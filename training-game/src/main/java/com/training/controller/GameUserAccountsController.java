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

import com.training.entity.GameUserAccountsEntity;
import com.training.service.GameUserAccountsService;
import com.training.utils.PageUtils;
import com.training.utils.Query;
import com.training.utils.R;

/**
 * 用户账户Controller
 *
 * @author tongchunbin
 * @email 1533961990@qq.com
 * @date 2018-04-09 22:17:44
 */
@Controller
@RequestMapping("gameuseraccounts")
public class GameUserAccountsController {
    @Autowired
    private GameUserAccountsService gameUserAccountsService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("gameuseraccounts:list")
    @ResponseBody
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<GameUserAccountsEntity> gameUserAccountsList = gameUserAccountsService.queryList(query);
        int total = gameUserAccountsService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(gameUserAccountsList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("gameuseraccounts:info")
    @ResponseBody
    public R info(@PathVariable("id") Long id) {
        GameUserAccountsEntity gameUserAccounts = gameUserAccountsService.queryObject(id);

        return R.ok().put("gameUserAccounts", gameUserAccounts);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("gameuseraccounts:save")
    @ResponseBody
    public R save(@RequestBody GameUserAccountsEntity gameUserAccounts) {
        gameUserAccountsService.save(gameUserAccounts);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("gameuseraccounts:update")
    @ResponseBody
    public R update(@RequestBody GameUserAccountsEntity gameUserAccounts) {
        gameUserAccountsService.update(gameUserAccounts);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("gameuseraccounts:delete")
    @ResponseBody
    public R delete(@RequestBody Long[]ids) {
        gameUserAccountsService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<GameUserAccountsEntity> list = gameUserAccountsService.queryList(params);

        return R.ok().put("list", list);
    }
}
