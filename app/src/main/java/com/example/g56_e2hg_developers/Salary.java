package com.example.g56_e2hg_developers;

public class Salary {

    private String ename;
    private String bas;
    private String over;
    private String allow;
    private String bonus;
    private String fest;
    private String stamp;
    private String epf;
    private Double tearning;
    private Double tdeducation;
    private Double totalp;
    private Double calepff;

    public Salary() {
    }

    public Salary(String ename, String bas, String over, String allow, String bonus, String fest, String stamp, String epf, Double tearning, Double tdeducation, Double totalp, Double calepff) {
        this.ename = ename;
        this.bas = bas;
        this.over = over;
        this.allow = allow;
        this.bonus = bonus;
        this.fest = fest;
        this.stamp = stamp;
        this.epf = epf;
        this.tearning = tearning;
        this.tdeducation = tdeducation;
        this.totalp = totalp;
        this.calepff = calepff;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getBas() {
        return bas;
    }

    public void setBas(String bas) {
        this.bas = bas;
    }

    public String getOver() {
        return over;
    }

    public void setOver(String over) {
        this.over = over;
    }

    public String getAllow() {
        return allow;
    }

    public void setAllow(String allow) {
        this.allow = allow;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public String getFest() {
        return fest;
    }

    public void setFest(String fest) {
        this.fest = fest;
    }

    public String getStamp() {
        return stamp;
    }

    public void setStamp(String stamp) {
        this.stamp = stamp;
    }

    public String getEpf() {
        return epf;
    }

    public void setEpf(String epf) {
        this.epf = epf;
    }

    public Double getTearning() {
        return tearning;
    }

    public void setTearning(Double tearning) {
        this.tearning = tearning;
    }

    public Double getTdeducation() {
        return tdeducation;
    }

    public void setTdeducation(Double tdeducation) {
        this.tdeducation = tdeducation;
    }

    public Double getTotalp() {
        return totalp;
    }

    public void setTotalp(Double totalp) {
        this.totalp = totalp;
    }

    public Double getCalepff() {
        return calepff;
    }

    public void setCalepff(Double calepff) {
        this.calepff = calepff;
    }
}