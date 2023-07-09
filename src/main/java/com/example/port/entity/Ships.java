package com.example.port.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * <p>
 * 船舶表
 * </p>
 *
 * @author 陈键樑
 * @since 2023-03-03
 */
@Data
@Slf4j
@TableName("ships")
@EqualsAndHashCode(callSuper = false)
public class Ships implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 船名
     */
    private String name;

    /**
     * 船型
     */
    private String shiptype;

    /**
     * 船长
     */
    private Float length;

    /**
     * 吃水深度
     */
    private Float draft;

    /**
     * 吨位
     */
    private Float tonnage;

    /**
     * 船长姓名
     */
    private String captainname;

    /**
     * 船东姓名
     */
    private String ownername;

    /**
     * 用户ID
     */
    private Integer userid;

    /**
     * 审核状态
     */
    private Integer reviewstatus;

    /**
     * 逻辑删除标记
     */
    private Boolean deleted;
}
