/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utslabpbo;

/**
 *
 * @author ASUS
 */
public class transAccount {
    
        String nama;
           saveAccount accounts = new saveAccount();
           bankAccount users = new bankAccount(nama);
    
        public void deposit(int accountNumber, float nominal){
            int index = accounts.getAccountIndex(accountNumber);
            
            if(index >= 0){
                accounts.updateBalance(index, nominal);
            }
            
            else{
                System.out.println("User Tidak Ditemukan");
            }
        }
        
        public void transfer(int pengirim, int penerima, float nominal){
            int indexPengirim = accounts.getAccountIndex(pengirim);
            int indexPenerima = accounts.getAccountIndex(penerima);
            
            if (indexPengirim < 0 || indexPenerima < 0){
                System.out.println("Maaf, Salah Satu Nomor Rekening INVALID");
                return;
            }
            
            else{
                accounts.userTransfer(indexPengirim, indexPenerima, nominal);
            }


//        bankAccount accountPengirim = null;
//        bankAccount accountPenetima = null;

        
        }
}
