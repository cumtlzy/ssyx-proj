package com.atguigu.ssyx.sys.service.impl;

import com.atguigu.ssyx.model.sys.Ware;
import com.atguigu.ssyx.sys.mapper.WareMapper;
import com.atguigu.ssyx.sys.service.WareService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * ClassName: WareServiceImpl
 * Package: com.atguigu.ssyx.sys.service.impl
 */

@Service
public class WareServiceImpl extends ServiceImpl<WareMapper, Ware> implements WareService {
}
