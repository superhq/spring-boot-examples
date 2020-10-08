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
    @Test
    void testInsertFile(){
        SdfsFile file = new SdfsFile();
        file.setFile_id(1L);
        file.setFile_size(0L);
        file.setFile_digest("test");
        fileMapper.InsertFile(file);
        Object o = new Object();
    }

}
