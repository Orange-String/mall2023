package com.ddq.ddqmall.coupon.dao;

import com.ddq.ddqmall.coupon.entity.CouponHistoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券领取历史记录
 * 
 * @author ddd
 * @email ddd@gmail.com
 * @date 2023-05-01 15:01:53
 */
@Mapper
public interface CouponHistoryDao extends BaseMapper<CouponHistoryEntity> {
	
}
