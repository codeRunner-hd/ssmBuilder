package com.hand.controller;

import com.hand.pojo.Books;
import com.hand.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Admin
 * @date 2020-07-14 11:26
 */
@Controller
@RequestMapping("/book")
public class BooksController {

    @Autowired
    @Qualifier("BookServiceImpl")
    private BooksService booksService;

    /**
     * 查询所有图书
     *
     * @param model ~
     * @return 图书列表页面
     */
    @RequestMapping("/allBook")
    public String allBook(Model model) {
        List<Books> list = booksService.queryBookList();
        model.addAttribute("list", list);
        return "allBook";
    }

    /**
     * 跳转添加图书
     *
     * @return 添加图书页面
     */
    @RequestMapping("/toAddBook")
    public String toAddBook() {
        return "addBook";
    }

    /**
     * 添加图书
     *
     * @param books 图书信息
     * @return 图书列表页面
     */
    @RequestMapping("/addBook")
    public String addBook(Books books) {
        booksService.addBook(books);
        return "redirect:/book/allBook";
    }

    /**
     * 跳转修改图书页面
     *
     * @param model ~
     * @param id    图书编号
     * @return 修改图书页面
     */
    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(Model model, int id) {
        Books books = booksService.queryByBookId(id);
        model.addAttribute("book", books);
        return "updateBook";
    }

    /**
     * 修改图书
     *
     * @param model ~
     * @param book  图书信息
     * @return 图书列表页面
     */
    @RequestMapping("/updateBook")
    public String updateBook(Model model, Books book) {
        booksService.updateBook(book);
        Books books = booksService.queryByBookId(book.getBookId());
        model.addAttribute("books", books);
        return "redirect:/book/allBook";
    }

    /**
     * 删除图书
     *
     * @param id 图书编号
     * @return 图书列表页面
     */
    @RequestMapping("/del/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id) {
        booksService.deleteBook(id);
        return "redirect:/book/allBook";
    }

    /**
     * 查询图书
     *
     * @param bookName 根据图书名称查询
     * @param model    ~
     * @return 图书列表页面
     */
    @RequestMapping("/queryBook")
    public String queryBook(String bookName, Model model) {
        List<Books> list = new ArrayList<Books>();
        Books books = booksService.queryByBookName(bookName);
        if (books == null) {
            list = booksService.queryBookList();
            model.addAttribute("error", "对不起，没有找到这本书！");
        } else {
            list.add(books);
        }
        model.addAttribute("list", list);
        return "allBook";
    }
}