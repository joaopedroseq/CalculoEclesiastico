package fuscus_vulpes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

public class Frame extends JFrame implements ActionListener {
    JButton botao;
    JLabel dataPascoa, dataCarnaval, dataCorpoCristo, erro, erro2;
    JTextField caixaAno;

    public Frame() {
        ImageIcon icone = new ImageIcon("src/main/java/fuscus_vulpes/icon.png");
        ImageIcon fuscus_vulpes = new ImageIcon("src/main/java/fuscus_vulpes/fuscus_vulpes.png");



        JLabel informacaoAno = new JLabel();
        informacaoAno.setBounds(15, 20, 300, 40);
        informacaoAno.setText("Escreva aqui o ano que pretende calcular:");
        informacaoAno.setIcon(icone);

        JLabel copyright = new JLabel();
        copyright.setBounds(15, 15, 200, 40);
        copyright.setText("made by João Sequeira");

        JLabel copyright2 = new JLabel();
        copyright2.setBounds(300, 0, 200, 70);
        copyright2.setText("© fuscus vulpes, 2025");
        copyright2.setHorizontalTextPosition(JLabel.CENTER);
        copyright2.setVerticalTextPosition(JLabel.TOP);
        copyright2.setIcon(fuscus_vulpes);


        this.caixaAno = new JTextField();
        this.caixaAno.setBounds(300,20,80,40);
        this.caixaAno.setFont(new Font("Times New Roman",Font.BOLD,35));

        erro = new JLabel();
        erro.setBounds(150, 250, 150, 150);
        erro.setVerticalTextPosition(JLabel.CENTER);
        erro.setHorizontalTextPosition(JLabel.CENTER);
        erro.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 20));
        erro.setText("Data inválida");
        erro.setVisible(false);

        erro2 = new JLabel();
        erro2.setBounds(150, 250, 150, 150);
        erro2.setVerticalTextPosition(JLabel.CENTER);
        erro2.setHorizontalTextPosition(JLabel.CENTER);
        erro2.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 20));
        erro2.setText("Insira um ano entre 1582 e 2299");
        erro2.setVisible(false);


        dataPascoa = new JLabel();
        dataPascoa.setBounds(150, 250, 150, 150);
        dataPascoa.setVerticalTextPosition(JLabel.CENTER);
        dataPascoa.setHorizontalTextPosition(JLabel.CENTER);
        dataPascoa.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 20));

        dataCarnaval = new JLabel();
        dataCarnaval.setBounds(150, 250, 150, 150);
        dataCarnaval.setVerticalTextPosition(JLabel.CENTER);
        dataCarnaval.setHorizontalTextPosition(JLabel.CENTER);
        dataCarnaval.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 20));

        dataCorpoCristo = new JLabel();
        dataCorpoCristo.setBounds(150, 250, 150, 150);
        dataCorpoCristo.setVerticalTextPosition(JLabel.CENTER);
        dataCorpoCristo.setHorizontalTextPosition(JLabel.CENTER);
        dataCorpoCristo.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 20));

        this.botao = new JButton("CALCULAR");
        this.botao.setBounds(50, 100, 100, 50);
        this.botao.addActionListener(this);
        botao.setFocusable(false);
        botao.setHorizontalTextPosition(JButton.CENTER);
        botao.setVerticalTextPosition(JButton.CENTER);
        botao.setFont(new Font("Comic Sans", Font.BOLD, 10));
        botao.setVerticalAlignment(JLabel.CENTER);
        botao.setHorizontalAlignment(JLabel.CENTER);


        this.setTitle("Cálculo Eclesiástico");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(450, 450);
        this.setResizable(false);
        this.setLayout(new BorderLayout(10, 10));
        this.setVisible(true);

        JPanel painel1 = new JPanel();
        JPanel painel2 = new JPanel();
        JPanel painel3 = new JPanel();
        JPanel painel4 = new JPanel();

        painel1.setBackground(new Color(255, 255, 255));
        painel1.setPreferredSize(new Dimension(250, 75));
        painel1.setLayout(null);
        painel1.add(caixaAno);
        painel1.add(informacaoAno);


        painel2.setBackground(new Color(255, 255, 255));
        painel2.setPreferredSize(new Dimension(150, 100));
        painel2.setLayout(null);
        painel2.add(botao);

        JPanel painel5 = new JPanel();
        painel5.setPreferredSize(new Dimension(150,150));
        painel5.setBackground(Color.black);

        painel3.setPreferredSize(new Dimension(150, 75));
        painel3.setBackground(new Color(255, 255, 255));
        painel3.setLayout(null);
        painel3.add(copyright);
        painel3.add(copyright2);
        painel3.add(painel5, BorderLayout.EAST);


        painel4.setBackground(new Color(255, 255, 255));
        painel4.setPreferredSize(new Dimension(300, 75));
        painel4.add(erro);
        painel4.add(erro2);
        painel4.add(dataPascoa);
        painel4.add(dataCarnaval);
        painel4.add(dataCorpoCristo);



        this.add(painel1, BorderLayout.NORTH);
        this.add(painel2, BorderLayout.WEST);
        this.add(painel3, BorderLayout.SOUTH);
        this.add(painel4, BorderLayout.EAST);


        this.setIconImage(icone.getImage());
        this.getContentPane().setBackground(new Color(0, 0, 0));


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botao) {
            erro.setVisible(false);
            erro2.setVisible(false);
            String texto = caixaAno.getText();
            if (CalculoData.validarData(texto)) {
                int ano = Integer.parseInt(texto);
                ArrayList<LocalDate> datas = CalculoData.obterDatasPascoa(ano);
                dataPascoa.setText("Páscoa: " + CalculoData.imprimirData(datas.get(0)));
                dataCarnaval.setText("Carnaval: " + CalculoData.imprimirData(datas.get(1)));
                dataCorpoCristo.setText("Corpo de Cristo: " + CalculoData.imprimirData(datas.get(2)));
            } else {
                erro.setVisible(true);
                erro2.setVisible(true);
            }
        }
    }
}
