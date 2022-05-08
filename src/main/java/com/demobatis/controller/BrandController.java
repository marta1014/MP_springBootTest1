package com.demobatis.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.demobatis.pojo.Brand;
import com.demobatis.pojo.PageSize;
import com.demobatis.service.IBrandService;
import com.demobatis.util.ResponseFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
public class BrandController {
    @Autowired
    private IBrandService iBrandService;

    @PostMapping("all")
    public ResponseFormat getAllBrand() {
        ResponseFormat list = getPageList(new PageSize(-1,-1));
        return list;
    }

    @PostMapping("addBrand")
    public ResponseFormat addBrand(@RequestBody Brand brand) {
        // ResponseFormat r = new ResponseFormat();
        // boolean save = iBrandService.save(brand);
        // r.setResponseFlag(save ? "000000" : "999999");
        // new ResponseFormat(iBrandService.save(brand) ? "000000" : "999999");
        // return r;
        return new ResponseFormat(iBrandService.save(brand) ? "000000" : "999999");
    }

    @PutMapping("updateBrand")
    public ResponseFormat updateBrand(@RequestBody Brand brand) {
//        ResponseFormat r = new ResponseFormat();
//        boolean b = iBrandService.updateById(brand);
//        r.setResponseFlag(b ? "000000" : "999999");
//        return r;
        return new ResponseFormat(iBrandService.updateById(brand) ? "000000" : "999999");
    }

    @PostMapping("updateBrand")
    public ResponseFormat updateBrand1(@RequestBody Brand brand) {
//        ResponseFormat r = new ResponseFormat();
//        boolean b = iBrandService.updateById(brand);
//        r.setResponseFlag(b ? "000000" : "999999");
//        return r;
        return new ResponseFormat(iBrandService.updateById(brand) ? "000000" : "999999");
    }

    @PostMapping("del")
    public ResponseFormat deleteBrand1(@RequestBody Brand brand) {
//        ResponseFormat r = new ResponseFormat();
//        boolean b = iBrandService.removeById(brand.getId());;
//        r.setResponseFlag(b ? "000000" : "999999");
//        return r;
        return new ResponseFormat(iBrandService.removeById(brand.getId()) ? "000000" : "999999");
    }

    @GetMapping("/{id}")
    // localhost/brands/3
    public ResponseFormat getById(@PathVariable int id) {
        ResponseFormat r = new ResponseFormat();
        Brand b = iBrandService.getById(id);
        r.setResponseFlag(b != null ? "000000" : "999999");
        r.setData(b);
        return r;
    }

    @PostMapping("getBrandById")
    public ResponseFormat getBrandById(@RequestBody Brand brand) {
        Brand b = iBrandService.getById(brand.getId());
        return new ResponseFormat(b != null ? "000000" : "999999",b);
    }

    @PostMapping("getPageTest")
    public ResponseFormat getPageList(@RequestBody PageSize pageSize) {
        ResponseFormat r = new ResponseFormat();
        int cur = pageSize.getCurrent() == -1 ? 1 : pageSize.getCurrent();
        int size = pageSize.getPageSize() == -1 ?  iBrandService.count() :  pageSize.getPageSize();
        IPage b = iBrandService.getPageList(cur,size);
        if(cur > b.getPages()) {
            b = iBrandService.getPageList((int) b.getPages(),size);
        }
        r.setResponseFlag(b != null ? "000000" : "999999");
        r.setData(b);
        return r;
    }

    @PostMapping("selectByCondition") // error
    public void selectListByCondition(@RequestBody PageSize pageSize,Brand brand) {
        System.out.println(brand+"1234567890");
    }

    @GetMapping("selectByCondition/{current}/{pageSize}")
    public ResponseFormat gettListByCondition(@PathVariable int current,@PathVariable int pageSize, Brand brand) {
        ResponseFormat r = new ResponseFormat();
        IPage b = iBrandService.getBrandListByCondition(current,pageSize,brand);
        if(current > b.getPages()) {
            b = iBrandService.getBrandListByCondition((int) b.getPages(),pageSize,brand);
        }
        r.setResponseFlag(b != null ? "000000" : "999999");
        r.setData(b);
        return r;
    }
}
