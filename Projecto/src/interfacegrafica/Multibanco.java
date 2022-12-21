package interfacegrafica;

import javax.swing.*;
import java.awt.*;

public class Multibanco extends JPanel {

    PainelFundo painelFundo;


    public  Multibanco (PainelFundo painelFundo) {
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
        opcaoPainel.setLayout(new GridLayout(1, 5, 15, 0));
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
        JLabel segundoTitulo = new JLabel("Realizar reserva de programa.Autocarro:\n");
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
        JButton multibanco = new JButton("Multbanco");
        pagamentoPanel.add(tipoPagamento);
        pagamentoPanel.add(multibanco);
        this.add(pagamentoPanel);

        //================================================================
        //Painel de referencia multibanco

        JPanel referenciaMultibanco = new JPanel(new GridLayout(3, 2, 0, 0));
        referenciaMultibanco.setBounds(200, 300, 300, 200);
        JLabel entidade = new JLabel("Entidade:");
        JLabel referencia = new JLabel("Referencia:");
        JLabel valor = new JLabel("Valor");
        JLabel entidadeInfo = new JLabel("12345");
        JLabel referenciaInfo = new JLabel("gerado automaticamente");
        JLabel valorInfo = new JLabel("gerado automaticamente");
        referenciaMultibanco.add(entidade);
        referenciaMultibanco.add(entidadeInfo);
        referenciaMultibanco.add(referencia);
        referenciaMultibanco.add(referenciaInfo);
        referenciaMultibanco.add(valor);
        referenciaMultibanco.add(valorInfo);
        this.add(referenciaMultibanco);



        //Botão de auntenticar
        JButton botaoConfirmar = new JButton("Confirmar");
        botaoConfirmar.setBounds(200, 550, 350, 50);
        this.add(botaoConfirmar);





    }

}
