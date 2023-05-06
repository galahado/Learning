package streams;

public record Dish(String name, boolean vegetarian, int calories, streams.Dish.Type type) {

    public enum Type {
        MEAT,
        FISH,
        OTHER
    }
}