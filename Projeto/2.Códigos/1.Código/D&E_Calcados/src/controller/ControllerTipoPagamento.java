package controller;

import model.ModelTipoPagamento;
import DAO.DAOTipoPagamento;
import java.util.ArrayList;

/**
*
* @author contato@blsoft.com.br
*/
public class ControllerTipoPagamento {

    private DAOTipoPagamento daoTipoPagamento = new DAOTipoPagamento();

    /**
    * grava TipoPagamento
    * @param pModelTipoPagamento
    * return int
    */
    public int salvarTipoPagamentoController(ModelTipoPagamento pModelTipoPagamento){
        return this.daoTipoPagamento.salvarTipoPagamentoDAO(pModelTipoPagamento);
    }

    /**
    * recupera TipoPagamento
    * @param pCodigo
    * return ModelTipoPagamento
    */
    public ModelTipoPagamento getTipoPagamentoController(int pCodigo){
        return this.daoTipoPagamento.getTipoPagamentoDAO(pCodigo);
    }
    
    /**
    * recupera TipoPagamento
    * @param pNome
    * return ModelTipoPagamento
    */
    public ModelTipoPagamento getTipoPagamentoController(String pNome){
        return this.daoTipoPagamento.getTipoPagamentoDAO(pNome);
    }

    /**
    * recupera uma lista deTipoPagamento
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<ModelTipoPagamento> getListaTipoPagamentoController(){
        return this.daoTipoPagamento.getListaTipoPagamentoDAO();
    }

    /**
    * atualiza TipoPagamento
    * @param pModelTipoPagamento
    * return boolean
    */
    public boolean atualizarTipoPagamentoController(ModelTipoPagamento pModelTipoPagamento){
        return this.daoTipoPagamento.atualizarTipoPagamentoDAO(pModelTipoPagamento);
    }

    /**
    * exclui TipoPagamento
    * @param pCodigo
    * return boolean
    */
    public boolean excluirTipoPagamentoController(int pCodigo){
        return this.daoTipoPagamento.excluirTipoPagamentoDAO(pCodigo);
    }
}