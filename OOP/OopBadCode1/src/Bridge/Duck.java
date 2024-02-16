package Bridge;

public abstract class Duck {
    protected Capabilities capabilities;

    protected Duck(Capabilities capabilities) {
        this.capabilities = capabilities;
    }

    public abstract void duckCapabilities();
}
