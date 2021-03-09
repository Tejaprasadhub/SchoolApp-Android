package com.cts.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FeesCategoryData {
    @JsonProperty("id")
    public String id;
    @JsonProperty("name")
    public String name;
    @JsonProperty("class")
    public String className;
    @JsonProperty("roll")
    public String rollNo;
    @JsonProperty("paid_date")
    public String padiDate;
    @JsonProperty("total")
    public String totalAmt;
    @JsonProperty("paid")
    public String paidAmt;
    @JsonProperty("due")
    public String dueAmt;
    @JsonProperty("status")
    public String status;
    @JsonProperty("examType")
    public String examType;
}
