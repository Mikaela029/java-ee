package crude.com;


/*CRUD
 
Criar uma classe chamada Personagem. Esta classe deve ter os seguintes campos (com getters, setters e construtores):
    private String nome;
    private String especie;
    private String comidaFavorita;
 
 
Criar um endpoint (“/personagem”) que permita fazer operações CRUD:
    Usar o método POST para criar uma nova personagem.
    Usar o método GET para ler todas as personagens.
*/
 
public class Personagem {

       private String nome = "";
       private String especie = "";
       private String comidaFavorita = "";

public static void Personagem (String nome, String especie, String comidaFavorita[] args ){
    
    this.nome = nome;
    this.especie = especie;
    this.comidaFavorita = comidaFavorita;
        
       }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getEspecie(){
        this.especie = especie;
    }
    public void setEspevie(){

    }

    public void getComidaFavorita(){

    }

    }

