package com.example.tf.pconline.Datas;

/**
 * Created by Administrator on 2017/6/11.
 */

public class QiCheKeJi {
    private String image;
    private String PiCtitle,PLMessage;

    public QiCheKeJi(String image, String piCtitle, String PLMessage) {
        this.image = image;
        PiCtitle = piCtitle;
        this.PLMessage = PLMessage;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPiCtitle() {
        return PiCtitle;
    }

    public void setPiCtitle(String piCtitle) {
        PiCtitle = piCtitle;
    }

    public String getPLMessage() {
        return PLMessage;
    }

    public void setPLMessage(String PLMessage) {
        this.PLMessage = PLMessage;
    }
}
