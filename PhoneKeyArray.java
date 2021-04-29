package demo1.phoneDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description: 简单电话按键实现组合输出 0~99
 * @author: kongkengo
 * @date: 2021年4月25日 上午10:09:36
 */

public class PhoneKeyArray {
	/**
	 * 定义下标对应的按键排序
	 */
	final static char[][] temp = new char[][] { {}, {}, { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' },
			{ 'j', 'k', 'l' }, { 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' }

	};

	/**
	 * @param digits 控制台输入数字 0~99
	 * @return 输出数组
	 */
	public static List<String> letterCombinations(String digits) {

		int n = digits.length();
		int[] d = new int[n];
		for (int i = 0; i < n; i++) {
			d[i] = Integer.parseInt(String.valueOf(digits.charAt(i)));
			// System.out.println(d[i]);
		}
		List<String> l = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			// if (i!=0||i!=1) {}
			GetCombinations(l, d[i], temp);

		}
		return l;
	}

	/**
	 * @param temp  临时按键对应的数组
	 * @param index 下标
	 * @param t     按键映射的数组
	 */
	public static void GetCombinations(List<String> temp, int index, char[][] t) {
		List<String> l = new ArrayList<String>();
		List<String> tt = new ArrayList<String>(temp);
		temp.clear();
		// System.out.println(t[index].length);
		for (int i = 0; i < t[index].length; i++) {
			l.add(String.valueOf(t[index][i]));
			// System.out.print("*-*-"+l);
		}
		if (tt.size() == 0) {
			for (int i = 0; i < l.size(); i++) {
				temp.add(l.get(i));
				// System.out.print("temp:"+temp);
			}
		} else {
			for (int i = 0; i < tt.size(); i++) {
				for (int j = 0; j < l.size(); j++) {
					temp.add(tt.get(i) + l.get(j));
				}
			}
		}
	}

	/**
	 * main测试方法
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		while (true) {
			System.out.print("请输入0-99数字：");
			Scanner s = new Scanner(System.in);
			String num = s.next();
			if (num.length()<=2&&num.length()>0) {
				num = num.toString().replaceAll("[0|1]+?$", "");// 简单去除没用的下标
				List<String> letterCombinations = letterCombinations(num);
				System.out.println(letterCombinations);
			}else
				System.out.println("无效信息！请重新输入：");
		}
	}

}
