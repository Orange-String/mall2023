package com.ddq.ddqmall.product.service.impl;

import com.ddq.ddqmall.product.dao.AttrAttrgroupRelationDao;
import com.ddq.ddqmall.product.entity.AttrAttrgroupRelationEntity;
import com.ddq.ddqmall.product.vo.AttrGroupRelationVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ddq.common.utils.PageUtils;
import com.ddq.common.utils.Query;

import com.ddq.ddqmall.product.dao.AttrGroupDao;
import com.ddq.ddqmall.product.entity.AttrGroupEntity;
import com.ddq.ddqmall.product.service.AttrGroupService;
import org.springframework.util.StringUtils;


@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupDao, AttrGroupEntity> implements AttrGroupService {

    @Autowired
    private AttrAttrgroupRelationDao attrAttrgroupRelationDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrGroupEntity> page = this.page(
                new Query<AttrGroupEntity>().getPage(params),
                new QueryWrapper<AttrGroupEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Long catelogId) {
        //select * from pms_attr_group where catelog_id = ? and (attr_group_id = key or like "%key%")
        String key = (String) params.get("key");
        QueryWrapper<AttrGroupEntity> attrGroupEntityQueryWrapper = new QueryWrapper<>();
        if (StringUtils.hasText(key)) {
            attrGroupEntityQueryWrapper.and(obj -> {
                obj.eq("attr_group_id", key)
                        .or()
                        .like("attr_group_name", key);
            });
        }
        if (catelogId == 0) {
            IPage<AttrGroupEntity> page = this.page(new Query<AttrGroupEntity>().getPage(params), attrGroupEntityQueryWrapper);
            return new PageUtils(page);
        } else {
            attrGroupEntityQueryWrapper.eq("catelog_id", catelogId);
            IPage<AttrGroupEntity> page = this.page(new Query<AttrGroupEntity>().getPage(params), attrGroupEntityQueryWrapper);
            return new PageUtils(page);
        }
    }

    @Override
    public void deleteRelation(AttrGroupRelationVo[] relationVos) {
//        attrAttrgroupRelationDao.delete(new QueryWrapper<AttrAttrgroupRelationEntity>().eq("attr_id",1L)
//                .eq("attr_group_id",1L));
        List<AttrAttrgroupRelationEntity> attrgroupRelationEntities = Arrays.asList(relationVos).stream().map(item -> {
            AttrAttrgroupRelationEntity attrAttrgroupRelationEntity = new AttrAttrgroupRelationEntity();
            BeanUtils.copyProperties(item, attrAttrgroupRelationEntity);
            return attrAttrgroupRelationEntity;
        }).collect(Collectors.toList());
        //自定义方法进行批量删除
        attrAttrgroupRelationDao.deleteBatchRelation(attrgroupRelationEntities);
    }
}