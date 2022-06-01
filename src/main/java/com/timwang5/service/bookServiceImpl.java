package com.timwang5.service;

import com.timwang5.dao.bookMapper;
import com.timwang5.pojo.Books;

import java.util.List;

public class bookServiceImpl implements bookService{

    //Service²ãµ÷Dao²ã
    private bookMapper bookMapper;

    public void setBookMapper(com.timwang5.dao.bookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public int addBook(Books book) {
        return bookMapper.addBook(book);
    }

    @Override
    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    @Override
    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    @Override
    public Books queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }

    @Override
    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }

    @Override
    public Books queryBookByName(String bookName) {
        return bookMapper.queryBookByName(bookName);
    }
}
