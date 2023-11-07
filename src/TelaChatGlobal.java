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
    private DefaultListModel listaCliente;
    private JList jlistaCliente;
    private JScrollPane jspListaCliente;

    public TelaChatGlobal() {



        setLayout(null);




        JLabel inicio = new JLabel("Chat Global");
        inicio.setBounds(350, 10, 100, 40);

        chatGlobal = new JTextArea();
        chatGlobal.setBounds(10, 80, 580, 400);
        chatGlobal.setEditable(false);
        JScrollPane chatScrollPane = new JScrollPane(chatGlobal);
        chatScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        chatScrollPane.setBounds(10, 80, 580, 400);

        caixaDeMensagem = new JTextArea();
        caixaDeMensagem.setBounds(10, 500, 600, 50);
        caixaDeMensagem.setLineWrap(true);
        JScrollPane mensagemScrollPane = new JScrollPane(caixaDeMensagem);
        mensagemScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        mensagemScrollPane.setBounds(10, 500, 600, 50);

        botaoEnviar = new JButton("Enviar");
        botaoEnviar.setBounds(620, 500, 150, 50);

        listaCliente = new DefaultListModel();
        jlistaCliente = new JList(listaCliente);
        jlistaCliente.setBounds(600,80,180,400);
        jlistaCliente.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jspListaCliente = new JScrollPane(jlistaCliente);
        jspListaCliente.setBounds(600,80,180,400);
        jspListaCliente.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);




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
        add(jspListaCliente);


    }

    public  String getText(){
        return this.caixaDeMensagem.getText();
    }

    public void setText(String msg){
        this.caixaDeMensagem.setText(msg);
    }

    public void setLista(String[] lista){
        listaCliente.removeAllElements();
        for (int i = 1; i <lista.length ; i++) {
            listaCliente.addElement(lista[i]);
        }
    }

}

