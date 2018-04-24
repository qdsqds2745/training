package com.training.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.training.dao.ClassTypeDao;
import com.training.entity.ClassTypeEntity;
import com.training.service.ClassTypeService;

/**
 * 班级种类Service实现类
 *
 * @author tongchunbin
 * @email 1533961990@qq.com
 * @date 2018-03-20 09:51:04
 */
@Service("classTypeService")
public class ClassTypeServiceImpl implements ClassTypeService {
    @Autowired
    private ClassTypeDao classTypeDao;

    @Override
    public ClassTypeEntity queryObject(Long id) {
        return classTypeDao.queryObject(id);
    }

    @Override
    public List<ClassTypeEntity> queryList(Map<String, Object> map) {
        return classTypeDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return classTypeDao.queryTotal(map);
    }

    @Override
    public int save(ClassTypeEntity classType) {
        return classTypeDao.save(classType);
    }

    @Override
    public int update(ClassTypeEntity classType) {
        return classTypeDao.update(classType);
    }

    @Override
    public int delete(Long id) {
        return classTypeDao.delete(id);
    }

    @Override
    public int deleteBatch(Long[]ids) {
        return classTypeDao.deleteBatch(ids);
    }
}
