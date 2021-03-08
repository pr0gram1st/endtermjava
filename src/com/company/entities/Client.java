package com.company.entities;

public class Client{
    int id;
    String firstName;
    String secondName;
    String accountnick;
    int age;
    String gender;
    String password;
    double balance;
    public Client(){
        id = 0;
        firstName = "";
        secondName = "";
        age = 0;
        gender = "";
        accountnick = "";
        password = "";
        balance = 0;
    }
    public Client(int id, String firstName, String secondName, String accountnick, int age, String gender, String password, double balance){
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.accountnick = accountnick;
        this.age = age;
        this.gender = gender;
        this.password = password;
        this.balance = balance;
    }
    public Client(String firstName, String secondName, String accountnick, int age, String gender, String password, double balance){
        this.firstName = firstName;
        this.secondName = secondName;
        this.accountnick = accountnick;
        this.age = age;
        this.gender = gender;
        this.password = password;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public String getAccountnick() {
        return accountnick;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getGender() {
        return gender;
    }

    public String getPassword() {
        return password;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setAccountnick(String accountnick) {
        this.accountnick = accountnick;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Override
    public String toString() {
        return "Client Info: \n" +
                "Id=" + id + '\n' +
                "FirstName='" + firstName + '\n' +
                "SecondName='" + secondName + '\n' +
                "Accountnick='" + accountnick + '\n' +
                "Age=" + age + '\n' +
                "Gender='" + gender + '\n' +
                "Password='" + password + '\n' +
                "Balance=" + balance + '\n';
    }
}
