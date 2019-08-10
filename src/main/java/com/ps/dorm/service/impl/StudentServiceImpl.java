package com.ps.dorm.service.impl;

import com.ps.dorm.Utils.GetJoin;
import com.ps.dorm.domain.BuidingDo;
import com.ps.dorm.domain.StudentDo;
import com.ps.dorm.mapper.StuMapper;
import com.ps.dorm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 作者：ZLRWJSAN
 * 创建于 2019/6/10 22:01
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StuMapper stuMapper;

    @Override
    public void add(StudentDo studentDo) {
        stuMapper.stuInsert(studentDo);
    }

    @Override
    public void update(StudentDo studentDo) {
        stuMapper.stuUpdate(studentDo);
    }

    @Override
    public void delete(StudentDo studentDo) {
        stuMapper.stuDelete(studentDo);
    }

    @Override
    public List<StudentDo> query() {
        return stuMapper.stuSelect();
    }
}
