import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*
 * Mohammad Juma
 * Garrett Nickens
 * Evan Michelsen
 * 
 * TCSS 343 - Autumn 2014
 * Homework 6B
 * November 30, 2014
 */

/**
 * Homework 6B
 * 
 * @author Mohammad Juma
 * @author Garrett Nickens
 * @author Evan Michelsen
 * @version 11-30-2014
 */
public final class Homework6B {

	/**
	 * Private constructor, to prevent instantiation of this class.
	 */
	private Homework6B() {
		// do nothing.
	}

	/**
	 * The main method.
	 * 
	 * @param args Command line arguments.
	 */
	public static void main(final String[] args){
		// create graph a----b-----c,
		//                X     Y
		// X and Y are objects stored at edges. .

		// All Objects stored will be strings.

		/** Create Sample Graph **/
		SimpleGraph G = new SimpleGraph();
		Vertex v, v1, v2, v3, v4, v5, v6, v7;
		Edge e, e3a, e1b, e12c, e3d, e2e, e6f, e8g, e10h, e9i, e11j, e6k;
		v1 = G.insertVertex(1, "Vertex 1");
		v2 = G.insertVertex(2, "Vertex 2");
		v3 = G.insertVertex(3, "Vertex 3");
		v4 = G.insertVertex(4, "Vertex 4");
		v5 = G.insertVertex(5, "Vertex 5");
		v6 = G.insertVertex(6, "Vertex 6");
		v7 = G.insertVertex(7, "Vertex 7");
		e3a = G.insertEdge(v1, v2, 3, "Edge 3A");
		e1b = G.insertEdge(v1, v3, 1, "Edge 1B");
		e12c = G.insertEdge(v1, v5, 12, "Edge 12C");
		e3d = G.insertEdge(v2, v3, 3, "Edge 3D");
		e2e = G.insertEdge(v2, v4, 2, "Edge 2E");
		e6f = G.insertEdge(v3, v4, 6, "Edge 6F");
		e8g = G.insertEdge(v4, v5, 8, "Edge 8G");
		e10h = G.insertEdge(v4, v6, 10, "Edge 10H");
		e9i = G.insertEdge(v5, v6, 9, "Edge 9I");
		e11j = G.insertEdge(v5, v7, 11, "Edge 11J");
		e6k = G.insertEdge(v6, v7, 6, "Edge 6K");

		Iterator i;

		System.out.println("Iterating through vertices...");
		for (i= G.vertices(); i.hasNext(); ) {
			v = (Vertex) i.next();
			System.out.println("found vertex " + v.getName());
		}

		System.out.println("Iterating through adjacency lists...");
		for (i= G.vertices(); i.hasNext(); ) {
			v = (Vertex) i.next();
			System.out.println("Vertex "+v.getName());
			Iterator j;

			for (j = G.incidentEdges(v); j.hasNext();) {
				e = (Edge) j.next();
				System.out.println("  found edge " + e.getName());
			}
		}

		/** Build Array From Adjacency List **/
		List<Edge> edgesArray = new ArrayList<Edge>();
		Map edgesMap = new HashMap();
		for (i = G.vertices(); i.hasNext(); ) {
			v = (Vertex) i.next();
			Iterator j;
			for (j = G.incidentEdges(v); j.hasNext();) {
				e = (Edge) j.next();
				edgesMap.put(e, e.getName());
			}
		}
		edgesArray.addAll(edgesMap.keySet());
		
		for (Edge ed: edgesArray) {
			System.out.println("Array: " + ed.getName());
		}
	}
}
