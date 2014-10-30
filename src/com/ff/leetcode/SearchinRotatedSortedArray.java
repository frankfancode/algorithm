package com.ff.leetcode;

public class SearchinRotatedSortedArray {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 4, 4, 5, 6, 6, 6, 6, 6, 7, 8, 9, 10 };
		int[] rotateda = { 6, 7, 8, 9, 10, 0, 1, 2, 3, 4, 5 };
		//System.out.println(search(a, 2));
		int target=7;
		System.out.println("rotateda:" + binarySearchRotated(rotateda, target, 0, rotateda.length - 1));

//		long startTime = System.nanoTime(); // 获取开始时间
//		System.out.println(binarySearch(a, 7, 0, a.length - 1));
//		long endTime = System.nanoTime(); // 获取结束时间
//		System.out.println("程序运行时间： " + (endTime - startTime) + "ns");
	}

	public static int search(int[] A, int target) {
		long startTime = System.nanoTime(); // 获取开始时间

		int index = -1;

		for (int i = 0; i < A.length; i++) {
			if (A[i] == target) {
				index = i;
			}
		}
		long endTime = System.nanoTime(); // 获取结束时间
		System.out.println("程序运行时间： " + (endTime - startTime) + "ns");
		return index;

	}

	public static int binarySearch(int[] A, int target, int start, int end) {
		System.out.println("start:" + start + "end:" + end);
		int index = -1;
		int mid = (start + end) / 2;

		if (A[start] > target) {
			return -1;
		} else if (A[start] == target) {
			return start;
		} else if (A[end] == target) {
			return end;
		} else if (start == mid && A[mid] != target) {
			return -1;
		} else {
			if (A[mid] == target) {
				index = mid;
			} else if (A[mid] > target) {
				index = binarySearch(A, target, start, mid);
			} else if (A[mid] < target) {
				index = binarySearch(A, target, mid + 1, end);
			}

		}
		return index;

	}

	public static int binarySearchRotated(int[] A, int target, int start, int end) {
		int index = -1;
		int mid = (start + end) / 2;

		if (start == mid) {
			if (A[start] == target) {
				return start;
			} else if (end > mid) {
				if (A[end] == target) {
					return end;
				} else {
					return -1;
				}

			} else if (end == mid) {
				return -1;
			}
		} else {
			if (A[start] == target) {
				index = start;
			} else if (A[mid] == target) {
				index = mid;
			} else if (A[mid] > A[start]) {
				// end点在中后
				if (A[start] > target) {
					index = binarySearchRotated(A, target, mid + 1, end);
				} else if (A[start] < target && target < A[mid]) {
					index = binarySearchRotated(A, target, start, mid);
				} else if (A[start] < target && A[mid] < target) {
					index = binarySearchRotated(A, target, mid, end);
				}

			} else if (A[mid] < A[start]) {
				// end点在中前
				if (A[start] > target && A[mid] > target) {
					index = binarySearchRotated(A, target, start, mid);
				} else if (A[start] > target && A[mid] < target) {
					index = binarySearchRotated(A, target, mid + 1, end);
				} else if (A[start] < target) {
					index = binarySearchRotated(A, target, start, mid);
				}
			}

		}
		return index;

	}

	public int searcheasy(int[] A, int target) {
		int index = -1;

		for (int i = 0; i < A.length; i++) {
			if (A[i] == target) {
				index = i;
			}
		}
		return index;

	}
}