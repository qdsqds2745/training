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

import com.training.entity.ContractEntity;
import com.training.service.ContractService;
import com.training.utils.PageUtils;
import com.training.utils.Query;
import com.training.utils.R;

/**
 * 合同Controller
 *
 * @author tongchunbin
 * @email 1533961990@qq.com
 * @date 2018-04-09 22:17:43
 */
@Controller
@RequestMapping("contract")
public class ContractController {
    @Autowired
    private ContractService contractService;

    /**
     * 查看列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("contract:list")
    @ResponseBody
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<ContractEntity> contractList = contractService.queryList(query);
        int total = contractService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(contractList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("contract:info")
    @ResponseBody
    public R info(@PathVariable("id") Long id) {
        ContractEntity contract = contractService.queryObject(id);

        return R.ok().put("contract", contract);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("contract:save")
    @ResponseBody
    public R save(@RequestBody ContractEntity contract) {
        contractService.save(contract);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("contract:update")
    @ResponseBody
    public R update(@RequestBody ContractEntity contract) {
        contractService.update(contract);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("contract:delete")
    @ResponseBody
    public R delete(@RequestBody Long[]ids) {
        contractService.deleteBatch(ids);

        return R.ok();
    }

    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<ContractEntity> list = contractService.queryList(params);

        return R.ok().put("list", list);
    }
}
