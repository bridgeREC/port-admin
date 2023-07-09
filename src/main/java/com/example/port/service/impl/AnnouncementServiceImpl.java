package com.example.port.service.impl;

import com.example.port.entity.Announcement;
import com.example.port.mapper.AnnouncementMapper;
import com.example.port.service.IAnnouncementService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 公告表 服务实现类
 * </p>
 *
 * @author 陈键樑
 * @since 2023-03-02
 */
@Service
public class AnnouncementServiceImpl extends ServiceImpl<AnnouncementMapper, Announcement> implements IAnnouncementService {

}
