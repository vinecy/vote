public class Ballot {
    byte[] upk;  // publick key
    int C;       // vote encripted
    int pi;      // proof that C is either 1 or 0
    String sign; // sign of C+pi with usk

    public Ballot( byte[] upk, int C, int pi, String sign)
    {
        this.upk=upk;
        this.C=C;
        this.pi=pi;
        this.sign=sign;
    }
}
