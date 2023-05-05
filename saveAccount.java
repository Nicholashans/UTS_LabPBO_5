/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utslabpbo;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class saveAccount {
    String nama;
    public static ArrayList<bankAccount> accounts = new ArrayList<bankAccount>();
    bankAccount users = new bankAccount(nama);
    
    public void setAccount(bankAccount newAccount){
        accounts.add(newAccount);
    }
    
    public void saveUserData(bankAccount account){
        accounts.add(account);
    }
    
    public int getTotalUser(){
        return accounts.size();
    }
    
    public int getAccountIndex(int accountNumber){
        
        for (int i = 0; i<accounts.size();i++){
            if(accounts.get(i).getAccountNumber() == accountNumber){
                return i;
            }
        }
        
        return -1;
    }
    
    public void updateBalance (int index, float nominal){
        bankAccount account = accounts.get(index);
        
        account.setNewBalance(nominal);
        
        accounts.set(index, account);
    } 
            
    public bankAccount isExist(int nomorrekening){
        for (int i = 0; i < accounts.size(); i++){
            if (nomorrekening == accounts.get(i).accountnumber){
                return accounts.get(i);
            }
        }
        
        return null;
    }
    
//        public bankAccount cekUsers(int nomorrekening){
//        for (int i = 0; i < accounts.size(); i++){
//                return accounts.getUserInfo();        
//        }
//        return accounts;
//        }
    
    public void userTransfer (int indexPengirim, int indexPenerima, float nominal){
        bankAccount accountPengirim = accounts.get(indexPengirim);
        bankAccount accountPenerima = accounts.get(indexPenerima);
        
        if((accountPengirim.getBalance() - nominal) < 0){
            System.out.println("Duit Pengirim Tidak Cukup!");
            return;
        }
        
        else {
            updateBalance(indexPengirim,(nominal*-1));
            updateBalance(indexPenerima,nominal);
            
            System.out.println("Uang Telah Berhasil Ditransfer dari " + accountPengirim.getName() + " ke Akun " + accountPenerima.getName());
        }
        
    }
    
}
