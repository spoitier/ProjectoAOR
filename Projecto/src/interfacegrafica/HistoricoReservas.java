package interfacegrafica;

import programa.Aor_Autocarro;
import programa.Cliente;
import programa.Reserva;
import programa.Utilizador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The type Historico reservas.
 */
public class HistoricoReservas extends JPanel implements ActionListener {

   private final PainelFundo painelFundo;
    private JTable tabela;
    private JScrollPane sp;
    private final JLabel clienteNome;
    private final Aor_Autocarro aor_autocarro;
    private final JComboBox mesCombobox;

    /**
     * Instantiates a new Historico reservas.
     *
     * @param painelFundo   the painel fundo
     * @param aor_autocarro the aor autocarro
     */
    public HistoricoReservas(PainelFundo painelFundo, Aor_Autocarro aor_autocarro) {
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
        clienteNome = new JLabel("Nome do Cliente");
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
        opcaoPainel.setLayout(new GridLayout(1, 5, 15, 0));
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
        JLabel segundoTitulo = new JLabel("Historico de reservas\n");
        segundoTitulo.setBounds(50, 100, 900, 30);
        this.add(segundoTitulo);

        // Botoes de filtragem
        JPanel botoesFiltro = new JPanel(new GridLayout(1, 4, 5, 5));
        botoesFiltro.setBounds(100, 150, 200, 30);
        JLabel mesLabel = new JLabel("Mes:");
        String[] mes = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        mesCombobox = new JComboBox(mes);


        botoesFiltro.add(mesLabel);
        botoesFiltro.add(mesCombobox);
        this.add(botoesFiltro);

        //========================================
        // Tabela
        String[] colunas = {"Nº Reserva", "Data Aluguer", "NºDias", "NºPessoas",
                "Local Partida", "Local Destino", "Matricula", "Custo total Viagem"};
        ArrayList<String[]> data = new ArrayList<>();

        String[][] dataArray = data.toArray(new String[0][0]);
        tabela = new JTable(dataArray, colunas);
        sp = new JScrollPane(tabela);
        sp.setBounds(100, 200, 600, 400);
        this.add(sp);
        revalidate();
        repaint();


        opcao1.addActionListener(this);
        opcao2.addActionListener(this);
        opcao3.addActionListener(this);
        opcao4.addActionListener(this);
        opcao5.addActionListener(this);
        sairBotao.addActionListener(this);
        mesCombobox.addActionListener(this);





    }


    /**
     * Listagem por mes.
     *
     * @param mes the mes
     */
    public void listagemPorMes(String mes) {
        remove(sp);
        String[] colunas = {"Nº Reserva", "Data Aluguer", "NºDias", "NºPessoas",
                "Local Partida", "Local Destino", "Matricula", "Custo total Viagem"};

        ArrayList<String[]> data = new ArrayList<>();
        for (Reserva reserva : aor_autocarro.getReservas()) {
            if (reserva.getCliente().getEmail().equals(aor_autocarro.getUserLogado().getEmail())) {
                String[] reservaInfo = new String[8];
                if (String.valueOf(reserva.getDataPartida().getMonthValue()).equals(mes)) {
                    reservaInfo[0] = reserva.getId();
                    reservaInfo[1] = String.valueOf(reserva.getDataPartida());
                    reservaInfo[2] = reserva.getNumeroDias();
                    reservaInfo[3] = reserva.getNumeroPessoas();
                    reservaInfo[4] = reserva.getLocalPartida();
                    reservaInfo[5] = reserva.getLocalDestino();
                    reservaInfo[6] = reserva.getAutocarro().getMatricula();
                    reservaInfo[7] = String.valueOf(reserva.getCusto());
                    data.add(reservaInfo);
                } else if(mes.equals("0")){
                    reservaInfo[0] = reserva.getId();
                    reservaInfo[1] = String.valueOf(reserva.getDataPartida());
                    reservaInfo[2] = reserva.getNumeroDias();
                    reservaInfo[3] = reserva.getNumeroPessoas();
                    reservaInfo[4] = reserva.getLocalPartida();
                    reservaInfo[5] = reserva.getLocalDestino();
                    reservaInfo[6] = reserva.getAutocarro().getMatricula();
                    reservaInfo[7] = String.valueOf(reserva.getCusto());
                    data.add(reservaInfo);

                }

            }
        }
        String[][] dataArray = data.toArray(new String[0][0]);
        tabela = new JTable(dataArray, colunas);
        sp = new JScrollPane(tabela);
        sp.setBounds(100, 200, 600, 400);
        this.add(sp);
        clienteNome.setText(aor_autocarro.getUserLogado().getNome());
        revalidate();
        repaint();


    }



    @Override
    public void actionPerformed(ActionEvent e) {

        String mes = (String) mesCombobox.getSelectedItem();
        listagemPorMes(mes);

        if (e.getActionCommand().equals("Reserva Autocarro")) {
            painelFundo.mudaEcra("ReservaViagem");
        }


        if (e.getActionCommand().equals("Histórico Reservas")) {
            ((HistoricoReservas) (painelFundo.mapaPaineis.get("HistoricoReservas"))).listagemPorMes("0");
            painelFundo.mudaEcra("HistoricoReservas");
        }

        if (e.getActionCommand().equals("Consultar Reservas")) {
            ((ConsultarReservas) (painelFundo.mapaPaineis.get("ConsultarReservas"))).listagemPorMes("0");
            painelFundo.mudaEcra("ConsultarReservas");
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
