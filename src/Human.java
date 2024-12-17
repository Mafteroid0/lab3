import java.util.ArrayList;
import java.util.Objects;

public class Human extends Creature {
    private int caution = 1 + (int) (Math.random() * (100));
    private int statiety = 1 + (int) (Math.random() * (100));
    private ArrayList<Cloth> cloths = new ArrayList<>();
    private Item activeitem;
    public Human(String name) {
        super(name);
        System.out.println("Прибыл " + name);
    }
    private String removeitem() throws NoItemException{
        if (activeitem == null){
            throw new NoItemException();
        } else{
            String somename =  activeitem.getName();
            activeitem = null;
            return somename;
        }
    }
    private void increaseStatiety(int amount){
        statiety += amount;
        System.out.println("Сытость " + name + " понемногу поднимается.");
    }
    private void decreaseStatiety(int amount){
        statiety -= amount;
        System.out.println("Сытость " + name + " падает.");
    }
    private void decreaseCaution(int amount){
        caution -= amount;
        System.out.println("Внимательность " + name + " упала");
    }
    private void increaseCaution(int amount){
        caution += amount;
        System.out.println("Внимательность " + name + " поднялась");
    }

    void taste(Fruit fruit){
        String description = fruit.getFruitType().getTitle();
        System.out.println(name + " пробует " + description);
        if (fruit instanceof Moonfruit){
            System.out.println(name + " убедился что это лунный " + description);
        } else System.out.println(name + " убедился что это обычный " + description);
    };
    public void eat(Food food){
        System.out.println(name + " ест " + food.getName());
        increaseStatiety(10);
        decreaseCaution(10);
    };
    void take(Item item){
        if (activeitem == null) {
            activeitem = item;
            System.out.println(name + " взял " + activeitem.getName());
        }
        else throw new TooManyItemsException(this, item);
    }
    void throwItem(Direction direction){
        try {
            System.out.println(name + " отшвырнул " + removeitem() + " " + direction.getTitle());
        } catch (NoItemException e) {
            System.out.println(name + " ничего не отшвырнул.");
        }
    };
    void describeStatiety(){
        if (statiety < 20) {
            System.out.println(name + " голоден!");
        } else if (statiety < 40) {
            System.out.println(name + " хочет есть.");
        } else if (statiety < 85){
            System.out.println(name + " не против подкрепиться.");
        } else{
            System.out.println(name + " сыт.");
        }
    }

    void describeActiveItem(){
        if (activeitem != null){
            System.out.println(name + " держит в руках " + activeitem.getName());
        } else System.out.println(name + " ничего не держит в руках.");

    }


    public void move(Direction direction){
        System.out.println(name + " прошёл " + direction.getTitle());
    }

    Integer getCaution(){
        return caution;
    }
    void payAttention(int thresholdValue){
        if (this.getCaution() < thresholdValue){
            System.out.println(name + " ничего не заметил потому что вёл себя недостаточно осторожно.");
        }
        else{
            System.out.println(name + " вёл себя достаточно осторожно чтобы заметить это.");
        }
    }
    public String getName(){
        return name;
    }

    public void addCloth(Cloth cloth){
        cloths.add(cloth);
    }

    public void describeCloth(){
        boolean has_trousers = false;
        boolean has_boots = false;
        for (Cloth cloth : cloths) {
            System.out.println("На " + name + " надето " + cloth.getDescription());
            if (cloth.getElement() == ClothElement.Trousers){has_trousers = true;}
            if (cloth.getElement() == ClothElement.Boots){has_boots = true;}
        }
        if (has_trousers){
            System.out.println("Такие штаны обычно носят заткнув в сапоги");
            if (has_boots){
                System.out.println("Именно так он их и носил.");
            } else {
                System.out.println("Но сапог не было.");
            }
        }
    }

//    @Override
//    public boolean equals(Object other) {
//        if (other instanceof Human){
//            return getName().equals(((Human) other).getName());
//        }
//        return false;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return caution == human.caution && statiety == human.statiety && Objects.equals(cloths, human.cloths) && Objects.equals(activeitem, human.activeitem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(caution, statiety, cloths, activeitem);
    }

    @Override
    public String toString() {
        return "Human{"
                + "name='" + name + '\''
                + ", activeitem=" + activeitem
                + ", caution=" + caution
                + ", statiety=" + statiety
                + '}';
    }


    public class Eyes{
        public Eyes(){
        }
        public void follow(Human other) {
                System.out.println("За " + other.getName() + " следили чьи-то глаза.");
                other.payAttention(75);

        }
        public void describeOwner(){
            System.out.println("Глаза принадлежат " + name);
        }
    }

}
