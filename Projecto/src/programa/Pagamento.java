package programa;

import java.io.Serializable;

public class Pagamento implements Serializable
{

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
        return "programa.Pagamento{" +
                "reserva=" + reserva +
                '}';
    }
}


