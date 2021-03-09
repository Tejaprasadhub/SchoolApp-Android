package com.cts.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TimeTableResponse {
    @JsonProperty("startTime")
    public String StartTime = "";
    @JsonProperty("endTime")
    public String EndTime = "";
    @JsonProperty("subjectid")
    public String subjectId = "";
    @JsonProperty("subjectName")
    public String subjectName = "";
    @JsonProperty("tecaherId")
    public String TeacherId = "";
    @JsonProperty("teacherName")
    public String TeacherName = "";
    @JsonProperty("exp")
    public String Exp = "";
    @JsonProperty("isPractical")
    public Boolean isPractical = false;
    @JsonProperty("isTheory")
    public  Boolean isTheory = false;
}
