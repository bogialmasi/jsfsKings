package hu.kiralyok.controllers;

import hu.kiralyok.domain.Kingdom;
import hu.kiralyok.domain.King;
import hu.kiralyok.services.KingdomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KingdomTroller {

    private KingdomService service;

    @Autowired
    public void setService(KingdomService service) {
        this.service = service;
    }

    @GetMapping("/kingdoms")
    public List<Kingdom> kingdoms() {
        return service.getKingdoms();
    }

    @GetMapping("/kingdoms/{id}")
    public Kingdom getKingdomById(@PathVariable("id") int id) {
        return service.getKingdomById(id);
    }

    @GetMapping("/kingdoms/{id}/kings")
    public List<King> getKingsByKingdom(@PathVariable("id") int id) {
        return service.getKingsByKingdom(id);
    }

    /*---------------------------------------------------------------------------*/

    @PostMapping("/kingdoms")
    @ResponseStatus(HttpStatus.CREATED)
    public Kingdom addKingdom(@RequestBody Kingdom category) {
        return service.addKingdom(category);
    }

    /*---------------------------------------------------------------------------*/


    @DeleteMapping("/kingdoms/{id}")
    public void deleteKingdom(@PathVariable("id") int id) {
        service.deleteKingdom(id);
    }

    /*---------------------------------------------------------------------------*/

    @PatchMapping("/kingdoms/{id}/{area}/{population}")
    public void updatKingdom(@PathVariable("id") int id, @PathVariable("area") int area, @PathVariable("population") int population){
        service.updateKingdom(id, area, population);
    }
}
