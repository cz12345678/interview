package com.thunisoft.bean;

/**
 * @author chenzhen
 * @create 2019-06-24 下午 10:03
 */
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

/**
 * @author ceshi
 * @Title: Gender
 * @ProjectName ceshi
 * @Description: TODO
 * @date 2018/7/1121:58
 */
@XStreamAlias("MaxBenefitDurPeriod")
@XStreamConverter(value = ToAttributedValueConverter.class, strings = { "value" })
public class Gender {
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
