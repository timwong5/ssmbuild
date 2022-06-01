package com.timwang5.dao;

import com.timwang5.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface bookMapper {
    //����һ��Book
    int addBook(Books book);

    //����idɾ��һ��Book
    int deleteBookById(@Param("bookId") int id);

    //����Book
    int updateBook(Books books);

    //����id��ѯ,����һ��Book
    Books queryBookById(int id);

    //��ѯȫ��Book,����list����
    List<Books> queryAllBook();

    //����������ѯ�鼮
    Books queryBookByName(@Param("bookName")String bookName);
}
