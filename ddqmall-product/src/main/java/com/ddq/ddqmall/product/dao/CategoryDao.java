package com.ddq.ddqmall.product.dao;

import com.ddq.ddqmall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author ddd
 * @email ddd@gmail.com
 * @date 2023-03-15 21:11:04
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
