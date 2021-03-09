package com.cts.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TeachersResponse {
    @JsonProperty("teacherId")
    public String teacherId = "";
    @JsonProperty("teacherName")
    public String teacherName = "";
    @JsonProperty("teacherImage")
    public String teacherImg = "";
    @JsonProperty("subjectId")
    public String subjectId = "";
    @JsonProperty("subjectName")
    public String subjectName = "";
    @JsonProperty("phn")
    public String phone = "";
    @JsonProperty("email")
    public String email = "";
}
