/**
 * [1968] - [2020] Centros Culturales de Mexico A.C / Universidad Panamericana
 * All Rights Reserved.
 */
package up.edu.isgc.raytracer;

import up.edu.isgc.raytracer.lights.DirectionalLight;
import up.edu.isgc.raytracer.lights.Light;
import up.edu.isgc.raytracer.lights.PointLight;
import up.edu.isgc.raytracer.objects.*;
import up.edu.isgc.raytracer.tools.OBJReader;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Jafet Rodríguez
 * @author Sebastián García
 */
public class Raytracer {

    public static void main(String[] args) {
        System.out.println(new Date());
        Scene scene01 = new Scene();
        scene01.setCamera(new Camera(new Vector3D(0, 0, -8), 160, 160, 800, 800, 8.2f, 50f));
        scene01.addLight(new PointLight(new Vector3D(-2f, 1f, -1f), Color.WHITE, 9));
        scene01.addLight(new PointLight(new Vector3D(2f, 1f, -1f), Color.WHITE, 9));
        scene01.addLight(new PointLight(new Vector3D(0f, 1f, 0f), Color.WHITE, 20));
        //scene01.addLight(new DirectionalLight(Vector3D.ZERO(), new Vector3D(0.5, -.1, 0), Color.RED, 20));
        scene01.addObject(new Sphere(new Vector3D(1f, 1f, 5f), 0.5f, Color.RED, new Materials(1f,10f, 0f)));
        scene01.addObject(new Sphere(new Vector3D(0f, 1f, 4.5f), 0.25f, new Color(200, 255, 0), new Materials(1f,1f,0f)));
        scene01.addObject(new Sphere(new Vector3D(-1f, 1f, 4.5f), 0.3f, Color.BLUE, new Materials(1f,5f,0f)));
        scene01.addObject(new Sphere(new Vector3D(4.85f, 1f, 4.5f), 0.3f, Color.PINK, new Materials(1f,5f,0f)));
        scene01.addObject(OBJReader.GetPolygon("CubeQuad.obj", new Vector3D(-1f, -3f, 3f), Color.GREEN, new Materials(1,2,0f)));
        scene01.addObject(OBJReader.GetPolygon("SmallTeapot.obj", new Vector3D(-1f, -2.0f, 3f), Color.BLUE, new Materials(1,5,1f)));
        scene01.addObject(OBJReader.GetPolygon("Ring.obj", new Vector3D(2f, -2.0f, 1.5f), Color.RED,  new Materials(2,10,1f)));
        scene01.addObject(OBJReader.GetPolygon("Ground.obj", new Vector3D(0f, -4f, 1f), Color.WHITE,  new Materials(2,10,1f)));

        Scene scene02 = new Scene();
        scene02.setCamera(new Camera(new Vector3D(0, 0, -8), 160, 160, 800, 800, 8.2f, 50f));
        scene02.addLight(new PointLight(new Vector3D(1.5f, 1f, -1.5f), Color.WHITE, 30f));
        scene02.addLight(new PointLight(new Vector3D(0f, 3f, 0f), Color.WHITE, 30f));
        scene02.addObject(new Sphere(new Vector3D(1.5f, -1f,  3f) ,.8f, Color.yellow, new Materials(1,5,1f)));
        scene02.addObject(OBJReader.GetPolygon("SmallTeapot.obj", new Vector3D(-1.5f, -2f, 3.5f), Color.BLUE, new Materials(1,5,1f)));
        scene02.addObject(OBJReader.GetPolygon("Plane.obj", new Vector3D(0f, -2.2f, 2.5f), Color.WHITE, new Materials(10,10,1f)));

        Scene scene03 = new Scene();
        scene03.setCamera(new Camera(new Vector3D(0, 0, -8), 160, 160, 2500, 2500, 8.2f, 50f));
        scene03.addLight(new PointLight(new Vector3D(0f, 2.5f, 2f), Color.WHITE, 50f));
        scene03.addLight(new PointLight(new Vector3D(7f, 2f, 15f), Color.WHITE, 50f));
        scene03.addLight(new PointLight(new Vector3D(-7f, 2f, 15f), Color.WHITE, 50f));
        scene03.addLight(new PointLight(new Vector3D(0f, 3f, 0f), Color.WHITE, 60f));
        scene03.addLight(new PointLight(new Vector3D(0f, 2f, -3f), Color.WHITE, 60f));
        scene03.addLight(new PointLight(new Vector3D(0f, -1f, 0f), Color.WHITE, 30f));
        scene03.addObject(OBJReader.GetPolygon("Ground.obj", new Vector3D(0f, -4f, 0f), new Color(171,0, 157, 228),  new Materials(1,2,0f)));
        //scene03.addObject(OBJReader.GetPolygon("Ground.obj", new Vector3D(0f, -4f, 0f), Color.DARK_GRAY,  new Materials(1,2,0f)));
        scene03.addObject(OBJReader.GetPolygon("SmallTeapotL.obj", new Vector3D(3, -2, 5), new Color(209, 189, 0, 211), new Materials(1,5,1f)));
        scene03.addObject(OBJReader.GetPolygon("SmallTeapot.obj", new Vector3D(-3, -2, 5), new Color(209, 189, 0, 211), new Materials(1,5,1f)));
        scene03.addObject(OBJReader.GetPolygon("Wall.obj", new Vector3D(0f, 0f, 20f),  Color.DARK_GRAY,  new Materials(1,1,0f)));
        //scene03.addObject(OBJReader.GetPolygon("Wall.obj", new Vector3D(0f, 0f, 20f), new Color(171,0, 157, 228),  new Materials(1,1,0f)));
        scene03.addObject(OBJReader.GetPolygon("RingTiltF.obj", new Vector3D(0f, -2f, 3f), Color.red,  new Materials(1,10,1f)));
        scene03.addObject(new Sphere(new Vector3D(0f, 1f, 5f), 1f, Color.LIGHT_GRAY, new Materials(1f,5f, 1f)));
        scene03.addObject(new Sphere(new Vector3D(-3f, 1f, 5f), 0.5f, Color.blue, new Materials(1f,5f, 0f)));
        scene03.addObject(new Sphere(new Vector3D(3f, 1f, 5f), 0.5f, Color.blue, new Materials(1f,5f, 0f)));

        Scene scene04 = new Scene();
        scene04.setCamera(new Camera(new Vector3D(0, 0, -8), 160, 160, 2500, 2500, 8.2f, 50f));
        scene04.addLight(new PointLight(new Vector3D(1.5f, 1f, -1.5f), Color.WHITE, 30f));
        scene04.addLight(new PointLight(new Vector3D(0f, 3f, 0f), Color.WHITE, 30f));
        scene04.addObject(OBJReader.GetPolygon("SmallTeapot.obj", new Vector3D(-1.5f, -2f, 4f), new Color(21, 179, 179, 240), new Materials(1,10,1f)));
        scene04.addObject(OBJReader.GetPolygon("SmallTeapotL.obj", new Vector3D(1.5f, -2f, 2f), Color.pink, new Materials(1,10,1f)));
        scene04.addObject(OBJReader.GetPolygon("Plane.obj", new Vector3D(0f, -2.2f, 2.5f), Color.WHITE, new Materials(10,10,1f)));

        Scene scene05 = new Scene();
        scene05.setCamera(new Camera(new Vector3D(0, 0, -8), 160, 160, 5000, 5000, 2f, 50f));
        //scene05.addObject(OBJReader.GetPolygon("Cube.obj", new Vector3D(2f, 0f, 2f), Color.MAGENTA,  new Materials(1,5,0)));
        //scene05.addObject(OBJReader.GetPolygon("CubeQuad.obj", new Vector3D(0f, 0.5f, 5f), Color.RED, new Materials(3,2,1)));
        //scene05.addObject(OBJReader.GetPolygon("SmallTeapot.obj", new Vector3D(-1.3f, -.75f, -1.5f), Color.white, new Materials(1,5,0)));
        scene05.addObject(OBJReader.GetPolygon("Ground.obj", new Vector3D(0,-1.5f,3f),new Color(242, 120, 122),new Materials(1,2,1)));
        //scene05.addObject(new Sphere(new Vector3D(-2f, 2.5f, 2f) ,.7f, Color.pink, new Materials(1,2,1)));
        //scene05.addObject(new Sphere(new Vector3D(2f, 2.5f, 2f) ,.7f, Color.gray, new Materials(1,2,1)));
        scene05.addObject(new Sphere(new Vector3D(2f, 0f, -1.5f) ,.8f, Color.gray, new Materials(1,2,1)));
        scene05.addObject(new Sphere(new Vector3D(-2f, 0f, -1.5f) ,.8f, Color.gray, new Materials(1,2,1)));
        scene05.addObject(new Sphere(new Vector3D(0f, 0f, 2f) ,.7f, Color.gray, new Materials(1,2,1)));
        scene05.addLight(new PointLight(new Vector3D(0,5,-8),Color.white,20));
        scene05.addLight(new PointLight(new Vector3D(2f, 3f, 0f), new Color(235, 102, 242), 20f));


        BufferedImage image = raytrace(scene05);
        File outputImage = new File("FinalScene4.png");
        try {
            ImageIO.write(image, "png", outputImage);
        } catch (IOException ioe) {
            System.out.println("Something failed");
        }
        System.out.println(new Date());
    }

    public static BufferedImage raytrace(Scene scene) {
        ExecutorService executorService = Executors.newFixedThreadPool(12);
        Camera mainCamera = scene.getCamera();
        ArrayList<Light> lights = scene.getLights();
        float[] nearFarPlanes = mainCamera.getNearFarPlanes();
        BufferedImage image = new BufferedImage(mainCamera.getResolutionWidth(), mainCamera.getResolutionHeight(), BufferedImage.TYPE_INT_RGB);
        ArrayList<Object3D> objects = scene.getObjects();

        Vector3D[][] positionsToRaytrace = mainCamera.calculatePositionsToRay();
        for (int i = 0; i < positionsToRaytrace.length; i++) {
            for (int j = 0; j < positionsToRaytrace[i].length; j++) {
                double x = positionsToRaytrace[i][j].getX() + mainCamera.getPosition().getX();
                double y = positionsToRaytrace[i][j].getY() + mainCamera.getPosition().getY();
                double z = positionsToRaytrace[i][j].getZ() + mainCamera.getPosition().getZ();

                Ray ray = new Ray(mainCamera.getPosition(), new Vector3D(x, y, z));
                Runnable runnable= imageCreator(i,j,mainCamera, ray, objects, nearFarPlanes, lights, image);
                executorService.execute(runnable);

            }
        }
        executorService.shutdown();
        try{
            if(!executorService.awaitTermination(180, TimeUnit.MINUTES)){
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(!executorService.isTerminated()){
                System.err.println("Cancel non-finished");
            }
        }
        executorService.shutdownNow();
        return image;
    }

    public static Runnable imageCreator(int i,int j,Camera mainCamera,Ray ray,ArrayList<Object3D> objects,float[] nearFarPlanes,ArrayList<Light> lights,BufferedImage image){
        Runnable aRunnable = new Runnable() {
            @Override
            public void run() {
                float cameraZ = (float) mainCamera.getPosition().getZ();
                Intersection closestIntersection = raycast(ray, objects, null, new float[]{cameraZ + nearFarPlanes[0], cameraZ + nearFarPlanes[1]});
                //Background color
                Color pixelColor = Color.BLACK;
                if (closestIntersection != null) {
                    if(closestIntersection.getObject().getMaterials().getReflection() > 0){
                        int count =0;
                        Intersection reflectionintrsctn = Reflection2(closestIntersection, objects, mainCamera, count);
                        if(reflectionintrsctn != null){
                            closestIntersection = reflectionintrsctn;
                        }
                    }
                    for (Light light : lights) {
                        Ray shadow = new Ray(closestIntersection.getPosition(), light.getPosition());
                        Intersection ifshadow = raycast(shadow, objects, closestIntersection.getObject(), new float[]{cameraZ + nearFarPlanes[0], cameraZ + nearFarPlanes[1]} );
                        float distance = (float) Math.sqrt(Math.pow(closestIntersection.getPosition().getX()-light.getPosition().getX(),2)+Math.pow(closestIntersection.getPosition().getY()-light.getPosition().getY(),2)+Math.pow(closestIntersection.getPosition().getZ()-light.getPosition().getZ(),2));
                        float nDotL = light.getNDotL(closestIntersection);
                        float intensity = (float) light.getIntensity() * nDotL;
                        float falloff = 1;
                        if(! (light instanceof DirectionalLight)){
                            falloff = (float) (intensity/Math.pow(distance, 2));
                        }
                        double specular = Specular(closestIntersection, mainCamera, light);
                        Color lightColor = light.getColor();
                        Color objColor = closestIntersection.getObject().getColor();
                        float userDiffuse = (float) closestIntersection.getObject().getMaterials().getDiffuse();
                        float[] lightColors = new float[]{lightColor.getRed() / 255.0f, lightColor.getGreen() / 255.0f, lightColor.getBlue() / 255.0f};
                        float[] objColors = new float[]{(objColor.getRed() / 255.0f)*userDiffuse, (objColor.getGreen() / 255.0f)*userDiffuse, (objColor.getBlue() / 255.0f)*userDiffuse};
                        for (int colorIndex = 0; colorIndex < objColors.length; colorIndex++) {
                            objColors[colorIndex] *= lightColors[colorIndex] * falloff * specular;
                        }
                        Color diffuse = new Color(clamp(objColors[0], 0, 1),clamp(objColors[1], 0, 1),clamp(objColors[2], 0, 1));
                        if(ifshadow != null){
                            diffuse = Color.BLACK;
                        }
                        pixelColor = addColor(pixelColor, diffuse);

                    }
                }
                setColor(i, j, pixelColor, image);
            }
        };
        return aRunnable;
    }

    public static synchronized void setColor(int i, int j, Color pixelColor, BufferedImage image){
        image.setRGB(i, j, pixelColor.getRGB());
    }

    public static float clamp(float value, float min, float max) {
        if (value < min) {
            return min;
        }
        if (value > max) {
            return max;
        }
        return value;
    }

    public static Color addColor(Color original, Color otherColor){
        float red = clamp((original.getRed() / 255.0f) + (otherColor.getRed() / 255.0f), 0, 1);
        float green = clamp((original.getGreen() / 255.0f) + (otherColor.getGreen() / 255.0f), 0, 1);
        float blue = clamp((original.getBlue() / 255.0f) + (otherColor.getBlue() / 255.0f), 0, 1);
        return new Color(red, green, blue);
    }

    public static Intersection raycast(Ray ray, ArrayList<Object3D> objects, Object3D caster, float[] clippingPlanes) {
        Intersection closestIntersection = null;

        for (int k = 0; k < objects.size(); k++) {
            Object3D currentObj = objects.get(k);
            if (caster == null || !currentObj.equals(caster)) {
                Intersection intersection = currentObj.getIntersection(ray);
                if (intersection != null) {
                    double distance = intersection.getDistance();
                    if (distance >= 0 &&
                            (closestIntersection == null || distance < closestIntersection.getDistance()) &&
                            (clippingPlanes == null || (intersection.getPosition().getZ() >= clippingPlanes[0] &&
                                    intersection.getPosition().getZ() <= clippingPlanes[1]))) {
                        closestIntersection = intersection;
                    }
                }
            }
        }

        return closestIntersection;
    }

    public static double Specular(Intersection closestIntersection, Camera camera, Light light){
        Vector3D cameraPos = Vector3D.normalize(camera.getPosition());
        Vector3D lightPos = Vector3D.normalize(light.getPosition());
        double shininess = closestIntersection.getObject().getMaterials().getShininess();
        Vector3D vectorsum = Vector3D.add(cameraPos, lightPos);
        Vector3D HalfV = Vector3D.normalize(Vector3D.scalarMultiplication(vectorsum, 1/Vector3D.magnitude(vectorsum)));

        double specular = Math.pow((Vector3D.dotProduct(closestIntersection.getNormal(), HalfV)), shininess);

        return specular;

    }

    public static Intersection Reflection2(Intersection closestIntersection,  ArrayList<Object3D> objects, Camera mainCamera, int count) {

        if (count <= 2){
            float reflective = (float) closestIntersection.getObject().getMaterials().getReflection();
            if (reflective > 0){
                Vector3D intersectionNormal = closestIntersection.getNormal();
                Vector3D intersectionViewer = Vector3D.substract(closestIntersection.getPosition(), mainCamera.getPosition());
                double nDotL= Vector3D.dotProduct(intersectionNormal,intersectionViewer);
                Vector3D doubleNormal= Vector3D.scalarMultiplication(intersectionNormal,-2);
                Vector3D nDotLTimesNormal= Vector3D.scalarMultiplication(doubleNormal,nDotL);
                Vector3D reflection = Vector3D.add(nDotLTimesNormal,intersectionViewer);
                Ray reflectionRay = new Ray(closestIntersection.getPosition(), reflection);


                for (Object3D object : objects) {
                    if (!object.equals(closestIntersection.getObject())) {
                        Intersection reflectedIntersection = raycast(reflectionRay, objects, closestIntersection.getObject(), null);
                        if (reflectedIntersection == null) {
                            return closestIntersection;
                        } else {
                            return Reflection2(reflectedIntersection, objects, mainCamera, count++);
                        }
                    }
                }

            }


        }
        return closestIntersection;
    }



}
