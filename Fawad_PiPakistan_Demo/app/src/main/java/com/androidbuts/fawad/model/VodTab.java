package com.androidbuts.fawad.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by fawadjawaidmalik on 13/10/2016.
 */
public class VodTab {

    @SerializedName("VODTabId")
    @Expose
    private int VODTabId;
    @SerializedName("VODTabName")
    @Expose
    private String VODTabName;
    @SerializedName("VODTabThumbnailPath")
    @Expose
    private String VODTabThumbnailPath;

    public int getVODTabId() {
        return VODTabId;
    }

    public void setVODTabId(int VODTabId) {
        this.VODTabId = VODTabId;
    }

    public String getVODTabName() {
        return VODTabName;
    }

    public void setVODTabName(String VODTabName) {
        this.VODTabName = VODTabName;
    }

    public String getVODTabThumbnailPath() {
        return VODTabThumbnailPath;
    }

    public void setVODTabThumbnailPath(String VODTabThumbnailPath) {
        this.VODTabThumbnailPath = VODTabThumbnailPath;
    }
}
