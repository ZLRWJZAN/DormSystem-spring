package com.ps.dorm.service.impl;

import com.ps.dorm.domain.DormDo;
import com.ps.dorm.mapper.DormMapper;
import com.ps.dorm.service.DormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 作者：ZLRWJSAN
 * 创建于 2019/6/10 20:51
 */
@Service
public class DormServiceImpl implements DormService {
    @Autowired
    private DormMapper dormMapper;

    @Override
    public void add(DormDo dormDo) {
        dormMapper.dormInsert(dormDo);
    }

    @Override
    public void update(DormDo dormDo) {
        dormMapper.dormUpdate(dormDo);
    }

    @Override
    public void delete(DormDo dormDo) {
        dormMapper.dormDelete(dormDo);
    }

    @Override
    public List<DormDo> query() {
        return dormMapper.dormSelect();
    }
}
