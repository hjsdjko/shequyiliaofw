package com.service.impl;

import com.utils.StringUtil;
import com.service.DictionaryService;
import com.utils.ClazzDiff;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import com.dao.ZhinanLiuyanDao;
import com.entity.ZhinanLiuyanEntity;
import com.service.ZhinanLiuyanService;
import com.entity.view.ZhinanLiuyanView;

/**
 * 指南留言 服务实现类
 */
@Service("zhinanLiuyanService")
@Transactional
public class ZhinanLiuyanServiceImpl extends ServiceImpl<ZhinanLiuyanDao, ZhinanLiuyanEntity> implements ZhinanLiuyanService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<ZhinanLiuyanView> page =new Query<ZhinanLiuyanView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
