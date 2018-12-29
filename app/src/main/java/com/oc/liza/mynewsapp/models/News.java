package com.oc.liza.mynewsapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class News implements NewsItem{
    @SerializedName("section")
    @Expose
    private String section;

    @SerializedName("subsection")
    @Expose
    private String subsection;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("published_date")
    @Expose
    private Date published_date;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("multimedia")
    @Expose
    private ArrayList<NewsImage> multimedia;

    @SerializedName("media")
    @Expose
    private ArrayList<NewsImage> media;


    @Override
    public String getTitle() {
        return title;
    }
    @Override
    public String getPublished_date() {
        return DateFormat.getDateInstance(DateFormat.SHORT).format(published_date);
    }

    @Override
    public String getUrl() {

        if (url.startsWith("https")) {
            //replace https with http in url
            url = url.substring(5);
            url = "http" + url;
        }
        return url;
    }
    @Override
    public String getImageUrl() {
        try {
            return multimedia.get(0).getUrl();
        } catch (Exception e) {
            return media.get(0).getMetadata().get(0).getUrl();
        }
    }
    @Override
    public String sectionAndSubsectionString() {
        String str = "";
        if (subsection != null && subsection.length() > 1) {
            str += section + " > " + subsection;
        } else {
            str += section;
        }
        return str;
    }

}
