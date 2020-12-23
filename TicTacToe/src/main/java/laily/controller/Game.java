// package et importation
package laily.controller;
import laily.model.Player;
import laily.model.Point;
import laily.view.IView;

// La classe jeu
public class Game {

    // je commence par arborer mon interface et mon controlleur
    final private IView iview;
    final private GameController gameController;

public Game(IView iview) {
    // J'implemente mon interface et mon controlleur blablabla
    this.iview = iview;
    this.gameController = iview.getGameController();
}

public void theGame() {
    // SUPER DUR
    // X* 1- je dois a chaque fois boucler les tour tant que je return true
    // O* 2- ok ok mollo molet je met l 'interface dans tes dents
    // O* 3- je crée le playeur et je le refract avec getplayeurs qui mdr doit index
    // O* 4- La je pointe comme lafouine EN FONCTION DU PLAYER donc on met en parametre dans le constructeur
    // O* 5- je montre le jeu  
    while (gameController.getNextTurn()) {
        Point point = iview.startTurn();
            Player currentPlayer = gameController.getCurrentPlayer(gameController.getPlayers()[0]);
            gameController.move(point.getX(), point.getY(), currentPlayer);
        iview.showBoard();
    }
    // SUPER DUR

    // no comment juste le flag
    if (gameController.getWinner() != null) {
        iview.showWinner();
        iview.anotherGame();
    } else {
        iview.showDraw();
        iview.anotherGame();
    }
}

// je recup les donné du controlleur pour le passer en conditionel
protected GameController getGameController() {
    return gameController;
}
}
