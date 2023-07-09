package com.example.port.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.port.entity.Announcement;
import com.example.port.service.IAnnouncementService;
import com.example.port.service.IUserService;
import com.example.port.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 公告表 前端控制器
 * </p>
 *
 * @author 陈键樑
 * @since 2023-03-02
 */
@RestController
@RequestMapping("/announcement")
public class AnnouncementController {
    SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Autowired
    private IAnnouncementService announcementService;
    @Autowired
    private IUserService userService;
    @GetMapping("/page")
    public Result<?> getPage(@RequestParam(value = "pageTitle",required = false) String title,
                             @RequestParam(value = "pageAuthor",required = false) String author,
                             @RequestParam(defaultValue = "1")Integer pageNum,
                             @RequestParam(defaultValue = "4")Integer pageSize){

        LambdaQueryWrapper<Announcement> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StringUtils.hasLength(title),Announcement::getTitle,title);
        wrapper.like(StringUtils.hasLength(author),Announcement::getAuthor,author);

        Page<Announcement> page = new Page<>(pageNum,pageSize);
        announcementService.page(page,wrapper);

        Map<String,Object> data = new HashMap<>();
        data.put("total",page.getTotal());
        data.put("list",page.getRecords());
        data.put("pageNum", pageNum);
        data.put("pageSize", pageSize);
        return Result.success(data);
    }

    @PostMapping
    public Result<?> addAnnouncement(@RequestBody Announcement Announcement){
        Announcement.setAuthor(userService.getloginUser().getRealname());
        Announcement.setCreatetime(sdf.format(System.currentTimeMillis()));
        announcementService.save(Announcement);
        return Result.success("新增公告成功");
    }

    @PutMapping
    public Result<?> updateAnnouncement(@RequestBody Announcement Announcement){
        announcementService.updateById(Announcement);
        return Result.success("修改公告成功");
    }

    @GetMapping("/{id}")
    public Result<Announcement> getAnnouncement(@PathVariable("id") Integer id){
        Announcement Announcement = announcementService.getById(id);
        return Result.success(Announcement);
    }

    @DeleteMapping("/{id}")
    public Result<Announcement> deleteAnnouncement(@PathVariable("id") Integer id){
        announcementService.removeById(id);
        return Result.success("删除公告成功");
    }

}

