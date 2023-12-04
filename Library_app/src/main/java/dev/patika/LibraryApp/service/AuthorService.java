package dev.patika.LibraryApp.service;

import dev.patika.LibraryApp.dto.request.AuthorRequest;
import dev.patika.LibraryApp.dto.response.AuthorResponse;
import dev.patika.LibraryApp.entity.Author;
import dev.patika.LibraryApp.mapper.AuthorMapper;
import dev.patika.LibraryApp.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public List<AuthorResponse> findAll() {
        return authorMapper.asOutput(authorRepository.findAll());
    }

    public AuthorResponse getById(Long id) {
        return authorMapper.asOutput(authorRepository.findById(id).orElseThrow(() -> new RuntimeException(id + "id li Yazar Bulunamadı !!!")));
    }

    public AuthorResponse create(AuthorRequest request) {
        // Name , birthDate ve country bizim için unique sayılıyor bu yüzden bu özelliklere sahip author var mı diye
        // DB den bakıyoruz yoksa create isteği atabiliriz.
        Optional<Author> isAuthorExist = authorRepository.findByNameAndBirthDateAndCountry(request.getName(), request.getBirthDate(), request.getCountry());

        if (isAuthorExist.isEmpty()) {
            Author authorSaved = authorRepository.save(authorMapper.asEntity(request));
            return authorMapper.asOutput(authorSaved);
        }
        throw new RuntimeException("Bu yazar daha önce sisteme kayıt olmuştur !!!");
    }

    public AuthorResponse update(Long id, AuthorRequest request) {

        Optional<Author> authorFromDb = authorRepository.findById(id);

        Optional<Author> isAuthorExist = authorRepository.findByNameAndBirthDateAndCountry(request.getName(), request.getBirthDate(), request.getCountry());

        if (authorFromDb.isEmpty()) {
            throw new RuntimeException(id + "Güncellemeye çalıştığınız yazar sistemde bulunamadı. !!!.");
        }

        if (isAuthorExist.isPresent()) {
            throw new RuntimeException("Bu yazar daha önce sisteme kayıt olmuştur !!!");
        }
        Author author = authorFromDb.get();
        authorMapper.update(author, request);
        return authorMapper.asOutput(authorRepository.save(author));
    }

    public void deleteById(Long id) {
        Optional<Author> authorFromDb = authorRepository.findById(id);
        if (authorFromDb.isPresent()) {
            authorRepository.delete(authorFromDb.get());
        } else {
            throw new RuntimeException(id + "id li Yazar sistemde bulunamadı !!!");
        }
    }


}
