package bzh.zomzog.kotlinworkshop.domain;

import java.time.LocalDateTime;

public final class PonyBuilder {
    private String id;
    private String name;
    private PonyType type;
    private LocalDateTime createdAt;

    private PonyBuilder() {
    }

    public static PonyBuilder newBuilder() {
        return new PonyBuilder();
    }

    public PonyBuilder id(String id) {
        this.id = id;
        return this;
    }

    public PonyBuilder name(String name) {
        this.name = name;
        return this;
    }

    public PonyBuilder type(PonyType type) {
        this.type = type;
        return this;
    }

    public PonyBuilder createdAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Pony build() {
        return new Pony(id, name, type, createdAt);
    }
}
