package com.ddq.ddqmall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ddq.common.utils.PageUtils;
import com.ddq.ddqmall.ware.entity.WareOrderTaskDetailEntity;

import java.util.Map;

/**
 * 库存工作单
 *
 * @author ddd
 * @email ddd@gmail.com
 * @date 2023-05-01 15:14:16
 */
public interface WareOrderTaskDetailService extends IService<WareOrderTaskDetailEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

