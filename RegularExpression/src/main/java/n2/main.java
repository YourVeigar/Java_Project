package n2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt", true));

        RegExp regularExpression = new RegExp(6);
        regularExpression.fileWrite(writer, "RE 1 = " + regularExpression.str);
        RegExp regularExpression1 = new RegExp(8);
        regularExpression.fileWrite(writer, "RE 2 = " + regularExpression1.str);
        RegExp regularExpression2 = new RegExp(5);
        regularExpression.fileWrite(writer, "RE 3 = " + regularExpression2.str);
        RegExp regularExpression3 = new RegExp(9);
        regularExpression.fileWrite(writer, "RE 4 = " + regularExpression3.str);
        RegExp regularExpression4 = new RegExp(7);
        regularExpression.fileWrite(writer, "RE 5 = " + regularExpression4.str);
        RegExp regularExpression5 = new RegExp(10);
        regularExpression.fileWrite(writer, "RE 6 = " + regularExpression5.str);
        RegExp regularExpression6 = new RegExp(12);
        regularExpression.fileWrite(writer, "RE 7 = " + regularExpression6.str);

        writer.write("\n");
        writer.close();
    }
}
