package org.acme.graph.model;

/**
 * 
 * Un arc matérialisé par un sommet source et un sommet cible
 * 
 * @author MBorne
 *
 */
public class Edge {
	
	
	/**
	 * Identifiant de l'arc
	 */
	private String id;

	/**
	 * Sommet initial
	 */
	private Vertex source;

	/**
	 * Sommet final
	 */
	private Vertex target;
	
	protected Edge (Vertex source, Vertex target, String id) {
		assert(source!=null);
		assert(target!=null);
		this.id = id;
		this.source = source;
		this.target = target;
		
		this.source.addInEdges(this);
		this.target.addOutEdges(this);
	}

	public String getId() {
		return id;
	}

	public Vertex getSource() {
		return source;
	}

	public Vertex getTarget() {
		return target;
	}

	/**
	 * dijkstra - coût de parcours de l'arc (distance géométrique)
	 * 
	 * @return
	 */
	public double getCost() {
		return source.getCoordinate().distance(target.getCoordinate());
	}

	@Override
	public String toString() {
		return id + " (" + source + "->" + target + ")";
	}

}
