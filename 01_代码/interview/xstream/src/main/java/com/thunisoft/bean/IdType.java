package com.thunisoft.bean;

/**
 * @author chenzhen
 * @create 2019-06-24 下午 10:02
 */
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

/**
 * @author ceshi
 * @Title: IdType
 * @ProjectName ceshi
 * @Description: TODO
 * @date 2018/7/1121:56
 */
@XStreamAlias("MaxBenefitDurPeriod")
@XStreamConverter(value = ToAttributedValueConverter.class, strings = { "value" })
public class IdType {
    //// 将name作为Cat属性输出在父节点
    @XStreamAsAttribute()
    private String name;
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
