package com.example.springbootdemo.transation.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("test_2")
public class Test2 {
    private int id;
    private String name;
}
