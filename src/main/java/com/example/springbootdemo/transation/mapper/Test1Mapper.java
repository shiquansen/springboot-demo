package com.example.springbootdemo.transation.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootdemo.transation.entity.Test1;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

@Mapper
public interface Test1Mapper extends BaseMapper<Test1> {
}
