package testpyton;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arguments = new String[] {"python", "C:\\Users\\chenyonghong\\NetworkCardInfo\\networkcardinfo\\test.py", "c://1", "1.txt","ÄÐ"};
     //String[] arguments=new String[]{"python -c C:\\Users\\chenyonghong\\NetworkCardInfo\\networkcardinfo\\BridgeNetwork.py BridgeNetwork.py.creatfile(c:\\1, 1.txt,123)"};
		
		try {
            Process process = Runtime.getRuntime().exec(arguments);
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = null;  
          while ((line = in.readLine()) != null) {  
              System.out.println(line);  
          }  
          in.close();  
          int re = process.waitFor();  
          System.out.println(re);
        } catch (Exception e) {
            e.printStackTrace();
        }  

	}

}
