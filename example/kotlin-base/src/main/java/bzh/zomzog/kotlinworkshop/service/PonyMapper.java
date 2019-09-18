package bzh.zomzog.kotlinworkshop.service;

import bzh.zomzog.kotlinworkshop.domain.Pony;
import bzh.zomzog.kotlinworkshop.domain.PonyBuilder;
import bzh.zomzog.kotlinworkshop.repository.documents.PonyMongo;
import bzh.zomzog.kotlinworkshop.repository.documents.PonyMongoBuilder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PonyMapper {

    public Pony map(PonyMongo mongo) {
        return PonyBuilder.newBuilder()
                .id(mongo.getId().toString())
                .name(mongo.getName())
                .type(mongo.getType())
                .createdAt(mongo.getCreatedAt())
                .build();
    }

    public PonyMongo mapNew(Pony pony) {
        return PonyMongoBuilder.newBuilder()
                .name(pony.getName())
                .type(pony.getType())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public PonyMongo update(PonyMongo origin, Pony update) {
        return PonyMongoBuilder.newBuilder(origin)
                .name(update.getName())
                .type(update.getType())
                .build();
    }
}
