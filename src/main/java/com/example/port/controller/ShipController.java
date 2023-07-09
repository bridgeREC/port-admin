package com.example.port.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.port.entity.User;
import com.example.port.mapper.ShipMapper;
import com.example.port.entity.Ships;
import com.example.port.service.IShipService;
import com.example.port.service.IUserService;
import com.example.port.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 船舶表 前端控制器
 * </p>
 *
 * @author 陈键樑
 * @since 2023-03-02
 */
@RestController
@RequestMapping("/ship")
//@CrossOrigin
public class ShipController {
    @Autowired
    private IShipService shipService;

    @Autowired
    private IUserService userService;

    @GetMapping("/page")
    public Result<?> getPage(@RequestParam(value = "pageShipname",required = false) String name,
                             @RequestParam(value = "pageShiptype",required = false) String shiptype,
                             @RequestParam(value = "pageCaptainname",required = false) String captainname,
                             @RequestParam(value = "pageOwnername",required = false) String ownername,
                             @RequestParam(value = "pageLength",required = false) String length,
                             @RequestParam(value = "pageTonnage",required = false) String tonnage,
                             @RequestParam(value = "pageDraft",required = false) String draft,
                             @RequestParam(value = "pageReviewstatus",required = false) String reviewstatus,
                             @RequestParam(value = "pageUserid",required = false) String userid,
                             @RequestParam(defaultValue = "1")Integer pageNum,
                             @RequestParam(defaultValue = "4")Integer pageSize){

        LambdaQueryWrapper<Ships> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StringUtils.hasLength(name),Ships::getName,name);
        wrapper.like(StringUtils.hasLength(shiptype),Ships::getShiptype,shiptype);
        wrapper.like(StringUtils.hasLength(captainname),Ships::getCaptainname,captainname);
        wrapper.like(StringUtils.hasLength(ownername),Ships::getOwnername,ownername);
        wrapper.le(StringUtils.hasLength(length), Ships::getLength,length);
        wrapper.le(StringUtils.hasLength(tonnage),Ships::getTonnage,tonnage);
        wrapper.le(StringUtils.hasLength(draft),Ships::getDraft,draft);
        wrapper.eq(StringUtils.hasLength(reviewstatus),Ships::getReviewstatus,reviewstatus);
        wrapper.eq(StringUtils.hasLength(userid),Ships::getUserid,userid);

        Page<Ships> page = new Page<>(pageNum,pageSize);
        shipService.page(page,wrapper);

        Map<String,Object> data = new HashMap<>();
        data.put("total",page.getTotal());
        data.put("list",page.getRecords());
        data.put("pageNum", pageNum);
        data.put("pageSize", pageSize);
        return Result.success(data);
    }


    @PostMapping
    public Result<?> addShip(@RequestBody Ships ship){
        ship.setUserid(userService.getloginUser().getId());
        shipService.save(ship);
        return Result.success("新增船舶成功");
    }

    @PutMapping
    public Result<?> updateShip(@RequestBody Ships ship){
        ship.setUserid(userService.getloginUser().getId());
        shipService.updateById(ship);
        return Result.success("修改船舶成功");
    }

    @GetMapping("/{id}")
    public Result<Ships> getShip(@PathVariable("id") Integer id){
        Ships ship = shipService.getById(id);
        return Result.success(ship);
    }

    @DeleteMapping("/{id}")
    public Result<Ships> deleteShipById(@PathVariable("id") Integer id){
        shipService.removeById(id);
        return Result.success("删除船舶成功");
    }

}

