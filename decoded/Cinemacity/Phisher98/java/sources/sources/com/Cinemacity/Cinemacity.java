package com.Cinemacity;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fleeksoft.ksoup.Ksoup;
import com.lagradost.api.Log;
import com.lagradost.cloudstream3.Actor;
import com.lagradost.cloudstream3.ActorData;
import com.lagradost.cloudstream3.ActorRole;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.ErrorLoadingException;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.MainPageData;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.MovieLoadResponse;
import com.lagradost.cloudstream3.MovieSearchResponse;
import com.lagradost.cloudstream3.Score;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SearchResponseList;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.Qualities;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import io.ktor.http.CodecsKt;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
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
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.Interceptor;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Cinemacity.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Cinemacity/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 Z2\u00020\u0001:\u0001ZB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00052\u0014\b\u0002\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050#H\u0082@¢\u0006\u0002\u0010$J\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&2\b\u0010(\u001a\u0004\u0018\u00010\u0005J\u001e\u0010+\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0096@¢\u0006\u0002\u00102J\f\u00103\u001a\u000204*\u000205H\u0002J\f\u00106\u001a\u000204*\u000207H\u0002J\u001e\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u00052\u0006\u0010.\u001a\u00020/H\u0096@¢\u0006\u0002\u0010;J\u0016\u0010<\u001a\u00020=2\u0006\u0010!\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010>JF\u0010?\u001a\u00020\u00112\u0006\u0010@\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\u00112\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020E0C2\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020E0CH\u0096@¢\u0006\u0002\u0010HJ\u000e\u0010I\u001a\u00020/2\u0006\u0010!\u001a\u00020\u0005J\u0010\u0010J\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010\u0005J]\u0010M\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u00050N0&2\u0006\u0010O\u001a\u00020\u00052\b\u0010P\u001a\u0004\u0018\u00010K2\u0006\u0010Q\u001a\u00020/2\u0006\u0010R\u001a\u00020\u00052\n\b\u0002\u0010S\u001a\u0004\u0018\u00010/2\n\b\u0002\u0010T\u001a\u0004\u0018\u00010/¢\u0006\u0002\u0010UJ0\u0010V\u001a\u00020\u00052\u0006\u0010O\u001a\u00020\u00052\u0006\u0010W\u001a\u00020\u00052\u0006\u0010X\u001a\u00020\u00052\b\u0010Y\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u0005R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0011X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u0011X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u0011X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020*0&X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,¨\u0006["}, d2 = {"Lcom/Cinemacity/Cinemacity;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "lang", "getLang", "setLang", "hasMainPage", "", "getHasMainPage", "()Z", "hasDownloadSupport", "getHasDownloadSupport", "hasChromecastSupport", "getHasChromecastSupport", "hasQuickSearch", "getHasQuickSearch", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "appGet", "Lcom/lagradost/nicehttp/NiceResponse;", "url", "extraHeaders", "", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseCredits", "", "Lcom/lagradost/cloudstream3/ActorData;", "jsonText", "mainPage", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lorg/jsoup/nodes/Element;", "toFallbackSearchResult", "Lcom/fleeksoft/ksoup/nodes/Element;", "search", "Lcom/lagradost/cloudstream3/SearchResponseList;", "query", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "extractQuality", "parseSubtitles", "Lorg/json/JSONArray;", "raw", "buildDownloadLinks", "Lkotlin/Triple;", "base", "subtitles", "selectedAudioIndex", "title", "season", "episode", "(Ljava/lang/String;Lorg/json/JSONArray;ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Ljava/util/List;", "makeDownloadHref", "videoPath", "audioPath", "subtitlePaths", "Companion", "Cinemacity"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCinemacity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Cinemacity.kt\ncom/Cinemacity/Cinemacity\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 6 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,844:1\n117#2,10:845\n1#3:855\n1#3:867\n1#3:885\n1#3:891\n1#3:914\n1#3:945\n1#3:972\n1#3:978\n1#3:1040\n1795#4,10:856\n2068#4:866\n2069#4:868\n1805#4:869\n296#4,2:870\n296#4,2:872\n1795#4,10:874\n2068#4:884\n2069#4:886\n1805#4:887\n1795#4,10:934\n2068#4:944\n2069#4:946\n1805#4:947\n296#4,2:948\n1739#4:950\n1814#4,3:951\n777#4:954\n873#4,2:955\n1739#4:957\n1814#4,3:958\n1795#4,10:961\n2068#4:971\n2069#4:973\n1805#4:974\n777#4:998\n873#4,2:999\n1373#4,2:1001\n1402#4,4:1003\n2068#4:1007\n777#4:1008\n873#4,2:1009\n2077#4,2:1011\n2068#4,2:1013\n2079#4:1015\n2069#4:1016\n2068#4,2:1017\n1739#4:1019\n1814#4,3:1020\n777#4:1023\n873#4,2:1024\n777#4:1026\n873#4,2:1027\n1795#4,10:1029\n2068#4:1039\n2069#4:1041\n1805#4:1042\n777#4:1043\n873#4,2:1044\n93#5,2:888\n63#5:890\n64#5,15:892\n95#5,2:909\n93#5,2:911\n63#5:913\n64#5,15:915\n95#5,2:932\n93#5,2:975\n63#5:977\n64#5,15:979\n95#5,2:996\n50#6:907\n43#6:908\n50#6:930\n43#6:931\n50#6:994\n43#6:995\n*S KotlinDebug\n*F\n+ 1 Cinemacity.kt\ncom/Cinemacity/Cinemacity\n*L\n167#1:845,10\n218#1:867\n275#1:885\n297#1:891\n339#1:914\n341#1:945\n399#1:972\n434#1:978\n777#1:1040\n218#1:856,10\n218#1:866\n218#1:868\n218#1:869\n223#1:870,2\n224#1:872,2\n275#1:874,10\n275#1:884\n275#1:886\n275#1:887\n341#1:934,10\n341#1:944\n341#1:946\n341#1:947\n367#1:948,2\n372#1:950\n372#1:951,3\n373#1:954\n373#1:955,2\n378#1:957\n378#1:958,3\n399#1:961,10\n399#1:971\n399#1:973\n399#1:974\n445#1:998\n445#1:999,2\n446#1:1001,2\n446#1:1003,4\n672#1:1007\n687#1:1008\n687#1:1009,2\n689#1:1011,2\n698#1:1013,2\n689#1:1015\n672#1:1016\n733#1:1017,2\n756#1:1019\n756#1:1020,3\n757#1:1023\n757#1:1024,2\n758#1:1026\n758#1:1027,2\n777#1:1029,10\n777#1:1039\n777#1:1041\n777#1:1042\n782#1:1043\n782#1:1044,2\n297#1:888,2\n297#1:890\n297#1:892,15\n297#1:909,2\n339#1:911,2\n339#1:913\n339#1:915,15\n339#1:932,2\n434#1:975,2\n434#1:977\n434#1:979,15\n434#1:996,2\n297#1:907\n297#1:908\n339#1:930\n339#1:931\n434#1:994\n434#1:995\n*E\n"})
public final class Cinemacity extends MainAPI {

    @NotNull
    private static final String TMDBIMAGEBASEURL = "https://image.tmdb.org/t/p/original";

    @NotNull
    private static final String cinemeta_url = "https://v3-cinemeta.strem.io/meta";
    private final boolean hasQuickSearch;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String FALLBACK_LOGIN_COOKIE = MainAPIKt.base64Decode("ZGxlX3VzZXJfaWQ9MzI3Mjk7IGRsZV9wYXNzd29yZD04OTQxNzFjNmE4ZGFiMThlZTU5NGQ1YzY1MjAwOWEzNTs=");

    @NotNull
    private static final Mutex cfBypassMutex = MutexKt.Mutex$default(false, 1, (Object) null);

    @NotNull
    private String mainUrl = "https://cinemacity.cc";

    @NotNull
    private String name = "CinemaCity";

    @NotNull
    private String lang = "en";
    private final boolean hasMainPage = true;
    private final boolean hasDownloadSupport = true;
    private final boolean hasChromecastSupport = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.TvSeries});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("movies", "Movies"), TuplesKt.to("tv-series", "TV Series"), TuplesKt.to("genre/animation", "Animation"), TuplesKt.to("genre/documentary", "Documentary")});

    /* JADX INFO: renamed from: com.Cinemacity.Cinemacity$appGet$1 */
    /* JADX INFO: compiled from: Cinemacity.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Cinemacity.Cinemacity", f = "Cinemacity.kt", i = {0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4}, l = {163, 849, 168, 172, 177}, m = "appGet", n = {"url", "extraHeaders", "url", "extraHeaders", "rawResponse", "recheckPassed", "$this$withLock_u24default$iv", "url", "extraHeaders", "rawResponse", "recheckPassed", "$this$withLock_u24default$iv", "url", "extraHeaders", "rawResponse", "recheckPassed", "$this$withLock_u24default$iv", "recheck", "url", "extraHeaders", "rawResponse", "recheckPassed"}, nl = {164, 850, 169, 174, -1}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3"}, v = 2)
    static final class C00001 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C00001(Continuation<? super C00001> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Cinemacity.this.appGet(null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Cinemacity.Cinemacity$getMainPage$1 */
    /* JADX INFO: compiled from: Cinemacity.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Cinemacity.Cinemacity", f = "Cinemacity.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {217}, m = "getMainPage", n = {"request", "savedLogin", "cfCookies", "authCookie", "authHeaders", "url", "page"}, nl = {218}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C00011(Continuation<? super C00011> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Cinemacity.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Cinemacity.Cinemacity$load$1 */
    /* JADX INFO: compiled from: Cinemacity.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Cinemacity.Cinemacity", f = "Cinemacity.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}, l = {356, 405, 422, 433, 567, 598}, m = "load", n = {"url", "savedLogin", "loginPart", "cfCookies", "authCookie", "authHeaders", "url", "savedLogin", "loginPart", "cfCookies", "authCookie", "authHeaders", "page", "doc", "ogTitle", "title", "poster", "bgposter", "trailer", "audioLanguages", "descriptions", "recommendation", "year", "tvtype", "tmdbmetatype", "genre", "background", "description", "imdbId", "id", "$this$load_u24lambda_u247_u240", "url", "savedLogin", "loginPart", "cfCookies", "authCookie", "authHeaders", "page", "doc", "ogTitle", "title", "poster", "bgposter", "trailer", "audioLanguages", "descriptions", "recommendation", "year", "tvtype", "tmdbmetatype", "genre", "background", "description", "imdbId", "tmdbId", "logoPath", "it", "$this$load_u24lambda_u249_u240", "url", "savedLogin", "loginPart", "cfCookies", "authCookie", "authHeaders", "page", "doc", "ogTitle", "title", "poster", "bgposter", "trailer", "audioLanguages", "descriptions", "recommendation", "year", "tvtype", "tmdbmetatype", "genre", "background", "description", "imdbId", "tmdbId", "logoPath", "creditsJson", "castList", "typeset", "it", "url", "savedLogin", "loginPart", "cfCookies", "authCookie", "authHeaders", "page", "doc", "ogTitle", "title", "poster", "bgposter", "trailer", "audioLanguages", "descriptions", "recommendation", "year", "tvtype", "tmdbmetatype", "genre", "background", "description", "imdbId", "tmdbId", "logoPath", "creditsJson", "castList", "typeset", "responseData", "epMetaMap", "playerScript", "decodedPlayer", "playerJson", "rawFile", "fileArray", "seasonRegex", "episodeRegex", "episodeList", "movieHrefs", "movieSubtitleTracks", "moviejson", "url", "savedLogin", "loginPart", "cfCookies", "authCookie", "authHeaders", "page", "doc", "ogTitle", "title", "poster", "bgposter", "trailer", "audioLanguages", "descriptions", "recommendation", "year", "tvtype", "tmdbmetatype", "genre", "background", "description", "imdbId", "tmdbId", "logoPath", "creditsJson", "castList", "typeset", "responseData", "epMetaMap", "playerScript", "decodedPlayer", "playerJson", "rawFile", "fileArray", "seasonRegex", "episodeRegex", "episodeList", "movieHrefs", "movieSubtitleTracks", "moviejson"}, nl = {357, 409, 425, 434, 596, -1}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$28", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$28", "L$29", "L$30", "L$31", "L$32", "L$33", "L$34", "L$35", "L$36", "L$37", "L$38", "L$39", "L$40", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$28", "L$29", "L$30", "L$31", "L$32", "L$33", "L$34", "L$35", "L$36", "L$37", "L$38", "L$39", "L$40"}, v = 2)
    static final class C00021 extends ContinuationImpl {
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
        Object L$40;
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
            return Cinemacity.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Cinemacity.Cinemacity$loadLinks$1 */
    /* JADX INFO: compiled from: Cinemacity.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Cinemacity.Cinemacity", f = "Cinemacity.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {639, 674, 700}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "obj", "subs", "s", "isCasting", "i", "data", "subtitleCallback", "callback", "obj", "streamUrls", "savedLogin", "loginPart", "cfCookies", "authCookie", "streamHeaders", "$this$forEach$iv", "element$iv", "url", "isCasting", "data", "subtitleCallback", "callback", "obj", "streamUrls", "savedLogin", "loginPart", "cfCookies", "authCookie", "streamHeaders", "$this$forEach$iv", "element$iv", "url", "audioFiles", "parts", "$this$forEachIndexed$iv", "item$iv", "downloads", "$this$forEach$iv", "element$iv", "dlUrl", "lang", "isCasting", "index$iv", "index", "quality"}, nl = {638, 673, 699}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$12", "L$13", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$12", "L$13", "L$14", "L$15", "L$16", "L$18", "L$19", "L$20", "L$22", "L$23", "L$24", "Z$0", "I$0", "I$1", "I$2"}, v = 2)
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
            return Cinemacity.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Cinemacity.Cinemacity$search$1 */
    /* JADX INFO: compiled from: Cinemacity.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Cinemacity.Cinemacity", f = "Cinemacity.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {274, 288, 312, 320}, m = "search", n = {"query", "savedLogin", "loginPart", "cfCookies", "authCookie", "authHeaders", "mainSearchUrl", "page", "query", "savedLogin", "loginPart", "cfCookies", "authCookie", "authHeaders", "mainSearchUrl", "doc", "res", "finalHash", "$this$search_u24lambda_u242", "page", "query", "savedLogin", "loginPart", "cfCookies", "authCookie", "authHeaders", "mainSearchUrl", "doc", "res", "finalHash", "html", "$this$search_u24lambda_u244", "page", "query", "savedLogin", "loginPart", "cfCookies", "authCookie", "authHeaders", "mainSearchUrl", "doc", "res", "finalHash", "ajaxUrl", "page"}, nl = {275, 297, 313, 337}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "I$0"}, v = 2)
    static final class C00061 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
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

        C00061(Continuation<? super C00061> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Cinemacity.this.search(null, 0, (Continuation) this);
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

    @NotNull
    public String getLang() {
        return this.lang;
    }

    public void setLang(@NotNull String str) {
        this.lang = str;
    }

    public boolean getHasMainPage() {
        return this.hasMainPage;
    }

    public boolean getHasDownloadSupport() {
        return this.hasDownloadSupport;
    }

    public boolean getHasChromecastSupport() {
        return this.hasChromecastSupport;
    }

    public boolean getHasQuickSearch() {
        return this.hasQuickSearch;
    }

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    /* JADX INFO: compiled from: Cinemacity.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/Cinemacity/Cinemacity$Companion;", "", "<init>", "()V", "TMDBIMAGEBASEURL", "", "cinemeta_url", "FALLBACK_LOGIN_COOKIE", "cfBypassMutex", "Lkotlinx/coroutines/sync/Mutex;", "isCloudflareBlocked", "", "response", "Lcom/lagradost/nicehttp/NiceResponse;", "cfHeaders", "", "getCfHeaders", "()Ljava/util/Map;", "Cinemacity"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isCloudflareBlocked(@NotNull NiceResponse response) {
            if (response.getCode() != 403 && response.getCode() != 503) {
                return false;
            }
            String body = response.getText();
            String lower = body.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lower, "toLowerCase(...)");
            return StringsKt.contains$default(lower, "<title>just a moment", false, 2, (Object) null) || StringsKt.contains$default(lower, "id=\"challenge-form\"", false, 2, (Object) null) || StringsKt.contains$default(lower, "cf-browser-verification", false, 2, (Object) null) || StringsKt.contains$default(lower, "checking your browser before accessing", false, 2, (Object) null);
        }

        @NotNull
        public final Map<String, String> getCfHeaders() {
            Map map = new LinkedHashMap();
            String savedUa = CinemacityPlugin.INSTANCE.getCfUserAgent();
            if (savedUa.length() > 0) {
                map.put("User-Agent", savedUa);
            }
            String savedCookies = CinemacityPlugin.INSTANCE.getCfCookies();
            if (savedCookies.length() > 0) {
                map.put("Cookie", savedCookies);
            }
            return map;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:29:0x011e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:30:0x011f  */
    /* JADX WARN: Code duplicated, block: B:32:0x013f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:33:0x0140  */
    /* JADX WARN: Code duplicated, block: B:40:0x0191 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:41:0x0192  */
    /* JADX WARN: Code duplicated, block: B:44:0x01aa A[Catch: all -> 0x01ad, TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x01ad, blocks: (B:44:0x01aa, B:50:0x01ba), top: B:84:0x01a8 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x01b2 A[Catch: all -> 0x0252, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0252, blocks: (B:42:0x019f, B:48:0x01b2), top: B:75:0x019f }] */
    /* JADX WARN: Code duplicated, block: B:50:0x01ba A[Catch: all -> 0x01ad, TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x01ad, blocks: (B:44:0x01aa, B:50:0x01ba), top: B:84:0x01a8 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x01d7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:58:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:60:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:62:0x023e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:63:0x023f  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object appGet(String url, Map<String, String> map, Continuation<? super NiceResponse> continuation) throws Throwable {
        C00001 c00001;
        Mutex $this$withLock_u24default$iv;
        Object owner$iv;
        Object obj;
        C00001 c00002;
        String url2;
        Map<String, String> map2;
        NiceResponse rawResponse;
        Ref.ObjectRef recheckPassed;
        Mutex $this$withLock_u24default$iv2;
        NiceResponse rawResponse2;
        String url3;
        Ref.ObjectRef recheckPassed2;
        Mutex $this$withLock_u24default$iv3;
        Object owner$iv2;
        int $i$f$withLock;
        Ref.ObjectRef recheckPassed3;
        Mutex $this$withLock_u24default$iv4;
        String url4;
        Object obj2;
        C00001 c00003;
        String url5;
        Map<String, String> map3;
        NiceResponse rawResponse3;
        Ref.ObjectRef recheckPassed4;
        NiceResponse recheck;
        Ref.ObjectRef recheckPassed5;
        NiceResponse rawResponse4;
        String url6;
        NiceResponse it;
        Object obj3;
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
        C00001 c00004 = c00001;
        Object $result = c00004.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (c00004.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Requests app = MainActivityKt.getApp();
                    CinemacityCFBypassInterceptor cinemacityCFBypassInterceptor = CinemacityCFBypassInterceptor.INSTANCE;
                    c00004.L$0 = url;
                    c00004.L$1 = map;
                    c00004.label = 1;
                    obj = Requests.get$default(app, url, map, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, cinemacityCFBypassInterceptor, false, (ResponseParser) null, c00004, 3580, (Object) null);
                    c00002 = c00004;
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    url2 = url;
                    map2 = map;
                    rawResponse = (NiceResponse) obj;
                    if (!INSTANCE.isCloudflareBlocked(rawResponse)) {
                        return rawResponse;
                    }
                    recheckPassed = new Ref.ObjectRef();
                    $this$withLock_u24default$iv2 = cfBypassMutex;
                    c00002.L$0 = url2;
                    c00002.L$1 = map2;
                    c00002.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse);
                    c00002.L$3 = recheckPassed;
                    c00002.L$4 = $this$withLock_u24default$iv2;
                    c00002.label = 2;
                    if ($this$withLock_u24default$iv2.lock((Object) null, c00002) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    rawResponse2 = rawResponse;
                    url3 = url2;
                    recheckPassed2 = recheckPassed;
                    $this$withLock_u24default$iv3 = $this$withLock_u24default$iv2;
                    owner$iv2 = null;
                    $i$f$withLock = 0;
                    try {
                        Requests app2 = MainActivityKt.getApp();
                        CinemacityCFBypassInterceptor cinemacityCFBypassInterceptor2 = CinemacityCFBypassInterceptor.INSTANCE;
                        c00002.L$0 = url3;
                        c00002.L$1 = map2;
                        c00002.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse2);
                        c00002.L$3 = recheckPassed2;
                        c00002.L$4 = $this$withLock_u24default$iv3;
                        c00002.label = 3;
                        recheckPassed3 = recheckPassed2;
                        $this$withLock_u24default$iv4 = $this$withLock_u24default$iv3;
                        C00001 c00005 = c00002;
                        url4 = url3;
                        try {
                            obj2 = Requests.get$default(app2, url4, map2, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, cinemacityCFBypassInterceptor2, false, (ResponseParser) null, c00005, 3580, (Object) null);
                            c00003 = c00005;
                            if (obj2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            url5 = url4;
                            map3 = map2;
                            owner$iv = owner$iv2;
                            rawResponse3 = rawResponse2;
                            recheckPassed4 = recheckPassed3;
                            $this$withLock_u24default$iv = $this$withLock_u24default$iv4;
                            $result = obj2;
                            try {
                                recheck = (NiceResponse) $result;
                                try {
                                    try {
                                        if (!INSTANCE.isCloudflareBlocked(recheck)) {
                                            if (CinemacityPlugin.INSTANCE.getCfWebviewEnabled()) {
                                                c00003.L$0 = url5;
                                                c00003.L$1 = map3;
                                                c00003.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse3);
                                                c00003.L$3 = recheckPassed4;
                                                c00003.L$4 = $this$withLock_u24default$iv;
                                                c00003.L$5 = SpillingKt.nullOutSpilledVariable(recheck);
                                                c00003.label = 4;
                                                if (CinemacityKt.showCinemacityCFBypassDialogAndWait(url5, c00003) == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                recheckPassed5 = recheckPassed4;
                                                rawResponse4 = rawResponse3;
                                                url6 = url5;
                                            }
                                            Unit unit = Unit.INSTANCE;
                                            $this$withLock_u24default$iv.unlock(owner$iv);
                                            it = (NiceResponse) recheckPassed5.element;
                                            if (it != null) {
                                                return it;
                                            }
                                            Ref.ObjectRef recheckPassed6 = recheckPassed5;
                                            Requests app3 = MainActivityKt.getApp();
                                            CinemacityCFBypassInterceptor cinemacityCFBypassInterceptor3 = CinemacityCFBypassInterceptor.INSTANCE;
                                            c00003.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                                            c00003.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                                            c00003.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse4);
                                            c00003.L$3 = SpillingKt.nullOutSpilledVariable(recheckPassed6);
                                            c00003.L$4 = null;
                                            c00003.L$5 = null;
                                            c00003.label = 5;
                                            obj3 = Requests.get$default(app3, url6, map3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, cinemacityCFBypassInterceptor3, false, (ResponseParser) null, c00003, 3580, (Object) null);
                                            if (obj3 == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            return obj3;
                                        }
                                        recheckPassed4.element = recheck;
                                        Unit unit2 = Unit.INSTANCE;
                                        $this$withLock_u24default$iv.unlock(owner$iv);
                                        it = (NiceResponse) recheckPassed5.element;
                                        if (it != null) {
                                            return it;
                                        }
                                        Ref.ObjectRef recheckPassed7 = recheckPassed5;
                                        Requests app4 = MainActivityKt.getApp();
                                        CinemacityCFBypassInterceptor cinemacityCFBypassInterceptor4 = CinemacityCFBypassInterceptor.INSTANCE;
                                        c00003.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                                        c00003.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                                        c00003.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse4);
                                        c00003.L$3 = SpillingKt.nullOutSpilledVariable(recheckPassed7);
                                        c00003.L$4 = null;
                                        c00003.L$5 = null;
                                        c00003.label = 5;
                                        obj3 = Requests.get$default(app4, url6, map3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, cinemacityCFBypassInterceptor4, false, (ResponseParser) null, c00003, 3580, (Object) null);
                                        if (obj3 == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        return obj3;
                                    } catch (Throwable th) {
                                        th = th;
                                        $this$withLock_u24default$iv.unlock(owner$iv);
                                        throw th;
                                    }
                                    recheckPassed5 = recheckPassed4;
                                    rawResponse4 = rawResponse3;
                                    url6 = url5;
                                } catch (Throwable th2) {
                                    th = th2;
                                    $this$withLock_u24default$iv.unlock(owner$iv);
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            owner$iv = owner$iv2;
                            $this$withLock_u24default$iv = $this$withLock_u24default$iv4;
                            $this$withLock_u24default$iv.unlock(owner$iv);
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        owner$iv = owner$iv2;
                        $this$withLock_u24default$iv = $this$withLock_u24default$iv3;
                    }
                    break;
                case 1:
                    map2 = (Map) c00004.L$1;
                    url2 = (String) c00004.L$0;
                    ResultKt.throwOnFailure($result);
                    c00002 = c00004;
                    obj = $result;
                    rawResponse = (NiceResponse) obj;
                    if (!INSTANCE.isCloudflareBlocked(rawResponse)) {
                        return rawResponse;
                    }
                    recheckPassed = new Ref.ObjectRef();
                    $this$withLock_u24default$iv2 = cfBypassMutex;
                    c00002.L$0 = url2;
                    c00002.L$1 = map2;
                    c00002.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse);
                    c00002.L$3 = recheckPassed;
                    c00002.L$4 = $this$withLock_u24default$iv2;
                    c00002.label = 2;
                    if ($this$withLock_u24default$iv2.lock((Object) null, c00002) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    rawResponse2 = rawResponse;
                    url3 = url2;
                    recheckPassed2 = recheckPassed;
                    $this$withLock_u24default$iv3 = $this$withLock_u24default$iv2;
                    owner$iv2 = null;
                    $i$f$withLock = 0;
                    Requests app5 = MainActivityKt.getApp();
                    CinemacityCFBypassInterceptor cinemacityCFBypassInterceptor5 = CinemacityCFBypassInterceptor.INSTANCE;
                    c00002.L$0 = url3;
                    c00002.L$1 = map2;
                    c00002.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse2);
                    c00002.L$3 = recheckPassed2;
                    c00002.L$4 = $this$withLock_u24default$iv3;
                    c00002.label = 3;
                    recheckPassed3 = recheckPassed2;
                    $this$withLock_u24default$iv4 = $this$withLock_u24default$iv3;
                    C00001 c00006 = c00002;
                    url4 = url3;
                    obj2 = Requests.get$default(app5, url4, map2, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, cinemacityCFBypassInterceptor5, false, (ResponseParser) null, c00006, 3580, (Object) null);
                    c00003 = c00006;
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    url5 = url4;
                    map3 = map2;
                    owner$iv = owner$iv2;
                    rawResponse3 = rawResponse2;
                    recheckPassed4 = recheckPassed3;
                    $this$withLock_u24default$iv = $this$withLock_u24default$iv4;
                    $result = obj2;
                    recheck = (NiceResponse) $result;
                    if (!INSTANCE.isCloudflareBlocked(recheck)) {
                        if (CinemacityPlugin.INSTANCE.getCfWebviewEnabled()) {
                            c00003.L$0 = url5;
                            c00003.L$1 = map3;
                            c00003.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse3);
                            c00003.L$3 = recheckPassed4;
                            c00003.L$4 = $this$withLock_u24default$iv;
                            c00003.L$5 = SpillingKt.nullOutSpilledVariable(recheck);
                            c00003.label = 4;
                            if (CinemacityKt.showCinemacityCFBypassDialogAndWait(url5, c00003) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            recheckPassed5 = recheckPassed4;
                            rawResponse4 = rawResponse3;
                            url6 = url5;
                        }
                        Unit unit3 = Unit.INSTANCE;
                        $this$withLock_u24default$iv.unlock(owner$iv);
                        it = (NiceResponse) recheckPassed5.element;
                        if (it != null) {
                            return it;
                        }
                        Ref.ObjectRef recheckPassed8 = recheckPassed5;
                        Requests app6 = MainActivityKt.getApp();
                        CinemacityCFBypassInterceptor cinemacityCFBypassInterceptor6 = CinemacityCFBypassInterceptor.INSTANCE;
                        c00003.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                        c00003.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                        c00003.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse4);
                        c00003.L$3 = SpillingKt.nullOutSpilledVariable(recheckPassed8);
                        c00003.L$4 = null;
                        c00003.L$5 = null;
                        c00003.label = 5;
                        obj3 = Requests.get$default(app6, url6, map3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, cinemacityCFBypassInterceptor6, false, (ResponseParser) null, c00003, 3580, (Object) null);
                        if (obj3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return obj3;
                    }
                    recheckPassed4.element = recheck;
                    recheckPassed5 = recheckPassed4;
                    rawResponse4 = rawResponse3;
                    url6 = url5;
                    Unit unit4 = Unit.INSTANCE;
                    $this$withLock_u24default$iv.unlock(owner$iv);
                    it = (NiceResponse) recheckPassed5.element;
                    if (it != null) {
                        return it;
                    }
                    Ref.ObjectRef recheckPassed9 = recheckPassed5;
                    Requests app7 = MainActivityKt.getApp();
                    CinemacityCFBypassInterceptor cinemacityCFBypassInterceptor7 = CinemacityCFBypassInterceptor.INSTANCE;
                    c00003.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                    c00003.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                    c00003.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse4);
                    c00003.L$3 = SpillingKt.nullOutSpilledVariable(recheckPassed9);
                    c00003.L$4 = null;
                    c00003.L$5 = null;
                    c00003.label = 5;
                    obj3 = Requests.get$default(app7, url6, map3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, cinemacityCFBypassInterceptor7, false, (ResponseParser) null, c00003, 3580, (Object) null);
                    if (obj3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return obj3;
                case 2:
                    Mutex $this$withLock_u24default$iv5 = (Mutex) c00004.L$4;
                    Ref.ObjectRef recheckPassed10 = (Ref.ObjectRef) c00004.L$3;
                    NiceResponse rawResponse5 = (NiceResponse) c00004.L$2;
                    Map<String, String> map4 = (Map) c00004.L$1;
                    url3 = (String) c00004.L$0;
                    ResultKt.throwOnFailure($result);
                    $i$f$withLock = 0;
                    owner$iv2 = null;
                    recheckPassed2 = recheckPassed10;
                    rawResponse2 = rawResponse5;
                    map2 = map4;
                    c00002 = c00004;
                    $this$withLock_u24default$iv3 = $this$withLock_u24default$iv5;
                    Requests app8 = MainActivityKt.getApp();
                    CinemacityCFBypassInterceptor cinemacityCFBypassInterceptor8 = CinemacityCFBypassInterceptor.INSTANCE;
                    c00002.L$0 = url3;
                    c00002.L$1 = map2;
                    c00002.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse2);
                    c00002.L$3 = recheckPassed2;
                    c00002.L$4 = $this$withLock_u24default$iv3;
                    c00002.label = 3;
                    recheckPassed3 = recheckPassed2;
                    $this$withLock_u24default$iv4 = $this$withLock_u24default$iv3;
                    C00001 c00007 = c00002;
                    url4 = url3;
                    obj2 = Requests.get$default(app8, url4, map2, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, cinemacityCFBypassInterceptor8, false, (ResponseParser) null, c00007, 3580, (Object) null);
                    c00003 = c00007;
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    url5 = url4;
                    map3 = map2;
                    owner$iv = owner$iv2;
                    rawResponse3 = rawResponse2;
                    recheckPassed4 = recheckPassed3;
                    $this$withLock_u24default$iv = $this$withLock_u24default$iv4;
                    $result = obj2;
                    recheck = (NiceResponse) $result;
                    if (!INSTANCE.isCloudflareBlocked(recheck)) {
                        if (CinemacityPlugin.INSTANCE.getCfWebviewEnabled()) {
                            c00003.L$0 = url5;
                            c00003.L$1 = map3;
                            c00003.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse3);
                            c00003.L$3 = recheckPassed4;
                            c00003.L$4 = $this$withLock_u24default$iv;
                            c00003.L$5 = SpillingKt.nullOutSpilledVariable(recheck);
                            c00003.label = 4;
                            if (CinemacityKt.showCinemacityCFBypassDialogAndWait(url5, c00003) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            recheckPassed5 = recheckPassed4;
                            rawResponse4 = rawResponse3;
                            url6 = url5;
                        }
                        Unit unit5 = Unit.INSTANCE;
                        $this$withLock_u24default$iv.unlock(owner$iv);
                        it = (NiceResponse) recheckPassed5.element;
                        if (it != null) {
                            return it;
                        }
                        Ref.ObjectRef recheckPassed11 = recheckPassed5;
                        Requests app9 = MainActivityKt.getApp();
                        CinemacityCFBypassInterceptor cinemacityCFBypassInterceptor9 = CinemacityCFBypassInterceptor.INSTANCE;
                        c00003.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                        c00003.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                        c00003.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse4);
                        c00003.L$3 = SpillingKt.nullOutSpilledVariable(recheckPassed11);
                        c00003.L$4 = null;
                        c00003.L$5 = null;
                        c00003.label = 5;
                        obj3 = Requests.get$default(app9, url6, map3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, cinemacityCFBypassInterceptor9, false, (ResponseParser) null, c00003, 3580, (Object) null);
                        if (obj3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return obj3;
                    }
                    recheckPassed4.element = recheck;
                    recheckPassed5 = recheckPassed4;
                    rawResponse4 = rawResponse3;
                    url6 = url5;
                    Unit unit6 = Unit.INSTANCE;
                    $this$withLock_u24default$iv.unlock(owner$iv);
                    it = (NiceResponse) recheckPassed5.element;
                    if (it != null) {
                        return it;
                    }
                    Ref.ObjectRef recheckPassed12 = recheckPassed5;
                    Requests app10 = MainActivityKt.getApp();
                    CinemacityCFBypassInterceptor cinemacityCFBypassInterceptor10 = CinemacityCFBypassInterceptor.INSTANCE;
                    c00003.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                    c00003.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                    c00003.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse4);
                    c00003.L$3 = SpillingKt.nullOutSpilledVariable(recheckPassed12);
                    c00003.L$4 = null;
                    c00003.L$5 = null;
                    c00003.label = 5;
                    obj3 = Requests.get$default(app10, url6, map3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, cinemacityCFBypassInterceptor10, false, (ResponseParser) null, c00003, 3580, (Object) null);
                    if (obj3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return obj3;
                case 3:
                    owner$iv = null;
                    $this$withLock_u24default$iv = (Mutex) c00004.L$4;
                    recheckPassed4 = (Ref.ObjectRef) c00004.L$3;
                    rawResponse3 = (NiceResponse) c00004.L$2;
                    map3 = (Map) c00004.L$1;
                    url5 = (String) c00004.L$0;
                    ResultKt.throwOnFailure($result);
                    c00003 = c00004;
                    recheck = (NiceResponse) $result;
                    if (!INSTANCE.isCloudflareBlocked(recheck)) {
                        if (CinemacityPlugin.INSTANCE.getCfWebviewEnabled()) {
                            c00003.L$0 = url5;
                            c00003.L$1 = map3;
                            c00003.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse3);
                            c00003.L$3 = recheckPassed4;
                            c00003.L$4 = $this$withLock_u24default$iv;
                            c00003.L$5 = SpillingKt.nullOutSpilledVariable(recheck);
                            c00003.label = 4;
                            if (CinemacityKt.showCinemacityCFBypassDialogAndWait(url5, c00003) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            recheckPassed5 = recheckPassed4;
                            rawResponse4 = rawResponse3;
                            url6 = url5;
                        }
                        Unit unit7 = Unit.INSTANCE;
                        $this$withLock_u24default$iv.unlock(owner$iv);
                        it = (NiceResponse) recheckPassed5.element;
                        if (it != null) {
                            return it;
                        }
                        Ref.ObjectRef recheckPassed13 = recheckPassed5;
                        Requests app11 = MainActivityKt.getApp();
                        CinemacityCFBypassInterceptor cinemacityCFBypassInterceptor11 = CinemacityCFBypassInterceptor.INSTANCE;
                        c00003.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                        c00003.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                        c00003.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse4);
                        c00003.L$3 = SpillingKt.nullOutSpilledVariable(recheckPassed13);
                        c00003.L$4 = null;
                        c00003.L$5 = null;
                        c00003.label = 5;
                        obj3 = Requests.get$default(app11, url6, map3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, cinemacityCFBypassInterceptor11, false, (ResponseParser) null, c00003, 3580, (Object) null);
                        if (obj3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return obj3;
                    }
                    recheckPassed4.element = recheck;
                    recheckPassed5 = recheckPassed4;
                    rawResponse4 = rawResponse3;
                    url6 = url5;
                    Unit unit8 = Unit.INSTANCE;
                    $this$withLock_u24default$iv.unlock(owner$iv);
                    it = (NiceResponse) recheckPassed5.element;
                    if (it != null) {
                        return it;
                    }
                    Ref.ObjectRef recheckPassed14 = recheckPassed5;
                    Requests app12 = MainActivityKt.getApp();
                    CinemacityCFBypassInterceptor cinemacityCFBypassInterceptor12 = CinemacityCFBypassInterceptor.INSTANCE;
                    c00003.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                    c00003.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                    c00003.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse4);
                    c00003.L$3 = SpillingKt.nullOutSpilledVariable(recheckPassed14);
                    c00003.L$4 = null;
                    c00003.L$5 = null;
                    c00003.label = 5;
                    obj3 = Requests.get$default(app12, url6, map3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, cinemacityCFBypassInterceptor12, false, (ResponseParser) null, c00003, 3580, (Object) null);
                    if (obj3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return obj3;
                case 4:
                    owner$iv = null;
                    $this$withLock_u24default$iv = (Mutex) c00004.L$4;
                    recheckPassed4 = (Ref.ObjectRef) c00004.L$3;
                    rawResponse3 = (NiceResponse) c00004.L$2;
                    map3 = (Map) c00004.L$1;
                    url5 = (String) c00004.L$0;
                    ResultKt.throwOnFailure($result);
                    c00003 = c00004;
                    recheckPassed5 = recheckPassed4;
                    rawResponse4 = rawResponse3;
                    url6 = url5;
                    Unit unit9 = Unit.INSTANCE;
                    $this$withLock_u24default$iv.unlock(owner$iv);
                    it = (NiceResponse) recheckPassed5.element;
                    if (it != null) {
                        return it;
                    }
                    Ref.ObjectRef recheckPassed15 = recheckPassed5;
                    Requests app13 = MainActivityKt.getApp();
                    CinemacityCFBypassInterceptor cinemacityCFBypassInterceptor13 = CinemacityCFBypassInterceptor.INSTANCE;
                    c00003.L$0 = SpillingKt.nullOutSpilledVariable(url6);
                    c00003.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                    c00003.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse4);
                    c00003.L$3 = SpillingKt.nullOutSpilledVariable(recheckPassed15);
                    c00003.L$4 = null;
                    c00003.L$5 = null;
                    c00003.label = 5;
                    obj3 = Requests.get$default(app13, url6, map3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, cinemacityCFBypassInterceptor13, false, (ResponseParser) null, c00003, 3580, (Object) null);
                    if (obj3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return obj3;
                case 5:
                    ResultKt.throwOnFailure($result);
                    return $result;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object appGet$default(Cinemacity cinemacity, String str, Map map, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        return cinemacity.appGet(str, map, continuation);
    }

    @NotNull
    public final List<ActorData> parseCredits(@Nullable String jsonText) {
        String str = jsonText;
        if (str == null || StringsKt.isBlank(str)) {
            return CollectionsKt.emptyList();
        }
        ArrayList list = new ArrayList();
        JSONObject root = new JSONObject(jsonText);
        JSONArray castArr = root.optJSONArray("cast");
        if (castArr == null) {
            return list;
        }
        int length = castArr.length();
        for (int i = 0; i < length; i++) {
            JSONObject c = castArr.optJSONObject(i);
            if (c != null) {
                String name = c.optString("name");
                if (StringsKt.isBlank(name)) {
                    name = null;
                }
                if (name == null && (name = c.optString("original_name")) == null) {
                    name = "";
                }
                String it = c.optString("profile_path");
                if (StringsKt.isBlank(it)) {
                    it = null;
                }
                String it2 = it != null ? TMDBIMAGEBASEURL + it : null;
                String it3 = c.optString("character");
                String character = StringsKt.isBlank(it3) ? null : it3;
                Actor actor = new Actor(name, it2);
                list.add(new ActorData(actor, (ActorRole) null, character, (Actor) null, 10, (DefaultConstructorMarker) null));
            }
        }
        return list;
    }

    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.lagradost.cloudstream3.ErrorLoadingException */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) throws Throwable {
        C00011 c00011;
        MainPageRequest request2;
        Object objAppGet;
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
        Object $result = c00011.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00011.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (StringsKt.isBlank(CinemacityPlugin.INSTANCE.getLoginCookies())) {
                    throw new ErrorLoadingException("Not logged in. Open Cinemacity addon settings and login.");
                }
                String savedLogin = CinemacityPlugin.INSTANCE.getLoginCookies();
                String cfCookies = CinemacityPlugin.INSTANCE.getCfCookies();
                String authCookie = !StringsKt.isBlank(cfCookies) ? savedLogin + "; " + cfCookies : savedLogin;
                Map<String, String> mapMapOf = MapsKt.mapOf(TuplesKt.to("Cookie", authCookie));
                String url = page == 1 ? getMainUrl() + '/' + request.getData() : getMainUrl() + '/' + request.getData() + "/page/" + page;
                request2 = request;
                c00011.L$0 = request2;
                c00011.L$1 = SpillingKt.nullOutSpilledVariable(savedLogin);
                c00011.L$2 = SpillingKt.nullOutSpilledVariable(cfCookies);
                c00011.L$3 = SpillingKt.nullOutSpilledVariable(authCookie);
                c00011.L$4 = SpillingKt.nullOutSpilledVariable(mapMapOf);
                c00011.L$5 = SpillingKt.nullOutSpilledVariable(url);
                c00011.I$0 = page;
                c00011.label = 1;
                objAppGet = appGet(url, mapMapOf, c00011);
                if (objAppGet == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                int i = c00011.I$0;
                MainPageRequest request3 = (MainPageRequest) c00011.L$0;
                ResultKt.throwOnFailure($result);
                objAppGet = $result;
                request2 = request3;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document doc = ((NiceResponse) objAppGet).getDocument();
        Iterable $this$mapNotNull$iv = doc.select("div.dar-short_item");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Element it = (Element) element$iv$iv$iv;
            SearchResponse searchResult = toSearchResult(it);
            if (searchResult != null) {
                destination$iv$iv.add(searchResult);
            }
        }
        List home = (List) destination$iv$iv;
        return MainAPIKt.newHomePageResponse(request2.getName(), home, Boxing.boxBoolean(true));
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00de  */
    /* JADX WARN: Code duplicated, block: B:58:0x0104  */
    private final SearchResponse toSearchResult(Element $this$toSearchResult) {
        Object element$iv;
        Object element$iv2;
        Element elementSelectFirst;
        boolean z;
        String strText;
        String it;
        String strAttr;
        String strOwnText;
        String strSubstringBefore$default;
        Iterable $this$firstOrNull$iv = $this$toSearchResult.children();
        Iterator it2 = $this$firstOrNull$iv.iterator();
        do {
            if (!it2.hasNext()) {
                element$iv = null;
                break;
            }
            element$iv = it2.next();
        } while (!Intrinsics.areEqual(((Element) element$iv).tagName(), "a"));
        Element element = (Element) element$iv;
        String string = (element == null || (strOwnText = element.ownText()) == null || (strSubstringBefore$default = StringsKt.substringBefore$default(strOwnText, "(", (String) null, 2, (Object) null)) == null) ? null : StringsKt.trim(strSubstringBefore$default).toString();
        String str = "";
        if (string == null) {
            string = "";
        }
        String title = string;
        Cinemacity cinemacity = this;
        Iterable $this$firstOrNull$iv2 = $this$toSearchResult.children();
        Iterator it3 = $this$firstOrNull$iv2.iterator();
        do {
            if (!it3.hasNext()) {
                element$iv2 = null;
                break;
            }
            element$iv2 = it3.next();
        } while (!Intrinsics.areEqual(((Element) element$iv2).tagName(), "a"));
        Element element2 = (Element) element$iv2;
        if (element2 != null && (strAttr = element2.attr("href")) != null) {
            str = strAttr;
        }
        String href = MainAPIKt.fixUrl(cinemacity, str);
        final String posterUrl = MainAPIKt.fixUrlNull(this, $this$toSearchResult.select("div.dar-short_bg a ").attr("href"));
        Element elementSelectFirst2 = $this$toSearchResult.selectFirst("span.rating-color");
        final String score = elementSelectFirst2 != null ? elementSelectFirst2.ownText() : null;
        Element elementSelectFirst3 = $this$toSearchResult.selectFirst("div.dar-short_bg.e-cover > div span:nth-child(2) > a");
        final String quality = "HD";
        if (elementSelectFirst3 == null || (it = elementSelectFirst3.text()) == null) {
            elementSelectFirst = $this$toSearchResult.selectFirst("div.dar-short_bg.e-cover > div > span");
            z = false;
            if (elementSelectFirst != null && (strText = elementSelectFirst.text()) != null && StringsKt.contains(strText, "TS", true)) {
                z = true;
            }
            if (z) {
                quality = "TS";
            }
        } else {
            String it4 = StringsKt.isBlank(it) ? null : it;
            if (it4 == null) {
                elementSelectFirst = $this$toSearchResult.selectFirst("div.dar-short_bg.e-cover > div > span");
                z = false;
                if (elementSelectFirst != null) {
                    z = true;
                }
                if (z) {
                    quality = "TS";
                }
            } else if (StringsKt.contains(it4, "TS", true)) {
                quality = "TS";
            }
        }
        TvType type = StringsKt.contains(href, "/tv-series/", true) ? TvType.TvSeries : TvType.Movie;
        return MainAPIKt.newMovieSearchResponse$default(this, title, href, type, false, new Function1() { // from class: com.Cinemacity.Cinemacity$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                return Cinemacity.toSearchResult$lambda$5(posterUrl, score, quality, (MovieSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResult$lambda$5(String $posterUrl, String $score, String $quality, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($posterUrl);
        $this$newMovieSearchResponse.setPosterHeaders(INSTANCE.getCfHeaders());
        $this$newMovieSearchResponse.setScore(Score.Companion.from10($score));
        $this$newMovieSearchResponse.setQuality(MainAPIKt.getQualityFromString($quality));
        return Unit.INSTANCE;
    }

    private final SearchResponse toFallbackSearchResult(com.fleeksoft.ksoup.nodes.Element $this$toFallbackSearchResult) {
        String strAttr;
        String strOwnText;
        String strSubstringBefore$default;
        com.fleeksoft.ksoup.nodes.Element titleElement = $this$toFallbackSearchResult.selectFirst("a:not([data-highslide])");
        String string = (titleElement == null || (strOwnText = titleElement.ownText()) == null || (strSubstringBefore$default = StringsKt.substringBefore$default(strOwnText, "(", (String) null, 2, (Object) null)) == null) ? null : StringsKt.trim(strSubstringBefore$default).toString();
        String str = "";
        if (string == null) {
            string = "";
        }
        String title = string;
        Cinemacity cinemacity = this;
        if (titleElement != null && (strAttr = titleElement.attr("href")) != null) {
            str = strAttr;
        }
        String href = MainAPIKt.fixUrl(cinemacity, str);
        Cinemacity cinemacity2 = this;
        com.fleeksoft.ksoup.nodes.Element elementSelectFirst = $this$toFallbackSearchResult.selectFirst("img");
        final String posterUrl = MainAPIKt.fixUrlNull(cinemacity2, elementSelectFirst != null ? elementSelectFirst.attr("src") : null);
        com.fleeksoft.ksoup.nodes.Element elementSelectFirst2 = $this$toFallbackSearchResult.selectFirst("span.rating-color1");
        final String score = elementSelectFirst2 != null ? elementSelectFirst2.text() : null;
        TvType type = StringsKt.contains(href, "/tv-series/", true) ? TvType.TvSeries : TvType.Movie;
        return MainAPIKt.newMovieSearchResponse$default(this, title, href, type, false, new Function1() { // from class: com.Cinemacity.Cinemacity$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return Cinemacity.toFallbackSearchResult$lambda$0(posterUrl, score, (MovieSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toFallbackSearchResult$lambda$0(String $posterUrl, String $score, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($posterUrl);
        $this$newMovieSearchResponse.setPosterHeaders(INSTANCE.getCfHeaders());
        $this$newMovieSearchResponse.setScore(Score.Companion.from10($score));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x047a  */
    /* JADX WARN: Code duplicated, block: B:114:0x04a2 A[Catch: all -> 0x04d4, TryCatch #19 {all -> 0x04d4, blocks: (B:112:0x049e, B:114:0x04a2, B:116:0x04aa, B:118:0x04ae, B:120:0x04b2, B:122:0x04b7, B:128:0x04c3, B:129:0x04ca, B:71:0x0415, B:83:0x044d, B:86:0x0454, B:103:0x047c, B:101:0x0473, B:82:0x0443, B:70:0x040b), top: B:256:0x040b }] */
    /* JADX WARN: Code duplicated, block: B:115:0x04a9  */
    /* JADX WARN: Code duplicated, block: B:118:0x04ae A[Catch: all -> 0x04d4, TryCatch #19 {all -> 0x04d4, blocks: (B:112:0x049e, B:114:0x04a2, B:116:0x04aa, B:118:0x04ae, B:120:0x04b2, B:122:0x04b7, B:128:0x04c3, B:129:0x04ca, B:71:0x0415, B:83:0x044d, B:86:0x0454, B:103:0x047c, B:101:0x0473, B:82:0x0443, B:70:0x040b), top: B:256:0x040b }] */
    /* JADX WARN: Code duplicated, block: B:119:0x04b1  */
    /* JADX WARN: Code duplicated, block: B:122:0x04b7 A[Catch: all -> 0x04d4, TryCatch #19 {all -> 0x04d4, blocks: (B:112:0x049e, B:114:0x04a2, B:116:0x04aa, B:118:0x04ae, B:120:0x04b2, B:122:0x04b7, B:128:0x04c3, B:129:0x04ca, B:71:0x0415, B:83:0x044d, B:86:0x0454, B:103:0x047c, B:101:0x0473, B:82:0x0443, B:70:0x040b), top: B:256:0x040b }] */
    /* JADX WARN: Code duplicated, block: B:126:0x04c0  */
    /* JADX WARN: Code duplicated, block: B:128:0x04c3 A[Catch: all -> 0x04d4, TryCatch #19 {all -> 0x04d4, blocks: (B:112:0x049e, B:114:0x04a2, B:116:0x04aa, B:118:0x04ae, B:120:0x04b2, B:122:0x04b7, B:128:0x04c3, B:129:0x04ca, B:71:0x0415, B:83:0x044d, B:86:0x0454, B:103:0x047c, B:101:0x0473, B:82:0x0443, B:70:0x040b), top: B:256:0x040b }] */
    /* JADX WARN: Code duplicated, block: B:143:0x0561  */
    /* JADX WARN: Code duplicated, block: B:146:0x059c  */
    /* JADX WARN: Code duplicated, block: B:148:0x05b5  */
    /* JADX WARN: Code duplicated, block: B:154:0x05cc  */
    /* JADX WARN: Code duplicated, block: B:157:0x05e4  */
    /* JADX WARN: Code duplicated, block: B:159:0x05e7  */
    /* JADX WARN: Code duplicated, block: B:161:0x0639 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:162:0x063a  */
    /* JADX WARN: Code duplicated, block: B:165:0x0666  */
    /* JADX WARN: Code duplicated, block: B:171:0x0678  */
    /* JADX WARN: Code duplicated, block: B:174:0x0698  */
    /* JADX WARN: Code duplicated, block: B:177:0x07d6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:178:0x07d7  */
    /* JADX WARN: Code duplicated, block: B:181:0x0808  */
    /* JADX WARN: Code duplicated, block: B:183:0x0810  */
    /* JADX WARN: Code duplicated, block: B:184:0x0815  */
    /* JADX WARN: Code duplicated, block: B:204:0x0875  */
    /* JADX WARN: Code duplicated, block: B:216:0x08ad  */
    /* JADX WARN: Code duplicated, block: B:226:0x08c9 A[Catch: Exception -> 0x08e3, TRY_LEAVE, TryCatch #7 {Exception -> 0x08e3, blocks: (B:214:0x08a7, B:217:0x08ae, B:226:0x08c9, B:225:0x08c3, B:213:0x089d, B:220:0x08b4), top: B:262:0x089d, inners: #9, #25 }] */
    /* JADX WARN: Code duplicated, block: B:237:0x08ee  */
    /* JADX WARN: Code duplicated, block: B:244:0x0926  */
    /* JADX WARN: Code duplicated, block: B:246:0x0940  */
    /* JADX WARN: Code duplicated, block: B:250:0x0959  */
    /* JADX WARN: Code duplicated, block: B:252:0x02bc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:265:0x041e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:286:0x0878 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:294:0x045a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:296:0x08b4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:300:0x0945 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:303:0x0283 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:34:0x0268  */
    /* JADX WARN: Code duplicated, block: B:36:0x027e  */
    /* JADX WARN: Code duplicated, block: B:40:0x0297  */
    /* JADX WARN: Code duplicated, block: B:42:0x029e  */
    /* JADX WARN: Code duplicated, block: B:51:0x0399 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:52:0x039a  */
    /* JADX WARN: Code duplicated, block: B:56:0x03bb  */
    /* JADX WARN: Code duplicated, block: B:57:0x03c4  */
    /* JADX WARN: Code duplicated, block: B:73:0x041b  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:85:0x0453  */
    @Nullable
    public Object search(@NotNull String query, int page, @NotNull Continuation<? super SearchResponseList> continuation) throws Throwable {
        C00061 c00061;
        char c;
        Object authCookie;
        String query2;
        Object obj;
        String cfCookies;
        String mainSearchUrl;
        int page2;
        String authCookie2;
        String cfCookies2;
        Map<String, String> map;
        Document doc;
        Iterable $this$mapNotNull$iv;
        Collection destination$iv$iv;
        List res;
        Ref.ObjectRef finalHash;
        C00061 c00062;
        Object obj2;
        Map<String, String> map2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object authCookie3;
        Object obj6;
        String str;
        List res2;
        String html;
        Document doc2;
        Ref.ObjectRef finalHash2;
        Cinemacity $this$search_u24lambda_u242;
        String query3;
        C00061 c00063;
        int page3;
        Object obj7;
        Cinemacity $this$search_u24lambda_u243;
        Object obj8;
        int i;
        String savedLogin;
        String authCookie4;
        int page4;
        String savedLogin2;
        Map<String, String> map3;
        String query4;
        Object $result;
        SearchResponse searchResult;
        String savedLogin3;
        Ref.ObjectRef finalHash3;
        Map<String, String> map4;
        int page5;
        List res3;
        String mainSearchUrl2;
        String savedLogin4;
        String loginPart;
        Document doc3;
        String html2;
        String savedLogin5;
        MatchResult matchResultFind$default;
        String it;
        Object objAppGet;
        String savedLogin6;
        String html3;
        Cinemacity $this$search_u24lambda_u244;
        Ref.ObjectRef objectRef;
        String cfCookies3;
        Ref.ObjectRef finalHash4;
        List groupValues;
        String value$iv;
        int page6;
        Object obj9;
        Object objDecodeFromString;
        DeserializationStrategy deserializationStrategy;
        String value$iv$iv;
        Map bootJson;
        Object obj10;
        String hash;
        String str2;
        boolean z;
        int page7;
        String query5;
        MatchResult matchResultFind$default2;
        List groupValues2;
        String str3;
        String json;
        Object obj11;
        Object objDecodeFromString2;
        DeserializationStrategy deserializationStrategy2;
        Map map5;
        String contentHtml;
        com.fleeksoft.ksoup.nodes.Document fallbackDoc;
        Collection destination$iv$iv2;
        SearchResponse fallbackSearchResult;
        String str4;
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
        Object $result2 = c00061.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        String str5 = "";
        switch (c00061.label) {
            case 0:
                c = 2;
                ResultKt.throwOnFailure($result2);
                String savedLogin7 = CinemacityPlugin.INSTANCE.getLoginCookies();
                String str6 = savedLogin7;
                if (StringsKt.isBlank(str6)) {
                    str6 = FALLBACK_LOGIN_COOKIE;
                }
                String loginPart2 = str6;
                String cfCookies4 = CinemacityPlugin.INSTANCE.getCfCookies();
                authCookie = !StringsKt.isBlank(cfCookies4) ? loginPart2 + "; " + cfCookies4 : loginPart2;
                Map<String, String> mapMapOf = MapsKt.mapOf(TuplesKt.to("Cookie", authCookie));
                String mainSearchUrl3 = getMainUrl() + "/?do=search&subaction=search&search_start=0&full_search=0&story=" + query;
                c00061.L$0 = query;
                c00061.L$1 = SpillingKt.nullOutSpilledVariable(savedLogin7);
                c00061.L$2 = SpillingKt.nullOutSpilledVariable(loginPart2);
                c00061.L$3 = SpillingKt.nullOutSpilledVariable(cfCookies4);
                c00061.L$4 = authCookie;
                c00061.L$5 = mapMapOf;
                c00061.L$6 = SpillingKt.nullOutSpilledVariable(mainSearchUrl3);
                c00061.I$0 = page;
                c00061.label = 1;
                Object objAppGet2 = appGet(mainSearchUrl3, mapMapOf, c00061);
                if (objAppGet2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                query2 = query;
                obj = objAppGet2;
                cfCookies = loginPart2;
                mainSearchUrl = mainSearchUrl3;
                page2 = page;
                authCookie2 = savedLogin7;
                cfCookies2 = cfCookies4;
                map = mapMapOf;
                doc = ((NiceResponse) obj).getDocument();
                $this$mapNotNull$iv = doc.select("div.dar-short_item");
                destination$iv$iv = new ArrayList();
                for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                    Iterable $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                    searchResult = toSearchResult((Element) element$iv$iv$iv);
                    if (searchResult != null) {
                        destination$iv$iv.add(searchResult);
                    }
                    $this$mapNotNull$iv = $this$mapNotNull$iv2;
                }
                res = (List) destination$iv$iv;
                if (!res.isEmpty()) {
                    return MainAPIKt.toNewSearchResponseList$default(res, (Boolean) null, 1, (Object) null);
                }
                finalHash = new Ref.ObjectRef();
                finalHash.element = CinemacityPlugin.INSTANCE.getUserHash();
                if (StringsKt.isBlank((CharSequence) finalHash.element)) {
                    try {
                        Result.Companion companion = Result.Companion;
                        $this$search_u24lambda_u242 = this;
                        try {
                            Requests app = MainActivityKt.getApp();
                            String str7 = $this$search_u24lambda_u242.getMainUrl() + "/engine/ajax/controller.php?mod=ccdeviceguard&action=boot";
                            Pair[] pairArr = new Pair[3];
                            pairArr[0] = TuplesKt.to("X-Requested-With", "XMLHttpRequest");
                            pairArr[1] = TuplesKt.to("Referer", $this$search_u24lambda_u242.getMainUrl() + '/');
                            pairArr[c] = TuplesKt.to("Cookie", authCookie);
                            Map mapMapOf2 = MapsKt.mapOf(pairArr);
                            CinemacityCFBypassInterceptor cinemacityCFBypassInterceptor = CinemacityCFBypassInterceptor.INSTANCE;
                            c00061.L$0 = query2;
                            c00061.L$1 = SpillingKt.nullOutSpilledVariable(authCookie2);
                            c00061.L$2 = SpillingKt.nullOutSpilledVariable(cfCookies);
                            c00061.L$3 = SpillingKt.nullOutSpilledVariable(cfCookies2);
                            c00061.L$4 = authCookie;
                            c00061.L$5 = map;
                            c00061.L$6 = SpillingKt.nullOutSpilledVariable(mainSearchUrl);
                            c00061.L$7 = doc;
                            c00061.L$8 = SpillingKt.nullOutSpilledVariable(res);
                            c00061.L$9 = finalHash;
                            c00061.L$10 = SpillingKt.nullOutSpilledVariable($this$search_u24lambda_u242);
                            c00061.I$0 = page2;
                            c00061.label = 2;
                            obj4 = "XMLHttpRequest";
                            obj5 = "X-Requested-With";
                            authCookie3 = authCookie;
                            query3 = query2;
                            map2 = map;
                            obj3 = "Referer";
                            obj6 = "Cookie";
                            str = "dle_login_hash\\s*=\\s*'([^']+)'";
                            c00063 = c00061;
                            obj2 = coroutine_suspended;
                            page3 = page2;
                            try {
                                obj7 = Requests.get$default(app, str7, mapMapOf2, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, cinemacityCFBypassInterceptor, false, (ResponseParser) null, c00063, 3580, (Object) null);
                                c00062 = c00063;
                                if (obj7 == obj2) {
                                    return obj2;
                                }
                                $this$search_u24lambda_u243 = $this$search_u24lambda_u242;
                                obj8 = obj7;
                                res2 = res;
                                page2 = page3;
                                html = mainSearchUrl;
                                i = 0;
                                doc2 = doc;
                                finalHash2 = finalHash;
                                savedLogin = authCookie2;
                                authCookie4 = cfCookies;
                                try {
                                    NiceResponse bootResp = (NiceResponse) obj8;
                                    AppUtils appUtils = AppUtils.INSTANCE;
                                    value$iv = bootResp.getText();
                                    if (value$iv == null) {
                                        page6 = page2;
                                        objDecodeFromString = null;
                                    } else {
                                        try {
                                            Result.Companion companion2 = Result.Companion;
                                            try {
                                                page6 = page2;
                                                try {
                                                    KType kTypeTypeOf = Reflection.typeOf(Map.class, KTypeProjection.Companion.invariant(Reflection.typeOf(String.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Object.class)));
                                                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                                    obj9 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                                                    break;
                                                } catch (Throwable th) {
                                                    th = th;
                                                    try {
                                                        try {
                                                            Result.Companion companion3 = Result.Companion;
                                                            obj9 = Result.constructor-impl(ResultKt.createFailure(th));
                                                        } catch (Exception e) {
                                                            objDecodeFromString = null;
                                                            bootJson = (Map) objDecodeFromString;
                                                            if (bootJson != null) {
                                                                obj10 = bootJson.get("user_hash");
                                                            } else {
                                                                obj10 = null;
                                                            }
                                                            if (obj10 instanceof String) {
                                                                hash = (String) obj10;
                                                            } else {
                                                                hash = null;
                                                            }
                                                            str2 = hash;
                                                            if (str2 != null) {
                                                                z = true;
                                                            } else {
                                                                z = true;
                                                            }
                                                            if (!z) {
                                                                finalHash2.element = hash;
                                                                CinemacityPlugin.INSTANCE.setUserHash(hash);
                                                            }
                                                            Result.constructor-impl(Unit.INSTANCE);
                                                            page2 = page6;
                                                            page4 = page2;
                                                            savedLogin2 = savedLogin;
                                                            map3 = map2;
                                                            query4 = query3;
                                                            $result = authCookie3;
                                                            if (StringsKt.isBlank((CharSequence) finalHash2.element)) {
                                                                html2 = doc2.html();
                                                                savedLogin5 = savedLogin2;
                                                                matchResultFind$default = Regex.find$default(new Regex(str), html2, 0, 2, (Object) null);
                                                                if (matchResultFind$default != null) {
                                                                    it = doc2.select("input[name=dle_hash]").attr("value");
                                                                    if (StringsKt.isBlank(it)) {
                                                                        it = null;
                                                                    }
                                                                    if (it == null) {
                                                                        Cinemacity $this$search_u24lambda_u245 = this;
                                                                        String mainUrl = $this$search_u24lambda_u245.getMainUrl();
                                                                        c00062.L$0 = query4;
                                                                        c00062.L$1 = SpillingKt.nullOutSpilledVariable(savedLogin5);
                                                                        c00062.L$2 = SpillingKt.nullOutSpilledVariable(authCookie4);
                                                                        c00062.L$3 = SpillingKt.nullOutSpilledVariable(cfCookies2);
                                                                        c00062.L$4 = $result;
                                                                        c00062.L$5 = SpillingKt.nullOutSpilledVariable(map3);
                                                                        c00062.L$6 = SpillingKt.nullOutSpilledVariable(html);
                                                                        c00062.L$7 = SpillingKt.nullOutSpilledVariable(doc2);
                                                                        c00062.L$8 = SpillingKt.nullOutSpilledVariable(res2);
                                                                        c00062.L$9 = finalHash2;
                                                                        c00062.L$10 = SpillingKt.nullOutSpilledVariable(html2);
                                                                        c00062.L$11 = SpillingKt.nullOutSpilledVariable($this$search_u24lambda_u245);
                                                                        c00062.L$12 = finalHash2;
                                                                        c00062.I$0 = page4;
                                                                        c00062.label = 3;
                                                                        objAppGet = $this$search_u24lambda_u245.appGet(mainUrl, map3, c00062);
                                                                        if (objAppGet == obj2) {
                                                                            return obj2;
                                                                        }
                                                                        savedLogin6 = savedLogin5;
                                                                        html3 = html2;
                                                                        $this$search_u24lambda_u244 = null;
                                                                        objectRef = finalHash2;
                                                                        cfCookies3 = cfCookies2;
                                                                        String mainHtml = ((NiceResponse) objAppGet).getDocument().html();
                                                                        String query6 = query4;
                                                                        Object authCookie5 = $result;
                                                                        Map<String, String> map6 = map3;
                                                                        matchResultFind$default2 = Regex.find$default(new Regex(str), mainHtml, 0, 2, (Object) null);
                                                                        if (matchResultFind$default2 != null) {
                                                                            it = "";
                                                                        } else {
                                                                            it = "";
                                                                        }
                                                                        query4 = query6;
                                                                        finalHash4 = finalHash2;
                                                                        $result = authCookie5;
                                                                        map3 = map6;
                                                                        cfCookies2 = cfCookies3;
                                                                        finalHash2 = objectRef;
                                                                    }
                                                                    finalHash2.element = it;
                                                                    finalHash3 = finalHash4;
                                                                    savedLogin3 = savedLogin6;
                                                                    map4 = map3;
                                                                    page5 = page4;
                                                                    res3 = res2;
                                                                    mainSearchUrl2 = html;
                                                                    loginPart = authCookie4;
                                                                    doc3 = doc2;
                                                                    savedLogin4 = cfCookies2;
                                                                } else {
                                                                    it = doc2.select("input[name=dle_hash]").attr("value");
                                                                    if (StringsKt.isBlank(it)) {
                                                                        it = null;
                                                                    }
                                                                    if (it == null) {
                                                                        Cinemacity $this$search_u24lambda_u246 = this;
                                                                        String mainUrl2 = $this$search_u24lambda_u246.getMainUrl();
                                                                        c00062.L$0 = query4;
                                                                        c00062.L$1 = SpillingKt.nullOutSpilledVariable(savedLogin5);
                                                                        c00062.L$2 = SpillingKt.nullOutSpilledVariable(authCookie4);
                                                                        c00062.L$3 = SpillingKt.nullOutSpilledVariable(cfCookies2);
                                                                        c00062.L$4 = $result;
                                                                        c00062.L$5 = SpillingKt.nullOutSpilledVariable(map3);
                                                                        c00062.L$6 = SpillingKt.nullOutSpilledVariable(html);
                                                                        c00062.L$7 = SpillingKt.nullOutSpilledVariable(doc2);
                                                                        c00062.L$8 = SpillingKt.nullOutSpilledVariable(res2);
                                                                        c00062.L$9 = finalHash2;
                                                                        c00062.L$10 = SpillingKt.nullOutSpilledVariable(html2);
                                                                        c00062.L$11 = SpillingKt.nullOutSpilledVariable($this$search_u24lambda_u246);
                                                                        c00062.L$12 = finalHash2;
                                                                        c00062.I$0 = page4;
                                                                        c00062.label = 3;
                                                                        objAppGet = $this$search_u24lambda_u246.appGet(mainUrl2, map3, c00062);
                                                                        if (objAppGet == obj2) {
                                                                            return obj2;
                                                                        }
                                                                        savedLogin6 = savedLogin5;
                                                                        html3 = html2;
                                                                        $this$search_u24lambda_u244 = null;
                                                                        objectRef = finalHash2;
                                                                        cfCookies3 = cfCookies2;
                                                                        String mainHtml2 = ((NiceResponse) objAppGet).getDocument().html();
                                                                        String query7 = query4;
                                                                        Object authCookie6 = $result;
                                                                        Map<String, String> map7 = map3;
                                                                        matchResultFind$default2 = Regex.find$default(new Regex(str), mainHtml2, 0, 2, (Object) null);
                                                                        if (matchResultFind$default2 != null) {
                                                                            it = "";
                                                                        } else {
                                                                            it = "";
                                                                        }
                                                                        query4 = query7;
                                                                        finalHash4 = finalHash2;
                                                                        $result = authCookie6;
                                                                        map3 = map7;
                                                                        cfCookies2 = cfCookies3;
                                                                        finalHash2 = objectRef;
                                                                    }
                                                                    finalHash2.element = it;
                                                                    finalHash3 = finalHash4;
                                                                    savedLogin3 = savedLogin6;
                                                                    map4 = map3;
                                                                    page5 = page4;
                                                                    res3 = res2;
                                                                    mainSearchUrl2 = html;
                                                                    loginPart = authCookie4;
                                                                    doc3 = doc2;
                                                                    savedLogin4 = cfCookies2;
                                                                }
                                                                savedLogin6 = savedLogin5;
                                                                finalHash4 = finalHash2;
                                                                finalHash2.element = it;
                                                                finalHash3 = finalHash4;
                                                                savedLogin3 = savedLogin6;
                                                                map4 = map3;
                                                                page5 = page4;
                                                                res3 = res2;
                                                                mainSearchUrl2 = html;
                                                                loginPart = authCookie4;
                                                                doc3 = doc2;
                                                                savedLogin4 = cfCookies2;
                                                            } else {
                                                                savedLogin3 = savedLogin2;
                                                                finalHash3 = finalHash2;
                                                                map4 = map3;
                                                                page5 = page4;
                                                                res3 = res2;
                                                                mainSearchUrl2 = html;
                                                                savedLogin4 = cfCookies2;
                                                                loginPart = authCookie4;
                                                                doc3 = doc2;
                                                            }
                                                            String ajaxUrl = getMainUrl() + "/engine/mods/dle_search/ajax.php";
                                                            Requests app2 = MainActivityKt.getApp();
                                                            Map mapMapOf3 = MapsKt.mapOf(new Pair[]{TuplesKt.to(obj5, obj4), TuplesKt.to("Origin", getMainUrl()), TuplesKt.to(obj3, getMainUrl() + '/'), TuplesKt.to("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8"), TuplesKt.to(obj6, $result)});
                                                            Map mapMapOf4 = MapsKt.mapOf(new Pair[]{TuplesKt.to("story", query4), TuplesKt.to("dle_hash", finalHash3.element), TuplesKt.to("thisUrl", "1")});
                                                            CinemacityCFBypassInterceptor cinemacityCFBypassInterceptor2 = CinemacityCFBypassInterceptor.INSTANCE;
                                                            c00062.L$0 = SpillingKt.nullOutSpilledVariable(query4);
                                                            c00062.L$1 = SpillingKt.nullOutSpilledVariable(savedLogin3);
                                                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(loginPart);
                                                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(savedLogin4);
                                                            c00062.L$4 = SpillingKt.nullOutSpilledVariable($result);
                                                            c00062.L$5 = SpillingKt.nullOutSpilledVariable(map4);
                                                            c00062.L$6 = SpillingKt.nullOutSpilledVariable(mainSearchUrl2);
                                                            c00062.L$7 = SpillingKt.nullOutSpilledVariable(doc3);
                                                            c00062.L$8 = SpillingKt.nullOutSpilledVariable(res3);
                                                            c00062.L$9 = SpillingKt.nullOutSpilledVariable(finalHash3);
                                                            c00062.L$10 = SpillingKt.nullOutSpilledVariable(ajaxUrl);
                                                            c00062.L$11 = null;
                                                            c00062.L$12 = null;
                                                            c00062.I$0 = page5;
                                                            c00062.label = 4;
                                                            $result2 = Requests.post$default(app2, ajaxUrl, mapMapOf3, (String) null, (Map) null, (Map) null, mapMapOf4, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, cinemacityCFBypassInterceptor2, false, (ResponseParser) null, c00062, 57308, (Object) null);
                                                            if ($result2 == obj2) {
                                                                return obj2;
                                                            }
                                                            page7 = page5;
                                                            query5 = query4;
                                                            NiceResponse fallbackResponse = (NiceResponse) $result2;
                                                            json = fallbackResponse.getText();
                                                            if (StringsKt.contains$default(json, "\"content\"", false, 2, (Object) null)) {
                                                                return MainAPIKt.toNewSearchResponseList$default(CollectionsKt.emptyList(), (Boolean) null, 1, (Object) null);
                                                            }
                                                            AppUtils appUtils2 = AppUtils.INSTANCE;
                                                            if (json == null) {
                                                                try {
                                                                    Result.Companion companion4 = Result.Companion;
                                                                    try {
                                                                        try {
                                                                            try {
                                                                                KType kTypeTypeOf2 = Reflection.typeOf(Map.class, KTypeProjection.Companion.invariant(Reflection.typeOf(String.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(String.class)));
                                                                                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                                                                obj11 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                                                                                break;
                                                                            } catch (Throwable th2) {
                                                                                th = th2;
                                                                                try {
                                                                                    Result.Companion companion5 = Result.Companion;
                                                                                    obj11 = Result.constructor-impl(ResultKt.createFailure(th));
                                                                                } catch (Exception e2) {
                                                                                    objDecodeFromString2 = null;
                                                                                    map5 = (Map) objDecodeFromString2;
                                                                                    if (map5 != null) {
                                                                                        str5 = str4;
                                                                                    }
                                                                                    contentHtml = str5;
                                                                                    fallbackDoc = Ksoup.parse$default(Ksoup.INSTANCE, contentHtml, (String) null, 2, (Object) null);
                                                                                    Iterable $this$mapNotNull$iv3 = fallbackDoc.select("div.dle-fast_item");
                                                                                    destination$iv$iv2 = new ArrayList();
                                                                                    for (Object element$iv$iv$iv2 : $this$mapNotNull$iv3) {
                                                                                        String contentHtml2 = contentHtml;
                                                                                        com.fleeksoft.ksoup.nodes.Document fallbackDoc2 = fallbackDoc;
                                                                                        fallbackSearchResult = toFallbackSearchResult((com.fleeksoft.ksoup.nodes.Element) element$iv$iv$iv2);
                                                                                        if (fallbackSearchResult != null) {
                                                                                            destination$iv$iv2.add(fallbackSearchResult);
                                                                                        }
                                                                                        contentHtml = contentHtml2;
                                                                                        fallbackDoc = fallbackDoc2;
                                                                                    }
                                                                                    List fallbackRes = (List) destination$iv$iv2;
                                                                                    return MainAPIKt.toNewSearchResponseList$default(fallbackRes, (Boolean) null, 1, (Object) null);
                                                                                }
                                                                            }
                                                                        } catch (Throwable th3) {
                                                                            th = th3;
                                                                        }
                                                                    } catch (Throwable th4) {
                                                                        th = th4;
                                                                    }
                                                                } catch (Throwable th5) {
                                                                    th = th5;
                                                                }
                                                                if (Result.exceptionOrNull-impl(obj11) == null) {
                                                                    try {
                                                                        Result.Companion companion6 = Result.Companion;
                                                                        try {
                                                                            obj11 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Map.class), (List) null, 2, (Object) null));
                                                                            break;
                                                                        } catch (Throwable th6) {
                                                                            th = th6;
                                                                            try {
                                                                                Result.Companion companion7 = Result.Companion;
                                                                                obj11 = Result.constructor-impl(ResultKt.createFailure(th));
                                                                            } catch (Exception e3) {
                                                                                objDecodeFromString2 = null;
                                                                            }
                                                                        }
                                                                    } catch (Throwable th7) {
                                                                        th = th7;
                                                                    }
                                                                }
                                                                if (Result.isFailure-impl(obj11)) {
                                                                    obj11 = null;
                                                                }
                                                                deserializationStrategy2 = (KSerializer) obj11;
                                                                if (deserializationStrategy2 != null) {
                                                                    try {
                                                                        objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, json);
                                                                    } catch (SerializationException e4) {
                                                                        ArchComponentExtKt.logError(e4);
                                                                        ObjectMapper $this$readValue$iv$iv$iv = MainAPIKt.getMapper();
                                                                        objDecodeFromString2 = $this$readValue$iv$iv$iv.readValue(json, new TypeReference<Map<String, ? extends String>>() { // from class: com.Cinemacity.Cinemacity$search$$inlined$tryParseJson$1
                                                                        });
                                                                    } catch (Throwable th8) {
                                                                        ObjectMapper $this$readValue$iv$iv$iv2 = MainAPIKt.getMapper();
                                                                        objDecodeFromString2 = $this$readValue$iv$iv$iv2.readValue(json, new TypeReference<Map<String, ? extends String>>() { // from class: com.Cinemacity.Cinemacity$search$$inlined$tryParseJson$1
                                                                        });
                                                                    }
                                                                } else {
                                                                    ObjectMapper $this$readValue$iv$iv$iv3 = MainAPIKt.getMapper();
                                                                    objDecodeFromString2 = $this$readValue$iv$iv$iv3.readValue(json, new TypeReference<Map<String, ? extends String>>() { // from class: com.Cinemacity.Cinemacity$search$$inlined$tryParseJson$1
                                                                    });
                                                                }
                                                                break;
                                                            } else {
                                                                objDecodeFromString2 = null;
                                                            }
                                                            map5 = (Map) objDecodeFromString2;
                                                            if (map5 != null) {
                                                                str5 = str4;
                                                            }
                                                            contentHtml = str5;
                                                            fallbackDoc = Ksoup.parse$default(Ksoup.INSTANCE, contentHtml, (String) null, 2, (Object) null);
                                                            Iterable $this$mapNotNull$iv4 = fallbackDoc.select("div.dle-fast_item");
                                                            destination$iv$iv2 = new ArrayList();
                                                            while (r22.hasNext()) {
                                                                String contentHtml3 = contentHtml;
                                                                com.fleeksoft.ksoup.nodes.Document fallbackDoc3 = fallbackDoc;
                                                                fallbackSearchResult = toFallbackSearchResult((com.fleeksoft.ksoup.nodes.Element) element$iv$iv$iv2);
                                                                if (fallbackSearchResult != null) {
                                                                    destination$iv$iv2.add(fallbackSearchResult);
                                                                }
                                                                contentHtml = contentHtml3;
                                                                fallbackDoc = fallbackDoc3;
                                                            }
                                                            List fallbackRes2 = (List) destination$iv$iv2;
                                                            return MainAPIKt.toNewSearchResponseList$default(fallbackRes2, (Boolean) null, 1, (Object) null);
                                                        }
                                                    } catch (Throwable th9) {
                                                        th = th9;
                                                        page2 = page6;
                                                        cfCookies = authCookie4;
                                                        authCookie2 = savedLogin;
                                                        query2 = query3;
                                                        Object $result3 = Result.Companion;
                                                        Result.constructor-impl(ResultKt.createFailure(th));
                                                        query3 = query2;
                                                        savedLogin = authCookie2;
                                                        authCookie4 = cfCookies;
                                                    }
                                                }
                                            } catch (Throwable th10) {
                                                th = th10;
                                                page6 = page2;
                                            }
                                        } catch (Throwable th11) {
                                            th = th11;
                                            page6 = page2;
                                        }
                                        if (Result.exceptionOrNull-impl(obj9) != null) {
                                            try {
                                                Result.Companion companion8 = Result.Companion;
                                                try {
                                                    obj9 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Map.class), (List) null, 2, (Object) null));
                                                    break;
                                                } catch (Throwable th12) {
                                                    th = th12;
                                                    try {
                                                        Result.Companion companion9 = Result.Companion;
                                                        obj9 = Result.constructor-impl(ResultKt.createFailure(th));
                                                    } catch (Exception e5) {
                                                        objDecodeFromString = null;
                                                    }
                                                }
                                            } catch (Throwable th13) {
                                                th = th13;
                                            }
                                        }
                                        if (Result.isFailure-impl(obj9)) {
                                            obj9 = null;
                                        }
                                        deserializationStrategy = (KSerializer) obj9;
                                        if (deserializationStrategy != null) {
                                            try {
                                                value$iv$iv = value$iv;
                                                try {
                                                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv$iv);
                                                } catch (SerializationException e6) {
                                                    e$iv$iv = e6;
                                                    ArchComponentExtKt.logError((Throwable) e$iv$iv);
                                                    ObjectMapper $this$readValue$iv$iv$iv4 = MainAPIKt.getMapper();
                                                    String content$iv$iv$iv = value$iv$iv;
                                                    objDecodeFromString = $this$readValue$iv$iv$iv4.readValue(content$iv$iv$iv, new TypeReference<Map<String, ? extends Object>>() { // from class: com.Cinemacity.Cinemacity$search$lambda$2$$inlined$tryParseJson$1
                                                    });
                                                } catch (Throwable th14) {
                                                    ObjectMapper $this$readValue$iv$iv$iv5 = MainAPIKt.getMapper();
                                                    String content$iv$iv$iv2 = value$iv$iv;
                                                    objDecodeFromString = $this$readValue$iv$iv$iv5.readValue(content$iv$iv$iv2, new TypeReference<Map<String, ? extends Object>>() { // from class: com.Cinemacity.Cinemacity$search$lambda$2$$inlined$tryParseJson$1
                                                    });
                                                }
                                            } catch (SerializationException e7) {
                                                e$iv$iv = e7;
                                                value$iv$iv = value$iv;
                                            } catch (Throwable th15) {
                                                value$iv$iv = value$iv;
                                            }
                                        } else {
                                            value$iv$iv = value$iv;
                                        }
                                        ObjectMapper $this$readValue$iv$iv$iv6 = MainAPIKt.getMapper();
                                        String content$iv$iv$iv3 = value$iv$iv;
                                        objDecodeFromString = $this$readValue$iv$iv$iv6.readValue(content$iv$iv$iv3, new TypeReference<Map<String, ? extends Object>>() { // from class: com.Cinemacity.Cinemacity$search$lambda$2$$inlined$tryParseJson$1
                                        });
                                    }
                                    bootJson = (Map) objDecodeFromString;
                                    if (bootJson != null) {
                                        obj10 = bootJson.get("user_hash");
                                    } else {
                                        obj10 = null;
                                    }
                                    if (obj10 instanceof String) {
                                        hash = (String) obj10;
                                    } else {
                                        hash = null;
                                    }
                                    str2 = hash;
                                    if (str2 != null || StringsKt.isBlank(str2)) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    if (!z) {
                                        finalHash2.element = hash;
                                        CinemacityPlugin.INSTANCE.setUserHash(hash);
                                    }
                                    Result.constructor-impl(Unit.INSTANCE);
                                    page2 = page6;
                                } catch (Throwable th16) {
                                    th = th16;
                                    cfCookies = authCookie4;
                                    authCookie2 = savedLogin;
                                    query2 = query3;
                                }
                                page4 = page2;
                                savedLogin2 = savedLogin;
                                map3 = map2;
                                query4 = query3;
                                $result = authCookie3;
                            } catch (Throwable th17) {
                                th = th17;
                                c00062 = c00063;
                                res2 = res;
                                page2 = page3;
                                html = mainSearchUrl;
                                query2 = query3;
                                doc2 = doc;
                                finalHash2 = finalHash;
                                Object $result4 = Result.Companion;
                                Result.constructor-impl(ResultKt.createFailure(th));
                                query3 = query2;
                                savedLogin = authCookie2;
                                authCookie4 = cfCookies;
                                page4 = page2;
                                savedLogin2 = savedLogin;
                                map3 = map2;
                                query4 = query3;
                                $result = authCookie3;
                                if (StringsKt.isBlank((CharSequence) finalHash2.element)) {
                                    html2 = doc2.html();
                                    savedLogin5 = savedLogin2;
                                    matchResultFind$default = Regex.find$default(new Regex(str), html2, 0, 2, (Object) null);
                                    if (matchResultFind$default != null) {
                                        it = doc2.select("input[name=dle_hash]").attr("value");
                                        if (StringsKt.isBlank(it)) {
                                            it = null;
                                        }
                                        if (it == null) {
                                            Cinemacity $this$search_u24lambda_u247 = this;
                                            String mainUrl3 = $this$search_u24lambda_u247.getMainUrl();
                                            c00062.L$0 = query4;
                                            c00062.L$1 = SpillingKt.nullOutSpilledVariable(savedLogin5);
                                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(authCookie4);
                                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(cfCookies2);
                                            c00062.L$4 = $result;
                                            c00062.L$5 = SpillingKt.nullOutSpilledVariable(map3);
                                            c00062.L$6 = SpillingKt.nullOutSpilledVariable(html);
                                            c00062.L$7 = SpillingKt.nullOutSpilledVariable(doc2);
                                            c00062.L$8 = SpillingKt.nullOutSpilledVariable(res2);
                                            c00062.L$9 = finalHash2;
                                            c00062.L$10 = SpillingKt.nullOutSpilledVariable(html2);
                                            c00062.L$11 = SpillingKt.nullOutSpilledVariable($this$search_u24lambda_u247);
                                            c00062.L$12 = finalHash2;
                                            c00062.I$0 = page4;
                                            c00062.label = 3;
                                            objAppGet = $this$search_u24lambda_u247.appGet(mainUrl3, map3, c00062);
                                            if (objAppGet == obj2) {
                                                return obj2;
                                            }
                                            savedLogin6 = savedLogin5;
                                            html3 = html2;
                                            $this$search_u24lambda_u244 = null;
                                            objectRef = finalHash2;
                                            cfCookies3 = cfCookies2;
                                            String mainHtml3 = ((NiceResponse) objAppGet).getDocument().html();
                                            String query8 = query4;
                                            Object authCookie7 = $result;
                                            Map<String, String> map8 = map3;
                                            matchResultFind$default2 = Regex.find$default(new Regex(str), mainHtml3, 0, 2, (Object) null);
                                            if (matchResultFind$default2 != null) {
                                                it = "";
                                            } else {
                                                it = "";
                                            }
                                            query4 = query8;
                                            finalHash4 = finalHash2;
                                            $result = authCookie7;
                                            map3 = map8;
                                            cfCookies2 = cfCookies3;
                                            finalHash2 = objectRef;
                                        }
                                        finalHash2.element = it;
                                        finalHash3 = finalHash4;
                                        savedLogin3 = savedLogin6;
                                        map4 = map3;
                                        page5 = page4;
                                        res3 = res2;
                                        mainSearchUrl2 = html;
                                        loginPart = authCookie4;
                                        doc3 = doc2;
                                        savedLogin4 = cfCookies2;
                                    } else {
                                        it = doc2.select("input[name=dle_hash]").attr("value");
                                        if (StringsKt.isBlank(it)) {
                                            it = null;
                                        }
                                        if (it == null) {
                                            Cinemacity $this$search_u24lambda_u248 = this;
                                            String mainUrl4 = $this$search_u24lambda_u248.getMainUrl();
                                            c00062.L$0 = query4;
                                            c00062.L$1 = SpillingKt.nullOutSpilledVariable(savedLogin5);
                                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(authCookie4);
                                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(cfCookies2);
                                            c00062.L$4 = $result;
                                            c00062.L$5 = SpillingKt.nullOutSpilledVariable(map3);
                                            c00062.L$6 = SpillingKt.nullOutSpilledVariable(html);
                                            c00062.L$7 = SpillingKt.nullOutSpilledVariable(doc2);
                                            c00062.L$8 = SpillingKt.nullOutSpilledVariable(res2);
                                            c00062.L$9 = finalHash2;
                                            c00062.L$10 = SpillingKt.nullOutSpilledVariable(html2);
                                            c00062.L$11 = SpillingKt.nullOutSpilledVariable($this$search_u24lambda_u248);
                                            c00062.L$12 = finalHash2;
                                            c00062.I$0 = page4;
                                            c00062.label = 3;
                                            objAppGet = $this$search_u24lambda_u248.appGet(mainUrl4, map3, c00062);
                                            if (objAppGet == obj2) {
                                                return obj2;
                                            }
                                            savedLogin6 = savedLogin5;
                                            html3 = html2;
                                            $this$search_u24lambda_u244 = null;
                                            objectRef = finalHash2;
                                            cfCookies3 = cfCookies2;
                                            String mainHtml4 = ((NiceResponse) objAppGet).getDocument().html();
                                            String query9 = query4;
                                            Object authCookie8 = $result;
                                            Map<String, String> map9 = map3;
                                            matchResultFind$default2 = Regex.find$default(new Regex(str), mainHtml4, 0, 2, (Object) null);
                                            if (matchResultFind$default2 != null) {
                                                it = "";
                                            } else {
                                                it = "";
                                            }
                                            query4 = query9;
                                            finalHash4 = finalHash2;
                                            $result = authCookie8;
                                            map3 = map9;
                                            cfCookies2 = cfCookies3;
                                            finalHash2 = objectRef;
                                        }
                                        finalHash2.element = it;
                                        finalHash3 = finalHash4;
                                        savedLogin3 = savedLogin6;
                                        map4 = map3;
                                        page5 = page4;
                                        res3 = res2;
                                        mainSearchUrl2 = html;
                                        loginPart = authCookie4;
                                        doc3 = doc2;
                                        savedLogin4 = cfCookies2;
                                    }
                                    savedLogin6 = savedLogin5;
                                    finalHash4 = finalHash2;
                                    finalHash2.element = it;
                                    finalHash3 = finalHash4;
                                    savedLogin3 = savedLogin6;
                                    map4 = map3;
                                    page5 = page4;
                                    res3 = res2;
                                    mainSearchUrl2 = html;
                                    loginPart = authCookie4;
                                    doc3 = doc2;
                                    savedLogin4 = cfCookies2;
                                } else {
                                    savedLogin3 = savedLogin2;
                                    finalHash3 = finalHash2;
                                    map4 = map3;
                                    page5 = page4;
                                    res3 = res2;
                                    mainSearchUrl2 = html;
                                    savedLogin4 = cfCookies2;
                                    loginPart = authCookie4;
                                    doc3 = doc2;
                                }
                                String ajaxUrl2 = getMainUrl() + "/engine/mods/dle_search/ajax.php";
                                Requests app3 = MainActivityKt.getApp();
                                Map mapMapOf5 = MapsKt.mapOf(new Pair[]{TuplesKt.to(obj5, obj4), TuplesKt.to("Origin", getMainUrl()), TuplesKt.to(obj3, getMainUrl() + '/'), TuplesKt.to("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8"), TuplesKt.to(obj6, $result)});
                                Map mapMapOf6 = MapsKt.mapOf(new Pair[]{TuplesKt.to("story", query4), TuplesKt.to("dle_hash", finalHash3.element), TuplesKt.to("thisUrl", "1")});
                                CinemacityCFBypassInterceptor cinemacityCFBypassInterceptor3 = CinemacityCFBypassInterceptor.INSTANCE;
                                c00062.L$0 = SpillingKt.nullOutSpilledVariable(query4);
                                c00062.L$1 = SpillingKt.nullOutSpilledVariable(savedLogin3);
                                c00062.L$2 = SpillingKt.nullOutSpilledVariable(loginPart);
                                c00062.L$3 = SpillingKt.nullOutSpilledVariable(savedLogin4);
                                c00062.L$4 = SpillingKt.nullOutSpilledVariable($result);
                                c00062.L$5 = SpillingKt.nullOutSpilledVariable(map4);
                                c00062.L$6 = SpillingKt.nullOutSpilledVariable(mainSearchUrl2);
                                c00062.L$7 = SpillingKt.nullOutSpilledVariable(doc3);
                                c00062.L$8 = SpillingKt.nullOutSpilledVariable(res3);
                                c00062.L$9 = SpillingKt.nullOutSpilledVariable(finalHash3);
                                c00062.L$10 = SpillingKt.nullOutSpilledVariable(ajaxUrl2);
                                c00062.L$11 = null;
                                c00062.L$12 = null;
                                c00062.I$0 = page5;
                                c00062.label = 4;
                                $result2 = Requests.post$default(app3, ajaxUrl2, mapMapOf5, (String) null, (Map) null, (Map) null, mapMapOf6, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, cinemacityCFBypassInterceptor3, false, (ResponseParser) null, c00062, 57308, (Object) null);
                                if ($result2 == obj2) {
                                    return obj2;
                                }
                                page7 = page5;
                                query5 = query4;
                                NiceResponse fallbackResponse2 = (NiceResponse) $result2;
                                json = fallbackResponse2.getText();
                                if (StringsKt.contains$default(json, "\"content\"", false, 2, (Object) null)) {
                                    return MainAPIKt.toNewSearchResponseList$default(CollectionsKt.emptyList(), (Boolean) null, 1, (Object) null);
                                }
                                AppUtils appUtils3 = AppUtils.INSTANCE;
                                if (json == null) {
                                    Result.Companion companion10 = Result.Companion;
                                    KType kTypeTypeOf3 = Reflection.typeOf(Map.class, KTypeProjection.Companion.invariant(Reflection.typeOf(String.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(String.class)));
                                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                    obj11 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf3));
                                    if (Result.exceptionOrNull-impl(obj11) == null) {
                                        Result.Companion companion11 = Result.Companion;
                                        obj11 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Map.class), (List) null, 2, (Object) null));
                                        break;
                                    }
                                    if (Result.isFailure-impl(obj11)) {
                                        obj11 = null;
                                    }
                                    deserializationStrategy2 = (KSerializer) obj11;
                                    if (deserializationStrategy2 != null) {
                                        objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, json);
                                    } else {
                                        ObjectMapper $this$readValue$iv$iv$iv7 = MainAPIKt.getMapper();
                                        objDecodeFromString2 = $this$readValue$iv$iv$iv7.readValue(json, new TypeReference<Map<String, ? extends String>>() { // from class: com.Cinemacity.Cinemacity$search$$inlined$tryParseJson$1
                                        });
                                    }
                                    break;
                                } else {
                                    objDecodeFromString2 = null;
                                }
                                map5 = (Map) objDecodeFromString2;
                                if (map5 != null) {
                                    str5 = str4;
                                }
                                contentHtml = str5;
                                fallbackDoc = Ksoup.parse$default(Ksoup.INSTANCE, contentHtml, (String) null, 2, (Object) null);
                                Iterable $this$mapNotNull$iv5 = fallbackDoc.select("div.dle-fast_item");
                                destination$iv$iv2 = new ArrayList();
                                while (r22.hasNext()) {
                                    String contentHtml4 = contentHtml;
                                    com.fleeksoft.ksoup.nodes.Document fallbackDoc4 = fallbackDoc;
                                    fallbackSearchResult = toFallbackSearchResult((com.fleeksoft.ksoup.nodes.Element) element$iv$iv$iv2);
                                    if (fallbackSearchResult != null) {
                                        destination$iv$iv2.add(fallbackSearchResult);
                                    }
                                    contentHtml = contentHtml4;
                                    fallbackDoc = fallbackDoc4;
                                }
                                List fallbackRes3 = (List) destination$iv$iv2;
                                return MainAPIKt.toNewSearchResponseList$default(fallbackRes3, (Boolean) null, 1, (Object) null);
                            }
                        } catch (Throwable th18) {
                            th = th18;
                            c00062 = c00061;
                            obj2 = coroutine_suspended;
                            map2 = map;
                            obj3 = "Referer";
                            obj4 = "XMLHttpRequest";
                            obj5 = "X-Requested-With";
                            authCookie3 = authCookie;
                            obj6 = "Cookie";
                            str = "dle_login_hash\\s*=\\s*'([^']+)'";
                            res2 = res;
                            html = mainSearchUrl;
                            doc2 = doc;
                            finalHash2 = finalHash;
                        }
                    } catch (Throwable th19) {
                        th = th19;
                        c00062 = c00061;
                        obj2 = coroutine_suspended;
                        map2 = map;
                        obj3 = "Referer";
                        obj4 = "XMLHttpRequest";
                        obj5 = "X-Requested-With";
                        authCookie3 = authCookie;
                        obj6 = "Cookie";
                        str = "dle_login_hash\\s*=\\s*'([^']+)'";
                        res2 = res;
                        html = mainSearchUrl;
                        doc2 = doc;
                        finalHash2 = finalHash;
                    }
                    break;
                } else {
                    c00062 = c00061;
                    obj2 = coroutine_suspended;
                    String query10 = query2;
                    Map<String, String> map10 = map;
                    obj3 = "Referer";
                    obj4 = "XMLHttpRequest";
                    obj5 = "X-Requested-With";
                    Object authCookie9 = authCookie;
                    obj6 = "Cookie";
                    str = "dle_login_hash\\s*=\\s*'([^']+)'";
                    res2 = res;
                    page4 = page2;
                    savedLogin2 = authCookie2;
                    html = mainSearchUrl;
                    doc2 = doc;
                    finalHash2 = finalHash;
                    authCookie4 = cfCookies;
                    map3 = map10;
                    query4 = query10;
                    $result = authCookie9;
                }
                if (StringsKt.isBlank((CharSequence) finalHash2.element)) {
                    html2 = doc2.html();
                    savedLogin5 = savedLogin2;
                    matchResultFind$default = Regex.find$default(new Regex(str), html2, 0, 2, (Object) null);
                    if (matchResultFind$default != null || (groupValues = matchResultFind$default.getGroupValues()) == null || (it = (String) groupValues.get(1)) == null) {
                        it = doc2.select("input[name=dle_hash]").attr("value");
                        if (StringsKt.isBlank(it)) {
                            it = null;
                        }
                        if (it == null) {
                            Cinemacity $this$search_u24lambda_u249 = this;
                            String mainUrl5 = $this$search_u24lambda_u249.getMainUrl();
                            c00062.L$0 = query4;
                            c00062.L$1 = SpillingKt.nullOutSpilledVariable(savedLogin5);
                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(authCookie4);
                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(cfCookies2);
                            c00062.L$4 = $result;
                            c00062.L$5 = SpillingKt.nullOutSpilledVariable(map3);
                            c00062.L$6 = SpillingKt.nullOutSpilledVariable(html);
                            c00062.L$7 = SpillingKt.nullOutSpilledVariable(doc2);
                            c00062.L$8 = SpillingKt.nullOutSpilledVariable(res2);
                            c00062.L$9 = finalHash2;
                            c00062.L$10 = SpillingKt.nullOutSpilledVariable(html2);
                            c00062.L$11 = SpillingKt.nullOutSpilledVariable($this$search_u24lambda_u249);
                            c00062.L$12 = finalHash2;
                            c00062.I$0 = page4;
                            c00062.label = 3;
                            objAppGet = $this$search_u24lambda_u249.appGet(mainUrl5, map3, c00062);
                            if (objAppGet == obj2) {
                                return obj2;
                            }
                            savedLogin6 = savedLogin5;
                            html3 = html2;
                            $this$search_u24lambda_u244 = null;
                            objectRef = finalHash2;
                            cfCookies3 = cfCookies2;
                            String mainHtml5 = ((NiceResponse) objAppGet).getDocument().html();
                            String query11 = query4;
                            Object authCookie10 = $result;
                            Map<String, String> map11 = map3;
                            matchResultFind$default2 = Regex.find$default(new Regex(str), mainHtml5, 0, 2, (Object) null);
                            if (matchResultFind$default2 != null || (groupValues2 = matchResultFind$default2.getGroupValues()) == null || (str3 = (String) groupValues2.get(1)) == null) {
                                it = "";
                            } else {
                                it = str3;
                            }
                            query4 = query11;
                            finalHash4 = finalHash2;
                            $result = authCookie10;
                            map3 = map11;
                            cfCookies2 = cfCookies3;
                            finalHash2 = objectRef;
                        }
                        finalHash2.element = it;
                        finalHash3 = finalHash4;
                        savedLogin3 = savedLogin6;
                        map4 = map3;
                        page5 = page4;
                        res3 = res2;
                        mainSearchUrl2 = html;
                        loginPart = authCookie4;
                        doc3 = doc2;
                        savedLogin4 = cfCookies2;
                    }
                    savedLogin6 = savedLogin5;
                    finalHash4 = finalHash2;
                    finalHash2.element = it;
                    finalHash3 = finalHash4;
                    savedLogin3 = savedLogin6;
                    map4 = map3;
                    page5 = page4;
                    res3 = res2;
                    mainSearchUrl2 = html;
                    loginPart = authCookie4;
                    doc3 = doc2;
                    savedLogin4 = cfCookies2;
                } else {
                    savedLogin3 = savedLogin2;
                    finalHash3 = finalHash2;
                    map4 = map3;
                    page5 = page4;
                    res3 = res2;
                    mainSearchUrl2 = html;
                    savedLogin4 = cfCookies2;
                    loginPart = authCookie4;
                    doc3 = doc2;
                }
                String ajaxUrl3 = getMainUrl() + "/engine/mods/dle_search/ajax.php";
                Requests app4 = MainActivityKt.getApp();
                Map mapMapOf7 = MapsKt.mapOf(new Pair[]{TuplesKt.to(obj5, obj4), TuplesKt.to("Origin", getMainUrl()), TuplesKt.to(obj3, getMainUrl() + '/'), TuplesKt.to("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8"), TuplesKt.to(obj6, $result)});
                Map mapMapOf8 = MapsKt.mapOf(new Pair[]{TuplesKt.to("story", query4), TuplesKt.to("dle_hash", finalHash3.element), TuplesKt.to("thisUrl", "1")});
                CinemacityCFBypassInterceptor cinemacityCFBypassInterceptor4 = CinemacityCFBypassInterceptor.INSTANCE;
                c00062.L$0 = SpillingKt.nullOutSpilledVariable(query4);
                c00062.L$1 = SpillingKt.nullOutSpilledVariable(savedLogin3);
                c00062.L$2 = SpillingKt.nullOutSpilledVariable(loginPart);
                c00062.L$3 = SpillingKt.nullOutSpilledVariable(savedLogin4);
                c00062.L$4 = SpillingKt.nullOutSpilledVariable($result);
                c00062.L$5 = SpillingKt.nullOutSpilledVariable(map4);
                c00062.L$6 = SpillingKt.nullOutSpilledVariable(mainSearchUrl2);
                c00062.L$7 = SpillingKt.nullOutSpilledVariable(doc3);
                c00062.L$8 = SpillingKt.nullOutSpilledVariable(res3);
                c00062.L$9 = SpillingKt.nullOutSpilledVariable(finalHash3);
                c00062.L$10 = SpillingKt.nullOutSpilledVariable(ajaxUrl3);
                c00062.L$11 = null;
                c00062.L$12 = null;
                c00062.I$0 = page5;
                c00062.label = 4;
                $result2 = Requests.post$default(app4, ajaxUrl3, mapMapOf7, (String) null, (Map) null, (Map) null, mapMapOf8, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, cinemacityCFBypassInterceptor4, false, (ResponseParser) null, c00062, 57308, (Object) null);
                if ($result2 == obj2) {
                    return obj2;
                }
                page7 = page5;
                query5 = query4;
                NiceResponse fallbackResponse3 = (NiceResponse) $result2;
                json = fallbackResponse3.getText();
                if (StringsKt.contains$default(json, "\"content\"", false, 2, (Object) null)) {
                    return MainAPIKt.toNewSearchResponseList$default(CollectionsKt.emptyList(), (Boolean) null, 1, (Object) null);
                }
                AppUtils appUtils4 = AppUtils.INSTANCE;
                if (json == null) {
                    Result.Companion companion12 = Result.Companion;
                    KType kTypeTypeOf4 = Reflection.typeOf(Map.class, KTypeProjection.Companion.invariant(Reflection.typeOf(String.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(String.class)));
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj11 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf4));
                    if (Result.exceptionOrNull-impl(obj11) == null) {
                        Result.Companion companion13 = Result.Companion;
                        obj11 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Map.class), (List) null, 2, (Object) null));
                        break;
                    }
                    if (Result.isFailure-impl(obj11)) {
                        obj11 = null;
                    }
                    deserializationStrategy2 = (KSerializer) obj11;
                    if (deserializationStrategy2 != null) {
                        objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, json);
                    } else {
                        ObjectMapper $this$readValue$iv$iv$iv8 = MainAPIKt.getMapper();
                        objDecodeFromString2 = $this$readValue$iv$iv$iv8.readValue(json, new TypeReference<Map<String, ? extends String>>() { // from class: com.Cinemacity.Cinemacity$search$$inlined$tryParseJson$1
                        });
                    }
                    break;
                } else {
                    objDecodeFromString2 = null;
                }
                map5 = (Map) objDecodeFromString2;
                if (map5 != null && (str4 = (String) map5.get("content")) != null) {
                    str5 = str4;
                }
                contentHtml = str5;
                fallbackDoc = Ksoup.parse$default(Ksoup.INSTANCE, contentHtml, (String) null, 2, (Object) null);
                Iterable $this$mapNotNull$iv6 = fallbackDoc.select("div.dle-fast_item");
                destination$iv$iv2 = new ArrayList();
                while (r22.hasNext()) {
                    String contentHtml5 = contentHtml;
                    com.fleeksoft.ksoup.nodes.Document fallbackDoc5 = fallbackDoc;
                    fallbackSearchResult = toFallbackSearchResult((com.fleeksoft.ksoup.nodes.Element) element$iv$iv$iv2);
                    if (fallbackSearchResult != null) {
                        destination$iv$iv2.add(fallbackSearchResult);
                    }
                    contentHtml = contentHtml5;
                    fallbackDoc = fallbackDoc5;
                }
                List fallbackRes4 = (List) destination$iv$iv2;
                return MainAPIKt.toNewSearchResponseList$default(fallbackRes4, (Boolean) null, 1, (Object) null);
            case 1:
                c = 2;
                int page8 = c00061.I$0;
                String mainSearchUrl4 = (String) c00061.L$6;
                map = (Map) c00061.L$5;
                authCookie = (String) c00061.L$4;
                String cfCookies5 = (String) c00061.L$3;
                String loginPart3 = (String) c00061.L$2;
                String savedLogin8 = (String) c00061.L$1;
                String query12 = (String) c00061.L$0;
                ResultKt.throwOnFailure($result2);
                query2 = query12;
                obj = $result2;
                mainSearchUrl = mainSearchUrl4;
                cfCookies = loginPart3;
                authCookie2 = savedLogin8;
                page2 = page8;
                cfCookies2 = cfCookies5;
                doc = ((NiceResponse) obj).getDocument();
                $this$mapNotNull$iv = doc.select("div.dar-short_item");
                destination$iv$iv = new ArrayList();
                while (r33.hasNext()) {
                    Iterable $this$mapNotNull$iv7 = $this$mapNotNull$iv;
                    searchResult = toSearchResult((Element) element$iv$iv$iv);
                    if (searchResult != null) {
                        destination$iv$iv.add(searchResult);
                    }
                    $this$mapNotNull$iv = $this$mapNotNull$iv7;
                }
                res = (List) destination$iv$iv;
                if (!res.isEmpty()) {
                    return MainAPIKt.toNewSearchResponseList$default(res, (Boolean) null, 1, (Object) null);
                }
                finalHash = new Ref.ObjectRef();
                finalHash.element = CinemacityPlugin.INSTANCE.getUserHash();
                if (StringsKt.isBlank((CharSequence) finalHash.element)) {
                    Result.Companion companion14 = Result.Companion;
                    $this$search_u24lambda_u242 = this;
                    Requests app5 = MainActivityKt.getApp();
                    String str8 = $this$search_u24lambda_u242.getMainUrl() + "/engine/ajax/controller.php?mod=ccdeviceguard&action=boot";
                    Pair[] pairArr2 = new Pair[3];
                    pairArr2[0] = TuplesKt.to("X-Requested-With", "XMLHttpRequest");
                    pairArr2[1] = TuplesKt.to("Referer", $this$search_u24lambda_u242.getMainUrl() + '/');
                    pairArr2[c] = TuplesKt.to("Cookie", authCookie);
                    Map mapMapOf9 = MapsKt.mapOf(pairArr2);
                    CinemacityCFBypassInterceptor cinemacityCFBypassInterceptor5 = CinemacityCFBypassInterceptor.INSTANCE;
                    c00061.L$0 = query2;
                    c00061.L$1 = SpillingKt.nullOutSpilledVariable(authCookie2);
                    c00061.L$2 = SpillingKt.nullOutSpilledVariable(cfCookies);
                    c00061.L$3 = SpillingKt.nullOutSpilledVariable(cfCookies2);
                    c00061.L$4 = authCookie;
                    c00061.L$5 = map;
                    c00061.L$6 = SpillingKt.nullOutSpilledVariable(mainSearchUrl);
                    c00061.L$7 = doc;
                    c00061.L$8 = SpillingKt.nullOutSpilledVariable(res);
                    c00061.L$9 = finalHash;
                    c00061.L$10 = SpillingKt.nullOutSpilledVariable($this$search_u24lambda_u242);
                    c00061.I$0 = page2;
                    c00061.label = 2;
                    obj4 = "XMLHttpRequest";
                    obj5 = "X-Requested-With";
                    authCookie3 = authCookie;
                    query3 = query2;
                    map2 = map;
                    obj3 = "Referer";
                    obj6 = "Cookie";
                    str = "dle_login_hash\\s*=\\s*'([^']+)'";
                    c00063 = c00061;
                    obj2 = coroutine_suspended;
                    page3 = page2;
                    obj7 = Requests.get$default(app5, str8, mapMapOf9, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, cinemacityCFBypassInterceptor5, false, (ResponseParser) null, c00063, 3580, (Object) null);
                    c00062 = c00063;
                    if (obj7 == obj2) {
                        return obj2;
                    }
                    $this$search_u24lambda_u243 = $this$search_u24lambda_u242;
                    obj8 = obj7;
                    res2 = res;
                    page2 = page3;
                    html = mainSearchUrl;
                    i = 0;
                    doc2 = doc;
                    finalHash2 = finalHash;
                    savedLogin = authCookie2;
                    authCookie4 = cfCookies;
                    NiceResponse bootResp2 = (NiceResponse) obj8;
                    AppUtils appUtils5 = AppUtils.INSTANCE;
                    value$iv = bootResp2.getText();
                    if (value$iv == null) {
                        page6 = page2;
                        objDecodeFromString = null;
                    } else {
                        Result.Companion companion15 = Result.Companion;
                        page6 = page2;
                        KType kTypeTypeOf5 = Reflection.typeOf(Map.class, KTypeProjection.Companion.invariant(Reflection.typeOf(String.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Object.class)));
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                        obj9 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf5));
                        if (Result.exceptionOrNull-impl(obj9) != null) {
                            Result.Companion companion16 = Result.Companion;
                            obj9 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Map.class), (List) null, 2, (Object) null));
                            break;
                        }
                        if (Result.isFailure-impl(obj9)) {
                            obj9 = null;
                        }
                        deserializationStrategy = (KSerializer) obj9;
                        if (deserializationStrategy != null) {
                            value$iv$iv = value$iv;
                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv$iv);
                        } else {
                            value$iv$iv = value$iv;
                        }
                        ObjectMapper $this$readValue$iv$iv$iv9 = MainAPIKt.getMapper();
                        String content$iv$iv$iv4 = value$iv$iv;
                        objDecodeFromString = $this$readValue$iv$iv$iv9.readValue(content$iv$iv$iv4, new TypeReference<Map<String, ? extends Object>>() { // from class: com.Cinemacity.Cinemacity$search$lambda$2$$inlined$tryParseJson$1
                        });
                    }
                    bootJson = (Map) objDecodeFromString;
                    if (bootJson != null) {
                        obj10 = bootJson.get("user_hash");
                    } else {
                        obj10 = null;
                    }
                    if (obj10 instanceof String) {
                        hash = (String) obj10;
                    } else {
                        hash = null;
                    }
                    str2 = hash;
                    if (str2 != null) {
                        z = true;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        finalHash2.element = hash;
                        CinemacityPlugin.INSTANCE.setUserHash(hash);
                    }
                    Result.constructor-impl(Unit.INSTANCE);
                    page2 = page6;
                    page4 = page2;
                    savedLogin2 = savedLogin;
                    map3 = map2;
                    query4 = query3;
                    $result = authCookie3;
                    break;
                } else {
                    c00062 = c00061;
                    obj2 = coroutine_suspended;
                    String query13 = query2;
                    Map<String, String> map12 = map;
                    obj3 = "Referer";
                    obj4 = "XMLHttpRequest";
                    obj5 = "X-Requested-With";
                    Object authCookie11 = authCookie;
                    obj6 = "Cookie";
                    str = "dle_login_hash\\s*=\\s*'([^']+)'";
                    res2 = res;
                    page4 = page2;
                    savedLogin2 = authCookie2;
                    html = mainSearchUrl;
                    doc2 = doc;
                    finalHash2 = finalHash;
                    authCookie4 = cfCookies;
                    map3 = map12;
                    query4 = query13;
                    $result = authCookie11;
                }
                if (StringsKt.isBlank((CharSequence) finalHash2.element)) {
                    html2 = doc2.html();
                    savedLogin5 = savedLogin2;
                    matchResultFind$default = Regex.find$default(new Regex(str), html2, 0, 2, (Object) null);
                    if (matchResultFind$default != null) {
                        it = doc2.select("input[name=dle_hash]").attr("value");
                        if (StringsKt.isBlank(it)) {
                            it = null;
                        }
                        if (it == null) {
                            Cinemacity $this$search_u24lambda_u2410 = this;
                            String mainUrl6 = $this$search_u24lambda_u2410.getMainUrl();
                            c00062.L$0 = query4;
                            c00062.L$1 = SpillingKt.nullOutSpilledVariable(savedLogin5);
                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(authCookie4);
                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(cfCookies2);
                            c00062.L$4 = $result;
                            c00062.L$5 = SpillingKt.nullOutSpilledVariable(map3);
                            c00062.L$6 = SpillingKt.nullOutSpilledVariable(html);
                            c00062.L$7 = SpillingKt.nullOutSpilledVariable(doc2);
                            c00062.L$8 = SpillingKt.nullOutSpilledVariable(res2);
                            c00062.L$9 = finalHash2;
                            c00062.L$10 = SpillingKt.nullOutSpilledVariable(html2);
                            c00062.L$11 = SpillingKt.nullOutSpilledVariable($this$search_u24lambda_u2410);
                            c00062.L$12 = finalHash2;
                            c00062.I$0 = page4;
                            c00062.label = 3;
                            objAppGet = $this$search_u24lambda_u2410.appGet(mainUrl6, map3, c00062);
                            if (objAppGet == obj2) {
                                return obj2;
                            }
                            savedLogin6 = savedLogin5;
                            html3 = html2;
                            $this$search_u24lambda_u244 = null;
                            objectRef = finalHash2;
                            cfCookies3 = cfCookies2;
                            String mainHtml6 = ((NiceResponse) objAppGet).getDocument().html();
                            String query14 = query4;
                            Object authCookie12 = $result;
                            Map<String, String> map13 = map3;
                            matchResultFind$default2 = Regex.find$default(new Regex(str), mainHtml6, 0, 2, (Object) null);
                            if (matchResultFind$default2 != null) {
                                it = "";
                            } else {
                                it = "";
                            }
                            query4 = query14;
                            finalHash4 = finalHash2;
                            $result = authCookie12;
                            map3 = map13;
                            cfCookies2 = cfCookies3;
                            finalHash2 = objectRef;
                        }
                        finalHash2.element = it;
                        finalHash3 = finalHash4;
                        savedLogin3 = savedLogin6;
                        map4 = map3;
                        page5 = page4;
                        res3 = res2;
                        mainSearchUrl2 = html;
                        loginPart = authCookie4;
                        doc3 = doc2;
                        savedLogin4 = cfCookies2;
                    } else {
                        it = doc2.select("input[name=dle_hash]").attr("value");
                        if (StringsKt.isBlank(it)) {
                            it = null;
                        }
                        if (it == null) {
                            Cinemacity $this$search_u24lambda_u2411 = this;
                            String mainUrl7 = $this$search_u24lambda_u2411.getMainUrl();
                            c00062.L$0 = query4;
                            c00062.L$1 = SpillingKt.nullOutSpilledVariable(savedLogin5);
                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(authCookie4);
                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(cfCookies2);
                            c00062.L$4 = $result;
                            c00062.L$5 = SpillingKt.nullOutSpilledVariable(map3);
                            c00062.L$6 = SpillingKt.nullOutSpilledVariable(html);
                            c00062.L$7 = SpillingKt.nullOutSpilledVariable(doc2);
                            c00062.L$8 = SpillingKt.nullOutSpilledVariable(res2);
                            c00062.L$9 = finalHash2;
                            c00062.L$10 = SpillingKt.nullOutSpilledVariable(html2);
                            c00062.L$11 = SpillingKt.nullOutSpilledVariable($this$search_u24lambda_u2411);
                            c00062.L$12 = finalHash2;
                            c00062.I$0 = page4;
                            c00062.label = 3;
                            objAppGet = $this$search_u24lambda_u2411.appGet(mainUrl7, map3, c00062);
                            if (objAppGet == obj2) {
                                return obj2;
                            }
                            savedLogin6 = savedLogin5;
                            html3 = html2;
                            $this$search_u24lambda_u244 = null;
                            objectRef = finalHash2;
                            cfCookies3 = cfCookies2;
                            String mainHtml7 = ((NiceResponse) objAppGet).getDocument().html();
                            String query15 = query4;
                            Object authCookie13 = $result;
                            Map<String, String> map14 = map3;
                            matchResultFind$default2 = Regex.find$default(new Regex(str), mainHtml7, 0, 2, (Object) null);
                            if (matchResultFind$default2 != null) {
                                it = "";
                            } else {
                                it = "";
                            }
                            query4 = query15;
                            finalHash4 = finalHash2;
                            $result = authCookie13;
                            map3 = map14;
                            cfCookies2 = cfCookies3;
                            finalHash2 = objectRef;
                        }
                        finalHash2.element = it;
                        finalHash3 = finalHash4;
                        savedLogin3 = savedLogin6;
                        map4 = map3;
                        page5 = page4;
                        res3 = res2;
                        mainSearchUrl2 = html;
                        loginPart = authCookie4;
                        doc3 = doc2;
                        savedLogin4 = cfCookies2;
                    }
                    savedLogin6 = savedLogin5;
                    finalHash4 = finalHash2;
                    finalHash2.element = it;
                    finalHash3 = finalHash4;
                    savedLogin3 = savedLogin6;
                    map4 = map3;
                    page5 = page4;
                    res3 = res2;
                    mainSearchUrl2 = html;
                    loginPart = authCookie4;
                    doc3 = doc2;
                    savedLogin4 = cfCookies2;
                } else {
                    savedLogin3 = savedLogin2;
                    finalHash3 = finalHash2;
                    map4 = map3;
                    page5 = page4;
                    res3 = res2;
                    mainSearchUrl2 = html;
                    savedLogin4 = cfCookies2;
                    loginPart = authCookie4;
                    doc3 = doc2;
                }
                String ajaxUrl4 = getMainUrl() + "/engine/mods/dle_search/ajax.php";
                Requests app6 = MainActivityKt.getApp();
                Map mapMapOf10 = MapsKt.mapOf(new Pair[]{TuplesKt.to(obj5, obj4), TuplesKt.to("Origin", getMainUrl()), TuplesKt.to(obj3, getMainUrl() + '/'), TuplesKt.to("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8"), TuplesKt.to(obj6, $result)});
                Map mapMapOf11 = MapsKt.mapOf(new Pair[]{TuplesKt.to("story", query4), TuplesKt.to("dle_hash", finalHash3.element), TuplesKt.to("thisUrl", "1")});
                CinemacityCFBypassInterceptor cinemacityCFBypassInterceptor6 = CinemacityCFBypassInterceptor.INSTANCE;
                c00062.L$0 = SpillingKt.nullOutSpilledVariable(query4);
                c00062.L$1 = SpillingKt.nullOutSpilledVariable(savedLogin3);
                c00062.L$2 = SpillingKt.nullOutSpilledVariable(loginPart);
                c00062.L$3 = SpillingKt.nullOutSpilledVariable(savedLogin4);
                c00062.L$4 = SpillingKt.nullOutSpilledVariable($result);
                c00062.L$5 = SpillingKt.nullOutSpilledVariable(map4);
                c00062.L$6 = SpillingKt.nullOutSpilledVariable(mainSearchUrl2);
                c00062.L$7 = SpillingKt.nullOutSpilledVariable(doc3);
                c00062.L$8 = SpillingKt.nullOutSpilledVariable(res3);
                c00062.L$9 = SpillingKt.nullOutSpilledVariable(finalHash3);
                c00062.L$10 = SpillingKt.nullOutSpilledVariable(ajaxUrl4);
                c00062.L$11 = null;
                c00062.L$12 = null;
                c00062.I$0 = page5;
                c00062.label = 4;
                $result2 = Requests.post$default(app6, ajaxUrl4, mapMapOf10, (String) null, (Map) null, (Map) null, mapMapOf11, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, cinemacityCFBypassInterceptor6, false, (ResponseParser) null, c00062, 57308, (Object) null);
                if ($result2 == obj2) {
                    return obj2;
                }
                page7 = page5;
                query5 = query4;
                NiceResponse fallbackResponse4 = (NiceResponse) $result2;
                json = fallbackResponse4.getText();
                if (StringsKt.contains$default(json, "\"content\"", false, 2, (Object) null)) {
                    return MainAPIKt.toNewSearchResponseList$default(CollectionsKt.emptyList(), (Boolean) null, 1, (Object) null);
                }
                AppUtils appUtils6 = AppUtils.INSTANCE;
                if (json == null) {
                    Result.Companion companion17 = Result.Companion;
                    KType kTypeTypeOf6 = Reflection.typeOf(Map.class, KTypeProjection.Companion.invariant(Reflection.typeOf(String.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(String.class)));
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj11 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf6));
                    if (Result.exceptionOrNull-impl(obj11) == null) {
                        Result.Companion companion18 = Result.Companion;
                        obj11 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Map.class), (List) null, 2, (Object) null));
                        break;
                    }
                    if (Result.isFailure-impl(obj11)) {
                        obj11 = null;
                    }
                    deserializationStrategy2 = (KSerializer) obj11;
                    if (deserializationStrategy2 != null) {
                        objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, json);
                    } else {
                        ObjectMapper $this$readValue$iv$iv$iv10 = MainAPIKt.getMapper();
                        objDecodeFromString2 = $this$readValue$iv$iv$iv10.readValue(json, new TypeReference<Map<String, ? extends String>>() { // from class: com.Cinemacity.Cinemacity$search$$inlined$tryParseJson$1
                        });
                    }
                    break;
                } else {
                    objDecodeFromString2 = null;
                }
                map5 = (Map) objDecodeFromString2;
                if (map5 != null) {
                    str5 = str4;
                }
                contentHtml = str5;
                fallbackDoc = Ksoup.parse$default(Ksoup.INSTANCE, contentHtml, (String) null, 2, (Object) null);
                Iterable $this$mapNotNull$iv8 = fallbackDoc.select("div.dle-fast_item");
                destination$iv$iv2 = new ArrayList();
                while (r22.hasNext()) {
                    String contentHtml6 = contentHtml;
                    com.fleeksoft.ksoup.nodes.Document fallbackDoc6 = fallbackDoc;
                    fallbackSearchResult = toFallbackSearchResult((com.fleeksoft.ksoup.nodes.Element) element$iv$iv$iv2);
                    if (fallbackSearchResult != null) {
                        destination$iv$iv2.add(fallbackSearchResult);
                    }
                    contentHtml = contentHtml6;
                    fallbackDoc = fallbackDoc6;
                }
                List fallbackRes5 = (List) destination$iv$iv2;
                return MainAPIKt.toNewSearchResponseList$default(fallbackRes5, (Boolean) null, 1, (Object) null);
            case 2:
                page2 = c00061.I$0;
                $this$search_u24lambda_u243 = (Cinemacity) c00061.L$10;
                finalHash2 = (Ref.ObjectRef) c00061.L$9;
                res2 = (List) c00061.L$8;
                doc2 = (Document) c00061.L$7;
                html = (String) c00061.L$6;
                Map<String, String> map15 = (Map) c00061.L$5;
                Object authCookie14 = (String) c00061.L$4;
                String cfCookies6 = (String) c00061.L$3;
                authCookie4 = (String) c00061.L$2;
                savedLogin = (String) c00061.L$1;
                query2 = (String) c00061.L$0;
                try {
                    ResultKt.throwOnFailure($result2);
                    c00062 = c00061;
                    obj2 = coroutine_suspended;
                    map2 = map15;
                    query3 = query2;
                    obj8 = $result2;
                    obj3 = "Referer";
                    obj4 = "XMLHttpRequest";
                    obj5 = "X-Requested-With";
                    obj6 = "Cookie";
                    str = "dle_login_hash\\s*=\\s*'([^']+)'";
                    i = 0;
                    authCookie3 = authCookie14;
                    cfCookies2 = cfCookies6;
                    NiceResponse bootResp3 = (NiceResponse) obj8;
                    AppUtils appUtils7 = AppUtils.INSTANCE;
                    value$iv = bootResp3.getText();
                    if (value$iv == null) {
                        page6 = page2;
                        objDecodeFromString = null;
                    } else {
                        Result.Companion companion19 = Result.Companion;
                        page6 = page2;
                        KType kTypeTypeOf7 = Reflection.typeOf(Map.class, KTypeProjection.Companion.invariant(Reflection.typeOf(String.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Object.class)));
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                        obj9 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf7));
                        if (Result.exceptionOrNull-impl(obj9) != null) {
                            Result.Companion companion110 = Result.Companion;
                            obj9 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Map.class), (List) null, 2, (Object) null));
                            break;
                        }
                        if (Result.isFailure-impl(obj9)) {
                            obj9 = null;
                        }
                        deserializationStrategy = (KSerializer) obj9;
                        if (deserializationStrategy != null) {
                            value$iv$iv = value$iv;
                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv$iv);
                        } else {
                            value$iv$iv = value$iv;
                        }
                        ObjectMapper $this$readValue$iv$iv$iv11 = MainAPIKt.getMapper();
                        String content$iv$iv$iv5 = value$iv$iv;
                        objDecodeFromString = $this$readValue$iv$iv$iv11.readValue(content$iv$iv$iv5, new TypeReference<Map<String, ? extends Object>>() { // from class: com.Cinemacity.Cinemacity$search$lambda$2$$inlined$tryParseJson$1
                        });
                    }
                    bootJson = (Map) objDecodeFromString;
                    if (bootJson != null) {
                        obj10 = bootJson.get("user_hash");
                    } else {
                        obj10 = null;
                    }
                    if (obj10 instanceof String) {
                        hash = (String) obj10;
                    } else {
                        hash = null;
                    }
                    str2 = hash;
                    if (str2 != null) {
                        z = true;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        finalHash2.element = hash;
                        CinemacityPlugin.INSTANCE.setUserHash(hash);
                    }
                    Result.constructor-impl(Unit.INSTANCE);
                    page2 = page6;
                    break;
                } catch (Throwable th20) {
                    th = th20;
                    c00062 = c00061;
                    obj2 = coroutine_suspended;
                    map2 = map15;
                    obj3 = "Referer";
                    obj4 = "XMLHttpRequest";
                    obj5 = "X-Requested-With";
                    obj6 = "Cookie";
                    str = "dle_login_hash\\s*=\\s*'([^']+)'";
                    authCookie3 = authCookie14;
                    cfCookies2 = cfCookies6;
                    cfCookies = authCookie4;
                    authCookie2 = savedLogin;
                    Object $result5 = Result.Companion;
                    Result.constructor-impl(ResultKt.createFailure(th));
                    query3 = query2;
                    savedLogin = authCookie2;
                    authCookie4 = cfCookies;
                    page4 = page2;
                    savedLogin2 = savedLogin;
                    map3 = map2;
                    query4 = query3;
                    $result = authCookie3;
                    if (StringsKt.isBlank((CharSequence) finalHash2.element)) {
                        html2 = doc2.html();
                        savedLogin5 = savedLogin2;
                        matchResultFind$default = Regex.find$default(new Regex(str), html2, 0, 2, (Object) null);
                        if (matchResultFind$default != null) {
                            it = doc2.select("input[name=dle_hash]").attr("value");
                            if (StringsKt.isBlank(it)) {
                                it = null;
                            }
                            if (it == null) {
                                Cinemacity $this$search_u24lambda_u2412 = this;
                                String mainUrl8 = $this$search_u24lambda_u2412.getMainUrl();
                                c00062.L$0 = query4;
                                c00062.L$1 = SpillingKt.nullOutSpilledVariable(savedLogin5);
                                c00062.L$2 = SpillingKt.nullOutSpilledVariable(authCookie4);
                                c00062.L$3 = SpillingKt.nullOutSpilledVariable(cfCookies2);
                                c00062.L$4 = $result;
                                c00062.L$5 = SpillingKt.nullOutSpilledVariable(map3);
                                c00062.L$6 = SpillingKt.nullOutSpilledVariable(html);
                                c00062.L$7 = SpillingKt.nullOutSpilledVariable(doc2);
                                c00062.L$8 = SpillingKt.nullOutSpilledVariable(res2);
                                c00062.L$9 = finalHash2;
                                c00062.L$10 = SpillingKt.nullOutSpilledVariable(html2);
                                c00062.L$11 = SpillingKt.nullOutSpilledVariable($this$search_u24lambda_u2412);
                                c00062.L$12 = finalHash2;
                                c00062.I$0 = page4;
                                c00062.label = 3;
                                objAppGet = $this$search_u24lambda_u2412.appGet(mainUrl8, map3, c00062);
                                if (objAppGet == obj2) {
                                    return obj2;
                                }
                                savedLogin6 = savedLogin5;
                                html3 = html2;
                                $this$search_u24lambda_u244 = null;
                                objectRef = finalHash2;
                                cfCookies3 = cfCookies2;
                                String mainHtml8 = ((NiceResponse) objAppGet).getDocument().html();
                                String query16 = query4;
                                Object authCookie15 = $result;
                                Map<String, String> map16 = map3;
                                matchResultFind$default2 = Regex.find$default(new Regex(str), mainHtml8, 0, 2, (Object) null);
                                if (matchResultFind$default2 != null) {
                                    it = "";
                                } else {
                                    it = "";
                                }
                                query4 = query16;
                                finalHash4 = finalHash2;
                                $result = authCookie15;
                                map3 = map16;
                                cfCookies2 = cfCookies3;
                                finalHash2 = objectRef;
                            }
                            finalHash2.element = it;
                            finalHash3 = finalHash4;
                            savedLogin3 = savedLogin6;
                            map4 = map3;
                            page5 = page4;
                            res3 = res2;
                            mainSearchUrl2 = html;
                            loginPart = authCookie4;
                            doc3 = doc2;
                            savedLogin4 = cfCookies2;
                        } else {
                            it = doc2.select("input[name=dle_hash]").attr("value");
                            if (StringsKt.isBlank(it)) {
                                it = null;
                            }
                            if (it == null) {
                                Cinemacity $this$search_u24lambda_u2413 = this;
                                String mainUrl9 = $this$search_u24lambda_u2413.getMainUrl();
                                c00062.L$0 = query4;
                                c00062.L$1 = SpillingKt.nullOutSpilledVariable(savedLogin5);
                                c00062.L$2 = SpillingKt.nullOutSpilledVariable(authCookie4);
                                c00062.L$3 = SpillingKt.nullOutSpilledVariable(cfCookies2);
                                c00062.L$4 = $result;
                                c00062.L$5 = SpillingKt.nullOutSpilledVariable(map3);
                                c00062.L$6 = SpillingKt.nullOutSpilledVariable(html);
                                c00062.L$7 = SpillingKt.nullOutSpilledVariable(doc2);
                                c00062.L$8 = SpillingKt.nullOutSpilledVariable(res2);
                                c00062.L$9 = finalHash2;
                                c00062.L$10 = SpillingKt.nullOutSpilledVariable(html2);
                                c00062.L$11 = SpillingKt.nullOutSpilledVariable($this$search_u24lambda_u2413);
                                c00062.L$12 = finalHash2;
                                c00062.I$0 = page4;
                                c00062.label = 3;
                                objAppGet = $this$search_u24lambda_u2413.appGet(mainUrl9, map3, c00062);
                                if (objAppGet == obj2) {
                                    return obj2;
                                }
                                savedLogin6 = savedLogin5;
                                html3 = html2;
                                $this$search_u24lambda_u244 = null;
                                objectRef = finalHash2;
                                cfCookies3 = cfCookies2;
                                String mainHtml9 = ((NiceResponse) objAppGet).getDocument().html();
                                String query17 = query4;
                                Object authCookie16 = $result;
                                Map<String, String> map17 = map3;
                                matchResultFind$default2 = Regex.find$default(new Regex(str), mainHtml9, 0, 2, (Object) null);
                                if (matchResultFind$default2 != null) {
                                    it = "";
                                } else {
                                    it = "";
                                }
                                query4 = query17;
                                finalHash4 = finalHash2;
                                $result = authCookie16;
                                map3 = map17;
                                cfCookies2 = cfCookies3;
                                finalHash2 = objectRef;
                            }
                            finalHash2.element = it;
                            finalHash3 = finalHash4;
                            savedLogin3 = savedLogin6;
                            map4 = map3;
                            page5 = page4;
                            res3 = res2;
                            mainSearchUrl2 = html;
                            loginPart = authCookie4;
                            doc3 = doc2;
                            savedLogin4 = cfCookies2;
                        }
                        savedLogin6 = savedLogin5;
                        finalHash4 = finalHash2;
                        finalHash2.element = it;
                        finalHash3 = finalHash4;
                        savedLogin3 = savedLogin6;
                        map4 = map3;
                        page5 = page4;
                        res3 = res2;
                        mainSearchUrl2 = html;
                        loginPart = authCookie4;
                        doc3 = doc2;
                        savedLogin4 = cfCookies2;
                    } else {
                        savedLogin3 = savedLogin2;
                        finalHash3 = finalHash2;
                        map4 = map3;
                        page5 = page4;
                        res3 = res2;
                        mainSearchUrl2 = html;
                        savedLogin4 = cfCookies2;
                        loginPart = authCookie4;
                        doc3 = doc2;
                    }
                    String ajaxUrl5 = getMainUrl() + "/engine/mods/dle_search/ajax.php";
                    Requests app7 = MainActivityKt.getApp();
                    Map mapMapOf12 = MapsKt.mapOf(new Pair[]{TuplesKt.to(obj5, obj4), TuplesKt.to("Origin", getMainUrl()), TuplesKt.to(obj3, getMainUrl() + '/'), TuplesKt.to("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8"), TuplesKt.to(obj6, $result)});
                    Map mapMapOf13 = MapsKt.mapOf(new Pair[]{TuplesKt.to("story", query4), TuplesKt.to("dle_hash", finalHash3.element), TuplesKt.to("thisUrl", "1")});
                    CinemacityCFBypassInterceptor cinemacityCFBypassInterceptor7 = CinemacityCFBypassInterceptor.INSTANCE;
                    c00062.L$0 = SpillingKt.nullOutSpilledVariable(query4);
                    c00062.L$1 = SpillingKt.nullOutSpilledVariable(savedLogin3);
                    c00062.L$2 = SpillingKt.nullOutSpilledVariable(loginPart);
                    c00062.L$3 = SpillingKt.nullOutSpilledVariable(savedLogin4);
                    c00062.L$4 = SpillingKt.nullOutSpilledVariable($result);
                    c00062.L$5 = SpillingKt.nullOutSpilledVariable(map4);
                    c00062.L$6 = SpillingKt.nullOutSpilledVariable(mainSearchUrl2);
                    c00062.L$7 = SpillingKt.nullOutSpilledVariable(doc3);
                    c00062.L$8 = SpillingKt.nullOutSpilledVariable(res3);
                    c00062.L$9 = SpillingKt.nullOutSpilledVariable(finalHash3);
                    c00062.L$10 = SpillingKt.nullOutSpilledVariable(ajaxUrl5);
                    c00062.L$11 = null;
                    c00062.L$12 = null;
                    c00062.I$0 = page5;
                    c00062.label = 4;
                    $result2 = Requests.post$default(app7, ajaxUrl5, mapMapOf12, (String) null, (Map) null, (Map) null, mapMapOf13, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, cinemacityCFBypassInterceptor7, false, (ResponseParser) null, c00062, 57308, (Object) null);
                    if ($result2 == obj2) {
                        return obj2;
                    }
                    page7 = page5;
                    query5 = query4;
                    NiceResponse fallbackResponse5 = (NiceResponse) $result2;
                    json = fallbackResponse5.getText();
                    if (StringsKt.contains$default(json, "\"content\"", false, 2, (Object) null)) {
                        return MainAPIKt.toNewSearchResponseList$default(CollectionsKt.emptyList(), (Boolean) null, 1, (Object) null);
                    }
                    AppUtils appUtils8 = AppUtils.INSTANCE;
                    if (json == null) {
                        Result.Companion companion111 = Result.Companion;
                        KType kTypeTypeOf8 = Reflection.typeOf(Map.class, KTypeProjection.Companion.invariant(Reflection.typeOf(String.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(String.class)));
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                        obj11 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf8));
                        if (Result.exceptionOrNull-impl(obj11) == null) {
                            Result.Companion companion112 = Result.Companion;
                            obj11 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Map.class), (List) null, 2, (Object) null));
                            break;
                        }
                        if (Result.isFailure-impl(obj11)) {
                            obj11 = null;
                        }
                        deserializationStrategy2 = (KSerializer) obj11;
                        if (deserializationStrategy2 != null) {
                            objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, json);
                        } else {
                            ObjectMapper $this$readValue$iv$iv$iv12 = MainAPIKt.getMapper();
                            objDecodeFromString2 = $this$readValue$iv$iv$iv12.readValue(json, new TypeReference<Map<String, ? extends String>>() { // from class: com.Cinemacity.Cinemacity$search$$inlined$tryParseJson$1
                            });
                        }
                        break;
                    } else {
                        objDecodeFromString2 = null;
                    }
                    map5 = (Map) objDecodeFromString2;
                    if (map5 != null) {
                        str5 = str4;
                    }
                    contentHtml = str5;
                    fallbackDoc = Ksoup.parse$default(Ksoup.INSTANCE, contentHtml, (String) null, 2, (Object) null);
                    Iterable $this$mapNotNull$iv9 = fallbackDoc.select("div.dle-fast_item");
                    destination$iv$iv2 = new ArrayList();
                    while (r22.hasNext()) {
                        String contentHtml7 = contentHtml;
                        com.fleeksoft.ksoup.nodes.Document fallbackDoc7 = fallbackDoc;
                        fallbackSearchResult = toFallbackSearchResult((com.fleeksoft.ksoup.nodes.Element) element$iv$iv$iv2);
                        if (fallbackSearchResult != null) {
                            destination$iv$iv2.add(fallbackSearchResult);
                        }
                        contentHtml = contentHtml7;
                        fallbackDoc = fallbackDoc7;
                    }
                    List fallbackRes6 = (List) destination$iv$iv2;
                    return MainAPIKt.toNewSearchResponseList$default(fallbackRes6, (Boolean) null, 1, (Object) null);
                }
                page4 = page2;
                savedLogin2 = savedLogin;
                map3 = map2;
                query4 = query3;
                $result = authCookie3;
                if (StringsKt.isBlank((CharSequence) finalHash2.element)) {
                    html2 = doc2.html();
                    savedLogin5 = savedLogin2;
                    matchResultFind$default = Regex.find$default(new Regex(str), html2, 0, 2, (Object) null);
                    if (matchResultFind$default != null) {
                        it = doc2.select("input[name=dle_hash]").attr("value");
                        if (StringsKt.isBlank(it)) {
                            it = null;
                        }
                        if (it == null) {
                            Cinemacity $this$search_u24lambda_u2414 = this;
                            String mainUrl10 = $this$search_u24lambda_u2414.getMainUrl();
                            c00062.L$0 = query4;
                            c00062.L$1 = SpillingKt.nullOutSpilledVariable(savedLogin5);
                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(authCookie4);
                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(cfCookies2);
                            c00062.L$4 = $result;
                            c00062.L$5 = SpillingKt.nullOutSpilledVariable(map3);
                            c00062.L$6 = SpillingKt.nullOutSpilledVariable(html);
                            c00062.L$7 = SpillingKt.nullOutSpilledVariable(doc2);
                            c00062.L$8 = SpillingKt.nullOutSpilledVariable(res2);
                            c00062.L$9 = finalHash2;
                            c00062.L$10 = SpillingKt.nullOutSpilledVariable(html2);
                            c00062.L$11 = SpillingKt.nullOutSpilledVariable($this$search_u24lambda_u2414);
                            c00062.L$12 = finalHash2;
                            c00062.I$0 = page4;
                            c00062.label = 3;
                            objAppGet = $this$search_u24lambda_u2414.appGet(mainUrl10, map3, c00062);
                            if (objAppGet == obj2) {
                                return obj2;
                            }
                            savedLogin6 = savedLogin5;
                            html3 = html2;
                            $this$search_u24lambda_u244 = null;
                            objectRef = finalHash2;
                            cfCookies3 = cfCookies2;
                            String mainHtml10 = ((NiceResponse) objAppGet).getDocument().html();
                            String query18 = query4;
                            Object authCookie17 = $result;
                            Map<String, String> map18 = map3;
                            matchResultFind$default2 = Regex.find$default(new Regex(str), mainHtml10, 0, 2, (Object) null);
                            if (matchResultFind$default2 != null) {
                                it = "";
                            } else {
                                it = "";
                            }
                            query4 = query18;
                            finalHash4 = finalHash2;
                            $result = authCookie17;
                            map3 = map18;
                            cfCookies2 = cfCookies3;
                            finalHash2 = objectRef;
                        }
                        finalHash2.element = it;
                        finalHash3 = finalHash4;
                        savedLogin3 = savedLogin6;
                        map4 = map3;
                        page5 = page4;
                        res3 = res2;
                        mainSearchUrl2 = html;
                        loginPart = authCookie4;
                        doc3 = doc2;
                        savedLogin4 = cfCookies2;
                    } else {
                        it = doc2.select("input[name=dle_hash]").attr("value");
                        if (StringsKt.isBlank(it)) {
                            it = null;
                        }
                        if (it == null) {
                            Cinemacity $this$search_u24lambda_u2415 = this;
                            String mainUrl11 = $this$search_u24lambda_u2415.getMainUrl();
                            c00062.L$0 = query4;
                            c00062.L$1 = SpillingKt.nullOutSpilledVariable(savedLogin5);
                            c00062.L$2 = SpillingKt.nullOutSpilledVariable(authCookie4);
                            c00062.L$3 = SpillingKt.nullOutSpilledVariable(cfCookies2);
                            c00062.L$4 = $result;
                            c00062.L$5 = SpillingKt.nullOutSpilledVariable(map3);
                            c00062.L$6 = SpillingKt.nullOutSpilledVariable(html);
                            c00062.L$7 = SpillingKt.nullOutSpilledVariable(doc2);
                            c00062.L$8 = SpillingKt.nullOutSpilledVariable(res2);
                            c00062.L$9 = finalHash2;
                            c00062.L$10 = SpillingKt.nullOutSpilledVariable(html2);
                            c00062.L$11 = SpillingKt.nullOutSpilledVariable($this$search_u24lambda_u2415);
                            c00062.L$12 = finalHash2;
                            c00062.I$0 = page4;
                            c00062.label = 3;
                            objAppGet = $this$search_u24lambda_u2415.appGet(mainUrl11, map3, c00062);
                            if (objAppGet == obj2) {
                                return obj2;
                            }
                            savedLogin6 = savedLogin5;
                            html3 = html2;
                            $this$search_u24lambda_u244 = null;
                            objectRef = finalHash2;
                            cfCookies3 = cfCookies2;
                            String mainHtml11 = ((NiceResponse) objAppGet).getDocument().html();
                            String query19 = query4;
                            Object authCookie18 = $result;
                            Map<String, String> map19 = map3;
                            matchResultFind$default2 = Regex.find$default(new Regex(str), mainHtml11, 0, 2, (Object) null);
                            if (matchResultFind$default2 != null) {
                                it = "";
                            } else {
                                it = "";
                            }
                            query4 = query19;
                            finalHash4 = finalHash2;
                            $result = authCookie18;
                            map3 = map19;
                            cfCookies2 = cfCookies3;
                            finalHash2 = objectRef;
                        }
                        finalHash2.element = it;
                        finalHash3 = finalHash4;
                        savedLogin3 = savedLogin6;
                        map4 = map3;
                        page5 = page4;
                        res3 = res2;
                        mainSearchUrl2 = html;
                        loginPart = authCookie4;
                        doc3 = doc2;
                        savedLogin4 = cfCookies2;
                    }
                    savedLogin6 = savedLogin5;
                    finalHash4 = finalHash2;
                    finalHash2.element = it;
                    finalHash3 = finalHash4;
                    savedLogin3 = savedLogin6;
                    map4 = map3;
                    page5 = page4;
                    res3 = res2;
                    mainSearchUrl2 = html;
                    loginPart = authCookie4;
                    doc3 = doc2;
                    savedLogin4 = cfCookies2;
                } else {
                    savedLogin3 = savedLogin2;
                    finalHash3 = finalHash2;
                    map4 = map3;
                    page5 = page4;
                    res3 = res2;
                    mainSearchUrl2 = html;
                    savedLogin4 = cfCookies2;
                    loginPart = authCookie4;
                    doc3 = doc2;
                }
                String ajaxUrl6 = getMainUrl() + "/engine/mods/dle_search/ajax.php";
                Requests app8 = MainActivityKt.getApp();
                Map mapMapOf14 = MapsKt.mapOf(new Pair[]{TuplesKt.to(obj5, obj4), TuplesKt.to("Origin", getMainUrl()), TuplesKt.to(obj3, getMainUrl() + '/'), TuplesKt.to("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8"), TuplesKt.to(obj6, $result)});
                Map mapMapOf15 = MapsKt.mapOf(new Pair[]{TuplesKt.to("story", query4), TuplesKt.to("dle_hash", finalHash3.element), TuplesKt.to("thisUrl", "1")});
                CinemacityCFBypassInterceptor cinemacityCFBypassInterceptor8 = CinemacityCFBypassInterceptor.INSTANCE;
                c00062.L$0 = SpillingKt.nullOutSpilledVariable(query4);
                c00062.L$1 = SpillingKt.nullOutSpilledVariable(savedLogin3);
                c00062.L$2 = SpillingKt.nullOutSpilledVariable(loginPart);
                c00062.L$3 = SpillingKt.nullOutSpilledVariable(savedLogin4);
                c00062.L$4 = SpillingKt.nullOutSpilledVariable($result);
                c00062.L$5 = SpillingKt.nullOutSpilledVariable(map4);
                c00062.L$6 = SpillingKt.nullOutSpilledVariable(mainSearchUrl2);
                c00062.L$7 = SpillingKt.nullOutSpilledVariable(doc3);
                c00062.L$8 = SpillingKt.nullOutSpilledVariable(res3);
                c00062.L$9 = SpillingKt.nullOutSpilledVariable(finalHash3);
                c00062.L$10 = SpillingKt.nullOutSpilledVariable(ajaxUrl6);
                c00062.L$11 = null;
                c00062.L$12 = null;
                c00062.I$0 = page5;
                c00062.label = 4;
                $result2 = Requests.post$default(app8, ajaxUrl6, mapMapOf14, (String) null, (Map) null, (Map) null, mapMapOf15, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, cinemacityCFBypassInterceptor8, false, (ResponseParser) null, c00062, 57308, (Object) null);
                if ($result2 == obj2) {
                    return obj2;
                }
                page7 = page5;
                query5 = query4;
                NiceResponse fallbackResponse6 = (NiceResponse) $result2;
                json = fallbackResponse6.getText();
                if (StringsKt.contains$default(json, "\"content\"", false, 2, (Object) null)) {
                    return MainAPIKt.toNewSearchResponseList$default(CollectionsKt.emptyList(), (Boolean) null, 1, (Object) null);
                }
                AppUtils appUtils9 = AppUtils.INSTANCE;
                if (json == null) {
                    Result.Companion companion113 = Result.Companion;
                    KType kTypeTypeOf9 = Reflection.typeOf(Map.class, KTypeProjection.Companion.invariant(Reflection.typeOf(String.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(String.class)));
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj11 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf9));
                    if (Result.exceptionOrNull-impl(obj11) == null) {
                        Result.Companion companion114 = Result.Companion;
                        obj11 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Map.class), (List) null, 2, (Object) null));
                        break;
                    }
                    if (Result.isFailure-impl(obj11)) {
                        obj11 = null;
                    }
                    deserializationStrategy2 = (KSerializer) obj11;
                    if (deserializationStrategy2 != null) {
                        objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, json);
                    } else {
                        ObjectMapper $this$readValue$iv$iv$iv13 = MainAPIKt.getMapper();
                        objDecodeFromString2 = $this$readValue$iv$iv$iv13.readValue(json, new TypeReference<Map<String, ? extends String>>() { // from class: com.Cinemacity.Cinemacity$search$$inlined$tryParseJson$1
                        });
                    }
                    break;
                } else {
                    objDecodeFromString2 = null;
                }
                map5 = (Map) objDecodeFromString2;
                if (map5 != null) {
                    str5 = str4;
                }
                contentHtml = str5;
                fallbackDoc = Ksoup.parse$default(Ksoup.INSTANCE, contentHtml, (String) null, 2, (Object) null);
                Iterable $this$mapNotNull$iv10 = fallbackDoc.select("div.dle-fast_item");
                destination$iv$iv2 = new ArrayList();
                while (r22.hasNext()) {
                    String contentHtml8 = contentHtml;
                    com.fleeksoft.ksoup.nodes.Document fallbackDoc8 = fallbackDoc;
                    fallbackSearchResult = toFallbackSearchResult((com.fleeksoft.ksoup.nodes.Element) element$iv$iv$iv2);
                    if (fallbackSearchResult != null) {
                        destination$iv$iv2.add(fallbackSearchResult);
                    }
                    contentHtml = contentHtml8;
                    fallbackDoc = fallbackDoc8;
                }
                List fallbackRes7 = (List) destination$iv$iv2;
                return MainAPIKt.toNewSearchResponseList$default(fallbackRes7, (Boolean) null, 1, (Object) null);
            case 3:
                int page9 = c00061.I$0;
                Ref.ObjectRef objectRef2 = (Ref.ObjectRef) c00061.L$12;
                String html4 = (String) c00061.L$10;
                Ref.ObjectRef finalHash5 = (Ref.ObjectRef) c00061.L$9;
                res2 = (List) c00061.L$8;
                Document doc4 = (Document) c00061.L$7;
                String mainSearchUrl5 = (String) c00061.L$6;
                Map<String, String> map20 = (Map) c00061.L$5;
                Object authCookie19 = (String) c00061.L$4;
                cfCookies3 = (String) c00061.L$3;
                String loginPart4 = (String) c00061.L$2;
                savedLogin6 = (String) c00061.L$1;
                query4 = (String) c00061.L$0;
                ResultKt.throwOnFailure($result2);
                c00062 = c00061;
                obj2 = coroutine_suspended;
                obj3 = "Referer";
                obj4 = "XMLHttpRequest";
                obj5 = "X-Requested-With";
                objectRef = objectRef2;
                obj6 = "Cookie";
                html3 = html4;
                str = "dle_login_hash\\s*=\\s*'([^']+)'";
                $this$search_u24lambda_u244 = null;
                html = mainSearchUrl5;
                doc2 = doc4;
                objAppGet = $result2;
                finalHash2 = finalHash5;
                $result = authCookie19;
                authCookie4 = loginPart4;
                page4 = page9;
                map3 = map20;
                String mainHtml12 = ((NiceResponse) objAppGet).getDocument().html();
                String query110 = query4;
                Object authCookie110 = $result;
                Map<String, String> map110 = map3;
                matchResultFind$default2 = Regex.find$default(new Regex(str), mainHtml12, 0, 2, (Object) null);
                if (matchResultFind$default2 != null) {
                    it = "";
                } else {
                    it = "";
                }
                query4 = query110;
                finalHash4 = finalHash2;
                $result = authCookie110;
                map3 = map110;
                cfCookies2 = cfCookies3;
                finalHash2 = objectRef;
                finalHash2.element = it;
                finalHash3 = finalHash4;
                savedLogin3 = savedLogin6;
                map4 = map3;
                page5 = page4;
                res3 = res2;
                mainSearchUrl2 = html;
                loginPart = authCookie4;
                doc3 = doc2;
                savedLogin4 = cfCookies2;
                String ajaxUrl7 = getMainUrl() + "/engine/mods/dle_search/ajax.php";
                Requests app9 = MainActivityKt.getApp();
                Map mapMapOf16 = MapsKt.mapOf(new Pair[]{TuplesKt.to(obj5, obj4), TuplesKt.to("Origin", getMainUrl()), TuplesKt.to(obj3, getMainUrl() + '/'), TuplesKt.to("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8"), TuplesKt.to(obj6, $result)});
                Map mapMapOf17 = MapsKt.mapOf(new Pair[]{TuplesKt.to("story", query4), TuplesKt.to("dle_hash", finalHash3.element), TuplesKt.to("thisUrl", "1")});
                CinemacityCFBypassInterceptor cinemacityCFBypassInterceptor9 = CinemacityCFBypassInterceptor.INSTANCE;
                c00062.L$0 = SpillingKt.nullOutSpilledVariable(query4);
                c00062.L$1 = SpillingKt.nullOutSpilledVariable(savedLogin3);
                c00062.L$2 = SpillingKt.nullOutSpilledVariable(loginPart);
                c00062.L$3 = SpillingKt.nullOutSpilledVariable(savedLogin4);
                c00062.L$4 = SpillingKt.nullOutSpilledVariable($result);
                c00062.L$5 = SpillingKt.nullOutSpilledVariable(map4);
                c00062.L$6 = SpillingKt.nullOutSpilledVariable(mainSearchUrl2);
                c00062.L$7 = SpillingKt.nullOutSpilledVariable(doc3);
                c00062.L$8 = SpillingKt.nullOutSpilledVariable(res3);
                c00062.L$9 = SpillingKt.nullOutSpilledVariable(finalHash3);
                c00062.L$10 = SpillingKt.nullOutSpilledVariable(ajaxUrl7);
                c00062.L$11 = null;
                c00062.L$12 = null;
                c00062.I$0 = page5;
                c00062.label = 4;
                $result2 = Requests.post$default(app9, ajaxUrl7, mapMapOf16, (String) null, (Map) null, (Map) null, mapMapOf17, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, cinemacityCFBypassInterceptor9, false, (ResponseParser) null, c00062, 57308, (Object) null);
                if ($result2 == obj2) {
                    return obj2;
                }
                page7 = page5;
                query5 = query4;
                NiceResponse fallbackResponse7 = (NiceResponse) $result2;
                json = fallbackResponse7.getText();
                if (StringsKt.contains$default(json, "\"content\"", false, 2, (Object) null)) {
                    return MainAPIKt.toNewSearchResponseList$default(CollectionsKt.emptyList(), (Boolean) null, 1, (Object) null);
                }
                AppUtils appUtils10 = AppUtils.INSTANCE;
                if (json == null) {
                    Result.Companion companion115 = Result.Companion;
                    KType kTypeTypeOf10 = Reflection.typeOf(Map.class, KTypeProjection.Companion.invariant(Reflection.typeOf(String.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(String.class)));
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj11 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf10));
                    if (Result.exceptionOrNull-impl(obj11) == null) {
                        Result.Companion companion116 = Result.Companion;
                        obj11 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Map.class), (List) null, 2, (Object) null));
                        break;
                    }
                    if (Result.isFailure-impl(obj11)) {
                        obj11 = null;
                    }
                    deserializationStrategy2 = (KSerializer) obj11;
                    if (deserializationStrategy2 != null) {
                        objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, json);
                    } else {
                        ObjectMapper $this$readValue$iv$iv$iv14 = MainAPIKt.getMapper();
                        objDecodeFromString2 = $this$readValue$iv$iv$iv14.readValue(json, new TypeReference<Map<String, ? extends String>>() { // from class: com.Cinemacity.Cinemacity$search$$inlined$tryParseJson$1
                        });
                    }
                    break;
                } else {
                    objDecodeFromString2 = null;
                }
                map5 = (Map) objDecodeFromString2;
                if (map5 != null) {
                    str5 = str4;
                }
                contentHtml = str5;
                fallbackDoc = Ksoup.parse$default(Ksoup.INSTANCE, contentHtml, (String) null, 2, (Object) null);
                Iterable $this$mapNotNull$iv11 = fallbackDoc.select("div.dle-fast_item");
                destination$iv$iv2 = new ArrayList();
                while (r22.hasNext()) {
                    String contentHtml9 = contentHtml;
                    com.fleeksoft.ksoup.nodes.Document fallbackDoc9 = fallbackDoc;
                    fallbackSearchResult = toFallbackSearchResult((com.fleeksoft.ksoup.nodes.Element) element$iv$iv$iv2);
                    if (fallbackSearchResult != null) {
                        destination$iv$iv2.add(fallbackSearchResult);
                    }
                    contentHtml = contentHtml9;
                    fallbackDoc = fallbackDoc9;
                }
                List fallbackRes8 = (List) destination$iv$iv2;
                return MainAPIKt.toNewSearchResponseList$default(fallbackRes8, (Boolean) null, 1, (Object) null);
            case 4:
                page7 = c00061.I$0;
                String query20 = (String) c00061.L$0;
                ResultKt.throwOnFailure($result2);
                query5 = query20;
                NiceResponse fallbackResponse8 = (NiceResponse) $result2;
                json = fallbackResponse8.getText();
                if (StringsKt.contains$default(json, "\"content\"", false, 2, (Object) null)) {
                    return MainAPIKt.toNewSearchResponseList$default(CollectionsKt.emptyList(), (Boolean) null, 1, (Object) null);
                }
                AppUtils appUtils11 = AppUtils.INSTANCE;
                if (json == null) {
                    Result.Companion companion117 = Result.Companion;
                    KType kTypeTypeOf11 = Reflection.typeOf(Map.class, KTypeProjection.Companion.invariant(Reflection.typeOf(String.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(String.class)));
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj11 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf11));
                    if (Result.exceptionOrNull-impl(obj11) == null) {
                        Result.Companion companion118 = Result.Companion;
                        obj11 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Map.class), (List) null, 2, (Object) null));
                        break;
                    }
                    if (Result.isFailure-impl(obj11)) {
                        obj11 = null;
                    }
                    deserializationStrategy2 = (KSerializer) obj11;
                    if (deserializationStrategy2 != null) {
                        objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, json);
                    } else {
                        ObjectMapper $this$readValue$iv$iv$iv15 = MainAPIKt.getMapper();
                        objDecodeFromString2 = $this$readValue$iv$iv$iv15.readValue(json, new TypeReference<Map<String, ? extends String>>() { // from class: com.Cinemacity.Cinemacity$search$$inlined$tryParseJson$1
                        });
                    }
                    break;
                } else {
                    objDecodeFromString2 = null;
                }
                map5 = (Map) objDecodeFromString2;
                if (map5 != null) {
                    str5 = str4;
                }
                contentHtml = str5;
                fallbackDoc = Ksoup.parse$default(Ksoup.INSTANCE, contentHtml, (String) null, 2, (Object) null);
                Iterable $this$mapNotNull$iv12 = fallbackDoc.select("div.dle-fast_item");
                destination$iv$iv2 = new ArrayList();
                while (r22.hasNext()) {
                    String contentHtml10 = contentHtml;
                    com.fleeksoft.ksoup.nodes.Document fallbackDoc10 = fallbackDoc;
                    fallbackSearchResult = toFallbackSearchResult((com.fleeksoft.ksoup.nodes.Element) element$iv$iv$iv2);
                    if (fallbackSearchResult != null) {
                        destination$iv$iv2.add(fallbackSearchResult);
                    }
                    contentHtml = contentHtml10;
                    fallbackDoc = fallbackDoc10;
                }
                List fallbackRes9 = (List) destination$iv$iv2;
                return MainAPIKt.toNewSearchResponseList$default(fallbackRes9, (Boolean) null, 1, (Object) null);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.lagradost.cloudstream3.ErrorLoadingException */
    /* JADX WARN: Code duplicated, block: B:102:0x079b  */
    /* JADX WARN: Code duplicated, block: B:105:0x07b2  */
    /* JADX WARN: Code duplicated, block: B:106:0x07b7  */
    /* JADX WARN: Code duplicated, block: B:110:0x0806  */
    /* JADX WARN: Code duplicated, block: B:111:0x0809  */
    /* JADX WARN: Code duplicated, block: B:114:0x0810  */
    /* JADX WARN: Code duplicated, block: B:115:0x0813  */
    /* JADX WARN: Code duplicated, block: B:119:0x0851  */
    /* JADX WARN: Code duplicated, block: B:121:0x086b  */
    /* JADX WARN: Code duplicated, block: B:126:0x0889  */
    /* JADX WARN: Code duplicated, block: B:128:0x08ae  */
    /* JADX WARN: Code duplicated, block: B:129:0x08b3  */
    /* JADX WARN: Code duplicated, block: B:132:0x08b7 A[LOOP:10: B:124:0x0883->B:132:0x08b7, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:136:0x08c8  */
    /* JADX WARN: Code duplicated, block: B:154:0x09a3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:155:0x09a4  */
    /* JADX WARN: Code duplicated, block: B:159:0x09d3 A[Catch: all -> 0x0a27, TRY_ENTER, TryCatch #3 {all -> 0x0a27, blocks: (B:156:0x09be, B:159:0x09d3, B:161:0x09d9, B:180:0x0a1c, B:169:0x09f5, B:171:0x09fd, B:173:0x0a03), top: B:544:0x09be }] */
    /* JADX WARN: Code duplicated, block: B:169:0x09f5 A[Catch: all -> 0x0a27, TryCatch #3 {all -> 0x0a27, blocks: (B:156:0x09be, B:159:0x09d3, B:161:0x09d9, B:180:0x0a1c, B:169:0x09f5, B:171:0x09fd, B:173:0x0a03), top: B:544:0x09be }] */
    /* JADX WARN: Code duplicated, block: B:171:0x09fd A[Catch: all -> 0x0a27, TryCatch #3 {all -> 0x0a27, blocks: (B:156:0x09be, B:159:0x09d3, B:161:0x09d9, B:180:0x0a1c, B:169:0x09f5, B:171:0x09fd, B:173:0x0a03), top: B:544:0x09be }] */
    /* JADX WARN: Code duplicated, block: B:179:0x0a1b  */
    /* JADX WARN: Code duplicated, block: B:203:0x0bc7  */
    /* JADX WARN: Code duplicated, block: B:206:0x0bcc  */
    /* JADX WARN: Code duplicated, block: B:207:0x0bd5  */
    /* JADX WARN: Code duplicated, block: B:209:0x0bf5  */
    /* JADX WARN: Code duplicated, block: B:212:0x0c42  */
    /* JADX WARN: Code duplicated, block: B:213:0x0c64  */
    /* JADX WARN: Code duplicated, block: B:216:0x0c6c  */
    /* JADX WARN: Code duplicated, block: B:236:0x0d60 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:237:0x0d61  */
    /* JADX WARN: Code duplicated, block: B:263:0x0f3e  */
    /* JADX WARN: Code duplicated, block: B:265:0x0f63  */
    /* JADX WARN: Code duplicated, block: B:268:0x0fc1  */
    /* JADX WARN: Code duplicated, block: B:271:0x0fc7  */
    /* JADX WARN: Code duplicated, block: B:273:0x0fd5  */
    /* JADX WARN: Code duplicated, block: B:274:0x0fd8  */
    /* JADX WARN: Code duplicated, block: B:276:0x0fdc  */
    /* JADX WARN: Code duplicated, block: B:278:0x10d4 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:279:0x10d5  */
    /* JADX WARN: Code duplicated, block: B:282:0x1106  */
    /* JADX WARN: Code duplicated, block: B:284:0x110e  */
    /* JADX WARN: Code duplicated, block: B:285:0x1113  */
    /* JADX WARN: Code duplicated, block: B:292:0x1145  */
    /* JADX WARN: Code duplicated, block: B:304:0x1183  */
    /* JADX WARN: Code duplicated, block: B:321:0x11aa  */
    /* JADX WARN: Code duplicated, block: B:332:0x11d4  */
    /* JADX WARN: Code duplicated, block: B:336:0x1258  */
    /* JADX WARN: Code duplicated, block: B:340:0x1265  */
    /* JADX WARN: Code duplicated, block: B:343:0x126f  */
    /* JADX WARN: Code duplicated, block: B:347:0x1281  */
    /* JADX WARN: Code duplicated, block: B:368:0x133e A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:372:0x135d  */
    /* JADX WARN: Code duplicated, block: B:39:0x05c2  */
    /* JADX WARN: Code duplicated, block: B:407:0x1471  */
    /* JADX WARN: Code duplicated, block: B:40:0x05c7  */
    /* JADX WARN: Code duplicated, block: B:42:0x05ca  */
    /* JADX WARN: Code duplicated, block: B:45:0x05e6  */
    /* JADX WARN: Code duplicated, block: B:46:0x05eb  */
    /* JADX WARN: Code duplicated, block: B:48:0x05ee  */
    /* JADX WARN: Code duplicated, block: B:51:0x05f9  */
    /* JADX WARN: Code duplicated, block: B:52:0x05fe  */
    /* JADX WARN: Code duplicated, block: B:535:0x19c6 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:550:0x114a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x0625  */
    /* JADX WARN: Code duplicated, block: B:589:0x118a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:614:0x0670 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:615:0x0668 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:625:0x086f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:626:0x08c5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:627:0x08be A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:69:0x0661 A[LOOP:5: B:54:0x061f->B:69:0x0661, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:90:0x0727  */
    /* JADX WARN: Code duplicated, block: B:93:0x0731  */
    /* JADX WARN: Code duplicated, block: B:94:0x0736  */
    /* JADX WARN: Code duplicated, block: B:98:0x075f  */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) throws Throwable {
        C00021 c00021;
        Object objAppGet;
        String savedLogin;
        String loginPart;
        String authCookie;
        Map<String, String> map;
        String cfCookies;
        String url2;
        NiceResponse page;
        Document doc;
        Element elementSelectFirst;
        String strAttr;
        String ogTitle;
        String title;
        Element elementSelectFirst2;
        String poster;
        Element elementSelectFirst3;
        String bgposter;
        String trailer;
        Iterator it;
        Object obj;
        String str;
        Object element$iv;
        Element element;
        String audioLanguages;
        Element elementSelectFirst4;
        String descriptions;
        Iterable $this$map$iv;
        String descriptions2;
        Collection destination$iv$iv;
        Iterable $this$mapTo$iv$iv;
        String audioLanguages2;
        List recommendation;
        Integer year;
        TvType tvType;
        TvType tvtype;
        String str2;
        String tmdbmetatype;
        Ref.ObjectRef genre;
        Ref.ObjectRef background;
        Ref.ObjectRef description;
        Iterable $this$mapNotNull$iv;
        Collection destination$iv$iv2;
        String ogTitle2;
        Iterator it2;
        String str3;
        Ref.ObjectRef genre2;
        String value;
        String imdbId;
        String str4;
        String str5;
        String authCookie2;
        Map<String, String> map2;
        NiceResponse page2;
        Ref.ObjectRef genre3;
        String imdbId2;
        Ref.ObjectRef description2;
        String trailer2;
        String tmdbmetatype2;
        Ref.ObjectRef background2;
        String str6;
        Integer year2;
        String descriptions3;
        String url3;
        List recommendation2;
        String title2;
        String bgposter2;
        String imdbId3;
        String poster2;
        TvType $result;
        List recommendation3;
        TvType tvtype2;
        Document doc2;
        String poster3;
        String title3;
        String bgposter3;
        String trailer3;
        String descriptions4;
        Object obj2;
        String audioLanguages3;
        String loginPart2;
        Ref.ObjectRef genre4;
        String title4;
        Ref.ObjectRef description3;
        Ref.ObjectRef background3;
        Ref.ObjectRef genre5;
        String poster4;
        int i;
        Object obj3;
        Document doc3;
        String trailer4;
        Iterator it3;
        MatchResult matchResultFind$default;
        String strAttr2;
        Element elementSelectFirst5;
        String strAttr3;
        Element elementSelectFirst6;
        final String posterUrl;
        Iterable iterableSelect;
        Object $result2;
        Element elementSelectFirst7;
        boolean z;
        String strText;
        Object obj4;
        Ref.ObjectRef genre6;
        String tmdbId;
        String it4;
        String logoPath;
        String tmdbmetatype3;
        String cfCookies2;
        String logoPath2;
        String imdbId4;
        String tmdbId2;
        String audioLanguages4;
        Ref.ObjectRef background4;
        Ref.ObjectRef description4;
        String str7;
        Ref.ObjectRef genre7;
        TvType tvtype3;
        String descriptions5;
        List recommendation4;
        Integer year3;
        String trailer5;
        Document doc4;
        String imdbId5;
        String title5;
        String bgposter4;
        String poster5;
        String url4;
        Document doc5;
        String title6;
        String poster6;
        String bgposter5;
        String audioLanguages5;
        Ref.ObjectRef genre8;
        String descriptions6;
        String tmdbmetatype4;
        List recommendation5;
        Integer year4;
        String descriptions7;
        String imdbId6;
        String tmdbId3;
        Ref.ObjectRef background5;
        Ref.ObjectRef description5;
        String title7;
        Ref.ObjectRef background6;
        String imdbId7;
        C00021 c00022;
        Object obj5;
        String audioLanguages6;
        Integer num;
        String strValueOf;
        JSONObject obj6;
        JSONArray jSONArrayOptJSONArray;
        JSONArray jSONArrayOptJSONArray2;
        Integer numBoxInt;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        Object obj7;
        String imdbId8;
        String creditsJson;
        Ref.ObjectRef description6;
        Ref.ObjectRef background7;
        String imdbId9;
        List<ActorData> credits;
        String typeset;
        Object obj8;
        String typeset2;
        String trailer6;
        Ref.ObjectRef description7;
        List<ActorData> list;
        Integer year5;
        Ref.ObjectRef genre9;
        String creditsJson2;
        String logoPath3;
        List recommendation6;
        String imdbId10;
        String tmdbId4;
        ResponseData responseData;
        String title8;
        String loginPart3;
        String descriptions8;
        Document doc6;
        String typeset3;
        String trailer7;
        String audioLanguages7;
        String bgposter6;
        String poster7;
        Ref.ObjectRef background8;
        TvType tvtype4;
        String str8;
        String it5;
        String descriptions9;
        String bgposter7;
        String audioLanguages8;
        String trailer8;
        String tmdbId5;
        List recommendation7;
        Integer year6;
        Ref.ObjectRef genre10;
        Ref.ObjectRef background9;
        String logoPath4;
        TvType tvtype5;
        String poster8;
        String descriptions10;
        Document doc7;
        Object obj9;
        Integer year7;
        Ref.ObjectRef description8;
        List<ActorData> list2;
        String logoPath5;
        List castList;
        String imdbId11;
        String typeset4;
        String tmdbId6;
        String it6;
        String creditsJson3;
        Ref.ObjectRef genre11;
        LinkedHashMap destination$iv$iv3;
        Element element2;
        String playerScript;
        Document doc8;
        Object rawFile;
        String decodedPlayer;
        String creditsJson4;
        JSONArray $this$load_u24lambda_u2415;
        String it7;
        JSONObject playerJson;
        String strOptString;
        JSONObject jSONObjectOptJSONObject3;
        String moviejson;
        String certification;
        ResponseData.Meta meta;
        String name;
        ResponseData.Meta meta2;
        ResponseData.Meta.AppExtras app_extras;
        ResponseData.Meta meta3;
        String name2;
        Regex seasonRegex;
        String str9;
        List groupValues;
        String str10;
        List groupValues2;
        String str11;
        String it8;
        JSONObject jSONObject;
        ResponseData.Meta meta4;
        Iterable $this$filter$iv;
        ResponseData.Meta it9;
        String description9;
        String background10;
        String text;
        ResponseData responseData2;
        Object obj10;
        Object objDecodeFromString;
        DeserializationStrategy deserializationStrategy;
        String value$iv$iv;
        Cinemacity cinemacity = this;
        if (continuation instanceof C00021) {
            c00021 = (C00021) continuation;
            if ((c00021.label & Integer.MIN_VALUE) != 0) {
                c00021.label -= Integer.MIN_VALUE;
            } else {
                c00021 = cinemacity.new C00021(continuation);
            }
        } else {
            c00021 = cinemacity.new C00021(continuation);
        }
        C00021 c00023 = c00021;
        Object $result3 = c00023.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        String str12 = "{";
        String str13 = "";
        switch (c00023.label) {
            case 0:
                ResultKt.throwOnFailure($result3);
                String savedLogin2 = CinemacityPlugin.INSTANCE.getLoginCookies();
                String str14 = savedLogin2;
                if (StringsKt.isBlank(str14)) {
                    str14 = FALLBACK_LOGIN_COOKIE;
                }
                String loginPart4 = str14;
                String cfCookies3 = CinemacityPlugin.INSTANCE.getCfCookies();
                String authCookie3 = !StringsKt.isBlank(cfCookies3) ? loginPart4 + "; " + cfCookies3 : loginPart4;
                Map<String, String> mapMapOf = MapsKt.mapOf(TuplesKt.to("Cookie", authCookie3));
                c00023.L$0 = url;
                c00023.L$1 = SpillingKt.nullOutSpilledVariable(savedLogin2);
                c00023.L$2 = SpillingKt.nullOutSpilledVariable(loginPart4);
                c00023.L$3 = SpillingKt.nullOutSpilledVariable(cfCookies3);
                c00023.L$4 = SpillingKt.nullOutSpilledVariable(authCookie3);
                c00023.L$5 = SpillingKt.nullOutSpilledVariable(mapMapOf);
                c00023.label = 1;
                objAppGet = cinemacity.appGet(url, mapMapOf, c00023);
                if (objAppGet == coroutine_suspended) {
                    return coroutine_suspended;
                }
                savedLogin = savedLogin2;
                loginPart = loginPart4;
                authCookie = authCookie3;
                map = mapMapOf;
                cfCookies = cfCookies3;
                url2 = url;
                page = (NiceResponse) objAppGet;
                doc = page.getDocument();
                elementSelectFirst = doc.selectFirst("meta[property=og:title]");
                if (elementSelectFirst != null) {
                    strAttr = elementSelectFirst.attr("content");
                } else {
                    strAttr = null;
                }
                if (strAttr == null) {
                    strAttr = "";
                }
                ogTitle = strAttr;
                title = StringsKt.trim(StringsKt.substringBefore$default(ogTitle, "(", (String) null, 2, (Object) null)).toString();
                elementSelectFirst2 = doc.selectFirst("meta[property=og:image]");
                if (elementSelectFirst2 != null) {
                    poster = elementSelectFirst2.attr("content");
                } else {
                    poster = null;
                }
                if (poster == null) {
                    poster = "";
                }
                elementSelectFirst3 = doc.selectFirst("div.dar-full_bg a");
                if (elementSelectFirst3 != null) {
                    bgposter = elementSelectFirst3.attr("href");
                } else {
                    bgposter = null;
                }
                trailer = doc.select("div.dar-full_bg.e-cover > div").attr("data-vbg");
                Iterable $this$firstOrNull$iv = doc.select("li");
                it = $this$firstOrNull$iv.iterator();
                while (true) {
                    if (it.hasNext()) {
                        element$iv = it.next();
                        $result2 = $result3;
                        Element it10 = (Element) element$iv;
                        obj = coroutine_suspended;
                        elementSelectFirst7 = it10.selectFirst("span");
                        if (elementSelectFirst7 == null && (strText = elementSelectFirst7.text()) != null) {
                            str = str12;
                            z = StringsKt.equals(strText, "Audio language", true);
                            if (!z) {
                                $result3 = $result2;
                                coroutine_suspended = obj;
                                str12 = str;
                            }
                        }
                        if (!z) {
                            $result3 = $result2;
                            coroutine_suspended = obj;
                            str12 = str;
                        }
                    } else {
                        obj = coroutine_suspended;
                        str = str12;
                        element$iv = null;
                    }
                }
                element = (Element) element$iv;
                if (element != null || (iterableSelect = element.select("span:eq(1) a")) == null) {
                    audioLanguages = null;
                } else {
                    Iterable $this$map$iv2 = iterableSelect;
                    int $i$f$map = CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10);
                    Collection destination$iv$iv4 = new ArrayList($i$f$map);
                    for (Object item$iv$iv : $this$map$iv2) {
                        Element it11 = (Element) item$iv$iv;
                        destination$iv$iv4.add(StringsKt.trim(it11.text()).toString());
                        $this$map$iv2 = $this$map$iv2;
                    }
                    Iterable $this$filter$iv2 = (List) destination$iv$iv4;
                    Collection destination$iv$iv5 = new ArrayList();
                    for (Object element$iv$iv : $this$filter$iv2) {
                        Iterable $this$filter$iv3 = $this$filter$iv2;
                        String it12 = (String) element$iv$iv;
                        if (it12.length() > 0) {
                            destination$iv$iv5.add(element$iv$iv);
                        }
                        $this$filter$iv2 = $this$filter$iv3;
                    }
                    audioLanguages = CollectionsKt.joinToString$default((List) destination$iv$iv5, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
                }
                elementSelectFirst4 = doc.selectFirst("#about div.ta-full_text1");
                if (elementSelectFirst4 != null) {
                    descriptions = elementSelectFirst4.text();
                } else {
                    descriptions = null;
                }
                $this$map$iv = doc.select("div.ta-rel > div.ta-rel_item");
                descriptions2 = descriptions;
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                $this$mapTo$iv$iv = $this$map$iv;
                for (Object item$iv$iv2 : $this$mapTo$iv$iv) {
                    Element it13 = (Element) item$iv$iv2;
                    Iterable $this$map$iv3 = $this$map$iv;
                    String audioLanguages9 = audioLanguages;
                    Iterable $this$mapTo$iv$iv2 = $this$mapTo$iv$iv;
                    String recTitle = StringsKt.trim(StringsKt.substringBefore$default(it13.select("a").text(), "(", (String) null, 2, (Object) null)).toString();
                    Cinemacity cinemacity2 = this;
                    elementSelectFirst5 = it13.selectFirst("> div > a");
                    if (elementSelectFirst5 != null || (strAttr3 = elementSelectFirst5.attr("href")) == null) {
                        strAttr3 = "";
                    }
                    String href = MainAPIKt.fixUrl(cinemacity2, strAttr3);
                    final String score = it13.select("span.rating-color1").text();
                    elementSelectFirst6 = it13.selectFirst("div > a");
                    if (elementSelectFirst6 != null) {
                        posterUrl = elementSelectFirst6.attr("href");
                    } else {
                        posterUrl = null;
                    }
                    destination$iv$iv.add(MainAPIKt.newMovieSearchResponse$default(this, recTitle, href, TvType.Movie, false, new Function1() { // from class: com.Cinemacity.Cinemacity$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj11) {
                            return Cinemacity.load$lambda$4$0(posterUrl, score, (MovieSearchResponse) obj11);
                        }
                    }, 8, (Object) null));
                    $this$map$iv = $this$map$iv3;
                    $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
                    audioLanguages = audioLanguages9;
                }
                audioLanguages2 = audioLanguages;
                recommendation = (List) destination$iv$iv;
                year = StringsKt.toIntOrNull(StringsKt.substringBefore$default(StringsKt.substringAfter(ogTitle, "(", ""), ")", (String) null, 2, (Object) null));
                if (StringsKt.contains(url2, "/movies/", true)) {
                    tvType = TvType.Movie;
                } else {
                    tvType = TvType.TvSeries;
                }
                tvtype = tvType;
                if (tvtype == TvType.TvSeries) {
                    str2 = "tv";
                } else {
                    str2 = "movie";
                }
                tmdbmetatype = str2;
                genre = new Ref.ObjectRef();
                background = new Ref.ObjectRef();
                description = new Ref.ObjectRef();
                $this$mapNotNull$iv = doc.select("div.ta-full_rating1 > div");
                destination$iv$iv2 = new ArrayList();
                for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                    Iterable $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                    Element it14 = (Element) element$iv$iv$iv;
                    String ogTitle3 = ogTitle;
                    strAttr2 = it14.attr("onclick");
                    if (strAttr2 != null) {
                        destination$iv$iv2.add(strAttr2);
                    }
                    $this$mapNotNull$iv = $this$mapNotNull$iv2;
                    ogTitle = ogTitle3;
                }
                ogTitle2 = ogTitle;
                it2 = ((List) destination$iv$iv2).iterator();
                while (true) {
                    if (it2.hasNext()) {
                        String it15 = (String) it2.next();
                        it3 = it2;
                        str3 = str13;
                        genre2 = genre;
                        matchResultFind$default = Regex.find$default(new Regex("tt\\d+"), it15, 0, 2, (Object) null);
                        if (matchResultFind$default != null) {
                            value = matchResultFind$default.getValue();
                        } else {
                            value = null;
                        }
                        if (value != null) {
                            str13 = str3;
                            genre = genre2;
                            it2 = it3;
                        }
                    } else {
                        str3 = str13;
                        genre2 = genre;
                        value = null;
                    }
                }
                imdbId = value;
                if (imdbId != null) {
                    try {
                        Result.Companion companion = Result.Companion;
                        Cinemacity $this$load_u24lambda_u247_u240 = this;
                        Requests app = MainActivityKt.getApp();
                        String str15 = "https://api.themoviedb.org/3/find/" + imdbId + "?api_key=1865f43a0549ca50d341dd9ab8b29f49&external_source=imdb_id";
                        c00023.L$0 = url2;
                        c00023.L$1 = SpillingKt.nullOutSpilledVariable(savedLogin);
                        c00023.L$2 = SpillingKt.nullOutSpilledVariable(loginPart);
                        c00023.L$3 = SpillingKt.nullOutSpilledVariable(cfCookies);
                        c00023.L$4 = SpillingKt.nullOutSpilledVariable(authCookie);
                        c00023.L$5 = SpillingKt.nullOutSpilledVariable(map);
                        c00023.L$6 = SpillingKt.nullOutSpilledVariable(page);
                        c00023.L$7 = doc;
                        c00023.L$8 = SpillingKt.nullOutSpilledVariable(ogTitle2);
                        c00023.L$9 = title;
                        c00023.L$10 = poster;
                        c00023.L$11 = bgposter;
                        c00023.L$12 = trailer;
                        try {
                            c00023.L$13 = audioLanguages2;
                            loginPart2 = url2;
                            try {
                                c00023.L$14 = descriptions2;
                                c00023.L$15 = recommendation;
                                c00023.L$16 = year;
                                c00023.L$17 = tvtype;
                                c00023.L$18 = tmdbmetatype;
                                recommendation3 = recommendation;
                                genre5 = genre2;
                                try {
                                    c00023.L$19 = genre5;
                                    poster4 = poster;
                                    try {
                                        c00023.L$20 = background;
                                        try {
                                            c00023.L$21 = description;
                                            c00023.L$22 = imdbId;
                                            c00023.L$23 = SpillingKt.nullOutSpilledVariable(imdbId);
                                            c00023.L$24 = SpillingKt.nullOutSpilledVariable($this$load_u24lambda_u247_u240);
                                            try {
                                                c00023.label = 2;
                                                doc2 = doc;
                                                title3 = title;
                                                bgposter3 = bgposter;
                                                trailer3 = trailer;
                                                audioLanguages3 = audioLanguages2;
                                                str4 = str3;
                                                poster3 = poster4;
                                                tvtype2 = tvtype;
                                                descriptions4 = descriptions2;
                                                obj2 = obj;
                                                str5 = str;
                                                i = 0;
                                                try {
                                                    obj3 = Requests.get$default(app, str15, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00023, 4094, (Object) null);
                                                    c00023 = c00023;
                                                    if (obj3 == obj2) {
                                                        return obj2;
                                                    }
                                                    authCookie2 = cfCookies;
                                                    page2 = page;
                                                    genre4 = genre5;
                                                    title4 = imdbId;
                                                    doc3 = doc2;
                                                    description3 = description;
                                                    trailer4 = trailer3;
                                                    tmdbmetatype2 = tmdbmetatype;
                                                    background3 = background;
                                                    map2 = map;
                                                    try {
                                                        obj6 = new JSONObject(((NiceResponse) obj3).getText());
                                                        jSONArrayOptJSONArray = obj6.optJSONArray("movie_results");
                                                        if (jSONArrayOptJSONArray != null || (jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i)) == null) {
                                                            jSONArrayOptJSONArray2 = obj6.optJSONArray("tv_results");
                                                            if (jSONArrayOptJSONArray2 != null || (jSONObjectOptJSONObject = jSONArrayOptJSONArray2.optJSONObject(i)) == null) {
                                                                numBoxInt = null;
                                                            } else {
                                                                numBoxInt = Boxing.boxInt(jSONObjectOptJSONObject.optInt("id"));
                                                                int it16 = numBoxInt.intValue();
                                                                int it17 = it16 != 0 ? 1 : 0;
                                                                if (it17 == 0) {
                                                                    numBoxInt = null;
                                                                }
                                                            }
                                                        } else {
                                                            numBoxInt = Boxing.boxInt(jSONObjectOptJSONObject2.optInt("id"));
                                                            int it18 = numBoxInt.intValue();
                                                            int it19 = it18 != 0 ? 1 : 0;
                                                            if (it19 == 0) {
                                                                numBoxInt = null;
                                                            }
                                                            if (numBoxInt == null) {
                                                                jSONArrayOptJSONArray2 = obj6.optJSONArray("tv_results");
                                                                if (jSONArrayOptJSONArray2 != null) {
                                                                    numBoxInt = null;
                                                                } else {
                                                                    numBoxInt = null;
                                                                }
                                                            }
                                                        }
                                                        Ref.ObjectRef objectRef = genre4;
                                                        obj4 = Result.constructor-impl(numBoxInt);
                                                        genre6 = objectRef;
                                                    } catch (Throwable th) {
                                                        th = th;
                                                        trailer3 = trailer4;
                                                        doc2 = doc3;
                                                        page = page2;
                                                        map = map2;
                                                        cfCookies = authCookie2;
                                                        Result.Companion companion2 = Result.Companion;
                                                        Ref.ObjectRef objectRef2 = genre4;
                                                        obj4 = Result.constructor-impl(ResultKt.createFailure(th));
                                                        genre6 = objectRef2;
                                                        authCookie2 = cfCookies;
                                                        map2 = map;
                                                        page2 = page;
                                                        doc3 = doc2;
                                                        trailer4 = trailer3;
                                                    }
                                                    if (Result.isFailure-impl(obj4)) {
                                                        obj4 = null;
                                                    }
                                                    num = (Integer) obj4;
                                                    if (num != null) {
                                                        strValueOf = String.valueOf(num.intValue());
                                                    } else {
                                                        strValueOf = null;
                                                    }
                                                    genre3 = genre6;
                                                    imdbId2 = title4;
                                                    background2 = background3;
                                                    str6 = strValueOf;
                                                    trailer2 = trailer4;
                                                    doc = doc3;
                                                    obj = obj2;
                                                    description2 = description3;
                                                    url3 = loginPart2;
                                                    recommendation2 = recommendation3;
                                                    title2 = title3;
                                                    bgposter2 = bgposter3;
                                                    imdbId3 = audioLanguages3;
                                                    poster2 = poster3;
                                                    year2 = year;
                                                    descriptions3 = descriptions4;
                                                    $result = tvtype2;
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    c00023 = c00023;
                                                    genre4 = genre5;
                                                    title4 = imdbId;
                                                    description3 = description;
                                                    tmdbmetatype2 = tmdbmetatype;
                                                    background3 = background;
                                                    Result.Companion companion3 = Result.Companion;
                                                    Ref.ObjectRef objectRef3 = genre4;
                                                    obj4 = Result.constructor-impl(ResultKt.createFailure(th));
                                                    genre6 = objectRef3;
                                                    authCookie2 = cfCookies;
                                                    map2 = map;
                                                    page2 = page;
                                                    doc3 = doc2;
                                                    trailer4 = trailer3;
                                                    if (Result.isFailure-impl(obj4)) {
                                                        obj4 = null;
                                                    }
                                                    num = (Integer) obj4;
                                                    if (num != null) {
                                                        strValueOf = String.valueOf(num.intValue());
                                                    } else {
                                                        strValueOf = null;
                                                    }
                                                    genre3 = genre6;
                                                    imdbId2 = title4;
                                                    background2 = background3;
                                                    str6 = strValueOf;
                                                    trailer2 = trailer4;
                                                    doc = doc3;
                                                    obj = obj2;
                                                    description2 = description3;
                                                    url3 = loginPart2;
                                                    recommendation2 = recommendation3;
                                                    title2 = title3;
                                                    bgposter2 = bgposter3;
                                                    imdbId3 = audioLanguages3;
                                                    poster2 = poster3;
                                                    year2 = year;
                                                    descriptions3 = descriptions4;
                                                    $result = tvtype2;
                                                    tmdbId = str6;
                                                    if (imdbId2 != null) {
                                                        String it20 = imdbId2;
                                                        it4 = "https://live.metahub.space/logo/medium/" + it20 + "/img";
                                                    } else {
                                                        it4 = null;
                                                    }
                                                    logoPath = it4;
                                                    if (tmdbId != null) {
                                                        try {
                                                            Result.Companion companion4 = Result.Companion;
                                                            Cinemacity $this$load_u24lambda_u249_u240 = this;
                                                            Requests app2 = MainActivityKt.getApp();
                                                            try {
                                                                String str16 = "https://api.themoviedb.org/3/" + tmdbmetatype2 + '/' + tmdbId + "/credits?api_key=1865f43a0549ca50d341dd9ab8b29f49&language=en-US";
                                                                c00023.L$0 = url3;
                                                                c00023.L$1 = SpillingKt.nullOutSpilledVariable(savedLogin);
                                                                c00023.L$2 = SpillingKt.nullOutSpilledVariable(loginPart);
                                                                c00023.L$3 = SpillingKt.nullOutSpilledVariable(authCookie2);
                                                                c00023.L$4 = SpillingKt.nullOutSpilledVariable(authCookie);
                                                                c00023.L$5 = SpillingKt.nullOutSpilledVariable(map2);
                                                                c00023.L$6 = SpillingKt.nullOutSpilledVariable(page2);
                                                                c00023.L$7 = doc;
                                                                c00023.L$8 = SpillingKt.nullOutSpilledVariable(ogTitle2);
                                                                c00023.L$9 = title2;
                                                                c00023.L$10 = poster2;
                                                                c00023.L$11 = bgposter2;
                                                                c00023.L$12 = trailer2;
                                                                c00023.L$13 = imdbId3;
                                                                c00023.L$14 = descriptions3;
                                                                c00023.L$15 = recommendation2;
                                                                c00023.L$16 = year2;
                                                                c00023.L$17 = $result;
                                                                c00023.L$18 = SpillingKt.nullOutSpilledVariable(tmdbmetatype2);
                                                                genre8 = genre3;
                                                                try {
                                                                    c00023.L$19 = genre8;
                                                                    title7 = title2;
                                                                    background5 = background2;
                                                                    try {
                                                                        c00023.L$20 = background5;
                                                                        background6 = description2;
                                                                        try {
                                                                            c00023.L$21 = background6;
                                                                            imdbId7 = imdbId2;
                                                                            try {
                                                                                c00023.L$22 = imdbId7;
                                                                                try {
                                                                                    c00023.L$23 = tmdbId;
                                                                                    try {
                                                                                        c00023.L$24 = logoPath;
                                                                                        c00023.L$25 = SpillingKt.nullOutSpilledVariable(tmdbId);
                                                                                        c00023.L$26 = SpillingKt.nullOutSpilledVariable($this$load_u24lambda_u249_u240);
                                                                                        c00023.label = 3;
                                                                                        poster6 = poster2;
                                                                                        bgposter5 = bgposter2;
                                                                                        descriptions6 = trailer2;
                                                                                        c00022 = c00023;
                                                                                        audioLanguages5 = imdbId3;
                                                                                        tmdbmetatype4 = descriptions3;
                                                                                        recommendation5 = recommendation2;
                                                                                        tmdbmetatype3 = tmdbmetatype2;
                                                                                        url4 = url3;
                                                                                        title6 = title7;
                                                                                        year4 = year2;
                                                                                        doc5 = doc;
                                                                                        try {
                                                                                            obj5 = Requests.get$default(app2, str16, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4094, (Object) null);
                                                                                            c00023 = c00022;
                                                                                            coroutine_suspended = obj;
                                                                                            if (obj5 == coroutine_suspended) {
                                                                                                return coroutine_suspended;
                                                                                            }
                                                                                            descriptions7 = logoPath;
                                                                                            imdbId6 = imdbId7;
                                                                                            tmdbId3 = tmdbId;
                                                                                            audioLanguages6 = audioLanguages5;
                                                                                            background5 = background5;
                                                                                            description5 = background6;
                                                                                            cfCookies2 = authCookie;
                                                                                            try {
                                                                                                String str17 = imdbId6;
                                                                                                obj7 = Result.constructor-impl(((NiceResponse) obj5).getText());
                                                                                                imdbId8 = str17;
                                                                                            } catch (Throwable th3) {
                                                                                                th = th3;
                                                                                                audioLanguages5 = audioLanguages6;
                                                                                                authCookie = cfCookies2;
                                                                                                Result.Companion companion5 = Result.Companion;
                                                                                                String str18 = imdbId6;
                                                                                                obj7 = Result.constructor-impl(ResultKt.createFailure(th));
                                                                                                imdbId8 = str18;
                                                                                                cfCookies2 = authCookie;
                                                                                                audioLanguages6 = audioLanguages5;
                                                                                            }
                                                                                            if (Result.isFailure-impl(obj7)) {
                                                                                                obj7 = null;
                                                                                            }
                                                                                            obj = coroutine_suspended;
                                                                                            logoPath2 = descriptions7;
                                                                                            tmdbId2 = tmdbId3;
                                                                                            str7 = (String) obj7;
                                                                                            description4 = description5;
                                                                                            audioLanguages4 = audioLanguages6;
                                                                                            imdbId4 = imdbId8;
                                                                                            background4 = background5;
                                                                                            tvtype3 = $result;
                                                                                            descriptions5 = tmdbmetatype4;
                                                                                            recommendation4 = recommendation5;
                                                                                            year3 = year4;
                                                                                            trailer5 = descriptions6;
                                                                                            title5 = title6;
                                                                                            poster5 = poster6;
                                                                                            genre7 = genre8;
                                                                                            doc4 = doc5;
                                                                                            imdbId5 = url4;
                                                                                            bgposter4 = bgposter5;
                                                                                        } catch (Throwable th4) {
                                                                                            th = th4;
                                                                                            c00023 = c00022;
                                                                                            coroutine_suspended = obj;
                                                                                            descriptions7 = logoPath;
                                                                                            imdbId6 = imdbId7;
                                                                                            tmdbId3 = tmdbId;
                                                                                            background5 = background5;
                                                                                            description5 = background6;
                                                                                            Result.Companion companion6 = Result.Companion;
                                                                                            String str19 = imdbId6;
                                                                                            obj7 = Result.constructor-impl(ResultKt.createFailure(th));
                                                                                            imdbId8 = str19;
                                                                                            cfCookies2 = authCookie;
                                                                                            audioLanguages6 = audioLanguages5;
                                                                                            if (Result.isFailure-impl(obj7)) {
                                                                                                obj7 = null;
                                                                                            }
                                                                                            obj = coroutine_suspended;
                                                                                            logoPath2 = descriptions7;
                                                                                            tmdbId2 = tmdbId3;
                                                                                            str7 = (String) obj7;
                                                                                            description4 = description5;
                                                                                            audioLanguages4 = audioLanguages6;
                                                                                            imdbId4 = imdbId8;
                                                                                            background4 = background5;
                                                                                            tvtype3 = $result;
                                                                                            descriptions5 = tmdbmetatype4;
                                                                                            recommendation4 = recommendation5;
                                                                                            year3 = year4;
                                                                                            trailer5 = descriptions6;
                                                                                            title5 = title6;
                                                                                            poster5 = poster6;
                                                                                            genre7 = genre8;
                                                                                            doc4 = doc5;
                                                                                            imdbId5 = url4;
                                                                                            bgposter4 = bgposter5;
                                                                                            creditsJson = str7;
                                                                                            description6 = description4;
                                                                                            background7 = background4;
                                                                                            imdbId9 = imdbId4;
                                                                                            credits = parseCredits(creditsJson);
                                                                                            typeset = tvtype3 == TvType.TvSeries ? "series" : "movie";
                                                                                            if (imdbId9 != null) {
                                                                                                if (StringsKt.isBlank(imdbId9)) {
                                                                                                    str8 = null;
                                                                                                } else {
                                                                                                    str8 = imdbId9;
                                                                                                }
                                                                                                if (str8 != null) {
                                                                                                    it5 = str8;
                                                                                                    Requests app3 = MainActivityKt.getApp();
                                                                                                    String poster9 = "https://v3-cinemeta.strem.io/meta/" + typeset + '/' + it5 + ".json";
                                                                                                    c00023.L$0 = imdbId5;
                                                                                                    c00023.L$1 = SpillingKt.nullOutSpilledVariable(savedLogin);
                                                                                                    c00023.L$2 = SpillingKt.nullOutSpilledVariable(loginPart);
                                                                                                    c00023.L$3 = SpillingKt.nullOutSpilledVariable(authCookie2);
                                                                                                    c00023.L$4 = SpillingKt.nullOutSpilledVariable(cfCookies2);
                                                                                                    c00023.L$5 = SpillingKt.nullOutSpilledVariable(map2);
                                                                                                    c00023.L$6 = SpillingKt.nullOutSpilledVariable(page2);
                                                                                                    c00023.L$7 = doc4;
                                                                                                    c00023.L$8 = SpillingKt.nullOutSpilledVariable(ogTitle2);
                                                                                                    c00023.L$9 = title5;
                                                                                                    c00023.L$10 = poster5;
                                                                                                    c00023.L$11 = bgposter4;
                                                                                                    c00023.L$12 = trailer5;
                                                                                                    c00023.L$13 = audioLanguages4;
                                                                                                    c00023.L$14 = descriptions5;
                                                                                                    c00023.L$15 = recommendation4;
                                                                                                    c00023.L$16 = year3;
                                                                                                    c00023.L$17 = tvtype3;
                                                                                                    c00023.L$18 = SpillingKt.nullOutSpilledVariable(tmdbmetatype3);
                                                                                                    c00023.L$19 = genre7;
                                                                                                    c00023.L$20 = background7;
                                                                                                    descriptions9 = imdbId5;
                                                                                                    c00023.L$21 = description6;
                                                                                                    c00023.L$22 = imdbId9;
                                                                                                    c00023.L$23 = tmdbId2;
                                                                                                    c00023.L$24 = logoPath2;
                                                                                                    c00023.L$25 = SpillingKt.nullOutSpilledVariable(creditsJson);
                                                                                                    c00023.L$26 = credits;
                                                                                                    c00023.L$27 = SpillingKt.nullOutSpilledVariable(typeset);
                                                                                                    c00023.L$28 = SpillingKt.nullOutSpilledVariable(it5);
                                                                                                    c00023.label = 4;
                                                                                                    bgposter7 = bgposter4;
                                                                                                    audioLanguages8 = trailer5;
                                                                                                    trailer8 = audioLanguages4;
                                                                                                    tmdbId5 = tmdbId2;
                                                                                                    C00021 c00024 = c00023;
                                                                                                    recommendation7 = recommendation4;
                                                                                                    year6 = year3;
                                                                                                    genre10 = genre7;
                                                                                                    background9 = background7;
                                                                                                    logoPath4 = logoPath2;
                                                                                                    Object obj11 = obj;
                                                                                                    tvtype5 = tvtype3;
                                                                                                    obj8 = obj11;
                                                                                                    poster8 = poster5;
                                                                                                    descriptions10 = descriptions5;
                                                                                                    doc7 = doc4;
                                                                                                    cinemacity = this;
                                                                                                    obj9 = Requests.get$default(app3, poster9, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00024, 4094, (Object) null);
                                                                                                    c00023 = c00024;
                                                                                                    if (obj9 == obj8) {
                                                                                                        return obj8;
                                                                                                    }
                                                                                                    title8 = title5;
                                                                                                    year7 = year6;
                                                                                                    description8 = description6;
                                                                                                    list2 = credits;
                                                                                                    creditsJson2 = creditsJson;
                                                                                                    logoPath5 = logoPath4;
                                                                                                    castList = recommendation7;
                                                                                                    imdbId11 = imdbId9;
                                                                                                    typeset4 = typeset;
                                                                                                    tmdbId6 = tmdbId5;
                                                                                                    it6 = it5;
                                                                                                    creditsJson3 = savedLogin;
                                                                                                    genre11 = genre10;
                                                                                                    loginPart3 = loginPart;
                                                                                                    text = ((NiceResponse) obj9).getText();
                                                                                                    Integer year8 = year7;
                                                                                                    trailer6 = str5;
                                                                                                    if (StringsKt.startsWith$default(text, trailer6, false, 2, (Object) null)) {
                                                                                                        AppUtils appUtils = AppUtils.INSTANCE;
                                                                                                        if (text == null) {
                                                                                                            objDecodeFromString = null;
                                                                                                        } else {
                                                                                                            try {
                                                                                                                try {
                                                                                                                    Result.Companion companion7 = Result.Companion;
                                                                                                                    KType kTypeTypeOf = Reflection.typeOf(ResponseData.class);
                                                                                                                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                                                                                                    obj10 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                                                                                                                } catch (Throwable th5) {
                                                                                                                    Result.Companion companion8 = Result.Companion;
                                                                                                                    obj10 = Result.constructor-impl(ResultKt.createFailure(th5));
                                                                                                                }
                                                                                                                if (Result.exceptionOrNull-impl(obj10) != null) {
                                                                                                                    try {
                                                                                                                        Result.Companion companion9 = Result.Companion;
                                                                                                                        try {
                                                                                                                            obj10 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(ResponseData.class), (List) null, 2, (Object) null));
                                                                                                                            break;
                                                                                                                        } catch (Throwable th6) {
                                                                                                                            th = th6;
                                                                                                                            try {
                                                                                                                                Result.Companion companion10 = Result.Companion;
                                                                                                                                obj10 = Result.constructor-impl(ResultKt.createFailure(th));
                                                                                                                            } catch (Exception e) {
                                                                                                                                objDecodeFromString = null;
                                                                                                                            }
                                                                                                                        }
                                                                                                                    } catch (Throwable th7) {
                                                                                                                        th = th7;
                                                                                                                    }
                                                                                                                }
                                                                                                                if (Result.isFailure-impl(obj10)) {
                                                                                                                    obj10 = null;
                                                                                                                }
                                                                                                                deserializationStrategy = (KSerializer) obj10;
                                                                                                                if (deserializationStrategy != null) {
                                                                                                                    try {
                                                                                                                        value$iv$iv = text;
                                                                                                                        try {
                                                                                                                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv$iv);
                                                                                                                        } catch (SerializationException e2) {
                                                                                                                            e$iv$iv = e2;
                                                                                                                            ArchComponentExtKt.logError((Throwable) e$iv$iv);
                                                                                                                            ObjectMapper $this$readValue$iv$iv$iv = MainAPIKt.getMapper();
                                                                                                                            String content$iv$iv$iv = value$iv$iv;
                                                                                                                            objDecodeFromString = $this$readValue$iv$iv$iv.readValue(content$iv$iv$iv, new TypeReference<ResponseData>() { // from class: com.Cinemacity.Cinemacity$load$lambda$11$$inlined$tryParseJson$1
                                                                                                                            });
                                                                                                                        } catch (Throwable th8) {
                                                                                                                            ObjectMapper $this$readValue$iv$iv$iv2 = MainAPIKt.getMapper();
                                                                                                                            String content$iv$iv$iv2 = value$iv$iv;
                                                                                                                            objDecodeFromString = $this$readValue$iv$iv$iv2.readValue(content$iv$iv$iv2, new TypeReference<ResponseData>() { // from class: com.Cinemacity.Cinemacity$load$lambda$11$$inlined$tryParseJson$1
                                                                                                                            });
                                                                                                                        }
                                                                                                                    } catch (SerializationException e3) {
                                                                                                                        e$iv$iv = e3;
                                                                                                                        value$iv$iv = text;
                                                                                                                    } catch (Throwable th9) {
                                                                                                                        value$iv$iv = text;
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    value$iv$iv = text;
                                                                                                                }
                                                                                                                ObjectMapper $this$readValue$iv$iv$iv3 = MainAPIKt.getMapper();
                                                                                                                String content$iv$iv$iv3 = value$iv$iv;
                                                                                                                objDecodeFromString = $this$readValue$iv$iv$iv3.readValue(content$iv$iv$iv3, new TypeReference<ResponseData>() { // from class: com.Cinemacity.Cinemacity$load$lambda$11$$inlined$tryParseJson$1
                                                                                                                });
                                                                                                            } catch (Exception e4) {
                                                                                                                objDecodeFromString = null;
                                                                                                                responseData2 = (ResponseData) objDecodeFromString;
                                                                                                                year5 = year8;
                                                                                                                responseData = responseData2;
                                                                                                                typeset2 = typeset4;
                                                                                                                logoPath3 = logoPath5;
                                                                                                                description7 = description8;
                                                                                                                tmdbId4 = tmdbId6;
                                                                                                                imdbId10 = imdbId11;
                                                                                                                list = list2;
                                                                                                                genre9 = genre11;
                                                                                                                recommendation6 = castList;
                                                                                                                savedLogin = creditsJson3;
                                                                                                                descriptions8 = descriptions10;
                                                                                                                doc6 = doc7;
                                                                                                                typeset3 = descriptions9;
                                                                                                                trailer7 = audioLanguages8;
                                                                                                                audioLanguages7 = trailer8;
                                                                                                                tvtype4 = tvtype5;
                                                                                                                bgposter6 = bgposter7;
                                                                                                                poster7 = poster8;
                                                                                                                background8 = background9;
                                                                                                                if (responseData != null) {
                                                                                                                    description9 = it9.getDescription();
                                                                                                                    if (description9 == null) {
                                                                                                                        description9 = descriptions8;
                                                                                                                    }
                                                                                                                    description7.element = description9;
                                                                                                                    background10 = it9.getBackground();
                                                                                                                    if (background10 == null) {
                                                                                                                        background10 = poster7;
                                                                                                                    }
                                                                                                                    background8.element = background10;
                                                                                                                    genre9.element = it9.getGenres();
                                                                                                                    Unit unit = Unit.INSTANCE;
                                                                                                                }
                                                                                                                destination$iv$iv3 = responseData == null ? MapsKt.emptyMap() : MapsKt.emptyMap();
                                                                                                                element2 = (Element) CollectionsKt.getOrNull(doc6.select("script:containsData(atob)"), 1);
                                                                                                                if (element2 != null) {
                                                                                                                }
                                                                                                                throw new IllegalStateException("PlayerJS not found; only torrent links available".toString());
                                                                                                            }
                                                                                                        }
                                                                                                        responseData2 = (ResponseData) objDecodeFromString;
                                                                                                    } else {
                                                                                                        responseData2 = null;
                                                                                                    }
                                                                                                    year5 = year8;
                                                                                                    responseData = responseData2;
                                                                                                    typeset2 = typeset4;
                                                                                                    logoPath3 = logoPath5;
                                                                                                    description7 = description8;
                                                                                                    tmdbId4 = tmdbId6;
                                                                                                    imdbId10 = imdbId11;
                                                                                                    list = list2;
                                                                                                    genre9 = genre11;
                                                                                                    recommendation6 = castList;
                                                                                                    savedLogin = creditsJson3;
                                                                                                    descriptions8 = descriptions10;
                                                                                                    doc6 = doc7;
                                                                                                    typeset3 = descriptions9;
                                                                                                    trailer7 = audioLanguages8;
                                                                                                    audioLanguages7 = trailer8;
                                                                                                    tvtype4 = tvtype5;
                                                                                                    bgposter6 = bgposter7;
                                                                                                    poster7 = poster8;
                                                                                                    background8 = background9;
                                                                                                    break;
                                                                                                }
                                                                                                if (responseData != null) {
                                                                                                    description9 = it9.getDescription();
                                                                                                    if (description9 == null) {
                                                                                                        description9 = descriptions8;
                                                                                                    }
                                                                                                    description7.element = description9;
                                                                                                    background10 = it9.getBackground();
                                                                                                    if (background10 == null) {
                                                                                                        background10 = poster7;
                                                                                                    }
                                                                                                    background8.element = background10;
                                                                                                    genre9.element = it9.getGenres();
                                                                                                    Unit unit2 = Unit.INSTANCE;
                                                                                                }
                                                                                                if (responseData == null) {
                                                                                                }
                                                                                                element2 = (Element) CollectionsKt.getOrNull(doc6.select("script:containsData(atob)"), 1);
                                                                                                if (element2 != null) {
                                                                                                }
                                                                                                throw new IllegalStateException("PlayerJS not found; only torrent links available".toString());
                                                                                            }
                                                                                            Object obj12 = obj;
                                                                                            TvType tvtype6 = tvtype3;
                                                                                            obj8 = obj12;
                                                                                            String url5 = imdbId5;
                                                                                            Document doc9 = doc4;
                                                                                            typeset2 = typeset;
                                                                                            String poster10 = poster5;
                                                                                            String bgposter8 = bgposter4;
                                                                                            String trailer9 = trailer5;
                                                                                            cinemacity = this;
                                                                                            trailer6 = str5;
                                                                                            description7 = description6;
                                                                                            list = credits;
                                                                                            year5 = year3;
                                                                                            genre9 = genre7;
                                                                                            creditsJson2 = creditsJson;
                                                                                            logoPath3 = logoPath2;
                                                                                            recommendation6 = recommendation4;
                                                                                            imdbId10 = imdbId9;
                                                                                            tmdbId4 = tmdbId2;
                                                                                            responseData = null;
                                                                                            title8 = title5;
                                                                                            loginPart3 = loginPart;
                                                                                            descriptions8 = descriptions5;
                                                                                            doc6 = doc9;
                                                                                            typeset3 = url5;
                                                                                            trailer7 = trailer9;
                                                                                            audioLanguages7 = audioLanguages4;
                                                                                            bgposter6 = bgposter8;
                                                                                            poster7 = poster10;
                                                                                            background8 = background7;
                                                                                            tvtype4 = tvtype6;
                                                                                            if (responseData != null) {
                                                                                                description9 = it9.getDescription();
                                                                                                if (description9 == null) {
                                                                                                    description9 = descriptions8;
                                                                                                }
                                                                                                description7.element = description9;
                                                                                                background10 = it9.getBackground();
                                                                                                if (background10 == null) {
                                                                                                    background10 = poster7;
                                                                                                }
                                                                                                background8.element = background10;
                                                                                                genre9.element = it9.getGenres();
                                                                                                Unit unit3 = Unit.INSTANCE;
                                                                                            }
                                                                                            if (responseData == null) {
                                                                                            }
                                                                                            element2 = (Element) CollectionsKt.getOrNull(doc6.select("script:containsData(atob)"), 1);
                                                                                            if (element2 != null) {
                                                                                            }
                                                                                            throw new IllegalStateException("PlayerJS not found; only torrent links available".toString());
                                                                                        }
                                                                                    } catch (Throwable th10) {
                                                                                        th = th10;
                                                                                        url4 = url3;
                                                                                        doc5 = doc;
                                                                                        poster6 = poster2;
                                                                                        bgposter5 = bgposter2;
                                                                                        descriptions6 = trailer2;
                                                                                        audioLanguages5 = imdbId3;
                                                                                        tmdbmetatype4 = descriptions3;
                                                                                        recommendation5 = recommendation2;
                                                                                        tmdbmetatype3 = tmdbmetatype2;
                                                                                        title6 = title7;
                                                                                        coroutine_suspended = obj;
                                                                                        year4 = year2;
                                                                                        descriptions7 = logoPath;
                                                                                        imdbId6 = imdbId7;
                                                                                        tmdbId3 = tmdbId;
                                                                                        background5 = background5;
                                                                                        description5 = background6;
                                                                                    }
                                                                                } catch (Throwable th11) {
                                                                                    th = th11;
                                                                                    url4 = url3;
                                                                                    doc5 = doc;
                                                                                    poster6 = poster2;
                                                                                    bgposter5 = bgposter2;
                                                                                    descriptions6 = trailer2;
                                                                                    audioLanguages5 = imdbId3;
                                                                                    tmdbmetatype4 = descriptions3;
                                                                                    recommendation5 = recommendation2;
                                                                                    tmdbmetatype3 = tmdbmetatype2;
                                                                                    title6 = title7;
                                                                                    coroutine_suspended = obj;
                                                                                    year4 = year2;
                                                                                    descriptions7 = logoPath;
                                                                                    imdbId6 = imdbId7;
                                                                                    tmdbId3 = tmdbId;
                                                                                    background5 = background5;
                                                                                    description5 = background6;
                                                                                }
                                                                            } catch (Throwable th12) {
                                                                                th = th12;
                                                                                url4 = url3;
                                                                                doc5 = doc;
                                                                                poster6 = poster2;
                                                                                bgposter5 = bgposter2;
                                                                                descriptions6 = trailer2;
                                                                                audioLanguages5 = imdbId3;
                                                                                tmdbmetatype4 = descriptions3;
                                                                                tmdbmetatype3 = tmdbmetatype2;
                                                                                title6 = title7;
                                                                                coroutine_suspended = obj;
                                                                                recommendation5 = recommendation2;
                                                                                year4 = year2;
                                                                                descriptions7 = logoPath;
                                                                                imdbId6 = imdbId7;
                                                                                tmdbId3 = tmdbId;
                                                                                background5 = background5;
                                                                                description5 = background6;
                                                                            }
                                                                        } catch (Throwable th13) {
                                                                            th = th13;
                                                                            url4 = url3;
                                                                            doc5 = doc;
                                                                            poster6 = poster2;
                                                                            bgposter5 = bgposter2;
                                                                            descriptions6 = trailer2;
                                                                            audioLanguages5 = imdbId3;
                                                                            tmdbmetatype4 = descriptions3;
                                                                            year4 = year2;
                                                                            tmdbmetatype3 = tmdbmetatype2;
                                                                            title6 = title7;
                                                                            coroutine_suspended = obj;
                                                                            recommendation5 = recommendation2;
                                                                            descriptions7 = logoPath;
                                                                            imdbId6 = imdbId2;
                                                                            tmdbId3 = tmdbId;
                                                                            background5 = background5;
                                                                            description5 = background6;
                                                                        }
                                                                    } catch (Throwable th14) {
                                                                        th = th14;
                                                                        url4 = url3;
                                                                        doc5 = doc;
                                                                        poster6 = poster2;
                                                                        bgposter5 = bgposter2;
                                                                        descriptions6 = trailer2;
                                                                        audioLanguages5 = imdbId3;
                                                                        tmdbmetatype4 = descriptions3;
                                                                        tmdbmetatype3 = tmdbmetatype2;
                                                                        title6 = title7;
                                                                        coroutine_suspended = obj;
                                                                        recommendation5 = recommendation2;
                                                                        year4 = year2;
                                                                        descriptions7 = logoPath;
                                                                        imdbId6 = imdbId2;
                                                                        tmdbId3 = tmdbId;
                                                                        description5 = description2;
                                                                    }
                                                                } catch (Throwable th15) {
                                                                    th = th15;
                                                                    url4 = url3;
                                                                    doc5 = doc;
                                                                    title6 = title2;
                                                                    poster6 = poster2;
                                                                    bgposter5 = bgposter2;
                                                                    descriptions6 = trailer2;
                                                                    audioLanguages5 = imdbId3;
                                                                    tmdbmetatype3 = tmdbmetatype2;
                                                                    Ref.ObjectRef objectRef4 = background2;
                                                                    coroutine_suspended = obj;
                                                                    tmdbmetatype4 = descriptions3;
                                                                    recommendation5 = recommendation2;
                                                                    year4 = year2;
                                                                    descriptions7 = logoPath;
                                                                    imdbId6 = imdbId2;
                                                                    tmdbId3 = tmdbId;
                                                                    background5 = objectRef4;
                                                                    description5 = description2;
                                                                }
                                                            } catch (Throwable th16) {
                                                                th = th16;
                                                                url4 = url3;
                                                                doc5 = doc;
                                                                title6 = title2;
                                                                poster6 = poster2;
                                                                bgposter5 = bgposter2;
                                                                audioLanguages5 = imdbId3;
                                                                tmdbmetatype3 = tmdbmetatype2;
                                                                Ref.ObjectRef objectRef5 = background2;
                                                                Ref.ObjectRef objectRef6 = description2;
                                                                genre8 = genre3;
                                                                coroutine_suspended = obj;
                                                                descriptions6 = trailer2;
                                                                tmdbmetatype4 = descriptions3;
                                                                recommendation5 = recommendation2;
                                                                year4 = year2;
                                                                descriptions7 = logoPath;
                                                                imdbId6 = imdbId2;
                                                                tmdbId3 = tmdbId;
                                                                background5 = objectRef5;
                                                                description5 = objectRef6;
                                                            }
                                                        } catch (Throwable th17) {
                                                            th = th17;
                                                            url4 = url3;
                                                            doc5 = doc;
                                                            title6 = title2;
                                                            poster6 = poster2;
                                                            bgposter5 = bgposter2;
                                                            audioLanguages5 = imdbId3;
                                                            tmdbmetatype3 = tmdbmetatype2;
                                                            Ref.ObjectRef objectRef7 = background2;
                                                            Ref.ObjectRef objectRef8 = description2;
                                                            genre8 = genre3;
                                                            coroutine_suspended = obj;
                                                            descriptions6 = trailer2;
                                                            tmdbmetatype4 = descriptions3;
                                                            recommendation5 = recommendation2;
                                                            year4 = year2;
                                                            descriptions7 = logoPath;
                                                            imdbId6 = imdbId2;
                                                            tmdbId3 = tmdbId;
                                                            background5 = objectRef7;
                                                            description5 = objectRef8;
                                                        }
                                                    } else {
                                                        String url6 = url3;
                                                        String poster11 = poster2;
                                                        String bgposter9 = bgposter2;
                                                        String audioLanguages10 = imdbId3;
                                                        tmdbmetatype3 = tmdbmetatype2;
                                                        String trailer10 = trailer2;
                                                        List recommendation8 = recommendation2;
                                                        Integer year9 = year2;
                                                        cfCookies2 = authCookie;
                                                        logoPath2 = logoPath;
                                                        imdbId4 = imdbId2;
                                                        tmdbId2 = tmdbId;
                                                        audioLanguages4 = audioLanguages10;
                                                        background4 = background2;
                                                        description4 = description2;
                                                        str7 = null;
                                                        genre7 = genre3;
                                                        tvtype3 = $result;
                                                        descriptions5 = descriptions3;
                                                        recommendation4 = recommendation8;
                                                        year3 = year9;
                                                        trailer5 = trailer10;
                                                        doc4 = doc;
                                                        imdbId5 = url6;
                                                        title5 = title2;
                                                        bgposter4 = bgposter9;
                                                        poster5 = poster11;
                                                    }
                                                    creditsJson = str7;
                                                    description6 = description4;
                                                    background7 = background4;
                                                    imdbId9 = imdbId4;
                                                    credits = parseCredits(creditsJson);
                                                    typeset = tvtype3 == TvType.TvSeries ? "series" : "movie";
                                                    if (imdbId9 != null) {
                                                        if (StringsKt.isBlank(imdbId9)) {
                                                            str8 = imdbId9;
                                                        } else {
                                                            str8 = null;
                                                        }
                                                        if (str8 != null) {
                                                            it5 = str8;
                                                            Requests app4 = MainActivityKt.getApp();
                                                            String poster12 = "https://v3-cinemeta.strem.io/meta/" + typeset + '/' + it5 + ".json";
                                                            c00023.L$0 = imdbId5;
                                                            c00023.L$1 = SpillingKt.nullOutSpilledVariable(savedLogin);
                                                            c00023.L$2 = SpillingKt.nullOutSpilledVariable(loginPart);
                                                            c00023.L$3 = SpillingKt.nullOutSpilledVariable(authCookie2);
                                                            c00023.L$4 = SpillingKt.nullOutSpilledVariable(cfCookies2);
                                                            c00023.L$5 = SpillingKt.nullOutSpilledVariable(map2);
                                                            c00023.L$6 = SpillingKt.nullOutSpilledVariable(page2);
                                                            c00023.L$7 = doc4;
                                                            c00023.L$8 = SpillingKt.nullOutSpilledVariable(ogTitle2);
                                                            c00023.L$9 = title5;
                                                            c00023.L$10 = poster5;
                                                            c00023.L$11 = bgposter4;
                                                            c00023.L$12 = trailer5;
                                                            c00023.L$13 = audioLanguages4;
                                                            c00023.L$14 = descriptions5;
                                                            c00023.L$15 = recommendation4;
                                                            c00023.L$16 = year3;
                                                            c00023.L$17 = tvtype3;
                                                            c00023.L$18 = SpillingKt.nullOutSpilledVariable(tmdbmetatype3);
                                                            c00023.L$19 = genre7;
                                                            c00023.L$20 = background7;
                                                            descriptions9 = imdbId5;
                                                            c00023.L$21 = description6;
                                                            c00023.L$22 = imdbId9;
                                                            c00023.L$23 = tmdbId2;
                                                            c00023.L$24 = logoPath2;
                                                            c00023.L$25 = SpillingKt.nullOutSpilledVariable(creditsJson);
                                                            c00023.L$26 = credits;
                                                            c00023.L$27 = SpillingKt.nullOutSpilledVariable(typeset);
                                                            c00023.L$28 = SpillingKt.nullOutSpilledVariable(it5);
                                                            c00023.label = 4;
                                                            bgposter7 = bgposter4;
                                                            audioLanguages8 = trailer5;
                                                            trailer8 = audioLanguages4;
                                                            tmdbId5 = tmdbId2;
                                                            C00021 c00025 = c00023;
                                                            recommendation7 = recommendation4;
                                                            year6 = year3;
                                                            genre10 = genre7;
                                                            background9 = background7;
                                                            logoPath4 = logoPath2;
                                                            Object obj13 = obj;
                                                            tvtype5 = tvtype3;
                                                            obj8 = obj13;
                                                            poster8 = poster5;
                                                            descriptions10 = descriptions5;
                                                            doc7 = doc4;
                                                            cinemacity = this;
                                                            obj9 = Requests.get$default(app4, poster12, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00025, 4094, (Object) null);
                                                            c00023 = c00025;
                                                            if (obj9 == obj8) {
                                                                return obj8;
                                                            }
                                                            title8 = title5;
                                                            year7 = year6;
                                                            description8 = description6;
                                                            list2 = credits;
                                                            creditsJson2 = creditsJson;
                                                            logoPath5 = logoPath4;
                                                            castList = recommendation7;
                                                            imdbId11 = imdbId9;
                                                            typeset4 = typeset;
                                                            tmdbId6 = tmdbId5;
                                                            it6 = it5;
                                                            creditsJson3 = savedLogin;
                                                            genre11 = genre10;
                                                            loginPart3 = loginPart;
                                                            text = ((NiceResponse) obj9).getText();
                                                            Integer year10 = year7;
                                                            trailer6 = str5;
                                                            if (StringsKt.startsWith$default(text, trailer6, false, 2, (Object) null)) {
                                                                AppUtils appUtils2 = AppUtils.INSTANCE;
                                                                if (text == null) {
                                                                    objDecodeFromString = null;
                                                                } else {
                                                                    Result.Companion companion11 = Result.Companion;
                                                                    KType kTypeTypeOf2 = Reflection.typeOf(ResponseData.class);
                                                                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                                                    obj10 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                                                                    if (Result.exceptionOrNull-impl(obj10) != null) {
                                                                        Result.Companion companion12 = Result.Companion;
                                                                        obj10 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(ResponseData.class), (List) null, 2, (Object) null));
                                                                        break;
                                                                    }
                                                                    if (Result.isFailure-impl(obj10)) {
                                                                        obj10 = null;
                                                                    }
                                                                    deserializationStrategy = (KSerializer) obj10;
                                                                    if (deserializationStrategy != null) {
                                                                        value$iv$iv = text;
                                                                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv$iv);
                                                                    } else {
                                                                        value$iv$iv = text;
                                                                    }
                                                                    ObjectMapper $this$readValue$iv$iv$iv4 = MainAPIKt.getMapper();
                                                                    String content$iv$iv$iv4 = value$iv$iv;
                                                                    objDecodeFromString = $this$readValue$iv$iv$iv4.readValue(content$iv$iv$iv4, new TypeReference<ResponseData>() { // from class: com.Cinemacity.Cinemacity$load$lambda$11$$inlined$tryParseJson$1
                                                                    });
                                                                }
                                                                responseData2 = (ResponseData) objDecodeFromString;
                                                            } else {
                                                                responseData2 = null;
                                                            }
                                                            year5 = year10;
                                                            responseData = responseData2;
                                                            typeset2 = typeset4;
                                                            logoPath3 = logoPath5;
                                                            description7 = description8;
                                                            tmdbId4 = tmdbId6;
                                                            imdbId10 = imdbId11;
                                                            list = list2;
                                                            genre9 = genre11;
                                                            recommendation6 = castList;
                                                            savedLogin = creditsJson3;
                                                            descriptions8 = descriptions10;
                                                            doc6 = doc7;
                                                            typeset3 = descriptions9;
                                                            trailer7 = audioLanguages8;
                                                            audioLanguages7 = trailer8;
                                                            tvtype4 = tvtype5;
                                                            bgposter6 = bgposter7;
                                                            poster7 = poster8;
                                                            background8 = background9;
                                                            break;
                                                        }
                                                        if (responseData != null) {
                                                            description9 = it9.getDescription();
                                                            if (description9 == null) {
                                                                description9 = descriptions8;
                                                            }
                                                            description7.element = description9;
                                                            background10 = it9.getBackground();
                                                            if (background10 == null) {
                                                                background10 = poster7;
                                                            }
                                                            background8.element = background10;
                                                            genre9.element = it9.getGenres();
                                                            Unit unit4 = Unit.INSTANCE;
                                                        }
                                                        if (responseData == null) {
                                                        }
                                                        element2 = (Element) CollectionsKt.getOrNull(doc6.select("script:containsData(atob)"), 1);
                                                        if (element2 != null) {
                                                        }
                                                        throw new IllegalStateException("PlayerJS not found; only torrent links available".toString());
                                                    }
                                                    Object obj14 = obj;
                                                    TvType tvtype7 = tvtype3;
                                                    obj8 = obj14;
                                                    String url7 = imdbId5;
                                                    Document doc10 = doc4;
                                                    typeset2 = typeset;
                                                    String poster13 = poster5;
                                                    String bgposter10 = bgposter4;
                                                    String trailer11 = trailer5;
                                                    cinemacity = this;
                                                    trailer6 = str5;
                                                    description7 = description6;
                                                    list = credits;
                                                    year5 = year3;
                                                    genre9 = genre7;
                                                    creditsJson2 = creditsJson;
                                                    logoPath3 = logoPath2;
                                                    recommendation6 = recommendation4;
                                                    imdbId10 = imdbId9;
                                                    tmdbId4 = tmdbId2;
                                                    responseData = null;
                                                    title8 = title5;
                                                    loginPart3 = loginPart;
                                                    descriptions8 = descriptions5;
                                                    doc6 = doc10;
                                                    typeset3 = url7;
                                                    trailer7 = trailer11;
                                                    audioLanguages7 = audioLanguages4;
                                                    bgposter6 = bgposter10;
                                                    poster7 = poster13;
                                                    background8 = background7;
                                                    tvtype4 = tvtype7;
                                                    if (responseData != null) {
                                                        description9 = it9.getDescription();
                                                        if (description9 == null) {
                                                            description9 = descriptions8;
                                                        }
                                                        description7.element = description9;
                                                        background10 = it9.getBackground();
                                                        if (background10 == null) {
                                                            background10 = poster7;
                                                        }
                                                        background8.element = background10;
                                                        genre9.element = it9.getGenres();
                                                        Unit unit5 = Unit.INSTANCE;
                                                    }
                                                    if (responseData == null) {
                                                    }
                                                    element2 = (Element) CollectionsKt.getOrNull(doc6.select("script:containsData(atob)"), 1);
                                                    if (element2 != null) {
                                                    }
                                                    throw new IllegalStateException("PlayerJS not found; only torrent links available".toString());
                                                }
                                            } catch (Throwable th18) {
                                                th = th18;
                                                descriptions4 = descriptions2;
                                                tvtype2 = tvtype;
                                                doc2 = doc;
                                                title3 = title;
                                                bgposter3 = bgposter;
                                                trailer3 = trailer;
                                                audioLanguages3 = audioLanguages2;
                                                str4 = str3;
                                                poster3 = poster4;
                                                obj2 = obj;
                                                str5 = str;
                                                genre4 = genre5;
                                                title4 = imdbId;
                                                description3 = description;
                                                tmdbmetatype2 = tmdbmetatype;
                                                background3 = background;
                                            }
                                        } catch (Throwable th19) {
                                            th = th19;
                                            descriptions4 = descriptions2;
                                            tvtype2 = tvtype;
                                            doc2 = doc;
                                            title3 = title;
                                            bgposter3 = bgposter;
                                            trailer3 = trailer;
                                            audioLanguages3 = audioLanguages2;
                                            str4 = str3;
                                            poster3 = poster4;
                                            obj2 = obj;
                                            str5 = str;
                                            genre4 = genre5;
                                            title4 = imdbId;
                                            description3 = description;
                                            tmdbmetatype2 = tmdbmetatype;
                                            background3 = background;
                                        }
                                    } catch (Throwable th20) {
                                        th = th20;
                                        descriptions4 = descriptions2;
                                        tvtype2 = tvtype;
                                        doc2 = doc;
                                        title3 = title;
                                        bgposter3 = bgposter;
                                        trailer3 = trailer;
                                        audioLanguages3 = audioLanguages2;
                                        str4 = str3;
                                        poster3 = poster4;
                                        str5 = str;
                                        obj2 = obj;
                                        genre4 = genre5;
                                        title4 = imdbId;
                                        description3 = description;
                                        tmdbmetatype2 = tmdbmetatype;
                                        background3 = background;
                                    }
                                } catch (Throwable th21) {
                                    th = th21;
                                    descriptions4 = descriptions2;
                                    tvtype2 = tvtype;
                                    doc2 = doc;
                                    poster3 = poster;
                                    title3 = title;
                                    bgposter3 = bgposter;
                                    trailer3 = trailer;
                                    audioLanguages3 = audioLanguages2;
                                    str4 = str3;
                                    str5 = str;
                                    obj2 = obj;
                                    genre4 = genre5;
                                    title4 = imdbId;
                                    description3 = description;
                                    tmdbmetatype2 = tmdbmetatype;
                                    background3 = background;
                                }
                            } catch (Throwable th22) {
                                th = th22;
                                recommendation3 = recommendation;
                                descriptions4 = descriptions2;
                                tvtype2 = tvtype;
                                doc2 = doc;
                                poster3 = poster;
                                title3 = title;
                                bgposter3 = bgposter;
                                trailer3 = trailer;
                                audioLanguages3 = audioLanguages2;
                                str4 = str3;
                                obj2 = obj;
                                str5 = str;
                                genre4 = genre2;
                                title4 = imdbId;
                                description3 = description;
                                tmdbmetatype2 = tmdbmetatype;
                                background3 = background;
                            }
                        } catch (Throwable th23) {
                            th = th23;
                            recommendation3 = recommendation;
                            loginPart2 = url2;
                            tvtype2 = tvtype;
                            doc2 = doc;
                            poster3 = poster;
                            title3 = title;
                            bgposter3 = bgposter;
                            trailer3 = trailer;
                            audioLanguages3 = audioLanguages2;
                            str4 = str3;
                            descriptions4 = descriptions2;
                            obj2 = obj;
                            str5 = str;
                            genre4 = genre2;
                            title4 = imdbId;
                            description3 = description;
                            tmdbmetatype2 = tmdbmetatype;
                            background3 = background;
                        }
                    } catch (Throwable th24) {
                        th = th24;
                        recommendation3 = recommendation;
                        tvtype2 = tvtype;
                        doc2 = doc;
                        poster3 = poster;
                        title3 = title;
                        bgposter3 = bgposter;
                        trailer3 = trailer;
                        str4 = str3;
                        descriptions4 = descriptions2;
                        obj2 = obj;
                        str5 = str;
                        audioLanguages3 = audioLanguages2;
                        loginPart2 = url2;
                        genre4 = genre2;
                        title4 = imdbId;
                        description3 = description;
                        tmdbmetatype2 = tmdbmetatype;
                        background3 = background;
                    }
                } else {
                    String poster14 = poster;
                    String bgposter11 = bgposter;
                    str4 = str3;
                    str5 = str;
                    String audioLanguages11 = url2;
                    authCookie2 = cfCookies;
                    map2 = map;
                    page2 = page;
                    genre3 = genre2;
                    imdbId2 = imdbId;
                    description2 = description;
                    trailer2 = trailer;
                    tmdbmetatype2 = tmdbmetatype;
                    background2 = background;
                    str6 = null;
                    year2 = year;
                    descriptions3 = descriptions2;
                    url3 = audioLanguages11;
                    recommendation2 = recommendation;
                    title2 = title;
                    bgposter2 = bgposter11;
                    imdbId3 = audioLanguages2;
                    poster2 = poster14;
                    $result = tvtype;
                }
                tmdbId = str6;
                if (imdbId2 != null) {
                    String it21 = imdbId2;
                    it4 = "https://live.metahub.space/logo/medium/" + it21 + "/img";
                } else {
                    it4 = null;
                }
                logoPath = it4;
                if (tmdbId != null) {
                    Result.Companion companion13 = Result.Companion;
                    Cinemacity $this$load_u24lambda_u249_u241 = this;
                    Requests app5 = MainActivityKt.getApp();
                    String str110 = "https://api.themoviedb.org/3/" + tmdbmetatype2 + '/' + tmdbId + "/credits?api_key=1865f43a0549ca50d341dd9ab8b29f49&language=en-US";
                    c00023.L$0 = url3;
                    c00023.L$1 = SpillingKt.nullOutSpilledVariable(savedLogin);
                    c00023.L$2 = SpillingKt.nullOutSpilledVariable(loginPart);
                    c00023.L$3 = SpillingKt.nullOutSpilledVariable(authCookie2);
                    c00023.L$4 = SpillingKt.nullOutSpilledVariable(authCookie);
                    c00023.L$5 = SpillingKt.nullOutSpilledVariable(map2);
                    c00023.L$6 = SpillingKt.nullOutSpilledVariable(page2);
                    c00023.L$7 = doc;
                    c00023.L$8 = SpillingKt.nullOutSpilledVariable(ogTitle2);
                    c00023.L$9 = title2;
                    c00023.L$10 = poster2;
                    c00023.L$11 = bgposter2;
                    c00023.L$12 = trailer2;
                    c00023.L$13 = imdbId3;
                    c00023.L$14 = descriptions3;
                    c00023.L$15 = recommendation2;
                    c00023.L$16 = year2;
                    c00023.L$17 = $result;
                    c00023.L$18 = SpillingKt.nullOutSpilledVariable(tmdbmetatype2);
                    genre8 = genre3;
                    c00023.L$19 = genre8;
                    title7 = title2;
                    background5 = background2;
                    c00023.L$20 = background5;
                    background6 = description2;
                    c00023.L$21 = background6;
                    imdbId7 = imdbId2;
                    c00023.L$22 = imdbId7;
                    c00023.L$23 = tmdbId;
                    c00023.L$24 = logoPath;
                    c00023.L$25 = SpillingKt.nullOutSpilledVariable(tmdbId);
                    c00023.L$26 = SpillingKt.nullOutSpilledVariable($this$load_u24lambda_u249_u241);
                    c00023.label = 3;
                    poster6 = poster2;
                    bgposter5 = bgposter2;
                    descriptions6 = trailer2;
                    c00022 = c00023;
                    audioLanguages5 = imdbId3;
                    tmdbmetatype4 = descriptions3;
                    recommendation5 = recommendation2;
                    tmdbmetatype3 = tmdbmetatype2;
                    url4 = url3;
                    title6 = title7;
                    year4 = year2;
                    doc5 = doc;
                    obj5 = Requests.get$default(app5, str110, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4094, (Object) null);
                    c00023 = c00022;
                    coroutine_suspended = obj;
                    if (obj5 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    descriptions7 = logoPath;
                    imdbId6 = imdbId7;
                    tmdbId3 = tmdbId;
                    audioLanguages6 = audioLanguages5;
                    background5 = background5;
                    description5 = background6;
                    cfCookies2 = authCookie;
                    String str111 = imdbId6;
                    obj7 = Result.constructor-impl(((NiceResponse) obj5).getText());
                    imdbId8 = str111;
                    if (Result.isFailure-impl(obj7)) {
                        obj7 = null;
                    }
                    obj = coroutine_suspended;
                    logoPath2 = descriptions7;
                    tmdbId2 = tmdbId3;
                    str7 = (String) obj7;
                    description4 = description5;
                    audioLanguages4 = audioLanguages6;
                    imdbId4 = imdbId8;
                    background4 = background5;
                    tvtype3 = $result;
                    descriptions5 = tmdbmetatype4;
                    recommendation4 = recommendation5;
                    year3 = year4;
                    trailer5 = descriptions6;
                    title5 = title6;
                    poster5 = poster6;
                    genre7 = genre8;
                    doc4 = doc5;
                    imdbId5 = url4;
                    bgposter4 = bgposter5;
                } else {
                    String url8 = url3;
                    String poster15 = poster2;
                    String bgposter12 = bgposter2;
                    String audioLanguages12 = imdbId3;
                    tmdbmetatype3 = tmdbmetatype2;
                    String trailer12 = trailer2;
                    List recommendation9 = recommendation2;
                    Integer year11 = year2;
                    cfCookies2 = authCookie;
                    logoPath2 = logoPath;
                    imdbId4 = imdbId2;
                    tmdbId2 = tmdbId;
                    audioLanguages4 = audioLanguages12;
                    background4 = background2;
                    description4 = description2;
                    str7 = null;
                    genre7 = genre3;
                    tvtype3 = $result;
                    descriptions5 = descriptions3;
                    recommendation4 = recommendation9;
                    year3 = year11;
                    trailer5 = trailer12;
                    doc4 = doc;
                    imdbId5 = url8;
                    title5 = title2;
                    bgposter4 = bgposter12;
                    poster5 = poster15;
                }
                creditsJson = str7;
                description6 = description4;
                background7 = background4;
                imdbId9 = imdbId4;
                credits = parseCredits(creditsJson);
                typeset = tvtype3 == TvType.TvSeries ? "series" : "movie";
                if (imdbId9 != null) {
                    if (StringsKt.isBlank(imdbId9)) {
                        str8 = imdbId9;
                    } else {
                        str8 = null;
                    }
                    if (str8 != null) {
                        it5 = str8;
                        Requests app6 = MainActivityKt.getApp();
                        String poster16 = "https://v3-cinemeta.strem.io/meta/" + typeset + '/' + it5 + ".json";
                        c00023.L$0 = imdbId5;
                        c00023.L$1 = SpillingKt.nullOutSpilledVariable(savedLogin);
                        c00023.L$2 = SpillingKt.nullOutSpilledVariable(loginPart);
                        c00023.L$3 = SpillingKt.nullOutSpilledVariable(authCookie2);
                        c00023.L$4 = SpillingKt.nullOutSpilledVariable(cfCookies2);
                        c00023.L$5 = SpillingKt.nullOutSpilledVariable(map2);
                        c00023.L$6 = SpillingKt.nullOutSpilledVariable(page2);
                        c00023.L$7 = doc4;
                        c00023.L$8 = SpillingKt.nullOutSpilledVariable(ogTitle2);
                        c00023.L$9 = title5;
                        c00023.L$10 = poster5;
                        c00023.L$11 = bgposter4;
                        c00023.L$12 = trailer5;
                        c00023.L$13 = audioLanguages4;
                        c00023.L$14 = descriptions5;
                        c00023.L$15 = recommendation4;
                        c00023.L$16 = year3;
                        c00023.L$17 = tvtype3;
                        c00023.L$18 = SpillingKt.nullOutSpilledVariable(tmdbmetatype3);
                        c00023.L$19 = genre7;
                        c00023.L$20 = background7;
                        descriptions9 = imdbId5;
                        c00023.L$21 = description6;
                        c00023.L$22 = imdbId9;
                        c00023.L$23 = tmdbId2;
                        c00023.L$24 = logoPath2;
                        c00023.L$25 = SpillingKt.nullOutSpilledVariable(creditsJson);
                        c00023.L$26 = credits;
                        c00023.L$27 = SpillingKt.nullOutSpilledVariable(typeset);
                        c00023.L$28 = SpillingKt.nullOutSpilledVariable(it5);
                        c00023.label = 4;
                        bgposter7 = bgposter4;
                        audioLanguages8 = trailer5;
                        trailer8 = audioLanguages4;
                        tmdbId5 = tmdbId2;
                        C00021 c00026 = c00023;
                        recommendation7 = recommendation4;
                        year6 = year3;
                        genre10 = genre7;
                        background9 = background7;
                        logoPath4 = logoPath2;
                        Object obj15 = obj;
                        tvtype5 = tvtype3;
                        obj8 = obj15;
                        poster8 = poster5;
                        descriptions10 = descriptions5;
                        doc7 = doc4;
                        cinemacity = this;
                        obj9 = Requests.get$default(app6, poster16, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00026, 4094, (Object) null);
                        c00023 = c00026;
                        if (obj9 == obj8) {
                            return obj8;
                        }
                        title8 = title5;
                        year7 = year6;
                        description8 = description6;
                        list2 = credits;
                        creditsJson2 = creditsJson;
                        logoPath5 = logoPath4;
                        castList = recommendation7;
                        imdbId11 = imdbId9;
                        typeset4 = typeset;
                        tmdbId6 = tmdbId5;
                        it6 = it5;
                        creditsJson3 = savedLogin;
                        genre11 = genre10;
                        loginPart3 = loginPart;
                        text = ((NiceResponse) obj9).getText();
                        Integer year12 = year7;
                        trailer6 = str5;
                        if (StringsKt.startsWith$default(text, trailer6, false, 2, (Object) null)) {
                            AppUtils appUtils3 = AppUtils.INSTANCE;
                            if (text == null) {
                                objDecodeFromString = null;
                            } else {
                                Result.Companion companion14 = Result.Companion;
                                KType kTypeTypeOf3 = Reflection.typeOf(ResponseData.class);
                                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                obj10 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf3));
                                if (Result.exceptionOrNull-impl(obj10) != null) {
                                    Result.Companion companion15 = Result.Companion;
                                    obj10 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(ResponseData.class), (List) null, 2, (Object) null));
                                    break;
                                }
                                if (Result.isFailure-impl(obj10)) {
                                    obj10 = null;
                                }
                                deserializationStrategy = (KSerializer) obj10;
                                if (deserializationStrategy != null) {
                                    value$iv$iv = text;
                                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv$iv);
                                } else {
                                    value$iv$iv = text;
                                }
                                ObjectMapper $this$readValue$iv$iv$iv5 = MainAPIKt.getMapper();
                                String content$iv$iv$iv5 = value$iv$iv;
                                objDecodeFromString = $this$readValue$iv$iv$iv5.readValue(content$iv$iv$iv5, new TypeReference<ResponseData>() { // from class: com.Cinemacity.Cinemacity$load$lambda$11$$inlined$tryParseJson$1
                                });
                            }
                            responseData2 = (ResponseData) objDecodeFromString;
                        } else {
                            responseData2 = null;
                        }
                        year5 = year12;
                        responseData = responseData2;
                        typeset2 = typeset4;
                        logoPath3 = logoPath5;
                        description7 = description8;
                        tmdbId4 = tmdbId6;
                        imdbId10 = imdbId11;
                        list = list2;
                        genre9 = genre11;
                        recommendation6 = castList;
                        savedLogin = creditsJson3;
                        descriptions8 = descriptions10;
                        doc6 = doc7;
                        typeset3 = descriptions9;
                        trailer7 = audioLanguages8;
                        audioLanguages7 = trailer8;
                        tvtype4 = tvtype5;
                        bgposter6 = bgposter7;
                        poster7 = poster8;
                        background8 = background9;
                        break;
                    }
                    if (responseData != null && (it9 = responseData.getMeta()) != null) {
                        description9 = it9.getDescription();
                        if (description9 == null) {
                            description9 = descriptions8;
                        }
                        description7.element = description9;
                        background10 = it9.getBackground();
                        if (background10 == null) {
                            background10 = poster7;
                        }
                        background8.element = background10;
                        genre9.element = it9.getGenres();
                        Unit unit6 = Unit.INSTANCE;
                    }
                    if (responseData == null && (meta4 = responseData.getMeta()) != null && ($this$filter$iv = meta4.getVideos()) != null) {
                        Collection destination$iv$iv6 = new ArrayList();
                        for (Object element$iv$iv2 : $this$filter$iv) {
                            ResponseData.Meta.EpisodeDetails it22 = (ResponseData.Meta.EpisodeDetails) element$iv$iv2;
                            if ((it22.getSeason() == null || it22.getEpisode() == null) ? false : true) {
                                destination$iv$iv6.add(element$iv$iv2);
                            }
                        }
                        Iterable $this$associateBy$iv = (List) destination$iv$iv6;
                        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16);
                        destination$iv$iv3 = new LinkedHashMap(capacity$iv);
                        for (Object element$iv$iv3 : $this$associateBy$iv) {
                            Ref.ObjectRef description10 = description7;
                            ResponseData.Meta.EpisodeDetails it23 = (ResponseData.Meta.EpisodeDetails) element$iv$iv3;
                            destination$iv$iv3.put(new StringBuilder().append(it23.getSeason()).append(':').append(it23.getEpisode()).toString(), element$iv$iv3);
                            typeset3 = typeset3;
                            genre9 = genre9;
                            description7 = description10;
                        }
                        description7 = description7;
                        genre9 = genre9;
                        typeset3 = typeset3;
                    }
                    element2 = (Element) CollectionsKt.getOrNull(doc6.select("script:containsData(atob)"), 1);
                    if (element2 != null || (playerScript = element2.data()) == null) {
                        throw new IllegalStateException("PlayerJS not found; only torrent links available".toString());
                    }
                    String decodedPlayer2 = MainAPIKt.base64Decode(StringsKt.substringBefore$default(StringsKt.substringAfter$default(playerScript, "atob(\"", (String) null, 2, (Object) null), "\")", (String) null, 2, (Object) null));
                    JSONObject playerJson2 = new JSONObject(StringsKt.substringBeforeLast$default(StringsKt.substringAfter$default(decodedPlayer2, "new Playerjs(", (String) null, 2, (Object) null), ");", (String) null, 2, (Object) null));
                    Object rawFile2 = playerJson2.opt("file");
                    if (rawFile2 == null) {
                        throw new IllegalStateException("PlayerJS: missing file field".toString());
                    }
                    if (rawFile2 instanceof JSONArray) {
                        $this$load_u24lambda_u2415 = (JSONArray) rawFile2;
                        doc8 = doc6;
                        rawFile = rawFile2;
                        decodedPlayer = decodedPlayer2;
                        creditsJson4 = creditsJson2;
                    } else {
                        if (!(rawFile2 instanceof String)) {
                            throw new ErrorLoadingException("Not logged in. Open CinemaCity Extension settings and login.");
                        }
                        String value2 = StringsKt.trim((String) rawFile2).toString();
                        doc8 = doc6;
                        rawFile = rawFile2;
                        decodedPlayer = decodedPlayer2;
                        creditsJson4 = creditsJson2;
                        if (StringsKt.startsWith$default(value2, "[", false, 2, (Object) null) && StringsKt.endsWith$default(value2, "]", false, 2, (Object) null)) {
                            $this$load_u24lambda_u2415 = new JSONArray(value2);
                        } else if (StringsKt.startsWith$default(value2, trailer6, false, 2, (Object) null) && StringsKt.endsWith$default(value2, "}", false, 2, (Object) null)) {
                            $this$load_u24lambda_u2415 = new JSONArray();
                            $this$load_u24lambda_u2415.put(new JSONObject(value2));
                        } else {
                            if (StringsKt.isBlank(value2)) {
                                throw new ErrorLoadingException("Not logged in. Open CinemaCity Extension settings and login.");
                            }
                            $this$load_u24lambda_u2415 = new JSONArray();
                            JSONObject $this$load_u24lambda_u2416_u240 = new JSONObject();
                            $this$load_u24lambda_u2416_u240.put("file", value2);
                            $this$load_u24lambda_u2415.put($this$load_u24lambda_u2416_u240);
                        }
                    }
                    JSONArray fileArray = $this$load_u24lambda_u2415;
                    Regex seasonRegex2 = new Regex("Season\\s*(\\d+)", RegexOption.IGNORE_CASE);
                    Regex episodeRegex = new Regex("Episode\\s*(\\d+)", RegexOption.IGNORE_CASE);
                    List episodeList = new ArrayList();
                    Log.INSTANCE.d("Phisher", fileArray.toString());
                    JSONObject it24 = fileArray.optJSONObject(0);
                    String str20 = "folder";
                    if (it24 == null) {
                        jSONObject = it24;
                        jSONObject = it24;
                        it7 = null;
                    } else {
                        if (it24.has("folder")) {
                            jSONObject = null;
                        }
                        if (jSONObject == null || (it7 = jSONObject.optString("file")) == null) {
                            jSONObject = it24;
                            jSONObject = it24;
                            it7 = null;
                        } else if (StringsKt.isBlank(it7)) {
                            jSONObject = it24;
                            it7 = null;
                        }
                    }
                    jSONObject = it24;
                    String movieHrefs = it7;
                    if (playerJson2.opt("subtitle") instanceof String) {
                        playerJson = playerJson2;
                        strOptString = playerJson2.optString("subtitle");
                    } else {
                        playerJson = playerJson2;
                        JSONObject playerJson3 = fileArray.optJSONObject(0);
                        strOptString = (!((playerJson3 != null ? playerJson3.opt("subtitle") : null) instanceof String) || (jSONObjectOptJSONObject3 = fileArray.optJSONObject(0)) == null) ? null : jSONObjectOptJSONObject3.optString("subtitle");
                    }
                    JSONArray movieSubtitleTracks = cinemacity.parseSubtitles(strOptString);
                    if (movieHrefs != null) {
                        JSONObject $this$load_u24lambda_u2419_u240 = new JSONObject();
                        $this$load_u24lambda_u2419_u240.put("streamUrl", movieHrefs);
                        $this$load_u24lambda_u2419_u240.put("subtitleTracks", movieSubtitleTracks);
                        moviejson = $this$load_u24lambda_u2419_u240.toString();
                    } else {
                        moviejson = null;
                    }
                    if (tvtype4 != TvType.TvSeries) {
                        TvType tvtype8 = tvtype4;
                        String moviejson2 = moviejson;
                        String url9 = typeset3;
                        Log log = Log.INSTANCE;
                        if (responseData == null || (meta2 = responseData.getMeta()) == null || (app_extras = meta2.getApp_extras()) == null || (certification = app_extras.getCertification()) == null) {
                            certification = str4;
                        }
                        log.d("Phisher", certification);
                        Cinemacity cinemacity3 = this;
                        String str21 = (responseData == null || (meta = responseData.getMeta()) == null || (name = meta.getName()) == null) ? title8 : name;
                        TvType tvType2 = TvType.Movie;
                        C00048 c00048 = new C00048(background8, bgposter6, poster7, logoPath3, year5, responseData, recommendation6, genre9, list, imdbId10, tmdbId4, trailer7, description7, descriptions8, audioLanguages7, null);
                        c00023.L$0 = SpillingKt.nullOutSpilledVariable(url9);
                        c00023.L$1 = SpillingKt.nullOutSpilledVariable(savedLogin);
                        c00023.L$2 = SpillingKt.nullOutSpilledVariable(loginPart3);
                        c00023.L$3 = SpillingKt.nullOutSpilledVariable(authCookie2);
                        c00023.L$4 = SpillingKt.nullOutSpilledVariable(cfCookies2);
                        c00023.L$5 = SpillingKt.nullOutSpilledVariable(map2);
                        c00023.L$6 = SpillingKt.nullOutSpilledVariable(page2);
                        c00023.L$7 = SpillingKt.nullOutSpilledVariable(doc8);
                        c00023.L$8 = SpillingKt.nullOutSpilledVariable(ogTitle2);
                        c00023.L$9 = SpillingKt.nullOutSpilledVariable(title8);
                        c00023.L$10 = SpillingKt.nullOutSpilledVariable(poster7);
                        c00023.L$11 = SpillingKt.nullOutSpilledVariable(bgposter6);
                        c00023.L$12 = SpillingKt.nullOutSpilledVariable(trailer7);
                        c00023.L$13 = SpillingKt.nullOutSpilledVariable(audioLanguages7);
                        c00023.L$14 = SpillingKt.nullOutSpilledVariable(descriptions8);
                        c00023.L$15 = SpillingKt.nullOutSpilledVariable(recommendation6);
                        c00023.L$16 = SpillingKt.nullOutSpilledVariable(year5);
                        c00023.L$17 = SpillingKt.nullOutSpilledVariable(tvtype8);
                        c00023.L$18 = SpillingKt.nullOutSpilledVariable(tmdbmetatype3);
                        c00023.L$19 = SpillingKt.nullOutSpilledVariable(genre9);
                        c00023.L$20 = SpillingKt.nullOutSpilledVariable(background8);
                        c00023.L$21 = SpillingKt.nullOutSpilledVariable(description7);
                        c00023.L$22 = SpillingKt.nullOutSpilledVariable(imdbId10);
                        c00023.L$23 = SpillingKt.nullOutSpilledVariable(tmdbId4);
                        c00023.L$24 = SpillingKt.nullOutSpilledVariable(logoPath3);
                        c00023.L$25 = SpillingKt.nullOutSpilledVariable(creditsJson4);
                        c00023.L$26 = SpillingKt.nullOutSpilledVariable(list);
                        c00023.L$27 = SpillingKt.nullOutSpilledVariable(typeset2);
                        c00023.L$28 = SpillingKt.nullOutSpilledVariable(responseData);
                        c00023.L$29 = SpillingKt.nullOutSpilledVariable(destination$iv$iv3);
                        c00023.L$30 = SpillingKt.nullOutSpilledVariable((Object) r15);
                        c00023.L$31 = SpillingKt.nullOutSpilledVariable(decodedPlayer);
                        c00023.L$32 = SpillingKt.nullOutSpilledVariable(playerJson);
                        c00023.L$33 = SpillingKt.nullOutSpilledVariable(rawFile);
                        c00023.L$34 = SpillingKt.nullOutSpilledVariable(fileArray);
                        c00023.L$35 = SpillingKt.nullOutSpilledVariable(seasonRegex2);
                        c00023.L$36 = SpillingKt.nullOutSpilledVariable(episodeRegex);
                        c00023.L$37 = SpillingKt.nullOutSpilledVariable(episodeList);
                        c00023.L$38 = SpillingKt.nullOutSpilledVariable(movieHrefs);
                        c00023.L$39 = SpillingKt.nullOutSpilledVariable(movieSubtitleTracks);
                        c00023.L$40 = SpillingKt.nullOutSpilledVariable(moviejson2);
                        c00023.label = 6;
                        Object objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(cinemacity3, str21, url9, tvType2, moviejson2, c00048, c00023);
                        return objNewMovieLoadResponse == obj8 ? obj8 : objNewMovieLoadResponse;
                    }
                    int i2 = 0;
                    int length = fileArray.length();
                    while (i2 < length) {
                        TvType tvtype9 = tvtype4;
                        JSONObject seasonJson = fileArray.getJSONObject(i2);
                        JSONArray movieSubtitleTracks2 = movieSubtitleTracks;
                        String str22 = "title";
                        int i3 = i2;
                        JSONArray fileArray2 = fileArray;
                        String moviejson3 = moviejson;
                        int i4 = length;
                        MatchResult matchResultFind$default2 = Regex.find$default(seasonRegex2, seasonJson.optString("title"), 0, 2, (Object) null);
                        if (matchResultFind$default2 == null || (groupValues = matchResultFind$default2.getGroupValues()) == null || (str10 = (String) groupValues.get(1)) == null) {
                            seasonRegex = seasonRegex2;
                            str9 = str20;
                        } else {
                            Integer intOrNull = StringsKt.toIntOrNull(str10);
                            if (intOrNull != null) {
                                final int seasonNumber = intOrNull.intValue();
                                JSONArray episodes = seasonJson.optJSONArray(str20);
                                if (episodes == null) {
                                    seasonRegex = seasonRegex2;
                                    str9 = str20;
                                } else {
                                    int j = 0;
                                    int length2 = episodes.length();
                                    while (j < length2) {
                                        Regex seasonRegex3 = seasonRegex2;
                                        JSONObject epJson = episodes.getJSONObject(j);
                                        JSONObject seasonJson2 = seasonJson;
                                        String str23 = str22;
                                        JSONArray episodes2 = episodes;
                                        int j2 = j;
                                        MatchResult matchResultFind$default3 = Regex.find$default(episodeRegex, epJson.optString(str22), 0, 2, (Object) null);
                                        if (matchResultFind$default3 == null || (groupValues2 = matchResultFind$default3.getGroupValues()) == null || (str11 = (String) groupValues2.get(1)) == null) {
                                            str20 = str20;
                                        } else {
                                            Integer intOrNull2 = StringsKt.toIntOrNull(str11);
                                            if (intOrNull2 != null) {
                                                final int episodeNumber = intOrNull2.intValue();
                                                List streamUrls = new ArrayList();
                                                String it25 = epJson.optString("file");
                                                if (StringsKt.isBlank(it25)) {
                                                    it25 = null;
                                                }
                                                if (it25 != null) {
                                                    streamUrls.add(it25);
                                                    Unit unit7 = Unit.INSTANCE;
                                                }
                                                JSONArray sources = epJson.optJSONArray(str20);
                                                if (sources != null) {
                                                    int i5 = 0;
                                                    int length3 = sources.length();
                                                    int k = 0;
                                                    while (k < length3) {
                                                        int i6 = i5;
                                                        JSONObject jSONObjectOptJSONObject4 = sources.optJSONObject(k);
                                                        if (jSONObjectOptJSONObject4 != null && (it8 = jSONObjectOptJSONObject4.optString("file")) != null) {
                                                            if (StringsKt.isBlank(it8)) {
                                                                it8 = null;
                                                            }
                                                            if (it8 != null) {
                                                                streamUrls.add(it8);
                                                                Unit unit8 = Unit.INSTANCE;
                                                            }
                                                        }
                                                        k++;
                                                        i5 = i6;
                                                        sources = sources;
                                                    }
                                                    Unit unit9 = Unit.INSTANCE;
                                                }
                                                if (!streamUrls.isEmpty()) {
                                                    String metaKey = new StringBuilder().append(seasonNumber).append(':').append(episodeNumber).toString();
                                                    final ResponseData.Meta.EpisodeDetails epMeta = (ResponseData.Meta.EpisodeDetails) destination$iv$iv3.get(metaKey);
                                                    JSONArray epSubtitleTracks = cinemacity.parseSubtitles(epJson.optString("subtitle"));
                                                    JSONObject $this$load_u24lambda_u2423 = new JSONObject();
                                                    $this$load_u24lambda_u2423.put("streams", new JSONArray((Collection) streamUrls));
                                                    $this$load_u24lambda_u2423.put("subtitleTracks", epSubtitleTracks);
                                                    String epjson = $this$load_u24lambda_u2423.toString();
                                                    episodeList.add(MainAPIKt.newEpisode(this, epjson, new Function1() { // from class: com.Cinemacity.Cinemacity$$ExternalSyntheticLambda1
                                                        public final Object invoke(Object obj16) {
                                                            return Cinemacity.load$lambda$24(seasonNumber, episodeNumber, epMeta, (Episode) obj16);
                                                        }
                                                    }));
                                                }
                                            } else {
                                                str20 = str20;
                                            }
                                        }
                                        j = j2 + 1;
                                        cinemacity = this;
                                        episodes = episodes2;
                                        seasonRegex2 = seasonRegex3;
                                        str22 = str23;
                                        seasonJson = seasonJson2;
                                        str20 = str20;
                                    }
                                    seasonRegex = seasonRegex2;
                                    str9 = str20;
                                }
                            } else {
                                seasonRegex = seasonRegex2;
                                str9 = str20;
                            }
                        }
                        i2 = i3 + 1;
                        cinemacity = this;
                        length = i4;
                        tvtype4 = tvtype9;
                        movieSubtitleTracks = movieSubtitleTracks2;
                        fileArray = fileArray2;
                        moviejson = moviejson3;
                        seasonRegex2 = seasonRegex;
                        str20 = str9;
                    }
                    Regex seasonRegex4 = seasonRegex2;
                    TvType tvtype10 = tvtype4;
                    JSONArray movieSubtitleTracks3 = movieSubtitleTracks;
                    JSONArray fileArray3 = fileArray;
                    String moviejson4 = moviejson;
                    Cinemacity cinemacity4 = this;
                    String str24 = (responseData == null || (meta3 = responseData.getMeta()) == null || (name2 = meta3.getName()) == null) ? title8 : name2;
                    TvType tvType3 = TvType.TvSeries;
                    C00037 c00037 = new C00037(background8, bgposter6, poster7, logoPath3, year5, responseData, recommendation6, genre9, list, imdbId10, tmdbId4, trailer7, description7, descriptions8, audioLanguages7, null);
                    c00023.L$0 = SpillingKt.nullOutSpilledVariable(typeset3);
                    c00023.L$1 = SpillingKt.nullOutSpilledVariable(savedLogin);
                    c00023.L$2 = SpillingKt.nullOutSpilledVariable(loginPart3);
                    c00023.L$3 = SpillingKt.nullOutSpilledVariable(authCookie2);
                    c00023.L$4 = SpillingKt.nullOutSpilledVariable(cfCookies2);
                    c00023.L$5 = SpillingKt.nullOutSpilledVariable(map2);
                    c00023.L$6 = SpillingKt.nullOutSpilledVariable(page2);
                    c00023.L$7 = SpillingKt.nullOutSpilledVariable(doc8);
                    c00023.L$8 = SpillingKt.nullOutSpilledVariable(ogTitle2);
                    c00023.L$9 = SpillingKt.nullOutSpilledVariable(title8);
                    c00023.L$10 = SpillingKt.nullOutSpilledVariable(poster7);
                    c00023.L$11 = SpillingKt.nullOutSpilledVariable(bgposter6);
                    c00023.L$12 = SpillingKt.nullOutSpilledVariable(trailer7);
                    c00023.L$13 = SpillingKt.nullOutSpilledVariable(audioLanguages7);
                    c00023.L$14 = SpillingKt.nullOutSpilledVariable(descriptions8);
                    c00023.L$15 = SpillingKt.nullOutSpilledVariable(recommendation6);
                    c00023.L$16 = SpillingKt.nullOutSpilledVariable(year5);
                    c00023.L$17 = SpillingKt.nullOutSpilledVariable(tvtype10);
                    c00023.L$18 = SpillingKt.nullOutSpilledVariable(tmdbmetatype3);
                    c00023.L$19 = SpillingKt.nullOutSpilledVariable(genre9);
                    c00023.L$20 = SpillingKt.nullOutSpilledVariable(background8);
                    c00023.L$21 = SpillingKt.nullOutSpilledVariable(description7);
                    c00023.L$22 = SpillingKt.nullOutSpilledVariable(imdbId10);
                    c00023.L$23 = SpillingKt.nullOutSpilledVariable(tmdbId4);
                    c00023.L$24 = SpillingKt.nullOutSpilledVariable(logoPath3);
                    c00023.L$25 = SpillingKt.nullOutSpilledVariable(creditsJson4);
                    c00023.L$26 = SpillingKt.nullOutSpilledVariable(list);
                    c00023.L$27 = SpillingKt.nullOutSpilledVariable(typeset2);
                    c00023.L$28 = SpillingKt.nullOutSpilledVariable(responseData);
                    c00023.L$29 = SpillingKt.nullOutSpilledVariable(destination$iv$iv3);
                    c00023.L$30 = SpillingKt.nullOutSpilledVariable((Object) r15);
                    c00023.L$31 = SpillingKt.nullOutSpilledVariable(decodedPlayer);
                    c00023.L$32 = SpillingKt.nullOutSpilledVariable(playerJson);
                    c00023.L$33 = SpillingKt.nullOutSpilledVariable(rawFile);
                    c00023.L$34 = SpillingKt.nullOutSpilledVariable(fileArray3);
                    c00023.L$35 = SpillingKt.nullOutSpilledVariable(seasonRegex4);
                    c00023.L$36 = SpillingKt.nullOutSpilledVariable(episodeRegex);
                    c00023.L$37 = SpillingKt.nullOutSpilledVariable(episodeList);
                    c00023.L$38 = SpillingKt.nullOutSpilledVariable(movieHrefs);
                    c00023.L$39 = SpillingKt.nullOutSpilledVariable(movieSubtitleTracks3);
                    c00023.L$40 = SpillingKt.nullOutSpilledVariable(moviejson4);
                    c00023.label = 5;
                    Object objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(cinemacity4, str24, typeset3, tvType3, episodeList, c00037, c00023);
                    return objNewTvSeriesLoadResponse == obj8 ? obj8 : objNewTvSeriesLoadResponse;
                }
                Object obj16 = obj;
                TvType tvtype11 = tvtype3;
                obj8 = obj16;
                String url10 = imdbId5;
                Document doc11 = doc4;
                typeset2 = typeset;
                String poster17 = poster5;
                String bgposter13 = bgposter4;
                String trailer13 = trailer5;
                cinemacity = this;
                trailer6 = str5;
                description7 = description6;
                list = credits;
                year5 = year3;
                genre9 = genre7;
                creditsJson2 = creditsJson;
                logoPath3 = logoPath2;
                recommendation6 = recommendation4;
                imdbId10 = imdbId9;
                tmdbId4 = tmdbId2;
                responseData = null;
                title8 = title5;
                loginPart3 = loginPart;
                descriptions8 = descriptions5;
                doc6 = doc11;
                typeset3 = url10;
                trailer7 = trailer13;
                audioLanguages7 = audioLanguages4;
                bgposter6 = bgposter13;
                poster7 = poster17;
                background8 = background7;
                tvtype4 = tvtype11;
                if (responseData != null) {
                    description9 = it9.getDescription();
                    if (description9 == null) {
                        description9 = descriptions8;
                    }
                    description7.element = description9;
                    background10 = it9.getBackground();
                    if (background10 == null) {
                        background10 = poster7;
                    }
                    background8.element = background10;
                    genre9.element = it9.getGenres();
                    Unit unit10 = Unit.INSTANCE;
                }
                if (responseData == null) {
                }
                element2 = (Element) CollectionsKt.getOrNull(doc6.select("script:containsData(atob)"), 1);
                if (element2 != null) {
                }
                throw new IllegalStateException("PlayerJS not found; only torrent links available".toString());
            case 1:
                Map<String, String> map3 = (Map) c00023.L$5;
                String authCookie4 = (String) c00023.L$4;
                String cfCookies4 = (String) c00023.L$3;
                String loginPart5 = (String) c00023.L$2;
                String savedLogin3 = (String) c00023.L$1;
                String url11 = (String) c00023.L$0;
                ResultKt.throwOnFailure($result3);
                map = map3;
                objAppGet = $result3;
                authCookie = authCookie4;
                loginPart = loginPart5;
                savedLogin = savedLogin3;
                cfCookies = cfCookies4;
                url2 = url11;
                page = (NiceResponse) objAppGet;
                doc = page.getDocument();
                elementSelectFirst = doc.selectFirst("meta[property=og:title]");
                if (elementSelectFirst != null) {
                    strAttr = elementSelectFirst.attr("content");
                } else {
                    strAttr = null;
                }
                if (strAttr == null) {
                    strAttr = "";
                }
                ogTitle = strAttr;
                title = StringsKt.trim(StringsKt.substringBefore$default(ogTitle, "(", (String) null, 2, (Object) null)).toString();
                elementSelectFirst2 = doc.selectFirst("meta[property=og:image]");
                if (elementSelectFirst2 != null) {
                    poster = elementSelectFirst2.attr("content");
                } else {
                    poster = null;
                }
                if (poster == null) {
                    poster = "";
                }
                elementSelectFirst3 = doc.selectFirst("div.dar-full_bg a");
                if (elementSelectFirst3 != null) {
                    bgposter = elementSelectFirst3.attr("href");
                } else {
                    bgposter = null;
                }
                trailer = doc.select("div.dar-full_bg.e-cover > div").attr("data-vbg");
                Iterable $this$firstOrNull$iv2 = doc.select("li");
                it = $this$firstOrNull$iv2.iterator();
                while (true) {
                    if (it.hasNext()) {
                        element$iv = it.next();
                        $result2 = $result3;
                        Element it110 = (Element) element$iv;
                        obj = coroutine_suspended;
                        elementSelectFirst7 = it110.selectFirst("span");
                        str = elementSelectFirst7 == null ? str12 : str12;
                        if (!z) {
                            $result3 = $result2;
                            coroutine_suspended = obj;
                            str12 = str;
                        }
                    } else {
                        obj = coroutine_suspended;
                        str = str12;
                        element$iv = null;
                    }
                }
                element = (Element) element$iv;
                if (element != null) {
                    audioLanguages = null;
                } else {
                    audioLanguages = null;
                }
                elementSelectFirst4 = doc.selectFirst("#about div.ta-full_text1");
                if (elementSelectFirst4 != null) {
                    descriptions = elementSelectFirst4.text();
                } else {
                    descriptions = null;
                }
                $this$map$iv = doc.select("div.ta-rel > div.ta-rel_item");
                descriptions2 = descriptions;
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                $this$mapTo$iv$iv = $this$map$iv;
                while (r30.hasNext()) {
                    Element it111 = (Element) item$iv$iv2;
                    Iterable $this$map$iv4 = $this$map$iv;
                    String audioLanguages13 = audioLanguages;
                    Iterable $this$mapTo$iv$iv3 = $this$mapTo$iv$iv;
                    String recTitle2 = StringsKt.trim(StringsKt.substringBefore$default(it111.select("a").text(), "(", (String) null, 2, (Object) null)).toString();
                    Cinemacity cinemacity5 = this;
                    elementSelectFirst5 = it111.selectFirst("> div > a");
                    if (elementSelectFirst5 != null) {
                        strAttr3 = "";
                    } else {
                        strAttr3 = "";
                    }
                    String href2 = MainAPIKt.fixUrl(cinemacity5, strAttr3);
                    final String score2 = it111.select("span.rating-color1").text();
                    elementSelectFirst6 = it111.selectFirst("div > a");
                    if (elementSelectFirst6 != null) {
                        posterUrl = elementSelectFirst6.attr("href");
                    } else {
                        posterUrl = null;
                    }
                    destination$iv$iv.add(MainAPIKt.newMovieSearchResponse$default(this, recTitle2, href2, TvType.Movie, false, new Function1() { // from class: com.Cinemacity.Cinemacity$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj17) {
                            return Cinemacity.load$lambda$4$0(posterUrl, score2, (MovieSearchResponse) obj17);
                        }
                    }, 8, (Object) null));
                    $this$map$iv = $this$map$iv4;
                    $this$mapTo$iv$iv = $this$mapTo$iv$iv3;
                    audioLanguages = audioLanguages13;
                }
                audioLanguages2 = audioLanguages;
                recommendation = (List) destination$iv$iv;
                year = StringsKt.toIntOrNull(StringsKt.substringBefore$default(StringsKt.substringAfter(ogTitle, "(", ""), ")", (String) null, 2, (Object) null));
                if (StringsKt.contains(url2, "/movies/", true)) {
                    tvType = TvType.Movie;
                } else {
                    tvType = TvType.TvSeries;
                }
                tvtype = tvType;
                if (tvtype == TvType.TvSeries) {
                    str2 = "tv";
                } else {
                    str2 = "movie";
                }
                tmdbmetatype = str2;
                genre = new Ref.ObjectRef();
                background = new Ref.ObjectRef();
                description = new Ref.ObjectRef();
                $this$mapNotNull$iv = doc.select("div.ta-full_rating1 > div");
                destination$iv$iv2 = new ArrayList();
                while (r40.hasNext()) {
                    Iterable $this$mapNotNull$iv3 = $this$mapNotNull$iv;
                    Element it112 = (Element) element$iv$iv$iv;
                    String ogTitle4 = ogTitle;
                    strAttr2 = it112.attr("onclick");
                    if (strAttr2 != null) {
                        destination$iv$iv2.add(strAttr2);
                    }
                    $this$mapNotNull$iv = $this$mapNotNull$iv3;
                    ogTitle = ogTitle4;
                }
                ogTitle2 = ogTitle;
                it2 = ((List) destination$iv$iv2).iterator();
                while (true) {
                    if (it2.hasNext()) {
                        String it113 = (String) it2.next();
                        it3 = it2;
                        str3 = str13;
                        genre2 = genre;
                        matchResultFind$default = Regex.find$default(new Regex("tt\\d+"), it113, 0, 2, (Object) null);
                        if (matchResultFind$default != null) {
                            value = matchResultFind$default.getValue();
                        } else {
                            value = null;
                        }
                        if (value != null) {
                            str13 = str3;
                            genre = genre2;
                            it2 = it3;
                        }
                    } else {
                        str3 = str13;
                        genre2 = genre;
                        value = null;
                    }
                }
                imdbId = value;
                if (imdbId != null) {
                    Result.Companion companion16 = Result.Companion;
                    Cinemacity $this$load_u24lambda_u247_u241 = this;
                    Requests app7 = MainActivityKt.getApp();
                    String str112 = "https://api.themoviedb.org/3/find/" + imdbId + "?api_key=1865f43a0549ca50d341dd9ab8b29f49&external_source=imdb_id";
                    c00023.L$0 = url2;
                    c00023.L$1 = SpillingKt.nullOutSpilledVariable(savedLogin);
                    c00023.L$2 = SpillingKt.nullOutSpilledVariable(loginPart);
                    c00023.L$3 = SpillingKt.nullOutSpilledVariable(cfCookies);
                    c00023.L$4 = SpillingKt.nullOutSpilledVariable(authCookie);
                    c00023.L$5 = SpillingKt.nullOutSpilledVariable(map);
                    c00023.L$6 = SpillingKt.nullOutSpilledVariable(page);
                    c00023.L$7 = doc;
                    c00023.L$8 = SpillingKt.nullOutSpilledVariable(ogTitle2);
                    c00023.L$9 = title;
                    c00023.L$10 = poster;
                    c00023.L$11 = bgposter;
                    c00023.L$12 = trailer;
                    c00023.L$13 = audioLanguages2;
                    loginPart2 = url2;
                    c00023.L$14 = descriptions2;
                    c00023.L$15 = recommendation;
                    c00023.L$16 = year;
                    c00023.L$17 = tvtype;
                    c00023.L$18 = tmdbmetatype;
                    recommendation3 = recommendation;
                    genre5 = genre2;
                    c00023.L$19 = genre5;
                    poster4 = poster;
                    c00023.L$20 = background;
                    c00023.L$21 = description;
                    c00023.L$22 = imdbId;
                    c00023.L$23 = SpillingKt.nullOutSpilledVariable(imdbId);
                    c00023.L$24 = SpillingKt.nullOutSpilledVariable($this$load_u24lambda_u247_u241);
                    c00023.label = 2;
                    doc2 = doc;
                    title3 = title;
                    bgposter3 = bgposter;
                    trailer3 = trailer;
                    audioLanguages3 = audioLanguages2;
                    str4 = str3;
                    poster3 = poster4;
                    tvtype2 = tvtype;
                    descriptions4 = descriptions2;
                    obj2 = obj;
                    str5 = str;
                    i = 0;
                    obj3 = Requests.get$default(app7, str112, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00023, 4094, (Object) null);
                    c00023 = c00023;
                    if (obj3 == obj2) {
                        return obj2;
                    }
                    authCookie2 = cfCookies;
                    page2 = page;
                    genre4 = genre5;
                    title4 = imdbId;
                    doc3 = doc2;
                    description3 = description;
                    trailer4 = trailer3;
                    tmdbmetatype2 = tmdbmetatype;
                    background3 = background;
                    map2 = map;
                    obj6 = new JSONObject(((NiceResponse) obj3).getText());
                    jSONArrayOptJSONArray = obj6.optJSONArray("movie_results");
                    if (jSONArrayOptJSONArray != null) {
                        jSONArrayOptJSONArray2 = obj6.optJSONArray("tv_results");
                        if (jSONArrayOptJSONArray2 != null) {
                            numBoxInt = null;
                        } else {
                            numBoxInt = null;
                        }
                    } else {
                        jSONArrayOptJSONArray2 = obj6.optJSONArray("tv_results");
                        if (jSONArrayOptJSONArray2 != null) {
                            numBoxInt = null;
                        } else {
                            numBoxInt = null;
                        }
                    }
                    Ref.ObjectRef objectRef9 = genre4;
                    obj4 = Result.constructor-impl(numBoxInt);
                    genre6 = objectRef9;
                    if (Result.isFailure-impl(obj4)) {
                        obj4 = null;
                    }
                    num = (Integer) obj4;
                    if (num != null) {
                        strValueOf = String.valueOf(num.intValue());
                    } else {
                        strValueOf = null;
                    }
                    genre3 = genre6;
                    imdbId2 = title4;
                    background2 = background3;
                    str6 = strValueOf;
                    trailer2 = trailer4;
                    doc = doc3;
                    obj = obj2;
                    description2 = description3;
                    url3 = loginPart2;
                    recommendation2 = recommendation3;
                    title2 = title3;
                    bgposter2 = bgposter3;
                    imdbId3 = audioLanguages3;
                    poster2 = poster3;
                    year2 = year;
                    descriptions3 = descriptions4;
                    $result = tvtype2;
                } else {
                    String poster18 = poster;
                    String bgposter14 = bgposter;
                    str4 = str3;
                    str5 = str;
                    String audioLanguages14 = url2;
                    authCookie2 = cfCookies;
                    map2 = map;
                    page2 = page;
                    genre3 = genre2;
                    imdbId2 = imdbId;
                    description2 = description;
                    trailer2 = trailer;
                    tmdbmetatype2 = tmdbmetatype;
                    background2 = background;
                    str6 = null;
                    year2 = year;
                    descriptions3 = descriptions2;
                    url3 = audioLanguages14;
                    recommendation2 = recommendation;
                    title2 = title;
                    bgposter2 = bgposter14;
                    imdbId3 = audioLanguages2;
                    poster2 = poster18;
                    $result = tvtype;
                }
                tmdbId = str6;
                if (imdbId2 != null) {
                    String it26 = imdbId2;
                    it4 = "https://live.metahub.space/logo/medium/" + it26 + "/img";
                } else {
                    it4 = null;
                }
                logoPath = it4;
                if (tmdbId != null) {
                    Result.Companion companion17 = Result.Companion;
                    Cinemacity $this$load_u24lambda_u249_u242 = this;
                    Requests app8 = MainActivityKt.getApp();
                    String str113 = "https://api.themoviedb.org/3/" + tmdbmetatype2 + '/' + tmdbId + "/credits?api_key=1865f43a0549ca50d341dd9ab8b29f49&language=en-US";
                    c00023.L$0 = url3;
                    c00023.L$1 = SpillingKt.nullOutSpilledVariable(savedLogin);
                    c00023.L$2 = SpillingKt.nullOutSpilledVariable(loginPart);
                    c00023.L$3 = SpillingKt.nullOutSpilledVariable(authCookie2);
                    c00023.L$4 = SpillingKt.nullOutSpilledVariable(authCookie);
                    c00023.L$5 = SpillingKt.nullOutSpilledVariable(map2);
                    c00023.L$6 = SpillingKt.nullOutSpilledVariable(page2);
                    c00023.L$7 = doc;
                    c00023.L$8 = SpillingKt.nullOutSpilledVariable(ogTitle2);
                    c00023.L$9 = title2;
                    c00023.L$10 = poster2;
                    c00023.L$11 = bgposter2;
                    c00023.L$12 = trailer2;
                    c00023.L$13 = imdbId3;
                    c00023.L$14 = descriptions3;
                    c00023.L$15 = recommendation2;
                    c00023.L$16 = year2;
                    c00023.L$17 = $result;
                    c00023.L$18 = SpillingKt.nullOutSpilledVariable(tmdbmetatype2);
                    genre8 = genre3;
                    c00023.L$19 = genre8;
                    title7 = title2;
                    background5 = background2;
                    c00023.L$20 = background5;
                    background6 = description2;
                    c00023.L$21 = background6;
                    imdbId7 = imdbId2;
                    c00023.L$22 = imdbId7;
                    c00023.L$23 = tmdbId;
                    c00023.L$24 = logoPath;
                    c00023.L$25 = SpillingKt.nullOutSpilledVariable(tmdbId);
                    c00023.L$26 = SpillingKt.nullOutSpilledVariable($this$load_u24lambda_u249_u242);
                    c00023.label = 3;
                    poster6 = poster2;
                    bgposter5 = bgposter2;
                    descriptions6 = trailer2;
                    c00022 = c00023;
                    audioLanguages5 = imdbId3;
                    tmdbmetatype4 = descriptions3;
                    recommendation5 = recommendation2;
                    tmdbmetatype3 = tmdbmetatype2;
                    url4 = url3;
                    title6 = title7;
                    year4 = year2;
                    doc5 = doc;
                    obj5 = Requests.get$default(app8, str113, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4094, (Object) null);
                    c00023 = c00022;
                    coroutine_suspended = obj;
                    if (obj5 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    descriptions7 = logoPath;
                    imdbId6 = imdbId7;
                    tmdbId3 = tmdbId;
                    audioLanguages6 = audioLanguages5;
                    background5 = background5;
                    description5 = background6;
                    cfCookies2 = authCookie;
                    String str114 = imdbId6;
                    obj7 = Result.constructor-impl(((NiceResponse) obj5).getText());
                    imdbId8 = str114;
                    if (Result.isFailure-impl(obj7)) {
                        obj7 = null;
                    }
                    obj = coroutine_suspended;
                    logoPath2 = descriptions7;
                    tmdbId2 = tmdbId3;
                    str7 = (String) obj7;
                    description4 = description5;
                    audioLanguages4 = audioLanguages6;
                    imdbId4 = imdbId8;
                    background4 = background5;
                    tvtype3 = $result;
                    descriptions5 = tmdbmetatype4;
                    recommendation4 = recommendation5;
                    year3 = year4;
                    trailer5 = descriptions6;
                    title5 = title6;
                    poster5 = poster6;
                    genre7 = genre8;
                    doc4 = doc5;
                    imdbId5 = url4;
                    bgposter4 = bgposter5;
                } else {
                    String url12 = url3;
                    String poster19 = poster2;
                    String bgposter15 = bgposter2;
                    String audioLanguages15 = imdbId3;
                    tmdbmetatype3 = tmdbmetatype2;
                    String trailer14 = trailer2;
                    List recommendation10 = recommendation2;
                    Integer year13 = year2;
                    cfCookies2 = authCookie;
                    logoPath2 = logoPath;
                    imdbId4 = imdbId2;
                    tmdbId2 = tmdbId;
                    audioLanguages4 = audioLanguages15;
                    background4 = background2;
                    description4 = description2;
                    str7 = null;
                    genre7 = genre3;
                    tvtype3 = $result;
                    descriptions5 = descriptions3;
                    recommendation4 = recommendation10;
                    year3 = year13;
                    trailer5 = trailer14;
                    doc4 = doc;
                    imdbId5 = url12;
                    title5 = title2;
                    bgposter4 = bgposter15;
                    poster5 = poster19;
                }
                creditsJson = str7;
                description6 = description4;
                background7 = background4;
                imdbId9 = imdbId4;
                credits = parseCredits(creditsJson);
                typeset = tvtype3 == TvType.TvSeries ? "series" : "movie";
                if (imdbId9 != null) {
                    if (StringsKt.isBlank(imdbId9)) {
                        str8 = imdbId9;
                    } else {
                        str8 = null;
                    }
                    if (str8 != null) {
                        it5 = str8;
                        Requests app9 = MainActivityKt.getApp();
                        String poster110 = "https://v3-cinemeta.strem.io/meta/" + typeset + '/' + it5 + ".json";
                        c00023.L$0 = imdbId5;
                        c00023.L$1 = SpillingKt.nullOutSpilledVariable(savedLogin);
                        c00023.L$2 = SpillingKt.nullOutSpilledVariable(loginPart);
                        c00023.L$3 = SpillingKt.nullOutSpilledVariable(authCookie2);
                        c00023.L$4 = SpillingKt.nullOutSpilledVariable(cfCookies2);
                        c00023.L$5 = SpillingKt.nullOutSpilledVariable(map2);
                        c00023.L$6 = SpillingKt.nullOutSpilledVariable(page2);
                        c00023.L$7 = doc4;
                        c00023.L$8 = SpillingKt.nullOutSpilledVariable(ogTitle2);
                        c00023.L$9 = title5;
                        c00023.L$10 = poster5;
                        c00023.L$11 = bgposter4;
                        c00023.L$12 = trailer5;
                        c00023.L$13 = audioLanguages4;
                        c00023.L$14 = descriptions5;
                        c00023.L$15 = recommendation4;
                        c00023.L$16 = year3;
                        c00023.L$17 = tvtype3;
                        c00023.L$18 = SpillingKt.nullOutSpilledVariable(tmdbmetatype3);
                        c00023.L$19 = genre7;
                        c00023.L$20 = background7;
                        descriptions9 = imdbId5;
                        c00023.L$21 = description6;
                        c00023.L$22 = imdbId9;
                        c00023.L$23 = tmdbId2;
                        c00023.L$24 = logoPath2;
                        c00023.L$25 = SpillingKt.nullOutSpilledVariable(creditsJson);
                        c00023.L$26 = credits;
                        c00023.L$27 = SpillingKt.nullOutSpilledVariable(typeset);
                        c00023.L$28 = SpillingKt.nullOutSpilledVariable(it5);
                        c00023.label = 4;
                        bgposter7 = bgposter4;
                        audioLanguages8 = trailer5;
                        trailer8 = audioLanguages4;
                        tmdbId5 = tmdbId2;
                        C00021 c00027 = c00023;
                        recommendation7 = recommendation4;
                        year6 = year3;
                        genre10 = genre7;
                        background9 = background7;
                        logoPath4 = logoPath2;
                        Object obj17 = obj;
                        tvtype5 = tvtype3;
                        obj8 = obj17;
                        poster8 = poster5;
                        descriptions10 = descriptions5;
                        doc7 = doc4;
                        cinemacity = this;
                        obj9 = Requests.get$default(app9, poster110, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00027, 4094, (Object) null);
                        c00023 = c00027;
                        if (obj9 == obj8) {
                            return obj8;
                        }
                        title8 = title5;
                        year7 = year6;
                        description8 = description6;
                        list2 = credits;
                        creditsJson2 = creditsJson;
                        logoPath5 = logoPath4;
                        castList = recommendation7;
                        imdbId11 = imdbId9;
                        typeset4 = typeset;
                        tmdbId6 = tmdbId5;
                        it6 = it5;
                        creditsJson3 = savedLogin;
                        genre11 = genre10;
                        loginPart3 = loginPart;
                        text = ((NiceResponse) obj9).getText();
                        Integer year14 = year7;
                        trailer6 = str5;
                        if (StringsKt.startsWith$default(text, trailer6, false, 2, (Object) null)) {
                            AppUtils appUtils4 = AppUtils.INSTANCE;
                            if (text == null) {
                                objDecodeFromString = null;
                            } else {
                                Result.Companion companion18 = Result.Companion;
                                KType kTypeTypeOf4 = Reflection.typeOf(ResponseData.class);
                                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                obj10 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf4));
                                if (Result.exceptionOrNull-impl(obj10) != null) {
                                    Result.Companion companion19 = Result.Companion;
                                    obj10 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(ResponseData.class), (List) null, 2, (Object) null));
                                    break;
                                }
                                if (Result.isFailure-impl(obj10)) {
                                    obj10 = null;
                                }
                                deserializationStrategy = (KSerializer) obj10;
                                if (deserializationStrategy != null) {
                                    value$iv$iv = text;
                                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv$iv);
                                } else {
                                    value$iv$iv = text;
                                }
                                ObjectMapper $this$readValue$iv$iv$iv6 = MainAPIKt.getMapper();
                                String content$iv$iv$iv6 = value$iv$iv;
                                objDecodeFromString = $this$readValue$iv$iv$iv6.readValue(content$iv$iv$iv6, new TypeReference<ResponseData>() { // from class: com.Cinemacity.Cinemacity$load$lambda$11$$inlined$tryParseJson$1
                                });
                            }
                            responseData2 = (ResponseData) objDecodeFromString;
                        } else {
                            responseData2 = null;
                        }
                        year5 = year14;
                        responseData = responseData2;
                        typeset2 = typeset4;
                        logoPath3 = logoPath5;
                        description7 = description8;
                        tmdbId4 = tmdbId6;
                        imdbId10 = imdbId11;
                        list = list2;
                        genre9 = genre11;
                        recommendation6 = castList;
                        savedLogin = creditsJson3;
                        descriptions8 = descriptions10;
                        doc6 = doc7;
                        typeset3 = descriptions9;
                        trailer7 = audioLanguages8;
                        audioLanguages7 = trailer8;
                        tvtype4 = tvtype5;
                        bgposter6 = bgposter7;
                        poster7 = poster8;
                        background8 = background9;
                        break;
                    }
                    if (responseData != null) {
                        description9 = it9.getDescription();
                        if (description9 == null) {
                            description9 = descriptions8;
                        }
                        description7.element = description9;
                        background10 = it9.getBackground();
                        if (background10 == null) {
                            background10 = poster7;
                        }
                        background8.element = background10;
                        genre9.element = it9.getGenres();
                        Unit unit11 = Unit.INSTANCE;
                    }
                    if (responseData == null) {
                    }
                    element2 = (Element) CollectionsKt.getOrNull(doc6.select("script:containsData(atob)"), 1);
                    if (element2 != null) {
                    }
                    throw new IllegalStateException("PlayerJS not found; only torrent links available".toString());
                }
                Object obj18 = obj;
                TvType tvtype12 = tvtype3;
                obj8 = obj18;
                String url13 = imdbId5;
                Document doc12 = doc4;
                typeset2 = typeset;
                String poster111 = poster5;
                String bgposter16 = bgposter4;
                String trailer15 = trailer5;
                cinemacity = this;
                trailer6 = str5;
                description7 = description6;
                list = credits;
                year5 = year3;
                genre9 = genre7;
                creditsJson2 = creditsJson;
                logoPath3 = logoPath2;
                recommendation6 = recommendation4;
                imdbId10 = imdbId9;
                tmdbId4 = tmdbId2;
                responseData = null;
                title8 = title5;
                loginPart3 = loginPart;
                descriptions8 = descriptions5;
                doc6 = doc12;
                typeset3 = url13;
                trailer7 = trailer15;
                audioLanguages7 = audioLanguages4;
                bgposter6 = bgposter16;
                poster7 = poster111;
                background8 = background7;
                tvtype4 = tvtype12;
                if (responseData != null) {
                    description9 = it9.getDescription();
                    if (description9 == null) {
                        description9 = descriptions8;
                    }
                    description7.element = description9;
                    background10 = it9.getBackground();
                    if (background10 == null) {
                        background10 = poster7;
                    }
                    background8.element = background10;
                    genre9.element = it9.getGenres();
                    Unit unit12 = Unit.INSTANCE;
                }
                if (responseData == null) {
                }
                element2 = (Element) CollectionsKt.getOrNull(doc6.select("script:containsData(atob)"), 1);
                if (element2 != null) {
                }
                throw new IllegalStateException("PlayerJS not found; only torrent links available".toString());
            case 2:
                title4 = (String) c00023.L$22;
                description3 = (Ref.ObjectRef) c00023.L$21;
                background3 = (Ref.ObjectRef) c00023.L$20;
                genre4 = (Ref.ObjectRef) c00023.L$19;
                tmdbmetatype2 = (String) c00023.L$18;
                TvType tvtype13 = (TvType) c00023.L$17;
                Integer year15 = (Integer) c00023.L$16;
                List recommendation11 = (List) c00023.L$15;
                String descriptions11 = (String) c00023.L$14;
                String audioLanguages16 = (String) c00023.L$13;
                trailer4 = (String) c00023.L$12;
                String bgposter17 = (String) c00023.L$11;
                String poster20 = (String) c00023.L$10;
                String title9 = (String) c00023.L$9;
                String ogTitle5 = (String) c00023.L$8;
                doc3 = (Document) c00023.L$7;
                page2 = (NiceResponse) c00023.L$6;
                map2 = (Map) c00023.L$5;
                String authCookie5 = (String) c00023.L$4;
                authCookie2 = (String) c00023.L$3;
                String loginPart6 = (String) c00023.L$2;
                String savedLogin4 = (String) c00023.L$1;
                String url14 = (String) c00023.L$0;
                try {
                    ResultKt.throwOnFailure($result3);
                    obj3 = $result3;
                    obj2 = coroutine_suspended;
                    str5 = "{";
                    str4 = "";
                    tvtype2 = tvtype13;
                    descriptions4 = descriptions11;
                    audioLanguages3 = audioLanguages16;
                    bgposter3 = bgposter17;
                    poster3 = poster20;
                    title3 = title9;
                    ogTitle2 = ogTitle5;
                    loginPart = loginPart6;
                    loginPart2 = url14;
                    year = year15;
                    savedLogin = savedLogin4;
                    i = 0;
                    recommendation3 = recommendation11;
                    authCookie = authCookie5;
                    obj6 = new JSONObject(((NiceResponse) obj3).getText());
                    jSONArrayOptJSONArray = obj6.optJSONArray("movie_results");
                    if (jSONArrayOptJSONArray != null) {
                        jSONArrayOptJSONArray2 = obj6.optJSONArray("tv_results");
                        if (jSONArrayOptJSONArray2 != null) {
                            numBoxInt = null;
                        } else {
                            numBoxInt = null;
                        }
                    } else {
                        jSONArrayOptJSONArray2 = obj6.optJSONArray("tv_results");
                        if (jSONArrayOptJSONArray2 != null) {
                            numBoxInt = null;
                        } else {
                            numBoxInt = null;
                        }
                    }
                    Ref.ObjectRef objectRef10 = genre4;
                    obj4 = Result.constructor-impl(numBoxInt);
                    genre6 = objectRef10;
                } catch (Throwable th25) {
                    th = th25;
                    obj2 = coroutine_suspended;
                    str5 = "{";
                    str4 = "";
                    tvtype2 = tvtype13;
                    descriptions4 = descriptions11;
                    audioLanguages3 = audioLanguages16;
                    trailer3 = trailer4;
                    bgposter3 = bgposter17;
                    poster3 = poster20;
                    title3 = title9;
                    ogTitle2 = ogTitle5;
                    doc2 = doc3;
                    page = page2;
                    map = map2;
                    loginPart = loginPart6;
                    loginPart2 = url14;
                    year = year15;
                    cfCookies = authCookie2;
                    savedLogin = savedLogin4;
                    recommendation3 = recommendation11;
                    authCookie = authCookie5;
                    Result.Companion companion20 = Result.Companion;
                    Ref.ObjectRef objectRef11 = genre4;
                    obj4 = Result.constructor-impl(ResultKt.createFailure(th));
                    genre6 = objectRef11;
                    authCookie2 = cfCookies;
                    map2 = map;
                    page2 = page;
                    doc3 = doc2;
                    trailer4 = trailer3;
                    if (Result.isFailure-impl(obj4)) {
                        obj4 = null;
                    }
                    num = (Integer) obj4;
                    if (num != null) {
                        strValueOf = String.valueOf(num.intValue());
                    } else {
                        strValueOf = null;
                    }
                    genre3 = genre6;
                    imdbId2 = title4;
                    background2 = background3;
                    str6 = strValueOf;
                    trailer2 = trailer4;
                    doc = doc3;
                    obj = obj2;
                    description2 = description3;
                    url3 = loginPart2;
                    recommendation2 = recommendation3;
                    title2 = title3;
                    bgposter2 = bgposter3;
                    imdbId3 = audioLanguages3;
                    poster2 = poster3;
                    year2 = year;
                    descriptions3 = descriptions4;
                    $result = tvtype2;
                    tmdbId = str6;
                    if (imdbId2 != null) {
                        String it27 = imdbId2;
                        it4 = "https://live.metahub.space/logo/medium/" + it27 + "/img";
                    } else {
                        it4 = null;
                    }
                    logoPath = it4;
                    if (tmdbId != null) {
                        Result.Companion companion110 = Result.Companion;
                        Cinemacity $this$load_u24lambda_u249_u243 = this;
                        Requests app10 = MainActivityKt.getApp();
                        String str115 = "https://api.themoviedb.org/3/" + tmdbmetatype2 + '/' + tmdbId + "/credits?api_key=1865f43a0549ca50d341dd9ab8b29f49&language=en-US";
                        c00023.L$0 = url3;
                        c00023.L$1 = SpillingKt.nullOutSpilledVariable(savedLogin);
                        c00023.L$2 = SpillingKt.nullOutSpilledVariable(loginPart);
                        c00023.L$3 = SpillingKt.nullOutSpilledVariable(authCookie2);
                        c00023.L$4 = SpillingKt.nullOutSpilledVariable(authCookie);
                        c00023.L$5 = SpillingKt.nullOutSpilledVariable(map2);
                        c00023.L$6 = SpillingKt.nullOutSpilledVariable(page2);
                        c00023.L$7 = doc;
                        c00023.L$8 = SpillingKt.nullOutSpilledVariable(ogTitle2);
                        c00023.L$9 = title2;
                        c00023.L$10 = poster2;
                        c00023.L$11 = bgposter2;
                        c00023.L$12 = trailer2;
                        c00023.L$13 = imdbId3;
                        c00023.L$14 = descriptions3;
                        c00023.L$15 = recommendation2;
                        c00023.L$16 = year2;
                        c00023.L$17 = $result;
                        c00023.L$18 = SpillingKt.nullOutSpilledVariable(tmdbmetatype2);
                        genre8 = genre3;
                        c00023.L$19 = genre8;
                        title7 = title2;
                        background5 = background2;
                        c00023.L$20 = background5;
                        background6 = description2;
                        c00023.L$21 = background6;
                        imdbId7 = imdbId2;
                        c00023.L$22 = imdbId7;
                        c00023.L$23 = tmdbId;
                        c00023.L$24 = logoPath;
                        c00023.L$25 = SpillingKt.nullOutSpilledVariable(tmdbId);
                        c00023.L$26 = SpillingKt.nullOutSpilledVariable($this$load_u24lambda_u249_u243);
                        c00023.label = 3;
                        poster6 = poster2;
                        bgposter5 = bgposter2;
                        descriptions6 = trailer2;
                        c00022 = c00023;
                        audioLanguages5 = imdbId3;
                        tmdbmetatype4 = descriptions3;
                        recommendation5 = recommendation2;
                        tmdbmetatype3 = tmdbmetatype2;
                        url4 = url3;
                        title6 = title7;
                        year4 = year2;
                        doc5 = doc;
                        obj5 = Requests.get$default(app10, str115, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4094, (Object) null);
                        c00023 = c00022;
                        coroutine_suspended = obj;
                        if (obj5 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        descriptions7 = logoPath;
                        imdbId6 = imdbId7;
                        tmdbId3 = tmdbId;
                        audioLanguages6 = audioLanguages5;
                        background5 = background5;
                        description5 = background6;
                        cfCookies2 = authCookie;
                        String str116 = imdbId6;
                        obj7 = Result.constructor-impl(((NiceResponse) obj5).getText());
                        imdbId8 = str116;
                        if (Result.isFailure-impl(obj7)) {
                            obj7 = null;
                        }
                        obj = coroutine_suspended;
                        logoPath2 = descriptions7;
                        tmdbId2 = tmdbId3;
                        str7 = (String) obj7;
                        description4 = description5;
                        audioLanguages4 = audioLanguages6;
                        imdbId4 = imdbId8;
                        background4 = background5;
                        tvtype3 = $result;
                        descriptions5 = tmdbmetatype4;
                        recommendation4 = recommendation5;
                        year3 = year4;
                        trailer5 = descriptions6;
                        title5 = title6;
                        poster5 = poster6;
                        genre7 = genre8;
                        doc4 = doc5;
                        imdbId5 = url4;
                        bgposter4 = bgposter5;
                    } else {
                        String url15 = url3;
                        String poster112 = poster2;
                        String bgposter18 = bgposter2;
                        String audioLanguages17 = imdbId3;
                        tmdbmetatype3 = tmdbmetatype2;
                        String trailer16 = trailer2;
                        List recommendation12 = recommendation2;
                        Integer year16 = year2;
                        cfCookies2 = authCookie;
                        logoPath2 = logoPath;
                        imdbId4 = imdbId2;
                        tmdbId2 = tmdbId;
                        audioLanguages4 = audioLanguages17;
                        background4 = background2;
                        description4 = description2;
                        str7 = null;
                        genre7 = genre3;
                        tvtype3 = $result;
                        descriptions5 = descriptions3;
                        recommendation4 = recommendation12;
                        year3 = year16;
                        trailer5 = trailer16;
                        doc4 = doc;
                        imdbId5 = url15;
                        title5 = title2;
                        bgposter4 = bgposter18;
                        poster5 = poster112;
                    }
                    creditsJson = str7;
                    description6 = description4;
                    background7 = background4;
                    imdbId9 = imdbId4;
                    credits = parseCredits(creditsJson);
                    typeset = tvtype3 == TvType.TvSeries ? "series" : "movie";
                    if (imdbId9 != null) {
                        if (StringsKt.isBlank(imdbId9)) {
                            str8 = imdbId9;
                        } else {
                            str8 = null;
                        }
                        if (str8 != null) {
                            it5 = str8;
                            Requests app11 = MainActivityKt.getApp();
                            String poster113 = "https://v3-cinemeta.strem.io/meta/" + typeset + '/' + it5 + ".json";
                            c00023.L$0 = imdbId5;
                            c00023.L$1 = SpillingKt.nullOutSpilledVariable(savedLogin);
                            c00023.L$2 = SpillingKt.nullOutSpilledVariable(loginPart);
                            c00023.L$3 = SpillingKt.nullOutSpilledVariable(authCookie2);
                            c00023.L$4 = SpillingKt.nullOutSpilledVariable(cfCookies2);
                            c00023.L$5 = SpillingKt.nullOutSpilledVariable(map2);
                            c00023.L$6 = SpillingKt.nullOutSpilledVariable(page2);
                            c00023.L$7 = doc4;
                            c00023.L$8 = SpillingKt.nullOutSpilledVariable(ogTitle2);
                            c00023.L$9 = title5;
                            c00023.L$10 = poster5;
                            c00023.L$11 = bgposter4;
                            c00023.L$12 = trailer5;
                            c00023.L$13 = audioLanguages4;
                            c00023.L$14 = descriptions5;
                            c00023.L$15 = recommendation4;
                            c00023.L$16 = year3;
                            c00023.L$17 = tvtype3;
                            c00023.L$18 = SpillingKt.nullOutSpilledVariable(tmdbmetatype3);
                            c00023.L$19 = genre7;
                            c00023.L$20 = background7;
                            descriptions9 = imdbId5;
                            c00023.L$21 = description6;
                            c00023.L$22 = imdbId9;
                            c00023.L$23 = tmdbId2;
                            c00023.L$24 = logoPath2;
                            c00023.L$25 = SpillingKt.nullOutSpilledVariable(creditsJson);
                            c00023.L$26 = credits;
                            c00023.L$27 = SpillingKt.nullOutSpilledVariable(typeset);
                            c00023.L$28 = SpillingKt.nullOutSpilledVariable(it5);
                            c00023.label = 4;
                            bgposter7 = bgposter4;
                            audioLanguages8 = trailer5;
                            trailer8 = audioLanguages4;
                            tmdbId5 = tmdbId2;
                            C00021 c00028 = c00023;
                            recommendation7 = recommendation4;
                            year6 = year3;
                            genre10 = genre7;
                            background9 = background7;
                            logoPath4 = logoPath2;
                            Object obj19 = obj;
                            tvtype5 = tvtype3;
                            obj8 = obj19;
                            poster8 = poster5;
                            descriptions10 = descriptions5;
                            doc7 = doc4;
                            cinemacity = this;
                            obj9 = Requests.get$default(app11, poster113, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00028, 4094, (Object) null);
                            c00023 = c00028;
                            if (obj9 == obj8) {
                                return obj8;
                            }
                            title8 = title5;
                            year7 = year6;
                            description8 = description6;
                            list2 = credits;
                            creditsJson2 = creditsJson;
                            logoPath5 = logoPath4;
                            castList = recommendation7;
                            imdbId11 = imdbId9;
                            typeset4 = typeset;
                            tmdbId6 = tmdbId5;
                            it6 = it5;
                            creditsJson3 = savedLogin;
                            genre11 = genre10;
                            loginPart3 = loginPart;
                            text = ((NiceResponse) obj9).getText();
                            Integer year17 = year7;
                            trailer6 = str5;
                            if (StringsKt.startsWith$default(text, trailer6, false, 2, (Object) null)) {
                                AppUtils appUtils5 = AppUtils.INSTANCE;
                                if (text == null) {
                                    objDecodeFromString = null;
                                } else {
                                    Result.Companion companion111 = Result.Companion;
                                    KType kTypeTypeOf5 = Reflection.typeOf(ResponseData.class);
                                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                    obj10 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf5));
                                    if (Result.exceptionOrNull-impl(obj10) != null) {
                                        Result.Companion companion112 = Result.Companion;
                                        obj10 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(ResponseData.class), (List) null, 2, (Object) null));
                                        break;
                                    }
                                    if (Result.isFailure-impl(obj10)) {
                                        obj10 = null;
                                    }
                                    deserializationStrategy = (KSerializer) obj10;
                                    if (deserializationStrategy != null) {
                                        value$iv$iv = text;
                                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv$iv);
                                    } else {
                                        value$iv$iv = text;
                                    }
                                    ObjectMapper $this$readValue$iv$iv$iv7 = MainAPIKt.getMapper();
                                    String content$iv$iv$iv7 = value$iv$iv;
                                    objDecodeFromString = $this$readValue$iv$iv$iv7.readValue(content$iv$iv$iv7, new TypeReference<ResponseData>() { // from class: com.Cinemacity.Cinemacity$load$lambda$11$$inlined$tryParseJson$1
                                    });
                                }
                                responseData2 = (ResponseData) objDecodeFromString;
                            } else {
                                responseData2 = null;
                            }
                            year5 = year17;
                            responseData = responseData2;
                            typeset2 = typeset4;
                            logoPath3 = logoPath5;
                            description7 = description8;
                            tmdbId4 = tmdbId6;
                            imdbId10 = imdbId11;
                            list = list2;
                            genre9 = genre11;
                            recommendation6 = castList;
                            savedLogin = creditsJson3;
                            descriptions8 = descriptions10;
                            doc6 = doc7;
                            typeset3 = descriptions9;
                            trailer7 = audioLanguages8;
                            audioLanguages7 = trailer8;
                            tvtype4 = tvtype5;
                            bgposter6 = bgposter7;
                            poster7 = poster8;
                            background8 = background9;
                            break;
                        }
                        if (responseData != null) {
                            description9 = it9.getDescription();
                            if (description9 == null) {
                                description9 = descriptions8;
                            }
                            description7.element = description9;
                            background10 = it9.getBackground();
                            if (background10 == null) {
                                background10 = poster7;
                            }
                            background8.element = background10;
                            genre9.element = it9.getGenres();
                            Unit unit13 = Unit.INSTANCE;
                        }
                        if (responseData == null) {
                        }
                        element2 = (Element) CollectionsKt.getOrNull(doc6.select("script:containsData(atob)"), 1);
                        if (element2 != null) {
                        }
                        throw new IllegalStateException("PlayerJS not found; only torrent links available".toString());
                    }
                    Object obj110 = obj;
                    TvType tvtype14 = tvtype3;
                    obj8 = obj110;
                    String url16 = imdbId5;
                    Document doc13 = doc4;
                    typeset2 = typeset;
                    String poster114 = poster5;
                    String bgposter19 = bgposter4;
                    String trailer17 = trailer5;
                    cinemacity = this;
                    trailer6 = str5;
                    description7 = description6;
                    list = credits;
                    year5 = year3;
                    genre9 = genre7;
                    creditsJson2 = creditsJson;
                    logoPath3 = logoPath2;
                    recommendation6 = recommendation4;
                    imdbId10 = imdbId9;
                    tmdbId4 = tmdbId2;
                    responseData = null;
                    title8 = title5;
                    loginPart3 = loginPart;
                    descriptions8 = descriptions5;
                    doc6 = doc13;
                    typeset3 = url16;
                    trailer7 = trailer17;
                    audioLanguages7 = audioLanguages4;
                    bgposter6 = bgposter19;
                    poster7 = poster114;
                    background8 = background7;
                    tvtype4 = tvtype14;
                    if (responseData != null) {
                        description9 = it9.getDescription();
                        if (description9 == null) {
                            description9 = descriptions8;
                        }
                        description7.element = description9;
                        background10 = it9.getBackground();
                        if (background10 == null) {
                            background10 = poster7;
                        }
                        background8.element = background10;
                        genre9.element = it9.getGenres();
                        Unit unit14 = Unit.INSTANCE;
                    }
                    if (responseData == null) {
                    }
                    element2 = (Element) CollectionsKt.getOrNull(doc6.select("script:containsData(atob)"), 1);
                    if (element2 != null) {
                    }
                    throw new IllegalStateException("PlayerJS not found; only torrent links available".toString());
                }
                if (Result.isFailure-impl(obj4)) {
                    obj4 = null;
                }
                num = (Integer) obj4;
                if (num != null) {
                    strValueOf = String.valueOf(num.intValue());
                } else {
                    strValueOf = null;
                }
                genre3 = genre6;
                imdbId2 = title4;
                background2 = background3;
                str6 = strValueOf;
                trailer2 = trailer4;
                doc = doc3;
                obj = obj2;
                description2 = description3;
                url3 = loginPart2;
                recommendation2 = recommendation3;
                title2 = title3;
                bgposter2 = bgposter3;
                imdbId3 = audioLanguages3;
                poster2 = poster3;
                year2 = year;
                descriptions3 = descriptions4;
                $result = tvtype2;
                tmdbId = str6;
                if (imdbId2 != null) {
                    String it28 = imdbId2;
                    it4 = "https://live.metahub.space/logo/medium/" + it28 + "/img";
                } else {
                    it4 = null;
                }
                logoPath = it4;
                if (tmdbId != null) {
                    Result.Companion companion113 = Result.Companion;
                    Cinemacity $this$load_u24lambda_u249_u244 = this;
                    Requests app12 = MainActivityKt.getApp();
                    String str117 = "https://api.themoviedb.org/3/" + tmdbmetatype2 + '/' + tmdbId + "/credits?api_key=1865f43a0549ca50d341dd9ab8b29f49&language=en-US";
                    c00023.L$0 = url3;
                    c00023.L$1 = SpillingKt.nullOutSpilledVariable(savedLogin);
                    c00023.L$2 = SpillingKt.nullOutSpilledVariable(loginPart);
                    c00023.L$3 = SpillingKt.nullOutSpilledVariable(authCookie2);
                    c00023.L$4 = SpillingKt.nullOutSpilledVariable(authCookie);
                    c00023.L$5 = SpillingKt.nullOutSpilledVariable(map2);
                    c00023.L$6 = SpillingKt.nullOutSpilledVariable(page2);
                    c00023.L$7 = doc;
                    c00023.L$8 = SpillingKt.nullOutSpilledVariable(ogTitle2);
                    c00023.L$9 = title2;
                    c00023.L$10 = poster2;
                    c00023.L$11 = bgposter2;
                    c00023.L$12 = trailer2;
                    c00023.L$13 = imdbId3;
                    c00023.L$14 = descriptions3;
                    c00023.L$15 = recommendation2;
                    c00023.L$16 = year2;
                    c00023.L$17 = $result;
                    c00023.L$18 = SpillingKt.nullOutSpilledVariable(tmdbmetatype2);
                    genre8 = genre3;
                    c00023.L$19 = genre8;
                    title7 = title2;
                    background5 = background2;
                    c00023.L$20 = background5;
                    background6 = description2;
                    c00023.L$21 = background6;
                    imdbId7 = imdbId2;
                    c00023.L$22 = imdbId7;
                    c00023.L$23 = tmdbId;
                    c00023.L$24 = logoPath;
                    c00023.L$25 = SpillingKt.nullOutSpilledVariable(tmdbId);
                    c00023.L$26 = SpillingKt.nullOutSpilledVariable($this$load_u24lambda_u249_u244);
                    c00023.label = 3;
                    poster6 = poster2;
                    bgposter5 = bgposter2;
                    descriptions6 = trailer2;
                    c00022 = c00023;
                    audioLanguages5 = imdbId3;
                    tmdbmetatype4 = descriptions3;
                    recommendation5 = recommendation2;
                    tmdbmetatype3 = tmdbmetatype2;
                    url4 = url3;
                    title6 = title7;
                    year4 = year2;
                    doc5 = doc;
                    obj5 = Requests.get$default(app12, str117, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4094, (Object) null);
                    c00023 = c00022;
                    coroutine_suspended = obj;
                    if (obj5 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    descriptions7 = logoPath;
                    imdbId6 = imdbId7;
                    tmdbId3 = tmdbId;
                    audioLanguages6 = audioLanguages5;
                    background5 = background5;
                    description5 = background6;
                    cfCookies2 = authCookie;
                    String str118 = imdbId6;
                    obj7 = Result.constructor-impl(((NiceResponse) obj5).getText());
                    imdbId8 = str118;
                    if (Result.isFailure-impl(obj7)) {
                        obj7 = null;
                    }
                    obj = coroutine_suspended;
                    logoPath2 = descriptions7;
                    tmdbId2 = tmdbId3;
                    str7 = (String) obj7;
                    description4 = description5;
                    audioLanguages4 = audioLanguages6;
                    imdbId4 = imdbId8;
                    background4 = background5;
                    tvtype3 = $result;
                    descriptions5 = tmdbmetatype4;
                    recommendation4 = recommendation5;
                    year3 = year4;
                    trailer5 = descriptions6;
                    title5 = title6;
                    poster5 = poster6;
                    genre7 = genre8;
                    doc4 = doc5;
                    imdbId5 = url4;
                    bgposter4 = bgposter5;
                } else {
                    String url17 = url3;
                    String poster115 = poster2;
                    String bgposter110 = bgposter2;
                    String audioLanguages18 = imdbId3;
                    tmdbmetatype3 = tmdbmetatype2;
                    String trailer18 = trailer2;
                    List recommendation13 = recommendation2;
                    Integer year18 = year2;
                    cfCookies2 = authCookie;
                    logoPath2 = logoPath;
                    imdbId4 = imdbId2;
                    tmdbId2 = tmdbId;
                    audioLanguages4 = audioLanguages18;
                    background4 = background2;
                    description4 = description2;
                    str7 = null;
                    genre7 = genre3;
                    tvtype3 = $result;
                    descriptions5 = descriptions3;
                    recommendation4 = recommendation13;
                    year3 = year18;
                    trailer5 = trailer18;
                    doc4 = doc;
                    imdbId5 = url17;
                    title5 = title2;
                    bgposter4 = bgposter110;
                    poster5 = poster115;
                }
                creditsJson = str7;
                description6 = description4;
                background7 = background4;
                imdbId9 = imdbId4;
                credits = parseCredits(creditsJson);
                typeset = tvtype3 == TvType.TvSeries ? "series" : "movie";
                if (imdbId9 != null) {
                    if (StringsKt.isBlank(imdbId9)) {
                        str8 = imdbId9;
                    } else {
                        str8 = null;
                    }
                    if (str8 != null) {
                        it5 = str8;
                        Requests app13 = MainActivityKt.getApp();
                        String poster116 = "https://v3-cinemeta.strem.io/meta/" + typeset + '/' + it5 + ".json";
                        c00023.L$0 = imdbId5;
                        c00023.L$1 = SpillingKt.nullOutSpilledVariable(savedLogin);
                        c00023.L$2 = SpillingKt.nullOutSpilledVariable(loginPart);
                        c00023.L$3 = SpillingKt.nullOutSpilledVariable(authCookie2);
                        c00023.L$4 = SpillingKt.nullOutSpilledVariable(cfCookies2);
                        c00023.L$5 = SpillingKt.nullOutSpilledVariable(map2);
                        c00023.L$6 = SpillingKt.nullOutSpilledVariable(page2);
                        c00023.L$7 = doc4;
                        c00023.L$8 = SpillingKt.nullOutSpilledVariable(ogTitle2);
                        c00023.L$9 = title5;
                        c00023.L$10 = poster5;
                        c00023.L$11 = bgposter4;
                        c00023.L$12 = trailer5;
                        c00023.L$13 = audioLanguages4;
                        c00023.L$14 = descriptions5;
                        c00023.L$15 = recommendation4;
                        c00023.L$16 = year3;
                        c00023.L$17 = tvtype3;
                        c00023.L$18 = SpillingKt.nullOutSpilledVariable(tmdbmetatype3);
                        c00023.L$19 = genre7;
                        c00023.L$20 = background7;
                        descriptions9 = imdbId5;
                        c00023.L$21 = description6;
                        c00023.L$22 = imdbId9;
                        c00023.L$23 = tmdbId2;
                        c00023.L$24 = logoPath2;
                        c00023.L$25 = SpillingKt.nullOutSpilledVariable(creditsJson);
                        c00023.L$26 = credits;
                        c00023.L$27 = SpillingKt.nullOutSpilledVariable(typeset);
                        c00023.L$28 = SpillingKt.nullOutSpilledVariable(it5);
                        c00023.label = 4;
                        bgposter7 = bgposter4;
                        audioLanguages8 = trailer5;
                        trailer8 = audioLanguages4;
                        tmdbId5 = tmdbId2;
                        C00021 c00029 = c00023;
                        recommendation7 = recommendation4;
                        year6 = year3;
                        genre10 = genre7;
                        background9 = background7;
                        logoPath4 = logoPath2;
                        Object obj111 = obj;
                        tvtype5 = tvtype3;
                        obj8 = obj111;
                        poster8 = poster5;
                        descriptions10 = descriptions5;
                        doc7 = doc4;
                        cinemacity = this;
                        obj9 = Requests.get$default(app13, poster116, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00029, 4094, (Object) null);
                        c00023 = c00029;
                        if (obj9 == obj8) {
                            return obj8;
                        }
                        title8 = title5;
                        year7 = year6;
                        description8 = description6;
                        list2 = credits;
                        creditsJson2 = creditsJson;
                        logoPath5 = logoPath4;
                        castList = recommendation7;
                        imdbId11 = imdbId9;
                        typeset4 = typeset;
                        tmdbId6 = tmdbId5;
                        it6 = it5;
                        creditsJson3 = savedLogin;
                        genre11 = genre10;
                        loginPart3 = loginPart;
                        text = ((NiceResponse) obj9).getText();
                        Integer year19 = year7;
                        trailer6 = str5;
                        if (StringsKt.startsWith$default(text, trailer6, false, 2, (Object) null)) {
                            AppUtils appUtils6 = AppUtils.INSTANCE;
                            if (text == null) {
                                objDecodeFromString = null;
                            } else {
                                Result.Companion companion114 = Result.Companion;
                                KType kTypeTypeOf6 = Reflection.typeOf(ResponseData.class);
                                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                obj10 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf6));
                                if (Result.exceptionOrNull-impl(obj10) != null) {
                                    Result.Companion companion115 = Result.Companion;
                                    obj10 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(ResponseData.class), (List) null, 2, (Object) null));
                                    break;
                                }
                                if (Result.isFailure-impl(obj10)) {
                                    obj10 = null;
                                }
                                deserializationStrategy = (KSerializer) obj10;
                                if (deserializationStrategy != null) {
                                    value$iv$iv = text;
                                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv$iv);
                                } else {
                                    value$iv$iv = text;
                                }
                                ObjectMapper $this$readValue$iv$iv$iv8 = MainAPIKt.getMapper();
                                String content$iv$iv$iv8 = value$iv$iv;
                                objDecodeFromString = $this$readValue$iv$iv$iv8.readValue(content$iv$iv$iv8, new TypeReference<ResponseData>() { // from class: com.Cinemacity.Cinemacity$load$lambda$11$$inlined$tryParseJson$1
                                });
                            }
                            responseData2 = (ResponseData) objDecodeFromString;
                        } else {
                            responseData2 = null;
                        }
                        year5 = year19;
                        responseData = responseData2;
                        typeset2 = typeset4;
                        logoPath3 = logoPath5;
                        description7 = description8;
                        tmdbId4 = tmdbId6;
                        imdbId10 = imdbId11;
                        list = list2;
                        genre9 = genre11;
                        recommendation6 = castList;
                        savedLogin = creditsJson3;
                        descriptions8 = descriptions10;
                        doc6 = doc7;
                        typeset3 = descriptions9;
                        trailer7 = audioLanguages8;
                        audioLanguages7 = trailer8;
                        tvtype4 = tvtype5;
                        bgposter6 = bgposter7;
                        poster7 = poster8;
                        background8 = background9;
                        break;
                    }
                    if (responseData != null) {
                        description9 = it9.getDescription();
                        if (description9 == null) {
                            description9 = descriptions8;
                        }
                        description7.element = description9;
                        background10 = it9.getBackground();
                        if (background10 == null) {
                            background10 = poster7;
                        }
                        background8.element = background10;
                        genre9.element = it9.getGenres();
                        Unit unit15 = Unit.INSTANCE;
                    }
                    if (responseData == null) {
                    }
                    element2 = (Element) CollectionsKt.getOrNull(doc6.select("script:containsData(atob)"), 1);
                    if (element2 != null) {
                    }
                    throw new IllegalStateException("PlayerJS not found; only torrent links available".toString());
                }
                Object obj112 = obj;
                TvType tvtype15 = tvtype3;
                obj8 = obj112;
                String url18 = imdbId5;
                Document doc14 = doc4;
                typeset2 = typeset;
                String poster117 = poster5;
                String bgposter111 = bgposter4;
                String trailer19 = trailer5;
                cinemacity = this;
                trailer6 = str5;
                description7 = description6;
                list = credits;
                year5 = year3;
                genre9 = genre7;
                creditsJson2 = creditsJson;
                logoPath3 = logoPath2;
                recommendation6 = recommendation4;
                imdbId10 = imdbId9;
                tmdbId4 = tmdbId2;
                responseData = null;
                title8 = title5;
                loginPart3 = loginPart;
                descriptions8 = descriptions5;
                doc6 = doc14;
                typeset3 = url18;
                trailer7 = trailer19;
                audioLanguages7 = audioLanguages4;
                bgposter6 = bgposter111;
                poster7 = poster117;
                background8 = background7;
                tvtype4 = tvtype15;
                if (responseData != null) {
                    description9 = it9.getDescription();
                    if (description9 == null) {
                        description9 = descriptions8;
                    }
                    description7.element = description9;
                    background10 = it9.getBackground();
                    if (background10 == null) {
                        background10 = poster7;
                    }
                    background8.element = background10;
                    genre9.element = it9.getGenres();
                    Unit unit16 = Unit.INSTANCE;
                }
                if (responseData == null) {
                }
                element2 = (Element) CollectionsKt.getOrNull(doc6.select("script:containsData(atob)"), 1);
                if (element2 != null) {
                }
                throw new IllegalStateException("PlayerJS not found; only torrent links available".toString());
            case 3:
                descriptions7 = (String) c00023.L$24;
                tmdbId3 = (String) c00023.L$23;
                imdbId6 = (String) c00023.L$22;
                description5 = (Ref.ObjectRef) c00023.L$21;
                background5 = (Ref.ObjectRef) c00023.L$20;
                Ref.ObjectRef genre12 = (Ref.ObjectRef) c00023.L$19;
                String tmdbmetatype5 = (String) c00023.L$18;
                TvType tvtype16 = (TvType) c00023.L$17;
                Integer year20 = (Integer) c00023.L$16;
                List recommendation14 = (List) c00023.L$15;
                String descriptions12 = (String) c00023.L$14;
                audioLanguages6 = (String) c00023.L$13;
                String trailer20 = (String) c00023.L$12;
                String bgposter20 = (String) c00023.L$11;
                String poster21 = (String) c00023.L$10;
                String title10 = (String) c00023.L$9;
                String ogTitle6 = (String) c00023.L$8;
                Document doc15 = (Document) c00023.L$7;
                NiceResponse page3 = (NiceResponse) c00023.L$6;
                Map<String, String> map4 = (Map) c00023.L$5;
                cfCookies2 = (String) c00023.L$4;
                String cfCookies5 = (String) c00023.L$3;
                String loginPart7 = (String) c00023.L$2;
                String savedLogin5 = (String) c00023.L$1;
                String url19 = (String) c00023.L$0;
                try {
                    ResultKt.throwOnFailure($result3);
                    year4 = year20;
                    recommendation5 = recommendation14;
                    url4 = url19;
                    obj5 = $result3;
                    str5 = "{";
                    str4 = "";
                    genre8 = genre12;
                    tmdbmetatype3 = tmdbmetatype5;
                    tmdbmetatype4 = descriptions12;
                    descriptions6 = trailer20;
                    bgposter5 = bgposter20;
                    poster6 = poster21;
                    title6 = title10;
                    ogTitle2 = ogTitle6;
                    page2 = page3;
                    loginPart = loginPart7;
                    savedLogin = savedLogin5;
                    $result = tvtype16;
                    doc5 = doc15;
                    map2 = map4;
                    authCookie2 = cfCookies5;
                    String str119 = imdbId6;
                    obj7 = Result.constructor-impl(((NiceResponse) obj5).getText());
                    imdbId8 = str119;
                } catch (Throwable th26) {
                    th = th26;
                    year4 = year20;
                    recommendation5 = recommendation14;
                    url4 = url19;
                    str5 = "{";
                    str4 = "";
                    genre8 = genre12;
                    tmdbmetatype3 = tmdbmetatype5;
                    tmdbmetatype4 = descriptions12;
                    audioLanguages5 = audioLanguages6;
                    descriptions6 = trailer20;
                    bgposter5 = bgposter20;
                    poster6 = poster21;
                    title6 = title10;
                    ogTitle2 = ogTitle6;
                    page2 = page3;
                    loginPart = loginPart7;
                    savedLogin = savedLogin5;
                    $result = tvtype16;
                    doc5 = doc15;
                    map2 = map4;
                    authCookie = cfCookies2;
                    authCookie2 = cfCookies5;
                    Result.Companion companion21 = Result.Companion;
                    String str120 = imdbId6;
                    obj7 = Result.constructor-impl(ResultKt.createFailure(th));
                    imdbId8 = str120;
                    cfCookies2 = authCookie;
                    audioLanguages6 = audioLanguages5;
                    if (Result.isFailure-impl(obj7)) {
                        obj7 = null;
                    }
                    obj = coroutine_suspended;
                    logoPath2 = descriptions7;
                    tmdbId2 = tmdbId3;
                    str7 = (String) obj7;
                    description4 = description5;
                    audioLanguages4 = audioLanguages6;
                    imdbId4 = imdbId8;
                    background4 = background5;
                    tvtype3 = $result;
                    descriptions5 = tmdbmetatype4;
                    recommendation4 = recommendation5;
                    year3 = year4;
                    trailer5 = descriptions6;
                    title5 = title6;
                    poster5 = poster6;
                    genre7 = genre8;
                    doc4 = doc5;
                    imdbId5 = url4;
                    bgposter4 = bgposter5;
                    creditsJson = str7;
                    description6 = description4;
                    background7 = background4;
                    imdbId9 = imdbId4;
                    credits = parseCredits(creditsJson);
                    typeset = tvtype3 == TvType.TvSeries ? "series" : "movie";
                    if (imdbId9 != null) {
                        if (StringsKt.isBlank(imdbId9)) {
                            str8 = imdbId9;
                        } else {
                            str8 = null;
                        }
                        if (str8 != null) {
                            it5 = str8;
                            Requests app14 = MainActivityKt.getApp();
                            String poster118 = "https://v3-cinemeta.strem.io/meta/" + typeset + '/' + it5 + ".json";
                            c00023.L$0 = imdbId5;
                            c00023.L$1 = SpillingKt.nullOutSpilledVariable(savedLogin);
                            c00023.L$2 = SpillingKt.nullOutSpilledVariable(loginPart);
                            c00023.L$3 = SpillingKt.nullOutSpilledVariable(authCookie2);
                            c00023.L$4 = SpillingKt.nullOutSpilledVariable(cfCookies2);
                            c00023.L$5 = SpillingKt.nullOutSpilledVariable(map2);
                            c00023.L$6 = SpillingKt.nullOutSpilledVariable(page2);
                            c00023.L$7 = doc4;
                            c00023.L$8 = SpillingKt.nullOutSpilledVariable(ogTitle2);
                            c00023.L$9 = title5;
                            c00023.L$10 = poster5;
                            c00023.L$11 = bgposter4;
                            c00023.L$12 = trailer5;
                            c00023.L$13 = audioLanguages4;
                            c00023.L$14 = descriptions5;
                            c00023.L$15 = recommendation4;
                            c00023.L$16 = year3;
                            c00023.L$17 = tvtype3;
                            c00023.L$18 = SpillingKt.nullOutSpilledVariable(tmdbmetatype3);
                            c00023.L$19 = genre7;
                            c00023.L$20 = background7;
                            descriptions9 = imdbId5;
                            c00023.L$21 = description6;
                            c00023.L$22 = imdbId9;
                            c00023.L$23 = tmdbId2;
                            c00023.L$24 = logoPath2;
                            c00023.L$25 = SpillingKt.nullOutSpilledVariable(creditsJson);
                            c00023.L$26 = credits;
                            c00023.L$27 = SpillingKt.nullOutSpilledVariable(typeset);
                            c00023.L$28 = SpillingKt.nullOutSpilledVariable(it5);
                            c00023.label = 4;
                            bgposter7 = bgposter4;
                            audioLanguages8 = trailer5;
                            trailer8 = audioLanguages4;
                            tmdbId5 = tmdbId2;
                            C00021 c000210 = c00023;
                            recommendation7 = recommendation4;
                            year6 = year3;
                            genre10 = genre7;
                            background9 = background7;
                            logoPath4 = logoPath2;
                            Object obj113 = obj;
                            tvtype5 = tvtype3;
                            obj8 = obj113;
                            poster8 = poster5;
                            descriptions10 = descriptions5;
                            doc7 = doc4;
                            cinemacity = this;
                            obj9 = Requests.get$default(app14, poster118, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000210, 4094, (Object) null);
                            c00023 = c000210;
                            if (obj9 == obj8) {
                                return obj8;
                            }
                            title8 = title5;
                            year7 = year6;
                            description8 = description6;
                            list2 = credits;
                            creditsJson2 = creditsJson;
                            logoPath5 = logoPath4;
                            castList = recommendation7;
                            imdbId11 = imdbId9;
                            typeset4 = typeset;
                            tmdbId6 = tmdbId5;
                            it6 = it5;
                            creditsJson3 = savedLogin;
                            genre11 = genre10;
                            loginPart3 = loginPart;
                            text = ((NiceResponse) obj9).getText();
                            Integer year110 = year7;
                            trailer6 = str5;
                            if (StringsKt.startsWith$default(text, trailer6, false, 2, (Object) null)) {
                                AppUtils appUtils7 = AppUtils.INSTANCE;
                                if (text == null) {
                                    objDecodeFromString = null;
                                } else {
                                    Result.Companion companion116 = Result.Companion;
                                    KType kTypeTypeOf7 = Reflection.typeOf(ResponseData.class);
                                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                    obj10 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf7));
                                    if (Result.exceptionOrNull-impl(obj10) != null) {
                                        Result.Companion companion117 = Result.Companion;
                                        obj10 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(ResponseData.class), (List) null, 2, (Object) null));
                                        break;
                                    }
                                    if (Result.isFailure-impl(obj10)) {
                                        obj10 = null;
                                    }
                                    deserializationStrategy = (KSerializer) obj10;
                                    if (deserializationStrategy != null) {
                                        value$iv$iv = text;
                                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv$iv);
                                    } else {
                                        value$iv$iv = text;
                                    }
                                    ObjectMapper $this$readValue$iv$iv$iv9 = MainAPIKt.getMapper();
                                    String content$iv$iv$iv9 = value$iv$iv;
                                    objDecodeFromString = $this$readValue$iv$iv$iv9.readValue(content$iv$iv$iv9, new TypeReference<ResponseData>() { // from class: com.Cinemacity.Cinemacity$load$lambda$11$$inlined$tryParseJson$1
                                    });
                                }
                                responseData2 = (ResponseData) objDecodeFromString;
                            } else {
                                responseData2 = null;
                            }
                            year5 = year110;
                            responseData = responseData2;
                            typeset2 = typeset4;
                            logoPath3 = logoPath5;
                            description7 = description8;
                            tmdbId4 = tmdbId6;
                            imdbId10 = imdbId11;
                            list = list2;
                            genre9 = genre11;
                            recommendation6 = castList;
                            savedLogin = creditsJson3;
                            descriptions8 = descriptions10;
                            doc6 = doc7;
                            typeset3 = descriptions9;
                            trailer7 = audioLanguages8;
                            audioLanguages7 = trailer8;
                            tvtype4 = tvtype5;
                            bgposter6 = bgposter7;
                            poster7 = poster8;
                            background8 = background9;
                            break;
                        }
                        if (responseData != null) {
                            description9 = it9.getDescription();
                            if (description9 == null) {
                                description9 = descriptions8;
                            }
                            description7.element = description9;
                            background10 = it9.getBackground();
                            if (background10 == null) {
                                background10 = poster7;
                            }
                            background8.element = background10;
                            genre9.element = it9.getGenres();
                            Unit unit17 = Unit.INSTANCE;
                        }
                        if (responseData == null) {
                        }
                        element2 = (Element) CollectionsKt.getOrNull(doc6.select("script:containsData(atob)"), 1);
                        if (element2 != null) {
                        }
                        throw new IllegalStateException("PlayerJS not found; only torrent links available".toString());
                    }
                    Object obj114 = obj;
                    TvType tvtype17 = tvtype3;
                    obj8 = obj114;
                    String url110 = imdbId5;
                    Document doc16 = doc4;
                    typeset2 = typeset;
                    String poster119 = poster5;
                    String bgposter112 = bgposter4;
                    String trailer110 = trailer5;
                    cinemacity = this;
                    trailer6 = str5;
                    description7 = description6;
                    list = credits;
                    year5 = year3;
                    genre9 = genre7;
                    creditsJson2 = creditsJson;
                    logoPath3 = logoPath2;
                    recommendation6 = recommendation4;
                    imdbId10 = imdbId9;
                    tmdbId4 = tmdbId2;
                    responseData = null;
                    title8 = title5;
                    loginPart3 = loginPart;
                    descriptions8 = descriptions5;
                    doc6 = doc16;
                    typeset3 = url110;
                    trailer7 = trailer110;
                    audioLanguages7 = audioLanguages4;
                    bgposter6 = bgposter112;
                    poster7 = poster119;
                    background8 = background7;
                    tvtype4 = tvtype17;
                    if (responseData != null) {
                        description9 = it9.getDescription();
                        if (description9 == null) {
                            description9 = descriptions8;
                        }
                        description7.element = description9;
                        background10 = it9.getBackground();
                        if (background10 == null) {
                            background10 = poster7;
                        }
                        background8.element = background10;
                        genre9.element = it9.getGenres();
                        Unit unit18 = Unit.INSTANCE;
                    }
                    if (responseData == null) {
                    }
                    element2 = (Element) CollectionsKt.getOrNull(doc6.select("script:containsData(atob)"), 1);
                    if (element2 != null) {
                    }
                    throw new IllegalStateException("PlayerJS not found; only torrent links available".toString());
                }
                if (Result.isFailure-impl(obj7)) {
                    obj7 = null;
                }
                obj = coroutine_suspended;
                logoPath2 = descriptions7;
                tmdbId2 = tmdbId3;
                str7 = (String) obj7;
                description4 = description5;
                audioLanguages4 = audioLanguages6;
                imdbId4 = imdbId8;
                background4 = background5;
                tvtype3 = $result;
                descriptions5 = tmdbmetatype4;
                recommendation4 = recommendation5;
                year3 = year4;
                trailer5 = descriptions6;
                title5 = title6;
                poster5 = poster6;
                genre7 = genre8;
                doc4 = doc5;
                imdbId5 = url4;
                bgposter4 = bgposter5;
                creditsJson = str7;
                description6 = description4;
                background7 = background4;
                imdbId9 = imdbId4;
                credits = parseCredits(creditsJson);
                typeset = tvtype3 == TvType.TvSeries ? "series" : "movie";
                if (imdbId9 != null) {
                    if (StringsKt.isBlank(imdbId9)) {
                        str8 = imdbId9;
                    } else {
                        str8 = null;
                    }
                    if (str8 != null) {
                        it5 = str8;
                        Requests app15 = MainActivityKt.getApp();
                        String poster1110 = "https://v3-cinemeta.strem.io/meta/" + typeset + '/' + it5 + ".json";
                        c00023.L$0 = imdbId5;
                        c00023.L$1 = SpillingKt.nullOutSpilledVariable(savedLogin);
                        c00023.L$2 = SpillingKt.nullOutSpilledVariable(loginPart);
                        c00023.L$3 = SpillingKt.nullOutSpilledVariable(authCookie2);
                        c00023.L$4 = SpillingKt.nullOutSpilledVariable(cfCookies2);
                        c00023.L$5 = SpillingKt.nullOutSpilledVariable(map2);
                        c00023.L$6 = SpillingKt.nullOutSpilledVariable(page2);
                        c00023.L$7 = doc4;
                        c00023.L$8 = SpillingKt.nullOutSpilledVariable(ogTitle2);
                        c00023.L$9 = title5;
                        c00023.L$10 = poster5;
                        c00023.L$11 = bgposter4;
                        c00023.L$12 = trailer5;
                        c00023.L$13 = audioLanguages4;
                        c00023.L$14 = descriptions5;
                        c00023.L$15 = recommendation4;
                        c00023.L$16 = year3;
                        c00023.L$17 = tvtype3;
                        c00023.L$18 = SpillingKt.nullOutSpilledVariable(tmdbmetatype3);
                        c00023.L$19 = genre7;
                        c00023.L$20 = background7;
                        descriptions9 = imdbId5;
                        c00023.L$21 = description6;
                        c00023.L$22 = imdbId9;
                        c00023.L$23 = tmdbId2;
                        c00023.L$24 = logoPath2;
                        c00023.L$25 = SpillingKt.nullOutSpilledVariable(creditsJson);
                        c00023.L$26 = credits;
                        c00023.L$27 = SpillingKt.nullOutSpilledVariable(typeset);
                        c00023.L$28 = SpillingKt.nullOutSpilledVariable(it5);
                        c00023.label = 4;
                        bgposter7 = bgposter4;
                        audioLanguages8 = trailer5;
                        trailer8 = audioLanguages4;
                        tmdbId5 = tmdbId2;
                        C00021 c000211 = c00023;
                        recommendation7 = recommendation4;
                        year6 = year3;
                        genre10 = genre7;
                        background9 = background7;
                        logoPath4 = logoPath2;
                        Object obj115 = obj;
                        tvtype5 = tvtype3;
                        obj8 = obj115;
                        poster8 = poster5;
                        descriptions10 = descriptions5;
                        doc7 = doc4;
                        cinemacity = this;
                        obj9 = Requests.get$default(app15, poster1110, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000211, 4094, (Object) null);
                        c00023 = c000211;
                        if (obj9 == obj8) {
                            return obj8;
                        }
                        title8 = title5;
                        year7 = year6;
                        description8 = description6;
                        list2 = credits;
                        creditsJson2 = creditsJson;
                        logoPath5 = logoPath4;
                        castList = recommendation7;
                        imdbId11 = imdbId9;
                        typeset4 = typeset;
                        tmdbId6 = tmdbId5;
                        it6 = it5;
                        creditsJson3 = savedLogin;
                        genre11 = genre10;
                        loginPart3 = loginPart;
                        text = ((NiceResponse) obj9).getText();
                        Integer year111 = year7;
                        trailer6 = str5;
                        if (StringsKt.startsWith$default(text, trailer6, false, 2, (Object) null)) {
                            AppUtils appUtils8 = AppUtils.INSTANCE;
                            if (text == null) {
                                objDecodeFromString = null;
                            } else {
                                Result.Companion companion118 = Result.Companion;
                                KType kTypeTypeOf8 = Reflection.typeOf(ResponseData.class);
                                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                obj10 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf8));
                                if (Result.exceptionOrNull-impl(obj10) != null) {
                                    Result.Companion companion119 = Result.Companion;
                                    obj10 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(ResponseData.class), (List) null, 2, (Object) null));
                                    break;
                                }
                                if (Result.isFailure-impl(obj10)) {
                                    obj10 = null;
                                }
                                deserializationStrategy = (KSerializer) obj10;
                                if (deserializationStrategy != null) {
                                    value$iv$iv = text;
                                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv$iv);
                                } else {
                                    value$iv$iv = text;
                                }
                                ObjectMapper $this$readValue$iv$iv$iv10 = MainAPIKt.getMapper();
                                String content$iv$iv$iv10 = value$iv$iv;
                                objDecodeFromString = $this$readValue$iv$iv$iv10.readValue(content$iv$iv$iv10, new TypeReference<ResponseData>() { // from class: com.Cinemacity.Cinemacity$load$lambda$11$$inlined$tryParseJson$1
                                });
                            }
                            responseData2 = (ResponseData) objDecodeFromString;
                        } else {
                            responseData2 = null;
                        }
                        year5 = year111;
                        responseData = responseData2;
                        typeset2 = typeset4;
                        logoPath3 = logoPath5;
                        description7 = description8;
                        tmdbId4 = tmdbId6;
                        imdbId10 = imdbId11;
                        list = list2;
                        genre9 = genre11;
                        recommendation6 = castList;
                        savedLogin = creditsJson3;
                        descriptions8 = descriptions10;
                        doc6 = doc7;
                        typeset3 = descriptions9;
                        trailer7 = audioLanguages8;
                        audioLanguages7 = trailer8;
                        tvtype4 = tvtype5;
                        bgposter6 = bgposter7;
                        poster7 = poster8;
                        background8 = background9;
                        break;
                    }
                    if (responseData != null) {
                        description9 = it9.getDescription();
                        if (description9 == null) {
                            description9 = descriptions8;
                        }
                        description7.element = description9;
                        background10 = it9.getBackground();
                        if (background10 == null) {
                            background10 = poster7;
                        }
                        background8.element = background10;
                        genre9.element = it9.getGenres();
                        Unit unit19 = Unit.INSTANCE;
                    }
                    if (responseData == null) {
                    }
                    element2 = (Element) CollectionsKt.getOrNull(doc6.select("script:containsData(atob)"), 1);
                    if (element2 != null) {
                    }
                    throw new IllegalStateException("PlayerJS not found; only torrent links available".toString());
                }
                Object obj116 = obj;
                TvType tvtype18 = tvtype3;
                obj8 = obj116;
                String url111 = imdbId5;
                Document doc17 = doc4;
                typeset2 = typeset;
                String poster1111 = poster5;
                String bgposter113 = bgposter4;
                String trailer111 = trailer5;
                cinemacity = this;
                trailer6 = str5;
                description7 = description6;
                list = credits;
                year5 = year3;
                genre9 = genre7;
                creditsJson2 = creditsJson;
                logoPath3 = logoPath2;
                recommendation6 = recommendation4;
                imdbId10 = imdbId9;
                tmdbId4 = tmdbId2;
                responseData = null;
                title8 = title5;
                loginPart3 = loginPart;
                descriptions8 = descriptions5;
                doc6 = doc17;
                typeset3 = url111;
                trailer7 = trailer111;
                audioLanguages7 = audioLanguages4;
                bgposter6 = bgposter113;
                poster7 = poster1111;
                background8 = background7;
                tvtype4 = tvtype18;
                if (responseData != null) {
                    description9 = it9.getDescription();
                    if (description9 == null) {
                        description9 = descriptions8;
                    }
                    description7.element = description9;
                    background10 = it9.getBackground();
                    if (background10 == null) {
                        background10 = poster7;
                    }
                    background8.element = background10;
                    genre9.element = it9.getGenres();
                    Unit unit110 = Unit.INSTANCE;
                }
                if (responseData == null) {
                }
                element2 = (Element) CollectionsKt.getOrNull(doc6.select("script:containsData(atob)"), 1);
                if (element2 != null) {
                }
                throw new IllegalStateException("PlayerJS not found; only torrent links available".toString());
            case 4:
                it6 = (String) c00023.L$28;
                typeset4 = (String) c00023.L$27;
                list2 = (List) c00023.L$26;
                creditsJson2 = (String) c00023.L$25;
                logoPath5 = (String) c00023.L$24;
                tmdbId6 = (String) c00023.L$23;
                imdbId11 = (String) c00023.L$22;
                description8 = (Ref.ObjectRef) c00023.L$21;
                Ref.ObjectRef background11 = (Ref.ObjectRef) c00023.L$20;
                genre11 = (Ref.ObjectRef) c00023.L$19;
                String tmdbmetatype6 = (String) c00023.L$18;
                TvType tvtype19 = (TvType) c00023.L$17;
                Integer year21 = (Integer) c00023.L$16;
                castList = (List) c00023.L$15;
                String descriptions13 = (String) c00023.L$14;
                String audioLanguages19 = (String) c00023.L$13;
                String trailer21 = (String) c00023.L$12;
                String bgposter21 = (String) c00023.L$11;
                String poster22 = (String) c00023.L$10;
                title8 = (String) c00023.L$9;
                String ogTitle7 = (String) c00023.L$8;
                Document doc18 = (Document) c00023.L$7;
                NiceResponse page4 = (NiceResponse) c00023.L$6;
                Map<String, String> map5 = (Map) c00023.L$5;
                String authCookie6 = (String) c00023.L$4;
                String cfCookies6 = (String) c00023.L$3;
                loginPart3 = (String) c00023.L$2;
                creditsJson3 = (String) c00023.L$1;
                String url20 = (String) c00023.L$0;
                ResultKt.throwOnFailure($result3);
                trailer8 = audioLanguages19;
                audioLanguages8 = trailer21;
                cfCookies2 = authCookie6;
                authCookie2 = cfCookies6;
                obj8 = coroutine_suspended;
                str5 = "{";
                str4 = "";
                background9 = background11;
                tmdbmetatype3 = tmdbmetatype6;
                bgposter7 = bgposter21;
                poster8 = poster22;
                ogTitle2 = ogTitle7;
                obj9 = $result3;
                tvtype5 = tvtype19;
                year7 = year21;
                descriptions10 = descriptions13;
                doc7 = doc18;
                page2 = page4;
                map2 = map5;
                descriptions9 = url20;
                text = ((NiceResponse) obj9).getText();
                Integer year112 = year7;
                trailer6 = str5;
                if (StringsKt.startsWith$default(text, trailer6, false, 2, (Object) null)) {
                    AppUtils appUtils9 = AppUtils.INSTANCE;
                    if (text == null) {
                        objDecodeFromString = null;
                    } else {
                        Result.Companion companion1110 = Result.Companion;
                        KType kTypeTypeOf9 = Reflection.typeOf(ResponseData.class);
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                        obj10 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf9));
                        if (Result.exceptionOrNull-impl(obj10) != null) {
                            Result.Companion companion1111 = Result.Companion;
                            obj10 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(ResponseData.class), (List) null, 2, (Object) null));
                            break;
                        }
                        if (Result.isFailure-impl(obj10)) {
                            obj10 = null;
                        }
                        deserializationStrategy = (KSerializer) obj10;
                        if (deserializationStrategy != null) {
                            value$iv$iv = text;
                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv$iv);
                        } else {
                            value$iv$iv = text;
                        }
                        ObjectMapper $this$readValue$iv$iv$iv11 = MainAPIKt.getMapper();
                        String content$iv$iv$iv11 = value$iv$iv;
                        objDecodeFromString = $this$readValue$iv$iv$iv11.readValue(content$iv$iv$iv11, new TypeReference<ResponseData>() { // from class: com.Cinemacity.Cinemacity$load$lambda$11$$inlined$tryParseJson$1
                        });
                    }
                    responseData2 = (ResponseData) objDecodeFromString;
                    break;
                } else {
                    responseData2 = null;
                }
                year5 = year112;
                responseData = responseData2;
                typeset2 = typeset4;
                logoPath3 = logoPath5;
                description7 = description8;
                tmdbId4 = tmdbId6;
                imdbId10 = imdbId11;
                list = list2;
                genre9 = genre11;
                recommendation6 = castList;
                savedLogin = creditsJson3;
                descriptions8 = descriptions10;
                doc6 = doc7;
                typeset3 = descriptions9;
                trailer7 = audioLanguages8;
                audioLanguages7 = trailer8;
                tvtype4 = tvtype5;
                bgposter6 = bgposter7;
                poster7 = poster8;
                background8 = background9;
                if (responseData != null) {
                    description9 = it9.getDescription();
                    if (description9 == null) {
                        description9 = descriptions8;
                    }
                    description7.element = description9;
                    background10 = it9.getBackground();
                    if (background10 == null) {
                        background10 = poster7;
                    }
                    background8.element = background10;
                    genre9.element = it9.getGenres();
                    Unit unit111 = Unit.INSTANCE;
                }
                if (responseData == null) {
                }
                element2 = (Element) CollectionsKt.getOrNull(doc6.select("script:containsData(atob)"), 1);
                if (element2 != null) {
                }
                throw new IllegalStateException("PlayerJS not found; only torrent links available".toString());
            case 5:
                Object obj20 = c00023.L$33;
                ResultKt.throwOnFailure($result3);
                return $result3;
            case 6:
                Object obj21 = c00023.L$33;
                ResultKt.throwOnFailure($result3);
                return $result3;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$4$0(String $posterUrl, String $score, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($posterUrl);
        $this$newMovieSearchResponse.setScore(Score.Companion.from10($score));
        return Unit.INSTANCE;
    }

    static final Unit load$lambda$24(int $seasonNumber, int $episodeNumber, ResponseData.Meta.EpisodeDetails $epMeta, Episode $this$newEpisode) {
        String string;
        $this$newEpisode.setSeason(Integer.valueOf($seasonNumber));
        $this$newEpisode.setEpisode(Integer.valueOf($episodeNumber));
        if ($epMeta == null || (string = $epMeta.getName()) == null) {
            string = new StringBuilder().append('S').append($seasonNumber).append('E').append($episodeNumber).toString();
        }
        $this$newEpisode.setName(string);
        $this$newEpisode.setDescription($epMeta != null ? $epMeta.getOverview() : null);
        $this$newEpisode.setPosterUrl($epMeta != null ? $epMeta.getThumbnail() : null);
        MainAPIKt.addDate$default($this$newEpisode, $epMeta != null ? $epMeta.getReleased() : null, (String) null, 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.Cinemacity.Cinemacity$load$7 */
    /* JADX INFO: compiled from: Cinemacity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Cinemacity.Cinemacity$load$7", f = "Cinemacity.kt", i = {0}, l = {592}, m = "invokeSuspend", n = {"$this$newTvSeriesLoadResponse"}, nl = {593}, s = {"L$0"}, v = 2)
    static final class C00037 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $audioLanguages;
        final /* synthetic */ Ref.ObjectRef<String> $background;
        final /* synthetic */ String $bgposter;
        final /* synthetic */ List<ActorData> $castList;
        final /* synthetic */ Ref.ObjectRef<String> $description;
        final /* synthetic */ String $descriptions;
        final /* synthetic */ Ref.ObjectRef<List<String>> $genre;
        final /* synthetic */ String $imdbId;
        final /* synthetic */ String $logoPath;
        final /* synthetic */ String $poster;
        final /* synthetic */ List<MovieSearchResponse> $recommendation;
        final /* synthetic */ ResponseData $responseData;
        final /* synthetic */ String $tmdbId;
        final /* synthetic */ String $trailer;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00037(Ref.ObjectRef<String> objectRef, String str, String str2, String str3, Integer num, ResponseData responseData, List<MovieSearchResponse> list, Ref.ObjectRef<List<String>> objectRef2, List<ActorData> list2, String str4, String str5, String str6, Ref.ObjectRef<String> objectRef3, String str7, String str8, Continuation<? super C00037> continuation) {
            super(2, continuation);
            this.$background = objectRef;
            this.$bgposter = str;
            this.$poster = str2;
            this.$logoPath = str3;
            this.$year = num;
            this.$responseData = responseData;
            this.$recommendation = list;
            this.$genre = objectRef2;
            this.$castList = list2;
            this.$imdbId = str4;
            this.$tmdbId = str5;
            this.$trailer = str6;
            this.$description = objectRef3;
            this.$descriptions = str7;
            this.$audioLanguages = str8;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00037 = new C00037(this.$background, this.$bgposter, this.$poster, this.$logoPath, this.$year, this.$responseData, this.$recommendation, this.$genre, this.$castList, this.$imdbId, this.$tmdbId, this.$trailer, this.$description, this.$descriptions, this.$audioLanguages, continuation);
            c00037.L$0 = obj;
            return c00037;
        }

        public final Object invoke(TvSeriesLoadResponse tvSeriesLoadResponse, Continuation<? super Unit> continuation) {
            return create(tvSeriesLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            ResponseData.Meta meta;
            ResponseData.Meta.AppExtras app_extras;
            ResponseData.Meta meta2;
            ResponseData.Meta meta3;
            String year;
            LoadResponse loadResponse = (TvSeriesLoadResponse) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String str = (String) this.$background.element;
                    if (str == null) {
                        str = this.$bgposter;
                    }
                    loadResponse.setBackgroundPosterUrl(str);
                    loadResponse.setPosterUrl(this.$poster);
                    loadResponse.setPosterHeaders(Cinemacity.INSTANCE.getCfHeaders());
                    try {
                        loadResponse.setLogoUrl(this.$logoPath);
                        break;
                    } catch (Throwable th) {
                    }
                    Integer intOrNull = this.$year;
                    String certification = null;
                    if (intOrNull == null) {
                        ResponseData responseData = this.$responseData;
                        intOrNull = (responseData == null || (meta3 = responseData.getMeta()) == null || (year = meta3.getYear()) == null) ? null : StringsKt.toIntOrNull(year);
                    }
                    loadResponse.setYear(intOrNull);
                    Ref.ObjectRef<String> objectRef = this.$description;
                    String str2 = this.$descriptions;
                    String str3 = this.$audioLanguages;
                    StringBuilder $this$invokeSuspend_u24lambda_u240 = new StringBuilder();
                    String str4 = (String) objectRef.element;
                    if (str4 != null) {
                        str2 = str4;
                    }
                    $this$invokeSuspend_u24lambda_u240.append(str2);
                    String str5 = str3;
                    if (!(str5 == null || StringsKt.isBlank(str5))) {
                        $this$invokeSuspend_u24lambda_u240.append(" - Audio: ");
                        $this$invokeSuspend_u24lambda_u240.append(str3);
                    }
                    loadResponse.setPlot($this$invokeSuspend_u24lambda_u240.toString());
                    loadResponse.setRecommendations(this.$recommendation);
                    loadResponse.setTags((List) this.$genre.element);
                    loadResponse.setActors(this.$castList);
                    Score.Companion companion = Score.Companion;
                    ResponseData responseData2 = this.$responseData;
                    loadResponse.setScore(companion.from10((responseData2 == null || (meta2 = responseData2.getMeta()) == null) ? null : meta2.getImdbRating()));
                    ResponseData responseData3 = this.$responseData;
                    if (responseData3 != null && (meta = responseData3.getMeta()) != null && (app_extras = meta.getApp_extras()) != null) {
                        certification = app_extras.getCertification();
                    }
                    loadResponse.setContentRating(certification);
                    LoadResponse.Companion.addImdbId(loadResponse, this.$imdbId);
                    LoadResponse.Companion.addTMDbId(loadResponse, this.$tmdbId);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(loadResponse);
                    this.label = 1;
                    if (LoadResponse.Companion.addTrailer$default(LoadResponse.Companion, loadResponse, this.$trailer, (String) null, false, (Continuation) this, 6, (Object) null) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.Cinemacity.Cinemacity$load$8 */
    /* JADX INFO: compiled from: Cinemacity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Cinemacity.Cinemacity$load$8", f = "Cinemacity.kt", i = {0}, l = {623}, m = "invokeSuspend", n = {"$this$newMovieLoadResponse"}, nl = {624}, s = {"L$0"}, v = 2)
    static final class C00048 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $audioLanguages;
        final /* synthetic */ Ref.ObjectRef<String> $background;
        final /* synthetic */ String $bgposter;
        final /* synthetic */ List<ActorData> $castList;
        final /* synthetic */ Ref.ObjectRef<String> $description;
        final /* synthetic */ String $descriptions;
        final /* synthetic */ Ref.ObjectRef<List<String>> $genre;
        final /* synthetic */ String $imdbId;
        final /* synthetic */ String $logoPath;
        final /* synthetic */ String $poster;
        final /* synthetic */ List<MovieSearchResponse> $recommendation;
        final /* synthetic */ ResponseData $responseData;
        final /* synthetic */ String $tmdbId;
        final /* synthetic */ String $trailer;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00048(Ref.ObjectRef<String> objectRef, String str, String str2, String str3, Integer num, ResponseData responseData, List<MovieSearchResponse> list, Ref.ObjectRef<List<String>> objectRef2, List<ActorData> list2, String str4, String str5, String str6, Ref.ObjectRef<String> objectRef3, String str7, String str8, Continuation<? super C00048> continuation) {
            super(2, continuation);
            this.$background = objectRef;
            this.$bgposter = str;
            this.$poster = str2;
            this.$logoPath = str3;
            this.$year = num;
            this.$responseData = responseData;
            this.$recommendation = list;
            this.$genre = objectRef2;
            this.$castList = list2;
            this.$imdbId = str4;
            this.$tmdbId = str5;
            this.$trailer = str6;
            this.$description = objectRef3;
            this.$descriptions = str7;
            this.$audioLanguages = str8;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00048 = new C00048(this.$background, this.$bgposter, this.$poster, this.$logoPath, this.$year, this.$responseData, this.$recommendation, this.$genre, this.$castList, this.$imdbId, this.$tmdbId, this.$trailer, this.$description, this.$descriptions, this.$audioLanguages, continuation);
            c00048.L$0 = obj;
            return c00048;
        }

        public final Object invoke(MovieLoadResponse movieLoadResponse, Continuation<? super Unit> continuation) {
            return create(movieLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            ResponseData.Meta meta;
            ResponseData.Meta meta2;
            ResponseData.Meta.AppExtras app_extras;
            ResponseData.Meta meta3;
            String year;
            LoadResponse loadResponse = (MovieLoadResponse) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String str = (String) this.$background.element;
                    if (str == null) {
                        str = this.$bgposter;
                    }
                    loadResponse.setBackgroundPosterUrl(str);
                    loadResponse.setPosterUrl(this.$poster);
                    loadResponse.setPosterHeaders(Cinemacity.INSTANCE.getCfHeaders());
                    try {
                        loadResponse.setLogoUrl(this.$logoPath);
                        break;
                    } catch (Throwable th) {
                    }
                    Integer intOrNull = this.$year;
                    String imdbRating = null;
                    if (intOrNull == null) {
                        ResponseData responseData = this.$responseData;
                        intOrNull = (responseData == null || (meta3 = responseData.getMeta()) == null || (year = meta3.getYear()) == null) ? null : StringsKt.toIntOrNull(year);
                    }
                    loadResponse.setYear(intOrNull);
                    Ref.ObjectRef<String> objectRef = this.$description;
                    String str2 = this.$descriptions;
                    String str3 = this.$audioLanguages;
                    StringBuilder $this$invokeSuspend_u24lambda_u240 = new StringBuilder();
                    String str4 = (String) objectRef.element;
                    if (str4 != null) {
                        str2 = str4;
                    }
                    $this$invokeSuspend_u24lambda_u240.append(str2);
                    String str5 = str3;
                    if (!(str5 == null || StringsKt.isBlank(str5))) {
                        $this$invokeSuspend_u24lambda_u240.append(" - Audio: ");
                        $this$invokeSuspend_u24lambda_u240.append(str3);
                    }
                    loadResponse.setPlot($this$invokeSuspend_u24lambda_u240.toString());
                    loadResponse.setRecommendations(this.$recommendation);
                    loadResponse.setTags((List) this.$genre.element);
                    loadResponse.setActors(this.$castList);
                    ResponseData responseData2 = this.$responseData;
                    loadResponse.setContentRating((responseData2 == null || (meta2 = responseData2.getMeta()) == null || (app_extras = meta2.getApp_extras()) == null) ? null : app_extras.getCertification());
                    Score.Companion companion = Score.Companion;
                    ResponseData responseData3 = this.$responseData;
                    if (responseData3 != null && (meta = responseData3.getMeta()) != null) {
                        imdbRating = meta.getImdbRating();
                    }
                    loadResponse.setScore(companion.from10(imdbRating));
                    LoadResponse.Companion.addImdbId(loadResponse, this.$imdbId);
                    LoadResponse.Companion.addTMDbId(loadResponse, this.$tmdbId);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(loadResponse);
                    this.label = 1;
                    if (LoadResponse.Companion.addTrailer$default(LoadResponse.Companion, loadResponse, this.$trailer, (String) null, false, (Continuation) this, 6, (Object) null) == coroutine_suspended) {
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

    /* JADX WARN: Code duplicated, block: B:19:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:21:0x0240 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:22:0x0241  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0241 -> B:23:0x024b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x0482 -> B:74:0x04c7). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:85:0x061e -> B:86:0x064a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object loadLinks(@org.jetbrains.annotations.NotNull java.lang.String r48, boolean r49, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r50, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r51, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r52) {
        /*
            Method dump skipped, instruction units count: 1782
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.Cinemacity.Cinemacity.loadLinks(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final int extractQuality(@NotNull String url) {
        if (StringsKt.contains$default(url, "2160p", false, 2, (Object) null)) {
            return Qualities.P2160.getValue();
        }
        if (StringsKt.contains$default(url, "1440p", false, 2, (Object) null)) {
            return Qualities.P1440.getValue();
        }
        if (StringsKt.contains$default(url, "1080p", false, 2, (Object) null)) {
            return Qualities.P1080.getValue();
        }
        if (StringsKt.contains$default(url, "720p", false, 2, (Object) null)) {
            return Qualities.P720.getValue();
        }
        if (StringsKt.contains$default(url, "480p", false, 2, (Object) null)) {
            return Qualities.P480.getValue();
        }
        return StringsKt.contains$default(url, "360p", false, 2, (Object) null) ? Qualities.P360.getValue() : Qualities.Unknown.getValue();
    }

    @NotNull
    public final JSONArray parseSubtitles(@Nullable String raw) throws JSONException {
        JSONArray tracks = new JSONArray();
        String str = raw;
        if (str == null || StringsKt.isBlank(str)) {
            return tracks;
        }
        Iterable $this$forEach$iv = StringsKt.split$default(raw, new String[]{","}, false, 0, 6, (Object) null);
        for (Object element$iv : $this$forEach$iv) {
            String entry = (String) element$iv;
            MatchResult match = Regex.find$default(new Regex("\\[(.+?)](https?://.+)"), StringsKt.trim(entry).toString(), 0, 2, (Object) null);
            if (match != null) {
                JSONObject $this$parseSubtitles_u24lambda_u240_u240 = new JSONObject();
                $this$parseSubtitles_u24lambda_u240_u240.put("language", match.getGroupValues().get(1));
                $this$parseSubtitles_u24lambda_u240_u240.put("subtitleUrl", match.getGroupValues().get(2));
                tracks.put($this$parseSubtitles_u24lambda_u240_u240);
            }
        }
        return tracks;
    }

    public static /* synthetic */ List buildDownloadLinks$default(Cinemacity cinemacity, String str, JSONArray jSONArray, int i, String str2, Integer num, Integer num2, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            num = null;
        }
        if ((i2 & 32) != 0) {
            num2 = null;
        }
        return cinemacity.buildDownloadLinks(str, jSONArray, i, str2, num, num2);
    }

    @NotNull
    public final List<Triple<String, Integer, String>> buildDownloadLinks(@NotNull String base, @Nullable JSONArray subtitles, int selectedAudioIndex, @NotNull String title, @Nullable Integer season, @Nullable Integer episode) {
        String audio;
        String e;
        String dlName;
        Iterable $this$map$iv = StringsKt.split$default(base, new String[]{","}, false, 0, 6, (Object) null);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            String it = (String) item$iv$iv;
            destination$iv$iv.add(StringsKt.trim(it).toString());
        }
        List parts = (List) destination$iv$iv;
        List $this$filter$iv = parts;
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            String it2 = (String) element$iv$iv;
            if (StringsKt.endsWith$default(it2, ".mp4", false, 2, (Object) null)) {
                destination$iv$iv2.add(element$iv$iv);
            }
        }
        List<String> videoFiles = (List) destination$iv$iv2;
        List $this$filter$iv2 = parts;
        Collection destination$iv$iv3 = new ArrayList();
        for (Object element$iv$iv2 : $this$filter$iv2) {
            String it3 = (String) element$iv$iv2;
            if (StringsKt.endsWith$default(it3, ".m4a", false, 2, (Object) null)) {
                destination$iv$iv3.add(element$iv$iv2);
            }
        }
        List audioFiles = (List) destination$iv$iv3;
        if (!audioFiles.isEmpty() && (audio = (String) CollectionsKt.getOrNull(audioFiles, selectedAudioIndex)) != null) {
            String baseUrl = CollectionsKt.joinToString$default(parts, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
            String langRaw = StringsKt.substringBefore$default(StringsKt.substringAfterLast$default(audio, "_", (String) null, 2, (Object) null), ".m4a", (String) null, 2, (Object) null);
            String strReplace$default = StringsKt.replace$default(langRaw, "-", " ", false, 4, (Object) null);
            if (strReplace$default.length() > 0) {
                StringBuilder sb = new StringBuilder();
                char it4 = strReplace$default.charAt(0);
                String strValueOf = String.valueOf(it4);
                Intrinsics.checkNotNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
                String upperCase = strValueOf.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                StringBuilder sbAppend = sb.append((Object) upperCase);
                String strSubstring = strReplace$default.substring(1);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                strReplace$default = sbAppend.append(strSubstring).toString();
            }
            String lang = strReplace$default;
            List results = new ArrayList();
            for (String video : videoFiles) {
                int quality = extractQuality(video);
                String res = StringsKt.substringBefore$default(StringsKt.substringAfterLast$default(video, "_", (String) null, 2, (Object) null), ".mp4", (String) null, 2, (Object) null);
                if (season != null && episode != null) {
                    String s = StringsKt.padStart(String.valueOf(season.intValue()), 2, '0');
                    String e2 = StringsKt.padStart(String.valueOf(episode.intValue()), 2, '0');
                    StringBuilder sbAppend2 = new StringBuilder().append(buildDownloadLinks$cleanTitle(title)).append(".S").append(s).append('E').append(e2).append('.').append(res).append('.');
                    e = video;
                    dlName = sbAppend2.append(StringsKt.replace$default(lang, " ", ".", false, 4, (Object) null)).toString();
                } else {
                    e = video;
                    dlName = buildDownloadLinks$cleanTitle(title) + ".WEB-DL." + res + '.' + StringsKt.replace$default(lang, " ", ".", false, 4, (Object) null);
                }
                String subs = buildDownloadLinks$filterSubs(subtitles, e);
                String baseUrl2 = baseUrl;
                String audio2 = audio;
                String finalUrl = makeDownloadHref(baseUrl2, e, audio2, subs, dlName);
                results.add(new Triple(finalUrl, Integer.valueOf(quality), lang));
                baseUrl = baseUrl2;
                audio = audio2;
                parts = parts;
            }
            return results;
        }
        return CollectionsKt.emptyList();
    }

    private static final String buildDownloadLinks$normalizeSubtitle(String url) {
        int idx = StringsKt.indexOf$default(url, "/public_files/", 0, false, 6, (Object) null);
        if (idx == -1) {
            return null;
        }
        String strSubstring = url.substring("/public_files/".length() + idx);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    private static final String buildDownloadLinks$filterSubs(JSONArray $subtitles, String video) {
        String it;
        String baseName = StringsKt.substringBefore$default(StringsKt.substringBefore$default(StringsKt.substringAfterLast$default(video, "/", (String) null, 2, (Object) null), "_web-dl", (String) null, 2, (Object) null), "_202", (String) null, 2, (Object) null);
        if ($subtitles != null) {
            Iterable $this$mapNotNull$iv = RangesKt.until(0, $subtitles.length());
            Collection destination$iv$iv = new ArrayList();
            IntIterator it2 = $this$mapNotNull$iv.iterator();
            while (it2.hasNext()) {
                int element$iv$iv$iv = it2.nextInt();
                JSONObject jSONObjectOptJSONObject = $subtitles.optJSONObject(element$iv$iv$iv);
                String it3 = (jSONObjectOptJSONObject == null || (it = jSONObjectOptJSONObject.optString("subtitleUrl")) == null) ? null : buildDownloadLinks$normalizeSubtitle(it);
                if (it3 != null) {
                    destination$iv$iv.add(it3);
                }
            }
            Iterable $this$filter$iv = (List) destination$iv$iv;
            Collection destination$iv$iv2 = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                String baseName2 = baseName;
                Iterable $this$filter$iv2 = $this$filter$iv;
                if (StringsKt.contains$default((String) element$iv$iv, baseName, false, 2, (Object) null)) {
                    destination$iv$iv2.add(element$iv$iv);
                }
                baseName = baseName2;
                $this$filter$iv = $this$filter$iv2;
            }
            String strJoinToString$default = CollectionsKt.joinToString$default(CollectionsKt.distinct((List) destination$iv$iv2), ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
            if (strJoinToString$default != null) {
                return strJoinToString$default;
            }
        }
        return "";
    }

    private static final String buildDownloadLinks$cleanTitle(String input) {
        return StringsKt.trim(new Regex("\\.+").replace(new Regex("[\\s_]+").replace(new Regex("[^0-9A-Za-z\\s._-]").replace(input, ""), "."), "."), new char[]{'.'});
    }

    @NotNull
    public final String makeDownloadHref(@NotNull String base, @NotNull String videoPath, @NotNull String audioPath, @Nullable String subtitlePaths, @NotNull String name) {
        StringBuilder $this$makeDownloadHref_u24lambda_u240 = new StringBuilder();
        $this$makeDownloadHref_u24lambda_u240.append("?action=download");
        $this$makeDownloadHref_u24lambda_u240.append("&video=" + CodecsKt.encodeURLQueryComponent$default(videoPath, false, false, (Charset) null, 7, (Object) null));
        $this$makeDownloadHref_u24lambda_u240.append("&audio=" + CodecsKt.encodeURLQueryComponent$default(audioPath, false, false, (Charset) null, 7, (Object) null));
        if (subtitlePaths != null) {
            if (subtitlePaths.length() > 0) {
                $this$makeDownloadHref_u24lambda_u240.append("&subtitle=" + CodecsKt.encodeURLQueryComponent$default(subtitlePaths, false, false, (Charset) null, 7, (Object) null));
            }
            $this$makeDownloadHref_u24lambda_u240.append("&name=" + CodecsKt.encodeURLQueryComponent$default(name, false, false, (Charset) null, 7, (Object) null));
        }
        String qs = $this$makeDownloadHref_u24lambda_u240.toString();
        return base + qs;
    }
}
