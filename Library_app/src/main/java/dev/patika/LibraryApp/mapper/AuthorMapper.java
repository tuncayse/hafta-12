package dev.patika.LibraryApp.mapper;

import dev.patika.LibraryApp.dto.request.AuthorRequest;
import dev.patika.LibraryApp.dto.response.AuthorResponse;
import dev.patika.LibraryApp.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface AuthorMapper {
    Author asEntity(AuthorRequest authorRequest);

    AuthorResponse asOutput(Author author);

    List<AuthorResponse> asOutput(List<Author> author);

    void update(@MappingTarget Author entity, AuthorRequest request);


}
