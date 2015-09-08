import java.io.File;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;


public class ReadingXml {

	public JSONArray readingFile(String filenamewidpath)
	{
		JSONArray jsArray= new JSONArray();
		try
		{
		File file=new File(filenamewidpath);
		
		String str=FileUtils.readFileToString(file,"UTF8");
		JSONParser parser=new JSONParser();
		Object obj=parser.parse(str);
		 jsArray=(JSONArray) obj;
		return jsArray;
		}catch(Exception e)
		{
			e.printStackTrace();
			System.exit(0);
		}
		return jsArray;
		
	}
}
