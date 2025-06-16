package com.actitime.generic;

import java.time.LocalDateTime;

public class Demo {
public static void main(String[] args) {
	String time = LocalDateTime.now().toString().replace(':', '-');
	System.out.println(time);
}
}
