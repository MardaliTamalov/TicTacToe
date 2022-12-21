package game;

import players.Computer;
import players.Human;
import players.Players;

import java.util.Random;

public class GameProcess {
    private Character[][] field = new Character[3][3];
    private Players [] players;

    public void startGame() {
        showStartInfo();
        scheduling();
        while (true) {
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
            players= new Players[]{new Human('X'), new Computer('O')};
        } else {
            System.out.println("Вы ходите ноликами!");
            players= new Players[]{new Computer('X'), new Human('O')};
        }
    }

    private void nextStep(){

        for (Players player: players){
            System.out.println("ходит " + player);
            player.doStep(field);
            showField();
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
