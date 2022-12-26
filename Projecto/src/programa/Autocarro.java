package programa;

import java.io.Serializable;

public class Autocarro implements Serializable {

    private int lotacao;
    private String matricula;
    private String marca;
    private String modelo;

    public Autocarro() {
    }

    public Autocarro(int lotacao, String matricula, String marca, String modelo) {
        this.lotacao = lotacao;
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
    }

    public int getLotacao() {
        return lotacao;
    }

    public void setLotacao(int lotacao) {
        this.lotacao = lotacao;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }


    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Autocarro{" +
                "lotacao=" + lotacao +
                ", matricula='" + matricula + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }


    //=================================================
    //Validar a matricula
    //========================================

    public void validarMatricula(String matricula) {
        int traco = 0;
        int numero = 0;
        int letra = 0;
        if (matricula.length() == 8) {
            for (int i = 0; i < matricula.length(); i++) {
                if (matricula.charAt(i) == '-') {
                    traco++;
                }
                if (Character.isDigit(matricula.charAt(i))) {
                    numero++;
                }
                if (Character.isLetter(matricula.charAt(i))) {
                    letra++;
                }

            }
        }
        if (traco == 2 && (numero == letra * 2 || letra == numero * 2)) {
            System.out.println("Matricula Valida");
        } else {
            System.out.println("Matricula Invalida");
        }

    }


    public  void validarLotacao(String lotacao) {
        try {
            int lotacaoInteiro = Integer.parseInt(lotacao);
            if (lotacaoInteiro <= 50) {
                System.out.println("Adicionar à lista");
            } else {
                System.out.println("Capacidade maxima é 50");
            }
        } catch (NumberFormatException ex) {
            System.out.println("Dados invalidos");
        }


    }

    public void validarMarca(String marca) {
        int contador = 0;
        for (int i =0;i<marca.length();i++) {
            if (Character.isDigit(marca.charAt(i))) {
                contador++;
            }
        }
        if(contador==marca.length()){
            System.out.println("valor valido");
        } else {
            System.out.println("Dados Invalidos");
        }
    }


}
