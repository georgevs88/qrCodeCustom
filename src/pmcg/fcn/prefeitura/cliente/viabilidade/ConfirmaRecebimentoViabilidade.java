
package pmcg.fcn.prefeitura.cliente.viabilidade;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for confirmaRecebimentoViabilidade complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="confirmaRecebimentoViabilidade">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="xmlConfirmacaoRecebimentoConsulta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "confirmaRecebimentoViabilidade", propOrder = {
    "xmlConfirmacaoRecebimentoConsulta"
})
public class ConfirmaRecebimentoViabilidade {

    protected String xmlConfirmacaoRecebimentoConsulta;

    /**
     * Gets the value of the xmlConfirmacaoRecebimentoConsulta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXmlConfirmacaoRecebimentoConsulta() {
        return xmlConfirmacaoRecebimentoConsulta;
    }

    /**
     * Sets the value of the xmlConfirmacaoRecebimentoConsulta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXmlConfirmacaoRecebimentoConsulta(String value) {
        this.xmlConfirmacaoRecebimentoConsulta = value;
    }

}
