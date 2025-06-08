package donjons;

/**
 * Obstacle ayant une position
 **/
public class Obstacle  {
    Position m_position;

    /**
     * Constructeur d'obstacle
     * Crée un obstacle à la position (x,y)
     * @param x position en x
     * @param y position en y
     **/
    public Obstacle(int x , int y) {
        m_position=new Position(x,y);
    }

    /**
     * Retourne la position de l'obstacle
     * @return Position de l'obstacle
     */
    public Position getPosition() {return m_position;}

}