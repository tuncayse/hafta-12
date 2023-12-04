package dev.patika.LibraryApp.mapper;

import dev.patika.LibraryApp.dto.response.PublisherResponse;
import dev.patika.LibraryApp.entity.Publisher;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PublisherMapper {
    PublisherResponse asOutput(Publisher publisher);

    List<PublisherResponse> asOutput(List<Publisher> publishers);
}
