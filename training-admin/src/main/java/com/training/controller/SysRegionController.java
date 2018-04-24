package com.training.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.cache.RegionCacheUtil;
import com.training.entity.SysRegionEntity;
import com.training.service.SysRegionService;
import com.training.utils.PageUtils;
import com.training.utils.Query;
import com.training.utils.R;
import com.training.utils.TreeUtils;

/**
 * Controller
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-11-04 11:19:31
 */
@RestController
@RequestMapping("sys/region")
public class SysRegionController {
    @Autowired
    private SysRegionService sysRegionService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:region:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<SysRegionEntity> regionList = sysRegionService.queryList(query);
        int total = sysRegionService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(regionList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }


    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:region:info")
    public R info(@PathVariable("id") Integer id) {
        SysRegionEntity region = sysRegionService.queryObject(id);

        return R.ok().put("region", region);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:region:save")
    public R save(@RequestBody SysRegionEntity region) {
        sysRegionService.save(region);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:region:update")
    public R update(@RequestBody SysRegionEntity region) {
        sysRegionService.update(region);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:region:delete")
    public R delete(@RequestBody Integer[] ids) {
        sysRegionService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查询所有国家
     *
     * @return
     */
    @RequestMapping("/getAllCountry")
    public R getAllCountry() {
        List<SysRegionEntity> list = RegionCacheUtil.getAllCountry();
        return R.ok().put("list", list);
    }

    /**
     * 查询所有省份
     *
     * @return
     */
    @RequestMapping("/getAllProvice")
    public R getAllProvice(@RequestParam(required = false) Integer areaId) {
        List<SysRegionEntity> list = RegionCacheUtil.getAllProviceByParentId(areaId);
        return R.ok().put("list", list);
    }

    /**
     * 查询所有城市
     *
     * @return
     */
    @RequestMapping("/getAllCity")
    public R getAllCity(@RequestParam(required = false) Integer areaId) {
        List<SysRegionEntity> list = RegionCacheUtil.getChildrenCity(areaId);
        return R.ok().put("list", list);
    }


    /**
     * 查询所有区县
     *
     * @return
     */
    @RequestMapping("/getChildrenDistrict")
    public R getChildrenDistrict(@RequestParam(required = false) Integer areaId) {
        List<SysRegionEntity> list = RegionCacheUtil.getChildrenDistrict(areaId);
        return R.ok().put("list", list);
    }

    /**
     * 查看信息(全部加载页面渲染太慢！)
     */
    @RequestMapping("/getAreaTree")
    public R getAreaTree() {
        List<SysRegionEntity> list = RegionCacheUtil.sysRegionEntityList;
        for (SysRegionEntity sysRegionEntity : list) {
            sysRegionEntity.setValue(sysRegionEntity.getId() + "");
            sysRegionEntity.setLabel(sysRegionEntity.getName());
        }
        List<SysRegionEntity> node = TreeUtils.factorTree(list);

        return R.ok().put("node", node);
    }

    @RequestMapping("/getAreaByType")
    public R getAreaByType(@RequestParam(required = false) Integer type) {

        List<SysRegionEntity> list = new ArrayList<>();
        if (type.equals(0)) {

        } else if (type.equals(1)) {//省份
            list = RegionCacheUtil.getAllCountry();
        } else if (type.equals(2)) {
            list = RegionCacheUtil.getAllProvice();
        } else if (type.equals(3)) {
            list = RegionCacheUtil.getAllCity();
        }
        return R.ok().put("list", list);
    }
}
