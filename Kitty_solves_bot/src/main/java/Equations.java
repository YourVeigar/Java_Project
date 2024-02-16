public class Equations {

    static Bot bot = new Bot();

    public void varvar1 (Long id, String digits) {
        String[] digit = digits.split(" ");
        double a = Double.parseDouble(digit[0]);
        double b = Double.parseDouble(digit[1]);
        double c = Double.parseDouble(digit[2]);
        double n = Double.parseDouble(digit[3]);
        double x = Double.parseDouble(digit[4]);

        double one = 5 * Math.pow(a, n*x);
        double two = b + c;
        double three = Math.sqrt(Math.abs(Math.cos(Math.pow(x, 3))));

        bot.sendText(id, Double.toString(one/two - three));

    }

    public  void varvar2(Long id, String digits) {

        String[] digit = digits.split(" ");
        double a = Double.parseDouble(digit[0]);
        double x = Double.parseDouble(digit[1]);
        double y = Double.parseDouble(digit[2]);
        double w = Double.parseDouble(digit[3]);

        double one = Math.abs(x - y);
        double two = Math.pow((1 + 2*x), a);
        double three = Math.exp(Math.sqrt(1 + w));
        double otv = one/two - three;

        bot.sendText(id, Double.toString(otv));
    }

    public  void varvar3 (Long id, String digits) {

        String[] digit = digits.split(" ");
        double a0 = Double.parseDouble(digit[0]);
        double a1 = Double.parseDouble(digit[1]);
        double a2 = Double.parseDouble(digit[2]);
        double x = Double.parseDouble(digit[3]);

        double one = a0 + a1*x;
        double two = a2 * Math.pow(Math.abs(Math.sin(x)), 1/3.0);

        bot.sendText(id, Double.toString(Math.sqrt(one + two)));
    }

    public  void varvar4 (Long id, String digits) {

        String[] digit = digits.split(" ");
        double a = Double.parseDouble(digit[0]);
        double x = Double.parseDouble(digit[1]);

        double one = Math.log(Math.abs(Math.pow(a, 7)));
        double two = Math.atan(x*x);
        double three = Math.PI/(Math.sqrt(Math.abs(a + x)));

        bot.sendText(id, Double.toString(one + two + three));
    }

    public  void varvar5 (Long id, String digits) {

        String[] digit = digits.split(" ");
        double a = Double.parseDouble(digit[0]);
        double b = Double.parseDouble(digit[1]);
        double c = Double.parseDouble(digit[2]);
        double d = Double.parseDouble(digit[3]);
        double x = Double.parseDouble(digit[4]);

        double one = Math.pow((a + b), 2)/(c + d);
        double two = Math.exp(Math.sqrt(x + 1));

        bot.sendText(id, Double.toString(Math.pow((one + two), 1/5.0)));
    }

    public  void varvar6 (Long id, String digits) {

        double x = Double.parseDouble(digits);

        double one = 2 * Math.sin(4*x);
        double two = Math.pow(Math.cos(x*x), 2);
        double three = (one + two)/3*x;

        bot.sendText(id, Double.toString(Math.exp(three)));
    }

    public  void varvar7 (Long id, String digits) {

        double x = Double.parseDouble(digits);
        double one = (1 + x*x)/(1 - x);
        double two = 1/2.0 * Math.tan(x);
        double three = 1/4.0 * (one + two);

        bot.sendText(id, Double.toString(three));
    }

    boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
