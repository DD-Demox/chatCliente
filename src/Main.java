import javax.swing.*;

public class Main {
    public static void main(String[] args) {


        JFrame janela = new JFrame();
        TelaLogin login = new TelaLogin();
        janela.add(login);
        janela.setBounds(0,0,800,800);
        janela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        janela.setResizable(true);
        janela.setVisible(true);

    }
}
