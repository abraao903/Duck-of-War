package TrabalhoAvaliativo;

public enum Afinidade {

    VANTAGEM(1.5),
    NEUTRO(1.0),
    DESVANTAGEM(0.7);

    private final double multiplicador;

    Afinidade(double multiplicador){
        this.multiplicador = multiplicador;
    }

    public double getMultiplicador(){
        return multiplicador;
    }

}
