package com.example.port.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author 陈键樑
 * @since 2023-03-02
 */
@Data
@Slf4j
@TableName("user")
@EqualsAndHashCode(callSuper = false)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户昵称
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户电话号码
     */
    private Integer userphone;

    /**
     * 姓名
     */
    private String realname;

    /**
     * 所属船只
     */
    private Integer usership;

    /**
     * 角色ID
     */
    private Integer roleid;

    /**
     * 审核状态
     */
    private Integer reviewstatus;

    /**
     * 逻辑删除标记
     */
    @TableLogic
    private Boolean deleted;


}
