package com.example.port.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author 陈键樑
 * @since 2023-03-02
 */
@Data
@TableName("appeal")
@EqualsAndHashCode(callSuper = false)
public class Appeals implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 申诉船只的id
     */
    private Integer shipid;

    /**
     * 申诉用户的id
     */
    private Integer userid;

    /**
     * 申述内容
     */
    private String content;

    /**
     * 申诉状态
     */
    private int status;

    /**
     * 创建时间
     */
    private String createdat;

    /**
     * 逻辑删除标记
     */
    @TableLogic
    private Boolean deleted;

}
