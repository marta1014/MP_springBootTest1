package com.demobatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageSize {
    private int current;
    private int pageSize;
    private Brand brand;

    public PageSize(int current, int pageSize) {
        this.current = current;
        this.pageSize = pageSize;
    }
}
