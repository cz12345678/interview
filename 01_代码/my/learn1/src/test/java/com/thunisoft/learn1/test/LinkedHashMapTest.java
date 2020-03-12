package src.com.atguigi.my.test;

import java.util.*;

/**
 * LinkedHashMap测试，LinkedHashMap可以保证Map的遍历顺序不便
 */
public class LinkedHashMapTest {

    public static void main(String[] args) {


        Map<String, Object> data = new LinkedHashMap<>();

        Map<String, Object> zcjd = new HashMap<>();
        zcjd.put("jdmc","侦查阶段");
        zcjd.put("sl",208);
        zcjd.put("bfb",0.42);

        List<Map<String, Object>> zcjdList = new ArrayList<>();

        zcjdList.add(getCqjdfb("审查逮捕","批准/不批准逮捕决定反馈",136, 0.66));
        zcjdList.add(getCqjdfb("不捕复议","发送维持或变更原不捕决定",72, 0.34));

        zcjd.put("jdpm", zcjdList);

        Map<String, Object> scqsjd = new HashMap<>();
        scqsjd.put("jdmc","审查起诉阶段");
        scqsjd.put("sl",106);
        scqsjd.put("bfb",0.21);
        List<Map<String, Object>> scqsjdList = new ArrayList<>();

        scqsjdList.add(getCqjdfb("移送审查起诉","补充后移送审查起诉",62,0.60));
        scqsjdList.add(getCqjdfb("移送审查起诉","改变管辖通知",30,0.30));
        scqsjdList.add(getCqjdfb("不诉复核","维持或变更原不起诉决定",14,0.10));

        scqsjd.put("jdpm", scqsjdList);

        Map<String, Object> spjd = new HashMap<>();
        spjd.put("jdmc","审判阶段");
        spjd.put("sl",90);
        spjd.put("bfb",0.18);
        List<Map<String, Object>> spjdList = new ArrayList<>();

        spjdList.add(getCqjdfb("一审公诉","变更羁押期限",63, 0.7));
        spjdList.add(getCqjdfb("二审上诉","送达结案文书",15, 0.16));
        spjdList.add(getCqjdfb("二审抗诉","送达结案文书",9, 0.1));
        spjdList.add(getCqjdfb("一审公诉","结案",3, 0.04));

        spjd.put("jdpm", spjdList);

        Map<String, Object> zxjd = new HashMap<>();
        zxjd.put("jdmc","执行阶段");
        zxjd.put("sl",90);
        zxjd.put("bfb",0.19);
        List<Map<String, Object>> zxjdList = new ArrayList<>();

        zxjdList.add(getCqjdfb("减刑假释","发送送达回证",81,0.9));
        zxjdList.add(getCqjdfb("委托调查","申请委托调查或居住地核实",9,0.1));

        zxjd.put("jdpm", zxjdList);


        Map<String, Object> qt = new HashMap<>();
        qt.put("jdmc","其他");
        qt.put("sl",0);
        qt.put("bfb",0);
        qt.put("jdpm",0);

        data.put("zcjd",zcjd);
        data.put("scqsjd",scqsjd);
        data.put("spjd",spjd);
        data.put("zxjd",zxjd);
        data.put("qt",qt);


        Iterator<Map.Entry<String, Object>> iterator = data.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Object> next = iterator.next();
            System.err.println(next.getKey() + "===========>" + next.getValue());
        }

    }

    private static Map<String, Object> getCqjdfb( String ywmc, String ywjdmc, Integer cqcs, double percent){
        Map<String, Object> map = new HashMap<>();
        map.put("ywmc", ywmc); // 业务名称
        map.put("ywjdmc",ywjdmc); // 业务节点名称
        map.put("cqcs", cqcs); // 业务节点超期次数
        map.put("percent", percent);
        return map;
    }

}
