package programa;

import java.io.Serializable;
import java.time.LocalDate;

public class Notificação implements Serializable {
    String email;
    String tipoNotificação;
    String descrição;
    LocalDate data;
    Boolean lido;

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

    public void setTipoNotificação(String tipoNotificação) {
        this.tipoNotificação = tipoNotificação;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Boolean getLido() {
        return lido;
    }

    public void setLido(Boolean lido) {
        this.lido = lido;
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
