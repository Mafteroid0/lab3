

public class Fruit extends Food {
    public FruitType fruitType;
    public String name;
    public Color color;
    public Fruit(FruitType fruitType) {
        super(fruitType.getTitle());
        this.fruitType = fruitType;
        this.color = Color.RED;
        this.name = fruitType.getTitle();
    }

    public void setColor(Color color){
        this.color = color;
    }
    public Color getColor(){
        return this.color;
    }

    public FruitType getFruitType() {
        return fruitType;
    }
}
