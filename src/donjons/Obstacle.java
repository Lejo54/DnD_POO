package donjons;

public class Obstacle  {
    Position m_position;
    public Obstacle() {
        m_position=new Position();
    }
    public Obstacle(int x , int y) {
        m_position=new Position(x,y);
    }
    public Position getPosition() {return m_position;}

}