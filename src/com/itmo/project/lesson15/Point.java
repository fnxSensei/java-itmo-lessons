package com.itmo.project.lesson15;

public class Point implements Comparable<Point>{

    //сортировка по возрастанию
    //сортировка по убыванию
    //сортировка не по возрастанию
    //сортировка не по убиванию

    @Override
    public int compareTo(Point o) {
        // 0 если объекты равны
        // -1 если вызывающий оъект меньше
        // 1 если вызывающий оъект больше
        if (x<o.x && y<o.x) return -1;
        //esle if ....
        return 0;
    }
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        return y == point.y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }


}
