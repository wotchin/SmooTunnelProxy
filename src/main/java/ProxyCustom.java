
import java.io.*;
import java.net.Socket;

public class ProxyCustom implements Runnable {

    private final Socket socket;

    public ProxyCustom(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = null;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = in.readLine())!=null){
                stringBuilder.append(line);
            }
            System.out.println(stringBuilder.toString());
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println("over");
        }
    }
}
