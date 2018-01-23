
import java.util.ArrayList;
import java.util.Iterator;

public class Algo {

    ArrayList L;

    /*
    Setup(1λ,l) is a possibly interactive algorithm run by ` trustees. It takes as inputs the security parameter 1
    λ and the total number l of trustees. It outputs an election public key pk, which includes the description of the set of
    admissible votes V; a list of secret keys sk. We assume pk to be an implicit input of the remaining algorithms.
    */
     public election_public_key Setup(int security_parameter, int l, int t){
        return(new election_public_key());
    }

    /*
    Register(1λ, id) captures the registration phase that is intuitively inherent to any voting system. On inputs the
    security parameter 1 λ and a unique identifier id for the user, it outputs the secret part of the credential uskid
    and the public part of the credential upkid. We assume the list L = {upkid} of legitimate public credentials to
    be included in the public key pk. Hence every algorithm in the voting protocol has access to L. Of course, if
    no credentials are needed, L is empty and Register(1λ, id) is void
     */
    public credentials Register(int security_parameter, int id){
        credentials c = new credentials(signature.skeygen(security_parameter),signature.skeygen(security_parameter));
        L.add(c.upk);
        return(c);
    }

    /*
    Vote(id, upk, usk, v) is used by voter id to cast his choice v ∈ V for the election. It outputs a ballot b, which
    may/may not include the identifier id. The identifier id can be seen as an optional input.
     */
    public ballot vote ( int id, int upk, int usk, int v){
        int C =  crypto.Enc(upk, v);
        int pi =  Disj.disjproof( 1, upk,1, 1);
        return( new ballot(upk, C, pi, signature.sign(usk, Integer.toString(C)+Integer.toString(pi))));
    }

    /*
    VerifyVote(BB, id, upk, usk, b) is a typically light verification algorithm intended to the voters, for checking that
    their ballots will be included in the tally. It takes as input the bulletin board BB, a ballot b, and the voter’s
    credentials usk, upk and performs some validity checks, returning accept or reject.
     */
    public Boolean verifyvote(bulletinboard BB, int id, String upk, String usk, ballot b){
        return(BB.ballots.contains(b));
    }

    /*
    Validate(b) takes as input a ballot b and returns accept or reject for well/ill-formed ballots
     */
    public Boolean validate (ballot b)
    {
        if (    L.contains(b.upk) &&
                Disj.disjverify(1,b.upk, b.C, b.pi) &&
                signature.sverify(b.upk,Integer.toString(b.C)+Integer.toString(b.pi))) {
            return(true);
        }
        return(false);
    }

    /*
    BallotBox(BB, b) takes as inputs the bulletin board BB and a ballot b. If Validate(b) accepts it adds b to BB;
    otherwise, it lets BB unchanged.
     */
    public void ballotbox(bulletinboard BB, ballot b){

        if ( validate(b)) {
            for (Iterator<ballot> bb = BB.ballots.iterator(); bb.hasNext();) {
                if(bb.next().upk==b.upk) {
                    bb.remove();
                }
            }
            BB.ballots.add(b);
        }
    }

    /*
    Tally(BB, sk) takes as input the bulletin board BB = {b1, . . . , bτ } and the secret key sk, where τ is the number of
    ballots cast. It outputs the tally result, together with a proof of correct tabulation Π. Possibly, result = invalid,
    meaning the election has been declared invalid.
     */
    public result tally (bulletinboard BB, int sk){
        //etape 1,2,3
        ArrayList<Integer> liste = null;
        for (ballot bb: BB.ballots  ) {
            if (!validate(bb) || liste.contains(bb.upk)) {
                return(new result(false, 1));
            }
            liste.add(bb.upk);
        }
        return null;
    }

    /*
    Verify(BB,result, Π) takes as input the bulletin board BB, and a result/proof pair (result, Π) and checks whether
    Π is a valid proof of correct tallying for result. It returns accept if so; otherwise it returns reject
     */
    public Boolean verify ( bulletinboard BB, result result){
        //etape 1,2,3
        ArrayList<Integer> liste = null;
        for (ballot bb: BB.ballots  ) {
            if (!validate(bb) || liste.contains(bb.upk)) {
                return(false);
            }
            liste.add(bb.upk);
        }
        return(true);
    }
}
