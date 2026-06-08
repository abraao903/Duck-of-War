package TrabalhoAvaliativo;

public class Cisne extends Aves implements  Ataques{

    public Cisne(){

        this.nome = "PATO CISNE ";
        this.vida = 600;
        this.ataque = 20;
        this.defesa = 35;
        this.velocidade = 30;

        System.out.println("Criando um " + this.nome);
        System.out.println(this.vida + " de vida");
        System.out.println(this.ataque + " de ataque");
        System.out.println(this.defesa + " de defesa");
        System.out.println(this.velocidade + " de velocidade");
        System.out.println("======== Interações com o terreno ========");
        System.out.println("Terreno vantajoso: " + Terrenos.AQUATICO);
        System.out.println("Terreno neutro: " + Terrenos.AEREO);
        System.out.println("Terreno Ruim: " + Terrenos.TERRESTRE + "\n");

    }

    @Override
    public String getNomeAtaqueNormal(){
        return "Grasnido Ensurdercedor : dano 1x";
    }

    @Override
    public String getNomeAtaquePesado(){
        return "Bicada Brutal : dano 1.5x";
    }

    @Override
    public String getNomeUltimate() {
        return "Graça da Plumagem : danoInimigo -20%";
    }


    @Override
    public Afinidade checarAfinidade(Terrenos terrenoAtual) {
        if (terrenoAtual == Terrenos.AQUATICO) {
            return Afinidade.VANTAGEM;
        } else if (terrenoAtual == Terrenos.AEREO) {
            return Afinidade.DESVANTAGEM;
        } else {
            return Afinidade.NEUTRO;
        }
    }


    @Override
    public void ataqueNormal(Aves defensor, Terrenos terrenoAtual) {

        int ataqueComBonus = this.getAtaqueModificado(terrenoAtual);
        int danoFinal = (int) (ataqueComBonus * 1.0);

        System.out.println(this.nome + " ataca no" + terrenoAtual + " Dano causado: " + danoFinal);

        defensor.receberDano(danoFinal);
    }


    @Override
    public void ataquePesado(Aves defensor, Terrenos terrenoAtual) {

        int ataqueComBonus = this.getAtaqueModificado(terrenoAtual);
        int danoFinal = (int) (ataqueComBonus * 1.5);

        if (terrenoAtual == Terrenos.AEREO) {
            danoFinal = (int) (danoFinal * 0.5);
            System.out.println(this.nome + " da uma bicada toda torda e causa metade de seu dano!");

        } else if (terrenoAtual == Terrenos.AQUATICO) {
            danoFinal = (int) (danoFinal * 1.5) + defensor.defesa;
            System.out.println(this.nome + " é esperiente no terreno " + terrenoAtual + ", e começou a prever os movimentos de: " + defensor.nome);
        } else {

            System.out.println(this.nome + " ataca  no terreno " + terrenoAtual + " Dano causado: " + danoFinal);

            defensor.receberDano(danoFinal);
        }
    }
    @Override
    public void ultimate(Aves defensor, Terrenos terrenoAtual){

        
        if (terrenoAtual == Terrenos.AQUATICO) {
            System.out.println(this.nome + " Usa sua suprema no terreno" + terrenoAtual + "!");
            System.out.println(this.nome + "CISNE ignora o inimigo, mostrando superioridade: \n");
            System.out.println("Ataque do " + defensor.nome + ": " + defensor.ataque + "\n");
            defensor.diminuirDano(defensor.ataque);
            System.out.println("Ataque atual do " + defensor.nome + ": " + defensor.ataque);
            int i = this.vida + defensor.ataque;
            this.vida = i;
        }
        else if (terrenoAtual == Terrenos.AEREO)
        {
            System.out.println(this.nome + "Tenta levantar vôo e cai graciosamente de cara no chão");
        }
        else
        {
            System.out.println("CISNE avalia: " + defensor.nome + " e o julga inferior");
            int i = this.vida + defensor.ataque;
            this.vida = i;
        }
    }
}


