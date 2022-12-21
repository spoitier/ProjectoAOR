package programa;

import java.io.Serializable;

public abstract class Utilizador implements Serializable {

    protected String email;
    protected String palavraChave;
    protected String nome;
    protected String nif;
    protected String morada;
    protected String telefone;
    protected String id;
    //Fostes
    public Utilizador(String email, String palavraChave, String nome, String nif, String morada, String telefone) {
        this.email = email;
        this.palavraChave = palavraChave;
        this.nome = nome;
        this.nif = nif;
        this.morada = morada;
        this.telefone = telefone;
        // this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public abstract String getPalavraChave();

    public void setPalavraChave(String palavraChave) {
        this.palavraChave = palavraChave;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void esqueceuPalavraPasse(String email) {
        System.out.println("Foi enviado para seu email" + email + " uma nova palavra-passe");
        System.out.println("Volte a fazer o login com a nova palavra-passe");
    }

}
