package com.training.service;

import com.training.entity.GameUserExperienceEntity;

import java.util.List;
import java.util.Map;

/**
 * 用户经验Service接口
 *
 * @author tongchunbin
 * @email 1533961990@qq.com
 * @date 2018-04-09 22:17:44
 */
public interface GameUserExperienceService {

    /**
     * 根据主键查询实体
     *
     * @param id 主键
     * @return 实体
     */
    GameUserExperienceEntity queryObject(Long id);

    /**
     * 分页查询
     *
     * @param map 参数
     * @return list
     */
    List<GameUserExperienceEntity> queryList(Map<String, Object> map);

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
     * @param gameUserExperience 实体
     * @return 保存条数
     */
    int save(GameUserExperienceEntity gameUserExperience);

    /**
     * 根据主键更新实体
     *
     * @param gameUserExperience 实体
     * @return 更新条数
     */
    int update(GameUserExperienceEntity gameUserExperience);

    /**
     * 根据主键删除
     *
     * @param id
     * @return 删除条数
     */
    int delete(Long id);

    /**
     * 根据主键批量删除
     *
     * @param ids
     * @return 删除条数
     */
    int deleteBatch(Long[]ids);
}
