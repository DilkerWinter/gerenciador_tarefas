


import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class tela_cadastro extends JFrame{
    JPasswordField senha_cadastro;
    JTextField email_cadastro, nome_cadastro;
    JLabel texto_senha, texto_email, texto_nome, title, mensagem;
    JButton btn_cadastrar, btn_voltar;
    
    
    tela_cadastro() throws IOException {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(315,350);
        this.setTitle("Cadastrar");
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        
        try {
            File iconFile = new File("src/main/java/icon_img/task_icon.png");
            Image iconImage = ImageIO.read(iconFile);
            setIconImage(iconImage);
        } catch (IOException e) {
            e.printStackTrace();
          
        }
        
        texto_senha =  new JLabel("Senha:");
        texto_senha.setBounds(25,175, 200, 25);
        this.add(texto_senha);
        senha_cadastro = new JPasswordField();
        this.add(senha_cadastro);
        senha_cadastro.setBounds(25,200, 250, 25);
        
        texto_email =  new JLabel("E-mail:");
        texto_email.setBounds(25, 125, 200, 25);
        this.add(texto_email);
        email_cadastro = new JTextField();
        this.add(email_cadastro);
        email_cadastro.setBounds(25, 150, 250, 25);
        
        
        texto_nome =  new JLabel("Nome:");
        texto_nome.setBounds(25, 75, 200, 25);
        this.add(texto_nome);
        nome_cadastro = new JTextField();
        this.add(nome_cadastro);
        nome_cadastro.setBounds(25, 100, 250, 25);
        
        title = new JLabel("Crie sua conta");
        title.setBounds(25, 15, 300, 25);
        title.setFont(title.getFont().deriveFont(25f));
        this.add(title);
        
        btn_cadastrar = new JButton("Cadastrar");
        btn_cadastrar.setBounds(175 ,250, 100, 25);
        this.add(btn_cadastrar);
        
        
        mensagem = new JLabel();
        mensagem.setBounds(25, 50, 300, 25);
        this.add(mensagem);
        
        btn_voltar = new JButton("Voltar");
        btn_voltar.setBounds(25 ,250, 100, 25);
        this.add(btn_voltar);
        
        
        btn_cadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                banco_config bancoConfig = new banco_config();
                String validar_cadastro = bancoConfig.executar_cadastro(nome_cadastro.getText(), email_cadastro.getText(), senha_cadastro.getText());
                
                switch (validar_cadastro) {
                    case "ok":
                       mensagem.setText("Conta Criada com Sucesso!");
                       mensagem.setForeground(Color.GREEN);

                    {
                        try {
                            tela_login iniciar_login = new tela_login();
                            iniciar_login.iniciarlogin();
                        } catch (IOException ex) {
                            Logger.getLogger(tela_cadastro.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                        break;

                    case "Preencha todos os campos":
                        mensagem.setText("Preencha todos os campos");
                        mensagem.setForeground(Color.red);

                        break;
                    case "Email já registrado":
                        mensagem.setText("Email já registrado");
                        mensagem.setForeground(Color.red);
                        break;
                    case "Nome já registrado":
                        mensagem.setText("Nome já registrado");
                        mensagem.setForeground(Color.red);
                        break;
                    case "Erro no Sistema":
                        mensagem.setText("Erro no Sistema");
                        mensagem.setForeground(Color.red);
                        break;
                        
                    default:
                        mensagem.setText("Ai nem eu posso te ajuda");
                        mensagem.setForeground(Color.red);
                }
            
            }
        });
        
        btn_voltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            dispose();
            try {
                    tela_login iniciar_login = new tela_login();
                    iniciar_login.iniciarlogin();
                } catch (IOException ex) {Logger.getLogger(tela_cadastro.class.getName()).log(Level.SEVERE, null, ex);
                        }
            }
        });
}
    
    public void iniciarcadastro(){
        this.setVisible(true);
    }
}

