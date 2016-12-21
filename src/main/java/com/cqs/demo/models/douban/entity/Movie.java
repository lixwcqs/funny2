package com.cqs.demo.models.douban.entity;

/**
 * Created by cqs on 10/15/16.
 */
public class Movie {
    int id;
    String title;
    String cover;
    float rate;
    boolean isBeetleSubject;
    boolean isNew;
    boolean playable;
    String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public boolean isBeetleSubject() {
        return isBeetleSubject;
    }

    public void setIsBeetleSubject(boolean isBeetleSubject) {
        this.isBeetleSubject = isBeetleSubject;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
    }

    public boolean isPlayable() {
        return playable;
    }

    public void setPlayable(boolean playable) {
        this.playable = playable;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cover2='" + cover + '\'' +
                ", rate=" + rate +
                ", isBeetleSubject=" + isBeetleSubject +
                ", isNew=" + isNew +
                ", playable=" + playable +
                ", url='" + url + '\'' +
                '}';
    }
}
