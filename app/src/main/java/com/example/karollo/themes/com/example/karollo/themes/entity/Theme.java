package com.example.karollo.themes.com.example.karollo.themes.entity;

import com.orm.SugarRecord;

public class Theme extends SugarRecord<Theme> {
    private String pictureId;
    private String status;

    public Theme() {
    }

    public Theme(String pictureId, String status) {
        this.pictureId = pictureId;
        this.status = status;
    }

    public String getPictureId() {
        return pictureId;
    }

    public void setPictureId(String pictureId) {
        this.pictureId = pictureId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
