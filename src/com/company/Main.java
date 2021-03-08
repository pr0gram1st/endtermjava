package com.company;

import com.company.Repository.ClientRepository;
import com.company.Repository.interfaces.IClientRepository;
import com.company.controller.Controller;
import com.company.data.IPostgresDB;
import com.company.data.PostgresDB;

public class Main {

    public static void main(String[] args) {
        IPostgresDB db = new PostgresDB();
        IClientRepository repo = new ClientRepository(db);
        Controller controller = new Controller(repo);
        MyApplication app = new MyApplication(controller);
        app.start();
    }
}
