import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

//O Varredor de Portais (O Loop). O vosso programa deve analisar automaticamente os primeiros 20 cidadãos do universo. Criem um ciclo que faça o código Java disparar 20 pedidos HTTP seguidos, alterando o ID no fim do URL de forma dinâmica (do ID 1 ao 20).
 
public class VarredorDePortais {
    public static void main(String[] args) throws Exception {
        HttpClient client = HttpClient.newHttpClient();

        // int para nrs inteiros,
        // i=1 - dizemos que vamos mudar o valor em 1, o i é a variavel que guarda o nr
        // i<21 - o programa vai correr enquanto o nr for menor que 21, ou seja, 20 ->
        // nao pode ser i=20, pois o programa não começa em 20, e, tendo esse comando, o
        // programa leria como estar a começar em 20
        // poderiamos tambem usar o i<=20
        // i++ - ordem da incrementaçao, que é positiva
        // para aumentar o i em 1, costuma-se fazer i= i+1, pode-se fazer i += 1, ou
        // entao como foi colocado, o ++ no caso é só para aumentar em 1 for (int i = 1;
        // i < 21; i++) {
        for (int i = 1; i <= 20; i++) {
            HttpRequest request = HttpRequest.newBuilder()
                    // uri é o que permite ao Java utilizar os links
                    .uri(URI.create("https://rickandmortyapi.com/api/character/" + i)) // o +i é para o programa saber
                                                                                       // que tem de ir avançando 1
                    .GET()
                    .build(); // pegar em todas as instruções dadas anteriormente, é a funcionaliade que permite ao Java utilizar o que foi escrito para trás
            HttpResponse<String> res = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(res.body() + "\n");

        }

    }

}
