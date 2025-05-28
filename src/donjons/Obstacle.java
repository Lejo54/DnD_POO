package donjons;

public class Obstacle  {
    Position m_position;
    public Obstacle() {
        m_position=new Position();
    }
    public Obstacle(int y , int x) {
        m_position=new Position(x,y);
    }
    public Position getPosition() {return m_position;}

}