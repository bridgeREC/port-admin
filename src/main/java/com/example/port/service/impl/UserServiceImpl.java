package com.example.port.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.port.entity.User;
import com.example.port.mapper.UserMapper;
import com.example.port.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.port.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author 陈键樑
 * @since 2023-03-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    private User loginUser;

    public User getloginUser() {
        return loginUser;
    }

    @Override
    public Map<String, Object> login(User user) {
        // 根据用户名查询
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, user.getUsername());
        loginUser = this.baseMapper.selectOne(wrapper);

        // 结果不为空，并且密码和传入密码匹配，则生成token
        if (loginUser != null && passwordEncoder.matches(user.getPassword(), loginUser.getPassword()) && loginUser.getReviewstatus() != 0 && loginUser.getReviewstatus() != 2) {
            String token = JwtUtils.generateToken(loginUser.getUsername());
            loginUser.setPassword(null);
            // 返回数据
            Map<String, Object> data = new HashMap<>();
            data.put("token", token);
            return data;
        }
        return null;
    }

    @Override
    public Map<String, Object> getUserInfo(String token) {
        String[] roles;
        int Role = loginUser.getRoleid();
        Map<String, Object> data = new HashMap<>();
        if (Role == 1) {
            roles = new String[]{"root"};
            data.put("avatar", "https://i.postimg.cc/mD6nrBkh/6-HZJFLGV3-B9-C9-IO-N-QQM.jpg");
        } else {
            if (Role == 2) {
                roles = new String[]{"admin"};
                data.put("avatar", "https://i.postimg.cc/3NVztYQz/D-F-C-8-UA2-G-I-R.jpg");
            } else {
                roles = new String[]{"user"};
                data.put("avatar", "https://i.postimg.cc/76DHN1nS/S5-V6850-JHTCI0-E-H-Y.jpg");
            }
        }
        data.put("name", loginUser.getRealname());
        data.put("roles", roles);
        return data;
    }
}
