import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Fruta {
    private static final List<String> frutas = new ArrayList<>();

    static {
        frutas.add("Banana");
        frutas.add("Maçã");
        frutas.add("Laranja");
        frutas.add("Uva");
        frutas.add("Manga");
        frutas.add("Pera");
        frutas.add("Melancia");
        frutas.add("Morango");
        frutas.add("Abacaxi");
        frutas.add("Cereja");
    }

    public static String comerFruta() {
        Random aleatorio = new Random();
        int fruta = aleatorio.nextInt(frutas.size());
        return frutas.get(fruta);
    }
}
