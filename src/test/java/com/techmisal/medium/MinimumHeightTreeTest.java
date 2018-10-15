package com.techmisal.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class MinimumHeightTreeTest {

    private MinimumHeightTree solver = new MinimumHeightTree();

    @Test
    public void shouldReturnOne() {
        int[][] vertices = { {1,0}, {1,2}, {1,3}};
        Integer n = 4;
        List actualResult = solver.findMinHeightTrees(n, vertices);
        List expectedResult = new LinkedList<Integer>();
        expectedResult.add(1);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldReturnOneAndThree() {
        int[][] vertices = { {0,3}, {1,3}, {2,3},{4,3},{5,4} } ;
        Integer n = 6;
        List actualResult = solver.findMinHeightTrees(n, vertices);
        List expectedResult = new LinkedList<Integer>();
        expectedResult.add(3);
        expectedResult.add(4);
        Assert.assertEquals(expectedResult, actualResult);
    }

}
