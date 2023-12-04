package dev.patika.LibraryApp.mapper;

import dev.patika.LibraryApp.dto.request.BookForBorrowingRequest;
import dev.patika.LibraryApp.entity.Book;
import org.mapstruct.Mapper;

@Mapper
public interface BookForBorrowingMapper {

    Book asEntity(BookForBorrowingRequest bookForBorrowingRequest);
}
