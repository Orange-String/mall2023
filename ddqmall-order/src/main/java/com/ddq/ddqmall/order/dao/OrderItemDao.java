package com.ddq.ddqmall.order.dao;

import com.ddq.ddqmall.order.entity.OrderItemEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单项信息
 * 
 * @author ddd
 * @email ddd@gmail.com
 * @date 2023-05-01 15:11:39
 */
@Mapper
public interface OrderItemDao extends BaseMapper<OrderItemEntity> {
	
}
