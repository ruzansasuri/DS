import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Ruzan on 1/26/2018.
 */
public class TCPClient
{
    public static void main(String ag[])throws IOException
    {
        String serverName ="localhost";
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Socket connection = new Socket(serverName, 6789);
        DataOutputStream dos = new DataOutputStream(connection.getOutputStream());
        String sentence = input.readLine();
        dos.writeBytes(sentence + "\n");
        BufferedReader fromServer = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String modSentence = fromServer.readLine();
        System.out.println(modSentence);
        connection.close();
    }
}
//import java.io.BufferedReader;
//        import java.io.DataOutputStream;
//        import java.io.IOException;
//        import java.io.InputStreamReader;
//        import java.net.ServerSocket;
//        import java.net.Socket;
//
///**
// * Created by Ruzan on 1/26/2018.
// */
//public class TCPServer
//{
//    public static void main(String ag[]) throws IOException
//    {
//        ServerSocket server = new ServerSocket(6789);
//        while(true)
//        {
//            Socket connection = server.accept();
//            BufferedReader fromClient = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//            DataOutputStream toClient = new DataOutputStream(connection.getOutputStream());
//            String clientMessage = fromClient.readLine();
//            System.out.println(clientMessage);
//            String cap = clientMessage.toUpperCase() + "\n";
//            toClient.writeBytes(cap);
//        }
//    }
//}
