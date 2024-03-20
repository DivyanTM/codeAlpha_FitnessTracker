package com.codealpha.fitnesstracker;

public class Exercise {
    private int id;
    private String name;
    private String procd;


    public Exercise(int id, String name, String procd) {
        this.id = id;
        this.name = name;
        this.procd = procd;
    }

    public int getImageResource() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getProcd() {
        return procd;
    }
}
