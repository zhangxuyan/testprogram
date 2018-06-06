package com.esage.dao;

import java.util.List;
import java.util.Map;

import javax.management.Query;

import com.esage.util.Pager;

public class UserDaoImpl {
	public Pager pagerff(Pager p, Map<String, Object> pram) {
        Session session = null;
        Transaction tx = null;
        try {
            session=HibernateUtils.getSessionFactory().openSession();
            tx=session.beginTransaction();
            String hql=p.getHql();//获取查询语句
            Query query= session.createQuery(hql).setCacheable(true);
            //设置参数
            query.setProperties(pram);
            //查询具体数据
            int count=query.list().size();
            p.setRowsTotal(count);
            int nowPage=1;
            if(p.getPage()>0){
                nowPage=p.getPage();
            }
            //指定从那个对象开始查询，参数的索引位置是从0开始的，
            query.setFirstResult((p.getPage()-1)*p.getRows());
            //分页时，一次最多产寻的对象数
            query.setMaxResults(p.getRows());
            List<?> list1=query.list();        
            p.setList(list1);
            tx.commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }finally{
            session.close();
        }
        return  p;
    }
}
