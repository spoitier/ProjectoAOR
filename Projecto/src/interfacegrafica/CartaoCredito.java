package interfacegrafica;

import programa.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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


    public CartaoCredito(PainelFundo painelfundo) {

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
        JLabel clienteNome = new JLabel("Nome do Cliente");
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
        JLabel valorViagem = new JLabel("Valor");
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

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean validar = true;
        Cliente logado;
        Pagamento pagamento;
        Reserva reserva;
        LocalDate dataExpiração = LocalDate.parse(dataExpiracaoField.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));


        if (e.getActionCommand().equals("Confirmar")) {
            if (numeroCartaoField.getText().equals("") || nomeClienteField.getText().equals("")
                    || dataExpiracaoField.getText().equals("") || codigoSegurancaField.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Há campos de preenchimento obrigatório que não foram preenchidos");
                validar = false;
            }
            //Verificar se o número do cartão crédito é constituído por 14-16 números
            if (!programa.CartaoCredito.validarnumCartaoCredito(numeroCartaoField.getText())) {
                JOptionPane.showMessageDialog(null, "Número Cartão Crédito inválido");
                validar = false;
            }

            //Verificar se o nome é constituído só por letras
            if (!programa.CartaoCredito.validarNome(nomeClienteField.getText())) {
                JOptionPane.showMessageDialog(null, "Nome com carateres inválidos");
                validar = false;
            }
            //Verificar se data Aluguer é válida
            if (!programa.CartaoCredito.validarDataFormato(dataExpiracaoField.getText())) {
                JOptionPane.showMessageDialog(null, "Por favor,preencha a data com o formato dd/mm/AAAA");
                validar = false;
            } else if (!programa.CartaoCredito.validarDataValida(dataExpiracaoField.getText())) {
                JOptionPane.showMessageDialog(null, "Data com mês ou dia inválidos");
                validar = false;
            } else if (!programa.CartaoCredito.validarDataExpiração(dataExpiracaoField.getText())) {
                JOptionPane.showMessageDialog(null, "Data de Expiração não pode ser inferior à data atual");
                validar = false;
            }
            //Verificar se o pin de segurança do cartão crédito é constituído por 3 números
            if (!programa.CartaoCredito.validarPinCartaoCredito(codigoSegurancaField.getText())) {
                JOptionPane.showMessageDialog(null, "Pin inválido");
                validar = false;
            }
            if (validar) {
                logado = (Cliente) aor_autocarro.getUserLogado();
                reserva = aor_autocarro.identificarReservaPagamento(logado);
                pagamento = new programa.CartaoCredito(reserva, numeroCartaoField.getText(), nomeClienteField.getText(),
                        dataExpiração, codigoSegurancaField.getText());
                //Adicionado pagamento da reserva à lista de Reservas
                aor_autocarro.addPagamento(pagamento);
                JOptionPane.showMessageDialog(null, "O pagamento da sua reserva" +
                        " nº" + Reserva.getId() + " no valor de " + reserva.getCusto() + "€");
                FicheiroDeObjectos.escreveObjeto(aor_autocarro);
            }
        }

        if (e.getActionCommand().equals("ReservaViagem")) {
            painelFundo.mudaEcra("ReservaViagem");
        }

        if (e.getActionCommand().equals("Histórico Reservas")) {
            painelFundo.mudaEcra("HistoricoReservas");
        }

        if (e.getActionCommand().equals("Consultar Reservas")) {
            painelFundo.mudaEcra("ConsultarReservas");
        }

        if (e.getActionCommand().equals("Cancelar Reservas")) {
            painelFundo.mudaEcra("CancelarReserva");
        }
        if (e.getActionCommand().equals("Dados Pessoais")) {
            painelFundo.mudaEcra("DadosPessoaisClientes");
        }
        if (e.getActionCommand().equals("Sair")) {
            painelFundo.mudaEcra("Login");
        }
        if (e.getActionCommand().equals("Mudar Pagamento")) {
            painelFundo.mudaEcra("Pagamentos");

        }

    }
}