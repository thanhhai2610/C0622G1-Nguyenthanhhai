package ss6_ke_thua.point2D_point3D.Model;

public class Point3D extends Point2D {
    private float z;

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z) {
//        setX(x);
//        setY(y);
        this.z = z;
    }

    public float getXY() {
        float[] arr = new float[]{getX(), getY(), z};
        return arr[3];
    }

    @Override
    public String toString() {
        return String.format("X= %.2f, Y: %.2f, Z: %.2f", getX(), getY(), z);
    }
}
