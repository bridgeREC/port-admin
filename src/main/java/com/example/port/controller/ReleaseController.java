package com.example.port.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.port.entity.Release;
import com.example.port.entity.Ships;
import com.example.port.service.IReleaseService;
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
 *  前端控制器
 * </p>
 *
 * @author 陈键樑
 * @since 2023-03-02
 */
@RestController
@RequestMapping("/release")
public class ReleaseController {
    @Autowired
    private IReleaseService releaseService;

    @Autowired
    private IUserService userService;

    @GetMapping("/page")
    public Result<?> getPage(@RequestParam(value = "pageShipid",required = false) String shipid,
                             @RequestParam(value = "pageOperatorid",required = false) String operatorid,
                             @RequestParam(value = "pageClearancetype",required = false) String clearancetype,
                             @RequestParam(defaultValue = "1")Integer pageNum,
                             @RequestParam(defaultValue = "4")Integer pageSize){

        LambdaQueryWrapper<Release> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StringUtils.hasLength(shipid),Release::getShipid,shipid);
        wrapper.like(StringUtils.hasLength(operatorid),Release::getOperatorid,operatorid);
        wrapper.like(StringUtils.hasLength(clearancetype),Release::getClearancetype,clearancetype);

        Page<Release> page = new Page<>(pageNum,pageSize);
        releaseService.page(page,wrapper);

        Map<String,Object> data = new HashMap<>();
        data.put("total",page.getTotal());
        data.put("list",page.getRecords());
        data.put("pageNum", pageNum);
        data.put("pageSize", pageSize);
        return Result.success(data);
    }


    @PostMapping
    public Result<?> addRelease(@RequestBody Release release){
        release.setOperatorid(userService.getloginUser().getId());
        releaseService.save(release);
        return Result.success("新增放行成功");
    }

    @PutMapping
    public Result<?> updateRelease(@RequestBody Release release){
        releaseService.updateById(release);
        return Result.success("修改放行成功");
    }

    @GetMapping("/{id}")
    public Result<Release> getRelease(@PathVariable("id") Integer id){
        Release release = releaseService.getById(id);
        return Result.success(release);
    }

    @DeleteMapping("/{id}")
    public Result<Release> deleteRelease(@PathVariable("id") Integer id){
        releaseService.removeById(id);
        return Result.success("删除放行成功");
    }

}

