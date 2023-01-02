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
        if ((data.length() == 5) && (data.charAt(2) == '/')) {
            data.replaceAll("/", "");
            for (int i = 0; i < data.length(); i++) {
                if (Character.isDigit(data.charAt(i))) {
                    validar = true;
                }
            }
        }return validar;
    }

    //Verificar se a data é igual ou superior à data atual
    public static boolean validarDataExpiração(String data) {
        boolean validar = false;
        LocalDate hoje=LocalDate.now();
        String dataHoje=hoje.toString();
        int mesAtual = Integer.parseInt(dataHoje.substring(5, 7));
        int anoAtual= Integer.parseInt(dataHoje.substring(2, 4));

        String dataSemEspaços=data.replaceAll("/", "");

        int mes = Integer.parseInt(dataSemEspaços.substring(0, 2));
        int ano= Integer.parseInt(dataSemEspaços.substring(2, 4));

        if(mes>0&&mes<=12){
            validar=true;
        }
        if(ano==anoAtual&&mes>=mesAtual){
            validar=true;
        }
        if(ano>anoAtual){
            validar=true;
        }
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
