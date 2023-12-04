package dev.patika.LibraryManagement.business.abstracts;

import dev.patika.LibraryManagement.entities.Category;

import java.util.List;

public interface ICategoryService {
    Category getById (int id);
    Category save (Category category);
    Category update (Category category);
    String delete(int id);
    List<Category> findAll();
}
