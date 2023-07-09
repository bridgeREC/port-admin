package com.example.port.mapper;

import com.example.port.entity.Release;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 陈键樑
 * @since 2023-03-02
 */
@RestController
@Mapper
public interface ReleaseMapper extends BaseMapper<Release> {

}
