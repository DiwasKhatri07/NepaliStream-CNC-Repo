package com.Goojara;

import com.lagradost.api.Log;
import com.lagradost.cloudstream3.Actor;
import com.lagradost.cloudstream3.ActorData;
import com.lagradost.cloudstream3.ActorRole;
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
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SearchResponseList;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.Qualities;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
import okhttp3.Interceptor;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Goojara.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Goojara/classes.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 O2\u00020\u0001:\u0001OB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010 \u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0096@¢\u0006\u0002\u0010'J\f\u0010(\u001a\u00020)*\u00020*H\u0002J\u001e\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00052\u0006\u0010#\u001a\u00020$H\u0096@¢\u0006\u0002\u0010/J\u0016\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u00103JF\u00104\u001a\u00020\u000e2\u0006\u00105\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u000e2\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020:082\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020:08H\u0096@¢\u0006\u0002\u0010=J\"\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050?2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00050\u001eH\u0002J\u001e\u0010A\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010B2\u0006\u0010C\u001a\u00020\u0005H\u0002J(\u0010D\u001a\u00020\u00052\b\u0010E\u001a\u0004\u0018\u00010\u00052\u0014\u0010F\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010BH\u0002J\u0016\u0010G\u001a\b\u0012\u0004\u0012\u00020H0\u001e2\b\u0010I\u001a\u0004\u0018\u00010\u0005J^\u0010J\u001a\u00020:2\u0006\u0010K\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u00052\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010M\u001a\u0004\u0018\u00010$2\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020:082\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020:08H\u0086@¢\u0006\u0002\u0010NR\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0014\u0010\u0016\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u000e\u0010+\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006P"}, d2 = {"Lcom/Goojara/Goojara;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasDownloadSupport", "getHasDownloadSupport", "hasQuickSearch", "getHasQuickSearch", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lorg/jsoup/nodes/Element;", "DEFAULT_POSTER", "search", "Lcom/lagradost/cloudstream3/SearchResponseList;", "query", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseSetCookieHeaders", "", "headers", "extract3chkPair", "Lkotlin/Pair;", "body", "buildCookieHeader", "aGooz", "random", "parseCredits", "Lcom/lagradost/cloudstream3/ActorData;", "jsonText", "loadSourceNameExtractor", "source", "referer", "quality", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "Goojara"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGoojara.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Goojara.kt\ncom/Goojara/Goojara\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,364:1\n1739#2:365\n1814#2,3:366\n1795#2,10:370\n2068#2:380\n2069#2:382\n1805#2:383\n1795#2,10:384\n2068#2:394\n2069#2:396\n1805#2:397\n777#2:398\n873#2,2:399\n2068#2,2:401\n1#3:369\n1#3:381\n1#3:395\n*S KotlinDebug\n*F\n+ 1 Goojara.kt\ncom/Goojara/Goojara\n*L\n46#1:365\n46#1:366,3\n194#1:370,10\n194#1:380\n194#1:382\n194#1:383\n219#1:384,10\n219#1:394\n219#1:396\n219#1:397\n295#1:398\n295#1:399,2\n295#1:401,2\n194#1:381\n219#1:395\n*E\n"})
public final class Goojara extends MainAPI {

    @NotNull
    public static final String TMDBIMAGEBASEURL = "https://image.tmdb.org/t/p/original";
    private final boolean hasQuickSearch;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Map<String, String> headers = MapsKt.mapOf(TuplesKt.to("Cookie", "aGooz=dg18hh2eittp5e7s53u0e6bloh; 98ef5a07=747ffc60ea65eb361a495f; _997e=CC3E288A8E177D1A15AC79C049BCE3162D678A00; 3d4930c4=6239ad831b7cfd09950432; _2252=8A4FEB904DF45EB188E25A7A89432E0E489A5ADA; 12cd410d=77da7901426e0f0c27e062; _3553=3DB01E776983EE4DACE282E616C9B7B4FB2E2D3D"));

    @NotNull
    private String mainUrl = "https://ww1.goojara.to";

    @NotNull
    private String name = "Goojara";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "en";
    private final boolean hasDownloadSupport = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.TvSeries});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("watch-movies-recent", "Recently Updated Movies"), TuplesKt.to("watch-series-recent", "Recently Updated Series"), TuplesKt.to("watch-movies-popular", "Popular Movies"), TuplesKt.to("watch-series-popular", "Popular Series")});

    @NotNull
    private final String DEFAULT_POSTER = "https://thumbs.dreamstime.com/b/cinema-poster-design-template-popcorn-box-disposable-cup-beverages-straw-film-strip-clapper-board-ticket-detailed-44098150.jpg";

    /* JADX INFO: renamed from: com.Goojara.Goojara$getMainPage$1 */
    /* JADX INFO: compiled from: Goojara.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Goojara.Goojara", f = "Goojara.kt", i = {0, 0}, l = {45}, m = "getMainPage", n = {"request", "page"}, nl = {46}, s = {"L$0", "I$0"}, v = 2)
    static final class C00001 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00001(Continuation<? super C00001> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Goojara.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Goojara.Goojara$load$1 */
    /* JADX INFO: compiled from: Goojara.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Goojara.Goojara", f = "Goojara.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6}, l = {133, 155, 158, 179, 217, 243, 251}, m = "load", n = {"url", "url", "document", "raw", "seasonRegex", "match", "title", "poster", "description", "type", "imdbid", "metatype", "tmdbmetatype", "url", "document", "raw", "seasonRegex", "match", "title", "poster", "description", "type", "imdbid", "metatype", "tmdbmetatype", "metares", "id", "$this$load_u24lambda_u240_u240", "url", "document", "raw", "seasonRegex", "match", "title", "poster", "description", "type", "imdbid", "metatype", "tmdbmetatype", "metares", "tmdbId", "id", "$this$load_u24lambda_u241_u240", "url", "document", "raw", "seasonRegex", "match", "title", "poster", "description", "type", "imdbid", "metatype", "tmdbmetatype", "metares", "tmdbId", "movieCreditsJsonText", "castList", "metaJson", "metaPoster", "metaBackground", "metaDescription", "metaGenres", "epMetaMap", "href", "episodes", "seasonHref", "totalSeasons", "seasonIndex", "url", "document", "raw", "seasonRegex", "match", "title", "poster", "description", "type", "imdbid", "metatype", "tmdbmetatype", "metares", "tmdbId", "movieCreditsJsonText", "castList", "metaJson", "metaPoster", "metaBackground", "metaDescription", "metaGenres", "epMetaMap", "href", "episodes", "totalSeasons", "url", "document", "raw", "seasonRegex", "match", "title", "poster", "description", "type", "imdbid", "metatype", "tmdbmetatype", "metares", "tmdbId", "movieCreditsJsonText", "castList", "metaJson", "metaPoster", "metaBackground", "metaDescription", "metaGenres", "epMetaMap"}, nl = {135, 156, 160, 178, 218, 251, 210}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        int I$0;
        int I$1;
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
            return Goojara.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Goojara.Goojara$loadLinks$1 */
    /* JADX INFO: compiled from: Goojara.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Goojara.Goojara", f = "Goojara.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {269, 276}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "isCasting", "data", "subtitleCallback", "callback", "initialResp", "doc", "bodyHtml", "setCookieHeader", "cookieMap", "randomPair", "cookieHeader", "isCasting"}, nl = {270, 288}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "Z$0"}, v = 2)
    static final class C00041 extends ContinuationImpl {
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

        C00041(Continuation<? super C00041> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Goojara.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Goojara.Goojara$loadSourceNameExtractor$1 */
    /* JADX INFO: compiled from: Goojara.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Goojara.Goojara", f = "Goojara.kt", i = {0, 0, 0, 0, 0, 0}, l = {345}, m = "loadSourceNameExtractor", n = {"source", "url", "referer", "quality", "subtitleCallback", "callback"}, nl = {362}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 2)
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
            return Goojara.this.loadSourceNameExtractor(null, null, null, null, null, null, (Continuation) this);
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

    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    /* JADX INFO: compiled from: Goojara.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/Goojara/Goojara$Companion;", "", "<init>", "()V", "TMDBIMAGEBASEURL", "", "headers", "", "getHeaders", "()Ljava/util/Map;", "Goojara"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final Map<String, String> getHeaders() {
            return Goojara.headers;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        C00001 c00001;
        boolean z;
        MainPageRequest request2;
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
        Object $result = c00001.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00001.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                String str = getMainUrl() + '/' + request.getData() + "?p=" + page;
                c00001.L$0 = request;
                c00001.I$0 = page;
                c00001.label = 1;
                z = true;
                $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00001, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                request2 = request;
                break;
                break;
            case 1:
                int i = c00001.I$0;
                request2 = (MainPageRequest) c00001.L$0;
                ResultKt.throwOnFailure($result);
                z = true;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document res = ((NiceResponse) $result).getDocument();
        Iterable $this$map$iv = res.select("#xbrd > div:nth-child(4) a");
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Element it = (Element) item$iv$iv;
            destination$iv$iv.add(toSearchResult(it));
        }
        List home = (List) destination$iv$iv;
        return MainAPIKt.newHomePageResponse(new HomePageList(request2.getName(), home, false), Boxing.boxBoolean(z));
    }

    private final SearchResponse toSearchResult(Element $this$toSearchResult) {
        String title = $this$toSearchResult.select("span.mtl").text();
        String href = $this$toSearchResult.attr("href");
        final String posterUrl = $this$toSearchResult.select("img").attr("data-src");
        return MainAPIKt.newMovieSearchResponse$default(this, title, href, TvType.Movie, false, new Function1() { // from class: com.Goojara.Goojara$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return Goojara.toSearchResult$lambda$0(posterUrl, (MovieSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResult$lambda$0(String $posterUrl, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($posterUrl);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.Goojara.Goojara$search$2 */
    /* JADX INFO: compiled from: Goojara.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/lagradost/cloudstream3/SearchResponseList;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Goojara.Goojara$search$2", f = "Goojara.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {91, 127}, m = "invokeSuspend", n = {"$this$coroutineScope", "url", "body", "headers", "$this$coroutineScope", "url", "body", "headers", "results", "sem", "deferred", "concurrency"}, nl = {95, 128}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nGoojara.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Goojara.kt\ncom/Goojara/Goojara$search$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,364:1\n1739#2:365\n1814#2,3:366\n*S KotlinDebug\n*F\n+ 1 Goojara.kt\ncom/Goojara/Goojara$search$2\n*L\n100#1:365\n100#1:366,3\n*E\n"})
    static final class C00082 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SearchResponseList>, Object> {
        final /* synthetic */ String $query;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00082(String str, Continuation<? super C00082> continuation) {
            super(2, continuation);
            this.$query = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00082 = Goojara.this.new C00082(this.$query, continuation);
            c00082.L$0 = obj;
            return c00082;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super SearchResponseList> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:15:0x0157 A[LOOP:0: B:13:0x0151->B:15:0x0157, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:18:0x01ce A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:19:0x01cf  */
        public final Object invokeSuspend(Object $result) {
            Map body;
            Object objPost$default;
            String url;
            Map headers;
            int concurrency;
            Semaphore sem;
            List $this$map$iv;
            Goojara goojara;
            Collection destination$iv$iv;
            Object objAwaitAll;
            CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String url2 = Goojara.this.getMainUrl() + "/xmre.php";
                    body = MapsKt.mapOf(new Pair[]{TuplesKt.to("z", "Mwxxa3Vnaw"), TuplesKt.to("x", "b3716e05ff"), TuplesKt.to("q", this.$query)});
                    Map headers2 = MapsKt.mapOf(new Pair[]{TuplesKt.to("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:140.0) Gecko/20100101 Firefox/140.0"), TuplesKt.to("Accept", "*/*"), TuplesKt.to("Content-Type", "application/x-www-form-urlencoded"), TuplesKt.to("Referer", Goojara.this.getMainUrl()), TuplesKt.to("Cookie", "aGooz=b2orla8fv69k6a7c31knrqkljg")});
                    this.L$0 = $this$coroutineScope;
                    this.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(body);
                    this.L$3 = headers2;
                    this.label = 1;
                    objPost$default = Requests.post$default(MainActivityKt.getApp(), url2, headers2, (String) null, (Map) null, (Map) null, body, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 65500, (Object) null);
                    if (objPost$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    url = url2;
                    headers = headers2;
                    List deferred = ((NiceResponse) objPost$default).getDocument().select("li a");
                    concurrency = 10;
                    sem = SemaphoreKt.Semaphore$default(10, 0, 2, (Object) null);
                    $this$map$iv = deferred;
                    goojara = Goojara.this;
                    destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    for (Object item$iv$iv : $this$map$iv) {
                        Element el = (Element) item$iv$iv;
                        Collection destination$iv$iv2 = destination$iv$iv;
                        destination$iv$iv2.add(BuildersKt.async$default($this$coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new Goojara$search$2$deferred$1$1(sem, el, goojara, headers, null), 2, (Object) null));
                        destination$iv$iv = destination$iv$iv2;
                        concurrency = concurrency;
                        $this$map$iv = $this$map$iv;
                    }
                    int concurrency2 = concurrency;
                    List deferred2 = (List) destination$iv$iv;
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$coroutineScope);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(url);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(body);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(headers);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(deferred);
                    this.L$5 = SpillingKt.nullOutSpilledVariable(sem);
                    this.L$6 = SpillingKt.nullOutSpilledVariable(deferred2);
                    this.I$0 = concurrency2;
                    this.label = 2;
                    objAwaitAll = AwaitKt.awaitAll(deferred2, (Continuation) this);
                    if (objAwaitAll == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    List responses = CollectionsKt.filterNotNull((Iterable) objAwaitAll);
                    return MainAPIKt.toNewSearchResponseList$default(responses, (Boolean) null, 1, (Object) null);
                case 1:
                    Map headers3 = (Map) this.L$3;
                    Map body2 = (Map) this.L$2;
                    String url3 = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    headers = headers3;
                    body = body2;
                    url = url3;
                    objPost$default = $result;
                    List deferred3 = ((NiceResponse) objPost$default).getDocument().select("li a");
                    concurrency = 10;
                    sem = SemaphoreKt.Semaphore$default(10, 0, 2, (Object) null);
                    $this$map$iv = deferred3;
                    goojara = Goojara.this;
                    destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    while (r23.hasNext()) {
                        Element el2 = (Element) item$iv$iv;
                        Collection destination$iv$iv3 = destination$iv$iv;
                        destination$iv$iv3.add(BuildersKt.async$default($this$coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new Goojara$search$2$deferred$1$1(sem, el2, goojara, headers, null), 2, (Object) null));
                        destination$iv$iv = destination$iv$iv3;
                        concurrency = concurrency;
                        $this$map$iv = $this$map$iv;
                    }
                    int concurrency3 = concurrency;
                    List deferred4 = (List) destination$iv$iv;
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$coroutineScope);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(url);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(body);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(headers);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(deferred3);
                    this.L$5 = SpillingKt.nullOutSpilledVariable(sem);
                    this.L$6 = SpillingKt.nullOutSpilledVariable(deferred4);
                    this.I$0 = concurrency3;
                    this.label = 2;
                    objAwaitAll = AwaitKt.awaitAll(deferred4, (Continuation) this);
                    if (objAwaitAll == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    List responses2 = CollectionsKt.filterNotNull((Iterable) objAwaitAll);
                    return MainAPIKt.toNewSearchResponseList$default(responses2, (Boolean) null, 1, (Object) null);
                case 2:
                    int i = this.I$0;
                    ResultKt.throwOnFailure($result);
                    objAwaitAll = $result;
                    List responses3 = CollectionsKt.filterNotNull((Iterable) objAwaitAll);
                    return MainAPIKt.toNewSearchResponseList$default(responses3, (Boolean) null, 1, (Object) null);
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    @Nullable
    public Object search(@NotNull String query, int page, @NotNull Continuation<? super SearchResponseList> continuation) {
        return CoroutineScopeKt.coroutineScope(new C00082(query, null), continuation);
    }

    /* JADX WARN: Code duplicated, block: B:110:0x065d  */
    /* JADX WARN: Code duplicated, block: B:124:0x06cd  */
    /* JADX WARN: Code duplicated, block: B:235:0x0b07 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:236:0x0b08  */
    /* JADX WARN: Code duplicated, block: B:240:0x0b5b  */
    /* JADX WARN: Code duplicated, block: B:242:0x0baf A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:260:0x0c19  */
    /* JADX WARN: Code duplicated, block: B:262:0x0c23  */
    /* JADX WARN: Code duplicated, block: B:265:0x0c32  */
    /* JADX WARN: Code duplicated, block: B:267:0x0c35  */
    /* JADX WARN: Code duplicated, block: B:269:0x0c46  */
    /* JADX WARN: Code duplicated, block: B:272:0x0c4e  */
    /* JADX WARN: Code duplicated, block: B:277:0x0c66  */
    /* JADX WARN: Code duplicated, block: B:279:0x0c6a  */
    /* JADX WARN: Code duplicated, block: B:284:0x0c80  */
    /* JADX WARN: Code duplicated, block: B:286:0x0ca6 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:289:0x0cb1  */
    /* JADX WARN: Code duplicated, block: B:293:0x0cdc  */
    /* JADX WARN: Code duplicated, block: B:331:0x0cb5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Path cross not found for [B:309:0x05f5, B:97:0x0628], limit reached: 324 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:236:0x0b08 -> B:237:0x0b30). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object load(@org.jetbrains.annotations.NotNull java.lang.String r72, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r73) {
        /*
            Method dump skipped, instruction units count: 3860
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.Goojara.Goojara.load(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$6$6(String $epTitle, int $seasonIndex, Integer $epno, String $epOverview, String $epPosterFromMeta, String $released, Episode $this$newEpisode) {
        $this$newEpisode.setName($epTitle);
        $this$newEpisode.setSeason(Integer.valueOf($seasonIndex));
        $this$newEpisode.setEpisode($epno);
        $this$newEpisode.setDescription($epOverview);
        if ($epPosterFromMeta != null) {
            $this$newEpisode.setPosterUrl($epPosterFromMeta);
        }
        MainAPIKt.addDate$default($this$newEpisode, $released, (String) null, 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.Goojara.Goojara$load$3 */
    /* JADX INFO: compiled from: Goojara.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Goojara.Goojara$load$3", f = "Goojara.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00023 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<ActorData> $castList;
        final /* synthetic */ String $imdbid;
        final /* synthetic */ String $metaBackground;
        final /* synthetic */ String $metaDescription;
        final /* synthetic */ List<String> $metaGenres;
        final /* synthetic */ String $metaPoster;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00023(String str, String str2, List<String> list, String str3, String str4, List<ActorData> list2, Continuation<? super C00023> continuation) {
            super(2, continuation);
            this.$metaPoster = str;
            this.$metaDescription = str2;
            this.$metaGenres = list;
            this.$imdbid = str3;
            this.$metaBackground = str4;
            this.$castList = list2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00023 = new C00023(this.$metaPoster, this.$metaDescription, this.$metaGenres, this.$imdbid, this.$metaBackground, this.$castList, continuation);
            c00023.L$0 = obj;
            return c00023;
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
                    loadResponse.setPosterUrl(this.$metaPoster);
                    loadResponse.setPlot(this.$metaDescription);
                    if (!this.$metaGenres.isEmpty()) {
                        loadResponse.setTags(this.$metaGenres);
                    }
                    LoadResponse.Companion.addImdbId(loadResponse, this.$imdbid);
                    loadResponse.setBackgroundPosterUrl(this.$metaBackground);
                    loadResponse.setActors(this.$castList);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.Goojara.Goojara$load$4 */
    /* JADX INFO: compiled from: Goojara.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Goojara.Goojara$load$4", f = "Goojara.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00034 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<ActorData> $castList;
        final /* synthetic */ String $imdbid;
        final /* synthetic */ String $metaBackground;
        final /* synthetic */ String $metaDescription;
        final /* synthetic */ List<String> $metaGenres;
        final /* synthetic */ String $metaPoster;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00034(String str, String str2, List<String> list, String str3, String str4, List<ActorData> list2, Continuation<? super C00034> continuation) {
            super(2, continuation);
            this.$metaPoster = str;
            this.$metaDescription = str2;
            this.$metaGenres = list;
            this.$imdbid = str3;
            this.$metaBackground = str4;
            this.$castList = list2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00034 = new C00034(this.$metaPoster, this.$metaDescription, this.$metaGenres, this.$imdbid, this.$metaBackground, this.$castList, continuation);
            c00034.L$0 = obj;
            return c00034;
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
                    loadResponse.setPosterUrl(this.$metaPoster);
                    loadResponse.setPlot(this.$metaDescription);
                    if (!this.$metaGenres.isEmpty()) {
                        loadResponse.setTags(this.$metaGenres);
                    }
                    LoadResponse.Companion.addImdbId(loadResponse, this.$imdbid);
                    loadResponse.setBackgroundPosterUrl(this.$metaBackground);
                    loadResponse.setActors(this.$castList);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0111 A[PHI: r14
      0x0111: PHI (r14v3 java.lang.String) = (r14v2 java.lang.String), (r14v7 java.lang.String) binds: [B:19:0x0102, B:21:0x010e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:26:0x0191 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:27:0x0192  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00041 c00041;
        boolean z;
        C00041 c00042;
        String data2;
        boolean isCasting2;
        Object obj;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        List listSelect;
        C00052 c00052;
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
        Object $result = c00041.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00041.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                Map mapMapOf = MapsKt.mapOf(new Pair[]{TuplesKt.to("Referer", "https://www.goojara.to"), TuplesKt.to("Cookie", "")});
                c00041.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00041.L$1 = function1;
                c00041.L$2 = function2;
                c00041.Z$0 = isCasting;
                c00041.label = 1;
                C00041 c00043 = c00041;
                z = true;
                Object obj2 = Requests.get$default(app, data, mapMapOf, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00043, 4092, (Object) null);
                c00042 = c00043;
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                data2 = data;
                isCasting2 = isCasting;
                obj = obj2;
                function3 = function1;
                function4 = function2;
                NiceResponse initialResp = (NiceResponse) obj;
                Document doc = initialResp.getDocument();
                String bodyHtml = doc.outerHtml();
                String str = initialResp.getHeaders().get("Set-Cookie");
                String setCookieHeader = (str == null || (str = initialResp.getHeaders().get("set-cookie")) != null) ? str : "";
                Map<String, String> setCookieHeaders = parseSetCookieHeaders(CollectionsKt.listOf(setCookieHeader));
                Pair<String, String> pairExtract3chkPair = extract3chkPair(bodyHtml);
                String cookieHeader = buildCookieHeader(setCookieHeaders.get("aGooz"), pairExtract3chkPair);
                listSelect = doc.select("#drl a");
                c00052 = new C00052(cookieHeader, this, function3, function4, null);
                c00042.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00042.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                c00042.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                c00042.L$3 = SpillingKt.nullOutSpilledVariable(initialResp);
                c00042.L$4 = SpillingKt.nullOutSpilledVariable(doc);
                c00042.L$5 = SpillingKt.nullOutSpilledVariable(bodyHtml);
                c00042.L$6 = SpillingKt.nullOutSpilledVariable(setCookieHeader);
                c00042.L$7 = SpillingKt.nullOutSpilledVariable(setCookieHeaders);
                c00042.L$8 = SpillingKt.nullOutSpilledVariable(pairExtract3chkPair);
                c00042.L$9 = SpillingKt.nullOutSpilledVariable(cookieHeader);
                c00042.Z$0 = isCasting2;
                c00042.label = 2;
                if (ParCollectionsKt.amap(listSelect, c00052, c00042) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Boxing.boxBoolean(z);
            case 1:
                boolean isCasting3 = c00041.Z$0;
                Function1<? super ExtractorLink, Unit> function5 = (Function1) c00041.L$2;
                Function1<? super SubtitleFile, Unit> function6 = (Function1) c00041.L$1;
                data2 = (String) c00041.L$0;
                ResultKt.throwOnFailure($result);
                function3 = function6;
                c00042 = c00041;
                isCasting2 = isCasting3;
                function4 = function5;
                z = true;
                obj = $result;
                NiceResponse initialResp2 = (NiceResponse) obj;
                Document doc2 = initialResp2.getDocument();
                String bodyHtml2 = doc2.outerHtml();
                String str2 = initialResp2.getHeaders().get("Set-Cookie");
                String setCookieHeader2 = (str2 == null || (str2 = initialResp2.getHeaders().get("set-cookie")) != null) ? str2 : "";
                Map<String, String> setCookieHeaders2 = parseSetCookieHeaders(CollectionsKt.listOf(setCookieHeader2));
                Pair<String, String> pairExtract3chkPair2 = extract3chkPair(bodyHtml2);
                String cookieHeader2 = buildCookieHeader(setCookieHeaders2.get("aGooz"), pairExtract3chkPair2);
                listSelect = doc2.select("#drl a");
                c00052 = new C00052(cookieHeader2, this, function3, function4, null);
                c00042.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00042.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                c00042.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                c00042.L$3 = SpillingKt.nullOutSpilledVariable(initialResp2);
                c00042.L$4 = SpillingKt.nullOutSpilledVariable(doc2);
                c00042.L$5 = SpillingKt.nullOutSpilledVariable(bodyHtml2);
                c00042.L$6 = SpillingKt.nullOutSpilledVariable(setCookieHeader2);
                c00042.L$7 = SpillingKt.nullOutSpilledVariable(setCookieHeaders2);
                c00042.L$8 = SpillingKt.nullOutSpilledVariable(pairExtract3chkPair2);
                c00042.L$9 = SpillingKt.nullOutSpilledVariable(cookieHeader2);
                c00042.Z$0 = isCasting2;
                c00042.label = 2;
                if (ParCollectionsKt.amap(listSelect, c00052, c00042) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Boxing.boxBoolean(z);
            case 2:
                boolean z2 = c00041.Z$0;
                ResultKt.throwOnFailure($result);
                z = true;
                return Boxing.boxBoolean(z);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.Goojara.Goojara$loadLinks$2 */
    /* JADX INFO: compiled from: Goojara.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "element", "Lorg/jsoup/nodes/Element;", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Goojara.Goojara$loadLinks$2", f = "Goojara.kt", i = {0, 0, 1, 1, 1, 1}, l = {280, 283}, m = "invokeSuspend", n = {"element", "href", "element", "href", "redirectResp", "iframe"}, nl = {281, 284}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3"}, v = 2)
    static final class C00052 extends SuspendLambda implements Function2<Element, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ String $cookieHeader;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ Goojara this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00052(String str, Goojara goojara, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super C00052> continuation) {
            super(2, continuation);
            this.$cookieHeader = str;
            this.this$0 = goojara;
            this.$subtitleCallback = function1;
            this.$callback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00052 = new C00052(this.$cookieHeader, this.this$0, this.$subtitleCallback, this.$callback, continuation);
            c00052.L$0 = obj;
            return c00052;
        }

        public final Object invoke(Element element, Continuation<? super Unit> continuation) {
            return create(element, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:35:0x0100 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:36:0x0101  */
        public final Object invokeSuspend(Object $result) {
            String href;
            Object obj;
            NiceResponse redirectResp;
            String str;
            String iframe;
            Element element = (Element) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    href = element.attr("href");
                    if (href.length() == 0) {
                        return Unit.INSTANCE;
                    }
                    try {
                        Requests app = MainActivityKt.getApp();
                        Pair[] pairArr = {TuplesKt.to("Referer", "https://ww1.goojara.to"), TuplesKt.to("Cookie", this.$cookieHeader)};
                        this.L$0 = SpillingKt.nullOutSpilledVariable(element);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(href);
                        this.label = 1;
                        obj = Requests.get$default(app, href, MapsKt.mapOf(pairArr), (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 4060, (Object) null);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        redirectResp = (NiceResponse) obj;
                        str = redirectResp.getHeaders().get("location");
                        if (str != null && (str = redirectResp.getHeaders().get("Location")) == null) {
                            return Unit.INSTANCE;
                        }
                        iframe = str;
                        Log.INSTANCE.d("Phisher", iframe);
                        this.L$0 = SpillingKt.nullOutSpilledVariable(element);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(href);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(redirectResp);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(iframe);
                        this.label = 2;
                        if (this.this$0.loadSourceNameExtractor("", iframe, "", Boxing.boxInt(Qualities.P720.getValue()), this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    } catch (Exception e) {
                        e = e;
                        Log.INSTANCE.w("Phisher", "failed to fetch embed redirect: " + e.getMessage());
                    }
                    break;
                case 1:
                    String href2 = (String) this.L$1;
                    try {
                        ResultKt.throwOnFailure($result);
                        href = href2;
                        obj = $result;
                        redirectResp = (NiceResponse) obj;
                        str = redirectResp.getHeaders().get("location");
                        if (str != null) {
                            break;
                        }
                        iframe = str;
                        Log.INSTANCE.d("Phisher", iframe);
                        this.L$0 = SpillingKt.nullOutSpilledVariable(element);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(href);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(redirectResp);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(iframe);
                        this.label = 2;
                        if (this.this$0.loadSourceNameExtractor("", iframe, "", Boxing.boxInt(Qualities.P720.getValue()), this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    } catch (Exception e2) {
                        e = e2;
                        Log.INSTANCE.w("Phisher", "failed to fetch embed redirect: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        ResultKt.throwOnFailure($result);
                        break;
                    } catch (Exception e3) {
                        e = e3;
                        Log.INSTANCE.w("Phisher", "failed to fetch embed redirect: " + e.getMessage());
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    private final Map<String, String> parseSetCookieHeaders(List<String> headers2) {
        Map map = new LinkedHashMap();
        Pattern cookiePattern = Pattern.compile("^\\s*([^=;\\s]+)=([^;\\r\\n]*)");
        List<String> $this$filter$iv = headers2;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            String it = (String) element$iv$iv;
            if (!StringsKt.isBlank(it)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable $this$forEach$iv = (List) destination$iv$iv;
        for (Object element$iv : $this$forEach$iv) {
            String h = (String) element$iv;
            Matcher matcher = cookiePattern.matcher(h);
            if (matcher.find()) {
                boolean z = true;
                String name = matcher.group(1);
                String value = matcher.group(2);
                String str = name;
                if (str != null && str.length() != 0) {
                    z = false;
                }
                if (!z && value != null) {
                    map.put(name, value);
                }
            }
        }
        return map;
    }

    private final Pair<String, String> extract3chkPair(String body) {
        Pattern p = Pattern.compile("_3chk\\(\\s*'([^']+)'\\s*,\\s*'([^']+)'");
        Matcher m = p.matcher(body);
        if (m.find()) {
            return new Pair<>(m.group(1), m.group(2));
        }
        return null;
    }

    private final String buildCookieHeader(String aGooz, Pair<String, String> random) {
        List parts = new ArrayList();
        String str = aGooz;
        if (!(str == null || str.length() == 0)) {
            parts.add("aGooz=" + aGooz);
        }
        if (random != null) {
            parts.add(((String) random.getFirst()) + '=' + ((String) random.getSecond()));
        }
        return CollectionsKt.joinToString$default(parts, "; ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
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

    public static /* synthetic */ Object loadSourceNameExtractor$default(Goojara goojara, String str, String str2, String str3, Integer num, Function1 function1, Function1 function2, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = null;
        }
        if ((i & 8) != 0) {
            num = null;
        }
        return goojara.loadSourceNameExtractor(str, str2, str3, num, function1, function2, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Nullable
    public final Object loadSourceNameExtractor(@NotNull final String source, @NotNull String url, @Nullable String referer, @Nullable final Integer quality, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull final Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        C00061 c00061;
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
                Function1 function3 = new Function1() { // from class: com.Goojara.Goojara$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        return Goojara.loadSourceNameExtractor$lambda$0(function2, source, quality, (ExtractorLink) obj);
                    }
                };
                c00061.L$0 = SpillingKt.nullOutSpilledVariable(source);
                c00061.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00061.L$2 = SpillingKt.nullOutSpilledVariable(referer);
                c00061.L$3 = SpillingKt.nullOutSpilledVariable(quality);
                c00061.L$4 = SpillingKt.nullOutSpilledVariable(function1);
                c00061.L$5 = SpillingKt.nullOutSpilledVariable(function2);
                c00061.label = 1;
                if (ExtractorApiKt.loadExtractor(url, referer, function1, function3, c00061) == coroutine_suspended) {
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

    static final Unit loadSourceNameExtractor$lambda$0(Function1 $callback, String $source, Integer $quality, ExtractorLink link) {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new Goojara$loadSourceNameExtractor$2$1($callback, link, $source, $quality, null), 3, (Object) null);
        return Unit.INSTANCE;
    }
}
