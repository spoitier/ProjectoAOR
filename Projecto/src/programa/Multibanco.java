package programa;

import java.io.Serializable;
import java.time.LocalDate;

public class Multibanco extends Pagamento implements Serializable {


    private int entidade;
    private String referencia;
    private double montante;

    public Multibanco(Reserva reserva, int entidade, String referencia, double montante) {
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

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
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
        return "Reserva=" + reserva +"|Multibanco:" +
                "entidade=" + entidade +
                ",referencia=" + referencia +
                ",montante=" + montante;
    }
    public static String gerarRefMultibanco(){
        String referenciaMB= String.valueOf(Math.round((Math.random()*999)*100)/100+" "+
                String.valueOf(Math.round((Math.random()*999)*100)/100)+" "+
                String.valueOf(Math.round((Math.random()*999)*100)/100));
        return referenciaMB;
    }

}
