package idang.dev.phonebook.repository;

import idang.dev.phonebook.entity.PhoneBook;

public interface PhoneBookRepository {

    PhoneBook[] getAll();

    void add(PhoneBook phoneBook);

    boolean remove(Integer number);

}
