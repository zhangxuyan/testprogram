package com.esage.dao;

import java.util.List;
import java.util.Map;

import javax.management.Query;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.classic.Session;

import com.esage.util.HibernateUtils;
import com.esage.util.Pager;

public class UserDaoImpl {
	public Pager pagerff(Pager p, Map<String, Object> pram) throws IllegalStateException, SystemException {
        Session session = null;
        Transaction tx = null;
        try {
            session=HibernateUtils.getSessionFactory().openSession();
            tx=(Transaction) session.beginTransaction();
            String hql=p.getHql();//获取查询语句
            Query query= (Query) session.createQuery(hql).setCacheable(true);
            //设置参数
            ((org.hibernate.Query) query).setProperties(pram);
            //查询具体数据
            int count=((org.hibernate.Query) query).list().size();
            p.setRowsTotal(count);
            int nowPage=1;
            if(p.getPage()>0){
                nowPage=p.getPage();
            }
            //指定从那个对象开始查询，参数的索引位置是从0开始的，
            ((org.hibernate.Query) query).setFirstResult((p.getPage()-1)*p.getRows());
            //分页时，一次最多产寻的对象数
            ((org.hibernate.Query) query).setMaxResults(p.getRows());
            List<?> list1=((org.hibernate.Query) query).list();        
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
