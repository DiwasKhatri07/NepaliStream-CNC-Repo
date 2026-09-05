package com.hdhub4u;

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
import com.lagradost.cloudstream3.Score;
import com.lagradost.cloudstream3.SearchQuality;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SearchResponseList;
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
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* JADX INFO: compiled from: HDhub4uProvider.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/HDhub4u/classes.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 H2\u00020\u0001:\u0001HB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010 \u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0096@¢\u0006\u0002\u0010)J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0002J\f\u0010.\u001a\u00020+*\u00020/H\u0002J\u001e\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&H\u0096@¢\u0006\u0002\u00103J\u0016\u00104\u001a\b\u0012\u0004\u0012\u00020\u00050\u001e2\u0006\u00105\u001a\u000206H\u0002J\u0016\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010:JF\u0010;\u001a\u00020\u00112\u0006\u0010<\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\u00112\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020A0?2\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020A0?H\u0096@¢\u0006\u0002\u0010DJ\u0012\u0010E\u001a\u0004\u0018\u00010F2\b\u0010G\u001a\u0004\u0018\u00010\u0005R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0011X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u0011X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001a\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050#X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/hdhub4u/HDhub4uProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "lang", "getLang", "setLang", "hasMainPage", "", "getHasMainPage", "()Z", "hasDownloadSupport", "getHasDownloadSupport", "hasQuickSearch", "getHasQuickSearch", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "headers", "", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "post", "Lorg/jsoup/nodes/Element;", "toSearchResult", "Lcom/hdhub4u/Document;", "search", "Lcom/lagradost/cloudstream3/SearchResponseList;", "query", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "extractLinksATags", "aTags", "Lorg/jsoup/select/Elements;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSearchQuality", "Lcom/lagradost/cloudstream3/SearchQuality;", "check", "Companion", "HDhub4u"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nHDhub4uProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HDhub4uProvider.kt\ncom/hdhub4u/HDhub4uProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 5 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 6 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 7 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 8 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,531:1\n1795#2,10:532\n2068#2:542\n2069#2:544\n1805#2:545\n1739#2:551\n1814#2,3:552\n1795#2,10:555\n2068#2:565\n2069#2:567\n1805#2:568\n777#2:569\n873#2,2:570\n1739#2:578\n1814#2,3:579\n2068#2:582\n1795#2,10:583\n2068#2:593\n2069#2:595\n1805#2:596\n1960#2,3:597\n2068#2:600\n2068#2:601\n2069#2:609\n2069#2:610\n1795#2,10:611\n2068#2:621\n2069#2:623\n1805#2:624\n2069#2:632\n1739#2:658\n1814#2,3:659\n777#2:662\n873#2,2:663\n1#3:543\n1#3:566\n1#3:577\n1#3:594\n1#3:622\n1#3:638\n73#4,5:546\n73#4,5:572\n460#5,7:602\n460#5,7:625\n221#6,2:633\n93#7,2:635\n63#7:637\n64#7,15:639\n95#7,2:656\n50#8:654\n43#8:655\n*S KotlinDebug\n*F\n+ 1 HDhub4uProvider.kt\ncom/hdhub4u/HDhub4uProvider\n*L\n80#1:532,10\n80#1:542\n80#1:544\n80#1:545\n122#1:551\n122#1:552,3\n130#1:555,10\n130#1:565\n130#1:567\n130#1:568\n131#1:569\n131#1:570,2\n345#1:578\n345#1:579,3\n365#1:582\n367#1:583,10\n367#1:593\n367#1:595\n367#1:596\n369#1:597,3\n375#1:600\n380#1:601\n380#1:609\n375#1:610\n399#1:611,10\n399#1:621\n399#1:623\n399#1:624\n365#1:632\n453#1:658\n453#1:659,3\n453#1:662\n453#1:663,2\n80#1:543\n130#1:566\n367#1:594\n399#1:622\n453#1:638\n120#1:546,5\n173#1:572,5\n386#1:602,7\n411#1:625,7\n416#1:633,2\n453#1:635,2\n453#1:637\n453#1:639,15\n453#1:656,2\n453#1:654\n453#1:655\n*E\n"})
public final class HDhub4uProvider extends MainAPI {

    @NotNull
    public static final String TAG = "EpisodeParser";

    @NotNull
    public static final String TMDBAPI = "https://api.themoviedb.org/3";

    @NotNull
    public static final String TMDBAPIKEY = "1865f43a0549ca50d341dd9ab8b29f49";

    @NotNull
    public static final String TMDBBASE = "https://image.tmdb.org/t/p/original";
    private final boolean hasQuickSearch;

    @NotNull
    private String mainUrl = (String) BuildersKt.runBlockingK(EmptyCoroutineContext.INSTANCE, new HDhub4uProvider$mainUrl$1(null));

    @NotNull
    private String name = "HDHub4U";

    @NotNull
    private String lang = "hi";
    private final boolean hasMainPage = true;
    private final boolean hasDownloadSupport = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.TvSeries, TvType.Anime});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("", "Latest"), TuplesKt.to("category/bollywood-movies/", "Bollywood"), TuplesKt.to("category/hollywood-movies/", "Hollywood"), TuplesKt.to("category/hindi-dubbed/", "Hindi Dubbed"), TuplesKt.to("category/south-hindi-movies/", "South Hindi Dubbed"), TuplesKt.to("category/category/web-series/", "Web Series"), TuplesKt.to("category/adult/", "Adult")});

    @NotNull
    private final Map<String, String> headers = MapsKt.mapOf(new Pair[]{TuplesKt.to("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36 Edg/131.0.0.0"), TuplesKt.to("Cookie", "xla=s4t")});

    /* JADX INFO: renamed from: com.hdhub4u.HDhub4uProvider$getMainPage$1 */
    /* JADX INFO: compiled from: HDhub4uProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.hdhub4u.HDhub4uProvider", f = "HDhub4uProvider.kt", i = {0, 0}, l = {74}, m = "getMainPage", n = {"request", "page"}, nl = {79}, s = {"L$0", "I$0"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00011(Continuation<? super C00011> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HDhub4uProvider.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.hdhub4u.HDhub4uProvider$load$1 */
    /* JADX INFO: compiled from: HDhub4uProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.hdhub4u.HDhub4uProvider", f = "HDhub4uProvider.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8}, l = {138, 171, 193, 224, 281, 348, 377, 378, 432}, m = "load", n = {"url", "url", "doc", "title", "seasontitle", "seasonNumber", "image", "plot", "tags", "poster", "trailer", "typeraw", "tvtype", "actorData", "genre", "year", "background", "description", "tmdbHref", "tmdbId", "type", "isMovie", "isTv", "url", "doc", "title", "seasontitle", "seasonNumber", "image", "plot", "tags", "poster", "trailer", "typeraw", "tvtype", "actorData", "genre", "year", "background", "description", "imdbUrl", "tmdbIdResolved", "imdbIdOnly", "isMovie", "url", "doc", "title", "seasontitle", "seasonNumber", "image", "plot", "tags", "poster", "trailer", "typeraw", "tvtype", "actorData", "genre", "year", "background", "description", "imdbUrl", "tmdbIdResolved", "$this$load_u24lambda_u242", "type", "isMovie", "url", "doc", "title", "seasontitle", "seasonNumber", "image", "plot", "tags", "poster", "trailer", "typeraw", "tvtype", "actorData", "genre", "year", "background", "description", "imdbUrl", "tmdbIdResolved", "$this$load_u24lambda_u242", "type", "detailsText", "detailsJson", "yearRaw", "metaYear", "metaRating", "metaDesc", "metaBackground", "metaName", "imdbid", "logoPath", "actorDataList", "metaGenres", "videos", "isMovie", "url", "doc", "title", "seasontitle", "seasonNumber", "image", "plot", "tags", "poster", "trailer", "typeraw", "tvtype", "actorData", "genre", "year", "background", "description", "imdbUrl", "tmdbIdResolved", "responseData", "movieList", "isMovie", "url", "doc", "title", "seasontitle", "seasonNumber", "image", "plot", "tags", "poster", "trailer", "typeraw", "tvtype", "actorData", "genre", "year", "background", "description", "imdbUrl", "tmdbIdResolved", "responseData", "episodesData", "epLinksMap", "episodeRegex", "$this$forEach$iv", "element$iv", "element", "baseLinks", "allEpisodeLinks", "episodeNumberFromTitle", "$this$forEach$iv", "element$iv", "url", "isMovie", "isDirectLinkBlock", "url", "doc", "title", "seasontitle", "seasonNumber", "image", "plot", "tags", "poster", "trailer", "typeraw", "tvtype", "actorData", "genre", "year", "background", "description", "imdbUrl", "tmdbIdResolved", "responseData", "episodesData", "epLinksMap", "episodeRegex", "$this$forEach$iv", "element$iv", "element", "baseLinks", "allEpisodeLinks", "episodeNumberFromTitle", "$this$forEach$iv", "element$iv", "url", "resolvedUrl", "isMovie", "isDirectLinkBlock", "url", "doc", "title", "seasontitle", "seasonNumber", "image", "plot", "tags", "poster", "trailer", "typeraw", "tvtype", "actorData", "genre", "year", "background", "description", "imdbUrl", "tmdbIdResolved", "responseData", "episodesData", "epLinksMap", "episodeRegex", "isMovie"}, nl = {139, 173, 196, 226, 282, 361, 378, 380, -1}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "I$0", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$28", "L$29", "L$30", "L$31", "L$32", "L$33", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$25", "L$26", "L$27", "L$28", "L$29", "L$30", "L$32", "L$33", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$25", "L$26", "L$27", "L$28", "L$29", "L$30", "L$32", "L$33", "L$34", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "I$0"}, v = 2)
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
            return HDhub4uProvider.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.hdhub4u.HDhub4uProvider$loadLinks$1 */
    /* JADX INFO: compiled from: HDhub4uProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.hdhub4u.HDhub4uProvider", f = "HDhub4uProvider.kt", i = {0, 0, 0, 0, 0}, l = {454}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "linksList", "isCasting"}, nl = {486}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0"}, v = 2)
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
            return HDhub4uProvider.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.hdhub4u.HDhub4uProvider$search$1 */
    /* JADX INFO: compiled from: HDhub4uProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.hdhub4u.HDhub4uProvider", f = "HDhub4uProvider.kt", i = {0, 0}, l = {108}, m = "search", n = {"query", "page"}, nl = {120}, s = {"L$0", "I$0"}, v = 2)
    static final class C00071 extends ContinuationImpl {
        int I$0;
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
            return HDhub4uProvider.this.search(null, 0, (Continuation) this);
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
        C00011 c00011;
        boolean z;
        MainPageRequest request2;
        int page2 = page;
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
                Requests app = MainActivityKt.getApp();
                String str = getMainUrl() + '/' + request.getData() + "page/" + page2 + '/';
                Map<String, String> map = this.headers;
                c00011.L$0 = request;
                c00011.I$0 = page2;
                c00011.label = 1;
                z = true;
                $result = Requests.get$default(app, str, map, (String) null, (Map) null, (Map) null, true, 60, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00011, 3996, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
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
        org.jsoup.nodes.Document doc = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv = doc.select(".recent-movies > li.thumb");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            int page3 = page2;
            Element it = (Element) element$iv$iv$iv;
            SearchResponse result = toResult(it);
            if (result != null) {
                destination$iv$iv.add(result);
            }
            page2 = page3;
        }
        List home = (List) destination$iv$iv;
        return MainAPIKt.newHomePageResponse(request2.getName(), home, Boxing.boxBoolean(z));
    }

    private final SearchResponse toResult(final Element post) {
        final String titleText = post.select("figcaption:nth-child(2) > a:nth-child(1) > p:nth-child(1)").text();
        String title = UtilsKt.cleanTitle(titleText);
        String url = post.select("figure:nth-child(1) > a:nth-child(2)").attr("href");
        return MainAPIKt.newMovieSearchResponse$default(this, title, url, TvType.Movie, false, new Function1() { // from class: com.hdhub4u.HDhub4uProvider$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return HDhub4uProvider.toResult$lambda$0(post, this, titleText, (MovieSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toResult$lambda$0(Element $post, HDhub4uProvider this$0, String $titleText, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($post.select("figure:nth-child(1) > img:nth-child(1)").attr("src"));
        $this$newMovieSearchResponse.setQuality(this$0.getSearchQuality($titleText));
        return Unit.INSTANCE;
    }

    private final SearchResponse toSearchResult(final Document $this$toSearchResult) {
        return MainAPIKt.newMovieSearchResponse$default(this, $this$toSearchResult.getPostTitle(), new Regex("^https?://[^/]+").replace($this$toSearchResult.getPermalink(), getMainUrl()), TvType.Movie, false, new Function1() { // from class: com.hdhub4u.HDhub4uProvider$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return HDhub4uProvider.toSearchResult$lambda$0($this$toSearchResult, (MovieSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResult$lambda$0(Document $this_toSearchResult, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($this_toSearchResult.getPostThumbnail());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object search(@NotNull String query, int page, @NotNull Continuation<? super SearchResponseList> continuation) {
        C00071 c00071;
        int i;
        Object safe;
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
                Map<String, String> map = this.headers;
                String mainUrl = getMainUrl();
                c00071.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00071.I$0 = page;
                c00071.label = 1;
                i = 1;
                $result = Requests.get$default(MainActivityKt.getApp(), "https://search.pingora.fyi/collections/post/documents/search?q=" + query + "&query_by=post_title,category&query_by_weights=4,2&sort_by=sort_by_date:desc&limit=15&highlight_fields=none&use_cache=true&page=" + page, map, mainUrl, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00071, 4088, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                int i2 = c00071.I$0;
                ResultKt.throwOnFailure($result);
                i = 1;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NiceResponse this_$iv = (NiceResponse) $result;
        try {
            ResponseParser parser = this_$iv.getParser();
            Intrinsics.checkNotNull(parser);
            safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(Search.class));
        } catch (Exception e$iv) {
            e$iv.printStackTrace();
            safe = null;
        }
        Search response = (Search) safe;
        Iterable hits = response != null ? response.getHits() : null;
        Intrinsics.checkNotNull(hits);
        Iterable $this$map$iv = hits;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Hit hit = (Hit) item$iv$iv;
            destination$iv$iv.add(toSearchResult(hit.getDocument()));
        }
        return MainAPIKt.toNewSearchResponseList$default((List) destination$iv$iv, (Boolean) null, i, (Object) null);
    }

    private final List<String> extractLinksATags(Elements aTags) {
        Regex allowedDomains = new Regex("https://(.*\\.)?(hdstream4u|hubstream)\\..*");
        Iterable $this$mapNotNull$iv = (Iterable) aTags;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Element it = (Element) element$iv$iv$iv;
            String strAttr = it.attr("href");
            if (strAttr != null) {
                destination$iv$iv.add(strAttr);
            }
        }
        Iterable $this$filter$iv = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            String it2 = (String) element$iv$iv;
            if (allowedDomains.containsMatchIn(it2)) {
                destination$iv$iv2.add(element$iv$iv);
            }
        }
        return CollectionsKt.distinct((List) destination$iv$iv2);
    }

    /* JADX WARN: Code duplicated, block: B:1095:0x12bd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:1175:0x2e33 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:1191:0x169a A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:242:0x12ba  */
    /* JADX WARN: Code duplicated, block: B:246:0x12d1  */
    /* JADX WARN: Code duplicated, block: B:247:0x12d2  */
    /* JADX WARN: Code duplicated, block: B:249:0x12d5 A[Catch: all -> 0x12da, TRY_LEAVE, TryCatch #93 {all -> 0x12da, blocks: (B:244:0x12bd, B:249:0x12d5), top: B:1095:0x12bd }] */
    /* JADX WARN: Code duplicated, block: B:255:0x1306  */
    /* JADX WARN: Code duplicated, block: B:264:0x132f A[Catch: all -> 0x1352, TRY_LEAVE, TryCatch #28 {all -> 0x1352, blocks: (B:262:0x1329, B:264:0x132f, B:286:0x1429, B:294:0x1447, B:304:0x1474, B:313:0x14a2, B:315:0x14ab, B:323:0x14c2, B:342:0x153e), top: B:998:0x1329 }] */
    /* JADX WARN: Code duplicated, block: B:274:0x13f7  */
    /* JADX WARN: Code duplicated, block: B:279:0x1413  */
    /* JADX WARN: Code duplicated, block: B:280:0x1414  */
    /* JADX WARN: Code duplicated, block: B:282:0x1417  */
    /* JADX WARN: Code duplicated, block: B:285:0x1428  */
    /* JADX WARN: Code duplicated, block: B:290:0x1440  */
    /* JADX WARN: Code duplicated, block: B:291:0x1443  */
    /* JADX WARN: Code duplicated, block: B:293:0x1446  */
    /* JADX WARN: Code duplicated, block: B:296:0x144c  */
    /* JADX WARN: Code duplicated, block: B:301:0x146b  */
    /* JADX WARN: Code duplicated, block: B:303:0x1470  */
    /* JADX WARN: Code duplicated, block: B:307:0x148c  */
    /* JADX WARN: Code duplicated, block: B:312:0x14a0  */
    /* JADX WARN: Code duplicated, block: B:315:0x14ab A[Catch: all -> 0x1352, TryCatch #28 {all -> 0x1352, blocks: (B:262:0x1329, B:264:0x132f, B:286:0x1429, B:294:0x1447, B:304:0x1474, B:313:0x14a2, B:315:0x14ab, B:323:0x14c2, B:342:0x153e), top: B:998:0x1329 }] */
    /* JADX WARN: Code duplicated, block: B:319:0x14bb  */
    /* JADX WARN: Code duplicated, block: B:323:0x14c2 A[Catch: all -> 0x1352, TRY_LEAVE, TryCatch #28 {all -> 0x1352, blocks: (B:262:0x1329, B:264:0x132f, B:286:0x1429, B:294:0x1447, B:304:0x1474, B:313:0x14a2, B:315:0x14ab, B:323:0x14c2, B:342:0x153e), top: B:998:0x1329 }] */
    /* JADX WARN: Code duplicated, block: B:325:0x14e3  */
    /* JADX WARN: Code duplicated, block: B:328:0x14f6  */
    /* JADX WARN: Code duplicated, block: B:331:0x1500 A[Catch: all -> 0x1626, TryCatch #5 {all -> 0x1626, blocks: (B:329:0x14f8, B:331:0x1500, B:333:0x150f, B:336:0x151f), top: B:962:0x14f8 }] */
    /* JADX WARN: Code duplicated, block: B:333:0x150f A[Catch: all -> 0x1626, TryCatch #5 {all -> 0x1626, blocks: (B:329:0x14f8, B:331:0x1500, B:333:0x150f, B:336:0x151f), top: B:962:0x14f8 }] */
    /* JADX WARN: Code duplicated, block: B:335:0x1515  */
    /* JADX WARN: Code duplicated, block: B:336:0x151f A[Catch: all -> 0x1626, TRY_LEAVE, TryCatch #5 {all -> 0x1626, blocks: (B:329:0x14f8, B:331:0x1500, B:333:0x150f, B:336:0x151f), top: B:962:0x14f8 }] */
    /* JADX WARN: Code duplicated, block: B:339:0x1538  */
    /* JADX WARN: Code duplicated, block: B:341:0x153c  */
    /* JADX WARN: Code duplicated, block: B:344:0x1546  */
    /* JADX WARN: Code duplicated, block: B:345:0x1549  */
    /* JADX WARN: Code duplicated, block: B:346:0x154c  */
    /* JADX WARN: Code duplicated, block: B:351:0x1567  */
    /* JADX WARN: Code duplicated, block: B:353:0x156a  */
    /* JADX WARN: Code duplicated, block: B:355:0x1580  */
    /* JADX WARN: Code duplicated, block: B:358:0x1597  */
    /* JADX WARN: Code duplicated, block: B:359:0x1598  */
    /* JADX WARN: Code duplicated, block: B:368:0x161f  */
    /* JADX WARN: Code duplicated, block: B:371:0x1651  */
    /* JADX WARN: Code duplicated, block: B:374:0x1669  */
    /* JADX WARN: Code duplicated, block: B:377:0x1671 A[Catch: all -> 0x15f8, TryCatch #108 {all -> 0x15f8, blocks: (B:361:0x15ba, B:354:0x156e, B:356:0x1583, B:360:0x1599, B:364:0x15ed, B:375:0x166b, B:377:0x1671, B:379:0x1679, B:381:0x167f, B:386:0x1691, B:387:0x169a, B:388:0x169f), top: B:1117:0x15ba }] */
    /* JADX WARN: Code duplicated, block: B:379:0x1679 A[Catch: all -> 0x15f8, TryCatch #108 {all -> 0x15f8, blocks: (B:361:0x15ba, B:354:0x156e, B:356:0x1583, B:360:0x1599, B:364:0x15ed, B:375:0x166b, B:377:0x1671, B:379:0x1679, B:381:0x167f, B:386:0x1691, B:387:0x169a, B:388:0x169f), top: B:1117:0x15ba }] */
    /* JADX WARN: Code duplicated, block: B:391:0x16b0 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:563:0x25df  */
    /* JADX WARN: Code duplicated, block: B:566:0x25ef  */
    /* JADX WARN: Code duplicated, block: B:569:0x25fe  */
    /* JADX WARN: Code duplicated, block: B:611:0x2adb  */
    /* JADX WARN: Code duplicated, block: B:700:0x2e0a  */
    /* JADX WARN: Code duplicated, block: B:703:0x2e35 A[LOOP:4: B:698:0x2e04->B:703:0x2e35, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Failed to apply debug info
    jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 153341. Try increasing type updates limit count.
    	at jadx.core.dex.visitors.typeinference.TypeUpdateInfo.requestUpdate(TypeUpdateInfo.java:61)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:298)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyDebugInfo(TypeUpdate.java:77)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:137)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:133)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.searchAndApplyVarDebugInfo(DebugInfoApplyVisitor.java:75)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.lambda$applyDebugInfo$0(DebugInfoApplyVisitor.java:68)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:68)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.visit(DebugInfoApplyVisitor.java:55)
     */
    /* JADX WARN: Multi-variable search skipped. Vars limit reached: 6408 (expected less than 5000) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 36, insn: 0x0641: MOVE (r57 I:??[OBJECT, ARRAY]) = (r36 I:??[OBJECT, ARRAY] A[D('year' kotlin.jvm.internal.Ref$ObjectRef)]), block:B:33:0x063a */
    /* JADX WARN: Not initialized variable reg: 37, insn: 0x0647: MOVE (r42 I:??[OBJECT, ARRAY] A[D('poster' java.lang.String)]) = (r37 I:??[OBJECT, ARRAY] A[D('genre' kotlin.jvm.internal.Ref$ObjectRef)]), block:B:33:0x063a */
    /* JADX WARN: Not initialized variable reg: 42, insn: 0x0643: MOVE (r27 I:??[OBJECT, ARRAY]) = (r42 I:??[OBJECT, ARRAY] A[D('poster' java.lang.String)]), block:B:33:0x063a */
    /* JADX WARN: Path cross not found for [B:1016:0x1235, B:236:0x1294], limit reached: 1165 */
    /* JADX WARN: Path cross not found for [B:1095:0x12bd, B:254:0x1304], limit reached: 1165 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v172 */
    /* JADX WARN: Type inference failed for: r0v331 */
    /* JADX WARN: Type inference failed for: r0v425 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9, names: [isMovie], types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r1v289 */
    /* JADX WARN: Type inference failed for: r1v290 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r6v123, names: [doc], types: [org.jsoup.nodes.Document] */
    /* JADX WARN: Type inference failed for: r6v125, names: [doc], types: [org.jsoup.nodes.Document] */
    /* JADX WARN: Type inference failed for: r6v127, names: [doc], types: [org.jsoup.nodes.Document] */
    /* JADX WARN: Type inference failed for: r6v129, names: [doc], types: [org.jsoup.nodes.Document] */
    /* JADX WARN: Type inference failed for: r6v131, names: [doc], types: [org.jsoup.nodes.Document] */
    /* JADX WARN: Type inference failed for: r6v133, names: [doc], types: [org.jsoup.nodes.Document] */
    /* JADX WARN: Type inference failed for: r6v135, names: [doc], types: [org.jsoup.nodes.Document] */
    /* JADX WARN: Type inference failed for: r6v137, names: [doc], types: [org.jsoup.nodes.Document] */
    /* JADX WARN: Type inference failed for: r6v139, names: [doc], types: [org.jsoup.nodes.Document] */
    /* JADX WARN: Type inference failed for: r6v141, names: [doc], types: [org.jsoup.nodes.Document] */
    /* JADX WARN: Type inference failed for: r6v143, names: [doc], types: [org.jsoup.nodes.Document] */
    /* JADX WARN: Type inference failed for: r6v146 */
    /* JADX WARN: Type inference failed for: r6v153, names: [title], types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r6v154, names: [title], types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r6v155, names: [title], types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r6v156, names: [title], types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r6v157, names: [title], types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r6v158, names: [title], types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r6v159, names: [title], types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r6v160, names: [title], types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r6v163, names: [title], types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r6v165, names: [title], types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r6v167, names: [title], types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r6v169, names: [title], types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r6v171, names: [title], types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r6v173, names: [title], types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r6v175, names: [title], types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r6v177, names: [title], types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r6v179, names: [title], types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r6v181, names: [title], types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r6v183, names: [title], types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r6v187, names: [title], types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r6v195, names: [title], types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r6v198 */
    /* JADX WARN: Type inference failed for: r6v2, names: [isMovie], types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v201, names: [title], types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r6v202, names: [title], types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r6v203, names: [title], types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r6v204, names: [title], types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r6v205, names: [title], types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r6v206, names: [title], types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r6v207, names: [title], types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r6v235 */
    /* JADX WARN: Type inference failed for: r6v236 */
    /* JADX WARN: Type inference failed for: r6v237 */
    /* JADX WARN: Type inference failed for: r6v238 */
    /* JADX WARN: Type inference failed for: r6v239 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 31 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:707:0x2e4f -> B:708:0x2ea0). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:768:0x3072 -> B:1105:0x3098). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:834:0x3373 -> B:882:0x3820). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:836:0x339c -> B:882:0x3820). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:838:0x33c7 -> B:882:0x3820). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:840:0x33f4 -> B:882:0x3820). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:847:0x3464 -> B:882:0x3820). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:849:0x3499 -> B:882:0x3820). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:851:0x34d0 -> B:882:0x3820). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:853:0x3509 -> B:882:0x3820). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:855:0x3542 -> B:882:0x3820). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:857:0x3582 -> B:882:0x3820). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:859:0x35c4 -> B:882:0x3820). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:871:0x3660 -> B:882:0x3820). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:873:0x36a8 -> B:882:0x3820). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:875:0x36f2 -> B:882:0x3820). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:877:0x373e -> B:882:0x3820). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:879:0x378a -> B:882:0x3820). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:881:0x37d5 -> B:882:0x3820). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:919:0x39fc -> B:920:0x3a15). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object load(@org.jetbrains.annotations.NotNull java.lang.String r100, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r101) {
        /*
            Method dump skipped, instruction units count: 15334
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hdhub4u.HDhub4uProvider.load(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.hdhub4u.HDhub4uProvider$load$6 */
    /* JADX INFO: compiled from: HDhub4uProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.hdhub4u.HDhub4uProvider$load$6", f = "HDhub4uProvider.kt", i = {0}, l = {357}, m = "invokeSuspend", n = {"$this$newMovieLoadResponse"}, nl = {358}, s = {"L$0"}, v = 2)
    static final class C00036 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<List<ActorData>> $actorData;
        final /* synthetic */ Ref.ObjectRef<String> $background;
        final /* synthetic */ Ref.ObjectRef<String> $description;
        final /* synthetic */ Ref.ObjectRef<List<String>> $genre;
        final /* synthetic */ String $imdbUrl;
        final /* synthetic */ String $plot;
        final /* synthetic */ String $poster;
        final /* synthetic */ ResponseDataLocal $responseData;
        final /* synthetic */ List<String> $tags;
        final /* synthetic */ String $trailer;
        final /* synthetic */ Ref.ObjectRef<String> $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00036(Ref.ObjectRef<String> objectRef, ResponseDataLocal responseDataLocal, String str, Ref.ObjectRef<String> objectRef2, Ref.ObjectRef<String> objectRef3, String str2, Ref.ObjectRef<List<String>> objectRef4, List<String> list, Ref.ObjectRef<List<ActorData>> objectRef5, String str3, String str4, Continuation<? super C00036> continuation) {
            super(2, continuation);
            this.$background = objectRef;
            this.$responseData = responseDataLocal;
            this.$poster = str;
            this.$year = objectRef2;
            this.$description = objectRef3;
            this.$plot = str2;
            this.$genre = objectRef4;
            this.$tags = list;
            this.$actorData = objectRef5;
            this.$trailer = str3;
            this.$imdbUrl = str4;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00036 = new C00036(this.$background, this.$responseData, this.$poster, this.$year, this.$description, this.$plot, this.$genre, this.$tags, this.$actorData, this.$trailer, this.$imdbUrl, continuation);
            c00036.L$0 = obj;
            return c00036;
        }

        public final Object invoke(MovieLoadResponse movieLoadResponse, Continuation<? super Unit> continuation) {
            return create(movieLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            MetaLocal meta;
            MetaLocal meta2;
            LoadResponse loadResponse = (MovieLoadResponse) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    loadResponse.setBackgroundPosterUrl((String) this.$background.element);
                    Score rating = null;
                    try {
                        ResponseDataLocal responseDataLocal = this.$responseData;
                        loadResponse.setLogoUrl((responseDataLocal == null || (meta2 = responseDataLocal.getMeta()) == null) ? null : meta2.getLogo());
                        break;
                    } catch (Throwable th) {
                    }
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
                    if (responseDataLocal2 != null && (meta = responseDataLocal2.getMeta()) != null) {
                        rating = meta.getRating();
                    }
                    loadResponse.setScore(rating);
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
            LoadResponse.Companion.addImdbUrl(loadResponse, this.$imdbUrl);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$6$1(VideoLocal $info, int $epNum, Integer $seasonNumber, Episode $this$newEpisode) {
        String title;
        if ($info == null || (title = $info.getTitle()) == null) {
            title = "Episode " + $epNum;
        }
        $this$newEpisode.setName(title);
        $this$newEpisode.setSeason($seasonNumber);
        $this$newEpisode.setEpisode(Integer.valueOf($epNum));
        $this$newEpisode.setPosterUrl($info != null ? $info.getThumbnail() : null);
        $this$newEpisode.setDescription($info != null ? $info.getOverview() : null);
        $this$newEpisode.setScore($info != null ? $info.getRating() : null);
        MainAPIKt.addDate$default($this$newEpisode, $info != null ? $info.getReleased() : null, (String) null, 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.hdhub4u.HDhub4uProvider$load$9 */
    /* JADX INFO: compiled from: HDhub4uProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.hdhub4u.HDhub4uProvider$load$9", f = "HDhub4uProvider.kt", i = {0}, l = {441}, m = "invokeSuspend", n = {"$this$newTvSeriesLoadResponse"}, nl = {442}, s = {"L$0"}, v = 2)
    static final class C00049 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<List<ActorData>> $actorData;
        final /* synthetic */ Ref.ObjectRef<String> $background;
        final /* synthetic */ Ref.ObjectRef<String> $description;
        final /* synthetic */ Ref.ObjectRef<List<String>> $genre;
        final /* synthetic */ String $imdbUrl;
        final /* synthetic */ String $plot;
        final /* synthetic */ String $poster;
        final /* synthetic */ ResponseDataLocal $responseData;
        final /* synthetic */ List<String> $tags;
        final /* synthetic */ String $trailer;
        final /* synthetic */ Ref.ObjectRef<String> $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00049(Ref.ObjectRef<String> objectRef, ResponseDataLocal responseDataLocal, String str, Ref.ObjectRef<String> objectRef2, Ref.ObjectRef<String> objectRef3, String str2, Ref.ObjectRef<List<String>> objectRef4, List<String> list, Ref.ObjectRef<List<ActorData>> objectRef5, String str3, String str4, Continuation<? super C00049> continuation) {
            super(2, continuation);
            this.$background = objectRef;
            this.$responseData = responseDataLocal;
            this.$poster = str;
            this.$year = objectRef2;
            this.$description = objectRef3;
            this.$plot = str2;
            this.$genre = objectRef4;
            this.$tags = list;
            this.$actorData = objectRef5;
            this.$trailer = str3;
            this.$imdbUrl = str4;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00049 = new C00049(this.$background, this.$responseData, this.$poster, this.$year, this.$description, this.$plot, this.$genre, this.$tags, this.$actorData, this.$trailer, this.$imdbUrl, continuation);
            c00049.L$0 = obj;
            return c00049;
        }

        public final Object invoke(TvSeriesLoadResponse tvSeriesLoadResponse, Continuation<? super Unit> continuation) {
            return create(tvSeriesLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            MetaLocal meta;
            MetaLocal meta2;
            LoadResponse loadResponse = (TvSeriesLoadResponse) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    loadResponse.setBackgroundPosterUrl((String) this.$background.element);
                    Score rating = null;
                    try {
                        ResponseDataLocal responseDataLocal = this.$responseData;
                        loadResponse.setLogoUrl((responseDataLocal == null || (meta2 = responseDataLocal.getMeta()) == null) ? null : meta2.getLogo());
                        break;
                    } catch (Throwable th) {
                    }
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
                    if (responseDataLocal2 != null && (meta = responseDataLocal2.getMeta()) != null) {
                        rating = meta.getRating();
                    }
                    loadResponse.setScore(rating);
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
            LoadResponse.Companion.addImdbUrl(loadResponse, this.$imdbUrl);
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
        List linksList;
        List linksList2;
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
                                objDecodeFromString = $this$readValue$iv$iv$iv.readValue(data, new TypeReference<List<? extends String>>() { // from class: com.hdhub4u.HDhub4uProvider$loadLinks$$inlined$tryParseJson$1
                                });
                            } catch (Throwable th3) {
                                ObjectMapper $this$readValue$iv$iv$iv2 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv$iv2.readValue(data, new TypeReference<List<? extends String>>() { // from class: com.hdhub4u.HDhub4uProvider$loadLinks$$inlined$tryParseJson$1
                                });
                            }
                        } else {
                            ObjectMapper $this$readValue$iv$iv$iv3 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv$iv3.readValue(data, new TypeReference<List<? extends String>>() { // from class: com.hdhub4u.HDhub4uProvider$loadLinks$$inlined$tryParseJson$1
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
                        String it = (String) item$iv$iv;
                        destination$iv$iv.add(StringsKt.trim(it).toString());
                    }
                    Iterable $this$filter$iv = (List) destination$iv$iv;
                    Collection destination$iv$iv2 = new ArrayList();
                    for (Object element$iv$iv : $this$filter$iv) {
                        String it2 = (String) element$iv$iv;
                        if (it2.length() > 0) {
                            destination$iv$iv2.add(element$iv$iv);
                        }
                    }
                    linksList = (List) destination$iv$iv2;
                } else {
                    linksList = CollectionsKt.emptyList();
                }
                C00062 c00062 = new C00062(function1, function2, null);
                c00052.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00052.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                c00052.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                c00052.L$3 = linksList;
                c00052.Z$0 = isCasting;
                c00052.label = 1;
                if (ParCollectionsKt.amap(linksList, c00062, c00052) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                linksList2 = linksList;
                break;
                break;
            case 1:
                boolean z = c00052.Z$0;
                linksList2 = (List) c00052.L$3;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Boxing.boxBoolean(!linksList2.isEmpty());
    }

    /* JADX INFO: renamed from: com.hdhub4u.HDhub4uProvider$loadLinks$2 */
    /* JADX INFO: compiled from: HDhub4uProvider.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "link", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.hdhub4u.HDhub4uProvider$loadLinks$2", f = "HDhub4uProvider.kt", i = {0, 1, 1, 2, 2}, l = {457, 464, 473}, m = "invokeSuspend", n = {"link", "link", "finalLink", "link", "finalLink"}, nl = {459, 473, 481}, s = {"L$0", "L$0", "L$1", "L$0", "L$1"}, v = 2)
    static final class C00062 extends SuspendLambda implements Function2<String, Continuation<? super Object>, Object> {
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
            Continuation<Unit> c00062 = new C00062(this.$subtitleCallback, this.$callback, continuation);
            c00062.L$0 = obj;
            return c00062;
        }

        public final Object invoke(String str, Continuation<Object> continuation) {
            return create(str, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:23:0x0058  */
        /* JADX WARN: Code duplicated, block: B:28:0x006a A[Catch: Exception -> 0x0030, TryCatch #0 {Exception -> 0x0030, blocks: (B:7:0x001c, B:10:0x0026, B:11:0x002b, B:21:0x0054, B:26:0x005b, B:28:0x006a, B:33:0x008c, B:16:0x0037, B:18:0x0046), top: B:39:0x000d }] */
        /* JADX WARN: Code duplicated, block: B:30:0x0089 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:31:0x008a  */
        /* JADX WARN: Code duplicated, block: B:33:0x008c A[Catch: Exception -> 0x0030, TRY_LEAVE, TryCatch #0 {Exception -> 0x0030, blocks: (B:7:0x001c, B:10:0x0026, B:11:0x002b, B:21:0x0054, B:26:0x005b, B:28:0x006a, B:33:0x008c, B:16:0x0037, B:18:0x0046), top: B:39:0x000d }] */
        /* JADX WARN: Code duplicated, block: B:35:0x00a6 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:42:? A[RETURN, SYNTHETIC] */
        public final Object invokeSuspend(Object $result) {
            Object redirectLinks;
            String str;
            String finalLink;
            Object objLoadExtractor;
            Object url;
            String link = (String) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (StringsKt.contains$default(link, "?id=", false, 2, (Object) null)) {
                            this.L$0 = link;
                            this.label = 1;
                            redirectLinks = UtilsKt.getRedirectLinks(link, (Continuation) this);
                            if (redirectLinks == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            str = (String) redirectLinks;
                            if (str == null) {
                                str = link;
                            }
                        } else {
                            str = link;
                        }
                        finalLink = str;
                        if (StringsKt.contains(finalLink, "Hubdrive", true)) {
                            this.L$0 = link;
                            this.L$1 = SpillingKt.nullOutSpilledVariable(finalLink);
                            this.label = 2;
                            url = new Hubdrive().getUrl(finalLink, "", this.$subtitleCallback, this.$callback, (Continuation) this);
                            if (url == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return url;
                        }
                        this.L$0 = link;
                        this.L$1 = SpillingKt.nullOutSpilledVariable(finalLink);
                        this.label = 3;
                        objLoadExtractor = ExtractorApiKt.loadExtractor(finalLink, this.$subtitleCallback, this.$callback, (Continuation) this);
                        if (objLoadExtractor == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return objLoadExtractor;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        redirectLinks = $result;
                        str = (String) redirectLinks;
                        if (str == null) {
                            str = link;
                        }
                        finalLink = str;
                        if (StringsKt.contains(finalLink, "Hubdrive", true)) {
                            this.L$0 = link;
                            this.L$1 = SpillingKt.nullOutSpilledVariable(finalLink);
                            this.label = 2;
                            url = new Hubdrive().getUrl(finalLink, "", this.$subtitleCallback, this.$callback, (Continuation) this);
                            if (url == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return url;
                        }
                        this.L$0 = link;
                        this.L$1 = SpillingKt.nullOutSpilledVariable(finalLink);
                        this.label = 3;
                        objLoadExtractor = ExtractorApiKt.loadExtractor(finalLink, this.$subtitleCallback, this.$callback, (Continuation) this);
                        if (objLoadExtractor == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return objLoadExtractor;
                    case 2:
                        ResultKt.throwOnFailure($result);
                        url = $result;
                        return url;
                    case 3:
                        ResultKt.throwOnFailure($result);
                        return $result;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Exception e) {
                Log.INSTANCE.e("Phisher", "Failed to process " + link + ": " + e.getMessage());
                return Unit.INSTANCE;
            }
        }
    }

    @Nullable
    public final SearchQuality getSearchQuality(@Nullable String check) {
        if (check == null) {
            return null;
        }
        String u = Normalizer.normalize(check, Normalizer.Form.NFKC).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(u, "toLowerCase(...)");
        List<Pair> patterns = CollectionsKt.listOf(new Pair[]{TuplesKt.to(new Regex("\\b(4k|ds4k|uhd|2160p)\\b", RegexOption.IGNORE_CASE), SearchQuality.FourK), TuplesKt.to(new Regex("\\b(hdts|hdcam|hdtc)\\b", RegexOption.IGNORE_CASE), SearchQuality.HdCam), TuplesKt.to(new Regex("\\b(camrip|cam[- ]?rip)\\b", RegexOption.IGNORE_CASE), SearchQuality.CamRip), TuplesKt.to(new Regex("\\b(cam)\\b", RegexOption.IGNORE_CASE), SearchQuality.Cam), TuplesKt.to(new Regex("\\b(web[- ]?dl|webrip|webdl)\\b", RegexOption.IGNORE_CASE), SearchQuality.WebRip), TuplesKt.to(new Regex("\\b(bluray|bdrip|blu[- ]?ray)\\b", RegexOption.IGNORE_CASE), SearchQuality.BlueRay), TuplesKt.to(new Regex("\\b(1440p|qhd)\\b", RegexOption.IGNORE_CASE), SearchQuality.BlueRay), TuplesKt.to(new Regex("\\b(1080p|fullhd)\\b", RegexOption.IGNORE_CASE), SearchQuality.HD), TuplesKt.to(new Regex("\\b(720p)\\b", RegexOption.IGNORE_CASE), SearchQuality.SD), TuplesKt.to(new Regex("\\b(hdrip|hdtv)\\b", RegexOption.IGNORE_CASE), SearchQuality.HD), TuplesKt.to(new Regex("\\b(dvd)\\b", RegexOption.IGNORE_CASE), SearchQuality.DVD), TuplesKt.to(new Regex("\\b(hq)\\b", RegexOption.IGNORE_CASE), SearchQuality.HQ), TuplesKt.to(new Regex("\\b(rip)\\b", RegexOption.IGNORE_CASE), SearchQuality.CamRip)});
        for (Pair pair : patterns) {
            Regex regex = (Regex) pair.component1();
            SearchQuality quality = (SearchQuality) pair.component2();
            if (regex.containsMatchIn(u)) {
                return quality;
            }
        }
        return null;
    }
}
