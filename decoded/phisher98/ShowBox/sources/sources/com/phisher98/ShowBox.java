package com.phisher98;

import android.content.SharedPreferences;
import android.util.Base64;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.lagradost.cloudstream3.APIHolder;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.MovieLoadResponse;
import com.lagradost.cloudstream3.MovieSearchResponse;
import com.lagradost.cloudstream3.ParCollectionsKt;
import com.lagradost.cloudstream3.Score;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.ranges.CharRange;
import kotlin.ranges.IntRange;
import kotlin.reflect.KType;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ShowBox.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/ShowBox/classes.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\b\u0016\u0018\u0000 [2\u00020\u0001:#[\\]^_`abcdefghijklmnopqrstuvwxyz{|}B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u001d\u001a\u00020\u0007H\u0002J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0007J\u000e\u0010%\u001a\u00020&2\u0006\u0010$\u001a\u00020\u0007J\u0006\u0010'\u001a\u00020(J\u0016\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\rJ\"\u0010,\u001a\u0002H-\"\n\b\u0000\u0010-\u0018\u0001*\u00020.2\u0006\u0010*\u001a\u00020\u0007H\u0086\b¢\u0006\u0002\u0010/J\u0006\u00100\u001a\u000201J\u001e\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020HH\u0096@¢\u0006\u0002\u0010IJ\u001c\u0010J\u001a\b\u0012\u0004\u0012\u00020L0K2\u0006\u0010*\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010MJ\u0016\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010MJF\u0010Q\u001a\u00020\r2\u0006\u0010R\u001a\u00020\u00072\u0006\u0010S\u001a\u00020\r2\u0012\u0010T\u001a\u000e\u0012\u0004\u0012\u00020V\u0012\u0004\u0012\u00020W0U2\u0012\u0010X\u001a\u000e\u0012\u0004\u0012\u00020Y\u0012\u0004\u0012\u00020W0UH\u0096@¢\u0006\u0002\u0010ZR\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\rX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\rX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\tR\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u00105\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\tR\u0011\u00107\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\tR\u0014\u00109\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\tR\u0014\u0010;\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\tR\u000e\u0010=\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010>\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\tR\u000e\u0010@\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000¨\u0006~"}, d2 = {"Lcom/phisher98/ShowBox;", "Lcom/lagradost/cloudstream3/MainAPI;", "sharedPref", "Landroid/content/SharedPreferences;", "<init>", "(Landroid/content/SharedPreferences;)V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "hasMainPage", "", "getHasMainPage", "()Z", "hasChromecastSupport", "getHasChromecastSupport", "instantLinkLoading", "getInstantLinkLoading", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "uitoken", "getUitoken", "headers", "", "randomToken", "token", "cinemeta_url", "CLIENT_CERT_PEM", "CLIENT_KEY_PEM", "loadCertificateFromPem", "Ljava/security/cert/X509Certificate;", "pem", "loadPrivateKeyFromPem", "Ljava/security/PrivateKey;", "buildClientWithCert", "Lokhttp3/OkHttpClient;", "queryApi", "query", "useAlternativeApi", "queryApiParsed", "T", "", "(Ljava/lang/String;)Ljava/lang/Object;", "getExpiryDate", "", "iv", "key", "firstAPI", "secondAPI", "getSecondAPI", "thirdAPI", "getThirdAPI", "watchSomuchAPI", "getWatchSomuchAPI", "openSubAPI", "getOpenSubAPI", "appKey", "appId", "getAppId", "appIdSecond", "appVersion", "appVersionCode", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "ResponseTypes", "UserAgentInterceptor", "CipherUtils", "HexDump", "MD5Util", "PostJSON", "ListJSON", "DataJSON", "Data", "MainData", "LoadData", "MovieData", "MovieDataProp", "SeriesDataProp", "SeriesSeasonProp", "SeriesLanguage", "SeriesEpisode", "SeriesData", "LinkData", "LinkDataProp", "LinkList", "ParsedLinkData", "SubtitleDataProp", "Subtitles", "SubtitleList", "PrivateSubtitleData", "ExternalResponse", "WatchsomuchTorrents", "WatchsomuchMovies", "WatchsomuchResponses", "WatchsomuchSubtitles", "WatchsomuchSubResponses", "OsSubtitles", "OsResult", "ShowBox"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nShowBox.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ShowBox.kt\ncom/phisher98/ShowBox\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 6 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,946:1\n365#1,12:949\n365#1,12:993\n365#1,12:1038\n365#1,12:1050\n221#2,2:947\n1#3:961\n1#3:984\n1#3:987\n1#3:1016\n1#3:1020\n1#3:1063\n1795#4,10:962\n2068#4:972\n1795#4,10:973\n2068#4:983\n2069#4:985\n1805#4:986\n2069#4:988\n1805#4:989\n1960#4,3:990\n1795#4,10:1005\n2068#4:1015\n2069#4:1017\n1805#4:1018\n63#5:1019\n64#5,15:1021\n63#5:1062\n64#5,15:1064\n50#6:1036\n43#6:1037\n50#6:1079\n43#6:1080\n*S KotlinDebug\n*F\n+ 1 ShowBox.kt\ncom/phisher98/ShowBox\n*L\n444#1:949,12\n514#1:993,12\n681#1:1038,12\n707#1:1050,12\n349#1:947,2\n453#1:984\n450#1:987\n514#1:1016\n662#1:1020\n840#1:1063\n450#1:962,10\n450#1:972\n453#1:973,10\n453#1:983\n453#1:985\n453#1:986\n450#1:988\n450#1:989\n470#1:990,3\n514#1:1005,10\n514#1:1015\n514#1:1017\n514#1:1018\n662#1:1019\n662#1:1021,15\n840#1:1062\n840#1:1064,15\n662#1:1036\n662#1:1037\n840#1:1079\n840#1:1080\n*E\n"})
public class ShowBox extends MainAPI {

    @NotNull
    private static final String Supertoken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE3NTc3NzEzNjgsIm5iZiI6MTc1Nzc3MTM2OCwiZXhwIjoxNzg4ODc1Mzg4LCJkYXRhIjp7InVpZCI6MTM4NTUxLCJ0b2tlbiI6IjU5ZTEzOWZkMTczZDkwNDVhMmI1ZmMxM2I0MGRmZDg3IiwicGxhdGZvcm0iOiJhbmRyb2lkIn19._CJMdnsymUmXNdTJiaSOftlhUBdfxNuWOKw1StOkHKU";

    @NotNull
    private final String CLIENT_CERT_PEM;

    @NotNull
    private final String CLIENT_KEY_PEM;

    @NotNull
    private final String appId;

    @NotNull
    private final String appIdSecond;

    @NotNull
    private final String appKey;

    @NotNull
    private final String appVersion;

    @NotNull
    private final String appVersionCode;

    @NotNull
    private final String cinemeta_url;

    @NotNull
    private final String firstAPI;
    private final boolean hasChromecastSupport;
    private final boolean hasMainPage;

    @NotNull
    private final Map<String, String> headers;
    private final boolean instantLinkLoading;

    @NotNull
    private final String iv;

    @NotNull
    private final String key;

    @NotNull
    private String name;

    @NotNull
    private final String openSubAPI;

    @NotNull
    private final String secondAPI;

    @NotNull
    private final Set<TvType> supportedTypes;

    @NotNull
    private final String thirdAPI;

    @NotNull
    private final String token;

    @Nullable
    private final String uitoken;

    @NotNull
    private final String watchSomuchAPI;

    /* JADX INFO: renamed from: com.phisher98.ShowBox$load$1 */
    /* JADX INFO: compiled from: ShowBox.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.ShowBox", f = "ShowBox.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6}, l = {685, 686, 688, 711, 712, 714, 742}, m = "load$suspendImpl", n = {"$this", "url", "loadData", "data", "isMovie", "hideNsfw", "$this", "url", "loadData", "data", "meta", "isMovie", "hideNsfw", "$this", "url", "loadData", "data", "meta", "logoUrl", "isMovie", "hideNsfw", "$this", "url", "loadData", "data", "isMovie", "hideNsfw", "$this", "url", "loadData", "data", "meta", "isMovie", "hideNsfw", "$this", "url", "loadData", "data", "meta", "logoUrl", "isMovie", "hideNsfw", "$this", "url", "loadData", "data", "meta", "logoUrl", "allEpisodes", "isMovie", "hideNsfw"}, nl = {686, 688, 707, 712, 714, 740, -1}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1"}, v = 2)
    static final class C00001 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C00001(Continuation<? super C00001> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ShowBox.load$suspendImpl(ShowBox.this, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.ShowBox$loadLinks$1 */
    /* JADX INFO: compiled from: ShowBox.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.ShowBox", f = "ShowBox.kt", i = {0, 0, 0, 0, 0, 0}, l = {842}, m = "loadLinks$suspendImpl", n = {"$this", "data", "subtitleCallback", "callback", "parsed", "isCasting"}, nl = {892}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0"}, v = 2)
    static final class C00031 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00031(Continuation<? super C00031> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ShowBox.loadLinks$suspendImpl(ShowBox.this, null, false, null, null, (Continuation) this);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ShowBox() {
        SharedPreferences sharedPreferences = null;
        this(sharedPreferences, 1, sharedPreferences);
    }

    @Nullable
    public Object getMainPage(int i, @NotNull MainPageRequest mainPageRequest, @NotNull Continuation<? super HomePageResponse> continuation) {
        return getMainPage$suspendImpl(this, i, mainPageRequest, continuation);
    }

    @Nullable
    public Object load(@NotNull String str, @NotNull Continuation<? super LoadResponse> continuation) {
        return load$suspendImpl(this, str, continuation);
    }

    @Nullable
    public Object loadLinks(@NotNull String str, boolean z, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        return loadLinks$suspendImpl(this, str, z, function1, function2, continuation);
    }

    @Nullable
    public Object search(@NotNull String str, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        return search$suspendImpl(this, str, continuation);
    }

    public ShowBox(@Nullable SharedPreferences sharedPref) {
        String string;
        this.name = "ShowBox";
        this.hasMainPage = true;
        this.hasChromecastSupport = true;
        this.instantLinkLoading = true;
        this.supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.TvSeries, TvType.Anime, TvType.AnimeMovie});
        String strSubstringAfter$default = null;
        if (sharedPref != null && (string = sharedPref.getString("token", null)) != null) {
            strSubstringAfter$default = StringsKt.substringAfter$default(string, "ui=", (String) null, 2, (Object) null);
        }
        this.uitoken = strSubstringAfter$default;
        this.headers = MapsKt.mapOf(new Pair[]{TuplesKt.to("Platform", "android"), TuplesKt.to("Accept", "charset=utf-8"), TuplesKt.to("Cookie", "ci=168aec549ca68e")});
        this.token = randomToken();
        this.cinemeta_url = "https://v3-cinemeta.strem.io/meta";
        this.CLIENT_CERT_PEM = "\n-----BEGIN CERTIFICATE-----\nMIIEFTCCAv2gAwIBAgIUCrILmXOevO03gUhhbEhG/wZb2uAwDQYJKoZIhvcNAQEL\nBQAwgagxCzAJBgNVBAYTAlVTMRMwEQYDVQQIEwpDYWxpZm9ybmlhMRYwFAYDVQQH\nEw1TYW4gRnJhbmNpc2NvMRkwFwYDVQQKExBDbG91ZGZsYXJlLCBJbmMuMRswGQYD\nVQQLExJ3d3cuY2xvdWRmbGFyZS5jb20xNDAyBgNVBAMTK01hbmFnZWQgQ0EgM2Q0\nZDQ4ZTQ2ZmI3MGM1NzgxZmI0N2VhNzk4MjMxZDMwHhcNMjQwNjA0MDkxMTAwWhcN\nMzkwNjAxMDkxMTAwWjAiMQswCQYDVQQGEwJVUzETMBEGA1UEAxMKQ2xvdWRmbGFy\nZTCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAJhpMlr/+IatuBqpuZuA\n6QvqdI2QiFb1UMVujb/xiaBC/vqJMlMenLSDysk8xd4fLeC+GC8AyWf1IMJIz6d9\nrBjOhN4D+MxvgphufkdIVqs63SqKcrr/ZL0JaRpxxEg/pKqSjH55Ik71keB8tt0m\nmQ76WK1swMydOAqn6DIKVAi7wF9acWyX/6Ly+cmxfueLDZvkLigXl3gMHbuoa5Y+\nCadqKl2qlijhnvjpuEbAvyDyXWe838TUi0PYMMVuOu7PV4By2LINsm+gKv83od4k\nRCSWTrLKlgfqneqnudMrqeWckNUHGVB+3Lruw1ebB/Rs4gJ59VhJYpbNmM2mYT0r\nVQkCAwEAAaOBuzCBuDATBgNVHSUEDDAKBggrBgEFBQcDAjAMBgNVHRMBAf8EAjAA\nMB0GA1UdDgQWBBSF9Jkz4ZkbS5+LANO3YGWZRuX/PDAfBgNVHSMEGDAWgBTj01Q6\nMJPAjpPqCEcv8rjxAUTO9jBTBgNVHR8ETDBKMEigRqBEhkJodHRwOi8vY3JsLmNs\nb3VkZmxhcmUuY29tL2U1YTYzNzc5LTQ3NWQtNGI5OS04YzQxLTIwMjE5MmZhNjNj\nZC5jcmwwDQYJKoZIhvcNAQELBQADggEBALD+9MsfANm7fbzYH5/lXl07hwn2KSN8\nPH7zxyo87ED62IL9U7YOnhb3rqLS1RXUzyHEmb9kzYgzKzzNrELdKH77vNk172Vk\niRQwGD0MZiYNERWhmmBtjV1oxllz74fL4+aZTYAespIbOekmFn9NZJ+XSdyF9RqS\nfzDiz27GP5ZSHHI6xwdUP+a87N/RnfI4UwGxyXvPpHfoAZWjoXDqLKKwEL36/Sqi\nnGcp970y0gnZ2zI2ehqivsF7BATMZqvU+LJKCH8NEE2bnbCJ6qlPHZWZFNKYWBOe\nI1Crf0gNAWD/q3HKGMVZiyxlhU6SsQS4/08tDXXQjWYfl6i3oviexSk=\n-----END CERTIFICATE-----\n";
        this.CLIENT_KEY_PEM = "\n-----BEGIN PRIVATE KEY-----\nMIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCYaTJa//iGrbga\nqbmbgOkL6nSNkIhW9VDFbo2/8YmgQv76iTJTHpy0g8rJPMXeHy3gvhgvAMln9SDC\nSM+nfawYzoTeA/jMb4KYbn5HSFarOt0qinK6/2S9CWkaccRIP6Sqkox+eSJO9ZHg\nfLbdJpkO+litbMDMnTgKp+gyClQIu8BfWnFsl/+i8vnJsX7niw2b5C4oF5d4DB27\nqGuWPgmnaipdqpYo4Z746bhGwL8g8l1nvN/E1ItD2DDFbjruz1eActiyDbJvoCr/\nN6HeJEQklk6yypYH6p3qp7nTK6nlnJDVBxlQfty67sNXmwf0bOICefVYSWKWzZjN\npmE9K1UJAgMBAAECggEAQFvnxjKiJWkVPbkfJjHU91GtnxwB3sqfrYdmN0ANUE4K\nMwydYikinj2q87iEi6wZ6PYM60hHRG1oRHKPsZgphJ4s0D3YIagS+0Bpdbtv0cW9\nIBovoZR4WzUum1qgOqwZYmgZCM0pNjOPwr6XT6Ldbkw8BxvN/HmFcUZ/ECZ5XugW\ncKqKoy0HSlxwXT4PUAgLVfL4KvWy4A4yJJF24zgRKE4QYveOR4nUFvoRdxhuAyYW\nxsajItj6sc6Jyr9FJzdw5Ra9EFwcWFM4uDdjHoaQrjwKId9fkCA+9eUCERWKTxCR\nP8mU4p2cAJYO+ME9fZfs8H2uqGNj13XUzoT6JzM8UwKBgQDUFZWcfmlgCM2BjU9c\n8qhYjD2egT3qxWJLYSUTUZfdOGgB6lxTqnOhsy93xYmVInz6r9XEZsLVoQj/wcZk\np7y+MxjiWNcBcUmviwHee42fe6BQZHaYlAFtlAKNSiHumfq6AtXpZvkQZJWTSRyW\nlI4LBEL6fSuqpk88EH9FXJbChwKBgQC3+F/1Qi3EoeohhWD+jMO0r8IblBd7jYbp\n2zs17KQsCEyc1qyIaE+a8Ud8zUqsECKWBuSFsQ2qrR3jZW6DZOw8hmp1foYC+Jjr\nC/BHyWsyYxrCoxpvSJMXCY6ulyFHjIZboopRVi/jgfowteMW6WyxvOMqVAqZtxRW\nHyFbsa+/7wKBgQCGHRwd+SZjr01dZmHQcjaYwB5bNHlWE/nDlyvd2pQBNaE3zN8T\nnU8/6tLSl50YLNYBpN22NBFzDEFnkj8F+bh2QlOzFuDnrZ8eHfZRnaoCNyg6jj0c\n4UNB6v3uIPnyK3cM16wzy4Umo6SenfYxFsH4H3rHcg4B/OdQIVKKJzHC0wKBgQCj\nQxhlX0WeqtJMzUE2pVVIlHF+Z/4u93ozLwts34USTosu5JRYublrl5QJfWY3LFqF\nKbjDrEykmt1bYDijAn1jeSYg/xeOq2+JqB6klms7XBfzgyuCdrWSTDkDV7uA84SI\n7cYySHpXPJH7iG7vdlevpCE0/0ApCgBSLW49IYMGoQKBgAxVRqAhLdA0RO+nTAC/\nwhOL5RGy5M2oXKfqNkzEt2k5og7xXY7ZoYTye5Byb3+wLpEJXW+V8FlfXk/u5ZI7\noFuZne+lYcCPMNDXdku6wKdf9gSnOSHOGMu8TvHcud4uIDYmFH5qabJL5GDoQi7Q\n12XvK21e6GNOEaRRlTHz0qUB\n-----END PRIVATE KEY-----\n";
        this.iv = MainAPIKt.base64Decode("d0VpcGhUbiE=");
        this.key = MainAPIKt.base64Decode("MTIzZDZjZWRmNjI2ZHk1NDIzM2FhMXc2");
        this.firstAPI = MainAPIKt.base64Decode("aHR0cHM6Ly9zaG93Ym94c3NsLnNoZWd1Lm5ldC9hcGkvYXBpX2NsaWVudC8=");
        this.secondAPI = MainAPIKt.base64Decode("aHR0cHM6Ly9zaG93Ym94YXBpc3NsLnN0c29zby5jb20vYXBpL2FwaV9jbGllbnQv");
        this.thirdAPI = MainAPIKt.base64Decode("aHR0cHM6Ly93d3cuZmViYm94LmNvbQ==");
        this.watchSomuchAPI = "https://watchsomuch.tv";
        this.openSubAPI = "https://opensubtitles-v3.strem.io";
        this.appKey = MainAPIKt.base64Decode("bW92aWVib3g=");
        this.appId = MainAPIKt.base64Decode("Y29tLnRkby5zaG93Ym94");
        this.appIdSecond = MainAPIKt.base64Decode("Y29tLnRkby5zaG93Ym94");
        this.appVersion = "11.7";
        this.appVersionCode = "131";
    }

    public /* synthetic */ ShowBox(SharedPreferences sharedPreferences, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : sharedPreferences);
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    public void setName(@NotNull String str) {
        this.name = str;
    }

    public boolean getHasMainPage() {
        return this.hasMainPage;
    }

    public boolean getHasChromecastSupport() {
        return this.hasChromecastSupport;
    }

    public boolean getInstantLinkLoading() {
        return this.instantLinkLoading;
    }

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    /* JADX INFO: compiled from: ShowBox.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\n\u001a\u00020\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\r"}, d2 = {"Lcom/phisher98/ShowBox$ResponseTypes;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Series", "Movies", "toTvType", "Lcom/lagradost/cloudstream3/TvType;", "Companion", "ShowBox"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public enum ResponseTypes {
        Series(2),
        Movies(1);

        private final int value;
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        public static EnumEntries<ResponseTypes> getEntries() {
            return $ENTRIES;
        }

        ResponseTypes(int value) {
            this.value = value;
        }

        public final int getValue() {
            return this.value;
        }

        @NotNull
        public final TvType toTvType() {
            return this == Series ? TvType.TvSeries : TvType.Movie;
        }

        /* JADX INFO: compiled from: ShowBox.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/phisher98/ShowBox$ResponseTypes$Companion;", "", "<init>", "()V", "getResponseType", "Lcom/phisher98/ShowBox$ResponseTypes;", "value", "", "(Ljava/lang/Integer;)Lcom/phisher98/ShowBox$ResponseTypes;", "ShowBox"}, k = 1, mv = {2, 4, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nShowBox.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ShowBox.kt\ncom/phisher98/ShowBox$ResponseTypes$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,946:1\n296#2,2:947\n*S KotlinDebug\n*F\n+ 1 ShowBox.kt\ncom/phisher98/ShowBox$ResponseTypes$Companion\n*L\n94#1:947,2\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @NotNull
            public final ResponseTypes getResponseType(@Nullable Integer value) {
                Object element$iv;
                ResponseTypes it;
                Iterable $this$firstOrNull$iv = ResponseTypes.getEntries();
                Iterator it2 = $this$firstOrNull$iv.iterator();
                do {
                    if (!it2.hasNext()) {
                        element$iv = null;
                        break;
                    }
                    element$iv = it2.next();
                    it = (ResponseTypes) element$iv;
                } while (!(value != null && it.getValue() == value.intValue()));
                ResponseTypes responseTypes = (ResponseTypes) element$iv;
                return responseTypes == null ? ResponseTypes.Movies : responseTypes;
            }
        }
    }

    @Nullable
    public final String getUitoken() {
        return this.uitoken;
    }

    /* JADX INFO: compiled from: ShowBox.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/phisher98/ShowBox$UserAgentInterceptor;", "Lokhttp3/Interceptor;", "<init>", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "ShowBox"}, k = 1, mv = {2, 4, 0}, xi = 48)
    private static final class UserAgentInterceptor implements Interceptor {
        @NotNull
        public Response intercept(@NotNull Interceptor.Chain chain) {
            return chain.proceed(chain.request().newBuilder().removeHeader("user-agent").addHeader("user-agent", "okhttp/3.12.6").build());
        }
    }

    private final String randomToken() {
        return CollectionsKt.joinToString$default(new IntRange(0, 31), "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.phisher98.ShowBox$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                ((Integer) obj).intValue();
                return String.valueOf(((Character) CollectionsKt.random(CollectionsKt.plus(new CharRange('0', '9'), new CharRange('a', 'f')), Random.Default)).charValue());
            }
        }, 30, (Object) null);
    }

    /* JADX INFO: compiled from: ShowBox.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0005J\"\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/phisher98/ShowBox$CipherUtils;", "", "<init>", "()V", "ALGORITHM", "", "TRANSFORMATION", "encrypt", "str", "key", "iv", "md5", "getVerify", "str2", "str3", "ShowBox"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nShowBox.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ShowBox.kt\ncom/phisher98/ShowBox$CipherUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,946:1\n1#2:947\n*E\n"})
    private static final class CipherUtils {

        @NotNull
        private static final String ALGORITHM = "DESede";

        @NotNull
        public static final CipherUtils INSTANCE = new CipherUtils();

        @NotNull
        private static final String TRANSFORMATION = "DESede/CBC/PKCS5Padding";

        private CipherUtils() {
        }

        @Nullable
        public final String encrypt(@NotNull String str, @NotNull String key, @NotNull String iv) {
            try {
                Cipher cipher = Cipher.getInstance(TRANSFORMATION);
                byte[] bArr = new byte[24];
                byte[] bytes = key.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                int length = bytes.length <= 24 ? bytes.length : 24;
                System.arraycopy(bytes, 0, bArr, 0, length);
                while (length < 24) {
                    bArr[length] = 0;
                    length++;
                }
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, ALGORITHM);
                byte[] bytes2 = iv.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
                cipher.init(1, secretKeySpec, new IvParameterSpec(bytes2));
                byte[] bytes3 = str.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes3, "getBytes(...)");
                return new String(Base64.encode(cipher.doFinal(bytes3), 2), StandardCharsets.UTF_8);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Nullable
        public final String md5(@NotNull String str) {
            byte[] it = MD5Util.INSTANCE.md5(str);
            if (it == null) {
                return null;
            }
            String lowerCase = HexDump.toHexString$default(HexDump.INSTANCE, it, 0, 0, 6, null).toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            return lowerCase;
        }

        @Nullable
        public final String getVerify(@Nullable String str, @NotNull String str2, @NotNull String str3) {
            if (str != null) {
                return md5(md5(str2) + str3 + str);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: ShowBox.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0007b\u0002\b\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/phisher98/ShowBox$HexDump;", "", "<init>", "()V", "HEX_DIGITS", "", "toHexString", "", "bArr", "", "i", "", "i2", "Lkotlin/jvm/JvmOverloads;", "ShowBox"}, k = 1, mv = {2, 4, 0}, xi = 48)
    private static final class HexDump {

        @NotNull
        public static final HexDump INSTANCE = new HexDump();

        @NotNull
        private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        @JvmOverloads
        @NotNull
        public final String toHexString(@NotNull byte[] bArr) {
            return toHexString$default(this, bArr, 0, 0, 6, null);
        }

        @JvmOverloads
        @NotNull
        public final String toHexString(@NotNull byte[] bArr, int i) {
            return toHexString$default(this, bArr, i, 0, 4, null);
        }

        private HexDump() {
        }

        public static /* synthetic */ String toHexString$default(HexDump hexDump, byte[] bArr, int i, int i2, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = bArr.length;
            }
            return hexDump.toHexString(bArr, i, i2);
        }

        @JvmOverloads
        @NotNull
        public final String toHexString(@NotNull byte[] bArr, int i, int i2) {
            char[] cArr = new char[i2 * 2];
            int i3 = 0;
            int i4 = i + i2;
            for (int i5 = i; i5 < i4; i5++) {
                int b = bArr[i5];
                int i6 = i3 + 1;
                char[] cArr2 = HEX_DIGITS;
                cArr[i3] = cArr2[(b >>> 4) & 15];
                i3 = i6 + 1;
                cArr[i6] = cArr2[b & 15];
            }
            return new String(cArr);
        }
    }

    /* JADX INFO: compiled from: ShowBox.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0005¨\u0006\t"}, d2 = {"Lcom/phisher98/ShowBox$MD5Util;", "", "<init>", "()V", "md5", "", "str", "", "bArr", "ShowBox"}, k = 1, mv = {2, 4, 0}, xi = 48)
    private static final class MD5Util {

        @NotNull
        public static final MD5Util INSTANCE = new MD5Util();

        private MD5Util() {
        }

        @Nullable
        public final byte[] md5(@NotNull String str) {
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            return md5(bytes);
        }

        @Nullable
        public final byte[] md5(@Nullable byte[] bArr) {
            try {
                MessageDigest digest = MessageDigest.getInstance("MD5");
                if (bArr == null) {
                    return null;
                }
                digest.update(bArr);
                return digest.digest();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    @NotNull
    public final X509Certificate loadCertificateFromPem(@NotNull String pem) throws CertificateException {
        String cleanPem = new Regex("\\s+").replace(StringsKt.replace$default(StringsKt.replace$default(pem, "-----BEGIN CERTIFICATE-----", "", false, 4, (Object) null), "-----END CERTIFICATE-----", "", false, 4, (Object) null), "");
        byte[] decoded = MainAPIKt.base64DecodeArray(cleanPem);
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        Certificate certificateGenerateCertificate = cf.generateCertificate(new ByteArrayInputStream(decoded));
        Intrinsics.checkNotNull(certificateGenerateCertificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
        return (X509Certificate) certificateGenerateCertificate;
    }

    @NotNull
    public final PrivateKey loadPrivateKeyFromPem(@NotNull String pem) {
        String cleanPem = new Regex("\\s+").replace(StringsKt.replace$default(StringsKt.replace$default(pem, "-----BEGIN PRIVATE KEY-----", "", false, 4, (Object) null), "-----END PRIVATE KEY-----", "", false, 4, (Object) null), "");
        byte[] decoded = MainAPIKt.base64DecodeArray(cleanPem);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(decoded);
        return KeyFactory.getInstance("RSA").generatePrivate(keySpec);
    }

    @NotNull
    public final OkHttpClient buildClientWithCert() throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, CertificateException, KeyStoreException, KeyManagementException {
        X509Certificate cert = loadCertificateFromPem(this.CLIENT_CERT_PEM);
        PrivateKey key = loadPrivateKeyFromPem(this.CLIENT_KEY_PEM);
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(null, null);
        char[] charArray = "".toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
        keyStore.setKeyEntry("client", key, charArray, new X509Certificate[]{cert});
        KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        char[] charArray2 = "".toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray2, "toCharArray(...)");
        kmf.init(keyStore, charArray2);
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init((KeyStore) null);
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), new SecureRandom());
        TrustManager trustManager = tmf.getTrustManagers()[0];
        Intrinsics.checkNotNull(trustManager, "null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
        X509TrustManager trustManager2 = (X509TrustManager) trustManager;
        return new OkHttpClient.Builder().sslSocketFactory(sslContext.getSocketFactory(), trustManager2).build();
    }

    @NotNull
    public final String queryApi(@NotNull String query, boolean useAlternativeApi) {
        String encryptedQuery = CipherUtils.INSTANCE.encrypt(query, this.key, this.iv);
        Intrinsics.checkNotNull(encryptedQuery);
        String appKeyHash = CipherUtils.INSTANCE.md5(this.appKey);
        Intrinsics.checkNotNull(appKeyHash);
        String newBody = "{\"app_key\":\"" + appKeyHash + "\",\"verify\":\"" + CipherUtils.INSTANCE.getVerify(encryptedQuery, this.appKey, this.key) + "\",\"encrypt_data\":\"" + encryptedQuery + "\"}";
        byte[] bytes = newBody.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        String base64Body = MainAPIKt.base64Encode(bytes);
        Map data = MapsKt.mapOf(new Pair[]{TuplesKt.to("data", base64Body), TuplesKt.to("appid", "27"), TuplesKt.to("platform", "android"), TuplesKt.to("version", this.appVersionCode), TuplesKt.to("medium", "Website"), TuplesKt.to("token", this.token)});
        String url = useAlternativeApi ? this.secondAPI : this.firstAPI;
        OkHttpClient client = buildClientWithCert().newBuilder().addInterceptor(new UserAgentInterceptor()).connectTimeout(10L, TimeUnit.SECONDS).readTimeout(10L, TimeUnit.SECONDS).writeTimeout(10L, TimeUnit.SECONDS).build();
        FormBody.Builder $this$queryApi_u24lambda_u240 = new FormBody.Builder((Charset) null, 1, (DefaultConstructorMarker) null);
        for (Map.Entry element$iv : data.entrySet()) {
            String k = (String) element$iv.getKey();
            FormBody.Builder builder = $this$queryApi_u24lambda_u240;
            String v = (String) element$iv.getValue();
            $this$queryApi_u24lambda_u240.add(k, v);
            $this$queryApi_u24lambda_u240 = builder;
        }
        Request request = new Request.Builder().url(url).headers(Headers.Companion.of(this.headers)).post($this$queryApi_u24lambda_u240.build()).build();
        Response response = (Closeable) client.newCall(request).execute();
        try {
            Response resp = response;
            String strString = resp.body().string();
            CloseableKt.closeFinally(response, (Throwable) null);
            return strString;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(response, th);
                throw th2;
            }
        }
    }

    public final /* synthetic */ <T> T queryApiParsed(String query) {
        Gson gson = new Gson();
        String strQueryApi = queryApi(query, false);
        if (StringsKt.isBlank(strQueryApi) || StringsKt.startsWith$default(StringsKt.trim(strQueryApi).toString(), "<", false, 2, (Object) null)) {
            String strQueryApi2 = queryApi(query, true);
            Intrinsics.reifiedOperationMarker(4, "T");
            return (T) gson.fromJson(strQueryApi2, Object.class);
        }
        try {
            Intrinsics.reifiedOperationMarker(4, "T");
            return (T) gson.fromJson(strQueryApi, Object.class);
        } catch (Exception e) {
            String strQueryApi3 = queryApi(query, true);
            Intrinsics.reifiedOperationMarker(4, "T");
            return (T) gson.fromJson(strQueryApi3, Object.class);
        }
    }

    public final long getExpiryDate() {
        return APIHolder.INSTANCE.getUnixTime() + 43200;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: ShowBox.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0092\u0001\u00103\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00104J\u0014\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00108\u001a\u00020\u0003HÖ\u0081\u0004J\n\u00109\u001a\u00020\u0005HÖ\u0081\u0004R)\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0002¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R'\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u0092\u0002\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R'\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u0092\u0002\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R'\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u0092\u0002\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R'\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u0092\u0002\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R)\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001e¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001d\u0010\u0012R'\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u0092\u0002\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b( ¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R'\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u0092\u0002\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\"¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R'\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u0092\u0002\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b($¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R'\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u0092\u0002\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(&¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R)\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b('¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u000e\u0010\u0012¨\u0006:"}, d2 = {"Lcom/phisher98/ShowBox$PostJSON;", "", "id", "", "title", "", "bannerMini", "poster", "poster2", "boxType", "imdbRating", "seasonEpisode", "updateTitle", "qualityTag", "is3D", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "Lcom/google/gson/annotations/SerializedName;", "value", "getTitle", "()Ljava/lang/String;", "getBannerMini", "banner_mini", "getPoster", "getPoster2", "poster_2", "getBoxType", "box_type", "getImdbRating", "imdb_rating", "getSeasonEpisode", "season_episode", "getUpdateTitle", "update_title", "getQualityTag", "quality_tag", "3d", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/phisher98/ShowBox$PostJSON;", "equals", "", "other", "hashCode", "toString", "ShowBox"}, k = 1, mv = {2, 4, 0}, xi = 48)
    static final /* data */ class PostJSON {

        @SerializedName("banner_mini")
        @Nullable
        private final String bannerMini;

        @SerializedName("box_type")
        @Nullable
        private final Integer boxType;

        @SerializedName("id")
        @Nullable
        private final Integer id;

        @SerializedName("imdb_rating")
        @Nullable
        private final String imdbRating;

        @SerializedName("3d")
        @Nullable
        private final Integer is3D;

        @SerializedName("poster")
        @Nullable
        private final String poster;

        @SerializedName("poster_2")
        @Nullable
        private final String poster2;

        @SerializedName("quality_tag")
        @Nullable
        private final String qualityTag;

        @SerializedName("season_episode")
        @Nullable
        private final String seasonEpisode;

        @SerializedName("title")
        @Nullable
        private final String title;

        @SerializedName("update_title")
        @Nullable
        private final String updateTitle;

        public PostJSON() {
            this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
        }

        public static /* synthetic */ PostJSON copy$default(PostJSON postJSON, Integer num, String str, String str2, String str3, String str4, Integer num2, String str5, String str6, String str7, String str8, Integer num3, int i, Object obj) {
            if ((i & 1) != 0) {
                num = postJSON.id;
            }
            if ((i & 2) != 0) {
                str = postJSON.title;
            }
            if ((i & 4) != 0) {
                str2 = postJSON.bannerMini;
            }
            if ((i & 8) != 0) {
                str3 = postJSON.poster;
            }
            if ((i & 16) != 0) {
                str4 = postJSON.poster2;
            }
            if ((i & 32) != 0) {
                num2 = postJSON.boxType;
            }
            if ((i & 64) != 0) {
                str5 = postJSON.imdbRating;
            }
            if ((i & 128) != 0) {
                str6 = postJSON.seasonEpisode;
            }
            if ((i & 256) != 0) {
                str7 = postJSON.updateTitle;
            }
            if ((i & 512) != 0) {
                str8 = postJSON.qualityTag;
            }
            if ((i & 1024) != 0) {
                num3 = postJSON.is3D;
            }
            String str9 = str8;
            Integer num4 = num3;
            String str10 = str6;
            String str11 = str7;
            Integer num5 = num2;
            String str12 = str5;
            String str13 = str4;
            String str14 = str2;
            return postJSON.copy(num, str, str14, str3, str13, num5, str12, str10, str11, str9, num4);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component10, reason: from getter */
        public final String getQualityTag() {
            return this.qualityTag;
        }

        @Nullable
        /* JADX INFO: renamed from: component11, reason: from getter */
        public final Integer getIs3D() {
            return this.is3D;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getBannerMini() {
            return this.bannerMini;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getPoster() {
            return this.poster;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getPoster2() {
            return this.poster2;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Integer getBoxType() {
            return this.boxType;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getImdbRating() {
            return this.imdbRating;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getSeasonEpisode() {
            return this.seasonEpisode;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getUpdateTitle() {
            return this.updateTitle;
        }

        @NotNull
        public final PostJSON copy(@Nullable Integer id, @Nullable String title, @Nullable String bannerMini, @Nullable String poster, @Nullable String poster2, @Nullable Integer boxType, @Nullable String imdbRating, @Nullable String seasonEpisode, @Nullable String updateTitle, @Nullable String qualityTag, @Nullable Integer is3D) {
            return new PostJSON(id, title, bannerMini, poster, poster2, boxType, imdbRating, seasonEpisode, updateTitle, qualityTag, is3D);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PostJSON)) {
                return false;
            }
            PostJSON postJSON = (PostJSON) other;
            return Intrinsics.areEqual(this.id, postJSON.id) && Intrinsics.areEqual(this.title, postJSON.title) && Intrinsics.areEqual(this.bannerMini, postJSON.bannerMini) && Intrinsics.areEqual(this.poster, postJSON.poster) && Intrinsics.areEqual(this.poster2, postJSON.poster2) && Intrinsics.areEqual(this.boxType, postJSON.boxType) && Intrinsics.areEqual(this.imdbRating, postJSON.imdbRating) && Intrinsics.areEqual(this.seasonEpisode, postJSON.seasonEpisode) && Intrinsics.areEqual(this.updateTitle, postJSON.updateTitle) && Intrinsics.areEqual(this.qualityTag, postJSON.qualityTag) && Intrinsics.areEqual(this.is3D, postJSON.is3D);
        }

        public int hashCode() {
            return ((((((((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.bannerMini == null ? 0 : this.bannerMini.hashCode())) * 31) + (this.poster == null ? 0 : this.poster.hashCode())) * 31) + (this.poster2 == null ? 0 : this.poster2.hashCode())) * 31) + (this.boxType == null ? 0 : this.boxType.hashCode())) * 31) + (this.imdbRating == null ? 0 : this.imdbRating.hashCode())) * 31) + (this.seasonEpisode == null ? 0 : this.seasonEpisode.hashCode())) * 31) + (this.updateTitle == null ? 0 : this.updateTitle.hashCode())) * 31) + (this.qualityTag == null ? 0 : this.qualityTag.hashCode())) * 31) + (this.is3D != null ? this.is3D.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PostJSON(id=").append(this.id).append(", title=").append(this.title).append(", bannerMini=").append(this.bannerMini).append(", poster=").append(this.poster).append(", poster2=").append(this.poster2).append(", boxType=").append(this.boxType).append(", imdbRating=").append(this.imdbRating).append(", seasonEpisode=").append(this.seasonEpisode).append(", updateTitle=").append(this.updateTitle).append(", qualityTag=").append(this.qualityTag).append(", is3D=").append(this.is3D).append(')');
            return sb.toString();
        }

        public PostJSON(@Nullable Integer id, @Nullable String title, @Nullable String bannerMini, @Nullable String poster, @Nullable String poster2, @Nullable Integer boxType, @Nullable String imdbRating, @Nullable String seasonEpisode, @Nullable String updateTitle, @Nullable String qualityTag, @Nullable Integer is3D) {
            this.id = id;
            this.title = title;
            this.bannerMini = bannerMini;
            this.poster = poster;
            this.poster2 = poster2;
            this.boxType = boxType;
            this.imdbRating = imdbRating;
            this.seasonEpisode = seasonEpisode;
            this.updateTitle = updateTitle;
            this.qualityTag = qualityTag;
            this.is3D = is3D;
        }

        public /* synthetic */ PostJSON(Integer num, String str, String str2, String str3, String str4, Integer num2, String str5, String str6, String str7, String str8, Integer num3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : num2, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : str6, (i & 256) != 0 ? null : str7, (i & 512) != 0 ? null : str8, (i & 1024) != 0 ? null : num3);
        }

        @Nullable
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final String getBannerMini() {
            return this.bannerMini;
        }

        @Nullable
        public final String getPoster() {
            return this.poster;
        }

        @Nullable
        public final String getPoster2() {
            return this.poster2;
        }

        @Nullable
        public final Integer getBoxType() {
            return this.boxType;
        }

        @Nullable
        public final String getImdbRating() {
            return this.imdbRating;
        }

        @Nullable
        public final String getSeasonEpisode() {
            return this.seasonEpisode;
        }

        @Nullable
        public final String getUpdateTitle() {
            return this.updateTitle;
        }

        @Nullable
        public final String getQualityTag() {
            return this.qualityTag;
        }

        @Nullable
        public final Integer is3D() {
            return this.is3D;
        }
    }

    /* JADX INFO: compiled from: ShowBox.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0082\b\u0018\u00002\u00020\u0001Bu\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\u0018\b\u0002\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010)\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0019\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fHÆ\u0003J|\u0010,\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0018\b\u0002\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fHÆ\u0001¢\u0006\u0002\u0010-J\u0014\u0010.\u001a\u00020\n2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00100\u001a\u00020\u0003HÖ\u0081\u0004J\n\u00101\u001a\u00020\u0005HÖ\u0081\u0004R)\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0002¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R'\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u0092\u0002\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R'\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u0092\u0002\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R)\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001a¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0007\u0010\u0013R)\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001c¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u001b\u0010\u0013R)\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u0092\u0002\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\t¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR'\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u0092\u0002\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(!¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R5\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f8\u0006X\u0087\u0004\u0092\u0002\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u00062"}, d2 = {"Lcom/phisher98/ShowBox$ListJSON;", "", "code", "", "type", "", "name", "isMore", "boxType", "cache", "", "cacheKey", "list", "Ljava/util/ArrayList;", "Lcom/phisher98/ShowBox$PostJSON;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/ArrayList;)V", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "Lcom/google/gson/annotations/SerializedName;", "value", "getType", "()Ljava/lang/String;", "getName", "ismore", "getBoxType", "box_type", "getCache", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCacheKey", "cache_key", "getList", "()Ljava/util/ArrayList;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/ArrayList;)Lcom/phisher98/ShowBox$ListJSON;", "equals", "other", "hashCode", "toString", "ShowBox"}, k = 1, mv = {2, 4, 0}, xi = 48)
    private static final /* data */ class ListJSON {

        @SerializedName("box_type")
        @Nullable
        private final Integer boxType;

        @SerializedName("cache")
        @Nullable
        private final Boolean cache;

        @SerializedName("cache_key")
        @Nullable
        private final String cacheKey;

        @SerializedName("code")
        @Nullable
        private final Integer code;

        @SerializedName("ismore")
        @Nullable
        private final Integer isMore;

        @SerializedName("list")
        @NotNull
        private final ArrayList<PostJSON> list;

        @SerializedName("name")
        @Nullable
        private final String name;

        @SerializedName("type")
        @Nullable
        private final String type;

        public ListJSON() {
            this(null, null, null, null, null, null, null, null, 255, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ListJSON copy$default(ListJSON listJSON, Integer num, String str, String str2, Integer num2, Integer num3, Boolean bool, String str3, ArrayList arrayList, int i, Object obj) {
            if ((i & 1) != 0) {
                num = listJSON.code;
            }
            if ((i & 2) != 0) {
                str = listJSON.type;
            }
            if ((i & 4) != 0) {
                str2 = listJSON.name;
            }
            if ((i & 8) != 0) {
                num2 = listJSON.isMore;
            }
            if ((i & 16) != 0) {
                num3 = listJSON.boxType;
            }
            if ((i & 32) != 0) {
                bool = listJSON.cache;
            }
            if ((i & 64) != 0) {
                str3 = listJSON.cacheKey;
            }
            if ((i & 128) != 0) {
                arrayList = listJSON.list;
            }
            String str4 = str3;
            ArrayList arrayList2 = arrayList;
            Integer num4 = num3;
            Boolean bool2 = bool;
            return listJSON.copy(num, str, str2, num2, num4, bool2, str4, arrayList2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getCode() {
            return this.code;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Integer getIsMore() {
            return this.isMore;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Integer getBoxType() {
            return this.boxType;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Boolean getCache() {
            return this.cache;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getCacheKey() {
            return this.cacheKey;
        }

        @NotNull
        public final ArrayList<PostJSON> component8() {
            return this.list;
        }

        @NotNull
        public final ListJSON copy(@Nullable Integer code, @Nullable String type, @Nullable String name, @Nullable Integer isMore, @Nullable Integer boxType, @Nullable Boolean cache, @Nullable String cacheKey, @NotNull ArrayList<PostJSON> list) {
            return new ListJSON(code, type, name, isMore, boxType, cache, cacheKey, list);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ListJSON)) {
                return false;
            }
            ListJSON listJSON = (ListJSON) other;
            return Intrinsics.areEqual(this.code, listJSON.code) && Intrinsics.areEqual(this.type, listJSON.type) && Intrinsics.areEqual(this.name, listJSON.name) && Intrinsics.areEqual(this.isMore, listJSON.isMore) && Intrinsics.areEqual(this.boxType, listJSON.boxType) && Intrinsics.areEqual(this.cache, listJSON.cache) && Intrinsics.areEqual(this.cacheKey, listJSON.cacheKey) && Intrinsics.areEqual(this.list, listJSON.list);
        }

        public int hashCode() {
            return ((((((((((((((this.code == null ? 0 : this.code.hashCode()) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.isMore == null ? 0 : this.isMore.hashCode())) * 31) + (this.boxType == null ? 0 : this.boxType.hashCode())) * 31) + (this.cache == null ? 0 : this.cache.hashCode())) * 31) + (this.cacheKey != null ? this.cacheKey.hashCode() : 0)) * 31) + this.list.hashCode();
        }

        @NotNull
        public String toString() {
            return "ListJSON(code=" + this.code + ", type=" + this.type + ", name=" + this.name + ", isMore=" + this.isMore + ", boxType=" + this.boxType + ", cache=" + this.cache + ", cacheKey=" + this.cacheKey + ", list=" + this.list + ')';
        }

        public ListJSON(@Nullable Integer code, @Nullable String type, @Nullable String name, @Nullable Integer isMore, @Nullable Integer boxType, @Nullable Boolean cache, @Nullable String cacheKey, @NotNull ArrayList<PostJSON> arrayList) {
            this.code = code;
            this.type = type;
            this.name = name;
            this.isMore = isMore;
            this.boxType = boxType;
            this.cache = cache;
            this.cacheKey = cacheKey;
            this.list = arrayList;
        }

        public /* synthetic */ ListJSON(Integer num, String str, String str2, Integer num2, Integer num3, Boolean bool, String str3, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? null : num3, (i & 32) != 0 ? null : bool, (i & 64) != 0 ? null : str3, (i & 128) != 0 ? new ArrayList() : arrayList);
        }

        @Nullable
        public final Integer getCode() {
            return this.code;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }

        @Nullable
        public final String getName() {
            return this.name;
        }

        @Nullable
        public final Integer isMore() {
            return this.isMore;
        }

        @Nullable
        public final Integer getBoxType() {
            return this.boxType;
        }

        @Nullable
        public final Boolean getCache() {
            return this.cache;
        }

        @Nullable
        public final String getCacheKey() {
            return this.cacheKey;
        }

        @NotNull
        public final ArrayList<PostJSON> getList() {
            return this.list;
        }
    }

    /* JADX INFO: compiled from: ShowBox.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B9\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0019\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tHÆ\u0003J@\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0014\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001d\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0005HÖ\u0081\u0004R)\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0002¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR'\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u0092\u0002\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R5\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t8\u0006X\u0087\u0004\u0092\u0002\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/phisher98/ShowBox$DataJSON;", "", "code", "", "msg", "", "data", "Ljava/util/ArrayList;", "Lcom/phisher98/ShowBox$ListJSON;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/ArrayList;)V", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "Lcom/google/gson/annotations/SerializedName;", "value", "getMsg", "()Ljava/lang/String;", "getData", "()Ljava/util/ArrayList;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/ArrayList;)Lcom/phisher98/ShowBox$DataJSON;", "equals", "", "other", "hashCode", "toString", "ShowBox"}, k = 1, mv = {2, 4, 0}, xi = 48)
    private static final /* data */ class DataJSON {

        @SerializedName("code")
        @Nullable
        private final Integer code;

        @SerializedName("data")
        @NotNull
        private final ArrayList<ListJSON> data;

        @SerializedName("msg")
        @Nullable
        private final String msg;

        public DataJSON() {
            this(null, null, null, 7, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DataJSON copy$default(DataJSON dataJSON, Integer num, String str, ArrayList arrayList, int i, Object obj) {
            if ((i & 1) != 0) {
                num = dataJSON.code;
            }
            if ((i & 2) != 0) {
                str = dataJSON.msg;
            }
            if ((i & 4) != 0) {
                arrayList = dataJSON.data;
            }
            return dataJSON.copy(num, str, arrayList);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getCode() {
            return this.code;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getMsg() {
            return this.msg;
        }

        @NotNull
        public final ArrayList<ListJSON> component3() {
            return this.data;
        }

        @NotNull
        public final DataJSON copy(@Nullable Integer code, @Nullable String msg, @NotNull ArrayList<ListJSON> data) {
            return new DataJSON(code, msg, data);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DataJSON)) {
                return false;
            }
            DataJSON dataJSON = (DataJSON) other;
            return Intrinsics.areEqual(this.code, dataJSON.code) && Intrinsics.areEqual(this.msg, dataJSON.msg) && Intrinsics.areEqual(this.data, dataJSON.data);
        }

        public int hashCode() {
            return ((((this.code == null ? 0 : this.code.hashCode()) * 31) + (this.msg != null ? this.msg.hashCode() : 0)) * 31) + this.data.hashCode();
        }

        @NotNull
        public String toString() {
            return "DataJSON(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ')';
        }

        public DataJSON(@Nullable Integer code, @Nullable String msg, @NotNull ArrayList<ListJSON> arrayList) {
            this.code = code;
            this.msg = msg;
            this.data = arrayList;
        }

        public /* synthetic */ DataJSON(Integer num, String str, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? new ArrayList() : arrayList);
        }

        @Nullable
        public final Integer getCode() {
            return this.code;
        }

        @Nullable
        public final String getMsg() {
            return this.msg;
        }

        @NotNull
        public final ArrayList<ListJSON> getData() {
            return this.data;
        }
    }

    @NotNull
    public final String getSecondAPI() {
        return this.secondAPI;
    }

    @NotNull
    public final String getThirdAPI() {
        return this.thirdAPI;
    }

    @NotNull
    public final String getWatchSomuchAPI() {
        return this.watchSomuchAPI;
    }

    @NotNull
    public final String getOpenSubAPI() {
        return this.openSubAPI;
    }

    @NotNull
    public final String getAppId() {
        return this.appId;
    }

    /* JADX WARN: Code duplicated, block: B:43:0x016f  */
    static /* synthetic */ Object getMainPage$suspendImpl(ShowBox showBox, int i, MainPageRequest mainPageRequest, Continuation<? super HomePageResponse> continuation) {
        Object objFromJson;
        boolean z;
        DataJSON dataJSON;
        boolean z2;
        HomePageList homePageList;
        final String str;
        MovieSearchResponse movieSearchResponseNewMovieSearchResponse;
        int i2 = 1;
        boolean z3 = !MainAPI.Companion.getSettingsForProvider().getEnableAdult();
        String strTrimIndent = StringsKt.trimIndent("{\"childmode\":\"" + (z3 ? 1 : 0) + "\",\"app_version\":\"" + showBox.appVersion + "\",\"appid\":\"" + showBox.appIdSecond + "\",\"module\":\"Home_list_type_v2\",\"channel\":\"Website\",\"page\":\"" + i + "\",\"lang\":\"en\",\"type\":\"all\",\"pagelimit\":\"20\",\"expired_date\":\"" + showBox.getExpiryDate() + "\",\"platform\":\"android\"}\n            ");
        Gson gson = new Gson();
        String strQueryApi = showBox.queryApi(strTrimIndent, false);
        if (StringsKt.isBlank(strQueryApi) || StringsKt.startsWith$default(StringsKt.trim(strQueryApi).toString(), "<", false, 2, (Object) null)) {
            objFromJson = gson.fromJson(showBox.queryApi(strTrimIndent, true), DataJSON.class);
        } else {
            try {
                objFromJson = gson.fromJson(strQueryApi, DataJSON.class);
            } catch (Exception e) {
                objFromJson = gson.fromJson(showBox.queryApi(strTrimIndent, true), DataJSON.class);
            }
        }
        DataJSON dataJSON2 = (DataJSON) objFromJson;
        ArrayList<ListJSON> data = dataJSON2.getData();
        List<ListJSON> listSubList = data.subList(Math.min(data.size(), 1), data.size());
        ArrayList arrayList = new ArrayList();
        for (ListJSON listJSON : listSubList) {
            String name = listJSON.getName();
            String str2 = name;
            if (str2 == null || str2.length() == 0) {
                name = "Featured";
            }
            String str3 = name;
            ArrayList<PostJSON> list = listJSON.getList();
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    dataJSON = dataJSON2;
                    z2 = z3;
                    ArrayList arrayList3 = arrayList2;
                    if (!arrayList3.isEmpty()) {
                        homePageList = new HomePageList(str3, arrayList3, false, 4, (DefaultConstructorMarker) null);
                        break;
                    }
                    homePageList = null;
                    break;
                }
                final PostJSON postJSON = (PostJSON) it.next();
                Integer boxType = postJSON.getBoxType();
                dataJSON = dataJSON2;
                TvType tvType = (boxType != null && boxType.intValue() == i2) ? TvType.Movie : TvType.TvSeries;
                String qualityTag = postJSON.getQualityTag();
                if (qualityTag == null) {
                    str = qualityTag;
                    str = "";
                } else {
                    if (StringsKt.contains(qualityTag, "blu-ray", true)) {
                        str = "Blueray";
                    }
                    if (str == null) {
                        str = qualityTag;
                        str = "";
                    }
                }
                str = qualityTag;
                ShowBox showBox2 = showBox;
                String title = postJSON.getTitle();
                if (title != null) {
                    AppUtils appUtils = AppUtils.INSTANCE;
                    Integer id = postJSON.getId();
                    if (id == null) {
                        z2 = z3;
                        homePageList = null;
                        break;
                    }
                    movieSearchResponseNewMovieSearchResponse = MainAPIKt.newMovieSearchResponse(showBox2, title, appUtils.toJson(new LoadData(id.intValue(), postJSON.getBoxType())), tvType, false, new Function1() { // from class: com.phisher98.ShowBox$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            return ShowBox.getMainPage$lambda$1$0$1(postJSON, str, (MovieSearchResponse) obj);
                        }
                    });
                } else {
                    movieSearchResponseNewMovieSearchResponse = null;
                }
                if (movieSearchResponseNewMovieSearchResponse != null) {
                    arrayList2.add(movieSearchResponseNewMovieSearchResponse);
                }
                z3 = z3;
                dataJSON2 = dataJSON;
                i2 = 1;
            }
            if (homePageList != null) {
                arrayList.add(homePageList);
            }
            z3 = z2;
            dataJSON2 = dataJSON;
            i2 = 1;
        }
        Object[] objArr = z3 ? 1 : 0;
        ArrayList arrayList4 = arrayList;
        ArrayList arrayList5 = arrayList4;
        if ((arrayList5 instanceof Collection) && arrayList5.isEmpty()) {
            z = false;
        } else {
            Iterator it2 = arrayList5.iterator();
            while (it2.hasNext()) {
                if (((HomePageList) it2.next()).getList().isEmpty()) {
                    z = true;
                }
            }
            z = false;
        }
        return MainAPIKt.newHomePageResponse(arrayList4, Boxing.boxBoolean(!z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMainPage$lambda$1$0$1(PostJSON $post, String $normalizedQuality, MovieSearchResponse $this$newMovieSearchResponse) {
        String poster = $post.getPoster();
        if (poster == null) {
            poster = $post.getPoster2();
        }
        $this$newMovieSearchResponse.setPosterUrl(poster);
        $this$newMovieSearchResponse.setQuality(MainAPIKt.getQualityFromString($normalizedQuality));
        $this$newMovieSearchResponse.setScore(Score.Companion.from10($post.getImdbRating()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: ShowBox.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B\u007f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&J\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010*\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010/\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0086\u0001\u00101\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u00102J\u0014\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00106\u001a\u00020\u0003HÖ\u0081\u0004J\n\u00107\u001a\u00020\u0007HÖ\u0081\u0004R)\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0002¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R)\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0015\u0010\u0011R)\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0017¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0016\u0010\u0011R'\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u0092\u0002\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R'\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u0092\u0002\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R'\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u0092\u0002\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R'\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u0092\u0002\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R)\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u000b¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001e\u0010\u0011R'\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u0092\u0002\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b( ¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R'\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u0092\u0002\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\"¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019¨\u00068"}, d2 = {"Lcom/phisher98/ShowBox$Data;", "", "id", "", "mid", "boxType", "title", "", "posterOrg", "poster", "cats", "year", "imdbRating", "qualityTag", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "Lcom/google/gson/annotations/SerializedName;", "value", "getMid", "getBoxType", "box_type", "getTitle", "()Ljava/lang/String;", "getPosterOrg", "poster_org", "getPoster", "getCats", "getYear", "getImdbRating", "imdb_rating", "getQualityTag", "quality_tag", "toSearchResponse", "Lcom/lagradost/cloudstream3/MovieSearchResponse;", "api", "Lcom/lagradost/cloudstream3/MainAPI;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/phisher98/ShowBox$Data;", "equals", "", "other", "hashCode", "toString", "ShowBox"}, k = 1, mv = {2, 4, 0}, xi = 48)
    static final /* data */ class Data {

        @SerializedName("box_type")
        @Nullable
        private final Integer boxType;

        @SerializedName("cats")
        @Nullable
        private final String cats;

        @SerializedName("id")
        @Nullable
        private final Integer id;

        @SerializedName("imdb_rating")
        @Nullable
        private final String imdbRating;

        @SerializedName("mid")
        @Nullable
        private final Integer mid;

        @SerializedName("poster")
        @Nullable
        private final String poster;

        @SerializedName("poster_org")
        @Nullable
        private final String posterOrg;

        @SerializedName("quality_tag")
        @Nullable
        private final String qualityTag;

        @SerializedName("title")
        @Nullable
        private final String title;

        @SerializedName("year")
        @Nullable
        private final Integer year;

        public Data() {
            this(null, null, null, null, null, null, null, null, null, null, 1023, null);
        }

        public static /* synthetic */ Data copy$default(Data data, Integer num, Integer num2, Integer num3, String str, String str2, String str3, String str4, Integer num4, String str5, String str6, int i, Object obj) {
            if ((i & 1) != 0) {
                num = data.id;
            }
            if ((i & 2) != 0) {
                num2 = data.mid;
            }
            if ((i & 4) != 0) {
                num3 = data.boxType;
            }
            if ((i & 8) != 0) {
                str = data.title;
            }
            if ((i & 16) != 0) {
                str2 = data.posterOrg;
            }
            if ((i & 32) != 0) {
                str3 = data.poster;
            }
            if ((i & 64) != 0) {
                str4 = data.cats;
            }
            if ((i & 128) != 0) {
                num4 = data.year;
            }
            if ((i & 256) != 0) {
                str5 = data.imdbRating;
            }
            if ((i & 512) != 0) {
                str6 = data.qualityTag;
            }
            String str7 = str5;
            String str8 = str6;
            String str9 = str4;
            Integer num5 = num4;
            String str10 = str2;
            String str11 = str3;
            return data.copy(num, num2, num3, str, str10, str11, str9, num5, str7, str8);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component10, reason: from getter */
        public final String getQualityTag() {
            return this.qualityTag;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getMid() {
            return this.mid;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getBoxType() {
            return this.boxType;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getPosterOrg() {
            return this.posterOrg;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getPoster() {
            return this.poster;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getCats() {
            return this.cats;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Integer getYear() {
            return this.year;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getImdbRating() {
            return this.imdbRating;
        }

        @NotNull
        public final Data copy(@Nullable Integer id, @Nullable Integer mid, @Nullable Integer boxType, @Nullable String title, @Nullable String posterOrg, @Nullable String poster, @Nullable String cats, @Nullable Integer year, @Nullable String imdbRating, @Nullable String qualityTag) {
            return new Data(id, mid, boxType, title, posterOrg, poster, cats, year, imdbRating, qualityTag);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Data)) {
                return false;
            }
            Data data = (Data) other;
            return Intrinsics.areEqual(this.id, data.id) && Intrinsics.areEqual(this.mid, data.mid) && Intrinsics.areEqual(this.boxType, data.boxType) && Intrinsics.areEqual(this.title, data.title) && Intrinsics.areEqual(this.posterOrg, data.posterOrg) && Intrinsics.areEqual(this.poster, data.poster) && Intrinsics.areEqual(this.cats, data.cats) && Intrinsics.areEqual(this.year, data.year) && Intrinsics.areEqual(this.imdbRating, data.imdbRating) && Intrinsics.areEqual(this.qualityTag, data.qualityTag);
        }

        public int hashCode() {
            return ((((((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.mid == null ? 0 : this.mid.hashCode())) * 31) + (this.boxType == null ? 0 : this.boxType.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.posterOrg == null ? 0 : this.posterOrg.hashCode())) * 31) + (this.poster == null ? 0 : this.poster.hashCode())) * 31) + (this.cats == null ? 0 : this.cats.hashCode())) * 31) + (this.year == null ? 0 : this.year.hashCode())) * 31) + (this.imdbRating == null ? 0 : this.imdbRating.hashCode())) * 31) + (this.qualityTag != null ? this.qualityTag.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Data(id=" + this.id + ", mid=" + this.mid + ", boxType=" + this.boxType + ", title=" + this.title + ", posterOrg=" + this.posterOrg + ", poster=" + this.poster + ", cats=" + this.cats + ", year=" + this.year + ", imdbRating=" + this.imdbRating + ", qualityTag=" + this.qualityTag + ')';
        }

        public Data(@Nullable Integer id, @Nullable Integer mid, @Nullable Integer boxType, @Nullable String title, @Nullable String posterOrg, @Nullable String poster, @Nullable String cats, @Nullable Integer year, @Nullable String imdbRating, @Nullable String qualityTag) {
            this.id = id;
            this.mid = mid;
            this.boxType = boxType;
            this.title = title;
            this.posterOrg = posterOrg;
            this.poster = poster;
            this.cats = cats;
            this.year = year;
            this.imdbRating = imdbRating;
            this.qualityTag = qualityTag;
        }

        public /* synthetic */ Data(Integer num, Integer num2, Integer num3, String str, String str2, String str3, String str4, Integer num4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : str3, (i & 64) != 0 ? null : str4, (i & 128) != 0 ? null : num4, (i & 256) != 0 ? null : str5, (i & 512) != 0 ? null : str6);
        }

        @Nullable
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        public final Integer getMid() {
            return this.mid;
        }

        @Nullable
        public final Integer getBoxType() {
            return this.boxType;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final String getPosterOrg() {
            return this.posterOrg;
        }

        @Nullable
        public final String getPoster() {
            return this.poster;
        }

        @Nullable
        public final String getCats() {
            return this.cats;
        }

        @Nullable
        public final Integer getYear() {
            return this.year;
        }

        @Nullable
        public final String getImdbRating() {
            return this.imdbRating;
        }

        @Nullable
        public final String getQualityTag() {
            return this.qualityTag;
        }

        @Nullable
        public final MovieSearchResponse toSearchResponse(@NotNull MainAPI api) {
            Integer num = this.boxType;
            int actualBoxType = num != null ? num.intValue() : ResponseTypes.Movies.getValue();
            String str = this.title;
            if (str == null) {
                str = "";
            }
            String str2 = str;
            AppUtils appUtils = AppUtils.INSTANCE;
            Integer num2 = this.id;
            if (num2 == null && (num2 = this.mid) == null) {
                return null;
            }
            return MainAPIKt.newMovieSearchResponse(api, str2, appUtils.toJson(new LoadData(num2.intValue(), Integer.valueOf(actualBoxType))), ResponseTypes.INSTANCE.getResponseType(Integer.valueOf(actualBoxType)).toTvType(), false, new Function1() { // from class: com.phisher98.ShowBox$Data$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    return ShowBox.Data.toSearchResponse$lambda$0(this.f$0, (MovieSearchResponse) obj);
                }
            });
        }

        static final Unit toSearchResponse$lambda$0(Data this$0, MovieSearchResponse $this$newMovieSearchResponse) {
            String strReplace$default;
            String str = this$0.posterOrg;
            $this$newMovieSearchResponse.setPosterUrl(!(str == null || str.length() == 0) ? this$0.posterOrg : this$0.poster);
            int i = this$0.year;
            if (i == null) {
                i = 0;
            }
            $this$newMovieSearchResponse.setYear(i);
            String str2 = this$0.qualityTag;
            if (str2 == null || (strReplace$default = StringsKt.replace$default(str2, "-", "", false, 4, (Object) null)) == null) {
                strReplace$default = "";
            }
            $this$newMovieSearchResponse.setQuality(MainAPIKt.getQualityFromString(strReplace$default));
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: ShowBox.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0005HÖ\u0081\u0004R%\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR%\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u0092\u0002\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R+\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004\u0092\u0002\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/phisher98/ShowBox$MainData;", "", "code", "", "msg", "", "data", "", "Lcom/phisher98/ShowBox$Data;", "<init>", "(ILjava/lang/String;Ljava/util/List;)V", "getCode", "()I", "Lcom/google/gson/annotations/SerializedName;", "value", "getMsg", "()Ljava/lang/String;", "getData", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "ShowBox"}, k = 1, mv = {2, 4, 0}, xi = 48)
    private static final /* data */ class MainData {

        @SerializedName("code")
        private final int code;

        @SerializedName("data")
        @NotNull
        private final List<Data> data;

        @SerializedName("msg")
        @NotNull
        private final String msg;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MainData copy$default(MainData mainData, int i, String str, List list, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = mainData.code;
            }
            if ((i2 & 2) != 0) {
                str = mainData.msg;
            }
            if ((i2 & 4) != 0) {
                list = mainData.data;
            }
            return mainData.copy(i, str, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getCode() {
            return this.code;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getMsg() {
            return this.msg;
        }

        @NotNull
        public final List<Data> component3() {
            return this.data;
        }

        @NotNull
        public final MainData copy(int code, @NotNull String msg, @NotNull List<Data> data) {
            return new MainData(code, msg, data);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MainData)) {
                return false;
            }
            MainData mainData = (MainData) other;
            return this.code == mainData.code && Intrinsics.areEqual(this.msg, mainData.msg) && Intrinsics.areEqual(this.data, mainData.data);
        }

        public int hashCode() {
            return (((this.code * 31) + this.msg.hashCode()) * 31) + this.data.hashCode();
        }

        @NotNull
        public String toString() {
            return "MainData(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ')';
        }

        public MainData(int code, @NotNull String msg, @NotNull List<Data> list) {
            this.code = code;
            this.msg = msg;
            this.data = list;
        }

        public final int getCode() {
            return this.code;
        }

        @NotNull
        public final String getMsg() {
            return this.msg;
        }

        @NotNull
        public final List<Data> getData() {
            return this.data;
        }
    }

    static /* synthetic */ Object search$suspendImpl(ShowBox showBox, String str, Continuation<? super List<? extends SearchResponse>> continuation) {
        Object objFromJson;
        String str2 = "{\"childmode\":\"" + (!MainAPI.Companion.getSettingsForProvider().getEnableAdult() ? 1 : 0) + "\",\"app_version\":\"" + showBox.appVersion + "\",\"module\":\"Search3\",\"channel\":\"Website\",\"page\":\"1\",\"lang\":\"en\",\"type\":\"all\",\"keyword\":\"" + str + "\",\"pagelimit\":\"15\",\"expired_date\":\"" + showBox.getExpiryDate() + "\",\"platform\":\"android\",\"appid\":\"" + showBox.appId + "\"}";
        Gson gson = new Gson();
        String strQueryApi = showBox.queryApi(str2, false);
        if (StringsKt.isBlank(strQueryApi) || StringsKt.startsWith$default(StringsKt.trim(strQueryApi).toString(), "<", false, 2, (Object) null)) {
            objFromJson = gson.fromJson(showBox.queryApi(str2, true), MainData.class);
        } else {
            try {
                objFromJson = gson.fromJson(strQueryApi, MainData.class);
            } catch (Exception e) {
                objFromJson = gson.fromJson(showBox.queryApi(str2, true), MainData.class);
            }
        }
        List<Data> data = ((MainData) objFromJson).getData();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = data.iterator();
        while (it.hasNext()) {
            List<Data> list = data;
            MovieSearchResponse searchResponse = ((Data) it.next()).toSearchResponse(showBox);
            if (searchResponse != null) {
                arrayList.add(searchResponse);
            }
            data = list;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: ShowBox.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ$\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/phisher98/ShowBox$LoadData;", "", "id", "", "box_type", "<init>", "(ILjava/lang/Integer;)V", "getId", "()I", "getBox_type", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(ILjava/lang/Integer;)Lcom/phisher98/ShowBox$LoadData;", "equals", "", "other", "hashCode", "toString", "", "ShowBox"}, k = 1, mv = {2, 4, 0}, xi = 48)
    static final /* data */ class LoadData {

        @Nullable
        private final Integer box_type;
        private final int id;

        public static /* synthetic */ LoadData copy$default(LoadData loadData, int i, Integer num, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = loadData.id;
            }
            if ((i2 & 2) != 0) {
                num = loadData.box_type;
            }
            return loadData.copy(i, num);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getBox_type() {
            return this.box_type;
        }

        @NotNull
        public final LoadData copy(int id, @Nullable Integer box_type) {
            return new LoadData(id, box_type);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LoadData)) {
                return false;
            }
            LoadData loadData = (LoadData) other;
            return this.id == loadData.id && Intrinsics.areEqual(this.box_type, loadData.box_type);
        }

        public int hashCode() {
            return (this.id * 31) + (this.box_type == null ? 0 : this.box_type.hashCode());
        }

        @NotNull
        public String toString() {
            return "LoadData(id=" + this.id + ", box_type=" + this.box_type + ')';
        }

        public LoadData(int id, @Nullable Integer box_type) {
            this.id = id;
            this.box_type = box_type;
        }

        public final int getId() {
            return this.id;
        }

        @Nullable
        public final Integer getBox_type() {
            return this.box_type;
        }
    }

    /* JADX INFO: compiled from: ShowBox.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b<\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B\u0093\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u0010F\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u0010K\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u0010O\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010U\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u0010V\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010Y\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aHÆ\u0003J\u009a\u0002\u0010[\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aHÆ\u0001¢\u0006\u0002\u0010\\J\u0014\u0010]\u001a\u00020^2\b\u0010_\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010`\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010a\u001a\u00020\u0005HÖ\u0081\u0004R)\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0002¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR/\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u0092\u0002\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0004¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R'\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u0092\u0002\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0006¢\u0006\b\n\u0000\u001a\u0004\b'\u0010$R'\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u0092\u0002\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0007¢\u0006\b\n\u0000\u001a\u0004\b(\u0010$R'\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u0092\u0002\f\b!\u0012\b\b\"\u0012\u0004\b\b(\b¢\u0006\b\n\u0000\u001a\u0004\b)\u0010$R)\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b!\u0012\b\b\"\u0012\u0004\b\b(\t¢\u0006\n\n\u0002\u0010 \u001a\u0004\b*\u0010\u001fR'\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u0092\u0002\f\b!\u0012\b\b\"\u0012\u0004\b\b(\n¢\u0006\b\n\u0000\u001a\u0004\b+\u0010$R'\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u0092\u0002\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u000b¢\u0006\b\n\u0000\u001a\u0004\b,\u0010$R'\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u0092\u0002\f\b!\u0012\b\b\"\u0012\u0004\b\b(\f¢\u0006\b\n\u0000\u001a\u0004\b-\u0010$R)\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b!\u0012\b\b\"\u0012\u0004\b\b(\r¢\u0006\n\n\u0002\u0010 \u001a\u0004\b.\u0010\u001fR'\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u0092\u0002\f\b!\u0012\b\b\"\u0012\u0004\b\b(0¢\u0006\b\n\u0000\u001a\u0004\b/\u0010$R'\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u0092\u0002\f\b!\u0012\b\b\"\u0012\u0004\b\b(2¢\u0006\b\n\u0000\u001a\u0004\b1\u0010$R'\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u0092\u0002\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0010¢\u0006\b\n\u0000\u001a\u0004\b3\u0010$R'\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u0092\u0002\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0011¢\u0006\b\n\u0000\u001a\u0004\b4\u0010$R'\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u0092\u0002\f\b!\u0012\b\b\"\u0012\u0004\b\b(6¢\u0006\b\n\u0000\u001a\u0004\b5\u0010$R)\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b!\u0012\b\b\"\u0012\u0004\b\b(8¢\u0006\n\n\u0002\u0010 \u001a\u0004\b7\u0010\u001fR)\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b!\u0012\b\b\"\u0012\u0004\b\b(:¢\u0006\n\n\u0002\u0010 \u001a\u0004\b9\u0010\u001fR'\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u0092\u0002\f\b!\u0012\b\b\"\u0012\u0004\b\b(<¢\u0006\b\n\u0000\u001a\u0004\b;\u0010$R'\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u0092\u0002\f\b!\u0012\b\b\"\u0012\u0004\b\b(>¢\u0006\b\n\u0000\u001a\u0004\b=\u0010$R'\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u0092\u0002\f\b!\u0012\b\b\"\u0012\u0004\b\b(@¢\u0006\b\n\u0000\u001a\u0004\b?\u0010$R)\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b!\u0012\b\b\"\u0012\u0004\b\b(B¢\u0006\n\n\u0002\u0010 \u001a\u0004\bA\u0010\u001fR+\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0006X\u0087\u0004\u0092\u0002\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0019¢\u0006\b\n\u0000\u001a\u0004\bC\u0010D¨\u0006b"}, d2 = {"Lcom/phisher98/ShowBox$MovieData;", "", "id", "", "title", "", "director", "writer", "actors", "runtime", "poster", "description", "cats", "year", "imdbId", "imdbRating", "trailer", "released", "contentRating", "tmdbId", "tomatoMeter", "posterOrg", "trailerUrl", "imdbLink", "boxType", "recommend", "", "Lcom/phisher98/ShowBox$Data;", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "Lcom/google/gson/annotations/SerializedName;", "value", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getDirector", "getWriter", "getActors", "getRuntime", "getPoster", "getDescription", "getCats", "getYear", "getImdbId", "imdb_id", "getImdbRating", "imdb_rating", "getTrailer", "getReleased", "getContentRating", "content_rating", "getTmdbId", "tmdb_id", "getTomatoMeter", "tomato_meter", "getPosterOrg", "poster_org", "getTrailerUrl", "trailer_url", "getImdbLink", "imdb_link", "getBoxType", "box_type", "getRecommend", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;)Lcom/phisher98/ShowBox$MovieData;", "equals", "", "other", "hashCode", "toString", "ShowBox"}, k = 1, mv = {2, 4, 0}, xi = 48)
    private static final /* data */ class MovieData {

        @SerializedName("actors")
        @Nullable
        private final String actors;

        @SerializedName("box_type")
        @Nullable
        private final Integer boxType;

        @SerializedName("cats")
        @Nullable
        private final String cats;

        @SerializedName("content_rating")
        @Nullable
        private final String contentRating;

        @SerializedName("description")
        @Nullable
        private final String description;

        @SerializedName("director")
        @Nullable
        private final String director;

        @SerializedName("id")
        @Nullable
        private final Integer id;

        @SerializedName("imdb_id")
        @Nullable
        private final String imdbId;

        @SerializedName("imdb_link")
        @Nullable
        private final String imdbLink;

        @SerializedName("imdb_rating")
        @Nullable
        private final String imdbRating;

        @SerializedName("poster")
        @Nullable
        private final String poster;

        @SerializedName("poster_org")
        @Nullable
        private final String posterOrg;

        @SerializedName("recommend")
        @NotNull
        private final List<Data> recommend;

        @SerializedName("released")
        @Nullable
        private final String released;

        @SerializedName("runtime")
        @Nullable
        private final Integer runtime;

        @SerializedName("title")
        @Nullable
        private String title;

        @SerializedName("tmdb_id")
        @Nullable
        private final Integer tmdbId;

        @SerializedName("tomato_meter")
        @Nullable
        private final Integer tomatoMeter;

        @SerializedName("trailer")
        @Nullable
        private final String trailer;

        @SerializedName("trailer_url")
        @Nullable
        private final String trailerUrl;

        @SerializedName("writer")
        @Nullable
        private final String writer;

        @SerializedName("year")
        @Nullable
        private final Integer year;

        public MovieData() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 4194303, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MovieData copy$default(MovieData movieData, Integer num, String str, String str2, String str3, String str4, Integer num2, String str5, String str6, String str7, Integer num3, String str8, String str9, String str10, String str11, String str12, Integer num4, Integer num5, String str13, String str14, String str15, Integer num6, List list, int i, Object obj) {
            List list2;
            Integer num7;
            Integer num8 = (i & 1) != 0 ? movieData.id : num;
            String str16 = (i & 2) != 0 ? movieData.title : str;
            String str17 = (i & 4) != 0 ? movieData.director : str2;
            String str18 = (i & 8) != 0 ? movieData.writer : str3;
            String str19 = (i & 16) != 0 ? movieData.actors : str4;
            Integer num9 = (i & 32) != 0 ? movieData.runtime : num2;
            String str20 = (i & 64) != 0 ? movieData.poster : str5;
            String str21 = (i & 128) != 0 ? movieData.description : str6;
            String str22 = (i & 256) != 0 ? movieData.cats : str7;
            Integer num10 = (i & 512) != 0 ? movieData.year : num3;
            String str23 = (i & 1024) != 0 ? movieData.imdbId : str8;
            String str24 = (i & 2048) != 0 ? movieData.imdbRating : str9;
            String str25 = (i & 4096) != 0 ? movieData.trailer : str10;
            String str26 = (i & 8192) != 0 ? movieData.released : str11;
            Integer num11 = num8;
            String str27 = (i & 16384) != 0 ? movieData.contentRating : str12;
            Integer num12 = (i & 32768) != 0 ? movieData.tmdbId : num4;
            Integer num13 = (i & 65536) != 0 ? movieData.tomatoMeter : num5;
            String str28 = (i & 131072) != 0 ? movieData.posterOrg : str13;
            String str29 = (i & 262144) != 0 ? movieData.trailerUrl : str14;
            String str30 = (i & 524288) != 0 ? movieData.imdbLink : str15;
            Integer num14 = (i & 1048576) != 0 ? movieData.boxType : num6;
            if ((i & 2097152) != 0) {
                num7 = num14;
                list2 = movieData.recommend;
            } else {
                list2 = list;
                num7 = num14;
            }
            return movieData.copy(num11, str16, str17, str18, str19, num9, str20, str21, str22, num10, str23, str24, str25, str26, str27, num12, num13, str28, str29, str30, num7, list2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component10, reason: from getter */
        public final Integer getYear() {
            return this.year;
        }

        @Nullable
        /* JADX INFO: renamed from: component11, reason: from getter */
        public final String getImdbId() {
            return this.imdbId;
        }

        @Nullable
        /* JADX INFO: renamed from: component12, reason: from getter */
        public final String getImdbRating() {
            return this.imdbRating;
        }

        @Nullable
        /* JADX INFO: renamed from: component13, reason: from getter */
        public final String getTrailer() {
            return this.trailer;
        }

        @Nullable
        /* JADX INFO: renamed from: component14, reason: from getter */
        public final String getReleased() {
            return this.released;
        }

        @Nullable
        /* JADX INFO: renamed from: component15, reason: from getter */
        public final String getContentRating() {
            return this.contentRating;
        }

        @Nullable
        /* JADX INFO: renamed from: component16, reason: from getter */
        public final Integer getTmdbId() {
            return this.tmdbId;
        }

        @Nullable
        /* JADX INFO: renamed from: component17, reason: from getter */
        public final Integer getTomatoMeter() {
            return this.tomatoMeter;
        }

        @Nullable
        /* JADX INFO: renamed from: component18, reason: from getter */
        public final String getPosterOrg() {
            return this.posterOrg;
        }

        @Nullable
        /* JADX INFO: renamed from: component19, reason: from getter */
        public final String getTrailerUrl() {
            return this.trailerUrl;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component20, reason: from getter */
        public final String getImdbLink() {
            return this.imdbLink;
        }

        @Nullable
        /* JADX INFO: renamed from: component21, reason: from getter */
        public final Integer getBoxType() {
            return this.boxType;
        }

        @NotNull
        public final List<Data> component22() {
            return this.recommend;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getDirector() {
            return this.director;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getWriter() {
            return this.writer;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getActors() {
            return this.actors;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Integer getRuntime() {
            return this.runtime;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getPoster() {
            return this.poster;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getCats() {
            return this.cats;
        }

        @NotNull
        public final MovieData copy(@Nullable Integer id, @Nullable String title, @Nullable String director, @Nullable String writer, @Nullable String actors, @Nullable Integer runtime, @Nullable String poster, @Nullable String description, @Nullable String cats, @Nullable Integer year, @Nullable String imdbId, @Nullable String imdbRating, @Nullable String trailer, @Nullable String released, @Nullable String contentRating, @Nullable Integer tmdbId, @Nullable Integer tomatoMeter, @Nullable String posterOrg, @Nullable String trailerUrl, @Nullable String imdbLink, @Nullable Integer boxType, @NotNull List<Data> recommend) {
            return new MovieData(id, title, director, writer, actors, runtime, poster, description, cats, year, imdbId, imdbRating, trailer, released, contentRating, tmdbId, tomatoMeter, posterOrg, trailerUrl, imdbLink, boxType, recommend);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MovieData)) {
                return false;
            }
            MovieData movieData = (MovieData) other;
            return Intrinsics.areEqual(this.id, movieData.id) && Intrinsics.areEqual(this.title, movieData.title) && Intrinsics.areEqual(this.director, movieData.director) && Intrinsics.areEqual(this.writer, movieData.writer) && Intrinsics.areEqual(this.actors, movieData.actors) && Intrinsics.areEqual(this.runtime, movieData.runtime) && Intrinsics.areEqual(this.poster, movieData.poster) && Intrinsics.areEqual(this.description, movieData.description) && Intrinsics.areEqual(this.cats, movieData.cats) && Intrinsics.areEqual(this.year, movieData.year) && Intrinsics.areEqual(this.imdbId, movieData.imdbId) && Intrinsics.areEqual(this.imdbRating, movieData.imdbRating) && Intrinsics.areEqual(this.trailer, movieData.trailer) && Intrinsics.areEqual(this.released, movieData.released) && Intrinsics.areEqual(this.contentRating, movieData.contentRating) && Intrinsics.areEqual(this.tmdbId, movieData.tmdbId) && Intrinsics.areEqual(this.tomatoMeter, movieData.tomatoMeter) && Intrinsics.areEqual(this.posterOrg, movieData.posterOrg) && Intrinsics.areEqual(this.trailerUrl, movieData.trailerUrl) && Intrinsics.areEqual(this.imdbLink, movieData.imdbLink) && Intrinsics.areEqual(this.boxType, movieData.boxType) && Intrinsics.areEqual(this.recommend, movieData.recommend);
        }

        public int hashCode() {
            return ((((((((((((((((((((((((((((((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.director == null ? 0 : this.director.hashCode())) * 31) + (this.writer == null ? 0 : this.writer.hashCode())) * 31) + (this.actors == null ? 0 : this.actors.hashCode())) * 31) + (this.runtime == null ? 0 : this.runtime.hashCode())) * 31) + (this.poster == null ? 0 : this.poster.hashCode())) * 31) + (this.description == null ? 0 : this.description.hashCode())) * 31) + (this.cats == null ? 0 : this.cats.hashCode())) * 31) + (this.year == null ? 0 : this.year.hashCode())) * 31) + (this.imdbId == null ? 0 : this.imdbId.hashCode())) * 31) + (this.imdbRating == null ? 0 : this.imdbRating.hashCode())) * 31) + (this.trailer == null ? 0 : this.trailer.hashCode())) * 31) + (this.released == null ? 0 : this.released.hashCode())) * 31) + (this.contentRating == null ? 0 : this.contentRating.hashCode())) * 31) + (this.tmdbId == null ? 0 : this.tmdbId.hashCode())) * 31) + (this.tomatoMeter == null ? 0 : this.tomatoMeter.hashCode())) * 31) + (this.posterOrg == null ? 0 : this.posterOrg.hashCode())) * 31) + (this.trailerUrl == null ? 0 : this.trailerUrl.hashCode())) * 31) + (this.imdbLink == null ? 0 : this.imdbLink.hashCode())) * 31) + (this.boxType != null ? this.boxType.hashCode() : 0)) * 31) + this.recommend.hashCode();
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("MovieData(id=").append(this.id).append(", title=").append(this.title).append(", director=").append(this.director).append(", writer=").append(this.writer).append(", actors=").append(this.actors).append(", runtime=").append(this.runtime).append(", poster=").append(this.poster).append(", description=").append(this.description).append(", cats=").append(this.cats).append(", year=").append(this.year).append(", imdbId=").append(this.imdbId).append(", imdbRating=");
            sb.append(this.imdbRating).append(", trailer=").append(this.trailer).append(", released=").append(this.released).append(", contentRating=").append(this.contentRating).append(", tmdbId=").append(this.tmdbId).append(", tomatoMeter=").append(this.tomatoMeter).append(", posterOrg=").append(this.posterOrg).append(", trailerUrl=").append(this.trailerUrl).append(", imdbLink=").append(this.imdbLink).append(", boxType=").append(this.boxType).append(", recommend=").append(this.recommend).append(')');
            return sb.toString();
        }

        public MovieData(@Nullable Integer id, @Nullable String title, @Nullable String director, @Nullable String writer, @Nullable String actors, @Nullable Integer runtime, @Nullable String poster, @Nullable String description, @Nullable String cats, @Nullable Integer year, @Nullable String imdbId, @Nullable String imdbRating, @Nullable String trailer, @Nullable String released, @Nullable String contentRating, @Nullable Integer tmdbId, @Nullable Integer tomatoMeter, @Nullable String posterOrg, @Nullable String trailerUrl, @Nullable String imdbLink, @Nullable Integer boxType, @NotNull List<Data> list) {
            this.id = id;
            this.title = title;
            this.director = director;
            this.writer = writer;
            this.actors = actors;
            this.runtime = runtime;
            this.poster = poster;
            this.description = description;
            this.cats = cats;
            this.year = year;
            this.imdbId = imdbId;
            this.imdbRating = imdbRating;
            this.trailer = trailer;
            this.released = released;
            this.contentRating = contentRating;
            this.tmdbId = tmdbId;
            this.tomatoMeter = tomatoMeter;
            this.posterOrg = posterOrg;
            this.trailerUrl = trailerUrl;
            this.imdbLink = imdbLink;
            this.boxType = boxType;
            this.recommend = list;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ MovieData(Integer num, String str, String str2, String str3, String str4, Integer num2, String str5, String str6, String str7, Integer num3, String str8, String str9, String str10, String str11, String str12, Integer num4, Integer num5, String str13, String str14, String str15, Integer num6, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            Integer num7 = (i & 1) != 0 ? null : num;
            String str16 = (i & 2) != 0 ? null : str;
            String str17 = (i & 4) != 0 ? null : str2;
            String str18 = (i & 8) != 0 ? null : str3;
            String str19 = (i & 16) != 0 ? null : str4;
            Integer num8 = (i & 32) != 0 ? null : num2;
            String str20 = (i & 64) != 0 ? null : str5;
            String str21 = (i & 128) != 0 ? null : str6;
            String str22 = (i & 256) != 0 ? null : str7;
            Integer num9 = (i & 512) != 0 ? null : num3;
            String str23 = (i & 1024) != 0 ? null : str8;
            String str24 = (i & 2048) != 0 ? null : str9;
            String str25 = (i & 4096) != 0 ? null : str10;
            String str26 = (i & 8192) != 0 ? null : str11;
            String str27 = (i & 16384) != 0 ? null : str12;
            this(num7, str16, str17, str18, str19, num8, str20, str21, str22, num9, str23, str24, str25, str26, str27, (i & 32768) != 0 ? null : num4, (i & 65536) != 0 ? null : num5, (i & 131072) != 0 ? null : str13, (i & 262144) != 0 ? null : str14, (i & 524288) != 0 ? null : str15, (i & 1048576) != 0 ? null : num6, (i & 2097152) != 0 ? CollectionsKt.emptyList() : list);
        }

        @Nullable
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(@Nullable String str) {
            this.title = str;
        }

        @Nullable
        public final String getDirector() {
            return this.director;
        }

        @Nullable
        public final String getWriter() {
            return this.writer;
        }

        @Nullable
        public final String getActors() {
            return this.actors;
        }

        @Nullable
        public final Integer getRuntime() {
            return this.runtime;
        }

        @Nullable
        public final String getPoster() {
            return this.poster;
        }

        @Nullable
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        public final String getCats() {
            return this.cats;
        }

        @Nullable
        public final Integer getYear() {
            return this.year;
        }

        @Nullable
        public final String getImdbId() {
            return this.imdbId;
        }

        @Nullable
        public final String getImdbRating() {
            return this.imdbRating;
        }

        @Nullable
        public final String getTrailer() {
            return this.trailer;
        }

        @Nullable
        public final String getReleased() {
            return this.released;
        }

        @Nullable
        public final String getContentRating() {
            return this.contentRating;
        }

        @Nullable
        public final Integer getTmdbId() {
            return this.tmdbId;
        }

        @Nullable
        public final Integer getTomatoMeter() {
            return this.tomatoMeter;
        }

        @Nullable
        public final String getPosterOrg() {
            return this.posterOrg;
        }

        @Nullable
        public final String getTrailerUrl() {
            return this.trailerUrl;
        }

        @Nullable
        public final String getImdbLink() {
            return this.imdbLink;
        }

        @Nullable
        public final Integer getBoxType() {
            return this.boxType;
        }

        @NotNull
        public final List<Data> getRecommend() {
            return this.recommend;
        }
    }

    /* JADX INFO: compiled from: ShowBox.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004R'\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/phisher98/ShowBox$MovieDataProp;", "", "data", "Lcom/phisher98/ShowBox$MovieData;", "<init>", "(Lcom/phisher98/ShowBox$MovieData;)V", "getData", "()Lcom/phisher98/ShowBox$MovieData;", "Lcom/google/gson/annotations/SerializedName;", "value", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ShowBox"}, k = 1, mv = {2, 4, 0}, xi = 48)
    private static final /* data */ class MovieDataProp {

        @SerializedName("data")
        @Nullable
        private final MovieData data;

        /* JADX WARN: Illegal instructions before constructor call */
        public MovieDataProp() {
            MovieData movieData = null;
            this(movieData, 1, movieData);
        }

        public static /* synthetic */ MovieDataProp copy$default(MovieDataProp movieDataProp, MovieData movieData, int i, Object obj) {
            if ((i & 1) != 0) {
                movieData = movieDataProp.data;
            }
            return movieDataProp.copy(movieData);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final MovieData getData() {
            return this.data;
        }

        @NotNull
        public final MovieDataProp copy(@Nullable MovieData data) {
            return new MovieDataProp(data);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof MovieDataProp) && Intrinsics.areEqual(this.data, ((MovieDataProp) other).data);
        }

        public int hashCode() {
            if (this.data == null) {
                return 0;
            }
            return this.data.hashCode();
        }

        @NotNull
        public String toString() {
            return "MovieDataProp(data=" + this.data + ')';
        }

        public MovieDataProp(@Nullable MovieData data) {
            this.data = data;
        }

        public /* synthetic */ MovieDataProp(MovieData movieData, int i, DefaultConstructorMarker defaultConstructorMarker) {
            MovieData movieData2;
            if ((i & 1) == 0) {
                movieData2 = movieData;
            } else {
                movieData2 = new MovieData(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 4194303, null);
            }
            this(movieData2);
        }

        @Nullable
        public final MovieData getData() {
            return this.data;
        }
    }

    /* JADX INFO: compiled from: ShowBox.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0014\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u0005HÖ\u0081\u0004R)\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0002¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR'\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u0092\u0002\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R'\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u0092\u0002\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/phisher98/ShowBox$SeriesDataProp;", "", "code", "", "msg", "", "data", "Lcom/phisher98/ShowBox$SeriesData;", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/phisher98/ShowBox$SeriesData;)V", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "Lcom/google/gson/annotations/SerializedName;", "value", "getMsg", "()Ljava/lang/String;", "getData", "()Lcom/phisher98/ShowBox$SeriesData;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/phisher98/ShowBox$SeriesData;)Lcom/phisher98/ShowBox$SeriesDataProp;", "equals", "", "other", "hashCode", "toString", "ShowBox"}, k = 1, mv = {2, 4, 0}, xi = 48)
    private static final /* data */ class SeriesDataProp {

        @SerializedName("code")
        @Nullable
        private final Integer code;

        @SerializedName("data")
        @Nullable
        private final SeriesData data;

        @SerializedName("msg")
        @Nullable
        private final String msg;

        public SeriesDataProp() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ SeriesDataProp copy$default(SeriesDataProp seriesDataProp, Integer num, String str, SeriesData seriesData, int i, Object obj) {
            if ((i & 1) != 0) {
                num = seriesDataProp.code;
            }
            if ((i & 2) != 0) {
                str = seriesDataProp.msg;
            }
            if ((i & 4) != 0) {
                seriesData = seriesDataProp.data;
            }
            return seriesDataProp.copy(num, str, seriesData);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getCode() {
            return this.code;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getMsg() {
            return this.msg;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final SeriesData getData() {
            return this.data;
        }

        @NotNull
        public final SeriesDataProp copy(@Nullable Integer code, @Nullable String msg, @Nullable SeriesData data) {
            return new SeriesDataProp(code, msg, data);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SeriesDataProp)) {
                return false;
            }
            SeriesDataProp seriesDataProp = (SeriesDataProp) other;
            return Intrinsics.areEqual(this.code, seriesDataProp.code) && Intrinsics.areEqual(this.msg, seriesDataProp.msg) && Intrinsics.areEqual(this.data, seriesDataProp.data);
        }

        public int hashCode() {
            return ((((this.code == null ? 0 : this.code.hashCode()) * 31) + (this.msg == null ? 0 : this.msg.hashCode())) * 31) + (this.data != null ? this.data.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "SeriesDataProp(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ')';
        }

        public SeriesDataProp(@Nullable Integer code, @Nullable String msg, @Nullable SeriesData data) {
            this.code = code;
            this.msg = msg;
            this.data = data;
        }

        public /* synthetic */ SeriesDataProp(Integer num, String str, SeriesData seriesData, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : seriesData);
        }

        @Nullable
        public final Integer getCode() {
            return this.code;
        }

        @Nullable
        public final String getMsg() {
            return this.msg;
        }

        @Nullable
        public final SeriesData getData() {
            return this.data;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: ShowBox.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J6\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001d\u001a\u00020\u0005HÖ\u0081\u0004R)\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR'\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u0092\u0002\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R+\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004\u0092\u0002\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/phisher98/ShowBox$SeriesSeasonProp;", "", "code", "", "msg", "", "data", "", "Lcom/phisher98/ShowBox$SeriesEpisode;", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;)V", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "Lcom/google/gson/annotations/SerializedName;", "value", "getMsg", "()Ljava/lang/String;", "getData", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;)Lcom/phisher98/ShowBox$SeriesSeasonProp;", "equals", "", "other", "hashCode", "toString", "ShowBox"}, k = 1, mv = {2, 4, 0}, xi = 48)
    static final /* data */ class SeriesSeasonProp {

        @SerializedName("code")
        @Nullable
        private final Integer code;

        @SerializedName("data")
        @NotNull
        private final List<SeriesEpisode> data;

        @SerializedName("msg")
        @Nullable
        private final String msg;

        public SeriesSeasonProp() {
            this(null, null, null, 7, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SeriesSeasonProp copy$default(SeriesSeasonProp seriesSeasonProp, Integer num, String str, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                num = seriesSeasonProp.code;
            }
            if ((i & 2) != 0) {
                str = seriesSeasonProp.msg;
            }
            if ((i & 4) != 0) {
                list = seriesSeasonProp.data;
            }
            return seriesSeasonProp.copy(num, str, list);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getCode() {
            return this.code;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getMsg() {
            return this.msg;
        }

        @NotNull
        public final List<SeriesEpisode> component3() {
            return this.data;
        }

        @NotNull
        public final SeriesSeasonProp copy(@Nullable Integer code, @Nullable String msg, @NotNull List<SeriesEpisode> data) {
            return new SeriesSeasonProp(code, msg, data);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SeriesSeasonProp)) {
                return false;
            }
            SeriesSeasonProp seriesSeasonProp = (SeriesSeasonProp) other;
            return Intrinsics.areEqual(this.code, seriesSeasonProp.code) && Intrinsics.areEqual(this.msg, seriesSeasonProp.msg) && Intrinsics.areEqual(this.data, seriesSeasonProp.data);
        }

        public int hashCode() {
            return ((((this.code == null ? 0 : this.code.hashCode()) * 31) + (this.msg != null ? this.msg.hashCode() : 0)) * 31) + this.data.hashCode();
        }

        @NotNull
        public String toString() {
            return "SeriesSeasonProp(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ')';
        }

        public SeriesSeasonProp(@Nullable Integer code, @Nullable String msg, @NotNull List<SeriesEpisode> list) {
            this.code = code;
            this.msg = msg;
            this.data = list;
        }

        public /* synthetic */ SeriesSeasonProp(Integer num, String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? CollectionsKt.emptyList() : list);
        }

        @Nullable
        public final Integer getCode() {
            return this.code;
        }

        @Nullable
        public final String getMsg() {
            return this.msg;
        }

        @NotNull
        public final List<SeriesEpisode> getData() {
            return this.data;
        }
    }

    /* JADX INFO: compiled from: ShowBox.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004R'\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR'\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/phisher98/ShowBox$SeriesLanguage;", "", "title", "", "lang", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "Lcom/google/gson/annotations/SerializedName;", "value", "getLang", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ShowBox"}, k = 1, mv = {2, 4, 0}, xi = 48)
    private static final /* data */ class SeriesLanguage {

        @SerializedName("lang")
        @Nullable
        private final String lang;

        @SerializedName("title")
        @Nullable
        private final String title;

        /* JADX WARN: Illegal instructions before constructor call */
        public SeriesLanguage() {
            String str = null;
            this(str, str, 3, str);
        }

        public static /* synthetic */ SeriesLanguage copy$default(SeriesLanguage seriesLanguage, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = seriesLanguage.title;
            }
            if ((i & 2) != 0) {
                str2 = seriesLanguage.lang;
            }
            return seriesLanguage.copy(str, str2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getLang() {
            return this.lang;
        }

        @NotNull
        public final SeriesLanguage copy(@Nullable String title, @Nullable String lang) {
            return new SeriesLanguage(title, lang);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SeriesLanguage)) {
                return false;
            }
            SeriesLanguage seriesLanguage = (SeriesLanguage) other;
            return Intrinsics.areEqual(this.title, seriesLanguage.title) && Intrinsics.areEqual(this.lang, seriesLanguage.lang);
        }

        public int hashCode() {
            return ((this.title == null ? 0 : this.title.hashCode()) * 31) + (this.lang != null ? this.lang.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "SeriesLanguage(title=" + this.title + ", lang=" + this.lang + ')';
        }

        public SeriesLanguage(@Nullable String title, @Nullable String lang) {
            this.title = title;
            this.lang = lang;
        }

        public /* synthetic */ SeriesLanguage(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final String getLang() {
            return this.lang;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: ShowBox.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\bD\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B³\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\u000b\u0010P\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010U\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\u000b\u0010V\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010W\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u00103J\u000b\u0010X\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010^\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010_\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010`\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\u000b\u0010a\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\u000b\u0010d\u001a\u0004\u0018\u00010\bHÆ\u0003Jº\u0002\u0010e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010fJ\u0014\u0010g\u001a\u00020h2\b\u0010i\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010j\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010k\u001a\u00020\bHÖ\u0081\u0004R)\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b#\u0012\b\b$\u0012\u0004\b\b(\u0002¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R)\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b#\u0012\b\b$\u0012\u0004\b\b(\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b%\u0010!R)\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b#\u0012\b\b$\u0012\u0004\b\b(\u0005¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b&\u0010!R)\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b#\u0012\b\b$\u0012\u0004\b\b(\u0006¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b'\u0010!R'\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u0092\u0002\f\b#\u0012\b\b$\u0012\u0004\b\b(\u0007¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R'\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u0092\u0002\f\b#\u0012\b\b$\u0012\u0004\b\b(\t¢\u0006\b\n\u0000\u001a\u0004\b*\u0010)R'\u0010\n\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u0092\u0002\f\b#\u0012\b\b$\u0012\u0004\b\b(,¢\u0006\b\n\u0000\u001a\u0004\b+\u0010)R'\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u0092\u0002\f\b#\u0012\b\b$\u0012\u0004\b\b(.¢\u0006\b\n\u0000\u001a\u0004\b-\u0010)R'\u0010\f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u0092\u0002\f\b#\u0012\b\b$\u0012\u0004\b\b(\f¢\u0006\b\n\u0000\u001a\u0004\b/\u0010)R)\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b#\u0012\b\b$\u0012\u0004\b\b(\r¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b0\u0010!R'\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u0092\u0002\f\b#\u0012\b\b$\u0012\u0004\b\b(\u000e¢\u0006\b\n\u0000\u001a\u0004\b1\u0010)R)\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004\u0092\u0002\f\b#\u0012\b\b$\u0012\u0004\b\b(5¢\u0006\n\n\u0002\u00104\u001a\u0004\b2\u00103R'\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u0092\u0002\f\b#\u0012\b\b$\u0012\u0004\b\b(7¢\u0006\b\n\u0000\u001a\u0004\b6\u0010)R'\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u0092\u0002\f\b#\u0012\b\b$\u0012\u0004\b\b(9¢\u0006\b\n\u0000\u001a\u0004\b8\u0010)R'\u0010\u0013\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u0092\u0002\f\b#\u0012\b\b$\u0012\u0004\b\b(;¢\u0006\b\n\u0000\u001a\u0004\b:\u0010)R'\u0010\u0014\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u0092\u0002\f\b#\u0012\b\b$\u0012\u0004\b\b(=¢\u0006\b\n\u0000\u001a\u0004\b<\u0010)R'\u0010\u0015\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u0092\u0002\f\b#\u0012\b\b$\u0012\u0004\b\b(?¢\u0006\b\n\u0000\u001a\u0004\b>\u0010)R'\u0010\u0016\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u0092\u0002\f\b#\u0012\b\b$\u0012\u0004\b\b(A¢\u0006\b\n\u0000\u001a\u0004\b@\u0010)R)\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b#\u0012\b\b$\u0012\u0004\b\b(C¢\u0006\n\n\u0002\u0010\"\u001a\u0004\bB\u0010!R)\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b#\u0012\b\b$\u0012\u0004\b\b(\u0018¢\u0006\n\n\u0002\u0010\"\u001a\u0004\bD\u0010!R)\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b#\u0012\b\b$\u0012\u0004\b\b(F¢\u0006\n\n\u0002\u0010\"\u001a\u0004\bE\u0010!R'\u0010\u001a\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u0092\u0002\f\b#\u0012\b\b$\u0012\u0004\b\b(\u001a¢\u0006\b\n\u0000\u001a\u0004\bG\u0010)R'\u0010\u001b\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u0092\u0002\f\b#\u0012\b\b$\u0012\u0004\b\b(\u001b¢\u0006\b\n\u0000\u001a\u0004\bH\u0010)R)\u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b#\u0012\b\b$\u0012\u0004\b\b(\u001c¢\u0006\n\n\u0002\u0010\"\u001a\u0004\bI\u0010!R'\u0010\u001d\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u0092\u0002\f\b#\u0012\b\b$\u0012\u0004\b\b(K¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010)¨\u0006l"}, d2 = {"Lcom/phisher98/ShowBox$SeriesEpisode;", "", "id", "", "tid", "season", "episode", "title", "", "thumbs", "thumbsBak", "thumbsOriginal", "synopsis", "runtime", "released", "releasedTimestamp", "", "audioLang", "imdbRating", "thumbsMin", "thumbsOrg", "imdbLink", "imdbId", "mbId", "state", "posterImdb", "remark", "pending", "display", "qualityTag", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "Lcom/google/gson/annotations/SerializedName;", "value", "getTid", "getSeason", "getEpisode", "getTitle", "()Ljava/lang/String;", "getThumbs", "getThumbsBak", "thumbs_bak", "getThumbsOriginal", "thumbs_original", "getSynopsis", "getRuntime", "getReleased", "getReleasedTimestamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "released_timestamp", "getAudioLang", "audio_lang", "getImdbRating", "imdb_rating", "getThumbsMin", "thumbs_min", "getThumbsOrg", "thumbs_org", "getImdbLink", "imdb_link", "getImdbId", "imdb_id", "getMbId", "mb_id", "getState", "getPosterImdb", "poster_imdb", "getRemark", "getPending", "getDisplay", "getQualityTag", "quality_tag", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/phisher98/ShowBox$SeriesEpisode;", "equals", "", "other", "hashCode", "toString", "ShowBox"}, k = 1, mv = {2, 4, 0}, xi = 48)
    static final /* data */ class SeriesEpisode {

        @SerializedName("audio_lang")
        @Nullable
        private final String audioLang;

        @SerializedName("display")
        @Nullable
        private final Integer display;

        @SerializedName("episode")
        @Nullable
        private final Integer episode;

        @SerializedName("id")
        @Nullable
        private final Integer id;

        @SerializedName("imdb_id")
        @Nullable
        private final String imdbId;

        @SerializedName("imdb_link")
        @Nullable
        private final String imdbLink;

        @SerializedName("imdb_rating")
        @Nullable
        private final String imdbRating;

        @SerializedName("mb_id")
        @Nullable
        private final Integer mbId;

        @SerializedName("pending")
        @Nullable
        private final String pending;

        @SerializedName("poster_imdb")
        @Nullable
        private final Integer posterImdb;

        @SerializedName("quality_tag")
        @Nullable
        private final String qualityTag;

        @SerializedName("released")
        @Nullable
        private final String released;

        @SerializedName("released_timestamp")
        @Nullable
        private final Long releasedTimestamp;

        @SerializedName("remark")
        @Nullable
        private final String remark;

        @SerializedName("runtime")
        @Nullable
        private final Integer runtime;

        @SerializedName("season")
        @Nullable
        private final Integer season;

        @SerializedName("state")
        @Nullable
        private final Integer state;

        @SerializedName("synopsis")
        @Nullable
        private final String synopsis;

        @SerializedName("thumbs")
        @Nullable
        private final String thumbs;

        @SerializedName("thumbs_bak")
        @Nullable
        private final String thumbsBak;

        @SerializedName("thumbs_min")
        @Nullable
        private final String thumbsMin;

        @SerializedName("thumbs_org")
        @Nullable
        private final String thumbsOrg;

        @SerializedName("thumbs_original")
        @Nullable
        private final String thumbsOriginal;

        @SerializedName("tid")
        @Nullable
        private final Integer tid;

        @SerializedName("title")
        @Nullable
        private final String title;

        public SeriesEpisode() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 33554431, null);
        }

        public static /* synthetic */ SeriesEpisode copy$default(SeriesEpisode seriesEpisode, Integer num, Integer num2, Integer num3, Integer num4, String str, String str2, String str3, String str4, String str5, Integer num5, String str6, Long l, String str7, String str8, String str9, String str10, String str11, String str12, Integer num6, Integer num7, Integer num8, String str13, String str14, Integer num9, String str15, int i, Object obj) {
            String str16;
            Integer num10;
            Integer num11 = (i & 1) != 0 ? seriesEpisode.id : num;
            Integer num12 = (i & 2) != 0 ? seriesEpisode.tid : num2;
            Integer num13 = (i & 4) != 0 ? seriesEpisode.season : num3;
            Integer num14 = (i & 8) != 0 ? seriesEpisode.episode : num4;
            String str17 = (i & 16) != 0 ? seriesEpisode.title : str;
            String str18 = (i & 32) != 0 ? seriesEpisode.thumbs : str2;
            String str19 = (i & 64) != 0 ? seriesEpisode.thumbsBak : str3;
            String str20 = (i & 128) != 0 ? seriesEpisode.thumbsOriginal : str4;
            String str21 = (i & 256) != 0 ? seriesEpisode.synopsis : str5;
            Integer num15 = (i & 512) != 0 ? seriesEpisode.runtime : num5;
            String str22 = (i & 1024) != 0 ? seriesEpisode.released : str6;
            Long l2 = (i & 2048) != 0 ? seriesEpisode.releasedTimestamp : l;
            String str23 = (i & 4096) != 0 ? seriesEpisode.audioLang : str7;
            String str24 = (i & 8192) != 0 ? seriesEpisode.imdbRating : str8;
            Integer num16 = num11;
            String str25 = (i & 16384) != 0 ? seriesEpisode.thumbsMin : str9;
            String str26 = (i & 32768) != 0 ? seriesEpisode.thumbsOrg : str10;
            String str27 = (i & 65536) != 0 ? seriesEpisode.imdbLink : str11;
            String str28 = (i & 131072) != 0 ? seriesEpisode.imdbId : str12;
            Integer num17 = (i & 262144) != 0 ? seriesEpisode.mbId : num6;
            Integer num18 = (i & 524288) != 0 ? seriesEpisode.state : num7;
            Integer num19 = (i & 1048576) != 0 ? seriesEpisode.posterImdb : num8;
            String str29 = (i & 2097152) != 0 ? seriesEpisode.remark : str13;
            String str30 = (i & 4194304) != 0 ? seriesEpisode.pending : str14;
            Integer num20 = (i & 8388608) != 0 ? seriesEpisode.display : num9;
            if ((i & 16777216) != 0) {
                num10 = num20;
                str16 = seriesEpisode.qualityTag;
            } else {
                str16 = str15;
                num10 = num20;
            }
            return seriesEpisode.copy(num16, num12, num13, num14, str17, str18, str19, str20, str21, num15, str22, l2, str23, str24, str25, str26, str27, str28, num17, num18, num19, str29, str30, num10, str16);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component10, reason: from getter */
        public final Integer getRuntime() {
            return this.runtime;
        }

        @Nullable
        /* JADX INFO: renamed from: component11, reason: from getter */
        public final String getReleased() {
            return this.released;
        }

        @Nullable
        /* JADX INFO: renamed from: component12, reason: from getter */
        public final Long getReleasedTimestamp() {
            return this.releasedTimestamp;
        }

        @Nullable
        /* JADX INFO: renamed from: component13, reason: from getter */
        public final String getAudioLang() {
            return this.audioLang;
        }

        @Nullable
        /* JADX INFO: renamed from: component14, reason: from getter */
        public final String getImdbRating() {
            return this.imdbRating;
        }

        @Nullable
        /* JADX INFO: renamed from: component15, reason: from getter */
        public final String getThumbsMin() {
            return this.thumbsMin;
        }

        @Nullable
        /* JADX INFO: renamed from: component16, reason: from getter */
        public final String getThumbsOrg() {
            return this.thumbsOrg;
        }

        @Nullable
        /* JADX INFO: renamed from: component17, reason: from getter */
        public final String getImdbLink() {
            return this.imdbLink;
        }

        @Nullable
        /* JADX INFO: renamed from: component18, reason: from getter */
        public final String getImdbId() {
            return this.imdbId;
        }

        @Nullable
        /* JADX INFO: renamed from: component19, reason: from getter */
        public final Integer getMbId() {
            return this.mbId;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getTid() {
            return this.tid;
        }

        @Nullable
        /* JADX INFO: renamed from: component20, reason: from getter */
        public final Integer getState() {
            return this.state;
        }

        @Nullable
        /* JADX INFO: renamed from: component21, reason: from getter */
        public final Integer getPosterImdb() {
            return this.posterImdb;
        }

        @Nullable
        /* JADX INFO: renamed from: component22, reason: from getter */
        public final String getRemark() {
            return this.remark;
        }

        @Nullable
        /* JADX INFO: renamed from: component23, reason: from getter */
        public final String getPending() {
            return this.pending;
        }

        @Nullable
        /* JADX INFO: renamed from: component24, reason: from getter */
        public final Integer getDisplay() {
            return this.display;
        }

        @Nullable
        /* JADX INFO: renamed from: component25, reason: from getter */
        public final String getQualityTag() {
            return this.qualityTag;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getSeason() {
            return this.season;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Integer getEpisode() {
            return this.episode;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getThumbs() {
            return this.thumbs;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getThumbsBak() {
            return this.thumbsBak;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getThumbsOriginal() {
            return this.thumbsOriginal;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getSynopsis() {
            return this.synopsis;
        }

        @NotNull
        public final SeriesEpisode copy(@Nullable Integer id, @Nullable Integer tid, @Nullable Integer season, @Nullable Integer episode, @Nullable String title, @Nullable String thumbs, @Nullable String thumbsBak, @Nullable String thumbsOriginal, @Nullable String synopsis, @Nullable Integer runtime, @Nullable String released, @Nullable Long releasedTimestamp, @Nullable String audioLang, @Nullable String imdbRating, @Nullable String thumbsMin, @Nullable String thumbsOrg, @Nullable String imdbLink, @Nullable String imdbId, @Nullable Integer mbId, @Nullable Integer state, @Nullable Integer posterImdb, @Nullable String remark, @Nullable String pending, @Nullable Integer display, @Nullable String qualityTag) {
            return new SeriesEpisode(id, tid, season, episode, title, thumbs, thumbsBak, thumbsOriginal, synopsis, runtime, released, releasedTimestamp, audioLang, imdbRating, thumbsMin, thumbsOrg, imdbLink, imdbId, mbId, state, posterImdb, remark, pending, display, qualityTag);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SeriesEpisode)) {
                return false;
            }
            SeriesEpisode seriesEpisode = (SeriesEpisode) other;
            return Intrinsics.areEqual(this.id, seriesEpisode.id) && Intrinsics.areEqual(this.tid, seriesEpisode.tid) && Intrinsics.areEqual(this.season, seriesEpisode.season) && Intrinsics.areEqual(this.episode, seriesEpisode.episode) && Intrinsics.areEqual(this.title, seriesEpisode.title) && Intrinsics.areEqual(this.thumbs, seriesEpisode.thumbs) && Intrinsics.areEqual(this.thumbsBak, seriesEpisode.thumbsBak) && Intrinsics.areEqual(this.thumbsOriginal, seriesEpisode.thumbsOriginal) && Intrinsics.areEqual(this.synopsis, seriesEpisode.synopsis) && Intrinsics.areEqual(this.runtime, seriesEpisode.runtime) && Intrinsics.areEqual(this.released, seriesEpisode.released) && Intrinsics.areEqual(this.releasedTimestamp, seriesEpisode.releasedTimestamp) && Intrinsics.areEqual(this.audioLang, seriesEpisode.audioLang) && Intrinsics.areEqual(this.imdbRating, seriesEpisode.imdbRating) && Intrinsics.areEqual(this.thumbsMin, seriesEpisode.thumbsMin) && Intrinsics.areEqual(this.thumbsOrg, seriesEpisode.thumbsOrg) && Intrinsics.areEqual(this.imdbLink, seriesEpisode.imdbLink) && Intrinsics.areEqual(this.imdbId, seriesEpisode.imdbId) && Intrinsics.areEqual(this.mbId, seriesEpisode.mbId) && Intrinsics.areEqual(this.state, seriesEpisode.state) && Intrinsics.areEqual(this.posterImdb, seriesEpisode.posterImdb) && Intrinsics.areEqual(this.remark, seriesEpisode.remark) && Intrinsics.areEqual(this.pending, seriesEpisode.pending) && Intrinsics.areEqual(this.display, seriesEpisode.display) && Intrinsics.areEqual(this.qualityTag, seriesEpisode.qualityTag);
        }

        public int hashCode() {
            return ((((((((((((((((((((((((((((((((((((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.tid == null ? 0 : this.tid.hashCode())) * 31) + (this.season == null ? 0 : this.season.hashCode())) * 31) + (this.episode == null ? 0 : this.episode.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.thumbs == null ? 0 : this.thumbs.hashCode())) * 31) + (this.thumbsBak == null ? 0 : this.thumbsBak.hashCode())) * 31) + (this.thumbsOriginal == null ? 0 : this.thumbsOriginal.hashCode())) * 31) + (this.synopsis == null ? 0 : this.synopsis.hashCode())) * 31) + (this.runtime == null ? 0 : this.runtime.hashCode())) * 31) + (this.released == null ? 0 : this.released.hashCode())) * 31) + (this.releasedTimestamp == null ? 0 : this.releasedTimestamp.hashCode())) * 31) + (this.audioLang == null ? 0 : this.audioLang.hashCode())) * 31) + (this.imdbRating == null ? 0 : this.imdbRating.hashCode())) * 31) + (this.thumbsMin == null ? 0 : this.thumbsMin.hashCode())) * 31) + (this.thumbsOrg == null ? 0 : this.thumbsOrg.hashCode())) * 31) + (this.imdbLink == null ? 0 : this.imdbLink.hashCode())) * 31) + (this.imdbId == null ? 0 : this.imdbId.hashCode())) * 31) + (this.mbId == null ? 0 : this.mbId.hashCode())) * 31) + (this.state == null ? 0 : this.state.hashCode())) * 31) + (this.posterImdb == null ? 0 : this.posterImdb.hashCode())) * 31) + (this.remark == null ? 0 : this.remark.hashCode())) * 31) + (this.pending == null ? 0 : this.pending.hashCode())) * 31) + (this.display == null ? 0 : this.display.hashCode())) * 31) + (this.qualityTag != null ? this.qualityTag.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("SeriesEpisode(id=").append(this.id).append(", tid=").append(this.tid).append(", season=").append(this.season).append(", episode=").append(this.episode).append(", title=").append(this.title).append(", thumbs=").append(this.thumbs).append(", thumbsBak=").append(this.thumbsBak).append(", thumbsOriginal=").append(this.thumbsOriginal).append(", synopsis=").append(this.synopsis).append(", runtime=").append(this.runtime).append(", released=").append(this.released).append(", releasedTimestamp=");
            sb.append(this.releasedTimestamp).append(", audioLang=").append(this.audioLang).append(", imdbRating=").append(this.imdbRating).append(", thumbsMin=").append(this.thumbsMin).append(", thumbsOrg=").append(this.thumbsOrg).append(", imdbLink=").append(this.imdbLink).append(", imdbId=").append(this.imdbId).append(", mbId=").append(this.mbId).append(", state=").append(this.state).append(", posterImdb=").append(this.posterImdb).append(", remark=").append(this.remark).append(", pending=").append(this.pending);
            sb.append(", display=").append(this.display).append(", qualityTag=").append(this.qualityTag).append(')');
            return sb.toString();
        }

        public SeriesEpisode(@Nullable Integer id, @Nullable Integer tid, @Nullable Integer season, @Nullable Integer episode, @Nullable String title, @Nullable String thumbs, @Nullable String thumbsBak, @Nullable String thumbsOriginal, @Nullable String synopsis, @Nullable Integer runtime, @Nullable String released, @Nullable Long releasedTimestamp, @Nullable String audioLang, @Nullable String imdbRating, @Nullable String thumbsMin, @Nullable String thumbsOrg, @Nullable String imdbLink, @Nullable String imdbId, @Nullable Integer mbId, @Nullable Integer state, @Nullable Integer posterImdb, @Nullable String remark, @Nullable String pending, @Nullable Integer display, @Nullable String qualityTag) {
            this.id = id;
            this.tid = tid;
            this.season = season;
            this.episode = episode;
            this.title = title;
            this.thumbs = thumbs;
            this.thumbsBak = thumbsBak;
            this.thumbsOriginal = thumbsOriginal;
            this.synopsis = synopsis;
            this.runtime = runtime;
            this.released = released;
            this.releasedTimestamp = releasedTimestamp;
            this.audioLang = audioLang;
            this.imdbRating = imdbRating;
            this.thumbsMin = thumbsMin;
            this.thumbsOrg = thumbsOrg;
            this.imdbLink = imdbLink;
            this.imdbId = imdbId;
            this.mbId = mbId;
            this.state = state;
            this.posterImdb = posterImdb;
            this.remark = remark;
            this.pending = pending;
            this.display = display;
            this.qualityTag = qualityTag;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ SeriesEpisode(Integer num, Integer num2, Integer num3, Integer num4, String str, String str2, String str3, String str4, String str5, Integer num5, String str6, Long l, String str7, String str8, String str9, String str10, String str11, String str12, Integer num6, Integer num7, Integer num8, String str13, String str14, Integer num9, String str15, int i, DefaultConstructorMarker defaultConstructorMarker) {
            Integer num10 = (i & 1) != 0 ? null : num;
            Integer num11 = (i & 2) != 0 ? null : num2;
            Integer num12 = (i & 4) != 0 ? null : num3;
            Integer num13 = (i & 8) != 0 ? null : num4;
            String str16 = (i & 16) != 0 ? null : str;
            String str17 = (i & 32) != 0 ? null : str2;
            String str18 = (i & 64) != 0 ? null : str3;
            String str19 = (i & 128) != 0 ? null : str4;
            String str20 = (i & 256) != 0 ? null : str5;
            Integer num14 = (i & 512) != 0 ? null : num5;
            String str21 = (i & 1024) != 0 ? null : str6;
            Long l2 = (i & 2048) != 0 ? null : l;
            String str22 = (i & 4096) != 0 ? null : str7;
            String str23 = (i & 8192) != 0 ? null : str8;
            String str24 = (i & 16384) != 0 ? null : str9;
            this(num10, num11, num12, num13, str16, str17, str18, str19, str20, num14, str21, l2, str22, str23, str24, (i & 32768) != 0 ? null : str10, (i & 65536) != 0 ? null : str11, (i & 131072) != 0 ? null : str12, (i & 262144) != 0 ? null : num6, (i & 524288) != 0 ? null : num7, (i & 1048576) != 0 ? null : num8, (i & 2097152) != 0 ? null : str13, (i & 4194304) != 0 ? null : str14, (i & 8388608) != 0 ? null : num9, (i & 16777216) != 0 ? null : str15);
        }

        @Nullable
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        public final Integer getTid() {
            return this.tid;
        }

        @Nullable
        public final Integer getSeason() {
            return this.season;
        }

        @Nullable
        public final Integer getEpisode() {
            return this.episode;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final String getThumbs() {
            return this.thumbs;
        }

        @Nullable
        public final String getThumbsBak() {
            return this.thumbsBak;
        }

        @Nullable
        public final String getThumbsOriginal() {
            return this.thumbsOriginal;
        }

        @Nullable
        public final String getSynopsis() {
            return this.synopsis;
        }

        @Nullable
        public final Integer getRuntime() {
            return this.runtime;
        }

        @Nullable
        public final String getReleased() {
            return this.released;
        }

        @Nullable
        public final Long getReleasedTimestamp() {
            return this.releasedTimestamp;
        }

        @Nullable
        public final String getAudioLang() {
            return this.audioLang;
        }

        @Nullable
        public final String getImdbRating() {
            return this.imdbRating;
        }

        @Nullable
        public final String getThumbsMin() {
            return this.thumbsMin;
        }

        @Nullable
        public final String getThumbsOrg() {
            return this.thumbsOrg;
        }

        @Nullable
        public final String getImdbLink() {
            return this.imdbLink;
        }

        @Nullable
        public final String getImdbId() {
            return this.imdbId;
        }

        @Nullable
        public final Integer getMbId() {
            return this.mbId;
        }

        @Nullable
        public final Integer getState() {
            return this.state;
        }

        @Nullable
        public final Integer getPosterImdb() {
            return this.posterImdb;
        }

        @Nullable
        public final String getRemark() {
            return this.remark;
        }

        @Nullable
        public final String getPending() {
            return this.pending;
        }

        @Nullable
        public final Integer getDisplay() {
            return this.display;
        }

        @Nullable
        public final String getQualityTag() {
            return this.qualityTag;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: ShowBox.kt */
    @Metadata(d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b(\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0003\b\u009d\u0001\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001BÇ\u0005\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0006\u0012\u000e\b\u0002\u00105\u001a\b\u0012\u0004\u0012\u00020\u000306\u0012\u000e\b\u0002\u00107\u001a\b\u0012\u0004\u0012\u00020\u000306\u0012\u000e\b\u0002\u00108\u001a\b\u0012\u0004\u0012\u00020\u000606\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0006\u0012\u000e\b\u0002\u0010:\u001a\b\u0012\u0004\u0012\u00020;06\u0012\u000e\b\u0002\u0010<\u001a\b\u0012\u0004\u0012\u00020=06\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\bA\u0010BJ\u0011\u0010¨\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010DJ\u0011\u0010©\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010DJ\f\u0010ª\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010«\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010DJ\u0011\u0010¬\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010DJ\u0011\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010DJ\u0011\u0010®\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010DJ\f\u0010¯\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010°\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010±\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010²\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010DJ\f\u0010³\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010´\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010DJ\f\u0010µ\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010¶\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010·\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010¸\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010¹\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010DJ\u0011\u0010º\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010DJ\u0011\u0010»\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010DJ\u0011\u0010¼\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010DJ\f\u0010½\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010¾\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010¿\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010DJ\f\u0010À\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010Á\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010DJ\u0011\u0010Â\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010DJ\u0011\u0010Ã\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010DJ\f\u0010Ä\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010Å\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010Æ\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010Ç\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010DJ\f\u0010È\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010É\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010DJ\u0011\u0010Ê\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010DJ\f\u0010Ë\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010Ì\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010Í\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010DJ\u0011\u0010Î\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010DJ\u0011\u0010Ï\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010DJ\u0011\u0010Ð\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010DJ\f\u0010Ñ\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0012\u0010Ò\u0001\u001a\u0004\u0018\u00010/HÆ\u0003¢\u0006\u0003\u0010\u008d\u0001J\f\u0010Ó\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010Ô\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010Õ\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010Ö\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010×\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010Ø\u0001\u001a\b\u0012\u0004\u0012\u00020\u000306HÆ\u0003J\u0010\u0010Ù\u0001\u001a\b\u0012\u0004\u0012\u00020\u000306HÆ\u0003J\u0010\u0010Ú\u0001\u001a\b\u0012\u0004\u0012\u00020\u000606HÆ\u0003J\f\u0010Û\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010Ü\u0001\u001a\b\u0012\u0004\u0012\u00020;06HÆ\u0003J\u0010\u0010Ý\u0001\u001a\b\u0012\u0004\u0012\u00020=06HÆ\u0003J\u0011\u0010Þ\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010DJ\f\u0010ß\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010à\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003JÐ\u0005\u0010á\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00062\u000e\b\u0002\u00105\u001a\b\u0012\u0004\u0012\u00020\u0003062\u000e\b\u0002\u00107\u001a\b\u0012\u0004\u0012\u00020\u0003062\u000e\b\u0002\u00108\u001a\b\u0012\u0004\u0012\u00020\u0006062\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00062\u000e\b\u0002\u0010:\u001a\b\u0012\u0004\u0012\u00020;062\u000e\b\u0002\u0010<\u001a\b\u0012\u0004\u0012\u00020=062\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0003\u0010â\u0001J\u0017\u0010ã\u0001\u001a\u00030ä\u00012\t\u0010å\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\u000b\u0010æ\u0001\u001a\u00020\u0003HÖ\u0081\u0004J\u000b\u0010ç\u0001\u001a\u00020\u0006HÖ\u0081\u0004R)\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\bF\u0012\b\bG\u0012\u0004\b\b(\u0002¢\u0006\n\n\u0002\u0010E\u001a\u0004\bC\u0010DR)\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\bF\u0012\b\bG\u0012\u0004\b\b(I¢\u0006\n\n\u0002\u0010E\u001a\u0004\bH\u0010DR'\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u0092\u0002\f\bF\u0012\b\bG\u0012\u0004\b\b(\u0005¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR)\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\bF\u0012\b\bG\u0012\u0004\b\b(\u0007¢\u0006\n\n\u0002\u0010E\u001a\u0004\bL\u0010DR)\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\bF\u0012\b\bG\u0012\u0004\b\b(\b¢\u0006\n\n\u0002\u0010E\u001a\u0004\bM\u0010DR)\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\bF\u0012\b\bG\u0012\u0004\b\b(O¢\u0006\n\n\u0002\u0010E\u001a\u0004\bN\u0010DR)\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\bF\u0012\b\bG\u0012\u0004\b\b(Q¢\u0006\n\n\u0002\u0010E\u001a\u0004\bP\u0010DR'\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u0092\u0002\f\bF\u0012\b\bG\u0012\u0004\b\b(\u000b¢\u0006\b\n\u0000\u001a\u0004\bR\u0010KR'\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u0092\u0002\f\bF\u0012\b\bG\u0012\u0004\b\b(\f¢\u0006\b\n\u0000\u001a\u0004\bS\u0010KR'\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u0092\u0002\f\bF\u0012\b\bG\u0012\u0004\b\b(\r¢\u0006\b\n\u0000\u001a\u0004\bT\u0010KR)\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\bF\u0012\b\bG\u0012\u0004\b\b(V¢\u0006\n\n\u0002\u0010E\u001a\u0004\bU\u0010DR'\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u0092\u0002\f\bF\u0012\b\bG\u0012\u0004\b\b(\u000f¢\u0006\b\n\u0000\u001a\u0004\bW\u0010KR)\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\bF\u0012\b\bG\u0012\u0004\b\b(Y¢\u0006\n\n\u0002\u0010E\u001a\u0004\bX\u0010DR'\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u0092\u0002\f\bF\u0012\b\bG\u0012\u0004\b\b([¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010KR'\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u0092\u0002\f\bF\u0012\b\bG\u0012\u0004\b\b(\u0012¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010KR'\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u0092\u0002\f\bF\u0012\b\bG\u0012\u0004\b\b(^¢\u0006\b\n\u0000\u001a\u0004\b]\u0010KR'\u0010\u0014\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u0092\u0002\f\bF\u0012\b\bG\u0012\u0004\b\b(\u0014¢\u0006\b\n\u0000\u001a\u0004\b_\u0010KR)\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\bF\u0012\b\bG\u0012\u0004\b\b(\u0015¢\u0006\n\n\u0002\u0010E\u001a\u0004\b`\u0010DR)\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\bF\u0012\b\bG\u0012\u0004\b\b(\u0016¢\u0006\n\n\u0002\u0010E\u001a\u0004\ba\u0010DR)\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\bF\u0012\b\bG\u0012\u0004\b\b(\u0017¢\u0006\n\n\u0002\u0010E\u001a\u0004\bb\u0010DR)\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\bF\u0012\b\bG\u0012\u0004\b\b(\u0018¢\u0006\n\n\u0002\u0010E\u001a\u0004\bc\u0010DR'\u0010\u0019\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u0092\u0002\f\bF\u0012\b\bG\u0012\u0004\b\b(e¢\u0006\b\n\u0000\u001a\u0004\bd\u0010KR'\u0010\u001a\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u0092\u0002\f\bF\u0012\b\bG\u0012\u0004\b\b(\u001a¢\u0006\b\n\u0000\u001a\u0004\bf\u0010KR)\u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\bF\u0012\b\bG\u0012\u0004\b\b(h¢\u0006\n\n\u0002\u0010E\u001a\u0004\bg\u0010DR'\u0010\u001c\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u0092\u0002\f\bF\u0012\b\bG\u0012\u0004\b\b(j¢\u0006\b\n\u0000\u001a\u0004\bi\u0010KR)\u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\bF\u0012\b\bG\u0012\u0004\b\b(l¢\u0006\n\n\u0002\u0010E\u001a\u0004\bk\u0010DR)\u0010\u001e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\bF\u0012\b\bG\u0012\u0004\b\b(n¢\u0006\n\n\u0002\u0010E\u001a\u0004\bm\u0010DR)\u0010\u001f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\bF\u0012\b\bG\u0012\u0004\b\b(p¢\u0006\n\n\u0002\u0010E\u001a\u0004\bo\u0010DR'\u0010 \u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u0092\u0002\f\bF\u0012\b\bG\u0012\u0004\b\b( ¢\u0006\b\n\u0000\u001a\u0004\bq\u0010KR'\u0010!\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u0092\u0002\f\bF\u0012\b\bG\u0012\u0004\b\b(s¢\u0006\b\n\u0000\u001a\u0004\br\u0010KR'\u0010\"\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u0092\u0002\f\bF\u0012\b\bG\u0012\u0004\b\b(u¢\u0006\b\n\u0000\u001a\u0004\bt\u0010KR)\u0010#\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\bF\u0012\b\bG\u0012\u0004\b\b(w¢\u0006\n\n\u0002\u0010E\u001a\u0004\bv\u0010DR'\u0010$\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u0092\u0002\f\bF\u0012\b\bG\u0012\u0004\b\b(y¢\u0006\b\n\u0000\u001a\u0004\bx\u0010KR)\u0010%\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\bF\u0012\b\bG\u0012\u0004\b\b({¢\u0006\n\n\u0002\u0010E\u001a\u0004\bz\u0010DR)\u0010&\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\bF\u0012\b\bG\u0012\u0004\b\b(}¢\u0006\n\n\u0002\u0010E\u001a\u0004\b|\u0010DR'\u0010'\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u0092\u0002\f\bF\u0012\b\bG\u0012\u0004\b\b(\u007f¢\u0006\b\n\u0000\u001a\u0004\b~\u0010KR)\u0010(\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u0092\u0002\r\bF\u0012\t\bG\u0012\u0005\b\b(\u0081\u0001¢\u0006\t\n\u0000\u001a\u0005\b\u0080\u0001\u0010KR+\u0010)\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\r\bF\u0012\t\bG\u0012\u0005\b\b(\u0083\u0001¢\u0006\u000b\n\u0002\u0010E\u001a\u0005\b\u0082\u0001\u0010DR+\u0010*\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\r\bF\u0012\t\bG\u0012\u0005\b\b(\u0085\u0001¢\u0006\u000b\n\u0002\u0010E\u001a\u0005\b\u0084\u0001\u0010DR+\u0010+\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\r\bF\u0012\t\bG\u0012\u0005\b\b(\u0087\u0001¢\u0006\u000b\n\u0002\u0010E\u001a\u0005\b\u0086\u0001\u0010DR+\u0010,\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\r\bF\u0012\t\bG\u0012\u0005\b\b(\u0089\u0001¢\u0006\u000b\n\u0002\u0010E\u001a\u0005\b\u0088\u0001\u0010DR)\u0010-\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u0092\u0002\r\bF\u0012\t\bG\u0012\u0005\b\b(\u008b\u0001¢\u0006\t\n\u0000\u001a\u0005\b\u008a\u0001\u0010KR-\u0010.\u001a\u0004\u0018\u00010/8\u0006X\u0087\u0004\u0092\u0002\r\bF\u0012\t\bG\u0012\u0005\b\b(\u008f\u0001¢\u0006\r\n\u0003\u0010\u008e\u0001\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001R)\u00100\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u0092\u0002\r\bF\u0012\t\bG\u0012\u0005\b\b(\u0091\u0001¢\u0006\t\n\u0000\u001a\u0005\b\u0090\u0001\u0010KR)\u00101\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u0092\u0002\r\bF\u0012\t\bG\u0012\u0005\b\b(\u0093\u0001¢\u0006\t\n\u0000\u001a\u0005\b\u0092\u0001\u0010KR)\u00102\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u0092\u0002\r\bF\u0012\t\bG\u0012\u0005\b\b(\u0095\u0001¢\u0006\t\n\u0000\u001a\u0005\b\u0094\u0001\u0010KR)\u00103\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u0092\u0002\r\bF\u0012\t\bG\u0012\u0005\b\b(\u0097\u0001¢\u0006\t\n\u0000\u001a\u0005\b\u0096\u0001\u0010KR)\u00104\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u0092\u0002\r\bF\u0012\t\bG\u0012\u0005\b\b(\u0099\u0001¢\u0006\t\n\u0000\u001a\u0005\b\u0098\u0001\u0010KR-\u00105\u001a\b\u0012\u0004\u0012\u00020\u0003068\u0006X\u0087\u0004\u0092\u0002\f\bF\u0012\b\bG\u0012\u0004\b\b(5¢\u0006\n\n\u0000\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001R-\u00107\u001a\b\u0012\u0004\u0012\u00020\u0003068\u0006X\u0087\u0004\u0092\u0002\f\bF\u0012\b\bG\u0012\u0004\b\b(7¢\u0006\n\n\u0000\u001a\u0006\b\u009c\u0001\u0010\u009b\u0001R-\u00108\u001a\b\u0012\u0004\u0012\u00020\u0006068\u0006X\u0087\u0004\u0092\u0002\f\bF\u0012\b\bG\u0012\u0004\b\b(8¢\u0006\n\n\u0000\u001a\u0006\b\u009d\u0001\u0010\u009b\u0001R)\u00109\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u0092\u0002\r\bF\u0012\t\bG\u0012\u0005\b\b(\u009f\u0001¢\u0006\t\n\u0000\u001a\u0005\b\u009e\u0001\u0010KR-\u0010:\u001a\b\u0012\u0004\u0012\u00020;068\u0006X\u0087\u0004\u0092\u0002\f\bF\u0012\b\bG\u0012\u0004\b\b(:¢\u0006\n\n\u0000\u001a\u0006\b \u0001\u0010\u009b\u0001R-\u0010<\u001a\b\u0012\u0004\u0012\u00020=068\u0006X\u0087\u0004\u0092\u0002\f\bF\u0012\b\bG\u0012\u0004\b\b(<¢\u0006\n\n\u0000\u001a\u0006\b¡\u0001\u0010\u009b\u0001R+\u0010>\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\r\bF\u0012\t\bG\u0012\u0005\b\b(£\u0001¢\u0006\u000b\n\u0002\u0010E\u001a\u0005\b¢\u0001\u0010DR)\u0010?\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u0092\u0002\r\bF\u0012\t\bG\u0012\u0005\b\b(¥\u0001¢\u0006\t\n\u0000\u001a\u0005\b¤\u0001\u0010KR)\u0010@\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u0092\u0002\r\bF\u0012\t\bG\u0012\u0005\b\b(§\u0001¢\u0006\t\n\u0000\u001a\u0005\b¦\u0001\u0010K¨\u0006è\u0001"}, d2 = {"Lcom/phisher98/ShowBox$SeriesData;", "", "id", "", "mbId", "title", "", "display", "state", "vipOnly", "codeFile", "director", "writer", "actors", "addTime", "poster", "posterImdb", "bannerMini", "description", "imdbId", "cats", "year", "collect", "view", "download", "updateTime", "released", "releasedTimestamp", "episodeReleased", "episodeReleasedTimestamp", "maxSeason", "maxEpisode", "remark", "imdbRating", "contentRating", "tmdbId", "tomatoUrl", "tomatoMeter", "tomatoMeterCount", "tomatoMeterState", "reelgoodUrl", "audienceScore", "audienceScoreCount", "noTomatoUrl", "orderYear", "episodateId", "weightsDay", "", "posterMin", "posterOrg", "bannerMiniMin", "bannerMiniOrg", "trailerUrl", "years", "", "season", "history", "imdbLink", "episode", "Lcom/phisher98/ShowBox$SeriesEpisode;", "language", "Lcom/phisher98/ShowBox$SeriesLanguage;", "boxType", "yearYear", "seasonEpisode", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "Lcom/google/gson/annotations/SerializedName;", "value", "getMbId", "mb_id", "getTitle", "()Ljava/lang/String;", "getDisplay", "getState", "getVipOnly", "vip_only", "getCodeFile", "code_file", "getDirector", "getWriter", "getActors", "getAddTime", "add_time", "getPoster", "getPosterImdb", "poster_imdb", "getBannerMini", "banner_mini", "getDescription", "getImdbId", "imdb_id", "getCats", "getYear", "getCollect", "getView", "getDownload", "getUpdateTime", "update_time", "getReleased", "getReleasedTimestamp", "released_timestamp", "getEpisodeReleased", "episode_released", "getEpisodeReleasedTimestamp", "episode_released_timestamp", "getMaxSeason", "max_season", "getMaxEpisode", "max_episode", "getRemark", "getImdbRating", "imdb_rating", "getContentRating", "content_rating", "getTmdbId", "tmdb_id", "getTomatoUrl", "tomato_url", "getTomatoMeter", "tomato_meter", "getTomatoMeterCount", "tomato_meter_count", "getTomatoMeterState", "tomato_meter_state", "getReelgoodUrl", "reelgood_url", "getAudienceScore", "audience_score", "getAudienceScoreCount", "audience_score_count", "getNoTomatoUrl", "no_tomato_url", "getOrderYear", "order_year", "getEpisodateId", "episodate_id", "getWeightsDay", "()Ljava/lang/Double;", "Ljava/lang/Double;", "weights_day", "getPosterMin", "poster_min", "getPosterOrg", "poster_org", "getBannerMiniMin", "banner_mini_min", "getBannerMiniOrg", "banner_mini_org", "getTrailerUrl", "trailer_url", "getYears", "()Ljava/util/List;", "getSeason", "getHistory", "getImdbLink", "imdb_link", "getEpisode", "getLanguage", "getBoxType", "box_type", "getYearYear", "year_year", "getSeasonEpisode", "season_episode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component50", "component51", "component52", "component53", "component54", "component55", "component56", "component57", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/phisher98/ShowBox$SeriesData;", "equals", "", "other", "hashCode", "toString", "ShowBox"}, k = 1, mv = {2, 4, 0}, xi = 48)
    static final /* data */ class SeriesData {

        @SerializedName("actors")
        @Nullable
        private final String actors;

        @SerializedName("add_time")
        @Nullable
        private final Integer addTime;

        @SerializedName("audience_score")
        @Nullable
        private final Integer audienceScore;

        @SerializedName("audience_score_count")
        @Nullable
        private final Integer audienceScoreCount;

        @SerializedName("banner_mini")
        @Nullable
        private final String bannerMini;

        @SerializedName("banner_mini_min")
        @Nullable
        private final String bannerMiniMin;

        @SerializedName("banner_mini_org")
        @Nullable
        private final String bannerMiniOrg;

        @SerializedName("box_type")
        @Nullable
        private final Integer boxType;

        @SerializedName("cats")
        @Nullable
        private final String cats;

        @SerializedName("code_file")
        @Nullable
        private final Integer codeFile;

        @SerializedName("collect")
        @Nullable
        private final Integer collect;

        @SerializedName("content_rating")
        @Nullable
        private final String contentRating;

        @SerializedName("description")
        @Nullable
        private final String description;

        @SerializedName("director")
        @Nullable
        private final String director;

        @SerializedName("display")
        @Nullable
        private final Integer display;

        @SerializedName("download")
        @Nullable
        private final Integer download;

        @SerializedName("episodate_id")
        @Nullable
        private final String episodateId;

        @SerializedName("episode")
        @NotNull
        private final List<SeriesEpisode> episode;

        @SerializedName("episode_released")
        @Nullable
        private final String episodeReleased;

        @SerializedName("episode_released_timestamp")
        @Nullable
        private final Integer episodeReleasedTimestamp;

        @SerializedName("history")
        @NotNull
        private final List<String> history;

        @SerializedName("id")
        @Nullable
        private final Integer id;

        @SerializedName("imdb_id")
        @Nullable
        private final String imdbId;

        @SerializedName("imdb_link")
        @Nullable
        private final String imdbLink;

        @SerializedName("imdb_rating")
        @Nullable
        private final String imdbRating;

        @SerializedName("language")
        @NotNull
        private final List<SeriesLanguage> language;

        @SerializedName("max_episode")
        @Nullable
        private final Integer maxEpisode;

        @SerializedName("max_season")
        @Nullable
        private final Integer maxSeason;

        @SerializedName("mb_id")
        @Nullable
        private final Integer mbId;

        @SerializedName("no_tomato_url")
        @Nullable
        private final Integer noTomatoUrl;

        @SerializedName("order_year")
        @Nullable
        private final Integer orderYear;

        @SerializedName("poster")
        @Nullable
        private final String poster;

        @SerializedName("poster_imdb")
        @Nullable
        private final Integer posterImdb;

        @SerializedName("poster_min")
        @Nullable
        private final String posterMin;

        @SerializedName("poster_org")
        @Nullable
        private final String posterOrg;

        @SerializedName("reelgood_url")
        @Nullable
        private final String reelgoodUrl;

        @SerializedName("released")
        @Nullable
        private final String released;

        @SerializedName("released_timestamp")
        @Nullable
        private final Integer releasedTimestamp;

        @SerializedName("remark")
        @Nullable
        private final String remark;

        @SerializedName("season")
        @NotNull
        private final List<Integer> season;

        @SerializedName("season_episode")
        @Nullable
        private final String seasonEpisode;

        @SerializedName("state")
        @Nullable
        private final Integer state;

        @SerializedName("title")
        @Nullable
        private final String title;

        @SerializedName("tmdb_id")
        @Nullable
        private final Integer tmdbId;

        @SerializedName("tomato_meter")
        @Nullable
        private final Integer tomatoMeter;

        @SerializedName("tomato_meter_count")
        @Nullable
        private final Integer tomatoMeterCount;

        @SerializedName("tomato_meter_state")
        @Nullable
        private final String tomatoMeterState;

        @SerializedName("tomato_url")
        @Nullable
        private final String tomatoUrl;

        @SerializedName("trailer_url")
        @Nullable
        private final String trailerUrl;

        @SerializedName("update_time")
        @Nullable
        private final String updateTime;

        @SerializedName("view")
        @Nullable
        private final Integer view;

        @SerializedName("vip_only")
        @Nullable
        private final Integer vipOnly;

        @SerializedName("weights_day")
        @Nullable
        private final Double weightsDay;

        @SerializedName("writer")
        @Nullable
        private final String writer;

        @SerializedName("year")
        @Nullable
        private final Integer year;

        @SerializedName("year_year")
        @Nullable
        private final String yearYear;

        @SerializedName("years")
        @NotNull
        private final List<Integer> years;

        public SeriesData() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 33554431, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SeriesData copy$default(SeriesData seriesData, Integer num, Integer num2, String str, Integer num3, Integer num4, Integer num5, Integer num6, String str2, String str3, String str4, Integer num7, String str5, Integer num8, String str6, String str7, String str8, String str9, Integer num9, Integer num10, Integer num11, Integer num12, String str10, String str11, Integer num13, String str12, Integer num14, Integer num15, Integer num16, String str13, String str14, String str15, Integer num17, String str16, Integer num18, Integer num19, String str17, String str18, Integer num20, Integer num21, Integer num22, Integer num23, String str19, Double d, String str20, String str21, String str22, String str23, String str24, List list, List list2, List list3, String str25, List list4, List list5, Integer num24, String str26, String str27, int i, int i2, Object obj) {
            Integer num25 = (i & 1) != 0 ? seriesData.id : num;
            return seriesData.copy(num25, (i & 2) != 0 ? seriesData.mbId : num2, (i & 4) != 0 ? seriesData.title : str, (i & 8) != 0 ? seriesData.display : num3, (i & 16) != 0 ? seriesData.state : num4, (i & 32) != 0 ? seriesData.vipOnly : num5, (i & 64) != 0 ? seriesData.codeFile : num6, (i & 128) != 0 ? seriesData.director : str2, (i & 256) != 0 ? seriesData.writer : str3, (i & 512) != 0 ? seriesData.actors : str4, (i & 1024) != 0 ? seriesData.addTime : num7, (i & 2048) != 0 ? seriesData.poster : str5, (i & 4096) != 0 ? seriesData.posterImdb : num8, (i & 8192) != 0 ? seriesData.bannerMini : str6, (i & 16384) != 0 ? seriesData.description : str7, (i & 32768) != 0 ? seriesData.imdbId : str8, (i & 65536) != 0 ? seriesData.cats : str9, (i & 131072) != 0 ? seriesData.year : num9, (i & 262144) != 0 ? seriesData.collect : num10, (i & 524288) != 0 ? seriesData.view : num11, (i & 1048576) != 0 ? seriesData.download : num12, (i & 2097152) != 0 ? seriesData.updateTime : str10, (i & 4194304) != 0 ? seriesData.released : str11, (i & 8388608) != 0 ? seriesData.releasedTimestamp : num13, (i & 16777216) != 0 ? seriesData.episodeReleased : str12, (i & 33554432) != 0 ? seriesData.episodeReleasedTimestamp : num14, (i & 67108864) != 0 ? seriesData.maxSeason : num15, (i & 134217728) != 0 ? seriesData.maxEpisode : num16, (i & 268435456) != 0 ? seriesData.remark : str13, (i & 536870912) != 0 ? seriesData.imdbRating : str14, (i & 1073741824) != 0 ? seriesData.contentRating : str15, (i & Integer.MIN_VALUE) != 0 ? seriesData.tmdbId : num17, (i2 & 1) != 0 ? seriesData.tomatoUrl : str16, (i2 & 2) != 0 ? seriesData.tomatoMeter : num18, (i2 & 4) != 0 ? seriesData.tomatoMeterCount : num19, (i2 & 8) != 0 ? seriesData.tomatoMeterState : str17, (i2 & 16) != 0 ? seriesData.reelgoodUrl : str18, (i2 & 32) != 0 ? seriesData.audienceScore : num20, (i2 & 64) != 0 ? seriesData.audienceScoreCount : num21, (i2 & 128) != 0 ? seriesData.noTomatoUrl : num22, (i2 & 256) != 0 ? seriesData.orderYear : num23, (i2 & 512) != 0 ? seriesData.episodateId : str19, (i2 & 1024) != 0 ? seriesData.weightsDay : d, (i2 & 2048) != 0 ? seriesData.posterMin : str20, (i2 & 4096) != 0 ? seriesData.posterOrg : str21, (i2 & 8192) != 0 ? seriesData.bannerMiniMin : str22, (i2 & 16384) != 0 ? seriesData.bannerMiniOrg : str23, (i2 & 32768) != 0 ? seriesData.trailerUrl : str24, (i2 & 65536) != 0 ? seriesData.years : list, (i2 & 131072) != 0 ? seriesData.season : list2, (i2 & 262144) != 0 ? seriesData.history : list3, (i2 & 524288) != 0 ? seriesData.imdbLink : str25, (i2 & 1048576) != 0 ? seriesData.episode : list4, (i2 & 2097152) != 0 ? seriesData.language : list5, (i2 & 4194304) != 0 ? seriesData.boxType : num24, (i2 & 8388608) != 0 ? seriesData.yearYear : str26, (i2 & 16777216) != 0 ? seriesData.seasonEpisode : str27);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component10, reason: from getter */
        public final String getActors() {
            return this.actors;
        }

        @Nullable
        /* JADX INFO: renamed from: component11, reason: from getter */
        public final Integer getAddTime() {
            return this.addTime;
        }

        @Nullable
        /* JADX INFO: renamed from: component12, reason: from getter */
        public final String getPoster() {
            return this.poster;
        }

        @Nullable
        /* JADX INFO: renamed from: component13, reason: from getter */
        public final Integer getPosterImdb() {
            return this.posterImdb;
        }

        @Nullable
        /* JADX INFO: renamed from: component14, reason: from getter */
        public final String getBannerMini() {
            return this.bannerMini;
        }

        @Nullable
        /* JADX INFO: renamed from: component15, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        /* JADX INFO: renamed from: component16, reason: from getter */
        public final String getImdbId() {
            return this.imdbId;
        }

        @Nullable
        /* JADX INFO: renamed from: component17, reason: from getter */
        public final String getCats() {
            return this.cats;
        }

        @Nullable
        /* JADX INFO: renamed from: component18, reason: from getter */
        public final Integer getYear() {
            return this.year;
        }

        @Nullable
        /* JADX INFO: renamed from: component19, reason: from getter */
        public final Integer getCollect() {
            return this.collect;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getMbId() {
            return this.mbId;
        }

        @Nullable
        /* JADX INFO: renamed from: component20, reason: from getter */
        public final Integer getView() {
            return this.view;
        }

        @Nullable
        /* JADX INFO: renamed from: component21, reason: from getter */
        public final Integer getDownload() {
            return this.download;
        }

        @Nullable
        /* JADX INFO: renamed from: component22, reason: from getter */
        public final String getUpdateTime() {
            return this.updateTime;
        }

        @Nullable
        /* JADX INFO: renamed from: component23, reason: from getter */
        public final String getReleased() {
            return this.released;
        }

        @Nullable
        /* JADX INFO: renamed from: component24, reason: from getter */
        public final Integer getReleasedTimestamp() {
            return this.releasedTimestamp;
        }

        @Nullable
        /* JADX INFO: renamed from: component25, reason: from getter */
        public final String getEpisodeReleased() {
            return this.episodeReleased;
        }

        @Nullable
        /* JADX INFO: renamed from: component26, reason: from getter */
        public final Integer getEpisodeReleasedTimestamp() {
            return this.episodeReleasedTimestamp;
        }

        @Nullable
        /* JADX INFO: renamed from: component27, reason: from getter */
        public final Integer getMaxSeason() {
            return this.maxSeason;
        }

        @Nullable
        /* JADX INFO: renamed from: component28, reason: from getter */
        public final Integer getMaxEpisode() {
            return this.maxEpisode;
        }

        @Nullable
        /* JADX INFO: renamed from: component29, reason: from getter */
        public final String getRemark() {
            return this.remark;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component30, reason: from getter */
        public final String getImdbRating() {
            return this.imdbRating;
        }

        @Nullable
        /* JADX INFO: renamed from: component31, reason: from getter */
        public final String getContentRating() {
            return this.contentRating;
        }

        @Nullable
        /* JADX INFO: renamed from: component32, reason: from getter */
        public final Integer getTmdbId() {
            return this.tmdbId;
        }

        @Nullable
        /* JADX INFO: renamed from: component33, reason: from getter */
        public final String getTomatoUrl() {
            return this.tomatoUrl;
        }

        @Nullable
        /* JADX INFO: renamed from: component34, reason: from getter */
        public final Integer getTomatoMeter() {
            return this.tomatoMeter;
        }

        @Nullable
        /* JADX INFO: renamed from: component35, reason: from getter */
        public final Integer getTomatoMeterCount() {
            return this.tomatoMeterCount;
        }

        @Nullable
        /* JADX INFO: renamed from: component36, reason: from getter */
        public final String getTomatoMeterState() {
            return this.tomatoMeterState;
        }

        @Nullable
        /* JADX INFO: renamed from: component37, reason: from getter */
        public final String getReelgoodUrl() {
            return this.reelgoodUrl;
        }

        @Nullable
        /* JADX INFO: renamed from: component38, reason: from getter */
        public final Integer getAudienceScore() {
            return this.audienceScore;
        }

        @Nullable
        /* JADX INFO: renamed from: component39, reason: from getter */
        public final Integer getAudienceScoreCount() {
            return this.audienceScoreCount;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Integer getDisplay() {
            return this.display;
        }

        @Nullable
        /* JADX INFO: renamed from: component40, reason: from getter */
        public final Integer getNoTomatoUrl() {
            return this.noTomatoUrl;
        }

        @Nullable
        /* JADX INFO: renamed from: component41, reason: from getter */
        public final Integer getOrderYear() {
            return this.orderYear;
        }

        @Nullable
        /* JADX INFO: renamed from: component42, reason: from getter */
        public final String getEpisodateId() {
            return this.episodateId;
        }

        @Nullable
        /* JADX INFO: renamed from: component43, reason: from getter */
        public final Double getWeightsDay() {
            return this.weightsDay;
        }

        @Nullable
        /* JADX INFO: renamed from: component44, reason: from getter */
        public final String getPosterMin() {
            return this.posterMin;
        }

        @Nullable
        /* JADX INFO: renamed from: component45, reason: from getter */
        public final String getPosterOrg() {
            return this.posterOrg;
        }

        @Nullable
        /* JADX INFO: renamed from: component46, reason: from getter */
        public final String getBannerMiniMin() {
            return this.bannerMiniMin;
        }

        @Nullable
        /* JADX INFO: renamed from: component47, reason: from getter */
        public final String getBannerMiniOrg() {
            return this.bannerMiniOrg;
        }

        @Nullable
        /* JADX INFO: renamed from: component48, reason: from getter */
        public final String getTrailerUrl() {
            return this.trailerUrl;
        }

        @NotNull
        public final List<Integer> component49() {
            return this.years;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Integer getState() {
            return this.state;
        }

        @NotNull
        public final List<Integer> component50() {
            return this.season;
        }

        @NotNull
        public final List<String> component51() {
            return this.history;
        }

        @Nullable
        /* JADX INFO: renamed from: component52, reason: from getter */
        public final String getImdbLink() {
            return this.imdbLink;
        }

        @NotNull
        public final List<SeriesEpisode> component53() {
            return this.episode;
        }

        @NotNull
        public final List<SeriesLanguage> component54() {
            return this.language;
        }

        @Nullable
        /* JADX INFO: renamed from: component55, reason: from getter */
        public final Integer getBoxType() {
            return this.boxType;
        }

        @Nullable
        /* JADX INFO: renamed from: component56, reason: from getter */
        public final String getYearYear() {
            return this.yearYear;
        }

        @Nullable
        /* JADX INFO: renamed from: component57, reason: from getter */
        public final String getSeasonEpisode() {
            return this.seasonEpisode;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Integer getVipOnly() {
            return this.vipOnly;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Integer getCodeFile() {
            return this.codeFile;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getDirector() {
            return this.director;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getWriter() {
            return this.writer;
        }

        @NotNull
        public final SeriesData copy(@Nullable Integer id, @Nullable Integer mbId, @Nullable String title, @Nullable Integer display, @Nullable Integer state, @Nullable Integer vipOnly, @Nullable Integer codeFile, @Nullable String director, @Nullable String writer, @Nullable String actors, @Nullable Integer addTime, @Nullable String poster, @Nullable Integer posterImdb, @Nullable String bannerMini, @Nullable String description, @Nullable String imdbId, @Nullable String cats, @Nullable Integer year, @Nullable Integer collect, @Nullable Integer view, @Nullable Integer download, @Nullable String updateTime, @Nullable String released, @Nullable Integer releasedTimestamp, @Nullable String episodeReleased, @Nullable Integer episodeReleasedTimestamp, @Nullable Integer maxSeason, @Nullable Integer maxEpisode, @Nullable String remark, @Nullable String imdbRating, @Nullable String contentRating, @Nullable Integer tmdbId, @Nullable String tomatoUrl, @Nullable Integer tomatoMeter, @Nullable Integer tomatoMeterCount, @Nullable String tomatoMeterState, @Nullable String reelgoodUrl, @Nullable Integer audienceScore, @Nullable Integer audienceScoreCount, @Nullable Integer noTomatoUrl, @Nullable Integer orderYear, @Nullable String episodateId, @Nullable Double weightsDay, @Nullable String posterMin, @Nullable String posterOrg, @Nullable String bannerMiniMin, @Nullable String bannerMiniOrg, @Nullable String trailerUrl, @NotNull List<Integer> years, @NotNull List<Integer> season, @NotNull List<String> history, @Nullable String imdbLink, @NotNull List<SeriesEpisode> episode, @NotNull List<SeriesLanguage> language, @Nullable Integer boxType, @Nullable String yearYear, @Nullable String seasonEpisode) {
            return new SeriesData(id, mbId, title, display, state, vipOnly, codeFile, director, writer, actors, addTime, poster, posterImdb, bannerMini, description, imdbId, cats, year, collect, view, download, updateTime, released, releasedTimestamp, episodeReleased, episodeReleasedTimestamp, maxSeason, maxEpisode, remark, imdbRating, contentRating, tmdbId, tomatoUrl, tomatoMeter, tomatoMeterCount, tomatoMeterState, reelgoodUrl, audienceScore, audienceScoreCount, noTomatoUrl, orderYear, episodateId, weightsDay, posterMin, posterOrg, bannerMiniMin, bannerMiniOrg, trailerUrl, years, season, history, imdbLink, episode, language, boxType, yearYear, seasonEpisode);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SeriesData)) {
                return false;
            }
            SeriesData seriesData = (SeriesData) other;
            return Intrinsics.areEqual(this.id, seriesData.id) && Intrinsics.areEqual(this.mbId, seriesData.mbId) && Intrinsics.areEqual(this.title, seriesData.title) && Intrinsics.areEqual(this.display, seriesData.display) && Intrinsics.areEqual(this.state, seriesData.state) && Intrinsics.areEqual(this.vipOnly, seriesData.vipOnly) && Intrinsics.areEqual(this.codeFile, seriesData.codeFile) && Intrinsics.areEqual(this.director, seriesData.director) && Intrinsics.areEqual(this.writer, seriesData.writer) && Intrinsics.areEqual(this.actors, seriesData.actors) && Intrinsics.areEqual(this.addTime, seriesData.addTime) && Intrinsics.areEqual(this.poster, seriesData.poster) && Intrinsics.areEqual(this.posterImdb, seriesData.posterImdb) && Intrinsics.areEqual(this.bannerMini, seriesData.bannerMini) && Intrinsics.areEqual(this.description, seriesData.description) && Intrinsics.areEqual(this.imdbId, seriesData.imdbId) && Intrinsics.areEqual(this.cats, seriesData.cats) && Intrinsics.areEqual(this.year, seriesData.year) && Intrinsics.areEqual(this.collect, seriesData.collect) && Intrinsics.areEqual(this.view, seriesData.view) && Intrinsics.areEqual(this.download, seriesData.download) && Intrinsics.areEqual(this.updateTime, seriesData.updateTime) && Intrinsics.areEqual(this.released, seriesData.released) && Intrinsics.areEqual(this.releasedTimestamp, seriesData.releasedTimestamp) && Intrinsics.areEqual(this.episodeReleased, seriesData.episodeReleased) && Intrinsics.areEqual(this.episodeReleasedTimestamp, seriesData.episodeReleasedTimestamp) && Intrinsics.areEqual(this.maxSeason, seriesData.maxSeason) && Intrinsics.areEqual(this.maxEpisode, seriesData.maxEpisode) && Intrinsics.areEqual(this.remark, seriesData.remark) && Intrinsics.areEqual(this.imdbRating, seriesData.imdbRating) && Intrinsics.areEqual(this.contentRating, seriesData.contentRating) && Intrinsics.areEqual(this.tmdbId, seriesData.tmdbId) && Intrinsics.areEqual(this.tomatoUrl, seriesData.tomatoUrl) && Intrinsics.areEqual(this.tomatoMeter, seriesData.tomatoMeter) && Intrinsics.areEqual(this.tomatoMeterCount, seriesData.tomatoMeterCount) && Intrinsics.areEqual(this.tomatoMeterState, seriesData.tomatoMeterState) && Intrinsics.areEqual(this.reelgoodUrl, seriesData.reelgoodUrl) && Intrinsics.areEqual(this.audienceScore, seriesData.audienceScore) && Intrinsics.areEqual(this.audienceScoreCount, seriesData.audienceScoreCount) && Intrinsics.areEqual(this.noTomatoUrl, seriesData.noTomatoUrl) && Intrinsics.areEqual(this.orderYear, seriesData.orderYear) && Intrinsics.areEqual(this.episodateId, seriesData.episodateId) && Intrinsics.areEqual(this.weightsDay, seriesData.weightsDay) && Intrinsics.areEqual(this.posterMin, seriesData.posterMin) && Intrinsics.areEqual(this.posterOrg, seriesData.posterOrg) && Intrinsics.areEqual(this.bannerMiniMin, seriesData.bannerMiniMin) && Intrinsics.areEqual(this.bannerMiniOrg, seriesData.bannerMiniOrg) && Intrinsics.areEqual(this.trailerUrl, seriesData.trailerUrl) && Intrinsics.areEqual(this.years, seriesData.years) && Intrinsics.areEqual(this.season, seriesData.season) && Intrinsics.areEqual(this.history, seriesData.history) && Intrinsics.areEqual(this.imdbLink, seriesData.imdbLink) && Intrinsics.areEqual(this.episode, seriesData.episode) && Intrinsics.areEqual(this.language, seriesData.language) && Intrinsics.areEqual(this.boxType, seriesData.boxType) && Intrinsics.areEqual(this.yearYear, seriesData.yearYear) && Intrinsics.areEqual(this.seasonEpisode, seriesData.seasonEpisode);
        }

        public int hashCode() {
            return ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.mbId == null ? 0 : this.mbId.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.display == null ? 0 : this.display.hashCode())) * 31) + (this.state == null ? 0 : this.state.hashCode())) * 31) + (this.vipOnly == null ? 0 : this.vipOnly.hashCode())) * 31) + (this.codeFile == null ? 0 : this.codeFile.hashCode())) * 31) + (this.director == null ? 0 : this.director.hashCode())) * 31) + (this.writer == null ? 0 : this.writer.hashCode())) * 31) + (this.actors == null ? 0 : this.actors.hashCode())) * 31) + (this.addTime == null ? 0 : this.addTime.hashCode())) * 31) + (this.poster == null ? 0 : this.poster.hashCode())) * 31) + (this.posterImdb == null ? 0 : this.posterImdb.hashCode())) * 31) + (this.bannerMini == null ? 0 : this.bannerMini.hashCode())) * 31) + (this.description == null ? 0 : this.description.hashCode())) * 31) + (this.imdbId == null ? 0 : this.imdbId.hashCode())) * 31) + (this.cats == null ? 0 : this.cats.hashCode())) * 31) + (this.year == null ? 0 : this.year.hashCode())) * 31) + (this.collect == null ? 0 : this.collect.hashCode())) * 31) + (this.view == null ? 0 : this.view.hashCode())) * 31) + (this.download == null ? 0 : this.download.hashCode())) * 31) + (this.updateTime == null ? 0 : this.updateTime.hashCode())) * 31) + (this.released == null ? 0 : this.released.hashCode())) * 31) + (this.releasedTimestamp == null ? 0 : this.releasedTimestamp.hashCode())) * 31) + (this.episodeReleased == null ? 0 : this.episodeReleased.hashCode())) * 31) + (this.episodeReleasedTimestamp == null ? 0 : this.episodeReleasedTimestamp.hashCode())) * 31) + (this.maxSeason == null ? 0 : this.maxSeason.hashCode())) * 31) + (this.maxEpisode == null ? 0 : this.maxEpisode.hashCode())) * 31) + (this.remark == null ? 0 : this.remark.hashCode())) * 31) + (this.imdbRating == null ? 0 : this.imdbRating.hashCode())) * 31) + (this.contentRating == null ? 0 : this.contentRating.hashCode())) * 31) + (this.tmdbId == null ? 0 : this.tmdbId.hashCode())) * 31) + (this.tomatoUrl == null ? 0 : this.tomatoUrl.hashCode())) * 31) + (this.tomatoMeter == null ? 0 : this.tomatoMeter.hashCode())) * 31) + (this.tomatoMeterCount == null ? 0 : this.tomatoMeterCount.hashCode())) * 31) + (this.tomatoMeterState == null ? 0 : this.tomatoMeterState.hashCode())) * 31) + (this.reelgoodUrl == null ? 0 : this.reelgoodUrl.hashCode())) * 31) + (this.audienceScore == null ? 0 : this.audienceScore.hashCode())) * 31) + (this.audienceScoreCount == null ? 0 : this.audienceScoreCount.hashCode())) * 31) + (this.noTomatoUrl == null ? 0 : this.noTomatoUrl.hashCode())) * 31) + (this.orderYear == null ? 0 : this.orderYear.hashCode())) * 31) + (this.episodateId == null ? 0 : this.episodateId.hashCode())) * 31) + (this.weightsDay == null ? 0 : this.weightsDay.hashCode())) * 31) + (this.posterMin == null ? 0 : this.posterMin.hashCode())) * 31) + (this.posterOrg == null ? 0 : this.posterOrg.hashCode())) * 31) + (this.bannerMiniMin == null ? 0 : this.bannerMiniMin.hashCode())) * 31) + (this.bannerMiniOrg == null ? 0 : this.bannerMiniOrg.hashCode())) * 31) + (this.trailerUrl == null ? 0 : this.trailerUrl.hashCode())) * 31) + this.years.hashCode()) * 31) + this.season.hashCode()) * 31) + this.history.hashCode()) * 31) + (this.imdbLink == null ? 0 : this.imdbLink.hashCode())) * 31) + this.episode.hashCode()) * 31) + this.language.hashCode()) * 31) + (this.boxType == null ? 0 : this.boxType.hashCode())) * 31) + (this.yearYear == null ? 0 : this.yearYear.hashCode())) * 31) + (this.seasonEpisode != null ? this.seasonEpisode.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("SeriesData(id=").append(this.id).append(", mbId=").append(this.mbId).append(", title=").append(this.title).append(", display=").append(this.display).append(", state=").append(this.state).append(", vipOnly=").append(this.vipOnly).append(", codeFile=").append(this.codeFile).append(", director=").append(this.director).append(", writer=").append(this.writer).append(", actors=").append(this.actors).append(", addTime=").append(this.addTime).append(", poster=");
            sb.append(this.poster).append(", posterImdb=").append(this.posterImdb).append(", bannerMini=").append(this.bannerMini).append(", description=").append(this.description).append(", imdbId=").append(this.imdbId).append(", cats=").append(this.cats).append(", year=").append(this.year).append(", collect=").append(this.collect).append(", view=").append(this.view).append(", download=").append(this.download).append(", updateTime=").append(this.updateTime).append(", released=").append(this.released);
            sb.append(", releasedTimestamp=").append(this.releasedTimestamp).append(", episodeReleased=").append(this.episodeReleased).append(", episodeReleasedTimestamp=").append(this.episodeReleasedTimestamp).append(", maxSeason=").append(this.maxSeason).append(", maxEpisode=").append(this.maxEpisode).append(", remark=").append(this.remark).append(", imdbRating=").append(this.imdbRating).append(", contentRating=").append(this.contentRating).append(", tmdbId=").append(this.tmdbId).append(", tomatoUrl=").append(this.tomatoUrl).append(", tomatoMeter=").append(this.tomatoMeter).append(", tomatoMeterCount=");
            sb.append(this.tomatoMeterCount).append(", tomatoMeterState=").append(this.tomatoMeterState).append(", reelgoodUrl=").append(this.reelgoodUrl).append(", audienceScore=").append(this.audienceScore).append(", audienceScoreCount=").append(this.audienceScoreCount).append(", noTomatoUrl=").append(this.noTomatoUrl).append(", orderYear=").append(this.orderYear).append(", episodateId=").append(this.episodateId).append(", weightsDay=").append(this.weightsDay).append(", posterMin=").append(this.posterMin).append(", posterOrg=").append(this.posterOrg).append(", bannerMiniMin=").append(this.bannerMiniMin);
            sb.append(", bannerMiniOrg=").append(this.bannerMiniOrg).append(", trailerUrl=").append(this.trailerUrl).append(", years=").append(this.years).append(", season=").append(this.season).append(", history=").append(this.history).append(", imdbLink=").append(this.imdbLink).append(", episode=").append(this.episode).append(", language=").append(this.language).append(", boxType=").append(this.boxType).append(", yearYear=").append(this.yearYear).append(", seasonEpisode=").append(this.seasonEpisode).append(')');
            return sb.toString();
        }

        public SeriesData(@Nullable Integer id, @Nullable Integer mbId, @Nullable String title, @Nullable Integer display, @Nullable Integer state, @Nullable Integer vipOnly, @Nullable Integer codeFile, @Nullable String director, @Nullable String writer, @Nullable String actors, @Nullable Integer addTime, @Nullable String poster, @Nullable Integer posterImdb, @Nullable String bannerMini, @Nullable String description, @Nullable String imdbId, @Nullable String cats, @Nullable Integer year, @Nullable Integer collect, @Nullable Integer view, @Nullable Integer download, @Nullable String updateTime, @Nullable String released, @Nullable Integer releasedTimestamp, @Nullable String episodeReleased, @Nullable Integer episodeReleasedTimestamp, @Nullable Integer maxSeason, @Nullable Integer maxEpisode, @Nullable String remark, @Nullable String imdbRating, @Nullable String contentRating, @Nullable Integer tmdbId, @Nullable String tomatoUrl, @Nullable Integer tomatoMeter, @Nullable Integer tomatoMeterCount, @Nullable String tomatoMeterState, @Nullable String reelgoodUrl, @Nullable Integer audienceScore, @Nullable Integer audienceScoreCount, @Nullable Integer noTomatoUrl, @Nullable Integer orderYear, @Nullable String episodateId, @Nullable Double weightsDay, @Nullable String posterMin, @Nullable String posterOrg, @Nullable String bannerMiniMin, @Nullable String bannerMiniOrg, @Nullable String trailerUrl, @NotNull List<Integer> list, @NotNull List<Integer> list2, @NotNull List<String> list3, @Nullable String imdbLink, @NotNull List<SeriesEpisode> list4, @NotNull List<SeriesLanguage> list5, @Nullable Integer boxType, @Nullable String yearYear, @Nullable String seasonEpisode) {
            this.id = id;
            this.mbId = mbId;
            this.title = title;
            this.display = display;
            this.state = state;
            this.vipOnly = vipOnly;
            this.codeFile = codeFile;
            this.director = director;
            this.writer = writer;
            this.actors = actors;
            this.addTime = addTime;
            this.poster = poster;
            this.posterImdb = posterImdb;
            this.bannerMini = bannerMini;
            this.description = description;
            this.imdbId = imdbId;
            this.cats = cats;
            this.year = year;
            this.collect = collect;
            this.view = view;
            this.download = download;
            this.updateTime = updateTime;
            this.released = released;
            this.releasedTimestamp = releasedTimestamp;
            this.episodeReleased = episodeReleased;
            this.episodeReleasedTimestamp = episodeReleasedTimestamp;
            this.maxSeason = maxSeason;
            this.maxEpisode = maxEpisode;
            this.remark = remark;
            this.imdbRating = imdbRating;
            this.contentRating = contentRating;
            this.tmdbId = tmdbId;
            this.tomatoUrl = tomatoUrl;
            this.tomatoMeter = tomatoMeter;
            this.tomatoMeterCount = tomatoMeterCount;
            this.tomatoMeterState = tomatoMeterState;
            this.reelgoodUrl = reelgoodUrl;
            this.audienceScore = audienceScore;
            this.audienceScoreCount = audienceScoreCount;
            this.noTomatoUrl = noTomatoUrl;
            this.orderYear = orderYear;
            this.episodateId = episodateId;
            this.weightsDay = weightsDay;
            this.posterMin = posterMin;
            this.posterOrg = posterOrg;
            this.bannerMiniMin = bannerMiniMin;
            this.bannerMiniOrg = bannerMiniOrg;
            this.trailerUrl = trailerUrl;
            this.years = list;
            this.season = list2;
            this.history = list3;
            this.imdbLink = imdbLink;
            this.episode = list4;
            this.language = list5;
            this.boxType = boxType;
            this.yearYear = yearYear;
            this.seasonEpisode = seasonEpisode;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ SeriesData(Integer num, Integer num2, String str, Integer num3, Integer num4, Integer num5, Integer num6, String str2, String str3, String str4, Integer num7, String str5, Integer num8, String str6, String str7, String str8, String str9, Integer num9, Integer num10, Integer num11, Integer num12, String str10, String str11, Integer num13, String str12, Integer num14, Integer num15, Integer num16, String str13, String str14, String str15, Integer num17, String str16, Integer num18, Integer num19, String str17, String str18, Integer num20, Integer num21, Integer num22, Integer num23, String str19, Double d, String str20, String str21, String str22, String str23, String str24, List list, List list2, List list3, String str25, List list4, List list5, Integer num24, String str26, String str27, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            Integer num25 = (i & 1) != 0 ? null : num;
            Integer num26 = (i & 2) != 0 ? null : num2;
            String str28 = (i & 4) != 0 ? null : str;
            Integer num27 = (i & 8) != 0 ? null : num3;
            Integer num28 = (i & 16) != 0 ? null : num4;
            Integer num29 = (i & 32) != 0 ? null : num5;
            Integer num30 = (i & 64) != 0 ? null : num6;
            String str29 = (i & 128) != 0 ? null : str2;
            String str30 = (i & 256) != 0 ? null : str3;
            String str31 = (i & 512) != 0 ? null : str4;
            Integer num31 = (i & 1024) != 0 ? null : num7;
            String str32 = (i & 2048) != 0 ? null : str5;
            Integer num32 = (i & 4096) != 0 ? null : num8;
            String str33 = (i & 8192) != 0 ? null : str6;
            Integer num33 = num25;
            String str34 = (i & 16384) != 0 ? null : str7;
            String str35 = (i & 32768) != 0 ? null : str8;
            String str36 = (i & 65536) != 0 ? null : str9;
            Integer num34 = (i & 131072) != 0 ? null : num9;
            Integer num35 = (i & 262144) != 0 ? null : num10;
            Integer num36 = (i & 524288) != 0 ? null : num11;
            Integer num37 = (i & 1048576) != 0 ? null : num12;
            String str37 = (i & 2097152) != 0 ? null : str10;
            String str38 = (i & 4194304) != 0 ? null : str11;
            Integer num38 = (i & 8388608) != 0 ? null : num13;
            String str39 = (i & 16777216) != 0 ? null : str12;
            Integer num39 = (i & 33554432) != 0 ? null : num14;
            Integer num40 = (i & 67108864) != 0 ? null : num15;
            Integer num41 = (i & 134217728) != 0 ? null : num16;
            String str40 = (i & 268435456) != 0 ? null : str13;
            String str41 = (i & 536870912) != 0 ? null : str14;
            String str42 = (i & 1073741824) != 0 ? null : str15;
            Integer num42 = (i & Integer.MIN_VALUE) != 0 ? null : num17;
            String str43 = (i2 & 1) != 0 ? null : str16;
            Integer num43 = (i2 & 2) != 0 ? null : num18;
            Integer num44 = (i2 & 4) != 0 ? null : num19;
            String str44 = (i2 & 8) != 0 ? null : str17;
            String str45 = (i2 & 16) != 0 ? null : str18;
            Integer num45 = (i2 & 32) != 0 ? null : num20;
            Integer num46 = (i2 & 64) != 0 ? null : num21;
            Integer num47 = num42;
            Integer num48 = (i2 & 128) != 0 ? null : num22;
            Integer num49 = num26;
            String str46 = str28;
            Integer num50 = num27;
            Integer num51 = num28;
            Integer num52 = num29;
            Integer num53 = num30;
            String str47 = str29;
            String str48 = str30;
            String str49 = str31;
            Integer num54 = num31;
            String str50 = str32;
            Integer num55 = num32;
            this(num33, num49, str46, num50, num51, num52, num53, str47, str48, str49, num54, str50, num55, str33, str34, str35, str36, num34, num35, num36, num37, str37, str38, num38, str39, num39, num40, num41, str40, str41, str42, num47, str43, num43, num44, str44, str45, num45, num46, num48, (i2 & 256) != 0 ? null : num23, (i2 & 512) != 0 ? null : str19, (i2 & 1024) != 0 ? null : d, (i2 & 2048) != 0 ? null : str20, (i2 & 4096) != 0 ? null : str21, (i2 & 8192) != 0 ? null : str22, (i2 & 16384) != 0 ? null : str23, (i2 & 32768) != 0 ? null : str24, (i2 & 65536) != 0 ? CollectionsKt.emptyList() : list, (i2 & 131072) != 0 ? CollectionsKt.emptyList() : list2, (i2 & 262144) != 0 ? CollectionsKt.emptyList() : list3, (i2 & 524288) != 0 ? null : str25, (i2 & 1048576) != 0 ? CollectionsKt.emptyList() : list4, (i2 & 2097152) != 0 ? CollectionsKt.emptyList() : list5, (i2 & 4194304) != 0 ? null : num24, (i2 & 8388608) != 0 ? null : str26, (i2 & 16777216) != 0 ? null : str27);
        }

        @Nullable
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        public final Integer getMbId() {
            return this.mbId;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final Integer getDisplay() {
            return this.display;
        }

        @Nullable
        public final Integer getState() {
            return this.state;
        }

        @Nullable
        public final Integer getVipOnly() {
            return this.vipOnly;
        }

        @Nullable
        public final Integer getCodeFile() {
            return this.codeFile;
        }

        @Nullable
        public final String getDirector() {
            return this.director;
        }

        @Nullable
        public final String getWriter() {
            return this.writer;
        }

        @Nullable
        public final String getActors() {
            return this.actors;
        }

        @Nullable
        public final Integer getAddTime() {
            return this.addTime;
        }

        @Nullable
        public final String getPoster() {
            return this.poster;
        }

        @Nullable
        public final Integer getPosterImdb() {
            return this.posterImdb;
        }

        @Nullable
        public final String getBannerMini() {
            return this.bannerMini;
        }

        @Nullable
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        public final String getImdbId() {
            return this.imdbId;
        }

        @Nullable
        public final String getCats() {
            return this.cats;
        }

        @Nullable
        public final Integer getYear() {
            return this.year;
        }

        @Nullable
        public final Integer getCollect() {
            return this.collect;
        }

        @Nullable
        public final Integer getView() {
            return this.view;
        }

        @Nullable
        public final Integer getDownload() {
            return this.download;
        }

        @Nullable
        public final String getUpdateTime() {
            return this.updateTime;
        }

        @Nullable
        public final String getReleased() {
            return this.released;
        }

        @Nullable
        public final Integer getReleasedTimestamp() {
            return this.releasedTimestamp;
        }

        @Nullable
        public final String getEpisodeReleased() {
            return this.episodeReleased;
        }

        @Nullable
        public final Integer getEpisodeReleasedTimestamp() {
            return this.episodeReleasedTimestamp;
        }

        @Nullable
        public final Integer getMaxSeason() {
            return this.maxSeason;
        }

        @Nullable
        public final Integer getMaxEpisode() {
            return this.maxEpisode;
        }

        @Nullable
        public final String getRemark() {
            return this.remark;
        }

        @Nullable
        public final String getImdbRating() {
            return this.imdbRating;
        }

        @Nullable
        public final String getContentRating() {
            return this.contentRating;
        }

        @Nullable
        public final Integer getTmdbId() {
            return this.tmdbId;
        }

        @Nullable
        public final String getTomatoUrl() {
            return this.tomatoUrl;
        }

        @Nullable
        public final Integer getTomatoMeter() {
            return this.tomatoMeter;
        }

        @Nullable
        public final Integer getTomatoMeterCount() {
            return this.tomatoMeterCount;
        }

        @Nullable
        public final String getTomatoMeterState() {
            return this.tomatoMeterState;
        }

        @Nullable
        public final String getReelgoodUrl() {
            return this.reelgoodUrl;
        }

        @Nullable
        public final Integer getAudienceScore() {
            return this.audienceScore;
        }

        @Nullable
        public final Integer getAudienceScoreCount() {
            return this.audienceScoreCount;
        }

        @Nullable
        public final Integer getNoTomatoUrl() {
            return this.noTomatoUrl;
        }

        @Nullable
        public final Integer getOrderYear() {
            return this.orderYear;
        }

        @Nullable
        public final String getEpisodateId() {
            return this.episodateId;
        }

        @Nullable
        public final Double getWeightsDay() {
            return this.weightsDay;
        }

        @Nullable
        public final String getPosterMin() {
            return this.posterMin;
        }

        @Nullable
        public final String getPosterOrg() {
            return this.posterOrg;
        }

        @Nullable
        public final String getBannerMiniMin() {
            return this.bannerMiniMin;
        }

        @Nullable
        public final String getBannerMiniOrg() {
            return this.bannerMiniOrg;
        }

        @Nullable
        public final String getTrailerUrl() {
            return this.trailerUrl;
        }

        @NotNull
        public final List<Integer> getYears() {
            return this.years;
        }

        @NotNull
        public final List<Integer> getSeason() {
            return this.season;
        }

        @NotNull
        public final List<String> getHistory() {
            return this.history;
        }

        @Nullable
        public final String getImdbLink() {
            return this.imdbLink;
        }

        @NotNull
        public final List<SeriesEpisode> getEpisode() {
            return this.episode;
        }

        @NotNull
        public final List<SeriesLanguage> getLanguage() {
            return this.language;
        }

        @Nullable
        public final Integer getBoxType() {
            return this.boxType;
        }

        @Nullable
        public final String getYearYear() {
            return this.yearYear;
        }

        @Nullable
        public final String getSeasonEpisode() {
            return this.seasonEpisode;
        }
    }

    /* JADX WARN: Code duplicated, block: B:119:0x047d  */
    /* JADX WARN: Code duplicated, block: B:120:0x0482  */
    /* JADX WARN: Code duplicated, block: B:123:0x0488  */
    /* JADX WARN: Code duplicated, block: B:124:0x048d  */
    /* JADX WARN: Code duplicated, block: B:127:0x04a5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:128:0x04a6  */
    /* JADX WARN: Code duplicated, block: B:131:0x04e3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:132:0x04e4  */
    /* JADX WARN: Code duplicated, block: B:135:0x04fa  */
    /* JADX WARN: Code duplicated, block: B:136:0x04fd  */
    /* JADX WARN: Code duplicated, block: B:139:0x0540 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:140:0x0541  */
    /* JADX WARN: Code duplicated, block: B:67:0x02c3  */
    /* JADX WARN: Code duplicated, block: B:69:0x02e2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:70:0x02e3  */
    /* JADX WARN: Code duplicated, block: B:73:0x02eb  */
    /* JADX WARN: Code duplicated, block: B:74:0x02f0  */
    /* JADX WARN: Code duplicated, block: B:77:0x02f6  */
    /* JADX WARN: Code duplicated, block: B:78:0x02fb  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:81:0x0317 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:82:0x0318  */
    /* JADX WARN: Code duplicated, block: B:86:0x032b  */
    /* JADX WARN: Code duplicated, block: B:89:0x0339  */
    /* JADX WARN: Code duplicated, block: B:91:0x0397 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:92:0x0398  */
    /* JADX WARN: Code duplicated, block: B:94:0x03a1  */
    /* JADX WARN: Code duplicated, block: B:96:0x03ac  */
    /* JADX WARN: Type inference failed for: r0v18, types: [java.lang.Throwable] */
    static /* synthetic */ Object load$suspendImpl(ShowBox showBox, String str, Continuation<? super LoadResponse> continuation) {
        C00001 c00001;
        Object obj;
        Object objDecodeFromString;
        int i;
        Object objFromJson;
        Object objLoad$fetchCinemeta;
        SeriesData seriesData;
        LoadData loadData;
        int i2;
        LoadData loadData2;
        boolean z;
        Object objFromJson2;
        MovieData data;
        Object objLoad$fetchCinemeta2;
        MovieData movieData;
        int i3;
        LoadData loadData3;
        ResponseData responseData;
        Meta meta;
        Meta meta2;
        Integer moviedb_id;
        Object objLoad$fetchLogo;
        String str2;
        MovieData movieData2;
        LoadData loadData4;
        int i4;
        ShowBox showBox2;
        String str3;
        ShowBox showBox3;
        String title;
        String str4;
        TvType tvType;
        Integer id;
        Object objNewMovieLoadResponse;
        ResponseData responseData2;
        Meta meta3;
        Meta meta4;
        Integer moviedb_id2;
        Object objLoad$fetchLogo2;
        int i5;
        ShowBox showBox4;
        SeriesData seriesData2;
        LoadData loadData5;
        String str5;
        ShowBox showBox5;
        int i6;
        SeriesData seriesData3;
        Object objAmap;
        String str6;
        int i7;
        Meta meta5;
        SeriesData seriesData4;
        String str7;
        int i8;
        String title2;
        String str8;
        Object objNewTvSeriesLoadResponse;
        ShowBox showBox6 = showBox;
        String str9 = str;
        if (continuation instanceof C00001) {
            c00001 = (C00001) continuation;
            if ((c00001.label & Integer.MIN_VALUE) != 0) {
                c00001.label -= Integer.MIN_VALUE;
            } else {
                c00001 = showBox6.new C00001(continuation);
            }
        } else {
            c00001 = showBox6.new C00001(continuation);
        }
        C00001 c00002 = c00001;
        Object obj2 = c00002.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        String str10 = "";
        switch (c00002.label) {
            case 0:
                ResultKt.throwOnFailure(obj2);
                AppUtils appUtils = AppUtils.INSTANCE;
                try {
                    Result.Companion companion = Result.Companion;
                    KType kTypeTypeOf = Reflection.typeOf(LoadData.class);
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                    break;
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                if (Result.exceptionOrNull-impl(obj) != null) {
                    try {
                        Result.Companion companion3 = Result.Companion;
                        obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(LoadData.class), (List) null, 2, (Object) null));
                    } catch (Throwable th2) {
                        Result.Companion companion4 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th2));
                    }
                    break;
                }
                if (Result.isFailure-impl(obj)) {
                    obj = null;
                }
                DeserializationStrategy deserializationStrategy = (KSerializer) obj;
                if (deserializationStrategy != null) {
                    try {
                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, str);
                    } catch (SerializationException e) {
                        ArchComponentExtKt.logError(e);
                        objDecodeFromString = MainAPIKt.getMapper().readValue(str, new TypeReference<LoadData>() { // from class: com.phisher98.ShowBox$load$suspendImpl$$inlined$parseJson$1
                        });
                    } catch (Throwable th3) {
                        objDecodeFromString = MainAPIKt.getMapper().readValue(str, new TypeReference<LoadData>() { // from class: com.phisher98.ShowBox$load$suspendImpl$$inlined$parseJson$1
                        });
                    }
                    break;
                } else {
                    objDecodeFromString = MainAPIKt.getMapper().readValue(str, new TypeReference<LoadData>() { // from class: com.phisher98.ShowBox$load$suspendImpl$$inlined$parseJson$1
                    });
                }
                LoadData loadData6 = (LoadData) objDecodeFromString;
                Integer box_type = loadData6.getBox_type();
                i = (box_type != null && box_type.intValue() == ResponseTypes.Movies.getValue()) ? 1 : 0;
                int i9 = !MainAPI.Companion.getSettingsForProvider().getEnableAdult() ? 1 : 0;
                if (i == 0) {
                    String str11 = "{\"childmode\":\"" + i9 + "\",\"uid\":\"\",\"app_version\":\"" + showBox6.appVersion + "\",\"appid\":\"" + showBox6.appIdSecond + "\",\"module\":\"TV_detail_1\",\"display_all\":\"1\",\"channel\":\"Website\",\"lang\":\"en\",\"expired_date\":\"" + showBox6.getExpiryDate() + "\",\"platform\":\"android\",\"tid\":\"" + loadData6.getId() + "\"}";
                    Gson gson = new Gson();
                    String strQueryApi = showBox.queryApi(str11, false);
                    if (!StringsKt.isBlank(strQueryApi) && !StringsKt.startsWith$default(StringsKt.trim(strQueryApi).toString(), "<", false, 2, (Object) null)) {
                        try {
                            objFromJson = gson.fromJson(strQueryApi, SeriesDataProp.class);
                        } catch (Exception e2) {
                            objFromJson = gson.fromJson(showBox.queryApi(str11, true), SeriesDataProp.class);
                        }
                        break;
                    } else {
                        boolean z2 = true;
                        objFromJson = gson.fromJson(showBox.queryApi(str11, z2), SeriesDataProp.class);
                    }
                    SeriesData data2 = ((SeriesDataProp) objFromJson).getData();
                    if (data2 == null) {
                        throw new RuntimeException("API error");
                    }
                    String imdbId = data2.getImdbId();
                    c00002.L$0 = showBox6;
                    c00002.L$1 = str9;
                    c00002.L$2 = loadData6;
                    c00002.L$3 = data2;
                    c00002.I$0 = i;
                    c00002.I$1 = i9;
                    c00002.label = 4;
                    objLoad$fetchCinemeta = load$fetchCinemeta(showBox6, "series", imdbId, c00002);
                    if (objLoad$fetchCinemeta == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    seriesData = data2;
                    loadData = loadData6;
                    i2 = i9;
                    responseData2 = (ResponseData) objLoad$fetchCinemeta;
                    if (responseData2 != null) {
                        meta3 = responseData2.getMeta();
                    } else {
                        meta3 = null;
                    }
                    meta4 = meta3;
                    TvType tvType2 = TvType.TvSeries;
                    if (meta4 != null) {
                        moviedb_id2 = meta4.getMoviedb_id();
                    } else {
                        moviedb_id2 = null;
                    }
                    c00002.L$0 = showBox6;
                    c00002.L$1 = str9;
                    c00002.L$2 = loadData;
                    c00002.L$3 = seriesData;
                    c00002.L$4 = meta4;
                    c00002.I$0 = i;
                    c00002.I$1 = i2;
                    c00002.label = 5;
                    objLoad$fetchLogo2 = load$fetchLogo(tvType2, moviedb_id2, c00002);
                    if (objLoad$fetchLogo2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    i5 = i2;
                    showBox4 = showBox6;
                    seriesData2 = seriesData;
                    loadData5 = loadData;
                    str5 = (String) objLoad$fetchLogo2;
                    List<Integer> season = seriesData2.getSeason();
                    showBox5 = showBox4;
                    i6 = i5;
                    seriesData3 = seriesData2;
                    ShowBox$load$allEpisodes$1 showBox$load$allEpisodes$1 = new ShowBox$load$allEpisodes$1(showBox4, i5, loadData5, seriesData2, null);
                    c00002.L$0 = showBox5;
                    c00002.L$1 = str9;
                    c00002.L$2 = SpillingKt.nullOutSpilledVariable(loadData5);
                    c00002.L$3 = seriesData3;
                    c00002.L$4 = meta4;
                    c00002.L$5 = str5;
                    c00002.I$0 = i;
                    c00002.I$1 = i6;
                    c00002.label = 6;
                    objAmap = ParCollectionsKt.amap(season, showBox$load$allEpisodes$1, c00002);
                    if (objAmap == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str6 = str5;
                    i7 = i6;
                    meta5 = meta4;
                    seriesData4 = seriesData3;
                    str7 = str9;
                    i8 = i;
                    List listFlatten = CollectionsKt.flatten((Iterable) objAmap);
                    ShowBox showBox7 = showBox5;
                    title2 = seriesData4.getTitle();
                    if (title2 == null) {
                        str8 = str10;
                    } else {
                        str8 = title2;
                    }
                    TvType tvType3 = TvType.TvSeries;
                    C00023 c00023 = new C00023(seriesData4, meta5, str6, null);
                    c00002.L$0 = SpillingKt.nullOutSpilledVariable(showBox5);
                    c00002.L$1 = SpillingKt.nullOutSpilledVariable(str7);
                    c00002.L$2 = SpillingKt.nullOutSpilledVariable(loadData5);
                    c00002.L$3 = SpillingKt.nullOutSpilledVariable(seriesData4);
                    c00002.L$4 = SpillingKt.nullOutSpilledVariable(meta5);
                    c00002.L$5 = SpillingKt.nullOutSpilledVariable(str6);
                    c00002.L$6 = SpillingKt.nullOutSpilledVariable(listFlatten);
                    c00002.I$0 = i8;
                    c00002.I$1 = i7;
                    c00002.label = 7;
                    objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(showBox7, str8, str7, tvType3, listFlatten, c00023, c00002);
                    if (objNewTvSeriesLoadResponse == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return objNewTvSeriesLoadResponse;
                }
                String str12 = "{\"childmode\":\"" + i9 + "\",\"uid\":\"\",\"app_version\":\"" + showBox6.appVersion + "\",\"appid\":\"" + showBox6.appIdSecond + "\",\"module\":\"Movie_detail\",\"channel\":\"Website\",\"mid\":\"" + loadData6.getId() + "\",\"lang\":\"en\",\"expired_date\":\"" + showBox6.getExpiryDate() + "\",\"platform\":\"android\",\"oss\":\"\",\"group\":\"\"}";
                Gson gson2 = new Gson();
                String strQueryApi2 = showBox.queryApi(str12, false);
                if (!StringsKt.isBlank(strQueryApi2)) {
                    loadData2 = loadData6;
                    if (StringsKt.startsWith$default(StringsKt.trim(strQueryApi2).toString(), "<", false, 2, (Object) null)) {
                        z = true;
                    } else {
                        try {
                            objFromJson2 = gson2.fromJson(strQueryApi2, MovieDataProp.class);
                        } catch (Exception e3) {
                            objFromJson2 = gson2.fromJson(showBox.queryApi(str12, true), MovieDataProp.class);
                        }
                    }
                    data = ((MovieDataProp) objFromJson2).getData();
                    if (data != null) {
                        throw new RuntimeException("API error");
                    }
                    String imdbId2 = data.getImdbId();
                    c00002.L$0 = showBox6;
                    c00002.L$1 = str9;
                    c00002.L$2 = SpillingKt.nullOutSpilledVariable(loadData2);
                    c00002.L$3 = data;
                    c00002.I$0 = i;
                    c00002.I$1 = i9;
                    c00002.label = 1;
                    objLoad$fetchCinemeta2 = load$fetchCinemeta(showBox6, "movie", imdbId2, c00002);
                    if (objLoad$fetchCinemeta2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    movieData = data;
                    i3 = i9;
                    loadData3 = loadData2;
                    responseData = (ResponseData) objLoad$fetchCinemeta2;
                    if (responseData != null) {
                        meta = responseData.getMeta();
                    } else {
                        meta = null;
                    }
                    meta2 = meta;
                    TvType tvType4 = TvType.Movie;
                    if (meta2 != null) {
                        moviedb_id = meta2.getMoviedb_id();
                    } else {
                        moviedb_id = null;
                    }
                    c00002.L$0 = showBox6;
                    c00002.L$1 = str9;
                    c00002.L$2 = SpillingKt.nullOutSpilledVariable(loadData3);
                    c00002.L$3 = movieData;
                    c00002.L$4 = meta2;
                    c00002.I$0 = i;
                    c00002.I$1 = i3;
                    c00002.label = 2;
                    objLoad$fetchLogo = load$fetchLogo(tvType4, moviedb_id, c00002);
                    if (objLoad$fetchLogo == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    MovieData movieData3 = movieData;
                    str2 = str9;
                    movieData2 = movieData3;
                    loadData4 = loadData3;
                    i4 = i;
                    showBox2 = showBox6;
                    str3 = (String) objLoad$fetchLogo;
                    showBox3 = showBox2;
                    title = movieData2.getTitle();
                    if (title != null) {
                        str10 = title;
                    }
                    str4 = str2;
                    tvType = TvType.Movie;
                    id = movieData2.getId();
                    if (id != null) {
                        throw new RuntimeException("No movie ID");
                    }
                    LinkData linkData = new LinkData(id.intValue(), ResponseTypes.Movies.getValue(), null, null, movieData2.getId(), movieData2.getImdbId());
                    Meta meta6 = meta2;
                    C00012 c00012 = new C00012(movieData2, meta6, str3, showBox2, null);
                    c00002.L$0 = SpillingKt.nullOutSpilledVariable(showBox2);
                    c00002.L$1 = SpillingKt.nullOutSpilledVariable(str4);
                    c00002.L$2 = SpillingKt.nullOutSpilledVariable(loadData4);
                    c00002.L$3 = SpillingKt.nullOutSpilledVariable(movieData2);
                    c00002.L$4 = SpillingKt.nullOutSpilledVariable(meta6);
                    c00002.L$5 = SpillingKt.nullOutSpilledVariable(str3);
                    c00002.I$0 = i4;
                    c00002.I$1 = i3;
                    c00002.label = 3;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(showBox3, str10, str4, tvType, linkData, c00012, c00002);
                    if (objNewMovieLoadResponse == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return objNewMovieLoadResponse;
                }
                loadData2 = loadData6;
                z = true;
                objFromJson2 = gson2.fromJson(showBox.queryApi(str12, z), MovieDataProp.class);
                data = ((MovieDataProp) objFromJson2).getData();
                if (data != null) {
                    throw new RuntimeException("API error");
                }
                String imdbId3 = data.getImdbId();
                c00002.L$0 = showBox6;
                c00002.L$1 = str9;
                c00002.L$2 = SpillingKt.nullOutSpilledVariable(loadData2);
                c00002.L$3 = data;
                c00002.I$0 = i;
                c00002.I$1 = i9;
                c00002.label = 1;
                objLoad$fetchCinemeta2 = load$fetchCinemeta(showBox6, "movie", imdbId3, c00002);
                if (objLoad$fetchCinemeta2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                movieData = data;
                i3 = i9;
                loadData3 = loadData2;
                responseData = (ResponseData) objLoad$fetchCinemeta2;
                if (responseData != null) {
                    meta = responseData.getMeta();
                } else {
                    meta = null;
                }
                meta2 = meta;
                TvType tvType5 = TvType.Movie;
                if (meta2 != null) {
                    moviedb_id = meta2.getMoviedb_id();
                } else {
                    moviedb_id = null;
                }
                c00002.L$0 = showBox6;
                c00002.L$1 = str9;
                c00002.L$2 = SpillingKt.nullOutSpilledVariable(loadData3);
                c00002.L$3 = movieData;
                c00002.L$4 = meta2;
                c00002.I$0 = i;
                c00002.I$1 = i3;
                c00002.label = 2;
                objLoad$fetchLogo = load$fetchLogo(tvType5, moviedb_id, c00002);
                if (objLoad$fetchLogo == coroutine_suspended) {
                    return coroutine_suspended;
                }
                MovieData movieData4 = movieData;
                str2 = str9;
                movieData2 = movieData4;
                loadData4 = loadData3;
                i4 = i;
                showBox2 = showBox6;
                str3 = (String) objLoad$fetchLogo;
                showBox3 = showBox2;
                title = movieData2.getTitle();
                if (title != null) {
                    str10 = title;
                }
                str4 = str2;
                tvType = TvType.Movie;
                id = movieData2.getId();
                if (id != null) {
                    throw new RuntimeException("No movie ID");
                }
                LinkData linkData2 = new LinkData(id.intValue(), ResponseTypes.Movies.getValue(), null, null, movieData2.getId(), movieData2.getImdbId());
                Meta meta7 = meta2;
                C00012 c00013 = new C00012(movieData2, meta7, str3, showBox2, null);
                c00002.L$0 = SpillingKt.nullOutSpilledVariable(showBox2);
                c00002.L$1 = SpillingKt.nullOutSpilledVariable(str4);
                c00002.L$2 = SpillingKt.nullOutSpilledVariable(loadData4);
                c00002.L$3 = SpillingKt.nullOutSpilledVariable(movieData2);
                c00002.L$4 = SpillingKt.nullOutSpilledVariable(meta7);
                c00002.L$5 = SpillingKt.nullOutSpilledVariable(str3);
                c00002.I$0 = i4;
                c00002.I$1 = i3;
                c00002.label = 3;
                objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(showBox3, str10, str4, tvType, linkData2, c00013, c00002);
                if (objNewMovieLoadResponse == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return objNewMovieLoadResponse;
            case 1:
                i3 = c00002.I$1;
                int i10 = c00002.I$0;
                MovieData movieData5 = (MovieData) c00002.L$3;
                loadData3 = (LoadData) c00002.L$2;
                str9 = (String) c00002.L$1;
                showBox6 = (ShowBox) c00002.L$0;
                ResultKt.throwOnFailure(obj2);
                i = i10;
                movieData = movieData5;
                objLoad$fetchCinemeta2 = obj2;
                responseData = (ResponseData) objLoad$fetchCinemeta2;
                if (responseData != null) {
                    meta = responseData.getMeta();
                } else {
                    meta = null;
                }
                meta2 = meta;
                TvType tvType6 = TvType.Movie;
                if (meta2 != null) {
                    moviedb_id = meta2.getMoviedb_id();
                } else {
                    moviedb_id = null;
                }
                c00002.L$0 = showBox6;
                c00002.L$1 = str9;
                c00002.L$2 = SpillingKt.nullOutSpilledVariable(loadData3);
                c00002.L$3 = movieData;
                c00002.L$4 = meta2;
                c00002.I$0 = i;
                c00002.I$1 = i3;
                c00002.label = 2;
                objLoad$fetchLogo = load$fetchLogo(tvType6, moviedb_id, c00002);
                if (objLoad$fetchLogo == coroutine_suspended) {
                    return coroutine_suspended;
                }
                MovieData movieData6 = movieData;
                str2 = str9;
                movieData2 = movieData6;
                loadData4 = loadData3;
                i4 = i;
                showBox2 = showBox6;
                str3 = (String) objLoad$fetchLogo;
                showBox3 = showBox2;
                title = movieData2.getTitle();
                if (title != null) {
                    str10 = title;
                }
                str4 = str2;
                tvType = TvType.Movie;
                id = movieData2.getId();
                if (id != null) {
                    throw new RuntimeException("No movie ID");
                }
                LinkData linkData3 = new LinkData(id.intValue(), ResponseTypes.Movies.getValue(), null, null, movieData2.getId(), movieData2.getImdbId());
                Meta meta8 = meta2;
                C00012 c00014 = new C00012(movieData2, meta8, str3, showBox2, null);
                c00002.L$0 = SpillingKt.nullOutSpilledVariable(showBox2);
                c00002.L$1 = SpillingKt.nullOutSpilledVariable(str4);
                c00002.L$2 = SpillingKt.nullOutSpilledVariable(loadData4);
                c00002.L$3 = SpillingKt.nullOutSpilledVariable(movieData2);
                c00002.L$4 = SpillingKt.nullOutSpilledVariable(meta8);
                c00002.L$5 = SpillingKt.nullOutSpilledVariable(str3);
                c00002.I$0 = i4;
                c00002.I$1 = i3;
                c00002.label = 3;
                objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(showBox3, str10, str4, tvType, linkData3, c00014, c00002);
                if (objNewMovieLoadResponse == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return objNewMovieLoadResponse;
            case 2:
                i3 = c00002.I$1;
                int i11 = c00002.I$0;
                meta2 = (Meta) c00002.L$4;
                MovieData movieData7 = (MovieData) c00002.L$3;
                LoadData loadData7 = (LoadData) c00002.L$2;
                String str13 = (String) c00002.L$1;
                ShowBox showBox8 = (ShowBox) c00002.L$0;
                ResultKt.throwOnFailure(obj2);
                str2 = str13;
                movieData2 = movieData7;
                str10 = "";
                loadData4 = loadData7;
                objLoad$fetchLogo = obj2;
                i4 = i11;
                showBox2 = showBox8;
                str3 = (String) objLoad$fetchLogo;
                showBox3 = showBox2;
                title = movieData2.getTitle();
                if (title != null) {
                    str10 = title;
                }
                str4 = str2;
                tvType = TvType.Movie;
                id = movieData2.getId();
                if (id != null) {
                    throw new RuntimeException("No movie ID");
                }
                LinkData linkData4 = new LinkData(id.intValue(), ResponseTypes.Movies.getValue(), null, null, movieData2.getId(), movieData2.getImdbId());
                Meta meta9 = meta2;
                C00012 c00015 = new C00012(movieData2, meta9, str3, showBox2, null);
                c00002.L$0 = SpillingKt.nullOutSpilledVariable(showBox2);
                c00002.L$1 = SpillingKt.nullOutSpilledVariable(str4);
                c00002.L$2 = SpillingKt.nullOutSpilledVariable(loadData4);
                c00002.L$3 = SpillingKt.nullOutSpilledVariable(movieData2);
                c00002.L$4 = SpillingKt.nullOutSpilledVariable(meta9);
                c00002.L$5 = SpillingKt.nullOutSpilledVariable(str3);
                c00002.I$0 = i4;
                c00002.I$1 = i3;
                c00002.label = 3;
                objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(showBox3, str10, str4, tvType, linkData4, c00015, c00002);
                if (objNewMovieLoadResponse == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return objNewMovieLoadResponse;
            case 3:
                int i12 = c00002.I$1;
                int i13 = c00002.I$0;
                ResultKt.throwOnFailure(obj2);
                return obj2;
            case 4:
                i2 = c00002.I$1;
                i = c00002.I$0;
                SeriesData seriesData5 = (SeriesData) c00002.L$3;
                LoadData loadData8 = (LoadData) c00002.L$2;
                str9 = (String) c00002.L$1;
                showBox6 = (ShowBox) c00002.L$0;
                ResultKt.throwOnFailure(obj2);
                loadData = loadData8;
                objLoad$fetchCinemeta = obj2;
                seriesData = seriesData5;
                responseData2 = (ResponseData) objLoad$fetchCinemeta;
                if (responseData2 != null) {
                    meta3 = responseData2.getMeta();
                } else {
                    meta3 = null;
                }
                meta4 = meta3;
                TvType tvType7 = TvType.TvSeries;
                if (meta4 != null) {
                    moviedb_id2 = meta4.getMoviedb_id();
                } else {
                    moviedb_id2 = null;
                }
                c00002.L$0 = showBox6;
                c00002.L$1 = str9;
                c00002.L$2 = loadData;
                c00002.L$3 = seriesData;
                c00002.L$4 = meta4;
                c00002.I$0 = i;
                c00002.I$1 = i2;
                c00002.label = 5;
                objLoad$fetchLogo2 = load$fetchLogo(tvType7, moviedb_id2, c00002);
                if (objLoad$fetchLogo2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                i5 = i2;
                showBox4 = showBox6;
                seriesData2 = seriesData;
                loadData5 = loadData;
                str5 = (String) objLoad$fetchLogo2;
                List<Integer> season2 = seriesData2.getSeason();
                showBox5 = showBox4;
                i6 = i5;
                seriesData3 = seriesData2;
                ShowBox$load$allEpisodes$1 showBox$load$allEpisodes$2 = new ShowBox$load$allEpisodes$1(showBox4, i5, loadData5, seriesData2, null);
                c00002.L$0 = showBox5;
                c00002.L$1 = str9;
                c00002.L$2 = SpillingKt.nullOutSpilledVariable(loadData5);
                c00002.L$3 = seriesData3;
                c00002.L$4 = meta4;
                c00002.L$5 = str5;
                c00002.I$0 = i;
                c00002.I$1 = i6;
                c00002.label = 6;
                objAmap = ParCollectionsKt.amap(season2, showBox$load$allEpisodes$2, c00002);
                if (objAmap == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str6 = str5;
                i7 = i6;
                meta5 = meta4;
                seriesData4 = seriesData3;
                str7 = str9;
                i8 = i;
                List listFlatten2 = CollectionsKt.flatten((Iterable) objAmap);
                ShowBox showBox9 = showBox5;
                title2 = seriesData4.getTitle();
                if (title2 == null) {
                    str8 = str10;
                } else {
                    str8 = title2;
                }
                TvType tvType8 = TvType.TvSeries;
                C00023 c00024 = new C00023(seriesData4, meta5, str6, null);
                c00002.L$0 = SpillingKt.nullOutSpilledVariable(showBox5);
                c00002.L$1 = SpillingKt.nullOutSpilledVariable(str7);
                c00002.L$2 = SpillingKt.nullOutSpilledVariable(loadData5);
                c00002.L$3 = SpillingKt.nullOutSpilledVariable(seriesData4);
                c00002.L$4 = SpillingKt.nullOutSpilledVariable(meta5);
                c00002.L$5 = SpillingKt.nullOutSpilledVariable(str6);
                c00002.L$6 = SpillingKt.nullOutSpilledVariable(listFlatten2);
                c00002.I$0 = i8;
                c00002.I$1 = i7;
                c00002.label = 7;
                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(showBox9, str8, str7, tvType8, listFlatten2, c00024, c00002);
                if (objNewTvSeriesLoadResponse == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return objNewTvSeriesLoadResponse;
            case 5:
                int i14 = c00002.I$1;
                i = c00002.I$0;
                meta4 = (Meta) c00002.L$4;
                SeriesData seriesData6 = (SeriesData) c00002.L$3;
                LoadData loadData9 = (LoadData) c00002.L$2;
                str9 = (String) c00002.L$1;
                ShowBox showBox10 = (ShowBox) c00002.L$0;
                ResultKt.throwOnFailure(obj2);
                str10 = "";
                objLoad$fetchLogo2 = obj2;
                i5 = i14;
                showBox4 = showBox10;
                seriesData2 = seriesData6;
                loadData5 = loadData9;
                str5 = (String) objLoad$fetchLogo2;
                List<Integer> season3 = seriesData2.getSeason();
                showBox5 = showBox4;
                i6 = i5;
                seriesData3 = seriesData2;
                ShowBox$load$allEpisodes$1 showBox$load$allEpisodes$3 = new ShowBox$load$allEpisodes$1(showBox4, i5, loadData5, seriesData2, null);
                c00002.L$0 = showBox5;
                c00002.L$1 = str9;
                c00002.L$2 = SpillingKt.nullOutSpilledVariable(loadData5);
                c00002.L$3 = seriesData3;
                c00002.L$4 = meta4;
                c00002.L$5 = str5;
                c00002.I$0 = i;
                c00002.I$1 = i6;
                c00002.label = 6;
                objAmap = ParCollectionsKt.amap(season3, showBox$load$allEpisodes$3, c00002);
                if (objAmap == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str6 = str5;
                i7 = i6;
                meta5 = meta4;
                seriesData4 = seriesData3;
                str7 = str9;
                i8 = i;
                List listFlatten3 = CollectionsKt.flatten((Iterable) objAmap);
                ShowBox showBox11 = showBox5;
                title2 = seriesData4.getTitle();
                if (title2 == null) {
                    str8 = str10;
                } else {
                    str8 = title2;
                }
                TvType tvType9 = TvType.TvSeries;
                C00023 c00025 = new C00023(seriesData4, meta5, str6, null);
                c00002.L$0 = SpillingKt.nullOutSpilledVariable(showBox5);
                c00002.L$1 = SpillingKt.nullOutSpilledVariable(str7);
                c00002.L$2 = SpillingKt.nullOutSpilledVariable(loadData5);
                c00002.L$3 = SpillingKt.nullOutSpilledVariable(seriesData4);
                c00002.L$4 = SpillingKt.nullOutSpilledVariable(meta5);
                c00002.L$5 = SpillingKt.nullOutSpilledVariable(str6);
                c00002.L$6 = SpillingKt.nullOutSpilledVariable(listFlatten3);
                c00002.I$0 = i8;
                c00002.I$1 = i7;
                c00002.label = 7;
                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(showBox11, str8, str7, tvType9, listFlatten3, c00025, c00002);
                if (objNewTvSeriesLoadResponse == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return objNewTvSeriesLoadResponse;
            case 6:
                i7 = c00002.I$1;
                int i15 = c00002.I$0;
                String str14 = (String) c00002.L$5;
                Meta meta10 = (Meta) c00002.L$4;
                SeriesData seriesData7 = (SeriesData) c00002.L$3;
                LoadData loadData10 = (LoadData) c00002.L$2;
                String str15 = (String) c00002.L$1;
                ShowBox showBox12 = (ShowBox) c00002.L$0;
                ResultKt.throwOnFailure(obj2);
                showBox5 = showBox12;
                str10 = "";
                seriesData4 = seriesData7;
                objAmap = obj2;
                loadData5 = loadData10;
                str6 = str14;
                meta5 = meta10;
                str7 = str15;
                i8 = i15;
                List listFlatten4 = CollectionsKt.flatten((Iterable) objAmap);
                ShowBox showBox13 = showBox5;
                title2 = seriesData4.getTitle();
                if (title2 == null) {
                    str8 = str10;
                } else {
                    str8 = title2;
                }
                TvType tvType10 = TvType.TvSeries;
                C00023 c00026 = new C00023(seriesData4, meta5, str6, null);
                c00002.L$0 = SpillingKt.nullOutSpilledVariable(showBox5);
                c00002.L$1 = SpillingKt.nullOutSpilledVariable(str7);
                c00002.L$2 = SpillingKt.nullOutSpilledVariable(loadData5);
                c00002.L$3 = SpillingKt.nullOutSpilledVariable(seriesData4);
                c00002.L$4 = SpillingKt.nullOutSpilledVariable(meta5);
                c00002.L$5 = SpillingKt.nullOutSpilledVariable(str6);
                c00002.L$6 = SpillingKt.nullOutSpilledVariable(listFlatten4);
                c00002.I$0 = i8;
                c00002.I$1 = i7;
                c00002.label = 7;
                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(showBox13, str8, str7, tvType10, listFlatten4, c00026, c00002);
                if (objNewTvSeriesLoadResponse == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return objNewTvSeriesLoadResponse;
            case 7:
                int i16 = c00002.I$1;
                int i17 = c00002.I$0;
                ResultKt.throwOnFailure(obj2);
                return obj2;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public static final Object load$fetchCinemeta(ShowBox this$0, String type, String imdbId, Continuation<? super ResponseData> continuation) {
        ShowBox$load$fetchCinemeta$1 showBox$load$fetchCinemeta$1;
        boolean z;
        Object obj;
        if (continuation instanceof ShowBox$load$fetchCinemeta$1) {
            showBox$load$fetchCinemeta$1 = (ShowBox$load$fetchCinemeta$1) continuation;
            if ((showBox$load$fetchCinemeta$1.label & Integer.MIN_VALUE) != 0) {
                showBox$load$fetchCinemeta$1.label -= Integer.MIN_VALUE;
            } else {
                showBox$load$fetchCinemeta$1 = new ShowBox$load$fetchCinemeta$1(continuation);
            }
        } else {
            showBox$load$fetchCinemeta$1 = new ShowBox$load$fetchCinemeta$1(continuation);
        }
        Object $result = showBox$load$fetchCinemeta$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (showBox$load$fetchCinemeta$1.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (imdbId != null) {
                    String it = imdbId.length() > 0 ? imdbId : null;
                    if (it != null) {
                        Requests app = MainActivityKt.getApp();
                        String str = this$0.cinemeta_url + '/' + type + '/' + it + ".json";
                        showBox$load$fetchCinemeta$1.L$0 = SpillingKt.nullOutSpilledVariable(this$0);
                        showBox$load$fetchCinemeta$1.L$1 = SpillingKt.nullOutSpilledVariable(type);
                        showBox$load$fetchCinemeta$1.L$2 = SpillingKt.nullOutSpilledVariable(imdbId);
                        showBox$load$fetchCinemeta$1.L$3 = SpillingKt.nullOutSpilledVariable(it);
                        showBox$load$fetchCinemeta$1.label = 1;
                        z = false;
                        $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 10000L, (Interceptor) null, false, (ResponseParser) null, showBox$load$fetchCinemeta$1, 3838, (Object) null);
                        if ($result == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    break;
                }
                return null;
            case 1:
                ResultKt.throwOnFailure($result);
                z = false;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String res = ((NiceResponse) $result).getText();
        if (res.length() > 0) {
            obj = null;
            if (StringsKt.startsWith$default(res, "{", z, 2, (Object) null)) {
                return (ResponseData) new Gson().fromJson(res, ResponseData.class);
            }
        } else {
            obj = null;
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object load$fetchLogo(TvType type, Integer tmdbId, Continuation<? super String> continuation) {
        return ShowBoxparserKt.fetchTmdbLogoUrl("https://api.themoviedb.org/3", "1865f43a0549ca50d341dd9ab8b29f49", type, tmdbId, "en", continuation);
    }

    /* JADX INFO: renamed from: com.phisher98.ShowBox$load$2 */
    /* JADX INFO: compiled from: ShowBox.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.ShowBox$load$2", f = "ShowBox.kt", i = {0}, l = {702}, m = "invokeSuspend", n = {"$this$newMovieLoadResponse"}, nl = {703}, s = {"L$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nShowBox.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ShowBox.kt\ncom/phisher98/ShowBox$load$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,946:1\n1795#2,10:947\n2068#2:957\n2069#2:959\n1805#2:960\n1739#2:961\n1814#2,3:962\n1#3:958\n*S KotlinDebug\n*F\n+ 1 ShowBox.kt\ncom/phisher98/ShowBox$load$2\n*L\n694#1:947,10\n694#1:957\n694#1:959\n694#1:960\n700#1:961\n700#1:962,3\n694#1:958\n*E\n"})
    static final class C00012 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ MovieData $data;
        final /* synthetic */ String $logoUrl;
        final /* synthetic */ Meta $meta;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ShowBox this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00012(MovieData movieData, Meta meta, String str, ShowBox showBox, Continuation<? super C00012> continuation) {
            super(2, continuation);
            this.$data = movieData;
            this.$meta = meta;
            this.$logoUrl = str;
            this.this$0 = showBox;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00012 = new C00012(this.$data, this.$meta, this.$logoUrl, this.this$0, continuation);
            c00012.L$0 = obj;
            return c00012;
        }

        public final Object invoke(MovieLoadResponse movieLoadResponse, Continuation<? super Unit> continuation) {
            return create(movieLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            String posterOrg;
            List<String> listEmptyList;
            List<String> genre;
            Iterable iterableSplit$default;
            LoadResponse loadResponse = (MovieLoadResponse) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Iterable $this$mapNotNull$iv = this.$data.getRecommend();
                    ShowBox showBox = this.this$0;
                    Collection destination$iv$iv = new ArrayList();
                    for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                        Data it = (Data) element$iv$iv$iv;
                        Iterable $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                        MovieSearchResponse searchResponse = it.toSearchResponse(showBox);
                        if (searchResponse != null) {
                            destination$iv$iv.add(searchResponse);
                        }
                        $this$mapNotNull$iv = $this$mapNotNull$iv2;
                    }
                    loadResponse.setRecommendations((List) destination$iv$iv);
                    String poster = this.$data.getPoster();
                    if (poster == null) {
                        poster = this.$data.getPosterOrg();
                    }
                    loadResponse.setPosterUrl(poster);
                    Meta meta = this.$meta;
                    if ((meta == null || (posterOrg = meta.getBackground()) == null) && (posterOrg = this.$data.getPosterOrg()) == null) {
                        posterOrg = this.$data.getPoster();
                    }
                    loadResponse.setBackgroundPosterUrl(posterOrg);
                    loadResponse.setYear(this.$data.getYear());
                    LoadResponse.Companion companion = LoadResponse.Companion;
                    LoadResponse loadResponse2 = loadResponse;
                    Meta meta2 = this.$meta;
                    if (meta2 == null || (listEmptyList = meta2.getCast()) == null) {
                        listEmptyList = CollectionsKt.emptyList();
                    }
                    companion.addActorNames(loadResponse2, listEmptyList);
                    loadResponse.setPlot(this.$data.getDescription());
                    Meta meta3 = this.$meta;
                    if (meta3 == null || (genre = meta3.getGenre()) == null) {
                        String cats = this.$data.getCats();
                        if (cats == null || (iterableSplit$default = StringsKt.split$default(cats, new String[]{","}, false, 0, 6, (Object) null)) == null) {
                            genre = null;
                        } else {
                            Iterable $this$map$iv = iterableSplit$default;
                            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                            for (Object item$iv$iv : $this$map$iv) {
                                String it2 = (String) item$iv$iv;
                                destination$iv$iv2.add(APIHolder.INSTANCE.capitalize(it2));
                            }
                            genre = (List) destination$iv$iv2;
                        }
                    }
                    loadResponse.setTags(genre);
                    loadResponse.setScore(Score.Companion.from10(this.$data.getImdbRating()));
                    this.L$0 = loadResponse;
                    this.label = 1;
                    if (LoadResponse.Companion.addTrailer$default(LoadResponse.Companion, loadResponse, this.$data.getTrailerUrl(), (String) null, false, (Continuation) this, 6, (Object) null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LoadResponse.Companion.addImdbId(loadResponse, this.$data.getImdbId());
            try {
                loadResponse.setLogoUrl(this.$logoUrl);
            } catch (Throwable th) {
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.phisher98.ShowBox$load$3 */
    /* JADX INFO: compiled from: ShowBox.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.ShowBox$load$3", f = "ShowBox.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nShowBox.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ShowBox.kt\ncom/phisher98/ShowBox$load$3\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,946:1\n1739#2:947\n1814#2,3:948\n*S KotlinDebug\n*F\n+ 1 ShowBox.kt\ncom/phisher98/ShowBox$load$3\n*L\n749#1:947\n749#1:948,3\n*E\n"})
    static final class C00023 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ SeriesData $data;
        final /* synthetic */ String $logoUrl;
        final /* synthetic */ Meta $meta;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00023(SeriesData seriesData, Meta meta, String str, Continuation<? super C00023> continuation) {
            super(2, continuation);
            this.$data = seriesData;
            this.$meta = meta;
            this.$logoUrl = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00023 = new C00023(this.$data, this.$meta, this.$logoUrl, continuation);
            c00023.L$0 = obj;
            return c00023;
        }

        public final Object invoke(TvSeriesLoadResponse tvSeriesLoadResponse, Continuation<? super Unit> continuation) {
            return create(tvSeriesLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            List<String> listEmptyList;
            String bannerMiniOrg;
            List<String> genre;
            Iterable iterableSplit$default;
            LoadResponse loadResponse = (TvSeriesLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    loadResponse.setYear(this.$data.getYear());
                    loadResponse.setPlot(this.$data.getDescription());
                    LoadResponse.Companion companion = LoadResponse.Companion;
                    LoadResponse loadResponse2 = loadResponse;
                    Meta meta = this.$meta;
                    if (meta == null || (listEmptyList = meta.getCast()) == null) {
                        listEmptyList = CollectionsKt.emptyList();
                    }
                    companion.addActorNames(loadResponse2, listEmptyList);
                    String poster = this.$data.getPoster();
                    if (poster == null) {
                        poster = this.$data.getPosterOrg();
                    }
                    loadResponse.setPosterUrl(poster);
                    Meta meta2 = this.$meta;
                    if ((meta2 == null || (bannerMiniOrg = meta2.getBackground()) == null) && (bannerMiniOrg = this.$data.getBannerMiniOrg()) == null && (bannerMiniOrg = this.$data.getBannerMini()) == null && (bannerMiniOrg = this.$data.getPosterOrg()) == null) {
                        bannerMiniOrg = this.$data.getPoster();
                    }
                    loadResponse.setBackgroundPosterUrl(bannerMiniOrg);
                    loadResponse.setScore(Score.Companion.from10(this.$data.getImdbRating()));
                    Meta meta3 = this.$meta;
                    if (meta3 == null || (genre = meta3.getGenre()) == null) {
                        String cats = this.$data.getCats();
                        if (cats == null || (iterableSplit$default = StringsKt.split$default(cats, new String[]{","}, false, 0, 6, (Object) null)) == null) {
                            genre = null;
                        } else {
                            Iterable $this$map$iv = iterableSplit$default;
                            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                            for (Object item$iv$iv : $this$map$iv) {
                                String it = (String) item$iv$iv;
                                destination$iv$iv.add(APIHolder.INSTANCE.capitalize(it));
                            }
                            genre = (List) destination$iv$iv;
                        }
                    }
                    loadResponse.setTags(genre);
                    LoadResponse.Companion.addImdbId(loadResponse, this.$data.getImdbId());
                    LoadResponse.Companion.addImdbUrl(loadResponse, this.$data.getImdbLink());
                    try {
                        loadResponse.setLogoUrl(this.$logoUrl);
                        break;
                    } catch (Throwable th) {
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: ShowBox.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\tHÆ\u0003JR\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0014\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010!\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\"\u001a\u00020\tHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0013\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lcom/phisher98/ShowBox$LinkData;", "", "id", "", "type", "season", "episode", "mediaId", "imdbId", "", "<init>", "(IILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getId", "()I", "getType", "getSeason", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEpisode", "getMediaId", "getImdbId", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(IILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/phisher98/ShowBox$LinkData;", "equals", "", "other", "hashCode", "toString", "ShowBox"}, k = 1, mv = {2, 4, 0}, xi = 48)
    static final /* data */ class LinkData {

        @Nullable
        private final Integer episode;
        private final int id;

        @Nullable
        private final String imdbId;

        @Nullable
        private final Integer mediaId;

        @Nullable
        private final Integer season;
        private final int type;

        public static /* synthetic */ LinkData copy$default(LinkData linkData, int i, int i2, Integer num, Integer num2, Integer num3, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = linkData.id;
            }
            if ((i3 & 2) != 0) {
                i2 = linkData.type;
            }
            if ((i3 & 4) != 0) {
                num = linkData.season;
            }
            if ((i3 & 8) != 0) {
                num2 = linkData.episode;
            }
            if ((i3 & 16) != 0) {
                num3 = linkData.mediaId;
            }
            if ((i3 & 32) != 0) {
                str = linkData.imdbId;
            }
            Integer num4 = num3;
            String str2 = str;
            return linkData.copy(i, i2, num, num2, num4, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getType() {
            return this.type;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getSeason() {
            return this.season;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Integer getEpisode() {
            return this.episode;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Integer getMediaId() {
            return this.mediaId;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getImdbId() {
            return this.imdbId;
        }

        @NotNull
        public final LinkData copy(int id, int type, @Nullable Integer season, @Nullable Integer episode, @Nullable Integer mediaId, @Nullable String imdbId) {
            return new LinkData(id, type, season, episode, mediaId, imdbId);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LinkData)) {
                return false;
            }
            LinkData linkData = (LinkData) other;
            return this.id == linkData.id && this.type == linkData.type && Intrinsics.areEqual(this.season, linkData.season) && Intrinsics.areEqual(this.episode, linkData.episode) && Intrinsics.areEqual(this.mediaId, linkData.mediaId) && Intrinsics.areEqual(this.imdbId, linkData.imdbId);
        }

        public int hashCode() {
            return (((((((((this.id * 31) + this.type) * 31) + (this.season == null ? 0 : this.season.hashCode())) * 31) + (this.episode == null ? 0 : this.episode.hashCode())) * 31) + (this.mediaId == null ? 0 : this.mediaId.hashCode())) * 31) + (this.imdbId != null ? this.imdbId.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "LinkData(id=" + this.id + ", type=" + this.type + ", season=" + this.season + ", episode=" + this.episode + ", mediaId=" + this.mediaId + ", imdbId=" + this.imdbId + ')';
        }

        public LinkData(int id, int type, @Nullable Integer season, @Nullable Integer episode, @Nullable Integer mediaId, @Nullable String imdbId) {
            this.id = id;
            this.type = type;
            this.season = season;
            this.episode = episode;
            this.mediaId = mediaId;
            this.imdbId = imdbId;
        }

        public final int getId() {
            return this.id;
        }

        public final int getType() {
            return this.type;
        }

        @Nullable
        public final Integer getSeason() {
            return this.season;
        }

        @Nullable
        public final Integer getEpisode() {
            return this.episode;
        }

        @Nullable
        public final Integer getMediaId() {
            return this.mediaId;
        }

        @Nullable
        public final String getImdbId() {
            return this.imdbId;
        }
    }

    /* JADX INFO: compiled from: ShowBox.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0014\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u0005HÖ\u0081\u0004R)\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0002¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR'\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u0092\u0002\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R'\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u0092\u0002\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/phisher98/ShowBox$LinkDataProp;", "", "code", "", "msg", "", "data", "Lcom/phisher98/ShowBox$ParsedLinkData;", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/phisher98/ShowBox$ParsedLinkData;)V", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "Lcom/google/gson/annotations/SerializedName;", "value", "getMsg", "()Ljava/lang/String;", "getData", "()Lcom/phisher98/ShowBox$ParsedLinkData;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/phisher98/ShowBox$ParsedLinkData;)Lcom/phisher98/ShowBox$LinkDataProp;", "equals", "", "other", "hashCode", "toString", "ShowBox"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class LinkDataProp {

        @SerializedName("code")
        @Nullable
        private final Integer code;

        @SerializedName("data")
        @Nullable
        private final ParsedLinkData data;

        @SerializedName("msg")
        @Nullable
        private final String msg;

        public LinkDataProp() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ LinkDataProp copy$default(LinkDataProp linkDataProp, Integer num, String str, ParsedLinkData parsedLinkData, int i, Object obj) {
            if ((i & 1) != 0) {
                num = linkDataProp.code;
            }
            if ((i & 2) != 0) {
                str = linkDataProp.msg;
            }
            if ((i & 4) != 0) {
                parsedLinkData = linkDataProp.data;
            }
            return linkDataProp.copy(num, str, parsedLinkData);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getCode() {
            return this.code;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getMsg() {
            return this.msg;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final ParsedLinkData getData() {
            return this.data;
        }

        @NotNull
        public final LinkDataProp copy(@Nullable Integer code, @Nullable String msg, @Nullable ParsedLinkData data) {
            return new LinkDataProp(code, msg, data);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LinkDataProp)) {
                return false;
            }
            LinkDataProp linkDataProp = (LinkDataProp) other;
            return Intrinsics.areEqual(this.code, linkDataProp.code) && Intrinsics.areEqual(this.msg, linkDataProp.msg) && Intrinsics.areEqual(this.data, linkDataProp.data);
        }

        public int hashCode() {
            return ((((this.code == null ? 0 : this.code.hashCode()) * 31) + (this.msg == null ? 0 : this.msg.hashCode())) * 31) + (this.data != null ? this.data.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "LinkDataProp(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ')';
        }

        public LinkDataProp(@Nullable Integer code, @Nullable String msg, @Nullable ParsedLinkData data) {
            this.code = code;
            this.msg = msg;
            this.data = data;
        }

        public /* synthetic */ LinkDataProp(Integer num, String str, ParsedLinkData parsedLinkData, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? new ParsedLinkData(null, null, null, 7, null) : parsedLinkData);
        }

        @Nullable
        public final Integer getCode() {
            return this.code;
        }

        @Nullable
        public final String getMsg() {
            return this.msg;
        }

        @Nullable
        public final ParsedLinkData getData() {
            return this.data;
        }
    }

    /* JADX INFO: compiled from: ShowBox.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b6\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u008f\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u001b\u0010\u001cJ\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010B\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010'J\u0010\u0010C\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010+J\u0010\u0010D\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010'J\u0010\u0010E\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010+J\u0010\u0010F\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010+J\u0010\u0010G\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010+J\u0010\u0010H\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010+J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010J\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010+J\u0010\u0010K\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010+J\u0010\u0010L\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010+J\u0010\u0010M\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010+J\u0010\u0010N\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010+J\u0010\u0010O\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010+J\u000b\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010Q\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010+J\u0010\u0010R\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010+J\u0096\u0002\u0010S\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010TJ\u0014\u0010U\u001a\u00020V2\b\u0010W\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010X\u001a\u00020\u000bHÖ\u0081\u0004J\n\u0010Y\u001a\u00020\u0003HÖ\u0081\u0004R'\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR'\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001eR'\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u001f\u0012\b\b \u0012\u0004\b\b(#¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001eR'\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u0006¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001eR'\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001eR)\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u0092\u0002\f\b\u001f\u0012\b\b \u0012\u0004\b\b()¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R)\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004\u0092\u0002\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\n¢\u0006\n\n\u0002\u0010,\u001a\u0004\b*\u0010+R)\u0010\f\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u0092\u0002\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\f¢\u0006\n\n\u0002\u0010(\u001a\u0004\b-\u0010'R)\u0010\r\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004\u0092\u0002\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\r¢\u0006\n\n\u0002\u0010,\u001a\u0004\b.\u0010+R)\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004\u0092\u0002\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u000e¢\u0006\n\n\u0002\u0010,\u001a\u0004\b/\u0010+R)\u0010\u000f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004\u0092\u0002\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u000f¢\u0006\n\n\u0002\u0010,\u001a\u0004\b0\u0010+R)\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004\u0092\u0002\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u0010¢\u0006\n\n\u0002\u0010,\u001a\u0004\b1\u0010+R'\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u0011¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001eR)\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004\u0092\u0002\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u0012¢\u0006\n\n\u0002\u0010,\u001a\u0004\b3\u0010+R)\u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004\u0092\u0002\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u0013¢\u0006\n\n\u0002\u0010,\u001a\u0004\b4\u0010+R)\u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004\u0092\u0002\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u0014¢\u0006\n\n\u0002\u0010,\u001a\u0004\b5\u0010+R)\u0010\u0015\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004\u0092\u0002\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u0015¢\u0006\n\n\u0002\u0010,\u001a\u0004\b6\u0010+R)\u0010\u0016\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004\u0092\u0002\f\b\u001f\u0012\b\b \u0012\u0004\b\b(8¢\u0006\n\n\u0002\u0010,\u001a\u0004\b7\u0010+R)\u0010\u0017\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004\u0092\u0002\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u0017¢\u0006\n\n\u0002\u0010,\u001a\u0004\b9\u0010+R'\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u0018¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u001eR)\u0010\u0019\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004\u0092\u0002\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u0019¢\u0006\n\n\u0002\u0010,\u001a\u0004\b;\u0010+R)\u0010\u001a\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004\u0092\u0002\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u001a¢\u0006\n\n\u0002\u0010,\u001a\u0004\b<\u0010+¨\u0006Z"}, d2 = {"Lcom/phisher98/ShowBox$LinkList;", "", "path", "", "quality", "realQuality", "format", "size", "sizeBytes", "", "count", "", "dateline", "fid", "mmfid", "h265", "hdr", "filename", "original", "colorbit", "success", "timeout", "vipLink", "fps", "bitstream", "width", "height", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getPath", "()Ljava/lang/String;", "Lcom/google/gson/annotations/SerializedName;", "value", "getQuality", "getRealQuality", "real_quality", "getFormat", "getSize", "getSizeBytes", "()Ljava/lang/Long;", "Ljava/lang/Long;", "size_bytes", "getCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDateline", "getFid", "getMmfid", "getH265", "getHdr", "getFilename", "getOriginal", "getColorbit", "getSuccess", "getTimeout", "getVipLink", "vip_link", "getFps", "getBitstream", "getWidth", "getHeight", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/phisher98/ShowBox$LinkList;", "equals", "", "other", "hashCode", "toString", "ShowBox"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class LinkList {

        @SerializedName("bitstream")
        @Nullable
        private final String bitstream;

        @SerializedName("colorbit")
        @Nullable
        private final Integer colorbit;

        @SerializedName("count")
        @Nullable
        private final Integer count;

        @SerializedName("dateline")
        @Nullable
        private final Long dateline;

        @SerializedName("fid")
        @Nullable
        private final Integer fid;

        @SerializedName("filename")
        @Nullable
        private final String filename;

        @SerializedName("format")
        @Nullable
        private final String format;

        @SerializedName("fps")
        @Nullable
        private final Integer fps;

        @SerializedName("h265")
        @Nullable
        private final Integer h265;

        @SerializedName("hdr")
        @Nullable
        private final Integer hdr;

        @SerializedName("height")
        @Nullable
        private final Integer height;

        @SerializedName("mmfid")
        @Nullable
        private final Integer mmfid;

        @SerializedName("original")
        @Nullable
        private final Integer original;

        @SerializedName("path")
        @Nullable
        private final String path;

        @SerializedName("quality")
        @Nullable
        private final String quality;

        @SerializedName("real_quality")
        @Nullable
        private final String realQuality;

        @SerializedName("size")
        @Nullable
        private final String size;

        @SerializedName("size_bytes")
        @Nullable
        private final Long sizeBytes;

        @SerializedName("success")
        @Nullable
        private final Integer success;

        @SerializedName("timeout")
        @Nullable
        private final Integer timeout;

        @SerializedName("vip_link")
        @Nullable
        private final Integer vipLink;

        @SerializedName("width")
        @Nullable
        private final Integer width;

        public LinkList() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 4194303, null);
        }

        public static /* synthetic */ LinkList copy$default(LinkList linkList, String str, String str2, String str3, String str4, String str5, Long l, Integer num, Long l2, Integer num2, Integer num3, Integer num4, Integer num5, String str6, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, String str7, Integer num12, Integer num13, int i, Object obj) {
            Integer num14;
            Integer num15;
            String str8 = (i & 1) != 0 ? linkList.path : str;
            String str9 = (i & 2) != 0 ? linkList.quality : str2;
            String str10 = (i & 4) != 0 ? linkList.realQuality : str3;
            String str11 = (i & 8) != 0 ? linkList.format : str4;
            String str12 = (i & 16) != 0 ? linkList.size : str5;
            Long l3 = (i & 32) != 0 ? linkList.sizeBytes : l;
            Integer num16 = (i & 64) != 0 ? linkList.count : num;
            Long l4 = (i & 128) != 0 ? linkList.dateline : l2;
            Integer num17 = (i & 256) != 0 ? linkList.fid : num2;
            Integer num18 = (i & 512) != 0 ? linkList.mmfid : num3;
            Integer num19 = (i & 1024) != 0 ? linkList.h265 : num4;
            Integer num20 = (i & 2048) != 0 ? linkList.hdr : num5;
            String str13 = (i & 4096) != 0 ? linkList.filename : str6;
            Integer num21 = (i & 8192) != 0 ? linkList.original : num6;
            String str14 = str8;
            Integer num22 = (i & 16384) != 0 ? linkList.colorbit : num7;
            Integer num23 = (i & 32768) != 0 ? linkList.success : num8;
            Integer num24 = (i & 65536) != 0 ? linkList.timeout : num9;
            Integer num25 = (i & 131072) != 0 ? linkList.vipLink : num10;
            Integer num26 = (i & 262144) != 0 ? linkList.fps : num11;
            String str15 = (i & 524288) != 0 ? linkList.bitstream : str7;
            Integer num27 = (i & 1048576) != 0 ? linkList.width : num12;
            if ((i & 2097152) != 0) {
                num15 = num27;
                num14 = linkList.height;
            } else {
                num14 = num13;
                num15 = num27;
            }
            return linkList.copy(str14, str9, str10, str11, str12, l3, num16, l4, num17, num18, num19, num20, str13, num21, num22, num23, num24, num25, num26, str15, num15, num14);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getPath() {
            return this.path;
        }

        @Nullable
        /* JADX INFO: renamed from: component10, reason: from getter */
        public final Integer getMmfid() {
            return this.mmfid;
        }

        @Nullable
        /* JADX INFO: renamed from: component11, reason: from getter */
        public final Integer getH265() {
            return this.h265;
        }

        @Nullable
        /* JADX INFO: renamed from: component12, reason: from getter */
        public final Integer getHdr() {
            return this.hdr;
        }

        @Nullable
        /* JADX INFO: renamed from: component13, reason: from getter */
        public final String getFilename() {
            return this.filename;
        }

        @Nullable
        /* JADX INFO: renamed from: component14, reason: from getter */
        public final Integer getOriginal() {
            return this.original;
        }

        @Nullable
        /* JADX INFO: renamed from: component15, reason: from getter */
        public final Integer getColorbit() {
            return this.colorbit;
        }

        @Nullable
        /* JADX INFO: renamed from: component16, reason: from getter */
        public final Integer getSuccess() {
            return this.success;
        }

        @Nullable
        /* JADX INFO: renamed from: component17, reason: from getter */
        public final Integer getTimeout() {
            return this.timeout;
        }

        @Nullable
        /* JADX INFO: renamed from: component18, reason: from getter */
        public final Integer getVipLink() {
            return this.vipLink;
        }

        @Nullable
        /* JADX INFO: renamed from: component19, reason: from getter */
        public final Integer getFps() {
            return this.fps;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getQuality() {
            return this.quality;
        }

        @Nullable
        /* JADX INFO: renamed from: component20, reason: from getter */
        public final String getBitstream() {
            return this.bitstream;
        }

        @Nullable
        /* JADX INFO: renamed from: component21, reason: from getter */
        public final Integer getWidth() {
            return this.width;
        }

        @Nullable
        /* JADX INFO: renamed from: component22, reason: from getter */
        public final Integer getHeight() {
            return this.height;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getRealQuality() {
            return this.realQuality;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getFormat() {
            return this.format;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getSize() {
            return this.size;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Long getSizeBytes() {
            return this.sizeBytes;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Integer getCount() {
            return this.count;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Long getDateline() {
            return this.dateline;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final Integer getFid() {
            return this.fid;
        }

        @NotNull
        public final LinkList copy(@Nullable String path, @Nullable String quality, @Nullable String realQuality, @Nullable String format, @Nullable String size, @Nullable Long sizeBytes, @Nullable Integer count, @Nullable Long dateline, @Nullable Integer fid, @Nullable Integer mmfid, @Nullable Integer h265, @Nullable Integer hdr, @Nullable String filename, @Nullable Integer original, @Nullable Integer colorbit, @Nullable Integer success, @Nullable Integer timeout, @Nullable Integer vipLink, @Nullable Integer fps, @Nullable String bitstream, @Nullable Integer width, @Nullable Integer height) {
            return new LinkList(path, quality, realQuality, format, size, sizeBytes, count, dateline, fid, mmfid, h265, hdr, filename, original, colorbit, success, timeout, vipLink, fps, bitstream, width, height);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LinkList)) {
                return false;
            }
            LinkList linkList = (LinkList) other;
            return Intrinsics.areEqual(this.path, linkList.path) && Intrinsics.areEqual(this.quality, linkList.quality) && Intrinsics.areEqual(this.realQuality, linkList.realQuality) && Intrinsics.areEqual(this.format, linkList.format) && Intrinsics.areEqual(this.size, linkList.size) && Intrinsics.areEqual(this.sizeBytes, linkList.sizeBytes) && Intrinsics.areEqual(this.count, linkList.count) && Intrinsics.areEqual(this.dateline, linkList.dateline) && Intrinsics.areEqual(this.fid, linkList.fid) && Intrinsics.areEqual(this.mmfid, linkList.mmfid) && Intrinsics.areEqual(this.h265, linkList.h265) && Intrinsics.areEqual(this.hdr, linkList.hdr) && Intrinsics.areEqual(this.filename, linkList.filename) && Intrinsics.areEqual(this.original, linkList.original) && Intrinsics.areEqual(this.colorbit, linkList.colorbit) && Intrinsics.areEqual(this.success, linkList.success) && Intrinsics.areEqual(this.timeout, linkList.timeout) && Intrinsics.areEqual(this.vipLink, linkList.vipLink) && Intrinsics.areEqual(this.fps, linkList.fps) && Intrinsics.areEqual(this.bitstream, linkList.bitstream) && Intrinsics.areEqual(this.width, linkList.width) && Intrinsics.areEqual(this.height, linkList.height);
        }

        public int hashCode() {
            return ((((((((((((((((((((((((((((((((((((((((((this.path == null ? 0 : this.path.hashCode()) * 31) + (this.quality == null ? 0 : this.quality.hashCode())) * 31) + (this.realQuality == null ? 0 : this.realQuality.hashCode())) * 31) + (this.format == null ? 0 : this.format.hashCode())) * 31) + (this.size == null ? 0 : this.size.hashCode())) * 31) + (this.sizeBytes == null ? 0 : this.sizeBytes.hashCode())) * 31) + (this.count == null ? 0 : this.count.hashCode())) * 31) + (this.dateline == null ? 0 : this.dateline.hashCode())) * 31) + (this.fid == null ? 0 : this.fid.hashCode())) * 31) + (this.mmfid == null ? 0 : this.mmfid.hashCode())) * 31) + (this.h265 == null ? 0 : this.h265.hashCode())) * 31) + (this.hdr == null ? 0 : this.hdr.hashCode())) * 31) + (this.filename == null ? 0 : this.filename.hashCode())) * 31) + (this.original == null ? 0 : this.original.hashCode())) * 31) + (this.colorbit == null ? 0 : this.colorbit.hashCode())) * 31) + (this.success == null ? 0 : this.success.hashCode())) * 31) + (this.timeout == null ? 0 : this.timeout.hashCode())) * 31) + (this.vipLink == null ? 0 : this.vipLink.hashCode())) * 31) + (this.fps == null ? 0 : this.fps.hashCode())) * 31) + (this.bitstream == null ? 0 : this.bitstream.hashCode())) * 31) + (this.width == null ? 0 : this.width.hashCode())) * 31) + (this.height != null ? this.height.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("LinkList(path=").append(this.path).append(", quality=").append(this.quality).append(", realQuality=").append(this.realQuality).append(", format=").append(this.format).append(", size=").append(this.size).append(", sizeBytes=").append(this.sizeBytes).append(", count=").append(this.count).append(", dateline=").append(this.dateline).append(", fid=").append(this.fid).append(", mmfid=").append(this.mmfid).append(", h265=").append(this.h265).append(", hdr=");
            sb.append(this.hdr).append(", filename=").append(this.filename).append(", original=").append(this.original).append(", colorbit=").append(this.colorbit).append(", success=").append(this.success).append(", timeout=").append(this.timeout).append(", vipLink=").append(this.vipLink).append(", fps=").append(this.fps).append(", bitstream=").append(this.bitstream).append(", width=").append(this.width).append(", height=").append(this.height).append(')');
            return sb.toString();
        }

        public LinkList(@Nullable String path, @Nullable String quality, @Nullable String realQuality, @Nullable String format, @Nullable String size, @Nullable Long sizeBytes, @Nullable Integer count, @Nullable Long dateline, @Nullable Integer fid, @Nullable Integer mmfid, @Nullable Integer h265, @Nullable Integer hdr, @Nullable String filename, @Nullable Integer original, @Nullable Integer colorbit, @Nullable Integer success, @Nullable Integer timeout, @Nullable Integer vipLink, @Nullable Integer fps, @Nullable String bitstream, @Nullable Integer width, @Nullable Integer height) {
            this.path = path;
            this.quality = quality;
            this.realQuality = realQuality;
            this.format = format;
            this.size = size;
            this.sizeBytes = sizeBytes;
            this.count = count;
            this.dateline = dateline;
            this.fid = fid;
            this.mmfid = mmfid;
            this.h265 = h265;
            this.hdr = hdr;
            this.filename = filename;
            this.original = original;
            this.colorbit = colorbit;
            this.success = success;
            this.timeout = timeout;
            this.vipLink = vipLink;
            this.fps = fps;
            this.bitstream = bitstream;
            this.width = width;
            this.height = height;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ LinkList(String str, String str2, String str3, String str4, String str5, Long l, Integer num, Long l2, Integer num2, Integer num3, Integer num4, Integer num5, String str6, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, String str7, Integer num12, Integer num13, int i, DefaultConstructorMarker defaultConstructorMarker) {
            String str8 = (i & 1) != 0 ? null : str;
            String str9 = (i & 2) != 0 ? null : str2;
            String str10 = (i & 4) != 0 ? null : str3;
            String str11 = (i & 8) != 0 ? null : str4;
            String str12 = (i & 16) != 0 ? null : str5;
            Long l3 = (i & 32) != 0 ? null : l;
            Integer num14 = (i & 64) != 0 ? null : num;
            Long l4 = (i & 128) != 0 ? null : l2;
            Integer num15 = (i & 256) != 0 ? null : num2;
            Integer num16 = (i & 512) != 0 ? null : num3;
            Integer num17 = (i & 1024) != 0 ? null : num4;
            Integer num18 = (i & 2048) != 0 ? null : num5;
            String str13 = (i & 4096) != 0 ? null : str6;
            Integer num19 = (i & 8192) != 0 ? null : num6;
            Integer num20 = (i & 16384) != 0 ? null : num7;
            this(str8, str9, str10, str11, str12, l3, num14, l4, num15, num16, num17, num18, str13, num19, num20, (i & 32768) != 0 ? null : num8, (i & 65536) != 0 ? null : num9, (i & 131072) != 0 ? null : num10, (i & 262144) != 0 ? null : num11, (i & 524288) != 0 ? null : str7, (i & 1048576) != 0 ? null : num12, (i & 2097152) != 0 ? null : num13);
        }

        @Nullable
        public final String getPath() {
            return this.path;
        }

        @Nullable
        public final String getQuality() {
            return this.quality;
        }

        @Nullable
        public final String getRealQuality() {
            return this.realQuality;
        }

        @Nullable
        public final String getFormat() {
            return this.format;
        }

        @Nullable
        public final String getSize() {
            return this.size;
        }

        @Nullable
        public final Long getSizeBytes() {
            return this.sizeBytes;
        }

        @Nullable
        public final Integer getCount() {
            return this.count;
        }

        @Nullable
        public final Long getDateline() {
            return this.dateline;
        }

        @Nullable
        public final Integer getFid() {
            return this.fid;
        }

        @Nullable
        public final Integer getMmfid() {
            return this.mmfid;
        }

        @Nullable
        public final Integer getH265() {
            return this.h265;
        }

        @Nullable
        public final Integer getHdr() {
            return this.hdr;
        }

        @Nullable
        public final String getFilename() {
            return this.filename;
        }

        @Nullable
        public final Integer getOriginal() {
            return this.original;
        }

        @Nullable
        public final Integer getColorbit() {
            return this.colorbit;
        }

        @Nullable
        public final Integer getSuccess() {
            return this.success;
        }

        @Nullable
        public final Integer getTimeout() {
            return this.timeout;
        }

        @Nullable
        public final Integer getVipLink() {
            return this.vipLink;
        }

        @Nullable
        public final Integer getFps() {
            return this.fps;
        }

        @Nullable
        public final String getBitstream() {
            return this.bitstream;
        }

        @Nullable
        public final Integer getWidth() {
            return this.width;
        }

        @Nullable
        public final Integer getHeight() {
            return this.height;
        }
    }

    /* JADX INFO: compiled from: ShowBox.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012&\b\u0003\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012&\b\u0003\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0007j\b\u0012\u0004\u0012\u00020\u000b`\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0019\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tHÆ\u0003J\u0019\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0007j\b\u0012\u0004\u0012\u00020\u000b`\tHÆ\u0003Jx\u0010\u0017\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022&\b\u0003\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062&\b\u0003\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0007j\b\u0012\u0004\u0012\u00020\u000b`\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\nHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001d\u001a\u00020\bHÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR!\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R!\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0007j\b\u0012\u0004\u0012\u00020\u000b`\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/phisher98/ShowBox$ParsedLinkData;", "", "seconds", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "quality", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "list", "Lcom/phisher98/ShowBox$LinkList;", "<init>", "(Ljava/lang/Integer;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getSeconds", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getQuality", "()Ljava/util/ArrayList;", "getList", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/util/ArrayList;Ljava/util/ArrayList;)Lcom/phisher98/ShowBox$ParsedLinkData;", "equals", "", "other", "hashCode", "toString", "ShowBox"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class ParsedLinkData {

        @NotNull
        private final ArrayList<LinkList> list;

        @NotNull
        private final ArrayList<String> quality;

        @Nullable
        private final Integer seconds;

        public ParsedLinkData() {
            this(null, null, null, 7, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ParsedLinkData copy$default(ParsedLinkData parsedLinkData, Integer num, ArrayList arrayList, ArrayList arrayList2, int i, Object obj) {
            if ((i & 1) != 0) {
                num = parsedLinkData.seconds;
            }
            if ((i & 2) != 0) {
                arrayList = parsedLinkData.quality;
            }
            if ((i & 4) != 0) {
                arrayList2 = parsedLinkData.list;
            }
            return parsedLinkData.copy(num, arrayList, arrayList2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getSeconds() {
            return this.seconds;
        }

        @NotNull
        public final ArrayList<String> component2() {
            return this.quality;
        }

        @NotNull
        public final ArrayList<LinkList> component3() {
            return this.list;
        }

        @NotNull
        public final ParsedLinkData copy(@JsonProperty("seconds") @Nullable Integer seconds, @JsonProperty("quality") @NotNull ArrayList<String> quality, @JsonProperty("list") @NotNull ArrayList<LinkList> list) {
            return new ParsedLinkData(seconds, quality, list);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ParsedLinkData)) {
                return false;
            }
            ParsedLinkData parsedLinkData = (ParsedLinkData) other;
            return Intrinsics.areEqual(this.seconds, parsedLinkData.seconds) && Intrinsics.areEqual(this.quality, parsedLinkData.quality) && Intrinsics.areEqual(this.list, parsedLinkData.list);
        }

        public int hashCode() {
            return ((((this.seconds == null ? 0 : this.seconds.hashCode()) * 31) + this.quality.hashCode()) * 31) + this.list.hashCode();
        }

        @NotNull
        public String toString() {
            return "ParsedLinkData(seconds=" + this.seconds + ", quality=" + this.quality + ", list=" + this.list + ')';
        }

        public ParsedLinkData(@JsonProperty("seconds") @Nullable Integer seconds, @JsonProperty("quality") @NotNull ArrayList<String> arrayList, @JsonProperty("list") @NotNull ArrayList<LinkList> arrayList2) {
            this.seconds = seconds;
            this.quality = arrayList;
            this.list = arrayList2;
        }

        public /* synthetic */ ParsedLinkData(Integer num, ArrayList arrayList, ArrayList arrayList2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? new ArrayList() : arrayList, (i & 4) != 0 ? new ArrayList() : arrayList2);
        }

        @Nullable
        public final Integer getSeconds() {
            return this.seconds;
        }

        @NotNull
        public final ArrayList<String> getQuality() {
            return this.quality;
        }

        @NotNull
        public final ArrayList<LinkList> getList() {
            return this.list;
        }
    }

    /* JADX INFO: compiled from: ShowBox.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\tHÆ\u0003J\\\u0010\u0016\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\bHÆ\u0001¢\u0006\u0002\u0010\u0017J\u0014\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u0007HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/phisher98/ShowBox$SubtitleDataProp;", "", "code", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "msg", "", "data", "Lcom/phisher98/ShowBox$PrivateSubtitleData;", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/phisher98/ShowBox$PrivateSubtitleData;)V", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMsg", "()Ljava/lang/String;", "getData", "()Lcom/phisher98/ShowBox$PrivateSubtitleData;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/phisher98/ShowBox$PrivateSubtitleData;)Lcom/phisher98/ShowBox$SubtitleDataProp;", "equals", "", "other", "hashCode", "toString", "ShowBox"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class SubtitleDataProp {

        @Nullable
        private final Integer code;

        @Nullable
        private final PrivateSubtitleData data;

        @Nullable
        private final String msg;

        public SubtitleDataProp() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ SubtitleDataProp copy$default(SubtitleDataProp subtitleDataProp, Integer num, String str, PrivateSubtitleData privateSubtitleData, int i, Object obj) {
            if ((i & 1) != 0) {
                num = subtitleDataProp.code;
            }
            if ((i & 2) != 0) {
                str = subtitleDataProp.msg;
            }
            if ((i & 4) != 0) {
                privateSubtitleData = subtitleDataProp.data;
            }
            return subtitleDataProp.copy(num, str, privateSubtitleData);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getCode() {
            return this.code;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getMsg() {
            return this.msg;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final PrivateSubtitleData getData() {
            return this.data;
        }

        @NotNull
        public final SubtitleDataProp copy(@JsonProperty("code") @Nullable Integer code, @JsonProperty("msg") @Nullable String msg, @JsonProperty("data") @Nullable PrivateSubtitleData data) {
            return new SubtitleDataProp(code, msg, data);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SubtitleDataProp)) {
                return false;
            }
            SubtitleDataProp subtitleDataProp = (SubtitleDataProp) other;
            return Intrinsics.areEqual(this.code, subtitleDataProp.code) && Intrinsics.areEqual(this.msg, subtitleDataProp.msg) && Intrinsics.areEqual(this.data, subtitleDataProp.data);
        }

        public int hashCode() {
            return ((((this.code == null ? 0 : this.code.hashCode()) * 31) + (this.msg == null ? 0 : this.msg.hashCode())) * 31) + (this.data != null ? this.data.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "SubtitleDataProp(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ')';
        }

        public SubtitleDataProp(@JsonProperty("code") @Nullable Integer code, @JsonProperty("msg") @Nullable String msg, @JsonProperty("data") @Nullable PrivateSubtitleData data) {
            this.code = code;
            this.msg = msg;
            this.data = data;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ SubtitleDataProp(Integer num, String str, PrivateSubtitleData privateSubtitleData, int i, DefaultConstructorMarker defaultConstructorMarker) {
            ArrayList arrayList = null;
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? new PrivateSubtitleData(arrayList, arrayList, 3, arrayList) : privateSubtitleData);
        }

        @Nullable
        public final Integer getCode() {
            return this.code;
        }

        @Nullable
        public final String getMsg() {
            return this.msg;
        }

        @Nullable
        public final PrivateSubtitleData getData() {
            return this.data;
        }
    }

    /* JADX INFO: compiled from: ShowBox.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b&\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BÙ\u0002\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t\u0012\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b\u0012\u0018\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r\u0012\u0018\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e\u0012\u0018\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f\u0012\u0018\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0011\u0012\u0018\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0012\u0012\u0018\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0014:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0015\u0012\u0018\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010,\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u00101\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u00106\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010(J\u0010\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJà\u0002\u00108\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t2\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n2\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b2\u0018\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f2\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r2\u0018\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e2\u0018\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f2\u0018\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00112\u0018\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00122\u0018\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0014:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00152\u0018\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0016HÆ\u0001¢\u0006\u0002\u00109J\u0014\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010=\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010>\u001a\u00020\u0007HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b!\u0010\u001aR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b#\u0010\u001aR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b$\u0010\u001aR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b%\u0010\u001aR\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b&\u0010\u001aR\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010)\u001a\u0004\b'\u0010(R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b*\u0010\u001a¨\u0006?"}, d2 = {"Lcom/phisher98/ShowBox$Subtitles;", "", "sid", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "mid", "", "filePath", "file_path", "lang", "language", "delay", "point", "order", "support_total", "adminOrder", "admin_order", "myselect", "addTime", "", "add_time", "count", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;)V", "getSid", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMid", "()Ljava/lang/String;", "getFilePath", "getLang", "getLanguage", "getDelay", "getPoint", "getOrder", "getSupport_total", "getAdminOrder", "getMyselect", "getAddTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCount", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;)Lcom/phisher98/ShowBox$Subtitles;", "equals", "", "other", "hashCode", "toString", "ShowBox"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Subtitles {

        @Nullable
        private final Long addTime;

        @Nullable
        private final Integer adminOrder;

        @Nullable
        private final Integer count;

        @Nullable
        private final Integer delay;

        @Nullable
        private final String filePath;

        @Nullable
        private final String lang;

        @Nullable
        private final String language;

        @Nullable
        private final String mid;

        @Nullable
        private final Integer myselect;

        @Nullable
        private final Integer order;

        @Nullable
        private final String point;

        @Nullable
        private final Integer sid;

        @Nullable
        private final Integer support_total;

        public Subtitles() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
        }

        public static /* synthetic */ Subtitles copy$default(Subtitles subtitles, Integer num, String str, String str2, String str3, String str4, Integer num2, String str5, Integer num3, Integer num4, Integer num5, Integer num6, Long l, Integer num7, int i, Object obj) {
            if ((i & 1) != 0) {
                num = subtitles.sid;
            }
            return subtitles.copy(num, (i & 2) != 0 ? subtitles.mid : str, (i & 4) != 0 ? subtitles.filePath : str2, (i & 8) != 0 ? subtitles.lang : str3, (i & 16) != 0 ? subtitles.language : str4, (i & 32) != 0 ? subtitles.delay : num2, (i & 64) != 0 ? subtitles.point : str5, (i & 128) != 0 ? subtitles.order : num3, (i & 256) != 0 ? subtitles.support_total : num4, (i & 512) != 0 ? subtitles.adminOrder : num5, (i & 1024) != 0 ? subtitles.myselect : num6, (i & 2048) != 0 ? subtitles.addTime : l, (i & 4096) != 0 ? subtitles.count : num7);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getSid() {
            return this.sid;
        }

        @Nullable
        /* JADX INFO: renamed from: component10, reason: from getter */
        public final Integer getAdminOrder() {
            return this.adminOrder;
        }

        @Nullable
        /* JADX INFO: renamed from: component11, reason: from getter */
        public final Integer getMyselect() {
            return this.myselect;
        }

        @Nullable
        /* JADX INFO: renamed from: component12, reason: from getter */
        public final Long getAddTime() {
            return this.addTime;
        }

        @Nullable
        /* JADX INFO: renamed from: component13, reason: from getter */
        public final Integer getCount() {
            return this.count;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getMid() {
            return this.mid;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getFilePath() {
            return this.filePath;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getLang() {
            return this.lang;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getLanguage() {
            return this.language;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Integer getDelay() {
            return this.delay;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getPoint() {
            return this.point;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Integer getOrder() {
            return this.order;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final Integer getSupport_total() {
            return this.support_total;
        }

        @NotNull
        public final Subtitles copy(@JsonProperty("sid") @Nullable Integer sid, @JsonProperty("mid") @Nullable String mid, @JsonProperty("file_path") @Nullable String filePath, @JsonProperty("lang") @Nullable String lang, @JsonProperty("language") @Nullable String language, @JsonProperty("delay") @Nullable Integer delay, @JsonProperty("point") @Nullable String point, @JsonProperty("order") @Nullable Integer order, @JsonProperty("support_total") @Nullable Integer support_total, @JsonProperty("admin_order") @Nullable Integer adminOrder, @JsonProperty("myselect") @Nullable Integer myselect, @JsonProperty("add_time") @Nullable Long addTime, @JsonProperty("count") @Nullable Integer count) {
            return new Subtitles(sid, mid, filePath, lang, language, delay, point, order, support_total, adminOrder, myselect, addTime, count);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Subtitles)) {
                return false;
            }
            Subtitles subtitles = (Subtitles) other;
            return Intrinsics.areEqual(this.sid, subtitles.sid) && Intrinsics.areEqual(this.mid, subtitles.mid) && Intrinsics.areEqual(this.filePath, subtitles.filePath) && Intrinsics.areEqual(this.lang, subtitles.lang) && Intrinsics.areEqual(this.language, subtitles.language) && Intrinsics.areEqual(this.delay, subtitles.delay) && Intrinsics.areEqual(this.point, subtitles.point) && Intrinsics.areEqual(this.order, subtitles.order) && Intrinsics.areEqual(this.support_total, subtitles.support_total) && Intrinsics.areEqual(this.adminOrder, subtitles.adminOrder) && Intrinsics.areEqual(this.myselect, subtitles.myselect) && Intrinsics.areEqual(this.addTime, subtitles.addTime) && Intrinsics.areEqual(this.count, subtitles.count);
        }

        public int hashCode() {
            return ((((((((((((((((((((((((this.sid == null ? 0 : this.sid.hashCode()) * 31) + (this.mid == null ? 0 : this.mid.hashCode())) * 31) + (this.filePath == null ? 0 : this.filePath.hashCode())) * 31) + (this.lang == null ? 0 : this.lang.hashCode())) * 31) + (this.language == null ? 0 : this.language.hashCode())) * 31) + (this.delay == null ? 0 : this.delay.hashCode())) * 31) + (this.point == null ? 0 : this.point.hashCode())) * 31) + (this.order == null ? 0 : this.order.hashCode())) * 31) + (this.support_total == null ? 0 : this.support_total.hashCode())) * 31) + (this.adminOrder == null ? 0 : this.adminOrder.hashCode())) * 31) + (this.myselect == null ? 0 : this.myselect.hashCode())) * 31) + (this.addTime == null ? 0 : this.addTime.hashCode())) * 31) + (this.count != null ? this.count.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Subtitles(sid=").append(this.sid).append(", mid=").append(this.mid).append(", filePath=").append(this.filePath).append(", lang=").append(this.lang).append(", language=").append(this.language).append(", delay=").append(this.delay).append(", point=").append(this.point).append(", order=").append(this.order).append(", support_total=").append(this.support_total).append(", adminOrder=").append(this.adminOrder).append(", myselect=").append(this.myselect).append(", addTime=");
            sb.append(this.addTime).append(", count=").append(this.count).append(')');
            return sb.toString();
        }

        public Subtitles(@JsonProperty("sid") @Nullable Integer sid, @JsonProperty("mid") @Nullable String mid, @JsonProperty("file_path") @Nullable String filePath, @JsonProperty("lang") @Nullable String lang, @JsonProperty("language") @Nullable String language, @JsonProperty("delay") @Nullable Integer delay, @JsonProperty("point") @Nullable String point, @JsonProperty("order") @Nullable Integer order, @JsonProperty("support_total") @Nullable Integer support_total, @JsonProperty("admin_order") @Nullable Integer adminOrder, @JsonProperty("myselect") @Nullable Integer myselect, @JsonProperty("add_time") @Nullable Long addTime, @JsonProperty("count") @Nullable Integer count) {
            this.sid = sid;
            this.mid = mid;
            this.filePath = filePath;
            this.lang = lang;
            this.language = language;
            this.delay = delay;
            this.point = point;
            this.order = order;
            this.support_total = support_total;
            this.adminOrder = adminOrder;
            this.myselect = myselect;
            this.addTime = addTime;
            this.count = count;
        }

        public /* synthetic */ Subtitles(Integer num, String str, String str2, String str3, String str4, Integer num2, String str5, Integer num3, Integer num4, Integer num5, Integer num6, Long l, Integer num7, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : num2, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : num3, (i & 256) != 0 ? null : num4, (i & 512) != 0 ? null : num5, (i & 1024) != 0 ? null : num6, (i & 2048) != 0 ? null : l, (i & 4096) == 0 ? num7 : null);
        }

        @Nullable
        public final Integer getSid() {
            return this.sid;
        }

        @Nullable
        public final String getMid() {
            return this.mid;
        }

        @Nullable
        public final String getFilePath() {
            return this.filePath;
        }

        @Nullable
        public final String getLang() {
            return this.lang;
        }

        @Nullable
        public final String getLanguage() {
            return this.language;
        }

        @Nullable
        public final Integer getDelay() {
            return this.delay;
        }

        @Nullable
        public final String getPoint() {
            return this.point;
        }

        @Nullable
        public final Integer getOrder() {
            return this.order;
        }

        @Nullable
        public final Integer getSupport_total() {
            return this.support_total;
        }

        @Nullable
        public final Integer getAdminOrder() {
            return this.adminOrder;
        }

        @Nullable
        public final Integer getMyselect() {
            return this.myselect;
        }

        @Nullable
        public final Long getAddTime() {
            return this.addTime;
        }

        @Nullable
        public final Integer getCount() {
            return this.count;
        }
    }

    /* JADX INFO: compiled from: ShowBox.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012&\b\u0003\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tHÆ\u0003JK\u0010\u0012\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022&\b\u0003\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR!\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/phisher98/ShowBox$SubtitleList;", "", "language", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "subtitles", "Ljava/util/ArrayList;", "Lcom/phisher98/ShowBox$Subtitles;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/lang/String;Ljava/util/ArrayList;)V", "getLanguage", "()Ljava/lang/String;", "getSubtitles", "()Ljava/util/ArrayList;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ShowBox"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class SubtitleList {

        @Nullable
        private final String language;

        @NotNull
        private final ArrayList<Subtitles> subtitles;

        /* JADX WARN: Multi-variable type inference failed */
        public SubtitleList() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SubtitleList copy$default(SubtitleList subtitleList, String str, ArrayList arrayList, int i, Object obj) {
            if ((i & 1) != 0) {
                str = subtitleList.language;
            }
            if ((i & 2) != 0) {
                arrayList = subtitleList.subtitles;
            }
            return subtitleList.copy(str, arrayList);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getLanguage() {
            return this.language;
        }

        @NotNull
        public final ArrayList<Subtitles> component2() {
            return this.subtitles;
        }

        @NotNull
        public final SubtitleList copy(@JsonProperty("language") @Nullable String language, @JsonProperty("subtitles") @NotNull ArrayList<Subtitles> subtitles) {
            return new SubtitleList(language, subtitles);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SubtitleList)) {
                return false;
            }
            SubtitleList subtitleList = (SubtitleList) other;
            return Intrinsics.areEqual(this.language, subtitleList.language) && Intrinsics.areEqual(this.subtitles, subtitleList.subtitles);
        }

        public int hashCode() {
            return ((this.language == null ? 0 : this.language.hashCode()) * 31) + this.subtitles.hashCode();
        }

        @NotNull
        public String toString() {
            return "SubtitleList(language=" + this.language + ", subtitles=" + this.subtitles + ')';
        }

        public SubtitleList(@JsonProperty("language") @Nullable String language, @JsonProperty("subtitles") @NotNull ArrayList<Subtitles> arrayList) {
            this.language = language;
            this.subtitles = arrayList;
        }

        public /* synthetic */ SubtitleList(String str, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? new ArrayList() : arrayList);
        }

        @Nullable
        public final String getLanguage() {
            return this.language;
        }

        @NotNull
        public final ArrayList<Subtitles> getSubtitles() {
            return this.subtitles;
        }
    }

    /* JADX INFO: compiled from: ShowBox.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012&\b\u0003\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002\u0012&\b\u0003\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0003j\b\u0012\u0004\u0012\u00020\t`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J\u0019\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0003j\b\u0012\u0004\u0012\u00020\t`\u0005HÆ\u0003JY\u0010\u0011\u001a\u00020\u00002&\b\u0003\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u00022&\b\u0003\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0003j\b\u0012\u0004\u0012\u00020\t`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bHÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0004HÖ\u0081\u0004R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR!\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0003j\b\u0012\u0004\u0012\u00020\t`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/phisher98/ShowBox$PrivateSubtitleData;", "", "select", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "list", "Lcom/phisher98/ShowBox$SubtitleList;", "<init>", "(Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getSelect", "()Ljava/util/ArrayList;", "getList", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ShowBox"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class PrivateSubtitleData {

        @NotNull
        private final ArrayList<SubtitleList> list;

        @NotNull
        private final ArrayList<String> select;

        /* JADX WARN: Illegal instructions before constructor call */
        public PrivateSubtitleData() {
            ArrayList arrayList = null;
            this(arrayList, arrayList, 3, arrayList);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PrivateSubtitleData copy$default(PrivateSubtitleData privateSubtitleData, ArrayList arrayList, ArrayList arrayList2, int i, Object obj) {
            if ((i & 1) != 0) {
                arrayList = privateSubtitleData.select;
            }
            if ((i & 2) != 0) {
                arrayList2 = privateSubtitleData.list;
            }
            return privateSubtitleData.copy(arrayList, arrayList2);
        }

        @NotNull
        public final ArrayList<String> component1() {
            return this.select;
        }

        @NotNull
        public final ArrayList<SubtitleList> component2() {
            return this.list;
        }

        @NotNull
        public final PrivateSubtitleData copy(@JsonProperty("select") @NotNull ArrayList<String> select, @JsonProperty("list") @NotNull ArrayList<SubtitleList> list) {
            return new PrivateSubtitleData(select, list);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PrivateSubtitleData)) {
                return false;
            }
            PrivateSubtitleData privateSubtitleData = (PrivateSubtitleData) other;
            return Intrinsics.areEqual(this.select, privateSubtitleData.select) && Intrinsics.areEqual(this.list, privateSubtitleData.list);
        }

        public int hashCode() {
            return (this.select.hashCode() * 31) + this.list.hashCode();
        }

        @NotNull
        public String toString() {
            return "PrivateSubtitleData(select=" + this.select + ", list=" + this.list + ')';
        }

        public PrivateSubtitleData(@JsonProperty("select") @NotNull ArrayList<String> arrayList, @JsonProperty("list") @NotNull ArrayList<SubtitleList> arrayList2) {
            this.select = arrayList;
            this.list = arrayList2;
        }

        public /* synthetic */ PrivateSubtitleData(ArrayList arrayList, ArrayList arrayList2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new ArrayList() : arrayList, (i & 2) != 0 ? new ArrayList() : arrayList2);
        }

        @NotNull
        public final ArrayList<String> getSelect() {
            return this.select;
        }

        @NotNull
        public final ArrayList<SubtitleList> getList() {
            return this.list;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    static /* synthetic */ Object loadLinks$suspendImpl(ShowBox $this, String data, boolean isCasting, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super Boolean> continuation) {
        C00031 c00031;
        Object obj;
        char c;
        Object objDecodeFromString;
        char c2;
        boolean z;
        if (continuation instanceof C00031) {
            c00031 = (C00031) continuation;
            if ((c00031.label & Integer.MIN_VALUE) != 0) {
                c00031.label -= Integer.MIN_VALUE;
            } else {
                c00031 = $this.new C00031(continuation);
            }
        } else {
            c00031 = $this.new C00031(continuation);
        }
        C00031 c00032 = c00031;
        Object $result = c00032.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00032.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                AppUtils appUtils = AppUtils.INSTANCE;
                try {
                    Result.Companion companion = Result.Companion;
                    KType kTypeTypeOf = Reflection.typeOf(LinkData.class);
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                if (Result.exceptionOrNull-impl(obj) == null) {
                    c = 1;
                } else {
                    try {
                        Result.Companion companion3 = Result.Companion;
                        c = 1;
                        try {
                            obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(LinkData.class), (List) null, 2, (Object) null));
                        } catch (Throwable th2) {
                            th = th2;
                            Result.Companion companion4 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        c = 1;
                    }
                }
                if (Result.isFailure-impl(obj)) {
                    obj = null;
                }
                DeserializationStrategy deserializationStrategy = (KSerializer) obj;
                if (deserializationStrategy != null) {
                    try {
                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, data);
                        c2 = 2;
                    } catch (SerializationException e) {
                        ArchComponentExtKt.logError(e);
                        ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                        c2 = 2;
                        objDecodeFromString = $this$readValue$iv$iv.readValue(data, new TypeReference<LinkData>() { // from class: com.phisher98.ShowBox$loadLinks$suspendImpl$$inlined$parseJson$1
                        });
                    } catch (Throwable th4) {
                        ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                        c2 = 2;
                        objDecodeFromString = $this$readValue$iv$iv2.readValue(data, new TypeReference<LinkData>() { // from class: com.phisher98.ShowBox$loadLinks$suspendImpl$$inlined$parseJson$1
                        });
                    }
                } else {
                    ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                    c2 = 2;
                    objDecodeFromString = $this$readValue$iv$iv3.readValue(data, new TypeReference<LinkData>() { // from class: com.phisher98.ShowBox$loadLinks$suspendImpl$$inlined$parseJson$1
                    });
                }
                LinkData parsed = (LinkData) objDecodeFromString;
                Function1[] function1Arr = new Function1[5];
                function1Arr[0] = new C00042(parsed, $this, function2, null);
                function1Arr[c] = new C00053(parsed, function1, function2, null);
                function1Arr[c2] = new C00064(parsed, $this, function2, null);
                function1Arr[3] = new C00075(parsed, function1, null);
                function1Arr[4] = new C00086(parsed, function1, null);
                c00032.L$0 = SpillingKt.nullOutSpilledVariable($this);
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(data);
                c00032.L$2 = SpillingKt.nullOutSpilledVariable(function1);
                c00032.L$3 = SpillingKt.nullOutSpilledVariable(function2);
                c00032.L$4 = SpillingKt.nullOutSpilledVariable(parsed);
                c00032.Z$0 = isCasting;
                z = true;
                c00032.label = 1;
                if (ParCollectionsKt.runAllAsync(function1Arr, c00032) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                boolean z2 = c00032.Z$0;
                ResultKt.throwOnFailure($result);
                z = true;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Boxing.boxBoolean(z);
    }

    /* JADX INFO: renamed from: com.phisher98.ShowBox$loadLinks$2 */
    /* JADX INFO: compiled from: ShowBox.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.ShowBox$loadLinks$2", f = "ShowBox.kt", i = {}, l = {844}, m = "invokeSuspend", n = {}, nl = {852}, s = {}, v = 2)
    static final class C00042 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ LinkData $parsed;
        int label;
        final /* synthetic */ ShowBox this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00042(LinkData linkData, ShowBox showBox, Function1<? super ExtractorLink, Unit> function1, Continuation<? super C00042> continuation) {
            super(1, continuation);
            this.$parsed = linkData;
            this.this$0 = showBox;
            this.$callback = function1;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00042(this.$parsed, this.this$0, this.$callback, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (ShowBoxExtractor.INSTANCE.invokeExternalSource(this.$parsed.getMediaId(), Boxing.boxInt(this.$parsed.getType()), this.$parsed.getSeason(), this.$parsed.getEpisode(), this.this$0.getUitoken(), this.$callback, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.phisher98.ShowBox$loadLinks$3 */
    /* JADX INFO: compiled from: ShowBox.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.ShowBox$loadLinks$3", f = "ShowBox.kt", i = {}, l = {854}, m = "invokeSuspend", n = {}, nl = {863}, s = {}, v = 2)
    static final class C00053 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ LinkData $parsed;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00053(LinkData linkData, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super C00053> continuation) {
            super(1, continuation);
            this.$parsed = linkData;
            this.$subtitleCallback = function1;
            this.$callback = function2;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00053(this.$parsed, this.$subtitleCallback, this.$callback, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (ShowBoxExtractor.INSTANCE.invokeInternalSource(Boxing.boxInt(this.$parsed.getId()), Boxing.boxInt(this.$parsed.getType()), this.$parsed.getSeason(), this.$parsed.getEpisode(), ShowBox.Supertoken, this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.phisher98.ShowBox$loadLinks$4 */
    /* JADX INFO: compiled from: ShowBox.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.ShowBox$loadLinks$4", f = "ShowBox.kt", i = {}, l = {865}, m = "invokeSuspend", n = {}, nl = {873}, s = {}, v = 2)
    static final class C00064 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ LinkData $parsed;
        int label;
        final /* synthetic */ ShowBox this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00064(LinkData linkData, ShowBox showBox, Function1<? super ExtractorLink, Unit> function1, Continuation<? super C00064> continuation) {
            super(1, continuation);
            this.$parsed = linkData;
            this.this$0 = showBox;
            this.$callback = function1;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00064(this.$parsed, this.this$0, this.$callback, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (ShowBoxExtractor.INSTANCE.invokeExternalM3u8Source(this.$parsed.getMediaId(), Boxing.boxInt(this.$parsed.getType()), this.$parsed.getSeason(), this.$parsed.getEpisode(), this.this$0.getUitoken(), this.$callback, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.phisher98.ShowBox$loadLinks$5 */
    /* JADX INFO: compiled from: ShowBox.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.ShowBox$loadLinks$5", f = "ShowBox.kt", i = {}, l = {875}, m = "invokeSuspend", n = {}, nl = {881}, s = {}, v = 2)
    static final class C00075 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ LinkData $parsed;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00075(LinkData linkData, Function1<? super SubtitleFile, Unit> function1, Continuation<? super C00075> continuation) {
            super(1, continuation);
            this.$parsed = linkData;
            this.$subtitleCallback = function1;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00075(this.$parsed, this.$subtitleCallback, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (ShowBoxExtractor.INSTANCE.invokeOpenSubs(this.$parsed.getImdbId(), this.$parsed.getSeason(), this.$parsed.getEpisode(), this.$subtitleCallback, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.phisher98.ShowBox$loadLinks$6 */
    /* JADX INFO: compiled from: ShowBox.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.ShowBox$loadLinks$6", f = "ShowBox.kt", i = {}, l = {883}, m = "invokeSuspend", n = {}, nl = {889}, s = {}, v = 2)
    static final class C00086 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ LinkData $parsed;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00086(LinkData linkData, Function1<? super SubtitleFile, Unit> function1, Continuation<? super C00086> continuation) {
            super(1, continuation);
            this.$parsed = linkData;
            this.$subtitleCallback = function1;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00086(this.$parsed, this.$subtitleCallback, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (ShowBoxExtractor.INSTANCE.invokeWatchsomuch(this.$parsed.getImdbId(), this.$parsed.getSeason(), this.$parsed.getEpisode(), this.$subtitleCallback, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: ShowBox.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0013B!\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J#\u0010\u000b\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/phisher98/ShowBox$ExternalResponse;", "", "data", "Lcom/phisher98/ShowBox$ExternalResponse$Data;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Lcom/phisher98/ShowBox$ExternalResponse$Data;)V", "getData", "()Lcom/phisher98/ShowBox$ExternalResponse$Data;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Data", "ShowBox"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class ExternalResponse {

        @Nullable
        private final Data data;

        /* JADX WARN: Illegal instructions before constructor call */
        public ExternalResponse() {
            Data data = null;
            this(data, 1, data);
        }

        public static /* synthetic */ ExternalResponse copy$default(ExternalResponse externalResponse, Data data, int i, Object obj) {
            if ((i & 1) != 0) {
                data = externalResponse.data;
            }
            return externalResponse.copy(data);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Data getData() {
            return this.data;
        }

        @NotNull
        public final ExternalResponse copy(@JsonProperty("data") @Nullable Data data) {
            return new ExternalResponse(data);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ExternalResponse) && Intrinsics.areEqual(this.data, ((ExternalResponse) other).data);
        }

        public int hashCode() {
            if (this.data == null) {
                return 0;
            }
            return this.data.hashCode();
        }

        @NotNull
        public String toString() {
            return "ExternalResponse(data=" + this.data + ')';
        }

        public ExternalResponse(@JsonProperty("data") @Nullable Data data) {
            this.data = data;
        }

        public /* synthetic */ ExternalResponse(Data data, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : data);
        }

        @Nullable
        public final Data getData() {
            return this.data;
        }

        /* JADX INFO: compiled from: ShowBox.kt */
        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001dBg\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012*\b\u0003\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bHÆ\u0003Ji\u0010\u0016\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00072*\b\u0003\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\bHÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR%\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/phisher98/ShowBox$ExternalResponse$Data;", "", "link", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "shareLink", "share_link", "file_list", "Ljava/util/ArrayList;", "Lcom/phisher98/ShowBox$ExternalResponse$Data$FileList;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V", "getLink", "()Ljava/lang/String;", "getShareLink", "getFile_list", "()Ljava/util/ArrayList;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "FileList", "ShowBox"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final /* data */ class Data {

            @Nullable
            private final ArrayList<FileList> file_list;

            @Nullable
            private final String link;

            @Nullable
            private final String shareLink;

            public Data() {
                this(null, null, null, 7, null);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Data copy$default(Data data, String str, String str2, ArrayList arrayList, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = data.link;
                }
                if ((i & 2) != 0) {
                    str2 = data.shareLink;
                }
                if ((i & 4) != 0) {
                    arrayList = data.file_list;
                }
                return data.copy(str, str2, arrayList);
            }

            @Nullable
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getLink() {
                return this.link;
            }

            @Nullable
            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getShareLink() {
                return this.shareLink;
            }

            @Nullable
            public final ArrayList<FileList> component3() {
                return this.file_list;
            }

            @NotNull
            public final Data copy(@JsonProperty("link") @Nullable String link, @JsonProperty("share_link") @Nullable String shareLink, @JsonProperty("file_list") @Nullable ArrayList<FileList> file_list) {
                return new Data(link, shareLink, file_list);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Data)) {
                    return false;
                }
                Data data = (Data) other;
                return Intrinsics.areEqual(this.link, data.link) && Intrinsics.areEqual(this.shareLink, data.shareLink) && Intrinsics.areEqual(this.file_list, data.file_list);
            }

            public int hashCode() {
                return ((((this.link == null ? 0 : this.link.hashCode()) * 31) + (this.shareLink == null ? 0 : this.shareLink.hashCode())) * 31) + (this.file_list != null ? this.file_list.hashCode() : 0);
            }

            @NotNull
            public String toString() {
                return "Data(link=" + this.link + ", shareLink=" + this.shareLink + ", file_list=" + this.file_list + ')';
            }

            public Data(@JsonProperty("link") @Nullable String link, @JsonProperty("share_link") @Nullable String shareLink, @JsonProperty("file_list") @Nullable ArrayList<FileList> arrayList) {
                this.link = link;
                this.shareLink = shareLink;
                this.file_list = arrayList;
            }

            public /* synthetic */ Data(String str, String str2, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? new ArrayList() : arrayList);
            }

            @Nullable
            public final String getLink() {
                return this.link;
            }

            @Nullable
            public final String getShareLink() {
                return this.shareLink;
            }

            @Nullable
            public final ArrayList<FileList> getFile_list() {
                return this.file_list;
            }

            /* JADX INFO: compiled from: ShowBox.kt */
            @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\\\u0010\u0014\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\bHÆ\u0001¢\u0006\u0002\u0010\u0015J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0007HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0010\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/phisher98/ShowBox$ExternalResponse$Data$FileList;", "", "fid", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "file_name", "", "oss_fid", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;)V", "getFid", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getFile_name", "()Ljava/lang/String;", "getOss_fid", "component1", "component2", "component3", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;)Lcom/phisher98/ShowBox$ExternalResponse$Data$FileList;", "equals", "", "other", "hashCode", "", "toString", "ShowBox"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final /* data */ class FileList {

                @Nullable
                private final Long fid;

                @Nullable
                private final String file_name;

                @Nullable
                private final Long oss_fid;

                public FileList() {
                    this(null, null, null, 7, null);
                }

                public static /* synthetic */ FileList copy$default(FileList fileList, Long l, String str, Long l2, int i, Object obj) {
                    if ((i & 1) != 0) {
                        l = fileList.fid;
                    }
                    if ((i & 2) != 0) {
                        str = fileList.file_name;
                    }
                    if ((i & 4) != 0) {
                        l2 = fileList.oss_fid;
                    }
                    return fileList.copy(l, str, l2);
                }

                @Nullable
                /* JADX INFO: renamed from: component1, reason: from getter */
                public final Long getFid() {
                    return this.fid;
                }

                @Nullable
                /* JADX INFO: renamed from: component2, reason: from getter */
                public final String getFile_name() {
                    return this.file_name;
                }

                @Nullable
                /* JADX INFO: renamed from: component3, reason: from getter */
                public final Long getOss_fid() {
                    return this.oss_fid;
                }

                @NotNull
                public final FileList copy(@JsonProperty("fid") @Nullable Long fid, @JsonProperty("file_name") @Nullable String file_name, @JsonProperty("oss_fid") @Nullable Long oss_fid) {
                    return new FileList(fid, file_name, oss_fid);
                }

                public boolean equals(@Nullable Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof FileList)) {
                        return false;
                    }
                    FileList fileList = (FileList) other;
                    return Intrinsics.areEqual(this.fid, fileList.fid) && Intrinsics.areEqual(this.file_name, fileList.file_name) && Intrinsics.areEqual(this.oss_fid, fileList.oss_fid);
                }

                public int hashCode() {
                    return ((((this.fid == null ? 0 : this.fid.hashCode()) * 31) + (this.file_name == null ? 0 : this.file_name.hashCode())) * 31) + (this.oss_fid != null ? this.oss_fid.hashCode() : 0);
                }

                @NotNull
                public String toString() {
                    return "FileList(fid=" + this.fid + ", file_name=" + this.file_name + ", oss_fid=" + this.oss_fid + ')';
                }

                public FileList(@JsonProperty("fid") @Nullable Long fid, @JsonProperty("file_name") @Nullable String file_name, @JsonProperty("oss_fid") @Nullable Long oss_fid) {
                    this.fid = fid;
                    this.file_name = file_name;
                    this.oss_fid = oss_fid;
                }

                public /* synthetic */ FileList(Long l, String str, Long l2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : l2);
                }

                @Nullable
                public final Long getFid() {
                    return this.fid;
                }

                @Nullable
                public final String getFile_name() {
                    return this.file_name;
                }

                @Nullable
                public final Long getOss_fid() {
                    return this.oss_fid;
                }
            }
        }
    }

    /* JADX INFO: compiled from: ShowBox.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJv\u0010\u0015\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00072\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\bHÆ\u0001¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u001cHÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000f\u0010\fR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0010\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/phisher98/ShowBox$WatchsomuchTorrents;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "movieId", "season", "episode", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMovieId", "getSeason", "getEpisode", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/phisher98/ShowBox$WatchsomuchTorrents;", "equals", "", "other", "hashCode", "toString", "", "ShowBox"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class WatchsomuchTorrents {

        @Nullable
        private final Integer episode;

        @Nullable
        private final Integer id;

        @Nullable
        private final Integer movieId;

        @Nullable
        private final Integer season;

        public WatchsomuchTorrents() {
            this(null, null, null, null, 15, null);
        }

        public static /* synthetic */ WatchsomuchTorrents copy$default(WatchsomuchTorrents watchsomuchTorrents, Integer num, Integer num2, Integer num3, Integer num4, int i, Object obj) {
            if ((i & 1) != 0) {
                num = watchsomuchTorrents.id;
            }
            if ((i & 2) != 0) {
                num2 = watchsomuchTorrents.movieId;
            }
            if ((i & 4) != 0) {
                num3 = watchsomuchTorrents.season;
            }
            if ((i & 8) != 0) {
                num4 = watchsomuchTorrents.episode;
            }
            return watchsomuchTorrents.copy(num, num2, num3, num4);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getMovieId() {
            return this.movieId;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getSeason() {
            return this.season;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Integer getEpisode() {
            return this.episode;
        }

        @NotNull
        public final WatchsomuchTorrents copy(@JsonProperty("id") @Nullable Integer id, @JsonProperty("movieId") @Nullable Integer movieId, @JsonProperty("season") @Nullable Integer season, @JsonProperty("episode") @Nullable Integer episode) {
            return new WatchsomuchTorrents(id, movieId, season, episode);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WatchsomuchTorrents)) {
                return false;
            }
            WatchsomuchTorrents watchsomuchTorrents = (WatchsomuchTorrents) other;
            return Intrinsics.areEqual(this.id, watchsomuchTorrents.id) && Intrinsics.areEqual(this.movieId, watchsomuchTorrents.movieId) && Intrinsics.areEqual(this.season, watchsomuchTorrents.season) && Intrinsics.areEqual(this.episode, watchsomuchTorrents.episode);
        }

        public int hashCode() {
            return ((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.movieId == null ? 0 : this.movieId.hashCode())) * 31) + (this.season == null ? 0 : this.season.hashCode())) * 31) + (this.episode != null ? this.episode.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "WatchsomuchTorrents(id=" + this.id + ", movieId=" + this.movieId + ", season=" + this.season + ", episode=" + this.episode + ')';
        }

        public WatchsomuchTorrents(@JsonProperty("id") @Nullable Integer id, @JsonProperty("movieId") @Nullable Integer movieId, @JsonProperty("season") @Nullable Integer season, @JsonProperty("episode") @Nullable Integer episode) {
            this.id = id;
            this.movieId = movieId;
            this.season = season;
            this.episode = episode;
        }

        public /* synthetic */ WatchsomuchTorrents(Integer num, Integer num2, Integer num3, Integer num4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : num4);
        }

        @Nullable
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        public final Integer getMovieId() {
            return this.movieId;
        }

        @Nullable
        public final Integer getSeason() {
            return this.season;
        }

        @Nullable
        public final Integer getEpisode() {
            return this.episode;
        }
    }

    /* JADX INFO: compiled from: ShowBox.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J5\u0010\r\u001a\u00020\u00002*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R%\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/phisher98/ShowBox$WatchsomuchMovies;", "", "torrents", "Ljava/util/ArrayList;", "Lcom/phisher98/ShowBox$WatchsomuchTorrents;", "Lkotlin/collections/ArrayList;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Ljava/util/ArrayList;)V", "getTorrents", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ShowBox"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class WatchsomuchMovies {

        @Nullable
        private final ArrayList<WatchsomuchTorrents> torrents;

        /* JADX WARN: Illegal instructions before constructor call */
        public WatchsomuchMovies() {
            ArrayList arrayList = null;
            this(arrayList, 1, arrayList);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ WatchsomuchMovies copy$default(WatchsomuchMovies watchsomuchMovies, ArrayList arrayList, int i, Object obj) {
            if ((i & 1) != 0) {
                arrayList = watchsomuchMovies.torrents;
            }
            return watchsomuchMovies.copy(arrayList);
        }

        @Nullable
        public final ArrayList<WatchsomuchTorrents> component1() {
            return this.torrents;
        }

        @NotNull
        public final WatchsomuchMovies copy(@JsonProperty("torrents") @Nullable ArrayList<WatchsomuchTorrents> torrents) {
            return new WatchsomuchMovies(torrents);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof WatchsomuchMovies) && Intrinsics.areEqual(this.torrents, ((WatchsomuchMovies) other).torrents);
        }

        public int hashCode() {
            if (this.torrents == null) {
                return 0;
            }
            return this.torrents.hashCode();
        }

        @NotNull
        public String toString() {
            return "WatchsomuchMovies(torrents=" + this.torrents + ')';
        }

        public WatchsomuchMovies(@JsonProperty("torrents") @Nullable ArrayList<WatchsomuchTorrents> arrayList) {
            this.torrents = arrayList;
        }

        public /* synthetic */ WatchsomuchMovies(ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new ArrayList() : arrayList);
        }

        @Nullable
        public final ArrayList<WatchsomuchTorrents> getTorrents() {
            return this.torrents;
        }
    }

    /* JADX INFO: compiled from: ShowBox.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J#\u0010\u000b\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/phisher98/ShowBox$WatchsomuchResponses;", "", "movie", "Lcom/phisher98/ShowBox$WatchsomuchMovies;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Lcom/phisher98/ShowBox$WatchsomuchMovies;)V", "getMovie", "()Lcom/phisher98/ShowBox$WatchsomuchMovies;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ShowBox"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class WatchsomuchResponses {

        @Nullable
        private final WatchsomuchMovies movie;

        /* JADX WARN: Illegal instructions before constructor call */
        public WatchsomuchResponses() {
            WatchsomuchMovies watchsomuchMovies = null;
            this(watchsomuchMovies, 1, watchsomuchMovies);
        }

        public static /* synthetic */ WatchsomuchResponses copy$default(WatchsomuchResponses watchsomuchResponses, WatchsomuchMovies watchsomuchMovies, int i, Object obj) {
            if ((i & 1) != 0) {
                watchsomuchMovies = watchsomuchResponses.movie;
            }
            return watchsomuchResponses.copy(watchsomuchMovies);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final WatchsomuchMovies getMovie() {
            return this.movie;
        }

        @NotNull
        public final WatchsomuchResponses copy(@JsonProperty("movie") @Nullable WatchsomuchMovies movie) {
            return new WatchsomuchResponses(movie);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof WatchsomuchResponses) && Intrinsics.areEqual(this.movie, ((WatchsomuchResponses) other).movie);
        }

        public int hashCode() {
            if (this.movie == null) {
                return 0;
            }
            return this.movie.hashCode();
        }

        @NotNull
        public String toString() {
            return "WatchsomuchResponses(movie=" + this.movie + ')';
        }

        public WatchsomuchResponses(@JsonProperty("movie") @Nullable WatchsomuchMovies movie) {
            this.movie = movie;
        }

        public /* synthetic */ WatchsomuchResponses(WatchsomuchMovies watchsomuchMovies, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : watchsomuchMovies);
        }

        @Nullable
        public final WatchsomuchMovies getMovie() {
            return this.movie;
        }
    }

    /* JADX INFO: compiled from: ShowBox.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J=\u0010\u000e\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/phisher98/ShowBox$WatchsomuchSubtitles;", "", "url", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "label", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getLabel", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ShowBox"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class WatchsomuchSubtitles {

        @Nullable
        private final String label;

        @Nullable
        private final String url;

        /* JADX WARN: Illegal instructions before constructor call */
        public WatchsomuchSubtitles() {
            String str = null;
            this(str, str, 3, str);
        }

        public static /* synthetic */ WatchsomuchSubtitles copy$default(WatchsomuchSubtitles watchsomuchSubtitles, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = watchsomuchSubtitles.url;
            }
            if ((i & 2) != 0) {
                str2 = watchsomuchSubtitles.label;
            }
            return watchsomuchSubtitles.copy(str, str2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getLabel() {
            return this.label;
        }

        @NotNull
        public final WatchsomuchSubtitles copy(@JsonProperty("url") @Nullable String url, @JsonProperty("label") @Nullable String label) {
            return new WatchsomuchSubtitles(url, label);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WatchsomuchSubtitles)) {
                return false;
            }
            WatchsomuchSubtitles watchsomuchSubtitles = (WatchsomuchSubtitles) other;
            return Intrinsics.areEqual(this.url, watchsomuchSubtitles.url) && Intrinsics.areEqual(this.label, watchsomuchSubtitles.label);
        }

        public int hashCode() {
            return ((this.url == null ? 0 : this.url.hashCode()) * 31) + (this.label != null ? this.label.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "WatchsomuchSubtitles(url=" + this.url + ", label=" + this.label + ')';
        }

        public WatchsomuchSubtitles(@JsonProperty("url") @Nullable String url, @JsonProperty("label") @Nullable String label) {
            this.url = url;
            this.label = label;
        }

        public /* synthetic */ WatchsomuchSubtitles(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }

        @Nullable
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        public final String getLabel() {
            return this.label;
        }
    }

    /* JADX INFO: compiled from: ShowBox.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J5\u0010\r\u001a\u00020\u00002*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R%\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/phisher98/ShowBox$WatchsomuchSubResponses;", "", "subtitles", "Ljava/util/ArrayList;", "Lcom/phisher98/ShowBox$WatchsomuchSubtitles;", "Lkotlin/collections/ArrayList;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Ljava/util/ArrayList;)V", "getSubtitles", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ShowBox"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class WatchsomuchSubResponses {

        @Nullable
        private final ArrayList<WatchsomuchSubtitles> subtitles;

        /* JADX WARN: Illegal instructions before constructor call */
        public WatchsomuchSubResponses() {
            ArrayList arrayList = null;
            this(arrayList, 1, arrayList);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ WatchsomuchSubResponses copy$default(WatchsomuchSubResponses watchsomuchSubResponses, ArrayList arrayList, int i, Object obj) {
            if ((i & 1) != 0) {
                arrayList = watchsomuchSubResponses.subtitles;
            }
            return watchsomuchSubResponses.copy(arrayList);
        }

        @Nullable
        public final ArrayList<WatchsomuchSubtitles> component1() {
            return this.subtitles;
        }

        @NotNull
        public final WatchsomuchSubResponses copy(@JsonProperty("subtitles") @Nullable ArrayList<WatchsomuchSubtitles> subtitles) {
            return new WatchsomuchSubResponses(subtitles);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof WatchsomuchSubResponses) && Intrinsics.areEqual(this.subtitles, ((WatchsomuchSubResponses) other).subtitles);
        }

        public int hashCode() {
            if (this.subtitles == null) {
                return 0;
            }
            return this.subtitles.hashCode();
        }

        @NotNull
        public String toString() {
            return "WatchsomuchSubResponses(subtitles=" + this.subtitles + ')';
        }

        public WatchsomuchSubResponses(@JsonProperty("subtitles") @Nullable ArrayList<WatchsomuchSubtitles> arrayList) {
            this.subtitles = arrayList;
        }

        public /* synthetic */ WatchsomuchSubResponses(ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new ArrayList() : arrayList);
        }

        @Nullable
        public final ArrayList<WatchsomuchSubtitles> getSubtitles() {
            return this.subtitles;
        }
    }

    /* JADX INFO: compiled from: ShowBox.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J=\u0010\u000e\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/phisher98/ShowBox$OsSubtitles;", "", "url", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "lang", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getLang", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ShowBox"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class OsSubtitles {

        @Nullable
        private final String lang;

        @Nullable
        private final String url;

        /* JADX WARN: Illegal instructions before constructor call */
        public OsSubtitles() {
            String str = null;
            this(str, str, 3, str);
        }

        public static /* synthetic */ OsSubtitles copy$default(OsSubtitles osSubtitles, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = osSubtitles.url;
            }
            if ((i & 2) != 0) {
                str2 = osSubtitles.lang;
            }
            return osSubtitles.copy(str, str2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getLang() {
            return this.lang;
        }

        @NotNull
        public final OsSubtitles copy(@JsonProperty("url") @Nullable String url, @JsonProperty("lang") @Nullable String lang) {
            return new OsSubtitles(url, lang);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OsSubtitles)) {
                return false;
            }
            OsSubtitles osSubtitles = (OsSubtitles) other;
            return Intrinsics.areEqual(this.url, osSubtitles.url) && Intrinsics.areEqual(this.lang, osSubtitles.lang);
        }

        public int hashCode() {
            return ((this.url == null ? 0 : this.url.hashCode()) * 31) + (this.lang != null ? this.lang.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "OsSubtitles(url=" + this.url + ", lang=" + this.lang + ')';
        }

        public OsSubtitles(@JsonProperty("url") @Nullable String url, @JsonProperty("lang") @Nullable String lang) {
            this.url = url;
            this.lang = lang;
        }

        public /* synthetic */ OsSubtitles(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }

        @Nullable
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        public final String getLang() {
            return this.lang;
        }
    }

    /* JADX INFO: compiled from: ShowBox.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J5\u0010\r\u001a\u00020\u00002*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R%\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/phisher98/ShowBox$OsResult;", "", "subtitles", "Ljava/util/ArrayList;", "Lcom/phisher98/ShowBox$OsSubtitles;", "Lkotlin/collections/ArrayList;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Ljava/util/ArrayList;)V", "getSubtitles", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ShowBox"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class OsResult {

        @Nullable
        private final ArrayList<OsSubtitles> subtitles;

        /* JADX WARN: Illegal instructions before constructor call */
        public OsResult() {
            ArrayList arrayList = null;
            this(arrayList, 1, arrayList);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ OsResult copy$default(OsResult osResult, ArrayList arrayList, int i, Object obj) {
            if ((i & 1) != 0) {
                arrayList = osResult.subtitles;
            }
            return osResult.copy(arrayList);
        }

        @Nullable
        public final ArrayList<OsSubtitles> component1() {
            return this.subtitles;
        }

        @NotNull
        public final OsResult copy(@JsonProperty("subtitles") @Nullable ArrayList<OsSubtitles> subtitles) {
            return new OsResult(subtitles);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OsResult) && Intrinsics.areEqual(this.subtitles, ((OsResult) other).subtitles);
        }

        public int hashCode() {
            if (this.subtitles == null) {
                return 0;
            }
            return this.subtitles.hashCode();
        }

        @NotNull
        public String toString() {
            return "OsResult(subtitles=" + this.subtitles + ')';
        }

        public OsResult(@JsonProperty("subtitles") @Nullable ArrayList<OsSubtitles> arrayList) {
            this.subtitles = arrayList;
        }

        public /* synthetic */ OsResult(ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new ArrayList() : arrayList);
        }

        @Nullable
        public final ArrayList<OsSubtitles> getSubtitles() {
            return this.subtitles;
        }
    }
}
