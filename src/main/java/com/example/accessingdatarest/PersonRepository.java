package com.example.accessingdatarest;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/*
* annotation @RepositoryRestResource includes common REST methods like:
*   POST(with Person object as JSON in request body) => "/people" + json object in body,
*   GET => "/people",
*   DELETE(with id as parameter) => "/people/{id}",
*   PUT(with id as parameter and Person object as JSON in request body) => "/people/{id}" + json object in body*
*/
@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

    // "/people/search/findByLastName?name=<last name>"
    List<Person> findByLastName(@Param("name") String name);

}