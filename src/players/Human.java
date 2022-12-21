package players;

import java.util.Scanner;

public class Human extends Players {


    public Human(Character symbol) {
        super(symbol);
    }

    @Override
    public void doStep(Character[][] field) {
        Scanner scanner = new Scanner(System.in);
        boolean moveEnd = false;
        while (!moveEnd) {

            switch (scanner.nextInt()) {
                case 1 -> {
                    if (checkCell(field, 0, 0)) {
                        field[0][0] = getSymbol();
                        moveEnd = true;
                    }
 }
                case 2 -> {
                    if (checkCell(field, 0, 1)) {
                        field[0][1] = getSymbol();
                        moveEnd = true;
                    }
                }
                case 3 -> {
                    if (checkCell(field, 0, 2)) {
                        field[0][2] = getSymbol();
                        moveEnd = true;
                    }
                }
                case 4 -> {
                    if (checkCell(field, 1, 0)) {
                        field[1][0] = getSymbol();
                        moveEnd = true;
                    }
                }
                case 5 -> {
                    if (checkCell(field, 1, 1)) {
                        field[1][1] = getSymbol();
                        moveEnd = true;
                    }
                }
                case 6 -> {
                    if (checkCell(field, 1, 2)) {
                        field[1][2] = getSymbol();
                        moveEnd = true;
                    }
                }
                case 7 -> {
                    if (checkCell(field, 2, 0)) {
                        field[2][0] = getSymbol();
                        moveEnd = true;
                    }
                }
                case 8 -> {
                    if (checkCell(field, 2, 1)) {
                        field[2][1] = getSymbol();
                        moveEnd = true;
                    }
                }
                case 9 -> {
                    if (checkCell(field, 2, 2)) {
                        field[2][2] = getSymbol();
                        moveEnd = true;
                    }
                }

                default -> System.out.println("Недопустимая ячейка повторите ввод");
            }
        }
    }

    @Override
    public String toString() {
        return "Human";
    }

}
