package purchaseOrder_data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.io.FileUtils;

public class JsonReader {

	
	public List<HashMap<String, String>> getJsonData() throws IOException {
		//common.io
		File file = new File("C:\\Users\\saiki\\OneDrive\\Desktop\\New folder\\maven project\\Ecom\\src\\test\\java\\purchaseOrder_data\\PurchaseOrder.json");
		String jsonContent = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		
		List<HashMap<String,String>> data=mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){});
	 return data;
	}	
	
}
/*new TypeReference<>() {} creates an anonymous subclass.
This is necessary because the generic type is stored in the subclass so Jackson can read it using reflection.

So without {} → the generic information is lost during compilation so {} are used as subclass to store generic data*/
