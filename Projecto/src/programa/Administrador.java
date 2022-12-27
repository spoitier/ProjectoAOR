package programa;

import java.io.Serializable;

public class Administrador extends Utilizador implements Serializable {








    public Administrador(String id,String email, String palavraChave, String nome, String nif, String morada, String telefone) {
        super(email, palavraChave, nome, nif, morada, telefone);
        this.palavraChave = getPalavraChave();
        this.id=id;
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
