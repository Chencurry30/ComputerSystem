package com.sicnu.boot.controller;


import com.github.pagehelper.PageInfo;
import com.sicnu.boot.pojo.Teacher;
import com.sicnu.boot.service.TeacherService;
import com.sicnu.boot.utils.ServerResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.validation.constraints.Min;
import java.util.List;

/**
 * description:
 *
 * @author 汪杨
 * @version 1.0
 * @date 2022/11/2
 */
@Slf4j
@RestController
@RequestMapping("/teachers")
@Validated
public class TeacherController {

    @Resource
    private TeacherService teacherService;
    @GetMapping("/{id}")
    public ServerResponse<Teacher> getTeacherById(@PathVariable("id") Integer id){
        return teacherService.getTeacherById(id);
    }

    @GetMapping("/pages/{directionId}-{pageNum}")
    ServerResponse<PageInfo<Teacher>> getTeacherPage(@PathVariable Integer directionId,
            @Min(value = 1,message = "pageNum的最小值为1") @PathVariable Integer pageNum){
        return teacherService.getTeacherPage(directionId,pageNum);
    }


    @GetMapping
    public ServerResponse<List<Teacher>> getAllTeacher(){
        return teacherService.getAllTeacher();
    }

    @PostMapping()
    ServerResponse<String> insertTeacher(@Validated
                                         @RequestBody Teacher teacher){
        return teacherService.insertTeacher(teacher);
    }


    @PutMapping
    ServerResponse<String> updateTeacher(@Validated
                                      @RequestBody Teacher teacher){
        return teacherService.updateTeacher(teacher);
    }

    @DeleteMapping("/{teacherId}")
    ServerResponse<String> deleteTeacherByTeacherId(@Min(value = 0,message = "id的最小值为1")
                                              @PathVariable Integer teacherId){
        return teacherService.deleteTeacherByTeacherId(teacherId);
    }


}
