package com.ddq.ddqmall.product.service.impl;

import com.ddq.ddqmall.product.service.CategoryBrandRelationService;
import com.ddq.ddqmall.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ddq.common.utils.PageUtils;
import com.ddq.common.utils.Query;

import com.ddq.ddqmall.product.dao.BrandDao;
import com.ddq.ddqmall.product.entity.BrandEntity;
import com.ddq.ddqmall.product.service.BrandService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;


@Service("brandService")
public class BrandServiceImpl extends ServiceImpl<BrandDao, BrandEntity> implements BrandService {

    @Autowired
    private CategoryBrandRelationService categoryBrandRelationService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        //1.获取key
        String key = (String) params.get("key");

        QueryWrapper<BrandEntity> brandEntityQueryWrapper = new QueryWrapper<>();
        if (StringUtils.hasText(key)) {
            brandEntityQueryWrapper.eq("brand_id", key)
                    .or()
                    .like("name", key);
        }
        IPage<BrandEntity> page = this.page(
                new Query<BrandEntity>().getPage(params),
                brandEntityQueryWrapper);

        return new PageUtils(page);
    }

    @Transactional
    @Override
    public void updateDetail(BrandEntity brand) {
        //保证冗余字段的数据一致
        updateById(brand);
        if(StringUtils.hasText(brand.getName())) {
            //同步更新其他关联表中的数据
            categoryBrandRelationService.updateBrand(brand.getBrandId(),brand.getName());
            //TODO 更新其他关联表
        }
    }

}