/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utslabpbo;
import java.util.Random;
import java.util.Date;
import java.util.Scanner;
/**
 *
 * @author ASUS
 */
public class bankAccount {
    String name;
    String account;
    float balance;
    int accountnumber;
    String date;
    
    public bankAccount(String name){
        this.name = name;
        this.balance = 0;
        setAccountNumber();
        setDate();
    }
    
    
    public void setDate(){
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat SDF = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = SDF.format(dt);
        this.date =  currentTime;
    }
    
    public void setAccountNumber(){
         Random rand = new Random();
         int randomNum = rand.nextInt(900000) + 100000;
         this.accountnumber = randomNum;
//         System.out.println("Random 6-digit number: " + randomNum);
    }
    
        public String getName(){
            return this.name;
    }
        
        public int getAccountNumber(){
            return this.accountnumber;
        }
        
        public void setNewBalance(float input){
            balance = balance + input;
        }
        
        
        public float getBalance(){
            return this.balance;
        }
        
        public void displayInfo(){
            System.out.println("Name \t \t \t : " +this.name);
            System.out.println("Balance \t \t : Rp. "+this.balance);
            System.out.println("Account Number \t \t : "+this.accountnumber);
            System.out.println("Registration Date \t : "+this.date);
        }
        
        public void getUserInfo(){
            getName();
            getAccountNumber();
            getBalance();
        }
        
        
}






