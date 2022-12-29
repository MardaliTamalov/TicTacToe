package game;

import players.Computer;
import players.Human;
import players.Players;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class GameProcess {
    private Character[][] field = new Character[3][3];
    private Players[] players;
    private boolean endGame;

    public void startGame() {
        showStartInfo();
        scheduling();
        while (!endGame) {
            nextStep();
        }
    }

    /**
     * отображение стартовой информации у игрового поля
     */
    private void showStartInfo() {

        for (int i = 1; i <= 9; i++) {
            System.out.print("[" + i + "]");
            if (i % 3 == 0) {
                System.out.println();
            }
        }
//        Stream.iterate(1,x-> x+1)
//                .limit(9)
//                .peek(x-> {
//                    if((x-1)% 3==0){
//                        System.out.println();
//                    }
//                }).forEach(x->System.out.print("[" + x + "]"));

    }

    /**
     * определение очередности
     */
    private void scheduling() {
        Random random = new Random();

        if (random.nextBoolean()) {
            System.out.println("Вы ходите крестиками!");
            players = new Players[]{new Human('X'), new Computer('O')};
        } else {
            System.out.println("Вы ходите ноликами!");
            players = new Players[]{new Computer('X'), new Human('O')};
        }
    }

    private void nextStep() {
        for (Players player : players) {
            if (!endGame) {
                System.out.println("ходит " + player);
                player.doStep(field);
                showField();
                checkEndGame(player);
            }
        }
    }

    private void checkEndGame(Players player) {
        checkWin(player);
        if (!endGame) {
            checkDraw();
        }
    }

    private void checkWin(Players player) {
        Character x = player.getSymbol();
        for (int i = 0; i < field.length; i++) {
            if (field[i][0] == x && field[i][1] == x && field[i][2] == x
                    || field[0][i] == x && field[1][i] == x && field[2][i] == x) {
                System.out.println("Игра окончена. " + player + " победил!");
                endGame = true;
            } else if (field[0][0] == x && field[1][1] == x && field[2][2] == x
                    || field[0][2] == x && field[1][1] == x && field[2][0] == x){
                System.out.println("Игра окончена. " + player + " победил!");
            endGame = true;
            return;
        }
    }
    }
//            if(    field[0][0] == x && field[0][1] == x && field[0][2] == x
//                || field[1][0] == x && field[1][1] == x && field[1][2] == x
//                || field[2][0] == x && field[2][1] == x && field[2][2] == x
//                || field[0][0] == x && field[1][0] == x && field[2][0] == x
//                || field[0][1] == x && field[1][1] == x && field[2][1] == x
//                || field[0][2] == x && field[1][2] == x && field[2][2] == x

//                || field[0][0] == x && field[1][1] == x && field[2][2] == x
//                || field[0][2] == x && field[1][1] == x && field[2][0] == x) {
//            System.out.println("Игра окончена. "+ player+" победил!");
//            endGame=true;
//        }
//    }

    private void checkDraw() {
        if (Arrays.stream(field)
                .flatMap(Arrays::stream)
                .allMatch(Objects::nonNull)) {
            System.out.println("Ничья");
            endGame = true;
        }
    }

    /**
     *
     */
    private void showField() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == null) {
                    System.out.print("[ ]");
                } else {
                    System.out.print("[" + field[i][j] + "]");
                }
            }
            System.out.println();
        }
    }


}
