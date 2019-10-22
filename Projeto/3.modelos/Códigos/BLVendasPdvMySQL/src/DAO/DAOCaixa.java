package DAO;

import model.ModelCaixa;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author contato@blsoft.com.br
*/
public class DAOCaixa extends ConexaoMySql {

    /**
    * grava Caixa
    * @param pModelCaixa
    * return int
    */
    public int salvarCaixaDAO(ModelCaixa pModelCaixa){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO caixa ("
                    + "codigo,"
                    + "dinheiro,"
                    + "cheque,"
                    + "cartao,"
                    + "vale"
                + ") VALUES ("
                    + "'" + pModelCaixa.getCodigo() + "',"
                    + "'" + pModelCaixa.getDinheiro() + "',"
                    + "'" + pModelCaixa.getCheque() + "',"
                    + "'" + pModelCaixa.getCartao() + "',"
                    + "'" + pModelCaixa.getVale() + "'"
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
    * recupera Caixa
    * @param pCodigo
    * return ModelCaixa
    */
    public ModelCaixa getCaixaDAO(int pCodigo){
        ModelCaixa modelCaixa = new ModelCaixa();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "dinheiro,"
                    + "cheque,"
                    + "cartao,"
                    + "vale"
                 + " FROM"
                     + " caixa"
                 + " WHERE"
                     + " codigo = '" + pCodigo + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelCaixa.setCodigo(this.getResultSet().getInt(1));
                modelCaixa.setDinheiro(this.getResultSet().getFloat(2));
                modelCaixa.setCheque(this.getResultSet().getFloat(3));
                modelCaixa.setCartao(this.getResultSet().getFloat(4));
                modelCaixa.setVale(this.getResultSet().getFloat(5));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelCaixa;
    }

    /**
    * recupera uma lista de Caixa
        * return ArrayList
    */
    public ArrayList<ModelCaixa> getListaCaixaDAO(){
        ArrayList<ModelCaixa> listamodelCaixa = new ArrayList();
        ModelCaixa modelCaixa = new ModelCaixa();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "dinheiro,"
                    + "cheque,"
                    + "cartao,"
                    + "vale"
                 + " FROM"
                     + " caixa"
                + ";"
            );

            while(this.getResultSet().next()){
                modelCaixa = new ModelCaixa();
                modelCaixa.setCodigo(this.getResultSet().getInt(1));
                modelCaixa.setDinheiro(this.getResultSet().getFloat(2));
                modelCaixa.setCheque(this.getResultSet().getFloat(3));
                modelCaixa.setCartao(this.getResultSet().getFloat(4));
                modelCaixa.setVale(this.getResultSet().getFloat(5));
                listamodelCaixa.add(modelCaixa);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelCaixa;
    }

    /**
    * atualiza Caixa
    * @param pModelCaixa
    * return boolean
    */
    public boolean atualizarCaixaDAO(ModelCaixa pModelCaixa){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE caixa SET "
                    + "codigo = '" + pModelCaixa.getCodigo() + "',"
                    + "dinheiro = '" + pModelCaixa.getDinheiro() + "',"
                    + "cheque = '" + pModelCaixa.getCheque() + "',"
                    + "cartao = '" + pModelCaixa.getCartao() + "',"
                    + "vale = '" + pModelCaixa.getVale() + "'"
                + " WHERE "
                    + "codigo = '" + pModelCaixa.getCodigo() + "'"
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
    * exclui Caixa
    * @param pCodigo
    * return boolean
    */
    public boolean excluirCaixaDAO(int pCodigo){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM caixa "
                + " WHERE "
                    + "codigo = '" + pCodigo + "'"
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