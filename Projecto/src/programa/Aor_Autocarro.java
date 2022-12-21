package programa;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;

public class Aor_Autocarro implements Serializable {

    ArrayList<Utilizador> utilizadores = new ArrayList<>();
    ArrayList<Reserva> reservas = new ArrayList<>();
    ArrayList<Reserva> reservasCanceladas = new ArrayList<>();
    ArrayList<Reserva> reservasemEspera = new ArrayList<>();
    ArrayList<Motorista> motoristas = new ArrayList<>();
    ArrayList<Autocarro> autocarros = new ArrayList<>();
    ArrayList<Pagamento> listaPagamentos = new ArrayList<>();


    public void gravarFicheiro(){
        try {
            FicheiroDeObjectos fdo = new FicheiroDeObjectos();

        fdo.abreEscrita("Aor_Autocarro");
        fdo.escreveObjeto(this);
        fdo.fechaEscrita();}
        catch (IOException e){
            System.out.println("Erro"+e);
        }
    }
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

    public ArrayList<Pagamento> getListaPagamentos() {
        return listaPagamentos;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
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

    //Validar Registo de Login
    public boolean validarRegisto(String email, char palavraChave) {
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
        } return validar;
    }

    //Verifica se existe disponível a empresa algum autocarro com capacidade para o nºpessoas solicitadas
    public boolean verificarAutocarroLotaçao(int n_pessoas) {
        boolean existe = true;
        for (Autocarro bus : autocarros) {
            if (bus.getLotacao() >= n_pessoas) {
            } else existe = false;
        }
        return existe;
    }

    //Efetuar reserva de autocarro pelo cliente:
    public String efetuarReserva(Cliente cliente, LocalDate dataReq, int nDias, int nPessoas, String partida, String destino, int distancia) throws IOException {
        String resultadoReserva = null;
        ArrayList<Autocarro> autDisponiveis = new ArrayList<>();
        ArrayList<Reserva> reservasAlvo = new ArrayList<>();
        ArrayList<Motorista> motoristasDisponíveis = new ArrayList<>(motoristas);
        LocalDate datafim = dataReq.plusDays(nDias);//calcula data fim do periodo de reserva pretendido
        LocalDate hoje = LocalDate.now(); //data de hoje
        long difDias;//diferença de dias
        Autocarro autocarro = new Autocarro();
        Motorista motorista = new Motorista();

        //Verificar se existe algum autocarro(e respetivo motorista) reservado para o período solicitado

        for (Autocarro bus : autocarros) {
            if (bus.getLotacao() >= nPessoas) {
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
            //Ordenar autocarros disponíveis por ordem cerscente relativamente à sua capacidade
            autDisponiveis.sort(Comparator.comparing(Autocarro::getLotacao));
            autocarro = autDisponiveis.get(0);
            motorista = motoristasDisponíveis.get(0);
            //Criar e adicionar reserva à lista de reservas da Empresa
            resultadoReserva = "Sucesso";
            Reserva reserva1 = new Reserva(cliente, autocarro, motorista, hoje, dataReq, nDias, nPessoas,
                    "partida", "destino", distancia);
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
                Reserva reserva2 = new Reserva(cliente, autocarro, motorista, hoje, dataReq, nDias, nPessoas,
                        "partida", "destino", distancia);
                reservas.add(reserva2);
            } else {
                autocarro = null;
                motorista = null;
                //Criar e adicionar reserva à lista de reservas em Espera
                resultadoReserva = "Espera";
                Reserva reserva3 = new Reserva(cliente, autocarro, motorista, hoje, dataReq, nDias, nPessoas,
                        "partida", "destino", distancia);
                reservasemEspera.add(reserva3);
            }
        }
        gravarFicheiro();
        return resultadoReserva;
    }

    //Identificar o Autocarro que foi atribuido à reserva
    public Autocarro identificarAutocarroReservado(Reserva reserva) {
        return reserva.getAutocarro();
    }

    //Adicionar notificação de cancelamento à lista de Notificações do Cliente
    //- verifica tipo de subscrição do cliente
    //- verifica se tem direito a reembolso
    //- adiciona notificação à lista de notificações do cliente
    public void adicionarNotificaçãoCancelamento(Reserva reserva) {
        //Calcular diferença de dias entre hoje e a data partida
        LocalDate hoje = LocalDate.now(); //data de hoje
        long diferençaDias = ChronoUnit.DAYS.between(hoje, reserva.getDataPartida());
        double reembolso;

        //Adicionar notificação à lista de Notificações do Cliente cancelado
        //Cliente "normal" tem direito a reembolso com penalização 50% se diferençaDias>7
        if (diferençaDias > 7 && reserva.getCliente().getTipoCliente().equals("Normal")) {
            reembolso = (reserva.getCusto() / 2.0);
            Notificação cancelamento = new Notificação(reserva.getCliente().getEmail(),
                    "A sua reserva do dia " + reserva.getDataPartida() + " foi cancelada. " +
                            "Irá ser reembolsado pelo valor de " + reembolso + "€, através de" + identificarTipoPagamento(reserva),
                    hoje, false);
            reserva.getCliente().getNotificações().add(cancelamento);

            //Cliente "premium" tem direito a reembolso na sua totalidade se diferençaDias>2
        } else if (diferençaDias > 2 && reserva.getCliente().getTipoCliente().equals("Premium")) {
            reembolso = reserva.getCusto();
            Notificação cancelamento = new Notificação(reserva.getCliente().getEmail(),
                    "A sua reserva do dia " + reserva.getDataPartida() + " foi cancelada. " +
                            "Irá ser reembolsado pelo valor de " + reembolso + "€, através de" + identificarTipoPagamento(reserva),
                    hoje, false);
            reserva.getCliente().getNotificações().add(cancelamento);
            //Caso não se verifiquem nenhuma das condições anteriores, o cliente não tem direito a reembolso
        } else {
            Notificação cancelamento = new Notificação(reserva.getCliente().getEmail(),
                    "A sua reserva do dia " + reserva.getDataPartida() +
                            " foi cancelada. De acordo, com o seu pacote de subscrição, não irá ter direito a reembolso", hoje, false);
            reserva.getCliente().getNotificações().add(cancelamento);
        }
    }

    //Identificar tipo de pagamento, para efetuar reembolso
    public String identificarTipoPagamento(Reserva reserva) {

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
    public void cancelarReservaemEspera(Reserva reserva) {reservasemEspera.remove(reserva);
    }

    //Cancela reserva pelo cliente, e verifica se os clientes em lista espera
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
                if (reservasemEspera.size() != 0) {verificarListaEspera(res);}

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

    //Verificar reservas em lista de espera, após ter sido cancelada uma reserva
    // - Este método só é corrido se a dimensão da lista de espera for diferente de 0;
    // - Verificar se o autocarro da reserva cancelada cumpre os requisitos da reserva em lista de espera,
    // nomeadamente lotação e período de aluguer.
    //criar uma lista, para guardar o nº de reservas em espera candidatas
    //Identificar email do cliente/clientes e adicionar notificação à lista do/s Cliente/s
    //Remove reserva da lista de espera, cria nova reserva e adiciona à lista de reservas da empresa
    public void verificarListaEspera(Reserva reserva) {

        ArrayList<Reserva> candidatas = new ArrayList<>();
        Notificação notificaçãoReserva = null;
        LocalDate hoje = LocalDate.now(); //data de hoje

        for (Reserva resEspera : reservasemEspera) {
            if (resEspera.getNumeroPessoas() <= reserva.getAutocarro().getLotacao()) {
                if ((resEspera.getDataPartida().isEqual(reserva.getDataPartida())) &&
                        (resEspera.getDataPartida().isBefore(reserva.getDataFim())) &&
                        (resEspera.getDataFim().isBefore(reserva.getDataFim()))) {
                    candidatas.add(resEspera);
                } if (candidatas.size() >= 1) {
                    for (int i = 0; i < candidatas.size(); i++) {
                        notificaçãoReserva = new Notificação(candidatas.get(i).getCliente().getEmail(), "RE: A sua reserva em espera foi processada,proceda ao seu pagamento " +
                                ".Data de partida em " + candidatas.get(i).getDataPartida()+".Custo: "+candidatas.get(i).getCusto(), hoje, false);
                        //Adiciona notificação à lista das notificaçóes do cliente
                        candidatas.get(i).getCliente().getNotificações().add(notificaçãoReserva);
                    }
                }
            }
        }
        if(candidatas.size()==1)
            //Remove reserva da lista de espera
            reservasemEspera.remove(candidatas.get(0));
        //Cria nova reserva
        Reserva novaReserva=new Reserva(candidatas.get(0).getCliente(),reserva.getAutocarro(),
                reserva.getMotorista(),hoje,candidatas.get(0).getDataPartida(),
                candidatas.get(0).getNumeroDias(),candidatas.get(0).getNumeroPessoas(),candidatas.get(0).getLocalPartida(),
                candidatas.get(0).getLocalDestino(),candidatas.get(0).getDistancia());
        //Adiciona nova reserva à lista de reservas
        reservas.add(novaReserva);
    }

    //Cancelamento reservas, por cliente ter sido removido por um Administrador
    //1ª- remover todas as reservas desse cliente da lista de reservas da empresa
    //2º - adicionar as reservas canceladas à lista de reservas canceladas
    //3º -Verificar se existem clientes em lista de espera que possam ficar com esta reserva
    //4º - Notificar cliente, que foi removido da aplicação
    //5º - Método Adicionar Notificação de Cancelamento de reservas
    //- verifica tipo de subscrição do cliente
    //- verifica se tem direito a reembolso
    //- adiciona notificação à lista de notificações do cliente
    public void cancelarReservasporAdministrador(int nifCliente) {
        LocalDate hoje = LocalDate.now(); //data de hoje
        for (Reserva res : reservas) {
            if (res.getCliente().getNif() == nifCliente) {
                //Identificar a reserva, remover da lista de reservas e adicionar à lista de reservas canceladas
                reservas.remove(res);
                reservasCanceladas.add(res);

                //Verificar se existem clientes em lista de espera que possam ficar com esta reserva
                if (reservasemEspera.size() != 0) {verificarListaEspera(res);}

                //Criar e adicionar notificação de que o cliente foi removido,pelo que só terá acesso ao login
                Notificação clienteRemovido = new Notificação(res.getCliente().getEmail(),
                        "Foi removido da aplicação desta empresa.Pelo que não terá acesso ao seu menu Cliente",
                        hoje, false);
                res.getCliente().getNotificações().add(clienteRemovido);
                //Adicionar notificação de cancelamento de reserva à lista de notificações do cliente
                adicionarNotificaçãoCancelamento(res);
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

        for(Autocarro bus:autocarros){
            if(bus.getMatricula().equals(matrícula)){
                autocarros.remove(bus);
            }
        }

        for (Reserva res : reservas) {
            if (res.getAutocarro().getMatricula().equals(matrícula)) {
                reservas.remove(res);
                reservasCanceladas.add(res);
                //Criar e adicionar notificação de que o autocarro foi removido
                Notificação autocarroRemovido = new Notificação(res.getCliente().getEmail(),
                        "Pedimos imensa desculpa pelo transtorno, mas o autocarro associado à sua reserva deixou de fazer parte da frota desta empresa.",
                        hoje, false);
                res.getCliente().getNotificações().add(autocarroRemovido);
                //Adicionar notificação de cancelamento de reserva à lista de notificações do cliente
                adicionarNotificaçãoCancelamento(res);
            }
        }
    }
}
