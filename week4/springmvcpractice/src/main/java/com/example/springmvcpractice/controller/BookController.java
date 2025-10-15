package com.example.springmvcpractice.controller;

import com.example.springmvcpractice.dto.BookDto;
import com.example.springmvcpractice.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    // 생성자 주입
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /** 도서 목록 */
    @GetMapping
    public String list(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books/list";
    }

    /** 도서 상세 */
    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.getBookById(id));
        return "books/detail";
    }

    /** 도서 등록 폼 표시 */
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("bookDto", new BookDto());
        return "books/form";
    }

    /** 도서 등록 처리 */
    @PostMapping
    public String createBook(@ModelAttribute("bookDto") BookDto bookDto) {
        bookService.createBook(bookDto);
        return "redirect:/books";
    }
}