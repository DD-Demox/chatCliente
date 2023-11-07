import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class TelaChatPrivado extends JFrame implements Runnable {
    private JTextArea chatPrivado;
    private JTextArea caixaDeMensagem;
    private JButton botaoEnviar;
    private String destinatario;
    private String remetente;

    public TelaChatPrivado(String destinatario) {
        this.destinatario = destinatario;
        this.remetente = Client.name;
        setTitle("Chat Privado com "+this.destinatario);
        setSize(800, 800);
        setLocationRelativeTo(null);

        setMinimumSize(new Dimension(700, 700));
        setMaximumSize(new Dimension(700, 700));
        setResizable(false);

        JPanel painel = new JPanel();
        painel.setLayout(null);

        JLabel inicio = new JLabel("Chat Privado com "+destinatario);
        inicio.setBounds(350, 10, 100, 40);

        chatPrivado = new JTextArea();
        chatPrivado.setBounds(10, 80, 580, 400);
        chatPrivado.setEditable(false);
        JScrollPane chatScrollPane = new JScrollPane(chatPrivado);
        chatScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        chatScrollPane.setBounds(10, 80, 760, 400);

        caixaDeMensagem = new JTextArea();
        caixaDeMensagem.setBounds(10, 500, 600, 50);
        caixaDeMensagem.setLineWrap(true);
        JScrollPane mensagemScrollPane = new JScrollPane(caixaDeMensagem);
        mensagemScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        mensagemScrollPane.setBounds(10, 500, 600, 50);

        botaoEnviar = new JButton("Enviar");
        botaoEnviar.setBounds(620, 500, 150, 50);

        botaoEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enviarMensagem();
            }
        });

        caixaDeMensagem.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER && e.isShiftDown()) {
                    caixaDeMensagem.append("\n");
                } else if (e.getKeyCode() == KeyEvent.VK_ENTER && !e.isShiftDown()) {
                    enviarMensagem();
                    e.consume();
                }
            }
        });

        painel.add(inicio);
        painel.add(chatScrollPane);
        painel.add(mensagemScrollPane);
        painel.add(botaoEnviar);

        add(painel);
        setVisible(true);
    }

    private void enviarMensagem() {
        String[] mensagem = new String[6];
        mensagem[0]= "msgPrivada";
        try {
            mensagem[1] = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException ex) {
            throw new RuntimeException(ex);
        }
        mensagem[2] = Client.name;
        mensagem[4] =this.destinatario;
        mensagem[5]=caixaDeMensagem.getText();
        try {
            Client.out.writeObject(mensagem);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        caixaDeMensagem.setText("");
    }
    public String getDestinatario(){
        return this.destinatario;
    }
    public void setTextChat(String msg){
        chatPrivado.append(msg+"\n");
    }

    @Override
    public void run() {

    }
}