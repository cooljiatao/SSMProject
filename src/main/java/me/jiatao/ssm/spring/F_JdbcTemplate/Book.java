package me.jiatao.ssm.spring.F_JdbcTemplate;

/**
 * -- ----------------------------
 * -- Table structure for book
 * -- ----------------------------
 * DROP TABLE IF EXISTS `book`;
 * CREATE TABLE `book` (
 *   `id` int(11) NOT NULL AUTO_INCREMENT,
 *   `name` varchar(50) DEFAULT NULL,
 *   `price` double DEFAULT NULL,
 *   PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */

public class Book {

    private Integer id;
    private String name;
    private Double price;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    public String toString() {
        return "Book [id=" + id + ", name=" + name + ", price=" + price + "]";
    }

}
