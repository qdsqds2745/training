package com.training.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.training.dao.GradeDao;
import com.training.entity.GradeEntity;
import com.training.service.GradeService;

/**
 * Service实现类
 *
 * @author tongchunbin
 * @email 1533961990@qq.com
 * @date 2018-04-09 22:17:43
 */
@Service("gradeService")
public class GradeServiceImpl implements GradeService {
    @Autowired
    private GradeDao gradeDao;

    @Override
    public GradeEntity queryObject(Integer id) {
        return gradeDao.queryObject(id);
    }

    @Override
    public List<GradeEntity> queryList(Map<String, Object> map) {
        return gradeDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return gradeDao.queryTotal(map);
    }

    @Override
    public int save(GradeEntity grade) {
        return gradeDao.save(grade);
    }

    @Override
    public int update(GradeEntity grade) {
        return gradeDao.update(grade);
    }

    @Override
    public int delete(Integer id) {
        return gradeDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[]ids) {
        return gradeDao.deleteBatch(ids);
    }
}
