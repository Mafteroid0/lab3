public class Moonfruit extends Fruit{
    public Moonfruit(FruitType fruitType) {
        super(fruitType);
    }
    @Override
    public String getName(){
        return "Лунный " + name;
    }
}
