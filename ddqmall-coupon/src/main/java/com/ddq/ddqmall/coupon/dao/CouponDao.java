package com.ddq.ddqmall.coupon.dao;

import com.ddq.ddqmall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author ddd
 * @email ddd@gmail.com
 * @date 2023-05-01 15:01:52
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
