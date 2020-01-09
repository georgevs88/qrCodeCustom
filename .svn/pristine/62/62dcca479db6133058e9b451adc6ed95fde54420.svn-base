package pmcg.imti.view.ws;

public class AppWSProxy implements pmcg.imti.view.ws.AppWS {
  private String _endpoint = null;
  private pmcg.imti.view.ws.AppWS appWS = null;
  
  public AppWSProxy() {
    _initAppWSProxy();
  }
  
  public AppWSProxy(String endpoint) {
    _endpoint = endpoint;
    _initAppWSProxy();
  }
  
  private void _initAppWSProxy() {
    try {
      appWS = (new pmcg.imti.view.ws.AppWSServiceLocator()).getWebServiceGTM();
      if (appWS != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)appWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)appWS)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (appWS != null)
      ((javax.xml.rpc.Stub)appWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public pmcg.imti.view.ws.AppWS getAppWS() {
    if (appWS == null)
      _initAppWSProxy();
    return appWS;
  }
  
  public java.lang.String consultaCadastroEconomico(java.lang.String mensagem) throws java.rmi.RemoteException{
    if (appWS == null)
      _initAppWSProxy();
    return appWS.consultaCadastroEconomico(mensagem);
  }
  
  public java.lang.String consultaCadastroEconomicoPorContador(java.lang.String mensagem) throws java.rmi.RemoteException{
    if (appWS == null)
      _initAppWSProxy();
    return appWS.consultaCadastroEconomicoPorContador(mensagem);
  }
  
  public java.lang.String consultaPagamentoGuiaDam(java.lang.String mensagem) throws java.rmi.RemoteException{
    if (appWS == null)
      _initAppWSProxy();
    return appWS.consultaPagamentoGuiaDam(mensagem);
  }
  
  public java.lang.String consultaAutoIss(java.lang.String mensagem) throws java.rmi.RemoteException{
    if (appWS == null)
      _initAppWSProxy();
    return appWS.consultaAutoIss(mensagem);
  }
  
  public java.lang.String consultaPagamentoAidf(java.lang.String mensagem) throws java.rmi.RemoteException{
    if (appWS == null)
      _initAppWSProxy();
    return appWS.consultaPagamentoAidf(mensagem);
  }
  
  public java.lang.String consultaExtratoFinanceiro(java.lang.String mensagem) throws java.rmi.RemoteException{
    if (appWS == null)
      _initAppWSProxy();
    return appWS.consultaExtratoFinanceiro(mensagem);
  }
  
  public java.lang.Object[] consultaExtratoDebito(java.lang.String mensagem) throws java.rmi.RemoteException{
    if (appWS == null)
      _initAppWSProxy();
    return appWS.consultaExtratoDebito(mensagem);
  }
  
  public java.lang.String emiteGuiaDam(java.lang.String mensagem) throws java.rmi.RemoteException{
    if (appWS == null)
      _initAppWSProxy();
    return appWS.emiteGuiaDam(mensagem);
  }
  
  public java.lang.String validaCertidao(java.lang.String mensagem) throws java.rmi.RemoteException{
    if (appWS == null)
      _initAppWSProxy();
    return appWS.validaCertidao(mensagem);
  }
  
  public java.lang.String gravaGuiaDam(java.lang.String mensagem) throws java.rmi.RemoteException{
    if (appWS == null)
      _initAppWSProxy();
    return appWS.gravaGuiaDam(mensagem);
  }
  
  public java.lang.String consultaDebitoCadastroEconomicoImovel(java.lang.String mensagem) throws java.rmi.RemoteException{
    if (appWS == null)
      _initAppWSProxy();
    return appWS.consultaDebitoCadastroEconomicoImovel(mensagem);
  }
  
  public java.lang.String processaArquivoCadastroSincronizado(java.lang.String mensagem) throws java.rmi.RemoteException{
    if (appWS == null)
      _initAppWSProxy();
    return appWS.processaArquivoCadastroSincronizado(mensagem);
  }
  
  public java.lang.String consultaLancamento(java.lang.String mensagem) throws java.rmi.RemoteException{
    if (appWS == null)
      _initAppWSProxy();
    return appWS.consultaLancamento(mensagem);
  }
  
  public java.lang.String solicitaGuiaDam(java.lang.String mensagem) throws java.rmi.RemoteException{
    if (appWS == null)
      _initAppWSProxy();
    return appWS.solicitaGuiaDam(mensagem);
  }
  
  public java.lang.String consultaPagamento(java.lang.String mensagem) throws java.rmi.RemoteException{
    if (appWS == null)
      _initAppWSProxy();
    return appWS.consultaPagamento(mensagem);
  }
  
  public java.lang.String consultaPosicaoDiaria(java.lang.String mensagem) throws java.rmi.RemoteException{
    if (appWS == null)
      _initAppWSProxy();
    return appWS.consultaPosicaoDiaria(mensagem);
  }
  
  public java.lang.String obterCDAs(java.lang.String mensagem) throws java.rmi.RemoteException{
    if (appWS == null)
      _initAppWSProxy();
    return appWS.obterCDAs(mensagem);
  }
  
  public java.lang.String obterDadosCDAs(java.lang.String mensagem) throws java.rmi.RemoteException{
    if (appWS == null)
      _initAppWSProxy();
    return appWS.obterDadosCDAs(mensagem);
  }
  
  public java.lang.String gravaCadastroEconomico(java.lang.String entradaGravaCadastroEconomicoXML) throws java.rmi.RemoteException{
    if (appWS == null)
      _initAppWSProxy();
    return appWS.gravaCadastroEconomico(entradaGravaCadastroEconomicoXML);
  }
  
  public java.lang.String registraRetornoProcessoForum(java.lang.String mensagem) throws java.rmi.RemoteException{
    if (appWS == null)
      _initAppWSProxy();
    return appWS.registraRetornoProcessoForum(mensagem);
  }
  
  public java.lang.String solicitaCodigoAutenticidade(java.lang.String mensagem) throws java.rmi.RemoteException{
    if (appWS == null)
      _initAppWSProxy();
    return appWS.solicitaCodigoAutenticidade(mensagem);
  }
  
  public java.lang.String gravaLicencas(java.lang.String mensagem) throws java.rmi.RemoteException{
    if (appWS == null)
      _initAppWSProxy();
    return appWS.gravaLicencas(mensagem);
  }
  
  public java.lang.String gravaGuiaDamCGR(java.lang.String mensagem) throws java.rmi.RemoteException{
    if (appWS == null)
      _initAppWSProxy();
    return appWS.gravaGuiaDamCGR(mensagem);
  }
  
  public java.lang.String gravaDocumentoArrecadacao(java.lang.String mensagem) throws java.rmi.RemoteException{
    if (appWS == null)
      _initAppWSProxy();
    return appWS.gravaDocumentoArrecadacao(mensagem);
  }
  
  public java.lang.String gravaContratoParcelamento(java.lang.String mensagem) throws java.rmi.RemoteException{
    if (appWS == null)
      _initAppWSProxy();
    return appWS.gravaContratoParcelamento(mensagem);
  }
  
  public java.lang.String alteraSituacaoCadastroEconomico(java.lang.String mensagem) throws java.rmi.RemoteException{
    if (appWS == null)
      _initAppWSProxy();
    return appWS.alteraSituacaoCadastroEconomico(mensagem);
  }
  
  public java.lang.String processaArquivoAutoInfracaoV1(java.lang.String mensagem) throws java.rmi.RemoteException{
    if (appWS == null)
      _initAppWSProxy();
    return appWS.processaArquivoAutoInfracaoV1(mensagem);
  }
  
  public java.lang.String solicitaDocArrecadacaoAutoInfracao(java.lang.String mensagem) throws java.rmi.RemoteException{
    if (appWS == null)
      _initAppWSProxy();
    return appWS.solicitaDocArrecadacaoAutoInfracao(mensagem);
  }
  
  public java.lang.String solicitaGuiaDamTaxaDiversa(java.lang.String mensagem) throws java.rmi.RemoteException{
    if (appWS == null)
      _initAppWSProxy();
    return appWS.solicitaGuiaDamTaxaDiversa(mensagem);
  }
  
  public java.lang.String emiteCertidao(java.lang.String mensagem) throws java.rmi.RemoteException{
    if (appWS == null)
      _initAppWSProxy();
    return appWS.emiteCertidao(mensagem);
  }
  
  public java.lang.String verificaAutenticidadeCertidao(java.lang.String mensagem) throws java.rmi.RemoteException{
    if (appWS == null)
      _initAppWSProxy();
    return appWS.verificaAutenticidadeCertidao(mensagem);
  }
  
  public java.lang.String verificaPagamentoGuia(java.lang.String mensagem) throws java.rmi.RemoteException{
    if (appWS == null)
      _initAppWSProxy();
    return appWS.verificaPagamentoGuia(mensagem);
  }
  
  public java.lang.String emiteFichaCadastral(java.lang.String mensagem) throws java.rmi.RemoteException{
    if (appWS == null)
      _initAppWSProxy();
    return appWS.emiteFichaCadastral(mensagem);
  }
  
  public java.lang.String emiteExtratoDebitos(java.lang.String mensagem) throws java.rmi.RemoteException{
    if (appWS == null)
      _initAppWSProxy();
    return appWS.emiteExtratoDebitos(mensagem);
  }
  
  
}