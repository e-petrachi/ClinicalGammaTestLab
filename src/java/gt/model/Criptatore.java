package gt.model;

import org.apache.commons.codec.binary.Base64;

public class Criptatore {
	private static Criptatore instance;

	private Criptatore(){}
	public static synchronized Criptatore getInstance(){
		if(instance==null){
			instance = new Criptatore();
		} 
		return instance;
	}
	public String codifica(String daCod){
		// CODIFICA BASE64
	    byte[] encoded = Base64.encodeBase64(daCod.getBytes()); 
	    return new String(encoded);
	} 
	public String decodifica(String daDec){
	    // DECODIFICA BASE64
	    byte[] decoded = Base64.decodeBase64(daDec.getBytes()); 
	    return new String(decoded);
	}
}
