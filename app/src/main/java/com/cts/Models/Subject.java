package com.cts.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Subject {
    @JsonProperty("id")
    public String id ;
    @JsonProperty("name")
    public  String name;
    @JsonProperty("total")
    public  String total;
    @JsonProperty("secured")
    public String secured;
    @JsonProperty("status")
    public String status;
    @JsonProperty("examStatus")
    public String examStatus;
    @JsonProperty("examDate")
    public  String examDate;
}
