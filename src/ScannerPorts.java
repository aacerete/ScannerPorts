import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Created by 46990527d on 08/02/17.
 */
public class ScannerPorts {

    static int PortInici = 5554;
    static int PortFi = 65535;

    public static void main(String[] args) {

        //ip 172.31.73.44
        String ip = "localhost";


        for (int port = PortInici; port < PortFi; port++) {

            try {

                Socket socket = new Socket();
                SocketAddress adress = new InetSocketAddress(ip,port);
                socket.connect(adress);

                OutputStream os = socket.getOutputStream();

                String mensaje = "Tens el "+ port + " obert" ;
                os.write(mensaje.getBytes());

                System.out.println("Escanejant port: " + port);


                System.out.println("El port número:" + port + " està obert");
                socket.close();

            } catch (Exception ex) {
                System.out.println("port " + port + " tancat");
            }
        }
    }
}