package com.fifth.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.fifth.common.Result;
import com.fifth.domain.Course;
import com.fifth.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/****
 * @Author:Anonym
 * @Description:
 * @Date 2021/11/26 00:00
 *****/

@RestController
@RequestMapping("/course")
@CrossOrigin
public class CourseController {

    @Autowired
    private CourseMapper courseMapper;

    /**
     * 根据用户查询Course 分页查询
     *
     * @param role
     * @param username
     * @return
     */
    @GetMapping("/{role}/{username}")
    public Result selectCourseList(@PathVariable("role") Integer role,
                                   @PathVariable("username") String username) {
        List<Course> courseList = null;

        if (StringUtils.isEmpty(role) || StringUtils.isEmpty(username)) return Result.error("-1", "系统暂时繁忙,请稍后重试");
        if (1 == role) courseList = courseMapper.stuCourseList(username);
        if (2 == role) courseList = courseMapper.teachCourseList(username);

        return Result.success(courseList);
    }

    /***
     * 根据ID删除
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable Integer id) {
        //调用courseMapper实现根据主键删除
        if (courseMapper.deleteById(id) > 0) return Result.success();
        return Result.error("-1", "删除失败");
    }

    /***
     * 修改Course数据
     * @param course
     * @param id
     * @return
     */
    @PutMapping(value = "/{id}")
    public Result update(@RequestBody Course course, @PathVariable Integer id) {
        //调用courseMapper实现修改Course
        if (courseMapper.update(course, new UpdateWrapper<Course>().eq("id", id)) > 0) return Result.success();
        return Result.error("-1", "修改失败");
    }

    /***
     * 新增Course数据
     * @param course
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Course course) {
        //调用courseMapper实现添加Course
        if (courseMapper.insert(course) > 0) return Result.success();
        return Result.error("-1", "新增失败");
    }

    /***
     * 根据ID查询Course数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<Course> findById(@PathVariable Integer id) {
        //调用courseMapper实现根据主键查询Course
        Course course = courseMapper.selectById(id);
        return Result.success(course);
    }

    /***
     * 查询Course全部数据
     * @return
     */
    @GetMapping
    public Result<List<Course>> findAll() {
        //调用courseMapper实现查询所有Course
        List<Course> list = courseMapper.selectList(null);
        return Result.success(list);
    }
}
