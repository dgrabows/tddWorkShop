public class SomeClass {

    String myRandomFlag = "";

    private ProteinSelector proteinSelector;

    public SomeClass(ProteinSelector proteinSelector) {
        this.proteinSelector = proteinSelector;
    }

    public String someMethod() {

        if (proteinSelector.shouldChooseBacon()) {
            myRandomFlag = "Bacon";
        } else {
            myRandomFlag = "Tofu";
        }
        
        return myRandomFlag;
    }

}
