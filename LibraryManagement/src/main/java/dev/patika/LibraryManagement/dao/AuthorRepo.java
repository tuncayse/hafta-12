package dev.patika.LibraryManagement.dao;

import dev.patika.LibraryManagement.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author, Integer> {

}
