import java.time.LocalDate;

public class Multibanco extends Pagamento{


    private int entidade;
    private int referencia;
    private double montante;

    public Multibanco(Reserva reserva, int entidade, int referencia, double montante) {
        super(reserva);
        this.entidade = 12345;
        this.referencia = referencia;
        this.montante = getReserva().getCusto();
    }

    public int getEntidade() {
        return entidade;
    }

    public void setEntidade(int entidade) {
        this.entidade = entidade;
    }

    public int getReferencia() {
        return referencia;
    }

    public void setReferencia(int referencia) {
        this.referencia = referencia;
    }

    public double getMontante() {
        return montante;
    }

    public void setMontante(double montante) {
        this.montante = montante;
    }

    @Override
    public String toString() {
        return "Multibanco{" +
                "entidade=" + entidade +
                ", referencia=" + referencia +
                ", montante=" + montante +
                ", reserva=" + reserva +
                '}';
    }
}
