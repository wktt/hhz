package com.hhz.springboot.dao;

import com.hhz.springboot.bean.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Select("select * from student")
    public List<Student> getAllStudent();
}
