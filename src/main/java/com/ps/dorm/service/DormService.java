package com.ps.dorm.service;

import com.ps.dorm.domain.DormDo;

import java.util.List;

/**
 * 作者：ZLRWJSAN
 * 创建于 2019/6/10 20:51
 */

public interface DormService {
    void add(DormDo dormDo);
    void update(DormDo dormDo);
    void delete(DormDo dormDo);
    List<DormDo> query();
}
