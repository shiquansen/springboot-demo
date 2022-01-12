package com.example.springbootdemo.transation.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootdemo.transation.entity.Test1;
import com.example.springbootdemo.transation.entity.Test2;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Test2Mapper extends BaseMapper<Test2> {
}
