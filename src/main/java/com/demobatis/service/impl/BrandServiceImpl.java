package com.demobatis.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demobatis.mapper.BrandMapper;
import com.demobatis.pojo.Brand;
import com.demobatis.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// 实现类
@Service
public class BrandServiceImpl implements BrandService  {

    @Autowired
    BrandMapper brandMapper;

    @Override
    public Boolean save(Brand brand) {
        return brandMapper.insert(brand) > 0;
    }

    @Override
    public Boolean update(Brand brand) {
        return brandMapper.updateById(brand) > 0;
    }

    @Override
    public Boolean del(Integer id) {
        return brandMapper.deleteById(id) > 0;
    }

    @Override
    public Brand byId(Integer id) {
        return brandMapper.selectById(id) ;
    }

    @Override
    public List<Brand> getAll() {
        return brandMapper.selectList(null);
    }

    @Override
    public IPage<Brand> getPage(Integer current, Integer pageSize) {
        IPage<Brand> page = new Page<>(current,pageSize);
        return brandMapper.selectPage(page,null);
    }
}