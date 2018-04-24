package com.training.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.training.entity.MemberEntity;
import com.training.service.MemberService;
import com.training.utils.PageUtils;
import com.training.utils.Query;
import com.training.utils.R;

/**
 * 会员Controller
 *
 * @author tongchunbin
 * @email 1533961990@qq.com
 * @date 2018-04-09 22:17:43
 */
@Controller
@RequestMapping("member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("member:list")
    @ResponseBody
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<MemberEntity> memberList = memberService.queryList(query);
        int total = memberService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(memberList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("member:info")
    @ResponseBody
    public R info(@PathVariable("id") Long id) {
        MemberEntity member = memberService.queryObject(id);

        return R.ok().put("member", member);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("member:save")
    @ResponseBody
    public R save(@RequestBody MemberEntity member) {
        memberService.save(member);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("member:update")
    @ResponseBody
    public R update(@RequestBody MemberEntity member) {
        memberService.update(member);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("member:delete")
    @ResponseBody
    public R delete(@RequestBody Long[]ids) {
        memberService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<MemberEntity> list = memberService.queryList(params);

        return R.ok().put("list", list);
    }
}
