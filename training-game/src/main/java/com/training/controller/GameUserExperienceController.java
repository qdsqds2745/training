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

import com.training.entity.GameUserExperienceEntity;
import com.training.service.GameUserExperienceService;
import com.training.utils.PageUtils;
import com.training.utils.Query;
import com.training.utils.R;

/**
 * 用户经验Controller
 *
 * @author tongchunbin
 * @email 1533961990@qq.com
 * @date 2018-04-09 22:17:44
 */
@Controller
@RequestMapping("gameuserexperience")
public class GameUserExperienceController {
    @Autowired
    private GameUserExperienceService gameUserExperienceService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("gameuserexperience:list")
    @ResponseBody
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<GameUserExperienceEntity> gameUserExperienceList = gameUserExperienceService.queryList(query);
        int total = gameUserExperienceService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(gameUserExperienceList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("gameuserexperience:info")
    @ResponseBody
    public R info(@PathVariable("id") Long id) {
        GameUserExperienceEntity gameUserExperience = gameUserExperienceService.queryObject(id);

        return R.ok().put("gameUserExperience", gameUserExperience);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("gameuserexperience:save")
    @ResponseBody
    public R save(@RequestBody GameUserExperienceEntity gameUserExperience) {
        gameUserExperienceService.save(gameUserExperience);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("gameuserexperience:update")
    @ResponseBody
    public R update(@RequestBody GameUserExperienceEntity gameUserExperience) {
        gameUserExperienceService.update(gameUserExperience);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("gameuserexperience:delete")
    @ResponseBody
    public R delete(@RequestBody Long[]ids) {
        gameUserExperienceService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<GameUserExperienceEntity> list = gameUserExperienceService.queryList(params);

        return R.ok().put("list", list);
    }
}
