package com.cts.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;

public class FeesCategory {
    @JsonProperty("id")
    public String id;
    @JsonProperty("name")
    @Expose
    public String name = "";
    @JsonProperty("image")
    public String imageUrl = "";
    @Expose
    public Integer iconName = 0;
    @Expose
    public Boolean isSelected = false;
    @JsonProperty("catgData")
    public ArrayList<FeesCategoryData> catgData = new ArrayList<>();

    public  FeesCategory(){

    }
    public FeesCategory(String catgName,Integer catgIcon,Boolean isSelected){
        this.name = catgName;
        this.iconName = catgIcon;
        this.isSelected = isSelected;
    }

}


