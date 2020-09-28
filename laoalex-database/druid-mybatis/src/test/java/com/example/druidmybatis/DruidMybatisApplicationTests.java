package com.example.druidmybatis;

import com.example.druidmybatis.entity.SdfsFile;
import com.example.druidmybatis.mapper.FileMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DruidMybatisApplicationTests {
    @Autowired
    private FileMapper fileMapper;
    @Test
    void contextLoads() {
    }
    @Test
    void testSelectById(){
        SdfsFile file = fileMapper.SelectById(596660321903923200L);
        System.out.println(file);
    }

}
