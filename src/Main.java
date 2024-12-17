//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Human neznayka = new Human("Незнайка");
        Human fisk = new Human("Фикс");

        Moonfruit pear = new Moonfruit(FruitType.PEAR);
        neznayka.take(pear);
        Fence fence = new Fence(Size.Large);
        Bush bush = new Bush(Size.Small, new Moonfruit(FruitType.BERRY));

        Human.Eyes fiskeyes = fisk.new Eyes();

        Cloth blazer = new Cloth(ClothElement.Blazer, Color.GINGER);
        Cloth cap = new Cloth(ClothElement.Cap, Color.GINGER);
        Cloth trousers = new Cloth(ClothElement.Trousers, Color.BLUE);
        Cloth sandals = new Cloth(ClothElement.Sandals, Color.BLUE);
        blazer.putOn(fisk);
        cap.putOn(fisk);
        trousers.putOn(fisk);
        sandals.putOn(fisk);

        Broom broom = new Broom();
        fisk.take(broom);

        System.out.println("\n----История о Незнайке----\n");


        neznayka.throwItem(Direction.AWAY);
        neznayka.describeStatiety();
        neznayka.move(Direction.AWAY);
        fence.describe();
        bush.describe();
        Fruit berry = bush.getFruit();
        neznayka.taste(berry);
        neznayka.eat(berry);
        neznayka.describeStatiety();
        fiskeyes.follow(neznayka);
        fiskeyes.describeOwner();
        fisk.describeCloth();
        fisk.describeActiveItem();


        }
    }
