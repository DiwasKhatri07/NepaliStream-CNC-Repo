package com.hindmoviez;

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
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SearchResponseList;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.network.CloudflareKiller;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
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
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.Interceptor;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* JADX INFO: compiled from: hindmoviez.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Hindmoviez/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 =2\u00020\u0001:\u0001=B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010 \u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0096@¢\u0006\u0002\u0010'J\f\u0010(\u001a\u00020)*\u00020*H\u0002J\u001e\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00052\u0006\u0010#\u001a\u00020$H\u0096@¢\u0006\u0002\u0010.J\u0016\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u00102JF\u00103\u001a\u00020\u00112\u0006\u00104\u001a\u00020\u00052\u0006\u00105\u001a\u00020\u00112\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u000209072\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020907H\u0096@¢\u0006\u0002\u0010<R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0011X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u0011X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006>"}, d2 = {"Lcom/hindmoviez/Hindmoviez;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "lang", "getLang", "setLang", "hasMainPage", "", "getHasMainPage", "()Z", "hasDownloadSupport", "getHasDownloadSupport", "hasQuickSearch", "getHasQuickSearch", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lorg/jsoup/nodes/Element;", "search", "Lcom/lagradost/cloudstream3/SearchResponseList;", "query", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "Hindmoviez"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nhindmoviez.kt\nKotlin\n*S Kotlin\n*F\n+ 1 hindmoviez.kt\ncom/hindmoviez/Hindmoviez\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 5 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 6 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 7 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,454:1\n1795#2,10:455\n2068#2:465\n2069#2:467\n1805#2:468\n1795#2,10:470\n2068#2:480\n2069#2:482\n1805#2:483\n2068#2:484\n1739#2:486\n1814#2,3:487\n2069#2:490\n296#2,2:491\n296#2,2:516\n296#2,2:541\n2068#2:589\n1795#2,10:590\n2068#2:600\n2069#2:602\n1805#2:603\n2068#2:604\n2069#2:612\n2069#2:613\n1739#2:614\n1814#2,3:615\n296#2,2:644\n1#3:466\n1#3:469\n1#3:481\n1#3:485\n1#3:496\n1#3:521\n1#3:546\n1#3:569\n1#3:601\n1#3:621\n1#3:650\n1#3:673\n1#3:693\n93#4,2:493\n63#4:495\n64#4,15:497\n95#4,2:514\n93#4,2:518\n63#4:520\n64#4,15:522\n95#4,2:539\n93#4,2:543\n63#4:545\n64#4,15:547\n95#4,2:564\n93#4,2:566\n63#4:568\n64#4,15:570\n95#4,2:587\n93#4,2:618\n63#4:620\n64#4,15:622\n95#4,2:639\n93#4,2:647\n63#4:649\n64#4,15:651\n95#4,2:668\n93#4,2:670\n63#4:672\n64#4,15:674\n95#4,2:691\n50#5:512\n43#5:513\n50#5:537\n43#5:538\n50#5:562\n43#5:563\n50#5:585\n43#5:586\n50#5:637\n43#5:638\n50#5:666\n43#5:667\n50#5:689\n43#5:690\n460#6,7:605\n129#7:641\n158#7,2:642\n160#7:646\n*S KotlinDebug\n*F\n+ 1 hindmoviez.kt\ncom/hindmoviez/Hindmoviez\n*L\n85#1:455,10\n85#1:465\n85#1:467\n85#1:468\n105#1:470,10\n105#1:480\n105#1:482\n105#1:483\n132#1:484\n154#1:486\n154#1:487,3\n132#1:490\n162#1:491,2\n234#1:516,2\n238#1:541,2\n257#1:589\n275#1:590,10\n275#1:600\n275#1:602\n275#1:603\n295#1:604\n295#1:612\n257#1:613\n302#1:614\n302#1:615,3\n319#1:644,2\n85#1:466\n105#1:481\n233#1:496\n237#1:521\n243#1:546\n247#1:569\n275#1:601\n314#1:621\n350#1:650\n376#1:673\n233#1:493,2\n233#1:495\n233#1:497,15\n233#1:514,2\n237#1:518,2\n237#1:520\n237#1:522,15\n237#1:539,2\n243#1:543,2\n243#1:545\n243#1:547,15\n243#1:564,2\n247#1:566,2\n247#1:568\n247#1:570,15\n247#1:587,2\n314#1:618,2\n314#1:620\n314#1:622,15\n314#1:639,2\n350#1:647,2\n350#1:649\n350#1:651,15\n350#1:668,2\n376#1:670,2\n376#1:672\n376#1:674,15\n376#1:691,2\n233#1:512\n233#1:513\n237#1:537\n237#1:538\n243#1:562\n243#1:563\n247#1:585\n247#1:586\n314#1:637\n314#1:638\n350#1:666\n350#1:667\n376#1:689\n376#1:690\n297#1:605,7\n316#1:641\n316#1:642,2\n316#1:646\n*E\n"})
public final class Hindmoviez extends MainAPI {

    @NotNull
    private static final String TMDB_API = "https://api.themoviedb.org/3";

    @NotNull
    private static final String TMDB_IMG = "https://image.tmdb.org/t/p/original";

    @NotNull
    private static final String TMDB_KEY = "1865f43a0549ca50d341dd9ab8b29f49";
    private final boolean hasQuickSearch;

    @NotNull
    private String mainUrl = (String) BuildersKt.runBlockingK(EmptyCoroutineContext.INSTANCE, new Hindmoviez$mainUrl$1(null));

    @NotNull
    private String name = "Hindmoviez";

    @NotNull
    private String lang = "hi";
    private final boolean hasMainPage = true;
    private final boolean hasDownloadSupport = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.TvSeries});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("", "HomePage"), TuplesKt.to("movies", "Movies"), TuplesKt.to("web-series", "Web Series"), TuplesKt.to("dramas/korean-drama", "Korean Dramas"), TuplesKt.to("dramas/chinese-drama", "Chinese Dramas"), TuplesKt.to("anime", "Anime")});

    /* JADX INFO: renamed from: com.hindmoviez.Hindmoviez$getMainPage$1 */
    /* JADX INFO: compiled from: hindmoviez.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.hindmoviez.Hindmoviez", f = "hindmoviez.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {74, 77}, m = "getMainPage", n = {"request", "url", "page", "request", "url", "response", "page"}, nl = {75, 84}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "L$2", "I$0"}, v = 2)
    static final class C00021 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00021(Continuation<? super C00021> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Hindmoviez.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.hindmoviez.Hindmoviez$load$1 */
    /* JADX INFO: compiled from: hindmoviez.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.hindmoviez.Hindmoviez", f = "hindmoviez.kt", i = {0, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, l = {111, 116, 175, 190, 199, 226, 274, 279, 305, 332, 352}, m = "load", n = {"url", "url", "response", "url", "response", "finalResponse", "doc", "name", "imdbRating", "imdbId", "releaseYear", "docgenres", "title", "poster", "descriptions", "typeraw", "tvtype", "background", "description", "id", "$this$load_u24lambda_u243_u240", "url", "response", "finalResponse", "doc", "name", "imdbRating", "imdbId", "releaseYear", "docgenres", "title", "poster", "descriptions", "typeraw", "tvtype", "background", "description", "tmdbId", "it", "tmdbmetatype", "$this$load_u24lambda_u244_u240", "url", "response", "finalResponse", "doc", "name", "imdbRating", "imdbId", "releaseYear", "docgenres", "title", "poster", "descriptions", "typeraw", "tvtype", "background", "description", "tmdbId", "creditsJson", "castList", "url", "response", "finalResponse", "doc", "name", "imdbRating", "imdbId", "releaseYear", "docgenres", "title", "poster", "descriptions", "typeraw", "tvtype", "background", "description", "tmdbId", "creditsJson", "castList", "hrefs", "tmdbType", "id", "$this$load_u24lambda_u245_u240", "url", "response", "finalResponse", "doc", "name", "imdbRating", "imdbId", "releaseYear", "docgenres", "title", "poster", "descriptions", "typeraw", "tvtype", "background", "description", "tmdbId", "creditsJson", "castList", "hrefs", "tmdbType", "tmdbDetail", "logoUrl", "episodeUrlMap", "$this$forEach$iv", "element$iv", "h3", "p", "episodeListUrl", "seasonNumber", "url", "response", "finalResponse", "doc", "name", "imdbRating", "imdbId", "releaseYear", "docgenres", "title", "poster", "descriptions", "typeraw", "tvtype", "background", "description", "tmdbId", "creditsJson", "castList", "hrefs", "tmdbType", "tmdbDetail", "logoUrl", "episodeUrlMap", "$this$forEach$iv", "element$iv", "h3", "p", "episodeListUrl", "episodeDoc", "ajaxUrl", "seasonNumber", "url", "response", "finalResponse", "doc", "name", "imdbRating", "imdbId", "releaseYear", "docgenres", "title", "poster", "descriptions", "typeraw", "tvtype", "background", "description", "tmdbId", "creditsJson", "castList", "hrefs", "tmdbType", "tmdbDetail", "logoUrl", "episodeUrlMap", "seasonNumbers", "tmdbSeasonMap", "url", "response", "finalResponse", "doc", "name", "imdbRating", "imdbId", "releaseYear", "docgenres", "title", "poster", "descriptions", "typeraw", "tvtype", "background", "description", "tmdbId", "creditsJson", "castList", "hrefs", "tmdbType", "tmdbDetail", "logoUrl", "episodeUrlMap", "seasonNumbers", "tmdbSeasonMap", "tvDetail", "episodes", "url", "response", "finalResponse", "doc", "name", "imdbRating", "imdbId", "releaseYear", "docgenres", "title", "poster", "descriptions", "typeraw", "tvtype", "background", "description", "tmdbId", "creditsJson", "castList", "hrefs", "tmdbType", "tmdbDetail", "logoUrl", "movieDetail"}, nl = {113, 122, 179, 193, 217, 228, 275, 295, 314, 350, -1}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$26", "L$27", "L$28", "L$29", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$26", "L$27", "L$28", "L$29", "L$30", "L$31", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23"}, v = 2)
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
            return Hindmoviez.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.hindmoviez.Hindmoviez$loadLinks$1 */
    /* JADX INFO: compiled from: hindmoviez.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.hindmoviez.Hindmoviez", f = "hindmoviez.kt", i = {0, 0, 0, 0, 0}, l = {378}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "links", "isCasting"}, nl = {452}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0"}, v = 2)
    static final class C00081 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
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
            return Hindmoviez.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.hindmoviez.Hindmoviez$search$1 */
    /* JADX INFO: compiled from: hindmoviez.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.hindmoviez.Hindmoviez", f = "hindmoviez.kt", i = {0, 0}, l = {104}, m = "search", n = {"query", "page"}, nl = {105}, s = {"L$0", "I$0"}, v = 2)
    static final class C00111 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00111(Continuation<? super C00111> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Hindmoviez.this.search(null, 0, (Continuation) this);
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

    /* JADX WARN: Code duplicated, block: B:24:0x010f  */
    /* JADX WARN: Code duplicated, block: B:26:0x015e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:27:0x015f  */
    /* JADX WARN: Code duplicated, block: B:29:0x016e  */
    /* JADX WARN: Code duplicated, block: B:33:0x0199  */
    /* JADX WARN: Code duplicated, block: B:35:0x01af  */
    /* JADX WARN: Code duplicated, block: B:41:0x01b4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        C00021 c00021;
        Object obj;
        boolean z;
        C00021 c00022;
        Object obj2;
        String url;
        int page2;
        MainPageRequest request2;
        NiceResponse response;
        MainPageRequest request3;
        int page3;
        MainPageRequest request4;
        String url2;
        String url3;
        MainPageRequest request5;
        int page4;
        Collection destination$iv$iv;
        SearchResponse searchResult;
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
        Object $result = c00021.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00021.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String url4 = page == 1 ? getMainUrl() + '/' + request.getData() : getMainUrl() + '/' + request.getData() + "/page/" + page;
                Requests app = MainActivityKt.getApp();
                c00021.L$0 = request;
                c00021.L$1 = url4;
                c00021.I$0 = page;
                c00021.label = 1;
                String url5 = url4;
                C00021 c00023 = c00021;
                obj = coroutine_suspended;
                z = true;
                Object obj3 = Requests.get$default(app, url5, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 5000L, (Interceptor) null, false, (ResponseParser) null, c00023, 3838, (Object) null);
                c00022 = c00023;
                if (obj3 == obj) {
                    return obj;
                }
                obj2 = obj3;
                url = url5;
                page2 = page;
                request2 = request;
                response = (NiceResponse) obj2;
                if (StringsKt.contains(response.getText(), "Just a moment", z)) {
                    Requests app2 = MainActivityKt.getApp();
                    Interceptor cloudflareKiller = new CloudflareKiller();
                    c00022.L$0 = request2;
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(url);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(response);
                    c00022.I$0 = page2;
                    c00022.label = 2;
                    page3 = page2;
                    request4 = request2;
                    url2 = url;
                    $result = Requests.get$default(app2, url2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 5000L, cloudflareKiller, false, (ResponseParser) null, c00022, 3326, (Object) null);
                    if ($result == obj) {
                        return obj;
                    }
                    url3 = url2;
                    request5 = request4;
                    page4 = page3;
                    response = (NiceResponse) $result;
                    request3 = request5;
                } else {
                    request3 = request2;
                }
                Document doc = response.getDocument();
                Iterable $this$mapNotNull$iv = doc.select("article");
                destination$iv$iv = new ArrayList();
                for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                    Element it = (Element) element$iv$iv$iv;
                    searchResult = toSearchResult(it);
                    if (searchResult != null) {
                        destination$iv$iv.add(searchResult);
                    }
                }
                List home = (List) destination$iv$iv;
                return MainAPIKt.newHomePageResponse(request3.getName(), home, Boxing.boxBoolean(true));
            case 1:
                int page5 = c00021.I$0;
                String url6 = (String) c00021.L$1;
                MainPageRequest request6 = (MainPageRequest) c00021.L$0;
                ResultKt.throwOnFailure($result);
                obj2 = $result;
                z = true;
                page2 = page5;
                obj = coroutine_suspended;
                request2 = request6;
                url = url6;
                c00022 = c00021;
                response = (NiceResponse) obj2;
                if (StringsKt.contains(response.getText(), "Just a moment", z)) {
                    Requests app3 = MainActivityKt.getApp();
                    Interceptor cloudflareKiller2 = new CloudflareKiller();
                    c00022.L$0 = request2;
                    c00022.L$1 = SpillingKt.nullOutSpilledVariable(url);
                    c00022.L$2 = SpillingKt.nullOutSpilledVariable(response);
                    c00022.I$0 = page2;
                    c00022.label = 2;
                    page3 = page2;
                    request4 = request2;
                    url2 = url;
                    $result = Requests.get$default(app3, url2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 5000L, cloudflareKiller2, false, (ResponseParser) null, c00022, 3326, (Object) null);
                    if ($result == obj) {
                        return obj;
                    }
                    url3 = url2;
                    request5 = request4;
                    page4 = page3;
                    response = (NiceResponse) $result;
                    request3 = request5;
                } else {
                    request3 = request2;
                }
                Document doc2 = response.getDocument();
                Iterable $this$mapNotNull$iv2 = doc2.select("article");
                destination$iv$iv = new ArrayList();
                while (r14.hasNext()) {
                    Element it2 = (Element) element$iv$iv$iv;
                    searchResult = toSearchResult(it2);
                    if (searchResult != null) {
                        destination$iv$iv.add(searchResult);
                    }
                }
                List home2 = (List) destination$iv$iv;
                return MainAPIKt.newHomePageResponse(request3.getName(), home2, Boxing.boxBoolean(true));
            case 2:
                page4 = c00021.I$0;
                url3 = (String) c00021.L$1;
                request5 = (MainPageRequest) c00021.L$0;
                ResultKt.throwOnFailure($result);
                response = (NiceResponse) $result;
                request3 = request5;
                Document doc3 = response.getDocument();
                Iterable $this$mapNotNull$iv3 = doc3.select("article");
                destination$iv$iv = new ArrayList();
                while (r14.hasNext()) {
                    Element it3 = (Element) element$iv$iv$iv;
                    searchResult = toSearchResult(it3);
                    if (searchResult != null) {
                        destination$iv$iv.add(searchResult);
                    }
                }
                List home3 = (List) destination$iv$iv;
                return MainAPIKt.newHomePageResponse(request3.getName(), home3, Boxing.boxBoolean(true));
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final SearchResponse toSearchResult(Element $this$toSearchResult) {
        Element elementSelectFirst = $this$toSearchResult.selectFirst("h2.entry-title a");
        final String title = UtilsKt.cleanTitle(elementSelectFirst != null ? elementSelectFirst.text() : null);
        String href = MainAPIKt.fixUrl(this, $this$toSearchResult.select("a").attr("href"));
        Hindmoviez hindmoviez = this;
        Elements img = $this$toSearchResult.select("header.entry-header img");
        String it = img.attr("data-src");
        String strAttr = StringsKt.isBlank(it) ? null : it;
        if (strAttr == null) {
            strAttr = img.attr("src");
        }
        final String posterUrl = MainAPIKt.fixUrlNull(hindmoviez, strAttr);
        return MainAPIKt.newMovieSearchResponse$default(this, title, href, TvType.Movie, false, new Function1() { // from class: com.hindmoviez.Hindmoviez$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return Hindmoviez.toSearchResult$lambda$1(posterUrl, title, (MovieSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResult$lambda$1(String $posterUrl, String $title, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($posterUrl);
        $this$newMovieSearchResponse.setQuality(UtilsKt.getSearchQuality($title));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object search(@NotNull String query, int page, @NotNull Continuation<? super SearchResponseList> continuation) {
        C00111 c00111;
        if (continuation instanceof C00111) {
            c00111 = (C00111) continuation;
            if ((c00111.label & Integer.MIN_VALUE) != 0) {
                c00111.label -= Integer.MIN_VALUE;
            } else {
                c00111 = new C00111(continuation);
            }
        } else {
            c00111 = new C00111(continuation);
        }
        Object $result = c00111.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00111.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                String str = getMainUrl() + "/page/" + page + "/?s=" + query;
                c00111.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00111.I$0 = page;
                c00111.label = 1;
                $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00111, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                int i = c00111.I$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document doc = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv = doc.select("article");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Element it = (Element) element$iv$iv$iv;
            SearchResponse searchResult = toSearchResult(it);
            if (searchResult != null) {
                destination$iv$iv.add(searchResult);
            }
        }
        List res = (List) destination$iv$iv;
        return MainAPIKt.toNewSearchResponseList$default(res, (Boolean) null, 1, (Object) null);
    }

    /* JADX WARN: Code duplicated, block: B:176:0x0b8b A[Catch: all -> 0x0bb9, TryCatch #14 {all -> 0x0bb9, blocks: (B:162:0x0b54, B:166:0x0b6a, B:168:0x0b70, B:187:0x0bb3, B:176:0x0b8b, B:178:0x0b93, B:180:0x0b9a), top: B:843:0x0b54 }] */
    /* JADX WARN: Code duplicated, block: B:186:0x0bb2  */
    /* JADX WARN: Code duplicated, block: B:397:0x14ab  */
    /* JADX WARN: Code duplicated, block: B:462:0x15d6  */
    /* JADX WARN: Code duplicated, block: B:586:0x1808  */
    /* JADX WARN: Code duplicated, block: B:588:0x1838  */
    /* JADX WARN: Code duplicated, block: B:650:0x1c28 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:628:0x1a0d -> B:653:0x1c42). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:632:0x1adc -> B:633:0x1afb). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:652:0x1c36 -> B:653:0x1c42). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object load(@org.jetbrains.annotations.NotNull java.lang.String r74, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r75) {
        /*
            Method dump skipped, instruction units count: 8802
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hindmoviez.Hindmoviez.load(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.hindmoviez.Hindmoviez$load$6 */
    /* JADX INFO: compiled from: hindmoviez.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "s", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.hindmoviez.Hindmoviez$load$6", f = "hindmoviez.kt", i = {0, 0}, l = {307}, m = "invokeSuspend", n = {"$this$invokeSuspend_u24lambda_u240", "s"}, nl = {308}, s = {"L$0", "I$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nhindmoviez.kt\nKotlin\n*S Kotlin\n*F\n+ 1 hindmoviez.kt\ncom/hindmoviez/Hindmoviez$load$6\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,454:1\n1#2:455\n1#2:459\n93#3,2:456\n63#3:458\n64#3,15:460\n95#3,2:477\n50#4:475\n43#4:476\n*S KotlinDebug\n*F\n+ 1 hindmoviez.kt\ncom/hindmoviez/Hindmoviez$load$6\n*L\n308#1:459\n308#1:456,2\n308#1:458\n308#1:460,15\n308#1:477,2\n308#1:475\n308#1:476\n*E\n"})
    static final class C00046 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $tmdbId;
        final /* synthetic */ Map<Integer, TmdbSeasonDetail> $tmdbSeasonMap;
        /* synthetic */ int I$0;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00046(Map<Integer, TmdbSeasonDetail> map, String str, Continuation<? super C00046> continuation) {
            super(2, continuation);
            this.$tmdbSeasonMap = map;
            this.$tmdbId = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00046 = Hindmoviez.this.new C00046(this.$tmdbSeasonMap, this.$tmdbId, continuation);
            c00046.I$0 = ((Number) obj).intValue();
            return c00046;
        }

        public final Object invoke(int i, Continuation<? super Unit> continuation) {
            return create(Integer.valueOf(i), continuation).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke(((Number) obj).intValue(), (Continuation<? super Unit>) obj2);
        }

        /* JADX WARN: Code duplicated, block: B:21:0x00b4  */
        /* JADX WARN: Code duplicated, block: B:22:0x00b7  */
        /* JADX WARN: Code duplicated, block: B:36:0x0111  */
        /* JADX WARN: Code duplicated, block: B:46:0x012d A[Catch: Exception -> 0x0143, all -> 0x014e, TRY_LEAVE, TryCatch #7 {Exception -> 0x0143, blocks: (B:27:0x00dd, B:34:0x010b, B:37:0x0112, B:46:0x012d, B:45:0x0127, B:33:0x0100, B:26:0x00d3), top: B:84:0x00d3 }] */
        /* JADX WARN: Code duplicated, block: B:63:0x016a  */
        /* JADX WARN: Code duplicated, block: B:66:0x0173  */
        /* JADX WARN: Code duplicated, block: B:88:0x00e4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:90:0x0118 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        public final Object invokeSuspend(Object $result) {
            C00046 c00046;
            int s;
            List list;
            Object obj;
            Object obj2;
            Object obj3;
            TmdbSeasonDetail detail;
            Map<Integer, TmdbSeasonDetail> map;
            Map<Integer, TmdbSeasonDetail> map2;
            String it;
            Object obj4;
            Object objDecodeFromString;
            DeserializationStrategy deserializationStrategy;
            int s2 = this.I$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Hindmoviez $this$invokeSuspend_u24lambda_u240 = Hindmoviez.this;
                    String str = this.$tmdbId;
                    try {
                        Result.Companion companion = Result.Companion;
                        Requests app = MainActivityKt.getApp();
                        String str2 = "https://api.themoviedb.org/3/tv/" + str + "/season/" + s2 + "?api_key=1865f43a0549ca50d341dd9ab8b29f49&language=en-US";
                        this.L$0 = SpillingKt.nullOutSpilledVariable($this$invokeSuspend_u24lambda_u240);
                        this.I$0 = s2;
                        this.label = 1;
                        s = s2;
                        list = null;
                        try {
                            obj = Requests.get$default(app, str2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, this, 4094, (Object) null);
                            c00046 = this;
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            try {
                                it = ((NiceResponse) obj).getText();
                                AppUtils appUtils = AppUtils.INSTANCE;
                                if (it == null) {
                                    objDecodeFromString = list;
                                } else {
                                    try {
                                        Result.Companion companion2 = Result.Companion;
                                        KType kTypeTypeOf = Reflection.typeOf(TmdbSeasonDetail.class);
                                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                        obj4 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                                        break;
                                    } catch (Throwable th) {
                                        try {
                                            Result.Companion companion3 = Result.Companion;
                                            obj4 = Result.constructor-impl(ResultKt.createFailure(th));
                                        } catch (Exception e) {
                                            objDecodeFromString = list;
                                        }
                                    }
                                    if (Result.exceptionOrNull-impl(obj4) != null) {
                                        try {
                                            Result.Companion companion4 = Result.Companion;
                                            obj4 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(TmdbSeasonDetail.class), list, 2, list));
                                        } catch (Throwable th2) {
                                            Result.Companion companion5 = Result.Companion;
                                            obj4 = Result.constructor-impl(ResultKt.createFailure(th2));
                                        }
                                    }
                                    if (Result.isFailure-impl(obj4)) {
                                        obj4 = list;
                                    }
                                    deserializationStrategy = (KSerializer) obj4;
                                    if (deserializationStrategy != null) {
                                        try {
                                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, it);
                                        } catch (SerializationException e2) {
                                            ArchComponentExtKt.logError(e2);
                                            ObjectMapper $this$readValue$iv$iv$iv = MainAPIKt.getMapper();
                                            objDecodeFromString = $this$readValue$iv$iv$iv.readValue(it, new TypeReference<TmdbSeasonDetail>() { // from class: com.hindmoviez.Hindmoviez$load$6$invokeSuspend$lambda$0$0$$inlined$tryParseJson$1
                                            });
                                        } catch (Throwable th3) {
                                            ObjectMapper $this$readValue$iv$iv$iv2 = MainAPIKt.getMapper();
                                            objDecodeFromString = $this$readValue$iv$iv$iv2.readValue(it, new TypeReference<TmdbSeasonDetail>() { // from class: com.hindmoviez.Hindmoviez$load$6$invokeSuspend$lambda$0$0$$inlined$tryParseJson$1
                                            });
                                        }
                                    } else {
                                        ObjectMapper $this$readValue$iv$iv$iv3 = MainAPIKt.getMapper();
                                        objDecodeFromString = $this$readValue$iv$iv$iv3.readValue(it, new TypeReference<TmdbSeasonDetail>() { // from class: com.hindmoviez.Hindmoviez$load$6$invokeSuspend$lambda$0$0$$inlined$tryParseJson$1
                                        });
                                    }
                                }
                                obj2 = Result.constructor-impl((TmdbSeasonDetail) objDecodeFromString);
                            } catch (Throwable th4) {
                                th = th4;
                                Result.Companion companion6 = Result.Companion;
                                obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            c00046 = this;
                            Result.Companion companion7 = Result.Companion;
                            obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                            obj3 = obj2;
                            if (Result.isFailure-impl(obj3)) {
                                obj3 = list;
                            }
                            detail = (TmdbSeasonDetail) obj3;
                            map = c00046.$tmdbSeasonMap;
                            map2 = c00046.$tmdbSeasonMap;
                            synchronized (map) {
                                map2.put(Boxing.boxInt(s), detail);
                                Unit unit = Unit.INSTANCE;
                                return Unit.INSTANCE;
                            }
                        }
                        break;
                    } catch (Throwable th6) {
                        th = th6;
                        c00046 = this;
                        s = s2;
                        list = null;
                    }
                    obj3 = obj2;
                    if (Result.isFailure-impl(obj3)) {
                        obj3 = list;
                    }
                    detail = (TmdbSeasonDetail) obj3;
                    map = c00046.$tmdbSeasonMap;
                    map2 = c00046.$tmdbSeasonMap;
                    synchronized (map) {
                        map2.put(Boxing.boxInt(s), detail);
                        Unit unit2 = Unit.INSTANCE;
                    }
                    return Unit.INSTANCE;
                case 1:
                    try {
                        ResultKt.throwOnFailure($result);
                        s = s2;
                        obj = $result;
                        c00046 = this;
                        list = null;
                        it = ((NiceResponse) obj).getText();
                        AppUtils appUtils2 = AppUtils.INSTANCE;
                        if (it == null) {
                            objDecodeFromString = list;
                        } else {
                            Result.Companion companion8 = Result.Companion;
                            KType kTypeTypeOf2 = Reflection.typeOf(TmdbSeasonDetail.class);
                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                            obj4 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                            if (Result.exceptionOrNull-impl(obj4) != null) {
                                Result.Companion companion9 = Result.Companion;
                                obj4 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(TmdbSeasonDetail.class), list, 2, list));
                            }
                            if (Result.isFailure-impl(obj4)) {
                                obj4 = list;
                            }
                            deserializationStrategy = (KSerializer) obj4;
                            if (deserializationStrategy != null) {
                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, it);
                            } else {
                                ObjectMapper $this$readValue$iv$iv$iv4 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv$iv4.readValue(it, new TypeReference<TmdbSeasonDetail>() { // from class: com.hindmoviez.Hindmoviez$load$6$invokeSuspend$lambda$0$0$$inlined$tryParseJson$1
                                });
                            }
                        }
                        obj2 = Result.constructor-impl((TmdbSeasonDetail) objDecodeFromString);
                        break;
                    } catch (Throwable th7) {
                        th = th7;
                        c00046 = this;
                        s = s2;
                        list = null;
                        Result.Companion companion10 = Result.Companion;
                        obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                        obj3 = obj2;
                        if (Result.isFailure-impl(obj3)) {
                            obj3 = list;
                        }
                        detail = (TmdbSeasonDetail) obj3;
                        map = c00046.$tmdbSeasonMap;
                        map2 = c00046.$tmdbSeasonMap;
                        synchronized (map) {
                            map2.put(Boxing.boxInt(s), detail);
                            Unit unit3 = Unit.INSTANCE;
                            return Unit.INSTANCE;
                        }
                    }
                    obj3 = obj2;
                    if (Result.isFailure-impl(obj3)) {
                        obj3 = list;
                    }
                    detail = (TmdbSeasonDetail) obj3;
                    map = c00046.$tmdbSeasonMap;
                    map2 = c00046.$tmdbSeasonMap;
                    synchronized (map) {
                        map2.put(Boxing.boxInt(s), detail);
                        Unit unit4 = Unit.INSTANCE;
                        return Unit.INSTANCE;
                    }
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$15$1(TmdbEpisode $metaEp, int $seasonNumber, int $episodeNumber, Episode $this$newEpisode) {
        String it;
        Double vote_average;
        String it2;
        $this$newEpisode.setName($metaEp != null ? $metaEp.getName() : null);
        $this$newEpisode.setSeason(Integer.valueOf($seasonNumber));
        $this$newEpisode.setEpisode(Integer.valueOf($episodeNumber));
        if ($metaEp == null || (it2 = $metaEp.getStill_path()) == null) {
            it = null;
        } else {
            it = TMDB_IMG + it2;
        }
        $this$newEpisode.setPosterUrl(it);
        $this$newEpisode.setDescription($metaEp != null ? $metaEp.getOverview() : null);
        $this$newEpisode.setScore(Score.Companion.from10(($metaEp == null || (vote_average = $metaEp.getVote_average()) == null) ? null : String.valueOf(vote_average.doubleValue())));
        MainAPIKt.addDate$default($this$newEpisode, $metaEp != null ? $metaEp.getAir_date() : null, (String) null, 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.hindmoviez.Hindmoviez$load$7 */
    /* JADX INFO: compiled from: hindmoviez.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.hindmoviez.Hindmoviez$load$7", f = "hindmoviez.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nhindmoviez.kt\nKotlin\n*S Kotlin\n*F\n+ 1 hindmoviez.kt\ncom/hindmoviez/Hindmoviez$load$7\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,454:1\n1#2:455\n1#2:467\n1795#3,10:456\n2068#3:466\n2069#3:468\n1805#3:469\n*S KotlinDebug\n*F\n+ 1 hindmoviez.kt\ncom/hindmoviez/Hindmoviez$load$7\n*L\n342#1:467\n342#1:456,10\n342#1:466\n342#1:468\n342#1:469\n*E\n"})
    static final class C00067 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<String> $background;
        final /* synthetic */ List<ActorData> $castList;
        final /* synthetic */ Ref.ObjectRef<String> $description;
        final /* synthetic */ Ref.ObjectRef<List<String>> $docgenres;
        final /* synthetic */ Ref.ObjectRef<String> $imdbId;
        final /* synthetic */ Ref.ObjectRef<String> $imdbRating;
        final /* synthetic */ String $logoUrl;
        final /* synthetic */ String $poster;
        final /* synthetic */ Ref.ObjectRef<String> $releaseYear;
        final /* synthetic */ TmdbTvDetail $tvDetail;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00067(Ref.ObjectRef<String> objectRef, String str, Ref.ObjectRef<String> objectRef2, TmdbTvDetail tmdbTvDetail, Ref.ObjectRef<String> objectRef3, Ref.ObjectRef<List<String>> objectRef4, List<ActorData> list, String str2, Ref.ObjectRef<String> objectRef5, Ref.ObjectRef<String> objectRef6, Continuation<? super C00067> continuation) {
            super(2, continuation);
            this.$background = objectRef;
            this.$poster = str;
            this.$releaseYear = objectRef2;
            this.$tvDetail = tmdbTvDetail;
            this.$description = objectRef3;
            this.$docgenres = objectRef4;
            this.$castList = list;
            this.$logoUrl = str2;
            this.$imdbRating = objectRef5;
            this.$imdbId = objectRef6;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00067 = new C00067(this.$background, this.$poster, this.$releaseYear, this.$tvDetail, this.$description, this.$docgenres, this.$castList, this.$logoUrl, this.$imdbRating, this.$imdbId, continuation);
            c00067.L$0 = obj;
            return c00067;
        }

        public final Object invoke(TvSeriesLoadResponse tvSeriesLoadResponse, Continuation<? super Unit> continuation) {
            return create(tvSeriesLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Integer intOrNull;
            String first_air_date;
            String strTake;
            Double vote_average;
            Iterable genres;
            LoadResponse loadResponse = (TvSeriesLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    loadResponse.setBackgroundPosterUrl((String) this.$background.element);
                    loadResponse.setPosterUrl(this.$poster);
                    String str = (String) this.$releaseYear.element;
                    String strValueOf = null;
                    if (str == null || (intOrNull = StringsKt.toIntOrNull(str)) == null) {
                        TmdbTvDetail tmdbTvDetail = this.$tvDetail;
                        intOrNull = (tmdbTvDetail == null || (first_air_date = tmdbTvDetail.getFirst_air_date()) == null || (strTake = StringsKt.take(first_air_date, 4)) == null) ? null : StringsKt.toIntOrNull(strTake);
                    }
                    loadResponse.setYear(intOrNull);
                    String plot = (String) this.$description.element;
                    if (plot == null) {
                        plot = loadResponse.getPlot();
                    }
                    loadResponse.setPlot(plot);
                    Collection collection = (Collection) this.$docgenres.element;
                    TmdbTvDetail tmdbTvDetail2 = this.$tvDetail;
                    if (collection.isEmpty()) {
                        if (tmdbTvDetail2 == null || (genres = tmdbTvDetail2.getGenres()) == null) {
                            collection = null;
                        } else {
                            Iterable $this$mapNotNull$iv = genres;
                            Collection destination$iv$iv = new ArrayList();
                            for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                                TmdbGenre it = (TmdbGenre) element$iv$iv$iv;
                                String name = it.getName();
                                if (name != null) {
                                    destination$iv$iv.add(name);
                                }
                            }
                            collection = (List) destination$iv$iv;
                        }
                    }
                    loadResponse.setTags((List) collection);
                    loadResponse.setActors(this.$castList);
                    try {
                        loadResponse.setLogoUrl(this.$logoUrl);
                        break;
                    } catch (Throwable th) {
                    }
                    Score.Companion companion = Score.Companion;
                    String str2 = (String) this.$imdbRating.element;
                    if (str2 == null) {
                        TmdbTvDetail tmdbTvDetail3 = this.$tvDetail;
                        if (tmdbTvDetail3 != null && (vote_average = tmdbTvDetail3.getVote_average()) != null) {
                            strValueOf = String.valueOf(vote_average.doubleValue());
                        }
                    } else {
                        strValueOf = str2;
                    }
                    loadResponse.setScore(companion.from10(strValueOf));
                    LoadResponse.Companion.addImdbId(loadResponse, (String) this.$imdbId.element);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.hindmoviez.Hindmoviez$load$8 */
    /* JADX INFO: compiled from: hindmoviez.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.hindmoviez.Hindmoviez$load$8", f = "hindmoviez.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nhindmoviez.kt\nKotlin\n*S Kotlin\n*F\n+ 1 hindmoviez.kt\ncom/hindmoviez/Hindmoviez$load$8\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,454:1\n1#2:455\n1#2:467\n1795#3,10:456\n2068#3:466\n2069#3:468\n1805#3:469\n*S KotlinDebug\n*F\n+ 1 hindmoviez.kt\ncom/hindmoviez/Hindmoviez$load$8\n*L\n362#1:467\n362#1:456,10\n362#1:466\n362#1:468\n362#1:469\n*E\n"})
    static final class C00078 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<String> $background;
        final /* synthetic */ List<ActorData> $castList;
        final /* synthetic */ Ref.ObjectRef<String> $description;
        final /* synthetic */ Ref.ObjectRef<List<String>> $docgenres;
        final /* synthetic */ Ref.ObjectRef<String> $imdbId;
        final /* synthetic */ Ref.ObjectRef<String> $imdbRating;
        final /* synthetic */ String $logoUrl;
        final /* synthetic */ TmdbMovieDetail $movieDetail;
        final /* synthetic */ String $poster;
        final /* synthetic */ Ref.ObjectRef<String> $releaseYear;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00078(Ref.ObjectRef<String> objectRef, String str, Ref.ObjectRef<String> objectRef2, TmdbMovieDetail tmdbMovieDetail, Ref.ObjectRef<String> objectRef3, Ref.ObjectRef<List<String>> objectRef4, List<ActorData> list, String str2, Ref.ObjectRef<String> objectRef5, Ref.ObjectRef<String> objectRef6, Continuation<? super C00078> continuation) {
            super(2, continuation);
            this.$background = objectRef;
            this.$poster = str;
            this.$releaseYear = objectRef2;
            this.$movieDetail = tmdbMovieDetail;
            this.$description = objectRef3;
            this.$docgenres = objectRef4;
            this.$castList = list;
            this.$logoUrl = str2;
            this.$imdbRating = objectRef5;
            this.$imdbId = objectRef6;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00078 = new C00078(this.$background, this.$poster, this.$releaseYear, this.$movieDetail, this.$description, this.$docgenres, this.$castList, this.$logoUrl, this.$imdbRating, this.$imdbId, continuation);
            c00078.L$0 = obj;
            return c00078;
        }

        public final Object invoke(MovieLoadResponse movieLoadResponse, Continuation<? super Unit> continuation) {
            return create(movieLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Integer intOrNull;
            String release_date;
            String strTake;
            Double vote_average;
            Iterable genres;
            LoadResponse loadResponse = (MovieLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    loadResponse.setBackgroundPosterUrl((String) this.$background.element);
                    loadResponse.setPosterUrl(this.$poster);
                    String str = (String) this.$releaseYear.element;
                    String strValueOf = null;
                    if (str == null || (intOrNull = StringsKt.toIntOrNull(str)) == null) {
                        TmdbMovieDetail tmdbMovieDetail = this.$movieDetail;
                        intOrNull = (tmdbMovieDetail == null || (release_date = tmdbMovieDetail.getRelease_date()) == null || (strTake = StringsKt.take(release_date, 4)) == null) ? null : StringsKt.toIntOrNull(strTake);
                    }
                    loadResponse.setYear(intOrNull);
                    String plot = (String) this.$description.element;
                    if (plot == null) {
                        plot = loadResponse.getPlot();
                    }
                    loadResponse.setPlot(plot);
                    Collection collection = (Collection) this.$docgenres.element;
                    TmdbMovieDetail tmdbMovieDetail2 = this.$movieDetail;
                    if (collection.isEmpty()) {
                        if (tmdbMovieDetail2 == null || (genres = tmdbMovieDetail2.getGenres()) == null) {
                            collection = null;
                        } else {
                            Iterable $this$mapNotNull$iv = genres;
                            Collection destination$iv$iv = new ArrayList();
                            for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                                TmdbGenre it = (TmdbGenre) element$iv$iv$iv;
                                String name = it.getName();
                                if (name != null) {
                                    destination$iv$iv.add(name);
                                }
                            }
                            collection = (List) destination$iv$iv;
                        }
                    }
                    loadResponse.setTags((List) collection);
                    loadResponse.setActors(this.$castList);
                    try {
                        loadResponse.setLogoUrl(this.$logoUrl);
                        break;
                    } catch (Throwable th) {
                    }
                    Score.Companion companion = Score.Companion;
                    String str2 = (String) this.$imdbRating.element;
                    if (str2 == null) {
                        TmdbMovieDetail tmdbMovieDetail3 = this.$movieDetail;
                        if (tmdbMovieDetail3 != null && (vote_average = tmdbMovieDetail3.getVote_average()) != null) {
                            strValueOf = String.valueOf(vote_average.doubleValue());
                        }
                    } else {
                        strValueOf = str2;
                    }
                    loadResponse.setScore(companion.from10(strValueOf));
                    LoadResponse.Companion.addImdbId(loadResponse, (String) this.$imdbId.element);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00081 c00081;
        boolean z;
        Object obj;
        Object obj2;
        Object objDecodeFromString;
        boolean z2;
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
                AppUtils appUtils = AppUtils.INSTANCE;
                if (data == null) {
                    obj2 = null;
                    z = true;
                } else {
                    try {
                        Result.Companion companion = Result.Companion;
                        z = true;
                        try {
                            KType kTypeTypeOf = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(HindmoviezLinkData.class)));
                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                            obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                            break;
                        } catch (Throwable th) {
                            th = th;
                            try {
                                Result.Companion companion2 = Result.Companion;
                                obj = Result.constructor-impl(ResultKt.createFailure(th));
                            } catch (Exception e) {
                                obj2 = null;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        z = true;
                    }
                    if (Result.exceptionOrNull-impl(obj) != null) {
                        try {
                            Result.Companion companion3 = Result.Companion;
                            obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                        } catch (Throwable th3) {
                            Result.Companion companion4 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th3));
                        }
                    }
                    DeserializationStrategy deserializationStrategy = (KSerializer) (Result.isFailure-impl(obj) ? null : obj);
                    if (deserializationStrategy != null) {
                        try {
                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, data);
                        } catch (SerializationException e2) {
                            ArchComponentExtKt.logError(e2);
                            ObjectMapper $this$readValue$iv$iv$iv = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv$iv.readValue(data, new TypeReference<List<? extends HindmoviezLinkData>>() { // from class: com.hindmoviez.Hindmoviez$loadLinks$$inlined$tryParseJson$1
                            });
                        } catch (Throwable th4) {
                            ObjectMapper $this$readValue$iv$iv$iv2 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv$iv2.readValue(data, new TypeReference<List<? extends HindmoviezLinkData>>() { // from class: com.hindmoviez.Hindmoviez$loadLinks$$inlined$tryParseJson$1
                            });
                        }
                    } else {
                        ObjectMapper $this$readValue$iv$iv$iv3 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv$iv3.readValue(data, new TypeReference<List<? extends HindmoviezLinkData>>() { // from class: com.hindmoviez.Hindmoviez$loadLinks$$inlined$tryParseJson$1
                        });
                    }
                    obj2 = objDecodeFromString;
                }
                List links = (List) obj2;
                if (links == null) {
                    return Boxing.boxBoolean(z);
                }
                C00092 c00092 = new C00092(function1, function2, null);
                c00082.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00082.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                c00082.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                c00082.L$3 = SpillingKt.nullOutSpilledVariable(links);
                c00082.Z$0 = isCasting;
                z2 = true;
                c00082.label = 1;
                if (ParCollectionsKt.amap(links, c00092, c00082) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                boolean z3 = c00082.Z$0;
                ResultKt.throwOnFailure($result);
                z2 = true;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Boxing.boxBoolean(z2);
    }

    /* JADX INFO: renamed from: com.hindmoviez.Hindmoviez$loadLinks$2 */
    /* JADX INFO: compiled from: hindmoviez.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "linkData", "Lcom/hindmoviez/HindmoviezLinkData;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.hindmoviez.Hindmoviez$loadLinks$2", f = "hindmoviez.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2}, l = {382, 396, 417}, m = "invokeSuspend", n = {"linkData", "encoded", "linkData", "encoded", "signedUrl", "linkData", "encoded", "signedUrl", "pageDoc", "name", "extractedSpecs", "fileSize", "btnUrls"}, nl = {389, 397, 450}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7"}, v = 2)
    @SourceDebugExtension({"SMAP\nhindmoviez.kt\nKotlin\n*S Kotlin\n*F\n+ 1 hindmoviez.kt\ncom/hindmoviez/Hindmoviez$loadLinks$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,454:1\n1#2:455\n1#2:459\n1#2:490\n93#3,2:456\n63#3:458\n64#3,15:460\n95#3,2:477\n50#4:475\n43#4:476\n1795#5,10:479\n2068#5:489\n2069#5:491\n1805#5:492\n*S KotlinDebug\n*F\n+ 1 hindmoviez.kt\ncom/hindmoviez/Hindmoviez$loadLinks$2\n*L\n389#1:459\n415#1:490\n389#1:456,2\n389#1:458\n389#1:460,15\n389#1:477,2\n389#1:475\n389#1:476\n415#1:479,10\n415#1:489\n415#1:491\n415#1:492\n*E\n"})
    static final class C00092 extends SuspendLambda implements Function2<HindmoviezLinkData, Continuation<? super Unit>, Object> {
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
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00092(Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super C00092> continuation) {
            super(2, continuation);
            this.$subtitleCallback = function1;
            this.$callback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00092 = new C00092(this.$subtitleCallback, this.$callback, continuation);
            c00092.L$0 = obj;
            return c00092;
        }

        public final Object invoke(HindmoviezLinkData hindmoviezLinkData, Continuation<? super Unit> continuation) {
            return create(hindmoviezLinkData, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:105:0x0294 A[ADDED_TO_REGION, REMOVE] */
        /* JADX WARN: Code duplicated, block: B:108:0x0298  */
        /* JADX WARN: Code duplicated, block: B:109:0x029a  */
        /* JADX WARN: Code duplicated, block: B:113:0x02bb  */
        /* JADX WARN: Code duplicated, block: B:116:0x02e0  */
        /* JADX WARN: Code duplicated, block: B:118:0x02e3  */
        /* JADX WARN: Code duplicated, block: B:122:0x033c A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:123:0x033d  */
        /* JADX WARN: Code duplicated, block: B:148:0x011c A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:152:0x015a A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:156:0x02e7 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:24:0x00e2  */
        /* JADX WARN: Code duplicated, block: B:25:0x00e9  */
        /* JADX WARN: Code duplicated, block: B:32:0x0117  */
        /* JADX WARN: Code duplicated, block: B:44:0x0153  */
        /* JADX WARN: Code duplicated, block: B:54:0x016f A[Catch: Exception -> 0x0189, TRY_LEAVE, TryCatch #3 {Exception -> 0x0189, blocks: (B:42:0x014d, B:45:0x0154, B:54:0x016f, B:53:0x0169, B:41:0x0143, B:48:0x015a), top: B:135:0x0143, inners: #13 }] */
        /* JADX WARN: Code duplicated, block: B:65:0x0198 A[Catch: Exception -> 0x01be, TryCatch #6 {Exception -> 0x01be, blocks: (B:63:0x0192, B:65:0x0198, B:67:0x019e, B:69:0x01a4), top: B:140:0x0192 }] */
        /* JADX WARN: Code duplicated, block: B:69:0x01a4 A[Catch: Exception -> 0x01be, TRY_LEAVE, TryCatch #6 {Exception -> 0x01be, blocks: (B:63:0x0192, B:65:0x0198, B:67:0x019e, B:69:0x01a4), top: B:140:0x0192 }] */
        /* JADX WARN: Code duplicated, block: B:79:0x021c A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:80:0x021d  */
        /* JADX WARN: Code duplicated, block: B:84:0x0233  */
        /* JADX WARN: Code duplicated, block: B:89:0x024f  */
        /* JADX WARN: Code duplicated, block: B:92:0x0254  */
        /* JADX WARN: Code duplicated, block: B:95:0x025f  */
        /* JADX WARN: Code duplicated, block: B:96:0x0268  */
        /* JADX WARN: Code duplicated, block: B:99:0x0276  */
        public final Object invokeSuspend(Object $result) {
            String encoded;
            Object objPost$default;
            HindmoviezLinkData linkData;
            String url;
            String signedUrl;
            Object obj;
            String encoded2;
            String encoded3;
            String it;
            Object obj2;
            Object objDecodeFromString;
            DeserializationStrategy deserializationStrategy;
            HindmoviezSignResponse response;
            HindmoviezSignData data;
            Element elementSelectFirst;
            String string;
            String name;
            String strBuildExtractedTitle;
            String extractedSpecs;
            Element elementSelectFirst2;
            String str;
            String string2;
            String fileSize;
            Iterable $this$mapNotNull$iv;
            Collection destination$iv$iv;
            List btnUrls;
            String url2;
            String strText;
            String strText2;
            String strSubstringAfter$default;
            HindmoviezLinkData linkData2 = (HindmoviezLinkData) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    encoded = UtilsKt.hindmoviezBase64Url(linkData2.getRawId());
                    try {
                        Requests app = MainActivityKt.getApp();
                        String ajaxUrl = linkData2.getAjaxUrl();
                        Map mapMapOf = MapsKt.mapOf(TuplesKt.to("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/149.0.0.0 Safari/537.36"));
                        Pair[] pairArr = {TuplesKt.to("action", "hindshare_sign"), TuplesKt.to("d", encoded)};
                        this.L$0 = linkData2;
                        this.L$1 = encoded;
                        this.label = 1;
                        objPost$default = Requests.post$default(app, ajaxUrl, mapMapOf, (String) null, (Map) null, (Map) null, MapsKt.mapOf(pairArr), (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 65500, (Object) null);
                        if (objPost$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        it = ((NiceResponse) objPost$default).getText();
                        AppUtils appUtils = AppUtils.INSTANCE;
                        if (it == null) {
                            linkData = linkData2;
                            objDecodeFromString = null;
                        } else {
                            try {
                                try {
                                    Result.Companion companion = Result.Companion;
                                    KType kTypeTypeOf = Reflection.typeOf(HindmoviezSignResponse.class);
                                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                    obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                                } catch (Throwable th) {
                                    Result.Companion companion2 = Result.Companion;
                                    obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                                }
                                if (Result.exceptionOrNull-impl(obj2) != null) {
                                    linkData = linkData2;
                                } else {
                                    try {
                                        Result.Companion companion3 = Result.Companion;
                                        linkData = linkData2;
                                        try {
                                            obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(HindmoviezSignResponse.class), (List) null, 2, (Object) null));
                                            break;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            try {
                                                Result.Companion companion4 = Result.Companion;
                                                obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                                            } catch (Exception e) {
                                                objDecodeFromString = null;
                                            }
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        linkData = linkData2;
                                    }
                                }
                                if (Result.isFailure-impl(obj2)) {
                                    obj2 = null;
                                }
                                deserializationStrategy = (KSerializer) obj2;
                                if (deserializationStrategy != null) {
                                    try {
                                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, it);
                                    } catch (SerializationException e2) {
                                        ArchComponentExtKt.logError(e2);
                                        ObjectMapper $this$readValue$iv$iv$iv = MainAPIKt.getMapper();
                                        objDecodeFromString = $this$readValue$iv$iv$iv.readValue(it, new TypeReference<HindmoviezSignResponse>() { // from class: com.hindmoviez.Hindmoviez$loadLinks$2$invokeSuspend$lambda$0$$inlined$tryParseJson$1
                                        });
                                    } catch (Throwable th4) {
                                        ObjectMapper $this$readValue$iv$iv$iv2 = MainAPIKt.getMapper();
                                        objDecodeFromString = $this$readValue$iv$iv$iv2.readValue(it, new TypeReference<HindmoviezSignResponse>() { // from class: com.hindmoviez.Hindmoviez$loadLinks$2$invokeSuspend$lambda$0$$inlined$tryParseJson$1
                                        });
                                    }
                                } else {
                                    ObjectMapper $this$readValue$iv$iv$iv3 = MainAPIKt.getMapper();
                                    objDecodeFromString = $this$readValue$iv$iv$iv3.readValue(it, new TypeReference<HindmoviezSignResponse>() { // from class: com.hindmoviez.Hindmoviez$loadLinks$2$invokeSuspend$lambda$0$$inlined$tryParseJson$1
                                    });
                                }
                                break;
                            } catch (Exception e3) {
                                linkData = linkData2;
                                objDecodeFromString = null;
                                response = (HindmoviezSignResponse) objDecodeFromString;
                                if (response != null) {
                                    url = linkData.getDomain() + "/dl/" + encoded;
                                } else {
                                    url = linkData.getDomain() + "/dl/" + encoded;
                                }
                                signedUrl = url;
                                this.L$0 = SpillingKt.nullOutSpilledVariable(linkData);
                                this.L$1 = SpillingKt.nullOutSpilledVariable(encoded);
                                this.L$2 = SpillingKt.nullOutSpilledVariable(signedUrl);
                                this.label = 2;
                                obj = Requests.get$default(MainActivityKt.getApp(), signedUrl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 10000L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 3838, (Object) null);
                                if (obj == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                encoded2 = encoded;
                                encoded3 = signedUrl;
                                try {
                                    Document pageDoc = ((NiceResponse) obj).getDocument();
                                    elementSelectFirst = pageDoc.selectFirst("div.container p:contains(Name:)");
                                    if (elementSelectFirst != null) {
                                        string = null;
                                    } else {
                                        string = null;
                                    }
                                    if (string == null) {
                                        string = "";
                                    }
                                    name = string;
                                    if (StringsKt.isBlank(name)) {
                                        strBuildExtractedTitle = "";
                                    } else {
                                        strBuildExtractedTitle = UtilsKt.buildExtractedTitle(UtilsKt.extractSpecs(name));
                                    }
                                    extractedSpecs = strBuildExtractedTitle;
                                    elementSelectFirst2 = pageDoc.selectFirst("div.container p:contains(Size:)");
                                    if (elementSelectFirst2 == null) {
                                        str = null;
                                    } else {
                                        str = null;
                                    }
                                    string2 = str;
                                    if (string2 == null) {
                                        fileSize = "";
                                    } else {
                                        fileSize = string2;
                                    }
                                    $this$mapNotNull$iv = pageDoc.select("a.btn");
                                    destination$iv$iv = new ArrayList();
                                    for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                                        Iterable $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                                        url2 = ((Element) element$iv$iv$iv).absUrl("href");
                                        if (StringsKt.isBlank(url2)) {
                                            url2 = null;
                                        }
                                        if (url2 != null) {
                                            destination$iv$iv.add(url2);
                                        }
                                        $this$mapNotNull$iv = $this$mapNotNull$iv2;
                                    }
                                    btnUrls = (List) destination$iv$iv;
                                    this.L$0 = SpillingKt.nullOutSpilledVariable(linkData);
                                    this.L$1 = SpillingKt.nullOutSpilledVariable(encoded2);
                                    this.L$2 = SpillingKt.nullOutSpilledVariable(encoded3);
                                    this.L$3 = SpillingKt.nullOutSpilledVariable(pageDoc);
                                    this.L$4 = SpillingKt.nullOutSpilledVariable(name);
                                    this.L$5 = SpillingKt.nullOutSpilledVariable(extractedSpecs);
                                    this.L$6 = SpillingKt.nullOutSpilledVariable(fileSize);
                                    this.L$7 = SpillingKt.nullOutSpilledVariable(btnUrls);
                                    this.label = 3;
                                    if (ParCollectionsKt.amap(btnUrls, new AnonymousClass1(extractedSpecs, fileSize, this.$subtitleCallback, this.$callback, null), (Continuation) this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    return Unit.INSTANCE;
                                } catch (Exception e4) {
                                    return Unit.INSTANCE;
                                }
                            }
                        }
                        try {
                            response = (HindmoviezSignResponse) objDecodeFromString;
                            if (response != null || (data = response.getData()) == null || (url = data.getUrl()) == null) {
                                url = linkData.getDomain() + "/dl/" + encoded;
                            }
                        } catch (Exception e5) {
                            url = linkData.getDomain() + "/dl/" + encoded;
                        }
                    } catch (Exception e6) {
                        linkData = linkData2;
                        url = linkData.getDomain() + "/dl/" + encoded;
                        signedUrl = url;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(linkData);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(encoded);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(signedUrl);
                        this.label = 2;
                        obj = Requests.get$default(MainActivityKt.getApp(), signedUrl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 10000L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 3838, (Object) null);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        encoded2 = encoded;
                        encoded3 = signedUrl;
                        Document pageDoc2 = ((NiceResponse) obj).getDocument();
                        elementSelectFirst = pageDoc2.selectFirst("div.container p:contains(Name:)");
                        if (elementSelectFirst != null) {
                            string = null;
                        } else {
                            string = null;
                        }
                        if (string == null) {
                            string = "";
                        }
                        name = string;
                        if (StringsKt.isBlank(name)) {
                            strBuildExtractedTitle = UtilsKt.buildExtractedTitle(UtilsKt.extractSpecs(name));
                        } else {
                            strBuildExtractedTitle = "";
                        }
                        extractedSpecs = strBuildExtractedTitle;
                        elementSelectFirst2 = pageDoc2.selectFirst("div.container p:contains(Size:)");
                        if (elementSelectFirst2 == null) {
                            str = null;
                        } else {
                            str = null;
                        }
                        string2 = str;
                        if (string2 == null) {
                            fileSize = "";
                        } else {
                            fileSize = string2;
                        }
                        $this$mapNotNull$iv = pageDoc2.select("a.btn");
                        destination$iv$iv = new ArrayList();
                        while (r16.hasNext()) {
                            Iterable $this$mapNotNull$iv3 = $this$mapNotNull$iv;
                            url2 = ((Element) element$iv$iv$iv).absUrl("href");
                            if (StringsKt.isBlank(url2)) {
                                url2 = null;
                            }
                            if (url2 != null) {
                                destination$iv$iv.add(url2);
                            }
                            $this$mapNotNull$iv = $this$mapNotNull$iv3;
                        }
                        btnUrls = (List) destination$iv$iv;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(linkData);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(encoded2);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(encoded3);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(pageDoc2);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(name);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(extractedSpecs);
                        this.L$6 = SpillingKt.nullOutSpilledVariable(fileSize);
                        this.L$7 = SpillingKt.nullOutSpilledVariable(btnUrls);
                        this.label = 3;
                        if (ParCollectionsKt.amap(btnUrls, new AnonymousClass1(extractedSpecs, fileSize, this.$subtitleCallback, this.$callback, null), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                    signedUrl = url;
                    try {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(linkData);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(encoded);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(signedUrl);
                        this.label = 2;
                        obj = Requests.get$default(MainActivityKt.getApp(), signedUrl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 10000L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 3838, (Object) null);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        encoded2 = encoded;
                        encoded3 = signedUrl;
                        Document pageDoc3 = ((NiceResponse) obj).getDocument();
                        elementSelectFirst = pageDoc3.selectFirst("div.container p:contains(Name:)");
                        if (elementSelectFirst != null || (strText2 = elementSelectFirst.text()) == null || (strSubstringAfter$default = StringsKt.substringAfter$default(strText2, "Name:", (String) null, 2, (Object) null)) == null) {
                            string = null;
                        } else {
                            string = StringsKt.trim(strSubstringAfter$default).toString();
                        }
                        if (string == null) {
                            string = "";
                        }
                        name = string;
                        if (StringsKt.isBlank(name)) {
                            strBuildExtractedTitle = UtilsKt.buildExtractedTitle(UtilsKt.extractSpecs(name));
                        } else {
                            strBuildExtractedTitle = "";
                        }
                        extractedSpecs = strBuildExtractedTitle;
                        elementSelectFirst2 = pageDoc3.selectFirst("div.container p:contains(Size:)");
                        if (elementSelectFirst2 == null && (strText = elementSelectFirst2.text()) != null) {
                            str = null;
                            String strSubstringAfter$default2 = StringsKt.substringAfter$default(strText, "Size:", (String) null, 2, (Object) null);
                            if (strSubstringAfter$default2 != null) {
                                string2 = StringsKt.trim(strSubstringAfter$default2).toString();
                            }
                            if (string2 == null) {
                                fileSize = "";
                            } else {
                                fileSize = string2;
                            }
                            $this$mapNotNull$iv = pageDoc3.select("a.btn");
                            destination$iv$iv = new ArrayList();
                            while (r16.hasNext()) {
                                Iterable $this$mapNotNull$iv4 = $this$mapNotNull$iv;
                                url2 = ((Element) element$iv$iv$iv).absUrl("href");
                                if (StringsKt.isBlank(url2)) {
                                    url2 = null;
                                }
                                if (url2 != null) {
                                    destination$iv$iv.add(url2);
                                }
                                $this$mapNotNull$iv = $this$mapNotNull$iv4;
                            }
                            btnUrls = (List) destination$iv$iv;
                            this.L$0 = SpillingKt.nullOutSpilledVariable(linkData);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(encoded2);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(encoded3);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(pageDoc3);
                            this.L$4 = SpillingKt.nullOutSpilledVariable(name);
                            this.L$5 = SpillingKt.nullOutSpilledVariable(extractedSpecs);
                            this.L$6 = SpillingKt.nullOutSpilledVariable(fileSize);
                            this.L$7 = SpillingKt.nullOutSpilledVariable(btnUrls);
                            this.label = 3;
                            if (ParCollectionsKt.amap(btnUrls, new AnonymousClass1(extractedSpecs, fileSize, this.$subtitleCallback, this.$callback, null), (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        }
                        str = null;
                        string2 = str;
                        if (string2 == null) {
                            fileSize = "";
                        } else {
                            fileSize = string2;
                        }
                        $this$mapNotNull$iv = pageDoc3.select("a.btn");
                        destination$iv$iv = new ArrayList();
                        while (r16.hasNext()) {
                            Iterable $this$mapNotNull$iv5 = $this$mapNotNull$iv;
                            url2 = ((Element) element$iv$iv$iv).absUrl("href");
                            if (StringsKt.isBlank(url2)) {
                                url2 = null;
                            }
                            if (url2 != null) {
                                destination$iv$iv.add(url2);
                            }
                            $this$mapNotNull$iv = $this$mapNotNull$iv5;
                        }
                        btnUrls = (List) destination$iv$iv;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(linkData);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(encoded2);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(encoded3);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(pageDoc3);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(name);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(extractedSpecs);
                        this.L$6 = SpillingKt.nullOutSpilledVariable(fileSize);
                        this.L$7 = SpillingKt.nullOutSpilledVariable(btnUrls);
                        this.label = 3;
                        if (ParCollectionsKt.amap(btnUrls, new AnonymousClass1(extractedSpecs, fileSize, this.$subtitleCallback, this.$callback, null), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    } catch (Exception e7) {
                        return Unit.INSTANCE;
                    }
                case 1:
                    encoded = (String) this.L$1;
                    try {
                        ResultKt.throwOnFailure($result);
                        objPost$default = $result;
                        it = ((NiceResponse) objPost$default).getText();
                        AppUtils appUtils2 = AppUtils.INSTANCE;
                        if (it == null) {
                            linkData = linkData2;
                            objDecodeFromString = null;
                        } else {
                            Result.Companion companion5 = Result.Companion;
                            KType kTypeTypeOf2 = Reflection.typeOf(HindmoviezSignResponse.class);
                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                            obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                            if (Result.exceptionOrNull-impl(obj2) != null) {
                                Result.Companion companion6 = Result.Companion;
                                linkData = linkData2;
                                obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(HindmoviezSignResponse.class), (List) null, 2, (Object) null));
                            } else {
                                linkData = linkData2;
                            }
                            if (Result.isFailure-impl(obj2)) {
                                obj2 = null;
                            }
                            deserializationStrategy = (KSerializer) obj2;
                            if (deserializationStrategy != null) {
                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, it);
                            } else {
                                ObjectMapper $this$readValue$iv$iv$iv4 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv$iv4.readValue(it, new TypeReference<HindmoviezSignResponse>() { // from class: com.hindmoviez.Hindmoviez$loadLinks$2$invokeSuspend$lambda$0$$inlined$tryParseJson$1
                                });
                            }
                        }
                        response = (HindmoviezSignResponse) objDecodeFromString;
                        if (response != null) {
                            url = linkData.getDomain() + "/dl/" + encoded;
                        } else {
                            url = linkData.getDomain() + "/dl/" + encoded;
                        }
                        break;
                    } catch (Exception e8) {
                        linkData = linkData2;
                        url = linkData.getDomain() + "/dl/" + encoded;
                        signedUrl = url;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(linkData);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(encoded);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(signedUrl);
                        this.label = 2;
                        obj = Requests.get$default(MainActivityKt.getApp(), signedUrl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 10000L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 3838, (Object) null);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        encoded2 = encoded;
                        encoded3 = signedUrl;
                        Document pageDoc4 = ((NiceResponse) obj).getDocument();
                        elementSelectFirst = pageDoc4.selectFirst("div.container p:contains(Name:)");
                        if (elementSelectFirst != null) {
                            string = null;
                        } else {
                            string = null;
                        }
                        if (string == null) {
                            string = "";
                        }
                        name = string;
                        if (StringsKt.isBlank(name)) {
                            strBuildExtractedTitle = UtilsKt.buildExtractedTitle(UtilsKt.extractSpecs(name));
                        } else {
                            strBuildExtractedTitle = "";
                        }
                        extractedSpecs = strBuildExtractedTitle;
                        elementSelectFirst2 = pageDoc4.selectFirst("div.container p:contains(Size:)");
                        if (elementSelectFirst2 == null) {
                            str = null;
                        } else {
                            str = null;
                        }
                        string2 = str;
                        if (string2 == null) {
                            fileSize = "";
                        } else {
                            fileSize = string2;
                        }
                        $this$mapNotNull$iv = pageDoc4.select("a.btn");
                        destination$iv$iv = new ArrayList();
                        while (r16.hasNext()) {
                            Iterable $this$mapNotNull$iv6 = $this$mapNotNull$iv;
                            url2 = ((Element) element$iv$iv$iv).absUrl("href");
                            if (StringsKt.isBlank(url2)) {
                                url2 = null;
                            }
                            if (url2 != null) {
                                destination$iv$iv.add(url2);
                            }
                            $this$mapNotNull$iv = $this$mapNotNull$iv6;
                        }
                        btnUrls = (List) destination$iv$iv;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(linkData);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(encoded2);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(encoded3);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(pageDoc4);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(name);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(extractedSpecs);
                        this.L$6 = SpillingKt.nullOutSpilledVariable(fileSize);
                        this.L$7 = SpillingKt.nullOutSpilledVariable(btnUrls);
                        this.label = 3;
                        if (ParCollectionsKt.amap(btnUrls, new AnonymousClass1(extractedSpecs, fileSize, this.$subtitleCallback, this.$callback, null), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                    signedUrl = url;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(linkData);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(encoded);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(signedUrl);
                    this.label = 2;
                    obj = Requests.get$default(MainActivityKt.getApp(), signedUrl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 10000L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 3838, (Object) null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    encoded2 = encoded;
                    encoded3 = signedUrl;
                    Document pageDoc5 = ((NiceResponse) obj).getDocument();
                    elementSelectFirst = pageDoc5.selectFirst("div.container p:contains(Name:)");
                    if (elementSelectFirst != null) {
                        string = null;
                    } else {
                        string = null;
                    }
                    if (string == null) {
                        string = "";
                    }
                    name = string;
                    if (StringsKt.isBlank(name)) {
                        strBuildExtractedTitle = UtilsKt.buildExtractedTitle(UtilsKt.extractSpecs(name));
                    } else {
                        strBuildExtractedTitle = "";
                    }
                    extractedSpecs = strBuildExtractedTitle;
                    elementSelectFirst2 = pageDoc5.selectFirst("div.container p:contains(Size:)");
                    if (elementSelectFirst2 == null) {
                        str = null;
                    } else {
                        str = null;
                    }
                    string2 = str;
                    if (string2 == null) {
                        fileSize = "";
                    } else {
                        fileSize = string2;
                    }
                    $this$mapNotNull$iv = pageDoc5.select("a.btn");
                    destination$iv$iv = new ArrayList();
                    while (r16.hasNext()) {
                        Iterable $this$mapNotNull$iv7 = $this$mapNotNull$iv;
                        url2 = ((Element) element$iv$iv$iv).absUrl("href");
                        if (StringsKt.isBlank(url2)) {
                            url2 = null;
                        }
                        if (url2 != null) {
                            destination$iv$iv.add(url2);
                        }
                        $this$mapNotNull$iv = $this$mapNotNull$iv7;
                    }
                    btnUrls = (List) destination$iv$iv;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(linkData);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(encoded2);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(encoded3);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(pageDoc5);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(name);
                    this.L$5 = SpillingKt.nullOutSpilledVariable(extractedSpecs);
                    this.L$6 = SpillingKt.nullOutSpilledVariable(fileSize);
                    this.L$7 = SpillingKt.nullOutSpilledVariable(btnUrls);
                    this.label = 3;
                    if (ParCollectionsKt.amap(btnUrls, new AnonymousClass1(extractedSpecs, fileSize, this.$subtitleCallback, this.$callback, null), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                case 2:
                    String signedUrl2 = (String) this.L$2;
                    String encoded4 = (String) this.L$1;
                    try {
                        ResultKt.throwOnFailure($result);
                        obj = $result;
                        linkData = linkData2;
                        encoded2 = encoded4;
                        encoded3 = signedUrl2;
                        Document pageDoc6 = ((NiceResponse) obj).getDocument();
                        elementSelectFirst = pageDoc6.selectFirst("div.container p:contains(Name:)");
                        if (elementSelectFirst != null) {
                            string = null;
                        } else {
                            string = null;
                        }
                        if (string == null) {
                            string = "";
                        }
                        name = string;
                        if (StringsKt.isBlank(name)) {
                            strBuildExtractedTitle = UtilsKt.buildExtractedTitle(UtilsKt.extractSpecs(name));
                        } else {
                            strBuildExtractedTitle = "";
                        }
                        extractedSpecs = strBuildExtractedTitle;
                        elementSelectFirst2 = pageDoc6.selectFirst("div.container p:contains(Size:)");
                        if (elementSelectFirst2 == null) {
                            str = null;
                        } else {
                            str = null;
                        }
                        string2 = str;
                        if (string2 == null) {
                            fileSize = "";
                        } else {
                            fileSize = string2;
                        }
                        $this$mapNotNull$iv = pageDoc6.select("a.btn");
                        destination$iv$iv = new ArrayList();
                        while (r16.hasNext()) {
                            Iterable $this$mapNotNull$iv8 = $this$mapNotNull$iv;
                            url2 = ((Element) element$iv$iv$iv).absUrl("href");
                            if (StringsKt.isBlank(url2)) {
                                url2 = null;
                            }
                            if (url2 != null) {
                                destination$iv$iv.add(url2);
                            }
                            $this$mapNotNull$iv = $this$mapNotNull$iv8;
                        }
                        btnUrls = (List) destination$iv$iv;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(linkData);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(encoded2);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(encoded3);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(pageDoc6);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(name);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(extractedSpecs);
                        this.L$6 = SpillingKt.nullOutSpilledVariable(fileSize);
                        this.L$7 = SpillingKt.nullOutSpilledVariable(btnUrls);
                        this.label = 3;
                        if (ParCollectionsKt.amap(btnUrls, new AnonymousClass1(extractedSpecs, fileSize, this.$subtitleCallback, this.$callback, null), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    } catch (Exception e9) {
                        return Unit.INSTANCE;
                    }
                case 3:
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.hindmoviez.Hindmoviez$loadLinks$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: hindmoviez.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "btnUrl", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.hindmoviez.Hindmoviez$loadLinks$2$1", f = "hindmoviez.kt", i = {0, 1, 2, 2, 2, 2}, l = {419, 423, 430}, m = "invokeSuspend", n = {"btnUrl", "btnUrl", "btnUrl", "doc", "innerLinks", "quality"}, nl = {420, 425, 446}, s = {"L$0", "L$0", "L$0", "L$1", "L$2", "I$0"}, v = 2)
        @SourceDebugExtension({"SMAP\nhindmoviez.kt\nKotlin\n*S Kotlin\n*F\n+ 1 hindmoviez.kt\ncom/hindmoviez/Hindmoviez$loadLinks$2$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,454:1\n1795#2,10:455\n2068#2:465\n2069#2:468\n1805#2:469\n1#3:466\n1#3:467\n*S KotlinDebug\n*F\n+ 1 hindmoviez.kt\ncom/hindmoviez/Hindmoviez$loadLinks$2$1\n*L\n428#1:455,10\n428#1:465\n428#1:468\n428#1:469\n428#1:467\n*E\n"})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
            final /* synthetic */ String $extractedSpecs;
            final /* synthetic */ String $fileSize;
            final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
            int I$0;
            /* synthetic */ Object L$0;
            Object L$1;
            Object L$2;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(String str, String str2, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$extractedSpecs = str;
                this.$fileSize = str2;
                this.$subtitleCallback = function1;
                this.$callback = function2;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$extractedSpecs, this.$fileSize, this.$subtitleCallback, this.$callback, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            public final Object invoke(String str, Continuation<? super Unit> continuation) {
                return create(str, continuation).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code duplicated, block: B:28:0x00ce  */
            /* JADX WARN: Code duplicated, block: B:36:0x011b  */
            /* JADX WARN: Code duplicated, block: B:37:0x011c  */
            /* JADX WARN: Code duplicated, block: B:39:0x0120 A[Catch: Exception -> 0x013c, TryCatch #1 {Exception -> 0x013c, blocks: (B:34:0x0109, B:39:0x0120, B:42:0x0133), top: B:65:0x0109 }] */
            /* JADX WARN: Code duplicated, block: B:40:0x012d  */
            /* JADX WARN: Code duplicated, block: B:42:0x0133 A[Catch: Exception -> 0x013c, TRY_LEAVE, TryCatch #1 {Exception -> 0x013c, blocks: (B:34:0x0109, B:39:0x0120, B:42:0x0133), top: B:65:0x0109 }] */
            /* JADX WARN: Code duplicated, block: B:55:0x0182 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:63:0x00f3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:74:0x0137 A[SYNTHETIC] */
            public final Object invokeSuspend(Object $result) {
                Pair pair;
                Object obj;
                Element elementSelectFirst;
                String strText;
                int quality;
                Iterable $this$mapNotNull$iv;
                Collection destination$iv$iv;
                String btnUrl;
                List innerLinks;
                Element it;
                Pair pairAbsUrl;
                Pair pair2;
                String btnUrl2 = (String) this.L$0;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                try {
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            if (StringsKt.contains$default(btnUrl2, "gdshine", false, 2, (Object) null)) {
                                this.L$0 = SpillingKt.nullOutSpilledVariable(btnUrl2);
                                this.label = 1;
                                if (ExtractorApiKt.loadExtractor(btnUrl2, this.$extractedSpecs + '[' + this.$fileSize + ']', this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                return Unit.INSTANCE;
                            }
                            this.L$0 = btnUrl2;
                            this.label = 2;
                            pair = null;
                            obj = Requests.get$default(MainActivityKt.getApp(), btnUrl2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 10000L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 3838, (Object) null);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            Document doc = ((NiceResponse) obj).getDocument();
                            elementSelectFirst = doc.selectFirst("div.container h2");
                            if (elementSelectFirst != null || (strText = elementSelectFirst.text()) == null) {
                                strText = "";
                            }
                            quality = UtilsKt.getIndexQuality(strText);
                            $this$mapNotNull$iv = doc.select("a.button");
                            destination$iv$iv = new ArrayList();
                            for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                                try {
                                    it = (Element) element$iv$iv$iv;
                                    Iterable $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                                    String btnUrl3 = btnUrl2;
                                    try {
                                        pairAbsUrl = it.absUrl("href");
                                        if (!StringsKt.isBlank((CharSequence) pairAbsUrl)) {
                                            pairAbsUrl = pair;
                                        }
                                        if (pairAbsUrl != null) {
                                            pair2 = TuplesKt.to(pairAbsUrl, it.text());
                                        } else {
                                            pair2 = pair;
                                        }
                                        if (pair2 != null) {
                                            destination$iv$iv.add(pair2);
                                        }
                                        $this$mapNotNull$iv = $this$mapNotNull$iv2;
                                        btnUrl2 = btnUrl3;
                                    } catch (Exception e) {
                                    }
                                } catch (Exception e2) {
                                }
                            }
                            btnUrl = btnUrl2;
                            try {
                                innerLinks = (List) destination$iv$iv;
                                try {
                                    this.L$0 = SpillingKt.nullOutSpilledVariable(btnUrl);
                                    this.L$1 = SpillingKt.nullOutSpilledVariable(doc);
                                    this.L$2 = SpillingKt.nullOutSpilledVariable(innerLinks);
                                    this.I$0 = quality;
                                    this.label = 3;
                                    if (ParCollectionsKt.amap(innerLinks, new C00131(this.$extractedSpecs, this.$fileSize, this.$subtitleCallback, this.$callback, btnUrl, quality, null), (Continuation) this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                } catch (Exception e3) {
                                }
                            } catch (Exception e4) {
                            }
                            return Unit.INSTANCE;
                        case 1:
                            ResultKt.throwOnFailure($result);
                            return Unit.INSTANCE;
                        case 2:
                            ResultKt.throwOnFailure($result);
                            obj = $result;
                            pair = null;
                            Document doc2 = ((NiceResponse) obj).getDocument();
                            elementSelectFirst = doc2.selectFirst("div.container h2");
                            if (elementSelectFirst != null) {
                                strText = "";
                            } else {
                                strText = "";
                            }
                            quality = UtilsKt.getIndexQuality(strText);
                            $this$mapNotNull$iv = doc2.select("a.button");
                            destination$iv$iv = new ArrayList();
                            while (r12.hasNext()) {
                                it = (Element) element$iv$iv$iv;
                                Iterable $this$mapNotNull$iv3 = $this$mapNotNull$iv;
                                String btnUrl4 = btnUrl2;
                                pairAbsUrl = it.absUrl("href");
                                if (!StringsKt.isBlank((CharSequence) pairAbsUrl)) {
                                    pairAbsUrl = pair;
                                }
                                if (pairAbsUrl != null) {
                                    pair2 = TuplesKt.to(pairAbsUrl, it.text());
                                } else {
                                    pair2 = pair;
                                }
                                if (pair2 != null) {
                                    destination$iv$iv.add(pair2);
                                }
                                $this$mapNotNull$iv = $this$mapNotNull$iv3;
                                btnUrl2 = btnUrl4;
                            }
                            btnUrl = btnUrl2;
                            innerLinks = (List) destination$iv$iv;
                            this.L$0 = SpillingKt.nullOutSpilledVariable(btnUrl);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(doc2);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(innerLinks);
                            this.I$0 = quality;
                            this.label = 3;
                            if (ParCollectionsKt.amap(innerLinks, new C00131(this.$extractedSpecs, this.$fileSize, this.$subtitleCallback, this.$callback, btnUrl, quality, null), (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        case 3:
                            int i = this.I$0;
                            ResultKt.throwOnFailure($result);
                            return Unit.INSTANCE;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } catch (Exception e5) {
                }
            }

            /* JADX INFO: renamed from: com.hindmoviez.Hindmoviez$loadLinks$2$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: hindmoviez.kt */
            @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\t\u0012\u00070\u0004¢\u0006\u0002\b\u00050\u0003H\n"}, d2 = {"<anonymous>", "", "<destruct>", "Lkotlin/Pair;", "", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 4, 0}, xi = 48)
            @DebugMetadata(c = "com.hindmoviez.Hindmoviez$loadLinks$2$1$1", f = "hindmoviez.kt", i = {0, 0, 0, 1, 1, 1}, l = {432, 435}, m = "invokeSuspend", n = {"<destruct>", "href", "linkText", "<destruct>", "href", "linkText"}, nl = {434, 434}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"}, v = 2)
            static final class C00131 extends SuspendLambda implements Function2<Pair<? extends String, ? extends String>, Continuation<? super Object>, Object> {
                final /* synthetic */ String $btnUrl;
                final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
                final /* synthetic */ String $extractedSpecs;
                final /* synthetic */ String $fileSize;
                final /* synthetic */ int $quality;
                final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
                /* synthetic */ Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00131(String str, String str2, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, String str3, int i, Continuation<? super C00131> continuation) {
                    super(2, continuation);
                    this.$extractedSpecs = str;
                    this.$fileSize = str2;
                    this.$subtitleCallback = function1;
                    this.$callback = function2;
                    this.$btnUrl = str3;
                    this.$quality = i;
                }

                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    Continuation<Unit> c00131 = new C00131(this.$extractedSpecs, this.$fileSize, this.$subtitleCallback, this.$callback, this.$btnUrl, this.$quality, continuation);
                    c00131.L$0 = obj;
                    return c00131;
                }

                public final Object invoke(Pair<String, String> pair, Continuation<Object> continuation) {
                    return create(pair, continuation).invokeSuspend(Unit.INSTANCE);
                }

                public final Object invokeSuspend(Object $result) {
                    Object objNewExtractorLink$default;
                    Function1<ExtractorLink, Unit> function1;
                    String linkText;
                    String linkText2;
                    Pair pair = (Pair) this.L$0;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            String href = (String) pair.component1();
                            String linkText3 = (String) pair.component2();
                            if (StringsKt.contains$default(href, "gdshine", false, 2, (Object) null)) {
                                this.L$0 = SpillingKt.nullOutSpilledVariable(pair);
                                this.L$1 = SpillingKt.nullOutSpilledVariable(href);
                                this.L$2 = SpillingKt.nullOutSpilledVariable(linkText3);
                                this.label = 1;
                                Object objLoadExtractor = ExtractorApiKt.loadExtractor(href, this.$extractedSpecs + '[' + this.$fileSize + ']', this.$subtitleCallback, this.$callback, (Continuation) this);
                                return objLoadExtractor == coroutine_suspended ? coroutine_suspended : objLoadExtractor;
                            }
                            Function1<ExtractorLink, Unit> function2 = this.$callback;
                            this.L$0 = SpillingKt.nullOutSpilledVariable(pair);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(href);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(linkText3);
                            this.L$3 = function2;
                            this.label = 2;
                            objNewExtractorLink$default = ExtractorApiKt.newExtractorLink$default(linkText3, "[HCloud] " + this.$extractedSpecs + '[' + this.$fileSize + ']', href, (ExtractorLinkType) null, new C00141(this.$btnUrl, this.$quality, null), (Continuation) this, 8, (Object) null);
                            if (objNewExtractorLink$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            function1 = function2;
                            linkText = linkText3;
                            linkText2 = href;
                            break;
                            break;
                        case 1:
                            ResultKt.throwOnFailure($result);
                            return $result;
                        case 2:
                            function1 = (Function1) this.L$3;
                            linkText = (String) this.L$2;
                            linkText2 = (String) this.L$1;
                            ResultKt.throwOnFailure($result);
                            objNewExtractorLink$default = $result;
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    function1.invoke(objNewExtractorLink$default);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: com.hindmoviez.Hindmoviez$loadLinks$2$1$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: hindmoviez.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
                @DebugMetadata(c = "com.hindmoviez.Hindmoviez$loadLinks$2$1$1$1", f = "hindmoviez.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
                static final class C00141 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
                    final /* synthetic */ String $btnUrl;
                    final /* synthetic */ int $quality;
                    private /* synthetic */ Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C00141(String str, int i, Continuation<? super C00141> continuation) {
                        super(2, continuation);
                        this.$btnUrl = str;
                        this.$quality = i;
                    }

                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        Continuation<Unit> c00141 = new C00141(this.$btnUrl, this.$quality, continuation);
                        c00141.L$0 = obj;
                        return c00141;
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
                                $this$newExtractorLink.setReferer(this.$btnUrl);
                                $this$newExtractorLink.setQuality(this.$quality);
                                return Unit.INSTANCE;
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    }
                }
            }
        }
    }
}
