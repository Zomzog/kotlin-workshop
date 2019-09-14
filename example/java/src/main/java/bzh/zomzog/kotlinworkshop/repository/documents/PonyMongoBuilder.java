package bzh.zomzog.kotlinworkshop.repository.documents;

import bzh.zomzog.kotlinworkshop.domain.PonyType;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;

public final class PonyMongoBuilder {
    private ObjectId id;
    private String name;
    private PonyType type;
    private LocalDateTime createdAt;

    private PonyMongoBuilder() {
    }

    private PonyMongoBuilder(PonyMongo pony) {
        this.id = pony.getId();
        this.name = pony.getName();
        this.type = pony.getType();
        this.createdAt = pony.getCreatedAt();
    }

    public static PonyMongoBuilder newBuilder() {
        return new PonyMongoBuilder();
    }

    public static PonyMongoBuilder newBuilder(PonyMongo pony) {
        return new PonyMongoBuilder(pony);
    }

    public PonyMongoBuilder id(ObjectId id) {
        this.id = id;
        return this;
    }

    public PonyMongoBuilder name(String name) {
        this.name = name;
        return this;
    }

    public PonyMongoBuilder type(PonyType type) {
        this.type = type;
        return this;
    }

    public PonyMongoBuilder createdAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public PonyMongo build() {
        PonyMongo ponyMongo = new PonyMongo();
        ponyMongo.setId(id);
        ponyMongo.setName(name);
        ponyMongo.setType(type);
        ponyMongo.setCreatedAt(createdAt);
        return ponyMongo;
    }
}
