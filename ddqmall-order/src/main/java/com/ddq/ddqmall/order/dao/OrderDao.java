package com.ddq.ddqmall.order.dao;

import com.ddq.ddqmall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author ddd
 * @email ddd@gmail.com
 * @date 2023-05-01 15:11:39
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
