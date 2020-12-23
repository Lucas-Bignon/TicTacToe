package laily.model;

public class Board {
    private static final int SIZE = 3;
    private final Figure[][] figures;

    public Board(){
        this(SIZE);
    }

    public Board(final int customBoardSize){
            this.figures = new Figure[SIZE][SIZE];
    }

    public void setFigure(final int x, final int y, final Figure figure){
        if (checkCoordinates(x, y)) {
            figures[x][y] = figure;
        }
        else {
            System.out.println("error");
        }
    }

    public Figure getFigure(final int x, final int y){
        if (checkCoordinates(x, y)) {
            return figures[x][y];
        }
        else {
            System.out.println("error");
            return figures[x][y];
        }
    }

    public Figure[][] getFiguresArray() {
            return figures;
    }

    public int getRowLength(final int row) {
        return figures[row].length;
    }

    private boolean checkCoordinates(final int x, final int y){
        return (checkCoordinate(x) && checkCoordinate(y));
    }

    public boolean checkCoordinate(final int coordinate) {
        return (coordinate >= 0 && coordinate <= figures.length - 1);
    }

}