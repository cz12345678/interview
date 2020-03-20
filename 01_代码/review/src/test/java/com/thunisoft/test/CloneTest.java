package com.thunisoft.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @describe:
 * @author: chenzhen-1
 * @date: 2019-3-18-下午5:51:27
 */
public class CloneTest {

	public static void main(String[] args) {
		Body body = new Body("张三", new Fonter(), new Head());
		Body body2 = clonex(body);

		System.err.println(body + "===>" + body2);

		System.out.println("body==body2  ====>" + (body == body2));
		System.out.println("body.font==body2.font  ====>"
				+ (body.getFonter() == body2.getFonter()));
		System.out.println("body.head==body2.head  ====>"
				+ (body.getHead() == body2.getHead()));
	}

	@SuppressWarnings("unchecked")
	public static <T> T clonex(T obj) {
		ByteArrayOutputStream bos = null;
		ObjectOutputStream oos = null;

		ObjectInputStream ois = null;
		T result = null;
		try {
			bos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(bos);
			oos.writeObject(obj);

			ois = new ObjectInputStream(new ByteArrayInputStream(
					bos.toByteArray()));

			result = (T) ois.readObject();

		} catch (Exception e) {
			e.printStackTrace();
		} 
		return result;
	}

}

class Body implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private Fonter fonter;
	private Head head;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Fonter getFonter() {
		return fonter;
	}

	public void setFonter(Fonter fonter) {
		this.fonter = fonter;
	}

	public Head getHead() {
		return head;
	}

	public void setHead(Head head) {
		this.head = head;
	}

	@Override
	public String toString() {
		return "Body [name=" + name + ", fonter=" + fonter + ", head=" + head
				+ "]";
	}

	public Body(String name, Fonter fonter, Head head) {
		super();
		this.name = name;
		this.fonter = fonter;
		this.head = head;
	}

}

class Head implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer size;

	public Integer getSize() {
		return size;
	}

	@Override
	public String toString() {
		return "Head [size=" + size + "]";
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}

class Fonter implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer size;
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Fonter [size=" + size + "]";
	}
	
	
	

}

class Face implements Serializable {
	/**
      * 
      */
	private static final long serialVersionUID = 1L;
	private Integer size;
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Face [size=" + size + "]";
	}
	
	
	
}
