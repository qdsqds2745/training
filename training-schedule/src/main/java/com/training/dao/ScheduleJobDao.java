package com.training.dao;

import java.util.Map;

import com.training.entity.ScheduleJobEntity;

/**
 * 定时任务
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2016年12月1日 下午10:29:57
 */
public interface ScheduleJobDao extends BaseDao<ScheduleJobEntity> {

    /**
     * 批量更新状态
     */
    int updateBatch(Map<String, Object> map);
}
