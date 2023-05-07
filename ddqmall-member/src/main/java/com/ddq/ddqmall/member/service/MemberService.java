package com.ddq.ddqmall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ddq.common.utils.PageUtils;
import com.ddq.ddqmall.member.entity.MemberEntity;

import java.util.Map;

/**
 * 会员
 *
 * @author ddd
 * @email ddd@gmail.com
 * @date 2023-03-15 22:31:40
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

