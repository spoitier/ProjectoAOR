package interfacegrafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HistoricoReservas extends JPanel implements ActionListener {

    PainelFundo painelFundo;
    JButton sairBotao;
    JButton opcao1;
    JButton opcao2;
    JButton opcao3;
    JButton opcao4;
    JButton opcao5;

    public HistoricoReservas(PainelFundo painelFundo) {
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
        JLabel segundoTitulo = new JLabel("Historico de reservas\n");
        segundoTitulo.setBounds(50, 100, 900, 30);
        this.add(segundoTitulo);

        // Botoes de filtragem
        JPanel botoesFiltro = new JPanel(new GridLayout(1, 4, 5, 5));
        botoesFiltro.setBounds(100, 150, 200, 30);
        JLabel anoLabel = new JLabel("Ano:");
        JLabel mesLabel = new JLabel("Mes:");
        JTextField anoField = new JTextField();
        JTextField mesField = new JTextField();
        botoesFiltro.add(anoLabel);
        botoesFiltro.add(anoField);
        botoesFiltro.add(mesLabel);
        botoesFiltro.add(mesField);
        this.add(botoesFiltro);

        //========================================
        // Tabela

        String[] colunas = {"Nº programa.Reserva", "Data Aluguer", "NºDias", "NºPessoas",
                "Local Partida", "Local Destino", "Custo total Viagem", "Estado"};

        String[][] data = {{"111", "19/12/2022", "15", "30", "Coimbra", "Lisboa", "50", "Pendente"}
                , {"121", "21/12/2022", "15", "30", "Coimbra", "Lisboa", "50", "Pendente"}};

        JTable tabela = new JTable(data, colunas);
        JScrollPane sp = new JScrollPane(tabela);
        sp.setBounds(100, 200, 500, 400);
        this.add(sp);

        opcao1.addActionListener(this);
        opcao2.addActionListener(this);
        opcao3.addActionListener(this);
        opcao4.addActionListener(this);
        opcao5.addActionListener(this);
        sairBotao.addActionListener(this);




    }


    @Override
    public void actionPerformed(ActionEvent e) {
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

    }
}
