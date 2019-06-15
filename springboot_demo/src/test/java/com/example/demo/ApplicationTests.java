package com.example.demo;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Test
	public void contextLoads() {
		/*String temp;
		String[] arr = {"aa","aa","aaaa","aaa","a","a"};
		for (int i = arr.length-1; i >0 ; i--) {
			if (arr[i].length() > arr[i-1].length()){
				temp = arr[i-1];
				arr[i-1] = arr[i];
				arr[i] = temp;
			}
		}
		System.out.println(arr[0].length());*/


        /**临时长度**/
        int tempLength = 0;
        /**所需寻找的最长子字符串的长度**/
        int subStringMaxLength = 0;
		/**举例字符串**/
		String string = "aa aaaaaa aaa a a";
		for (int i = 0;i < string.length();i++){
			if (((int)string.charAt(i)) != 32) {
				tempLength ++;
			}else {
				subStringMaxLength = tempLength > subStringMaxLength ? tempLength : subStringMaxLength;
				tempLength = 0;
			}
		}

		subStringMaxLength = tempLength > subStringMaxLength ? tempLength : subStringMaxLength;

		System.out.println(subStringMaxLength);
	}

}
