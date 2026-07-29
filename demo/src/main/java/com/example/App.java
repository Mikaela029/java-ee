package com.example;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/") //o Tomee, o servidor, vai encontrar o caminho para o servidor
public class App extends HttpServlet {
    
    @Override // duas funcionalidades, é informativo, e ajuda a nao cometer erros.  
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     //usamos o protected para subscrever o metodo (ter o mesmo metodo com outro comportamento) do get que existe na classe do httpServlet
    //faz um get, e recebe 2 parametros, o req e o resp
    //sempre que quisermos conusltar alguma coisa do pedidio usamos a variavel req (request)
    //sempre que quisermos responder, usamos a resp (response)
        resp.getWriter().println("Servlet Online");
        
        }

    } 
   


    

