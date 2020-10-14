package com.hand.service;

import com.hand.pojo.Books;

import java.util.List;

/**
 * @author Admin
 * @date 2020-07-14 11:26
 */
public interface BooksService {
    /**
     * 添加图书
     *
     * @param books 图书信息
     */
    void addBook(Books books);

    /**
     * 删除图书
     *
     * @param bookId 图书id
     */
    void deleteBook(int bookId);

    /**
     * 修改图书
     *
     * @param books 图书信息
     */
    void updateBook(Books books);

    /**
     * 根据图书id查询图书
     *
     * @param bookId 图书id
     * @return 图书信息
     */
    Books queryByBookId(int bookId);

    /**
     * 查询图书列表
     *
     * @return 图书List
     */
    List<Books> queryBookList();

    /**
     * 根据图书名查询图书
     *
     * @param bookName 图书名
     * @return 图书信息
     */
    Books queryByBookName(String bookName);
}