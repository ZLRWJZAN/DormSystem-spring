package com.ps.dorm.service;

import com.ps.dorm.domain.StudentDo;

import java.util.List;

/**
 * 作者：ZLRWJSAN
 * 创建于 2019/6/10 22:01
 */
public interface StudentService {
    void add(StudentDo studentDo);
    void update(StudentDo studentDo);
    void delete(StudentDo studentDo);
    List<StudentDo> query();
}
