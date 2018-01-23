import java.util.ArrayList;

public class Shared {

    ArrayList<byte[]> sk; //secret key
    ArrayList<byte[]> vk; //verification key
    byte[] pk;

    public Shared(ArrayList<byte[]> sk, ArrayList<byte[]> vk, byte[] pk) {
        this.sk = sk;
        this.vk = vk;
        this.pk = pk;
    }
}
