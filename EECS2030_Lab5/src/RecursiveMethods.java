import java.util.ArrayList;
import java.util.List;

/*
 * Requirement:
 * You are required to implement all methods recursively.
 * You receive a zero if there is any occurrence of a loop (e.g., for, while).  
 * See under doc/index.html for the API of methods.
 * This lab requires definitions of recursive helper methods. 
 * You may review the recording of parts of Lecture 14 (October 28): 
 * 		https://youtu.be/J2CB3QHinQU 
 */
public class RecursiveMethods {
	/**
	 * Return an array storing the first n numbers in an arithmetic sequence, with
	 * initial term 'start' and common difference 'diff'. You can assume that n is
	 * non-negative (larger than or equal to 0). e.g., arithmeticArray(2, 3, 5)
	 * returns an array {2, 5, 8, 11, 14}.
	 * 
	 * @param start the first term in an arithmetic sequence
	 * @param diff  the common difference between terms in an arithmetic sequence
	 * @param n     the first n numbers in an arithmetic sequence
	 * @return an array representing the first n numbers in the specified arithmetic
	 *         sequence
	 * 
	 *         <b>You are forbidden to use the arithmeticList method below to solve
	 *         this problem.</b>
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public int[] arithmeticArray(int start, int diff, int n) {
		/*
		 * Your Task: Make use of the recursive method arithmeticArrayHelper.
		 */
		int result[] = new int[n];
		if (n == 0) {
			return result;
		} else if (n == 1) {
			result[0] = start;
			return result;
		} else {
			result[0] = start;
			arithmeticArrayHelper(1, diff, result);
			return result;
		}
	}

	/**
	 * This is a recursive helper method expected to be used by arithmeticArray.
	 * 
	 * @param i    position in `seq` to be assigned to
	 * @param diff common difference of the arithmetics sequence
	 * @param seq  a partially filled arithmetic sequence
	 * 
	 *             Each recursive call to this helper method stores at index `i` of
	 *             the resulting arithmetic sequence `seq`, which is assumed to have
	 *             been partially filled at indices 0, 1, ..., i - 1.
	 */
	void arithmeticArrayHelper(int i, int diff, int[] seq) {

		if (i != seq.length) {
			seq[i] = seq[i - 1] + diff;
			int k = i + 1;
			arithmeticArrayHelper(k, diff, seq);
		}
	}

	/**
	 * Return a list storing the first n numbers in an arithmetic sequence, with
	 * initial term 'start' and common difference 'diff'. You can assume that n is
	 * non-negative (larger than or equal to 0). e.g., arithmeticList(2, 3, 5)
	 * returns a list {2, 5, 8, 11, 14}.
	 * 
	 * @param start the first term in an arithmetic sequence
	 * @param diff  the common difference between terms in an arithmetic sequence
	 * @param n     the first n numbers in an arithmetic sequence
	 * @return a list representing the first n numbers in the specified arithmetic
	 *         sequence
	 * 
	 *         <b>You are forbidden to use the arithmeticArray method above to solve
	 *         this problem.</b>
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public List<Integer> arithmeticList(int start, int diff, int n) {
		/*
		 * Your Task: Make use of the recursive method arithmeticListHelper.
		 */
		List<Integer> result = new ArrayList<>();
		if (n == 0) {
			return result;
		} else {
			if (n == 1) {
				result.add(start);
				return result;
			} else {
				result.add(start);
				arithmeticListHelper(1, diff, result, n);
				return result;

			}
		}

	}

	/**
	 * This is a recursive helper method expected to be used by arithmeticList.
	 * 
	 * @param i    position in `seq` to be assigned to
	 * @param diff common difference of the arithmetics sequence
	 * @param seq  a partially filled arithmetic sequence
	 * @param n    size of the arithmetic sequence to be built eventually
	 * 
	 *             Each recursive call to this helper method stores at index `i` of
	 *             the resulting arithmetic sequence `seq`, which is assumed to have
	 *             been partially filled at indices 0, 1, ..., i - 1.
	 */
	void arithmeticListHelper(int i, int diff, List<Integer> seq, int n) {

		if (i != n) {
			i--;
			int a = seq.get(i) + diff;
			seq.add(a);
			int k = i + 2;
			arithmeticListHelper(k, diff, seq, n);
		}
	}

	/**
	 * Return whether or not an array represents the first n numbers of an
	 * arithmetic sequence. An arithmetic sequence has a common difference between
	 * every two adjacent terms. The array may or may not be empty. e.g.,
	 * isArithmeticArray({1, 3, 5, 8, 10}) returns false and isArithmeticArray({1,
	 * 3, 5, 7, 9}) returns true (because the common difference is 2).
	 * 
	 * @param a an array
	 * @return true if input array a represents an arithmetic sequence; false
	 *         otherwise.
	 * 
	 *         <b>You are forbidden to use the isArithmeticList method below to
	 *         solve this problem.</b>
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public boolean isArithmeticArray(int[] a) {
		/*
		 * Your Task: Make use of the recursive method isArithmeticArrayHelper.
		 */
		if (a.length == 0) {
			return true;
		} else {
			if (a.length == 1 || a.length == 2) {
				return true;
			} else {
				int diff = a[1] - a[0];
				boolean result = isArithmeticArrayHelper(1, diff, a);
				return result;
			}

		}
	}

	/**
	 * This is a recursive helper method expected to be used by isArithmeticArray.
	 * 
	 * @param i    position in `seq`, starting from which the remaining sub-sequence
	 *             is an arithmetic sequence
	 * @param diff common difference of the arithmetics sequence
	 * @param a    an array which may or may not be an arithmetic sequence
	 * @return whether or not the sub-sequence of `a` with indices i - 1, i, i + 1,
	 *         ..., a.length - 1 is an arithmetic sequence
	 * 
	 *         Each recursive call to this helper method considers if elements of
	 *         `a` at indices `i - 1` and `i` make two valid adjacent elements in
	 *         the arithmetic sequence, i.e., their difference is equal to the
	 *         common difference `diff`. Also, it considers if the remaining
	 *         sub-sequence (indices i + 1, i + 2, ..., a.length - 1) is an
	 *         arithmetic sequence with common difference `diff`.
	 */
	boolean isArithmeticArrayHelper(int i, int diff, int[] a) {
		/*
		 * Your Task
		 */
		boolean result = true;
		if (i != a.length - 1) {
			if (a[i + 1] - a[i] != diff) {
				return false;
			} else {
				int k = i + 1;
				return result && isArithmeticArrayHelper(k, diff, a);
			}
		} else {
			return true;
		}

	}

	/**
	 * Return whether or not a list represents the first n numbers of an arithmetic
	 * sequence. An arithmetic sequence has a common difference between every two
	 * adjacent terms. The list may or may not be empty. e.g., isArithmeticList({1,
	 * 3, 5, 8, 10}) returns false and isArithmeticList({1, 3, 5, 7, 9}) returns
	 * true (because the common difference is 2).
	 * 
	 * @param l a list
	 * @return true if input list l represents an arithmetic sequence; false
	 *         otherwise.
	 * 
	 *         <b>You are forbidden to use the isArithmeticArray method above to
	 *         solve this problem.</b>
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public boolean isArithmeticList(List<Integer> l) {
		/*
		 * Your Task: Make use of the recursive method isArithmeticListHelper.
		 */
		if (l.isEmpty()) {
			return true;
		} else {
			if (l.size() == 1 || l.size() == 2) {
				return true;
			} else {
				int diff = l.get(1) - l.get(0);
				boolean result = isArithmeticListHelper(1, diff, l);
				return result;
			}

		}
	}

	/**
	 * This is a recursive helper method expected to be used by isArithmeticList.
	 * 
	 * @param i    position in `seq`, starting from which the remaining sub-sequence
	 *             is an arithmetic sequence
	 * @param diff common difference of the arithmetics sequence
	 * @param l    a list which may or may not be an arithmetic sequence
	 * @return whether or not the sub-sequence of `l` with indices i - 1, i, i + 1,
	 *         ..., l.size() - 1 is an arithmetic sequence
	 * 
	 *         Each recursive call to this helper method considers if elements of
	 *         `l` at indices `i - 1` and `i` make two valid adjacent elements in
	 *         the arithmetic sequence, i.e., their difference is equal to the
	 *         common difference `diff`. Also, it considers if the remaining
	 *         sub-sequence (indices i + 1, i + 2, ..., l.size() - 1) is an
	 *         arithmetic sequence with common difference `diff`.
	 */
	boolean isArithmeticListHelper(int i, int diff, List<Integer> l) {
		/*
		 * Your Task
		 */
		boolean result = true;
		if (i != l.size() - 1) {
			if (l.get(i + 1) - l.get(i) != diff) {
				return false;
			} else {
				int k = i + 1;
				return result && isArithmeticListHelper(k, diff, l);
			}
		} else {
			return true;
		}
	}

	/**
	 * Given a sorted input array a, return a sorted array of size a.length + 1,
	 * consisting of all elements of array a and integer i.
	 * 
	 * @param a an array that is sorted in a non-descending order
	 * @param i an integer
	 * @return a sorted array of size a.length + 1, consisting of all elements of
	 *         array a and integer i. e.g., insertIntoSortedArray({1, 2, 4, 5}, 3)
	 *         returns a sorted array {1, 2, 3, 4, 5}.
	 * 
	 *         <b>You are forbidden to use the insertIntoSortedList method below to
	 *         solve this problem.</b>
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */

	public int[] insertIntoSortedArray(int[] a, int i) {
		/*
		 * Your Task: Define a recursive method yourself and use it here.
		 */
		int result[] = new int[a.length + 1];
		if (a.length == 0) {
			a = new int[1];
			a[0] = i;
			return a;
		} else if (i > a[a.length - 1]) {
			result = insertArrayHelper(0, a, result, i);
			result[result.length - 1] = i;
			return result;
		} else {
			result = insertArrayHelper(0, a, result, i);
			return result;
		}
	}

	int[] insertArrayHelper(int start, int[] a, int[] result, int i) {

		if (start != a.length) {
			if (i > a[start]) {
				result[start] = a[start];
				start++;
				insertArrayHelper(start, a, result, i);
				return result;
			} else if (i <= a[start]) {
				result[start] = i;
				result[start + 1] = a[start];
				i = a[start];
				start++;
				insertArrayHelper(start, a, result, i);
				return result;
			}
			return result;
		} else {
			// result[a.length + 1] = a[a.length-1];
			return result;
		}
	}

	/**
	 * Given a sorted input list, return a sorted list of size list.size() + 1,
	 * consisting of all elements of the input list and integer i.
	 * 
	 * @param list a list that is sorted in a non-descending order
	 * @param i    an integer
	 * @return a sorted list of size list.size() + 1, consisting of all elements of
	 *         the input list and integer i. e.g., insertIntoSortedList({1, 2, 4,
	 *         5}, 3) returns a sorted list {1, 2, 3, 4, 5}.
	 * 
	 *         <b>You are forbidden to use the insertIntoSortedArray method above to
	 *         solve this problem.</b>
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public List<Integer> insertIntoSortedList(List<Integer> list, int i) {
		/*
		 * Your Task: Define a recursive method yourself and use it here.
		 */
		List<Integer> result = new ArrayList<>();
		if (list.isEmpty()) {
			list.add(i);
			return list;
		} else if (i > list.get(list.size() - 1)) {
			list.add(i);
			return list;
		} else {
			result = insertHelp(0, list, result, i);
			return result;
		}

	}

	List<Integer> insertHelp(int start, List<Integer> list, List<Integer> result, int i) {
		if (start != list.size()) {
			if (i > list.get(start)) {
				result.add(list.get(start));
				start++;
				insertHelp(start, list, result, i);
				return result;
			} else if (i <= list.get(start)) {
				result.add(i);
				i = list.get(start);
				start++;
				insertHelp(start, list, result, i);
				return result;
			}
			return result;
		} else {
			result.add(list.get(list.size() - 1));
			return result;
		}
	}

	/**
	 * Given two sorted arrays left and right, where left is sorted in a
	 * non-descending order and right is sorted in a ***non-ascending*** order,
	 * return an array (of size left.length + right.length) sorted in a
	 * non-descending order, consisting of all elements of arrays left and right.
	 * 
	 * @param left  an array sorted in a non-descending order
	 * @param right an array sorted in a non-ascending order
	 * @return a sorted array of size left.length + right.length, consisting of all
	 *         elements of arrays left and right. e.g., mergeSortedArraysV2({1, 3,
	 *         5, 7}, {8, 6, 4, 2}) returns a sorted array {1, 2, 3, 4, 5, 6, 7, 8}.
	 * 
	 *         <b>You are forbidden to use the mergeSortedListsV2 method below to
	 *         solve this problem.</b>
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public int[] mergeSortedArrays(int[] left, int[] right) {
		/*
		 * Your Task: Define a recursive method yourself and use it here.
		 */
		int result[] = new int[right.length + left.length];
		if (left.length == 0 && right.length == 0) {
			return left;
		} else {
			result = mergeArrayHelper(left, right, 0, right.length - 1, result, 0);
			return result;
		}
	}

	int[] mergeArrayHelper(int[] left, int[] right, int l, int r, int[] result, int k) {
		if (l != left.length || r != -1) {
			if (left.length == 0 || l > left.length - 1) {
				result[k] = right[r];
				k++;
				r--;
				mergeArrayHelper(left, right, l, r, result, k);
				return result;
			} else if (right.length == 0 || r < 0) {
				result[k] = left[l];
				k++;
				l++;
				mergeArrayHelper(left, right, l, r, result, k);
				return result;
			} else if (right[r] < left[l]) {
				result[k] = right[r];
				k++;
				r--;
				mergeArrayHelper(left, right, l, r, result, k);
				return result;
			} else if (right[r] > left[l]) {
				result[k] = left[l];
				k++;
				l++;
				mergeArrayHelper(left, right, l, r, result, k);
				return result;
			} else {
				return result;
			}
		} else {
			return result;
		}
	}

	/**
	 * Given two sorted lists left and right, where left is sorted in a
	 * non-descending order and right is sorted in a ***non-ascending*** order,
	 * return a list (of size left.length + right.length) sorted in a non-descending
	 * order, consisting of all elements of lists left and right.
	 * 
	 * @param left  a list sorted in a non-descending order
	 * @param right a list sorted in a non-ascending order
	 * @return a sorted list of size left.size() + right.size(), consisting of all
	 *         elements of lists left and right. e.g., mergeSortedListsV2({1, 3, 5,
	 *         7}, {8, 6, 4, 2}) returns a sorted list {1, 2, 3, 4, 5, 6, 7, 8}.
	 * 
	 *         <b>You are forbidden to use the mergeSortedArraysV2 method above to
	 *         solve this problem.</b>
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public List<Integer> mergeSortedLists(List<Integer> left, List<Integer> right) {
		/*
		 * Your Task: Define a recursive method yourself and use it here.
		 */
		List<Integer> result = new ArrayList<>();
		if (left.isEmpty() && right.isEmpty()) {
			return left;
		} else {
			result = mergeListsHelp(left, right, 0, right.size() - 1, result);
			return result;
		}
	}

	List<Integer> mergeListsHelp(List<Integer> left, List<Integer> right, int l, int r, List<Integer> result) {
		if (l != left.size() || r != -1) {
			if (left.isEmpty() || l > left.size() - 1) {
				result.add(right.get(r));
				r--;
				mergeListsHelp(left, right, l, r, result);
				return result;
			} else if (right.isEmpty() || r < 0) {
				result.add(left.get(l));
				l++;
				mergeListsHelp(left, right, l, r, result);
				return result;
			} else if (right.get(r) < left.get(l)) {
				result.add(right.get(r));
				r--;
				mergeListsHelp(left, right, l, r, result);
				return result;
			} else if (right.get(r) > left.get(l)) {
				result.add(left.get(l));
				l++;
				mergeListsHelp(left, right, l, r, result);
				return result;
			} else {
				return result;
			}
		} else {
			return result;
		}

	}
}
