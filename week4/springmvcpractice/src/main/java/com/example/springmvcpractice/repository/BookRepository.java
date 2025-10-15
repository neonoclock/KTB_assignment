package com.example.springmvcpractice.repository;

import com.example.springmvcpractice.dto.BookDto;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BookRepository {

    // 삽입 순서 유지
    private final Map<Long, BookDto> store = new LinkedHashMap<>();
    private long sequence = 0L;
    private boolean initialized = false;

    public BookRepository() {
        initIfEmpty();
    }

    private synchronized void initIfEmpty() {
        if (initialized || !store.isEmpty()) return;

        // 초기 데이터 3권
        save(new BookDto(null, "Clean Code", "Robert C. Martin",
                "소프트웨어 장인 정신을 담은 책입니다.", "9780132350884"));
        save(new BookDto(null, "객체지향의 사실과 오해", "조영호",
                "객체지향의 본질을 쉽게 설명합니다.", "9791186710770"));
        save(new BookDto(null, "Effective Java", "Joshua Bloch",
                "자바 개발자를 위한 베스트 프랙티스 모음집입니다.", "9780134685991"));

        initialized = true;
    }

    /** 새 도서 저장 (id가 없을 때만 신규 id 부여) */
    public BookDto save(BookDto book) {
        if (book.getId() == null) {
            book.setId(++sequence);
        } else {
            // 외부에서 id가 들어온 경우 시퀀스 역행 방지
            sequence = Math.max(sequence, book.getId());
        }
        store.put(book.getId(), copy(book));
        return copy(book);
    }

    /** 단건 조회 */
    public Optional<BookDto> findById(Long id) {
        BookDto found = store.get(id);
        return Optional.ofNullable(found == null ? null : copy(found));
    }

    /** 전체 조회 (삽입 순서 유지) */
    public List<BookDto> findAll() {
        List<BookDto> list = new ArrayList<>(store.size());
        for (BookDto b : store.values()) {
            list.add(copy(b));
        }
        return list;
    }

    // 방어적 복사 (외부에서 내부 상태 변경 못 하도록)
    private BookDto copy(BookDto src) {
        return new BookDto(src.getId(), src.getTitle(), src.getAuthor(), src.getDescription(), src.getIsbn());
    }
}
