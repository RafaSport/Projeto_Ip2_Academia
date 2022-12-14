package br.ufrpe_SistemaAcademia.gui;

import br.ufrpe_SistemaAcademia.exception.ElementoNaoExisteException;
import br.ufrpe_SistemaAcademia.exception.ProfessorNaoContemAluno;
import br.ufrpe_SistemaAcademia.negocio.Fachada;
import br.ufrpe_SistemaAcademia.negocio.bean.Aluno;
import br.ufrpe_SistemaAcademia.negocio.bean.Exercicio;
import br.ufrpe_SistemaAcademia.negocio.bean.Pessoa;
import br.ufrpe_SistemaAcademia.negocio.bean.Professor;
import java.util.List;
import javax.swing.JOptionPane;

public class TelaProfessor extends javax.swing.JFrame {

    Professor usuario = (Professor) Fachada.getInstance().getUsuario();
    Aluno alunoConsultado;
    
    String diaDaSemana;
    int dia = 0;
    
    List<Pessoa> listaDeAlunosDoProfessor = Fachada.getInstance().listarAlunosDoProfessor(usuario);
            
    
    public TelaProfessor() {
        initComponents();
        
        lblNomeProfessor.setText(usuario.getNome());
        
        for(int i = 0; i < listaDeAlunosDoProfessor.size(); i++){
            
            try {
                
                tableAlunos.setValueAt(listaDeAlunosDoProfessor.get(i).getNome(), i, 0);               
                tableAlunos.setValueAt(Fachada.getInstance().treinosCadastrado((Aluno)listaDeAlunosDoProfessor.get(i), usuario), i, 1);
                tableAlunos.setValueAt(Fachada.getInstance().exerciciosCadastrado((Aluno)listaDeAlunosDoProfessor.get(i), usuario), i, 2);
                
            } catch (ProfessorNaoContemAluno ex) {
                
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO", 0);
                
            } catch (ElementoNaoExisteException ex) {
                
                tableAlunos.setValueAt("Plano de treino não cadastrado!", i, 1);
                tableAlunos.setValueAt("Exercicios não cadastrados!", i, 2);
                
            }
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

        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        menuBar2 = new java.awt.MenuBar();
        menu3 = new java.awt.Menu();
        menu4 = new java.awt.Menu();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtMatriculaCadastro = new javax.swing.JTextField();
        btnCadastrarTreinoExercicio = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblTreino = new javax.swing.JLabel();
        lblExercicios = new javax.swing.JLabel();
        btnConsultar = new javax.swing.JButton();
        lblNomeAluno = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAlunos = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtMatriculaConsulta = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableExercicios = new javax.swing.JTable();
        cmbDiaDaSemana = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        lblNomeAlunoConsultar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblNomeProfessor = new javax.swing.JLabel();

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        menu3.setLabel("File");
        menuBar2.add(menu3);

        menu4.setLabel("Edit");
        menuBar2.add(menu4);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela do Aluno");

        jPanel1.setBackground(new java.awt.Color(0, 0, 204));

        jLabel1.setBackground(new java.awt.Color(204, 255, 204));
        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Academia");

        jLabel9.setBackground(new java.awt.Color(204, 255, 204));
        jLabel9.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Power");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufrpe_SistemaAcademia/images/5463870-design-de-logotipo-de-academia-relampago-vetor.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(110, 110, 110))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(200, 200, 200)
                    .addComponent(jLabel10)
                    .addContainerGap(200, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel9))
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(7, 7, 7)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jPanel5.setBackground(new java.awt.Color(153, 153, 153));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setText("Matricula do Aluno :");

        btnCadastrarTreinoExercicio.setBackground(new java.awt.Color(0, 0, 204));
        btnCadastrarTreinoExercicio.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnCadastrarTreinoExercicio.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastrarTreinoExercicio.setText("Cadastrar Treino ou Exercicios");
        btnCadastrarTreinoExercicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarTreinoExercicioActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel8.setText("Nome do Aluno :");

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel11.setText("Treino :");

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel12.setText("Exercicios :");

        lblTreino.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblTreino.setText("...");

        lblExercicios.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblExercicios.setText("...");

        btnConsultar.setBackground(new java.awt.Color(0, 0, 204));
        btnConsultar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnConsultar.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        lblNomeAluno.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblNomeAluno.setText("...");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMatriculaCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel8))
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblNomeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 269, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblTreino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(186, 186, 186))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btnCadastrarTreinoExercicio))
                                    .addComponent(lblExercicios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(184, 184, 184)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMatriculaCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultar))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lblNomeAluno))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lblTreino))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lblExercicios))
                .addGap(18, 18, 18)
                .addComponent(btnCadastrarTreinoExercicio)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Cadastro", jPanel2);

        tableAlunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nome", "Treino", "Exercicios"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableAlunos);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Meus Alunos", jPanel4);

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel4.setText("Matricula do Aluno:");

        btnBuscar.setBackground(new java.awt.Color(0, 0, 204));
        btnBuscar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tableExercicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Exercicio", "Duração (Min)", "Series (Qtd)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tableExercicios);

        cmbDiaDaSemana.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sabado" }));
        cmbDiaDaSemana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDiaDaSemanaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel5.setText("Nome do Aluno:");

        lblNomeAlunoConsultar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblNomeAlunoConsultar.setText("...");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMatriculaConsulta)
                    .addComponent(lblNomeAlunoConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(cmbDiaDaSemana, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMatriculaConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(cmbDiaDaSemana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblNomeAlunoConsultar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Consulta", jPanel3);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel2.setText("Bem-Vindo Professor/a");

        lblNomeProfessor.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblNomeProfessor.setText("Vazio");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNomeProfessor)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblNomeProfessor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSair)
                .addContainerGap())
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSair)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        
        String matricula = txtMatriculaCadastro.getText();
        
        Aluno a = new Aluno();
        
        a.setMatricula(matricula);
      
        try {
            alunoConsultado = (Aluno)Fachada.getInstance().consultar(usuario, a);
            Fachada.getInstance().setPessoaManipulada(alunoConsultado);
            
            if(alunoConsultado != null){
                
                lblNomeAluno.setText(alunoConsultado.getNome());
                
                try {
                    lblTreino.setText(Fachada.getInstance().treinosCadastrado(alunoConsultado, usuario));
                    lblExercicios.setText(Fachada.getInstance().exerciciosCadastrado(alunoConsultado, usuario));
                    
                }catch(ElementoNaoExisteException ex){
                    
                    lblTreino.setText("...");
                    lblExercicios.setText("...");
                    JOptionPane.showMessageDialog(null, "Plano de treino não cadastrado!", "ERRO", 0);
                }
                            
            }else{
                
                lblNomeAluno.setText("...");
                lblTreino.setText("...");
                lblExercicios.setText("...");
                JOptionPane.showMessageDialog(null, "Aluno não cadastrado para este professor", "ERRO", 0);
            }
            
            
        } catch (ElementoNaoExisteException ex) {
            
            lblNomeAluno.setText("...");
            lblTreino.setText("...");
            lblExercicios.setText("...");
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO", 0);
            
        } catch (ProfessorNaoContemAluno ex) {
  
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO", 0);
        }
        
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
      
        String matricula = txtMatriculaConsulta.getText();
        
        Aluno a = new Aluno();
        
        a.setMatricula(matricula);
        
        Aluno alunoConsultado;
        
        List<Exercicio> listaExercicios;
        
        try {
            alunoConsultado = (Aluno)Fachada.getInstance().consultar(usuario, a);
            
            if(alunoConsultado != null){
                
                lblNomeAlunoConsultar.setText(alunoConsultado.getNome());
                
                if(alunoConsultado.getPlanoTreino() != null){
                    
                    try{
                        
                        listaExercicios = alunoConsultado.getPlanoTreino().getTreinos().get(dia).getExercicios();
                        
                        Fachada.getInstance().apagarTabela(tableExercicios, tableExercicios.getRowCount());

                        for(int i = 0; i < listaExercicios.size(); i++ ){

                            tableExercicios.setValueAt(listaExercicios.get(i).getTipoExercicio(), i, 0);
                            tableExercicios.setValueAt(listaExercicios.get(i).getDuracao(), i, 1);
                            tableExercicios.setValueAt(listaExercicios.get(i).getSerie(), i, 2);
                        }
                        
                    }catch(IndexOutOfBoundsException ex){
                        
                        Fachada.getInstance().apagarTabela(tableExercicios, tableExercicios.getRowCount());
                        JOptionPane.showMessageDialog(null, "Não há exercicios cadastrado!", "ERRO", 0);
                    }
                    
                }else{
                   
                    Fachada.getInstance().apagarTabela(tableExercicios, tableExercicios.getRowCount());
                    JOptionPane.showMessageDialog(null, "Plano de treino não cadastrado!", "ERRO", 0);
                }
                
            }else{
                lblNomeAlunoConsultar.setText("");
                Fachada.getInstance().apagarTabela(tableExercicios, tableExercicios.getRowCount());
                JOptionPane.showMessageDialog(null, "Aluno cadastrado para outro professor!", "ERRO", 0);
            }
            
        } catch (ElementoNaoExisteException ex) {
            lblNomeAlunoConsultar.setText("");
            Fachada.getInstance().apagarTabela(tableExercicios, tableExercicios.getRowCount());
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO", 0);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void cmbDiaDaSemanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDiaDaSemanaActionPerformed
        
        diaDaSemana = cmbDiaDaSemana.getSelectedItem().toString();
        
        switch (diaDaSemana) {
            case "Segunda": dia = 0;
                break;                
            case "Terça": dia = 1;               
                break;                
            case "Quarta": dia = 2;               
                break;               
            case "Quinta": dia = 3;               
                break;
            case "Sexta": dia = 4;               
                break;
            case "Sabado": dia = 5;               
                break;      
            
        }

    }//GEN-LAST:event_cmbDiaDaSemanaActionPerformed

    private void btnCadastrarTreinoExercicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarTreinoExercicioActionPerformed
        
        if( txtMatriculaCadastro.getText() != null){
            
            String matricula = txtMatriculaCadastro.getText();
        
            Aluno a = new Aluno();

            a.setMatricula(matricula);
            
            try {
                
                alunoConsultado = (Aluno)Fachada.getInstance().consultar(usuario, a);
                Fachada.getInstance().setPessoaManipulada(alunoConsultado);
                
                if(alunoConsultado != null){
                    
                    new TelaProfCadastros().setVisible(true);
                    this.dispose();
                
                }else{
                    
                    JOptionPane.showMessageDialog(null, "Aluno não cadastrado para este professor", "ERRO", 0);
                }
                
                
            } catch (ElementoNaoExisteException ex) {
                
                JOptionPane.showMessageDialog(null, "Matricula invalida!", "ERRO", 0);
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Matricula invalida!", "ERRO", 0);
        }
        
    }//GEN-LAST:event_btnCadastrarTreinoExercicioActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        new TelaInicial().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

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
            java.util.logging.Logger.getLogger(TelaProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaProfessor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCadastrarTreinoExercicio;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnSair;
    private javax.swing.JComboBox<String> cmbDiaDaSemana;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JLabel lblExercicios;
    private javax.swing.JLabel lblNomeAluno;
    private javax.swing.JLabel lblNomeAlunoConsultar;
    private javax.swing.JLabel lblNomeProfessor;
    private javax.swing.JLabel lblTreino;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.Menu menu3;
    private java.awt.Menu menu4;
    private java.awt.MenuBar menuBar1;
    private java.awt.MenuBar menuBar2;
    private javax.swing.JTable tableAlunos;
    private javax.swing.JTable tableExercicios;
    private javax.swing.JTextField txtMatriculaCadastro;
    private javax.swing.JTextField txtMatriculaConsulta;
    // End of variables declaration//GEN-END:variables
}
