package com.Kartoons;

import com.lagradost.api.Log;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.ErrorLoadingException;
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
import com.lagradost.cloudstream3.Score;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Kartoons.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Kartoons/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 W2\u00020\u0001:\u0001WB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J,\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00032\u0014\b\u0002\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030!H\u0082@¢\u0006\u0002\u0010\"J\u0018\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&H\u0002J\u0018\u0010'\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020&H\u0002J\b\u00100\u001a\u000201H\u0002J\u001e\u0010.\u001a\u0002022\u0006\u00103\u001a\u00020&2\u0006\u00104\u001a\u000205H\u0096@¢\u0006\u0002\u00106J\f\u00107\u001a\u000208*\u000209H\u0002J\u001c\u0010:\u001a\b\u0012\u0004\u0012\u0002080,2\u0006\u0010;\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010<J\u001c\u0010=\u001a\b\u0012\u0004\u0012\u0002080,2\u0006\u0010;\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010<J\u0016\u0010>\u001a\u00020?2\u0006\u0010\u001f\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010<JF\u0010@\u001a\u00020\u000e2\u0006\u0010A\u001a\u00020\u00032\u0006\u0010B\u001a\u00020\u000e2\u0012\u0010C\u001a\u000e\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u0002010D2\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u0002010DH\u0096@¢\u0006\u0002\u0010HJ\u0010\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020GH\u0016J$\u0010R\u001a\b\u0012\u0004\u0012\u00020S0,2\u0006\u0010T\u001a\u00020U2\u0006\u0010\u0006\u001a\u00020\u0003H\u0082@¢\u0006\u0002\u0010VR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0005R\u001a\u0010\n\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\u0005R\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\u0005R\u0014\u0010\u0014\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0014\u0010\u0016\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u001b\u0010I\u001a\u00020J8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bK\u0010L¨\u0006X"}, d2 = {"Lcom/Kartoons/Kartoons;", "Lcom/lagradost/cloudstream3/MainAPI;", "authToken", "", "<init>", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasDownloadSupport", "getHasDownloadSupport", "hasQuickSearch", "getHasQuickSearch", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "appGet", "Lcom/lagradost/nicehttp/NiceResponse;", "url", "extraHeaders", "", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "solvePow", "nonce", "requiredBits", "", "hasLeadingZeroBits", "bytes", "", "bits", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "checkAuth", "", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lcom/Kartoons/Data;", "quickSearch", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ENC_LINE_REGEX", "Lkotlin/text/Regex;", "getENC_LINE_REGEX", "()Lkotlin/text/Regex;", "ENC_LINE_REGEX$delegate", "Lkotlin/Lazy;", "getVideoInterceptor", "Lokhttp3/Interceptor;", "extractorLink", "fetchSeasonDetailsForShow", "Lcom/Kartoons/SeasonEpisodes;", "showData", "Lcom/Kartoons/LoadData;", "(Lcom/Kartoons/LoadData;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "Kartoons"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nKartoons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Kartoons.kt\ncom/Kartoons/Kartoons\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 3 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,527:1\n73#2,5:528\n68#2:544\n104#2,5:549\n104#2,5:558\n73#2,5:571\n117#3,10:533\n1#4:543\n1739#5:545\n1814#5,3:546\n1739#5:554\n1814#5,3:555\n1739#5:563\n1814#5,3:564\n2068#5:567\n2068#5,2:568\n2069#5:570\n2068#5,2:576\n*S KotlinDebug\n*F\n+ 1 Kartoons.kt\ncom/Kartoons/Kartoons\n*L\n153#1:528,5\n228#1:544\n253#1:549,5\n264#1:558,5\n340#1:571,5\n169#1:533,10\n229#1:545\n229#1:546,3\n253#1:554\n253#1:555,3\n282#1:563\n282#1:564,3\n294#1:567\n297#1:568,2\n294#1:570\n341#1:576,2\n*E\n"})
public final class Kartoons extends MainAPI {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Mutex cfBypassMutex = MutexKt.Mutex$default(false, 1, (Object) null);

    @Nullable
    private static String challengeToken;

    @Nullable
    private static String cookie;

    @Nullable
    private static String userAgent;

    @Nullable
    private final String authToken;
    private final boolean hasDownloadSupport;

    @NotNull
    private String mainUrl = "https://api.kartoons.me";

    @NotNull
    private String name = "Kartoons";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "hi";
    private final boolean hasQuickSearch = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.Anime, TvType.Cartoon});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("api/shows", "Shows"), TuplesKt.to("api/movies", "Movies"), TuplesKt.to("api/popularity/shows?limit=15&period=day", "Popular Shows"), TuplesKt.to("api/popularity/movies?limit=15&period=day", "Popular Movies")});

    /* JADX INFO: renamed from: ENC_LINE_REGEX$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy ENC_LINE_REGEX = LazyKt.lazy(new Function0() { // from class: com.Kartoons.Kartoons$$ExternalSyntheticLambda6
        public final Object invoke() {
            return Kartoons.ENC_LINE_REGEX_delegate$lambda$0();
        }
    });

    /* JADX INFO: renamed from: com.Kartoons.Kartoons$appGet$1 */
    /* JADX INFO: compiled from: Kartoons.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Kartoons.Kartoons", f = "Kartoons.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6}, l = {141, 153, 161, 537, 170, 174, 179}, m = "appGet", n = {"url", "extraHeaders", "baseHeaders", "mergedHeaders", "url", "extraHeaders", "baseHeaders", "mergedHeaders", "rawResponse", "contentParam", "powUrl", "url", "extraHeaders", "baseHeaders", "mergedHeaders", "rawResponse", "contentParam", "powUrl", "powRes", "pData", "solution", "powHeaders", "url", "extraHeaders", "baseHeaders", "mergedHeaders", "rawResponse", "recheckPassed", "$this$withLock_u24default$iv", "url", "extraHeaders", "baseHeaders", "mergedHeaders", "rawResponse", "recheckPassed", "$this$withLock_u24default$iv", "url", "extraHeaders", "baseHeaders", "mergedHeaders", "rawResponse", "recheckPassed", "$this$withLock_u24default$iv", "recheck", "url", "extraHeaders", "baseHeaders", "mergedHeaders", "rawResponse", "recheckPassed"}, nl = {144, 528, 166, 538, 171, 176, -1}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 2)
    static final class C00021 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
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
            return Kartoons.this.appGet(null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Kartoons.Kartoons$getMainPage$1 */
    /* JADX INFO: compiled from: Kartoons.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Kartoons.Kartoons", f = "Kartoons.kt", i = {0, 0}, l = {228}, m = "getMainPage", n = {"request", "page"}, nl = {528}, s = {"L$0", "I$0"}, v = 2)
    static final class C00041 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00041(Continuation<? super C00041> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Kartoons.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Kartoons.Kartoons$load$1 */
    /* JADX INFO: compiled from: Kartoons.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Kartoons.Kartoons", f = "Kartoons.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {264, 290, 311, 321}, m = "load", n = {"url", "url", "json", "res", "title", "description", "poster", "backgroundPoster", "startYear", "rating", "tags", "href", "tvtag", "recommendations", "url", "json", "res", "title", "description", "poster", "backgroundPoster", "startYear", "rating", "tags", "href", "tvtag", "recommendations", "allSeasonDetails", "episodesList", "url", "json", "res", "title", "description", "poster", "backgroundPoster", "startYear", "rating", "tags", "href", "tvtag", "recommendations"}, nl = {528, 292, 321, 289}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12"}, v = 2)
    static final class C00051 extends ContinuationImpl {
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

        C00051(Continuation<? super C00051> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Kartoons.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Kartoons.Kartoons$loadLinks$1 */
    /* JADX INFO: compiled from: Kartoons.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Kartoons.Kartoons", f = "Kartoons.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {340, 353}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "isCasting", "data", "subtitleCallback", "callback", "res", "$this$forEach$iv", "element$iv", "link", "m3u8", "encoded", "isCasting"}, nl = {528, 352}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$7", "L$8", "L$9", "Z$0"}, v = 2)
    static final class C00081 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
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

        C00081(Continuation<? super C00081> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Kartoons.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Kartoons.Kartoons$search$1 */
    /* JADX INFO: compiled from: Kartoons.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Kartoons.Kartoons", f = "Kartoons.kt", i = {0}, l = {253}, m = "search", n = {"query"}, nl = {528}, s = {"L$0"}, v = 2)
    static final class C00091 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00091(Continuation<? super C00091> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Kartoons.this.search(null, (Continuation) this);
        }
    }

    public Kartoons(@Nullable String authToken) {
        this.authToken = authToken;
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

    public boolean getHasDownloadSupport() {
        return this.hasDownloadSupport;
    }

    public boolean getHasQuickSearch() {
        return this.hasQuickSearch;
    }

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    /* JADX INFO: compiled from: Kartoons.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/Kartoons/Kartoons$Companion;", "", "<init>", "()V", "challengeToken", "", "getChallengeToken", "()Ljava/lang/String;", "setChallengeToken", "(Ljava/lang/String;)V", "cookie", "getCookie", "setCookie", "userAgent", "getUserAgent", "setUserAgent", "cfBypassMutex", "Lkotlinx/coroutines/sync/Mutex;", "isCloudflareBlocked", "", "response", "Lcom/lagradost/nicehttp/NiceResponse;", "Kartoons"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Nullable
        public final String getChallengeToken() {
            return Kartoons.challengeToken;
        }

        public final void setChallengeToken(@Nullable String str) {
            Kartoons.challengeToken = str;
        }

        @Nullable
        public final String getCookie() {
            return Kartoons.cookie;
        }

        public final void setCookie(@Nullable String str) {
            Kartoons.cookie = str;
        }

        @Nullable
        public final String getUserAgent() {
            return Kartoons.userAgent;
        }

        public final void setUserAgent(@Nullable String str) {
            Kartoons.userAgent = str;
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:102:0x04f5 A[Catch: all -> 0x05af, TRY_ENTER, TRY_LEAVE, TryCatch #6 {all -> 0x05af, blocks: (B:96:0x04e3, B:102:0x04f5), top: B:139:0x04e3 }] */
    /* JADX WARN: Code duplicated, block: B:104:0x04fd A[Catch: all -> 0x04f0, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x04f0, blocks: (B:98:0x04ed, B:104:0x04fd), top: B:129:0x04eb }] */
    /* JADX WARN: Code duplicated, block: B:106:0x0526 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:112:0x0548  */
    /* JADX WARN: Code duplicated, block: B:114:0x054a  */
    /* JADX WARN: Code duplicated, block: B:116:0x0596 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:117:0x0597  */
    /* JADX WARN: Code duplicated, block: B:44:0x024a  */
    /* JADX WARN: Code duplicated, block: B:46:0x025c  */
    /* JADX WARN: Code duplicated, block: B:47:0x0278  */
    /* JADX WARN: Code duplicated, block: B:49:0x0286  */
    /* JADX WARN: Code duplicated, block: B:52:0x02aa  */
    /* JADX WARN: Code duplicated, block: B:53:0x02ac  */
    /* JADX WARN: Code duplicated, block: B:55:0x02af  */
    /* JADX WARN: Code duplicated, block: B:57:0x0324 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:58:0x0325  */
    /* JADX WARN: Code duplicated, block: B:66:0x0350  */
    /* JADX WARN: Code duplicated, block: B:67:0x0355  */
    /* JADX WARN: Code duplicated, block: B:70:0x035a  */
    /* JADX WARN: Code duplicated, block: B:78:0x0427  */
    /* JADX WARN: Code duplicated, block: B:79:0x042e  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:83:0x043e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:84:0x043f  */
    /* JADX WARN: Code duplicated, block: B:86:0x0474 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:87:0x0475  */
    /* JADX WARN: Code duplicated, block: B:94:0x04d2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:95:0x04d3  */
    /* JADX WARN: Code duplicated, block: B:98:0x04ed A[Catch: all -> 0x04f0, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x04f0, blocks: (B:98:0x04ed, B:104:0x04fd), top: B:129:0x04eb }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v38 */
    /* JADX WARN: Type inference failed for: r8v39 */
    /* JADX WARN: Type inference failed for: r8v40 */
    public final Object appGet(String str, Map<String, String> map, Continuation<? super NiceResponse> continuation) throws Throwable {
        C00021 c00021;
        Mutex mutex;
        Map map2;
        char c;
        Object obj;
        boolean z;
        Object obj2;
        C00021 c00022;
        Map<String, String> map3;
        Map map4;
        String str2;
        NiceResponse niceResponse;
        String str3;
        Map map5;
        NiceResponse niceResponse2;
        String str4;
        boolean z2;
        String str5;
        String str6;
        NiceResponse niceResponse3;
        int i;
        char c2;
        Object obj3;
        Map map6;
        C00021 c00023;
        String str7;
        Map<String, String> map7;
        String str8;
        Map map8;
        Object safe;
        PowChallengeResponse powChallengeResponse;
        PowChallengeData data;
        PowChallengeData powChallengeData;
        Map map9;
        String str9;
        Map map10;
        Map<String, String> map11;
        Ref.ObjectRef objectRef;
        Mutex mutex2;
        Object obj4;
        Map<String, String> map12;
        Ref.ObjectRef objectRef2;
        NiceResponse niceResponse4;
        Mutex mutex3;
        Object obj5;
        Map map13;
        Mutex mutex4;
        Ref.ObjectRef objectRef3;
        String str10;
        Object obj6;
        C00021 c00024;
        String str11;
        Map map14;
        Object obj7;
        NiceResponse niceResponse5;
        Map map15;
        Map<String, String> map16;
        Ref.ObjectRef objectRef4;
        NiceResponse niceResponse6;
        String str12;
        Ref.ObjectRef objectRef5;
        NiceResponse niceResponse7;
        Map map17;
        Map map18;
        Map<String, String> map19;
        Object obj8;
        NiceResponse niceResponse8;
        Object obj9;
        Object obj10;
        if (continuation instanceof C00021) {
            c00021 = (C00021) continuation;
            if ((c00021.label & Integer.MIN_VALUE) != 0) {
                c00021.label -= Integer.MIN_VALUE;
            } else {
                c00021 = new C00021(continuation);
            }
        } else {
            c00021 = new C00021(continuation);
        }
        C00021 c00025 = c00021;
        Object obj11 = c00025.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        Object obj12 = 2;
        try {
            switch (c00025.label) {
                case 0:
                    ResultKt.throwOnFailure(obj11);
                    Map mapMapOf = MapsKt.mapOf(TuplesKt.to("x-challenge-token", "nGvC-9tPhkm4PRmKcTZMzR-CvcfEeSQVrZevvS-wmCU"));
                    if (challengeToken != null) {
                        String str13 = challengeToken;
                        Intrinsics.checkNotNull(str13);
                        mapMapOf = MapsKt.mapOf(TuplesKt.to("x-challenge-token", str13));
                    }
                    Map mapPlus = MapsKt.plus(mapMapOf, map);
                    String str14 = this.authToken;
                    Map mapPlus2 = MapsKt.plus(mapPlus, !(str14 == null || StringsKt.isBlank(str14)) ? MapsKt.mapOf(TuplesKt.to("Authorization", "Bearer " + this.authToken)) : MapsKt.emptyMap());
                    Requests app = MainActivityKt.getApp();
                    KartoonsCFBypassInterceptor kartoonsCFBypassInterceptor = KartoonsCFBypassInterceptor.INSTANCE;
                    c00025.L$0 = str;
                    c00025.L$1 = SpillingKt.nullOutSpilledVariable(map);
                    c00025.L$2 = SpillingKt.nullOutSpilledVariable(mapMapOf);
                    c00025.L$3 = mapPlus2;
                    c00025.label = 1;
                    map2 = mapPlus2;
                    c = 1;
                    obj = coroutine_suspended;
                    z = false;
                    obj2 = Requests.get$default(app, str, map2, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, kartoonsCFBypassInterceptor, false, (ResponseParser) null, c00025, 3580, (Object) null);
                    c00022 = c00025;
                    if (obj2 == obj) {
                        return obj;
                    }
                    map3 = map;
                    map4 = mapMapOf;
                    str2 = str;
                    niceResponse = (NiceResponse) obj2;
                    if (StringsKt.contains$default(niceResponse.getText(), "pow_required", z, 2, (Object) null)) {
                        str4 = "";
                        if (StringsKt.contains$default(str2, "/shows/episode/", z, 2, (Object) null)) {
                            str4 = "episode:" + StringsKt.substringBefore$default(StringsKt.substringAfter$default(str2, "/shows/episode/", (String) null, 2, (Object) null), "/links", (String) null, 2, (Object) null);
                        } else if (StringsKt.contains$default(str2, "/movies/", z, 2, (Object) null)) {
                            str4 = "movie:" + StringsKt.substringBefore$default(StringsKt.substringAfter$default(str2, "/movies/", (String) null, 2, (Object) null), "/links", (String) null, 2, (Object) null);
                        }
                        if (str4.length() > 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            str5 = getMainUrl() + "/api/challenge/pow?content=" + str4;
                            Requests app2 = MainActivityKt.getApp();
                            KartoonsCFBypassInterceptor kartoonsCFBypassInterceptor2 = KartoonsCFBypassInterceptor.INSTANCE;
                            c00022.L$0 = str2;
                            c00022.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                            c00022.L$2 = SpillingKt.nullOutSpilledVariable(map4);
                            c00022.L$3 = map2;
                            c00022.L$4 = niceResponse;
                            c00022.L$5 = SpillingKt.nullOutSpilledVariable(str4);
                            c00022.L$6 = SpillingKt.nullOutSpilledVariable(str5);
                            c00022.label = 2;
                            C00021 c00026 = c00022;
                            str6 = str4;
                            niceResponse3 = niceResponse;
                            i = 2;
                            c2 = 0;
                            obj3 = Requests.get$default(app2, str5, map2, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, kartoonsCFBypassInterceptor2, false, (ResponseParser) null, c00026, 3580, (Object) null);
                            map6 = map2;
                            c00023 = c00026;
                            if (obj3 == obj) {
                                return obj;
                            }
                            str7 = str2;
                            map7 = map3;
                            str8 = str5;
                            map8 = map6;
                            NiceResponse niceResponse9 = (NiceResponse) obj3;
                            try {
                                ResponseParser parser = niceResponse9.getParser();
                                Intrinsics.checkNotNull(parser);
                                safe = parser.parseSafe(niceResponse9.getText(), Reflection.getOrCreateKotlinClass(PowChallengeResponse.class));
                            } catch (Exception e) {
                                e.printStackTrace();
                                safe = null;
                            }
                            powChallengeResponse = (PowChallengeResponse) safe;
                            if (powChallengeResponse != null) {
                                data = powChallengeResponse.getData();
                            } else {
                                data = null;
                            }
                            powChallengeData = data;
                            if (powChallengeData == null && powChallengeData.getEnabled()) {
                                String strSolvePow = solvePow(powChallengeData.getNonce(), powChallengeData.getBits());
                                Pair[] pairArr = new Pair[i];
                                pairArr[c2] = TuplesKt.to("x-pow-nonce", powChallengeData.getNonce());
                                pairArr[c] = TuplesKt.to("x-pow-solution", strSolvePow);
                                Map mapPlus3 = MapsKt.plus(map8, MapsKt.mapOf(pairArr));
                                Requests app3 = MainActivityKt.getApp();
                                KartoonsCFBypassInterceptor kartoonsCFBypassInterceptor3 = KartoonsCFBypassInterceptor.INSTANCE;
                                c00023.L$0 = str7;
                                c00023.L$1 = SpillingKt.nullOutSpilledVariable(map7);
                                c00023.L$2 = SpillingKt.nullOutSpilledVariable(map4);
                                c00023.L$3 = map8;
                                c00023.L$4 = SpillingKt.nullOutSpilledVariable(niceResponse3);
                                c00023.L$5 = SpillingKt.nullOutSpilledVariable(str6);
                                c00023.L$6 = SpillingKt.nullOutSpilledVariable(str8);
                                c00023.L$7 = SpillingKt.nullOutSpilledVariable(powChallengeResponse);
                                c00023.L$8 = SpillingKt.nullOutSpilledVariable(powChallengeData);
                                c00023.L$9 = SpillingKt.nullOutSpilledVariable(strSolvePow);
                                c00023.L$10 = SpillingKt.nullOutSpilledVariable(mapPlus3);
                                c00023.label = 3;
                                C00021 c00027 = c00023;
                                String str15 = str7;
                                Map map20 = map8;
                                Object obj13 = Requests.get$default(app3, str15, mapPlus3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, kartoonsCFBypassInterceptor3, false, (ResponseParser) null, c00027, 3580, (Object) null);
                                c00022 = c00027;
                                if (obj13 == obj) {
                                    return obj;
                                }
                                map9 = map20;
                                str9 = str15;
                                map10 = map4;
                                map11 = map7;
                                obj11 = obj13;
                                niceResponse2 = (NiceResponse) obj11;
                                map5 = map9;
                                map4 = map10;
                                map3 = map11;
                                str3 = str9;
                            } else {
                                c00022 = c00023;
                                map5 = map8;
                                str3 = str7;
                                niceResponse2 = niceResponse3;
                                map3 = map7;
                            }
                            if (!INSTANCE.isCloudflareBlocked(niceResponse2)) {
                                return niceResponse2;
                            }
                            objectRef = new Ref.ObjectRef();
                            mutex2 = cfBypassMutex;
                            c00022.L$0 = str3;
                            c00022.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                            c00022.L$2 = SpillingKt.nullOutSpilledVariable(map4);
                            c00022.L$3 = map5;
                            c00022.L$4 = SpillingKt.nullOutSpilledVariable(niceResponse2);
                            c00022.L$5 = objectRef;
                            c00022.L$6 = mutex2;
                            c00022.L$7 = null;
                            c00022.L$8 = null;
                            c00022.L$9 = null;
                            c00022.L$10 = null;
                            c00022.label = 4;
                            if (mutex2.lock((Object) null, c00022) == obj) {
                                return obj;
                            }
                            obj4 = null;
                            map12 = map3;
                            objectRef2 = objectRef;
                            niceResponse4 = niceResponse2;
                            mutex3 = mutex2;
                            obj5 = null;
                            map13 = map5;
                            try {
                                Requests app4 = MainActivityKt.getApp();
                                KartoonsCFBypassInterceptor kartoonsCFBypassInterceptor4 = KartoonsCFBypassInterceptor.INSTANCE;
                                c00022.L$0 = str3;
                                c00022.L$1 = SpillingKt.nullOutSpilledVariable(map12);
                                c00022.L$2 = SpillingKt.nullOutSpilledVariable(map4);
                                c00022.L$3 = map13;
                                c00022.L$4 = SpillingKt.nullOutSpilledVariable(niceResponse4);
                                c00022.L$5 = objectRef2;
                                c00022.L$6 = mutex3;
                                c00022.label = 5;
                                mutex4 = mutex3;
                                C00021 c00028 = c00022;
                                objectRef3 = objectRef2;
                                str10 = str3;
                                try {
                                    obj6 = Requests.get$default(app4, str10, map13, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, kartoonsCFBypassInterceptor4, false, (ResponseParser) null, c00028, 3580, (Object) null);
                                    c00024 = c00028;
                                    if (obj6 == obj) {
                                        return obj;
                                    }
                                    str11 = str10;
                                    map14 = map13;
                                    obj7 = obj4;
                                    niceResponse5 = niceResponse4;
                                    map15 = map4;
                                    map16 = map12;
                                    objectRef4 = objectRef3;
                                    mutex = mutex4;
                                    obj11 = obj6;
                                    try {
                                        niceResponse6 = (NiceResponse) obj11;
                                        try {
                                            try {
                                                if (!INSTANCE.isCloudflareBlocked(niceResponse6)) {
                                                    if (KartoonsPlugin.INSTANCE.getCfWebviewEnabled()) {
                                                        c00024.L$0 = str11;
                                                        c00024.L$1 = SpillingKt.nullOutSpilledVariable(map16);
                                                        c00024.L$2 = SpillingKt.nullOutSpilledVariable(map15);
                                                        c00024.L$3 = map14;
                                                        c00024.L$4 = SpillingKt.nullOutSpilledVariable(niceResponse5);
                                                        c00024.L$5 = objectRef4;
                                                        c00024.L$6 = mutex;
                                                        c00024.L$7 = SpillingKt.nullOutSpilledVariable(niceResponse6);
                                                        c00024.label = 6;
                                                        if (KartoonsKt.showKartoonsCFBypassDialogAndWait(str11, c00024) == obj) {
                                                            obj10 = obj7;
                                                            return obj;
                                                        }
                                                        obj10 = obj7;
                                                        str12 = str11;
                                                        objectRef5 = objectRef4;
                                                        niceResponse7 = niceResponse5;
                                                        map17 = map14;
                                                        map18 = map15;
                                                        map19 = map16;
                                                        obj8 = obj10;
                                                    }
                                                    Unit unit = Unit.INSTANCE;
                                                    mutex.unlock(obj8);
                                                    niceResponse8 = (NiceResponse) objectRef5.element;
                                                    if (niceResponse8 != null) {
                                                        return niceResponse8;
                                                    }
                                                    Requests app5 = MainActivityKt.getApp();
                                                    KartoonsCFBypassInterceptor kartoonsCFBypassInterceptor5 = KartoonsCFBypassInterceptor.INSTANCE;
                                                    c00024.L$0 = SpillingKt.nullOutSpilledVariable(str12);
                                                    c00024.L$1 = SpillingKt.nullOutSpilledVariable(map19);
                                                    c00024.L$2 = SpillingKt.nullOutSpilledVariable(map18);
                                                    c00024.L$3 = SpillingKt.nullOutSpilledVariable(map17);
                                                    c00024.L$4 = SpillingKt.nullOutSpilledVariable(niceResponse7);
                                                    c00024.L$5 = SpillingKt.nullOutSpilledVariable(objectRef5);
                                                    c00024.L$6 = null;
                                                    c00024.L$7 = null;
                                                    c00024.label = 7;
                                                    obj9 = Requests.get$default(app5, str12, map17, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, kartoonsCFBypassInterceptor5, false, (ResponseParser) null, c00024, 3580, (Object) null);
                                                    if (obj9 == obj) {
                                                        return obj;
                                                    }
                                                    return obj9;
                                                }
                                                objectRef4.element = niceResponse6;
                                                Unit unit2 = Unit.INSTANCE;
                                                mutex.unlock(obj8);
                                                niceResponse8 = (NiceResponse) objectRef5.element;
                                                if (niceResponse8 != null) {
                                                    return niceResponse8;
                                                }
                                                Requests app6 = MainActivityKt.getApp();
                                                KartoonsCFBypassInterceptor kartoonsCFBypassInterceptor6 = KartoonsCFBypassInterceptor.INSTANCE;
                                                c00024.L$0 = SpillingKt.nullOutSpilledVariable(str12);
                                                c00024.L$1 = SpillingKt.nullOutSpilledVariable(map19);
                                                c00024.L$2 = SpillingKt.nullOutSpilledVariable(map18);
                                                c00024.L$3 = SpillingKt.nullOutSpilledVariable(map17);
                                                c00024.L$4 = SpillingKt.nullOutSpilledVariable(niceResponse7);
                                                c00024.L$5 = SpillingKt.nullOutSpilledVariable(objectRef5);
                                                c00024.L$6 = null;
                                                c00024.L$7 = null;
                                                c00024.label = 7;
                                                obj9 = Requests.get$default(app6, str12, map17, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, kartoonsCFBypassInterceptor6, false, (ResponseParser) null, c00024, 3580, (Object) null);
                                                if (obj9 == obj) {
                                                    return obj;
                                                }
                                                return obj9;
                                            } catch (Throwable th) {
                                                th = th;
                                                obj12 = obj8;
                                                mutex.unlock(obj12);
                                                throw th;
                                            }
                                            str12 = str11;
                                            objectRef5 = objectRef4;
                                            niceResponse7 = niceResponse5;
                                            map17 = map14;
                                            map18 = map15;
                                            map19 = map16;
                                            obj8 = obj7;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            obj12 = obj7;
                                            mutex.unlock(obj12);
                                            throw th;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        obj12 = obj7;
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    obj12 = obj4;
                                    mutex = mutex4;
                                    mutex.unlock(obj12);
                                    throw th;
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                obj12 = obj4;
                                mutex = mutex3;
                            }
                            break;
                        }
                    }
                    str3 = str2;
                    map5 = map2;
                    niceResponse2 = niceResponse;
                    if (!INSTANCE.isCloudflareBlocked(niceResponse2)) {
                        return niceResponse2;
                    }
                    objectRef = new Ref.ObjectRef();
                    mutex2 = cfBypassMutex;
                    c00022.L$0 = str3;
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(map4);
                    c00022.L$3 = map5;
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(niceResponse2);
                    c00022.L$5 = objectRef;
                    c00022.L$6 = mutex2;
                    c00022.L$7 = null;
                    c00022.L$8 = null;
                    c00022.L$9 = null;
                    c00022.L$10 = null;
                    c00022.label = 4;
                    if (mutex2.lock((Object) null, c00022) == obj) {
                        return obj;
                    }
                    obj4 = null;
                    map12 = map3;
                    objectRef2 = objectRef;
                    niceResponse4 = niceResponse2;
                    mutex3 = mutex2;
                    obj5 = null;
                    map13 = map5;
                    Requests app7 = MainActivityKt.getApp();
                    KartoonsCFBypassInterceptor kartoonsCFBypassInterceptor7 = KartoonsCFBypassInterceptor.INSTANCE;
                    c00022.L$0 = str3;
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(map12);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(map4);
                    c00022.L$3 = map13;
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(niceResponse4);
                    c00022.L$5 = objectRef2;
                    c00022.L$6 = mutex3;
                    c00022.label = 5;
                    mutex4 = mutex3;
                    C00021 c00029 = c00022;
                    objectRef3 = objectRef2;
                    str10 = str3;
                    obj6 = Requests.get$default(app7, str10, map13, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, kartoonsCFBypassInterceptor7, false, (ResponseParser) null, c00029, 3580, (Object) null);
                    c00024 = c00029;
                    if (obj6 == obj) {
                        return obj;
                    }
                    str11 = str10;
                    map14 = map13;
                    obj7 = obj4;
                    niceResponse5 = niceResponse4;
                    map15 = map4;
                    map16 = map12;
                    objectRef4 = objectRef3;
                    mutex = mutex4;
                    obj11 = obj6;
                    niceResponse6 = (NiceResponse) obj11;
                    if (!INSTANCE.isCloudflareBlocked(niceResponse6)) {
                        if (KartoonsPlugin.INSTANCE.getCfWebviewEnabled()) {
                            c00024.L$0 = str11;
                            c00024.L$1 = SpillingKt.nullOutSpilledVariable(map16);
                            c00024.L$2 = SpillingKt.nullOutSpilledVariable(map15);
                            c00024.L$3 = map14;
                            c00024.L$4 = SpillingKt.nullOutSpilledVariable(niceResponse5);
                            c00024.L$5 = objectRef4;
                            c00024.L$6 = mutex;
                            c00024.L$7 = SpillingKt.nullOutSpilledVariable(niceResponse6);
                            c00024.label = 6;
                            if (KartoonsKt.showKartoonsCFBypassDialogAndWait(str11, c00024) == obj) {
                                obj10 = obj7;
                                return obj;
                            }
                            obj10 = obj7;
                            str12 = str11;
                            objectRef5 = objectRef4;
                            niceResponse7 = niceResponse5;
                            map17 = map14;
                            map18 = map15;
                            map19 = map16;
                            obj8 = obj10;
                        }
                        Unit unit3 = Unit.INSTANCE;
                        mutex.unlock(obj8);
                        niceResponse8 = (NiceResponse) objectRef5.element;
                        if (niceResponse8 != null) {
                            return niceResponse8;
                        }
                        Requests app8 = MainActivityKt.getApp();
                        KartoonsCFBypassInterceptor kartoonsCFBypassInterceptor8 = KartoonsCFBypassInterceptor.INSTANCE;
                        c00024.L$0 = SpillingKt.nullOutSpilledVariable(str12);
                        c00024.L$1 = SpillingKt.nullOutSpilledVariable(map19);
                        c00024.L$2 = SpillingKt.nullOutSpilledVariable(map18);
                        c00024.L$3 = SpillingKt.nullOutSpilledVariable(map17);
                        c00024.L$4 = SpillingKt.nullOutSpilledVariable(niceResponse7);
                        c00024.L$5 = SpillingKt.nullOutSpilledVariable(objectRef5);
                        c00024.L$6 = null;
                        c00024.L$7 = null;
                        c00024.label = 7;
                        obj9 = Requests.get$default(app8, str12, map17, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, kartoonsCFBypassInterceptor8, false, (ResponseParser) null, c00024, 3580, (Object) null);
                        if (obj9 == obj) {
                            return obj;
                        }
                        return obj9;
                    }
                    objectRef4.element = niceResponse6;
                    str12 = str11;
                    objectRef5 = objectRef4;
                    niceResponse7 = niceResponse5;
                    map17 = map14;
                    map18 = map15;
                    map19 = map16;
                    obj8 = obj7;
                    Unit unit4 = Unit.INSTANCE;
                    mutex.unlock(obj8);
                    niceResponse8 = (NiceResponse) objectRef5.element;
                    if (niceResponse8 != null) {
                        return niceResponse8;
                    }
                    Requests app9 = MainActivityKt.getApp();
                    KartoonsCFBypassInterceptor kartoonsCFBypassInterceptor9 = KartoonsCFBypassInterceptor.INSTANCE;
                    c00024.L$0 = SpillingKt.nullOutSpilledVariable(str12);
                    c00024.L$1 = SpillingKt.nullOutSpilledVariable(map19);
                    c00024.L$2 = SpillingKt.nullOutSpilledVariable(map18);
                    c00024.L$3 = SpillingKt.nullOutSpilledVariable(map17);
                    c00024.L$4 = SpillingKt.nullOutSpilledVariable(niceResponse7);
                    c00024.L$5 = SpillingKt.nullOutSpilledVariable(objectRef5);
                    c00024.L$6 = null;
                    c00024.L$7 = null;
                    c00024.label = 7;
                    obj9 = Requests.get$default(app9, str12, map17, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, kartoonsCFBypassInterceptor9, false, (ResponseParser) null, c00024, 3580, (Object) null);
                    if (obj9 == obj) {
                        return obj;
                    }
                    return obj9;
                case 1:
                    Map map21 = (Map) c00025.L$3;
                    Map map22 = (Map) c00025.L$2;
                    Map<String, String> map23 = (Map) c00025.L$1;
                    String str16 = (String) c00025.L$0;
                    ResultKt.throwOnFailure(obj11);
                    obj = coroutine_suspended;
                    map4 = map22;
                    map3 = map23;
                    z = false;
                    c = 1;
                    map2 = map21;
                    c00022 = c00025;
                    obj2 = obj11;
                    str2 = str16;
                    niceResponse = (NiceResponse) obj2;
                    if (StringsKt.contains$default(niceResponse.getText(), "pow_required", z, 2, (Object) null)) {
                        str4 = "";
                        if (StringsKt.contains$default(str2, "/shows/episode/", z, 2, (Object) null)) {
                            str4 = "episode:" + StringsKt.substringBefore$default(StringsKt.substringAfter$default(str2, "/shows/episode/", (String) null, 2, (Object) null), "/links", (String) null, 2, (Object) null);
                        } else if (StringsKt.contains$default(str2, "/movies/", z, 2, (Object) null)) {
                            str4 = "movie:" + StringsKt.substringBefore$default(StringsKt.substringAfter$default(str2, "/movies/", (String) null, 2, (Object) null), "/links", (String) null, 2, (Object) null);
                        }
                        if (str4.length() > 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            str5 = getMainUrl() + "/api/challenge/pow?content=" + str4;
                            Requests app10 = MainActivityKt.getApp();
                            KartoonsCFBypassInterceptor kartoonsCFBypassInterceptor10 = KartoonsCFBypassInterceptor.INSTANCE;
                            c00022.L$0 = str2;
                            c00022.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                            c00022.L$2 = SpillingKt.nullOutSpilledVariable(map4);
                            c00022.L$3 = map2;
                            c00022.L$4 = niceResponse;
                            c00022.L$5 = SpillingKt.nullOutSpilledVariable(str4);
                            c00022.L$6 = SpillingKt.nullOutSpilledVariable(str5);
                            c00022.label = 2;
                            C00021 c000210 = c00022;
                            str6 = str4;
                            niceResponse3 = niceResponse;
                            i = 2;
                            c2 = 0;
                            obj3 = Requests.get$default(app10, str5, map2, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, kartoonsCFBypassInterceptor10, false, (ResponseParser) null, c000210, 3580, (Object) null);
                            map6 = map2;
                            c00023 = c000210;
                            if (obj3 == obj) {
                                return obj;
                            }
                            str7 = str2;
                            map7 = map3;
                            str8 = str5;
                            map8 = map6;
                            NiceResponse niceResponse10 = (NiceResponse) obj3;
                            ResponseParser parser2 = niceResponse10.getParser();
                            Intrinsics.checkNotNull(parser2);
                            safe = parser2.parseSafe(niceResponse10.getText(), Reflection.getOrCreateKotlinClass(PowChallengeResponse.class));
                            powChallengeResponse = (PowChallengeResponse) safe;
                            if (powChallengeResponse != null) {
                                data = powChallengeResponse.getData();
                            } else {
                                data = null;
                            }
                            powChallengeData = data;
                            if (powChallengeData == null) {
                                break;
                            }
                            c00022 = c00023;
                            map5 = map8;
                            str3 = str7;
                            niceResponse2 = niceResponse3;
                            map3 = map7;
                            if (!INSTANCE.isCloudflareBlocked(niceResponse2)) {
                                return niceResponse2;
                            }
                            objectRef = new Ref.ObjectRef();
                            mutex2 = cfBypassMutex;
                            c00022.L$0 = str3;
                            c00022.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                            c00022.L$2 = SpillingKt.nullOutSpilledVariable(map4);
                            c00022.L$3 = map5;
                            c00022.L$4 = SpillingKt.nullOutSpilledVariable(niceResponse2);
                            c00022.L$5 = objectRef;
                            c00022.L$6 = mutex2;
                            c00022.L$7 = null;
                            c00022.L$8 = null;
                            c00022.L$9 = null;
                            c00022.L$10 = null;
                            c00022.label = 4;
                            if (mutex2.lock((Object) null, c00022) == obj) {
                                return obj;
                            }
                            obj4 = null;
                            map12 = map3;
                            objectRef2 = objectRef;
                            niceResponse4 = niceResponse2;
                            mutex3 = mutex2;
                            obj5 = null;
                            map13 = map5;
                            Requests app11 = MainActivityKt.getApp();
                            KartoonsCFBypassInterceptor kartoonsCFBypassInterceptor11 = KartoonsCFBypassInterceptor.INSTANCE;
                            c00022.L$0 = str3;
                            c00022.L$1 = SpillingKt.nullOutSpilledVariable(map12);
                            c00022.L$2 = SpillingKt.nullOutSpilledVariable(map4);
                            c00022.L$3 = map13;
                            c00022.L$4 = SpillingKt.nullOutSpilledVariable(niceResponse4);
                            c00022.L$5 = objectRef2;
                            c00022.L$6 = mutex3;
                            c00022.label = 5;
                            mutex4 = mutex3;
                            C00021 c000211 = c00022;
                            objectRef3 = objectRef2;
                            str10 = str3;
                            obj6 = Requests.get$default(app11, str10, map13, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, kartoonsCFBypassInterceptor11, false, (ResponseParser) null, c000211, 3580, (Object) null);
                            c00024 = c000211;
                            if (obj6 == obj) {
                                return obj;
                            }
                            str11 = str10;
                            map14 = map13;
                            obj7 = obj4;
                            niceResponse5 = niceResponse4;
                            map15 = map4;
                            map16 = map12;
                            objectRef4 = objectRef3;
                            mutex = mutex4;
                            obj11 = obj6;
                            niceResponse6 = (NiceResponse) obj11;
                            if (!INSTANCE.isCloudflareBlocked(niceResponse6)) {
                                if (KartoonsPlugin.INSTANCE.getCfWebviewEnabled()) {
                                    c00024.L$0 = str11;
                                    c00024.L$1 = SpillingKt.nullOutSpilledVariable(map16);
                                    c00024.L$2 = SpillingKt.nullOutSpilledVariable(map15);
                                    c00024.L$3 = map14;
                                    c00024.L$4 = SpillingKt.nullOutSpilledVariable(niceResponse5);
                                    c00024.L$5 = objectRef4;
                                    c00024.L$6 = mutex;
                                    c00024.L$7 = SpillingKt.nullOutSpilledVariable(niceResponse6);
                                    c00024.label = 6;
                                    if (KartoonsKt.showKartoonsCFBypassDialogAndWait(str11, c00024) == obj) {
                                        obj10 = obj7;
                                        return obj;
                                    }
                                    obj10 = obj7;
                                    str12 = str11;
                                    objectRef5 = objectRef4;
                                    niceResponse7 = niceResponse5;
                                    map17 = map14;
                                    map18 = map15;
                                    map19 = map16;
                                    obj8 = obj10;
                                }
                                Unit unit5 = Unit.INSTANCE;
                                mutex.unlock(obj8);
                                niceResponse8 = (NiceResponse) objectRef5.element;
                                if (niceResponse8 != null) {
                                    return niceResponse8;
                                }
                                Requests app12 = MainActivityKt.getApp();
                                KartoonsCFBypassInterceptor kartoonsCFBypassInterceptor12 = KartoonsCFBypassInterceptor.INSTANCE;
                                c00024.L$0 = SpillingKt.nullOutSpilledVariable(str12);
                                c00024.L$1 = SpillingKt.nullOutSpilledVariable(map19);
                                c00024.L$2 = SpillingKt.nullOutSpilledVariable(map18);
                                c00024.L$3 = SpillingKt.nullOutSpilledVariable(map17);
                                c00024.L$4 = SpillingKt.nullOutSpilledVariable(niceResponse7);
                                c00024.L$5 = SpillingKt.nullOutSpilledVariable(objectRef5);
                                c00024.L$6 = null;
                                c00024.L$7 = null;
                                c00024.label = 7;
                                obj9 = Requests.get$default(app12, str12, map17, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, kartoonsCFBypassInterceptor12, false, (ResponseParser) null, c00024, 3580, (Object) null);
                                if (obj9 == obj) {
                                    return obj;
                                }
                                return obj9;
                            }
                            objectRef4.element = niceResponse6;
                            str12 = str11;
                            objectRef5 = objectRef4;
                            niceResponse7 = niceResponse5;
                            map17 = map14;
                            map18 = map15;
                            map19 = map16;
                            obj8 = obj7;
                            Unit unit6 = Unit.INSTANCE;
                            mutex.unlock(obj8);
                            niceResponse8 = (NiceResponse) objectRef5.element;
                            if (niceResponse8 != null) {
                                return niceResponse8;
                            }
                            Requests app13 = MainActivityKt.getApp();
                            KartoonsCFBypassInterceptor kartoonsCFBypassInterceptor13 = KartoonsCFBypassInterceptor.INSTANCE;
                            c00024.L$0 = SpillingKt.nullOutSpilledVariable(str12);
                            c00024.L$1 = SpillingKt.nullOutSpilledVariable(map19);
                            c00024.L$2 = SpillingKt.nullOutSpilledVariable(map18);
                            c00024.L$3 = SpillingKt.nullOutSpilledVariable(map17);
                            c00024.L$4 = SpillingKt.nullOutSpilledVariable(niceResponse7);
                            c00024.L$5 = SpillingKt.nullOutSpilledVariable(objectRef5);
                            c00024.L$6 = null;
                            c00024.L$7 = null;
                            c00024.label = 7;
                            obj9 = Requests.get$default(app13, str12, map17, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, kartoonsCFBypassInterceptor13, false, (ResponseParser) null, c00024, 3580, (Object) null);
                            if (obj9 == obj) {
                                return obj;
                            }
                            return obj9;
                        }
                    }
                    str3 = str2;
                    map5 = map2;
                    niceResponse2 = niceResponse;
                    if (!INSTANCE.isCloudflareBlocked(niceResponse2)) {
                        return niceResponse2;
                    }
                    objectRef = new Ref.ObjectRef();
                    mutex2 = cfBypassMutex;
                    c00022.L$0 = str3;
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(map4);
                    c00022.L$3 = map5;
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(niceResponse2);
                    c00022.L$5 = objectRef;
                    c00022.L$6 = mutex2;
                    c00022.L$7 = null;
                    c00022.L$8 = null;
                    c00022.L$9 = null;
                    c00022.L$10 = null;
                    c00022.label = 4;
                    if (mutex2.lock((Object) null, c00022) == obj) {
                        return obj;
                    }
                    obj4 = null;
                    map12 = map3;
                    objectRef2 = objectRef;
                    niceResponse4 = niceResponse2;
                    mutex3 = mutex2;
                    obj5 = null;
                    map13 = map5;
                    Requests app14 = MainActivityKt.getApp();
                    KartoonsCFBypassInterceptor kartoonsCFBypassInterceptor14 = KartoonsCFBypassInterceptor.INSTANCE;
                    c00022.L$0 = str3;
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(map12);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(map4);
                    c00022.L$3 = map13;
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(niceResponse4);
                    c00022.L$5 = objectRef2;
                    c00022.L$6 = mutex3;
                    c00022.label = 5;
                    mutex4 = mutex3;
                    C00021 c000212 = c00022;
                    objectRef3 = objectRef2;
                    str10 = str3;
                    obj6 = Requests.get$default(app14, str10, map13, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, kartoonsCFBypassInterceptor14, false, (ResponseParser) null, c000212, 3580, (Object) null);
                    c00024 = c000212;
                    if (obj6 == obj) {
                        return obj;
                    }
                    str11 = str10;
                    map14 = map13;
                    obj7 = obj4;
                    niceResponse5 = niceResponse4;
                    map15 = map4;
                    map16 = map12;
                    objectRef4 = objectRef3;
                    mutex = mutex4;
                    obj11 = obj6;
                    niceResponse6 = (NiceResponse) obj11;
                    if (!INSTANCE.isCloudflareBlocked(niceResponse6)) {
                        if (KartoonsPlugin.INSTANCE.getCfWebviewEnabled()) {
                            c00024.L$0 = str11;
                            c00024.L$1 = SpillingKt.nullOutSpilledVariable(map16);
                            c00024.L$2 = SpillingKt.nullOutSpilledVariable(map15);
                            c00024.L$3 = map14;
                            c00024.L$4 = SpillingKt.nullOutSpilledVariable(niceResponse5);
                            c00024.L$5 = objectRef4;
                            c00024.L$6 = mutex;
                            c00024.L$7 = SpillingKt.nullOutSpilledVariable(niceResponse6);
                            c00024.label = 6;
                            if (KartoonsKt.showKartoonsCFBypassDialogAndWait(str11, c00024) == obj) {
                                obj10 = obj7;
                                return obj;
                            }
                            obj10 = obj7;
                            str12 = str11;
                            objectRef5 = objectRef4;
                            niceResponse7 = niceResponse5;
                            map17 = map14;
                            map18 = map15;
                            map19 = map16;
                            obj8 = obj10;
                        }
                        Unit unit7 = Unit.INSTANCE;
                        mutex.unlock(obj8);
                        niceResponse8 = (NiceResponse) objectRef5.element;
                        if (niceResponse8 != null) {
                            return niceResponse8;
                        }
                        Requests app15 = MainActivityKt.getApp();
                        KartoonsCFBypassInterceptor kartoonsCFBypassInterceptor15 = KartoonsCFBypassInterceptor.INSTANCE;
                        c00024.L$0 = SpillingKt.nullOutSpilledVariable(str12);
                        c00024.L$1 = SpillingKt.nullOutSpilledVariable(map19);
                        c00024.L$2 = SpillingKt.nullOutSpilledVariable(map18);
                        c00024.L$3 = SpillingKt.nullOutSpilledVariable(map17);
                        c00024.L$4 = SpillingKt.nullOutSpilledVariable(niceResponse7);
                        c00024.L$5 = SpillingKt.nullOutSpilledVariable(objectRef5);
                        c00024.L$6 = null;
                        c00024.L$7 = null;
                        c00024.label = 7;
                        obj9 = Requests.get$default(app15, str12, map17, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, kartoonsCFBypassInterceptor15, false, (ResponseParser) null, c00024, 3580, (Object) null);
                        if (obj9 == obj) {
                            return obj;
                        }
                        return obj9;
                    }
                    objectRef4.element = niceResponse6;
                    str12 = str11;
                    objectRef5 = objectRef4;
                    niceResponse7 = niceResponse5;
                    map17 = map14;
                    map18 = map15;
                    map19 = map16;
                    obj8 = obj7;
                    Unit unit8 = Unit.INSTANCE;
                    mutex.unlock(obj8);
                    niceResponse8 = (NiceResponse) objectRef5.element;
                    if (niceResponse8 != null) {
                        return niceResponse8;
                    }
                    Requests app16 = MainActivityKt.getApp();
                    KartoonsCFBypassInterceptor kartoonsCFBypassInterceptor16 = KartoonsCFBypassInterceptor.INSTANCE;
                    c00024.L$0 = SpillingKt.nullOutSpilledVariable(str12);
                    c00024.L$1 = SpillingKt.nullOutSpilledVariable(map19);
                    c00024.L$2 = SpillingKt.nullOutSpilledVariable(map18);
                    c00024.L$3 = SpillingKt.nullOutSpilledVariable(map17);
                    c00024.L$4 = SpillingKt.nullOutSpilledVariable(niceResponse7);
                    c00024.L$5 = SpillingKt.nullOutSpilledVariable(objectRef5);
                    c00024.L$6 = null;
                    c00024.L$7 = null;
                    c00024.label = 7;
                    obj9 = Requests.get$default(app16, str12, map17, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, kartoonsCFBypassInterceptor16, false, (ResponseParser) null, c00024, 3580, (Object) null);
                    if (obj9 == obj) {
                        return obj;
                    }
                    return obj9;
                case 2:
                    String str17 = (String) c00025.L$6;
                    String str18 = (String) c00025.L$5;
                    NiceResponse niceResponse11 = (NiceResponse) c00025.L$4;
                    Map map24 = (Map) c00025.L$3;
                    Map map25 = (Map) c00025.L$2;
                    Map<String, String> map26 = (Map) c00025.L$1;
                    str7 = (String) c00025.L$0;
                    ResultKt.throwOnFailure(obj11);
                    str8 = str17;
                    obj = coroutine_suspended;
                    str6 = str18;
                    niceResponse3 = niceResponse11;
                    map8 = map24;
                    map4 = map25;
                    map7 = map26;
                    i = 2;
                    c = 1;
                    c2 = 0;
                    c00023 = c00025;
                    obj3 = obj11;
                    NiceResponse niceResponse12 = (NiceResponse) obj3;
                    ResponseParser parser3 = niceResponse12.getParser();
                    Intrinsics.checkNotNull(parser3);
                    safe = parser3.parseSafe(niceResponse12.getText(), Reflection.getOrCreateKotlinClass(PowChallengeResponse.class));
                    powChallengeResponse = (PowChallengeResponse) safe;
                    if (powChallengeResponse != null) {
                        data = powChallengeResponse.getData();
                    } else {
                        data = null;
                    }
                    powChallengeData = data;
                    if (powChallengeData == null) {
                        break;
                    }
                    c00022 = c00023;
                    map5 = map8;
                    str3 = str7;
                    niceResponse2 = niceResponse3;
                    map3 = map7;
                    if (!INSTANCE.isCloudflareBlocked(niceResponse2)) {
                        return niceResponse2;
                    }
                    objectRef = new Ref.ObjectRef();
                    mutex2 = cfBypassMutex;
                    c00022.L$0 = str3;
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(map4);
                    c00022.L$3 = map5;
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(niceResponse2);
                    c00022.L$5 = objectRef;
                    c00022.L$6 = mutex2;
                    c00022.L$7 = null;
                    c00022.L$8 = null;
                    c00022.L$9 = null;
                    c00022.L$10 = null;
                    c00022.label = 4;
                    if (mutex2.lock((Object) null, c00022) == obj) {
                        return obj;
                    }
                    obj4 = null;
                    map12 = map3;
                    objectRef2 = objectRef;
                    niceResponse4 = niceResponse2;
                    mutex3 = mutex2;
                    obj5 = null;
                    map13 = map5;
                    Requests app17 = MainActivityKt.getApp();
                    KartoonsCFBypassInterceptor kartoonsCFBypassInterceptor17 = KartoonsCFBypassInterceptor.INSTANCE;
                    c00022.L$0 = str3;
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(map12);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(map4);
                    c00022.L$3 = map13;
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(niceResponse4);
                    c00022.L$5 = objectRef2;
                    c00022.L$6 = mutex3;
                    c00022.label = 5;
                    mutex4 = mutex3;
                    C00021 c000213 = c00022;
                    objectRef3 = objectRef2;
                    str10 = str3;
                    obj6 = Requests.get$default(app17, str10, map13, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, kartoonsCFBypassInterceptor17, false, (ResponseParser) null, c000213, 3580, (Object) null);
                    c00024 = c000213;
                    if (obj6 == obj) {
                        return obj;
                    }
                    str11 = str10;
                    map14 = map13;
                    obj7 = obj4;
                    niceResponse5 = niceResponse4;
                    map15 = map4;
                    map16 = map12;
                    objectRef4 = objectRef3;
                    mutex = mutex4;
                    obj11 = obj6;
                    niceResponse6 = (NiceResponse) obj11;
                    if (!INSTANCE.isCloudflareBlocked(niceResponse6)) {
                        if (KartoonsPlugin.INSTANCE.getCfWebviewEnabled()) {
                            c00024.L$0 = str11;
                            c00024.L$1 = SpillingKt.nullOutSpilledVariable(map16);
                            c00024.L$2 = SpillingKt.nullOutSpilledVariable(map15);
                            c00024.L$3 = map14;
                            c00024.L$4 = SpillingKt.nullOutSpilledVariable(niceResponse5);
                            c00024.L$5 = objectRef4;
                            c00024.L$6 = mutex;
                            c00024.L$7 = SpillingKt.nullOutSpilledVariable(niceResponse6);
                            c00024.label = 6;
                            if (KartoonsKt.showKartoonsCFBypassDialogAndWait(str11, c00024) == obj) {
                                obj10 = obj7;
                                return obj;
                            }
                            obj10 = obj7;
                            str12 = str11;
                            objectRef5 = objectRef4;
                            niceResponse7 = niceResponse5;
                            map17 = map14;
                            map18 = map15;
                            map19 = map16;
                            obj8 = obj10;
                        }
                        Unit unit9 = Unit.INSTANCE;
                        mutex.unlock(obj8);
                        niceResponse8 = (NiceResponse) objectRef5.element;
                        if (niceResponse8 != null) {
                            return niceResponse8;
                        }
                        Requests app18 = MainActivityKt.getApp();
                        KartoonsCFBypassInterceptor kartoonsCFBypassInterceptor18 = KartoonsCFBypassInterceptor.INSTANCE;
                        c00024.L$0 = SpillingKt.nullOutSpilledVariable(str12);
                        c00024.L$1 = SpillingKt.nullOutSpilledVariable(map19);
                        c00024.L$2 = SpillingKt.nullOutSpilledVariable(map18);
                        c00024.L$3 = SpillingKt.nullOutSpilledVariable(map17);
                        c00024.L$4 = SpillingKt.nullOutSpilledVariable(niceResponse7);
                        c00024.L$5 = SpillingKt.nullOutSpilledVariable(objectRef5);
                        c00024.L$6 = null;
                        c00024.L$7 = null;
                        c00024.label = 7;
                        obj9 = Requests.get$default(app18, str12, map17, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, kartoonsCFBypassInterceptor18, false, (ResponseParser) null, c00024, 3580, (Object) null);
                        if (obj9 == obj) {
                            return obj;
                        }
                        return obj9;
                    }
                    objectRef4.element = niceResponse6;
                    str12 = str11;
                    objectRef5 = objectRef4;
                    niceResponse7 = niceResponse5;
                    map17 = map14;
                    map18 = map15;
                    map19 = map16;
                    obj8 = obj7;
                    Unit unit10 = Unit.INSTANCE;
                    mutex.unlock(obj8);
                    niceResponse8 = (NiceResponse) objectRef5.element;
                    if (niceResponse8 != null) {
                        return niceResponse8;
                    }
                    Requests app19 = MainActivityKt.getApp();
                    KartoonsCFBypassInterceptor kartoonsCFBypassInterceptor19 = KartoonsCFBypassInterceptor.INSTANCE;
                    c00024.L$0 = SpillingKt.nullOutSpilledVariable(str12);
                    c00024.L$1 = SpillingKt.nullOutSpilledVariable(map19);
                    c00024.L$2 = SpillingKt.nullOutSpilledVariable(map18);
                    c00024.L$3 = SpillingKt.nullOutSpilledVariable(map17);
                    c00024.L$4 = SpillingKt.nullOutSpilledVariable(niceResponse7);
                    c00024.L$5 = SpillingKt.nullOutSpilledVariable(objectRef5);
                    c00024.L$6 = null;
                    c00024.L$7 = null;
                    c00024.label = 7;
                    obj9 = Requests.get$default(app19, str12, map17, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, kartoonsCFBypassInterceptor19, false, (ResponseParser) null, c00024, 3580, (Object) null);
                    if (obj9 == obj) {
                        return obj;
                    }
                    return obj9;
                case 3:
                    map9 = (Map) c00025.L$3;
                    map10 = (Map) c00025.L$2;
                    map11 = (Map) c00025.L$1;
                    str9 = (String) c00025.L$0;
                    ResultKt.throwOnFailure(obj11);
                    obj = coroutine_suspended;
                    c00022 = c00025;
                    niceResponse2 = (NiceResponse) obj11;
                    map5 = map9;
                    map4 = map10;
                    map3 = map11;
                    str3 = str9;
                    if (!INSTANCE.isCloudflareBlocked(niceResponse2)) {
                        return niceResponse2;
                    }
                    objectRef = new Ref.ObjectRef();
                    mutex2 = cfBypassMutex;
                    c00022.L$0 = str3;
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(map4);
                    c00022.L$3 = map5;
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(niceResponse2);
                    c00022.L$5 = objectRef;
                    c00022.L$6 = mutex2;
                    c00022.L$7 = null;
                    c00022.L$8 = null;
                    c00022.L$9 = null;
                    c00022.L$10 = null;
                    c00022.label = 4;
                    if (mutex2.lock((Object) null, c00022) == obj) {
                        return obj;
                    }
                    obj4 = null;
                    map12 = map3;
                    objectRef2 = objectRef;
                    niceResponse4 = niceResponse2;
                    mutex3 = mutex2;
                    obj5 = null;
                    map13 = map5;
                    Requests app110 = MainActivityKt.getApp();
                    KartoonsCFBypassInterceptor kartoonsCFBypassInterceptor110 = KartoonsCFBypassInterceptor.INSTANCE;
                    c00022.L$0 = str3;
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(map12);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(map4);
                    c00022.L$3 = map13;
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(niceResponse4);
                    c00022.L$5 = objectRef2;
                    c00022.L$6 = mutex3;
                    c00022.label = 5;
                    mutex4 = mutex3;
                    C00021 c000214 = c00022;
                    objectRef3 = objectRef2;
                    str10 = str3;
                    obj6 = Requests.get$default(app110, str10, map13, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, kartoonsCFBypassInterceptor110, false, (ResponseParser) null, c000214, 3580, (Object) null);
                    c00024 = c000214;
                    if (obj6 == obj) {
                        return obj;
                    }
                    str11 = str10;
                    map14 = map13;
                    obj7 = obj4;
                    niceResponse5 = niceResponse4;
                    map15 = map4;
                    map16 = map12;
                    objectRef4 = objectRef3;
                    mutex = mutex4;
                    obj11 = obj6;
                    niceResponse6 = (NiceResponse) obj11;
                    if (!INSTANCE.isCloudflareBlocked(niceResponse6)) {
                        if (KartoonsPlugin.INSTANCE.getCfWebviewEnabled()) {
                            c00024.L$0 = str11;
                            c00024.L$1 = SpillingKt.nullOutSpilledVariable(map16);
                            c00024.L$2 = SpillingKt.nullOutSpilledVariable(map15);
                            c00024.L$3 = map14;
                            c00024.L$4 = SpillingKt.nullOutSpilledVariable(niceResponse5);
                            c00024.L$5 = objectRef4;
                            c00024.L$6 = mutex;
                            c00024.L$7 = SpillingKt.nullOutSpilledVariable(niceResponse6);
                            c00024.label = 6;
                            if (KartoonsKt.showKartoonsCFBypassDialogAndWait(str11, c00024) == obj) {
                                obj10 = obj7;
                                return obj;
                            }
                            obj10 = obj7;
                            str12 = str11;
                            objectRef5 = objectRef4;
                            niceResponse7 = niceResponse5;
                            map17 = map14;
                            map18 = map15;
                            map19 = map16;
                            obj8 = obj10;
                        }
                        Unit unit11 = Unit.INSTANCE;
                        mutex.unlock(obj8);
                        niceResponse8 = (NiceResponse) objectRef5.element;
                        if (niceResponse8 != null) {
                            return niceResponse8;
                        }
                        Requests app111 = MainActivityKt.getApp();
                        KartoonsCFBypassInterceptor kartoonsCFBypassInterceptor111 = KartoonsCFBypassInterceptor.INSTANCE;
                        c00024.L$0 = SpillingKt.nullOutSpilledVariable(str12);
                        c00024.L$1 = SpillingKt.nullOutSpilledVariable(map19);
                        c00024.L$2 = SpillingKt.nullOutSpilledVariable(map18);
                        c00024.L$3 = SpillingKt.nullOutSpilledVariable(map17);
                        c00024.L$4 = SpillingKt.nullOutSpilledVariable(niceResponse7);
                        c00024.L$5 = SpillingKt.nullOutSpilledVariable(objectRef5);
                        c00024.L$6 = null;
                        c00024.L$7 = null;
                        c00024.label = 7;
                        obj9 = Requests.get$default(app111, str12, map17, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, kartoonsCFBypassInterceptor111, false, (ResponseParser) null, c00024, 3580, (Object) null);
                        if (obj9 == obj) {
                            return obj;
                        }
                        return obj9;
                    }
                    objectRef4.element = niceResponse6;
                    str12 = str11;
                    objectRef5 = objectRef4;
                    niceResponse7 = niceResponse5;
                    map17 = map14;
                    map18 = map15;
                    map19 = map16;
                    obj8 = obj7;
                    Unit unit12 = Unit.INSTANCE;
                    mutex.unlock(obj8);
                    niceResponse8 = (NiceResponse) objectRef5.element;
                    if (niceResponse8 != null) {
                        return niceResponse8;
                    }
                    Requests app112 = MainActivityKt.getApp();
                    KartoonsCFBypassInterceptor kartoonsCFBypassInterceptor112 = KartoonsCFBypassInterceptor.INSTANCE;
                    c00024.L$0 = SpillingKt.nullOutSpilledVariable(str12);
                    c00024.L$1 = SpillingKt.nullOutSpilledVariable(map19);
                    c00024.L$2 = SpillingKt.nullOutSpilledVariable(map18);
                    c00024.L$3 = SpillingKt.nullOutSpilledVariable(map17);
                    c00024.L$4 = SpillingKt.nullOutSpilledVariable(niceResponse7);
                    c00024.L$5 = SpillingKt.nullOutSpilledVariable(objectRef5);
                    c00024.L$6 = null;
                    c00024.L$7 = null;
                    c00024.label = 7;
                    obj9 = Requests.get$default(app112, str12, map17, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, kartoonsCFBypassInterceptor112, false, (ResponseParser) null, c00024, 3580, (Object) null);
                    if (obj9 == obj) {
                        return obj;
                    }
                    return obj9;
                case 4:
                    Mutex mutex5 = (Mutex) c00025.L$6;
                    Ref.ObjectRef objectRef6 = (Ref.ObjectRef) c00025.L$5;
                    NiceResponse niceResponse13 = (NiceResponse) c00025.L$4;
                    Map map27 = (Map) c00025.L$3;
                    Map map28 = (Map) c00025.L$2;
                    Map<String, String> map29 = (Map) c00025.L$1;
                    str3 = (String) c00025.L$0;
                    ResultKt.throwOnFailure(obj11);
                    c00022 = c00025;
                    mutex3 = mutex5;
                    obj5 = null;
                    obj = coroutine_suspended;
                    obj4 = null;
                    objectRef2 = objectRef6;
                    niceResponse4 = niceResponse13;
                    map4 = map28;
                    map12 = map29;
                    map13 = map27;
                    Requests app113 = MainActivityKt.getApp();
                    KartoonsCFBypassInterceptor kartoonsCFBypassInterceptor113 = KartoonsCFBypassInterceptor.INSTANCE;
                    c00022.L$0 = str3;
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(map12);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(map4);
                    c00022.L$3 = map13;
                    c00022.L$4 = SpillingKt.nullOutSpilledVariable(niceResponse4);
                    c00022.L$5 = objectRef2;
                    c00022.L$6 = mutex3;
                    c00022.label = 5;
                    mutex4 = mutex3;
                    C00021 c000215 = c00022;
                    objectRef3 = objectRef2;
                    str10 = str3;
                    obj6 = Requests.get$default(app113, str10, map13, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, kartoonsCFBypassInterceptor113, false, (ResponseParser) null, c000215, 3580, (Object) null);
                    c00024 = c000215;
                    if (obj6 == obj) {
                        return obj;
                    }
                    str11 = str10;
                    map14 = map13;
                    obj7 = obj4;
                    niceResponse5 = niceResponse4;
                    map15 = map4;
                    map16 = map12;
                    objectRef4 = objectRef3;
                    mutex = mutex4;
                    obj11 = obj6;
                    niceResponse6 = (NiceResponse) obj11;
                    if (!INSTANCE.isCloudflareBlocked(niceResponse6)) {
                        if (KartoonsPlugin.INSTANCE.getCfWebviewEnabled()) {
                            c00024.L$0 = str11;
                            c00024.L$1 = SpillingKt.nullOutSpilledVariable(map16);
                            c00024.L$2 = SpillingKt.nullOutSpilledVariable(map15);
                            c00024.L$3 = map14;
                            c00024.L$4 = SpillingKt.nullOutSpilledVariable(niceResponse5);
                            c00024.L$5 = objectRef4;
                            c00024.L$6 = mutex;
                            c00024.L$7 = SpillingKt.nullOutSpilledVariable(niceResponse6);
                            c00024.label = 6;
                            if (KartoonsKt.showKartoonsCFBypassDialogAndWait(str11, c00024) == obj) {
                                obj10 = obj7;
                                return obj;
                            }
                            obj10 = obj7;
                            str12 = str11;
                            objectRef5 = objectRef4;
                            niceResponse7 = niceResponse5;
                            map17 = map14;
                            map18 = map15;
                            map19 = map16;
                            obj8 = obj10;
                        }
                        Unit unit13 = Unit.INSTANCE;
                        mutex.unlock(obj8);
                        niceResponse8 = (NiceResponse) objectRef5.element;
                        if (niceResponse8 != null) {
                            return niceResponse8;
                        }
                        Requests app114 = MainActivityKt.getApp();
                        KartoonsCFBypassInterceptor kartoonsCFBypassInterceptor114 = KartoonsCFBypassInterceptor.INSTANCE;
                        c00024.L$0 = SpillingKt.nullOutSpilledVariable(str12);
                        c00024.L$1 = SpillingKt.nullOutSpilledVariable(map19);
                        c00024.L$2 = SpillingKt.nullOutSpilledVariable(map18);
                        c00024.L$3 = SpillingKt.nullOutSpilledVariable(map17);
                        c00024.L$4 = SpillingKt.nullOutSpilledVariable(niceResponse7);
                        c00024.L$5 = SpillingKt.nullOutSpilledVariable(objectRef5);
                        c00024.L$6 = null;
                        c00024.L$7 = null;
                        c00024.label = 7;
                        obj9 = Requests.get$default(app114, str12, map17, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, kartoonsCFBypassInterceptor114, false, (ResponseParser) null, c00024, 3580, (Object) null);
                        if (obj9 == obj) {
                            return obj;
                        }
                        return obj9;
                    }
                    objectRef4.element = niceResponse6;
                    str12 = str11;
                    objectRef5 = objectRef4;
                    niceResponse7 = niceResponse5;
                    map17 = map14;
                    map18 = map15;
                    map19 = map16;
                    obj8 = obj7;
                    Unit unit14 = Unit.INSTANCE;
                    mutex.unlock(obj8);
                    niceResponse8 = (NiceResponse) objectRef5.element;
                    if (niceResponse8 != null) {
                        return niceResponse8;
                    }
                    Requests app115 = MainActivityKt.getApp();
                    KartoonsCFBypassInterceptor kartoonsCFBypassInterceptor115 = KartoonsCFBypassInterceptor.INSTANCE;
                    c00024.L$0 = SpillingKt.nullOutSpilledVariable(str12);
                    c00024.L$1 = SpillingKt.nullOutSpilledVariable(map19);
                    c00024.L$2 = SpillingKt.nullOutSpilledVariable(map18);
                    c00024.L$3 = SpillingKt.nullOutSpilledVariable(map17);
                    c00024.L$4 = SpillingKt.nullOutSpilledVariable(niceResponse7);
                    c00024.L$5 = SpillingKt.nullOutSpilledVariable(objectRef5);
                    c00024.L$6 = null;
                    c00024.L$7 = null;
                    c00024.label = 7;
                    obj9 = Requests.get$default(app115, str12, map17, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, kartoonsCFBypassInterceptor115, false, (ResponseParser) null, c00024, 3580, (Object) null);
                    if (obj9 == obj) {
                        return obj;
                    }
                    return obj9;
                case 5:
                    obj7 = null;
                    mutex = (Mutex) c00025.L$6;
                    objectRef4 = (Ref.ObjectRef) c00025.L$5;
                    niceResponse5 = (NiceResponse) c00025.L$4;
                    map14 = (Map) c00025.L$3;
                    map15 = (Map) c00025.L$2;
                    map16 = (Map) c00025.L$1;
                    str11 = (String) c00025.L$0;
                    ResultKt.throwOnFailure(obj11);
                    c00024 = c00025;
                    obj = coroutine_suspended;
                    niceResponse6 = (NiceResponse) obj11;
                    if (!INSTANCE.isCloudflareBlocked(niceResponse6)) {
                        if (KartoonsPlugin.INSTANCE.getCfWebviewEnabled()) {
                            c00024.L$0 = str11;
                            c00024.L$1 = SpillingKt.nullOutSpilledVariable(map16);
                            c00024.L$2 = SpillingKt.nullOutSpilledVariable(map15);
                            c00024.L$3 = map14;
                            c00024.L$4 = SpillingKt.nullOutSpilledVariable(niceResponse5);
                            c00024.L$5 = objectRef4;
                            c00024.L$6 = mutex;
                            c00024.L$7 = SpillingKt.nullOutSpilledVariable(niceResponse6);
                            c00024.label = 6;
                            if (KartoonsKt.showKartoonsCFBypassDialogAndWait(str11, c00024) == obj) {
                                obj10 = obj7;
                                return obj;
                            }
                            obj10 = obj7;
                            str12 = str11;
                            objectRef5 = objectRef4;
                            niceResponse7 = niceResponse5;
                            map17 = map14;
                            map18 = map15;
                            map19 = map16;
                            obj8 = obj10;
                        }
                        Unit unit15 = Unit.INSTANCE;
                        mutex.unlock(obj8);
                        niceResponse8 = (NiceResponse) objectRef5.element;
                        if (niceResponse8 != null) {
                            return niceResponse8;
                        }
                        Requests app116 = MainActivityKt.getApp();
                        KartoonsCFBypassInterceptor kartoonsCFBypassInterceptor116 = KartoonsCFBypassInterceptor.INSTANCE;
                        c00024.L$0 = SpillingKt.nullOutSpilledVariable(str12);
                        c00024.L$1 = SpillingKt.nullOutSpilledVariable(map19);
                        c00024.L$2 = SpillingKt.nullOutSpilledVariable(map18);
                        c00024.L$3 = SpillingKt.nullOutSpilledVariable(map17);
                        c00024.L$4 = SpillingKt.nullOutSpilledVariable(niceResponse7);
                        c00024.L$5 = SpillingKt.nullOutSpilledVariable(objectRef5);
                        c00024.L$6 = null;
                        c00024.L$7 = null;
                        c00024.label = 7;
                        obj9 = Requests.get$default(app116, str12, map17, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, kartoonsCFBypassInterceptor116, false, (ResponseParser) null, c00024, 3580, (Object) null);
                        if (obj9 == obj) {
                            return obj;
                        }
                        return obj9;
                    }
                    objectRef4.element = niceResponse6;
                    str12 = str11;
                    objectRef5 = objectRef4;
                    niceResponse7 = niceResponse5;
                    map17 = map14;
                    map18 = map15;
                    map19 = map16;
                    obj8 = obj7;
                    Unit unit16 = Unit.INSTANCE;
                    mutex.unlock(obj8);
                    niceResponse8 = (NiceResponse) objectRef5.element;
                    if (niceResponse8 != null) {
                        return niceResponse8;
                    }
                    Requests app117 = MainActivityKt.getApp();
                    KartoonsCFBypassInterceptor kartoonsCFBypassInterceptor117 = KartoonsCFBypassInterceptor.INSTANCE;
                    c00024.L$0 = SpillingKt.nullOutSpilledVariable(str12);
                    c00024.L$1 = SpillingKt.nullOutSpilledVariable(map19);
                    c00024.L$2 = SpillingKt.nullOutSpilledVariable(map18);
                    c00024.L$3 = SpillingKt.nullOutSpilledVariable(map17);
                    c00024.L$4 = SpillingKt.nullOutSpilledVariable(niceResponse7);
                    c00024.L$5 = SpillingKt.nullOutSpilledVariable(objectRef5);
                    c00024.L$6 = null;
                    c00024.L$7 = null;
                    c00024.label = 7;
                    obj9 = Requests.get$default(app117, str12, map17, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, kartoonsCFBypassInterceptor117, false, (ResponseParser) null, c00024, 3580, (Object) null);
                    if (obj9 == obj) {
                        return obj;
                    }
                    return obj9;
                case 6:
                    obj10 = null;
                    mutex = (Mutex) c00025.L$6;
                    objectRef4 = (Ref.ObjectRef) c00025.L$5;
                    niceResponse5 = (NiceResponse) c00025.L$4;
                    map14 = (Map) c00025.L$3;
                    map15 = (Map) c00025.L$2;
                    map16 = (Map) c00025.L$1;
                    str11 = (String) c00025.L$0;
                    ResultKt.throwOnFailure(obj11);
                    obj = coroutine_suspended;
                    c00024 = c00025;
                    obj10 = obj7;
                    str12 = str11;
                    objectRef5 = objectRef4;
                    niceResponse7 = niceResponse5;
                    map17 = map14;
                    map18 = map15;
                    map19 = map16;
                    obj8 = obj10;
                    Unit unit17 = Unit.INSTANCE;
                    mutex.unlock(obj8);
                    niceResponse8 = (NiceResponse) objectRef5.element;
                    if (niceResponse8 != null) {
                        return niceResponse8;
                    }
                    Requests app118 = MainActivityKt.getApp();
                    KartoonsCFBypassInterceptor kartoonsCFBypassInterceptor118 = KartoonsCFBypassInterceptor.INSTANCE;
                    c00024.L$0 = SpillingKt.nullOutSpilledVariable(str12);
                    c00024.L$1 = SpillingKt.nullOutSpilledVariable(map19);
                    c00024.L$2 = SpillingKt.nullOutSpilledVariable(map18);
                    c00024.L$3 = SpillingKt.nullOutSpilledVariable(map17);
                    c00024.L$4 = SpillingKt.nullOutSpilledVariable(niceResponse7);
                    c00024.L$5 = SpillingKt.nullOutSpilledVariable(objectRef5);
                    c00024.L$6 = null;
                    c00024.L$7 = null;
                    c00024.label = 7;
                    obj9 = Requests.get$default(app118, str12, map17, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, kartoonsCFBypassInterceptor118, false, (ResponseParser) null, c00024, 3580, (Object) null);
                    if (obj9 == obj) {
                        return obj;
                    }
                    return obj9;
                case 7:
                    ResultKt.throwOnFailure(obj11);
                    return obj11;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object appGet$default(Kartoons kartoons, String str, Map map, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        return kartoons.appGet(str, map, continuation);
    }

    private final String solvePow(String nonce, int requiredBits) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        long solution = 0;
        while (true) {
            String attempt = nonce + ':' + solution;
            byte[] bytes = attempt.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            byte[] hashBytes = md.digest(bytes);
            if (hasLeadingZeroBits(hashBytes, requiredBits)) {
                return String.valueOf(solution);
            }
            solution++;
        }
    }

    private final boolean hasLeadingZeroBits(byte[] bytes, int bits) {
        int remaining = bits;
        for (byte b : bytes) {
            int unsignedByte = b & 255;
            if (remaining >= 8) {
                if (unsignedByte != 0) {
                    return false;
                }
                remaining -= 8;
            } else {
                if (remaining <= 0) {
                    return true;
                }
                int shift = 8 - remaining;
                int mask = 255 & (255 << shift);
                return (unsignedByte & mask) == 0;
            }
        }
        return true;
    }

    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.lagradost.cloudstream3.ErrorLoadingException */
    private final void checkAuth() throws ErrorLoadingException {
        String str = this.authToken;
        if (str == null || StringsKt.isBlank(str)) {
            throw new ErrorLoadingException("Not logged in. Please open the Kartoons extension settings and tap 'Kartoons Account' to login.");
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.lagradost.cloudstream3.ErrorLoadingException */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) throws ErrorLoadingException {
        C00041 c00041;
        Object obj;
        MainPageRequest request2;
        List home;
        if (continuation instanceof C00041) {
            c00041 = (C00041) continuation;
            if ((c00041.label & Integer.MIN_VALUE) != 0) {
                c00041.label -= Integer.MIN_VALUE;
            } else {
                c00041 = new C00041(continuation);
            }
        } else {
            c00041 = new C00041(continuation);
        }
        C00041 c00042 = c00041;
        Object $result = c00042.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00042.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                checkAuth();
                String str = getMainUrl() + '/' + request.getData() + "?page=" + page + "&limit=20";
                c00042.L$0 = request;
                c00042.I$0 = page;
                c00042.label = 1;
                Object objAppGet$default = appGet$default(this, str, null, c00042, 2, null);
                if (objAppGet$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = objAppGet$default;
                request2 = request;
                break;
                break;
            case 1:
                int i = c00042.I$0;
                request2 = (MainPageRequest) c00042.L$0;
                ResultKt.throwOnFailure($result);
                obj = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NiceResponse this_$iv = (NiceResponse) obj;
        ResponseParser parser = this_$iv.getParser();
        Intrinsics.checkNotNull(parser);
        Home res = (Home) parser.parse(this_$iv.getText(), Reflection.getOrCreateKotlinClass(Home.class));
        Iterable data = res.getData();
        if (data == null) {
            home = null;
        } else {
            Iterable $this$map$iv = data;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                Data it = (Data) item$iv$iv;
                destination$iv$iv.add(toSearchResult(it));
            }
            home = (List) destination$iv$iv;
        }
        String name = request2.getName();
        Intrinsics.checkNotNull(home);
        return MainAPIKt.newHomePageResponse(new HomePageList(name, home, false), Boxing.boxBoolean(true));
    }

    private final SearchResponse toSearchResult(final Data $this$toSearchResult) {
        String title = $this$toSearchResult.getTitle();
        Intrinsics.checkNotNull(title);
        String href = MainAPIKt.fixUrl(this, "/api/" + $this$toSearchResult.getType() + "s/" + $this$toSearchResult.getSlug());
        final String poster = $this$toSearchResult.getImage();
        return MainAPIKt.newMovieSearchResponse$default(this, title, href, TvType.Movie, false, new Function1() { // from class: com.Kartoons.Kartoons$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                return Kartoons.toSearchResult$lambda$0(poster, $this$toSearchResult, (MovieSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResult$lambda$0(String $poster, Data $this_toSearchResult, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($poster);
        $this$newMovieSearchResponse.setScore(Score.Companion.from10($this_toSearchResult.getRating()));
        return Unit.INSTANCE;
    }

    @Nullable
    public Object quickSearch(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        return search(query, continuation);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.lagradost.cloudstream3.ErrorLoadingException */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) throws ErrorLoadingException {
        C00091 c00091;
        Object objAppGet$default;
        Object safe;
        Iterable data;
        if (continuation instanceof C00091) {
            c00091 = (C00091) continuation;
            if ((c00091.label & Integer.MIN_VALUE) != 0) {
                c00091.label -= Integer.MIN_VALUE;
            } else {
                c00091 = new C00091(continuation);
            }
        } else {
            c00091 = new C00091(continuation);
        }
        C00091 c00092 = c00091;
        Object $result = c00092.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00092.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                checkAuth();
                String str = getMainUrl() + "/api/search/suggestions?q=" + query + "&limit=5";
                c00092.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00092.label = 1;
                objAppGet$default = appGet$default(this, str, null, c00092, 2, null);
                if (objAppGet$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                objAppGet$default = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NiceResponse this_$iv = (NiceResponse) objAppGet$default;
        try {
            ResponseParser parser = this_$iv.getParser();
            Intrinsics.checkNotNull(parser);
            safe = parser.parseSafe(this_$iv.getTextLarge(), Reflection.getOrCreateKotlinClass(Search.class));
        } catch (Exception e$iv) {
            e$iv.printStackTrace();
            safe = null;
        }
        Search search = (Search) safe;
        if (search == null || (data = search.getData()) == null) {
            List res = CollectionsKt.emptyList();
            return res;
        }
        Iterable $this$map$iv = data;
        int $i$f$map = 0;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            final SearchDaum it = (SearchDaum) item$iv$iv;
            destination$iv$iv.add(MainAPIKt.newMovieSearchResponse$default(this, it.getTitle(), MainAPIKt.fixUrl(this, "/api/" + it.getType() + "s/" + it.getId()), TvType.Movie, false, new Function1() { // from class: com.Kartoons.Kartoons$$ExternalSyntheticLambda3
                public final Object invoke(Object obj) {
                    return Kartoons.search$lambda$0$0(it, (MovieSearchResponse) obj);
                }
            }, 8, (Object) null));
            $this$map$iv = $this$map$iv;
            $i$f$map = $i$f$map;
        }
        List res2 = (List) destination$iv$iv;
        return res2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit search$lambda$0$0(SearchDaum $it, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($it.getImage());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.lagradost.cloudstream3.ErrorLoadingException */
    /* JADX WARN: Code duplicated, block: B:101:0x04f4 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:102:0x04f5  */
    /* JADX WARN: Code duplicated, block: B:105:0x051c  */
    /* JADX WARN: Code duplicated, block: B:107:0x0526  */
    /* JADX WARN: Code duplicated, block: B:27:0x0167  */
    /* JADX WARN: Code duplicated, block: B:29:0x016d  */
    /* JADX WARN: Code duplicated, block: B:31:0x0175  */
    /* JADX WARN: Code duplicated, block: B:34:0x017d  */
    /* JADX WARN: Code duplicated, block: B:37:0x0185  */
    /* JADX WARN: Code duplicated, block: B:38:0x0188  */
    /* JADX WARN: Code duplicated, block: B:44:0x019b A[PHI: r4
      0x019b: PHI (r4v8 java.lang.String) = (r4v7 java.lang.String), (r4v26 java.lang.String) binds: [B:40:0x0190, B:42:0x0196] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:47:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:48:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:51:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:52:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:55:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:58:0x020b  */
    /* JADX WARN: Code duplicated, block: B:60:0x021c  */
    /* JADX WARN: Code duplicated, block: B:61:0x021f  */
    /* JADX WARN: Code duplicated, block: B:63:0x0223  */
    /* JADX WARN: Code duplicated, block: B:64:0x0226  */
    /* JADX WARN: Code duplicated, block: B:67:0x022f  */
    /* JADX WARN: Code duplicated, block: B:71:0x0254  */
    /* JADX WARN: Code duplicated, block: B:73:0x0268  */
    /* JADX WARN: Code duplicated, block: B:74:0x026b  */
    /* JADX WARN: Code duplicated, block: B:78:0x02d4  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:80:0x030d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:81:0x030e  */
    /* JADX WARN: Code duplicated, block: B:85:0x033e  */
    /* JADX WARN: Code duplicated, block: B:87:0x034c  */
    /* JADX WARN: Code duplicated, block: B:90:0x0365 A[LOOP:1: B:88:0x035f->B:90:0x0365, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:92:0x03c8  */
    /* JADX WARN: Code duplicated, block: B:96:0x045f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:97:0x0460  */
    /* JADX WARN: Code duplicated, block: B:99:0x0477  */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) throws ErrorLoadingException {
        C00051 c00051;
        Object objAppGet$default;
        String url2;
        Integer numBoxInt;
        Object safe;
        Load json;
        LoadData res;
        String title;
        String title2;
        String description;
        String description2;
        String image;
        String str;
        String poster;
        String coverImage;
        String str2;
        String backgroundPoster;
        Long startYear;
        Integer startYear2;
        Double rating;
        double dDoubleValue;
        Score rating2;
        List<String> tags;
        List<String> list;
        String href;
        String type;
        boolean z;
        String href2;
        TvType tvtag;
        Iterable related;
        Iterable $this$map$iv;
        Collection destination$iv$iv;
        Iterable $this$mapTo$iv$iv;
        String str3;
        List recommendations;
        String description3;
        Object objNewMovieLoadResponse;
        TvType tvtag2;
        LoadData res2;
        String title3;
        String title4;
        String backgroundPoster2;
        Integer startYear3;
        Score rating3;
        List<String> list2;
        List recommendations2;
        Load json2;
        String href3;
        Object objFetchSeasonDetailsForShow;
        LoadData res3;
        String backgroundPoster3;
        Integer startYear4;
        String poster2;
        Score rating4;
        List<String> list3;
        String href4;
        TvType tvtag3;
        String backgroundPoster4;
        Load json3;
        List recommendations3;
        String description4;
        String poster3;
        String title5;
        String str4;
        List allSeasonDetails;
        List episodesList;
        List $this$forEach$iv;
        Object objNewTvSeriesLoadResponse;
        SeasonEpisodes season;
        Long seasonNumber;
        final int seasonNumber2;
        Iterable $this$forEach$iv2;
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
        C00051 c00052 = c00051;
        Object $result = c00052.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        String str5 = "/links";
        switch (c00052.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                checkAuth();
                c00052.L$0 = url;
                c00052.label = 1;
                objAppGet$default = appGet$default(this, url, null, c00052, 2, null);
                if (objAppGet$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                url2 = url;
                NiceResponse this_$iv = (NiceResponse) objAppGet$default;
                numBoxInt = null;
                try {
                    ResponseParser parser = this_$iv.getParser();
                    Intrinsics.checkNotNull(parser);
                    safe = parser.parseSafe(this_$iv.getTextLarge(), Reflection.getOrCreateKotlinClass(Load.class));
                    break;
                } catch (Exception e$iv) {
                    e$iv.printStackTrace();
                    safe = null;
                }
                json = (Load) safe;
                if (json != null) {
                    throw new ErrorLoadingException("Failed to parse JSON");
                }
                res = json.getData();
                if (res != null) {
                    throw new ErrorLoadingException("Failed to parse load response");
                }
                title = res.getTitle();
                if (title == null) {
                    title = "";
                }
                title2 = title;
                description = res.getDescription();
                if (description == null) {
                    description = "";
                }
                description2 = description;
                image = res.getImage();
                if (image == null) {
                    str = "";
                } else {
                    str = image;
                }
                poster = str;
                coverImage = res.getCoverImage();
                if (coverImage == null || (coverImage = res.getHoverImage()) != null) {
                    str2 = coverImage;
                } else {
                    str2 = "";
                }
                backgroundPoster = str2;
                startYear = res.getStartYear();
                if (startYear != null) {
                    numBoxInt = Boxing.boxInt((int) startYear.longValue());
                }
                startYear2 = numBoxInt;
                Score.Companion companion = Score.Companion;
                rating = res.getRating();
                if (rating != null) {
                    dDoubleValue = rating.doubleValue();
                } else {
                    dDoubleValue = 0.0d;
                }
                rating2 = companion.from10(Boxing.boxDouble(dDoubleValue));
                tags = res.getTags();
                if (tags == null) {
                    tags = CollectionsKt.emptyList();
                }
                list = tags;
                href = getMainUrl() + "/api/movies/" + res.getId() + "/links";
                type = res.getType();
                z = false;
                if (type != null) {
                    href2 = href;
                    if (StringsKt.contains(type, "movie", true)) {
                        z = true;
                    }
                } else {
                    href2 = href;
                }
                if (z) {
                    tvtag = TvType.Movie;
                } else {
                    tvtag = TvType.TvSeries;
                }
                related = json.getRelated();
                if (related == null) {
                    related = CollectionsKt.emptyList();
                }
                $this$map$iv = related;
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                $this$mapTo$iv$iv = $this$map$iv;
                for (Object item$iv$iv : $this$mapTo$iv$iv) {
                    Related rel = (Related) item$iv$iv;
                    Kartoons kartoons = this;
                    title5 = rel.getTitle();
                    if (title5 == null) {
                        str4 = "";
                    } else {
                        str4 = title5;
                    }
                    Iterable $this$map$iv2 = $this$map$iv;
                    MovieSearchResponse $this$load_u24lambda_u240_u240 = MainAPIKt.newMovieSearchResponse$default(kartoons, str4, getMainUrl() + "/api/" + rel.getType() + "s/" + rel.getSlug(), TvType.Movie, false, (Function1) null, 24, (Object) null);
                    $this$load_u24lambda_u240_u240.setPosterUrl(rel.getImage());
                    destination$iv$iv.add($this$load_u24lambda_u240_u240);
                    $this$map$iv = $this$map$iv2;
                    $this$mapTo$iv$iv = $this$mapTo$iv$iv;
                    str5 = str5;
                }
                str3 = str5;
                recommendations = (List) destination$iv$iv;
                if (tvtag == TvType.TvSeries) {
                    TvType tvType = TvType.Movie;
                    description3 = description2;
                    C00074 c00074 = new C00074(poster, backgroundPoster, description3, startYear2, rating2, list, recommendations, null);
                    c00052.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c00052.L$1 = SpillingKt.nullOutSpilledVariable(json);
                    c00052.L$2 = SpillingKt.nullOutSpilledVariable(res);
                    c00052.L$3 = SpillingKt.nullOutSpilledVariable(title2);
                    c00052.L$4 = SpillingKt.nullOutSpilledVariable(description3);
                    c00052.L$5 = SpillingKt.nullOutSpilledVariable(poster);
                    c00052.L$6 = SpillingKt.nullOutSpilledVariable(backgroundPoster);
                    c00052.L$7 = SpillingKt.nullOutSpilledVariable(startYear2);
                    c00052.L$8 = SpillingKt.nullOutSpilledVariable(rating2);
                    c00052.L$9 = SpillingKt.nullOutSpilledVariable(list);
                    c00052.L$10 = SpillingKt.nullOutSpilledVariable(href2);
                    c00052.L$11 = SpillingKt.nullOutSpilledVariable(tvtag);
                    c00052.L$12 = SpillingKt.nullOutSpilledVariable(recommendations);
                    c00052.label = 4;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, title2, url2, tvType, href2, c00074, c00052);
                    if (objNewMovieLoadResponse == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    tvtag2 = tvtag;
                    res2 = res;
                    title3 = title2;
                    title4 = poster;
                    backgroundPoster2 = backgroundPoster;
                    startYear3 = startYear2;
                    rating3 = rating2;
                    list2 = list;
                    recommendations2 = recommendations;
                    json2 = json;
                    href3 = href2;
                    return (LoadResponse) objNewMovieLoadResponse;
                }
                String mainUrl = getMainUrl();
                c00052.L$0 = url2;
                c00052.L$1 = SpillingKt.nullOutSpilledVariable(json);
                c00052.L$2 = SpillingKt.nullOutSpilledVariable(res);
                c00052.L$3 = title2;
                c00052.L$4 = description2;
                c00052.L$5 = poster;
                c00052.L$6 = backgroundPoster;
                c00052.L$7 = startYear2;
                c00052.L$8 = rating2;
                c00052.L$9 = list;
                c00052.L$10 = SpillingKt.nullOutSpilledVariable(href2);
                c00052.L$11 = SpillingKt.nullOutSpilledVariable(tvtag);
                c00052.L$12 = recommendations;
                c00052.label = 2;
                objFetchSeasonDetailsForShow = fetchSeasonDetailsForShow(res, mainUrl, c00052);
                if (objFetchSeasonDetailsForShow == coroutine_suspended) {
                    return coroutine_suspended;
                }
                res3 = res;
                backgroundPoster3 = backgroundPoster;
                startYear4 = startYear2;
                poster2 = poster;
                rating4 = rating2;
                list3 = list;
                href4 = href2;
                tvtag3 = tvtag;
                backgroundPoster4 = url2;
                json3 = json;
                recommendations3 = recommendations;
                description4 = description2;
                poster3 = title2;
                allSeasonDetails = (List) objFetchSeasonDetailsForShow;
                episodesList = new ArrayList();
                $this$forEach$iv = allSeasonDetails;
                for (Object element$iv : $this$forEach$iv) {
                    season = (SeasonEpisodes) element$iv;
                    seasonNumber = season.getSeasonNumber();
                    if (seasonNumber != null) {
                        seasonNumber2 = (int) seasonNumber.longValue();
                        $this$forEach$iv2 = season.getEpisodes();
                        for (Object element$iv2 : $this$forEach$iv2) {
                            Iterable $this$forEach$iv3 = $this$forEach$iv2;
                            final EpisodeItem ep = (EpisodeItem) element$iv2;
                            episodesList.add(MainAPIKt.newEpisode(this, getMainUrl() + "/api/shows/episode/" + ep.getId() + str3, new Function1() { // from class: com.Kartoons.Kartoons$$ExternalSyntheticLambda1
                                public final Object invoke(Object obj) {
                                    return Kartoons.load$lambda$1$0$0(seasonNumber2, ep, (Episode) obj);
                                }
                            }));
                            $this$forEach$iv2 = $this$forEach$iv3;
                            allSeasonDetails = allSeasonDetails;
                            $this$forEach$iv = $this$forEach$iv;
                            tvtag3 = tvtag3;
                            href4 = href4;
                        }
                    }
                    json3 = json3;
                    allSeasonDetails = allSeasonDetails;
                    $this$forEach$iv = $this$forEach$iv;
                    tvtag3 = tvtag3;
                    href4 = href4;
                }
                TvType tvType2 = TvType.TvSeries;
                C00063 c00063 = new C00063(poster2, backgroundPoster3, description4, startYear4, rating4, list3, recommendations3, null);
                c00052.L$0 = SpillingKt.nullOutSpilledVariable(backgroundPoster4);
                c00052.L$1 = SpillingKt.nullOutSpilledVariable(json3);
                c00052.L$2 = SpillingKt.nullOutSpilledVariable(res3);
                c00052.L$3 = SpillingKt.nullOutSpilledVariable(poster3);
                c00052.L$4 = SpillingKt.nullOutSpilledVariable(description4);
                c00052.L$5 = SpillingKt.nullOutSpilledVariable(poster2);
                c00052.L$6 = SpillingKt.nullOutSpilledVariable(backgroundPoster3);
                c00052.L$7 = SpillingKt.nullOutSpilledVariable(startYear4);
                c00052.L$8 = SpillingKt.nullOutSpilledVariable(rating4);
                c00052.L$9 = SpillingKt.nullOutSpilledVariable(list3);
                c00052.L$10 = SpillingKt.nullOutSpilledVariable(href4);
                c00052.L$11 = SpillingKt.nullOutSpilledVariable(tvtag3);
                c00052.L$12 = SpillingKt.nullOutSpilledVariable(recommendations3);
                c00052.L$13 = SpillingKt.nullOutSpilledVariable(allSeasonDetails);
                c00052.L$14 = SpillingKt.nullOutSpilledVariable(episodesList);
                c00052.label = 3;
                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, poster3, backgroundPoster4, tvType2, episodesList, c00063, c00052);
                if (objNewTvSeriesLoadResponse == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return (LoadResponse) objNewTvSeriesLoadResponse;
            case 1:
                String url3 = (String) c00052.L$0;
                ResultKt.throwOnFailure($result);
                url2 = url3;
                objAppGet$default = $result;
                NiceResponse this_$iv2 = (NiceResponse) objAppGet$default;
                numBoxInt = null;
                ResponseParser parser2 = this_$iv2.getParser();
                Intrinsics.checkNotNull(parser2);
                safe = parser2.parseSafe(this_$iv2.getTextLarge(), Reflection.getOrCreateKotlinClass(Load.class));
                json = (Load) safe;
                if (json != null) {
                    throw new ErrorLoadingException("Failed to parse JSON");
                }
                res = json.getData();
                if (res != null) {
                    throw new ErrorLoadingException("Failed to parse load response");
                }
                title = res.getTitle();
                if (title == null) {
                    title = "";
                }
                title2 = title;
                description = res.getDescription();
                if (description == null) {
                    description = "";
                }
                description2 = description;
                image = res.getImage();
                if (image == null) {
                    str = "";
                } else {
                    str = image;
                }
                poster = str;
                coverImage = res.getCoverImage();
                if (coverImage == null) {
                    str2 = coverImage;
                } else {
                    str2 = coverImage;
                }
                backgroundPoster = str2;
                startYear = res.getStartYear();
                if (startYear != null) {
                    numBoxInt = Boxing.boxInt((int) startYear.longValue());
                }
                startYear2 = numBoxInt;
                Score.Companion companion2 = Score.Companion;
                rating = res.getRating();
                if (rating != null) {
                    dDoubleValue = rating.doubleValue();
                } else {
                    dDoubleValue = 0.0d;
                }
                rating2 = companion2.from10(Boxing.boxDouble(dDoubleValue));
                tags = res.getTags();
                if (tags == null) {
                    tags = CollectionsKt.emptyList();
                }
                list = tags;
                href = getMainUrl() + "/api/movies/" + res.getId() + "/links";
                type = res.getType();
                z = false;
                if (type != null) {
                    href2 = href;
                    if (StringsKt.contains(type, "movie", true)) {
                        z = true;
                    }
                } else {
                    href2 = href;
                }
                if (z) {
                    tvtag = TvType.Movie;
                } else {
                    tvtag = TvType.TvSeries;
                }
                related = json.getRelated();
                if (related == null) {
                    related = CollectionsKt.emptyList();
                }
                $this$map$iv = related;
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                $this$mapTo$iv$iv = $this$map$iv;
                while (r19.hasNext()) {
                    Related rel2 = (Related) item$iv$iv;
                    Kartoons kartoons2 = this;
                    title5 = rel2.getTitle();
                    if (title5 == null) {
                        str4 = "";
                    } else {
                        str4 = title5;
                    }
                    Iterable $this$map$iv3 = $this$map$iv;
                    MovieSearchResponse $this$load_u24lambda_u240_u241 = MainAPIKt.newMovieSearchResponse$default(kartoons2, str4, getMainUrl() + "/api/" + rel2.getType() + "s/" + rel2.getSlug(), TvType.Movie, false, (Function1) null, 24, (Object) null);
                    $this$load_u24lambda_u240_u241.setPosterUrl(rel2.getImage());
                    destination$iv$iv.add($this$load_u24lambda_u240_u241);
                    $this$map$iv = $this$map$iv3;
                    $this$mapTo$iv$iv = $this$mapTo$iv$iv;
                    str5 = str5;
                }
                str3 = str5;
                recommendations = (List) destination$iv$iv;
                if (tvtag == TvType.TvSeries) {
                    TvType tvType3 = TvType.Movie;
                    description3 = description2;
                    C00074 c00075 = new C00074(poster, backgroundPoster, description3, startYear2, rating2, list, recommendations, null);
                    c00052.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c00052.L$1 = SpillingKt.nullOutSpilledVariable(json);
                    c00052.L$2 = SpillingKt.nullOutSpilledVariable(res);
                    c00052.L$3 = SpillingKt.nullOutSpilledVariable(title2);
                    c00052.L$4 = SpillingKt.nullOutSpilledVariable(description3);
                    c00052.L$5 = SpillingKt.nullOutSpilledVariable(poster);
                    c00052.L$6 = SpillingKt.nullOutSpilledVariable(backgroundPoster);
                    c00052.L$7 = SpillingKt.nullOutSpilledVariable(startYear2);
                    c00052.L$8 = SpillingKt.nullOutSpilledVariable(rating2);
                    c00052.L$9 = SpillingKt.nullOutSpilledVariable(list);
                    c00052.L$10 = SpillingKt.nullOutSpilledVariable(href2);
                    c00052.L$11 = SpillingKt.nullOutSpilledVariable(tvtag);
                    c00052.L$12 = SpillingKt.nullOutSpilledVariable(recommendations);
                    c00052.label = 4;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, title2, url2, tvType3, href2, c00075, c00052);
                    if (objNewMovieLoadResponse == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    tvtag2 = tvtag;
                    res2 = res;
                    title3 = title2;
                    title4 = poster;
                    backgroundPoster2 = backgroundPoster;
                    startYear3 = startYear2;
                    rating3 = rating2;
                    list2 = list;
                    recommendations2 = recommendations;
                    json2 = json;
                    href3 = href2;
                    return (LoadResponse) objNewMovieLoadResponse;
                }
                String mainUrl2 = getMainUrl();
                c00052.L$0 = url2;
                c00052.L$1 = SpillingKt.nullOutSpilledVariable(json);
                c00052.L$2 = SpillingKt.nullOutSpilledVariable(res);
                c00052.L$3 = title2;
                c00052.L$4 = description2;
                c00052.L$5 = poster;
                c00052.L$6 = backgroundPoster;
                c00052.L$7 = startYear2;
                c00052.L$8 = rating2;
                c00052.L$9 = list;
                c00052.L$10 = SpillingKt.nullOutSpilledVariable(href2);
                c00052.L$11 = SpillingKt.nullOutSpilledVariable(tvtag);
                c00052.L$12 = recommendations;
                c00052.label = 2;
                objFetchSeasonDetailsForShow = fetchSeasonDetailsForShow(res, mainUrl2, c00052);
                if (objFetchSeasonDetailsForShow == coroutine_suspended) {
                    return coroutine_suspended;
                }
                res3 = res;
                backgroundPoster3 = backgroundPoster;
                startYear4 = startYear2;
                poster2 = poster;
                rating4 = rating2;
                list3 = list;
                href4 = href2;
                tvtag3 = tvtag;
                backgroundPoster4 = url2;
                json3 = json;
                recommendations3 = recommendations;
                description4 = description2;
                poster3 = title2;
                allSeasonDetails = (List) objFetchSeasonDetailsForShow;
                episodesList = new ArrayList();
                $this$forEach$iv = allSeasonDetails;
                while (r7.hasNext()) {
                    season = (SeasonEpisodes) element$iv;
                    seasonNumber = season.getSeasonNumber();
                    if (seasonNumber != null) {
                        seasonNumber2 = (int) seasonNumber.longValue();
                        $this$forEach$iv2 = season.getEpisodes();
                        while (r18.hasNext()) {
                            Iterable $this$forEach$iv4 = $this$forEach$iv2;
                            final EpisodeItem ep2 = (EpisodeItem) element$iv2;
                            episodesList.add(MainAPIKt.newEpisode(this, getMainUrl() + "/api/shows/episode/" + ep2.getId() + str3, new Function1() { // from class: com.Kartoons.Kartoons$$ExternalSyntheticLambda1
                                public final Object invoke(Object obj) {
                                    return Kartoons.load$lambda$1$0$0(seasonNumber2, ep2, (Episode) obj);
                                }
                            }));
                            $this$forEach$iv2 = $this$forEach$iv4;
                            allSeasonDetails = allSeasonDetails;
                            $this$forEach$iv = $this$forEach$iv;
                            tvtag3 = tvtag3;
                            href4 = href4;
                        }
                    }
                    json3 = json3;
                    allSeasonDetails = allSeasonDetails;
                    $this$forEach$iv = $this$forEach$iv;
                    tvtag3 = tvtag3;
                    href4 = href4;
                }
                TvType tvType4 = TvType.TvSeries;
                C00063 c00064 = new C00063(poster2, backgroundPoster3, description4, startYear4, rating4, list3, recommendations3, null);
                c00052.L$0 = SpillingKt.nullOutSpilledVariable(backgroundPoster4);
                c00052.L$1 = SpillingKt.nullOutSpilledVariable(json3);
                c00052.L$2 = SpillingKt.nullOutSpilledVariable(res3);
                c00052.L$3 = SpillingKt.nullOutSpilledVariable(poster3);
                c00052.L$4 = SpillingKt.nullOutSpilledVariable(description4);
                c00052.L$5 = SpillingKt.nullOutSpilledVariable(poster2);
                c00052.L$6 = SpillingKt.nullOutSpilledVariable(backgroundPoster3);
                c00052.L$7 = SpillingKt.nullOutSpilledVariable(startYear4);
                c00052.L$8 = SpillingKt.nullOutSpilledVariable(rating4);
                c00052.L$9 = SpillingKt.nullOutSpilledVariable(list3);
                c00052.L$10 = SpillingKt.nullOutSpilledVariable(href4);
                c00052.L$11 = SpillingKt.nullOutSpilledVariable(tvtag3);
                c00052.L$12 = SpillingKt.nullOutSpilledVariable(recommendations3);
                c00052.L$13 = SpillingKt.nullOutSpilledVariable(allSeasonDetails);
                c00052.L$14 = SpillingKt.nullOutSpilledVariable(episodesList);
                c00052.label = 3;
                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, poster3, backgroundPoster4, tvType4, episodesList, c00064, c00052);
                if (objNewTvSeriesLoadResponse == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return (LoadResponse) objNewTvSeriesLoadResponse;
            case 2:
                List recommendations4 = (List) c00052.L$12;
                TvType tvtag4 = (TvType) c00052.L$11;
                String href5 = (String) c00052.L$10;
                List<String> list4 = (List) c00052.L$9;
                Score rating5 = (Score) c00052.L$8;
                Integer startYear5 = (Integer) c00052.L$7;
                String backgroundPoster5 = (String) c00052.L$6;
                String poster4 = (String) c00052.L$5;
                String description5 = (String) c00052.L$4;
                String title6 = (String) c00052.L$3;
                res3 = (LoadData) c00052.L$2;
                Load json4 = (Load) c00052.L$1;
                String url4 = (String) c00052.L$0;
                ResultKt.throwOnFailure($result);
                list3 = list4;
                rating4 = rating5;
                startYear4 = startYear5;
                str3 = "/links";
                backgroundPoster3 = backgroundPoster5;
                poster2 = poster4;
                objFetchSeasonDetailsForShow = $result;
                recommendations3 = recommendations4;
                backgroundPoster4 = url4;
                tvtag3 = tvtag4;
                href4 = href5;
                json3 = json4;
                description4 = description5;
                poster3 = title6;
                allSeasonDetails = (List) objFetchSeasonDetailsForShow;
                episodesList = new ArrayList();
                $this$forEach$iv = allSeasonDetails;
                while (r7.hasNext()) {
                    season = (SeasonEpisodes) element$iv;
                    seasonNumber = season.getSeasonNumber();
                    if (seasonNumber != null) {
                        seasonNumber2 = (int) seasonNumber.longValue();
                        $this$forEach$iv2 = season.getEpisodes();
                        while (r18.hasNext()) {
                            Iterable $this$forEach$iv5 = $this$forEach$iv2;
                            final EpisodeItem ep3 = (EpisodeItem) element$iv2;
                            episodesList.add(MainAPIKt.newEpisode(this, getMainUrl() + "/api/shows/episode/" + ep3.getId() + str3, new Function1() { // from class: com.Kartoons.Kartoons$$ExternalSyntheticLambda1
                                public final Object invoke(Object obj) {
                                    return Kartoons.load$lambda$1$0$0(seasonNumber2, ep3, (Episode) obj);
                                }
                            }));
                            $this$forEach$iv2 = $this$forEach$iv5;
                            allSeasonDetails = allSeasonDetails;
                            $this$forEach$iv = $this$forEach$iv;
                            tvtag3 = tvtag3;
                            href4 = href4;
                        }
                    }
                    json3 = json3;
                    allSeasonDetails = allSeasonDetails;
                    $this$forEach$iv = $this$forEach$iv;
                    tvtag3 = tvtag3;
                    href4 = href4;
                }
                TvType tvType5 = TvType.TvSeries;
                C00063 c00065 = new C00063(poster2, backgroundPoster3, description4, startYear4, rating4, list3, recommendations3, null);
                c00052.L$0 = SpillingKt.nullOutSpilledVariable(backgroundPoster4);
                c00052.L$1 = SpillingKt.nullOutSpilledVariable(json3);
                c00052.L$2 = SpillingKt.nullOutSpilledVariable(res3);
                c00052.L$3 = SpillingKt.nullOutSpilledVariable(poster3);
                c00052.L$4 = SpillingKt.nullOutSpilledVariable(description4);
                c00052.L$5 = SpillingKt.nullOutSpilledVariable(poster2);
                c00052.L$6 = SpillingKt.nullOutSpilledVariable(backgroundPoster3);
                c00052.L$7 = SpillingKt.nullOutSpilledVariable(startYear4);
                c00052.L$8 = SpillingKt.nullOutSpilledVariable(rating4);
                c00052.L$9 = SpillingKt.nullOutSpilledVariable(list3);
                c00052.L$10 = SpillingKt.nullOutSpilledVariable(href4);
                c00052.L$11 = SpillingKt.nullOutSpilledVariable(tvtag3);
                c00052.L$12 = SpillingKt.nullOutSpilledVariable(recommendations3);
                c00052.L$13 = SpillingKt.nullOutSpilledVariable(allSeasonDetails);
                c00052.L$14 = SpillingKt.nullOutSpilledVariable(episodesList);
                c00052.label = 3;
                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, poster3, backgroundPoster4, tvType5, episodesList, c00065, c00052);
                if (objNewTvSeriesLoadResponse == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return (LoadResponse) objNewTvSeriesLoadResponse;
            case 3:
                ResultKt.throwOnFailure($result);
                objNewTvSeriesLoadResponse = $result;
                return (LoadResponse) objNewTvSeriesLoadResponse;
            case 4:
                List recommendations5 = (List) c00052.L$12;
                TvType tvtag5 = (TvType) c00052.L$11;
                href3 = (String) c00052.L$10;
                list2 = (List) c00052.L$9;
                rating3 = (Score) c00052.L$8;
                startYear3 = (Integer) c00052.L$7;
                backgroundPoster2 = (String) c00052.L$6;
                title4 = (String) c00052.L$5;
                String description6 = (String) c00052.L$4;
                title3 = (String) c00052.L$3;
                res2 = (LoadData) c00052.L$2;
                json2 = (Load) c00052.L$1;
                ResultKt.throwOnFailure($result);
                tvtag2 = tvtag5;
                description3 = description6;
                objNewMovieLoadResponse = $result;
                recommendations2 = recommendations5;
                return (LoadResponse) objNewMovieLoadResponse;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$1$0$0(int $seasonNumber, EpisodeItem $ep, Episode $this$newEpisode) {
        $this$newEpisode.setSeason(Integer.valueOf($seasonNumber));
        Long episodeNumber = $ep.getEpisodeNumber();
        $this$newEpisode.setEpisode(episodeNumber != null ? Integer.valueOf((int) episodeNumber.longValue()) : 0);
        String title = $ep.getTitle();
        if (title == null) {
            title = "";
        }
        $this$newEpisode.setName(title);
        $this$newEpisode.setPosterUrl($ep.getImage());
        $this$newEpisode.setDescription($ep.getDescription());
        Long durationMinutes = $ep.getDurationMinutes();
        $this$newEpisode.setRunTime(durationMinutes != null ? Integer.valueOf((int) durationMinutes.longValue()) : null);
        EpisodeCreatedAt createdAt = $ep.getCreatedAt();
        MainAPIKt.addDate$default($this$newEpisode, String.valueOf(createdAt != null ? createdAt.getIso() : null), (String) null, 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.Kartoons.Kartoons$load$3 */
    /* JADX INFO: compiled from: Kartoons.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Kartoons.Kartoons$load$3", f = "Kartoons.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00063 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $backgroundPoster;
        final /* synthetic */ String $description;
        final /* synthetic */ String $poster;
        final /* synthetic */ Score $rating;
        final /* synthetic */ List<MovieSearchResponse> $recommendations;
        final /* synthetic */ Integer $startYear;
        final /* synthetic */ List<String> $tags;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00063(String str, String str2, String str3, Integer num, Score score, List<String> list, List<MovieSearchResponse> list2, Continuation<? super C00063> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$backgroundPoster = str2;
            this.$description = str3;
            this.$startYear = num;
            this.$rating = score;
            this.$tags = list;
            this.$recommendations = list2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00063 = new C00063(this.$poster, this.$backgroundPoster, this.$description, this.$startYear, this.$rating, this.$tags, this.$recommendations, continuation);
            c00063.L$0 = obj;
            return c00063;
        }

        public final Object invoke(TvSeriesLoadResponse tvSeriesLoadResponse, Continuation<? super Unit> continuation) {
            return create(tvSeriesLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            TvSeriesLoadResponse $this$newTvSeriesLoadResponse = (TvSeriesLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$newTvSeriesLoadResponse.setPosterUrl(this.$poster);
                    $this$newTvSeriesLoadResponse.setBackgroundPosterUrl(this.$backgroundPoster);
                    $this$newTvSeriesLoadResponse.setPlot(this.$description);
                    $this$newTvSeriesLoadResponse.setYear(this.$startYear);
                    $this$newTvSeriesLoadResponse.setScore(this.$rating);
                    $this$newTvSeriesLoadResponse.setTags(this.$tags);
                    $this$newTvSeriesLoadResponse.setRecommendations(this.$recommendations);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.Kartoons.Kartoons$load$4 */
    /* JADX INFO: compiled from: Kartoons.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Kartoons.Kartoons$load$4", f = "Kartoons.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00074 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $backgroundPoster;
        final /* synthetic */ String $description;
        final /* synthetic */ String $poster;
        final /* synthetic */ Score $rating;
        final /* synthetic */ List<MovieSearchResponse> $recommendations;
        final /* synthetic */ Integer $startYear;
        final /* synthetic */ List<String> $tags;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00074(String str, String str2, String str3, Integer num, Score score, List<String> list, List<MovieSearchResponse> list2, Continuation<? super C00074> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$backgroundPoster = str2;
            this.$description = str3;
            this.$startYear = num;
            this.$rating = score;
            this.$tags = list;
            this.$recommendations = list2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00074 = new C00074(this.$poster, this.$backgroundPoster, this.$description, this.$startYear, this.$rating, this.$tags, this.$recommendations, continuation);
            c00074.L$0 = obj;
            return c00074;
        }

        public final Object invoke(MovieLoadResponse movieLoadResponse, Continuation<? super Unit> continuation) {
            return create(movieLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            MovieLoadResponse $this$newMovieLoadResponse = (MovieLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$newMovieLoadResponse.setPosterUrl(this.$poster);
                    $this$newMovieLoadResponse.setBackgroundPosterUrl(this.$backgroundPoster);
                    $this$newMovieLoadResponse.setPlot(this.$description);
                    $this$newMovieLoadResponse.setYear(this.$startYear);
                    $this$newMovieLoadResponse.setScore(this.$rating);
                    $this$newMovieLoadResponse.setTags(this.$tags);
                    $this$newMovieLoadResponse.setRecommendations(this.$recommendations);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x010f  */
    /* JADX WARN: Code duplicated, block: B:35:0x011e  */
    /* JADX WARN: Code duplicated, block: B:36:0x0126  */
    /* JADX WARN: Code duplicated, block: B:42:0x0144  */
    /* JADX WARN: Code duplicated, block: B:45:0x019c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:46:0x019d  */
    /* JADX WARN: Code duplicated, block: B:48:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:63:0x0203 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:64:0x013a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x019d -> B:47:0x01ad). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:31:0x0109
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object loadLinks(@org.jetbrains.annotations.NotNull java.lang.String r27, boolean r28, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r29, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r30, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r31) {
        /*
            Method dump skipped, instruction units count: 548
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.Kartoons.Kartoons.loadLinks(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Regex getENC_LINE_REGEX() {
        return (Regex) this.ENC_LINE_REGEX.getValue();
    }

    static final Regex ENC_LINE_REGEX_delegate$lambda$0() {
        return new Regex("^enc\\d+:.+", RegexOption.IGNORE_CASE);
    }

    @NotNull
    public Interceptor getVideoInterceptor(@NotNull ExtractorLink extractorLink) {
        return new Interceptor() { // from class: com.Kartoons.Kartoons$$ExternalSyntheticLambda5
            public final Response intercept(Interceptor.Chain chain) {
                return Kartoons.getVideoInterceptor$lambda$0(this.f$0, chain);
            }
        };
    }

    static final Response getVideoInterceptor$lambda$0(final Kartoons this$0, Interceptor.Chain chain) {
        String string;
        Request request = chain.request();
        String url = request.url().toString();
        Log.INSTANCE.d(this$0.getName(), "Request URL: " + url);
        Request.Builder builder = request.newBuilder().header("Origin", "https://kartoons.me").header("Referer", "https://kartoons.me/").header("Accept", "*/*").header("Accept-Language", "en-US,en;q=0.9").header("Sec-Fetch-Dest", "empty").header("Sec-Fetch-Mode", "cors").header("Sec-Fetch-Site", "cross-site");
        String savedUa = KartoonsPlugin.INSTANCE.getCfUserAgent();
        String ua = savedUa.length() > 0 ? savedUa : "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36";
        builder.header("User-Agent", ua);
        String savedCookies = KartoonsPlugin.INSTANCE.getCfCookies();
        if (savedCookies.length() > 0) {
            builder.header("Cookie", savedCookies);
        }
        Request newRequest = builder.build();
        Response response = chain.proceed(newRequest);
        ResponseBody body = response.body();
        MediaType contentType = body.contentType();
        if (StringsKt.contains(url, "/segment/", true) || StringsKt.endsWith(url, ".ts", true)) {
            Log.INSTANCE.d(this$0.getName(), "Segment URL detected, skipping rewrite");
            return response;
        }
        boolean isPlaylistUrl = StringsKt.endsWith(url, ".m3u8", true) || StringsKt.contains(url, "playlist", true) || StringsKt.contains(url, ".m3u8", true);
        if (contentType == null || (string = contentType.toString()) == null) {
            string = "";
        }
        String ctString = string;
        boolean isPlaylistContentType = StringsKt.contains(ctString, "mpegurl", true) || StringsKt.contains(ctString, "m3u8", true);
        if (!isPlaylistUrl && !isPlaylistContentType) {
            Log.INSTANCE.d(this$0.getName(), "Not a playlist response, skipping rewrite");
            return response;
        }
        try {
            String originalText = body.string();
            Log.INSTANCE.d(this$0.getName(), "Original playlist:\n" + originalText);
            if (!StringsKt.contains(originalText, "enc2:", true)) {
                Log.INSTANCE.d(this$0.getName(), "No enc lines found, returning original playlist");
                return response.newBuilder().body(ResponseBody.Companion.create(originalText, contentType)).build();
            }
            final Regex uriRegex = new Regex("URI=\"(enc\\d+:[^\"]+)\"");
            String rewritten = SequencesKt.joinToString$default(StringsKt.lineSequence(originalText), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.Kartoons.Kartoons$$ExternalSyntheticLambda2
                public final Object invoke(Object obj) {
                    return Kartoons.getVideoInterceptor$lambda$0$0(this.f$0, uriRegex, (String) obj);
                }
            }, 30, (Object) null);
            Log.INSTANCE.d(this$0.getName(), "Rewritten playlist:\n" + rewritten);
            return response.newBuilder().body(ResponseBody.Companion.create(rewritten, contentType)).build();
        } catch (Exception e) {
            Log.INSTANCE.e(this$0.getName(), "Failed to read playlist body: " + e.getMessage());
            return response;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence getVideoInterceptor$lambda$0$0(final Kartoons this$0, Regex $uriRegex, String rawLine) {
        String line = StringsKt.trimEnd(rawLine).toString();
        String trimmed = StringsKt.trimStart(line).toString();
        if (this$0.getENC_LINE_REGEX().matches(trimmed)) {
            Log.INSTANCE.d(this$0.getName(), "Found encrypted line: " + trimmed);
            String decrypted = UtilsKt.decryptStream$default(trimmed, null, 2, null);
            Log.INSTANCE.d(this$0.getName(), "Decrypted line: " + (decrypted == null ? "FAILED" : decrypted));
            return decrypted != null ? decrypted : line;
        }
        if (StringsKt.contains$default(line, "URI=\"enc", false, 2, (Object) null)) {
            line = $uriRegex.replace(line, new Function1() { // from class: com.Kartoons.Kartoons$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    return Kartoons.getVideoInterceptor$lambda$0$0$0(this.f$0, (MatchResult) obj);
                }
            });
        }
        return line;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence getVideoInterceptor$lambda$0$0$0(Kartoons this$0, MatchResult match) {
        String encrypted = (String) match.getGroupValues().get(1);
        Log.INSTANCE.d(this$0.getName(), "Found encrypted URI: " + encrypted);
        String decrypted = UtilsKt.decryptStream$default(encrypted, null, 2, null);
        Log.INSTANCE.d(this$0.getName(), "Decrypted URI: " + (decrypted == null ? "FAILED" : decrypted));
        return "URI=\"" + (decrypted == null ? encrypted : decrypted) + '\"';
    }

    /* JADX INFO: renamed from: com.Kartoons.Kartoons$fetchSeasonDetailsForShow$2 */
    /* JADX INFO: compiled from: Kartoons.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/Kartoons/SeasonEpisodes;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Kartoons.Kartoons$fetchSeasonDetailsForShow$2", f = "Kartoons.kt", i = {0, 0}, l = {519}, m = "invokeSuspend", n = {"$this$coroutineScope", "showSlug"}, nl = {520}, s = {"L$0", "L$1"}, v = 2)
    @SourceDebugExtension({"SMAP\nKartoons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Kartoons.kt\ncom/Kartoons/Kartoons$fetchSeasonDetailsForShow$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,527:1\n1795#2,10:528\n2068#2:538\n2069#2:540\n1805#2:541\n1#3:539\n*S KotlinDebug\n*F\n+ 1 Kartoons.kt\ncom/Kartoons/Kartoons$fetchSeasonDetailsForShow$2\n*L\n502#1:528,10\n502#1:538\n502#1:540\n502#1:541\n502#1:539\n*E\n"})
    static final class C00032 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends SeasonEpisodes>>, Object> {
        final /* synthetic */ String $mainUrl;
        final /* synthetic */ LoadData $showData;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ Kartoons this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00032(LoadData loadData, String str, Kartoons kartoons, Continuation<? super C00032> continuation) {
            super(2, continuation);
            this.$showData = loadData;
            this.$mainUrl = str;
            this.this$0 = kartoons;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00032 = new C00032(this.$showData, this.$mainUrl, this.this$0, continuation);
            c00032.L$0 = obj;
            return c00032;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<SeasonEpisodes>> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object objAwaitAll;
            CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String slug = this.$showData.getSlug();
                    if (slug == null) {
                        return CollectionsKt.emptyList();
                    }
                    String showSlug = slug;
                    Iterable seasons = this.$showData.getSeasons();
                    if (seasons == null) {
                        seasons = CollectionsKt.emptyList();
                    }
                    Iterable $this$mapNotNull$iv = seasons;
                    String str = this.$mainUrl;
                    Kartoons kartoons = this.this$0;
                    Collection destination$iv$iv = new ArrayList();
                    for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                        Season season = (Season) element$iv$iv$iv;
                        String seasonSlug = season.getSlug();
                        Deferred deferredAsync$default = seasonSlug == null ? null : BuildersKt.async$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new Kartoons$fetchSeasonDetailsForShow$2$1$1(str, showSlug, seasonSlug, kartoons, null), 3, (Object) null);
                        if (deferredAsync$default != null) {
                            destination$iv$iv.add(deferredAsync$default);
                        }
                        showSlug = showSlug;
                        str = str;
                        kartoons = kartoons;
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$coroutineScope);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(showSlug);
                    this.label = 1;
                    objAwaitAll = AwaitKt.awaitAll((List) destination$iv$iv, (Continuation) this);
                    if (objAwaitAll == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    objAwaitAll = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return CollectionsKt.filterNotNull((Iterable) objAwaitAll);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object fetchSeasonDetailsForShow(LoadData showData, String mainUrl, Continuation<? super List<SeasonEpisodes>> continuation) {
        return CoroutineScopeKt.coroutineScope(new C00032(showData, mainUrl, this, null), continuation);
    }
}
