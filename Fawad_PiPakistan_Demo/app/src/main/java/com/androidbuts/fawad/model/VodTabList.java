package com.androidbuts.fawad.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by fawadjawaidmalik on 13/10/2016.
 */
public class VodTabList {

    @SerializedName("VODTabs")
    @Expose
    private ArrayList<VodTab> VODTabs = new ArrayList<>();

    /**
     * @return The VODTabs
     */
    public ArrayList<VodTab> getVODTabs() {
        return VODTabs;
    }

    /**
     * @param VODTabs The VODTabs
     */
    public void setVODTabs(ArrayList<VodTab> VODTabs) {
        this.VODTabs = VODTabs;
    }
}
