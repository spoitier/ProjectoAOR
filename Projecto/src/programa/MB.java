package programa;

import java.io.Serializable;

public class MB extends Pagamento implements Serializable {


    private int entidade;
    private String referencia;
    private double montante;

    public MB(Reserva reserva, int entidade, String referencia, double montante) {
        super(reserva);
        this.entidade = 12345;
        this.referencia = referencia;
        this.montante = getReserva().getCusto();
    }

    @Override
    public String toString() {
        return "Reserva=" + reserva +"|Multibanco:" +
                "entidade=" + entidade +
                ",referencia=" + referencia +
                ",montante=" + montante;
    }
    public static String gerarRefMultibanco(){
        String referenciaMB= String.valueOf(100+(Math.round((Math.random()*899)*100)/100))+" "+
                String.valueOf(100+(Math.round((Math.random()*899)*100)/100))+" "+
                String.valueOf(100+(Math.round((Math.random()*899)*100)/100));
        return referenciaMB;
    }

}
