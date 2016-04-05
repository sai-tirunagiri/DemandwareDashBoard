package org.quinnox.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.quinnox.pojo.GooglePojo;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Oauth2callback extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Oauth2callback() {
        super();
        
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        
        System.out.println("entering doGet");
        try {
            // get code
            String code = request.getParameter("code");
            // format parameters to post
            String urlParameters = "code="
                    + code
                    + "&client_id=238431647655-sjevuh415i09i9512qtmp74gsmuohl27.apps.googleusercontent.com"
                    + "&client_secret=qgKdRt5g8U7icTX8KX-KxS0R"
                    + "&redirect_uri=http://demandwaredashboard-prod.mot.com/FileDashBoard/Oauth2callback"
                    + "&grant_type=authorization_code";
            
            //post parameters
            URL url = new URL("https://accounts.google.com/o/oauth2/token");
            URLConnection urlConn = url.openConnection();
            urlConn.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(
                    urlConn.getOutputStream());
            writer.write(urlParameters);
            writer.flush();
            
            //get output in outputString 
            String line, outputString = "";
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    urlConn.getInputStream()));
            while ((line = reader.readLine()) != null) {
                outputString += line;
            }
            System.out.println(outputString);
            
            //get Access Token 
            JsonObject json = (JsonObject)new JsonParser().parse(outputString);
            String access_token = json.get("access_token").getAsString();
            System.out.println(access_token);
           
            TrustManager[] trustAllCerts = new TrustManager[] {
            	       new X509TrustManager() {
            	          public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            	            return null;
            	          }

            	          public void checkClientTrusted(X509Certificate[] certs, String authType) {  }

            	          public void checkServerTrusted(X509Certificate[] certs, String authType) {  }

            	       }
            };
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            
         // Create all-trusting host name verifier
            HostnameVerifier allHostsValid = new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) {
                  return true;
                }

				public boolean verify1(String arg0, SSLSession arg1) {
					// TODO Auto-generated method stub
					return false;
				}
            };
            
         // Install the all-trusting host verifier
            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
            /*
             * end of the fix
             */
                       
            //get User Info 
            url = new URL(
                    "https://www.googleapis.com/oauth2/v1/userinfo?access_token="
                            + access_token);
            urlConn = url.openConnection();
            outputString = "";
            reader = new BufferedReader(new InputStreamReader(
                    urlConn.getInputStream()));
            while ((line = reader.readLine()) != null) {
                outputString += line;
            }
            System.out.println(outputString);
            
            // Convert JSON response into Pojo class
            GooglePojo data = new Gson().fromJson(outputString, GooglePojo.class);
            System.out.println(data);
            writer.close();
            reader.close();
           
            response.sendRedirect("home.jsp");
            
        } catch (MalformedURLException e) {
            System.out.println( e);
            e.printStackTrace();
        } catch (ProtocolException e) {
            System.out.println( e);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println( e);
            e.printStackTrace();
        } catch (KeyManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("leaving doGet");
    }

}