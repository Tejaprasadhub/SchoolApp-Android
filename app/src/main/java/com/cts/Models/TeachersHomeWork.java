package com.cts.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TeachersHomeWork {
    public String homeworkId = "";
    public String classId ="";
    @JsonProperty("class")
    public String className = "";
    public String secId = "";
    @JsonProperty("section")
    public String secName = "";
    public String SubjectId = "";
    @JsonProperty("subject")
    public String subjectName  = "";
    @JsonProperty("assign_date")
    public String assignDate = "";
    @JsonProperty("submission_date")
    public String submissionDate = "";
    @JsonProperty("title")
    public String chapterName = "";
    public String Desc = "";
    @JsonProperty("file_url")
    public String uploadFile = "";
}
