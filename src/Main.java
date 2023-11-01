import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {


        JFrame janela = new JFrame();
        TelaLogin login = new TelaLogin();
        janela.add(login);
        janela.setBounds(0,0,800,800);
        janela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        janela.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if(Client.out != null){
                    String[] codigo = new String[6];
                    codigo[0] = "sair";
                    codigo[5] = "usuario desconectado\n";
                    try {
                        Client.out.writeObject(codigo);
                        Client.out.close();
                        ServerThread.in.close();
                        Client.socket.close();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });

        janela.setResizable(true);
        janela.setVisible(true);

    }
}
