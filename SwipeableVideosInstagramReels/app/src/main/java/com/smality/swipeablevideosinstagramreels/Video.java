package com.smality.swipeablevideosinstagramreels;

public class Video {
    private String url,title,desc;
    public Video(String url, String title, String desc) {
        this.url = url;
        this.title = title;
        this.desc = desc;
    }
    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }
}
