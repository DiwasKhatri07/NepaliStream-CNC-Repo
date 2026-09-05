package com.fourKHDHub;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.api.Log;
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
import com.lagradost.cloudstream3.SearchQuality;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
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

/* JADX INFO: compiled from: FourKHDHub.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/FourKHDHub/classes.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 ;2\u00020\u0001:\u0001;B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010 \u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0096@¢\u0006\u0002\u0010'J\u000e\u0010(\u001a\u0004\u0018\u00010)*\u00020*H\u0002J\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020)0\u001e2\u0006\u0010,\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010-J\u0016\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010-JF\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u000e2\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u000207052\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020705H\u0096@¢\u0006\u0002\u0010:R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0014\u0010\u0016\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006<"}, d2 = {"Lcom/fourKHDHub/FourKHDHub;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasDownloadSupport", "getHasDownloadSupport", "hasQuickSearch", "getHasQuickSearch", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lorg/jsoup/nodes/Element;", "search", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "FourKHDHub"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFourKHDHub.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FourKHDHub.kt\ncom/fourKHDHub/FourKHDHub\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 5 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 6 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 7 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,387:1\n1795#2,10:388\n2068#2:398\n2069#2:400\n1805#2:401\n1739#2:402\n1814#2,3:403\n1795#2,10:406\n2068#2:416\n2069#2:418\n1805#2:419\n1739#2:420\n1814#2,3:421\n1795#2,10:425\n2068#2:435\n2069#2:437\n1805#2:438\n2068#2:439\n2068#2:440\n1795#2,10:441\n2068#2:451\n2069#2:453\n1805#2:454\n2069#2:462\n2069#2:463\n1739#2:464\n1814#2,3:465\n2068#2:470\n1795#2,10:471\n2068#2:481\n2069#2:483\n1805#2:484\n2069#2:485\n1#3:399\n1#3:417\n1#3:424\n1#3:436\n1#3:452\n1#3:482\n1#3:489\n460#4,7:455\n221#5,2:468\n93#6,2:486\n63#6:488\n64#6,15:490\n95#6,2:507\n50#7:505\n43#7:506\n*S KotlinDebug\n*F\n+ 1 FourKHDHub.kt\ncom/fourKHDHub/FourKHDHub\n*L\n60#1:388,10\n60#1:398\n60#1:400\n60#1:401\n70#1:402\n70#1:403,3\n81#1:406,10\n81#1:416\n81#1:418\n81#1:419\n92#1:420\n92#1:421,3\n102#1:425,10\n102#1:435\n102#1:437\n102#1:438\n179#1:439\n184#1:440\n189#1:441,10\n189#1:451\n189#1:453\n189#1:454\n184#1:462\n179#1:463\n200#1:464\n200#1:465,3\n243#1:470\n252#1:471,10\n252#1:481\n252#1:483\n252#1:484\n243#1:485\n60#1:399\n81#1:417\n102#1:436\n189#1:452\n252#1:482\n360#1:489\n192#1:455,7\n209#1:468,2\n360#1:486,2\n360#1:488\n360#1:490,15\n360#1:507,2\n360#1:505\n360#1:506\n*E\n"})
public final class FourKHDHub extends MainAPI {

    @NotNull
    private static final String SIMKL = "https://api.simkl.com";

    @NotNull
    public static final String TMDBAPI = "https://api.themoviedb.org/3";

    @NotNull
    public static final String TMDBIMAGEBASEURL = "https://image.tmdb.org/t/p/original";

    @NotNull
    public static final String TMDB_API_KEY = "1865f43a0549ca50d341dd9ab8b29f49";

    @NotNull
    private String mainUrl = (String) BuildersKt.runBlockingK(EmptyCoroutineContext.INSTANCE, new FourKHDHub$mainUrl$1(null));

    @NotNull
    private String name = "4K HDHUB";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "en";
    private final boolean hasDownloadSupport = true;
    private final boolean hasQuickSearch = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.Anime, TvType.TvSeries});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("", "Home"), TuplesKt.to("category/movies", "Latest Movies"), TuplesKt.to("category/series", "Latest Episodes"), TuplesKt.to("category/korean-series", "Korean Series"), TuplesKt.to("category/netflix", "Netflix"), TuplesKt.to("category/amazon_prime_video", "Amazon Prime Video"), TuplesKt.to("category/jiohotstar", "JioHotstar"), TuplesKt.to("category/disney", "Disney+"), TuplesKt.to("category/Apple_TV", "Apple TV+"), TuplesKt.to("category/anime", "Anime"), TuplesKt.to("category/2160p-HDR", "4K HDR"), TuplesKt.to("category/imdb", "Top IMDb"), TuplesKt.to("category/hindi-movies", "Hindi Movies"), TuplesKt.to("category/english-movies", "English Movies")});

    /* JADX INFO: renamed from: com.fourKHDHub.FourKHDHub$getMainPage$1 */
    /* JADX INFO: compiled from: FourKHDHub.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.fourKHDHub.FourKHDHub", f = "FourKHDHub.kt", i = {0, 0, 0}, l = {59}, m = "getMainPage", n = {"request", "url", "page"}, nl = {60}, s = {"L$0", "L$1", "I$0"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00011(Continuation<? super C00011> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FourKHDHub.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.fourKHDHub.FourKHDHub$load$1 */
    /* JADX INFO: compiled from: FourKHDHub.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.fourKHDHub.FourKHDHub", f = "FourKHDHub.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, l = {89, 96, 118, 163, 174, 203, 297, 314, 324, 331, 337}, m = "load", n = {"url", "url", "document", "title", "poster", "tags", "year", "tvType", "$this$load_u24lambda_u241", "isMovie", "url", "document", "title", "poster", "tags", "year", "tvType", "tmdbId", "hrefs", "description", "trailer", "recommendations", "tmdbRating", "tmdbActors", "type", "$this$load_u24lambda_u243", "isMovie", "url", "document", "title", "poster", "tags", "year", "tvType", "tmdbId", "hrefs", "description", "trailer", "recommendations", "tmdbTitle", "tmdbOverview", "tmdbYear", "tmdbRating", "tmdbPoster", "tmdbBackdrop", "tmdbActors", "fixedTitle", "fixedPoster", "fixedBackdrop", "fixedPlot", "fixedYear", "finalActorsFromTmdb", "tvSeriesEpisodes", "episodesMap", "maxEpisodePerSeason", "$this$load_u24lambda_u2414_u240", "url", "isMovie", "id", "url", "document", "title", "poster", "tags", "year", "tvType", "tmdbId", "hrefs", "description", "trailer", "recommendations", "tmdbTitle", "tmdbOverview", "tmdbYear", "tmdbRating", "tmdbPoster", "tmdbBackdrop", "tmdbActors", "fixedTitle", "fixedPoster", "fixedBackdrop", "fixedPlot", "fixedYear", "finalActorsFromTmdb", "tvSeriesEpisodes", "episodesMap", "maxEpisodePerSeason", "imdbIdFromSeries", "logoPath", "imdb", "$this$load_u24lambda_u2416_u240", "isMovie", "url", "document", "title", "poster", "tags", "year", "tvType", "tmdbId", "hrefs", "description", "trailer", "recommendations", "tmdbTitle", "tmdbOverview", "tmdbYear", "tmdbRating", "tmdbPoster", "tmdbBackdrop", "tmdbActors", "fixedTitle", "fixedPoster", "fixedBackdrop", "fixedPlot", "fixedYear", "finalActorsFromTmdb", "tvSeriesEpisodes", "episodesMap", "maxEpisodePerSeason", "imdbIdFromSeries", "logoPath", "simklIdseries", "tmdbSeasonCache", "seasonsToFetch", "$this$load_u24lambda_u2419", "isMovie", "s", "url", "document", "title", "poster", "tags", "year", "tvType", "tmdbId", "hrefs", "description", "trailer", "recommendations", "tmdbTitle", "tmdbOverview", "tmdbYear", "tmdbRating", "tmdbPoster", "tmdbBackdrop", "tmdbActors", "fixedTitle", "fixedPoster", "fixedBackdrop", "fixedPlot", "fixedYear", "finalActorsFromTmdb", "tvSeriesEpisodes", "episodesMap", "maxEpisodePerSeason", "imdbIdFromSeries", "logoPath", "simklIdseries", "tmdbSeasonCache", "isMovie", "url", "document", "title", "poster", "tags", "year", "tvType", "tmdbId", "hrefs", "description", "trailer", "recommendations", "tmdbTitle", "tmdbOverview", "tmdbYear", "tmdbRating", "tmdbPoster", "tmdbBackdrop", "tmdbActors", "fixedTitle", "fixedPoster", "fixedBackdrop", "fixedPlot", "fixedYear", "finalActorsFromTmdb", "$this$load_u24lambda_u2424_u240", "url", "isMovie", "id", "url", "document", "title", "poster", "tags", "year", "tvType", "tmdbId", "hrefs", "description", "trailer", "recommendations", "tmdbTitle", "tmdbOverview", "tmdbYear", "tmdbRating", "tmdbPoster", "tmdbBackdrop", "tmdbActors", "fixedTitle", "fixedPoster", "fixedBackdrop", "fixedPlot", "fixedYear", "finalActorsFromTmdb", "imdbIdFromMovie", "logoPath", "imdb", "$this$load_u24lambda_u2426_u240", "isMovie", "url", "document", "title", "poster", "tags", "year", "tvType", "tmdbId", "hrefs", "description", "trailer", "recommendations", "tmdbTitle", "tmdbOverview", "tmdbYear", "tmdbRating", "tmdbPoster", "tmdbBackdrop", "tmdbActors", "fixedTitle", "fixedPoster", "fixedBackdrop", "fixedPlot", "fixedYear", "finalActorsFromTmdb", "imdbIdFromMovie", "logoPath", "simklIdMovie", "$this$load_u24lambda_u2427_u240", "isMovie", "id", "url", "document", "title", "poster", "tags", "year", "tvType", "tmdbId", "hrefs", "description", "trailer", "recommendations", "tmdbTitle", "tmdbOverview", "tmdbYear", "tmdbRating", "tmdbPoster", "tmdbBackdrop", "tmdbActors", "fixedTitle", "fixedPoster", "fixedBackdrop", "fixedPlot", "fixedYear", "finalActorsFromTmdb", "imdbIdFromMovie", "logoPath", "simklIdMovie", "movieCreditsJsonText", "movieCastList", "finalMovieActors", "isMovie"}, nl = {90, 96, 119, 392, 175, 202, 311, 392, 325, 330, 156}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$28", "L$29", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$28", "L$29", "L$30", "L$31", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$28", "L$29", "L$30", "L$31", "L$32", "L$36", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$28", "L$29", "L$30", "L$31", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$28", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$28", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$28", "L$29", "L$30", "I$0"}, v = 2)
    static final class C00021 extends ContinuationImpl {
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

        C00021(Continuation<? super C00021> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FourKHDHub.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.fourKHDHub.FourKHDHub$loadLinks$1 */
    /* JADX INFO: compiled from: FourKHDHub.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.fourKHDHub.FourKHDHub", f = "FourKHDHub.kt", i = {0, 0, 0, 0, 0}, l = {363}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "links", "isCasting"}, nl = {384}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0"}, v = 2)
    static final class C00051 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
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
            return FourKHDHub.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.fourKHDHub.FourKHDHub$search$1 */
    /* JADX INFO: compiled from: FourKHDHub.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.fourKHDHub.FourKHDHub", f = "FourKHDHub.kt", i = {0}, l = {80}, m = "search", n = {"query"}, nl = {81}, s = {"L$0"}, v = 2)
    static final class C00071 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00071(Continuation<? super C00071> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FourKHDHub.this.search(null, (Continuation) this);
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

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        C00011 c00011;
        boolean z;
        int page2;
        MainPageRequest request2;
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
                String url = getMainUrl() + (!StringsKt.isBlank(request.getData()) ? '/' + request.getData() : "") + (page > 1 ? "/page/" + page : "");
                Requests app = MainActivityKt.getApp();
                c00011.L$0 = request;
                c00011.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00011.I$0 = page;
                c00011.label = 1;
                z = true;
                $result = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00011, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                page2 = page;
                request2 = request;
                break;
                break;
            case 1:
                page2 = c00011.I$0;
                request2 = (MainPageRequest) c00011.L$0;
                ResultKt.throwOnFailure($result);
                z = true;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv = document.select("div.card-grid a");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            int page3 = page2;
            Element it = (Element) element$iv$iv$iv;
            SearchResponse searchResult = toSearchResult(it);
            if (searchResult != null) {
                destination$iv$iv.add(searchResult);
            }
            page2 = page3;
        }
        List results = (List) destination$iv$iv;
        return MainAPIKt.newHomePageResponse(request2.getName(), results, Boxing.boxBoolean(z));
    }

    private final SearchResponse toSearchResult(Element $this$toSearchResult) {
        String title;
        Element elementSelectFirst = $this$toSearchResult.selectFirst("h3");
        if (elementSelectFirst == null || (title = elementSelectFirst.text()) == null) {
            return null;
        }
        String href = $this$toSearchResult.attr("href");
        final String posterUrl = $this$toSearchResult.select("img").attr("src");
        Iterable $this$map$iv = $this$toSearchResult.select("span.movie-card-format");
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Element it = (Element) item$iv$iv;
            destination$iv$iv.add(it.text());
        }
        List tags = (List) destination$iv$iv;
        final SearchQuality quality = UtilsKt.getSearchQuality(tags);
        return MainAPIKt.newMovieSearchResponse$default(this, title, href, TvType.Movie, false, new Function1() { // from class: com.fourKHDHub.FourKHDHub$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return FourKHDHub.toSearchResult$lambda$1(posterUrl, quality, (MovieSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResult$lambda$1(String $posterUrl, SearchQuality $quality, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($posterUrl);
        $this$newMovieSearchResponse.setQuality($quality);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        C00071 c00071;
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
        switch (c00071.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                String str = getMainUrl() + "/?s=" + query;
                c00071.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00071.label = 1;
                $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00071, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv = document.select("div.card-grid a");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Element it = (Element) element$iv$iv$iv;
            SearchResponse searchResult = toSearchResult(it);
            if (searchResult != null) {
                destination$iv$iv.add(searchResult);
            }
        }
        List results = (List) destination$iv$iv;
        return results;
    }

    /* JADX WARN: Code duplicated, block: B:381:0x180c  */
    /* JADX WARN: Code duplicated, block: B:469:0x1d56  */
    /* JADX WARN: Code duplicated, block: B:499:0x1e78 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:500:0x1e79  */
    /* JADX WARN: Code duplicated, block: B:537:0x23e6  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Multi-variable search skipped. Vars limit reached: 6426 (expected less than 5000) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v100 */
    /* JADX WARN: Type inference failed for: r12v104 */
    /* JADX WARN: Type inference failed for: r12v94 */
    /* JADX WARN: Type inference failed for: r36v62 */
    /* JADX WARN: Type inference failed for: r36v68, types: [java.lang.Integer, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r36v71 */
    /* JADX WARN: Type inference failed for: r43v109 */
    /* JADX WARN: Type inference failed for: r43v115, types: [java.lang.Integer, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r43v116 */
    /* JADX WARN: Type inference failed for: r4v161 */
    /* JADX WARN: Type inference failed for: r4v77 */
    /* JADX WARN: Type inference failed for: r50v61 */
    /* JADX WARN: Type inference failed for: r50v62, types: [java.lang.Integer, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r50v63 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:500:0x1e79 -> B:1036:0x1ecc). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:534:0x2398 -> B:535:0x23e0). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object load(@org.jetbrains.annotations.NotNull java.lang.String r95, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r96) {
        /*
            Method dump skipped, instruction units count: 14878
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fourKHDHub.FourKHDHub.load(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static final Comparable load$lambda$20(Pair it) {
        return (Comparable) it.getFirst();
    }

    static final Comparable load$lambda$21(Pair it) {
        return (Comparable) it.getSecond();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$22$1(int $season, int $episode, Ref.ObjectRef $epName, Ref.ObjectRef $epThumb, Ref.ObjectRef $epOverview, Ref.ObjectRef $epAir, Ref.ObjectRef $epRating, Episode $this$newEpisode) {
        $this$newEpisode.setSeason(Integer.valueOf($season));
        $this$newEpisode.setEpisode(Integer.valueOf($episode));
        String str = (String) $epName.element;
        if (str == null) {
            str = "Episode " + $episode;
        }
        $this$newEpisode.setName(str);
        $this$newEpisode.setPosterUrl((String) $epThumb.element);
        $this$newEpisode.setDescription((String) $epOverview.element);
        MainAPIKt.addDate$default($this$newEpisode, (String) $epAir.element, (String) null, 2, (Object) null);
        $this$newEpisode.setScore(UtilsKt.safeScoreFrom10((Double) $epRating.element));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$23$2(int $season, Ref.IntRef $nextEpisode, Ref.ObjectRef $epName, String $fileTitle, String $quality, String $size, Ref.ObjectRef $epThumb, Ref.ObjectRef $epOverview, Ref.ObjectRef $epAir, Ref.ObjectRef $epRating, Episode $this$newEpisode) {
        $this$newEpisode.setSeason(Integer.valueOf($season));
        $this$newEpisode.setEpisode(Integer.valueOf($nextEpisode.element));
        String string = (String) $epName.element;
        if (string == null) {
            string = StringsKt.trim('S' + StringsKt.padStart(String.valueOf($season), 2, '0') + " – " + $fileTitle + " [" + $quality + ", " + $size + ']').toString();
        }
        $this$newEpisode.setName(string);
        $this$newEpisode.setPosterUrl((String) $epThumb.element);
        $this$newEpisode.setDescription((String) $epOverview.element);
        MainAPIKt.addDate$default($this$newEpisode, (String) $epAir.element, (String) null, 2, (Object) null);
        $this$newEpisode.setScore(UtilsKt.safeScoreFrom10((Double) $epRating.element));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.fourKHDHub.FourKHDHub$load$17 */
    /* JADX INFO: compiled from: FourKHDHub.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.fourKHDHub.FourKHDHub$load$17", f = "FourKHDHub.kt", i = {0}, l = {307}, m = "invokeSuspend", n = {"$this$newTvSeriesLoadResponse"}, nl = {308}, s = {"L$0"}, v = 2)
    static final class C000317 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<ActorData> $finalActorsFromTmdb;
        final /* synthetic */ String $fixedBackdrop;
        final /* synthetic */ String $fixedPlot;
        final /* synthetic */ String $fixedPoster;
        final /* synthetic */ Integer $fixedYear;
        final /* synthetic */ String $logoPath;
        final /* synthetic */ List<SearchResponse> $recommendations;
        final /* synthetic */ Integer $simklIdseries;
        final /* synthetic */ List<String> $tags;
        final /* synthetic */ Ref.ObjectRef<Double> $tmdbRating;
        final /* synthetic */ String $trailer;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C000317(String str, String str2, String str3, Integer num, String str4, List<String> list, List<? extends SearchResponse> list2, List<ActorData> list3, Ref.ObjectRef<Double> objectRef, String str5, Integer num2, Continuation<? super C000317> continuation) {
            super(2, continuation);
            this.$fixedPoster = str;
            this.$fixedBackdrop = str2;
            this.$logoPath = str3;
            this.$fixedYear = num;
            this.$fixedPlot = str4;
            this.$tags = list;
            this.$recommendations = list2;
            this.$finalActorsFromTmdb = list3;
            this.$tmdbRating = objectRef;
            this.$trailer = str5;
            this.$simklIdseries = num2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c000317 = new C000317(this.$fixedPoster, this.$fixedBackdrop, this.$logoPath, this.$fixedYear, this.$fixedPlot, this.$tags, this.$recommendations, this.$finalActorsFromTmdb, this.$tmdbRating, this.$trailer, this.$simklIdseries, continuation);
            c000317.L$0 = obj;
            return c000317;
        }

        public final Object invoke(TvSeriesLoadResponse tvSeriesLoadResponse, Continuation<? super Unit> continuation) {
            return create(tvSeriesLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            LoadResponse loadResponse = (TvSeriesLoadResponse) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    loadResponse.setPosterUrl(this.$fixedPoster);
                    loadResponse.setBackgroundPosterUrl(this.$fixedBackdrop);
                    try {
                        loadResponse.setLogoUrl(this.$logoPath);
                        break;
                    } catch (Throwable th) {
                    }
                    loadResponse.setYear(this.$fixedYear);
                    loadResponse.setPlot(this.$fixedPlot);
                    loadResponse.setTags(this.$tags);
                    loadResponse.setRecommendations(this.$recommendations);
                    loadResponse.setActors(this.$finalActorsFromTmdb);
                    loadResponse.setScore(UtilsKt.safeScoreFrom10((Double) this.$tmdbRating.element));
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
            LoadResponse.Companion.addSimklId(loadResponse, this.$simklIdseries);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.fourKHDHub.FourKHDHub$load$18 */
    /* JADX INFO: compiled from: FourKHDHub.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.fourKHDHub.FourKHDHub$load$18", f = "FourKHDHub.kt", i = {0}, l = {347}, m = "invokeSuspend", n = {"$this$newMovieLoadResponse"}, nl = {348}, s = {"L$0"}, v = 2)
    static final class C000418 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<ActorData> $finalMovieActors;
        final /* synthetic */ String $fixedBackdrop;
        final /* synthetic */ String $fixedPlot;
        final /* synthetic */ String $fixedPoster;
        final /* synthetic */ Integer $fixedYear;
        final /* synthetic */ String $logoPath;
        final /* synthetic */ List<SearchResponse> $recommendations;
        final /* synthetic */ Integer $simklIdMovie;
        final /* synthetic */ List<String> $tags;
        final /* synthetic */ Ref.ObjectRef<Double> $tmdbRating;
        final /* synthetic */ String $trailer;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C000418(String str, String str2, String str3, Integer num, String str4, List<String> list, List<? extends SearchResponse> list2, List<ActorData> list3, Ref.ObjectRef<Double> objectRef, String str5, Integer num2, Continuation<? super C000418> continuation) {
            super(2, continuation);
            this.$fixedPoster = str;
            this.$fixedBackdrop = str2;
            this.$logoPath = str3;
            this.$fixedYear = num;
            this.$fixedPlot = str4;
            this.$tags = list;
            this.$recommendations = list2;
            this.$finalMovieActors = list3;
            this.$tmdbRating = objectRef;
            this.$trailer = str5;
            this.$simklIdMovie = num2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c000418 = new C000418(this.$fixedPoster, this.$fixedBackdrop, this.$logoPath, this.$fixedYear, this.$fixedPlot, this.$tags, this.$recommendations, this.$finalMovieActors, this.$tmdbRating, this.$trailer, this.$simklIdMovie, continuation);
            c000418.L$0 = obj;
            return c000418;
        }

        public final Object invoke(MovieLoadResponse movieLoadResponse, Continuation<? super Unit> continuation) {
            return create(movieLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            LoadResponse loadResponse = (MovieLoadResponse) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    loadResponse.setPosterUrl(this.$fixedPoster);
                    loadResponse.setBackgroundPosterUrl(this.$fixedBackdrop);
                    try {
                        loadResponse.setLogoUrl(this.$logoPath);
                        break;
                    } catch (Throwable th) {
                    }
                    loadResponse.setYear(this.$fixedYear);
                    loadResponse.setPlot(this.$fixedPlot);
                    loadResponse.setTags(this.$tags);
                    loadResponse.setRecommendations(this.$recommendations);
                    loadResponse.setActors(this.$finalMovieActors);
                    loadResponse.setScore(UtilsKt.safeScoreFrom10((Double) this.$tmdbRating.element));
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
            LoadResponse.Companion.addSimklId(loadResponse, this.$simklIdMovie);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00051 c00051;
        Object obj;
        Object obj2;
        Object objDecodeFromString;
        Sequence sequenceAsSequence;
        Sequence sequenceFilter;
        Sequence sequenceDistinct;
        List links;
        boolean z;
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
        switch (c00052.label) {
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
                                objDecodeFromString = $this$readValue$iv$iv$iv.readValue(data, new TypeReference<List<? extends String>>() { // from class: com.fourKHDHub.FourKHDHub$loadLinks$$inlined$tryParseJson$1
                                });
                            } catch (Throwable th3) {
                                ObjectMapper $this$readValue$iv$iv$iv2 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv$iv2.readValue(data, new TypeReference<List<? extends String>>() { // from class: com.fourKHDHub.FourKHDHub$loadLinks$$inlined$tryParseJson$1
                                });
                            }
                        } else {
                            ObjectMapper $this$readValue$iv$iv$iv3 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv$iv3.readValue(data, new TypeReference<List<? extends String>>() { // from class: com.fourKHDHub.FourKHDHub$loadLinks$$inlined$tryParseJson$1
                            });
                        }
                        obj2 = objDecodeFromString;
                    } catch (Exception e2) {
                        obj2 = null;
                    }
                }
                List list = (List) obj2;
                if (list == null || (sequenceAsSequence = CollectionsKt.asSequence(list)) == null || (sequenceFilter = SequencesKt.filter(sequenceAsSequence, new Function1() { // from class: com.fourKHDHub.FourKHDHub$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj3) {
                        return Boolean.valueOf(FourKHDHub.loadLinks$lambda$0((String) obj3));
                    }
                })) == null || (sequenceDistinct = SequencesKt.distinct(sequenceFilter)) == null || (links = SequencesKt.toList(sequenceDistinct)) == null) {
                    return Boxing.boxBoolean(false);
                }
                C00062 c00062 = new C00062(function1, function2, null);
                c00052.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00052.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                c00052.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                c00052.L$3 = SpillingKt.nullOutSpilledVariable(links);
                c00052.Z$0 = isCasting;
                z = true;
                c00052.label = 1;
                if (ParCollectionsKt.amap(links, c00062, c00052) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                boolean z2 = c00052.Z$0;
                ResultKt.throwOnFailure($result);
                z = true;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Boxing.boxBoolean(z);
    }

    static final boolean loadLinks$lambda$0(String it) {
        return !StringsKt.isBlank(it);
    }

    /* JADX INFO: renamed from: com.fourKHDHub.FourKHDHub$loadLinks$2 */
    /* JADX INFO: compiled from: FourKHDHub.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "raw", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.fourKHDHub.FourKHDHub$loadLinks$2", f = "FourKHDHub.kt", i = {0, 1, 1, 2, 2}, l = {365, 375, 377}, m = "invokeSuspend", n = {"raw", "raw", "resolved", "raw", "resolved"}, nl = {366, 377, 379}, s = {"L$0", "L$0", "L$1", "L$0", "L$1"}, v = 2)
    static final class C00062 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00062(Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super C00062> continuation) {
            super(2, continuation);
            this.$subtitleCallback = function1;
            this.$callback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00062 = FourKHDHub.this.new C00062(this.$subtitleCallback, this.$callback, continuation);
            c00062.L$0 = obj;
            return c00062;
        }

        public final Object invoke(String str, Continuation<? super Unit> continuation) {
            return create(str, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:29:0x006a  */
        /* JADX WARN: Code duplicated, block: B:34:0x007b A[Catch: Exception -> 0x00c1, TryCatch #2 {Exception -> 0x00c1, blocks: (B:32:0x006e, B:34:0x007b, B:39:0x00a0), top: B:53:0x006e }] */
        /* JADX WARN: Code duplicated, block: B:36:0x009d A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:37:0x009e  */
        /* JADX WARN: Code duplicated, block: B:39:0x00a0 A[Catch: Exception -> 0x00c1, TRY_LEAVE, TryCatch #2 {Exception -> 0x00c1, blocks: (B:32:0x006e, B:34:0x007b, B:39:0x00a0), top: B:53:0x006e }] */
        /* JADX WARN: Code duplicated, block: B:41:0x00be A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:42:0x00bf  */
        /* JADX WARN: Code duplicated, block: B:53:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [int] */
        /* JADX WARN: Type inference failed for: r2v15 */
        public final Object invokeSuspend(Object $result) {
            String str;
            Object redirectLinks;
            String resolved;
            String raw = (String) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            String str2 = this.label;
            try {
                try {
                    switch (str2) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            if (StringsKt.contains$default(raw, "id=", false, 2, (Object) null)) {
                                this.L$0 = raw;
                                this.label = 1;
                                redirectLinks = UtilsKt.getRedirectLinks(raw, (Continuation) this);
                                if (redirectLinks == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                str = (String) redirectLinks;
                                break;
                            } else {
                                str = raw;
                            }
                            resolved = str;
                            if (StringsKt.isBlank(resolved)) {
                                return Unit.INSTANCE;
                            }
                            try {
                                if (StringsKt.contains(resolved, "hubcloud", true)) {
                                    this.L$0 = SpillingKt.nullOutSpilledVariable(raw);
                                    this.L$1 = resolved;
                                    this.label = 2;
                                    if (new HubCloud().getUrl(resolved, FourKHDHub.this.getName(), this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                } else {
                                    this.L$0 = SpillingKt.nullOutSpilledVariable(raw);
                                    this.L$1 = resolved;
                                    this.label = 3;
                                    if (ExtractorApiKt.loadExtractor(resolved, FourKHDHub.this.getName(), this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            } catch (Exception e) {
                                e = e;
                                str2 = resolved;
                                Log.INSTANCE.e("Extractor", "Extractor failed: " + str2 + " — " + e.getMessage());
                            }
                            return Unit.INSTANCE;
                        case 1:
                            ResultKt.throwOnFailure($result);
                            redirectLinks = $result;
                            str = (String) redirectLinks;
                            resolved = str;
                            if (StringsKt.isBlank(resolved)) {
                                return Unit.INSTANCE;
                            }
                            if (StringsKt.contains(resolved, "hubcloud", true)) {
                                this.L$0 = SpillingKt.nullOutSpilledVariable(raw);
                                this.L$1 = resolved;
                                this.label = 2;
                                if (new HubCloud().getUrl(resolved, FourKHDHub.this.getName(), this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                this.L$0 = SpillingKt.nullOutSpilledVariable(raw);
                                this.L$1 = resolved;
                                this.label = 3;
                                if (ExtractorApiKt.loadExtractor(resolved, FourKHDHub.this.getName(), this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            return Unit.INSTANCE;
                        case 2:
                            ResultKt.throwOnFailure($result);
                            return Unit.INSTANCE;
                        case 3:
                            ResultKt.throwOnFailure($result);
                            return Unit.INSTANCE;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Exception e3) {
                Log.INSTANCE.e("Extractor", "Redirect failed: " + raw + " — " + e3.getMessage());
                return Unit.INSTANCE;
            }
        }
    }
}
