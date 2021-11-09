package util;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonTransformation {
    private static Gson gson = new Gson();
    /**
     * @Description //TODO 对象转Json
     * @Param 
     * @return 
     **/
    public String ObjToGson (Object obj){
        return gson.toJson(obj);
    }
    /**
     * @Description //TODO Json转对象
     * @Param str Jsonzifu串
     * @Param obj 对象
     * @return
     **/
    public Object JsonToObj(String str,Object obj){
        return gson.fromJson(str,obj.getClass());
    }
    /**
     * @Description //TODO Json转List
     * @Date 23:40 2020/12/8
     * @Param
     * @return
     **/
    public List<Object> JsonToList(String str){
        return gson.fromJson(str,new TypeToken<List<Object>>() { }.getType());
    }
    /**
     * @Description //TODO List转Gson
     * @Param
     * @return
     **/
    public String ListToJson(List list){
        return gson.toJson(list);
    }
    /**
     * @Description //TODO Json转Map
     * @Param
     * @return
     **/
    public Map<Object,Object> JsonToMap(String str){
        return gson.fromJson(str,new TypeToken<HashMap<Object,Object>>() { }.getType());
    }
    /**
     * @Description //TODO Map转Gson
     * @Date 23:42 2020/12/8
     * @Param
     * @return
     **/
    public String MapToJson(Map map){
        return gson.toJson(map);
    }
}
