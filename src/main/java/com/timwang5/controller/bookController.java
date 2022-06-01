package com.timwang5.controller;


import com.timwang5.pojo.Books;
import com.timwang5.service.bookService;
import com.timwang5.service.bookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class bookController {

    @Autowired
    @Qualifier("bookServiceImpl")
    private bookService bookService = new bookServiceImpl();

    @RequestMapping("/allBook")
    public String list(Model model) {
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list", list);
        return "allBook";
    }

    //跳转到增加书籍界面
    @RequestMapping("/toAddBook")
    public String toAddpage(){
        return "addBook";
    }

    @RequestMapping("/addBook")
    public String addPaper(Books books) {
        System.out.println(books);
        bookService.addBook(books);
        //重定向到allBook请求
        return "redirect:/book/allBook";
    }


    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(Model model, int id) {
        Books books = bookService.queryBookById(id);
        System.out.println(books);
        model.addAttribute("book",books );
        return "updateBook";
    }

    @RequestMapping("/updateBook")
    public String updateBook(Model model, Books book) {
        System.out.println(book);
        bookService.updateBook(book);
        Books books = bookService.queryBookById(book.getBookID());
        model.addAttribute("books", books);
        return "redirect:/book/allBook";
    }


    @RequestMapping("/deleteBook/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id) {
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/queryBook")
    public String queryBook(String bookName, Model model){
        Books books = bookService.queryBookByName(bookName);
        System.out.println(books);
        List<Books> queryBook = new ArrayList<Books>();
        queryBook.add(books);
        if(books == null){
            queryBook = bookService.queryAllBook();
            model.addAttribute("error","查询书籍不存在");
        }
        model.addAttribute("list",queryBook);
        return "allBook";
    }


}
