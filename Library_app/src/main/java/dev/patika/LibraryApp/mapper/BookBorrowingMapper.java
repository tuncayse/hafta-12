package dev.patika.LibraryApp.mapper;

import dev.patika.LibraryApp.dto.request.BookBorrowingRequest;
import dev.patika.LibraryApp.dto.request.BookBorrowingUpdateRequest;
import dev.patika.LibraryApp.entity.BookBorrowing;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface BookBorrowingMapper {

    BookBorrowing asEntity(BookBorrowingRequest bookBorrowingRequest);

    BookBorrowing asEntity(BookBorrowingUpdateRequest bookBorrowingUpdateRequest);

    void update(@MappingTarget BookBorrowing entity, BookBorrowingUpdateRequest bookBorrowingUpdateRequest);
}
