package api;

import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public class ClientHelper {

	public static class AcceptAllCertificatesAllHosts {
		
		public static Client createClient() {
			// Create a trust manager that does not validate certificate chains
			TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {

				public X509Certificate[] getAcceptedIssuers() {
					return null;
				}

				public void checkClientTrusted(X509Certificate[] certs,
						String authType) {
				}

				public void checkServerTrusted(X509Certificate[] certs,
						String authType) {
				}
			} };

			// Install the all-trusting trust manager
			SSLContext sc = null;
			try {
				sc = SSLContext.getInstance("SSL");
				sc.init(null, trustAllCerts, new SecureRandom());
				HttpsURLConnection.setDefaultSSLSocketFactory(sc
						.getSocketFactory());
			} catch (Exception e) {
			}

			HostnameVerifier allHostsValid = new HostnameVerifier() {
				
				public boolean verify(String hostname, SSLSession session) {
					return true;
				}
			};

			Client client = ClientBuilder.newBuilder().sslContext(sc).hostnameVerifier(allHostsValid).build();
			return client;

		}
	}
}

