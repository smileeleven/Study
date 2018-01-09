import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author aiboleepro
 * @date 2018-01-08 下午1:16
 **/
public class Main {

    public static void main(String[] s) {
        String endFlag = "##";
        List<Car> cars = init();
        System.out.println("：：：：开始租车：：：：(输入回车开始选择)");
        Double money = 0.0;
        Scanner end = new Scanner(System.in,"UTF-8");
        while (!(endFlag).equals(end.nextLine())) {
            System.out.println("请选择车辆id:");
            Scanner in = new Scanner(System.in,"UTF-8");
            int id = in.nextInt();
            if (id >= cars.size()) {
                System.out.println("列表里没有该车，请重新选择");
            } else {
                System.out.println("请输入天数：");


                int day = in.nextInt();
                money += cars.get(id).rent(day);
            }
            System.out.println("回车选择下一辆，输入'##'结束");
        }
        System.out.println("总金额为：" + money);
    }

    private static List<Car> init() {

        Coach coach1 = new Coach();
        coach1.setNumber(20);
        coach1.setName("第一辆客车");
        coach1.setPrice(20.0);
        Coach coach2 = new Coach();
        coach2.setNumber(15);
        coach2.setName("第二辆客车");
        coach2.setPrice(15.0);
        Trucks trucks1 = new Trucks();
        trucks1.setCarry(20.0);
        trucks1.setName("第一辆货车");
        trucks1.setPrice(200.0);
        Trucks trucks2 = new Trucks();
        trucks2.setCarry(23.0);
        trucks2.setName("第二辆货车");
        trucks2.setPrice(201.0);
        Trucks trucks3 = new Trucks();
        trucks3.setCarry(22.0);
        trucks3.setName("第三辆货车");
        trucks3.setPrice(203.0);

        List<Car> cars = new ArrayList<>();
        cars.add(coach1);
        cars.add(coach2);
        cars.add(trucks1);
        cars.add(trucks2);
        cars.add(trucks3);

        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).setId(i);
            cars.get(i).show();
        }

        return cars;
    }

}
