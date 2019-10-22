package model;

import java.util.ArrayList;

/**
 * @author  BLSoft
 * www.Blsoft.com.br
 * Venda de software e código fonte
*/
public class ModelProdutos {

    private int codigo;
    private int fornecedoresCodigo;
    private String nome;
    private Double valor;
    private int estoque;
    private String codigoBarras;
    private ArrayList<ModelProdutos> listaModelProdutoses;

    /**
    * Construtor
    */
    public ModelProdutos(){}

    /**
    * seta o valor de codigo
    * @param pCodigo
    */
    public void setCodigo(int pCodigo){
        this.codigo = pCodigo;
    }
    /**
    * return codigo
    */
    public int getCodigo(){
        return this.codigo;
    }

    /**
    * seta o valor de fornecedoresCodigo
    * @param pFornecedores_codigo
    */
    public void setFornecedoresCodigo(int pFornecedores_codigo){
        this.fornecedoresCodigo = pFornecedores_codigo;
    }
    /**
    * return fornecedoresCodigo
    */
    public int getFornecedoresCodigo(){
        return this.fornecedoresCodigo;
    }

    /**
    * seta o valor de nome
    * @param pNome
    */
    public void setNome(String pNome){
        this.nome = pNome;
    }
    /**
    * return nome
    */
    public String getNome(){
        return this.nome;
    }

    /**
    * seta o valor de valor
    * @param pValor
    */
    public void setValor(Double pValor){
        this.valor = pValor;
    }
    /**
    * return valor
    */
    public Double getValor(){
        return this.valor;
    }

    /**
    * seta o valor de estoque
    * @param pEstoque
    */
    public void setEstoque(int pEstoque){
        this.estoque = pEstoque;
    }
    /**
    * return estoque
    */
    public int getEstoque(){
        return this.estoque;
    }

    @Override
    public String toString(){
        return "ModelProdutos {" + "::codigo = " + this.codigo + "::fornecedores_codigo = " + this.fornecedoresCodigo + "::nome = " + this.nome + "::valor = " + this.valor + "::estoque = " + this.estoque +  "}";
    }

    /**
     * @return the listaModelProdutoses
     */
    public ArrayList<ModelProdutos> getListaModelProdutoses() {
        return listaModelProdutoses;
    }

    /**
     * @param listaModelProdutoses the listaModelProdutoses to set
     */
    public void setListaModelProdutoses(ArrayList<ModelProdutos> listaModelProdutoses) {
        this.listaModelProdutoses = listaModelProdutoses;
    }

    /**
     * @return the codigoBarras
     */
    public String getCodigoBarras() {
        return codigoBarras;
    }

    /**
     * @param codigoBarras the codigoBarras to set
     */
    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }
}