package TreesandGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph<T>{

	private enum State { Unvisited, Visiting, Visited};
	
	private static class Vertex {
		int data;
		State state;
		ArrayList<Vertex> adjacentNodes;
		
		Vertex(int data){
			this.data = data;
			adjacentNodes = new ArrayList<Vertex>();
		}
	}

	ArrayList<Vertex> vertices;
	
	Graph(){
		
		vertices = new ArrayList<Vertex>();
	}
	
	public void addVertex(int data){
		vertices.add(new Vertex(data));
	}
	
	public void addEdge(Vertex v1, Vertex v2){
		if(vertices.get(v1.data) == null || vertices.get(v2.data) == null)
			throw new NullPointerException();
		v1.adjacentNodes.add(v2);
	}
	
	
	public boolean isRoute(Graph g, Vertex start, Vertex end){
		
		if(start == end)
			return true;
		
		Vertex v = start;
		Queue<Vertex> q = new LinkedList<Vertex>();
		q.add(start);

		return false;
	//
			
	//	}
		
	}
}
