package bzh.zomzog.kotlinworkshop.repository.documents;

import bzh.zomzog.kotlinworkshop.domain.PonyType;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

@Document
public class PonyMongo {

    private ObjectId id;
    private String name;
    private PonyType type;
    private LocalDateTime createdAt;

    public ObjectId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public PonyType getType() {
        return type;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(PonyType type) {
        this.type = type;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PonyMongo ponyMongo = (PonyMongo) o;
        return Objects.equals(id, ponyMongo.id) &&
                Objects.equals(name, ponyMongo.name) &&
                type == ponyMongo.type &&
                Objects.equals(createdAt, ponyMongo.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, createdAt);
    }

    @Override
    public String toString() {
        return "PonyMongo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", createdAt=" + createdAt +
                '}';
    }
}
