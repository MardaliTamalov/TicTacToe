package players;

import java.util.Random;

public class Computer extends Players {
    boolean endStep = false;

    public Computer(Character symbol) {
        super(symbol);
    }

    @Override
    public void doStep(Character[][] field) {
        if (!endStep) {
            firstStep(field);
        }
        if (!endStep) {
            checkWinLose (field);
        }
        if (!endStep) {
            randomMove(field);
        }
        endStep = false;
    }
private void checkWinLose(Character[][] field){
        Character x = getSymbol();

        for (int i=0;i<2;i++){
            if(!endStep) {
                checkPossibilityWinLose(field, x,getSymbol());
            }
            if (x == 'X')
                x = 'O';
            else
                x='X';
        }
}

    private void checkPossibilityWinLose(Character[][] field, Character x, Character y) {
      if (field[0][0] == null) {
            if (field[0][1] == x  && field[0][2] == x || field[1][0] == x && field[2][0] == x || field[1][1] == x && field[2][2] == x) {
                field[0][0] = y;
                endStep=true;
                return;
            }
        }
        if (field[0][1] == null) {
            if (field[0][0] == x && field[0][2] == x || field[1][1] == x && field[2][1] == x) {
                field[0][1] = y;
                endStep=true;
                return;
            }
        }
        if (field[0][2] == null) {
            if (field[0][0] == x && field[0][1] == x || field[1][2] == x && field[2][2] == x ||
                    field[2][0] == x && field[1][1] == x) {
                field[0][2] = y;
                endStep=true;
                return;
            }
        }
        if (field[1][0] == null) {
            if (field[0][0] == x && field[2][0] == x || field[1][1] == x && field[1][2] == x) {
                field[1][0] = y;
                endStep=true;
                return;
            }
        }
        if (field[1][1] == null) {
            if (field[0][0] == x && field[2][2] == x || field[0][2] == x && field[2][0] == x ||
                    field[1][0] == x && field[1][2] == x || field[0][1] == x && field[2][1] == x) {
                field[1][1] = y;
                endStep=true;
                return;
            }
        }
        if (field[1][2] == null) {
            if (field[0][2] == x && field[2][2] == x || field[1][0] == x && field[1][1] == x) {
                field[1][2] = y;
                endStep=true;
                return;
            }
        }
        if (field[2][0] == null) {
            if (field[0][0] == x && field[1][0] == x || field[2][1] == x && field[2][2] == x ||
                    field[0][2] == x && field[1][1] == x) {
                field[2][0] = y;
                endStep=true;
                return;
            }
        }
        if (field[2][1] == null) {
            if (field[2][0] == x && field[2][2] == x || field[0][1] == x && field[1][1] == x) {
                field[2][1] = y;
                endStep=true;
                return;
            }
        }
        if (field[2][2] == null) {
            if (field[0][2] == x && field[1][2] == x || field[2][0] == x && field[2][1] == x
                    || field[0][0] == x && field[1][1] == x) {
                field[2][2] = y;
                endStep=true;
            }
        }
    }

    private void firstStep(Character[][] field) {
        if (field[1][1] == null) {
            field[1][1] = getSymbol();
            endStep = true;
        }
    }

    private void randomMove(Character[][] field) {
        Random random = new Random();
        while (!endStep) {
            int x = random.nextInt(3);
            int y = random.nextInt(3);
            if (field[x][y] == null) {
                field[x][y] = getSymbol();
                endStep = true;
            }
        }
    }

    @Override
    public String toString() {
        return "Computer";
    }
}
