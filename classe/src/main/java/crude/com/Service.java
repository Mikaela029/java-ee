package crude.com;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class Service {

    @Inject
    private Repository repository; //o 1 repositório é a classe, o repositorio a branco é o objeto criado na classe

    @Transactional
    public void personagem(Personagem personagem) { //referente ao POST
       
        if (personagem.getComidaFavorita() == null ||
            personagem.getComidaFavorita().isBlank()){ 
 
            personagem.setComidaFavorita("Lasanha");
 
    }
     repository.personagem(personagem);
 
    }
    public List<Personagem> getAll() { //REFERENTE AO GET
        return repository.getAll(); // o objeto repository tem as propriedades (funçoes) da classe Repository
    }

    public void deletePersonagem(int id){ //REFERENTE AO GET. o atributo é um int
        repository.deletePersonagem(id);
    }

    public void putPersonagem(Personagem personagem){ //REFERENTE AO PUT
        repository.putPersonagem(personagem);
    }

}

