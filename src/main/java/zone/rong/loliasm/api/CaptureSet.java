package zone.rong.loliasm.api;

import java.util.HashSet;
import java.util.Set;

public class CaptureSet<K> extends HashSet<K> {

    private static final long serialVersionUID = -231949409716453515L;
    private final Set<K> backingCaptures;

    public CaptureSet() {
        super();
        this.backingCaptures = new HashSet<>();
    }

    public CaptureSet(Set<K> populate) {
        this();
        addAll(populate);
    }

    public void addCapture(K capture) {
        this.backingCaptures.add(capture);
    }

    public boolean put(K k) {
        return super.add(k);
    }

    @Override
    public boolean add(K k) {
        return this.backingCaptures.contains(k) || super.add(k);
    }
}
