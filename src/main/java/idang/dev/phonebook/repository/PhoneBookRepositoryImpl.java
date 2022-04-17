package idang.dev.phonebook.repository;

import idang.dev.phonebook.entity.PhoneBook;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneBookRepositoryImpl implements PhoneBookRepository{

    private DataSource dataSource;

    public PhoneBookRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public PhoneBook[] getAll() {
        String sql = "SELECT * FROM phonebook";

        try(Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)){

            List<PhoneBook> lists = new ArrayList<>();
            while (resultSet.next()){
                PhoneBook phoneBooks = new PhoneBook();
                phoneBooks.setId(resultSet.getInt("id"));
                phoneBooks.setName(resultSet.getString("name"));
                phoneBooks.setNumber(resultSet.getString("number"));

                lists.add(phoneBooks);
            }

            return lists.toArray(new PhoneBook[]{});
        }catch (SQLException exception){
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void add(PhoneBook phoneBook) {

        String sql = "INSERT INTO phonebook (name, number) VALUES (?, ?)";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setString(1, phoneBook.getName());
            preparedStatement.setString(2, phoneBook.getNumber());
            preparedStatement.executeUpdate();

        }catch (SQLException exception){
            throw new RuntimeException(exception);
        }

    }

    private boolean isExists(Integer number) {
        String sql = "SELECT * FROM phonebook WHERE id = ?";

        try(Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setInt(1, number);
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                if (resultSet.next()){
                    return true;
                }else {
                    return false;
                }
            }

        }catch (SQLException exception){
            throw new RuntimeException(exception);
        }
    }

    @Override
    public boolean remove(Integer number) {

        if (isExists(number)){
            String sql = "DELETE FROM phonebook WHERE id = ?";

            try(Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)){

                preparedStatement.setInt(1, number);
                preparedStatement.executeUpdate();

                return true;
            }catch (SQLException exception){
                throw new RuntimeException(exception);
            }
        }else {
            return false;
        }

    }
}
