package com.icbc.distributed.accinfo.controller;

import java.util.Arrays;
import java.util.Map;


import com.icbc.distributed.accinfo.feign.FClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.icbc.distributed.accinfo.entity.AccInfoTableEntity;
import com.icbc.distributed.accinfo.service.*;
import com.icbc.common.utils.PageUtils;
import com.icbc.common.utils.R;



/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2020-07-20 20:31:15
 */
@RestController
@RequestMapping("accinfo/accinfotable")
public class AccInfoTableController {
    @Autowired
    private AccInfoTableService accInfoTableService;

    @Autowired
    FClient fClient;
    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = accInfoTableService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{accId}")
    public R info(@PathVariable("accId") Long accId){
		if(fClient.checkAcc(accId+"")){
		    return R.error(400, "wrong accId");
        }

        AccInfoTableEntity accInfoTable = accInfoTableService.getById(accId);

        return R.ok().put("accInfoTable", accInfoTable);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody AccInfoTableEntity accInfoTable){
		accInfoTableService.save(accInfoTable);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody AccInfoTableEntity accInfoTable){
		accInfoTableService.updateById(accInfoTable);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] accIds){

        accInfoTableService.removeByIds(Arrays.asList(accIds));

        return R.ok();
    }

}
