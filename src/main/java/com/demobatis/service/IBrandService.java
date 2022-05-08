package com.demobatis.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.demobatis.pojo.Brand;

// 业务层 接口的优化版本

public interface IBrandService extends IService<Brand> {
    // void something
    IPage<Brand> getPageList(int current, int pageSize);

    IPage<Brand> getBrandListByCondition(int current, int pageSize,Brand brand);
}
