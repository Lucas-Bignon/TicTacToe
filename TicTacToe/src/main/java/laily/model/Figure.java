package laily.model;

// fait tout seul j'enum car sa m'évite de faire des ligne donc je refract et derriere j override
// pourquoi j override ? bah debug^^ faut forcer de réecrire le param et le recup
// un peus un force push git
public enum Figure {

    X("X"), O("O");

    private final String figure;

    private Figure(final String figureName){
        figure = figureName;
    }

    @Override
    public String toString() {
        return figure;
    }

}
