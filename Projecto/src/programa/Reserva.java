package programa;

import javax.swing.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reserva implements Serializable {

    private Cliente cliente;
    private Autocarro autocarro;
    private Motorista motorista;
    private LocalDate dataReserva;
    private LocalDate dataPartida;
    private String numeroDias;
    private String numeroPessoas;
    private String localPartida;
    private String localDestino;
    private String distancia;

    private LocalDate dataFim;
    private double custo; // não pode estar no construtor
    private String id;

public Reserva(){
}

    public Reserva(Cliente cliente, Autocarro autocarro, Motorista motorista, LocalDate dataReserva, LocalDate dataPartida, String numeroDias, String numeroPessoas, String localPartida, String localDestino, String distancia,String id) {
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
        dataFim = dataPartida.plusDays(Integer.parseInt(numeroDias));//calcula data fim do periodo de reserva pretendido
        this.id=id;
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

    public String getLocalPartida() {
        return localPartida;
    }

    public String getLocalDestino() {
        return localDestino;
    }

    public String getNumeroPessoas() {
        return numeroPessoas;
    }
    public String getNumeroDias() {
        return numeroDias;
    }

    public String getId() {
        return id;
    }

    public double getCusto() {
        int distancia1=0;
        int nPessoas=0;
    try {
        distancia1 = Integer.parseInt(distancia);
    }
    catch (Exception e){
            JOptionPane.showMessageDialog(null,"Preencha número Km");
        }
        try {
    nPessoas=Integer.parseInt(numeroPessoas);
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Preencha número pessoas");
        }
        return custo = 0.55 * distancia1 + 1.2 * nPessoas;
    }

    public static boolean validarLocal(String local) {
        boolean validar = false;
        local = local.replaceAll("\\s", "");
        int contadorLetras = 0;

        for (int i = 0; i < local.length(); i++) {
            if (Character.isLetter(local.charAt(i))) {
                contadorLetras++;
            }
        }
        if (local.length() == contadorLetras) {
            validar = true;
        }
        return validar;
    }

    public static boolean validarNumeros(String dadoNumerico) {
        boolean validar = false;
        int contadorNumeros = 0;

        for (int i = 0; i < dadoNumerico.length(); i++) {
            if (Character.isDigit(dadoNumerico.charAt(i))) {
                contadorNumeros++;
            }
        }
        if (dadoNumerico.length() == contadorNumeros) {
            validar = true;
        }
        return validar;
    }

    public static boolean validarDataFormato(String data) {
        boolean validar = false;
        //Validar o formato da data
        if ((data.length() == 10) && (data.charAt(2) == '/') && (data.charAt(5) == '/')) {
            data.replaceAll("/", "");
            for (int i = 0; i < data.length(); i++) {
                if (Character.isDigit(data.charAt(i))) {
                    validar = true;
                }
            }
        }return validar;
    }
        //Validar o valor da data
        public static boolean validarDataValida(String data) {
            boolean validar = false;
    String dataSemEspaços=data.replaceAll("/", "");

        int dia = Integer.parseInt(dataSemEspaços.substring(0, 2));
        int mes = Integer.parseInt(dataSemEspaços.substring(2, 4));


       /*if(dia<0&&dia>31&&mes<0&&mes>12){
            validar=false;
        }*/

        if ((mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8||mes==10||mes==12) && (dia <= 31)) {
            validar = true;
        } else if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && (dia <= 30)) {
            validar = true;
        } else if (mes == 2 && dia <= 28) {
            validar = true;
        }
        return validar;
    }

    //Verificar se a data é igual ou superior à data atual
        public static boolean validarDataAluguer(String data) {
            boolean validar = false;
            LocalDate dataAluguer = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            if (dataAluguer.isAfter(LocalDate.now())) {
                validar = true;
            }
            System.out.println(dataAluguer+" "+LocalDate.now());
            return validar;
        }



    @Override
    public String toString() {
        return "Reserva:cliente=" + cliente +
                ",autocarro=" + autocarro +
                ",motorista=" + motorista +
                ",nºreserva= " + id +
                ",data da reserva=" + dataReserva +
                ",data da partida=" + dataPartida +
                ",numero dias=" + numeroDias +
                ",numero de pessoas=" + numeroPessoas +
                ",local de partida='" + localPartida + '\'' +
                ",local de destino='" + localDestino + '\'' +
                ",distancia=" + distancia +
                ",custo=" + custo;
    }
}
