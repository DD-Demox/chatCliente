import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerThread extends Thread {
    private Socket socket;
    private BufferedReader br;
    public ServerThread(Socket socket) throws IOException {
        this.socket =socket;
        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run() {

        try {
            while (true){
                String response = br.readLine();
                System.out.println(response);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
