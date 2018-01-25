/**
 * @author aiboleepro
 * @date 2018-01-19 下午1:23
 **/
public class CallBackImpl implements CallBack {

    @Override
    public void starTransaction() {
        System.out.println("开启事务");
    }

    @Override
    public void endTransaction() {
        System.out.println("关闭事务");
    }
}
