package controller;

import model.ModelFornecedor;
import DAO.DAOFornecedor;
import java.util.ArrayList;
import relatorios.DAORelatorios;

/**
 * @author  BLSoft
 * www.Blsoft.com.br
 * Venda de software e código fonte
*/
public class ControllerFornecedor {

    private DAOFornecedor daoFornecedor = new DAOFornecedor();
    private DAORelatorios dAORelatorios = new DAORelatorios();

    /**
    * grava Fornecedor
    * @param pModelFornecedor
    * return int
    */
    public int salvarFornecedorController(ModelFornecedor pModelFornecedor){
        return this.daoFornecedor.salvarFornecedorDAO(pModelFornecedor);
    }

    /**
    * recupera Fornecedor
    * @param pCodigo
    * return ModelFornecedor
    */
    public ModelFornecedor getFornecedorController(int pCodigo){
        return this.daoFornecedor.getFornecedorDAO(pCodigo);
    }
    
    /**
    * recupera Fornecedor
    * @param pNome
    * return ModelFornecedor
    */
    public ModelFornecedor getFornecedorController(String pNome){
        return this.daoFornecedor.getFornecedorDAO(pNome);
    }

    /**
    * recupera uma lista deFornecedor
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<ModelFornecedor> getListaFornecedorController(){
        return this.daoFornecedor.getListaFornecedorDAO();
    }

    /**
    * atualiza Fornecedor
    * @param pModelFornecedor
    * return boolean
    */
    public boolean atualizarFornecedorController(ModelFornecedor pModelFornecedor){
        return this.daoFornecedor.atualizarFornecedorDAO(pModelFornecedor);
    }

    /**
    * exclui Fornecedor
    * @param pCodigo
    * return boolean
    */
    public boolean excluirFornecedorController(int pCodigo){
        return this.daoFornecedor.excluirFornecedorDAO(pCodigo);
    }

    public boolean gerarRelatorioFornecedor() {
        return this.dAORelatorios.gerarRelatorioFornecedores();
    }
}