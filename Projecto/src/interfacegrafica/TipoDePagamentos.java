package interfacegrafica;

import programa.Reserva;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TipoDePagamentos extends JPanel implements ActionListener {
    PainelFundo painelFundo;
    Reserva reserva;
    JLabel valorViagem;

    JButton opcao1;
    JButton opcao2;
    JButton opcao3;
    JButton opcao4;
    JButton opcao5;

    JButton paypalButton;
    JButton cartaoCreditoButton;
    JButton multibancoButton;
    JLabel clienteNome;
    JButton sairBotao;


    public TipoDePagamentos(PainelFundo painelFundo) {
        this.painelFundo = painelFundo;
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


        opcao1 = new JButton("ReservaViagem");
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

        //Botoes de programa.Pagamento

        JPanel pagamentoPanel = new JPanel(new GridLayout(4, 1, 0, 30));
        pagamentoPanel.setBounds(200, 200, 400, 350);
        JLabel tipoPagamento = new JLabel("TIPO DE PAGAMENTO");
        paypalButton = new JButton("PayPAL");
        cartaoCreditoButton = new JButton("Cartão de Crédito");
        multibancoButton = new JButton("Multibanco");
        pagamentoPanel.add(tipoPagamento);
        pagamentoPanel.add(paypalButton);
        pagamentoPanel.add(cartaoCreditoButton);
        pagamentoPanel.add(multibancoButton);
        this.add(pagamentoPanel);


        opcao1.addActionListener(this);
        opcao2.addActionListener(this);
        opcao3.addActionListener(this);
        opcao4.addActionListener(this);
        opcao5.addActionListener(this);
        paypalButton.addActionListener(this);
        cartaoCreditoButton.addActionListener(this);
        multibancoButton.addActionListener(this);


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
        int resultado;
        if(e.getActionCommand().equals("ReservaViagem")) {
            resultado = JOptionPane.showConfirmDialog(null, "A sua reserva ainda não está paga." +
                    "Tem a certeza que quer cancelar?", "Escolha uma opção", JOptionPane.YES_NO_OPTION);
            if (resultado == JOptionPane.YES_OPTION) {
                painelFundo.mudaEcra("ReservaViagem");
            }
        }

        if(e.getActionCommand().equals("Histórico Reservas")) {
            resultado = JOptionPane.showConfirmDialog(null, "A sua reserva ainda não está paga." +
                    "Tem a certeza que quer cancelar?", "Escolha uma opção", JOptionPane.YES_NO_OPTION);
            if (resultado == JOptionPane.YES_OPTION) {
                painelFundo.mudaEcra("HistoricoReservas");
            }
        }

        if(e.getActionCommand().equals("Consultar Reservas")) {
            resultado = JOptionPane.showConfirmDialog(null, "A sua reserva ainda não está paga." +
                    "Tem a certeza que quer cancelar?", "Escolha uma opção", JOptionPane.YES_NO_OPTION);
            if (resultado == JOptionPane.YES_OPTION) {
                painelFundo.mudaEcra("ConsultarReservas");
            }
        }

        if(e.getActionCommand().equals("Cancelar Reservas")) {
            resultado = JOptionPane.showConfirmDialog(null, "A sua reserva ainda não está paga." +
                    "Tem a certeza que quer cancelar?", "Escolha uma opção", JOptionPane.YES_NO_OPTION);
            if (resultado == JOptionPane.YES_OPTION) {
                painelFundo.mudaEcra("CancelarReserva");
            }
        }
        if(e.getActionCommand().equals("Dados Pessoais")) {
            resultado = JOptionPane.showConfirmDialog(null, "A sua reserva ainda não está paga." +
                    "Tem a certeza que quer cancelar?", "Escolha uma opção", JOptionPane.YES_NO_OPTION);
            if (resultado == JOptionPane.YES_OPTION) {
                painelFundo.mudaEcra("DadosPessoaisClientes");
            }
        }
        if(e.getActionCommand().equals("Sair")) {
            resultado = JOptionPane.showConfirmDialog(null, "A sua reserva ainda não está paga." +
                    "Tem a certeza que quer cancelar?", "Escolha uma opção", JOptionPane.YES_NO_OPTION);
            if (resultado == JOptionPane.YES_OPTION) {
                ((Login)painelFundo.mapaPaineis.get("Login")).sair();
                painelFundo.mudaEcra("Login");
            }
        }
        if(e.getActionCommand().equals("PayPAL")){
            ((PayPal)(painelFundo.mapaPaineis.get("PayPal"))).custoAutocarro(this.reserva);
            painelFundo.mudaEcra("PayPal");
        }
        if(e.getActionCommand().equals("Cartão de Crédito")){
            ((CartaoCredito)(painelFundo.mapaPaineis.get("CartaoCredito"))).custoAutocarro(this.reserva);
            painelFundo.mudaEcra("CartaoCredito");
        }
        if(e.getActionCommand().equals("Multibanco")){
            ((Multibanco)(painelFundo.mapaPaineis.get("Multibanco"))).custoAutocarro(this.reserva);
            painelFundo.mudaEcra("Multibanco");
        }

    }
}