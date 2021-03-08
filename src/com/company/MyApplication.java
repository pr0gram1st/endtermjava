package com.company;

import com.company.entities.*;
import com.company.controller.*;

import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MyApplication {
    private final Controller controller;
    private final Scanner scanner;

    public MyApplication(Controller controller){
        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void start(){
        System.out.println("============================================================================");
        System.out.println("================           Brothers welcoms you!       ===================");
        System.out.println("============================================================================");
        System.out.println("\n");
        System.out.println("Please enter 1 if you already have an account");
        System.out.println("Please enter 2 if you want to register");
        int opt = scanner.nextInt();
        int id = 0;
        scanner.nextLine();
        if(opt == 1) {
            String res = allClientsMenu();
            System.out.println(res);
            System.out.println("Select an account");
            id = scanner.nextInt();
            scanner.nextLine();
            res = checkPasswordMenu(id);
            System.out.println(res);
            if(res != "Correct!"){
                System.out.println("Sorry try again");
                return;
            }
        }
        else {
            id = createClientMenu();
        }
        while(true){
            System.out.println("Select option: (1-5)");
            System.out.println("Enter 1 if you want to book/reserve PC");
            System.out.println("Enter 2 if you want to book/reserve PS");
            System.out.println("Enter 3 if you want to buy Food");
            System.out.println("Enter 4 if you want to know account information");
            System.out.println("Enter 5 if you want add money to your balance");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.println("Enter the option: (0-5)");
                int option = scanner.nextInt();
                scanner.nextLine();
                if(option == 1){
                    reservePcMenu(id);
                }
                else if(option == 2){
                    reservePsMenu(id);
                }
                else if(option == 3){
                    buyFood(id);
                }
                else if(option == 4){
                    getInfoMenu(id);
                }
                else if(option == 5){
                    updateBalanceMenu(id);
                }
                else{
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be integer");
                scanner.nextLine();
            } catch (Exception e){
                System.out.println(e.getMessage());
            }

            System.out.println("----------------------------------------");
        }
    }

    public void updateBalanceMenu(int id){
        System.out.println("PC: ");
        System.out.println("Workdays: ");
        System.out.println("1 hour - 400 tng");
        System.out.println("3 hours - 900 tng");
        System.out.println("5 hours - 1700 tng");
        System.out.println("All night(12 hours) - 3000 tng");
        System.out.println("Weekends: ");
        System.out.println("1 hour - 700 tng");
        System.out.println("3 hours - 1400 tng");
        System.out.println("5 hours - 2200 tng");
        System.out.println("All night(12 hours) - 4000 tng");
        System.out.println("PlayStation: ");
        System.out.println("Workdays: ");
        System.out.println("1 hour - 500 tng");
        System.out.println("3 hours - 1000 tng");
        System.out.println("5 hours - 1500 tng");
        System.out.println("All night(12 hours) - 3000 tng");
        System.out.println("Weekends: ");
        System.out.println("1 hour - 700 tng");
        System.out.println("3 hours - 1400 tng");
        System.out.println("5 hours - 2000 tng");
        System.out.println("All night(12 hours) - 3500 tng");
        System.out.println("Enter amount of money you want to add: ");
        int x = scanner.nextInt();
        scanner.nextLine();
        String response = controller.updateBalance(id, x);
        System.out.println(response);
        String response1 = controller.remain(id);
        System.out.println(response1);
    }

    public void getInfoMenu(int id){
        String res = controller.getInfo(id);
        System.out.println(res);
    }

    public String allClientsMenu(){
        System.out.println("Here is the list of accounts: ");
        String res = controller.allClients();
        return res;
    }

    public String checkPasswordMenu(int id){
        System.out.println("Enter Password: ");
        String pass = scanner.nextLine();
        boolean response = controller.checkPassword(pass, id);
        return (response ? "Correct!" : "Incorrect!");
    }

    public int createClientMenu(){
        System.out.println("Please give some information about yourself, please");
        System.out.println("Please enter name");
        String name = scanner.nextLine();
        System.out.println("Please enter surname");
        String surname = scanner.nextLine();
        System.out.println("Please enter age");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please enter gender");
        String gender = scanner.nextLine();
        System.out.println("Please create a nickname");
        String nickname = scanner.nextLine();
        System.out.println("Please create a password");
        String password = scanner.nextLine();
        Client cur = new Client(name, surname, nickname, age, gender, password, 0);
        int id = controller.createClient(cur);
        System.out.println(id);
        return id;
    }

    public void reservePcMenu(int id){
        try {
            int option = -1;
            while(option != 2 || option != 0) {
                System.out.println("Enter 1 if you want to see the available PC's list");
                System.out.println("Enter 2 if you want to reserve PC");
                System.out.println("Enter 3 if you want to see reserved PC's list");
                System.out.println("Enter 0 if you want to exit");
                System.out.println("Enter the option: (0 - 3)");
                option = scanner.nextInt();
                scanner.nextLine();
                if(option == 0){
                    return;
                }
                if (option == 1) {
                    String response = controller.getAllPC();
                    System.out.println(response);
                } else if (option == 2) {
                    System.out.println("Please enter id of PC");
                    int curid = scanner.nextInt();
                    scanner.nextLine();
                    String response = controller.reservePC(id, curid);
                    System.out.println(response);
                    String response1 = controller.remain(id);
                    System.out.println(response1);
                } else if (option == 3) {
                    String response = controller.getReservedPc();
                    System.out.println(response);
                } else {
                    System.out.println("Input must be in range between 0 and 3!");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Input must be integer");
            scanner.nextLine();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void reservePsMenu(int id){
        try {
            int option = -1;
            while(option != 2 || option != 0) {
                System.out.println("Enter 1 if you want to see the available PlayStations list");
                System.out.println("Enter 2 if you want to reserve PlayStation");
                System.out.println("Enter 3 if you want to see reserved PlayStations list");
                System.out.println("Enter 0 if you want to exit");
                System.out.println("Enter the option: (0 - 3)");
                option = scanner.nextInt();
                scanner.nextLine();
                if(option == 0){
                    return;
                }
                if (option == 1) {
                    String response = controller.getAllPs();
                    System.out.println(response);
                } else if (option == 2) {
                    System.out.println("Please enter id of PlayStation");
                    int curid = scanner.nextInt();
                    scanner.nextLine();
                    String response = controller.reservePs(id, curid);
                    System.out.println(response);
                    String response1 = controller.remain(id);
                    System.out.println(response1);
                } else if (option == 3) {
                    String response = controller.getReservedPs();
                    System.out.println(response);
                } else {
                    System.out.println("Input must be in range between 0 and 3!");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Input must be integer");
            scanner.nextLine();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void buyFood(int id){
        try {
            int option = -1;
            while(option != 2 || option != 3 || option != 0) {
                System.out.println("Enter 1 if you want to see the drinks list");
                System.out.println("Enter 2 if you want to see the snacks list");
                System.out.println("Enter 3 if you want to buy");
                System.out.println("Enter 0 if you want to exit");
                System.out.println("Enter the option: (0 - 3)");
                option = scanner.nextInt();
                scanner.nextLine();
                if(option == 0){
                    return;
                }
                if (option == 1) {
                    String response = controller.getAllDrinks();
                    System.out.println(response);
                } else if (option == 2) {
                    String response = controller.getAllSnacks();
                    System.out.println(response);
                } else if (option == 3) {
                    System.out.println("Please enter id of food");
                    int curid = scanner.nextInt();
                    scanner.nextLine();
                    String response = controller.buyFood(id, curid);
                    System.out.println(response);
                    String response1 = controller.remain(id);
                    System.out.println(response1);
                } else {
                    System.out.println("Input must be in range between 0 and 3!");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Input must be integer");
            scanner.nextLine();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
