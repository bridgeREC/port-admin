package com.example.port.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableLogic;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 公告表
 * </p>
 *
 * @author 陈键樑
 * @since 2023-03-02
 */
@Data
@TableName("announcement")
@EqualsAndHashCode(callSuper = false)
public class Announcement implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 公告标题
     */
    private String title;

    /**
     * 公告内容
     */
    private String content;

    /**
     * 创建时间
     */
    private String createtime;

    /**
     * 发布人
     */
    private String author;

    /**
     * 逻辑删除标记
     */
    @TableLogic
    private Boolean deleted;


}
