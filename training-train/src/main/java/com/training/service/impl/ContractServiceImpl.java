package com.training.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.training.dao.ContractDao;
import com.training.entity.ContractEntity;
import com.training.service.ContractService;

/**
 * 合同Service实现类
 *
 * @author tongchunbin
 * @email 1533961990@qq.com
 * @date 2018-04-09 22:17:43
 */
@Service("contractService")
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractDao contractDao;

    @Override
    public ContractEntity queryObject(Long id) {
        return contractDao.queryObject(id);
    }

    @Override
    public List<ContractEntity> queryList(Map<String, Object> map) {
        return contractDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return contractDao.queryTotal(map);
    }

    @Override
    public int save(ContractEntity contract) {
        return contractDao.save(contract);
    }

    @Override
    public int update(ContractEntity contract) {
        return contractDao.update(contract);
    }

    @Override
    public int delete(Long id) {
        return contractDao.delete(id);
    }

    @Override
    public int deleteBatch(Long[]ids) {
        return contractDao.deleteBatch(ids);
    }
}
