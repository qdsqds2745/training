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

import com.training.entity.ClassTypeEntity;
import com.training.service.ClassTypeService;
import com.training.utils.PageUtils;
import com.training.utils.Query;
import com.training.utils.R;

/**
 * 班级种类Controller
 *
 * @author tongchunbin
 * @email 1533961990@qq.com
 * @date 2018-03-20 09:51:04
 */
@Controller
@RequestMapping("classtype")
public class ClassTypeController {
    @Autowired
    private ClassTypeService classTypeService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("classtype:list")
    @ResponseBody
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<ClassTypeEntity> classTypeList = classTypeService.queryList(query);
        int total = classTypeService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(classTypeList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("classtype:info")
    @ResponseBody
    public R info(@PathVariable("id") Long id) {
        ClassTypeEntity classType = classTypeService.queryObject(id);

        return R.ok().put("classType", classType);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("classtype:save")
    @ResponseBody
    public R save(@RequestBody ClassTypeEntity classType) {
        classTypeService.save(classType);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("classtype:update")
    @ResponseBody
    public R update(@RequestBody ClassTypeEntity classType) {
        classTypeService.update(classType);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("classtype:delete")
    @ResponseBody
    public R delete(@RequestBody Long[]ids) {
        classTypeService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<ClassTypeEntity> list = classTypeService.queryList(params);

        return R.ok().put("list", list);
    }
}
