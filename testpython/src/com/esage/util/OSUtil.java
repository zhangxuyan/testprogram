package com.esage.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.Properties;

import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.Swap;

public class OSUtil {
	public static void property() throws UnknownHostException {
		Runtime r = Runtime.getRuntime();
		Properties props = System.getProperties();
		InetAddress addr;
		addr = InetAddress.getLocalHost();
		String ip = addr.getHostAddress();
		Map<String, String> map = System.getenv();
		String userName = map.get("USERNAME");// ��ȡ�û���
		String computerName = map.get("COMPUTERNAME");// ��ȡ�������
		String userDomain = map.get("USERDOMAIN");// ��ȡ���������
		System.out.println("�û���:    " + userName);
		System.out.println("�������:    " + computerName);
		System.out.println("���������:    " + userDomain);
		System.out.println("����ip��ַ:    " + ip);
		System.out.println("����������:    " + addr.getHostName());
		System.out.println("JVM����ʹ�õ����ڴ�:    " + r.totalMemory());
		System.out.println("JVM����ʹ�õ�ʣ���ڴ�:    " + r.freeMemory());
		System.out.println("JVM����ʹ�õĴ���������:    " + r.availableProcessors());
		System.out.println("Java�����л����汾��    " + props.getProperty("java.version"));
		System.out.println("Java�����л�����Ӧ�̣�    " + props.getProperty("java.vendor"));
		System.out.println("Java��Ӧ�̵�URL��    " + props.getProperty("java.vendor.url"));
		System.out.println("Java�İ�װ·����    " + props.getProperty("java.home"));
		System.out.println("Java��������淶�汾��    " + props.getProperty("java.vm.specification.version"));
		System.out.println("Java��������淶��Ӧ�̣�    " + props.getProperty("java.vm.specification.vendor"));
		System.out.println("Java��������淶���ƣ�    " + props.getProperty("java.vm.specification.name"));
		System.out.println("Java�������ʵ�ְ汾��    " + props.getProperty("java.vm.version"));
		System.out.println("Java�������ʵ�ֹ�Ӧ�̣�    " + props.getProperty("java.vm.vendor"));
		System.out.println("Java�������ʵ�����ƣ�    " + props.getProperty("java.vm.name"));
		System.out.println("Java����ʱ�����淶�汾��    " + props.getProperty("java.specification.version"));
		System.out.println("Java����ʱ�����淶��Ӧ�̣�    " + props.getProperty("java.specification.vender"));
		System.out.println("Java����ʱ�����淶���ƣ�    " + props.getProperty("java.specification.name"));
		System.out.println("Java�����ʽ�汾�ţ�    " + props.getProperty("java.class.version"));
		System.out.println("Java����·����    " + props.getProperty("java.class.path"));
		System.out.println("���ؿ�ʱ������·���б�    " + props.getProperty("java.library.path"));
		System.out.println("Ĭ�ϵ���ʱ�ļ�·����    " + props.getProperty("java.io.tmpdir"));
		System.out.println("һ��������չĿ¼��·����    " + props.getProperty("java.ext.dirs"));
		System.out.println("����ϵͳ�����ƣ�    " + props.getProperty("os.name"));
		System.out.println("����ϵͳ�Ĺ��ܣ�    " + props.getProperty("os.arch"));
		System.out.println("����ϵͳ�İ汾��    " + props.getProperty("os.version"));
		System.out.println("�ļ��ָ�����    " + props.getProperty("file.separator"));
		System.out.println("·���ָ�����    " + props.getProperty("path.separator"));
		System.out.println("�зָ�����    " + props.getProperty("line.separator"));
		System.out.println("�û����˻����ƣ�    " + props.getProperty("user.name"));
		System.out.println("�û�����Ŀ¼��    " + props.getProperty("user.home"));
		System.out.println("�û��ĵ�ǰ����Ŀ¼��    " + props.getProperty("user.dir"));
	}
	
	
	
	public static void memory() throws SigarException {
        Sigar sigar = new Sigar();
        Mem mem = sigar.getMem();
        // �ڴ�����
        System.out.println("�ڴ�����:    " + mem.getTotal() / 1024L + "K av");
        // ��ǰ�ڴ�ʹ����
        System.out.println("��ǰ�ڴ�ʹ����:    " + mem.getUsed() / 1024L + "K used");
        // ��ǰ�ڴ�ʣ����
        System.out.println("��ǰ�ڴ�ʣ����:    " + mem.getFree() / 1024L + "K free");
        Swap swap = sigar.getSwap();
        // ����������
        System.out.println("����������:    " + swap.getTotal() / 1024L + "K av");
        // ��ǰ������ʹ����
        System.out.println("��ǰ������ʹ����:    " + swap.getUsed() / 1024L + "K used");
        // ��ǰ������ʣ����
        System.out.println("��ǰ������ʣ����:    " + swap.getFree() / 1024L + "K free");
    }

}
