import java.util.ArrayList;

public class Shared {

    ArrayList<Integer> sk; //secret key
    ArrayList<Integer> vk; //verification key
    Integer pk;

    public Shared(ArrayList<Integer> sk, ArrayList<Integer> vk, Integer pk) {
        this.sk = sk;
        this.vk = vk;
        this.pk = pk;
    }
}
