package com.demobatis.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.demobatis.pojo.Brand;

import java.util.List;

// 业务层
public interface BrandService {
    Boolean save(Brand brand);
    Boolean update(Brand brand);
    Boolean del(Integer id);
    Brand byId(Integer id);
    List<Brand> getAll();
    IPage<Brand> getPage(Integer current, Integer pageSize);
}
