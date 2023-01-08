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

    @Override
    public String toString() {
        return "Paypal{" +
                "email='" + email + '\'' +
                ", palavraChave='" + palavraChave + '\'' +
                ", reserva=" + reserva +
                '}';
    }
    public static boolean validarEmail(String email) {
        boolean validar = false;
        String[] email2 = email.split("");
        for (int i = 0; i < email2.length; i++) {
            if (email2[i].equals("@")) {
                for (int j = i; j < email2.length; j++) {
                    if (email2[j].equals(".")) {
                        validar = true;
                    }
                }
            }
        }return validar;
    }
}
