package model;
/**
*
* @author contato@blsoft.com.br
*/
public class ModelCaixa {

    private int codigo;
    private float dinheiro;
    private float cheque;
    private float cartao;
    private float vale;

    /**
    * Construtor
    */
    public ModelCaixa(){}

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
    * seta o valor de dinheiro
    * @param pDinheiro
    */
    public void setDinheiro(float pDinheiro){
        this.dinheiro = pDinheiro;
    }
    /**
    * return dinheiro
    */
    public float getDinheiro(){
        return this.dinheiro;
    }

    /**
    * seta o valor de cheque
    * @param pCheque
    */
    public void setCheque(float pCheque){
        this.cheque = pCheque;
    }
    /**
    * return cheque
    */
    public float getCheque(){
        return this.cheque;
    }

    /**
    * seta o valor de cartao
    * @param pCartao
    */
    public void setCartao(float pCartao){
        this.cartao = pCartao;
    }
    /**
    * return cartao
    */
    public float getCartao(){
        return this.cartao;
    }

    /**
    * seta o valor de vale
    * @param pVale
    */
    public void setVale(float pVale){
        this.vale = pVale;
    }
    /**
    * return vale
    */
    public float getVale(){
        return this.vale;
    }

    @Override
    public String toString(){
        return "ModelCaixa {" + "::codigo = " + this.codigo + "::dinheiro = " + this.dinheiro + "::cheque = " + this.cheque + "::cartao = " + this.cartao + "::vale = " + this.vale +  "}";
    }
}