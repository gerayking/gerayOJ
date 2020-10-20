package com.gerayking.gerayoj.pojo;

import lombok.Data;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Contest {
    private int CID;
    private String title;
    private List<Integer> problemList;
    private String description;
    private String StartTime;
    private String EndTime;

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public String getEndTime() {
        return EndTime;
    }

    public void setEndTime(String endTime) {
        EndTime = endTime;
    }

    public void setProblemList(List<Integer> problemList) {
        this.problemList = problemList;
    }

    public Contest() {
    }

    public Contest(int CID, String title, List problemList, String description) {
        this.CID = CID;
        this.title = title;
        this.problemList = problemList;
        this.description = description;
    }

    public int getCID() {
        return CID;
    }

    public void setCID(int CID) {
        this.CID = CID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List getProblemList() {
        return problemList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
