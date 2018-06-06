package com.test;

import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;



import java.io.File;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;

import javax.management.MBeanServerConnection;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import com.sun.management.OperatingSystemMXBean;


public class test {
	private static final int CPUTIME = 500;  
	 private static final int PERCENT = 100;  
	  private static final int FAULTLENGTH = 10; 

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		 System.out.println(getIpAddress());
		 System.out.println(getMemery());
		 
	}

	private static  void getSystemTime() {

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		System.out.println(df.format(new Date()));// new Date()为获取当前系统时间

	}

	private static  void getInputTime() {
		// long timeStamp = 1495777335060;//直接是时间戳
		long timeStamp = System.currentTimeMillis(); // 获取当前时间戳,也可以是你自已给的一个随机的或是别人给你的时间戳(一定是long型的数据)
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 这个是你要转成后的时间的格式
		String sd = sdf.format(new Date(Long.parseLong(String.valueOf(timeStamp)))); // 时间戳转换成时间
		System.out.println(sd);// 打印出你要的时间

		// 结果就是: 2017-05-26 13:42:15

	}
	
	
	private static String getIpAddress() throws UnknownHostException {  
		         InetAddress address = InetAddress.getLocalHost();  
	   
		         return address.getHostAddress();  
	     }  
	
	
	// 获得cpu使用率  
//	    public static String getCpuRatioForWindows() {  
//	  
////	        try {  
////	            String procCmd = System.getenv("windir")  
////	                   + "\\system32\\wbem\\wmic.exe process get Caption,CommandLine,KernelModeTime,ReadOperationCount,ThreadCount,UserModeTime,WriteOperationCount";  
////	            // 取进程信息  
////	            long[] c0 = readCpu(Runtime.getRuntime().exec(procCmd));  
////	            Thread.sleep(CPUTIME);  
////	            long[] c1 = readCpu(Runtime.getRuntime().exec(procCmd));  
////	  
////	            if (c0 != null && c1 != null) {  
////	                long idletime = c1[0] - c0[0];  
////	                long busytime = c1[1] - c0[1];  
////	                return   Double.valueOf(PERCENT * (busytime) * 1.0 / (busytime + idletime)).intValue() + "%";  
////	            } else {  
////	               return   0 + "%";  
////	            }  
////	  
////	        } catch (Exception ex) {  
////	            ex.printStackTrace();  
////	            return  0 + "%";  
////	       }  
//	    }  
	  

	 // 获取内存使用率
		public static String getMemery() {

			OperatingSystemMXBean osmxb = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
			long totalvirtualMemory =  osmxb.getTotalSwapSpaceSize(); // 剩余的物理内存
			long freePhysicalMemorySize = osmxb.getFreePhysicalMemorySize();
			Double compare = (Double) (1 - freePhysicalMemorySize * 1.0 / totalvirtualMemory) * 100;

			String str = compare.intValue() + "%";
			return str;

		}


}
