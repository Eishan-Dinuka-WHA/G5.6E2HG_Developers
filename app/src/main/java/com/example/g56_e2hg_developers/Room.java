package com.example.g56_e2hg_developers;

public class Room {
    private String rname;
    private String remail;
    private String rtype;
    private String rguests;
    private String adate;
    private String ddate;

    public Room() {
    }

    public Room(String rname, String remail, String rtype, String rguests, String adate, String ddate) {
        this.rname = rname;
        this.remail = remail;
        this.rtype = rtype;
        this.rguests = rguests;
        this.adate = adate;
        this.ddate = ddate;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRemail() {
        return remail;
    }

    public void setRemail(String remail) {
        this.remail = remail;
    }

    public String getRtype() {
        return rtype;
    }

    public void setRtype(String rtype) {
        this.rtype = rtype;
    }

    public String getRguests() {
        return rguests;
    }

    public void setRguests(String rguests) {
        this.rguests = rguests;
    }

    public String getAdate() {
        return adate;
    }

    public void setAdate(String adate) {
        this.adate = adate;
    }

    public String getDdate() {
        return ddate;
    }

    public void setDdate(String ddate) {
        this.ddate = ddate;
    }
}
