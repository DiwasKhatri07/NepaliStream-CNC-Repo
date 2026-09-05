package com.MovieBox;

import android.content.SharedPreferences;
import android.util.Base64;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.kotlin.ExtensionsKt;
import com.lagradost.cloudstream3.ActorData;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.MainPageData;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.MovieLoadResponse;
import com.lagradost.cloudstream3.MovieSearchResponse;
import com.lagradost.cloudstream3.ParCollectionsKt;
import com.lagradost.cloudstream3.Score;
import com.lagradost.cloudstream3.SearchResponseList;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.net.URI;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: compiled from: MovieBoxProvider.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/MovieBoxProvider/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 d2\u00020\u0001:\u0001dB\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u001f\u001a\u00020\u0007H\u0002J\u0010\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010+\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0007H\u0002J\u0019\u0010,\u001a\u00020\u00072\n\b\u0002\u0010-\u001a\u0004\u0018\u00010&H\u0002¢\u0006\u0002\u0010.J>\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u00072\b\u00101\u001a\u0004\u0018\u00010\u00072\b\u00102\u001a\u0004\u0018\u00010\u00072\u0006\u00103\u001a\u00020\u00072\b\u00104\u001a\u0004\u0018\u00010\u00072\u0006\u00105\u001a\u00020&H\u0002JS\u00106\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u00072\b\u00101\u001a\u0004\u0018\u00010\u00072\b\u00102\u001a\u0004\u0018\u00010\u00072\u0006\u00103\u001a\u00020\u00072\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u00107\u001a\u00020\u00102\n\b\u0002\u0010-\u001a\u0004\u0018\u00010&H\u0002¢\u0006\u0002\u00108J\u0012\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010\u0007H\u0002J\u0018\u0010<\u001a\u00020\u00072\b\b\u0002\u0010=\u001a\u00020\u0010H\u0082@¢\u0006\u0002\u0010>J\u000e\u0010?\u001a\u00020\u0007H\u0082@¢\u0006\u0002\u0010@J\u0012\u0010A\u001a\u00020:2\b\u0010B\u001a\u0004\u0018\u00010\u0007H\u0002JT\u0010C\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070D2\u0006\u00100\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u00072\b\b\u0002\u00102\u001a\u00020\u00072\b\b\u0002\u00101\u001a\u00020\u00072\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010E\u001a\u00020\u0010H\u0082@¢\u0006\u0002\u0010FJ\u0014\u0010G\u001a\u0004\u0018\u00010\u00072\b\u0010H\u001a\u0004\u0018\u00010\u0007H\u0002J\u001e\u0010L\u001a\u00020N2\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020RH\u0096@¢\u0006\u0002\u0010SJ\u001e\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020\u00072\u0006\u0010O\u001a\u00020PH\u0096@¢\u0006\u0002\u0010WJ\u0016\u0010X\u001a\u00020Y2\u0006\u00103\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010ZJF\u0010[\u001a\u00020\u00102\u0006\u0010\\\u001a\u00020\u00072\u0006\u0010]\u001a\u00020\u00102\u0012\u0010^\u001a\u000e\u0012\u0004\u0012\u00020`\u0012\u0004\u0012\u00020:0_2\u0012\u0010a\u001a\u000e\u0012\u0004\u0012\u00020b\u0012\u0004\u0012\u00020:0_H\u0096@¢\u0006\u0002\u0010cR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\t\"\u0004\b\u0015\u0010\u000bR\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010 \u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\tR\u000e\u0010\"\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020&X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020K0JX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010M¨\u0006e"}, d2 = {"Lcom/MovieBox/MovieBoxProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "sharedPref", "Landroid/content/SharedPreferences;", "<init>", "(Landroid/content/SharedPreferences;)V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "secretKeyDefault", "secretKeyAlt", "random", "Ljava/security/SecureRandom;", "generateDeviceId", "deviceId", "getDeviceId", "modernUserAgent", "modernClientInfo", "PREF_TOKEN_KEY", "tokenTimestamp", "", "tokenTtlMs", "md5", "input", "", "reverseString", "generateXClientToken", "hardcodedTimestamp", "(Ljava/lang/Long;)Ljava/lang/String;", "buildCanonicalString", "method", "accept", "contentType", "url", "body", "timestamp", "generateXTrSignature", "useAltKey", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Long;)Ljava/lang/String;", "saveToken", "", "token", "fetchAnonymousToken", "forceRefresh", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCachedToken", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "persistTokenFromXUser", "xUserHeader", "buildAuthHeaders", "", "useToken", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "extractPolicyResource", "signCookie", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "Lcom/lagradost/cloudstream3/SearchResponseList;", "query", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "MovieBoxProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMovieBoxProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MovieBoxProvider.kt\ncom/MovieBox/MovieBoxProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 5 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 6 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,1185:1\n1795#2,10:1186\n2068#2:1196\n2069#2:1198\n1805#2:1199\n1221#2:1200\n2068#2,2:1201\n1795#2,10:1203\n2068#2:1213\n2069#2:1215\n1805#2:1216\n1795#2,10:1217\n2068#2:1227\n2069#2:1229\n1805#2:1230\n1849#2,8:1231\n1739#2:1239\n1814#2,3:1240\n2068#2,2:1243\n2068#2:1245\n2069#2:1253\n2068#2:1255\n296#2,2:1256\n2069#2:1265\n1#3:1197\n1#3:1214\n1#3:1228\n1#3:1258\n460#4,7:1246\n221#5:1254\n222#5:1266\n437#6:1259\n513#6,5:1260\n*S KotlinDebug\n*F\n+ 1 MovieBoxProvider.kt\ncom/MovieBox/MovieBoxProvider\n*L\n143#1:1186,10\n143#1:1196\n143#1:1198\n143#1:1199\n147#1:1200\n366#1:1201,2\n417#1:1203,10\n417#1:1213\n417#1:1215\n417#1:1216\n539#1:1217,10\n539#1:1227\n539#1:1229\n539#1:1230\n551#1:1231,8\n555#1:1239\n555#1:1240,3\n599#1:1243,2\n621#1:1245\n621#1:1253\n636#1:1255\n638#1:1256,2\n636#1:1265\n143#1:1197\n417#1:1214\n539#1:1228\n625#1:1246,7\n635#1:1254\n635#1:1266\n655#1:1259\n655#1:1260,5\n*E\n"})
public final class MovieBoxProvider extends MainAPI {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final List<String> HOST_POOL = CollectionsKt.listOf(new String[]{"https://api6.aoneroom.com", "https://api5.aoneroom.com", "https://api4.aoneroom.com", "https://api4sg.aoneroom.com", "https://api3.aoneroom.com"});

    @Nullable
    private static String bearerToken;

    @NotNull
    private final String PREF_TOKEN_KEY;

    @NotNull
    private final String deviceId;
    private final boolean hasMainPage;

    @NotNull
    private String lang;

    @NotNull
    private final List<MainPageData> mainPage;

    @NotNull
    private String mainUrl;

    @NotNull
    private final String modernClientInfo;

    @NotNull
    private final String modernUserAgent;

    @NotNull
    private String name;

    @NotNull
    private final SecureRandom random;

    @NotNull
    private final String secretKeyAlt;

    @NotNull
    private final String secretKeyDefault;

    @Nullable
    private final SharedPreferences sharedPref;

    @NotNull
    private final Set<TvType> supportedTypes;
    private long tokenTimestamp;
    private final long tokenTtlMs;

    /* JADX INFO: renamed from: com.MovieBox.MovieBoxProvider$buildAuthHeaders$1 */
    /* JADX INFO: compiled from: MovieBoxProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.MovieBox.MovieBoxProvider", f = "MovieBoxProvider.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {275}, m = "buildAuthHeaders", n = {"method", "url", "contentType", "accept", "body", "xClientToken", "xTrSig", "map", "useToken", "ts"}, nl = {276}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0", "J$0"}, v = 2)
    static final class C00001 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00001(Continuation<? super C00001> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MovieBoxProvider.this.buildAuthHeaders(null, null, null, null, null, false, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.MovieBox.MovieBoxProvider$fetchAnonymousToken$1 */
    /* JADX INFO: compiled from: MovieBoxProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.MovieBox.MovieBoxProvider", f = "MovieBoxProvider.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {226}, m = "fetchAnonymousToken", n = {"rankUrl", "xClientToken", "xTrSig", "headers", "forceRefresh", "now", "ts"}, nl = {227}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "J$0", "J$1"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00011(Continuation<? super C00011> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MovieBoxProvider.this.fetchAnonymousToken(false, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.MovieBox.MovieBoxProvider$getMainPage$1 */
    /* JADX INFO: compiled from: MovieBoxProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.MovieBox.MovieBoxProvider", f = "MovieBoxProvider.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7}, l = {384, 386, 391, 393, 401, 403, 406, 408}, m = "getMainPage", n = {"request", "url", "data1", "mainParts", "channelId", "options", "classify", "country", "year", "genre", "sort", "jsonBody", "page", "perPage", "pg", "request", "url", "data1", "mainParts", "channelId", "options", "classify", "country", "year", "genre", "sort", "jsonBody", "page", "perPage", "pg", "request", "url", "data1", "mainParts", "channelId", "options", "classify", "country", "year", "genre", "sort", "jsonBody", "headers", "requestBody", "page", "perPage", "pg", "request", "url", "data1", "mainParts", "channelId", "options", "classify", "country", "year", "genre", "sort", "jsonBody", "headers", "requestBody", "page", "perPage", "pg", "request", "url", "data1", "mainParts", "channelId", "options", "classify", "country", "year", "genre", "sort", "jsonBody", "headers", "requestBody", "response", "page", "perPage", "pg", "request", "url", "data1", "mainParts", "channelId", "options", "classify", "country", "year", "genre", "sort", "jsonBody", "headers", "requestBody", "response", "page", "perPage", "pg", "request", "url", "data1", "mainParts", "channelId", "options", "classify", "country", "year", "genre", "sort", "jsonBody", "headers", "requestBody", "response", "page", "perPage", "pg", "request", "url", "data1", "mainParts", "channelId", "options", "classify", "country", "year", "genre", "sort", "jsonBody", "headers", "requestBody", "response", "page", "perPage", "pg"}, nl = {386, 383, 393, 390, 403, 400, 408, 405}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "I$0", "I$1", "I$2"}, v = 2)
    static final class C00021 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C00021(Continuation<? super C00021> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MovieBoxProvider.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.MovieBox.MovieBoxProvider$load$1 */
    /* JADX INFO: compiled from: MovieBoxProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.MovieBox.MovieBoxProvider", f = "MovieBoxProvider.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, l = {505, 506, 512, 513, 574, 580, 588, 610, 611, 687, 702}, m = "load", n = {"url", "id", "finalUrl", "url", "id", "finalUrl", "headers", "url", "id", "finalUrl", "headers", "response", "url", "id", "finalUrl", "headers", "response", "url", "id", "finalUrl", "headers", "response", "body", "mapper", "root", "data", "title", "description", "releaseDate", "duration", "genre", "imdbRating", "year", "coverUrl", "backgroundUrl", "actors", "tags", "durationMinutes", "type", "subjectType", "url", "id", "finalUrl", "headers", "response", "body", "mapper", "root", "data", "title", "description", "releaseDate", "duration", "genre", "imdbRating", "year", "coverUrl", "backgroundUrl", "actors", "tags", "durationMinutes", "type", "tmdbId", "imdbId", "subjectType", "url", "id", "finalUrl", "headers", "response", "body", "mapper", "root", "data", "title", "description", "releaseDate", "duration", "genre", "imdbRating", "year", "coverUrl", "backgroundUrl", "actors", "tags", "durationMinutes", "type", "tmdbId", "imdbId", "logoUrl", "subjectType", "url", "id", "finalUrl", "headers", "response", "body", "mapper", "root", "data", "title", "description", "releaseDate", "duration", "genre", "imdbRating", "year", "coverUrl", "backgroundUrl", "actors", "tags", "durationMinutes", "type", "tmdbId", "imdbId", "logoUrl", "meta", "metaVideos", "Poster", "Background", "Description", "IMDBRating", "allSubjectIds", "episodeMap", "subjectId", "seasonUrl", "subjectType", "url", "id", "finalUrl", "headers", "response", "body", "mapper", "root", "data", "title", "description", "releaseDate", "duration", "genre", "imdbRating", "year", "coverUrl", "backgroundUrl", "actors", "tags", "durationMinutes", "type", "tmdbId", "imdbId", "logoUrl", "meta", "metaVideos", "Poster", "Background", "Description", "IMDBRating", "allSubjectIds", "episodeMap", "subjectId", "seasonUrl", "seasonHeaders", "subjectType", "url", "id", "finalUrl", "headers", "response", "body", "mapper", "root", "data", "title", "description", "releaseDate", "duration", "genre", "imdbRating", "year", "coverUrl", "backgroundUrl", "actors", "tags", "durationMinutes", "type", "tmdbId", "imdbId", "logoUrl", "meta", "metaVideos", "Poster", "Background", "Description", "IMDBRating", "allSubjectIds", "episodeMap", "episodes", "subjectType", "url", "id", "finalUrl", "headers", "response", "body", "mapper", "root", "data", "title", "description", "releaseDate", "duration", "genre", "imdbRating", "year", "coverUrl", "backgroundUrl", "actors", "tags", "durationMinutes", "type", "tmdbId", "imdbId", "logoUrl", "meta", "metaVideos", "Poster", "Background", "Description", "IMDBRating", "subjectType"}, nl = {506, 509, 513, 516, 580, 588, 589, 611, 612, 702, -1}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$28", "L$29", "L$30", "L$31", "L$32", "L$34", "L$35", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$28", "L$29", "L$30", "L$31", "L$32", "L$34", "L$35", "L$36", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$28", "L$29", "L$30", "L$31", "L$32", "L$33", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$28", "L$29", "L$30", "I$0"}, v = 2)
    static final class C00031 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$16;
        Object L$17;
        Object L$18;
        Object L$19;
        Object L$2;
        Object L$20;
        Object L$21;
        Object L$22;
        Object L$23;
        Object L$24;
        Object L$25;
        Object L$26;
        Object L$27;
        Object L$28;
        Object L$29;
        Object L$3;
        Object L$30;
        Object L$31;
        Object L$32;
        Object L$33;
        Object L$34;
        Object L$35;
        Object L$36;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C00031(Continuation<? super C00031> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MovieBoxProvider.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.MovieBox.MovieBoxProvider$loadLinks$1 */
    /* JADX INFO: compiled from: MovieBoxProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.MovieBox.MovieBoxProvider", f = "MovieBoxProvider.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}, l = {743, 744, 747, 748, 749, 778}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "parts", "originalSubjectId", "subjectUrl", "isCasting", "season", "episode", "data", "subtitleCallback", "callback", "parts", "originalSubjectId", "subjectUrl", "subjectHeaders", "isCasting", "season", "episode", "data", "subtitleCallback", "callback", "parts", "originalSubjectId", "subjectUrl", "subjectHeaders", "subjectResponse", "isCasting", "season", "episode", "data", "subtitleCallback", "callback", "parts", "originalSubjectId", "subjectUrl", "subjectHeaders", "subjectResponse", "isCasting", "season", "episode", "data", "subtitleCallback", "callback", "parts", "originalSubjectId", "subjectUrl", "subjectHeaders", "subjectResponse", "isCasting", "season", "episode", "data", "subtitleCallback", "callback", "parts", "originalSubjectId", "subjectUrl", "subjectHeaders", "subjectResponse", "subjectIds", "originalLanguageName", "isCasting", "season", "episode"}, nl = {744, 746, 748, 749, 752, 928}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "Z$0", "I$0", "I$1"}, v = 2)
    static final class C00061 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00061(Continuation<? super C00061> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MovieBoxProvider.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.MovieBox.MovieBoxProvider$search$1 */
    /* JADX INFO: compiled from: MovieBoxProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.MovieBox.MovieBoxProvider", f = "MovieBoxProvider.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3}, l = {452, 453, 458, 459}, m = "search", n = {"query", "url", "jsonBody", "requestBody", "page", "query", "url", "jsonBody", "requestBody", "headers", "page", "query", "url", "jsonBody", "requestBody", "headers", "response", "page", "query", "url", "jsonBody", "requestBody", "headers", "response", "page"}, nl = {453, 455, 459, 462}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0"}, v = 2)
    static final class C00081 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C00081(Continuation<? super C00081> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MovieBoxProvider.this.search(null, 0, (Continuation) this);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MovieBoxProvider() {
        SharedPreferences sharedPreferences = null;
        this(sharedPreferences, 1, sharedPreferences);
    }

    public MovieBoxProvider(@Nullable SharedPreferences sharedPref) {
        String string;
        this.sharedPref = sharedPref;
        SharedPreferences sharedPreferences = this.sharedPref;
        this.mainUrl = (sharedPreferences == null || (string = sharedPreferences.getString("moviebox_host", HOST_POOL.get(4))) == null) ? HOST_POOL.get(4) : string;
        this.name = "MovieBox";
        this.hasMainPage = true;
        this.lang = "hi";
        this.supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.TvSeries});
        this.secretKeyDefault = MainAPIKt.base64Decode("NzZpUmwwN3MweFNOOWpxbUVXQXQ3OUVCSlp1bElRSXNWNjRGWnIyTw==");
        this.secretKeyAlt = MainAPIKt.base64Decode("WHFuMm5uTzQxL0w5Mm8xaXVYaFNMSFRiWHZZNFo1Wlo2Mm04bVNMQQ==");
        this.random = new SecureRandom();
        this.deviceId = generateDeviceId();
        this.modernUserAgent = "com.community.mbox.in/50020126 (Linux; U; Android 14; en_IN; Pixel 8; Build/UD1A.230803.041; Cronet/145.0.7582.0)";
        this.modernClientInfo = "{\"package_name\":\"com.community.mbox.in\",\"version_name\":\"4.0.02.0831.03\",\"version_code\":50020126,\"os\":\"android\",\"os_version\":\"14\",\"device_id\":\"" + this.deviceId + "\",\"install_store\":\"official\",\"gaid\":\"1b2212c1-dadf-43c3-a0c8-bd6ce48ae22d\",\"brand\":\"Google\",\"model\":\"Pixel 8\",\"system_language\":\"en\",\"net\":\"NETWORK_WIFI\",\"region\":\"IN\",\"timezone\":\"Asia/Calcutta\",\"sp_code\":\"\"}";
        this.PREF_TOKEN_KEY = "moviebox_bearer_token_v3";
        this.tokenTtlMs = 3600000L;
        this.mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("4516404531735022304", "Trending"), TuplesKt.to("5692654647815587592", "Trending in Cinema"), TuplesKt.to("414907768299210008", "Bollywood"), TuplesKt.to("3859721901924910512", "South Indian"), TuplesKt.to("8019599703232971616", "Hollywood"), TuplesKt.to("4741626294545400336", "Top Series This Week"), TuplesKt.to("8434602210994128512", "Anime"), TuplesKt.to("1255898847918934600", "Reality TV"), TuplesKt.to("4903182713986896328", "Indian Drama"), TuplesKt.to("7878715743607948784", "Korean Drama"), TuplesKt.to("8788126208987989488", "Chinese Drama"), TuplesKt.to("3910636007619709856", "Western TV"), TuplesKt.to("5177200225164885656", "Turkish Drama"), TuplesKt.to("1|1", "Movies"), TuplesKt.to("1|2", "Series"), TuplesKt.to("1|1006", "Anime"), TuplesKt.to("1|1;country=India", "Indian (Movies)"), TuplesKt.to("1|2;country=India", "Indian (Series)"), TuplesKt.to("1|1;classify=Hindi dub;country=United States", "USA (Movies)"), TuplesKt.to("1|2;classify=Hindi dub;country=United States", "USA (Series)"), TuplesKt.to("1|1;country=Japan", "Japan (Movies)"), TuplesKt.to("1|2;country=Japan", "Japan (Series)"), TuplesKt.to("1|1;country=China", "China (Movies)"), TuplesKt.to("1|2;country=China", "China (Series)"), TuplesKt.to("1|1;country=Philippines", "Philippines (Movies)"), TuplesKt.to("1|2;country=Philippines", "Philippines (Series)"), TuplesKt.to("1|1;country=Thailand", "Thailand(Movies)"), TuplesKt.to("1|2;country=Thailand", "Thailand(Series)"), TuplesKt.to("1|1;country=Nigeria", "Nollywood (Movies)"), TuplesKt.to("1|2;country=Nigeria", "Nollywood (Series)"), TuplesKt.to("1|1;country=Korea", "South Korean (Movies)"), TuplesKt.to("1|2;country=Korea", "South Korean (Series)"), TuplesKt.to("1|1;classify=Hindi dub;genre=Action", "Action (Movies)"), TuplesKt.to("1|1;classify=Hindi dub;genre=Crime", "Crime (Movies)"), TuplesKt.to("1|1;classify=Hindi dub;genre=Comedy", "Comedy (Movies)"), TuplesKt.to("1|2;classify=Hindi dub;genre=Crime", "Crime (Series)"), TuplesKt.to("1|2;classify=Hindi dub;genre=Comedy", "Comedy (Series)")});
    }

    public /* synthetic */ MovieBoxProvider(SharedPreferences sharedPreferences, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : sharedPreferences);
    }

    /* JADX INFO: compiled from: MovieBoxProvider.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006J\u0010\u0010\u0011\u001a\u00020\u00122\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/MovieBox/MovieBoxProvider$Companion;", "", "<init>", "()V", "HOST_POOL", "", "", "getHOST_POOL", "()Ljava/util/List;", "bearerToken", "getBearerToken", "()Ljava/lang/String;", "setBearerToken", "(Ljava/lang/String;)V", "decodeJwtExpiry", "", "token", "isTokenValid", "", "MovieBoxProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nMovieBoxProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MovieBoxProvider.kt\ncom/MovieBox/MovieBoxProvider$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1185:1\n1#2:1186\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final List<String> getHOST_POOL() {
            return MovieBoxProvider.HOST_POOL;
        }

        @Nullable
        public final String getBearerToken() {
            return MovieBoxProvider.bearerToken;
        }

        public final void setBearerToken(@Nullable String str) {
            MovieBoxProvider.bearerToken = str;
        }

        public final long decodeJwtExpiry(@NotNull String token) {
            try {
                String payload = (String) CollectionsKt.getOrNull(StringsKt.split$default(token, new String[]{"."}, false, 0, 6, (Object) null), 1);
                if (payload == null) {
                    return 0L;
                }
                String it = StringsKt.replace$default(StringsKt.replace$default(payload, "-", "+", false, 4, (Object) null), "_", "/", false, 4, (Object) null);
                String padded = it + StringsKt.repeat("=", (4 - (it.length() % 4)) % 4);
                String json = new String(Base64.decode(padded, 0), Charsets.UTF_8);
                return new JSONObject(json).getLong("exp");
            } catch (Exception e) {
                return 0L;
            }
        }

        public final boolean isTokenValid(@Nullable String token) {
            String str = token;
            if (str == null || StringsKt.isBlank(str)) {
                return false;
            }
            long exp = decodeJwtExpiry(token);
            return exp > (System.currentTimeMillis() / 1000) + 3600;
        }
    }

    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    public void setMainUrl(@NotNull String str) {
        this.mainUrl = str;
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

    @NotNull
    public String getLang() {
        return this.lang;
    }

    public void setLang(@NotNull String str) {
        this.lang = str;
    }

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    private final String generateDeviceId() {
        byte[] bytes = new byte[16];
        this.random.nextBytes(bytes);
        return ArraysKt.joinToString$default(bytes, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.MovieBox.MovieBoxProvider$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return MovieBoxProvider.generateDeviceId$lambda$0(((Byte) obj).byteValue());
            }
        }, 30, (Object) null);
    }

    static final CharSequence generateDeviceId$lambda$0(byte it) {
        String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(it)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    @NotNull
    public final String getDeviceId() {
        return this.deviceId;
    }

    private final String md5(byte[] input) {
        return ArraysKt.joinToString$default(MessageDigest.getInstance("MD5").digest(input), "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.MovieBox.MovieBoxProvider$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                return MovieBoxProvider.md5$lambda$0(((Byte) obj).byteValue());
            }
        }, 30, (Object) null);
    }

    static final CharSequence md5$lambda$0(byte it) {
        String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(it)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    private final String reverseString(String input) {
        return StringsKt.reversed(input).toString();
    }

    static /* synthetic */ String generateXClientToken$default(MovieBoxProvider movieBoxProvider, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            l = null;
        }
        return movieBoxProvider.generateXClientToken(l);
    }

    private final String generateXClientToken(Long hardcodedTimestamp) {
        String timestamp = String.valueOf(hardcodedTimestamp != null ? hardcodedTimestamp.longValue() : System.currentTimeMillis());
        String reversed = reverseString(timestamp);
        byte[] bytes = reversed.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        String hash = md5(bytes);
        return timestamp + ',' + hash;
    }

    private final String buildCanonicalString(String method, String accept, String contentType, String url, String body, long timestamp) {
        URI parsed;
        String path;
        String query;
        byte[] bArr;
        String bodyHash;
        String bodyLength;
        Pair pair;
        try {
            try {
                parsed = new URI(url);
            } catch (Exception e) {
                parsed = null;
            }
        } catch (Exception e2) {
        }
        if (parsed == null || (path = parsed.getPath()) == null) {
            path = "";
        }
        String query2 = parsed != null ? parsed.getQuery() : null;
        int i = 1;
        if (query2 == null || StringsKt.isBlank(query2)) {
            query = "";
        } else {
            Iterable $this$mapNotNull$iv = StringsKt.split$default(parsed.getQuery(), new String[]{"&"}, false, 0, 6, (Object) null);
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                String it = (String) element$iv$iv$iv;
                List p = StringsKt.split$default(it, new String[]{"="}, false, 0, 6, (Object) null);
                if (p.isEmpty()) {
                    pair = null;
                } else {
                    Object obj = p.get(0);
                    String str = (String) CollectionsKt.getOrNull(p, i);
                    pair = TuplesKt.to(obj, str == null ? "" : str);
                }
                if (pair != null) {
                    destination$iv$iv.add(pair);
                }
                parsed = parsed;
                i = 1;
            }
            Iterable $this$sortedBy$iv = (List) destination$iv$iv;
            query = CollectionsKt.joinToString$default(CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: com.MovieBox.MovieBoxProvider$buildCanonicalString$$inlined$sortedBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    Pair it2 = (Pair) t;
                    String str2 = (String) it2.getFirst();
                    Pair it3 = (Pair) t2;
                    return ComparisonsKt.compareValues(str2, (String) it3.getFirst());
                }
            }), "&", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.MovieBox.MovieBoxProvider$$ExternalSyntheticLambda1
                public final Object invoke(Object obj2) {
                    return MovieBoxProvider.buildCanonicalString$lambda$2((Pair) obj2);
                }
            }, 30, (Object) null);
        }
        String canonicalUrl = query.length() > 0 ? path + '?' + query : path;
        if (body != null) {
            byte[] bytes = body.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            bArr = bytes;
        } else {
            bArr = null;
        }
        byte[] bodyBytes = bArr;
        if (bodyBytes != null) {
            byte[] trimmed = bodyBytes.length > 102400 ? ArraysKt.copyOfRange(bodyBytes, 0, 102400) : bodyBytes;
            bodyHash = md5(trimmed);
        } else {
            bodyHash = "";
        }
        if (bodyBytes == null || (bodyLength = String.valueOf(bodyBytes.length)) == null) {
            bodyLength = "";
        }
        StringBuilder sb = new StringBuilder();
        String upperCase = method.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return sb.append(upperCase).append('\n').append(accept == null ? "" : accept).append('\n').append(contentType != null ? contentType : "").append('\n').append(bodyLength).append('\n').append(timestamp).append('\n').append(bodyHash).append('\n').append(canonicalUrl).toString();
    }

    static final CharSequence buildCanonicalString$lambda$2(Pair it) {
        return ((String) it.getFirst()) + '=' + ((String) it.getSecond());
    }

    static /* synthetic */ String generateXTrSignature$default(MovieBoxProvider movieBoxProvider, String str, String str2, String str3, String str4, String str5, boolean z, Long l, int i, Object obj) {
        if ((i & 16) != 0) {
            str5 = null;
        }
        if ((i & 32) != 0) {
            z = false;
        }
        if ((i & 64) != 0) {
            l = null;
        }
        return movieBoxProvider.generateXTrSignature(str, str2, str3, str4, str5, z, l);
    }

    private final String generateXTrSignature(String method, String accept, String contentType, String url, String body, boolean useAltKey, Long hardcodedTimestamp) throws NoSuchAlgorithmException, InvalidKeyException {
        long timestamp = hardcodedTimestamp != null ? hardcodedTimestamp.longValue() : System.currentTimeMillis();
        String canonical = buildCanonicalString(method, accept, contentType, url, body, timestamp);
        String secret = useAltKey ? this.secretKeyAlt : this.secretKeyDefault;
        byte[] secretBytes = MainAPIKt.base64DecodeArray(secret);
        Mac mac = Mac.getInstance("HmacMD5");
        mac.init(new SecretKeySpec(secretBytes, "HmacMD5"));
        byte[] bytes = canonical.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] signature = mac.doFinal(bytes);
        String signatureB64 = MainAPIKt.base64Encode(signature);
        return timestamp + "|2|" + signatureB64;
    }

    private final void saveToken(String token) {
        SharedPreferences.Editor editorEdit;
        SharedPreferences.Editor editorPutString;
        String str = token;
        if (!(str == null || StringsKt.isBlank(str)) && INSTANCE.isTokenValid(token)) {
            bearerToken = token;
            this.tokenTimestamp = System.currentTimeMillis();
            SharedPreferences sharedPreferences = this.sharedPref;
            if (sharedPreferences == null || (editorEdit = sharedPreferences.edit()) == null || (editorPutString = editorEdit.putString(this.PREF_TOKEN_KEY, token)) == null) {
                return;
            }
            editorPutString.apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:50:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:52:0x01a6 A[Catch: Exception -> 0x01d8, TryCatch #4 {Exception -> 0x01d8, blocks: (B:44:0x0189, B:46:0x019a, B:52:0x01a6, B:54:0x01b6, B:56:0x01bd, B:58:0x01c2, B:62:0x01cc, B:64:0x01d0), top: B:94:0x0189 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x01b6 A[Catch: Exception -> 0x01d8, TryCatch #4 {Exception -> 0x01d8, blocks: (B:44:0x0189, B:46:0x019a, B:52:0x01a6, B:54:0x01b6, B:56:0x01bd, B:58:0x01c2, B:62:0x01cc, B:64:0x01d0), top: B:94:0x0189 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:60:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:62:0x01cc A[Catch: Exception -> 0x01d8, TryCatch #4 {Exception -> 0x01d8, blocks: (B:44:0x0189, B:46:0x019a, B:52:0x01a6, B:54:0x01b6, B:56:0x01bd, B:58:0x01c2, B:62:0x01cc, B:64:0x01d0), top: B:94:0x0189 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    /* JADX WARN: Code duplicated, block: B:83:0x01fe  */
    public final Object fetchAnonymousToken(boolean forceRefresh, Continuation<? super String> continuation) {
        C00011 c00011;
        long now;
        String str;
        long now2;
        Object obj;
        String xUser;
        String str2;
        boolean z;
        String str3;
        JsonNode jsonNode;
        String tok;
        String str4;
        if (continuation instanceof C00011) {
            c00011 = (C00011) continuation;
            if ((c00011.label & Integer.MIN_VALUE) != 0) {
                c00011.label -= Integer.MIN_VALUE;
            } else {
                c00011 = new C00011(continuation);
            }
        } else {
            c00011 = new C00011(continuation);
        }
        C00011 c00012 = c00011;
        Object $result = c00012.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00012.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                now = System.currentTimeMillis();
                if (!forceRefresh) {
                    if (INSTANCE.isTokenValid(bearerToken)) {
                        String str5 = bearerToken;
                        Intrinsics.checkNotNull(str5);
                        return str5;
                    }
                    SharedPreferences sharedPreferences = this.sharedPref;
                    String saved = sharedPreferences != null ? sharedPreferences.getString(this.PREF_TOKEN_KEY, null) : null;
                    if (INSTANCE.isTokenValid(saved)) {
                        bearerToken = saved;
                        Intrinsics.checkNotNull(saved);
                        return saved;
                    }
                }
                try {
                    long ts = System.currentTimeMillis();
                    String xClientToken = generateXClientToken(Boxing.boxLong(ts));
                    try {
                        str = null;
                        try {
                            String xTrSig = generateXTrSignature$default(this, "GET", "application/json", "application/json", "https://apig.inmoviebox.com/wefeed-mobile-bff/tab/ranking-list?tabId=0&categoryType=4516404531735022304&page=1&perPage=1", null, false, Boxing.boxLong(ts), 48, null);
                            Map headers = MapsKt.mapOf(new Pair[]{TuplesKt.to("user-agent", this.modernUserAgent), TuplesKt.to("accept", "application/json"), TuplesKt.to("content-type", "application/json"), TuplesKt.to("connection", "keep-alive"), TuplesKt.to("x-client-token", xClientToken), TuplesKt.to("x-tr-signature", xTrSig), TuplesKt.to("x-client-info", this.modernClientInfo), TuplesKt.to("x-client-status", "0")});
                            Requests app = MainActivityKt.getApp();
                            c00012.L$0 = SpillingKt.nullOutSpilledVariable("https://apig.inmoviebox.com/wefeed-mobile-bff/tab/ranking-list?tabId=0&categoryType=4516404531735022304&page=1&perPage=1");
                            c00012.L$1 = SpillingKt.nullOutSpilledVariable(xClientToken);
                            c00012.L$2 = SpillingKt.nullOutSpilledVariable(xTrSig);
                            c00012.L$3 = SpillingKt.nullOutSpilledVariable(headers);
                            c00012.Z$0 = forceRefresh;
                            now2 = now;
                            try {
                                c00012.J$0 = now2;
                                c00012.J$1 = ts;
                                c00012.label = 1;
                                try {
                                    Object obj2 = Requests.get$default(app, "https://apig.inmoviebox.com/wefeed-mobile-bff/tab/ranking-list?tabId=0&categoryType=4516404531735022304&page=1&perPage=1", headers, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00012, 4092, (Object) null);
                                    if (obj2 == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    obj = obj2;
                                    try {
                                        NiceResponse resp = (NiceResponse) obj;
                                        xUser = resp.getHeaders().get("x-user");
                                        str2 = xUser;
                                        if (str2 != null || StringsKt.isBlank(str2)) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        if (!z) {
                                            jsonNode = MainAPIKt.getMapper().readTree(xUser).get("token");
                                            if (jsonNode != null) {
                                                tok = jsonNode.asText();
                                            } else {
                                                tok = str;
                                            }
                                            str4 = tok;
                                            if (!(str4 != null || StringsKt.isBlank(str4))) {
                                                saveToken(tok);
                                                return tok;
                                            }
                                        }
                                        str3 = bearerToken;
                                        if (str3 == null) {
                                            return "";
                                        }
                                        return str3;
                                    } catch (Exception e) {
                                        now = now2;
                                        String str6 = bearerToken;
                                        return str6 != null ? str6 : "";
                                    }
                                } catch (Exception e2) {
                                    now = now2;
                                    String str7 = bearerToken;
                                    return str7 != null ? str7 : "";
                                }
                            } catch (Exception e3) {
                                now = now2;
                            }
                        } catch (Exception e4) {
                            now = now;
                        }
                    } catch (Exception e5) {
                        now = now;
                    }
                } catch (Exception e6) {
                }
                break;
            case 1:
                long j = c00012.J$1;
                now = c00012.J$0;
                boolean z2 = c00012.Z$0;
                try {
                    ResultKt.throwOnFailure($result);
                    str = null;
                    now2 = now;
                    obj = $result;
                    NiceResponse resp2 = (NiceResponse) obj;
                    xUser = resp2.getHeaders().get("x-user");
                    str2 = xUser;
                    if (str2 != null) {
                        z = true;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        jsonNode = MainAPIKt.getMapper().readTree(xUser).get("token");
                        if (jsonNode != null) {
                            tok = jsonNode.asText();
                        } else {
                            tok = str;
                        }
                        str4 = tok;
                        if (!(str4 != null || StringsKt.isBlank(str4))) {
                            saveToken(tok);
                            return tok;
                        }
                    }
                    str3 = bearerToken;
                    if (str3 == null) {
                        return "";
                    }
                    return str3;
                } catch (Exception e7) {
                    String str8 = bearerToken;
                    return str8 != null ? str8 : "";
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static /* synthetic */ Object fetchAnonymousToken$default(MovieBoxProvider movieBoxProvider, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return movieBoxProvider.fetchAnonymousToken(z, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getCachedToken(Continuation<? super String> continuation) {
        return fetchAnonymousToken(false, continuation);
    }

    private final void persistTokenFromXUser(String xUserHeader) {
        String token;
        String str = xUserHeader;
        if (str == null || StringsKt.isBlank(str)) {
            return;
        }
        try {
            JsonNode jsonNode = MainAPIKt.getMapper().readTree(xUserHeader).get("token");
            if (jsonNode != null && (token = jsonNode.asText()) != null) {
                saveToken(token);
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    public final Object buildAuthHeaders(String method, String url, String contentType, String accept, String body, boolean useToken, Continuation<? super Map<String, String>> continuation) {
        C00001 c00001;
        String xTrSig;
        String xTrSig2;
        Map map;
        long ts;
        if (continuation instanceof C00001) {
            c00001 = (C00001) continuation;
            if ((c00001.label & Integer.MIN_VALUE) != 0) {
                c00001.label -= Integer.MIN_VALUE;
            } else {
                c00001 = new C00001(continuation);
            }
        } else {
            c00001 = new C00001(continuation);
        }
        C00001 c00002 = c00001;
        Object $result = c00002.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00002.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                long ts2 = System.currentTimeMillis();
                String xClientToken = generateXClientToken(Boxing.boxLong(ts2));
                String xTrSig3 = generateXTrSignature$default(this, method, accept, contentType, url, body, false, Boxing.boxLong(ts2), 32, null);
                Map map2 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("user-agent", this.modernUserAgent), TuplesKt.to("accept", accept), TuplesKt.to("content-type", contentType), TuplesKt.to("connection", "keep-alive"), TuplesKt.to("x-client-token", xClientToken), TuplesKt.to("x-tr-signature", xTrSig3), TuplesKt.to("x-client-info", this.modernClientInfo), TuplesKt.to("x-client-status", "0")});
                if (!useToken) {
                    return map2;
                }
                c00002.L$0 = SpillingKt.nullOutSpilledVariable(method);
                c00002.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00002.L$2 = SpillingKt.nullOutSpilledVariable(contentType);
                c00002.L$3 = SpillingKt.nullOutSpilledVariable(accept);
                c00002.L$4 = SpillingKt.nullOutSpilledVariable(body);
                c00002.L$5 = SpillingKt.nullOutSpilledVariable(xClientToken);
                c00002.L$6 = SpillingKt.nullOutSpilledVariable(xTrSig3);
                c00002.L$7 = map2;
                c00002.Z$0 = useToken;
                c00002.J$0 = ts2;
                c00002.label = 1;
                Object objFetchAnonymousToken$default = fetchAnonymousToken$default(this, false, c00002, 1, null);
                if (objFetchAnonymousToken$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                xTrSig = xTrSig3;
                xTrSig2 = xClientToken;
                map = map2;
                $result = objFetchAnonymousToken$default;
                ts = ts2;
                break;
                break;
            case 1:
                ts = c00002.J$0;
                boolean z = c00002.Z$0;
                map = (Map) c00002.L$7;
                xTrSig = (String) c00002.L$6;
                xTrSig2 = (String) c00002.L$5;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String token = (String) $result;
        if (!StringsKt.isBlank(token)) {
            map.put("Authorization", "Bearer " + token);
        }
        return map;
    }

    static /* synthetic */ Object buildAuthHeaders$default(MovieBoxProvider movieBoxProvider, String str, String str2, String str3, String str4, String str5, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = "application/json";
        }
        if ((i & 8) != 0) {
            str4 = "application/json";
        }
        if ((i & 16) != 0) {
            str5 = null;
        }
        if ((i & 32) != 0) {
            z = true;
        }
        return movieBoxProvider.buildAuthHeaders(str, str2, str3, str4, str5, z, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String extractPolicyResource(String signCookie) {
        MatchResult match;
        Object obj;
        Object obj2;
        JsonNode jsonNode;
        JsonNode jsonNode2;
        String resource;
        String str = signCookie;
        if ((str == null || StringsKt.isBlank(str)) || (match = Regex.find$default(new Regex("CloudFront-Policy=([^;]+)"), signCookie, 0, 2, (Object) null)) == null) {
            return null;
        }
        String policyRaw = (String) match.getGroupValues().get(1);
        String cfB64 = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(policyRaw, '-', '+', false, 4, (Object) null), '~', '/', false, 4, (Object) null), '_', '=', false, 4, (Object) null);
        int cfRem = cfB64.length() % 4;
        String paddedCfB64 = cfRem > 0 ? cfB64 + StringsKt.repeat("=", 4 - cfRem) : cfB64;
        try {
            Result.Companion companion = Result.Companion;
            MovieBoxProvider movieBoxProvider = this;
            obj = Result.constructor-impl(MainAPIKt.base64Decode(paddedCfB64));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        String str2 = (String) obj;
        if (str2 == null) {
            try {
                Result.Companion companion3 = Result.Companion;
                MovieBoxProvider movieBoxProvider2 = this;
                String stdB64 = StringsKt.replace$default(StringsKt.replace$default(policyRaw, '-', '+', false, 4, (Object) null), '_', '/', false, 4, (Object) null);
                int stdRem = stdB64.length() % 4;
                String paddedStdB64 = stdRem > 0 ? stdB64 + StringsKt.repeat("=", 4 - stdRem) : stdB64;
                obj2 = Result.constructor-impl(MainAPIKt.base64Decode(paddedStdB64));
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.Companion;
                obj2 = Result.constructor-impl(ResultKt.createFailure(th2));
            }
            if (Result.isFailure-impl(obj2)) {
                obj2 = null;
            }
            str2 = (String) obj2;
            if (str2 == null) {
                return null;
            }
        }
        String decodedJson = str2;
        try {
            JsonNode root = MainAPIKt.getMapper().readTree(decodedJson);
            JsonNode jsonNode3 = root.get("Statement");
            if (jsonNode3 != null && (jsonNode = jsonNode3.get(0)) != null && (jsonNode2 = jsonNode.get("Resource")) != null && (resource = jsonNode2.asText()) != null) {
                String trimmed = StringsKt.trimEnd(resource, new char[]{'*', '/'});
                return StringsKt.endsWith(trimmed, ".mpd", true) ? trimmed : trimmed + "/index.mpd";
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    /* JADX WARN: Code duplicated, block: B:105:0x084b  */
    /* JADX WARN: Code duplicated, block: B:107:0x08c5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:108:0x08c6  */
    /* JADX WARN: Code duplicated, block: B:110:0x08f4  */
    /* JADX WARN: Code duplicated, block: B:112:0x0965 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:113:0x0966  */
    /* JADX WARN: Code duplicated, block: B:117:0x09ae  */
    /* JADX WARN: Code duplicated, block: B:119:0x0a3a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:120:0x0a3b  */
    /* JADX WARN: Code duplicated, block: B:122:0x0a69  */
    /* JADX WARN: Code duplicated, block: B:124:0x0aef A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:125:0x0af0  */
    /* JADX WARN: Code duplicated, block: B:136:0x0b4b A[Catch: Exception -> 0x0c53, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x0c53, blocks: (B:129:0x0b29, B:144:0x0b66, B:145:0x0b7f, B:147:0x0b85, B:149:0x0ba1, B:136:0x0b4b), top: B:198:0x0b29 }] */
    /* JADX WARN: Code duplicated, block: B:138:0x0b51 A[Catch: Exception -> 0x0b42, TRY_ENTER, TryCatch #1 {Exception -> 0x0b42, blocks: (B:131:0x0b39, B:138:0x0b51, B:141:0x0b5b), top: B:200:0x0b39 }] */
    /* JADX WARN: Code duplicated, block: B:139:0x0b58  */
    /* JADX WARN: Code duplicated, block: B:141:0x0b5b A[Catch: Exception -> 0x0b42, TRY_LEAVE, TryCatch #1 {Exception -> 0x0b42, blocks: (B:131:0x0b39, B:138:0x0b51, B:141:0x0b5b), top: B:200:0x0b39 }] */
    /* JADX WARN: Code duplicated, block: B:143:0x0b65  */
    /* JADX WARN: Code duplicated, block: B:147:0x0b85 A[Catch: Exception -> 0x0c53, TryCatch #0 {Exception -> 0x0c53, blocks: (B:129:0x0b29, B:144:0x0b66, B:145:0x0b7f, B:147:0x0b85, B:149:0x0ba1, B:136:0x0b4b), top: B:198:0x0b29 }] */
    /* JADX WARN: Code duplicated, block: B:149:0x0ba1 A[Catch: Exception -> 0x0c53, TRY_LEAVE, TryCatch #0 {Exception -> 0x0c53, blocks: (B:129:0x0b29, B:144:0x0b66, B:145:0x0b7f, B:147:0x0b85, B:149:0x0ba1, B:136:0x0b4b), top: B:198:0x0b29 }] */
    /* JADX WARN: Code duplicated, block: B:181:0x0c22  */
    /* JADX WARN: Code duplicated, block: B:184:0x0c2b A[Catch: Exception -> 0x0c51, TryCatch #2 {Exception -> 0x0c51, blocks: (B:154:0x0bb1, B:184:0x0c2b, B:157:0x0bb9, B:159:0x0bc3, B:162:0x0bca, B:164:0x0bd2, B:166:0x0bda, B:168:0x0be0, B:170:0x0be8, B:172:0x0bee, B:173:0x0bf1, B:177:0x0c00, B:174:0x0bf4, B:175:0x0bf9, B:187:0x0c41), top: B:202:0x0bb1 }] */
    /* JADX WARN: Code duplicated, block: B:185:0x0c32  */
    /* JADX WARN: Code duplicated, block: B:195:0x0c5d  */
    /* JADX WARN: Code duplicated, block: B:200:0x0b39 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x001e  */
    /* JADX WARN: Code duplicated, block: B:80:0x06d0  */
    /* JADX WARN: Code duplicated, block: B:82:0x0752 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:83:0x0753  */
    /* JADX WARN: Code duplicated, block: B:85:0x0773  */
    /* JADX WARN: Code duplicated, block: B:87:0x07e9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:88:0x07ea  */
    /* JADX WARN: Code duplicated, block: B:92:0x0812  */
    /* JADX WARN: Code duplicated, block: B:98:0x0826  */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        C00021 c00021;
        String url;
        Map options;
        Object $result;
        int perPage;
        String channelId;
        int pg;
        Object objBuildAuthHeaders$default;
        String sort;
        String country;
        String year;
        String classify;
        String genre;
        String jsonBody;
        String genre2;
        List mainParts;
        int perPage2;
        String channelId2;
        Object objBuildAuthHeaders$default2;
        String jsonBody2;
        String sort2;
        String year2;
        String genre3;
        String genre4;
        List mainParts2;
        Integer intOrNull;
        Map headers;
        String sort3;
        String genre5;
        String year3;
        int perPage3;
        Map options2;
        String data1;
        int page2;
        String url2;
        MainPageRequest request2;
        List mainParts3;
        String jsonBody3;
        String jsonBody4;
        String data2;
        List mainParts4;
        RequestBody requestBody;
        String channelId3;
        Map options3;
        String country2;
        JsonNode jsonNode;
        Object obj;
        Object $result2;
        String data3;
        List mainParts5;
        RequestBody requestBody2;
        String country3;
        String genre6;
        String classify2;
        String channelId4;
        MainPageRequest request3;
        int page3;
        String jsonBody5;
        RequestBody requestBody3;
        String genre7;
        String classify3;
        MainPageRequest request4;
        int perPage4;
        String url3;
        MainPageRequest request5;
        RequestBody requestBody4;
        NiceResponse niceResponse;
        Map headers2;
        String genre8;
        int pg2;
        String year4;
        NiceResponse response;
        SharedPreferences sharedPreferences;
        String jsonBody6;
        String url4;
        String year5;
        Object obj2;
        RequestBody requestBody5;
        Object objBuildAuthHeaders$default3;
        int pg3;
        int page4;
        MainPageRequest request6;
        RequestBody requestBody6;
        String genre9;
        Map headers3;
        NiceResponse response2;
        String jsonBody7;
        String sort4;
        String year6;
        RequestBody requestBody7;
        String url5;
        String year7;
        Object objBuildAuthHeaders$default4;
        String jsonBody8;
        int pg4;
        int page5;
        RequestBody requestBody8;
        String genre10;
        Map headers4;
        NiceResponse response3;
        String jsonBody9;
        String sort5;
        String year8;
        SharedPreferences.Editor editorEdit;
        SharedPreferences.Editor editorRemove;
        int page6;
        NiceResponse response4;
        String jsonBody10;
        int perPage5;
        String jsonBody11;
        String url6;
        RequestBody requestBody9;
        String year9;
        Map headers5;
        String genre11;
        String year10;
        int pg5;
        List mainParts6;
        int page7;
        String data4;
        List mainParts7;
        String channelId5;
        RequestBody requestBody10;
        String data5;
        List mainParts8;
        String classify4;
        int page8;
        int pg6;
        int perPage6;
        String genre12;
        String year11;
        NiceResponse response5;
        RequestBody requestBody11;
        MainPageRequest request7;
        String country4;
        RequestBody requestBody12;
        String data6;
        List mainParts9;
        String classify5;
        int page9;
        Map headers6;
        RequestBody requestBody13;
        MainPageRequest request8;
        String country5;
        NiceResponse niceResponse2;
        int page10;
        String responseBody;
        List listEmptyList;
        ObjectMapper mapper;
        JsonNode root;
        String str;
        JsonNode jsonNode2;
        JsonNode items;
        Collection destination$iv$iv;
        JsonNode jsonNode3;
        int page11;
        String responseBody2;
        RequestBody requestBody14;
        MovieSearchResponse movieSearchResponseNewMovieSearchResponse$default;
        Collection destination$iv$iv2;
        String strAsText;
        String id;
        TvType type;
        JsonNode jsonNode4;
        JsonNode jsonNode5;
        JsonNode jsonNode6;
        MovieBoxProvider movieBoxProvider = this;
        int page12 = page;
        MainPageRequest request9 = request;
        String str2 = "data";
        if (continuation instanceof C00021) {
            c00021 = (C00021) continuation;
            if ((c00021.label & Integer.MIN_VALUE) != 0) {
                c00021.label -= Integer.MIN_VALUE;
            } else {
                c00021 = movieBoxProvider.new C00021(continuation);
            }
        } else {
            c00021 = movieBoxProvider.new C00021(continuation);
        }
        C00021 c00022 = c00021;
        Object $result3 = c00022.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00022.label) {
            case 0:
                ResultKt.throwOnFailure($result3);
                url = (StringsKt.contains$default(request9.getData(), "|", false, 2, (Object) null) ? new StringBuilder().append(movieBoxProvider.getMainUrl()).append("/wefeed-mobile-bff/subject-api/list") : new StringBuilder().append(movieBoxProvider.getMainUrl()).append("/wefeed-mobile-bff/tab/ranking-list?tabId=0&categoryType=").append(request9.getData()).append("&page=").append(page12).append("&perPage=").append(15)).toString();
                String k = request9.getData();
                List mainParts10 = StringsKt.split$default(StringsKt.substringBefore$default(k, ";", (String) null, 2, (Object) null), new String[]{"|"}, false, 0, 6, (Object) null);
                String str3 = (String) CollectionsKt.getOrNull(mainParts10, 0);
                int pg7 = (str3 == null || (intOrNull = StringsKt.toIntOrNull(str3)) == null) ? 1 : intOrNull.intValue();
                String channelId6 = (String) CollectionsKt.getOrNull(mainParts10, 1);
                Map options4 = new LinkedHashMap();
                Iterable $this$forEach$iv = StringsKt.split$default(StringsKt.substringAfter(k, ";", ""), new String[]{";"}, false, 0, 6, (Object) null);
                int $i$f$forEach = 0;
                for (Object element$iv : $this$forEach$iv) {
                    String it = (String) element$iv;
                    Iterable $this$forEach$iv2 = $this$forEach$iv;
                    List p = StringsKt.split$default(it, new String[]{"="}, false, 0, 6, (Object) null);
                    String data7 = k;
                    int $i$f$forEach2 = $i$f$forEach;
                    List mainParts11 = mainParts10;
                    Pair pair = TuplesKt.to(CollectionsKt.getOrNull(p, 0), CollectionsKt.getOrNull(p, 1));
                    String k2 = (String) pair.component1();
                    String v = (String) pair.component2();
                    String str4 = k2;
                    if (!(str4 == null || StringsKt.isBlank(str4))) {
                        String str5 = v;
                        if (!(str5 == null || StringsKt.isBlank(str5))) {
                            options4.put(k2, v);
                        }
                    }
                    k = data7;
                    $i$f$forEach = $i$f$forEach2;
                    mainParts10 = mainParts11;
                    $this$forEach$iv = $this$forEach$iv2;
                }
                String data8 = k;
                List mainParts12 = mainParts10;
                String classify6 = (String) options4.get("classify");
                if (classify6 == null) {
                    classify6 = "All";
                }
                String country6 = (String) options4.get("country");
                if (country6 == null) {
                    country6 = "All";
                }
                String year12 = (String) options4.get("year");
                if (year12 == null) {
                    year12 = "All";
                }
                String genre13 = (String) options4.get("genre");
                if (genre13 == null) {
                    genre13 = "All";
                }
                String sort6 = (String) options4.get("sort");
                if (sort6 == null) {
                    sort6 = "ForYou";
                }
                options = options4;
                $result = $result3;
                String jsonBody12 = "{\"page\":" + pg7 + ",\"perPage\":15,\"channelId\":\"" + channelId6 + "\",\"classify\":\"" + classify6 + "\",\"country\":\"" + country6 + "\",\"year\":\"" + year12 + "\",\"genre\":\"" + genre13 + "\",\"sort\":\"" + sort6 + "\"}";
                String classify7 = classify6;
                String genre14 = genre13;
                String country7 = country6;
                String year13 = year12;
                if (StringsKt.contains$default(request9.getData(), "|", false, 2, (Object) null)) {
                    c00022.L$0 = request9;
                    c00022.L$1 = url;
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(data8);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts12);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId6);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(options);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(classify7);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(country7);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(year13);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre14);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort6);
                    c00022.L$11 = jsonBody12;
                    c00022.I$0 = page12;
                    c00022.I$1 = 15;
                    c00022.I$2 = pg7;
                    c00022.label = 1;
                    perPage2 = 15;
                    channelId2 = channelId6;
                    String sort7 = sort6;
                    pg = pg7;
                    objBuildAuthHeaders$default2 = buildAuthHeaders$default(this, "POST", url, "application/json; charset=utf-8", null, jsonBody12, false, c00022, 40, null);
                    if (objBuildAuthHeaders$default2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    jsonBody2 = jsonBody12;
                    sort2 = sort7;
                    country = country7;
                    year2 = year13;
                    classify = classify7;
                    genre3 = genre14;
                    genre4 = data8;
                    mainParts2 = mainParts12;
                    movieBoxProvider = this;
                    headers = (Map) objBuildAuthHeaders$default2;
                    sort3 = sort2;
                    genre5 = genre3;
                    year3 = year2;
                    perPage3 = perPage2;
                    options2 = options;
                    data1 = genre4;
                    page2 = page12;
                    url2 = url;
                    request2 = request9;
                    mainParts3 = mainParts2;
                    jsonBody3 = jsonBody2;
                    jsonBody4 = channelId2;
                    data2 = data1;
                    mainParts4 = mainParts3;
                    requestBody = RequestBody.Companion.create(jsonBody3, MediaType.Companion.get("application/json"));
                    channelId3 = jsonBody4;
                    options3 = options2;
                    country2 = country;
                    if (StringsKt.contains$default(request2.getData(), "|", false, 2, (Object) null)) {
                        Requests app = MainActivityKt.getApp();
                        c00022.L$0 = request2;
                        c00022.L$1 = url2;
                        c00022.L$2 = SpillingKt.nullOutSpilledVariable(data2);
                        c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts4);
                        c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId3);
                        c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                        c00022.L$6 = SpillingKt.nullOutSpilledVariable(classify);
                        c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                        c00022.L$8 = SpillingKt.nullOutSpilledVariable(year3);
                        c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre5);
                        c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort3);
                        c00022.L$11 = jsonBody3;
                        c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers);
                        c00022.L$13 = requestBody;
                        c00022.I$0 = page2;
                        c00022.I$1 = perPage3;
                        c00022.I$2 = pg;
                        c00022.label = 3;
                        obj = coroutine_suspended;
                        $result2 = $result;
                        jsonNode = null;
                        $result3 = Requests.post$default(app, url2, headers, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                        if ($result3 == obj) {
                            return obj;
                        }
                        data3 = data2;
                        mainParts5 = mainParts4;
                        requestBody3 = requestBody;
                        country3 = classify;
                        genre7 = genre5;
                        classify3 = year3;
                        channelId4 = channelId3;
                        request4 = request2;
                        page3 = page2;
                        jsonBody5 = jsonBody3;
                        String str6 = url2;
                        perPage4 = perPage3;
                        url3 = str6;
                        request5 = request4;
                        requestBody4 = requestBody3;
                        niceResponse = (NiceResponse) $result3;
                        headers2 = headers;
                        genre8 = genre7;
                        pg2 = pg;
                        year4 = classify3;
                        response = niceResponse;
                        if (response.getCode() != 401 || response.getCode() == 441) {
                            bearerToken = jsonNode;
                            sharedPreferences = movieBoxProvider.sharedPref;
                            if (sharedPreferences != null && (editorEdit = sharedPreferences.edit()) != null && (editorRemove = editorEdit.remove(movieBoxProvider.PREF_TOKEN_KEY)) != null) {
                                editorRemove.apply();
                                Unit unit = Unit.INSTANCE;
                            }
                            if (StringsKt.contains$default(request5.getData(), "|", false, 2, jsonNode)) {
                                c00022.L$0 = request5;
                                c00022.L$1 = url3;
                                c00022.L$2 = SpillingKt.nullOutSpilledVariable(data3);
                                c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts5);
                                c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId4);
                                c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                                c00022.L$6 = SpillingKt.nullOutSpilledVariable(country3);
                                c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                                c00022.L$8 = SpillingKt.nullOutSpilledVariable(year4);
                                c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre8);
                                c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort3);
                                c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody5);
                                c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers2);
                                c00022.L$13 = requestBody4;
                                c00022.L$14 = SpillingKt.nullOutSpilledVariable(response);
                                c00022.I$0 = page3;
                                c00022.I$1 = perPage4;
                                c00022.I$2 = pg2;
                                c00022.label = 5;
                                requestBody7 = requestBody4;
                                url5 = url3;
                                year7 = year4;
                                obj2 = obj;
                                objBuildAuthHeaders$default4 = buildAuthHeaders$default(this, "POST", url5, "application/json; charset=utf-8", null, jsonBody5, false, c00022, 40, null);
                                jsonBody8 = jsonBody5;
                                if (objBuildAuthHeaders$default4 == obj2) {
                                    return obj2;
                                }
                                int i = pg2;
                                $result3 = objBuildAuthHeaders$default4;
                                pg4 = i;
                                page5 = page3;
                                request6 = request5;
                                requestBody8 = requestBody7;
                                genre10 = genre8;
                                headers4 = headers2;
                                response3 = response;
                                jsonBody9 = jsonBody8;
                                sort5 = sort3;
                                year8 = year7;
                                response4 = response3;
                                jsonBody10 = jsonBody9;
                                perPage5 = perPage4;
                                jsonBody11 = url5;
                                url6 = channelId4;
                                requestBody9 = requestBody8;
                                year9 = year8;
                                headers5 = (Map) $result3;
                                genre11 = country3;
                                year10 = data3;
                                pg5 = pg4;
                                mainParts6 = mainParts5;
                                page7 = page5;
                                data4 = year10;
                                mainParts7 = mainParts6;
                                channelId5 = url6;
                                jsonNode = null;
                                if (StringsKt.contains$default(request6.getData(), "|", false, 2, (Object) null)) {
                                    Requests app2 = MainActivityKt.getApp();
                                    c00022.L$0 = request6;
                                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(jsonBody11);
                                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts7);
                                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId5);
                                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(genre11);
                                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(year9);
                                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre10);
                                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort5);
                                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody10);
                                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers5);
                                    c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody9);
                                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(response4);
                                    c00022.I$0 = page7;
                                    c00022.I$1 = perPage5;
                                    c00022.I$2 = pg5;
                                    c00022.label = 7;
                                    $result3 = Requests.post$default(app2, jsonBody11, headers5, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody9, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                                    requestBody12 = requestBody9;
                                    if ($result3 == obj2) {
                                        return obj2;
                                    }
                                    data6 = data4;
                                    mainParts9 = mainParts7;
                                    classify5 = genre11;
                                    page9 = page7;
                                    pg6 = pg5;
                                    headers6 = headers5;
                                    requestBody13 = requestBody12;
                                    request8 = request6;
                                    country5 = country2;
                                    niceResponse2 = (NiceResponse) $result3;
                                    request5 = request8;
                                    page10 = page9;
                                    response = niceResponse2;
                                    requestBody4 = requestBody13;
                                    page6 = page10;
                                } else {
                                    requestBody10 = requestBody9;
                                    Requests app3 = MainActivityKt.getApp();
                                    c00022.L$0 = request6;
                                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(jsonBody11);
                                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts7);
                                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId5);
                                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(genre11);
                                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(year9);
                                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre10);
                                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort5);
                                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody10);
                                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers5);
                                    c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody10);
                                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(response4);
                                    c00022.I$0 = page7;
                                    c00022.I$1 = perPage5;
                                    c00022.I$2 = pg5;
                                    c00022.label = 8;
                                    $result3 = Requests.get$default(app3, jsonBody11, headers5, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                                    if ($result3 == obj2) {
                                        return obj2;
                                    }
                                    data5 = data4;
                                    mainParts8 = mainParts7;
                                    classify4 = genre11;
                                    page8 = page7;
                                    pg6 = pg5;
                                    perPage6 = perPage5;
                                    genre12 = genre10;
                                    year11 = year9;
                                    response5 = response4;
                                    requestBody11 = requestBody10;
                                    request7 = request6;
                                    country4 = country2;
                                    niceResponse2 = (NiceResponse) $result3;
                                    requestBody13 = requestBody11;
                                    request5 = request7;
                                    page10 = page8;
                                    response = niceResponse2;
                                    requestBody4 = requestBody13;
                                    page6 = page10;
                                }
                            } else {
                                jsonBody6 = jsonBody5;
                                url4 = url3;
                                year5 = year4;
                                obj2 = obj;
                                requestBody5 = requestBody4;
                                c00022.L$0 = request5;
                                c00022.L$1 = url4;
                                c00022.L$2 = SpillingKt.nullOutSpilledVariable(data3);
                                c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts5);
                                c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId4);
                                c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                                c00022.L$6 = SpillingKt.nullOutSpilledVariable(country3);
                                c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                                c00022.L$8 = SpillingKt.nullOutSpilledVariable(year5);
                                c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre8);
                                c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort3);
                                c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody6);
                                c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers2);
                                c00022.L$13 = requestBody5;
                                c00022.L$14 = SpillingKt.nullOutSpilledVariable(response);
                                c00022.I$0 = page3;
                                c00022.I$1 = perPage4;
                                c00022.I$2 = pg2;
                                c00022.label = 6;
                                objBuildAuthHeaders$default3 = buildAuthHeaders$default(this, "GET", url4, null, null, null, false, c00022, 60, null);
                                if (objBuildAuthHeaders$default3 == obj2) {
                                    return obj2;
                                }
                                int i2 = pg2;
                                $result3 = objBuildAuthHeaders$default3;
                                pg3 = i2;
                                page4 = page3;
                                request6 = request5;
                                requestBody6 = requestBody5;
                                genre9 = genre8;
                                headers3 = headers2;
                                response2 = response;
                                jsonBody7 = jsonBody6;
                                sort4 = sort3;
                                year6 = year5;
                                response4 = response2;
                                jsonBody10 = jsonBody7;
                                sort5 = sort4;
                                perPage5 = perPage4;
                                jsonBody11 = url4;
                                genre10 = genre9;
                                url6 = channelId4;
                                requestBody9 = requestBody6;
                                year9 = year6;
                                headers5 = (Map) $result3;
                                page7 = page4;
                                year10 = data3;
                                genre11 = country3;
                                pg5 = pg3;
                                mainParts6 = mainParts5;
                                data4 = year10;
                                mainParts7 = mainParts6;
                                channelId5 = url6;
                                jsonNode = null;
                                if (StringsKt.contains$default(request6.getData(), "|", false, 2, (Object) null)) {
                                    Requests app4 = MainActivityKt.getApp();
                                    c00022.L$0 = request6;
                                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(jsonBody11);
                                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts7);
                                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId5);
                                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(genre11);
                                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(year9);
                                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre10);
                                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort5);
                                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody10);
                                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers5);
                                    c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody9);
                                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(response4);
                                    c00022.I$0 = page7;
                                    c00022.I$1 = perPage5;
                                    c00022.I$2 = pg5;
                                    c00022.label = 7;
                                    $result3 = Requests.post$default(app4, jsonBody11, headers5, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody9, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                                    requestBody12 = requestBody9;
                                    if ($result3 == obj2) {
                                        return obj2;
                                    }
                                    data6 = data4;
                                    mainParts9 = mainParts7;
                                    classify5 = genre11;
                                    page9 = page7;
                                    pg6 = pg5;
                                    headers6 = headers5;
                                    requestBody13 = requestBody12;
                                    request8 = request6;
                                    country5 = country2;
                                    niceResponse2 = (NiceResponse) $result3;
                                    request5 = request8;
                                    page10 = page9;
                                    response = niceResponse2;
                                    requestBody4 = requestBody13;
                                    page6 = page10;
                                } else {
                                    requestBody10 = requestBody9;
                                    Requests app5 = MainActivityKt.getApp();
                                    c00022.L$0 = request6;
                                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(jsonBody11);
                                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts7);
                                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId5);
                                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(genre11);
                                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(year9);
                                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre10);
                                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort5);
                                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody10);
                                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers5);
                                    c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody10);
                                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(response4);
                                    c00022.I$0 = page7;
                                    c00022.I$1 = perPage5;
                                    c00022.I$2 = pg5;
                                    c00022.label = 8;
                                    $result3 = Requests.get$default(app5, jsonBody11, headers5, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                                    if ($result3 == obj2) {
                                        return obj2;
                                    }
                                    data5 = data4;
                                    mainParts8 = mainParts7;
                                    classify4 = genre11;
                                    page8 = page7;
                                    pg6 = pg5;
                                    perPage6 = perPage5;
                                    genre12 = genre10;
                                    year11 = year9;
                                    response5 = response4;
                                    requestBody11 = requestBody10;
                                    request7 = request6;
                                    country4 = country2;
                                    niceResponse2 = (NiceResponse) $result3;
                                    requestBody13 = requestBody11;
                                    request5 = request7;
                                    page10 = page8;
                                    response = niceResponse2;
                                    requestBody4 = requestBody13;
                                    page6 = page10;
                                }
                            }
                        } else {
                            page6 = page3;
                        }
                        responseBody = response.getText();
                        try {
                            mapper = ExtensionsKt.jacksonObjectMapper();
                            root = mapper.readTree(responseBody);
                            str = str2;
                            jsonNode2 = root.get(str);
                            if (jsonNode2 == null) {
                                jsonNode5 = root.get(str);
                                if (jsonNode5 != null) {
                                    jsonNode6 = jsonNode5.get("subjects");
                                } else {
                                    jsonNode6 = jsonNode;
                                }
                                if (jsonNode6 == null) {
                                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                                }
                                items = jsonNode6;
                                Iterable $this$mapNotNull$iv = (Iterable) items;
                                destination$iv$iv = new ArrayList();
                                for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                                    final JsonNode item = (JsonNode) element$iv$iv$iv;
                                    ObjectMapper mapper2 = mapper;
                                    jsonNode3 = item.get("title");
                                    if (jsonNode3 != null) {
                                        page11 = page6;
                                        responseBody2 = responseBody;
                                        requestBody14 = requestBody4;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    } else {
                                        page11 = page6;
                                        responseBody2 = responseBody;
                                        requestBody14 = requestBody4;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    }
                                    if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                        destination$iv$iv2 = destination$iv$iv;
                                        destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                                    } else {
                                        destination$iv$iv2 = destination$iv$iv;
                                    }
                                    destination$iv$iv = destination$iv$iv2;
                                    mapper = mapper2;
                                    responseBody = responseBody2;
                                    requestBody4 = requestBody14;
                                    page6 = page11;
                                    break;
                                }
                                listEmptyList = (List) destination$iv$iv;
                            } else {
                                try {
                                    items = jsonNode2.get("items");
                                    if (items == null) {
                                        jsonNode5 = root.get(str);
                                        if (jsonNode5 != null) {
                                            jsonNode6 = jsonNode5.get("subjects");
                                        } else {
                                            jsonNode6 = jsonNode;
                                        }
                                        if (jsonNode6 == null) {
                                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                                        }
                                        items = jsonNode6;
                                    }
                                    Iterable $this$mapNotNull$iv2 = (Iterable) items;
                                    destination$iv$iv = new ArrayList();
                                    while (r27.hasNext()) {
                                        final JsonNode item2 = (JsonNode) element$iv$iv$iv;
                                        ObjectMapper mapper3 = mapper;
                                        jsonNode3 = item2.get("title");
                                        if (jsonNode3 != null || (strAsText = jsonNode3.asText()) == null) {
                                            page11 = page6;
                                            responseBody2 = responseBody;
                                            requestBody14 = requestBody4;
                                        } else {
                                            page11 = page6;
                                            responseBody2 = responseBody;
                                            requestBody14 = requestBody4;
                                            try {
                                                String title = StringsKt.substringBefore$default(strAsText, "[", (String) null, 2, (Object) null);
                                                if (title != null) {
                                                    JsonNode jsonNode7 = item2.get("subjectId");
                                                    if (jsonNode7 == null || (id = jsonNode7.asText()) == null) {
                                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                                    } else {
                                                        JsonNode jsonNode8 = item2.get("cover");
                                                        final String coverImg = (jsonNode8 == null || (jsonNode4 = jsonNode8.get("url")) == null) ? null : jsonNode4.asText();
                                                        JsonNode jsonNode9 = item2.get("subjectType");
                                                        int subjectType = jsonNode9 != null ? jsonNode9.asInt() : 1;
                                                        switch (subjectType) {
                                                            case 1:
                                                                type = TvType.Movie;
                                                                break;
                                                            case 2:
                                                                type = TvType.TvSeries;
                                                                break;
                                                            default:
                                                                type = TvType.Movie;
                                                                break;
                                                        }
                                                        movieSearchResponseNewMovieSearchResponse$default = MainAPIKt.newMovieSearchResponse$default(this, title, id, type, false, new Function1() { // from class: com.MovieBox.MovieBoxProvider$$ExternalSyntheticLambda6
                                                            public final Object invoke(Object obj3) {
                                                                return MovieBoxProvider.getMainPage$lambda$1$0(coverImg, item2, (MovieSearchResponse) obj3);
                                                            }
                                                        }, 8, (Object) null);
                                                    }
                                                }
                                                if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                                    destination$iv$iv2 = destination$iv$iv;
                                                    destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                                                } else {
                                                    destination$iv$iv2 = destination$iv$iv;
                                                }
                                                destination$iv$iv = destination$iv$iv2;
                                                mapper = mapper3;
                                                responseBody = responseBody2;
                                                requestBody4 = requestBody14;
                                                page6 = page11;
                                            } catch (Exception e) {
                                                listEmptyList = null;
                                                if (listEmptyList == null) {
                                                    listEmptyList = CollectionsKt.emptyList();
                                                }
                                                List data = listEmptyList;
                                                return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                                            }
                                        }
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                        if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                            destination$iv$iv2 = destination$iv$iv;
                                            destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                                        } else {
                                            destination$iv$iv2 = destination$iv$iv;
                                        }
                                        destination$iv$iv = destination$iv$iv2;
                                        mapper = mapper3;
                                        responseBody = responseBody2;
                                        requestBody4 = requestBody14;
                                        page6 = page11;
                                        break;
                                    }
                                    listEmptyList = (List) destination$iv$iv;
                                } catch (Exception e2) {
                                    listEmptyList = null;
                                    if (listEmptyList == null) {
                                        listEmptyList = CollectionsKt.emptyList();
                                    }
                                    List data9 = listEmptyList;
                                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data9, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                                }
                            }
                            break;
                        } catch (Exception e3) {
                        }
                        if (listEmptyList == null) {
                            listEmptyList = CollectionsKt.emptyList();
                        }
                        List data10 = listEmptyList;
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data10, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                    }
                    jsonNode = null;
                    obj = coroutine_suspended;
                    $result2 = $result;
                    Requests app6 = MainActivityKt.getApp();
                    c00022.L$0 = request2;
                    c00022.L$1 = url2;
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(data2);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts4);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId3);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(classify);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(year3);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre5);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort3);
                    c00022.L$11 = jsonBody3;
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers);
                    c00022.L$13 = requestBody;
                    c00022.I$0 = page2;
                    c00022.I$1 = perPage3;
                    c00022.I$2 = pg;
                    c00022.label = 4;
                    $result3 = Requests.get$default(app6, url2, headers, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                    if ($result3 == obj) {
                        return obj;
                    }
                    data3 = data2;
                    mainParts5 = mainParts4;
                    requestBody2 = requestBody;
                    country3 = classify;
                    genre6 = genre5;
                    classify2 = year3;
                    channelId4 = channelId3;
                    request3 = request2;
                    page3 = page2;
                    jsonBody5 = jsonBody3;
                    String str7 = url2;
                    perPage4 = perPage3;
                    url3 = str7;
                    request5 = request3;
                    requestBody4 = requestBody2;
                    niceResponse = (NiceResponse) $result3;
                    headers2 = headers;
                    genre8 = genre6;
                    pg2 = pg;
                    year4 = classify2;
                    response = niceResponse;
                    if (response.getCode() != 401) {
                    }
                    bearerToken = jsonNode;
                    sharedPreferences = movieBoxProvider.sharedPref;
                    if (sharedPreferences != null) {
                        editorRemove.apply();
                        Unit unit2 = Unit.INSTANCE;
                    }
                    if (StringsKt.contains$default(request5.getData(), "|", false, 2, jsonNode)) {
                        c00022.L$0 = request5;
                        c00022.L$1 = url3;
                        c00022.L$2 = SpillingKt.nullOutSpilledVariable(data3);
                        c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts5);
                        c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId4);
                        c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                        c00022.L$6 = SpillingKt.nullOutSpilledVariable(country3);
                        c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                        c00022.L$8 = SpillingKt.nullOutSpilledVariable(year4);
                        c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre8);
                        c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort3);
                        c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody5);
                        c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers2);
                        c00022.L$13 = requestBody4;
                        c00022.L$14 = SpillingKt.nullOutSpilledVariable(response);
                        c00022.I$0 = page3;
                        c00022.I$1 = perPage4;
                        c00022.I$2 = pg2;
                        c00022.label = 5;
                        requestBody7 = requestBody4;
                        url5 = url3;
                        year7 = year4;
                        obj2 = obj;
                        objBuildAuthHeaders$default4 = buildAuthHeaders$default(this, "POST", url5, "application/json; charset=utf-8", null, jsonBody5, false, c00022, 40, null);
                        jsonBody8 = jsonBody5;
                        if (objBuildAuthHeaders$default4 == obj2) {
                            return obj2;
                        }
                        int i3 = pg2;
                        $result3 = objBuildAuthHeaders$default4;
                        pg4 = i3;
                        page5 = page3;
                        request6 = request5;
                        requestBody8 = requestBody7;
                        genre10 = genre8;
                        headers4 = headers2;
                        response3 = response;
                        jsonBody9 = jsonBody8;
                        sort5 = sort3;
                        year8 = year7;
                        response4 = response3;
                        jsonBody10 = jsonBody9;
                        perPage5 = perPage4;
                        jsonBody11 = url5;
                        url6 = channelId4;
                        requestBody9 = requestBody8;
                        year9 = year8;
                        headers5 = (Map) $result3;
                        genre11 = country3;
                        year10 = data3;
                        pg5 = pg4;
                        mainParts6 = mainParts5;
                        page7 = page5;
                        data4 = year10;
                        mainParts7 = mainParts6;
                        channelId5 = url6;
                        jsonNode = null;
                        if (StringsKt.contains$default(request6.getData(), "|", false, 2, (Object) null)) {
                            Requests app7 = MainActivityKt.getApp();
                            c00022.L$0 = request6;
                            c00022.L$1 = SpillingKt.nullOutSpilledVariable(jsonBody11);
                            c00022.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                            c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts7);
                            c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId5);
                            c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                            c00022.L$6 = SpillingKt.nullOutSpilledVariable(genre11);
                            c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                            c00022.L$8 = SpillingKt.nullOutSpilledVariable(year9);
                            c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre10);
                            c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort5);
                            c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody10);
                            c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers5);
                            c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody9);
                            c00022.L$14 = SpillingKt.nullOutSpilledVariable(response4);
                            c00022.I$0 = page7;
                            c00022.I$1 = perPage5;
                            c00022.I$2 = pg5;
                            c00022.label = 7;
                            $result3 = Requests.post$default(app7, jsonBody11, headers5, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody9, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                            requestBody12 = requestBody9;
                            if ($result3 == obj2) {
                                return obj2;
                            }
                            data6 = data4;
                            mainParts9 = mainParts7;
                            classify5 = genre11;
                            page9 = page7;
                            pg6 = pg5;
                            headers6 = headers5;
                            requestBody13 = requestBody12;
                            request8 = request6;
                            country5 = country2;
                            niceResponse2 = (NiceResponse) $result3;
                            request5 = request8;
                            page10 = page9;
                            response = niceResponse2;
                            requestBody4 = requestBody13;
                            page6 = page10;
                            responseBody = response.getText();
                            mapper = ExtensionsKt.jacksonObjectMapper();
                            root = mapper.readTree(responseBody);
                            str = str2;
                            jsonNode2 = root.get(str);
                            if (jsonNode2 == null) {
                                jsonNode5 = root.get(str);
                                if (jsonNode5 != null) {
                                    jsonNode6 = jsonNode5.get("subjects");
                                } else {
                                    jsonNode6 = jsonNode;
                                }
                                if (jsonNode6 == null) {
                                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                                }
                                items = jsonNode6;
                                Iterable $this$mapNotNull$iv3 = (Iterable) items;
                                destination$iv$iv = new ArrayList();
                                while (r27.hasNext()) {
                                    final JsonNode item3 = (JsonNode) element$iv$iv$iv;
                                    ObjectMapper mapper4 = mapper;
                                    jsonNode3 = item3.get("title");
                                    if (jsonNode3 != null) {
                                        page11 = page6;
                                        responseBody2 = responseBody;
                                        requestBody14 = requestBody4;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    } else {
                                        page11 = page6;
                                        responseBody2 = responseBody;
                                        requestBody14 = requestBody4;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    }
                                    if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                        destination$iv$iv2 = destination$iv$iv;
                                        destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                                    } else {
                                        destination$iv$iv2 = destination$iv$iv;
                                    }
                                    destination$iv$iv = destination$iv$iv2;
                                    mapper = mapper4;
                                    responseBody = responseBody2;
                                    requestBody4 = requestBody14;
                                    page6 = page11;
                                    break;
                                }
                                listEmptyList = (List) destination$iv$iv;
                                break;
                            } else {
                                items = jsonNode2.get("items");
                                if (items == null) {
                                    jsonNode5 = root.get(str);
                                    if (jsonNode5 != null) {
                                        jsonNode6 = jsonNode5.get("subjects");
                                    } else {
                                        jsonNode6 = jsonNode;
                                    }
                                    if (jsonNode6 == null) {
                                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                                    }
                                    items = jsonNode6;
                                }
                                Iterable $this$mapNotNull$iv4 = (Iterable) items;
                                destination$iv$iv = new ArrayList();
                                while (r27.hasNext()) {
                                    final JsonNode item4 = (JsonNode) element$iv$iv$iv;
                                    ObjectMapper mapper5 = mapper;
                                    jsonNode3 = item4.get("title");
                                    if (jsonNode3 != null) {
                                        page11 = page6;
                                        responseBody2 = responseBody;
                                        requestBody14 = requestBody4;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    } else {
                                        page11 = page6;
                                        responseBody2 = responseBody;
                                        requestBody14 = requestBody4;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    }
                                    if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                        destination$iv$iv2 = destination$iv$iv;
                                        destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                                    } else {
                                        destination$iv$iv2 = destination$iv$iv;
                                    }
                                    destination$iv$iv = destination$iv$iv2;
                                    mapper = mapper5;
                                    responseBody = responseBody2;
                                    requestBody4 = requestBody14;
                                    page6 = page11;
                                    break;
                                }
                                listEmptyList = (List) destination$iv$iv;
                                break;
                            }
                            if (listEmptyList == null) {
                                listEmptyList = CollectionsKt.emptyList();
                            }
                            List data11 = listEmptyList;
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data11, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                        }
                        requestBody10 = requestBody9;
                        Requests app8 = MainActivityKt.getApp();
                        c00022.L$0 = request6;
                        c00022.L$1 = SpillingKt.nullOutSpilledVariable(jsonBody11);
                        c00022.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                        c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts7);
                        c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId5);
                        c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                        c00022.L$6 = SpillingKt.nullOutSpilledVariable(genre11);
                        c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                        c00022.L$8 = SpillingKt.nullOutSpilledVariable(year9);
                        c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre10);
                        c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort5);
                        c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody10);
                        c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers5);
                        c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody10);
                        c00022.L$14 = SpillingKt.nullOutSpilledVariable(response4);
                        c00022.I$0 = page7;
                        c00022.I$1 = perPage5;
                        c00022.I$2 = pg5;
                        c00022.label = 8;
                        $result3 = Requests.get$default(app8, jsonBody11, headers5, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                        if ($result3 == obj2) {
                            return obj2;
                        }
                        data5 = data4;
                        mainParts8 = mainParts7;
                        classify4 = genre11;
                        page8 = page7;
                        pg6 = pg5;
                        perPage6 = perPage5;
                        genre12 = genre10;
                        year11 = year9;
                        response5 = response4;
                        requestBody11 = requestBody10;
                        request7 = request6;
                        country4 = country2;
                        niceResponse2 = (NiceResponse) $result3;
                        requestBody13 = requestBody11;
                        request5 = request7;
                        page10 = page8;
                        response = niceResponse2;
                        requestBody4 = requestBody13;
                        page6 = page10;
                        responseBody = response.getText();
                        mapper = ExtensionsKt.jacksonObjectMapper();
                        root = mapper.readTree(responseBody);
                        str = str2;
                        jsonNode2 = root.get(str);
                        if (jsonNode2 == null) {
                            jsonNode5 = root.get(str);
                            if (jsonNode5 != null) {
                                jsonNode6 = jsonNode5.get("subjects");
                            } else {
                                jsonNode6 = jsonNode;
                            }
                            if (jsonNode6 == null) {
                                return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                            }
                            items = jsonNode6;
                            Iterable $this$mapNotNull$iv5 = (Iterable) items;
                            destination$iv$iv = new ArrayList();
                            while (r27.hasNext()) {
                                final JsonNode item5 = (JsonNode) element$iv$iv$iv;
                                ObjectMapper mapper6 = mapper;
                                jsonNode3 = item5.get("title");
                                if (jsonNode3 != null) {
                                    page11 = page6;
                                    responseBody2 = responseBody;
                                    requestBody14 = requestBody4;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    page11 = page6;
                                    responseBody2 = responseBody;
                                    requestBody14 = requestBody4;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                                if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                    destination$iv$iv2 = destination$iv$iv;
                                    destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                                } else {
                                    destination$iv$iv2 = destination$iv$iv;
                                }
                                destination$iv$iv = destination$iv$iv2;
                                mapper = mapper6;
                                responseBody = responseBody2;
                                requestBody4 = requestBody14;
                                page6 = page11;
                                break;
                            }
                            listEmptyList = (List) destination$iv$iv;
                            break;
                        } else {
                            items = jsonNode2.get("items");
                            if (items == null) {
                                jsonNode5 = root.get(str);
                                if (jsonNode5 != null) {
                                    jsonNode6 = jsonNode5.get("subjects");
                                } else {
                                    jsonNode6 = jsonNode;
                                }
                                if (jsonNode6 == null) {
                                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                                }
                                items = jsonNode6;
                            }
                            Iterable $this$mapNotNull$iv6 = (Iterable) items;
                            destination$iv$iv = new ArrayList();
                            while (r27.hasNext()) {
                                final JsonNode item6 = (JsonNode) element$iv$iv$iv;
                                ObjectMapper mapper7 = mapper;
                                jsonNode3 = item6.get("title");
                                if (jsonNode3 != null) {
                                    page11 = page6;
                                    responseBody2 = responseBody;
                                    requestBody14 = requestBody4;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    page11 = page6;
                                    responseBody2 = responseBody;
                                    requestBody14 = requestBody4;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                                if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                    destination$iv$iv2 = destination$iv$iv;
                                    destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                                } else {
                                    destination$iv$iv2 = destination$iv$iv;
                                }
                                destination$iv$iv = destination$iv$iv2;
                                mapper = mapper7;
                                responseBody = responseBody2;
                                requestBody4 = requestBody14;
                                page6 = page11;
                                break;
                            }
                            listEmptyList = (List) destination$iv$iv;
                            break;
                        }
                        if (listEmptyList == null) {
                            listEmptyList = CollectionsKt.emptyList();
                        }
                        List data12 = listEmptyList;
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data12, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                    }
                    jsonBody6 = jsonBody5;
                    url4 = url3;
                    year5 = year4;
                    obj2 = obj;
                    requestBody5 = requestBody4;
                    c00022.L$0 = request5;
                    c00022.L$1 = url4;
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(data3);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts5);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId4);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(country3);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(year5);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre8);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort3);
                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody6);
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers2);
                    c00022.L$13 = requestBody5;
                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(response);
                    c00022.I$0 = page3;
                    c00022.I$1 = perPage4;
                    c00022.I$2 = pg2;
                    c00022.label = 6;
                    objBuildAuthHeaders$default3 = buildAuthHeaders$default(this, "GET", url4, null, null, null, false, c00022, 60, null);
                    if (objBuildAuthHeaders$default3 == obj2) {
                        return obj2;
                    }
                    int i4 = pg2;
                    $result3 = objBuildAuthHeaders$default3;
                    pg3 = i4;
                    page4 = page3;
                    request6 = request5;
                    requestBody6 = requestBody5;
                    genre9 = genre8;
                    headers3 = headers2;
                    response2 = response;
                    jsonBody7 = jsonBody6;
                    sort4 = sort3;
                    year6 = year5;
                    response4 = response2;
                    jsonBody10 = jsonBody7;
                    sort5 = sort4;
                    perPage5 = perPage4;
                    jsonBody11 = url4;
                    genre10 = genre9;
                    url6 = channelId4;
                    requestBody9 = requestBody6;
                    year9 = year6;
                    headers5 = (Map) $result3;
                    page7 = page4;
                    year10 = data3;
                    genre11 = country3;
                    pg5 = pg3;
                    mainParts6 = mainParts5;
                    data4 = year10;
                    mainParts7 = mainParts6;
                    channelId5 = url6;
                    jsonNode = null;
                    if (StringsKt.contains$default(request6.getData(), "|", false, 2, (Object) null)) {
                        Requests app9 = MainActivityKt.getApp();
                        c00022.L$0 = request6;
                        c00022.L$1 = SpillingKt.nullOutSpilledVariable(jsonBody11);
                        c00022.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                        c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts7);
                        c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId5);
                        c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                        c00022.L$6 = SpillingKt.nullOutSpilledVariable(genre11);
                        c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                        c00022.L$8 = SpillingKt.nullOutSpilledVariable(year9);
                        c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre10);
                        c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort5);
                        c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody10);
                        c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers5);
                        c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody9);
                        c00022.L$14 = SpillingKt.nullOutSpilledVariable(response4);
                        c00022.I$0 = page7;
                        c00022.I$1 = perPage5;
                        c00022.I$2 = pg5;
                        c00022.label = 7;
                        $result3 = Requests.post$default(app9, jsonBody11, headers5, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody9, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                        requestBody12 = requestBody9;
                        if ($result3 == obj2) {
                            return obj2;
                        }
                        data6 = data4;
                        mainParts9 = mainParts7;
                        classify5 = genre11;
                        page9 = page7;
                        pg6 = pg5;
                        headers6 = headers5;
                        requestBody13 = requestBody12;
                        request8 = request6;
                        country5 = country2;
                        niceResponse2 = (NiceResponse) $result3;
                        request5 = request8;
                        page10 = page9;
                        response = niceResponse2;
                        requestBody4 = requestBody13;
                        page6 = page10;
                        responseBody = response.getText();
                        mapper = ExtensionsKt.jacksonObjectMapper();
                        root = mapper.readTree(responseBody);
                        str = str2;
                        jsonNode2 = root.get(str);
                        if (jsonNode2 == null) {
                            jsonNode5 = root.get(str);
                            if (jsonNode5 != null) {
                                jsonNode6 = jsonNode5.get("subjects");
                            } else {
                                jsonNode6 = jsonNode;
                            }
                            if (jsonNode6 == null) {
                                return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                            }
                            items = jsonNode6;
                            Iterable $this$mapNotNull$iv7 = (Iterable) items;
                            destination$iv$iv = new ArrayList();
                            while (r27.hasNext()) {
                                final JsonNode item7 = (JsonNode) element$iv$iv$iv;
                                ObjectMapper mapper8 = mapper;
                                jsonNode3 = item7.get("title");
                                if (jsonNode3 != null) {
                                    page11 = page6;
                                    responseBody2 = responseBody;
                                    requestBody14 = requestBody4;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    page11 = page6;
                                    responseBody2 = responseBody;
                                    requestBody14 = requestBody4;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                                if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                    destination$iv$iv2 = destination$iv$iv;
                                    destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                                } else {
                                    destination$iv$iv2 = destination$iv$iv;
                                }
                                destination$iv$iv = destination$iv$iv2;
                                mapper = mapper8;
                                responseBody = responseBody2;
                                requestBody4 = requestBody14;
                                page6 = page11;
                                break;
                            }
                            listEmptyList = (List) destination$iv$iv;
                            break;
                        } else {
                            items = jsonNode2.get("items");
                            if (items == null) {
                                jsonNode5 = root.get(str);
                                if (jsonNode5 != null) {
                                    jsonNode6 = jsonNode5.get("subjects");
                                } else {
                                    jsonNode6 = jsonNode;
                                }
                                if (jsonNode6 == null) {
                                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                                }
                                items = jsonNode6;
                            }
                            Iterable $this$mapNotNull$iv8 = (Iterable) items;
                            destination$iv$iv = new ArrayList();
                            while (r27.hasNext()) {
                                final JsonNode item8 = (JsonNode) element$iv$iv$iv;
                                ObjectMapper mapper9 = mapper;
                                jsonNode3 = item8.get("title");
                                if (jsonNode3 != null) {
                                    page11 = page6;
                                    responseBody2 = responseBody;
                                    requestBody14 = requestBody4;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    page11 = page6;
                                    responseBody2 = responseBody;
                                    requestBody14 = requestBody4;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                                if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                    destination$iv$iv2 = destination$iv$iv;
                                    destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                                } else {
                                    destination$iv$iv2 = destination$iv$iv;
                                }
                                destination$iv$iv = destination$iv$iv2;
                                mapper = mapper9;
                                responseBody = responseBody2;
                                requestBody4 = requestBody14;
                                page6 = page11;
                                break;
                            }
                            listEmptyList = (List) destination$iv$iv;
                            break;
                        }
                        if (listEmptyList == null) {
                            listEmptyList = CollectionsKt.emptyList();
                        }
                        List data13 = listEmptyList;
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data13, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                    }
                    requestBody10 = requestBody9;
                    Requests app10 = MainActivityKt.getApp();
                    c00022.L$0 = request6;
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(jsonBody11);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts7);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId5);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(genre11);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(year9);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre10);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort5);
                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody10);
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers5);
                    c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody10);
                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(response4);
                    c00022.I$0 = page7;
                    c00022.I$1 = perPage5;
                    c00022.I$2 = pg5;
                    c00022.label = 8;
                    $result3 = Requests.get$default(app10, jsonBody11, headers5, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                    if ($result3 == obj2) {
                        return obj2;
                    }
                    data5 = data4;
                    mainParts8 = mainParts7;
                    classify4 = genre11;
                    page8 = page7;
                    pg6 = pg5;
                    perPage6 = perPage5;
                    genre12 = genre10;
                    year11 = year9;
                    response5 = response4;
                    requestBody11 = requestBody10;
                    request7 = request6;
                    country4 = country2;
                    niceResponse2 = (NiceResponse) $result3;
                    requestBody13 = requestBody11;
                    request5 = request7;
                    page10 = page8;
                    response = niceResponse2;
                    requestBody4 = requestBody13;
                    page6 = page10;
                    responseBody = response.getText();
                    mapper = ExtensionsKt.jacksonObjectMapper();
                    root = mapper.readTree(responseBody);
                    str = str2;
                    jsonNode2 = root.get(str);
                    if (jsonNode2 == null) {
                        jsonNode5 = root.get(str);
                        if (jsonNode5 != null) {
                            jsonNode6 = jsonNode5.get("subjects");
                        } else {
                            jsonNode6 = jsonNode;
                        }
                        if (jsonNode6 == null) {
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                        }
                        items = jsonNode6;
                        Iterable $this$mapNotNull$iv9 = (Iterable) items;
                        destination$iv$iv = new ArrayList();
                        while (r27.hasNext()) {
                            final JsonNode item9 = (JsonNode) element$iv$iv$iv;
                            ObjectMapper mapper10 = mapper;
                            jsonNode3 = item9.get("title");
                            if (jsonNode3 != null) {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                destination$iv$iv2 = destination$iv$iv;
                                destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                destination$iv$iv2 = destination$iv$iv;
                            }
                            destination$iv$iv = destination$iv$iv2;
                            mapper = mapper10;
                            responseBody = responseBody2;
                            requestBody4 = requestBody14;
                            page6 = page11;
                            break;
                        }
                        listEmptyList = (List) destination$iv$iv;
                        break;
                    } else {
                        items = jsonNode2.get("items");
                        if (items == null) {
                            jsonNode5 = root.get(str);
                            if (jsonNode5 != null) {
                                jsonNode6 = jsonNode5.get("subjects");
                            } else {
                                jsonNode6 = jsonNode;
                            }
                            if (jsonNode6 == null) {
                                return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                            }
                            items = jsonNode6;
                        }
                        Iterable $this$mapNotNull$iv10 = (Iterable) items;
                        destination$iv$iv = new ArrayList();
                        while (r27.hasNext()) {
                            final JsonNode item10 = (JsonNode) element$iv$iv$iv;
                            ObjectMapper mapper11 = mapper;
                            jsonNode3 = item10.get("title");
                            if (jsonNode3 != null) {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                destination$iv$iv2 = destination$iv$iv;
                                destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                destination$iv$iv2 = destination$iv$iv;
                            }
                            destination$iv$iv = destination$iv$iv2;
                            mapper = mapper11;
                            responseBody = responseBody2;
                            requestBody4 = requestBody14;
                            page6 = page11;
                            break;
                        }
                        listEmptyList = (List) destination$iv$iv;
                        break;
                    }
                    if (listEmptyList == null) {
                        listEmptyList = CollectionsKt.emptyList();
                    }
                    List data14 = listEmptyList;
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data14, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                }
                perPage = 15;
                channelId = channelId6;
                String sort8 = sort6;
                pg = pg7;
                c00022.L$0 = request9;
                c00022.L$1 = url;
                c00022.L$2 = SpillingKt.nullOutSpilledVariable(data8);
                c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts12);
                c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId);
                c00022.L$5 = SpillingKt.nullOutSpilledVariable(options);
                c00022.L$6 = SpillingKt.nullOutSpilledVariable(classify7);
                c00022.L$7 = SpillingKt.nullOutSpilledVariable(country7);
                c00022.L$8 = SpillingKt.nullOutSpilledVariable(year13);
                c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre14);
                c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort8);
                c00022.L$11 = jsonBody12;
                c00022.I$0 = page12;
                c00022.I$1 = 15;
                c00022.I$2 = pg;
                c00022.label = 2;
                movieBoxProvider = this;
                objBuildAuthHeaders$default = buildAuthHeaders$default(movieBoxProvider, "GET", url, null, null, null, false, c00022, 60, null);
                if (objBuildAuthHeaders$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                sort = sort8;
                country = country7;
                year = year13;
                classify = classify7;
                genre = genre14;
                jsonBody = jsonBody12;
                genre2 = data8;
                mainParts = mainParts12;
                headers = (Map) objBuildAuthHeaders$default;
                sort3 = sort;
                genre5 = genre;
                year3 = year;
                perPage3 = perPage;
                options2 = options;
                data1 = genre2;
                page2 = page12;
                url2 = url;
                request2 = request9;
                mainParts3 = mainParts;
                jsonBody3 = jsonBody;
                jsonBody4 = channelId;
                data2 = data1;
                mainParts4 = mainParts3;
                requestBody = RequestBody.Companion.create(jsonBody3, MediaType.Companion.get("application/json"));
                channelId3 = jsonBody4;
                options3 = options2;
                country2 = country;
                if (StringsKt.contains$default(request2.getData(), "|", false, 2, (Object) null)) {
                    Requests app11 = MainActivityKt.getApp();
                    c00022.L$0 = request2;
                    c00022.L$1 = url2;
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(data2);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts4);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId3);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(classify);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(year3);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre5);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort3);
                    c00022.L$11 = jsonBody3;
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers);
                    c00022.L$13 = requestBody;
                    c00022.I$0 = page2;
                    c00022.I$1 = perPage3;
                    c00022.I$2 = pg;
                    c00022.label = 3;
                    obj = coroutine_suspended;
                    $result2 = $result;
                    jsonNode = null;
                    $result3 = Requests.post$default(app11, url2, headers, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                    if ($result3 == obj) {
                        return obj;
                    }
                    data3 = data2;
                    mainParts5 = mainParts4;
                    requestBody3 = requestBody;
                    country3 = classify;
                    genre7 = genre5;
                    classify3 = year3;
                    channelId4 = channelId3;
                    request4 = request2;
                    page3 = page2;
                    jsonBody5 = jsonBody3;
                    String str8 = url2;
                    perPage4 = perPage3;
                    url3 = str8;
                    request5 = request4;
                    requestBody4 = requestBody3;
                    niceResponse = (NiceResponse) $result3;
                    headers2 = headers;
                    genre8 = genre7;
                    pg2 = pg;
                    year4 = classify3;
                    response = niceResponse;
                    if (response.getCode() != 401) {
                    }
                    bearerToken = jsonNode;
                    sharedPreferences = movieBoxProvider.sharedPref;
                    if (sharedPreferences != null) {
                        editorRemove.apply();
                        Unit unit3 = Unit.INSTANCE;
                    }
                    if (StringsKt.contains$default(request5.getData(), "|", false, 2, jsonNode)) {
                        c00022.L$0 = request5;
                        c00022.L$1 = url3;
                        c00022.L$2 = SpillingKt.nullOutSpilledVariable(data3);
                        c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts5);
                        c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId4);
                        c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                        c00022.L$6 = SpillingKt.nullOutSpilledVariable(country3);
                        c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                        c00022.L$8 = SpillingKt.nullOutSpilledVariable(year4);
                        c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre8);
                        c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort3);
                        c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody5);
                        c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers2);
                        c00022.L$13 = requestBody4;
                        c00022.L$14 = SpillingKt.nullOutSpilledVariable(response);
                        c00022.I$0 = page3;
                        c00022.I$1 = perPage4;
                        c00022.I$2 = pg2;
                        c00022.label = 5;
                        requestBody7 = requestBody4;
                        url5 = url3;
                        year7 = year4;
                        obj2 = obj;
                        objBuildAuthHeaders$default4 = buildAuthHeaders$default(this, "POST", url5, "application/json; charset=utf-8", null, jsonBody5, false, c00022, 40, null);
                        jsonBody8 = jsonBody5;
                        if (objBuildAuthHeaders$default4 == obj2) {
                            return obj2;
                        }
                        int i5 = pg2;
                        $result3 = objBuildAuthHeaders$default4;
                        pg4 = i5;
                        page5 = page3;
                        request6 = request5;
                        requestBody8 = requestBody7;
                        genre10 = genre8;
                        headers4 = headers2;
                        response3 = response;
                        jsonBody9 = jsonBody8;
                        sort5 = sort3;
                        year8 = year7;
                        response4 = response3;
                        jsonBody10 = jsonBody9;
                        perPage5 = perPage4;
                        jsonBody11 = url5;
                        url6 = channelId4;
                        requestBody9 = requestBody8;
                        year9 = year8;
                        headers5 = (Map) $result3;
                        genre11 = country3;
                        year10 = data3;
                        pg5 = pg4;
                        mainParts6 = mainParts5;
                        page7 = page5;
                        data4 = year10;
                        mainParts7 = mainParts6;
                        channelId5 = url6;
                        jsonNode = null;
                        if (StringsKt.contains$default(request6.getData(), "|", false, 2, (Object) null)) {
                            Requests app12 = MainActivityKt.getApp();
                            c00022.L$0 = request6;
                            c00022.L$1 = SpillingKt.nullOutSpilledVariable(jsonBody11);
                            c00022.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                            c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts7);
                            c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId5);
                            c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                            c00022.L$6 = SpillingKt.nullOutSpilledVariable(genre11);
                            c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                            c00022.L$8 = SpillingKt.nullOutSpilledVariable(year9);
                            c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre10);
                            c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort5);
                            c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody10);
                            c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers5);
                            c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody9);
                            c00022.L$14 = SpillingKt.nullOutSpilledVariable(response4);
                            c00022.I$0 = page7;
                            c00022.I$1 = perPage5;
                            c00022.I$2 = pg5;
                            c00022.label = 7;
                            $result3 = Requests.post$default(app12, jsonBody11, headers5, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody9, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                            requestBody12 = requestBody9;
                            if ($result3 == obj2) {
                                return obj2;
                            }
                            data6 = data4;
                            mainParts9 = mainParts7;
                            classify5 = genre11;
                            page9 = page7;
                            pg6 = pg5;
                            headers6 = headers5;
                            requestBody13 = requestBody12;
                            request8 = request6;
                            country5 = country2;
                            niceResponse2 = (NiceResponse) $result3;
                            request5 = request8;
                            page10 = page9;
                            response = niceResponse2;
                            requestBody4 = requestBody13;
                            page6 = page10;
                            responseBody = response.getText();
                            mapper = ExtensionsKt.jacksonObjectMapper();
                            root = mapper.readTree(responseBody);
                            str = str2;
                            jsonNode2 = root.get(str);
                            if (jsonNode2 == null) {
                                jsonNode5 = root.get(str);
                                if (jsonNode5 != null) {
                                    jsonNode6 = jsonNode5.get("subjects");
                                } else {
                                    jsonNode6 = jsonNode;
                                }
                                if (jsonNode6 == null) {
                                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                                }
                                items = jsonNode6;
                                Iterable $this$mapNotNull$iv11 = (Iterable) items;
                                destination$iv$iv = new ArrayList();
                                while (r27.hasNext()) {
                                    final JsonNode item11 = (JsonNode) element$iv$iv$iv;
                                    ObjectMapper mapper12 = mapper;
                                    jsonNode3 = item11.get("title");
                                    if (jsonNode3 != null) {
                                        page11 = page6;
                                        responseBody2 = responseBody;
                                        requestBody14 = requestBody4;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    } else {
                                        page11 = page6;
                                        responseBody2 = responseBody;
                                        requestBody14 = requestBody4;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    }
                                    if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                        destination$iv$iv2 = destination$iv$iv;
                                        destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                                    } else {
                                        destination$iv$iv2 = destination$iv$iv;
                                    }
                                    destination$iv$iv = destination$iv$iv2;
                                    mapper = mapper12;
                                    responseBody = responseBody2;
                                    requestBody4 = requestBody14;
                                    page6 = page11;
                                    break;
                                }
                                listEmptyList = (List) destination$iv$iv;
                                break;
                            } else {
                                items = jsonNode2.get("items");
                                if (items == null) {
                                    jsonNode5 = root.get(str);
                                    if (jsonNode5 != null) {
                                        jsonNode6 = jsonNode5.get("subjects");
                                    } else {
                                        jsonNode6 = jsonNode;
                                    }
                                    if (jsonNode6 == null) {
                                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                                    }
                                    items = jsonNode6;
                                }
                                Iterable $this$mapNotNull$iv12 = (Iterable) items;
                                destination$iv$iv = new ArrayList();
                                while (r27.hasNext()) {
                                    final JsonNode item12 = (JsonNode) element$iv$iv$iv;
                                    ObjectMapper mapper13 = mapper;
                                    jsonNode3 = item12.get("title");
                                    if (jsonNode3 != null) {
                                        page11 = page6;
                                        responseBody2 = responseBody;
                                        requestBody14 = requestBody4;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    } else {
                                        page11 = page6;
                                        responseBody2 = responseBody;
                                        requestBody14 = requestBody4;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    }
                                    if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                        destination$iv$iv2 = destination$iv$iv;
                                        destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                                    } else {
                                        destination$iv$iv2 = destination$iv$iv;
                                    }
                                    destination$iv$iv = destination$iv$iv2;
                                    mapper = mapper13;
                                    responseBody = responseBody2;
                                    requestBody4 = requestBody14;
                                    page6 = page11;
                                    break;
                                }
                                listEmptyList = (List) destination$iv$iv;
                                break;
                            }
                            if (listEmptyList == null) {
                                listEmptyList = CollectionsKt.emptyList();
                            }
                            List data15 = listEmptyList;
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data15, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                        }
                        requestBody10 = requestBody9;
                        Requests app13 = MainActivityKt.getApp();
                        c00022.L$0 = request6;
                        c00022.L$1 = SpillingKt.nullOutSpilledVariable(jsonBody11);
                        c00022.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                        c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts7);
                        c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId5);
                        c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                        c00022.L$6 = SpillingKt.nullOutSpilledVariable(genre11);
                        c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                        c00022.L$8 = SpillingKt.nullOutSpilledVariable(year9);
                        c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre10);
                        c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort5);
                        c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody10);
                        c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers5);
                        c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody10);
                        c00022.L$14 = SpillingKt.nullOutSpilledVariable(response4);
                        c00022.I$0 = page7;
                        c00022.I$1 = perPage5;
                        c00022.I$2 = pg5;
                        c00022.label = 8;
                        $result3 = Requests.get$default(app13, jsonBody11, headers5, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                        if ($result3 == obj2) {
                            return obj2;
                        }
                        data5 = data4;
                        mainParts8 = mainParts7;
                        classify4 = genre11;
                        page8 = page7;
                        pg6 = pg5;
                        perPage6 = perPage5;
                        genre12 = genre10;
                        year11 = year9;
                        response5 = response4;
                        requestBody11 = requestBody10;
                        request7 = request6;
                        country4 = country2;
                        niceResponse2 = (NiceResponse) $result3;
                        requestBody13 = requestBody11;
                        request5 = request7;
                        page10 = page8;
                        response = niceResponse2;
                        requestBody4 = requestBody13;
                        page6 = page10;
                        responseBody = response.getText();
                        mapper = ExtensionsKt.jacksonObjectMapper();
                        root = mapper.readTree(responseBody);
                        str = str2;
                        jsonNode2 = root.get(str);
                        if (jsonNode2 == null) {
                            jsonNode5 = root.get(str);
                            if (jsonNode5 != null) {
                                jsonNode6 = jsonNode5.get("subjects");
                            } else {
                                jsonNode6 = jsonNode;
                            }
                            if (jsonNode6 == null) {
                                return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                            }
                            items = jsonNode6;
                            Iterable $this$mapNotNull$iv13 = (Iterable) items;
                            destination$iv$iv = new ArrayList();
                            while (r27.hasNext()) {
                                final JsonNode item13 = (JsonNode) element$iv$iv$iv;
                                ObjectMapper mapper14 = mapper;
                                jsonNode3 = item13.get("title");
                                if (jsonNode3 != null) {
                                    page11 = page6;
                                    responseBody2 = responseBody;
                                    requestBody14 = requestBody4;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    page11 = page6;
                                    responseBody2 = responseBody;
                                    requestBody14 = requestBody4;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                                if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                    destination$iv$iv2 = destination$iv$iv;
                                    destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                                } else {
                                    destination$iv$iv2 = destination$iv$iv;
                                }
                                destination$iv$iv = destination$iv$iv2;
                                mapper = mapper14;
                                responseBody = responseBody2;
                                requestBody4 = requestBody14;
                                page6 = page11;
                                break;
                            }
                            listEmptyList = (List) destination$iv$iv;
                            break;
                        } else {
                            items = jsonNode2.get("items");
                            if (items == null) {
                                jsonNode5 = root.get(str);
                                if (jsonNode5 != null) {
                                    jsonNode6 = jsonNode5.get("subjects");
                                } else {
                                    jsonNode6 = jsonNode;
                                }
                                if (jsonNode6 == null) {
                                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                                }
                                items = jsonNode6;
                            }
                            Iterable $this$mapNotNull$iv14 = (Iterable) items;
                            destination$iv$iv = new ArrayList();
                            while (r27.hasNext()) {
                                final JsonNode item14 = (JsonNode) element$iv$iv$iv;
                                ObjectMapper mapper15 = mapper;
                                jsonNode3 = item14.get("title");
                                if (jsonNode3 != null) {
                                    page11 = page6;
                                    responseBody2 = responseBody;
                                    requestBody14 = requestBody4;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    page11 = page6;
                                    responseBody2 = responseBody;
                                    requestBody14 = requestBody4;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                                if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                    destination$iv$iv2 = destination$iv$iv;
                                    destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                                } else {
                                    destination$iv$iv2 = destination$iv$iv;
                                }
                                destination$iv$iv = destination$iv$iv2;
                                mapper = mapper15;
                                responseBody = responseBody2;
                                requestBody4 = requestBody14;
                                page6 = page11;
                                break;
                            }
                            listEmptyList = (List) destination$iv$iv;
                            break;
                        }
                        if (listEmptyList == null) {
                            listEmptyList = CollectionsKt.emptyList();
                        }
                        List data16 = listEmptyList;
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data16, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                    }
                    jsonBody6 = jsonBody5;
                    url4 = url3;
                    year5 = year4;
                    obj2 = obj;
                    requestBody5 = requestBody4;
                    c00022.L$0 = request5;
                    c00022.L$1 = url4;
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(data3);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts5);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId4);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(country3);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(year5);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre8);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort3);
                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody6);
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers2);
                    c00022.L$13 = requestBody5;
                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(response);
                    c00022.I$0 = page3;
                    c00022.I$1 = perPage4;
                    c00022.I$2 = pg2;
                    c00022.label = 6;
                    objBuildAuthHeaders$default3 = buildAuthHeaders$default(this, "GET", url4, null, null, null, false, c00022, 60, null);
                    if (objBuildAuthHeaders$default3 == obj2) {
                        return obj2;
                    }
                    int i6 = pg2;
                    $result3 = objBuildAuthHeaders$default3;
                    pg3 = i6;
                    page4 = page3;
                    request6 = request5;
                    requestBody6 = requestBody5;
                    genre9 = genre8;
                    headers3 = headers2;
                    response2 = response;
                    jsonBody7 = jsonBody6;
                    sort4 = sort3;
                    year6 = year5;
                    response4 = response2;
                    jsonBody10 = jsonBody7;
                    sort5 = sort4;
                    perPage5 = perPage4;
                    jsonBody11 = url4;
                    genre10 = genre9;
                    url6 = channelId4;
                    requestBody9 = requestBody6;
                    year9 = year6;
                    headers5 = (Map) $result3;
                    page7 = page4;
                    year10 = data3;
                    genre11 = country3;
                    pg5 = pg3;
                    mainParts6 = mainParts5;
                    data4 = year10;
                    mainParts7 = mainParts6;
                    channelId5 = url6;
                    jsonNode = null;
                    if (StringsKt.contains$default(request6.getData(), "|", false, 2, (Object) null)) {
                        Requests app14 = MainActivityKt.getApp();
                        c00022.L$0 = request6;
                        c00022.L$1 = SpillingKt.nullOutSpilledVariable(jsonBody11);
                        c00022.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                        c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts7);
                        c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId5);
                        c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                        c00022.L$6 = SpillingKt.nullOutSpilledVariable(genre11);
                        c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                        c00022.L$8 = SpillingKt.nullOutSpilledVariable(year9);
                        c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre10);
                        c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort5);
                        c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody10);
                        c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers5);
                        c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody9);
                        c00022.L$14 = SpillingKt.nullOutSpilledVariable(response4);
                        c00022.I$0 = page7;
                        c00022.I$1 = perPage5;
                        c00022.I$2 = pg5;
                        c00022.label = 7;
                        $result3 = Requests.post$default(app14, jsonBody11, headers5, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody9, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                        requestBody12 = requestBody9;
                        if ($result3 == obj2) {
                            return obj2;
                        }
                        data6 = data4;
                        mainParts9 = mainParts7;
                        classify5 = genre11;
                        page9 = page7;
                        pg6 = pg5;
                        headers6 = headers5;
                        requestBody13 = requestBody12;
                        request8 = request6;
                        country5 = country2;
                        niceResponse2 = (NiceResponse) $result3;
                        request5 = request8;
                        page10 = page9;
                        response = niceResponse2;
                        requestBody4 = requestBody13;
                        page6 = page10;
                        responseBody = response.getText();
                        mapper = ExtensionsKt.jacksonObjectMapper();
                        root = mapper.readTree(responseBody);
                        str = str2;
                        jsonNode2 = root.get(str);
                        if (jsonNode2 == null) {
                            jsonNode5 = root.get(str);
                            if (jsonNode5 != null) {
                                jsonNode6 = jsonNode5.get("subjects");
                            } else {
                                jsonNode6 = jsonNode;
                            }
                            if (jsonNode6 == null) {
                                return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                            }
                            items = jsonNode6;
                            Iterable $this$mapNotNull$iv15 = (Iterable) items;
                            destination$iv$iv = new ArrayList();
                            while (r27.hasNext()) {
                                final JsonNode item15 = (JsonNode) element$iv$iv$iv;
                                ObjectMapper mapper16 = mapper;
                                jsonNode3 = item15.get("title");
                                if (jsonNode3 != null) {
                                    page11 = page6;
                                    responseBody2 = responseBody;
                                    requestBody14 = requestBody4;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    page11 = page6;
                                    responseBody2 = responseBody;
                                    requestBody14 = requestBody4;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                                if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                    destination$iv$iv2 = destination$iv$iv;
                                    destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                                } else {
                                    destination$iv$iv2 = destination$iv$iv;
                                }
                                destination$iv$iv = destination$iv$iv2;
                                mapper = mapper16;
                                responseBody = responseBody2;
                                requestBody4 = requestBody14;
                                page6 = page11;
                                break;
                            }
                            listEmptyList = (List) destination$iv$iv;
                            break;
                        } else {
                            items = jsonNode2.get("items");
                            if (items == null) {
                                jsonNode5 = root.get(str);
                                if (jsonNode5 != null) {
                                    jsonNode6 = jsonNode5.get("subjects");
                                } else {
                                    jsonNode6 = jsonNode;
                                }
                                if (jsonNode6 == null) {
                                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                                }
                                items = jsonNode6;
                            }
                            Iterable $this$mapNotNull$iv16 = (Iterable) items;
                            destination$iv$iv = new ArrayList();
                            while (r27.hasNext()) {
                                final JsonNode item16 = (JsonNode) element$iv$iv$iv;
                                ObjectMapper mapper17 = mapper;
                                jsonNode3 = item16.get("title");
                                if (jsonNode3 != null) {
                                    page11 = page6;
                                    responseBody2 = responseBody;
                                    requestBody14 = requestBody4;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    page11 = page6;
                                    responseBody2 = responseBody;
                                    requestBody14 = requestBody4;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                                if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                    destination$iv$iv2 = destination$iv$iv;
                                    destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                                } else {
                                    destination$iv$iv2 = destination$iv$iv;
                                }
                                destination$iv$iv = destination$iv$iv2;
                                mapper = mapper17;
                                responseBody = responseBody2;
                                requestBody4 = requestBody14;
                                page6 = page11;
                                break;
                            }
                            listEmptyList = (List) destination$iv$iv;
                            break;
                        }
                        if (listEmptyList == null) {
                            listEmptyList = CollectionsKt.emptyList();
                        }
                        List data17 = listEmptyList;
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data17, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                    }
                    requestBody10 = requestBody9;
                    Requests app15 = MainActivityKt.getApp();
                    c00022.L$0 = request6;
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(jsonBody11);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts7);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId5);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(genre11);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(year9);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre10);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort5);
                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody10);
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers5);
                    c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody10);
                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(response4);
                    c00022.I$0 = page7;
                    c00022.I$1 = perPage5;
                    c00022.I$2 = pg5;
                    c00022.label = 8;
                    $result3 = Requests.get$default(app15, jsonBody11, headers5, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                    if ($result3 == obj2) {
                        return obj2;
                    }
                    data5 = data4;
                    mainParts8 = mainParts7;
                    classify4 = genre11;
                    page8 = page7;
                    pg6 = pg5;
                    perPage6 = perPage5;
                    genre12 = genre10;
                    year11 = year9;
                    response5 = response4;
                    requestBody11 = requestBody10;
                    request7 = request6;
                    country4 = country2;
                    niceResponse2 = (NiceResponse) $result3;
                    requestBody13 = requestBody11;
                    request5 = request7;
                    page10 = page8;
                    response = niceResponse2;
                    requestBody4 = requestBody13;
                    page6 = page10;
                    responseBody = response.getText();
                    mapper = ExtensionsKt.jacksonObjectMapper();
                    root = mapper.readTree(responseBody);
                    str = str2;
                    jsonNode2 = root.get(str);
                    if (jsonNode2 == null) {
                        jsonNode5 = root.get(str);
                        if (jsonNode5 != null) {
                            jsonNode6 = jsonNode5.get("subjects");
                        } else {
                            jsonNode6 = jsonNode;
                        }
                        if (jsonNode6 == null) {
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                        }
                        items = jsonNode6;
                        Iterable $this$mapNotNull$iv17 = (Iterable) items;
                        destination$iv$iv = new ArrayList();
                        while (r27.hasNext()) {
                            final JsonNode item17 = (JsonNode) element$iv$iv$iv;
                            ObjectMapper mapper18 = mapper;
                            jsonNode3 = item17.get("title");
                            if (jsonNode3 != null) {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                destination$iv$iv2 = destination$iv$iv;
                                destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                destination$iv$iv2 = destination$iv$iv;
                            }
                            destination$iv$iv = destination$iv$iv2;
                            mapper = mapper18;
                            responseBody = responseBody2;
                            requestBody4 = requestBody14;
                            page6 = page11;
                            break;
                        }
                        listEmptyList = (List) destination$iv$iv;
                        break;
                    } else {
                        items = jsonNode2.get("items");
                        if (items == null) {
                            jsonNode5 = root.get(str);
                            if (jsonNode5 != null) {
                                jsonNode6 = jsonNode5.get("subjects");
                            } else {
                                jsonNode6 = jsonNode;
                            }
                            if (jsonNode6 == null) {
                                return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                            }
                            items = jsonNode6;
                        }
                        Iterable $this$mapNotNull$iv18 = (Iterable) items;
                        destination$iv$iv = new ArrayList();
                        while (r27.hasNext()) {
                            final JsonNode item18 = (JsonNode) element$iv$iv$iv;
                            ObjectMapper mapper19 = mapper;
                            jsonNode3 = item18.get("title");
                            if (jsonNode3 != null) {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                destination$iv$iv2 = destination$iv$iv;
                                destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                destination$iv$iv2 = destination$iv$iv;
                            }
                            destination$iv$iv = destination$iv$iv2;
                            mapper = mapper19;
                            responseBody = responseBody2;
                            requestBody4 = requestBody14;
                            page6 = page11;
                            break;
                        }
                        listEmptyList = (List) destination$iv$iv;
                        break;
                    }
                    if (listEmptyList == null) {
                        listEmptyList = CollectionsKt.emptyList();
                    }
                    List data18 = listEmptyList;
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data18, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                }
                jsonNode = null;
                obj = coroutine_suspended;
                $result2 = $result;
                Requests app16 = MainActivityKt.getApp();
                c00022.L$0 = request2;
                c00022.L$1 = url2;
                c00022.L$2 = SpillingKt.nullOutSpilledVariable(data2);
                c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts4);
                c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId3);
                c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                c00022.L$6 = SpillingKt.nullOutSpilledVariable(classify);
                c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                c00022.L$8 = SpillingKt.nullOutSpilledVariable(year3);
                c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre5);
                c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort3);
                c00022.L$11 = jsonBody3;
                c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers);
                c00022.L$13 = requestBody;
                c00022.I$0 = page2;
                c00022.I$1 = perPage3;
                c00022.I$2 = pg;
                c00022.label = 4;
                $result3 = Requests.get$default(app16, url2, headers, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                if ($result3 == obj) {
                    return obj;
                }
                data3 = data2;
                mainParts5 = mainParts4;
                requestBody2 = requestBody;
                country3 = classify;
                genre6 = genre5;
                classify2 = year3;
                channelId4 = channelId3;
                request3 = request2;
                page3 = page2;
                jsonBody5 = jsonBody3;
                String str9 = url2;
                perPage4 = perPage3;
                url3 = str9;
                request5 = request3;
                requestBody4 = requestBody2;
                niceResponse = (NiceResponse) $result3;
                headers2 = headers;
                genre8 = genre6;
                pg2 = pg;
                year4 = classify2;
                response = niceResponse;
                if (response.getCode() != 401) {
                }
                bearerToken = jsonNode;
                sharedPreferences = movieBoxProvider.sharedPref;
                if (sharedPreferences != null) {
                    editorRemove.apply();
                    Unit unit4 = Unit.INSTANCE;
                }
                if (StringsKt.contains$default(request5.getData(), "|", false, 2, jsonNode)) {
                    c00022.L$0 = request5;
                    c00022.L$1 = url3;
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(data3);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts5);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId4);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(country3);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(year4);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre8);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort3);
                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody5);
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers2);
                    c00022.L$13 = requestBody4;
                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(response);
                    c00022.I$0 = page3;
                    c00022.I$1 = perPage4;
                    c00022.I$2 = pg2;
                    c00022.label = 5;
                    requestBody7 = requestBody4;
                    url5 = url3;
                    year7 = year4;
                    obj2 = obj;
                    objBuildAuthHeaders$default4 = buildAuthHeaders$default(this, "POST", url5, "application/json; charset=utf-8", null, jsonBody5, false, c00022, 40, null);
                    jsonBody8 = jsonBody5;
                    if (objBuildAuthHeaders$default4 == obj2) {
                        return obj2;
                    }
                    int i7 = pg2;
                    $result3 = objBuildAuthHeaders$default4;
                    pg4 = i7;
                    page5 = page3;
                    request6 = request5;
                    requestBody8 = requestBody7;
                    genre10 = genre8;
                    headers4 = headers2;
                    response3 = response;
                    jsonBody9 = jsonBody8;
                    sort5 = sort3;
                    year8 = year7;
                    response4 = response3;
                    jsonBody10 = jsonBody9;
                    perPage5 = perPage4;
                    jsonBody11 = url5;
                    url6 = channelId4;
                    requestBody9 = requestBody8;
                    year9 = year8;
                    headers5 = (Map) $result3;
                    genre11 = country3;
                    year10 = data3;
                    pg5 = pg4;
                    mainParts6 = mainParts5;
                    page7 = page5;
                    data4 = year10;
                    mainParts7 = mainParts6;
                    channelId5 = url6;
                    jsonNode = null;
                    if (StringsKt.contains$default(request6.getData(), "|", false, 2, (Object) null)) {
                        Requests app17 = MainActivityKt.getApp();
                        c00022.L$0 = request6;
                        c00022.L$1 = SpillingKt.nullOutSpilledVariable(jsonBody11);
                        c00022.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                        c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts7);
                        c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId5);
                        c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                        c00022.L$6 = SpillingKt.nullOutSpilledVariable(genre11);
                        c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                        c00022.L$8 = SpillingKt.nullOutSpilledVariable(year9);
                        c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre10);
                        c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort5);
                        c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody10);
                        c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers5);
                        c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody9);
                        c00022.L$14 = SpillingKt.nullOutSpilledVariable(response4);
                        c00022.I$0 = page7;
                        c00022.I$1 = perPage5;
                        c00022.I$2 = pg5;
                        c00022.label = 7;
                        $result3 = Requests.post$default(app17, jsonBody11, headers5, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody9, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                        requestBody12 = requestBody9;
                        if ($result3 == obj2) {
                            return obj2;
                        }
                        data6 = data4;
                        mainParts9 = mainParts7;
                        classify5 = genre11;
                        page9 = page7;
                        pg6 = pg5;
                        headers6 = headers5;
                        requestBody13 = requestBody12;
                        request8 = request6;
                        country5 = country2;
                        niceResponse2 = (NiceResponse) $result3;
                        request5 = request8;
                        page10 = page9;
                        response = niceResponse2;
                        requestBody4 = requestBody13;
                        page6 = page10;
                        responseBody = response.getText();
                        mapper = ExtensionsKt.jacksonObjectMapper();
                        root = mapper.readTree(responseBody);
                        str = str2;
                        jsonNode2 = root.get(str);
                        if (jsonNode2 == null) {
                            jsonNode5 = root.get(str);
                            if (jsonNode5 != null) {
                                jsonNode6 = jsonNode5.get("subjects");
                            } else {
                                jsonNode6 = jsonNode;
                            }
                            if (jsonNode6 == null) {
                                return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                            }
                            items = jsonNode6;
                            Iterable $this$mapNotNull$iv19 = (Iterable) items;
                            destination$iv$iv = new ArrayList();
                            while (r27.hasNext()) {
                                final JsonNode item19 = (JsonNode) element$iv$iv$iv;
                                ObjectMapper mapper110 = mapper;
                                jsonNode3 = item19.get("title");
                                if (jsonNode3 != null) {
                                    page11 = page6;
                                    responseBody2 = responseBody;
                                    requestBody14 = requestBody4;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    page11 = page6;
                                    responseBody2 = responseBody;
                                    requestBody14 = requestBody4;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                                if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                    destination$iv$iv2 = destination$iv$iv;
                                    destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                                } else {
                                    destination$iv$iv2 = destination$iv$iv;
                                }
                                destination$iv$iv = destination$iv$iv2;
                                mapper = mapper110;
                                responseBody = responseBody2;
                                requestBody4 = requestBody14;
                                page6 = page11;
                                break;
                            }
                            listEmptyList = (List) destination$iv$iv;
                            break;
                        } else {
                            items = jsonNode2.get("items");
                            if (items == null) {
                                jsonNode5 = root.get(str);
                                if (jsonNode5 != null) {
                                    jsonNode6 = jsonNode5.get("subjects");
                                } else {
                                    jsonNode6 = jsonNode;
                                }
                                if (jsonNode6 == null) {
                                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                                }
                                items = jsonNode6;
                            }
                            Iterable $this$mapNotNull$iv110 = (Iterable) items;
                            destination$iv$iv = new ArrayList();
                            while (r27.hasNext()) {
                                final JsonNode item110 = (JsonNode) element$iv$iv$iv;
                                ObjectMapper mapper111 = mapper;
                                jsonNode3 = item110.get("title");
                                if (jsonNode3 != null) {
                                    page11 = page6;
                                    responseBody2 = responseBody;
                                    requestBody14 = requestBody4;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    page11 = page6;
                                    responseBody2 = responseBody;
                                    requestBody14 = requestBody4;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                                if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                    destination$iv$iv2 = destination$iv$iv;
                                    destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                                } else {
                                    destination$iv$iv2 = destination$iv$iv;
                                }
                                destination$iv$iv = destination$iv$iv2;
                                mapper = mapper111;
                                responseBody = responseBody2;
                                requestBody4 = requestBody14;
                                page6 = page11;
                                break;
                            }
                            listEmptyList = (List) destination$iv$iv;
                            break;
                        }
                        if (listEmptyList == null) {
                            listEmptyList = CollectionsKt.emptyList();
                        }
                        List data19 = listEmptyList;
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data19, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                    }
                    requestBody10 = requestBody9;
                    Requests app18 = MainActivityKt.getApp();
                    c00022.L$0 = request6;
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(jsonBody11);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts7);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId5);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(genre11);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(year9);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre10);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort5);
                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody10);
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers5);
                    c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody10);
                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(response4);
                    c00022.I$0 = page7;
                    c00022.I$1 = perPage5;
                    c00022.I$2 = pg5;
                    c00022.label = 8;
                    $result3 = Requests.get$default(app18, jsonBody11, headers5, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                    if ($result3 == obj2) {
                        return obj2;
                    }
                    data5 = data4;
                    mainParts8 = mainParts7;
                    classify4 = genre11;
                    page8 = page7;
                    pg6 = pg5;
                    perPage6 = perPage5;
                    genre12 = genre10;
                    year11 = year9;
                    response5 = response4;
                    requestBody11 = requestBody10;
                    request7 = request6;
                    country4 = country2;
                    niceResponse2 = (NiceResponse) $result3;
                    requestBody13 = requestBody11;
                    request5 = request7;
                    page10 = page8;
                    response = niceResponse2;
                    requestBody4 = requestBody13;
                    page6 = page10;
                    responseBody = response.getText();
                    mapper = ExtensionsKt.jacksonObjectMapper();
                    root = mapper.readTree(responseBody);
                    str = str2;
                    jsonNode2 = root.get(str);
                    if (jsonNode2 == null) {
                        jsonNode5 = root.get(str);
                        if (jsonNode5 != null) {
                            jsonNode6 = jsonNode5.get("subjects");
                        } else {
                            jsonNode6 = jsonNode;
                        }
                        if (jsonNode6 == null) {
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                        }
                        items = jsonNode6;
                        Iterable $this$mapNotNull$iv111 = (Iterable) items;
                        destination$iv$iv = new ArrayList();
                        while (r27.hasNext()) {
                            final JsonNode item111 = (JsonNode) element$iv$iv$iv;
                            ObjectMapper mapper112 = mapper;
                            jsonNode3 = item111.get("title");
                            if (jsonNode3 != null) {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                destination$iv$iv2 = destination$iv$iv;
                                destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                destination$iv$iv2 = destination$iv$iv;
                            }
                            destination$iv$iv = destination$iv$iv2;
                            mapper = mapper112;
                            responseBody = responseBody2;
                            requestBody4 = requestBody14;
                            page6 = page11;
                            break;
                        }
                        listEmptyList = (List) destination$iv$iv;
                        break;
                    } else {
                        items = jsonNode2.get("items");
                        if (items == null) {
                            jsonNode5 = root.get(str);
                            if (jsonNode5 != null) {
                                jsonNode6 = jsonNode5.get("subjects");
                            } else {
                                jsonNode6 = jsonNode;
                            }
                            if (jsonNode6 == null) {
                                return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                            }
                            items = jsonNode6;
                        }
                        Iterable $this$mapNotNull$iv112 = (Iterable) items;
                        destination$iv$iv = new ArrayList();
                        while (r27.hasNext()) {
                            final JsonNode item112 = (JsonNode) element$iv$iv$iv;
                            ObjectMapper mapper113 = mapper;
                            jsonNode3 = item112.get("title");
                            if (jsonNode3 != null) {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                destination$iv$iv2 = destination$iv$iv;
                                destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                destination$iv$iv2 = destination$iv$iv;
                            }
                            destination$iv$iv = destination$iv$iv2;
                            mapper = mapper113;
                            responseBody = responseBody2;
                            requestBody4 = requestBody14;
                            page6 = page11;
                            break;
                        }
                        listEmptyList = (List) destination$iv$iv;
                        break;
                    }
                    if (listEmptyList == null) {
                        listEmptyList = CollectionsKt.emptyList();
                    }
                    List data110 = listEmptyList;
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data110, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                }
                jsonBody6 = jsonBody5;
                url4 = url3;
                year5 = year4;
                obj2 = obj;
                requestBody5 = requestBody4;
                c00022.L$0 = request5;
                c00022.L$1 = url4;
                c00022.L$2 = SpillingKt.nullOutSpilledVariable(data3);
                c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts5);
                c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId4);
                c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                c00022.L$6 = SpillingKt.nullOutSpilledVariable(country3);
                c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                c00022.L$8 = SpillingKt.nullOutSpilledVariable(year5);
                c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre8);
                c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort3);
                c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody6);
                c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers2);
                c00022.L$13 = requestBody5;
                c00022.L$14 = SpillingKt.nullOutSpilledVariable(response);
                c00022.I$0 = page3;
                c00022.I$1 = perPage4;
                c00022.I$2 = pg2;
                c00022.label = 6;
                objBuildAuthHeaders$default3 = buildAuthHeaders$default(this, "GET", url4, null, null, null, false, c00022, 60, null);
                if (objBuildAuthHeaders$default3 == obj2) {
                    return obj2;
                }
                int i8 = pg2;
                $result3 = objBuildAuthHeaders$default3;
                pg3 = i8;
                page4 = page3;
                request6 = request5;
                requestBody6 = requestBody5;
                genre9 = genre8;
                headers3 = headers2;
                response2 = response;
                jsonBody7 = jsonBody6;
                sort4 = sort3;
                year6 = year5;
                response4 = response2;
                jsonBody10 = jsonBody7;
                sort5 = sort4;
                perPage5 = perPage4;
                jsonBody11 = url4;
                genre10 = genre9;
                url6 = channelId4;
                requestBody9 = requestBody6;
                year9 = year6;
                headers5 = (Map) $result3;
                page7 = page4;
                year10 = data3;
                genre11 = country3;
                pg5 = pg3;
                mainParts6 = mainParts5;
                data4 = year10;
                mainParts7 = mainParts6;
                channelId5 = url6;
                jsonNode = null;
                if (StringsKt.contains$default(request6.getData(), "|", false, 2, (Object) null)) {
                    Requests app19 = MainActivityKt.getApp();
                    c00022.L$0 = request6;
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(jsonBody11);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts7);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId5);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(genre11);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(year9);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre10);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort5);
                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody10);
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers5);
                    c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody9);
                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(response4);
                    c00022.I$0 = page7;
                    c00022.I$1 = perPage5;
                    c00022.I$2 = pg5;
                    c00022.label = 7;
                    $result3 = Requests.post$default(app19, jsonBody11, headers5, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody9, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                    requestBody12 = requestBody9;
                    if ($result3 == obj2) {
                        return obj2;
                    }
                    data6 = data4;
                    mainParts9 = mainParts7;
                    classify5 = genre11;
                    page9 = page7;
                    pg6 = pg5;
                    headers6 = headers5;
                    requestBody13 = requestBody12;
                    request8 = request6;
                    country5 = country2;
                    niceResponse2 = (NiceResponse) $result3;
                    request5 = request8;
                    page10 = page9;
                    response = niceResponse2;
                    requestBody4 = requestBody13;
                    page6 = page10;
                    responseBody = response.getText();
                    mapper = ExtensionsKt.jacksonObjectMapper();
                    root = mapper.readTree(responseBody);
                    str = str2;
                    jsonNode2 = root.get(str);
                    if (jsonNode2 == null) {
                        jsonNode5 = root.get(str);
                        if (jsonNode5 != null) {
                            jsonNode6 = jsonNode5.get("subjects");
                        } else {
                            jsonNode6 = jsonNode;
                        }
                        if (jsonNode6 == null) {
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                        }
                        items = jsonNode6;
                        Iterable $this$mapNotNull$iv113 = (Iterable) items;
                        destination$iv$iv = new ArrayList();
                        while (r27.hasNext()) {
                            final JsonNode item113 = (JsonNode) element$iv$iv$iv;
                            ObjectMapper mapper114 = mapper;
                            jsonNode3 = item113.get("title");
                            if (jsonNode3 != null) {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                destination$iv$iv2 = destination$iv$iv;
                                destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                destination$iv$iv2 = destination$iv$iv;
                            }
                            destination$iv$iv = destination$iv$iv2;
                            mapper = mapper114;
                            responseBody = responseBody2;
                            requestBody4 = requestBody14;
                            page6 = page11;
                            break;
                        }
                        listEmptyList = (List) destination$iv$iv;
                        break;
                    } else {
                        items = jsonNode2.get("items");
                        if (items == null) {
                            jsonNode5 = root.get(str);
                            if (jsonNode5 != null) {
                                jsonNode6 = jsonNode5.get("subjects");
                            } else {
                                jsonNode6 = jsonNode;
                            }
                            if (jsonNode6 == null) {
                                return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                            }
                            items = jsonNode6;
                        }
                        Iterable $this$mapNotNull$iv114 = (Iterable) items;
                        destination$iv$iv = new ArrayList();
                        while (r27.hasNext()) {
                            final JsonNode item114 = (JsonNode) element$iv$iv$iv;
                            ObjectMapper mapper115 = mapper;
                            jsonNode3 = item114.get("title");
                            if (jsonNode3 != null) {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                destination$iv$iv2 = destination$iv$iv;
                                destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                destination$iv$iv2 = destination$iv$iv;
                            }
                            destination$iv$iv = destination$iv$iv2;
                            mapper = mapper115;
                            responseBody = responseBody2;
                            requestBody4 = requestBody14;
                            page6 = page11;
                            break;
                        }
                        listEmptyList = (List) destination$iv$iv;
                        break;
                    }
                    if (listEmptyList == null) {
                        listEmptyList = CollectionsKt.emptyList();
                    }
                    List data111 = listEmptyList;
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data111, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                }
                requestBody10 = requestBody9;
                Requests app110 = MainActivityKt.getApp();
                c00022.L$0 = request6;
                c00022.L$1 = SpillingKt.nullOutSpilledVariable(jsonBody11);
                c00022.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts7);
                c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId5);
                c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                c00022.L$6 = SpillingKt.nullOutSpilledVariable(genre11);
                c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                c00022.L$8 = SpillingKt.nullOutSpilledVariable(year9);
                c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre10);
                c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort5);
                c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody10);
                c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers5);
                c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody10);
                c00022.L$14 = SpillingKt.nullOutSpilledVariable(response4);
                c00022.I$0 = page7;
                c00022.I$1 = perPage5;
                c00022.I$2 = pg5;
                c00022.label = 8;
                $result3 = Requests.get$default(app110, jsonBody11, headers5, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                if ($result3 == obj2) {
                    return obj2;
                }
                data5 = data4;
                mainParts8 = mainParts7;
                classify4 = genre11;
                page8 = page7;
                pg6 = pg5;
                perPage6 = perPage5;
                genre12 = genre10;
                year11 = year9;
                response5 = response4;
                requestBody11 = requestBody10;
                request7 = request6;
                country4 = country2;
                niceResponse2 = (NiceResponse) $result3;
                requestBody13 = requestBody11;
                request5 = request7;
                page10 = page8;
                response = niceResponse2;
                requestBody4 = requestBody13;
                page6 = page10;
                responseBody = response.getText();
                mapper = ExtensionsKt.jacksonObjectMapper();
                root = mapper.readTree(responseBody);
                str = str2;
                jsonNode2 = root.get(str);
                if (jsonNode2 == null) {
                    jsonNode5 = root.get(str);
                    if (jsonNode5 != null) {
                        jsonNode6 = jsonNode5.get("subjects");
                    } else {
                        jsonNode6 = jsonNode;
                    }
                    if (jsonNode6 == null) {
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                    }
                    items = jsonNode6;
                    Iterable $this$mapNotNull$iv115 = (Iterable) items;
                    destination$iv$iv = new ArrayList();
                    while (r27.hasNext()) {
                        final JsonNode item115 = (JsonNode) element$iv$iv$iv;
                        ObjectMapper mapper116 = mapper;
                        jsonNode3 = item115.get("title");
                        if (jsonNode3 != null) {
                            page11 = page6;
                            responseBody2 = responseBody;
                            requestBody14 = requestBody4;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            page11 = page6;
                            responseBody2 = responseBody;
                            requestBody14 = requestBody4;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        }
                        if (movieSearchResponseNewMovieSearchResponse$default != null) {
                            destination$iv$iv2 = destination$iv$iv;
                            destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                        } else {
                            destination$iv$iv2 = destination$iv$iv;
                        }
                        destination$iv$iv = destination$iv$iv2;
                        mapper = mapper116;
                        responseBody = responseBody2;
                        requestBody4 = requestBody14;
                        page6 = page11;
                        break;
                    }
                    listEmptyList = (List) destination$iv$iv;
                    break;
                } else {
                    items = jsonNode2.get("items");
                    if (items == null) {
                        jsonNode5 = root.get(str);
                        if (jsonNode5 != null) {
                            jsonNode6 = jsonNode5.get("subjects");
                        } else {
                            jsonNode6 = jsonNode;
                        }
                        if (jsonNode6 == null) {
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                        }
                        items = jsonNode6;
                    }
                    Iterable $this$mapNotNull$iv116 = (Iterable) items;
                    destination$iv$iv = new ArrayList();
                    while (r27.hasNext()) {
                        final JsonNode item116 = (JsonNode) element$iv$iv$iv;
                        ObjectMapper mapper117 = mapper;
                        jsonNode3 = item116.get("title");
                        if (jsonNode3 != null) {
                            page11 = page6;
                            responseBody2 = responseBody;
                            requestBody14 = requestBody4;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            page11 = page6;
                            responseBody2 = responseBody;
                            requestBody14 = requestBody4;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        }
                        if (movieSearchResponseNewMovieSearchResponse$default != null) {
                            destination$iv$iv2 = destination$iv$iv;
                            destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                        } else {
                            destination$iv$iv2 = destination$iv$iv;
                        }
                        destination$iv$iv = destination$iv$iv2;
                        mapper = mapper117;
                        responseBody = responseBody2;
                        requestBody4 = requestBody14;
                        page6 = page11;
                        break;
                    }
                    listEmptyList = (List) destination$iv$iv;
                    break;
                }
                if (listEmptyList == null) {
                    listEmptyList = CollectionsKt.emptyList();
                }
                List data112 = listEmptyList;
                return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data112, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
            case 1:
                int pg8 = c00022.I$2;
                int perPage7 = c00022.I$1;
                int page13 = c00022.I$0;
                jsonBody2 = (String) c00022.L$11;
                sort2 = (String) c00022.L$10;
                genre3 = (String) c00022.L$9;
                year2 = (String) c00022.L$8;
                country = (String) c00022.L$7;
                classify = (String) c00022.L$6;
                Map options5 = (Map) c00022.L$5;
                String channelId7 = (String) c00022.L$4;
                mainParts2 = (List) c00022.L$3;
                genre4 = (String) c00022.L$2;
                String url7 = (String) c00022.L$1;
                MainPageRequest request10 = (MainPageRequest) c00022.L$0;
                ResultKt.throwOnFailure($result3);
                request9 = request10;
                pg = pg8;
                objBuildAuthHeaders$default2 = $result3;
                page12 = page13;
                channelId2 = channelId7;
                options = options5;
                perPage2 = perPage7;
                $result = objBuildAuthHeaders$default2;
                url = url7;
                movieBoxProvider = this;
                headers = (Map) objBuildAuthHeaders$default2;
                sort3 = sort2;
                genre5 = genre3;
                year3 = year2;
                perPage3 = perPage2;
                options2 = options;
                data1 = genre4;
                page2 = page12;
                url2 = url;
                request2 = request9;
                mainParts3 = mainParts2;
                jsonBody3 = jsonBody2;
                jsonBody4 = channelId2;
                data2 = data1;
                mainParts4 = mainParts3;
                requestBody = RequestBody.Companion.create(jsonBody3, MediaType.Companion.get("application/json"));
                channelId3 = jsonBody4;
                options3 = options2;
                country2 = country;
                if (StringsKt.contains$default(request2.getData(), "|", false, 2, (Object) null)) {
                    Requests app111 = MainActivityKt.getApp();
                    c00022.L$0 = request2;
                    c00022.L$1 = url2;
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(data2);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts4);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId3);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(classify);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(year3);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre5);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort3);
                    c00022.L$11 = jsonBody3;
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers);
                    c00022.L$13 = requestBody;
                    c00022.I$0 = page2;
                    c00022.I$1 = perPage3;
                    c00022.I$2 = pg;
                    c00022.label = 3;
                    obj = coroutine_suspended;
                    $result2 = $result;
                    jsonNode = null;
                    $result3 = Requests.post$default(app111, url2, headers, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                    if ($result3 == obj) {
                        return obj;
                    }
                    data3 = data2;
                    mainParts5 = mainParts4;
                    requestBody3 = requestBody;
                    country3 = classify;
                    genre7 = genre5;
                    classify3 = year3;
                    channelId4 = channelId3;
                    request4 = request2;
                    page3 = page2;
                    jsonBody5 = jsonBody3;
                    String str10 = url2;
                    perPage4 = perPage3;
                    url3 = str10;
                    request5 = request4;
                    requestBody4 = requestBody3;
                    niceResponse = (NiceResponse) $result3;
                    headers2 = headers;
                    genre8 = genre7;
                    pg2 = pg;
                    year4 = classify3;
                    response = niceResponse;
                    if (response.getCode() != 401) {
                        break;
                    }
                    bearerToken = jsonNode;
                    sharedPreferences = movieBoxProvider.sharedPref;
                    if (sharedPreferences != null) {
                        editorRemove.apply();
                        Unit unit5 = Unit.INSTANCE;
                    }
                    if (StringsKt.contains$default(request5.getData(), "|", false, 2, jsonNode)) {
                        c00022.L$0 = request5;
                        c00022.L$1 = url3;
                        c00022.L$2 = SpillingKt.nullOutSpilledVariable(data3);
                        c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts5);
                        c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId4);
                        c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                        c00022.L$6 = SpillingKt.nullOutSpilledVariable(country3);
                        c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                        c00022.L$8 = SpillingKt.nullOutSpilledVariable(year4);
                        c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre8);
                        c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort3);
                        c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody5);
                        c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers2);
                        c00022.L$13 = requestBody4;
                        c00022.L$14 = SpillingKt.nullOutSpilledVariable(response);
                        c00022.I$0 = page3;
                        c00022.I$1 = perPage4;
                        c00022.I$2 = pg2;
                        c00022.label = 5;
                        requestBody7 = requestBody4;
                        url5 = url3;
                        year7 = year4;
                        obj2 = obj;
                        objBuildAuthHeaders$default4 = buildAuthHeaders$default(this, "POST", url5, "application/json; charset=utf-8", null, jsonBody5, false, c00022, 40, null);
                        jsonBody8 = jsonBody5;
                        if (objBuildAuthHeaders$default4 == obj2) {
                            return obj2;
                        }
                        int i9 = pg2;
                        $result3 = objBuildAuthHeaders$default4;
                        pg4 = i9;
                        page5 = page3;
                        request6 = request5;
                        requestBody8 = requestBody7;
                        genre10 = genre8;
                        headers4 = headers2;
                        response3 = response;
                        jsonBody9 = jsonBody8;
                        sort5 = sort3;
                        year8 = year7;
                        response4 = response3;
                        jsonBody10 = jsonBody9;
                        perPage5 = perPage4;
                        jsonBody11 = url5;
                        url6 = channelId4;
                        requestBody9 = requestBody8;
                        year9 = year8;
                        headers5 = (Map) $result3;
                        genre11 = country3;
                        year10 = data3;
                        pg5 = pg4;
                        mainParts6 = mainParts5;
                        page7 = page5;
                        data4 = year10;
                        mainParts7 = mainParts6;
                        channelId5 = url6;
                        jsonNode = null;
                        if (StringsKt.contains$default(request6.getData(), "|", false, 2, (Object) null)) {
                            Requests app112 = MainActivityKt.getApp();
                            c00022.L$0 = request6;
                            c00022.L$1 = SpillingKt.nullOutSpilledVariable(jsonBody11);
                            c00022.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                            c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts7);
                            c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId5);
                            c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                            c00022.L$6 = SpillingKt.nullOutSpilledVariable(genre11);
                            c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                            c00022.L$8 = SpillingKt.nullOutSpilledVariable(year9);
                            c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre10);
                            c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort5);
                            c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody10);
                            c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers5);
                            c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody9);
                            c00022.L$14 = SpillingKt.nullOutSpilledVariable(response4);
                            c00022.I$0 = page7;
                            c00022.I$1 = perPage5;
                            c00022.I$2 = pg5;
                            c00022.label = 7;
                            $result3 = Requests.post$default(app112, jsonBody11, headers5, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody9, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                            requestBody12 = requestBody9;
                            if ($result3 == obj2) {
                                return obj2;
                            }
                            data6 = data4;
                            mainParts9 = mainParts7;
                            classify5 = genre11;
                            page9 = page7;
                            pg6 = pg5;
                            headers6 = headers5;
                            requestBody13 = requestBody12;
                            request8 = request6;
                            country5 = country2;
                            niceResponse2 = (NiceResponse) $result3;
                            request5 = request8;
                            page10 = page9;
                            response = niceResponse2;
                            requestBody4 = requestBody13;
                            page6 = page10;
                            responseBody = response.getText();
                            mapper = ExtensionsKt.jacksonObjectMapper();
                            root = mapper.readTree(responseBody);
                            str = str2;
                            jsonNode2 = root.get(str);
                            if (jsonNode2 == null) {
                                jsonNode5 = root.get(str);
                                if (jsonNode5 != null) {
                                    jsonNode6 = jsonNode5.get("subjects");
                                } else {
                                    jsonNode6 = jsonNode;
                                }
                                if (jsonNode6 == null) {
                                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                                }
                                items = jsonNode6;
                                Iterable $this$mapNotNull$iv117 = (Iterable) items;
                                destination$iv$iv = new ArrayList();
                                while (r27.hasNext()) {
                                    final JsonNode item117 = (JsonNode) element$iv$iv$iv;
                                    ObjectMapper mapper118 = mapper;
                                    jsonNode3 = item117.get("title");
                                    if (jsonNode3 != null) {
                                        page11 = page6;
                                        responseBody2 = responseBody;
                                        requestBody14 = requestBody4;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    } else {
                                        page11 = page6;
                                        responseBody2 = responseBody;
                                        requestBody14 = requestBody4;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    }
                                    if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                        destination$iv$iv2 = destination$iv$iv;
                                        destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                                    } else {
                                        destination$iv$iv2 = destination$iv$iv;
                                    }
                                    destination$iv$iv = destination$iv$iv2;
                                    mapper = mapper118;
                                    responseBody = responseBody2;
                                    requestBody4 = requestBody14;
                                    page6 = page11;
                                    break;
                                }
                                listEmptyList = (List) destination$iv$iv;
                                break;
                            } else {
                                items = jsonNode2.get("items");
                                if (items == null) {
                                    jsonNode5 = root.get(str);
                                    if (jsonNode5 != null) {
                                        jsonNode6 = jsonNode5.get("subjects");
                                    } else {
                                        jsonNode6 = jsonNode;
                                    }
                                    if (jsonNode6 == null) {
                                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                                    }
                                    items = jsonNode6;
                                }
                                Iterable $this$mapNotNull$iv118 = (Iterable) items;
                                destination$iv$iv = new ArrayList();
                                while (r27.hasNext()) {
                                    final JsonNode item118 = (JsonNode) element$iv$iv$iv;
                                    ObjectMapper mapper119 = mapper;
                                    jsonNode3 = item118.get("title");
                                    if (jsonNode3 != null) {
                                        page11 = page6;
                                        responseBody2 = responseBody;
                                        requestBody14 = requestBody4;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    } else {
                                        page11 = page6;
                                        responseBody2 = responseBody;
                                        requestBody14 = requestBody4;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    }
                                    if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                        destination$iv$iv2 = destination$iv$iv;
                                        destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                                    } else {
                                        destination$iv$iv2 = destination$iv$iv;
                                    }
                                    destination$iv$iv = destination$iv$iv2;
                                    mapper = mapper119;
                                    responseBody = responseBody2;
                                    requestBody4 = requestBody14;
                                    page6 = page11;
                                    break;
                                }
                                listEmptyList = (List) destination$iv$iv;
                                break;
                            }
                            if (listEmptyList == null) {
                                listEmptyList = CollectionsKt.emptyList();
                            }
                            List data113 = listEmptyList;
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data113, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                        }
                        requestBody10 = requestBody9;
                        Requests app113 = MainActivityKt.getApp();
                        c00022.L$0 = request6;
                        c00022.L$1 = SpillingKt.nullOutSpilledVariable(jsonBody11);
                        c00022.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                        c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts7);
                        c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId5);
                        c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                        c00022.L$6 = SpillingKt.nullOutSpilledVariable(genre11);
                        c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                        c00022.L$8 = SpillingKt.nullOutSpilledVariable(year9);
                        c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre10);
                        c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort5);
                        c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody10);
                        c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers5);
                        c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody10);
                        c00022.L$14 = SpillingKt.nullOutSpilledVariable(response4);
                        c00022.I$0 = page7;
                        c00022.I$1 = perPage5;
                        c00022.I$2 = pg5;
                        c00022.label = 8;
                        $result3 = Requests.get$default(app113, jsonBody11, headers5, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                        if ($result3 == obj2) {
                            return obj2;
                        }
                        data5 = data4;
                        mainParts8 = mainParts7;
                        classify4 = genre11;
                        page8 = page7;
                        pg6 = pg5;
                        perPage6 = perPage5;
                        genre12 = genre10;
                        year11 = year9;
                        response5 = response4;
                        requestBody11 = requestBody10;
                        request7 = request6;
                        country4 = country2;
                        niceResponse2 = (NiceResponse) $result3;
                        requestBody13 = requestBody11;
                        request5 = request7;
                        page10 = page8;
                        response = niceResponse2;
                        requestBody4 = requestBody13;
                        page6 = page10;
                        responseBody = response.getText();
                        mapper = ExtensionsKt.jacksonObjectMapper();
                        root = mapper.readTree(responseBody);
                        str = str2;
                        jsonNode2 = root.get(str);
                        if (jsonNode2 == null) {
                            jsonNode5 = root.get(str);
                            if (jsonNode5 != null) {
                                jsonNode6 = jsonNode5.get("subjects");
                            } else {
                                jsonNode6 = jsonNode;
                            }
                            if (jsonNode6 == null) {
                                return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                            }
                            items = jsonNode6;
                            Iterable $this$mapNotNull$iv119 = (Iterable) items;
                            destination$iv$iv = new ArrayList();
                            while (r27.hasNext()) {
                                final JsonNode item119 = (JsonNode) element$iv$iv$iv;
                                ObjectMapper mapper1110 = mapper;
                                jsonNode3 = item119.get("title");
                                if (jsonNode3 != null) {
                                    page11 = page6;
                                    responseBody2 = responseBody;
                                    requestBody14 = requestBody4;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    page11 = page6;
                                    responseBody2 = responseBody;
                                    requestBody14 = requestBody4;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                                if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                    destination$iv$iv2 = destination$iv$iv;
                                    destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                                } else {
                                    destination$iv$iv2 = destination$iv$iv;
                                }
                                destination$iv$iv = destination$iv$iv2;
                                mapper = mapper1110;
                                responseBody = responseBody2;
                                requestBody4 = requestBody14;
                                page6 = page11;
                                break;
                            }
                            listEmptyList = (List) destination$iv$iv;
                            break;
                        } else {
                            items = jsonNode2.get("items");
                            if (items == null) {
                                jsonNode5 = root.get(str);
                                if (jsonNode5 != null) {
                                    jsonNode6 = jsonNode5.get("subjects");
                                } else {
                                    jsonNode6 = jsonNode;
                                }
                                if (jsonNode6 == null) {
                                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                                }
                                items = jsonNode6;
                            }
                            Iterable $this$mapNotNull$iv1110 = (Iterable) items;
                            destination$iv$iv = new ArrayList();
                            while (r27.hasNext()) {
                                final JsonNode item1110 = (JsonNode) element$iv$iv$iv;
                                ObjectMapper mapper1111 = mapper;
                                jsonNode3 = item1110.get("title");
                                if (jsonNode3 != null) {
                                    page11 = page6;
                                    responseBody2 = responseBody;
                                    requestBody14 = requestBody4;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    page11 = page6;
                                    responseBody2 = responseBody;
                                    requestBody14 = requestBody4;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                                if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                    destination$iv$iv2 = destination$iv$iv;
                                    destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                                } else {
                                    destination$iv$iv2 = destination$iv$iv;
                                }
                                destination$iv$iv = destination$iv$iv2;
                                mapper = mapper1111;
                                responseBody = responseBody2;
                                requestBody4 = requestBody14;
                                page6 = page11;
                                break;
                            }
                            listEmptyList = (List) destination$iv$iv;
                            break;
                        }
                        if (listEmptyList == null) {
                            listEmptyList = CollectionsKt.emptyList();
                        }
                        List data114 = listEmptyList;
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data114, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                    }
                    jsonBody6 = jsonBody5;
                    url4 = url3;
                    year5 = year4;
                    obj2 = obj;
                    requestBody5 = requestBody4;
                    c00022.L$0 = request5;
                    c00022.L$1 = url4;
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(data3);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts5);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId4);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(country3);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(year5);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre8);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort3);
                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody6);
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers2);
                    c00022.L$13 = requestBody5;
                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(response);
                    c00022.I$0 = page3;
                    c00022.I$1 = perPage4;
                    c00022.I$2 = pg2;
                    c00022.label = 6;
                    objBuildAuthHeaders$default3 = buildAuthHeaders$default(this, "GET", url4, null, null, null, false, c00022, 60, null);
                    if (objBuildAuthHeaders$default3 == obj2) {
                        return obj2;
                    }
                    int i10 = pg2;
                    $result3 = objBuildAuthHeaders$default3;
                    pg3 = i10;
                    page4 = page3;
                    request6 = request5;
                    requestBody6 = requestBody5;
                    genre9 = genre8;
                    headers3 = headers2;
                    response2 = response;
                    jsonBody7 = jsonBody6;
                    sort4 = sort3;
                    year6 = year5;
                    response4 = response2;
                    jsonBody10 = jsonBody7;
                    sort5 = sort4;
                    perPage5 = perPage4;
                    jsonBody11 = url4;
                    genre10 = genre9;
                    url6 = channelId4;
                    requestBody9 = requestBody6;
                    year9 = year6;
                    headers5 = (Map) $result3;
                    page7 = page4;
                    year10 = data3;
                    genre11 = country3;
                    pg5 = pg3;
                    mainParts6 = mainParts5;
                    data4 = year10;
                    mainParts7 = mainParts6;
                    channelId5 = url6;
                    jsonNode = null;
                    if (StringsKt.contains$default(request6.getData(), "|", false, 2, (Object) null)) {
                        Requests app114 = MainActivityKt.getApp();
                        c00022.L$0 = request6;
                        c00022.L$1 = SpillingKt.nullOutSpilledVariable(jsonBody11);
                        c00022.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                        c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts7);
                        c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId5);
                        c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                        c00022.L$6 = SpillingKt.nullOutSpilledVariable(genre11);
                        c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                        c00022.L$8 = SpillingKt.nullOutSpilledVariable(year9);
                        c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre10);
                        c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort5);
                        c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody10);
                        c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers5);
                        c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody9);
                        c00022.L$14 = SpillingKt.nullOutSpilledVariable(response4);
                        c00022.I$0 = page7;
                        c00022.I$1 = perPage5;
                        c00022.I$2 = pg5;
                        c00022.label = 7;
                        $result3 = Requests.post$default(app114, jsonBody11, headers5, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody9, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                        requestBody12 = requestBody9;
                        if ($result3 == obj2) {
                            return obj2;
                        }
                        data6 = data4;
                        mainParts9 = mainParts7;
                        classify5 = genre11;
                        page9 = page7;
                        pg6 = pg5;
                        headers6 = headers5;
                        requestBody13 = requestBody12;
                        request8 = request6;
                        country5 = country2;
                        niceResponse2 = (NiceResponse) $result3;
                        request5 = request8;
                        page10 = page9;
                        response = niceResponse2;
                        requestBody4 = requestBody13;
                        page6 = page10;
                        responseBody = response.getText();
                        mapper = ExtensionsKt.jacksonObjectMapper();
                        root = mapper.readTree(responseBody);
                        str = str2;
                        jsonNode2 = root.get(str);
                        if (jsonNode2 == null) {
                            jsonNode5 = root.get(str);
                            if (jsonNode5 != null) {
                                jsonNode6 = jsonNode5.get("subjects");
                            } else {
                                jsonNode6 = jsonNode;
                            }
                            if (jsonNode6 == null) {
                                return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                            }
                            items = jsonNode6;
                            Iterable $this$mapNotNull$iv1111 = (Iterable) items;
                            destination$iv$iv = new ArrayList();
                            while (r27.hasNext()) {
                                final JsonNode item1111 = (JsonNode) element$iv$iv$iv;
                                ObjectMapper mapper1112 = mapper;
                                jsonNode3 = item1111.get("title");
                                if (jsonNode3 != null) {
                                    page11 = page6;
                                    responseBody2 = responseBody;
                                    requestBody14 = requestBody4;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    page11 = page6;
                                    responseBody2 = responseBody;
                                    requestBody14 = requestBody4;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                                if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                    destination$iv$iv2 = destination$iv$iv;
                                    destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                                } else {
                                    destination$iv$iv2 = destination$iv$iv;
                                }
                                destination$iv$iv = destination$iv$iv2;
                                mapper = mapper1112;
                                responseBody = responseBody2;
                                requestBody4 = requestBody14;
                                page6 = page11;
                                break;
                            }
                            listEmptyList = (List) destination$iv$iv;
                            break;
                        } else {
                            items = jsonNode2.get("items");
                            if (items == null) {
                                jsonNode5 = root.get(str);
                                if (jsonNode5 != null) {
                                    jsonNode6 = jsonNode5.get("subjects");
                                } else {
                                    jsonNode6 = jsonNode;
                                }
                                if (jsonNode6 == null) {
                                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                                }
                                items = jsonNode6;
                            }
                            Iterable $this$mapNotNull$iv1112 = (Iterable) items;
                            destination$iv$iv = new ArrayList();
                            while (r27.hasNext()) {
                                final JsonNode item1112 = (JsonNode) element$iv$iv$iv;
                                ObjectMapper mapper1113 = mapper;
                                jsonNode3 = item1112.get("title");
                                if (jsonNode3 != null) {
                                    page11 = page6;
                                    responseBody2 = responseBody;
                                    requestBody14 = requestBody4;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    page11 = page6;
                                    responseBody2 = responseBody;
                                    requestBody14 = requestBody4;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                                if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                    destination$iv$iv2 = destination$iv$iv;
                                    destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                                } else {
                                    destination$iv$iv2 = destination$iv$iv;
                                }
                                destination$iv$iv = destination$iv$iv2;
                                mapper = mapper1113;
                                responseBody = responseBody2;
                                requestBody4 = requestBody14;
                                page6 = page11;
                                break;
                            }
                            listEmptyList = (List) destination$iv$iv;
                            break;
                        }
                        if (listEmptyList == null) {
                            listEmptyList = CollectionsKt.emptyList();
                        }
                        List data115 = listEmptyList;
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data115, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                    }
                    requestBody10 = requestBody9;
                    Requests app115 = MainActivityKt.getApp();
                    c00022.L$0 = request6;
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(jsonBody11);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts7);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId5);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(genre11);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(year9);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre10);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort5);
                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody10);
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers5);
                    c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody10);
                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(response4);
                    c00022.I$0 = page7;
                    c00022.I$1 = perPage5;
                    c00022.I$2 = pg5;
                    c00022.label = 8;
                    $result3 = Requests.get$default(app115, jsonBody11, headers5, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                    if ($result3 == obj2) {
                        return obj2;
                    }
                    data5 = data4;
                    mainParts8 = mainParts7;
                    classify4 = genre11;
                    page8 = page7;
                    pg6 = pg5;
                    perPage6 = perPage5;
                    genre12 = genre10;
                    year11 = year9;
                    response5 = response4;
                    requestBody11 = requestBody10;
                    request7 = request6;
                    country4 = country2;
                    niceResponse2 = (NiceResponse) $result3;
                    requestBody13 = requestBody11;
                    request5 = request7;
                    page10 = page8;
                    response = niceResponse2;
                    requestBody4 = requestBody13;
                    page6 = page10;
                    responseBody = response.getText();
                    mapper = ExtensionsKt.jacksonObjectMapper();
                    root = mapper.readTree(responseBody);
                    str = str2;
                    jsonNode2 = root.get(str);
                    if (jsonNode2 == null) {
                        jsonNode5 = root.get(str);
                        if (jsonNode5 != null) {
                            jsonNode6 = jsonNode5.get("subjects");
                        } else {
                            jsonNode6 = jsonNode;
                        }
                        if (jsonNode6 == null) {
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                        }
                        items = jsonNode6;
                        Iterable $this$mapNotNull$iv1113 = (Iterable) items;
                        destination$iv$iv = new ArrayList();
                        while (r27.hasNext()) {
                            final JsonNode item1113 = (JsonNode) element$iv$iv$iv;
                            ObjectMapper mapper1114 = mapper;
                            jsonNode3 = item1113.get("title");
                            if (jsonNode3 != null) {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                destination$iv$iv2 = destination$iv$iv;
                                destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                destination$iv$iv2 = destination$iv$iv;
                            }
                            destination$iv$iv = destination$iv$iv2;
                            mapper = mapper1114;
                            responseBody = responseBody2;
                            requestBody4 = requestBody14;
                            page6 = page11;
                            break;
                        }
                        listEmptyList = (List) destination$iv$iv;
                        break;
                    } else {
                        items = jsonNode2.get("items");
                        if (items == null) {
                            jsonNode5 = root.get(str);
                            if (jsonNode5 != null) {
                                jsonNode6 = jsonNode5.get("subjects");
                            } else {
                                jsonNode6 = jsonNode;
                            }
                            if (jsonNode6 == null) {
                                return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                            }
                            items = jsonNode6;
                        }
                        Iterable $this$mapNotNull$iv1114 = (Iterable) items;
                        destination$iv$iv = new ArrayList();
                        while (r27.hasNext()) {
                            final JsonNode item1114 = (JsonNode) element$iv$iv$iv;
                            ObjectMapper mapper1115 = mapper;
                            jsonNode3 = item1114.get("title");
                            if (jsonNode3 != null) {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                destination$iv$iv2 = destination$iv$iv;
                                destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                destination$iv$iv2 = destination$iv$iv;
                            }
                            destination$iv$iv = destination$iv$iv2;
                            mapper = mapper1115;
                            responseBody = responseBody2;
                            requestBody4 = requestBody14;
                            page6 = page11;
                            break;
                        }
                        listEmptyList = (List) destination$iv$iv;
                        break;
                    }
                    if (listEmptyList == null) {
                        listEmptyList = CollectionsKt.emptyList();
                    }
                    List data116 = listEmptyList;
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data116, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                }
                jsonNode = null;
                obj = coroutine_suspended;
                $result2 = $result;
                Requests app116 = MainActivityKt.getApp();
                c00022.L$0 = request2;
                c00022.L$1 = url2;
                c00022.L$2 = SpillingKt.nullOutSpilledVariable(data2);
                c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts4);
                c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId3);
                c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                c00022.L$6 = SpillingKt.nullOutSpilledVariable(classify);
                c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                c00022.L$8 = SpillingKt.nullOutSpilledVariable(year3);
                c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre5);
                c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort3);
                c00022.L$11 = jsonBody3;
                c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers);
                c00022.L$13 = requestBody;
                c00022.I$0 = page2;
                c00022.I$1 = perPage3;
                c00022.I$2 = pg;
                c00022.label = 4;
                $result3 = Requests.get$default(app116, url2, headers, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                if ($result3 == obj) {
                    return obj;
                }
                data3 = data2;
                mainParts5 = mainParts4;
                requestBody2 = requestBody;
                country3 = classify;
                genre6 = genre5;
                classify2 = year3;
                channelId4 = channelId3;
                request3 = request2;
                page3 = page2;
                jsonBody5 = jsonBody3;
                String str11 = url2;
                perPage4 = perPage3;
                url3 = str11;
                request5 = request3;
                requestBody4 = requestBody2;
                niceResponse = (NiceResponse) $result3;
                headers2 = headers;
                genre8 = genre6;
                pg2 = pg;
                year4 = classify2;
                response = niceResponse;
                if (response.getCode() != 401) {
                    break;
                }
                bearerToken = jsonNode;
                sharedPreferences = movieBoxProvider.sharedPref;
                if (sharedPreferences != null) {
                    editorRemove.apply();
                    Unit unit6 = Unit.INSTANCE;
                }
                if (StringsKt.contains$default(request5.getData(), "|", false, 2, jsonNode)) {
                    c00022.L$0 = request5;
                    c00022.L$1 = url3;
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(data3);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts5);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId4);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(country3);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(year4);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre8);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort3);
                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody5);
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers2);
                    c00022.L$13 = requestBody4;
                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(response);
                    c00022.I$0 = page3;
                    c00022.I$1 = perPage4;
                    c00022.I$2 = pg2;
                    c00022.label = 5;
                    requestBody7 = requestBody4;
                    url5 = url3;
                    year7 = year4;
                    obj2 = obj;
                    objBuildAuthHeaders$default4 = buildAuthHeaders$default(this, "POST", url5, "application/json; charset=utf-8", null, jsonBody5, false, c00022, 40, null);
                    jsonBody8 = jsonBody5;
                    if (objBuildAuthHeaders$default4 == obj2) {
                        return obj2;
                    }
                    int i11 = pg2;
                    $result3 = objBuildAuthHeaders$default4;
                    pg4 = i11;
                    page5 = page3;
                    request6 = request5;
                    requestBody8 = requestBody7;
                    genre10 = genre8;
                    headers4 = headers2;
                    response3 = response;
                    jsonBody9 = jsonBody8;
                    sort5 = sort3;
                    year8 = year7;
                    response4 = response3;
                    jsonBody10 = jsonBody9;
                    perPage5 = perPage4;
                    jsonBody11 = url5;
                    url6 = channelId4;
                    requestBody9 = requestBody8;
                    year9 = year8;
                    headers5 = (Map) $result3;
                    genre11 = country3;
                    year10 = data3;
                    pg5 = pg4;
                    mainParts6 = mainParts5;
                    page7 = page5;
                    data4 = year10;
                    mainParts7 = mainParts6;
                    channelId5 = url6;
                    jsonNode = null;
                    if (StringsKt.contains$default(request6.getData(), "|", false, 2, (Object) null)) {
                        Requests app117 = MainActivityKt.getApp();
                        c00022.L$0 = request6;
                        c00022.L$1 = SpillingKt.nullOutSpilledVariable(jsonBody11);
                        c00022.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                        c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts7);
                        c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId5);
                        c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                        c00022.L$6 = SpillingKt.nullOutSpilledVariable(genre11);
                        c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                        c00022.L$8 = SpillingKt.nullOutSpilledVariable(year9);
                        c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre10);
                        c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort5);
                        c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody10);
                        c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers5);
                        c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody9);
                        c00022.L$14 = SpillingKt.nullOutSpilledVariable(response4);
                        c00022.I$0 = page7;
                        c00022.I$1 = perPage5;
                        c00022.I$2 = pg5;
                        c00022.label = 7;
                        $result3 = Requests.post$default(app117, jsonBody11, headers5, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody9, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                        requestBody12 = requestBody9;
                        if ($result3 == obj2) {
                            return obj2;
                        }
                        data6 = data4;
                        mainParts9 = mainParts7;
                        classify5 = genre11;
                        page9 = page7;
                        pg6 = pg5;
                        headers6 = headers5;
                        requestBody13 = requestBody12;
                        request8 = request6;
                        country5 = country2;
                        niceResponse2 = (NiceResponse) $result3;
                        request5 = request8;
                        page10 = page9;
                        response = niceResponse2;
                        requestBody4 = requestBody13;
                        page6 = page10;
                        responseBody = response.getText();
                        mapper = ExtensionsKt.jacksonObjectMapper();
                        root = mapper.readTree(responseBody);
                        str = str2;
                        jsonNode2 = root.get(str);
                        if (jsonNode2 == null) {
                            jsonNode5 = root.get(str);
                            if (jsonNode5 != null) {
                                jsonNode6 = jsonNode5.get("subjects");
                            } else {
                                jsonNode6 = jsonNode;
                            }
                            if (jsonNode6 == null) {
                                return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                            }
                            items = jsonNode6;
                            Iterable $this$mapNotNull$iv1115 = (Iterable) items;
                            destination$iv$iv = new ArrayList();
                            while (r27.hasNext()) {
                                final JsonNode item1115 = (JsonNode) element$iv$iv$iv;
                                ObjectMapper mapper1116 = mapper;
                                jsonNode3 = item1115.get("title");
                                if (jsonNode3 != null) {
                                    page11 = page6;
                                    responseBody2 = responseBody;
                                    requestBody14 = requestBody4;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    page11 = page6;
                                    responseBody2 = responseBody;
                                    requestBody14 = requestBody4;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                                if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                    destination$iv$iv2 = destination$iv$iv;
                                    destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                                } else {
                                    destination$iv$iv2 = destination$iv$iv;
                                }
                                destination$iv$iv = destination$iv$iv2;
                                mapper = mapper1116;
                                responseBody = responseBody2;
                                requestBody4 = requestBody14;
                                page6 = page11;
                                break;
                            }
                            listEmptyList = (List) destination$iv$iv;
                            break;
                        } else {
                            items = jsonNode2.get("items");
                            if (items == null) {
                                jsonNode5 = root.get(str);
                                if (jsonNode5 != null) {
                                    jsonNode6 = jsonNode5.get("subjects");
                                } else {
                                    jsonNode6 = jsonNode;
                                }
                                if (jsonNode6 == null) {
                                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                                }
                                items = jsonNode6;
                            }
                            Iterable $this$mapNotNull$iv1116 = (Iterable) items;
                            destination$iv$iv = new ArrayList();
                            while (r27.hasNext()) {
                                final JsonNode item1116 = (JsonNode) element$iv$iv$iv;
                                ObjectMapper mapper1117 = mapper;
                                jsonNode3 = item1116.get("title");
                                if (jsonNode3 != null) {
                                    page11 = page6;
                                    responseBody2 = responseBody;
                                    requestBody14 = requestBody4;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    page11 = page6;
                                    responseBody2 = responseBody;
                                    requestBody14 = requestBody4;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                                if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                    destination$iv$iv2 = destination$iv$iv;
                                    destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                                } else {
                                    destination$iv$iv2 = destination$iv$iv;
                                }
                                destination$iv$iv = destination$iv$iv2;
                                mapper = mapper1117;
                                responseBody = responseBody2;
                                requestBody4 = requestBody14;
                                page6 = page11;
                                break;
                            }
                            listEmptyList = (List) destination$iv$iv;
                            break;
                        }
                        if (listEmptyList == null) {
                            listEmptyList = CollectionsKt.emptyList();
                        }
                        List data117 = listEmptyList;
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data117, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                    }
                    requestBody10 = requestBody9;
                    Requests app118 = MainActivityKt.getApp();
                    c00022.L$0 = request6;
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(jsonBody11);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts7);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId5);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(genre11);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(year9);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre10);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort5);
                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody10);
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers5);
                    c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody10);
                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(response4);
                    c00022.I$0 = page7;
                    c00022.I$1 = perPage5;
                    c00022.I$2 = pg5;
                    c00022.label = 8;
                    $result3 = Requests.get$default(app118, jsonBody11, headers5, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                    if ($result3 == obj2) {
                        return obj2;
                    }
                    data5 = data4;
                    mainParts8 = mainParts7;
                    classify4 = genre11;
                    page8 = page7;
                    pg6 = pg5;
                    perPage6 = perPage5;
                    genre12 = genre10;
                    year11 = year9;
                    response5 = response4;
                    requestBody11 = requestBody10;
                    request7 = request6;
                    country4 = country2;
                    niceResponse2 = (NiceResponse) $result3;
                    requestBody13 = requestBody11;
                    request5 = request7;
                    page10 = page8;
                    response = niceResponse2;
                    requestBody4 = requestBody13;
                    page6 = page10;
                    responseBody = response.getText();
                    mapper = ExtensionsKt.jacksonObjectMapper();
                    root = mapper.readTree(responseBody);
                    str = str2;
                    jsonNode2 = root.get(str);
                    if (jsonNode2 == null) {
                        jsonNode5 = root.get(str);
                        if (jsonNode5 != null) {
                            jsonNode6 = jsonNode5.get("subjects");
                        } else {
                            jsonNode6 = jsonNode;
                        }
                        if (jsonNode6 == null) {
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                        }
                        items = jsonNode6;
                        Iterable $this$mapNotNull$iv1117 = (Iterable) items;
                        destination$iv$iv = new ArrayList();
                        while (r27.hasNext()) {
                            final JsonNode item1117 = (JsonNode) element$iv$iv$iv;
                            ObjectMapper mapper1118 = mapper;
                            jsonNode3 = item1117.get("title");
                            if (jsonNode3 != null) {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                destination$iv$iv2 = destination$iv$iv;
                                destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                destination$iv$iv2 = destination$iv$iv;
                            }
                            destination$iv$iv = destination$iv$iv2;
                            mapper = mapper1118;
                            responseBody = responseBody2;
                            requestBody4 = requestBody14;
                            page6 = page11;
                            break;
                        }
                        listEmptyList = (List) destination$iv$iv;
                        break;
                    } else {
                        items = jsonNode2.get("items");
                        if (items == null) {
                            jsonNode5 = root.get(str);
                            if (jsonNode5 != null) {
                                jsonNode6 = jsonNode5.get("subjects");
                            } else {
                                jsonNode6 = jsonNode;
                            }
                            if (jsonNode6 == null) {
                                return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                            }
                            items = jsonNode6;
                        }
                        Iterable $this$mapNotNull$iv1118 = (Iterable) items;
                        destination$iv$iv = new ArrayList();
                        while (r27.hasNext()) {
                            final JsonNode item1118 = (JsonNode) element$iv$iv$iv;
                            ObjectMapper mapper1119 = mapper;
                            jsonNode3 = item1118.get("title");
                            if (jsonNode3 != null) {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                destination$iv$iv2 = destination$iv$iv;
                                destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                destination$iv$iv2 = destination$iv$iv;
                            }
                            destination$iv$iv = destination$iv$iv2;
                            mapper = mapper1119;
                            responseBody = responseBody2;
                            requestBody4 = requestBody14;
                            page6 = page11;
                            break;
                        }
                        listEmptyList = (List) destination$iv$iv;
                        break;
                    }
                    if (listEmptyList == null) {
                        listEmptyList = CollectionsKt.emptyList();
                    }
                    List data118 = listEmptyList;
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data118, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                }
                jsonBody6 = jsonBody5;
                url4 = url3;
                year5 = year4;
                obj2 = obj;
                requestBody5 = requestBody4;
                c00022.L$0 = request5;
                c00022.L$1 = url4;
                c00022.L$2 = SpillingKt.nullOutSpilledVariable(data3);
                c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts5);
                c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId4);
                c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                c00022.L$6 = SpillingKt.nullOutSpilledVariable(country3);
                c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                c00022.L$8 = SpillingKt.nullOutSpilledVariable(year5);
                c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre8);
                c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort3);
                c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody6);
                c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers2);
                c00022.L$13 = requestBody5;
                c00022.L$14 = SpillingKt.nullOutSpilledVariable(response);
                c00022.I$0 = page3;
                c00022.I$1 = perPage4;
                c00022.I$2 = pg2;
                c00022.label = 6;
                objBuildAuthHeaders$default3 = buildAuthHeaders$default(this, "GET", url4, null, null, null, false, c00022, 60, null);
                if (objBuildAuthHeaders$default3 == obj2) {
                    return obj2;
                }
                int i12 = pg2;
                $result3 = objBuildAuthHeaders$default3;
                pg3 = i12;
                page4 = page3;
                request6 = request5;
                requestBody6 = requestBody5;
                genre9 = genre8;
                headers3 = headers2;
                response2 = response;
                jsonBody7 = jsonBody6;
                sort4 = sort3;
                year6 = year5;
                response4 = response2;
                jsonBody10 = jsonBody7;
                sort5 = sort4;
                perPage5 = perPage4;
                jsonBody11 = url4;
                genre10 = genre9;
                url6 = channelId4;
                requestBody9 = requestBody6;
                year9 = year6;
                headers5 = (Map) $result3;
                page7 = page4;
                year10 = data3;
                genre11 = country3;
                pg5 = pg3;
                mainParts6 = mainParts5;
                data4 = year10;
                mainParts7 = mainParts6;
                channelId5 = url6;
                jsonNode = null;
                if (StringsKt.contains$default(request6.getData(), "|", false, 2, (Object) null)) {
                    Requests app119 = MainActivityKt.getApp();
                    c00022.L$0 = request6;
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(jsonBody11);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts7);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId5);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(genre11);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(year9);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre10);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort5);
                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody10);
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers5);
                    c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody9);
                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(response4);
                    c00022.I$0 = page7;
                    c00022.I$1 = perPage5;
                    c00022.I$2 = pg5;
                    c00022.label = 7;
                    $result3 = Requests.post$default(app119, jsonBody11, headers5, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody9, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                    requestBody12 = requestBody9;
                    if ($result3 == obj2) {
                        return obj2;
                    }
                    data6 = data4;
                    mainParts9 = mainParts7;
                    classify5 = genre11;
                    page9 = page7;
                    pg6 = pg5;
                    headers6 = headers5;
                    requestBody13 = requestBody12;
                    request8 = request6;
                    country5 = country2;
                    niceResponse2 = (NiceResponse) $result3;
                    request5 = request8;
                    page10 = page9;
                    response = niceResponse2;
                    requestBody4 = requestBody13;
                    page6 = page10;
                    responseBody = response.getText();
                    mapper = ExtensionsKt.jacksonObjectMapper();
                    root = mapper.readTree(responseBody);
                    str = str2;
                    jsonNode2 = root.get(str);
                    if (jsonNode2 == null) {
                        jsonNode5 = root.get(str);
                        if (jsonNode5 != null) {
                            jsonNode6 = jsonNode5.get("subjects");
                        } else {
                            jsonNode6 = jsonNode;
                        }
                        if (jsonNode6 == null) {
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                        }
                        items = jsonNode6;
                        Iterable $this$mapNotNull$iv1119 = (Iterable) items;
                        destination$iv$iv = new ArrayList();
                        while (r27.hasNext()) {
                            final JsonNode item1119 = (JsonNode) element$iv$iv$iv;
                            ObjectMapper mapper11110 = mapper;
                            jsonNode3 = item1119.get("title");
                            if (jsonNode3 != null) {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                destination$iv$iv2 = destination$iv$iv;
                                destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                destination$iv$iv2 = destination$iv$iv;
                            }
                            destination$iv$iv = destination$iv$iv2;
                            mapper = mapper11110;
                            responseBody = responseBody2;
                            requestBody4 = requestBody14;
                            page6 = page11;
                            break;
                        }
                        listEmptyList = (List) destination$iv$iv;
                        break;
                    } else {
                        items = jsonNode2.get("items");
                        if (items == null) {
                            jsonNode5 = root.get(str);
                            if (jsonNode5 != null) {
                                jsonNode6 = jsonNode5.get("subjects");
                            } else {
                                jsonNode6 = jsonNode;
                            }
                            if (jsonNode6 == null) {
                                return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                            }
                            items = jsonNode6;
                        }
                        Iterable $this$mapNotNull$iv11110 = (Iterable) items;
                        destination$iv$iv = new ArrayList();
                        while (r27.hasNext()) {
                            final JsonNode item11110 = (JsonNode) element$iv$iv$iv;
                            ObjectMapper mapper11111 = mapper;
                            jsonNode3 = item11110.get("title");
                            if (jsonNode3 != null) {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                destination$iv$iv2 = destination$iv$iv;
                                destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                destination$iv$iv2 = destination$iv$iv;
                            }
                            destination$iv$iv = destination$iv$iv2;
                            mapper = mapper11111;
                            responseBody = responseBody2;
                            requestBody4 = requestBody14;
                            page6 = page11;
                            break;
                        }
                        listEmptyList = (List) destination$iv$iv;
                        break;
                    }
                    if (listEmptyList == null) {
                        listEmptyList = CollectionsKt.emptyList();
                    }
                    List data119 = listEmptyList;
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data119, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                }
                requestBody10 = requestBody9;
                Requests app1110 = MainActivityKt.getApp();
                c00022.L$0 = request6;
                c00022.L$1 = SpillingKt.nullOutSpilledVariable(jsonBody11);
                c00022.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts7);
                c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId5);
                c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                c00022.L$6 = SpillingKt.nullOutSpilledVariable(genre11);
                c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                c00022.L$8 = SpillingKt.nullOutSpilledVariable(year9);
                c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre10);
                c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort5);
                c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody10);
                c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers5);
                c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody10);
                c00022.L$14 = SpillingKt.nullOutSpilledVariable(response4);
                c00022.I$0 = page7;
                c00022.I$1 = perPage5;
                c00022.I$2 = pg5;
                c00022.label = 8;
                $result3 = Requests.get$default(app1110, jsonBody11, headers5, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                if ($result3 == obj2) {
                    return obj2;
                }
                data5 = data4;
                mainParts8 = mainParts7;
                classify4 = genre11;
                page8 = page7;
                pg6 = pg5;
                perPage6 = perPage5;
                genre12 = genre10;
                year11 = year9;
                response5 = response4;
                requestBody11 = requestBody10;
                request7 = request6;
                country4 = country2;
                niceResponse2 = (NiceResponse) $result3;
                requestBody13 = requestBody11;
                request5 = request7;
                page10 = page8;
                response = niceResponse2;
                requestBody4 = requestBody13;
                page6 = page10;
                responseBody = response.getText();
                mapper = ExtensionsKt.jacksonObjectMapper();
                root = mapper.readTree(responseBody);
                str = str2;
                jsonNode2 = root.get(str);
                if (jsonNode2 == null) {
                    jsonNode5 = root.get(str);
                    if (jsonNode5 != null) {
                        jsonNode6 = jsonNode5.get("subjects");
                    } else {
                        jsonNode6 = jsonNode;
                    }
                    if (jsonNode6 == null) {
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                    }
                    items = jsonNode6;
                    Iterable $this$mapNotNull$iv11111 = (Iterable) items;
                    destination$iv$iv = new ArrayList();
                    while (r27.hasNext()) {
                        final JsonNode item11111 = (JsonNode) element$iv$iv$iv;
                        ObjectMapper mapper11112 = mapper;
                        jsonNode3 = item11111.get("title");
                        if (jsonNode3 != null) {
                            page11 = page6;
                            responseBody2 = responseBody;
                            requestBody14 = requestBody4;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            page11 = page6;
                            responseBody2 = responseBody;
                            requestBody14 = requestBody4;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        }
                        if (movieSearchResponseNewMovieSearchResponse$default != null) {
                            destination$iv$iv2 = destination$iv$iv;
                            destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                        } else {
                            destination$iv$iv2 = destination$iv$iv;
                        }
                        destination$iv$iv = destination$iv$iv2;
                        mapper = mapper11112;
                        responseBody = responseBody2;
                        requestBody4 = requestBody14;
                        page6 = page11;
                        break;
                    }
                    listEmptyList = (List) destination$iv$iv;
                    break;
                } else {
                    items = jsonNode2.get("items");
                    if (items == null) {
                        jsonNode5 = root.get(str);
                        if (jsonNode5 != null) {
                            jsonNode6 = jsonNode5.get("subjects");
                        } else {
                            jsonNode6 = jsonNode;
                        }
                        if (jsonNode6 == null) {
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                        }
                        items = jsonNode6;
                    }
                    Iterable $this$mapNotNull$iv11112 = (Iterable) items;
                    destination$iv$iv = new ArrayList();
                    while (r27.hasNext()) {
                        final JsonNode item11112 = (JsonNode) element$iv$iv$iv;
                        ObjectMapper mapper11113 = mapper;
                        jsonNode3 = item11112.get("title");
                        if (jsonNode3 != null) {
                            page11 = page6;
                            responseBody2 = responseBody;
                            requestBody14 = requestBody4;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            page11 = page6;
                            responseBody2 = responseBody;
                            requestBody14 = requestBody4;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        }
                        if (movieSearchResponseNewMovieSearchResponse$default != null) {
                            destination$iv$iv2 = destination$iv$iv;
                            destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                        } else {
                            destination$iv$iv2 = destination$iv$iv;
                        }
                        destination$iv$iv = destination$iv$iv2;
                        mapper = mapper11113;
                        responseBody = responseBody2;
                        requestBody4 = requestBody14;
                        page6 = page11;
                        break;
                    }
                    listEmptyList = (List) destination$iv$iv;
                    break;
                }
                if (listEmptyList == null) {
                    listEmptyList = CollectionsKt.emptyList();
                }
                List data1110 = listEmptyList;
                return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data1110, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
            case 2:
                int pg9 = c00022.I$2;
                int perPage8 = c00022.I$1;
                int page14 = c00022.I$0;
                jsonBody = (String) c00022.L$11;
                sort = (String) c00022.L$10;
                genre = (String) c00022.L$9;
                year = (String) c00022.L$8;
                country = (String) c00022.L$7;
                classify = (String) c00022.L$6;
                Map options6 = (Map) c00022.L$5;
                String channelId8 = (String) c00022.L$4;
                mainParts = (List) c00022.L$3;
                genre2 = (String) c00022.L$2;
                String url8 = (String) c00022.L$1;
                MainPageRequest request11 = (MainPageRequest) c00022.L$0;
                ResultKt.throwOnFailure($result3);
                request9 = request11;
                pg = pg9;
                objBuildAuthHeaders$default = $result3;
                page12 = page14;
                channelId = channelId8;
                options = options6;
                perPage = perPage8;
                $result = objBuildAuthHeaders$default;
                url = url8;
                headers = (Map) objBuildAuthHeaders$default;
                sort3 = sort;
                genre5 = genre;
                year3 = year;
                perPage3 = perPage;
                options2 = options;
                data1 = genre2;
                page2 = page12;
                url2 = url;
                request2 = request9;
                mainParts3 = mainParts;
                jsonBody3 = jsonBody;
                jsonBody4 = channelId;
                data2 = data1;
                mainParts4 = mainParts3;
                requestBody = RequestBody.Companion.create(jsonBody3, MediaType.Companion.get("application/json"));
                channelId3 = jsonBody4;
                options3 = options2;
                country2 = country;
                if (StringsKt.contains$default(request2.getData(), "|", false, 2, (Object) null)) {
                    Requests app1111 = MainActivityKt.getApp();
                    c00022.L$0 = request2;
                    c00022.L$1 = url2;
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(data2);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts4);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId3);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(classify);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(year3);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre5);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort3);
                    c00022.L$11 = jsonBody3;
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers);
                    c00022.L$13 = requestBody;
                    c00022.I$0 = page2;
                    c00022.I$1 = perPage3;
                    c00022.I$2 = pg;
                    c00022.label = 3;
                    obj = coroutine_suspended;
                    $result2 = $result;
                    jsonNode = null;
                    $result3 = Requests.post$default(app1111, url2, headers, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                    if ($result3 == obj) {
                        return obj;
                    }
                    data3 = data2;
                    mainParts5 = mainParts4;
                    requestBody3 = requestBody;
                    country3 = classify;
                    genre7 = genre5;
                    classify3 = year3;
                    channelId4 = channelId3;
                    request4 = request2;
                    page3 = page2;
                    jsonBody5 = jsonBody3;
                    String str12 = url2;
                    perPage4 = perPage3;
                    url3 = str12;
                    request5 = request4;
                    requestBody4 = requestBody3;
                    niceResponse = (NiceResponse) $result3;
                    headers2 = headers;
                    genre8 = genre7;
                    pg2 = pg;
                    year4 = classify3;
                    response = niceResponse;
                    if (response.getCode() != 401) {
                        break;
                    }
                    bearerToken = jsonNode;
                    sharedPreferences = movieBoxProvider.sharedPref;
                    if (sharedPreferences != null) {
                        editorRemove.apply();
                        Unit unit7 = Unit.INSTANCE;
                    }
                    if (StringsKt.contains$default(request5.getData(), "|", false, 2, jsonNode)) {
                        c00022.L$0 = request5;
                        c00022.L$1 = url3;
                        c00022.L$2 = SpillingKt.nullOutSpilledVariable(data3);
                        c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts5);
                        c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId4);
                        c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                        c00022.L$6 = SpillingKt.nullOutSpilledVariable(country3);
                        c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                        c00022.L$8 = SpillingKt.nullOutSpilledVariable(year4);
                        c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre8);
                        c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort3);
                        c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody5);
                        c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers2);
                        c00022.L$13 = requestBody4;
                        c00022.L$14 = SpillingKt.nullOutSpilledVariable(response);
                        c00022.I$0 = page3;
                        c00022.I$1 = perPage4;
                        c00022.I$2 = pg2;
                        c00022.label = 5;
                        requestBody7 = requestBody4;
                        url5 = url3;
                        year7 = year4;
                        obj2 = obj;
                        objBuildAuthHeaders$default4 = buildAuthHeaders$default(this, "POST", url5, "application/json; charset=utf-8", null, jsonBody5, false, c00022, 40, null);
                        jsonBody8 = jsonBody5;
                        if (objBuildAuthHeaders$default4 == obj2) {
                            return obj2;
                        }
                        int i13 = pg2;
                        $result3 = objBuildAuthHeaders$default4;
                        pg4 = i13;
                        page5 = page3;
                        request6 = request5;
                        requestBody8 = requestBody7;
                        genre10 = genre8;
                        headers4 = headers2;
                        response3 = response;
                        jsonBody9 = jsonBody8;
                        sort5 = sort3;
                        year8 = year7;
                        response4 = response3;
                        jsonBody10 = jsonBody9;
                        perPage5 = perPage4;
                        jsonBody11 = url5;
                        url6 = channelId4;
                        requestBody9 = requestBody8;
                        year9 = year8;
                        headers5 = (Map) $result3;
                        genre11 = country3;
                        year10 = data3;
                        pg5 = pg4;
                        mainParts6 = mainParts5;
                        page7 = page5;
                        data4 = year10;
                        mainParts7 = mainParts6;
                        channelId5 = url6;
                        jsonNode = null;
                        if (StringsKt.contains$default(request6.getData(), "|", false, 2, (Object) null)) {
                            Requests app1112 = MainActivityKt.getApp();
                            c00022.L$0 = request6;
                            c00022.L$1 = SpillingKt.nullOutSpilledVariable(jsonBody11);
                            c00022.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                            c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts7);
                            c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId5);
                            c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                            c00022.L$6 = SpillingKt.nullOutSpilledVariable(genre11);
                            c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                            c00022.L$8 = SpillingKt.nullOutSpilledVariable(year9);
                            c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre10);
                            c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort5);
                            c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody10);
                            c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers5);
                            c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody9);
                            c00022.L$14 = SpillingKt.nullOutSpilledVariable(response4);
                            c00022.I$0 = page7;
                            c00022.I$1 = perPage5;
                            c00022.I$2 = pg5;
                            c00022.label = 7;
                            $result3 = Requests.post$default(app1112, jsonBody11, headers5, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody9, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                            requestBody12 = requestBody9;
                            if ($result3 == obj2) {
                                return obj2;
                            }
                            data6 = data4;
                            mainParts9 = mainParts7;
                            classify5 = genre11;
                            page9 = page7;
                            pg6 = pg5;
                            headers6 = headers5;
                            requestBody13 = requestBody12;
                            request8 = request6;
                            country5 = country2;
                            niceResponse2 = (NiceResponse) $result3;
                            request5 = request8;
                            page10 = page9;
                            response = niceResponse2;
                            requestBody4 = requestBody13;
                            page6 = page10;
                            responseBody = response.getText();
                            mapper = ExtensionsKt.jacksonObjectMapper();
                            root = mapper.readTree(responseBody);
                            str = str2;
                            jsonNode2 = root.get(str);
                            if (jsonNode2 == null) {
                                jsonNode5 = root.get(str);
                                if (jsonNode5 != null) {
                                    jsonNode6 = jsonNode5.get("subjects");
                                } else {
                                    jsonNode6 = jsonNode;
                                }
                                if (jsonNode6 == null) {
                                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                                }
                                items = jsonNode6;
                                Iterable $this$mapNotNull$iv11113 = (Iterable) items;
                                destination$iv$iv = new ArrayList();
                                while (r27.hasNext()) {
                                    final JsonNode item11113 = (JsonNode) element$iv$iv$iv;
                                    ObjectMapper mapper11114 = mapper;
                                    jsonNode3 = item11113.get("title");
                                    if (jsonNode3 != null) {
                                        page11 = page6;
                                        responseBody2 = responseBody;
                                        requestBody14 = requestBody4;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    } else {
                                        page11 = page6;
                                        responseBody2 = responseBody;
                                        requestBody14 = requestBody4;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    }
                                    if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                        destination$iv$iv2 = destination$iv$iv;
                                        destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                                    } else {
                                        destination$iv$iv2 = destination$iv$iv;
                                    }
                                    destination$iv$iv = destination$iv$iv2;
                                    mapper = mapper11114;
                                    responseBody = responseBody2;
                                    requestBody4 = requestBody14;
                                    page6 = page11;
                                    break;
                                }
                                listEmptyList = (List) destination$iv$iv;
                                break;
                            } else {
                                items = jsonNode2.get("items");
                                if (items == null) {
                                    jsonNode5 = root.get(str);
                                    if (jsonNode5 != null) {
                                        jsonNode6 = jsonNode5.get("subjects");
                                    } else {
                                        jsonNode6 = jsonNode;
                                    }
                                    if (jsonNode6 == null) {
                                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                                    }
                                    items = jsonNode6;
                                }
                                Iterable $this$mapNotNull$iv11114 = (Iterable) items;
                                destination$iv$iv = new ArrayList();
                                while (r27.hasNext()) {
                                    final JsonNode item11114 = (JsonNode) element$iv$iv$iv;
                                    ObjectMapper mapper11115 = mapper;
                                    jsonNode3 = item11114.get("title");
                                    if (jsonNode3 != null) {
                                        page11 = page6;
                                        responseBody2 = responseBody;
                                        requestBody14 = requestBody4;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    } else {
                                        page11 = page6;
                                        responseBody2 = responseBody;
                                        requestBody14 = requestBody4;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    }
                                    if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                        destination$iv$iv2 = destination$iv$iv;
                                        destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                                    } else {
                                        destination$iv$iv2 = destination$iv$iv;
                                    }
                                    destination$iv$iv = destination$iv$iv2;
                                    mapper = mapper11115;
                                    responseBody = responseBody2;
                                    requestBody4 = requestBody14;
                                    page6 = page11;
                                    break;
                                }
                                listEmptyList = (List) destination$iv$iv;
                                break;
                            }
                            if (listEmptyList == null) {
                                listEmptyList = CollectionsKt.emptyList();
                            }
                            List data1111 = listEmptyList;
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data1111, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                        }
                        requestBody10 = requestBody9;
                        Requests app1113 = MainActivityKt.getApp();
                        c00022.L$0 = request6;
                        c00022.L$1 = SpillingKt.nullOutSpilledVariable(jsonBody11);
                        c00022.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                        c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts7);
                        c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId5);
                        c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                        c00022.L$6 = SpillingKt.nullOutSpilledVariable(genre11);
                        c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                        c00022.L$8 = SpillingKt.nullOutSpilledVariable(year9);
                        c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre10);
                        c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort5);
                        c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody10);
                        c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers5);
                        c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody10);
                        c00022.L$14 = SpillingKt.nullOutSpilledVariable(response4);
                        c00022.I$0 = page7;
                        c00022.I$1 = perPage5;
                        c00022.I$2 = pg5;
                        c00022.label = 8;
                        $result3 = Requests.get$default(app1113, jsonBody11, headers5, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                        if ($result3 == obj2) {
                            return obj2;
                        }
                        data5 = data4;
                        mainParts8 = mainParts7;
                        classify4 = genre11;
                        page8 = page7;
                        pg6 = pg5;
                        perPage6 = perPage5;
                        genre12 = genre10;
                        year11 = year9;
                        response5 = response4;
                        requestBody11 = requestBody10;
                        request7 = request6;
                        country4 = country2;
                        niceResponse2 = (NiceResponse) $result3;
                        requestBody13 = requestBody11;
                        request5 = request7;
                        page10 = page8;
                        response = niceResponse2;
                        requestBody4 = requestBody13;
                        page6 = page10;
                        responseBody = response.getText();
                        mapper = ExtensionsKt.jacksonObjectMapper();
                        root = mapper.readTree(responseBody);
                        str = str2;
                        jsonNode2 = root.get(str);
                        if (jsonNode2 == null) {
                            jsonNode5 = root.get(str);
                            if (jsonNode5 != null) {
                                jsonNode6 = jsonNode5.get("subjects");
                            } else {
                                jsonNode6 = jsonNode;
                            }
                            if (jsonNode6 == null) {
                                return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                            }
                            items = jsonNode6;
                            Iterable $this$mapNotNull$iv11115 = (Iterable) items;
                            destination$iv$iv = new ArrayList();
                            while (r27.hasNext()) {
                                final JsonNode item11115 = (JsonNode) element$iv$iv$iv;
                                ObjectMapper mapper11116 = mapper;
                                jsonNode3 = item11115.get("title");
                                if (jsonNode3 != null) {
                                    page11 = page6;
                                    responseBody2 = responseBody;
                                    requestBody14 = requestBody4;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    page11 = page6;
                                    responseBody2 = responseBody;
                                    requestBody14 = requestBody4;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                                if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                    destination$iv$iv2 = destination$iv$iv;
                                    destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                                } else {
                                    destination$iv$iv2 = destination$iv$iv;
                                }
                                destination$iv$iv = destination$iv$iv2;
                                mapper = mapper11116;
                                responseBody = responseBody2;
                                requestBody4 = requestBody14;
                                page6 = page11;
                                break;
                            }
                            listEmptyList = (List) destination$iv$iv;
                            break;
                        } else {
                            items = jsonNode2.get("items");
                            if (items == null) {
                                jsonNode5 = root.get(str);
                                if (jsonNode5 != null) {
                                    jsonNode6 = jsonNode5.get("subjects");
                                } else {
                                    jsonNode6 = jsonNode;
                                }
                                if (jsonNode6 == null) {
                                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                                }
                                items = jsonNode6;
                            }
                            Iterable $this$mapNotNull$iv11116 = (Iterable) items;
                            destination$iv$iv = new ArrayList();
                            while (r27.hasNext()) {
                                final JsonNode item11116 = (JsonNode) element$iv$iv$iv;
                                ObjectMapper mapper11117 = mapper;
                                jsonNode3 = item11116.get("title");
                                if (jsonNode3 != null) {
                                    page11 = page6;
                                    responseBody2 = responseBody;
                                    requestBody14 = requestBody4;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    page11 = page6;
                                    responseBody2 = responseBody;
                                    requestBody14 = requestBody4;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                                if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                    destination$iv$iv2 = destination$iv$iv;
                                    destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                                } else {
                                    destination$iv$iv2 = destination$iv$iv;
                                }
                                destination$iv$iv = destination$iv$iv2;
                                mapper = mapper11117;
                                responseBody = responseBody2;
                                requestBody4 = requestBody14;
                                page6 = page11;
                                break;
                            }
                            listEmptyList = (List) destination$iv$iv;
                            break;
                        }
                        if (listEmptyList == null) {
                            listEmptyList = CollectionsKt.emptyList();
                        }
                        List data1112 = listEmptyList;
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data1112, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                    }
                    jsonBody6 = jsonBody5;
                    url4 = url3;
                    year5 = year4;
                    obj2 = obj;
                    requestBody5 = requestBody4;
                    c00022.L$0 = request5;
                    c00022.L$1 = url4;
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(data3);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts5);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId4);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(country3);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(year5);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre8);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort3);
                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody6);
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers2);
                    c00022.L$13 = requestBody5;
                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(response);
                    c00022.I$0 = page3;
                    c00022.I$1 = perPage4;
                    c00022.I$2 = pg2;
                    c00022.label = 6;
                    objBuildAuthHeaders$default3 = buildAuthHeaders$default(this, "GET", url4, null, null, null, false, c00022, 60, null);
                    if (objBuildAuthHeaders$default3 == obj2) {
                        return obj2;
                    }
                    int i14 = pg2;
                    $result3 = objBuildAuthHeaders$default3;
                    pg3 = i14;
                    page4 = page3;
                    request6 = request5;
                    requestBody6 = requestBody5;
                    genre9 = genre8;
                    headers3 = headers2;
                    response2 = response;
                    jsonBody7 = jsonBody6;
                    sort4 = sort3;
                    year6 = year5;
                    response4 = response2;
                    jsonBody10 = jsonBody7;
                    sort5 = sort4;
                    perPage5 = perPage4;
                    jsonBody11 = url4;
                    genre10 = genre9;
                    url6 = channelId4;
                    requestBody9 = requestBody6;
                    year9 = year6;
                    headers5 = (Map) $result3;
                    page7 = page4;
                    year10 = data3;
                    genre11 = country3;
                    pg5 = pg3;
                    mainParts6 = mainParts5;
                    data4 = year10;
                    mainParts7 = mainParts6;
                    channelId5 = url6;
                    jsonNode = null;
                    if (StringsKt.contains$default(request6.getData(), "|", false, 2, (Object) null)) {
                        Requests app1114 = MainActivityKt.getApp();
                        c00022.L$0 = request6;
                        c00022.L$1 = SpillingKt.nullOutSpilledVariable(jsonBody11);
                        c00022.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                        c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts7);
                        c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId5);
                        c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                        c00022.L$6 = SpillingKt.nullOutSpilledVariable(genre11);
                        c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                        c00022.L$8 = SpillingKt.nullOutSpilledVariable(year9);
                        c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre10);
                        c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort5);
                        c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody10);
                        c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers5);
                        c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody9);
                        c00022.L$14 = SpillingKt.nullOutSpilledVariable(response4);
                        c00022.I$0 = page7;
                        c00022.I$1 = perPage5;
                        c00022.I$2 = pg5;
                        c00022.label = 7;
                        $result3 = Requests.post$default(app1114, jsonBody11, headers5, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody9, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                        requestBody12 = requestBody9;
                        if ($result3 == obj2) {
                            return obj2;
                        }
                        data6 = data4;
                        mainParts9 = mainParts7;
                        classify5 = genre11;
                        page9 = page7;
                        pg6 = pg5;
                        headers6 = headers5;
                        requestBody13 = requestBody12;
                        request8 = request6;
                        country5 = country2;
                        niceResponse2 = (NiceResponse) $result3;
                        request5 = request8;
                        page10 = page9;
                        response = niceResponse2;
                        requestBody4 = requestBody13;
                        page6 = page10;
                        responseBody = response.getText();
                        mapper = ExtensionsKt.jacksonObjectMapper();
                        root = mapper.readTree(responseBody);
                        str = str2;
                        jsonNode2 = root.get(str);
                        if (jsonNode2 == null) {
                            jsonNode5 = root.get(str);
                            if (jsonNode5 != null) {
                                jsonNode6 = jsonNode5.get("subjects");
                            } else {
                                jsonNode6 = jsonNode;
                            }
                            if (jsonNode6 == null) {
                                return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                            }
                            items = jsonNode6;
                            Iterable $this$mapNotNull$iv11117 = (Iterable) items;
                            destination$iv$iv = new ArrayList();
                            while (r27.hasNext()) {
                                final JsonNode item11117 = (JsonNode) element$iv$iv$iv;
                                ObjectMapper mapper11118 = mapper;
                                jsonNode3 = item11117.get("title");
                                if (jsonNode3 != null) {
                                    page11 = page6;
                                    responseBody2 = responseBody;
                                    requestBody14 = requestBody4;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    page11 = page6;
                                    responseBody2 = responseBody;
                                    requestBody14 = requestBody4;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                                if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                    destination$iv$iv2 = destination$iv$iv;
                                    destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                                } else {
                                    destination$iv$iv2 = destination$iv$iv;
                                }
                                destination$iv$iv = destination$iv$iv2;
                                mapper = mapper11118;
                                responseBody = responseBody2;
                                requestBody4 = requestBody14;
                                page6 = page11;
                                break;
                            }
                            listEmptyList = (List) destination$iv$iv;
                            break;
                        } else {
                            items = jsonNode2.get("items");
                            if (items == null) {
                                jsonNode5 = root.get(str);
                                if (jsonNode5 != null) {
                                    jsonNode6 = jsonNode5.get("subjects");
                                } else {
                                    jsonNode6 = jsonNode;
                                }
                                if (jsonNode6 == null) {
                                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                                }
                                items = jsonNode6;
                            }
                            Iterable $this$mapNotNull$iv11118 = (Iterable) items;
                            destination$iv$iv = new ArrayList();
                            while (r27.hasNext()) {
                                final JsonNode item11118 = (JsonNode) element$iv$iv$iv;
                                ObjectMapper mapper11119 = mapper;
                                jsonNode3 = item11118.get("title");
                                if (jsonNode3 != null) {
                                    page11 = page6;
                                    responseBody2 = responseBody;
                                    requestBody14 = requestBody4;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    page11 = page6;
                                    responseBody2 = responseBody;
                                    requestBody14 = requestBody4;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                                if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                    destination$iv$iv2 = destination$iv$iv;
                                    destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                                } else {
                                    destination$iv$iv2 = destination$iv$iv;
                                }
                                destination$iv$iv = destination$iv$iv2;
                                mapper = mapper11119;
                                responseBody = responseBody2;
                                requestBody4 = requestBody14;
                                page6 = page11;
                                break;
                            }
                            listEmptyList = (List) destination$iv$iv;
                            break;
                        }
                        if (listEmptyList == null) {
                            listEmptyList = CollectionsKt.emptyList();
                        }
                        List data1113 = listEmptyList;
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data1113, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                    }
                    requestBody10 = requestBody9;
                    Requests app1115 = MainActivityKt.getApp();
                    c00022.L$0 = request6;
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(jsonBody11);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts7);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId5);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(genre11);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(year9);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre10);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort5);
                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody10);
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers5);
                    c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody10);
                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(response4);
                    c00022.I$0 = page7;
                    c00022.I$1 = perPage5;
                    c00022.I$2 = pg5;
                    c00022.label = 8;
                    $result3 = Requests.get$default(app1115, jsonBody11, headers5, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                    if ($result3 == obj2) {
                        return obj2;
                    }
                    data5 = data4;
                    mainParts8 = mainParts7;
                    classify4 = genre11;
                    page8 = page7;
                    pg6 = pg5;
                    perPage6 = perPage5;
                    genre12 = genre10;
                    year11 = year9;
                    response5 = response4;
                    requestBody11 = requestBody10;
                    request7 = request6;
                    country4 = country2;
                    niceResponse2 = (NiceResponse) $result3;
                    requestBody13 = requestBody11;
                    request5 = request7;
                    page10 = page8;
                    response = niceResponse2;
                    requestBody4 = requestBody13;
                    page6 = page10;
                    responseBody = response.getText();
                    mapper = ExtensionsKt.jacksonObjectMapper();
                    root = mapper.readTree(responseBody);
                    str = str2;
                    jsonNode2 = root.get(str);
                    if (jsonNode2 == null) {
                        jsonNode5 = root.get(str);
                        if (jsonNode5 != null) {
                            jsonNode6 = jsonNode5.get("subjects");
                        } else {
                            jsonNode6 = jsonNode;
                        }
                        if (jsonNode6 == null) {
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                        }
                        items = jsonNode6;
                        Iterable $this$mapNotNull$iv11119 = (Iterable) items;
                        destination$iv$iv = new ArrayList();
                        while (r27.hasNext()) {
                            final JsonNode item11119 = (JsonNode) element$iv$iv$iv;
                            ObjectMapper mapper111110 = mapper;
                            jsonNode3 = item11119.get("title");
                            if (jsonNode3 != null) {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                destination$iv$iv2 = destination$iv$iv;
                                destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                destination$iv$iv2 = destination$iv$iv;
                            }
                            destination$iv$iv = destination$iv$iv2;
                            mapper = mapper111110;
                            responseBody = responseBody2;
                            requestBody4 = requestBody14;
                            page6 = page11;
                            break;
                        }
                        listEmptyList = (List) destination$iv$iv;
                        break;
                    } else {
                        items = jsonNode2.get("items");
                        if (items == null) {
                            jsonNode5 = root.get(str);
                            if (jsonNode5 != null) {
                                jsonNode6 = jsonNode5.get("subjects");
                            } else {
                                jsonNode6 = jsonNode;
                            }
                            if (jsonNode6 == null) {
                                return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                            }
                            items = jsonNode6;
                        }
                        Iterable $this$mapNotNull$iv111110 = (Iterable) items;
                        destination$iv$iv = new ArrayList();
                        while (r27.hasNext()) {
                            final JsonNode item111110 = (JsonNode) element$iv$iv$iv;
                            ObjectMapper mapper111111 = mapper;
                            jsonNode3 = item111110.get("title");
                            if (jsonNode3 != null) {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                destination$iv$iv2 = destination$iv$iv;
                                destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                destination$iv$iv2 = destination$iv$iv;
                            }
                            destination$iv$iv = destination$iv$iv2;
                            mapper = mapper111111;
                            responseBody = responseBody2;
                            requestBody4 = requestBody14;
                            page6 = page11;
                            break;
                        }
                        listEmptyList = (List) destination$iv$iv;
                        break;
                    }
                    if (listEmptyList == null) {
                        listEmptyList = CollectionsKt.emptyList();
                    }
                    List data1114 = listEmptyList;
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data1114, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                }
                jsonNode = null;
                obj = coroutine_suspended;
                $result2 = $result;
                Requests app1116 = MainActivityKt.getApp();
                c00022.L$0 = request2;
                c00022.L$1 = url2;
                c00022.L$2 = SpillingKt.nullOutSpilledVariable(data2);
                c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts4);
                c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId3);
                c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                c00022.L$6 = SpillingKt.nullOutSpilledVariable(classify);
                c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                c00022.L$8 = SpillingKt.nullOutSpilledVariable(year3);
                c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre5);
                c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort3);
                c00022.L$11 = jsonBody3;
                c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers);
                c00022.L$13 = requestBody;
                c00022.I$0 = page2;
                c00022.I$1 = perPage3;
                c00022.I$2 = pg;
                c00022.label = 4;
                $result3 = Requests.get$default(app1116, url2, headers, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                if ($result3 == obj) {
                    return obj;
                }
                data3 = data2;
                mainParts5 = mainParts4;
                requestBody2 = requestBody;
                country3 = classify;
                genre6 = genre5;
                classify2 = year3;
                channelId4 = channelId3;
                request3 = request2;
                page3 = page2;
                jsonBody5 = jsonBody3;
                String str13 = url2;
                perPage4 = perPage3;
                url3 = str13;
                request5 = request3;
                requestBody4 = requestBody2;
                niceResponse = (NiceResponse) $result3;
                headers2 = headers;
                genre8 = genre6;
                pg2 = pg;
                year4 = classify2;
                response = niceResponse;
                if (response.getCode() != 401) {
                    break;
                }
                bearerToken = jsonNode;
                sharedPreferences = movieBoxProvider.sharedPref;
                if (sharedPreferences != null) {
                    editorRemove.apply();
                    Unit unit8 = Unit.INSTANCE;
                }
                if (StringsKt.contains$default(request5.getData(), "|", false, 2, jsonNode)) {
                    c00022.L$0 = request5;
                    c00022.L$1 = url3;
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(data3);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts5);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId4);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(country3);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(year4);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre8);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort3);
                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody5);
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers2);
                    c00022.L$13 = requestBody4;
                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(response);
                    c00022.I$0 = page3;
                    c00022.I$1 = perPage4;
                    c00022.I$2 = pg2;
                    c00022.label = 5;
                    requestBody7 = requestBody4;
                    url5 = url3;
                    year7 = year4;
                    obj2 = obj;
                    objBuildAuthHeaders$default4 = buildAuthHeaders$default(this, "POST", url5, "application/json; charset=utf-8", null, jsonBody5, false, c00022, 40, null);
                    jsonBody8 = jsonBody5;
                    if (objBuildAuthHeaders$default4 == obj2) {
                        return obj2;
                    }
                    int i15 = pg2;
                    $result3 = objBuildAuthHeaders$default4;
                    pg4 = i15;
                    page5 = page3;
                    request6 = request5;
                    requestBody8 = requestBody7;
                    genre10 = genre8;
                    headers4 = headers2;
                    response3 = response;
                    jsonBody9 = jsonBody8;
                    sort5 = sort3;
                    year8 = year7;
                    response4 = response3;
                    jsonBody10 = jsonBody9;
                    perPage5 = perPage4;
                    jsonBody11 = url5;
                    url6 = channelId4;
                    requestBody9 = requestBody8;
                    year9 = year8;
                    headers5 = (Map) $result3;
                    genre11 = country3;
                    year10 = data3;
                    pg5 = pg4;
                    mainParts6 = mainParts5;
                    page7 = page5;
                    data4 = year10;
                    mainParts7 = mainParts6;
                    channelId5 = url6;
                    jsonNode = null;
                    if (StringsKt.contains$default(request6.getData(), "|", false, 2, (Object) null)) {
                        Requests app1117 = MainActivityKt.getApp();
                        c00022.L$0 = request6;
                        c00022.L$1 = SpillingKt.nullOutSpilledVariable(jsonBody11);
                        c00022.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                        c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts7);
                        c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId5);
                        c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                        c00022.L$6 = SpillingKt.nullOutSpilledVariable(genre11);
                        c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                        c00022.L$8 = SpillingKt.nullOutSpilledVariable(year9);
                        c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre10);
                        c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort5);
                        c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody10);
                        c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers5);
                        c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody9);
                        c00022.L$14 = SpillingKt.nullOutSpilledVariable(response4);
                        c00022.I$0 = page7;
                        c00022.I$1 = perPage5;
                        c00022.I$2 = pg5;
                        c00022.label = 7;
                        $result3 = Requests.post$default(app1117, jsonBody11, headers5, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody9, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                        requestBody12 = requestBody9;
                        if ($result3 == obj2) {
                            return obj2;
                        }
                        data6 = data4;
                        mainParts9 = mainParts7;
                        classify5 = genre11;
                        page9 = page7;
                        pg6 = pg5;
                        headers6 = headers5;
                        requestBody13 = requestBody12;
                        request8 = request6;
                        country5 = country2;
                        niceResponse2 = (NiceResponse) $result3;
                        request5 = request8;
                        page10 = page9;
                        response = niceResponse2;
                        requestBody4 = requestBody13;
                        page6 = page10;
                        responseBody = response.getText();
                        mapper = ExtensionsKt.jacksonObjectMapper();
                        root = mapper.readTree(responseBody);
                        str = str2;
                        jsonNode2 = root.get(str);
                        if (jsonNode2 == null) {
                            jsonNode5 = root.get(str);
                            if (jsonNode5 != null) {
                                jsonNode6 = jsonNode5.get("subjects");
                            } else {
                                jsonNode6 = jsonNode;
                            }
                            if (jsonNode6 == null) {
                                return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                            }
                            items = jsonNode6;
                            Iterable $this$mapNotNull$iv111111 = (Iterable) items;
                            destination$iv$iv = new ArrayList();
                            while (r27.hasNext()) {
                                final JsonNode item111111 = (JsonNode) element$iv$iv$iv;
                                ObjectMapper mapper111112 = mapper;
                                jsonNode3 = item111111.get("title");
                                if (jsonNode3 != null) {
                                    page11 = page6;
                                    responseBody2 = responseBody;
                                    requestBody14 = requestBody4;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    page11 = page6;
                                    responseBody2 = responseBody;
                                    requestBody14 = requestBody4;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                                if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                    destination$iv$iv2 = destination$iv$iv;
                                    destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                                } else {
                                    destination$iv$iv2 = destination$iv$iv;
                                }
                                destination$iv$iv = destination$iv$iv2;
                                mapper = mapper111112;
                                responseBody = responseBody2;
                                requestBody4 = requestBody14;
                                page6 = page11;
                                break;
                            }
                            listEmptyList = (List) destination$iv$iv;
                            break;
                        } else {
                            items = jsonNode2.get("items");
                            if (items == null) {
                                jsonNode5 = root.get(str);
                                if (jsonNode5 != null) {
                                    jsonNode6 = jsonNode5.get("subjects");
                                } else {
                                    jsonNode6 = jsonNode;
                                }
                                if (jsonNode6 == null) {
                                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                                }
                                items = jsonNode6;
                            }
                            Iterable $this$mapNotNull$iv111112 = (Iterable) items;
                            destination$iv$iv = new ArrayList();
                            while (r27.hasNext()) {
                                final JsonNode item111112 = (JsonNode) element$iv$iv$iv;
                                ObjectMapper mapper111113 = mapper;
                                jsonNode3 = item111112.get("title");
                                if (jsonNode3 != null) {
                                    page11 = page6;
                                    responseBody2 = responseBody;
                                    requestBody14 = requestBody4;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    page11 = page6;
                                    responseBody2 = responseBody;
                                    requestBody14 = requestBody4;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                                if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                    destination$iv$iv2 = destination$iv$iv;
                                    destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                                } else {
                                    destination$iv$iv2 = destination$iv$iv;
                                }
                                destination$iv$iv = destination$iv$iv2;
                                mapper = mapper111113;
                                responseBody = responseBody2;
                                requestBody4 = requestBody14;
                                page6 = page11;
                                break;
                            }
                            listEmptyList = (List) destination$iv$iv;
                            break;
                        }
                        if (listEmptyList == null) {
                            listEmptyList = CollectionsKt.emptyList();
                        }
                        List data1115 = listEmptyList;
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data1115, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                    }
                    requestBody10 = requestBody9;
                    Requests app1118 = MainActivityKt.getApp();
                    c00022.L$0 = request6;
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(jsonBody11);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts7);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId5);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(genre11);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(year9);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre10);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort5);
                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody10);
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers5);
                    c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody10);
                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(response4);
                    c00022.I$0 = page7;
                    c00022.I$1 = perPage5;
                    c00022.I$2 = pg5;
                    c00022.label = 8;
                    $result3 = Requests.get$default(app1118, jsonBody11, headers5, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                    if ($result3 == obj2) {
                        return obj2;
                    }
                    data5 = data4;
                    mainParts8 = mainParts7;
                    classify4 = genre11;
                    page8 = page7;
                    pg6 = pg5;
                    perPage6 = perPage5;
                    genre12 = genre10;
                    year11 = year9;
                    response5 = response4;
                    requestBody11 = requestBody10;
                    request7 = request6;
                    country4 = country2;
                    niceResponse2 = (NiceResponse) $result3;
                    requestBody13 = requestBody11;
                    request5 = request7;
                    page10 = page8;
                    response = niceResponse2;
                    requestBody4 = requestBody13;
                    page6 = page10;
                    responseBody = response.getText();
                    mapper = ExtensionsKt.jacksonObjectMapper();
                    root = mapper.readTree(responseBody);
                    str = str2;
                    jsonNode2 = root.get(str);
                    if (jsonNode2 == null) {
                        jsonNode5 = root.get(str);
                        if (jsonNode5 != null) {
                            jsonNode6 = jsonNode5.get("subjects");
                        } else {
                            jsonNode6 = jsonNode;
                        }
                        if (jsonNode6 == null) {
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                        }
                        items = jsonNode6;
                        Iterable $this$mapNotNull$iv111113 = (Iterable) items;
                        destination$iv$iv = new ArrayList();
                        while (r27.hasNext()) {
                            final JsonNode item111113 = (JsonNode) element$iv$iv$iv;
                            ObjectMapper mapper111114 = mapper;
                            jsonNode3 = item111113.get("title");
                            if (jsonNode3 != null) {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                destination$iv$iv2 = destination$iv$iv;
                                destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                destination$iv$iv2 = destination$iv$iv;
                            }
                            destination$iv$iv = destination$iv$iv2;
                            mapper = mapper111114;
                            responseBody = responseBody2;
                            requestBody4 = requestBody14;
                            page6 = page11;
                            break;
                        }
                        listEmptyList = (List) destination$iv$iv;
                        break;
                    } else {
                        items = jsonNode2.get("items");
                        if (items == null) {
                            jsonNode5 = root.get(str);
                            if (jsonNode5 != null) {
                                jsonNode6 = jsonNode5.get("subjects");
                            } else {
                                jsonNode6 = jsonNode;
                            }
                            if (jsonNode6 == null) {
                                return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                            }
                            items = jsonNode6;
                        }
                        Iterable $this$mapNotNull$iv111114 = (Iterable) items;
                        destination$iv$iv = new ArrayList();
                        while (r27.hasNext()) {
                            final JsonNode item111114 = (JsonNode) element$iv$iv$iv;
                            ObjectMapper mapper111115 = mapper;
                            jsonNode3 = item111114.get("title");
                            if (jsonNode3 != null) {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                destination$iv$iv2 = destination$iv$iv;
                                destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                destination$iv$iv2 = destination$iv$iv;
                            }
                            destination$iv$iv = destination$iv$iv2;
                            mapper = mapper111115;
                            responseBody = responseBody2;
                            requestBody4 = requestBody14;
                            page6 = page11;
                            break;
                        }
                        listEmptyList = (List) destination$iv$iv;
                        break;
                    }
                    if (listEmptyList == null) {
                        listEmptyList = CollectionsKt.emptyList();
                    }
                    List data1116 = listEmptyList;
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data1116, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                }
                jsonBody6 = jsonBody5;
                url4 = url3;
                year5 = year4;
                obj2 = obj;
                requestBody5 = requestBody4;
                c00022.L$0 = request5;
                c00022.L$1 = url4;
                c00022.L$2 = SpillingKt.nullOutSpilledVariable(data3);
                c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts5);
                c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId4);
                c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                c00022.L$6 = SpillingKt.nullOutSpilledVariable(country3);
                c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                c00022.L$8 = SpillingKt.nullOutSpilledVariable(year5);
                c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre8);
                c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort3);
                c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody6);
                c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers2);
                c00022.L$13 = requestBody5;
                c00022.L$14 = SpillingKt.nullOutSpilledVariable(response);
                c00022.I$0 = page3;
                c00022.I$1 = perPage4;
                c00022.I$2 = pg2;
                c00022.label = 6;
                objBuildAuthHeaders$default3 = buildAuthHeaders$default(this, "GET", url4, null, null, null, false, c00022, 60, null);
                if (objBuildAuthHeaders$default3 == obj2) {
                    return obj2;
                }
                int i16 = pg2;
                $result3 = objBuildAuthHeaders$default3;
                pg3 = i16;
                page4 = page3;
                request6 = request5;
                requestBody6 = requestBody5;
                genre9 = genre8;
                headers3 = headers2;
                response2 = response;
                jsonBody7 = jsonBody6;
                sort4 = sort3;
                year6 = year5;
                response4 = response2;
                jsonBody10 = jsonBody7;
                sort5 = sort4;
                perPage5 = perPage4;
                jsonBody11 = url4;
                genre10 = genre9;
                url6 = channelId4;
                requestBody9 = requestBody6;
                year9 = year6;
                headers5 = (Map) $result3;
                page7 = page4;
                year10 = data3;
                genre11 = country3;
                pg5 = pg3;
                mainParts6 = mainParts5;
                data4 = year10;
                mainParts7 = mainParts6;
                channelId5 = url6;
                jsonNode = null;
                if (StringsKt.contains$default(request6.getData(), "|", false, 2, (Object) null)) {
                    Requests app1119 = MainActivityKt.getApp();
                    c00022.L$0 = request6;
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(jsonBody11);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts7);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId5);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(genre11);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(year9);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre10);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort5);
                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody10);
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers5);
                    c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody9);
                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(response4);
                    c00022.I$0 = page7;
                    c00022.I$1 = perPage5;
                    c00022.I$2 = pg5;
                    c00022.label = 7;
                    $result3 = Requests.post$default(app1119, jsonBody11, headers5, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody9, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                    requestBody12 = requestBody9;
                    if ($result3 == obj2) {
                        return obj2;
                    }
                    data6 = data4;
                    mainParts9 = mainParts7;
                    classify5 = genre11;
                    page9 = page7;
                    pg6 = pg5;
                    headers6 = headers5;
                    requestBody13 = requestBody12;
                    request8 = request6;
                    country5 = country2;
                    niceResponse2 = (NiceResponse) $result3;
                    request5 = request8;
                    page10 = page9;
                    response = niceResponse2;
                    requestBody4 = requestBody13;
                    page6 = page10;
                    responseBody = response.getText();
                    mapper = ExtensionsKt.jacksonObjectMapper();
                    root = mapper.readTree(responseBody);
                    str = str2;
                    jsonNode2 = root.get(str);
                    if (jsonNode2 == null) {
                        jsonNode5 = root.get(str);
                        if (jsonNode5 != null) {
                            jsonNode6 = jsonNode5.get("subjects");
                        } else {
                            jsonNode6 = jsonNode;
                        }
                        if (jsonNode6 == null) {
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                        }
                        items = jsonNode6;
                        Iterable $this$mapNotNull$iv111115 = (Iterable) items;
                        destination$iv$iv = new ArrayList();
                        while (r27.hasNext()) {
                            final JsonNode item111115 = (JsonNode) element$iv$iv$iv;
                            ObjectMapper mapper111116 = mapper;
                            jsonNode3 = item111115.get("title");
                            if (jsonNode3 != null) {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                destination$iv$iv2 = destination$iv$iv;
                                destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                destination$iv$iv2 = destination$iv$iv;
                            }
                            destination$iv$iv = destination$iv$iv2;
                            mapper = mapper111116;
                            responseBody = responseBody2;
                            requestBody4 = requestBody14;
                            page6 = page11;
                            break;
                        }
                        listEmptyList = (List) destination$iv$iv;
                        break;
                    } else {
                        items = jsonNode2.get("items");
                        if (items == null) {
                            jsonNode5 = root.get(str);
                            if (jsonNode5 != null) {
                                jsonNode6 = jsonNode5.get("subjects");
                            } else {
                                jsonNode6 = jsonNode;
                            }
                            if (jsonNode6 == null) {
                                return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                            }
                            items = jsonNode6;
                        }
                        Iterable $this$mapNotNull$iv111116 = (Iterable) items;
                        destination$iv$iv = new ArrayList();
                        while (r27.hasNext()) {
                            final JsonNode item111116 = (JsonNode) element$iv$iv$iv;
                            ObjectMapper mapper111117 = mapper;
                            jsonNode3 = item111116.get("title");
                            if (jsonNode3 != null) {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                destination$iv$iv2 = destination$iv$iv;
                                destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                destination$iv$iv2 = destination$iv$iv;
                            }
                            destination$iv$iv = destination$iv$iv2;
                            mapper = mapper111117;
                            responseBody = responseBody2;
                            requestBody4 = requestBody14;
                            page6 = page11;
                            break;
                        }
                        listEmptyList = (List) destination$iv$iv;
                        break;
                    }
                    if (listEmptyList == null) {
                        listEmptyList = CollectionsKt.emptyList();
                    }
                    List data1117 = listEmptyList;
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data1117, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                }
                requestBody10 = requestBody9;
                Requests app11110 = MainActivityKt.getApp();
                c00022.L$0 = request6;
                c00022.L$1 = SpillingKt.nullOutSpilledVariable(jsonBody11);
                c00022.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts7);
                c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId5);
                c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                c00022.L$6 = SpillingKt.nullOutSpilledVariable(genre11);
                c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                c00022.L$8 = SpillingKt.nullOutSpilledVariable(year9);
                c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre10);
                c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort5);
                c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody10);
                c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers5);
                c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody10);
                c00022.L$14 = SpillingKt.nullOutSpilledVariable(response4);
                c00022.I$0 = page7;
                c00022.I$1 = perPage5;
                c00022.I$2 = pg5;
                c00022.label = 8;
                $result3 = Requests.get$default(app11110, jsonBody11, headers5, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                if ($result3 == obj2) {
                    return obj2;
                }
                data5 = data4;
                mainParts8 = mainParts7;
                classify4 = genre11;
                page8 = page7;
                pg6 = pg5;
                perPage6 = perPage5;
                genre12 = genre10;
                year11 = year9;
                response5 = response4;
                requestBody11 = requestBody10;
                request7 = request6;
                country4 = country2;
                niceResponse2 = (NiceResponse) $result3;
                requestBody13 = requestBody11;
                request5 = request7;
                page10 = page8;
                response = niceResponse2;
                requestBody4 = requestBody13;
                page6 = page10;
                responseBody = response.getText();
                mapper = ExtensionsKt.jacksonObjectMapper();
                root = mapper.readTree(responseBody);
                str = str2;
                jsonNode2 = root.get(str);
                if (jsonNode2 == null) {
                    jsonNode5 = root.get(str);
                    if (jsonNode5 != null) {
                        jsonNode6 = jsonNode5.get("subjects");
                    } else {
                        jsonNode6 = jsonNode;
                    }
                    if (jsonNode6 == null) {
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                    }
                    items = jsonNode6;
                    Iterable $this$mapNotNull$iv111117 = (Iterable) items;
                    destination$iv$iv = new ArrayList();
                    while (r27.hasNext()) {
                        final JsonNode item111117 = (JsonNode) element$iv$iv$iv;
                        ObjectMapper mapper111118 = mapper;
                        jsonNode3 = item111117.get("title");
                        if (jsonNode3 != null) {
                            page11 = page6;
                            responseBody2 = responseBody;
                            requestBody14 = requestBody4;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            page11 = page6;
                            responseBody2 = responseBody;
                            requestBody14 = requestBody4;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        }
                        if (movieSearchResponseNewMovieSearchResponse$default != null) {
                            destination$iv$iv2 = destination$iv$iv;
                            destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                        } else {
                            destination$iv$iv2 = destination$iv$iv;
                        }
                        destination$iv$iv = destination$iv$iv2;
                        mapper = mapper111118;
                        responseBody = responseBody2;
                        requestBody4 = requestBody14;
                        page6 = page11;
                        break;
                    }
                    listEmptyList = (List) destination$iv$iv;
                    break;
                } else {
                    items = jsonNode2.get("items");
                    if (items == null) {
                        jsonNode5 = root.get(str);
                        if (jsonNode5 != null) {
                            jsonNode6 = jsonNode5.get("subjects");
                        } else {
                            jsonNode6 = jsonNode;
                        }
                        if (jsonNode6 == null) {
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                        }
                        items = jsonNode6;
                    }
                    Iterable $this$mapNotNull$iv111118 = (Iterable) items;
                    destination$iv$iv = new ArrayList();
                    while (r27.hasNext()) {
                        final JsonNode item111118 = (JsonNode) element$iv$iv$iv;
                        ObjectMapper mapper111119 = mapper;
                        jsonNode3 = item111118.get("title");
                        if (jsonNode3 != null) {
                            page11 = page6;
                            responseBody2 = responseBody;
                            requestBody14 = requestBody4;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            page11 = page6;
                            responseBody2 = responseBody;
                            requestBody14 = requestBody4;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        }
                        if (movieSearchResponseNewMovieSearchResponse$default != null) {
                            destination$iv$iv2 = destination$iv$iv;
                            destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                        } else {
                            destination$iv$iv2 = destination$iv$iv;
                        }
                        destination$iv$iv = destination$iv$iv2;
                        mapper = mapper111119;
                        responseBody = responseBody2;
                        requestBody4 = requestBody14;
                        page6 = page11;
                        break;
                    }
                    listEmptyList = (List) destination$iv$iv;
                    break;
                }
                if (listEmptyList == null) {
                    listEmptyList = CollectionsKt.emptyList();
                }
                List data1118 = listEmptyList;
                return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data1118, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
            case 3:
                int pg10 = c00022.I$2;
                int perPage9 = c00022.I$1;
                int page15 = c00022.I$0;
                RequestBody requestBody15 = (RequestBody) c00022.L$13;
                Map headers7 = (Map) c00022.L$12;
                jsonBody5 = (String) c00022.L$11;
                String sort9 = (String) c00022.L$10;
                genre7 = (String) c00022.L$9;
                classify3 = (String) c00022.L$8;
                String country8 = (String) c00022.L$7;
                country3 = (String) c00022.L$6;
                Map options7 = (Map) c00022.L$5;
                channelId4 = (String) c00022.L$4;
                mainParts5 = (List) c00022.L$3;
                data3 = (String) c00022.L$2;
                String url9 = (String) c00022.L$1;
                MainPageRequest request12 = (MainPageRequest) c00022.L$0;
                ResultKt.throwOnFailure($result3);
                country2 = country8;
                pg = pg10;
                headers = headers7;
                sort3 = sort9;
                str2 = str2;
                $result2 = $result3;
                obj = coroutine_suspended;
                options3 = options7;
                url2 = url9;
                perPage3 = perPage9;
                requestBody3 = requestBody15;
                jsonNode = null;
                request4 = request12;
                page3 = page15;
                String str14 = url2;
                perPage4 = perPage3;
                url3 = str14;
                request5 = request4;
                requestBody4 = requestBody3;
                niceResponse = (NiceResponse) $result3;
                headers2 = headers;
                genre8 = genre7;
                pg2 = pg;
                year4 = classify3;
                response = niceResponse;
                if (response.getCode() != 401) {
                    break;
                }
                bearerToken = jsonNode;
                sharedPreferences = movieBoxProvider.sharedPref;
                if (sharedPreferences != null) {
                    editorRemove.apply();
                    Unit unit9 = Unit.INSTANCE;
                }
                if (StringsKt.contains$default(request5.getData(), "|", false, 2, jsonNode)) {
                    c00022.L$0 = request5;
                    c00022.L$1 = url3;
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(data3);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts5);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId4);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(country3);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(year4);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre8);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort3);
                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody5);
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers2);
                    c00022.L$13 = requestBody4;
                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(response);
                    c00022.I$0 = page3;
                    c00022.I$1 = perPage4;
                    c00022.I$2 = pg2;
                    c00022.label = 5;
                    requestBody7 = requestBody4;
                    url5 = url3;
                    year7 = year4;
                    obj2 = obj;
                    objBuildAuthHeaders$default4 = buildAuthHeaders$default(this, "POST", url5, "application/json; charset=utf-8", null, jsonBody5, false, c00022, 40, null);
                    jsonBody8 = jsonBody5;
                    if (objBuildAuthHeaders$default4 == obj2) {
                        return obj2;
                    }
                    int i17 = pg2;
                    $result3 = objBuildAuthHeaders$default4;
                    pg4 = i17;
                    page5 = page3;
                    request6 = request5;
                    requestBody8 = requestBody7;
                    genre10 = genre8;
                    headers4 = headers2;
                    response3 = response;
                    jsonBody9 = jsonBody8;
                    sort5 = sort3;
                    year8 = year7;
                    response4 = response3;
                    jsonBody10 = jsonBody9;
                    perPage5 = perPage4;
                    jsonBody11 = url5;
                    url6 = channelId4;
                    requestBody9 = requestBody8;
                    year9 = year8;
                    headers5 = (Map) $result3;
                    genre11 = country3;
                    year10 = data3;
                    pg5 = pg4;
                    mainParts6 = mainParts5;
                    page7 = page5;
                    data4 = year10;
                    mainParts7 = mainParts6;
                    channelId5 = url6;
                    jsonNode = null;
                    if (StringsKt.contains$default(request6.getData(), "|", false, 2, (Object) null)) {
                        Requests app11111 = MainActivityKt.getApp();
                        c00022.L$0 = request6;
                        c00022.L$1 = SpillingKt.nullOutSpilledVariable(jsonBody11);
                        c00022.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                        c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts7);
                        c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId5);
                        c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                        c00022.L$6 = SpillingKt.nullOutSpilledVariable(genre11);
                        c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                        c00022.L$8 = SpillingKt.nullOutSpilledVariable(year9);
                        c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre10);
                        c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort5);
                        c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody10);
                        c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers5);
                        c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody9);
                        c00022.L$14 = SpillingKt.nullOutSpilledVariable(response4);
                        c00022.I$0 = page7;
                        c00022.I$1 = perPage5;
                        c00022.I$2 = pg5;
                        c00022.label = 7;
                        $result3 = Requests.post$default(app11111, jsonBody11, headers5, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody9, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                        requestBody12 = requestBody9;
                        if ($result3 == obj2) {
                            return obj2;
                        }
                        data6 = data4;
                        mainParts9 = mainParts7;
                        classify5 = genre11;
                        page9 = page7;
                        pg6 = pg5;
                        headers6 = headers5;
                        requestBody13 = requestBody12;
                        request8 = request6;
                        country5 = country2;
                        niceResponse2 = (NiceResponse) $result3;
                        request5 = request8;
                        page10 = page9;
                        response = niceResponse2;
                        requestBody4 = requestBody13;
                        page6 = page10;
                        responseBody = response.getText();
                        mapper = ExtensionsKt.jacksonObjectMapper();
                        root = mapper.readTree(responseBody);
                        str = str2;
                        jsonNode2 = root.get(str);
                        if (jsonNode2 == null) {
                            jsonNode5 = root.get(str);
                            if (jsonNode5 != null) {
                                jsonNode6 = jsonNode5.get("subjects");
                            } else {
                                jsonNode6 = jsonNode;
                            }
                            if (jsonNode6 == null) {
                                return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                            }
                            items = jsonNode6;
                            Iterable $this$mapNotNull$iv111119 = (Iterable) items;
                            destination$iv$iv = new ArrayList();
                            while (r27.hasNext()) {
                                final JsonNode item111119 = (JsonNode) element$iv$iv$iv;
                                ObjectMapper mapper1111110 = mapper;
                                jsonNode3 = item111119.get("title");
                                if (jsonNode3 != null) {
                                    page11 = page6;
                                    responseBody2 = responseBody;
                                    requestBody14 = requestBody4;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    page11 = page6;
                                    responseBody2 = responseBody;
                                    requestBody14 = requestBody4;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                                if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                    destination$iv$iv2 = destination$iv$iv;
                                    destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                                } else {
                                    destination$iv$iv2 = destination$iv$iv;
                                }
                                destination$iv$iv = destination$iv$iv2;
                                mapper = mapper1111110;
                                responseBody = responseBody2;
                                requestBody4 = requestBody14;
                                page6 = page11;
                                break;
                            }
                            listEmptyList = (List) destination$iv$iv;
                            break;
                        } else {
                            items = jsonNode2.get("items");
                            if (items == null) {
                                jsonNode5 = root.get(str);
                                if (jsonNode5 != null) {
                                    jsonNode6 = jsonNode5.get("subjects");
                                } else {
                                    jsonNode6 = jsonNode;
                                }
                                if (jsonNode6 == null) {
                                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                                }
                                items = jsonNode6;
                            }
                            Iterable $this$mapNotNull$iv1111110 = (Iterable) items;
                            destination$iv$iv = new ArrayList();
                            while (r27.hasNext()) {
                                final JsonNode item1111110 = (JsonNode) element$iv$iv$iv;
                                ObjectMapper mapper1111111 = mapper;
                                jsonNode3 = item1111110.get("title");
                                if (jsonNode3 != null) {
                                    page11 = page6;
                                    responseBody2 = responseBody;
                                    requestBody14 = requestBody4;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    page11 = page6;
                                    responseBody2 = responseBody;
                                    requestBody14 = requestBody4;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                                if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                    destination$iv$iv2 = destination$iv$iv;
                                    destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                                } else {
                                    destination$iv$iv2 = destination$iv$iv;
                                }
                                destination$iv$iv = destination$iv$iv2;
                                mapper = mapper1111111;
                                responseBody = responseBody2;
                                requestBody4 = requestBody14;
                                page6 = page11;
                                break;
                            }
                            listEmptyList = (List) destination$iv$iv;
                            break;
                        }
                        if (listEmptyList == null) {
                            listEmptyList = CollectionsKt.emptyList();
                        }
                        List data1119 = listEmptyList;
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data1119, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                    }
                    requestBody10 = requestBody9;
                    Requests app11112 = MainActivityKt.getApp();
                    c00022.L$0 = request6;
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(jsonBody11);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts7);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId5);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(genre11);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(year9);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre10);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort5);
                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody10);
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers5);
                    c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody10);
                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(response4);
                    c00022.I$0 = page7;
                    c00022.I$1 = perPage5;
                    c00022.I$2 = pg5;
                    c00022.label = 8;
                    $result3 = Requests.get$default(app11112, jsonBody11, headers5, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                    if ($result3 == obj2) {
                        return obj2;
                    }
                    data5 = data4;
                    mainParts8 = mainParts7;
                    classify4 = genre11;
                    page8 = page7;
                    pg6 = pg5;
                    perPage6 = perPage5;
                    genre12 = genre10;
                    year11 = year9;
                    response5 = response4;
                    requestBody11 = requestBody10;
                    request7 = request6;
                    country4 = country2;
                    niceResponse2 = (NiceResponse) $result3;
                    requestBody13 = requestBody11;
                    request5 = request7;
                    page10 = page8;
                    response = niceResponse2;
                    requestBody4 = requestBody13;
                    page6 = page10;
                    responseBody = response.getText();
                    mapper = ExtensionsKt.jacksonObjectMapper();
                    root = mapper.readTree(responseBody);
                    str = str2;
                    jsonNode2 = root.get(str);
                    if (jsonNode2 == null) {
                        jsonNode5 = root.get(str);
                        if (jsonNode5 != null) {
                            jsonNode6 = jsonNode5.get("subjects");
                        } else {
                            jsonNode6 = jsonNode;
                        }
                        if (jsonNode6 == null) {
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                        }
                        items = jsonNode6;
                        Iterable $this$mapNotNull$iv1111111 = (Iterable) items;
                        destination$iv$iv = new ArrayList();
                        while (r27.hasNext()) {
                            final JsonNode item1111111 = (JsonNode) element$iv$iv$iv;
                            ObjectMapper mapper1111112 = mapper;
                            jsonNode3 = item1111111.get("title");
                            if (jsonNode3 != null) {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                destination$iv$iv2 = destination$iv$iv;
                                destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                destination$iv$iv2 = destination$iv$iv;
                            }
                            destination$iv$iv = destination$iv$iv2;
                            mapper = mapper1111112;
                            responseBody = responseBody2;
                            requestBody4 = requestBody14;
                            page6 = page11;
                            break;
                        }
                        listEmptyList = (List) destination$iv$iv;
                        break;
                    } else {
                        items = jsonNode2.get("items");
                        if (items == null) {
                            jsonNode5 = root.get(str);
                            if (jsonNode5 != null) {
                                jsonNode6 = jsonNode5.get("subjects");
                            } else {
                                jsonNode6 = jsonNode;
                            }
                            if (jsonNode6 == null) {
                                return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                            }
                            items = jsonNode6;
                        }
                        Iterable $this$mapNotNull$iv1111112 = (Iterable) items;
                        destination$iv$iv = new ArrayList();
                        while (r27.hasNext()) {
                            final JsonNode item1111112 = (JsonNode) element$iv$iv$iv;
                            ObjectMapper mapper1111113 = mapper;
                            jsonNode3 = item1111112.get("title");
                            if (jsonNode3 != null) {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                destination$iv$iv2 = destination$iv$iv;
                                destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                destination$iv$iv2 = destination$iv$iv;
                            }
                            destination$iv$iv = destination$iv$iv2;
                            mapper = mapper1111113;
                            responseBody = responseBody2;
                            requestBody4 = requestBody14;
                            page6 = page11;
                            break;
                        }
                        listEmptyList = (List) destination$iv$iv;
                        break;
                    }
                    if (listEmptyList == null) {
                        listEmptyList = CollectionsKt.emptyList();
                    }
                    List data11110 = listEmptyList;
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data11110, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                }
                jsonBody6 = jsonBody5;
                url4 = url3;
                year5 = year4;
                obj2 = obj;
                requestBody5 = requestBody4;
                c00022.L$0 = request5;
                c00022.L$1 = url4;
                c00022.L$2 = SpillingKt.nullOutSpilledVariable(data3);
                c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts5);
                c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId4);
                c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                c00022.L$6 = SpillingKt.nullOutSpilledVariable(country3);
                c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                c00022.L$8 = SpillingKt.nullOutSpilledVariable(year5);
                c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre8);
                c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort3);
                c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody6);
                c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers2);
                c00022.L$13 = requestBody5;
                c00022.L$14 = SpillingKt.nullOutSpilledVariable(response);
                c00022.I$0 = page3;
                c00022.I$1 = perPage4;
                c00022.I$2 = pg2;
                c00022.label = 6;
                objBuildAuthHeaders$default3 = buildAuthHeaders$default(this, "GET", url4, null, null, null, false, c00022, 60, null);
                if (objBuildAuthHeaders$default3 == obj2) {
                    return obj2;
                }
                int i18 = pg2;
                $result3 = objBuildAuthHeaders$default3;
                pg3 = i18;
                page4 = page3;
                request6 = request5;
                requestBody6 = requestBody5;
                genre9 = genre8;
                headers3 = headers2;
                response2 = response;
                jsonBody7 = jsonBody6;
                sort4 = sort3;
                year6 = year5;
                response4 = response2;
                jsonBody10 = jsonBody7;
                sort5 = sort4;
                perPage5 = perPage4;
                jsonBody11 = url4;
                genre10 = genre9;
                url6 = channelId4;
                requestBody9 = requestBody6;
                year9 = year6;
                headers5 = (Map) $result3;
                page7 = page4;
                year10 = data3;
                genre11 = country3;
                pg5 = pg3;
                mainParts6 = mainParts5;
                data4 = year10;
                mainParts7 = mainParts6;
                channelId5 = url6;
                jsonNode = null;
                if (StringsKt.contains$default(request6.getData(), "|", false, 2, (Object) null)) {
                    Requests app11113 = MainActivityKt.getApp();
                    c00022.L$0 = request6;
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(jsonBody11);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts7);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId5);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(genre11);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(year9);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre10);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort5);
                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody10);
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers5);
                    c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody9);
                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(response4);
                    c00022.I$0 = page7;
                    c00022.I$1 = perPage5;
                    c00022.I$2 = pg5;
                    c00022.label = 7;
                    $result3 = Requests.post$default(app11113, jsonBody11, headers5, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody9, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                    requestBody12 = requestBody9;
                    if ($result3 == obj2) {
                        return obj2;
                    }
                    data6 = data4;
                    mainParts9 = mainParts7;
                    classify5 = genre11;
                    page9 = page7;
                    pg6 = pg5;
                    headers6 = headers5;
                    requestBody13 = requestBody12;
                    request8 = request6;
                    country5 = country2;
                    niceResponse2 = (NiceResponse) $result3;
                    request5 = request8;
                    page10 = page9;
                    response = niceResponse2;
                    requestBody4 = requestBody13;
                    page6 = page10;
                    responseBody = response.getText();
                    mapper = ExtensionsKt.jacksonObjectMapper();
                    root = mapper.readTree(responseBody);
                    str = str2;
                    jsonNode2 = root.get(str);
                    if (jsonNode2 == null) {
                        jsonNode5 = root.get(str);
                        if (jsonNode5 != null) {
                            jsonNode6 = jsonNode5.get("subjects");
                        } else {
                            jsonNode6 = jsonNode;
                        }
                        if (jsonNode6 == null) {
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                        }
                        items = jsonNode6;
                        Iterable $this$mapNotNull$iv1111113 = (Iterable) items;
                        destination$iv$iv = new ArrayList();
                        while (r27.hasNext()) {
                            final JsonNode item1111113 = (JsonNode) element$iv$iv$iv;
                            ObjectMapper mapper1111114 = mapper;
                            jsonNode3 = item1111113.get("title");
                            if (jsonNode3 != null) {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                destination$iv$iv2 = destination$iv$iv;
                                destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                destination$iv$iv2 = destination$iv$iv;
                            }
                            destination$iv$iv = destination$iv$iv2;
                            mapper = mapper1111114;
                            responseBody = responseBody2;
                            requestBody4 = requestBody14;
                            page6 = page11;
                            break;
                        }
                        listEmptyList = (List) destination$iv$iv;
                        break;
                    } else {
                        items = jsonNode2.get("items");
                        if (items == null) {
                            jsonNode5 = root.get(str);
                            if (jsonNode5 != null) {
                                jsonNode6 = jsonNode5.get("subjects");
                            } else {
                                jsonNode6 = jsonNode;
                            }
                            if (jsonNode6 == null) {
                                return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                            }
                            items = jsonNode6;
                        }
                        Iterable $this$mapNotNull$iv1111114 = (Iterable) items;
                        destination$iv$iv = new ArrayList();
                        while (r27.hasNext()) {
                            final JsonNode item1111114 = (JsonNode) element$iv$iv$iv;
                            ObjectMapper mapper1111115 = mapper;
                            jsonNode3 = item1111114.get("title");
                            if (jsonNode3 != null) {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                destination$iv$iv2 = destination$iv$iv;
                                destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                destination$iv$iv2 = destination$iv$iv;
                            }
                            destination$iv$iv = destination$iv$iv2;
                            mapper = mapper1111115;
                            responseBody = responseBody2;
                            requestBody4 = requestBody14;
                            page6 = page11;
                            break;
                        }
                        listEmptyList = (List) destination$iv$iv;
                        break;
                    }
                    if (listEmptyList == null) {
                        listEmptyList = CollectionsKt.emptyList();
                    }
                    List data11111 = listEmptyList;
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data11111, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                }
                requestBody10 = requestBody9;
                Requests app11114 = MainActivityKt.getApp();
                c00022.L$0 = request6;
                c00022.L$1 = SpillingKt.nullOutSpilledVariable(jsonBody11);
                c00022.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts7);
                c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId5);
                c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                c00022.L$6 = SpillingKt.nullOutSpilledVariable(genre11);
                c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                c00022.L$8 = SpillingKt.nullOutSpilledVariable(year9);
                c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre10);
                c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort5);
                c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody10);
                c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers5);
                c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody10);
                c00022.L$14 = SpillingKt.nullOutSpilledVariable(response4);
                c00022.I$0 = page7;
                c00022.I$1 = perPage5;
                c00022.I$2 = pg5;
                c00022.label = 8;
                $result3 = Requests.get$default(app11114, jsonBody11, headers5, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                if ($result3 == obj2) {
                    return obj2;
                }
                data5 = data4;
                mainParts8 = mainParts7;
                classify4 = genre11;
                page8 = page7;
                pg6 = pg5;
                perPage6 = perPage5;
                genre12 = genre10;
                year11 = year9;
                response5 = response4;
                requestBody11 = requestBody10;
                request7 = request6;
                country4 = country2;
                niceResponse2 = (NiceResponse) $result3;
                requestBody13 = requestBody11;
                request5 = request7;
                page10 = page8;
                response = niceResponse2;
                requestBody4 = requestBody13;
                page6 = page10;
                responseBody = response.getText();
                mapper = ExtensionsKt.jacksonObjectMapper();
                root = mapper.readTree(responseBody);
                str = str2;
                jsonNode2 = root.get(str);
                if (jsonNode2 == null) {
                    jsonNode5 = root.get(str);
                    if (jsonNode5 != null) {
                        jsonNode6 = jsonNode5.get("subjects");
                    } else {
                        jsonNode6 = jsonNode;
                    }
                    if (jsonNode6 == null) {
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                    }
                    items = jsonNode6;
                    Iterable $this$mapNotNull$iv1111115 = (Iterable) items;
                    destination$iv$iv = new ArrayList();
                    while (r27.hasNext()) {
                        final JsonNode item1111115 = (JsonNode) element$iv$iv$iv;
                        ObjectMapper mapper1111116 = mapper;
                        jsonNode3 = item1111115.get("title");
                        if (jsonNode3 != null) {
                            page11 = page6;
                            responseBody2 = responseBody;
                            requestBody14 = requestBody4;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            page11 = page6;
                            responseBody2 = responseBody;
                            requestBody14 = requestBody4;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        }
                        if (movieSearchResponseNewMovieSearchResponse$default != null) {
                            destination$iv$iv2 = destination$iv$iv;
                            destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                        } else {
                            destination$iv$iv2 = destination$iv$iv;
                        }
                        destination$iv$iv = destination$iv$iv2;
                        mapper = mapper1111116;
                        responseBody = responseBody2;
                        requestBody4 = requestBody14;
                        page6 = page11;
                        break;
                    }
                    listEmptyList = (List) destination$iv$iv;
                    break;
                } else {
                    items = jsonNode2.get("items");
                    if (items == null) {
                        jsonNode5 = root.get(str);
                        if (jsonNode5 != null) {
                            jsonNode6 = jsonNode5.get("subjects");
                        } else {
                            jsonNode6 = jsonNode;
                        }
                        if (jsonNode6 == null) {
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                        }
                        items = jsonNode6;
                    }
                    Iterable $this$mapNotNull$iv1111116 = (Iterable) items;
                    destination$iv$iv = new ArrayList();
                    while (r27.hasNext()) {
                        final JsonNode item1111116 = (JsonNode) element$iv$iv$iv;
                        ObjectMapper mapper1111117 = mapper;
                        jsonNode3 = item1111116.get("title");
                        if (jsonNode3 != null) {
                            page11 = page6;
                            responseBody2 = responseBody;
                            requestBody14 = requestBody4;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            page11 = page6;
                            responseBody2 = responseBody;
                            requestBody14 = requestBody4;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        }
                        if (movieSearchResponseNewMovieSearchResponse$default != null) {
                            destination$iv$iv2 = destination$iv$iv;
                            destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                        } else {
                            destination$iv$iv2 = destination$iv$iv;
                        }
                        destination$iv$iv = destination$iv$iv2;
                        mapper = mapper1111117;
                        responseBody = responseBody2;
                        requestBody4 = requestBody14;
                        page6 = page11;
                        break;
                    }
                    listEmptyList = (List) destination$iv$iv;
                    break;
                }
                if (listEmptyList == null) {
                    listEmptyList = CollectionsKt.emptyList();
                }
                List data11112 = listEmptyList;
                return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data11112, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
            case 4:
                int pg11 = c00022.I$2;
                int perPage10 = c00022.I$1;
                int page16 = c00022.I$0;
                RequestBody requestBody16 = (RequestBody) c00022.L$13;
                Map headers8 = (Map) c00022.L$12;
                jsonBody5 = (String) c00022.L$11;
                String sort10 = (String) c00022.L$10;
                genre6 = (String) c00022.L$9;
                classify2 = (String) c00022.L$8;
                String country9 = (String) c00022.L$7;
                country3 = (String) c00022.L$6;
                Map options8 = (Map) c00022.L$5;
                channelId4 = (String) c00022.L$4;
                mainParts5 = (List) c00022.L$3;
                data3 = (String) c00022.L$2;
                String url10 = (String) c00022.L$1;
                MainPageRequest request13 = (MainPageRequest) c00022.L$0;
                ResultKt.throwOnFailure($result3);
                country2 = country9;
                pg = pg11;
                headers = headers8;
                sort3 = sort10;
                str2 = str2;
                $result2 = $result3;
                obj = coroutine_suspended;
                options3 = options8;
                url2 = url10;
                perPage3 = perPage10;
                requestBody2 = requestBody16;
                jsonNode = null;
                request3 = request13;
                page3 = page16;
                String str15 = url2;
                perPage4 = perPage3;
                url3 = str15;
                request5 = request3;
                requestBody4 = requestBody2;
                niceResponse = (NiceResponse) $result3;
                headers2 = headers;
                genre8 = genre6;
                pg2 = pg;
                year4 = classify2;
                response = niceResponse;
                if (response.getCode() != 401) {
                    break;
                }
                bearerToken = jsonNode;
                sharedPreferences = movieBoxProvider.sharedPref;
                if (sharedPreferences != null) {
                    editorRemove.apply();
                    Unit unit10 = Unit.INSTANCE;
                }
                if (StringsKt.contains$default(request5.getData(), "|", false, 2, jsonNode)) {
                    c00022.L$0 = request5;
                    c00022.L$1 = url3;
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(data3);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts5);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId4);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(country3);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(year4);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre8);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort3);
                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody5);
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers2);
                    c00022.L$13 = requestBody4;
                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(response);
                    c00022.I$0 = page3;
                    c00022.I$1 = perPage4;
                    c00022.I$2 = pg2;
                    c00022.label = 5;
                    requestBody7 = requestBody4;
                    url5 = url3;
                    year7 = year4;
                    obj2 = obj;
                    objBuildAuthHeaders$default4 = buildAuthHeaders$default(this, "POST", url5, "application/json; charset=utf-8", null, jsonBody5, false, c00022, 40, null);
                    jsonBody8 = jsonBody5;
                    if (objBuildAuthHeaders$default4 == obj2) {
                        return obj2;
                    }
                    int i19 = pg2;
                    $result3 = objBuildAuthHeaders$default4;
                    pg4 = i19;
                    page5 = page3;
                    request6 = request5;
                    requestBody8 = requestBody7;
                    genre10 = genre8;
                    headers4 = headers2;
                    response3 = response;
                    jsonBody9 = jsonBody8;
                    sort5 = sort3;
                    year8 = year7;
                    response4 = response3;
                    jsonBody10 = jsonBody9;
                    perPage5 = perPage4;
                    jsonBody11 = url5;
                    url6 = channelId4;
                    requestBody9 = requestBody8;
                    year9 = year8;
                    headers5 = (Map) $result3;
                    genre11 = country3;
                    year10 = data3;
                    pg5 = pg4;
                    mainParts6 = mainParts5;
                    page7 = page5;
                    data4 = year10;
                    mainParts7 = mainParts6;
                    channelId5 = url6;
                    jsonNode = null;
                    if (StringsKt.contains$default(request6.getData(), "|", false, 2, (Object) null)) {
                        Requests app11115 = MainActivityKt.getApp();
                        c00022.L$0 = request6;
                        c00022.L$1 = SpillingKt.nullOutSpilledVariable(jsonBody11);
                        c00022.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                        c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts7);
                        c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId5);
                        c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                        c00022.L$6 = SpillingKt.nullOutSpilledVariable(genre11);
                        c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                        c00022.L$8 = SpillingKt.nullOutSpilledVariable(year9);
                        c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre10);
                        c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort5);
                        c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody10);
                        c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers5);
                        c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody9);
                        c00022.L$14 = SpillingKt.nullOutSpilledVariable(response4);
                        c00022.I$0 = page7;
                        c00022.I$1 = perPage5;
                        c00022.I$2 = pg5;
                        c00022.label = 7;
                        $result3 = Requests.post$default(app11115, jsonBody11, headers5, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody9, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                        requestBody12 = requestBody9;
                        if ($result3 == obj2) {
                            return obj2;
                        }
                        data6 = data4;
                        mainParts9 = mainParts7;
                        classify5 = genre11;
                        page9 = page7;
                        pg6 = pg5;
                        headers6 = headers5;
                        requestBody13 = requestBody12;
                        request8 = request6;
                        country5 = country2;
                        niceResponse2 = (NiceResponse) $result3;
                        request5 = request8;
                        page10 = page9;
                        response = niceResponse2;
                        requestBody4 = requestBody13;
                        page6 = page10;
                        responseBody = response.getText();
                        mapper = ExtensionsKt.jacksonObjectMapper();
                        root = mapper.readTree(responseBody);
                        str = str2;
                        jsonNode2 = root.get(str);
                        if (jsonNode2 == null) {
                            jsonNode5 = root.get(str);
                            if (jsonNode5 != null) {
                                jsonNode6 = jsonNode5.get("subjects");
                            } else {
                                jsonNode6 = jsonNode;
                            }
                            if (jsonNode6 == null) {
                                return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                            }
                            items = jsonNode6;
                            Iterable $this$mapNotNull$iv1111117 = (Iterable) items;
                            destination$iv$iv = new ArrayList();
                            while (r27.hasNext()) {
                                final JsonNode item1111117 = (JsonNode) element$iv$iv$iv;
                                ObjectMapper mapper1111118 = mapper;
                                jsonNode3 = item1111117.get("title");
                                if (jsonNode3 != null) {
                                    page11 = page6;
                                    responseBody2 = responseBody;
                                    requestBody14 = requestBody4;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    page11 = page6;
                                    responseBody2 = responseBody;
                                    requestBody14 = requestBody4;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                                if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                    destination$iv$iv2 = destination$iv$iv;
                                    destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                                } else {
                                    destination$iv$iv2 = destination$iv$iv;
                                }
                                destination$iv$iv = destination$iv$iv2;
                                mapper = mapper1111118;
                                responseBody = responseBody2;
                                requestBody4 = requestBody14;
                                page6 = page11;
                                break;
                            }
                            listEmptyList = (List) destination$iv$iv;
                            break;
                        } else {
                            items = jsonNode2.get("items");
                            if (items == null) {
                                jsonNode5 = root.get(str);
                                if (jsonNode5 != null) {
                                    jsonNode6 = jsonNode5.get("subjects");
                                } else {
                                    jsonNode6 = jsonNode;
                                }
                                if (jsonNode6 == null) {
                                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                                }
                                items = jsonNode6;
                            }
                            Iterable $this$mapNotNull$iv1111118 = (Iterable) items;
                            destination$iv$iv = new ArrayList();
                            while (r27.hasNext()) {
                                final JsonNode item1111118 = (JsonNode) element$iv$iv$iv;
                                ObjectMapper mapper1111119 = mapper;
                                jsonNode3 = item1111118.get("title");
                                if (jsonNode3 != null) {
                                    page11 = page6;
                                    responseBody2 = responseBody;
                                    requestBody14 = requestBody4;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    page11 = page6;
                                    responseBody2 = responseBody;
                                    requestBody14 = requestBody4;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                                if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                    destination$iv$iv2 = destination$iv$iv;
                                    destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                                } else {
                                    destination$iv$iv2 = destination$iv$iv;
                                }
                                destination$iv$iv = destination$iv$iv2;
                                mapper = mapper1111119;
                                responseBody = responseBody2;
                                requestBody4 = requestBody14;
                                page6 = page11;
                                break;
                            }
                            listEmptyList = (List) destination$iv$iv;
                            break;
                        }
                        if (listEmptyList == null) {
                            listEmptyList = CollectionsKt.emptyList();
                        }
                        List data11113 = listEmptyList;
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data11113, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                    }
                    requestBody10 = requestBody9;
                    Requests app11116 = MainActivityKt.getApp();
                    c00022.L$0 = request6;
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(jsonBody11);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts7);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId5);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(genre11);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(year9);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre10);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort5);
                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody10);
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers5);
                    c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody10);
                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(response4);
                    c00022.I$0 = page7;
                    c00022.I$1 = perPage5;
                    c00022.I$2 = pg5;
                    c00022.label = 8;
                    $result3 = Requests.get$default(app11116, jsonBody11, headers5, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                    if ($result3 == obj2) {
                        return obj2;
                    }
                    data5 = data4;
                    mainParts8 = mainParts7;
                    classify4 = genre11;
                    page8 = page7;
                    pg6 = pg5;
                    perPage6 = perPage5;
                    genre12 = genre10;
                    year11 = year9;
                    response5 = response4;
                    requestBody11 = requestBody10;
                    request7 = request6;
                    country4 = country2;
                    niceResponse2 = (NiceResponse) $result3;
                    requestBody13 = requestBody11;
                    request5 = request7;
                    page10 = page8;
                    response = niceResponse2;
                    requestBody4 = requestBody13;
                    page6 = page10;
                    responseBody = response.getText();
                    mapper = ExtensionsKt.jacksonObjectMapper();
                    root = mapper.readTree(responseBody);
                    str = str2;
                    jsonNode2 = root.get(str);
                    if (jsonNode2 == null) {
                        jsonNode5 = root.get(str);
                        if (jsonNode5 != null) {
                            jsonNode6 = jsonNode5.get("subjects");
                        } else {
                            jsonNode6 = jsonNode;
                        }
                        if (jsonNode6 == null) {
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                        }
                        items = jsonNode6;
                        Iterable $this$mapNotNull$iv1111119 = (Iterable) items;
                        destination$iv$iv = new ArrayList();
                        while (r27.hasNext()) {
                            final JsonNode item1111119 = (JsonNode) element$iv$iv$iv;
                            ObjectMapper mapper11111110 = mapper;
                            jsonNode3 = item1111119.get("title");
                            if (jsonNode3 != null) {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                destination$iv$iv2 = destination$iv$iv;
                                destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                destination$iv$iv2 = destination$iv$iv;
                            }
                            destination$iv$iv = destination$iv$iv2;
                            mapper = mapper11111110;
                            responseBody = responseBody2;
                            requestBody4 = requestBody14;
                            page6 = page11;
                            break;
                        }
                        listEmptyList = (List) destination$iv$iv;
                        break;
                    } else {
                        items = jsonNode2.get("items");
                        if (items == null) {
                            jsonNode5 = root.get(str);
                            if (jsonNode5 != null) {
                                jsonNode6 = jsonNode5.get("subjects");
                            } else {
                                jsonNode6 = jsonNode;
                            }
                            if (jsonNode6 == null) {
                                return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                            }
                            items = jsonNode6;
                        }
                        Iterable $this$mapNotNull$iv11111110 = (Iterable) items;
                        destination$iv$iv = new ArrayList();
                        while (r27.hasNext()) {
                            final JsonNode item11111110 = (JsonNode) element$iv$iv$iv;
                            ObjectMapper mapper11111111 = mapper;
                            jsonNode3 = item11111110.get("title");
                            if (jsonNode3 != null) {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                destination$iv$iv2 = destination$iv$iv;
                                destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                destination$iv$iv2 = destination$iv$iv;
                            }
                            destination$iv$iv = destination$iv$iv2;
                            mapper = mapper11111111;
                            responseBody = responseBody2;
                            requestBody4 = requestBody14;
                            page6 = page11;
                            break;
                        }
                        listEmptyList = (List) destination$iv$iv;
                        break;
                    }
                    if (listEmptyList == null) {
                        listEmptyList = CollectionsKt.emptyList();
                    }
                    List data11114 = listEmptyList;
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data11114, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                }
                jsonBody6 = jsonBody5;
                url4 = url3;
                year5 = year4;
                obj2 = obj;
                requestBody5 = requestBody4;
                c00022.L$0 = request5;
                c00022.L$1 = url4;
                c00022.L$2 = SpillingKt.nullOutSpilledVariable(data3);
                c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts5);
                c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId4);
                c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                c00022.L$6 = SpillingKt.nullOutSpilledVariable(country3);
                c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                c00022.L$8 = SpillingKt.nullOutSpilledVariable(year5);
                c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre8);
                c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort3);
                c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody6);
                c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers2);
                c00022.L$13 = requestBody5;
                c00022.L$14 = SpillingKt.nullOutSpilledVariable(response);
                c00022.I$0 = page3;
                c00022.I$1 = perPage4;
                c00022.I$2 = pg2;
                c00022.label = 6;
                objBuildAuthHeaders$default3 = buildAuthHeaders$default(this, "GET", url4, null, null, null, false, c00022, 60, null);
                if (objBuildAuthHeaders$default3 == obj2) {
                    return obj2;
                }
                int i110 = pg2;
                $result3 = objBuildAuthHeaders$default3;
                pg3 = i110;
                page4 = page3;
                request6 = request5;
                requestBody6 = requestBody5;
                genre9 = genre8;
                headers3 = headers2;
                response2 = response;
                jsonBody7 = jsonBody6;
                sort4 = sort3;
                year6 = year5;
                response4 = response2;
                jsonBody10 = jsonBody7;
                sort5 = sort4;
                perPage5 = perPage4;
                jsonBody11 = url4;
                genre10 = genre9;
                url6 = channelId4;
                requestBody9 = requestBody6;
                year9 = year6;
                headers5 = (Map) $result3;
                page7 = page4;
                year10 = data3;
                genre11 = country3;
                pg5 = pg3;
                mainParts6 = mainParts5;
                data4 = year10;
                mainParts7 = mainParts6;
                channelId5 = url6;
                jsonNode = null;
                if (StringsKt.contains$default(request6.getData(), "|", false, 2, (Object) null)) {
                    Requests app11117 = MainActivityKt.getApp();
                    c00022.L$0 = request6;
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(jsonBody11);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts7);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId5);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(genre11);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(year9);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre10);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort5);
                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody10);
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers5);
                    c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody9);
                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(response4);
                    c00022.I$0 = page7;
                    c00022.I$1 = perPage5;
                    c00022.I$2 = pg5;
                    c00022.label = 7;
                    $result3 = Requests.post$default(app11117, jsonBody11, headers5, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody9, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                    requestBody12 = requestBody9;
                    if ($result3 == obj2) {
                        return obj2;
                    }
                    data6 = data4;
                    mainParts9 = mainParts7;
                    classify5 = genre11;
                    page9 = page7;
                    pg6 = pg5;
                    headers6 = headers5;
                    requestBody13 = requestBody12;
                    request8 = request6;
                    country5 = country2;
                    niceResponse2 = (NiceResponse) $result3;
                    request5 = request8;
                    page10 = page9;
                    response = niceResponse2;
                    requestBody4 = requestBody13;
                    page6 = page10;
                    responseBody = response.getText();
                    mapper = ExtensionsKt.jacksonObjectMapper();
                    root = mapper.readTree(responseBody);
                    str = str2;
                    jsonNode2 = root.get(str);
                    if (jsonNode2 == null) {
                        jsonNode5 = root.get(str);
                        if (jsonNode5 != null) {
                            jsonNode6 = jsonNode5.get("subjects");
                        } else {
                            jsonNode6 = jsonNode;
                        }
                        if (jsonNode6 == null) {
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                        }
                        items = jsonNode6;
                        Iterable $this$mapNotNull$iv11111111 = (Iterable) items;
                        destination$iv$iv = new ArrayList();
                        while (r27.hasNext()) {
                            final JsonNode item11111111 = (JsonNode) element$iv$iv$iv;
                            ObjectMapper mapper11111112 = mapper;
                            jsonNode3 = item11111111.get("title");
                            if (jsonNode3 != null) {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                destination$iv$iv2 = destination$iv$iv;
                                destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                destination$iv$iv2 = destination$iv$iv;
                            }
                            destination$iv$iv = destination$iv$iv2;
                            mapper = mapper11111112;
                            responseBody = responseBody2;
                            requestBody4 = requestBody14;
                            page6 = page11;
                            break;
                        }
                        listEmptyList = (List) destination$iv$iv;
                        break;
                    } else {
                        items = jsonNode2.get("items");
                        if (items == null) {
                            jsonNode5 = root.get(str);
                            if (jsonNode5 != null) {
                                jsonNode6 = jsonNode5.get("subjects");
                            } else {
                                jsonNode6 = jsonNode;
                            }
                            if (jsonNode6 == null) {
                                return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                            }
                            items = jsonNode6;
                        }
                        Iterable $this$mapNotNull$iv11111112 = (Iterable) items;
                        destination$iv$iv = new ArrayList();
                        while (r27.hasNext()) {
                            final JsonNode item11111112 = (JsonNode) element$iv$iv$iv;
                            ObjectMapper mapper11111113 = mapper;
                            jsonNode3 = item11111112.get("title");
                            if (jsonNode3 != null) {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                destination$iv$iv2 = destination$iv$iv;
                                destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                destination$iv$iv2 = destination$iv$iv;
                            }
                            destination$iv$iv = destination$iv$iv2;
                            mapper = mapper11111113;
                            responseBody = responseBody2;
                            requestBody4 = requestBody14;
                            page6 = page11;
                            break;
                        }
                        listEmptyList = (List) destination$iv$iv;
                        break;
                    }
                    if (listEmptyList == null) {
                        listEmptyList = CollectionsKt.emptyList();
                    }
                    List data11115 = listEmptyList;
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data11115, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                }
                requestBody10 = requestBody9;
                Requests app11118 = MainActivityKt.getApp();
                c00022.L$0 = request6;
                c00022.L$1 = SpillingKt.nullOutSpilledVariable(jsonBody11);
                c00022.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts7);
                c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId5);
                c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                c00022.L$6 = SpillingKt.nullOutSpilledVariable(genre11);
                c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                c00022.L$8 = SpillingKt.nullOutSpilledVariable(year9);
                c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre10);
                c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort5);
                c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody10);
                c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers5);
                c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody10);
                c00022.L$14 = SpillingKt.nullOutSpilledVariable(response4);
                c00022.I$0 = page7;
                c00022.I$1 = perPage5;
                c00022.I$2 = pg5;
                c00022.label = 8;
                $result3 = Requests.get$default(app11118, jsonBody11, headers5, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                if ($result3 == obj2) {
                    return obj2;
                }
                data5 = data4;
                mainParts8 = mainParts7;
                classify4 = genre11;
                page8 = page7;
                pg6 = pg5;
                perPage6 = perPage5;
                genre12 = genre10;
                year11 = year9;
                response5 = response4;
                requestBody11 = requestBody10;
                request7 = request6;
                country4 = country2;
                niceResponse2 = (NiceResponse) $result3;
                requestBody13 = requestBody11;
                request5 = request7;
                page10 = page8;
                response = niceResponse2;
                requestBody4 = requestBody13;
                page6 = page10;
                responseBody = response.getText();
                mapper = ExtensionsKt.jacksonObjectMapper();
                root = mapper.readTree(responseBody);
                str = str2;
                jsonNode2 = root.get(str);
                if (jsonNode2 == null) {
                    jsonNode5 = root.get(str);
                    if (jsonNode5 != null) {
                        jsonNode6 = jsonNode5.get("subjects");
                    } else {
                        jsonNode6 = jsonNode;
                    }
                    if (jsonNode6 == null) {
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                    }
                    items = jsonNode6;
                    Iterable $this$mapNotNull$iv11111113 = (Iterable) items;
                    destination$iv$iv = new ArrayList();
                    while (r27.hasNext()) {
                        final JsonNode item11111113 = (JsonNode) element$iv$iv$iv;
                        ObjectMapper mapper11111114 = mapper;
                        jsonNode3 = item11111113.get("title");
                        if (jsonNode3 != null) {
                            page11 = page6;
                            responseBody2 = responseBody;
                            requestBody14 = requestBody4;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            page11 = page6;
                            responseBody2 = responseBody;
                            requestBody14 = requestBody4;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        }
                        if (movieSearchResponseNewMovieSearchResponse$default != null) {
                            destination$iv$iv2 = destination$iv$iv;
                            destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                        } else {
                            destination$iv$iv2 = destination$iv$iv;
                        }
                        destination$iv$iv = destination$iv$iv2;
                        mapper = mapper11111114;
                        responseBody = responseBody2;
                        requestBody4 = requestBody14;
                        page6 = page11;
                        break;
                    }
                    listEmptyList = (List) destination$iv$iv;
                    break;
                } else {
                    items = jsonNode2.get("items");
                    if (items == null) {
                        jsonNode5 = root.get(str);
                        if (jsonNode5 != null) {
                            jsonNode6 = jsonNode5.get("subjects");
                        } else {
                            jsonNode6 = jsonNode;
                        }
                        if (jsonNode6 == null) {
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                        }
                        items = jsonNode6;
                    }
                    Iterable $this$mapNotNull$iv11111114 = (Iterable) items;
                    destination$iv$iv = new ArrayList();
                    while (r27.hasNext()) {
                        final JsonNode item11111114 = (JsonNode) element$iv$iv$iv;
                        ObjectMapper mapper11111115 = mapper;
                        jsonNode3 = item11111114.get("title");
                        if (jsonNode3 != null) {
                            page11 = page6;
                            responseBody2 = responseBody;
                            requestBody14 = requestBody4;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            page11 = page6;
                            responseBody2 = responseBody;
                            requestBody14 = requestBody4;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        }
                        if (movieSearchResponseNewMovieSearchResponse$default != null) {
                            destination$iv$iv2 = destination$iv$iv;
                            destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                        } else {
                            destination$iv$iv2 = destination$iv$iv;
                        }
                        destination$iv$iv = destination$iv$iv2;
                        mapper = mapper11111115;
                        responseBody = responseBody2;
                        requestBody4 = requestBody14;
                        page6 = page11;
                        break;
                    }
                    listEmptyList = (List) destination$iv$iv;
                    break;
                }
                if (listEmptyList == null) {
                    listEmptyList = CollectionsKt.emptyList();
                }
                List data11116 = listEmptyList;
                return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data11116, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
            case 5:
                pg4 = c00022.I$2;
                int perPage11 = c00022.I$1;
                int page17 = c00022.I$0;
                response3 = (NiceResponse) c00022.L$14;
                requestBody8 = (RequestBody) c00022.L$13;
                headers4 = (Map) c00022.L$12;
                jsonBody9 = (String) c00022.L$11;
                sort5 = (String) c00022.L$10;
                genre10 = (String) c00022.L$9;
                page5 = page17;
                String year14 = (String) c00022.L$8;
                String country10 = (String) c00022.L$7;
                String classify8 = (String) c00022.L$6;
                Map options9 = (Map) c00022.L$5;
                String channelId9 = (String) c00022.L$4;
                List mainParts13 = (List) c00022.L$3;
                String data20 = (String) c00022.L$2;
                String url11 = (String) c00022.L$1;
                request6 = (MainPageRequest) c00022.L$0;
                ResultKt.throwOnFailure($result3);
                str2 = str2;
                obj2 = coroutine_suspended;
                country2 = country10;
                country3 = classify8;
                options3 = options9;
                channelId4 = channelId9;
                mainParts5 = mainParts13;
                data3 = data20;
                perPage4 = perPage11;
                url5 = url11;
                year8 = year14;
                response4 = response3;
                jsonBody10 = jsonBody9;
                perPage5 = perPage4;
                jsonBody11 = url5;
                url6 = channelId4;
                requestBody9 = requestBody8;
                year9 = year8;
                headers5 = (Map) $result3;
                genre11 = country3;
                year10 = data3;
                pg5 = pg4;
                mainParts6 = mainParts5;
                page7 = page5;
                data4 = year10;
                mainParts7 = mainParts6;
                channelId5 = url6;
                jsonNode = null;
                if (StringsKt.contains$default(request6.getData(), "|", false, 2, (Object) null)) {
                    Requests app11119 = MainActivityKt.getApp();
                    c00022.L$0 = request6;
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(jsonBody11);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts7);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId5);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(genre11);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(year9);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre10);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort5);
                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody10);
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers5);
                    c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody9);
                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(response4);
                    c00022.I$0 = page7;
                    c00022.I$1 = perPage5;
                    c00022.I$2 = pg5;
                    c00022.label = 7;
                    $result3 = Requests.post$default(app11119, jsonBody11, headers5, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody9, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                    requestBody12 = requestBody9;
                    if ($result3 == obj2) {
                        return obj2;
                    }
                    data6 = data4;
                    mainParts9 = mainParts7;
                    classify5 = genre11;
                    page9 = page7;
                    pg6 = pg5;
                    headers6 = headers5;
                    requestBody13 = requestBody12;
                    request8 = request6;
                    country5 = country2;
                    niceResponse2 = (NiceResponse) $result3;
                    request5 = request8;
                    page10 = page9;
                    response = niceResponse2;
                    requestBody4 = requestBody13;
                    page6 = page10;
                    responseBody = response.getText();
                    mapper = ExtensionsKt.jacksonObjectMapper();
                    root = mapper.readTree(responseBody);
                    str = str2;
                    jsonNode2 = root.get(str);
                    if (jsonNode2 == null) {
                        jsonNode5 = root.get(str);
                        if (jsonNode5 != null) {
                            jsonNode6 = jsonNode5.get("subjects");
                        } else {
                            jsonNode6 = jsonNode;
                        }
                        if (jsonNode6 == null) {
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                        }
                        items = jsonNode6;
                        Iterable $this$mapNotNull$iv11111115 = (Iterable) items;
                        destination$iv$iv = new ArrayList();
                        while (r27.hasNext()) {
                            final JsonNode item11111115 = (JsonNode) element$iv$iv$iv;
                            ObjectMapper mapper11111116 = mapper;
                            jsonNode3 = item11111115.get("title");
                            if (jsonNode3 != null) {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                destination$iv$iv2 = destination$iv$iv;
                                destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                destination$iv$iv2 = destination$iv$iv;
                            }
                            destination$iv$iv = destination$iv$iv2;
                            mapper = mapper11111116;
                            responseBody = responseBody2;
                            requestBody4 = requestBody14;
                            page6 = page11;
                            break;
                        }
                        listEmptyList = (List) destination$iv$iv;
                        break;
                    } else {
                        items = jsonNode2.get("items");
                        if (items == null) {
                            jsonNode5 = root.get(str);
                            if (jsonNode5 != null) {
                                jsonNode6 = jsonNode5.get("subjects");
                            } else {
                                jsonNode6 = jsonNode;
                            }
                            if (jsonNode6 == null) {
                                return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                            }
                            items = jsonNode6;
                        }
                        Iterable $this$mapNotNull$iv11111116 = (Iterable) items;
                        destination$iv$iv = new ArrayList();
                        while (r27.hasNext()) {
                            final JsonNode item11111116 = (JsonNode) element$iv$iv$iv;
                            ObjectMapper mapper11111117 = mapper;
                            jsonNode3 = item11111116.get("title");
                            if (jsonNode3 != null) {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                destination$iv$iv2 = destination$iv$iv;
                                destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                destination$iv$iv2 = destination$iv$iv;
                            }
                            destination$iv$iv = destination$iv$iv2;
                            mapper = mapper11111117;
                            responseBody = responseBody2;
                            requestBody4 = requestBody14;
                            page6 = page11;
                            break;
                        }
                        listEmptyList = (List) destination$iv$iv;
                        break;
                    }
                    if (listEmptyList == null) {
                        listEmptyList = CollectionsKt.emptyList();
                    }
                    List data11117 = listEmptyList;
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data11117, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                }
                requestBody10 = requestBody9;
                Requests app111110 = MainActivityKt.getApp();
                c00022.L$0 = request6;
                c00022.L$1 = SpillingKt.nullOutSpilledVariable(jsonBody11);
                c00022.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts7);
                c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId5);
                c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                c00022.L$6 = SpillingKt.nullOutSpilledVariable(genre11);
                c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                c00022.L$8 = SpillingKt.nullOutSpilledVariable(year9);
                c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre10);
                c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort5);
                c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody10);
                c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers5);
                c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody10);
                c00022.L$14 = SpillingKt.nullOutSpilledVariable(response4);
                c00022.I$0 = page7;
                c00022.I$1 = perPage5;
                c00022.I$2 = pg5;
                c00022.label = 8;
                $result3 = Requests.get$default(app111110, jsonBody11, headers5, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                if ($result3 == obj2) {
                    return obj2;
                }
                data5 = data4;
                mainParts8 = mainParts7;
                classify4 = genre11;
                page8 = page7;
                pg6 = pg5;
                perPage6 = perPage5;
                genre12 = genre10;
                year11 = year9;
                response5 = response4;
                requestBody11 = requestBody10;
                request7 = request6;
                country4 = country2;
                niceResponse2 = (NiceResponse) $result3;
                requestBody13 = requestBody11;
                request5 = request7;
                page10 = page8;
                response = niceResponse2;
                requestBody4 = requestBody13;
                page6 = page10;
                responseBody = response.getText();
                mapper = ExtensionsKt.jacksonObjectMapper();
                root = mapper.readTree(responseBody);
                str = str2;
                jsonNode2 = root.get(str);
                if (jsonNode2 == null) {
                    jsonNode5 = root.get(str);
                    if (jsonNode5 != null) {
                        jsonNode6 = jsonNode5.get("subjects");
                    } else {
                        jsonNode6 = jsonNode;
                    }
                    if (jsonNode6 == null) {
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                    }
                    items = jsonNode6;
                    Iterable $this$mapNotNull$iv11111117 = (Iterable) items;
                    destination$iv$iv = new ArrayList();
                    while (r27.hasNext()) {
                        final JsonNode item11111117 = (JsonNode) element$iv$iv$iv;
                        ObjectMapper mapper11111118 = mapper;
                        jsonNode3 = item11111117.get("title");
                        if (jsonNode3 != null) {
                            page11 = page6;
                            responseBody2 = responseBody;
                            requestBody14 = requestBody4;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            page11 = page6;
                            responseBody2 = responseBody;
                            requestBody14 = requestBody4;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        }
                        if (movieSearchResponseNewMovieSearchResponse$default != null) {
                            destination$iv$iv2 = destination$iv$iv;
                            destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                        } else {
                            destination$iv$iv2 = destination$iv$iv;
                        }
                        destination$iv$iv = destination$iv$iv2;
                        mapper = mapper11111118;
                        responseBody = responseBody2;
                        requestBody4 = requestBody14;
                        page6 = page11;
                        break;
                    }
                    listEmptyList = (List) destination$iv$iv;
                    break;
                } else {
                    items = jsonNode2.get("items");
                    if (items == null) {
                        jsonNode5 = root.get(str);
                        if (jsonNode5 != null) {
                            jsonNode6 = jsonNode5.get("subjects");
                        } else {
                            jsonNode6 = jsonNode;
                        }
                        if (jsonNode6 == null) {
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                        }
                        items = jsonNode6;
                    }
                    Iterable $this$mapNotNull$iv11111118 = (Iterable) items;
                    destination$iv$iv = new ArrayList();
                    while (r27.hasNext()) {
                        final JsonNode item11111118 = (JsonNode) element$iv$iv$iv;
                        ObjectMapper mapper11111119 = mapper;
                        jsonNode3 = item11111118.get("title");
                        if (jsonNode3 != null) {
                            page11 = page6;
                            responseBody2 = responseBody;
                            requestBody14 = requestBody4;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            page11 = page6;
                            responseBody2 = responseBody;
                            requestBody14 = requestBody4;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        }
                        if (movieSearchResponseNewMovieSearchResponse$default != null) {
                            destination$iv$iv2 = destination$iv$iv;
                            destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                        } else {
                            destination$iv$iv2 = destination$iv$iv;
                        }
                        destination$iv$iv = destination$iv$iv2;
                        mapper = mapper11111119;
                        responseBody = responseBody2;
                        requestBody4 = requestBody14;
                        page6 = page11;
                        break;
                    }
                    listEmptyList = (List) destination$iv$iv;
                    break;
                }
                if (listEmptyList == null) {
                    listEmptyList = CollectionsKt.emptyList();
                }
                List data11118 = listEmptyList;
                return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data11118, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
            case 6:
                pg3 = c00022.I$2;
                int perPage12 = c00022.I$1;
                int page18 = c00022.I$0;
                response2 = (NiceResponse) c00022.L$14;
                requestBody6 = (RequestBody) c00022.L$13;
                headers3 = (Map) c00022.L$12;
                jsonBody7 = (String) c00022.L$11;
                sort4 = (String) c00022.L$10;
                genre9 = (String) c00022.L$9;
                page4 = page18;
                String year15 = (String) c00022.L$8;
                String country11 = (String) c00022.L$7;
                String classify9 = (String) c00022.L$6;
                Map options10 = (Map) c00022.L$5;
                String channelId10 = (String) c00022.L$4;
                List mainParts14 = (List) c00022.L$3;
                String data21 = (String) c00022.L$2;
                String url12 = (String) c00022.L$1;
                request6 = (MainPageRequest) c00022.L$0;
                ResultKt.throwOnFailure($result3);
                str2 = str2;
                obj2 = coroutine_suspended;
                country2 = country11;
                country3 = classify9;
                options3 = options10;
                channelId4 = channelId10;
                mainParts5 = mainParts14;
                data3 = data21;
                perPage4 = perPage12;
                url4 = url12;
                year6 = year15;
                response4 = response2;
                jsonBody10 = jsonBody7;
                sort5 = sort4;
                perPage5 = perPage4;
                jsonBody11 = url4;
                genre10 = genre9;
                url6 = channelId4;
                requestBody9 = requestBody6;
                year9 = year6;
                headers5 = (Map) $result3;
                page7 = page4;
                year10 = data3;
                genre11 = country3;
                pg5 = pg3;
                mainParts6 = mainParts5;
                data4 = year10;
                mainParts7 = mainParts6;
                channelId5 = url6;
                jsonNode = null;
                if (StringsKt.contains$default(request6.getData(), "|", false, 2, (Object) null)) {
                    Requests app111111 = MainActivityKt.getApp();
                    c00022.L$0 = request6;
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(jsonBody11);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts7);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId5);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(genre11);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(year9);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre10);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort5);
                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody10);
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers5);
                    c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody9);
                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(response4);
                    c00022.I$0 = page7;
                    c00022.I$1 = perPage5;
                    c00022.I$2 = pg5;
                    c00022.label = 7;
                    $result3 = Requests.post$default(app111111, jsonBody11, headers5, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody9, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                    requestBody12 = requestBody9;
                    if ($result3 == obj2) {
                        return obj2;
                    }
                    data6 = data4;
                    mainParts9 = mainParts7;
                    classify5 = genre11;
                    page9 = page7;
                    pg6 = pg5;
                    headers6 = headers5;
                    requestBody13 = requestBody12;
                    request8 = request6;
                    country5 = country2;
                    niceResponse2 = (NiceResponse) $result3;
                    request5 = request8;
                    page10 = page9;
                    response = niceResponse2;
                    requestBody4 = requestBody13;
                    page6 = page10;
                    responseBody = response.getText();
                    mapper = ExtensionsKt.jacksonObjectMapper();
                    root = mapper.readTree(responseBody);
                    str = str2;
                    jsonNode2 = root.get(str);
                    if (jsonNode2 == null) {
                        jsonNode5 = root.get(str);
                        if (jsonNode5 != null) {
                            jsonNode6 = jsonNode5.get("subjects");
                        } else {
                            jsonNode6 = jsonNode;
                        }
                        if (jsonNode6 == null) {
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                        }
                        items = jsonNode6;
                        Iterable $this$mapNotNull$iv11111119 = (Iterable) items;
                        destination$iv$iv = new ArrayList();
                        while (r27.hasNext()) {
                            final JsonNode item11111119 = (JsonNode) element$iv$iv$iv;
                            ObjectMapper mapper111111110 = mapper;
                            jsonNode3 = item11111119.get("title");
                            if (jsonNode3 != null) {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                destination$iv$iv2 = destination$iv$iv;
                                destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                destination$iv$iv2 = destination$iv$iv;
                            }
                            destination$iv$iv = destination$iv$iv2;
                            mapper = mapper111111110;
                            responseBody = responseBody2;
                            requestBody4 = requestBody14;
                            page6 = page11;
                            break;
                        }
                        listEmptyList = (List) destination$iv$iv;
                        break;
                    } else {
                        items = jsonNode2.get("items");
                        if (items == null) {
                            jsonNode5 = root.get(str);
                            if (jsonNode5 != null) {
                                jsonNode6 = jsonNode5.get("subjects");
                            } else {
                                jsonNode6 = jsonNode;
                            }
                            if (jsonNode6 == null) {
                                return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                            }
                            items = jsonNode6;
                        }
                        Iterable $this$mapNotNull$iv111111110 = (Iterable) items;
                        destination$iv$iv = new ArrayList();
                        while (r27.hasNext()) {
                            final JsonNode item111111110 = (JsonNode) element$iv$iv$iv;
                            ObjectMapper mapper111111111 = mapper;
                            jsonNode3 = item111111110.get("title");
                            if (jsonNode3 != null) {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                page11 = page6;
                                responseBody2 = responseBody;
                                requestBody14 = requestBody4;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                destination$iv$iv2 = destination$iv$iv;
                                destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                destination$iv$iv2 = destination$iv$iv;
                            }
                            destination$iv$iv = destination$iv$iv2;
                            mapper = mapper111111111;
                            responseBody = responseBody2;
                            requestBody4 = requestBody14;
                            page6 = page11;
                            break;
                        }
                        listEmptyList = (List) destination$iv$iv;
                        break;
                    }
                    if (listEmptyList == null) {
                        listEmptyList = CollectionsKt.emptyList();
                    }
                    List data11119 = listEmptyList;
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data11119, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                }
                requestBody10 = requestBody9;
                Requests app111112 = MainActivityKt.getApp();
                c00022.L$0 = request6;
                c00022.L$1 = SpillingKt.nullOutSpilledVariable(jsonBody11);
                c00022.L$2 = SpillingKt.nullOutSpilledVariable(data4);
                c00022.L$3 = SpillingKt.nullOutSpilledVariable(mainParts7);
                c00022.L$4 = SpillingKt.nullOutSpilledVariable(channelId5);
                c00022.L$5 = SpillingKt.nullOutSpilledVariable(options3);
                c00022.L$6 = SpillingKt.nullOutSpilledVariable(genre11);
                c00022.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                c00022.L$8 = SpillingKt.nullOutSpilledVariable(year9);
                c00022.L$9 = SpillingKt.nullOutSpilledVariable(genre10);
                c00022.L$10 = SpillingKt.nullOutSpilledVariable(sort5);
                c00022.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody10);
                c00022.L$12 = SpillingKt.nullOutSpilledVariable(headers5);
                c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody10);
                c00022.L$14 = SpillingKt.nullOutSpilledVariable(response4);
                c00022.I$0 = page7;
                c00022.I$1 = perPage5;
                c00022.I$2 = pg5;
                c00022.label = 8;
                $result3 = Requests.get$default(app111112, jsonBody11, headers5, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                if ($result3 == obj2) {
                    return obj2;
                }
                data5 = data4;
                mainParts8 = mainParts7;
                classify4 = genre11;
                page8 = page7;
                pg6 = pg5;
                perPage6 = perPage5;
                genre12 = genre10;
                year11 = year9;
                response5 = response4;
                requestBody11 = requestBody10;
                request7 = request6;
                country4 = country2;
                niceResponse2 = (NiceResponse) $result3;
                requestBody13 = requestBody11;
                request5 = request7;
                page10 = page8;
                response = niceResponse2;
                requestBody4 = requestBody13;
                page6 = page10;
                responseBody = response.getText();
                mapper = ExtensionsKt.jacksonObjectMapper();
                root = mapper.readTree(responseBody);
                str = str2;
                jsonNode2 = root.get(str);
                if (jsonNode2 == null) {
                    jsonNode5 = root.get(str);
                    if (jsonNode5 != null) {
                        jsonNode6 = jsonNode5.get("subjects");
                    } else {
                        jsonNode6 = jsonNode;
                    }
                    if (jsonNode6 == null) {
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                    }
                    items = jsonNode6;
                    Iterable $this$mapNotNull$iv111111111 = (Iterable) items;
                    destination$iv$iv = new ArrayList();
                    while (r27.hasNext()) {
                        final JsonNode item111111111 = (JsonNode) element$iv$iv$iv;
                        ObjectMapper mapper111111112 = mapper;
                        jsonNode3 = item111111111.get("title");
                        if (jsonNode3 != null) {
                            page11 = page6;
                            responseBody2 = responseBody;
                            requestBody14 = requestBody4;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            page11 = page6;
                            responseBody2 = responseBody;
                            requestBody14 = requestBody4;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        }
                        if (movieSearchResponseNewMovieSearchResponse$default != null) {
                            destination$iv$iv2 = destination$iv$iv;
                            destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                        } else {
                            destination$iv$iv2 = destination$iv$iv;
                        }
                        destination$iv$iv = destination$iv$iv2;
                        mapper = mapper111111112;
                        responseBody = responseBody2;
                        requestBody4 = requestBody14;
                        page6 = page11;
                        break;
                    }
                    listEmptyList = (List) destination$iv$iv;
                    break;
                } else {
                    items = jsonNode2.get("items");
                    if (items == null) {
                        jsonNode5 = root.get(str);
                        if (jsonNode5 != null) {
                            jsonNode6 = jsonNode5.get("subjects");
                        } else {
                            jsonNode6 = jsonNode;
                        }
                        if (jsonNode6 == null) {
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                        }
                        items = jsonNode6;
                    }
                    Iterable $this$mapNotNull$iv111111112 = (Iterable) items;
                    destination$iv$iv = new ArrayList();
                    while (r27.hasNext()) {
                        final JsonNode item111111112 = (JsonNode) element$iv$iv$iv;
                        ObjectMapper mapper111111113 = mapper;
                        jsonNode3 = item111111112.get("title");
                        if (jsonNode3 != null) {
                            page11 = page6;
                            responseBody2 = responseBody;
                            requestBody14 = requestBody4;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            page11 = page6;
                            responseBody2 = responseBody;
                            requestBody14 = requestBody4;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        }
                        if (movieSearchResponseNewMovieSearchResponse$default != null) {
                            destination$iv$iv2 = destination$iv$iv;
                            destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                        } else {
                            destination$iv$iv2 = destination$iv$iv;
                        }
                        destination$iv$iv = destination$iv$iv2;
                        mapper = mapper111111113;
                        responseBody = responseBody2;
                        requestBody4 = requestBody14;
                        page6 = page11;
                        break;
                    }
                    listEmptyList = (List) destination$iv$iv;
                    break;
                }
                if (listEmptyList == null) {
                    listEmptyList = CollectionsKt.emptyList();
                }
                List data111110 = listEmptyList;
                return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data111110, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
            case 7:
                pg6 = c00022.I$2;
                int perPage13 = c00022.I$1;
                int page19 = c00022.I$0;
                requestBody13 = (RequestBody) c00022.L$13;
                headers6 = (Map) c00022.L$12;
                String jsonBody13 = (String) c00022.L$11;
                sort5 = (String) c00022.L$10;
                genre10 = (String) c00022.L$9;
                String year16 = (String) c00022.L$8;
                page9 = page19;
                String country12 = (String) c00022.L$7;
                classify5 = (String) c00022.L$6;
                String channelId11 = (String) c00022.L$4;
                mainParts9 = (List) c00022.L$3;
                data6 = (String) c00022.L$2;
                String url13 = (String) c00022.L$1;
                MainPageRequest request14 = (MainPageRequest) c00022.L$0;
                ResultKt.throwOnFailure($result3);
                request8 = request14;
                jsonBody10 = jsonBody13;
                str2 = str2;
                year9 = year16;
                channelId5 = channelId11;
                jsonBody11 = url13;
                country5 = country12;
                perPage5 = perPage13;
                jsonNode = null;
                niceResponse2 = (NiceResponse) $result3;
                request5 = request8;
                page10 = page9;
                response = niceResponse2;
                requestBody4 = requestBody13;
                page6 = page10;
                responseBody = response.getText();
                mapper = ExtensionsKt.jacksonObjectMapper();
                root = mapper.readTree(responseBody);
                str = str2;
                jsonNode2 = root.get(str);
                if (jsonNode2 == null) {
                    jsonNode5 = root.get(str);
                    if (jsonNode5 != null) {
                        jsonNode6 = jsonNode5.get("subjects");
                    } else {
                        jsonNode6 = jsonNode;
                    }
                    if (jsonNode6 == null) {
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                    }
                    items = jsonNode6;
                    Iterable $this$mapNotNull$iv111111113 = (Iterable) items;
                    destination$iv$iv = new ArrayList();
                    while (r27.hasNext()) {
                        final JsonNode item111111113 = (JsonNode) element$iv$iv$iv;
                        ObjectMapper mapper111111114 = mapper;
                        jsonNode3 = item111111113.get("title");
                        if (jsonNode3 != null) {
                            page11 = page6;
                            responseBody2 = responseBody;
                            requestBody14 = requestBody4;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            page11 = page6;
                            responseBody2 = responseBody;
                            requestBody14 = requestBody4;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        }
                        if (movieSearchResponseNewMovieSearchResponse$default != null) {
                            destination$iv$iv2 = destination$iv$iv;
                            destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                        } else {
                            destination$iv$iv2 = destination$iv$iv;
                        }
                        destination$iv$iv = destination$iv$iv2;
                        mapper = mapper111111114;
                        responseBody = responseBody2;
                        requestBody4 = requestBody14;
                        page6 = page11;
                        break;
                    }
                    listEmptyList = (List) destination$iv$iv;
                    break;
                } else {
                    items = jsonNode2.get("items");
                    if (items == null) {
                        jsonNode5 = root.get(str);
                        if (jsonNode5 != null) {
                            jsonNode6 = jsonNode5.get("subjects");
                        } else {
                            jsonNode6 = jsonNode;
                        }
                        if (jsonNode6 == null) {
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                        }
                        items = jsonNode6;
                    }
                    Iterable $this$mapNotNull$iv111111114 = (Iterable) items;
                    destination$iv$iv = new ArrayList();
                    while (r27.hasNext()) {
                        final JsonNode item111111114 = (JsonNode) element$iv$iv$iv;
                        ObjectMapper mapper111111115 = mapper;
                        jsonNode3 = item111111114.get("title");
                        if (jsonNode3 != null) {
                            page11 = page6;
                            responseBody2 = responseBody;
                            requestBody14 = requestBody4;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            page11 = page6;
                            responseBody2 = responseBody;
                            requestBody14 = requestBody4;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        }
                        if (movieSearchResponseNewMovieSearchResponse$default != null) {
                            destination$iv$iv2 = destination$iv$iv;
                            destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                        } else {
                            destination$iv$iv2 = destination$iv$iv;
                        }
                        destination$iv$iv = destination$iv$iv2;
                        mapper = mapper111111115;
                        responseBody = responseBody2;
                        requestBody4 = requestBody14;
                        page6 = page11;
                        break;
                    }
                    listEmptyList = (List) destination$iv$iv;
                    break;
                }
                if (listEmptyList == null) {
                    listEmptyList = CollectionsKt.emptyList();
                }
                List data111111 = listEmptyList;
                return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data111111, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
            case 8:
                pg6 = c00022.I$2;
                perPage6 = c00022.I$1;
                int page20 = c00022.I$0;
                response5 = (NiceResponse) c00022.L$14;
                RequestBody requestBody17 = (RequestBody) c00022.L$13;
                Map headers9 = (Map) c00022.L$12;
                String jsonBody14 = (String) c00022.L$11;
                String sort11 = (String) c00022.L$10;
                genre12 = (String) c00022.L$9;
                year11 = (String) c00022.L$8;
                page8 = page20;
                String country13 = (String) c00022.L$7;
                classify4 = (String) c00022.L$6;
                String channelId12 = (String) c00022.L$4;
                mainParts8 = (List) c00022.L$3;
                data5 = (String) c00022.L$2;
                String url14 = (String) c00022.L$1;
                MainPageRequest request15 = (MainPageRequest) c00022.L$0;
                ResultKt.throwOnFailure($result3);
                request7 = request15;
                headers5 = headers9;
                str2 = str2;
                jsonBody10 = jsonBody14;
                channelId5 = channelId12;
                jsonBody11 = url14;
                country4 = country13;
                requestBody11 = requestBody17;
                sort5 = sort11;
                jsonNode = null;
                niceResponse2 = (NiceResponse) $result3;
                requestBody13 = requestBody11;
                request5 = request7;
                page10 = page8;
                response = niceResponse2;
                requestBody4 = requestBody13;
                page6 = page10;
                responseBody = response.getText();
                mapper = ExtensionsKt.jacksonObjectMapper();
                root = mapper.readTree(responseBody);
                str = str2;
                jsonNode2 = root.get(str);
                if (jsonNode2 == null) {
                    jsonNode5 = root.get(str);
                    if (jsonNode5 != null) {
                        jsonNode6 = jsonNode5.get("subjects");
                    } else {
                        jsonNode6 = jsonNode;
                    }
                    if (jsonNode6 == null) {
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                    }
                    items = jsonNode6;
                    Iterable $this$mapNotNull$iv111111115 = (Iterable) items;
                    destination$iv$iv = new ArrayList();
                    while (r27.hasNext()) {
                        final JsonNode item111111115 = (JsonNode) element$iv$iv$iv;
                        ObjectMapper mapper111111116 = mapper;
                        jsonNode3 = item111111115.get("title");
                        if (jsonNode3 != null) {
                            page11 = page6;
                            responseBody2 = responseBody;
                            requestBody14 = requestBody4;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            page11 = page6;
                            responseBody2 = responseBody;
                            requestBody14 = requestBody4;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        }
                        if (movieSearchResponseNewMovieSearchResponse$default != null) {
                            destination$iv$iv2 = destination$iv$iv;
                            destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                        } else {
                            destination$iv$iv2 = destination$iv$iv;
                        }
                        destination$iv$iv = destination$iv$iv2;
                        mapper = mapper111111116;
                        responseBody = responseBody2;
                        requestBody4 = requestBody14;
                        page6 = page11;
                        break;
                    }
                    listEmptyList = (List) destination$iv$iv;
                    break;
                } else {
                    items = jsonNode2.get("items");
                    if (items == null) {
                        jsonNode5 = root.get(str);
                        if (jsonNode5 != null) {
                            jsonNode6 = jsonNode5.get("subjects");
                        } else {
                            jsonNode6 = jsonNode;
                        }
                        if (jsonNode6 == null) {
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode, 2, jsonNode);
                        }
                        items = jsonNode6;
                    }
                    Iterable $this$mapNotNull$iv111111116 = (Iterable) items;
                    destination$iv$iv = new ArrayList();
                    while (r27.hasNext()) {
                        final JsonNode item111111116 = (JsonNode) element$iv$iv$iv;
                        ObjectMapper mapper111111117 = mapper;
                        jsonNode3 = item111111116.get("title");
                        if (jsonNode3 != null) {
                            page11 = page6;
                            responseBody2 = responseBody;
                            requestBody14 = requestBody4;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            page11 = page6;
                            responseBody2 = responseBody;
                            requestBody14 = requestBody4;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        }
                        if (movieSearchResponseNewMovieSearchResponse$default != null) {
                            destination$iv$iv2 = destination$iv$iv;
                            destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                        } else {
                            destination$iv$iv2 = destination$iv$iv;
                        }
                        destination$iv$iv = destination$iv$iv2;
                        mapper = mapper111111117;
                        responseBody = responseBody2;
                        requestBody4 = requestBody14;
                        page6 = page11;
                        break;
                    }
                    listEmptyList = (List) destination$iv$iv;
                    break;
                }
                if (listEmptyList == null) {
                    listEmptyList = CollectionsKt.emptyList();
                }
                List data111112 = listEmptyList;
                return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data111112, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMainPage$lambda$1$0(String $coverImg, JsonNode $item, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($coverImg);
        Score.Companion companion = Score.Companion;
        JsonNode jsonNode = $item.get("imdbRatingValue");
        $this$newMovieSearchResponse.setScore(companion.from10(jsonNode != null ? jsonNode.asText() : null));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0184 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:23:0x0185  */
    /* JADX WARN: Code duplicated, block: B:26:0x0199  */
    /* JADX WARN: Code duplicated, block: B:30:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:37:0x01f4 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:38:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:41:0x0256 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:42:0x0257  */
    /* JADX WARN: Code duplicated, block: B:46:0x0286  */
    /* JADX WARN: Code duplicated, block: B:77:0x0314  */
    /* JADX WARN: Code duplicated, block: B:78:0x0319  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:80:0x031d  */
    /* JADX WARN: Code duplicated, block: B:81:0x0322  */
    /* JADX WARN: Code duplicated, block: B:82:0x0327  */
    /* JADX WARN: Code duplicated, block: B:91:0x0377 A[ADDED_TO_REGION, REMOVE] */
    @Nullable
    public Object search(@NotNull String query, int page, @NotNull Continuation<? super SearchResponseList> continuation) {
        C00081 c00081;
        String query2;
        String jsonBody;
        RequestBody requestBody;
        String jsonBody2;
        Object obj;
        int page2;
        Map headers;
        RequestBody requestBody2;
        Object obj2;
        String url;
        Object objPost$default;
        int page3;
        Object obj3;
        String jsonBody3;
        String query3;
        String query4;
        RequestBody requestBody3;
        NiceResponse response;
        SharedPreferences sharedPreferences;
        String url2;
        Object obj4;
        Object objBuildAuthHeaders$default;
        int page4;
        String jsonBody4;
        RequestBody requestBody4;
        String query5;
        NiceResponse response2;
        String url3;
        SharedPreferences.Editor editorEdit;
        SharedPreferences.Editor editorRemove;
        Map headers2;
        String url4;
        Map headers3;
        RequestBody requestBody5;
        JsonNode jsonNode;
        Boolean bool;
        JsonNode<JsonNode> results;
        String title;
        String id;
        ObjectMapper mapper;
        JsonNode jsonNode2;
        int subjectType;
        TvType tvType;
        if (continuation instanceof C00081) {
            c00081 = (C00081) continuation;
            if ((c00081.label & Integer.MIN_VALUE) != 0) {
                c00081.label -= Integer.MIN_VALUE;
            } else {
                c00081 = new C00081(continuation);
            }
        } else {
            c00081 = new C00081(continuation);
        }
        C00081 c00082 = c00081;
        Object $result = c00082.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00082.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String url5 = getMainUrl() + "/wefeed-mobile-bff/subject-api/search/v2";
                String jsonBody5 = "{\"page\": " + page + ", \"perPage\": 20, \"keyword\": \"" + query + "\"}";
                RequestBody requestBody6 = RequestBody.Companion.create(jsonBody5, MediaType.Companion.get("application/json"));
                c00082.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00082.L$1 = url5;
                c00082.L$2 = jsonBody5;
                c00082.L$3 = requestBody6;
                c00082.I$0 = page;
                c00082.label = 1;
                Object objBuildAuthHeaders$default2 = buildAuthHeaders$default(this, "POST", url5, "application/json; charset=utf-8", null, jsonBody5, false, c00082, 40, null);
                if (objBuildAuthHeaders$default2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                query2 = query;
                jsonBody = jsonBody5;
                requestBody = requestBody6;
                jsonBody2 = url5;
                obj = objBuildAuthHeaders$default2;
                page2 = page;
                Map headers4 = (Map) obj;
                Requests app = MainActivityKt.getApp();
                c00082.L$0 = SpillingKt.nullOutSpilledVariable(query2);
                c00082.L$1 = jsonBody2;
                c00082.L$2 = jsonBody;
                c00082.L$3 = requestBody;
                c00082.L$4 = SpillingKt.nullOutSpilledVariable(headers4);
                c00082.I$0 = page2;
                c00082.label = 2;
                headers = headers4;
                requestBody2 = requestBody;
                obj2 = coroutine_suspended;
                url = jsonBody2;
                objPost$default = Requests.post$default(app, url, headers, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody2, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00082, 65276, (Object) null);
                if (objPost$default == obj2) {
                    return obj2;
                }
                page3 = page2;
                obj3 = objPost$default;
                jsonBody3 = jsonBody;
                query3 = query2;
                query4 = url;
                requestBody3 = requestBody2;
                response = (NiceResponse) obj3;
                if (response.getCode() != 401 || response.getCode() == 441) {
                    bearerToken = null;
                    sharedPreferences = this.sharedPref;
                    if (sharedPreferences != null && (editorEdit = sharedPreferences.edit()) != null && (editorRemove = editorEdit.remove(this.PREF_TOKEN_KEY)) != null) {
                        editorRemove.apply();
                    }
                    c00082.L$0 = SpillingKt.nullOutSpilledVariable(query3);
                    c00082.L$1 = query4;
                    c00082.L$2 = SpillingKt.nullOutSpilledVariable(jsonBody3);
                    c00082.L$3 = requestBody3;
                    c00082.L$4 = SpillingKt.nullOutSpilledVariable(headers);
                    c00082.L$5 = SpillingKt.nullOutSpilledVariable(response);
                    c00082.I$0 = page3;
                    c00082.label = 3;
                    Object obj5 = obj2;
                    url2 = query4;
                    obj4 = obj5;
                    objBuildAuthHeaders$default = buildAuthHeaders$default(this, "POST", url2, "application/json; charset=utf-8", null, jsonBody3, false, c00082, 40, null);
                    if (objBuildAuthHeaders$default == obj4) {
                        return obj4;
                    }
                    int i = page3;
                    $result = objBuildAuthHeaders$default;
                    page4 = i;
                    jsonBody4 = jsonBody3;
                    requestBody4 = requestBody3;
                    query5 = query3;
                    response2 = response;
                    url3 = url2;
                    headers2 = (Map) $result;
                    Requests app2 = MainActivityKt.getApp();
                    c00082.L$0 = SpillingKt.nullOutSpilledVariable(query5);
                    c00082.L$1 = SpillingKt.nullOutSpilledVariable(url3);
                    c00082.L$2 = SpillingKt.nullOutSpilledVariable(jsonBody4);
                    c00082.L$3 = SpillingKt.nullOutSpilledVariable(requestBody4);
                    c00082.L$4 = SpillingKt.nullOutSpilledVariable(headers2);
                    c00082.L$5 = SpillingKt.nullOutSpilledVariable(response2);
                    c00082.I$0 = page4;
                    c00082.label = 4;
                    $result = Requests.post$default(app2, url3, headers2, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody4, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00082, 65276, (Object) null);
                    if ($result == obj4) {
                        return obj4;
                    }
                    url4 = url3;
                    headers3 = headers2;
                    requestBody5 = requestBody4;
                    response = (NiceResponse) $result;
                }
                persistTokenFromXUser(response.getHeaders().get("x-user"));
                String responseBody = response.getText();
                ObjectMapper mapper2 = ExtensionsKt.jacksonObjectMapper();
                JsonNode root = mapper2.readTree(responseBody);
                jsonNode = root.get("data");
                if (jsonNode != null || (results = jsonNode.get("results")) == null) {
                    bool = null;
                    return MainAPIKt.newSearchResponseList$default(CollectionsKt.emptyList(), bool, 2, bool);
                }
                List searchList = new ArrayList();
                for (JsonNode result : results) {
                    JsonNode<JsonNode> subjects = result.get("subjects");
                    if (subjects != null) {
                        for (final JsonNode subject : subjects) {
                            subjects = subjects;
                            responseBody = responseBody;
                            JsonNode jsonNode3 = subject.get("title");
                            if (jsonNode3 == null || (title = jsonNode3.asText()) == null) {
                                mapper2 = mapper2;
                            } else {
                                JsonNode jsonNode4 = subject.get("subjectId");
                                if (jsonNode4 == null || (id = jsonNode4.asText()) == null) {
                                    mapper2 = mapper2;
                                } else {
                                    JsonNode jsonNode5 = subject.get("cover");
                                    if (jsonNode5 != null) {
                                        mapper = mapper2;
                                        JsonNode jsonNode6 = jsonNode5.get("url");
                                        final String coverImg = jsonNode6 != null ? jsonNode6.asText() : null;
                                        jsonNode2 = subject.get("subjectType");
                                        if (jsonNode2 != null) {
                                            subjectType = jsonNode2.asInt();
                                        } else {
                                            subjectType = 1;
                                        }
                                        switch (subjectType) {
                                            case 1:
                                                tvType = TvType.Movie;
                                                break;
                                            case 2:
                                                tvType = TvType.TvSeries;
                                                break;
                                            default:
                                                tvType = TvType.Movie;
                                                break;
                                        }
                                        TvType type = tvType;
                                        searchList.add(MainAPIKt.newMovieSearchResponse$default(this, title, id, type, false, new Function1() { // from class: com.MovieBox.MovieBoxProvider$$ExternalSyntheticLambda0
                                            public final Object invoke(Object obj6) {
                                                return MovieBoxProvider.search$lambda$0(coverImg, subject, (MovieSearchResponse) obj6);
                                            }
                                        }, 8, (Object) null));
                                        mapper2 = mapper;
                                    } else {
                                        mapper = mapper2;
                                    }
                                    jsonNode2 = subject.get("subjectType");
                                    if (jsonNode2 != null) {
                                        subjectType = jsonNode2.asInt();
                                    } else {
                                        subjectType = 1;
                                    }
                                    switch (subjectType) {
                                        case 1:
                                            tvType = TvType.Movie;
                                            break;
                                        case 2:
                                            tvType = TvType.TvSeries;
                                            break;
                                        default:
                                            tvType = TvType.Movie;
                                            break;
                                    }
                                    TvType type2 = tvType;
                                    searchList.add(MainAPIKt.newMovieSearchResponse$default(this, title, id, type2, false, new Function1() { // from class: com.MovieBox.MovieBoxProvider$$ExternalSyntheticLambda0
                                        public final Object invoke(Object obj6) {
                                            return MovieBoxProvider.search$lambda$0(coverImg, subject, (MovieSearchResponse) obj6);
                                        }
                                    }, 8, (Object) null));
                                    mapper2 = mapper;
                                }
                            }
                        }
                    }
                }
                return MainAPIKt.toNewSearchResponseList$default(searchList, (Boolean) null, 1, (Object) null);
            case 1:
                page2 = c00082.I$0;
                requestBody = (RequestBody) c00082.L$3;
                jsonBody = (String) c00082.L$2;
                jsonBody2 = (String) c00082.L$1;
                query2 = (String) c00082.L$0;
                ResultKt.throwOnFailure($result);
                obj = $result;
                Map headers5 = (Map) obj;
                Requests app3 = MainActivityKt.getApp();
                c00082.L$0 = SpillingKt.nullOutSpilledVariable(query2);
                c00082.L$1 = jsonBody2;
                c00082.L$2 = jsonBody;
                c00082.L$3 = requestBody;
                c00082.L$4 = SpillingKt.nullOutSpilledVariable(headers5);
                c00082.I$0 = page2;
                c00082.label = 2;
                headers = headers5;
                requestBody2 = requestBody;
                obj2 = coroutine_suspended;
                url = jsonBody2;
                objPost$default = Requests.post$default(app3, url, headers, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody2, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00082, 65276, (Object) null);
                if (objPost$default == obj2) {
                    return obj2;
                }
                page3 = page2;
                obj3 = objPost$default;
                jsonBody3 = jsonBody;
                query3 = query2;
                query4 = url;
                requestBody3 = requestBody2;
                response = (NiceResponse) obj3;
                if (response.getCode() != 401) {
                    break;
                }
                bearerToken = null;
                sharedPreferences = this.sharedPref;
                if (sharedPreferences != null) {
                    editorRemove.apply();
                }
                c00082.L$0 = SpillingKt.nullOutSpilledVariable(query3);
                c00082.L$1 = query4;
                c00082.L$2 = SpillingKt.nullOutSpilledVariable(jsonBody3);
                c00082.L$3 = requestBody3;
                c00082.L$4 = SpillingKt.nullOutSpilledVariable(headers);
                c00082.L$5 = SpillingKt.nullOutSpilledVariable(response);
                c00082.I$0 = page3;
                c00082.label = 3;
                Object obj6 = obj2;
                url2 = query4;
                obj4 = obj6;
                objBuildAuthHeaders$default = buildAuthHeaders$default(this, "POST", url2, "application/json; charset=utf-8", null, jsonBody3, false, c00082, 40, null);
                if (objBuildAuthHeaders$default == obj4) {
                    return obj4;
                }
                int i2 = page3;
                $result = objBuildAuthHeaders$default;
                page4 = i2;
                jsonBody4 = jsonBody3;
                requestBody4 = requestBody3;
                query5 = query3;
                response2 = response;
                url3 = url2;
                headers2 = (Map) $result;
                Requests app4 = MainActivityKt.getApp();
                c00082.L$0 = SpillingKt.nullOutSpilledVariable(query5);
                c00082.L$1 = SpillingKt.nullOutSpilledVariable(url3);
                c00082.L$2 = SpillingKt.nullOutSpilledVariable(jsonBody4);
                c00082.L$3 = SpillingKt.nullOutSpilledVariable(requestBody4);
                c00082.L$4 = SpillingKt.nullOutSpilledVariable(headers2);
                c00082.L$5 = SpillingKt.nullOutSpilledVariable(response2);
                c00082.I$0 = page4;
                c00082.label = 4;
                $result = Requests.post$default(app4, url3, headers2, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody4, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00082, 65276, (Object) null);
                if ($result == obj4) {
                    return obj4;
                }
                url4 = url3;
                headers3 = headers2;
                requestBody5 = requestBody4;
                response = (NiceResponse) $result;
                persistTokenFromXUser(response.getHeaders().get("x-user"));
                String responseBody2 = response.getText();
                ObjectMapper mapper3 = ExtensionsKt.jacksonObjectMapper();
                JsonNode root2 = mapper3.readTree(responseBody2);
                jsonNode = root2.get("data");
                if (jsonNode != null) {
                    bool = null;
                } else {
                    bool = null;
                }
                return MainAPIKt.newSearchResponseList$default(CollectionsKt.emptyList(), bool, 2, bool);
            case 2:
                int page5 = c00082.I$0;
                Map headers6 = (Map) c00082.L$4;
                RequestBody requestBody7 = (RequestBody) c00082.L$3;
                jsonBody3 = (String) c00082.L$2;
                query4 = (String) c00082.L$1;
                String query6 = (String) c00082.L$0;
                ResultKt.throwOnFailure($result);
                headers = headers6;
                query3 = query6;
                obj2 = coroutine_suspended;
                page3 = page5;
                requestBody3 = requestBody7;
                obj3 = $result;
                response = (NiceResponse) obj3;
                if (response.getCode() != 401) {
                    break;
                }
                bearerToken = null;
                sharedPreferences = this.sharedPref;
                if (sharedPreferences != null) {
                    editorRemove.apply();
                }
                c00082.L$0 = SpillingKt.nullOutSpilledVariable(query3);
                c00082.L$1 = query4;
                c00082.L$2 = SpillingKt.nullOutSpilledVariable(jsonBody3);
                c00082.L$3 = requestBody3;
                c00082.L$4 = SpillingKt.nullOutSpilledVariable(headers);
                c00082.L$5 = SpillingKt.nullOutSpilledVariable(response);
                c00082.I$0 = page3;
                c00082.label = 3;
                Object obj7 = obj2;
                url2 = query4;
                obj4 = obj7;
                objBuildAuthHeaders$default = buildAuthHeaders$default(this, "POST", url2, "application/json; charset=utf-8", null, jsonBody3, false, c00082, 40, null);
                if (objBuildAuthHeaders$default == obj4) {
                    return obj4;
                }
                int i3 = page3;
                $result = objBuildAuthHeaders$default;
                page4 = i3;
                jsonBody4 = jsonBody3;
                requestBody4 = requestBody3;
                query5 = query3;
                response2 = response;
                url3 = url2;
                headers2 = (Map) $result;
                Requests app5 = MainActivityKt.getApp();
                c00082.L$0 = SpillingKt.nullOutSpilledVariable(query5);
                c00082.L$1 = SpillingKt.nullOutSpilledVariable(url3);
                c00082.L$2 = SpillingKt.nullOutSpilledVariable(jsonBody4);
                c00082.L$3 = SpillingKt.nullOutSpilledVariable(requestBody4);
                c00082.L$4 = SpillingKt.nullOutSpilledVariable(headers2);
                c00082.L$5 = SpillingKt.nullOutSpilledVariable(response2);
                c00082.I$0 = page4;
                c00082.label = 4;
                $result = Requests.post$default(app5, url3, headers2, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody4, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00082, 65276, (Object) null);
                if ($result == obj4) {
                    return obj4;
                }
                url4 = url3;
                headers3 = headers2;
                requestBody5 = requestBody4;
                response = (NiceResponse) $result;
                persistTokenFromXUser(response.getHeaders().get("x-user"));
                String responseBody3 = response.getText();
                ObjectMapper mapper4 = ExtensionsKt.jacksonObjectMapper();
                JsonNode root3 = mapper4.readTree(responseBody3);
                jsonNode = root3.get("data");
                if (jsonNode != null) {
                    bool = null;
                } else {
                    bool = null;
                }
                return MainAPIKt.newSearchResponseList$default(CollectionsKt.emptyList(), bool, 2, bool);
            case 3:
                page4 = c00082.I$0;
                response2 = (NiceResponse) c00082.L$5;
                RequestBody requestBody8 = (RequestBody) c00082.L$3;
                jsonBody4 = (String) c00082.L$2;
                String url6 = (String) c00082.L$1;
                query5 = (String) c00082.L$0;
                ResultKt.throwOnFailure($result);
                requestBody4 = requestBody8;
                obj4 = coroutine_suspended;
                url3 = url6;
                headers2 = (Map) $result;
                Requests app6 = MainActivityKt.getApp();
                c00082.L$0 = SpillingKt.nullOutSpilledVariable(query5);
                c00082.L$1 = SpillingKt.nullOutSpilledVariable(url3);
                c00082.L$2 = SpillingKt.nullOutSpilledVariable(jsonBody4);
                c00082.L$3 = SpillingKt.nullOutSpilledVariable(requestBody4);
                c00082.L$4 = SpillingKt.nullOutSpilledVariable(headers2);
                c00082.L$5 = SpillingKt.nullOutSpilledVariable(response2);
                c00082.I$0 = page4;
                c00082.label = 4;
                $result = Requests.post$default(app6, url3, headers2, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody4, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00082, 65276, (Object) null);
                if ($result == obj4) {
                    return obj4;
                }
                url4 = url3;
                headers3 = headers2;
                requestBody5 = requestBody4;
                response = (NiceResponse) $result;
                persistTokenFromXUser(response.getHeaders().get("x-user"));
                String responseBody4 = response.getText();
                ObjectMapper mapper5 = ExtensionsKt.jacksonObjectMapper();
                JsonNode root4 = mapper5.readTree(responseBody4);
                jsonNode = root4.get("data");
                if (jsonNode != null) {
                    bool = null;
                } else {
                    bool = null;
                }
                return MainAPIKt.newSearchResponseList$default(CollectionsKt.emptyList(), bool, 2, bool);
            case 4:
                page4 = c00082.I$0;
                headers3 = (Map) c00082.L$4;
                requestBody5 = (RequestBody) c00082.L$3;
                jsonBody4 = (String) c00082.L$2;
                url4 = (String) c00082.L$1;
                query5 = (String) c00082.L$0;
                ResultKt.throwOnFailure($result);
                response = (NiceResponse) $result;
                persistTokenFromXUser(response.getHeaders().get("x-user"));
                String responseBody5 = response.getText();
                ObjectMapper mapper6 = ExtensionsKt.jacksonObjectMapper();
                JsonNode root5 = mapper6.readTree(responseBody5);
                jsonNode = root5.get("data");
                if (jsonNode != null) {
                    bool = null;
                } else {
                    bool = null;
                }
                return MainAPIKt.newSearchResponseList$default(CollectionsKt.emptyList(), bool, 2, bool);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static final Unit search$lambda$0(String $coverImg, JsonNode $subject, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($coverImg);
        Score.Companion companion = Score.Companion;
        JsonNode jsonNode = $subject.get("imdbRatingValue");
        $this$newMovieSearchResponse.setScore(companion.from10(jsonNode != null ? jsonNode.asText() : null));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:150:0x0a4e  */
    /* JADX WARN: Code duplicated, block: B:151:0x0a57  */
    /* JADX WARN: Code duplicated, block: B:289:0x0f2a  */
    /* JADX WARN: Code duplicated, block: B:291:0x101f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:292:0x1020  */
    /* JADX WARN: Code duplicated, block: B:295:0x1138 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:296:0x1139  */
    /* JADX WARN: Code duplicated, block: B:299:0x1182  */
    /* JADX WARN: Code duplicated, block: B:301:0x1194  */
    /* JADX WARN: Code duplicated, block: B:302:0x119d  */
    /* JADX WARN: Code duplicated, block: B:304:0x11a2  */
    /* JADX WARN: Code duplicated, block: B:331:0x1248 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:333:0x124f  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:296:0x1139 -> B:297:0x1174). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object load(@org.jetbrains.annotations.NotNull java.lang.String r90, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r91) {
        /*
            Method dump skipped, instruction units count: 6158
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.MovieBox.MovieBoxProvider.load(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$6$0$5(String $epName, int $seasonNumber, int $episodeNumber, String $epThumb, String $epDesc, Integer $runtime, String $aired, Episode $this$newEpisode) {
        $this$newEpisode.setName($epName);
        $this$newEpisode.setSeason(Integer.valueOf($seasonNumber));
        $this$newEpisode.setEpisode(Integer.valueOf($episodeNumber));
        $this$newEpisode.setPosterUrl($epThumb);
        $this$newEpisode.setDescription($epDesc);
        $this$newEpisode.setRunTime($runtime);
        MainAPIKt.addDate$default($this$newEpisode, $aired, (String) null, 2, (Object) null);
        return Unit.INSTANCE;
    }

    static final Unit load$lambda$7(String $coverUrl, Episode $this$newEpisode) {
        $this$newEpisode.setName("Episode 1");
        $this$newEpisode.setSeason(1);
        $this$newEpisode.setEpisode(1);
        $this$newEpisode.setPosterUrl($coverUrl);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.MovieBox.MovieBoxProvider$load$6 */
    /* JADX INFO: compiled from: MovieBoxProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.MovieBox.MovieBoxProvider$load$6", f = "MovieBoxProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nMovieBoxProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MovieBoxProvider.kt\ncom/MovieBox/MovieBoxProvider$load$6\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1185:1\n1#2:1186\n*E\n"})
    static final class C00046 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $Background;
        final /* synthetic */ String $Description;
        final /* synthetic */ String $IMDBRating;
        final /* synthetic */ String $Poster;
        final /* synthetic */ List<ActorData> $actors;
        final /* synthetic */ String $backgroundUrl;
        final /* synthetic */ String $coverUrl;
        final /* synthetic */ String $description;
        final /* synthetic */ Integer $durationMinutes;
        final /* synthetic */ String $imdbId;
        final /* synthetic */ Integer $imdbRating;
        final /* synthetic */ String $logoUrl;
        final /* synthetic */ List<String> $tags;
        final /* synthetic */ Integer $tmdbId;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00046(String str, String str2, String str3, String str4, String str5, String str6, String str7, Integer num, List<String> list, List<ActorData> list2, String str8, Integer num2, Integer num3, String str9, Integer num4, Continuation<? super C00046> continuation) {
            super(2, continuation);
            this.$coverUrl = str;
            this.$Poster = str2;
            this.$Background = str3;
            this.$backgroundUrl = str4;
            this.$logoUrl = str5;
            this.$Description = str6;
            this.$description = str7;
            this.$year = num;
            this.$tags = list;
            this.$actors = list2;
            this.$IMDBRating = str8;
            this.$imdbRating = num2;
            this.$durationMinutes = num3;
            this.$imdbId = str9;
            this.$tmdbId = num4;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00046 = new C00046(this.$coverUrl, this.$Poster, this.$Background, this.$backgroundUrl, this.$logoUrl, this.$Description, this.$description, this.$year, this.$tags, this.$actors, this.$IMDBRating, this.$imdbRating, this.$durationMinutes, this.$imdbId, this.$tmdbId, continuation);
            c00046.L$0 = obj;
            return c00046;
        }

        public final Object invoke(TvSeriesLoadResponse tvSeriesLoadResponse, Continuation<? super Unit> continuation) {
            return create(tvSeriesLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            LoadResponse loadResponse = (TvSeriesLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String str = this.$coverUrl;
                    if (str == null) {
                        str = this.$Poster;
                    }
                    loadResponse.setPosterUrl(str);
                    String str2 = this.$Background;
                    if (str2 == null && (str2 = this.$backgroundUrl) == null) {
                        str2 = this.$Poster;
                    }
                    loadResponse.setBackgroundPosterUrl(str2);
                    try {
                        loadResponse.setLogoUrl(this.$logoUrl);
                        break;
                    } catch (Throwable th) {
                    }
                    String str3 = this.$Description;
                    if (str3 == null) {
                        str3 = this.$description;
                    }
                    loadResponse.setPlot(str3);
                    loadResponse.setYear(this.$year);
                    loadResponse.setTags(this.$tags);
                    loadResponse.setActors(this.$actors);
                    Score scoreFrom10 = Score.Companion.from10(this.$IMDBRating);
                    if (scoreFrom10 == null) {
                        Integer num = this.$imdbRating;
                        if (num != null) {
                            int it = num.intValue();
                            scoreFrom10 = Score.Companion.from10(Boxing.boxInt(it));
                        } else {
                            scoreFrom10 = null;
                        }
                    }
                    loadResponse.setScore(scoreFrom10);
                    loadResponse.setDuration(this.$durationMinutes);
                    LoadResponse.Companion.addImdbId(loadResponse, this.$imdbId);
                    LoadResponse.Companion.addTMDbId(loadResponse, String.valueOf(this.$tmdbId));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.MovieBox.MovieBoxProvider$load$7 */
    /* JADX INFO: compiled from: MovieBoxProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.MovieBox.MovieBoxProvider$load$7", f = "MovieBoxProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nMovieBoxProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MovieBoxProvider.kt\ncom/MovieBox/MovieBoxProvider$load$7\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1185:1\n1#2:1186\n*E\n"})
    static final class C00057 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $Background;
        final /* synthetic */ String $Description;
        final /* synthetic */ String $IMDBRating;
        final /* synthetic */ String $Poster;
        final /* synthetic */ List<ActorData> $actors;
        final /* synthetic */ String $backgroundUrl;
        final /* synthetic */ String $coverUrl;
        final /* synthetic */ String $description;
        final /* synthetic */ Integer $durationMinutes;
        final /* synthetic */ String $imdbId;
        final /* synthetic */ Integer $imdbRating;
        final /* synthetic */ String $logoUrl;
        final /* synthetic */ List<String> $tags;
        final /* synthetic */ Integer $tmdbId;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00057(String str, String str2, String str3, String str4, String str5, String str6, String str7, Integer num, List<String> list, List<ActorData> list2, String str8, Integer num2, Integer num3, String str9, Integer num4, Continuation<? super C00057> continuation) {
            super(2, continuation);
            this.$coverUrl = str;
            this.$Poster = str2;
            this.$Background = str3;
            this.$backgroundUrl = str4;
            this.$logoUrl = str5;
            this.$Description = str6;
            this.$description = str7;
            this.$year = num;
            this.$tags = list;
            this.$actors = list2;
            this.$IMDBRating = str8;
            this.$imdbRating = num2;
            this.$durationMinutes = num3;
            this.$imdbId = str9;
            this.$tmdbId = num4;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00057 = new C00057(this.$coverUrl, this.$Poster, this.$Background, this.$backgroundUrl, this.$logoUrl, this.$Description, this.$description, this.$year, this.$tags, this.$actors, this.$IMDBRating, this.$imdbRating, this.$durationMinutes, this.$imdbId, this.$tmdbId, continuation);
            c00057.L$0 = obj;
            return c00057;
        }

        public final Object invoke(MovieLoadResponse movieLoadResponse, Continuation<? super Unit> continuation) {
            return create(movieLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            LoadResponse loadResponse = (MovieLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String str = this.$coverUrl;
                    if (str == null) {
                        str = this.$Poster;
                    }
                    loadResponse.setPosterUrl(str);
                    String str2 = this.$Background;
                    if (str2 == null) {
                        str2 = this.$backgroundUrl;
                    }
                    loadResponse.setBackgroundPosterUrl(str2);
                    try {
                        loadResponse.setLogoUrl(this.$logoUrl);
                        break;
                    } catch (Throwable th) {
                    }
                    String str3 = this.$Description;
                    if (str3 == null) {
                        str3 = this.$description;
                    }
                    loadResponse.setPlot(str3);
                    loadResponse.setYear(this.$year);
                    loadResponse.setTags(this.$tags);
                    loadResponse.setActors(this.$actors);
                    Score scoreFrom10 = Score.Companion.from10(this.$IMDBRating);
                    if (scoreFrom10 == null) {
                        Integer num = this.$imdbRating;
                        if (num != null) {
                            int it = num.intValue();
                            scoreFrom10 = Score.Companion.from10(Boxing.boxInt(it));
                        } else {
                            scoreFrom10 = null;
                        }
                    }
                    loadResponse.setScore(scoreFrom10);
                    loadResponse.setDuration(this.$durationMinutes);
                    LoadResponse.Companion.addImdbId(loadResponse, this.$imdbId);
                    LoadResponse.Companion.addTMDbId(loadResponse, String.valueOf(this.$tmdbId));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x03b1  */
    /* JADX WARN: Code duplicated, block: B:105:0x0401 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:106:0x0402  */
    /* JADX WARN: Code duplicated, block: B:111:0x0465 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:112:0x0466  */
    /* JADX WARN: Code duplicated, block: B:120:0x04a9 A[Catch: Exception -> 0x0531, TryCatch #11 {Exception -> 0x0531, blocks: (B:118:0x0493, B:120:0x04a9, B:123:0x04b8, B:125:0x04be, B:126:0x04c2, B:128:0x04c8, B:130:0x04de, B:132:0x04e5, B:134:0x04ef, B:138:0x04fa, B:141:0x0509), top: B:209:0x0493 }] */
    /* JADX WARN: Code duplicated, block: B:121:0x04b2  */
    /* JADX WARN: Code duplicated, block: B:123:0x04b8 A[Catch: Exception -> 0x0531, TryCatch #11 {Exception -> 0x0531, blocks: (B:118:0x0493, B:120:0x04a9, B:123:0x04b8, B:125:0x04be, B:126:0x04c2, B:128:0x04c8, B:130:0x04de, B:132:0x04e5, B:134:0x04ef, B:138:0x04fa, B:141:0x0509), top: B:209:0x0493 }] */
    /* JADX WARN: Code duplicated, block: B:149:0x0538  */
    /* JADX WARN: Code duplicated, block: B:155:0x05b8 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:156:0x05b9  */
    /* JADX WARN: Code duplicated, block: B:209:0x0493 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:219:0x0360 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:85:0x0349 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:86:0x034a  */
    /* JADX WARN: Code duplicated, block: B:94:0x0369  */
    /* JADX WARN: Code duplicated, block: B:99:0x03b0 A[RETURN] */
    /* JADX WARN: Not initialized variable reg: 13, insn: 0x012d: MOVE (r9 I:??[OBJECT, ARRAY]) = (r13 I:??[OBJECT, ARRAY] A[D('callback' kotlin.jvm.functions.Function1)]), block:B:27:0x012b */
    /* JADX WARN: Not initialized variable reg: 15, insn: 0x012f: MOVE (r14 I:??[OBJECT, ARRAY] A[D('subtitleCallback' kotlin.jvm.functions.Function1)]) = (r15 I:??[OBJECT, ARRAY] A[D('data' java.lang.String)]), block:B:27:0x012b */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00061 c00061;
        boolean z;
        String originalSubjectId;
        boolean isCasting2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        List parts;
        int episode;
        int season;
        String originalSubjectId2;
        String data2;
        Object obj;
        String data3;
        Integer intOrNull;
        Integer intOrNull2;
        List groupValues;
        Map subjectHeaders;
        JsonNode jsonNode;
        Object obj2;
        String data4;
        int episode2;
        Map subjectHeaders2;
        String $result;
        String subjectUrl;
        Object obj3;
        NiceResponse subjectResponse;
        boolean isCasting3;
        Function1<? super ExtractorLink, Unit> function5;
        Map subjectHeaders3;
        Function1<? super SubtitleFile, Unit> function6;
        String subjectUrl2;
        String originalSubjectId3;
        NiceResponse subjectResponse2;
        int season2;
        int episode3;
        List parts2;
        boolean z2;
        int season3;
        Map subjectHeaders4;
        Function1<? super ExtractorLink, Unit> function7;
        String originalSubjectId4;
        NiceResponse subjectResponse3;
        boolean isCasting4;
        int season4;
        Function1<? super SubtitleFile, Unit> function8;
        int season5;
        String originalSubjectId5;
        Function1<? super ExtractorLink, Unit> function9;
        int episode4;
        String subjectUrl3;
        Object objBuildAuthHeaders$default;
        String subjectUrl4;
        Function1<? super SubtitleFile, Unit> function10;
        boolean isCasting5;
        NiceResponse subjectResponse4;
        Function1<? super ExtractorLink, Unit> function11;
        int episode5;
        int season6;
        String originalSubjectId6;
        String data5;
        Map subjectHeaders5;
        String data6;
        int episode6;
        Map subjectHeaders6;
        Function1<? super SubtitleFile, Unit> function12;
        int season7;
        String subjectUrl5;
        Function1<? super ExtractorLink, Unit> function13;
        String originalSubjectId7;
        List parts3;
        List subjectIds;
        JsonNode subjectData;
        JsonNode<JsonNode> dubs;
        JsonNode subjectData2;
        C00072 c00072;
        Function1<? super SubtitleFile, Unit> function14;
        Function1<? super ExtractorLink, Unit> function15;
        if (continuation instanceof C00061) {
            c00061 = (C00061) continuation;
            if ((c00061.label & Integer.MIN_VALUE) != 0) {
                c00061.label -= Integer.MIN_VALUE;
            } else {
                c00061 = new C00061(continuation);
            }
        } else {
            c00061 = new C00061(continuation);
        }
        C00061 c00062 = c00061;
        Object $result2 = c00062.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (c00062.label) {
                case 0:
                    ResultKt.throwOnFailure($result2);
                    try {
                        List parts4 = StringsKt.split$default(data, new String[]{"|"}, false, 0, 6, (Object) null);
                        try {
                            if (StringsKt.contains$default((CharSequence) parts4.get(0), "get?subjectId", false, 2, (Object) null)) {
                                MatchResult matchResultFind$default = Regex.find$default(new Regex("subjectId=([^&]+)"), (CharSequence) parts4.get(0), 0, 2, (Object) null);
                                if (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null || (originalSubjectId = (String) groupValues.get(1)) == null) {
                                    originalSubjectId = StringsKt.substringAfterLast$default((String) parts4.get(0), '/', (String) null, 2, (Object) null);
                                }
                            } else {
                                originalSubjectId = StringsKt.contains$default((CharSequence) parts4.get(0), "/", false, 2, (Object) null) ? StringsKt.substringAfterLast$default((String) parts4.get(0), '/', (String) null, 2, (Object) null) : (String) parts4.get(0);
                            }
                            int season8 = (parts4.size() <= 1 || (intOrNull2 = StringsKt.toIntOrNull((String) parts4.get(1))) == null) ? 0 : intOrNull2.intValue();
                            int episode7 = (parts4.size() > 2 && (intOrNull = StringsKt.toIntOrNull((String) parts4.get(2))) != null) ? intOrNull.intValue() : 0;
                            String subjectUrl6 = getMainUrl() + "/wefeed-mobile-bff/subject-api/get?subjectId=" + originalSubjectId;
                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(data);
                            c00062.L$1 = function1;
                            c00062.L$2 = function2;
                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(parts4);
                            c00062.L$4 = originalSubjectId;
                            c00062.L$5 = subjectUrl6;
                            c00062.Z$0 = isCasting;
                            c00062.I$0 = season8;
                            c00062.I$1 = episode7;
                            c00062.label = 1;
                            int episode8 = episode7;
                            int season9 = season8;
                            String originalSubjectId8 = originalSubjectId;
                            Object objBuildAuthHeaders$default2 = buildAuthHeaders$default(this, "GET", subjectUrl6, null, null, null, false, c00062, 60, null);
                            if (objBuildAuthHeaders$default2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            isCasting2 = isCasting;
                            function3 = function1;
                            function4 = function2;
                            parts = parts4;
                            episode = episode8;
                            season = season9;
                            originalSubjectId2 = originalSubjectId8;
                            data2 = subjectUrl6;
                            obj = objBuildAuthHeaders$default2;
                            data3 = data;
                            try {
                                subjectHeaders = (Map) obj;
                                try {
                                    Requests app = MainActivityKt.getApp();
                                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data3);
                                    c00062.L$1 = function3;
                                    c00062.L$2 = function4;
                                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(parts);
                                    c00062.L$4 = originalSubjectId2;
                                    c00062.L$5 = data2;
                                    c00062.L$6 = SpillingKt.nullOutSpilledVariable(subjectHeaders);
                                    c00062.Z$0 = isCasting2;
                                    c00062.I$0 = season;
                                    c00062.I$1 = episode;
                                    c00062.label = 2;
                                    jsonNode = null;
                                    try {
                                        obj2 = Requests.get$default(app, data2, subjectHeaders, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00062, 4092, (Object) null);
                                        if (obj2 == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        data4 = data3;
                                        episode2 = episode;
                                        subjectHeaders2 = subjectHeaders;
                                        $result = originalSubjectId2;
                                        subjectUrl = data2;
                                        obj3 = obj2;
                                        try {
                                            subjectResponse = (NiceResponse) obj3;
                                            if (subjectResponse.getCode() != 401) {
                                                try {
                                                    if (subjectResponse.getCode() != 441) {
                                                        String str = subjectUrl;
                                                        isCasting3 = isCasting2;
                                                        function5 = function4;
                                                        subjectHeaders3 = subjectHeaders2;
                                                        function6 = function3;
                                                        subjectUrl2 = str;
                                                        originalSubjectId3 = $result;
                                                        subjectResponse2 = subjectResponse;
                                                        season2 = episode2;
                                                        episode3 = season;
                                                        parts2 = parts;
                                                        z2 = true;
                                                    }
                                                    try {
                                                        subjectIds = new ArrayList();
                                                        JsonNode jsonNode2 = "Original";
                                                        int season10 = episode3;
                                                        try {
                                                            if (subjectResponse2.getCode() == 200) {
                                                                try {
                                                                    String subjectResponseBody = subjectResponse2.getText();
                                                                    JsonNode subjectRoot = MainAPIKt.getMapper().readTree(subjectResponseBody);
                                                                    subjectData = subjectRoot.get("data");
                                                                    if (subjectData != null) {
                                                                        dubs = subjectData.get("dubs");
                                                                    } else {
                                                                        dubs = jsonNode;
                                                                    }
                                                                    if (dubs == null && dubs.isArray()) {
                                                                        for (JsonNode dub : dubs) {
                                                                            subjectData = subjectData;
                                                                            dubs = dubs;
                                                                            JsonNode jsonNode3 = dub.get("subjectId");
                                                                            JsonNode jsonNodeAsText = jsonNode3 != null ? jsonNode3.asText() : jsonNode;
                                                                            season2 = season2;
                                                                            JsonNode jsonNode4 = dub.get("lanName");
                                                                            JsonNode jsonNodeAsText2 = jsonNode4 != null ? jsonNode4.asText() : jsonNode;
                                                                            if (jsonNodeAsText != null && jsonNodeAsText2 != null) {
                                                                                if (Intrinsics.areEqual(jsonNodeAsText, originalSubjectId3)) {
                                                                                    jsonNode2 = jsonNodeAsText2;
                                                                                } else {
                                                                                    Boxing.boxBoolean(subjectIds.add(new Pair(jsonNodeAsText, jsonNodeAsText2)));
                                                                                }
                                                                            }
                                                                            break;
                                                                        }
                                                                        season2 = season2;
                                                                        subjectData2 = jsonNode2;
                                                                    }
                                                                    persistTokenFromXUser(subjectResponse2.getHeaders().get("x-user"));
                                                                    subjectIds.add(0, new Pair(originalSubjectId3, subjectData2));
                                                                    JsonNode jsonNode5 = subjectData2;
                                                                    int episode9 = season2;
                                                                    Map subjectHeaders7 = subjectHeaders3;
                                                                    z = false;
                                                                    c00072 = new C00072(season10, episode9, function5, function6, null);
                                                                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                                                                    c00062.L$1 = SpillingKt.nullOutSpilledVariable(function6);
                                                                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(function5);
                                                                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(parts2);
                                                                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(originalSubjectId3);
                                                                    c00062.L$5 = SpillingKt.nullOutSpilledVariable(subjectUrl2);
                                                                    c00062.L$6 = SpillingKt.nullOutSpilledVariable(subjectHeaders7);
                                                                    c00062.L$7 = SpillingKt.nullOutSpilledVariable(subjectResponse2);
                                                                    c00062.L$8 = SpillingKt.nullOutSpilledVariable(subjectIds);
                                                                    c00062.L$9 = SpillingKt.nullOutSpilledVariable(jsonNode5);
                                                                    c00062.Z$0 = isCasting3;
                                                                    c00062.I$0 = season10;
                                                                    c00062.I$1 = episode9;
                                                                    c00062.label = 6;
                                                                    if (ParCollectionsKt.amap(subjectIds, c00072, c00062) == coroutine_suspended) {
                                                                        return coroutine_suspended;
                                                                    }
                                                                    function14 = function6;
                                                                    function15 = function5;
                                                                    try {
                                                                        return Boxing.boxBoolean(z2);
                                                                    } catch (Exception e) {
                                                                        return Boxing.boxBoolean(z);
                                                                    }
                                                                } catch (Exception e2) {
                                                                    z = false;
                                                                    return Boxing.boxBoolean(z);
                                                                }
                                                            }
                                                            c00072 = new C00072(season10, episode9, function5, function6, null);
                                                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                                                            c00062.L$1 = SpillingKt.nullOutSpilledVariable(function6);
                                                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(function5);
                                                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(parts2);
                                                            c00062.L$4 = SpillingKt.nullOutSpilledVariable(originalSubjectId3);
                                                            c00062.L$5 = SpillingKt.nullOutSpilledVariable(subjectUrl2);
                                                            c00062.L$6 = SpillingKt.nullOutSpilledVariable(subjectHeaders7);
                                                            c00062.L$7 = SpillingKt.nullOutSpilledVariable(subjectResponse2);
                                                            c00062.L$8 = SpillingKt.nullOutSpilledVariable(subjectIds);
                                                            c00062.L$9 = SpillingKt.nullOutSpilledVariable(jsonNode5);
                                                            c00062.Z$0 = isCasting3;
                                                            c00062.I$0 = season10;
                                                            c00062.I$1 = episode9;
                                                            c00062.label = 6;
                                                            if (ParCollectionsKt.amap(subjectIds, c00072, c00062) == coroutine_suspended) {
                                                                return coroutine_suspended;
                                                            }
                                                            function14 = function6;
                                                            function15 = function5;
                                                            return Boxing.boxBoolean(z2);
                                                        } catch (Exception e3) {
                                                            return Boxing.boxBoolean(z);
                                                        }
                                                        subjectData2 = "Original";
                                                        persistTokenFromXUser(subjectResponse2.getHeaders().get("x-user"));
                                                        subjectIds.add(0, new Pair(originalSubjectId3, subjectData2));
                                                        JsonNode jsonNode6 = subjectData2;
                                                        int episode10 = season2;
                                                        Map subjectHeaders8 = subjectHeaders3;
                                                        z = false;
                                                    } catch (Exception e4) {
                                                        z = false;
                                                    }
                                                } catch (Exception e5) {
                                                    z = false;
                                                    return Boxing.boxBoolean(z);
                                                }
                                            }
                                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                                            c00062.L$1 = function3;
                                            c00062.L$2 = function4;
                                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(parts);
                                            c00062.L$4 = $result;
                                            c00062.L$5 = subjectUrl;
                                            c00062.L$6 = SpillingKt.nullOutSpilledVariable(subjectHeaders2);
                                            c00062.L$7 = SpillingKt.nullOutSpilledVariable(subjectResponse);
                                            c00062.Z$0 = isCasting2;
                                            c00062.I$0 = season;
                                            c00062.I$1 = episode2;
                                            c00062.label = 3;
                                            if (fetchAnonymousToken(true, c00062) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            season3 = episode2;
                                            subjectHeaders4 = subjectHeaders2;
                                            function7 = function4;
                                            originalSubjectId4 = $result;
                                            subjectResponse3 = subjectResponse;
                                            isCasting4 = isCasting2;
                                            season4 = season;
                                            function8 = function3;
                                            try {
                                                c00062.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                                                c00062.L$1 = function8;
                                                c00062.L$2 = function7;
                                                c00062.L$3 = SpillingKt.nullOutSpilledVariable(parts);
                                                c00062.L$4 = originalSubjectId4;
                                                c00062.L$5 = subjectUrl;
                                                c00062.L$6 = SpillingKt.nullOutSpilledVariable(subjectHeaders4);
                                                c00062.L$7 = SpillingKt.nullOutSpilledVariable(subjectResponse3);
                                                c00062.Z$0 = isCasting4;
                                                c00062.I$0 = season4;
                                                c00062.I$1 = season3;
                                                c00062.label = 4;
                                                season5 = season4;
                                                originalSubjectId5 = originalSubjectId4;
                                                function9 = function7;
                                                episode4 = season3;
                                                subjectUrl3 = subjectUrl;
                                                z2 = true;
                                                try {
                                                    objBuildAuthHeaders$default = buildAuthHeaders$default(this, "GET", subjectUrl3, null, null, null, false, c00062, 60, null);
                                                    if (objBuildAuthHeaders$default == coroutine_suspended) {
                                                        return coroutine_suspended;
                                                    }
                                                    Function1<? super SubtitleFile, Unit> function16 = function8;
                                                    subjectUrl4 = subjectUrl3;
                                                    function10 = function16;
                                                    isCasting5 = isCasting4;
                                                    subjectResponse4 = subjectResponse3;
                                                    function11 = function9;
                                                    episode5 = episode4;
                                                    season6 = season5;
                                                    originalSubjectId6 = originalSubjectId5;
                                                    $result2 = objBuildAuthHeaders$default;
                                                    data5 = data4;
                                                    try {
                                                        subjectHeaders5 = (Map) $result2;
                                                        Requests app2 = MainActivityKt.getApp();
                                                        c00062.L$0 = SpillingKt.nullOutSpilledVariable(data5);
                                                        c00062.L$1 = function10;
                                                        c00062.L$2 = function11;
                                                        c00062.L$3 = SpillingKt.nullOutSpilledVariable(parts);
                                                        c00062.L$4 = originalSubjectId6;
                                                        c00062.L$5 = SpillingKt.nullOutSpilledVariable(subjectUrl4);
                                                        c00062.L$6 = SpillingKt.nullOutSpilledVariable(subjectHeaders5);
                                                        c00062.L$7 = SpillingKt.nullOutSpilledVariable(subjectResponse4);
                                                        c00062.Z$0 = isCasting5;
                                                        c00062.I$0 = season6;
                                                        c00062.I$1 = episode5;
                                                        c00062.label = 5;
                                                        try {
                                                            $result2 = Requests.get$default(app2, subjectUrl4, subjectHeaders5, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00062, 4092, (Object) null);
                                                            if ($result2 == coroutine_suspended) {
                                                                return coroutine_suspended;
                                                            }
                                                            data6 = data5;
                                                            episode6 = episode5;
                                                            subjectHeaders6 = subjectHeaders5;
                                                            function12 = function10;
                                                            season7 = season6;
                                                            subjectUrl5 = subjectUrl4;
                                                            function13 = function11;
                                                            originalSubjectId7 = originalSubjectId6;
                                                            parts3 = parts;
                                                            try {
                                                                subjectResponse2 = (NiceResponse) $result2;
                                                                int i = season7;
                                                                season2 = episode6;
                                                                episode3 = i;
                                                                function6 = function12;
                                                                data4 = data6;
                                                                parts2 = parts3;
                                                                subjectUrl2 = subjectUrl5;
                                                                isCasting3 = isCasting5;
                                                                function5 = function13;
                                                                originalSubjectId3 = originalSubjectId7;
                                                                subjectHeaders3 = subjectHeaders6;
                                                                subjectIds = new ArrayList();
                                                                JsonNode jsonNode7 = "Original";
                                                                int season11 = episode3;
                                                                if (subjectResponse2.getCode() == 200) {
                                                                    String subjectResponseBody2 = subjectResponse2.getText();
                                                                    JsonNode subjectRoot2 = MainAPIKt.getMapper().readTree(subjectResponseBody2);
                                                                    subjectData = subjectRoot2.get("data");
                                                                    if (subjectData != null) {
                                                                        dubs = subjectData.get("dubs");
                                                                    } else {
                                                                        dubs = jsonNode;
                                                                    }
                                                                    if (dubs == null) {
                                                                    }
                                                                }
                                                                subjectData2 = "Original";
                                                                persistTokenFromXUser(subjectResponse2.getHeaders().get("x-user"));
                                                                subjectIds.add(0, new Pair(originalSubjectId3, subjectData2));
                                                                JsonNode jsonNode8 = subjectData2;
                                                                int episode11 = season2;
                                                                Map subjectHeaders9 = subjectHeaders3;
                                                                z = false;
                                                                c00072 = new C00072(season11, episode11, function5, function6, null);
                                                                c00062.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                                                                c00062.L$1 = SpillingKt.nullOutSpilledVariable(function6);
                                                                c00062.L$2 = SpillingKt.nullOutSpilledVariable(function5);
                                                                c00062.L$3 = SpillingKt.nullOutSpilledVariable(parts2);
                                                                c00062.L$4 = SpillingKt.nullOutSpilledVariable(originalSubjectId3);
                                                                c00062.L$5 = SpillingKt.nullOutSpilledVariable(subjectUrl2);
                                                                c00062.L$6 = SpillingKt.nullOutSpilledVariable(subjectHeaders9);
                                                                c00062.L$7 = SpillingKt.nullOutSpilledVariable(subjectResponse2);
                                                                c00062.L$8 = SpillingKt.nullOutSpilledVariable(subjectIds);
                                                                c00062.L$9 = SpillingKt.nullOutSpilledVariable(jsonNode8);
                                                                c00062.Z$0 = isCasting3;
                                                                c00062.I$0 = season11;
                                                                c00062.I$1 = episode11;
                                                                c00062.label = 6;
                                                                if (ParCollectionsKt.amap(subjectIds, c00072, c00062) == coroutine_suspended) {
                                                                    return coroutine_suspended;
                                                                }
                                                                function14 = function6;
                                                                function15 = function5;
                                                                return Boxing.boxBoolean(z2);
                                                            } catch (Exception e6) {
                                                                z = false;
                                                                return Boxing.boxBoolean(z);
                                                            }
                                                        } catch (Exception e7) {
                                                            z = false;
                                                            return Boxing.boxBoolean(z);
                                                        }
                                                    } catch (Exception e8) {
                                                        z = false;
                                                    }
                                                } catch (Exception e9) {
                                                    z = false;
                                                    return Boxing.boxBoolean(z);
                                                }
                                            } catch (Exception e10) {
                                                z = false;
                                            }
                                        } catch (Exception e11) {
                                            z = false;
                                        }
                                    } catch (Exception e12) {
                                        z = false;
                                        return Boxing.boxBoolean(z);
                                    }
                                } catch (Exception e13) {
                                    z = false;
                                }
                            } catch (Exception e14) {
                                z = false;
                            }
                        } catch (Exception e15) {
                            z = false;
                            return Boxing.boxBoolean(z);
                        }
                    } catch (Exception e16) {
                        z = false;
                    }
                    break;
                case 1:
                    int episode12 = c00062.I$1;
                    int season12 = c00062.I$0;
                    isCasting2 = c00062.Z$0;
                    String subjectUrl7 = (String) c00062.L$5;
                    String originalSubjectId9 = (String) c00062.L$4;
                    List parts5 = (List) c00062.L$3;
                    function4 = (Function1) c00062.L$2;
                    function3 = (Function1) c00062.L$1;
                    String data7 = (String) c00062.L$0;
                    try {
                        ResultKt.throwOnFailure($result2);
                        episode = episode12;
                        data3 = data7;
                        data2 = subjectUrl7;
                        parts = parts5;
                        originalSubjectId2 = originalSubjectId9;
                        season = season12;
                        obj = $result2;
                        subjectHeaders = (Map) obj;
                        Requests app3 = MainActivityKt.getApp();
                        c00062.L$0 = SpillingKt.nullOutSpilledVariable(data3);
                        c00062.L$1 = function3;
                        c00062.L$2 = function4;
                        c00062.L$3 = SpillingKt.nullOutSpilledVariable(parts);
                        c00062.L$4 = originalSubjectId2;
                        c00062.L$5 = data2;
                        c00062.L$6 = SpillingKt.nullOutSpilledVariable(subjectHeaders);
                        c00062.Z$0 = isCasting2;
                        c00062.I$0 = season;
                        c00062.I$1 = episode;
                        c00062.label = 2;
                        jsonNode = null;
                        obj2 = Requests.get$default(app3, data2, subjectHeaders, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00062, 4092, (Object) null);
                        if (obj2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        data4 = data3;
                        episode2 = episode;
                        subjectHeaders2 = subjectHeaders;
                        $result = originalSubjectId2;
                        subjectUrl = data2;
                        obj3 = obj2;
                        subjectResponse = (NiceResponse) obj3;
                        if (subjectResponse.getCode() != 401) {
                            if (subjectResponse.getCode() != 441) {
                                String str2 = subjectUrl;
                                isCasting3 = isCasting2;
                                function5 = function4;
                                subjectHeaders3 = subjectHeaders2;
                                function6 = function3;
                                subjectUrl2 = str2;
                                originalSubjectId3 = $result;
                                subjectResponse2 = subjectResponse;
                                season2 = episode2;
                                episode3 = season;
                                parts2 = parts;
                                z2 = true;
                            }
                            subjectIds = new ArrayList();
                            JsonNode jsonNode9 = "Original";
                            int season13 = episode3;
                            if (subjectResponse2.getCode() == 200) {
                                String subjectResponseBody3 = subjectResponse2.getText();
                                JsonNode subjectRoot3 = MainAPIKt.getMapper().readTree(subjectResponseBody3);
                                subjectData = subjectRoot3.get("data");
                                if (subjectData != null) {
                                    dubs = subjectData.get("dubs");
                                } else {
                                    dubs = jsonNode;
                                }
                                if (dubs == null) {
                                }
                                break;
                            }
                            subjectData2 = "Original";
                            persistTokenFromXUser(subjectResponse2.getHeaders().get("x-user"));
                            subjectIds.add(0, new Pair(originalSubjectId3, subjectData2));
                            JsonNode jsonNode10 = subjectData2;
                            int episode13 = season2;
                            Map subjectHeaders10 = subjectHeaders3;
                            z = false;
                            c00072 = new C00072(season13, episode13, function5, function6, null);
                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                            c00062.L$1 = SpillingKt.nullOutSpilledVariable(function6);
                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(function5);
                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(parts2);
                            c00062.L$4 = SpillingKt.nullOutSpilledVariable(originalSubjectId3);
                            c00062.L$5 = SpillingKt.nullOutSpilledVariable(subjectUrl2);
                            c00062.L$6 = SpillingKt.nullOutSpilledVariable(subjectHeaders10);
                            c00062.L$7 = SpillingKt.nullOutSpilledVariable(subjectResponse2);
                            c00062.L$8 = SpillingKt.nullOutSpilledVariable(subjectIds);
                            c00062.L$9 = SpillingKt.nullOutSpilledVariable(jsonNode10);
                            c00062.Z$0 = isCasting3;
                            c00062.I$0 = season13;
                            c00062.I$1 = episode13;
                            c00062.label = 6;
                            if (ParCollectionsKt.amap(subjectIds, c00072, c00062) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            function14 = function6;
                            function15 = function5;
                            return Boxing.boxBoolean(z2);
                        }
                        c00062.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                        c00062.L$1 = function3;
                        c00062.L$2 = function4;
                        c00062.L$3 = SpillingKt.nullOutSpilledVariable(parts);
                        c00062.L$4 = $result;
                        c00062.L$5 = subjectUrl;
                        c00062.L$6 = SpillingKt.nullOutSpilledVariable(subjectHeaders2);
                        c00062.L$7 = SpillingKt.nullOutSpilledVariable(subjectResponse);
                        c00062.Z$0 = isCasting2;
                        c00062.I$0 = season;
                        c00062.I$1 = episode2;
                        c00062.label = 3;
                        if (fetchAnonymousToken(true, c00062) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        season3 = episode2;
                        subjectHeaders4 = subjectHeaders2;
                        function7 = function4;
                        originalSubjectId4 = $result;
                        subjectResponse3 = subjectResponse;
                        isCasting4 = isCasting2;
                        season4 = season;
                        function8 = function3;
                        c00062.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                        c00062.L$1 = function8;
                        c00062.L$2 = function7;
                        c00062.L$3 = SpillingKt.nullOutSpilledVariable(parts);
                        c00062.L$4 = originalSubjectId4;
                        c00062.L$5 = subjectUrl;
                        c00062.L$6 = SpillingKt.nullOutSpilledVariable(subjectHeaders4);
                        c00062.L$7 = SpillingKt.nullOutSpilledVariable(subjectResponse3);
                        c00062.Z$0 = isCasting4;
                        c00062.I$0 = season4;
                        c00062.I$1 = season3;
                        c00062.label = 4;
                        season5 = season4;
                        originalSubjectId5 = originalSubjectId4;
                        function9 = function7;
                        episode4 = season3;
                        subjectUrl3 = subjectUrl;
                        z2 = true;
                        objBuildAuthHeaders$default = buildAuthHeaders$default(this, "GET", subjectUrl3, null, null, null, false, c00062, 60, null);
                        if (objBuildAuthHeaders$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Function1<? super SubtitleFile, Unit> function17 = function8;
                        subjectUrl4 = subjectUrl3;
                        function10 = function17;
                        isCasting5 = isCasting4;
                        subjectResponse4 = subjectResponse3;
                        function11 = function9;
                        episode5 = episode4;
                        season6 = season5;
                        originalSubjectId6 = originalSubjectId5;
                        $result2 = objBuildAuthHeaders$default;
                        data5 = data4;
                        subjectHeaders5 = (Map) $result2;
                        Requests app4 = MainActivityKt.getApp();
                        c00062.L$0 = SpillingKt.nullOutSpilledVariable(data5);
                        c00062.L$1 = function10;
                        c00062.L$2 = function11;
                        c00062.L$3 = SpillingKt.nullOutSpilledVariable(parts);
                        c00062.L$4 = originalSubjectId6;
                        c00062.L$5 = SpillingKt.nullOutSpilledVariable(subjectUrl4);
                        c00062.L$6 = SpillingKt.nullOutSpilledVariable(subjectHeaders5);
                        c00062.L$7 = SpillingKt.nullOutSpilledVariable(subjectResponse4);
                        c00062.Z$0 = isCasting5;
                        c00062.I$0 = season6;
                        c00062.I$1 = episode5;
                        c00062.label = 5;
                        $result2 = Requests.get$default(app4, subjectUrl4, subjectHeaders5, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00062, 4092, (Object) null);
                        if ($result2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        data6 = data5;
                        episode6 = episode5;
                        subjectHeaders6 = subjectHeaders5;
                        function12 = function10;
                        season7 = season6;
                        subjectUrl5 = subjectUrl4;
                        function13 = function11;
                        originalSubjectId7 = originalSubjectId6;
                        parts3 = parts;
                        subjectResponse2 = (NiceResponse) $result2;
                        int i2 = season7;
                        season2 = episode6;
                        episode3 = i2;
                        function6 = function12;
                        data4 = data6;
                        parts2 = parts3;
                        subjectUrl2 = subjectUrl5;
                        isCasting3 = isCasting5;
                        function5 = function13;
                        originalSubjectId3 = originalSubjectId7;
                        subjectHeaders3 = subjectHeaders6;
                        subjectIds = new ArrayList();
                        JsonNode jsonNode11 = "Original";
                        int season14 = episode3;
                        if (subjectResponse2.getCode() == 200) {
                            String subjectResponseBody4 = subjectResponse2.getText();
                            JsonNode subjectRoot4 = MainAPIKt.getMapper().readTree(subjectResponseBody4);
                            subjectData = subjectRoot4.get("data");
                            if (subjectData != null) {
                                dubs = subjectData.get("dubs");
                            } else {
                                dubs = jsonNode;
                            }
                            if (dubs == null) {
                            }
                            break;
                        }
                        subjectData2 = "Original";
                        persistTokenFromXUser(subjectResponse2.getHeaders().get("x-user"));
                        subjectIds.add(0, new Pair(originalSubjectId3, subjectData2));
                        JsonNode jsonNode12 = subjectData2;
                        int episode14 = season2;
                        Map subjectHeaders11 = subjectHeaders3;
                        z = false;
                        c00072 = new C00072(season14, episode14, function5, function6, null);
                        c00062.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                        c00062.L$1 = SpillingKt.nullOutSpilledVariable(function6);
                        c00062.L$2 = SpillingKt.nullOutSpilledVariable(function5);
                        c00062.L$3 = SpillingKt.nullOutSpilledVariable(parts2);
                        c00062.L$4 = SpillingKt.nullOutSpilledVariable(originalSubjectId3);
                        c00062.L$5 = SpillingKt.nullOutSpilledVariable(subjectUrl2);
                        c00062.L$6 = SpillingKt.nullOutSpilledVariable(subjectHeaders11);
                        c00062.L$7 = SpillingKt.nullOutSpilledVariable(subjectResponse2);
                        c00062.L$8 = SpillingKt.nullOutSpilledVariable(subjectIds);
                        c00062.L$9 = SpillingKt.nullOutSpilledVariable(jsonNode12);
                        c00062.Z$0 = isCasting3;
                        c00062.I$0 = season14;
                        c00062.I$1 = episode14;
                        c00062.label = 6;
                        if (ParCollectionsKt.amap(subjectIds, c00072, c00062) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function14 = function6;
                        function15 = function5;
                        return Boxing.boxBoolean(z2);
                    } catch (Exception e17) {
                        z = false;
                        return Boxing.boxBoolean(z);
                    }
                case 2:
                    episode2 = c00062.I$1;
                    int season15 = c00062.I$0;
                    isCasting2 = c00062.Z$0;
                    subjectHeaders2 = (Map) c00062.L$6;
                    String subjectUrl8 = (String) c00062.L$5;
                    String originalSubjectId10 = (String) c00062.L$4;
                    List parts6 = (List) c00062.L$3;
                    Function1<? super ExtractorLink, Unit> function18 = (Function1) c00062.L$2;
                    Function1<? super SubtitleFile, Unit> function19 = (Function1) c00062.L$1;
                    data4 = (String) c00062.L$0;
                    try {
                        ResultKt.throwOnFailure($result2);
                        parts = parts6;
                        function4 = function18;
                        function3 = function19;
                        jsonNode = null;
                        $result = originalSubjectId10;
                        obj3 = $result2;
                        subjectUrl = subjectUrl8;
                        season = season15;
                        subjectResponse = (NiceResponse) obj3;
                        if (subjectResponse.getCode() != 401) {
                            if (subjectResponse.getCode() != 441) {
                                String str3 = subjectUrl;
                                isCasting3 = isCasting2;
                                function5 = function4;
                                subjectHeaders3 = subjectHeaders2;
                                function6 = function3;
                                subjectUrl2 = str3;
                                originalSubjectId3 = $result;
                                subjectResponse2 = subjectResponse;
                                season2 = episode2;
                                episode3 = season;
                                parts2 = parts;
                                z2 = true;
                            }
                            subjectIds = new ArrayList();
                            JsonNode jsonNode13 = "Original";
                            int season16 = episode3;
                            if (subjectResponse2.getCode() == 200) {
                                String subjectResponseBody5 = subjectResponse2.getText();
                                JsonNode subjectRoot5 = MainAPIKt.getMapper().readTree(subjectResponseBody5);
                                subjectData = subjectRoot5.get("data");
                                if (subjectData != null) {
                                    dubs = subjectData.get("dubs");
                                } else {
                                    dubs = jsonNode;
                                }
                                if (dubs == null) {
                                }
                                break;
                            }
                            subjectData2 = "Original";
                            persistTokenFromXUser(subjectResponse2.getHeaders().get("x-user"));
                            subjectIds.add(0, new Pair(originalSubjectId3, subjectData2));
                            JsonNode jsonNode14 = subjectData2;
                            int episode15 = season2;
                            Map subjectHeaders12 = subjectHeaders3;
                            z = false;
                            c00072 = new C00072(season16, episode15, function5, function6, null);
                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                            c00062.L$1 = SpillingKt.nullOutSpilledVariable(function6);
                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(function5);
                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(parts2);
                            c00062.L$4 = SpillingKt.nullOutSpilledVariable(originalSubjectId3);
                            c00062.L$5 = SpillingKt.nullOutSpilledVariable(subjectUrl2);
                            c00062.L$6 = SpillingKt.nullOutSpilledVariable(subjectHeaders12);
                            c00062.L$7 = SpillingKt.nullOutSpilledVariable(subjectResponse2);
                            c00062.L$8 = SpillingKt.nullOutSpilledVariable(subjectIds);
                            c00062.L$9 = SpillingKt.nullOutSpilledVariable(jsonNode14);
                            c00062.Z$0 = isCasting3;
                            c00062.I$0 = season16;
                            c00062.I$1 = episode15;
                            c00062.label = 6;
                            if (ParCollectionsKt.amap(subjectIds, c00072, c00062) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            function14 = function6;
                            function15 = function5;
                            return Boxing.boxBoolean(z2);
                        }
                        c00062.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                        c00062.L$1 = function3;
                        c00062.L$2 = function4;
                        c00062.L$3 = SpillingKt.nullOutSpilledVariable(parts);
                        c00062.L$4 = $result;
                        c00062.L$5 = subjectUrl;
                        c00062.L$6 = SpillingKt.nullOutSpilledVariable(subjectHeaders2);
                        c00062.L$7 = SpillingKt.nullOutSpilledVariable(subjectResponse);
                        c00062.Z$0 = isCasting2;
                        c00062.I$0 = season;
                        c00062.I$1 = episode2;
                        c00062.label = 3;
                        if (fetchAnonymousToken(true, c00062) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        season3 = episode2;
                        subjectHeaders4 = subjectHeaders2;
                        function7 = function4;
                        originalSubjectId4 = $result;
                        subjectResponse3 = subjectResponse;
                        isCasting4 = isCasting2;
                        season4 = season;
                        function8 = function3;
                        c00062.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                        c00062.L$1 = function8;
                        c00062.L$2 = function7;
                        c00062.L$3 = SpillingKt.nullOutSpilledVariable(parts);
                        c00062.L$4 = originalSubjectId4;
                        c00062.L$5 = subjectUrl;
                        c00062.L$6 = SpillingKt.nullOutSpilledVariable(subjectHeaders4);
                        c00062.L$7 = SpillingKt.nullOutSpilledVariable(subjectResponse3);
                        c00062.Z$0 = isCasting4;
                        c00062.I$0 = season4;
                        c00062.I$1 = season3;
                        c00062.label = 4;
                        season5 = season4;
                        originalSubjectId5 = originalSubjectId4;
                        function9 = function7;
                        episode4 = season3;
                        subjectUrl3 = subjectUrl;
                        z2 = true;
                        objBuildAuthHeaders$default = buildAuthHeaders$default(this, "GET", subjectUrl3, null, null, null, false, c00062, 60, null);
                        if (objBuildAuthHeaders$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Function1<? super SubtitleFile, Unit> function110 = function8;
                        subjectUrl4 = subjectUrl3;
                        function10 = function110;
                        isCasting5 = isCasting4;
                        subjectResponse4 = subjectResponse3;
                        function11 = function9;
                        episode5 = episode4;
                        season6 = season5;
                        originalSubjectId6 = originalSubjectId5;
                        $result2 = objBuildAuthHeaders$default;
                        data5 = data4;
                        subjectHeaders5 = (Map) $result2;
                        Requests app5 = MainActivityKt.getApp();
                        c00062.L$0 = SpillingKt.nullOutSpilledVariable(data5);
                        c00062.L$1 = function10;
                        c00062.L$2 = function11;
                        c00062.L$3 = SpillingKt.nullOutSpilledVariable(parts);
                        c00062.L$4 = originalSubjectId6;
                        c00062.L$5 = SpillingKt.nullOutSpilledVariable(subjectUrl4);
                        c00062.L$6 = SpillingKt.nullOutSpilledVariable(subjectHeaders5);
                        c00062.L$7 = SpillingKt.nullOutSpilledVariable(subjectResponse4);
                        c00062.Z$0 = isCasting5;
                        c00062.I$0 = season6;
                        c00062.I$1 = episode5;
                        c00062.label = 5;
                        $result2 = Requests.get$default(app5, subjectUrl4, subjectHeaders5, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00062, 4092, (Object) null);
                        if ($result2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        data6 = data5;
                        episode6 = episode5;
                        subjectHeaders6 = subjectHeaders5;
                        function12 = function10;
                        season7 = season6;
                        subjectUrl5 = subjectUrl4;
                        function13 = function11;
                        originalSubjectId7 = originalSubjectId6;
                        parts3 = parts;
                        subjectResponse2 = (NiceResponse) $result2;
                        int i3 = season7;
                        season2 = episode6;
                        episode3 = i3;
                        function6 = function12;
                        data4 = data6;
                        parts2 = parts3;
                        subjectUrl2 = subjectUrl5;
                        isCasting3 = isCasting5;
                        function5 = function13;
                        originalSubjectId3 = originalSubjectId7;
                        subjectHeaders3 = subjectHeaders6;
                        subjectIds = new ArrayList();
                        JsonNode jsonNode15 = "Original";
                        int season17 = episode3;
                        if (subjectResponse2.getCode() == 200) {
                            String subjectResponseBody6 = subjectResponse2.getText();
                            JsonNode subjectRoot6 = MainAPIKt.getMapper().readTree(subjectResponseBody6);
                            subjectData = subjectRoot6.get("data");
                            if (subjectData != null) {
                                dubs = subjectData.get("dubs");
                            } else {
                                dubs = jsonNode;
                            }
                            if (dubs == null) {
                            }
                            break;
                        }
                        subjectData2 = "Original";
                        persistTokenFromXUser(subjectResponse2.getHeaders().get("x-user"));
                        subjectIds.add(0, new Pair(originalSubjectId3, subjectData2));
                        JsonNode jsonNode16 = subjectData2;
                        int episode16 = season2;
                        Map subjectHeaders13 = subjectHeaders3;
                        z = false;
                        c00072 = new C00072(season17, episode16, function5, function6, null);
                        c00062.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                        c00062.L$1 = SpillingKt.nullOutSpilledVariable(function6);
                        c00062.L$2 = SpillingKt.nullOutSpilledVariable(function5);
                        c00062.L$3 = SpillingKt.nullOutSpilledVariable(parts2);
                        c00062.L$4 = SpillingKt.nullOutSpilledVariable(originalSubjectId3);
                        c00062.L$5 = SpillingKt.nullOutSpilledVariable(subjectUrl2);
                        c00062.L$6 = SpillingKt.nullOutSpilledVariable(subjectHeaders13);
                        c00062.L$7 = SpillingKt.nullOutSpilledVariable(subjectResponse2);
                        c00062.L$8 = SpillingKt.nullOutSpilledVariable(subjectIds);
                        c00062.L$9 = SpillingKt.nullOutSpilledVariable(jsonNode16);
                        c00062.Z$0 = isCasting3;
                        c00062.I$0 = season17;
                        c00062.I$1 = episode16;
                        c00062.label = 6;
                        if (ParCollectionsKt.amap(subjectIds, c00072, c00062) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function14 = function6;
                        function15 = function5;
                        return Boxing.boxBoolean(z2);
                    } catch (Exception e18) {
                        z = false;
                        return Boxing.boxBoolean(z);
                    }
                case 3:
                    int episode17 = c00062.I$1;
                    int season18 = c00062.I$0;
                    boolean isCasting6 = c00062.Z$0;
                    NiceResponse subjectResponse5 = (NiceResponse) c00062.L$7;
                    Map subjectHeaders14 = (Map) c00062.L$6;
                    subjectUrl = (String) c00062.L$5;
                    String originalSubjectId11 = (String) c00062.L$4;
                    List parts7 = (List) c00062.L$3;
                    Function1<? super ExtractorLink, Unit> function20 = (Function1) c00062.L$2;
                    Function1<? super SubtitleFile, Unit> function21 = (Function1) c00062.L$1;
                    String data8 = (String) c00062.L$0;
                    ResultKt.throwOnFailure($result2);
                    subjectResponse3 = subjectResponse5;
                    subjectHeaders4 = subjectHeaders14;
                    originalSubjectId4 = originalSubjectId11;
                    parts = parts7;
                    jsonNode = null;
                    isCasting4 = isCasting6;
                    season4 = season18;
                    season3 = episode17;
                    function7 = function20;
                    function8 = function21;
                    data4 = data8;
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                    c00062.L$1 = function8;
                    c00062.L$2 = function7;
                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(parts);
                    c00062.L$4 = originalSubjectId4;
                    c00062.L$5 = subjectUrl;
                    c00062.L$6 = SpillingKt.nullOutSpilledVariable(subjectHeaders4);
                    c00062.L$7 = SpillingKt.nullOutSpilledVariable(subjectResponse3);
                    c00062.Z$0 = isCasting4;
                    c00062.I$0 = season4;
                    c00062.I$1 = season3;
                    c00062.label = 4;
                    season5 = season4;
                    originalSubjectId5 = originalSubjectId4;
                    function9 = function7;
                    episode4 = season3;
                    subjectUrl3 = subjectUrl;
                    z2 = true;
                    objBuildAuthHeaders$default = buildAuthHeaders$default(this, "GET", subjectUrl3, null, null, null, false, c00062, 60, null);
                    if (objBuildAuthHeaders$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Function1<? super SubtitleFile, Unit> function111 = function8;
                    subjectUrl4 = subjectUrl3;
                    function10 = function111;
                    isCasting5 = isCasting4;
                    subjectResponse4 = subjectResponse3;
                    function11 = function9;
                    episode5 = episode4;
                    season6 = season5;
                    originalSubjectId6 = originalSubjectId5;
                    $result2 = objBuildAuthHeaders$default;
                    data5 = data4;
                    subjectHeaders5 = (Map) $result2;
                    Requests app6 = MainActivityKt.getApp();
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data5);
                    c00062.L$1 = function10;
                    c00062.L$2 = function11;
                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(parts);
                    c00062.L$4 = originalSubjectId6;
                    c00062.L$5 = SpillingKt.nullOutSpilledVariable(subjectUrl4);
                    c00062.L$6 = SpillingKt.nullOutSpilledVariable(subjectHeaders5);
                    c00062.L$7 = SpillingKt.nullOutSpilledVariable(subjectResponse4);
                    c00062.Z$0 = isCasting5;
                    c00062.I$0 = season6;
                    c00062.I$1 = episode5;
                    c00062.label = 5;
                    $result2 = Requests.get$default(app6, subjectUrl4, subjectHeaders5, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00062, 4092, (Object) null);
                    if ($result2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    data6 = data5;
                    episode6 = episode5;
                    subjectHeaders6 = subjectHeaders5;
                    function12 = function10;
                    season7 = season6;
                    subjectUrl5 = subjectUrl4;
                    function13 = function11;
                    originalSubjectId7 = originalSubjectId6;
                    parts3 = parts;
                    subjectResponse2 = (NiceResponse) $result2;
                    int i4 = season7;
                    season2 = episode6;
                    episode3 = i4;
                    function6 = function12;
                    data4 = data6;
                    parts2 = parts3;
                    subjectUrl2 = subjectUrl5;
                    isCasting3 = isCasting5;
                    function5 = function13;
                    originalSubjectId3 = originalSubjectId7;
                    subjectHeaders3 = subjectHeaders6;
                    subjectIds = new ArrayList();
                    JsonNode jsonNode17 = "Original";
                    int season19 = episode3;
                    if (subjectResponse2.getCode() == 200) {
                        String subjectResponseBody7 = subjectResponse2.getText();
                        JsonNode subjectRoot7 = MainAPIKt.getMapper().readTree(subjectResponseBody7);
                        subjectData = subjectRoot7.get("data");
                        if (subjectData != null) {
                            dubs = subjectData.get("dubs");
                        } else {
                            dubs = jsonNode;
                        }
                        if (dubs == null) {
                        }
                        break;
                    }
                    subjectData2 = "Original";
                    persistTokenFromXUser(subjectResponse2.getHeaders().get("x-user"));
                    subjectIds.add(0, new Pair(originalSubjectId3, subjectData2));
                    JsonNode jsonNode18 = subjectData2;
                    int episode18 = season2;
                    Map subjectHeaders15 = subjectHeaders3;
                    z = false;
                    c00072 = new C00072(season19, episode18, function5, function6, null);
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                    c00062.L$1 = SpillingKt.nullOutSpilledVariable(function6);
                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(function5);
                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(parts2);
                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(originalSubjectId3);
                    c00062.L$5 = SpillingKt.nullOutSpilledVariable(subjectUrl2);
                    c00062.L$6 = SpillingKt.nullOutSpilledVariable(subjectHeaders15);
                    c00062.L$7 = SpillingKt.nullOutSpilledVariable(subjectResponse2);
                    c00062.L$8 = SpillingKt.nullOutSpilledVariable(subjectIds);
                    c00062.L$9 = SpillingKt.nullOutSpilledVariable(jsonNode18);
                    c00062.Z$0 = isCasting3;
                    c00062.I$0 = season19;
                    c00062.I$1 = episode18;
                    c00062.label = 6;
                    if (ParCollectionsKt.amap(subjectIds, c00072, c00062) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function14 = function6;
                    function15 = function5;
                    return Boxing.boxBoolean(z2);
                case 4:
                    int episode19 = c00062.I$1;
                    int season20 = c00062.I$0;
                    isCasting5 = c00062.Z$0;
                    NiceResponse subjectResponse6 = (NiceResponse) c00062.L$7;
                    String subjectUrl9 = (String) c00062.L$5;
                    String originalSubjectId12 = (String) c00062.L$4;
                    List parts8 = (List) c00062.L$3;
                    Function1<? super ExtractorLink, Unit> function22 = (Function1) c00062.L$2;
                    Function1<? super SubtitleFile, Unit> function23 = (Function1) c00062.L$1;
                    String data9 = (String) c00062.L$0;
                    ResultKt.throwOnFailure($result2);
                    parts = parts8;
                    jsonNode = null;
                    z2 = true;
                    episode5 = episode19;
                    originalSubjectId6 = originalSubjectId12;
                    data5 = data9;
                    subjectResponse4 = subjectResponse6;
                    function11 = function22;
                    subjectUrl4 = subjectUrl9;
                    season6 = season20;
                    function10 = function23;
                    subjectHeaders5 = (Map) $result2;
                    Requests app7 = MainActivityKt.getApp();
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data5);
                    c00062.L$1 = function10;
                    c00062.L$2 = function11;
                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(parts);
                    c00062.L$4 = originalSubjectId6;
                    c00062.L$5 = SpillingKt.nullOutSpilledVariable(subjectUrl4);
                    c00062.L$6 = SpillingKt.nullOutSpilledVariable(subjectHeaders5);
                    c00062.L$7 = SpillingKt.nullOutSpilledVariable(subjectResponse4);
                    c00062.Z$0 = isCasting5;
                    c00062.I$0 = season6;
                    c00062.I$1 = episode5;
                    c00062.label = 5;
                    $result2 = Requests.get$default(app7, subjectUrl4, subjectHeaders5, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00062, 4092, (Object) null);
                    if ($result2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    data6 = data5;
                    episode6 = episode5;
                    subjectHeaders6 = subjectHeaders5;
                    function12 = function10;
                    season7 = season6;
                    subjectUrl5 = subjectUrl4;
                    function13 = function11;
                    originalSubjectId7 = originalSubjectId6;
                    parts3 = parts;
                    subjectResponse2 = (NiceResponse) $result2;
                    int i5 = season7;
                    season2 = episode6;
                    episode3 = i5;
                    function6 = function12;
                    data4 = data6;
                    parts2 = parts3;
                    subjectUrl2 = subjectUrl5;
                    isCasting3 = isCasting5;
                    function5 = function13;
                    originalSubjectId3 = originalSubjectId7;
                    subjectHeaders3 = subjectHeaders6;
                    subjectIds = new ArrayList();
                    JsonNode jsonNode19 = "Original";
                    int season110 = episode3;
                    if (subjectResponse2.getCode() == 200) {
                        String subjectResponseBody8 = subjectResponse2.getText();
                        JsonNode subjectRoot8 = MainAPIKt.getMapper().readTree(subjectResponseBody8);
                        subjectData = subjectRoot8.get("data");
                        if (subjectData != null) {
                            dubs = subjectData.get("dubs");
                        } else {
                            dubs = jsonNode;
                        }
                        if (dubs == null) {
                        }
                        break;
                    }
                    subjectData2 = "Original";
                    persistTokenFromXUser(subjectResponse2.getHeaders().get("x-user"));
                    subjectIds.add(0, new Pair(originalSubjectId3, subjectData2));
                    JsonNode jsonNode110 = subjectData2;
                    int episode110 = season2;
                    Map subjectHeaders16 = subjectHeaders3;
                    z = false;
                    c00072 = new C00072(season110, episode110, function5, function6, null);
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                    c00062.L$1 = SpillingKt.nullOutSpilledVariable(function6);
                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(function5);
                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(parts2);
                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(originalSubjectId3);
                    c00062.L$5 = SpillingKt.nullOutSpilledVariable(subjectUrl2);
                    c00062.L$6 = SpillingKt.nullOutSpilledVariable(subjectHeaders16);
                    c00062.L$7 = SpillingKt.nullOutSpilledVariable(subjectResponse2);
                    c00062.L$8 = SpillingKt.nullOutSpilledVariable(subjectIds);
                    c00062.L$9 = SpillingKt.nullOutSpilledVariable(jsonNode110);
                    c00062.Z$0 = isCasting3;
                    c00062.I$0 = season110;
                    c00062.I$1 = episode110;
                    c00062.label = 6;
                    if (ParCollectionsKt.amap(subjectIds, c00072, c00062) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function14 = function6;
                    function15 = function5;
                    return Boxing.boxBoolean(z2);
                case 5:
                    episode6 = c00062.I$1;
                    season7 = c00062.I$0;
                    isCasting5 = c00062.Z$0;
                    subjectHeaders6 = (Map) c00062.L$6;
                    subjectUrl5 = (String) c00062.L$5;
                    originalSubjectId7 = (String) c00062.L$4;
                    parts3 = (List) c00062.L$3;
                    function13 = (Function1) c00062.L$2;
                    function12 = (Function1) c00062.L$1;
                    data6 = (String) c00062.L$0;
                    ResultKt.throwOnFailure($result2);
                    jsonNode = null;
                    z2 = true;
                    subjectResponse2 = (NiceResponse) $result2;
                    int i6 = season7;
                    season2 = episode6;
                    episode3 = i6;
                    function6 = function12;
                    data4 = data6;
                    parts2 = parts3;
                    subjectUrl2 = subjectUrl5;
                    isCasting3 = isCasting5;
                    function5 = function13;
                    originalSubjectId3 = originalSubjectId7;
                    subjectHeaders3 = subjectHeaders6;
                    subjectIds = new ArrayList();
                    JsonNode jsonNode111 = "Original";
                    int season111 = episode3;
                    if (subjectResponse2.getCode() == 200) {
                        String subjectResponseBody9 = subjectResponse2.getText();
                        JsonNode subjectRoot9 = MainAPIKt.getMapper().readTree(subjectResponseBody9);
                        subjectData = subjectRoot9.get("data");
                        if (subjectData != null) {
                            dubs = subjectData.get("dubs");
                        } else {
                            dubs = jsonNode;
                        }
                        if (dubs == null) {
                        }
                        break;
                    }
                    subjectData2 = "Original";
                    persistTokenFromXUser(subjectResponse2.getHeaders().get("x-user"));
                    subjectIds.add(0, new Pair(originalSubjectId3, subjectData2));
                    JsonNode jsonNode112 = subjectData2;
                    int episode111 = season2;
                    Map subjectHeaders17 = subjectHeaders3;
                    z = false;
                    c00072 = new C00072(season111, episode111, function5, function6, null);
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                    c00062.L$1 = SpillingKt.nullOutSpilledVariable(function6);
                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(function5);
                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(parts2);
                    c00062.L$4 = SpillingKt.nullOutSpilledVariable(originalSubjectId3);
                    c00062.L$5 = SpillingKt.nullOutSpilledVariable(subjectUrl2);
                    c00062.L$6 = SpillingKt.nullOutSpilledVariable(subjectHeaders17);
                    c00062.L$7 = SpillingKt.nullOutSpilledVariable(subjectResponse2);
                    c00062.L$8 = SpillingKt.nullOutSpilledVariable(subjectIds);
                    c00062.L$9 = SpillingKt.nullOutSpilledVariable(jsonNode112);
                    c00062.Z$0 = isCasting3;
                    c00062.I$0 = season111;
                    c00062.I$1 = episode111;
                    c00062.label = 6;
                    if (ParCollectionsKt.amap(subjectIds, c00072, c00062) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function14 = function6;
                    function15 = function5;
                    return Boxing.boxBoolean(z2);
                case 6:
                    int i7 = c00062.I$1;
                    int i8 = c00062.I$0;
                    boolean z3 = c00062.Z$0;
                    function15 = (Function1) c00062.L$2;
                    function14 = (Function1) c00062.L$1;
                    try {
                        ResultKt.throwOnFailure($result2);
                        z = false;
                        z2 = true;
                        return Boxing.boxBoolean(z2);
                    } catch (Exception e19) {
                        z = false;
                        return Boxing.boxBoolean(z);
                    }
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Exception e20) {
            z = false;
        }
    }

    /* JADX INFO: renamed from: com.MovieBox.MovieBoxProvider$loadLinks$2 */
    /* JADX INFO: compiled from: MovieBoxProvider.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "<destruct>", "Lkotlin/Pair;", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.MovieBox.MovieBoxProvider$loadLinks$2", f = "MovieBoxProvider.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14}, l = {781, 782, 785, 786, 787, 817, 845, 846, 857, 866, 867, 878, 889, 890, 904}, m = "invokeSuspend", n = {"<destruct>", "subjectId", "language", "playUrl", "<destruct>", "subjectId", "language", "playUrl", "playHeaders", "<destruct>", "subjectId", "language", "playUrl", "playHeaders", "response", "<destruct>", "subjectId", "language", "playUrl", "playHeaders", "response", "<destruct>", "subjectId", "language", "playUrl", "playHeaders", "response", "<destruct>", "subjectId", "language", "playUrl", "playHeaders", "response", "responseBody", "root", "playData", "streams", "stream", "rawStreamUrl", "format", "resolutions", "signCookieRaw", "signCookie", "streamId", "quality", "policyUrl", "finalStreamUrl", "<destruct>", "subjectId", "language", "playUrl", "playHeaders", "response", "responseBody", "root", "playData", "streams", "stream", "rawStreamUrl", "format", "resolutions", "signCookieRaw", "signCookie", "streamId", "quality", "policyUrl", "finalStreamUrl", "subLink", "<destruct>", "subjectId", "language", "playUrl", "playHeaders", "response", "responseBody", "root", "playData", "streams", "stream", "rawStreamUrl", "format", "resolutions", "signCookieRaw", "signCookie", "streamId", "quality", "policyUrl", "finalStreamUrl", "subLink", "subHeaders", "<destruct>", "subjectId", "language", "playUrl", "playHeaders", "response", "responseBody", "root", "playData", "streams", "stream", "rawStreamUrl", "format", "resolutions", "signCookieRaw", "signCookie", "streamId", "quality", "policyUrl", "finalStreamUrl", "subLink", "subHeaders", "subResponse", "subRoot", "extCaptions", "caption", "captionUrl", "lang", "<destruct>", "subjectId", "language", "playUrl", "playHeaders", "response", "responseBody", "root", "playData", "streams", "stream", "rawStreamUrl", "format", "resolutions", "signCookieRaw", "signCookie", "streamId", "quality", "policyUrl", "finalStreamUrl", "subLink", "subHeaders", "subResponse", "subRoot", "extCaptions", "subLink1", "<destruct>", "subjectId", "language", "playUrl", "playHeaders", "response", "responseBody", "root", "playData", "streams", "stream", "rawStreamUrl", "format", "resolutions", "signCookieRaw", "signCookie", "streamId", "quality", "policyUrl", "finalStreamUrl", "subLink", "subHeaders", "subResponse", "subRoot", "extCaptions", "subLink1", "subHeaders1", "<destruct>", "subjectId", "language", "playUrl", "playHeaders", "response", "responseBody", "root", "playData", "streams", "stream", "rawStreamUrl", "format", "resolutions", "signCookieRaw", "signCookie", "streamId", "quality", "policyUrl", "finalStreamUrl", "subLink", "subHeaders", "subResponse", "subRoot", "extCaptions", "subLink1", "subHeaders1", "subResponse1", "subRoot1", "extCaptions1", "caption", "captionUrl", "lang", "<destruct>", "subjectId", "language", "playUrl", "playHeaders", "response", "responseBody", "root", "playData", "streams", "fallbackUrl", "<destruct>", "subjectId", "language", "playUrl", "playHeaders", "response", "responseBody", "root", "playData", "streams", "fallbackUrl", "fallbackHeaders", "<destruct>", "subjectId", "language", "playUrl", "playHeaders", "response", "responseBody", "root", "playData", "streams", "fallbackUrl", "fallbackHeaders", "fallbackResponse", "fallbackRoot", "detectors", "$this$forEach$iv", "element$iv", "detector", "$this$forEach$iv", "element$iv", "video", "se", "link", "ep", "quality"}, nl = {782, 784, 786, 787, 790, 816, 846, 847, 856, 867, 868, 877, 890, 892, 903}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$27", "L$28", "L$29", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$28", "L$29", "L$30", "L$32", "L$33", "L$34", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$19", "L$20", "L$21", "L$23", "L$24", "L$25", "L$26", "L$27", "I$2"}, v = 2)
    @SourceDebugExtension({"SMAP\nMovieBoxProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MovieBoxProvider.kt\ncom/MovieBox/MovieBoxProvider$loadLinks$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1185:1\n2068#2:1186\n2068#2,2:1187\n2069#2:1189\n*S KotlinDebug\n*F\n+ 1 MovieBoxProvider.kt\ncom/MovieBox/MovieBoxProvider$loadLinks$2\n*L\n895#1:1186\n896#1:1187,2\n895#1:1189\n*E\n"})
    static final class C00072 extends SuspendLambda implements Function2<Pair<? extends String, ? extends String>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ int $episode;
        final /* synthetic */ int $season;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        int I$0;
        int I$1;
        int I$2;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$16;
        Object L$17;
        Object L$18;
        Object L$19;
        Object L$2;
        Object L$20;
        Object L$21;
        Object L$22;
        Object L$23;
        Object L$24;
        Object L$25;
        Object L$26;
        Object L$27;
        Object L$28;
        Object L$29;
        Object L$3;
        Object L$30;
        Object L$31;
        Object L$32;
        Object L$33;
        Object L$34;
        Object L$35;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00072(int i, int i2, Function1<? super ExtractorLink, Unit> function1, Function1<? super SubtitleFile, Unit> function2, Continuation<? super C00072> continuation) {
            super(2, continuation);
            this.$season = i;
            this.$episode = i2;
            this.$callback = function1;
            this.$subtitleCallback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00072 = MovieBoxProvider.this.new C00072(this.$season, this.$episode, this.$callback, this.$subtitleCallback, continuation);
            c00072.L$0 = obj;
            return c00072;
        }

        public final Object invoke(Pair<String, String> pair, Continuation<? super Unit> continuation) {
            return create(pair, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:389:0x17e8 A[Catch: Exception -> 0x1bad, TRY_LEAVE, TryCatch #4 {Exception -> 0x1bad, blocks: (B:387:0x17e2, B:389:0x17e8), top: B:496:0x17e2 }] */
        /* JADX WARN: Code duplicated, block: B:393:0x1802 A[Catch: Exception -> 0x1ba3, TRY_LEAVE, TryCatch #23 {Exception -> 0x1ba3, blocks: (B:391:0x17f6, B:393:0x1802, B:466:0x1b95), top: B:532:0x17f6 }] */
        /* JADX WARN: Code duplicated, block: B:463:0x1b84  */
        /* JADX WARN: Not initialized variable reg: 12, insn: 0x07d1: MOVE (r5 I:??[OBJECT, ARRAY]) = (r12 I:??[OBJECT, ARRAY] A[D('language' java.lang.String)]), block:B:64:0x07ce */
        /* JADX WARN: Not initialized variable reg: 15, insn: 0x07d2: MOVE (r3 I:??[OBJECT, ARRAY]) = (r15 I:??[OBJECT, ARRAY] A[D('subjectId' java.lang.String)]), block:B:64:0x07ce */
        /* JADX WARN: Not initialized variable reg: 20, insn: 0x0761: MOVE (r2 I:??[OBJECT, ARRAY] A[D('subjectId' java.lang.String)]) = (r20 I:??[OBJECT, ARRAY] A[D('<destruct>' kotlin.Pair)]), block:B:53:0x075d */
        /* JADX WARN: Not initialized variable reg: 20, insn: 0x07d3: MOVE (r2 I:??[OBJECT, ARRAY]) = (r20 I:??[OBJECT, ARRAY] A[D('<destruct>' kotlin.Pair)]), block:B:64:0x07ce */
        /* JADX WARN: Not initialized variable reg: 37, insn: 0x0763: MOVE (r5 I:??[OBJECT, ARRAY]) = (r37 I:??[OBJECT, ARRAY] A[D('language' java.lang.String)]), block:B:53:0x075d */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:269:0x1083 -> B:517:0x0ee6). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:299:0x1390 -> B:560:0x13b3). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:332:0x1530 -> B:528:0x154c). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:394:0x180a -> B:506:0x1833). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:441:0x1a2f -> B:568:0x1a54). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:463:0x1b84 -> B:464:0x1b8c). Please report as a decompilation issue!!! */
        /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
            java.lang.StackOverflowError
            	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
            	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
            */
        public final java.lang.Object invokeSuspend(java.lang.Object r66) {
            /*
                Method dump skipped, instruction units count: 7212
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.MovieBox.MovieBoxProvider.C00072.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: com.MovieBox.MovieBoxProvider$loadLinks$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: MovieBoxProvider.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.MovieBox.MovieBoxProvider$loadLinks$2$1", f = "MovieBoxProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
            final /* synthetic */ Integer $quality;
            final /* synthetic */ String $signCookie;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ MovieBoxProvider this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(MovieBoxProvider movieBoxProvider, Integer num, String str, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = movieBoxProvider;
                this.$quality = num;
                this.$signCookie = str;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.this$0, this.$quality, this.$signCookie, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            public final Object invoke(ExtractorLink extractorLink, Continuation<? super Unit> continuation) {
                return create(extractorLink, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object $result) {
                ExtractorLink $this$newExtractorLink = (ExtractorLink) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        $this$newExtractorLink.setHeaders(MapsKt.mapOf(new Pair[]{TuplesKt.to("Referer", this.this$0.getMainUrl() + '/'), TuplesKt.to("User-Agent", this.this$0.modernUserAgent)}));
                        if (this.$quality != null) {
                            $this$newExtractorLink.setQuality(this.$quality.intValue());
                        }
                        if (this.$signCookie != null) {
                            $this$newExtractorLink.setHeaders(MapsKt.plus($this$newExtractorLink.getHeaders(), MapsKt.mapOf(TuplesKt.to("Cookie", this.$signCookie))));
                        }
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
    }
}
