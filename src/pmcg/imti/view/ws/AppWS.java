/**
 * AppWS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pmcg.imti.view.ws;

public interface AppWS extends java.rmi.Remote {
    public java.lang.String consultaCadastroEconomico(java.lang.String mensagem) throws java.rmi.RemoteException;
    public java.lang.String consultaCadastroEconomicoPorContador(java.lang.String mensagem) throws java.rmi.RemoteException;
    public java.lang.String consultaPagamentoGuiaDam(java.lang.String mensagem) throws java.rmi.RemoteException;
    public java.lang.String consultaAutoIss(java.lang.String mensagem) throws java.rmi.RemoteException;
    public java.lang.String consultaPagamentoAidf(java.lang.String mensagem) throws java.rmi.RemoteException;
    public java.lang.String consultaExtratoFinanceiro(java.lang.String mensagem) throws java.rmi.RemoteException;
    public java.lang.Object[] consultaExtratoDebito(java.lang.String mensagem) throws java.rmi.RemoteException;
    public java.lang.String emiteGuiaDam(java.lang.String mensagem) throws java.rmi.RemoteException;
    public java.lang.String validaCertidao(java.lang.String mensagem) throws java.rmi.RemoteException;
    public java.lang.String gravaGuiaDam(java.lang.String mensagem) throws java.rmi.RemoteException;
    public java.lang.String consultaDebitoCadastroEconomicoImovel(java.lang.String mensagem) throws java.rmi.RemoteException;
    public java.lang.String processaArquivoCadastroSincronizado(java.lang.String mensagem) throws java.rmi.RemoteException;
    public java.lang.String consultaLancamento(java.lang.String mensagem) throws java.rmi.RemoteException;
    public java.lang.String solicitaGuiaDam(java.lang.String mensagem) throws java.rmi.RemoteException;
    public java.lang.String consultaPagamento(java.lang.String mensagem) throws java.rmi.RemoteException;
    public java.lang.String consultaPosicaoDiaria(java.lang.String mensagem) throws java.rmi.RemoteException;
    public java.lang.String obterCDAs(java.lang.String mensagem) throws java.rmi.RemoteException;
    public java.lang.String obterDadosCDAs(java.lang.String mensagem) throws java.rmi.RemoteException;
    public java.lang.String gravaCadastroEconomico(java.lang.String entradaGravaCadastroEconomicoXML) throws java.rmi.RemoteException;
    public java.lang.String registraRetornoProcessoForum(java.lang.String mensagem) throws java.rmi.RemoteException;
    public java.lang.String solicitaCodigoAutenticidade(java.lang.String mensagem) throws java.rmi.RemoteException;
    public java.lang.String gravaLicencas(java.lang.String mensagem) throws java.rmi.RemoteException;
    public java.lang.String gravaGuiaDamCGR(java.lang.String mensagem) throws java.rmi.RemoteException;
    public java.lang.String gravaDocumentoArrecadacao(java.lang.String mensagem) throws java.rmi.RemoteException;
    public java.lang.String gravaContratoParcelamento(java.lang.String mensagem) throws java.rmi.RemoteException;
    public java.lang.String alteraSituacaoCadastroEconomico(java.lang.String mensagem) throws java.rmi.RemoteException;
    public java.lang.String processaArquivoAutoInfracaoV1(java.lang.String mensagem) throws java.rmi.RemoteException;
    public java.lang.String solicitaDocArrecadacaoAutoInfracao(java.lang.String mensagem) throws java.rmi.RemoteException;
    public java.lang.String solicitaGuiaDamTaxaDiversa(java.lang.String mensagem) throws java.rmi.RemoteException;
    public java.lang.String emiteCertidao(java.lang.String mensagem) throws java.rmi.RemoteException;
    public java.lang.String verificaAutenticidadeCertidao(java.lang.String mensagem) throws java.rmi.RemoteException;
    public java.lang.String verificaPagamentoGuia(java.lang.String mensagem) throws java.rmi.RemoteException;
    public java.lang.String emiteFichaCadastral(java.lang.String mensagem) throws java.rmi.RemoteException;
    public java.lang.String emiteExtratoDebitos(java.lang.String mensagem) throws java.rmi.RemoteException;
}
