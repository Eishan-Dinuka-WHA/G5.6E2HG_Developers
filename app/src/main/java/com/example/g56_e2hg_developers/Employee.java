package com.example.g56_e2hg_developers;

public class Employee {
    private String id;
    private String fname;
    private String mob;
    private String add;
    private String desin;
    private String type;
    private String gen;
    private String edu;

    public Employee() {
    }

    public Employee(String id, String fname, String mob, String add, String desin, String type, String gen, String edu) {
        this.id = id;
        this.fname = fname;
        this.mob = mob;
        this.add = add;
        this.desin = desin;
        this.type = type;
        this.gen = gen;
        this.edu = edu;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getDesin() {
        return desin;
    }

    public void setDesin(String desin) {
        this.desin = desin;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public String getEdu() {
        return edu;
    }

    public void setEdu(String edu) {
        this.edu = edu;
    }
}
