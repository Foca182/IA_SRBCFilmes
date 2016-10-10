/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
//import Modelo.*;
import Modelo.SRBC;
import Controller.Operacao;
import Modelo.Movie;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;
import Modelo.SRBC;
import Modelo.SimilarityResult;
import Modelo.WeightConfig;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Peter-Asus
 */
public class Main extends javax.swing.JFrame {
    
        Operacao operacao = new Operacao();               
        int Tvalor = 0;
        int Rvalor,Fvalor = 0;        
        String Svalor = "";
        ArrayList<String> vetTitulos=  new  ArrayList();
        ArrayList<String> vetDiretor=  new  ArrayList();
        ArrayList<String> vetAtor   =  new  ArrayList();
        ArrayList<String> vetEnredo =  new  ArrayList();
        ArrayList<String> ListGener =  new  ArrayList();
     /**
     * Creates new form Main
     */
    public Main() {
        SRBC.Init();        
        initComponents();
        jStitulo.setValue(100);
        jSator.setValue(100);
        jSdiretor.setValue(100);
        jSGenero.setValue(100);
        jSenredo.setValue(100);
         jCbTitulo.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt){
                for (String title : SRBC.getTitles())
                    {
                        vetTitulos.add(title);
                    }
                String digitado  = jCbTitulo.getEditor().getItem().toString();
                if (evt.getKeyCode()>=65 && evt.getKeyCode()<=90 ||evt.getKeyCode()>=96
                    &&evt.getKeyCode()<= 105 ||evt.getKeyCode() == evt.VK_ENTER){                    
                    jCbTitulo.setModel(operacao.getLista(digitado,vetTitulos));
                    if (jCbTitulo.getItemCount()>0) {
                       jCbTitulo.showPopup();
                        if (evt.getKeyCode()!=8) {
                           ((JTextComponent)jCbTitulo.getEditor().getEditorComponent()).select(digitado.length(), jCbTitulo.getEditor().getItem().toString().length());                       
                        }
                    else{
                        jCbTitulo.getEditor().setItem(digitado);
                        }
                    }
                    else {
                        jCbTitulo.addItem(digitado);
                    }
                 }
            }
        });  
         
          jCbDiretor.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt){ 
                  for (String director : SRBC.getDirectors())
                    {
                        vetDiretor.add(director);
                    }
                String digitado  = jCbDiretor.getEditor().getItem().toString();
                if (evt.getKeyCode()>=65 && evt.getKeyCode()<=90 ||evt.getKeyCode()>=96
                    &&evt.getKeyCode()<= 105 ||evt.getKeyCode() == evt.VK_ENTER){                    
                    jCbDiretor.setModel(operacao.getLista(digitado,vetDiretor));
                    if (jCbDiretor.getItemCount()>0) {
                       jCbDiretor.showPopup();
                        if (evt.getKeyCode()!=8) {
                           ((JTextComponent)jCbDiretor.getEditor().getEditorComponent()).select(digitado.length(), jCbDiretor.getEditor().getItem().toString().length());                       
                        }
                    else{
                        jCbDiretor.getEditor().setItem(digitado);
                        }
                    }
                    else {
                        jCbDiretor.addItem(digitado);
                    }
                 }
            }
        });   
           jCbAtor.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt){   
                for (String actor : SRBC.getActors())
                    {
                        vetAtor.add(actor);
                    }
                String digitado  = jCbAtor.getEditor().getItem().toString();
                if (evt.getKeyCode()>=65 && evt.getKeyCode()<=90 ||evt.getKeyCode()>=96
                    &&evt.getKeyCode()<= 105 ||evt.getKeyCode() == evt.VK_ENTER){                    
                    jCbAtor.setModel(operacao.getLista(digitado,vetAtor));
                    if (jCbAtor.getItemCount()>0) {
                       jCbAtor.showPopup();
                        if (evt.getKeyCode()!=8) {
                           ((JTextComponent)jCbAtor.getEditor().getEditorComponent()).select(digitado.length(), jCbAtor.getEditor().getItem().toString().length());                       
                        }
                    else{
                        jCbAtor.getEditor().setItem(digitado);
                        }
                    }
                    else {
                        jCbAtor.addItem(digitado);
                    }
                 }
            }
        });  
            jCbEnredo.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt){ 
                for (String plot : SRBC.getPlots()) 
                {
                    vetEnredo.add(plot);
                }
                String digitado  = jCbEnredo.getEditor().getItem().toString();
                if (evt.getKeyCode()>=65 && evt.getKeyCode()<=90 ||evt.getKeyCode()>=96
                    &&evt.getKeyCode()<= 105 ||evt.getKeyCode() == evt.VK_ENTER){                    
                    jCbEnredo.setModel(operacao.getLista(digitado,vetEnredo));
                    if (jCbEnredo.getItemCount()>0) {
                       jCbEnredo.showPopup();
                        if (evt.getKeyCode()!=8) {
                           ((JTextComponent)jCbEnredo.getEditor().getEditorComponent()).select(digitado.length(), jCbEnredo.getEditor().getItem().toString().length());                       
                        }
                    else{
                        jCbEnredo.getEditor().setItem(digitado);
                        }
                    }
                    else {
                        jCbEnredo.addItem(digitado);
                    }
                 }
            }
        });  
     
     
    }
     
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jCbTitulo = new javax.swing.JComboBox<>();
        jPGenero = new javax.swing.JPanel();
        jChAcao = new javax.swing.JCheckBox();
        jChComedia = new javax.swing.JCheckBox();
        jChFamilia = new javax.swing.JCheckBox();
        jChDocumentario = new javax.swing.JCheckBox();
        jChCrime = new javax.swing.JCheckBox();
        jChAventura = new javax.swing.JCheckBox();
        jChAnimacao = new javax.swing.JCheckBox();
        jChDrama = new javax.swing.JCheckBox();
        jChNoir = new javax.swing.JCheckBox();
        jChFantasia = new javax.swing.JCheckBox();
        jChHorror = new javax.swing.JCheckBox();
        jChMisterio = new javax.swing.JCheckBox();
        jChMusical = new javax.swing.JCheckBox();
        jChThiller = new javax.swing.JCheckBox();
        jChSci = new javax.swing.JCheckBox();
        jChRomance = new javax.swing.JCheckBox();
        jChGuerra = new javax.swing.JCheckBox();
        jChVelho = new javax.swing.JCheckBox();
        jChBiogra = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jCbDiretor = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnAdicionar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstEnredo = new javax.swing.JList<>();
        jButton2 = new javax.swing.JButton();
        jCbEnredo = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jCbAtor = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableRelatorio = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jStitulo = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jSdiretor = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jSator = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jSenredo = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        jSGenero = new javax.swing.JSpinner();
        jLbGenero = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AC2_M1");
        setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Titulo:"));

        jLabel1.setText("Digite o Titulo que deseja:");

        jCbTitulo.setEditable(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jCbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPGenero.setBorder(javax.swing.BorderFactory.createTitledBorder("Genero:"));
        jPGenero.setToolTipText("");

        jChAcao.setText("Ação");

        jChComedia.setText("Comedia");
        jChComedia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChComediaActionPerformed(evt);
            }
        });

        jChFamilia.setText("Familia");

        jChDocumentario.setText("Documentario");

        jChCrime.setText("Crime");
        jChCrime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChCrimeActionPerformed(evt);
            }
        });

        jChAventura.setText("Aventura");
        jChAventura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChAventuraActionPerformed(evt);
            }
        });

        jChAnimacao.setText("Animação");

        jChDrama.setText("Drama");

        jChNoir.setText("Filme Noir");

        jChFantasia.setText("Fantasia");

        jChHorror.setText("Horror");

        jChMisterio.setText("Misterio");

        jChMusical.setText("Musical");

        jChThiller.setText("Thriller");

        jChSci.setText("Sci-Fi");

        jChRomance.setText("Romance");

        jChGuerra.setText("Guerra");

        jChVelho.setText("Velho -Oeste");

        jChBiogra.setText("Biografia");

        javax.swing.GroupLayout jPGeneroLayout = new javax.swing.GroupLayout(jPGenero);
        jPGenero.setLayout(jPGeneroLayout);
        jPGeneroLayout.setHorizontalGroup(
            jPGeneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGeneroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPGeneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jChAcao)
                    .addComponent(jChAventura)
                    .addComponent(jChAnimacao))
                .addGap(18, 18, 18)
                .addGroup(jPGeneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jChComedia)
                    .addComponent(jChFamilia)
                    .addComponent(jChCrime))
                .addGap(18, 18, 18)
                .addGroup(jPGeneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jChDocumentario)
                    .addComponent(jChDrama)
                    .addComponent(jChFantasia))
                .addGap(18, 18, 18)
                .addGroup(jPGeneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jChNoir)
                    .addComponent(jChHorror)
                    .addComponent(jChMusical))
                .addGap(18, 18, 18)
                .addGroup(jPGeneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jChRomance)
                    .addComponent(jChMisterio)
                    .addComponent(jChSci))
                .addGap(18, 18, 18)
                .addGroup(jPGeneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jChVelho)
                    .addGroup(jPGeneroLayout.createSequentialGroup()
                        .addComponent(jChThiller)
                        .addGap(27, 27, 27)
                        .addComponent(jChBiogra))
                    .addComponent(jChGuerra))
                .addGap(0, 15, Short.MAX_VALUE))
        );
        jPGeneroLayout.setVerticalGroup(
            jPGeneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGeneroLayout.createSequentialGroup()
                .addGroup(jPGeneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jChAcao)
                    .addComponent(jChFamilia)
                    .addComponent(jChDocumentario)
                    .addComponent(jChNoir)
                    .addComponent(jChMisterio)
                    .addComponent(jChThiller)
                    .addComponent(jChBiogra))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPGeneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jChComedia)
                    .addComponent(jChAventura)
                    .addComponent(jChDrama)
                    .addComponent(jChHorror)
                    .addComponent(jChRomance)
                    .addComponent(jChGuerra))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPGeneroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jChCrime)
                    .addComponent(jChAnimacao)
                    .addComponent(jChFantasia)
                    .addComponent(jChMusical)
                    .addComponent(jChSci)
                    .addComponent(jChVelho))
                .addGap(0, 4, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Diretor:"));

        jLabel2.setText("Digite o Diretor que deseja:");

        jCbDiretor.setEditable(true);
        jCbDiretor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbDiretorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jCbDiretor, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jCbDiretor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Enredo:"));

        jLabel3.setText("Digite e selecione o Enredo:");

        btnAdicionar.setText("Adicionar >>");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(lstEnredo);

        jButton2.setText("Remover <<");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jCbEnredo.setEditable(true);
        jCbEnredo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbEnredoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jCbEnredo, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAdicionar)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(btnAdicionar)
                            .addComponent(jCbEnredo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Ator:"));

        jLabel9.setText("Digite o Ator que deseja:");

        jCbAtor.setEditable(true);
        jCbAtor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbAtorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addGap(29, 29, 29)
                .addComponent(jCbAtor, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jCbAtor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultado:"));

        jButton1.setText("Executar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTableRelatorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableRelatorio);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPGenero, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Detalhes do Filmes:", jPanel1);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Definição de Valores de Busca:"));

        jStitulo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jStituloStateChanged(evt);
            }
        });

        jLabel4.setText("Peso Titulo:");

        jSdiretor.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSdiretorStateChanged(evt);
            }
        });

        jLabel5.setText("Peso Diretor:");

        jSator.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSatorStateChanged(evt);
            }
        });

        jLabel6.setText("Peso Ator:");

        jSenredo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSenredoStateChanged(evt);
            }
        });

        jLabel7.setText("Peso Enredo:");

        jSGenero.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSGeneroStateChanged(evt);
            }
        });

        jLbGenero.setText("Peso Genero:");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(80, 80, 80))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(79, 79, 79)))
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSenredo, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                            .addComponent(jSdiretor, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSator, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLbGenero))
                        .addGap(78, 78, 78)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jStitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(437, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jStitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLbGenero)
                    .addComponent(jSGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jSdiretor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jSator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jSenredo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(530, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Configurações:", jPanel7);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jChAventuraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChAventuraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jChAventuraActionPerformed

    private void jChComediaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChComediaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jChComediaActionPerformed

    private void jChCrimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChCrimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jChCrimeActionPerformed

    private void jCbDiretorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCbDiretorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCbDiretorActionPerformed

    private void jCbAtorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCbAtorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCbAtorActionPerformed

    private void jCbEnredoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCbEnredoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCbEnredoActionPerformed
       DefaultListModel model = new DefaultListModel();
    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        this.lstEnredo.setModel(model);
        model.addElement(this.jCbEnredo.getSelectedItem());
        jCbEnredo.getEditor().setItem("");            
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String ger ="" ,res = "";
        for (Component c : jPGenero.getComponents()) {            
            if (c.getClass().equals(JCheckBox.class)){
                JCheckBox jck = (JCheckBox)c;
                if (jck.isSelected()){
                    ger = jck.getText();
                    res+= jck.getText()+ ", ";
                    ListGener.add(ger);
                }                    
            }    
        }
            JOptionPane.showMessageDialog(null, res);
        
 
        Movie filmeDoUsuario = SRBC.searchMovieByTitle(jCbTitulo.getSelectedItem().toString());
        if (filmeDoUsuario != null)
        {
            // Configura os pesos de cada atributo
            WeightConfig pesos = new WeightConfig();
            pesos.title =   (Float.parseFloat(jStitulo.getValue().toString()))/100;
            pesos.genre =   (Float.parseFloat(jSGenero.getValue().toString()))/100;
            pesos.director =(Float.parseFloat(jSdiretor.getValue().toString()))/100;
            pesos.actor =   (Float.parseFloat(jSator.getValue().toString()))/100;
            pesos.plot =    (Float.parseFloat(jSenredo.getValue().toString()))/100;
            
            // Busca a lista ordenada de todos os filmes semelhantes.
            DefaultTableModel model = (DefaultTableModel) jTableRelatorio.getModel();
            model.setNumRows(0);            
            model.setColumnIdentifiers(new Object[]{ "Similaridade","Titulo","Genero","Diretor","Ator","Enredo"});
            List<SimilarityResult> filmesSemelhantes = SRBC.getSimilarMovies(filmeDoUsuario, pesos);
            for (SimilarityResult sr : filmesSemelhantes)
            {                
                Movie filme = sr.movie;
                float similaridade = sr.similarity;              
                System.out.println((int)(similaridade*100.0f)+"% => "+filme.title +" "+ filme.genres+" "+filme.director +" "+filme.actor+""+filme.genres );
                model.addRow(new Object[]{
                similaridade,filme.title,filme.genres,filme.director,filme.actor,filme.plots
                });
            }            
              System.out.println(ListGener.toString());           
            }
        else
        {
            System.err.println("Filme não encontrado. Verifique o nome");
        }       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       int select = lstEnredo.getSelectedIndex();
       model.remove(select);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jStituloStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jStituloStateChanged
        jStitulo.setValue(operacao.FixaValor(Integer.parseInt(jStitulo.getValue().toString())));
    }//GEN-LAST:event_jStituloStateChanged

    private void jSGeneroStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSGeneroStateChanged
        jSGenero.setValue(operacao.FixaValor(Integer.parseInt(jSGenero.getValue().toString())));
    }//GEN-LAST:event_jSGeneroStateChanged

    private void jSdiretorStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSdiretorStateChanged
       jSdiretor.setValue(operacao.FixaValor(Integer.parseInt(jSdiretor.getValue().toString())));
    }//GEN-LAST:event_jSdiretorStateChanged

    private void jSatorStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSatorStateChanged
        jSator.setValue(operacao.FixaValor(Integer.parseInt(jSator.getValue().toString())));
    }//GEN-LAST:event_jSatorStateChanged

    private void jSenredoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSenredoStateChanged
        jSenredo.setValue(operacao.FixaValor(Integer.parseInt(jSenredo.getValue().toString())));
    }//GEN-LAST:event_jSenredoStateChanged
   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jCbAtor;
    private javax.swing.JComboBox<String> jCbDiretor;
    private javax.swing.JComboBox<String> jCbEnredo;
    private javax.swing.JComboBox<String> jCbTitulo;
    private javax.swing.JCheckBox jChAcao;
    private javax.swing.JCheckBox jChAnimacao;
    private javax.swing.JCheckBox jChAventura;
    private javax.swing.JCheckBox jChBiogra;
    private javax.swing.JCheckBox jChComedia;
    private javax.swing.JCheckBox jChCrime;
    private javax.swing.JCheckBox jChDocumentario;
    private javax.swing.JCheckBox jChDrama;
    private javax.swing.JCheckBox jChFamilia;
    private javax.swing.JCheckBox jChFantasia;
    private javax.swing.JCheckBox jChGuerra;
    private javax.swing.JCheckBox jChHorror;
    private javax.swing.JCheckBox jChMisterio;
    private javax.swing.JCheckBox jChMusical;
    private javax.swing.JCheckBox jChNoir;
    private javax.swing.JCheckBox jChRomance;
    private javax.swing.JCheckBox jChSci;
    private javax.swing.JCheckBox jChThiller;
    private javax.swing.JCheckBox jChVelho;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLbGenero;
    private javax.swing.JPanel jPGenero;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    public javax.swing.JSpinner jSGenero;
    public javax.swing.JSpinner jSator;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JSpinner jSdiretor;
    public javax.swing.JSpinner jSenredo;
    public javax.swing.JSpinner jStitulo;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableRelatorio;
    private javax.swing.JList<String> lstEnredo;
    // End of variables declaration//GEN-END:variables
}
