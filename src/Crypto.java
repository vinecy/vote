import java.util.ArrayList;

public class Crypto {

    public void distkg( int security_parameter, int t, int l){

        /*
        DistKG(1λ, t, l) proceeds as follows:
           1. Each party Pi chooses a random t-degree polynomial fi(x) = ai0+ai1x+. . .+aitx t ∈ Z[x] and broadcasts
           Aik = g aik for k = 0, . . . , t. Denote the secret held by Pi as si = fi(0) and let Yi = g
           fi(0). Each party Pi computes shares sij = fi(j) mod q of its own secret si for j = 1, . . . , ` and sends sij ∈ Zq secretly to
           party Pj .
           2. Each party Pj verifies the shares he received by checking for i = 1, . . . , `:
           g sij = Y t k=0 (Aik) j k (1)
           If a check fails for an index i then Pj broadcasts a complaint against Pi
           3. Party Pi reveals share sij ∈ Zq if it receives a complaint against him by party Pj . If any of the revealed
           shares sij fails to satisfy Equation 1, then Pi
           is disqualified. Let us define the set QUAL 6= ∅ as the set of
           qualified players.
           4. The public key is computed as pk = Q i∈QUAL Yi P . Each Pj sets his share of the secret key as xj =
           i∈QUAL sij mod q. The virtual decryption key x = P i∈QUAL si mod q is not needed to be known to
           be able to decrypt. The public verification keys are computed as vkj = Q i∈QUAL g sij for j = 1, . . . , `.
         */
    }


    public static String  sharedec(int ski, int vki, String R, String S){
        /*
            ShareDec(ski , vki , C) outputs (i, ci = Rxi ).
        */
        return (null);
    }

    public boolean verifyeq(int g, int vki, String R, String c, String pi){
        return true;
    }

    public void rec ( ElectionPublicKey pk, int vk, ArrayList C , ArrayList c){
        /*
        Rec(pk, vk, C, C) parses C = (R, S), C = {ci1 , . . . , cit+1 } and outputs m
         */
    }

    public static int Enc(int upk, int v){
         /*
           outputs C = (R, S) = (g r , Y r · m) for a plaintext m ∈ G and randomness r R ← Zq.
        */
        return (v);
    }


}
