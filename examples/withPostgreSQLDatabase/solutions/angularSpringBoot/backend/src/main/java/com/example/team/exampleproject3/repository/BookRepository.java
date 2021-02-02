package com.example.team.exampleproject3.repository;

import com.example.team.exampleproject3.model.Book;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
}