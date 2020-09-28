package com.example.druidmybatis.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;


import java.util.Date;

@Data
@ToString
@Setter

@NoArgsConstructor

public class SdfsFile {
    private Long file_id;
    private Long file_size;
    private String file_type;
    private Integer state;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date create_time;
    private String file_digest;
    private Integer store_id;
}
