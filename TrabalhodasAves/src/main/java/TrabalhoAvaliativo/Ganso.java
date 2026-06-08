package TrabalhoAvaliativo;

public class Ganso extends Aves implements  Ataques{

    public Ganso(){

        this.nome = "PATO GANSO ";
        this.vida = 550;
        this.ataque = 30;
        this.defesa = 25;
        this.velocidade = 50;

        System.out.println("Criando um " + this.nome);
        System.out.println(this.vida + " de vida");
        System.out.println(this.ataque + " de ataque");
        System.out.println(this.defesa + " de defesa");
        System.out.println(this.velocidade + " de velocidade");
        System.out.println("======== Interações com o terreno ========");
        System.out.println("Terreno vantajoso: " + Terrenos.TERRESTRE);
        System.out.println("Terreno neutro: " + Terrenos.AQUATICO);
        System.out.println("Terreno Ruim: " + Terrenos.AEREO + "\n");

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
        return "Furia do Parquinho: dano 2.5x(Sacrifica 20% do hp)";
    }


        @Override
        public Afinidade checarAfinidade(Terrenos terrenoAtual) {
            if (terrenoAtual == Terrenos.AQUATICO) {
                return Afinidade.NEUTRO;
            } else if (terrenoAtual == Terrenos.AEREO) {
                return Afinidade.DESVANTAGEM;
            } else {
                return Afinidade.VANTAGEM;
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
                danoFinal = danoFinal / 2;
                System.out.println(this.nome + " da uma bicada toda torda e causa metade de seu dano!");

            } else if (terrenoAtual == Terrenos.TERRESTRE) {
                danoFinal = (int) (danoFinal * 1.2);
                System.out.println(this.nome + " é esperiente no terreno " + terrenoAtual + " e seu dano foi um pouco amplificado");
            }

                System.out.println(this.nome + " ataca  no terreno " + terrenoAtual + " Dano causado: " + danoFinal);

                defensor.receberDano(danoFinal);

        }
        @Override
        public void ultimate(Aves defensor, Terrenos terrenoAtual){

        int ataqueComBonus = this.getAtaqueModificado(terrenoAtual);
        int danoFinal = (int) (ataqueComBonus * 2.5);
        this.vida = (int) (vida * 0.8);

        if (terrenoAtual == Terrenos.AEREO){
            danoFinal = 0;
            this.vida = (int) (vida * 0.95);
            System.out.println(this.nome + " Usa sua suprema no terreno" + terrenoAtual + "!");
            System.out.println(this.nome + " esta perdido e não sabe oque fazer");
            System.out.println(this.nome + "Errou o alvo e se bateu no processo perdendo vida");

        } else if (terrenoAtual == Terrenos.TERRESTRE){
            danoFinal = (int) (danoFinal * 3.0);
            this.vida = (int) (vida * 0.90);
            System.out.println(this.nome + " faz o ataque de forma exemplar e toma menos dano que o normal");
            System.out.println(this.nome + " vida atual " + this.vida);
        } else {

            System.out.println(this.nome + " Usa sua suprema no terreno " + terrenoAtual + "!");
            System.out.println(this.nome + "Sacrifica metade de sua vida atual: " + this.vida);
            System.out.println("O dano causado no pato inimigo foi de: " + danoFinal);
        }

        defensor.receberDano(danoFinal);
        }
}


