package bean;

import lombok.Data;

import javax.xml.bind.annotation.*;

/**
 * 模拟的银行实体
 *
 * @author aiboleepro
 * @date 2018-01-18 下午8:11
 **/
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@XmlType(name = "Money", propOrder = { "id","userId", "name","bankName","money"})
public class Money {

    @XmlElement
    private String id;
    @XmlElement
    private String userId;
    @XmlElement
    private String bankName;
    @XmlElement
    private String name;
    @XmlElement
    private Integer money;
}
