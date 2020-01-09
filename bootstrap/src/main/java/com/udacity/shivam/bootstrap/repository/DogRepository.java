package com.udacity.shivam.bootstrap.repository;

import com.udacity.shivam.bootstrap.entity.Dog;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog,Long> {

  @Query("select d.id, d.breed from Dog d where d.id=:id")
  String findDogBreedById(Long id);

  @Query("select d.id, d.name from Dog d")
  List<String> findAllName();

  @Query("select d.id, d.breed from Dog d")
  List<String> findAllBreed();

}
