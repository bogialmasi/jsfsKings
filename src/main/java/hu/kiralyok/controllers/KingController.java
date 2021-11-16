package hu.kiralyok.controllers;

import hu.kiralyok.domain.King;
import hu.kiralyok.services.KingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class KingController {

    private KingService service;

    @Autowired
    public void setService(KingService service) {
        this.service = service;
    }

    @GetMapping("/kings")
    public List<King> kings() {
        return service.getKings();
    }

    @GetMapping("/kings/{id}")
    public King getCategoryById(@PathVariable("id") int id) {
        return service.getKingById(id);
    }

    /*---------------------------------------------------------------------------*/

    @PostMapping("/kings")
    @ResponseStatus(HttpStatus.CREATED)
    public King addKing(@RequestBody King king) {
        return service.addKing(king);
    }

    /*---------------------------------------------------------------------------*/


    @DeleteMapping("/kings/{id}")
    public void killKing(@PathVariable("id") int id) {
        service.killKing(id);
    }

    /*---------------------------------------------------------------------------*/

    @PatchMapping("/kings/{id}/{death}")
    public void updateKing(@PathVariable("id") int id, @PathVariable("death") int death) {
        service.updateKing(id, death);
    }
}