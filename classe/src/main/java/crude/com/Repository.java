package crude.com;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    private static List<Personagem> lista = new ArrayList<>();

    static void personagem(Personagem personagem) {
        lista.add(personagem);

    }

    static List<Personagem> getAll() {
        return lista;
    }
}
