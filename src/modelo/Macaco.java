import java.util.*;

import static java.lang.Thread.sleep;

public class Macaco {

    private String nome;
    private List<String> bucho = new ArrayList();

    public Macaco(String nome) {
        this.nome = nome;
    }

    public boolean procurarComida() {
        procurar();
        return encontrou();
    }

    public void comer() {
        if (bucho.size() == 4) {
            System.out.println(this.nome + " está com bucho cheio! Você precisa fazer cocô...");
            esperar();
            System.out.println(this.nome + " está fazendo cocô...");
            esperar();
            fazerCoco();

        } else {
            String fruta = Fruta.comerFruta();
            bucho.add(fruta);
            System.out.println(this.nome + " comeu: " + fruta);
            esperar();
        }
    }

    private void fazerCoco() {
        bucho.remove(bucho.get(0));
        System.out.println("Agora você pode comer novamente. ");
        esperar();
    }

    public boolean checarVitoria() {
        if (bucho.size() < 4) return false;
        Set<String> frutasNoBucho = new HashSet<>(bucho);

        return frutasNoBucho.size() == 1 || frutasNoBucho.size() == bucho.size();
    }

    private void procurar() {
        separador();
        System.out.println(this.nome + " está procurando alimento...");
        esperar();
    }

    private boolean encontrou() {
        Random aleatorio = new Random();
        int procurar = aleatorio.nextInt(10) + 1;

        if (procurar % 2 == 0) {
            System.out.println(this.nome + " encontrou!!!");
            return true;
        } else {
            System.out.println(this.nome + " não encontrou! Passou a vez.");
            esperar();
            return false;
        }
    }

    public String getNome() {
        return nome;
    }

    public List<String> getBucho() {
        return bucho;
    }

    private void esperar() {
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private String separador() {
        String separador = "===================================================";
        System.out.println(separador);
        return separador;
    }


}
