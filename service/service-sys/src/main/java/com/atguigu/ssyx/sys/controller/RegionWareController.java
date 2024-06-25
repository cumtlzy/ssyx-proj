package com.atguigu.ssyx.sys.controller;

import com.atguigu.ssyx.common.result.Result;
import com.atguigu.ssyx.model.sys.RegionWare;
import com.atguigu.ssyx.sys.service.RegionWareService;
import com.atguigu.ssyx.vo.sys.RegionWareQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * ClassName: RegionWareController
 * Package: com.atguigu.ssyx.sys.controller
 */

@Api(tags = "RegionWare管理")
@RestController
@RequestMapping("admin/sys/regionWare")
public class RegionWareController {

    @Resource
    private RegionWareService regionWareService;

    //开通区域列表
    @ApiOperation(value = "获取开通区域列表")
    @GetMapping("{page}/{limit}")
    public Result index(@PathVariable Long page,
                        @PathVariable Long limit,
                        RegionWareQueryVo regionWareQueryVo) {

        Page<RegionWare> pageParam = new Page<>(page, limit);

        IPage<RegionWare> pageModel = regionWareService.selectPage(pageParam, regionWareQueryVo);

        return Result.ok(pageModel);
    }

    //添加开通区域
    @ApiOperation(value = "新增")
    @PostMapping("save")
    public Result save(@RequestBody RegionWare regionWare) {
        regionWareService.saveRegionWare(regionWare);
        return Result.ok(null);
    }
}
