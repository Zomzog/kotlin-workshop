package bzh.zomzog.kotlinworkshop.service

import bzh.zomzog.kotlinworkshop.domain.Pony
import bzh.zomzog.kotlinworkshop.domain.PonyType
import bzh.zomzog.kotlinworkshop.repository.documents.PonyMongoBuilder
import org.bson.types.ObjectId
import java.time.LocalDateTime


fun ponyDefault(id: String? = "5d8293800dbdf8463e65de90", name: String = "Pinkie", type: PonyType = PonyType.Pegasi, createdAt: LocalDateTime? = LocalDateTime.parse("2007-12-03T10:15:30")) =
        Pony(id, name, type, createdAt)

fun ponyMongoDefault(id: String? = "5d8293800dbdf8463e65de90", name: String = "Pinkie", type: PonyType = PonyType.Pegasi, createdAt: LocalDateTime? = LocalDateTime.parse("2007-12-03T10:15:30")) = PonyMongoBuilder.newBuilder()
        .id(if (null == id) id else ObjectId(id))
        .name(name)
        .type(type)
        .createdAt(createdAt).build()