package interfacegrafica;

import programa.Aor_Autocarro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultarReservas extends JPanel implements ActionListener {

    PainelFundo painelFundo;
    Aor_Autocarro aor_autocarro;
    JButton sairBotao;
    JButton opcao1;
    JButton opcao2;
    JButton opcao3;
    JButton opcao4;
    JButton opcao5;

    JTable tabela;
    JScrollPane sp;
    JLabel clienteNome;

    public ConsultarReservas(PainelFundo painelFundo, Aor_Autocarro aor_autocarro) {
        this.aor_autocarro = aor_autocarro;
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
        clienteNome = new JLabel();
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


        opcao1 = new JButton("Reserva Autocarro");
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
        JLabel segundoTitulo = new JLabel("Consultar reservas agendadas");
        segundoTitulo.setBounds(50, 100, 900, 30);
        this.add(segundoTitulo);

        // Botoes de filtragem
        JPanel botoesFiltro = new JPanel(new GridLayout(1, 4, 5, 5));
        botoesFiltro.setBounds(100, 150, 200, 30);
        JLabel mesLabel = new JLabel("Mes:");
        String[] mes = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        JComboBox mesCombobox = new JComboBox(mes);
        botoesFiltro.add(mesLabel);
        botoesFiltro.add(mesCombobox);
        this.add(botoesFiltro);


        //========================================
        // Tabela

        String[] colunas = {"Nº Reserva", "Data Aluguer", "NºDias", "NºPessoas",
                "Local Partida", "Local Destino", "Custo total Viagem", "Estado"};

        String[][] data = new String[aor_autocarro.getReservasemEspera().size()][8];
        for (int i = 0; i < aor_autocarro.getReservasemEspera().size(); i++) {
            data[i][0] = aor_autocarro.getReservasemEspera().get(i).toString();
            data[i][1] = String.valueOf(aor_autocarro.getReservasemEspera().get(i).getDataReserva());
            data[i][2] = String.valueOf(aor_autocarro.getReservasemEspera().get(i).getNumeroDias());
            data[i][3] = String.valueOf(aor_autocarro.getReservasemEspera().get(i).getNumeroPessoas());
            data[i][4] = aor_autocarro.getReservasemEspera().get(i).getLocalPartida();
            data[i][5] = aor_autocarro.getReservasemEspera().get(i).getLocalDestino();
            data[i][6] = String.valueOf(aor_autocarro.getReservasemEspera().get(i).getCusto());
            data[i][7] = aor_autocarro.getReservasemEspera().get(i).toString();

        }


        tabela = new JTable(data, colunas);
        sp = new JScrollPane(tabela);
        sp.setBounds(100, 200, 500, 400);
        this.add(sp);

        opcao1.addActionListener(this);
        opcao2.addActionListener(this);
        opcao3.addActionListener(this);
        opcao4.addActionListener(this);
        opcao5.addActionListener(this);
        sairBotao.addActionListener(this);


    }

    public void nomeLogado() {

        if (aor_autocarro.getUserLogado() == null) {
            clienteNome.setText("");
        } else
            clienteNome.setText(aor_autocarro.getUserLogado().getNome());
        revalidate();
        repaint();

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Reserva Autocarro\"")) {
            painelFundo.mudaEcra("ReservaViagem");
        }

        if (e.getActionCommand().equals("Histórico Reservas")) {
            ((HistoricoReservas) (painelFundo.mapaPaineis.get("HistoricoReservas"))).nomeLogado();
            painelFundo.mudaEcra("HistoricoReservas");
        }



        if (e.getActionCommand().equals("Cancelar Reservas")) {
            ((CancelarReserva) (painelFundo.mapaPaineis.get("CancelarReserva"))).nomeLogado();

            painelFundo.mudaEcra("CancelarReserva");
        }
        if (e.getActionCommand().equals("Dados Pessoais")) {
            ((DadosPessoaisCliente) (painelFundo.mapaPaineis.get("DadosPessoaisCliente"))).nomeLogado();
            painelFundo.mudaEcra("DadosPessoaisCliente");
        }
        if (e.getActionCommand().equals("Sair")) {
            ((Login)painelFundo.mapaPaineis.get("Login")).sair();
            painelFundo.mudaEcra("Login");
        }

    }

}
