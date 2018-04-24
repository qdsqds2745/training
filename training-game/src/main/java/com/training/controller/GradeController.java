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

import com.training.entity.GradeEntity;
import com.training.service.GradeService;
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
@RequestMapping("grade")
public class GradeController {
    @Autowired
    private GradeService gradeService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("grade:list")
    @ResponseBody
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<GradeEntity> gradeList = gradeService.queryList(query);
        int total = gradeService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(gradeList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("grade:info")
    @ResponseBody
    public R info(@PathVariable("id") Integer id) {
        GradeEntity grade = gradeService.queryObject(id);

        return R.ok().put("grade", grade);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("grade:save")
    @ResponseBody
    public R save(@RequestBody GradeEntity grade) {
        gradeService.save(grade);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("grade:update")
    @ResponseBody
    public R update(@RequestBody GradeEntity grade) {
        gradeService.update(grade);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("grade:delete")
    @ResponseBody
    public R delete(@RequestBody Integer[]ids) {
        gradeService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<GradeEntity> list = gradeService.queryList(params);

        return R.ok().put("list", list);
    }
}
