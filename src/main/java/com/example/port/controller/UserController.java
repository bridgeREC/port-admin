package com.example.port.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.port.mapper.UserMapper;
import com.example.port.entity.User;
import com.example.port.utils.Result;
import com.example.port.service.IUserService;
import com.example.port.utils.JwtUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author 陈键樑
 * @since 2023-03-02
 */
@RestController
@RequestMapping("/user")
//@CrossOrigin
public class UserController {
    @Autowired
    private IUserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public Result<Map<String,Object>> login(@RequestBody User user){
        Map<String,Object> data = userService.login(user);
        if (data != null) {
            return Result.success(data);
        }
        return Result.fail(20002,"用户名或密码错误");
    }

    @GetMapping("/info")
    public Result getUserInfo(@RequestParam("token") String token) {
        Map<String,Object> data = userService.getUserInfo(token);
        if(data != null){
            return Result.success(data);
        }
        return Result.fail(20003,"登录信息无效，请重新登录");
    }


    @GetMapping("/page")
    public Result<?> getPage(@RequestParam(value = "pageusername",required = false) String username,
                             @RequestParam(value = "pageuserrealname",required = false) String realname,
                             @RequestParam(value = "pageusership",required = false) String usership,
                             @RequestParam(value = "pageuserreviewstatus",required = false) String userreviewstatus,
                             @RequestParam(defaultValue = "1")Integer pageNum,
                             @RequestParam(defaultValue = "4")Integer pageSize){

        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StringUtils.hasLength(username),User::getUsername,username);
        wrapper.like(StringUtils.hasLength(realname),User::getRealname,realname);
        wrapper.like(StringUtils.hasLength(usership),User::getUsership,usership);
        wrapper.like(StringUtils.hasLength(userreviewstatus),User::getReviewstatus,userreviewstatus);
        wrapper.eq(User::getRoleid , 3);

        Page<User> page = new Page<>(pageNum,pageSize);
        userService.page(page,wrapper);

        Map<String,Object> data = new HashMap<>();
        data.put("total",page.getTotal());
        data.put("list",page.getRecords());
        data.put("pageNum", pageNum);
        data.put("pageSize", pageSize);
        return Result.success(data);
    }

    @PostMapping
    public Result<?> addUser(@RequestBody User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoleid(3);
        userService.save(user);
        return Result.success("新增用户成功");
    }

    @PutMapping
    public Result<?> updateUser(@RequestBody User user){
        userService.updateById(user);
        return Result.success("修改用户成功");
    }

    @GetMapping("/{id}")
    public Result<User> getUserById(@PathVariable("id") Integer id){
        User user = userService.getById(id);
        return Result.success(user);
    }

    @DeleteMapping("/{id}")
    public Result<User> deleteUserById(@PathVariable("id") Integer id){
        userService.removeById(id);
        return Result.success("删除用户成功");
    }

    @PostMapping("/logout")
    public Result logout(){
        return Result.success("成功登出");
    }

}