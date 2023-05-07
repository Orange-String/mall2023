package com.ddq.ddqmall.member.dao;

import com.ddq.ddqmall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author ddd
 * @email ddd@gmail.com
 * @date 2023-03-15 22:31:40
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
