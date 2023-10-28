package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;

public class Test  {
	public static int[] sort(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(count(arr[i], arr)>count(arr[j], arr)) {
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
//					System.out.println(arr[i]+"  "+count(arr[i], arr));
//					System.out.println(arr[j]+"  "+count(arr[i+1], arr));
				}
			}
		}
		
		return arr;
	}
	
	public static int count(int i, int[] arr) {
		int result =0;
		for(int j:arr) {
			if (j == i) {
				result ++;
			}
		}
		return result;
	}
    public static void main(String[] args) {
		int[] arr = {2,5,1,2,9,2,6,8,9};
		int arr2[] = {5,6,3,1,6,1};
		System.out.println(Arrays.toString(sort(arr2)));
		System.out.println();
	}
}