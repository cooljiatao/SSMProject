package me.jiatao.ssm.spring;


import me.jiatao.ssm.spring.E_AspectJAnnotation.CustomerServiceImpl;
import me.jiatao.ssm.spring.E_AspectJAnnotation.ProductService;
import me.jiatao.ssm.spring.F_JdbcTemplate.Book;
import me.jiatao.ssm.spring.F_JdbcTemplate.BookDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

//目标：测试一下spring的bean的某些功能

//junit整合spring的测试
// 立马开启了spring的注解
@RunWith(SpringJUnit4ClassRunner.class)
//加载核心配置文件，自动构建spring容器
@ContextConfiguration(locations = "classpath:applicationContextF.xml")
public class SpringJunitF {
    //注入要测试bean
    @Autowired
    @Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier("c3p0JdbcTemplate")
    private JdbcTemplate c3p0JdbcTemplate;

    @Autowired
    @Qualifier("c3p0JdbcTemplate2")
    private JdbcTemplate c3p0JdbcTemplate2;

    @Test
    public void testCreatetable() {
        jdbcTemplate.execute("create table test002(id int,name varchar(20))");
        c3p0JdbcTemplate.execute("create table test003(id int,name varchar(20))");
        c3p0JdbcTemplate2.execute("create table test004(id int,name varchar(20))");
    }


    @Autowired
    @Qualifier("bookDao")
    private BookDao bookDao;

    @Test
    public void createBook() {
        for (int i = 0; i < 10; i++) {
            Book book = new Book();
            book.setName("book" + i);
            book.setPrice(i * 10.0);

            bookDao.save(book);
        }
    }

    @Test
    public void updateBook() {
        Book book = new Book();
        book.setId(2);
        book.setName("book" + 222);
        book.setPrice(222.0);

        bookDao.update(book);
    }

    @Test
    public void deleteBook() {
        Book book = new Book();
        book.setId(2);

        bookDao.delete(book);
    }

    @Test
    public void findBook() {
        Book book = bookDao.findById(10);
        System.out.println(book);
    }

    @Test
    public void findBookCount() {
        Book book = new Book();
        book.setName("book");
        int bookCount = bookDao.findCount(book);
        System.out.println(bookCount);
    }


    @Test
    public void findAll() {
        List<Book> books = bookDao.findAll();
        for (Book book : books) {
            System.out.println(book);
        }
    }


    @Test
    public void findByCondition() {
        Book book = new Book();
        book.setName("%book%");
        List<Book> books = bookDao.findByCondition(book);
        for (Book bookItem : books) {
            System.out.println(bookItem);
        }
    }
}
