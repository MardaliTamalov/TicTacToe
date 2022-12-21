package players;

public abstract class Players {
    private final Character symbol;

    public Players(Character symbol) {
        this.symbol = symbol;
    }
    public Character getSymbol() {
        return symbol;
    }

    public abstract void doStep(Character[][] field);

    public boolean checkCell(Character[][] field,int x, int y){
        if (this instanceof Human && field[x][y]!=null ){
            System.out.println("ячейка занята. Повторите ввод!");
        }
        return field[x][y]==null;
    }
    }
