
package pmcg.fcn.prefeitura.cliente.viabilidade;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for recuperaViabilidadesPendentes complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="recuperaViabilidadesPendentes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="xmlRequerimentoConsultaViabilidade" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "recuperaViabilidadesPendentes", propOrder = {
    "xmlRequerimentoConsultaViabilidade"
})
public class RecuperaViabilidadesPendentes {

    protected String xmlRequerimentoConsultaViabilidade;

    /**
     * Gets the value of the xmlRequerimentoConsultaViabilidade property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXmlRequerimentoConsultaViabilidade() {
        return xmlRequerimentoConsultaViabilidade;
    }

    /**
     * Sets the value of the xmlRequerimentoConsultaViabilidade property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXmlRequerimentoConsultaViabilidade(String value) {
        this.xmlRequerimentoConsultaViabilidade = value;
    }

}
