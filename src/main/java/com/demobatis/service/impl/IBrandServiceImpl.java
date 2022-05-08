package com.demobatis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demobatis.mapper.BrandMapper;
import com.demobatis.pojo.Brand;
import com.demobatis.service.IBrandService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// 此处实现类是 package com.demobatis.service.impl.BrandServiceImpl 的优化版本 给予MP
@Service
public class IBrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements IBrandService {
    @Autowired
    private BrandMapper brandMapper;
    @Override
    public IPage<Brand> getPageList(int current, int pageSize) {
        IPage page = new Page(current,pageSize);
        brandMapper.selectPage(page, null);
        return page;
    }

    @Override
    public IPage<Brand> getBrandListByCondition(int current, int pageSize, Brand brand) {
        IPage page = new Page(current,pageSize);
        LambdaQueryWrapper<Brand> lw = new LambdaQueryWrapper<>();
        lw.like(Strings.isNotEmpty(brand.getBrandName()),Brand::getBrandName,brand.getBrandName());
        lw.like(Strings.isNotEmpty(brand.getCompanyName()),Brand::getCompanyName,brand.getCompanyName());
        brandMapper.selectPage(page, lw);
        return page;
    }
}
