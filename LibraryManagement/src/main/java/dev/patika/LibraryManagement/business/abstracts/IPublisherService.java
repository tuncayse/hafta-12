package dev.patika.LibraryManagement.business.abstracts;

import dev.patika.LibraryManagement.entities.Publisher;

import java.util.List;

public interface IPublisherService {
    Publisher getById (int id);
    Publisher save (Publisher publisher);
    Publisher update (Publisher publisher);
    void delete (int id);
    List<Publisher> findAll();
}
