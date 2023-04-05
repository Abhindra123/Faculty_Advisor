package com.sonait.facultyadvisor;

public class Userr {
    String sname,regno;
    public  Userr(){}

    public Userr(String sname, String regno) {
        this.sname = sname;
        this.regno = regno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }
}