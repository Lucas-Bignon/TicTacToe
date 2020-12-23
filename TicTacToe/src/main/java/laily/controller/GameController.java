// -------------------------------
//  Le controlleur assez simple a comprendre dur a réaliser pas mal de tuto
//  
// -------------------




//package et importation
package laily.controller;
import laily.model.Board;
import laily.model.Figure;
import laily.model.Player;


// le controlleur de la classe jeu
public class GameController {

    // la totalité des variables requise pour le controle du constructeur
    private static final String GAME_NAME = "XO";
    private static final int FIRST_PLAYER = 0;
    private static final int SECOND_PLAYER = 1;
    private static final int DIAG_UP = 1;
    private static final int DIAG_DOWN = 0;
    private static final int DIAGS_FOR_CHECK = 2;
    private final String gameName;
    private final Player[] players;
    private final Board board;
    private final int boardLength;

    // le constructeur avec la totalité des fonction object
    // Seulement 3 parametre facilement iterable
    public GameController(final String gameName, final Player[] players, final Board board) {
        // je lui donne ses params
        this.gameName = gameName;
        this.board = board;
        this.players = players;
        this.boardLength = board.getFiguresArray().length;
    }
    // je retourne simplement le nom du jeu
    public String getGameName() {
        return gameName;
    }
    // je retourne les joueurs enregistré # load ?
    public Player[] getPlayers() {
        return players;
    }
     // remontre le tableau de jeu no delete
    public Board getBoard() {
        return board;
    }

    // Salut manu ou les formateur aujoudrd'hui on vas faire la fonction flag
    // a voir
    public Player getWinner() {
        for (Player playerForCheck : players) {
            String figureToCheck = playerForCheck.getFigure().toString();
            if (checkRowsForWin(figureToCheck) || checkLinesForWin(figureToCheck) || checkDiagsForWin(figureToCheck)) {
                return playerForCheck;
            }
        }
        return null;
    }


    // interdiction de mettre sur la même case
    public void move(final int x, final int y, final Player player) {
        if (board.getFigure(x, y) != null) {
            System.out.println("ERREUR MEME CASE GO RESET");
        } else {
            board.setFigure(x, y, player.getFigure());
        }
    }

        // donne le prochain tour extreme important
    public boolean getNextTurn() {
        final Figure[][] figures = getBoard().getFiguresArray();
        if (getWinner() != null) {
            return false;
        }
        for (Figure[] figureArray : figures) {
            for (Figure figureValue : figureArray) {
                if (figureValue == null) {
                    return true;
                }
            }
        }
        return false;
    }

        // pareille c'est la base refractoring a balle impossible a skip
    public Player getCurrentPlayer(final Player firstPlayer) {
        int firstPlayerNum = getFirstPlayerNum(firstPlayer);
        int[] playersTurns = getPlayersTurns();

        if (playersTurns[FIRST_PLAYER] == playersTurns[SECOND_PLAYER]) {
            return players[firstPlayerNum];
        } else if (firstPlayerNum == FIRST_PLAYER) {
            return players[SECOND_PLAYER];
        } else {
            return players[FIRST_PLAYER];
        }
    }

    // sa check a balle en fonction des colonne whaaa du refract a baalle
    private boolean checkLinesForWin(final String playerFigure) {
        for (int row = 0; row < boardLength; row++) {
            if (getPlayerForLine(row, playerFigure) == boardLength) {
                return true;
            }
        }
        return false;
    }

        // sa test la win go test null c mort check de win core
    private boolean checkRowsForWin(final String playerFigure) {
        for (int column = 0; column < boardLength; column++) {
            if (getPlayerForColumn(column, playerFigure) == boardLength) {
                return true;
            }
        }
        return false;
    }
    // ez pas de check pas de win
    private boolean checkDiagsForWin(final String playerFigure) {
        for (int diag_direction = 0; diag_direction < DIAGS_FOR_CHECK; diag_direction++) {
            if (getPlayerForDiag(diag_direction, playerFigure) == boardLength) {
                return true;
            }
        }
        return false;
    }

    private int getPlayerForDiag(final int direction, final String playerFigure) {
        int playerDiagCount = 0;
        if (direction == DIAG_UP) {
            for (int i = 0; i < boardLength; i++) {
                if ((board.getFigure(i, i) != null)) {
                    playerDiagCount++;
                }
            }
        }
        if (direction == DIAG_DOWN) {
            for (int i = 0; i < boardLength; i++) {
                int row = (boardLength - 1) - i;
                if ((board.getFigure(row, i) != null)) {
                    playerDiagCount++;
                }
            }
        }
        return playerDiagCount;
    }

    private int getPlayerForColumn(final int column, final String playerFigure) {
        int playerColumnCount = 0;
        for (int i = 0; i < boardLength; i++) {
            if ((board.getFigure(i, column) != null)) {
                playerColumnCount++;
            }
        }
        return playerColumnCount;
    }

    private int[] getPlayersTurns() {
        int[] playersTurns = new int[players.length];
        for (int playerNum = 0; playerNum < players.length; playerNum++) {
            playersTurns[playerNum] = getPlayerForBoard(players[playerNum].getFigure().toString());
        }
        return playersTurns;
    }

    private int getPlayerForBoard(final String playerFigure) {
        int playerBoardCount = 0;
        for (int i = 0; i < boardLength; i++) {
            playerBoardCount += getPlayerForLine(i, playerFigure);
        }
        return playerBoardCount;
    }

    private int getPlayerForLine(final int row, final String playerFigure) {
        int playerRowCount = 0;
        for (int i = 0; i < board.getRowLength(row); i++) {
            if ((board.getFigure(row, i) != null) && equalsFigures(row, i, playerFigure)) {
                playerRowCount++;
            }
        }
        return playerRowCount;
    }

    private int getFirstPlayerNum(final Player firstPlayer) {
        int firstPlayerPositionNum = 0;
        for (int num = 0; num < players.length; num++) {
            if (players[num] == firstPlayer) {
                firstPlayerPositionNum = num;
            }
        }
        return firstPlayerPositionNum;
    }

    private boolean equalsFigures(final int x, final int y, final String playerFigure) {
        return board.getFigure(x, y).toString().equals(playerFigure);
    }
}
