import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

//Alerta de Segurança: Ameaça Alienígena. A Citadela precisa de monitorizar riscos biológicos. Se o vosso programa detetar um cidadão que seja da espécie Alien e que esteja Morto, deve imprimir um alerta imediato na consola: [PERIGO] Um Alien foi encontrado morto com o ID X!

public class AlertaSeguranca {
    public static void main(String[] args) throws Exception {
        HttpClient client = HttpClient.newHttpClient();

        int contaAlive = 0; // estabelecemos a variavel do contador com um valor neutro, como vamos
                            // incrementar o valor neutro é 0
        int contaDead = 0; // sempre que terminamos uma instriçao numa linha usar o ;
        for (int i = 1; i <= 20; i++) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://rickandmortyapi.com/api/character/" + i))
                    .GET()
                    .build();
            HttpResponse<String> res = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (res.body().contains("Alive")) {
                contaAlive = contaAlive + 1;
            }

            if (res.body().contains("Dead")) {
                if (res.body().contains("Alien")) {
                System.out.println("[PERIGO] Um Alien foi encontrado morto com o ID "+i);
                }
                contaDead = contaDead + 1;
            }

        }
        System.out.println("CENSO: Detetados " + contaAlive + " personagens VIVOS e " + contaDead + " personagens MORTOS nos primeiros 20 registos."); // o + aqui funciona como colar texto, adiciona
                                                                     // informaçao a frente
    }

}
