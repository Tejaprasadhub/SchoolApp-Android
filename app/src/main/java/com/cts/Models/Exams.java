package com.cts.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Exams {
    @JsonProperty("id")
    public String id = "";
    @JsonProperty("classid")
    public String classid = "";
    @JsonProperty("className")
    public String className = "";
    @JsonProperty("examName")
    public String examName = "";
    @JsonProperty("totalMarks")
    public String TotalMarks = "";
    @JsonProperty("startDate")
    public String startDate = "";
    @JsonProperty("endDate")
    public String endDate = "";
    @JsonProperty("status")
    public String status;
    @JsonProperty("examStatus")
    public String examStatus = "";
    @JsonProperty("secured")
    public String secured ="";
    @JsonProperty("subject")
    public ArrayList<Subject> subjects = new ArrayList<>();
    public Exams(){

    }

    public  Exams(String id,String classname,String examname,String total){
        this.id = id;
        this.className = classname;
        this.examName = examname;
        this.TotalMarks = total;
    }
}
