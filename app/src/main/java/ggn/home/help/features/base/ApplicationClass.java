package ggn.home.help.features.base;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.StrictMode;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.facebook.FacebookSdk;

import java.util.concurrent.Executors;

import ggn.home.help.web.Web;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApplicationClass extends MultiDexApplication {
    private static Retrofit retrofit;
    private static String userId;
    private static String authToken;

    public static Retrofit getRetrofit(Context context) {
        initRetrofitModule(context);
        return retrofit;
    }

    public static void resetRetrofit() {
        retrofit = null;
    }

    public static void setUserId(String userId) {
        ApplicationClass.userId = userId;
    }

    public static void setAuthToken(String authToken) {
        ApplicationClass.authToken = authToken;
    }

    public static String getUserId() {
        return userId;
    }

    public static String getAuthToken() {
        return authToken;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);

    }

    @Override
    public void onCreate() {
        super.onCreate();

        sInstance = this;
        FacebookSdk.sdkInitialize(getApplicationContext());

//        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/Gotham-Light_0.ttf");
        //for camera
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());
        }

        initRetrofitModule(getApplicationContext());
    }

    private static void initRetrofitModule(Context context) {
        retrofit = new Retrofit.Builder()
                .baseUrl(Web.Path.BASE_URL)
                .callbackExecutor(Executors.newFixedThreadPool(5))
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .client(okClient(context))
                .build();
    }

//    private static OkHttpClient okClient(Context context) {
//        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//
//        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
//        httpClient.connectTimeout(1, TimeUnit.MINUTES);
//        httpClient.readTimeout(1, TimeUnit.MINUTES);
//        httpClient.addInterceptor(interceptor);
//
//        return httpClient.build();
//    }

//    private static OkHttpClient okClient(Context context) {
//        CertificateFactory cf;
//        InputStream cert = null;
//        Certificate ca;
//        String keyStoreType = KeyStore.getDefaultType();
//        KeyStore keyStore = null;
//        try {
//            cf = CertificateFactory.getInstance("X.509");
//            cert = context.getResources().openRawResource(R.raw.my_cert_farmx);
//            ca = cf.generateCertificate(cert);
//            keyStore = KeyStore.getInstance(keyStoreType);
//            keyStore.load(null, null);
//            keyStore.setCertificateEntry("ca", ca);
//        } catch (CertificateException e) {
//            e.printStackTrace();
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        } catch (KeyStoreException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                cert.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        // creating a TrustManager that trusts the CAs in our KeyStore
//        String tmfAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
//        TrustManagerFactory tmf = null;
//        try {
//            tmf = TrustManagerFactory.getInstance(tmfAlgorithm);
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//        try {
//            tmf.init(keyStore);
//        } catch (KeyStoreException e) {
//            e.printStackTrace();
//        }
//
//        // creating an SSLSocketFactory that uses our TrustManager
//        SSLContext sslContext = null;
//        try {
//            sslContext = SSLContext.getInstance("TLS");
//            sslContext.init(null, tmf.getTrustManagers(), null);
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        } catch (KeyManagementException e) {
//            e.printStackTrace();
//        }
//
//        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//
//        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
//        httpClient.sslSocketFactory(sslContext.getSocketFactory());
//        httpClient.connectTimeout(1, TimeUnit.MINUTES);
//        httpClient.readTimeout(1, TimeUnit.MINUTES);
//        httpClient.addInterceptor(interceptor);
//
//        return httpClient.build();
//    }

    private static ApplicationClass sInstance = null;

    // Getter to access Singleton instance
    public static ApplicationClass getInstance() {
        return sInstance;
    }

    public static boolean isActivityVisible() {
        return activityVisible;
    }

    public static void activityResumed() {
        activityVisible = true;
    }

    public static void activityPaused() {
        activityVisible = false;
    }

    private static boolean activityVisible;
}
