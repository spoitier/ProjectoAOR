package programa;

import java.io.IOException;
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
                    userLogado=user;
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

    public boolean removerCliente(String nif) {
        LocalDate hoje= LocalDate.now();
        Cliente removido = null;
        //pesquisa cliente com base no nif solicitado
        for (Utilizador utilizador : utilizadores) {
            if ((utilizador instanceof Cliente) && (utilizador.getNif().equals(nif))) {
                removido = (Cliente) utilizador;
                //Criar e adicionar notificação de que o cliente foi removido,pelo que só terá acesso ao login
                if(cancelarReservasdoClienteRemovido(nif)==0){
                Notificação clienteRemovido = new Notificação(removido.getEmail(), "ClienteRemovido",
                        "Foi removido da aplicação desta empresa.Pelo que não terá acesso ao seu menu Cliente",
                        hoje, false);
                removido.getNotificações().add(clienteRemovido);
                return true;}
                else if(cancelarReservasdoClienteRemovido(nif)>0){
                    Notificação clienteRemovido = new Notificação(removido.getEmail(), "ClienteRemovido",
                            "Foi removido da aplicação desta empresa.Pelo que não terá acesso ao seu menu Cliente.\n" +
                                    "As suas reservas foram canceladas.",
                            hoje, false);
                    removido.getNotificações().add(clienteRemovido);
                    return true;}
            }
        }return false;
    }


    public int cancelarReservasdoClienteRemovido(String nifCliente) {//Cancelamento reservas, por cliente ter sido removido por um Administrador
int contaRservas=0;
        // Verificar se este cliente tinha reservas pendentes
        for (Reserva res : reservas) {
            //Identificar a reserva deste cliente, remover da lista de reservas e adicionar à lista de reservas canceladas
            if (res.getCliente().getNif().equals(nifCliente)) {
                contaRservas++;
                reservas.remove(res);
                reservasCanceladas.add(res);
                //Adicionar notificação de cancelamento de reserva à lista de notificações do cliente
                adicionarNotificaçãoCancelamento(res);

                //Verificar se existem clientes em lista de espera que possam ficar com esta reserva
                if (reservasemEspera.size() != 0) {
                    verificarListaEspera(res);}

            }
        }return contaRservas;
    }





    //===========================================================================================
    //Métodos CLIENTES
    //Verifica se existe disponível na empresa algum autocarro com capacidade para o nºpessoas solicitadas
    public boolean verificarAutocarroLotaçao(String n_pessoas) {
        boolean existe = true;
        for (Autocarro bus : autocarros) {
            if (Integer.parseInt(bus.getLotacao()) >= Integer.parseInt(n_pessoas)) {
            } else existe = false;
        }
        return existe;
    }

    //Efetuar reserva de autocarro pelo cliente:
   /* public String efetuarReserva(Cliente cliente, LocalDate dataReq, String nDias, String nPessoas, String partida, String destino, String distancia) throws IOException {
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

        //Verificar se existe algum autocarro(e respetivo motorista) reservado para o período solicitado

        for (Autocarro bus : autocarros) {
            if (Integer.parseInt(bus.getLotacao()) >= numeroPessoas) {
                //lista com autocarros com capacidade >=lotaçao pretendida
                autDisponiveis.add(bus);
                for (Reserva res : reservas) {
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
        return resultadoReserva;
    }*/

    public Reserva verificarAutocarroSemReservas(Cliente cliente, LocalDate dataReq, String nDias, String nPessoas, String partida, String destino, String distancia) throws IOException {
        boolean existe=false;
        int numeroPessoas = Integer.parseInt(nPessoas);
        Autocarro autocarro = new Autocarro();
        Motorista motorista = new Motorista();
        LocalDate hoje = LocalDate.now(); //data de hoje
        Reserva reserva;

        //Ordenar Lista de autocarros por Lotação
        autocarros.sort(Comparator.comparing(Autocarro::getLotacao));

        for (Autocarro bus : autocarros) {
            if (Integer.parseInt(bus.getLotacao()) >= numeroPessoas) {
                if (reservas.size() == 0) {
                    autocarro = bus;
                    motorista = motoristas.get(0);
                    existe = true;
                } else {
                    for (Reserva res : reservas) {
                        //Verificar se o autocarro tem reservas
                        if (res.getAutocarro().equals(bus)) {
                            if (reservas.size() == 0) {
                                autocarro = bus;
                                motorista = identificarMotoristaDisponível(cliente, dataReq, nDias);
                                if (motorista != null) {
                                    existe = true;
                                } else {
                                    existe = false;
                                }
                            }
                        }
                    }
                }
            }
        }

        if(existe) {
            reserva = new Reserva(cliente, autocarro, motorista, hoje, dataReq, "nDias", "nPessoas",
                    "partida", "destino", "distancia");
            reservas.add(reserva);
            //FicheiroDeObjectos.escreveObjeto(aor_autocarro);
        }
        else{
            reserva=null;
        }
        return reserva;
    }

    public Reserva verificarAutocarrocomReservas(Cliente cliente, LocalDate dataReq, String nDias, String nPessoas, String partida, String destino, String distancia) throws IOException {
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
        Reserva reserva=new Reserva();

        //Ordenar Lista de autocarros por Lotação
        autocarros.sort(Comparator.comparing(Autocarro::getLotacao));

        for (Autocarro bus : autocarros) {
            if (Integer.parseInt(bus.getLotacao()) >= numeroPessoas) {
                //lista com autocarros com capacidade >=lotaçao pretendida
                autDisponiveis.add(bus);
                for (Reserva res : reservas) {
                    //Verificar se existe(para cada autocarro) alguma reserva com data (início ou fim) compreendida para o periodo pretendido
                    if ((res.getDataPartida().isEqual(dataReq) || res.getDataPartida().isEqual(datafim)
                            || res.getDataPartida().isAfter(dataReq) && res.getDataPartida().isBefore(datafim))
                            || (res.getDataFim().isEqual(dataReq) || res.getDataFim().isEqual(datafim)
                            || res.getDataFim().isAfter(dataReq) && res.getDataFim().isBefore(datafim))) {
                        //Verificar tipo Cliente que quer reservar autocarro:
                        //Se for cliente "Normal"
                        if (cliente.getTipoCliente().equals("Normal")) {
                            resultadoReserva = "indisponível";
                        }
                        //Cliente Premium tem prioridade na reserva apenas sob clientes "normais"
                        else if (cliente.getTipoCliente().equals("Premium")) {
                            //Verificar qual o tipo cliente da reserva já efetuada
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
                resultadoReserva = "Sucesso";
                reserva = new Reserva(cliente, autocarro, motorista, hoje, dataReq, "nDias", "nPessoas",
                        "partida", "destino", "distancia");
                reservas.add(reserva);
            //FicheiroDeObjectos.escreveObjeto(aor_autocarro);

            } else if(resultadoReserva == "indisponível") {
                reserva=null;
            //FicheiroDeObjectos.escreveObjeto(aor_autocarro);
            }
        return reserva;
        }

    //Identificar o Autocarro que foi atribuido à reserva
    public Autocarro identificarAutocarroReservado(Reserva reserva) {
        return reserva.getAutocarro();
    }
    public Motorista identificarMotoristaDisponível(Cliente cliente, LocalDate dataReq, String nDias) throws IOException {
        int duração = Integer.parseInt(nDias);
        LocalDate datafim = dataReq.plusDays(duração);//calcula data fim do periodo de reserva pretendido
        long difDias;//diferença de dias
        Motorista motorista=new Motorista();

        for (Motorista disponivel : motoristas) {
            for (Reserva res : reservas) {
                if (res.getMotorista().equals(disponivel)) {
                    if (reservas.size() == 0) {
                        motorista = disponivel;
                        //Verificar se existe(para cada motorista) alguma reserva com data (início ou fim) compreendida para o periodo pretendido
                    } else if ((res.getDataPartida().isEqual(dataReq) || res.getDataPartida().isEqual(datafim)
                            || res.getDataPartida().isAfter(dataReq) && res.getDataPartida().isBefore(datafim))
                            || (res.getDataFim().isEqual(dataReq) || res.getDataFim().isEqual(datafim)
                            || res.getDataFim().isAfter(dataReq) && res.getDataFim().isBefore(datafim))) {
                        motorista = null;
                    } else {
                        motorista = disponivel;
                    }
                }
            }
        }return motorista;
        }


    public void adicionarNotificaçãoCancelamento(Reserva reserva) {//Adicionar notificação de cancelamento à lista de Notificações do Cliente

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

    public Reserva identificarReservaPagamento(Cliente cliente){
        LocalDate hoje=LocalDate.now();
        Reserva resPagamento=new Reserva();

        for(Reserva res: reservas){
            if(res.getCliente().equals(cliente)&&res.getDataReserva().isEqual(hoje)){
              resPagamento=res;
            }
        }return resPagamento;

    }

    public String identificarTipoPagamento(Reserva reserva) {//Identificar tipo de pagamento, para efetuar reembolso

        String tipoPagamento = null;

        for (Pagamento p : listaPagamentos) {
            if (p.getReserva().equals(reserva)) {
                if (p instanceof Paypal) {
                    tipoPagamento = "conta paypal com email: " + ((Paypal) p).getEmail();
                } else if (p instanceof Multibanco) {
                    tipoPagamento = "multibanco.Foi enviado um pedido do IBAN para o email " + p.getReserva().getCliente().getEmail();
                } else if (p instanceof CartaoCredito) {
                    tipoPagamento = " Cartão de Crédito nº" + ((CartaoCredito) p).getNumeroCartao() + " em nome de " + ((CartaoCredito) p).getNomeClienteCartao();
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
    public String cancelarReservaCliente(LocalDate data_aluguer) {

        double reembolso;
        String descrição = null;
        LocalDate hoje = LocalDate.now(); //data de hoje
        long diferençaDias = ChronoUnit.DAYS.between(hoje, data_aluguer);

        for (Reserva res : reservas) {
            //Identificar a reserva, remover da lista de reservas e adicionar à lista de reservas canceladas
            if (res.getDataPartida().isEqual(data_aluguer)) {
                reservas.remove(res);
                reservasCanceladas.add(res);
                //Verificar se existem clientes em lista de espera que possam ficar com esta reserva
                if (reservasemEspera.size() != 0) {
                    verificarListaEspera(res);
                }

                //Verificar tipo de subscrição do cliente e se tem direito a reembolso
                //Cliente "normal" tem direito a reembolso com penalização 50% se diferençaDias>7
                if (diferençaDias > 7 && res.getCliente().getTipoCliente().equals("Normal")) {
                    reembolso = (res.getCusto() / 2.0);
                    descrição = "A sua reserva do dia " + data_aluguer + " foi cancelada com sucesso. " +
                            "Irá ser reembolsado pelo valor de " + reembolso + "€, através de" + identificarTipoPagamento(res);

                    //Cliente "premium" tem direito a reembolso na sua totalidade se diferençaDias>2
                } else if (diferençaDias > 2 && res.getCliente().getTipoCliente().equals("Premium")) {
                    reembolso = res.getCusto();
                    descrição = "A sua reserva do dia " + data_aluguer + " foi cancelada com sucesso. " +
                            "Irá ser reembolsado pelo valor de " + reembolso + "€, através de" + identificarTipoPagamento(res);

                    //Caso não se verifiquem nenhuma das condições anteriores, o cliente não tem direito a reembolso
                } else {
                    descrição = "A sua reserva do dia " + data_aluguer + " foi cancelada com sucesso. De acordo, com o seu pacote de subscrição, não irá ter direito a reembolso.";
                }
            }
        }
        return descrição;
    }

    //Verificar reservas em lista de espera, após ter sido cancelada uma reserva e notificação dos clientes
    // - Este método só é corrido se a dimensão da lista de espera for diferente de 0;
    // - Verificar se o autocarro da reserva cancelada cumpre os requisitos da reserva em lista de espera,
    // nomeadamente lotação.
    //criar uma lista, para guardar o nº de reservas em espera candidatas
    //Identificar email do cliente/clientes e adicionar notificação à lista do/s Cliente/s

    public void verificarListaEspera(Reserva reserva) {

        ArrayList<Reserva> candidatas = new ArrayList<>();
        Notificação notificaçãoReserva = null;
        LocalDate hoje = LocalDate.now(); //data de hoje
        Autocarro autocarro = reserva.getAutocarro();//autocarro da reserva cancelada
        Motorista motorista = reserva.getMotorista();//motorista da reserva cancelada

        for (Reserva resEspera : reservasemEspera) {
            //verifica se o autocarro da reserva cancelada tem capacidade para o nº pessoas e período das reservas em espera
            if (Integer.parseInt(resEspera.getNumeroPessoas()) <= Integer.parseInt(reserva.getAutocarro().getLotacao())){
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
                        ".Data de partida em " + candidatas.get(i).getDataPartida() + ".Custo: " + candidatas.get(i).getCusto(), hoje, false);
                //Adiciona notificação à lista das notificaçóes do cliente
                candidatas.get(i).getCliente().getNotificações().add(notificaçãoReserva);
                //Adicionar autocarro e motorista às reservas Candidatas em lista de espera;
                candidatas.get(i).setAutocarro(autocarro);
                candidatas.get(i).setMotorista(motorista);

            }
        }
    }


    //Cancelamento reservas de clientes, por autocarro ter sido removido por um Gerente
    //1º - remover autocarro da lista de autocarros;
    //2ª- remover todas as reservas associadas a esse autocarro da lista de reservas da empresa
    //3º - adicionar as reservas canceladas à lista de reservas canceladas
    //4º - Notificar cliente, que o autocarro associado à sua reserva deixou de estar disponível
    //5º - Método Adicionar Notificação de Cancelamento de reservas
    //- verifica tipo de subscrição do cliente
    //- verifica se tem direito a reembolso
    //- adiciona notificação à lista de notificações do cliente
    public void cancelarReservasporGerente(String matrícula) {
        LocalDate hoje = LocalDate.now(); //data de hoje

        for (Autocarro bus : autocarros) {
            if (bus.getMatricula().equals(matrícula)) {
                autocarros.remove(bus);
            }
        }

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

    //Atribuir reserva efetiva a cliente em lista de espera:
    public String atribuirReservaListaEspera(String email) {

        Cliente logado = (Cliente) utilizadorLogado(email);//identificar cliente através do email
        Reserva novaReserva = null;
        Autocarro reservado = null;
        String descrição = null;
        int contador = 0;
        //Verificar qual a reserva e o autocarro atribuidos à sua reserva em lista de espera
        for (Reserva reservas : reservasemEspera) {
            if (reservas.getCliente().equals(logado)) {
                novaReserva = reservas;
                reservado = reservas.getAutocarro();
            }
        }
        // Caso o valor atribuido ao autocarro seja "null", o cliente volta para a lista de espera
        if (reservado.equals(null)) {
            descrição = "Lamentamos o incómodo,mas a sua reserva continua em lista de espera";
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
            reservas.add(novaReserva);
        } else {
            //Caso seja maior que 1, consideramos que este foi o primeiro cliente a ler a notificação, ficando a reserva
            //deste autocarro para si. Nos restantes clientes iremos voltar a atribuir um valor "null" nos campos
            //relativos ao autocarro e motorista.
            reservasemEspera.remove(novaReserva);
            reservas.add(novaReserva);
            for (Reserva reservas : reservasemEspera) {
                if (reservas.getAutocarro().equals(reservado)) {
                    reservas.setAutocarro(null);
                    reservas.setMotorista(null);
                }
            }
        }
        return descrição;
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
        for (Motorista motorista:motoristas) {
            if((motorista.getEmail().equals(email))) {
                motoristaRemovido=motorista;
            }
            else {
                motoristaRemovido=null;
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

}







