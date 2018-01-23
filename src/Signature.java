import java.security.SecureRandom;

public class Signature {

    public static byte[] skeygen ()
    {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[16]; // 128 bits are converted to 16 bytes;
        random.nextBytes(bytes);
        return (bytes);
    }

    public static String sign (byte[] usk , String m)
    {
        return( m );
    }

    public static  Boolean sverify (byte[] usk, String m)
    {
        return( true );
    }
}
