package com.ddq.ddqmall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ddq.common.utils.PageUtils;
import com.ddq.ddqmall.product.entity.AttrEntity;
import com.ddq.ddqmall.product.vo.AttrResponseVo;
import com.ddq.ddqmall.product.vo.AttrVo;

import java.util.List;
import java.util.Map;

/**
 * 商品属性
 *
 * @author ddd
 * @email ddd@gmail.com
 * @date 2023-05-01 14:49:04
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveAttr(AttrVo attr);

    PageUtils queryBaseAttrPage(Map<String, Object> params, Long catelogId, String type);

    AttrResponseVo getAttrInfo(Long attrId);

    void updateAttr(AttrVo attr);

    List<AttrEntity> getRelationAttr(Long attrGroupId);

    PageUtils getNoRelationAttr(Map<String, Object> params, Long attrGroupId);
}

