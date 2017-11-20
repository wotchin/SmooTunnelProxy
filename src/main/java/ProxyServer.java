
import java.io.IOException;
import java.net.*;

import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ProxyServer {

    public ProxyServer(int port) throws IOException{

        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            throw new IOException("Port initial error.");
        }
        ExecutorService thread = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2 +1);
        while (true){
            try {
                Socket socket = server.accept();
                //等待手动创建线程池
                System.out.println(socket.getLocalPort());
                thread.submit(new ProxyCustom(socket));
            }catch (IOException e){
                e.printStackTrace();
            }

        }
    }
}
