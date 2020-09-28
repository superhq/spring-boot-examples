package com.example.druid.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.sql.Timestamp;
import java.util.Date;

@Data
@ToString
@Setter
//这里有一个问题，不能加有参构造方法。加了之后查询回来的数据，会直接用有参构造方法赋值，
//构造方法中的参数顺序不一定与查询结果一致。这里有可能是Mybatis plus的Bug.
//@AllArgsConstructor
@NoArgsConstructor
@TableName("sdfs_file")
public class SdfsFile {
    @TableId
    private Long file_id;
    private Long file_size;
    private String file_type;

    private Integer state;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date create_time;
    private String file_digest;

    private Integer store_id;
}
