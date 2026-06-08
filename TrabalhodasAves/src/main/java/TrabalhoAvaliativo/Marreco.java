package TrabalhoAvaliativo;

public class Marreco extends Aves implements Ataques{
    
    public Marreco(){
        this.nome = "PATO MARRECO ";
        this.vida = 400;
        this.ataque = 55;
        this.defesa = 20;
        this.velocidade = 70;

        System.out.println("Criando um " + this.nome);
        System.out.println(this.vida + " de vida");
        System.out.println(this.ataque + " de ataque");
        System.out.println(this.defesa + " de defesa");
        System.out.println(this.velocidade + " de velocidade");
        System.out.println("======== Interações com o terreno ========");
        System.out.println("Terreno vantajoso: " + Terrenos.AEREO);
        System.out.println("Terreno neutro: " + Terrenos.TERRESTRE);
        System.out.println("Terreno Ruim: " + Terrenos.AQUATICO + "\n");
    }
    @Override
    public String getNomeAtaqueNormal(){
        return "Bicada veloz : dano 1x";
    }

    @Override
    public String getNomeAtaquePesado(){
        return "Corte de asa : dano 1.5x";
    }

    @Override
    public String getNomeUltimate() {
        return "Rasantes Multiplos : 1 golpe basico garantido, 50% de chances de 2 golpes, 12.5% 3 golpes e 1.56% de 4 golpes. CUIDADO: Golpes em alta velocidade machucam.";
    }

    @Override
        public Afinidade checarAfinidade(Terrenos terrenoAtual) {
            if (terrenoAtual == Terrenos.AEREO) {
                return Afinidade.VANTAGEM;
            } else if (terrenoAtual == Terrenos.AQUATICO) {
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
        public void ataquePesado(Aves defensor, Terrenos terrenoAtual){

            int ataqueComBonus = this.getAtaqueModificado(terrenoAtual);
            int danoFinal = (int) (ataqueComBonus * 1.5);

            if(terrenoAtual == Terrenos.AQUATICO){
                danoFinal = danoFinal / 3;
                System.out.println("O Marreco tentou atacar com suas asas, mas perdeu o equilibrio e quase se afogou! Seu golpe arranhou um pouco o alvo.");

            } else if(terrenoAtual == Terrenos.AEREO){
                danoFinal = (int) (danoFinal * 1.5);
                System.out.println( this.nome + " é especialista em aeronautica e teve seu poder amplificado!");
            }

                System.out.println(this.nome + " ataca  no terreno " + terrenoAtual + " Dano causado: " + danoFinal);

                defensor.receberDano(danoFinal);
        }

        @Override
        public void ultimate(Aves defensor, Terrenos terrenoAtual){

        int ataqueComBonus = this.getAtaqueModificado(terrenoAtual);
        int danoFinal = (int) (ataqueComBonus);
        int chances = (int)(Math.random() * 2) + 1;

            System.out.println(this.nome + " Usa sua suprema no terreno" + terrenoAtual + "!");
            System.out.println(this.nome + "Dá seu golpe garantido!");
            danoFinal += ataqueComBonus;
            if(chances == 1){
                System.out.println(this.nome + " errou o segundo ataque. Azar ou  livramento?"); 
            } else if(chances == 2){
                danoFinal += ataqueComBonus;
                this.vida += -25;
                System.out.println(this.nome + " acertou o segundo golpe, causando " + ataqueComBonus + " de dano e recebeu 25 de dano.");
                chances = (int)(Math.random() * 4) + 1;
                if(chances != 1){
                    System.out.println(this.nome + " errou o terceiro golpe... Às vezes é melhor assim.");
                } else if(chances == 1){
                    danoFinal += ataqueComBonus;
                    this.vida += -25;
                    System.out.println(this.nome + " acertou o terceiro golpe, causando " + ataqueComBonus + " de dano e recebeu 25 de dano.");
                    chances = (int)(Math.random() * 8) + 1;
                    if(chances != 1){
                        System.out.println(this.nome + " errou o quarto golpe. Eu diria que está tudo bem.");
                    } else if(chances == 1){
                        danoFinal += ataqueComBonus;
                        this.vida += -50;
                        System.out.println(this.nome + " acertou o quarto golpe, causando " + ataqueComBonus + " de dano e recebeu 50 de dano... ouch...");
                    }
                }
            }
            System.out.println("O dano causado no pato inimigo foi de: " + danoFinal);

        defensor.receberDano(danoFinal);
        }

}
