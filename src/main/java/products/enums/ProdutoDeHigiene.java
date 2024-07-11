package products.enums;

public enum ProdutoDeHigiene {
	SABONETE(1),
	ESCOVA_DE_DENTES(2),
	PASTA_DE_DENTES(3),
	ABSORVENTES(4);
	
	private int code;
	
	private ProdutoDeHigiene(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
	
	public static ProdutoDeHigiene valueOf(int code) {
		for(ProdutoDeHigiene value : ProdutoDeHigiene.values()) {
			if(code == value.getCode()) {
				return value;
			}
			
		}
		throw new IllegalArgumentException("Invalid ProdutoDeHigiene Code");
	}
	
}
