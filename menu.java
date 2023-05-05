/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utslabpbo;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class menu {
    String nama;
            public static Scanner inputNomor = new Scanner(System.in);
            public static Scanner inputUser = new Scanner(System.in);
            public static Scanner inputRekening = new Scanner (System.in);
            public static Scanner inputRektujuan = new Scanner (System.in);
            public static Scanner inputNama = new Scanner (System.in);
            public static Scanner inputRekasal = new Scanner(System.in);
            public static Scanner inputNominal = new Scanner (System.in);    
            public static saveAccount save = new saveAccount();
            public static transAccount transaksi = new transAccount();
            bankAccount users = new bankAccount(nama);
            
        public void displayMenu(){
            System.out.println("========================");
            System.out.println("--------IKLC BANK-------");
            System.out.println("========================");
            System.out.println("1. Registration");
            System.out.println("2. Deposit");
            System.out.println("3. Transfer");
            System.out.println("4. Cek Data User");
            System.out.println("5. Exit");
            System.out.print("Silakan Dipilih Salah Satu Nomor \t = ");
            int nomor = inputNomor.nextInt();
        
                System.out.println("\n");

                if (nomor == 1){
                    registration();
                }

                else if (nomor == 2){
                    deposit();                  
                }
                
                else if (nomor == 3){
                    transfer();
                }
                else if (nomor == 4){
                    accountDetails();
                }
                else if (nomor == 5){
                    System.out.println("See You Again.");
                }
                else {
                    System.out.println("Nomor Tidak Ada, Silakan Ketik Angka Yang Benar");
                    displayMenu();
                }
                       
         }   
        
        public void registration(){
                    System.out.println("REGISTRATION");
                    System.out.println("============");
                    System.out.print("Masukkan nama yang mau di register\t= ");
                    String nama = inputUser.nextLine();
                    bankAccount acc1 = new bankAccount(nama);
                    acc1.displayInfo();
                    save.setAccount(acc1);
                    
                    displayMenu();
        }
        
         public void deposit(){
                    System.out.println("DEPOSIT");
                    System.out.println("=======");
                    System.out.println("Masukkan Nomor Rekening Yang Ingin di-Deposit : ");
                    int rekening = inputRekening.nextInt();

                    bankAccount myAccount = save.isExist(rekening);

                    if (myAccount != null){
                        System.out.println("Masukkan Nominal Yang Ingin Deposit");
                        float nominal = inputNominal.nextFloat();
                            if (nominal != -1){
                                myAccount.balance += nominal;
                                System.out.println("Nominal sebesar " + nominal + " telah berhasil ditambahkan ke " + myAccount.getName());
                                displayMenu();
                            }
                            
                            else {
                                System.out.println("Inputan Harus Berupa Angka");
                                deposit();
                            }
                        
                    }
                }
         
         public void transfer(){
             System.out.println("TRANSFER");
             System.out.println("=========");
             System.out.println("Masukkan Nomor Rekening Asal = ");
             int rekeningawal = inputRekasal.nextInt();
             System.out.println("Masukkan Nomor Rekening Yang Dituju = ");
             int rekeningtujuan = inputRektujuan.nextInt();
             
             System.out.println("Input Nominal Yang Ingin di-Transfer = ");
             float nominal = inputNominal.nextFloat();
             
             bankAccount myAccount1 = save.isExist(rekeningawal);
             bankAccount myAccount2 = save.isExist(rekeningtujuan);
//             
            transaksi.transfer(myAccount1.getAccountNumber(), rekeningtujuan, nominal);
//             
            displayMenu();
             
         }
         
         public void accountDetails(){
             System.out.println("ACCOUNT CHECKING");
             System.out.println("==================");
             System.out.println("Masukkan Nomor Rekening Yang Ingin Dicek");
             int rekening2 = inputRekening.nextInt();
             
             bankAccount myAccount = save.isExist(rekening2);

                    if (myAccount != null){
                        System.out.println("Akun Ditemukan!");
                        System.out.println("==============");
                        myAccount.displayInfo();     
                        displayMenu();
                    }   
                    else {
                        System.out.println("Akun Tidak Ada, silakan buat akunnya terlebih dahulu");
                        displayMenu();
                    }

         }
}
