abstract class Creature {
    protected final String name;

    public Creature(String name) {
        this.name = name;
    }
    public abstract void eat(Food food);
    public abstract String getName();
    public abstract void move(Direction direction);

}
