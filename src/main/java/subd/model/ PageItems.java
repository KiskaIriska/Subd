package subd.model;

import java.util.Collection;

public class PageItems<T> {
    private final long count;
    private final Collection<T> items;

    public PageItems(long count, Collection<T> items) {
        this.count = count;
        this.items = items;
    }
    public long getCount() {
        return count;
    }
    public Collection<T> getItems() {
        return items;
    }
}

