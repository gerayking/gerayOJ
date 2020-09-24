package com.gerayking.gerayoj.pojo;
public class Problem {
    private int pid;
    private String title;
    private int AcNum;
    private int StatuNum;

    public Problem() {
    }

    public Problem(int pid, String title, int acNum, int statuNum) {
        this.pid = pid;
        this.title = title;
        AcNum = acNum;
        StatuNum = statuNum;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAcNum() {
        return AcNum;
    }

    public void setAcNum(int acNum) {
        AcNum = acNum;
    }

    public int getStatuNum() {
        return StatuNum;
    }

    public void setStatuNum(int statuNum) {
        StatuNum = statuNum;
    }
}
