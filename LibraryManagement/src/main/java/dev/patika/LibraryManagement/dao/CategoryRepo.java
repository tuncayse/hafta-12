package dev.patika.LibraryManagement.dao;

import dev.patika.LibraryManagement.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
