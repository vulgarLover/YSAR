package com.ysar.module.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ysar.module.user.domain.entity.UserEntity;
import com.ysar.module.user.mapper.UserEntityMapper;
import com.ysar.module.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author shenwei
 * @since 2019-09-05
 */
public class UserServiceImpl extends ServiceImpl<UserEntityMapper, UserEntity> implements UserService {
    @Autowired
    private UserEntityMapper userEntityMapper;
}
