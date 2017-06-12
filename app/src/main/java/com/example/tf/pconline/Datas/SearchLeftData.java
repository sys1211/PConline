package com.example.tf.pconline.Datas;

/**
 * Created by joker on 2017/6/9.
 */

public class SearchLeftData {
    private int img;
    private String up;
    private String below;

    public SearchLeftData(int img, String up, String below) {
        this.img = img;
        this.up = up;
        this.below = below;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getUp() {
        return up;
    }

    public void setUp(String up) {
        this.up = up;
    }

    public String getBelow() {
        return below;
    }

    public void setBelow(String below) {
        this.below = below;
    }
}
