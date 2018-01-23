import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by zied on 23/01/18.
 */
public class Main {


    public static void main(String[] args) throws IOException {

        int t ;
        //demander t
        System.out.println("Donner t");
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferRead.readLine();
        t = Integer.parseInt(s);
        //demander l
        int l;
        System.out.println("Donner L");
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

        //creer tout les trustee
        //creer tout les clients

        //for(){Login)



    }

}
