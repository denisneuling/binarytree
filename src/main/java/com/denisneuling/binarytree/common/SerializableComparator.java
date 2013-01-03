package com.denisneuling.binarytree.common;

import java.io.Serializable;
import java.util.Comparator;

import org.springframework.stereotype.Component;

@Component
public class SerializableComparator implements Comparator<Serializable>{

	@Override
	public int compare(Serializable o1, Serializable o2) {
		if(o1 instanceof String && o2 instanceof String){
			return compareS((String)o1, (String)o2);
		}else if(o1 instanceof Integer && o2 instanceof Integer){
			return compareI((Integer)o1, (Integer)o2);
		}

		if(o1.hashCode() < o2.hashCode()){
			return -1;
		}else if(o1.hashCode() > o2.hashCode()){
			return 1;
		}
		return 0;
	}

	private int compareI(Integer integer1, Integer integer2){
		if(integer1 < integer2){
			return -1;
		}else if(integer1 > integer2){
			return 1;
		}
		return 0;
	}
	
	private int compareS(String string1, String string2){
		return string1.compareTo(string2);
	}
}
