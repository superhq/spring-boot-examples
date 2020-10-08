package com.example.druidmybatis.mapper;

import com.example.druidmybatis.entity.SdfsFile;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface FileMapper {
   @Select("SELECT * FROM sdfs_file WHERE file_id=#{id}")
    SdfsFile SelectById(Long id);
   @Insert("INSERT INTO sdfs_file(file_id,file_size,file_digest) VALUES(#{file_id},#{file_size},#{file_digest})")
    void InsertFile(SdfsFile file);
}
