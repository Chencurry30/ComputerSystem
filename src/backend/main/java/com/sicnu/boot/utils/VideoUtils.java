package com.sicnu.boot.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * description:  视频筛选的工具类
 *
 * @author :  胡建华
 * Data:    2022/10/25 16:59
 */
public class VideoUtils {
    /**
     * description: 返回视频筛选列表的时长筛选
     *
     * @return List<Map<String,Object>>
     * @author 胡建华
     * Date:  2022/10/25 17:12
     */
    public static List<Map<String,Object>> getDurationList(){
        List<Map<String,Object>> list = new ArrayList<>();
        list.add(getDurationMap(0,"全部",0));
        list.add(getDurationMap(1,"小于10分钟",10));
        list.add(getDurationMap(2,"小于半个小时",30));
        list.add(getDurationMap(3,"小于一个小时",60));
        list.add(getDurationMap(4,"小于两个小时",120));
        return list;
    }

    public static Integer getDurationById(Integer durationId){
        for (Map<String, Object> map : getDurationList()) {
            if (map.get("durationId") == durationId){
                return (Integer) map.get("durationValue");
            }
        }
        return null;
    }

    public static List<Map<String,Object>> getSortList(){
        List<Map<String,Object>> list = new ArrayList<>();
        list.add(getSortMap(0,"全部",""));
        list.add(getSortMap(1,"时长","duration"));
        list.add(getSortMap(2,"上传时间","time"));
        list.add(getSortMap(3,"播放量","view_num"));
        list.add(getSortMap(4,"评论人数","comment_num"));
        return list;
    }

    public static String getSortById(Integer sortId){
        for (Map<String, Object> map : getSortList()) {
            if (map.get("sortId") == sortId){
                return (String) map.get("sortValue");
            }
        }
        return null;
    }

    private static Map<String,Object> getSortMap(Integer sortId,String sortName,String sortValue){
        Map<String,Object> map = new HashMap<>(3);
        map.put("id",sortId);
        map.put("name",sortName);
        map.put("sortId",sortId);
        map.put("sortName",sortName);
        map.put("sortValue",sortValue);
        return map;
    }

    private static Map<String,Object> getDurationMap(Integer durationId,String durationName,Integer durationValue){
        Map<String,Object> map = new HashMap<>(3);
        map.put("id",durationId);
        map.put("name",durationName);
        map.put("durationId",durationId);
        map.put("durationName",durationName);
        map.put("durationValue",durationValue);
        return map;
    }


}
