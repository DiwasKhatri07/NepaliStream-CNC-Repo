package com.zinkmovies;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.ActorData;
import com.lagradost.cloudstream3.Episode;
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
import com.lagradost.cloudstream3.SearchQuality;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SearchResponseList;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import com.phisher98.donation.DonationManager;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collection;
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
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
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
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Zinkmovies.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Zinkmovies/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 C2\u00020\u0001:\u0001CB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010 \u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0096@¢\u0006\u0002\u0010)J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0002J\u001e\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&H\u0096@¢\u0006\u0002\u00101J\u0016\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u00105JF\u00106\u001a\u00020\u00112\u0006\u00107\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u00112\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020<0:2\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020<0:H\u0096@¢\u0006\u0002\u0010?J\u0012\u0010@\u001a\u0004\u0018\u00010A2\b\u0010B\u001a\u0004\u0018\u00010\u0005R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0011X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u0011X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001a\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050#X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/zinkmovies/Zinkmovies;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "lang", "getLang", "setLang", "hasMainPage", "", "getHasMainPage", "()Z", "hasDownloadSupport", "getHasDownloadSupport", "hasQuickSearch", "getHasQuickSearch", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "headers", "", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "post", "Lorg/jsoup/nodes/Element;", "search", "Lcom/lagradost/cloudstream3/SearchResponseList;", "query", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSearchQuality", "Lcom/lagradost/cloudstream3/SearchQuality;", "check", "Companion", "Zinkmovies"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nZinkmovies.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zinkmovies.kt\ncom/zinkmovies/Zinkmovies\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 5 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 6 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 7 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,718:1\n832#2:719\n862#2,2:720\n1795#2,10:722\n2068#2:732\n2069#2:734\n1805#2:735\n1739#2:737\n1814#2,3:738\n1739#2:741\n1814#2,3:742\n1739#2:745\n1814#2,3:746\n777#2:749\n873#2,2:750\n2068#2:752\n2068#2:753\n2069#2:761\n2069#2:762\n1739#2:763\n1814#2,3:764\n777#2:767\n873#2,2:768\n2068#2:770\n2068#2:771\n2069#2:779\n2069#2:780\n1739#2:806\n1814#2,3:807\n777#2:810\n873#2,2:811\n1#3:733\n1#3:736\n1#3:786\n1#3:813\n460#4,7:754\n460#4,7:772\n221#5,2:781\n93#6,2:783\n63#6:785\n64#6,15:787\n95#6,2:804\n50#7:802\n43#7:803\n*S KotlinDebug\n*F\n+ 1 Zinkmovies.kt\ncom/zinkmovies/Zinkmovies\n*L\n227#1:719\n227#1:720,2\n228#1:722,10\n228#1:732\n228#1:734\n228#1:735\n250#1:737\n250#1:738,3\n281#1:741\n281#1:742,3\n470#1:745\n470#1:746,3\n495#1:749\n495#1:750,2\n496#1:752\n525#1:753\n525#1:761\n496#1:762\n564#1:763\n564#1:764,3\n565#1:767\n565#1:768,2\n567#1:770\n570#1:771\n570#1:779\n567#1:780\n638#1:806\n638#1:807,3\n639#1:810\n639#1:811,2\n228#1:733\n637#1:786\n544#1:754,7\n580#1:772,7\n590#1:781,2\n637#1:783,2\n637#1:785\n637#1:787,15\n637#1:804,2\n637#1:802\n637#1:803\n*E\n"})
public final class Zinkmovies extends MainAPI {

    @NotNull
    public static final String TMDBAPI = "https://api.themoviedb.org/3";

    @NotNull
    public static final String TMDBAPIKEY = "1865f43a0549ca50d341dd9ab8b29f49";

    @NotNull
    public static final String TMDBBASE = "https://image.tmdb.org/t/p/original";
    private final boolean hasQuickSearch;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Mutex cfBypassMutex = MutexKt.Mutex$default(false, 1, (Object) null);

    @NotNull
    private static final List<String> CF_BLOCKER_PHRASES = CollectionsKt.listOf(new String[]{"just a moment", "checking your browser", "ddos-guard", "attention required", "verify you are human", "cloudflare", "cf-browser-verification", "cf-chl-widget"});

    @NotNull
    private String mainUrl = (String) BuildersKt.runBlockingK(EmptyCoroutineContext.INSTANCE, new Zinkmovies$mainUrl$1(null));

    @NotNull
    private String name = "Zinkmovies";

    @NotNull
    private String lang = "hi";
    private final boolean hasMainPage = true;
    private final boolean hasDownloadSupport = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.TvSeries, TvType.Anime});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("", "Home"), TuplesKt.to("movies/", "Movies"), TuplesKt.to("tvshows/", "Tv Shows"), TuplesKt.to("genre/bollywood/", "Bollywood"), TuplesKt.to("genre/HOLLYWOOD-MOVIES/", "Hollywood"), TuplesKt.to("genre/animation/", "Animation"), TuplesKt.to("genre/anime/", "Anime"), TuplesKt.to("genre/korean/", "KDrama")});

    @NotNull
    private final Map<String, String> headers = MapsKt.mapOf(new Pair[]{TuplesKt.to("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36 Edg/131.0.0.0"), TuplesKt.to("Cookie", "xla=s4t")});

    /* JADX INFO: renamed from: com.zinkmovies.Zinkmovies$getMainPage$1 */
    /* JADX INFO: compiled from: Zinkmovies.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.zinkmovies.Zinkmovies", f = "Zinkmovies.kt", i = {0, 0}, l = {221}, m = "getMainPage", n = {"request", "page"}, nl = {226}, s = {"L$0", "I$0"}, v = 2)
    static final class C00131 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00131(Continuation<? super C00131> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Zinkmovies.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.zinkmovies.Zinkmovies$load$1 */
    /* JADX INFO: compiled from: Zinkmovies.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.zinkmovies.Zinkmovies", f = "Zinkmovies.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7}, l = {263, 310, 322, 387, 473, 523, 569, 612}, m = "load", n = {"url", "url", "doc", "title", "seasontitle", "seasonNumber", "image", "plot", "tags", "poster", "trailer", "tvtype", "recommendations", "actorData", "genre", "year", "background", "description", "tmdbIdResolved", "$this$load_u24lambda_u242", "query", "type", "searchUrl", "url", "doc", "title", "seasontitle", "seasonNumber", "image", "plot", "tags", "poster", "trailer", "tvtype", "recommendations", "actorData", "genre", "year", "background", "description", "tmdbIdResolved", "$this$load_u24lambda_u243", "type", "url", "doc", "title", "seasontitle", "seasonNumber", "image", "plot", "tags", "poster", "trailer", "tvtype", "recommendations", "actorData", "genre", "year", "background", "description", "tmdbIdResolved", "$this$load_u24lambda_u243", "type", "detailsText", "detailsJson", "yearRaw", "metaYear", "metaRating", "metaDesc", "metaBackground", "metaName", "imdbId", "logoPath", "actorDataList", "metaGenres", "videos", "totalSeasons", "season", "url", "doc", "title", "seasontitle", "seasonNumber", "image", "plot", "tags", "poster", "trailer", "tvtype", "recommendations", "actorData", "genre", "year", "background", "description", "tmdbIdResolved", "responseData", "movieList", "url", "doc", "title", "seasontitle", "seasonNumber", "image", "plot", "tags", "poster", "trailer", "tvtype", "recommendations", "actorData", "genre", "year", "background", "description", "tmdbIdResolved", "responseData", "episodesData", "epLinksMap", "seasonRegex", "episodeRegex", "$this$forEach$iv", "element$iv", "seasonElement", "next", "seasonUrl", "seasonNum", "url", "doc", "title", "seasontitle", "seasonNumber", "image", "plot", "tags", "poster", "trailer", "tvtype", "recommendations", "actorData", "genre", "year", "background", "description", "tmdbIdResolved", "responseData", "episodesData", "epLinksMap", "seasonRegex", "episodeRegex", "$this$forEach$iv", "element$iv", "linkUrl", "fallbackSeason", "url", "doc", "title", "seasontitle", "seasonNumber", "image", "plot", "tags", "poster", "trailer", "tvtype", "recommendations", "actorData", "genre", "year", "background", "description", "tmdbIdResolved", "responseData", "episodesData", "epLinksMap", "seasonRegex", "episodeRegex"}, nl = {264, 312, 324, 389, 488, 525, 570, -1}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$28", "L$29", "L$30", "L$31", "L$32", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$25", "L$26", "L$27", "L$28", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$25", "L$26", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22"}, v = 2)
    static final class C00141 extends ContinuationImpl {
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
        Object L$25;
        Object L$26;
        Object L$27;
        Object L$28;
        Object L$29;
        Object L$3;
        Object L$30;
        Object L$31;
        Object L$32;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C00141(Continuation<? super C00141> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Zinkmovies.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.zinkmovies.Zinkmovies$loadLinks$1 */
    /* JADX INFO: compiled from: Zinkmovies.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.zinkmovies.Zinkmovies", f = "Zinkmovies.kt", i = {0, 0, 0, 0, 0}, l = {644}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "linksList", "isCasting"}, nl = {669}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0"}, v = 2)
    static final class C00171 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00171(Continuation<? super C00171> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Zinkmovies.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.zinkmovies.Zinkmovies$search$1 */
    /* JADX INFO: compiled from: Zinkmovies.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.zinkmovies.Zinkmovies", f = "Zinkmovies.kt", i = {0, 0}, l = {248}, m = "search", n = {"query", "page"}, nl = {250}, s = {"L$0", "I$0"}, v = 2)
    static final class C00191 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00191(Continuation<? super C00191> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Zinkmovies.this.search(null, 0, (Continuation) this);
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

    public boolean getHasQuickSearch() {
        return this.hasQuickSearch;
    }

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    /* JADX INFO: compiled from: Zinkmovies.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ@\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00052\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u001aR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001b"}, d2 = {"Lcom/zinkmovies/Zinkmovies$Companion;", "", "<init>", "()V", "TMDBAPIKEY", "", "TMDBBASE", "TMDBAPI", "cfBypassMutex", "Lkotlinx/coroutines/sync/Mutex;", "CF_BLOCKER_PHRASES", "", "isCloudflareBlocked", "", "response", "Lcom/lagradost/nicehttp/NiceResponse;", "cfHeaders", "", "getCfHeaders", "()Ljava/util/Map;", "appGet", "url", "headers", "cacheTime", "", "allowRedirects", "(Ljava/lang/String;Ljava/util/Map;IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Zinkmovies"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nZinkmovies.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zinkmovies.kt\ncom/zinkmovies/Zinkmovies$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,718:1\n1960#2,3:719\n117#3,10:722\n1#4:732\n*S KotlinDebug\n*F\n+ 1 Zinkmovies.kt\ncom/zinkmovies/Zinkmovies$Companion\n*L\n151#1:719,3\n179#1:722,10\n*E\n"})
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
            String body = response.getText().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(body, "toLowerCase(...)");
            Iterable $this$any$iv = Zinkmovies.CF_BLOCKER_PHRASES;
            if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
                return false;
            }
            for (Object element$iv : $this$any$iv) {
                String it = (String) element$iv;
                if (StringsKt.contains$default(body, it, false, 2, (Object) null)) {
                    return true;
                }
            }
            return false;
        }

        @NotNull
        public final Map<String, String> getCfHeaders() {
            Map map = new LinkedHashMap();
            String savedUa = ZinkmoviesPlugin.INSTANCE.getCfUserAgent();
            if (savedUa.length() > 0) {
                map.put("User-Agent", savedUa);
            }
            String savedCookies = ZinkmoviesPlugin.INSTANCE.getCfCookies();
            if (savedCookies.length() > 0) {
                map.put("Cookie", savedCookies);
            }
            return map;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object appGet$default(Companion companion, String str, Map map, int i, boolean z, Continuation continuation, int i2, Object obj) {
            return companion.appGet(str, (i2 & 2) != 0 ? MapsKt.emptyMap() : map, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? true : z, continuation);
        }

        /* JADX WARN: Code duplicated, block: B:29:0x014d A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:30:0x014e  */
        /* JADX WARN: Code duplicated, block: B:32:0x0174 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:33:0x0175  */
        /* JADX WARN: Code duplicated, block: B:37:0x018f  */
        /* JADX WARN: Code duplicated, block: B:38:0x0191  */
        /* JADX WARN: Code duplicated, block: B:44:0x01d5 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:45:0x01d6  */
        /* JADX WARN: Code duplicated, block: B:48:0x01f1 A[Catch: all -> 0x01f4, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x01f4, blocks: (B:48:0x01f1, B:54:0x0201), top: B:85:0x01ef }] */
        /* JADX WARN: Code duplicated, block: B:52:0x01f9 A[Catch: all -> 0x02af, TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x02af, blocks: (B:46:0x01e6, B:52:0x01f9), top: B:87:0x01e6 }] */
        /* JADX WARN: Code duplicated, block: B:54:0x0201 A[Catch: all -> 0x01f4, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x01f4, blocks: (B:48:0x01f1, B:54:0x0201), top: B:85:0x01ef }] */
        /* JADX WARN: Code duplicated, block: B:56:0x0222 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:62:0x023e  */
        /* JADX WARN: Code duplicated, block: B:64:0x0240  */
        /* JADX WARN: Code duplicated, block: B:66:0x0297 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:67:0x0298  */
        /* JADX WARN: Code duplicated, block: B:7:0x0018  */
        @Nullable
        public final Object appGet(@NotNull String url, @NotNull Map<String, String> map, int cacheTime, boolean allowRedirects, @NotNull Continuation<? super NiceResponse> continuation) throws Throwable {
            Zinkmovies$Companion$appGet$1 zinkmovies$Companion$appGet$1;
            Mutex $this$withLock_u24default$iv;
            Object owner$iv;
            Object obj;
            Zinkmovies$Companion$appGet$1 zinkmovies$Companion$appGet$2;
            String url2;
            Map<String, String> map2;
            int cacheTime2;
            boolean allowRedirects2;
            NiceResponse rawResponse;
            Ref.ObjectRef recheckPassed;
            Mutex $this$withLock_u24default$iv2;
            NiceResponse rawResponse2;
            boolean allowRedirects3;
            Map<String, String> map3;
            String url3;
            Mutex $this$withLock_u24default$iv3;
            Object owner$iv2;
            int $i$f$withLock;
            int cacheTime3;
            boolean z;
            Ref.ObjectRef recheckPassed2;
            boolean allowRedirects4;
            String url4;
            Mutex $this$withLock_u24default$iv4;
            Map<String, String> map4;
            Object obj2;
            Zinkmovies$Companion$appGet$1 zinkmovies$Companion$appGet$3;
            String url5;
            Map<String, String> map5;
            int cacheTime4;
            boolean allowRedirects5;
            NiceResponse rawResponse3;
            Ref.ObjectRef recheckPassed3;
            NiceResponse recheck;
            boolean allowRedirects6;
            Object owner$iv3;
            Ref.ObjectRef recheckPassed4;
            NiceResponse rawResponse4;
            int cacheTime5;
            NiceResponse it;
            Object obj3;
            if (continuation instanceof Zinkmovies$Companion$appGet$1) {
                zinkmovies$Companion$appGet$1 = (Zinkmovies$Companion$appGet$1) continuation;
                if ((zinkmovies$Companion$appGet$1.label & Integer.MIN_VALUE) != 0) {
                    zinkmovies$Companion$appGet$1.label -= Integer.MIN_VALUE;
                } else {
                    zinkmovies$Companion$appGet$1 = new Zinkmovies$Companion$appGet$1(this, continuation);
                }
            } else {
                zinkmovies$Companion$appGet$1 = new Zinkmovies$Companion$appGet$1(this, continuation);
            }
            Zinkmovies$Companion$appGet$1 zinkmovies$Companion$appGet$4 = zinkmovies$Companion$appGet$1;
            Object $result = zinkmovies$Companion$appGet$4.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (zinkmovies$Companion$appGet$4.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Requests app = MainActivityKt.getApp();
                        ZinkmoviesCFBypassInterceptor zinkmoviesCFBypassInterceptor = ZinkmoviesCFBypassInterceptor.INSTANCE;
                        zinkmovies$Companion$appGet$4.L$0 = url;
                        zinkmovies$Companion$appGet$4.L$1 = map;
                        zinkmovies$Companion$appGet$4.I$0 = cacheTime;
                        zinkmovies$Companion$appGet$4.Z$0 = allowRedirects;
                        zinkmovies$Companion$appGet$4.label = 1;
                        obj = Requests.get$default(app, url, map, (String) null, (Map) null, (Map) null, allowRedirects, cacheTime, (TimeUnit) null, 0L, zinkmoviesCFBypassInterceptor, false, (ResponseParser) null, zinkmovies$Companion$appGet$4, 3484, (Object) null);
                        zinkmovies$Companion$appGet$2 = zinkmovies$Companion$appGet$4;
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        url2 = url;
                        map2 = map;
                        cacheTime2 = cacheTime;
                        allowRedirects2 = allowRedirects;
                        rawResponse = (NiceResponse) obj;
                        if (!isCloudflareBlocked(rawResponse)) {
                            return rawResponse;
                        }
                        recheckPassed = new Ref.ObjectRef();
                        $this$withLock_u24default$iv2 = Zinkmovies.cfBypassMutex;
                        zinkmovies$Companion$appGet$2.L$0 = url2;
                        zinkmovies$Companion$appGet$2.L$1 = map2;
                        zinkmovies$Companion$appGet$2.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse);
                        zinkmovies$Companion$appGet$2.L$3 = recheckPassed;
                        zinkmovies$Companion$appGet$2.L$4 = $this$withLock_u24default$iv2;
                        zinkmovies$Companion$appGet$2.I$0 = cacheTime2;
                        zinkmovies$Companion$appGet$2.Z$0 = allowRedirects2;
                        zinkmovies$Companion$appGet$2.label = 2;
                        if ($this$withLock_u24default$iv2.lock((Object) null, zinkmovies$Companion$appGet$2) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        rawResponse2 = rawResponse;
                        allowRedirects3 = allowRedirects2;
                        map3 = map2;
                        url3 = url2;
                        $this$withLock_u24default$iv3 = $this$withLock_u24default$iv2;
                        owner$iv2 = null;
                        $i$f$withLock = 0;
                        cacheTime3 = cacheTime2;
                        try {
                            Requests app2 = MainActivityKt.getApp();
                            ZinkmoviesCFBypassInterceptor zinkmoviesCFBypassInterceptor2 = ZinkmoviesCFBypassInterceptor.INSTANCE;
                            if (allowRedirects3) {
                                z = true;
                            } else {
                                z = false;
                            }
                            ZinkmoviesCFBypassInterceptor zinkmoviesCFBypassInterceptor3 = zinkmoviesCFBypassInterceptor2;
                            zinkmovies$Companion$appGet$2.L$0 = url3;
                            zinkmovies$Companion$appGet$2.L$1 = map3;
                            zinkmovies$Companion$appGet$2.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse2);
                            zinkmovies$Companion$appGet$2.L$3 = recheckPassed;
                            zinkmovies$Companion$appGet$2.L$4 = $this$withLock_u24default$iv3;
                            zinkmovies$Companion$appGet$2.I$0 = cacheTime3;
                            zinkmovies$Companion$appGet$2.Z$0 = allowRedirects3;
                            zinkmovies$Companion$appGet$2.label = 3;
                            recheckPassed2 = recheckPassed;
                            allowRedirects4 = allowRedirects3;
                            Zinkmovies$Companion$appGet$1 zinkmovies$Companion$appGet$5 = zinkmovies$Companion$appGet$2;
                            url4 = url3;
                            $this$withLock_u24default$iv4 = $this$withLock_u24default$iv3;
                            map4 = map3;
                            try {
                                obj2 = Requests.get$default(app2, url4, map4, (String) null, (Map) null, (Map) null, z, cacheTime3, (TimeUnit) null, 0L, zinkmoviesCFBypassInterceptor3, false, (ResponseParser) null, zinkmovies$Companion$appGet$5, 3484, (Object) null);
                                zinkmovies$Companion$appGet$3 = zinkmovies$Companion$appGet$5;
                                if (obj2 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                url5 = url4;
                                map5 = map4;
                                cacheTime4 = cacheTime3;
                                allowRedirects5 = allowRedirects4;
                                owner$iv = owner$iv2;
                                rawResponse3 = rawResponse2;
                                $this$withLock_u24default$iv = $this$withLock_u24default$iv4;
                                recheckPassed3 = recheckPassed2;
                                $result = obj2;
                                try {
                                    recheck = (NiceResponse) $result;
                                    try {
                                        try {
                                            if (!Zinkmovies.INSTANCE.isCloudflareBlocked(recheck)) {
                                                if (ZinkmoviesPlugin.INSTANCE.getCfWebviewEnabled()) {
                                                    zinkmovies$Companion$appGet$3.L$0 = url5;
                                                    zinkmovies$Companion$appGet$3.L$1 = map5;
                                                    zinkmovies$Companion$appGet$3.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse3);
                                                    zinkmovies$Companion$appGet$3.L$3 = recheckPassed3;
                                                    zinkmovies$Companion$appGet$3.L$4 = $this$withLock_u24default$iv;
                                                    zinkmovies$Companion$appGet$3.L$5 = SpillingKt.nullOutSpilledVariable(recheck);
                                                    zinkmovies$Companion$appGet$3.I$0 = cacheTime4;
                                                    zinkmovies$Companion$appGet$3.Z$0 = allowRedirects5;
                                                    zinkmovies$Companion$appGet$3.label = 4;
                                                    if (ZinkmoviesKt.showCFBypassDialogAndWait(url5, zinkmovies$Companion$appGet$3) == coroutine_suspended) {
                                                        return coroutine_suspended;
                                                    }
                                                    allowRedirects6 = allowRedirects5;
                                                    owner$iv3 = owner$iv;
                                                    recheckPassed4 = recheckPassed3;
                                                    rawResponse4 = rawResponse3;
                                                    cacheTime5 = cacheTime4;
                                                }
                                                Unit unit = Unit.INSTANCE;
                                                $this$withLock_u24default$iv.unlock(owner$iv3);
                                                Object owner$iv4 = recheckPassed4.element;
                                                it = (NiceResponse) owner$iv4;
                                                if (it != null) {
                                                    return it;
                                                }
                                                Ref.ObjectRef recheckPassed5 = recheckPassed4;
                                                Requests app3 = MainActivityKt.getApp();
                                                ZinkmoviesCFBypassInterceptor zinkmoviesCFBypassInterceptor4 = ZinkmoviesCFBypassInterceptor.INSTANCE;
                                                zinkmovies$Companion$appGet$3.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                                                zinkmovies$Companion$appGet$3.L$1 = SpillingKt.nullOutSpilledVariable(map5);
                                                zinkmovies$Companion$appGet$3.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse4);
                                                zinkmovies$Companion$appGet$3.L$3 = SpillingKt.nullOutSpilledVariable(recheckPassed5);
                                                zinkmovies$Companion$appGet$3.L$4 = null;
                                                zinkmovies$Companion$appGet$3.L$5 = null;
                                                zinkmovies$Companion$appGet$3.I$0 = cacheTime5;
                                                zinkmovies$Companion$appGet$3.Z$0 = allowRedirects6;
                                                zinkmovies$Companion$appGet$3.label = 5;
                                                obj3 = Requests.get$default(app3, url5, map5, (String) null, (Map) null, (Map) null, allowRedirects6, cacheTime5, (TimeUnit) null, 0L, zinkmoviesCFBypassInterceptor4, false, (ResponseParser) null, zinkmovies$Companion$appGet$3, 3484, (Object) null);
                                                if (obj3 == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                return obj3;
                                            }
                                            recheckPassed3.element = recheck;
                                            Unit unit2 = Unit.INSTANCE;
                                            $this$withLock_u24default$iv.unlock(owner$iv3);
                                            Object owner$iv5 = recheckPassed4.element;
                                            it = (NiceResponse) owner$iv5;
                                            if (it != null) {
                                                return it;
                                            }
                                            Ref.ObjectRef recheckPassed6 = recheckPassed4;
                                            Requests app4 = MainActivityKt.getApp();
                                            ZinkmoviesCFBypassInterceptor zinkmoviesCFBypassInterceptor5 = ZinkmoviesCFBypassInterceptor.INSTANCE;
                                            zinkmovies$Companion$appGet$3.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                                            zinkmovies$Companion$appGet$3.L$1 = SpillingKt.nullOutSpilledVariable(map5);
                                            zinkmovies$Companion$appGet$3.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse4);
                                            zinkmovies$Companion$appGet$3.L$3 = SpillingKt.nullOutSpilledVariable(recheckPassed6);
                                            zinkmovies$Companion$appGet$3.L$4 = null;
                                            zinkmovies$Companion$appGet$3.L$5 = null;
                                            zinkmovies$Companion$appGet$3.I$0 = cacheTime5;
                                            zinkmovies$Companion$appGet$3.Z$0 = allowRedirects6;
                                            zinkmovies$Companion$appGet$3.label = 5;
                                            obj3 = Requests.get$default(app4, url5, map5, (String) null, (Map) null, (Map) null, allowRedirects6, cacheTime5, (TimeUnit) null, 0L, zinkmoviesCFBypassInterceptor5, false, (ResponseParser) null, zinkmovies$Companion$appGet$3, 3484, (Object) null);
                                            if (obj3 == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            return obj3;
                                        } catch (Throwable th) {
                                            th = th;
                                            owner$iv = owner$iv3;
                                            $this$withLock_u24default$iv.unlock(owner$iv);
                                            throw th;
                                        }
                                        allowRedirects6 = allowRedirects5;
                                        owner$iv3 = owner$iv;
                                        recheckPassed4 = recheckPassed3;
                                        rawResponse4 = rawResponse3;
                                        cacheTime5 = cacheTime4;
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
                        allowRedirects2 = zinkmovies$Companion$appGet$4.Z$0;
                        cacheTime2 = zinkmovies$Companion$appGet$4.I$0;
                        map2 = (Map) zinkmovies$Companion$appGet$4.L$1;
                        url2 = (String) zinkmovies$Companion$appGet$4.L$0;
                        ResultKt.throwOnFailure($result);
                        zinkmovies$Companion$appGet$2 = zinkmovies$Companion$appGet$4;
                        obj = $result;
                        rawResponse = (NiceResponse) obj;
                        if (!isCloudflareBlocked(rawResponse)) {
                            return rawResponse;
                        }
                        recheckPassed = new Ref.ObjectRef();
                        $this$withLock_u24default$iv2 = Zinkmovies.cfBypassMutex;
                        zinkmovies$Companion$appGet$2.L$0 = url2;
                        zinkmovies$Companion$appGet$2.L$1 = map2;
                        zinkmovies$Companion$appGet$2.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse);
                        zinkmovies$Companion$appGet$2.L$3 = recheckPassed;
                        zinkmovies$Companion$appGet$2.L$4 = $this$withLock_u24default$iv2;
                        zinkmovies$Companion$appGet$2.I$0 = cacheTime2;
                        zinkmovies$Companion$appGet$2.Z$0 = allowRedirects2;
                        zinkmovies$Companion$appGet$2.label = 2;
                        if ($this$withLock_u24default$iv2.lock((Object) null, zinkmovies$Companion$appGet$2) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        rawResponse2 = rawResponse;
                        allowRedirects3 = allowRedirects2;
                        map3 = map2;
                        url3 = url2;
                        $this$withLock_u24default$iv3 = $this$withLock_u24default$iv2;
                        owner$iv2 = null;
                        $i$f$withLock = 0;
                        cacheTime3 = cacheTime2;
                        Requests app5 = MainActivityKt.getApp();
                        ZinkmoviesCFBypassInterceptor zinkmoviesCFBypassInterceptor6 = ZinkmoviesCFBypassInterceptor.INSTANCE;
                        if (allowRedirects3) {
                            z = true;
                        } else {
                            z = false;
                        }
                        ZinkmoviesCFBypassInterceptor zinkmoviesCFBypassInterceptor7 = zinkmoviesCFBypassInterceptor6;
                        zinkmovies$Companion$appGet$2.L$0 = url3;
                        zinkmovies$Companion$appGet$2.L$1 = map3;
                        zinkmovies$Companion$appGet$2.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse2);
                        zinkmovies$Companion$appGet$2.L$3 = recheckPassed;
                        zinkmovies$Companion$appGet$2.L$4 = $this$withLock_u24default$iv3;
                        zinkmovies$Companion$appGet$2.I$0 = cacheTime3;
                        zinkmovies$Companion$appGet$2.Z$0 = allowRedirects3;
                        zinkmovies$Companion$appGet$2.label = 3;
                        recheckPassed2 = recheckPassed;
                        allowRedirects4 = allowRedirects3;
                        Zinkmovies$Companion$appGet$1 zinkmovies$Companion$appGet$6 = zinkmovies$Companion$appGet$2;
                        url4 = url3;
                        $this$withLock_u24default$iv4 = $this$withLock_u24default$iv3;
                        map4 = map3;
                        obj2 = Requests.get$default(app5, url4, map4, (String) null, (Map) null, (Map) null, z, cacheTime3, (TimeUnit) null, 0L, zinkmoviesCFBypassInterceptor7, false, (ResponseParser) null, zinkmovies$Companion$appGet$6, 3484, (Object) null);
                        zinkmovies$Companion$appGet$3 = zinkmovies$Companion$appGet$6;
                        if (obj2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        url5 = url4;
                        map5 = map4;
                        cacheTime4 = cacheTime3;
                        allowRedirects5 = allowRedirects4;
                        owner$iv = owner$iv2;
                        rawResponse3 = rawResponse2;
                        $this$withLock_u24default$iv = $this$withLock_u24default$iv4;
                        recheckPassed3 = recheckPassed2;
                        $result = obj2;
                        recheck = (NiceResponse) $result;
                        if (!Zinkmovies.INSTANCE.isCloudflareBlocked(recheck)) {
                            if (ZinkmoviesPlugin.INSTANCE.getCfWebviewEnabled()) {
                                zinkmovies$Companion$appGet$3.L$0 = url5;
                                zinkmovies$Companion$appGet$3.L$1 = map5;
                                zinkmovies$Companion$appGet$3.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse3);
                                zinkmovies$Companion$appGet$3.L$3 = recheckPassed3;
                                zinkmovies$Companion$appGet$3.L$4 = $this$withLock_u24default$iv;
                                zinkmovies$Companion$appGet$3.L$5 = SpillingKt.nullOutSpilledVariable(recheck);
                                zinkmovies$Companion$appGet$3.I$0 = cacheTime4;
                                zinkmovies$Companion$appGet$3.Z$0 = allowRedirects5;
                                zinkmovies$Companion$appGet$3.label = 4;
                                if (ZinkmoviesKt.showCFBypassDialogAndWait(url5, zinkmovies$Companion$appGet$3) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                allowRedirects6 = allowRedirects5;
                                owner$iv3 = owner$iv;
                                recheckPassed4 = recheckPassed3;
                                rawResponse4 = rawResponse3;
                                cacheTime5 = cacheTime4;
                            }
                            Unit unit3 = Unit.INSTANCE;
                            $this$withLock_u24default$iv.unlock(owner$iv3);
                            Object owner$iv6 = recheckPassed4.element;
                            it = (NiceResponse) owner$iv6;
                            if (it != null) {
                                return it;
                            }
                            Ref.ObjectRef recheckPassed7 = recheckPassed4;
                            Requests app6 = MainActivityKt.getApp();
                            ZinkmoviesCFBypassInterceptor zinkmoviesCFBypassInterceptor8 = ZinkmoviesCFBypassInterceptor.INSTANCE;
                            zinkmovies$Companion$appGet$3.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                            zinkmovies$Companion$appGet$3.L$1 = SpillingKt.nullOutSpilledVariable(map5);
                            zinkmovies$Companion$appGet$3.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse4);
                            zinkmovies$Companion$appGet$3.L$3 = SpillingKt.nullOutSpilledVariable(recheckPassed7);
                            zinkmovies$Companion$appGet$3.L$4 = null;
                            zinkmovies$Companion$appGet$3.L$5 = null;
                            zinkmovies$Companion$appGet$3.I$0 = cacheTime5;
                            zinkmovies$Companion$appGet$3.Z$0 = allowRedirects6;
                            zinkmovies$Companion$appGet$3.label = 5;
                            obj3 = Requests.get$default(app6, url5, map5, (String) null, (Map) null, (Map) null, allowRedirects6, cacheTime5, (TimeUnit) null, 0L, zinkmoviesCFBypassInterceptor8, false, (ResponseParser) null, zinkmovies$Companion$appGet$3, 3484, (Object) null);
                            if (obj3 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return obj3;
                        }
                        recheckPassed3.element = recheck;
                        allowRedirects6 = allowRedirects5;
                        owner$iv3 = owner$iv;
                        recheckPassed4 = recheckPassed3;
                        rawResponse4 = rawResponse3;
                        cacheTime5 = cacheTime4;
                        Unit unit4 = Unit.INSTANCE;
                        $this$withLock_u24default$iv.unlock(owner$iv3);
                        Object owner$iv7 = recheckPassed4.element;
                        it = (NiceResponse) owner$iv7;
                        if (it != null) {
                            return it;
                        }
                        Ref.ObjectRef recheckPassed8 = recheckPassed4;
                        Requests app7 = MainActivityKt.getApp();
                        ZinkmoviesCFBypassInterceptor zinkmoviesCFBypassInterceptor9 = ZinkmoviesCFBypassInterceptor.INSTANCE;
                        zinkmovies$Companion$appGet$3.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                        zinkmovies$Companion$appGet$3.L$1 = SpillingKt.nullOutSpilledVariable(map5);
                        zinkmovies$Companion$appGet$3.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse4);
                        zinkmovies$Companion$appGet$3.L$3 = SpillingKt.nullOutSpilledVariable(recheckPassed8);
                        zinkmovies$Companion$appGet$3.L$4 = null;
                        zinkmovies$Companion$appGet$3.L$5 = null;
                        zinkmovies$Companion$appGet$3.I$0 = cacheTime5;
                        zinkmovies$Companion$appGet$3.Z$0 = allowRedirects6;
                        zinkmovies$Companion$appGet$3.label = 5;
                        obj3 = Requests.get$default(app7, url5, map5, (String) null, (Map) null, (Map) null, allowRedirects6, cacheTime5, (TimeUnit) null, 0L, zinkmoviesCFBypassInterceptor9, false, (ResponseParser) null, zinkmovies$Companion$appGet$3, 3484, (Object) null);
                        if (obj3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return obj3;
                    case 2:
                        boolean allowRedirects7 = zinkmovies$Companion$appGet$4.Z$0;
                        int cacheTime6 = zinkmovies$Companion$appGet$4.I$0;
                        Mutex $this$withLock_u24default$iv5 = (Mutex) zinkmovies$Companion$appGet$4.L$4;
                        Ref.ObjectRef recheckPassed9 = (Ref.ObjectRef) zinkmovies$Companion$appGet$4.L$3;
                        NiceResponse rawResponse5 = (NiceResponse) zinkmovies$Companion$appGet$4.L$2;
                        map3 = (Map) zinkmovies$Companion$appGet$4.L$1;
                        url3 = (String) zinkmovies$Companion$appGet$4.L$0;
                        ResultKt.throwOnFailure($result);
                        $i$f$withLock = 0;
                        owner$iv2 = null;
                        $this$withLock_u24default$iv3 = $this$withLock_u24default$iv5;
                        recheckPassed = recheckPassed9;
                        rawResponse2 = rawResponse5;
                        zinkmovies$Companion$appGet$2 = zinkmovies$Companion$appGet$4;
                        allowRedirects3 = allowRedirects7;
                        cacheTime3 = cacheTime6;
                        Requests app8 = MainActivityKt.getApp();
                        ZinkmoviesCFBypassInterceptor zinkmoviesCFBypassInterceptor10 = ZinkmoviesCFBypassInterceptor.INSTANCE;
                        if (allowRedirects3) {
                            z = true;
                        } else {
                            z = false;
                        }
                        ZinkmoviesCFBypassInterceptor zinkmoviesCFBypassInterceptor11 = zinkmoviesCFBypassInterceptor10;
                        zinkmovies$Companion$appGet$2.L$0 = url3;
                        zinkmovies$Companion$appGet$2.L$1 = map3;
                        zinkmovies$Companion$appGet$2.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse2);
                        zinkmovies$Companion$appGet$2.L$3 = recheckPassed;
                        zinkmovies$Companion$appGet$2.L$4 = $this$withLock_u24default$iv3;
                        zinkmovies$Companion$appGet$2.I$0 = cacheTime3;
                        zinkmovies$Companion$appGet$2.Z$0 = allowRedirects3;
                        zinkmovies$Companion$appGet$2.label = 3;
                        recheckPassed2 = recheckPassed;
                        allowRedirects4 = allowRedirects3;
                        Zinkmovies$Companion$appGet$1 zinkmovies$Companion$appGet$7 = zinkmovies$Companion$appGet$2;
                        url4 = url3;
                        $this$withLock_u24default$iv4 = $this$withLock_u24default$iv3;
                        map4 = map3;
                        obj2 = Requests.get$default(app8, url4, map4, (String) null, (Map) null, (Map) null, z, cacheTime3, (TimeUnit) null, 0L, zinkmoviesCFBypassInterceptor11, false, (ResponseParser) null, zinkmovies$Companion$appGet$7, 3484, (Object) null);
                        zinkmovies$Companion$appGet$3 = zinkmovies$Companion$appGet$7;
                        if (obj2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        url5 = url4;
                        map5 = map4;
                        cacheTime4 = cacheTime3;
                        allowRedirects5 = allowRedirects4;
                        owner$iv = owner$iv2;
                        rawResponse3 = rawResponse2;
                        $this$withLock_u24default$iv = $this$withLock_u24default$iv4;
                        recheckPassed3 = recheckPassed2;
                        $result = obj2;
                        recheck = (NiceResponse) $result;
                        if (!Zinkmovies.INSTANCE.isCloudflareBlocked(recheck)) {
                            if (ZinkmoviesPlugin.INSTANCE.getCfWebviewEnabled()) {
                                zinkmovies$Companion$appGet$3.L$0 = url5;
                                zinkmovies$Companion$appGet$3.L$1 = map5;
                                zinkmovies$Companion$appGet$3.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse3);
                                zinkmovies$Companion$appGet$3.L$3 = recheckPassed3;
                                zinkmovies$Companion$appGet$3.L$4 = $this$withLock_u24default$iv;
                                zinkmovies$Companion$appGet$3.L$5 = SpillingKt.nullOutSpilledVariable(recheck);
                                zinkmovies$Companion$appGet$3.I$0 = cacheTime4;
                                zinkmovies$Companion$appGet$3.Z$0 = allowRedirects5;
                                zinkmovies$Companion$appGet$3.label = 4;
                                if (ZinkmoviesKt.showCFBypassDialogAndWait(url5, zinkmovies$Companion$appGet$3) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                allowRedirects6 = allowRedirects5;
                                owner$iv3 = owner$iv;
                                recheckPassed4 = recheckPassed3;
                                rawResponse4 = rawResponse3;
                                cacheTime5 = cacheTime4;
                            }
                            Unit unit5 = Unit.INSTANCE;
                            $this$withLock_u24default$iv.unlock(owner$iv3);
                            Object owner$iv8 = recheckPassed4.element;
                            it = (NiceResponse) owner$iv8;
                            if (it != null) {
                                return it;
                            }
                            Ref.ObjectRef recheckPassed10 = recheckPassed4;
                            Requests app9 = MainActivityKt.getApp();
                            ZinkmoviesCFBypassInterceptor zinkmoviesCFBypassInterceptor12 = ZinkmoviesCFBypassInterceptor.INSTANCE;
                            zinkmovies$Companion$appGet$3.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                            zinkmovies$Companion$appGet$3.L$1 = SpillingKt.nullOutSpilledVariable(map5);
                            zinkmovies$Companion$appGet$3.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse4);
                            zinkmovies$Companion$appGet$3.L$3 = SpillingKt.nullOutSpilledVariable(recheckPassed10);
                            zinkmovies$Companion$appGet$3.L$4 = null;
                            zinkmovies$Companion$appGet$3.L$5 = null;
                            zinkmovies$Companion$appGet$3.I$0 = cacheTime5;
                            zinkmovies$Companion$appGet$3.Z$0 = allowRedirects6;
                            zinkmovies$Companion$appGet$3.label = 5;
                            obj3 = Requests.get$default(app9, url5, map5, (String) null, (Map) null, (Map) null, allowRedirects6, cacheTime5, (TimeUnit) null, 0L, zinkmoviesCFBypassInterceptor12, false, (ResponseParser) null, zinkmovies$Companion$appGet$3, 3484, (Object) null);
                            if (obj3 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return obj3;
                        }
                        recheckPassed3.element = recheck;
                        allowRedirects6 = allowRedirects5;
                        owner$iv3 = owner$iv;
                        recheckPassed4 = recheckPassed3;
                        rawResponse4 = rawResponse3;
                        cacheTime5 = cacheTime4;
                        Unit unit6 = Unit.INSTANCE;
                        $this$withLock_u24default$iv.unlock(owner$iv3);
                        Object owner$iv9 = recheckPassed4.element;
                        it = (NiceResponse) owner$iv9;
                        if (it != null) {
                            return it;
                        }
                        Ref.ObjectRef recheckPassed11 = recheckPassed4;
                        Requests app10 = MainActivityKt.getApp();
                        ZinkmoviesCFBypassInterceptor zinkmoviesCFBypassInterceptor13 = ZinkmoviesCFBypassInterceptor.INSTANCE;
                        zinkmovies$Companion$appGet$3.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                        zinkmovies$Companion$appGet$3.L$1 = SpillingKt.nullOutSpilledVariable(map5);
                        zinkmovies$Companion$appGet$3.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse4);
                        zinkmovies$Companion$appGet$3.L$3 = SpillingKt.nullOutSpilledVariable(recheckPassed11);
                        zinkmovies$Companion$appGet$3.L$4 = null;
                        zinkmovies$Companion$appGet$3.L$5 = null;
                        zinkmovies$Companion$appGet$3.I$0 = cacheTime5;
                        zinkmovies$Companion$appGet$3.Z$0 = allowRedirects6;
                        zinkmovies$Companion$appGet$3.label = 5;
                        obj3 = Requests.get$default(app10, url5, map5, (String) null, (Map) null, (Map) null, allowRedirects6, cacheTime5, (TimeUnit) null, 0L, zinkmoviesCFBypassInterceptor13, false, (ResponseParser) null, zinkmovies$Companion$appGet$3, 3484, (Object) null);
                        if (obj3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return obj3;
                    case 3:
                        allowRedirects5 = zinkmovies$Companion$appGet$4.Z$0;
                        cacheTime4 = zinkmovies$Companion$appGet$4.I$0;
                        owner$iv = null;
                        $this$withLock_u24default$iv = (Mutex) zinkmovies$Companion$appGet$4.L$4;
                        recheckPassed3 = (Ref.ObjectRef) zinkmovies$Companion$appGet$4.L$3;
                        rawResponse3 = (NiceResponse) zinkmovies$Companion$appGet$4.L$2;
                        map5 = (Map) zinkmovies$Companion$appGet$4.L$1;
                        url5 = (String) zinkmovies$Companion$appGet$4.L$0;
                        ResultKt.throwOnFailure($result);
                        zinkmovies$Companion$appGet$3 = zinkmovies$Companion$appGet$4;
                        recheck = (NiceResponse) $result;
                        if (!Zinkmovies.INSTANCE.isCloudflareBlocked(recheck)) {
                            if (ZinkmoviesPlugin.INSTANCE.getCfWebviewEnabled()) {
                                zinkmovies$Companion$appGet$3.L$0 = url5;
                                zinkmovies$Companion$appGet$3.L$1 = map5;
                                zinkmovies$Companion$appGet$3.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse3);
                                zinkmovies$Companion$appGet$3.L$3 = recheckPassed3;
                                zinkmovies$Companion$appGet$3.L$4 = $this$withLock_u24default$iv;
                                zinkmovies$Companion$appGet$3.L$5 = SpillingKt.nullOutSpilledVariable(recheck);
                                zinkmovies$Companion$appGet$3.I$0 = cacheTime4;
                                zinkmovies$Companion$appGet$3.Z$0 = allowRedirects5;
                                zinkmovies$Companion$appGet$3.label = 4;
                                if (ZinkmoviesKt.showCFBypassDialogAndWait(url5, zinkmovies$Companion$appGet$3) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                allowRedirects6 = allowRedirects5;
                                owner$iv3 = owner$iv;
                                recheckPassed4 = recheckPassed3;
                                rawResponse4 = rawResponse3;
                                cacheTime5 = cacheTime4;
                            }
                            Unit unit7 = Unit.INSTANCE;
                            $this$withLock_u24default$iv.unlock(owner$iv3);
                            Object owner$iv10 = recheckPassed4.element;
                            it = (NiceResponse) owner$iv10;
                            if (it != null) {
                                return it;
                            }
                            Ref.ObjectRef recheckPassed12 = recheckPassed4;
                            Requests app11 = MainActivityKt.getApp();
                            ZinkmoviesCFBypassInterceptor zinkmoviesCFBypassInterceptor14 = ZinkmoviesCFBypassInterceptor.INSTANCE;
                            zinkmovies$Companion$appGet$3.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                            zinkmovies$Companion$appGet$3.L$1 = SpillingKt.nullOutSpilledVariable(map5);
                            zinkmovies$Companion$appGet$3.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse4);
                            zinkmovies$Companion$appGet$3.L$3 = SpillingKt.nullOutSpilledVariable(recheckPassed12);
                            zinkmovies$Companion$appGet$3.L$4 = null;
                            zinkmovies$Companion$appGet$3.L$5 = null;
                            zinkmovies$Companion$appGet$3.I$0 = cacheTime5;
                            zinkmovies$Companion$appGet$3.Z$0 = allowRedirects6;
                            zinkmovies$Companion$appGet$3.label = 5;
                            obj3 = Requests.get$default(app11, url5, map5, (String) null, (Map) null, (Map) null, allowRedirects6, cacheTime5, (TimeUnit) null, 0L, zinkmoviesCFBypassInterceptor14, false, (ResponseParser) null, zinkmovies$Companion$appGet$3, 3484, (Object) null);
                            if (obj3 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return obj3;
                        }
                        recheckPassed3.element = recheck;
                        allowRedirects6 = allowRedirects5;
                        owner$iv3 = owner$iv;
                        recheckPassed4 = recheckPassed3;
                        rawResponse4 = rawResponse3;
                        cacheTime5 = cacheTime4;
                        Unit unit8 = Unit.INSTANCE;
                        $this$withLock_u24default$iv.unlock(owner$iv3);
                        Object owner$iv11 = recheckPassed4.element;
                        it = (NiceResponse) owner$iv11;
                        if (it != null) {
                            return it;
                        }
                        Ref.ObjectRef recheckPassed13 = recheckPassed4;
                        Requests app12 = MainActivityKt.getApp();
                        ZinkmoviesCFBypassInterceptor zinkmoviesCFBypassInterceptor15 = ZinkmoviesCFBypassInterceptor.INSTANCE;
                        zinkmovies$Companion$appGet$3.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                        zinkmovies$Companion$appGet$3.L$1 = SpillingKt.nullOutSpilledVariable(map5);
                        zinkmovies$Companion$appGet$3.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse4);
                        zinkmovies$Companion$appGet$3.L$3 = SpillingKt.nullOutSpilledVariable(recheckPassed13);
                        zinkmovies$Companion$appGet$3.L$4 = null;
                        zinkmovies$Companion$appGet$3.L$5 = null;
                        zinkmovies$Companion$appGet$3.I$0 = cacheTime5;
                        zinkmovies$Companion$appGet$3.Z$0 = allowRedirects6;
                        zinkmovies$Companion$appGet$3.label = 5;
                        obj3 = Requests.get$default(app12, url5, map5, (String) null, (Map) null, (Map) null, allowRedirects6, cacheTime5, (TimeUnit) null, 0L, zinkmoviesCFBypassInterceptor15, false, (ResponseParser) null, zinkmovies$Companion$appGet$3, 3484, (Object) null);
                        if (obj3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return obj3;
                    case 4:
                        allowRedirects5 = zinkmovies$Companion$appGet$4.Z$0;
                        cacheTime4 = zinkmovies$Companion$appGet$4.I$0;
                        owner$iv = null;
                        $this$withLock_u24default$iv = (Mutex) zinkmovies$Companion$appGet$4.L$4;
                        recheckPassed3 = (Ref.ObjectRef) zinkmovies$Companion$appGet$4.L$3;
                        rawResponse3 = (NiceResponse) zinkmovies$Companion$appGet$4.L$2;
                        map5 = (Map) zinkmovies$Companion$appGet$4.L$1;
                        url5 = (String) zinkmovies$Companion$appGet$4.L$0;
                        ResultKt.throwOnFailure($result);
                        zinkmovies$Companion$appGet$3 = zinkmovies$Companion$appGet$4;
                        allowRedirects6 = allowRedirects5;
                        owner$iv3 = owner$iv;
                        recheckPassed4 = recheckPassed3;
                        rawResponse4 = rawResponse3;
                        cacheTime5 = cacheTime4;
                        Unit unit9 = Unit.INSTANCE;
                        $this$withLock_u24default$iv.unlock(owner$iv3);
                        Object owner$iv12 = recheckPassed4.element;
                        it = (NiceResponse) owner$iv12;
                        if (it != null) {
                            return it;
                        }
                        Ref.ObjectRef recheckPassed14 = recheckPassed4;
                        Requests app13 = MainActivityKt.getApp();
                        ZinkmoviesCFBypassInterceptor zinkmoviesCFBypassInterceptor16 = ZinkmoviesCFBypassInterceptor.INSTANCE;
                        zinkmovies$Companion$appGet$3.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                        zinkmovies$Companion$appGet$3.L$1 = SpillingKt.nullOutSpilledVariable(map5);
                        zinkmovies$Companion$appGet$3.L$2 = SpillingKt.nullOutSpilledVariable(rawResponse4);
                        zinkmovies$Companion$appGet$3.L$3 = SpillingKt.nullOutSpilledVariable(recheckPassed14);
                        zinkmovies$Companion$appGet$3.L$4 = null;
                        zinkmovies$Companion$appGet$3.L$5 = null;
                        zinkmovies$Companion$appGet$3.I$0 = cacheTime5;
                        zinkmovies$Companion$appGet$3.Z$0 = allowRedirects6;
                        zinkmovies$Companion$appGet$3.label = 5;
                        obj3 = Requests.get$default(app13, url5, map5, (String) null, (Map) null, (Map) null, allowRedirects6, cacheTime5, (TimeUnit) null, 0L, zinkmoviesCFBypassInterceptor16, false, (ResponseParser) null, zinkmovies$Companion$appGet$3, 3484, (Object) null);
                        if (obj3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return obj3;
                    case 5:
                        boolean z2 = zinkmovies$Companion$appGet$4.Z$0;
                        int i = zinkmovies$Companion$appGet$4.I$0;
                        ResultKt.throwOnFailure($result);
                        return $result;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
    }

    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) throws Throwable {
        C00131 c00131;
        MainPageRequest request2;
        Object objAppGet;
        int page2 = page;
        if (continuation instanceof C00131) {
            c00131 = (C00131) continuation;
            if ((c00131.label & Integer.MIN_VALUE) != 0) {
                c00131.label -= Integer.MIN_VALUE;
            } else {
                c00131 = new C00131(continuation);
            }
        } else {
            c00131 = new C00131(continuation);
        }
        C00131 c00132 = c00131;
        Object $result = c00132.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00132.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                DonationManager.INSTANCE.checkAndShow(getName());
                Companion companion = INSTANCE;
                String str = getMainUrl() + '/' + request.getData() + "page/" + page2 + '/';
                Map<String, String> map = this.headers;
                request2 = request;
                c00132.L$0 = request2;
                c00132.I$0 = page2;
                c00132.label = 1;
                objAppGet = companion.appGet(str, map, 60, true, c00132);
                if (objAppGet == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                page2 = c00132.I$0;
                MainPageRequest request3 = (MainPageRequest) c00132.L$0;
                ResultKt.throwOnFailure($result);
                request2 = request3;
                objAppGet = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document doc = ((NiceResponse) objAppGet).getDocument();
        Iterable $this$filterNot$iv = doc.select("article");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filterNot$iv) {
            Element it = (Element) element$iv$iv;
            if (!((it.closest(".animation-1") == null && it.closest(".items.featured") == null) ? false : true)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable $this$mapNotNull$iv = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            int page3 = page2;
            SearchResponse result = toResult((Element) element$iv$iv$iv);
            if (result != null) {
                destination$iv$iv2.add(result);
            }
            page2 = page3;
        }
        List home = (List) destination$iv$iv2;
        return MainAPIKt.newHomePageResponse(request2.getName(), home, Boxing.boxBoolean(true));
    }

    private final SearchResponse toResult(final Element post) {
        String titleText = post.select("h3 a").text();
        String title = UtilsKt.cleanTitle(titleText);
        String url = post.select("h3 a").attr("href");
        String strAttr = post.select("img").attr("data-lazy-src");
        if (StringsKt.isBlank(strAttr)) {
            strAttr = post.select("img").attr("src");
        }
        final String poster = strAttr;
        final Score score = Score.Companion.from10(post.select("div.rating").text());
        return MainAPIKt.newMovieSearchResponse$default(this, title, url, TvType.Movie, false, new Function1() { // from class: com.zinkmovies.Zinkmovies$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                return Zinkmovies.toResult$lambda$1(poster, score, this, post, (MovieSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toResult$lambda$1(String $poster, Score $score, Zinkmovies this$0, Element $post, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl(StringsKt.replace$default($poster, "/w185/", "/w500/", false, 4, (Object) null));
        $this$newMovieSearchResponse.setPosterHeaders(INSTANCE.getCfHeaders());
        $this$newMovieSearchResponse.setScore($score);
        $this$newMovieSearchResponse.setQuality(this$0.getSearchQuality($post.select("span.quality").text()));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object search(@NotNull String query, int page, @NotNull Continuation<? super SearchResponseList> continuation) {
        C00191 c00191;
        Object objAppGet$default;
        int page2 = page;
        if (continuation instanceof C00191) {
            c00191 = (C00191) continuation;
            if ((c00191.label & Integer.MIN_VALUE) != 0) {
                c00191.label -= Integer.MIN_VALUE;
            } else {
                c00191 = new C00191(continuation);
            }
        } else {
            c00191 = new C00191(continuation);
        }
        C00191 c00192 = c00191;
        Object $result = c00192.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00192.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Companion companion = INSTANCE;
                String str = getMainUrl() + "/page/" + page2 + "/?s=" + query;
                Map<String, String> map = this.headers;
                c00192.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00192.I$0 = page2;
                c00192.label = 1;
                objAppGet$default = Companion.appGet$default(companion, str, map, 0, false, c00192, 12, null);
                if (objAppGet$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                page2 = c00192.I$0;
                ResultKt.throwOnFailure($result);
                objAppGet$default = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Iterable $this$map$iv = ((NiceResponse) objAppGet$default).getDocument().select("article");
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Element it = (Element) item$iv$iv;
            String name = it.select("a").text();
            String href = it.select("a").attr("href");
            int page3 = page2;
            String strAttr = it.select("img").attr("data-lazy-src");
            if (StringsKt.isBlank(strAttr)) {
                strAttr = it.select("img").attr("src");
            }
            final String poster = strAttr;
            destination$iv$iv.add(MainAPIKt.newMovieSearchResponse$default(this, name, href, TvType.Movie, false, new Function1() { // from class: com.zinkmovies.Zinkmovies$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    return Zinkmovies.search$lambda$0$1(poster, (MovieSearchResponse) obj);
                }
            }, 8, (Object) null));
            page2 = page3;
        }
        return MainAPIKt.toNewSearchResponseList$default((List) destination$iv$iv, (Boolean) null, 1, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit search$lambda$0$1(String $poster, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl(StringsKt.replace$default($poster, "/w92/", "/w500/", false, 4, (Object) null));
        $this$newMovieSearchResponse.setPosterHeaders(INSTANCE.getCfHeaders());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:1084:0x1268 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:380:0x1210 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:381:0x1211  */
    /* JADX WARN: Code duplicated, block: B:384:0x1247  */
    /* JADX WARN: Code duplicated, block: B:389:0x1258 A[Catch: all -> 0x13df, Exception -> 0x140a, TRY_LEAVE, TryCatch #107 {Exception -> 0x140a, all -> 0x13df, blocks: (B:387:0x1250, B:389:0x1258), top: B:1098:0x1250 }] */
    /* JADX WARN: Code duplicated, block: B:394:0x126e  */
    /* JADX WARN: Code duplicated, block: B:395:0x127c A[Catch: all -> 0x1322, Exception -> 0x134b, TryCatch #114 {Exception -> 0x134b, all -> 0x1322, blocks: (B:392:0x1268, B:395:0x127c, B:400:0x12b9), top: B:1084:0x1268 }] */
    /* JADX WARN: Code duplicated, block: B:397:0x12b3  */
    /* JADX WARN: Code duplicated, block: B:398:0x12b4  */
    /* JADX WARN: Code duplicated, block: B:400:0x12b9 A[Catch: all -> 0x1322, Exception -> 0x134b, TRY_LEAVE, TryCatch #114 {Exception -> 0x134b, all -> 0x1322, blocks: (B:392:0x1268, B:395:0x127c, B:400:0x12b9), top: B:1084:0x1268 }] */
    /* JADX WARN: Code duplicated, block: B:403:0x12d5  */
    /* JADX WARN: Code duplicated, block: B:416:0x13d3  */
    /* JADX WARN: Code duplicated, block: B:425:0x1489  */
    /* JADX WARN: Code duplicated, block: B:427:0x1497  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Failed to apply debug info
    jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 118861. Try increasing type updates limit count.
    	at jadx.core.dex.visitors.typeinference.TypeUpdateInfo.requestUpdate(TypeUpdateInfo.java:61)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:298)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyDebugInfo(TypeUpdate.java:77)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:137)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:133)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.searchAndApplyVarDebugInfo(DebugInfoApplyVisitor.java:75)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.lambda$applyDebugInfo$0(DebugInfoApplyVisitor.java:68)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:68)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.visit(DebugInfoApplyVisitor.java:55)
     */
    /* JADX WARN: Multi-variable search skipped. Vars limit reached: 5408 (expected less than 5000) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:381:0x1211 -> B:1100:0x1236). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:615:0x1fe3 -> B:616:0x2027). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:666:0x212a -> B:988:0x2156). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:719:0x22d3 -> B:744:0x25be). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:721:0x2308 -> B:744:0x25be). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:723:0x233f -> B:744:0x25be). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:725:0x2376 -> B:744:0x25be). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:727:0x23af -> B:744:0x25be). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:729:0x23ea -> B:744:0x25be). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:731:0x2425 -> B:744:0x25be). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:733:0x2460 -> B:744:0x25be). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:735:0x249b -> B:744:0x25be). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:737:0x24d6 -> B:744:0x25be). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:739:0x2511 -> B:744:0x25be). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:741:0x254c -> B:744:0x25be). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:743:0x2586 -> B:744:0x25be). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:755:0x267d -> B:756:0x2687). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:795:0x2820 -> B:979:0x284c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:855:0x29f4 -> B:871:0x2bdf). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:857:0x2a32 -> B:871:0x2bdf). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:864:0x2ac3 -> B:871:0x2bdf). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:866:0x2b0b -> B:871:0x2bdf). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:868:0x2b53 -> B:871:0x2bdf). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:870:0x2b9a -> B:871:0x2bdf). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object load(@org.jetbrains.annotations.NotNull java.lang.String r104, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r105) {
        /*
            Method dump skipped, instruction units count: 11886
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zinkmovies.Zinkmovies.load(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$1$1(String $poster, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($poster);
        $this$newMovieSearchResponse.setPosterHeaders(INSTANCE.getCfHeaders());
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.zinkmovies.Zinkmovies$load$5 */
    /* JADX INFO: compiled from: Zinkmovies.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.zinkmovies.Zinkmovies$load$5", f = "Zinkmovies.kt", i = {0}, l = {484}, m = "invokeSuspend", n = {"$this$newMovieLoadResponse"}, nl = {485}, s = {"L$0"}, v = 2)
    static final class C00165 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<List<ActorData>> $actorData;
        final /* synthetic */ Ref.ObjectRef<String> $background;
        final /* synthetic */ Ref.ObjectRef<String> $description;
        final /* synthetic */ Ref.ObjectRef<List<String>> $genre;
        final /* synthetic */ String $plot;
        final /* synthetic */ String $poster;
        final /* synthetic */ List<MovieSearchResponse> $recommendations;
        final /* synthetic */ ResponseDataLocal $responseData;
        final /* synthetic */ List<String> $tags;
        final /* synthetic */ String $trailer;
        final /* synthetic */ Ref.ObjectRef<String> $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00165(Ref.ObjectRef<String> objectRef, List<MovieSearchResponse> list, ResponseDataLocal responseDataLocal, String str, Ref.ObjectRef<String> objectRef2, Ref.ObjectRef<String> objectRef3, String str2, Ref.ObjectRef<List<String>> objectRef4, List<String> list2, Ref.ObjectRef<List<ActorData>> objectRef5, String str3, Continuation<? super C00165> continuation) {
            super(2, continuation);
            this.$background = objectRef;
            this.$recommendations = list;
            this.$responseData = responseDataLocal;
            this.$poster = str;
            this.$year = objectRef2;
            this.$description = objectRef3;
            this.$plot = str2;
            this.$genre = objectRef4;
            this.$tags = list2;
            this.$actorData = objectRef5;
            this.$trailer = str3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00165 = new C00165(this.$background, this.$recommendations, this.$responseData, this.$poster, this.$year, this.$description, this.$plot, this.$genre, this.$tags, this.$actorData, this.$trailer, continuation);
            c00165.L$0 = obj;
            return c00165;
        }

        public final Object invoke(MovieLoadResponse movieLoadResponse, Continuation<? super Unit> continuation) {
            return create(movieLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            MetaLocal meta;
            MetaLocal meta2;
            MetaLocal meta3;
            LoadResponse loadResponse = (MovieLoadResponse) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            String imdbId = null;
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    loadResponse.setBackgroundPosterUrl((String) this.$background.element);
                    loadResponse.setRecommendations(this.$recommendations);
                    ResponseDataLocal responseDataLocal = this.$responseData;
                    loadResponse.setLogoUrl((responseDataLocal == null || (meta2 = responseDataLocal.getMeta()) == null) ? null : meta2.getLogo());
                    loadResponse.setPosterUrl(this.$poster);
                    loadResponse.setPosterHeaders(Zinkmovies.INSTANCE.getCfHeaders());
                    loadResponse.setYear(StringsKt.toIntOrNull((String) this.$year.element));
                    String str = (String) this.$description.element;
                    if (str == null) {
                        str = this.$plot;
                    }
                    loadResponse.setPlot(str);
                    List<String> list = (List) this.$genre.element;
                    if (list == null) {
                        list = this.$tags;
                    }
                    loadResponse.setTags(list);
                    loadResponse.setActors((List) this.$actorData.element);
                    ResponseDataLocal responseDataLocal2 = this.$responseData;
                    loadResponse.setScore((responseDataLocal2 == null || (meta = responseDataLocal2.getMeta()) == null) ? null : meta.getRating());
                    this.L$0 = loadResponse;
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
            LoadResponse.Companion companion = LoadResponse.Companion;
            LoadResponse loadResponse2 = loadResponse;
            ResponseDataLocal responseDataLocal3 = this.$responseData;
            if (responseDataLocal3 != null && (meta3 = responseDataLocal3.getMeta()) != null) {
                imdbId = meta3.getImdbId();
            }
            companion.addImdbId(loadResponse2, imdbId);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$11$1(VideoLocal $info, int $epNum, int $seasonNum, Episode $this$newEpisode) {
        String title;
        if ($info == null || (title = $info.getTitle()) == null) {
            title = "Episode " + $epNum;
        }
        $this$newEpisode.setName(title);
        $this$newEpisode.setSeason(Integer.valueOf($seasonNum));
        $this$newEpisode.setEpisode(Integer.valueOf($epNum));
        $this$newEpisode.setPosterUrl($info != null ? $info.getThumbnail() : null);
        $this$newEpisode.setDescription($info != null ? $info.getOverview() : null);
        $this$newEpisode.setScore($info != null ? $info.getRating() : null);
        MainAPIKt.addDate$default($this$newEpisode, $info != null ? $info.getReleased() : null, (String) null, 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.zinkmovies.Zinkmovies$load$12 */
    /* JADX INFO: compiled from: Zinkmovies.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.zinkmovies.Zinkmovies$load$12", f = "Zinkmovies.kt", i = {0}, l = {624}, m = "invokeSuspend", n = {"$this$newTvSeriesLoadResponse"}, nl = {625}, s = {"L$0"}, v = 2)
    static final class C001512 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<List<ActorData>> $actorData;
        final /* synthetic */ Ref.ObjectRef<String> $background;
        final /* synthetic */ Ref.ObjectRef<String> $description;
        final /* synthetic */ Ref.ObjectRef<List<String>> $genre;
        final /* synthetic */ String $plot;
        final /* synthetic */ String $poster;
        final /* synthetic */ List<MovieSearchResponse> $recommendations;
        final /* synthetic */ ResponseDataLocal $responseData;
        final /* synthetic */ List<String> $tags;
        final /* synthetic */ String $trailer;
        final /* synthetic */ Ref.ObjectRef<String> $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C001512(Ref.ObjectRef<String> objectRef, List<MovieSearchResponse> list, ResponseDataLocal responseDataLocal, String str, Ref.ObjectRef<String> objectRef2, Ref.ObjectRef<String> objectRef3, String str2, Ref.ObjectRef<List<String>> objectRef4, List<String> list2, Ref.ObjectRef<List<ActorData>> objectRef5, String str3, Continuation<? super C001512> continuation) {
            super(2, continuation);
            this.$background = objectRef;
            this.$recommendations = list;
            this.$responseData = responseDataLocal;
            this.$poster = str;
            this.$year = objectRef2;
            this.$description = objectRef3;
            this.$plot = str2;
            this.$genre = objectRef4;
            this.$tags = list2;
            this.$actorData = objectRef5;
            this.$trailer = str3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c001512 = new C001512(this.$background, this.$recommendations, this.$responseData, this.$poster, this.$year, this.$description, this.$plot, this.$genre, this.$tags, this.$actorData, this.$trailer, continuation);
            c001512.L$0 = obj;
            return c001512;
        }

        public final Object invoke(TvSeriesLoadResponse tvSeriesLoadResponse, Continuation<? super Unit> continuation) {
            return create(tvSeriesLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            MetaLocal meta;
            MetaLocal meta2;
            MetaLocal meta3;
            LoadResponse loadResponse = (TvSeriesLoadResponse) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            String imdbId = null;
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    loadResponse.setBackgroundPosterUrl((String) this.$background.element);
                    loadResponse.setRecommendations(this.$recommendations);
                    ResponseDataLocal responseDataLocal = this.$responseData;
                    loadResponse.setLogoUrl((responseDataLocal == null || (meta2 = responseDataLocal.getMeta()) == null) ? null : meta2.getLogo());
                    loadResponse.setPosterUrl(this.$poster);
                    loadResponse.setPosterHeaders(Zinkmovies.INSTANCE.getCfHeaders());
                    loadResponse.setYear(StringsKt.toIntOrNull((String) this.$year.element));
                    String str = (String) this.$description.element;
                    if (str == null) {
                        str = this.$plot;
                    }
                    loadResponse.setPlot(str);
                    List<String> list = (List) this.$genre.element;
                    if (list == null) {
                        list = this.$tags;
                    }
                    loadResponse.setTags(list);
                    loadResponse.setActors((List) this.$actorData.element);
                    ResponseDataLocal responseDataLocal2 = this.$responseData;
                    loadResponse.setScore((responseDataLocal2 == null || (meta = responseDataLocal2.getMeta()) == null) ? null : meta.getRating());
                    this.L$0 = loadResponse;
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
            LoadResponse.Companion companion = LoadResponse.Companion;
            LoadResponse loadResponse2 = loadResponse;
            ResponseDataLocal responseDataLocal3 = this.$responseData;
            if (responseDataLocal3 != null && (meta3 = responseDataLocal3.getMeta()) != null) {
                imdbId = meta3.getImdbId();
            }
            companion.addImdbId(loadResponse2, imdbId);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00171 c00171;
        Object obj;
        Object obj2;
        Object objDecodeFromString;
        List linksList;
        boolean z;
        if (continuation instanceof C00171) {
            c00171 = (C00171) continuation;
            if ((c00171.label & Integer.MIN_VALUE) != 0) {
                c00171.label -= Integer.MIN_VALUE;
            } else {
                c00171 = new C00171(continuation);
            }
        } else {
            c00171 = new C00171(continuation);
        }
        C00171 c00172 = c00171;
        Object $result = c00172.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00172.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                AppUtils appUtils = AppUtils.INSTANCE;
                if (data == null) {
                    obj2 = null;
                } else {
                    try {
                        try {
                            Result.Companion companion = Result.Companion;
                            KType kTypeTypeOf = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(String.class)));
                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                            obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        if (Result.exceptionOrNull-impl(obj) != null) {
                            try {
                                Result.Companion companion3 = Result.Companion;
                                obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                            } catch (Throwable th2) {
                                Result.Companion companion4 = Result.Companion;
                                obj = Result.constructor-impl(ResultKt.createFailure(th2));
                            }
                        }
                        DeserializationStrategy deserializationStrategy = (KSerializer) (Result.isFailure-impl(obj) ? null : obj);
                        if (deserializationStrategy != null) {
                            try {
                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, data);
                            } catch (SerializationException e) {
                                ArchComponentExtKt.logError(e);
                                ObjectMapper $this$readValue$iv$iv$iv = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv$iv.readValue(data, new TypeReference<List<? extends String>>() { // from class: com.zinkmovies.Zinkmovies$loadLinks$$inlined$tryParseJson$1
                                });
                            } catch (Throwable th3) {
                                ObjectMapper $this$readValue$iv$iv$iv2 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv$iv2.readValue(data, new TypeReference<List<? extends String>>() { // from class: com.zinkmovies.Zinkmovies$loadLinks$$inlined$tryParseJson$1
                                });
                            }
                        } else {
                            ObjectMapper $this$readValue$iv$iv$iv3 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv$iv3.readValue(data, new TypeReference<List<? extends String>>() { // from class: com.zinkmovies.Zinkmovies$loadLinks$$inlined$tryParseJson$1
                            });
                        }
                        obj2 = objDecodeFromString;
                    } catch (Exception e2) {
                        obj2 = null;
                    }
                }
                Iterable iterable = (List) obj2;
                if (iterable != null) {
                    Iterable $this$map$iv = iterable;
                    Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    for (Object item$iv$iv : $this$map$iv) {
                        String p0 = (String) item$iv$iv;
                        destination$iv$iv.add(StringsKt.trim(p0).toString());
                    }
                    Iterable $this$filter$iv = (List) destination$iv$iv;
                    Collection destination$iv$iv2 = new ArrayList();
                    for (Object element$iv$iv : $this$filter$iv) {
                        String p1 = (String) element$iv$iv;
                        if (p1.length() > 0) {
                            destination$iv$iv2.add(element$iv$iv);
                        }
                    }
                    linksList = (List) destination$iv$iv2;
                } else {
                    linksList = null;
                }
                if (linksList == null) {
                    linksList = CollectionsKt.emptyList();
                }
                if (linksList.isEmpty()) {
                    return Boxing.boxBoolean(false);
                }
                C00182 c00182 = new C00182(function2, this, function1, null);
                c00172.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00172.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                c00172.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                c00172.L$3 = SpillingKt.nullOutSpilledVariable(linksList);
                c00172.Z$0 = isCasting;
                z = true;
                c00172.label = 1;
                if (ParCollectionsKt.amap(linksList, c00182, c00172) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                boolean z2 = c00172.Z$0;
                ResultKt.throwOnFailure($result);
                z = true;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Boxing.boxBoolean(z);
    }

    /* JADX INFO: renamed from: com.zinkmovies.Zinkmovies$loadLinks$2 */
    /* JADX INFO: compiled from: Zinkmovies.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "pageUrl", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.zinkmovies.Zinkmovies$loadLinks$2", f = "Zinkmovies.kt", i = {0, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3}, l = {645, 646, 649, 659}, m = "invokeSuspend", n = {"pageUrl", "pageUrl", "finalUrl", "pageUrl", "finalUrl", "$this$forEach$iv", "element$iv", "link", "pageUrl", "finalUrl", "$this$forEach$iv", "element$iv", "link"}, nl = {646, 719, 648, 666}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$7", "L$8", "L$0", "L$1", "L$2", "L$7", "L$8"}, v = 2)
    @SourceDebugExtension({"SMAP\nZinkmovies.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zinkmovies.kt\ncom/zinkmovies/Zinkmovies$loadLinks$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,718:1\n2068#2,2:719\n*S KotlinDebug\n*F\n+ 1 Zinkmovies.kt\ncom/zinkmovies/Zinkmovies$loadLinks$2\n*L\n646#1:719,2\n*E\n"})
    static final class C00182 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        final /* synthetic */ Zinkmovies this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00182(Function1<? super ExtractorLink, Unit> function1, Zinkmovies zinkmovies, Function1<? super SubtitleFile, Unit> function2, Continuation<? super C00182> continuation) {
            super(2, continuation);
            this.$callback = function1;
            this.this$0 = zinkmovies;
            this.$subtitleCallback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00182 = new C00182(this.$callback, this.this$0, this.$subtitleCallback, continuation);
            c00182.L$0 = obj;
            return c00182;
        }

        public final Object invoke(String str, Continuation<? super Unit> continuation) {
            return create(str, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:19:0x00db  */
        /* JADX WARN: Code duplicated, block: B:21:0x00fa  */
        /* JADX WARN: Code duplicated, block: B:23:0x0146 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:24:0x0147  */
        /* JADX WARN: Code duplicated, block: B:26:0x015e  */
        /* JADX WARN: Code duplicated, block: B:28:0x019b A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:29:0x019c  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x019c -> B:30:0x01a2). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        public final java.lang.Object invokeSuspend(java.lang.Object r25) {
            /*
                Method dump skipped, instruction units count: 444
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.zinkmovies.Zinkmovies.C00182.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Nullable
    public final SearchQuality getSearchQuality(@Nullable String check) {
        if (check == null) {
            return null;
        }
        String u = Normalizer.normalize(check, Normalizer.Form.NFKC).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(u, "toLowerCase(...)");
        List<Pair> patterns = CollectionsKt.listOf(new Pair[]{TuplesKt.to(new Regex("\\b(hdts|hdcam|hdtc)\\b", RegexOption.IGNORE_CASE), SearchQuality.HdCam), TuplesKt.to(new Regex("\\b(camrip|cam[- ]?rip)\\b", RegexOption.IGNORE_CASE), SearchQuality.CamRip), TuplesKt.to(new Regex("\\bcam\\b", RegexOption.IGNORE_CASE), SearchQuality.Cam), TuplesKt.to(new Regex("\\b(web[- ]?dl|webrip|webdl)\\b", RegexOption.IGNORE_CASE), SearchQuality.WebRip), TuplesKt.to(new Regex("\\b(bluray|blu[- ]?ray|bdrip)\\b", RegexOption.IGNORE_CASE), SearchQuality.BlueRay), TuplesKt.to(new Regex("\\b(4k|2160p|uhd|ds4k)\\b", RegexOption.IGNORE_CASE), SearchQuality.FourK), TuplesKt.to(new Regex("\\b(1440p|qhd)\\b", RegexOption.IGNORE_CASE), SearchQuality.HD), TuplesKt.to(new Regex("\\b(1080p|fullhd)\\b", RegexOption.IGNORE_CASE), SearchQuality.HD), TuplesKt.to(new Regex("\\b720p\\b", RegexOption.IGNORE_CASE), SearchQuality.SD), TuplesKt.to(new Regex("\\b(hdrip|hdtv)\\b", RegexOption.IGNORE_CASE), SearchQuality.HD), TuplesKt.to(new Regex("\\bdvd\\b", RegexOption.IGNORE_CASE), SearchQuality.DVD), TuplesKt.to(new Regex("\\bhq\\b", RegexOption.IGNORE_CASE), SearchQuality.HQ), TuplesKt.to(new Regex("\\brip\\b", RegexOption.IGNORE_CASE), SearchQuality.CamRip)});
        for (Pair pair : patterns) {
            Regex regex = (Regex) pair.component1();
            SearchQuality quality = (SearchQuality) pair.component2();
            SearchQuality searchQuality = regex.containsMatchIn(u) ? quality : null;
            if (searchQuality != null) {
                return searchQuality;
            }
        }
        return null;
    }
}
