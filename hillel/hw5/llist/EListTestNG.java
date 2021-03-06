package edu.hillel.hw5.llist;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.junit.Assert.assertArrayEquals;

import org.testng.Assert;
import org.testng.AssertJUnit;

public class EListTestNG extends Assert
{
	EList rr=null;

	@DataProvider
	public static Object[][] parameterTestNG() {
		return new Object[][]{
			{ new AList0() },
			{ new AList1() },
			{ new AList2() },
			{ new AListR() },
			{ new LList1() },
			{ new LList2() },
			{ new LListR() }
		};
	}

	//=====================================
	// size, init, toArray
	//=====================================
	@Test(dataProvider = "parameterTestNG")
	public void testSize_null(EList rr)
	{
		int[] ini = null;
		rr.init(ini);
		assertEquals(0, rr.size());
		int[] exp = {};
		int[] act = rr.toArray();
		AssertJUnit.assertArrayEquals(exp, act);
	}
	@Test(dataProvider = "parameterTestNG")
	public void testSize_0(EList rr)
	{
		int[] ini = {};
		rr.init(ini);
		assertEquals(0, rr.size());
		int[] exp = {};
		int[] act = rr.toArray();
		AssertJUnit.assertArrayEquals(exp, act);
	}
	@Test(dataProvider = "parameterTestNG")
	public void testSize_1(EList rr) 
	{

		int[] ini = {10};
		rr.init(ini);
		assertEquals(1, rr.size());
		int[] exp = {10};
		int[] act = rr.toArray();
		AssertJUnit.assertArrayEquals(exp, act);
	}
	@Test(dataProvider = "parameterTestNG")
	public void testSize_2(EList rr) 
	{

		int[] ini = {10,20};
		rr.init(ini);
		assertEquals(2, rr.size());
		int[] exp = {10,20};
		int[] act = rr.toArray();
		AssertJUnit.assertArrayEquals(exp, act);
	}
	@Test(dataProvider = "parameterTestNG")
	public void testSize_many(EList rr)
	{

		int[] ini = {10,20,33,77,11,24,19};
		rr.init(ini);
		assertEquals(7, rr.size());
		int[] exp = {10,20,33,77,11,24,19};
		int[] act = rr.toArray();
		AssertJUnit.assertArrayEquals(exp, act);
	}

	//=====================================
	// clear
	//=====================================
	@Test(dataProvider = "parameterTestNG")
	public void testClear(EList rr)
	{
		int[] ini = {10,20,33,77,11,24,19};
		rr.init(ini);
		assertEquals(7, rr.size());
		rr.clear();
		assertEquals(0, rr.size());
	}

	//=====================================
	// Get
	//=====================================

	@Test (dataProvider = "parameterTestNG",expectedExceptions = ListIsEmptyException.class)
	public void testGet(EList rr)
	{
		int[] ini = {};
		rr.init(ini);
		rr.get(0);
	}

	@Test (dataProvider = "parameterTestNG",expectedExceptions = ListIsEmptyException.class)
	public void testGet_OutRange1(EList rr)
	{
		int[] ini = {10,20,33,77,11,24,19};
		rr.init(ini);
		rr.get(25);
	}

	@Test (dataProvider = "parameterTestNG",expectedExceptions = ListIsEmptyException.class)
	public void testGet_OutRange2(EList rr)
	{
		int[] ini = {10,20,33,77,11,24,19};
		rr.init(ini);
		rr.get(-1);
	}

	@Test(dataProvider = "parameterTestNG")
	public void testGet_1(EList rr)
	{

		int[] ini = {10};
		rr.init(ini);
		assertEquals(10, rr.get(0));
	}
	@Test(dataProvider = "parameterTestNG")
	public void testGet_2(EList rr)
	{

		int[] ini = {10,20};
		rr.init(ini);
		assertEquals(20, rr.get(1));
	}
	@Test(dataProvider = "parameterTestNG")
	public void testGet_many(EList rr)
	{

		int[] ini = {10,20,33,77,11,24,19};
		rr.init(ini);
		assertEquals(77, rr.get(3));
	}

	//=====================================
	// Set
	//=====================================
	@Test (dataProvider = "parameterTestNG",expectedExceptions = ListIsEmptyException.class)
	public void testSet_0(EList rr)
	{
		int[] ini = {};
		rr.init(ini);
		rr.set(2,99);
		assertEquals(0, rr.size());
		assertEquals(0, rr.get(2));
	}
	@Test(dataProvider = "parameterTestNG")
	public void testSet_1(EList rr)
	{
		int[] ini = {10};
		rr.init(ini);
		rr.set(0,99);
		assertEquals(1, rr.size());
		assertEquals(99, rr.get(0));
	}
	@Test(dataProvider = "parameterTestNG")
	public void testSet_2(EList rr)
	{
		int[] ini = {10,20};
		rr.init(ini);
		rr.set(1,99);
		assertEquals(2, rr.size());
		assertEquals(99, rr.get(1));
	}
	@Test(dataProvider = "parameterTestNG")
	public void testSet_many(EList rr)
	{
		int[] ini = {10,20,33,77,11,24,19,};
		rr.init(ini);
		rr.set(6,99);
		assertEquals(7, rr.size());
		assertEquals(99, rr.get(6));
		int[] exp = {10,20,33,77,11,24,99};
		int[] act = rr.toArray();
		AssertJUnit.assertArrayEquals(exp, act);
	}
	@Test(dataProvider = "parameterTestNG")
	public void testSet_many2(EList rr)
	{
		int[] ini = {10,20,33,77,11,24,19,10,4,19,11,14,15,13,15,16,12,8,19,20};
		rr.init(ini);
		rr.set(2,99);
		assertEquals(20, rr.size());
		assertEquals(99, rr.get(2));
		int[] exp = {10,20,99,77,11,24,19,10,4,19,11,14,15,13,15,16,12,8,19,20};
		int[] act = rr.toArray();
		AssertJUnit.assertArrayEquals(exp, act);
	}
	@Test (dataProvider = "parameterTestNG",expectedExceptions = ListIsEmptyException.class)
	public void testSet_outrange(EList rr)
	{
		int[] ini = {10,20,33,77,11,24,19,10,4,19,11,14,15,13,15,16,12,8,19,20};
		rr.init(ini);
		rr.set(35,99);
		assertEquals(20, rr.size());
		assertEquals(99, rr.get(2));
		int[] exp = {10,20,99,77,11,24,19,10,4,19,11,14,15,13,15,16,12,8,19,20};
		int[] act = rr.toArray();
		AssertJUnit.assertArrayEquals(exp, act);
	}

	//=====================================
	// addStart
	//=====================================
	@Test(dataProvider = "parameterTestNG")
	public void testAddStart(EList rr)
	{

		int[] ini = {};
		rr.init(ini);
		rr.addStart(99);
		assertEquals(1, rr.size());
		assertEquals(99, rr.get(0));
		int[] exp = {99};
		int[] act = rr.toArray();
		AssertJUnit.assertArrayEquals(exp, act);
	}
	@Test(dataProvider = "parameterTestNG")
	public void testAddStart_1(EList rr)
	{

		int[] ini = {10};
		rr.init(ini);
		rr.addStart(99);
		assertEquals(2, rr.size());
		assertEquals(99, rr.get(0));
		int[] exp = {99,10};
		int[] act = rr.toArray();
		AssertJUnit.assertArrayEquals(exp, act);
	}
	@Test(dataProvider = "parameterTestNG")
	public void testAddStart_2(EList rr)
	{
		int[] ini = {10,20};
		rr.init(ini);
		rr.addStart(99);
		assertEquals(3, rr.size());
		assertEquals(99, rr.get(0));
		int[] exp = {99,10,20};
		int[] act = rr.toArray();
		AssertJUnit.assertArrayEquals(exp, act);
	}
	@Test(dataProvider = "parameterTestNG")
	public void testAddStart_many(EList rr)
	{

		int[] ini = {10,20,33,77,11,24,19};
		rr.init(ini);
		rr.addStart(99);
		assertEquals(8, rr.size());
		assertEquals(99, rr.get(0));
		int[] exp = {99,10,20,33,77,11,24,19};
		int[] act = rr.toArray();
		AssertJUnit.assertArrayEquals(exp, act);
	}

	//=====================================
	// addEnd
	//=====================================
	@Test(dataProvider = "parameterTestNG")
	public void testAddEnd(EList rr)
	{

		int[] ini = {};
		rr.init(ini);
		rr.addEnd(99);
		assertEquals(1, rr.size());
		assertEquals(99, rr.get(rr.size()-1));
		int[] exp = {99};
		int[] act = rr.toArray();
		AssertJUnit.assertArrayEquals(exp, act);
	}
	@Test(dataProvider = "parameterTestNG")
	public void testAddEnd_1(EList rr)
	{

		int[] ini = {10};
		rr.init(ini);
		rr.addEnd(99);
		assertEquals(2, rr.size());
		assertEquals(99, rr.get(rr.size()-1));
		int[] exp = {10,99};
		int[] act = rr.toArray();
		AssertJUnit.assertArrayEquals(exp, act);
	}
	@Test(dataProvider = "parameterTestNG")
	public void testAddEnd_2(EList rr)
	{

		int[] ini = {10,20};
		rr.init(ini);
		rr.addEnd(99);
		assertEquals(3, rr.size());
		assertEquals(99, rr.get(rr.size()-1));
		int[] exp = {10,20,99};
		int[] act = rr.toArray();
		AssertJUnit.assertArrayEquals(exp, act);
	}
	@Test(dataProvider = "parameterTestNG")
	public void testAddEnd_many(EList rr)
	{

		int[] ini = {10,20,33,77,11,24,19};
		rr.init(ini);
		rr.addEnd(99);
		assertEquals(8, rr.size());
		assertEquals(99, rr.get(rr.size()-1));
		int[] exp = {10,20,33,77,11,24,19,99};
		int[] act = rr.toArray();
		AssertJUnit.assertArrayEquals(exp, act);
	}

	//=====================================
	// addPos
	//=====================================
	@Test(dataProvider = "parameterTestNG")
	public void testAddPos_0(EList rr)
	{

		int[] ini = {};
		rr.init(ini);
		rr.addPos(0,99);
		assertEquals(1, rr.size());
		assertEquals(99, rr.get(0));
		int[] exp = {99};
		int[] act = rr.toArray();
		AssertJUnit.assertArrayEquals(exp, act);
	}

	@Test(dataProvider = "parameterTestNG")
	public void testAddPos_1(EList rr)
	{
		int[] ini = {10};
		rr.init(ini);
		rr.addPos(1,99);
		assertEquals(2, rr.size());
		assertEquals(99, rr.get(1));
		int[] exp = {10,99};
		int[] act = rr.toArray();
		AssertJUnit.assertArrayEquals(exp, act);
	}
	@Test(dataProvider = "parameterTestNG")
	public void testAddPos_2(EList rr)
	{

		int[] ini = {10,20};
		rr.init(ini);
		rr.addPos(1,99);
		assertEquals(3, rr.size());
		assertEquals(99, rr.get(1));
		int[] exp = {10,99,20};
		int[] act = rr.toArray();
		AssertJUnit.assertArrayEquals(exp, act);
	}
	@Test(dataProvider = "parameterTestNG")
	public void testAddPos_many(EList rr)
	{

		int[] ini = {10,20,33,77,11,24,19};
		rr.init(ini);
		rr.addPos(1,99);
		assertEquals(8, rr.size());
		assertEquals(99, rr.get(1));
		int[] exp = {10,99,20,33,77,11,24,19};
		int[] act = rr.toArray();
		AssertJUnit.assertArrayEquals(exp, act);
	}

	//=====================================
	// delStart
	//=====================================
	@Test (dataProvider = "parameterTestNG",expectedExceptions = ListIsEmptyException.class)
	public void testDelStart_0(EList rr)
	{
		int[] ini = {};
		rr.init(ini);
		rr.delStart();
	}
	@Test(dataProvider = "parameterTestNG")
	public void testDelStart_1(EList rr)
	{

		int[] ini = {10};
		rr.init(ini);
		rr.delStart();
		assertEquals(0, rr.size());
		int[] exp = {};
		int[] act = rr.toArray();
		AssertJUnit.assertArrayEquals(exp, act);		
	}
	@Test(dataProvider = "parameterTestNG")
	public void testDelStart_2(EList rr)
	{

		int[] ini = {10,20};
		rr.init(ini);
		rr.delStart();
		assertEquals(1, rr.size());
		int[] exp = {20};
		int[] act = rr.toArray();
		AssertJUnit.assertArrayEquals(exp, act);		
	}
	@Test(dataProvider = "parameterTestNG")
	public void testDelStart_many(EList rr)
	{

		int[] ini = {10,20,33,77,11,24,19};
		rr.init(ini);
		rr.delStart();
		assertEquals(6, rr.size());
		int[] exp = {20,33,77,11,24,19};
		int[] act = rr.toArray();
		AssertJUnit.assertArrayEquals(exp, act);		
	}

	//=====================================
	// delEnd
	//=====================================
	@Test (dataProvider = "parameterTestNG",expectedExceptions = ListIsEmptyException.class)
	public void testDelEnd_0(EList rr)
	{
		int[] ini = {};
		rr.init(ini);
		rr.delEnd();	
	}
	@Test(dataProvider = "parameterTestNG")
	public void testDelEnd_1(EList rr)
	{

		int[] ini = {10};
		rr.init(ini);
		rr.delEnd();
		assertEquals(0, rr.size());
		int[] exp = {};
		int[] act = rr.toArray();
		AssertJUnit.assertArrayEquals(exp, act);		
	}
	@Test(dataProvider = "parameterTestNG")
	public void testDelEnd_2(EList rr)
	{

		int[] ini = {10,20};
		rr.init(ini);
		rr.delEnd();
		assertEquals(1, rr.size());
		int[] exp = {10};
		int[] act = rr.toArray();
		AssertJUnit.assertArrayEquals(exp, act);		
	}
	@Test(dataProvider = "parameterTestNG")
	public void testDelEnd_many(EList rr)
	{

		int[] ini = {10,20,33,77,11,24,19};
		rr.init(ini);
		rr.delEnd();
		assertEquals(6, rr.size());
		int[] exp = {10,20,33,77,11,24};
		int[] act = rr.toArray();
		AssertJUnit.assertArrayEquals(exp, act);		
	}

	//=====================================
	// delPos
	//=====================================
	@Test (dataProvider = "parameterTestNG",expectedExceptions = ListIsEmptyException.class)
	public void testDelPos_0(EList rr)
	{		
		int[] ini = {};
		rr.init(ini);
		rr.delPos(0);	
	}
	@Test(dataProvider = "parameterTestNG")
	public void testDelPos_1(EList rr)
	{
		int[] ini = {10};
		rr.init(ini);
		rr.delPos(0);
		assertEquals(0, rr.size());
		int[] exp = {};
		int[] act = rr.toArray();
		AssertJUnit.assertArrayEquals(exp, act);		
	}
	@Test(dataProvider = "parameterTestNG")
	public void testDelPos_2(EList rr)
	{

		int[] ini = {10,20};
		rr.init(ini);
		rr.delPos(0);
		assertEquals(1, rr.size());
		int[] exp = {20};
		int[] act = rr.toArray();
		AssertJUnit.assertArrayEquals(exp, act);		
	}
	@Test(dataProvider = "parameterTestNG")
	public void testDelPos_many(EList rr)
	{

		int[] ini = {10,20,33,77,11,24,19};
		rr.init(ini);
		rr.delPos(3);
		assertEquals(6, rr.size());
		int[] exp = {10,20,33,11,24,19};
		int[] act = rr.toArray();
		AssertJUnit.assertArrayEquals(exp, act);		
	}

	//=====================================
	// Min
	//=====================================
	@Test (dataProvider = "parameterTestNG",expectedExceptions = ListIsEmptyException.class)
	public void testMin_0(EList rr)
	{	
		int[] ini = {};
		rr.init(ini);
		assertEquals(0, rr.min());
	}	
	@Test(dataProvider = "parameterTestNG")
	public void testMin_1(EList rr)
	{	
		int[] ini = {10};
		rr.init(ini);
		assertEquals(10, rr.min());
	}
	@Test(dataProvider = "parameterTestNG")
	public void testMin_2(EList rr)
	{	
		int[] ini = {10,20};
		rr.init(ini);
		assertEquals(10, rr.min());
	}
	@Test(dataProvider = "parameterTestNG")
	public void testMin_many(EList rr)
	{	
		int[] ini = {10,20,33,77,11};
		rr.init(ini);
		assertEquals(10, rr.min());
	}

	//=====================================
	// Max
	//=====================================
	@Test (dataProvider = "parameterTestNG",expectedExceptions = ListIsEmptyException.class)
	public void testMax_0(EList rr)
	{	
		int[] ini = {};
		rr.init(ini);
		assertEquals(0, rr.max());
	}	
	@Test(dataProvider = "parameterTestNG")
	public void testMax_1(EList rr)
	{	
		int[] ini = {10};
		rr.init(ini);
		assertEquals(10, rr.max());
	}
	@Test(dataProvider = "parameterTestNG")
	public void testMax_2(EList rr)
	{	
		int[] ini = {10,20};
		rr.init(ini);
		assertEquals(20, rr.max());
	}
	@Test(dataProvider = "parameterTestNG")
	public void testMax_many(EList rr)
	{	
		int[] ini = {10,20,33,77,11};
		rr.init(ini);
		assertEquals(77, rr.max());
	}

	//=====================================
	// MinInd
	//=====================================
	@Test (dataProvider = "parameterTestNG",expectedExceptions = ListIsEmptyException.class)
	public void testMinInd_0(EList rr)
	{	
		int[] ini = {};
		rr.init(ini);
		assertEquals(0, rr.minInd());
	}	
	@Test(dataProvider = "parameterTestNG")
	public void testMinInd_1(EList rr)
	{	
		int[] ini = {10};
		rr.init(ini);
		assertEquals(0, rr.minInd());
	}
	@Test(dataProvider = "parameterTestNG")
	public void testMinInd_2(EList rr)
	{	
		int[] ini = {10,20};
		rr.init(ini);
		assertEquals(0, rr.minInd());
	}
	@Test(dataProvider = "parameterTestNG")
	public void testMinInd_many(EList rr)
	{	
		int[] ini = {10,20,33,77,11,5};
		rr.init(ini);
		assertEquals(5, rr.minInd());
	}

	@Test(dataProvider = "parameterTestNG")
	public void testMinInd_many2(EList rr)
	{	
		int[] ini = {10,20,33,77,11,24,19,10,4,19,11,14,15,13,15,16,12,8,19,20};
		rr.init(ini);
		assertEquals(8, rr.minInd());
	}

	//=====================================
	// MaxInd
	//=====================================
	@Test (dataProvider = "parameterTestNG",expectedExceptions = ListIsEmptyException.class)
	public void testMaxInd_0(EList rr)
	{	
		int[] ini = {};
		rr.init(ini);
		assertEquals(0, rr.maxInd());
	}	
	@Test(dataProvider = "parameterTestNG")
	public void testMaxInd_1(EList rr)
	{	
		int[] ini = {10};
		rr.init(ini);
		assertEquals(0, rr.maxInd());
	}
	@Test(dataProvider = "parameterTestNG")
	public void testMaxInd_2(EList rr)
	{	
		int[] ini = {10,20};
		rr.init(ini);
		assertEquals(1, rr.maxInd());
	}
	@Test(dataProvider = "parameterTestNG")
	public void testMaxInd_many(EList rr)
	{	
		int[] ini = {10,20,33,77,11};
		rr.init(ini);
		assertEquals(3, rr.maxInd());
	}

	@Test(dataProvider = "parameterTestNG")
	public void testMaxInd_many2(EList rr)
	{	
		int[] ini = {10,20,33,77,11,24,19,10,4,19,11,14,99,13,15,16,12,8,19,20};
		rr.init(ini);
		assertEquals(12, rr.maxInd());
	}

	//=====================================
	// sort
	//=====================================
	@Test(dataProvider = "parameterTestNG")
	public void testSort_0(EList rr) 
	{
		int[] ini = {};
		rr.init(ini);
		rr.sort();
		int[] exp = {};
		int[] act = rr.toArray();
		AssertJUnit.assertArrayEquals(exp, act);
	}
	@Test(dataProvider = "parameterTestNG")
	public void testSort_1(EList rr) 
	{

		int[] ini = {10};
		rr.init(ini);
		rr.sort();
		int[] exp = {10};
		int[] act = rr.toArray();
		AssertJUnit.assertArrayEquals(exp, act);
	}
	@Test(dataProvider = "parameterTestNG")
	public void testSort_2(EList rr) 
	{

		int[] ini = {77,11};
		rr.init(ini);
		rr.sort();
		int[] exp = {11,77};
		int[] act = rr.toArray();
		AssertJUnit.assertArrayEquals(exp, act);
	}
	@Test(dataProvider = "parameterTestNG")
	public void testSort_many(EList rr) 
	{

		int[] ini = {10,20,33,77,11,24,19};
		rr.init(ini);
		rr.sort();
		int[] exp = {10,11,19,20,24,33,77};
		int[] act = rr.toArray();
		AssertJUnit.assertArrayEquals(exp, act);
	}
	@Test(dataProvider = "parameterTestNG")
	public void testSort_many2(EList rr)
	{	
		int[] ini = {10,20,33,77,11,24,19,10,4,19,11,14,99,13,15,16,12,8,19,20};
		rr.init(ini);
		rr.sort();
		int[] exp = {4,8,10,10,11,11,12,13,14,15,16,19,19,19,20,20,24,33,77,99};
		int[] act = rr.toArray();
		AssertJUnit.assertArrayEquals(exp, act);
	}

	//=====================================
	// reverse
	//=====================================
	@Test(dataProvider = "parameterTestNG")
	public void testReverse_0(EList rr) 
	{

		int[] ini = {};
		rr.init(ini);
		rr.reverse();
		int[] exp = {};
		int[] act = rr.toArray();
		AssertJUnit.assertArrayEquals(exp, act);
	}
	@Test(dataProvider = "parameterTestNG")
	public void testReverse_1(EList rr) 
	{

		int[] ini = {10};
		rr.init(ini);
		rr.reverse();
		int[] exp = {10};
		int[] act = rr.toArray();
		AssertJUnit.assertArrayEquals(exp, act);
	}
	@Test(dataProvider = "parameterTestNG")
	public void testReverse_2(EList rr) 
	{

		int[] ini = {10,20};
		rr.init(ini);
		rr.reverse();
		int[] exp = {20,10};
		int[] act = rr.toArray();
		AssertJUnit.assertArrayEquals(exp, act);
	}
	@Test(dataProvider = "parameterTestNG")
	public void testReverse_many(EList rr) 
	{

		int[] ini = {10,20,33,77,11,24,19};
		rr.init(ini);
		rr.reverse();
		int[] exp = {19,24,11,77,33,20,10};
		int[] act = rr.toArray();
		AssertJUnit.assertArrayEquals(exp, act);
	}

	//=====================================
	// halfReverse
	//=====================================
	@Test(dataProvider = "parameterTestNG")
	public void testHalfReverse_0(EList rr) 
	{

		int[] ini = {};
		rr.init(ini);
		rr.halfReverse();
		int[] exp = {};
		int[] act = rr.toArray();
		AssertJUnit.assertArrayEquals(exp, act);
	}
	@Test(dataProvider = "parameterTestNG")
	public void testHalfReverse_1(EList rr) 
	{

		int[] ini = {10};
		rr.init(ini);
		rr.halfReverse();
		int[] exp = {10};
		int[] act = rr.toArray();
		AssertJUnit.assertArrayEquals(exp, act);
	}
	@Test(dataProvider = "parameterTestNG")
	public void testHalfReverse_2(EList rr) 
	{

		int[] ini = {10,20};
		rr.init(ini);
		rr.halfReverse();
		int[] exp = {20,10};
		int[] act = rr.toArray();
		AssertJUnit.assertArrayEquals(exp, act);
	}

	@Test(dataProvider = "parameterTestNG")
	public void testHalfReverse_many_even(EList rr) 
	{

		int[] ini = {10,20,33,11,24,19};
		rr.init(ini);
		rr.halfReverse();
		int[] exp = {11,24,19,10,20,33};
		int[] act = rr.toArray();
		AssertJUnit.assertArrayEquals(exp, act);
	}

	@Test(dataProvider = "parameterTestNG")
	public void testHalfReverse_many_odd(EList rr) 
	{

		int[] ini = {10,20,33,77,11,24,19};
		rr.init(ini);
		rr.halfReverse();
		int[] exp = {11,24,19,77,10,20,33};
		int[] act = rr.toArray();
		AssertJUnit.assertArrayEquals(exp, act);
	}

	//=====================================
	// Test Iterator
	//=====================================
	@Test(dataProvider = "parameterTestNG")
	public void testIterator0(EList rr) 
	{

		int[] ini = {};
		rr.init(ini);
		int[] act=new int[rr.size()];
		int i=0;
		for(Integer temp:rr)
		{
			act[i++]=temp;
		}
		int[] exp = {};
		assertArrayEquals(exp, act);
	}
	@Test(dataProvider = "parameterTestNG")
	public void testIterator1(EList rr) 
	{

		int[] ini = {10};
		rr.init(ini);
		int[] act=new int[rr.size()];
		int i=0;
		for(Integer temp:rr)
		{
			act[i++]=temp;
		}
		int[] exp = {10};
		assertArrayEquals(exp, act);
	}
	@Test(dataProvider = "parameterTestNG")
	public void testIterator2(EList rr) 
	{

		int[] ini = {10,20};
		rr.init(ini);
		int[] act=new int[rr.size()];
		int i=0;
		for(Integer temp:rr)
		{
			act[i++]=temp;
		}
		int[] exp = {10,20};
		assertArrayEquals(exp, act);
	}
	@Test(dataProvider = "parameterTestNG")
	public void testIteratorMany(EList rr) 
	{

		int[] ini = {10,20,33,77,11,24,19};
		rr.init(ini);
		int[] act=new int[rr.size()];
		int i=0;
		for(Integer temp:rr)
		{
			act[i++]=temp;
		}
		int[] exp = {10,20,33,77,11,24,19};
		assertArrayEquals(exp, act);
	}
}
