package products.enums;

public enum UnidadesDeMedida {
	KG(1),
	G(2),
	L(3),
	ML(4);
	
	private Integer code;
	
	private UnidadesDeMedida(Integer code) {
		this.code = code;
	}
	
	public Integer getCode() {
		return code;
	}
	public static UnidadesDeMedida valueOf(Integer code) {
		for(UnidadesDeMedida value : UnidadesDeMedida.values()) {
			if(value.getCode() == code){
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid UnidadeDeMedida Code");
	}
}
