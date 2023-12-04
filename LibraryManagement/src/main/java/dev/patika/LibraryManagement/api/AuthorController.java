package dev.patika.LibraryManagement.api;

import dev.patika.LibraryManagement.business.abstracts.IAuthorService;
import dev.patika.LibraryManagement.entities.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/v1")
public class AuthorController {

    @Autowired
    private final IAuthorService authorService;
    public AuthorController(IAuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    @ResponseStatus(HttpStatus.OK)
    public List<Author> findAll(){
        return this.authorService.findAll();
    }

    @PostMapping("/authors")
    @ResponseStatus(HttpStatus.CREATED)
    public Author save(@RequestBody Author author){
        return this.authorService.save(author);
    }

    public Author update(@RequestBody Author author){
        return  this.authorService.update(author);

    }
}
