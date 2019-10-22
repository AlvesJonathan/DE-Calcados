package DAO;

import model.ModelConta;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author contato@blsoft.com.br
*/
public class DAOConta extends ConexaoMySql {

    /**
    * grava ContaPagar
    * @param pConta
    * return int
    */
    public int salvarContaPagarDAO(ModelConta pConta){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO contas ("
                    + "fk_codigo_pessoa,"
                    + "descricao,"
                    + "data,"
                    + "vencimento,"
                    + "pagamento,"
                    + "fk_tipo_pagamento,"
                    + "observacao,"
                    + "situacao,"
                    + "valor, "
                    + "tipo_conta"
                + ") VALUES ("
                    + "'" + pConta.getCodigoPessoa() + "',"
                    + "'" + pConta.getDescricao() + "',"
                    + "'" + pConta.getData() + "',"
                    + "'" + pConta.getVencimento() + "',"
                    + "'" + pConta.getPagamento() + "',"
                    + "'" + pConta.getTipoPagamento() + "',"
                    + "'" + pConta.getObservacao() + "',"
                    + "'" + pConta.isSituacao() + "',"
                    + "'" + pConta.getValor() + "',"
                    + "'" + pConta.getTipoConta() + "'"
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
    * recupera ContaPagar
    * @param pCodigo
    * return ModelConta
    */
    public ModelConta getContaPagarDAO(int pCodigo){
        ModelConta modelConta = new ModelConta();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk_codigo,"
                    + "fk_codigo_pessoa,"
                    + "descricao,"
                    + "data,"
                    + "vencimento,"
                    + "pagamento,"
                    + "fk_tipo_pagamento,"
                    + "observacao,"
                    + "situacao,"
                    + "valor,"
                    + "tipo_conta"
                 + " FROM"
                     + " contas"
                 + " WHERE"
                     + " pk_codigo = '" + pCodigo + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelConta.setCodigo(this.getResultSet().getInt(1));
                modelConta.setCodigoPessoa(this.getResultSet().getInt(2));
                modelConta.setDescricao(this.getResultSet().getString(3));
                modelConta.setData(this.getResultSet().getDate(4));
                modelConta.setVencimento(this.getResultSet().getDate(5));
                modelConta.setPagamento(this.getResultSet().getDate(6));
                modelConta.setTipoPagamento(this.getResultSet().getInt(7));
                modelConta.setObservacao(this.getResultSet().getString(8));
                modelConta.setSituacao(this.getResultSet().getInt(9));
                modelConta.setValor(this.getResultSet().getFloat(10));
                modelConta.setTipoConta(this.getResultSet().getString(11));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelConta;
    }

    /**
    * recupera uma lista de ContaPagar
        * return ArrayList
    */
    public ArrayList<ModelConta> getListaContaPagarDAO(){
        ArrayList<ModelConta> listamodelConta = new ArrayList();
        ModelConta modelConta = new ModelConta();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk_codigo,"
                    + "fk_codigo_pessoa,"
                    + "descricao,"
                    + "data,"
                    + "vencimento,"
                    + "pagamento,"
                    + "fk_tipo_pagamento,"
                    + "observacao,"
                    + "situacao,"
                    + "valor,"
                    + "tipo_conta"
                 + " FROM"
                     + " contas"
                + ";"
            );

            while(this.getResultSet().next()){
                modelConta = new ModelConta();
                modelConta.setCodigo(this.getResultSet().getInt(1));
                modelConta.setCodigoPessoa(this.getResultSet().getInt(2));
                modelConta.setDescricao(this.getResultSet().getString(3));
                modelConta.setData(this.getResultSet().getDate(4));
                modelConta.setVencimento(this.getResultSet().getDate(5));
                modelConta.setPagamento(this.getResultSet().getDate(6));
                modelConta.setTipoPagamento(this.getResultSet().getInt(7));
                modelConta.setObservacao(this.getResultSet().getString(8));
                modelConta.setSituacao(this.getResultSet().getInt(9));
                modelConta.setValor(this.getResultSet().getFloat(10));
                modelConta.setTipoConta(this.getResultSet().getString(11));
                listamodelConta.add(modelConta);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelConta;
    }

    /**
    * recupera uma lista de ContaPagar
        * return ArrayList
    */
    public ArrayList<ModelConta> getListaContaPagarDAO(int pStatus){
        ArrayList<ModelConta> listamodelContaPagar = new ArrayList();
        ModelConta modelConta = new ModelConta();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk_codigo,"
                    + "fk_codigo_pessoa,"
                    + "descricao,"
                    + "data,"
                    + "vencimento,"
                    + "pagamento,"
                    + "fk_tipo_pagamento,"
                    + "observacao,"
                    + "situacao,"
                    + "valor, "
                    + "tipo_conta"
                 + " FROM"
                     + " contas where situacao = '"+pStatus+"'  and tipo_conta = 'PAGAR'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelConta = new ModelConta();
                modelConta.setCodigo(this.getResultSet().getInt(1));
                modelConta.setCodigoPessoa(this.getResultSet().getInt(2));
                modelConta.setDescricao(this.getResultSet().getString(3));
                modelConta.setData(this.getResultSet().getDate(4));
                modelConta.setVencimento(this.getResultSet().getDate(5));
                modelConta.setPagamento(this.getResultSet().getDate(6));
                modelConta.setTipoPagamento(this.getResultSet().getInt(7));
                modelConta.setObservacao(this.getResultSet().getString(8));
                modelConta.setSituacao(this.getResultSet().getInt(9));
                modelConta.setValor(this.getResultSet().getFloat(10));
                modelConta.setTipoConta(this.getResultSet().getString(11));
                listamodelContaPagar.add(modelConta);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelContaPagar;
    }
    
    /**
    * recupera uma lista de ContaPagar
        * return ArrayList
    */
    public ArrayList<ModelConta> getListaContaReceberDAO(int pStatus){
        ArrayList<ModelConta> listamodelContaPagar = new ArrayList();
        ModelConta modelConta = new ModelConta();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk_codigo,"
                    + "fk_codigo_pessoa,"
                    + "descricao,"
                    + "data,"
                    + "vencimento,"
                    + "pagamento,"
                    + "fk_tipo_pagamento,"
                    + "observacao,"
                    + "situacao,"
                    + "valor, "
                    + "tipo_conta"
                 + " FROM"
                     + " contas where situacao = '"+pStatus+"' AND tipo_conta = 'RECEBER'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelConta = new ModelConta();
                modelConta.setCodigo(this.getResultSet().getInt(1));
                modelConta.setCodigoPessoa(this.getResultSet().getInt(2));
                modelConta.setDescricao(this.getResultSet().getString(3));
                modelConta.setData(this.getResultSet().getDate(4));
                modelConta.setVencimento(this.getResultSet().getDate(5));
                modelConta.setPagamento(this.getResultSet().getDate(6));
                modelConta.setTipoPagamento(this.getResultSet().getInt(7));
                modelConta.setObservacao(this.getResultSet().getString(8));
                modelConta.setSituacao(this.getResultSet().getInt(9));
                modelConta.setValor(this.getResultSet().getFloat(10));
                modelConta.setTipoConta(this.getResultSet().getString(11));
                listamodelContaPagar.add(modelConta);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelContaPagar;
    }
    
    /**
    * recupera uma lista de ContaPagar
        * return ArrayList
    */
    public ArrayList<ModelConta> getListaContasDAO(int pStatus){
        ArrayList<ModelConta> listamodelContaPagar = new ArrayList();
        ModelConta modelConta = new ModelConta();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk_codigo,"
                    + "fk_codigo_pessoa,"
                    + "descricao,"
                    + "data,"
                    + "vencimento,"
                    + "pagamento,"
                    + "fk_tipo_pagamento,"
                    + "observacao,"
                    + "situacao,"
                    + "valor, "
                    + "tipo_conta"
                 + " FROM"
                     + " contas where situacao = '"+pStatus+"'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelConta = new ModelConta();
                modelConta.setCodigo(this.getResultSet().getInt(1));
                modelConta.setCodigoPessoa(this.getResultSet().getInt(2));
                modelConta.setDescricao(this.getResultSet().getString(3));
                modelConta.setData(this.getResultSet().getDate(4));
                modelConta.setVencimento(this.getResultSet().getDate(5));
                modelConta.setPagamento(this.getResultSet().getDate(6));
                modelConta.setTipoPagamento(this.getResultSet().getInt(7));
                modelConta.setObservacao(this.getResultSet().getString(8));
                modelConta.setSituacao(this.getResultSet().getInt(9));
                modelConta.setValor(this.getResultSet().getFloat(10));
                modelConta.setTipoConta(this.getResultSet().getString(11));
                listamodelContaPagar.add(modelConta);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelContaPagar;
    }
    
    /**
    * atualiza ContaPagar
    * @param pModelContaPagar
    * return boolean
    */
    public boolean atualizarContaPagarDAO(ModelConta pModelContaPagar){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE contas SET "
                    + "pk_codigo = '" + pModelContaPagar.getCodigo() + "',"
                    + "fk_codigo_pessoa = '" + pModelContaPagar.getCodigoPessoa() + "',"
                    + "descricao = '" + pModelContaPagar.getDescricao() + "',"
                    + "data = '" + pModelContaPagar.getData() + "',"
                    + "vencimento = '" + pModelContaPagar.getVencimento() + "',"
                    + "pagamento = '" + pModelContaPagar.getPagamento() + "',"
                    + "fk_tipo_pagamento = '" + pModelContaPagar.getTipoPagamento() + "',"
                    + "observacao = '" + pModelContaPagar.getObservacao() + "',"
                    + "situacao = '" + pModelContaPagar.isSituacao() + "',"
                    + "valor = '" + pModelContaPagar.getValor() + "',"
                    + "tipo_conta = '" + pModelContaPagar.getTipoConta()+ "'"
                + " WHERE "
                    + "pk_codigo = '" + pModelContaPagar.getCodigo() + "'"
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
    * atualiza ContaPagar
    * @param pModelContaPagar
    * return boolean
    */
    public boolean atualizarContaReceberDAO(ModelConta pModelContaPagar){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE contas SET "
                    + "pk_codigo = '" + pModelContaPagar.getCodigo() + "',"
                    + "fk_codigo_pessoa = '" + pModelContaPagar.getCodigoPessoa() + "',"
                    + "descricao = '" + pModelContaPagar.getDescricao() + "',"
                    + "data = '" + pModelContaPagar.getData() + "',"
                    + "vencimento = '" + pModelContaPagar.getVencimento() + "',"
                    + "pagamento = '" + pModelContaPagar.getPagamento() + "',"
                    + "fk_tipo_pagamento = '" + pModelContaPagar.getTipoPagamento() + "',"
                    + "observacao = '" + pModelContaPagar.getObservacao() + "',"
                    + "situacao = '" + pModelContaPagar.isSituacao() + "',"
                    + "valor = '" + pModelContaPagar.getValor() + "',"
                    + "tipo_conta = '" + pModelContaPagar.getTipoConta()+ "'"
                + " WHERE "
                    + "pk_codigo = '" + pModelContaPagar.getCodigo() + "'"
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
    * exclui ContaPagar
    * @param pCodigo
    * return boolean
    */
    public boolean excluirContaPagarDAO(int pCodigo){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM contas "
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

    public boolean receberContaReceberDAO(ModelConta pModelConta) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE contas SET "
                    + "pagamento = '" + pModelConta.getPagamento() + "',"
                    + "situacao = '" + pModelConta.isSituacao() + "'"
                + " WHERE "
                    + "pk_codigo = '" + pModelConta.getCodigo() + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }
    
    public boolean pagarContaPagarDAO(ModelConta pModelConta) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE contas SET "
                    + "pagamento = '" + pModelConta.getPagamento() + "',"
                    + "situacao = '" + pModelConta.isSituacao() + "'"
                + " WHERE "
                    + "pk_codigo = '" + pModelConta.getCodigo() + "'"
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