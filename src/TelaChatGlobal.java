import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TelaChatGlobal extends JPanel {
    private JTextArea chatGlobal;
    private JTextArea caixaDeMensagem;
    private JButton botaoEnviar;

    public TelaChatGlobal() {



        setLayout(null);



        JLabel inicio = new JLabel("Chat Global");
        inicio.setBounds(350, 10, 100, 40);

        chatGlobal = new JTextArea();
        chatGlobal.setBounds(10, 80, 580, 400);
        chatGlobal.setEditable(false);
        JScrollPane chatScrollPane = new JScrollPane(chatGlobal);
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



        caixaDeMensagem.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER && e.isShiftDown()) {
                    caixaDeMensagem.append("\n");
                } else if (e.getKeyCode() == KeyEvent.VK_ENTER && !e.isShiftDown()) {
                    botaoEnviar.doClick();
                    e.consume();
                }
            }
        });

        add(inicio);
        add(chatScrollPane);
        add(mensagemScrollPane);
        add(botaoEnviar);


    }

    public  String getText(){
        return this.caixaDeMensagem.getText();
    }

    public void setText(String msg){
        this.caixaDeMensagem.setText(msg);
    }



}

