package conexoes;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 * @author  BLSoft
 * www.Blsoft.com.br
 * Venda de software e código fonte
 */
public class ConexaoFirebird {

    private Connection con = null; //variavel para conexao
    private Statement statement;
    private ResultSet resultSet;

    private final String databaseURL = "jdbc:firebirdsql:localhost:C:\\BLVendas\\firebird\\sisvenda.fdb";
    private final String user = "sysdba"; 
    private final String password = "masterkey";
    private final String driverName = "org.firebirdsql.jdbc.FBDriver";

    /**
     * Abre uma conexao com o banco
     */
    public void conectar() {
        try {
            Class.forName(driverName).newInstance();
            this.con = DriverManager.getConnection(databaseURL, user, password);
            System.out.println("Conexão obtida com sucesso.");
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (Exception e) {
            System.out.println("Problemas ao tentar conectar com o banco de dados: " + e);
        }

    }

    public void executarSQL(String sql) {
        try {
            this.statement = con.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            this.resultSet = this.statement.executeQuery(sql);
        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
        }
    }
    
    public void executarUpdateSQL(String sql) {
        try {
            this.statement = con.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            this.statement.executeUpdate(sql);

        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
        }
    }

    /**
     * Executa insert SQL
     *     
* @param pSQL
     * @return boolean
     */
    public int insertSQL(String pSQL) {
        int idRetorno = 0;
        try {
            this.statement = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            this.resultSet = this.statement.executeQuery(pSQL);

            while (this.getResultSet().next()) {
                idRetorno = this.getResultSet().getInt(1);
            }

        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
        }
        return idRetorno;
    }

    /**
     * encerra a conexão corrente
     *     
* @return boolean
     */
    public boolean fecharConexao() {
        try {
            if ((this.getResultSet() != null) && (this.statement != null)) {
                this.getResultSet().close();
                this.statement.close();
            }
            this.getCon().close();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return false;
    }

    /**
     * @return the statement
     */
    public Statement getStatement() {
        return statement;
    }

    /**
     * @return the resultSet
     */
    public ResultSet getResultSet() {
        return resultSet;
    }

    /**
     * @return the con
     */
    public Connection getCon() {
        return con;
    }

    /**
     * @param con the con to set
     */
    public void setCon(Connection con) {
        this.con = con;
    }

    /**
     * @param statement the statement to set
     */
    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    /**
     * @param resultSet the resultSet to set
     */
    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }
}
