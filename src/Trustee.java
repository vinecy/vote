import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by zied on 23/01/18.
 */
public class Trustee {

    public static final ArrayList<Integer> L = null ;
    public static  ArrayList<Ballot> BB = new ArrayList<>(3);
    int index;


    // Checks whether VerifyEq(g, vkk, RΣ, ck, πk) = 1 for k = 1, . . . , `. If not, it outputs result ← ∅. Else,
    boolean verifyEp(int g, int vKk, String RSom, int piK){
        boolean verify=false;
        //if(verification==1) verify=true;
        return verify;
    }

    /*
    Setup(1λ,l) is a possibly interactive algorithm run by ` trustees. It takes as inputs the security parameter 1
    λ and the total number l of trustees. It outputs an election public key pk, which includes the description of the set of
    admissible votes V; a list of secret keys sk. We assume pk to be an implicit input of the remaining algorithms.
    */
    public ElectionPublicKey Setup(int security_parameter, int l, int t){
       Shared s = Distkg(security_parameter, l , t);
       int sk = s.sk.get(index);
       ArrayList<Integer> vk = s.vk;
       int pk = s.pk;
       ArrayList<Integer> v = null;
       v.add(0);v.add(1);
       return(new ElectionPublicKey(1,1,pk,vk,v,L,1));
    }

    public Shared Distkg(int securityParameter, int t, int l)
    {
        ArrayList<Integer> sk =null;
        ArrayList<Integer> vk =null;
        for (int i =0 ; i<l; i++){
            sk.add(i);
            vk.add(i);
        }
        int pk=1;
        return (new Shared( sk, vk, pk));
    }

    /*
   BallotBox(BB, b) takes as inputs the bulletin board BB and a ballot b. If Validate(b) accepts it adds b to BB;
   otherwise, it lets BB unchanged.
    */
    public void ballotbox(ArrayList<Ballot> BB, Ballot b){

        if ( validate(b)) {
            for (Iterator<Ballot> bb = BB.iterator(); bb.hasNext();) {
                if(bb.next().upk==b.upk) {
                    bb.remove();
                }
            }
            BB.add(b);
        }
    }

    /*
Validate(b) takes as input a ballot b and returns accept or reject for well/ill-formed ballots
 */
    public Boolean validate (Ballot b)
    {
        if (   // !L.contains(b.upk) &&
                Disj.disjverify(1,b.upk, b.C, b.pi) &&
                Signature.sverify(b.upk,Integer.toString(b.C)+Integer.toString(b.pi))) {
            return(true);
        }
        return(false);
    }

    /*
    Tally(BB, sk) takes as input the bulletin board BB = {b1, . . . , bτ } and the secret key sk, where τ is the number of
    ballots cast. It outputs the tally result, together with a proof of correct tabulation Π. Possibly, result = invalid,
    meaning the election has been declared invalid.
     */
    public Result tally (ArrayList<Ballot> BB, int sk){
        //etape 1,2,3
        String somme_r = null;
        String somme_s = null;
        ArrayList<Integer> liste = null;
        for (Ballot bb: BB  ) {
            if (!validate(bb) || liste.contains(bb.upk)) {
                return(new Result(false, 1));
            }
            liste.add(bb.upk);
            somme_r.concat(Integer.toString(bb.C));
            somme_s.concat(bb.sign);
        }
        String c = Crypto.sharedec(sk, 1 , somme_r, somme_s);
        return null;
    }

    /*
    Verify(BB,result, Π) takes as input the bulletin board BB, and a result/proof pair (result, Π) and checks whether
    Π is a valid proof of correct tallying for result. It returns accept if so; otherwise it returns reject
     */
    public Boolean verify ( ArrayList<Ballot> BB, Result result){
        //etape 1,2,3
        ArrayList<Integer> liste = null;
        for (Ballot bb: BB ) {
            if (!validate(bb) || liste.contains(bb.upk)) {
                return(false);
            }
            liste.add(bb.upk);
        }
        return(true);
    }

}
