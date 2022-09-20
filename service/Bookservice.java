package cqut.cn.edu.service;

import cqut.cn.edu.mapper.BookMapper;
import cqut.cn.edu.pojo.Book;

import cqut.cn.edu.pojo.Paging;
import cqut.cn.edu.util.SqlSessionFactoryUtils;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


import java.util.Date;
import java.util.List;

public class Bookservice {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    //查询所有
    public List<Book> selectAll(){
        SqlSession sqlSession = factory.openSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        List<Book> books = bookMapper.selectAll();

        sqlSession.close();
        return books;
    }

//    //根据某项内容查询
//    public List<Book> selectbycondition(Book book){
//        SqlSession sqlSession = factory.openSession();
//        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
//        List<Book> books = bookMapper.selectbycondition(book);
//
//        sqlSession.close();
//        return books;
//    }

    //添加书籍
    public void addbook(Book book){
        SqlSession sqlSession = factory.openSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);

        bookMapper.addbook(book);

        sqlSession.commit();

        sqlSession.close();
    }

    //修改书籍信息
    public void updatebook(Book book){
        SqlSession sqlSession = factory.openSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);

        bookMapper.updatebook(book);

        sqlSession.commit();

        sqlSession.close();
    }

    //删除书籍
    public void deletebook(int id){
        SqlSession sqlSession = factory.openSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);

        bookMapper.deletebook(id);

        sqlSession.commit();

        sqlSession.close();
    }

    //批量删除
    public void deletebyids(int[] ids){
        SqlSession sqlSession = factory.openSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);

        bookMapper.deletebyids(ids);

        sqlSession.commit();

        sqlSession.close();
    }

    //分页查询
    public Paging<Book> selectbypage(int currentpage,int pagesize){
        SqlSession sqlSession = factory.openSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);

        int begin = (currentpage-1)*pagesize;
        int size = pagesize;

        List<Book> rows = bookMapper.selectbypage(begin,size);
        int count = bookMapper.selectcount();

        Paging<Book> page = new Paging();
        page.setRows(rows);
        page.setTotalcount(count);

        sqlSession.close();

        return page;
    }

    //条件查询
    public Paging<Book> selectbycondition(int currentpage,int pagesize,Book book){
        SqlSession sqlSession = factory.openSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);

        int begin = (currentpage-1)*pagesize;
        int size = pagesize;

        //模糊查询处理字符串
        String bookname = book.getBookname();
        if(bookname!=null&&bookname.length()>0)
            book.setBookname("%"+bookname+"%");
        String author = book.getAuthor();
        if(author!=null&&author.length()>0)
            book.setAuthor("%"+author+"%");

        
        List<Book> rows = bookMapper.selectbycondition(begin,size,book);
        int count = bookMapper.selectcountbycondition(book);
        System.out.println(count);

        Paging<Book> page = new Paging();
        page.setRows(rows);
        page.setTotalcount(count);

        sqlSession.close();

        return page;
    }
}
