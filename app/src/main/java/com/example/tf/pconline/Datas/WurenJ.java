package com.example.tf.pconline.Datas;

/**
 * Created by Administrator on 2017/6/12.
 */

public class WurenJ {
    private String image;
    private String WRCtitle,WRMessage;

    public WurenJ(String image, String WRCtitle, String WRMessage) {
        this.image = image;
        this.WRCtitle = WRCtitle;
        this.WRMessage = WRMessage;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getWRCtitle() {
        return WRCtitle;
    }

    public void setWRCtitle(String WRCtitle) {
        this.WRCtitle = WRCtitle;
    }

    public String getWRMessage() {
        return WRMessage;
    }

    public void setWRMessage(String WRMessage) {
        this.WRMessage = WRMessage;
    }
}
