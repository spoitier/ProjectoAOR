import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Aor_Autocarro implements Serializable {

    ArrayList<Utilizador> utilizadores = new ArrayList<>();
    ArrayList<Reserva> reservas = new ArrayList<>();
    ArrayList<Reserva> reservasCanceladas = new ArrayList<>();
    ArrayList<Reserva> reservasemEspera = new ArrayList<>();
    ArrayList<Motorista> motoristas = new ArrayList<>();
    ArrayList<Autocarro> autocarros = new ArrayList<>();
    ArrayList<Pagamento> listaPagamentos = new ArrayList<>();


    public void addUtilizador(Utilizador utilizador) {
        utilizadores.add(utilizador);
    }

    public void addReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public void addReservaCancelada(Reserva reserva) {
        reservasCanceladas.add(reserva);
    }

    public void addReservaemEspera(Reserva reserva) {
        reservasemEspera.add(reserva);
    }

    public void addMotorista(Motorista motorista) {
        motoristas.add(motorista);
    }

    public void addAutocarro(Autocarro autocarro) {
        autocarros.add(autocarro);
    }

    public void addPagamento(Pagamento pagamento) {
        listaPagamentos.add(pagamento);
    }

    @Override
    public String toString() {
        return "Aor_Autocarro{" +
                "utilizadores=" + utilizadores +
                ", reservas=" + reservas +
                ", motoristas=" + motoristas +
                ", autocarros=" + autocarros +
                '}';
    }

    public void validarRegisto(String email, String palavraChave) {
        boolean validar = false;
        for (Utilizador u : utilizadores) {
            if (u.getEmail().equals(email) && u.getPalavraChave().equals(palavraChave)) {
                validar = true;
            }
        }
        if (validar == true) {
            System.out.println("Login valido");
        } else {
            System.out.println("Email ou palavra-chave invalidos");
        }
    }

    /*public String verificarAutocarroDisponivel(Cliente cliente, int nDias, LocalDate data, int nPessoas) {

        boolean disponivel;
        LocalDate datafim = data.plusDays(nDias);

        for (Autocarro bus : autocarros) {
            for (Reserva res : reservas) {
                if (res.getDataPartida().isAfter(data) || res.getDataPartida().isEqual(data) ||
                        res.getDataPartida().isBefore(datafim)) {
                }
            }
        }*/
    }


