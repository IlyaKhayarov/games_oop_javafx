package ru.job4j;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Ilya Khayarov
 * @version $Id$
 * @since 0.1
 */


public class BishopBlackTest {

    /**
     * Test
     * Позиция
     */
    @Test
    public void whenTestPosition() {
        BishopBlack bb = new BishopBlack(Cell.F1);
        assertThat(bb.position(), is(Cell.F1));
    }

    /**
     * Test
     * Копирование
     */
    @Test
    public void whenTestCopy() {
        BishopBlack bb = new BishopBlack(Cell.F1);
        assertThat(bb.copy(Cell.F3).position(), is(Cell.F3));
    }

    /**
     * Test
     * Путь
     */
    @Test
    public void whenTestWay() {
        BishopBlack bb = new BishopBlack(Cell.C1);
        Cell[] arr = bb.way(Cell.H3, Cell.C8);
        Cell[] a = {Cell.G4, Cell.F5, Cell.E6, Cell.D7, Cell.C8};
        assertThat(arr, is(a));
    }

    /**
     * Test
     * Проверка на диагональный путь
     */
    @Test
    public void whenTestValidateDiagonal() {
        BishopBlack bb = new BishopBlack(Cell.C1);
        System.out.println(bb.isDiagonal(Cell.H3, Cell.H4));
        assertThat(bb.isDiagonal(Cell.H3, Cell.H4), is(false));

    }
}



