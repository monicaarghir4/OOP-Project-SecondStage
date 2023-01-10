package input;

public class FiltersInput {
    private SortInput sort;
    private ContainsInput contains;

    public FiltersInput() {
    }

    public FiltersInput(final SortInput sort, final ContainsInput contains) {
        this.sort = sort;
        this.contains = contains;
    }

    /**
     * @return the sorting class
     */
    public SortInput getSort() {
        return sort;
    }

    /**
     * @return containing class
     */
    public ContainsInput getContains() {
        return contains;
    }
}
