/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mesinpengolahdata;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author salik
 */
public class Praktikum4 {
    ArrayList<String> nama = new ArrayList<>();
    ArrayList<String> nim = new ArrayList<>();
    ArrayList<String> tglLahir = new ArrayList<>();
    ArrayList<Integer> gender = new ArrayList<>();
    
    void PilihanMenu(){
        Scanner input = new Scanner(System.in);
        while(true){
        System.out.println("Menu:");
        System.out.println("1. Tambahkan Data");
        System.out.println("2. Menghapus Data");
        System.out.println("3. Cari Data");
        System.out.println("4. Tampilkan Data");
        
        System.out.println("Pilih Nomor Menu :");
        int Menu = input.nextInt();
        switch(Menu){
            case 1:
                tambahData();
                
            case 2:
                hapusData();
                break;
            case 3:
                cariData();
                break;
            case 4:
                tampilkanData();
            break;
            default:
                /*balik ke menu*/
                System.out.println("*********************************************************************");
                System.out.println("Maaf, nomor yang anda pilih tidak ada dalam menu, silahkan coba lagi!");
                System.out.println("*********************************************************************");
                this.PilihanMenu();
            }
        }
    }
    void tambahData(){
        Scanner input = new Scanner(System.in);
        
        while(true){
            System.out.println("Masukkan Nama : ");
            nama.add(input.nextLine());
            System.out.println("Masukkan Nim : ");
            nim.add(input.nextLine());
            System.out.println("Masukkan Tanggal Lahir : ");
            tglLahir.add(input.nextLine());
            System.out.println("Pilih Gender : ");
            gender.add(input.nextInt());
            System.out.println("Nama : " + this.nama );
            System.out.println("Nim : " + this.nim );
            System.out.println("Tanggal Lahir : " + this.tglLahir );
            System.out.println("Gender : " + this.gender);
            
            input.nextLine();
            System.out.println("Input Lagi (y/n) : ");
            char data = input.nextLine().charAt(0);
            if (data == 'n'){
               this.PilihanMenu();
            }
        }
    }
    void hapusData(){
        Scanner input = new Scanner(System.in);
        
        while(true){
            System.out.println("Nama : " + this.nama );
            System.out.println("Nim : " + this.nim );
            System.out.println("Tanggal Lahir : " + this.tglLahir );
            System.out.println("Gender : " + this.gender);
            System.out.println("Pilih data yang ingin dihapus (masukkan nim) : ");
            if(this.nim.size() > 0){
                String terhapus = input.nextLine();
//                input.nextLine();
                int index = nim.indexOf(terhapus);
                if(index < 0){
                    System.out.println("");
                    System.out.println("**************************************");
                    System.out.println("      #TIDAK ADA DATA YANG COCOK.");
                    System.out.println("**************************************");
                    System.out.println("");
                       this.PilihanMenu();  
                       
                }else{
                    nim.remove(index);
                    nama.remove(index);
                    tglLahir.remove(index);
                    gender.remove(index);
                    System.out.println("");
                    System.out.println("**************************************");
                    System.out.println("        #DATA BERHASIL DIHAPUS.");
                    System.out.println("**************************************");
                    System.out.println("");
                    
                    System.out.println("Nama : " + this.nama );
                    System.out.println("Nim : " + this.nim );
                    System.out.println("Tanggal Lahir : " + this.tglLahir );
                    System.out.println("Gender : " + this.gender);
                    System.out.println("Input Lagi (y/n) : ");
//                    input.nextLine();
                    char data = input.nextLine().charAt(0);
                    if (data == 'n'){
                       this.PilihanMenu();  
                    }
                }
            }else{
                System.out.println("");
                System.out.println("******************************************");
                System.out.println("            #TIDAK ADA DATA.");
                System.out.println("******************************************");
                System.out.println("");
                   this.PilihanMenu();  
                }
            }
        }
   
    void cariData(){
        Scanner input = new Scanner(System.in);
        System.out.println("#Cara Mencari Data : ");
        System.out.println(" 1. NIM");
        System.out.println(" 2. Gender");
        System.out.print("  Masukkan Pilihan: ");
        int pilihan = input.nextInt();
        switch(pilihan){
            case 1:
                input.nextLine();
                System.out.print("  Masukkan NIM : ");
                String cari = input.nextLine();
                for(String n: nim){
                    if(nim.contains(cari)){
                        int index = nim.indexOf(cari);
                        String jenisKelamin = (gender.get(index) == 0) ? "Laki-laki" : "Perempuan";
                        System.out.println("");
                        System.out.println("===================================");
                        System.out.println("#Hail Pencarian Dengan NIM " + nim.get(index));
                        System.out.println("===================================");
                        System.out.println("Nama : " + nama.get(index));
                        System.out.println("NIM : " + nim.get(index));
                        System.out.println("Tanggal Lahir : " + tglLahir.get(index));
                        System.out.println("Gender : " + jenisKelamin);
                        System.out.println("===================================");
                        System.out.println("");
                        break;
                    }
                }
                break;
            case 2:
                input.nextLine();
                System.out.print("  Masukkan Gender(0:Laki-laki 1:Perempuan):");
                int mencari = input.nextInt();
                for(int n = 0; n < gender.size(); n++){
                    if(gender.get(n) == mencari){
                        String jenisKelamin = (gender.get(n) == 0) ? "Laki-laki" : "Perempuan";
                        System.out.println("");
                        System.out.println("===================================");
                        System.out.println("#Hasil Pencarian Berdasarkan Gender");
                        System.out.println("===================================");
                        System.out.println("Nama : " + this.nama.get(n));
                        System.out.println("NIM : " + this.nim.get(n));
                        System.out.println("Tanggal Lahir : " + this.tglLahir.get(n));
                        System.out.println("Gender : " + jenisKelamin);
                        System.out.println("===================================");
                        System.out.println("");
                    }
                }
                break;
            default:
                System.out.println("");
                System.out.println("*******************************************");
                System.out.println("Pilihan tidak tersedia, silahkan coba lagi.");
                System.out.println("*******************************************");
                System.out.println("");
                this.PilihanMenu();
            }
        }
    void tampilkanData(){ 
        Scanner input = new Scanner(System.in);
        if(nim.size() == 0){
            System.out.println("");
            System.out.println("==============================================");
            System.out.println("                #TIDAK ADA DATA.");
            System.out.println("==============================================");
            System.out.println("");
        }
        else{
            for(int n = 0; n < nim.size(); n++){
                String jenisKelamin = (gender.get(n) == 0) ? "Laki-laki" : "Perempuan";
                System.out.println("");
                System.out.println("==========================================");
                System.out.println("        #Urutan Data ke " + (n+1));
                System.out.println("==========================================");
                System.out.println("Nama : " + nama.get(n));
                System.out.println("NIM : " + nim.get(n));                
                System.out.println("Tanggal : " + tglLahir.get(n));
                System.out.println("Gender : " + jenisKelamin);
                System.out.println("==========================================");
            }
            System.out.println("Jumlah Total Mahasiswa : " + nim.size() +"\n\n");
            
            }
        }
    }
    

    
  
