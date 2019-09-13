package ru.job4j;

import org.junit.Test;

import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.white.PawnWhite;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Ilya Khayarov
 * @version $Id$
 * @since 0.1
 */
public class LogicTest {
    /**
     * Test
     * На пути препятствие - не пройти
     */
    @Test
    public void whenLogicMoveFalse() {
        BishopBlack bb = new BishopBlack(Cell.C8);
        PawnWhite p1 = new PawnWhite(Cell.D7);
        Logic logic = new Logic();
        logic.add(bb);
        logic.add(p1);
        assertThat(logic.move(Cell.C8, Cell.E6), is(false));
    }

    /**
     * Test
     * На пути нет препятствий - путь свободен
     */
    @Test
    public void whenLogicMoveTrue() {
        BishopBlack bb = new BishopBlack(Cell.C8);
        PawnWhite p1 = new PawnWhite(Cell.E6);
        Logic logic = new Logic();
        logic.add(bb);
        logic.add(p1);
        assertThat(logic.move(Cell.C8, Cell.D7), is(true));
    }
}

