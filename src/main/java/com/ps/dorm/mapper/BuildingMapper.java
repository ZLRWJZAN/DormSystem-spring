package com.ps.dorm.mapper;

import com.ps.dorm.domain.BuidingDo;
import com.ps.dorm.domain.DormDo;

import java.util.List;

/**
 * 作者：ZLRWJSAN
 * 创建于 2019/6/15 11:13
 */
public interface BuildingMapper {
    void buidInsert(BuidingDo buidingDo);
    void buidUpdate(BuidingDo buidingDo);
    void buidDelete(BuidingDo buidingDo);
    List<BuidingDo> buidSelect();
    List<DormDo> buidSelectId(DormDo dormDo);

}
