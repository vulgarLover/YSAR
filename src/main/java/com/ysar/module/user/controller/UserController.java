package com.ysar.module.user.controller;


import com.ysar.module.user.domain.entity.UserEntity;
import com.ysar.module.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author shenwei
 * @since 2019-09-05
 */
@RestController
@Api(value = "用户管理API", tags = "用户管理API")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/findAll")
    @ApiOperation(value = "获取所有用户信息 @author shenwei", notes = "管理端分页查询意见反馈")
    public List<UserEntity> findAll() {
        return userService.findAll();
    }
}
