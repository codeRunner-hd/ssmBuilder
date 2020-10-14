package com.hand.dao;

import com.hand.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Admin
 * @date 2020-07-14 11:26
 */
public interface BooksDao {

    /**
     * 添加图书
     *
     * @param books 图书
     * @return ~
     */
    int addBook(Books books);

    /**
     * 删除图书
     *
     * @param bookId 图书Id
     * @return ~
     */
    int deleteBook(@Param("bookId") int bookId);

    /**
     * 修改图书
     *
     * @param books 图书
     * @return ~
     */
    int updateBook(Books books);

    /**
     * 根据id查询图书
     *
     * @param bookId 图书Id
     * @return 图书信息
     */
    Books queryByBookId(@Param("bookId") int bookId);

    /**
     * 查询图书列表
     *
     * @return 图书list
     */
    List<Books> queryBookList();

    /**
     * 根据图书名查询图书
     *
     * @param bookName 图书名称
     * @return 图书信息
     */
    Books queryByBookName(String bookName);
}