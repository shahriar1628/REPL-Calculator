package com.interview.app;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testReadFiles() {
        List<String> inputs = FileReadWRite.readFile("./resources/input.txt") ;
        assertTrue(inputs.stream().count()==2);
        assertTrue(inputs.stream().anyMatch(line -> line.toLowerCase().contains("hello")));
    }
    @Test
    public void testWriteFiles() {
        boolean write = FileReadWRite.writeFiles("./resources/input.txt", new ArrayList<String>()
                {
                    {
                        add("hello123") ;
                        add("ok");
                    }
                }
        ) ;
        assertTrue(write);
    }

    @Test
    public void testdir() {
        FileReadWRite.makeSingleDiectory("C:\\\\Directory1");
    }


    @Test
    public void testmuldir() {
        FileReadWRite.makeMultipleDiectories("C:\\\\Directory2\\\\Sub2\\\\Sub-Sub2");
    }
}
