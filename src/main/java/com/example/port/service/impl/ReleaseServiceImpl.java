package com.example.port.service.impl;

import com.example.port.entity.Release;
import com.example.port.mapper.ReleaseMapper;
import com.example.port.service.IReleaseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  放行表服务实现类
 * </p>
 *
 * @author 陈键樑
 * @since 2023-03-02
 */
@Service
public class ReleaseServiceImpl extends ServiceImpl<ReleaseMapper, Release> implements IReleaseService {
}
