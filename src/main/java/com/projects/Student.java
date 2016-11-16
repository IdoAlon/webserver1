package com.projects;

/**
 * Created by thesonics on 23/09/16.
 */
class Student {
    private String id;
    private String fullName;
    private String gender;
    private float avg;

    public Student(String id, String fullName, String gender, float avg) {
        this.id = id;
        this.fullName = fullName;
        this.gender = gender;
        this.avg = avg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public float getAvg() {
        return avg;
    }

    public void setAvg(float avg) {
        this.avg = avg;
    }
}
