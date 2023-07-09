package com.example.port.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.port.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author 陈键樑
 * @since 2023-03-02
 */
public interface IUserService extends IService<User> {
    Map<String, Object> login(User user);

    Map<String, Object> getUserInfo(String token);

    User getloginUser();
}
