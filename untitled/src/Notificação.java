import java.io.Serializable;
import java.time.LocalDate;

public class Notificação implements Serializable {
    String email;
    String descrição;
    LocalDate data;
    Boolean lido;

    public Notificação(String email, String descrição, LocalDate data, Boolean lido) {
        this.email = email;
        this.descrição = descrição;
        this.data = data;
        this.lido = lido;
    }
}
