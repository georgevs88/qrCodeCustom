
package pmcg.fcn.prefeitura.cliente.viabilidade;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the prefeitura.cliente.viabilidade package. 
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

    private final static QName _ConfirmaRespostaAnaliseEnderecoResponse_QNAME = new QName("http://www.jucemg.mg.gov.br/empreendimento/service", "confirmaRespostaAnaliseEnderecoResponse");
    private final static QName _ConfirmaRecebimentoViabilidade_QNAME = new QName("http://www.jucemg.mg.gov.br/empreendimento/service", "confirmaRecebimentoViabilidade");
    private final static QName _ConfirmaRecebimentoViabilidadeResponse_QNAME = new QName("http://www.jucemg.mg.gov.br/empreendimento/service", "confirmaRecebimentoViabilidadeResponse");
    private final static QName _RecuperaViabilidadesPendentesResponse_QNAME = new QName("http://www.jucemg.mg.gov.br/empreendimento/service", "recuperaViabilidadesPendentesResponse");
    private final static QName _RecuperaViabilidadesPendentes_QNAME = new QName("http://www.jucemg.mg.gov.br/empreendimento/service", "recuperaViabilidadesPendentes");
    private final static QName _ConfirmaRespostaAnaliseEndereco_QNAME = new QName("http://www.jucemg.mg.gov.br/empreendimento/service", "confirmaRespostaAnaliseEndereco");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: prefeitura.cliente.viabilidade
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConfirmaRespostaAnaliseEnderecoResponse }
     * 
     */
    public ConfirmaRespostaAnaliseEnderecoResponse createConfirmaRespostaAnaliseEnderecoResponse() {
        return new ConfirmaRespostaAnaliseEnderecoResponse();
    }

    /**
     * Create an instance of {@link RecuperaViabilidadesPendentes }
     * 
     */
    public RecuperaViabilidadesPendentes createRecuperaViabilidadesPendentes() {
        return new RecuperaViabilidadesPendentes();
    }

    /**
     * Create an instance of {@link ConfirmaRecebimentoViabilidadeResponse }
     * 
     */
    public ConfirmaRecebimentoViabilidadeResponse createConfirmaRecebimentoViabilidadeResponse() {
        return new ConfirmaRecebimentoViabilidadeResponse();
    }

    /**
     * Create an instance of {@link RecuperaViabilidadesPendentesResponse }
     * 
     */
    public RecuperaViabilidadesPendentesResponse createRecuperaViabilidadesPendentesResponse() {
        return new RecuperaViabilidadesPendentesResponse();
    }

    /**
     * Create an instance of {@link ConfirmaRespostaAnaliseEndereco }
     * 
     */
    public ConfirmaRespostaAnaliseEndereco createConfirmaRespostaAnaliseEndereco() {
        return new ConfirmaRespostaAnaliseEndereco();
    }

    /**
     * Create an instance of {@link ConfirmaRecebimentoViabilidade }
     * 
     */
    public ConfirmaRecebimentoViabilidade createConfirmaRecebimentoViabilidade() {
        return new ConfirmaRecebimentoViabilidade();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConfirmaRespostaAnaliseEnderecoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.jucemg.mg.gov.br/empreendimento/service", name = "confirmaRespostaAnaliseEnderecoResponse")
    public JAXBElement<ConfirmaRespostaAnaliseEnderecoResponse> createConfirmaRespostaAnaliseEnderecoResponse(ConfirmaRespostaAnaliseEnderecoResponse value) {
        return new JAXBElement<ConfirmaRespostaAnaliseEnderecoResponse>(_ConfirmaRespostaAnaliseEnderecoResponse_QNAME, ConfirmaRespostaAnaliseEnderecoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConfirmaRecebimentoViabilidade }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.jucemg.mg.gov.br/empreendimento/service", name = "confirmaRecebimentoViabilidade")
    public JAXBElement<ConfirmaRecebimentoViabilidade> createConfirmaRecebimentoViabilidade(ConfirmaRecebimentoViabilidade value) {
        return new JAXBElement<ConfirmaRecebimentoViabilidade>(_ConfirmaRecebimentoViabilidade_QNAME, ConfirmaRecebimentoViabilidade.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConfirmaRecebimentoViabilidadeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.jucemg.mg.gov.br/empreendimento/service", name = "confirmaRecebimentoViabilidadeResponse")
    public JAXBElement<ConfirmaRecebimentoViabilidadeResponse> createConfirmaRecebimentoViabilidadeResponse(ConfirmaRecebimentoViabilidadeResponse value) {
        return new JAXBElement<ConfirmaRecebimentoViabilidadeResponse>(_ConfirmaRecebimentoViabilidadeResponse_QNAME, ConfirmaRecebimentoViabilidadeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RecuperaViabilidadesPendentesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.jucemg.mg.gov.br/empreendimento/service", name = "recuperaViabilidadesPendentesResponse")
    public JAXBElement<RecuperaViabilidadesPendentesResponse> createRecuperaViabilidadesPendentesResponse(RecuperaViabilidadesPendentesResponse value) {
        return new JAXBElement<RecuperaViabilidadesPendentesResponse>(_RecuperaViabilidadesPendentesResponse_QNAME, RecuperaViabilidadesPendentesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RecuperaViabilidadesPendentes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.jucemg.mg.gov.br/empreendimento/service", name = "recuperaViabilidadesPendentes")
    public JAXBElement<RecuperaViabilidadesPendentes> createRecuperaViabilidadesPendentes(RecuperaViabilidadesPendentes value) {
        return new JAXBElement<RecuperaViabilidadesPendentes>(_RecuperaViabilidadesPendentes_QNAME, RecuperaViabilidadesPendentes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConfirmaRespostaAnaliseEndereco }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.jucemg.mg.gov.br/empreendimento/service", name = "confirmaRespostaAnaliseEndereco")
    public JAXBElement<ConfirmaRespostaAnaliseEndereco> createConfirmaRespostaAnaliseEndereco(ConfirmaRespostaAnaliseEndereco value) {
        return new JAXBElement<ConfirmaRespostaAnaliseEndereco>(_ConfirmaRespostaAnaliseEndereco_QNAME, ConfirmaRespostaAnaliseEndereco.class, null, value);
    }

}
