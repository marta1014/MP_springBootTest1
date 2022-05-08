package com.demobatis.pojo;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Mapper;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_brand")
public class Brand {
    private int id;
    private String brandName;
    private String companyName;
    private int statu;
    private String description;
    private int ordered;
}
