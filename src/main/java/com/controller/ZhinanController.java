
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 防范指南
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/zhinan")
public class ZhinanController {
    private static final Logger logger = LoggerFactory.getLogger(ZhinanController.class);

    private static final String TABLE_NAME = "zhinan";

    @Autowired
    private ZhinanService zhinanService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private LiuyanService liuyanService;//留言板
    @Autowired
    private NewsService newsService;//社区公告
    @Autowired
    private YishengService yishengService;//医生
    @Autowired
    private YishengChatService yishengChatService;//用户咨询
    @Autowired
    private YishengCollectionService yishengCollectionService;//医生收藏
    @Autowired
    private YishengCommentbackService yishengCommentbackService;//医生评价
    @Autowired
    private YishengYuyueService yishengYuyueService;//挂号
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private ZhinanCollectionService zhinanCollectionService;//指南收藏
    @Autowired
    private ZhinanLiuyanService zhinanLiuyanService;//指南留言
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("医生".equals(role))
            params.put("yishengId",request.getSession().getAttribute("userId"));
        params.put("zhinanDeleteStart",1);params.put("zhinanDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = zhinanService.queryPage(params);

        //字典表数据转换
        List<ZhinanView> list =(List<ZhinanView>)page.getList();
        for(ZhinanView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZhinanEntity zhinan = zhinanService.selectById(id);
        if(zhinan !=null){
            //entity转view
            ZhinanView view = new ZhinanView();
            BeanUtils.copyProperties( zhinan , view );//把实体数据重构到view中
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ZhinanEntity zhinan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zhinan:{}",this.getClass().getName(),zhinan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ZhinanEntity> queryWrapper = new EntityWrapper<ZhinanEntity>()
            .eq("zhinan_name", zhinan.getZhinanName())
            .eq("zhinan_video", zhinan.getZhinanVideo())
            .eq("zhinan_types", zhinan.getZhinanTypes())
            .eq("zan_number", zhinan.getZanNumber())
            .eq("cai_number", zhinan.getCaiNumber())
            .eq("zhinan_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhinanEntity zhinanEntity = zhinanService.selectOne(queryWrapper);
        if(zhinanEntity==null){
            zhinan.setZhinanClicknum(1);
            zhinan.setZhinanDelete(1);
            zhinan.setInsertTime(new Date());
            zhinan.setCreateTime(new Date());
            zhinanService.insert(zhinan);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZhinanEntity zhinan, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,zhinan:{}",this.getClass().getName(),zhinan.toString());
        ZhinanEntity oldZhinanEntity = zhinanService.selectById(zhinan.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(zhinan.getZhinanPhoto()) || "null".equals(zhinan.getZhinanPhoto())){
                zhinan.setZhinanPhoto(null);
        }
        if("".equals(zhinan.getZhinanVideo()) || "null".equals(zhinan.getZhinanVideo())){
                zhinan.setZhinanVideo(null);
        }

            zhinanService.updateById(zhinan);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ZhinanEntity> oldZhinanList =zhinanService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<ZhinanEntity> list = new ArrayList<>();
        for(Integer id:ids){
            ZhinanEntity zhinanEntity = new ZhinanEntity();
            zhinanEntity.setId(id);
            zhinanEntity.setZhinanDelete(2);
            list.add(zhinanEntity);
        }
        if(list != null && list.size() >0){
            zhinanService.updateBatchById(list);
        }

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<ZhinanEntity> zhinanList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ZhinanEntity zhinanEntity = new ZhinanEntity();
//                            zhinanEntity.setZhinanUuidNumber(data.get(0));                    //指南编号 要改的
//                            zhinanEntity.setZhinanName(data.get(0));                    //指南标题 要改的
//                            zhinanEntity.setZhinanPhoto("");//详情和图片
//                            zhinanEntity.setZhinanVideo(data.get(0));                    //指南视频 要改的
//                            zhinanEntity.setZhinanTypes(Integer.valueOf(data.get(0)));   //指南类型 要改的
//                            zhinanEntity.setZhinanClicknum(Integer.valueOf(data.get(0)));   //指南热度 要改的
//                            zhinanEntity.setZanNumber(Integer.valueOf(data.get(0)));   //赞 要改的
//                            zhinanEntity.setCaiNumber(Integer.valueOf(data.get(0)));   //踩 要改的
//                            zhinanEntity.setZhinanContent("");//详情和图片
//                            zhinanEntity.setZhinanDelete(1);//逻辑删除字段
//                            zhinanEntity.setInsertTime(date);//时间
//                            zhinanEntity.setCreateTime(date);//时间
                            zhinanList.add(zhinanEntity);


                            //把要查询是否重复的字段放入map中
                                //指南编号
                                if(seachFields.containsKey("zhinanUuidNumber")){
                                    List<String> zhinanUuidNumber = seachFields.get("zhinanUuidNumber");
                                    zhinanUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> zhinanUuidNumber = new ArrayList<>();
                                    zhinanUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("zhinanUuidNumber",zhinanUuidNumber);
                                }
                        }

                        //查询是否重复
                         //指南编号
                        List<ZhinanEntity> zhinanEntities_zhinanUuidNumber = zhinanService.selectList(new EntityWrapper<ZhinanEntity>().in("zhinan_uuid_number", seachFields.get("zhinanUuidNumber")).eq("zhinan_delete", 1));
                        if(zhinanEntities_zhinanUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ZhinanEntity s:zhinanEntities_zhinanUuidNumber){
                                repeatFields.add(s.getZhinanUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [指南编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        zhinanService.insertBatch(zhinanList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }



    /**
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<ZhinanView> returnZhinanViewList = new ArrayList<>();

        //查看收藏
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        PageUtils pageUtils = zhinanCollectionService.queryPage(params1);
        List<ZhinanCollectionView> collectionViewsList =(List<ZhinanCollectionView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(ZhinanCollectionView collectionView:collectionViewsList){
            Integer zhinanTypes = collectionView.getZhinanTypes();
            if(typeMap.containsKey(zhinanTypes)){
                typeMap.put(zhinanTypes,typeMap.get(zhinanTypes)+1);
            }else{
                typeMap.put(zhinanTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("zhinanTypes",type);
            PageUtils pageUtils1 = zhinanService.queryPage(params2);
            List<ZhinanView> zhinanViewList =(List<ZhinanView>)pageUtils1.getList();
            returnZhinanViewList.addAll(zhinanViewList);
            if(returnZhinanViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = zhinanService.queryPage(params);
        if(returnZhinanViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnZhinanViewList.size();//要添加的数量
            List<ZhinanView> zhinanViewList =(List<ZhinanView>)page.getList();
            for(ZhinanView zhinanView:zhinanViewList){
                Boolean addFlag = true;
                for(ZhinanView returnZhinanView:returnZhinanViewList){
                    if(returnZhinanView.getId().intValue() ==zhinanView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnZhinanViewList.add(zhinanView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnZhinanViewList = returnZhinanViewList.subList(0, limit);
        }

        for(ZhinanView c:returnZhinanViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnZhinanViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = zhinanService.queryPage(params);

        //字典表数据转换
        List<ZhinanView> list =(List<ZhinanView>)page.getList();
        for(ZhinanView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZhinanEntity zhinan = zhinanService.selectById(id);
            if(zhinan !=null){

                //点击数量加1
                zhinan.setZhinanClicknum(zhinan.getZhinanClicknum()+1);
                zhinanService.updateById(zhinan);

                //entity转view
                ZhinanView view = new ZhinanView();
                BeanUtils.copyProperties( zhinan , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody ZhinanEntity zhinan, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,zhinan:{}",this.getClass().getName(),zhinan.toString());
        Wrapper<ZhinanEntity> queryWrapper = new EntityWrapper<ZhinanEntity>()
            .eq("zhinan_uuid_number", zhinan.getZhinanUuidNumber())
            .eq("zhinan_name", zhinan.getZhinanName())
            .eq("zhinan_video", zhinan.getZhinanVideo())
            .eq("zhinan_types", zhinan.getZhinanTypes())
            .eq("zhinan_clicknum", zhinan.getZhinanClicknum())
            .eq("zan_number", zhinan.getZanNumber())
            .eq("cai_number", zhinan.getCaiNumber())
            .eq("zhinan_delete", zhinan.getZhinanDelete())
//            .notIn("zhinan_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhinanEntity zhinanEntity = zhinanService.selectOne(queryWrapper);
        if(zhinanEntity==null){
            zhinan.setZhinanClicknum(1);
                zhinan.setZanNumber(1);
                zhinan.setCaiNumber(1);
            zhinan.setZhinanDelete(1);
            zhinan.setInsertTime(new Date());
            zhinan.setCreateTime(new Date());
        zhinanService.insert(zhinan);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

