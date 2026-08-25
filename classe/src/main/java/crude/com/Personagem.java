package crude.com;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity //dizer ao Jakarta que o Personagem precisa de uma tabela criada
public class Personagem {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY) //atribuimos um valor ao stratagy. dizemos ao jakarta para criar ids
        private int id;

        public String toDString() {
                return "nome: "+ nome+ ", id: "+ id + "espécie: "+especie + "comida favorita: "+ comidaFavorita;
                
        }


        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        private String nome;
        private String especie;
        private String comidaFavorita;

      public Personagem() {
        
      }

                public Personagem(String nome, String especie, String comidaFavorita) {
                        this.nome = nome;
                        this.especie = especie;
                        this.comidaFavorita = comidaFavorita;
                }

                // getters e setters
                public String getNome() {
                        return nome;
                }

                public void setNome(String nome) {
                        this.nome = nome;
                }

                public String getEspecie() {
                        return especie;
                }

                public void setEspecie(String especie) {
                        this.especie = especie;
                }

                public String getComidaFavorita() {
                        return comidaFavorita;
                }

                public void setComidaFavorita(String comidaFavorita) {
                        this.comidaFavorita = comidaFavorita;
                }

}