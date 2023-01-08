package interfacegrafica;

import programa.Aor_Autocarro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Estatistica extends JPanel implements ActionListener {
    PainelFundo painelFundo;
    Aor_Autocarro aor_autocarro;
    JButton sairButton;
    JButton opcao1;
    JButton opcao2;
    JButton opcao3;
    JButton opcao4;
    JButton opcao5;
    JButton opcao6;

    JLabel clienteNome;

    JTable tabela;
    JScrollPane sp;

    JTable canceladasTable;
    JScrollPane spCanceladas;

    JTable reservasTable;
    JScrollPane spReservas;

    String[] colunasReservas ;

    String[][] dataReservas;
    JLabel totalRequisitadoLabel;


    public Estatistica(PainelFundo painelFundo, Aor_Autocarro aor_autocarro) {
        this.painelFundo = painelFundo;
        this.aor_autocarro = aor_autocarro;
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
        clienteNome = new JLabel("Nome do Admin");
        clienteNome.setBounds(700, 0, 100, 30);
        cabecalho.add(clienteNome);

        // Botao para sair para o login
        sairButton = new JButton("Sair");
        sairButton.setBounds(810, 1, 70, 28);
        cabecalho.add(sairButton);
        this.add(cabecalho);

        //===========================================================
        //Painel de escolhas do Admin
        JPanel opcaoPainel = new JPanel();
        opcaoPainel.setLayout(new GridLayout(1, 5, 15, 0));
        opcaoPainel.setBounds(0, 35, 900, 50);
        opcaoPainel.setBorder(BorderFactory.createLineBorder(Color.BLACK));


        opcao1 = new JButton("Adminstradores");
        opcao2 = new JButton("Motoristas");
        opcao3 = new JButton("Autocarros");
        opcao4 = new JButton("Clientes");
        opcao5 = new JButton("Estatistica");
        opcao6 = new JButton("Dados Pessoais");

        opcaoPainel.add(opcao1);
        opcaoPainel.add(opcao2);
        opcaoPainel.add(opcao3);
        opcaoPainel.add(opcao4);
        opcaoPainel.add(opcao5);
        opcaoPainel.add(opcao6);

        this.add(opcaoPainel);


        //=====================================================================
        //Segundo titulo
        JLabel segundoTitulo = new JLabel("Estatística");
        segundoTitulo.setBounds(50, 100, 900, 30);
        this.add(segundoTitulo);

        //======================================================================
        // Abas
        JTabbedPane abasPanel = new JTabbedPane();
        abasPanel.setTabPlacement(JTabbedPane.LEFT);
        abasPanel.setBounds(0, 125, 880, 530);


        //==========================================================
        //Aba Total Clientes
        JPanel totalClientesPanel = new JPanel();
        totalClientesPanel.setLayout(null);
        totalClientesPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Botoes de filtragem

        JPanel totalClientes = new JPanel(new GridLayout(1, 2, 0, 0));
        totalClientes.setBounds(200, 350, 250, 15);
        JLabel totalClientesLabel = new JLabel("Total Clientes:");
        JLabel totalClientesPreenchidoLabel = new JLabel(String.valueOf(aor_autocarro.contarCliente() - 1));
        totalClientes.add(totalClientesLabel);
        totalClientes.add(totalClientesPreenchidoLabel);

        totalClientesPanel.add(totalClientes);
        abasPanel.add("Total Clientes", totalClientesPanel);
        this.add(abasPanel);

        //==============================================================
        //Aba total Motoristas
        JPanel totalMotoristasPanel = new JPanel();
        totalMotoristasPanel.setLayout(null);

        // Botoes de filtragem

        JPanel totalMotoristas = new JPanel(new GridLayout(1, 2, 0, 0));
        totalMotoristas.setBounds(200, 350, 250, 15);
        JLabel totalMotoristasLabel = new JLabel("Total Motoristas:");
        JLabel totalMotoristasPreenchidoLabel = new JLabel(String.valueOf(aor_autocarro.contarMotorista()));
        totalMotoristas.add(totalMotoristasLabel);
        totalMotoristas.add(totalMotoristasPreenchidoLabel);

        totalMotoristasPanel.add(totalMotoristas);
        abasPanel.add("Total Motoristas", totalMotoristasPanel);

        //===============================================================
        //Aba total Autocarros
        JPanel totalAutocarrosPanel = new JPanel();
        totalAutocarrosPanel.setLayout(null);


        JPanel totalAutocarros = new JPanel(new GridLayout(1, 2, 0, 0));
        totalAutocarros.setBounds(200, 350, 250, 15);
        JLabel totalAutocarrosLabel = new JLabel("Total Autocarros:");
        JLabel totalAutocarrosPreenchidoLabel = new JLabel(String.valueOf(aor_autocarro.contarAutocarro()));
        totalAutocarros.add(totalAutocarrosLabel);
        totalAutocarros.add(totalAutocarrosPreenchidoLabel);

        totalAutocarrosPanel.add(totalAutocarros);
        abasPanel.add("Total Autocarros", totalAutocarrosPanel);

        //===============================================================
        //Aba total Autocarro mais Requisitado
        JPanel autocarroMaisRequisitado = new JPanel();
        autocarroMaisRequisitado.setLayout(null);

        // Botoes de filtragem

        JPanel totalRequisitado = new JPanel(new GridLayout(1, 2, 0, 0));
        totalRequisitado.setBounds(200, 350, 400, 15);
        JLabel totalRequisitadoLabel = new JLabel();
        JLabel totalRequisitadoPreenchidoLabel = new JLabel();
        totalRequisitado.add(totalRequisitadoLabel);
        totalRequisitado.add(totalRequisitadoPreenchidoLabel);

        autocarroMaisRequisitado.add(totalRequisitado);

        abasPanel.add("Autocarro mais requisitado", autocarroMaisRequisitado);


        //===================================================
        //Cliente com mais viagens

        JPanel totalViagensPanel = new JPanel();
        totalViagensPanel.setLayout(null);

        // Botoes de filtragem

        JPanel totalViagens = new JPanel(new GridLayout(1, 2, 0, 0));
        totalViagens.setBounds(150, 350, 400, 15);
        JLabel totalViagensLabel = new JLabel("Cliente com mais viagens");
        JLabel totalViagensPreenchidoLabel = new JLabel("Preenchido");
        totalViagens.add(totalViagensLabel);
        totalViagens.add(totalViagensPreenchidoLabel);

        totalViagensPanel.add(totalViagens);
        abasPanel.add("Cliente com mais viagens", totalViagensPanel);

        //==========================================================================
        //Autocarros Reservados
        JPanel autocarrosReservados = new JPanel();
        autocarrosReservados.setLayout(null);

        //Botoes
        JPanel botoesFiltroReservados = new JPanel(new GridLayout(1, 2, 10, 5));
        botoesFiltroReservados.setBounds(225, 25, 200, 30);
        JLabel mesLabelReservados = new JLabel("Mes:");
        String[] mes = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        JComboBox mesCombobox1 = new JComboBox(mes);

        botoesFiltroReservados.add(mesLabelReservados);
        botoesFiltroReservados.add(mesCombobox1);

        //Tabela
        String[] colunas = {"Matricula", "Data Partida", "Data Chegada"};

        String[][] data = new String[aor_autocarro.getReservas().size()][3];
        for (int i = 0; i < aor_autocarro.getReservas().size(); i++) {
            //data[i][0] = aor_autocarro.getReservas().get(i).getAutocarro().getMatricula();
            data[i][1] = String.valueOf(aor_autocarro.getReservas().get(i).getDataPartida());
            data[i][2] = String.valueOf(aor_autocarro.getReservas().get(i).getDataFim());

        }

        tabela = new JTable(data, colunas);
        sp = new JScrollPane(tabela);
        sp.setBounds(200, 100, 300, 400);
        autocarrosReservados.add(botoesFiltroReservados);
        autocarrosReservados.add(sp);
        abasPanel.add("Autocarros reservados", autocarrosReservados);

        //=======================================================
        //Requisições Canceladas

        JPanel autocarrosCanceladas = new JPanel();
        autocarrosCanceladas.setLayout(null);

        //Botoes
        JPanel botoesFiltroCanceladas = new JPanel(new GridLayout(1, 2, 0, 5));
        botoesFiltroCanceladas.setBounds(225, 50, 200, 30);
        JLabel mesLabelCanceladas = new JLabel("Mes:");
        JComboBox mesCombobox2 = new JComboBox(mes);
        botoesFiltroCanceladas.add(mesLabelCanceladas);
        botoesFiltroCanceladas.add(mesCombobox2);

        //Tabela
        String[] colunasCanceladas = {"Matricula", "Data Partida", "Data Chegada", "Cliente", "Motorista"};

        String[][] dataCanceladas = new String[aor_autocarro.getReservasCanceladas().size()][5];

        for (int i = 0; i < aor_autocarro.getReservasCanceladas().size(); i++) {
            dataCanceladas[i][0] = aor_autocarro.getReservasCanceladas().get(i).getAutocarro().getMatricula();
            dataCanceladas[i][1] = String.valueOf(aor_autocarro.getReservasCanceladas().get(i).getDataPartida());
            dataCanceladas[i][2] = String.valueOf(aor_autocarro.getReservasCanceladas().get(i).getDataFim());
            dataCanceladas[i][3] = aor_autocarro.getReservasCanceladas().get(i).getCliente().getNome();
            dataCanceladas[i][4] = aor_autocarro.getReservasCanceladas().get(i).getMotorista().getNome();
        }


        canceladasTable = new JTable(dataCanceladas, colunasCanceladas);
        spCanceladas = new JScrollPane(canceladasTable);
        spCanceladas.setBounds(100, 100, 500, 400);
        autocarrosCanceladas.add(botoesFiltroCanceladas);
        autocarrosCanceladas.add(spCanceladas);
        abasPanel.add("Requisições Canceladas", autocarrosCanceladas);

        //========================================================================
        //Reservas em Espera

        JPanel autocarrosReservas = new JPanel();
        autocarrosReservas.setLayout(null);

        //Botoes
        JPanel botoesFiltroReservas = new JPanel(new GridLayout(1, 4, 0, 5));
        botoesFiltroReservas.setBounds(225, 50, 200, 30);
        JLabel mesLabelReservas = new JLabel("Mes:");
        JComboBox mesCombobox3 = new JComboBox(mes);
        botoesFiltroReservas.add(mesLabelReservas);
        botoesFiltroReservas.add(mesCombobox3);

        //Tabela
        colunasReservas = new String[]{"Cliente", "Data Partida", "Data Chegada"};

        dataReservas = new String[aor_autocarro.getReservasemEspera().size()][3];

        for (int i = 0; i < aor_autocarro.getReservasemEspera().size(); i++) {
            dataReservas[i][0] = String.valueOf(aor_autocarro.getReservasemEspera().get(i).getDataPartida());
            dataReservas[i][1] = String.valueOf(aor_autocarro.getReservasemEspera().get(i).getDataFim());
            dataReservas[i][2] = aor_autocarro.getReservasemEspera().get(i).getCliente().getNome();

        }









        reservasTable = new JTable(dataReservas, colunasReservas);
        spReservas = new JScrollPane(reservasTable);
        spReservas.setBounds(100, 100, 500, 400);
        autocarrosReservas.add(botoesFiltroReservas);
        autocarrosReservas.add(spReservas);
        abasPanel.add("Reservas em Espera", autocarrosReservas);

        //============================================
        //Volume de reservas

        JPanel volumeReservas = new JPanel();
        volumeReservas.setLayout(null);

        //Botoes
        JPanel botoesFiltroVolume = new JPanel(new GridLayout(1, 4, 0, 5));
        botoesFiltroVolume.setBounds(225, 25, 200, 30);
        JLabel anoLabelVolume = new JLabel("Ano:");
        JTextField anoFieldVolume = new JTextField();
        botoesFiltroVolume.add(anoLabelVolume);
        botoesFiltroVolume.add(anoFieldVolume);
        volumeReservas.add(botoesFiltroVolume);

        //Tabela
        String[] colunasVolume = {"Mês", "Volume"};
        String[] meses = {"Janeiro","Fevereiro","Março","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"};


        String[][] dataVolume = {{"", ""}
                , {"", ""}};

        JTable volumeTable = new JTable(dataVolume, colunasVolume);
        JScrollPane spvolume = new JScrollPane(volumeTable);
        spvolume.setBounds(100, 80, 500, 300);
        volumeReservas.add(spvolume);

        //Label
        JPanel volumePreenchidoPanel = new JPanel(new GridLayout(1, 2, 40, 5));
        volumePreenchidoPanel.setBounds(150, 300, 400, 300);
        JLabel volumePreenchido = new JLabel("Dias com mais reservas:");
        JLabel volumePreenchidoLabel = new JLabel("Preenchido automaticamente");
        volumePreenchidoPanel.add(volumePreenchido);
        volumePreenchidoPanel.add(volumePreenchidoLabel);
        volumeReservas.add(volumePreenchidoPanel);
        abasPanel.add("Volume de Reservas", volumeReservas);


        this.add(abasPanel);

        opcao1.addActionListener(this);
        opcao2.addActionListener(this);
        opcao3.addActionListener(this);
        opcao4.addActionListener(this);
        opcao5.addActionListener(this);
        opcao6.addActionListener(this);
        sairButton.addActionListener(this);

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
        if (e.getActionCommand().equals("Adminstradores")) {
            painelFundo.mudaEcra("RegistarNovoAdministrador");
        }

        if (e.getActionCommand().equals("Motoristas")) {
            painelFundo.mudaEcra("Motoristas");
        }

        if (e.getActionCommand().equals("Autocarros")) {
            painelFundo.mudaEcra("Autocarros");
        }

        if (e.getActionCommand().equals("Clientes")) {
            ((AdicionarClientes) (painelFundo.mapaPaineis.get("AdicionarClientes"))).nomeLogado();
            painelFundo.mudaEcra("AdicionarClientes");
        }
        if (e.getActionCommand().equals("Estatistica")) {
            painelFundo.mudaEcra("Estatistica");
        }
        if (e.getActionCommand().equals("Dados Pessoais")) {
            ((DadosPessoaisAdmin)(painelFundo.mapaPaineis.get("DadosPessoaisAdmin"))).nomeLogado();
            painelFundo.mudaEcra("DadosPessoaisAdmin");
        }

        if (e.getActionCommand().equals("Sair")) {
            ((Login)painelFundo.mapaPaineis.get("Login")).sair();
            painelFundo.mudaEcra("Login");
        }

    }
}
