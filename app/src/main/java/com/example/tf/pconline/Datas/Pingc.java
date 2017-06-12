package com.example.tf.pconline.Datas;

/**
 * Created by Administrator on 2017/6/11.
 */

public class Pingc {
    String Title,Meaasge;
    String Image;

    public Pingc(String title, String meaasge, String image) {
        Title = title;
        Meaasge = meaasge;
        Image = image;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getMeaasge() {
        return Meaasge;
    }

    public void setMeaasge(String meaasge) {
        Meaasge = meaasge;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
