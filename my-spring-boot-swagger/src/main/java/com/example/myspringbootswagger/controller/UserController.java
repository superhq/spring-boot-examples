package com.example.myspringbootswagger.controller;

import com.example.myspringbootswagger.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api(tags = "用户相关接口")
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @ApiOperation("新增用户")
    @PostMapping("/add")
    public boolean add(@RequestBody User user) {
        return false;
    }

    @ApiOperation("查找用户")
    @GetMapping("/find/{id}")
    public User find(@PathVariable String id) {
        return new User();
    }

    @ApiOperation("更新用户")
    @PutMapping("/update")
    public boolean update(@RequestBody User user) {
        return true;
    }

    @ApiOperation("删除用户")
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id) {
        return true;
    }
}
