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
                mandarGlobal(codigo);


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

    private void mandarGlobal(String[] codigo){

        JScrollPane caixaPane = (JScrollPane) Telas.chatGlobal.getComponent(1);
        JTextArea chatglobal = (JTextArea) caixaPane.getViewport().getView();
        chatglobal.append(codigo[2]+":"+codigo[5]+"\n");

    }
}
