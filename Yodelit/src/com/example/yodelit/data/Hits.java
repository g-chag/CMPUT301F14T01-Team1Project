package com.example.yodelit.data;
import java.util.List;


public class Hits<Yodel> {
	private int total;
	private float max_score;
	private List<ElasticSearchHit<Yodel>> hits;
	
	public Hits() {}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public float getMax_score() {
		return max_score;
	}

	public void setMax_score(float max_score) {
		this.max_score = max_score;
	}

	public List<ElasticSearchHit<Yodel>> getHits() {
		return hits;
	}

	public void setHits(List<ElasticSearchHit<Yodel>> hits) {
		this.hits = hits;
	}

	@Override
	public String toString() {
		return "Hits [total=" + total + ", max_score=" + max_score + ", hits="
				+ hits + "]";
	}
}