package com.ecommerce.shops.mapper;

import com.ecommerce.shops.bean.ZbTongji;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ZbTongjiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ZbTongji record);

    int insertSelective(ZbTongji record);

    ZbTongji selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ZbTongji record);

    int updateByPrimaryKey(ZbTongji record);

    int getTotalCount();

    List<ZbTongji> findPageData(@Param("start")Integer start, @Param("limit")Integer limit);
}