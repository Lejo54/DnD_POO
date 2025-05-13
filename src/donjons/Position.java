package donjons;


public class Position {
    private int m_x;
    private int m_y;

    public Position() {
         this.m_x = -1;
         this.m_y = -1;
    }

    public Position(int x, int y) {
        this.m_x = x;
        this.m_y = y;
    }

    public int getX() {
        return m_x;
    }

    public void changeX(int newX) {
        this.m_x = newX;
    }

    public int getY() {
        return m_y;
    }

    public void changeY(int newY) {
        this.m_y = newY;
    }
    public void changeXY(int newX, int newY) {
        this.m_x = newX;
        this.m_y = newY;
    }

    @Override
    public String toString() {
        return "Position{" +
            "x=" + m_x +
            ", y=" + m_y +
            '}';
        }
    }