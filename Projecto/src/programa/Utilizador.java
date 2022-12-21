package programa;

import java.io.Serializable;

public abstract class Utilizador implements Serializable {

    protected String email;
    protected String palavraChave;
    protected String nome;
    protected int nif;
    protected String morada;
    protected int telefone;
    protected String id;
    //Fostes
    public Utilizador(String email, String palavraChave, String nome, int nif, String morada, int telefone) {
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

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }




    @Override
    public String toString() {
        return "Utilizador{" +
                "email='" + email + '\'' +
                ", palavraChave='" + palavraChave + '\'' +
                ", nome='" + nome + '\'' +
                ", nif=" + nif +
                ", morada='" + morada + '\'' +
                ", telefone=" + telefone +
                ", id=" + id +
                '}';
    }


    public void esqueceuPalavraPasse(String email) {
        System.out.println("Foi enviado para seu email" + email + " uma nova palavra-passe");
        System.out.println("Volte a fazer o login com a nova palavra-passe");
    }

}
