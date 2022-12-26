package programa;

import java.io.Serializable;
import java.time.LocalDate;

public class CartaoCredito extends Pagamento implements Serializable {

    private int numeroCartao;
    private String nomeClienteCartao;
    private LocalDate dataExpiracao;
    private int codigoSeguranca;

    public CartaoCredito(Reserva reserva, int numeroCartao, String nomeClienteCartao, LocalDate dataExpiracao, int codigoSeguranca) {
        super(reserva);
        this.numeroCartao = numeroCartao;
        this.nomeClienteCartao = nomeClienteCartao;
        this.dataExpiracao = dataExpiracao;
        this.codigoSeguranca = codigoSeguranca;
    }


    public int getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(int numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getNomeClienteCartao() {
        return nomeClienteCartao;
    }

    public void setNomeClienteCartao(String nomeClienteCartao) {
        this.nomeClienteCartao = nomeClienteCartao;
    }

    public LocalDate getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(LocalDate dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }

    public int getCodigoSeguranca() {
        return codigoSeguranca;
    }

    public void setCodigoSeguranca(int codigoSeguranca) {
        this.codigoSeguranca = codigoSeguranca;
    }

    @Override
    public String toString() {
        return "CartaoCredito{" +
                "numeroCartao=" + numeroCartao +
                ", nomeClienteCartao='" + nomeClienteCartao + '\'' +
                ", dataExpiracao=" + dataExpiracao +
                ", codigoSeguranca=" + codigoSeguranca +
                ", reserva=" + reserva +
                '}';
    }






}
