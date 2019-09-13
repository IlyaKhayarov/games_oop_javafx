package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            throw new IllegalStateException(
                    String.format("Could not move by diagonal from %s to %s", source, dest)
            );
        }
        int size = Math.abs(dest.x - source.x);
        Cell[] steps = new Cell[size];
        int deltaX; if (dest.x > source.x) deltaX = 1; else deltaX = -1;
        int deltaY; if (dest.y > source.y) deltaY = 1; else deltaY = -1;
        int x = source.x + deltaX;
        int y = source.y + deltaY;
        for (int i = 0; i < size; i++) {
            for (Cell cell : Cell.values()) {
                if (cell.x == x && cell.y == y) {
                    steps[i] = cell;
                    break;
                }
            }
            x += deltaX;
            y += deltaY;
        }
        return steps;
    }
    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
    public boolean isDiagonal(Cell source, Cell dest) {
        if (source.x != dest.x & source.y != dest.y) {
            return true;
        }
        return false;
    }
}
