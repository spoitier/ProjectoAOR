import java.time.LocalDate;
import java.util.ArrayList;

public class Cliente extends Utilizador {

    public static int contador=1;
    private String id;

    private ArrayList<Reserva> reservasAgendandas=new ArrayList<>();
    private ArrayList<Reserva> reservasCanceladas=new ArrayList<>();
    private ArrayList<Reserva> reservasEmEspera=new ArrayList<>();
    private char tipoCliente; //Cliente Premium ou Cliente Normal
    private LocalDate data; // Data da subscrição, nova ou alterada

    public Cliente(String email, String palavraChave, String nome, int nif, String morada, int telefone, char tipoCliente, LocalDate data) {
        super(email, palavraChave, nome, nif, morada, telefone);
        this.tipoCliente = tipoCliente;
        this.data = data;
        id = "cl".concat(String.valueOf(Cliente.contador));
        contador++;
    }

    public void addReservaAgendada(Reserva reserva) {
        reservasAgendandas.add(reserva);
    }

    public void addReservaCancelada(Reserva reserva) {
        reservasCanceladas.add(reserva);
    }
    public void addReservaemEspera(Reserva reserva) {
        reservasEmEspera.add(reserva);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                ", tipoCliente=" + tipoCliente +
                ", data=" + data +
                ", email='" + email + '\'' +
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
