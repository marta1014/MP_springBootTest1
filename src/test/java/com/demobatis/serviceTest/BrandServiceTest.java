package com.demobatis.serviceTest;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demobatis.mapper.BrandMapper;
import com.demobatis.pojo.Brand;
import com.demobatis.service.BrandService;
import com.demobatis.service.IBrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BrandServiceTest {
    @Autowired
    private IBrandService iBrandService;
    @Autowired
    private BrandService brandService;
    @Test
    void testForBrand() {
        Brand brand = new Brand();
        brand.setBrandName("sanXing");
        brand.setCompanyName("sanXing Co Ltd");
        brand.setStatu(0);
        brand.setDescription("hello sanXing");
        brand.setOrdered(20);
        brand.setId(7);
        IPage<Brand> page = brandService.getPage(3, 1);
        System.out.println(page.getRecords());
    }

    @Test
    void testBrandForMP() {
        Brand brand = iBrandService.getById(7);
        System.out.println(brand);
    }
}
