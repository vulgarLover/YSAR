package com.ysar.module.user.service;

import com.ysar.module.user.domain.entity.UserEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author shenwei
 * @since 2019-09-05
 */
public interface UserService extends IService<UserEntity> {
    List<UserEntity> findAll();
}
