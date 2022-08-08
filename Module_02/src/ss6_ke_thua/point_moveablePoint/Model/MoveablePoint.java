package ss6_ke_thua.point_moveablePoint.Model;

public class MoveablePoint extends Point {
    private float xSpeed;
    private float ySpeed;

    public MoveablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float ySpeed,float xSpeed) {
        this.ySpeed = ySpeed;
        this.xSpeed = xSpeed;
    }

    public float getSpeed() {
        float arr[]= new float[]{};
        return arr[2];
    }

    @Override
    public String toString() {
        return String.format("(%.1f,%.1f),speed=(%.1f,%.1f)",getX(),getY(),xSpeed,ySpeed);
    }

    public MoveablePoint move() {
        setX(getX()+xSpeed);
        setY(getY()+ySpeed);
        return this;
    }
}
