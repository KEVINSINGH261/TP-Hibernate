package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;

public abstract class DAO<Object> {

    protected Connection conn = null;

    public DAO(Connection conn) {
        this.conn = conn;
    }

    public abstract boolean create(Object obj) throws SQLException;

    public abstract Object read(int id);

    public abstract ArrayList<Object> readAll();

    public abstract boolean update(Object obj);

    public abstract boolean delete(int id);
}
