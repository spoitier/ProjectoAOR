package programa;

import java.io.Serializable;
import java.time.LocalDate;

public class Paypal extends Pagamento implements Serializable
{
    private String email;
    private String palavraChave;

    public Paypal(Reserva reserva, String email, String palavraChave) {
        super(reserva);
        this.email = email;
        this.palavraChave = palavraChave;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPalavraChave() {
        return palavraChave;
    }

    public void setPalavraChave(String palavraChave) {
        this.palavraChave = palavraChave;
    }

    @Override
    public String toString() {
        return "Paypal{" +
                "email='" + email + '\'' +
                ", palavraChave='" + palavraChave + '\'' +
                ", reserva=" + reserva +
                '}';
    }
}
