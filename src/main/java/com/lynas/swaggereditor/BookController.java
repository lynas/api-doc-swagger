package com.lynas.swaggereditor;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable long id) {
        return new Book(id, "book1");
    }

    @GetMapping
    public List<Book> getAll() {
        return new ArrayList<Book>();
    }

    @PostMapping
    public Book createNewBook(@RequestBody Book book) {
        return book;
    }

    @DeleteMapping("/{id}")
    public boolean deleteBook(@PathVariable long id) {
        return true;
    }

}
