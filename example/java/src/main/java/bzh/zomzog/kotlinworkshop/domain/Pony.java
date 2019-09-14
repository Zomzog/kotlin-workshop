package bzh.zomzog.kotlinworkshop.domain;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;

public class Pony {
    private final String id;
    @NotNull
    private final String name;
    @NotNull
    private final PonyType type;
    private final LocalDateTime createdAt;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public PonyType getType() {
        return type;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Pony(String id, String name, PonyType type, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.createdAt = createdAt;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pony pony = (Pony) o;
        return Objects.equals(id, pony.id) &&
                Objects.equals(name, pony.name) &&
                type == pony.type &&
                Objects.equals(createdAt, pony.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, createdAt);
    }

    @Override
    public String toString() {
        return "Pony{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", createdAt=" + createdAt +
                '}';
    }
}
