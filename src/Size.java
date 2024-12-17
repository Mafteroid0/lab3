public enum Size {
    Small("Маленького размера"),
    Medium("Среднего размера"),
    Large("Большого размера");
    private final String title;

    Size(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Size{" +
                "title='" + title + '\'' +
                '}';
    }
}
