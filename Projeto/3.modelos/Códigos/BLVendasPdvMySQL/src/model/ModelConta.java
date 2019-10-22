package model;

import java.sql.Date;

/**
*
* @author contato@blsoft.com.br
*/
public class ModelConta {

    private int codigo;
    private int codigoPessoa;
    private String descricao;
    private Date data;
    private Date vencimento;
    private Date pagamento;
    private int tipoPagamento;
    private String observacao;
    private int situacao;
    private float valor;
    private String tipoConta;

    /**
    * Construtor
    */
    public ModelConta(){}

    /**
    * seta o valor de codigo
    * @param pCodigo
    */
    public void setCodigo(int pCodigo){
        this.codigo = pCodigo;
    }
    /**
    * return pk_codigo
    */
    public int getCodigo(){
        return this.codigo;
    }

    /**
    * seta o valor de codigoPessoa
    * @param pCodigoCliente
    */
    public void setCodigoPessoa(int pCodigoCliente){
        this.codigoPessoa = pCodigoCliente;
    }
    /**
    * return fk_codigoPessoa
    */
    public int getCodigoPessoa(){
        return this.codigoPessoa;
    }

    /**
    * seta o valor de descricao
    * @param pDescricao
    */
    public void setDescricao(String pDescricao){
        this.descricao = pDescricao;
    }
    /**
    * return descricao
    */
    public String getDescricao(){
        return this.descricao;
    }

    /**
    * seta o valor de data
    * @param pData
    */
    public void setData(Date pData){
        this.data = pData;
    }
    /**
    * return data
    */
    public Date getData(){
        return this.data;
    }

    /**
    * seta o valor de vencimento
    * @param pVencimento
    */
    public void setVencimento(Date pVencimento){
        this.vencimento = pVencimento;
    }
    /**
    * return vencimento
    */
    public Date getVencimento(){
        return this.vencimento;
    }

    /**
    * seta o valor de pagamento
    * @param pPagamento
    */
    public void setPagamento(Date pPagamento){
        this.pagamento = pPagamento;
    }
    /**
    * return pagamento
    */
    public Date getPagamento(){
        return this.pagamento;
    }

    /**
    * seta o valor de tipoPagamento
    * @param pTipoPagamento
    */
    public void setTipoPagamento(int pTipoPagamento){
        this.tipoPagamento = pTipoPagamento;
    }
    /**
    * return fk_tipoPagamento
    */
    public int getTipoPagamento(){
        return this.tipoPagamento;
    }

    /**
    * seta o valor de observacao
    * @param pObservacao
    */
    public void setObservacao(String pObservacao){
        this.observacao = pObservacao;
    }
    /**
    * return observacao
    */
    public String getObservacao(){
        return this.observacao;
    }

    /**
    * seta o valor de situacao
    * @param pSituacao
    */
    public void setSituacao(int pSituacao){
        this.situacao = pSituacao;
    }
    /**
    * return situacao
    */
    public int isSituacao(){
        return this.situacao;
    }

    /**
    * seta o valor de valor
    * @param pValor
    */
    public void setValor(float pValor){
        this.valor = pValor;
    }
    /**
    * return valor
    */
    public float getValor(){
        return this.valor;
    }

    @Override
    public String toString(){
        return "ModelContaPagar {" + "::codigo = " + this.codigo + "::codigoCliente = " + this.codigoPessoa + "::descricao = " + this.descricao + "::data = " + this.data + "::vencimento = " + this.vencimento + "::pagamento = " + this.pagamento + "::tipoPagamento = " + this.tipoPagamento + "::observacao = " + this.observacao + "::situacao = " + this.situacao + "::valor = " + this.valor +  "}";
    }

    /**
     * @return the tipoConta
     */
    public String getTipoConta() {
        return tipoConta;
    }

    /**
     * @param tipoConta the tipoConta to set
     */
    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }
}