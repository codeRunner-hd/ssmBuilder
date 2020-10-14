package com.hand.service.impl;

import com.hand.dao.BooksDao;
import com.hand.pojo.Books;
import com.hand.service.BooksService;

import java.util.List;

/**
 * @author Admin
 * @date 2020-07-14 13:35
 */
public class BooksServiceImpl implements BooksService {
    private BooksDao booksDao;

    public void setBooksDao(BooksDao booksDao) {
        this.booksDao = booksDao;
    }

    /**
     * 添加图书
     *
     * @param books 图书
     */
    @Override
    public void addBook(Books books) {
        booksDao.addBook(books);
    }

    /**
     * 删除图书
     *
     * @param bookId 图书id
     */
    @Override
    public void deleteBook(int bookId) {
        booksDao.deleteBook(bookId);
    }

    /**
     * 修改图书
     *
     * @param books 图书
     */
    @Override
    public void updateBook(Books books) {
        booksDao.updateBook(books);
    }

    /**
     * 根据id查询图书
     *
     * @param bookId 图书id
     * @return 图书信息
     */
    @Override
    public Books queryByBookId(int bookId) {
        return booksDao.queryByBookId(bookId);
    }

    /**
     * 查询图书列表
     *
     * @return 图书列表
     */
    @Override
    public List<Books> queryBookList() {
        return booksDao.queryBookList();
    }

    /**
     * 根据图书名查询图书
     *
     * @param bookName 图书名
     * @return 图书信息
     */
    @Override
    public Books queryByBookName(String bookName) {
        return booksDao.queryByBookName(bookName);
    }
}