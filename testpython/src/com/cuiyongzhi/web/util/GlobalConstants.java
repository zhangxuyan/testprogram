package com.cuiyongzhi.web.util;
import java.util.Properties;
import org.springframework.stereotype.Component;

/**
 * ClassName: GlobalConstants
 * @Description: ��ȡ�����ļ�����
 * @author XiaoJiu
 * @date 2017-10-19
 */

@Component
public class GlobalConstants {
	
	public static Properties interfaceUrlProperties;
	
	 public static String getInterfaceUrl(String key) {
	        return (String) interfaceUrlProperties.get(key);
	    }
}