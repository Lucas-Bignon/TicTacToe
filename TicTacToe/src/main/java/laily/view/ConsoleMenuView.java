package laily.view;

import java.util.Scanner;

import laily.controller.Game;
import laily.controller.GameStarter;

public class ConsoleMenuView {

    private static final int START_CODE = 1;

    //private static final int LOAD_CODE = 2;

    //private static final int SETTINGS_CODE = 3;

    private static final int EXIT_CODE = 4;

   // private static int BOARD_SIZE;

    //private static final int MIN_SIZE = 3;

    public static void showMenuWithResult() {

        System.out.println("Le morpion chuis trop content");
        System.out.println(START_CODE + " - Tu veux jouer :)");
       // System.out.println(LOAD_CODE + " - Load");
       // System.out.println(SETTINGS_CODE + " - Set up and play");
        System.out.println(EXIT_CODE + " - Exit");
        System.out.print("> ");
            final Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case START_CODE:
                    System.out.println("C'est partie !");
                    GameStarter.defaultStart().theGame();
                    break;
               // case LOAD_CODE:
                //    System.out.println("Loading...");
                    //TODO
                  //  break;
                //case SETTINGS_CODE:
                  //  customInput().theGame();
                  //  break;
                case EXIT_CODE:
                    System.out.println("Bye bye");
                    break;
                default:
                    System.out.println("Mon switch indique une erreur ptit malin");
                    showMenuWithResult();
                    break;
            }
        }

    protected static Game customInput() {
        //Scanner input = new Scanner(System.in);
        //final String gameName = "XO";
        //System.out.println("Enter player one name:");
        //String playerOneName = input.nextLine();
        //System.out.println("Enter player two name:");
        //String playerTwoName = input.nextLine();
        //final int boardSize = enterSize();
        //return GameStarter.customStart(boardSize,playerOneName,playerTwoName, gameName);
    return null;
    }

    protected static int enterSize(){
       // Scanner input = new Scanner(System.in);
       //     System.out.println("Enter board size:");
       //     BOARD_SIZE = input.nextInt();
       // return BOARD_SIZE;
       return 3;
    }

}
