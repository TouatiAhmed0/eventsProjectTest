package tn.esprit.eventsproject.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.eventsproject.entities.Event;
import tn.esprit.eventsproject.entities.Logistics;
import tn.esprit.eventsproject.entities.Participant;
import tn.esprit.eventsproject.services.IEventServices;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("event")
@RestController
public class EventRestController {
    private final IEventServices eventServices;

    @PostMapping("/addPart")
    public Participant addParticipant(@RequestBody Participant participant){
        return eventServices.addParticipant(participant);
    }
    @PostMapping("/addEvent/{id}")
    public Event addEventPart(@RequestBody Event event, @PathVariable("id") int idPart){
        return eventServices.addAffectEvenParticipant(event, idPart);
    }
    @PutMapping("/addAffectLog/{description}")
    public Logistics addAffectLog(@RequestBody Logistics logistics,@PathVariable("description") String descriptionEvent){
        return eventServices.addAffectLog(logistics,descriptionEvent);
    }
    @GetMapping("/getLogs/{d1}/{d2}")
    public List<Logistics> getLogistiquesDates (@PathVariable("d1") LocalDate date_debut, @PathVariable("d2") LocalDate date_fin){
        return eventServices.getLogisticsDates(date_debut,date_fin);
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @PostMapping("/addEvent")
    public Event addEvent(@RequestBody Event event){
        return eventServices.addAffectEvenParticipant(event);
    }

    @GetMapping("/getEvent/{id}")
    public Event getEvent( @PathVariable("id") int id){
        return eventServices.retrieveEvent(id);
    }

    @GetMapping("/getAll")
    public List<Event> getAll(){
        return eventServices.getAll();
    }

}
