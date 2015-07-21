package com.ban.incl.instantclass.vo;

/**
 * Created by ots on 2015-05-18.
 */
public class ClassVO {
    private String classId;
    private String title;
    private String date;
    private String startTime;
    private String endTime;
    private String content;
    private String place;
    private String addr;
    private String price;
    private String curr_people;
    private String max_people;
    private String end_yn;
    private String del_yn;

    public String getCurr_people() {
        return curr_people;
    }

    public void setCurr_people(String curr_people) {
        this.curr_people = curr_people;
    }

    public String getMax_people() {
        return max_people;
    }

    public void setMax_people(String max_people) {
        this.max_people = max_people;
    }

    public String getEnd_yn() {
        return end_yn;
    }

    public void setEnd_yn(String end_yn) {
        this.end_yn = end_yn;
    }

    public String getDel_yn() {
        return del_yn;
    }

    public void setDel_yn(String del_yn) {
        this.del_yn = del_yn;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
