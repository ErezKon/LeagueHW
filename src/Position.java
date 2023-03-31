public enum Position {
    GOALKEEPER("Goal Keeper"),
    DEFENDER("Defender"),
    MIDFIELDER("Mid Fielder"),
    FORWARD("Forward");


    private final String name;

    private Position(String s) {
        name = s;
    }
    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}
