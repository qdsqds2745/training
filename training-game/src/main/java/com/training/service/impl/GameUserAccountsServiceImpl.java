package com.training.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.training.dao.GameUserAccountsDao;
import com.training.entity.GameUserAccountsEntity;
import com.training.service.GameUserAccountsService;

/**
 * 用户账户Service实现类
 *
 * @author tongchunbin
 * @email 1533961990@qq.com
 * @date 2018-04-09 22:17:44
 */
@Service("gameUserAccountsService")
public class GameUserAccountsServiceImpl implements GameUserAccountsService {
    @Autowired
    private GameUserAccountsDao gameUserAccountsDao;

    @Override
    public GameUserAccountsEntity queryObject(Long id) {
        return gameUserAccountsDao.queryObject(id);
    }

    @Override
    public List<GameUserAccountsEntity> queryList(Map<String, Object> map) {
        return gameUserAccountsDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return gameUserAccountsDao.queryTotal(map);
    }

    @Override
    public int save(GameUserAccountsEntity gameUserAccounts) {
        return gameUserAccountsDao.save(gameUserAccounts);
    }

    @Override
    public int update(GameUserAccountsEntity gameUserAccounts) {
        return gameUserAccountsDao.update(gameUserAccounts);
    }

    @Override
    public int delete(Long id) {
        return gameUserAccountsDao.delete(id);
    }

    @Override
    public int deleteBatch(Long[]ids) {
        return gameUserAccountsDao.deleteBatch(ids);
    }
}
