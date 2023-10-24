import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private Scanner scanner;
    private PrintStream out;
    String msg;
    String clientInput;
    String name="";
    ServerThread serverThread;


    Client(){
        try(Socket socket = new Socket("127.0.0.1",10000)) {

            scanner = new Scanner(System.in);
            out = new PrintStream(socket.getOutputStream(),true);
            serverThread = new ServerThread(socket);
            serverThread.start();
            do {
                if(name.equals("")){
                    System.out.println("Digite seu nome:");

                    clientInput = scanner.nextLine();
                    name=clientInput;
                    out.println(name+ " entrou!");
                    if (name.equals("sair")){
                        break;
                    }

                }else{
                    clientInput = scanner.nextLine();
                    out.println(name+": "+clientInput);
                    if(clientInput.equals("sair")){
                        break;
                    }
                }

            }while (!clientInput.equals("sair"));




        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
