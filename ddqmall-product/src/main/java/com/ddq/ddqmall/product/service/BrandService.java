package com.ddq.ddqmall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ddq.common.utils.PageUtils;
import com.ddq.ddqmall.product.entity.BrandEntity;

import java.util.Map;

/**
 * 品牌
 *
 * @author ddd
 * @email ddd@gmail.com
 * @date 2023-03-15 21:11:04
 */
public interface BrandService extends IService<BrandEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

