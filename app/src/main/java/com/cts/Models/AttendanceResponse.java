package com.cts.Models;

public class AttendanceResponse {
   public String date ;
   public Boolean isCurrentMonth = false;
   public Boolean isCurrentDay = false;
   public Boolean isSelectedDay = false;
   public Boolean isPresent = true;
   public Boolean isAbscent = true;
   public Boolean isLate = true;
   public Boolean isHoliday = true;
   public Boolean isHalfDay = true;
}
