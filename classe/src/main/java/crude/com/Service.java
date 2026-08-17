package crude.com;

import java.util.List;

public class Service {

    static void personagem(Personagem personagem) {
       
        if (personagem.getComidaFavorita() == null ||
            personagem.getComidaFavorita().isBlank()){ 
 
            personagem.setComidaFavorita("Lasanha");
 
    }
     Repository.personagem(personagem);
 
    }
    static List<Personagem> getAll() {
        return Repository.getAll();
    }

}
