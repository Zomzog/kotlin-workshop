package bzh.zomzog.kotlinworkshop.controller;

import bzh.zomzog.kotlinworkshop.domain.Pony;
import bzh.zomzog.kotlinworkshop.service.PonyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ponies")
public class PonyController {

    private final PonyService ponyService;

    public PonyController(PonyService ponyService) {
        this.ponyService = ponyService;
    }

    @GetMapping
    public ResponseEntity<List<Pony>> list() {
        List<Pony> result = ponyService.list();
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<Pony> save(@RequestBody Pony pony) {
        Pony result = ponyService.save(pony);
        return ResponseEntity.ok(result);
    }

}
