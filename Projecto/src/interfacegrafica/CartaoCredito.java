package interfacegrafica;

import javax.swing.*;
import java.awt.*;

public class CartaoCredito  extends JPanel {

    PainelFundo painelFundo;

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
        JButton sairBotao = new JButton("Sair");
        sairBotao.setBounds(810, 1, 70, 28);
        cabecalho.add(sairBotao);
        this.add(cabecalho);

        //===========================================================
        //Painel de escolhas do cliente
        JPanel opcaoPainel = new JPanel();
        opcaoPainel.setLayout(new GridLayout(1, 5,15,0));
        opcaoPainel.setBounds(0, 35, 900, 50);
        opcaoPainel.setBorder(BorderFactory.createLineBorder(Color.BLACK));



        JButton opcao1 = new JButton("Reserva Autocarro");
        JButton opcao2 = new JButton("Histórico Reservas");
        JButton opcao3 = new JButton("Consultar Reservas");
        JButton opcao4 = new JButton("Cancelar Reservas");
        JButton opcao5 = new JButton("Dados Pessoais");

        opcaoPainel.add(opcao1);
        opcaoPainel.add(opcao2);
        opcaoPainel.add(opcao3);
        opcaoPainel.add(opcao4);
        opcaoPainel.add(opcao5);

        this.add(opcaoPainel);

        //=====================================================================
        //Segundo titulo
        JLabel segundoTitulo =new JLabel("Realizar reserva de Autocarro:\n");
        segundoTitulo.setBounds(50,100,900,30);
        this.add(segundoTitulo);

        //=====================================================================
        //Custo da viagem
        JPanel custoViagem = new JPanel();
        custoViagem.setLayout(null);
        custoViagem.setBounds(625,250,200,200);
        JLabel tituloCusto = new JLabel("CUSTO DA VIAGEM");
        tituloCusto.setBounds(45,30,200,10);
        JLabel valorViagem = new JLabel("Valor");
        valorViagem.setBounds(75,100,200,10);
        custoViagem.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        custoViagem.add(tituloCusto);
        custoViagem.add(valorViagem);
        this.add(custoViagem);

        //===========================================
        //Paypal

        JPanel pagamentoPanel= new JPanel(new GridLayout(2,1,0,15));
        pagamentoPanel.setBounds(200,150,350,100);
        JLabel tipoPagamento = new JLabel("TIPO DE PAGAMENTO");
        JButton paypalButton = new JButton("CARTÃO CREDITO");
        pagamentoPanel.add(tipoPagamento);
        pagamentoPanel.add(paypalButton);
        this.add(pagamentoPanel);

        //================================================================
        //Painel do Login
        JPanel cartaoCreditoPanel = new JPanel();
        cartaoCreditoPanel.setLayout(null);
        cartaoCreditoPanel.setBounds(150, 275, 425, 250);

        //Label do numerocartao
        JLabel numeroCartao = new JLabel("Nº Cartão:");
        numeroCartao.setBounds(0, 25, 80, 30);

        //Label do nome cliente
        JLabel nomeCliente = new JLabel("Nome do Cliente do cartão:\n");
        nomeCliente.setBounds(0, 75, 200, 30);

        //Label do nome cliente
        JLabel dataExpiracao = new JLabel("Data expiração: ");
        dataExpiracao.setBounds(0, 125, 200, 30);

        //Label do nome cliente
        JLabel codigoSeguranca = new JLabel("Codigo de Segurança:");
        codigoSeguranca.setBounds(0, 175, 200, 30);


        // Textofield do numero cartao
        TextField numeroCartaoField = new TextField();
        numeroCartaoField.setBounds(200, 25, 170, 30);

        // Textofield do nome cliente
        TextField nomeClienteField = new TextField();
        nomeClienteField.setBounds(200, 75, 170, 30);

        // Textofield da data expiracao
        TextField dataExpiracaoField = new TextField();
        dataExpiracaoField.setBounds(200, 125, 170, 30);

        // Textofield do codigo Segurança
        TextField codigoSegurancaField = new TextField();
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
        JButton botaoConfirmar = new JButton("Confirmar");
        botaoConfirmar.setBounds(225, 550, 300, 60);
        this.add(botaoConfirmar);

    }
}