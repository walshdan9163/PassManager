package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import Controller.Controller;

final public class Model {

    public static ArrayList<String> getUserData(String fileName){
        ArrayList<String> user = new ArrayList();
        try(Scanner s = new Scanner(new File("User.txt"))) {
            while (s.hasNext()){
                user.add(s.next());
        }
        
        }
        catch(FileNotFoundException y){
            System.out.println("Error in 'getUserData'");
        }
        return user;
    }

    public static ArrayList<String> getPassData(String fileName){
        ArrayList<String> pass = new ArrayList();
        try{
            Scanner s = new Scanner(new File("Pass.txt"));
            while (s.hasNext()){
                pass.add(s.next());
        }
        s.close();
        
        }
        catch(FileNotFoundException y){
            System.out.println("Error in 'getPassData'");
        }
        return pass;
    }
    
    public static ArrayList<String> getAccountData(String fileName){
        ArrayList<String> account = new ArrayList();
        try{
            Scanner s = new Scanner(new File("Account.txt"));
            while (s.hasNext()){
                account.add(s.next());
        }
        s.close();
        
        }
        catch(FileNotFoundException y){
            System.out.println("Error in 'getAccountData'");
        }
        return account;
}
    public static int update(String website, String username, String password){
        int x;
        account = Model.getAccountData("Account.txt");
        user = Model.getUserData("User.txt");
        pass = Model.getPassData("Pass.txt");
        
        if(account.contains(website)){
                int j = account.indexOf(website);
                user.remove(j);
                pass.remove(j);
                account.remove(j);
                user.add(username);
                pass.add(password);
                account.add(website);
                x = 1;
            }
        
        else{
            Controller.showError();
            x = 0;
        }
        
        try(BufferedWriter out = new BufferedWriter(new FileWriter("account.txt", false))) {
        for(int i = 0; i < account.size(); i++){
            out.write(account.get(i));
            out.newLine();
        }
        
        }
        catch(IOException e){
            System.out.println("Error in delete - account fileWriter.");
        }
        
        try (BufferedWriter out = new BufferedWriter(new FileWriter("pass.txt", false))) {
                for(int i = 0; i < pass.size(); i++){
                    out.write(pass.get(i));
                    out.newLine();
                }   }
        
        
        catch(IOException e){
            System.out.println("Error in delete - pass fileWriter.");
        }
        
        try(BufferedWriter out = new BufferedWriter(new FileWriter("user.txt", false))) {
        for(int i = 0; i < user.size(); i++){
            out.write(user.get(i));
            out.newLine();
        }
        
        }
        catch(IOException e){
            e.printStackTrace();
            System.out.println("Error in delete - user fileWriter.");
        }     
        return x;
    }
    
    public static int delete(String website){
        //System.out.println("in delete");
        account = Model.getAccountData("Account.txt");
        user = Model.getUserData("User.txt");
        pass = Model.getPassData("Pass.txt");
        int x;
        
        if(account.contains(website)){
            int j = account.indexOf(website);
            user.remove(j);
            pass.remove(j);
            account.remove(j);
            x = 1;
        }
        else{
            Controller.showError();
            x = 0;
        }
            
        //}
        
        try(BufferedWriter out = new BufferedWriter(new FileWriter("account.txt", false))) {
        for(int i = 0; i < account.size(); i++){
            out.write(account.get(i));
            out.newLine();
        }
        
        }
        catch(IOException e){
            System.out.println("Error in delete - account fileWriter.");
        }
        
        try (BufferedWriter out = new BufferedWriter(new FileWriter("pass.txt", false))) {
                for(int i = 0; i < pass.size(); i++){
                    out.write(pass.get(i));
                    out.newLine();
                }   }
        
        
        catch(IOException e){
            System.out.println("Error in delete - pass fileWriter.");
        }
        
        try(BufferedWriter out = new BufferedWriter(new FileWriter("user.txt", false))) {
        for(int i = 0; i < user.size(); i++){
            out.write(user.get(i));
            out.newLine();
        }
        
        }
        catch(IOException e){
            e.printStackTrace();
            System.out.println("Error in delete - user fileWriter.");
        }     
        return x;
    }
    
    public static String getUser(){
        String users = "";
        
        try{
        Scanner sc = new Scanner(new File("User.txt"));
        while(sc.hasNext()){
            users += sc.next() + "\n";
            }
        }
        catch(FileNotFoundException e){
                System.out.println("Error in getUser");
        }
        return users;
    }
    
    public static String getPass(){
        String pass = "";
        try{
        Scanner sc = new Scanner(new File("Pass.txt"));
        while(sc.hasNext()){
            pass += sc.next() + "\n";
            
        }
        }
        catch(FileNotFoundException e){
                System.out.println("Error in getPass");
                }
        
        return pass;
    }
    
    public static String getAccount(){
        String account = "";
        try{
        Scanner sc = new Scanner(new File("Account.txt"));
        while(sc.hasNext()){
            account += sc.next() + "\n";
            
        }
        }
        catch(FileNotFoundException e){
                System.out.println("Error in getAccount");
                }
        return account;
    }
    

    
    public static void setUser(String name){
        try(BufferedWriter out = new BufferedWriter(new FileWriter("user.txt", true))) {
            
            out.write(name);
            out.newLine();
        }
        catch(IOException e){
            System.out.println("Error in setUser");
        }
        
    }
    
    public static void setPass(String pass){
        try(BufferedWriter out = new BufferedWriter(new FileWriter("pass.txt", true))) {
            out.write(pass);
            out.newLine();
        }
        catch(IOException e){
            System.out.println("Error in setPass");
        }
    }
    
    public static void setAccount(String acc){
        try(BufferedWriter out = new BufferedWriter(new FileWriter("account.txt", true))) {
            out.write(acc);
            out.newLine();
        }
        catch(IOException e){
            System.out.println("Error in setaccount");
        }
    }

    static private ArrayList<String> account = new ArrayList();
    static private ArrayList<String> user = new ArrayList();
    static private ArrayList<String> pass = new ArrayList();    
}