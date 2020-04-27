package ProjetoN1.persistencia;

import ProjetoN1.entidade.Computador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComputadorDAOMySQL implements ComputadorDAO {
    private String createSQL = "INSERT INTO computador(marca,processador,quantidade_de_ram,tamanho_do_disco) VALUES (?, ?, ?, ?)";
    private String readSQL = "SELECT * FROM computador";
    private String updateSQL = "UPDATE computador SET marca=?, processador=?, quantidade_de_ram=?, tamanho_do_disco=? WHERE id=?";
    private String deleteSQL = "DELETE FROM computador WHERE id=?";

    private final MySQLConnection mysql = new MySQLConnection();

    @Override
    public boolean create(Computador computador) {
        Connection conexao = mysql.getConnection();
        try {
            PreparedStatement stm = conexao.prepareStatement(createSQL);
            stm.setString(1, computador.getMarca());
            stm.setString(2, computador.getProcessador());
            stm.setInt(3, computador.getQuantidade_de_ram());
            stm.setInt(4, computador.getTamanho_do_disco());
            int registros = stm.executeUpdate();
            return  registros > 0 ? true : false;
        }
        catch (final SQLException ex) {
            System.out.println("Falha de conexão com a base de dados!");
            ex.printStackTrace();
        }
        catch (final Exception ex) {
            ex.printStackTrace();
        }
        finally {
            try {
                conexao.close();
            }
            catch (final Exception ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }
    @Override
    public List<Computador> read() {
        Connection conexao = mysql.getConnection();
        List<Computador> computadores = new ArrayList();
        try {
            PreparedStatement stm = conexao.prepareStatement(readSQL);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Computador computador = new Computador();
                computador.setId(rs.getLong("id"));
                computador.setMarca(rs.getString("marca"));
                computador.setProcessador(rs.getString("processador"));
                computador.setQuantidade_de_ram(rs.getInt("quantidade_de_ram"));
                computador.setTamanho_do_disco(rs.getInt("tamanho_do_disco"));
                computadores.add(computador);
            }
            return computadores;
        }
        catch (final SQLException ex) {
            System.out.println("Falha de conexão com a base de dados!");
            ex.printStackTrace();
        }
        catch (final Exception ex) {
            ex.printStackTrace();
        }
        finally {
            try {
                conexao.close();
            }
            catch (final Exception ex) {
                ex.printStackTrace();
            }
        }
        return computadores;
    }
    @Override
    public boolean update(Computador computador) {
        Connection conexao = mysql.getConnection();
        int registros=-1;
        try {
            PreparedStatement stm = conexao.prepareStatement(updateSQL);
            stm.setString(1, computador.getMarca());
            stm.setString(2, computador.getProcessador());
            stm.setInt(3, computador.getQuantidade_de_ram());
            stm.setInt(4, computador.getTamanho_do_disco());
            stm.setLong(5, computador.getId());
            registros = stm.executeUpdate();
        }
        catch (final SQLException ex) {
            System.out.println("Falha de conexão com a base de dados!");
            ex.printStackTrace();
        }
        catch (final Exception ex) {
            ex.printStackTrace();
        }
        finally {
            try {
                conexao.close();
            }
            catch (final Exception ex) {
                ex.printStackTrace();
            }
        }
        return  registros > 0 ? true : false;
    }
    @Override
    public boolean delete(Computador computador) {
        Connection conexao = mysql.getConnection();
        try {
            PreparedStatement stm = conexao.prepareStatement(deleteSQL);
            stm.setLong(1, computador.getId());
            int registros = stm.executeUpdate();
            return  registros > 0 ? true : false;
        }
        catch (final SQLException ex) {
            System.out.println("Falha de conexão com a base de dados!");
            ex.printStackTrace();
        }
        catch (final Exception ex) {
            ex.printStackTrace();
        }
        finally {
            try {
                conexao.close();
            }
            catch (final Exception ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }
}