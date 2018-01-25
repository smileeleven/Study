package bean;

import lombok.Data;

import javax.xml.bind.annotation.*;

/**
 * @author aiboleepro
 * @date 2018-01-18 下午8:12
 **/
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@XmlType(name = "MoneyParam", propOrder = { "userId","bankName"})
public class RequestParam {

    @XmlElement
    private String userId;
    @XmlElement
    private String bankName;

}
