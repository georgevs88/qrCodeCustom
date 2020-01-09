package pmcg.fcn.prefeitura;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.servlet.http.HttpServletRequest;

import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.configuration.security.FiltersType;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.ConnectionType;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

public class ClienteSSL {

    public static void configurar_Cliente_SSL(Object service) throws Exception {
	System.setProperty("sun.security.ssl.allowUnsafeRenegotiation", "true");
	configurar_Http_Conduit(service);
    }

    public static void configurar_Http_Conduit(Object service) throws Exception {
	Client client = ClientProxy.getClient(service);
	HTTPConduit httpConduit = (HTTPConduit) client.getConduit();
	TLSClientParameters tlsParams = new TLSClientParameters();
	tlsParams.setDisableCNCheck(true);
	adicionar_Truststore(tlsParams);
	adicionar_Keystore(tlsParams);
	adicionar_Filtros(tlsParams);

	httpConduit.setTlsClientParameters(tlsParams);
	httpConduit.setClient(configurar_Http_Client_Policy());
    }

    public static HTTPClientPolicy configurar_Http_Client_Policy() {
	HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();

	httpClientPolicy.setConnectionTimeout(36000);
	httpClientPolicy.setAllowChunking(false);
	httpClientPolicy.setReceiveTimeout(32000);
	httpClientPolicy.setConnection(ConnectionType.KEEP_ALIVE);

	return httpClientPolicy;
    }

    public static void adicionar_Filtros(TLSClientParameters tlsParams) {
    	FiltersType filter = new FiltersType();
    	filter.getInclude().add(".*_EXPORT_.*");
    	filter.getInclude().add(".*_EXPORT1024_.*");
    	filter.getInclude().add(".*_WITH_DES_.*");
    	filter.getInclude().add(".*_WITH_NULL_.*");
    	filter.getInclude().add("DES-CBC-SHA");
    	filter.getInclude().add("SSL_RSA_WITH_RC4_128_MD5");
    	filter.getInclude().add("TLS_RSA_WITH_AES_128_CBC_SHA");
    	filter.getInclude().add("SSL_RSA_WITH_RC4_128_SHA");
    	filter.getInclude().add("SSL_RSA_WITH_DES_CBC_SHA");
    	filter.getInclude().add("SSL_RSA_WITH_3DES_EDE_CBC_SHA");

    	filter.getExclude().add(".*_DH_anon_.*");
    	
    	tlsParams.setCipherSuitesFilter(filter);
	}

    public static void adicionar_Keystore(TLSClientParameters tlsParams) throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException,
	    FileNotFoundException, UnrecoverableKeyException {

	KeyStore keyStore = KeyStore.getInstance("PKCS12");
	keyStore.load(new FileInputStream(new File(Constantes.Certificados.arquivo_pfx)), new String(Constantes.Certificados.senha_pfx).toCharArray());
	KeyManagerFactory keyFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
	keyFactory.init(keyStore, new String(Constantes.Certificados.senha_pfx).toCharArray());
	KeyManager[] keyMgr = keyFactory.getKeyManagers();
	tlsParams.setKeyManagers(keyMgr);
    }

    public static void adicionar_Truststore(TLSClientParameters tlsParams) throws KeyStoreException, IOException, NoSuchAlgorithmException,
	    CertificateException, FileNotFoundException {

	KeyStore keyStore = KeyStore.getInstance("JCEKS");
	keyStore.load(new FileInputStream(new File(Constantes.Certificados.arquivo_jks)), new String(Constantes.Certificados.senha_jks).toCharArray());
	TrustManagerFactory trustFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
	trustFactory.init(keyStore);
	TrustManager[] trustMgr = trustFactory.getTrustManagers();
	tlsParams.setTrustManagers(trustMgr);
    }

    public static boolean possui_Certificado_Na_Conexao(HttpServletRequest request) {
	if (request.isSecure()) {
	    java.security.cert.X509Certificate[] certs = (java.security.cert.X509Certificate[]) request.getAttribute("javax.servlet.request.X509Certificate");
	    if (certs != null && certs.length > 0) {
		System.out.println("Possui Certificado Na Conexão");
		return true;
	    } else {
		System.out.println("Não Possui o Certificado na Conexão. refazer validação.");
		return false;
	    }
	}
	System.out.println("Não Possui o Certificado na Conexão. refazer validação.");
	return false;
    }

}
