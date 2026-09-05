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
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collection;
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
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Zinkmovies.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Zinkmovies/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 C2\u00020\u0001:\u0001CB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010 \u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0096@¢\u0006\u0002\u0010)J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0002J\u001e\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&H\u0096@¢\u0006\u0002\u00101J\u0016\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u00105JF\u00106\u001a\u00020\u00112\u0006\u00107\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u00112\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020<0:2\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020<0:H\u0096@¢\u0006\u0002\u0010?J\u0012\u0010@\u001a\u0004\u0018\u00010A2\b\u0010B\u001a\u0004\u0018\u00010\u0005R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0011X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u0011X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001a\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050#X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/zinkmovies/Zinkmovies;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "lang", "getLang", "setLang", "hasMainPage", "", "getHasMainPage", "()Z", "hasDownloadSupport", "getHasDownloadSupport", "hasQuickSearch", "getHasQuickSearch", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "headers", "", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "post", "Lorg/jsoup/nodes/Element;", "search", "Lcom/lagradost/cloudstream3/SearchResponseList;", "query", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSearchQuality", "Lcom/lagradost/cloudstream3/SearchQuality;", "check", "Companion", "Zinkmovies"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nZinkmovies.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zinkmovies.kt\ncom/zinkmovies/Zinkmovies\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 5 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 6 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 7 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,568:1\n832#2:569\n862#2,2:570\n1795#2,10:572\n2068#2:582\n2069#2:584\n1805#2:585\n1739#2:587\n1814#2,3:588\n1739#2:591\n1814#2,3:592\n1739#2:595\n1814#2,3:596\n777#2:599\n873#2,2:600\n2068#2:602\n2068#2:603\n2069#2:611\n2069#2:612\n1739#2:613\n1814#2,3:614\n777#2:617\n873#2,2:618\n2068#2:620\n2068#2:621\n2069#2:629\n2069#2:630\n1739#2:656\n1814#2,3:657\n777#2:660\n873#2,2:661\n1#3:583\n1#3:586\n1#3:636\n1#3:663\n460#4,7:604\n460#4,7:622\n221#5,2:631\n93#6,2:633\n63#6:635\n64#6,15:637\n95#6,2:654\n50#7:652\n43#7:653\n*S KotlinDebug\n*F\n+ 1 Zinkmovies.kt\ncom/zinkmovies/Zinkmovies\n*L\n82#1:569\n82#1:570,2\n83#1:572,10\n83#1:582\n83#1:584\n83#1:585\n104#1:587\n104#1:588,3\n134#1:591\n134#1:592,3\n322#1:595\n322#1:596,3\n346#1:599\n346#1:600,2\n347#1:602\n376#1:603\n376#1:611\n347#1:612\n415#1:613\n415#1:614,3\n416#1:617\n416#1:618,2\n418#1:620\n421#1:621\n421#1:629\n418#1:630\n488#1:656\n488#1:657,3\n489#1:660\n489#1:661,2\n83#1:583\n487#1:636\n395#1:604,7\n431#1:622,7\n441#1:631,2\n487#1:633,2\n487#1:635\n487#1:637,15\n487#1:654,2\n487#1:652\n487#1:653\n*E\n"})
public final class Zinkmovies extends MainAPI {

    @NotNull
    public static final String TMDBAPI = "https://api.themoviedb.org/3";

    @NotNull
    public static final String TMDBAPIKEY = "1865f43a0549ca50d341dd9ab8b29f49";

    @NotNull
    public static final String TMDBBASE = "https://image.tmdb.org/t/p/original";
    private final boolean hasQuickSearch;

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
    @DebugMetadata(c = "com.zinkmovies.Zinkmovies", f = "Zinkmovies.kt", i = {0, 0}, l = {76}, m = "getMainPage", n = {"request", "page"}, nl = {81}, s = {"L$0", "I$0"}, v = 2)
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
            return Zinkmovies.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.zinkmovies.Zinkmovies$load$1 */
    /* JADX INFO: compiled from: Zinkmovies.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.zinkmovies.Zinkmovies", f = "Zinkmovies.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7}, l = {116, 162, 174, 239, 325, 374, 420, 463}, m = "load", n = {"url", "url", "doc", "title", "seasontitle", "seasonNumber", "image", "plot", "tags", "poster", "trailer", "tvtype", "recommendations", "actorData", "genre", "year", "background", "description", "tmdbIdResolved", "$this$load_u24lambda_u242", "query", "type", "searchUrl", "url", "doc", "title", "seasontitle", "seasonNumber", "image", "plot", "tags", "poster", "trailer", "tvtype", "recommendations", "actorData", "genre", "year", "background", "description", "tmdbIdResolved", "$this$load_u24lambda_u243", "type", "url", "doc", "title", "seasontitle", "seasonNumber", "image", "plot", "tags", "poster", "trailer", "tvtype", "recommendations", "actorData", "genre", "year", "background", "description", "tmdbIdResolved", "$this$load_u24lambda_u243", "type", "detailsText", "detailsJson", "yearRaw", "metaYear", "metaRating", "metaDesc", "metaBackground", "metaName", "imdbId", "logoPath", "actorDataList", "metaGenres", "videos", "totalSeasons", "season", "url", "doc", "title", "seasontitle", "seasonNumber", "image", "plot", "tags", "poster", "trailer", "tvtype", "recommendations", "actorData", "genre", "year", "background", "description", "tmdbIdResolved", "responseData", "movieList", "url", "doc", "title", "seasontitle", "seasonNumber", "image", "plot", "tags", "poster", "trailer", "tvtype", "recommendations", "actorData", "genre", "year", "background", "description", "tmdbIdResolved", "responseData", "episodesData", "epLinksMap", "seasonRegex", "episodeRegex", "$this$forEach$iv", "element$iv", "seasonElement", "next", "seasonUrl", "seasonNum", "url", "doc", "title", "seasontitle", "seasonNumber", "image", "plot", "tags", "poster", "trailer", "tvtype", "recommendations", "actorData", "genre", "year", "background", "description", "tmdbIdResolved", "responseData", "episodesData", "epLinksMap", "seasonRegex", "episodeRegex", "$this$forEach$iv", "element$iv", "linkUrl", "fallbackSeason", "url", "doc", "title", "seasontitle", "seasonNumber", "image", "plot", "tags", "poster", "trailer", "tvtype", "recommendations", "actorData", "genre", "year", "background", "description", "tmdbIdResolved", "responseData", "episodesData", "epLinksMap", "seasonRegex", "episodeRegex"}, nl = {117, 164, 176, 241, 339, 376, 421, -1}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$28", "L$29", "L$30", "L$31", "L$32", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$25", "L$26", "L$27", "L$28", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$25", "L$26", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22"}, v = 2)
    static final class C00091 extends ContinuationImpl {
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

        C00091(Continuation<? super C00091> continuation) {
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
    @DebugMetadata(c = "com.zinkmovies.Zinkmovies", f = "Zinkmovies.kt", i = {0, 0, 0, 0, 0}, l = {494}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "linksList", "isCasting"}, nl = {519}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0"}, v = 2)
    static final class C00121 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
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
            return Zinkmovies.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.zinkmovies.Zinkmovies$search$1 */
    /* JADX INFO: compiled from: Zinkmovies.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.zinkmovies.Zinkmovies", f = "Zinkmovies.kt", i = {0, 0}, l = {102}, m = "search", n = {"query", "page"}, nl = {104}, s = {"L$0", "I$0"}, v = 2)
    static final class C00141 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00141(Continuation<? super C00141> continuation) {
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

    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        C00081 c00081;
        boolean z;
        MainPageRequest request2;
        int page2 = page;
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
                Requests app = MainActivityKt.getApp();
                String str = getMainUrl() + '/' + request.getData() + "page/" + page2 + '/';
                Map<String, String> map = this.headers;
                c00081.L$0 = request;
                c00081.I$0 = page2;
                c00081.label = 1;
                z = true;
                $result = Requests.get$default(app, str, map, (String) null, (Map) null, (Map) null, true, 60, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00081, 3996, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                request2 = request;
                break;
                break;
            case 1:
                page2 = c00081.I$0;
                request2 = (MainPageRequest) c00081.L$0;
                ResultKt.throwOnFailure($result);
                z = true;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document doc = ((NiceResponse) $result).getDocument();
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
        return MainAPIKt.newHomePageResponse(request2.getName(), home, Boxing.boxBoolean(z));
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
        $this$newMovieSearchResponse.setScore($score);
        $this$newMovieSearchResponse.setQuality(this$0.getSearchQuality($post.select("span.quality").text()));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object search(@NotNull String query, int page, @NotNull Continuation<? super SearchResponseList> continuation) {
        C00141 c00141;
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
        Object $result = c00141.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00141.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                String str = getMainUrl() + "/page/" + page + "/?s=" + query;
                c00141.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00141.I$0 = page;
                c00141.label = 1;
                $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00141, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                int i = c00141.I$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Iterable $this$map$iv = ((NiceResponse) $result).getDocument().select("article");
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Element it = (Element) item$iv$iv;
            String name = it.select("a").text();
            String href = it.select("a").attr("href");
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
        }
        return MainAPIKt.toNewSearchResponseList$default((List) destination$iv$iv, (Boolean) null, 1, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit search$lambda$0$1(String $poster, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl(StringsKt.replace$default($poster, "/w92/", "/w500/", false, 4, (Object) null));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:1099:0x1308 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:393:0x12ae A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:394:0x12af  */
    /* JADX WARN: Code duplicated, block: B:397:0x12e7  */
    /* JADX WARN: Code duplicated, block: B:400:0x12f8 A[Catch: all -> 0x1487, Exception -> 0x14b6, TRY_LEAVE, TryCatch #109 {Exception -> 0x14b6, all -> 0x1487, blocks: (B:398:0x12e9, B:400:0x12f8), top: B:1107:0x12e9 }] */
    /* JADX WARN: Code duplicated, block: B:405:0x130e  */
    /* JADX WARN: Code duplicated, block: B:406:0x131a A[Catch: all -> 0x13be, Exception -> 0x13eb, TryCatch #113 {Exception -> 0x13eb, all -> 0x13be, blocks: (B:403:0x1308, B:406:0x131a, B:411:0x1357), top: B:1099:0x1308 }] */
    /* JADX WARN: Code duplicated, block: B:408:0x1351  */
    /* JADX WARN: Code duplicated, block: B:409:0x1352  */
    /* JADX WARN: Code duplicated, block: B:411:0x1357 A[Catch: all -> 0x13be, Exception -> 0x13eb, TRY_LEAVE, TryCatch #113 {Exception -> 0x13eb, all -> 0x13be, blocks: (B:403:0x1308, B:406:0x131a, B:411:0x1357), top: B:1099:0x1308 }] */
    /* JADX WARN: Code duplicated, block: B:414:0x1373  */
    /* JADX WARN: Code duplicated, block: B:427:0x147d  */
    /* JADX WARN: Code duplicated, block: B:432:0x14e5  */
    /* JADX WARN: Code duplicated, block: B:434:0x14f1  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Failed to apply debug info
    jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 121061. Try increasing type updates limit count.
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
    /* JADX WARN: Multi-variable search skipped. Vars limit reached: 5533 (expected less than 5000) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r29v10 */
    /* JADX WARN: Type inference failed for: r29v102, names: [actorData], types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r29v107 */
    /* JADX WARN: Type inference failed for: r29v108 */
    /* JADX WARN: Type inference failed for: r29v109 */
    /* JADX WARN: Type inference failed for: r29v110 */
    /* JADX WARN: Type inference failed for: r29v111 */
    /* JADX WARN: Type inference failed for: r29v112 */
    /* JADX WARN: Type inference failed for: r29v113 */
    /* JADX WARN: Type inference failed for: r29v114 */
    /* JADX WARN: Type inference failed for: r29v115 */
    /* JADX WARN: Type inference failed for: r29v116 */
    /* JADX WARN: Type inference failed for: r29v117 */
    /* JADX WARN: Type inference failed for: r29v118 */
    /* JADX WARN: Type inference failed for: r29v119 */
    /* JADX WARN: Type inference failed for: r29v12, names: [recommendations], types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r29v120 */
    /* JADX WARN: Type inference failed for: r29v121 */
    /* JADX WARN: Type inference failed for: r29v122 */
    /* JADX WARN: Type inference failed for: r29v123 */
    /* JADX WARN: Type inference failed for: r29v124 */
    /* JADX WARN: Type inference failed for: r29v125 */
    /* JADX WARN: Type inference failed for: r29v126 */
    /* JADX WARN: Type inference failed for: r29v127 */
    /* JADX WARN: Type inference failed for: r29v128 */
    /* JADX WARN: Type inference failed for: r29v129 */
    /* JADX WARN: Type inference failed for: r29v130 */
    /* JADX WARN: Type inference failed for: r29v131 */
    /* JADX WARN: Type inference failed for: r29v132 */
    /* JADX WARN: Type inference failed for: r29v133 */
    /* JADX WARN: Type inference failed for: r29v134 */
    /* JADX WARN: Type inference failed for: r29v135 */
    /* JADX WARN: Type inference failed for: r29v14 */
    /* JADX WARN: Type inference failed for: r29v17, names: [seasonNumber], types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r29v20, names: [tvtype], types: [com.lagradost.cloudstream3.TvType] */
    /* JADX WARN: Type inference failed for: r29v21, names: [tvtype], types: [com.lagradost.cloudstream3.TvType] */
    /* JADX WARN: Type inference failed for: r29v22 */
    /* JADX WARN: Type inference failed for: r29v24 */
    /* JADX WARN: Type inference failed for: r29v26 */
    /* JADX WARN: Type inference failed for: r29v28 */
    /* JADX WARN: Type inference failed for: r29v30 */
    /* JADX WARN: Type inference failed for: r29v32 */
    /* JADX WARN: Type inference failed for: r29v34 */
    /* JADX WARN: Type inference failed for: r29v38 */
    /* JADX WARN: Type inference failed for: r29v39 */
    /* JADX WARN: Type inference failed for: r29v40, names: [seasonNumber], types: [java.lang.Integer, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r29v41 */
    /* JADX WARN: Type inference failed for: r29v42 */
    /* JADX WARN: Type inference failed for: r29v44, names: [metaYear], types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r29v45 */
    /* JADX WARN: Type inference failed for: r29v47 */
    /* JADX WARN: Type inference failed for: r29v48 */
    /* JADX WARN: Type inference failed for: r29v51 */
    /* JADX WARN: Type inference failed for: r29v56 */
    /* JADX WARN: Type inference failed for: r29v60 */
    /* JADX WARN: Type inference failed for: r29v62, names: [seasonNumber], types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r29v64 */
    /* JADX WARN: Type inference failed for: r29v66 */
    /* JADX WARN: Type inference failed for: r29v8 */
    /* JADX WARN: Type inference failed for: r29v9 */
    /* JADX WARN: Type inference failed for: r29v90, names: [seasonNumber], types: [java.lang.Integer, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r29v91, names: [seasonNumber], types: [java.lang.Integer, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v179, names: [title], types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r37v100 */
    /* JADX WARN: Type inference failed for: r37v101 */
    /* JADX WARN: Type inference failed for: r37v102 */
    /* JADX WARN: Type inference failed for: r37v104 */
    /* JADX WARN: Type inference failed for: r37v105 */
    /* JADX WARN: Type inference failed for: r37v106, names: [seasonNumber], types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r37v107 */
    /* JADX WARN: Type inference failed for: r37v108 */
    /* JADX WARN: Type inference failed for: r37v110, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r37v111 */
    /* JADX WARN: Type inference failed for: r37v112 */
    /* JADX WARN: Type inference failed for: r37v113 */
    /* JADX WARN: Type inference failed for: r37v96 */
    /* JADX WARN: Type inference failed for: r37v97 */
    /* JADX WARN: Type inference failed for: r37v98 */
    /* JADX WARN: Type inference failed for: r37v99 */
    /* JADX WARN: Type inference failed for: r3v141 */
    /* JADX WARN: Type inference failed for: r3v143, names: [seasonNumber], types: [java.lang.Integer, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v159 */
    /* JADX WARN: Type inference failed for: r3v165 */
    /* JADX WARN: Type inference failed for: r3v169 */
    /* JADX WARN: Type inference failed for: r3v215 */
    /* JADX WARN: Type inference failed for: r40v100 */
    /* JADX WARN: Type inference failed for: r40v65 */
    /* JADX WARN: Type inference failed for: r40v66 */
    /* JADX WARN: Type inference failed for: r40v67 */
    /* JADX WARN: Type inference failed for: r40v68 */
    /* JADX WARN: Type inference failed for: r40v69 */
    /* JADX WARN: Type inference failed for: r40v70 */
    /* JADX WARN: Type inference failed for: r40v71 */
    /* JADX WARN: Type inference failed for: r40v72 */
    /* JADX WARN: Type inference failed for: r40v73 */
    /* JADX WARN: Type inference failed for: r40v74 */
    /* JADX WARN: Type inference failed for: r40v75 */
    /* JADX WARN: Type inference failed for: r40v76 */
    /* JADX WARN: Type inference failed for: r40v78 */
    /* JADX WARN: Type inference failed for: r40v79 */
    /* JADX WARN: Type inference failed for: r40v80, names: [seasonNumber], types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r40v81, names: [seasonNumber], types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r40v83, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r8v112 */
    /* JADX WARN: Type inference failed for: r8v113 */
    /* JADX WARN: Type inference failed for: r8v114 */
    /* JADX WARN: Type inference failed for: r8v115 */
    /* JADX WARN: Type inference failed for: r8v116 */
    /* JADX WARN: Type inference failed for: r8v117 */
    /* JADX WARN: Type inference failed for: r8v118 */
    /* JADX WARN: Type inference failed for: r8v119 */
    /* JADX WARN: Type inference failed for: r8v120 */
    /* JADX WARN: Type inference failed for: r8v121 */
    /* JADX WARN: Type inference failed for: r8v122 */
    /* JADX WARN: Type inference failed for: r8v123 */
    /* JADX WARN: Type inference failed for: r8v124 */
    /* JADX WARN: Type inference failed for: r8v125 */
    /* JADX WARN: Type inference failed for: r8v126 */
    /* JADX WARN: Type inference failed for: r8v127 */
    /* JADX WARN: Type inference failed for: r8v128 */
    /* JADX WARN: Type inference failed for: r8v129 */
    /* JADX WARN: Type inference failed for: r8v130 */
    /* JADX WARN: Type inference failed for: r8v131 */
    /* JADX WARN: Type inference failed for: r8v132 */
    /* JADX WARN: Type inference failed for: r8v133 */
    /* JADX WARN: Type inference failed for: r8v134 */
    /* JADX WARN: Type inference failed for: r8v135 */
    /* JADX WARN: Type inference failed for: r8v136 */
    /* JADX WARN: Type inference failed for: r8v37, names: [type], types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v38, names: [type], types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v40, names: [seasonNumber], types: [java.lang.Integer, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v62, names: [seasonNumber], types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r8v63, names: [seasonNumber], types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r8v66, names: [videos], types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v67, names: [videos], types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:394:0x12af -> B:1103:0x12d6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:624:0x2049 -> B:625:0x208e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:676:0x21a5 -> B:1083:0x21dc). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:727:0x2352 -> B:753:0x2692). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:729:0x2394 -> B:753:0x2692). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:733:0x23da -> B:753:0x2692). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:738:0x2466 -> B:753:0x2692). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:740:0x24ac -> B:753:0x2692). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:742:0x24f2 -> B:753:0x2692). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:744:0x2538 -> B:753:0x2692). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:746:0x257e -> B:753:0x2692). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:748:0x25c4 -> B:753:0x2692). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:750:0x260a -> B:753:0x2692). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:752:0x264f -> B:753:0x2692). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:764:0x275d -> B:765:0x2765). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:804:0x2911 -> B:964:0x2945). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:860:0x2ad8 -> B:876:0x2cd7). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:862:0x2b1b -> B:876:0x2cd7). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:869:0x2baf -> B:876:0x2cd7). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:871:0x2bfa -> B:876:0x2cd7). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:873:0x2c45 -> B:876:0x2cd7). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:875:0x2c8f -> B:876:0x2cd7). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object load(@org.jetbrains.annotations.NotNull java.lang.String r102, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r103) {
        /*
            Method dump skipped, instruction units count: 12106
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zinkmovies.Zinkmovies.load(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$1$1(String $poster, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($poster);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.zinkmovies.Zinkmovies$load$5 */
    /* JADX INFO: compiled from: Zinkmovies.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.zinkmovies.Zinkmovies$load$5", f = "Zinkmovies.kt", i = {0}, l = {335}, m = "invokeSuspend", n = {"$this$newMovieLoadResponse"}, nl = {336}, s = {"L$0"}, v = 2)
    static final class C00115 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
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
        C00115(Ref.ObjectRef<String> objectRef, List<MovieSearchResponse> list, ResponseDataLocal responseDataLocal, String str, Ref.ObjectRef<String> objectRef2, Ref.ObjectRef<String> objectRef3, String str2, Ref.ObjectRef<List<String>> objectRef4, List<String> list2, Ref.ObjectRef<List<ActorData>> objectRef5, String str3, Continuation<? super C00115> continuation) {
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
            Continuation<Unit> c00115 = new C00115(this.$background, this.$recommendations, this.$responseData, this.$poster, this.$year, this.$description, this.$plot, this.$genre, this.$tags, this.$actorData, this.$trailer, continuation);
            c00115.L$0 = obj;
            return c00115;
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
    @DebugMetadata(c = "com.zinkmovies.Zinkmovies$load$12", f = "Zinkmovies.kt", i = {0}, l = {474}, m = "invokeSuspend", n = {"$this$newTvSeriesLoadResponse"}, nl = {475}, s = {"L$0"}, v = 2)
    static final class C001012 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
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
        C001012(Ref.ObjectRef<String> objectRef, List<MovieSearchResponse> list, ResponseDataLocal responseDataLocal, String str, Ref.ObjectRef<String> objectRef2, Ref.ObjectRef<String> objectRef3, String str2, Ref.ObjectRef<List<String>> objectRef4, List<String> list2, Ref.ObjectRef<List<ActorData>> objectRef5, String str3, Continuation<? super C001012> continuation) {
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
            Continuation<Unit> c001012 = new C001012(this.$background, this.$recommendations, this.$responseData, this.$poster, this.$year, this.$description, this.$plot, this.$genre, this.$tags, this.$actorData, this.$trailer, continuation);
            c001012.L$0 = obj;
            return c001012;
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
        C00121 c00121;
        Object obj;
        Object obj2;
        Object objDecodeFromString;
        List linksList;
        boolean z;
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
                C00132 c00132 = new C00132(function2, this, function1, null);
                c00122.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00122.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                c00122.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                c00122.L$3 = SpillingKt.nullOutSpilledVariable(linksList);
                c00122.Z$0 = isCasting;
                z = true;
                c00122.label = 1;
                if (ParCollectionsKt.amap(linksList, c00132, c00122) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                boolean z2 = c00122.Z$0;
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
    @DebugMetadata(c = "com.zinkmovies.Zinkmovies$loadLinks$2", f = "Zinkmovies.kt", i = {0, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3}, l = {495, 496, 499, 509}, m = "invokeSuspend", n = {"pageUrl", "pageUrl", "finalUrl", "pageUrl", "finalUrl", "$this$forEach$iv", "element$iv", "link", "pageUrl", "finalUrl", "$this$forEach$iv", "element$iv", "link"}, nl = {496, 569, 498, 516}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$7", "L$8", "L$0", "L$1", "L$2", "L$7", "L$8"}, v = 2)
    @SourceDebugExtension({"SMAP\nZinkmovies.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zinkmovies.kt\ncom/zinkmovies/Zinkmovies$loadLinks$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,568:1\n2068#2,2:569\n*S KotlinDebug\n*F\n+ 1 Zinkmovies.kt\ncom/zinkmovies/Zinkmovies$loadLinks$2\n*L\n496#1:569,2\n*E\n"})
    static final class C00132 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
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
        C00132(Function1<? super ExtractorLink, Unit> function1, Zinkmovies zinkmovies, Function1<? super SubtitleFile, Unit> function2, Continuation<? super C00132> continuation) {
            super(2, continuation);
            this.$callback = function1;
            this.this$0 = zinkmovies;
            this.$subtitleCallback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00132 = new C00132(this.$callback, this.this$0, this.$subtitleCallback, continuation);
            c00132.L$0 = obj;
            return c00132;
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
            throw new UnsupportedOperationException("Method not decompiled: com.zinkmovies.Zinkmovies.C00132.invokeSuspend(java.lang.Object):java.lang.Object");
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
