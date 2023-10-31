import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaLogin extends JPanel {

    public TelaLogin(){
        setLayout(null);
        setBounds(0,0,300,200);
//        setVisible(true);

        JLabel serverJ = new JLabel("Servidor");
        JLabel portaJ = new JLabel("Porta");
        JLabel nickJ  = new JLabel("Apelido");

        serverJ.setBounds(10,10,100,20);
        portaJ.setBounds(10,35,100,20);
        nickJ.setBounds(10,60,100,20);

        JTextField serverJTF = new JTextField();
        JTextField portaJTF = new JTextField();
        JTextField nickJTF = new JTextField();

        serverJTF.setBounds(110,10,100,20);
        portaJTF.setBounds(110,35,100,20);
        nickJTF.setBounds(110,60,100,20);

        JButton logarB = new JButton("Conectar");
        logarB.setBounds(100,100,100,30);

        logarB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Telas.chatGlobal = new TelaChatGlobal();
                Client client = new Client(serverJTF.getText(),Integer.parseInt(portaJTF.getText()),nickJTF.getText(),Telas.chatGlobal);
                client.run();
                Container pai = getParent();
                pai.removeAll();
                pai.add(Telas.chatGlobal);
                pai.setBounds(0,0,Telas.chatGlobal.getWidth(),Telas.chatGlobal.getHeight());
                pai.revalidate();
                pai.repaint();

            }
        });

        add(serverJ);
        add(portaJ);
        add(nickJ);
        add(serverJTF);
        add(portaJTF);
        add(nickJTF);
        add(logarB);
//        setVisible(true);



    }
}
