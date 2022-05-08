package com.demobatis.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.demobatis.pojo.Brand;
import com.demobatis.pojo.PageSize;
import com.demobatis.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @RestController
@RequestMapping("/brands") // 公共请求路径前缀

/**
 * 如若基于restful风格
 * 对应mapping。。。
 * 新增 post
 * 删除 delete
 * 修改 put
 * 查询 get
 *
 * 接收参数
 * @RequestBody 实体数据
 * @PathVariable 路径变量
 */
public class BrandControllerLow {
    @Autowired
    private IBrandService iBrandService;

    @PostMapping("all")
    public List<Brand> getAllBrand() {
        List<Brand> list = iBrandService.list();
        return list;
    }

    @PostMapping("addBrand")
    public Boolean addBrand(@RequestBody Brand brand) {
        return iBrandService.save(brand);
    }

    @PutMapping("updateBrand")
    public Boolean updateBrand(@RequestBody Brand brand) {
       return iBrandService.updateById(brand);
    }

    @PostMapping("updateBrand")
    public Boolean updateBrand1(@RequestBody Brand brand) {
        return iBrandService.updateById(brand);
    }

    @PostMapping("del")
    public Boolean deleteBrand1(@RequestBody Brand brand) {
        return iBrandService.removeById(brand.getId());
    }

    @GetMapping("/{id}")
    // localhost/brands/3
    public Brand getById(@PathVariable int id) {
        return iBrandService.getById(id);
    }

    @PostMapping("getBrandById")
    public Brand getBrandById(@RequestBody Brand brand) {
        return iBrandService.getById(brand.getId());
    }

    @PostMapping("getPageTest")
    public IPage<Brand> getPageList(@RequestBody PageSize pageSize) {
        return iBrandService.getPageList(pageSize.getCurrent(),pageSize.getPageSize());
    }
}
