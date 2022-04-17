package idang.dev.phonebook;

import idang.dev.phonebook.repository.PhoneBookRepository;
import idang.dev.phonebook.repository.PhoneBookRepositoryImpl;
import idang.dev.phonebook.service.PhoneBookService;
import idang.dev.phonebook.service.PhoneBookServiceImpl;
import idang.dev.phonebook.util.DatabaseUtil;
import idang.dev.phonebook.view.PhoneBookView;

import javax.sql.DataSource;

public class AplikasiPhoneBookV2 {

    public static void main(String[] args) {

        DataSource dataSource = DatabaseUtil.getDatasource();
        PhoneBookRepository phoneBookRepository = new PhoneBookRepositoryImpl(dataSource);
        PhoneBookService phoneBookService = new PhoneBookServiceImpl(phoneBookRepository);
        PhoneBookView phoneBookView = new PhoneBookView(phoneBookService);

        phoneBookView.showPhoneBook();

    }

}
