package pmcg.imti.ui;

import org.zkoss.zk.ui.ext.AfterCompose;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Textbox;

/**
 * Extensão para Textbox com máscara
 * 
 * a - Representa um carácter alpha numérico (A-Z,a-z)
 * 9 - Representa um carácter numérico (0-9)
 * N - Representa um carácter numérico (0-9)
 * * - Representa um carácter alpha numeric character (A-Z,a-z,0-9)
 * 
 * @author Hugo B. Bucker
 *
 */
public class Mask extends Textbox implements AfterCompose {

	private String mask = "";
	private String placeholder = "_";

	private String _mask = "";
	
	@Override
	public void afterCompose() {
//		String jqE = "jq('#" + this.getUuid() + "')";
//		String jq = "zk.afterMount(function() {" + jqE + ".unmask().mask('" + this.mask	+ "', {placeholder:'" + this.placeholder + "'});});";
//
//		Clients.evalJavaScript(jq);
		this.initMask();
	}

	private void initMask(){
		String jqE = "jq('#" + this.getUuid() + "')";
		String jq = jqE + ".unmask().mask('" + this.mask + "', {placeholder:'" + this.placeholder + "'});";

		Clients.evalJavaScript(jq);
	}
	
	public String getMask() {
		return mask;
	}

	public void setMask(String mask) {
		this.mask = mask;
		if (this._mask == null || !this._mask.equals(mask)){
			this._mask = mask;
			this.initMask();
		}
	}

	public String getPlaceholder() {
		return placeholder;
	}

	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}
	
}