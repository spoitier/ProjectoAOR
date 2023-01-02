package interfacegrafica;

import programa.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PayPal extends JPanel implements ActionListener {

    Aor_Autocarro aor_autocarro;
    PainelFundo painelFundo;

    JButton opcao1;
    JButton opcao2;
    JButton opcao3;
    JButton opcao4;
    JButton opcao5;

    JButton botaoConfirmar;
    JButton paypalButton;

    JButton mudarPagamentoButton;
    JButton sairBotao;
    JLabel login;
    JLabel email;
    JLabel palavraChave;
    TextField emailField;
    JPasswordField palavraChaveField;

    public PayPal(PainelFundo painelFundo,Aor_Autocarro aor_autocarro) {
        this.aor_autocarro=aor_autocarro;
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
        JLabel valorViagem = new JLabel("Valor");
        valorViagem.setBounds(75, 100, 200, 10);
        custoViagem.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        custoViagem.add(tituloCusto);
        custoViagem.add(valorViagem);
        this.add(custoViagem);

        //===========================================
        //programa.Paypal

        JPanel pagamentoPanel = new JPanel(new GridLayout(2, 1, 0, 15));
        pagamentoPanel.setBounds(200, 200, 350, 100);
        JLabel tipoPagamento = new JLabel("TIPO DE PAGAMENTO");
        paypalButton = new JButton("PayPAL");
        pagamentoPanel.add(tipoPagamento);
        pagamentoPanel.add(paypalButton);
        this.add(pagamentoPanel);

        //================================================================
        //Painel do Login
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);
        loginPanel.setBounds(200, 300, 350, 200);

        //Label do login
        login = new JLabel("Login:");
        login.setBounds(10, 0, 50, 30);

        //Label do email
        email = new JLabel("Email");
        email.setBounds(30, 50, 80, 30);

        //Label da palavra chave
        palavraChave = new JLabel("Palavra-Chave");
        palavraChave.setBounds(30, 100, 100, 30);

        // Textofield do email
        emailField = new TextField("Escreve aqui o seu email");
        emailField.setBounds(150, 50, 170, 30);

        // Textofield da palavrachave
        palavraChaveField = new JPasswordField("Escreve aqui a sua Palavra-Chave");
        palavraChaveField.setBounds(150, 100, 170, 30);
        loginPanel.add(email);
        loginPanel.add(palavraChave);
        loginPanel.add(emailField);
        loginPanel.add(palavraChaveField);
        this.add(loginPanel);

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
        boolean validar=true;
        String email = emailField.getText();
        String password = new String(palavraChaveField.getPassword());//para transformar em string
        Cliente logado;
        Pagamento pagamento;
        Reserva reserva;

        if(e.getActionCommand().equals("Confirmar")){
            if (emailField.getText().equals("") || password.equals("")) {
                JOptionPane.showMessageDialog(null, "Há campos de preenchimento obrigatório que não foram preenchidos");
            validar=false;
            }
            if(!Paypal.validarEmail(email)){
                JOptionPane.showMessageDialog(null, "Email inválido");
            validar=false;
            }
            if(validar){
                logado = (Cliente) aor_autocarro.getUserLogado();
                reserva=aor_autocarro.identificarReservaPagamento(logado);
                pagamento=new Paypal(reserva,email,password);
                //Adicionado pagamento da reserva à lista de Reservas
                aor_autocarro.addPagamento(pagamento);
                JOptionPane.showMessageDialog(null, "O pagamento da sua reserva" +
                        " nº"+reserva.getId()+" no valor de €");
                FicheiroDeObjectos.escreveObjeto(aor_autocarro);
            }
        }

        if(e.getActionCommand().equals("ReservaViagem")) {
            painelFundo.mudaEcra("ReservaViagem");
        }

        if(e.getActionCommand().equals("Histórico Reservas")) {
            painelFundo.mudaEcra("HistoricoReservas");
        }

        if(e.getActionCommand().equals("Consultar Reservas")) {
            painelFundo.mudaEcra("ConsultarReservas");
        }

        if(e.getActionCommand().equals("Cancelar Reservas")) {
            painelFundo.mudaEcra("CancelarReserva");
        }
        if(e.getActionCommand().equals("Dados Pessoais")) {
            painelFundo.mudaEcra("DadosPessoaisClientes");
        }
        if(e.getActionCommand().equals("Sair")){
            painelFundo.mudaEcra("Login");
        }
        if(e.getActionCommand().equals("Mudar Pagamento")){
            painelFundo.mudaEcra("Pagamentos");

        }



    }
}
