package com.esage.hibernate.bean;

import java.util.List;

public class QueryResult {
	private int count; // �ܼ�¼��
    private List list; // һҳ������

    public QueryResult(int count, List list) {
        this.count = count;
        this.list = list;
    }

    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public List getList() {
        return list;
    }
    public void setList(List list) {
        this.list = list;
    }


}
