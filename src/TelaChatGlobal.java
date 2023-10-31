import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TelaChatGlobal extends JPanel {

    public TelaChatGlobal(){
        setLayout(null);
        setBounds(0,0,800,800);

        JLabel inicio = new JLabel("Chat Global");
        inicio.setBounds(400,10 , 300, 40 );

        JTextArea chatGlobal = new JTextArea();
        chatGlobal.setBounds(10,80,400, 400);
        chatGlobal.setEditable(false);

        JTextArea caixaDeMensagem = new JTextArea();
        caixaDeMensagem.setBounds(10, 500 , 300, 50);
        caixaDeMensagem.setLineWrap(true);


        JButton botaoEnviar = new JButton("Enviar");
        botaoEnviar.setBounds(320,500, 90,50 );


        botaoEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        caixaDeMensagem.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    botaoEnviar.doClick();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });



        add(inicio);
        add(chatGlobal);
        add(caixaDeMensagem);
        add(botaoEnviar);


    }

}

