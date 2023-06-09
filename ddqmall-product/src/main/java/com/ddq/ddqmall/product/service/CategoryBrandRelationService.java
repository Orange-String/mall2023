package com.ddq.ddqmall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ddq.common.utils.PageUtils;
import com.ddq.ddqmall.product.entity.CategoryBrandRelationEntity;

import java.util.Map;

/**
 * 品牌分类关联
 *
 * @author ddd
 * @email ddd@gmail.com
 * @date 2023-05-01 14:49:04
 */
public interface CategoryBrandRelationService extends IService<CategoryBrandRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveDetail(CategoryBrandRelationEntity categoryBrandRelation);

    void updateBrand(Long brandId, String name);

    void updateCategory(Long catId, String name);
}

