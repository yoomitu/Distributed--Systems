package com.icbc.distributed.interest.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.icbc.common.utils.PageUtils;
import com.icbc.distributed.interest.entity.AccIntTableEntity;

import java.util.Map;

/**
 * 
 *
 * @author ${author}
 * @email ${email}
 * @date 2020-07-20 20:45:08
 */
public interface AccIntTableService extends IService<AccIntTableEntity> {

    PageUtils queryPage(Map<String, Object> params);
}
