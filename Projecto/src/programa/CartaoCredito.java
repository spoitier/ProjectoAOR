package programa;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class CartaoCredito extends Pagamento implements Serializable {

    private String numeroCartao;
    private String nomeClienteCartao;
    private LocalDate dataExpiracao;
    private String codigoSeguranca;

    public CartaoCredito(Reserva reserva, String numeroCartao, String nomeClienteCartao, LocalDate dataExpiracao, String codigoSeguranca) {
        super(reserva);
        this.numeroCartao = numeroCartao;
        this.nomeClienteCartao = nomeClienteCartao;
        this.dataExpiracao = dataExpiracao;
        this.codigoSeguranca = codigoSeguranca;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getCodigoSeguranca() {
        return codigoSeguranca;
    }

    public void setCodigoSeguranca(String codigoSeguranca) {
        this.codigoSeguranca = codigoSeguranca;
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



    @Override
    public String toString() {
        return "reserva=" + reserva +"\n" +
                "|CartaoCredito:" +
                "numeroCartao=" + numeroCartao +
                ",nomeClienteCartao='" + nomeClienteCartao +
                ",dataExpiracao=" + dataExpiracao;
    }
    public static boolean validarnumCartaoCredito(String dadoNumerico) {
        boolean validar=false;
        dadoNumerico=dadoNumerico.replaceAll("\\s","");
        int contadorNumeros=0;

        for(int i=0;i<dadoNumerico.length();i++){
            if(Character.isDigit(dadoNumerico.charAt(i))){
                contadorNumeros++;
            }
        }
        if(contadorNumeros<=16&&contadorNumeros>=14){
            validar=true;
        }
        return validar;
    }
    public static boolean validarNome(String nome) {
        boolean validar = false;
        nome=nome.replaceAll("\\s","");
        int contadorLetras=0;

        for(int i=0;i<nome.length();i++){
            if(!Character.isDigit(nome.charAt(i))){
                contadorLetras++;
            }
        }
        if(nome.length()==contadorLetras){
            validar=true;
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
        int ano = Integer.parseInt(dataSemEspaços.substring(4, 8));

        if(dia<0&&dia>31&&mes<0&&mes>12){
            validar=false;
        }

        if ((mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8) && (dia <= 31)) {
            validar = true;
        } else if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && (dia <= 30)) {
            validar = true;
        } else if (mes == 2 && dia <= 28) {
            validar = true;
        }
        return validar;
    }

    //Verificar se a data é igual ou superior à data atual
    public static boolean validarDataExpiração(String data) {
        boolean validar = false;
        LocalDate dataAluguer = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        if (dataAluguer.isAfter(LocalDate.now())) {
            validar = true;
        }
        System.out.println(dataAluguer+" "+LocalDate.now());
        return validar;
    }
    public static boolean validarPinCartaoCredito(String dadoNumerico) {
        boolean validar=false;
        dadoNumerico=dadoNumerico.replaceAll("\\s","");
        int contadorNumeros=0;

        for(int i=0;i<dadoNumerico.length();i++){
            if(Character.isDigit(dadoNumerico.charAt(i))){
                contadorNumeros++;
            }
        }
        if(contadorNumeros==3){
            validar=true;
        }
        return validar;
    }
}
