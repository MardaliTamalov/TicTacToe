package players;

import java.util.Random;

public class Computer extends Players {

    public Computer(Character symbol) {
        super(symbol);
    }

    @Override
    public void doStep(Character[][] field) {
        if (field[1][1] == null) {
            field[1][1] = getSymbol();
        }
        Random random = new Random();
        boolean endMove=false;

        while (!endMove) {
            int x = random.nextInt(3);
            int y = random.nextInt(3);
            if (checkCell(field,x,y)) {
                field[x][y] = getSymbol();
                endMove = true;
            }
        }
    }

    @Override
    public String toString() {
        return "Computer";
    }
}
