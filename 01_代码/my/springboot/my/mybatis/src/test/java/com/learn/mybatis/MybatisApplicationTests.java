package com.learn.mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class MybatisApplicationTests {

    @Test
    public void contextLoads() {

        Gfdsj gfdsj = new Gfdsj();
        Set<Facssj> facs_arr = gfdsj.getFacs_arr();

        Iterator<Facssj> iterator = facs_arr.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
        System.out.println(facs_arr.size());

        System.err.println("-------------------------------");
        facs_arr.add(new Facssj("工业园区"));
        facs_arr.add(new Facssj("繁华地段"));
        facs_arr.add(new Facssj("商业区"));
        facs_arr.add(new Facssj("广场"));
        facs_arr.add(new Facssj("其他繁华地段"));
        facs_arr.add(new Facssj("偏僻地段"));
        facs_arr.add(new Facssj("楼群"));
        facs_arr.add(new Facssj("贸易市场"));
        facs_arr.add(new Facssj("居民小区"));

        System.err.println();

        System.out.println(facs_arr.size());




    }


    private class Gfdsj{

        private String gfdbh;

        private String gfdmc;

        private Integer ajs;

        private String facs;

        private Set<Facssj> facs_arr = new HashSet<>(10);

        {
            facs_arr.add(new Facssj("工业园区"));
            facs_arr.add(new Facssj("繁华地段"));
            facs_arr.add(new Facssj("商业区"));
            facs_arr.add(new Facssj("广场"));
            facs_arr.add(new Facssj("其他繁华地段"));
            facs_arr.add(new Facssj("偏僻地段"));
            facs_arr.add(new Facssj("楼群"));
            facs_arr.add(new Facssj("贸易市场"));
            facs_arr.add(new Facssj("居民小区"));
        }

        public String getGfdbh() {
            return gfdbh;
        }

        public void setGfdbh(String gfdbh) {
            this.gfdbh = gfdbh;
        }

        public String getGfdmc() {
            return gfdmc;
        }

        public void setGfdmc(String gfdmc) {
            this.gfdmc = gfdmc;
        }

        public Integer getAjs() {
            return ajs;
        }

        public void setAjs(Integer ajs) {
            this.ajs = ajs;
        }

        public String getFacs() {
            return facs;
        }

        public void setFacs(String facs) {
            this.facs = facs;
        }

        public Set<Facssj> getFacs_arr() {
            return facs_arr;
        }

        public void setFacs_arr(Set<Facssj> facs_arr) {
            this.facs_arr = facs_arr;
        }

        @Override
        public String toString() {
            return "Gfdsj{" +
                    "gfdbh='" + gfdbh + '\'' +
                    ", gfdmc='" + gfdmc + '\'' +
                    ", ajs=" + ajs +
                    ", facs='" + facs + '\'' +
                    ", facs_arr=" + facs_arr +
                    '}';
        }
    }

    /**
     * 发案处所数据
     */
    private class Facssj{


        public Facssj(String csmc){
            this.csmc = csmc;
        }

        private String csmc;

        private Integer ajs = 0;

        public String getCsmc() {
            return csmc;
        }

        public void setCsmc(String csmc) {
            this.csmc = csmc;
        }

        public Integer getAjs() {
            return ajs;
        }

        public void setAjs(Integer ajs) {
            this.ajs = ajs;
        }

        @Override
        public String toString() {
            return "Facssj{" +
                    "csmc='" + csmc + '\'' +
                    ", ajs=" + ajs +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Facssj facssj = (Facssj) o;
            return Objects.equals(csmc, facssj.csmc);
        }

        @Override
        public int hashCode() {
            return Objects.hash(csmc);
        }
    }

}
