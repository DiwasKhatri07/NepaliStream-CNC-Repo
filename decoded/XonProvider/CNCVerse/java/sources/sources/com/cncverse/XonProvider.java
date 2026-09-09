package com.cncverse;

import android.content.Context;
import com.cncverse.donation.DonationManager;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.RuntimeJsonMappingException;
import com.fasterxml.jackson.module.kotlin.ExtensionsKt;
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
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvSeriesSearchResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
import com.lagradost.cloudstream3.utils.Qualities;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.net.URI;
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
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
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
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: XonProvider.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/XonProvider/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 X2\u00020\u0001:\u0005XYZ[\\B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u001fH\u0002J\u000e\u0010*\u001a\u00020+H\u0082@¢\u0006\u0002\u0010,J\u000e\u0010-\u001a\u00020+H\u0086@¢\u0006\u0002\u0010,J\u0010\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u0005H\u0002J\f\u00100\u001a\u00020\u0005*\u00020%H\u0002J\f\u00101\u001a\u00020\u0005*\u00020%H\u0002J\f\u00101\u001a\u00020\u0005*\u00020'H\u0002J\u001e\u00104\u001a\u0002062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0096@¢\u0006\u0002\u0010;J\u001e\u0010=\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00050>2\u0006\u0010?\u001a\u00020\u0005H\u0002J\u001c\u0010@\u001a\b\u0012\u0004\u0012\u00020A0$2\u0006\u0010?\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010BJ\u0018\u0010C\u001a\u0004\u0018\u00010D2\u0006\u0010/\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010BJF\u0010E\u001a\u00020\u000e2\u0006\u0010F\u001a\u00020\u00052\u0006\u0010G\u001a\u00020\u000e2\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020+0I2\u0012\u0010K\u001a\u000e\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020+0IH\u0096@¢\u0006\u0002\u0010MJB\u0010N\u001a\u00020+2\u0006\u0010O\u001a\u00020\u00052\u0006\u0010P\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020\u00052\u0006\u0010R\u001a\u00020\u00052\u0012\u0010K\u001a\u000e\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020+0IH\u0082@¢\u0006\u0002\u0010SJ&\u0010T\u001a\u00020L2\u0006\u0010U\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u00052\u0006\u0010V\u001a\u000208H\u0082@¢\u0006\u0002\u0010WR\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010 \u001a\n \"*\u0004\u0018\u00010!0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020'0$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00102\u001a\b\u0012\u0004\u0012\u0002030$X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0014\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00050$X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006]"}, d2 = {"Lcom/cncverse/XonProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "apiKey", "callerName", "configExpireTime", "", "configFetched", "getHeaders", "", "mapper", "Lcom/fasterxml/jackson/databind/ObjectMapper;", "kotlin.jvm.PlatformType", "cachedMovies", "", "Lcom/cncverse/XonProvider$Movie;", "cachedEpisodes", "Lcom/cncverse/XonProvider$Episode;", "lastCacheTime", "cacheRefreshInterval", "fetchRemoteConfig", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshCache", "formatUrl", "url", "bestPoster", "displayName", "mainPage", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "knownLanguages", "extractLanguageFromQuery", "Lkotlin/Pair;", "query", "search", "Lcom/lagradost/cloudstream3/SearchResponse;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addVideoLinks", "basic", "sd", "hd", "fhd", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "makeLink", "label", "quality", "(Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "Movie", "MoviesResponse", "Episode", "EpisodesResponse", "XonProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nXonProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 XonProvider.kt\ncom/cncverse/XonProvider\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 6 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,515:1\n1#2:516\n1#2:528\n1#2:541\n116#3:517\n54#3:518\n117#3:519\n61#3,8:520\n71#3:529\n116#3:530\n54#3:531\n117#3:532\n61#3,8:533\n71#3:542\n777#4:543\n873#4,2:544\n1586#4:546\n1661#4,3:547\n777#4:550\n873#4,2:551\n1586#4:553\n1661#4,3:554\n1586#4:557\n1661#4,3:558\n1512#4:561\n1538#4,3:562\n1541#4,3:572\n1586#4:576\n1661#4,3:577\n296#4:581\n1807#4,3:582\n297#4:585\n832#4:586\n862#4,2:587\n777#4:589\n873#4,2:590\n1915#4,2:592\n777#4:594\n873#4,2:595\n1915#4,2:597\n777#4:599\n873#4,2:600\n1586#4:602\n1661#4,3:603\n1205#4,2:606\n1282#4,4:608\n1586#4:612\n1661#4,3:613\n383#5,7:565\n221#6:575\n222#6:580\n*S KotlinDebug\n*F\n+ 1 XonProvider.kt\ncom/cncverse/XonProvider\n*L\n195#1:528\n200#1:541\n195#1:517\n195#1:518\n195#1:519\n195#1:520,8\n195#1:529\n200#1:530\n200#1:531\n200#1:532\n200#1:533,8\n200#1:542\n250#1:543\n250#1:544,2\n252#1:546\n252#1:547,3\n262#1:550\n262#1:551,2\n264#1:553\n264#1:554,3\n274#1:557\n274#1:558,3\n284#1:561\n284#1:562,3\n284#1:572,3\n286#1:576\n286#1:577,3\n318#1:581\n319#1:582,3\n318#1:585\n322#1:586\n322#1:587,2\n334#1:589\n334#1:590,2\n347#1:592,2\n356#1:594\n356#1:595,2\n366#1:597,2\n414#1:599\n414#1:600,2\n419#1:602\n419#1:603,3\n420#1:606,2\n420#1:608,4\n422#1:612\n422#1:613,3\n284#1:565,7\n285#1:575\n285#1:580\n*E\n"})
public final class XonProvider extends MainAPI {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static Context context;
    private long configExpireTime;
    private boolean configFetched;
    private long lastCacheTime;

    @NotNull
    private String mainUrl = "https://xon-avens.xyz/apis";

    @NotNull
    private String name = "Xon";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "ta";

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.TvSeries, TvType.Anime});

    @NotNull
    private String apiKey = "553y845hfhdlfhjkl438943943839443943fdhdkfjfj9834lnfd98";

    @NotNull
    private String callerName = "vion-official-app";
    private final ObjectMapper mapper = ExtensionsKt.jacksonObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    @NotNull
    private List<Movie> cachedMovies = CollectionsKt.emptyList();

    @NotNull
    private List<Episode> cachedEpisodes = CollectionsKt.emptyList();
    private final long cacheRefreshInterval = 86400000;

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("trending", "Trending"), TuplesKt.to("latest_episodes", "Latest Episodes"), TuplesKt.to("movies", "Movies")});

    @NotNull
    private final List<String> knownLanguages = CollectionsKt.listOf(new String[]{"tamil", "hindi", "telugu", "malayalam", "kannada", "english", "bengali", "marathi", "punjabi", "gujarati", "odia", "urdu", "assamese", "japanese", "korean", "chinese"});

    /* JADX INFO: renamed from: com.cncverse.XonProvider$addVideoLinks$1 */
    /* JADX INFO: compiled from: XonProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.XonProvider", f = "XonProvider.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3}, l = {502, 503, 504, 505}, m = "addVideoLinks", n = {"basic", "sd", "hd", "fhd", "callback", "basic", "sd", "hd", "fhd", "callback", "basic", "sd", "hd", "fhd", "callback", "basic", "sd", "hd", "fhd", "callback"}, nl = {503, 504, 505, 506}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"}, v = 2)
    static final class C00061 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C00061(Continuation<? super C00061> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return XonProvider.this.addVideoLinks(null, null, null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.XonProvider$fetchRemoteConfig$1 */
    /* JADX INFO: compiled from: XonProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.XonProvider", f = "XonProvider.kt", i = {}, l = {163}, m = "fetchRemoteConfig", n = {}, nl = {164}, s = {}, v = 2)
    static final class C00071 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C00071(Continuation<? super C00071> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return XonProvider.this.fetchRemoteConfig((Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.XonProvider$getMainPage$1 */
    /* JADX INFO: compiled from: XonProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.XonProvider", f = "XonProvider.kt", i = {0, 0}, l = {243}, m = "getMainPage", n = {"request", "page"}, nl = {244}, s = {"L$0", "I$0"}, v = 2)
    static final class C00081 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00081(Continuation<? super C00081> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return XonProvider.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.XonProvider$load$1 */
    /* JADX INFO: compiled from: XonProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.XonProvider", f = "XonProvider.kt", i = {0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {380, 392, 436}, m = "load", n = {"url", "url", "str", "parts", "type", "movie", "id", "url", "str", "parts", "type", "ep", "showEpisodes", "seasonIds", "seasonNoMap", "episodeList", "showTitle", "langLabel", "displayTitle", "id"}, nl = {381, 410, 452}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "I$0"}, v = 2)
    static final class C00091 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
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

        C00091(Continuation<? super C00091> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return XonProvider.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.XonProvider$loadLinks$1 */
    /* JADX INFO: compiled from: XonProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.XonProvider", f = "XonProvider.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6}, l = {464, 475, 476, 477, 482, 483, 484}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "isCasting", "data", "subtitleCallback", "callback", "str", "parts", "type", "ep", "isCasting", "id", "data", "subtitleCallback", "callback", "str", "parts", "type", "ep", "isCasting", "id", "data", "subtitleCallback", "callback", "str", "parts", "type", "ep", "isCasting", "id", "data", "subtitleCallback", "callback", "str", "parts", "type", "movie", "isCasting", "id", "data", "subtitleCallback", "callback", "str", "parts", "type", "movie", "isCasting", "id", "data", "subtitleCallback", "callback", "str", "parts", "type", "movie", "isCasting", "id"}, nl = {465, 476, 477, 480, 483, 484, 487}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "I$0"}, v = 2)
    static final class C00121 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00121(Continuation<? super C00121> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return XonProvider.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.XonProvider$refreshCache$1 */
    /* JADX INFO: compiled from: XonProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.XonProvider", f = "XonProvider.kt", i = {0, 1, 1, 2, 2, 2, 2}, l = {180, 194, 199}, m = "refreshCache", n = {"currentTime", "headers", "currentTime", "headers", "moviesRaw", "moviesResponse", "currentTime"}, nl = {183, 195, 200}, s = {"J$0", "L$0", "J$0", "L$0", "L$1", "L$2", "J$0"}, v = 2)
    static final class C00141 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00141(Continuation<? super C00141> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return XonProvider.this.refreshCache((Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.XonProvider$search$1 */
    /* JADX INFO: compiled from: XonProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.XonProvider", f = "XonProvider.kt", i = {0}, l = {328}, m = "search", n = {"query"}, nl = {329}, s = {"L$0"}, v = 2)
    static final class C00151 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00151(Continuation<? super C00151> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return XonProvider.this.search(null, (Continuation) this);
        }
    }

    /* JADX INFO: compiled from: XonProvider.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/cncverse/XonProvider$Companion;", "", "<init>", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "XonProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Nullable
        public final Context getContext() {
            return XonProvider.context;
        }

        public final void setContext(@Nullable Context context) {
            XonProvider.context = context;
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

    private final Map<String, String> getHeaders() {
        String host = "xon-avens.xyz";
        try {
            String host2 = new URI(getMainUrl()).getHost();
            if (host2 != null) {
                host = host2;
            }
        } catch (Exception e) {
        }
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("Accept-Encoding", "gzip"), TuplesKt.to("API", this.apiKey), TuplesKt.to("CALLER", this.callerName), TuplesKt.to("Connection", "Keep-Alive"), TuplesKt.to("Host", host), TuplesKt.to("User-Agent", "okhttp/5.3.2")});
    }

    /* JADX INFO: compiled from: XonProvider.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\bl\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u008f\u0003\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0003\u0010\u000e\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0003\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0014\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0003\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0018\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0019\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u001a\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u001b\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u001c\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u001e\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0003\u0010\u001f\u001a\u00020\u0003\u0012\n\b\u0003\u0010 \u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010!\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\"\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0003\u0010#\u001a\u00020\u0003\u0012\n\b\u0003\u0010$\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010%\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010&\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b'\u0010(J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u0003HÆ\u0003J\t\u0010P\u001a\u00020\u0006HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010X\u001a\u00020\u0003HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010]\u001a\u00020\u0003HÆ\u0003J\t\u0010^\u001a\u00020\u0003HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010a\u001a\u00020\u0003HÆ\u0003J\t\u0010b\u001a\u00020\u0003HÆ\u0003J\t\u0010c\u001a\u00020\u0003HÆ\u0003J\t\u0010d\u001a\u00020\u0003HÆ\u0003J\t\u0010e\u001a\u00020\u0003HÆ\u0003J\t\u0010f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010i\u001a\u00020\u0003HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010m\u001a\u00020\u0003HÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010p\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0091\u0003\u0010q\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00062\b\b\u0003\u0010\u000e\u001a\u00020\u00032\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\b\u0003\u0010\u0013\u001a\u00020\u00032\b\b\u0003\u0010\u0014\u001a\u00020\u00032\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u00062\b\b\u0003\u0010\u0017\u001a\u00020\u00032\b\b\u0003\u0010\u0018\u001a\u00020\u00032\b\b\u0003\u0010\u0019\u001a\u00020\u00032\b\b\u0003\u0010\u001a\u001a\u00020\u00032\b\b\u0003\u0010\u001b\u001a\u00020\u00032\b\b\u0003\u0010\u001c\u001a\u00020\u00032\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u001e\u001a\u0004\u0018\u00010\u00062\b\b\u0003\u0010\u001f\u001a\u00020\u00032\n\b\u0003\u0010 \u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010!\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\"\u001a\u0004\u0018\u00010\u00062\b\b\u0003\u0010#\u001a\u00020\u00032\n\b\u0003\u0010$\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010%\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010&\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0014\u0010r\u001a\u00020s2\b\u0010t\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010u\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010v\u001a\u00020\u0006HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010*R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010-R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010-R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010-R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010-R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010-R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010-R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010-R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010*R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010-R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010-R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010-R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010-R\u0016\u0010\u0013\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010*R\u0016\u0010\u0014\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010*R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010-R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010-R\u0016\u0010\u0017\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010*R\u0016\u0010\u0018\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010*R\u0016\u0010\u0019\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010*R\u0016\u0010\u001a\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010*R\u0016\u0010\u001b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010*R\u0016\u0010\u001c\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010*R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010-R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010-R\u0016\u0010\u001f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010*R\u0018\u0010 \u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010-R\u0018\u0010!\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010-R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010-R\u0016\u0010#\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010*R\u0018\u0010$\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u0010-R\u0018\u0010%\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010-R\u0018\u0010&\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010-¨\u0006w"}, d2 = {"Lcom/cncverse/XonProvider$Movie;", "", "id", "", "no", "name", "", "poster", "cover", "genre", "des", "tags", "type", "trailer", "ttype", "basic", "sd", "hd", "fhd", "showId", "language", "showName", "languageName", "premium", "wfeathers", "bfeathers", "sfeathers", "trending", "special", "xPlayer2", "xPlayer3", "locked", "rating", "avgRuntime", "ageRating", "top10", "playCode", "createdAt", "updatedAt", "<init>", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;IIIIIILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()I", "getNo", "getName", "()Ljava/lang/String;", "getPoster", "getCover", "getGenre", "getDes", "getTags", "getType", "getTrailer", "getTtype", "getBasic", "getSd", "getHd", "getFhd", "getShowId", "getLanguage", "getShowName", "getLanguageName", "getPremium", "getWfeathers", "getBfeathers", "getSfeathers", "getTrending", "getSpecial", "getXPlayer2", "getXPlayer3", "getLocked", "getRating", "getAvgRuntime", "getAgeRating", "getTop10", "getPlayCode", "getCreatedAt", "getUpdatedAt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "copy", "equals", "", "other", "hashCode", "toString", "XonProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Movie {

        @JsonProperty("age_rating")
        @Nullable
        private final String ageRating;

        @JsonProperty("avg_runtime")
        @Nullable
        private final String avgRuntime;

        @JsonProperty("basic")
        @Nullable
        private final String basic;

        @JsonProperty("bfeathers")
        private final int bfeathers;

        @JsonProperty("cover")
        @Nullable
        private final String cover;

        @JsonProperty("created_at")
        @Nullable
        private final String createdAt;

        @JsonProperty("des")
        @Nullable
        private final String des;

        @JsonProperty("fhd")
        @Nullable
        private final String fhd;

        @JsonProperty("genre")
        @Nullable
        private final String genre;

        @JsonProperty("hd")
        @Nullable
        private final String hd;

        @JsonProperty("id")
        private final int id;

        @JsonProperty("language")
        private final int language;

        @JsonProperty("language_name")
        @Nullable
        private final String languageName;

        @JsonProperty("locked")
        private final int locked;

        @JsonProperty("name")
        @NotNull
        private final String name;

        @JsonProperty("no")
        private final int no;

        @JsonProperty("play_code")
        @Nullable
        private final String playCode;

        @JsonProperty("poster")
        @Nullable
        private final String poster;

        @JsonProperty("premium")
        private final int premium;

        @JsonProperty("rating")
        @Nullable
        private final String rating;

        @JsonProperty("sd")
        @Nullable
        private final String sd;

        @JsonProperty("sfeathers")
        private final int sfeathers;

        @JsonProperty("show_id")
        private final int showId;

        @JsonProperty("show_name")
        @Nullable
        private final String showName;

        @JsonProperty("special")
        private final int special;

        @JsonProperty("tags")
        @Nullable
        private final String tags;

        @JsonProperty("top10")
        private final int top10;

        @JsonProperty("trailer")
        @Nullable
        private final String trailer;

        @JsonProperty("trending")
        private final int trending;

        @JsonProperty("ttype")
        private final int ttype;

        @JsonProperty("type")
        @Nullable
        private final String type;

        @JsonProperty("updated_at")
        @Nullable
        private final String updatedAt;

        @JsonProperty("wfeathers")
        private final int wfeathers;

        @JsonProperty("xPlayer2")
        @Nullable
        private final String xPlayer2;

        @JsonProperty("xPlayer3")
        @Nullable
        private final String xPlayer3;

        public static /* synthetic */ Movie copy$default(Movie movie, int i, int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i3, String str9, String str10, String str11, String str12, int i4, int i5, String str13, String str14, int i6, int i7, int i8, int i9, int i10, int i11, String str15, String str16, int i12, String str17, String str18, String str19, int i13, String str20, String str21, String str22, int i14, int i15, Object obj) {
            String str23;
            String str24;
            int i16 = (i14 & 1) != 0 ? movie.id : i;
            int i17 = (i14 & 2) != 0 ? movie.no : i2;
            String str25 = (i14 & 4) != 0 ? movie.name : str;
            String str26 = (i14 & 8) != 0 ? movie.poster : str2;
            String str27 = (i14 & 16) != 0 ? movie.cover : str3;
            String str28 = (i14 & 32) != 0 ? movie.genre : str4;
            String str29 = (i14 & 64) != 0 ? movie.des : str5;
            String str30 = (i14 & 128) != 0 ? movie.tags : str6;
            String str31 = (i14 & 256) != 0 ? movie.type : str7;
            String str32 = (i14 & 512) != 0 ? movie.trailer : str8;
            int i18 = (i14 & 1024) != 0 ? movie.ttype : i3;
            String str33 = (i14 & 2048) != 0 ? movie.basic : str9;
            String str34 = (i14 & 4096) != 0 ? movie.sd : str10;
            String str35 = (i14 & 8192) != 0 ? movie.hd : str11;
            int i19 = i16;
            String str36 = (i14 & 16384) != 0 ? movie.fhd : str12;
            int i20 = (i14 & 32768) != 0 ? movie.showId : i4;
            int i21 = (i14 & 65536) != 0 ? movie.language : i5;
            String str37 = (i14 & 131072) != 0 ? movie.showName : str13;
            String str38 = (i14 & 262144) != 0 ? movie.languageName : str14;
            int i22 = (i14 & 524288) != 0 ? movie.premium : i6;
            int i23 = (i14 & 1048576) != 0 ? movie.wfeathers : i7;
            int i24 = (i14 & 2097152) != 0 ? movie.bfeathers : i8;
            int i25 = (i14 & 4194304) != 0 ? movie.sfeathers : i9;
            int i26 = (i14 & 8388608) != 0 ? movie.trending : i10;
            int i27 = (i14 & 16777216) != 0 ? movie.special : i11;
            String str39 = (i14 & 33554432) != 0 ? movie.xPlayer2 : str15;
            String str40 = (i14 & 67108864) != 0 ? movie.xPlayer3 : str16;
            int i28 = (i14 & 134217728) != 0 ? movie.locked : i12;
            String str41 = (i14 & 268435456) != 0 ? movie.rating : str17;
            String str42 = (i14 & 536870912) != 0 ? movie.avgRuntime : str18;
            String str43 = (i14 & 1073741824) != 0 ? movie.ageRating : str19;
            int i29 = (i14 & Integer.MIN_VALUE) != 0 ? movie.top10 : i13;
            String str44 = (i15 & 1) != 0 ? movie.playCode : str20;
            String str45 = (i15 & 2) != 0 ? movie.createdAt : str21;
            if ((i15 & 4) != 0) {
                str24 = str45;
                str23 = movie.updatedAt;
            } else {
                str23 = str22;
                str24 = str45;
            }
            return movie.copy(i19, i17, str25, str26, str27, str28, str29, str30, str31, str32, i18, str33, str34, str35, str36, i20, i21, str37, str38, i22, i23, i24, i25, i26, i27, str39, str40, i28, str41, str42, str43, i29, str44, str24, str23);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component10, reason: from getter */
        public final String getTrailer() {
            return this.trailer;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final int getTtype() {
            return this.ttype;
        }

        @Nullable
        /* JADX INFO: renamed from: component12, reason: from getter */
        public final String getBasic() {
            return this.basic;
        }

        @Nullable
        /* JADX INFO: renamed from: component13, reason: from getter */
        public final String getSd() {
            return this.sd;
        }

        @Nullable
        /* JADX INFO: renamed from: component14, reason: from getter */
        public final String getHd() {
            return this.hd;
        }

        @Nullable
        /* JADX INFO: renamed from: component15, reason: from getter */
        public final String getFhd() {
            return this.fhd;
        }

        /* JADX INFO: renamed from: component16, reason: from getter */
        public final int getShowId() {
            return this.showId;
        }

        /* JADX INFO: renamed from: component17, reason: from getter */
        public final int getLanguage() {
            return this.language;
        }

        @Nullable
        /* JADX INFO: renamed from: component18, reason: from getter */
        public final String getShowName() {
            return this.showName;
        }

        @Nullable
        /* JADX INFO: renamed from: component19, reason: from getter */
        public final String getLanguageName() {
            return this.languageName;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getNo() {
            return this.no;
        }

        /* JADX INFO: renamed from: component20, reason: from getter */
        public final int getPremium() {
            return this.premium;
        }

        /* JADX INFO: renamed from: component21, reason: from getter */
        public final int getWfeathers() {
            return this.wfeathers;
        }

        /* JADX INFO: renamed from: component22, reason: from getter */
        public final int getBfeathers() {
            return this.bfeathers;
        }

        /* JADX INFO: renamed from: component23, reason: from getter */
        public final int getSfeathers() {
            return this.sfeathers;
        }

        /* JADX INFO: renamed from: component24, reason: from getter */
        public final int getTrending() {
            return this.trending;
        }

        /* JADX INFO: renamed from: component25, reason: from getter */
        public final int getSpecial() {
            return this.special;
        }

        @Nullable
        /* JADX INFO: renamed from: component26, reason: from getter */
        public final String getXPlayer2() {
            return this.xPlayer2;
        }

        @Nullable
        /* JADX INFO: renamed from: component27, reason: from getter */
        public final String getXPlayer3() {
            return this.xPlayer3;
        }

        /* JADX INFO: renamed from: component28, reason: from getter */
        public final int getLocked() {
            return this.locked;
        }

        @Nullable
        /* JADX INFO: renamed from: component29, reason: from getter */
        public final String getRating() {
            return this.rating;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @Nullable
        /* JADX INFO: renamed from: component30, reason: from getter */
        public final String getAvgRuntime() {
            return this.avgRuntime;
        }

        @Nullable
        /* JADX INFO: renamed from: component31, reason: from getter */
        public final String getAgeRating() {
            return this.ageRating;
        }

        /* JADX INFO: renamed from: component32, reason: from getter */
        public final int getTop10() {
            return this.top10;
        }

        @Nullable
        /* JADX INFO: renamed from: component33, reason: from getter */
        public final String getPlayCode() {
            return this.playCode;
        }

        @Nullable
        /* JADX INFO: renamed from: component34, reason: from getter */
        public final String getCreatedAt() {
            return this.createdAt;
        }

        @Nullable
        /* JADX INFO: renamed from: component35, reason: from getter */
        public final String getUpdatedAt() {
            return this.updatedAt;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getPoster() {
            return this.poster;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getCover() {
            return this.cover;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getGenre() {
            return this.genre;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getDes() {
            return this.des;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getTags() {
            return this.tags;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @NotNull
        public final Movie copy(@JsonProperty("id") int id, @JsonProperty("no") int no, @JsonProperty("name") @NotNull String name, @JsonProperty("poster") @Nullable String poster, @JsonProperty("cover") @Nullable String cover, @JsonProperty("genre") @Nullable String genre, @JsonProperty("des") @Nullable String des, @JsonProperty("tags") @Nullable String tags, @JsonProperty("type") @Nullable String type, @JsonProperty("trailer") @Nullable String trailer, @JsonProperty("ttype") int ttype, @JsonProperty("basic") @Nullable String basic, @JsonProperty("sd") @Nullable String sd, @JsonProperty("hd") @Nullable String hd, @JsonProperty("fhd") @Nullable String fhd, @JsonProperty("show_id") int showId, @JsonProperty("language") int language, @JsonProperty("show_name") @Nullable String showName, @JsonProperty("language_name") @Nullable String languageName, @JsonProperty("premium") int premium, @JsonProperty("wfeathers") int wfeathers, @JsonProperty("bfeathers") int bfeathers, @JsonProperty("sfeathers") int sfeathers, @JsonProperty("trending") int trending, @JsonProperty("special") int special, @JsonProperty("xPlayer2") @Nullable String xPlayer2, @JsonProperty("xPlayer3") @Nullable String xPlayer3, @JsonProperty("locked") int locked, @JsonProperty("rating") @Nullable String rating, @JsonProperty("avg_runtime") @Nullable String avgRuntime, @JsonProperty("age_rating") @Nullable String ageRating, @JsonProperty("top10") int top10, @JsonProperty("play_code") @Nullable String playCode, @JsonProperty("created_at") @Nullable String createdAt, @JsonProperty("updated_at") @Nullable String updatedAt) {
            return new Movie(id, no, name, poster, cover, genre, des, tags, type, trailer, ttype, basic, sd, hd, fhd, showId, language, showName, languageName, premium, wfeathers, bfeathers, sfeathers, trending, special, xPlayer2, xPlayer3, locked, rating, avgRuntime, ageRating, top10, playCode, createdAt, updatedAt);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Movie)) {
                return false;
            }
            Movie movie = (Movie) other;
            return this.id == movie.id && this.no == movie.no && Intrinsics.areEqual(this.name, movie.name) && Intrinsics.areEqual(this.poster, movie.poster) && Intrinsics.areEqual(this.cover, movie.cover) && Intrinsics.areEqual(this.genre, movie.genre) && Intrinsics.areEqual(this.des, movie.des) && Intrinsics.areEqual(this.tags, movie.tags) && Intrinsics.areEqual(this.type, movie.type) && Intrinsics.areEqual(this.trailer, movie.trailer) && this.ttype == movie.ttype && Intrinsics.areEqual(this.basic, movie.basic) && Intrinsics.areEqual(this.sd, movie.sd) && Intrinsics.areEqual(this.hd, movie.hd) && Intrinsics.areEqual(this.fhd, movie.fhd) && this.showId == movie.showId && this.language == movie.language && Intrinsics.areEqual(this.showName, movie.showName) && Intrinsics.areEqual(this.languageName, movie.languageName) && this.premium == movie.premium && this.wfeathers == movie.wfeathers && this.bfeathers == movie.bfeathers && this.sfeathers == movie.sfeathers && this.trending == movie.trending && this.special == movie.special && Intrinsics.areEqual(this.xPlayer2, movie.xPlayer2) && Intrinsics.areEqual(this.xPlayer3, movie.xPlayer3) && this.locked == movie.locked && Intrinsics.areEqual(this.rating, movie.rating) && Intrinsics.areEqual(this.avgRuntime, movie.avgRuntime) && Intrinsics.areEqual(this.ageRating, movie.ageRating) && this.top10 == movie.top10 && Intrinsics.areEqual(this.playCode, movie.playCode) && Intrinsics.areEqual(this.createdAt, movie.createdAt) && Intrinsics.areEqual(this.updatedAt, movie.updatedAt);
        }

        public int hashCode() {
            return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.id * 31) + this.no) * 31) + this.name.hashCode()) * 31) + (this.poster == null ? 0 : this.poster.hashCode())) * 31) + (this.cover == null ? 0 : this.cover.hashCode())) * 31) + (this.genre == null ? 0 : this.genre.hashCode())) * 31) + (this.des == null ? 0 : this.des.hashCode())) * 31) + (this.tags == null ? 0 : this.tags.hashCode())) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.trailer == null ? 0 : this.trailer.hashCode())) * 31) + this.ttype) * 31) + (this.basic == null ? 0 : this.basic.hashCode())) * 31) + (this.sd == null ? 0 : this.sd.hashCode())) * 31) + (this.hd == null ? 0 : this.hd.hashCode())) * 31) + (this.fhd == null ? 0 : this.fhd.hashCode())) * 31) + this.showId) * 31) + this.language) * 31) + (this.showName == null ? 0 : this.showName.hashCode())) * 31) + (this.languageName == null ? 0 : this.languageName.hashCode())) * 31) + this.premium) * 31) + this.wfeathers) * 31) + this.bfeathers) * 31) + this.sfeathers) * 31) + this.trending) * 31) + this.special) * 31) + (this.xPlayer2 == null ? 0 : this.xPlayer2.hashCode())) * 31) + (this.xPlayer3 == null ? 0 : this.xPlayer3.hashCode())) * 31) + this.locked) * 31) + (this.rating == null ? 0 : this.rating.hashCode())) * 31) + (this.avgRuntime == null ? 0 : this.avgRuntime.hashCode())) * 31) + (this.ageRating == null ? 0 : this.ageRating.hashCode())) * 31) + this.top10) * 31) + (this.playCode == null ? 0 : this.playCode.hashCode())) * 31) + (this.createdAt == null ? 0 : this.createdAt.hashCode())) * 31) + (this.updatedAt != null ? this.updatedAt.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Movie(id=").append(this.id).append(", no=").append(this.no).append(", name=").append(this.name).append(", poster=").append(this.poster).append(", cover=").append(this.cover).append(", genre=").append(this.genre).append(", des=").append(this.des).append(", tags=").append(this.tags).append(", type=").append(this.type).append(", trailer=").append(this.trailer).append(", ttype=").append(this.ttype).append(", basic=");
            sb.append(this.basic).append(", sd=").append(this.sd).append(", hd=").append(this.hd).append(", fhd=").append(this.fhd).append(", showId=").append(this.showId).append(", language=").append(this.language).append(", showName=").append(this.showName).append(", languageName=").append(this.languageName).append(", premium=").append(this.premium).append(", wfeathers=").append(this.wfeathers).append(", bfeathers=").append(this.bfeathers).append(", sfeathers=").append(this.sfeathers);
            sb.append(", trending=").append(this.trending).append(", special=").append(this.special).append(", xPlayer2=").append(this.xPlayer2).append(", xPlayer3=").append(this.xPlayer3).append(", locked=").append(this.locked).append(", rating=").append(this.rating).append(", avgRuntime=").append(this.avgRuntime).append(", ageRating=").append(this.ageRating).append(", top10=").append(this.top10).append(", playCode=").append(this.playCode).append(", createdAt=").append(this.createdAt).append(", updatedAt=");
            sb.append(this.updatedAt).append(')');
            return sb.toString();
        }

        public Movie(@JsonProperty("id") int id, @JsonProperty("no") int no, @JsonProperty("name") @NotNull String name, @JsonProperty("poster") @Nullable String poster, @JsonProperty("cover") @Nullable String cover, @JsonProperty("genre") @Nullable String genre, @JsonProperty("des") @Nullable String des, @JsonProperty("tags") @Nullable String tags, @JsonProperty("type") @Nullable String type, @JsonProperty("trailer") @Nullable String trailer, @JsonProperty("ttype") int ttype, @JsonProperty("basic") @Nullable String basic, @JsonProperty("sd") @Nullable String sd, @JsonProperty("hd") @Nullable String hd, @JsonProperty("fhd") @Nullable String fhd, @JsonProperty("show_id") int showId, @JsonProperty("language") int language, @JsonProperty("show_name") @Nullable String showName, @JsonProperty("language_name") @Nullable String languageName, @JsonProperty("premium") int premium, @JsonProperty("wfeathers") int wfeathers, @JsonProperty("bfeathers") int bfeathers, @JsonProperty("sfeathers") int sfeathers, @JsonProperty("trending") int trending, @JsonProperty("special") int special, @JsonProperty("xPlayer2") @Nullable String xPlayer2, @JsonProperty("xPlayer3") @Nullable String xPlayer3, @JsonProperty("locked") int locked, @JsonProperty("rating") @Nullable String rating, @JsonProperty("avg_runtime") @Nullable String avgRuntime, @JsonProperty("age_rating") @Nullable String ageRating, @JsonProperty("top10") int top10, @JsonProperty("play_code") @Nullable String playCode, @JsonProperty("created_at") @Nullable String createdAt, @JsonProperty("updated_at") @Nullable String updatedAt) {
            this.id = id;
            this.no = no;
            this.name = name;
            this.poster = poster;
            this.cover = cover;
            this.genre = genre;
            this.des = des;
            this.tags = tags;
            this.type = type;
            this.trailer = trailer;
            this.ttype = ttype;
            this.basic = basic;
            this.sd = sd;
            this.hd = hd;
            this.fhd = fhd;
            this.showId = showId;
            this.language = language;
            this.showName = showName;
            this.languageName = languageName;
            this.premium = premium;
            this.wfeathers = wfeathers;
            this.bfeathers = bfeathers;
            this.sfeathers = sfeathers;
            this.trending = trending;
            this.special = special;
            this.xPlayer2 = xPlayer2;
            this.xPlayer3 = xPlayer3;
            this.locked = locked;
            this.rating = rating;
            this.avgRuntime = avgRuntime;
            this.ageRating = ageRating;
            this.top10 = top10;
            this.playCode = playCode;
            this.createdAt = createdAt;
            this.updatedAt = updatedAt;
        }

        public /* synthetic */ Movie(int i, int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i3, String str9, String str10, String str11, String str12, int i4, int i5, String str13, String str14, int i6, int i7, int i8, int i9, int i10, int i11, String str15, String str16, int i12, String str17, String str18, String str19, int i13, String str20, String str21, String str22, int i14, int i15, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, i2, str, (i14 & 8) != 0 ? null : str2, (i14 & 16) != 0 ? null : str3, (i14 & 32) != 0 ? null : str4, (i14 & 64) != 0 ? null : str5, (i14 & 128) != 0 ? null : str6, (i14 & 256) != 0 ? null : str7, (i14 & 512) != 0 ? null : str8, (i14 & 1024) != 0 ? 0 : i3, (i14 & 2048) != 0 ? null : str9, (i14 & 4096) != 0 ? null : str10, (i14 & 8192) != 0 ? null : str11, (i14 & 16384) != 0 ? null : str12, (32768 & i14) != 0 ? 0 : i4, (65536 & i14) != 0 ? 0 : i5, (131072 & i14) != 0 ? null : str13, (262144 & i14) != 0 ? null : str14, (524288 & i14) != 0 ? 0 : i6, (1048576 & i14) != 0 ? 0 : i7, (2097152 & i14) != 0 ? 0 : i8, (4194304 & i14) != 0 ? 0 : i9, (8388608 & i14) != 0 ? 0 : i10, (16777216 & i14) != 0 ? 0 : i11, (33554432 & i14) != 0 ? null : str15, (67108864 & i14) != 0 ? null : str16, (134217728 & i14) != 0 ? 0 : i12, (268435456 & i14) != 0 ? null : str17, (536870912 & i14) != 0 ? null : str18, (1073741824 & i14) != 0 ? null : str19, (i14 & Integer.MIN_VALUE) != 0 ? 0 : i13, (i15 & 1) != 0 ? null : str20, (i15 & 2) != 0 ? null : str21, (i15 & 4) != 0 ? null : str22);
        }

        public final int getId() {
            return this.id;
        }

        public final int getNo() {
            return this.no;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @Nullable
        public final String getPoster() {
            return this.poster;
        }

        @Nullable
        public final String getCover() {
            return this.cover;
        }

        @Nullable
        public final String getGenre() {
            return this.genre;
        }

        @Nullable
        public final String getDes() {
            return this.des;
        }

        @Nullable
        public final String getTags() {
            return this.tags;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }

        @Nullable
        public final String getTrailer() {
            return this.trailer;
        }

        public final int getTtype() {
            return this.ttype;
        }

        @Nullable
        public final String getBasic() {
            return this.basic;
        }

        @Nullable
        public final String getSd() {
            return this.sd;
        }

        @Nullable
        public final String getHd() {
            return this.hd;
        }

        @Nullable
        public final String getFhd() {
            return this.fhd;
        }

        public final int getShowId() {
            return this.showId;
        }

        public final int getLanguage() {
            return this.language;
        }

        @Nullable
        public final String getShowName() {
            return this.showName;
        }

        @Nullable
        public final String getLanguageName() {
            return this.languageName;
        }

        public final int getPremium() {
            return this.premium;
        }

        public final int getWfeathers() {
            return this.wfeathers;
        }

        public final int getBfeathers() {
            return this.bfeathers;
        }

        public final int getSfeathers() {
            return this.sfeathers;
        }

        public final int getTrending() {
            return this.trending;
        }

        public final int getSpecial() {
            return this.special;
        }

        @Nullable
        public final String getXPlayer2() {
            return this.xPlayer2;
        }

        @Nullable
        public final String getXPlayer3() {
            return this.xPlayer3;
        }

        public final int getLocked() {
            return this.locked;
        }

        @Nullable
        public final String getRating() {
            return this.rating;
        }

        @Nullable
        public final String getAvgRuntime() {
            return this.avgRuntime;
        }

        @Nullable
        public final String getAgeRating() {
            return this.ageRating;
        }

        public final int getTop10() {
            return this.top10;
        }

        @Nullable
        public final String getPlayCode() {
            return this.playCode;
        }

        @Nullable
        public final String getCreatedAt() {
            return this.createdAt;
        }

        @Nullable
        public final String getUpdatedAt() {
            return this.updatedAt;
        }
    }

    /* JADX INFO: compiled from: XonProvider.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0003\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\u000e\b\u0003\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u0005HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/cncverse/XonProvider$MoviesResponse;", "", "status", "", "lastUpdated", "", "movies", "", "Lcom/cncverse/XonProvider$Movie;", "<init>", "(ZLjava/lang/String;Ljava/util/List;)V", "getStatus", "()Z", "getLastUpdated", "()Ljava/lang/String;", "getMovies", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "XonProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class MoviesResponse {

        @JsonProperty("last_updated")
        @NotNull
        private final String lastUpdated;

        @JsonProperty("movies")
        @NotNull
        private final List<Movie> movies;

        @JsonProperty("status")
        private final boolean status;

        public MoviesResponse() {
            this(false, null, null, 7, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MoviesResponse copy$default(MoviesResponse moviesResponse, boolean z, String str, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                z = moviesResponse.status;
            }
            if ((i & 2) != 0) {
                str = moviesResponse.lastUpdated;
            }
            if ((i & 4) != 0) {
                list = moviesResponse.movies;
            }
            return moviesResponse.copy(z, str, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getStatus() {
            return this.status;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getLastUpdated() {
            return this.lastUpdated;
        }

        @NotNull
        public final List<Movie> component3() {
            return this.movies;
        }

        @NotNull
        public final MoviesResponse copy(@JsonProperty("status") boolean status, @JsonProperty("last_updated") @NotNull String lastUpdated, @JsonProperty("movies") @NotNull List<Movie> movies) {
            return new MoviesResponse(status, lastUpdated, movies);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MoviesResponse)) {
                return false;
            }
            MoviesResponse moviesResponse = (MoviesResponse) other;
            return this.status == moviesResponse.status && Intrinsics.areEqual(this.lastUpdated, moviesResponse.lastUpdated) && Intrinsics.areEqual(this.movies, moviesResponse.movies);
        }

        public int hashCode() {
            return (((XonProvider$MoviesResponse$$ExternalSyntheticBackport0.m0m(this.status) * 31) + this.lastUpdated.hashCode()) * 31) + this.movies.hashCode();
        }

        @NotNull
        public String toString() {
            return "MoviesResponse(status=" + this.status + ", lastUpdated=" + this.lastUpdated + ", movies=" + this.movies + ')';
        }

        public MoviesResponse(@JsonProperty("status") boolean status, @JsonProperty("last_updated") @NotNull String lastUpdated, @JsonProperty("movies") @NotNull List<Movie> list) {
            this.status = status;
            this.lastUpdated = lastUpdated;
            this.movies = list;
        }

        public /* synthetic */ MoviesResponse(boolean z, String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? CollectionsKt.emptyList() : list);
        }

        public final boolean getStatus() {
            return this.status;
        }

        @NotNull
        public final String getLastUpdated() {
            return this.lastUpdated;
        }

        @NotNull
        public final List<Movie> getMovies() {
            return this.movies;
        }
    }

    /* JADX INFO: compiled from: XonProvider.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\bW\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B¿\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0003\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0017\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0003\u0010\u001a\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u001e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u001f\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b \u0010!J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0006HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u0003HÆ\u0003J\t\u0010P\u001a\u00020\u0003HÆ\u0003J\t\u0010Q\u001a\u00020\u0003HÆ\u0003J\t\u0010R\u001a\u00020\u0003HÆ\u0003J\t\u0010S\u001a\u00020\u0003HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010V\u001a\u00020\u0003HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0006HÆ\u0003JÁ\u0002\u0010\\\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\b\u0003\u0010\u0010\u001a\u00020\u00032\b\b\u0003\u0010\u0011\u001a\u00020\u00032\b\b\u0003\u0010\u0012\u001a\u00020\u00032\b\b\u0003\u0010\u0013\u001a\u00020\u00032\b\b\u0003\u0010\u0014\u001a\u00020\u00032\b\b\u0003\u0010\u0015\u001a\u00020\u00032\b\b\u0003\u0010\u0016\u001a\u00020\u00032\b\b\u0003\u0010\u0017\u001a\u00020\u00032\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\u00062\b\b\u0003\u0010\u001a\u001a\u00020\u00032\n\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u001e\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0014\u0010]\u001a\u00020^2\b\u0010_\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010`\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010a\u001a\u00020\u0006HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010&R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010&R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010&R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010&R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010&R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010&R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010&R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010&R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010&R\u0016\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010#R\u0016\u0010\u0011\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010#R\u0016\u0010\u0012\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010#R\u0016\u0010\u0013\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010#R\u0016\u0010\u0014\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010#R\u0016\u0010\u0015\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010#R\u0016\u0010\u0016\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010#R\u0016\u0010\u0017\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010#R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010&R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010&R\u0016\u0010\u001a\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010#R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010&R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010&R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010&R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010&R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010&¨\u0006b"}, d2 = {"Lcom/cncverse/XonProvider$Episode;", "", "id", "", "no", "name", "", "thumb", "cover", "des", "tags", "type", "basic", "sd", "hd", "fhd", "seasonId", "showId", "language", "premium", "wfeathers", "bfeathers", "sfeathers", "trending", "aplayer1", "aplayer2", "locked", "playCode", "showName", "languageName", "seasonName", "updatedAt", "<init>", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIIIIIILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()I", "getNo", "getName", "()Ljava/lang/String;", "getThumb", "getCover", "getDes", "getTags", "getType", "getBasic", "getSd", "getHd", "getFhd", "getSeasonId", "getShowId", "getLanguage", "getPremium", "getWfeathers", "getBfeathers", "getSfeathers", "getTrending", "getAplayer1", "getAplayer2", "getLocked", "getPlayCode", "getShowName", "getLanguageName", "getSeasonName", "getUpdatedAt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "copy", "equals", "", "other", "hashCode", "toString", "XonProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Episode {

        @JsonProperty("aplayer1")
        @Nullable
        private final String aplayer1;

        @JsonProperty("aplayer2")
        @Nullable
        private final String aplayer2;

        @JsonProperty("basic")
        @Nullable
        private final String basic;

        @JsonProperty("bfeathers")
        private final int bfeathers;

        @JsonProperty("cover")
        @Nullable
        private final String cover;

        @JsonProperty("des")
        @Nullable
        private final String des;

        @JsonProperty("fhd")
        @Nullable
        private final String fhd;

        @JsonProperty("hd")
        @Nullable
        private final String hd;

        @JsonProperty("id")
        private final int id;

        @JsonProperty("language")
        private final int language;

        @JsonProperty("languageName")
        @Nullable
        private final String languageName;

        @JsonProperty("locked")
        private final int locked;

        @JsonProperty("name")
        @NotNull
        private final String name;

        @JsonProperty("no")
        private final int no;

        @JsonProperty("play_code")
        @Nullable
        private final String playCode;

        @JsonProperty("premium")
        private final int premium;

        @JsonProperty("sd")
        @Nullable
        private final String sd;

        @JsonProperty("season_id")
        private final int seasonId;

        @JsonProperty("season_name")
        @Nullable
        private final String seasonName;

        @JsonProperty("sfeathers")
        private final int sfeathers;

        @JsonProperty("show_id")
        private final int showId;

        @JsonProperty("showName")
        @Nullable
        private final String showName;

        @JsonProperty("tags")
        @Nullable
        private final String tags;

        @JsonProperty("thumb")
        @Nullable
        private final String thumb;

        @JsonProperty("trending")
        private final int trending;

        @JsonProperty("type")
        @Nullable
        private final String type;

        @JsonProperty("updated_at")
        @Nullable
        private final String updatedAt;

        @JsonProperty("wfeathers")
        private final int wfeathers;

        public static /* synthetic */ Episode copy$default(Episode episode, int i, int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, String str11, String str12, int i11, String str13, String str14, String str15, String str16, String str17, int i12, Object obj) {
            String str18;
            String str19;
            int i13 = (i12 & 1) != 0 ? episode.id : i;
            int i14 = (i12 & 2) != 0 ? episode.no : i2;
            String str20 = (i12 & 4) != 0 ? episode.name : str;
            String str21 = (i12 & 8) != 0 ? episode.thumb : str2;
            String str22 = (i12 & 16) != 0 ? episode.cover : str3;
            String str23 = (i12 & 32) != 0 ? episode.des : str4;
            String str24 = (i12 & 64) != 0 ? episode.tags : str5;
            String str25 = (i12 & 128) != 0 ? episode.type : str6;
            String str26 = (i12 & 256) != 0 ? episode.basic : str7;
            String str27 = (i12 & 512) != 0 ? episode.sd : str8;
            String str28 = (i12 & 1024) != 0 ? episode.hd : str9;
            String str29 = (i12 & 2048) != 0 ? episode.fhd : str10;
            int i15 = (i12 & 4096) != 0 ? episode.seasonId : i3;
            int i16 = (i12 & 8192) != 0 ? episode.showId : i4;
            int i17 = i13;
            int i18 = (i12 & 16384) != 0 ? episode.language : i5;
            int i19 = (i12 & 32768) != 0 ? episode.premium : i6;
            int i20 = (i12 & 65536) != 0 ? episode.wfeathers : i7;
            int i21 = (i12 & 131072) != 0 ? episode.bfeathers : i8;
            int i22 = (i12 & 262144) != 0 ? episode.sfeathers : i9;
            int i23 = (i12 & 524288) != 0 ? episode.trending : i10;
            String str30 = (i12 & 1048576) != 0 ? episode.aplayer1 : str11;
            String str31 = (i12 & 2097152) != 0 ? episode.aplayer2 : str12;
            int i24 = (i12 & 4194304) != 0 ? episode.locked : i11;
            String str32 = (i12 & 8388608) != 0 ? episode.playCode : str13;
            String str33 = (i12 & 16777216) != 0 ? episode.showName : str14;
            String str34 = (i12 & 33554432) != 0 ? episode.languageName : str15;
            String str35 = (i12 & 67108864) != 0 ? episode.seasonName : str16;
            if ((i12 & 134217728) != 0) {
                str19 = str35;
                str18 = episode.updatedAt;
            } else {
                str18 = str17;
                str19 = str35;
            }
            return episode.copy(i17, i14, str20, str21, str22, str23, str24, str25, str26, str27, str28, str29, i15, i16, i18, i19, i20, i21, i22, i23, str30, str31, i24, str32, str33, str34, str19, str18);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component10, reason: from getter */
        public final String getSd() {
            return this.sd;
        }

        @Nullable
        /* JADX INFO: renamed from: component11, reason: from getter */
        public final String getHd() {
            return this.hd;
        }

        @Nullable
        /* JADX INFO: renamed from: component12, reason: from getter */
        public final String getFhd() {
            return this.fhd;
        }

        /* JADX INFO: renamed from: component13, reason: from getter */
        public final int getSeasonId() {
            return this.seasonId;
        }

        /* JADX INFO: renamed from: component14, reason: from getter */
        public final int getShowId() {
            return this.showId;
        }

        /* JADX INFO: renamed from: component15, reason: from getter */
        public final int getLanguage() {
            return this.language;
        }

        /* JADX INFO: renamed from: component16, reason: from getter */
        public final int getPremium() {
            return this.premium;
        }

        /* JADX INFO: renamed from: component17, reason: from getter */
        public final int getWfeathers() {
            return this.wfeathers;
        }

        /* JADX INFO: renamed from: component18, reason: from getter */
        public final int getBfeathers() {
            return this.bfeathers;
        }

        /* JADX INFO: renamed from: component19, reason: from getter */
        public final int getSfeathers() {
            return this.sfeathers;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getNo() {
            return this.no;
        }

        /* JADX INFO: renamed from: component20, reason: from getter */
        public final int getTrending() {
            return this.trending;
        }

        @Nullable
        /* JADX INFO: renamed from: component21, reason: from getter */
        public final String getAplayer1() {
            return this.aplayer1;
        }

        @Nullable
        /* JADX INFO: renamed from: component22, reason: from getter */
        public final String getAplayer2() {
            return this.aplayer2;
        }

        /* JADX INFO: renamed from: component23, reason: from getter */
        public final int getLocked() {
            return this.locked;
        }

        @Nullable
        /* JADX INFO: renamed from: component24, reason: from getter */
        public final String getPlayCode() {
            return this.playCode;
        }

        @Nullable
        /* JADX INFO: renamed from: component25, reason: from getter */
        public final String getShowName() {
            return this.showName;
        }

        @Nullable
        /* JADX INFO: renamed from: component26, reason: from getter */
        public final String getLanguageName() {
            return this.languageName;
        }

        @Nullable
        /* JADX INFO: renamed from: component27, reason: from getter */
        public final String getSeasonName() {
            return this.seasonName;
        }

        @Nullable
        /* JADX INFO: renamed from: component28, reason: from getter */
        public final String getUpdatedAt() {
            return this.updatedAt;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getThumb() {
            return this.thumb;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getCover() {
            return this.cover;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getDes() {
            return this.des;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getTags() {
            return this.tags;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getBasic() {
            return this.basic;
        }

        @NotNull
        public final Episode copy(@JsonProperty("id") int id, @JsonProperty("no") int no, @JsonProperty("name") @NotNull String name, @JsonProperty("thumb") @Nullable String thumb, @JsonProperty("cover") @Nullable String cover, @JsonProperty("des") @Nullable String des, @JsonProperty("tags") @Nullable String tags, @JsonProperty("type") @Nullable String type, @JsonProperty("basic") @Nullable String basic, @JsonProperty("sd") @Nullable String sd, @JsonProperty("hd") @Nullable String hd, @JsonProperty("fhd") @Nullable String fhd, @JsonProperty("season_id") int seasonId, @JsonProperty("show_id") int showId, @JsonProperty("language") int language, @JsonProperty("premium") int premium, @JsonProperty("wfeathers") int wfeathers, @JsonProperty("bfeathers") int bfeathers, @JsonProperty("sfeathers") int sfeathers, @JsonProperty("trending") int trending, @JsonProperty("aplayer1") @Nullable String aplayer1, @JsonProperty("aplayer2") @Nullable String aplayer2, @JsonProperty("locked") int locked, @JsonProperty("play_code") @Nullable String playCode, @JsonProperty("showName") @Nullable String showName, @JsonProperty("languageName") @Nullable String languageName, @JsonProperty("season_name") @Nullable String seasonName, @JsonProperty("updated_at") @Nullable String updatedAt) {
            return new Episode(id, no, name, thumb, cover, des, tags, type, basic, sd, hd, fhd, seasonId, showId, language, premium, wfeathers, bfeathers, sfeathers, trending, aplayer1, aplayer2, locked, playCode, showName, languageName, seasonName, updatedAt);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Episode)) {
                return false;
            }
            Episode episode = (Episode) other;
            return this.id == episode.id && this.no == episode.no && Intrinsics.areEqual(this.name, episode.name) && Intrinsics.areEqual(this.thumb, episode.thumb) && Intrinsics.areEqual(this.cover, episode.cover) && Intrinsics.areEqual(this.des, episode.des) && Intrinsics.areEqual(this.tags, episode.tags) && Intrinsics.areEqual(this.type, episode.type) && Intrinsics.areEqual(this.basic, episode.basic) && Intrinsics.areEqual(this.sd, episode.sd) && Intrinsics.areEqual(this.hd, episode.hd) && Intrinsics.areEqual(this.fhd, episode.fhd) && this.seasonId == episode.seasonId && this.showId == episode.showId && this.language == episode.language && this.premium == episode.premium && this.wfeathers == episode.wfeathers && this.bfeathers == episode.bfeathers && this.sfeathers == episode.sfeathers && this.trending == episode.trending && Intrinsics.areEqual(this.aplayer1, episode.aplayer1) && Intrinsics.areEqual(this.aplayer2, episode.aplayer2) && this.locked == episode.locked && Intrinsics.areEqual(this.playCode, episode.playCode) && Intrinsics.areEqual(this.showName, episode.showName) && Intrinsics.areEqual(this.languageName, episode.languageName) && Intrinsics.areEqual(this.seasonName, episode.seasonName) && Intrinsics.areEqual(this.updatedAt, episode.updatedAt);
        }

        public int hashCode() {
            return (((((((((((((((((((((((((((((((((((((((((((((((((((((this.id * 31) + this.no) * 31) + this.name.hashCode()) * 31) + (this.thumb == null ? 0 : this.thumb.hashCode())) * 31) + (this.cover == null ? 0 : this.cover.hashCode())) * 31) + (this.des == null ? 0 : this.des.hashCode())) * 31) + (this.tags == null ? 0 : this.tags.hashCode())) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.basic == null ? 0 : this.basic.hashCode())) * 31) + (this.sd == null ? 0 : this.sd.hashCode())) * 31) + (this.hd == null ? 0 : this.hd.hashCode())) * 31) + (this.fhd == null ? 0 : this.fhd.hashCode())) * 31) + this.seasonId) * 31) + this.showId) * 31) + this.language) * 31) + this.premium) * 31) + this.wfeathers) * 31) + this.bfeathers) * 31) + this.sfeathers) * 31) + this.trending) * 31) + (this.aplayer1 == null ? 0 : this.aplayer1.hashCode())) * 31) + (this.aplayer2 == null ? 0 : this.aplayer2.hashCode())) * 31) + this.locked) * 31) + (this.playCode == null ? 0 : this.playCode.hashCode())) * 31) + (this.showName == null ? 0 : this.showName.hashCode())) * 31) + (this.languageName == null ? 0 : this.languageName.hashCode())) * 31) + (this.seasonName == null ? 0 : this.seasonName.hashCode())) * 31) + (this.updatedAt != null ? this.updatedAt.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Episode(id=").append(this.id).append(", no=").append(this.no).append(", name=").append(this.name).append(", thumb=").append(this.thumb).append(", cover=").append(this.cover).append(", des=").append(this.des).append(", tags=").append(this.tags).append(", type=").append(this.type).append(", basic=").append(this.basic).append(", sd=").append(this.sd).append(", hd=").append(this.hd).append(", fhd=");
            sb.append(this.fhd).append(", seasonId=").append(this.seasonId).append(", showId=").append(this.showId).append(", language=").append(this.language).append(", premium=").append(this.premium).append(", wfeathers=").append(this.wfeathers).append(", bfeathers=").append(this.bfeathers).append(", sfeathers=").append(this.sfeathers).append(", trending=").append(this.trending).append(", aplayer1=").append(this.aplayer1).append(", aplayer2=").append(this.aplayer2).append(", locked=").append(this.locked);
            sb.append(", playCode=").append(this.playCode).append(", showName=").append(this.showName).append(", languageName=").append(this.languageName).append(", seasonName=").append(this.seasonName).append(", updatedAt=").append(this.updatedAt).append(')');
            return sb.toString();
        }

        public Episode(@JsonProperty("id") int id, @JsonProperty("no") int no, @JsonProperty("name") @NotNull String name, @JsonProperty("thumb") @Nullable String thumb, @JsonProperty("cover") @Nullable String cover, @JsonProperty("des") @Nullable String des, @JsonProperty("tags") @Nullable String tags, @JsonProperty("type") @Nullable String type, @JsonProperty("basic") @Nullable String basic, @JsonProperty("sd") @Nullable String sd, @JsonProperty("hd") @Nullable String hd, @JsonProperty("fhd") @Nullable String fhd, @JsonProperty("season_id") int seasonId, @JsonProperty("show_id") int showId, @JsonProperty("language") int language, @JsonProperty("premium") int premium, @JsonProperty("wfeathers") int wfeathers, @JsonProperty("bfeathers") int bfeathers, @JsonProperty("sfeathers") int sfeathers, @JsonProperty("trending") int trending, @JsonProperty("aplayer1") @Nullable String aplayer1, @JsonProperty("aplayer2") @Nullable String aplayer2, @JsonProperty("locked") int locked, @JsonProperty("play_code") @Nullable String playCode, @JsonProperty("showName") @Nullable String showName, @JsonProperty("languageName") @Nullable String languageName, @JsonProperty("season_name") @Nullable String seasonName, @JsonProperty("updated_at") @Nullable String updatedAt) {
            this.id = id;
            this.no = no;
            this.name = name;
            this.thumb = thumb;
            this.cover = cover;
            this.des = des;
            this.tags = tags;
            this.type = type;
            this.basic = basic;
            this.sd = sd;
            this.hd = hd;
            this.fhd = fhd;
            this.seasonId = seasonId;
            this.showId = showId;
            this.language = language;
            this.premium = premium;
            this.wfeathers = wfeathers;
            this.bfeathers = bfeathers;
            this.sfeathers = sfeathers;
            this.trending = trending;
            this.aplayer1 = aplayer1;
            this.aplayer2 = aplayer2;
            this.locked = locked;
            this.playCode = playCode;
            this.showName = showName;
            this.languageName = languageName;
            this.seasonName = seasonName;
            this.updatedAt = updatedAt;
        }

        public /* synthetic */ Episode(int i, int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, String str11, String str12, int i11, String str13, String str14, String str15, String str16, String str17, int i12, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, i2, str, (i12 & 8) != 0 ? null : str2, (i12 & 16) != 0 ? null : str3, (i12 & 32) != 0 ? null : str4, (i12 & 64) != 0 ? null : str5, (i12 & 128) != 0 ? null : str6, (i12 & 256) != 0 ? null : str7, (i12 & 512) != 0 ? null : str8, (i12 & 1024) != 0 ? null : str9, (i12 & 2048) != 0 ? null : str10, (i12 & 4096) != 0 ? 0 : i3, (i12 & 8192) != 0 ? 0 : i4, (i12 & 16384) != 0 ? 0 : i5, (32768 & i12) != 0 ? 0 : i6, (65536 & i12) != 0 ? 0 : i7, (131072 & i12) != 0 ? 0 : i8, (262144 & i12) != 0 ? 0 : i9, (524288 & i12) != 0 ? 0 : i10, (1048576 & i12) != 0 ? null : str11, (2097152 & i12) != 0 ? null : str12, (4194304 & i12) != 0 ? 0 : i11, (8388608 & i12) != 0 ? null : str13, (16777216 & i12) != 0 ? null : str14, (33554432 & i12) != 0 ? null : str15, (67108864 & i12) != 0 ? null : str16, (i12 & 134217728) != 0 ? null : str17);
        }

        public final int getId() {
            return this.id;
        }

        public final int getNo() {
            return this.no;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @Nullable
        public final String getThumb() {
            return this.thumb;
        }

        @Nullable
        public final String getCover() {
            return this.cover;
        }

        @Nullable
        public final String getDes() {
            return this.des;
        }

        @Nullable
        public final String getTags() {
            return this.tags;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }

        @Nullable
        public final String getBasic() {
            return this.basic;
        }

        @Nullable
        public final String getSd() {
            return this.sd;
        }

        @Nullable
        public final String getHd() {
            return this.hd;
        }

        @Nullable
        public final String getFhd() {
            return this.fhd;
        }

        public final int getSeasonId() {
            return this.seasonId;
        }

        public final int getShowId() {
            return this.showId;
        }

        public final int getLanguage() {
            return this.language;
        }

        public final int getPremium() {
            return this.premium;
        }

        public final int getWfeathers() {
            return this.wfeathers;
        }

        public final int getBfeathers() {
            return this.bfeathers;
        }

        public final int getSfeathers() {
            return this.sfeathers;
        }

        public final int getTrending() {
            return this.trending;
        }

        @Nullable
        public final String getAplayer1() {
            return this.aplayer1;
        }

        @Nullable
        public final String getAplayer2() {
            return this.aplayer2;
        }

        public final int getLocked() {
            return this.locked;
        }

        @Nullable
        public final String getPlayCode() {
            return this.playCode;
        }

        @Nullable
        public final String getShowName() {
            return this.showName;
        }

        @Nullable
        public final String getLanguageName() {
            return this.languageName;
        }

        @Nullable
        public final String getSeasonName() {
            return this.seasonName;
        }

        @Nullable
        public final String getUpdatedAt() {
            return this.updatedAt;
        }
    }

    /* JADX INFO: compiled from: XonProvider.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/cncverse/XonProvider$EpisodesResponse;", "", "episodes", "", "Lcom/cncverse/XonProvider$Episode;", "<init>", "(Ljava/util/List;)V", "getEpisodes", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "XonProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class EpisodesResponse {

        @JsonProperty("episodes")
        @NotNull
        private final List<Episode> episodes;

        /* JADX WARN: Illegal instructions before constructor call */
        public EpisodesResponse() {
            List list = null;
            this(list, 1, list);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ EpisodesResponse copy$default(EpisodesResponse episodesResponse, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = episodesResponse.episodes;
            }
            return episodesResponse.copy(list);
        }

        @NotNull
        public final List<Episode> component1() {
            return this.episodes;
        }

        @NotNull
        public final EpisodesResponse copy(@JsonProperty("episodes") @NotNull List<Episode> episodes) {
            return new EpisodesResponse(episodes);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof EpisodesResponse) && Intrinsics.areEqual(this.episodes, ((EpisodesResponse) other).episodes);
        }

        public int hashCode() {
            return this.episodes.hashCode();
        }

        @NotNull
        public String toString() {
            return "EpisodesResponse(episodes=" + this.episodes + ')';
        }

        public EpisodesResponse(@JsonProperty("episodes") @NotNull List<Episode> list) {
            this.episodes = list;
        }

        public /* synthetic */ EpisodesResponse(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? CollectionsKt.emptyList() : list);
        }

        @NotNull
        public final List<Episode> getEpisodes() {
            return this.episodes;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object fetchRemoteConfig(Continuation<? super Unit> continuation) {
        C00071 c00071;
        Object allConfig;
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
        Object $result = c00071.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (c00071.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    XonFirebaseRemoteConfigFetcher xonFirebaseRemoteConfigFetcher = XonFirebaseRemoteConfigFetcher.INSTANCE;
                    c00071.label = 1;
                    allConfig = xonFirebaseRemoteConfigFetcher.getAllConfig(c00071);
                    if (allConfig == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    allConfig = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Triple triple = (Triple) allConfig;
            String baseUrl = (String) triple.component1();
            String fetchedApiKey = (String) triple.component2();
            String fetchedCallerName = (String) triple.component3();
            if (baseUrl != null) {
                setMainUrl(baseUrl);
            }
            if (fetchedApiKey != null) {
                this.apiKey = fetchedApiKey;
            }
            if (fetchedCallerName != null) {
                this.callerName = fetchedCallerName;
            }
            this.configFetched = true;
            this.configExpireTime = System.currentTimeMillis() + ((long) 3600000);
        } catch (Exception e) {
            System.out.println((Object) ("Xon Provider: Failed to fetch remote config - " + e.getMessage()));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.fasterxml.jackson.databind.RuntimeJsonMappingException */
    /* JADX WARN: Code duplicated, block: B:43:0x0106 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:44:0x0107  */
    /* JADX WARN: Code duplicated, block: B:47:0x012c  */
    /* JADX WARN: Code duplicated, block: B:50:0x0154 A[Catch: Exception -> 0x0175, TryCatch #2 {Exception -> 0x0175, blocks: (B:48:0x012f, B:50:0x0154, B:52:0x0167, B:53:0x0174), top: B:90:0x012f }] */
    /* JADX WARN: Code duplicated, block: B:51:0x0165  */
    /* JADX WARN: Code duplicated, block: B:56:0x017b  */
    /* JADX WARN: Code duplicated, block: B:61:0x01e2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:62:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:65:0x020a A[Catch: Exception -> 0x0261, TryCatch #6 {Exception -> 0x0261, blocks: (B:63:0x01ea, B:65:0x020a, B:67:0x0232, B:69:0x0245, B:70:0x0252, B:71:0x0253), top: B:97:0x01ea }] */
    /* JADX WARN: Code duplicated, block: B:67:0x0232 A[Catch: Exception -> 0x0261, TryCatch #6 {Exception -> 0x0261, blocks: (B:63:0x01ea, B:65:0x020a, B:67:0x0232, B:69:0x0245, B:70:0x0252, B:71:0x0253), top: B:97:0x01ea }] */
    /* JADX WARN: Code duplicated, block: B:68:0x0243  */
    /* JADX WARN: Code duplicated, block: B:71:0x0253 A[Catch: Exception -> 0x0261, TRY_LEAVE, TryCatch #6 {Exception -> 0x0261, blocks: (B:63:0x01ea, B:65:0x020a, B:67:0x0232, B:69:0x0245, B:70:0x0252, B:71:0x0253), top: B:97:0x01ea }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public final Object refreshCache(@NotNull Continuation<? super Unit> continuation) throws RuntimeJsonMappingException {
        C00141 c00141;
        long currentTime;
        Map<String, String> headers;
        long currentTime2;
        String str;
        String str2;
        long currentTime3;
        String moviesRaw;
        Object $this$checkTypeMismatch$iv$iv;
        long currentTime4;
        String str3;
        long currentTime5;
        String qualifiedName;
        Object $this$checkTypeMismatch$iv$iv2;
        String qualifiedName2;
        if (continuation instanceof C00141) {
            c00141 = (C00141) continuation;
            if ((c00141.label & Integer.MIN_VALUE) != 0) {
                c00141.label -= Integer.MIN_VALUE;
            } else {
                c00141 = new C00141(continuation);
            }
        } else {
            c00141 = new C00141(continuation);
        }
        C00141 c00142 = c00141;
        Object $result = c00142.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (c00142.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    currentTime = System.currentTimeMillis();
                    if (!this.configFetched || currentTime >= this.configExpireTime) {
                        c00142.J$0 = currentTime;
                        c00142.label = 1;
                        if (fetchRemoteConfig(c00142) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    if (currentTime - this.lastCacheTime >= this.cacheRefreshInterval && !this.cachedMovies.isEmpty() && !this.cachedEpisodes.isEmpty()) {
                        return Unit.INSTANCE;
                    }
                    try {
                        headers = getHeaders();
                        Requests app = MainActivityKt.getApp();
                        String str4 = getMainUrl() + "/nzgetshows.php";
                        c00142.L$0 = headers;
                        c00142.J$0 = currentTime;
                        c00142.label = 2;
                        currentTime2 = currentTime;
                        str = " but was ";
                        str2 = "Deserialized value did not match the specified type; specified ";
                        try {
                            $result = Requests.get$default(app, str4, headers, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00142, 4092, (Object) null);
                            c00142 = c00142;
                            if ($result == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            currentTime3 = currentTime2;
                            try {
                                moviesRaw = ((NiceResponse) $result).getBody().string();
                                ObjectMapper $this$readValue$iv = this.mapper;
                                $this$checkTypeMismatch$iv$iv = $this$readValue$iv.readValue(moviesRaw, new TypeReference<MoviesResponse>() { // from class: com.cncverse.XonProvider$refreshCache$$inlined$readValue$1
                                });
                                if ($this$checkTypeMismatch$iv$iv instanceof MoviesResponse) {
                                    String str5 = str;
                                    MoviesResponse moviesResponse = (MoviesResponse) $this$checkTypeMismatch$iv$iv;
                                    this.cachedMovies = moviesResponse.getMovies();
                                    Requests app2 = MainActivityKt.getApp();
                                    String str6 = getMainUrl() + "/nzgetepisodes_v2.php";
                                    c00142.L$0 = SpillingKt.nullOutSpilledVariable(headers);
                                    c00142.L$1 = SpillingKt.nullOutSpilledVariable(moviesRaw);
                                    c00142.L$2 = SpillingKt.nullOutSpilledVariable(moviesResponse);
                                    c00142.J$0 = currentTime3;
                                    c00142.label = 3;
                                    currentTime4 = currentTime3;
                                    str3 = str5;
                                    try {
                                        $result = Requests.get$default(app2, str6, headers, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00142, 4092, (Object) null);
                                        if ($result == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        currentTime5 = currentTime4;
                                        try {
                                            String episodesRaw = ((NiceResponse) $result).getBody().string();
                                            ObjectMapper $this$readValue$iv2 = this.mapper;
                                            $this$checkTypeMismatch$iv$iv2 = $this$readValue$iv2.readValue(episodesRaw, new TypeReference<EpisodesResponse>() { // from class: com.cncverse.XonProvider$refreshCache$$inlined$readValue$2
                                            });
                                            if (!($this$checkTypeMismatch$iv$iv2 instanceof EpisodesResponse)) {
                                                EpisodesResponse episodesResponse = (EpisodesResponse) $this$checkTypeMismatch$iv$iv2;
                                                this.cachedEpisodes = episodesResponse.getEpisodes();
                                                this.lastCacheTime = currentTime5;
                                                return Unit.INSTANCE;
                                            }
                                            StringBuilder sbAppend = new StringBuilder().append(str2).append(Reflection.getOrCreateKotlinClass(EpisodesResponse.class).getQualifiedName()).append("(non-null)").append(str3);
                                            if ($this$checkTypeMismatch$iv$iv2 != null) {
                                                qualifiedName2 = Reflection.getOrCreateKotlinClass($this$checkTypeMismatch$iv$iv2.getClass()).getQualifiedName();
                                            } else {
                                                qualifiedName2 = null;
                                            }
                                            throw new RuntimeJsonMappingException(sbAppend.append(qualifiedName2).toString());
                                        } catch (Exception e) {
                                            e = e;
                                            System.out.println((Object) ("Xon Provider: Failed to refresh cache - " + e.getMessage()));
                                        }
                                    } catch (Exception e2) {
                                        e = e2;
                                    }
                                } else {
                                    try {
                                        StringBuilder sbAppend2 = new StringBuilder().append(str2).append(Reflection.getOrCreateKotlinClass(MoviesResponse.class).getQualifiedName()).append("(non-null)").append(str);
                                        if ($this$checkTypeMismatch$iv$iv != null) {
                                            qualifiedName = Reflection.getOrCreateKotlinClass($this$checkTypeMismatch$iv$iv.getClass()).getQualifiedName();
                                        } else {
                                            qualifiedName = null;
                                        }
                                        throw new RuntimeJsonMappingException(sbAppend2.append(qualifiedName).toString());
                                    } catch (Exception e3) {
                                        e = e3;
                                    }
                                }
                            } catch (Exception e4) {
                                e = e4;
                            }
                            System.out.println((Object) ("Xon Provider: Failed to refresh cache - " + e.getMessage()));
                            return Unit.INSTANCE;
                        } catch (Exception e5) {
                            e = e5;
                        }
                    } catch (Exception e6) {
                        e = e6;
                    }
                    break;
                case 1:
                    currentTime = c00142.J$0;
                    ResultKt.throwOnFailure($result);
                    if (currentTime - this.lastCacheTime >= this.cacheRefreshInterval) {
                        break;
                    }
                    headers = getHeaders();
                    Requests app3 = MainActivityKt.getApp();
                    String str7 = getMainUrl() + "/nzgetshows.php";
                    c00142.L$0 = headers;
                    c00142.J$0 = currentTime;
                    c00142.label = 2;
                    currentTime2 = currentTime;
                    str = " but was ";
                    str2 = "Deserialized value did not match the specified type; specified ";
                    $result = Requests.get$default(app3, str7, headers, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00142, 4092, (Object) null);
                    c00142 = c00142;
                    if ($result == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    currentTime3 = currentTime2;
                    moviesRaw = ((NiceResponse) $result).getBody().string();
                    ObjectMapper $this$readValue$iv3 = this.mapper;
                    $this$checkTypeMismatch$iv$iv = $this$readValue$iv3.readValue(moviesRaw, new TypeReference<MoviesResponse>() { // from class: com.cncverse.XonProvider$refreshCache$$inlined$readValue$1
                    });
                    if ($this$checkTypeMismatch$iv$iv instanceof MoviesResponse) {
                        StringBuilder sbAppend3 = new StringBuilder().append(str2).append(Reflection.getOrCreateKotlinClass(MoviesResponse.class).getQualifiedName()).append("(non-null)").append(str);
                        if ($this$checkTypeMismatch$iv$iv != null) {
                            qualifiedName = Reflection.getOrCreateKotlinClass($this$checkTypeMismatch$iv$iv.getClass()).getQualifiedName();
                        } else {
                            qualifiedName = null;
                        }
                        throw new RuntimeJsonMappingException(sbAppend3.append(qualifiedName).toString());
                    }
                    String str8 = str;
                    MoviesResponse moviesResponse2 = (MoviesResponse) $this$checkTypeMismatch$iv$iv;
                    this.cachedMovies = moviesResponse2.getMovies();
                    Requests app4 = MainActivityKt.getApp();
                    String str9 = getMainUrl() + "/nzgetepisodes_v2.php";
                    c00142.L$0 = SpillingKt.nullOutSpilledVariable(headers);
                    c00142.L$1 = SpillingKt.nullOutSpilledVariable(moviesRaw);
                    c00142.L$2 = SpillingKt.nullOutSpilledVariable(moviesResponse2);
                    c00142.J$0 = currentTime3;
                    c00142.label = 3;
                    currentTime4 = currentTime3;
                    str3 = str8;
                    $result = Requests.get$default(app4, str9, headers, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00142, 4092, (Object) null);
                    if ($result == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    currentTime5 = currentTime4;
                    String episodesRaw2 = ((NiceResponse) $result).getBody().string();
                    ObjectMapper $this$readValue$iv4 = this.mapper;
                    $this$checkTypeMismatch$iv$iv2 = $this$readValue$iv4.readValue(episodesRaw2, new TypeReference<EpisodesResponse>() { // from class: com.cncverse.XonProvider$refreshCache$$inlined$readValue$2
                    });
                    if (!($this$checkTypeMismatch$iv$iv2 instanceof EpisodesResponse)) {
                        EpisodesResponse episodesResponse2 = (EpisodesResponse) $this$checkTypeMismatch$iv$iv2;
                        this.cachedEpisodes = episodesResponse2.getEpisodes();
                        this.lastCacheTime = currentTime5;
                        return Unit.INSTANCE;
                    }
                    StringBuilder sbAppend4 = new StringBuilder().append(str2).append(Reflection.getOrCreateKotlinClass(EpisodesResponse.class).getQualifiedName()).append("(non-null)").append(str3);
                    if ($this$checkTypeMismatch$iv$iv2 != null) {
                        qualifiedName2 = Reflection.getOrCreateKotlinClass($this$checkTypeMismatch$iv$iv2.getClass()).getQualifiedName();
                    } else {
                        qualifiedName2 = null;
                    }
                    throw new RuntimeJsonMappingException(sbAppend4.append(qualifiedName2).toString());
                    System.out.println((Object) ("Xon Provider: Failed to refresh cache - " + e.getMessage()));
                    return Unit.INSTANCE;
                case 2:
                    long currentTime6 = c00142.J$0;
                    headers = (Map) c00142.L$0;
                    ResultKt.throwOnFailure($result);
                    str = " but was ";
                    str2 = "Deserialized value did not match the specified type; specified ";
                    currentTime3 = currentTime6;
                    moviesRaw = ((NiceResponse) $result).getBody().string();
                    ObjectMapper $this$readValue$iv5 = this.mapper;
                    $this$checkTypeMismatch$iv$iv = $this$readValue$iv5.readValue(moviesRaw, new TypeReference<MoviesResponse>() { // from class: com.cncverse.XonProvider$refreshCache$$inlined$readValue$1
                    });
                    if ($this$checkTypeMismatch$iv$iv instanceof MoviesResponse) {
                        StringBuilder sbAppend5 = new StringBuilder().append(str2).append(Reflection.getOrCreateKotlinClass(MoviesResponse.class).getQualifiedName()).append("(non-null)").append(str);
                        if ($this$checkTypeMismatch$iv$iv != null) {
                            qualifiedName = Reflection.getOrCreateKotlinClass($this$checkTypeMismatch$iv$iv.getClass()).getQualifiedName();
                        } else {
                            qualifiedName = null;
                        }
                        throw new RuntimeJsonMappingException(sbAppend5.append(qualifiedName).toString());
                    }
                    String str10 = str;
                    MoviesResponse moviesResponse3 = (MoviesResponse) $this$checkTypeMismatch$iv$iv;
                    this.cachedMovies = moviesResponse3.getMovies();
                    Requests app5 = MainActivityKt.getApp();
                    String str11 = getMainUrl() + "/nzgetepisodes_v2.php";
                    c00142.L$0 = SpillingKt.nullOutSpilledVariable(headers);
                    c00142.L$1 = SpillingKt.nullOutSpilledVariable(moviesRaw);
                    c00142.L$2 = SpillingKt.nullOutSpilledVariable(moviesResponse3);
                    c00142.J$0 = currentTime3;
                    c00142.label = 3;
                    currentTime4 = currentTime3;
                    str3 = str10;
                    $result = Requests.get$default(app5, str11, headers, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00142, 4092, (Object) null);
                    if ($result == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    currentTime5 = currentTime4;
                    String episodesRaw3 = ((NiceResponse) $result).getBody().string();
                    ObjectMapper $this$readValue$iv6 = this.mapper;
                    $this$checkTypeMismatch$iv$iv2 = $this$readValue$iv6.readValue(episodesRaw3, new TypeReference<EpisodesResponse>() { // from class: com.cncverse.XonProvider$refreshCache$$inlined$readValue$2
                    });
                    if (!($this$checkTypeMismatch$iv$iv2 instanceof EpisodesResponse)) {
                        EpisodesResponse episodesResponse3 = (EpisodesResponse) $this$checkTypeMismatch$iv$iv2;
                        this.cachedEpisodes = episodesResponse3.getEpisodes();
                        this.lastCacheTime = currentTime5;
                        return Unit.INSTANCE;
                    }
                    StringBuilder sbAppend6 = new StringBuilder().append(str2).append(Reflection.getOrCreateKotlinClass(EpisodesResponse.class).getQualifiedName()).append("(non-null)").append(str3);
                    if ($this$checkTypeMismatch$iv$iv2 != null) {
                        qualifiedName2 = Reflection.getOrCreateKotlinClass($this$checkTypeMismatch$iv$iv2.getClass()).getQualifiedName();
                    } else {
                        qualifiedName2 = null;
                    }
                    throw new RuntimeJsonMappingException(sbAppend6.append(qualifiedName2).toString());
                    System.out.println((Object) ("Xon Provider: Failed to refresh cache - " + e.getMessage()));
                    return Unit.INSTANCE;
                case 3:
                    currentTime5 = c00142.J$0;
                    ResultKt.throwOnFailure($result);
                    str3 = " but was ";
                    str2 = "Deserialized value did not match the specified type; specified ";
                    String episodesRaw4 = ((NiceResponse) $result).getBody().string();
                    ObjectMapper $this$readValue$iv7 = this.mapper;
                    $this$checkTypeMismatch$iv$iv2 = $this$readValue$iv7.readValue(episodesRaw4, new TypeReference<EpisodesResponse>() { // from class: com.cncverse.XonProvider$refreshCache$$inlined$readValue$2
                    });
                    if (!($this$checkTypeMismatch$iv$iv2 instanceof EpisodesResponse)) {
                        EpisodesResponse episodesResponse4 = (EpisodesResponse) $this$checkTypeMismatch$iv$iv2;
                        this.cachedEpisodes = episodesResponse4.getEpisodes();
                        this.lastCacheTime = currentTime5;
                        return Unit.INSTANCE;
                    }
                    StringBuilder sbAppend7 = new StringBuilder().append(str2).append(Reflection.getOrCreateKotlinClass(EpisodesResponse.class).getQualifiedName()).append("(non-null)").append(str3);
                    if ($this$checkTypeMismatch$iv$iv2 != null) {
                        qualifiedName2 = Reflection.getOrCreateKotlinClass($this$checkTypeMismatch$iv$iv2.getClass()).getQualifiedName();
                    } else {
                        qualifiedName2 = null;
                    }
                    throw new RuntimeJsonMappingException(sbAppend7.append(qualifiedName2).toString());
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Exception e7) {
            e = e7;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String formatUrl(String url) {
        if (StringsKt.startsWith$default(url, "http://", false, 2, (Object) null) || StringsKt.startsWith$default(url, "https://", false, 2, (Object) null)) {
            return url;
        }
        return "https://archive.org/download/" + url;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String bestPoster(Movie $this$bestPoster) {
        String poster = $this$bestPoster.getPoster();
        if (!(poster == null || poster.length() == 0)) {
            return formatUrl($this$bestPoster.getPoster());
        }
        String cover = $this$bestPoster.getCover();
        return !(cover == null || cover.length() == 0) ? formatUrl($this$bestPoster.getCover()) : "";
    }

    private final String displayName(Movie $this$displayName) {
        String languageName = $this$displayName.getLanguageName();
        if (languageName == null || languageName.length() == 0) {
            String name = $this$displayName.getName();
            return name == null ? "" : name;
        }
        StringBuilder sb = new StringBuilder();
        String name2 = $this$displayName.getName();
        return sb.append(name2 != null ? name2 : "").append(" (").append($this$displayName.getLanguageName()).append(')').toString();
    }

    private final String displayName(Episode $this$displayName) {
        String showName = $this$displayName.getShowName();
        if (!(showName == null || showName.length() == 0)) {
            String languageName = $this$displayName.getLanguageName();
            if (!(languageName == null || languageName.length() == 0)) {
                StringBuilder sbAppend = new StringBuilder().append($this$displayName.getShowName()).append(" – ");
                String name = $this$displayName.getName();
                return sbAppend.append(name != null ? name : "").append(" (").append($this$displayName.getLanguageName()).append(')').toString();
            }
        }
        String name2 = $this$displayName.getName();
        return name2 == null ? "" : name2;
    }

    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    /* JADX WARN: Code duplicated, block: B:67:0x02ab  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        C00081 c00081;
        MainPageRequest request2;
        int page2;
        Object answer$iv$iv$iv;
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
        Object $result = c00081.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00081.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                DonationManager.INSTANCE.checkAndShow(getName());
                request2 = request;
                c00081.L$0 = request2;
                c00081.I$0 = page;
                c00081.label = 1;
                if (refreshCache(c00081) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                page2 = page;
                break;
                break;
            case 1:
                page2 = c00081.I$0;
                request2 = (MainPageRequest) c00081.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        List list = new ArrayList();
        String data = request2.getData();
        switch (data.hashCode()) {
            case -1068259517:
                if (data.equals("movies")) {
                    Iterable $this$groupBy$iv = this.cachedMovies;
                    Map byLanguage = new LinkedHashMap();
                    for (Object element$iv$iv : $this$groupBy$iv) {
                        Movie it = (Movie) element$iv$iv;
                        String languageName = it.getLanguageName();
                        if (languageName == null) {
                            languageName = "";
                        }
                        String str = languageName;
                        Object value$iv$iv$iv = byLanguage.get(str);
                        if (value$iv$iv$iv == null) {
                            answer$iv$iv$iv = new ArrayList();
                            byLanguage.put(str, answer$iv$iv$iv);
                        } else {
                            answer$iv$iv$iv = value$iv$iv$iv;
                        }
                        List list$iv$iv = (List) answer$iv$iv$iv;
                        list$iv$iv.add(element$iv$iv);
                        $this$groupBy$iv = $this$groupBy$iv;
                    }
                    Map $this$forEach$iv = byLanguage;
                    int $i$f$forEach = 0;
                    for (Map.Entry element$iv : $this$forEach$iv.entrySet()) {
                        String lang = (String) element$iv.getKey();
                        List movies = (List) element$iv.getValue();
                        Iterable $this$map$iv = CollectionsKt.take(movies, 20);
                        Map $this$forEach$iv2 = $this$forEach$iv;
                        int $i$f$forEach2 = $i$f$forEach;
                        int $i$f$forEach3 = CollectionsKt.collectionSizeOrDefault($this$map$iv, 10);
                        Collection destination$iv$iv = new ArrayList($i$f$forEach3);
                        for (Object item$iv$iv : $this$map$iv) {
                            final Movie movie = (Movie) item$iv$iv;
                            destination$iv$iv.add(MainAPIKt.newMovieSearchResponse$default(this, movie.getName(), "movie:" + movie.getId(), TvType.Movie, false, new Function1() { // from class: com.cncverse.XonProvider$$ExternalSyntheticLambda3
                                public final Object invoke(Object obj) {
                                    return XonProvider.getMainPage$lambda$6$0$0(this.f$0, movie, (MovieSearchResponse) obj);
                                }
                            }, 8, (Object) null));
                            $result = $result;
                            page2 = page2;
                        }
                        Object $result2 = $result;
                        int page3 = page2;
                        List items = (List) destination$iv$iv;
                        String label = lang.length() > 0 ? lang + " Movies" : "Movies";
                        list.add(new HomePageList(label, items, true));
                        $i$f$forEach = $i$f$forEach2;
                        $this$forEach$iv = $this$forEach$iv2;
                        $result = $result2;
                        page2 = page3;
                    }
                }
                break;
            case 230566800:
                if (data.equals("latest_episodes")) {
                    Iterable $this$map$iv2 = CollectionsKt.take(this.cachedEpisodes, 20);
                    Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                    for (Object item$iv$iv2 : $this$map$iv2) {
                        final Episode ep = (Episode) item$iv$iv2;
                        destination$iv$iv2.add(MainAPIKt.newTvSeriesSearchResponse$default(this, displayName(ep), "episode:" + ep.getId(), TvType.TvSeries, false, new Function1() { // from class: com.cncverse.XonProvider$$ExternalSyntheticLambda2
                            public final Object invoke(Object obj) {
                                return XonProvider.getMainPage$lambda$4$0(ep, this, (TvSeriesSearchResponse) obj);
                            }
                        }, 8, (Object) null));
                        $this$map$iv2 = $this$map$iv2;
                    }
                    List latestEpisodes = (List) destination$iv$iv2;
                    list.add(new HomePageList("Latest Episodes", latestEpisodes, true));
                }
                break;
            case 1394955557:
                if (data.equals("trending")) {
                    Iterable $this$filter$iv = this.cachedMovies;
                    Collection destination$iv$iv3 = new ArrayList();
                    for (Object element$iv$iv2 : $this$filter$iv) {
                        Movie it2 = (Movie) element$iv$iv2;
                        if (it2.getTrending() == 1) {
                            destination$iv$iv3.add(element$iv$iv2);
                        }
                    }
                    Iterable $this$map$iv3 = CollectionsKt.take((List) destination$iv$iv3, 20);
                    Collection destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                    for (Object item$iv$iv3 : $this$map$iv3) {
                        final Movie movie2 = (Movie) item$iv$iv3;
                        destination$iv$iv4.add(MainAPIKt.newMovieSearchResponse$default(this, displayName(movie2), "movie:" + movie2.getId(), TvType.Movie, false, new Function1() { // from class: com.cncverse.XonProvider$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj) {
                                return XonProvider.getMainPage$lambda$1$0(this.f$0, movie2, (MovieSearchResponse) obj);
                            }
                        }, 8, (Object) null));
                    }
                    List trendingMovies = (List) destination$iv$iv4;
                    if (!trendingMovies.isEmpty()) {
                        list.add(new HomePageList("Trending Movies", trendingMovies, true));
                    }
                    Iterable $this$filter$iv2 = this.cachedEpisodes;
                    Collection destination$iv$iv5 = new ArrayList();
                    for (Object element$iv$iv3 : $this$filter$iv2) {
                        Episode it3 = (Episode) element$iv$iv3;
                        List trendingMovies2 = trendingMovies;
                        C00081 c00082 = c00081;
                        if (it3.getTrending() == 1) {
                            destination$iv$iv5.add(element$iv$iv3);
                        }
                        trendingMovies = trendingMovies2;
                        c00081 = c00082;
                    }
                    Iterable $this$map$iv4 = CollectionsKt.take((List) destination$iv$iv5, 20);
                    Collection destination$iv$iv6 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv4, 10));
                    for (Object item$iv$iv4 : $this$map$iv4) {
                        final Episode ep2 = (Episode) item$iv$iv4;
                        destination$iv$iv6.add(MainAPIKt.newTvSeriesSearchResponse$default(this, displayName(ep2), "episode:" + ep2.getId(), TvType.TvSeries, false, new Function1() { // from class: com.cncverse.XonProvider$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj) {
                                return XonProvider.getMainPage$lambda$3$0(ep2, this, (TvSeriesSearchResponse) obj);
                            }
                        }, 8, (Object) null));
                        $this$map$iv4 = $this$map$iv4;
                    }
                    List trendingEpisodes = (List) destination$iv$iv6;
                    if (!trendingEpisodes.isEmpty()) {
                        list.add(new HomePageList("Trending Episodes", trendingEpisodes, true));
                    }
                }
                break;
        }
        return MainAPIKt.newHomePageResponse$default(list, (Boolean) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMainPage$lambda$1$0(XonProvider this$0, Movie $movie, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl(this$0.bestPoster($movie));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMainPage$lambda$3$0(Episode $ep, XonProvider this$0, TvSeriesSearchResponse $this$newTvSeriesSearchResponse) {
        String thumb = $ep.getThumb();
        $this$newTvSeriesSearchResponse.setPosterUrl(!(thumb == null || thumb.length() == 0) ? this$0.formatUrl($ep.getThumb()) : "");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMainPage$lambda$4$0(Episode $ep, XonProvider this$0, TvSeriesSearchResponse $this$newTvSeriesSearchResponse) {
        String thumb = $ep.getThumb();
        $this$newTvSeriesSearchResponse.setPosterUrl(!(thumb == null || thumb.length() == 0) ? this$0.formatUrl($ep.getThumb()) : "");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMainPage$lambda$6$0$0(XonProvider this$0, Movie $movie, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl(this$0.bestPoster($movie));
        return Unit.INSTANCE;
    }

    private final Pair<String, String> extractLanguageFromQuery(String query) {
        Object element$iv;
        boolean z;
        Iterable tokens = new Regex("\\s+").split(StringsKt.trim(query).toString(), 0);
        Iterable $this$firstOrNull$iv = tokens;
        Iterator it = $this$firstOrNull$iv.iterator();
        do {
            if (!it.hasNext()) {
                element$iv = null;
                break;
            }
            element$iv = it.next();
            String token = (String) element$iv;
            Iterable $this$any$iv = this.knownLanguages;
            if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
                Iterator it2 = $this$any$iv.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        Object element$iv2 = it2.next();
                        String it3 = (String) element$iv2;
                        if (StringsKt.equals(it3, token, true)) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
            } else {
                z = false;
            }
        } while (!z);
        String langToken = (String) element$iv;
        if (langToken == null) {
            return new Pair<>((Object) null, StringsKt.trim(query).toString());
        }
        Iterable $this$filterNot$iv = tokens;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filterNot$iv) {
            String it4 = (String) element$iv$iv;
            if (!StringsKt.equals(it4, langToken, true)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        String remaining = StringsKt.trim(CollectionsKt.joinToString$default((List) destination$iv$iv, " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null)).toString();
        String lowerCase = langToken.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return new Pair<>(lowerCase, remaining);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:103:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:106:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:108:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:110:0x0200  */
    /* JADX WARN: Code duplicated, block: B:113:0x020d  */
    /* JADX WARN: Code duplicated, block: B:116:0x0211  */
    /* JADX WARN: Code duplicated, block: B:117:0x0213  */
    /* JADX WARN: Code duplicated, block: B:121:0x0219 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:123:0x021d  */
    /* JADX WARN: Code duplicated, block: B:125:0x0220  */
    /* JADX WARN: Code duplicated, block: B:135:0x011f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:139:0x0223 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:36:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:37:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:39:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:41:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:43:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:46:0x00de  */
    /* JADX WARN: Code duplicated, block: B:48:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:50:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:53:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:55:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:57:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:60:0x010a  */
    /* JADX WARN: Code duplicated, block: B:63:0x010e  */
    /* JADX WARN: Code duplicated, block: B:64:0x0110  */
    /* JADX WARN: Code duplicated, block: B:68:0x0116 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:71:0x011c  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:91:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:96:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:97:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:99:0x01d3  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        C00151 c00151;
        String query2;
        Iterable $this$filter$iv;
        int $i$f$filter;
        boolean langMatch;
        boolean z;
        boolean langMatch2;
        boolean textMatch;
        boolean textMatch2;
        String tags;
        boolean z2;
        String showName;
        boolean z3;
        boolean z4;
        C00151 c00152;
        boolean langMatch3;
        boolean z5;
        boolean langMatch4;
        boolean textMatch3;
        String des;
        boolean z6;
        String tags2;
        boolean z7;
        String showName2;
        boolean z8;
        boolean z9;
        if (continuation instanceof C00151) {
            c00151 = (C00151) continuation;
            if ((c00151.label & Integer.MIN_VALUE) != 0) {
                c00151.label -= Integer.MIN_VALUE;
            } else {
                c00151 = new C00151(continuation);
            }
        } else {
            c00151 = new C00151(continuation);
        }
        Object $result = c00151.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00151.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                c00151.L$0 = query;
                c00151.label = 1;
                if (refreshCache(c00151) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                query2 = query;
                break;
                break;
            case 1:
                query2 = (String) c00151.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        List results = new ArrayList();
        Pair<String, String> pairExtractLanguageFromQuery = extractLanguageFromQuery(query2);
        String detectedLang = (String) pairExtractLanguageFromQuery.component1();
        String textQuery = (String) pairExtractLanguageFromQuery.component2();
        Iterable $this$filter$iv2 = this.cachedMovies;
        Collection destination$iv$iv = new ArrayList();
        Iterator it = $this$filter$iv2.iterator();
        while (true) {
            boolean z10 = false;
            if (it.hasNext()) {
                Object element$iv$iv = it.next();
                Movie movie = (Movie) element$iv$iv;
                if (detectedLang == null) {
                    c00152 = c00151;
                } else {
                    String languageName = movie.getLanguageName();
                    if (languageName != null) {
                        String str = languageName;
                        c00152 = c00151;
                        z9 = StringsKt.contains(str, detectedLang, true);
                        if (z9) {
                            langMatch3 = false;
                        }
                        if (textQuery.length() == 0) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if (z5) {
                            langMatch4 = langMatch3;
                        } else {
                            langMatch4 = langMatch3;
                            if (!StringsKt.contains(movie.getName(), textQuery, true)) {
                                des = movie.getDes();
                                if (des == null && StringsKt.contains(des, textQuery, true)) {
                                    z6 = true;
                                } else {
                                    z6 = false;
                                }
                                if (!z6) {
                                    tags2 = movie.getTags();
                                    if (tags2 == null && StringsKt.contains(tags2, textQuery, true)) {
                                        z7 = true;
                                    } else {
                                        z7 = false;
                                    }
                                    if (!z7) {
                                        showName2 = movie.getShowName();
                                        if (showName2 == null && StringsKt.contains(showName2, textQuery, true)) {
                                            z8 = true;
                                        } else {
                                            z8 = false;
                                        }
                                        if (!z8) {
                                            textMatch3 = false;
                                        }
                                    }
                                }
                            }
                            if (langMatch4 && textMatch3) {
                                z10 = true;
                            }
                            if (z10) {
                                destination$iv$iv.add(element$iv$iv);
                            }
                            c00151 = c00152;
                        }
                        textMatch3 = true;
                        if (langMatch4) {
                            z10 = true;
                        }
                        if (z10) {
                            destination$iv$iv.add(element$iv$iv);
                        }
                        c00151 = c00152;
                    } else {
                        c00152 = c00151;
                    }
                    if (z9) {
                        langMatch3 = false;
                    }
                    if (textQuery.length() == 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (z5) {
                        langMatch4 = langMatch3;
                    } else {
                        langMatch4 = langMatch3;
                        if (!StringsKt.contains(movie.getName(), textQuery, true)) {
                            des = movie.getDes();
                            if (des == null) {
                                z6 = false;
                            } else {
                                z6 = false;
                            }
                            if (!z6) {
                                tags2 = movie.getTags();
                                if (tags2 == null) {
                                    z7 = false;
                                } else {
                                    z7 = false;
                                }
                                if (!z7) {
                                    showName2 = movie.getShowName();
                                    if (showName2 == null) {
                                        z8 = false;
                                    } else {
                                        z8 = false;
                                    }
                                    if (!z8) {
                                        textMatch3 = false;
                                    }
                                }
                            }
                        }
                        if (langMatch4) {
                            z10 = true;
                        }
                        if (z10) {
                            destination$iv$iv.add(element$iv$iv);
                        }
                        c00151 = c00152;
                    }
                    textMatch3 = true;
                    if (langMatch4) {
                        z10 = true;
                    }
                    if (z10) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                    c00151 = c00152;
                }
                langMatch3 = true;
                if (textQuery.length() == 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (z5) {
                    langMatch4 = langMatch3;
                } else {
                    langMatch4 = langMatch3;
                    if (!StringsKt.contains(movie.getName(), textQuery, true)) {
                        des = movie.getDes();
                        if (des == null) {
                            z6 = false;
                        } else {
                            z6 = false;
                        }
                        if (!z6) {
                            tags2 = movie.getTags();
                            if (tags2 == null) {
                                z7 = false;
                            } else {
                                z7 = false;
                            }
                            if (!z7) {
                                showName2 = movie.getShowName();
                                if (showName2 == null) {
                                    z8 = false;
                                } else {
                                    z8 = false;
                                }
                                if (!z8) {
                                    textMatch3 = false;
                                }
                            }
                        }
                    }
                    if (langMatch4) {
                        z10 = true;
                    }
                    if (z10) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                    c00151 = c00152;
                }
                textMatch3 = true;
                if (langMatch4) {
                    z10 = true;
                }
                if (z10) {
                    destination$iv$iv.add(element$iv$iv);
                }
                c00151 = c00152;
            } else {
                Iterable $this$forEach$iv = (List) destination$iv$iv;
                for (Object element$iv : $this$forEach$iv) {
                    final Movie movie2 = (Movie) element$iv;
                    results.add(MainAPIKt.newMovieSearchResponse$default(this, displayName(movie2), "movie:" + movie2.getId(), TvType.Movie, false, new Function1() { // from class: com.cncverse.XonProvider$$ExternalSyntheticLambda7
                        public final Object invoke(Object obj) {
                            return XonProvider.search$lambda$1$0(this.f$0, movie2, (MovieSearchResponse) obj);
                        }
                    }, 8, (Object) null));
                }
                Iterable $this$forEach$iv2 = this.cachedEpisodes;
                Iterable $this$filter$iv3 = $this$forEach$iv2;
                int $i$f$filter2 = 0;
                Collection destination$iv$iv2 = new ArrayList();
                for (Object element$iv$iv2 : $this$filter$iv3) {
                    Episode ep = (Episode) element$iv$iv2;
                    if (detectedLang == null) {
                        $this$filter$iv = $this$filter$iv3;
                        $i$f$filter = $i$f$filter2;
                    } else {
                        String languageName2 = ep.getLanguageName();
                        if (languageName2 != null) {
                            $this$filter$iv = $this$filter$iv3;
                            String str2 = languageName2;
                            $i$f$filter = $i$f$filter2;
                            z4 = StringsKt.contains(str2, detectedLang, true);
                            if (z4) {
                                langMatch = false;
                            }
                            if (textQuery.length() == 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                langMatch2 = langMatch;
                            } else {
                                langMatch2 = langMatch;
                                if (!StringsKt.contains(ep.getName(), textQuery, true)) {
                                    tags = ep.getTags();
                                    if (tags == null && StringsKt.contains(tags, textQuery, true)) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    if (!z2) {
                                        showName = ep.getShowName();
                                        if (showName == null && StringsKt.contains(showName, textQuery, true)) {
                                            z3 = true;
                                        } else {
                                            z3 = false;
                                        }
                                        if (!z3) {
                                            textMatch = false;
                                        }
                                    }
                                }
                                if (langMatch2 || !textMatch) {
                                    textMatch2 = false;
                                } else {
                                    textMatch2 = true;
                                }
                                if (textMatch2) {
                                    destination$iv$iv2.add(element$iv$iv2);
                                }
                                $this$filter$iv3 = $this$filter$iv;
                                $i$f$filter2 = $i$f$filter;
                            }
                            textMatch = true;
                            if (langMatch2) {
                                textMatch2 = false;
                            } else {
                                textMatch2 = false;
                            }
                            if (textMatch2) {
                                destination$iv$iv2.add(element$iv$iv2);
                            }
                            $this$filter$iv3 = $this$filter$iv;
                            $i$f$filter2 = $i$f$filter;
                        } else {
                            $this$filter$iv = $this$filter$iv3;
                            $i$f$filter = $i$f$filter2;
                        }
                        if (z4) {
                            langMatch = false;
                        }
                        if (textQuery.length() == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            langMatch2 = langMatch;
                        } else {
                            langMatch2 = langMatch;
                            if (!StringsKt.contains(ep.getName(), textQuery, true)) {
                                tags = ep.getTags();
                                if (tags == null) {
                                    z2 = false;
                                } else {
                                    z2 = false;
                                }
                                if (!z2) {
                                    showName = ep.getShowName();
                                    if (showName == null) {
                                        z3 = false;
                                    } else {
                                        z3 = false;
                                    }
                                    if (!z3) {
                                        textMatch = false;
                                    }
                                }
                            }
                            if (langMatch2) {
                                textMatch2 = false;
                            } else {
                                textMatch2 = false;
                            }
                            if (textMatch2) {
                                destination$iv$iv2.add(element$iv$iv2);
                            }
                            $this$filter$iv3 = $this$filter$iv;
                            $i$f$filter2 = $i$f$filter;
                        }
                        textMatch = true;
                        if (langMatch2) {
                            textMatch2 = false;
                        } else {
                            textMatch2 = false;
                        }
                        if (textMatch2) {
                            destination$iv$iv2.add(element$iv$iv2);
                        }
                        $this$filter$iv3 = $this$filter$iv;
                        $i$f$filter2 = $i$f$filter;
                    }
                    langMatch = true;
                    if (textQuery.length() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        langMatch2 = langMatch;
                    } else {
                        langMatch2 = langMatch;
                        if (!StringsKt.contains(ep.getName(), textQuery, true)) {
                            tags = ep.getTags();
                            if (tags == null) {
                                z2 = false;
                            } else {
                                z2 = false;
                            }
                            if (!z2) {
                                showName = ep.getShowName();
                                if (showName == null) {
                                    z3 = false;
                                } else {
                                    z3 = false;
                                }
                                if (!z3) {
                                    textMatch = false;
                                }
                            }
                        }
                        if (langMatch2) {
                            textMatch2 = false;
                        } else {
                            textMatch2 = false;
                        }
                        if (textMatch2) {
                            destination$iv$iv2.add(element$iv$iv2);
                        }
                        $this$filter$iv3 = $this$filter$iv;
                        $i$f$filter2 = $i$f$filter;
                    }
                    textMatch = true;
                    if (langMatch2) {
                        textMatch2 = false;
                    } else {
                        textMatch2 = false;
                    }
                    if (textMatch2) {
                        destination$iv$iv2.add(element$iv$iv2);
                    }
                    $this$filter$iv3 = $this$filter$iv;
                    $i$f$filter2 = $i$f$filter;
                }
                Iterable $this$forEach$iv3 = (List) destination$iv$iv2;
                for (Object element$iv2 : $this$forEach$iv3) {
                    final Episode ep2 = (Episode) element$iv2;
                    results.add(MainAPIKt.newTvSeriesSearchResponse$default(this, displayName(ep2), "episode:" + ep2.getId(), TvType.TvSeries, false, new Function1() { // from class: com.cncverse.XonProvider$$ExternalSyntheticLambda8
                        public final Object invoke(Object obj) {
                            return XonProvider.search$lambda$3$0(ep2, this, (TvSeriesSearchResponse) obj);
                        }
                    }, 8, (Object) null));
                }
                return results;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit search$lambda$1$0(XonProvider this$0, Movie $movie, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl(this$0.bestPoster($movie));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit search$lambda$3$0(Episode $ep, XonProvider this$0, TvSeriesSearchResponse $this$newTvSeriesSearchResponse) {
        String thumb = $ep.getThumb();
        $this$newTvSeriesSearchResponse.setPosterUrl(!(thumb == null || thumb.length() == 0) ? this$0.formatUrl($ep.getThumb()) : "");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x036d  */
    /* JADX WARN: Code duplicated, block: B:102:0x0371  */
    /* JADX WARN: Code duplicated, block: B:103:0x038f  */
    /* JADX WARN: Code duplicated, block: B:106:0x0403 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:107:0x0404  */
    /* JADX WARN: Code duplicated, block: B:109:0x0409  */
    /* JADX WARN: Code duplicated, block: B:111:0x040d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:114:0x0114 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:115:0x01ae A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:122:0x01f8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:21:0x00ca A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:22:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:24:0x00df  */
    /* JADX WARN: Code duplicated, block: B:26:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:29:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:31:0x010c  */
    /* JADX WARN: Code duplicated, block: B:32:0x010e  */
    /* JADX WARN: Code duplicated, block: B:39:0x0119 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:40:0x011a  */
    /* JADX WARN: Code duplicated, block: B:42:0x0171 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:43:0x0172  */
    /* JADX WARN: Code duplicated, block: B:45:0x0182  */
    /* JADX WARN: Code duplicated, block: B:47:0x018c  */
    /* JADX WARN: Code duplicated, block: B:50:0x019a  */
    /* JADX WARN: Code duplicated, block: B:52:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:53:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:59:0x01b3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:60:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:63:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:65:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:68:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:70:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:75:0x023e A[LOOP:3: B:73:0x0238->B:75:0x023e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:79:0x0292 A[LOOP:4: B:77:0x028c->B:79:0x0292, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:83:0x02f0 A[LOOP:5: B:81:0x02ea->B:83:0x02f0, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:86:0x0347  */
    /* JADX WARN: Code duplicated, block: B:88:0x034f  */
    /* JADX WARN: Code duplicated, block: B:89:0x0351  */
    /* JADX WARN: Code duplicated, block: B:91:0x0354  */
    /* JADX WARN: Code duplicated, block: B:92:0x0357  */
    /* JADX WARN: Code duplicated, block: B:96:0x0361  */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) {
        C00091 c00091;
        String url2;
        String str;
        List parts;
        String type;
        Integer intOrNull;
        int id;
        Iterator<T> it;
        Object next;
        Episode ep;
        Collection destination$iv$iv;
        List showEpisodes;
        Collection destination$iv$iv2;
        Iterable<IndexedValue> $this$associate$iv;
        final Map destination$iv$iv3;
        List $this$map$iv;
        int $i$f$map;
        Collection destination$iv$iv4;
        Iterable $this$mapTo$iv$iv;
        String url3;
        String showName;
        String str2;
        String showTitle;
        String langLabel;
        String displayTitle;
        Object objNewTvSeriesLoadResponse;
        String url4;
        String str3;
        boolean z;
        Episode it2;
        boolean z2;
        boolean z3;
        Iterator<T> it3;
        Object next2;
        Movie movie;
        Object objNewMovieLoadResponse;
        String url5;
        int id2;
        String type2;
        List parts2;
        String str4;
        boolean z4;
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
                c00092.L$0 = url;
                c00092.label = 1;
                if (refreshCache(c00092) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                url2 = url;
                str = StringsKt.substringAfterLast$default(url2, "/", (String) null, 2, (Object) null);
                parts = StringsKt.split$default(str, new String[]{":"}, false, 0, 6, (Object) null);
                if (parts.size() != 2) {
                    return null;
                }
                type = (String) parts.get(0);
                intOrNull = StringsKt.toIntOrNull((String) parts.get(1));
                if (intOrNull != null) {
                    return null;
                }
                id = intOrNull.intValue();
                if (Intrinsics.areEqual(type, "movie")) {
                    it3 = this.cachedMovies.iterator();
                    do {
                        if (it3.hasNext()) {
                            next2 = it3.next();
                            if (((Movie) next2).getId() == id) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                        } else {
                            next2 = null;
                        }
                        movie = (Movie) next2;
                        if (movie == null) {
                            return null;
                        }
                        String strDisplayName = displayName(movie);
                        TvType tvType = TvType.Movie;
                        String str5 = "movie:" + movie.getId();
                        C00102 c00102 = new C00102(movie, null);
                        c00092.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                        c00092.L$1 = SpillingKt.nullOutSpilledVariable(str);
                        c00092.L$2 = SpillingKt.nullOutSpilledVariable(parts);
                        c00092.L$3 = SpillingKt.nullOutSpilledVariable(type);
                        c00092.L$4 = SpillingKt.nullOutSpilledVariable(movie);
                        c00092.I$0 = id;
                        c00092.label = 2;
                        objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, strDisplayName, url2, tvType, str5, c00102, c00092);
                        if (objNewMovieLoadResponse == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        url5 = url2;
                        id2 = id;
                        type2 = type;
                        parts2 = parts;
                        str4 = str;
                        return (LoadResponse) objNewMovieLoadResponse;
                    } while (!z4);
                    movie = (Movie) next2;
                    if (movie == null) {
                        return null;
                    }
                    String strDisplayName2 = displayName(movie);
                    TvType tvType2 = TvType.Movie;
                    String str6 = "movie:" + movie.getId();
                    C00102 c00103 = new C00102(movie, null);
                    c00092.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c00092.L$1 = SpillingKt.nullOutSpilledVariable(str);
                    c00092.L$2 = SpillingKt.nullOutSpilledVariable(parts);
                    c00092.L$3 = SpillingKt.nullOutSpilledVariable(type);
                    c00092.L$4 = SpillingKt.nullOutSpilledVariable(movie);
                    c00092.I$0 = id;
                    c00092.label = 2;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, strDisplayName2, url2, tvType2, str6, c00103, c00092);
                    if (objNewMovieLoadResponse == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    url5 = url2;
                    id2 = id;
                    type2 = type;
                    parts2 = parts;
                    str4 = str;
                    return (LoadResponse) objNewMovieLoadResponse;
                }
                if (Intrinsics.areEqual(type, "episode")) {
                    return null;
                }
                it = this.cachedEpisodes.iterator();
                do {
                    if (it.hasNext()) {
                        next = it.next();
                        if (((Episode) next).getId() == id) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                    } else {
                        next = null;
                    }
                    ep = (Episode) next;
                    if (ep == null) {
                        return null;
                    }
                    Iterable $this$filter$iv = this.cachedEpisodes;
                    destination$iv$iv = new ArrayList();
                    for (Object element$iv$iv : $this$filter$iv) {
                        it2 = (Episode) element$iv$iv;
                        Object $result2 = $result;
                        if (it2.getShowId() == ep.getShowId() || it2.getLanguage() != ep.getLanguage()) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        if (z2) {
                            destination$iv$iv.add(element$iv$iv);
                        }
                        $result = $result2;
                    }
                    showEpisodes = CollectionsKt.sortedWith((List) destination$iv$iv, ComparisonsKt.compareBy(new Function1[]{new Function1() { // from class: com.cncverse.XonProvider$$ExternalSyntheticLambda4
                        public final Object invoke(Object obj) {
                            return XonProvider.load$lambda$3((XonProvider.Episode) obj);
                        }
                    }, new Function1() { // from class: com.cncverse.XonProvider$$ExternalSyntheticLambda5
                        public final Object invoke(Object obj) {
                            return XonProvider.load$lambda$4((XonProvider.Episode) obj);
                        }
                    }}));
                    List $this$map$iv2 = showEpisodes;
                    destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                    for (Object item$iv$iv : $this$map$iv2) {
                        destination$iv$iv2.add(Boxing.boxInt(((Episode) item$iv$iv).getSeasonId()));
                    }
                    List seasonIds = CollectionsKt.sorted(CollectionsKt.distinct((List) destination$iv$iv2));
                    $this$associate$iv = CollectionsKt.withIndex(seasonIds);
                    int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associate$iv, 10)), 16);
                    destination$iv$iv3 = new LinkedHashMap(capacity$iv);
                    for (IndexedValue indexedValue : $this$associate$iv) {
                        int idx = indexedValue.component1();
                        int sid = ((Number) indexedValue.component2()).intValue();
                        List showEpisodes2 = showEpisodes;
                        Pair pair = TuplesKt.to(Boxing.boxInt(sid), Boxing.boxInt(idx + 1));
                        destination$iv$iv3.put(pair.getFirst(), pair.getSecond());
                        showEpisodes = showEpisodes2;
                        $this$associate$iv = $this$associate$iv;
                    }
                    List showEpisodes3 = showEpisodes;
                    $this$map$iv = showEpisodes3;
                    $i$f$map = 0;
                    destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    $this$mapTo$iv$iv = $this$map$iv;
                    for (Object item$iv$iv2 : $this$mapTo$iv$iv) {
                        Iterable $this$map$iv3 = $this$map$iv;
                        final Episode e = (Episode) item$iv$iv2;
                        destination$iv$iv4.add(MainAPIKt.newEpisode(this, "episode:" + e.getId(), new Function1() { // from class: com.cncverse.XonProvider$$ExternalSyntheticLambda6
                            public final Object invoke(Object obj) {
                                return XonProvider.load$lambda$7$0(e, destination$iv$iv3, this, (Episode) obj);
                            }
                        }));
                        $this$map$iv = $this$map$iv3;
                        $i$f$map = $i$f$map;
                        url2 = url2;
                        $this$mapTo$iv$iv = $this$mapTo$iv$iv;
                    }
                    url3 = url2;
                    List episodeList = (List) destination$iv$iv4;
                    showName = ep.getShowName();
                    str2 = "Show";
                    if (showName != null) {
                        str3 = showName;
                        if (str3.length() == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            str2 = str3;
                        }
                        str2 = str2;
                    }
                    showTitle = str2;
                    langLabel = ep.getLanguageName();
                    if (langLabel == null) {
                        langLabel = "";
                    }
                    if (langLabel.length() > 0) {
                        displayTitle = showTitle + " (" + langLabel + ')';
                    } else {
                        displayTitle = showTitle;
                    }
                    TvType tvType3 = TvType.TvSeries;
                    C00113 c00113 = new C00113(ep, langLabel, null);
                    c00092.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                    c00092.L$1 = SpillingKt.nullOutSpilledVariable(str);
                    c00092.L$2 = SpillingKt.nullOutSpilledVariable(parts);
                    c00092.L$3 = SpillingKt.nullOutSpilledVariable(type);
                    c00092.L$4 = SpillingKt.nullOutSpilledVariable(ep);
                    c00092.L$5 = SpillingKt.nullOutSpilledVariable(showEpisodes3);
                    c00092.L$6 = SpillingKt.nullOutSpilledVariable(seasonIds);
                    c00092.L$7 = SpillingKt.nullOutSpilledVariable(destination$iv$iv3);
                    c00092.L$8 = SpillingKt.nullOutSpilledVariable(episodeList);
                    c00092.L$9 = SpillingKt.nullOutSpilledVariable(showTitle);
                    c00092.L$10 = SpillingKt.nullOutSpilledVariable(langLabel);
                    c00092.L$11 = SpillingKt.nullOutSpilledVariable(displayTitle);
                    c00092.I$0 = id;
                    c00092.label = 3;
                    objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, displayTitle, url3, tvType3, episodeList, c00113, c00092);
                    if (objNewTvSeriesLoadResponse == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    url4 = url3;
                    return (LoadResponse) objNewTvSeriesLoadResponse;
                } while (!z3);
                ep = (Episode) next;
                if (ep == null) {
                    return null;
                }
                Iterable $this$filter$iv2 = this.cachedEpisodes;
                destination$iv$iv = new ArrayList();
                while (r18.hasNext()) {
                    it2 = (Episode) element$iv$iv;
                    Object $result3 = $result;
                    if (it2.getShowId() == ep.getShowId()) {
                        z2 = false;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                    $result = $result3;
                }
                showEpisodes = CollectionsKt.sortedWith((List) destination$iv$iv, ComparisonsKt.compareBy(new Function1[]{new Function1() { // from class: com.cncverse.XonProvider$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj) {
                        return XonProvider.load$lambda$3((XonProvider.Episode) obj);
                    }
                }, new Function1() { // from class: com.cncverse.XonProvider$$ExternalSyntheticLambda5
                    public final Object invoke(Object obj) {
                        return XonProvider.load$lambda$4((XonProvider.Episode) obj);
                    }
                }}));
                List $this$map$iv4 = showEpisodes;
                destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv4, 10));
                while (r16.hasNext()) {
                    destination$iv$iv2.add(Boxing.boxInt(((Episode) item$iv$iv).getSeasonId()));
                }
                List seasonIds2 = CollectionsKt.sorted(CollectionsKt.distinct((List) destination$iv$iv2));
                $this$associate$iv = CollectionsKt.withIndex(seasonIds2);
                int capacity$iv2 = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associate$iv, 10)), 16);
                destination$iv$iv3 = new LinkedHashMap(capacity$iv2);
                while (r17.hasNext()) {
                    int idx2 = indexedValue.component1();
                    int sid2 = ((Number) indexedValue.component2()).intValue();
                    List showEpisodes4 = showEpisodes;
                    Pair pair2 = TuplesKt.to(Boxing.boxInt(sid2), Boxing.boxInt(idx2 + 1));
                    destination$iv$iv3.put(pair2.getFirst(), pair2.getSecond());
                    showEpisodes = showEpisodes4;
                    $this$associate$iv = $this$associate$iv;
                }
                List showEpisodes5 = showEpisodes;
                $this$map$iv = showEpisodes5;
                $i$f$map = 0;
                destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                $this$mapTo$iv$iv = $this$map$iv;
                while (r16.hasNext()) {
                    Iterable $this$map$iv5 = $this$map$iv;
                    final Episode e2 = (Episode) item$iv$iv2;
                    destination$iv$iv4.add(MainAPIKt.newEpisode(this, "episode:" + e2.getId(), new Function1() { // from class: com.cncverse.XonProvider$$ExternalSyntheticLambda6
                        public final Object invoke(Object obj) {
                            return XonProvider.load$lambda$7$0(e2, destination$iv$iv3, this, (Episode) obj);
                        }
                    }));
                    $this$map$iv = $this$map$iv5;
                    $i$f$map = $i$f$map;
                    url2 = url2;
                    $this$mapTo$iv$iv = $this$mapTo$iv$iv;
                }
                url3 = url2;
                List episodeList2 = (List) destination$iv$iv4;
                showName = ep.getShowName();
                str2 = "Show";
                if (showName != null) {
                    str3 = showName;
                    if (str3.length() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        str2 = str3;
                    }
                    str2 = str2;
                }
                showTitle = str2;
                langLabel = ep.getLanguageName();
                if (langLabel == null) {
                    langLabel = "";
                }
                if (langLabel.length() > 0) {
                    displayTitle = showTitle + " (" + langLabel + ')';
                } else {
                    displayTitle = showTitle;
                }
                TvType tvType4 = TvType.TvSeries;
                C00113 c00114 = new C00113(ep, langLabel, null);
                c00092.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                c00092.L$1 = SpillingKt.nullOutSpilledVariable(str);
                c00092.L$2 = SpillingKt.nullOutSpilledVariable(parts);
                c00092.L$3 = SpillingKt.nullOutSpilledVariable(type);
                c00092.L$4 = SpillingKt.nullOutSpilledVariable(ep);
                c00092.L$5 = SpillingKt.nullOutSpilledVariable(showEpisodes5);
                c00092.L$6 = SpillingKt.nullOutSpilledVariable(seasonIds2);
                c00092.L$7 = SpillingKt.nullOutSpilledVariable(destination$iv$iv3);
                c00092.L$8 = SpillingKt.nullOutSpilledVariable(episodeList2);
                c00092.L$9 = SpillingKt.nullOutSpilledVariable(showTitle);
                c00092.L$10 = SpillingKt.nullOutSpilledVariable(langLabel);
                c00092.L$11 = SpillingKt.nullOutSpilledVariable(displayTitle);
                c00092.I$0 = id;
                c00092.label = 3;
                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, displayTitle, url3, tvType4, episodeList2, c00114, c00092);
                if (objNewTvSeriesLoadResponse == coroutine_suspended) {
                    return coroutine_suspended;
                }
                url4 = url3;
                return (LoadResponse) objNewTvSeriesLoadResponse;
            case 1:
                String url6 = (String) c00092.L$0;
                ResultKt.throwOnFailure($result);
                url2 = url6;
                str = StringsKt.substringAfterLast$default(url2, "/", (String) null, 2, (Object) null);
                parts = StringsKt.split$default(str, new String[]{":"}, false, 0, 6, (Object) null);
                if (parts.size() != 2) {
                    return null;
                }
                type = (String) parts.get(0);
                intOrNull = StringsKt.toIntOrNull((String) parts.get(1));
                if (intOrNull != null) {
                    return null;
                }
                id = intOrNull.intValue();
                if (Intrinsics.areEqual(type, "movie")) {
                    it3 = this.cachedMovies.iterator();
                    do {
                        if (it3.hasNext()) {
                            next2 = it3.next();
                            if (((Movie) next2).getId() == id) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                        } else {
                            next2 = null;
                        }
                        movie = (Movie) next2;
                        if (movie == null) {
                            return null;
                        }
                        String strDisplayName3 = displayName(movie);
                        TvType tvType5 = TvType.Movie;
                        String str7 = "movie:" + movie.getId();
                        C00102 c00104 = new C00102(movie, null);
                        c00092.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                        c00092.L$1 = SpillingKt.nullOutSpilledVariable(str);
                        c00092.L$2 = SpillingKt.nullOutSpilledVariable(parts);
                        c00092.L$3 = SpillingKt.nullOutSpilledVariable(type);
                        c00092.L$4 = SpillingKt.nullOutSpilledVariable(movie);
                        c00092.I$0 = id;
                        c00092.label = 2;
                        objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, strDisplayName3, url2, tvType5, str7, c00104, c00092);
                        if (objNewMovieLoadResponse == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        url5 = url2;
                        id2 = id;
                        type2 = type;
                        parts2 = parts;
                        str4 = str;
                        return (LoadResponse) objNewMovieLoadResponse;
                    } while (!z4);
                    movie = (Movie) next2;
                    if (movie == null) {
                        return null;
                    }
                    String strDisplayName4 = displayName(movie);
                    TvType tvType6 = TvType.Movie;
                    String str8 = "movie:" + movie.getId();
                    C00102 c00105 = new C00102(movie, null);
                    c00092.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                    c00092.L$1 = SpillingKt.nullOutSpilledVariable(str);
                    c00092.L$2 = SpillingKt.nullOutSpilledVariable(parts);
                    c00092.L$3 = SpillingKt.nullOutSpilledVariable(type);
                    c00092.L$4 = SpillingKt.nullOutSpilledVariable(movie);
                    c00092.I$0 = id;
                    c00092.label = 2;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, strDisplayName4, url2, tvType6, str8, c00105, c00092);
                    if (objNewMovieLoadResponse == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    url5 = url2;
                    id2 = id;
                    type2 = type;
                    parts2 = parts;
                    str4 = str;
                    return (LoadResponse) objNewMovieLoadResponse;
                }
                if (Intrinsics.areEqual(type, "episode")) {
                    return null;
                }
                it = this.cachedEpisodes.iterator();
                do {
                    if (it.hasNext()) {
                        next = it.next();
                        if (((Episode) next).getId() == id) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                    } else {
                        next = null;
                    }
                    ep = (Episode) next;
                    if (ep == null) {
                        return null;
                    }
                    Iterable $this$filter$iv3 = this.cachedEpisodes;
                    destination$iv$iv = new ArrayList();
                    while (r18.hasNext()) {
                        it2 = (Episode) element$iv$iv;
                        Object $result4 = $result;
                        if (it2.getShowId() == ep.getShowId()) {
                            z2 = false;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            destination$iv$iv.add(element$iv$iv);
                        }
                        $result = $result4;
                    }
                    showEpisodes = CollectionsKt.sortedWith((List) destination$iv$iv, ComparisonsKt.compareBy(new Function1[]{new Function1() { // from class: com.cncverse.XonProvider$$ExternalSyntheticLambda4
                        public final Object invoke(Object obj) {
                            return XonProvider.load$lambda$3((XonProvider.Episode) obj);
                        }
                    }, new Function1() { // from class: com.cncverse.XonProvider$$ExternalSyntheticLambda5
                        public final Object invoke(Object obj) {
                            return XonProvider.load$lambda$4((XonProvider.Episode) obj);
                        }
                    }}));
                    List $this$map$iv6 = showEpisodes;
                    destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv6, 10));
                    while (r16.hasNext()) {
                        destination$iv$iv2.add(Boxing.boxInt(((Episode) item$iv$iv).getSeasonId()));
                    }
                    List seasonIds3 = CollectionsKt.sorted(CollectionsKt.distinct((List) destination$iv$iv2));
                    $this$associate$iv = CollectionsKt.withIndex(seasonIds3);
                    int capacity$iv3 = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associate$iv, 10)), 16);
                    destination$iv$iv3 = new LinkedHashMap(capacity$iv3);
                    while (r17.hasNext()) {
                        int idx3 = indexedValue.component1();
                        int sid3 = ((Number) indexedValue.component2()).intValue();
                        List showEpisodes6 = showEpisodes;
                        Pair pair3 = TuplesKt.to(Boxing.boxInt(sid3), Boxing.boxInt(idx3 + 1));
                        destination$iv$iv3.put(pair3.getFirst(), pair3.getSecond());
                        showEpisodes = showEpisodes6;
                        $this$associate$iv = $this$associate$iv;
                    }
                    List showEpisodes7 = showEpisodes;
                    $this$map$iv = showEpisodes7;
                    $i$f$map = 0;
                    destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    $this$mapTo$iv$iv = $this$map$iv;
                    while (r16.hasNext()) {
                        Iterable $this$map$iv7 = $this$map$iv;
                        final Episode e3 = (Episode) item$iv$iv2;
                        destination$iv$iv4.add(MainAPIKt.newEpisode(this, "episode:" + e3.getId(), new Function1() { // from class: com.cncverse.XonProvider$$ExternalSyntheticLambda6
                            public final Object invoke(Object obj) {
                                return XonProvider.load$lambda$7$0(e3, destination$iv$iv3, this, (Episode) obj);
                            }
                        }));
                        $this$map$iv = $this$map$iv7;
                        $i$f$map = $i$f$map;
                        url2 = url2;
                        $this$mapTo$iv$iv = $this$mapTo$iv$iv;
                    }
                    url3 = url2;
                    List episodeList3 = (List) destination$iv$iv4;
                    showName = ep.getShowName();
                    str2 = "Show";
                    if (showName != null) {
                        str3 = showName;
                        if (str3.length() == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            str2 = str3;
                        }
                        str2 = str2;
                    }
                    showTitle = str2;
                    langLabel = ep.getLanguageName();
                    if (langLabel == null) {
                        langLabel = "";
                    }
                    if (langLabel.length() > 0) {
                        displayTitle = showTitle + " (" + langLabel + ')';
                    } else {
                        displayTitle = showTitle;
                    }
                    TvType tvType7 = TvType.TvSeries;
                    C00113 c00115 = new C00113(ep, langLabel, null);
                    c00092.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                    c00092.L$1 = SpillingKt.nullOutSpilledVariable(str);
                    c00092.L$2 = SpillingKt.nullOutSpilledVariable(parts);
                    c00092.L$3 = SpillingKt.nullOutSpilledVariable(type);
                    c00092.L$4 = SpillingKt.nullOutSpilledVariable(ep);
                    c00092.L$5 = SpillingKt.nullOutSpilledVariable(showEpisodes7);
                    c00092.L$6 = SpillingKt.nullOutSpilledVariable(seasonIds3);
                    c00092.L$7 = SpillingKt.nullOutSpilledVariable(destination$iv$iv3);
                    c00092.L$8 = SpillingKt.nullOutSpilledVariable(episodeList3);
                    c00092.L$9 = SpillingKt.nullOutSpilledVariable(showTitle);
                    c00092.L$10 = SpillingKt.nullOutSpilledVariable(langLabel);
                    c00092.L$11 = SpillingKt.nullOutSpilledVariable(displayTitle);
                    c00092.I$0 = id;
                    c00092.label = 3;
                    objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, displayTitle, url3, tvType7, episodeList3, c00115, c00092);
                    if (objNewTvSeriesLoadResponse == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    url4 = url3;
                    return (LoadResponse) objNewTvSeriesLoadResponse;
                } while (!z3);
                ep = (Episode) next;
                if (ep == null) {
                    return null;
                }
                Iterable $this$filter$iv4 = this.cachedEpisodes;
                destination$iv$iv = new ArrayList();
                while (r18.hasNext()) {
                    it2 = (Episode) element$iv$iv;
                    Object $result5 = $result;
                    if (it2.getShowId() == ep.getShowId()) {
                        z2 = false;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                    $result = $result5;
                }
                showEpisodes = CollectionsKt.sortedWith((List) destination$iv$iv, ComparisonsKt.compareBy(new Function1[]{new Function1() { // from class: com.cncverse.XonProvider$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj) {
                        return XonProvider.load$lambda$3((XonProvider.Episode) obj);
                    }
                }, new Function1() { // from class: com.cncverse.XonProvider$$ExternalSyntheticLambda5
                    public final Object invoke(Object obj) {
                        return XonProvider.load$lambda$4((XonProvider.Episode) obj);
                    }
                }}));
                List $this$map$iv8 = showEpisodes;
                destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv8, 10));
                while (r16.hasNext()) {
                    destination$iv$iv2.add(Boxing.boxInt(((Episode) item$iv$iv).getSeasonId()));
                }
                List seasonIds4 = CollectionsKt.sorted(CollectionsKt.distinct((List) destination$iv$iv2));
                $this$associate$iv = CollectionsKt.withIndex(seasonIds4);
                int capacity$iv4 = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associate$iv, 10)), 16);
                destination$iv$iv3 = new LinkedHashMap(capacity$iv4);
                while (r17.hasNext()) {
                    int idx4 = indexedValue.component1();
                    int sid4 = ((Number) indexedValue.component2()).intValue();
                    List showEpisodes8 = showEpisodes;
                    Pair pair4 = TuplesKt.to(Boxing.boxInt(sid4), Boxing.boxInt(idx4 + 1));
                    destination$iv$iv3.put(pair4.getFirst(), pair4.getSecond());
                    showEpisodes = showEpisodes8;
                    $this$associate$iv = $this$associate$iv;
                }
                List showEpisodes9 = showEpisodes;
                $this$map$iv = showEpisodes9;
                $i$f$map = 0;
                destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                $this$mapTo$iv$iv = $this$map$iv;
                while (r16.hasNext()) {
                    Iterable $this$map$iv9 = $this$map$iv;
                    final Episode e4 = (Episode) item$iv$iv2;
                    destination$iv$iv4.add(MainAPIKt.newEpisode(this, "episode:" + e4.getId(), new Function1() { // from class: com.cncverse.XonProvider$$ExternalSyntheticLambda6
                        public final Object invoke(Object obj) {
                            return XonProvider.load$lambda$7$0(e4, destination$iv$iv3, this, (Episode) obj);
                        }
                    }));
                    $this$map$iv = $this$map$iv9;
                    $i$f$map = $i$f$map;
                    url2 = url2;
                    $this$mapTo$iv$iv = $this$mapTo$iv$iv;
                }
                url3 = url2;
                List episodeList4 = (List) destination$iv$iv4;
                showName = ep.getShowName();
                str2 = "Show";
                if (showName != null) {
                    str3 = showName;
                    if (str3.length() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        str2 = str3;
                    }
                    str2 = str2;
                }
                showTitle = str2;
                langLabel = ep.getLanguageName();
                if (langLabel == null) {
                    langLabel = "";
                }
                if (langLabel.length() > 0) {
                    displayTitle = showTitle + " (" + langLabel + ')';
                } else {
                    displayTitle = showTitle;
                }
                TvType tvType8 = TvType.TvSeries;
                C00113 c00116 = new C00113(ep, langLabel, null);
                c00092.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                c00092.L$1 = SpillingKt.nullOutSpilledVariable(str);
                c00092.L$2 = SpillingKt.nullOutSpilledVariable(parts);
                c00092.L$3 = SpillingKt.nullOutSpilledVariable(type);
                c00092.L$4 = SpillingKt.nullOutSpilledVariable(ep);
                c00092.L$5 = SpillingKt.nullOutSpilledVariable(showEpisodes9);
                c00092.L$6 = SpillingKt.nullOutSpilledVariable(seasonIds4);
                c00092.L$7 = SpillingKt.nullOutSpilledVariable(destination$iv$iv3);
                c00092.L$8 = SpillingKt.nullOutSpilledVariable(episodeList4);
                c00092.L$9 = SpillingKt.nullOutSpilledVariable(showTitle);
                c00092.L$10 = SpillingKt.nullOutSpilledVariable(langLabel);
                c00092.L$11 = SpillingKt.nullOutSpilledVariable(displayTitle);
                c00092.I$0 = id;
                c00092.label = 3;
                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, displayTitle, url3, tvType8, episodeList4, c00116, c00092);
                if (objNewTvSeriesLoadResponse == coroutine_suspended) {
                    return coroutine_suspended;
                }
                url4 = url3;
                return (LoadResponse) objNewTvSeriesLoadResponse;
            case 2:
                id2 = c00092.I$0;
                type2 = (String) c00092.L$3;
                parts2 = (List) c00092.L$2;
                str4 = (String) c00092.L$1;
                url5 = (String) c00092.L$0;
                ResultKt.throwOnFailure($result);
                objNewMovieLoadResponse = $result;
                return (LoadResponse) objNewMovieLoadResponse;
            case 3:
                int i = c00092.I$0;
                url4 = (String) c00092.L$0;
                ResultKt.throwOnFailure($result);
                objNewTvSeriesLoadResponse = $result;
                return (LoadResponse) objNewTvSeriesLoadResponse;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.cncverse.XonProvider$load$2 */
    /* JADX INFO: compiled from: XonProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.XonProvider$load$2", f = "XonProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nXonProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 XonProvider.kt\ncom/cncverse/XonProvider$load$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,515:1\n1#2:516\n*E\n"})
    static final class C00102 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ Movie $movie;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00102(Movie movie, Continuation<? super C00102> continuation) {
            super(2, continuation);
            this.$movie = movie;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00102 = XonProvider.this.new C00102(this.$movie, continuation);
            c00102.L$0 = obj;
            return c00102;
        }

        public final Object invoke(MovieLoadResponse movieLoadResponse, Continuation<? super Unit> continuation) {
            return create(movieLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            String strTake;
            MovieLoadResponse $this$newMovieLoadResponse = (MovieLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$newMovieLoadResponse.setPosterUrl(XonProvider.this.bestPoster(this.$movie));
                    Movie movie = this.$movie;
                    StringBuilder $this$invokeSuspend_u24lambda_u240 = new StringBuilder();
                    String it = movie.getDes();
                    if (it != null) {
                        $this$invokeSuspend_u24lambda_u240.append(it);
                        $this$invokeSuspend_u24lambda_u240.append("\n\n");
                    }
                    String rating = movie.getRating();
                    if (!(rating == null || rating.length() == 0)) {
                        $this$invokeSuspend_u24lambda_u240.append("⭐ " + movie.getRating() + '\n');
                    }
                    String avgRuntime = movie.getAvgRuntime();
                    if (!(avgRuntime == null || avgRuntime.length() == 0)) {
                        $this$invokeSuspend_u24lambda_u240.append("⏱ " + movie.getAvgRuntime() + '\n');
                    }
                    String ageRating = movie.getAgeRating();
                    if (!(ageRating == null || ageRating.length() == 0)) {
                        $this$invokeSuspend_u24lambda_u240.append("👶 " + movie.getAgeRating() + '\n');
                    }
                    String languageName = movie.getLanguageName();
                    if (!(languageName == null || languageName.length() == 0)) {
                        $this$invokeSuspend_u24lambda_u240.append("🌐 " + movie.getLanguageName());
                    }
                    $this$newMovieLoadResponse.setPlot($this$invokeSuspend_u24lambda_u240.toString());
                    String createdAt = this.$movie.getCreatedAt();
                    $this$newMovieLoadResponse.setYear((createdAt == null || (strTake = StringsKt.take(createdAt, 4)) == null) ? null : StringsKt.toIntOrNull(strTake));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable load$lambda$3(Episode it) {
        return Integer.valueOf(it.getSeasonId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable load$lambda$4(Episode it) {
        return Integer.valueOf(it.getNo());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$7$0(Episode $e, Map $seasonNoMap, XonProvider this$0, com.lagradost.cloudstream3.Episode $this$newEpisode) {
        $this$newEpisode.setName($e.getName());
        $this$newEpisode.setSeason((Integer) $seasonNoMap.get(Integer.valueOf($e.getSeasonId())));
        $this$newEpisode.setEpisode(Integer.valueOf($e.getNo()));
        String thumb = $e.getThumb();
        $this$newEpisode.setPosterUrl(!(thumb == null || thumb.length() == 0) ? this$0.formatUrl($e.getThumb()) : "");
        String des = $e.getDes();
        String str = null;
        if (des != null) {
            String str2 = des;
            if (!(str2.length() == 0)) {
                str = str2;
            }
            str = str;
        }
        $this$newEpisode.setDescription(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.cncverse.XonProvider$load$3 */
    /* JADX INFO: compiled from: XonProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.XonProvider$load$3", f = "XonProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00113 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ Episode $ep;
        final /* synthetic */ String $langLabel;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00113(Episode episode, String str, Continuation<? super C00113> continuation) {
            super(2, continuation);
            this.$ep = episode;
            this.$langLabel = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00113 = XonProvider.this.new C00113(this.$ep, this.$langLabel, continuation);
            c00113.L$0 = obj;
            return c00113;
        }

        public final Object invoke(TvSeriesLoadResponse tvSeriesLoadResponse, Continuation<? super Unit> continuation) {
            return create(tvSeriesLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:23:0x005f  */
        /* JADX WARN: Code duplicated, block: B:25:0x0069  */
        /* JADX WARN: Code duplicated, block: B:29:0x0072  */
        /* JADX WARN: Code duplicated, block: B:31:0x0075  */
        /* JADX WARN: Code duplicated, block: B:32:0x0082  */
        /* JADX WARN: Code duplicated, block: B:36:0x0092  */
        /* JADX WARN: Code duplicated, block: B:38:0x0095  */
        public final Object invokeSuspend(Object $result) {
            Object next;
            Movie matchedMovie;
            String thumb;
            boolean z;
            String url;
            Movie it;
            TvSeriesLoadResponse $this$newTvSeriesLoadResponse = (TvSeriesLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    List list = XonProvider.this.cachedMovies;
                    Episode episode = this.$ep;
                    Iterator it2 = list.iterator();
                    do {
                        if (it2.hasNext()) {
                            next = it2.next();
                            it = (Movie) next;
                        } else {
                            next = null;
                        }
                        matchedMovie = (Movie) next;
                        if (matchedMovie != null || (url = XonProvider.this.bestPoster(matchedMovie)) == null) {
                            thumb = this.$ep.getThumb();
                            if (thumb != null || thumb.length() == 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                url = "";
                            } else {
                                url = XonProvider.this.formatUrl(this.$ep.getThumb());
                            }
                        }
                        $this$newTvSeriesLoadResponse.setPosterUrl(url);
                        $this$newTvSeriesLoadResponse.setPlot(this.$langLabel.length() > 0 ? "Language: " + this.$langLabel : null);
                        return Unit.INSTANCE;
                    } while (!(it.getShowId() == episode.getShowId() && it.getLanguage() == episode.getLanguage()));
                    matchedMovie = (Movie) next;
                    if (matchedMovie != null) {
                        thumb = this.$ep.getThumb();
                        if (thumb != null) {
                            z = true;
                        } else {
                            z = true;
                        }
                        if (z) {
                            url = XonProvider.this.formatUrl(this.$ep.getThumb());
                        } else {
                            url = "";
                        }
                    } else {
                        thumb = this.$ep.getThumb();
                        if (thumb != null) {
                            z = true;
                        } else {
                            z = true;
                        }
                        if (z) {
                            url = XonProvider.this.formatUrl(this.$ep.getThumb());
                        } else {
                            url = "";
                        }
                    }
                    $this$newTvSeriesLoadResponse.setPosterUrl(url);
                    $this$newTvSeriesLoadResponse.setPlot(this.$langLabel.length() > 0 ? "Language: " + this.$langLabel : null);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0328  */
    /* JADX WARN: Code duplicated, block: B:103:0x032d  */
    /* JADX WARN: Code duplicated, block: B:105:0x0334  */
    /* JADX WARN: Code duplicated, block: B:108:0x033c  */
    /* JADX WARN: Code duplicated, block: B:111:0x0344  */
    /* JADX WARN: Code duplicated, block: B:114:0x034c  */
    /* JADX WARN: Code duplicated, block: B:117:0x037b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:118:0x037c  */
    /* JADX WARN: Code duplicated, block: B:121:0x038e  */
    /* JADX WARN: Code duplicated, block: B:125:0x0397  */
    /* JADX WARN: Code duplicated, block: B:127:0x039a  */
    /* JADX WARN: Code duplicated, block: B:129:0x03c9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:131:0x03cd  */
    /* JADX WARN: Code duplicated, block: B:134:0x03d7  */
    /* JADX WARN: Code duplicated, block: B:136:0x03dd  */
    /* JADX WARN: Code duplicated, block: B:138:0x03e1  */
    /* JADX WARN: Code duplicated, block: B:140:0x041c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:141:0x041d  */
    /* JADX WARN: Code duplicated, block: B:145:0x0426  */
    /* JADX WARN: Code duplicated, block: B:147:0x042b  */
    /* JADX WARN: Code duplicated, block: B:149:0x01e0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:150:0x01d8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:152:0x0323 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:25:0x0187  */
    /* JADX WARN: Code duplicated, block: B:27:0x018c  */
    /* JADX WARN: Code duplicated, block: B:29:0x019e  */
    /* JADX WARN: Code duplicated, block: B:31:0x01af  */
    /* JADX WARN: Code duplicated, block: B:34:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:36:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:37:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:40:0x01db A[LOOP:0: B:32:0x01b7->B:40:0x01db, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:44:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:46:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:48:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:51:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:54:0x0207  */
    /* JADX WARN: Code duplicated, block: B:58:0x0210  */
    /* JADX WARN: Code duplicated, block: B:61:0x0248 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:62:0x0249  */
    /* JADX WARN: Code duplicated, block: B:65:0x025b  */
    /* JADX WARN: Code duplicated, block: B:69:0x0264  */
    /* JADX WARN: Code duplicated, block: B:71:0x0267  */
    /* JADX WARN: Code duplicated, block: B:73:0x0296 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:75:0x029a  */
    /* JADX WARN: Code duplicated, block: B:78:0x02a4  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:80:0x02aa  */
    /* JADX WARN: Code duplicated, block: B:82:0x02ae  */
    /* JADX WARN: Code duplicated, block: B:84:0x02e9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:85:0x02ea  */
    /* JADX WARN: Code duplicated, block: B:87:0x02f0  */
    /* JADX WARN: Code duplicated, block: B:89:0x0301  */
    /* JADX WARN: Code duplicated, block: B:92:0x030f  */
    /* JADX WARN: Code duplicated, block: B:94:0x031d  */
    /* JADX WARN: Code duplicated, block: B:95:0x031f  */
    /* JADX WARN: Instruction removed from duplicated block: B:29:0x019e, please report this as an issue */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00121 c00121;
        String data2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        boolean isCasting2;
        String str;
        List parts;
        String type;
        Integer intOrNull;
        int id;
        boolean z;
        boolean z2;
        Iterator<T> it;
        Object next;
        Movie movie;
        String basic;
        String sd;
        String hd;
        String fhd;
        String data3;
        String str2;
        String type2;
        Movie movie2;
        int id2;
        boolean isCasting3;
        Function1<? super ExtractorLink, Unit> function5;
        List parts2;
        Movie it2;
        boolean z3;
        Iterator<T> it3;
        int id3;
        boolean z4;
        Object obj;
        Episode ep;
        String basic2;
        String sd2;
        String hd2;
        String type3;
        String data4;
        String str3;
        String type4;
        Episode ep2;
        int id4;
        boolean isCasting4;
        Function1<? super ExtractorLink, Unit> function6;
        List parts3;
        Object next2;
        Episode it4;
        boolean z5;
        String aplayer1;
        boolean z6;
        Function1<? super ExtractorLink, Unit> function7;
        String data5;
        String aplayer2;
        String aplayer3;
        String aplayer4;
        String str4;
        Function1<? super SubtitleFile, Unit> function8;
        String xPlayer2;
        boolean z7;
        Function1<? super ExtractorLink, Unit> function9;
        String data6;
        String xPlayer3;
        String xPlayer4;
        String xPlayer5;
        String str5;
        Function1<? super SubtitleFile, Unit> function10;
        if (continuation instanceof C00121) {
            c00121 = (C00121) continuation;
            if ((c00121.label & Integer.MIN_VALUE) != 0) {
                c00121.label -= Integer.MIN_VALUE;
            } else {
                c00121 = new C00121(continuation);
            }
        } else {
            c00121 = new C00121(continuation);
        }
        C00121 c00122 = c00121;
        Object $result = c00122.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00122.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                c00122.L$0 = data;
                c00122.L$1 = function1;
                c00122.L$2 = function2;
                c00122.Z$0 = isCasting;
                c00122.label = 1;
                if (refreshCache(c00122) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                data2 = data;
                function3 = function1;
                function4 = function2;
                isCasting2 = isCasting;
                str = StringsKt.substringAfterLast$default(data2, "/", (String) null, 2, (Object) null);
                parts = StringsKt.split$default(str, new String[]{":"}, false, 0, 6, (Object) null);
                if (parts.size() != 2) {
                    return Boxing.boxBoolean(false);
                }
                type = (String) parts.get(0);
                intOrNull = StringsKt.toIntOrNull((String) parts.get(1));
                if (intOrNull != null) {
                    return Boxing.boxBoolean(false);
                }
                id = intOrNull.intValue();
                if (Intrinsics.areEqual(type, "episode")) {
                    it3 = this.cachedEpisodes.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            next2 = it3.next();
                            it4 = (Episode) next2;
                            z = true;
                            id3 = id;
                            z4 = false;
                            if (it4.getId() == id3) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            if (z5) {
                                obj = next2;
                            } else {
                                id = id3;
                            }
                        } else {
                            id3 = id;
                            z = true;
                            z4 = false;
                            obj = null;
                        }
                    }
                    ep = (Episode) obj;
                    if (ep == null) {
                        return Boxing.boxBoolean(z4);
                    }
                    basic2 = ep.getBasic();
                    if (basic2 == null) {
                        basic2 = "";
                    }
                    sd2 = ep.getSd();
                    if (sd2 == null) {
                        sd2 = "";
                    }
                    hd2 = ep.getHd();
                    if (hd2 == null) {
                        hd2 = "";
                    }
                    String fhd2 = ep.getFhd();
                    type3 = fhd2 != null ? fhd2 : "";
                    c00122.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                    c00122.L$1 = function3;
                    c00122.L$2 = function4;
                    c00122.L$3 = SpillingKt.nullOutSpilledVariable(str);
                    c00122.L$4 = SpillingKt.nullOutSpilledVariable(parts);
                    c00122.L$5 = SpillingKt.nullOutSpilledVariable(type);
                    c00122.L$6 = ep;
                    c00122.Z$0 = isCasting2;
                    c00122.I$0 = id3;
                    c00122.label = 2;
                    if (addVideoLinks(basic2, sd2, hd2, type3, function4, c00122) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    data4 = data2;
                    str3 = str;
                    type4 = type;
                    ep2 = ep;
                    id4 = id3;
                    isCasting4 = isCasting2;
                    function6 = function4;
                    parts3 = parts;
                    aplayer1 = ep2.getAplayer1();
                    if (aplayer1 != null || aplayer1.length() == 0) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (z6) {
                        function7 = function6;
                        data5 = data4;
                    } else {
                        aplayer2 = ep2.getAplayer1();
                        c00122.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                        c00122.L$1 = function3;
                        c00122.L$2 = function6;
                        c00122.L$3 = SpillingKt.nullOutSpilledVariable(str3);
                        c00122.L$4 = SpillingKt.nullOutSpilledVariable(parts3);
                        c00122.L$5 = SpillingKt.nullOutSpilledVariable(type4);
                        c00122.L$6 = ep2;
                        c00122.Z$0 = isCasting4;
                        c00122.I$0 = id4;
                        c00122.label = 3;
                        if (ExtractorApiKt.loadExtractor(aplayer2, function3, function6, c00122) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function7 = function6;
                        data5 = data4;
                    }
                    aplayer3 = ep2.getAplayer2();
                    if (aplayer3 != null || aplayer3.length() == 0) {
                        z4 = true;
                    }
                    if (!z4) {
                        aplayer4 = ep2.getAplayer2();
                        c00122.L$0 = SpillingKt.nullOutSpilledVariable(data5);
                        c00122.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                        c00122.L$2 = SpillingKt.nullOutSpilledVariable(function7);
                        c00122.L$3 = SpillingKt.nullOutSpilledVariable(str3);
                        c00122.L$4 = SpillingKt.nullOutSpilledVariable(parts3);
                        c00122.L$5 = SpillingKt.nullOutSpilledVariable(type4);
                        c00122.L$6 = SpillingKt.nullOutSpilledVariable(ep2);
                        c00122.Z$0 = isCasting4;
                        c00122.I$0 = id4;
                        c00122.label = 4;
                        if (ExtractorApiKt.loadExtractor(aplayer4, function3, function7, c00122) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        str4 = str3;
                        function8 = function3;
                    }
                    return Boxing.boxBoolean(z);
                }
                z = true;
                z2 = false;
                if (Intrinsics.areEqual(type, "movie")) {
                    return Boxing.boxBoolean(false);
                }
                it = this.cachedMovies.iterator();
                do {
                    if (it.hasNext()) {
                        next = it.next();
                        it2 = (Movie) next;
                        if (it2.getId() == id) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                    } else {
                        next = null;
                    }
                    movie = (Movie) next;
                    if (movie == null) {
                        return Boxing.boxBoolean(false);
                    }
                    basic = movie.getBasic();
                    if (basic == null) {
                        basic = "";
                    }
                    sd = movie.getSd();
                    if (sd == null) {
                        sd = "";
                    }
                    hd = movie.getHd();
                    if (hd == null) {
                        hd = "";
                    }
                    fhd = movie.getFhd();
                    if (fhd == null) {
                        fhd = "";
                    }
                    c00122.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                    c00122.L$1 = function3;
                    c00122.L$2 = function4;
                    c00122.L$3 = SpillingKt.nullOutSpilledVariable(str);
                    c00122.L$4 = SpillingKt.nullOutSpilledVariable(parts);
                    c00122.L$5 = SpillingKt.nullOutSpilledVariable(type);
                    c00122.L$6 = movie;
                    c00122.Z$0 = isCasting2;
                    c00122.I$0 = id;
                    c00122.label = 5;
                    if (addVideoLinks(basic, sd, hd, fhd, function4, c00122) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    data3 = data2;
                    str2 = str;
                    type2 = type;
                    movie2 = movie;
                    id2 = id;
                    isCasting3 = isCasting2;
                    function5 = function4;
                    parts2 = parts;
                    xPlayer2 = movie2.getXPlayer2();
                    if (xPlayer2 != null || xPlayer2.length() == 0) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    if (z7) {
                        function9 = function5;
                        data6 = data3;
                    } else {
                        xPlayer3 = movie2.getXPlayer2();
                        c00122.L$0 = SpillingKt.nullOutSpilledVariable(data3);
                        c00122.L$1 = function3;
                        c00122.L$2 = function5;
                        c00122.L$3 = SpillingKt.nullOutSpilledVariable(str2);
                        c00122.L$4 = SpillingKt.nullOutSpilledVariable(parts2);
                        c00122.L$5 = SpillingKt.nullOutSpilledVariable(type2);
                        c00122.L$6 = movie2;
                        c00122.Z$0 = isCasting3;
                        c00122.I$0 = id2;
                        c00122.label = 6;
                        if (ExtractorApiKt.loadExtractor(xPlayer3, function3, function5, c00122) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function9 = function5;
                        data6 = data3;
                    }
                    xPlayer4 = movie2.getXPlayer3();
                    if (xPlayer4 != null || xPlayer4.length() == 0) {
                        z2 = true;
                    }
                    if (!z2) {
                        xPlayer5 = movie2.getXPlayer3();
                        c00122.L$0 = SpillingKt.nullOutSpilledVariable(data6);
                        c00122.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                        c00122.L$2 = SpillingKt.nullOutSpilledVariable(function9);
                        c00122.L$3 = SpillingKt.nullOutSpilledVariable(str2);
                        c00122.L$4 = SpillingKt.nullOutSpilledVariable(parts2);
                        c00122.L$5 = SpillingKt.nullOutSpilledVariable(type2);
                        c00122.L$6 = SpillingKt.nullOutSpilledVariable(movie2);
                        c00122.Z$0 = isCasting3;
                        c00122.I$0 = id2;
                        c00122.label = 7;
                        if (ExtractorApiKt.loadExtractor(xPlayer5, function3, function9, c00122) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        str5 = str2;
                        function10 = function3;
                    }
                    return Boxing.boxBoolean(z);
                } while (!z3);
                movie = (Movie) next;
                if (movie == null) {
                    return Boxing.boxBoolean(false);
                }
                basic = movie.getBasic();
                if (basic == null) {
                    basic = "";
                }
                sd = movie.getSd();
                if (sd == null) {
                    sd = "";
                }
                hd = movie.getHd();
                if (hd == null) {
                    hd = "";
                }
                fhd = movie.getFhd();
                if (fhd == null) {
                    fhd = "";
                }
                c00122.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00122.L$1 = function3;
                c00122.L$2 = function4;
                c00122.L$3 = SpillingKt.nullOutSpilledVariable(str);
                c00122.L$4 = SpillingKt.nullOutSpilledVariable(parts);
                c00122.L$5 = SpillingKt.nullOutSpilledVariable(type);
                c00122.L$6 = movie;
                c00122.Z$0 = isCasting2;
                c00122.I$0 = id;
                c00122.label = 5;
                if (addVideoLinks(basic, sd, hd, fhd, function4, c00122) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                data3 = data2;
                str2 = str;
                type2 = type;
                movie2 = movie;
                id2 = id;
                isCasting3 = isCasting2;
                function5 = function4;
                parts2 = parts;
                xPlayer2 = movie2.getXPlayer2();
                if (xPlayer2 != null) {
                    z7 = true;
                } else {
                    z7 = true;
                }
                if (z7) {
                    xPlayer3 = movie2.getXPlayer2();
                    c00122.L$0 = SpillingKt.nullOutSpilledVariable(data3);
                    c00122.L$1 = function3;
                    c00122.L$2 = function5;
                    c00122.L$3 = SpillingKt.nullOutSpilledVariable(str2);
                    c00122.L$4 = SpillingKt.nullOutSpilledVariable(parts2);
                    c00122.L$5 = SpillingKt.nullOutSpilledVariable(type2);
                    c00122.L$6 = movie2;
                    c00122.Z$0 = isCasting3;
                    c00122.I$0 = id2;
                    c00122.label = 6;
                    if (ExtractorApiKt.loadExtractor(xPlayer3, function3, function5, c00122) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function9 = function5;
                    data6 = data3;
                } else {
                    function9 = function5;
                    data6 = data3;
                }
                xPlayer4 = movie2.getXPlayer3();
                if (xPlayer4 != null) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                if (!z2) {
                    xPlayer5 = movie2.getXPlayer3();
                    c00122.L$0 = SpillingKt.nullOutSpilledVariable(data6);
                    c00122.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                    c00122.L$2 = SpillingKt.nullOutSpilledVariable(function9);
                    c00122.L$3 = SpillingKt.nullOutSpilledVariable(str2);
                    c00122.L$4 = SpillingKt.nullOutSpilledVariable(parts2);
                    c00122.L$5 = SpillingKt.nullOutSpilledVariable(type2);
                    c00122.L$6 = SpillingKt.nullOutSpilledVariable(movie2);
                    c00122.Z$0 = isCasting3;
                    c00122.I$0 = id2;
                    c00122.label = 7;
                    if (ExtractorApiKt.loadExtractor(xPlayer5, function3, function9, c00122) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str5 = str2;
                    function10 = function3;
                }
                return Boxing.boxBoolean(z);
            case 1:
                boolean isCasting5 = c00122.Z$0;
                Function1<? super ExtractorLink, Unit> function11 = (Function1) c00122.L$2;
                Function1<? super SubtitleFile, Unit> function12 = (Function1) c00122.L$1;
                String data7 = (String) c00122.L$0;
                ResultKt.throwOnFailure($result);
                isCasting2 = isCasting5;
                function4 = function11;
                function3 = function12;
                data2 = data7;
                str = StringsKt.substringAfterLast$default(data2, "/", (String) null, 2, (Object) null);
                parts = StringsKt.split$default(str, new String[]{":"}, false, 0, 6, (Object) null);
                if (parts.size() != 2) {
                    return Boxing.boxBoolean(false);
                }
                type = (String) parts.get(0);
                intOrNull = StringsKt.toIntOrNull((String) parts.get(1));
                if (intOrNull != null) {
                    return Boxing.boxBoolean(false);
                }
                id = intOrNull.intValue();
                if (Intrinsics.areEqual(type, "episode")) {
                    it3 = this.cachedEpisodes.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            next2 = it3.next();
                            it4 = (Episode) next2;
                            z = true;
                            id3 = id;
                            z4 = false;
                            if (it4.getId() == id3) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            if (z5) {
                                obj = next2;
                            } else {
                                id = id3;
                            }
                        } else {
                            id3 = id;
                            z = true;
                            z4 = false;
                            obj = null;
                        }
                    }
                    ep = (Episode) obj;
                    if (ep == null) {
                        return Boxing.boxBoolean(z4);
                    }
                    basic2 = ep.getBasic();
                    if (basic2 == null) {
                        basic2 = "";
                    }
                    sd2 = ep.getSd();
                    if (sd2 == null) {
                        sd2 = "";
                    }
                    hd2 = ep.getHd();
                    if (hd2 == null) {
                        hd2 = "";
                    }
                    String fhd3 = ep.getFhd();
                    if (fhd3 != null) {
                    }
                    c00122.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                    c00122.L$1 = function3;
                    c00122.L$2 = function4;
                    c00122.L$3 = SpillingKt.nullOutSpilledVariable(str);
                    c00122.L$4 = SpillingKt.nullOutSpilledVariable(parts);
                    c00122.L$5 = SpillingKt.nullOutSpilledVariable(type);
                    c00122.L$6 = ep;
                    c00122.Z$0 = isCasting2;
                    c00122.I$0 = id3;
                    c00122.label = 2;
                    if (addVideoLinks(basic2, sd2, hd2, type3, function4, c00122) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    data4 = data2;
                    str3 = str;
                    type4 = type;
                    ep2 = ep;
                    id4 = id3;
                    isCasting4 = isCasting2;
                    function6 = function4;
                    parts3 = parts;
                    aplayer1 = ep2.getAplayer1();
                    if (aplayer1 != null) {
                        z6 = true;
                    } else {
                        z6 = true;
                    }
                    if (z6) {
                        aplayer2 = ep2.getAplayer1();
                        c00122.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                        c00122.L$1 = function3;
                        c00122.L$2 = function6;
                        c00122.L$3 = SpillingKt.nullOutSpilledVariable(str3);
                        c00122.L$4 = SpillingKt.nullOutSpilledVariable(parts3);
                        c00122.L$5 = SpillingKt.nullOutSpilledVariable(type4);
                        c00122.L$6 = ep2;
                        c00122.Z$0 = isCasting4;
                        c00122.I$0 = id4;
                        c00122.label = 3;
                        if (ExtractorApiKt.loadExtractor(aplayer2, function3, function6, c00122) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function7 = function6;
                        data5 = data4;
                    } else {
                        function7 = function6;
                        data5 = data4;
                    }
                    aplayer3 = ep2.getAplayer2();
                    if (aplayer3 != null) {
                        z4 = true;
                    } else {
                        z4 = true;
                    }
                    if (!z4) {
                        aplayer4 = ep2.getAplayer2();
                        c00122.L$0 = SpillingKt.nullOutSpilledVariable(data5);
                        c00122.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                        c00122.L$2 = SpillingKt.nullOutSpilledVariable(function7);
                        c00122.L$3 = SpillingKt.nullOutSpilledVariable(str3);
                        c00122.L$4 = SpillingKt.nullOutSpilledVariable(parts3);
                        c00122.L$5 = SpillingKt.nullOutSpilledVariable(type4);
                        c00122.L$6 = SpillingKt.nullOutSpilledVariable(ep2);
                        c00122.Z$0 = isCasting4;
                        c00122.I$0 = id4;
                        c00122.label = 4;
                        if (ExtractorApiKt.loadExtractor(aplayer4, function3, function7, c00122) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        str4 = str3;
                        function8 = function3;
                    }
                    return Boxing.boxBoolean(z);
                }
                z = true;
                z2 = false;
                if (Intrinsics.areEqual(type, "movie")) {
                    return Boxing.boxBoolean(false);
                }
                it = this.cachedMovies.iterator();
                do {
                    if (it.hasNext()) {
                        next = it.next();
                        it2 = (Movie) next;
                        if (it2.getId() == id) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                    } else {
                        next = null;
                    }
                    movie = (Movie) next;
                    if (movie == null) {
                        return Boxing.boxBoolean(false);
                    }
                    basic = movie.getBasic();
                    if (basic == null) {
                        basic = "";
                    }
                    sd = movie.getSd();
                    if (sd == null) {
                        sd = "";
                    }
                    hd = movie.getHd();
                    if (hd == null) {
                        hd = "";
                    }
                    fhd = movie.getFhd();
                    if (fhd == null) {
                        fhd = "";
                    }
                    c00122.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                    c00122.L$1 = function3;
                    c00122.L$2 = function4;
                    c00122.L$3 = SpillingKt.nullOutSpilledVariable(str);
                    c00122.L$4 = SpillingKt.nullOutSpilledVariable(parts);
                    c00122.L$5 = SpillingKt.nullOutSpilledVariable(type);
                    c00122.L$6 = movie;
                    c00122.Z$0 = isCasting2;
                    c00122.I$0 = id;
                    c00122.label = 5;
                    if (addVideoLinks(basic, sd, hd, fhd, function4, c00122) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    data3 = data2;
                    str2 = str;
                    type2 = type;
                    movie2 = movie;
                    id2 = id;
                    isCasting3 = isCasting2;
                    function5 = function4;
                    parts2 = parts;
                    xPlayer2 = movie2.getXPlayer2();
                    if (xPlayer2 != null) {
                        z7 = true;
                    } else {
                        z7 = true;
                    }
                    if (z7) {
                        xPlayer3 = movie2.getXPlayer2();
                        c00122.L$0 = SpillingKt.nullOutSpilledVariable(data3);
                        c00122.L$1 = function3;
                        c00122.L$2 = function5;
                        c00122.L$3 = SpillingKt.nullOutSpilledVariable(str2);
                        c00122.L$4 = SpillingKt.nullOutSpilledVariable(parts2);
                        c00122.L$5 = SpillingKt.nullOutSpilledVariable(type2);
                        c00122.L$6 = movie2;
                        c00122.Z$0 = isCasting3;
                        c00122.I$0 = id2;
                        c00122.label = 6;
                        if (ExtractorApiKt.loadExtractor(xPlayer3, function3, function5, c00122) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function9 = function5;
                        data6 = data3;
                    } else {
                        function9 = function5;
                        data6 = data3;
                    }
                    xPlayer4 = movie2.getXPlayer3();
                    if (xPlayer4 != null) {
                        z2 = true;
                    } else {
                        z2 = true;
                    }
                    if (!z2) {
                        xPlayer5 = movie2.getXPlayer3();
                        c00122.L$0 = SpillingKt.nullOutSpilledVariable(data6);
                        c00122.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                        c00122.L$2 = SpillingKt.nullOutSpilledVariable(function9);
                        c00122.L$3 = SpillingKt.nullOutSpilledVariable(str2);
                        c00122.L$4 = SpillingKt.nullOutSpilledVariable(parts2);
                        c00122.L$5 = SpillingKt.nullOutSpilledVariable(type2);
                        c00122.L$6 = SpillingKt.nullOutSpilledVariable(movie2);
                        c00122.Z$0 = isCasting3;
                        c00122.I$0 = id2;
                        c00122.label = 7;
                        if (ExtractorApiKt.loadExtractor(xPlayer5, function3, function9, c00122) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        str5 = str2;
                        function10 = function3;
                    }
                    return Boxing.boxBoolean(z);
                } while (!z3);
                movie = (Movie) next;
                if (movie == null) {
                    return Boxing.boxBoolean(false);
                }
                basic = movie.getBasic();
                if (basic == null) {
                    basic = "";
                }
                sd = movie.getSd();
                if (sd == null) {
                    sd = "";
                }
                hd = movie.getHd();
                if (hd == null) {
                    hd = "";
                }
                fhd = movie.getFhd();
                if (fhd == null) {
                    fhd = "";
                }
                c00122.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00122.L$1 = function3;
                c00122.L$2 = function4;
                c00122.L$3 = SpillingKt.nullOutSpilledVariable(str);
                c00122.L$4 = SpillingKt.nullOutSpilledVariable(parts);
                c00122.L$5 = SpillingKt.nullOutSpilledVariable(type);
                c00122.L$6 = movie;
                c00122.Z$0 = isCasting2;
                c00122.I$0 = id;
                c00122.label = 5;
                if (addVideoLinks(basic, sd, hd, fhd, function4, c00122) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                data3 = data2;
                str2 = str;
                type2 = type;
                movie2 = movie;
                id2 = id;
                isCasting3 = isCasting2;
                function5 = function4;
                parts2 = parts;
                xPlayer2 = movie2.getXPlayer2();
                if (xPlayer2 != null) {
                    z7 = true;
                } else {
                    z7 = true;
                }
                if (z7) {
                    xPlayer3 = movie2.getXPlayer2();
                    c00122.L$0 = SpillingKt.nullOutSpilledVariable(data3);
                    c00122.L$1 = function3;
                    c00122.L$2 = function5;
                    c00122.L$3 = SpillingKt.nullOutSpilledVariable(str2);
                    c00122.L$4 = SpillingKt.nullOutSpilledVariable(parts2);
                    c00122.L$5 = SpillingKt.nullOutSpilledVariable(type2);
                    c00122.L$6 = movie2;
                    c00122.Z$0 = isCasting3;
                    c00122.I$0 = id2;
                    c00122.label = 6;
                    if (ExtractorApiKt.loadExtractor(xPlayer3, function3, function5, c00122) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function9 = function5;
                    data6 = data3;
                } else {
                    function9 = function5;
                    data6 = data3;
                }
                xPlayer4 = movie2.getXPlayer3();
                if (xPlayer4 != null) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                if (!z2) {
                    xPlayer5 = movie2.getXPlayer3();
                    c00122.L$0 = SpillingKt.nullOutSpilledVariable(data6);
                    c00122.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                    c00122.L$2 = SpillingKt.nullOutSpilledVariable(function9);
                    c00122.L$3 = SpillingKt.nullOutSpilledVariable(str2);
                    c00122.L$4 = SpillingKt.nullOutSpilledVariable(parts2);
                    c00122.L$5 = SpillingKt.nullOutSpilledVariable(type2);
                    c00122.L$6 = SpillingKt.nullOutSpilledVariable(movie2);
                    c00122.Z$0 = isCasting3;
                    c00122.I$0 = id2;
                    c00122.label = 7;
                    if (ExtractorApiKt.loadExtractor(xPlayer5, function3, function9, c00122) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str5 = str2;
                    function10 = function3;
                }
                return Boxing.boxBoolean(z);
            case 2:
                id4 = c00122.I$0;
                isCasting4 = c00122.Z$0;
                ep2 = (Episode) c00122.L$6;
                type4 = (String) c00122.L$5;
                parts3 = (List) c00122.L$4;
                str3 = (String) c00122.L$3;
                function6 = (Function1) c00122.L$2;
                function3 = (Function1) c00122.L$1;
                data4 = (String) c00122.L$0;
                ResultKt.throwOnFailure($result);
                z = true;
                z4 = false;
                aplayer1 = ep2.getAplayer1();
                if (aplayer1 != null) {
                    z6 = true;
                } else {
                    z6 = true;
                }
                if (z6) {
                    aplayer2 = ep2.getAplayer1();
                    c00122.L$0 = SpillingKt.nullOutSpilledVariable(data4);
                    c00122.L$1 = function3;
                    c00122.L$2 = function6;
                    c00122.L$3 = SpillingKt.nullOutSpilledVariable(str3);
                    c00122.L$4 = SpillingKt.nullOutSpilledVariable(parts3);
                    c00122.L$5 = SpillingKt.nullOutSpilledVariable(type4);
                    c00122.L$6 = ep2;
                    c00122.Z$0 = isCasting4;
                    c00122.I$0 = id4;
                    c00122.label = 3;
                    if (ExtractorApiKt.loadExtractor(aplayer2, function3, function6, c00122) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function7 = function6;
                    data5 = data4;
                } else {
                    function7 = function6;
                    data5 = data4;
                }
                aplayer3 = ep2.getAplayer2();
                if (aplayer3 != null) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (!z4) {
                    aplayer4 = ep2.getAplayer2();
                    c00122.L$0 = SpillingKt.nullOutSpilledVariable(data5);
                    c00122.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                    c00122.L$2 = SpillingKt.nullOutSpilledVariable(function7);
                    c00122.L$3 = SpillingKt.nullOutSpilledVariable(str3);
                    c00122.L$4 = SpillingKt.nullOutSpilledVariable(parts3);
                    c00122.L$5 = SpillingKt.nullOutSpilledVariable(type4);
                    c00122.L$6 = SpillingKt.nullOutSpilledVariable(ep2);
                    c00122.Z$0 = isCasting4;
                    c00122.I$0 = id4;
                    c00122.label = 4;
                    if (ExtractorApiKt.loadExtractor(aplayer4, function3, function7, c00122) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str4 = str3;
                    function8 = function3;
                }
                return Boxing.boxBoolean(z);
            case 3:
                id4 = c00122.I$0;
                isCasting4 = c00122.Z$0;
                ep2 = (Episode) c00122.L$6;
                type4 = (String) c00122.L$5;
                parts3 = (List) c00122.L$4;
                str3 = (String) c00122.L$3;
                function6 = (Function1) c00122.L$2;
                function3 = (Function1) c00122.L$1;
                data4 = (String) c00122.L$0;
                ResultKt.throwOnFailure($result);
                z = true;
                z4 = false;
                function7 = function6;
                data5 = data4;
                aplayer3 = ep2.getAplayer2();
                if (aplayer3 != null) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (!z4) {
                    aplayer4 = ep2.getAplayer2();
                    c00122.L$0 = SpillingKt.nullOutSpilledVariable(data5);
                    c00122.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                    c00122.L$2 = SpillingKt.nullOutSpilledVariable(function7);
                    c00122.L$3 = SpillingKt.nullOutSpilledVariable(str3);
                    c00122.L$4 = SpillingKt.nullOutSpilledVariable(parts3);
                    c00122.L$5 = SpillingKt.nullOutSpilledVariable(type4);
                    c00122.L$6 = SpillingKt.nullOutSpilledVariable(ep2);
                    c00122.Z$0 = isCasting4;
                    c00122.I$0 = id4;
                    c00122.label = 4;
                    if (ExtractorApiKt.loadExtractor(aplayer4, function3, function7, c00122) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str4 = str3;
                    function8 = function3;
                }
                return Boxing.boxBoolean(z);
            case 4:
                int id5 = c00122.I$0;
                boolean z8 = c00122.Z$0;
                str4 = (String) c00122.L$3;
                function8 = (Function1) c00122.L$1;
                ResultKt.throwOnFailure($result);
                z = true;
                return Boxing.boxBoolean(z);
            case 5:
                id2 = c00122.I$0;
                isCasting3 = c00122.Z$0;
                movie2 = (Movie) c00122.L$6;
                type2 = (String) c00122.L$5;
                parts2 = (List) c00122.L$4;
                str2 = (String) c00122.L$3;
                function5 = (Function1) c00122.L$2;
                function3 = (Function1) c00122.L$1;
                data3 = (String) c00122.L$0;
                ResultKt.throwOnFailure($result);
                z = true;
                z2 = false;
                xPlayer2 = movie2.getXPlayer2();
                if (xPlayer2 != null) {
                    z7 = true;
                } else {
                    z7 = true;
                }
                if (z7) {
                    xPlayer3 = movie2.getXPlayer2();
                    c00122.L$0 = SpillingKt.nullOutSpilledVariable(data3);
                    c00122.L$1 = function3;
                    c00122.L$2 = function5;
                    c00122.L$3 = SpillingKt.nullOutSpilledVariable(str2);
                    c00122.L$4 = SpillingKt.nullOutSpilledVariable(parts2);
                    c00122.L$5 = SpillingKt.nullOutSpilledVariable(type2);
                    c00122.L$6 = movie2;
                    c00122.Z$0 = isCasting3;
                    c00122.I$0 = id2;
                    c00122.label = 6;
                    if (ExtractorApiKt.loadExtractor(xPlayer3, function3, function5, c00122) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function9 = function5;
                    data6 = data3;
                } else {
                    function9 = function5;
                    data6 = data3;
                }
                xPlayer4 = movie2.getXPlayer3();
                if (xPlayer4 != null) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                if (!z2) {
                    xPlayer5 = movie2.getXPlayer3();
                    c00122.L$0 = SpillingKt.nullOutSpilledVariable(data6);
                    c00122.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                    c00122.L$2 = SpillingKt.nullOutSpilledVariable(function9);
                    c00122.L$3 = SpillingKt.nullOutSpilledVariable(str2);
                    c00122.L$4 = SpillingKt.nullOutSpilledVariable(parts2);
                    c00122.L$5 = SpillingKt.nullOutSpilledVariable(type2);
                    c00122.L$6 = SpillingKt.nullOutSpilledVariable(movie2);
                    c00122.Z$0 = isCasting3;
                    c00122.I$0 = id2;
                    c00122.label = 7;
                    if (ExtractorApiKt.loadExtractor(xPlayer5, function3, function9, c00122) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str5 = str2;
                    function10 = function3;
                }
                return Boxing.boxBoolean(z);
            case 6:
                id2 = c00122.I$0;
                isCasting3 = c00122.Z$0;
                movie2 = (Movie) c00122.L$6;
                type2 = (String) c00122.L$5;
                parts2 = (List) c00122.L$4;
                str2 = (String) c00122.L$3;
                function5 = (Function1) c00122.L$2;
                function3 = (Function1) c00122.L$1;
                data3 = (String) c00122.L$0;
                ResultKt.throwOnFailure($result);
                z = true;
                z2 = false;
                function9 = function5;
                data6 = data3;
                xPlayer4 = movie2.getXPlayer3();
                if (xPlayer4 != null) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                if (!z2) {
                    xPlayer5 = movie2.getXPlayer3();
                    c00122.L$0 = SpillingKt.nullOutSpilledVariable(data6);
                    c00122.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                    c00122.L$2 = SpillingKt.nullOutSpilledVariable(function9);
                    c00122.L$3 = SpillingKt.nullOutSpilledVariable(str2);
                    c00122.L$4 = SpillingKt.nullOutSpilledVariable(parts2);
                    c00122.L$5 = SpillingKt.nullOutSpilledVariable(type2);
                    c00122.L$6 = SpillingKt.nullOutSpilledVariable(movie2);
                    c00122.Z$0 = isCasting3;
                    c00122.I$0 = id2;
                    c00122.label = 7;
                    if (ExtractorApiKt.loadExtractor(xPlayer5, function3, function9, c00122) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str5 = str2;
                    function10 = function3;
                }
                return Boxing.boxBoolean(z);
            case 7:
                int i = c00122.I$0;
                boolean z9 = c00122.Z$0;
                str5 = (String) c00122.L$3;
                function10 = (Function1) c00122.L$1;
                ResultKt.throwOnFailure($result);
                z = true;
                return Boxing.boxBoolean(z);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:28:0x0104  */
    /* JADX WARN: Code duplicated, block: B:29:0x0106  */
    /* JADX WARN: Code duplicated, block: B:31:0x0109  */
    /* JADX WARN: Code duplicated, block: B:33:0x0132 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:34:0x0133  */
    /* JADX WARN: Code duplicated, block: B:38:0x0142  */
    /* JADX WARN: Code duplicated, block: B:39:0x0144  */
    /* JADX WARN: Code duplicated, block: B:41:0x0147  */
    /* JADX WARN: Code duplicated, block: B:43:0x0174 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:44:0x0175  */
    /* JADX WARN: Code duplicated, block: B:46:0x0179 A[PHI: r3 r9 r10 r11 r12
      0x0179: PHI (r3v27 kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit>) = 
      (r3v23 kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit>)
      (r3v28 kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit>)
     binds: [B:40:0x0145, B:45:0x0176] A[DONT_GENERATE, DONT_INLINE]
      0x0179: PHI (r9v9 'basic' java.lang.String) = (r9v5 'basic' java.lang.String), (r9v10 'basic' java.lang.String) binds: [B:40:0x0145, B:45:0x0176] A[DONT_GENERATE, DONT_INLINE]
      0x0179: PHI (r10v9 'sd' java.lang.String) = (r10v5 'sd' java.lang.String), (r10v10 'sd' java.lang.String) binds: [B:40:0x0145, B:45:0x0176] A[DONT_GENERATE, DONT_INLINE]
      0x0179: PHI (r11v9 'hd' java.lang.String) = (r11v5 'hd' java.lang.String), (r11v10 'hd' java.lang.String) binds: [B:40:0x0145, B:45:0x0176] A[DONT_GENERATE, DONT_INLINE]
      0x0179: PHI (r12v9 'fhd' java.lang.String) = (r12v5 'fhd' java.lang.String), (r12v10 'fhd' java.lang.String) binds: [B:40:0x0145, B:45:0x0176] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:48:0x0182  */
    /* JADX WARN: Code duplicated, block: B:50:0x0185  */
    /* JADX WARN: Code duplicated, block: B:52:0x01ba A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:53:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object addVideoLinks(String basic, String sd, String hd, String fhd, Function1<? super ExtractorLink, Unit> function1, Continuation<? super Unit> continuation) {
        C00061 c00061;
        Object obj;
        Function1<? super ExtractorLink, Unit> function2;
        boolean z;
        Object objMakeLink;
        Object obj2;
        Function1<? super ExtractorLink, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        boolean z2;
        Object objMakeLink2;
        Function1<? super ExtractorLink, Unit> function5;
        Object objMakeLink3;
        Function1<? super ExtractorLink, Unit> function6;
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
        Object $result = c00061.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00061.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (!(basic.length() > 0)) {
                    if (sd.length() > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        String url = formatUrl(sd);
                        int value = Qualities.P480.getValue();
                        c00061.L$0 = SpillingKt.nullOutSpilledVariable(basic);
                        c00061.L$1 = SpillingKt.nullOutSpilledVariable(sd);
                        c00061.L$2 = hd;
                        c00061.L$3 = fhd;
                        c00061.L$4 = function1;
                        c00061.L$5 = function1;
                        c00061.label = 2;
                        objMakeLink = makeLink("SD", url, value, c00061);
                        if (objMakeLink == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj2 = objMakeLink;
                        function3 = function1;
                        function3.invoke(obj2);
                    }
                    if (fhd.length() > 0) {
                        String url2 = formatUrl(fhd);
                        int value2 = Qualities.P1080.getValue();
                        c00061.L$0 = SpillingKt.nullOutSpilledVariable(basic);
                        c00061.L$1 = SpillingKt.nullOutSpilledVariable(sd);
                        c00061.L$2 = SpillingKt.nullOutSpilledVariable(hd);
                        c00061.L$3 = SpillingKt.nullOutSpilledVariable(fhd);
                        c00061.L$4 = SpillingKt.nullOutSpilledVariable(function4);
                        c00061.L$5 = function4;
                        c00061.label = 4;
                        objMakeLink3 = makeLink("FHD", url2, value2, c00061);
                        if (objMakeLink3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function6 = function4;
                        function6.invoke(objMakeLink3);
                    }
                    return Unit.INSTANCE;
                }
                String url3 = formatUrl(basic);
                int value3 = Qualities.P240.getValue();
                c00061.L$0 = SpillingKt.nullOutSpilledVariable(basic);
                c00061.L$1 = sd;
                c00061.L$2 = hd;
                c00061.L$3 = fhd;
                c00061.L$4 = function1;
                c00061.L$5 = function1;
                c00061.label = 1;
                Object objMakeLink4 = makeLink("Basic", url3, value3, c00061);
                if (objMakeLink4 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = objMakeLink4;
                function2 = function1;
                function1.invoke(obj);
                function1 = function2;
                if (sd.length() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    String url4 = formatUrl(sd);
                    int value4 = Qualities.P480.getValue();
                    c00061.L$0 = SpillingKt.nullOutSpilledVariable(basic);
                    c00061.L$1 = SpillingKt.nullOutSpilledVariable(sd);
                    c00061.L$2 = hd;
                    c00061.L$3 = fhd;
                    c00061.L$4 = function1;
                    c00061.L$5 = function1;
                    c00061.label = 2;
                    objMakeLink = makeLink("SD", url4, value4, c00061);
                    if (objMakeLink == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj2 = objMakeLink;
                    function3 = function1;
                    function3.invoke(obj2);
                }
                if (fhd.length() > 0) {
                    String url5 = formatUrl(fhd);
                    int value5 = Qualities.P1080.getValue();
                    c00061.L$0 = SpillingKt.nullOutSpilledVariable(basic);
                    c00061.L$1 = SpillingKt.nullOutSpilledVariable(sd);
                    c00061.L$2 = SpillingKt.nullOutSpilledVariable(hd);
                    c00061.L$3 = SpillingKt.nullOutSpilledVariable(fhd);
                    c00061.L$4 = SpillingKt.nullOutSpilledVariable(function4);
                    c00061.L$5 = function4;
                    c00061.label = 4;
                    objMakeLink3 = makeLink("FHD", url5, value5, c00061);
                    if (objMakeLink3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function6 = function4;
                    function6.invoke(objMakeLink3);
                }
                return Unit.INSTANCE;
                function4 = function1;
                if (hd.length() > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    String url6 = formatUrl(hd);
                    int value6 = Qualities.P720.getValue();
                    c00061.L$0 = SpillingKt.nullOutSpilledVariable(basic);
                    c00061.L$1 = SpillingKt.nullOutSpilledVariable(sd);
                    c00061.L$2 = SpillingKt.nullOutSpilledVariable(hd);
                    c00061.L$3 = fhd;
                    c00061.L$4 = function4;
                    c00061.L$5 = function4;
                    c00061.label = 3;
                    objMakeLink2 = makeLink("HD", url6, value6, c00061);
                    if (objMakeLink2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function5 = function4;
                    function5.invoke(objMakeLink2);
                    if (fhd.length() > 0) {
                        String url7 = formatUrl(fhd);
                        int value7 = Qualities.P1080.getValue();
                        c00061.L$0 = SpillingKt.nullOutSpilledVariable(basic);
                        c00061.L$1 = SpillingKt.nullOutSpilledVariable(sd);
                        c00061.L$2 = SpillingKt.nullOutSpilledVariable(hd);
                        c00061.L$3 = SpillingKt.nullOutSpilledVariable(fhd);
                        c00061.L$4 = SpillingKt.nullOutSpilledVariable(function4);
                        c00061.L$5 = function4;
                        c00061.label = 4;
                        objMakeLink3 = makeLink("FHD", url7, value7, c00061);
                        if (objMakeLink3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function6 = function4;
                        function6.invoke(objMakeLink3);
                    }
                } else {
                    if (fhd.length() > 0) {
                        String url8 = formatUrl(fhd);
                        int value8 = Qualities.P1080.getValue();
                        c00061.L$0 = SpillingKt.nullOutSpilledVariable(basic);
                        c00061.L$1 = SpillingKt.nullOutSpilledVariable(sd);
                        c00061.L$2 = SpillingKt.nullOutSpilledVariable(hd);
                        c00061.L$3 = SpillingKt.nullOutSpilledVariable(fhd);
                        c00061.L$4 = SpillingKt.nullOutSpilledVariable(function4);
                        c00061.L$5 = function4;
                        c00061.label = 4;
                        objMakeLink3 = makeLink("FHD", url8, value8, c00061);
                        if (objMakeLink3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function6 = function4;
                        function6.invoke(objMakeLink3);
                    }
                }
                return Unit.INSTANCE;
            case 1:
                Function1<? super ExtractorLink, Unit> function7 = (Function1) c00061.L$5;
                Function1<? super ExtractorLink, Unit> function8 = (Function1) c00061.L$4;
                fhd = (String) c00061.L$3;
                hd = (String) c00061.L$2;
                sd = (String) c00061.L$1;
                basic = (String) c00061.L$0;
                ResultKt.throwOnFailure($result);
                function2 = function8;
                function1 = function7;
                obj = $result;
                function1.invoke(obj);
                function1 = function2;
                if (sd.length() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    function4 = function1;
                    if (hd.length() > 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        String url9 = formatUrl(hd);
                        int value9 = Qualities.P720.getValue();
                        c00061.L$0 = SpillingKt.nullOutSpilledVariable(basic);
                        c00061.L$1 = SpillingKt.nullOutSpilledVariable(sd);
                        c00061.L$2 = SpillingKt.nullOutSpilledVariable(hd);
                        c00061.L$3 = fhd;
                        c00061.L$4 = function4;
                        c00061.L$5 = function4;
                        c00061.label = 3;
                        objMakeLink2 = makeLink("HD", url9, value9, c00061);
                        if (objMakeLink2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function5 = function4;
                        function5.invoke(objMakeLink2);
                    }
                    return Unit.INSTANCE;
                }
                String url10 = formatUrl(sd);
                int value10 = Qualities.P480.getValue();
                c00061.L$0 = SpillingKt.nullOutSpilledVariable(basic);
                c00061.L$1 = SpillingKt.nullOutSpilledVariable(sd);
                c00061.L$2 = hd;
                c00061.L$3 = fhd;
                c00061.L$4 = function1;
                c00061.L$5 = function1;
                c00061.label = 2;
                objMakeLink = makeLink("SD", url10, value10, c00061);
                if (objMakeLink == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj2 = objMakeLink;
                function3 = function1;
                function3.invoke(obj2);
                function4 = function1;
                if (hd.length() > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    String url11 = formatUrl(hd);
                    int value11 = Qualities.P720.getValue();
                    c00061.L$0 = SpillingKt.nullOutSpilledVariable(basic);
                    c00061.L$1 = SpillingKt.nullOutSpilledVariable(sd);
                    c00061.L$2 = SpillingKt.nullOutSpilledVariable(hd);
                    c00061.L$3 = fhd;
                    c00061.L$4 = function4;
                    c00061.L$5 = function4;
                    c00061.label = 3;
                    objMakeLink2 = makeLink("HD", url11, value11, c00061);
                    if (objMakeLink2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function5 = function4;
                    function5.invoke(objMakeLink2);
                }
                return Unit.INSTANCE;
                if (fhd.length() > 0) {
                    String url12 = formatUrl(fhd);
                    int value12 = Qualities.P1080.getValue();
                    c00061.L$0 = SpillingKt.nullOutSpilledVariable(basic);
                    c00061.L$1 = SpillingKt.nullOutSpilledVariable(sd);
                    c00061.L$2 = SpillingKt.nullOutSpilledVariable(hd);
                    c00061.L$3 = SpillingKt.nullOutSpilledVariable(fhd);
                    c00061.L$4 = SpillingKt.nullOutSpilledVariable(function4);
                    c00061.L$5 = function4;
                    c00061.label = 4;
                    objMakeLink3 = makeLink("FHD", url12, value12, c00061);
                    if (objMakeLink3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function6 = function4;
                    function6.invoke(objMakeLink3);
                }
                return Unit.INSTANCE;
            case 2:
                function3 = (Function1) c00061.L$5;
                function1 = (Function1) c00061.L$4;
                fhd = (String) c00061.L$3;
                hd = (String) c00061.L$2;
                sd = (String) c00061.L$1;
                basic = (String) c00061.L$0;
                ResultKt.throwOnFailure($result);
                obj2 = $result;
                function3.invoke(obj2);
                function4 = function1;
                if (hd.length() > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    String url13 = formatUrl(hd);
                    int value13 = Qualities.P720.getValue();
                    c00061.L$0 = SpillingKt.nullOutSpilledVariable(basic);
                    c00061.L$1 = SpillingKt.nullOutSpilledVariable(sd);
                    c00061.L$2 = SpillingKt.nullOutSpilledVariable(hd);
                    c00061.L$3 = fhd;
                    c00061.L$4 = function4;
                    c00061.L$5 = function4;
                    c00061.label = 3;
                    objMakeLink2 = makeLink("HD", url13, value13, c00061);
                    if (objMakeLink2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function5 = function4;
                    function5.invoke(objMakeLink2);
                    if (fhd.length() > 0) {
                        String url14 = formatUrl(fhd);
                        int value14 = Qualities.P1080.getValue();
                        c00061.L$0 = SpillingKt.nullOutSpilledVariable(basic);
                        c00061.L$1 = SpillingKt.nullOutSpilledVariable(sd);
                        c00061.L$2 = SpillingKt.nullOutSpilledVariable(hd);
                        c00061.L$3 = SpillingKt.nullOutSpilledVariable(fhd);
                        c00061.L$4 = SpillingKt.nullOutSpilledVariable(function4);
                        c00061.L$5 = function4;
                        c00061.label = 4;
                        objMakeLink3 = makeLink("FHD", url14, value14, c00061);
                        if (objMakeLink3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function6 = function4;
                        function6.invoke(objMakeLink3);
                    }
                } else {
                    if (fhd.length() > 0) {
                        String url15 = formatUrl(fhd);
                        int value15 = Qualities.P1080.getValue();
                        c00061.L$0 = SpillingKt.nullOutSpilledVariable(basic);
                        c00061.L$1 = SpillingKt.nullOutSpilledVariable(sd);
                        c00061.L$2 = SpillingKt.nullOutSpilledVariable(hd);
                        c00061.L$3 = SpillingKt.nullOutSpilledVariable(fhd);
                        c00061.L$4 = SpillingKt.nullOutSpilledVariable(function4);
                        c00061.L$5 = function4;
                        c00061.label = 4;
                        objMakeLink3 = makeLink("FHD", url15, value15, c00061);
                        if (objMakeLink3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function6 = function4;
                        function6.invoke(objMakeLink3);
                    }
                }
                return Unit.INSTANCE;
            case 3:
                Function1<? super ExtractorLink, Unit> function9 = (Function1) c00061.L$5;
                Function1<? super ExtractorLink, Unit> function10 = (Function1) c00061.L$4;
                fhd = (String) c00061.L$3;
                hd = (String) c00061.L$2;
                sd = (String) c00061.L$1;
                basic = (String) c00061.L$0;
                ResultKt.throwOnFailure($result);
                function5 = function9;
                function4 = function10;
                objMakeLink2 = $result;
                function5.invoke(objMakeLink2);
                if (fhd.length() > 0) {
                    String url16 = formatUrl(fhd);
                    int value16 = Qualities.P1080.getValue();
                    c00061.L$0 = SpillingKt.nullOutSpilledVariable(basic);
                    c00061.L$1 = SpillingKt.nullOutSpilledVariable(sd);
                    c00061.L$2 = SpillingKt.nullOutSpilledVariable(hd);
                    c00061.L$3 = SpillingKt.nullOutSpilledVariable(fhd);
                    c00061.L$4 = SpillingKt.nullOutSpilledVariable(function4);
                    c00061.L$5 = function4;
                    c00061.label = 4;
                    objMakeLink3 = makeLink("FHD", url16, value16, c00061);
                    if (objMakeLink3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function6 = function4;
                    function6.invoke(objMakeLink3);
                }
                return Unit.INSTANCE;
            case 4:
                function6 = (Function1) c00061.L$5;
                ResultKt.throwOnFailure($result);
                objMakeLink3 = $result;
                function6.invoke(objMakeLink3);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.cncverse.XonProvider$makeLink$2 */
    /* JADX INFO: compiled from: XonProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.XonProvider$makeLink$2", f = "XonProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00132 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $quality;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00132(int i, Continuation<? super C00132> continuation) {
            super(2, continuation);
            this.$quality = i;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00132 = XonProvider.this.new C00132(this.$quality, continuation);
            c00132.L$0 = obj;
            return c00132;
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
                    $this$newExtractorLink.setReferer(XonProvider.this.getMainUrl());
                    $this$newExtractorLink.setQuality(this.$quality);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object makeLink(String label, String url, int quality, Continuation<? super ExtractorLink> continuation) {
        return ExtractorApiKt.newExtractorLink(getName(), getName() + " - " + label, url, ExtractorLinkType.VIDEO, new C00132(quality, null), continuation);
    }
}
