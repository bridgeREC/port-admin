package com.example.port.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.port.entity.Ships;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 船舶表 Mapper 接口
 * </p>
 *
 * @author 陈键樑
 * @since 2023-03-02
 */

@RestController
@Mapper
public interface ShipMapper extends BaseMapper<Ships> {
    Ships selectShipByShipid(@Param("shipid") int shipid);
}
