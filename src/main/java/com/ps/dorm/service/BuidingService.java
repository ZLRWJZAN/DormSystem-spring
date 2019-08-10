package com.ps.dorm.service;

import com.ps.dorm.domain.BuidingDo;
import com.ps.dorm.domain.DormDo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 作者：ZLRWJSAN
 * 创建于 2019/6/10 16:57
 */

public interface BuidingService {
    void add(BuidingDo buidingDo);
    void update(BuidingDo buidingDo);
    void delete(BuidingDo buidingDo);
    List<BuidingDo> query();
    List<DormDo> queryId(DormDo dormDo);
}
