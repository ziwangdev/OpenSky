package external;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import com.monkeylearn.ExtraParam;
import com.monkeylearn.MonkeyLearn;
import com.monkeylearn.MonkeyLearnResponse;
import com.monkeylearn.MonkeyLearnException;

public class MonkeyLearnClient {
	
	private static final String API_KEY = "938d157671fe3b24a0919e042fbcb83ff0ccbfa6";
	private static final String MODEL_ID = "ex_YCya9nrn";
	
    public static void main( String[] args ) throws MonkeyLearnException {
        MonkeyLearn ml = new MonkeyLearn(API_KEY);
        String[] data = {"Elon Musk has shared a photo of the spacesuit designed by SpaceX. This is the second image shared of the new design and the first to feature the spacesuit’s full-body look."};
        
        List<List<String>> words = extractKeywords(data);
        for(List<String> ws : words) {
        	for(String w : ws) {
        		System.out.println(w);
        	}
        	System.out.println();
        }
        
        MonkeyLearnResponse res = ml.extractors.extract(MODEL_ID, data);
        System.out.println( res.arrayResult );
    }
    
    public static List<List<String>> extractKeywords(String[] text){
    	if(text == null || text.length == 0) {
    		return new ArrayList<>();
    	}
    	// Use the API key from your account
		MonkeyLearn ml = new MonkeyLearn(API_KEY);

		// Use the keyword extractor
		ExtraParam[] extraParams = { new ExtraParam("max_keywords", "3") };
		MonkeyLearnResponse response;
		try {
			response = ml.extractors.extract(MODEL_ID, text, extraParams);
			JSONArray resultArray = response.arrayResult;
			return getKeywords(resultArray);
		} catch (MonkeyLearnException e) {// it’s likely to have an exception
			e.printStackTrace();
		}

    	return null;
    }
    
    private static List<List<String>> getKeywords(JSONArray resultArray) {
    	List<List<String>> topKeywords = new ArrayList<>();
    	// i represents 20 job descriptions
    	for(int i = 0; i < resultArray.size(); i++) {
    		
    		List<String> keywords = new ArrayList<>();
    		// every job description has j keywords
    		JSONArray keywordsArray = (JSONArray) resultArray.get(i);
    		for(int j = 0; j < keywordsArray.size(); j++) {
    			JSONObject object = (JSONObject) keywordsArray.get(j);
    			String keyword = (String) object.get("keyword");
    			keywords.add(keyword);
    		}
    		
    		topKeywords.add(keywords);
    	}
    	return topKeywords;
    }
}