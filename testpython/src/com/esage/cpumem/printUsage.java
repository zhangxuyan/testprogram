package com.esage.cpumem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class printUsage {

	public static void printUsage() {
		OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
		for (Method method : operatingSystemMXBean.getClass().getDeclaredMethods()) {
			method.setAccessible(true);
			if (method.getName().startsWith("get") && Modifier.isPublic(method.getModifiers())) {
				Object value;
				try {
					value = method.invoke(operatingSystemMXBean);
				} catch (Exception e) {
					value = e;
				} // try
				System.out.println(method.getName() + " = " + value);
			} // if
		} // for
	}

	public double getCpuUsage() throws Exception {
		double cpuUsed = 0;

		Runtime rt = Runtime.getRuntime();
		Process p = rt.exec("top -b -n 1");// ����ϵͳ�ġ�top"����

		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String str = null;
			String[] strArray = null;

			while ((str = in.readLine()) != null) {
				int m = 0;

				if (str.indexOf(" R ") != -1) {// ֻ�����������еĽ��̣�top���̱������ &&

					strArray = str.split(" ");
					for (String tmp : strArray) {
						if (tmp.trim().length() == 0)
							continue;
						if (++m == 9) {// ��9��ΪCPU��ʹ�ðٷֱ�(RedHat

							cpuUsed += Double.parseDouble(tmp);

						}

					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			in.close();
		}
		return cpuUsed;
	}

	public double getMemUsage() throws Exception {

		double menUsed = 0;
		Runtime rt = Runtime.getRuntime();
		Process p = rt.exec("top -b -n 1");// ����ϵͳ�ġ�top"����

		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String str = null;
			String[] strArray = null;

			while ((str = in.readLine()) != null) {
				int m = 0;

				if (str.indexOf(" R ") != -1) {// ֻ�����������еĽ��̣�top���̱������ &&
					//
					// System.out.println("------------------3-----------------");
					strArray = str.split(" ");
					for (String tmp : strArray) {
						if (tmp.trim().length() == 0)
							continue;

						if (++m == 10) {
							// 9)--��10��Ϊmem��ʹ�ðٷֱ�(RedHat 9)

							menUsed += Double.parseDouble(tmp);

						}
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			in.close();
		}
		return menUsed;
	}

	public double getDeskUsage() throws Exception {
		double totalHD = 0;
		double usedHD = 0;
		Runtime rt = Runtime.getRuntime();
		Process p = rt.exec("df -hl");// df -hl �鿴Ӳ�̿ռ�

		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String str = null;
			String[] strArray = null;
			int flag = 0;
			while ((str = in.readLine()) != null) {
				int m = 0;
				// if (flag > 0) {
				// flag++;
				strArray = str.split(" ");
				for (String tmp : strArray) {
					if (tmp.trim().length() == 0)
						continue;
					++m;
					// System.out.println("----tmp----" + tmp);
					if (tmp.indexOf("G") != -1) {
						if (m == 2) {
							// System.out.println("---G----" + tmp);
							if (!tmp.equals("") && !tmp.equals("0"))
								totalHD += Double.parseDouble(tmp.substring(0, tmp.length() - 1)) * 1024;

						}
						if (m == 3) {
							// System.out.println("---G----" + tmp);
							if (!tmp.equals("none") && !tmp.equals("0"))
								usedHD += Double.parseDouble(tmp.substring(0, tmp.length() - 1)) * 1024;

						}
					}
					if (tmp.indexOf("M") != -1) {
						if (m == 2) {
							// System.out.println("---M---" + tmp);
							if (!tmp.equals("") && !tmp.equals("0"))
								totalHD += Double.parseDouble(tmp.substring(0, tmp.length() - 1));

						}
						if (m == 3) {
							// System.out.println("---M---" + tmp);
							if (!tmp.equals("none") && !tmp.equals("0"))
								usedHD += Double.parseDouble(tmp.substring(0, tmp.length() - 1));
							// System.out.println("----3----" + usedHD);
						}
					}

				}

				// }
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			in.close();
		}
		return (usedHD / totalHD) * 100;
	}
}
