package com.test;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String alarmMessage="MACHINE:192.168.1.180 's RAMRATE 当前值为44.15,已超出预警阀值,请及时进行处理";
		alarmMessage=alarmMessage.replace("VIRTUALMACHINE", "虚拟机").replace("MACHINE", "主机").replace("CPURATE", "CPU利用率").replace("RAMRATE", "内存利用率").replace("DISKRATE", "磁盘利用率").replace(" 's ", "的").trim();
		System.out.println(alarmMessage);
	}

}
