package DAO;

import model.ModelTipoPagamento;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author contato@blsoft.com.br
*/
public class DAOTipoPagamento extends ConexaoMySql {

    /**
    * grava TipoPagamento
    * @param pModelTipoPagamento
    * return int
    */
    public int salvarTipoPagamentoDAO(ModelTipoPagamento pModelTipoPagamento){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO tipo_pagamento ("
                    + "descricao"
                + ") VALUES ("
                    + "'" + pModelTipoPagamento.getDescricao() + "'"
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
    * recupera TipoPagamento
    * @param pCodigo
    * return ModelTipoPagamento
    */
    public ModelTipoPagamento getTipoPagamentoDAO(int pCodigo){
        ModelTipoPagamento modelTipoPagamento = new ModelTipoPagamento();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk_codigo,"
                    + "descricao"
                 + " FROM"
                     + " tipo_pagamento"
                 + " WHERE"
                     + " pk_codigo = '" + pCodigo + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelTipoPagamento.setCodigo(this.getResultSet().getInt(1));
                modelTipoPagamento.setDescricao(this.getResultSet().getString(2));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelTipoPagamento;
    }
    
    /**
    * recupera TipoPagamento
    * @param pNome
    * return ModelTipoPagamento
    */
    public ModelTipoPagamento getTipoPagamentoDAO(String pNome){
        ModelTipoPagamento modelTipoPagamento = new ModelTipoPagamento();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk_codigo,"
                    + "descricao"
                 + " FROM"
                     + " tipo_pagamento"
                 + " WHERE"
                     + " descricao = '" + pNome + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelTipoPagamento.setCodigo(this.getResultSet().getInt(1));
                modelTipoPagamento.setDescricao(this.getResultSet().getString(2));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelTipoPagamento;
    }

    /**
    * recupera uma lista de TipoPagamento
        * return ArrayList
    */
    public ArrayList<ModelTipoPagamento> getListaTipoPagamentoDAO(){
        ArrayList<ModelTipoPagamento> listamodelTipoPagamento = new ArrayList();
        ModelTipoPagamento modelTipoPagamento = new ModelTipoPagamento();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk_codigo,"
                    + "descricao"
                 + " FROM"
                     + " tipo_pagamento"
                + ";"
            );

            while(this.getResultSet().next()){
                modelTipoPagamento = new ModelTipoPagamento();
                modelTipoPagamento.setCodigo(this.getResultSet().getInt(1));
                modelTipoPagamento.setDescricao(this.getResultSet().getString(2));
                listamodelTipoPagamento.add(modelTipoPagamento);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelTipoPagamento;
    }

    /**
    * atualiza TipoPagamento
    * @param pModelTipoPagamento
    * return boolean
    */
    public boolean atualizarTipoPagamentoDAO(ModelTipoPagamento pModelTipoPagamento){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE tipo_pagamento SET "
                    + "pk_codigo = '" + pModelTipoPagamento.getCodigo() + "',"
                    + "descricao = '" + pModelTipoPagamento.getDescricao() + "'"
                + " WHERE "
                    + "pk_codigo = '" + pModelTipoPagamento.getCodigo() + "'"
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
    * exclui TipoPagamento
    * @param pCodigo
    * return boolean
    */
    public boolean excluirTipoPagamentoDAO(int pCodigo){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM tipo_pagamento "
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