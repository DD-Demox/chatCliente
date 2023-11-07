import javax.swing.*;
import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread {
    private Socket socket;
    public static ObjectInputStream in;
    public ServerThread(Socket socket) throws IOException {
        this.socket =socket;
        in = new ObjectInputStream(socket.getInputStream());
    }

    @Override
    public void run() {

        try {
            while (true){
                String[] codigo = (String[]) in.readObject();
                switch (codigo[0]){
                    case "global":
                        mandarGlobal(codigo);
                        break;
                    case "atualizarLista":
                        Telas.chatGlobal.setLista(codigo);
                        break;
                    case "msgPrivada":
                        madarPrivado(codigo);
                        break;
                }



            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    private void madarPrivado(String[] codigo) {
        TelaChatPrivado chatPrivado= null;
        for(TelaChatPrivado tcp: Telas.chatsPrivados){
            if(tcp.getDestinatario().equals(codigo[1])){
                chatPrivado = tcp;
                break;
            }
        }
        chatPrivado.setTextChat(codigo[2]);

    }

    private void mandarGlobal(String[] codigo){

        JScrollPane caixaPane = (JScrollPane) Telas.chatGlobal.getComponent(1);
        JTextArea chatglobal = (JTextArea) caixaPane.getViewport().getView();
        chatglobal.append(codigo[2]+":"+codigo[5]+"\n");

    }

}
