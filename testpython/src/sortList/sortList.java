package sortList;
//

//public class sortList implements Comparable<T> {
//
//}

//package userSort;

import java.lang.reflect.Method;

import java.util.Comparator;

/**
 * ���ļ��Ǹ�������Ĳ����������� 
 * eg�� �������Ϊ <Student> (String propertyName ,boolean isASC) ���صĽ��Ϊ list<Student>, �����Ǹ���propertyName�������к�Ľ�� 
 * ����Student���е�propertyName�ֶν�������
 * T��ʾ��Student�࣬propertyName�����е�һ���ֶ����� 
 * 
 * @author YinLinFei
 * @param <T>
 */

/**
 * �ֶ���������ĸ��Ҫ��д
 * 
 * @author YinLinFei
 */

public class sortList<T> implements Comparator<T> {

	private String propertyName;

	private boolean isAsc;

	public sortList(String propertyname, boolean isasc) {
		this.propertyName = propertyname;
		this.isAsc = isasc;
	}

	/**
	 * ��Ҫ���ǣ��������е��ֶζԶ����������
	 * 
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public int compare(T b1, T b2) {
		Class<?> clz = b1.getClass();
		Method mth = getPropertyMethod(clz, propertyName);
		try {
			Object o1 = mth.invoke(b1);
			Object o2 = mth.invoke(b2);
			if (o1 == null || o2 == null)
				return 0;
			Comparable value1 = (Comparable) o1;
			Comparable value2 = (Comparable) o2;
			if (isAsc) {
				return value1.compareTo(value2);
			} else {
				return value2.compareTo(value1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;

		// ԭ�ȵĹ̶��ĸ���ĳһ���̶����ֶν�������

		// if (b1 == null || b2 == null) {

		// return 0;

		// }

		// if (isAsc) {

		// return b1.getWeight().compareTo(b2.getWeight());

		// } else {

		// return b2.getWeight().compareTo(b1.getWeight());

		// }

	}

	// ��ȡ����
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Method getPropertyMethod(Class clz, String propertyName) {
		Method mth = null;
		try {
			mth = clz.getMethod("get" + propertyName);
		} catch (Exception e) {
			System.out.println("��ȡ������������");
		}
		return mth;
	}

	public String getPropertyName() {

		return propertyName;

	}

	public void setPropertyName(String propertyName) {

		this.propertyName = propertyName;

	}

	public boolean isAsc() {

		return isAsc;

	}

	public void setAsc(boolean isAsc) {

		this.isAsc = isAsc;

	}

}