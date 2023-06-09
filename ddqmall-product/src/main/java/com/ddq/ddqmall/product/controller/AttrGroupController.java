package com.ddq.ddqmall.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.ddq.ddqmall.product.entity.AttrEntity;
import com.ddq.ddqmall.product.service.AttrAttrgroupRelationService;
import com.ddq.ddqmall.product.service.AttrService;
import com.ddq.ddqmall.product.service.CategoryService;
import com.ddq.ddqmall.product.vo.AttrGroupRelationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ddq.ddqmall.product.entity.AttrGroupEntity;
import com.ddq.ddqmall.product.service.AttrGroupService;
import com.ddq.common.utils.PageUtils;
import com.ddq.common.utils.R;


/**
 * 属性分组
 *
 * @author ddd
 * @email ddd@gmail.com
 * @date 2023-05-01 14:49:04
 */
@RestController
@RequestMapping("product/attrgroup")
public class AttrGroupController {

    @Autowired
    private AttrGroupService attrGroupService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AttrService attrService;

    @Autowired
    private AttrAttrgroupRelationService attrAttrgroupRelationService;

    @PostMapping(value = "/attr/relation")
    public R addRelation(@RequestBody List<AttrGroupRelationVo> vos) {
        attrAttrgroupRelationService.saveBatch(vos);
        return R.ok();
    }

    @PostMapping(value = "/attr/relation/delete")
    public R deleteRelation(@RequestBody AttrGroupRelationVo[] relationVos) {
        attrGroupService.deleteRelation(relationVos);
        return R.ok();
    }

    @GetMapping(value = "{attrGroupId}/noattr/relation")
    public R attrNoRelation(@PathVariable(value = "attrGroupId") Long attrGroupId,
                            @RequestParam Map<String, Object> params) {
        PageUtils pageUtils = attrService.getNoRelationAttr(params, attrGroupId);
        return R.ok().put("page", pageUtils);
    }

    @GetMapping(value = "{attrGroupId}/attr/relation")
    public R attrRelation(@PathVariable(value = "attrGroupId") Long attrGroupId) {
        List<AttrEntity> entityList = attrService.getRelationAttr(attrGroupId);
        return R.ok().put("data", entityList);
    }

    /**
     * 列表
     */
    @RequestMapping("/list/{catelogId}")
    //@RequiresPermissions("product:attrgroup:list")
    public R list(@RequestParam Map<String, Object> params, @PathVariable(value = "catelogId") Long catelogId) {
        PageUtils page = attrGroupService.queryPage(params, catelogId);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrGroupId}")
    //@RequiresPermissions("product:attrgroup:info")
    public R info(@PathVariable("attrGroupId") Long attrGroupId) {
        AttrGroupEntity attrGroup = attrGroupService.getById(attrGroupId);
        Long catelogId = attrGroup.getCatelogId();
        Long[] path = categoryService.findCatelogPath(catelogId);
        attrGroup.setCatelogPath(path);
        return R.ok().put("attrGroup", attrGroup);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:attrgroup:save")
    public R save(@RequestBody AttrGroupEntity attrGroup) {
        attrGroupService.save(attrGroup);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:attrgroup:update")
    public R update(@RequestBody AttrGroupEntity attrGroup) {
        attrGroupService.updateById(attrGroup);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:attrgroup:delete")
    public R delete(@RequestBody Long[] attrGroupIds) {
        attrGroupService.removeByIds(Arrays.asList(attrGroupIds));

        return R.ok();
    }

}
