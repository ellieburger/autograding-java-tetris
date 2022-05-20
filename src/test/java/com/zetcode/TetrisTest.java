package com.zetcode;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TetrisTest {
    static private Tetris tetris;

    @BeforeAll
    public static void beforeTest() {
		try {
			tetris = new Tetris();
			//tetris.setVisible(true);
		} catch(Exception e) {
		}
    }

    @Test
    public void testRandomMove() {
        tetris.restart();
        // Random move
        int t = 0;
        try {
            while (t < 100) {
                if (Math.random() > 0.5)
                    tetris.move(1);
                else
                    tetris.move(-1);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                if (Math.random() > 0.5)
                    tetris.rotate(false);
                else
                    tetris.rotate(true);
                t++;
            }
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testGameOver() {
		tetris.restart();
		
		if (tetris.isGameOver()) {
			assertTrue(false);
		}
			
        for (int i=0; i<10; i++)
            tetris.dropDown();
        boolean ret = tetris.isGameOver();
        assertTrue(ret);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }
}
