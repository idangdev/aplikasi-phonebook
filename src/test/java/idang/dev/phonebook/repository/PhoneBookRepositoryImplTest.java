package idang.dev.phonebook.repository;

import com.zaxxer.hikari.HikariDataSource;
import idang.dev.phonebook.entity.PhoneBook;
import idang.dev.phonebook.util.DatabaseUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PhoneBookRepositoryImplTest {

    private HikariDataSource hikariDataSource;
    private PhoneBookRepository phoneBookRepository;

    @BeforeEach
    void setUp() {
        hikariDataSource = DatabaseUtil.getDatasource();
        phoneBookRepository = new PhoneBookRepositoryImpl(hikariDataSource);
    }

    @Test
    void testAddPhoneBook() {
        phoneBookRepository.add(new PhoneBook("Mamat", "12314311"));
        phoneBookRepository.add(new PhoneBook("Memet", "13231513"));
        phoneBookRepository.add(new PhoneBook("Wildan", "11231313"));
        phoneBookRepository.add(new PhoneBook("Alf", "123131"));
    }

    @Test
    void testRemovePhoneBook() {
        System.out.println(phoneBookRepository.remove(1));
        System.out.println(phoneBookRepository.remove(2));
        System.out.println(phoneBookRepository.remove(3));
        System.out.println(phoneBookRepository.remove(4));

    }

    @Test
    void testGetAll() {
        PhoneBook[] phoneBooks = phoneBookRepository.getAll();

        for (var phoneBook : phoneBooks){
            System.out.println(phoneBook.getId() + ". " + phoneBook.getName() + " -> " + phoneBook.getNumber());
        }
    }

    @AfterEach
    void tearDown() {
        hikariDataSource.close();
    }
}
