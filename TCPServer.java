import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Ruzan on 1/26/2018.
 */
public class TCPServer
{
    public static void main(String ag[]) throws IOException
    {
        ServerSocket server = new ServerSocket(6789);
        while(true)
        {
            Socket connection = server.accept();
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            DataOutputStream toClient = new DataOutputStream(connection.getOutputStream());
            String clientMessage = fromClient.readLine();
            System.out.println(clientMessage);
            String cap = clientMessage.toUpperCase() + "\n";
            toClient.writeBytes(cap);
        }
    }
}
