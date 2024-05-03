package com.dao;

import com.entity.ZhinanLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhinanLiuyanView;

/**
 * 指南留言 Dao 接口
 *
 * @author 
 */
public interface ZhinanLiuyanDao extends BaseMapper<ZhinanLiuyanEntity> {

   List<ZhinanLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
