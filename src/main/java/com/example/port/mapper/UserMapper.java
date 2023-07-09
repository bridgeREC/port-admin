package com.example.port.mapper;

import com.example.port.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author 陈键樑
 * @since 2023-03-02
 */
@RestController
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
