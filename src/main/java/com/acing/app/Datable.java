package com.acing.app;

import java.util.Comparator;
import java.util.Date;

public interface Datable extends Comparable<Datable> {
	Date getFecha();
	Long getTimeStamp();
	Comparator<Datable> getComparatorDatable();
	boolean antesDe(Datable datable);
	boolean despuesDe(Datable datable);
	
}
