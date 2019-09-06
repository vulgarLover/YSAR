package com.ysar.module.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ysar.module.user.domain.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author shenwei
 * @since 2019-09-05
 */
@Repository
public interface UserEntityMapper extends BaseMapper<UserEntity> {

    List<UserEntity> findAll();
}
