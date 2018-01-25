import bean.Money;
import bean.RequestParam;
import util.JaxbUtil;

/**
 * 针对P2B的worker
 *
 * @author aiboleepro
 * @date 2018-01-18 下午8:39
 **/
public class WorkerB extends Worker {

    private RequestParam requestParam;

    public WorkerB(RequestParam requestParam){
        this.requestParam = requestParam;
    }

    @Override
    public Money call() throws Exception {
        String xml = JaxbUtil.convertToXml(requestParam);
        String resultXml = SoketUtil.request(xml);
        return JaxbUtil.convertToJavaBean(resultXml,Money.class);
    }
}