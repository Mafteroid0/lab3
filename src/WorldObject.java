import java.util.Objects;

public class WorldObject extends Element {
    private final Size size;
    public WorldObject(String name, Size size){
        super(name);
        this.size = size;
    }
    public void describe(){
        System.out.println("Это " + name + " " + size.getTitle());
    }
    public String getName(){
        return name;
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorldObject that = (WorldObject) o;
        return size == that.size;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(size);
    }
}
