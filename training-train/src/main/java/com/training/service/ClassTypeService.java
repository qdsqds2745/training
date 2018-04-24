package com.training.service;

import com.training.entity.ClassTypeEntity;

import java.util.List;
import java.util.Map;

/**
 * 班级种类Service接口
 *
 * @author tongchunbin
 * @email 1533961990@qq.com
 * @date 2018-03-20 09:51:04
 */
public interface ClassTypeService {

    /**
     * 根据主键查询实体
     *
     * @param id 主键
     * @return 实体
     */
    ClassTypeEntity queryObject(Long id);

    /**
     * 分页查询
     *
     * @param map 参数
     * @return list
     */
    List<ClassTypeEntity> queryList(Map<String, Object> map);

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
     * @param classType 实体
     * @return 保存条数
     */
    int save(ClassTypeEntity classType);

    /**
     * 根据主键更新实体
     *
     * @param classType 实体
     * @return 更新条数
     */
    int update(ClassTypeEntity classType);

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
