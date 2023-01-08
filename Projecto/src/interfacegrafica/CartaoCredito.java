package interfacegrafica;

import programa.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CartaoCredito extends JPanel implements ActionListener {

    Aor_Autocarro aor_autocarro;

    CartaoCredito cartão;
    PainelFundo painelFundo;
    JButton sairBotao;
    JButton opcao1;
    JButton opcao2;
    JButton opcao3;
    JButton opcao4;
    JButton opcao5;

    JButton cartaocreditoButton;
    JButton botaoConfirmar;
    JButton mudarPagamentoButton;
    JLabel numeroCartao;
    JLabel nomeCliente;
    JLabel dataExpiracao;
    JLabel codigoSeguranca;
    TextField numeroCartaoField;
    TextField nomeClienteField;
    TextField dataExpiracaoField;
    TextField codigoSegurancaField;
    JLabel clienteNome;
    JLabel valorViagem;
    Reserva reserva;


    public CartaoCredito(PainelFundo painelfundo,Aor_Autocarro aor_autocarro) {
this.aor_autocarro=aor_autocarro;
        this.painelFundo = painelfundo;
        this.setLayout(null);

        //===================================================
        //Painel do Cabeçalho
        JPanel cabecalho = new JPanel();
        cabecalho.setLayout(null);
        cabecalho.setBounds(0, 0, 900, 30);

        //Label do nome da empresa
        JLabel empresaNome = new JLabel("Aor-Autocarros");
        empresaNome.setBounds(5, 0, 100, 30);
        cabecalho.add(empresaNome);

        // Nome do cliente
        clienteNome = new JLabel("Nome do Cliente");
        clienteNome.setBounds(700, 0, 100, 30);
        cabecalho.add(clienteNome);

        // Botao para sair para o login
        sairBotao = new JButton("Sair");
        sairBotao.setBounds(810, 1, 70, 28);
        cabecalho.add(sairBotao);
        this.add(cabecalho);

        //===========================================================
        //Painel de escolhas do cliente
        JPanel opcaoPainel = new JPanel();
        opcaoPainel.setLayout(new GridLayout(1, 5, 15, 0));
        opcaoPainel.setBounds(0, 35, 900, 50);
        opcaoPainel.setBorder(BorderFactory.createLineBorder(Color.BLACK));


        opcao1 = new JButton("programa.Reserva Autocarro");
        opcao2 = new JButton("Histórico Reservas");
        opcao3 = new JButton("Consultar Reservas");
        opcao4 = new JButton("Cancelar Reservas");
        opcao5 = new JButton("Dados Pessoais");

        opcaoPainel.add(opcao1);
        opcaoPainel.add(opcao2);
        opcaoPainel.add(opcao3);
        opcaoPainel.add(opcao4);
        opcaoPainel.add(opcao5);

        this.add(opcaoPainel);

        //=====================================================================
        //Segundo titulo
        JLabel segundoTitulo = new JLabel("Realizar reserva de Autocarro:\n");
        segundoTitulo.setBounds(50, 100, 900, 30);
        this.add(segundoTitulo);

        //=====================================================================
        //Custo da viagem
        JPanel custoViagem = new JPanel();
        custoViagem.setLayout(null);
        custoViagem.setBounds(625, 250, 200, 200);
        JLabel tituloCusto = new JLabel("CUSTO DA VIAGEM");
        tituloCusto.setBounds(45, 30, 200, 10);
        valorViagem = new JLabel("Valor");
        valorViagem.setBounds(75, 100, 200, 10);
        custoViagem.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        custoViagem.add(tituloCusto);
        custoViagem.add(valorViagem);
        this.add(custoViagem);

        //===========================================
        //programa.Paypal

        JPanel pagamentoPanel = new JPanel(new GridLayout(2, 1, 0, 15));
        pagamentoPanel.setBounds(200, 150, 350, 100);
        JLabel tipoPagamento = new JLabel("TIPO DE PAGAMENTO");
        cartaocreditoButton = new JButton("CARTÃO CREDITO");
        pagamentoPanel.add(tipoPagamento);
        pagamentoPanel.add(cartaocreditoButton);
        this.add(pagamentoPanel);

        //================================================================
        //Painel do Login
        JPanel cartaoCreditoPanel = new JPanel();
        cartaoCreditoPanel.setLayout(null);
        cartaoCreditoPanel.setBounds(170, 275, 425, 225);

        //Label do numerocartao
        numeroCartao = new JLabel("Nº Cartão:");
        numeroCartao.setBounds(0, 25, 80, 30);

        //Label do nome cliente
        nomeCliente = new JLabel("Nome do Cliente do cartão:\n");
        nomeCliente.setBounds(0, 75, 200, 30);

        //Label do nome cliente
        dataExpiracao = new JLabel("Data expiração: ");
        dataExpiracao.setBounds(0, 125, 200, 30);

        //Label do nome cliente
        codigoSeguranca = new JLabel("Codigo de Segurança:");
        codigoSeguranca.setBounds(0, 175, 200, 30);


        // Textofield do numero cartao
        numeroCartaoField = new TextField();
        numeroCartaoField.setBounds(200, 25, 170, 30);

        // Textofield do nome cliente
        nomeClienteField = new TextField();
        nomeClienteField.setBounds(200, 75, 170, 30);

        // Textofield da data expiracao
        dataExpiracaoField = new TextField();
        dataExpiracaoField.setBounds(200, 125, 170, 30);

        // Textofield do codigo Segurança
        codigoSegurancaField = new TextField();
        codigoSegurancaField.setBounds(200, 175, 170, 30);

        cartaoCreditoPanel.add(numeroCartao);
        cartaoCreditoPanel.add(nomeCliente);
        cartaoCreditoPanel.add(dataExpiracao);
        cartaoCreditoPanel.add(codigoSeguranca);
        cartaoCreditoPanel.add(numeroCartaoField);
        cartaoCreditoPanel.add(nomeClienteField);
        cartaoCreditoPanel.add(dataExpiracaoField);
        cartaoCreditoPanel.add(codigoSegurancaField);
        cartaoCreditoPanel.add(codigoSegurancaField);
        this.add(cartaoCreditoPanel);


        //Botão de auntenticar
        botaoConfirmar = new JButton("Confirmar");
        botaoConfirmar.setBounds(225, 500, 300, 50);
        this.add(botaoConfirmar);
        mudarPagamentoButton = new JButton("Mudar Pagamento");
        mudarPagamentoButton.setBounds(225, 600, 300, 50);
        this.add(mudarPagamentoButton);

        opcao1.addActionListener(this);
        opcao2.addActionListener(this);
        opcao3.addActionListener(this);
        opcao4.addActionListener(this);
        opcao5.addActionListener(this);
        botaoConfirmar.addActionListener(this);
        mudarPagamentoButton.addActionListener(this);
        sairBotao.addActionListener(this);
    }
    public void custoAutocarro(Reserva reserva) {
        if (!(reserva == null)) {
            this.reserva = reserva;
            clienteNome.setText(reserva.getCliente().getNome());
            valorViagem.setText(String.valueOf(reserva.getCusto()));

        }
    }






    @Override
    public void actionPerformed(ActionEvent e) {
        boolean validar = true;
        Cliente logado = (Cliente) aor_autocarro.getUserLogado();
        Pagamento pagamento;
        Reserva reserva;


        if (e.getActionCommand().equals("Confirmar")) {
            if (numeroCartaoField.getText().equals("") || nomeClienteField.getText().equals("")
                    || dataExpiracaoField.getText().equals("") || codigoSegurancaField.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Há campos de preenchimento obrigatório que não foram preenchidos");
                validar = false;
            }
            //Verificar se o número do cartão crédito é constituído por 14-16 números
            if (!Cartaocredito.validarnumCartaoCredito(numeroCartaoField.getText())) {
                JOptionPane.showMessageDialog(null, "Número Cartão Crédito inválido");
                validar = false;
            }

            //Verificar se o nome é constituído só por letras
            if (!Cartaocredito.validarNome(nomeClienteField.getText())) {
                JOptionPane.showMessageDialog(null, "Nome com carateres inválidos");
                validar = false;
            }
            //Verificar se data Aluguer é válida
            if (!Cartaocredito.validarDataFormato(dataExpiracaoField.getText())) {
                JOptionPane.showMessageDialog(null, "Por favor,preencha a data com o formato mm/AA");
                validar = false;
            } else if (!Cartaocredito.validarDataExpiração(dataExpiracaoField.getText())) {
                JOptionPane.showMessageDialog(null, "Data de Expiração inválida");
                validar = false;
            }
            //Verificar se o pin de segurança do cartão crédito é constituído por 3 números
            if (!Cartaocredito.validarPinCartaoCredito(codigoSegurancaField.getText())) {
                JOptionPane.showMessageDialog(null, "Pin inválido");
                validar = false;
            }
            if (validar) {
                reserva = aor_autocarro.identificarReservaPagamento(logado);
                //Adicionado reserva à lista de Reservas da Empresa
                aor_autocarro.addReserva(reserva);
                pagamento = new Cartaocredito(reserva, numeroCartaoField.getText(), nomeClienteField.getText(),
                        dataExpiracaoField.getText(), codigoSegurancaField.getText());
                //Adicionado pagamento da reserva à lista de Reservas
                aor_autocarro.addPagamento(pagamento);
                JOptionPane.showMessageDialog(null, "O pagamento da sua reserva" +
                        " nº" + reserva.getId() + " no valor de " + reserva.getCusto() + "€");
                FicheiroDeObjectos.escreveObjeto(aor_autocarro);
                painelFundo.mudaEcra("ConsultarReservas");
            }
        }

        int resultado;
        if(e.getActionCommand().equals("ReservaViagem")) {
            resultado = JOptionPane.showConfirmDialog(null, "A sua reserva ainda não está paga." +
                    "Tem a certeza que quer cancelar?", "Escolha uma opção", JOptionPane.YES_NO_OPTION);
            if (resultado == JOptionPane.YES_OPTION) {
                painelFundo.mudaEcra("ReservaViagem");
            }else{
                reserva=aor_autocarro.identificarReservaPagamento(logado);
                aor_autocarro.getReservas().remove(reserva);
            }
        }

        if(e.getActionCommand().equals("Histórico Reservas")) {
            resultado = JOptionPane.showConfirmDialog(null, "A sua reserva ainda não está paga." +
                    "Tem a certeza que quer cancelar?", "Escolha uma opção", JOptionPane.YES_NO_OPTION);
            if (resultado == JOptionPane.YES_OPTION) {
                painelFundo.mudaEcra("HistoricoReservas");
            }else{
                reserva=aor_autocarro.identificarReservaPagamento(logado);
                aor_autocarro.getReservas().remove(reserva);
            }
        }

        if(e.getActionCommand().equals("Consultar Reservas")) {
            resultado = JOptionPane.showConfirmDialog(null, "A sua reserva ainda não está paga." +
                    "Tem a certeza que quer cancelar?", "Escolha uma opção", JOptionPane.YES_NO_OPTION);
            if (resultado == JOptionPane.YES_OPTION) {
                painelFundo.mudaEcra("ConsultarReservas");
            }else{
                reserva=aor_autocarro.identificarReservaPagamento(logado);
                aor_autocarro.getReservas().remove(reserva);
            }
        }

        if(e.getActionCommand().equals("Cancelar Reservas")) {
            resultado = JOptionPane.showConfirmDialog(null, "A sua reserva ainda não está paga." +
                    "Tem a certeza que quer cancelar?", "Escolha uma opção", JOptionPane.YES_NO_OPTION);
            if (resultado == JOptionPane.YES_OPTION) {
                painelFundo.mudaEcra("CancelarReserva");
            }else{
                reserva=aor_autocarro.identificarReservaPagamento(logado);
                aor_autocarro.getReservas().remove(reserva);
            }
        }
        if(e.getActionCommand().equals("Dados Pessoais")) {
            resultado = JOptionPane.showConfirmDialog(null, "A sua reserva ainda não está paga." +
                    "Tem a certeza que quer cancelar?", "Escolha uma opção", JOptionPane.YES_NO_OPTION);
            if (resultado == JOptionPane.YES_OPTION) {
                painelFundo.mudaEcra("DadosPessoaisClientes");
            }else{
                reserva=aor_autocarro.identificarReservaPagamento(logado);
                aor_autocarro.getReservas().remove(reserva);
            }
        }
        if(e.getActionCommand().equals("Sair")) {
            resultado = JOptionPane.showConfirmDialog(null, "A sua reserva ainda não está paga." +
                    "Tem a certeza que quer cancelar?", "Escolha uma opção", JOptionPane.YES_NO_OPTION);
            if (resultado == JOptionPane.YES_OPTION) {
                ((Login)painelFundo.mapaPaineis.get("Login")).sair();
                painelFundo.mudaEcra("Login");
            }else{
                reserva=aor_autocarro.identificarReservaPagamento(logado);
                aor_autocarro.getReservas().remove(reserva);
            }
        }
        if (e.getActionCommand().equals("Mudar Pagamento")) {
            painelFundo.mudaEcra("Pagamentos");

        }

    }
}