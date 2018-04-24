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

import com.training.entity.BilingEntity;
import com.training.service.BilingService;
import com.training.utils.PageUtils;
import com.training.utils.Query;
import com.training.utils.R;

/**
 * 计费方式表Controller
 *
 * @author tongchunbin
 * @email 1533961990@qq.com
 * @date 2018-03-20 09:51:04
 */
@Controller
@RequestMapping("biling")
public class BilingController {
    @Autowired
    private BilingService bilingService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("biling:list")
    @ResponseBody
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<BilingEntity> bilingList = bilingService.queryList(query);
        int total = bilingService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(bilingList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{bilingId}")
    @RequiresPermissions("biling:info")
    @ResponseBody
    public R info(@PathVariable("bilingId") Integer bilingId) {
        BilingEntity biling = bilingService.queryObject(bilingId);

        return R.ok().put("biling", biling);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("biling:save")
    @ResponseBody
    public R save(@RequestBody BilingEntity biling) {
        bilingService.save(biling);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("biling:update")
    @ResponseBody
    public R update(@RequestBody BilingEntity biling) {
        bilingService.update(biling);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("biling:delete")
    @ResponseBody
    public R delete(@RequestBody Integer[]bilingIds) {
        bilingService.deleteBatch(bilingIds);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<BilingEntity> list = bilingService.queryList(params);

        return R.ok().put("list", list);
    }
}
