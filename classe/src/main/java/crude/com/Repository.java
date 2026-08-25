package crude.com;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@ApplicationScoped
public class Repository {

    @PersistenceContext
    private EntityManager em; // o entity manager é o que fala com a base de dados, faz a comunicaçao entre as bases de dados (persistence)

    public void personagem(Personagem personagem) {
        em.persist(personagem);
    
    }

    public List<Personagem> getAll() {
        return em.createQuery("SELECT p FROM Personagem p", Personagem.class).getResultList();
    }

    public void deletePersonagem(int id){ //o void não necessita de return
        em.remove(em.find(Personagem.class,id)); // estou a dizer ao entity manager que quero remover o objeto (personagem) da tabela

    }   

    public void putPersonagem(Personagem personagem){
        

    }

}
