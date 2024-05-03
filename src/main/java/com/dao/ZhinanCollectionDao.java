package com.dao;

import com.entity.ZhinanCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhinanCollectionView;

/**
 * 指南收藏 Dao 接口
 *
 * @author 
 */
public interface ZhinanCollectionDao extends BaseMapper<ZhinanCollectionEntity> {

   List<ZhinanCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
