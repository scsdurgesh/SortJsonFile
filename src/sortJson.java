
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class sortJson {
	public static void main(String ...ar)
	{
		String InPath="C:/Users/Durgesh/Desktop/ESMO data/UnsortIdx/";
		String outPath="C:/Users/Durgesh/Desktop/ESMO data/SortIdx/";
		File folder = new File(InPath);
        File[] listOfFiles = folder.listFiles();
        
        
			for(int i=0; i<listOfFiles.length;i++)
			{
				JSONArray Arr=new JSONArray();
				ReadingXml read=new ReadingXml();
				Arr=read.readingFile(InPath+listOfFiles[i].getName());
				List<JSONObject> jsonVal= new ArrayList<JSONObject>();
					for(int j=0; j<Arr.size();j++)
					{
						jsonVal.add((JSONObject) Arr.get(j));
					}
				Collections.sort(jsonVal, new Comparator<JSONObject>() {
					
					private static final String KEY_NAME = "name";
					@Override
					public int compare(JSONObject a, JSONObject b) {
						// TODO Auto-generated method stub
						String valA=new String();
						String valB=new String();
						String rvalA= new String();
						String rvalB= new String();
						 try {
				                valA = (String) a.get(KEY_NAME);
				                valB = (String) b.get(KEY_NAME);
				               
				                rvalA=valA.replace("�", "O");
				                rvalB=valB.replace("�", "O");
				                rvalA=rvalA.replace("�","U");
				                rvalB=rvalB.replace("�","U");
				                rvalA=rvalA.replace("�","o");
				                rvalB=rvalB.replace("�","o");
				                rvalA=rvalA.replace("�","u");
				                rvalB=rvalB.replace("�","u");
				                rvalA=rvalA.replace("�","a");
				                rvalB=rvalB.replace("�","a");
				                
				            } 
				            catch (Exception e) {
				                //do something
				            }
						 	
				            return rvalA.compareToIgnoreCase(rvalB);
					}
				});
				
				FileWritewithUTF8 file=new FileWritewithUTF8();
				file.fileWrite(outPath, jsonVal,listOfFiles[i].getName());
				System.out.println("Done");
			}
	
		
		}
}
