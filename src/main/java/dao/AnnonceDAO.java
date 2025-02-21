package dao;

import bean.Annonce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AnnonceDAO extends DAO<Annonce> {

    public AnnonceDAO(Connection con) {
        super(con);
    }

    @Override
    public boolean create(Annonce annonce) {
        try {

            PreparedStatement preparedStatement = this.conn.prepareStatement("INSERT INTO annonce (title, description, adress, mail, date) values (?, ?, ?, ?, ?)");

            preparedStatement.setString(1, annonce.getTitle());
            preparedStatement.setString(2, annonce.getDescription());
            preparedStatement.setString(3, annonce.getAdresse());
            preparedStatement.setString(4, annonce.getEmail());
            preparedStatement.setTimestamp(5, annonce.getDate());

            preparedStatement.executeUpdate();

            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Annonce read(int id) {

        Annonce annonce = new Annonce();
        try {
            ResultSet resultSet = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * from annonce where id = " + id);

            if(resultSet.first()) {
                annonce = new Annonce(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getString("description"), resultSet.getString("adress"), resultSet.getString("mail"), resultSet.getTimestamp("date"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return annonce;
    }

    @Override
    public ArrayList<Annonce> readAll() {
        ArrayList<Annonce> annonces = new ArrayList<>();

        try {
            ResultSet resultSet = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * from annonce");

            while (resultSet.next()) {
                Annonce annonce = new Annonce(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getString("description"), resultSet.getString("adress"), resultSet.getString("mail"), resultSet.getTimestamp("date"));
                annonces.add(annonce);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return annonces;

    }

    @Override
    public boolean update(Annonce annonce) {
        try {
            PreparedStatement preparedStatement = this.conn.prepareStatement("update annonce set title = ?, description = ?, adress = ?, mail = ?, date = ? where id = ?");

            preparedStatement.setString(1, annonce.getTitle());
            preparedStatement.setString(2, annonce.getDescription());
            preparedStatement.setString(3, annonce.getAdresse());
            preparedStatement.setString(4, annonce.getEmail());
            preparedStatement.setTimestamp(5, annonce.getDate());
            preparedStatement.setInt(6, annonce.getId());

            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(int id) {
        try {
            this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate("DELETE FROM annonce where id = " + id);
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
