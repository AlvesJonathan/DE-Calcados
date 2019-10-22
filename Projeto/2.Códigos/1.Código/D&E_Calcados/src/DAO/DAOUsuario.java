package DAO;

import model.ModelUsuario;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Leandro
*/
public class DAOUsuario extends ConexaoMySql {

    /**
    * grava Usuario
    * @param pModelUsuario
    * return int
    */
    public int salvarUsuarioDAO(ModelUsuario pModelUsuario){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO tbl_usuarios ("
                    + "nome,"
                    + "login,"
                    + "senha"
                + ") VALUES ("
                    + "'" + pModelUsuario.getNome() + "',"
                    + "'" + pModelUsuario.getLogin() + "',"
                    + "'" + pModelUsuario.getSenha() + "'"
                + ");"
            );
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * recupera Usuario
    * @param pCodigo
    * return ModelUsuario
    */
    public ModelUsuario getUsuarioDAO(int pCodigo){
        ModelUsuario modelUsuario = new ModelUsuario();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk_codigo,"
                    + "nome,"
                    + "login,"
                    + "senha"
                 + " FROM"
                     + " tbl_usuarios"
                 + " WHERE"
                     + " pk_codigo = '" + pCodigo + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelUsuario.setCodigo(this.getResultSet().getInt(1));
                modelUsuario.setNome(this.getResultSet().getString(2));
                modelUsuario.setLogin(this.getResultSet().getString(3));
                modelUsuario.setSenha(this.getResultSet().getString(4));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelUsuario;
    }

    /**
    * recupera Usuario
    * @param pLogin
    * return ModelUsuario
    */
    public ModelUsuario getUsuarioDAO(String pLogin){
        ModelUsuario modelUsuario = new ModelUsuario();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk_codigo,"
                    + "nome,"
                    + "login,"
                    + "senha"
                 + " FROM"
                     + " tbl_usuarios"
                 + " WHERE"
                     + " login = '" + pLogin + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelUsuario.setCodigo(this.getResultSet().getInt(1));
                modelUsuario.setNome(this.getResultSet().getString(2));
                modelUsuario.setLogin(this.getResultSet().getString(3));
                modelUsuario.setSenha(this.getResultSet().getString(4));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelUsuario;
    }
    
    /**
    * recupera Usuario
    * @param pCodigo
    * return ModelUsuario
    */
    public boolean getUsuarioDAO(ModelUsuario pModelUsuario){       
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_codigo,"
                    + "nome,"
                    + "login,"
                    + "senha"
                    + " FROM"
                    + " tbl_usuarios"
                    + " WHERE"
                    + " login = '" + pModelUsuario.getLogin()+ "' AND senha = '" + pModelUsuario.getSenha() + "' "
                    + ";"
            );

            if (getResultSet().next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }      
    }
    
    /**
    * recupera uma lista de Usuario
        * return ArrayList
    */
    public ArrayList<ModelUsuario> getListaUsuarioDAO(){
        ArrayList<ModelUsuario> listamodelUsuario = new ArrayList();
        ModelUsuario modelUsuario = new ModelUsuario();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk_codigo,"
                    + "nome,"
                    + "login,"
                    + "senha"
                 + " FROM"
                     + " tbl_usuarios"
                + ";"
            );

            while(this.getResultSet().next()){
                modelUsuario = new ModelUsuario();
                modelUsuario.setCodigo(this.getResultSet().getInt(1));
                modelUsuario.setNome(this.getResultSet().getString(2));
                modelUsuario.setLogin(this.getResultSet().getString(3));
                modelUsuario.setSenha(this.getResultSet().getString(4));
                listamodelUsuario.add(modelUsuario);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelUsuario;
    }

    /**
    * atualiza Usuario
    * @param pModelUsuario
    * return boolean
    */
    public boolean atualizarUsuarioDAO(ModelUsuario pModelUsuario){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE tbl_usuarios SET "
                    + "pk_codigo = '" + pModelUsuario.getCodigo() + "',"
                    + "nome = '" + pModelUsuario.getNome() + "',"
                    + "login = '" + pModelUsuario.getLogin() + "',"
                    + "senha = '" + pModelUsuario.getSenha() + "'"
                + " WHERE "
                    + "pk_codigo = '" + pModelUsuario.getCodigo() + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * exclui Usuario
    * @param pCodigo
    * return boolean
    */
    public boolean excluirUsuarioDAO(int pCodigo){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM tbl_usuarios "
                + " WHERE "
                    + "pk_codigo = '" + pCodigo + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }
}