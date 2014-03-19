package com.thinkjoy.open.service.impl;

import com.thinkjoy.open.domain.Sc;
import com.thinkjoy.open.mapper.ScMapper;
import com.thinkjoy.open.service.ScService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mac on 14-2-21.
 */
@Service
public class ScServiceImpl implements ScService {

    @Autowired
    private ScMapper scMapper;

    @Override
    public List<Sc> findAll(String studentId) {
        List<Sc> studentAll = scMapper.selectAll();
        return studentAll;
    }
}
