package bzh.zomzog.kotlinworkshop.repository;

import bzh.zomzog.kotlinworkshop.repository.documents.PonyMongo;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PonyRepository extends MongoRepository<PonyMongo, ObjectId> {
}
