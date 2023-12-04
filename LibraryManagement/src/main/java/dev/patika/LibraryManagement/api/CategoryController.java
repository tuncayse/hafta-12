package dev.patika.LibraryManagement.api;

import dev.patika.LibraryManagement.business.abstracts.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
@RequestMapping("/v1")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;
}
