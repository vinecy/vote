import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zied on 23/01/18.
 */
public class Main {

    static ArrayList<Client> L =new ArrayList<Client>(3);
    //static Map<String, String> questions = new HashMap<String, String>();

    public static void main(String[] args) throws IOException {

        ArrayList<Integer> test=new ArrayList<>(1);
        test.add(1);

        int t ;
        //demander t
        System.out.println("Donner t");
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferRead.readLine();
        t = Integer.parseInt(s);
        //demander l
        int l;
        System.out.println("Donner l");
        BufferedReader bufferRead1 = new BufferedReader(new InputStreamReader(System.in));
        s = bufferRead.readLine();
        l = Integer.parseInt(s);

        //demander nombre de clients
        int nbClient;
        System.out.println("Donner nombre de clients");
        BufferedReader bufferRead2 = new BufferedReader(new InputStreamReader(System.in));
        s = bufferRead.readLine();
        nbClient = Integer.parseInt(s);
        //construire L

        L.add(new Client("login", "pwd", 0));
        L.add(new Client("login1", "pwd1", 1));
        L.add(new Client("login2", "pwd2", 2));


        for (int i=0; i<nbClient;i++)
        {
            Login k = new Login();
        }

        while(!(L.get(0).voted  && L.get(1).voted  && L.get(2).voted ))
        {
            System.out.println("\nNouveau print!");
            /*for (Ballot b:Trustee.BB
                    ) {
                System.out.println(b.upk);
            }
            */
        }
        for (Ballot b:Trustee.BB
                ) {
            System.out.println(b.upk);
        }

    }
}
