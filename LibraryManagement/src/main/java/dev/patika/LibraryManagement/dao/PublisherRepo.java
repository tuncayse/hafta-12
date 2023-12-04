package dev.patika.LibraryManagement.dao;

import dev.patika.LibraryManagement.entities.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepo extends JpaRepository<Publisher, Integer> {
}
