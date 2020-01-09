package com.udacity.shivam.bootstrap.controller;


import com.udacity.shivam.bootstrap.entity.Dog;
import com.udacity.shivam.bootstrap.service.DogService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DogController {
  private DogService dogService;

  @Autowired
  public void setDogService(DogService dogService){
    this.dogService = dogService;
  }

  @GetMapping("/dogs")
  public ResponseEntity<List<Dog>> getAllDogs(){
      List<Dog> list = dogService.retriveDogs();
      return new ResponseEntity<List<Dog>>(list, HttpStatus.OK);
  }

  @GetMapping("/dogs/breed")
  public ResponseEntity<List<String>> getAllDogsBreed(){
    List<String> list = dogService.retriveDogBreed();
    return new ResponseEntity<List<String>>(list,HttpStatus.OK);
  }

  @GetMapping ("/dogs/name")
  public ResponseEntity<List<String>> getAllDogsName(){
    List<String> list = dogService.retriveDogName();
    return new ResponseEntity<List<String>>(list,HttpStatus.OK);
  }

  @GetMapping("/{id}/breed")
  public ResponseEntity<String> getBreedById(@PathVariable Long id){
    String breed = dogService.retriveDogBreedById(id);
    return new ResponseEntity<String>(breed,HttpStatus.OK);
  }

}
