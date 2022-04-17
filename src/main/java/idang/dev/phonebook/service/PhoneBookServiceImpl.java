package idang.dev.phonebook.service;

import idang.dev.phonebook.entity.PhoneBook;
import idang.dev.phonebook.repository.PhoneBookRepository;

public class PhoneBookServiceImpl implements PhoneBookService{

    private PhoneBookRepository phoneBookRepository;

    public PhoneBookServiceImpl(PhoneBookRepository phoneBookRepository) {
        this.phoneBookRepository = phoneBookRepository;
    }

    @Override
    public void showPhoneBook() {

        var model = phoneBookRepository.getAll();

        System.out.println("PHONE BOOK");

        for (int i = 0; i < model.length; i++) {
            var phoneBooks = model[i];

            if (model[i] != null){
                System.out.println(phoneBooks.getId() + ". " + phoneBooks.getName() + " -> " + phoneBooks.getNumber());
            }
        }
    }

    @Override
    public void addPhoneBook(String name, String number) {

        phoneBookRepository.add(new PhoneBook(name, number));

    }

    @Override
    public void removePhoneBook(Integer number) {
        if (phoneBookRepository.remove(number)){
            System.out.println("SUKSES MENGHAPUS NOMOR " + number);
        }else {
            System.out.println("GAGAL MENGHAPUS NOMOR " + number);
        }

    }
}
