package com.example.springmvcpractice.service;

import com.example.springmvcpractice.dto.BookDto;
import com.example.springmvcpractice.repository.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Comparator;
import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    // 생성자 주입
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /** 전체 목록 (id 오름차순 정렬) */
    public List<BookDto> getAllBooks() {
        List<BookDto> list = bookRepository.findAll();
        list.sort(Comparator.comparing(BookDto::getId));
        return list;
    }

    /** 단건 조회 (없으면 404) */
    public BookDto getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "도서를 찾을 수 없습니다."));
    }

    /** 새 도서 생성 */
    public BookDto createBook(BookDto bookDto) {
        return bookRepository.save(bookDto);
    }
}
