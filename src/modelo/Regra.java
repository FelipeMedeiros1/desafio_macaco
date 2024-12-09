package modelo;

public class Regra {

    public void regraDoJogo(){
        System.out.println("""
                =======================================================================
                ##Jogo do Macaco
                #regras:
                1- Defina a quantidade de jogadores.
                2- Dê um nome para cada macaco.
                3- O jogo começa e o macaco sai para procurar alimento.
                4- Se o macaco encontrar ele come, e acumula o alimento no bucho.
                5- Se o macaco não encontrar ele passa a vez. 
                
                #como vencer o jogo
                Para vencer o macaco deve comer 4 alimentos diferentes ou 4 iguais.
                No bucho do macaco só cabe 4 alimentos,
                Se o bucho estiver cheio e não estiver na condição de vencer o jogo,
                o macaco terá que fazer cocô para eliminar um alimento do seu bucho,
                e só poderá jogar na próxima rodada 
                =======================================================================
                """);
    }

}
