package AleatoryNumber;
import java.util.Random;

public class CreatingAleatoryNumber {

    int aleatoryNumber;

    public CreatingAleatoryNumber(int aleatoryNumber) {
        this.aleatoryNumber = aleatoryNumber;
    }

    public int generateNumber() {
        aleatoryNumber = new Random().nextInt(101);
        return aleatoryNumber;
    }
}
