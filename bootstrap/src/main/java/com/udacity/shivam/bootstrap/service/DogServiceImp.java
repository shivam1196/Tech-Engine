package com.udacity.shivam.bootstrap.service;

import com.udacity.shivam.bootstrap.entity.Dog;
import com.udacity.shivam.bootstrap.repository.DogRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DogServiceImp implements DogService {

  @Autowired
  DogRepository dogRepository;

  @Override
  public List<Dog> retriveDogs() {
    return (List<Dog>) dogRepository.findAll();
  }

  @Override
  public List<String> retriveDogBreed() {
    return (List<String>) dogRepository.findAllBreed();
  }

  @Override
  public String retriveDogBreedById(Long id) {
    Optional<String> optionalBreed = Optional.ofNullable(dogRepository.findDogBreedById(id));
    String breed = optionalBreed.orElseThrow(DogNotFoundException::new);
    return breed;
  }

  @Override
  public List<String> retriveDogName() {
    return (List<String>) dogRepository.findAllName();
  }
}
