package com.jsu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection{
    //����SQLServer���ݿ���������
    private static final String DBRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    //����SQLServer���ݿ����ӵ�ַ��testdb�ɸĳ��Լ������ݿ�����
    private static final String DBURL="jdbc:sqlserver://localhost:1433;DatabaseName=Java�γ����";
    private static final String DBUSER="CPHDL"; //SQLServer���ݿ������û���
    private static final String PASSWORD="CPH5513."; //SQLServer���ݿ���������
    private Connection conn=null; //�������Ӷ���
    public DatabaseConnection(){//���췽���������ݿ�
        try {
            Class.forName(DBRIVER);
            this.conn=DriverManager.getConnection(DBURL,DBUSER,PASSWORD);
        } catch (Exception e) {e.printStackTrace();}
    }
    public Connection getConnection() {//�������ݿ����Ӷ���
        return this.conn;
    }
    public void close() {//�ر���������
        if(this.conn!=null) {
            try {
                this.conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

