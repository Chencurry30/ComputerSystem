package com.sicnu.boot.utils;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/11/15 22:07
 */
@Component
@Data
public class QuestionUtils {
    private List<Map<String,Object>> typeList;
    private List<Map<String,Object>> difficultList;
    private List<Map<String,Object>> sourceList;
    private List<Map<String,Object>> yearList;

    {
        typeList = getTypeLists();
        difficultList = getDifficultLists();
        sourceList = getSourceLists();
        yearList = getYearLists();
    }

    public List<Map<String,Object>> getTypeLists(){
        List<Map<String,Object>> list = new ArrayList<>();
        list.add(getTypeMap(0,"全部",0));
        list.add(getTypeMap(1,"单选题",1));
        list.add(getTypeMap(2,"多选题",2));
        list.add(getTypeMap(3,"填空题",3));
        list.add(getTypeMap(4,"解答题",4));
        return list;
    }

    public List<Map<String,Object>> getDifficultLists(){
        List<Map<String,Object>> list = new ArrayList<>();
        list.add(getDifficultMap(0,"全部", BigDecimal.valueOf(0),BigDecimal.valueOf(0)));
        list.add(getDifficultMap(1,"易",BigDecimal.valueOf(0.1),BigDecimal.valueOf(0.3)));
        list.add(getDifficultMap(2,"较易",BigDecimal.valueOf(0.4),BigDecimal.valueOf(0.5)));
        list.add(getDifficultMap(3,"中等",BigDecimal.valueOf(0.6),BigDecimal.valueOf(0.7)));
        list.add(getDifficultMap(4,"难",BigDecimal.valueOf(0.8),BigDecimal.valueOf(0.9)));
        return list;
    }

    public List<Map<String,Object>> getSourceLists(){
        List<Map<String,Object>> list = new ArrayList<>();
        list.add(getSourceMap(0,"全部",""));
        list.add(getSourceMap(1,"自主招生","自主招生"));
        list.add(getSourceMap(2,"408","408"));
        list.add(getSourceMap(3,"考研真题","考研真题"));
        return list;
    }

    public List<Map<String,Object>> getYearLists(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<Map<String,Object>> list = null;
        try {
            list = new ArrayList<>();
            list.add(getYearMap(0,"全部",null));
            list.add(getYearMap(1,"2022",sdf.parse("2022-01-02")));
            list.add(getYearMap(2,"2021",sdf.parse("2021-01-02")));
            list.add(getYearMap(3,"2020",sdf.parse("2020-01-02")));
            list.add(getYearMap(4,"2019",sdf.parse("2019-01-02")));
            list.add(getYearMap(5,"2018",sdf.parse("2018-01-02")));
            list.add(getYearMap(6,"2017",sdf.parse("2017-01-02")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return list;
    }



    private Map<String,Object> getTypeMap(Integer typeId, String typeName, Integer typeValue){
        Map<String,Object> map = new HashMap<>(3);
        map.put("id",typeId);
        map.put("name",typeName);
        map.put("typeId",typeId);
        map.put("typeName",typeName);
        map.put("typeValue",typeValue);
        return map;
    }

    private Map<String,Object> getDifficultMap(Integer difficultId, String difficultName, BigDecimal difficultMinValue,BigDecimal difficultMaxValue){
        Map<String,Object> map = new HashMap<>(3);
        map.put("id",difficultId);
        map.put("name",difficultName);
        map.put("difficultId",difficultId);
        map.put("difficultName",difficultName);
        map.put("difficultMinValue",difficultMinValue);
        map.put("difficultMaxValue",difficultMaxValue);
        return map;
    }

    private Map<String,Object> getSourceMap(Integer sourceId,String sourceName,String sourceValue){
        Map<String,Object> map = new HashMap<>(3);
        map.put("id",sourceId);
        map.put("name",sourceName);
        map.put("sourceId",sourceId);
        map.put("sourceName",sourceName);
        map.put("sourceValue",sourceValue);
        return map;
    }

    private Map<String,Object> getYearMap(Integer yearId, String yearName, Date yearValue){
        Map<String,Object> map = new HashMap<>(3);
        map.put("id",yearId);
        map.put("name",yearName);
        map.put("yearId",yearId);
        map.put("yearName",yearName);
        map.put("yearValue",yearValue);
        return map;
    }

    public Integer getTypeById(Integer typeId){
        for (Map<String, Object> map : getTypeLists()) {
            if (map.get("typeId") == typeId){
                return (Integer) map.get("typeValue");
            }
        }
        return null;
    }

    public BigDecimal getDifficultMinById(Integer difficultId){
        for (Map<String, Object> map : getDifficultLists()) {
            if (map.get("difficultId") == difficultId){
                return (BigDecimal) map.get("difficultMinValue");
            }
        }
        return null;
    }

    public BigDecimal getDifficultMaxById(Integer difficultId){
        for (Map<String, Object> map : getDifficultLists()) {
            if (map.get("difficultId") == difficultId){
                return (BigDecimal) map.get("difficultMaxValue");
            }
        }
        return null;
    }

    public String getSourceById(Integer sourceId){
        for (Map<String, Object> map : getSourceLists()) {
            if (map.get("sourceId") == sourceId){
                return (String) map.get("sourceValue");
            }
        }
        return null;
    }

    public Date getYearById(Integer yearId){
        for (Map<String, Object> map : getYearLists()) {
            if (map.get("yearId") == yearId){
                return (Date) map.get("yearValue");
            }
        }
        return null;
    }
}
