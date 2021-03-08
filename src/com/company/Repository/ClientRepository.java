package com.company.Repository;

import com.company.Repository.interfaces.IClientRepository;
import com.company.data.IPostgresDB;
import com.company.entities.*;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository implements IClientRepository {
    private final IPostgresDB database;

    public ClientRepository(IPostgresDB database){this.database = database;}

    @Override
    public List<Ps5> getReservedPs() {
        Connection con = null;
        try {
            List < Ps5 > Ps = new ArrayList<Ps5>();
            con = database.getConnection();
            String sql = "Select * FROM Ps where client_id!=0";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                List < String > Games = new ArrayList<String>();
                String cur = "";
                String games = rs.getString("Games");
                for(int i = 0; i < games.length(); ++i){
                    char ch = games.charAt(i);
                    if(ch == ','){
                        Games.add(cur);
                        cur = "";
                    }
                    else{
                        cur += ch;
                    }
                }
                Ps5 comp = new Ps5(rs.getInt("id"),
                        rs.getInt("gamesCount"),
                        Games,
                        rs.getString("sofa"),
                        rs.getString("tvname"),
                        rs.getDouble("resolution"),
                        rs.getInt("gamepadcount"),
                        rs.getInt("generation"),
                        rs.getInt("cost"),
                        rs.getInt("client_id"));
                Ps.add(comp);
            }
            return Ps;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Pc> getReservedPc() {
        Connection con = null;
        try {
            List < Pc > Pcs = new ArrayList<Pc>();
            con = database.getConnection();
            String sql = "Select * FROM Pc where client_id!=0";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Pc comp = new Pc(rs.getInt("id"),
                        rs.getString("cpu"),
                        rs.getString("videocard"),
                        rs.getInt("ram"),
                        rs.getInt("memory"),
                        rs.getString("monitor"),
                        rs.getDouble("resolution"),
                        rs.getString("mouse"),
                        rs.getString("keyboard"),
                        rs.getString("headphones"),
                        rs.getInt("cost"),
                        rs.getInt("client_id"));
                Pcs.add(comp);
            }
            return Pcs;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }



    @Override
    public int remain(int id){
        Connection con = null;
        try {
            con = database.getConnection();
            String sql = "select * from clients where client_id=" + id;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                return rs.getInt("balance");
            }
            return 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return 0;
    }

    @Override
    public boolean updateBalance(int client_id, int amountOfMoney){
        Connection con = null;
        try {
            con = database.getConnection();
            String sql = "select * from clients where client_id=" + client_id;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                if(rs.getDouble("balance") + amountOfMoney < 0){
                    System.out.println("Not Enough Money!");
                    return false;
                }
                int total = (int)rs.getDouble("balance") + amountOfMoney;
                sql = "UPDATE clients SET balance=" + total + " WHERE client_id=" + client_id;
                PreparedStatement state = con.prepareStatement(sql);
                state.execute();
                return true;
            }
            return false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public List<String> allClients() {
        Connection con = null;
        try {
            List <String> accounts = new ArrayList<String>();
            con = database.getConnection();
            String sql = "Select * FROM clients";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("client_id");
                String nickname = rs.getString("nickname");
                accounts.add(id + "   |   " + nickname + "\n");
            }
            return accounts;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    public int getLastId(){
        Connection con = null;
        try {
            con = database.getConnection();
            String sql = "Select * FROM clients";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            int last = 0;
            while(rs.next()){
                int id = rs.getInt("client_id");
                last = id;
            }
            return last;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return -1;
    }

    @Override
    public int createClient(Client client) {
        Connection con = null;
        try {
            con = database.getConnection();
            String sql = "INSERT INTO clients(client_id, firstName, secondName, nickname, age, gender, password, balance) VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            int id = getLastId();
            if(id == -1){
                id = 1;
            }
            else{
                id++;
            }
            st.setInt(1, id);
            st.setString(2, client.getFirstName());
            st.setString(3, client.getSecondName());
            st.setString(4, client.getAccountnick());
            st.setInt(5, client.getAge());
            st.setString(6, client.getGender());
            st.setString(7, client.getPassword());
            st.setDouble(8, client.getBalance());
            st.execute();
            return id;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return -1;
    }

    @Override
    public List<Pc> getAllPc() {
        Connection con = null;
        try {
            List < Pc > Pcs = new ArrayList<Pc>();
            con = database.getConnection();
            String sql = "Select * FROM Pc";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Pc comp = new Pc(rs.getInt("id"),
                        rs.getString("cpu"),
                        rs.getString("videocard"),
                        rs.getInt("ram"),
                        rs.getInt("memory"),
                        rs.getString("monitor"),
                        rs.getDouble("resolution"),
                        rs.getString("mouse"),
                        rs.getString("keyboard"),
                        rs.getString("headphones"),
                        rs.getInt("cost"),
                        rs.getInt("client_id"));
                Pcs.add(comp);
            }
            return Pcs;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Ps5> getAllPs() {
        Connection con = null;
        try {
            List < Ps5 > Ps = new ArrayList<Ps5>();
            con = database.getConnection();
            String sql = "Select * FROM Ps";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                List < String > Games = new ArrayList<String>();
                String cur = "";
                String games = rs.getString("Games");
                for(int i = 0; i < games.length(); ++i){
                    char ch = games.charAt(i);
                    if(ch == ','){
                        Games.add(cur);
                        cur = "";
                    }
                    else{
                        cur += ch;
                    }
                }
                Ps5 comp = new Ps5(rs.getInt("id"),
                        rs.getInt("gamesCount"),
                        Games,
                        rs.getString("sofa"),
                        rs.getString("tvname"),
                        rs.getDouble("resolution"),
                        rs.getInt("gamepadcount"),
                        rs.getInt("generation"),
                        rs.getInt("cost"),
                        rs.getInt("client_id"));
                Ps.add(comp);
            }
            return Ps;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Food> getAllDrinks() {
        Connection con = null;
        try {
            List < Food > Drinks = new ArrayList<Food>();
            con = database.getConnection();
            String sql = "Select * FROM food where type='juice'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Food comp = new Food(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("type"),
                        rs.getInt("calories"),
                        rs.getInt("price"));
                Drinks.add(comp);
            }
            return Drinks;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Food> getAllSnacks() {
        Connection con = null;
        try {
            List < Food > Snacks = new ArrayList<Food>();
            con = database.getConnection();
            String sql = "Select * FROM food where type='snack'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Food comp = new Food(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("type"),
                        rs.getInt("calories"),
                        rs.getInt("price"));
                Snacks.add(comp);
            }
            return Snacks;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public String getInfo(int id) {
        Connection con = null;
        try {
            con = database.getConnection();
            String sql = "Select * FROM clients where client_id=" + id;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                Client cl = new Client(
                        rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getInt(5),
                rs.getString(6),
                rs.getString(7),
                rs.getDouble(8) );
                return cl.toString();
            }
            return "-1";
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return "-1";
    }

    @Override
    public boolean reservePc(int client_id, int Pc_id) {
        Connection con = null;
        try {
            con = database.getConnection();
            String sql = "select * from pc";
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            if(rs.next()) {
                System.out.println(client_id);
                if(updateBalance(client_id, -1 * rs.getInt("cost"))){
                    sql = "UPDATE Pc SET client_id=" + client_id + " WHERE id=" + Pc_id;
                    PreparedStatement st = con.prepareStatement(sql);
                    st.execute();
                    return true;
                }
            }
            return false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean reservePs(int client_id, int Ps_id) {
        Connection con = null;
        try {
            con = database.getConnection();
            String sql = "select * from ps";
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            if(rs.next()) {
                if(updateBalance(client_id, -1 * rs.getInt("cost"))){
                    sql = "UPDATE Ps SET client_id=" + client_id + " WHERE id=" + Ps_id;
                    PreparedStatement st = con.prepareStatement(sql);
                    st.execute();
                    return true;
                }
            }
            return false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean buyFood(int client_id, int food_id) {
        Connection con = null;
        try {
            con = database.getConnection();
            String sql = "select * from food";
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            if(rs.next()) {
                if(updateBalance(client_id, -1 *  rs.getInt("price"))){
                    sql = "DELETE FROM Food WHERE id=" + food_id;
                    PreparedStatement st = con.prepareStatement(sql);
                    st.execute();
                    return true;
                }
            }
            return false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public String getPassword(int id) {
        Connection con = null;
        try {
            con = database.getConnection();
            String sql = "Select * FROM clients where client_id=" + id;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                String pass = rs.getString("password");
                return pass;
            }
            return "-1";
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return "-1";
    }
}