package model;
/**
*
* @author Leandro
*/
public class ModelUsuario {

    private int codigo;
    private String nome;
    private String login;
    private String senha;

    /**
    * Construtor
    */
    public ModelUsuario(){}

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
    * seta o valor de login
    * @param pLogin
    */
    public void setLogin(String pLogin){
        this.login = pLogin;
    }
    /**
    * return login
    */
    public String getLogin(){
        return this.login;
    }

    /**
    * seta o valor de senha
    * @param pSenha
    */
    public void setSenha(String pSenha){
        this.senha = pSenha;
    }
    /**
    * return senha
    */
    public String getSenha(){
        return this.senha;
    }

    @Override
    public String toString(){
        return "ModelUsuario {" + "::codigo = " + this.codigo + "::nome = " + this.nome + "::login = " + this.login + "::senha = " + this.senha +  "}";
    }
}