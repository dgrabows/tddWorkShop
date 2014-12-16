public class ProteinSelector {
    private RandomBooleanGenerator randomBooleanGenerator;

    public ProteinSelector() {
        this.randomBooleanGenerator = new RandomBooleanGeneratorImpl();
    }

    public ProteinSelector(RandomBooleanGenerator randomBooleanGenerator) {
        this.randomBooleanGenerator = randomBooleanGenerator;
    }

    boolean shouldChooseBacon() {
        return (randomBooleanGenerator.getNextRandomBoolean() || (randomBooleanGenerator.getNextRandomBoolean() && randomBooleanGenerator.getNextRandomBoolean())) && randomBooleanGenerator.getNextRandomBoolean();
    }
}
