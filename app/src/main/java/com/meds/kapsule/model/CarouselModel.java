package com.meds.kapsule.model;

import java.io.Serializable;

public class CarouselModel implements Serializable{
    private String url, link;

    public CarouselModel(String url, String link) {
        this.url = url;
        this.link = link;
    }

    public String getUrl() {
        return url;
    }

    public String getLink() {
        return link;
    }
}
