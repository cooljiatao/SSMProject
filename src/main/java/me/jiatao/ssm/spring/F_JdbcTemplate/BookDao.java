package me.jiatao.ssm.spring.F_JdbcTemplate;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BookDao extends JdbcDaoSupport {

    //注入jdbctempate
//	private JdbcTemplate jdbcTemplate;
//	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//		this.jdbcTemplate = jdbcTemplate;
//	}

    //保存图书
    public void save(Book book) {
        String sql = "insert into book values(null,?,?)";
        //调用jdbctemplate
//		jdbcTemplate.update(sql, book.getName(),book.getPrice());
        super.getJdbcTemplate().update(sql, book.getName(), book.getPrice());
    }

    //更新
    public void update(Book book) {
        String sql = "update book set name =? ,price =? where id =?";
        super.getJdbcTemplate().update(sql, book.getName(), book.getPrice(), book.getId());
    }

    //删除
    public void delete(Book book) {
        super.getJdbcTemplate().update("delete from book where id =?", book.getId());
    }


    //根据id查询一个
    public Book findById(Integer id) {
//        return super.getJdbcTemplate().queryForObject("select * from book where id =?",  ParameterizedBeanPropertyRowMapper.newInstance(Book.class),id);
        return super.getJdbcTemplate().queryForObject("select * from book where id =?", BeanPropertyRowMapper.newInstance(Book.class), id);
    }

    //查询图书的数量
    public int findCount(Book book) {
//		return super.getJdbcTemplate().queryForInt("select count(*) from book");
//      return super.getJdbcTemplate().queryForInt("select count(*) from book where name like ?","%"+book.getName()+"%");

        return super.getJdbcTemplate().queryForObject("select count(*) from book where name like ?", new Object[]{"%" + book.getName() + "%"}, Integer.class);
    }


    /**
     * 查询所有
     * <p>
     * 如果表中列非常多，而且列名和属性名一样 ，使用反射代码简化
     * BeanPropertyRowMapper 自动匹配
     */
    public List<Book> findAll() {
        return super.getJdbcTemplate().query("select * from book", BeanPropertyRowMapper.newInstance(Book.class));
    }

    /**
     * 复杂条件查询列表
     * <p>
     * 如果表中列很少，字段列名称和属性名不一样，可以使用自定义RowMapper的方式装配bean：
     * 使用new BookRowMapper() 手动装配
     */

    public List<Book> findByCondition(Book book) {
        return super.getJdbcTemplate().query("select * from book where name like ?", new BookRowMapper(), book.getName());

    }

    /**
     *  自定义的手动装配的类
     */
    class BookRowMapper implements RowMapper<Book> {
        //参数1：自动将查询出来的结果集传进来
        //返回是：封装好的数据对象
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            Book book = new Book();
            //取当前指针的结果集
            book.setId(rs.getInt(1));
            book.setName(rs.getString(2));
            book.setPrice(rs.getDouble(3));
            return book;
        }

    }


}
