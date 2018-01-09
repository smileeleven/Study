/**
 * 客车
 * @author aiboleepro
 * @date 2018-01-08 下午12:36
 **/
public class Coach extends Car{

    private Integer number;

    Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    void show() {
        System.out.println("我是客车 id:" + super.getId() + " | 价格:" + super.getPrice() + " | 载客:" + this.getNumber());
    }

    @Override
    Double rent(int day) {
        return day * super.getPrice();
    }
}
