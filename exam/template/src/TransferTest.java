
/**
 * @author aiboleepro
 * @date 2018-01-19 下午1:17
 **/
public class TransferTest extends Transfer{


    @Override
    void affirm(String userAId, String userBId, Integer money) {
        System.out.println("我已经确认用户A及用户B的账户了");
    }

    @Override
    void check(String userAId, String userBId, Integer money) {
        System.out.println("我已经检查用户A及用户B的账户了");
    }

    public static void main(String[] args) {
        TransferTest transferTest = new TransferTest();
        transferTest.execute("1","2",200, new CallBackImpl());
    }
}
