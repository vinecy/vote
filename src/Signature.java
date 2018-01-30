import javallier.src.main.java.com.n1analytics.paillier.PaillierPrivateKey;
import javallier.src.main.java.com.n1analytics.paillier.PaillierPublicKey;

import java.security.SecureRandom;

public class Signature {


    public static String sign (PaillierPrivateKey usk , String m)
    {
        return( m );
    }

    public static  Boolean sverify (PaillierPublicKey upk, String m)
    {
        return( true );
    }
}
