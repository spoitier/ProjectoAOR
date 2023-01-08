package programa;

import javax.swing.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;

public class Aor_Autocarro implements Serializable {

    private ArrayList<Utilizador> utilizadores = new ArrayList<>();
    private ArrayList<Reserva> reservas = new ArrayList<>();
    private ArrayList<Reserva> reservasCanceladas = new ArrayList<>();
    private ArrayList<Reserva> reservasemEspera = new ArrayList<>();
    private ArrayList<Motorista> motoristas = new ArrayList<>();
    private ArrayList<Autocarro> autocarros = new ArrayList<>();
    private ArrayList<Pagamento> listaPagamentos = new ArrayList<>();

    private Utilizador userLogado;

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

    public ArrayList<Pagamento> getListaPagamentos() {
        return listaPagamentos;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void addUtilizador(Utilizador utilizador) {
        utilizadores.add(utilizador);
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

    //==============================================================================================
    //Métodos LOGIN
    //Validar Registo de Login
    public boolean validarRegisto(String email, String palavraChave) {
        boolean validar = false;
        for (Utilizador u : utilizadores) {
            if (u.getEmail().equals(email) && u.getPalavraChave().equals(palavraChave)) {
                validar = true;
            }
        }
        return validar;
    }

    //Verificar tipo utilizador: Cliente ou Administrador
    public String verificarTipoUtilizador(String email, String palavraChave) {
        String utilizador = null;
        for (Utilizador user : utilizadores) {
            if (user.getEmail().equals(email) && user.getPalavraChave().equals(palavraChave)) {
                if (user instanceof Cliente) {
                    utilizador = "cliente";
                } else {
                    utilizador = "administrador";
                }
            }
        }
        return utilizador;
    }

    //Contar nº Cliente
    public int contarCliente() {
        int cliente = 1;
        for (Utilizador user : utilizadores) {
            if (user instanceof Cliente) {
                cliente++;
            }
        }
        return cliente;
    }

    //Contar nº Administrador
    public int contarAdministrador() {
        int administrador = 0;
        for (Utilizador user : utilizadores) {
            if (user instanceof Administrador) {
                administrador++;
            }
        }
        return administrador;
    }

    public Utilizador getUserLogado() {
        return userLogado;
    }

    public void setUserLogado(Utilizador userLogado) {
        this.userLogado = userLogado;
    }

    //Retornar Utilizador logado
    public Utilizador utilizadorLogado(String email) {
        for (Utilizador user : utilizadores) {
            if (user.getEmail().equals(email)) {
                userLogado = user;
            }
        }
        return userLogado;
    }


    //Verificar se existe duplicação de resgisto de Nif, durante o registo de um novo utilizador
    public boolean verificarDuplicaçãoNif(String nif) {
        boolean duplicado = false;

        for (Utilizador user : utilizadores) {
            if (user.getNif().equals(nif)) {
                duplicado = true;
            }
        }
        return duplicado;
    }

    //Verificar se existe duplicação de registo de email, durante o registo de um novo utilizador
    public boolean verificarDuplicaçãoEmail(String email) {
        boolean duplicado = false;

        for (Utilizador user : utilizadores) {
            if (user.getEmail().equals(email)) {
                duplicado = true;
            }
        }
        return duplicado;
    }

    //===========================================================================================
    //Métodos ADMINISTRADORES

    public boolean removerCliente(String id) {
        LocalDate hoje = LocalDate.now();
        Cliente removido;
        //pesquisa cliente com base no id solicitado
        for (Utilizador utilizador : utilizadores) {
            if ((utilizador instanceof Cliente) && (utilizador.getId().equals(id))) {
                removido = (Cliente) utilizador;
                removido.setNome("inativo");
                removido.setMorada("inativo");
                removido.setTelefone("inativo");
                removido.setNif("inativo");

                //Criar e adicionar notificação de que o cliente foi removido,pelo que só terá acesso ao login

                Notificação clienteRemovido = new Notificação(removido.getEmail(), "ClienteRemovido",
                        "Foi removido da aplicação desta empresa.Pelo que não terá acesso ao seu menu Cliente",
                        hoje, false);
                removido.getNotificações().add(clienteRemovido);
                return true;
            }
        }
        return false;
    }


    public void cancelarReservasdoClienteRemovido(String id) {//Cancelamento reservas, por cliente ter sido removido por um Administrador

        // Verificar se este cliente tinha reservas pendentes
        for (Reserva res : reservas) {
            //Identificar a reserva deste cliente, remover da lista de reservas e adicionar à lista de reservas canceladas
            if (res.getCliente().getId().equals(id)) {

                reservas.remove(res);
                reservasCanceladas.add(res);
                //Adicionar notificação de cancelamento de reserva à lista de notificações do cliente
                adicionarNotificaçãoCancelamento(res);

                //Verificar se existem clientes em lista de espera que possam ficar com esta reserva
                if (reservasemEspera.size() != 0) {
                    verificarListaEspera(res);
                }

            }
        }
    }


    //===========================================================================================
    //Métodos CLIENTES
    //Verifica se existe disponível na empresa algum autocarro com capacidade para o nºpessoas solicitadas
    public boolean verificarAutocarroLotaçao(String n_pessoas) {
        int numeroPessoas = 0;
        try {
            numeroPessoas = Integer.parseInt(n_pessoas);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Preencha número pessoas");
        }
        boolean existe = false;
        for (Autocarro bus : autocarros) {
            if (numeroPessoas <= Integer.parseInt(bus.getLotacao())) {
                existe = true;
            }
        }
        return existe;
    }

    //Conta o nº total de reservas:efetuadas,canceladas e emEspera.Utilizado para atribuir ID à reserva
    public int contarReservas() {

        int contaReservas = reservas.size() + reservasCanceladas.size() + reservasemEspera.size();

        if (contaReservas == 0) {
            contaReservas = 1;
        } else
            contaReservas++;

        return contaReservas;
    }

    //Efetuar reserva de autocarro pelo cliente:
   /*public Reserva efetuarReserva(Cliente cliente, LocalDate dataReq, String nDias, String nPessoas, String partida, String destino, String distancia) throws IOException {
        String resultadoReserva = null;
        ArrayList<Autocarro> autDisponiveis = new ArrayList<>();
        ArrayList<Reserva> reservasAlvo = new ArrayList<>();
        ArrayList<Motorista> motoristasDisponíveis = new ArrayList<>(motoristas);
        int duração=Integer.parseInt(nDias);
        LocalDate datafim = dataReq.plusDays(duração);//calcula data fim do periodo de reserva pretendido
        LocalDate hoje = LocalDate.now(); //data de hoje
        int numeroPessoas=Integer.parseInt(nPessoas);
        long difDias;//diferença de dias
        Autocarro autocarro = new Autocarro();
        Motorista motorista = new Motorista();
        Reserva reservaAutocarro=new Reserva();

       //Ordenar Lista de autocarros por Lotação
        autocarros.sort(Comparator.comparing(Autocarro::getLotacao));

        for (Autocarro bus : autocarros) {
            if (Integer.parseInt(bus.getLotacao()) >= numeroPessoas) {
                //lista com autocarros com capacidade >=lotaçao pretendida
                autDisponiveis.add(bus);
                for (Reserva res : reservas) {
                //Verificar se existem reservas na lista de espera
                    if(reservas.size()==0){
                    autocarro = autocarros.get(0);
                    motorista = motoristas.get(0);
                    reservaAutocarro = new Reserva(cliente, autocarro, motorista, hoje, dataReq, nDias, nPessoas,
                            partida, destino, distancia);
                    return reservaAutocarro;
                }
                    //Verificar se os autocarro tem reservas
                    else{
                        if(reservaAutocarro.getAutocarro().equals(bus)){
                            autocarro=bus;
                            motorista = identificarMotoristaDisponível(cliente, dataReq, nDias);
                            reservaAutocarro = new Reserva(cliente, autocarro, motorista, hoje, dataReq, nDias, nPessoas,
                                    partida, destino, distancia);
                            return reservaAutocarro;
                        }

                    }
                    //Verificar se existe alguma reserva com data (início ou fim) compreendida para o periodo pretendido
                    if ((res.getDataPartida().isEqual(dataReq) || res.getDataPartida().isEqual(datafim)
                            || res.getDataPartida().isAfter(dataReq) && res.getDataPartida().isBefore(datafim))
                            || (res.getDataFim().isEqual(dataReq) || res.getDataFim().isEqual(datafim)
                            || res.getDataFim().isAfter(dataReq) && res.getDataFim().isBefore(datafim))) {
                        if (cliente.getTipoCliente().equals("Normal")) {
                            resultadoReserva = "indisponível";
                        }
                        //Cliente Premium tem prioridade na reserva apenas sob clientes "normais"
                        else if (cliente.getTipoCliente().equals("Premium")) {
                            if (res.getCliente().getTipoCliente().equals("Premium")) {
                                resultadoReserva = "indisponível";
                            } else if (res.getCliente().getTipoCliente().equals("Normal")) {
                                difDias = ChronoUnit.DAYS.between(hoje, res.getDataPartida());
                                //As reservas dos clientes "normais" só podem ser canceladas se:
                                if (difDias <= 2) {
                                    resultadoReserva = "indisponível";
                                } else if (difDias > 2) {
                                    //elimina autocarros reservados, para ficarmos no final apenas com os disponíveis
                                    autDisponiveis.remove(res.getAutocarro());
                                    //elimina motoristas autocarros, para ficarmos no final apenas com os disponíveis
                                    motoristasDisponíveis.remove(res.getMotorista());
                                    //guarda as reservas que cumprem os requisitos para serem canceladas
                                    reservasAlvo.add(res);
                                }
                            }
                        }
                    }
                }
            }
        }
        //Verificar qual(caso exista) o autocarro disponível ,atendendo ao requisito de minimizar lugares vazios
        if (autDisponiveis.size() >= 1) {
            //Ordenar autocarros disponíveis por ordem crescente relativamente à sua capacidade
            autDisponiveis.sort(Comparator.comparing(Autocarro::getLotacao));
            autocarro = autDisponiveis.get(0);
            motorista = motoristasDisponíveis.get(0);
            //Criar e adicionar reserva à lista de reservas da Empresa
            resultadoReserva = "Sucesso";
            Reserva reserva1 = new Reserva(cliente, autocarro, motorista, hoje, dataReq, "nDias", "nPessoas",
                    "partida", "destino", "distancia");
            reservas.add(reserva1);

        } else if (autDisponiveis.size() == 0) {
            if (reservasAlvo.size() != 0) {
                //Verificar qual o cliente com a data de reserva mais recente
                //Ordenar reservas por ordem decrescente relativamente à data de Reserva
                reservasAlvo.sort(Comparator.comparing(Reserva::getDataReserva).reversed());
                Reserva cancelada = reservasAlvo.get(0);

                //Adicionar notificação à lista de notificações do Cliente com reserva cancelada
                adicionarNotificaçãoCancelamento(cancelada);
                //Remover da Lista de Reservas da Empresa a reserva cancelada
                reservas.remove(reservasAlvo.get(0));
                //Adicionar a reserva cancelada à Lista de Reservas Canceladas da Empresa
                reservasCanceladas.add(reservasAlvo.get(0));
                //O autocarro associado à reserva cancelada fica disponível para reserva
                autocarro = reservasAlvo.get(0).getAutocarro();
                //O motorista associado ao autocarro fica disponível
                motorista = reservasAlvo.get(0).getMotorista();
                //Criar e adicionar reserva à lista de reservas da Empresa
                resultadoReserva = "Sucesso";
                Reserva reserva2 = new Reserva(cliente, autocarro, motorista, hoje, dataReq, "nDias", "nPessoas",
                        "partida", "destino", "distancia");
                reservas.add(reserva2);
            } else {
                autocarro = null;
                motorista = null;
                //Criar e adicionar reserva à lista de reservas em Espera
                resultadoReserva = "Espera";
                Reserva reserva3 = new Reserva(cliente, autocarro, motorista, hoje, dataReq, "nDias", "nPessoas",
                        "partida", "destino", "distancia");
                reservasemEspera.add(reserva3);
            }
        }
        return reservaAutocarro;
    }*/

    /*public Reserva verificarAutocarroSemReservas(Cliente cliente, LocalDate dataReq, String numeroDias, String numeroPessoas, String localPartida, String localDestino, String distancia) {

        int nPessoas = Integer.parseInt(numeroPessoas);
        Autocarro autocarro;
        Motorista motorista;
        LocalDate hoje = LocalDate.now(); //data de hoje
        Reserva reserva = new Reserva();

        //Ordenar Lista de autocarros por Lotação
        autocarros.sort(Comparator.comparing(Autocarro::getLotacao));

        for (Autocarro bus : autocarros) {
            if (Integer.parseInt(bus.getLotacao()) >= nPessoas) {
                if (reservas.size() == 0) {
                    autocarro = bus;
                    motorista = identificarMotoristaDisponível();
                    reserva = new Reserva(cliente, autocarro, motorista, hoje, dataReq, numeroDias, numeroPessoas,
                            localPartida, localDestino, distancia);
                    return reserva;

                }
            }
        }
        return reserva;
    }*/

    public Reserva efetuarReservaAutocarro(Cliente cliente, LocalDate dataReq, String nDias, String nPessoas, String partida, String destino, String distancia) {
        String resultadoReserva = null;
        ArrayList<Autocarro> autDisponiveis = new ArrayList<>();
        ArrayList<Reserva> reservasAlvo = new ArrayList<>();//lista de reservas com potencial para serem canceladas
        ArrayList<Motorista> motoristasDisponíveis = new ArrayList<>(motoristas);
        int duração = Integer.parseInt(nDias);
        LocalDate datafim = dataReq.plusDays(duração);//calcula data fim do periodo de reserva pretendido
        LocalDate hoje = LocalDate.now(); //data de hoje
        int numeroPessoas = Integer.parseInt(nPessoas);
        long difDias;//diferença de dias
        Autocarro autocarro;
        Motorista motorista;
        Reserva reserva = new Reserva();

        //Ordenar Lista de autocarros por Lotação
        autocarros.sort(Comparator.comparing(Autocarro::getLotacao));

        for (Autocarro bus : autocarros) {
            if (Integer.parseInt(bus.getLotacao()) >= numeroPessoas) {
                //lista com autocarros com capacidade >=lotaçao pretendida
                autDisponiveis.add(bus);
                if (reservas.size() == 0) {
                    autocarro = bus;
                    motorista = motoristasDisponíveis.get(0);
                    reserva = new Reserva(cliente, autocarro, motorista, hoje, dataReq, nDias, nPessoas,
                            partida, destino, distancia, "res" + contarReservas());
                    return reserva;
                } else {
                    for (Reserva res : reservas) {
                        if (res.getAutocarro().equals(bus)) {
                            //Verificar se existe(para cada autocarro) alguma reserva com data (início ou fim) compreendida para o periodo pretendido
                            if ((res.getDataPartida().isEqual(dataReq) || res.getDataPartida().isEqual(datafim)
                                    || res.getDataPartida().isAfter(dataReq) && res.getDataPartida().isBefore(datafim))
                                    || (res.getDataFim().isEqual(dataReq) || res.getDataFim().isEqual(datafim)
                                    || res.getDataFim().isAfter(dataReq) && res.getDataFim().isBefore(datafim))) {
                                //Verificar tipo Cliente que quer reservar autocarro:
                                //Se for cliente "Normal"
                                if (cliente.getTipoCliente().equals("Normal")) {
                                    reserva = new Reserva(cliente, null, null, hoje, dataReq, nDias, nPessoas,
                                            partida, destino, distancia, "res" + contarReservas());
                                    return reserva;
                                }
                                //Cliente Premium tem prioridade na reserva apenas sob clientes "normais"
                                else if (cliente.getTipoCliente().equals("Premium")) {
                                    //Verificar qual o tipo cliente da reserva já efetuada
                                    if (res.getCliente().getTipoCliente().equals("Premium")) {
                                        reserva = new Reserva(cliente, null, null, hoje, dataReq, nDias, nPessoas,
                                                partida, destino, distancia, "res" + contarReservas());
                                        return reserva;

                                    } else if (res.getCliente().getTipoCliente().equals("Normal")) {
                                        difDias = ChronoUnit.DAYS.between(hoje, res.getDataPartida());
                                        //As reservas dos clientes "normais" só podem ser canceladas se:
                                        if (difDias <= 2) {
                                            reserva = new Reserva(cliente, null, null, hoje, dataReq, nDias, nPessoas,
                                                    partida, destino, distancia, "res" + contarReservas());
                                            return reserva;
                                        } else {
                                            //elimina autocarros reservados, para ficarmos no final apenas com os disponíveis
                                            autDisponiveis.remove(res.getAutocarro());
                                            //elimina motoristas autocarros, para ficarmos no final apenas com os disponíveis
                                            motoristasDisponíveis.remove(res.getMotorista());
                                            //guarda as reservas que cumprem os requisitos para serem canceladas
                                            reservasAlvo.add(res);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        //Verificar qual(caso exista) o autocarro disponível ,atendendo ao requisito de minimizar lugares vazios
        if (autDisponiveis.size() >= 1) {
            //Ordenar autocarros disponíveis por ordem crescente relativamente à sua capacidade
            autocarro = autDisponiveis.get(0);
            motorista = motoristasDisponíveis.get(0);
            //Criar e adicionar reserva à lista de reservas da Empresa
            reserva = new Reserva(cliente, autocarro, motorista, hoje, dataReq, nDias, nPessoas,
                    partida, destino, distancia, "res" + contarReservas());
            return reserva;
        }

        //Verificar se existem reservas que podem ser canceladas
        if (reservasAlvo.size() != 0) {
            //Verificar qual o cliente com a data de reserva mais recente
            //Ordenar reservas por ordem decrescente relativamente à data de Reserva
            reservasAlvo.sort(Comparator.comparing(Reserva::getDataReserva).reversed());
            Reserva cancelada = reservasAlvo.get(0);
            //Adicionar notificação à lista de notificações do Cliente com reserva cancelada
            adicionarNotificaçãoCancelamento(cancelada);
            //Remover da Lista de Reservas da Empresa a reserva cancelada
            reservas.remove(reservasAlvo.get(0));
            //Adicionar a reserva cancelada à Lista de Reservas Canceladas da Empresa
            reservasCanceladas.add(reservasAlvo.get(0));
            //O autocarro associado à reserva cancelada fica disponível para reserva
            autocarro = reservasAlvo.get(0).getAutocarro();
            //O motorista associado ao autocarro fica disponível
            motorista = reservasAlvo.get(0).getMotorista();
            //Criar e adicionar reserva à lista de reservas da Empresa

            reserva = new Reserva(cliente, autocarro, motorista, hoje, dataReq, nDias, nPessoas,
                    partida, destino, distancia, "res" + contarReservas());
            return reserva;

        }

        return reserva;
    }

    //Identificar o Autocarro que foi atribuido à reserva
    public Autocarro identificarAutocarroReservado(Reserva reserva) {
        return reserva.getAutocarro();
    }

    public Motorista identificarMotoristaDisponível() {

        Motorista motorista = new Motorista();

        for (Motorista disponivel : motoristas) {
            if (reservas.size() == 0) {
                motorista = disponivel;
                return motorista;
            } else {
                for (Reserva res : reservas) {
                    if (res.getMotorista().equals(disponivel)) {
                    } else {
                        motorista = disponivel;
                        return motorista;

                    }
                }
            }
        }
        return motorista;
    }


    public void adicionarNotificaçãoCancelamento(Reserva reserva) {
        //Adicionar notificação de cancelamento à lista de Notificações do Cliente

        LocalDate hoje = LocalDate.now(); //data de hoje
        long diferençaDias = ChronoUnit.DAYS.between(hoje, reserva.getDataPartida());//Calcular diferença de dias entre hoje e a data partida
        double reembolso;

        //Adicionar notificação à lista de Notificações do Cliente cancelado
        //Cliente "normal" tem direito a reembolso com penalização 50% se diferençaDias>7
        if (diferençaDias > 7 && reserva.getCliente().getTipoCliente().equals("Normal")) {
            reembolso = (reserva.getCusto() / 2.0);
            Notificação cancelamento = new Notificação(reserva.getCliente().getEmail(), "Cancelamento",
                    "A sua reserva do dia " + reserva.getDataPartida() + " foi cancelada. " +
                            "Irá ser reembolsado pelo valor de " + reembolso + "€, através de" + identificarTipoPagamento(reserva),
                    hoje, false);
            reserva.getCliente().getNotificações().add(cancelamento);

            //Cliente "premium" tem direito a reembolso na sua totalidade se diferençaDias>2
        } else if (diferençaDias > 2 && reserva.getCliente().getTipoCliente().equals("Premium")) {
            reembolso = reserva.getCusto();
            Notificação cancelamento = new Notificação(reserva.getCliente().getEmail(), "Cancelamento",
                    "A sua reserva do dia " + reserva.getDataPartida() + " foi cancelada. " +
                            "Irá ser reembolsado pelo valor de " + reembolso + "€, através de" + identificarTipoPagamento(reserva),
                    hoje, false);
            reserva.getCliente().getNotificações().add(cancelamento);
            //Caso não se verifiquem nenhuma das condições anteriores, o cliente não tem direito a reembolso
        } else {
            Notificação cancelamento = new Notificação(reserva.getCliente().getEmail(), "Cancelamento",
                    "A sua reserva do dia " + reserva.getDataPartida() +
                            " foi cancelada. De acordo, com o seu pacote de subscrição, não irá ter direito a reembolso", hoje, false);
            reserva.getCliente().getNotificações().add(cancelamento);
        }
    }

    //========================================================================================
    //Metodos PAGAMENTO

    public Reserva identificarReservaPagamento(Cliente cliente) {
        LocalDate hoje = LocalDate.now();
        Reserva resPagamento = new Reserva();

        for (Reserva res : reservas) {
            if (res.getCliente().equals(cliente) && res.getDataReserva().isEqual(hoje)) {
                resPagamento = res;
                return resPagamento;
            }
        }
        return resPagamento;

    }

    public String identificarTipoPagamento(Reserva reserva) {//Identificar tipo de pagamento, para efetuar reembolso

        String tipoPagamento = null;

        for (Pagamento p : listaPagamentos) {
            if (p.getReserva().equals(reserva)) {
                if (p instanceof Paypal) {
                    tipoPagamento = "conta paypal com email: " + ((Paypal) p).getEmail();
                } else if (p instanceof MB) {
                    tipoPagamento = "multibanco.Foi enviado um pedido do IBAN para o email " + p.getReserva().getCliente().getEmail();
                } else if (p instanceof Cartaocredito) {
                    tipoPagamento = " Cartão de Crédito nº" + ((Cartaocredito) p).getNumeroCartao() + " em nome de " + ((Cartaocredito) p).getNomeClienteCartao();
                }
            }
        }
        return tipoPagamento;
    }

    //Cancelar reserva, caso o Cliente não queira ficar em lista espera
    public void cancelarReservaemEspera(Reserva reserva) {
        reservasemEspera.remove(reserva);
    }

    //Cancela reserva pelo cliente, e verifica clientes em lista espera
    public String cancelarReservaCliente(Cliente cliente, String id) {

        double reembolso;
        String descrição = null;
        LocalDate hoje = LocalDate.now(); //data de hoje

        long diferençaDias;

        for (Reserva res : reservas) {
            //Identificar a reserva, remover da lista de reservas e adicionar à lista de reservas canceladas
            if (res.getCliente().equals(cliente) && res.getId().equals(id)) {
                reservas.remove(res);
                reservasCanceladas.add(res);
                //Verificar se existem clientes em lista de espera que possam ficar com esta reserva
                if (reservasemEspera.size() != 0) {
                    verificarListaEspera(res);
                }
                LocalDate data_aluguer = res.getDataPartida();
                diferençaDias = ChronoUnit.DAYS.between(hoje, data_aluguer);
                //Verificar tipo de subscrição do cliente e se tem direito a reembolso
                //Cliente "normal" tem direito a reembolso com penalização 50% se diferençaDias>7
                if (diferençaDias > 7 && res.getCliente().getTipoCliente().equals("Normal")) {
                    reembolso = (res.getCusto() / 2.0);
                    descrição = "A sua reserva do dia " + data_aluguer + " foi cancelada com sucesso.\n " +
                            "Irá ser reembolsado pelo valor de " + reembolso + "€, através de" + identificarTipoPagamento(res);
                    return descrição;
                    //Cliente "premium" tem direito a reembolso na sua totalidade se diferençaDias>2
                } else if (diferençaDias > 2 && res.getCliente().getTipoCliente().equals("Premium")) {
                    reembolso = res.getCusto();
                    descrição = "A sua reserva do dia " + data_aluguer + " foi cancelada com sucesso. " +
                            "Irá ser reembolsado pelo valor de " + reembolso + "€, através de" + identificarTipoPagamento(res);
                    return descrição;
                    //Caso não se verifiquem nenhuma das condições anteriores, o cliente não tem direito a reembolso
                } else {
                    descrição = "A sua reserva do dia " + data_aluguer + " foi cancelada com sucesso.\n De acordo, com o seu pacote de subscrição, não irá ter direito a reembolso.";
                    return descrição;
                }
            }
        }
        descrição = "Não existe nenhuma reserva com esse id em seu nome \n " +
                "Sugerimos que proceda à consulta das suas reservas para confirmar id da reserva.";

        return descrição;
    }


    public void verificarListaEspera(Reserva reserva) {

        ArrayList<Reserva> candidatas = new ArrayList<>();
        Notificação notificaçãoReserva = null;
        LocalDate hoje = LocalDate.now(); //data de hoje
        Autocarro autocarro = reserva.getAutocarro();//autocarro da reserva cancelada
        Motorista motorista = reserva.getMotorista();//motorista da reserva cancelada


        for (Reserva resEspera : reservasemEspera) {
            //verifica se o autocarro da reserva cancelada tem capacidade para o nº pessoas e período das reservas em espera
            if (Integer.parseInt(resEspera.getNumeroPessoas()) <= Integer.parseInt(reserva.getAutocarro().getLotacao())) {
                //Adiciona à lista de candidatas, as reservas que satisfazem os requisitos pretendidos
                candidatas.add(resEspera);
                //Verifica na lista de reservas, quais as reservas atribuidas ao autocarro da reserva cancelada
                for (Reserva res : reservas) {
                    if (res.getAutocarro().equals(reserva.getAutocarro())) {
                        //Verificar se existe alguma reserva com data (início ou fim) fora do periodo pretendido
                        LocalDate dataReq = resEspera.getDataPartida();// data partida da reserva em espera
                        LocalDate datafim = resEspera.getDataFim();// data fim da reserva em espera
                        if ((res.getDataPartida().isEqual(dataReq) || res.getDataPartida().isEqual(datafim)
                                || res.getDataPartida().isAfter(dataReq) && res.getDataPartida().isBefore(datafim))
                                || (res.getDataFim().isEqual(dataReq) || res.getDataFim().isEqual(datafim)
                                || res.getDataFim().isAfter(dataReq) && res.getDataFim().isBefore(datafim))) {
                            //Remove à lista de candidatas, as reservas que ocupam o período pretendido
                            candidatas.remove(resEspera);
                        }
                    }
                }
            }
        }
        //Criar notificações para informar clientes com potencial para efetuarem reserva
        if (candidatas.size() >= 1) {
            for (int i = 0; i < candidatas.size(); i++) {
                notificaçãoReserva = new Notificação(candidatas.get(i).getCliente().getEmail(), "ListaEspera", "A sua reserva em espera foi processada,proceda ao seu pagamento " +
                        ".Data de partida em " + candidatas.get(i).getDataPartida(), hoje, false);
                //Adiciona notificação à lista das notificaçóes do cliente
                candidatas.get(i).getCliente().getNotificações().add(notificaçãoReserva);
                //Adicionar autocarro e motorista às reservas Candidatas em lista de espera;
                candidatas.get(i).setAutocarro(autocarro);
                candidatas.get(i).setMotorista(motorista);

            }
        }
    }


    //Cancelamento reservas de clientes, por autocarro ter sido removido por um Administrador
    public void cancelarReservasporAutocarro(String matrícula) {
        LocalDate hoje = LocalDate.now(); //data de hoje

        for (Reserva res : reservas) {
            if (res.getAutocarro().getMatricula().equals(matrícula)) {
                reservas.remove(res);
                reservasCanceladas.add(res);
                //Criar e adicionar notificação de que o autocarro foi removido
                Notificação autocarroRemovido = new Notificação(res.getCliente().getEmail(), "Cancelamento",
                        "Pedimos imensa desculpa pelo transtorno, mas o autocarro associado à sua reserva deixou de fazer parte da frota desta empresa.",
                        hoje, false);
                res.getCliente().getNotificações().add(autocarroRemovido);
                //Adicionar notificação de cancelamento de reserva à lista de notificações do cliente
                adicionarNotificaçãoCancelamento(res);
            }
        }
    }

    //Cancelamento reservas de clientes, por motorista ter sido removido por um Administrador
    public void cancelarReservasporMotorista(String email) {
        LocalDate hoje = LocalDate.now(); //data de hoje

        for (Reserva res : reservas) {
            if (res.getMotorista().getEmail().equals(email)) {
                reservas.remove(res);
                reservasCanceladas.add(res);
                //Criar e adicionar notificação de que o autocarro foi removido
                Notificação motoristaRemovido = new Notificação(res.getCliente().getEmail(), "Cancelamento",
                        "Pedimos imensa desculpa pelo transtorno, mas o motorista associado à sua reserva encontra-se indisponível.",
                        hoje, false);
                res.getCliente().getNotificações().add(motoristaRemovido);
                //Adicionar notificação de cancelamento de reserva à lista de notificações do cliente
                adicionarNotificaçãoCancelamento(res);
            }
        }
    }

    //Atribuir reserva efetiva a cliente em lista de espera, quando faz login
    public Reserva atribuirReservaListaEspera(String email) {

        Cliente logado = (Cliente) utilizadorLogado(email);//identificar cliente através do email
        Reserva novaReserva = null;
        Autocarro reservado = null;
        String descrição = null;
        int contador = 0;
        //Verificar qual a reserva e o autocarro atribuidos à sua reserva em lista de espera
        for (Reserva reserva : reservasemEspera) {
            if (reserva.getCliente().equals(logado)) {
                novaReserva = reserva;
                reservado = reserva.getAutocarro();
                return novaReserva;
            }
        }

        //Caso tenha sido atribuido um autocarro ao cliente, verificamos se é o único cliente que tem esse autocarro atribuido,
        // ou se há mais clientes em lista de espera com o mesmo autocarro atribuido
        for (Reserva reservas : reservasemEspera) {
            if (reservas.getAutocarro().equals(reservado)) {
                contador++;
            }
        }
        //Caso o contador seja =1, quer dizer que só este cliente tem este autocarro atribuido, pelo que iremos
        //remover a sua reserva à lista de espera e adicioná-la à lista de reservas da empresa.
        if (contador == 1) {
            //Remover reserva deste cliente da lista de espera e colocar na lista de reservas da empresa
            reservasemEspera.remove(novaReserva);

        } else {
            //Caso seja maior que 1, consideramos que este foi o primeiro cliente a ler a notificação, ficando a reserva
            //deste autocarro para si. Nos restantes clientes iremos voltar a atribuir um valor "null" nos campos
            //relativos ao autocarro e motorista.
            reservasemEspera.remove(novaReserva);

            for (Reserva reservas : reservasemEspera) {
                if (reservas.getAutocarro().equals(reservado)) {
                    reservas.setAutocarro(null);
                    reservas.setMotorista(null);
                    //Removemos a notificação da lista de notificações dos rsetantes clietes que estavam
                    //em lista de espera para esta reserva
                    for (Notificação le : reservas.getCliente().getNotificações()) {
                        if (le.getTipoNotificação().equals("listaEspera")) {
                            reservas.getCliente().getNotificações().remove(le);
                        }
                    }
                }
            }
        }
        return novaReserva;
    }


    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    public ArrayList<Reserva> getReservasCanceladas() {
        return reservasCanceladas;
    }

    public void setReservasCanceladas(ArrayList<Reserva> reservasCanceladas) {
        this.reservasCanceladas = reservasCanceladas;
    }

    public ArrayList<Reserva> getReservasemEspera() {
        return reservasemEspera;
    }

    public void setReservasemEspera(ArrayList<Reserva> reservasemEspera) {
        this.reservasemEspera = reservasemEspera;
    }

    public ArrayList<Motorista> getMotoristas() {
        return motoristas;
    }

    public void setMotoristas(ArrayList<Motorista> motoristas) {
        this.motoristas = motoristas;
    }

    public ArrayList<Autocarro> getAutocarros() {
        return autocarros;
    }

    public void setAutocarros(ArrayList<Autocarro> autocarros) {
        this.autocarros = autocarros;
    }

    public void setListaPagamentos(ArrayList<Pagamento> listaPagamentos) {
        this.listaPagamentos = listaPagamentos;
    }

    public ArrayList<Utilizador> getUtilizadores() {
        return utilizadores;
    }

    public void setUtilizadores(ArrayList<Utilizador> utilizadores) {
        this.utilizadores = utilizadores;
    }

    //========================================================================================
    //Metodos MOTORISTA
    public Motorista removerMotorista(String email) {
        Motorista motoristaRemovido = null;
        for (Motorista motorista : motoristas) {
            if ((motorista.getEmail().equals(email))) {
                motoristaRemovido = motorista;
            } else {
                motoristaRemovido = null;
            }
        }
        return motoristaRemovido;
    }

    public boolean verificarDuplicaçãoEmailMotorista(String email) {
        boolean duplicado = false;

        for (Motorista motorista : motoristas) {
            if (motorista.getEmail().equals(email)) {
                duplicado = true;
            }
        }
        return duplicado;
    }

    public boolean verificarDuplicacaoMatricula(String matricula) {
        for (Autocarro autocarro : autocarros) {
            if (autocarro.getMatricula().equals(matricula)) {
                return true;
            }
        }
        return false;
    }

    public Autocarro removerAutocarro(String matricula) {
        for (Autocarro autocarro : autocarros) {
            if ((autocarro.getMatricula().equals(matricula))) {
                return autocarro;
            }
        }
        return null;
    }

    public Utilizador getCliente(String nif) {
        for (Utilizador cliente : utilizadores) {
            if (cliente instanceof Cliente) {
                if ((cliente.getNif().equals(nif))) {
                    return cliente;
                }
            }

        }
        return null;
    }

    public int contarMotorista() {
        int motorista = 0;
        for (Motorista moto : motoristas) {
            motorista++;
        }
        return motorista;
    }

    public int contarAutocarro() {
        int autocarro = 0;
        for (Autocarro auto : autocarros) {
            autocarro++;
        }
        return autocarro;
    }

    public Utilizador getAdministrador(String email) {
        for (Utilizador administrador : utilizadores) {
            if ((administrador.getEmail().equals(email))) {
                return administrador;
            }
        }
        return null;
    }

    public void alterarPalavraChave(String email, String palavraChaveAtual,
                                    String novaPalavraChave, String confirmePalavraChave) {
        if (validarRegisto(email, palavraChaveAtual)) {
            if (novaPalavraChave.equals(confirmePalavraChave)) {
                for (Utilizador cliente : getUtilizadores()) {
                    if (cliente.getEmail().equals(email)) {
                        cliente.setPalavraChave(novaPalavraChave);
                        JOptionPane.showMessageDialog(null, "Palavra chave alterado com sucesso");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Palavra chave não coincidem");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Palavra chave atual incorrecta");
        }
    }


    public Autocarro getAutocarro(String matricula) {
        for (Autocarro autocarro : autocarros) {
            if ((autocarro.getMatricula().equals(matricula))) {
                return autocarro;
            }
        }
        return null;
    }

    public Motorista getMotorista(String email) {
        for (Motorista motorista : motoristas) {
            if ((motorista.getEmail().equals(email))) {
                return motorista;
            }
        }
        return null;
    }

    public String matriculaMaisRequisitado() {
        String elementoMaisFrequente = "";
        int contador = 0;
        for (Reserva reserva1 : reservas) {
            int tempContador = 0;
            for (Reserva reserva2 : reservas) {
                if (reserva2.getAutocarro().getMatricula().equals(reserva1.getAutocarro().getMatricula())) {
                    tempContador++;
                }
            }
            if (tempContador > contador) {
                elementoMaisFrequente = reserva1.getAutocarro().getMatricula();
                contador = tempContador;
            }
        }
        return elementoMaisFrequente;
    }
}










