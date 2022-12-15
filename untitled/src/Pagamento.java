import java.time.LocalDate;

public class Pagamento {

    protected Reserva reserva;

    public Pagamento(Reserva reserva) {
        this.reserva = reserva;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }


    @Override
    public String toString() {
        return "Pagamento{" +
                "reserva=" + reserva +
                '}';
    }
}


