package idang.dev.phonebook.view;

import idang.dev.phonebook.service.PhoneBookService;
import idang.dev.phonebook.util.InputUtil;

public class PhoneBookView {

    PhoneBookService phoneBookService;

    public PhoneBookView(PhoneBookService phoneBookService) {
        this.phoneBookService = phoneBookService;
    }

    public void showPhoneBook(){
        while (true){
            phoneBookService.showPhoneBook();

            System.out.println("Menu :");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");
            var input = InputUtil.input("Pilih");

            if (input.equals("1")){
                addPhoneBook();
            }else if (input.equals("2")){
                removePhoneBook();
            }else if (input.equals("x")){
                break;
            }else {
                System.out.println("Pilihan anda tidak dimengerti");
            }
        }
    }

    public void addPhoneBook(){
        System.out.println("ADD NUMBER");

        var name = InputUtil.input("Nama (x jika batal)");

        if (name.equals("x")){
            // batal
        }else {
            var number = InputUtil.input("Nomor (x jika batal)");
            if (number.equals("x")){
                // batal
            }else {
                phoneBookService.addPhoneBook(name, number);
            }
        }
    }

    public void removePhoneBook(){
        System.out.println("REMOVE NUMBER");

        var input = InputUtil.input("ID (x jika batal)");
        if (input.equals("x")){
            // batal
        }else {
            phoneBookService.removePhoneBook(Integer.valueOf(input));
        }
    }

}
