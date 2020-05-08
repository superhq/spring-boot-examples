package com.oldalexdatabaseversioncontrol.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
    private long id;
    private String name;
    private int age;
}
