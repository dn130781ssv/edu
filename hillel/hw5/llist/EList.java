package edu.hillel.hw5.llist;

public interface EList extends Iterable<Integer>
{
	int size();
	void init(int[] ini);
	int[] toArray();
	void clear();
	
	int get(int pos);
	void set(int pos, int val);

	void addStart(int val);
	void addEnd(int val);
	void addPos(int pos, int val);
	int delStart();
	int delEnd();
	int delPos(int pos);
	
	int min();
	int max();
	int minInd();
	int maxInd();
	
	void sort();
	void reverse();
	void halfReverse();
	
	
}

