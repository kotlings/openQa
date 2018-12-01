package com.yubao.response;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by Administrator on 2016-12-01.
 */
public class PageObject<T> {
    @ApiModelProperty(value = "总记录数")
    private int total;
    @ApiModelProperty(value = "总页数")
    public int pagecnt;  //页数

    @ApiModelProperty(value = "页码")
    public int index;    //页码

    @ApiModelProperty(value = "每页条数")
    public int size;     //每页条数
    public List<T> objects;

    public void setTotal(int total) {
        this.total = total;
        if(total == 0){
            this.pagecnt = 0;
        }else{
            this.pagecnt = total/size + 1;
        }
    }
}
