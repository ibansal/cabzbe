package cabz.common;

import java.util.Collections;
import java.util.List;

public class Utils {

	public static List getSublistForPage(List original, int count, int pos){
		if(count == 0){
			return Collections.EMPTY_LIST;
		}
		if(count < pos){
			return original;
		}
		int total = original.size();
		int thisCount = (count < (total - pos)) ? count : total - pos;
		return original.subList(pos, thisCount);	
	}
}
