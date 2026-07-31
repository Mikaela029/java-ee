package com.example;

import java.io.IOException;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

@Path("/test") 
public class App {
    
    @GET  
    public String ping(@QueryParam("user") int id) { //devolve em string
        System.out.println("Olá");
        return "ID do pedido" + id;
    }
    
        }

    
   


    

