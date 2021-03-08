package com.company.controller;

import com.company.Repository.interfaces.IClientRepository;
import com.company.entities.*;

import java.util.List;

public class Controller {
    private final IClientRepository repo;

    public Controller(IClientRepository repo) {
        this.repo = repo;
    }

    public String getReservedPc(){
        List < Pc > Pcs = repo.getReservedPc();
        return Pcs.toString();
    }

    public String getReservedPs(){
        List < Ps5 > Pss = repo.getReservedPs();
        return Pss.toString();
    }

    public String remain(int id){
        int x = repo.remain(id);
        return "Your current money " + x;
    }

    public String updateBalance(int id, int money){
        boolean response = repo.updateBalance(id, money);
        return (response ? "Update Finished" : "Update failed");
    }

    public boolean checkPassword(String pass, int id){
        String cur = repo.getPassword(id);
        if(cur.equals(pass)){
            return true;
        }
        return false;
    }

    public String allClients(){
        List <String> Clients = repo.allClients();
        return Clients.toString();
    }

    public int createClient(Client cur){
        int created = repo.createClient(cur);
        if(created == -1){
            System.out.println("Creation failed!");
        }
        else{
            System.out.println("Created successfully!");
        }
        return created;
    }

    public String getInfo(int id){
        String response = repo.getInfo(id);
        return response;
    }


    public String getAllPC(){
        List < Pc > Pcs = repo.getAllPc();
        return Pcs.toString();
    }

    public String getAllPs(){
        List < Ps5 > Pss = repo.getAllPs();
        return Pss.toString();
    }


    public String getAllDrinks(){
        List < Food > Pcs = repo.getAllDrinks();
        return Pcs.toString();
    }

    public String getAllSnacks(){
        List < Food > Pcs = repo.getAllSnacks();
        return Pcs.toString();
    }
    public String reservePC(int client_id, int Pc_id){
        boolean response = repo.reservePc(client_id, Pc_id);
        return (response ? "Reserved successfully" : "Reserve failed");
    }

    public String reservePs(int client_id, int Ps_id){
        boolean response = repo.reservePs(client_id, Ps_id);
        return (response ? "Reserved successfully" : "Reserve failed");
    }

    public String buyFood(int client_id, int food_id){
        boolean response = repo.buyFood(client_id, food_id);
        return (response ? "Bought successfully" : "Buying failed");
    }

}
