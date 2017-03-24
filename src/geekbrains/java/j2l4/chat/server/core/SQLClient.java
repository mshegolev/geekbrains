package geekbrains.java.j2l4.chat.server.core;

import java.sql.*;

/**
 * Created by myname on 23.03.17.
 */
public class SQLClient {

    private static Connection connection;
    private static Statement statement;

    synchronized static void connect(){
        try
        {Class.forName("org.sqllite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqllite:chat_db.sqlite");
            statement=connection.createStatement();
        } catch (ClassNotFoundException | SQLException e ){
            throw new RuntimeException(e);
        }
    }

    synchronized static void disconnect(){
        try{
            connection.close();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    synchronized static String getNick(String login, String pass){
        String request = "select nickname from user where login='"+login+"' and password='"+pass+"'";
        try {
            ResultSet resultSet = statement.executeQuery(request);
            if (resultSet.next()) {
                String nickname = resultSet.getString(1);
                return nickname;
            } else {
                return null;
            }
        }catch (SQLException e ){
            throw new RuntimeException(e);
        }
        }
    }


