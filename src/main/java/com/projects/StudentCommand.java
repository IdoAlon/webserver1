package com.projects;

import com.google.gson.Gson;

public class StudentCommand {
    private String command;
    private String id;
    private String fullName;
    private String gender;
    private String avg;

    public StudentCommand(String command, String id, String fullName, String gender, String avg) {
        this.command = command;
        this.id = id;
        this.fullName = fullName;
        this.gender = gender;
        this.avg = avg;
    }

    public static StudentCommand fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, StudentCommand.class);
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
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

    public String getAvg() {
        return avg;
    }

    public void setAvg(String avg) {
        this.avg = avg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentCommand that = (StudentCommand) o;

        if (command != null ? !command.equals(that.command) : that.command != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (fullName != null ? !fullName.equals(that.fullName) : that.fullName != null) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        return avg != null ? avg.equals(that.avg) : that.avg == null;

    }

    @Override
    public int hashCode() {
        int result = command != null ? command.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (avg != null ? avg.hashCode() : 0);
        return result;
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
