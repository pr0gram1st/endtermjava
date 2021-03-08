package com.company.entities;

import com.sun.source.tree.UsesTree;

import java.util.List;

public class Pc {
    int id;
    String cpu;
    String videocard;
    int ram;
    int memory;
    String monitor;
    double resolution;
    String mouse;
    String keyboard;
    String headphones;
    int cost;
    int clientid;
    public Pc(int id, String cpu, String videocard, int ram, int memory, String monitor, double resolution, String mouse, String keyboard, String headphones, int cost, int clientid){
        this.clientid = clientid;
        this.cost = cost;
        this.id = id;
        this.cpu = cpu;
        this.videocard = videocard;
        this.ram = ram;
        this.memory = memory;
        this.monitor = monitor;
        this.resolution = resolution;
        this.mouse = mouse;
        this.keyboard = keyboard;
        this.headphones = headphones;
    }

    public Pc(String cpu, String videocard, int ram, int memory, String monitor, int resolution, String mouse, String keyboard, String headphones, int cost, int clientid){
        this.clientid = clientid;
        this.cost = cost;
        this.cpu = cpu;
        this.videocard = videocard;
        this.ram = ram;
        this.memory = memory;
        this.monitor = monitor;
        this.resolution = resolution;
        this.mouse = mouse;
        this.keyboard = keyboard;
        this.headphones = headphones;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setHeadphones(String headphones) {
        this.headphones = headphones;
    }

    public void setKeyboard(String keyboard) {
        this.keyboard = keyboard;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    public void setMouse(String mouse) {
        this.mouse = mouse;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setResolution(double resolution) {
        this.resolution = resolution;
    }

    public void setVideocard(String videocard) {
        this.videocard = videocard;
    }

    public int getId() {
        return id;
    }

    public double getResolution() {
        return resolution;
    }

    public int getMemory() {
        return memory;
    }

    public int getRam() {
        return ram;
    }

    public String getCpu() {
        return cpu;
    }

    public String getHeadphones() {
        return headphones;
    }

    public String getKeyboard() {
        return keyboard;
    }

    public String getMonitor() {
        return monitor;
    }

    public String getMouse() {
        return mouse;
    }

    public String getVideocard() {
        return videocard;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }

    public int getClientid() {
        return clientid;
    }

    public String toString() {
        return "Pc Info: " + '\n' +
                "Id = " + id + '\n' +
                "Cpu = " + cpu + '\n' +
                "Videocard = " + videocard + '\n' +
                "Ram = " + ram +
                "Memory = " + memory +
                "Monitor = " + monitor + '\n' +
                "Resolution = " + resolution +
                "Mouse = " + mouse + '\n' +
                "Keyboard = " + keyboard + '\n' +
                "Headphones = " + headphones + '\n' +
                "Client Id = " + clientid + '\n' +
                "Cost = " + cost + '\n' +
                "-----------------------------------" + '\n';
    }
}
