import java.util.Arrays;

public class JavaCodeSort implements SortStrategy {
    @Override
    public void sortList(Integer[] list) {
        Arrays.sort(list);
    }

    @Override
    public String getStrategyName() {
        return "JavaCodeSort";
    }
}
