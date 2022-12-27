package programa;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Cliente extends Utilizador implements Serializable {


    private ArrayList<Notificação> notificações=new ArrayList<>();
    private String tipoCliente; //Cliente Premium ou Cliente Normal
    private LocalDate data; // Data da subscrição, nova ou alterada

    Aor_Autocarro empresa=new Aor_Autocarro();



    public Cliente(String id,String email, String palavraChave, String nome, String nif, String morada, String telefone, String tipoCliente, LocalDate data) {
        super(id,email, palavraChave, nome, nif, morada, telefone);
        this.tipoCliente = tipoCliente;
        this.data = data;
        this.palavraChave = palavraChave;
        this.id=id;


    }

    public String getPalavraChave() {
        return palavraChave;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public ArrayList<Notificação> getNotificações() {
        return notificações;
    }

    @Override
    public String toString() {
        return "Cliente." +
                "id=" + id +
                ",nome=" + nome  +
                ",nif=" + nif  +
                ",morada=" + morada  +
                ",telefone=" + telefone +
                ",email=" + email +
                ",palavraChave=" + palavraChave +
                ",data do registo=" + data+
                ",tipoCliente=" + tipoCliente;
    }

    public String getId() {
        return id;
    }

    public  void alterarSubscricao(String email) {
        for (Utilizador utilizador : aor_autocarro.getUtilizadores()) {
            if (((Cliente) utilizador).getTipoCliente().equals("N")) {
                ((Cliente) utilizador).setTipoCliente("P");
            } else if (((Cliente) utilizador).getTipoCliente().equals("P")) {
                ((Cliente) utilizador).setTipoCliente("N");

            }

        }
    }






}
