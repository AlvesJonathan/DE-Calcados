package controller;

import model.ModelProdutos;
import DAO.DAOProdutos;
import java.util.ArrayList;
import relatorios.DAORelatorios;

/**
 * @author  BLSoft
 * www.Blsoft.com.br
 * Venda de software e código fonte
*/
public class ControllerProdutos {

    private DAOProdutos daoProdutos = new DAOProdutos();
    private DAORelatorios dAORelatorios = new DAORelatorios();
    /**
    * grava Produtos
    * @param pModelProdutos
    * return int
    */
    public int salvarProdutosController(ModelProdutos pModelProdutos){
        return this.daoProdutos.salvarProdutosDAO(pModelProdutos);
    }

    /**
    * recupera Produtos
    * @param pCodigo
    * return ModelProdutos
    */
    public ModelProdutos getProdutosController(int pCodigo){
        return this.daoProdutos.getProdutosDAO(pCodigo);
    }
    
    /**
    * recupera Produtos
    * @param pNome
    * return ModelProdutos
    */
    public ModelProdutos getProdutosController(String pNome){
        return this.daoProdutos.getProdutosDAO(pNome);
    }

    /**
    * recupera uma lista deProdutos
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<ModelProdutos> getListaProdutosController(){
        return this.daoProdutos.getListaProdutosDAO();
    }

    /**
    * atualiza Produtos
    * @param pModelProdutos
    * return boolean
    */
    public boolean atualizarProdutosController(ModelProdutos pModelProdutos){
        return this.daoProdutos.atualizarProdutosDAO(pModelProdutos);
    }

    /**
    * exclui Produtos
    * @param pCodigo
    * return boolean
    */
    public boolean excluirProdutosController(int pCodigo){
        return this.daoProdutos.excluirProdutosDAO(pCodigo);
    }

    /**
    * atualiza Produtos
    * @param pModelProdutos
    * return boolean
    */
    public boolean atualizarProdutosQuantidadeController(ModelProdutos pModelProdutos){
        return this.daoProdutos.atualizarProdutosQuantidadeDAO(pModelProdutos);
    }

    public boolean gerarRelatorioProdutos() {
        return this.dAORelatorios.gerarRelatorioProdutos();
    }

    public ModelProdutos getProdutosCodigoBarrasController(String pCodigoBarras) {
        return this.daoProdutos.getProdutosCodigoBarrasDAO(pCodigoBarras);
    }
    
}