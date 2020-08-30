package com.icbc.distributed.accinfo.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.icbc.common.utils.PageUtils;
import com.icbc.common.utils.Query;

import com.icbc.distributed.accinfo.dao.AccIntTableDao;
import com.icbc.distributed.accinfo.entity.AccIntTableEntity;
import com.icbc.distributed.accinfo.service.AccIntTableService;


@Service("accIntTableService")
public class AccIntTableServiceImpl extends ServiceImpl<AccIntTableDao, AccIntTableEntity> implements AccIntTableService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AccIntTableEntity> page = this.page(
                new Query<AccIntTableEntity>().getPage(params),
                new QueryWrapper<AccIntTableEntity>()
        );

        return new PageUtils(page);
    }

}