/**
 * [1968] - [2020] Centros Culturales de Mexico A.C / Universidad Panamericana
 * All Rights Reserved.
 */
package up.edu.isgc.raytracer.lights;

import up.edu.isgc.raytracer.Intersection;
import up.edu.isgc.raytracer.Materials;
import up.edu.isgc.raytracer.Ray;
import up.edu.isgc.raytracer.Vector3D;
import up.edu.isgc.raytracer.objects.Object3D;

import java.awt.*;

/**
 *
 * @author Jafet Rodríguez
 */
public abstract class Light extends Object3D {
    private double intensity;
    private static Materials material = new Materials(0, 0,0);

    public Light(Vector3D position, Color color, double intensity){
        super(position, color, material);
        setIntensity(intensity);
    }

    public double getIntensity() {
        return intensity;
    }

    public void setIntensity(double intensity) {
        this.intensity = intensity;
    }

    public abstract float getNDotL(Intersection intersection);

    public Intersection getIntersection(Ray ray){
        return new Intersection(Vector3D.ZERO(), -1, Vector3D.ZERO(), null);
    }
}
