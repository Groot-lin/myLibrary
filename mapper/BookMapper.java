package cqut.cn.edu.mapper;

import cqut.cn.edu.pojo.Book;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

public interface BookMapper {
    @Select("select * from book")
    public List<Book> selectAll();


    List<Book> selectbycondition(@Param("begin") int begin,@Param("size") int size,@Param("book") Book book);
    int selectcountbycondition(@Param("book") Book book);

    @Insert("insert into book values(null,#{bookname},#{author},#{release_time},#{type},#{status})")
    void addbook(Book book);

    @Update("update book set bookname=#{bookname},author=#{author},release_time=#{release_time},type=#{type},status=#{status} where id=#{id}")
    void updatebook(Book book);

    @Delete("delete from book where id=#{id}")
    void deletebook(int id);


    void deletebyids(@Param("ids") int[] ids);

    @Select("select * from book limit #{begin},#{size}")
    List<Book> selectbypage(@Param("begin") int begin,@Param("size") int size);

    @Select("select count(*) from book")
    int selectcount();
}
