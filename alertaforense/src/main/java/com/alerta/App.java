package com.alerta;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//4)Se o vosso programa detetar um alien morto, deve iniciar uma investigação após o alerta para descobrir onde ele foi visto pela última vez.Isolem o URL do episódio e façam o Java disparar um segundo pedido HTTP para o URL do episódio que acabaram de descobrir. Extraiam o nome desse episódio e mostrem o veredicto no ecrã com este formato: [ALERTA FORENSE] O último registo do alien morto foi no episódio: '...'.
//5) A - Servlet do Censo. Criar uma servlet que disponibiliza o relatório através do caminho “/census” (contagem de vivos/mortos, alerta de alien morto e análise forense do episódio relativo ao perigo biológico). Devolver o relatório em HTML em vez de escrever na consola. Permitir que o pedido ao servlet defina o intervalo de personagens que devem ser analisados. (?offset=x&limit=y, x=1 e y=20 por defeito). Permitir que o pedido defina se o alerta de ameaça biológica alienígena deve ou não ser gerado. (?showAlerts=true/false, true por defeito)

@WebServlet("/census")
public class App extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { // tem haver co a forma como o Java funciona. Esta função faz parte HttpServlet funciona, é que nos permite fazer o override no original
        
        try {
            int limit = Integer.parseInt(req.getParameter("limit"));
            int offset = Integer.parseInt(req.getParameter("offset")); 
            
            
            String census = getCensus(limit, offset, true);
            resp.getWriter().write(census);

        } catch (Exception e) {

        }

    }
   
    private String getCensus(int size, int offset, boolean showAlert) throws Exception {
        
        HttpClient client = HttpClient.newHttpClient();

        int contaAlive = 0; //estabelecemos a variavel do contador com um valor neutro, como vamos incrementar o valor neutro é 0
        int contaDead = 0; //sempre que terminamos uma instriçao numa linha usar o ;
        String finalString = "";

        for (int i = offset; i <= size + offset; i++) { //i=offset, pois o utilizador vai escolher onde começa com o offset, e i =< size + offset, pois o utlizador vai definir o tamanho da amostra, e o offset determina onde terrmina (ex: se o offset for 5, e o size 20, a pesquisa vai teminar no 25)
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create("https://rickandmortyapi.com/api/character/" + i))                                                                       
                        .GET()
                        .build(); 
                HttpResponse<String> res = client.send(request, HttpResponse.BodyHandlers.ofString());
            
                if (res.body().contains("Alive")){
                    contaAlive = contaAlive + 1; }

                    if (res.body().contains("Dead")) {
                        if (res.body().contains("Alien") && showAlert) {
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

                          finalString += "[ALERTA FORENSE] O último registo do alien morto foi no episódio:"+episodeName + "\n"; //sempre que o codigo entrar nesta secção ele vai pegar no que esta escrito e adicionar a variavel finalString. o += aglutina a info a frente, adicionando a variavel
                        }
                            contaDead = contaDead + 1;
                    }
        
                }
                     finalString += "CENSO: Detetados "+contaAlive+" personagens VIVOS e "+contaDead+" personagens MORTOS nos primeiros 20 registos."; //o + aqui funciona como colar texto, adiciona informaçao a frente

            return finalString; 
        }
    }        
