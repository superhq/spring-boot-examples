package com.example.druidmybatis.mapper;

import com.example.druidmybatis.entity.SdfsFile;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface FileMapper {
   @Select("SELECT * FROM sdfs_file WHERE file_id=#{id}")
    SdfsFile SelectById(Long id);
}
