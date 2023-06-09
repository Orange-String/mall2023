package com.ddq.ddqmall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ddq.common.utils.PageUtils;
import com.ddq.ddqmall.product.entity.SkuSaleAttrValueEntity;

import java.util.Map;

/**
 * sku销售属性&值
 *
 * @author ddd
 * @email ddd@gmail.com
 * @date 2023-03-15 21:11:04
 */
public interface SkuSaleAttrValueService extends IService<SkuSaleAttrValueEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

