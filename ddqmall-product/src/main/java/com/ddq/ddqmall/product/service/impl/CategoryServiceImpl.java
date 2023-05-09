package com.ddq.ddqmall.product.service.impl;

import com.ddq.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ddq.common.utils.PageUtils;
import com.ddq.common.utils.Query;

import com.ddq.ddqmall.product.dao.CategoryDao;
import com.ddq.ddqmall.product.entity.CategoryEntity;
import com.ddq.ddqmall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        //1.查出所有分类
        List<CategoryEntity> entities = baseMapper.selectList(null);

        //2.组装成父子树形结构
        //2.1 找到所有的一级分类
        List<CategoryEntity> levelOne = entities.stream()
                .filter(categoryEntity -> categoryEntity.getParentCid() == 0)
                .map(menu -> {
                    menu.setChildren(getChildrens(menu, entities));
                    return menu;
                })
                .sorted(Comparator.comparingInt(menu -> (menu.getSort() == null ? 0 : menu.getSort())))
                .collect(Collectors.toList());
        return levelOne;
    }

    @Override
    public R removeMenuByIds(List<Long> asList) {
        //TODO 检查当前删除菜单是否被其他地方引用
        baseMapper.deleteBatchIds(asList);
        return R.ok();
    }

    //递归查找所有菜单的子菜单
    private List<CategoryEntity> getChildrens(CategoryEntity categoryEntity, List<CategoryEntity> categoryEntityList) {
        List<CategoryEntity> collect = categoryEntityList.stream()
                .filter(category -> category.getParentCid() == categoryEntity.getCatId())
                .map(category -> {
                    category.setChildren(getChildrens(category, categoryEntityList));
                    return category;
                })
                .sorted(Comparator.comparingInt(menu -> (menu.getSort() == null ? 0 : menu.getSort())))
                .collect(Collectors.toList());
        return collect;
    }
}