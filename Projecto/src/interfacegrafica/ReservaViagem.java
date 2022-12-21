package interfacegrafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReservaViagem extends JPanel implements ActionListener {

    PainelFundo painelFundo;
    JButton prosseguirButton;

    public ReservaViagem(PainelFundo painelFundo) {
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
        JLabel clienteNome = new JLabel("Nome do programa.Cliente");
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

        JButton opcao1 = new JButton("programa.Reserva programa.Autocarro");
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
        JLabel segundoTitulo =new JLabel("Realizar reserva de programa.Autocarro:\n");
        segundoTitulo.setBounds(50,100,900,30);
        this.add(segundoTitulo);

        //=====================================================================

        JPanel formulario = new JPanel();
        formulario.setLayout(null);
        formulario.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        formulario.setBounds(200, 200, 400, 350);


        //Labels
        JLabel dataAluguer = new JLabel("Data do Aluguer:");
        dataAluguer.setBounds(40, 50, 200, 30);
        JLabel numeroDias = new JLabel("Numero de dias:");
        numeroDias.setBounds(40, 90, 200, 30);
        JLabel numeroPessoas = new JLabel("Numero de Pessoas:");
        numeroPessoas.setBounds(40, 130, 200, 30);
        JLabel partida = new JLabel("Partida:");
        partida.setBounds(40, 170, 200, 30);
        JLabel destino = new JLabel("Destino:");
        destino.setBounds(40, 210, 200, 30);
        JLabel numeroKmTotal = new JLabel("Numero Km total:");
        numeroKmTotal.setBounds(40, 250, 200, 30);

        //Fields
        JTextField dataAluguerField = new JTextField();
        dataAluguerField.setBounds(160, 50, 200, 30);
        JTextField numeroDiasField = new JTextField();
        numeroDiasField.setBounds(160, 90, 200, 30);
        JTextField numeroPessoasField = new JTextField();
        numeroPessoasField.setBounds(160, 130, 200, 30);
        JTextField partidaField = new JTextField();
        partidaField.setBounds(160, 170, 200, 30);
        JTextField destinoField = new JTextField();
        destinoField.setBounds(160, 210, 200, 30);
        JTextField numeroKmTotalField = new JTextField();
        numeroKmTotalField.setBounds(160, 250, 200, 30);

        formulario.add(dataAluguer);
        formulario.add(numeroDias);
        formulario.add(numeroPessoas);
        formulario.add(partida);
        formulario.add(destino);
        formulario.add(numeroKmTotal);
        formulario.add(dataAluguerField);
        formulario.add(numeroDiasField);
        formulario.add(numeroPessoasField);
        formulario.add(partidaField);
        formulario.add(destinoField);
        formulario.add(numeroKmTotalField);
        this.add(formulario);

        //==========================================================

        //Botão para registar
        prosseguirButton = new JButton("Prosseguir");
        prosseguirButton.setBounds(340, 575, 200, 70);
        this.add(prosseguirButton);

        //============================================
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

















    }

    @Override
    public void actionPerformed(ActionEvent e) {



    }
}
