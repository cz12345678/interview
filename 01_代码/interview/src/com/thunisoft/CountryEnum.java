package com.thunisoft;

/**
 * @author chenzhen-1
 * @create 2019-06-02 9:41
 *
 *  枚举---六国
 */
public enum CountryEnum {

    ONE(1,"齐"), TWO(2,"楚"), THREE(3,"燕"), FOUR(4,"赵"), FIVE(5,"魏"),SIX(6,"韩");

    private Integer code;

    private String name;

    CountryEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static CountryEnum forEach_CountryEnum(Integer index){
        CountryEnum[] myArray = CountryEnum.values();// 枚举自带的方法

        for (CountryEnum country:  myArray) {
            if (index.equals(country.getCode())){
                return country;
            }
        }
        return null;
    }

}
