package com.example.port.service.impl;

import com.example.port.mapper.ShipMapper;
import com.example.port.entity.Ships;
import com.example.port.service.IShipService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


/**
 * <p>
 * 船舶表 服务实现类
 * </p>
 *
 * @author 陈键樑
 * @since 2023-03-02
 */
@Service
public class ShipServiceImpl extends ServiceImpl<ShipMapper, Ships> implements IShipService {

}
