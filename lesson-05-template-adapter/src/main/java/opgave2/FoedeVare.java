package opgave2;

public class FoedeVare extends Vare{

    public FoedeVare(int pris, String navn) {
        super(pris, navn);
    }

    public double beregnMoms() {
        double moms = getPris() * 0.05;
        if (moms > 3) {
            return moms;
        }
        return 3;
    }
}
