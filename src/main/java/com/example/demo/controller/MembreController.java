package com.example.demo.controller;

import com.example.demo.model.Membre;
import com.example.demo.service.MembreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//for the permission of capable of being accessible by the request of AJAX
@CrossOrigin(origins = "*")
@RequestMapping("/api/membres")
public class MembreController {

    // for injection of the service layer but not the repository and then there will be no need for constructor where will initialise the object so the method in service and JPA can be reached
    @Autowired
    public MembreService membreService;

    //1. to get all the information of the members existing
    @GetMapping("/all")
    public List<Membre> getAllMembres() {
        return membreService.getAllMembres();
    }

    //2. to get the info about the members active
    @GetMapping("/actif")
    public List<Membre> findByActifTrue() {
        return membreService.findByActifTrue();
    }

    //3. to find the member by its id
    @GetMapping("/{id}")
    public Optional<Membre> findMembreById(@PathVariable Long id) {
        return membreService.findMembreById(id);
    }

    /*
    //Optional work 4. method to create a member by requesting the post in Body with JSON data type in postman
    @PostMapping
    public Membre createMembre(@RequestBody Membre membre){
        return membreService.createMembre(membre);
    }

     */

    /*
     //  Optional work 5. method to create a list of member : in the body of Postman by creatting a List<Membre> with @RequestBody and method addMembre in service layer instead of only one member
    @PostMapping("/list")
    public List<Membre> addMembres(
            @RequestBody List<Membre> membres) {
        return membreService.addMembres(membres);
    }*/

     /*
    // Optional work 6. method to update a member or several members:
    the logic should follow two steps:
    firstly,to find the object in database:by using a variable as the path to find the object already exist in database,for json and HashMap,the variable path is the key to find the data correspondent;
     secondly, by using @RequestBody in controller ten setAttributes() before asking JPA to save() in service layer.

    !!there are several ways to update:
    (1)by using @PutMapping("/{id}")
     update one attribute at one time, or update several attributes for one object at onece:
    1.one specific attribute at one time:
    @PutMapping("/{id}") or ("/name/{name}") with @PathVariable for id or name, then reset just one attribute
    2.for one object to reset several attributes at once by finding id :@PutMapping("/{id}")
    by PutMapping with id, then reset one or several attributes , at last use JPA method to save()

    !!keyPoint:
    before save an object, should reset the attributes need to be changed by using setAttributes in service layer, as well as the id should be reset in controller, then to get the attribute in service layer!
          membre.setId();// in controller
          using a method already written : get(id) in service layer then the method of getById for membre. finally save();

    (2)by using @patchMapping("/{id}") for several attributes at once by @RequestBody Map<String, object> for updates and
    update several attributes at once with two-way of irritating forEach:

    @PatchMapping("v1/{id}")// @PatchMapping("v2/{id}")
    public void partialUpdateMembre(@pathVariable Long id, @RequestBody Map<String,Object> updates){
    membreService.partialUpdateMembreV1(id, updates);
    //membreService.partialUpdateMembreV2(id, updates);

    }

      */


}
