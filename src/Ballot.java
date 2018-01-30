import javallier.src.main.java.com.n1analytics.paillier.EncryptedNumber;
import javallier.src.main.java.com.n1analytics.paillier.PaillierPublicKey;

public class Ballot {
    PaillierPublicKey upk;  // publick key
    EncryptedNumber C;       // vote encripted
    int pi;      // proof that C is either 1 or 0
    String sign; // sign of C+pi with usk

    public Ballot(PaillierPublicKey upk, EncryptedNumber C, int pi, String sign)
    {
        this.upk=upk;
        this.C=C;
        this.pi=pi;
        this.sign=sign;
    }
}
