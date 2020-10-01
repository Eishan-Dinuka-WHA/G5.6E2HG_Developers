package com.example.g56_e2hg_developers;

public class Event {

    private String etype;
    private String name;
    private String email;
    private String ename;
    private String nog;
    private String date;
    private String htype;
    private String nop;
    private String hprice;
    private int totalP;

    public Event() {
    }

    public Event(String etype, String name, String email, String ename, String nog, String date, String htype, String nop, String hprice, int totalP) {
        this.etype = etype;
        this.name = name;
        this.email = email;
        this.ename = ename;
        this.nog = nog;
        this.date = date;
        this.htype = htype;
        this.nop = nop;
        this.hprice = hprice;
        this.totalP = totalP;
    }

    public String getEtype() {
        return etype;
    }

    public void setEtype(String etype) {
        this.etype = etype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getNog() {
        return nog;
    }

    public void setNog(String nog) {
        this.nog = nog;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHtype() {
        return htype;
    }

    public void setHtype(String htype) {
        this.htype = htype;
    }

    public String getNop() {
        return nop;
    }

    public void setNop(String nop) {
        this.nop = nop;
    }

    public String getHprice() {
        return hprice;
    }

    public void setHprice(String hprice) {
        this.hprice = hprice;
    }

    public int getTotalP() {
        return totalP;
    }

    public void setTotalP(int totalP) {
        this.totalP = totalP;
    }
}
