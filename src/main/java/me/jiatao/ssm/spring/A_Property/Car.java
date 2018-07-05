package me.jiatao.ssm.spring.A_Property;

public class Car {
    private Integer id;
    private String name;
    private Double price;

    //有参构造
    public Car(Integer id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    //取值要用getter
    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Car [id=" + id + ", name=" + name + ", price=" + price + "]";
    }

}
