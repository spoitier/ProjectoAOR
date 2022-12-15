public class Autocarro {

    private int lotacao;
    private String matricula;
    private String marca;
    private String modelo;

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
}
