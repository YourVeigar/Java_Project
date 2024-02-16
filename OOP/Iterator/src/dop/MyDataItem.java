package dop;

public class MyDataItem {
    String[] figures;
    int a;
    double b;
    char c;

    public MyDataItem(String[] figures, int a, double b, char c) {
        this.figures = figures;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String getFigures() {
        String str = "";
        for(int i = 0; i < figures.length; i++) {
            str += figures[i];
            str += " ";
        }
        return str;
    }

    public int getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public char getC() {
        return c;
    }
}
