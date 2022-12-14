
package br.ufrpe_SistemaAcademia.gui;

import br.ufrpe_SistemaAcademia.exception.ElementoJaExisteException;
import br.ufrpe_SistemaAcademia.exception.ElementoNaoExisteException;
import br.ufrpe_SistemaAcademia.negocio.Fachada;
import br.ufrpe_SistemaAcademia.negocio.bean.Aluno;
import br.ufrpe_SistemaAcademia.negocio.bean.Exercicio;
import br.ufrpe_SistemaAcademia.negocio.bean.Treino;
import br.ufrpe_SistemaAcademia.negocio.bean.TreinoExecutado;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class TelaAluno extends javax.swing.JFrame {
    
    Aluno usuario = (Aluno)Fachada.getInstance().getUsuario();
    TreinoExecutado treinoExecutado;
    boolean podeSalvar = false;

    public TelaAluno() {
        initComponents();        
        
        lblNome.setText(usuario.getNome());
       
        LocalDate hoje = LocalDate.now();
        String hoje1 = Fachada.getInstance().dateParaString(hoje);
        
        lblHoje.setText(hoje1 + " - " + String.valueOf(LocalDate.now().getDayOfWeek()));
            
        LocalDate data = usuario.getPlanoPagamento().getDataFim();     
        String dataFim = Fachada.getInstance().dateParaString(data);

        lblMes.setText(dataFim);//Data de validade do plano

        //Primeira condição para listar o treino do dia na tela
        //e tambem para setar as datas de validade do treino
        if(usuario.getPlanoTreino() != null){

            LocalDate dtTreinoInicio = usuario.getPlanoTreino().getDataInicio();
            LocalDate dtTreinoFim = usuario.getPlanoTreino().getDataFim();

            String dataTreinoInicio = Fachada.getInstance().dateParaString(dtTreinoInicio);
            String dataTreinoFim = Fachada.getInstance().dateParaString(dtTreinoFim);

            lblTreinoInicio.setText(dataTreinoInicio);
            lblTreinoFim.setText(dataTreinoFim);
            
            if(usuario.getPlanoTreino().getTreinos().size() == 6){
                
                List<Exercicio> lista = null;

            
                try {

                    //Este metodo retorna a lista de exercicio programada para o dia logado que sempre será "hoje"
                    //ele verifica que dia da semana é "hoje" e retorna a lista correspondente, já que cada aluno
                    //tem 6 lista de exercicios para cada dia da semana de segunda a sabado, caso o professor não
                    //preencha as lista para todos os dia dará exception tratada abaixo
                    lista = Fachada.getInstance().listaDeExerciciosDoDiaDaSemana(usuario, LocalDate.now());


                } catch (ArrayIndexOutOfBoundsException e) {

                    JOptionPane.showMessageDialog(null, 
                            "Lista Incompleta! Não possui treino para " + hoje.getDayOfWeek(), "ERRO", 0);

                }

                LocalDate dataLimiteDoTreino = usuario.getPlanoTreino().getDataFim();

                //Caso a lista tenha sido preenchida com os exercicios programado para o dia
                if(lista != null){

                    //Este metodo verifica se "hoje" esta dentro da data de validade do treino 
                    //se sim preenche a tabela com os exercicios
                    if(Fachada.getInstance().dataNaValidade(dataLimiteDoTreino, LocalDate.now())){

                        for( int i = 0; i < lista.size(); i++){

                            tableExercicios.setValueAt(lista.get(i).getTipoExercicio(), i, 0);
                            tableExercicios.setValueAt(lista.get(i).getDuracao(), i, 1);
                            tableExercicios.setValueAt(lista.get(i).getSerie(), i, 2);

                        }

                        podeSalvar = true;//Como ocorreu tudo certo esta variavel auxiliar valida o buttonTreinar salvar

                    }else{
                        JOptionPane.showMessageDialog(null, "Treino fora da data procure seu Professor!", "ERRO", 0);
                    }


                }else{
                    //Caso a lista esteja vazia esta condição verifica se é domingo para retornar uma menssagem
                    if(String.valueOf( LocalDate.now().getDayOfWeek() ).equalsIgnoreCase("SUNDAY")){

                        JOptionPane.showMessageDialog(null, "Não há treinos no domingo", "ERRO", 0);
                    }

                }
                
            }else{
                
                JOptionPane.showMessageDialog(null, "Não há treino cadastrado fale com seu professor!", "ERRO", 0);
            }

        }else{//Caso o aluno não tenha treino cadastrado
            
            JOptionPane.showMessageDialog(null, "Não há treino cadastrado fale com seu professor!", "ERRO", 0);
            
            lblTreinoInicio.setText("------------");
            lblTreinoFim.setText("-------------");
        }
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblMes = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblTreinoFim = new javax.swing.JLabel();
        lblTreinoInicio = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableExercicios = new javax.swing.JTable();
        btnTreinar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        lblHoje = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtDia = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtAno = new javax.swing.JTextField();
        txtMes = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableExerciciosExecutado = new javax.swing.JTable();
        btnConsultar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela do Aluno");

        jPanel1.setBackground(new java.awt.Color(0, 0, 204));

        jLabel1.setBackground(new java.awt.Color(204, 255, 204));
        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Academia");

        jLabel6.setBackground(new java.awt.Color(204, 255, 204));
        jLabel6.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Power");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufrpe_SistemaAcademia/images/5463870-design-de-logotipo-de-academia-relampago-vetor.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(111, 111, 111))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(200, 200, 200)
                    .addComponent(jLabel7)
                    .addContainerGap(200, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6))
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(7, 7, 7)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(8, Short.MAX_VALUE)))
        );

        btnSair.setBackground(new java.awt.Color(153, 153, 153));
        btnSair.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setPreferredSize(new java.awt.Dimension(500, 400));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setText("Aluno :");

        lblNome.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblNome.setText("Vazio");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel4.setText("Validade do Plano:");

        lblMes.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblMes.setText("Vazio");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setText("Treino Fim :");

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel5.setText("Treino Inicio :");

        lblTreinoFim.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblTreinoFim.setText("Vazio");

        lblTreinoInicio.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblTreinoInicio.setText("Vazio");

        tableExercicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Exercio", "Duração (Min)", "Series (qtd)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableExercicios);

        btnTreinar.setBackground(new java.awt.Color(0, 0, 204));
        btnTreinar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btnTreinar.setForeground(new java.awt.Color(255, 255, 255));
        btnTreinar.setText("Treinar");
        btnTreinar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTreinarActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel12.setText("Data :");

        lblHoje.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblHoje.setText("Vazio");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblHoje, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(lblNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTreinoInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                            .addComponent(lblMes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTreinoFim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnTreinar)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblNome)
                    .addComponent(jLabel4)
                    .addComponent(lblMes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblTreinoInicio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblTreinoFim)
                    .addComponent(jLabel12)
                    .addComponent(lblHoje))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTreinar)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Principal", jPanel2);

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel8.setText("Consultar Treino Numa Data");

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel9.setText("Dia:");

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel10.setText("Mes:");

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel11.setText("Ano:");

        tableExerciciosExecutado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Exercio", "Duração (Min)", "Series (qtd)"
            }
        ));
        jScrollPane2.setViewportView(tableExerciciosExecutado);

        btnConsultar.setBackground(new java.awt.Color(0, 0, 153));
        btnConsultar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnConsultar.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMes, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(txtMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Consulta", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSair)
                .addContainerGap())
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSair)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
        new TelaInicial().setVisible(true);
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnTreinarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTreinarActionPerformed
        
        
        if(usuario.getPlanoTreino() != null){
            
            LocalDate diaDoTreino = LocalDate.now();       
            Treino treino = new Treino();
            
            //Variavel auxiliar recebe true quando tudo dar certo na inicialização e a tabela é preenchida
            if(podeSalvar){
                
                //A lista de exercicio de "hoje" é setada no treino para ser instaciado o TreinoExecutado
                treino.setExercicios(Fachada.getInstance().listaDeExerciciosDoDiaDaSemana(usuario, diaDoTreino));
                
                treinoExecutado = new TreinoExecutado(usuario, treino, diaDoTreino);
            
                try {
                    Fachada.getInstance().salvarTreinoExecutado(treinoExecutado); 
                    
                    Fachada.getInstance().salvarTreinosExecutadosNoArquivo("treinosExecutados.dat");
                        
                    JOptionPane.showMessageDialog(null, "Treino salvo com sucesso", "CONFIRMAÇÃO", 1);
                        
                } catch (ElementoJaExisteException ex) {
                    
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO", 0);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Não há treino para salvar", "ERRO", 0);
            }
                      
        }else{
            JOptionPane.showMessageDialog(null, "Treino não cadastrado!", "ERRO", 0);
        }
    }//GEN-LAST:event_btnTreinarActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        
        Integer dia = Integer.parseInt(txtDia.getText());
        Integer mes = Integer.parseInt(txtMes.getText());
        Integer ano = Integer.parseInt(txtAno.getText());
        
        LocalDate diaDoTreino = LocalDate.of(ano, mes, dia);
        
        //Objeto instaciado apenas para ser comparado com um existente caso exista
        //já que o equals desse objeto se dá pelo aluno e diaDoTreino
        TreinoExecutado treinoPesquisado = new TreinoExecutado(usuario, diaDoTreino);
        
        List<Exercicio> lista = new ArrayList<>();
        
        try {
            //Metodo consulta o treino pesquisado e caso exista retorna o treino salvo
            TreinoExecutado te = Fachada.getInstance().consultarTreinoExecutado(treinoPesquisado);
            
            //Preenche a lista com a lista de exercicio do treinoexecutado pesquisado
            lista.addAll(te.getTreino().getExercicios());
            
            for( int i = 0; i < lista.size(); i++){
                
                tableExerciciosExecutado.setValueAt(lista.get(i).getTipoExercicio(), i, 0);
                tableExerciciosExecutado.setValueAt(lista.get(i).getDuracao(), i, 1);
                tableExerciciosExecutado.setValueAt(lista.get(i).getSerie(), i, 2);
                
            }
            
        } catch (ElementoNaoExisteException ex) {
            
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }   

    }//GEN-LAST:event_btnConsultarActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAluno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnTreinar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblHoje;
    private javax.swing.JLabel lblMes;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTreinoFim;
    private javax.swing.JLabel lblTreinoInicio;
    private javax.swing.JTable tableExercicios;
    private javax.swing.JTable tableExerciciosExecutado;
    private javax.swing.JTextField txtAno;
    private javax.swing.JTextField txtDia;
    private javax.swing.JTextField txtMes;
    // End of variables declaration//GEN-END:variables
}
