import java.util.Random;

public class RandomBooleanGeneratorImpl implements RandomBooleanGenerator {
    Random random;

    public RandomBooleanGeneratorImpl() {
        this.random = new Random();
    }

    public RandomBooleanGeneratorImpl(Random random) {
        this.random = random;
    }

    @Override
    public boolean getNextRandomBoolean() {
        return random.nextBoolean();
    }
}
