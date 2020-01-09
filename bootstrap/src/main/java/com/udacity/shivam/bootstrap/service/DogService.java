package com.udacity.shivam.bootstrap.service;

import com.udacity.shivam.bootstrap.entity.Dog;
import java.util.List;

public interface DogService {

  List<Dog> retriveDogs();
  List<String> retriveDogBreed();
  String retriveDogBreedById(Long id);
  List<String> retriveDogName();


}
