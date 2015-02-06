package cabz.common;

import java.util.ArrayList;
import java.util.List;


public class JsonRestObject {

    private Integer id;
    private String name;
    private List<String> relatedObjects = new ArrayList<String>();

    public JsonRestObject(Boolean success) {
    	if(success){
    		name = "Successfully updated/created content";
    	}else{
    		name = "Failed";
    	}
    }

    public JsonRestObject(Integer id) {
    	id = id;
    }
    
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getRelatedObjects() {
        return relatedObjects;
    }
}
