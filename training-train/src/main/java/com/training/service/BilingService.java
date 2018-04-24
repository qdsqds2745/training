package com.training.service;

import com.training.entity.BilingEntity;

import java.util.List;
import java.util.Map;

/**
 * 计费方式表Service接口
 *
 * @author tongchunbin
 * @email 1533961990@qq.com
 * @date 2018-03-20 09:51:04
 */
public interface BilingService {

    /**
     * 根据主键查询实体
     *
     * @param id 主键
     * @return 实体
     */
    BilingEntity queryObject(Integer bilingId);

    /**
     * 分页查询
     *
     * @param map 参数
     * @return list
     */
    List<BilingEntity> queryList(Map<String, Object> map);

    /**
     * 分页统计总数
     *
     * @param map 参数
     * @return 总数
     */
    int queryTotal(Map<String, Object> map);

    /**
     * 保存实体
     *
     * @param biling 实体
     * @return 保存条数
     */
    int save(BilingEntity biling);

    /**
     * 根据主键更新实体
     *
     * @param biling 实体
     * @return 更新条数
     */
    int update(BilingEntity biling);

    /**
     * 根据主键删除
     *
     * @param bilingId
     * @return 删除条数
     */
    int delete(Integer bilingId);

    /**
     * 根据主键批量删除
     *
     * @param bilingIds
     * @return 删除条数
     */
    int deleteBatch(Integer[]bilingIds);
}
