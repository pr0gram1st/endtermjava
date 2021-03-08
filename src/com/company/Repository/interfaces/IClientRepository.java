package com.company.Repository.interfaces;

import com.company.controller.Controller;
import com.company.entities.*;

import java.util.List;

public interface IClientRepository {
    List <String> allClients();
    int createClient(Client cur);
    List <Pc> getAllPc();
    List <Ps5> getAllPs();
    List <Food> getAllDrinks();
    List <Food> getAllSnacks();
    String getInfo(int id);
    boolean reservePc(int client_id, int Pc_id);
    boolean reservePs(int client_id, int Ps_id);
    boolean buyFood(int client_id, int food_id);
    String getPassword(int id);
    boolean updateBalance(int client_id, int amountOfMoney);
    int remain(int id);
    List <Pc> getReservedPc();
    List <Ps5> getReservedPs();
}