package num5;

public class ChocolateBoiler{

    public enum enumChocolateBoiler {
        INSTANCE;
        private boolean empty;
        private boolean boiled;
        int value;
        private static ChocolateBoiler uniqueInstance;

        private enumChocolateBoiler() {
            empty = true;
            boiled = false;
        }

        public static ChocolateBoiler getInstance() {
            return uniqueInstance;
        }

        public void fill() {
            if (isEmpty()) {
                empty = false;
                boiled = false;
            }
        }

        public void drain() {
            if (!isEmpty() && isBoiled()) {
                empty = true;
            }
        }

        public void boil() {
            if (!isEmpty() && !isBoiled()) {
                boiled = true;
            }
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public boolean isEmpty() {
            return empty;
        }

        public boolean isBoiled() {
            return boiled;
        }
    }
}
