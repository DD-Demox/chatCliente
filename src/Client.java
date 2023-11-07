import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import static javax.swing.text.StyleConstants.getComponent;

public class Client extends Thread {

    public static ObjectOutputStream out;
    public static Socket socket;
    private String msg;
    private String clientInput;
    private String name;
    ServerThread serverThread;
    String servidor;
    int porta;
    JPanel telaChatGlobal;



    Client(String servidor,int porta,String nick,JPanel telaChatGlobal){
        this.servidor = servidor;
        this.porta = porta;
        this.name = nick;
        this.telaChatGlobal = telaChatGlobal;
        JButton botao = (JButton) this.telaChatGlobal.getComponent(3);
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String[] codigo = new String[6];
                codigo[0] = "global";
                try {
                    codigo[1] = InetAddress.getLocalHost().getHostAddress();
                } catch (UnknownHostException ex) {
                    throw new RuntimeException(ex);
                }
                codigo[2] = name;
                codigo[5] = Telas.chatGlobal.getText();
                try {
                    out.writeObject(codigo);
                    Telas.chatGlobal.setText("");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

    }

    @Override
    public void run() {
        try {
            socket = new Socket(this.servidor,this.porta);
            out = new ObjectOutputStream(socket.getOutputStream());
            serverThread = new ServerThread(socket);
            serverThread.start();
            String[] nome ={"nome",this.name};
            out.writeObject(nome);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
