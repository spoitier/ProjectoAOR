package programa;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Cliente extends Utilizador implements Serializable {

    public static int contador=1;
    private String id;

    private ArrayList<Notificação> notificações=new ArrayList<>();
    private String tipoCliente; //Cliente Premium ou Cliente Normal
    private LocalDate data; // Data da subscrição, nova ou alterada


    public Cliente(String email, String palavraChave, String nome, int nif, String morada, int telefone, String tipoCliente, LocalDate data) {
        super(email, palavraChave, nome, nif, morada, telefone);
        this.tipoCliente = tipoCliente;
        this.data = data;
        this.palavraChave = palavraChave;
        id = "cl".concat(String.valueOf(Cliente.contador));
        contador++;
    }

    public String getPalavraChave() {
        return palavraChave;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public ArrayList<Notificação> getNotificações() {
        return notificações;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id='" + id + '\'' +
                ", tipoCliente=" + tipoCliente +
                ", data=" + data +
                ", email='" + email + '\'' +
                ", palavraChave='" + palavraChave + '\'' +
                ", nome='" + nome + '\'' +
                ", nif=" + nif +
                ", morada='" + morada + '\'' +
                ", telefone=" + telefone +
                ", id='" + id + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }


}
