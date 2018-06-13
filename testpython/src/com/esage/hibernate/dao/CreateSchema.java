package com.esage.hibernate.dao;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class CreateSchema {
	// �����������ɱ�ṹ
	@Test
	public void test() {
		Configuration cfg = new Configuration().configure();
		SchemaExport schemaExport = new SchemaExport(cfg);

		// ��һ������script�����ã� print the DDL to the console
		// �ڶ�������export�����ã� export the script to the database
		schemaExport.create(true, true);
	}
}
