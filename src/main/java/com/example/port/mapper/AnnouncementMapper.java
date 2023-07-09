package com.example.port.mapper;

import com.example.port.entity.Announcement;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 公告表 Mapper 接口
 * </p>
 *
 * @author 陈键樑
 * @since 2023-03-02
 */
@RestController
@Mapper
public interface AnnouncementMapper extends BaseMapper<Announcement> {

}
