package crude.com;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

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
public class Controller {

@Inject
private Service service; 

        @POST
        public void personagem(Personagem personagem) {

                service.personagem(personagem); 
        }

        @GET
        public Response getAll() {
                
                Response.ResponseBuilder responseBuilder = Response.ok();
                
                Response resposta = responseBuilder.entity().build();
                return resposta;

        }


        @DELETE
        public void deletePersonagem(int id) {
              service.deletePersonagem(id);
                
        }

        @PUT  //substitiu tudo
        public void putPersonagem() {
                

        }
        


        @PATCH { //substitui alguns atributos
        

        }
        
}