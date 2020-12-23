package laily.view;

import laily.controller.GameController;
import laily.model.Point;

public interface IView {

    public Point startTurn();

    public void showGameName();

    public void showPlayers();

    public void showBoard();

    public void showWinner();

    public void showDraw();

    public void anotherGame();

    public void showPointOccupied();

    public GameController getGameController();

}
