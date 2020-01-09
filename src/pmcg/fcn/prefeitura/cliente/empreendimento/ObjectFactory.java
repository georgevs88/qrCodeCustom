
package pmcg.fcn.prefeitura.cliente.empreendimento;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the prefeitura.cliente.empreendimento package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ConfirmacaoRecebimentoEmpreendimentoPelaPrefeituraResponse_QNAME = new QName("http://www.jucemg.mg.gov.br/empreendimento/service", "confirmacaoRecebimentoEmpreendimentoPelaPrefeituraResponse");
    private final static QName _RecuperaEmpreendimentosDeferidosParaPrefeitura_QNAME = new QName("http://www.jucemg.mg.gov.br/empreendimento/service", "recuperaEmpreendimentosDeferidosParaPrefeitura");
    private final static QName _ConfirmaAlvaraInscricaoMunicipalResponse_QNAME = new QName("http://www.jucemg.mg.gov.br/empreendimento/service", "confirmaAlvaraInscricaoMunicipalResponse");
    private final static QName _RecuperaEmpreendimentosDeferidosParaPrefeituraResponse_QNAME = new QName("http://www.jucemg.mg.gov.br/empreendimento/service", "recuperaEmpreendimentosDeferidosParaPrefeituraResponse");
    private final static QName _ConfirmaAlvaraInscricaoMunicipal_QNAME = new QName("http://www.jucemg.mg.gov.br/empreendimento/service", "confirmaAlvaraInscricaoMunicipal");
    private final static QName _ConfirmacaoRecebimentoEmpreendimentoPelaPrefeitura_QNAME = new QName("http://www.jucemg.mg.gov.br/empreendimento/service", "confirmacaoRecebimentoEmpreendimentoPelaPrefeitura");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: prefeitura.cliente.empreendimento
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConfirmacaoRecebimentoEmpreendimentoPelaPrefeituraResponse }
     * 
     */
    public ConfirmacaoRecebimentoEmpreendimentoPelaPrefeituraResponse createConfirmacaoRecebimentoEmpreendimentoPelaPrefeituraResponse() {
        return new ConfirmacaoRecebimentoEmpreendimentoPelaPrefeituraResponse();
    }

    /**
     * Create an instance of {@link ConfirmaAlvaraInscricaoMunicipal }
     * 
     */
    public ConfirmaAlvaraInscricaoMunicipal createConfirmaAlvaraInscricaoMunicipal() {
        return new ConfirmaAlvaraInscricaoMunicipal();
    }

    /**
     * Create an instance of {@link ConfirmacaoRecebimentoEmpreendimentoPelaPrefeitura }
     * 
     */
    public ConfirmacaoRecebimentoEmpreendimentoPelaPrefeitura createConfirmacaoRecebimentoEmpreendimentoPelaPrefeitura() {
        return new ConfirmacaoRecebimentoEmpreendimentoPelaPrefeitura();
    }

    /**
     * Create an instance of {@link RecuperaEmpreendimentosDeferidosParaPrefeituraResponse }
     * 
     */
    public RecuperaEmpreendimentosDeferidosParaPrefeituraResponse createRecuperaEmpreendimentosDeferidosParaPrefeituraResponse() {
        return new RecuperaEmpreendimentosDeferidosParaPrefeituraResponse();
    }

    /**
     * Create an instance of {@link ConfirmaAlvaraInscricaoMunicipalResponse }
     * 
     */
    public ConfirmaAlvaraInscricaoMunicipalResponse createConfirmaAlvaraInscricaoMunicipalResponse() {
        return new ConfirmaAlvaraInscricaoMunicipalResponse();
    }

    /**
     * Create an instance of {@link RecuperaEmpreendimentosDeferidosParaPrefeitura }
     * 
     */
    public RecuperaEmpreendimentosDeferidosParaPrefeitura createRecuperaEmpreendimentosDeferidosParaPrefeitura() {
        return new RecuperaEmpreendimentosDeferidosParaPrefeitura();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConfirmacaoRecebimentoEmpreendimentoPelaPrefeituraResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.jucemg.mg.gov.br/empreendimento/service", name = "confirmacaoRecebimentoEmpreendimentoPelaPrefeituraResponse")
    public JAXBElement<ConfirmacaoRecebimentoEmpreendimentoPelaPrefeituraResponse> createConfirmacaoRecebimentoEmpreendimentoPelaPrefeituraResponse(ConfirmacaoRecebimentoEmpreendimentoPelaPrefeituraResponse value) {
        return new JAXBElement<ConfirmacaoRecebimentoEmpreendimentoPelaPrefeituraResponse>(_ConfirmacaoRecebimentoEmpreendimentoPelaPrefeituraResponse_QNAME, ConfirmacaoRecebimentoEmpreendimentoPelaPrefeituraResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RecuperaEmpreendimentosDeferidosParaPrefeitura }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.jucemg.mg.gov.br/empreendimento/service", name = "recuperaEmpreendimentosDeferidosParaPrefeitura")
    public JAXBElement<RecuperaEmpreendimentosDeferidosParaPrefeitura> createRecuperaEmpreendimentosDeferidosParaPrefeitura(RecuperaEmpreendimentosDeferidosParaPrefeitura value) {
        return new JAXBElement<RecuperaEmpreendimentosDeferidosParaPrefeitura>(_RecuperaEmpreendimentosDeferidosParaPrefeitura_QNAME, RecuperaEmpreendimentosDeferidosParaPrefeitura.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConfirmaAlvaraInscricaoMunicipalResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.jucemg.mg.gov.br/empreendimento/service", name = "confirmaAlvaraInscricaoMunicipalResponse")
    public JAXBElement<ConfirmaAlvaraInscricaoMunicipalResponse> createConfirmaAlvaraInscricaoMunicipalResponse(ConfirmaAlvaraInscricaoMunicipalResponse value) {
        return new JAXBElement<ConfirmaAlvaraInscricaoMunicipalResponse>(_ConfirmaAlvaraInscricaoMunicipalResponse_QNAME, ConfirmaAlvaraInscricaoMunicipalResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RecuperaEmpreendimentosDeferidosParaPrefeituraResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.jucemg.mg.gov.br/empreendimento/service", name = "recuperaEmpreendimentosDeferidosParaPrefeituraResponse")
    public JAXBElement<RecuperaEmpreendimentosDeferidosParaPrefeituraResponse> createRecuperaEmpreendimentosDeferidosParaPrefeituraResponse(RecuperaEmpreendimentosDeferidosParaPrefeituraResponse value) {
        return new JAXBElement<RecuperaEmpreendimentosDeferidosParaPrefeituraResponse>(_RecuperaEmpreendimentosDeferidosParaPrefeituraResponse_QNAME, RecuperaEmpreendimentosDeferidosParaPrefeituraResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConfirmaAlvaraInscricaoMunicipal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.jucemg.mg.gov.br/empreendimento/service", name = "confirmaAlvaraInscricaoMunicipal")
    public JAXBElement<ConfirmaAlvaraInscricaoMunicipal> createConfirmaAlvaraInscricaoMunicipal(ConfirmaAlvaraInscricaoMunicipal value) {
        return new JAXBElement<ConfirmaAlvaraInscricaoMunicipal>(_ConfirmaAlvaraInscricaoMunicipal_QNAME, ConfirmaAlvaraInscricaoMunicipal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConfirmacaoRecebimentoEmpreendimentoPelaPrefeitura }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.jucemg.mg.gov.br/empreendimento/service", name = "confirmacaoRecebimentoEmpreendimentoPelaPrefeitura")
    public JAXBElement<ConfirmacaoRecebimentoEmpreendimentoPelaPrefeitura> createConfirmacaoRecebimentoEmpreendimentoPelaPrefeitura(ConfirmacaoRecebimentoEmpreendimentoPelaPrefeitura value) {
        return new JAXBElement<ConfirmacaoRecebimentoEmpreendimentoPelaPrefeitura>(_ConfirmacaoRecebimentoEmpreendimentoPelaPrefeitura_QNAME, ConfirmacaoRecebimentoEmpreendimentoPelaPrefeitura.class, null, value);
    }

}
