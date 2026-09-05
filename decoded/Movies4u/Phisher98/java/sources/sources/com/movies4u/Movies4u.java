package com.movies4u;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import kotlin.collections.ArraysKt;
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

/* JADX INFO: compiled from: Movies4u.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Movies4u/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 >2\u00020\u0001:\u0001>B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u001e\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0096@¢\u0006\u0002\u0010%J\u000e\u0010&\u001a\u0004\u0018\u00010'*\u00020(H\u0002J\u001e\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010,J\u0016\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u00100JF\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u000e2\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u000207052\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020705H\u0096@¢\u0006\u0002\u0010:J\u0012\u0010;\u001a\u0004\u0018\u00010<2\b\u0010=\u001a\u0004\u0018\u00010\u0005R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006?"}, d2 = {"Lcom/movies4u/Movies4u;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasDownloadSupport", "getHasDownloadSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lorg/jsoup/nodes/Element;", "search", "Lcom/lagradost/cloudstream3/SearchResponseList;", "query", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSearchQuality", "Lcom/lagradost/cloudstream3/SearchQuality;", "check", "Companion", "Movies4u"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMovies4u.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Movies4u.kt\ncom/movies4u/Movies4u\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 5 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 6 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 7 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,422:1\n1795#2,10:423\n2068#2:433\n2069#2:435\n1805#2:436\n1795#2,10:438\n2068#2:448\n2069#2:450\n1805#2:451\n1739#2:452\n1814#2,3:453\n296#2,2:456\n1795#2,10:458\n2068#2:468\n2069#2:470\n1805#2:471\n2068#2:472\n2069#2:474\n2068#2:475\n832#2:476\n862#2,2:477\n1739#2:479\n1814#2,3:480\n2068#2:483\n2068#2:484\n1739#2:485\n1814#2,3:486\n2069#2:496\n2069#2:504\n2069#2:505\n1#3:434\n1#3:437\n1#3:449\n1#3:469\n1#3:473\n1#3:513\n1#3:533\n460#4,7:489\n460#4,7:497\n129#5:506\n158#5,3:507\n93#6,2:510\n63#6:512\n64#6,15:514\n95#6,2:531\n50#7:529\n43#7:530\n*S KotlinDebug\n*F\n+ 1 Movies4u.kt\ncom/movies4u/Movies4u\n*L\n69#1:423,10\n69#1:433\n69#1:435\n69#1:436\n110#1:438,10\n110#1:448\n110#1:450\n110#1:451\n137#1:452\n137#1:453,3\n138#1:456,2\n204#1:458,10\n204#1:468\n204#1:470\n204#1:471\n205#1:472\n205#1:474\n231#1:475\n233#1:476\n233#1:477,2\n233#1:479\n233#1:480,3\n235#1:483\n240#1:484\n243#1:485\n243#1:486,3\n240#1:496\n235#1:504\n231#1:505\n69#1:434\n110#1:449\n204#1:469\n368#1:513\n245#1:489,7\n253#1:497,7\n262#1:506\n262#1:507,3\n368#1:510,2\n368#1:512\n368#1:514,15\n368#1:531,2\n368#1:529\n368#1:530\n*E\n"})
public final class Movies4u extends MainAPI {

    @NotNull
    public static final String TMDBAPI = "https://api.themoviedb.org/3";

    @NotNull
    public static final String TMDBAPIKEY = "1865f43a0549ca50d341dd9ab8b29f49";

    @NotNull
    public static final String TMDBBASE = "https://image.tmdb.org/t/p/original";

    @NotNull
    private String mainUrl = (String) BuildersKt.runBlockingK(EmptyCoroutineContext.INSTANCE, new Movies4u$mainUrl$1(null));

    @NotNull
    private String name = "Movies4u";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "hi";
    private final boolean hasDownloadSupport = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.TvSeries, TvType.Anime});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("", "Home"), TuplesKt.to("category/bollywood-movies/", "BollyWood"), TuplesKt.to("category/hollywood-movies/", "HollyWood"), TuplesKt.to("category/web-series/", "WEB-Series"), TuplesKt.to("category/anime/", "Anime / Animation"), TuplesKt.to("category/k-drama/", "K-Drama"), TuplesKt.to("category/south-hindi-movies/", "South Hindi Movies")});

    /* JADX INFO: renamed from: com.movies4u.Movies4u$getMainPage$1 */
    /* JADX INFO: compiled from: Movies4u.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.movies4u.Movies4u", f = "Movies4u.kt", i = {0, 0, 0}, l = {68}, m = "getMainPage", n = {"request", "url", "page"}, nl = {69}, s = {"L$0", "L$1", "I$0"}, v = 2)
    static final class C00121 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00121(Continuation<? super C00121> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Movies4u.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.movies4u.Movies4u$load$1 */
    /* JADX INFO: compiled from: Movies4u.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.movies4u.Movies4u", f = "Movies4u.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8}, l = {135, 155, 169, 185, 207, 237, 299, 333, 345}, m = "load", n = {"url", "url", "document", "title", "hrefList", "plot", "poster", "typeraw", "tvtype", "description", "background", "year", "actorData", "imdbId", "tmdbIdResolved", "isMovie", "url", "document", "title", "hrefList", "plot", "poster", "typeraw", "tvtype", "description", "background", "year", "actorData", "imdbId", "tmdbIdResolved", "isMovie", "url", "document", "title", "hrefList", "plot", "poster", "typeraw", "tvtype", "description", "background", "year", "actorData", "imdbId", "tmdbIdResolved", "logoUrl", "type", "isMovie", "url", "document", "title", "hrefList", "plot", "poster", "typeraw", "tvtype", "description", "background", "year", "actorData", "imdbId", "tmdbIdResolved", "logoUrl", "videoMap", "seasons", "$this$forEach$iv", "element$iv", "isMovie", "seasonNum", "url", "document", "title", "hrefList", "plot", "poster", "typeraw", "tvtype", "description", "background", "year", "actorData", "imdbId", "tmdbIdResolved", "logoUrl", "videoMap", "episodesMap", "$this$forEach$iv", "element$iv", "h4", "qualityLinks", "$this$forEach$iv", "element$iv", "qualityLink", "isMovie", "seasonNum", "url", "document", "title", "hrefList", "plot", "poster", "typeraw", "tvtype", "description", "background", "year", "actorData", "imdbId", "tmdbIdResolved", "logoUrl", "videoMap", "episodesMap", "episodes", "type", "isMovie", "url", "document", "title", "hrefList", "plot", "poster", "typeraw", "tvtype", "description", "background", "year", "actorData", "imdbId", "tmdbIdResolved", "logoUrl", "videoMap", "episodesMap", "episodes", "isMovie", "url", "document", "title", "hrefList", "plot", "poster", "typeraw", "tvtype", "description", "background", "year", "actorData", "imdbId", "tmdbIdResolved", "logoUrl", "videoMap", "episodesMap", "episodes", "isMovie"}, nl = {136, 156, 178, 187, 208, 238, 301, 345, 332}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$19", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$19", "L$20", "L$21", "L$22", "L$24", "L$25", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "I$0"}, v = 2)
    static final class C00131 extends ContinuationImpl {
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
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C00131(Continuation<? super C00131> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Movies4u.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.movies4u.Movies4u$loadLinks$1 */
    /* JADX INFO: compiled from: Movies4u.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.movies4u.Movies4u", f = "Movies4u.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {370, 378, 381}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "links", "isCasting", "data", "subtitleCallback", "callback", "isCasting", "data", "subtitleCallback", "callback", "isCasting"}, nl = {376, 381, 382}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "Z$0"}, v = 2)
    static final class C00161 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00161(Continuation<? super C00161> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Movies4u.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.movies4u.Movies4u$search$1 */
    /* JADX INFO: compiled from: Movies4u.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.movies4u.Movies4u", f = "Movies4u.kt", i = {0, 0, 0}, l = {109}, m = "search", n = {"query", "url", "page"}, nl = {110}, s = {"L$0", "L$1", "I$0"}, v = 2)
    static final class C00181 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00181(Continuation<? super C00181> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Movies4u.this.search(null, 0, (Continuation) this);
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
        C00121 c00121;
        StringBuilder sb;
        StringBuilder sbAppend;
        boolean z;
        int page2;
        MainPageRequest request2;
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
        Object $result = c00121.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00121.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (page == 1) {
                    sb = new StringBuilder();
                    sbAppend = sb.append(getMainUrl()).append('/').append(request.getData());
                } else {
                    sb = new StringBuilder();
                    sbAppend = sb.append(getMainUrl()).append('/').append(request.getData()).append("page/").append(page);
                }
                String url = sbAppend.toString();
                Requests app = MainActivityKt.getApp();
                c00121.L$0 = request;
                c00121.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00121.I$0 = page;
                c00121.label = 1;
                z = true;
                $result = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00121, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                page2 = page;
                request2 = request;
                break;
                break;
            case 1:
                page2 = c00121.I$0;
                request2 = (MainPageRequest) c00121.L$0;
                ResultKt.throwOnFailure($result);
                z = true;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv = document.select("article");
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
        List items = (List) destination$iv$iv;
        return MainAPIKt.newHomePageResponse(new HomePageList(request2.getName(), items, false), Boxing.boxBoolean(z));
    }

    private final SearchResponse toSearchResult(Element $this$toSearchResult) {
        Element img;
        Element aTag = $this$toSearchResult.selectFirst("h3 a,h2 a");
        if (aTag == null || (img = $this$toSearchResult.selectFirst("img")) == null) {
            return null;
        }
        String href = MainAPIKt.fixUrl(this, aTag.attr("href"));
        final String rawText = StringsKt.trim(aTag.ownText()).toString();
        String title = StringsKt.trim(StringsKt.substringBefore$default(rawText, " (", (String) null, 2, (Object) null)).toString();
        String it = StringsKt.substringBefore$default(StringsKt.substringAfter(rawText, "(", ""), ")", (String) null, 2, (Object) null);
        if (!new Regex("\\d{4}").matches(it)) {
            it = null;
        }
        String year = it;
        String lang = StringsKt.substringBefore$default(StringsKt.substringAfter(rawText, "[", ""), "]", (String) null, 2, (Object) null);
        if (StringsKt.isBlank(lang)) {
            lang = null;
        }
        StringBuilder $this$toSearchResult_u24lambda_u242 = new StringBuilder();
        $this$toSearchResult_u24lambda_u242.append(title);
        if (year != null) {
            $this$toSearchResult_u24lambda_u242.append(" (" + year + ')');
        }
        if (lang != null) {
            $this$toSearchResult_u24lambda_u242.append(" [" + lang + ']');
        }
        String fullTitle = $this$toSearchResult_u24lambda_u242.toString();
        final String posterUrl = MainAPIKt.fixUrlNull(this, img.attr("src"));
        return MainAPIKt.newMovieSearchResponse$default(this, fullTitle, href, TvType.Movie, false, new Function1() { // from class: com.movies4u.Movies4u$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                return Movies4u.toSearchResult$lambda$3(posterUrl, this, rawText, (MovieSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResult$lambda$3(String $posterUrl, Movies4u this$0, String $rawText, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($posterUrl);
        $this$newMovieSearchResponse.setQuality(this$0.getSearchQuality($rawText));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    @Nullable
    public Object search(@NotNull String query, int page, @NotNull Continuation<? super SearchResponseList> continuation) {
        C00181 c00181;
        StringBuilder sb;
        StringBuilder sbAppend;
        String url;
        int page2;
        String query2;
        Element img;
        MovieSearchResponse movieSearchResponseNewMovieSearchResponse$default;
        if (continuation instanceof C00181) {
            c00181 = (C00181) continuation;
            if ((c00181.label & Integer.MIN_VALUE) != 0) {
                c00181.label -= Integer.MIN_VALUE;
            } else {
                c00181 = new C00181(continuation);
            }
        } else {
            c00181 = new C00181(continuation);
        }
        Object $result = c00181.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00181.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (page == 1) {
                    sb = new StringBuilder();
                    sbAppend = sb.append(getMainUrl());
                } else {
                    sb = new StringBuilder();
                    sbAppend = sb.append(getMainUrl()).append("/page/").append(page);
                }
                String url2 = sbAppend.append("/?s=").append(query).toString();
                Requests app = MainActivityKt.getApp();
                c00181.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00181.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                c00181.I$0 = page;
                c00181.label = 1;
                url = url2;
                $result = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00181, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                page2 = page;
                query2 = query;
                break;
                break;
            case 1:
                int page3 = c00181.I$0;
                url = (String) c00181.L$1;
                String query3 = (String) c00181.L$0;
                ResultKt.throwOnFailure($result);
                page2 = page3;
                query2 = query3;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv = document.select("article");
        int $i$f$mapNotNull = 0;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Element article = (Element) element$iv$iv$iv;
            String query4 = query2;
            Element aTag = article.selectFirst("h3.entry-title a,div.downloads-btns-div a");
            if (aTag == null || (img = article.selectFirst("div.post-thumbnail img")) == null) {
                movieSearchResponseNewMovieSearchResponse$default = null;
            } else {
                String href = MainAPIKt.fixUrl(this, aTag.attr("href"));
                final String rawText = StringsKt.trim(aTag.text()).toString();
                String title = StringsKt.trim(StringsKt.substringBefore$default(rawText, "(", (String) null, 2, (Object) null)).toString();
                String it = StringsKt.substringBefore$default(StringsKt.substringAfter(rawText, "(", ""), ")", (String) null, 2, (Object) null);
                String str = it;
                if (!new Regex("\\d{4}").matches(it)) {
                    str = null;
                }
                String year = str;
                String lang = StringsKt.substringBefore$default(StringsKt.substringAfter(rawText, "[", ""), "]", (String) null, 2, (Object) null);
                if (StringsKt.isBlank(lang)) {
                    lang = null;
                }
                StringBuilder $this$search_u24lambda_u240_u242 = new StringBuilder();
                $this$search_u24lambda_u240_u242.append(title);
                if (year != null) {
                    $this$search_u24lambda_u240_u242.append(" (" + year + ')');
                }
                if (lang != null) {
                    $this$search_u24lambda_u240_u242.append(" [" + lang + ']');
                }
                String fullTitle = $this$search_u24lambda_u240_u242.toString();
                final String poster = MainAPIKt.fixUrlNull(this, img.attr("src"));
                TvType tvType = (StringsKt.contains(rawText, "Season", true) || StringsKt.contains(rawText, "Series", true)) ? TvType.TvSeries : StringsKt.contains(rawText, "Anime", true) ? TvType.Anime : TvType.Movie;
                movieSearchResponseNewMovieSearchResponse$default = MainAPIKt.newMovieSearchResponse$default(this, fullTitle, href, tvType, false, new Function1() { // from class: com.movies4u.Movies4u$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj) {
                        return Movies4u.search$lambda$0$3(poster, this, rawText, (MovieSearchResponse) obj);
                    }
                }, 8, (Object) null);
            }
            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                destination$iv$iv.add(movieSearchResponseNewMovieSearchResponse$default);
            }
            query2 = query4;
            page2 = page2;
            document = document;
            url = url;
            $this$mapNotNull$iv = $this$mapNotNull$iv;
            $i$f$mapNotNull = $i$f$mapNotNull;
        }
        List results = (List) destination$iv$iv;
        return MainAPIKt.toNewSearchResponseList$default(results, (Boolean) null, 1, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit search$lambda$0$3(String $poster, Movies4u this$0, String $rawText, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($poster);
        $this$newMovieSearchResponse.setQuality(this$0.getSearchQuality($rawText));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:136:0x0804  */
    /* JADX WARN: Code duplicated, block: B:224:0x0d13  */
    /* JADX WARN: Code duplicated, block: B:225:0x0d1a  */
    /* JADX WARN: Code duplicated, block: B:230:0x0d7f  */
    /* JADX WARN: Code duplicated, block: B:246:0x0e32 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:247:0x0e33  */
    /* JADX WARN: Code duplicated, block: B:250:0x0e6d  */
    /* JADX WARN: Code duplicated, block: B:251:0x0e8c A[Catch: Exception -> 0x105b, TryCatch #9 {Exception -> 0x105b, blocks: (B:248:0x0e5a, B:251:0x0e8c, B:253:0x0e93), top: B:622:0x0e5a }] */
    /* JADX WARN: Code duplicated, block: B:253:0x0e93 A[Catch: Exception -> 0x105b, TryCatch #9 {Exception -> 0x105b, blocks: (B:248:0x0e5a, B:251:0x0e8c, B:253:0x0e93), top: B:622:0x0e5a }] */
    /* JADX WARN: Code duplicated, block: B:255:0x0e99  */
    /* JADX WARN: Code duplicated, block: B:256:0x0eb4  */
    /* JADX WARN: Code duplicated, block: B:269:0x0f11  */
    /* JADX WARN: Code duplicated, block: B:271:0x0f15  */
    /* JADX WARN: Code duplicated, block: B:280:0x0f5b  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:247:0x0e33 -> B:622:0x0e5a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:347:0x1382 -> B:348:0x13cb). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:367:0x147c -> B:723:0x14ab). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:427:0x16da -> B:441:0x185a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:429:0x1714 -> B:441:0x185a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:431:0x1752 -> B:441:0x185a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:438:0x17da -> B:441:0x185a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:440:0x181b -> B:441:0x185a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object load(@org.jetbrains.annotations.NotNull java.lang.String r85, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r86) {
        /*
            Method dump skipped, instruction units count: 8270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.movies4u.Movies4u.load(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$5$0(VideoLocal $meta, boolean $isCompleteSeason, int $epNum, int $seasonNum, String $plot, String $poster, Episode $this$newEpisode) {
        String title;
        String overview;
        String thumbnail;
        Score scoreFrom10;
        Double rating;
        String title2 = $meta != null ? $meta.getTitle() : null;
        if (title2 == null || StringsKt.isBlank(title2)) {
            title = $isCompleteSeason ? "Episode " + $epNum : "Episode " + $epNum;
        } else {
            title = $meta.getTitle();
        }
        $this$newEpisode.setName(title);
        $this$newEpisode.setSeason(Integer.valueOf($seasonNum));
        $this$newEpisode.setEpisode(Integer.valueOf($epNum));
        String overview2 = $meta != null ? $meta.getOverview() : null;
        if (overview2 == null || StringsKt.isBlank(overview2)) {
            overview = $isCompleteSeason ? "Complete Season " + $seasonNum : $plot;
        } else {
            overview = $meta.getOverview();
        }
        $this$newEpisode.setDescription(overview);
        if ($meta == null || (thumbnail = $meta.getThumbnail()) == null) {
            thumbnail = $poster;
        }
        $this$newEpisode.setPosterUrl(thumbnail);
        if ($meta == null || (rating = $meta.getRating()) == null) {
            scoreFrom10 = null;
        } else {
            double it = rating.doubleValue();
            scoreFrom10 = Score.Companion.from10(Double.valueOf(it));
        }
        $this$newEpisode.setScore(scoreFrom10);
        MainAPIKt.addDate$default($this$newEpisode, $meta != null ? $meta.getReleased() : null, (String) null, 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.movies4u.Movies4u$load$14 */
    /* JADX INFO: compiled from: Movies4u.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.movies4u.Movies4u$load$14", f = "Movies4u.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C001414 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<List<ActorData>> $actorData;
        final /* synthetic */ Ref.ObjectRef<String> $background;
        final /* synthetic */ Ref.ObjectRef<String> $description;
        final /* synthetic */ String $imdbId;
        final /* synthetic */ String $logoUrl;
        final /* synthetic */ String $poster;
        final /* synthetic */ Ref.ObjectRef<Integer> $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C001414(Ref.ObjectRef<String> objectRef, String str, String str2, Ref.ObjectRef<Integer> objectRef2, Ref.ObjectRef<String> objectRef3, Ref.ObjectRef<List<ActorData>> objectRef4, String str3, Continuation<? super C001414> continuation) {
            super(2, continuation);
            this.$background = objectRef;
            this.$poster = str;
            this.$logoUrl = str2;
            this.$year = objectRef2;
            this.$description = objectRef3;
            this.$actorData = objectRef4;
            this.$imdbId = str3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c001414 = new C001414(this.$background, this.$poster, this.$logoUrl, this.$year, this.$description, this.$actorData, this.$imdbId, continuation);
            c001414.L$0 = obj;
            return c001414;
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
                    String str = (String) this.$background.element;
                    if (str == null) {
                        str = this.$poster;
                    }
                    loadResponse.setBackgroundPosterUrl(str);
                    try {
                        loadResponse.setLogoUrl(this.$logoUrl);
                        break;
                    } catch (Throwable th) {
                    }
                    loadResponse.setPosterUrl(this.$poster);
                    loadResponse.setYear((Integer) this.$year.element);
                    loadResponse.setPlot((String) this.$description.element);
                    loadResponse.setActors((List) this.$actorData.element);
                    LoadResponse.Companion.addImdbUrl(loadResponse, this.$imdbId);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.movies4u.Movies4u$load$15 */
    /* JADX INFO: compiled from: Movies4u.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.movies4u.Movies4u$load$15", f = "Movies4u.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C001515 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<List<ActorData>> $actorData;
        final /* synthetic */ Ref.ObjectRef<String> $background;
        final /* synthetic */ Ref.ObjectRef<String> $description;
        final /* synthetic */ String $imdbId;
        final /* synthetic */ String $logoUrl;
        final /* synthetic */ String $poster;
        final /* synthetic */ Ref.ObjectRef<Integer> $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C001515(Ref.ObjectRef<String> objectRef, String str, String str2, Ref.ObjectRef<Integer> objectRef2, Ref.ObjectRef<String> objectRef3, Ref.ObjectRef<List<ActorData>> objectRef4, String str3, Continuation<? super C001515> continuation) {
            super(2, continuation);
            this.$background = objectRef;
            this.$poster = str;
            this.$logoUrl = str2;
            this.$year = objectRef2;
            this.$description = objectRef3;
            this.$actorData = objectRef4;
            this.$imdbId = str3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c001515 = new C001515(this.$background, this.$poster, this.$logoUrl, this.$year, this.$description, this.$actorData, this.$imdbId, continuation);
            c001515.L$0 = obj;
            return c001515;
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
                    String str = (String) this.$background.element;
                    if (str == null) {
                        str = this.$poster;
                    }
                    loadResponse.setBackgroundPosterUrl(str);
                    try {
                        loadResponse.setLogoUrl(this.$logoUrl);
                        break;
                    } catch (Throwable th) {
                    }
                    loadResponse.setPosterUrl(this.$poster);
                    loadResponse.setYear((Integer) this.$year.element);
                    loadResponse.setPlot((String) this.$description.element);
                    loadResponse.setActors((List) this.$actorData.element);
                    LoadResponse.Companion.addImdbUrl(loadResponse, this.$imdbId);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:105:0x0110 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:0x0109  */
    /* JADX WARN: Code duplicated, block: B:56:0x0130  */
    /* JADX WARN: Code duplicated, block: B:7:0x0020  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00161 c00161;
        boolean z;
        Object obj;
        Object objDecodeFromString;
        DeserializationStrategy deserializationStrategy;
        String value$iv$iv;
        Function1<? super ExtractorLink, Unit> function3;
        Function1<? super SubtitleFile, Unit> function4 = function1;
        if (continuation instanceof C00161) {
            c00161 = (C00161) continuation;
            if ((c00161.label & Integer.MIN_VALUE) != 0) {
                c00161.label -= Integer.MIN_VALUE;
            } else {
                c00161 = new C00161(continuation);
            }
        } else {
            c00161 = new C00161(continuation);
        }
        C00161 c00162 = c00161;
        Object $result = c00162.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00162.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Object obj2 = null;
                if (StringsKt.startsWith$default(data, "[", false, 2, (Object) null)) {
                    AppUtils appUtils = AppUtils.INSTANCE;
                    if (data == null) {
                        z = false;
                    } else {
                        try {
                            Result.Companion companion = Result.Companion;
                            z = false;
                            try {
                                KType kTypeTypeOf = Reflection.typeOf(String[].class, KTypeProjection.Companion.invariant(Reflection.typeOf(String.class)));
                                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                                break;
                            } catch (Throwable th) {
                                th = th;
                                try {
                                    Result.Companion companion2 = Result.Companion;
                                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                                } catch (Exception e) {
                                    objDecodeFromString = null;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            z = false;
                        }
                        if (Result.exceptionOrNull-impl(obj) == null) {
                            if (Result.isFailure-impl(obj)) {
                                obj = null;
                            }
                            deserializationStrategy = (KSerializer) obj;
                            if (deserializationStrategy != null) {
                                try {
                                    value$iv$iv = data;
                                    try {
                                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv$iv);
                                    } catch (SerializationException e2) {
                                        e$iv$iv = e2;
                                        ArchComponentExtKt.logError((Throwable) e$iv$iv);
                                        ObjectMapper $this$readValue$iv$iv$iv = MainAPIKt.getMapper();
                                        String content$iv$iv$iv = value$iv$iv;
                                        objDecodeFromString = $this$readValue$iv$iv$iv.readValue(content$iv$iv$iv, new TypeReference<String[]>() { // from class: com.movies4u.Movies4u$loadLinks$$inlined$tryParseJson$1
                                        });
                                    } catch (Throwable th3) {
                                        ObjectMapper $this$readValue$iv$iv$iv2 = MainAPIKt.getMapper();
                                        String content$iv$iv$iv2 = value$iv$iv;
                                        objDecodeFromString = $this$readValue$iv$iv$iv2.readValue(content$iv$iv$iv2, new TypeReference<String[]>() { // from class: com.movies4u.Movies4u$loadLinks$$inlined$tryParseJson$1
                                        });
                                    }
                                } catch (SerializationException e3) {
                                    e$iv$iv = e3;
                                    value$iv$iv = data;
                                } catch (Throwable th4) {
                                    value$iv$iv = data;
                                }
                            } else {
                                value$iv$iv = data;
                            }
                            ObjectMapper $this$readValue$iv$iv$iv3 = MainAPIKt.getMapper();
                            String content$iv$iv$iv3 = value$iv$iv;
                            objDecodeFromString = $this$readValue$iv$iv$iv3.readValue(content$iv$iv$iv3, new TypeReference<String[]>() { // from class: com.movies4u.Movies4u$loadLinks$$inlined$tryParseJson$1
                            });
                        } else {
                            try {
                                Result.Companion companion3 = Result.Companion;
                                obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(String[].class), (List) null, 2, (Object) null));
                            } catch (Throwable th5) {
                                Result.Companion companion4 = Result.Companion;
                                obj = Result.constructor-impl(ResultKt.createFailure(th5));
                            }
                            if (Result.isFailure-impl(obj)) {
                                obj = null;
                            }
                            deserializationStrategy = (KSerializer) obj;
                            if (deserializationStrategy != null) {
                                value$iv$iv = data;
                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv$iv);
                            } else {
                                value$iv$iv = data;
                            }
                            ObjectMapper $this$readValue$iv$iv$iv4 = MainAPIKt.getMapper();
                            String content$iv$iv$iv4 = value$iv$iv;
                            objDecodeFromString = $this$readValue$iv$iv$iv4.readValue(content$iv$iv$iv4, new TypeReference<String[]>() { // from class: com.movies4u.Movies4u$loadLinks$$inlined$tryParseJson$1
                            });
                        }
                        obj2 = objDecodeFromString;
                    }
                    String[] strArr = (String[]) obj2;
                    List links = strArr != null ? ArraysKt.toList(strArr) : null;
                    List list = links;
                    if (list == null || list.isEmpty()) {
                        return Boxing.boxBoolean(z);
                    }
                    C00172 c00172 = new C00172(function4, function2, null);
                    c00162.L$0 = SpillingKt.nullOutSpilledVariable(data);
                    c00162.L$1 = SpillingKt.nullOutSpilledVariable(function4);
                    c00162.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                    c00162.L$3 = SpillingKt.nullOutSpilledVariable(links);
                    c00162.Z$0 = isCasting;
                    c00162.label = 1;
                    if (ParCollectionsKt.amap(links, c00172, c00162) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function3 = function2;
                    break;
                } else if (StringsKt.contains$default(data, "M4ulinks", false, 2, (Object) null)) {
                    M4ulinks m4ulinks = new M4ulinks();
                    String name = getName();
                    c00162.L$0 = SpillingKt.nullOutSpilledVariable(data);
                    c00162.L$1 = SpillingKt.nullOutSpilledVariable(function4);
                    c00162.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                    c00162.Z$0 = isCasting;
                    c00162.label = 2;
                    if (m4ulinks.getUrl(data, name, function4, function2, c00162) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    String name2 = getName();
                    c00162.L$0 = SpillingKt.nullOutSpilledVariable(data);
                    c00162.L$1 = SpillingKt.nullOutSpilledVariable(function4);
                    c00162.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                    c00162.Z$0 = isCasting;
                    c00162.label = 3;
                    if (ExtractorApiKt.loadExtractor(data, name2, function4, function2, c00162) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Boxing.boxBoolean(true);
            case 1:
                boolean isCasting2 = c00162.Z$0;
                function3 = (Function1) c00162.L$2;
                function4 = (Function1) c00162.L$1;
                ResultKt.throwOnFailure($result);
                return Boxing.boxBoolean(true);
            case 2:
                boolean isCasting3 = c00162.Z$0;
                ResultKt.throwOnFailure($result);
                return Boxing.boxBoolean(true);
            case 3:
                boolean z2 = c00162.Z$0;
                ResultKt.throwOnFailure($result);
                return Boxing.boxBoolean(true);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.movies4u.Movies4u$loadLinks$2 */
    /* JADX INFO: compiled from: Movies4u.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "link", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.movies4u.Movies4u$loadLinks$2", f = "Movies4u.kt", i = {0}, l = {371}, m = "invokeSuspend", n = {"link"}, nl = {373}, s = {"L$0"}, v = 2)
    static final class C00172 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00172(Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super C00172> continuation) {
            super(2, continuation);
            this.$subtitleCallback = function1;
            this.$callback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00172 = Movies4u.this.new C00172(this.$subtitleCallback, this.$callback, continuation);
            c00172.L$0 = obj;
            return c00172;
        }

        public final Object invoke(String str, Continuation<? super Unit> continuation) {
            return create(str, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            String link = (String) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    if (!StringsKt.isBlank(link)) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(link);
                        this.label = 1;
                        if (ExtractorApiKt.loadExtractor(link, Movies4u.this.getName(), this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
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
