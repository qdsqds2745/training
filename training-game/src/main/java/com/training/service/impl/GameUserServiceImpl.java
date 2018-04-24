package com.training.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.training.dao.GameUserDao;
import com.training.entity.GameUserEntity;
import com.training.service.GameUserService;

/**
 * Service实现类
 *
 * @author tongchunbin
 * @email 1533961990@qq.com
 * @date 2018-04-09 22:17:43
 */
@Service("gameUserService")
public class GameUserServiceImpl implements GameUserService {
    @Autowired
    private GameUserDao gameUserDao;

    @Override
    public GameUserEntity queryObject(Long id) {
        return gameUserDao.queryObject(id);
    }

    @Override
    public List<GameUserEntity> queryList(Map<String, Object> map) {
        return gameUserDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return gameUserDao.queryTotal(map);
    }

    @Override
    public int save(GameUserEntity gameUser) {
        return gameUserDao.save(gameUser);
    }

    @Override
    public int update(GameUserEntity gameUser) {
        return gameUserDao.update(gameUser);
    }

    @Override
    public int delete(Long id) {
        return gameUserDao.delete(id);
    }

    @Override
    public int deleteBatch(Long[]ids) {
        return gameUserDao.deleteBatch(ids);
    }
}
