package crude.com;

import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

/*CRUD
Criar uma classe chamada Personagem. Esta classe deve ter os seguintes campos (com getters, setters e construtores):
        private String nome;
        private String especie;
        private String comidaFavorita;
 
 
Criar um endpoint (“/personagem”) que permita fazer operações CRUD:
        Usar o método POST para criar uma nova personagem.
        Usar o método GET para ler todas as personagens.
*/

@Path("/personagem")
public class App {

        private static List<Personagem> lista = new ArrayList<>();

        @POST
        public void personagem(Personagem personagem) {

                // construtores
                // Personagem novoPersonagem = new Personagem("Maria", "Humana :)",
                // "Quesadilla");

                lista.add(personagem);
        }

        @GET
        public List<Personagem> getAll() {
                return lista;
        }



}