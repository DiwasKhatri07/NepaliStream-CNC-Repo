package com.MovieBox;

import android.content.SharedPreferences;
import android.util.Base64;
import com.fasterxml.jackson.databind.JsonNode;
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
import com.phisher98.donation.DonationManager;
import java.net.URI;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
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
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 d2\u00020\u0001:\u0001dB\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u001f\u001a\u00020\u0007H\u0002J\u0010\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010*\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0007H\u0002J\u0019\u0010+\u001a\u00020\u00072\n\b\u0002\u0010,\u001a\u0004\u0018\u00010&H\u0002¢\u0006\u0002\u0010-J>\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u00072\b\u00100\u001a\u0004\u0018\u00010\u00072\b\u00101\u001a\u0004\u0018\u00010\u00072\u0006\u00102\u001a\u00020\u00072\b\u00103\u001a\u0004\u0018\u00010\u00072\u0006\u00104\u001a\u00020&H\u0002JS\u00105\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u00072\b\u00100\u001a\u0004\u0018\u00010\u00072\b\u00101\u001a\u0004\u0018\u00010\u00072\u0006\u00102\u001a\u00020\u00072\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u00106\u001a\u00020\u00102\n\b\u0002\u0010,\u001a\u0004\u0018\u00010&H\u0002¢\u0006\u0002\u00107J\u0012\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010\u0007H\u0002J\u0018\u0010;\u001a\u00020\u00072\b\b\u0002\u0010<\u001a\u00020\u0010H\u0082@¢\u0006\u0002\u0010=J\u0012\u0010>\u001a\u0002092\b\u0010?\u001a\u0004\u0018\u00010\u0007H\u0002JT\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070A2\u0006\u0010/\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\b\b\u0002\u00101\u001a\u00020\u00072\b\b\u0002\u00100\u001a\u00020\u00072\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010B\u001a\u00020\u0010H\u0082@¢\u0006\u0002\u0010CJ\u0014\u0010D\u001a\u0004\u0018\u00010\u00072\b\u0010E\u001a\u0004\u0018\u00010\u0007H\u0002J\u000e\u0010K\u001a\u00020\u00102\u0006\u0010L\u001a\u00020MJ\u001e\u0010I\u001a\u00020N2\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020RH\u0096@¢\u0006\u0002\u0010SJ\u001e\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020\u00072\u0006\u0010O\u001a\u00020PH\u0096@¢\u0006\u0002\u0010WJ\u0016\u0010X\u001a\u00020Y2\u0006\u00102\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010ZJF\u0010[\u001a\u00020\u00102\u0006\u0010\\\u001a\u00020\u00072\u0006\u0010]\u001a\u00020\u00102\u0012\u0010^\u001a\u000e\u0012\u0004\u0012\u00020`\u0012\u0004\u0012\u0002090_2\u0012\u0010a\u001a\u000e\u0012\u0004\u0012\u00020b\u0012\u0004\u0012\u0002090_H\u0096@¢\u0006\u0002\u0010cR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\t\"\u0004\b\u0015\u0010\u000bR\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010 \u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\tR\u000e\u0010\"\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010F\u001a\b\u0012\u0004\u0012\u00020H0GX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010J¨\u0006e"}, d2 = {"Lcom/MovieBox/MovieBoxProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "sharedPref", "Landroid/content/SharedPreferences;", "<init>", "(Landroid/content/SharedPreferences;)V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "secretKeyDefault", "secretKeyAlt", "random", "Ljava/security/SecureRandom;", "generateDeviceId", "deviceId", "getDeviceId", "modernUserAgent", "modernClientInfo", "PREF_TOKEN_KEY", "tokenTimestamp", "", "md5", "input", "", "reverseString", "generateXClientToken", "hardcodedTimestamp", "(Ljava/lang/Long;)Ljava/lang/String;", "buildCanonicalString", "method", "accept", "contentType", "url", "body", "timestamp", "generateXTrSignature", "useAltKey", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Long;)Ljava/lang/String;", "saveToken", "", "token", "fetchAnonymousToken", "forceRefresh", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "persistTokenFromXUser", "xUserHeader", "buildAuthHeaders", "", "useToken", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "extractPolicyResource", "signCookie", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "isNsfwItem", "item", "Lcom/fasterxml/jackson/databind/JsonNode;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "Lcom/lagradost/cloudstream3/SearchResponseList;", "query", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "MovieBoxProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMovieBoxProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MovieBoxProvider.kt\ncom/MovieBox/MovieBoxProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 5 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 6 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,1233:1\n1795#2,10:1234\n2068#2:1244\n2069#2:1246\n1805#2:1247\n1221#2:1248\n1739#2:1249\n1814#2,3:1250\n1960#2,3:1253\n1960#2,3:1256\n1960#2,3:1259\n1960#2,3:1262\n2068#2,2:1265\n1795#2,10:1267\n2068#2:1277\n2069#2:1279\n1805#2:1280\n1849#2,8:1281\n1795#2,10:1289\n2068#2:1299\n2069#2:1301\n1805#2:1302\n1849#2,8:1303\n1739#2:1311\n1814#2,3:1312\n2068#2,2:1315\n2068#2:1317\n2069#2:1325\n2068#2:1327\n296#2,2:1328\n2069#2:1337\n1#3:1245\n1#3:1278\n1#3:1300\n1#3:1330\n460#4,7:1318\n221#5:1326\n222#5:1338\n437#6:1331\n513#6,5:1332\n*S KotlinDebug\n*F\n+ 1 MovieBoxProvider.kt\ncom/MovieBox/MovieBoxProvider\n*L\n142#1:1234,10\n142#1:1244\n142#1:1246\n142#1:1247\n146#1:1248\n353#1:1249\n353#1:1250,3\n360#1:1253,3\n369#1:1256,3\n373#1:1259,3\n378#1:1262,3\n407#1:1265,2\n458#1:1267,10\n458#1:1277\n458#1:1279\n458#1:1280\n477#1:1281,8\n587#1:1289,10\n587#1:1299\n587#1:1301\n587#1:1302\n599#1:1303,8\n603#1:1311\n603#1:1312,3\n647#1:1315,2\n669#1:1317\n669#1:1325\n684#1:1327\n686#1:1328,2\n684#1:1337\n142#1:1245\n458#1:1278\n587#1:1300\n673#1:1318,7\n683#1:1326\n683#1:1338\n703#1:1331\n703#1:1332,5\n*E\n"})
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

    /* JADX INFO: renamed from: com.MovieBox.MovieBoxProvider$buildAuthHeaders$1 */
    /* JADX INFO: compiled from: MovieBoxProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.MovieBox.MovieBoxProvider", f = "MovieBoxProvider.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {269}, m = "buildAuthHeaders", n = {"method", "url", "contentType", "accept", "body", "xClientToken", "xTrSig", "map", "useToken", "ts"}, nl = {270}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0", "J$0"}, v = 2)
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
    @DebugMetadata(c = "com.MovieBox.MovieBoxProvider", f = "MovieBoxProvider.kt", i = {0, 0, 0, 0, 0, 0}, l = {224}, m = "fetchAnonymousToken", n = {"rankUrl", "xClientToken", "xTrSig", "headers", "forceRefresh", "ts"}, nl = {225}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "J$0"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        long J$0;
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
    @DebugMetadata(c = "com.MovieBox.MovieBoxProvider", f = "MovieBoxProvider.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7}, l = {425, 427, 432, 434, 442, 444, 447, 449}, m = "getMainPage", n = {"request", "url", "data1", "listParts", "channelId", "options", "classify", "country", "year", "genre", "sort", "jsonBody", "page", "perPage", "hideNsfw", "isRanking", "request", "url", "data1", "listParts", "channelId", "options", "classify", "country", "year", "genre", "sort", "jsonBody", "page", "perPage", "hideNsfw", "isRanking", "request", "url", "data1", "listParts", "channelId", "options", "classify", "country", "year", "genre", "sort", "jsonBody", "headers", "requestBody", "page", "perPage", "hideNsfw", "isRanking", "request", "url", "data1", "listParts", "channelId", "options", "classify", "country", "year", "genre", "sort", "jsonBody", "headers", "requestBody", "page", "perPage", "hideNsfw", "isRanking", "request", "url", "data1", "listParts", "channelId", "options", "classify", "country", "year", "genre", "sort", "jsonBody", "headers", "requestBody", "response", "page", "perPage", "hideNsfw", "isRanking", "request", "url", "data1", "listParts", "channelId", "options", "classify", "country", "year", "genre", "sort", "jsonBody", "headers", "requestBody", "response", "page", "perPage", "hideNsfw", "isRanking", "request", "url", "data1", "listParts", "channelId", "options", "classify", "country", "year", "genre", "sort", "jsonBody", "headers", "requestBody", "response", "page", "perPage", "hideNsfw", "isRanking", "request", "url", "data1", "listParts", "channelId", "options", "classify", "country", "year", "genre", "sort", "jsonBody", "headers", "requestBody", "response", "page", "perPage", "hideNsfw", "isRanking"}, nl = {427, 424, 434, 431, 444, 441, 449, 446}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "I$0", "I$1", "I$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "I$0", "I$1", "I$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "I$0", "I$1", "I$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "I$0", "I$1", "I$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "I$0", "I$1", "I$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "I$0", "I$1", "I$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "I$0", "I$1", "I$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "I$0", "I$1", "I$2", "Z$0"}, v = 2)
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
        boolean Z$0;
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
    @DebugMetadata(c = "com.MovieBox.MovieBoxProvider", f = "MovieBoxProvider.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, l = {549, 550, 556, 557, 622, 628, 636, 658, 659, 735, 750}, m = "load", n = {"url", "id", "finalUrl", "url", "id", "finalUrl", "headers", "url", "id", "finalUrl", "headers", "response", "url", "id", "finalUrl", "headers", "response", "url", "id", "finalUrl", "headers", "response", "body", "mapper", "root", "data", "title", "description", "releaseDate", "duration", "genre", "imdbRating", "year", "coverUrl", "backgroundUrl", "actors", "tags", "durationMinutes", "type", "subjectType", "url", "id", "finalUrl", "headers", "response", "body", "mapper", "root", "data", "title", "description", "releaseDate", "duration", "genre", "imdbRating", "year", "coverUrl", "backgroundUrl", "actors", "tags", "durationMinutes", "type", "tmdbId", "imdbId", "subjectType", "url", "id", "finalUrl", "headers", "response", "body", "mapper", "root", "data", "title", "description", "releaseDate", "duration", "genre", "imdbRating", "year", "coverUrl", "backgroundUrl", "actors", "tags", "durationMinutes", "type", "tmdbId", "imdbId", "logoUrl", "subjectType", "url", "id", "finalUrl", "headers", "response", "body", "mapper", "root", "data", "title", "description", "releaseDate", "duration", "genre", "imdbRating", "year", "coverUrl", "backgroundUrl", "actors", "tags", "durationMinutes", "type", "tmdbId", "imdbId", "logoUrl", "meta", "metaVideos", "Poster", "Background", "Description", "IMDBRating", "allSubjectIds", "episodeMap", "subjectId", "seasonUrl", "subjectType", "url", "id", "finalUrl", "headers", "response", "body", "mapper", "root", "data", "title", "description", "releaseDate", "duration", "genre", "imdbRating", "year", "coverUrl", "backgroundUrl", "actors", "tags", "durationMinutes", "type", "tmdbId", "imdbId", "logoUrl", "meta", "metaVideos", "Poster", "Background", "Description", "IMDBRating", "allSubjectIds", "episodeMap", "subjectId", "seasonUrl", "seasonHeaders", "subjectType", "url", "id", "finalUrl", "headers", "response", "body", "mapper", "root", "data", "title", "description", "releaseDate", "duration", "genre", "imdbRating", "year", "coverUrl", "backgroundUrl", "actors", "tags", "durationMinutes", "type", "tmdbId", "imdbId", "logoUrl", "meta", "metaVideos", "Poster", "Background", "Description", "IMDBRating", "allSubjectIds", "episodeMap", "episodes", "subjectType", "url", "id", "finalUrl", "headers", "response", "body", "mapper", "root", "data", "title", "description", "releaseDate", "duration", "genre", "imdbRating", "year", "coverUrl", "backgroundUrl", "actors", "tags", "durationMinutes", "type", "tmdbId", "imdbId", "logoUrl", "meta", "metaVideos", "Poster", "Background", "Description", "IMDBRating", "subjectType"}, nl = {550, 553, 557, 560, 628, 636, 637, 659, 660, 750, -1}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$28", "L$29", "L$30", "L$31", "L$32", "L$34", "L$35", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$28", "L$29", "L$30", "L$31", "L$32", "L$34", "L$35", "L$36", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$28", "L$29", "L$30", "L$31", "L$32", "L$33", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$28", "L$29", "L$30", "I$0"}, v = 2)
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
    @DebugMetadata(c = "com.MovieBox.MovieBoxProvider", f = "MovieBoxProvider.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}, l = {791, 792, 795, 796, 797, 826}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "parts", "originalSubjectId", "subjectUrl", "isCasting", "season", "episode", "data", "subtitleCallback", "callback", "parts", "originalSubjectId", "subjectUrl", "subjectHeaders", "isCasting", "season", "episode", "data", "subtitleCallback", "callback", "parts", "originalSubjectId", "subjectUrl", "subjectHeaders", "subjectResponse", "isCasting", "season", "episode", "data", "subtitleCallback", "callback", "parts", "originalSubjectId", "subjectUrl", "subjectHeaders", "subjectResponse", "isCasting", "season", "episode", "data", "subtitleCallback", "callback", "parts", "originalSubjectId", "subjectUrl", "subjectHeaders", "subjectResponse", "isCasting", "season", "episode", "data", "subtitleCallback", "callback", "parts", "originalSubjectId", "subjectUrl", "subjectHeaders", "subjectResponse", "subjectIds", "originalLanguageName", "isCasting", "season", "episode"}, nl = {792, 794, 796, 797, 800, 976}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "Z$0", "I$0", "I$1"}, v = 2)
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
    @DebugMetadata(c = "com.MovieBox.MovieBoxProvider", f = "MovieBoxProvider.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3}, l = {495, 496, 501, 502}, m = "search", n = {"query", "url", "jsonBody", "requestBody", "page", "hideNsfw", "query", "url", "jsonBody", "requestBody", "headers", "page", "hideNsfw", "query", "url", "jsonBody", "requestBody", "headers", "response", "page", "hideNsfw", "query", "url", "jsonBody", "requestBody", "headers", "response", "page", "hideNsfw"}, nl = {496, 498, 502, 505}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1"}, v = 2)
    static final class C00081 extends ContinuationImpl {
        int I$0;
        int I$1;
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
        this.mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("r|0|9167640870324258216", "Trending Movies"), TuplesKt.to("r|0|5692654647815587592", "In Cinema"), TuplesKt.to("r|0|414907768299210008", "Bollywood"), TuplesKt.to("r|0|3859721901924910512", "South Indian"), TuplesKt.to("r|0|8019599703232971616", "Hollywood"), TuplesKt.to("r|0|1488104699998914056", "New Release"), TuplesKt.to("r|0|6027735606879570952", "New Punjabi"), TuplesKt.to("r|0|6144409817256968824", "New Bengali"), TuplesKt.to("r|5|719331337777440448", "Top Series"), TuplesKt.to("r|5|4903182713986896328", "Indian Drama"), TuplesKt.to("r|5|1255898847918934600", "Reality TV"), TuplesKt.to("r|5|1976033493293449744", "Asian Drama"), TuplesKt.to("r|5|3910636007619709856", "Western TV"), TuplesKt.to("r|5|5177200225164885656", "Turkish Drama"), TuplesKt.to("1|1", "Movies"), TuplesKt.to("1|2", "Series"), TuplesKt.to("1|1006", "Anime"), TuplesKt.to("2|2;country=Japan;genre=Animation", "Anime (Series)"), TuplesKt.to("1|1;country=India", "Indian (Movies)"), TuplesKt.to("1|2;country=India", "Indian (Series)"), TuplesKt.to("1|1;classify=Hindi dub;country=United States", "USA (Movies)"), TuplesKt.to("1|2;classify=Hindi dub;country=United States", "USA (Series)"), TuplesKt.to("1|1;country=Japan", "Japan (Movies)"), TuplesKt.to("1|2;country=Japan", "Japan (Series)"), TuplesKt.to("1|1;country=China", "China (Movies)"), TuplesKt.to("1|2;country=China", "China (Series)"), TuplesKt.to("1|1;country=Philippines", "Philippines (Movies)"), TuplesKt.to("1|2;country=Philippines", "Philippines (Series)"), TuplesKt.to("1|1;country=Thailand", "Thailand(Movies)"), TuplesKt.to("1|2;country=Thailand", "Thailand(Series)"), TuplesKt.to("1|1;country=Nigeria", "Nollywood (Movies)"), TuplesKt.to("1|2;country=Nigeria", "Nollywood (Series)"), TuplesKt.to("1|1;country=Korea", "South Korean (Movies)"), TuplesKt.to("1|2;country=Korea", "South Korean (Series)"), TuplesKt.to("1|1;classify=Hindi dub;genre=Action", "Action (Movies)"), TuplesKt.to("1|1;classify=Hindi dub;genre=Crime", "Crime (Movies)"), TuplesKt.to("1|1;classify=Hindi dub;genre=Comedy", "Comedy (Movies)"), TuplesKt.to("1|2;classify=Hindi dub;genre=Crime", "Crime (Series)"), TuplesKt.to("1|2;classify=Hindi dub;genre=Comedy", "Comedy (Series)")});
    }

    public /* synthetic */ MovieBoxProvider(SharedPreferences sharedPreferences, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : sharedPreferences);
    }

    /* JADX INFO: compiled from: MovieBoxProvider.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006J\u0010\u0010\u0011\u001a\u00020\u00122\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/MovieBox/MovieBoxProvider$Companion;", "", "<init>", "()V", "HOST_POOL", "", "", "getHOST_POOL", "()Ljava/util/List;", "bearerToken", "getBearerToken", "()Ljava/lang/String;", "setBearerToken", "(Ljava/lang/String;)V", "decodeJwtExpiry", "", "token", "isTokenValid", "", "MovieBoxProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nMovieBoxProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MovieBoxProvider.kt\ncom/MovieBox/MovieBoxProvider$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1233:1\n1#2:1234\n*E\n"})
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
    /* JADX WARN: Code duplicated, block: B:44:0x0191  */
    /* JADX WARN: Code duplicated, block: B:46:0x0194 A[Catch: Exception -> 0x01c7, TryCatch #3 {Exception -> 0x01c7, blocks: (B:38:0x0177, B:40:0x0188, B:46:0x0194, B:48:0x01a4, B:49:0x01aa, B:51:0x01b1, B:55:0x01bb, B:57:0x01bf), top: B:78:0x0177 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x01a4 A[Catch: Exception -> 0x01c7, TryCatch #3 {Exception -> 0x01c7, blocks: (B:38:0x0177, B:40:0x0188, B:46:0x0194, B:48:0x01a4, B:49:0x01aa, B:51:0x01b1, B:55:0x01bb, B:57:0x01bf), top: B:78:0x0177 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:55:0x01bb A[Catch: Exception -> 0x01c7, TryCatch #3 {Exception -> 0x01c7, blocks: (B:38:0x0177, B:40:0x0188, B:46:0x0194, B:48:0x01a4, B:49:0x01aa, B:51:0x01b1, B:55:0x01bb, B:57:0x01bf), top: B:78:0x0177 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:70:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    /* JADX WARN: Code duplicated, block: B:80:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:81:? A[RETURN, SYNTHETIC] */
    public final Object fetchAnonymousToken(boolean forceRefresh, Continuation<? super String> continuation) {
        C00011 c00011;
        String strAsText;
        String str;
        String xUser;
        String str2;
        boolean z;
        String tok;
        JsonNode jsonNode;
        String tok2;
        String str3;
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
                if (!forceRefresh) {
                    if (INSTANCE.isTokenValid(bearerToken)) {
                        String str4 = bearerToken;
                        Intrinsics.checkNotNull(str4);
                        return str4;
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
                    strAsText = null;
                    String xTrSig = generateXTrSignature$default(this, "GET", "application/json", "application/json", "https://apig.inmoviebox.com/wefeed-mobile-bff/tab/ranking-list?tabId=0&categoryType=4516404531735022304&page=1&perPage=1", null, false, Boxing.boxLong(ts), 48, null);
                    Map headers = MapsKt.mapOf(new Pair[]{TuplesKt.to("user-agent", this.modernUserAgent), TuplesKt.to("accept", "application/json"), TuplesKt.to("content-type", "application/json"), TuplesKt.to("connection", "keep-alive"), TuplesKt.to("x-client-token", xClientToken), TuplesKt.to("x-tr-signature", xTrSig), TuplesKt.to("x-client-info", this.modernClientInfo), TuplesKt.to("x-client-status", "0")});
                    Requests app = MainActivityKt.getApp();
                    c00012.L$0 = SpillingKt.nullOutSpilledVariable("https://apig.inmoviebox.com/wefeed-mobile-bff/tab/ranking-list?tabId=0&categoryType=4516404531735022304&page=1&perPage=1");
                    c00012.L$1 = SpillingKt.nullOutSpilledVariable(xClientToken);
                    c00012.L$2 = SpillingKt.nullOutSpilledVariable(xTrSig);
                    c00012.L$3 = SpillingKt.nullOutSpilledVariable(headers);
                    c00012.Z$0 = forceRefresh;
                    c00012.J$0 = ts;
                    c00012.label = 1;
                    try {
                        Object obj = Requests.get$default(app, "https://apig.inmoviebox.com/wefeed-mobile-bff/tab/ranking-list?tabId=0&categoryType=4516404531735022304&page=1&perPage=1", headers, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00012, 4092, (Object) null);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result = obj;
                        try {
                            NiceResponse resp = (NiceResponse) $result;
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
                                    strAsText = jsonNode.asText();
                                }
                                tok2 = strAsText;
                                str3 = tok2;
                                if (!(str3 != null || StringsKt.isBlank(str3))) {
                                    saveToken(tok2);
                                    return tok2;
                                }
                            }
                            tok = bearerToken;
                            if (tok == null) {
                                return "";
                            }
                            return tok;
                        } catch (Exception e) {
                            str = bearerToken;
                            if (str == null) {
                                return "";
                            }
                            return str;
                        }
                    } catch (Exception e2) {
                        str = bearerToken;
                        if (str == null) {
                            return "";
                        }
                        return str;
                    }
                } catch (Exception e3) {
                }
                break;
            case 1:
                long j = c00012.J$0;
                boolean z2 = c00012.Z$0;
                try {
                    ResultKt.throwOnFailure($result);
                    strAsText = null;
                    NiceResponse resp2 = (NiceResponse) $result;
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
                            strAsText = jsonNode.asText();
                        }
                        tok2 = strAsText;
                        str3 = tok2;
                        if (!(str3 != null || StringsKt.isBlank(str3))) {
                            saveToken(tok2);
                            return tok2;
                        }
                    }
                    tok = bearerToken;
                    if (tok == null) {
                        return "";
                    }
                    return tok;
                } catch (Exception e4) {
                    str = bearerToken;
                    if (str == null) {
                        return "";
                    }
                    return str;
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

    /* JADX WARN: Code duplicated, block: B:11:0x002d  */
    /* JADX WARN: Code duplicated, block: B:22:0x0090  */
    public final boolean isNsfwItem(@NotNull JsonNode item) {
        String genre;
        String title;
        boolean z;
        boolean z2;
        String genre2;
        String title2;
        boolean z3;
        int $i$f$any;
        boolean z4;
        String strAsText;
        String strAsText2;
        String strAsText3;
        if (MainAPI.Companion.getSettingsForProvider().getEnableAdult()) {
            return false;
        }
        JsonNode jsonNode = item.get("genre");
        String contentRating = "";
        if (jsonNode == null || (strAsText3 = jsonNode.asText()) == null) {
            genre = "";
        } else {
            genre = strAsText3.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(genre, "toLowerCase(...)");
            if (genre == null) {
                genre = "";
            }
        }
        Iterable $this$map$iv = StringsKt.split$default(genre, new String[]{","}, false, 0, 6, (Object) null);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            String it = (String) item$iv$iv;
            destination$iv$iv.add(StringsKt.trim(it).toString());
        }
        Iterable genreTokens = (List) destination$iv$iv;
        JsonNode jsonNode2 = item.get("title");
        if (jsonNode2 == null || (strAsText2 = jsonNode2.asText()) == null) {
            title = "";
        } else {
            title = strAsText2.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(title, "toLowerCase(...)");
            if (title == null) {
                title = "";
            }
        }
        JsonNode jsonNode3 = item.get("subjectType");
        int subjectType = jsonNode3 != null ? jsonNode3.asInt() : 1;
        JsonNode jsonNode4 = item.get("restrictKid");
        int restrictKid = jsonNode4 != null ? jsonNode4.asInt() : 0;
        JsonNode jsonNode5 = item.get("contentRating");
        if (jsonNode5 != null && (strAsText = jsonNode5.asText()) != null) {
            contentRating = strAsText;
        }
        List adultGenres = CollectionsKt.listOf(new String[]{"adult", "erotic", "erotica", "hot"});
        Iterable $this$any$iv = genreTokens;
        if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
            Iterator it2 = $this$any$iv.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z = true;
                    z2 = false;
                    break;
                }
                Object element$iv = it2.next();
                z = true;
                String it3 = (String) element$iv;
                if (adultGenres.contains(it3)) {
                    z2 = true;
                    break;
                }
            }
        } else {
            z2 = false;
            z = true;
        }
        if (z2 || new Regex("\\bsex\\b").containsMatchIn(title)) {
            return z;
        }
        Iterable adultKeywords = CollectionsKt.listOf(new String[]{"porn", "hentai", "xxx", "seduced", "nude", "naked", "erotica", "vivamax", "ullu", "charmsukh", "kooku", "primeplay", "bhabhi", "bhabhiji", "x-rated", "سكس", "جنس"});
        Iterable $this$any$iv2 = adultKeywords;
        if (($this$any$iv2 instanceof Collection) && ((Collection) $this$any$iv2).isEmpty()) {
            genre2 = genre;
            title2 = title;
            z3 = false;
        } else {
            Iterator it4 = $this$any$iv2.iterator();
            while (true) {
                if (!it4.hasNext()) {
                    genre2 = genre;
                    title2 = title;
                    z3 = false;
                    break;
                }
                Object element$iv2 = it4.next();
                String it5 = (String) element$iv2;
                genre2 = genre;
                title2 = title;
                if (StringsKt.contains$default(title, it5, false, 2, (Object) null)) {
                    z3 = true;
                    break;
                }
                genre = genre2;
                title = title2;
            }
        }
        if (z3) {
            return z;
        }
        boolean isMatureRating = StringsKt.equals(contentRating, "R", true) || StringsKt.equals(contentRating, "TV-MA", true);
        if (restrictKid == 1 && isMatureRating) {
            Iterable $this$any$iv3 = genreTokens;
            if (!($this$any$iv3 instanceof Collection) || !((Collection) $this$any$iv3).isEmpty()) {
                Iterator it6 = $this$any$iv3.iterator();
                while (true) {
                    if (!it6.hasNext()) {
                        z4 = false;
                        break;
                    }
                    Object element$iv3 = it6.next();
                    String it7 = (String) element$iv3;
                    if (CollectionsKt.listOf(new String[]{"romance", "erotic", "hot", "drama"}).contains(it7)) {
                        z4 = true;
                        break;
                    }
                }
            } else {
                z4 = false;
            }
            if (z4) {
                return true;
            }
        }
        if (subjectType != 7) {
            return false;
        }
        if (!StringsKt.contains$default(genre2, "romance", false, 2, (Object) null) && !StringsKt.contains$default(genre2, "drama", false, 2, (Object) null)) {
            return false;
        }
        List provocativeWords = CollectionsKt.listOf(new String[]{"pleasure", "seductive", "naked", "escort", "affair", "lover", "mistress", "sensual"});
        List $this$any$iv4 = provocativeWords;
        if (($this$any$iv4 instanceof Collection) && $this$any$iv4.isEmpty()) {
            $i$f$any = 0;
        } else {
            for (Object element$iv4 : $this$any$iv4) {
                String it8 = (String) element$iv4;
                boolean isMatureRating2 = isMatureRating;
                List provocativeWords2 = provocativeWords;
                Iterable $this$any$iv5 = $this$any$iv4;
                if (StringsKt.contains$default(title2, it8, false, 2, (Object) null)) {
                    $i$f$any = 1;
                } else {
                    isMatureRating = isMatureRating2;
                    provocativeWords = provocativeWords2;
                    $this$any$iv4 = $this$any$iv5;
                }
            }
            $i$f$any = 0;
        }
        return $i$f$any != 0;
    }

    /* JADX WARN: Code duplicated, block: B:105:0x0909  */
    /* JADX WARN: Code duplicated, block: B:107:0x098e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:108:0x098f  */
    /* JADX WARN: Code duplicated, block: B:110:0x09c6  */
    /* JADX WARN: Code duplicated, block: B:112:0x0a40 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:113:0x0a41  */
    /* JADX WARN: Code duplicated, block: B:117:0x0a75  */
    /* JADX WARN: Code duplicated, block: B:119:0x0aff A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:120:0x0b00  */
    /* JADX WARN: Code duplicated, block: B:122:0x0b2b  */
    /* JADX WARN: Code duplicated, block: B:124:0x0bbf A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:125:0x0bc0  */
    /* JADX WARN: Code duplicated, block: B:131:0x0c04  */
    /* JADX WARN: Code duplicated, block: B:137:0x0c16  */
    /* JADX WARN: Code duplicated, block: B:140:0x0c1e A[Catch: Exception -> 0x0c0f, TRY_ENTER, TryCatch #0 {Exception -> 0x0c0f, blocks: (B:132:0x0c06, B:140:0x0c1e, B:143:0x0c29), top: B:208:0x0c06 }] */
    /* JADX WARN: Code duplicated, block: B:141:0x0c25  */
    /* JADX WARN: Code duplicated, block: B:143:0x0c29 A[Catch: Exception -> 0x0c0f, TRY_LEAVE, TryCatch #0 {Exception -> 0x0c0f, blocks: (B:132:0x0c06, B:140:0x0c1e, B:143:0x0c29), top: B:208:0x0c06 }] */
    /* JADX WARN: Code duplicated, block: B:148:0x0c54 A[Catch: Exception -> 0x0d6c, TryCatch #1 {Exception -> 0x0d6c, blocks: (B:145:0x0c35, B:146:0x0c4e, B:148:0x0c54, B:151:0x0c77, B:153:0x0c7f, B:138:0x0c18), top: B:210:0x0c18 }] */
    /* JADX WARN: Code duplicated, block: B:150:0x0c6e  */
    /* JADX WARN: Code duplicated, block: B:151:0x0c77 A[Catch: Exception -> 0x0d6c, TryCatch #1 {Exception -> 0x0d6c, blocks: (B:145:0x0c35, B:146:0x0c4e, B:148:0x0c54, B:151:0x0c77, B:153:0x0c7f, B:138:0x0c18), top: B:210:0x0c18 }] */
    /* JADX WARN: Code duplicated, block: B:153:0x0c7f A[Catch: Exception -> 0x0d6c, TryCatch #1 {Exception -> 0x0d6c, blocks: (B:145:0x0c35, B:146:0x0c4e, B:148:0x0c54, B:151:0x0c77, B:153:0x0c7f, B:138:0x0c18), top: B:210:0x0c18 }] */
    /* JADX WARN: Code duplicated, block: B:182:0x0cfa  */
    /* JADX WARN: Code duplicated, block: B:186:0x0d0a  */
    /* JADX WARN: Code duplicated, block: B:191:0x0d41 A[Catch: Exception -> 0x0d6a, TryCatch #2 {Exception -> 0x0d6a, blocks: (B:185:0x0d03, B:157:0x0c8f, B:160:0x0c97, B:162:0x0ca1, B:165:0x0ca8, B:167:0x0cb0, B:169:0x0cb8, B:171:0x0cbe, B:173:0x0cc6, B:175:0x0ccc, B:176:0x0ccf, B:180:0x0cde, B:177:0x0cd2, B:178:0x0cd7, B:188:0x0d1a, B:189:0x0d3b, B:191:0x0d41, B:193:0x0d5b, B:195:0x0d64), top: B:212:0x0d03 }] */
    /* JADX WARN: Code duplicated, block: B:205:0x0d7c  */
    /* JADX WARN: Code duplicated, block: B:212:0x0d03 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:219:0x0d61 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:221:0x0d5b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x001e  */
    /* JADX WARN: Code duplicated, block: B:81:0x0782  */
    /* JADX WARN: Code duplicated, block: B:83:0x080f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:84:0x0810  */
    /* JADX WARN: Code duplicated, block: B:86:0x0830  */
    /* JADX WARN: Code duplicated, block: B:88:0x08b3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:89:0x08b4  */
    /* JADX WARN: Code duplicated, block: B:93:0x08de  */
    /* JADX WARN: Code duplicated, block: B:99:0x08f4  */
    @Nullable
    public Object getMainPage(int i, @NotNull MainPageRequest mainPageRequest, @NotNull Continuation<? super HomePageResponse> continuation) {
        C00021 c00021;
        String str;
        List list;
        String str2;
        Object obj;
        String str3;
        String str4;
        JsonNode jsonNode;
        int i2;
        String str5;
        boolean z;
        String str6;
        int i3;
        String str7;
        String str8;
        String str9;
        String str10;
        Map map;
        String str11;
        String str12;
        boolean z2;
        int i4;
        String str13;
        Object objBuildAuthHeaders$default;
        int i5;
        String str14;
        String str15;
        Map map2;
        String str16;
        String str17;
        String str18;
        String str19;
        int i6;
        int i7;
        Map map3;
        int i8;
        MainPageRequest mainPageRequest2;
        boolean z3;
        String str20;
        String str21;
        Map map4;
        String str22;
        List list2;
        String str23;
        String str24;
        String str25;
        List list3;
        String str26;
        RequestBody requestBodyCreate;
        int i9;
        Object obj2;
        MainPageRequest mainPageRequest3;
        String str27;
        List list4;
        String str28;
        int i10;
        String str29;
        boolean z4;
        String str30;
        RequestBody requestBody;
        String str31;
        String str32;
        Object obj3;
        String str33;
        RequestBody requestBody2;
        MainPageRequest mainPageRequest4;
        String str34;
        String str35;
        Object obj4;
        String str36;
        boolean z5;
        MainPageRequest mainPageRequest5;
        String str37;
        int i11;
        Map map5;
        RequestBody requestBody3;
        NiceResponse niceResponse;
        String str38;
        NiceResponse niceResponse2;
        SharedPreferences sharedPreferences;
        Map map6;
        String str39;
        String str40;
        boolean z6;
        int i12;
        int i13;
        RequestBody requestBody4;
        Object obj5;
        String str41;
        Object objBuildAuthHeaders$default2;
        int i14;
        String str42;
        String str43;
        RequestBody requestBody5;
        Map map7;
        NiceResponse niceResponse3;
        String str44;
        String str45;
        Object obj6;
        Map map8;
        int i15;
        RequestBody requestBody6;
        String str46;
        Map map9;
        String str47;
        boolean z7;
        Object objBuildAuthHeaders$default3;
        int i16;
        String str48;
        Map map10;
        int i17;
        RequestBody requestBody7;
        Map map11;
        String str49;
        NiceResponse niceResponse4;
        String str50;
        Object obj7;
        String str51;
        SharedPreferences.Editor editorEdit;
        SharedPreferences.Editor editorRemove;
        String str52;
        int i18;
        int i19;
        NiceResponse niceResponse5;
        String str53;
        Map map12;
        Map map13;
        String str54;
        int i20;
        String str55;
        int i21;
        String str56;
        RequestBody requestBody8;
        MainPageRequest mainPageRequest6;
        String str57;
        String str58;
        String str59;
        boolean z8;
        String str60;
        String str61;
        List list5;
        Map map14;
        int i22;
        MainPageRequest mainPageRequest7;
        RequestBody requestBody9;
        String str62;
        int i23;
        RequestBody requestBody10;
        int i24;
        int i25;
        boolean z9;
        String str63;
        int i26;
        MainPageRequest mainPageRequest8;
        String str64;
        int i27;
        int i28;
        String str65;
        Map map15;
        NiceResponse niceResponse6;
        int i29;
        String str66;
        int i30;
        RequestBody requestBody11;
        int i31;
        ArrayList arrayListEmptyList;
        JsonNode jsonNode2;
        JsonNode jsonNode3;
        JsonNode jsonNode4;
        Iterable<JsonNode> iterable;
        ArrayList arrayList;
        ArrayList arrayList2;
        HashSet hashSet;
        ArrayList arrayList3;
        JsonNode jsonNode5;
        Iterable iterable2;
        int i32;
        String str67;
        MovieSearchResponse movieSearchResponseNewMovieSearchResponse$default;
        String strAsText;
        String strAsText2;
        TvType tvType;
        JsonNode jsonNode6;
        ArrayList arrayList4;
        MovieBoxProvider movieBoxProvider = this;
        int i33 = i;
        MainPageRequest mainPageRequest9 = mainPageRequest;
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
        Object objPost$default = c00022.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00022.label) {
            case 0:
                ResultKt.throwOnFailure(objPost$default);
                DonationManager.INSTANCE.checkAndShow(movieBoxProvider.getName());
                int i34 = !MainAPI.Companion.getSettingsForProvider().getEnableAdult() ? 1 : 0;
                boolean zStartsWith$default = StringsKt.startsWith$default(mainPageRequest9.getData(), "r|", false, 2, (Object) null);
                if (zStartsWith$default) {
                    List listSplit$default = StringsKt.split$default(mainPageRequest9.getData(), new String[]{"|"}, false, 0, 6, (Object) null);
                    String str68 = (String) CollectionsKt.getOrNull(listSplit$default, 1);
                    if (str68 == null) {
                        str68 = "0";
                    }
                    String str69 = (String) CollectionsKt.getOrNull(listSplit$default, 2);
                    if (str69 == null) {
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), (Boolean) null, 2, (Object) null);
                    }
                    str = getMainUrl() + "/wefeed-mobile-bff/tab/ranking-list?tabId=" + str68 + "&categoryType=" + str69 + "&page=" + i33 + "&perPage=20&restrictKid=" + i34;
                } else {
                    str = getMainUrl() + "/wefeed-mobile-bff/subject-api/list";
                }
                String data = mainPageRequest9.getData();
                List listSplit$default2 = StringsKt.split$default(StringsKt.substringBefore$default(data, ";", (String) null, 2, (Object) null), new String[]{"|"}, false, 0, 6, (Object) null);
                String str70 = (String) CollectionsKt.getOrNull(listSplit$default2, 1);
                list = listSplit$default2;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                List listSplit$default3 = StringsKt.split$default(StringsKt.substringAfter(data, ";", ""), new String[]{";"}, false, 0, 6, (Object) null);
                int i35 = 0;
                Iterator it = listSplit$default3.iterator();
                while (it.hasNext()) {
                    String str71 = data;
                    List listSplit$default4 = StringsKt.split$default((String) it.next(), new String[]{"="}, false, 0, 6, (Object) null);
                    List list6 = listSplit$default3;
                    int i36 = i35;
                    Pair pair = TuplesKt.to(CollectionsKt.getOrNull(listSplit$default4, 0), CollectionsKt.getOrNull(listSplit$default4, 1));
                    String str72 = (String) pair.component1();
                    String str73 = (String) pair.component2();
                    String str74 = str72;
                    if (!(str74 == null || StringsKt.isBlank(str74))) {
                        String str75 = str73;
                        if (!(str75 == null || StringsKt.isBlank(str75))) {
                            linkedHashMap.put(str72, str73);
                        }
                    }
                    i35 = i36;
                    listSplit$default3 = list6;
                    data = str71;
                }
                str2 = data;
                String str76 = (String) linkedHashMap.get("classify");
                if (str76 == null) {
                    str76 = "All";
                }
                String str77 = str76;
                String str78 = (String) linkedHashMap.get("country");
                if (str78 == null) {
                    str78 = "All";
                }
                String str79 = (String) linkedHashMap.get("year");
                if (str79 == null) {
                    str79 = "All";
                }
                String str80 = (String) linkedHashMap.get("genre");
                if (str80 == null) {
                    str80 = "All";
                }
                obj = objPost$default;
                String str81 = (String) linkedHashMap.get("sort");
                if (str81 == null) {
                    str81 = "ForYou";
                }
                str3 = "data";
                String str82 = "{\"page\":" + i33 + ",\"perPage\":20,\"channelId\":\"" + str70 + "\",\"classify\":\"" + str77 + "\",\"country\":\"" + str78 + "\",\"year\":\"" + str79 + "\",\"genre\":\"" + str80 + "\",\"sort\":\"" + str81 + "\",\"restrictKid\":" + i34 + '}';
                if (zStartsWith$default) {
                    c00022.L$0 = mainPageRequest9;
                    c00022.L$1 = str;
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(list);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(str70);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(linkedHashMap);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(str77);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(str78);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(str79);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(str80);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(str81);
                    c00022.L$11 = str82;
                    c00022.I$0 = i33;
                    c00022.I$1 = 20;
                    c00022.I$2 = i34;
                    c00022.Z$0 = zStartsWith$default;
                    c00022.label = 1;
                    String str83 = str78;
                    String str84 = str80;
                    String str85 = str79;
                    str12 = str77;
                    String str86 = str81;
                    z2 = zStartsWith$default;
                    jsonNode = null;
                    i4 = i34;
                    str13 = str;
                    objBuildAuthHeaders$default = buildAuthHeaders$default(this, "GET", str13, null, null, null, false, c00022, 60, null);
                    if (objBuildAuthHeaders$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    i5 = 20;
                    str14 = str82;
                    str15 = str86;
                    map2 = linkedHashMap;
                    str8 = str83;
                    str16 = str84;
                    str17 = str70;
                    str10 = str85;
                    str18 = str14;
                    str19 = str16;
                    i6 = i4;
                    i7 = i33;
                    map3 = map2;
                    i8 = i5;
                    mainPageRequest2 = mainPageRequest9;
                    z3 = z2;
                    movieBoxProvider = this;
                    str20 = str15;
                    str21 = str12;
                    map4 = (Map) objBuildAuthHeaders$default;
                    str22 = str13;
                    list2 = list;
                    str23 = str17;
                    str24 = str2;
                    str25 = str24;
                    list3 = list2;
                    str26 = str23;
                    requestBodyCreate = RequestBody.Companion.create(str18, MediaType.Companion.get("application/json"));
                    if (z3) {
                        Requests app = MainActivityKt.getApp();
                        c00022.L$0 = mainPageRequest2;
                        c00022.L$1 = str22;
                        c00022.L$2 = SpillingKt.nullOutSpilledVariable(str25);
                        c00022.L$3 = SpillingKt.nullOutSpilledVariable(list3);
                        c00022.L$4 = SpillingKt.nullOutSpilledVariable(str26);
                        c00022.L$5 = SpillingKt.nullOutSpilledVariable(map3);
                        c00022.L$6 = SpillingKt.nullOutSpilledVariable(str21);
                        c00022.L$7 = SpillingKt.nullOutSpilledVariable(str8);
                        c00022.L$8 = SpillingKt.nullOutSpilledVariable(str10);
                        c00022.L$9 = SpillingKt.nullOutSpilledVariable(str19);
                        c00022.L$10 = SpillingKt.nullOutSpilledVariable(str20);
                        c00022.L$11 = str18;
                        c00022.L$12 = SpillingKt.nullOutSpilledVariable(map4);
                        c00022.L$13 = requestBodyCreate;
                        c00022.I$0 = i7;
                        c00022.I$1 = i8;
                        c00022.I$2 = i6;
                        c00022.Z$0 = z3;
                        c00022.label = 3;
                        obj3 = coroutine_suspended;
                        i9 = i8;
                        objPost$default = Requests.get$default(app, str22, map4, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                        if (objPost$default == obj3) {
                            return obj3;
                        }
                        str27 = str25;
                        list4 = list3;
                        str28 = str21;
                        str29 = str8;
                        str33 = str19;
                        str32 = str26;
                        requestBody2 = requestBodyCreate;
                        mainPageRequest4 = mainPageRequest2;
                        i10 = i7;
                        str34 = str18;
                        str35 = str34;
                        obj4 = obj3;
                        str36 = str22;
                        z5 = z3;
                        mainPageRequest5 = mainPageRequest4;
                        str37 = str10;
                        i11 = i6;
                        map5 = map3;
                        requestBody3 = requestBody2;
                        niceResponse = (NiceResponse) objPost$default;
                        str38 = str33;
                        niceResponse2 = niceResponse;
                        if (niceResponse2.getCode() != 401 || niceResponse2.getCode() == 441) {
                            bearerToken = jsonNode;
                            sharedPreferences = movieBoxProvider.sharedPref;
                            if (sharedPreferences != null && (editorEdit = sharedPreferences.edit()) != null && (editorRemove = editorEdit.remove(movieBoxProvider.PREF_TOKEN_KEY)) != null) {
                                editorRemove.apply();
                                Unit unit = Unit.INSTANCE;
                            }
                            if (!z5) {
                                c00022.L$0 = mainPageRequest5;
                                c00022.L$1 = str36;
                                c00022.L$2 = SpillingKt.nullOutSpilledVariable(str27);
                                c00022.L$3 = SpillingKt.nullOutSpilledVariable(list4);
                                c00022.L$4 = SpillingKt.nullOutSpilledVariable(str32);
                                c00022.L$5 = SpillingKt.nullOutSpilledVariable(map5);
                                c00022.L$6 = SpillingKt.nullOutSpilledVariable(str28);
                                c00022.L$7 = SpillingKt.nullOutSpilledVariable(str29);
                                c00022.L$8 = SpillingKt.nullOutSpilledVariable(str37);
                                c00022.L$9 = SpillingKt.nullOutSpilledVariable(str38);
                                c00022.L$10 = SpillingKt.nullOutSpilledVariable(str20);
                                c00022.L$11 = SpillingKt.nullOutSpilledVariable(str35);
                                c00022.L$12 = SpillingKt.nullOutSpilledVariable(map4);
                                c00022.L$13 = requestBody3;
                                c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse2);
                                c00022.I$0 = i10;
                                c00022.I$1 = i9;
                                c00022.I$2 = i11;
                                c00022.Z$0 = z5;
                                c00022.label = 5;
                                i15 = i9;
                                requestBody6 = requestBody3;
                                str46 = str38;
                                i12 = i11;
                                map9 = map5;
                                str47 = str37;
                                obj5 = obj4;
                                z7 = z5;
                                objBuildAuthHeaders$default3 = buildAuthHeaders$default(movieBoxProvider, "GET", str36, null, null, null, false, c00022, 60, null);
                                if (objBuildAuthHeaders$default3 == obj5) {
                                    return obj5;
                                }
                                String str87 = str36;
                                i16 = i10;
                                str48 = str87;
                                map10 = map9;
                                i17 = i15;
                                requestBody7 = requestBody6;
                                map11 = map4;
                                str49 = str35;
                                niceResponse4 = niceResponse2;
                                str50 = str20;
                                obj7 = objBuildAuthHeaders$default3;
                                str51 = str47;
                                niceResponse5 = niceResponse4;
                                str53 = str49;
                                map12 = (Map) obj7;
                                map13 = map10;
                                str54 = str51;
                                i20 = i17;
                                str55 = str50;
                                movieBoxProvider = this;
                                i21 = i16;
                                str56 = str48;
                                requestBody8 = requestBody7;
                                mainPageRequest6 = mainPageRequest5;
                                str57 = str46;
                                str58 = str29;
                                str59 = str28;
                                z8 = z7;
                                str60 = str27;
                                str61 = str32;
                                list5 = list4;
                                map14 = map12;
                                if (z8) {
                                    Requests app2 = MainActivityKt.getApp();
                                    c00022.L$0 = mainPageRequest6;
                                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(str56);
                                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(str60);
                                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(list5);
                                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(str61);
                                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(map13);
                                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(str59);
                                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(str58);
                                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(str54);
                                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(str57);
                                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(str55);
                                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(str53);
                                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(map14);
                                    c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody8);
                                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse5);
                                    c00022.I$0 = i21;
                                    c00022.I$1 = i20;
                                    c00022.I$2 = i12;
                                    c00022.Z$0 = z8;
                                    c00022.label = 7;
                                    i26 = i12;
                                    objPost$default = Requests.get$default(app2, str56, map14, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                                    if (objPost$default == obj5) {
                                        return obj5;
                                    }
                                    int i37 = i20;
                                    mainPageRequest8 = mainPageRequest6;
                                    str64 = str59;
                                    i27 = i37;
                                    i28 = i21;
                                    str65 = str55;
                                    map15 = map14;
                                    niceResponse6 = (NiceResponse) objPost$default;
                                    mainPageRequest5 = mainPageRequest8;
                                    i29 = i26;
                                    str66 = str56;
                                    i30 = i27;
                                    requestBody11 = requestBody8;
                                    i31 = i28;
                                    niceResponse2 = niceResponse6;
                                    str52 = str66;
                                    i18 = i29;
                                    i19 = i31;
                                } else {
                                    List list7 = list5;
                                    i22 = i12;
                                    Requests app3 = MainActivityKt.getApp();
                                    c00022.L$0 = mainPageRequest6;
                                    mainPageRequest7 = mainPageRequest6;
                                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(str56);
                                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(str60);
                                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(list7);
                                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(str61);
                                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(map13);
                                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(str59);
                                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(str58);
                                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(str54);
                                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(str57);
                                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(str55);
                                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(str53);
                                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(map14);
                                    c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody8);
                                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse5);
                                    c00022.I$0 = i21;
                                    c00022.I$1 = i20;
                                    c00022.I$2 = i22;
                                    c00022.Z$0 = z8;
                                    c00022.label = 8;
                                    requestBody9 = requestBody8;
                                    objPost$default = Requests.post$default(app3, str56, map14, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody9, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                                    if (objPost$default == obj5) {
                                        return obj5;
                                    }
                                    str62 = str59;
                                    i23 = i21;
                                    requestBody10 = requestBody9;
                                    i24 = i20;
                                    i25 = i22;
                                    z9 = z8;
                                    str63 = str55;
                                    niceResponse6 = (NiceResponse) objPost$default;
                                    i30 = i24;
                                    requestBody11 = requestBody10;
                                    mainPageRequest5 = mainPageRequest7;
                                    str66 = str56;
                                    i29 = i25;
                                    i31 = i23;
                                    niceResponse2 = niceResponse6;
                                    str52 = str66;
                                    i18 = i29;
                                    i19 = i31;
                                }
                            } else {
                                map6 = map5;
                                str39 = str37;
                                str40 = str38;
                                z6 = z5;
                                i12 = i11;
                                i13 = i9;
                                requestBody4 = requestBody3;
                                obj5 = obj4;
                                c00022.L$0 = mainPageRequest5;
                                c00022.L$1 = str36;
                                c00022.L$2 = SpillingKt.nullOutSpilledVariable(str27);
                                c00022.L$3 = SpillingKt.nullOutSpilledVariable(list4);
                                c00022.L$4 = SpillingKt.nullOutSpilledVariable(str32);
                                c00022.L$5 = SpillingKt.nullOutSpilledVariable(map6);
                                c00022.L$6 = SpillingKt.nullOutSpilledVariable(str28);
                                c00022.L$7 = SpillingKt.nullOutSpilledVariable(str29);
                                c00022.L$8 = SpillingKt.nullOutSpilledVariable(str39);
                                c00022.L$9 = SpillingKt.nullOutSpilledVariable(str40);
                                c00022.L$10 = SpillingKt.nullOutSpilledVariable(str20);
                                c00022.L$11 = SpillingKt.nullOutSpilledVariable(str35);
                                c00022.L$12 = SpillingKt.nullOutSpilledVariable(map4);
                                c00022.L$13 = requestBody4;
                                c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse2);
                                c00022.I$0 = i10;
                                c00022.I$1 = i13;
                                c00022.I$2 = i12;
                                c00022.Z$0 = z6;
                                c00022.label = 6;
                                str41 = str35;
                                movieBoxProvider = this;
                                objBuildAuthHeaders$default2 = buildAuthHeaders$default(movieBoxProvider, "POST", str36, "application/json; charset=utf-8", null, str41, false, c00022, 40, null);
                                if (objBuildAuthHeaders$default2 == obj5) {
                                    return obj5;
                                }
                                i14 = i10;
                                str42 = str36;
                                str43 = str41;
                                requestBody5 = requestBody4;
                                map7 = map4;
                                niceResponse3 = niceResponse2;
                                str44 = str20;
                                str45 = str39;
                                obj6 = objBuildAuthHeaders$default2;
                                map8 = map6;
                                niceResponse5 = niceResponse3;
                                str53 = str43;
                                map12 = (Map) obj6;
                                map13 = map8;
                                str54 = str45;
                                i20 = i13;
                                str55 = str44;
                                i21 = i14;
                                requestBody8 = requestBody5;
                                str57 = str40;
                                str58 = str29;
                                str59 = str28;
                                str60 = str27;
                                str56 = str42;
                                mainPageRequest6 = mainPageRequest5;
                                z8 = z6;
                                list5 = list4;
                                str61 = str32;
                                map14 = map12;
                                if (z8) {
                                    Requests app4 = MainActivityKt.getApp();
                                    c00022.L$0 = mainPageRequest6;
                                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(str56);
                                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(str60);
                                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(list5);
                                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(str61);
                                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(map13);
                                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(str59);
                                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(str58);
                                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(str54);
                                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(str57);
                                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(str55);
                                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(str53);
                                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(map14);
                                    c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody8);
                                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse5);
                                    c00022.I$0 = i21;
                                    c00022.I$1 = i20;
                                    c00022.I$2 = i12;
                                    c00022.Z$0 = z8;
                                    c00022.label = 7;
                                    i26 = i12;
                                    objPost$default = Requests.get$default(app4, str56, map14, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                                    if (objPost$default == obj5) {
                                        return obj5;
                                    }
                                    int i38 = i20;
                                    mainPageRequest8 = mainPageRequest6;
                                    str64 = str59;
                                    i27 = i38;
                                    i28 = i21;
                                    str65 = str55;
                                    map15 = map14;
                                    niceResponse6 = (NiceResponse) objPost$default;
                                    mainPageRequest5 = mainPageRequest8;
                                    i29 = i26;
                                    str66 = str56;
                                    i30 = i27;
                                    requestBody11 = requestBody8;
                                    i31 = i28;
                                    niceResponse2 = niceResponse6;
                                    str52 = str66;
                                    i18 = i29;
                                    i19 = i31;
                                } else {
                                    List list8 = list5;
                                    i22 = i12;
                                    Requests app5 = MainActivityKt.getApp();
                                    c00022.L$0 = mainPageRequest6;
                                    mainPageRequest7 = mainPageRequest6;
                                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(str56);
                                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(str60);
                                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(list8);
                                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(str61);
                                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(map13);
                                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(str59);
                                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(str58);
                                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(str54);
                                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(str57);
                                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(str55);
                                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(str53);
                                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(map14);
                                    c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody8);
                                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse5);
                                    c00022.I$0 = i21;
                                    c00022.I$1 = i20;
                                    c00022.I$2 = i22;
                                    c00022.Z$0 = z8;
                                    c00022.label = 8;
                                    requestBody9 = requestBody8;
                                    objPost$default = Requests.post$default(app5, str56, map14, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody9, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                                    if (objPost$default == obj5) {
                                        return obj5;
                                    }
                                    str62 = str59;
                                    i23 = i21;
                                    requestBody10 = requestBody9;
                                    i24 = i20;
                                    i25 = i22;
                                    z9 = z8;
                                    str63 = str55;
                                    niceResponse6 = (NiceResponse) objPost$default;
                                    i30 = i24;
                                    requestBody11 = requestBody10;
                                    mainPageRequest5 = mainPageRequest7;
                                    str66 = str56;
                                    i29 = i25;
                                    i31 = i23;
                                    niceResponse2 = niceResponse6;
                                    str52 = str66;
                                    i18 = i29;
                                    i19 = i31;
                                }
                            }
                        } else {
                            str52 = str36;
                            i18 = i11;
                            i19 = i10;
                        }
                        try {
                            JsonNode tree = ExtensionsKt.jacksonObjectMapper().readTree(niceResponse2.getText());
                            String str88 = str3;
                            jsonNode2 = tree.get(str88);
                            try {
                                if (jsonNode2 != null) {
                                    try {
                                        jsonNode4 = jsonNode2.get("items");
                                        if (jsonNode4 == null) {
                                        }
                                        iterable = (Iterable) jsonNode4;
                                        arrayList = new ArrayList();
                                        for (final JsonNode jsonNode7 : iterable) {
                                            JsonNode jsonNode8 = jsonNode4;
                                            if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                                                iterable2 = iterable;
                                                i32 = i18;
                                                str67 = str52;
                                                movieSearchResponseNewMovieSearchResponse$default = null;
                                            } else {
                                                jsonNode5 = jsonNode7.get("title");
                                                if (jsonNode5 != null || (strAsText = jsonNode5.asText()) == null) {
                                                    iterable2 = iterable;
                                                    i32 = i18;
                                                    str67 = str52;
                                                } else {
                                                    iterable2 = iterable;
                                                    i32 = i18;
                                                    str67 = str52;
                                                    String strSubstringBefore$default = StringsKt.substringBefore$default(strAsText, "[", (String) null, 2, (Object) null);
                                                    if (strSubstringBefore$default != null) {
                                                        JsonNode jsonNode9 = jsonNode7.get("subjectId");
                                                        if (jsonNode9 == null || (strAsText2 = jsonNode9.asText()) == null) {
                                                            movieSearchResponseNewMovieSearchResponse$default = null;
                                                        } else {
                                                            JsonNode jsonNode10 = jsonNode7.get("cover");
                                                            final String strAsText3 = (jsonNode10 == null || (jsonNode6 = jsonNode10.get("url")) == null) ? null : jsonNode6.asText();
                                                            JsonNode jsonNode11 = jsonNode7.get("subjectType");
                                                            switch (jsonNode11 != null ? jsonNode11.asInt() : 1) {
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
                                                            movieSearchResponseNewMovieSearchResponse$default = MainAPIKt.newMovieSearchResponse$default(this, strSubstringBefore$default, strAsText2, tvType, false, new Function1() { // from class: com.MovieBox.MovieBoxProvider$$ExternalSyntheticLambda6
                                                                public final Object invoke(Object obj8) {
                                                                    return MovieBoxProvider.getMainPage$lambda$1$0(strAsText3, jsonNode7, (MovieSearchResponse) obj8);
                                                                }
                                                            }, 8, (Object) null);
                                                        }
                                                    }
                                                }
                                                movieSearchResponseNewMovieSearchResponse$default = null;
                                            }
                                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                                try {
                                                    arrayList4 = arrayList;
                                                    arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                                                } catch (Exception e) {
                                                    arrayListEmptyList = null;
                                                    if (arrayListEmptyList == null) {
                                                        arrayListEmptyList = CollectionsKt.emptyList();
                                                    }
                                                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                                                }
                                            } else {
                                                arrayList4 = arrayList;
                                            }
                                            arrayList = arrayList4;
                                            iterable = iterable2;
                                            jsonNode4 = jsonNode8;
                                            i18 = i32;
                                            str52 = str67;
                                            movieBoxProvider = this;
                                            break;
                                        }
                                        arrayList2 = arrayList;
                                        hashSet = new HashSet();
                                        arrayList3 = new ArrayList();
                                        for (Object obj8 : arrayList2) {
                                            arrayList2 = arrayList2;
                                            if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                                                arrayList3.add(obj8);
                                            }
                                        }
                                        arrayListEmptyList = arrayList3;
                                        break;
                                    } catch (Exception e2) {
                                        arrayListEmptyList = null;
                                        if (arrayListEmptyList == null) {
                                            arrayListEmptyList = CollectionsKt.emptyList();
                                        }
                                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                                    }
                                    if (arrayListEmptyList == null) {
                                        arrayListEmptyList = CollectionsKt.emptyList();
                                    }
                                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                                }
                                jsonNode3 = tree.get(str88);
                                if (jsonNode3 != null) {
                                    jsonNode4 = jsonNode3.get("subjects");
                                } else {
                                    jsonNode4 = jsonNode;
                                }
                                if (jsonNode4 == null) {
                                    JsonNode jsonNode12 = jsonNode;
                                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode12, 2, jsonNode12);
                                }
                                iterable = (Iterable) jsonNode4;
                                arrayList = new ArrayList();
                                while (r29.hasNext()) {
                                    JsonNode jsonNode13 = jsonNode4;
                                    if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                                        iterable2 = iterable;
                                        i32 = i18;
                                        str67 = str52;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    } else {
                                        jsonNode5 = jsonNode7.get("title");
                                        if (jsonNode5 != null) {
                                            iterable2 = iterable;
                                            i32 = i18;
                                            str67 = str52;
                                            movieSearchResponseNewMovieSearchResponse$default = null;
                                        } else {
                                            iterable2 = iterable;
                                            i32 = i18;
                                            str67 = str52;
                                            movieSearchResponseNewMovieSearchResponse$default = null;
                                        }
                                    }
                                    if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                        arrayList4 = arrayList;
                                        arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                                    } else {
                                        arrayList4 = arrayList;
                                    }
                                    arrayList = arrayList4;
                                    iterable = iterable2;
                                    jsonNode4 = jsonNode13;
                                    i18 = i32;
                                    str52 = str67;
                                    movieBoxProvider = this;
                                    break;
                                }
                                arrayList2 = arrayList;
                                hashSet = new HashSet();
                                arrayList3 = new ArrayList();
                                while (r4.hasNext()) {
                                    arrayList2 = arrayList2;
                                    if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                                        arrayList3.add(obj8);
                                    }
                                }
                                arrayListEmptyList = arrayList3;
                            } catch (Exception e3) {
                                arrayListEmptyList = null;
                                if (arrayListEmptyList == null) {
                                    arrayListEmptyList = CollectionsKt.emptyList();
                                }
                                return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                            }
                            break;
                        } catch (Exception e4) {
                        }
                        if (arrayListEmptyList == null) {
                            arrayListEmptyList = CollectionsKt.emptyList();
                        }
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                    }
                    i9 = i8;
                    obj2 = coroutine_suspended;
                    Requests app6 = MainActivityKt.getApp();
                    c00022.L$0 = mainPageRequest2;
                    c00022.L$1 = str22;
                    mainPageRequest3 = mainPageRequest2;
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(str25);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(list3);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(str26);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(map3);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(str21);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(str8);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(str10);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(str19);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(str20);
                    c00022.L$11 = str18;
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(map4);
                    c00022.L$13 = requestBodyCreate;
                    c00022.I$0 = i7;
                    c00022.I$1 = i9;
                    c00022.I$2 = i6;
                    c00022.Z$0 = z3;
                    c00022.label = 4;
                    objPost$default = Requests.post$default(app6, str22, map4, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                    if (objPost$default == obj2) {
                        return obj2;
                    }
                    str27 = str25;
                    list4 = list3;
                    str28 = str21;
                    i10 = i7;
                    str29 = str8;
                    z4 = z3;
                    str30 = str18;
                    requestBody = requestBodyCreate;
                    str31 = str19;
                    str32 = str26;
                    str35 = str30;
                    mainPageRequest5 = mainPageRequest3;
                    obj4 = obj2;
                    str36 = str22;
                    z5 = z4;
                    str37 = str10;
                    i11 = i6;
                    map5 = map3;
                    requestBody3 = requestBody;
                    niceResponse = (NiceResponse) objPost$default;
                    str38 = str31;
                    niceResponse2 = niceResponse;
                    if (niceResponse2.getCode() != 401) {
                    }
                    bearerToken = jsonNode;
                    sharedPreferences = movieBoxProvider.sharedPref;
                    if (sharedPreferences != null) {
                        editorRemove.apply();
                        Unit unit2 = Unit.INSTANCE;
                    }
                    if (!z5) {
                        map6 = map5;
                        str39 = str37;
                        str40 = str38;
                        z6 = z5;
                        i12 = i11;
                        i13 = i9;
                        requestBody4 = requestBody3;
                        obj5 = obj4;
                        c00022.L$0 = mainPageRequest5;
                        c00022.L$1 = str36;
                        c00022.L$2 = SpillingKt.nullOutSpilledVariable(str27);
                        c00022.L$3 = SpillingKt.nullOutSpilledVariable(list4);
                        c00022.L$4 = SpillingKt.nullOutSpilledVariable(str32);
                        c00022.L$5 = SpillingKt.nullOutSpilledVariable(map6);
                        c00022.L$6 = SpillingKt.nullOutSpilledVariable(str28);
                        c00022.L$7 = SpillingKt.nullOutSpilledVariable(str29);
                        c00022.L$8 = SpillingKt.nullOutSpilledVariable(str39);
                        c00022.L$9 = SpillingKt.nullOutSpilledVariable(str40);
                        c00022.L$10 = SpillingKt.nullOutSpilledVariable(str20);
                        c00022.L$11 = SpillingKt.nullOutSpilledVariable(str35);
                        c00022.L$12 = SpillingKt.nullOutSpilledVariable(map4);
                        c00022.L$13 = requestBody4;
                        c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse2);
                        c00022.I$0 = i10;
                        c00022.I$1 = i13;
                        c00022.I$2 = i12;
                        c00022.Z$0 = z6;
                        c00022.label = 6;
                        str41 = str35;
                        movieBoxProvider = this;
                        objBuildAuthHeaders$default2 = buildAuthHeaders$default(movieBoxProvider, "POST", str36, "application/json; charset=utf-8", null, str41, false, c00022, 40, null);
                        if (objBuildAuthHeaders$default2 == obj5) {
                            return obj5;
                        }
                        i14 = i10;
                        str42 = str36;
                        str43 = str41;
                        requestBody5 = requestBody4;
                        map7 = map4;
                        niceResponse3 = niceResponse2;
                        str44 = str20;
                        str45 = str39;
                        obj6 = objBuildAuthHeaders$default2;
                        map8 = map6;
                        niceResponse5 = niceResponse3;
                        str53 = str43;
                        map12 = (Map) obj6;
                        map13 = map8;
                        str54 = str45;
                        i20 = i13;
                        str55 = str44;
                        i21 = i14;
                        requestBody8 = requestBody5;
                        str57 = str40;
                        str58 = str29;
                        str59 = str28;
                        str60 = str27;
                        str56 = str42;
                        mainPageRequest6 = mainPageRequest5;
                        z8 = z6;
                        list5 = list4;
                        str61 = str32;
                        map14 = map12;
                        if (z8) {
                            Requests app7 = MainActivityKt.getApp();
                            c00022.L$0 = mainPageRequest6;
                            c00022.L$1 = SpillingKt.nullOutSpilledVariable(str56);
                            c00022.L$2 = SpillingKt.nullOutSpilledVariable(str60);
                            c00022.L$3 = SpillingKt.nullOutSpilledVariable(list5);
                            c00022.L$4 = SpillingKt.nullOutSpilledVariable(str61);
                            c00022.L$5 = SpillingKt.nullOutSpilledVariable(map13);
                            c00022.L$6 = SpillingKt.nullOutSpilledVariable(str59);
                            c00022.L$7 = SpillingKt.nullOutSpilledVariable(str58);
                            c00022.L$8 = SpillingKt.nullOutSpilledVariable(str54);
                            c00022.L$9 = SpillingKt.nullOutSpilledVariable(str57);
                            c00022.L$10 = SpillingKt.nullOutSpilledVariable(str55);
                            c00022.L$11 = SpillingKt.nullOutSpilledVariable(str53);
                            c00022.L$12 = SpillingKt.nullOutSpilledVariable(map14);
                            c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody8);
                            c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse5);
                            c00022.I$0 = i21;
                            c00022.I$1 = i20;
                            c00022.I$2 = i12;
                            c00022.Z$0 = z8;
                            c00022.label = 7;
                            i26 = i12;
                            objPost$default = Requests.get$default(app7, str56, map14, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                            if (objPost$default == obj5) {
                                return obj5;
                            }
                            int i39 = i20;
                            mainPageRequest8 = mainPageRequest6;
                            str64 = str59;
                            i27 = i39;
                            i28 = i21;
                            str65 = str55;
                            map15 = map14;
                            niceResponse6 = (NiceResponse) objPost$default;
                            mainPageRequest5 = mainPageRequest8;
                            i29 = i26;
                            str66 = str56;
                            i30 = i27;
                            requestBody11 = requestBody8;
                            i31 = i28;
                            niceResponse2 = niceResponse6;
                            str52 = str66;
                            i18 = i29;
                            i19 = i31;
                            JsonNode tree2 = ExtensionsKt.jacksonObjectMapper().readTree(niceResponse2.getText());
                            String str89 = str3;
                            jsonNode2 = tree2.get(str89);
                            if (jsonNode2 != null) {
                                jsonNode4 = jsonNode2.get("items");
                                if (jsonNode4 == null) {
                                }
                                iterable = (Iterable) jsonNode4;
                                arrayList = new ArrayList();
                                while (r29.hasNext()) {
                                    JsonNode jsonNode14 = jsonNode4;
                                    if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                                        iterable2 = iterable;
                                        i32 = i18;
                                        str67 = str52;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    } else {
                                        jsonNode5 = jsonNode7.get("title");
                                        if (jsonNode5 != null) {
                                            iterable2 = iterable;
                                            i32 = i18;
                                            str67 = str52;
                                            movieSearchResponseNewMovieSearchResponse$default = null;
                                        } else {
                                            iterable2 = iterable;
                                            i32 = i18;
                                            str67 = str52;
                                            movieSearchResponseNewMovieSearchResponse$default = null;
                                        }
                                    }
                                    if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                        arrayList4 = arrayList;
                                        arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                                    } else {
                                        arrayList4 = arrayList;
                                    }
                                    arrayList = arrayList4;
                                    iterable = iterable2;
                                    jsonNode4 = jsonNode14;
                                    i18 = i32;
                                    str52 = str67;
                                    movieBoxProvider = this;
                                    break;
                                }
                                arrayList2 = arrayList;
                                hashSet = new HashSet();
                                arrayList3 = new ArrayList();
                                while (r4.hasNext()) {
                                    arrayList2 = arrayList2;
                                    if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                                        arrayList3.add(obj8);
                                    }
                                }
                                arrayListEmptyList = arrayList3;
                                if (arrayListEmptyList == null) {
                                    arrayListEmptyList = CollectionsKt.emptyList();
                                }
                                return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                            }
                            jsonNode3 = tree2.get(str89);
                            if (jsonNode3 != null) {
                                jsonNode4 = jsonNode3.get("subjects");
                            } else {
                                jsonNode4 = jsonNode;
                            }
                            if (jsonNode4 == null) {
                                JsonNode jsonNode15 = jsonNode;
                                return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode15, 2, jsonNode15);
                            }
                            iterable = (Iterable) jsonNode4;
                            arrayList = new ArrayList();
                            while (r29.hasNext()) {
                                JsonNode jsonNode16 = jsonNode4;
                                if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    jsonNode5 = jsonNode7.get("title");
                                    if (jsonNode5 != null) {
                                        iterable2 = iterable;
                                        i32 = i18;
                                        str67 = str52;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    } else {
                                        iterable2 = iterable;
                                        i32 = i18;
                                        str67 = str52;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    }
                                }
                                if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                    arrayList4 = arrayList;
                                    arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                                } else {
                                    arrayList4 = arrayList;
                                }
                                arrayList = arrayList4;
                                iterable = iterable2;
                                jsonNode4 = jsonNode16;
                                i18 = i32;
                                str52 = str67;
                                movieBoxProvider = this;
                                break;
                            }
                            arrayList2 = arrayList;
                            hashSet = new HashSet();
                            arrayList3 = new ArrayList();
                            while (r4.hasNext()) {
                                arrayList2 = arrayList2;
                                if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                                    arrayList3.add(obj8);
                                }
                            }
                            arrayListEmptyList = arrayList3;
                            if (arrayListEmptyList == null) {
                                arrayListEmptyList = CollectionsKt.emptyList();
                            }
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                        }
                        List list9 = list5;
                        i22 = i12;
                        Requests app8 = MainActivityKt.getApp();
                        c00022.L$0 = mainPageRequest6;
                        mainPageRequest7 = mainPageRequest6;
                        c00022.L$1 = SpillingKt.nullOutSpilledVariable(str56);
                        c00022.L$2 = SpillingKt.nullOutSpilledVariable(str60);
                        c00022.L$3 = SpillingKt.nullOutSpilledVariable(list9);
                        c00022.L$4 = SpillingKt.nullOutSpilledVariable(str61);
                        c00022.L$5 = SpillingKt.nullOutSpilledVariable(map13);
                        c00022.L$6 = SpillingKt.nullOutSpilledVariable(str59);
                        c00022.L$7 = SpillingKt.nullOutSpilledVariable(str58);
                        c00022.L$8 = SpillingKt.nullOutSpilledVariable(str54);
                        c00022.L$9 = SpillingKt.nullOutSpilledVariable(str57);
                        c00022.L$10 = SpillingKt.nullOutSpilledVariable(str55);
                        c00022.L$11 = SpillingKt.nullOutSpilledVariable(str53);
                        c00022.L$12 = SpillingKt.nullOutSpilledVariable(map14);
                        c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody8);
                        c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse5);
                        c00022.I$0 = i21;
                        c00022.I$1 = i20;
                        c00022.I$2 = i22;
                        c00022.Z$0 = z8;
                        c00022.label = 8;
                        requestBody9 = requestBody8;
                        objPost$default = Requests.post$default(app8, str56, map14, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody9, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                        if (objPost$default == obj5) {
                            return obj5;
                        }
                        str62 = str59;
                        i23 = i21;
                        requestBody10 = requestBody9;
                        i24 = i20;
                        i25 = i22;
                        z9 = z8;
                        str63 = str55;
                        niceResponse6 = (NiceResponse) objPost$default;
                        i30 = i24;
                        requestBody11 = requestBody10;
                        mainPageRequest5 = mainPageRequest7;
                        str66 = str56;
                        i29 = i25;
                        i31 = i23;
                        niceResponse2 = niceResponse6;
                        str52 = str66;
                        i18 = i29;
                        i19 = i31;
                        JsonNode tree3 = ExtensionsKt.jacksonObjectMapper().readTree(niceResponse2.getText());
                        String str810 = str3;
                        jsonNode2 = tree3.get(str810);
                        if (jsonNode2 != null) {
                            jsonNode4 = jsonNode2.get("items");
                            if (jsonNode4 == null) {
                            }
                            iterable = (Iterable) jsonNode4;
                            arrayList = new ArrayList();
                            while (r29.hasNext()) {
                                JsonNode jsonNode17 = jsonNode4;
                                if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    jsonNode5 = jsonNode7.get("title");
                                    if (jsonNode5 != null) {
                                        iterable2 = iterable;
                                        i32 = i18;
                                        str67 = str52;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    } else {
                                        iterable2 = iterable;
                                        i32 = i18;
                                        str67 = str52;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    }
                                }
                                if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                    arrayList4 = arrayList;
                                    arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                                } else {
                                    arrayList4 = arrayList;
                                }
                                arrayList = arrayList4;
                                iterable = iterable2;
                                jsonNode4 = jsonNode17;
                                i18 = i32;
                                str52 = str67;
                                movieBoxProvider = this;
                                break;
                            }
                            arrayList2 = arrayList;
                            hashSet = new HashSet();
                            arrayList3 = new ArrayList();
                            while (r4.hasNext()) {
                                arrayList2 = arrayList2;
                                if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                                    arrayList3.add(obj8);
                                }
                            }
                            arrayListEmptyList = arrayList3;
                            if (arrayListEmptyList == null) {
                                arrayListEmptyList = CollectionsKt.emptyList();
                            }
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                        }
                        jsonNode3 = tree3.get(str810);
                        if (jsonNode3 != null) {
                            jsonNode4 = jsonNode3.get("subjects");
                        } else {
                            jsonNode4 = jsonNode;
                        }
                        if (jsonNode4 == null) {
                            JsonNode jsonNode18 = jsonNode;
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode18, 2, jsonNode18);
                        }
                        iterable = (Iterable) jsonNode4;
                        arrayList = new ArrayList();
                        while (r29.hasNext()) {
                            JsonNode jsonNode19 = jsonNode4;
                            if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                jsonNode5 = jsonNode7.get("title");
                                if (jsonNode5 != null) {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                arrayList4 = arrayList;
                                arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                arrayList4 = arrayList;
                            }
                            arrayList = arrayList4;
                            iterable = iterable2;
                            jsonNode4 = jsonNode19;
                            i18 = i32;
                            str52 = str67;
                            movieBoxProvider = this;
                            break;
                        }
                        arrayList2 = arrayList;
                        hashSet = new HashSet();
                        arrayList3 = new ArrayList();
                        while (r4.hasNext()) {
                            arrayList2 = arrayList2;
                            if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                                arrayList3.add(obj8);
                            }
                        }
                        arrayListEmptyList = arrayList3;
                        if (arrayListEmptyList == null) {
                            arrayListEmptyList = CollectionsKt.emptyList();
                        }
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                    }
                    c00022.L$0 = mainPageRequest5;
                    c00022.L$1 = str36;
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(str27);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(list4);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(str32);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(map5);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(str28);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(str29);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(str37);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(str38);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(str20);
                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(str35);
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(map4);
                    c00022.L$13 = requestBody3;
                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse2);
                    c00022.I$0 = i10;
                    c00022.I$1 = i9;
                    c00022.I$2 = i11;
                    c00022.Z$0 = z5;
                    c00022.label = 5;
                    i15 = i9;
                    requestBody6 = requestBody3;
                    str46 = str38;
                    i12 = i11;
                    map9 = map5;
                    str47 = str37;
                    obj5 = obj4;
                    z7 = z5;
                    objBuildAuthHeaders$default3 = buildAuthHeaders$default(movieBoxProvider, "GET", str36, null, null, null, false, c00022, 60, null);
                    if (objBuildAuthHeaders$default3 == obj5) {
                        return obj5;
                    }
                    String str811 = str36;
                    i16 = i10;
                    str48 = str811;
                    map10 = map9;
                    i17 = i15;
                    requestBody7 = requestBody6;
                    map11 = map4;
                    str49 = str35;
                    niceResponse4 = niceResponse2;
                    str50 = str20;
                    obj7 = objBuildAuthHeaders$default3;
                    str51 = str47;
                    niceResponse5 = niceResponse4;
                    str53 = str49;
                    map12 = (Map) obj7;
                    map13 = map10;
                    str54 = str51;
                    i20 = i17;
                    str55 = str50;
                    movieBoxProvider = this;
                    i21 = i16;
                    str56 = str48;
                    requestBody8 = requestBody7;
                    mainPageRequest6 = mainPageRequest5;
                    str57 = str46;
                    str58 = str29;
                    str59 = str28;
                    z8 = z7;
                    str60 = str27;
                    str61 = str32;
                    list5 = list4;
                    map14 = map12;
                    if (z8) {
                        Requests app9 = MainActivityKt.getApp();
                        c00022.L$0 = mainPageRequest6;
                        c00022.L$1 = SpillingKt.nullOutSpilledVariable(str56);
                        c00022.L$2 = SpillingKt.nullOutSpilledVariable(str60);
                        c00022.L$3 = SpillingKt.nullOutSpilledVariable(list5);
                        c00022.L$4 = SpillingKt.nullOutSpilledVariable(str61);
                        c00022.L$5 = SpillingKt.nullOutSpilledVariable(map13);
                        c00022.L$6 = SpillingKt.nullOutSpilledVariable(str59);
                        c00022.L$7 = SpillingKt.nullOutSpilledVariable(str58);
                        c00022.L$8 = SpillingKt.nullOutSpilledVariable(str54);
                        c00022.L$9 = SpillingKt.nullOutSpilledVariable(str57);
                        c00022.L$10 = SpillingKt.nullOutSpilledVariable(str55);
                        c00022.L$11 = SpillingKt.nullOutSpilledVariable(str53);
                        c00022.L$12 = SpillingKt.nullOutSpilledVariable(map14);
                        c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody8);
                        c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse5);
                        c00022.I$0 = i21;
                        c00022.I$1 = i20;
                        c00022.I$2 = i12;
                        c00022.Z$0 = z8;
                        c00022.label = 7;
                        i26 = i12;
                        objPost$default = Requests.get$default(app9, str56, map14, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                        if (objPost$default == obj5) {
                            return obj5;
                        }
                        int i310 = i20;
                        mainPageRequest8 = mainPageRequest6;
                        str64 = str59;
                        i27 = i310;
                        i28 = i21;
                        str65 = str55;
                        map15 = map14;
                        niceResponse6 = (NiceResponse) objPost$default;
                        mainPageRequest5 = mainPageRequest8;
                        i29 = i26;
                        str66 = str56;
                        i30 = i27;
                        requestBody11 = requestBody8;
                        i31 = i28;
                        niceResponse2 = niceResponse6;
                        str52 = str66;
                        i18 = i29;
                        i19 = i31;
                        JsonNode tree4 = ExtensionsKt.jacksonObjectMapper().readTree(niceResponse2.getText());
                        String str812 = str3;
                        jsonNode2 = tree4.get(str812);
                        if (jsonNode2 != null) {
                            jsonNode4 = jsonNode2.get("items");
                            if (jsonNode4 == null) {
                            }
                            iterable = (Iterable) jsonNode4;
                            arrayList = new ArrayList();
                            while (r29.hasNext()) {
                                JsonNode jsonNode110 = jsonNode4;
                                if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    jsonNode5 = jsonNode7.get("title");
                                    if (jsonNode5 != null) {
                                        iterable2 = iterable;
                                        i32 = i18;
                                        str67 = str52;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    } else {
                                        iterable2 = iterable;
                                        i32 = i18;
                                        str67 = str52;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    }
                                }
                                if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                    arrayList4 = arrayList;
                                    arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                                } else {
                                    arrayList4 = arrayList;
                                }
                                arrayList = arrayList4;
                                iterable = iterable2;
                                jsonNode4 = jsonNode110;
                                i18 = i32;
                                str52 = str67;
                                movieBoxProvider = this;
                                break;
                            }
                            arrayList2 = arrayList;
                            hashSet = new HashSet();
                            arrayList3 = new ArrayList();
                            while (r4.hasNext()) {
                                arrayList2 = arrayList2;
                                if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                                    arrayList3.add(obj8);
                                }
                            }
                            arrayListEmptyList = arrayList3;
                            if (arrayListEmptyList == null) {
                                arrayListEmptyList = CollectionsKt.emptyList();
                            }
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                        }
                        jsonNode3 = tree4.get(str812);
                        if (jsonNode3 != null) {
                            jsonNode4 = jsonNode3.get("subjects");
                        } else {
                            jsonNode4 = jsonNode;
                        }
                        if (jsonNode4 == null) {
                            JsonNode jsonNode111 = jsonNode;
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode111, 2, jsonNode111);
                        }
                        iterable = (Iterable) jsonNode4;
                        arrayList = new ArrayList();
                        while (r29.hasNext()) {
                            JsonNode jsonNode112 = jsonNode4;
                            if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                jsonNode5 = jsonNode7.get("title");
                                if (jsonNode5 != null) {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                arrayList4 = arrayList;
                                arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                arrayList4 = arrayList;
                            }
                            arrayList = arrayList4;
                            iterable = iterable2;
                            jsonNode4 = jsonNode112;
                            i18 = i32;
                            str52 = str67;
                            movieBoxProvider = this;
                            break;
                        }
                        arrayList2 = arrayList;
                        hashSet = new HashSet();
                        arrayList3 = new ArrayList();
                        while (r4.hasNext()) {
                            arrayList2 = arrayList2;
                            if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                                arrayList3.add(obj8);
                            }
                        }
                        arrayListEmptyList = arrayList3;
                        if (arrayListEmptyList == null) {
                            arrayListEmptyList = CollectionsKt.emptyList();
                        }
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                    }
                    List list10 = list5;
                    i22 = i12;
                    Requests app10 = MainActivityKt.getApp();
                    c00022.L$0 = mainPageRequest6;
                    mainPageRequest7 = mainPageRequest6;
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(str56);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(str60);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(list10);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(str61);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(map13);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(str59);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(str58);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(str54);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(str57);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(str55);
                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(str53);
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(map14);
                    c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody8);
                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse5);
                    c00022.I$0 = i21;
                    c00022.I$1 = i20;
                    c00022.I$2 = i22;
                    c00022.Z$0 = z8;
                    c00022.label = 8;
                    requestBody9 = requestBody8;
                    objPost$default = Requests.post$default(app10, str56, map14, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody9, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                    if (objPost$default == obj5) {
                        return obj5;
                    }
                    str62 = str59;
                    i23 = i21;
                    requestBody10 = requestBody9;
                    i24 = i20;
                    i25 = i22;
                    z9 = z8;
                    str63 = str55;
                    niceResponse6 = (NiceResponse) objPost$default;
                    i30 = i24;
                    requestBody11 = requestBody10;
                    mainPageRequest5 = mainPageRequest7;
                    str66 = str56;
                    i29 = i25;
                    i31 = i23;
                    niceResponse2 = niceResponse6;
                    str52 = str66;
                    i18 = i29;
                    i19 = i31;
                    JsonNode tree5 = ExtensionsKt.jacksonObjectMapper().readTree(niceResponse2.getText());
                    String str813 = str3;
                    jsonNode2 = tree5.get(str813);
                    if (jsonNode2 != null) {
                        jsonNode4 = jsonNode2.get("items");
                        if (jsonNode4 == null) {
                        }
                        iterable = (Iterable) jsonNode4;
                        arrayList = new ArrayList();
                        while (r29.hasNext()) {
                            JsonNode jsonNode113 = jsonNode4;
                            if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                jsonNode5 = jsonNode7.get("title");
                                if (jsonNode5 != null) {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                arrayList4 = arrayList;
                                arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                arrayList4 = arrayList;
                            }
                            arrayList = arrayList4;
                            iterable = iterable2;
                            jsonNode4 = jsonNode113;
                            i18 = i32;
                            str52 = str67;
                            movieBoxProvider = this;
                            break;
                        }
                        arrayList2 = arrayList;
                        hashSet = new HashSet();
                        arrayList3 = new ArrayList();
                        while (r4.hasNext()) {
                            arrayList2 = arrayList2;
                            if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                                arrayList3.add(obj8);
                            }
                        }
                        arrayListEmptyList = arrayList3;
                        if (arrayListEmptyList == null) {
                            arrayListEmptyList = CollectionsKt.emptyList();
                        }
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                    }
                    jsonNode3 = tree5.get(str813);
                    if (jsonNode3 != null) {
                        jsonNode4 = jsonNode3.get("subjects");
                    } else {
                        jsonNode4 = jsonNode;
                    }
                    if (jsonNode4 == null) {
                        JsonNode jsonNode114 = jsonNode;
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode114, 2, jsonNode114);
                    }
                    iterable = (Iterable) jsonNode4;
                    arrayList = new ArrayList();
                    while (r29.hasNext()) {
                        JsonNode jsonNode115 = jsonNode4;
                        if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                            iterable2 = iterable;
                            i32 = i18;
                            str67 = str52;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            jsonNode5 = jsonNode7.get("title");
                            if (jsonNode5 != null) {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                        }
                        if (movieSearchResponseNewMovieSearchResponse$default != null) {
                            arrayList4 = arrayList;
                            arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                        } else {
                            arrayList4 = arrayList;
                        }
                        arrayList = arrayList4;
                        iterable = iterable2;
                        jsonNode4 = jsonNode115;
                        i18 = i32;
                        str52 = str67;
                        movieBoxProvider = this;
                        break;
                    }
                    arrayList2 = arrayList;
                    hashSet = new HashSet();
                    arrayList3 = new ArrayList();
                    while (r4.hasNext()) {
                        arrayList2 = arrayList2;
                        if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                            arrayList3.add(obj8);
                        }
                    }
                    arrayListEmptyList = arrayList3;
                    if (arrayListEmptyList == null) {
                        arrayListEmptyList = CollectionsKt.emptyList();
                    }
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                }
                String str90 = str78;
                String str91 = str80;
                String str92 = str79;
                str4 = str77;
                String str93 = str81;
                jsonNode = null;
                i2 = 20;
                str5 = str;
                c00022.L$0 = mainPageRequest9;
                c00022.L$1 = str5;
                c00022.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                c00022.L$3 = SpillingKt.nullOutSpilledVariable(list);
                c00022.L$4 = SpillingKt.nullOutSpilledVariable(str70);
                c00022.L$5 = SpillingKt.nullOutSpilledVariable(linkedHashMap);
                c00022.L$6 = SpillingKt.nullOutSpilledVariable(str4);
                c00022.L$7 = SpillingKt.nullOutSpilledVariable(str90);
                c00022.L$8 = SpillingKt.nullOutSpilledVariable(str92);
                c00022.L$9 = SpillingKt.nullOutSpilledVariable(str91);
                c00022.L$10 = SpillingKt.nullOutSpilledVariable(str93);
                c00022.L$11 = str82;
                c00022.I$0 = i33;
                c00022.I$1 = 20;
                c00022.I$2 = i34;
                c00022.Z$0 = zStartsWith$default;
                c00022.label = 2;
                z = zStartsWith$default;
                movieBoxProvider = this;
                Object objBuildAuthHeaders$default4 = buildAuthHeaders$default(movieBoxProvider, "POST", str5, "application/json; charset=utf-8", null, str82, false, c00022, 40, null);
                if (objBuildAuthHeaders$default4 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str6 = str82;
                i3 = i34;
                str7 = str93;
                str8 = str90;
                str9 = str91;
                str10 = str92;
                objPost$default = objBuildAuthHeaders$default4;
                map = linkedHashMap;
                str11 = str70;
                str18 = str6;
                str20 = str7;
                str19 = str9;
                str21 = str4;
                i7 = i33;
                map3 = map;
                mainPageRequest2 = mainPageRequest9;
                map4 = (Map) objPost$default;
                z3 = z;
                i8 = i2;
                i6 = i3;
                str22 = str5;
                list2 = list;
                str24 = str2;
                str23 = str11;
                str25 = str24;
                list3 = list2;
                str26 = str23;
                requestBodyCreate = RequestBody.Companion.create(str18, MediaType.Companion.get("application/json"));
                if (z3) {
                    Requests app11 = MainActivityKt.getApp();
                    c00022.L$0 = mainPageRequest2;
                    c00022.L$1 = str22;
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(str25);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(list3);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(str26);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(map3);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(str21);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(str8);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(str10);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(str19);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(str20);
                    c00022.L$11 = str18;
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(map4);
                    c00022.L$13 = requestBodyCreate;
                    c00022.I$0 = i7;
                    c00022.I$1 = i8;
                    c00022.I$2 = i6;
                    c00022.Z$0 = z3;
                    c00022.label = 3;
                    obj3 = coroutine_suspended;
                    i9 = i8;
                    objPost$default = Requests.get$default(app11, str22, map4, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                    if (objPost$default == obj3) {
                        return obj3;
                    }
                    str27 = str25;
                    list4 = list3;
                    str28 = str21;
                    str29 = str8;
                    str33 = str19;
                    str32 = str26;
                    requestBody2 = requestBodyCreate;
                    mainPageRequest4 = mainPageRequest2;
                    i10 = i7;
                    str34 = str18;
                    str35 = str34;
                    obj4 = obj3;
                    str36 = str22;
                    z5 = z3;
                    mainPageRequest5 = mainPageRequest4;
                    str37 = str10;
                    i11 = i6;
                    map5 = map3;
                    requestBody3 = requestBody2;
                    niceResponse = (NiceResponse) objPost$default;
                    str38 = str33;
                    niceResponse2 = niceResponse;
                    if (niceResponse2.getCode() != 401) {
                    }
                    bearerToken = jsonNode;
                    sharedPreferences = movieBoxProvider.sharedPref;
                    if (sharedPreferences != null) {
                        editorRemove.apply();
                        Unit unit3 = Unit.INSTANCE;
                    }
                    if (!z5) {
                        map6 = map5;
                        str39 = str37;
                        str40 = str38;
                        z6 = z5;
                        i12 = i11;
                        i13 = i9;
                        requestBody4 = requestBody3;
                        obj5 = obj4;
                        c00022.L$0 = mainPageRequest5;
                        c00022.L$1 = str36;
                        c00022.L$2 = SpillingKt.nullOutSpilledVariable(str27);
                        c00022.L$3 = SpillingKt.nullOutSpilledVariable(list4);
                        c00022.L$4 = SpillingKt.nullOutSpilledVariable(str32);
                        c00022.L$5 = SpillingKt.nullOutSpilledVariable(map6);
                        c00022.L$6 = SpillingKt.nullOutSpilledVariable(str28);
                        c00022.L$7 = SpillingKt.nullOutSpilledVariable(str29);
                        c00022.L$8 = SpillingKt.nullOutSpilledVariable(str39);
                        c00022.L$9 = SpillingKt.nullOutSpilledVariable(str40);
                        c00022.L$10 = SpillingKt.nullOutSpilledVariable(str20);
                        c00022.L$11 = SpillingKt.nullOutSpilledVariable(str35);
                        c00022.L$12 = SpillingKt.nullOutSpilledVariable(map4);
                        c00022.L$13 = requestBody4;
                        c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse2);
                        c00022.I$0 = i10;
                        c00022.I$1 = i13;
                        c00022.I$2 = i12;
                        c00022.Z$0 = z6;
                        c00022.label = 6;
                        str41 = str35;
                        movieBoxProvider = this;
                        objBuildAuthHeaders$default2 = buildAuthHeaders$default(movieBoxProvider, "POST", str36, "application/json; charset=utf-8", null, str41, false, c00022, 40, null);
                        if (objBuildAuthHeaders$default2 == obj5) {
                            return obj5;
                        }
                        i14 = i10;
                        str42 = str36;
                        str43 = str41;
                        requestBody5 = requestBody4;
                        map7 = map4;
                        niceResponse3 = niceResponse2;
                        str44 = str20;
                        str45 = str39;
                        obj6 = objBuildAuthHeaders$default2;
                        map8 = map6;
                        niceResponse5 = niceResponse3;
                        str53 = str43;
                        map12 = (Map) obj6;
                        map13 = map8;
                        str54 = str45;
                        i20 = i13;
                        str55 = str44;
                        i21 = i14;
                        requestBody8 = requestBody5;
                        str57 = str40;
                        str58 = str29;
                        str59 = str28;
                        str60 = str27;
                        str56 = str42;
                        mainPageRequest6 = mainPageRequest5;
                        z8 = z6;
                        list5 = list4;
                        str61 = str32;
                        map14 = map12;
                        if (z8) {
                            Requests app12 = MainActivityKt.getApp();
                            c00022.L$0 = mainPageRequest6;
                            c00022.L$1 = SpillingKt.nullOutSpilledVariable(str56);
                            c00022.L$2 = SpillingKt.nullOutSpilledVariable(str60);
                            c00022.L$3 = SpillingKt.nullOutSpilledVariable(list5);
                            c00022.L$4 = SpillingKt.nullOutSpilledVariable(str61);
                            c00022.L$5 = SpillingKt.nullOutSpilledVariable(map13);
                            c00022.L$6 = SpillingKt.nullOutSpilledVariable(str59);
                            c00022.L$7 = SpillingKt.nullOutSpilledVariable(str58);
                            c00022.L$8 = SpillingKt.nullOutSpilledVariable(str54);
                            c00022.L$9 = SpillingKt.nullOutSpilledVariable(str57);
                            c00022.L$10 = SpillingKt.nullOutSpilledVariable(str55);
                            c00022.L$11 = SpillingKt.nullOutSpilledVariable(str53);
                            c00022.L$12 = SpillingKt.nullOutSpilledVariable(map14);
                            c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody8);
                            c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse5);
                            c00022.I$0 = i21;
                            c00022.I$1 = i20;
                            c00022.I$2 = i12;
                            c00022.Z$0 = z8;
                            c00022.label = 7;
                            i26 = i12;
                            objPost$default = Requests.get$default(app12, str56, map14, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                            if (objPost$default == obj5) {
                                return obj5;
                            }
                            int i311 = i20;
                            mainPageRequest8 = mainPageRequest6;
                            str64 = str59;
                            i27 = i311;
                            i28 = i21;
                            str65 = str55;
                            map15 = map14;
                            niceResponse6 = (NiceResponse) objPost$default;
                            mainPageRequest5 = mainPageRequest8;
                            i29 = i26;
                            str66 = str56;
                            i30 = i27;
                            requestBody11 = requestBody8;
                            i31 = i28;
                            niceResponse2 = niceResponse6;
                            str52 = str66;
                            i18 = i29;
                            i19 = i31;
                            JsonNode tree6 = ExtensionsKt.jacksonObjectMapper().readTree(niceResponse2.getText());
                            String str814 = str3;
                            jsonNode2 = tree6.get(str814);
                            if (jsonNode2 != null) {
                                jsonNode4 = jsonNode2.get("items");
                                if (jsonNode4 == null) {
                                }
                                iterable = (Iterable) jsonNode4;
                                arrayList = new ArrayList();
                                while (r29.hasNext()) {
                                    JsonNode jsonNode116 = jsonNode4;
                                    if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                                        iterable2 = iterable;
                                        i32 = i18;
                                        str67 = str52;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    } else {
                                        jsonNode5 = jsonNode7.get("title");
                                        if (jsonNode5 != null) {
                                            iterable2 = iterable;
                                            i32 = i18;
                                            str67 = str52;
                                            movieSearchResponseNewMovieSearchResponse$default = null;
                                        } else {
                                            iterable2 = iterable;
                                            i32 = i18;
                                            str67 = str52;
                                            movieSearchResponseNewMovieSearchResponse$default = null;
                                        }
                                    }
                                    if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                        arrayList4 = arrayList;
                                        arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                                    } else {
                                        arrayList4 = arrayList;
                                    }
                                    arrayList = arrayList4;
                                    iterable = iterable2;
                                    jsonNode4 = jsonNode116;
                                    i18 = i32;
                                    str52 = str67;
                                    movieBoxProvider = this;
                                    break;
                                }
                                arrayList2 = arrayList;
                                hashSet = new HashSet();
                                arrayList3 = new ArrayList();
                                while (r4.hasNext()) {
                                    arrayList2 = arrayList2;
                                    if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                                        arrayList3.add(obj8);
                                    }
                                }
                                arrayListEmptyList = arrayList3;
                                if (arrayListEmptyList == null) {
                                    arrayListEmptyList = CollectionsKt.emptyList();
                                }
                                return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                            }
                            jsonNode3 = tree6.get(str814);
                            if (jsonNode3 != null) {
                                jsonNode4 = jsonNode3.get("subjects");
                            } else {
                                jsonNode4 = jsonNode;
                            }
                            if (jsonNode4 == null) {
                                JsonNode jsonNode117 = jsonNode;
                                return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode117, 2, jsonNode117);
                            }
                            iterable = (Iterable) jsonNode4;
                            arrayList = new ArrayList();
                            while (r29.hasNext()) {
                                JsonNode jsonNode118 = jsonNode4;
                                if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    jsonNode5 = jsonNode7.get("title");
                                    if (jsonNode5 != null) {
                                        iterable2 = iterable;
                                        i32 = i18;
                                        str67 = str52;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    } else {
                                        iterable2 = iterable;
                                        i32 = i18;
                                        str67 = str52;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    }
                                }
                                if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                    arrayList4 = arrayList;
                                    arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                                } else {
                                    arrayList4 = arrayList;
                                }
                                arrayList = arrayList4;
                                iterable = iterable2;
                                jsonNode4 = jsonNode118;
                                i18 = i32;
                                str52 = str67;
                                movieBoxProvider = this;
                                break;
                            }
                            arrayList2 = arrayList;
                            hashSet = new HashSet();
                            arrayList3 = new ArrayList();
                            while (r4.hasNext()) {
                                arrayList2 = arrayList2;
                                if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                                    arrayList3.add(obj8);
                                }
                            }
                            arrayListEmptyList = arrayList3;
                            if (arrayListEmptyList == null) {
                                arrayListEmptyList = CollectionsKt.emptyList();
                            }
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                        }
                        List list11 = list5;
                        i22 = i12;
                        Requests app13 = MainActivityKt.getApp();
                        c00022.L$0 = mainPageRequest6;
                        mainPageRequest7 = mainPageRequest6;
                        c00022.L$1 = SpillingKt.nullOutSpilledVariable(str56);
                        c00022.L$2 = SpillingKt.nullOutSpilledVariable(str60);
                        c00022.L$3 = SpillingKt.nullOutSpilledVariable(list11);
                        c00022.L$4 = SpillingKt.nullOutSpilledVariable(str61);
                        c00022.L$5 = SpillingKt.nullOutSpilledVariable(map13);
                        c00022.L$6 = SpillingKt.nullOutSpilledVariable(str59);
                        c00022.L$7 = SpillingKt.nullOutSpilledVariable(str58);
                        c00022.L$8 = SpillingKt.nullOutSpilledVariable(str54);
                        c00022.L$9 = SpillingKt.nullOutSpilledVariable(str57);
                        c00022.L$10 = SpillingKt.nullOutSpilledVariable(str55);
                        c00022.L$11 = SpillingKt.nullOutSpilledVariable(str53);
                        c00022.L$12 = SpillingKt.nullOutSpilledVariable(map14);
                        c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody8);
                        c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse5);
                        c00022.I$0 = i21;
                        c00022.I$1 = i20;
                        c00022.I$2 = i22;
                        c00022.Z$0 = z8;
                        c00022.label = 8;
                        requestBody9 = requestBody8;
                        objPost$default = Requests.post$default(app13, str56, map14, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody9, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                        if (objPost$default == obj5) {
                            return obj5;
                        }
                        str62 = str59;
                        i23 = i21;
                        requestBody10 = requestBody9;
                        i24 = i20;
                        i25 = i22;
                        z9 = z8;
                        str63 = str55;
                        niceResponse6 = (NiceResponse) objPost$default;
                        i30 = i24;
                        requestBody11 = requestBody10;
                        mainPageRequest5 = mainPageRequest7;
                        str66 = str56;
                        i29 = i25;
                        i31 = i23;
                        niceResponse2 = niceResponse6;
                        str52 = str66;
                        i18 = i29;
                        i19 = i31;
                        JsonNode tree7 = ExtensionsKt.jacksonObjectMapper().readTree(niceResponse2.getText());
                        String str815 = str3;
                        jsonNode2 = tree7.get(str815);
                        if (jsonNode2 != null) {
                            jsonNode4 = jsonNode2.get("items");
                            if (jsonNode4 == null) {
                            }
                            iterable = (Iterable) jsonNode4;
                            arrayList = new ArrayList();
                            while (r29.hasNext()) {
                                JsonNode jsonNode119 = jsonNode4;
                                if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    jsonNode5 = jsonNode7.get("title");
                                    if (jsonNode5 != null) {
                                        iterable2 = iterable;
                                        i32 = i18;
                                        str67 = str52;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    } else {
                                        iterable2 = iterable;
                                        i32 = i18;
                                        str67 = str52;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    }
                                }
                                if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                    arrayList4 = arrayList;
                                    arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                                } else {
                                    arrayList4 = arrayList;
                                }
                                arrayList = arrayList4;
                                iterable = iterable2;
                                jsonNode4 = jsonNode119;
                                i18 = i32;
                                str52 = str67;
                                movieBoxProvider = this;
                                break;
                            }
                            arrayList2 = arrayList;
                            hashSet = new HashSet();
                            arrayList3 = new ArrayList();
                            while (r4.hasNext()) {
                                arrayList2 = arrayList2;
                                if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                                    arrayList3.add(obj8);
                                }
                            }
                            arrayListEmptyList = arrayList3;
                            if (arrayListEmptyList == null) {
                                arrayListEmptyList = CollectionsKt.emptyList();
                            }
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                        }
                        jsonNode3 = tree7.get(str815);
                        if (jsonNode3 != null) {
                            jsonNode4 = jsonNode3.get("subjects");
                        } else {
                            jsonNode4 = jsonNode;
                        }
                        if (jsonNode4 == null) {
                            JsonNode jsonNode1110 = jsonNode;
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode1110, 2, jsonNode1110);
                        }
                        iterable = (Iterable) jsonNode4;
                        arrayList = new ArrayList();
                        while (r29.hasNext()) {
                            JsonNode jsonNode1111 = jsonNode4;
                            if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                jsonNode5 = jsonNode7.get("title");
                                if (jsonNode5 != null) {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                arrayList4 = arrayList;
                                arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                arrayList4 = arrayList;
                            }
                            arrayList = arrayList4;
                            iterable = iterable2;
                            jsonNode4 = jsonNode1111;
                            i18 = i32;
                            str52 = str67;
                            movieBoxProvider = this;
                            break;
                        }
                        arrayList2 = arrayList;
                        hashSet = new HashSet();
                        arrayList3 = new ArrayList();
                        while (r4.hasNext()) {
                            arrayList2 = arrayList2;
                            if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                                arrayList3.add(obj8);
                            }
                        }
                        arrayListEmptyList = arrayList3;
                        if (arrayListEmptyList == null) {
                            arrayListEmptyList = CollectionsKt.emptyList();
                        }
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                    }
                    c00022.L$0 = mainPageRequest5;
                    c00022.L$1 = str36;
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(str27);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(list4);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(str32);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(map5);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(str28);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(str29);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(str37);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(str38);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(str20);
                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(str35);
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(map4);
                    c00022.L$13 = requestBody3;
                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse2);
                    c00022.I$0 = i10;
                    c00022.I$1 = i9;
                    c00022.I$2 = i11;
                    c00022.Z$0 = z5;
                    c00022.label = 5;
                    i15 = i9;
                    requestBody6 = requestBody3;
                    str46 = str38;
                    i12 = i11;
                    map9 = map5;
                    str47 = str37;
                    obj5 = obj4;
                    z7 = z5;
                    objBuildAuthHeaders$default3 = buildAuthHeaders$default(movieBoxProvider, "GET", str36, null, null, null, false, c00022, 60, null);
                    if (objBuildAuthHeaders$default3 == obj5) {
                        return obj5;
                    }
                    String str816 = str36;
                    i16 = i10;
                    str48 = str816;
                    map10 = map9;
                    i17 = i15;
                    requestBody7 = requestBody6;
                    map11 = map4;
                    str49 = str35;
                    niceResponse4 = niceResponse2;
                    str50 = str20;
                    obj7 = objBuildAuthHeaders$default3;
                    str51 = str47;
                    niceResponse5 = niceResponse4;
                    str53 = str49;
                    map12 = (Map) obj7;
                    map13 = map10;
                    str54 = str51;
                    i20 = i17;
                    str55 = str50;
                    movieBoxProvider = this;
                    i21 = i16;
                    str56 = str48;
                    requestBody8 = requestBody7;
                    mainPageRequest6 = mainPageRequest5;
                    str57 = str46;
                    str58 = str29;
                    str59 = str28;
                    z8 = z7;
                    str60 = str27;
                    str61 = str32;
                    list5 = list4;
                    map14 = map12;
                    if (z8) {
                        Requests app14 = MainActivityKt.getApp();
                        c00022.L$0 = mainPageRequest6;
                        c00022.L$1 = SpillingKt.nullOutSpilledVariable(str56);
                        c00022.L$2 = SpillingKt.nullOutSpilledVariable(str60);
                        c00022.L$3 = SpillingKt.nullOutSpilledVariable(list5);
                        c00022.L$4 = SpillingKt.nullOutSpilledVariable(str61);
                        c00022.L$5 = SpillingKt.nullOutSpilledVariable(map13);
                        c00022.L$6 = SpillingKt.nullOutSpilledVariable(str59);
                        c00022.L$7 = SpillingKt.nullOutSpilledVariable(str58);
                        c00022.L$8 = SpillingKt.nullOutSpilledVariable(str54);
                        c00022.L$9 = SpillingKt.nullOutSpilledVariable(str57);
                        c00022.L$10 = SpillingKt.nullOutSpilledVariable(str55);
                        c00022.L$11 = SpillingKt.nullOutSpilledVariable(str53);
                        c00022.L$12 = SpillingKt.nullOutSpilledVariable(map14);
                        c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody8);
                        c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse5);
                        c00022.I$0 = i21;
                        c00022.I$1 = i20;
                        c00022.I$2 = i12;
                        c00022.Z$0 = z8;
                        c00022.label = 7;
                        i26 = i12;
                        objPost$default = Requests.get$default(app14, str56, map14, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                        if (objPost$default == obj5) {
                            return obj5;
                        }
                        int i312 = i20;
                        mainPageRequest8 = mainPageRequest6;
                        str64 = str59;
                        i27 = i312;
                        i28 = i21;
                        str65 = str55;
                        map15 = map14;
                        niceResponse6 = (NiceResponse) objPost$default;
                        mainPageRequest5 = mainPageRequest8;
                        i29 = i26;
                        str66 = str56;
                        i30 = i27;
                        requestBody11 = requestBody8;
                        i31 = i28;
                        niceResponse2 = niceResponse6;
                        str52 = str66;
                        i18 = i29;
                        i19 = i31;
                        JsonNode tree8 = ExtensionsKt.jacksonObjectMapper().readTree(niceResponse2.getText());
                        String str817 = str3;
                        jsonNode2 = tree8.get(str817);
                        if (jsonNode2 != null) {
                            jsonNode4 = jsonNode2.get("items");
                            if (jsonNode4 == null) {
                            }
                            iterable = (Iterable) jsonNode4;
                            arrayList = new ArrayList();
                            while (r29.hasNext()) {
                                JsonNode jsonNode1112 = jsonNode4;
                                if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    jsonNode5 = jsonNode7.get("title");
                                    if (jsonNode5 != null) {
                                        iterable2 = iterable;
                                        i32 = i18;
                                        str67 = str52;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    } else {
                                        iterable2 = iterable;
                                        i32 = i18;
                                        str67 = str52;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    }
                                }
                                if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                    arrayList4 = arrayList;
                                    arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                                } else {
                                    arrayList4 = arrayList;
                                }
                                arrayList = arrayList4;
                                iterable = iterable2;
                                jsonNode4 = jsonNode1112;
                                i18 = i32;
                                str52 = str67;
                                movieBoxProvider = this;
                                break;
                            }
                            arrayList2 = arrayList;
                            hashSet = new HashSet();
                            arrayList3 = new ArrayList();
                            while (r4.hasNext()) {
                                arrayList2 = arrayList2;
                                if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                                    arrayList3.add(obj8);
                                }
                            }
                            arrayListEmptyList = arrayList3;
                            if (arrayListEmptyList == null) {
                                arrayListEmptyList = CollectionsKt.emptyList();
                            }
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                        }
                        jsonNode3 = tree8.get(str817);
                        if (jsonNode3 != null) {
                            jsonNode4 = jsonNode3.get("subjects");
                        } else {
                            jsonNode4 = jsonNode;
                        }
                        if (jsonNode4 == null) {
                            JsonNode jsonNode1113 = jsonNode;
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode1113, 2, jsonNode1113);
                        }
                        iterable = (Iterable) jsonNode4;
                        arrayList = new ArrayList();
                        while (r29.hasNext()) {
                            JsonNode jsonNode1114 = jsonNode4;
                            if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                jsonNode5 = jsonNode7.get("title");
                                if (jsonNode5 != null) {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                arrayList4 = arrayList;
                                arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                arrayList4 = arrayList;
                            }
                            arrayList = arrayList4;
                            iterable = iterable2;
                            jsonNode4 = jsonNode1114;
                            i18 = i32;
                            str52 = str67;
                            movieBoxProvider = this;
                            break;
                        }
                        arrayList2 = arrayList;
                        hashSet = new HashSet();
                        arrayList3 = new ArrayList();
                        while (r4.hasNext()) {
                            arrayList2 = arrayList2;
                            if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                                arrayList3.add(obj8);
                            }
                        }
                        arrayListEmptyList = arrayList3;
                        if (arrayListEmptyList == null) {
                            arrayListEmptyList = CollectionsKt.emptyList();
                        }
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                    }
                    List list12 = list5;
                    i22 = i12;
                    Requests app15 = MainActivityKt.getApp();
                    c00022.L$0 = mainPageRequest6;
                    mainPageRequest7 = mainPageRequest6;
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(str56);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(str60);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(list12);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(str61);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(map13);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(str59);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(str58);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(str54);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(str57);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(str55);
                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(str53);
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(map14);
                    c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody8);
                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse5);
                    c00022.I$0 = i21;
                    c00022.I$1 = i20;
                    c00022.I$2 = i22;
                    c00022.Z$0 = z8;
                    c00022.label = 8;
                    requestBody9 = requestBody8;
                    objPost$default = Requests.post$default(app15, str56, map14, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody9, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                    if (objPost$default == obj5) {
                        return obj5;
                    }
                    str62 = str59;
                    i23 = i21;
                    requestBody10 = requestBody9;
                    i24 = i20;
                    i25 = i22;
                    z9 = z8;
                    str63 = str55;
                    niceResponse6 = (NiceResponse) objPost$default;
                    i30 = i24;
                    requestBody11 = requestBody10;
                    mainPageRequest5 = mainPageRequest7;
                    str66 = str56;
                    i29 = i25;
                    i31 = i23;
                    niceResponse2 = niceResponse6;
                    str52 = str66;
                    i18 = i29;
                    i19 = i31;
                    JsonNode tree9 = ExtensionsKt.jacksonObjectMapper().readTree(niceResponse2.getText());
                    String str818 = str3;
                    jsonNode2 = tree9.get(str818);
                    if (jsonNode2 != null) {
                        jsonNode4 = jsonNode2.get("items");
                        if (jsonNode4 == null) {
                        }
                        iterable = (Iterable) jsonNode4;
                        arrayList = new ArrayList();
                        while (r29.hasNext()) {
                            JsonNode jsonNode1115 = jsonNode4;
                            if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                jsonNode5 = jsonNode7.get("title");
                                if (jsonNode5 != null) {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                arrayList4 = arrayList;
                                arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                arrayList4 = arrayList;
                            }
                            arrayList = arrayList4;
                            iterable = iterable2;
                            jsonNode4 = jsonNode1115;
                            i18 = i32;
                            str52 = str67;
                            movieBoxProvider = this;
                            break;
                        }
                        arrayList2 = arrayList;
                        hashSet = new HashSet();
                        arrayList3 = new ArrayList();
                        while (r4.hasNext()) {
                            arrayList2 = arrayList2;
                            if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                                arrayList3.add(obj8);
                            }
                        }
                        arrayListEmptyList = arrayList3;
                        if (arrayListEmptyList == null) {
                            arrayListEmptyList = CollectionsKt.emptyList();
                        }
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                    }
                    jsonNode3 = tree9.get(str818);
                    if (jsonNode3 != null) {
                        jsonNode4 = jsonNode3.get("subjects");
                    } else {
                        jsonNode4 = jsonNode;
                    }
                    if (jsonNode4 == null) {
                        JsonNode jsonNode1116 = jsonNode;
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode1116, 2, jsonNode1116);
                    }
                    iterable = (Iterable) jsonNode4;
                    arrayList = new ArrayList();
                    while (r29.hasNext()) {
                        JsonNode jsonNode1117 = jsonNode4;
                        if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                            iterable2 = iterable;
                            i32 = i18;
                            str67 = str52;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            jsonNode5 = jsonNode7.get("title");
                            if (jsonNode5 != null) {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                        }
                        if (movieSearchResponseNewMovieSearchResponse$default != null) {
                            arrayList4 = arrayList;
                            arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                        } else {
                            arrayList4 = arrayList;
                        }
                        arrayList = arrayList4;
                        iterable = iterable2;
                        jsonNode4 = jsonNode1117;
                        i18 = i32;
                        str52 = str67;
                        movieBoxProvider = this;
                        break;
                    }
                    arrayList2 = arrayList;
                    hashSet = new HashSet();
                    arrayList3 = new ArrayList();
                    while (r4.hasNext()) {
                        arrayList2 = arrayList2;
                        if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                            arrayList3.add(obj8);
                        }
                    }
                    arrayListEmptyList = arrayList3;
                    if (arrayListEmptyList == null) {
                        arrayListEmptyList = CollectionsKt.emptyList();
                    }
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                }
                i9 = i8;
                obj2 = coroutine_suspended;
                Requests app16 = MainActivityKt.getApp();
                c00022.L$0 = mainPageRequest2;
                c00022.L$1 = str22;
                mainPageRequest3 = mainPageRequest2;
                c00022.L$2 = SpillingKt.nullOutSpilledVariable(str25);
                c00022.L$3 = SpillingKt.nullOutSpilledVariable(list3);
                c00022.L$4 = SpillingKt.nullOutSpilledVariable(str26);
                c00022.L$5 = SpillingKt.nullOutSpilledVariable(map3);
                c00022.L$6 = SpillingKt.nullOutSpilledVariable(str21);
                c00022.L$7 = SpillingKt.nullOutSpilledVariable(str8);
                c00022.L$8 = SpillingKt.nullOutSpilledVariable(str10);
                c00022.L$9 = SpillingKt.nullOutSpilledVariable(str19);
                c00022.L$10 = SpillingKt.nullOutSpilledVariable(str20);
                c00022.L$11 = str18;
                c00022.L$12 = SpillingKt.nullOutSpilledVariable(map4);
                c00022.L$13 = requestBodyCreate;
                c00022.I$0 = i7;
                c00022.I$1 = i9;
                c00022.I$2 = i6;
                c00022.Z$0 = z3;
                c00022.label = 4;
                objPost$default = Requests.post$default(app16, str22, map4, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                if (objPost$default == obj2) {
                    return obj2;
                }
                str27 = str25;
                list4 = list3;
                str28 = str21;
                i10 = i7;
                str29 = str8;
                z4 = z3;
                str30 = str18;
                requestBody = requestBodyCreate;
                str31 = str19;
                str32 = str26;
                str35 = str30;
                mainPageRequest5 = mainPageRequest3;
                obj4 = obj2;
                str36 = str22;
                z5 = z4;
                str37 = str10;
                i11 = i6;
                map5 = map3;
                requestBody3 = requestBody;
                niceResponse = (NiceResponse) objPost$default;
                str38 = str31;
                niceResponse2 = niceResponse;
                if (niceResponse2.getCode() != 401) {
                }
                bearerToken = jsonNode;
                sharedPreferences = movieBoxProvider.sharedPref;
                if (sharedPreferences != null) {
                    editorRemove.apply();
                    Unit unit4 = Unit.INSTANCE;
                }
                if (!z5) {
                    map6 = map5;
                    str39 = str37;
                    str40 = str38;
                    z6 = z5;
                    i12 = i11;
                    i13 = i9;
                    requestBody4 = requestBody3;
                    obj5 = obj4;
                    c00022.L$0 = mainPageRequest5;
                    c00022.L$1 = str36;
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(str27);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(list4);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(str32);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(map6);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(str28);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(str29);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(str39);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(str40);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(str20);
                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(str35);
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(map4);
                    c00022.L$13 = requestBody4;
                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse2);
                    c00022.I$0 = i10;
                    c00022.I$1 = i13;
                    c00022.I$2 = i12;
                    c00022.Z$0 = z6;
                    c00022.label = 6;
                    str41 = str35;
                    movieBoxProvider = this;
                    objBuildAuthHeaders$default2 = buildAuthHeaders$default(movieBoxProvider, "POST", str36, "application/json; charset=utf-8", null, str41, false, c00022, 40, null);
                    if (objBuildAuthHeaders$default2 == obj5) {
                        return obj5;
                    }
                    i14 = i10;
                    str42 = str36;
                    str43 = str41;
                    requestBody5 = requestBody4;
                    map7 = map4;
                    niceResponse3 = niceResponse2;
                    str44 = str20;
                    str45 = str39;
                    obj6 = objBuildAuthHeaders$default2;
                    map8 = map6;
                    niceResponse5 = niceResponse3;
                    str53 = str43;
                    map12 = (Map) obj6;
                    map13 = map8;
                    str54 = str45;
                    i20 = i13;
                    str55 = str44;
                    i21 = i14;
                    requestBody8 = requestBody5;
                    str57 = str40;
                    str58 = str29;
                    str59 = str28;
                    str60 = str27;
                    str56 = str42;
                    mainPageRequest6 = mainPageRequest5;
                    z8 = z6;
                    list5 = list4;
                    str61 = str32;
                    map14 = map12;
                    if (z8) {
                        Requests app17 = MainActivityKt.getApp();
                        c00022.L$0 = mainPageRequest6;
                        c00022.L$1 = SpillingKt.nullOutSpilledVariable(str56);
                        c00022.L$2 = SpillingKt.nullOutSpilledVariable(str60);
                        c00022.L$3 = SpillingKt.nullOutSpilledVariable(list5);
                        c00022.L$4 = SpillingKt.nullOutSpilledVariable(str61);
                        c00022.L$5 = SpillingKt.nullOutSpilledVariable(map13);
                        c00022.L$6 = SpillingKt.nullOutSpilledVariable(str59);
                        c00022.L$7 = SpillingKt.nullOutSpilledVariable(str58);
                        c00022.L$8 = SpillingKt.nullOutSpilledVariable(str54);
                        c00022.L$9 = SpillingKt.nullOutSpilledVariable(str57);
                        c00022.L$10 = SpillingKt.nullOutSpilledVariable(str55);
                        c00022.L$11 = SpillingKt.nullOutSpilledVariable(str53);
                        c00022.L$12 = SpillingKt.nullOutSpilledVariable(map14);
                        c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody8);
                        c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse5);
                        c00022.I$0 = i21;
                        c00022.I$1 = i20;
                        c00022.I$2 = i12;
                        c00022.Z$0 = z8;
                        c00022.label = 7;
                        i26 = i12;
                        objPost$default = Requests.get$default(app17, str56, map14, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                        if (objPost$default == obj5) {
                            return obj5;
                        }
                        int i313 = i20;
                        mainPageRequest8 = mainPageRequest6;
                        str64 = str59;
                        i27 = i313;
                        i28 = i21;
                        str65 = str55;
                        map15 = map14;
                        niceResponse6 = (NiceResponse) objPost$default;
                        mainPageRequest5 = mainPageRequest8;
                        i29 = i26;
                        str66 = str56;
                        i30 = i27;
                        requestBody11 = requestBody8;
                        i31 = i28;
                        niceResponse2 = niceResponse6;
                        str52 = str66;
                        i18 = i29;
                        i19 = i31;
                        JsonNode tree10 = ExtensionsKt.jacksonObjectMapper().readTree(niceResponse2.getText());
                        String str819 = str3;
                        jsonNode2 = tree10.get(str819);
                        if (jsonNode2 != null) {
                            jsonNode4 = jsonNode2.get("items");
                            if (jsonNode4 == null) {
                            }
                            iterable = (Iterable) jsonNode4;
                            arrayList = new ArrayList();
                            while (r29.hasNext()) {
                                JsonNode jsonNode1118 = jsonNode4;
                                if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    jsonNode5 = jsonNode7.get("title");
                                    if (jsonNode5 != null) {
                                        iterable2 = iterable;
                                        i32 = i18;
                                        str67 = str52;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    } else {
                                        iterable2 = iterable;
                                        i32 = i18;
                                        str67 = str52;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    }
                                }
                                if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                    arrayList4 = arrayList;
                                    arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                                } else {
                                    arrayList4 = arrayList;
                                }
                                arrayList = arrayList4;
                                iterable = iterable2;
                                jsonNode4 = jsonNode1118;
                                i18 = i32;
                                str52 = str67;
                                movieBoxProvider = this;
                                break;
                            }
                            arrayList2 = arrayList;
                            hashSet = new HashSet();
                            arrayList3 = new ArrayList();
                            while (r4.hasNext()) {
                                arrayList2 = arrayList2;
                                if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                                    arrayList3.add(obj8);
                                }
                            }
                            arrayListEmptyList = arrayList3;
                            if (arrayListEmptyList == null) {
                                arrayListEmptyList = CollectionsKt.emptyList();
                            }
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                        }
                        jsonNode3 = tree10.get(str819);
                        if (jsonNode3 != null) {
                            jsonNode4 = jsonNode3.get("subjects");
                        } else {
                            jsonNode4 = jsonNode;
                        }
                        if (jsonNode4 == null) {
                            JsonNode jsonNode1119 = jsonNode;
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode1119, 2, jsonNode1119);
                        }
                        iterable = (Iterable) jsonNode4;
                        arrayList = new ArrayList();
                        while (r29.hasNext()) {
                            JsonNode jsonNode11110 = jsonNode4;
                            if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                jsonNode5 = jsonNode7.get("title");
                                if (jsonNode5 != null) {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                arrayList4 = arrayList;
                                arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                arrayList4 = arrayList;
                            }
                            arrayList = arrayList4;
                            iterable = iterable2;
                            jsonNode4 = jsonNode11110;
                            i18 = i32;
                            str52 = str67;
                            movieBoxProvider = this;
                            break;
                        }
                        arrayList2 = arrayList;
                        hashSet = new HashSet();
                        arrayList3 = new ArrayList();
                        while (r4.hasNext()) {
                            arrayList2 = arrayList2;
                            if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                                arrayList3.add(obj8);
                            }
                        }
                        arrayListEmptyList = arrayList3;
                        if (arrayListEmptyList == null) {
                            arrayListEmptyList = CollectionsKt.emptyList();
                        }
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                    }
                    List list13 = list5;
                    i22 = i12;
                    Requests app18 = MainActivityKt.getApp();
                    c00022.L$0 = mainPageRequest6;
                    mainPageRequest7 = mainPageRequest6;
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(str56);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(str60);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(list13);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(str61);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(map13);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(str59);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(str58);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(str54);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(str57);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(str55);
                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(str53);
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(map14);
                    c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody8);
                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse5);
                    c00022.I$0 = i21;
                    c00022.I$1 = i20;
                    c00022.I$2 = i22;
                    c00022.Z$0 = z8;
                    c00022.label = 8;
                    requestBody9 = requestBody8;
                    objPost$default = Requests.post$default(app18, str56, map14, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody9, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                    if (objPost$default == obj5) {
                        return obj5;
                    }
                    str62 = str59;
                    i23 = i21;
                    requestBody10 = requestBody9;
                    i24 = i20;
                    i25 = i22;
                    z9 = z8;
                    str63 = str55;
                    niceResponse6 = (NiceResponse) objPost$default;
                    i30 = i24;
                    requestBody11 = requestBody10;
                    mainPageRequest5 = mainPageRequest7;
                    str66 = str56;
                    i29 = i25;
                    i31 = i23;
                    niceResponse2 = niceResponse6;
                    str52 = str66;
                    i18 = i29;
                    i19 = i31;
                    JsonNode tree11 = ExtensionsKt.jacksonObjectMapper().readTree(niceResponse2.getText());
                    String str8110 = str3;
                    jsonNode2 = tree11.get(str8110);
                    if (jsonNode2 != null) {
                        jsonNode4 = jsonNode2.get("items");
                        if (jsonNode4 == null) {
                        }
                        iterable = (Iterable) jsonNode4;
                        arrayList = new ArrayList();
                        while (r29.hasNext()) {
                            JsonNode jsonNode11111 = jsonNode4;
                            if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                jsonNode5 = jsonNode7.get("title");
                                if (jsonNode5 != null) {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                arrayList4 = arrayList;
                                arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                arrayList4 = arrayList;
                            }
                            arrayList = arrayList4;
                            iterable = iterable2;
                            jsonNode4 = jsonNode11111;
                            i18 = i32;
                            str52 = str67;
                            movieBoxProvider = this;
                            break;
                        }
                        arrayList2 = arrayList;
                        hashSet = new HashSet();
                        arrayList3 = new ArrayList();
                        while (r4.hasNext()) {
                            arrayList2 = arrayList2;
                            if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                                arrayList3.add(obj8);
                            }
                        }
                        arrayListEmptyList = arrayList3;
                        if (arrayListEmptyList == null) {
                            arrayListEmptyList = CollectionsKt.emptyList();
                        }
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                    }
                    jsonNode3 = tree11.get(str8110);
                    if (jsonNode3 != null) {
                        jsonNode4 = jsonNode3.get("subjects");
                    } else {
                        jsonNode4 = jsonNode;
                    }
                    if (jsonNode4 == null) {
                        JsonNode jsonNode11112 = jsonNode;
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode11112, 2, jsonNode11112);
                    }
                    iterable = (Iterable) jsonNode4;
                    arrayList = new ArrayList();
                    while (r29.hasNext()) {
                        JsonNode jsonNode11113 = jsonNode4;
                        if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                            iterable2 = iterable;
                            i32 = i18;
                            str67 = str52;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            jsonNode5 = jsonNode7.get("title");
                            if (jsonNode5 != null) {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                        }
                        if (movieSearchResponseNewMovieSearchResponse$default != null) {
                            arrayList4 = arrayList;
                            arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                        } else {
                            arrayList4 = arrayList;
                        }
                        arrayList = arrayList4;
                        iterable = iterable2;
                        jsonNode4 = jsonNode11113;
                        i18 = i32;
                        str52 = str67;
                        movieBoxProvider = this;
                        break;
                    }
                    arrayList2 = arrayList;
                    hashSet = new HashSet();
                    arrayList3 = new ArrayList();
                    while (r4.hasNext()) {
                        arrayList2 = arrayList2;
                        if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                            arrayList3.add(obj8);
                        }
                    }
                    arrayListEmptyList = arrayList3;
                    if (arrayListEmptyList == null) {
                        arrayListEmptyList = CollectionsKt.emptyList();
                    }
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                }
                c00022.L$0 = mainPageRequest5;
                c00022.L$1 = str36;
                c00022.L$2 = SpillingKt.nullOutSpilledVariable(str27);
                c00022.L$3 = SpillingKt.nullOutSpilledVariable(list4);
                c00022.L$4 = SpillingKt.nullOutSpilledVariable(str32);
                c00022.L$5 = SpillingKt.nullOutSpilledVariable(map5);
                c00022.L$6 = SpillingKt.nullOutSpilledVariable(str28);
                c00022.L$7 = SpillingKt.nullOutSpilledVariable(str29);
                c00022.L$8 = SpillingKt.nullOutSpilledVariable(str37);
                c00022.L$9 = SpillingKt.nullOutSpilledVariable(str38);
                c00022.L$10 = SpillingKt.nullOutSpilledVariable(str20);
                c00022.L$11 = SpillingKt.nullOutSpilledVariable(str35);
                c00022.L$12 = SpillingKt.nullOutSpilledVariable(map4);
                c00022.L$13 = requestBody3;
                c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse2);
                c00022.I$0 = i10;
                c00022.I$1 = i9;
                c00022.I$2 = i11;
                c00022.Z$0 = z5;
                c00022.label = 5;
                i15 = i9;
                requestBody6 = requestBody3;
                str46 = str38;
                i12 = i11;
                map9 = map5;
                str47 = str37;
                obj5 = obj4;
                z7 = z5;
                objBuildAuthHeaders$default3 = buildAuthHeaders$default(movieBoxProvider, "GET", str36, null, null, null, false, c00022, 60, null);
                if (objBuildAuthHeaders$default3 == obj5) {
                    return obj5;
                }
                String str8111 = str36;
                i16 = i10;
                str48 = str8111;
                map10 = map9;
                i17 = i15;
                requestBody7 = requestBody6;
                map11 = map4;
                str49 = str35;
                niceResponse4 = niceResponse2;
                str50 = str20;
                obj7 = objBuildAuthHeaders$default3;
                str51 = str47;
                niceResponse5 = niceResponse4;
                str53 = str49;
                map12 = (Map) obj7;
                map13 = map10;
                str54 = str51;
                i20 = i17;
                str55 = str50;
                movieBoxProvider = this;
                i21 = i16;
                str56 = str48;
                requestBody8 = requestBody7;
                mainPageRequest6 = mainPageRequest5;
                str57 = str46;
                str58 = str29;
                str59 = str28;
                z8 = z7;
                str60 = str27;
                str61 = str32;
                list5 = list4;
                map14 = map12;
                if (z8) {
                    Requests app19 = MainActivityKt.getApp();
                    c00022.L$0 = mainPageRequest6;
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(str56);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(str60);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(list5);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(str61);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(map13);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(str59);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(str58);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(str54);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(str57);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(str55);
                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(str53);
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(map14);
                    c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody8);
                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse5);
                    c00022.I$0 = i21;
                    c00022.I$1 = i20;
                    c00022.I$2 = i12;
                    c00022.Z$0 = z8;
                    c00022.label = 7;
                    i26 = i12;
                    objPost$default = Requests.get$default(app19, str56, map14, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                    if (objPost$default == obj5) {
                        return obj5;
                    }
                    int i314 = i20;
                    mainPageRequest8 = mainPageRequest6;
                    str64 = str59;
                    i27 = i314;
                    i28 = i21;
                    str65 = str55;
                    map15 = map14;
                    niceResponse6 = (NiceResponse) objPost$default;
                    mainPageRequest5 = mainPageRequest8;
                    i29 = i26;
                    str66 = str56;
                    i30 = i27;
                    requestBody11 = requestBody8;
                    i31 = i28;
                    niceResponse2 = niceResponse6;
                    str52 = str66;
                    i18 = i29;
                    i19 = i31;
                    JsonNode tree12 = ExtensionsKt.jacksonObjectMapper().readTree(niceResponse2.getText());
                    String str8112 = str3;
                    jsonNode2 = tree12.get(str8112);
                    if (jsonNode2 != null) {
                        jsonNode4 = jsonNode2.get("items");
                        if (jsonNode4 == null) {
                        }
                        iterable = (Iterable) jsonNode4;
                        arrayList = new ArrayList();
                        while (r29.hasNext()) {
                            JsonNode jsonNode11114 = jsonNode4;
                            if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                jsonNode5 = jsonNode7.get("title");
                                if (jsonNode5 != null) {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                arrayList4 = arrayList;
                                arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                arrayList4 = arrayList;
                            }
                            arrayList = arrayList4;
                            iterable = iterable2;
                            jsonNode4 = jsonNode11114;
                            i18 = i32;
                            str52 = str67;
                            movieBoxProvider = this;
                            break;
                        }
                        arrayList2 = arrayList;
                        hashSet = new HashSet();
                        arrayList3 = new ArrayList();
                        while (r4.hasNext()) {
                            arrayList2 = arrayList2;
                            if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                                arrayList3.add(obj8);
                            }
                        }
                        arrayListEmptyList = arrayList3;
                        if (arrayListEmptyList == null) {
                            arrayListEmptyList = CollectionsKt.emptyList();
                        }
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                    }
                    jsonNode3 = tree12.get(str8112);
                    if (jsonNode3 != null) {
                        jsonNode4 = jsonNode3.get("subjects");
                    } else {
                        jsonNode4 = jsonNode;
                    }
                    if (jsonNode4 == null) {
                        JsonNode jsonNode11115 = jsonNode;
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode11115, 2, jsonNode11115);
                    }
                    iterable = (Iterable) jsonNode4;
                    arrayList = new ArrayList();
                    while (r29.hasNext()) {
                        JsonNode jsonNode11116 = jsonNode4;
                        if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                            iterable2 = iterable;
                            i32 = i18;
                            str67 = str52;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            jsonNode5 = jsonNode7.get("title");
                            if (jsonNode5 != null) {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                        }
                        if (movieSearchResponseNewMovieSearchResponse$default != null) {
                            arrayList4 = arrayList;
                            arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                        } else {
                            arrayList4 = arrayList;
                        }
                        arrayList = arrayList4;
                        iterable = iterable2;
                        jsonNode4 = jsonNode11116;
                        i18 = i32;
                        str52 = str67;
                        movieBoxProvider = this;
                        break;
                    }
                    arrayList2 = arrayList;
                    hashSet = new HashSet();
                    arrayList3 = new ArrayList();
                    while (r4.hasNext()) {
                        arrayList2 = arrayList2;
                        if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                            arrayList3.add(obj8);
                        }
                    }
                    arrayListEmptyList = arrayList3;
                    if (arrayListEmptyList == null) {
                        arrayListEmptyList = CollectionsKt.emptyList();
                    }
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                }
                List list14 = list5;
                i22 = i12;
                Requests app110 = MainActivityKt.getApp();
                c00022.L$0 = mainPageRequest6;
                mainPageRequest7 = mainPageRequest6;
                c00022.L$1 = SpillingKt.nullOutSpilledVariable(str56);
                c00022.L$2 = SpillingKt.nullOutSpilledVariable(str60);
                c00022.L$3 = SpillingKt.nullOutSpilledVariable(list14);
                c00022.L$4 = SpillingKt.nullOutSpilledVariable(str61);
                c00022.L$5 = SpillingKt.nullOutSpilledVariable(map13);
                c00022.L$6 = SpillingKt.nullOutSpilledVariable(str59);
                c00022.L$7 = SpillingKt.nullOutSpilledVariable(str58);
                c00022.L$8 = SpillingKt.nullOutSpilledVariable(str54);
                c00022.L$9 = SpillingKt.nullOutSpilledVariable(str57);
                c00022.L$10 = SpillingKt.nullOutSpilledVariable(str55);
                c00022.L$11 = SpillingKt.nullOutSpilledVariable(str53);
                c00022.L$12 = SpillingKt.nullOutSpilledVariable(map14);
                c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody8);
                c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse5);
                c00022.I$0 = i21;
                c00022.I$1 = i20;
                c00022.I$2 = i22;
                c00022.Z$0 = z8;
                c00022.label = 8;
                requestBody9 = requestBody8;
                objPost$default = Requests.post$default(app110, str56, map14, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody9, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                if (objPost$default == obj5) {
                    return obj5;
                }
                str62 = str59;
                i23 = i21;
                requestBody10 = requestBody9;
                i24 = i20;
                i25 = i22;
                z9 = z8;
                str63 = str55;
                niceResponse6 = (NiceResponse) objPost$default;
                i30 = i24;
                requestBody11 = requestBody10;
                mainPageRequest5 = mainPageRequest7;
                str66 = str56;
                i29 = i25;
                i31 = i23;
                niceResponse2 = niceResponse6;
                str52 = str66;
                i18 = i29;
                i19 = i31;
                JsonNode tree13 = ExtensionsKt.jacksonObjectMapper().readTree(niceResponse2.getText());
                String str8113 = str3;
                jsonNode2 = tree13.get(str8113);
                if (jsonNode2 != null) {
                    jsonNode4 = jsonNode2.get("items");
                    if (jsonNode4 == null) {
                    }
                    iterable = (Iterable) jsonNode4;
                    arrayList = new ArrayList();
                    while (r29.hasNext()) {
                        JsonNode jsonNode11117 = jsonNode4;
                        if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                            iterable2 = iterable;
                            i32 = i18;
                            str67 = str52;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            jsonNode5 = jsonNode7.get("title");
                            if (jsonNode5 != null) {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                        }
                        if (movieSearchResponseNewMovieSearchResponse$default != null) {
                            arrayList4 = arrayList;
                            arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                        } else {
                            arrayList4 = arrayList;
                        }
                        arrayList = arrayList4;
                        iterable = iterable2;
                        jsonNode4 = jsonNode11117;
                        i18 = i32;
                        str52 = str67;
                        movieBoxProvider = this;
                        break;
                    }
                    arrayList2 = arrayList;
                    hashSet = new HashSet();
                    arrayList3 = new ArrayList();
                    while (r4.hasNext()) {
                        arrayList2 = arrayList2;
                        if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                            arrayList3.add(obj8);
                        }
                    }
                    arrayListEmptyList = arrayList3;
                    if (arrayListEmptyList == null) {
                        arrayListEmptyList = CollectionsKt.emptyList();
                    }
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                }
                jsonNode3 = tree13.get(str8113);
                if (jsonNode3 != null) {
                    jsonNode4 = jsonNode3.get("subjects");
                } else {
                    jsonNode4 = jsonNode;
                }
                if (jsonNode4 == null) {
                    JsonNode jsonNode11118 = jsonNode;
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode11118, 2, jsonNode11118);
                }
                iterable = (Iterable) jsonNode4;
                arrayList = new ArrayList();
                while (r29.hasNext()) {
                    JsonNode jsonNode11119 = jsonNode4;
                    if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                        iterable2 = iterable;
                        i32 = i18;
                        str67 = str52;
                        movieSearchResponseNewMovieSearchResponse$default = null;
                    } else {
                        jsonNode5 = jsonNode7.get("title");
                        if (jsonNode5 != null) {
                            iterable2 = iterable;
                            i32 = i18;
                            str67 = str52;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            iterable2 = iterable;
                            i32 = i18;
                            str67 = str52;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        }
                    }
                    if (movieSearchResponseNewMovieSearchResponse$default != null) {
                        arrayList4 = arrayList;
                        arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                    } else {
                        arrayList4 = arrayList;
                    }
                    arrayList = arrayList4;
                    iterable = iterable2;
                    jsonNode4 = jsonNode11119;
                    i18 = i32;
                    str52 = str67;
                    movieBoxProvider = this;
                    break;
                }
                arrayList2 = arrayList;
                hashSet = new HashSet();
                arrayList3 = new ArrayList();
                while (r4.hasNext()) {
                    arrayList2 = arrayList2;
                    if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                        arrayList3.add(obj8);
                    }
                }
                arrayListEmptyList = arrayList3;
                if (arrayListEmptyList == null) {
                    arrayListEmptyList = CollectionsKt.emptyList();
                }
                return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
            case 1:
                boolean z10 = c00022.Z$0;
                int i40 = c00022.I$2;
                i5 = c00022.I$1;
                int i41 = c00022.I$0;
                str14 = (String) c00022.L$11;
                str15 = (String) c00022.L$10;
                str16 = (String) c00022.L$9;
                str10 = (String) c00022.L$8;
                str8 = (String) c00022.L$7;
                String str94 = (String) c00022.L$6;
                Map map16 = (Map) c00022.L$5;
                str17 = (String) c00022.L$4;
                List list15 = (List) c00022.L$3;
                String str95 = (String) c00022.L$2;
                String str96 = (String) c00022.L$1;
                MainPageRequest mainPageRequest10 = (MainPageRequest) c00022.L$0;
                ResultKt.throwOnFailure(objPost$default);
                str12 = str94;
                mainPageRequest9 = mainPageRequest10;
                z2 = z10;
                str3 = "data";
                objBuildAuthHeaders$default = objPost$default;
                i33 = i41;
                map2 = map16;
                list = list15;
                str2 = str95;
                jsonNode = null;
                i4 = i40;
                obj = objBuildAuthHeaders$default;
                str13 = str96;
                str18 = str14;
                str19 = str16;
                i6 = i4;
                i7 = i33;
                map3 = map2;
                i8 = i5;
                mainPageRequest2 = mainPageRequest9;
                z3 = z2;
                movieBoxProvider = this;
                str20 = str15;
                str21 = str12;
                map4 = (Map) objBuildAuthHeaders$default;
                str22 = str13;
                list2 = list;
                str23 = str17;
                str24 = str2;
                str25 = str24;
                list3 = list2;
                str26 = str23;
                requestBodyCreate = RequestBody.Companion.create(str18, MediaType.Companion.get("application/json"));
                if (z3) {
                    Requests app111 = MainActivityKt.getApp();
                    c00022.L$0 = mainPageRequest2;
                    c00022.L$1 = str22;
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(str25);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(list3);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(str26);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(map3);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(str21);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(str8);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(str10);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(str19);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(str20);
                    c00022.L$11 = str18;
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(map4);
                    c00022.L$13 = requestBodyCreate;
                    c00022.I$0 = i7;
                    c00022.I$1 = i8;
                    c00022.I$2 = i6;
                    c00022.Z$0 = z3;
                    c00022.label = 3;
                    obj3 = coroutine_suspended;
                    i9 = i8;
                    objPost$default = Requests.get$default(app111, str22, map4, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                    if (objPost$default == obj3) {
                        return obj3;
                    }
                    str27 = str25;
                    list4 = list3;
                    str28 = str21;
                    str29 = str8;
                    str33 = str19;
                    str32 = str26;
                    requestBody2 = requestBodyCreate;
                    mainPageRequest4 = mainPageRequest2;
                    i10 = i7;
                    str34 = str18;
                    str35 = str34;
                    obj4 = obj3;
                    str36 = str22;
                    z5 = z3;
                    mainPageRequest5 = mainPageRequest4;
                    str37 = str10;
                    i11 = i6;
                    map5 = map3;
                    requestBody3 = requestBody2;
                    niceResponse = (NiceResponse) objPost$default;
                    str38 = str33;
                    niceResponse2 = niceResponse;
                    if (niceResponse2.getCode() != 401) {
                        break;
                    }
                    bearerToken = jsonNode;
                    sharedPreferences = movieBoxProvider.sharedPref;
                    if (sharedPreferences != null) {
                        editorRemove.apply();
                        Unit unit5 = Unit.INSTANCE;
                    }
                    if (!z5) {
                        map6 = map5;
                        str39 = str37;
                        str40 = str38;
                        z6 = z5;
                        i12 = i11;
                        i13 = i9;
                        requestBody4 = requestBody3;
                        obj5 = obj4;
                        c00022.L$0 = mainPageRequest5;
                        c00022.L$1 = str36;
                        c00022.L$2 = SpillingKt.nullOutSpilledVariable(str27);
                        c00022.L$3 = SpillingKt.nullOutSpilledVariable(list4);
                        c00022.L$4 = SpillingKt.nullOutSpilledVariable(str32);
                        c00022.L$5 = SpillingKt.nullOutSpilledVariable(map6);
                        c00022.L$6 = SpillingKt.nullOutSpilledVariable(str28);
                        c00022.L$7 = SpillingKt.nullOutSpilledVariable(str29);
                        c00022.L$8 = SpillingKt.nullOutSpilledVariable(str39);
                        c00022.L$9 = SpillingKt.nullOutSpilledVariable(str40);
                        c00022.L$10 = SpillingKt.nullOutSpilledVariable(str20);
                        c00022.L$11 = SpillingKt.nullOutSpilledVariable(str35);
                        c00022.L$12 = SpillingKt.nullOutSpilledVariable(map4);
                        c00022.L$13 = requestBody4;
                        c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse2);
                        c00022.I$0 = i10;
                        c00022.I$1 = i13;
                        c00022.I$2 = i12;
                        c00022.Z$0 = z6;
                        c00022.label = 6;
                        str41 = str35;
                        movieBoxProvider = this;
                        objBuildAuthHeaders$default2 = buildAuthHeaders$default(movieBoxProvider, "POST", str36, "application/json; charset=utf-8", null, str41, false, c00022, 40, null);
                        if (objBuildAuthHeaders$default2 == obj5) {
                            return obj5;
                        }
                        i14 = i10;
                        str42 = str36;
                        str43 = str41;
                        requestBody5 = requestBody4;
                        map7 = map4;
                        niceResponse3 = niceResponse2;
                        str44 = str20;
                        str45 = str39;
                        obj6 = objBuildAuthHeaders$default2;
                        map8 = map6;
                        niceResponse5 = niceResponse3;
                        str53 = str43;
                        map12 = (Map) obj6;
                        map13 = map8;
                        str54 = str45;
                        i20 = i13;
                        str55 = str44;
                        i21 = i14;
                        requestBody8 = requestBody5;
                        str57 = str40;
                        str58 = str29;
                        str59 = str28;
                        str60 = str27;
                        str56 = str42;
                        mainPageRequest6 = mainPageRequest5;
                        z8 = z6;
                        list5 = list4;
                        str61 = str32;
                        map14 = map12;
                        if (z8) {
                            Requests app112 = MainActivityKt.getApp();
                            c00022.L$0 = mainPageRequest6;
                            c00022.L$1 = SpillingKt.nullOutSpilledVariable(str56);
                            c00022.L$2 = SpillingKt.nullOutSpilledVariable(str60);
                            c00022.L$3 = SpillingKt.nullOutSpilledVariable(list5);
                            c00022.L$4 = SpillingKt.nullOutSpilledVariable(str61);
                            c00022.L$5 = SpillingKt.nullOutSpilledVariable(map13);
                            c00022.L$6 = SpillingKt.nullOutSpilledVariable(str59);
                            c00022.L$7 = SpillingKt.nullOutSpilledVariable(str58);
                            c00022.L$8 = SpillingKt.nullOutSpilledVariable(str54);
                            c00022.L$9 = SpillingKt.nullOutSpilledVariable(str57);
                            c00022.L$10 = SpillingKt.nullOutSpilledVariable(str55);
                            c00022.L$11 = SpillingKt.nullOutSpilledVariable(str53);
                            c00022.L$12 = SpillingKt.nullOutSpilledVariable(map14);
                            c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody8);
                            c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse5);
                            c00022.I$0 = i21;
                            c00022.I$1 = i20;
                            c00022.I$2 = i12;
                            c00022.Z$0 = z8;
                            c00022.label = 7;
                            i26 = i12;
                            objPost$default = Requests.get$default(app112, str56, map14, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                            if (objPost$default == obj5) {
                                return obj5;
                            }
                            int i315 = i20;
                            mainPageRequest8 = mainPageRequest6;
                            str64 = str59;
                            i27 = i315;
                            i28 = i21;
                            str65 = str55;
                            map15 = map14;
                            niceResponse6 = (NiceResponse) objPost$default;
                            mainPageRequest5 = mainPageRequest8;
                            i29 = i26;
                            str66 = str56;
                            i30 = i27;
                            requestBody11 = requestBody8;
                            i31 = i28;
                            niceResponse2 = niceResponse6;
                            str52 = str66;
                            i18 = i29;
                            i19 = i31;
                            JsonNode tree14 = ExtensionsKt.jacksonObjectMapper().readTree(niceResponse2.getText());
                            String str8114 = str3;
                            jsonNode2 = tree14.get(str8114);
                            if (jsonNode2 != null) {
                                jsonNode4 = jsonNode2.get("items");
                                if (jsonNode4 == null) {
                                }
                                iterable = (Iterable) jsonNode4;
                                arrayList = new ArrayList();
                                while (r29.hasNext()) {
                                    JsonNode jsonNode111110 = jsonNode4;
                                    if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                                        iterable2 = iterable;
                                        i32 = i18;
                                        str67 = str52;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    } else {
                                        jsonNode5 = jsonNode7.get("title");
                                        if (jsonNode5 != null) {
                                            iterable2 = iterable;
                                            i32 = i18;
                                            str67 = str52;
                                            movieSearchResponseNewMovieSearchResponse$default = null;
                                        } else {
                                            iterable2 = iterable;
                                            i32 = i18;
                                            str67 = str52;
                                            movieSearchResponseNewMovieSearchResponse$default = null;
                                        }
                                    }
                                    if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                        arrayList4 = arrayList;
                                        arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                                    } else {
                                        arrayList4 = arrayList;
                                    }
                                    arrayList = arrayList4;
                                    iterable = iterable2;
                                    jsonNode4 = jsonNode111110;
                                    i18 = i32;
                                    str52 = str67;
                                    movieBoxProvider = this;
                                    break;
                                }
                                arrayList2 = arrayList;
                                hashSet = new HashSet();
                                arrayList3 = new ArrayList();
                                while (r4.hasNext()) {
                                    arrayList2 = arrayList2;
                                    if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                                        arrayList3.add(obj8);
                                    }
                                }
                                arrayListEmptyList = arrayList3;
                                if (arrayListEmptyList == null) {
                                    arrayListEmptyList = CollectionsKt.emptyList();
                                }
                                return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                            }
                            jsonNode3 = tree14.get(str8114);
                            if (jsonNode3 != null) {
                                jsonNode4 = jsonNode3.get("subjects");
                            } else {
                                jsonNode4 = jsonNode;
                            }
                            if (jsonNode4 == null) {
                                JsonNode jsonNode111111 = jsonNode;
                                return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode111111, 2, jsonNode111111);
                            }
                            iterable = (Iterable) jsonNode4;
                            arrayList = new ArrayList();
                            while (r29.hasNext()) {
                                JsonNode jsonNode111112 = jsonNode4;
                                if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    jsonNode5 = jsonNode7.get("title");
                                    if (jsonNode5 != null) {
                                        iterable2 = iterable;
                                        i32 = i18;
                                        str67 = str52;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    } else {
                                        iterable2 = iterable;
                                        i32 = i18;
                                        str67 = str52;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    }
                                }
                                if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                    arrayList4 = arrayList;
                                    arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                                } else {
                                    arrayList4 = arrayList;
                                }
                                arrayList = arrayList4;
                                iterable = iterable2;
                                jsonNode4 = jsonNode111112;
                                i18 = i32;
                                str52 = str67;
                                movieBoxProvider = this;
                                break;
                            }
                            arrayList2 = arrayList;
                            hashSet = new HashSet();
                            arrayList3 = new ArrayList();
                            while (r4.hasNext()) {
                                arrayList2 = arrayList2;
                                if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                                    arrayList3.add(obj8);
                                }
                            }
                            arrayListEmptyList = arrayList3;
                            if (arrayListEmptyList == null) {
                                arrayListEmptyList = CollectionsKt.emptyList();
                            }
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                        }
                        List list16 = list5;
                        i22 = i12;
                        Requests app113 = MainActivityKt.getApp();
                        c00022.L$0 = mainPageRequest6;
                        mainPageRequest7 = mainPageRequest6;
                        c00022.L$1 = SpillingKt.nullOutSpilledVariable(str56);
                        c00022.L$2 = SpillingKt.nullOutSpilledVariable(str60);
                        c00022.L$3 = SpillingKt.nullOutSpilledVariable(list16);
                        c00022.L$4 = SpillingKt.nullOutSpilledVariable(str61);
                        c00022.L$5 = SpillingKt.nullOutSpilledVariable(map13);
                        c00022.L$6 = SpillingKt.nullOutSpilledVariable(str59);
                        c00022.L$7 = SpillingKt.nullOutSpilledVariable(str58);
                        c00022.L$8 = SpillingKt.nullOutSpilledVariable(str54);
                        c00022.L$9 = SpillingKt.nullOutSpilledVariable(str57);
                        c00022.L$10 = SpillingKt.nullOutSpilledVariable(str55);
                        c00022.L$11 = SpillingKt.nullOutSpilledVariable(str53);
                        c00022.L$12 = SpillingKt.nullOutSpilledVariable(map14);
                        c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody8);
                        c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse5);
                        c00022.I$0 = i21;
                        c00022.I$1 = i20;
                        c00022.I$2 = i22;
                        c00022.Z$0 = z8;
                        c00022.label = 8;
                        requestBody9 = requestBody8;
                        objPost$default = Requests.post$default(app113, str56, map14, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody9, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                        if (objPost$default == obj5) {
                            return obj5;
                        }
                        str62 = str59;
                        i23 = i21;
                        requestBody10 = requestBody9;
                        i24 = i20;
                        i25 = i22;
                        z9 = z8;
                        str63 = str55;
                        niceResponse6 = (NiceResponse) objPost$default;
                        i30 = i24;
                        requestBody11 = requestBody10;
                        mainPageRequest5 = mainPageRequest7;
                        str66 = str56;
                        i29 = i25;
                        i31 = i23;
                        niceResponse2 = niceResponse6;
                        str52 = str66;
                        i18 = i29;
                        i19 = i31;
                        JsonNode tree15 = ExtensionsKt.jacksonObjectMapper().readTree(niceResponse2.getText());
                        String str8115 = str3;
                        jsonNode2 = tree15.get(str8115);
                        if (jsonNode2 != null) {
                            jsonNode4 = jsonNode2.get("items");
                            if (jsonNode4 == null) {
                            }
                            iterable = (Iterable) jsonNode4;
                            arrayList = new ArrayList();
                            while (r29.hasNext()) {
                                JsonNode jsonNode111113 = jsonNode4;
                                if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    jsonNode5 = jsonNode7.get("title");
                                    if (jsonNode5 != null) {
                                        iterable2 = iterable;
                                        i32 = i18;
                                        str67 = str52;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    } else {
                                        iterable2 = iterable;
                                        i32 = i18;
                                        str67 = str52;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    }
                                }
                                if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                    arrayList4 = arrayList;
                                    arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                                } else {
                                    arrayList4 = arrayList;
                                }
                                arrayList = arrayList4;
                                iterable = iterable2;
                                jsonNode4 = jsonNode111113;
                                i18 = i32;
                                str52 = str67;
                                movieBoxProvider = this;
                                break;
                            }
                            arrayList2 = arrayList;
                            hashSet = new HashSet();
                            arrayList3 = new ArrayList();
                            while (r4.hasNext()) {
                                arrayList2 = arrayList2;
                                if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                                    arrayList3.add(obj8);
                                }
                            }
                            arrayListEmptyList = arrayList3;
                            if (arrayListEmptyList == null) {
                                arrayListEmptyList = CollectionsKt.emptyList();
                            }
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                        }
                        jsonNode3 = tree15.get(str8115);
                        if (jsonNode3 != null) {
                            jsonNode4 = jsonNode3.get("subjects");
                        } else {
                            jsonNode4 = jsonNode;
                        }
                        if (jsonNode4 == null) {
                            JsonNode jsonNode111114 = jsonNode;
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode111114, 2, jsonNode111114);
                        }
                        iterable = (Iterable) jsonNode4;
                        arrayList = new ArrayList();
                        while (r29.hasNext()) {
                            JsonNode jsonNode111115 = jsonNode4;
                            if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                jsonNode5 = jsonNode7.get("title");
                                if (jsonNode5 != null) {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                arrayList4 = arrayList;
                                arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                arrayList4 = arrayList;
                            }
                            arrayList = arrayList4;
                            iterable = iterable2;
                            jsonNode4 = jsonNode111115;
                            i18 = i32;
                            str52 = str67;
                            movieBoxProvider = this;
                            break;
                        }
                        arrayList2 = arrayList;
                        hashSet = new HashSet();
                        arrayList3 = new ArrayList();
                        while (r4.hasNext()) {
                            arrayList2 = arrayList2;
                            if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                                arrayList3.add(obj8);
                            }
                        }
                        arrayListEmptyList = arrayList3;
                        if (arrayListEmptyList == null) {
                            arrayListEmptyList = CollectionsKt.emptyList();
                        }
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                    }
                    c00022.L$0 = mainPageRequest5;
                    c00022.L$1 = str36;
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(str27);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(list4);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(str32);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(map5);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(str28);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(str29);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(str37);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(str38);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(str20);
                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(str35);
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(map4);
                    c00022.L$13 = requestBody3;
                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse2);
                    c00022.I$0 = i10;
                    c00022.I$1 = i9;
                    c00022.I$2 = i11;
                    c00022.Z$0 = z5;
                    c00022.label = 5;
                    i15 = i9;
                    requestBody6 = requestBody3;
                    str46 = str38;
                    i12 = i11;
                    map9 = map5;
                    str47 = str37;
                    obj5 = obj4;
                    z7 = z5;
                    objBuildAuthHeaders$default3 = buildAuthHeaders$default(movieBoxProvider, "GET", str36, null, null, null, false, c00022, 60, null);
                    if (objBuildAuthHeaders$default3 == obj5) {
                        return obj5;
                    }
                    String str8116 = str36;
                    i16 = i10;
                    str48 = str8116;
                    map10 = map9;
                    i17 = i15;
                    requestBody7 = requestBody6;
                    map11 = map4;
                    str49 = str35;
                    niceResponse4 = niceResponse2;
                    str50 = str20;
                    obj7 = objBuildAuthHeaders$default3;
                    str51 = str47;
                    niceResponse5 = niceResponse4;
                    str53 = str49;
                    map12 = (Map) obj7;
                    map13 = map10;
                    str54 = str51;
                    i20 = i17;
                    str55 = str50;
                    movieBoxProvider = this;
                    i21 = i16;
                    str56 = str48;
                    requestBody8 = requestBody7;
                    mainPageRequest6 = mainPageRequest5;
                    str57 = str46;
                    str58 = str29;
                    str59 = str28;
                    z8 = z7;
                    str60 = str27;
                    str61 = str32;
                    list5 = list4;
                    map14 = map12;
                    if (z8) {
                        Requests app114 = MainActivityKt.getApp();
                        c00022.L$0 = mainPageRequest6;
                        c00022.L$1 = SpillingKt.nullOutSpilledVariable(str56);
                        c00022.L$2 = SpillingKt.nullOutSpilledVariable(str60);
                        c00022.L$3 = SpillingKt.nullOutSpilledVariable(list5);
                        c00022.L$4 = SpillingKt.nullOutSpilledVariable(str61);
                        c00022.L$5 = SpillingKt.nullOutSpilledVariable(map13);
                        c00022.L$6 = SpillingKt.nullOutSpilledVariable(str59);
                        c00022.L$7 = SpillingKt.nullOutSpilledVariable(str58);
                        c00022.L$8 = SpillingKt.nullOutSpilledVariable(str54);
                        c00022.L$9 = SpillingKt.nullOutSpilledVariable(str57);
                        c00022.L$10 = SpillingKt.nullOutSpilledVariable(str55);
                        c00022.L$11 = SpillingKt.nullOutSpilledVariable(str53);
                        c00022.L$12 = SpillingKt.nullOutSpilledVariable(map14);
                        c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody8);
                        c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse5);
                        c00022.I$0 = i21;
                        c00022.I$1 = i20;
                        c00022.I$2 = i12;
                        c00022.Z$0 = z8;
                        c00022.label = 7;
                        i26 = i12;
                        objPost$default = Requests.get$default(app114, str56, map14, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                        if (objPost$default == obj5) {
                            return obj5;
                        }
                        int i316 = i20;
                        mainPageRequest8 = mainPageRequest6;
                        str64 = str59;
                        i27 = i316;
                        i28 = i21;
                        str65 = str55;
                        map15 = map14;
                        niceResponse6 = (NiceResponse) objPost$default;
                        mainPageRequest5 = mainPageRequest8;
                        i29 = i26;
                        str66 = str56;
                        i30 = i27;
                        requestBody11 = requestBody8;
                        i31 = i28;
                        niceResponse2 = niceResponse6;
                        str52 = str66;
                        i18 = i29;
                        i19 = i31;
                        JsonNode tree16 = ExtensionsKt.jacksonObjectMapper().readTree(niceResponse2.getText());
                        String str8117 = str3;
                        jsonNode2 = tree16.get(str8117);
                        if (jsonNode2 != null) {
                            jsonNode4 = jsonNode2.get("items");
                            if (jsonNode4 == null) {
                            }
                            iterable = (Iterable) jsonNode4;
                            arrayList = new ArrayList();
                            while (r29.hasNext()) {
                                JsonNode jsonNode111116 = jsonNode4;
                                if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    jsonNode5 = jsonNode7.get("title");
                                    if (jsonNode5 != null) {
                                        iterable2 = iterable;
                                        i32 = i18;
                                        str67 = str52;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    } else {
                                        iterable2 = iterable;
                                        i32 = i18;
                                        str67 = str52;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    }
                                }
                                if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                    arrayList4 = arrayList;
                                    arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                                } else {
                                    arrayList4 = arrayList;
                                }
                                arrayList = arrayList4;
                                iterable = iterable2;
                                jsonNode4 = jsonNode111116;
                                i18 = i32;
                                str52 = str67;
                                movieBoxProvider = this;
                                break;
                            }
                            arrayList2 = arrayList;
                            hashSet = new HashSet();
                            arrayList3 = new ArrayList();
                            while (r4.hasNext()) {
                                arrayList2 = arrayList2;
                                if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                                    arrayList3.add(obj8);
                                }
                            }
                            arrayListEmptyList = arrayList3;
                            if (arrayListEmptyList == null) {
                                arrayListEmptyList = CollectionsKt.emptyList();
                            }
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                        }
                        jsonNode3 = tree16.get(str8117);
                        if (jsonNode3 != null) {
                            jsonNode4 = jsonNode3.get("subjects");
                        } else {
                            jsonNode4 = jsonNode;
                        }
                        if (jsonNode4 == null) {
                            JsonNode jsonNode111117 = jsonNode;
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode111117, 2, jsonNode111117);
                        }
                        iterable = (Iterable) jsonNode4;
                        arrayList = new ArrayList();
                        while (r29.hasNext()) {
                            JsonNode jsonNode111118 = jsonNode4;
                            if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                jsonNode5 = jsonNode7.get("title");
                                if (jsonNode5 != null) {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                arrayList4 = arrayList;
                                arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                arrayList4 = arrayList;
                            }
                            arrayList = arrayList4;
                            iterable = iterable2;
                            jsonNode4 = jsonNode111118;
                            i18 = i32;
                            str52 = str67;
                            movieBoxProvider = this;
                            break;
                        }
                        arrayList2 = arrayList;
                        hashSet = new HashSet();
                        arrayList3 = new ArrayList();
                        while (r4.hasNext()) {
                            arrayList2 = arrayList2;
                            if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                                arrayList3.add(obj8);
                            }
                        }
                        arrayListEmptyList = arrayList3;
                        if (arrayListEmptyList == null) {
                            arrayListEmptyList = CollectionsKt.emptyList();
                        }
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                    }
                    List list17 = list5;
                    i22 = i12;
                    Requests app115 = MainActivityKt.getApp();
                    c00022.L$0 = mainPageRequest6;
                    mainPageRequest7 = mainPageRequest6;
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(str56);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(str60);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(list17);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(str61);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(map13);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(str59);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(str58);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(str54);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(str57);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(str55);
                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(str53);
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(map14);
                    c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody8);
                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse5);
                    c00022.I$0 = i21;
                    c00022.I$1 = i20;
                    c00022.I$2 = i22;
                    c00022.Z$0 = z8;
                    c00022.label = 8;
                    requestBody9 = requestBody8;
                    objPost$default = Requests.post$default(app115, str56, map14, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody9, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                    if (objPost$default == obj5) {
                        return obj5;
                    }
                    str62 = str59;
                    i23 = i21;
                    requestBody10 = requestBody9;
                    i24 = i20;
                    i25 = i22;
                    z9 = z8;
                    str63 = str55;
                    niceResponse6 = (NiceResponse) objPost$default;
                    i30 = i24;
                    requestBody11 = requestBody10;
                    mainPageRequest5 = mainPageRequest7;
                    str66 = str56;
                    i29 = i25;
                    i31 = i23;
                    niceResponse2 = niceResponse6;
                    str52 = str66;
                    i18 = i29;
                    i19 = i31;
                    JsonNode tree17 = ExtensionsKt.jacksonObjectMapper().readTree(niceResponse2.getText());
                    String str8118 = str3;
                    jsonNode2 = tree17.get(str8118);
                    if (jsonNode2 != null) {
                        jsonNode4 = jsonNode2.get("items");
                        if (jsonNode4 == null) {
                        }
                        iterable = (Iterable) jsonNode4;
                        arrayList = new ArrayList();
                        while (r29.hasNext()) {
                            JsonNode jsonNode111119 = jsonNode4;
                            if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                jsonNode5 = jsonNode7.get("title");
                                if (jsonNode5 != null) {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                arrayList4 = arrayList;
                                arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                arrayList4 = arrayList;
                            }
                            arrayList = arrayList4;
                            iterable = iterable2;
                            jsonNode4 = jsonNode111119;
                            i18 = i32;
                            str52 = str67;
                            movieBoxProvider = this;
                            break;
                        }
                        arrayList2 = arrayList;
                        hashSet = new HashSet();
                        arrayList3 = new ArrayList();
                        while (r4.hasNext()) {
                            arrayList2 = arrayList2;
                            if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                                arrayList3.add(obj8);
                            }
                        }
                        arrayListEmptyList = arrayList3;
                        if (arrayListEmptyList == null) {
                            arrayListEmptyList = CollectionsKt.emptyList();
                        }
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                    }
                    jsonNode3 = tree17.get(str8118);
                    if (jsonNode3 != null) {
                        jsonNode4 = jsonNode3.get("subjects");
                    } else {
                        jsonNode4 = jsonNode;
                    }
                    if (jsonNode4 == null) {
                        JsonNode jsonNode1111110 = jsonNode;
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode1111110, 2, jsonNode1111110);
                    }
                    iterable = (Iterable) jsonNode4;
                    arrayList = new ArrayList();
                    while (r29.hasNext()) {
                        JsonNode jsonNode1111111 = jsonNode4;
                        if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                            iterable2 = iterable;
                            i32 = i18;
                            str67 = str52;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            jsonNode5 = jsonNode7.get("title");
                            if (jsonNode5 != null) {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                        }
                        if (movieSearchResponseNewMovieSearchResponse$default != null) {
                            arrayList4 = arrayList;
                            arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                        } else {
                            arrayList4 = arrayList;
                        }
                        arrayList = arrayList4;
                        iterable = iterable2;
                        jsonNode4 = jsonNode1111111;
                        i18 = i32;
                        str52 = str67;
                        movieBoxProvider = this;
                        break;
                    }
                    arrayList2 = arrayList;
                    hashSet = new HashSet();
                    arrayList3 = new ArrayList();
                    while (r4.hasNext()) {
                        arrayList2 = arrayList2;
                        if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                            arrayList3.add(obj8);
                        }
                    }
                    arrayListEmptyList = arrayList3;
                    if (arrayListEmptyList == null) {
                        arrayListEmptyList = CollectionsKt.emptyList();
                    }
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                }
                i9 = i8;
                obj2 = coroutine_suspended;
                Requests app116 = MainActivityKt.getApp();
                c00022.L$0 = mainPageRequest2;
                c00022.L$1 = str22;
                mainPageRequest3 = mainPageRequest2;
                c00022.L$2 = SpillingKt.nullOutSpilledVariable(str25);
                c00022.L$3 = SpillingKt.nullOutSpilledVariable(list3);
                c00022.L$4 = SpillingKt.nullOutSpilledVariable(str26);
                c00022.L$5 = SpillingKt.nullOutSpilledVariable(map3);
                c00022.L$6 = SpillingKt.nullOutSpilledVariable(str21);
                c00022.L$7 = SpillingKt.nullOutSpilledVariable(str8);
                c00022.L$8 = SpillingKt.nullOutSpilledVariable(str10);
                c00022.L$9 = SpillingKt.nullOutSpilledVariable(str19);
                c00022.L$10 = SpillingKt.nullOutSpilledVariable(str20);
                c00022.L$11 = str18;
                c00022.L$12 = SpillingKt.nullOutSpilledVariable(map4);
                c00022.L$13 = requestBodyCreate;
                c00022.I$0 = i7;
                c00022.I$1 = i9;
                c00022.I$2 = i6;
                c00022.Z$0 = z3;
                c00022.label = 4;
                objPost$default = Requests.post$default(app116, str22, map4, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                if (objPost$default == obj2) {
                    return obj2;
                }
                str27 = str25;
                list4 = list3;
                str28 = str21;
                i10 = i7;
                str29 = str8;
                z4 = z3;
                str30 = str18;
                requestBody = requestBodyCreate;
                str31 = str19;
                str32 = str26;
                str35 = str30;
                mainPageRequest5 = mainPageRequest3;
                obj4 = obj2;
                str36 = str22;
                z5 = z4;
                str37 = str10;
                i11 = i6;
                map5 = map3;
                requestBody3 = requestBody;
                niceResponse = (NiceResponse) objPost$default;
                str38 = str31;
                niceResponse2 = niceResponse;
                if (niceResponse2.getCode() != 401) {
                    break;
                }
                bearerToken = jsonNode;
                sharedPreferences = movieBoxProvider.sharedPref;
                if (sharedPreferences != null) {
                    editorRemove.apply();
                    Unit unit6 = Unit.INSTANCE;
                }
                if (!z5) {
                    map6 = map5;
                    str39 = str37;
                    str40 = str38;
                    z6 = z5;
                    i12 = i11;
                    i13 = i9;
                    requestBody4 = requestBody3;
                    obj5 = obj4;
                    c00022.L$0 = mainPageRequest5;
                    c00022.L$1 = str36;
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(str27);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(list4);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(str32);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(map6);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(str28);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(str29);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(str39);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(str40);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(str20);
                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(str35);
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(map4);
                    c00022.L$13 = requestBody4;
                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse2);
                    c00022.I$0 = i10;
                    c00022.I$1 = i13;
                    c00022.I$2 = i12;
                    c00022.Z$0 = z6;
                    c00022.label = 6;
                    str41 = str35;
                    movieBoxProvider = this;
                    objBuildAuthHeaders$default2 = buildAuthHeaders$default(movieBoxProvider, "POST", str36, "application/json; charset=utf-8", null, str41, false, c00022, 40, null);
                    if (objBuildAuthHeaders$default2 == obj5) {
                        return obj5;
                    }
                    i14 = i10;
                    str42 = str36;
                    str43 = str41;
                    requestBody5 = requestBody4;
                    map7 = map4;
                    niceResponse3 = niceResponse2;
                    str44 = str20;
                    str45 = str39;
                    obj6 = objBuildAuthHeaders$default2;
                    map8 = map6;
                    niceResponse5 = niceResponse3;
                    str53 = str43;
                    map12 = (Map) obj6;
                    map13 = map8;
                    str54 = str45;
                    i20 = i13;
                    str55 = str44;
                    i21 = i14;
                    requestBody8 = requestBody5;
                    str57 = str40;
                    str58 = str29;
                    str59 = str28;
                    str60 = str27;
                    str56 = str42;
                    mainPageRequest6 = mainPageRequest5;
                    z8 = z6;
                    list5 = list4;
                    str61 = str32;
                    map14 = map12;
                    if (z8) {
                        Requests app117 = MainActivityKt.getApp();
                        c00022.L$0 = mainPageRequest6;
                        c00022.L$1 = SpillingKt.nullOutSpilledVariable(str56);
                        c00022.L$2 = SpillingKt.nullOutSpilledVariable(str60);
                        c00022.L$3 = SpillingKt.nullOutSpilledVariable(list5);
                        c00022.L$4 = SpillingKt.nullOutSpilledVariable(str61);
                        c00022.L$5 = SpillingKt.nullOutSpilledVariable(map13);
                        c00022.L$6 = SpillingKt.nullOutSpilledVariable(str59);
                        c00022.L$7 = SpillingKt.nullOutSpilledVariable(str58);
                        c00022.L$8 = SpillingKt.nullOutSpilledVariable(str54);
                        c00022.L$9 = SpillingKt.nullOutSpilledVariable(str57);
                        c00022.L$10 = SpillingKt.nullOutSpilledVariable(str55);
                        c00022.L$11 = SpillingKt.nullOutSpilledVariable(str53);
                        c00022.L$12 = SpillingKt.nullOutSpilledVariable(map14);
                        c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody8);
                        c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse5);
                        c00022.I$0 = i21;
                        c00022.I$1 = i20;
                        c00022.I$2 = i12;
                        c00022.Z$0 = z8;
                        c00022.label = 7;
                        i26 = i12;
                        objPost$default = Requests.get$default(app117, str56, map14, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                        if (objPost$default == obj5) {
                            return obj5;
                        }
                        int i317 = i20;
                        mainPageRequest8 = mainPageRequest6;
                        str64 = str59;
                        i27 = i317;
                        i28 = i21;
                        str65 = str55;
                        map15 = map14;
                        niceResponse6 = (NiceResponse) objPost$default;
                        mainPageRequest5 = mainPageRequest8;
                        i29 = i26;
                        str66 = str56;
                        i30 = i27;
                        requestBody11 = requestBody8;
                        i31 = i28;
                        niceResponse2 = niceResponse6;
                        str52 = str66;
                        i18 = i29;
                        i19 = i31;
                        JsonNode tree18 = ExtensionsKt.jacksonObjectMapper().readTree(niceResponse2.getText());
                        String str8119 = str3;
                        jsonNode2 = tree18.get(str8119);
                        if (jsonNode2 != null) {
                            jsonNode4 = jsonNode2.get("items");
                            if (jsonNode4 == null) {
                            }
                            iterable = (Iterable) jsonNode4;
                            arrayList = new ArrayList();
                            while (r29.hasNext()) {
                                JsonNode jsonNode1111112 = jsonNode4;
                                if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    jsonNode5 = jsonNode7.get("title");
                                    if (jsonNode5 != null) {
                                        iterable2 = iterable;
                                        i32 = i18;
                                        str67 = str52;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    } else {
                                        iterable2 = iterable;
                                        i32 = i18;
                                        str67 = str52;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    }
                                }
                                if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                    arrayList4 = arrayList;
                                    arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                                } else {
                                    arrayList4 = arrayList;
                                }
                                arrayList = arrayList4;
                                iterable = iterable2;
                                jsonNode4 = jsonNode1111112;
                                i18 = i32;
                                str52 = str67;
                                movieBoxProvider = this;
                                break;
                            }
                            arrayList2 = arrayList;
                            hashSet = new HashSet();
                            arrayList3 = new ArrayList();
                            while (r4.hasNext()) {
                                arrayList2 = arrayList2;
                                if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                                    arrayList3.add(obj8);
                                }
                            }
                            arrayListEmptyList = arrayList3;
                            if (arrayListEmptyList == null) {
                                arrayListEmptyList = CollectionsKt.emptyList();
                            }
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                        }
                        jsonNode3 = tree18.get(str8119);
                        if (jsonNode3 != null) {
                            jsonNode4 = jsonNode3.get("subjects");
                        } else {
                            jsonNode4 = jsonNode;
                        }
                        if (jsonNode4 == null) {
                            JsonNode jsonNode1111113 = jsonNode;
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode1111113, 2, jsonNode1111113);
                        }
                        iterable = (Iterable) jsonNode4;
                        arrayList = new ArrayList();
                        while (r29.hasNext()) {
                            JsonNode jsonNode1111114 = jsonNode4;
                            if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                jsonNode5 = jsonNode7.get("title");
                                if (jsonNode5 != null) {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                arrayList4 = arrayList;
                                arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                arrayList4 = arrayList;
                            }
                            arrayList = arrayList4;
                            iterable = iterable2;
                            jsonNode4 = jsonNode1111114;
                            i18 = i32;
                            str52 = str67;
                            movieBoxProvider = this;
                            break;
                        }
                        arrayList2 = arrayList;
                        hashSet = new HashSet();
                        arrayList3 = new ArrayList();
                        while (r4.hasNext()) {
                            arrayList2 = arrayList2;
                            if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                                arrayList3.add(obj8);
                            }
                        }
                        arrayListEmptyList = arrayList3;
                        if (arrayListEmptyList == null) {
                            arrayListEmptyList = CollectionsKt.emptyList();
                        }
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                    }
                    List list18 = list5;
                    i22 = i12;
                    Requests app118 = MainActivityKt.getApp();
                    c00022.L$0 = mainPageRequest6;
                    mainPageRequest7 = mainPageRequest6;
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(str56);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(str60);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(list18);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(str61);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(map13);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(str59);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(str58);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(str54);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(str57);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(str55);
                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(str53);
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(map14);
                    c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody8);
                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse5);
                    c00022.I$0 = i21;
                    c00022.I$1 = i20;
                    c00022.I$2 = i22;
                    c00022.Z$0 = z8;
                    c00022.label = 8;
                    requestBody9 = requestBody8;
                    objPost$default = Requests.post$default(app118, str56, map14, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody9, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                    if (objPost$default == obj5) {
                        return obj5;
                    }
                    str62 = str59;
                    i23 = i21;
                    requestBody10 = requestBody9;
                    i24 = i20;
                    i25 = i22;
                    z9 = z8;
                    str63 = str55;
                    niceResponse6 = (NiceResponse) objPost$default;
                    i30 = i24;
                    requestBody11 = requestBody10;
                    mainPageRequest5 = mainPageRequest7;
                    str66 = str56;
                    i29 = i25;
                    i31 = i23;
                    niceResponse2 = niceResponse6;
                    str52 = str66;
                    i18 = i29;
                    i19 = i31;
                    JsonNode tree19 = ExtensionsKt.jacksonObjectMapper().readTree(niceResponse2.getText());
                    String str81110 = str3;
                    jsonNode2 = tree19.get(str81110);
                    if (jsonNode2 != null) {
                        jsonNode4 = jsonNode2.get("items");
                        if (jsonNode4 == null) {
                        }
                        iterable = (Iterable) jsonNode4;
                        arrayList = new ArrayList();
                        while (r29.hasNext()) {
                            JsonNode jsonNode1111115 = jsonNode4;
                            if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                jsonNode5 = jsonNode7.get("title");
                                if (jsonNode5 != null) {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                arrayList4 = arrayList;
                                arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                arrayList4 = arrayList;
                            }
                            arrayList = arrayList4;
                            iterable = iterable2;
                            jsonNode4 = jsonNode1111115;
                            i18 = i32;
                            str52 = str67;
                            movieBoxProvider = this;
                            break;
                        }
                        arrayList2 = arrayList;
                        hashSet = new HashSet();
                        arrayList3 = new ArrayList();
                        while (r4.hasNext()) {
                            arrayList2 = arrayList2;
                            if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                                arrayList3.add(obj8);
                            }
                        }
                        arrayListEmptyList = arrayList3;
                        if (arrayListEmptyList == null) {
                            arrayListEmptyList = CollectionsKt.emptyList();
                        }
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                    }
                    jsonNode3 = tree19.get(str81110);
                    if (jsonNode3 != null) {
                        jsonNode4 = jsonNode3.get("subjects");
                    } else {
                        jsonNode4 = jsonNode;
                    }
                    if (jsonNode4 == null) {
                        JsonNode jsonNode1111116 = jsonNode;
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode1111116, 2, jsonNode1111116);
                    }
                    iterable = (Iterable) jsonNode4;
                    arrayList = new ArrayList();
                    while (r29.hasNext()) {
                        JsonNode jsonNode1111117 = jsonNode4;
                        if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                            iterable2 = iterable;
                            i32 = i18;
                            str67 = str52;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            jsonNode5 = jsonNode7.get("title");
                            if (jsonNode5 != null) {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                        }
                        if (movieSearchResponseNewMovieSearchResponse$default != null) {
                            arrayList4 = arrayList;
                            arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                        } else {
                            arrayList4 = arrayList;
                        }
                        arrayList = arrayList4;
                        iterable = iterable2;
                        jsonNode4 = jsonNode1111117;
                        i18 = i32;
                        str52 = str67;
                        movieBoxProvider = this;
                        break;
                    }
                    arrayList2 = arrayList;
                    hashSet = new HashSet();
                    arrayList3 = new ArrayList();
                    while (r4.hasNext()) {
                        arrayList2 = arrayList2;
                        if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                            arrayList3.add(obj8);
                        }
                    }
                    arrayListEmptyList = arrayList3;
                    if (arrayListEmptyList == null) {
                        arrayListEmptyList = CollectionsKt.emptyList();
                    }
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                }
                c00022.L$0 = mainPageRequest5;
                c00022.L$1 = str36;
                c00022.L$2 = SpillingKt.nullOutSpilledVariable(str27);
                c00022.L$3 = SpillingKt.nullOutSpilledVariable(list4);
                c00022.L$4 = SpillingKt.nullOutSpilledVariable(str32);
                c00022.L$5 = SpillingKt.nullOutSpilledVariable(map5);
                c00022.L$6 = SpillingKt.nullOutSpilledVariable(str28);
                c00022.L$7 = SpillingKt.nullOutSpilledVariable(str29);
                c00022.L$8 = SpillingKt.nullOutSpilledVariable(str37);
                c00022.L$9 = SpillingKt.nullOutSpilledVariable(str38);
                c00022.L$10 = SpillingKt.nullOutSpilledVariable(str20);
                c00022.L$11 = SpillingKt.nullOutSpilledVariable(str35);
                c00022.L$12 = SpillingKt.nullOutSpilledVariable(map4);
                c00022.L$13 = requestBody3;
                c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse2);
                c00022.I$0 = i10;
                c00022.I$1 = i9;
                c00022.I$2 = i11;
                c00022.Z$0 = z5;
                c00022.label = 5;
                i15 = i9;
                requestBody6 = requestBody3;
                str46 = str38;
                i12 = i11;
                map9 = map5;
                str47 = str37;
                obj5 = obj4;
                z7 = z5;
                objBuildAuthHeaders$default3 = buildAuthHeaders$default(movieBoxProvider, "GET", str36, null, null, null, false, c00022, 60, null);
                if (objBuildAuthHeaders$default3 == obj5) {
                    return obj5;
                }
                String str81111 = str36;
                i16 = i10;
                str48 = str81111;
                map10 = map9;
                i17 = i15;
                requestBody7 = requestBody6;
                map11 = map4;
                str49 = str35;
                niceResponse4 = niceResponse2;
                str50 = str20;
                obj7 = objBuildAuthHeaders$default3;
                str51 = str47;
                niceResponse5 = niceResponse4;
                str53 = str49;
                map12 = (Map) obj7;
                map13 = map10;
                str54 = str51;
                i20 = i17;
                str55 = str50;
                movieBoxProvider = this;
                i21 = i16;
                str56 = str48;
                requestBody8 = requestBody7;
                mainPageRequest6 = mainPageRequest5;
                str57 = str46;
                str58 = str29;
                str59 = str28;
                z8 = z7;
                str60 = str27;
                str61 = str32;
                list5 = list4;
                map14 = map12;
                if (z8) {
                    Requests app119 = MainActivityKt.getApp();
                    c00022.L$0 = mainPageRequest6;
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(str56);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(str60);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(list5);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(str61);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(map13);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(str59);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(str58);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(str54);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(str57);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(str55);
                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(str53);
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(map14);
                    c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody8);
                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse5);
                    c00022.I$0 = i21;
                    c00022.I$1 = i20;
                    c00022.I$2 = i12;
                    c00022.Z$0 = z8;
                    c00022.label = 7;
                    i26 = i12;
                    objPost$default = Requests.get$default(app119, str56, map14, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                    if (objPost$default == obj5) {
                        return obj5;
                    }
                    int i318 = i20;
                    mainPageRequest8 = mainPageRequest6;
                    str64 = str59;
                    i27 = i318;
                    i28 = i21;
                    str65 = str55;
                    map15 = map14;
                    niceResponse6 = (NiceResponse) objPost$default;
                    mainPageRequest5 = mainPageRequest8;
                    i29 = i26;
                    str66 = str56;
                    i30 = i27;
                    requestBody11 = requestBody8;
                    i31 = i28;
                    niceResponse2 = niceResponse6;
                    str52 = str66;
                    i18 = i29;
                    i19 = i31;
                    JsonNode tree110 = ExtensionsKt.jacksonObjectMapper().readTree(niceResponse2.getText());
                    String str81112 = str3;
                    jsonNode2 = tree110.get(str81112);
                    if (jsonNode2 != null) {
                        jsonNode4 = jsonNode2.get("items");
                        if (jsonNode4 == null) {
                        }
                        iterable = (Iterable) jsonNode4;
                        arrayList = new ArrayList();
                        while (r29.hasNext()) {
                            JsonNode jsonNode1111118 = jsonNode4;
                            if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                jsonNode5 = jsonNode7.get("title");
                                if (jsonNode5 != null) {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                arrayList4 = arrayList;
                                arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                arrayList4 = arrayList;
                            }
                            arrayList = arrayList4;
                            iterable = iterable2;
                            jsonNode4 = jsonNode1111118;
                            i18 = i32;
                            str52 = str67;
                            movieBoxProvider = this;
                            break;
                        }
                        arrayList2 = arrayList;
                        hashSet = new HashSet();
                        arrayList3 = new ArrayList();
                        while (r4.hasNext()) {
                            arrayList2 = arrayList2;
                            if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                                arrayList3.add(obj8);
                            }
                        }
                        arrayListEmptyList = arrayList3;
                        if (arrayListEmptyList == null) {
                            arrayListEmptyList = CollectionsKt.emptyList();
                        }
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                    }
                    jsonNode3 = tree110.get(str81112);
                    if (jsonNode3 != null) {
                        jsonNode4 = jsonNode3.get("subjects");
                    } else {
                        jsonNode4 = jsonNode;
                    }
                    if (jsonNode4 == null) {
                        JsonNode jsonNode1111119 = jsonNode;
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode1111119, 2, jsonNode1111119);
                    }
                    iterable = (Iterable) jsonNode4;
                    arrayList = new ArrayList();
                    while (r29.hasNext()) {
                        JsonNode jsonNode11111110 = jsonNode4;
                        if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                            iterable2 = iterable;
                            i32 = i18;
                            str67 = str52;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            jsonNode5 = jsonNode7.get("title");
                            if (jsonNode5 != null) {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                        }
                        if (movieSearchResponseNewMovieSearchResponse$default != null) {
                            arrayList4 = arrayList;
                            arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                        } else {
                            arrayList4 = arrayList;
                        }
                        arrayList = arrayList4;
                        iterable = iterable2;
                        jsonNode4 = jsonNode11111110;
                        i18 = i32;
                        str52 = str67;
                        movieBoxProvider = this;
                        break;
                    }
                    arrayList2 = arrayList;
                    hashSet = new HashSet();
                    arrayList3 = new ArrayList();
                    while (r4.hasNext()) {
                        arrayList2 = arrayList2;
                        if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                            arrayList3.add(obj8);
                        }
                    }
                    arrayListEmptyList = arrayList3;
                    if (arrayListEmptyList == null) {
                        arrayListEmptyList = CollectionsKt.emptyList();
                    }
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                }
                List list19 = list5;
                i22 = i12;
                Requests app1110 = MainActivityKt.getApp();
                c00022.L$0 = mainPageRequest6;
                mainPageRequest7 = mainPageRequest6;
                c00022.L$1 = SpillingKt.nullOutSpilledVariable(str56);
                c00022.L$2 = SpillingKt.nullOutSpilledVariable(str60);
                c00022.L$3 = SpillingKt.nullOutSpilledVariable(list19);
                c00022.L$4 = SpillingKt.nullOutSpilledVariable(str61);
                c00022.L$5 = SpillingKt.nullOutSpilledVariable(map13);
                c00022.L$6 = SpillingKt.nullOutSpilledVariable(str59);
                c00022.L$7 = SpillingKt.nullOutSpilledVariable(str58);
                c00022.L$8 = SpillingKt.nullOutSpilledVariable(str54);
                c00022.L$9 = SpillingKt.nullOutSpilledVariable(str57);
                c00022.L$10 = SpillingKt.nullOutSpilledVariable(str55);
                c00022.L$11 = SpillingKt.nullOutSpilledVariable(str53);
                c00022.L$12 = SpillingKt.nullOutSpilledVariable(map14);
                c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody8);
                c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse5);
                c00022.I$0 = i21;
                c00022.I$1 = i20;
                c00022.I$2 = i22;
                c00022.Z$0 = z8;
                c00022.label = 8;
                requestBody9 = requestBody8;
                objPost$default = Requests.post$default(app1110, str56, map14, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody9, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                if (objPost$default == obj5) {
                    return obj5;
                }
                str62 = str59;
                i23 = i21;
                requestBody10 = requestBody9;
                i24 = i20;
                i25 = i22;
                z9 = z8;
                str63 = str55;
                niceResponse6 = (NiceResponse) objPost$default;
                i30 = i24;
                requestBody11 = requestBody10;
                mainPageRequest5 = mainPageRequest7;
                str66 = str56;
                i29 = i25;
                i31 = i23;
                niceResponse2 = niceResponse6;
                str52 = str66;
                i18 = i29;
                i19 = i31;
                JsonNode tree111 = ExtensionsKt.jacksonObjectMapper().readTree(niceResponse2.getText());
                String str81113 = str3;
                jsonNode2 = tree111.get(str81113);
                if (jsonNode2 != null) {
                    jsonNode4 = jsonNode2.get("items");
                    if (jsonNode4 == null) {
                    }
                    iterable = (Iterable) jsonNode4;
                    arrayList = new ArrayList();
                    while (r29.hasNext()) {
                        JsonNode jsonNode11111111 = jsonNode4;
                        if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                            iterable2 = iterable;
                            i32 = i18;
                            str67 = str52;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            jsonNode5 = jsonNode7.get("title");
                            if (jsonNode5 != null) {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                        }
                        if (movieSearchResponseNewMovieSearchResponse$default != null) {
                            arrayList4 = arrayList;
                            arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                        } else {
                            arrayList4 = arrayList;
                        }
                        arrayList = arrayList4;
                        iterable = iterable2;
                        jsonNode4 = jsonNode11111111;
                        i18 = i32;
                        str52 = str67;
                        movieBoxProvider = this;
                        break;
                    }
                    arrayList2 = arrayList;
                    hashSet = new HashSet();
                    arrayList3 = new ArrayList();
                    while (r4.hasNext()) {
                        arrayList2 = arrayList2;
                        if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                            arrayList3.add(obj8);
                        }
                    }
                    arrayListEmptyList = arrayList3;
                    if (arrayListEmptyList == null) {
                        arrayListEmptyList = CollectionsKt.emptyList();
                    }
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                }
                jsonNode3 = tree111.get(str81113);
                if (jsonNode3 != null) {
                    jsonNode4 = jsonNode3.get("subjects");
                } else {
                    jsonNode4 = jsonNode;
                }
                if (jsonNode4 == null) {
                    JsonNode jsonNode11111112 = jsonNode;
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode11111112, 2, jsonNode11111112);
                }
                iterable = (Iterable) jsonNode4;
                arrayList = new ArrayList();
                while (r29.hasNext()) {
                    JsonNode jsonNode11111113 = jsonNode4;
                    if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                        iterable2 = iterable;
                        i32 = i18;
                        str67 = str52;
                        movieSearchResponseNewMovieSearchResponse$default = null;
                    } else {
                        jsonNode5 = jsonNode7.get("title");
                        if (jsonNode5 != null) {
                            iterable2 = iterable;
                            i32 = i18;
                            str67 = str52;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            iterable2 = iterable;
                            i32 = i18;
                            str67 = str52;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        }
                    }
                    if (movieSearchResponseNewMovieSearchResponse$default != null) {
                        arrayList4 = arrayList;
                        arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                    } else {
                        arrayList4 = arrayList;
                    }
                    arrayList = arrayList4;
                    iterable = iterable2;
                    jsonNode4 = jsonNode11111113;
                    i18 = i32;
                    str52 = str67;
                    movieBoxProvider = this;
                    break;
                }
                arrayList2 = arrayList;
                hashSet = new HashSet();
                arrayList3 = new ArrayList();
                while (r4.hasNext()) {
                    arrayList2 = arrayList2;
                    if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                        arrayList3.add(obj8);
                    }
                }
                arrayListEmptyList = arrayList3;
                if (arrayListEmptyList == null) {
                    arrayListEmptyList = CollectionsKt.emptyList();
                }
                return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
            case 2:
                boolean z11 = c00022.Z$0;
                int i42 = c00022.I$2;
                int i43 = c00022.I$1;
                int i44 = c00022.I$0;
                str6 = (String) c00022.L$11;
                str7 = (String) c00022.L$10;
                str9 = (String) c00022.L$9;
                str10 = (String) c00022.L$8;
                str8 = (String) c00022.L$7;
                String str97 = (String) c00022.L$6;
                Map map17 = (Map) c00022.L$5;
                str11 = (String) c00022.L$4;
                List list20 = (List) c00022.L$3;
                String str98 = (String) c00022.L$2;
                String str99 = (String) c00022.L$1;
                MainPageRequest mainPageRequest11 = (MainPageRequest) c00022.L$0;
                ResultKt.throwOnFailure(objPost$default);
                z = z11;
                map = map17;
                list = list20;
                str4 = str97;
                mainPageRequest9 = mainPageRequest11;
                i2 = i43;
                str3 = "data";
                i33 = i44;
                str2 = str98;
                jsonNode = null;
                i3 = i42;
                obj = objPost$default;
                str5 = str99;
                str18 = str6;
                str20 = str7;
                str19 = str9;
                str21 = str4;
                i7 = i33;
                map3 = map;
                mainPageRequest2 = mainPageRequest9;
                map4 = (Map) objPost$default;
                z3 = z;
                i8 = i2;
                i6 = i3;
                str22 = str5;
                list2 = list;
                str24 = str2;
                str23 = str11;
                str25 = str24;
                list3 = list2;
                str26 = str23;
                requestBodyCreate = RequestBody.Companion.create(str18, MediaType.Companion.get("application/json"));
                if (z3) {
                    Requests app1111 = MainActivityKt.getApp();
                    c00022.L$0 = mainPageRequest2;
                    c00022.L$1 = str22;
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(str25);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(list3);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(str26);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(map3);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(str21);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(str8);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(str10);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(str19);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(str20);
                    c00022.L$11 = str18;
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(map4);
                    c00022.L$13 = requestBodyCreate;
                    c00022.I$0 = i7;
                    c00022.I$1 = i8;
                    c00022.I$2 = i6;
                    c00022.Z$0 = z3;
                    c00022.label = 3;
                    obj3 = coroutine_suspended;
                    i9 = i8;
                    objPost$default = Requests.get$default(app1111, str22, map4, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                    if (objPost$default == obj3) {
                        return obj3;
                    }
                    str27 = str25;
                    list4 = list3;
                    str28 = str21;
                    str29 = str8;
                    str33 = str19;
                    str32 = str26;
                    requestBody2 = requestBodyCreate;
                    mainPageRequest4 = mainPageRequest2;
                    i10 = i7;
                    str34 = str18;
                    str35 = str34;
                    obj4 = obj3;
                    str36 = str22;
                    z5 = z3;
                    mainPageRequest5 = mainPageRequest4;
                    str37 = str10;
                    i11 = i6;
                    map5 = map3;
                    requestBody3 = requestBody2;
                    niceResponse = (NiceResponse) objPost$default;
                    str38 = str33;
                    niceResponse2 = niceResponse;
                    if (niceResponse2.getCode() != 401) {
                        break;
                    }
                    bearerToken = jsonNode;
                    sharedPreferences = movieBoxProvider.sharedPref;
                    if (sharedPreferences != null) {
                        editorRemove.apply();
                        Unit unit7 = Unit.INSTANCE;
                    }
                    if (!z5) {
                        map6 = map5;
                        str39 = str37;
                        str40 = str38;
                        z6 = z5;
                        i12 = i11;
                        i13 = i9;
                        requestBody4 = requestBody3;
                        obj5 = obj4;
                        c00022.L$0 = mainPageRequest5;
                        c00022.L$1 = str36;
                        c00022.L$2 = SpillingKt.nullOutSpilledVariable(str27);
                        c00022.L$3 = SpillingKt.nullOutSpilledVariable(list4);
                        c00022.L$4 = SpillingKt.nullOutSpilledVariable(str32);
                        c00022.L$5 = SpillingKt.nullOutSpilledVariable(map6);
                        c00022.L$6 = SpillingKt.nullOutSpilledVariable(str28);
                        c00022.L$7 = SpillingKt.nullOutSpilledVariable(str29);
                        c00022.L$8 = SpillingKt.nullOutSpilledVariable(str39);
                        c00022.L$9 = SpillingKt.nullOutSpilledVariable(str40);
                        c00022.L$10 = SpillingKt.nullOutSpilledVariable(str20);
                        c00022.L$11 = SpillingKt.nullOutSpilledVariable(str35);
                        c00022.L$12 = SpillingKt.nullOutSpilledVariable(map4);
                        c00022.L$13 = requestBody4;
                        c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse2);
                        c00022.I$0 = i10;
                        c00022.I$1 = i13;
                        c00022.I$2 = i12;
                        c00022.Z$0 = z6;
                        c00022.label = 6;
                        str41 = str35;
                        movieBoxProvider = this;
                        objBuildAuthHeaders$default2 = buildAuthHeaders$default(movieBoxProvider, "POST", str36, "application/json; charset=utf-8", null, str41, false, c00022, 40, null);
                        if (objBuildAuthHeaders$default2 == obj5) {
                            return obj5;
                        }
                        i14 = i10;
                        str42 = str36;
                        str43 = str41;
                        requestBody5 = requestBody4;
                        map7 = map4;
                        niceResponse3 = niceResponse2;
                        str44 = str20;
                        str45 = str39;
                        obj6 = objBuildAuthHeaders$default2;
                        map8 = map6;
                        niceResponse5 = niceResponse3;
                        str53 = str43;
                        map12 = (Map) obj6;
                        map13 = map8;
                        str54 = str45;
                        i20 = i13;
                        str55 = str44;
                        i21 = i14;
                        requestBody8 = requestBody5;
                        str57 = str40;
                        str58 = str29;
                        str59 = str28;
                        str60 = str27;
                        str56 = str42;
                        mainPageRequest6 = mainPageRequest5;
                        z8 = z6;
                        list5 = list4;
                        str61 = str32;
                        map14 = map12;
                        if (z8) {
                            Requests app1112 = MainActivityKt.getApp();
                            c00022.L$0 = mainPageRequest6;
                            c00022.L$1 = SpillingKt.nullOutSpilledVariable(str56);
                            c00022.L$2 = SpillingKt.nullOutSpilledVariable(str60);
                            c00022.L$3 = SpillingKt.nullOutSpilledVariable(list5);
                            c00022.L$4 = SpillingKt.nullOutSpilledVariable(str61);
                            c00022.L$5 = SpillingKt.nullOutSpilledVariable(map13);
                            c00022.L$6 = SpillingKt.nullOutSpilledVariable(str59);
                            c00022.L$7 = SpillingKt.nullOutSpilledVariable(str58);
                            c00022.L$8 = SpillingKt.nullOutSpilledVariable(str54);
                            c00022.L$9 = SpillingKt.nullOutSpilledVariable(str57);
                            c00022.L$10 = SpillingKt.nullOutSpilledVariable(str55);
                            c00022.L$11 = SpillingKt.nullOutSpilledVariable(str53);
                            c00022.L$12 = SpillingKt.nullOutSpilledVariable(map14);
                            c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody8);
                            c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse5);
                            c00022.I$0 = i21;
                            c00022.I$1 = i20;
                            c00022.I$2 = i12;
                            c00022.Z$0 = z8;
                            c00022.label = 7;
                            i26 = i12;
                            objPost$default = Requests.get$default(app1112, str56, map14, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                            if (objPost$default == obj5) {
                                return obj5;
                            }
                            int i319 = i20;
                            mainPageRequest8 = mainPageRequest6;
                            str64 = str59;
                            i27 = i319;
                            i28 = i21;
                            str65 = str55;
                            map15 = map14;
                            niceResponse6 = (NiceResponse) objPost$default;
                            mainPageRequest5 = mainPageRequest8;
                            i29 = i26;
                            str66 = str56;
                            i30 = i27;
                            requestBody11 = requestBody8;
                            i31 = i28;
                            niceResponse2 = niceResponse6;
                            str52 = str66;
                            i18 = i29;
                            i19 = i31;
                            JsonNode tree112 = ExtensionsKt.jacksonObjectMapper().readTree(niceResponse2.getText());
                            String str81114 = str3;
                            jsonNode2 = tree112.get(str81114);
                            if (jsonNode2 != null) {
                                jsonNode4 = jsonNode2.get("items");
                                if (jsonNode4 == null) {
                                }
                                iterable = (Iterable) jsonNode4;
                                arrayList = new ArrayList();
                                while (r29.hasNext()) {
                                    JsonNode jsonNode11111114 = jsonNode4;
                                    if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                                        iterable2 = iterable;
                                        i32 = i18;
                                        str67 = str52;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    } else {
                                        jsonNode5 = jsonNode7.get("title");
                                        if (jsonNode5 != null) {
                                            iterable2 = iterable;
                                            i32 = i18;
                                            str67 = str52;
                                            movieSearchResponseNewMovieSearchResponse$default = null;
                                        } else {
                                            iterable2 = iterable;
                                            i32 = i18;
                                            str67 = str52;
                                            movieSearchResponseNewMovieSearchResponse$default = null;
                                        }
                                    }
                                    if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                        arrayList4 = arrayList;
                                        arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                                    } else {
                                        arrayList4 = arrayList;
                                    }
                                    arrayList = arrayList4;
                                    iterable = iterable2;
                                    jsonNode4 = jsonNode11111114;
                                    i18 = i32;
                                    str52 = str67;
                                    movieBoxProvider = this;
                                    break;
                                }
                                arrayList2 = arrayList;
                                hashSet = new HashSet();
                                arrayList3 = new ArrayList();
                                while (r4.hasNext()) {
                                    arrayList2 = arrayList2;
                                    if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                                        arrayList3.add(obj8);
                                    }
                                }
                                arrayListEmptyList = arrayList3;
                                if (arrayListEmptyList == null) {
                                    arrayListEmptyList = CollectionsKt.emptyList();
                                }
                                return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                            }
                            jsonNode3 = tree112.get(str81114);
                            if (jsonNode3 != null) {
                                jsonNode4 = jsonNode3.get("subjects");
                            } else {
                                jsonNode4 = jsonNode;
                            }
                            if (jsonNode4 == null) {
                                JsonNode jsonNode11111115 = jsonNode;
                                return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode11111115, 2, jsonNode11111115);
                            }
                            iterable = (Iterable) jsonNode4;
                            arrayList = new ArrayList();
                            while (r29.hasNext()) {
                                JsonNode jsonNode11111116 = jsonNode4;
                                if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    jsonNode5 = jsonNode7.get("title");
                                    if (jsonNode5 != null) {
                                        iterable2 = iterable;
                                        i32 = i18;
                                        str67 = str52;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    } else {
                                        iterable2 = iterable;
                                        i32 = i18;
                                        str67 = str52;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    }
                                }
                                if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                    arrayList4 = arrayList;
                                    arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                                } else {
                                    arrayList4 = arrayList;
                                }
                                arrayList = arrayList4;
                                iterable = iterable2;
                                jsonNode4 = jsonNode11111116;
                                i18 = i32;
                                str52 = str67;
                                movieBoxProvider = this;
                                break;
                            }
                            arrayList2 = arrayList;
                            hashSet = new HashSet();
                            arrayList3 = new ArrayList();
                            while (r4.hasNext()) {
                                arrayList2 = arrayList2;
                                if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                                    arrayList3.add(obj8);
                                }
                            }
                            arrayListEmptyList = arrayList3;
                            if (arrayListEmptyList == null) {
                                arrayListEmptyList = CollectionsKt.emptyList();
                            }
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                        }
                        List list110 = list5;
                        i22 = i12;
                        Requests app1113 = MainActivityKt.getApp();
                        c00022.L$0 = mainPageRequest6;
                        mainPageRequest7 = mainPageRequest6;
                        c00022.L$1 = SpillingKt.nullOutSpilledVariable(str56);
                        c00022.L$2 = SpillingKt.nullOutSpilledVariable(str60);
                        c00022.L$3 = SpillingKt.nullOutSpilledVariable(list110);
                        c00022.L$4 = SpillingKt.nullOutSpilledVariable(str61);
                        c00022.L$5 = SpillingKt.nullOutSpilledVariable(map13);
                        c00022.L$6 = SpillingKt.nullOutSpilledVariable(str59);
                        c00022.L$7 = SpillingKt.nullOutSpilledVariable(str58);
                        c00022.L$8 = SpillingKt.nullOutSpilledVariable(str54);
                        c00022.L$9 = SpillingKt.nullOutSpilledVariable(str57);
                        c00022.L$10 = SpillingKt.nullOutSpilledVariable(str55);
                        c00022.L$11 = SpillingKt.nullOutSpilledVariable(str53);
                        c00022.L$12 = SpillingKt.nullOutSpilledVariable(map14);
                        c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody8);
                        c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse5);
                        c00022.I$0 = i21;
                        c00022.I$1 = i20;
                        c00022.I$2 = i22;
                        c00022.Z$0 = z8;
                        c00022.label = 8;
                        requestBody9 = requestBody8;
                        objPost$default = Requests.post$default(app1113, str56, map14, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody9, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                        if (objPost$default == obj5) {
                            return obj5;
                        }
                        str62 = str59;
                        i23 = i21;
                        requestBody10 = requestBody9;
                        i24 = i20;
                        i25 = i22;
                        z9 = z8;
                        str63 = str55;
                        niceResponse6 = (NiceResponse) objPost$default;
                        i30 = i24;
                        requestBody11 = requestBody10;
                        mainPageRequest5 = mainPageRequest7;
                        str66 = str56;
                        i29 = i25;
                        i31 = i23;
                        niceResponse2 = niceResponse6;
                        str52 = str66;
                        i18 = i29;
                        i19 = i31;
                        JsonNode tree113 = ExtensionsKt.jacksonObjectMapper().readTree(niceResponse2.getText());
                        String str81115 = str3;
                        jsonNode2 = tree113.get(str81115);
                        if (jsonNode2 != null) {
                            jsonNode4 = jsonNode2.get("items");
                            if (jsonNode4 == null) {
                            }
                            iterable = (Iterable) jsonNode4;
                            arrayList = new ArrayList();
                            while (r29.hasNext()) {
                                JsonNode jsonNode11111117 = jsonNode4;
                                if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    jsonNode5 = jsonNode7.get("title");
                                    if (jsonNode5 != null) {
                                        iterable2 = iterable;
                                        i32 = i18;
                                        str67 = str52;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    } else {
                                        iterable2 = iterable;
                                        i32 = i18;
                                        str67 = str52;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    }
                                }
                                if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                    arrayList4 = arrayList;
                                    arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                                } else {
                                    arrayList4 = arrayList;
                                }
                                arrayList = arrayList4;
                                iterable = iterable2;
                                jsonNode4 = jsonNode11111117;
                                i18 = i32;
                                str52 = str67;
                                movieBoxProvider = this;
                                break;
                            }
                            arrayList2 = arrayList;
                            hashSet = new HashSet();
                            arrayList3 = new ArrayList();
                            while (r4.hasNext()) {
                                arrayList2 = arrayList2;
                                if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                                    arrayList3.add(obj8);
                                }
                            }
                            arrayListEmptyList = arrayList3;
                            if (arrayListEmptyList == null) {
                                arrayListEmptyList = CollectionsKt.emptyList();
                            }
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                        }
                        jsonNode3 = tree113.get(str81115);
                        if (jsonNode3 != null) {
                            jsonNode4 = jsonNode3.get("subjects");
                        } else {
                            jsonNode4 = jsonNode;
                        }
                        if (jsonNode4 == null) {
                            JsonNode jsonNode11111118 = jsonNode;
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode11111118, 2, jsonNode11111118);
                        }
                        iterable = (Iterable) jsonNode4;
                        arrayList = new ArrayList();
                        while (r29.hasNext()) {
                            JsonNode jsonNode11111119 = jsonNode4;
                            if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                jsonNode5 = jsonNode7.get("title");
                                if (jsonNode5 != null) {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                arrayList4 = arrayList;
                                arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                arrayList4 = arrayList;
                            }
                            arrayList = arrayList4;
                            iterable = iterable2;
                            jsonNode4 = jsonNode11111119;
                            i18 = i32;
                            str52 = str67;
                            movieBoxProvider = this;
                            break;
                        }
                        arrayList2 = arrayList;
                        hashSet = new HashSet();
                        arrayList3 = new ArrayList();
                        while (r4.hasNext()) {
                            arrayList2 = arrayList2;
                            if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                                arrayList3.add(obj8);
                            }
                        }
                        arrayListEmptyList = arrayList3;
                        if (arrayListEmptyList == null) {
                            arrayListEmptyList = CollectionsKt.emptyList();
                        }
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                    }
                    c00022.L$0 = mainPageRequest5;
                    c00022.L$1 = str36;
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(str27);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(list4);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(str32);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(map5);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(str28);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(str29);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(str37);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(str38);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(str20);
                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(str35);
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(map4);
                    c00022.L$13 = requestBody3;
                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse2);
                    c00022.I$0 = i10;
                    c00022.I$1 = i9;
                    c00022.I$2 = i11;
                    c00022.Z$0 = z5;
                    c00022.label = 5;
                    i15 = i9;
                    requestBody6 = requestBody3;
                    str46 = str38;
                    i12 = i11;
                    map9 = map5;
                    str47 = str37;
                    obj5 = obj4;
                    z7 = z5;
                    objBuildAuthHeaders$default3 = buildAuthHeaders$default(movieBoxProvider, "GET", str36, null, null, null, false, c00022, 60, null);
                    if (objBuildAuthHeaders$default3 == obj5) {
                        return obj5;
                    }
                    String str81116 = str36;
                    i16 = i10;
                    str48 = str81116;
                    map10 = map9;
                    i17 = i15;
                    requestBody7 = requestBody6;
                    map11 = map4;
                    str49 = str35;
                    niceResponse4 = niceResponse2;
                    str50 = str20;
                    obj7 = objBuildAuthHeaders$default3;
                    str51 = str47;
                    niceResponse5 = niceResponse4;
                    str53 = str49;
                    map12 = (Map) obj7;
                    map13 = map10;
                    str54 = str51;
                    i20 = i17;
                    str55 = str50;
                    movieBoxProvider = this;
                    i21 = i16;
                    str56 = str48;
                    requestBody8 = requestBody7;
                    mainPageRequest6 = mainPageRequest5;
                    str57 = str46;
                    str58 = str29;
                    str59 = str28;
                    z8 = z7;
                    str60 = str27;
                    str61 = str32;
                    list5 = list4;
                    map14 = map12;
                    if (z8) {
                        Requests app1114 = MainActivityKt.getApp();
                        c00022.L$0 = mainPageRequest6;
                        c00022.L$1 = SpillingKt.nullOutSpilledVariable(str56);
                        c00022.L$2 = SpillingKt.nullOutSpilledVariable(str60);
                        c00022.L$3 = SpillingKt.nullOutSpilledVariable(list5);
                        c00022.L$4 = SpillingKt.nullOutSpilledVariable(str61);
                        c00022.L$5 = SpillingKt.nullOutSpilledVariable(map13);
                        c00022.L$6 = SpillingKt.nullOutSpilledVariable(str59);
                        c00022.L$7 = SpillingKt.nullOutSpilledVariable(str58);
                        c00022.L$8 = SpillingKt.nullOutSpilledVariable(str54);
                        c00022.L$9 = SpillingKt.nullOutSpilledVariable(str57);
                        c00022.L$10 = SpillingKt.nullOutSpilledVariable(str55);
                        c00022.L$11 = SpillingKt.nullOutSpilledVariable(str53);
                        c00022.L$12 = SpillingKt.nullOutSpilledVariable(map14);
                        c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody8);
                        c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse5);
                        c00022.I$0 = i21;
                        c00022.I$1 = i20;
                        c00022.I$2 = i12;
                        c00022.Z$0 = z8;
                        c00022.label = 7;
                        i26 = i12;
                        objPost$default = Requests.get$default(app1114, str56, map14, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                        if (objPost$default == obj5) {
                            return obj5;
                        }
                        int i3110 = i20;
                        mainPageRequest8 = mainPageRequest6;
                        str64 = str59;
                        i27 = i3110;
                        i28 = i21;
                        str65 = str55;
                        map15 = map14;
                        niceResponse6 = (NiceResponse) objPost$default;
                        mainPageRequest5 = mainPageRequest8;
                        i29 = i26;
                        str66 = str56;
                        i30 = i27;
                        requestBody11 = requestBody8;
                        i31 = i28;
                        niceResponse2 = niceResponse6;
                        str52 = str66;
                        i18 = i29;
                        i19 = i31;
                        JsonNode tree114 = ExtensionsKt.jacksonObjectMapper().readTree(niceResponse2.getText());
                        String str81117 = str3;
                        jsonNode2 = tree114.get(str81117);
                        if (jsonNode2 != null) {
                            jsonNode4 = jsonNode2.get("items");
                            if (jsonNode4 == null) {
                            }
                            iterable = (Iterable) jsonNode4;
                            arrayList = new ArrayList();
                            while (r29.hasNext()) {
                                JsonNode jsonNode111111110 = jsonNode4;
                                if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    jsonNode5 = jsonNode7.get("title");
                                    if (jsonNode5 != null) {
                                        iterable2 = iterable;
                                        i32 = i18;
                                        str67 = str52;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    } else {
                                        iterable2 = iterable;
                                        i32 = i18;
                                        str67 = str52;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    }
                                }
                                if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                    arrayList4 = arrayList;
                                    arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                                } else {
                                    arrayList4 = arrayList;
                                }
                                arrayList = arrayList4;
                                iterable = iterable2;
                                jsonNode4 = jsonNode111111110;
                                i18 = i32;
                                str52 = str67;
                                movieBoxProvider = this;
                                break;
                            }
                            arrayList2 = arrayList;
                            hashSet = new HashSet();
                            arrayList3 = new ArrayList();
                            while (r4.hasNext()) {
                                arrayList2 = arrayList2;
                                if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                                    arrayList3.add(obj8);
                                }
                            }
                            arrayListEmptyList = arrayList3;
                            if (arrayListEmptyList == null) {
                                arrayListEmptyList = CollectionsKt.emptyList();
                            }
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                        }
                        jsonNode3 = tree114.get(str81117);
                        if (jsonNode3 != null) {
                            jsonNode4 = jsonNode3.get("subjects");
                        } else {
                            jsonNode4 = jsonNode;
                        }
                        if (jsonNode4 == null) {
                            JsonNode jsonNode111111111 = jsonNode;
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode111111111, 2, jsonNode111111111);
                        }
                        iterable = (Iterable) jsonNode4;
                        arrayList = new ArrayList();
                        while (r29.hasNext()) {
                            JsonNode jsonNode111111112 = jsonNode4;
                            if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                jsonNode5 = jsonNode7.get("title");
                                if (jsonNode5 != null) {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                arrayList4 = arrayList;
                                arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                arrayList4 = arrayList;
                            }
                            arrayList = arrayList4;
                            iterable = iterable2;
                            jsonNode4 = jsonNode111111112;
                            i18 = i32;
                            str52 = str67;
                            movieBoxProvider = this;
                            break;
                        }
                        arrayList2 = arrayList;
                        hashSet = new HashSet();
                        arrayList3 = new ArrayList();
                        while (r4.hasNext()) {
                            arrayList2 = arrayList2;
                            if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                                arrayList3.add(obj8);
                            }
                        }
                        arrayListEmptyList = arrayList3;
                        if (arrayListEmptyList == null) {
                            arrayListEmptyList = CollectionsKt.emptyList();
                        }
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                    }
                    List list111 = list5;
                    i22 = i12;
                    Requests app1115 = MainActivityKt.getApp();
                    c00022.L$0 = mainPageRequest6;
                    mainPageRequest7 = mainPageRequest6;
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(str56);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(str60);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(list111);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(str61);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(map13);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(str59);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(str58);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(str54);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(str57);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(str55);
                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(str53);
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(map14);
                    c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody8);
                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse5);
                    c00022.I$0 = i21;
                    c00022.I$1 = i20;
                    c00022.I$2 = i22;
                    c00022.Z$0 = z8;
                    c00022.label = 8;
                    requestBody9 = requestBody8;
                    objPost$default = Requests.post$default(app1115, str56, map14, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody9, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                    if (objPost$default == obj5) {
                        return obj5;
                    }
                    str62 = str59;
                    i23 = i21;
                    requestBody10 = requestBody9;
                    i24 = i20;
                    i25 = i22;
                    z9 = z8;
                    str63 = str55;
                    niceResponse6 = (NiceResponse) objPost$default;
                    i30 = i24;
                    requestBody11 = requestBody10;
                    mainPageRequest5 = mainPageRequest7;
                    str66 = str56;
                    i29 = i25;
                    i31 = i23;
                    niceResponse2 = niceResponse6;
                    str52 = str66;
                    i18 = i29;
                    i19 = i31;
                    JsonNode tree115 = ExtensionsKt.jacksonObjectMapper().readTree(niceResponse2.getText());
                    String str81118 = str3;
                    jsonNode2 = tree115.get(str81118);
                    if (jsonNode2 != null) {
                        jsonNode4 = jsonNode2.get("items");
                        if (jsonNode4 == null) {
                        }
                        iterable = (Iterable) jsonNode4;
                        arrayList = new ArrayList();
                        while (r29.hasNext()) {
                            JsonNode jsonNode111111113 = jsonNode4;
                            if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                jsonNode5 = jsonNode7.get("title");
                                if (jsonNode5 != null) {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                arrayList4 = arrayList;
                                arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                arrayList4 = arrayList;
                            }
                            arrayList = arrayList4;
                            iterable = iterable2;
                            jsonNode4 = jsonNode111111113;
                            i18 = i32;
                            str52 = str67;
                            movieBoxProvider = this;
                            break;
                        }
                        arrayList2 = arrayList;
                        hashSet = new HashSet();
                        arrayList3 = new ArrayList();
                        while (r4.hasNext()) {
                            arrayList2 = arrayList2;
                            if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                                arrayList3.add(obj8);
                            }
                        }
                        arrayListEmptyList = arrayList3;
                        if (arrayListEmptyList == null) {
                            arrayListEmptyList = CollectionsKt.emptyList();
                        }
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                    }
                    jsonNode3 = tree115.get(str81118);
                    if (jsonNode3 != null) {
                        jsonNode4 = jsonNode3.get("subjects");
                    } else {
                        jsonNode4 = jsonNode;
                    }
                    if (jsonNode4 == null) {
                        JsonNode jsonNode111111114 = jsonNode;
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode111111114, 2, jsonNode111111114);
                    }
                    iterable = (Iterable) jsonNode4;
                    arrayList = new ArrayList();
                    while (r29.hasNext()) {
                        JsonNode jsonNode111111115 = jsonNode4;
                        if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                            iterable2 = iterable;
                            i32 = i18;
                            str67 = str52;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            jsonNode5 = jsonNode7.get("title");
                            if (jsonNode5 != null) {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                        }
                        if (movieSearchResponseNewMovieSearchResponse$default != null) {
                            arrayList4 = arrayList;
                            arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                        } else {
                            arrayList4 = arrayList;
                        }
                        arrayList = arrayList4;
                        iterable = iterable2;
                        jsonNode4 = jsonNode111111115;
                        i18 = i32;
                        str52 = str67;
                        movieBoxProvider = this;
                        break;
                    }
                    arrayList2 = arrayList;
                    hashSet = new HashSet();
                    arrayList3 = new ArrayList();
                    while (r4.hasNext()) {
                        arrayList2 = arrayList2;
                        if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                            arrayList3.add(obj8);
                        }
                    }
                    arrayListEmptyList = arrayList3;
                    if (arrayListEmptyList == null) {
                        arrayListEmptyList = CollectionsKt.emptyList();
                    }
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                }
                i9 = i8;
                obj2 = coroutine_suspended;
                Requests app1116 = MainActivityKt.getApp();
                c00022.L$0 = mainPageRequest2;
                c00022.L$1 = str22;
                mainPageRequest3 = mainPageRequest2;
                c00022.L$2 = SpillingKt.nullOutSpilledVariable(str25);
                c00022.L$3 = SpillingKt.nullOutSpilledVariable(list3);
                c00022.L$4 = SpillingKt.nullOutSpilledVariable(str26);
                c00022.L$5 = SpillingKt.nullOutSpilledVariable(map3);
                c00022.L$6 = SpillingKt.nullOutSpilledVariable(str21);
                c00022.L$7 = SpillingKt.nullOutSpilledVariable(str8);
                c00022.L$8 = SpillingKt.nullOutSpilledVariable(str10);
                c00022.L$9 = SpillingKt.nullOutSpilledVariable(str19);
                c00022.L$10 = SpillingKt.nullOutSpilledVariable(str20);
                c00022.L$11 = str18;
                c00022.L$12 = SpillingKt.nullOutSpilledVariable(map4);
                c00022.L$13 = requestBodyCreate;
                c00022.I$0 = i7;
                c00022.I$1 = i9;
                c00022.I$2 = i6;
                c00022.Z$0 = z3;
                c00022.label = 4;
                objPost$default = Requests.post$default(app1116, str22, map4, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                if (objPost$default == obj2) {
                    return obj2;
                }
                str27 = str25;
                list4 = list3;
                str28 = str21;
                i10 = i7;
                str29 = str8;
                z4 = z3;
                str30 = str18;
                requestBody = requestBodyCreate;
                str31 = str19;
                str32 = str26;
                str35 = str30;
                mainPageRequest5 = mainPageRequest3;
                obj4 = obj2;
                str36 = str22;
                z5 = z4;
                str37 = str10;
                i11 = i6;
                map5 = map3;
                requestBody3 = requestBody;
                niceResponse = (NiceResponse) objPost$default;
                str38 = str31;
                niceResponse2 = niceResponse;
                if (niceResponse2.getCode() != 401) {
                    break;
                }
                bearerToken = jsonNode;
                sharedPreferences = movieBoxProvider.sharedPref;
                if (sharedPreferences != null) {
                    editorRemove.apply();
                    Unit unit8 = Unit.INSTANCE;
                }
                if (!z5) {
                    map6 = map5;
                    str39 = str37;
                    str40 = str38;
                    z6 = z5;
                    i12 = i11;
                    i13 = i9;
                    requestBody4 = requestBody3;
                    obj5 = obj4;
                    c00022.L$0 = mainPageRequest5;
                    c00022.L$1 = str36;
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(str27);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(list4);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(str32);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(map6);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(str28);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(str29);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(str39);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(str40);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(str20);
                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(str35);
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(map4);
                    c00022.L$13 = requestBody4;
                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse2);
                    c00022.I$0 = i10;
                    c00022.I$1 = i13;
                    c00022.I$2 = i12;
                    c00022.Z$0 = z6;
                    c00022.label = 6;
                    str41 = str35;
                    movieBoxProvider = this;
                    objBuildAuthHeaders$default2 = buildAuthHeaders$default(movieBoxProvider, "POST", str36, "application/json; charset=utf-8", null, str41, false, c00022, 40, null);
                    if (objBuildAuthHeaders$default2 == obj5) {
                        return obj5;
                    }
                    i14 = i10;
                    str42 = str36;
                    str43 = str41;
                    requestBody5 = requestBody4;
                    map7 = map4;
                    niceResponse3 = niceResponse2;
                    str44 = str20;
                    str45 = str39;
                    obj6 = objBuildAuthHeaders$default2;
                    map8 = map6;
                    niceResponse5 = niceResponse3;
                    str53 = str43;
                    map12 = (Map) obj6;
                    map13 = map8;
                    str54 = str45;
                    i20 = i13;
                    str55 = str44;
                    i21 = i14;
                    requestBody8 = requestBody5;
                    str57 = str40;
                    str58 = str29;
                    str59 = str28;
                    str60 = str27;
                    str56 = str42;
                    mainPageRequest6 = mainPageRequest5;
                    z8 = z6;
                    list5 = list4;
                    str61 = str32;
                    map14 = map12;
                    if (z8) {
                        Requests app1117 = MainActivityKt.getApp();
                        c00022.L$0 = mainPageRequest6;
                        c00022.L$1 = SpillingKt.nullOutSpilledVariable(str56);
                        c00022.L$2 = SpillingKt.nullOutSpilledVariable(str60);
                        c00022.L$3 = SpillingKt.nullOutSpilledVariable(list5);
                        c00022.L$4 = SpillingKt.nullOutSpilledVariable(str61);
                        c00022.L$5 = SpillingKt.nullOutSpilledVariable(map13);
                        c00022.L$6 = SpillingKt.nullOutSpilledVariable(str59);
                        c00022.L$7 = SpillingKt.nullOutSpilledVariable(str58);
                        c00022.L$8 = SpillingKt.nullOutSpilledVariable(str54);
                        c00022.L$9 = SpillingKt.nullOutSpilledVariable(str57);
                        c00022.L$10 = SpillingKt.nullOutSpilledVariable(str55);
                        c00022.L$11 = SpillingKt.nullOutSpilledVariable(str53);
                        c00022.L$12 = SpillingKt.nullOutSpilledVariable(map14);
                        c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody8);
                        c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse5);
                        c00022.I$0 = i21;
                        c00022.I$1 = i20;
                        c00022.I$2 = i12;
                        c00022.Z$0 = z8;
                        c00022.label = 7;
                        i26 = i12;
                        objPost$default = Requests.get$default(app1117, str56, map14, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                        if (objPost$default == obj5) {
                            return obj5;
                        }
                        int i3111 = i20;
                        mainPageRequest8 = mainPageRequest6;
                        str64 = str59;
                        i27 = i3111;
                        i28 = i21;
                        str65 = str55;
                        map15 = map14;
                        niceResponse6 = (NiceResponse) objPost$default;
                        mainPageRequest5 = mainPageRequest8;
                        i29 = i26;
                        str66 = str56;
                        i30 = i27;
                        requestBody11 = requestBody8;
                        i31 = i28;
                        niceResponse2 = niceResponse6;
                        str52 = str66;
                        i18 = i29;
                        i19 = i31;
                        JsonNode tree116 = ExtensionsKt.jacksonObjectMapper().readTree(niceResponse2.getText());
                        String str81119 = str3;
                        jsonNode2 = tree116.get(str81119);
                        if (jsonNode2 != null) {
                            jsonNode4 = jsonNode2.get("items");
                            if (jsonNode4 == null) {
                            }
                            iterable = (Iterable) jsonNode4;
                            arrayList = new ArrayList();
                            while (r29.hasNext()) {
                                JsonNode jsonNode111111116 = jsonNode4;
                                if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    jsonNode5 = jsonNode7.get("title");
                                    if (jsonNode5 != null) {
                                        iterable2 = iterable;
                                        i32 = i18;
                                        str67 = str52;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    } else {
                                        iterable2 = iterable;
                                        i32 = i18;
                                        str67 = str52;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    }
                                }
                                if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                    arrayList4 = arrayList;
                                    arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                                } else {
                                    arrayList4 = arrayList;
                                }
                                arrayList = arrayList4;
                                iterable = iterable2;
                                jsonNode4 = jsonNode111111116;
                                i18 = i32;
                                str52 = str67;
                                movieBoxProvider = this;
                                break;
                            }
                            arrayList2 = arrayList;
                            hashSet = new HashSet();
                            arrayList3 = new ArrayList();
                            while (r4.hasNext()) {
                                arrayList2 = arrayList2;
                                if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                                    arrayList3.add(obj8);
                                }
                            }
                            arrayListEmptyList = arrayList3;
                            if (arrayListEmptyList == null) {
                                arrayListEmptyList = CollectionsKt.emptyList();
                            }
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                        }
                        jsonNode3 = tree116.get(str81119);
                        if (jsonNode3 != null) {
                            jsonNode4 = jsonNode3.get("subjects");
                        } else {
                            jsonNode4 = jsonNode;
                        }
                        if (jsonNode4 == null) {
                            JsonNode jsonNode111111117 = jsonNode;
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode111111117, 2, jsonNode111111117);
                        }
                        iterable = (Iterable) jsonNode4;
                        arrayList = new ArrayList();
                        while (r29.hasNext()) {
                            JsonNode jsonNode111111118 = jsonNode4;
                            if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                jsonNode5 = jsonNode7.get("title");
                                if (jsonNode5 != null) {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                arrayList4 = arrayList;
                                arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                arrayList4 = arrayList;
                            }
                            arrayList = arrayList4;
                            iterable = iterable2;
                            jsonNode4 = jsonNode111111118;
                            i18 = i32;
                            str52 = str67;
                            movieBoxProvider = this;
                            break;
                        }
                        arrayList2 = arrayList;
                        hashSet = new HashSet();
                        arrayList3 = new ArrayList();
                        while (r4.hasNext()) {
                            arrayList2 = arrayList2;
                            if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                                arrayList3.add(obj8);
                            }
                        }
                        arrayListEmptyList = arrayList3;
                        if (arrayListEmptyList == null) {
                            arrayListEmptyList = CollectionsKt.emptyList();
                        }
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                    }
                    List list112 = list5;
                    i22 = i12;
                    Requests app1118 = MainActivityKt.getApp();
                    c00022.L$0 = mainPageRequest6;
                    mainPageRequest7 = mainPageRequest6;
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(str56);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(str60);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(list112);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(str61);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(map13);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(str59);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(str58);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(str54);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(str57);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(str55);
                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(str53);
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(map14);
                    c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody8);
                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse5);
                    c00022.I$0 = i21;
                    c00022.I$1 = i20;
                    c00022.I$2 = i22;
                    c00022.Z$0 = z8;
                    c00022.label = 8;
                    requestBody9 = requestBody8;
                    objPost$default = Requests.post$default(app1118, str56, map14, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody9, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                    if (objPost$default == obj5) {
                        return obj5;
                    }
                    str62 = str59;
                    i23 = i21;
                    requestBody10 = requestBody9;
                    i24 = i20;
                    i25 = i22;
                    z9 = z8;
                    str63 = str55;
                    niceResponse6 = (NiceResponse) objPost$default;
                    i30 = i24;
                    requestBody11 = requestBody10;
                    mainPageRequest5 = mainPageRequest7;
                    str66 = str56;
                    i29 = i25;
                    i31 = i23;
                    niceResponse2 = niceResponse6;
                    str52 = str66;
                    i18 = i29;
                    i19 = i31;
                    JsonNode tree117 = ExtensionsKt.jacksonObjectMapper().readTree(niceResponse2.getText());
                    String str811110 = str3;
                    jsonNode2 = tree117.get(str811110);
                    if (jsonNode2 != null) {
                        jsonNode4 = jsonNode2.get("items");
                        if (jsonNode4 == null) {
                        }
                        iterable = (Iterable) jsonNode4;
                        arrayList = new ArrayList();
                        while (r29.hasNext()) {
                            JsonNode jsonNode111111119 = jsonNode4;
                            if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                jsonNode5 = jsonNode7.get("title");
                                if (jsonNode5 != null) {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                arrayList4 = arrayList;
                                arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                arrayList4 = arrayList;
                            }
                            arrayList = arrayList4;
                            iterable = iterable2;
                            jsonNode4 = jsonNode111111119;
                            i18 = i32;
                            str52 = str67;
                            movieBoxProvider = this;
                            break;
                        }
                        arrayList2 = arrayList;
                        hashSet = new HashSet();
                        arrayList3 = new ArrayList();
                        while (r4.hasNext()) {
                            arrayList2 = arrayList2;
                            if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                                arrayList3.add(obj8);
                            }
                        }
                        arrayListEmptyList = arrayList3;
                        if (arrayListEmptyList == null) {
                            arrayListEmptyList = CollectionsKt.emptyList();
                        }
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                    }
                    jsonNode3 = tree117.get(str811110);
                    if (jsonNode3 != null) {
                        jsonNode4 = jsonNode3.get("subjects");
                    } else {
                        jsonNode4 = jsonNode;
                    }
                    if (jsonNode4 == null) {
                        JsonNode jsonNode1111111110 = jsonNode;
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode1111111110, 2, jsonNode1111111110);
                    }
                    iterable = (Iterable) jsonNode4;
                    arrayList = new ArrayList();
                    while (r29.hasNext()) {
                        JsonNode jsonNode1111111111 = jsonNode4;
                        if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                            iterable2 = iterable;
                            i32 = i18;
                            str67 = str52;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            jsonNode5 = jsonNode7.get("title");
                            if (jsonNode5 != null) {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                        }
                        if (movieSearchResponseNewMovieSearchResponse$default != null) {
                            arrayList4 = arrayList;
                            arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                        } else {
                            arrayList4 = arrayList;
                        }
                        arrayList = arrayList4;
                        iterable = iterable2;
                        jsonNode4 = jsonNode1111111111;
                        i18 = i32;
                        str52 = str67;
                        movieBoxProvider = this;
                        break;
                    }
                    arrayList2 = arrayList;
                    hashSet = new HashSet();
                    arrayList3 = new ArrayList();
                    while (r4.hasNext()) {
                        arrayList2 = arrayList2;
                        if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                            arrayList3.add(obj8);
                        }
                    }
                    arrayListEmptyList = arrayList3;
                    if (arrayListEmptyList == null) {
                        arrayListEmptyList = CollectionsKt.emptyList();
                    }
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                }
                c00022.L$0 = mainPageRequest5;
                c00022.L$1 = str36;
                c00022.L$2 = SpillingKt.nullOutSpilledVariable(str27);
                c00022.L$3 = SpillingKt.nullOutSpilledVariable(list4);
                c00022.L$4 = SpillingKt.nullOutSpilledVariable(str32);
                c00022.L$5 = SpillingKt.nullOutSpilledVariable(map5);
                c00022.L$6 = SpillingKt.nullOutSpilledVariable(str28);
                c00022.L$7 = SpillingKt.nullOutSpilledVariable(str29);
                c00022.L$8 = SpillingKt.nullOutSpilledVariable(str37);
                c00022.L$9 = SpillingKt.nullOutSpilledVariable(str38);
                c00022.L$10 = SpillingKt.nullOutSpilledVariable(str20);
                c00022.L$11 = SpillingKt.nullOutSpilledVariable(str35);
                c00022.L$12 = SpillingKt.nullOutSpilledVariable(map4);
                c00022.L$13 = requestBody3;
                c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse2);
                c00022.I$0 = i10;
                c00022.I$1 = i9;
                c00022.I$2 = i11;
                c00022.Z$0 = z5;
                c00022.label = 5;
                i15 = i9;
                requestBody6 = requestBody3;
                str46 = str38;
                i12 = i11;
                map9 = map5;
                str47 = str37;
                obj5 = obj4;
                z7 = z5;
                objBuildAuthHeaders$default3 = buildAuthHeaders$default(movieBoxProvider, "GET", str36, null, null, null, false, c00022, 60, null);
                if (objBuildAuthHeaders$default3 == obj5) {
                    return obj5;
                }
                String str811111 = str36;
                i16 = i10;
                str48 = str811111;
                map10 = map9;
                i17 = i15;
                requestBody7 = requestBody6;
                map11 = map4;
                str49 = str35;
                niceResponse4 = niceResponse2;
                str50 = str20;
                obj7 = objBuildAuthHeaders$default3;
                str51 = str47;
                niceResponse5 = niceResponse4;
                str53 = str49;
                map12 = (Map) obj7;
                map13 = map10;
                str54 = str51;
                i20 = i17;
                str55 = str50;
                movieBoxProvider = this;
                i21 = i16;
                str56 = str48;
                requestBody8 = requestBody7;
                mainPageRequest6 = mainPageRequest5;
                str57 = str46;
                str58 = str29;
                str59 = str28;
                z8 = z7;
                str60 = str27;
                str61 = str32;
                list5 = list4;
                map14 = map12;
                if (z8) {
                    Requests app1119 = MainActivityKt.getApp();
                    c00022.L$0 = mainPageRequest6;
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(str56);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(str60);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(list5);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(str61);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(map13);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(str59);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(str58);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(str54);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(str57);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(str55);
                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(str53);
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(map14);
                    c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody8);
                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse5);
                    c00022.I$0 = i21;
                    c00022.I$1 = i20;
                    c00022.I$2 = i12;
                    c00022.Z$0 = z8;
                    c00022.label = 7;
                    i26 = i12;
                    objPost$default = Requests.get$default(app1119, str56, map14, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                    if (objPost$default == obj5) {
                        return obj5;
                    }
                    int i3112 = i20;
                    mainPageRequest8 = mainPageRequest6;
                    str64 = str59;
                    i27 = i3112;
                    i28 = i21;
                    str65 = str55;
                    map15 = map14;
                    niceResponse6 = (NiceResponse) objPost$default;
                    mainPageRequest5 = mainPageRequest8;
                    i29 = i26;
                    str66 = str56;
                    i30 = i27;
                    requestBody11 = requestBody8;
                    i31 = i28;
                    niceResponse2 = niceResponse6;
                    str52 = str66;
                    i18 = i29;
                    i19 = i31;
                    JsonNode tree118 = ExtensionsKt.jacksonObjectMapper().readTree(niceResponse2.getText());
                    String str811112 = str3;
                    jsonNode2 = tree118.get(str811112);
                    if (jsonNode2 != null) {
                        jsonNode4 = jsonNode2.get("items");
                        if (jsonNode4 == null) {
                        }
                        iterable = (Iterable) jsonNode4;
                        arrayList = new ArrayList();
                        while (r29.hasNext()) {
                            JsonNode jsonNode1111111112 = jsonNode4;
                            if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                jsonNode5 = jsonNode7.get("title");
                                if (jsonNode5 != null) {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                arrayList4 = arrayList;
                                arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                arrayList4 = arrayList;
                            }
                            arrayList = arrayList4;
                            iterable = iterable2;
                            jsonNode4 = jsonNode1111111112;
                            i18 = i32;
                            str52 = str67;
                            movieBoxProvider = this;
                            break;
                        }
                        arrayList2 = arrayList;
                        hashSet = new HashSet();
                        arrayList3 = new ArrayList();
                        while (r4.hasNext()) {
                            arrayList2 = arrayList2;
                            if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                                arrayList3.add(obj8);
                            }
                        }
                        arrayListEmptyList = arrayList3;
                        if (arrayListEmptyList == null) {
                            arrayListEmptyList = CollectionsKt.emptyList();
                        }
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                    }
                    jsonNode3 = tree118.get(str811112);
                    if (jsonNode3 != null) {
                        jsonNode4 = jsonNode3.get("subjects");
                    } else {
                        jsonNode4 = jsonNode;
                    }
                    if (jsonNode4 == null) {
                        JsonNode jsonNode1111111113 = jsonNode;
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode1111111113, 2, jsonNode1111111113);
                    }
                    iterable = (Iterable) jsonNode4;
                    arrayList = new ArrayList();
                    while (r29.hasNext()) {
                        JsonNode jsonNode1111111114 = jsonNode4;
                        if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                            iterable2 = iterable;
                            i32 = i18;
                            str67 = str52;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            jsonNode5 = jsonNode7.get("title");
                            if (jsonNode5 != null) {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                        }
                        if (movieSearchResponseNewMovieSearchResponse$default != null) {
                            arrayList4 = arrayList;
                            arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                        } else {
                            arrayList4 = arrayList;
                        }
                        arrayList = arrayList4;
                        iterable = iterable2;
                        jsonNode4 = jsonNode1111111114;
                        i18 = i32;
                        str52 = str67;
                        movieBoxProvider = this;
                        break;
                    }
                    arrayList2 = arrayList;
                    hashSet = new HashSet();
                    arrayList3 = new ArrayList();
                    while (r4.hasNext()) {
                        arrayList2 = arrayList2;
                        if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                            arrayList3.add(obj8);
                        }
                    }
                    arrayListEmptyList = arrayList3;
                    if (arrayListEmptyList == null) {
                        arrayListEmptyList = CollectionsKt.emptyList();
                    }
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                }
                List list113 = list5;
                i22 = i12;
                Requests app11110 = MainActivityKt.getApp();
                c00022.L$0 = mainPageRequest6;
                mainPageRequest7 = mainPageRequest6;
                c00022.L$1 = SpillingKt.nullOutSpilledVariable(str56);
                c00022.L$2 = SpillingKt.nullOutSpilledVariable(str60);
                c00022.L$3 = SpillingKt.nullOutSpilledVariable(list113);
                c00022.L$4 = SpillingKt.nullOutSpilledVariable(str61);
                c00022.L$5 = SpillingKt.nullOutSpilledVariable(map13);
                c00022.L$6 = SpillingKt.nullOutSpilledVariable(str59);
                c00022.L$7 = SpillingKt.nullOutSpilledVariable(str58);
                c00022.L$8 = SpillingKt.nullOutSpilledVariable(str54);
                c00022.L$9 = SpillingKt.nullOutSpilledVariable(str57);
                c00022.L$10 = SpillingKt.nullOutSpilledVariable(str55);
                c00022.L$11 = SpillingKt.nullOutSpilledVariable(str53);
                c00022.L$12 = SpillingKt.nullOutSpilledVariable(map14);
                c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody8);
                c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse5);
                c00022.I$0 = i21;
                c00022.I$1 = i20;
                c00022.I$2 = i22;
                c00022.Z$0 = z8;
                c00022.label = 8;
                requestBody9 = requestBody8;
                objPost$default = Requests.post$default(app11110, str56, map14, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody9, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                if (objPost$default == obj5) {
                    return obj5;
                }
                str62 = str59;
                i23 = i21;
                requestBody10 = requestBody9;
                i24 = i20;
                i25 = i22;
                z9 = z8;
                str63 = str55;
                niceResponse6 = (NiceResponse) objPost$default;
                i30 = i24;
                requestBody11 = requestBody10;
                mainPageRequest5 = mainPageRequest7;
                str66 = str56;
                i29 = i25;
                i31 = i23;
                niceResponse2 = niceResponse6;
                str52 = str66;
                i18 = i29;
                i19 = i31;
                JsonNode tree119 = ExtensionsKt.jacksonObjectMapper().readTree(niceResponse2.getText());
                String str811113 = str3;
                jsonNode2 = tree119.get(str811113);
                if (jsonNode2 != null) {
                    jsonNode4 = jsonNode2.get("items");
                    if (jsonNode4 == null) {
                    }
                    iterable = (Iterable) jsonNode4;
                    arrayList = new ArrayList();
                    while (r29.hasNext()) {
                        JsonNode jsonNode1111111115 = jsonNode4;
                        if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                            iterable2 = iterable;
                            i32 = i18;
                            str67 = str52;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            jsonNode5 = jsonNode7.get("title");
                            if (jsonNode5 != null) {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                        }
                        if (movieSearchResponseNewMovieSearchResponse$default != null) {
                            arrayList4 = arrayList;
                            arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                        } else {
                            arrayList4 = arrayList;
                        }
                        arrayList = arrayList4;
                        iterable = iterable2;
                        jsonNode4 = jsonNode1111111115;
                        i18 = i32;
                        str52 = str67;
                        movieBoxProvider = this;
                        break;
                    }
                    arrayList2 = arrayList;
                    hashSet = new HashSet();
                    arrayList3 = new ArrayList();
                    while (r4.hasNext()) {
                        arrayList2 = arrayList2;
                        if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                            arrayList3.add(obj8);
                        }
                    }
                    arrayListEmptyList = arrayList3;
                    if (arrayListEmptyList == null) {
                        arrayListEmptyList = CollectionsKt.emptyList();
                    }
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                }
                jsonNode3 = tree119.get(str811113);
                if (jsonNode3 != null) {
                    jsonNode4 = jsonNode3.get("subjects");
                } else {
                    jsonNode4 = jsonNode;
                }
                if (jsonNode4 == null) {
                    JsonNode jsonNode1111111116 = jsonNode;
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode1111111116, 2, jsonNode1111111116);
                }
                iterable = (Iterable) jsonNode4;
                arrayList = new ArrayList();
                while (r29.hasNext()) {
                    JsonNode jsonNode1111111117 = jsonNode4;
                    if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                        iterable2 = iterable;
                        i32 = i18;
                        str67 = str52;
                        movieSearchResponseNewMovieSearchResponse$default = null;
                    } else {
                        jsonNode5 = jsonNode7.get("title");
                        if (jsonNode5 != null) {
                            iterable2 = iterable;
                            i32 = i18;
                            str67 = str52;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            iterable2 = iterable;
                            i32 = i18;
                            str67 = str52;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        }
                    }
                    if (movieSearchResponseNewMovieSearchResponse$default != null) {
                        arrayList4 = arrayList;
                        arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                    } else {
                        arrayList4 = arrayList;
                    }
                    arrayList = arrayList4;
                    iterable = iterable2;
                    jsonNode4 = jsonNode1111111117;
                    i18 = i32;
                    str52 = str67;
                    movieBoxProvider = this;
                    break;
                }
                arrayList2 = arrayList;
                hashSet = new HashSet();
                arrayList3 = new ArrayList();
                while (r4.hasNext()) {
                    arrayList2 = arrayList2;
                    if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                        arrayList3.add(obj8);
                    }
                }
                arrayListEmptyList = arrayList3;
                if (arrayListEmptyList == null) {
                    arrayListEmptyList = CollectionsKt.emptyList();
                }
                return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
            case 3:
                boolean z12 = c00022.Z$0;
                int i45 = c00022.I$2;
                i9 = c00022.I$1;
                int i46 = c00022.I$0;
                RequestBody requestBody12 = (RequestBody) c00022.L$13;
                Map map18 = (Map) c00022.L$12;
                str34 = (String) c00022.L$11;
                String str100 = (String) c00022.L$10;
                str33 = (String) c00022.L$9;
                String str101 = (String) c00022.L$8;
                str29 = (String) c00022.L$7;
                str28 = (String) c00022.L$6;
                Map map19 = (Map) c00022.L$5;
                str32 = (String) c00022.L$4;
                list4 = (List) c00022.L$3;
                str27 = (String) c00022.L$2;
                String str102 = (String) c00022.L$1;
                MainPageRequest mainPageRequest12 = (MainPageRequest) c00022.L$0;
                ResultKt.throwOnFailure(objPost$default);
                z3 = z12;
                i6 = i45;
                map4 = map18;
                str20 = str100;
                str3 = "data";
                obj3 = coroutine_suspended;
                str22 = str102;
                jsonNode = null;
                str10 = str101;
                mainPageRequest4 = mainPageRequest12;
                requestBody2 = requestBody12;
                i10 = i46;
                map3 = map19;
                str35 = str34;
                obj4 = obj3;
                str36 = str22;
                z5 = z3;
                mainPageRequest5 = mainPageRequest4;
                str37 = str10;
                i11 = i6;
                map5 = map3;
                requestBody3 = requestBody2;
                niceResponse = (NiceResponse) objPost$default;
                str38 = str33;
                niceResponse2 = niceResponse;
                if (niceResponse2.getCode() != 401) {
                    break;
                }
                bearerToken = jsonNode;
                sharedPreferences = movieBoxProvider.sharedPref;
                if (sharedPreferences != null) {
                    editorRemove.apply();
                    Unit unit9 = Unit.INSTANCE;
                }
                if (!z5) {
                    map6 = map5;
                    str39 = str37;
                    str40 = str38;
                    z6 = z5;
                    i12 = i11;
                    i13 = i9;
                    requestBody4 = requestBody3;
                    obj5 = obj4;
                    c00022.L$0 = mainPageRequest5;
                    c00022.L$1 = str36;
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(str27);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(list4);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(str32);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(map6);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(str28);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(str29);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(str39);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(str40);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(str20);
                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(str35);
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(map4);
                    c00022.L$13 = requestBody4;
                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse2);
                    c00022.I$0 = i10;
                    c00022.I$1 = i13;
                    c00022.I$2 = i12;
                    c00022.Z$0 = z6;
                    c00022.label = 6;
                    str41 = str35;
                    movieBoxProvider = this;
                    objBuildAuthHeaders$default2 = buildAuthHeaders$default(movieBoxProvider, "POST", str36, "application/json; charset=utf-8", null, str41, false, c00022, 40, null);
                    if (objBuildAuthHeaders$default2 == obj5) {
                        return obj5;
                    }
                    i14 = i10;
                    str42 = str36;
                    str43 = str41;
                    requestBody5 = requestBody4;
                    map7 = map4;
                    niceResponse3 = niceResponse2;
                    str44 = str20;
                    str45 = str39;
                    obj6 = objBuildAuthHeaders$default2;
                    map8 = map6;
                    niceResponse5 = niceResponse3;
                    str53 = str43;
                    map12 = (Map) obj6;
                    map13 = map8;
                    str54 = str45;
                    i20 = i13;
                    str55 = str44;
                    i21 = i14;
                    requestBody8 = requestBody5;
                    str57 = str40;
                    str58 = str29;
                    str59 = str28;
                    str60 = str27;
                    str56 = str42;
                    mainPageRequest6 = mainPageRequest5;
                    z8 = z6;
                    list5 = list4;
                    str61 = str32;
                    map14 = map12;
                    if (z8) {
                        Requests app11111 = MainActivityKt.getApp();
                        c00022.L$0 = mainPageRequest6;
                        c00022.L$1 = SpillingKt.nullOutSpilledVariable(str56);
                        c00022.L$2 = SpillingKt.nullOutSpilledVariable(str60);
                        c00022.L$3 = SpillingKt.nullOutSpilledVariable(list5);
                        c00022.L$4 = SpillingKt.nullOutSpilledVariable(str61);
                        c00022.L$5 = SpillingKt.nullOutSpilledVariable(map13);
                        c00022.L$6 = SpillingKt.nullOutSpilledVariable(str59);
                        c00022.L$7 = SpillingKt.nullOutSpilledVariable(str58);
                        c00022.L$8 = SpillingKt.nullOutSpilledVariable(str54);
                        c00022.L$9 = SpillingKt.nullOutSpilledVariable(str57);
                        c00022.L$10 = SpillingKt.nullOutSpilledVariable(str55);
                        c00022.L$11 = SpillingKt.nullOutSpilledVariable(str53);
                        c00022.L$12 = SpillingKt.nullOutSpilledVariable(map14);
                        c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody8);
                        c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse5);
                        c00022.I$0 = i21;
                        c00022.I$1 = i20;
                        c00022.I$2 = i12;
                        c00022.Z$0 = z8;
                        c00022.label = 7;
                        i26 = i12;
                        objPost$default = Requests.get$default(app11111, str56, map14, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                        if (objPost$default == obj5) {
                            return obj5;
                        }
                        int i3113 = i20;
                        mainPageRequest8 = mainPageRequest6;
                        str64 = str59;
                        i27 = i3113;
                        i28 = i21;
                        str65 = str55;
                        map15 = map14;
                        niceResponse6 = (NiceResponse) objPost$default;
                        mainPageRequest5 = mainPageRequest8;
                        i29 = i26;
                        str66 = str56;
                        i30 = i27;
                        requestBody11 = requestBody8;
                        i31 = i28;
                        niceResponse2 = niceResponse6;
                        str52 = str66;
                        i18 = i29;
                        i19 = i31;
                        JsonNode tree1110 = ExtensionsKt.jacksonObjectMapper().readTree(niceResponse2.getText());
                        String str811114 = str3;
                        jsonNode2 = tree1110.get(str811114);
                        if (jsonNode2 != null) {
                            jsonNode4 = jsonNode2.get("items");
                            if (jsonNode4 == null) {
                            }
                            iterable = (Iterable) jsonNode4;
                            arrayList = new ArrayList();
                            while (r29.hasNext()) {
                                JsonNode jsonNode1111111118 = jsonNode4;
                                if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    jsonNode5 = jsonNode7.get("title");
                                    if (jsonNode5 != null) {
                                        iterable2 = iterable;
                                        i32 = i18;
                                        str67 = str52;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    } else {
                                        iterable2 = iterable;
                                        i32 = i18;
                                        str67 = str52;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    }
                                }
                                if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                    arrayList4 = arrayList;
                                    arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                                } else {
                                    arrayList4 = arrayList;
                                }
                                arrayList = arrayList4;
                                iterable = iterable2;
                                jsonNode4 = jsonNode1111111118;
                                i18 = i32;
                                str52 = str67;
                                movieBoxProvider = this;
                                break;
                            }
                            arrayList2 = arrayList;
                            hashSet = new HashSet();
                            arrayList3 = new ArrayList();
                            while (r4.hasNext()) {
                                arrayList2 = arrayList2;
                                if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                                    arrayList3.add(obj8);
                                }
                            }
                            arrayListEmptyList = arrayList3;
                            if (arrayListEmptyList == null) {
                                arrayListEmptyList = CollectionsKt.emptyList();
                            }
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                        }
                        jsonNode3 = tree1110.get(str811114);
                        if (jsonNode3 != null) {
                            jsonNode4 = jsonNode3.get("subjects");
                        } else {
                            jsonNode4 = jsonNode;
                        }
                        if (jsonNode4 == null) {
                            JsonNode jsonNode1111111119 = jsonNode;
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode1111111119, 2, jsonNode1111111119);
                        }
                        iterable = (Iterable) jsonNode4;
                        arrayList = new ArrayList();
                        while (r29.hasNext()) {
                            JsonNode jsonNode11111111110 = jsonNode4;
                            if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                jsonNode5 = jsonNode7.get("title");
                                if (jsonNode5 != null) {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                arrayList4 = arrayList;
                                arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                arrayList4 = arrayList;
                            }
                            arrayList = arrayList4;
                            iterable = iterable2;
                            jsonNode4 = jsonNode11111111110;
                            i18 = i32;
                            str52 = str67;
                            movieBoxProvider = this;
                            break;
                        }
                        arrayList2 = arrayList;
                        hashSet = new HashSet();
                        arrayList3 = new ArrayList();
                        while (r4.hasNext()) {
                            arrayList2 = arrayList2;
                            if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                                arrayList3.add(obj8);
                            }
                        }
                        arrayListEmptyList = arrayList3;
                        if (arrayListEmptyList == null) {
                            arrayListEmptyList = CollectionsKt.emptyList();
                        }
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                    }
                    List list114 = list5;
                    i22 = i12;
                    Requests app11112 = MainActivityKt.getApp();
                    c00022.L$0 = mainPageRequest6;
                    mainPageRequest7 = mainPageRequest6;
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(str56);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(str60);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(list114);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(str61);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(map13);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(str59);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(str58);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(str54);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(str57);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(str55);
                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(str53);
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(map14);
                    c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody8);
                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse5);
                    c00022.I$0 = i21;
                    c00022.I$1 = i20;
                    c00022.I$2 = i22;
                    c00022.Z$0 = z8;
                    c00022.label = 8;
                    requestBody9 = requestBody8;
                    objPost$default = Requests.post$default(app11112, str56, map14, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody9, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                    if (objPost$default == obj5) {
                        return obj5;
                    }
                    str62 = str59;
                    i23 = i21;
                    requestBody10 = requestBody9;
                    i24 = i20;
                    i25 = i22;
                    z9 = z8;
                    str63 = str55;
                    niceResponse6 = (NiceResponse) objPost$default;
                    i30 = i24;
                    requestBody11 = requestBody10;
                    mainPageRequest5 = mainPageRequest7;
                    str66 = str56;
                    i29 = i25;
                    i31 = i23;
                    niceResponse2 = niceResponse6;
                    str52 = str66;
                    i18 = i29;
                    i19 = i31;
                    JsonNode tree1111 = ExtensionsKt.jacksonObjectMapper().readTree(niceResponse2.getText());
                    String str811115 = str3;
                    jsonNode2 = tree1111.get(str811115);
                    if (jsonNode2 != null) {
                        jsonNode4 = jsonNode2.get("items");
                        if (jsonNode4 == null) {
                        }
                        iterable = (Iterable) jsonNode4;
                        arrayList = new ArrayList();
                        while (r29.hasNext()) {
                            JsonNode jsonNode11111111111 = jsonNode4;
                            if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                jsonNode5 = jsonNode7.get("title");
                                if (jsonNode5 != null) {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                arrayList4 = arrayList;
                                arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                arrayList4 = arrayList;
                            }
                            arrayList = arrayList4;
                            iterable = iterable2;
                            jsonNode4 = jsonNode11111111111;
                            i18 = i32;
                            str52 = str67;
                            movieBoxProvider = this;
                            break;
                        }
                        arrayList2 = arrayList;
                        hashSet = new HashSet();
                        arrayList3 = new ArrayList();
                        while (r4.hasNext()) {
                            arrayList2 = arrayList2;
                            if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                                arrayList3.add(obj8);
                            }
                        }
                        arrayListEmptyList = arrayList3;
                        if (arrayListEmptyList == null) {
                            arrayListEmptyList = CollectionsKt.emptyList();
                        }
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                    }
                    jsonNode3 = tree1111.get(str811115);
                    if (jsonNode3 != null) {
                        jsonNode4 = jsonNode3.get("subjects");
                    } else {
                        jsonNode4 = jsonNode;
                    }
                    if (jsonNode4 == null) {
                        JsonNode jsonNode11111111112 = jsonNode;
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode11111111112, 2, jsonNode11111111112);
                    }
                    iterable = (Iterable) jsonNode4;
                    arrayList = new ArrayList();
                    while (r29.hasNext()) {
                        JsonNode jsonNode11111111113 = jsonNode4;
                        if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                            iterable2 = iterable;
                            i32 = i18;
                            str67 = str52;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            jsonNode5 = jsonNode7.get("title");
                            if (jsonNode5 != null) {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                        }
                        if (movieSearchResponseNewMovieSearchResponse$default != null) {
                            arrayList4 = arrayList;
                            arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                        } else {
                            arrayList4 = arrayList;
                        }
                        arrayList = arrayList4;
                        iterable = iterable2;
                        jsonNode4 = jsonNode11111111113;
                        i18 = i32;
                        str52 = str67;
                        movieBoxProvider = this;
                        break;
                    }
                    arrayList2 = arrayList;
                    hashSet = new HashSet();
                    arrayList3 = new ArrayList();
                    while (r4.hasNext()) {
                        arrayList2 = arrayList2;
                        if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                            arrayList3.add(obj8);
                        }
                    }
                    arrayListEmptyList = arrayList3;
                    if (arrayListEmptyList == null) {
                        arrayListEmptyList = CollectionsKt.emptyList();
                    }
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                }
                c00022.L$0 = mainPageRequest5;
                c00022.L$1 = str36;
                c00022.L$2 = SpillingKt.nullOutSpilledVariable(str27);
                c00022.L$3 = SpillingKt.nullOutSpilledVariable(list4);
                c00022.L$4 = SpillingKt.nullOutSpilledVariable(str32);
                c00022.L$5 = SpillingKt.nullOutSpilledVariable(map5);
                c00022.L$6 = SpillingKt.nullOutSpilledVariable(str28);
                c00022.L$7 = SpillingKt.nullOutSpilledVariable(str29);
                c00022.L$8 = SpillingKt.nullOutSpilledVariable(str37);
                c00022.L$9 = SpillingKt.nullOutSpilledVariable(str38);
                c00022.L$10 = SpillingKt.nullOutSpilledVariable(str20);
                c00022.L$11 = SpillingKt.nullOutSpilledVariable(str35);
                c00022.L$12 = SpillingKt.nullOutSpilledVariable(map4);
                c00022.L$13 = requestBody3;
                c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse2);
                c00022.I$0 = i10;
                c00022.I$1 = i9;
                c00022.I$2 = i11;
                c00022.Z$0 = z5;
                c00022.label = 5;
                i15 = i9;
                requestBody6 = requestBody3;
                str46 = str38;
                i12 = i11;
                map9 = map5;
                str47 = str37;
                obj5 = obj4;
                z7 = z5;
                objBuildAuthHeaders$default3 = buildAuthHeaders$default(movieBoxProvider, "GET", str36, null, null, null, false, c00022, 60, null);
                if (objBuildAuthHeaders$default3 == obj5) {
                    return obj5;
                }
                String str811116 = str36;
                i16 = i10;
                str48 = str811116;
                map10 = map9;
                i17 = i15;
                requestBody7 = requestBody6;
                map11 = map4;
                str49 = str35;
                niceResponse4 = niceResponse2;
                str50 = str20;
                obj7 = objBuildAuthHeaders$default3;
                str51 = str47;
                niceResponse5 = niceResponse4;
                str53 = str49;
                map12 = (Map) obj7;
                map13 = map10;
                str54 = str51;
                i20 = i17;
                str55 = str50;
                movieBoxProvider = this;
                i21 = i16;
                str56 = str48;
                requestBody8 = requestBody7;
                mainPageRequest6 = mainPageRequest5;
                str57 = str46;
                str58 = str29;
                str59 = str28;
                z8 = z7;
                str60 = str27;
                str61 = str32;
                list5 = list4;
                map14 = map12;
                if (z8) {
                    Requests app11113 = MainActivityKt.getApp();
                    c00022.L$0 = mainPageRequest6;
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(str56);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(str60);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(list5);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(str61);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(map13);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(str59);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(str58);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(str54);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(str57);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(str55);
                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(str53);
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(map14);
                    c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody8);
                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse5);
                    c00022.I$0 = i21;
                    c00022.I$1 = i20;
                    c00022.I$2 = i12;
                    c00022.Z$0 = z8;
                    c00022.label = 7;
                    i26 = i12;
                    objPost$default = Requests.get$default(app11113, str56, map14, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                    if (objPost$default == obj5) {
                        return obj5;
                    }
                    int i3114 = i20;
                    mainPageRequest8 = mainPageRequest6;
                    str64 = str59;
                    i27 = i3114;
                    i28 = i21;
                    str65 = str55;
                    map15 = map14;
                    niceResponse6 = (NiceResponse) objPost$default;
                    mainPageRequest5 = mainPageRequest8;
                    i29 = i26;
                    str66 = str56;
                    i30 = i27;
                    requestBody11 = requestBody8;
                    i31 = i28;
                    niceResponse2 = niceResponse6;
                    str52 = str66;
                    i18 = i29;
                    i19 = i31;
                    JsonNode tree1112 = ExtensionsKt.jacksonObjectMapper().readTree(niceResponse2.getText());
                    String str811117 = str3;
                    jsonNode2 = tree1112.get(str811117);
                    if (jsonNode2 != null) {
                        jsonNode4 = jsonNode2.get("items");
                        if (jsonNode4 == null) {
                        }
                        iterable = (Iterable) jsonNode4;
                        arrayList = new ArrayList();
                        while (r29.hasNext()) {
                            JsonNode jsonNode11111111114 = jsonNode4;
                            if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                jsonNode5 = jsonNode7.get("title");
                                if (jsonNode5 != null) {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                arrayList4 = arrayList;
                                arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                arrayList4 = arrayList;
                            }
                            arrayList = arrayList4;
                            iterable = iterable2;
                            jsonNode4 = jsonNode11111111114;
                            i18 = i32;
                            str52 = str67;
                            movieBoxProvider = this;
                            break;
                        }
                        arrayList2 = arrayList;
                        hashSet = new HashSet();
                        arrayList3 = new ArrayList();
                        while (r4.hasNext()) {
                            arrayList2 = arrayList2;
                            if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                                arrayList3.add(obj8);
                            }
                        }
                        arrayListEmptyList = arrayList3;
                        if (arrayListEmptyList == null) {
                            arrayListEmptyList = CollectionsKt.emptyList();
                        }
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                    }
                    jsonNode3 = tree1112.get(str811117);
                    if (jsonNode3 != null) {
                        jsonNode4 = jsonNode3.get("subjects");
                    } else {
                        jsonNode4 = jsonNode;
                    }
                    if (jsonNode4 == null) {
                        JsonNode jsonNode11111111115 = jsonNode;
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode11111111115, 2, jsonNode11111111115);
                    }
                    iterable = (Iterable) jsonNode4;
                    arrayList = new ArrayList();
                    while (r29.hasNext()) {
                        JsonNode jsonNode11111111116 = jsonNode4;
                        if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                            iterable2 = iterable;
                            i32 = i18;
                            str67 = str52;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            jsonNode5 = jsonNode7.get("title");
                            if (jsonNode5 != null) {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                        }
                        if (movieSearchResponseNewMovieSearchResponse$default != null) {
                            arrayList4 = arrayList;
                            arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                        } else {
                            arrayList4 = arrayList;
                        }
                        arrayList = arrayList4;
                        iterable = iterable2;
                        jsonNode4 = jsonNode11111111116;
                        i18 = i32;
                        str52 = str67;
                        movieBoxProvider = this;
                        break;
                    }
                    arrayList2 = arrayList;
                    hashSet = new HashSet();
                    arrayList3 = new ArrayList();
                    while (r4.hasNext()) {
                        arrayList2 = arrayList2;
                        if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                            arrayList3.add(obj8);
                        }
                    }
                    arrayListEmptyList = arrayList3;
                    if (arrayListEmptyList == null) {
                        arrayListEmptyList = CollectionsKt.emptyList();
                    }
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                }
                List list115 = list5;
                i22 = i12;
                Requests app11114 = MainActivityKt.getApp();
                c00022.L$0 = mainPageRequest6;
                mainPageRequest7 = mainPageRequest6;
                c00022.L$1 = SpillingKt.nullOutSpilledVariable(str56);
                c00022.L$2 = SpillingKt.nullOutSpilledVariable(str60);
                c00022.L$3 = SpillingKt.nullOutSpilledVariable(list115);
                c00022.L$4 = SpillingKt.nullOutSpilledVariable(str61);
                c00022.L$5 = SpillingKt.nullOutSpilledVariable(map13);
                c00022.L$6 = SpillingKt.nullOutSpilledVariable(str59);
                c00022.L$7 = SpillingKt.nullOutSpilledVariable(str58);
                c00022.L$8 = SpillingKt.nullOutSpilledVariable(str54);
                c00022.L$9 = SpillingKt.nullOutSpilledVariable(str57);
                c00022.L$10 = SpillingKt.nullOutSpilledVariable(str55);
                c00022.L$11 = SpillingKt.nullOutSpilledVariable(str53);
                c00022.L$12 = SpillingKt.nullOutSpilledVariable(map14);
                c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody8);
                c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse5);
                c00022.I$0 = i21;
                c00022.I$1 = i20;
                c00022.I$2 = i22;
                c00022.Z$0 = z8;
                c00022.label = 8;
                requestBody9 = requestBody8;
                objPost$default = Requests.post$default(app11114, str56, map14, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody9, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                if (objPost$default == obj5) {
                    return obj5;
                }
                str62 = str59;
                i23 = i21;
                requestBody10 = requestBody9;
                i24 = i20;
                i25 = i22;
                z9 = z8;
                str63 = str55;
                niceResponse6 = (NiceResponse) objPost$default;
                i30 = i24;
                requestBody11 = requestBody10;
                mainPageRequest5 = mainPageRequest7;
                str66 = str56;
                i29 = i25;
                i31 = i23;
                niceResponse2 = niceResponse6;
                str52 = str66;
                i18 = i29;
                i19 = i31;
                JsonNode tree1113 = ExtensionsKt.jacksonObjectMapper().readTree(niceResponse2.getText());
                String str811118 = str3;
                jsonNode2 = tree1113.get(str811118);
                if (jsonNode2 != null) {
                    jsonNode4 = jsonNode2.get("items");
                    if (jsonNode4 == null) {
                    }
                    iterable = (Iterable) jsonNode4;
                    arrayList = new ArrayList();
                    while (r29.hasNext()) {
                        JsonNode jsonNode11111111117 = jsonNode4;
                        if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                            iterable2 = iterable;
                            i32 = i18;
                            str67 = str52;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            jsonNode5 = jsonNode7.get("title");
                            if (jsonNode5 != null) {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                        }
                        if (movieSearchResponseNewMovieSearchResponse$default != null) {
                            arrayList4 = arrayList;
                            arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                        } else {
                            arrayList4 = arrayList;
                        }
                        arrayList = arrayList4;
                        iterable = iterable2;
                        jsonNode4 = jsonNode11111111117;
                        i18 = i32;
                        str52 = str67;
                        movieBoxProvider = this;
                        break;
                    }
                    arrayList2 = arrayList;
                    hashSet = new HashSet();
                    arrayList3 = new ArrayList();
                    while (r4.hasNext()) {
                        arrayList2 = arrayList2;
                        if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                            arrayList3.add(obj8);
                        }
                    }
                    arrayListEmptyList = arrayList3;
                    if (arrayListEmptyList == null) {
                        arrayListEmptyList = CollectionsKt.emptyList();
                    }
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                }
                jsonNode3 = tree1113.get(str811118);
                if (jsonNode3 != null) {
                    jsonNode4 = jsonNode3.get("subjects");
                } else {
                    jsonNode4 = jsonNode;
                }
                if (jsonNode4 == null) {
                    JsonNode jsonNode11111111118 = jsonNode;
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode11111111118, 2, jsonNode11111111118);
                }
                iterable = (Iterable) jsonNode4;
                arrayList = new ArrayList();
                while (r29.hasNext()) {
                    JsonNode jsonNode11111111119 = jsonNode4;
                    if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                        iterable2 = iterable;
                        i32 = i18;
                        str67 = str52;
                        movieSearchResponseNewMovieSearchResponse$default = null;
                    } else {
                        jsonNode5 = jsonNode7.get("title");
                        if (jsonNode5 != null) {
                            iterable2 = iterable;
                            i32 = i18;
                            str67 = str52;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            iterable2 = iterable;
                            i32 = i18;
                            str67 = str52;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        }
                    }
                    if (movieSearchResponseNewMovieSearchResponse$default != null) {
                        arrayList4 = arrayList;
                        arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                    } else {
                        arrayList4 = arrayList;
                    }
                    arrayList = arrayList4;
                    iterable = iterable2;
                    jsonNode4 = jsonNode11111111119;
                    i18 = i32;
                    str52 = str67;
                    movieBoxProvider = this;
                    break;
                }
                arrayList2 = arrayList;
                hashSet = new HashSet();
                arrayList3 = new ArrayList();
                while (r4.hasNext()) {
                    arrayList2 = arrayList2;
                    if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                        arrayList3.add(obj8);
                    }
                }
                arrayListEmptyList = arrayList3;
                if (arrayListEmptyList == null) {
                    arrayListEmptyList = CollectionsKt.emptyList();
                }
                return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
            case 4:
                z4 = c00022.Z$0;
                int i47 = c00022.I$2;
                i9 = c00022.I$1;
                int i48 = c00022.I$0;
                RequestBody requestBody13 = (RequestBody) c00022.L$13;
                Map map20 = (Map) c00022.L$12;
                str30 = (String) c00022.L$11;
                String str103 = (String) c00022.L$10;
                str31 = (String) c00022.L$9;
                String str104 = (String) c00022.L$8;
                str29 = (String) c00022.L$7;
                str28 = (String) c00022.L$6;
                Map map21 = (Map) c00022.L$5;
                str32 = (String) c00022.L$4;
                list4 = (List) c00022.L$3;
                str27 = (String) c00022.L$2;
                String str105 = (String) c00022.L$1;
                MainPageRequest mainPageRequest13 = (MainPageRequest) c00022.L$0;
                ResultKt.throwOnFailure(objPost$default);
                mainPageRequest3 = mainPageRequest13;
                i6 = i47;
                map4 = map20;
                str20 = str103;
                str3 = "data";
                obj2 = coroutine_suspended;
                i10 = i48;
                str22 = str105;
                jsonNode = null;
                str10 = str104;
                requestBody = requestBody13;
                map3 = map21;
                str35 = str30;
                mainPageRequest5 = mainPageRequest3;
                obj4 = obj2;
                str36 = str22;
                z5 = z4;
                str37 = str10;
                i11 = i6;
                map5 = map3;
                requestBody3 = requestBody;
                niceResponse = (NiceResponse) objPost$default;
                str38 = str31;
                niceResponse2 = niceResponse;
                if (niceResponse2.getCode() != 401) {
                    break;
                }
                bearerToken = jsonNode;
                sharedPreferences = movieBoxProvider.sharedPref;
                if (sharedPreferences != null) {
                    editorRemove.apply();
                    Unit unit10 = Unit.INSTANCE;
                }
                if (!z5) {
                    map6 = map5;
                    str39 = str37;
                    str40 = str38;
                    z6 = z5;
                    i12 = i11;
                    i13 = i9;
                    requestBody4 = requestBody3;
                    obj5 = obj4;
                    c00022.L$0 = mainPageRequest5;
                    c00022.L$1 = str36;
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(str27);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(list4);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(str32);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(map6);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(str28);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(str29);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(str39);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(str40);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(str20);
                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(str35);
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(map4);
                    c00022.L$13 = requestBody4;
                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse2);
                    c00022.I$0 = i10;
                    c00022.I$1 = i13;
                    c00022.I$2 = i12;
                    c00022.Z$0 = z6;
                    c00022.label = 6;
                    str41 = str35;
                    movieBoxProvider = this;
                    objBuildAuthHeaders$default2 = buildAuthHeaders$default(movieBoxProvider, "POST", str36, "application/json; charset=utf-8", null, str41, false, c00022, 40, null);
                    if (objBuildAuthHeaders$default2 == obj5) {
                        return obj5;
                    }
                    i14 = i10;
                    str42 = str36;
                    str43 = str41;
                    requestBody5 = requestBody4;
                    map7 = map4;
                    niceResponse3 = niceResponse2;
                    str44 = str20;
                    str45 = str39;
                    obj6 = objBuildAuthHeaders$default2;
                    map8 = map6;
                    niceResponse5 = niceResponse3;
                    str53 = str43;
                    map12 = (Map) obj6;
                    map13 = map8;
                    str54 = str45;
                    i20 = i13;
                    str55 = str44;
                    i21 = i14;
                    requestBody8 = requestBody5;
                    str57 = str40;
                    str58 = str29;
                    str59 = str28;
                    str60 = str27;
                    str56 = str42;
                    mainPageRequest6 = mainPageRequest5;
                    z8 = z6;
                    list5 = list4;
                    str61 = str32;
                    map14 = map12;
                    if (z8) {
                        Requests app11115 = MainActivityKt.getApp();
                        c00022.L$0 = mainPageRequest6;
                        c00022.L$1 = SpillingKt.nullOutSpilledVariable(str56);
                        c00022.L$2 = SpillingKt.nullOutSpilledVariable(str60);
                        c00022.L$3 = SpillingKt.nullOutSpilledVariable(list5);
                        c00022.L$4 = SpillingKt.nullOutSpilledVariable(str61);
                        c00022.L$5 = SpillingKt.nullOutSpilledVariable(map13);
                        c00022.L$6 = SpillingKt.nullOutSpilledVariable(str59);
                        c00022.L$7 = SpillingKt.nullOutSpilledVariable(str58);
                        c00022.L$8 = SpillingKt.nullOutSpilledVariable(str54);
                        c00022.L$9 = SpillingKt.nullOutSpilledVariable(str57);
                        c00022.L$10 = SpillingKt.nullOutSpilledVariable(str55);
                        c00022.L$11 = SpillingKt.nullOutSpilledVariable(str53);
                        c00022.L$12 = SpillingKt.nullOutSpilledVariable(map14);
                        c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody8);
                        c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse5);
                        c00022.I$0 = i21;
                        c00022.I$1 = i20;
                        c00022.I$2 = i12;
                        c00022.Z$0 = z8;
                        c00022.label = 7;
                        i26 = i12;
                        objPost$default = Requests.get$default(app11115, str56, map14, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                        if (objPost$default == obj5) {
                            return obj5;
                        }
                        int i3115 = i20;
                        mainPageRequest8 = mainPageRequest6;
                        str64 = str59;
                        i27 = i3115;
                        i28 = i21;
                        str65 = str55;
                        map15 = map14;
                        niceResponse6 = (NiceResponse) objPost$default;
                        mainPageRequest5 = mainPageRequest8;
                        i29 = i26;
                        str66 = str56;
                        i30 = i27;
                        requestBody11 = requestBody8;
                        i31 = i28;
                        niceResponse2 = niceResponse6;
                        str52 = str66;
                        i18 = i29;
                        i19 = i31;
                        JsonNode tree1114 = ExtensionsKt.jacksonObjectMapper().readTree(niceResponse2.getText());
                        String str811119 = str3;
                        jsonNode2 = tree1114.get(str811119);
                        if (jsonNode2 != null) {
                            jsonNode4 = jsonNode2.get("items");
                            if (jsonNode4 == null) {
                            }
                            iterable = (Iterable) jsonNode4;
                            arrayList = new ArrayList();
                            while (r29.hasNext()) {
                                JsonNode jsonNode111111111110 = jsonNode4;
                                if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    jsonNode5 = jsonNode7.get("title");
                                    if (jsonNode5 != null) {
                                        iterable2 = iterable;
                                        i32 = i18;
                                        str67 = str52;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    } else {
                                        iterable2 = iterable;
                                        i32 = i18;
                                        str67 = str52;
                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                    }
                                }
                                if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                    arrayList4 = arrayList;
                                    arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                                } else {
                                    arrayList4 = arrayList;
                                }
                                arrayList = arrayList4;
                                iterable = iterable2;
                                jsonNode4 = jsonNode111111111110;
                                i18 = i32;
                                str52 = str67;
                                movieBoxProvider = this;
                                break;
                            }
                            arrayList2 = arrayList;
                            hashSet = new HashSet();
                            arrayList3 = new ArrayList();
                            while (r4.hasNext()) {
                                arrayList2 = arrayList2;
                                if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                                    arrayList3.add(obj8);
                                }
                            }
                            arrayListEmptyList = arrayList3;
                            if (arrayListEmptyList == null) {
                                arrayListEmptyList = CollectionsKt.emptyList();
                            }
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                        }
                        jsonNode3 = tree1114.get(str811119);
                        if (jsonNode3 != null) {
                            jsonNode4 = jsonNode3.get("subjects");
                        } else {
                            jsonNode4 = jsonNode;
                        }
                        if (jsonNode4 == null) {
                            JsonNode jsonNode111111111111 = jsonNode;
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode111111111111, 2, jsonNode111111111111);
                        }
                        iterable = (Iterable) jsonNode4;
                        arrayList = new ArrayList();
                        while (r29.hasNext()) {
                            JsonNode jsonNode111111111112 = jsonNode4;
                            if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                jsonNode5 = jsonNode7.get("title");
                                if (jsonNode5 != null) {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                arrayList4 = arrayList;
                                arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                arrayList4 = arrayList;
                            }
                            arrayList = arrayList4;
                            iterable = iterable2;
                            jsonNode4 = jsonNode111111111112;
                            i18 = i32;
                            str52 = str67;
                            movieBoxProvider = this;
                            break;
                        }
                        arrayList2 = arrayList;
                        hashSet = new HashSet();
                        arrayList3 = new ArrayList();
                        while (r4.hasNext()) {
                            arrayList2 = arrayList2;
                            if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                                arrayList3.add(obj8);
                            }
                        }
                        arrayListEmptyList = arrayList3;
                        if (arrayListEmptyList == null) {
                            arrayListEmptyList = CollectionsKt.emptyList();
                        }
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                    }
                    List list116 = list5;
                    i22 = i12;
                    Requests app11116 = MainActivityKt.getApp();
                    c00022.L$0 = mainPageRequest6;
                    mainPageRequest7 = mainPageRequest6;
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(str56);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(str60);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(list116);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(str61);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(map13);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(str59);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(str58);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(str54);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(str57);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(str55);
                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(str53);
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(map14);
                    c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody8);
                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse5);
                    c00022.I$0 = i21;
                    c00022.I$1 = i20;
                    c00022.I$2 = i22;
                    c00022.Z$0 = z8;
                    c00022.label = 8;
                    requestBody9 = requestBody8;
                    objPost$default = Requests.post$default(app11116, str56, map14, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody9, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                    if (objPost$default == obj5) {
                        return obj5;
                    }
                    str62 = str59;
                    i23 = i21;
                    requestBody10 = requestBody9;
                    i24 = i20;
                    i25 = i22;
                    z9 = z8;
                    str63 = str55;
                    niceResponse6 = (NiceResponse) objPost$default;
                    i30 = i24;
                    requestBody11 = requestBody10;
                    mainPageRequest5 = mainPageRequest7;
                    str66 = str56;
                    i29 = i25;
                    i31 = i23;
                    niceResponse2 = niceResponse6;
                    str52 = str66;
                    i18 = i29;
                    i19 = i31;
                    JsonNode tree1115 = ExtensionsKt.jacksonObjectMapper().readTree(niceResponse2.getText());
                    String str8111110 = str3;
                    jsonNode2 = tree1115.get(str8111110);
                    if (jsonNode2 != null) {
                        jsonNode4 = jsonNode2.get("items");
                        if (jsonNode4 == null) {
                        }
                        iterable = (Iterable) jsonNode4;
                        arrayList = new ArrayList();
                        while (r29.hasNext()) {
                            JsonNode jsonNode111111111113 = jsonNode4;
                            if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                jsonNode5 = jsonNode7.get("title");
                                if (jsonNode5 != null) {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                arrayList4 = arrayList;
                                arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                arrayList4 = arrayList;
                            }
                            arrayList = arrayList4;
                            iterable = iterable2;
                            jsonNode4 = jsonNode111111111113;
                            i18 = i32;
                            str52 = str67;
                            movieBoxProvider = this;
                            break;
                        }
                        arrayList2 = arrayList;
                        hashSet = new HashSet();
                        arrayList3 = new ArrayList();
                        while (r4.hasNext()) {
                            arrayList2 = arrayList2;
                            if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                                arrayList3.add(obj8);
                            }
                        }
                        arrayListEmptyList = arrayList3;
                        if (arrayListEmptyList == null) {
                            arrayListEmptyList = CollectionsKt.emptyList();
                        }
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                    }
                    jsonNode3 = tree1115.get(str8111110);
                    if (jsonNode3 != null) {
                        jsonNode4 = jsonNode3.get("subjects");
                    } else {
                        jsonNode4 = jsonNode;
                    }
                    if (jsonNode4 == null) {
                        JsonNode jsonNode111111111114 = jsonNode;
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode111111111114, 2, jsonNode111111111114);
                    }
                    iterable = (Iterable) jsonNode4;
                    arrayList = new ArrayList();
                    while (r29.hasNext()) {
                        JsonNode jsonNode111111111115 = jsonNode4;
                        if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                            iterable2 = iterable;
                            i32 = i18;
                            str67 = str52;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            jsonNode5 = jsonNode7.get("title");
                            if (jsonNode5 != null) {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                        }
                        if (movieSearchResponseNewMovieSearchResponse$default != null) {
                            arrayList4 = arrayList;
                            arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                        } else {
                            arrayList4 = arrayList;
                        }
                        arrayList = arrayList4;
                        iterable = iterable2;
                        jsonNode4 = jsonNode111111111115;
                        i18 = i32;
                        str52 = str67;
                        movieBoxProvider = this;
                        break;
                    }
                    arrayList2 = arrayList;
                    hashSet = new HashSet();
                    arrayList3 = new ArrayList();
                    while (r4.hasNext()) {
                        arrayList2 = arrayList2;
                        if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                            arrayList3.add(obj8);
                        }
                    }
                    arrayListEmptyList = arrayList3;
                    if (arrayListEmptyList == null) {
                        arrayListEmptyList = CollectionsKt.emptyList();
                    }
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                }
                c00022.L$0 = mainPageRequest5;
                c00022.L$1 = str36;
                c00022.L$2 = SpillingKt.nullOutSpilledVariable(str27);
                c00022.L$3 = SpillingKt.nullOutSpilledVariable(list4);
                c00022.L$4 = SpillingKt.nullOutSpilledVariable(str32);
                c00022.L$5 = SpillingKt.nullOutSpilledVariable(map5);
                c00022.L$6 = SpillingKt.nullOutSpilledVariable(str28);
                c00022.L$7 = SpillingKt.nullOutSpilledVariable(str29);
                c00022.L$8 = SpillingKt.nullOutSpilledVariable(str37);
                c00022.L$9 = SpillingKt.nullOutSpilledVariable(str38);
                c00022.L$10 = SpillingKt.nullOutSpilledVariable(str20);
                c00022.L$11 = SpillingKt.nullOutSpilledVariable(str35);
                c00022.L$12 = SpillingKt.nullOutSpilledVariable(map4);
                c00022.L$13 = requestBody3;
                c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse2);
                c00022.I$0 = i10;
                c00022.I$1 = i9;
                c00022.I$2 = i11;
                c00022.Z$0 = z5;
                c00022.label = 5;
                i15 = i9;
                requestBody6 = requestBody3;
                str46 = str38;
                i12 = i11;
                map9 = map5;
                str47 = str37;
                obj5 = obj4;
                z7 = z5;
                objBuildAuthHeaders$default3 = buildAuthHeaders$default(movieBoxProvider, "GET", str36, null, null, null, false, c00022, 60, null);
                if (objBuildAuthHeaders$default3 == obj5) {
                    return obj5;
                }
                String str8111111 = str36;
                i16 = i10;
                str48 = str8111111;
                map10 = map9;
                i17 = i15;
                requestBody7 = requestBody6;
                map11 = map4;
                str49 = str35;
                niceResponse4 = niceResponse2;
                str50 = str20;
                obj7 = objBuildAuthHeaders$default3;
                str51 = str47;
                niceResponse5 = niceResponse4;
                str53 = str49;
                map12 = (Map) obj7;
                map13 = map10;
                str54 = str51;
                i20 = i17;
                str55 = str50;
                movieBoxProvider = this;
                i21 = i16;
                str56 = str48;
                requestBody8 = requestBody7;
                mainPageRequest6 = mainPageRequest5;
                str57 = str46;
                str58 = str29;
                str59 = str28;
                z8 = z7;
                str60 = str27;
                str61 = str32;
                list5 = list4;
                map14 = map12;
                if (z8) {
                    Requests app11117 = MainActivityKt.getApp();
                    c00022.L$0 = mainPageRequest6;
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(str56);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(str60);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(list5);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(str61);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(map13);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(str59);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(str58);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(str54);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(str57);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(str55);
                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(str53);
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(map14);
                    c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody8);
                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse5);
                    c00022.I$0 = i21;
                    c00022.I$1 = i20;
                    c00022.I$2 = i12;
                    c00022.Z$0 = z8;
                    c00022.label = 7;
                    i26 = i12;
                    objPost$default = Requests.get$default(app11117, str56, map14, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                    if (objPost$default == obj5) {
                        return obj5;
                    }
                    int i3116 = i20;
                    mainPageRequest8 = mainPageRequest6;
                    str64 = str59;
                    i27 = i3116;
                    i28 = i21;
                    str65 = str55;
                    map15 = map14;
                    niceResponse6 = (NiceResponse) objPost$default;
                    mainPageRequest5 = mainPageRequest8;
                    i29 = i26;
                    str66 = str56;
                    i30 = i27;
                    requestBody11 = requestBody8;
                    i31 = i28;
                    niceResponse2 = niceResponse6;
                    str52 = str66;
                    i18 = i29;
                    i19 = i31;
                    JsonNode tree1116 = ExtensionsKt.jacksonObjectMapper().readTree(niceResponse2.getText());
                    String str8111112 = str3;
                    jsonNode2 = tree1116.get(str8111112);
                    if (jsonNode2 != null) {
                        jsonNode4 = jsonNode2.get("items");
                        if (jsonNode4 == null) {
                        }
                        iterable = (Iterable) jsonNode4;
                        arrayList = new ArrayList();
                        while (r29.hasNext()) {
                            JsonNode jsonNode111111111116 = jsonNode4;
                            if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                jsonNode5 = jsonNode7.get("title");
                                if (jsonNode5 != null) {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                arrayList4 = arrayList;
                                arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                arrayList4 = arrayList;
                            }
                            arrayList = arrayList4;
                            iterable = iterable2;
                            jsonNode4 = jsonNode111111111116;
                            i18 = i32;
                            str52 = str67;
                            movieBoxProvider = this;
                            break;
                        }
                        arrayList2 = arrayList;
                        hashSet = new HashSet();
                        arrayList3 = new ArrayList();
                        while (r4.hasNext()) {
                            arrayList2 = arrayList2;
                            if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                                arrayList3.add(obj8);
                            }
                        }
                        arrayListEmptyList = arrayList3;
                        if (arrayListEmptyList == null) {
                            arrayListEmptyList = CollectionsKt.emptyList();
                        }
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                    }
                    jsonNode3 = tree1116.get(str8111112);
                    if (jsonNode3 != null) {
                        jsonNode4 = jsonNode3.get("subjects");
                    } else {
                        jsonNode4 = jsonNode;
                    }
                    if (jsonNode4 == null) {
                        JsonNode jsonNode111111111117 = jsonNode;
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode111111111117, 2, jsonNode111111111117);
                    }
                    iterable = (Iterable) jsonNode4;
                    arrayList = new ArrayList();
                    while (r29.hasNext()) {
                        JsonNode jsonNode111111111118 = jsonNode4;
                        if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                            iterable2 = iterable;
                            i32 = i18;
                            str67 = str52;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            jsonNode5 = jsonNode7.get("title");
                            if (jsonNode5 != null) {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                        }
                        if (movieSearchResponseNewMovieSearchResponse$default != null) {
                            arrayList4 = arrayList;
                            arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                        } else {
                            arrayList4 = arrayList;
                        }
                        arrayList = arrayList4;
                        iterable = iterable2;
                        jsonNode4 = jsonNode111111111118;
                        i18 = i32;
                        str52 = str67;
                        movieBoxProvider = this;
                        break;
                    }
                    arrayList2 = arrayList;
                    hashSet = new HashSet();
                    arrayList3 = new ArrayList();
                    while (r4.hasNext()) {
                        arrayList2 = arrayList2;
                        if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                            arrayList3.add(obj8);
                        }
                    }
                    arrayListEmptyList = arrayList3;
                    if (arrayListEmptyList == null) {
                        arrayListEmptyList = CollectionsKt.emptyList();
                    }
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                }
                List list117 = list5;
                i22 = i12;
                Requests app11118 = MainActivityKt.getApp();
                c00022.L$0 = mainPageRequest6;
                mainPageRequest7 = mainPageRequest6;
                c00022.L$1 = SpillingKt.nullOutSpilledVariable(str56);
                c00022.L$2 = SpillingKt.nullOutSpilledVariable(str60);
                c00022.L$3 = SpillingKt.nullOutSpilledVariable(list117);
                c00022.L$4 = SpillingKt.nullOutSpilledVariable(str61);
                c00022.L$5 = SpillingKt.nullOutSpilledVariable(map13);
                c00022.L$6 = SpillingKt.nullOutSpilledVariable(str59);
                c00022.L$7 = SpillingKt.nullOutSpilledVariable(str58);
                c00022.L$8 = SpillingKt.nullOutSpilledVariable(str54);
                c00022.L$9 = SpillingKt.nullOutSpilledVariable(str57);
                c00022.L$10 = SpillingKt.nullOutSpilledVariable(str55);
                c00022.L$11 = SpillingKt.nullOutSpilledVariable(str53);
                c00022.L$12 = SpillingKt.nullOutSpilledVariable(map14);
                c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody8);
                c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse5);
                c00022.I$0 = i21;
                c00022.I$1 = i20;
                c00022.I$2 = i22;
                c00022.Z$0 = z8;
                c00022.label = 8;
                requestBody9 = requestBody8;
                objPost$default = Requests.post$default(app11118, str56, map14, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody9, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                if (objPost$default == obj5) {
                    return obj5;
                }
                str62 = str59;
                i23 = i21;
                requestBody10 = requestBody9;
                i24 = i20;
                i25 = i22;
                z9 = z8;
                str63 = str55;
                niceResponse6 = (NiceResponse) objPost$default;
                i30 = i24;
                requestBody11 = requestBody10;
                mainPageRequest5 = mainPageRequest7;
                str66 = str56;
                i29 = i25;
                i31 = i23;
                niceResponse2 = niceResponse6;
                str52 = str66;
                i18 = i29;
                i19 = i31;
                JsonNode tree1117 = ExtensionsKt.jacksonObjectMapper().readTree(niceResponse2.getText());
                String str8111113 = str3;
                jsonNode2 = tree1117.get(str8111113);
                if (jsonNode2 != null) {
                    jsonNode4 = jsonNode2.get("items");
                    if (jsonNode4 == null) {
                    }
                    iterable = (Iterable) jsonNode4;
                    arrayList = new ArrayList();
                    while (r29.hasNext()) {
                        JsonNode jsonNode111111111119 = jsonNode4;
                        if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                            iterable2 = iterable;
                            i32 = i18;
                            str67 = str52;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            jsonNode5 = jsonNode7.get("title");
                            if (jsonNode5 != null) {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                        }
                        if (movieSearchResponseNewMovieSearchResponse$default != null) {
                            arrayList4 = arrayList;
                            arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                        } else {
                            arrayList4 = arrayList;
                        }
                        arrayList = arrayList4;
                        iterable = iterable2;
                        jsonNode4 = jsonNode111111111119;
                        i18 = i32;
                        str52 = str67;
                        movieBoxProvider = this;
                        break;
                    }
                    arrayList2 = arrayList;
                    hashSet = new HashSet();
                    arrayList3 = new ArrayList();
                    while (r4.hasNext()) {
                        arrayList2 = arrayList2;
                        if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                            arrayList3.add(obj8);
                        }
                    }
                    arrayListEmptyList = arrayList3;
                    if (arrayListEmptyList == null) {
                        arrayListEmptyList = CollectionsKt.emptyList();
                    }
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                }
                jsonNode3 = tree1117.get(str8111113);
                if (jsonNode3 != null) {
                    jsonNode4 = jsonNode3.get("subjects");
                } else {
                    jsonNode4 = jsonNode;
                }
                if (jsonNode4 == null) {
                    JsonNode jsonNode1111111111110 = jsonNode;
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode1111111111110, 2, jsonNode1111111111110);
                }
                iterable = (Iterable) jsonNode4;
                arrayList = new ArrayList();
                while (r29.hasNext()) {
                    JsonNode jsonNode1111111111111 = jsonNode4;
                    if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                        iterable2 = iterable;
                        i32 = i18;
                        str67 = str52;
                        movieSearchResponseNewMovieSearchResponse$default = null;
                    } else {
                        jsonNode5 = jsonNode7.get("title");
                        if (jsonNode5 != null) {
                            iterable2 = iterable;
                            i32 = i18;
                            str67 = str52;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            iterable2 = iterable;
                            i32 = i18;
                            str67 = str52;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        }
                    }
                    if (movieSearchResponseNewMovieSearchResponse$default != null) {
                        arrayList4 = arrayList;
                        arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                    } else {
                        arrayList4 = arrayList;
                    }
                    arrayList = arrayList4;
                    iterable = iterable2;
                    jsonNode4 = jsonNode1111111111111;
                    i18 = i32;
                    str52 = str67;
                    movieBoxProvider = this;
                    break;
                }
                arrayList2 = arrayList;
                hashSet = new HashSet();
                arrayList3 = new ArrayList();
                while (r4.hasNext()) {
                    arrayList2 = arrayList2;
                    if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                        arrayList3.add(obj8);
                    }
                }
                arrayListEmptyList = arrayList3;
                if (arrayListEmptyList == null) {
                    arrayListEmptyList = CollectionsKt.emptyList();
                }
                return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
            case 5:
                boolean z13 = c00022.Z$0;
                int i49 = c00022.I$2;
                i17 = c00022.I$1;
                int i50 = c00022.I$0;
                niceResponse4 = (NiceResponse) c00022.L$14;
                requestBody7 = (RequestBody) c00022.L$13;
                map11 = (Map) c00022.L$12;
                str49 = (String) c00022.L$11;
                str50 = (String) c00022.L$10;
                String str106 = (String) c00022.L$9;
                String str107 = (String) c00022.L$8;
                String str108 = (String) c00022.L$7;
                String str109 = (String) c00022.L$6;
                Map map22 = (Map) c00022.L$5;
                String str110 = (String) c00022.L$4;
                List list21 = (List) c00022.L$3;
                String str111 = (String) c00022.L$2;
                String str112 = (String) c00022.L$1;
                MainPageRequest mainPageRequest14 = (MainPageRequest) c00022.L$0;
                ResultKt.throwOnFailure(objPost$default);
                z7 = z13;
                str51 = str107;
                str29 = str108;
                str28 = str109;
                mainPageRequest5 = mainPageRequest14;
                str3 = "data";
                obj7 = objPost$default;
                obj5 = coroutine_suspended;
                map10 = map22;
                str32 = str110;
                list4 = list21;
                str27 = str111;
                str48 = str112;
                jsonNode = null;
                i12 = i49;
                i16 = i50;
                str46 = str106;
                niceResponse5 = niceResponse4;
                str53 = str49;
                map12 = (Map) obj7;
                map13 = map10;
                str54 = str51;
                i20 = i17;
                str55 = str50;
                movieBoxProvider = this;
                i21 = i16;
                str56 = str48;
                requestBody8 = requestBody7;
                mainPageRequest6 = mainPageRequest5;
                str57 = str46;
                str58 = str29;
                str59 = str28;
                z8 = z7;
                str60 = str27;
                str61 = str32;
                list5 = list4;
                map14 = map12;
                if (z8) {
                    Requests app11119 = MainActivityKt.getApp();
                    c00022.L$0 = mainPageRequest6;
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(str56);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(str60);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(list5);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(str61);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(map13);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(str59);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(str58);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(str54);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(str57);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(str55);
                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(str53);
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(map14);
                    c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody8);
                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse5);
                    c00022.I$0 = i21;
                    c00022.I$1 = i20;
                    c00022.I$2 = i12;
                    c00022.Z$0 = z8;
                    c00022.label = 7;
                    i26 = i12;
                    objPost$default = Requests.get$default(app11119, str56, map14, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                    if (objPost$default == obj5) {
                        return obj5;
                    }
                    int i3117 = i20;
                    mainPageRequest8 = mainPageRequest6;
                    str64 = str59;
                    i27 = i3117;
                    i28 = i21;
                    str65 = str55;
                    map15 = map14;
                    niceResponse6 = (NiceResponse) objPost$default;
                    mainPageRequest5 = mainPageRequest8;
                    i29 = i26;
                    str66 = str56;
                    i30 = i27;
                    requestBody11 = requestBody8;
                    i31 = i28;
                    niceResponse2 = niceResponse6;
                    str52 = str66;
                    i18 = i29;
                    i19 = i31;
                    JsonNode tree1118 = ExtensionsKt.jacksonObjectMapper().readTree(niceResponse2.getText());
                    String str8111114 = str3;
                    jsonNode2 = tree1118.get(str8111114);
                    if (jsonNode2 != null) {
                        jsonNode4 = jsonNode2.get("items");
                        if (jsonNode4 == null) {
                        }
                        iterable = (Iterable) jsonNode4;
                        arrayList = new ArrayList();
                        while (r29.hasNext()) {
                            JsonNode jsonNode1111111111112 = jsonNode4;
                            if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                jsonNode5 = jsonNode7.get("title");
                                if (jsonNode5 != null) {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                arrayList4 = arrayList;
                                arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                arrayList4 = arrayList;
                            }
                            arrayList = arrayList4;
                            iterable = iterable2;
                            jsonNode4 = jsonNode1111111111112;
                            i18 = i32;
                            str52 = str67;
                            movieBoxProvider = this;
                            break;
                        }
                        arrayList2 = arrayList;
                        hashSet = new HashSet();
                        arrayList3 = new ArrayList();
                        while (r4.hasNext()) {
                            arrayList2 = arrayList2;
                            if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                                arrayList3.add(obj8);
                            }
                        }
                        arrayListEmptyList = arrayList3;
                        if (arrayListEmptyList == null) {
                            arrayListEmptyList = CollectionsKt.emptyList();
                        }
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                    }
                    jsonNode3 = tree1118.get(str8111114);
                    if (jsonNode3 != null) {
                        jsonNode4 = jsonNode3.get("subjects");
                    } else {
                        jsonNode4 = jsonNode;
                    }
                    if (jsonNode4 == null) {
                        JsonNode jsonNode1111111111113 = jsonNode;
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode1111111111113, 2, jsonNode1111111111113);
                    }
                    iterable = (Iterable) jsonNode4;
                    arrayList = new ArrayList();
                    while (r29.hasNext()) {
                        JsonNode jsonNode1111111111114 = jsonNode4;
                        if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                            iterable2 = iterable;
                            i32 = i18;
                            str67 = str52;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            jsonNode5 = jsonNode7.get("title");
                            if (jsonNode5 != null) {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                        }
                        if (movieSearchResponseNewMovieSearchResponse$default != null) {
                            arrayList4 = arrayList;
                            arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                        } else {
                            arrayList4 = arrayList;
                        }
                        arrayList = arrayList4;
                        iterable = iterable2;
                        jsonNode4 = jsonNode1111111111114;
                        i18 = i32;
                        str52 = str67;
                        movieBoxProvider = this;
                        break;
                    }
                    arrayList2 = arrayList;
                    hashSet = new HashSet();
                    arrayList3 = new ArrayList();
                    while (r4.hasNext()) {
                        arrayList2 = arrayList2;
                        if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                            arrayList3.add(obj8);
                        }
                    }
                    arrayListEmptyList = arrayList3;
                    if (arrayListEmptyList == null) {
                        arrayListEmptyList = CollectionsKt.emptyList();
                    }
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                }
                List list118 = list5;
                i22 = i12;
                Requests app111110 = MainActivityKt.getApp();
                c00022.L$0 = mainPageRequest6;
                mainPageRequest7 = mainPageRequest6;
                c00022.L$1 = SpillingKt.nullOutSpilledVariable(str56);
                c00022.L$2 = SpillingKt.nullOutSpilledVariable(str60);
                c00022.L$3 = SpillingKt.nullOutSpilledVariable(list118);
                c00022.L$4 = SpillingKt.nullOutSpilledVariable(str61);
                c00022.L$5 = SpillingKt.nullOutSpilledVariable(map13);
                c00022.L$6 = SpillingKt.nullOutSpilledVariable(str59);
                c00022.L$7 = SpillingKt.nullOutSpilledVariable(str58);
                c00022.L$8 = SpillingKt.nullOutSpilledVariable(str54);
                c00022.L$9 = SpillingKt.nullOutSpilledVariable(str57);
                c00022.L$10 = SpillingKt.nullOutSpilledVariable(str55);
                c00022.L$11 = SpillingKt.nullOutSpilledVariable(str53);
                c00022.L$12 = SpillingKt.nullOutSpilledVariable(map14);
                c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody8);
                c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse5);
                c00022.I$0 = i21;
                c00022.I$1 = i20;
                c00022.I$2 = i22;
                c00022.Z$0 = z8;
                c00022.label = 8;
                requestBody9 = requestBody8;
                objPost$default = Requests.post$default(app111110, str56, map14, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody9, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                if (objPost$default == obj5) {
                    return obj5;
                }
                str62 = str59;
                i23 = i21;
                requestBody10 = requestBody9;
                i24 = i20;
                i25 = i22;
                z9 = z8;
                str63 = str55;
                niceResponse6 = (NiceResponse) objPost$default;
                i30 = i24;
                requestBody11 = requestBody10;
                mainPageRequest5 = mainPageRequest7;
                str66 = str56;
                i29 = i25;
                i31 = i23;
                niceResponse2 = niceResponse6;
                str52 = str66;
                i18 = i29;
                i19 = i31;
                JsonNode tree1119 = ExtensionsKt.jacksonObjectMapper().readTree(niceResponse2.getText());
                String str8111115 = str3;
                jsonNode2 = tree1119.get(str8111115);
                if (jsonNode2 != null) {
                    jsonNode4 = jsonNode2.get("items");
                    if (jsonNode4 == null) {
                    }
                    iterable = (Iterable) jsonNode4;
                    arrayList = new ArrayList();
                    while (r29.hasNext()) {
                        JsonNode jsonNode1111111111115 = jsonNode4;
                        if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                            iterable2 = iterable;
                            i32 = i18;
                            str67 = str52;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            jsonNode5 = jsonNode7.get("title");
                            if (jsonNode5 != null) {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                        }
                        if (movieSearchResponseNewMovieSearchResponse$default != null) {
                            arrayList4 = arrayList;
                            arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                        } else {
                            arrayList4 = arrayList;
                        }
                        arrayList = arrayList4;
                        iterable = iterable2;
                        jsonNode4 = jsonNode1111111111115;
                        i18 = i32;
                        str52 = str67;
                        movieBoxProvider = this;
                        break;
                    }
                    arrayList2 = arrayList;
                    hashSet = new HashSet();
                    arrayList3 = new ArrayList();
                    while (r4.hasNext()) {
                        arrayList2 = arrayList2;
                        if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                            arrayList3.add(obj8);
                        }
                    }
                    arrayListEmptyList = arrayList3;
                    if (arrayListEmptyList == null) {
                        arrayListEmptyList = CollectionsKt.emptyList();
                    }
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                }
                jsonNode3 = tree1119.get(str8111115);
                if (jsonNode3 != null) {
                    jsonNode4 = jsonNode3.get("subjects");
                } else {
                    jsonNode4 = jsonNode;
                }
                if (jsonNode4 == null) {
                    JsonNode jsonNode1111111111116 = jsonNode;
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode1111111111116, 2, jsonNode1111111111116);
                }
                iterable = (Iterable) jsonNode4;
                arrayList = new ArrayList();
                while (r29.hasNext()) {
                    JsonNode jsonNode1111111111117 = jsonNode4;
                    if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                        iterable2 = iterable;
                        i32 = i18;
                        str67 = str52;
                        movieSearchResponseNewMovieSearchResponse$default = null;
                    } else {
                        jsonNode5 = jsonNode7.get("title");
                        if (jsonNode5 != null) {
                            iterable2 = iterable;
                            i32 = i18;
                            str67 = str52;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            iterable2 = iterable;
                            i32 = i18;
                            str67 = str52;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        }
                    }
                    if (movieSearchResponseNewMovieSearchResponse$default != null) {
                        arrayList4 = arrayList;
                        arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                    } else {
                        arrayList4 = arrayList;
                    }
                    arrayList = arrayList4;
                    iterable = iterable2;
                    jsonNode4 = jsonNode1111111111117;
                    i18 = i32;
                    str52 = str67;
                    movieBoxProvider = this;
                    break;
                }
                arrayList2 = arrayList;
                hashSet = new HashSet();
                arrayList3 = new ArrayList();
                while (r4.hasNext()) {
                    arrayList2 = arrayList2;
                    if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                        arrayList3.add(obj8);
                    }
                }
                arrayListEmptyList = arrayList3;
                if (arrayListEmptyList == null) {
                    arrayListEmptyList = CollectionsKt.emptyList();
                }
                return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
            case 6:
                boolean z14 = c00022.Z$0;
                int i51 = c00022.I$2;
                int i52 = c00022.I$1;
                int i53 = c00022.I$0;
                niceResponse3 = (NiceResponse) c00022.L$14;
                requestBody5 = (RequestBody) c00022.L$13;
                map7 = (Map) c00022.L$12;
                str43 = (String) c00022.L$11;
                str44 = (String) c00022.L$10;
                String str113 = (String) c00022.L$9;
                String str114 = (String) c00022.L$8;
                String str115 = (String) c00022.L$7;
                String str116 = (String) c00022.L$6;
                Map map23 = (Map) c00022.L$5;
                String str117 = (String) c00022.L$4;
                List list22 = (List) c00022.L$3;
                String str118 = (String) c00022.L$2;
                String str119 = (String) c00022.L$1;
                MainPageRequest mainPageRequest15 = (MainPageRequest) c00022.L$0;
                ResultKt.throwOnFailure(objPost$default);
                mainPageRequest5 = mainPageRequest15;
                str3 = "data";
                obj5 = coroutine_suspended;
                str42 = str119;
                jsonNode = null;
                i12 = i51;
                i13 = i52;
                obj6 = objPost$default;
                i14 = i53;
                str45 = str114;
                str29 = str115;
                str28 = str116;
                str40 = str113;
                z6 = z14;
                map8 = map23;
                str32 = str117;
                list4 = list22;
                str27 = str118;
                niceResponse5 = niceResponse3;
                str53 = str43;
                map12 = (Map) obj6;
                map13 = map8;
                str54 = str45;
                i20 = i13;
                str55 = str44;
                i21 = i14;
                requestBody8 = requestBody5;
                str57 = str40;
                str58 = str29;
                str59 = str28;
                str60 = str27;
                str56 = str42;
                mainPageRequest6 = mainPageRequest5;
                z8 = z6;
                list5 = list4;
                str61 = str32;
                map14 = map12;
                if (z8) {
                    Requests app111111 = MainActivityKt.getApp();
                    c00022.L$0 = mainPageRequest6;
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(str56);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(str60);
                    c00022.L$3 = SpillingKt.nullOutSpilledVariable(list5);
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(str61);
                    c00022.L$5 = SpillingKt.nullOutSpilledVariable(map13);
                    c00022.L$6 = SpillingKt.nullOutSpilledVariable(str59);
                    c00022.L$7 = SpillingKt.nullOutSpilledVariable(str58);
                    c00022.L$8 = SpillingKt.nullOutSpilledVariable(str54);
                    c00022.L$9 = SpillingKt.nullOutSpilledVariable(str57);
                    c00022.L$10 = SpillingKt.nullOutSpilledVariable(str55);
                    c00022.L$11 = SpillingKt.nullOutSpilledVariable(str53);
                    c00022.L$12 = SpillingKt.nullOutSpilledVariable(map14);
                    c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody8);
                    c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse5);
                    c00022.I$0 = i21;
                    c00022.I$1 = i20;
                    c00022.I$2 = i12;
                    c00022.Z$0 = z8;
                    c00022.label = 7;
                    i26 = i12;
                    objPost$default = Requests.get$default(app111111, str56, map14, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                    if (objPost$default == obj5) {
                        return obj5;
                    }
                    int i3118 = i20;
                    mainPageRequest8 = mainPageRequest6;
                    str64 = str59;
                    i27 = i3118;
                    i28 = i21;
                    str65 = str55;
                    map15 = map14;
                    niceResponse6 = (NiceResponse) objPost$default;
                    mainPageRequest5 = mainPageRequest8;
                    i29 = i26;
                    str66 = str56;
                    i30 = i27;
                    requestBody11 = requestBody8;
                    i31 = i28;
                    niceResponse2 = niceResponse6;
                    str52 = str66;
                    i18 = i29;
                    i19 = i31;
                    JsonNode tree11110 = ExtensionsKt.jacksonObjectMapper().readTree(niceResponse2.getText());
                    String str8111116 = str3;
                    jsonNode2 = tree11110.get(str8111116);
                    if (jsonNode2 != null) {
                        jsonNode4 = jsonNode2.get("items");
                        if (jsonNode4 == null) {
                        }
                        iterable = (Iterable) jsonNode4;
                        arrayList = new ArrayList();
                        while (r29.hasNext()) {
                            JsonNode jsonNode1111111111118 = jsonNode4;
                            if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                jsonNode5 = jsonNode7.get("title");
                                if (jsonNode5 != null) {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    iterable2 = iterable;
                                    i32 = i18;
                                    str67 = str52;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                arrayList4 = arrayList;
                                arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                arrayList4 = arrayList;
                            }
                            arrayList = arrayList4;
                            iterable = iterable2;
                            jsonNode4 = jsonNode1111111111118;
                            i18 = i32;
                            str52 = str67;
                            movieBoxProvider = this;
                            break;
                        }
                        arrayList2 = arrayList;
                        hashSet = new HashSet();
                        arrayList3 = new ArrayList();
                        while (r4.hasNext()) {
                            arrayList2 = arrayList2;
                            if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                                arrayList3.add(obj8);
                            }
                        }
                        arrayListEmptyList = arrayList3;
                        if (arrayListEmptyList == null) {
                            arrayListEmptyList = CollectionsKt.emptyList();
                        }
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                    }
                    jsonNode3 = tree11110.get(str8111116);
                    if (jsonNode3 != null) {
                        jsonNode4 = jsonNode3.get("subjects");
                    } else {
                        jsonNode4 = jsonNode;
                    }
                    if (jsonNode4 == null) {
                        JsonNode jsonNode1111111111119 = jsonNode;
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode1111111111119, 2, jsonNode1111111111119);
                    }
                    iterable = (Iterable) jsonNode4;
                    arrayList = new ArrayList();
                    while (r29.hasNext()) {
                        JsonNode jsonNode11111111111110 = jsonNode4;
                        if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                            iterable2 = iterable;
                            i32 = i18;
                            str67 = str52;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            jsonNode5 = jsonNode7.get("title");
                            if (jsonNode5 != null) {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                        }
                        if (movieSearchResponseNewMovieSearchResponse$default != null) {
                            arrayList4 = arrayList;
                            arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                        } else {
                            arrayList4 = arrayList;
                        }
                        arrayList = arrayList4;
                        iterable = iterable2;
                        jsonNode4 = jsonNode11111111111110;
                        i18 = i32;
                        str52 = str67;
                        movieBoxProvider = this;
                        break;
                    }
                    arrayList2 = arrayList;
                    hashSet = new HashSet();
                    arrayList3 = new ArrayList();
                    while (r4.hasNext()) {
                        arrayList2 = arrayList2;
                        if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                            arrayList3.add(obj8);
                        }
                    }
                    arrayListEmptyList = arrayList3;
                    if (arrayListEmptyList == null) {
                        arrayListEmptyList = CollectionsKt.emptyList();
                    }
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                }
                List list119 = list5;
                i22 = i12;
                Requests app111112 = MainActivityKt.getApp();
                c00022.L$0 = mainPageRequest6;
                mainPageRequest7 = mainPageRequest6;
                c00022.L$1 = SpillingKt.nullOutSpilledVariable(str56);
                c00022.L$2 = SpillingKt.nullOutSpilledVariable(str60);
                c00022.L$3 = SpillingKt.nullOutSpilledVariable(list119);
                c00022.L$4 = SpillingKt.nullOutSpilledVariable(str61);
                c00022.L$5 = SpillingKt.nullOutSpilledVariable(map13);
                c00022.L$6 = SpillingKt.nullOutSpilledVariable(str59);
                c00022.L$7 = SpillingKt.nullOutSpilledVariable(str58);
                c00022.L$8 = SpillingKt.nullOutSpilledVariable(str54);
                c00022.L$9 = SpillingKt.nullOutSpilledVariable(str57);
                c00022.L$10 = SpillingKt.nullOutSpilledVariable(str55);
                c00022.L$11 = SpillingKt.nullOutSpilledVariable(str53);
                c00022.L$12 = SpillingKt.nullOutSpilledVariable(map14);
                c00022.L$13 = SpillingKt.nullOutSpilledVariable(requestBody8);
                c00022.L$14 = SpillingKt.nullOutSpilledVariable(niceResponse5);
                c00022.I$0 = i21;
                c00022.I$1 = i20;
                c00022.I$2 = i22;
                c00022.Z$0 = z8;
                c00022.label = 8;
                requestBody9 = requestBody8;
                objPost$default = Requests.post$default(app111112, str56, map14, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody9, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 65276, (Object) null);
                if (objPost$default == obj5) {
                    return obj5;
                }
                str62 = str59;
                i23 = i21;
                requestBody10 = requestBody9;
                i24 = i20;
                i25 = i22;
                z9 = z8;
                str63 = str55;
                niceResponse6 = (NiceResponse) objPost$default;
                i30 = i24;
                requestBody11 = requestBody10;
                mainPageRequest5 = mainPageRequest7;
                str66 = str56;
                i29 = i25;
                i31 = i23;
                niceResponse2 = niceResponse6;
                str52 = str66;
                i18 = i29;
                i19 = i31;
                JsonNode tree11111 = ExtensionsKt.jacksonObjectMapper().readTree(niceResponse2.getText());
                String str8111117 = str3;
                jsonNode2 = tree11111.get(str8111117);
                if (jsonNode2 != null) {
                    jsonNode4 = jsonNode2.get("items");
                    if (jsonNode4 == null) {
                    }
                    iterable = (Iterable) jsonNode4;
                    arrayList = new ArrayList();
                    while (r29.hasNext()) {
                        JsonNode jsonNode11111111111111 = jsonNode4;
                        if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                            iterable2 = iterable;
                            i32 = i18;
                            str67 = str52;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            jsonNode5 = jsonNode7.get("title");
                            if (jsonNode5 != null) {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                        }
                        if (movieSearchResponseNewMovieSearchResponse$default != null) {
                            arrayList4 = arrayList;
                            arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                        } else {
                            arrayList4 = arrayList;
                        }
                        arrayList = arrayList4;
                        iterable = iterable2;
                        jsonNode4 = jsonNode11111111111111;
                        i18 = i32;
                        str52 = str67;
                        movieBoxProvider = this;
                        break;
                    }
                    arrayList2 = arrayList;
                    hashSet = new HashSet();
                    arrayList3 = new ArrayList();
                    while (r4.hasNext()) {
                        arrayList2 = arrayList2;
                        if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                            arrayList3.add(obj8);
                        }
                    }
                    arrayListEmptyList = arrayList3;
                    if (arrayListEmptyList == null) {
                        arrayListEmptyList = CollectionsKt.emptyList();
                    }
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                }
                jsonNode3 = tree11111.get(str8111117);
                if (jsonNode3 != null) {
                    jsonNode4 = jsonNode3.get("subjects");
                } else {
                    jsonNode4 = jsonNode;
                }
                if (jsonNode4 == null) {
                    JsonNode jsonNode11111111111112 = jsonNode;
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode11111111111112, 2, jsonNode11111111111112);
                }
                iterable = (Iterable) jsonNode4;
                arrayList = new ArrayList();
                while (r29.hasNext()) {
                    JsonNode jsonNode11111111111113 = jsonNode4;
                    if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                        iterable2 = iterable;
                        i32 = i18;
                        str67 = str52;
                        movieSearchResponseNewMovieSearchResponse$default = null;
                    } else {
                        jsonNode5 = jsonNode7.get("title");
                        if (jsonNode5 != null) {
                            iterable2 = iterable;
                            i32 = i18;
                            str67 = str52;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            iterable2 = iterable;
                            i32 = i18;
                            str67 = str52;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        }
                    }
                    if (movieSearchResponseNewMovieSearchResponse$default != null) {
                        arrayList4 = arrayList;
                        arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                    } else {
                        arrayList4 = arrayList;
                    }
                    arrayList = arrayList4;
                    iterable = iterable2;
                    jsonNode4 = jsonNode11111111111113;
                    i18 = i32;
                    str52 = str67;
                    movieBoxProvider = this;
                    break;
                }
                arrayList2 = arrayList;
                hashSet = new HashSet();
                arrayList3 = new ArrayList();
                while (r4.hasNext()) {
                    arrayList2 = arrayList2;
                    if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                        arrayList3.add(obj8);
                    }
                }
                arrayListEmptyList = arrayList3;
                if (arrayListEmptyList == null) {
                    arrayListEmptyList = CollectionsKt.emptyList();
                }
                return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
            case 7:
                boolean z15 = c00022.Z$0;
                i26 = c00022.I$2;
                int i54 = c00022.I$1;
                int i55 = c00022.I$0;
                RequestBody requestBody14 = (RequestBody) c00022.L$13;
                map15 = (Map) c00022.L$12;
                String str120 = (String) c00022.L$11;
                str65 = (String) c00022.L$10;
                String str121 = (String) c00022.L$9;
                i28 = i55;
                String str122 = (String) c00022.L$8;
                String str123 = (String) c00022.L$6;
                Map map24 = (Map) c00022.L$5;
                String str124 = (String) c00022.L$4;
                String str125 = (String) c00022.L$1;
                MainPageRequest mainPageRequest16 = (MainPageRequest) c00022.L$0;
                ResultKt.throwOnFailure(objPost$default);
                z8 = z15;
                requestBody8 = requestBody14;
                str53 = str120;
                str3 = "data";
                str57 = str121;
                map13 = map24;
                str56 = str125;
                jsonNode = null;
                str54 = str122;
                mainPageRequest8 = mainPageRequest16;
                i27 = i54;
                str64 = str123;
                str61 = str124;
                niceResponse6 = (NiceResponse) objPost$default;
                mainPageRequest5 = mainPageRequest8;
                i29 = i26;
                str66 = str56;
                i30 = i27;
                requestBody11 = requestBody8;
                i31 = i28;
                niceResponse2 = niceResponse6;
                str52 = str66;
                i18 = i29;
                i19 = i31;
                JsonNode tree11112 = ExtensionsKt.jacksonObjectMapper().readTree(niceResponse2.getText());
                String str8111118 = str3;
                jsonNode2 = tree11112.get(str8111118);
                if (jsonNode2 != null) {
                    jsonNode4 = jsonNode2.get("items");
                    if (jsonNode4 == null) {
                    }
                    iterable = (Iterable) jsonNode4;
                    arrayList = new ArrayList();
                    while (r29.hasNext()) {
                        JsonNode jsonNode11111111111114 = jsonNode4;
                        if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                            iterable2 = iterable;
                            i32 = i18;
                            str67 = str52;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            jsonNode5 = jsonNode7.get("title");
                            if (jsonNode5 != null) {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                        }
                        if (movieSearchResponseNewMovieSearchResponse$default != null) {
                            arrayList4 = arrayList;
                            arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                        } else {
                            arrayList4 = arrayList;
                        }
                        arrayList = arrayList4;
                        iterable = iterable2;
                        jsonNode4 = jsonNode11111111111114;
                        i18 = i32;
                        str52 = str67;
                        movieBoxProvider = this;
                        break;
                    }
                    arrayList2 = arrayList;
                    hashSet = new HashSet();
                    arrayList3 = new ArrayList();
                    while (r4.hasNext()) {
                        arrayList2 = arrayList2;
                        if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                            arrayList3.add(obj8);
                        }
                    }
                    arrayListEmptyList = arrayList3;
                    if (arrayListEmptyList == null) {
                        arrayListEmptyList = CollectionsKt.emptyList();
                    }
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                }
                jsonNode3 = tree11112.get(str8111118);
                if (jsonNode3 != null) {
                    jsonNode4 = jsonNode3.get("subjects");
                } else {
                    jsonNode4 = jsonNode;
                }
                if (jsonNode4 == null) {
                    JsonNode jsonNode11111111111115 = jsonNode;
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode11111111111115, 2, jsonNode11111111111115);
                }
                iterable = (Iterable) jsonNode4;
                arrayList = new ArrayList();
                while (r29.hasNext()) {
                    JsonNode jsonNode11111111111116 = jsonNode4;
                    if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                        iterable2 = iterable;
                        i32 = i18;
                        str67 = str52;
                        movieSearchResponseNewMovieSearchResponse$default = null;
                    } else {
                        jsonNode5 = jsonNode7.get("title");
                        if (jsonNode5 != null) {
                            iterable2 = iterable;
                            i32 = i18;
                            str67 = str52;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            iterable2 = iterable;
                            i32 = i18;
                            str67 = str52;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        }
                    }
                    if (movieSearchResponseNewMovieSearchResponse$default != null) {
                        arrayList4 = arrayList;
                        arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                    } else {
                        arrayList4 = arrayList;
                    }
                    arrayList = arrayList4;
                    iterable = iterable2;
                    jsonNode4 = jsonNode11111111111116;
                    i18 = i32;
                    str52 = str67;
                    movieBoxProvider = this;
                    break;
                }
                arrayList2 = arrayList;
                hashSet = new HashSet();
                arrayList3 = new ArrayList();
                while (r4.hasNext()) {
                    arrayList2 = arrayList2;
                    if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                        arrayList3.add(obj8);
                    }
                }
                arrayListEmptyList = arrayList3;
                if (arrayListEmptyList == null) {
                    arrayListEmptyList = CollectionsKt.emptyList();
                }
                return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
            case 8:
                z9 = c00022.Z$0;
                i25 = c00022.I$2;
                i24 = c00022.I$1;
                int i56 = c00022.I$0;
                requestBody10 = (RequestBody) c00022.L$13;
                String str126 = (String) c00022.L$11;
                str63 = (String) c00022.L$10;
                String str127 = (String) c00022.L$9;
                i23 = i56;
                String str128 = (String) c00022.L$8;
                String str129 = (String) c00022.L$6;
                Map map25 = (Map) c00022.L$5;
                String str130 = (String) c00022.L$4;
                String str131 = (String) c00022.L$1;
                MainPageRequest mainPageRequest17 = (MainPageRequest) c00022.L$0;
                ResultKt.throwOnFailure(objPost$default);
                mainPageRequest7 = mainPageRequest17;
                str53 = str126;
                str57 = str127;
                str3 = "data";
                str62 = str129;
                map13 = map25;
                str61 = str130;
                str56 = str131;
                jsonNode = null;
                str54 = str128;
                niceResponse6 = (NiceResponse) objPost$default;
                i30 = i24;
                requestBody11 = requestBody10;
                mainPageRequest5 = mainPageRequest7;
                str66 = str56;
                i29 = i25;
                i31 = i23;
                niceResponse2 = niceResponse6;
                str52 = str66;
                i18 = i29;
                i19 = i31;
                JsonNode tree11113 = ExtensionsKt.jacksonObjectMapper().readTree(niceResponse2.getText());
                String str8111119 = str3;
                jsonNode2 = tree11113.get(str8111119);
                if (jsonNode2 != null) {
                    jsonNode4 = jsonNode2.get("items");
                    if (jsonNode4 == null) {
                    }
                    iterable = (Iterable) jsonNode4;
                    arrayList = new ArrayList();
                    while (r29.hasNext()) {
                        JsonNode jsonNode11111111111117 = jsonNode4;
                        if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                            iterable2 = iterable;
                            i32 = i18;
                            str67 = str52;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            jsonNode5 = jsonNode7.get("title");
                            if (jsonNode5 != null) {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                iterable2 = iterable;
                                i32 = i18;
                                str67 = str52;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                        }
                        if (movieSearchResponseNewMovieSearchResponse$default != null) {
                            arrayList4 = arrayList;
                            arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                        } else {
                            arrayList4 = arrayList;
                        }
                        arrayList = arrayList4;
                        iterable = iterable2;
                        jsonNode4 = jsonNode11111111111117;
                        i18 = i32;
                        str52 = str67;
                        movieBoxProvider = this;
                        break;
                    }
                    arrayList2 = arrayList;
                    hashSet = new HashSet();
                    arrayList3 = new ArrayList();
                    while (r4.hasNext()) {
                        arrayList2 = arrayList2;
                        if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                            arrayList3.add(obj8);
                        }
                    }
                    arrayListEmptyList = arrayList3;
                    if (arrayListEmptyList == null) {
                        arrayListEmptyList = CollectionsKt.emptyList();
                    }
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                }
                jsonNode3 = tree11113.get(str8111119);
                if (jsonNode3 != null) {
                    jsonNode4 = jsonNode3.get("subjects");
                } else {
                    jsonNode4 = jsonNode;
                }
                if (jsonNode4 == null) {
                    JsonNode jsonNode11111111111118 = jsonNode;
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), jsonNode11111111111118, 2, jsonNode11111111111118);
                }
                iterable = (Iterable) jsonNode4;
                arrayList = new ArrayList();
                while (r29.hasNext()) {
                    JsonNode jsonNode11111111111119 = jsonNode4;
                    if (movieBoxProvider.isNsfwItem(jsonNode7)) {
                        iterable2 = iterable;
                        i32 = i18;
                        str67 = str52;
                        movieSearchResponseNewMovieSearchResponse$default = null;
                    } else {
                        jsonNode5 = jsonNode7.get("title");
                        if (jsonNode5 != null) {
                            iterable2 = iterable;
                            i32 = i18;
                            str67 = str52;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            iterable2 = iterable;
                            i32 = i18;
                            str67 = str52;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        }
                    }
                    if (movieSearchResponseNewMovieSearchResponse$default != null) {
                        arrayList4 = arrayList;
                        arrayList4.add(movieSearchResponseNewMovieSearchResponse$default);
                    } else {
                        arrayList4 = arrayList;
                    }
                    arrayList = arrayList4;
                    iterable = iterable2;
                    jsonNode4 = jsonNode11111111111119;
                    i18 = i32;
                    str52 = str67;
                    movieBoxProvider = this;
                    break;
                }
                arrayList2 = arrayList;
                hashSet = new HashSet();
                arrayList3 = new ArrayList();
                while (r4.hasNext()) {
                    arrayList2 = arrayList2;
                    if (hashSet.add(((MovieSearchResponse) obj8).getUrl())) {
                        arrayList3.add(obj8);
                    }
                }
                arrayListEmptyList = arrayList3;
                if (arrayListEmptyList == null) {
                    arrayListEmptyList = CollectionsKt.emptyList();
                }
                return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(mainPageRequest5.getName(), arrayListEmptyList, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
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

    /* JADX WARN: Code duplicated, block: B:22:0x01ac A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:23:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:26:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:30:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:37:0x021f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:38:0x0220  */
    /* JADX WARN: Code duplicated, block: B:41:0x0285 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:42:0x0286  */
    /* JADX WARN: Code duplicated, block: B:46:0x02b8  */
    /* JADX WARN: Code duplicated, block: B:79:0x034c  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:80:0x0351  */
    /* JADX WARN: Code duplicated, block: B:82:0x0355  */
    /* JADX WARN: Code duplicated, block: B:83:0x035a  */
    /* JADX WARN: Code duplicated, block: B:84:0x035f  */
    /* JADX WARN: Code duplicated, block: B:94:0x03b7 A[ADDED_TO_REGION, REMOVE] */
    @Nullable
    public Object search(@NotNull String str, int i, @NotNull Continuation<? super SearchResponseList> continuation) {
        C00081 c00081;
        String str2;
        Object objBuildAuthHeaders$default;
        String str3;
        String str4;
        int i2;
        RequestBody requestBody;
        int i3;
        Map map;
        RequestBody requestBody2;
        Object obj;
        String str5;
        Object objPost$default;
        int i4;
        String str6;
        int i5;
        Object obj2;
        String str7;
        RequestBody requestBody3;
        NiceResponse niceResponse;
        SharedPreferences sharedPreferences;
        Object obj3;
        Object objBuildAuthHeaders$default2;
        int i6;
        String str8;
        int i7;
        RequestBody requestBody4;
        NiceResponse niceResponse2;
        String str9;
        String str10;
        SharedPreferences.Editor editorEdit;
        SharedPreferences.Editor editorRemove;
        Map map2;
        String str11;
        String str12;
        Map map3;
        RequestBody requestBody5;
        JsonNode jsonNode;
        Boolean bool;
        JsonNode jsonNode2;
        String strAsText;
        String strAsText2;
        String str13;
        JsonNode jsonNode3;
        int iAsInt;
        TvType tvType;
        this = this;
        if (continuation instanceof C00081) {
            c00081 = (C00081) continuation;
            if ((c00081.label & Integer.MIN_VALUE) != 0) {
                c00081.label -= Integer.MIN_VALUE;
            } else {
                c00081 = this.new C00081(continuation);
            }
        } else {
            c00081 = this.new C00081(continuation);
        }
        C00081 c00082 = c00081;
        Object objPost$default2 = c00082.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00082.label) {
            case 0:
                ResultKt.throwOnFailure(objPost$default2);
                String str14 = this.getMainUrl() + "/wefeed-mobile-bff/subject-api/search/v2";
                int i8 = !MainAPI.Companion.getSettingsForProvider().getEnableAdult() ? 1 : 0;
                String str15 = "{\"page\": " + i + ", \"perPage\": 20, \"keyword\": \"" + str + "\", \"restrictKid\": " + i8 + '}';
                RequestBody requestBodyCreate = RequestBody.Companion.create(str15, MediaType.Companion.get("application/json"));
                c00082.L$0 = SpillingKt.nullOutSpilledVariable(str);
                c00082.L$1 = str14;
                c00082.L$2 = str15;
                c00082.L$3 = requestBodyCreate;
                c00082.I$0 = i;
                c00082.I$1 = i8;
                c00082.label = 1;
                str2 = str15;
                objBuildAuthHeaders$default = buildAuthHeaders$default(this, "POST", str14, "application/json; charset=utf-8", null, str2, false, c00082, 40, null);
                if (objBuildAuthHeaders$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str3 = str;
                str4 = str14;
                i2 = i;
                requestBody = requestBodyCreate;
                i3 = i8;
                Map map4 = (Map) objBuildAuthHeaders$default;
                Requests app = MainActivityKt.getApp();
                c00082.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                c00082.L$1 = str4;
                c00082.L$2 = str2;
                c00082.L$3 = requestBody;
                c00082.L$4 = SpillingKt.nullOutSpilledVariable(map4);
                c00082.I$0 = i2;
                c00082.I$1 = i3;
                c00082.label = 2;
                map = map4;
                requestBody2 = requestBody;
                obj = coroutine_suspended;
                str5 = str4;
                objPost$default = Requests.post$default(app, str5, map, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody2, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00082, 65276, (Object) null);
                if (objPost$default == obj) {
                    return obj;
                }
                i4 = i3;
                str6 = str5;
                i5 = i2;
                obj2 = objPost$default;
                str7 = str3;
                requestBody3 = requestBody2;
                niceResponse = (NiceResponse) obj2;
                if (niceResponse.getCode() != 401 || niceResponse.getCode() == 441) {
                    bearerToken = null;
                    sharedPreferences = this.sharedPref;
                    if (sharedPreferences != null && (editorEdit = sharedPreferences.edit()) != null && (editorRemove = editorEdit.remove(this.PREF_TOKEN_KEY)) != null) {
                        editorRemove.apply();
                    }
                    c00082.L$0 = SpillingKt.nullOutSpilledVariable(str7);
                    c00082.L$1 = str6;
                    c00082.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                    c00082.L$3 = requestBody3;
                    c00082.L$4 = SpillingKt.nullOutSpilledVariable(map);
                    c00082.L$5 = SpillingKt.nullOutSpilledVariable(niceResponse);
                    c00082.I$0 = i5;
                    c00082.I$1 = i4;
                    c00082.label = 3;
                    obj3 = obj;
                    objBuildAuthHeaders$default2 = buildAuthHeaders$default(this, "POST", str6, "application/json; charset=utf-8", null, str2, false, c00082, 40, null);
                    if (objBuildAuthHeaders$default2 == obj3) {
                        return obj3;
                    }
                    int i9 = i4;
                    objPost$default2 = objBuildAuthHeaders$default2;
                    i6 = i9;
                    str8 = str2;
                    i7 = i5;
                    requestBody4 = requestBody3;
                    niceResponse2 = niceResponse;
                    str9 = str6;
                    str10 = str7;
                    map2 = (Map) objPost$default2;
                    Requests app2 = MainActivityKt.getApp();
                    c00082.L$0 = SpillingKt.nullOutSpilledVariable(str10);
                    c00082.L$1 = SpillingKt.nullOutSpilledVariable(str9);
                    c00082.L$2 = SpillingKt.nullOutSpilledVariable(str8);
                    c00082.L$3 = SpillingKt.nullOutSpilledVariable(requestBody4);
                    c00082.L$4 = SpillingKt.nullOutSpilledVariable(map2);
                    c00082.L$5 = SpillingKt.nullOutSpilledVariable(niceResponse2);
                    c00082.I$0 = i7;
                    c00082.I$1 = i6;
                    c00082.label = 4;
                    objPost$default2 = Requests.post$default(app2, str9, map2, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody4, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00082, 65276, (Object) null);
                    if (objPost$default2 == obj3) {
                        return obj3;
                    }
                    str11 = str10;
                    str12 = str9;
                    map3 = map2;
                    requestBody5 = requestBody4;
                    niceResponse = (NiceResponse) objPost$default2;
                    str6 = str12;
                }
                this.persistTokenFromXUser(niceResponse.getHeaders().get("x-user"));
                String text = niceResponse.getText();
                jsonNode = ExtensionsKt.jacksonObjectMapper().readTree(text).get("data");
                if (jsonNode != null || (jsonNode2 = jsonNode.get("results")) == null) {
                    bool = null;
                    return MainAPIKt.newSearchResponseList$default(CollectionsKt.emptyList(), bool, 2, bool);
                }
                ArrayList arrayList = new ArrayList();
                Iterator it = jsonNode2.iterator();
                while (it.hasNext()) {
                    text = text;
                    JsonNode<JsonNode> jsonNode4 = ((JsonNode) it.next()).get("subjects");
                    if (jsonNode4 != null) {
                        for (final JsonNode jsonNode5 : jsonNode4) {
                            jsonNode4 = jsonNode4;
                            if (!this.isNsfwItem(jsonNode5)) {
                                JsonNode jsonNode6 = jsonNode5.get("title");
                                if (jsonNode6 == null || (strAsText = jsonNode6.asText()) == null) {
                                    str6 = str6;
                                } else {
                                    JsonNode jsonNode7 = jsonNode5.get("subjectId");
                                    if (jsonNode7 == null || (strAsText2 = jsonNode7.asText()) == null) {
                                        str6 = str6;
                                    } else {
                                        JsonNode jsonNode8 = jsonNode5.get("cover");
                                        if (jsonNode8 != null) {
                                            str13 = str6;
                                            JsonNode jsonNode9 = jsonNode8.get("url");
                                            final String strAsText3 = jsonNode9 != null ? jsonNode9.asText() : null;
                                            jsonNode3 = jsonNode5.get("subjectType");
                                            if (jsonNode3 != null) {
                                                iAsInt = jsonNode3.asInt();
                                            } else {
                                                iAsInt = 1;
                                            }
                                            switch (iAsInt) {
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
                                            arrayList.add(MainAPIKt.newMovieSearchResponse$default(this, strAsText, strAsText2, tvType, false, new Function1() { // from class: com.MovieBox.MovieBoxProvider$$ExternalSyntheticLambda0
                                                public final Object invoke(Object obj4) {
                                                    return MovieBoxProvider.search$lambda$0(strAsText3, jsonNode5, (MovieSearchResponse) obj4);
                                                }
                                            }, 8, (Object) null));
                                            str6 = str13;
                                        } else {
                                            str13 = str6;
                                        }
                                        jsonNode3 = jsonNode5.get("subjectType");
                                        if (jsonNode3 != null) {
                                            iAsInt = jsonNode3.asInt();
                                        } else {
                                            iAsInt = 1;
                                        }
                                        switch (iAsInt) {
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
                                        arrayList.add(MainAPIKt.newMovieSearchResponse$default(this, strAsText, strAsText2, tvType, false, new Function1() { // from class: com.MovieBox.MovieBoxProvider$$ExternalSyntheticLambda0
                                            public final Object invoke(Object obj4) {
                                                return MovieBoxProvider.search$lambda$0(strAsText3, jsonNode5, (MovieSearchResponse) obj4);
                                            }
                                        }, 8, (Object) null));
                                        str6 = str13;
                                    }
                                }
                            }
                        }
                        this = this;
                    }
                }
                return MainAPIKt.toNewSearchResponseList$default(arrayList, (Boolean) null, 1, (Object) null);
            case 1:
                int i10 = c00082.I$1;
                i2 = c00082.I$0;
                requestBody = (RequestBody) c00082.L$3;
                str2 = (String) c00082.L$2;
                str4 = (String) c00082.L$1;
                str3 = (String) c00082.L$0;
                ResultKt.throwOnFailure(objPost$default2);
                i3 = i10;
                objBuildAuthHeaders$default = objPost$default2;
                Map map5 = (Map) objBuildAuthHeaders$default;
                Requests app3 = MainActivityKt.getApp();
                c00082.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                c00082.L$1 = str4;
                c00082.L$2 = str2;
                c00082.L$3 = requestBody;
                c00082.L$4 = SpillingKt.nullOutSpilledVariable(map5);
                c00082.I$0 = i2;
                c00082.I$1 = i3;
                c00082.label = 2;
                map = map5;
                requestBody2 = requestBody;
                obj = coroutine_suspended;
                str5 = str4;
                objPost$default = Requests.post$default(app3, str5, map, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody2, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00082, 65276, (Object) null);
                if (objPost$default == obj) {
                    return obj;
                }
                i4 = i3;
                str6 = str5;
                i5 = i2;
                obj2 = objPost$default;
                str7 = str3;
                requestBody3 = requestBody2;
                niceResponse = (NiceResponse) obj2;
                if (niceResponse.getCode() != 401) {
                    break;
                }
                bearerToken = null;
                sharedPreferences = this.sharedPref;
                if (sharedPreferences != null) {
                    editorRemove.apply();
                }
                c00082.L$0 = SpillingKt.nullOutSpilledVariable(str7);
                c00082.L$1 = str6;
                c00082.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                c00082.L$3 = requestBody3;
                c00082.L$4 = SpillingKt.nullOutSpilledVariable(map);
                c00082.L$5 = SpillingKt.nullOutSpilledVariable(niceResponse);
                c00082.I$0 = i5;
                c00082.I$1 = i4;
                c00082.label = 3;
                obj3 = obj;
                objBuildAuthHeaders$default2 = buildAuthHeaders$default(this, "POST", str6, "application/json; charset=utf-8", null, str2, false, c00082, 40, null);
                if (objBuildAuthHeaders$default2 == obj3) {
                    return obj3;
                }
                int i11 = i4;
                objPost$default2 = objBuildAuthHeaders$default2;
                i6 = i11;
                str8 = str2;
                i7 = i5;
                requestBody4 = requestBody3;
                niceResponse2 = niceResponse;
                str9 = str6;
                str10 = str7;
                map2 = (Map) objPost$default2;
                Requests app4 = MainActivityKt.getApp();
                c00082.L$0 = SpillingKt.nullOutSpilledVariable(str10);
                c00082.L$1 = SpillingKt.nullOutSpilledVariable(str9);
                c00082.L$2 = SpillingKt.nullOutSpilledVariable(str8);
                c00082.L$3 = SpillingKt.nullOutSpilledVariable(requestBody4);
                c00082.L$4 = SpillingKt.nullOutSpilledVariable(map2);
                c00082.L$5 = SpillingKt.nullOutSpilledVariable(niceResponse2);
                c00082.I$0 = i7;
                c00082.I$1 = i6;
                c00082.label = 4;
                objPost$default2 = Requests.post$default(app4, str9, map2, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody4, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00082, 65276, (Object) null);
                if (objPost$default2 == obj3) {
                    return obj3;
                }
                str11 = str10;
                str12 = str9;
                map3 = map2;
                requestBody5 = requestBody4;
                niceResponse = (NiceResponse) objPost$default2;
                str6 = str12;
                this.persistTokenFromXUser(niceResponse.getHeaders().get("x-user"));
                String text2 = niceResponse.getText();
                jsonNode = ExtensionsKt.jacksonObjectMapper().readTree(text2).get("data");
                if (jsonNode != null) {
                    bool = null;
                } else {
                    bool = null;
                }
                return MainAPIKt.newSearchResponseList$default(CollectionsKt.emptyList(), bool, 2, bool);
            case 2:
                int i12 = c00082.I$1;
                int i13 = c00082.I$0;
                Map map6 = (Map) c00082.L$4;
                RequestBody requestBody6 = (RequestBody) c00082.L$3;
                String str16 = (String) c00082.L$2;
                String str17 = (String) c00082.L$1;
                String str18 = (String) c00082.L$0;
                ResultKt.throwOnFailure(objPost$default2);
                map = map6;
                requestBody3 = requestBody6;
                str2 = str16;
                str6 = str17;
                str7 = str18;
                i4 = i12;
                obj = coroutine_suspended;
                i5 = i13;
                obj2 = objPost$default2;
                niceResponse = (NiceResponse) obj2;
                if (niceResponse.getCode() != 401) {
                    break;
                }
                bearerToken = null;
                sharedPreferences = this.sharedPref;
                if (sharedPreferences != null) {
                    editorRemove.apply();
                }
                c00082.L$0 = SpillingKt.nullOutSpilledVariable(str7);
                c00082.L$1 = str6;
                c00082.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                c00082.L$3 = requestBody3;
                c00082.L$4 = SpillingKt.nullOutSpilledVariable(map);
                c00082.L$5 = SpillingKt.nullOutSpilledVariable(niceResponse);
                c00082.I$0 = i5;
                c00082.I$1 = i4;
                c00082.label = 3;
                obj3 = obj;
                objBuildAuthHeaders$default2 = buildAuthHeaders$default(this, "POST", str6, "application/json; charset=utf-8", null, str2, false, c00082, 40, null);
                if (objBuildAuthHeaders$default2 == obj3) {
                    return obj3;
                }
                int i14 = i4;
                objPost$default2 = objBuildAuthHeaders$default2;
                i6 = i14;
                str8 = str2;
                i7 = i5;
                requestBody4 = requestBody3;
                niceResponse2 = niceResponse;
                str9 = str6;
                str10 = str7;
                map2 = (Map) objPost$default2;
                Requests app5 = MainActivityKt.getApp();
                c00082.L$0 = SpillingKt.nullOutSpilledVariable(str10);
                c00082.L$1 = SpillingKt.nullOutSpilledVariable(str9);
                c00082.L$2 = SpillingKt.nullOutSpilledVariable(str8);
                c00082.L$3 = SpillingKt.nullOutSpilledVariable(requestBody4);
                c00082.L$4 = SpillingKt.nullOutSpilledVariable(map2);
                c00082.L$5 = SpillingKt.nullOutSpilledVariable(niceResponse2);
                c00082.I$0 = i7;
                c00082.I$1 = i6;
                c00082.label = 4;
                objPost$default2 = Requests.post$default(app5, str9, map2, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody4, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00082, 65276, (Object) null);
                if (objPost$default2 == obj3) {
                    return obj3;
                }
                str11 = str10;
                str12 = str9;
                map3 = map2;
                requestBody5 = requestBody4;
                niceResponse = (NiceResponse) objPost$default2;
                str6 = str12;
                this.persistTokenFromXUser(niceResponse.getHeaders().get("x-user"));
                String text3 = niceResponse.getText();
                jsonNode = ExtensionsKt.jacksonObjectMapper().readTree(text3).get("data");
                if (jsonNode != null) {
                    bool = null;
                } else {
                    bool = null;
                }
                return MainAPIKt.newSearchResponseList$default(CollectionsKt.emptyList(), bool, 2, bool);
            case 3:
                i6 = c00082.I$1;
                i7 = c00082.I$0;
                niceResponse2 = (NiceResponse) c00082.L$5;
                RequestBody requestBody7 = (RequestBody) c00082.L$3;
                str8 = (String) c00082.L$2;
                String str19 = (String) c00082.L$1;
                String str20 = (String) c00082.L$0;
                ResultKt.throwOnFailure(objPost$default2);
                requestBody4 = requestBody7;
                str10 = str20;
                obj3 = coroutine_suspended;
                str9 = str19;
                map2 = (Map) objPost$default2;
                Requests app6 = MainActivityKt.getApp();
                c00082.L$0 = SpillingKt.nullOutSpilledVariable(str10);
                c00082.L$1 = SpillingKt.nullOutSpilledVariable(str9);
                c00082.L$2 = SpillingKt.nullOutSpilledVariable(str8);
                c00082.L$3 = SpillingKt.nullOutSpilledVariable(requestBody4);
                c00082.L$4 = SpillingKt.nullOutSpilledVariable(map2);
                c00082.L$5 = SpillingKt.nullOutSpilledVariable(niceResponse2);
                c00082.I$0 = i7;
                c00082.I$1 = i6;
                c00082.label = 4;
                objPost$default2 = Requests.post$default(app6, str9, map2, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody4, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00082, 65276, (Object) null);
                if (objPost$default2 == obj3) {
                    return obj3;
                }
                str11 = str10;
                str12 = str9;
                map3 = map2;
                requestBody5 = requestBody4;
                niceResponse = (NiceResponse) objPost$default2;
                str6 = str12;
                this.persistTokenFromXUser(niceResponse.getHeaders().get("x-user"));
                String text4 = niceResponse.getText();
                jsonNode = ExtensionsKt.jacksonObjectMapper().readTree(text4).get("data");
                if (jsonNode != null) {
                    bool = null;
                } else {
                    bool = null;
                }
                return MainAPIKt.newSearchResponseList$default(CollectionsKt.emptyList(), bool, 2, bool);
            case 4:
                i6 = c00082.I$1;
                i7 = c00082.I$0;
                map3 = (Map) c00082.L$4;
                requestBody5 = (RequestBody) c00082.L$3;
                str8 = (String) c00082.L$2;
                str12 = (String) c00082.L$1;
                str11 = (String) c00082.L$0;
                ResultKt.throwOnFailure(objPost$default2);
                niceResponse = (NiceResponse) objPost$default2;
                str6 = str12;
                this.persistTokenFromXUser(niceResponse.getHeaders().get("x-user"));
                String text5 = niceResponse.getText();
                jsonNode = ExtensionsKt.jacksonObjectMapper().readTree(text5).get("data");
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

    /* JADX WARN: Code duplicated, block: B:151:0x0a5c  */
    /* JADX WARN: Code duplicated, block: B:152:0x0a65  */
    /* JADX WARN: Code duplicated, block: B:290:0x0f31  */
    /* JADX WARN: Code duplicated, block: B:292:0x1022 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:293:0x1023  */
    /* JADX WARN: Code duplicated, block: B:296:0x1141 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:297:0x1142  */
    /* JADX WARN: Code duplicated, block: B:300:0x1189  */
    /* JADX WARN: Code duplicated, block: B:302:0x119b  */
    /* JADX WARN: Code duplicated, block: B:303:0x11a4  */
    /* JADX WARN: Code duplicated, block: B:305:0x11a9  */
    /* JADX WARN: Code duplicated, block: B:332:0x124f A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:334:0x1256  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:297:0x1142 -> B:298:0x117b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object load(@org.jetbrains.annotations.NotNull java.lang.String r91, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r92) {
        /*
            Method dump skipped, instruction units count: 6156
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
    @SourceDebugExtension({"SMAP\nMovieBoxProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MovieBoxProvider.kt\ncom/MovieBox/MovieBoxProvider$load$6\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1233:1\n1#2:1234\n*E\n"})
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
    @SourceDebugExtension({"SMAP\nMovieBoxProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MovieBoxProvider.kt\ncom/MovieBox/MovieBoxProvider$load$7\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1233:1\n1#2:1234\n*E\n"})
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
    @DebugMetadata(c = "com.MovieBox.MovieBoxProvider$loadLinks$2", f = "MovieBoxProvider.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14}, l = {829, 830, 833, 834, 835, 865, 893, 894, 905, 914, 915, 926, 937, 938, 952}, m = "invokeSuspend", n = {"<destruct>", "subjectId", "language", "playUrl", "<destruct>", "subjectId", "language", "playUrl", "playHeaders", "<destruct>", "subjectId", "language", "playUrl", "playHeaders", "response", "<destruct>", "subjectId", "language", "playUrl", "playHeaders", "response", "<destruct>", "subjectId", "language", "playUrl", "playHeaders", "response", "<destruct>", "subjectId", "language", "playUrl", "playHeaders", "response", "responseBody", "root", "playData", "streams", "stream", "rawStreamUrl", "format", "resolutions", "signCookieRaw", "signCookie", "streamId", "quality", "policyUrl", "finalStreamUrl", "<destruct>", "subjectId", "language", "playUrl", "playHeaders", "response", "responseBody", "root", "playData", "streams", "stream", "rawStreamUrl", "format", "resolutions", "signCookieRaw", "signCookie", "streamId", "quality", "policyUrl", "finalStreamUrl", "subLink", "<destruct>", "subjectId", "language", "playUrl", "playHeaders", "response", "responseBody", "root", "playData", "streams", "stream", "rawStreamUrl", "format", "resolutions", "signCookieRaw", "signCookie", "streamId", "quality", "policyUrl", "finalStreamUrl", "subLink", "subHeaders", "<destruct>", "subjectId", "language", "playUrl", "playHeaders", "response", "responseBody", "root", "playData", "streams", "stream", "rawStreamUrl", "format", "resolutions", "signCookieRaw", "signCookie", "streamId", "quality", "policyUrl", "finalStreamUrl", "subLink", "subHeaders", "subResponse", "subRoot", "extCaptions", "caption", "captionUrl", "lang", "<destruct>", "subjectId", "language", "playUrl", "playHeaders", "response", "responseBody", "root", "playData", "streams", "stream", "rawStreamUrl", "format", "resolutions", "signCookieRaw", "signCookie", "streamId", "quality", "policyUrl", "finalStreamUrl", "subLink", "subHeaders", "subResponse", "subRoot", "extCaptions", "subLink1", "<destruct>", "subjectId", "language", "playUrl", "playHeaders", "response", "responseBody", "root", "playData", "streams", "stream", "rawStreamUrl", "format", "resolutions", "signCookieRaw", "signCookie", "streamId", "quality", "policyUrl", "finalStreamUrl", "subLink", "subHeaders", "subResponse", "subRoot", "extCaptions", "subLink1", "subHeaders1", "<destruct>", "subjectId", "language", "playUrl", "playHeaders", "response", "responseBody", "root", "playData", "streams", "stream", "rawStreamUrl", "format", "resolutions", "signCookieRaw", "signCookie", "streamId", "quality", "policyUrl", "finalStreamUrl", "subLink", "subHeaders", "subResponse", "subRoot", "extCaptions", "subLink1", "subHeaders1", "subResponse1", "subRoot1", "extCaptions1", "caption", "captionUrl", "lang", "<destruct>", "subjectId", "language", "playUrl", "playHeaders", "response", "responseBody", "root", "playData", "streams", "fallbackUrl", "<destruct>", "subjectId", "language", "playUrl", "playHeaders", "response", "responseBody", "root", "playData", "streams", "fallbackUrl", "fallbackHeaders", "<destruct>", "subjectId", "language", "playUrl", "playHeaders", "response", "responseBody", "root", "playData", "streams", "fallbackUrl", "fallbackHeaders", "fallbackResponse", "fallbackRoot", "detectors", "$this$forEach$iv", "element$iv", "detector", "$this$forEach$iv", "element$iv", "video", "se", "link", "ep", "quality"}, nl = {830, 832, 834, 835, 838, 864, 894, 895, 904, 915, 916, 925, 938, 940, 951}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$27", "L$28", "L$29", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$28", "L$29", "L$30", "L$32", "L$33", "L$34", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$19", "L$20", "L$21", "L$23", "L$24", "L$25", "L$26", "L$27", "I$2"}, v = 2)
    @SourceDebugExtension({"SMAP\nMovieBoxProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MovieBoxProvider.kt\ncom/MovieBox/MovieBoxProvider$loadLinks$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1233:1\n2068#2:1234\n2068#2,2:1235\n2069#2:1237\n*S KotlinDebug\n*F\n+ 1 MovieBoxProvider.kt\ncom/MovieBox/MovieBoxProvider$loadLinks$2\n*L\n943#1:1234\n944#1:1235,2\n943#1:1237\n*E\n"})
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
