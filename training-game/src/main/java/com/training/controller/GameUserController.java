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

import com.training.entity.GameUserEntity;
import com.training.service.GameUserService;
import com.training.utils.PageUtils;
import com.training.utils.Query;
import com.training.utils.R;

/**
 * Controller
 *
 * @author tongchunbin
 * @email 1533961990@qq.com
 * @date 2018-04-09 22:17:43
 */
@Controller
@RequestMapping("gameuser")
public class GameUserController {
    @Autowired
    private GameUserService gameUserService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("gameuser:list")
    @ResponseBody
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<GameUserEntity> gameUserList = gameUserService.queryList(query);
        int total = gameUserService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(gameUserList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("gameuser:info")
    @ResponseBody
    public R info(@PathVariable("id") Long id) {
        GameUserEntity gameUser = gameUserService.queryObject(id);

        return R.ok().put("gameUser", gameUser);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("gameuser:save")
    @ResponseBody
    public R save(@RequestBody GameUserEntity gameUser) {
        gameUserService.save(gameUser);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("gameuser:update")
    @ResponseBody
    public R update(@RequestBody GameUserEntity gameUser) {
        gameUserService.update(gameUser);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("gameuser:delete")
    @ResponseBody
    public R delete(@RequestBody Long[]ids) {
        gameUserService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<GameUserEntity> list = gameUserService.queryList(params);

        return R.ok().put("list", list);
    }
}
