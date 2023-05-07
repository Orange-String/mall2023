package com.ddq.ddqmall.product.dao;

import com.ddq.ddqmall.product.entity.CommentReplayEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品评价回复关系
 * 
 * @author ddd
 * @email ddd@gmail.com
 * @date 2023-05-01 14:49:04
 */
@Mapper
public interface CommentReplayDao extends BaseMapper<CommentReplayEntity> {
	
}
