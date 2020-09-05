
public class PQNode implements Comparable<PQNode>{
		private Integer cor;
		private Double lossRatio;
		private boolean abandoned;

		public PQNode() {
			
		}
		
		public PQNode(Integer cor, Double lossRatio) {
			this.cor = cor;
			this.lossRatio = lossRatio;
		}
		
		public boolean isAbandoned() {
			return abandoned;
		}

		public void setAbandoned(boolean abandoned) {
			this.abandoned = abandoned;
		}

		public Integer getCor() {
			return cor;
		}

		public void setCor(Integer cor) {
			this.cor = cor;
		}

		public Double getLossRatio() {
			return lossRatio;
		}

		public void setLossRatio(Double lossRatio) {
			this.lossRatio = lossRatio;
		}

		@Override
		public int compareTo(PQNode o) {
			if (o.getLossRatio() < o.getLossRatio())
				return -1;
			else if (o.getLossRatio() > o.getLossRatio())
				return 1;
			else 
				return 0;
		}
		
		public String toString() {
			return cor + ": " + lossRatio;
		}
		
		public boolean equals(Object other) {
			if (other instanceof PQNode) {
				PQNode n = (PQNode) other;
				return n.cor == this.cor;
			}
			return false;
		}
		
		public int hashCode() {
			return cor.hashCode();
		}
		
}