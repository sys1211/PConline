package com.example.tf.pconline.domain;

/**
 * Created by le on 2017/6/8.
 */

public class Channel {
    private String imgUrl;


    private String name;



    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Channel(String imgUrl, String name) {

        this.imgUrl = imgUrl;
        this.name = name;

    }
}
