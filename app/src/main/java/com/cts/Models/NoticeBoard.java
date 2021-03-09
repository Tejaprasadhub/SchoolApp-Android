package com.cts.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NoticeBoard {
    @JsonProperty("notice_id")
    public String id = "";
    @JsonProperty("notice_name")
    public String noticeHeading = "";
    @JsonProperty("notice_date")
    public String noticeDate = "";
    @JsonProperty("notice_desc")
    public String noticeDesc = "";
}
