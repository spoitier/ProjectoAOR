package programa;

import java.io.Serializable;

public class Administrador extends Utilizador implements Serializable {

    private String id;
    public static int contador=1;





    public Administrador(String email, String palavraChave, String nome, int nif, String morada, int telefone) {
        super(email, palavraChave, nome, nif, morada, telefone);
        this.palavraChave = getPalavraChave();
        id = "admin".concat(String.valueOf(Administrador.contador));
        contador++;
    }

    //Metodo para gerar chave inicial
    public String getPalavraChave() {
        String palavraChave = "ADMIN2022";
        return palavraChave;
    }


    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    @Override
    public String toString() {
        return "programa.Administrador{" +
                "email='" + email + '\'' +
                ", palavraChave='" + palavraChave + '\'' +
                ", nome='" + nome + '\'' +
                ", nif=" + nif +
                ", morada='" + morada + '\'' +
                ", telefone=" + telefone +
                ", id=" + id +
                '}';
    }

    public String getId() {
        return id;
    }
}
