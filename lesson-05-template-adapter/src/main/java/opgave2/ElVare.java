package opgave2;

public class ElVare extends Vare{

    public ElVare(int pris, String navn) {
        super(pris, navn);
    }

    public double beregnMoms() {
        double moms = getPris() * 0.3;
        if (moms > 3) {
            return moms;
        }
        return 3;
    }
}
