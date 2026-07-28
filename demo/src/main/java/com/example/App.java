package com.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class App 
{
    public static void main( String[] args )

    {
        String jsonString = "{\"id\":\"1\", \"nome\":\"Mikaela\"}";

        ObjectMapper mapper = new ObjectMapper();
        //o codigo "perigoso" vem para dentro das chavetas
        try {
            JsonNode jsonNode = mapper.readTree(jsonString);
            int id = jsonNode.get("id").asInt();
            String nome = jsonNode.get("nome").asText();
            //classe colocamos a começar como mauscula, objetos comecam com minuscula
            
        }
        catch(JsonMappingException pe) {
                System.out.println("Erro a mapear a String Json");
        }
        catch(JsonProcessingException me) {
            System.out.println("Erro a ler a String Json");
        }
        //se correr bem no try, o codigo continua a ler, senão usamos o catch para resolver/ aparecer a mensagem
        

        System.out.println( "Hello World!" );
    }
}
