package bzh.zomzog.kotlinworkshop.service;

import bzh.zomzog.kotlinworkshop.domain.Pony;
import bzh.zomzog.kotlinworkshop.domain.PonyBuilder;
import bzh.zomzog.kotlinworkshop.repository.PonyRepository;
import bzh.zomzog.kotlinworkshop.repository.documents.PonyMongo;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PonyService {

    private final PonyRepository ponyRepository;

    private final PonyMapper mapper;

    public PonyService(PonyRepository ponyRepository, PonyMapper mapper) {
        this.ponyRepository = ponyRepository;
        this.mapper = mapper;
    }

    public List<Pony> list() {
        return ponyRepository.findAll()
                .stream()
                .map(mapper::map)
                .collect(Collectors.toList());
    }

    public Pony save(Pony pony) {
        PonyMongo updated;
        if (null == pony.getId()) {
            updated = ponyRepository.save(mapper.map(pony));
        } else {
            final Optional<PonyMongo> fromDb = ponyRepository.findById(new ObjectId(pony.getId()));
            updated = fromDb.map(it -> mapper.update(it, pony))
                    .orElseThrow(() -> new RuntimeException("Pony not found")); // TODO Named exception
        }
        return mapper.map(updated);
    }

}
