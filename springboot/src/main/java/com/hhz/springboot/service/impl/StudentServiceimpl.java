package com.hhz.springboot.service.impl;
import com.hhz.springboot.bean.Student;
import com.hhz.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import com.hhz.springboot.dao.StudentMapper;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceimpl implements StudentService{

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    public List<Student> getAllStudent(){
        List<Student> list = null;
        /**
         * 查询所有学生
         * 首先查看缓存中是否存在查找的数据
         * 若有则从缓存中取
         * 若没有则从数据库中取，并将数据加入到缓存中
         */
        boolean isExsit = redisTemplate.hasKey("student");
        if (isExsit){
            list =  (List<Student>) redisTemplate.opsForValue().get("student");
        }else{
            list = studentMapper.getAllStudent();
            redisTemplate.opsForValue().set("student",list);
        }
        return list;
    }
}
