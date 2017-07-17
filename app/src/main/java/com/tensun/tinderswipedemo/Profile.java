package com.tensun.tinderswipedemo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/7/17.
 */

public class Profile {

    @SerializedName("price")                                                                                             // 讀取json文件變量並將其綁定到模型變量
    @Expose                                                                                                              // 使變量可讀取到gson
    private String price;

    @SerializedName("url")                                                                                               // 讀取json文件變量並將其綁定到模型變量
    @Expose                                                                                                              // 使變量可讀取到gson
    private String imageUrl;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
