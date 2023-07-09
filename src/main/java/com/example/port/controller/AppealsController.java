package com.example.port.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.port.entity.Appeals;
import com.example.port.entity.User;
import com.example.port.service.IAppealsServices;
import com.example.port.service.IUserService;
import com.example.port.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
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
@RequestMapping("/appeals")
public class AppealsController {
    SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Autowired
    private IAppealsServices appealsService;

    @Autowired
    private IUserService userService;

    @GetMapping("/page")
    public Result<?> getPage(@RequestParam(value = "pageShipid",required = false) String shipid,
                             @RequestParam(value = "pageUserid",required = false) String userid,
                             @RequestParam(value = "pageStatus",required = false) String status,
                             @RequestParam(defaultValue = "1")Integer pageNum,
                             @RequestParam(defaultValue = "4")Integer pageSize){

        LambdaQueryWrapper<Appeals> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StringUtils.hasLength(shipid),Appeals::getShipid,shipid);
        wrapper.like(StringUtils.hasLength(userid),Appeals::getUserid,userid);
        wrapper.like(StringUtils.hasLength(status),Appeals::getStatus,status);

        Page<Appeals> page = new Page<>(pageNum,pageSize);
        appealsService.page(page,wrapper);

        Map<String,Object> data = new HashMap<>();
        data.put("total",page.getTotal());
        data.put("list",page.getRecords());
        data.put("pageNum", pageNum);
        data.put("pageSize", pageSize);
        return Result.success(data);
    }


    @PostMapping
    public Result<?> addAppeals(@RequestBody Appeals appeals){
        appeals.setUserid(userService.getloginUser().getId());
        appeals.setShipid(userService.getloginUser().getUsership());
        appeals.setCreatedat(sdf.format(System.currentTimeMillis()));
        appeals.setStatus(0);
        appealsService.save(appeals);
        return Result.success("新增申述成功");
    }

    @PutMapping
    public Result<?> updateAppeals(@RequestBody Appeals appeals){
        appealsService.updateById(appeals);
        return Result.success("修改申述成功");
    }

    @GetMapping("/{id}")
    public Result<Appeals> getAppeals(@PathVariable("id") Integer id){
        Appeals appeals = appealsService.getById(id);
        return Result.success(appeals);
    }

    @DeleteMapping("/{id}")
    public Result<Appeals> deleteAppeals(@PathVariable("id") Integer id){
        appealsService.removeById(id);
        return Result.success("删除申述成功");
    }

}


