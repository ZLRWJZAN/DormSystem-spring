package com.ps.dorm.service.impl;

import com.ps.dorm.annotation.Cache;
import com.ps.dorm.annotation.ShowLog;
import com.ps.dorm.domain.BuidingDo;
import com.ps.dorm.domain.DormDo;
import com.ps.dorm.mapper.BuildingMapper;
import com.ps.dorm.service.BuidingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 作者：ZLRWJSAN
 * 创建于 2019/6/10 16:57
 */
@Service
public class BuidingServiceImpl implements BuidingService {
    @Autowired
    private BuildingMapper buildingMapper;

    @Override
    @ShowLog
    public void add(BuidingDo buidingDo){
        buildingMapper.buidInsert(buidingDo);
    }

    @Override
    public void update(BuidingDo buidingDo){
        buildingMapper.buidUpdate(buidingDo);
    }

    @Override
    public void delete(BuidingDo buidingDo){
        buildingMapper.buidDelete(buidingDo);
    }

    @Override
    @Cache(time = 5)
    public List<BuidingDo> query(){
        return buildingMapper.buidSelect();
    }

    @Override
    public List<DormDo> queryId(DormDo dormDo){
        return buildingMapper.buidSelectId(dormDo);
    }

}
