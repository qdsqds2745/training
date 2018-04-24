package com.training.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.training.dao.MemberDao;
import com.training.entity.MemberEntity;
import com.training.service.MemberService;

/**
 * 会员Service实现类
 *
 * @author tongchunbin
 * @email 1533961990@qq.com
 * @date 2018-04-09 22:17:43
 */
@Service("memberService")
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberDao memberDao;

    @Override
    public MemberEntity queryObject(Long id) {
        return memberDao.queryObject(id);
    }

    @Override
    public List<MemberEntity> queryList(Map<String, Object> map) {
        return memberDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return memberDao.queryTotal(map);
    }

    @Override
    public int save(MemberEntity member) {
        return memberDao.save(member);
    }

    @Override
    public int update(MemberEntity member) {
        return memberDao.update(member);
    }

    @Override
    public int delete(Long id) {
        return memberDao.delete(id);
    }

    @Override
    public int deleteBatch(Long[]ids) {
        return memberDao.deleteBatch(ids);
    }
}
