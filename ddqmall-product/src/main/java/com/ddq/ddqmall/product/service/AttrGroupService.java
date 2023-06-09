package com.ddq.ddqmall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ddq.common.utils.PageUtils;
import com.ddq.ddqmall.product.entity.AttrGroupEntity;
import com.ddq.ddqmall.product.vo.AttrGroupRelationVo;

import java.util.Map;

/**
 * 属性分组
 *
 * @author ddd
 * @email ddd@gmail.com
 * @date 2023-05-01 14:49:04
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryPage(Map<String, Object> params, Long catelogId);

    void deleteRelation(AttrGroupRelationVo[] relationVos);
}

