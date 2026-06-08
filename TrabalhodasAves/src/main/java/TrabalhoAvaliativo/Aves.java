package TrabalhoAvaliativo;

public abstract class Aves {

    protected String nome;
    protected int vida, ataque, defesa, velocidade;


    public abstract String getNomeAtaqueNormal();
    public abstract String getNomeAtaquePesado();
    public abstract String getNomeUltimate();

    public abstract Afinidade checarAfinidade(Terrenos terrenoAtual);

    public int getAtaqueModificado(Terrenos terrenoAtual){
        Afinidade afinidade = this.checarAfinidade(terrenoAtual);
        return (int) (this.ataque * afinidade.getMultiplicador());
    }


    public void receberDano(int danoBruto){

        int danoFinal = danoBruto - (this.defesa);
        if (danoFinal < 1) danoFinal = 0;

        this.vida -= danoFinal;
        System.out.println(this.nome + " perdeu " + danoFinal + " de vida ");

    }

    public void diminuirDano(int ataqueInimigo)
    {
        int ataquePos = (int) (ataqueInimigo * 0.8);
        this.ataque = ataquePos;
    }

}
