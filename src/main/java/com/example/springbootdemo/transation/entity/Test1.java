package com.example.springbootdemo.transation.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("test_1")
public class Test1 {
    private int id;
    private String name;
}
