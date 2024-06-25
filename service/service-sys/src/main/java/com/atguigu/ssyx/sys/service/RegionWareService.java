package com.atguigu.ssyx.sys.service;

import com.atguigu.ssyx.model.sys.RegionWare;
import com.atguigu.ssyx.vo.sys.RegionWareQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * ClassName: RegionWareService
 * Package: com.atguigu.ssyx.sys.service
 */
public interface RegionWareService extends IService<RegionWare> {

    //开通区域列表
    IPage<RegionWare> selectPage(Page<RegionWare> pageParam,
                                 RegionWareQueryVo regionWareQueryVo);

    //添加开通区域
    void saveRegionWare(RegionWare regionWare);
}
