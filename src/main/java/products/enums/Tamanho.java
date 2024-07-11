package products.enums;

public enum Tamanho {
	INFANTIL(1),
	PP(2),
	P(3),
	M(4),
	G(5),
	GG(6);
	
	private Integer code;
	
	private Tamanho(Integer code) {
		this.code = code;
	}
	
	public Integer getCode() {
		return code;
	}
	
	public static Tamanho valueOf(Integer code) {
		for(Tamanho value : Tamanho.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid Tamanho Code");
	}
}
