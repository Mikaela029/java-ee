import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

//O Censo Demográfico (Lógica de Contagem). Queremos estatísticas reais. O programa deve analisar o texto de cada resposta (JSON) e contar quantos cidadãos estão vivos e quantos estão mortos. No final do programa (fora do loop), imprimam o relatório final na consola:=> CENSO: Detetados X personagens VIVOS e Y personagens MORTOS nos primeiros 20 registos.

public class CensoDemografico {
    public static void main(String[] args) throws Exception {
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

            if (res.body().contains("Dead")){
                contaDead = contaDead + 1;}
    
        }
        System.out.println("CENSO: Detetados "+contaAlive+" personagens VIVOS e "+contaDead+" personagens MORTOS nos primeiros 20 registos."); //o + aqui funciona como colar texto, adiciona informaçao a frente
    }

}
