package ProjetoN1;

import ProjetoN1.persistencia.CarroDAOMySQL;

import java.sql.*;
public class App {
    public static void main(final String[] args) {
        CarroDAOMySQL mysqlDAO = new CarroDAOMySQL();
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario(mysqlDAO);
        interfaceUsuario.iniciar();
    }
}