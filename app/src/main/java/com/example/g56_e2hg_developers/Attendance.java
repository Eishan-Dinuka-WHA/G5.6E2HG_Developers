package com.example.g56_e2hg_developers;

public class Attendance {

    private String adate;
    private String atype;
    private String atime;


    public Attendance() {
    }

    public Attendance(String adate, String atype, String atime) {
        this.adate = adate;
        this.atype = atype;
        this.atime = atime;
    }

    public String getAdate() {
        return adate;
    }

    public void setAdate(String adate) {
        this.adate = adate;
    }

    public String getAtype() {
        return atype;
    }

    public void setAtype(String atype) {
        this.atype = atype;
    }

    public String getAtime() {
        return atime;
    }

    public void setAtime(String atime) {
        this.atime = atime;
    }
}
