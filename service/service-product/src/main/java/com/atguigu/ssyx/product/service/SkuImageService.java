package com.atguigu.ssyx.product.service;

import com.atguigu.ssyx.model.product.SkuImage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 商品图片 服务类
 * </p>
 *
 * @author atguigu
 * @since 2024-06-25
 */
public interface SkuImageService extends IService<SkuImage> {

    List<SkuImage> findBySkuId(Long skuId);
}
