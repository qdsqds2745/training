package com.training.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.training.dao.BilingDao;
import com.training.entity.BilingEntity;
import com.training.service.BilingService;

/**
 * 计费方式表Service实现类
 *
 * @author tongchunbin
 * @email 1533961990@qq.com
 * @date 2018-03-20 09:51:04
 */
@Service("bilingService")
public class BilingServiceImpl implements BilingService {
    @Autowired
    private BilingDao bilingDao;

    @Override
    public BilingEntity queryObject(Integer bilingId) {
        return bilingDao.queryObject(bilingId);
    }

    @Override
    public List<BilingEntity> queryList(Map<String, Object> map) {
        return bilingDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return bilingDao.queryTotal(map);
    }

    @Override
    public int save(BilingEntity biling) {
        return bilingDao.save(biling);
    }

    @Override
    public int update(BilingEntity biling) {
        return bilingDao.update(biling);
    }

    @Override
    public int delete(Integer bilingId) {
        return bilingDao.delete(bilingId);
    }

    @Override
    public int deleteBatch(Integer[]bilingIds) {
        return bilingDao.deleteBatch(bilingIds);
    }
}
