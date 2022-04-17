package idang.dev.phonebook.service;

public interface PhoneBookService {

    void showPhoneBook();

    void addPhoneBook(String name, String number);

    void removePhoneBook(Integer number);

}
