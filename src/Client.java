import javallier.src.main.java.com.n1analytics.paillier.EncryptedNumber;
import javallier.src.main.java.com.n1analytics.paillier.PaillierPrivateKey;

import java.util.ArrayList;

public class Client {

    private PaillierPrivateKey p;
    private String login;
    private String pwd;
    private int id;
    public Boolean voted = false;

    public Client( String login, String pwd, int id) {
        this.login = login;
        this.pwd = pwd;
        this.id = id;
    }

    /*
        Register(1λ, id) captures the registration phase that is intuitively inherent to any voting system. On inputs the
        security parameter 1 λ and a unique identifier id for the user, it outputs the secret part of the credential uskid
        and the public part of the credential upkid. We assume the list L = {upkid} of legitimate public credentials to
        be included in the public key pk. Hence every algorithm in the voting protocol has access to L. Of course, if
        no credentials are needed, L is empty and Register(1λ, id) is void
         */
    public PaillierPrivateKey Register(int security_parameter, int id){
        PaillierPrivateKey c = PaillierPrivateKey.create(security_parameter);
        //Trustee.L.add(c.upk);
        return(c);
    }

    /*
   Vote(id, upk, usk, v) is used by voter id to cast his choice v ∈ V for the election. It outputs a ballot b, which
   may/may not include the identifier id. The identifier id can be seen as an optional input.
    */
    public Ballot vote ( int id,  int v){
        PaillierPrivateKey p=  Register(512, id);
        EncryptedNumber C =  Crypto.Enc(p.getPublicKey(), v);
        int pi =  Disj.disjproof( 1, p.getPublicKey(),1, 1);
        Ballot b = new Ballot(p.getPublicKey(), C, pi, Signature.sign(p, C.getExponent()+Integer.toString(pi)));
        //Trustee.BB.add(b);
        return(b);
    }


    /*
    VerifyVote(BB, id, upk, usk, b) is a typically light verification algorithm intended to the voters, for checking that
    their ballots will be included in the tally. It takes as input the bulletin board BB, a ballot b, and the voter’s
    credentials usk, upk and performs some validity checks, returning accept or reject.
     */
    public Boolean verifyvote(ArrayList<Ballot> BB, int id, byte[] upk, byte[] usk, Ballot b){
        return(BB.contains(b));
    }

    public PaillierPrivateKey getP() {
        return p;
    }

    public String getLogin() {
        return login;
    }

    public String getPwd() {
        return pwd;
    }

    public int getId() {
        return id;
    }

    public Boolean getVoted() {
        return voted;
    }
}
