package laily.view;


import java.util.InputMismatchException;
import java.util.Scanner;

import laily.controller.GameController;
import laily.model.Player;
import laily.model.Point;

public class ConsoleView implements IView {

    private static final String CHARACTER_HYPHEN = "~";

    private static final String EMPTY_FIGURE = " ";

    private static final String INPUT_ERROR = "Incorrect input, please try again";

    protected final GameController game;

    public ConsoleView(final GameController game) {
        assert game != null;
        this.game = game;
    }

    public GameController getGameController(){
        return game;
    }
// IMPORTANT
    public Point startTurn() {
        System.out.println("Prochain tour !");
        return new Point(getCoordinate(),getCoordinate());
    }

    public  void showGameName() {
        System.out.println(game.getGameName());
    }

    public void showPlayers() {
         for (Player player : game.getPlayers()) {
             System.out.println(player.getName() + ": " + player.getFigure().toString());
         }
    }

    public void showBoard() {
        int lineSize = game.getBoard().getFiguresArray().length;
        for (int i = 0 ; i < lineSize; i++) {
            showBoardLine(i);
            printLine(CHARACTER_HYPHEN, lineSize);
        }
    }

    public void  showWinner(){
        System.out.println("Le gagnant est : " + game.getWinner().getName());
    }

    public void showDraw(){
        System.out.println("Encore une égalité !");
    }

    public void showPointOccupied(){
        System.out.println("Tu peus pas mettre dans la case d un autre :(");
    }

    public void anotherGame() {
        System.out.println("(switch XOR) on rejoue ? oui/non");
            final Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();
            switch (choice) {
                case "oui":
                    ConsoleMenuView.showMenuWithResult();
                    break;
                case "non":
                    System.out.println("Salut le sang ! repasse me voir ;)");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Faut juste entrer oui ou non ^^");
                    anotherGame();
                    break;
            }
        }

    private void printLine(final String lineCharacter, final int lineSize) {
        for (int i = 0; i < lineSize; i++) {
            System.out.print(lineCharacter);
        }
        System.out.println();
    }

    private void showBoardLine(final int row)  {
        for (int i = 0; i < game.getBoard().getRowLength(row); i++) {
                if (game.getBoard().getFigure(row, i) == null) {
                    System.out.print(EMPTY_FIGURE);
                } else {
                    System.out.print(game.getBoard().getFigure(row, i).toString());
                }
        }
        System.out.println();
    }

    protected int getCoordinate() {
        while (true) {
            System.out.print("Envoie la position x (ENTER) y (ENTER)");
            try {
                final Scanner in = new Scanner(System.in);
                    int coordinate = in.nextInt() - 1;
                    if (game.getBoard().checkCoordinate(coordinate)) {
                        return coordinate;
                    }
                    else {
                        System.out.println(INPUT_ERROR);
                    }
            }
            catch (final InputMismatchException e) {
                System.out.println(INPUT_ERROR);
                }
            }

    }

}
