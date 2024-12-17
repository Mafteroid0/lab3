public record Cloth(ClothElement type, Color color) implements Wearable{
    public void putOn(Human human) {
        human.addCloth(this);
    }
    public String getDescription() {
        return type.getTitle() + " " + color.getTitle() + " цвета";
    }
    public ClothElement getElement(){
        return type;
    }

}
