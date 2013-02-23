import cs1.*;
import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.*;
import com.jme3.math.ColorRGBA;


public class Main extends SimpleApplication {
	public static void main (String[]args){
		Main app = new Main();
		app.start();
		Keyboard.readInt();
	}
	@Override
	public void simpleInitApp(){
		Box b = new Box(Vector3f.ZERO, 1, 1, 1);
		Geometry geom = new Geometry("box", b);
		Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
		mat.setColor("Color", ColorRGBA.Blue);
		geom.setMaterial(mat);
		rootNode.attachChild(geom);
	}
}
