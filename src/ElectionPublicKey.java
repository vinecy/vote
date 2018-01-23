import java.util.ArrayList;

public class ElectionPublicKey {

    int G;
    int q;
    int pk;
    ArrayList vk;
    ArrayList V;
    ArrayList L;
    int H;

    public ElectionPublicKey(int g, int q, int pk, ArrayList vk, ArrayList v, ArrayList l, int h) {
        G = g;
        this.q = q;
        this.pk = pk;
        this.vk = vk;
        V = v;
        L = l;
        H = h;
    }



}
