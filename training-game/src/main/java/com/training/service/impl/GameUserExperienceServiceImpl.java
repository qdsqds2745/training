package com.training.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.training.dao.GameUserExperienceDao;
import com.training.entity.GameUserExperienceEntity;
import com.training.service.GameUserExperienceService;

/**
 * 用户经验Service实现类
 *
 * @author tongchunbin
 * @email 1533961990@qq.com
 * @date 2018-04-09 22:17:44
 */
@Service("gameUserExperienceService")
public class GameUserExperienceServiceImpl implements GameUserExperienceService {
    @Autowired
    private GameUserExperienceDao gameUserExperienceDao;

    @Override
    public GameUserExperienceEntity queryObject(Long id) {
        return gameUserExperienceDao.queryObject(id);
    }

    @Override
    public List<GameUserExperienceEntity> queryList(Map<String, Object> map) {
        return gameUserExperienceDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return gameUserExperienceDao.queryTotal(map);
    }

    @Override
    public int save(GameUserExperienceEntity gameUserExperience) {
        return gameUserExperienceDao.save(gameUserExperience);
    }

    @Override
    public int update(GameUserExperienceEntity gameUserExperience) {
        return gameUserExperienceDao.update(gameUserExperience);
    }

    @Override
    public int delete(Long id) {
        return gameUserExperienceDao.delete(id);
    }

    @Override
    public int deleteBatch(Long[]ids) {
        return gameUserExperienceDao.deleteBatch(ids);
    }
}
