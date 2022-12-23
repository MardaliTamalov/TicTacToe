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
            checkWin(field);
        }
        if (!endStep){
            checkLose(field);
        }
        if (!endStep) {
            randomMove(field);
        }
        endStep = false;
    }

    private void checkWin(Character[][] field) {
        Character x = getSymbol();
        if (field[0][1] == x && field[0][2] == x || field[1][0] == x && field[2][0] == x ||
                field[1][1] == x && field[2][2] == x) {
            if (field[0][0] == null) {
                field[0][0] = x;
                endStep = true;
            }
        }
        if (field[0][0] == x && field[0][2] == x || field[1][1] == x && field[2][1] == x) {
            if (field[0][1] == null) {
                field[0][1] = x;
                endStep = true;
            }
        }
        if (field[0][0] == x && field[0][1] == x || field[1][2] == x && field[2][2] == x ||
                field[2][0] == x && field[1][1] == x) {
            if (field[0][2] == null) {
                field[0][2] = x;
                endStep = true;
            }
        }
        if (field[0][0] == x && field[2][0] == x || field[1][1] == x && field[1][2] == x) {
            if (field[1][0] == null) {
                field[1][0] = x;
                endStep = true;
            }
        }
        if (field[0][0] == x && field[2][2] == x || field[0][2] == x && field[2][0] == x ||
                field[1][0] == x && field[1][2] == x || field[0][1] == x && field[2][1] == x) {
            if (field[1][1] == null) {
                field[1][1] = x;
                endStep = true;
            }
        }
        if (field[0][2] == x && field[2][2] == x || field[1][0] == x && field[1][1] == x) {
            if (field[1][2] == null) {
                field[1][2] = x;
                endStep = true;
            }
        }
        if (field[0][0] == x && field[1][0] == x || field[2][1] == x && field[2][2] == x ||
                field[0][2] == x && field[1][1] == x) {
            if (field[2][0] == null) {
                field[2][0] = x;
                endStep = true;
            }
        }
        if (field[2][0] == x && field[2][2] == x || field[0][1] == x && field[1][1] == x) {
            if (field[2][1] == null) {
                field[2][1] = x;
                endStep = true;
            }
        }
        if (field[0][2] == x && field[1][2] == x || field[2][0] == x && field[2][1] == x
                || field[0][0] == x && field[1][1] == x) {
            if (field[2][2] == null) {
                field[2][2] = x;
                endStep = true;
            }
        }
    }

    private void checkLose(Character[][] field) {
        Character x = 'X';
        if (getSymbol() == 'X') {
            x = 'O';
        }
        if (field[0][1] == x && field[0][2] == x || field[1][0] == x && field[2][0] == x ||
                field[1][1] == x && field[2][2] == x) {
            if (field[0][0] == null) {
                field[0][0] = getSymbol();
                endStep = true;
            }
        }
        if (field[0][0] == x && field[0][2] == x || field[1][1] == x && field[2][1] == x) {
            if (field[0][1] == null) {
                field[0][1] =getSymbol();
                endStep = true;
            }
        }
        if (field[0][0] == x && field[0][1] == x || field[1][2] == x && field[2][2] == x ||
                field[2][0] == x && field[1][1] == x) {
            if (field[0][2] == null) {
                field[0][2] = getSymbol();
                endStep = true;
            }
        }
        if (field[0][0] == x && field[2][0] == x || field[1][1] == x && field[1][2] == x) {
            if (field[1][0] == null) {
                field[1][0] = getSymbol();
                endStep = true;
            }
        }
        if (field[0][0] == x && field[2][2] == x || field[0][2] == x && field[2][0] == x ||
                field[1][0] == x && field[1][2] == x || field[0][1] == x && field[2][1] == x) {
            if (field[1][1] == null) {
                field[1][1] = getSymbol();
                endStep = true;
            }
        }
        if (field[0][2] == x && field[2][2] == x || field[1][0] == x && field[1][1] == x) {
            if (field[1][2] == null) {
                field[1][2] = getSymbol();
                endStep = true;
            }
        }
        if (field[0][0] == x && field[1][0] == x || field[2][1] == x && field[2][2] == x ||
                field[0][2] == x && field[1][1] == x) {
            if (field[2][0] == null) {
                field[2][0] =getSymbol();
                endStep = true;
            }
        }
        if (field[2][0] == x && field[2][2] == x || field[0][1] == x && field[1][1] == x) {
            if (field[2][1] == null) {
                field[2][1] = getSymbol();
                endStep = true;
            }
        }
        if (field[0][2] == x && field[1][2] == x || field[2][0] == x && field[2][1] == x
                || field[0][0] == x && field[1][1] == x) {
            if (field[2][2] == null) {
                field[2][2] = getSymbol();
                endStep = true;
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
            if (field[x][y]==null) {
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
