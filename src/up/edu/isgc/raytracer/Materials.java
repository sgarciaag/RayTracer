package up.edu.isgc.raytracer;

/**
 * author @Sebastián García
 */
public class Materials {

    private double diffuse;
    private double shininess;
    private double reflection;

    public double getDiffuse() {
        return diffuse;
    }

    public void setDiffuse(double diffuse) {
        this.diffuse = diffuse;
    }

    public double getShininess() {
        return shininess;
    }

    public void setShininess(double shininess) {
        this.shininess = shininess;
    }

    public double getReflection() {
        return reflection;
    }

    public void setReflection(double reflection) {
        this.reflection = reflection;
    }

    public Materials(double diffuse, double shininess, double reflection) {
        setDiffuse(diffuse);
        setShininess(shininess);
        setReflection(reflection);

    }

}
