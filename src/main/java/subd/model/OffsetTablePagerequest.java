package subd.model;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import java.io.Serializable;

public class OffsetTablePageRequest implements Pageable, Serializable {
    private final int offset;
    private final int count;
    private final Sort sort;

    public OffsetTablePageRequest(long offset, long count) {
        this(offset, count, Sort.by("id"));
    }

    public OffsetTablePageRequest(long offset, long count, Sort sort) {
        if (offset < 0) {
            throw new IllegalArgumentException("Offset value must not be less than zero!");
        }
        if (count < 1) {
            throw new IllegalArgumentException("Count value must not be less than one!");
        }
        this.offset = (int) offset;
        this.count = (int) count;
        this.sort = sort;
    }

    @Override
    public Sort getSort() {
        return sort;
    }

    @Override
    public int getPageSize() {
        return count;
    }

    @Override
    public int getPageNumber() {
        return offset / count;
    }

    @Override
    public long getOffset() {
        return offset;
    }

    @Override
    public boolean hasPrevious() {
        return offset > 0;
    }

    @Override
    public Pageable next() {
        return new OffsetTablePageRequest(getOffset() + getPageSize(), getPageSize(), getSort());
    }

    @Override
    public Pageable previousOrFirst() {
        return hasPrevious() ? previous() : first();
    }

    public Pageable previous() {
        return getOffset() == 0 ? this : new OffsetTablePageRequest(getOffset() - getPageSize(), getPageSize(), getSort());
    }

    @Override
    public Pageable first() {
        return new OffsetTablePageRequest(0, getPageSize(), getSort());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final OffsetTablePageRequest other = (OffsetTablePageRequest) obj;
        return this.offset == other.offset && this.count == other.count;
    }
}