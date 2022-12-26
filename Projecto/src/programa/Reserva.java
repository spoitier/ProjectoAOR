package programa;

import java.io.Serializable;
import java.time.LocalDate;

public class Reserva implements Serializable {


    private Cliente cliente;
    private Autocarro autocarro;
    private Motorista motorista;
    private LocalDate dataReserva;
    private LocalDate dataPartida;
    private int numeroDias;
    private int numeroPessoas;
    private String localPartida;
    private String localDestino;
    private int distancia;

    private LocalDate dataFim;
    private double custo; // não pode estar o construtor


    public Reserva(Cliente cliente, Autocarro autocarro, Motorista motorista, LocalDate dataReserva, LocalDate dataPartida, int numeroDias, int numeroPessoas, String localPartida, String localDestino, int distancia) {
        this.cliente = cliente;
        this.autocarro = autocarro;
        this.motorista = motorista;
        this.dataReserva = dataReserva;
        this.dataPartida = dataPartida;
        this.numeroDias = numeroDias;
        this.numeroPessoas = numeroPessoas;
        this.localPartida = localPartida;
        this.localDestino = localDestino;
        this.distancia = distancia;
        dataFim=dataPartida.plusDays(numeroDias);//calcula data fim do periodo de reserva pretendido

    }
















    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Autocarro getAutocarro() {
        return autocarro;
    }

    public void setAutocarro(Autocarro autocarro) {
        this.autocarro = autocarro;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }


    public LocalDate getDataReserva() {
        return dataReserva;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataReserva(LocalDate dataReserva) {
        this.dataReserva = dataReserva;
    }

    public LocalDate getDataPartida() {
        return dataPartida;
    }

    public void setDataPartida(LocalDate dataPartida) {
        this.dataPartida = dataPartida;
    }

    public int getNumeroDias() {
        return numeroDias;
    }

    public void setNumeroDias(int numeroDias) {
        this.numeroDias = numeroDias;
    }

    public int getNumeroPessoas() {
        return numeroPessoas;
    }

    public void setNumeroPessoas(int numeroPessoas) {
        this.numeroPessoas = numeroPessoas;
    }

    public String getLocalPartida() {
        return localPartida;
    }

    public void setLocalPartida(String localPartida) {
        this.localPartida = localPartida;
    }

    public String getLocalDestino() {
        return localDestino;
    }

    public void setLocalDestino(String localDestino) {
        this.localDestino = localDestino;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public double getCusto() {
        return custo = 0.55 *getDistancia()+1.2*numeroPessoas;
    }



    @Override
    public String toString() {
        return "Reserva{" +
                "cliente=" + cliente +
                ", autocarro=" + autocarro +
                ", motorista=" + motorista +
                ", dataReserva=" + dataReserva +
                ", dataPartida=" + dataPartida +
                ", numeroDias=" + numeroDias +
                ", numeroPessoas=" + numeroPessoas +
                ", localPartida='" + localPartida + '\'' +
                ", localDestino='" + localDestino + '\'' +
                ", distancia=" + distancia +
                ", custo=" + custo +
                '}';
    }
}
