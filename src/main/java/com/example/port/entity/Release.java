package com.example.port.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableLogic;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 
 * </p>
 *
 * @author 陈键樑
 * @since 2023-03-02
 */
@Data
@Slf4j
@TableName("releases")
@EqualsAndHashCode(callSuper = false)
public class Release implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 船舶ID
     */
    private String shipid;

    /**
     * 操作员ID
     */
    private Integer operatorid;

    /**
     * 放行时间
     */
    private String releasetime;

    /**
     * 放行类型：0：未放行 1：入港放行，2：出港放行
     */
    private Integer clearancetype;

    /**
     * 放行备注
     */
    private String clearanceremark;

    /**
     * 逻辑删除
     */
    @TableLogic
    private Integer deleted;


}
