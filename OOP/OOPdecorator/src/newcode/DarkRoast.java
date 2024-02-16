package newcode;

public class DarkRoast implements Beverage {

  //  public DarkRoast() {
 //       description = "Dark Roast Coffee";
 //   }

    @Override
    public String getDescription() {
        return "Dark Roast Coffee";
    }

    public double cost() {
        return 0.99;
    }
}
