package com.example.myspringbootswagger.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
@ApiModel(value = "User",description = "用户实体")
public class User {
    @ApiModelProperty("用户ID")
    private String id;
    @ApiModelProperty("用户名")
    private String name;
    @ApiModelProperty("用户年龄")
    private int age;
}
