package com.jsu.polo;

class Employee{
    private String eid;
    private String ename;
    private String department;
    private String telenum;

    public Employee(String eid, String ename, String department, String telenum) {
        this.eid = eid;
        this.ename = ename;
        this.department = department;
        this.telenum = telenum;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTelenum() {
        return telenum;
    }

    public void setTelenum(String telenum) {
        this.telenum = telenum;
    }
}
public class Info {
}


