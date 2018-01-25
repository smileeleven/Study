/**
 * 转账业务
 *
 * @author aiboleepro
 * @date 2018-01-19 下午1:09
 **/
abstract class Transfer {

    /**
     * 确认双方账户
     * */
    abstract void affirm(String userAId, String userBId, Integer money);

    /**
     * 执行转账操作
     * */
    protected void transferMoney(String userAId, String userBId, Integer money){
        System.out.println("将A的"+money+"元转到B的账户上了");
    }

    /**
     * 完成后进行检查
     * */
    abstract void check(String userAId, String userBId, Integer money);


    public void execute(String userAId, String userBId, Integer money, CallBack callBack){
        callBack.starTransaction();
        this.affirm(userAId,userBId,money);
        this.transferMoney(userAId,userBId,money);
        this.check(userAId,userBId,money);
        callBack.endTransaction();
    }



}
