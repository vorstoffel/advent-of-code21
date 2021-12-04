package adventofcode2021.models;

public class BingoField {
    int number;
    boolean marked;

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }

    public boolean isMarked() {
        return marked;
    }
}
