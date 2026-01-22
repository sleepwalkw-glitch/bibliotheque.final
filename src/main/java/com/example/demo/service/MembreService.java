package com.example.demo.service;

import com.example.demo.model.Membre;
import com.example.demo.repository.MembreRepository;
import jakarta.persistence.Id;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class MembreService {
    private final MembreRepository membreRepository;

    public MembreService(MembreRepository membreRepository) {
        this.membreRepository = membreRepository;
    }

    //1. the method to get all members by using the method of JPA
    public List<Membre> getAllMembres() {
//        if the method is not declaired as static, it will be required to be called with an object instance,but not on the class name;
        return membreRepository.findAll();
    }

    // 2. method to get the members active with method written manuelle in Repository
    public List<Membre> findByActifTrue(){
        return membreRepository.findByActifTrue();
    }

    //3.  method to get the members by its id
    public Optional<Membre> findMembreById(Long id){
        //here can use Optional or without Optional , and should check if the id is already exist in the database.
        return Optional.of(membreRepository.findById(id)
                .orElseThrow(
                        () -> new IllegalArgumentException("Member with the id" + id + "not found.")));
    }


    /*
    //Optional work 4. method to create a member by requesting the post in Body with JSON data type in postman
    public Membre createMembre(Membre membre) {
       return membreRepository.save(membre);
    }
     */

    /*
//    Optional work 5. method to create a list of member in the body of Postman by creatting a List<Membre> with @RequestBody and method addMembre in service layer instead of only one member
    public List<Membre> addMembres(List<Membre> membres) {
        return membreRepository.saveAll(membres);
}

     */


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

    1.@PatchMapping("/{id}") with Map<String,object> and call the method of.map(), using foreach with switch to irritate , to find, to check and to reset in the same nested structure!
        public void partialUpdateMembreV1(Long id, Map<String, object> updates){
        findMembreById(id)
            .map(membre ->{
            updates.forEach((String key, object value) ->{
                switch(key){
                    case "name":
                        membre.setNom((String) value);
                        break;
                    case "email":
                        membre.setEmail((String)value);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid field" + key);
                    }
            )};
            return membreRepository.save(membre);
            });

      2.@PatchMapping(/{id}) with Map<String,object> for its method .forEach to loop in map, also to use Field type with its method ReflectionUtils.findField(Membre.class,key) to reset the field with ReflectUtils.setField(field,membreUpdate, value), before asking JPA to .save();
       Keypoint for the logic is to separate the verification and find by id part with the reset part.

       public void partialUpdateMembreV2(Long id,Map<String, object> updates){

       (1)step one: for the find by id , here are also two way, one with Optional.get(id), another is to use normal object method
       i.Optional
       private Optional<Membre> findMembreById(Long id){
       return Optional.ofNullable(membreRepository.findById(Long id)
            .orElseThrow(()->
                new IllegalArgumentException("Member with " +id + " not found")));
       }
       }
       (2)step two with two party: use map and ReflectUtils.findField() to irritate all the object in map then to reset the field with its values. for new object for membre, can chose the two ways, but the purpose is to get the one by findById.either optional or normal one works.
        // part 1: to findById
        i.create new object for the updated membre with Optional<Membre> to verify and then getById(id).get()
        Optional<Membre> Membre membreToUpdate = findMembreById(id).get();

        ii.create new object normal
        Membre membreToUpdate = findMembreById(id);

        // part 2: to reset the field with its value

        updates.forEach((String key, Object value)
            ->{Field filed = ReflectionUtils.findFeild(Membre.class, key);
          if(filed != null){
            filed.setAccessible(true);
            ReflectionUtils.setField(filed,membreToUpdate, value);
          }

        });
        membreRepository.save(membreToUpdate);}

     */


}
