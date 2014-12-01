/*
 * Written by Ed Hong UWT Feb. 17, 2003.
 * Modified by Donald Chinn May 14, 2003.
 * Modified by Donald Chinn December 11, 2003.
 */

import java.util.*;

/**
 * A class that represents a graph.
 * 
 * @author edhong
 * @version 0.0
 */
public class SimpleGraph {

    LinkedList vertexList;
    LinkedList edgeList;

    // Constructor
    public SimpleGraph() {
        this.vertexList = new LinkedList();
        this.edgeList = new LinkedList();
    }
    
    /**
     * Return the vertex list of this graph.
     * @returns  vertex list of this graph
     */
    public Iterator vertices() {
        return vertexList.iterator();
    }

    /**
     * Return the edge list of this graph.
     * @returns  edge list of this graph
     */
    public Iterator edges() {
        return edgeList.iterator();
    }

    /**
     * Given a vertex, return an iterator to the edge list of that vertex
     * @param v  a vertex
     * @returns  an iterator to the edge list of that vertex
     */
    public Iterator incidentEdges(Vertex v) {
        return v.incidentEdgeList.iterator();
    }

    /**
     * Return an arbitrary vertex of this graph
     * @returns  some vertex of this graph
     */
    public Vertex aVertex() {
        if (vertexList.size() > 0)
            return (Vertex) vertexList.getFirst();
        else
            return null;
    }

    /**
     * Add a vertex to this graph.
     * @param data  an object to be associated with the new vertex
     * @param name  a name to be associated with the new vertex
     * @returns  the new vertex
     */
    public Vertex insertVertex(Object data, Object name) {
        Vertex v;
        v = new Vertex(data, name);
        vertexList.addLast(v);
        return v;
    }

    /**
     * Add an edge to this graph.
     * @param v  the first endpoint of the edge
     * @param w  the second endpoint of the edge
     * @param data  data to be associated with the new edge
     * @param name  name to be associated with the new edge
     * @returns  the new edge
     */
    public Edge insertEdge(Vertex v, Vertex w, Object data, Object name) {
        Edge e;
        e = new Edge(v, w, data, name);
        edgeList.addLast(e);
        v.incidentEdgeList.addLast(e);
        w.incidentEdgeList.addLast(e);
        return e;
    }

    /**
     * Given a vertex and an edge, if the vertex is one of the endpoints
     * of the edge, return the other endpoint of the edge.  Otherwise,
     * return null.
     * @param v  a vertex
     * @param e  an edge
     * @returns  the other endpoint of the edge (or null, if v is not an endpoint of e)
     */
    public Vertex opposite(Vertex v, Edge e) {
        Vertex w;
        
        if (e.getFirstEndpoint() == v) {
            w= e.getSecondEndpoint();
        }
        else if (e.getSecondEndpoint() == v) {
            w = e.getFirstEndpoint();
        }
        else
            w = null;
        
        return w;
    }
    
    /**
     * Return the number of vertices in this graph.
     * @returns  the number of vertices
     */
    public int numVertices() {
        return vertexList.size();
    }

    /**
     * Return the number of edges in this graph.
     * @returns  the number of edges
     */
    public int numEdges() {
        return edgeList.size();
    }
}


