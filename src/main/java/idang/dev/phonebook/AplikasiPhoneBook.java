package idang.dev.phonebook;

import java.util.Scanner;

public class AplikasiPhoneBook {

    private static String[] pName = new String[10];
    private static String[] pNumber = new String[10];

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        viewShowPhoneBook();
    }

    public static void showPhoneBook(){

        System.out.println("PHONE BOOK");

        for (int i = 0; i < pName.length; i++) {
            var no = i + 1;
            var name = pName[i];
            var number = pNumber[i];

            if (pName[i] != null){
                System.out.println(no + ". " + name + " -> " + number);
            }
        }

    }

    public static void testShowPhoneBook(){
        pName[0] = "Wildan";
        pNumber[0] = "123456";
        pName[1] = "Sania";
        pNumber[1] = "123456";
        pName[2] = "Sania";
        pNumber[2] = "123456";

        showPhoneBook();
    }

    public static void addPhoneBook(String name, String number){
        var isFull = true;
        for (int i = 0; i < pName.length; i++) {
            if (pName[i] == null){
                isFull = false;
                break;
            }
        }

        if (isFull){
            var nameTemp = pName;
            var numberTemp = pNumber;

            pName = new String[pName.length * 2];
            pNumber = new String[pNumber.length * 2];

            for (int i = 0; i < nameTemp.length; i++) {
                pName[i] = nameTemp[i];
                pNumber[i] = numberTemp[i];
            }
        }

        for (int i = 0; i < pName.length; i++) {
            if (pName[i] == null){
                pName[i] = name;
                pNumber[i] = number;
                break;
            }
        }
    }

    public static void testAddPhoneBook(){
//        addPhoneBook("Wildan", "123456");
//        addPhoneBook("Slamet", "123456");
//        addPhoneBook("Nunung", "123456");

        for (int i = 0; i < 20; i++) {
            addPhoneBook("Wildan", "123456");
        }
        showPhoneBook();
    }

    public static boolean removePhoneBook(Integer number){
        if (number - 1 >= pName.length){
            return false;
        }else if (pName[number - 1] == null){
            return false;
        }else {
            for (int i = number - 1; i < pName.length; i++) {
                if (i == pName.length - 1){
                    pName[i] = null;
                    pNumber[i] = null;
                }else {
                    pName[i] = pName[i + 1];
                    pNumber[i] = pNumber[i + 1];
                }
            }
            return true;
        }
    }

    public static void testRemoveTodoList(){
        addPhoneBook("Wildan", "123456");
        addPhoneBook("Sania", "123456");
        addPhoneBook("Alfiansyah", "123456");
        addPhoneBook("Slamet", "123456");
        addPhoneBook("Nunung", "123456");
        showPhoneBook();
        removePhoneBook(2);
        showPhoneBook();
    }

    public static String input(String info){
        System.out.print(info + " : ");
        var input = scanner.nextLine();
        return input;
    }

    public static void viewShowPhoneBook(){
        while (true){
            showPhoneBook();

            System.out.println("Menu :");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");
            var input = input("Pilih");

            if (input.equals("1")){
                viewAddPhoneBook();
            }else if (input.equals("2")){
                viewRemovePhoneBook();
            }else if (input.equals("x")){
                break;
            }else {
                System.out.println("Pilihan anda tidak dimengerti");
            }
        }
    }

    public static void testViewShowPhoneBook(){
        addPhoneBook("Wildan", "123456");
        addPhoneBook("Sania", "123456");
        addPhoneBook("Alfiansyah", "123456");
        addPhoneBook("Slamet", "123456");
        viewShowPhoneBook();
    }

    public static void viewAddPhoneBook(){
        System.out.println("ADD NUMBER");

        var name = input("Nama (x jika batal)");

        if (name.equals("x")){
            // batal
        }else {
            var number = input("Nomor (x jika batal)");
            if (number.equals("x")){
                // batal
            }else {
                addPhoneBook(name, number);
            }
        }
    }

    public static void testViewAddPhoneBook(){
        addPhoneBook("Wildan", "123456");
        viewAddPhoneBook();
        showPhoneBook();
    }

    public static void viewRemovePhoneBook(){
        System.out.println("REMOVE NUMBER");

        var input = input("ID (x jika batal)");
        if (input.equals("x")){
            // batal
        }else {
            if (removePhoneBook(Integer.valueOf(input))){
                System.out.println("BERHASIL MENGHAPUS");
            }else {
                System.out.println("GAGAL MENGHAPUS");
            }
        }
    }

    public static void testViewRemovePhoneBook(){
        addPhoneBook("Wildan", "123456");
        addPhoneBook("Mamet", "123456");
        addPhoneBook("Budi", "123456");
        showPhoneBook();
        viewRemovePhoneBook();
        showPhoneBook();
    }

}
