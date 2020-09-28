package com.example.druidmybatis.controller;

import com.example.druidmybatis.entity.SdfsFile;
import com.example.druidmybatis.mapper.FileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private FileMapper fileMapper;
    @GetMapping("/test")
    SdfsFile test(){
        SdfsFile file = fileMapper.SelectById(596660321903923200L);
        return file;
    }
}
