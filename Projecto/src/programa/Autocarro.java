package programa;

import javax.swing.*;
import java.io.Serializable;

public class Autocarro implements Serializable {

    private String lotacao;
    private String matricula;
    private String marca;
    private String modelo;

    public Autocarro() {
    }

    public Autocarro( String matricula, String marca, String modelo,String lotacao) {
        this.lotacao = lotacao;
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getLotacao() {
        return lotacao;
    }

    public void setLotacao(String lotacao) {
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

    public static boolean validarMatricula(String matricula) {
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
        if ((traco == 2) && (numero == letra * 2 || letra == numero * 2)) {
            return true;
        }
        return false;
    }

    public static boolean validarMarca(String marca) {
        int contador = 0;
        for (int i = 0; i < marca.length(); i++) {
            if (Character.isDigit(marca.charAt(i))) {
                contador++;
            }
        }
        if (contador == marca.length()) {
            return true;
        }
        return false;
    }

}