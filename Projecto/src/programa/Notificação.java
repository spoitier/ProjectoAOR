package programa;

import java.io.Serializable;
import java.time.LocalDate;

public class Notificação implements Serializable {
   private String email;
    private  String tipoNotificação;
    private String descrição;
    private LocalDate data;
    private Boolean lido;

    public Notificação(String email,String tipoNotificação, String descrição, LocalDate data, Boolean lido) {
        this.email = email;
        this.tipoNotificação=tipoNotificação;
        this.descrição = descrição;
        this.data = data;
        this.lido = lido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoNotificação() {
        return tipoNotificação;
    }

    public String getDescrição() {
        return descrição;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Notificação:" +
                "email=" + email +
                ",tipoNotificação=" + tipoNotificação +
                ",descrição='" + descrição +
                ",data=" + data +
                ",lido=" + lido;
    }
}
