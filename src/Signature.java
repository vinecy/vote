import java.util.Random;

public class Signature {

    public static int  skeygen ( int security_parameter)
    {
        return (new Random().nextInt());
    }

    public static String sign (int usk , String m)
    {
        return( m );
    }

    public static  Boolean sverify (int usk, String m)
    {
        return( true );
    }
}
