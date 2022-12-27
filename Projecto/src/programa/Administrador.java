package programa;

import java.io.Serializable;

public class Administrador extends Utilizador implements Serializable {

    private String id;






    public Administrador(String id,String email, String palavraChave, String nome, String nif, String morada, String telefone) {
        super(id,email, palavraChave, nome, nif, morada, telefone);
        this.id=id;
        this.palavraChave = getPalavraChave();
    }

    //Metodo para gerar chave inicial
    public String getPalavraChave() {
        String palavraChave = "ADMIN2022";
        return palavraChave;
    }


    @Override
    public String toString() {
        return "Administrador:" +
                "id=" + id +
                ",nome=" + nome +
                ",nif=" + nif +
                ",morada=" + morada  +
                ",telefone=" + telefone +
                ",email=" + email +
                ",palavraChave=" + palavraChave+"\n";
    }

    public String getId() {
        return id;
    }
}
