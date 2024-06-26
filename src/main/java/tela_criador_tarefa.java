import java.awt.Color;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.*;

import com.toedter.calendar.JDateChooser;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class tela_criador_tarefa extends JDialog {
    
    JLabel app_title , app_desc , texto_titulo, texto_descricao, texto_DataInicio, texto_DataFim, data_inicio, texto_prioridade, texto_responsavel;
    JTextField tarefa_titulo;
    JTextArea tarefa_descricao;
    JDateChooser dataFim;
    JComboBox responsavel;
    JCheckBox prioridade; 
    JButton btn_Cancelar, btn_CriarTarefa;
    
    
    tela_criador_tarefa() throws ParseException {
        setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500,500);
        this.setTitle("Criar Tarefa");
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        try {
            File iconFile = new File("src/main/java/icon_img/add_task.png");
            Image iconImage = ImageIO.read(iconFile);
            setIconImage(iconImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        //Texto principal
        app_title = new JLabel("Nova Tarefa");
        app_title.setBounds(165, 5, 150, 25);
        app_title.setFont(app_title.getFont().deriveFont(25f));
        this.add(app_title);
        
        //Descricao principal
        app_desc = new JLabel();
        app_desc.setBounds(155, 25, 200, 25);
        this.add(app_desc);
        
        //Titulo da tarefa
        texto_titulo = new JLabel("Insira o Titulo:");
        texto_titulo.setBounds(25, 50, 90, 20);
        this.add(texto_titulo);
        tarefa_titulo = new JTextField();
        tarefa_titulo.setBounds(25, 70, 155, 20);
        this.add(tarefa_titulo);
        
        //Descricao da tarefa
        texto_descricao = new JLabel("Insira a Descrição:");
        texto_descricao.setBounds(25, 95, 125, 20);
        this.add(texto_descricao);
        tarefa_descricao = new JTextArea();
        JScrollPane scrollpane = new JScrollPane(tarefa_descricao);
        scrollpane.setBounds(25, 115, 437, 150);
        this.add(scrollpane);
        
        //Data Inicio
        texto_DataInicio = new JLabel("Data de inico:");
        texto_DataInicio.setBounds(25, 270, 90, 25);
        this.add(texto_DataInicio);
        data_inicio = new JLabel();
        data_inicio.setBounds(105, 272, 90,20);
        data_atual();
        this.add(data_inicio);
        
        //Data Fim
        texto_DataFim = new JLabel("Data Final:");
        texto_DataFim.setBounds(25, 295, 90, 20);
        this.add(texto_DataFim);
        dataFim = new JDateChooser();
        dataFim.setDateFormatString("dd/MM/yyyy");
        dataFim.setBounds(90, 297, 100, 20);
        this.add(dataFim);
        
        //Prioridade
        texto_prioridade = new JLabel("Urgente: ");
        texto_prioridade.setBounds(318, 295, 90, 25);
        this.add(texto_prioridade);
        prioridade = new JCheckBox();
        prioridade.setBounds(370, 297, 30, 20);
        this.add(prioridade);
        
        
        //Responsavel
        texto_responsavel = new JLabel("Responsavel:");
        texto_responsavel.setBounds(290, 270, 90, 25);
        this.add(texto_responsavel);
        responsavel = new JComboBox();
        responsavel.setBounds(371, 270, 90, 25);
        
        // Adicionando o nome do usuário logado à lista de nomes
        Pessoa pessoalogada = UsuarioLogado.getPessoa();
        List<String> nomes = new ArrayList<>();
        nomes.add(pessoalogada.getNome());
        banco_config banco = new banco_config();
        for (Pessoa pessoa : banco.buscarTodasPessoas()) {
                if (!pessoa.getNome().equals(pessoalogada.getNome())) {
                    nomes.add(pessoa.getNome());    
                 }
        }   
        DefaultComboBoxModel modeloNomes = new DefaultComboBoxModel(nomes.toArray());
        responsavel.setModel(modeloNomes);
        this.add(responsavel);
        
        
        
        //Botao Cancelar
        btn_Cancelar = new JButton("Cancelar");
        btn_Cancelar.setBounds(25 ,420, 100, 25);
        this.add(btn_Cancelar);
        
        //Botao Criar Tarefa
        btn_CriarTarefa = new JButton("Criar Tarefa");
        btn_CriarTarefa.setBounds(332, 420, 130, 25);
        this.add(btn_CriarTarefa);
    
       
        
        btn_Cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        
        btn_CriarTarefa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                banco_config bancoConfig = new banco_config();
                try {
                    String criarTarefa = bancoConfig.criarTarefa(tarefa_titulo.getText(), tarefa_descricao.getText(), data_atual(), dataFim.getDate(), false, UsuarioLogado.getPessoa(), isPrioridade(), responsavel.getSelectedItem().toString());
                    
                    if(criarTarefa == "Preencha Todos os Campos"){
                    app_desc.setText(criarTarefa);
                    app_desc.setForeground(Color.RED);
                    }else if(criarTarefa == "Esta Tarefa já foi Criada"){
                    app_desc.setText(criarTarefa);
                    app_desc.setBounds(167, 25, 200, 25);
                    app_desc.setForeground(Color.RED);
                    }else{
                    app_desc.setText(criarTarefa);
                    app_desc.setForeground(Color.GREEN);
                    dispose();
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(tela_criador_tarefa.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
        
        

    }
    
    
    
    //Verifica se esta como prioridade
    public boolean isPrioridade() {
        if(prioridade.isSelected()){
            return true;
        }else{
            return false;
        }
    }

    //Pega a data de hoje e formata
    public Date data_atual() {
        LocalDate dataHoje = LocalDate.now();
        String dataHojeFormatada = dataHoje.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        data_inicio.setText(dataHojeFormatada);
        Date datahoje_formatada_sql = java.sql.Date.valueOf(dataHoje);
        return datahoje_formatada_sql;
    }
    
    
    //Criar a tela
    public void criar_tarefa(){
        this.setVisible(true);
    }
}
