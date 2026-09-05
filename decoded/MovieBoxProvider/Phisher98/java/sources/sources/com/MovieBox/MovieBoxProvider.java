package com.MovieBox;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.net.Uri;
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
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
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
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
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
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ^2\u00020\u0001:\u0002^_B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007H\u0002J\u000e\u0010\u0010\u001a\u00020\u0007H\u0082@¢\u0006\u0002\u0010\u0011J\u0012\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020'H\u0002J\u0010\u0010(\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007H\u0002J\u0019\u0010)\u001a\u00020\u00072\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+H\u0002¢\u0006\u0002\u0010,J\u0006\u0010/\u001a\u00020\u0007J\u0006\u00105\u001a\u000206JP\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u00072\b\u00109\u001a\u0004\u0018\u00010\u00072\b\u0010:\u001a\u0004\u0018\u00010\u00072\u0006\u0010;\u001a\u00020\u00072\b\u0010<\u001a\u0004\u0018\u00010\u00072\u0006\u0010=\u001a\u00020+H\u0003b\u0010\b>\u0012\f\b?\u0012\b\b\fJ\u0004\b\b(@JS\u0010A\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u00072\b\u00109\u001a\u0004\u0018\u00010\u00072\b\u0010:\u001a\u0004\u0018\u00010\u00072\u0006\u0010;\u001a\u00020\u00072\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010B\u001a\u00020\u00182\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+H\u0002¢\u0006\u0002\u0010CJ\u001e\u0010F\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020LH\u0096@¢\u0006\u0002\u0010MJ\u001e\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020\u00072\u0006\u0010I\u001a\u00020JH\u0096@¢\u0006\u0002\u0010QJ\u0016\u0010R\u001a\u00020S2\u0006\u0010;\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010TJF\u0010U\u001a\u00020\u00182\u0006\u0010V\u001a\u00020\u00072\u0006\u0010W\u001a\u00020\u00182\u0012\u0010X\u001a\u000e\u0012\u0004\u0012\u00020Z\u0012\u0004\u0012\u00020\u000e0Y2\u0012\u0010[\u001a\u000e\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u00020\u000e0YH\u0096@¢\u0006\u0002\u0010]R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\t\"\u0004\b\u0016\u0010\u000bR\u0014\u0010\u0017\u001a\u00020\u0018X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\t\"\u0004\b\u001d\u0010\u000bR\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u00100\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\tR \u00102\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070403X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010D\u001a\b\u0012\u0004\u0012\u00020E04X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010G¨\u0006`"}, d2 = {"Lcom/MovieBox/MovieBoxProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "sharedPref", "Landroid/content/SharedPreferences;", "<init>", "(Landroid/content/SharedPreferences;)V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "PREF_TOKEN_KEY", "saveToken", "", "token", "getCachedToken", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "persistTokenFromXUser", "xUserHeader", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "secretKeyDefault", "secretKeyAlt", "md5", "input", "", "reverseString", "generateXClientToken", "hardcodedTimestamp", "", "(Ljava/lang/Long;)Ljava/lang/String;", "random", "Ljava/security/SecureRandom;", "generateDeviceId", "deviceId", "getDeviceId", "brandModels", "", "", "randomBrandModel", "Lcom/MovieBox/MovieBoxProvider$BrandModel;", "buildCanonicalString", "method", "accept", "contentType", "url", "body", "timestamp", "Landroid/annotation/SuppressLint;", "value", "UseKtx", "generateXTrSignature", "useAltKey", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Long;)Ljava/lang/String;", "mainPage", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "Lcom/lagradost/cloudstream3/SearchResponseList;", "query", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "BrandModel", "MovieBoxProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMovieBoxProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MovieBoxProvider.kt\ncom/MovieBox/MovieBoxProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 5 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 6 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,1211:1\n2068#2,2:1212\n1795#2,10:1214\n2068#2:1224\n2069#2:1226\n1805#2:1227\n1795#2,10:1228\n2068#2:1238\n2069#2:1240\n1805#2:1241\n1849#2,8:1242\n1739#2:1250\n1814#2,3:1251\n2068#2,2:1254\n2068#2:1256\n2069#2:1264\n2068#2:1266\n296#2,2:1267\n2069#2:1276\n1#3:1225\n1#3:1239\n1#3:1269\n460#4,7:1257\n221#5:1265\n222#5:1277\n437#6:1270\n513#6,5:1271\n*S KotlinDebug\n*F\n+ 1 MovieBoxProvider.kt\ncom/MovieBox/MovieBoxProvider\n*L\n321#1:1212,2\n376#1:1214,10\n376#1:1224\n376#1:1226\n376#1:1227\n514#1:1228,10\n514#1:1238\n514#1:1240\n514#1:1241\n526#1:1242,8\n530#1:1250\n530#1:1251,3\n574#1:1254,2\n601#1:1256\n601#1:1264\n616#1:1266\n618#1:1267,2\n616#1:1276\n376#1:1225\n514#1:1239\n605#1:1257,7\n615#1:1265\n615#1:1277\n635#1:1270\n635#1:1271,5\n*E\n"})
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
    private final Map<String, List<String>> brandModels;

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

    /* JADX INFO: renamed from: com.MovieBox.MovieBoxProvider$getCachedToken$1 */
    /* JADX INFO: compiled from: MovieBoxProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.MovieBox.MovieBoxProvider", f = "MovieBoxProvider.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {133}, m = "getCachedToken", n = {"saved", "url", "brand", "model", "xClientToken", "xTrSignature", "headers"}, nl = {134}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"}, v = 2)
    static final class C00001 extends ContinuationImpl {
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
            return MovieBoxProvider.this.getCachedToken((Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.MovieBox.MovieBoxProvider$getMainPage$1 */
    /* JADX INFO: compiled from: MovieBoxProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.MovieBox.MovieBoxProvider", f = "MovieBoxProvider.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {368, 368}, m = "getMainPage", n = {"request", "url", "data1", "mainParts", "channelId", "options", "classify", "country", "year", "genre", "sort", "jsonBody", "xClientToken", "xTrSignature", "getxTrSignature", "headers", "getheaders", "requestBody", "page", "perPage", "pg", "request", "url", "data1", "mainParts", "channelId", "options", "classify", "country", "year", "genre", "sort", "jsonBody", "xClientToken", "xTrSignature", "getxTrSignature", "headers", "getheaders", "requestBody", "page", "perPage", "pg"}, nl = {368, 370}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "I$0", "I$1", "I$2"}, v = 2)
    static final class C00011 extends ContinuationImpl {
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
        Object L$15;
        Object L$16;
        Object L$17;
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

        C00011(Continuation<? super C00011> continuation) {
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
    @DebugMetadata(c = "com.MovieBox.MovieBoxProvider", f = "MovieBoxProvider.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7}, l = {486, 489, 549, 555, 563, 591, 667, 682}, m = "load", n = {"url", "id", "finalUrl", "xClientToken", "xTrSignature", "url", "id", "finalUrl", "xClientToken", "xTrSignature", "headers", "url", "id", "finalUrl", "xClientToken", "xTrSignature", "headers", "response", "body", "mapper", "root", "data", "title", "description", "releaseDate", "duration", "genre", "imdbRating", "year", "coverUrl", "backgroundUrl", "actors", "tags", "durationMinutes", "type", "subjectType", "url", "id", "finalUrl", "xClientToken", "xTrSignature", "headers", "response", "body", "mapper", "root", "data", "title", "description", "releaseDate", "duration", "genre", "imdbRating", "year", "coverUrl", "backgroundUrl", "actors", "tags", "durationMinutes", "type", "tmdbId", "imdbId", "subjectType", "url", "id", "finalUrl", "xClientToken", "xTrSignature", "headers", "response", "body", "mapper", "root", "data", "title", "description", "releaseDate", "duration", "genre", "imdbRating", "year", "coverUrl", "backgroundUrl", "actors", "tags", "durationMinutes", "type", "tmdbId", "imdbId", "logoUrl", "subjectType", "url", "id", "finalUrl", "xClientToken", "xTrSignature", "headers", "response", "body", "mapper", "root", "data", "title", "description", "releaseDate", "duration", "genre", "imdbRating", "year", "coverUrl", "backgroundUrl", "actors", "tags", "durationMinutes", "type", "tmdbId", "imdbId", "logoUrl", "meta", "metaVideos", "Poster", "Background", "Description", "IMDBRating", "allSubjectIds", "episodeMap", "subjectId", "seasonUrl", "seasonSig", "seasonHeaders", "subjectType", "url", "id", "finalUrl", "xClientToken", "xTrSignature", "headers", "response", "body", "mapper", "root", "data", "title", "description", "releaseDate", "duration", "genre", "imdbRating", "year", "coverUrl", "backgroundUrl", "actors", "tags", "durationMinutes", "type", "tmdbId", "imdbId", "logoUrl", "meta", "metaVideos", "Poster", "Background", "Description", "IMDBRating", "allSubjectIds", "episodeMap", "episodes", "subjectType", "url", "id", "finalUrl", "xClientToken", "xTrSignature", "headers", "response", "body", "mapper", "root", "data", "title", "description", "releaseDate", "duration", "genre", "imdbRating", "year", "coverUrl", "backgroundUrl", "actors", "tags", "durationMinutes", "type", "tmdbId", "imdbId", "logoUrl", "meta", "metaVideos", "Poster", "Background", "Description", "IMDBRating", "subjectType"}, nl = {477, 490, 555, 563, 564, 592, 682, -1}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$28", "L$29", "L$30", "L$31", "L$32", "L$33", "L$34", "L$36", "L$37", "L$38", "L$39", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$28", "L$29", "L$30", "L$31", "L$32", "L$33", "L$34", "L$35", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$28", "L$29", "L$30", "L$31", "L$32", "I$0"}, v = 2)
    static final class C00021 extends ContinuationImpl {
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
        Object L$37;
        Object L$38;
        Object L$39;
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
            return MovieBoxProvider.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.MovieBox.MovieBoxProvider$loadLinks$1 */
    /* JADX INFO: compiled from: MovieBoxProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.MovieBox.MovieBoxProvider", f = "MovieBoxProvider.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {735, 738, 766, 774}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "brand", "model", "parts", "originalSubjectId", "subjectUrl", "subjectXClientToken", "subjectXTrSignature", "isCasting", "season", "episode", "data", "subtitleCallback", "callback", "brand", "model", "parts", "originalSubjectId", "subjectUrl", "subjectXClientToken", "subjectXTrSignature", "subjectHeaders", "isCasting", "season", "episode", "data", "subtitleCallback", "callback", "brand", "model", "parts", "originalSubjectId", "subjectUrl", "subjectXClientToken", "subjectXTrSignature", "subjectHeaders", "subjectResponse", "mapper", "subjectIds", "originalLanguageName", "isCasting", "season", "episode", "data", "subtitleCallback", "callback", "brand", "model", "parts", "originalSubjectId", "subjectUrl", "subjectXClientToken", "subjectXTrSignature", "subjectHeaders", "subjectResponse", "mapper", "subjectIds", "originalLanguageName", "token", "isCasting", "season", "episode"}, nl = {727, 739, 769, 953}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "Z$0", "I$0", "I$1"}, v = 2)
    static final class C00051 extends ContinuationImpl {
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
        Object L$15;
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

        C00051(Continuation<? super C00051> continuation) {
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
    @DebugMetadata(c = "com.MovieBox.MovieBoxProvider", f = "MovieBoxProvider.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {421, 424}, m = "search", n = {"query", "url", "jsonBody", "xClientToken", "xTrSignature", "page", "query", "url", "jsonBody", "xClientToken", "xTrSignature", "headers", "requestBody", "page"}, nl = {413, 430}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0"}, v = 2)
    static final class C00071 extends ContinuationImpl {
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
        int label;
        /* synthetic */ Object result;

        C00071(Continuation<? super C00071> continuation) {
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
        this.PREF_TOKEN_KEY = "moviebox_bearer_token_v3";
        this.name = "MovieBox";
        this.hasMainPage = true;
        this.lang = "hi";
        this.supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.TvSeries});
        this.secretKeyDefault = MainAPIKt.base64Decode("NzZpUmwwN3MweFNOOWpxbUVXQXQ3OUVCSlp1bElRSXNWNjRGWnIyTw==");
        this.secretKeyAlt = MainAPIKt.base64Decode("WHFuMm5uTzQxL0w5Mm8xaXVYaFNMSFRiWHZZNFo1Wlo2Mm04bVNMQQ==");
        this.random = new SecureRandom();
        this.deviceId = generateDeviceId();
        this.brandModels = MapsKt.mapOf(new Pair[]{TuplesKt.to("Samsung", CollectionsKt.listOf(new String[]{"SM-S918B", "SM-A528B", "SM-M336B"})), TuplesKt.to("Xiaomi", CollectionsKt.listOf(new String[]{"2201117TI", "M2012K11AI", "Redmi Note 11"})), TuplesKt.to("OnePlus", CollectionsKt.listOf(new String[]{"LE2111", "CPH2449", "IN2023"})), TuplesKt.to("Google", CollectionsKt.listOf(new String[]{"Pixel 6", "Pixel 7", "Pixel 8"})), TuplesKt.to("Realme", CollectionsKt.listOf(new String[]{"RMX3085", "RMX3360", "RMX3551"}))});
        this.mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("4516404531735022304", "Trending"), TuplesKt.to("5692654647815587592", "Trending in Cinema"), TuplesKt.to("414907768299210008", "Bollywood"), TuplesKt.to("3859721901924910512", "South Indian"), TuplesKt.to("8019599703232971616", "Hollywood"), TuplesKt.to("4741626294545400336", "Top Series This Week"), TuplesKt.to("8434602210994128512", "Anime"), TuplesKt.to("1255898847918934600", "Reality TV"), TuplesKt.to("4903182713986896328", "Indian Drama"), TuplesKt.to("7878715743607948784", "Korean Drama"), TuplesKt.to("8788126208987989488", "Chinese Drama"), TuplesKt.to("3910636007619709856", "Western TV"), TuplesKt.to("5177200225164885656", "Turkish Drama"), TuplesKt.to("1|1", "Movies"), TuplesKt.to("1|2", "Series"), TuplesKt.to("1|1006", "Anime"), TuplesKt.to("1|1;country=India", "Indian (Movies)"), TuplesKt.to("1|2;country=India", "Indian (Series)"), TuplesKt.to("1|1;classify=Hindi dub;country=United States", "USA (Movies)"), TuplesKt.to("1|2;classify=Hindi dub;country=United States", "USA (Series)"), TuplesKt.to("1|1;country=Japan", "Japan (Movies)"), TuplesKt.to("1|2;country=Japan", "Japan (Series)"), TuplesKt.to("1|1;country=China", "China (Movies)"), TuplesKt.to("1|2;country=China", "China (Series)"), TuplesKt.to("1|1;country=Philippines", "Philippines (Movies)"), TuplesKt.to("1|2;country=Philippines", "Philippines (Series)"), TuplesKt.to("1|1;country=Thailand", "Thailand(Movies)"), TuplesKt.to("1|2;country=Thailand", "Thailand(Series)"), TuplesKt.to("1|1;country=Nigeria", "Nollywood (Movies)"), TuplesKt.to("1|2;country=Nigeria", "Nollywood (Series)"), TuplesKt.to("1|1;country=Korea", "South Korean (Movies)"), TuplesKt.to("1|2;country=Korea", "South Korean (Series)"), TuplesKt.to("1|1;classify=Hindi dub;genre=Action", "Action (Movies)"), TuplesKt.to("1|1;classify=Hindi dub;genre=Crime", "Crime (Movies)"), TuplesKt.to("1|1;classify=Hindi dub;genre=Comedy", "Comedy (Movies)"), TuplesKt.to("1|2;classify=Hindi dub;genre=Crime", "Crime (Series)"), TuplesKt.to("1|2;classify=Hindi dub;genre=Comedy", "Comedy (Series)")});
    }

    public /* synthetic */ MovieBoxProvider(SharedPreferences sharedPreferences, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : sharedPreferences);
    }

    /* JADX INFO: compiled from: MovieBoxProvider.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006J\u0010\u0010\u0011\u001a\u00020\u00122\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/MovieBox/MovieBoxProvider$Companion;", "", "<init>", "()V", "HOST_POOL", "", "", "getHOST_POOL", "()Ljava/util/List;", "bearerToken", "getBearerToken", "()Ljava/lang/String;", "setBearerToken", "(Ljava/lang/String;)V", "decodeJwtExpiry", "", "token", "isTokenValid", "", "MovieBoxProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nMovieBoxProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MovieBoxProvider.kt\ncom/MovieBox/MovieBoxProvider$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1211:1\n1#2:1212\n*E\n"})
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

    private final void saveToken(String token) {
        SharedPreferences.Editor editorEdit;
        SharedPreferences.Editor editorPutString;
        String str = token;
        if (!(str == null || StringsKt.isBlank(str)) && INSTANCE.isTokenValid(token)) {
            bearerToken = token;
            SharedPreferences sharedPreferences = this.sharedPref;
            if (sharedPreferences == null || (editorEdit = sharedPreferences.edit()) == null || (editorPutString = editorEdit.putString(this.PREF_TOKEN_KEY, token)) == null) {
                return;
            }
            editorPutString.apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:40:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:42:0x01dd A[Catch: Exception -> 0x01f9, TryCatch #1 {Exception -> 0x01f9, blocks: (B:36:0x01c2, B:38:0x01d3, B:42:0x01dd, B:44:0x01ed, B:47:0x01f5), top: B:60:0x01c2 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x01ed A[Catch: Exception -> 0x01f9, TryCatch #1 {Exception -> 0x01f9, blocks: (B:36:0x01c2, B:38:0x01d3, B:42:0x01dd, B:44:0x01ed, B:47:0x01f5), top: B:60:0x01c2 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:47:0x01f5 A[Catch: Exception -> 0x01f9, TRY_LEAVE, TryCatch #1 {Exception -> 0x01f9, blocks: (B:36:0x01c2, B:38:0x01d3, B:42:0x01dd, B:44:0x01ed, B:47:0x01f5), top: B:60:0x01c2 }] */
    /* JADX WARN: Code duplicated, block: B:66:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:67:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object getCachedToken(Continuation<? super String> continuation) {
        C00001 c00001;
        String saved;
        String brand;
        String url;
        String saved2;
        String url2;
        String saved3;
        String url3;
        Object obj;
        String xUser;
        String str;
        JsonNode jsonNode;
        String token;
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
                if (INSTANCE.isTokenValid(bearerToken)) {
                    String str2 = bearerToken;
                    Intrinsics.checkNotNull(str2);
                    return str2;
                }
                SharedPreferences sharedPreferences = this.sharedPref;
                String saved4 = sharedPreferences != null ? sharedPreferences.getString(this.PREF_TOKEN_KEY, null) : null;
                if (INSTANCE.isTokenValid(saved4)) {
                    bearerToken = saved4;
                    Intrinsics.checkNotNull(saved4);
                    return saved4;
                }
                String url4 = getMainUrl() + "/wefeed-mobile-bff/tab/ranking-list?tabId=0&categoryType=4516404531735022304&page=1&perPage=1";
                BrandModel brandModelRandomBrandModel = randomBrandModel();
                String brand2 = brandModelRandomBrandModel.getBrand();
                String model = brandModelRandomBrandModel.getModel();
                String xClientToken = generateXClientToken$default(this, null, 1, null);
                saved = saved4;
                String xTrSignature = generateXTrSignature$default(this, "GET", "application/json", "application/json", url4, null, false, null, 112, null);
                Map headers = MapsKt.mapOf(new Pair[]{TuplesKt.to("user-agent", "com.community.oneroom/50020088 (Linux; U; Android 13; en_US; " + brand2 + "; Build/TQ3A.230901.001; Cronet/145.0.7582.0)"), TuplesKt.to("accept", "application/json"), TuplesKt.to("content-type", "application/json"), TuplesKt.to("x-client-token", xClientToken), TuplesKt.to("x-tr-signature", xTrSignature), TuplesKt.to("x-client-info", "{\"package_name\":\"com.community.oneroom\",\"version_name\":\"3.0.13.0325.03\",\"version_code\":50020088,\"os\":\"android\",\"os_version\":\"13\",\"device_id\":\"" + this.deviceId + "\",\"install_store\":\"ps\",\"system_language\":\"en\",\"net\":\"NETWORK_WIFI\",\"region\":\"US\",\"timezone\":\"Asia/Calcutta\",\"sp_code\":\"\"}"), TuplesKt.to("x-client-status", "0")});
                try {
                    Requests app = MainActivityKt.getApp();
                    c00002.L$0 = SpillingKt.nullOutSpilledVariable(saved);
                    c00002.L$1 = SpillingKt.nullOutSpilledVariable(url4);
                    c00002.L$2 = SpillingKt.nullOutSpilledVariable(brand2);
                    c00002.L$3 = SpillingKt.nullOutSpilledVariable(model);
                    c00002.L$4 = SpillingKt.nullOutSpilledVariable(xClientToken);
                    c00002.L$5 = SpillingKt.nullOutSpilledVariable(xTrSignature);
                    c00002.L$6 = SpillingKt.nullOutSpilledVariable(headers);
                    c00002.label = 1;
                    url2 = brand2;
                    saved3 = null;
                    url3 = url4;
                    try {
                        Object obj2 = Requests.get$default(app, url3, headers, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00002, 4092, (Object) null);
                        if (obj2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj = obj2;
                        try {
                            NiceResponse response = (NiceResponse) obj;
                            xUser = response.getHeaders().get("x-user");
                            str = xUser;
                            if (!(str != null || StringsKt.isBlank(str))) {
                                return "";
                            }
                            jsonNode = ExtensionsKt.jacksonObjectMapper().readTree(xUser).get("token");
                            if (jsonNode != null) {
                                token = jsonNode.asText();
                            } else {
                                token = saved3;
                            }
                            if (token != null) {
                                return "";
                            }
                            saveToken(token);
                            return token;
                        } catch (Exception e) {
                            e = e;
                            brand = url2;
                            url = url3;
                            saved2 = saved;
                            e.printStackTrace();
                            return "";
                        }
                    } catch (Exception e2) {
                        e = e2;
                        brand = url2;
                        url = url3;
                        saved2 = saved;
                        e.printStackTrace();
                        return "";
                    }
                } catch (Exception e3) {
                    e = e3;
                    brand = brand2;
                    url = url4;
                    saved2 = saved;
                }
                break;
            case 1:
                brand = (String) c00002.L$2;
                url = (String) c00002.L$1;
                saved2 = (String) c00002.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    saved = saved2;
                    obj = $result;
                    saved3 = null;
                    url3 = url;
                    url2 = brand;
                    NiceResponse response2 = (NiceResponse) obj;
                    xUser = response2.getHeaders().get("x-user");
                    str = xUser;
                    if (!(str != null || StringsKt.isBlank(str))) {
                        return "";
                    }
                    jsonNode = ExtensionsKt.jacksonObjectMapper().readTree(xUser).get("token");
                    if (jsonNode != null) {
                        token = jsonNode.asText();
                    } else {
                        token = saved3;
                    }
                    if (token != null) {
                        return "";
                    }
                    saveToken(token);
                    return token;
                } catch (Exception e4) {
                    e = e4;
                    e.printStackTrace();
                    return "";
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final void persistTokenFromXUser(String xUserHeader) {
        String token;
        String str = xUserHeader;
        if (str == null || StringsKt.isBlank(str)) {
            return;
        }
        try {
            JsonNode jsonNode = ExtensionsKt.jacksonObjectMapper().readTree(xUserHeader).get("token");
            if (jsonNode != null && (token = jsonNode.asText()) != null) {
                saveToken(token);
            }
        } catch (Exception e) {
        }
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

    @NotNull
    public final String generateDeviceId() {
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

    /* JADX INFO: compiled from: MovieBoxProvider.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/MovieBox/MovieBoxProvider$BrandModel;", "", "brand", "", "model", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getBrand", "()Ljava/lang/String;", "getModel", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "MovieBoxProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class BrandModel {

        @NotNull
        private final String brand;

        @NotNull
        private final String model;

        public static /* synthetic */ BrandModel copy$default(BrandModel brandModel, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = brandModel.brand;
            }
            if ((i & 2) != 0) {
                str2 = brandModel.model;
            }
            return brandModel.copy(str, str2);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getBrand() {
            return this.brand;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getModel() {
            return this.model;
        }

        @NotNull
        public final BrandModel copy(@NotNull String brand, @NotNull String model) {
            return new BrandModel(brand, model);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BrandModel)) {
                return false;
            }
            BrandModel brandModel = (BrandModel) other;
            return Intrinsics.areEqual(this.brand, brandModel.brand) && Intrinsics.areEqual(this.model, brandModel.model);
        }

        public int hashCode() {
            return (this.brand.hashCode() * 31) + this.model.hashCode();
        }

        @NotNull
        public String toString() {
            return "BrandModel(brand=" + this.brand + ", model=" + this.model + ')';
        }

        public BrandModel(@NotNull String brand, @NotNull String model) {
            this.brand = brand;
            this.model = model;
        }

        @NotNull
        public final String getBrand() {
            return this.brand;
        }

        @NotNull
        public final String getModel() {
            return this.model;
        }
    }

    @NotNull
    public final BrandModel randomBrandModel() {
        String brand = (String) CollectionsKt.random(this.brandModels.keySet(), Random.Default);
        List<String> list = this.brandModels.get(brand);
        Intrinsics.checkNotNull(list);
        String model = (String) CollectionsKt.random(list, Random.Default);
        return new BrandModel(brand, model);
    }

    @SuppressLint({"UseKtx"})
    private final String buildCanonicalString(String method, String accept, String contentType, String url, String body, long timestamp) {
        byte[] bodyBytes;
        String bodyHash;
        String bodyLength;
        final Uri parsed = Uri.parse(url);
        String path = parsed.getPath();
        if (path == null) {
            path = "";
        }
        String query = !parsed.getQueryParameterNames().isEmpty() ? CollectionsKt.joinToString$default(CollectionsKt.sorted(parsed.getQueryParameterNames()), "&", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.MovieBox.MovieBoxProvider$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                String str = (String) obj;
                return CollectionsKt.joinToString$default(parsed.getQueryParameters(str), "&", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.MovieBox.MovieBoxProvider$$ExternalSyntheticLambda7
                    public final Object invoke(Object obj2) {
                        return MovieBoxProvider.buildCanonicalString$lambda$0$0(str, (String) obj2);
                    }
                }, 30, (Object) null);
            }
        }, 30, (Object) null) : "";
        String canonicalUrl = query.length() > 0 ? path + '?' + query : path;
        if (body != null) {
            bodyBytes = body.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bodyBytes, "getBytes(...)");
        } else {
            bodyBytes = null;
        }
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence buildCanonicalString$lambda$0$0(String $key, String value) {
        return $key + '=' + value;
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

    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    /* JADX WARN: Code duplicated, block: B:127:0x0746  */
    /* JADX WARN: Code duplicated, block: B:130:0x074f A[Catch: Exception -> 0x0778, TryCatch #3 {Exception -> 0x0778, blocks: (B:102:0x06db, B:130:0x074f, B:105:0x06e3, B:107:0x06ed, B:110:0x06f4, B:112:0x06fc, B:114:0x0704, B:116:0x070a, B:118:0x0712, B:120:0x0718, B:121:0x071b, B:125:0x072a, B:122:0x071e, B:123:0x0723, B:133:0x0766), top: B:154:0x06db }] */
    /* JADX WARN: Code duplicated, block: B:131:0x0756  */
    /* JADX WARN: Code duplicated, block: B:145:0x078e  */
    /* JADX WARN: Code duplicated, block: B:78:0x0660  */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    /* JADX WARN: Code duplicated, block: B:84:0x0670  */
    /* JADX WARN: Code duplicated, block: B:87:0x0678 A[Catch: Exception -> 0x066b, TRY_ENTER, TryCatch #1 {Exception -> 0x066b, blocks: (B:79:0x0662, B:87:0x0678, B:90:0x0682), top: B:150:0x0662 }] */
    /* JADX WARN: Code duplicated, block: B:88:0x067f  */
    /* JADX WARN: Code duplicated, block: B:90:0x0682 A[Catch: Exception -> 0x066b, TRY_LEAVE, TryCatch #1 {Exception -> 0x066b, blocks: (B:79:0x0662, B:87:0x0678, B:90:0x0682), top: B:150:0x0662 }] */
    /* JADX WARN: Code duplicated, block: B:92:0x068d  */
    /* JADX WARN: Code duplicated, block: B:96:0x06ad A[Catch: Exception -> 0x077a, TryCatch #2 {Exception -> 0x077a, blocks: (B:93:0x068e, B:94:0x06a7, B:96:0x06ad, B:98:0x06cb, B:85:0x0672), top: B:152:0x0672 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x06cb A[Catch: Exception -> 0x077a, TryCatch #2 {Exception -> 0x077a, blocks: (B:93:0x068e, B:94:0x06a7, B:96:0x06ad, B:98:0x06cb, B:85:0x0672), top: B:152:0x0672 }] */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        C00011 c00011;
        String str;
        String url;
        Object obj;
        MainPageRequest request2;
        int perPage;
        int pg;
        String jsonBody;
        String xClientToken;
        Map getheaders;
        Map headers;
        String xTrSignature;
        int perPage2;
        RequestBody requestBody;
        String url2;
        MainPageRequest request3;
        int pg2;
        Integer intOrNull;
        NiceResponse response;
        int perPage3;
        int perPage4;
        MainPageRequest request4;
        MainPageRequest request5;
        List listEmptyList;
        JsonNode root;
        JsonNode jsonNode;
        JsonNode jsonNode2;
        JsonNode jsonNode3;
        JsonNode items;
        Iterable $this$mapNotNull$iv;
        int $i$f$mapNotNull;
        Collection destination$iv$iv;
        JsonNode jsonNode4;
        JsonNode items2;
        int $i$f$mapNotNull2;
        int perPage5;
        MovieSearchResponse movieSearchResponseNewMovieSearchResponse$default;
        Collection destination$iv$iv2;
        String strAsText;
        String id;
        TvType type;
        JsonNode jsonNode5;
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
                String url3 = (StringsKt.contains$default(request.getData(), "|", false, 2, (Object) null) ? new StringBuilder().append(getMainUrl()).append("/wefeed-mobile-bff/subject-api/list") : new StringBuilder().append(getMainUrl()).append("/wefeed-mobile-bff/tab/ranking-list?tabId=0&categoryType=").append(request.getData()).append("&page=").append(page).append("&perPage=").append(15)).toString();
                String data1 = request.getData();
                List mainParts = StringsKt.split$default(StringsKt.substringBefore$default(data1, ";", (String) null, 2, (Object) null), new String[]{"|"}, false, 0, 6, (Object) null);
                String str2 = (String) CollectionsKt.getOrNull(mainParts, 0);
                int pg3 = (str2 == null || (intOrNull = StringsKt.toIntOrNull(str2)) == null) ? 1 : intOrNull.intValue();
                String channelId = (String) CollectionsKt.getOrNull(mainParts, 1);
                Map options = new LinkedHashMap();
                Iterable $this$forEach$iv = StringsKt.split$default(StringsKt.substringAfter(data1, ";", ""), new String[]{";"}, false, 0, 6, (Object) null);
                for (Object element$iv : $this$forEach$iv) {
                    String it = (String) element$iv;
                    Object obj2 = coroutine_suspended;
                    List p = StringsKt.split$default(it, new String[]{"="}, false, 0, 6, (Object) null);
                    String data2 = data1;
                    String url4 = url3;
                    Iterable $this$forEach$iv2 = $this$forEach$iv;
                    Pair pair = TuplesKt.to(CollectionsKt.getOrNull(p, 0), CollectionsKt.getOrNull(p, 1));
                    String k = (String) pair.component1();
                    String v = (String) pair.component2();
                    String str3 = k;
                    if (!(str3 == null || StringsKt.isBlank(str3))) {
                        String str4 = v;
                        if (!(str4 == null || StringsKt.isBlank(str4))) {
                            options.put(k, v);
                        }
                    }
                    url3 = url4;
                    data1 = data2;
                    $this$forEach$iv = $this$forEach$iv2;
                    coroutine_suspended = obj2;
                }
                Object obj3 = coroutine_suspended;
                String data3 = data1;
                String url5 = url3;
                String classify = (String) options.get("classify");
                if (classify == null) {
                    classify = "All";
                }
                String country = (String) options.get("country");
                if (country == null) {
                    country = "All";
                }
                String year = (String) options.get("year");
                if (year == null) {
                    year = "All";
                }
                String str5 = (String) options.get("genre");
                String genre = str5 != null ? str5 : "All";
                String sort = (String) options.get("sort");
                if (sort == null) {
                    sort = "ForYou";
                }
                String jsonBody2 = "{\"page\":" + pg3 + ",\"perPage\":15,\"channelId\":\"" + channelId + "\",\"classify\":\"" + classify + "\",\"country\":\"" + country + "\",\"year\":\"" + year + "\",\"genre\":\"" + genre + "\",\"sort\":\"" + sort + "\"}";
                String classify2 = classify;
                String sort2 = sort;
                String xClientToken2 = generateXClientToken$default(this, null, 1, null);
                String year2 = year;
                int pg4 = pg3;
                String genre2 = genre;
                String country2 = country;
                String xTrSignature2 = generateXTrSignature$default(this, "POST", "application/json", "application/json; charset=utf-8", url5, jsonBody2, false, null, 96, null);
                str = "data";
                String getxTrSignature = generateXTrSignature$default(this, "GET", "application/json", "application/json", url5, null, false, null, 112, null);
                Map headers2 = MapsKt.mapOf(new Pair[]{TuplesKt.to("user-agent", "com.community.mbox.in/50020042 (Linux; U; Android 16; en_IN; sdk_gphone64_x86_64; Build/BP22.250325.006; Cronet/133.0.6876.3)"), TuplesKt.to("accept", "application/json"), TuplesKt.to("content-type", "application/json"), TuplesKt.to("connection", "keep-alive"), TuplesKt.to("x-client-token", xClientToken2), TuplesKt.to("x-tr-signature", xTrSignature2), TuplesKt.to("x-client-info", "{\"package_name\":\"com.community.mbox.in\",\"version_name\":\"3.0.03.0529.03\",\"version_code\":50020042,\"os\":\"android\",\"os_version\":\"16\",\"device_id\":\"" + this.deviceId + "\",\"install_store\":\"ps\",\"gaid\":\"d7578036d13336cc\",\"brand\":\"google\",\"model\":\"" + randomBrandModel() + "\",\"system_language\":\"en\",\"net\":\"NETWORK_WIFI\",\"region\":\"IN\",\"timezone\":\"Asia/Calcutta\",\"sp_code\":\"\"}"), TuplesKt.to("x-client-status", "0"), TuplesKt.to("x-play-mode", "2")});
                Map getheaders2 = MapsKt.mapOf(new Pair[]{TuplesKt.to("user-agent", "com.community.mbox.in/50020042 (Linux; U; Android 16; en_IN; sdk_gphone64_x86_64; Build/BP22.250325.006; Cronet/133.0.6876.3)"), TuplesKt.to("accept", "application/json"), TuplesKt.to("content-type", "application/json"), TuplesKt.to("connection", "keep-alive"), TuplesKt.to("x-client-token", xClientToken2), TuplesKt.to("x-tr-signature", getxTrSignature), TuplesKt.to("x-client-info", "{\"package_name\":\"com.community.mbox.in\",\"version_name\":\"3.0.03.0529.03\",\"version_code\":50020042,\"os\":\"android\",\"os_version\":\"16\",\"device_id\":\"" + this.deviceId + "\",\"install_store\":\"ps\",\"gaid\":\"d7578036d13336cc\",\"brand\":\"google\",\"model\":\"sdk_gphone64_x86_64\",\"system_language\":\"en\",\"net\":\"NETWORK_WIFI\",\"region\":\"IN\",\"timezone\":\"Asia/Calcutta\",\"sp_code\":\"\"}"), TuplesKt.to("x-client-status", "0")});
                RequestBody requestBody2 = RequestBody.Companion.create(jsonBody2, MediaType.Companion.get("application/json"));
                if (!StringsKt.contains$default(request.getData(), "|", false, 2, (Object) null)) {
                    url = url5;
                    Requests app = MainActivityKt.getApp();
                    c00012.L$0 = request;
                    c00012.L$1 = SpillingKt.nullOutSpilledVariable(url);
                    c00012.L$2 = SpillingKt.nullOutSpilledVariable(data3);
                    c00012.L$3 = SpillingKt.nullOutSpilledVariable(mainParts);
                    c00012.L$4 = SpillingKt.nullOutSpilledVariable(channelId);
                    c00012.L$5 = SpillingKt.nullOutSpilledVariable(options);
                    c00012.L$6 = SpillingKt.nullOutSpilledVariable(classify2);
                    c00012.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                    c00012.L$8 = SpillingKt.nullOutSpilledVariable(year2);
                    c00012.L$9 = SpillingKt.nullOutSpilledVariable(genre2);
                    c00012.L$10 = SpillingKt.nullOutSpilledVariable(sort2);
                    c00012.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody2);
                    c00012.L$12 = SpillingKt.nullOutSpilledVariable(xClientToken2);
                    c00012.L$13 = SpillingKt.nullOutSpilledVariable(xTrSignature2);
                    c00012.L$14 = SpillingKt.nullOutSpilledVariable(getxTrSignature);
                    c00012.L$15 = SpillingKt.nullOutSpilledVariable(headers2);
                    c00012.L$16 = SpillingKt.nullOutSpilledVariable(getheaders2);
                    c00012.L$17 = SpillingKt.nullOutSpilledVariable(requestBody2);
                    c00012.I$0 = page;
                    c00012.I$1 = 15;
                    c00012.I$2 = pg4;
                    c00012.label = 2;
                    Object obj4 = Requests.get$default(app, url, getheaders2, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00012, 4092, (Object) null);
                    if (obj4 == obj3) {
                        return obj3;
                    }
                    obj = obj4;
                    request2 = request;
                    perPage = 15;
                    pg = pg4;
                    jsonBody = jsonBody2;
                    xClientToken = xClientToken2;
                    getheaders = getheaders2;
                    headers = headers2;
                    xTrSignature = xTrSignature2;
                    response = (NiceResponse) obj;
                    perPage3 = perPage;
                    perPage4 = pg;
                    request4 = request2;
                    String responseBody = response.getText();
                    ObjectMapper mapper = ExtensionsKt.jacksonObjectMapper();
                    String str6 = str;
                    root = mapper.readTree(responseBody);
                    request5 = request4;
                    jsonNode = root.get(str6);
                    if (jsonNode != null) {
                        items = jsonNode.get("items");
                        if (items == null) {
                        }
                        $this$mapNotNull$iv = (Iterable) items;
                        $i$f$mapNotNull = 0;
                        Collection destination$iv$iv3 = new ArrayList();
                        destination$iv$iv = destination$iv$iv3;
                        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                            final JsonNode item = (JsonNode) element$iv$iv$iv;
                            JsonNode root2 = root;
                            Iterable $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                            jsonNode4 = item.get("title");
                            if (jsonNode4 != null) {
                                items2 = items;
                                $i$f$mapNotNull2 = $i$f$mapNotNull;
                                perPage5 = perPage3;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            } else {
                                items2 = items;
                                $i$f$mapNotNull2 = $i$f$mapNotNull;
                                perPage5 = perPage3;
                                movieSearchResponseNewMovieSearchResponse$default = null;
                            }
                            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                destination$iv$iv2 = destination$iv$iv;
                                destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                            } else {
                                destination$iv$iv2 = destination$iv$iv;
                            }
                            destination$iv$iv = destination$iv$iv2;
                            items = items2;
                            root = root2;
                            $this$mapNotNull$iv = $this$mapNotNull$iv2;
                            $i$f$mapNotNull = $i$f$mapNotNull2;
                            perPage3 = perPage5;
                            break;
                        }
                        listEmptyList = (List) destination$iv$iv;
                        if (listEmptyList == null) {
                            listEmptyList = CollectionsKt.emptyList();
                        }
                        List data = listEmptyList;
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                    }
                    jsonNode2 = root.get(str6);
                    if (jsonNode2 != null) {
                        jsonNode3 = jsonNode2.get("subjects");
                    } else {
                        jsonNode3 = null;
                    }
                    if (jsonNode3 == null) {
                        return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), (Boolean) null, 2, (Object) null);
                    }
                    items = jsonNode3;
                    $this$mapNotNull$iv = (Iterable) items;
                    $i$f$mapNotNull = 0;
                    Collection destination$iv$iv4 = new ArrayList();
                    destination$iv$iv = destination$iv$iv4;
                    while (r26.hasNext()) {
                        final JsonNode item2 = (JsonNode) element$iv$iv$iv;
                        JsonNode root3 = root;
                        Iterable $this$mapNotNull$iv3 = $this$mapNotNull$iv;
                        jsonNode4 = item2.get("title");
                        if (jsonNode4 != null) {
                            items2 = items;
                            $i$f$mapNotNull2 = $i$f$mapNotNull;
                            perPage5 = perPage3;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            items2 = items;
                            $i$f$mapNotNull2 = $i$f$mapNotNull;
                            perPage5 = perPage3;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        }
                        if (movieSearchResponseNewMovieSearchResponse$default != null) {
                            destination$iv$iv2 = destination$iv$iv;
                            destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                        } else {
                            destination$iv$iv2 = destination$iv$iv;
                        }
                        destination$iv$iv = destination$iv$iv2;
                        items = items2;
                        root = root3;
                        $this$mapNotNull$iv = $this$mapNotNull$iv3;
                        $i$f$mapNotNull = $i$f$mapNotNull2;
                        perPage3 = perPage5;
                        break;
                    }
                    listEmptyList = (List) destination$iv$iv;
                    if (listEmptyList == null) {
                        listEmptyList = CollectionsKt.emptyList();
                    }
                    List data4 = listEmptyList;
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data4, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                }
                Requests app2 = MainActivityKt.getApp();
                c00012.L$0 = request;
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(url5);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(data3);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(mainParts);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(channelId);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(options);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(classify2);
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(country2);
                c00012.L$8 = SpillingKt.nullOutSpilledVariable(year2);
                c00012.L$9 = SpillingKt.nullOutSpilledVariable(genre2);
                c00012.L$10 = SpillingKt.nullOutSpilledVariable(sort2);
                c00012.L$11 = SpillingKt.nullOutSpilledVariable(jsonBody2);
                c00012.L$12 = SpillingKt.nullOutSpilledVariable(xClientToken2);
                c00012.L$13 = SpillingKt.nullOutSpilledVariable(xTrSignature2);
                c00012.L$14 = SpillingKt.nullOutSpilledVariable(getxTrSignature);
                c00012.L$15 = SpillingKt.nullOutSpilledVariable(headers2);
                c00012.L$16 = SpillingKt.nullOutSpilledVariable(getheaders2);
                c00012.L$17 = SpillingKt.nullOutSpilledVariable(requestBody2);
                c00012.I$0 = page;
                c00012.I$1 = 15;
                c00012.I$2 = pg4;
                c00012.label = 1;
                Object objPost$default = Requests.post$default(app2, url5, headers2, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody2, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00012, 65276, (Object) null);
                if (objPost$default == obj3) {
                    c00012 = c00012;
                    return obj3;
                }
                c00012 = c00012;
                perPage2 = 15;
                requestBody = requestBody2;
                url2 = url5;
                $result = objPost$default;
                request3 = request;
                pg2 = pg4;
                response = (NiceResponse) $result;
                perPage3 = perPage2;
                perPage4 = pg2;
                request4 = request3;
                String responseBody2 = response.getText();
                try {
                    ObjectMapper mapper2 = ExtensionsKt.jacksonObjectMapper();
                    String str7 = str;
                    root = mapper2.readTree(responseBody2);
                    request5 = request4;
                    try {
                        jsonNode = root.get(str7);
                        try {
                            if (jsonNode != null) {
                                try {
                                    items = jsonNode.get("items");
                                    if (items == null) {
                                    }
                                    $this$mapNotNull$iv = (Iterable) items;
                                    $i$f$mapNotNull = 0;
                                    Collection destination$iv$iv5 = new ArrayList();
                                    destination$iv$iv = destination$iv$iv5;
                                    while (r26.hasNext()) {
                                        final JsonNode item3 = (JsonNode) element$iv$iv$iv;
                                        JsonNode root4 = root;
                                        Iterable $this$mapNotNull$iv4 = $this$mapNotNull$iv;
                                        jsonNode4 = item3.get("title");
                                        if (jsonNode4 != null || (strAsText = jsonNode4.asText()) == null) {
                                            items2 = items;
                                            $i$f$mapNotNull2 = $i$f$mapNotNull;
                                            perPage5 = perPage3;
                                        } else {
                                            items2 = items;
                                            $i$f$mapNotNull2 = $i$f$mapNotNull;
                                            perPage5 = perPage3;
                                            try {
                                                String title = StringsKt.substringBefore$default(strAsText, "[", (String) null, 2, (Object) null);
                                                if (title != null) {
                                                    JsonNode jsonNode6 = item3.get("subjectId");
                                                    if (jsonNode6 == null || (id = jsonNode6.asText()) == null) {
                                                        movieSearchResponseNewMovieSearchResponse$default = null;
                                                    } else {
                                                        JsonNode jsonNode7 = item3.get("cover");
                                                        final String coverImg = (jsonNode7 == null || (jsonNode5 = jsonNode7.get("url")) == null) ? null : jsonNode5.asText();
                                                        JsonNode jsonNode8 = item3.get("subjectType");
                                                        int subjectType = jsonNode8 != null ? jsonNode8.asInt() : 1;
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
                                                            public final Object invoke(Object obj5) {
                                                                return MovieBoxProvider.getMainPage$lambda$1$0(coverImg, item3, (MovieSearchResponse) obj5);
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
                                                items = items2;
                                                root = root4;
                                                $this$mapNotNull$iv = $this$mapNotNull$iv4;
                                                $i$f$mapNotNull = $i$f$mapNotNull2;
                                                perPage3 = perPage5;
                                            } catch (Exception e) {
                                                listEmptyList = null;
                                                if (listEmptyList == null) {
                                                    listEmptyList = CollectionsKt.emptyList();
                                                }
                                                List data5 = listEmptyList;
                                                return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data5, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
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
                                        items = items2;
                                        root = root4;
                                        $this$mapNotNull$iv = $this$mapNotNull$iv4;
                                        $i$f$mapNotNull = $i$f$mapNotNull2;
                                        perPage3 = perPage5;
                                        break;
                                    }
                                    listEmptyList = (List) destination$iv$iv;
                                    break;
                                } catch (Exception e2) {
                                    listEmptyList = null;
                                    if (listEmptyList == null) {
                                        listEmptyList = CollectionsKt.emptyList();
                                    }
                                    List data6 = listEmptyList;
                                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data6, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                                }
                                if (listEmptyList == null) {
                                    listEmptyList = CollectionsKt.emptyList();
                                }
                                List data7 = listEmptyList;
                                return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data7, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                            }
                            jsonNode2 = root.get(str7);
                            if (jsonNode2 != null) {
                                jsonNode3 = jsonNode2.get("subjects");
                            } else {
                                jsonNode3 = null;
                            }
                            if (jsonNode3 == null) {
                                return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), (Boolean) null, 2, (Object) null);
                            }
                            items = jsonNode3;
                            $this$mapNotNull$iv = (Iterable) items;
                            $i$f$mapNotNull = 0;
                            Collection destination$iv$iv6 = new ArrayList();
                            destination$iv$iv = destination$iv$iv6;
                            while (r26.hasNext()) {
                                final JsonNode item4 = (JsonNode) element$iv$iv$iv;
                                JsonNode root5 = root;
                                Iterable $this$mapNotNull$iv5 = $this$mapNotNull$iv;
                                jsonNode4 = item4.get("title");
                                if (jsonNode4 != null) {
                                    items2 = items;
                                    $i$f$mapNotNull2 = $i$f$mapNotNull;
                                    perPage5 = perPage3;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                } else {
                                    items2 = items;
                                    $i$f$mapNotNull2 = $i$f$mapNotNull;
                                    perPage5 = perPage3;
                                    movieSearchResponseNewMovieSearchResponse$default = null;
                                }
                                if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                    destination$iv$iv2 = destination$iv$iv;
                                    destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                                } else {
                                    destination$iv$iv2 = destination$iv$iv;
                                }
                                destination$iv$iv = destination$iv$iv2;
                                items = items2;
                                root = root5;
                                $this$mapNotNull$iv = $this$mapNotNull$iv5;
                                $i$f$mapNotNull = $i$f$mapNotNull2;
                                perPage3 = perPage5;
                                break;
                            }
                            listEmptyList = (List) destination$iv$iv;
                            if (listEmptyList == null) {
                                listEmptyList = CollectionsKt.emptyList();
                            }
                            List data8 = listEmptyList;
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data8, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                        } catch (Exception e3) {
                            listEmptyList = null;
                            if (listEmptyList == null) {
                                listEmptyList = CollectionsKt.emptyList();
                            }
                            List data9 = listEmptyList;
                            return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data9, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                        }
                    } catch (Exception e4) {
                    }
                } catch (Exception e5) {
                    request5 = request4;
                }
                break;
            case 1:
                pg2 = c00012.I$2;
                perPage2 = c00012.I$1;
                int i = c00012.I$0;
                requestBody = (RequestBody) c00012.L$17;
                url2 = (String) c00012.L$1;
                request3 = (MainPageRequest) c00012.L$0;
                ResultKt.throwOnFailure($result);
                str = "data";
                response = (NiceResponse) $result;
                perPage3 = perPage2;
                perPage4 = pg2;
                request4 = request3;
                String responseBody3 = response.getText();
                ObjectMapper mapper3 = ExtensionsKt.jacksonObjectMapper();
                String str8 = str;
                root = mapper3.readTree(responseBody3);
                request5 = request4;
                jsonNode = root.get(str8);
                if (jsonNode != null) {
                    items = jsonNode.get("items");
                    if (items == null) {
                    }
                    $this$mapNotNull$iv = (Iterable) items;
                    $i$f$mapNotNull = 0;
                    Collection destination$iv$iv7 = new ArrayList();
                    destination$iv$iv = destination$iv$iv7;
                    while (r26.hasNext()) {
                        final JsonNode item5 = (JsonNode) element$iv$iv$iv;
                        JsonNode root6 = root;
                        Iterable $this$mapNotNull$iv6 = $this$mapNotNull$iv;
                        jsonNode4 = item5.get("title");
                        if (jsonNode4 != null) {
                            items2 = items;
                            $i$f$mapNotNull2 = $i$f$mapNotNull;
                            perPage5 = perPage3;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            items2 = items;
                            $i$f$mapNotNull2 = $i$f$mapNotNull;
                            perPage5 = perPage3;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        }
                        if (movieSearchResponseNewMovieSearchResponse$default != null) {
                            destination$iv$iv2 = destination$iv$iv;
                            destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                        } else {
                            destination$iv$iv2 = destination$iv$iv;
                        }
                        destination$iv$iv = destination$iv$iv2;
                        items = items2;
                        root = root6;
                        $this$mapNotNull$iv = $this$mapNotNull$iv6;
                        $i$f$mapNotNull = $i$f$mapNotNull2;
                        perPage3 = perPage5;
                        break;
                    }
                    listEmptyList = (List) destination$iv$iv;
                    if (listEmptyList == null) {
                        listEmptyList = CollectionsKt.emptyList();
                    }
                    List data10 = listEmptyList;
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data10, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                }
                jsonNode2 = root.get(str8);
                if (jsonNode2 != null) {
                    jsonNode3 = jsonNode2.get("subjects");
                } else {
                    jsonNode3 = null;
                }
                if (jsonNode3 == null) {
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), (Boolean) null, 2, (Object) null);
                }
                items = jsonNode3;
                $this$mapNotNull$iv = (Iterable) items;
                $i$f$mapNotNull = 0;
                Collection destination$iv$iv8 = new ArrayList();
                destination$iv$iv = destination$iv$iv8;
                while (r26.hasNext()) {
                    final JsonNode item6 = (JsonNode) element$iv$iv$iv;
                    JsonNode root7 = root;
                    Iterable $this$mapNotNull$iv7 = $this$mapNotNull$iv;
                    jsonNode4 = item6.get("title");
                    if (jsonNode4 != null) {
                        items2 = items;
                        $i$f$mapNotNull2 = $i$f$mapNotNull;
                        perPage5 = perPage3;
                        movieSearchResponseNewMovieSearchResponse$default = null;
                    } else {
                        items2 = items;
                        $i$f$mapNotNull2 = $i$f$mapNotNull;
                        perPage5 = perPage3;
                        movieSearchResponseNewMovieSearchResponse$default = null;
                    }
                    if (movieSearchResponseNewMovieSearchResponse$default != null) {
                        destination$iv$iv2 = destination$iv$iv;
                        destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                    } else {
                        destination$iv$iv2 = destination$iv$iv;
                    }
                    destination$iv$iv = destination$iv$iv2;
                    items = items2;
                    root = root7;
                    $this$mapNotNull$iv = $this$mapNotNull$iv7;
                    $i$f$mapNotNull = $i$f$mapNotNull2;
                    perPage3 = perPage5;
                    break;
                }
                listEmptyList = (List) destination$iv$iv;
                if (listEmptyList == null) {
                    listEmptyList = CollectionsKt.emptyList();
                }
                List data11 = listEmptyList;
                return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data11, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
            case 2:
                pg = c00012.I$2;
                perPage = c00012.I$1;
                int i2 = c00012.I$0;
                getheaders = (Map) c00012.L$16;
                headers = (Map) c00012.L$15;
                xTrSignature = (String) c00012.L$13;
                xClientToken = (String) c00012.L$12;
                jsonBody = (String) c00012.L$11;
                String url6 = (String) c00012.L$1;
                request2 = (MainPageRequest) c00012.L$0;
                ResultKt.throwOnFailure($result);
                str = "data";
                obj = $result;
                url = url6;
                response = (NiceResponse) obj;
                perPage3 = perPage;
                perPage4 = pg;
                request4 = request2;
                String responseBody4 = response.getText();
                ObjectMapper mapper4 = ExtensionsKt.jacksonObjectMapper();
                String str9 = str;
                root = mapper4.readTree(responseBody4);
                request5 = request4;
                jsonNode = root.get(str9);
                if (jsonNode != null) {
                    items = jsonNode.get("items");
                    if (items == null) {
                    }
                    $this$mapNotNull$iv = (Iterable) items;
                    $i$f$mapNotNull = 0;
                    Collection destination$iv$iv9 = new ArrayList();
                    destination$iv$iv = destination$iv$iv9;
                    while (r26.hasNext()) {
                        final JsonNode item7 = (JsonNode) element$iv$iv$iv;
                        JsonNode root8 = root;
                        Iterable $this$mapNotNull$iv8 = $this$mapNotNull$iv;
                        jsonNode4 = item7.get("title");
                        if (jsonNode4 != null) {
                            items2 = items;
                            $i$f$mapNotNull2 = $i$f$mapNotNull;
                            perPage5 = perPage3;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        } else {
                            items2 = items;
                            $i$f$mapNotNull2 = $i$f$mapNotNull;
                            perPage5 = perPage3;
                            movieSearchResponseNewMovieSearchResponse$default = null;
                        }
                        if (movieSearchResponseNewMovieSearchResponse$default != null) {
                            destination$iv$iv2 = destination$iv$iv;
                            destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                        } else {
                            destination$iv$iv2 = destination$iv$iv;
                        }
                        destination$iv$iv = destination$iv$iv2;
                        items = items2;
                        root = root8;
                        $this$mapNotNull$iv = $this$mapNotNull$iv8;
                        $i$f$mapNotNull = $i$f$mapNotNull2;
                        perPage3 = perPage5;
                        break;
                    }
                    listEmptyList = (List) destination$iv$iv;
                    if (listEmptyList == null) {
                        listEmptyList = CollectionsKt.emptyList();
                    }
                    List data12 = listEmptyList;
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data12, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
                }
                jsonNode2 = root.get(str9);
                if (jsonNode2 != null) {
                    jsonNode3 = jsonNode2.get("subjects");
                } else {
                    jsonNode3 = null;
                }
                if (jsonNode3 == null) {
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), (Boolean) null, 2, (Object) null);
                }
                items = jsonNode3;
                $this$mapNotNull$iv = (Iterable) items;
                $i$f$mapNotNull = 0;
                Collection destination$iv$iv10 = new ArrayList();
                destination$iv$iv = destination$iv$iv10;
                while (r26.hasNext()) {
                    final JsonNode item8 = (JsonNode) element$iv$iv$iv;
                    JsonNode root9 = root;
                    Iterable $this$mapNotNull$iv9 = $this$mapNotNull$iv;
                    jsonNode4 = item8.get("title");
                    if (jsonNode4 != null) {
                        items2 = items;
                        $i$f$mapNotNull2 = $i$f$mapNotNull;
                        perPage5 = perPage3;
                        movieSearchResponseNewMovieSearchResponse$default = null;
                    } else {
                        items2 = items;
                        $i$f$mapNotNull2 = $i$f$mapNotNull;
                        perPage5 = perPage3;
                        movieSearchResponseNewMovieSearchResponse$default = null;
                    }
                    if (movieSearchResponseNewMovieSearchResponse$default != null) {
                        destination$iv$iv2 = destination$iv$iv;
                        destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                    } else {
                        destination$iv$iv2 = destination$iv$iv;
                    }
                    destination$iv$iv = destination$iv$iv2;
                    items = items2;
                    root = root9;
                    $this$mapNotNull$iv = $this$mapNotNull$iv9;
                    $i$f$mapNotNull = $i$f$mapNotNull2;
                    perPage3 = perPage5;
                    break;
                }
                listEmptyList = (List) destination$iv$iv;
                if (listEmptyList == null) {
                    listEmptyList = CollectionsKt.emptyList();
                }
                List data13 = listEmptyList;
                return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(new HomePageList(request5.getName(), data13, false, 4, (DefaultConstructorMarker) null)), (Boolean) null, 2, (Object) null);
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

    /* JADX WARN: Code duplicated, block: B:20:0x0258 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:21:0x0259  */
    /* JADX WARN: Code duplicated, block: B:24:0x027f  */
    /* JADX WARN: Code duplicated, block: B:26:0x0287  */
    /* JADX WARN: Code duplicated, block: B:27:0x028e  */
    /* JADX WARN: Code duplicated, block: B:30:0x029f  */
    /* JADX WARN: Code duplicated, block: B:36:0x02bd  */
    /* JADX WARN: Code duplicated, block: B:38:0x02d1  */
    /* JADX WARN: Code duplicated, block: B:55:0x0310  */
    /* JADX WARN: Code duplicated, block: B:56:0x0315  */
    /* JADX WARN: Code duplicated, block: B:58:0x0319  */
    /* JADX WARN: Code duplicated, block: B:59:0x031e  */
    /* JADX WARN: Code duplicated, block: B:60:0x0323  */
    /* JADX WARN: Code duplicated, block: B:69:0x0374  */
    /* JADX WARN: Code duplicated, block: B:73:0x02b3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:74:0x02af A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:79:0x035a A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object search(@NotNull String query, int page, @NotNull Continuation<? super SearchResponseList> continuation) {
        C00071 c00071;
        String url;
        String str;
        StringBuilder sbAppend;
        String str2;
        int i;
        Pair[] pairArr;
        Object obj;
        Pair[] pairArr2;
        String xClientToken;
        String xClientToken2;
        int page2;
        String xTrSignature;
        String xTrSignature2;
        Boolean bool;
        Object $result;
        Object objPost$default;
        int page3;
        JsonNode jsonNode;
        Boolean bool2;
        JsonNode<JsonNode> results;
        JsonNode<JsonNode> subjects;
        JsonNode jsonNode2;
        String title;
        String id;
        Object $result2;
        JsonNode jsonNode3;
        int subjectType;
        TvType tvType;
        if (continuation instanceof C00071) {
            c00071 = (C00071) continuation;
            if ((c00071.label & Integer.MIN_VALUE) != 0) {
                c00071.label -= Integer.MIN_VALUE;
            } else {
                c00071 = new C00071(continuation);
            }
        } else {
            c00071 = new C00071(continuation);
        }
        C00071 c00072 = c00071;
        Object $result3 = c00072.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00072.label) {
            case 0:
                ResultKt.throwOnFailure($result3);
                url = getMainUrl() + "/wefeed-mobile-bff/subject-api/search/v2";
                String jsonBody = "{\"page\": " + page + ", \"perPage\": 20, \"keyword\": \"" + query + "\"}";
                String xClientToken3 = generateXClientToken$default(this, null, 1, null);
                str = "application/json";
                String xTrSignature3 = generateXTrSignature$default(this, "POST", "application/json", "application/json; charset=utf-8", url, jsonBody, false, null, 96, null);
                Pair[] pairArr3 = new Pair[9];
                pairArr3[0] = TuplesKt.to("user-agent", "com.community.mbox.in/50020042 (Linux; U; Android 16; en_IN; sdk_gphone64_x86_64; Build/BP22.250325.006; Cronet/133.0.6876.3)");
                pairArr3[1] = TuplesKt.to("accept", str);
                pairArr3[2] = TuplesKt.to("content-type", str);
                pairArr3[3] = TuplesKt.to("connection", "keep-alive");
                pairArr3[4] = TuplesKt.to("x-client-token", xClientToken3);
                pairArr3[5] = TuplesKt.to("x-tr-signature", xTrSignature3);
                pairArr3[6] = TuplesKt.to("x-client-info", "{\"package_name\":\"com.community.mbox.in\",\"version_name\":\"3.0.03.0529.03\",\"version_code\":50020042,\"os\":\"android\",\"os_version\":\"16\",\"device_id\":\"" + this.deviceId + "\",\"install_store\":\"ps\",\"gaid\":\"d7578036d13336cc\",\"brand\":\"google\",\"model\":\"" + randomBrandModel() + "\",\"system_language\":\"en\",\"net\":\"NETWORK_WIFI\",\"region\":\"IN\",\"timezone\":\"Asia/Calcutta\",\"sp_code\":\"\"}");
                pairArr3[7] = TuplesKt.to("x-client-status", "0");
                sbAppend = new StringBuilder().append("Bearer ");
                c00072.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00072.L$1 = url;
                c00072.L$2 = jsonBody;
                c00072.L$3 = SpillingKt.nullOutSpilledVariable(xClientToken3);
                c00072.L$4 = SpillingKt.nullOutSpilledVariable(xTrSignature3);
                c00072.L$5 = pairArr3;
                c00072.L$6 = pairArr3;
                str2 = "Authorization";
                c00072.L$7 = "Authorization";
                c00072.L$8 = sbAppend;
                c00072.I$0 = page;
                i = 8;
                c00072.I$1 = 8;
                c00072.label = 1;
                Object cachedToken = getCachedToken(c00072);
                if (cachedToken == coroutine_suspended) {
                    return coroutine_suspended;
                }
                pairArr = pairArr3;
                obj = cachedToken;
                pairArr2 = pairArr;
                xClientToken = xClientToken3;
                xClientToken2 = jsonBody;
                page2 = page;
                xTrSignature = xTrSignature3;
                xTrSignature2 = query;
                pairArr2[i] = TuplesKt.to(str2, sbAppend.append((String) obj).toString());
                Map headers = MapsKt.mapOf(pairArr);
                RequestBody requestBody = RequestBody.Companion.create(xClientToken2, MediaType.Companion.get(str));
                Requests app = MainActivityKt.getApp();
                c00072.L$0 = SpillingKt.nullOutSpilledVariable(xTrSignature2);
                c00072.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00072.L$2 = SpillingKt.nullOutSpilledVariable(xClientToken2);
                c00072.L$3 = SpillingKt.nullOutSpilledVariable(xClientToken);
                c00072.L$4 = SpillingKt.nullOutSpilledVariable(xTrSignature);
                c00072.L$5 = SpillingKt.nullOutSpilledVariable(headers);
                c00072.L$6 = SpillingKt.nullOutSpilledVariable(requestBody);
                bool = null;
                c00072.L$7 = null;
                c00072.L$8 = null;
                c00072.I$0 = page2;
                c00072.label = 2;
                $result = $result3;
                objPost$default = Requests.post$default(app, url, headers, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00072, 65276, (Object) null);
                if (objPost$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                page3 = page2;
                NiceResponse response = (NiceResponse) objPost$default;
                persistTokenFromXUser(response.getHeaders().get("x-user"));
                String responseBody = response.getText();
                ObjectMapper mapper = ExtensionsKt.jacksonObjectMapper();
                JsonNode root = mapper.readTree(responseBody);
                jsonNode = root.get("data");
                if (jsonNode != null) {
                    results = jsonNode.get("results");
                    if (results != null) {
                        List searchList = new ArrayList();
                        for (JsonNode result : results) {
                            subjects = result.get("subjects");
                            if (subjects != null) {
                                for (final JsonNode subject : subjects) {
                                    subjects = subjects;
                                    page3 = page3;
                                    jsonNode2 = subject.get("title");
                                    if (jsonNode2 != null || (title = jsonNode2.asText()) == null) {
                                        $result = $result;
                                    } else {
                                        JsonNode jsonNode4 = subject.get("subjectId");
                                        if (jsonNode4 == null || (id = jsonNode4.asText()) == null) {
                                            $result = $result;
                                        } else {
                                            JsonNode jsonNode5 = subject.get("cover");
                                            if (jsonNode5 != null) {
                                                $result2 = $result;
                                                JsonNode jsonNode6 = jsonNode5.get("url");
                                                final String coverImg = jsonNode6 != null ? jsonNode6.asText() : null;
                                                jsonNode3 = subject.get("subjectType");
                                                if (jsonNode3 != null) {
                                                    subjectType = jsonNode3.asInt();
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
                                                    public final Object invoke(Object obj2) {
                                                        return MovieBoxProvider.search$lambda$0(coverImg, subject, (MovieSearchResponse) obj2);
                                                    }
                                                }, 8, (Object) null));
                                                $result = $result2;
                                            } else {
                                                $result2 = $result;
                                            }
                                            jsonNode3 = subject.get("subjectType");
                                            if (jsonNode3 != null) {
                                                subjectType = jsonNode3.asInt();
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
                                                public final Object invoke(Object obj2) {
                                                    return MovieBoxProvider.search$lambda$0(coverImg, subject, (MovieSearchResponse) obj2);
                                                }
                                            }, 8, (Object) null));
                                            $result = $result2;
                                        }
                                    }
                                }
                            }
                        }
                        return MainAPIKt.toNewSearchResponseList$default(searchList, (Boolean) null, 1, (Object) null);
                    }
                    bool2 = null;
                } else {
                    bool2 = bool;
                }
                return MainAPIKt.newSearchResponseList$default(CollectionsKt.emptyList(), bool2, 2, bool2);
            case 1:
                int page4 = c00072.I$1;
                page2 = c00072.I$0;
                sbAppend = (StringBuilder) c00072.L$8;
                str2 = (String) c00072.L$7;
                Pair[] pairArr4 = (Pair[]) c00072.L$6;
                Pair[] pairArr5 = (Pair[]) c00072.L$5;
                xTrSignature = (String) c00072.L$4;
                String xClientToken4 = (String) c00072.L$3;
                String jsonBody2 = (String) c00072.L$2;
                url = (String) c00072.L$1;
                xTrSignature2 = (String) c00072.L$0;
                ResultKt.throwOnFailure($result3);
                str = "application/json";
                pairArr = pairArr5;
                obj = $result3;
                i = page4;
                pairArr2 = pairArr4;
                xClientToken = xClientToken4;
                xClientToken2 = jsonBody2;
                pairArr2[i] = TuplesKt.to(str2, sbAppend.append((String) obj).toString());
                Map headers2 = MapsKt.mapOf(pairArr);
                RequestBody requestBody2 = RequestBody.Companion.create(xClientToken2, MediaType.Companion.get(str));
                Requests app2 = MainActivityKt.getApp();
                c00072.L$0 = SpillingKt.nullOutSpilledVariable(xTrSignature2);
                c00072.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00072.L$2 = SpillingKt.nullOutSpilledVariable(xClientToken2);
                c00072.L$3 = SpillingKt.nullOutSpilledVariable(xClientToken);
                c00072.L$4 = SpillingKt.nullOutSpilledVariable(xTrSignature);
                c00072.L$5 = SpillingKt.nullOutSpilledVariable(headers2);
                c00072.L$6 = SpillingKt.nullOutSpilledVariable(requestBody2);
                bool = null;
                c00072.L$7 = null;
                c00072.L$8 = null;
                c00072.I$0 = page2;
                c00072.label = 2;
                $result = $result3;
                objPost$default = Requests.post$default(app2, url, headers2, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody2, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00072, 65276, (Object) null);
                if (objPost$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                page3 = page2;
                NiceResponse response2 = (NiceResponse) objPost$default;
                persistTokenFromXUser(response2.getHeaders().get("x-user"));
                String responseBody2 = response2.getText();
                ObjectMapper mapper2 = ExtensionsKt.jacksonObjectMapper();
                JsonNode root2 = mapper2.readTree(responseBody2);
                jsonNode = root2.get("data");
                if (jsonNode != null) {
                    results = jsonNode.get("results");
                    if (results != null) {
                        List searchList2 = new ArrayList();
                        while (r16.hasNext()) {
                            subjects = result.get("subjects");
                            if (subjects != null) {
                                while (r17.hasNext()) {
                                    subjects = subjects;
                                    page3 = page3;
                                    jsonNode2 = subject.get("title");
                                    if (jsonNode2 != null) {
                                    }
                                    $result = $result;
                                }
                            }
                        }
                        return MainAPIKt.toNewSearchResponseList$default(searchList2, (Boolean) null, 1, (Object) null);
                    }
                    bool2 = null;
                } else {
                    bool2 = bool;
                }
                return MainAPIKt.newSearchResponseList$default(CollectionsKt.emptyList(), bool2, 2, bool2);
            case 2:
                page3 = c00072.I$0;
                ResultKt.throwOnFailure($result3);
                $result = $result3;
                objPost$default = $result;
                bool = null;
                NiceResponse response3 = (NiceResponse) objPost$default;
                persistTokenFromXUser(response3.getHeaders().get("x-user"));
                String responseBody3 = response3.getText();
                ObjectMapper mapper3 = ExtensionsKt.jacksonObjectMapper();
                JsonNode root3 = mapper3.readTree(responseBody3);
                jsonNode = root3.get("data");
                if (jsonNode != null) {
                    results = jsonNode.get("results");
                    if (results != null) {
                        List searchList3 = new ArrayList();
                        while (r16.hasNext()) {
                            subjects = result.get("subjects");
                            if (subjects != null) {
                                while (r17.hasNext()) {
                                    subjects = subjects;
                                    page3 = page3;
                                    jsonNode2 = subject.get("title");
                                    if (jsonNode2 != null) {
                                    }
                                    $result = $result;
                                }
                            }
                        }
                        return MainAPIKt.toNewSearchResponseList$default(searchList3, (Boolean) null, 1, (Object) null);
                    }
                    bool2 = null;
                } else {
                    bool2 = bool;
                }
                return MainAPIKt.newSearchResponseList$default(CollectionsKt.emptyList(), bool2, 2, bool2);
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

    /* JADX WARN: Code duplicated, block: B:125:0x0a32  */
    /* JADX WARN: Code duplicated, block: B:262:0x0f18  */
    /* JADX WARN: Code duplicated, block: B:264:0x1088 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:265:0x1089  */
    /* JADX WARN: Code duplicated, block: B:268:0x10d4  */
    /* JADX WARN: Code duplicated, block: B:270:0x10e6  */
    /* JADX WARN: Code duplicated, block: B:271:0x10ef  */
    /* JADX WARN: Code duplicated, block: B:273:0x10f4  */
    /* JADX WARN: Code duplicated, block: B:300:0x1196 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:302:0x119d  */
    /* JADX WARN: Code duplicated, block: B:461:0x0a38 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:265:0x1089 -> B:266:0x10c7). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object load(@org.jetbrains.annotations.NotNull java.lang.String r118, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r119) {
        /*
            Method dump skipped, instruction units count: 6062
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.MovieBox.MovieBoxProvider.load(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$7$0$5(String $epName, int $seasonNumber, int $episodeNumber, String $epThumb, String $epDesc, Integer $runtime, String $aired, Episode $this$newEpisode) {
        $this$newEpisode.setName($epName);
        $this$newEpisode.setSeason(Integer.valueOf($seasonNumber));
        $this$newEpisode.setEpisode(Integer.valueOf($episodeNumber));
        $this$newEpisode.setPosterUrl($epThumb);
        $this$newEpisode.setDescription($epDesc);
        $this$newEpisode.setRunTime($runtime);
        MainAPIKt.addDate$default($this$newEpisode, $aired, (String) null, 2, (Object) null);
        return Unit.INSTANCE;
    }

    static final Unit load$lambda$8(String $coverUrl, Episode $this$newEpisode) {
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
    @SourceDebugExtension({"SMAP\nMovieBoxProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MovieBoxProvider.kt\ncom/MovieBox/MovieBoxProvider$load$6\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1211:1\n1#2:1212\n*E\n"})
    static final class C00036 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
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
        C00036(String str, String str2, String str3, String str4, String str5, String str6, String str7, Integer num, List<String> list, List<ActorData> list2, String str8, Integer num2, Integer num3, String str9, Integer num4, Continuation<? super C00036> continuation) {
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
            Continuation<Unit> c00036 = new C00036(this.$coverUrl, this.$Poster, this.$Background, this.$backgroundUrl, this.$logoUrl, this.$Description, this.$description, this.$year, this.$tags, this.$actors, this.$IMDBRating, this.$imdbRating, this.$durationMinutes, this.$imdbId, this.$tmdbId, continuation);
            c00036.L$0 = obj;
            return c00036;
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
    @SourceDebugExtension({"SMAP\nMovieBoxProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MovieBoxProvider.kt\ncom/MovieBox/MovieBoxProvider$load$7\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1211:1\n1#2:1212\n*E\n"})
    static final class C00047 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
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
        C00047(String str, String str2, String str3, String str4, String str5, String str6, String str7, Integer num, List<String> list, List<ActorData> list2, String str8, Integer num2, Integer num3, String str9, Integer num4, Continuation<? super C00047> continuation) {
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
            Continuation<Unit> c00047 = new C00047(this.$coverUrl, this.$Poster, this.$Background, this.$backgroundUrl, this.$logoUrl, this.$Description, this.$description, this.$year, this.$tags, this.$actors, this.$IMDBRating, this.$imdbRating, this.$durationMinutes, this.$imdbId, this.$tmdbId, continuation);
            c00047.L$0 = obj;
            return c00047;
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

    /* JADX WARN: Code duplicated, block: B:100:0x056a A[Catch: Exception -> 0x05f9, TryCatch #13 {Exception -> 0x05f9, blocks: (B:95:0x0542, B:97:0x055c, B:100:0x056a, B:102:0x0570, B:103:0x0574, B:105:0x057a, B:107:0x0590, B:109:0x0596, B:111:0x05a0, B:115:0x05aa, B:117:0x05b0, B:118:0x05bb), top: B:194:0x0542 }] */
    /* JADX WARN: Code duplicated, block: B:125:0x0605  */
    /* JADX WARN: Code duplicated, block: B:129:0x0667 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:130:0x0668  */
    /* JADX WARN: Code duplicated, block: B:135:0x070e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:136:0x070f  */
    /* JADX WARN: Code duplicated, block: B:194:0x0542 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:90:0x0514 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:91:0x0515  */
    /* JADX WARN: Code duplicated, block: B:97:0x055c A[Catch: Exception -> 0x05f9, TryCatch #13 {Exception -> 0x05f9, blocks: (B:95:0x0542, B:97:0x055c, B:100:0x056a, B:102:0x0570, B:103:0x0574, B:105:0x057a, B:107:0x0590, B:109:0x0596, B:111:0x05a0, B:115:0x05aa, B:117:0x05b0, B:118:0x05bb), top: B:194:0x0542 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x0565  */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 11 */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00051 c00051;
        boolean z;
        String originalSubjectId;
        Object $result;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        boolean isCasting2;
        Object cachedToken;
        String originalSubjectId2;
        Object obj;
        Object subjectXClientToken;
        Pair[] pairArr;
        String model;
        String brand;
        List parts;
        String subjectXTrSignature;
        int i;
        String str;
        String subjectXClientToken2;
        String subjectUrl;
        StringBuilder sb;
        int episode;
        int season;
        Pair[] pairArr2;
        Integer intOrNull;
        Integer intOrNull2;
        List groupValues;
        Map subjectHeaders;
        String originalSubjectId3;
        Object obj2;
        boolean isCasting3;
        boolean z2;
        Object obj3;
        C00051 c00052;
        String data2;
        String originalSubjectId4;
        String subjectXTrSignature2;
        int season2;
        Function1<? super ExtractorLink, Unit> function5;
        String subjectUrl2;
        Function1<? super SubtitleFile, Unit> function6;
        boolean isCasting4;
        String originalSubjectId5;
        Object originalSubjectId6;
        NiceResponse subjectResponse;
        ObjectMapper mapper;
        List subjectIds;
        Object subjectXClientToken3;
        String subjectUrl3;
        ObjectMapper mapper2;
        String subjectXTrSignature3;
        JsonNode subjectData;
        JsonNode<JsonNode> dubs;
        String subjectXTrSignature4;
        List subjectIds2;
        Map subjectHeaders2;
        Object cachedToken2;
        NiceResponse subjectResponse2;
        Map subjectHeaders3;
        String subjectUrl4;
        String brand2;
        ObjectMapper mapper3;
        String originalLanguageName;
        boolean isCasting5;
        Function1<? super SubtitleFile, Unit> function7;
        List subjectIds3;
        String model2;
        Function1<? super ExtractorLink, Unit> function8;
        int episode2;
        Object obj4;
        Object $result2;
        Object obj5;
        List subjectIds4;
        C00062 c00062;
        Function1<? super ExtractorLink, Unit> function9;
        Function1<? super SubtitleFile, Unit> function10;
        String model3;
        if (continuation instanceof C00051) {
            c00051 = (C00051) continuation;
            if ((c00051.label & Integer.MIN_VALUE) != 0) {
                c00051.label -= Integer.MIN_VALUE;
            } else {
                c00051 = new C00051(continuation);
            }
        } else {
            c00051 = new C00051(continuation);
        }
        C00051 c00053 = c00051;
        Object $result3 = c00053.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00053.label) {
            case 0:
                ResultKt.throwOnFailure($result3);
                BrandModel brandModelRandomBrandModel = randomBrandModel();
                String brand3 = brandModelRandomBrandModel.getBrand();
                String model4 = brandModelRandomBrandModel.getModel();
                try {
                    List parts2 = StringsKt.split$default(data, new String[]{"|"}, false, 0, 6, (Object) null);
                    try {
                        if (StringsKt.contains$default((CharSequence) parts2.get(0), "get?subjectId", false, 2, (Object) null)) {
                            MatchResult matchResultFind$default = Regex.find$default(new Regex("subjectId=([^&]+)"), (CharSequence) parts2.get(0), 0, 2, (Object) null);
                            if (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null || (originalSubjectId = (String) groupValues.get(1)) == null) {
                                originalSubjectId = StringsKt.substringAfterLast$default((String) parts2.get(0), '/', (String) null, 2, (Object) null);
                            }
                        } else {
                            originalSubjectId = StringsKt.contains$default((CharSequence) parts2.get(0), "/", false, 2, (Object) null) ? StringsKt.substringAfterLast$default((String) parts2.get(0), '/', (String) null, 2, (Object) null) : (String) parts2.get(0);
                        }
                        int season3 = (parts2.size() <= 1 || (intOrNull2 = StringsKt.toIntOrNull((String) parts2.get(1))) == null) ? 0 : intOrNull2.intValue();
                        int episode3 = (parts2.size() > 2 && (intOrNull = StringsKt.toIntOrNull((String) parts2.get(2))) != null) ? intOrNull.intValue() : 0;
                        String subjectUrl5 = getMainUrl() + "/wefeed-mobile-bff/subject-api/get?subjectId=" + originalSubjectId;
                        Object subjectXClientToken4 = generateXClientToken$default(this, null, 1, null);
                        String originalSubjectId7 = originalSubjectId;
                        int season4 = season3;
                        int episode4 = episode3;
                        $result = $result3;
                        try {
                            String subjectXTrSignature5 = generateXTrSignature$default(this, "GET", "application/json", "application/json", subjectUrl5, null, false, null, 112, null);
                            Pair[] pairArr3 = new Pair[9];
                            pairArr3[0] = TuplesKt.to("user-agent", "com.community.oneroom/50020088 (Linux; U; Android 13; en_US; " + brand3 + "; Build/TQ3A.230901.001; Cronet/145.0.7582.0)");
                            pairArr3[1] = TuplesKt.to("accept", "application/json");
                            pairArr3[2] = TuplesKt.to("content-type", "application/json");
                            pairArr3[3] = TuplesKt.to("connection", "keep-alive");
                            pairArr3[4] = TuplesKt.to("x-client-token", subjectXClientToken4);
                            pairArr3[5] = TuplesKt.to("x-tr-signature", subjectXTrSignature5);
                            pairArr3[6] = TuplesKt.to("x-client-info", StringsKt.trimIndent("{\"package_name\":\"com.community.oneroom\",\"version_name\":\"3.0.13.0325.03\",\"version_code\":50020088,\"os\":\"android\",\"os_version\":\"13\",\"install_ch\":\"ps\",\"device_id\":\"" + this.deviceId + "\",\"install_store\":\"ps\",\"gaid\":\"1b2212c1-dadf-43c3-a0c8-bd6ce48ae22d\",\"brand\":\"" + model4 + "\",\"model\":\"" + brand3 + "\",\"system_language\":\"en\",\"net\":\"NETWORK_WIFI\",\"region\":\"US\",\"timezone\":\"Asia/Calcutta\",\"sp_code\":\"\",\"X-Play-Mode\":\"1\",\"X-Idle-Data\":\"1\",\"X-Family-Mode\":\"0\",\"X-Content-Mode\":\"0\"}"));
                            pairArr3[7] = TuplesKt.to("x-client-status", "0");
                            StringBuilder sbAppend = new StringBuilder().append("Bearer ");
                            c00053.L$0 = SpillingKt.nullOutSpilledVariable(data);
                            function3 = function1;
                            try {
                                c00053.L$1 = function3;
                                function4 = function2;
                                try {
                                    c00053.L$2 = function4;
                                    c00053.L$3 = brand3;
                                    c00053.L$4 = model4;
                                    c00053.L$5 = SpillingKt.nullOutSpilledVariable(parts2);
                                    c00053.L$6 = originalSubjectId7;
                                    c00053.L$7 = subjectUrl5;
                                    c00053.L$8 = SpillingKt.nullOutSpilledVariable(subjectXClientToken4);
                                    c00053.L$9 = SpillingKt.nullOutSpilledVariable(subjectXTrSignature5);
                                    c00053.L$10 = pairArr3;
                                    c00053.L$11 = pairArr3;
                                    c00053.L$12 = "Authorization";
                                    c00053.L$13 = sbAppend;
                                    isCasting2 = isCasting;
                                    try {
                                        c00053.Z$0 = isCasting2;
                                        c00053.I$0 = season4;
                                        c00053.I$1 = episode4;
                                        c00053.I$2 = 8;
                                        c00053.label = 1;
                                        cachedToken = getCachedToken(c00053);
                                        if (cachedToken == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        originalSubjectId2 = data;
                                        obj = coroutine_suspended;
                                        subjectXClientToken = subjectXClientToken4;
                                        pairArr = pairArr3;
                                        model = model4;
                                        brand = brand3;
                                        parts = parts2;
                                        subjectXTrSignature = subjectXTrSignature5;
                                        i = 8;
                                        str = "Authorization";
                                        subjectXClientToken2 = originalSubjectId7;
                                        subjectUrl = subjectUrl5;
                                        sb = sbAppend;
                                        episode = episode4;
                                        season = season4;
                                        pairArr2 = pairArr;
                                        try {
                                            pairArr2[i] = TuplesKt.to(str, sb.append((String) cachedToken).toString());
                                            subjectHeaders = MapsKt.mapOf(pairArr);
                                            Requests app = MainActivityKt.getApp();
                                            c00053.L$0 = SpillingKt.nullOutSpilledVariable(originalSubjectId2);
                                            c00053.L$1 = function3;
                                            c00053.L$2 = function4;
                                            c00053.L$3 = brand;
                                            c00053.L$4 = model;
                                            c00053.L$5 = SpillingKt.nullOutSpilledVariable(parts);
                                            c00053.L$6 = subjectXClientToken2;
                                            c00053.L$7 = SpillingKt.nullOutSpilledVariable(subjectUrl);
                                            c00053.L$8 = SpillingKt.nullOutSpilledVariable(subjectXClientToken);
                                            c00053.L$9 = SpillingKt.nullOutSpilledVariable(subjectXTrSignature);
                                            c00053.L$10 = SpillingKt.nullOutSpilledVariable(subjectHeaders);
                                            c00053.L$11 = null;
                                            c00053.L$12 = null;
                                            c00053.L$13 = null;
                                            c00053.Z$0 = isCasting2;
                                            c00053.I$0 = season;
                                            c00053.I$1 = episode;
                                            c00053.label = 2;
                                            originalSubjectId3 = subjectXClientToken2;
                                            obj2 = obj;
                                            isCasting3 = isCasting2;
                                            z2 = true;
                                            try {
                                                obj3 = Requests.get$default(app, subjectUrl, subjectHeaders, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00053, 4092, (Object) null);
                                                c00052 = c00053;
                                                if (obj3 == obj2) {
                                                    return obj2;
                                                }
                                                data2 = originalSubjectId2;
                                                originalSubjectId4 = model;
                                                subjectXTrSignature2 = brand;
                                                season2 = season;
                                                function5 = function4;
                                                subjectUrl2 = subjectUrl;
                                                function6 = function3;
                                                $result3 = obj3;
                                                isCasting4 = isCasting3;
                                                originalSubjectId5 = originalSubjectId3;
                                                originalSubjectId6 = subjectXClientToken;
                                                try {
                                                    subjectResponse = (NiceResponse) $result3;
                                                    mapper = ExtensionsKt.jacksonObjectMapper();
                                                    subjectIds = new ArrayList();
                                                    String originalLanguageName2 = "Original";
                                                    subjectXClientToken3 = originalSubjectId6;
                                                    subjectUrl3 = subjectUrl2;
                                                    if (subjectResponse.getCode() == 200) {
                                                        try {
                                                            String subjectResponseBody = subjectResponse.getText();
                                                            mapper2 = mapper;
                                                            JsonNode subjectRoot = mapper2.readTree(subjectResponseBody);
                                                            subjectXTrSignature3 = subjectXTrSignature;
                                                            subjectData = subjectRoot.get("data");
                                                            if (subjectData != null) {
                                                                dubs = subjectData.get("dubs");
                                                            } else {
                                                                dubs = null;
                                                            }
                                                            if (dubs == null && dubs.isArray()) {
                                                                for (JsonNode dub : dubs) {
                                                                    subjectData = subjectData;
                                                                    dubs = dubs;
                                                                    JsonNode jsonNode = dub.get("subjectId");
                                                                    String dubSubjectId = jsonNode != null ? jsonNode.asText() : null;
                                                                    subjectResponse = subjectResponse;
                                                                    JsonNode jsonNode2 = dub.get("lanName");
                                                                    String lanName = jsonNode2 != null ? jsonNode2.asText() : null;
                                                                    if (dubSubjectId == null || lanName == null) {
                                                                        subjectIds = subjectIds;
                                                                    } else {
                                                                        if (Intrinsics.areEqual(dubSubjectId, originalSubjectId5)) {
                                                                            originalLanguageName2 = lanName;
                                                                            Unit unit = Unit.INSTANCE;
                                                                            subjectIds2 = subjectIds;
                                                                        } else {
                                                                            Pair pair = new Pair(dubSubjectId, lanName);
                                                                            subjectIds2 = subjectIds;
                                                                            Boxing.boxBoolean(subjectIds2.add(pair));
                                                                        }
                                                                        subjectIds = subjectIds2;
                                                                    }
                                                                    break;
                                                                }
                                                                subjectResponse = subjectResponse;
                                                                subjectIds = subjectIds;
                                                                subjectXTrSignature4 = originalLanguageName2;
                                                            }
                                                            subjectHeaders2 = subjectHeaders;
                                                            persistTokenFromXUser(subjectResponse.getHeaders().get("x-user"));
                                                            c00052.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                                            c00052.L$1 = function6;
                                                            c00052.L$2 = function5;
                                                            c00052.L$3 = subjectXTrSignature2;
                                                            c00052.L$4 = originalSubjectId4;
                                                            c00052.L$5 = SpillingKt.nullOutSpilledVariable(parts);
                                                            c00052.L$6 = originalSubjectId5;
                                                            c00052.L$7 = SpillingKt.nullOutSpilledVariable(subjectUrl3);
                                                            c00052.L$8 = SpillingKt.nullOutSpilledVariable(subjectXClientToken3);
                                                            c00052.L$9 = SpillingKt.nullOutSpilledVariable(subjectXTrSignature3);
                                                            c00052.L$10 = SpillingKt.nullOutSpilledVariable(subjectHeaders2);
                                                            c00052.L$11 = SpillingKt.nullOutSpilledVariable(subjectResponse);
                                                            c00052.L$12 = mapper2;
                                                            c00052.L$13 = subjectIds;
                                                            c00052.L$14 = subjectXTrSignature4;
                                                            c00052.Z$0 = isCasting4;
                                                            c00052.I$0 = season2;
                                                            c00052.I$1 = episode;
                                                            c00052.label = 3;
                                                            cachedToken2 = getCachedToken(c00052);
                                                            if (cachedToken2 == obj2) {
                                                                return obj2;
                                                            }
                                                            subjectResponse2 = subjectResponse;
                                                            subjectHeaders3 = subjectHeaders2;
                                                            subjectUrl4 = subjectUrl3;
                                                            brand2 = subjectXTrSignature2;
                                                            mapper3 = mapper2;
                                                            originalLanguageName = subjectXTrSignature4;
                                                            isCasting5 = isCasting4;
                                                            function7 = function6;
                                                            subjectIds3 = subjectIds;
                                                            model2 = originalSubjectId4;
                                                            function8 = function5;
                                                            episode2 = episode;
                                                            obj4 = cachedToken2;
                                                            $result2 = subjectXClientToken3;
                                                            try {
                                                                String token = (String) obj4;
                                                                subjectIds3.add(0, new Pair(originalSubjectId5, originalLanguageName));
                                                                obj5 = obj2;
                                                                z = false;
                                                                subjectIds4 = subjectIds3;
                                                                String originalSubjectId8 = originalSubjectId5;
                                                                String token2 = brand2;
                                                                try {
                                                                    c00062 = new C00062(season2, episode2, token, token2, model2, mapper3, function8, function7, null);
                                                                    c00052.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                                                    c00052.L$1 = SpillingKt.nullOutSpilledVariable(function7);
                                                                    c00052.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                                                    c00052.L$3 = SpillingKt.nullOutSpilledVariable(token2);
                                                                    c00052.L$4 = SpillingKt.nullOutSpilledVariable(model2);
                                                                    c00052.L$5 = SpillingKt.nullOutSpilledVariable(parts);
                                                                    c00052.L$6 = SpillingKt.nullOutSpilledVariable(originalSubjectId8);
                                                                    c00052.L$7 = SpillingKt.nullOutSpilledVariable(subjectUrl4);
                                                                    c00052.L$8 = SpillingKt.nullOutSpilledVariable($result2);
                                                                    c00052.L$9 = SpillingKt.nullOutSpilledVariable(subjectXTrSignature3);
                                                                    c00052.L$10 = SpillingKt.nullOutSpilledVariable(subjectHeaders3);
                                                                    c00052.L$11 = SpillingKt.nullOutSpilledVariable(subjectResponse2);
                                                                    c00052.L$12 = SpillingKt.nullOutSpilledVariable(mapper3);
                                                                    c00052.L$13 = SpillingKt.nullOutSpilledVariable(subjectIds4);
                                                                    c00052.L$14 = SpillingKt.nullOutSpilledVariable(originalLanguageName);
                                                                    c00052.L$15 = SpillingKt.nullOutSpilledVariable(token);
                                                                    c00052.Z$0 = isCasting5;
                                                                    c00052.I$0 = season2;
                                                                    c00052.I$1 = episode2;
                                                                    c00052.label = 4;
                                                                    if (ParCollectionsKt.amap(subjectIds4, c00062, c00052) == obj5) {
                                                                        return obj5;
                                                                    }
                                                                    function9 = function8;
                                                                    function10 = function7;
                                                                    model3 = model2;
                                                                    try {
                                                                        return Boxing.boxBoolean(z2);
                                                                    } catch (Exception e) {
                                                                        return Boxing.boxBoolean(z);
                                                                    }
                                                                } catch (Exception e2) {
                                                                    return Boxing.boxBoolean(z);
                                                                }
                                                            } catch (Exception e3) {
                                                                z = false;
                                                            }
                                                        } catch (Exception e4) {
                                                            z = false;
                                                            return Boxing.boxBoolean(z);
                                                        }
                                                    } else {
                                                        mapper2 = mapper;
                                                        subjectXTrSignature3 = subjectXTrSignature;
                                                    }
                                                    subjectXTrSignature4 = "Original";
                                                    subjectHeaders2 = subjectHeaders;
                                                    persistTokenFromXUser(subjectResponse.getHeaders().get("x-user"));
                                                    c00052.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                                    c00052.L$1 = function6;
                                                    c00052.L$2 = function5;
                                                    c00052.L$3 = subjectXTrSignature2;
                                                    c00052.L$4 = originalSubjectId4;
                                                    c00052.L$5 = SpillingKt.nullOutSpilledVariable(parts);
                                                    c00052.L$6 = originalSubjectId5;
                                                    c00052.L$7 = SpillingKt.nullOutSpilledVariable(subjectUrl3);
                                                    c00052.L$8 = SpillingKt.nullOutSpilledVariable(subjectXClientToken3);
                                                    c00052.L$9 = SpillingKt.nullOutSpilledVariable(subjectXTrSignature3);
                                                    c00052.L$10 = SpillingKt.nullOutSpilledVariable(subjectHeaders2);
                                                    c00052.L$11 = SpillingKt.nullOutSpilledVariable(subjectResponse);
                                                    c00052.L$12 = mapper2;
                                                    c00052.L$13 = subjectIds;
                                                    c00052.L$14 = subjectXTrSignature4;
                                                    c00052.Z$0 = isCasting4;
                                                    c00052.I$0 = season2;
                                                    c00052.I$1 = episode;
                                                    c00052.label = 3;
                                                    cachedToken2 = getCachedToken(c00052);
                                                    if (cachedToken2 == obj2) {
                                                        return obj2;
                                                    }
                                                    subjectResponse2 = subjectResponse;
                                                    subjectHeaders3 = subjectHeaders2;
                                                    subjectUrl4 = subjectUrl3;
                                                    brand2 = subjectXTrSignature2;
                                                    mapper3 = mapper2;
                                                    originalLanguageName = subjectXTrSignature4;
                                                    isCasting5 = isCasting4;
                                                    function7 = function6;
                                                    subjectIds3 = subjectIds;
                                                    model2 = originalSubjectId4;
                                                    function8 = function5;
                                                    episode2 = episode;
                                                    obj4 = cachedToken2;
                                                    $result2 = subjectXClientToken3;
                                                    String token3 = (String) obj4;
                                                    subjectIds3.add(0, new Pair(originalSubjectId5, originalLanguageName));
                                                    obj5 = obj2;
                                                    z = false;
                                                    subjectIds4 = subjectIds3;
                                                    String originalSubjectId9 = originalSubjectId5;
                                                    String token4 = brand2;
                                                    c00062 = new C00062(season2, episode2, token3, token4, model2, mapper3, function8, function7, null);
                                                    c00052.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                                                    c00052.L$1 = SpillingKt.nullOutSpilledVariable(function7);
                                                    c00052.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                                                    c00052.L$3 = SpillingKt.nullOutSpilledVariable(token4);
                                                    c00052.L$4 = SpillingKt.nullOutSpilledVariable(model2);
                                                    c00052.L$5 = SpillingKt.nullOutSpilledVariable(parts);
                                                    c00052.L$6 = SpillingKt.nullOutSpilledVariable(originalSubjectId9);
                                                    c00052.L$7 = SpillingKt.nullOutSpilledVariable(subjectUrl4);
                                                    c00052.L$8 = SpillingKt.nullOutSpilledVariable($result2);
                                                    c00052.L$9 = SpillingKt.nullOutSpilledVariable(subjectXTrSignature3);
                                                    c00052.L$10 = SpillingKt.nullOutSpilledVariable(subjectHeaders3);
                                                    c00052.L$11 = SpillingKt.nullOutSpilledVariable(subjectResponse2);
                                                    c00052.L$12 = SpillingKt.nullOutSpilledVariable(mapper3);
                                                    c00052.L$13 = SpillingKt.nullOutSpilledVariable(subjectIds4);
                                                    c00052.L$14 = SpillingKt.nullOutSpilledVariable(originalLanguageName);
                                                    c00052.L$15 = SpillingKt.nullOutSpilledVariable(token3);
                                                    c00052.Z$0 = isCasting5;
                                                    c00052.I$0 = season2;
                                                    c00052.I$1 = episode2;
                                                    c00052.label = 4;
                                                    if (ParCollectionsKt.amap(subjectIds4, c00062, c00052) == obj5) {
                                                        return obj5;
                                                    }
                                                    function9 = function8;
                                                    function10 = function7;
                                                    model3 = model2;
                                                    return Boxing.boxBoolean(z2);
                                                } catch (Exception e5) {
                                                    z = false;
                                                }
                                            } catch (Exception e6) {
                                                z = false;
                                                return Boxing.boxBoolean(z);
                                            }
                                        } catch (Exception e7) {
                                            z = false;
                                        }
                                    } catch (Exception e8) {
                                        z = false;
                                        return Boxing.boxBoolean(z);
                                    }
                                } catch (Exception e9) {
                                }
                            } catch (Exception e10) {
                                z = false;
                                return Boxing.boxBoolean(z);
                            }
                        } catch (Exception e11) {
                        }
                    } catch (Exception e12) {
                        z = false;
                    }
                } catch (Exception e13) {
                    z = false;
                }
                break;
            case 1:
                int i2 = c00053.I$2;
                int episode5 = c00053.I$1;
                int season5 = c00053.I$0;
                boolean isCasting6 = c00053.Z$0;
                StringBuilder sb2 = (StringBuilder) c00053.L$13;
                String str2 = (String) c00053.L$12;
                Pair[] pairArr4 = (Pair[]) c00053.L$11;
                Pair[] pairArr5 = (Pair[]) c00053.L$10;
                String subjectXTrSignature6 = (String) c00053.L$9;
                Object subjectXClientToken5 = (String) c00053.L$8;
                String subjectUrl6 = (String) c00053.L$7;
                i = i2;
                String originalSubjectId10 = (String) c00053.L$6;
                List parts3 = (List) c00053.L$5;
                String model5 = (String) c00053.L$4;
                String brand4 = (String) c00053.L$3;
                Function1<? super ExtractorLink, Unit> function11 = (Function1) c00053.L$2;
                Function1<? super SubtitleFile, Unit> function12 = (Function1) c00053.L$1;
                String data3 = (String) c00053.L$0;
                try {
                    ResultKt.throwOnFailure($result3);
                    pairArr = pairArr5;
                    subjectXTrSignature = subjectXTrSignature6;
                    cachedToken = $result3;
                    $result = cachedToken;
                    obj = coroutine_suspended;
                    subjectXClientToken = subjectXClientToken5;
                    parts = parts3;
                    function4 = function11;
                    subjectXClientToken2 = originalSubjectId10;
                    isCasting2 = isCasting6;
                    subjectUrl = subjectUrl6;
                    pairArr2 = pairArr4;
                    function3 = function12;
                    originalSubjectId2 = data3;
                    episode = episode5;
                    str = str2;
                    model = model5;
                    sb = sb2;
                    season = season5;
                    brand = brand4;
                    pairArr2[i] = TuplesKt.to(str, sb.append((String) cachedToken).toString());
                    subjectHeaders = MapsKt.mapOf(pairArr);
                    Requests app2 = MainActivityKt.getApp();
                    c00053.L$0 = SpillingKt.nullOutSpilledVariable(originalSubjectId2);
                    c00053.L$1 = function3;
                    c00053.L$2 = function4;
                    c00053.L$3 = brand;
                    c00053.L$4 = model;
                    c00053.L$5 = SpillingKt.nullOutSpilledVariable(parts);
                    c00053.L$6 = subjectXClientToken2;
                    c00053.L$7 = SpillingKt.nullOutSpilledVariable(subjectUrl);
                    c00053.L$8 = SpillingKt.nullOutSpilledVariable(subjectXClientToken);
                    c00053.L$9 = SpillingKt.nullOutSpilledVariable(subjectXTrSignature);
                    c00053.L$10 = SpillingKt.nullOutSpilledVariable(subjectHeaders);
                    c00053.L$11 = null;
                    c00053.L$12 = null;
                    c00053.L$13 = null;
                    c00053.Z$0 = isCasting2;
                    c00053.I$0 = season;
                    c00053.I$1 = episode;
                    c00053.label = 2;
                    originalSubjectId3 = subjectXClientToken2;
                    obj2 = obj;
                    isCasting3 = isCasting2;
                    z2 = true;
                    obj3 = Requests.get$default(app2, subjectUrl, subjectHeaders, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00053, 4092, (Object) null);
                    c00052 = c00053;
                    if (obj3 == obj2) {
                        return obj2;
                    }
                    data2 = originalSubjectId2;
                    originalSubjectId4 = model;
                    subjectXTrSignature2 = brand;
                    season2 = season;
                    function5 = function4;
                    subjectUrl2 = subjectUrl;
                    function6 = function3;
                    $result3 = obj3;
                    isCasting4 = isCasting3;
                    originalSubjectId5 = originalSubjectId3;
                    originalSubjectId6 = subjectXClientToken;
                    subjectResponse = (NiceResponse) $result3;
                    mapper = ExtensionsKt.jacksonObjectMapper();
                    subjectIds = new ArrayList();
                    String originalLanguageName3 = "Original";
                    subjectXClientToken3 = originalSubjectId6;
                    subjectUrl3 = subjectUrl2;
                    if (subjectResponse.getCode() == 200) {
                        String subjectResponseBody2 = subjectResponse.getText();
                        mapper2 = mapper;
                        JsonNode subjectRoot2 = mapper2.readTree(subjectResponseBody2);
                        subjectXTrSignature3 = subjectXTrSignature;
                        subjectData = subjectRoot2.get("data");
                        if (subjectData != null) {
                            dubs = subjectData.get("dubs");
                        } else {
                            dubs = null;
                        }
                        if (dubs == null) {
                        }
                        break;
                    } else {
                        mapper2 = mapper;
                        subjectXTrSignature3 = subjectXTrSignature;
                    }
                    subjectXTrSignature4 = "Original";
                    subjectHeaders2 = subjectHeaders;
                    persistTokenFromXUser(subjectResponse.getHeaders().get("x-user"));
                    c00052.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                    c00052.L$1 = function6;
                    c00052.L$2 = function5;
                    c00052.L$3 = subjectXTrSignature2;
                    c00052.L$4 = originalSubjectId4;
                    c00052.L$5 = SpillingKt.nullOutSpilledVariable(parts);
                    c00052.L$6 = originalSubjectId5;
                    c00052.L$7 = SpillingKt.nullOutSpilledVariable(subjectUrl3);
                    c00052.L$8 = SpillingKt.nullOutSpilledVariable(subjectXClientToken3);
                    c00052.L$9 = SpillingKt.nullOutSpilledVariable(subjectXTrSignature3);
                    c00052.L$10 = SpillingKt.nullOutSpilledVariable(subjectHeaders2);
                    c00052.L$11 = SpillingKt.nullOutSpilledVariable(subjectResponse);
                    c00052.L$12 = mapper2;
                    c00052.L$13 = subjectIds;
                    c00052.L$14 = subjectXTrSignature4;
                    c00052.Z$0 = isCasting4;
                    c00052.I$0 = season2;
                    c00052.I$1 = episode;
                    c00052.label = 3;
                    cachedToken2 = getCachedToken(c00052);
                    if (cachedToken2 == obj2) {
                        return obj2;
                    }
                    subjectResponse2 = subjectResponse;
                    subjectHeaders3 = subjectHeaders2;
                    subjectUrl4 = subjectUrl3;
                    brand2 = subjectXTrSignature2;
                    mapper3 = mapper2;
                    originalLanguageName = subjectXTrSignature4;
                    isCasting5 = isCasting4;
                    function7 = function6;
                    subjectIds3 = subjectIds;
                    model2 = originalSubjectId4;
                    function8 = function5;
                    episode2 = episode;
                    obj4 = cachedToken2;
                    $result2 = subjectXClientToken3;
                    String token5 = (String) obj4;
                    subjectIds3.add(0, new Pair(originalSubjectId5, originalLanguageName));
                    obj5 = obj2;
                    z = false;
                    subjectIds4 = subjectIds3;
                    String originalSubjectId11 = originalSubjectId5;
                    String token6 = brand2;
                    c00062 = new C00062(season2, episode2, token5, token6, model2, mapper3, function8, function7, null);
                    c00052.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                    c00052.L$1 = SpillingKt.nullOutSpilledVariable(function7);
                    c00052.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                    c00052.L$3 = SpillingKt.nullOutSpilledVariable(token6);
                    c00052.L$4 = SpillingKt.nullOutSpilledVariable(model2);
                    c00052.L$5 = SpillingKt.nullOutSpilledVariable(parts);
                    c00052.L$6 = SpillingKt.nullOutSpilledVariable(originalSubjectId11);
                    c00052.L$7 = SpillingKt.nullOutSpilledVariable(subjectUrl4);
                    c00052.L$8 = SpillingKt.nullOutSpilledVariable($result2);
                    c00052.L$9 = SpillingKt.nullOutSpilledVariable(subjectXTrSignature3);
                    c00052.L$10 = SpillingKt.nullOutSpilledVariable(subjectHeaders3);
                    c00052.L$11 = SpillingKt.nullOutSpilledVariable(subjectResponse2);
                    c00052.L$12 = SpillingKt.nullOutSpilledVariable(mapper3);
                    c00052.L$13 = SpillingKt.nullOutSpilledVariable(subjectIds4);
                    c00052.L$14 = SpillingKt.nullOutSpilledVariable(originalLanguageName);
                    c00052.L$15 = SpillingKt.nullOutSpilledVariable(token5);
                    c00052.Z$0 = isCasting5;
                    c00052.I$0 = season2;
                    c00052.I$1 = episode2;
                    c00052.label = 4;
                    if (ParCollectionsKt.amap(subjectIds4, c00062, c00052) == obj5) {
                        return obj5;
                    }
                    function9 = function8;
                    function10 = function7;
                    model3 = model2;
                    return Boxing.boxBoolean(z2);
                } catch (Exception e14) {
                    z = false;
                    return Boxing.boxBoolean(z);
                }
            case 2:
                int episode6 = c00053.I$1;
                season2 = c00053.I$0;
                isCasting4 = c00053.Z$0;
                Map subjectHeaders4 = (Map) c00053.L$10;
                String subjectXTrSignature7 = (String) c00053.L$9;
                originalSubjectId6 = (String) c00053.L$8;
                subjectUrl2 = (String) c00053.L$7;
                String originalSubjectId12 = (String) c00053.L$6;
                List parts4 = (List) c00053.L$5;
                String model6 = (String) c00053.L$4;
                String brand5 = (String) c00053.L$3;
                function5 = (Function1) c00053.L$2;
                function6 = (Function1) c00053.L$1;
                data2 = (String) c00053.L$0;
                try {
                    ResultKt.throwOnFailure($result3);
                    subjectXTrSignature = subjectXTrSignature7;
                    obj2 = coroutine_suspended;
                    parts = parts4;
                    subjectXTrSignature2 = brand5;
                    z2 = true;
                    subjectHeaders = subjectHeaders4;
                    c00052 = c00053;
                    episode = episode6;
                    originalSubjectId5 = originalSubjectId12;
                    originalSubjectId4 = model6;
                    subjectResponse = (NiceResponse) $result3;
                    mapper = ExtensionsKt.jacksonObjectMapper();
                    subjectIds = new ArrayList();
                    String originalLanguageName4 = "Original";
                    subjectXClientToken3 = originalSubjectId6;
                    subjectUrl3 = subjectUrl2;
                    if (subjectResponse.getCode() == 200) {
                        String subjectResponseBody3 = subjectResponse.getText();
                        mapper2 = mapper;
                        JsonNode subjectRoot3 = mapper2.readTree(subjectResponseBody3);
                        subjectXTrSignature3 = subjectXTrSignature;
                        subjectData = subjectRoot3.get("data");
                        if (subjectData != null) {
                            dubs = subjectData.get("dubs");
                        } else {
                            dubs = null;
                        }
                        if (dubs == null) {
                        }
                        break;
                    } else {
                        mapper2 = mapper;
                        subjectXTrSignature3 = subjectXTrSignature;
                    }
                    subjectXTrSignature4 = "Original";
                    subjectHeaders2 = subjectHeaders;
                    persistTokenFromXUser(subjectResponse.getHeaders().get("x-user"));
                    c00052.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                    c00052.L$1 = function6;
                    c00052.L$2 = function5;
                    c00052.L$3 = subjectXTrSignature2;
                    c00052.L$4 = originalSubjectId4;
                    c00052.L$5 = SpillingKt.nullOutSpilledVariable(parts);
                    c00052.L$6 = originalSubjectId5;
                    c00052.L$7 = SpillingKt.nullOutSpilledVariable(subjectUrl3);
                    c00052.L$8 = SpillingKt.nullOutSpilledVariable(subjectXClientToken3);
                    c00052.L$9 = SpillingKt.nullOutSpilledVariable(subjectXTrSignature3);
                    c00052.L$10 = SpillingKt.nullOutSpilledVariable(subjectHeaders2);
                    c00052.L$11 = SpillingKt.nullOutSpilledVariable(subjectResponse);
                    c00052.L$12 = mapper2;
                    c00052.L$13 = subjectIds;
                    c00052.L$14 = subjectXTrSignature4;
                    c00052.Z$0 = isCasting4;
                    c00052.I$0 = season2;
                    c00052.I$1 = episode;
                    c00052.label = 3;
                    cachedToken2 = getCachedToken(c00052);
                    if (cachedToken2 == obj2) {
                        return obj2;
                    }
                    subjectResponse2 = subjectResponse;
                    subjectHeaders3 = subjectHeaders2;
                    subjectUrl4 = subjectUrl3;
                    brand2 = subjectXTrSignature2;
                    mapper3 = mapper2;
                    originalLanguageName = subjectXTrSignature4;
                    isCasting5 = isCasting4;
                    function7 = function6;
                    subjectIds3 = subjectIds;
                    model2 = originalSubjectId4;
                    function8 = function5;
                    episode2 = episode;
                    obj4 = cachedToken2;
                    $result2 = subjectXClientToken3;
                    String token7 = (String) obj4;
                    subjectIds3.add(0, new Pair(originalSubjectId5, originalLanguageName));
                    obj5 = obj2;
                    z = false;
                    subjectIds4 = subjectIds3;
                    String originalSubjectId13 = originalSubjectId5;
                    String token8 = brand2;
                    c00062 = new C00062(season2, episode2, token7, token8, model2, mapper3, function8, function7, null);
                    c00052.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                    c00052.L$1 = SpillingKt.nullOutSpilledVariable(function7);
                    c00052.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                    c00052.L$3 = SpillingKt.nullOutSpilledVariable(token8);
                    c00052.L$4 = SpillingKt.nullOutSpilledVariable(model2);
                    c00052.L$5 = SpillingKt.nullOutSpilledVariable(parts);
                    c00052.L$6 = SpillingKt.nullOutSpilledVariable(originalSubjectId13);
                    c00052.L$7 = SpillingKt.nullOutSpilledVariable(subjectUrl4);
                    c00052.L$8 = SpillingKt.nullOutSpilledVariable($result2);
                    c00052.L$9 = SpillingKt.nullOutSpilledVariable(subjectXTrSignature3);
                    c00052.L$10 = SpillingKt.nullOutSpilledVariable(subjectHeaders3);
                    c00052.L$11 = SpillingKt.nullOutSpilledVariable(subjectResponse2);
                    c00052.L$12 = SpillingKt.nullOutSpilledVariable(mapper3);
                    c00052.L$13 = SpillingKt.nullOutSpilledVariable(subjectIds4);
                    c00052.L$14 = SpillingKt.nullOutSpilledVariable(originalLanguageName);
                    c00052.L$15 = SpillingKt.nullOutSpilledVariable(token7);
                    c00052.Z$0 = isCasting5;
                    c00052.I$0 = season2;
                    c00052.I$1 = episode2;
                    c00052.label = 4;
                    if (ParCollectionsKt.amap(subjectIds4, c00062, c00052) == obj5) {
                        return obj5;
                    }
                    function9 = function8;
                    function10 = function7;
                    model3 = model2;
                    return Boxing.boxBoolean(z2);
                } catch (Exception e15) {
                    z = false;
                    return Boxing.boxBoolean(z);
                }
            case 3:
                int episode7 = c00053.I$1;
                season2 = c00053.I$0;
                boolean isCasting7 = c00053.Z$0;
                String originalLanguageName5 = (String) c00053.L$14;
                List subjectIds5 = (List) c00053.L$13;
                ObjectMapper mapper4 = (ObjectMapper) c00053.L$12;
                NiceResponse subjectResponse3 = (NiceResponse) c00053.L$11;
                Map subjectHeaders5 = (Map) c00053.L$10;
                String subjectXTrSignature8 = (String) c00053.L$9;
                Object subjectXClientToken6 = (String) c00053.L$8;
                String subjectUrl7 = (String) c00053.L$7;
                String originalSubjectId14 = (String) c00053.L$6;
                List parts5 = (List) c00053.L$5;
                String model7 = (String) c00053.L$4;
                brand2 = (String) c00053.L$3;
                Function1<? super ExtractorLink, Unit> function13 = (Function1) c00053.L$2;
                Function1<? super SubtitleFile, Unit> function14 = (Function1) c00053.L$1;
                String data4 = (String) c00053.L$0;
                try {
                    ResultKt.throwOnFailure($result3);
                    isCasting5 = isCasting7;
                    subjectResponse2 = subjectResponse3;
                    obj2 = coroutine_suspended;
                    subjectUrl4 = subjectUrl7;
                    episode2 = episode7;
                    parts = parts5;
                    z2 = true;
                    originalLanguageName = originalLanguageName5;
                    subjectIds3 = subjectIds5;
                    mapper3 = mapper4;
                    subjectHeaders3 = subjectHeaders5;
                    subjectXTrSignature3 = subjectXTrSignature8;
                    $result2 = subjectXClientToken6;
                    c00052 = c00053;
                    obj4 = $result3;
                    model2 = model7;
                    function8 = function13;
                    function7 = function14;
                    data2 = data4;
                    originalSubjectId5 = originalSubjectId14;
                    String token9 = (String) obj4;
                    subjectIds3.add(0, new Pair(originalSubjectId5, originalLanguageName));
                    obj5 = obj2;
                    z = false;
                    subjectIds4 = subjectIds3;
                    String originalSubjectId15 = originalSubjectId5;
                    String token10 = brand2;
                    c00062 = new C00062(season2, episode2, token9, token10, model2, mapper3, function8, function7, null);
                    c00052.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                    c00052.L$1 = SpillingKt.nullOutSpilledVariable(function7);
                    c00052.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                    c00052.L$3 = SpillingKt.nullOutSpilledVariable(token10);
                    c00052.L$4 = SpillingKt.nullOutSpilledVariable(model2);
                    c00052.L$5 = SpillingKt.nullOutSpilledVariable(parts);
                    c00052.L$6 = SpillingKt.nullOutSpilledVariable(originalSubjectId15);
                    c00052.L$7 = SpillingKt.nullOutSpilledVariable(subjectUrl4);
                    c00052.L$8 = SpillingKt.nullOutSpilledVariable($result2);
                    c00052.L$9 = SpillingKt.nullOutSpilledVariable(subjectXTrSignature3);
                    c00052.L$10 = SpillingKt.nullOutSpilledVariable(subjectHeaders3);
                    c00052.L$11 = SpillingKt.nullOutSpilledVariable(subjectResponse2);
                    c00052.L$12 = SpillingKt.nullOutSpilledVariable(mapper3);
                    c00052.L$13 = SpillingKt.nullOutSpilledVariable(subjectIds4);
                    c00052.L$14 = SpillingKt.nullOutSpilledVariable(originalLanguageName);
                    c00052.L$15 = SpillingKt.nullOutSpilledVariable(token9);
                    c00052.Z$0 = isCasting5;
                    c00052.I$0 = season2;
                    c00052.I$1 = episode2;
                    c00052.label = 4;
                    if (ParCollectionsKt.amap(subjectIds4, c00062, c00052) == obj5) {
                        return obj5;
                    }
                    function9 = function8;
                    function10 = function7;
                    model3 = model2;
                    return Boxing.boxBoolean(z2);
                } catch (Exception e16) {
                    z = false;
                    return Boxing.boxBoolean(z);
                }
            case 4:
                int i3 = c00053.I$1;
                int i4 = c00053.I$0;
                boolean isCasting8 = c00053.Z$0;
                String model8 = (String) c00053.L$4;
                function9 = (Function1) c00053.L$2;
                function10 = (Function1) c00053.L$1;
                try {
                    ResultKt.throwOnFailure($result3);
                    isCasting5 = isCasting8;
                    model3 = model8;
                    z = false;
                    z2 = true;
                    c00052 = c00053;
                    return Boxing.boxBoolean(z2);
                } catch (Exception e17) {
                    z = false;
                    return Boxing.boxBoolean(z);
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.MovieBox.MovieBoxProvider$loadLinks$2 */
    /* JADX INFO: compiled from: MovieBoxProvider.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "<destruct>", "Lkotlin/Pair;", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.MovieBox.MovieBoxProvider$loadLinks$2", f = "MovieBoxProvider.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7}, l = {792, 811, 846, 857, 878, 890, 916, 933}, m = "invokeSuspend", n = {"<destruct>", "subjectId", "language", "url", "xClientToken", "xTrSignature", "headers", "<destruct>", "subjectId", "language", "url", "xClientToken", "xTrSignature", "headers", "response", "responseBody", "root", "playData", "streams", "stream", "streamUrl", "format", "resolutions", "signCookieRaw", "signCookie", "id", "quality", "<destruct>", "subjectId", "language", "url", "xClientToken", "xTrSignature", "headers", "response", "responseBody", "root", "playData", "streams", "stream", "streamUrl", "format", "resolutions", "signCookieRaw", "signCookie", "id", "quality", "subLink", "xClientToken", "xTrSignature", "headers", "<destruct>", "subjectId", "language", "url", "xClientToken", "xTrSignature", "headers", "response", "responseBody", "root", "playData", "streams", "stream", "streamUrl", "format", "resolutions", "signCookieRaw", "signCookie", "id", "quality", "subLink", "xClientToken", "xTrSignature", "headers", "subResponse", "subRoot", "extCaptions", "caption", "captionUrl", "lang", "<destruct>", "subjectId", "language", "url", "xClientToken", "xTrSignature", "headers", "response", "responseBody", "root", "playData", "streams", "stream", "streamUrl", "format", "resolutions", "signCookieRaw", "signCookie", "id", "quality", "subLink", "xClientToken", "xTrSignature", "headers", "subResponse", "subRoot", "extCaptions", "subLink1", "xClientToken1", "xTrSignature1", "headers1", "<destruct>", "subjectId", "language", "url", "xClientToken", "xTrSignature", "headers", "response", "responseBody", "root", "playData", "streams", "stream", "streamUrl", "format", "resolutions", "signCookieRaw", "signCookie", "id", "quality", "subLink", "xClientToken", "xTrSignature", "headers", "subResponse", "subRoot", "extCaptions", "subLink1", "xClientToken1", "xTrSignature1", "headers1", "subResponse1", "subRoot1", "extCaptions1", "caption", "captionUrl", "lang", "<destruct>", "subjectId", "language", "url", "xClientToken", "xTrSignature", "headers", "response", "responseBody", "root", "playData", "streams", "fallbackUrl", "fallbackHeaders", "<destruct>", "subjectId", "language", "url", "xClientToken", "xTrSignature", "headers", "response", "responseBody", "root", "playData", "streams", "fallbackUrl", "fallbackHeaders", "fallbackResponse", "fallbackRoot", "detectors", "$this$forEach$iv", "element$iv", "detector", "$this$forEach$iv", "element$iv", "video", "se", "link", "ep", "quality"}, nl = {793, 810, 847, 856, 880, 889, 918, 932}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$29", "L$30", "L$31", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$28", "L$29", "L$30", "L$31", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$28", "L$29", "L$30", "L$31", "L$32", "L$33", "L$34", "L$36", "L$37", "L$38", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$21", "L$22", "L$23", "L$25", "L$26", "L$27", "L$28", "L$29", "I$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nMovieBoxProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MovieBoxProvider.kt\ncom/MovieBox/MovieBoxProvider$loadLinks$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1211:1\n2068#2:1212\n2068#2,2:1213\n2069#2:1215\n*S KotlinDebug\n*F\n+ 1 MovieBoxProvider.kt\ncom/MovieBox/MovieBoxProvider$loadLinks$2\n*L\n923#1:1212\n925#1:1213,2\n923#1:1215\n*E\n"})
    static final class C00062 extends SuspendLambda implements Function2<Pair<? extends String, ? extends String>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $brand;
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ int $episode;
        final /* synthetic */ ObjectMapper $mapper;
        final /* synthetic */ String $model;
        final /* synthetic */ int $season;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        final /* synthetic */ String $token;
        int I$0;
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
        Object L$36;
        Object L$37;
        Object L$38;
        Object L$39;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00062(int i, int i2, String str, String str2, String str3, ObjectMapper objectMapper, Function1<? super ExtractorLink, Unit> function1, Function1<? super SubtitleFile, Unit> function2, Continuation<? super C00062> continuation) {
            super(2, continuation);
            this.$season = i;
            this.$episode = i2;
            this.$token = str;
            this.$brand = str2;
            this.$model = str3;
            this.$mapper = objectMapper;
            this.$callback = function1;
            this.$subtitleCallback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00062 = MovieBoxProvider.this.new C00062(this.$season, this.$episode, this.$token, this.$brand, this.$model, this.$mapper, this.$callback, this.$subtitleCallback, continuation);
            c00062.L$0 = obj;
            return c00062;
        }

        public final Object invoke(Pair<String, String> pair, Continuation<? super Unit> continuation) {
            return create(pair, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:159:0x0d18 A[Catch: Exception -> 0x0ef8, TryCatch #3 {Exception -> 0x0ef8, blocks: (B:157:0x0d12, B:159:0x0d18, B:161:0x0d2e, B:164:0x0d42, B:183:0x0d83, B:171:0x0d5e), top: B:390:0x0d12 }] */
        /* JADX WARN: Code duplicated, block: B:187:0x0e78 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:188:0x0e79  */
        /* JADX WARN: Code duplicated, block: B:204:0x1100 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:205:0x1101  */
        /* JADX WARN: Code duplicated, block: B:210:0x1128  */
        /* JADX WARN: Code duplicated, block: B:215:0x113c  */
        /* JADX WARN: Code duplicated, block: B:217:0x1143 A[Catch: Exception -> 0x13d2, TRY_ENTER, TryCatch #25 {Exception -> 0x13d2, blocks: (B:208:0x1116, B:217:0x1143, B:219:0x1149), top: B:434:0x1116 }] */
        /* JADX WARN: Code duplicated, block: B:223:0x1167 A[Catch: Exception -> 0x1397, TryCatch #19 {Exception -> 0x1397, blocks: (B:221:0x1161, B:223:0x1167, B:225:0x117d, B:228:0x1191, B:247:0x11d1, B:235:0x11ac), top: B:422:0x1161 }] */
        /* JADX WARN: Code duplicated, block: B:251:0x12f6 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:252:0x12f7  */
        /* JADX WARN: Code duplicated, block: B:264:0x13a2  */
        /* JADX WARN: Code duplicated, block: B:307:0x15f4 A[Catch: Exception -> 0x1915, TRY_LEAVE, TryCatch #22 {Exception -> 0x1915, blocks: (B:305:0x15ee, B:307:0x15f4), top: B:428:0x15ee }] */
        /* JADX WARN: Code duplicated, block: B:311:0x160e A[Catch: Exception -> 0x190d, TRY_LEAVE, TryCatch #17 {Exception -> 0x190d, blocks: (B:309:0x1602, B:311:0x160e, B:362:0x18fc), top: B:418:0x1602 }] */
        /* JADX WARN: Code duplicated, block: B:359:0x18e9  */
        /* JADX WARN: Code duplicated, block: B:465:0x1363 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:469:0x1460 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:475:0x0ee1 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:69:0x087e A[Catch: Exception -> 0x147e, TryCatch #26 {Exception -> 0x147e, blocks: (B:67:0x0878, B:69:0x087e, B:71:0x0890, B:74:0x08b2, B:76:0x08be, B:79:0x08c5, B:81:0x08cf, B:84:0x08d6, B:86:0x08e0, B:88:0x08e6, B:90:0x08ec, B:98:0x08ff, B:100:0x090b, B:105:0x093c, B:104:0x0915), top: B:436:0x0878 }] */
        /* JADX WARN: Path cross not found for [B:414:0x119b, B:235:0x11ac], limit reached: 470 */
        /* JADX WARN: Path cross not found for [B:424:0x0d4e, B:171:0x0d5e], limit reached: 470 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:190:0x0e9a -> B:390:0x0d12). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:220:0x114d -> B:422:0x1161). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:252:0x12f7 -> B:396:0x1310). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:312:0x1616 -> B:404:0x1642). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:344:0x1816 -> B:388:0x1843). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:359:0x18e9 -> B:360:0x18f3). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        public final java.lang.Object invokeSuspend(java.lang.Object r88) {
            /*
                Method dump skipped, instruction units count: 6502
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.MovieBox.MovieBoxProvider.C00062.invokeSuspend(java.lang.Object):java.lang.Object");
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
                        $this$newExtractorLink.setHeaders(MapsKt.mapOf(TuplesKt.to("Referer", this.this$0.getMainUrl())));
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
