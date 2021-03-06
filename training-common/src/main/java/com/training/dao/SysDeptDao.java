package com.training.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.training.entity.SysDeptEntity;
import com.training.entity.UserWindowDto;

/**
 * 部门管理
 *
 * @author liepngjun
 * @email 939961241@qq.com
 * @date 2017-09-17 23:58:47
 */
@Mapper
public interface SysDeptDao extends BaseDao<SysDeptEntity> {

    /**
     * 查询子部门ID列表
     *
     * @param parentId 上级部门ID
     */
    List<Long> queryDetpIdList(Long parentId);


    /**
     * 根据实体条件查询
     * @return
     */
    List<UserWindowDto> queryPageByDto(UserWindowDto userWindowDto);
}
