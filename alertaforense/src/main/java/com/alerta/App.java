package com.alerta;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

//Se o vosso programa detetar um alien morto, deve iniciar uma investigação após o alerta para descobrir onde ele foi visto pela última vez.Isolem o URL do episódio e façam o Java disparar um segundo pedido HTTP para o URL do episódio que acabaram de descobrir. Extraiam o nome desse episódio e mostrem o veredicto no ecrã com este formato: [ALERTA FORENSE] O último registo do alien morto foi no episódio: '...'.
 
public class App 
{
    public static void main( String[] args )  throws Exception {
     HttpClient client = HttpClient.newHttpClient();

     int contaAlive = 0; //estabelecemos a variavel do contador com um valor neutro, como vamos incrementar o valor neutro é 0
     int contaDead = 0; //sempre que terminamos uma instriçao numa linha usar o ;
     for (int i = 1; i <= 20; i++) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://rickandmortyapi.com/api/character/" + i))                                                                       
                    .GET()
                    .build(); 
            HttpResponse<String> res = client.send(request, HttpResponse.BodyHandlers.ofString());
        
            if (res.body().contains("Alive")){
                contaAlive = contaAlive + 1; }

                if (res.body().contains("Dead")) {
                    if (res.body().contains("Alien")) {
                      ObjectMapper mapper = new ObjectMapper(); //mapper é especialista em olhar padroes em texto
                        JsonNode jsonNode = mapper.readTree(res.body()); //o jsonNode vai restruturar a info que o mapper devolve
                        String status = jsonNode.get("status").asText();
                        String specie = jsonNode.get("species").asText();    
                        List<String> episodes = mapper.convertValue(jsonNode.get("episode"), new TypeReference<List<String>>() {}); 
                        String lastEpisode = episodes.getLast(); 
                        HttpRequest request2 = HttpRequest.newBuilder()
                            .uri(URI.create(lastEpisode))
                            .GET()
                            .build();
                        HttpResponse<String> res2 = client.send(request2, HttpResponse.BodyHandlers.ofString());

                        String episodeName = mapper.readTree(res2.body()).get("name").asText(); //o Java não sabe a forma como tem de guardar a info, quando dizemos asText estamos a dizer que queremos a info em forma de trxto 

                        System.out.println("[ALERTA FORENSE] O último registo do alien morto foi no episódio:"+episodeName);
                }
                contaDead = contaDead + 1;
            }

    
        }
        System.out.println("CENSO: Detetados "+contaAlive+" personagens VIVOS e "+contaDead+" personagens MORTOS nos primeiros 20 registos."); //o + aqui funciona como colar texto, adiciona informaçao a frente

        System.out.println( "Hello World!" );
    }
}
