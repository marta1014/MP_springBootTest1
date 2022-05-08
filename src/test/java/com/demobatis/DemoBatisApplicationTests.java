package com.demobatis;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demobatis.mapper.BrandMapper;
import com.demobatis.pojo.Brand;
import net.bytebuddy.implementation.bytecode.ShiftRight;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoBatisApplicationTests {
    @Autowired
    private BrandMapper brandMapper;

    @Test
    void contextLoads() {
        // 分页功能需要用到mp的拦截器 addInnerInterceptor添加具体的拦截器
        // 参考 package com.demobatis.config; line 14
        IPage page = new Page(2,1);
        IPage<Brand> brandIPage = this.brandMapper.selectPage(page, null);
        // page.getRecords();

        String brandName = "诺基耶";
        // 代替 queryWrapper 避免外界传递非正常数据导致的报错
        LambdaQueryWrapper<Brand> qw = new LambdaQueryWrapper<>();
        qw.like(brandName != null,Brand::getBrandName,brandName);
        brandMapper.selectList(qw);

    }

}
