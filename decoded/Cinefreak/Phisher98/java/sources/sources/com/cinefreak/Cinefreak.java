package com.cinefreak;

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
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
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
import kotlin.text.MatchResult;
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

/* JADX INFO: compiled from: Cinefreak.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Cinefreak/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 D2\u00020\u0001:\u0004DEFGB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010 \u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0096@¢\u0006\u0002\u0010)J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0002J\u001e\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&H\u0096@¢\u0006\u0002\u00101J\u0016\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u00105JF\u00106\u001a\u00020\u00112\u0006\u00107\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u00112\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020<0:2\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020<0:H\u0096@¢\u0006\u0002\u0010?J\u0012\u0010@\u001a\u0004\u0018\u00010A2\b\u0010B\u001a\u0004\u0018\u00010\u0005J\u0010\u0010C\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u0005H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0011X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u0011X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001a\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050#X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/cinefreak/Cinefreak;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "lang", "getLang", "setLang", "hasMainPage", "", "getHasMainPage", "()Z", "hasDownloadSupport", "getHasDownloadSupport", "hasQuickSearch", "getHasQuickSearch", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "headers", "", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "post", "Lorg/jsoup/nodes/Element;", "search", "Lcom/lagradost/cloudstream3/SearchResponseList;", "query", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSearchQuality", "Lcom/lagradost/cloudstream3/SearchQuality;", "check", "getBaseUrl", "Companion", "EpisodeLinkHrefs", "SearchData", "Result", "Cinefreak"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCinefreak.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Cinefreak.kt\ncom/cinefreak/Cinefreak\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 5 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 6 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,701:1\n1795#2,10:702\n2068#2:712\n2069#2:714\n1805#2:715\n1739#2:722\n1814#2,3:723\n1739#2:726\n1814#2,3:727\n812#2,12:787\n2068#2,2:799\n812#2,12:801\n1795#2,10:813\n2068#2:823\n2069#2:825\n1805#2:826\n812#2,12:846\n2068#2,2:858\n832#2:860\n862#2,2:861\n2068#2:863\n2068#2,2:864\n2069#2:866\n2068#2:867\n2068#2,2:868\n2069#2:870\n1#3:713\n1#3:716\n1#3:731\n1#3:750\n1#3:769\n1#3:824\n1#3:828\n1#3:874\n1#3:894\n1#3:898\n1#3:918\n73#4,5:717\n63#5:730\n64#5,15:732\n63#5:749\n64#5,15:751\n63#5:768\n64#5,15:770\n63#5:827\n64#5,15:829\n93#5,2:871\n63#5:873\n64#5,15:875\n95#5,2:892\n93#5,2:895\n63#5:897\n64#5,15:899\n95#5,2:916\n50#6:747\n43#6:748\n50#6:766\n43#6:767\n50#6:785\n43#6:786\n50#6:844\n43#6:845\n50#6:890\n43#6:891\n50#6:914\n43#6:915\n*S KotlinDebug\n*F\n+ 1 Cinefreak.kt\ncom/cinefreak/Cinefreak\n*L\n88#1:702,10\n88#1:712\n88#1:714\n88#1:715\n114#1:722\n114#1:723,3\n178#1:726\n178#1:727,3\n336#1:787,12\n337#1:799,2\n351#1:801,12\n352#1:813,10\n352#1:823\n352#1:825\n352#1:826\n376#1:846,12\n377#1:858,2\n425#1:860\n425#1:861,2\n434#1:863\n445#1:864,2\n434#1:866\n496#1:867\n528#1:868,2\n496#1:870\n88#1:713\n225#1:731\n251#1:750\n274#1:769\n352#1:824\n369#1:828\n581#1:874\n586#1:898\n110#1:717,5\n225#1:730\n225#1:732,15\n251#1:749\n251#1:751,15\n274#1:768\n274#1:770,15\n369#1:827\n369#1:829,15\n581#1:871,2\n581#1:873\n581#1:875,15\n581#1:892,2\n586#1:895,2\n586#1:897\n586#1:899,15\n586#1:916,2\n225#1:747\n225#1:748\n251#1:766\n251#1:767\n274#1:785\n274#1:786\n369#1:844\n369#1:845\n581#1:890\n581#1:891\n586#1:914\n586#1:915\n*E\n"})
public class Cinefreak extends MainAPI {

    @NotNull
    public static final String TMDBAPI = "https://api.themoviedb.org/3";

    @NotNull
    public static final String TMDBAPIKEY = "1865f43a0549ca50d341dd9ab8b29f49";

    @NotNull
    public static final String TMDBBASE = "https://image.tmdb.org/t/p/original";
    private final boolean hasQuickSearch;

    @NotNull
    private String mainUrl = (String) BuildersKt.runBlockingK(EmptyCoroutineContext.INSTANCE, new Cinefreak$mainUrl$1(null));

    @NotNull
    private String name = "Cinefreak";

    @NotNull
    private String lang = "bn";
    private final boolean hasMainPage = true;
    private final boolean hasDownloadSupport = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.TvSeries, TvType.Anime});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("", "Home"), TuplesKt.to("animation", "Animation"), TuplesKt.to("bangla-movies", "Bangla Movies"), TuplesKt.to("bangla-dubbed", "Bangla Dubbed"), TuplesKt.to("chinese", "Chinese"), TuplesKt.to("dual-audio", "Dual Audio"), TuplesKt.to("english-movies", "English Movies"), TuplesKt.to("hindi-movies", "Hindi Movies"), TuplesKt.to("hindi-dubbed-movies", "Hindi Dubbed Movies"), TuplesKt.to("japanese", "Japanese"), TuplesKt.to("k-drama", "K-Drama"), TuplesKt.to("korean", "Korean"), TuplesKt.to("kannada", "Kannada"), TuplesKt.to("telugu", "Telugu"), TuplesKt.to("tamil", "Tamil"), TuplesKt.to("malayalam", "Malayalam"), TuplesKt.to("indonesian", "Indonesian"), TuplesKt.to("others", "Others"), TuplesKt.to("spanish", "Spanish")});

    @NotNull
    private final Map<String, String> headers = MapsKt.mapOf(new Pair[]{TuplesKt.to("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36 Edg/131.0.0.0"), TuplesKt.to("Cookie", "xla=s4t")});

    /* JADX INFO: renamed from: com.cinefreak.Cinefreak$getMainPage$1 */
    /* JADX INFO: compiled from: Cinefreak.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.cinefreak.Cinefreak", f = "Cinefreak.kt", i = {0, 0, 0, 0}, l = {87}, m = "getMainPage$suspendImpl", n = {"$this", "request", "url", "page"}, nl = {88}, s = {"L$0", "L$1", "L$2", "I$0"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00011(Continuation<? super C00011> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Cinefreak.getMainPage$suspendImpl(Cinefreak.this, 0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cinefreak.Cinefreak$load$1 */
    /* JADX INFO: compiled from: Cinefreak.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.cinefreak.Cinefreak", f = "Cinefreak.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6}, l = {139, 226, 252, 275, 370, 474, 555}, m = "load$suspendImpl", n = {"$this", "url", "$this", "url", "doc", "fullTitleText", "title", "seasonTitle", "seasonNumber", "plot", "tags", "poster", "trailer", "tvtype", "recommendations", "actorData", "genre", "year", "background", "description", "tmdbIdResolved", "$this$load_u24lambda_u243", "imdbId", "resultKey", "$this", "url", "doc", "fullTitleText", "title", "seasonTitle", "seasonNumber", "plot", "tags", "poster", "trailer", "tvtype", "recommendations", "actorData", "genre", "year", "background", "description", "tmdbIdResolved", "$this$load_u24lambda_u243", "query", "type", "$this", "url", "doc", "fullTitleText", "title", "seasonTitle", "seasonNumber", "plot", "tags", "poster", "trailer", "tvtype", "recommendations", "actorData", "genre", "year", "background", "description", "tmdbIdResolved", "$this$load_u24lambda_u244", "type", "$this", "url", "doc", "fullTitleText", "title", "seasonTitle", "seasonNumber", "plot", "tags", "poster", "trailer", "tvtype", "recommendations", "actorData", "genre", "year", "background", "description", "tmdbIdResolved", "$this$load_u24lambda_u244", "type", "metaName", "metaDesc", "yearRaw", "metaYear", "metaRating", "metaBackground", "externalIds", "imdbId", "logoPath", "details", "actorDataList", "metaGenres", "videos", "totalSeasons", "season", "$this", "url", "doc", "fullTitleText", "title", "seasonTitle", "seasonNumber", "plot", "tags", "poster", "trailer", "tvtype", "recommendations", "actorData", "genre", "year", "background", "description", "tmdbIdResolved", "responseData", "movieLinks", "qualityCount", "loadData", "$this", "url", "doc", "fullTitleText", "title", "seasonTitle", "seasonNumber", "plot", "tags", "poster", "trailer", "tvtype", "recommendations", "actorData", "genre", "year", "background", "description", "tmdbIdResolved", "responseData", "episodesData"}, nl = {141, 228, 254, 277, 372, 494, -1}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$28", "L$29", "L$30", "L$31", "L$32", "L$33", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20"}, v = 2)
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
        int label;
        /* synthetic */ Object result;

        C00021(Continuation<? super C00021> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Cinefreak.load$suspendImpl(Cinefreak.this, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cinefreak.Cinefreak$loadLinks$1 */
    /* JADX INFO: compiled from: Cinefreak.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.cinefreak.Cinefreak", f = "Cinefreak.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {590}, m = "loadLinks$suspendImpl", n = {"$this", "data", "subtitleCallback", "callback", "parsed", "links", "isCasting"}, nl = {626}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0"}, v = 2)
    static final class C00051 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
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
            return Cinefreak.loadLinks$suspendImpl(Cinefreak.this, null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cinefreak.Cinefreak$search$1 */
    /* JADX INFO: compiled from: Cinefreak.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.cinefreak.Cinefreak", f = "Cinefreak.kt", i = {0, 0, 0}, l = {108}, m = "search$suspendImpl", n = {"$this", "query", "page"}, nl = {110}, s = {"L$0", "L$1", "I$0"}, v = 2)
    static final class C00071 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00071(Continuation<? super C00071> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Cinefreak.search$suspendImpl(Cinefreak.this, null, 0, (Continuation) this);
        }
    }

    @Nullable
    public Object getMainPage(int i, @NotNull MainPageRequest mainPageRequest, @NotNull Continuation<? super HomePageResponse> continuation) {
        return getMainPage$suspendImpl(this, i, mainPageRequest, continuation);
    }

    @Nullable
    public Object load(@NotNull String str, @NotNull Continuation<? super LoadResponse> continuation) {
        return load$suspendImpl(this, str, continuation);
    }

    @Nullable
    public Object loadLinks(@NotNull String str, boolean z, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        return loadLinks$suspendImpl(this, str, z, function1, function2, continuation);
    }

    @Nullable
    public Object search(@NotNull String str, int i, @NotNull Continuation<? super SearchResponseList> continuation) {
        return search$suspendImpl(this, str, i, continuation);
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
    static /* synthetic */ Object getMainPage$suspendImpl(Cinefreak $this, int page, MainPageRequest request, Continuation<? super HomePageResponse> continuation) {
        C00011 c00011;
        StringBuilder sb;
        StringBuilder sbAppend;
        boolean z;
        Cinefreak $this2;
        MainPageRequest request2;
        int page2 = page;
        if (continuation instanceof C00011) {
            c00011 = (C00011) continuation;
            if ((c00011.label & Integer.MIN_VALUE) != 0) {
                c00011.label -= Integer.MIN_VALUE;
            } else {
                c00011 = $this.new C00011(continuation);
            }
        } else {
            c00011 = $this.new C00011(continuation);
        }
        Object $result = c00011.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00011.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (page2 == 1) {
                    sb = new StringBuilder();
                    sbAppend = sb.append($this.getMainUrl()).append('/').append(request.getData());
                } else {
                    sb = new StringBuilder();
                    sbAppend = sb.append($this.getMainUrl()).append('/').append(request.getData()).append("/page/").append(page2).append('/');
                }
                String url = sbAppend.toString();
                Requests app = MainActivityKt.getApp();
                c00011.L$0 = $this;
                c00011.L$1 = request;
                c00011.L$2 = SpillingKt.nullOutSpilledVariable(url);
                c00011.I$0 = page2;
                c00011.label = 1;
                z = true;
                $result = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00011, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $this2 = $this;
                request2 = request;
                break;
                break;
            case 1:
                page2 = c00011.I$0;
                request2 = (MainPageRequest) c00011.L$1;
                $this2 = (Cinefreak) c00011.L$0;
                ResultKt.throwOnFailure($result);
                z = true;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document doc = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv = doc.select("div.card-grid a");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            int page3 = page2;
            Element it = (Element) element$iv$iv$iv;
            SearchResponse result = $this2.toResult(it);
            if (result != null) {
                destination$iv$iv.add(result);
            }
            page2 = page3;
        }
        List home = (List) destination$iv$iv;
        return MainAPIKt.newHomePageResponse(request2.getName(), home, Boxing.boxBoolean(z));
    }

    private final SearchResponse toResult(final Element post) {
        String titleText = post.select("h3").text();
        String title = UtilsKt.cleanTitle(titleText);
        String url = post.attr("href");
        String strAttr = post.select("img").attr("data-lazy-src");
        if (StringsKt.isBlank(strAttr)) {
            strAttr = post.select("img").attr("src");
        }
        final String poster = strAttr;
        final Score score = Score.Companion.from10(post.select("div.rating").text());
        return MainAPIKt.newMovieSearchResponse$default(this, title, url, TvType.Movie, false, new Function1() { // from class: com.cinefreak.Cinefreak$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return Cinefreak.toResult$lambda$1(poster, score, this, post, (MovieSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toResult$lambda$1(String $poster, Score $score, Cinefreak this$0, Element $post, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl(StringsKt.replace$default($poster, "/w185/", "/w500/", false, 4, (Object) null));
        $this$newMovieSearchResponse.setScore($score);
        $this$newMovieSearchResponse.setQuality(this$0.getSearchQuality($post.select("div.quality-badges span").text()));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    static /* synthetic */ Object search$suspendImpl(Cinefreak $this, String query, int page, Continuation<? super SearchResponseList> continuation) {
        C00071 c00071;
        Cinefreak $this2;
        Object obj;
        int page2;
        Object safe;
        if (continuation instanceof C00071) {
            c00071 = (C00071) continuation;
            if ((c00071.label & Integer.MIN_VALUE) != 0) {
                c00071.label -= Integer.MIN_VALUE;
            } else {
                c00071 = $this.new C00071(continuation);
            }
        } else {
            c00071 = $this.new C00071(continuation);
        }
        Object $result = c00071.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00071.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                String str = $this.getMainUrl() + "/search-api.php?q=" + query + "&pg=" + page;
                c00071.L$0 = $this;
                c00071.L$1 = SpillingKt.nullOutSpilledVariable(query);
                c00071.I$0 = page;
                c00071.label = 1;
                Object obj2 = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00071, 4094, (Object) null);
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $this2 = $this;
                obj = obj2;
                page2 = page;
                break;
                break;
            case 1:
                int page3 = c00071.I$0;
                Cinefreak $this3 = (Cinefreak) c00071.L$0;
                ResultKt.throwOnFailure($result);
                $this2 = $this3;
                page2 = page3;
                obj = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NiceResponse this_$iv = (NiceResponse) obj;
        try {
            ResponseParser parser = this_$iv.getParser();
            Intrinsics.checkNotNull(parser);
            safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(SearchData.class));
        } catch (Exception e$iv) {
            e$iv.printStackTrace();
            safe = null;
        }
        SearchData searchData = (SearchData) safe;
        List results = searchData != null ? searchData.getResults() : null;
        if (results == null) {
            results = CollectionsKt.emptyList();
        }
        List $this$map$iv = results;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Result obj3 = (Result) item$iv$iv;
            List results2 = results;
            int page4 = page2;
            String href = StringsKt.startsWith$default(obj3.getL(), "http", false, 2, (Object) null) ? obj3.getL() : $this2.getMainUrl() + '/' + obj3.getL() + '/';
            TvType type = (StringsKt.contains(obj3.getT(), "season", true) || StringsKt.contains(obj3.getT(), "series", true) || StringsKt.contains(obj3.getT(), "episode", true) || StringsKt.contains(obj3.getT(), "s0", true)) ? TvType.TvSeries : TvType.Movie;
            final String poster = StringsKt.contains(obj3.getI(), $this2.getName(), true) ? $this2.getMainUrl() + StringsKt.replace$default(obj3.getI(), $this2.getBaseUrl(obj3.getI()), "", false, 4, (Object) null) : obj3.getI();
            destination$iv$iv.add(MainAPIKt.newMovieSearchResponse$default($this2, obj3.getT(), href, type, false, new Function1() { // from class: com.cinefreak.Cinefreak$$ExternalSyntheticLambda0
                public final Object invoke(Object obj4) {
                    return Cinefreak.search$lambda$0$0(poster, (MovieSearchResponse) obj4);
                }
            }, 8, (Object) null));
            results = results2;
            page2 = page4;
        }
        return MainAPIKt.toNewSearchResponseList$default((List) destination$iv$iv, (Boolean) null, 1, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit search$lambda$0$0(String $poster, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($poster);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:1166:0x1c5a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:1170:0x1cc7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:449:0x1688 A[Catch: all -> 0x208d, TRY_ENTER, TRY_LEAVE, TryCatch #88 {all -> 0x208d, blocks: (B:415:0x15ea, B:422:0x1619, B:425:0x1620, B:438:0x1662, B:467:0x16f8, B:479:0x171d, B:496:0x1750, B:506:0x1767, B:512:0x1779, B:449:0x1688, B:437:0x164d, B:421:0x160e, B:414:0x15e0, B:418:0x15f1), top: B:1144:0x15e0, inners: #87 }] */
    /* JADX WARN: Code duplicated, block: B:459:0x16a8 A[Catch: all -> 0x163c, TryCatch #17 {all -> 0x163c, blocks: (B:440:0x166f, B:442:0x1676, B:462:0x16b1, B:464:0x16d4, B:469:0x1700, B:471:0x1707, B:481:0x1725, B:483:0x172b, B:485:0x1733, B:487:0x173c, B:490:0x1743, B:502:0x1760, B:508:0x176f, B:451:0x1690, B:453:0x1697, B:459:0x16a8, B:433:0x1635, B:428:0x1626), top: B:1013:0x1623, inners: #96 }] */
    /* JADX WARN: Code duplicated, block: B:477:0x1717  */
    /* JADX WARN: Code duplicated, block: B:655:0x1b8a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:656:0x1b8b  */
    /* JADX WARN: Code duplicated, block: B:687:0x1c4d A[Catch: all -> 0x1e22, PHI: r0
      0x1c4d: PHI (r0v96 java.lang.Object) = (r0v88 java.lang.Object), (r0v92 java.lang.Object), (r0v95 java.lang.Object) binds: [B:681:0x1c20, B:686:0x1c42, B:683:0x1c23] A[DONT_GENERATE, DONT_INLINE], TryCatch #1 {all -> 0x1e22, blocks: (B:680:0x1c1c, B:687:0x1c4d, B:690:0x1c54, B:700:0x1c88, B:702:0x1c97, B:705:0x1c9d, B:706:0x1cae, B:708:0x1cb4, B:710:0x1cc4, B:712:0x1ccc, B:713:0x1cde, B:715:0x1ce4, B:717:0x1cfd, B:719:0x1d06, B:721:0x1d17, B:723:0x1d1e, B:725:0x1d27, B:727:0x1d2f, B:729:0x1d38, B:731:0x1d44, B:733:0x1d4c, B:738:0x1d61, B:743:0x1d93, B:745:0x1d9b, B:747:0x1da4, B:749:0x1dae, B:751:0x1db4, B:752:0x1dcd, B:699:0x1c6f, B:698:0x1c69, B:686:0x1c42, B:679:0x1c12, B:683:0x1c23, B:693:0x1c5a), top: B:985:0x1c1c, inners: #22, #42, #94 }] */
    /* JADX WARN: Code duplicated, block: B:689:0x1c53  */
    /* JADX WARN: Code duplicated, block: B:702:0x1c97 A[Catch: all -> 0x1e22, TryCatch #1 {all -> 0x1e22, blocks: (B:680:0x1c1c, B:687:0x1c4d, B:690:0x1c54, B:700:0x1c88, B:702:0x1c97, B:705:0x1c9d, B:706:0x1cae, B:708:0x1cb4, B:710:0x1cc4, B:712:0x1ccc, B:713:0x1cde, B:715:0x1ce4, B:717:0x1cfd, B:719:0x1d06, B:721:0x1d17, B:723:0x1d1e, B:725:0x1d27, B:727:0x1d2f, B:729:0x1d38, B:731:0x1d44, B:733:0x1d4c, B:738:0x1d61, B:743:0x1d93, B:745:0x1d9b, B:747:0x1da4, B:749:0x1dae, B:751:0x1db4, B:752:0x1dcd, B:699:0x1c6f, B:698:0x1c69, B:686:0x1c42, B:679:0x1c12, B:683:0x1c23, B:693:0x1c5a), top: B:985:0x1c1c, inners: #22, #42, #94 }] */
    /* JADX WARN: Code duplicated, block: B:703:0x1c9a  */
    /* JADX WARN: Code duplicated, block: B:705:0x1c9d A[Catch: all -> 0x1e22, TryCatch #1 {all -> 0x1e22, blocks: (B:680:0x1c1c, B:687:0x1c4d, B:690:0x1c54, B:700:0x1c88, B:702:0x1c97, B:705:0x1c9d, B:706:0x1cae, B:708:0x1cb4, B:710:0x1cc4, B:712:0x1ccc, B:713:0x1cde, B:715:0x1ce4, B:717:0x1cfd, B:719:0x1d06, B:721:0x1d17, B:723:0x1d1e, B:725:0x1d27, B:727:0x1d2f, B:729:0x1d38, B:731:0x1d44, B:733:0x1d4c, B:738:0x1d61, B:743:0x1d93, B:745:0x1d9b, B:747:0x1da4, B:749:0x1dae, B:751:0x1db4, B:752:0x1dcd, B:699:0x1c6f, B:698:0x1c69, B:686:0x1c42, B:679:0x1c12, B:683:0x1c23, B:693:0x1c5a), top: B:985:0x1c1c, inners: #22, #42, #94 }] */
    /* JADX WARN: Code duplicated, block: B:708:0x1cb4 A[Catch: all -> 0x1e22, TryCatch #1 {all -> 0x1e22, blocks: (B:680:0x1c1c, B:687:0x1c4d, B:690:0x1c54, B:700:0x1c88, B:702:0x1c97, B:705:0x1c9d, B:706:0x1cae, B:708:0x1cb4, B:710:0x1cc4, B:712:0x1ccc, B:713:0x1cde, B:715:0x1ce4, B:717:0x1cfd, B:719:0x1d06, B:721:0x1d17, B:723:0x1d1e, B:725:0x1d27, B:727:0x1d2f, B:729:0x1d38, B:731:0x1d44, B:733:0x1d4c, B:738:0x1d61, B:743:0x1d93, B:745:0x1d9b, B:747:0x1da4, B:749:0x1dae, B:751:0x1db4, B:752:0x1dcd, B:699:0x1c6f, B:698:0x1c69, B:686:0x1c42, B:679:0x1c12, B:683:0x1c23, B:693:0x1c5a), top: B:985:0x1c1c, inners: #22, #42, #94 }] */
    /* JADX WARN: Code duplicated, block: B:710:0x1cc4 A[Catch: all -> 0x1e22, TryCatch #1 {all -> 0x1e22, blocks: (B:680:0x1c1c, B:687:0x1c4d, B:690:0x1c54, B:700:0x1c88, B:702:0x1c97, B:705:0x1c9d, B:706:0x1cae, B:708:0x1cb4, B:710:0x1cc4, B:712:0x1ccc, B:713:0x1cde, B:715:0x1ce4, B:717:0x1cfd, B:719:0x1d06, B:721:0x1d17, B:723:0x1d1e, B:725:0x1d27, B:727:0x1d2f, B:729:0x1d38, B:731:0x1d44, B:733:0x1d4c, B:738:0x1d61, B:743:0x1d93, B:745:0x1d9b, B:747:0x1da4, B:749:0x1dae, B:751:0x1db4, B:752:0x1dcd, B:699:0x1c6f, B:698:0x1c69, B:686:0x1c42, B:679:0x1c12, B:683:0x1c23, B:693:0x1c5a), top: B:985:0x1c1c, inners: #22, #42, #94 }] */
    /* JADX WARN: Code duplicated, block: B:715:0x1ce4 A[Catch: all -> 0x1e22, TryCatch #1 {all -> 0x1e22, blocks: (B:680:0x1c1c, B:687:0x1c4d, B:690:0x1c54, B:700:0x1c88, B:702:0x1c97, B:705:0x1c9d, B:706:0x1cae, B:708:0x1cb4, B:710:0x1cc4, B:712:0x1ccc, B:713:0x1cde, B:715:0x1ce4, B:717:0x1cfd, B:719:0x1d06, B:721:0x1d17, B:723:0x1d1e, B:725:0x1d27, B:727:0x1d2f, B:729:0x1d38, B:731:0x1d44, B:733:0x1d4c, B:738:0x1d61, B:743:0x1d93, B:745:0x1d9b, B:747:0x1da4, B:749:0x1dae, B:751:0x1db4, B:752:0x1dcd, B:699:0x1c6f, B:698:0x1c69, B:686:0x1c42, B:679:0x1c12, B:683:0x1c23, B:693:0x1c5a), top: B:985:0x1c1c, inners: #22, #42, #94 }] */
    /* JADX WARN: Code duplicated, block: B:717:0x1cfd A[Catch: all -> 0x1e22, TryCatch #1 {all -> 0x1e22, blocks: (B:680:0x1c1c, B:687:0x1c4d, B:690:0x1c54, B:700:0x1c88, B:702:0x1c97, B:705:0x1c9d, B:706:0x1cae, B:708:0x1cb4, B:710:0x1cc4, B:712:0x1ccc, B:713:0x1cde, B:715:0x1ce4, B:717:0x1cfd, B:719:0x1d06, B:721:0x1d17, B:723:0x1d1e, B:725:0x1d27, B:727:0x1d2f, B:729:0x1d38, B:731:0x1d44, B:733:0x1d4c, B:738:0x1d61, B:743:0x1d93, B:745:0x1d9b, B:747:0x1da4, B:749:0x1dae, B:751:0x1db4, B:752:0x1dcd, B:699:0x1c6f, B:698:0x1c69, B:686:0x1c42, B:679:0x1c12, B:683:0x1c23, B:693:0x1c5a), top: B:985:0x1c1c, inners: #22, #42, #94 }] */
    /* JADX WARN: Code duplicated, block: B:718:0x1d04  */
    /* JADX WARN: Code duplicated, block: B:721:0x1d17 A[Catch: all -> 0x1e22, TryCatch #1 {all -> 0x1e22, blocks: (B:680:0x1c1c, B:687:0x1c4d, B:690:0x1c54, B:700:0x1c88, B:702:0x1c97, B:705:0x1c9d, B:706:0x1cae, B:708:0x1cb4, B:710:0x1cc4, B:712:0x1ccc, B:713:0x1cde, B:715:0x1ce4, B:717:0x1cfd, B:719:0x1d06, B:721:0x1d17, B:723:0x1d1e, B:725:0x1d27, B:727:0x1d2f, B:729:0x1d38, B:731:0x1d44, B:733:0x1d4c, B:738:0x1d61, B:743:0x1d93, B:745:0x1d9b, B:747:0x1da4, B:749:0x1dae, B:751:0x1db4, B:752:0x1dcd, B:699:0x1c6f, B:698:0x1c69, B:686:0x1c42, B:679:0x1c12, B:683:0x1c23, B:693:0x1c5a), top: B:985:0x1c1c, inners: #22, #42, #94 }] */
    /* JADX WARN: Code duplicated, block: B:724:0x1d25  */
    /* JADX WARN: Code duplicated, block: B:727:0x1d2f A[Catch: all -> 0x1e22, TryCatch #1 {all -> 0x1e22, blocks: (B:680:0x1c1c, B:687:0x1c4d, B:690:0x1c54, B:700:0x1c88, B:702:0x1c97, B:705:0x1c9d, B:706:0x1cae, B:708:0x1cb4, B:710:0x1cc4, B:712:0x1ccc, B:713:0x1cde, B:715:0x1ce4, B:717:0x1cfd, B:719:0x1d06, B:721:0x1d17, B:723:0x1d1e, B:725:0x1d27, B:727:0x1d2f, B:729:0x1d38, B:731:0x1d44, B:733:0x1d4c, B:738:0x1d61, B:743:0x1d93, B:745:0x1d9b, B:747:0x1da4, B:749:0x1dae, B:751:0x1db4, B:752:0x1dcd, B:699:0x1c6f, B:698:0x1c69, B:686:0x1c42, B:679:0x1c12, B:683:0x1c23, B:693:0x1c5a), top: B:985:0x1c1c, inners: #22, #42, #94 }] */
    /* JADX WARN: Code duplicated, block: B:728:0x1d36  */
    /* JADX WARN: Code duplicated, block: B:731:0x1d44 A[Catch: all -> 0x1e22, TryCatch #1 {all -> 0x1e22, blocks: (B:680:0x1c1c, B:687:0x1c4d, B:690:0x1c54, B:700:0x1c88, B:702:0x1c97, B:705:0x1c9d, B:706:0x1cae, B:708:0x1cb4, B:710:0x1cc4, B:712:0x1ccc, B:713:0x1cde, B:715:0x1ce4, B:717:0x1cfd, B:719:0x1d06, B:721:0x1d17, B:723:0x1d1e, B:725:0x1d27, B:727:0x1d2f, B:729:0x1d38, B:731:0x1d44, B:733:0x1d4c, B:738:0x1d61, B:743:0x1d93, B:745:0x1d9b, B:747:0x1da4, B:749:0x1dae, B:751:0x1db4, B:752:0x1dcd, B:699:0x1c6f, B:698:0x1c69, B:686:0x1c42, B:679:0x1c12, B:683:0x1c23, B:693:0x1c5a), top: B:985:0x1c1c, inners: #22, #42, #94 }] */
    /* JADX WARN: Code duplicated, block: B:741:0x1d8b A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:745:0x1d9b A[Catch: all -> 0x1e22, TryCatch #1 {all -> 0x1e22, blocks: (B:680:0x1c1c, B:687:0x1c4d, B:690:0x1c54, B:700:0x1c88, B:702:0x1c97, B:705:0x1c9d, B:706:0x1cae, B:708:0x1cb4, B:710:0x1cc4, B:712:0x1ccc, B:713:0x1cde, B:715:0x1ce4, B:717:0x1cfd, B:719:0x1d06, B:721:0x1d17, B:723:0x1d1e, B:725:0x1d27, B:727:0x1d2f, B:729:0x1d38, B:731:0x1d44, B:733:0x1d4c, B:738:0x1d61, B:743:0x1d93, B:745:0x1d9b, B:747:0x1da4, B:749:0x1dae, B:751:0x1db4, B:752:0x1dcd, B:699:0x1c6f, B:698:0x1c69, B:686:0x1c42, B:679:0x1c12, B:683:0x1c23, B:693:0x1c5a), top: B:985:0x1c1c, inners: #22, #42, #94 }] */
    /* JADX WARN: Code duplicated, block: B:746:0x1da2  */
    /* JADX WARN: Code duplicated, block: B:749:0x1dae A[Catch: all -> 0x1e22, TryCatch #1 {all -> 0x1e22, blocks: (B:680:0x1c1c, B:687:0x1c4d, B:690:0x1c54, B:700:0x1c88, B:702:0x1c97, B:705:0x1c9d, B:706:0x1cae, B:708:0x1cb4, B:710:0x1cc4, B:712:0x1ccc, B:713:0x1cde, B:715:0x1ce4, B:717:0x1cfd, B:719:0x1d06, B:721:0x1d17, B:723:0x1d1e, B:725:0x1d27, B:727:0x1d2f, B:729:0x1d38, B:731:0x1d44, B:733:0x1d4c, B:738:0x1d61, B:743:0x1d93, B:745:0x1d9b, B:747:0x1da4, B:749:0x1dae, B:751:0x1db4, B:752:0x1dcd, B:699:0x1c6f, B:698:0x1c69, B:686:0x1c42, B:679:0x1c12, B:683:0x1c23, B:693:0x1c5a), top: B:985:0x1c1c, inners: #22, #42, #94 }] */
    /* JADX WARN: Code duplicated, block: B:750:0x1db3  */
    /* JADX WARN: Code duplicated, block: B:754:0x1dd6  */
    /* JADX WARN: Code duplicated, block: B:757:0x1ddb  */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    /* JADX WARN: Failed to apply debug info
    jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 107561. Try increasing type updates limit count.
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
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 25, insn: 0x04da: MOVE (r41 I:??[OBJECT, ARRAY]) = (r25 I:??[OBJECT, ARRAY] A[D('description' kotlin.jvm.internal.Ref$ObjectRef)]), block:B:31:0x04cd */
    /* JADX WARN: Not initialized variable reg: 26, insn: 0x04dc: MOVE (r43 I:??[OBJECT, ARRAY]) = (r26 I:??[OBJECT, ARRAY] A[D('background' kotlin.jvm.internal.Ref$ObjectRef)]), block:B:31:0x04cd */
    /* JADX WARN: Not initialized variable reg: 27, insn: 0x04de: MOVE (r45 I:??[OBJECT, ARRAY]) = (r27 I:??[OBJECT, ARRAY] A[D('year' kotlin.jvm.internal.Ref$ObjectRef)]), block:B:31:0x04cd */
    /* JADX WARN: Not initialized variable reg: 28, insn: 0x04eb: MOVE (r38 I:??[OBJECT, ARRAY] A[D('title' kotlin.jvm.internal.Ref$ObjectRef)]) = (r28 I:??[OBJECT, ARRAY] A[D('genre' kotlin.jvm.internal.Ref$ObjectRef)]), block:B:31:0x04cd */
    /* JADX WARN: Not initialized variable reg: 29, insn: 0x04e0: MOVE (r26 I:??[OBJECT, ARRAY] A[D('background' kotlin.jvm.internal.Ref$ObjectRef)]) = (r29 I:??[OBJECT, ARRAY] A[D('actorData' kotlin.jvm.internal.Ref$ObjectRef)]), block:B:31:0x04cd */
    /* JADX WARN: Not initialized variable reg: 30, insn: 0x04e2: MOVE (r42 I:??[OBJECT, ARRAY]) = (r30 I:??[OBJECT, ARRAY] A[D('recommendations' java.util.List)]), block:B:31:0x04cd */
    /* JADX WARN: Not initialized variable reg: 31, insn: 0x04e4: MOVE (r48 I:??[OBJECT, ARRAY]) = (r31 I:??[OBJECT, ARRAY] A[D('tvtype' com.lagradost.cloudstream3.TvType)]), block:B:31:0x04cd */
    /* JADX WARN: Not initialized variable reg: 38, insn: 0x04e6: MOVE (r29 I:??[OBJECT, ARRAY] A[D('actorData' kotlin.jvm.internal.Ref$ObjectRef)]) = (r38 I:??[OBJECT, ARRAY] A[D('title' kotlin.jvm.internal.Ref$ObjectRef)]), block:B:31:0x04cd */
    /* JADX WARN: Path cross not found for [B:1160:0x1017, B:304:0x102c], limit reached: 1136 */
    /* JADX WARN: Path cross not found for [B:1162:0x1626, B:437:0x164d], limit reached: 1136 */
    /* JADX WARN: Path cross not found for [B:1164:0x09e0, B:174:0x09f5], limit reached: 1136 */
    /* JADX WARN: Type inference failed for: r15v139 */
    /* JADX WARN: Type inference failed for: r15v140 */
    /* JADX WARN: Type inference failed for: r15v141 */
    /* JADX WARN: Type inference failed for: r15v20, names: [seasonNumber], types: [java.lang.Integer, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v21, names: [seasonNumber], types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r15v23 */
    /* JADX WARN: Type inference failed for: r15v24, names: [seasonNumber], types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r15v32 */
    /* JADX WARN: Type inference failed for: r15v34, names: [recommendations], types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r46v15, names: [seasonNumber], types: [java.lang.Integer, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r46v16 */
    /* JADX WARN: Type inference failed for: r46v17, names: [seasonNumber], types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r46v18 */
    /* JADX WARN: Type inference failed for: r46v19, names: [seasonNumber], types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r47v0 */
    /* JADX WARN: Type inference failed for: r47v1 */
    /* JADX WARN: Type inference failed for: r47v10 */
    /* JADX WARN: Type inference failed for: r47v11 */
    /* JADX WARN: Type inference failed for: r47v12 */
    /* JADX WARN: Type inference failed for: r47v13 */
    /* JADX WARN: Type inference failed for: r47v14 */
    /* JADX WARN: Type inference failed for: r47v15 */
    /* JADX WARN: Type inference failed for: r47v16 */
    /* JADX WARN: Type inference failed for: r47v17 */
    /* JADX WARN: Type inference failed for: r47v18 */
    /* JADX WARN: Type inference failed for: r47v2 */
    /* JADX WARN: Type inference failed for: r47v22 */
    /* JADX WARN: Type inference failed for: r47v29, names: [seasonNumber], types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r47v3 */
    /* JADX WARN: Type inference failed for: r47v30 */
    /* JADX WARN: Type inference failed for: r47v31 */
    /* JADX WARN: Type inference failed for: r47v32 */
    /* JADX WARN: Type inference failed for: r47v33 */
    /* JADX WARN: Type inference failed for: r47v34 */
    /* JADX WARN: Type inference failed for: r47v35 */
    /* JADX WARN: Type inference failed for: r47v36 */
    /* JADX WARN: Type inference failed for: r47v37 */
    /* JADX WARN: Type inference failed for: r47v38 */
    /* JADX WARN: Type inference failed for: r47v39 */
    /* JADX WARN: Type inference failed for: r47v4 */
    /* JADX WARN: Type inference failed for: r47v40, names: [seasonNumber], types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r47v46 */
    /* JADX WARN: Type inference failed for: r47v48 */
    /* JADX WARN: Type inference failed for: r47v49 */
    /* JADX WARN: Type inference failed for: r47v5 */
    /* JADX WARN: Type inference failed for: r47v50 */
    /* JADX WARN: Type inference failed for: r47v51 */
    /* JADX WARN: Type inference failed for: r47v52 */
    /* JADX WARN: Type inference failed for: r47v53 */
    /* JADX WARN: Type inference failed for: r47v54 */
    /* JADX WARN: Type inference failed for: r47v55 */
    /* JADX WARN: Type inference failed for: r47v6 */
    /* JADX WARN: Type inference failed for: r47v7 */
    /* JADX WARN: Type inference failed for: r47v8 */
    /* JADX WARN: Type inference failed for: r47v9 */
    /* JADX WARN: Type inference failed for: r96v10, names: [seasonNumber], types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r96v12 */
    /* JADX WARN: Type inference failed for: r96v34 */
    /* JADX WARN: Type inference failed for: r96v35 */
    /* JADX WARN: Type inference failed for: r96v7 */
    /* JADX WARN: Type inference failed for: r96v8 */
    /* JADX WARN: Type inference failed for: r96v9, names: [seasonNumber], types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r97v11, names: [$this], types: [com.cinefreak.Cinefreak] */
    /* JADX WARN: Type inference failed for: r97v19, names: [seasonNumber], types: [java.lang.Integer, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r97v24, names: [$continuation], types: [kotlin.coroutines.Continuation] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 20 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 25 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 5 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 6 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:656:0x1b8b -> B:1031:0x1bb3). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    static /* synthetic */ java.lang.Object load$suspendImpl(com.cinefreak.Cinefreak r96, java.lang.String r97, kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r98) {
        /*
            Method dump skipped, instruction units count: 10756
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cinefreak.Cinefreak.load$suspendImpl(com.cinefreak.Cinefreak, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$2$1(String $recPoster, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($recPoster);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.cinefreak.Cinefreak$load$5 */
    /* JADX INFO: compiled from: Cinefreak.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.cinefreak.Cinefreak$load$5", f = "Cinefreak.kt", i = {0}, l = {489}, m = "invokeSuspend", n = {"$this$newMovieLoadResponse"}, nl = {490}, s = {"L$0"}, v = 2)
    static final class C00035 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
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
        C00035(Ref.ObjectRef<String> objectRef, List<MovieSearchResponse> list, ResponseDataLocal responseDataLocal, String str, Ref.ObjectRef<String> objectRef2, Ref.ObjectRef<String> objectRef3, String str2, Ref.ObjectRef<List<String>> objectRef4, List<String> list2, Ref.ObjectRef<List<ActorData>> objectRef5, String str3, Continuation<? super C00035> continuation) {
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
            Continuation<Unit> c00035 = new C00035(this.$background, this.$recommendations, this.$responseData, this.$poster, this.$year, this.$description, this.$plot, this.$genre, this.$tags, this.$actorData, this.$trailer, continuation);
            c00035.L$0 = obj;
            return c00035;
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
    public static final Unit load$lambda$7$4(VideoLocal $info, String $defaultName, int $season, int $firstEpisode, Episode $this$newEpisode) {
        String title;
        if ($info == null || (title = $info.getTitle()) == null) {
            title = $defaultName;
        }
        $this$newEpisode.setName(title);
        $this$newEpisode.setSeason(Integer.valueOf($season));
        $this$newEpisode.setEpisode(Integer.valueOf($firstEpisode));
        $this$newEpisode.setPosterUrl($info != null ? $info.getThumbnail() : null);
        $this$newEpisode.setDescription($info != null ? $info.getOverview() : null);
        $this$newEpisode.setScore($info != null ? $info.getRating() : null);
        MainAPIKt.addDate$default($this$newEpisode, $info != null ? $info.getReleased() : null, (String) null, 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.cinefreak.Cinefreak$load$7 */
    /* JADX INFO: compiled from: Cinefreak.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.cinefreak.Cinefreak$load$7", f = "Cinefreak.kt", i = {0}, l = {570}, m = "invokeSuspend", n = {"$this$newTvSeriesLoadResponse"}, nl = {571}, s = {"L$0"}, v = 2)
    static final class C00047 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
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
        C00047(Ref.ObjectRef<String> objectRef, List<MovieSearchResponse> list, String str, ResponseDataLocal responseDataLocal, Ref.ObjectRef<String> objectRef2, Ref.ObjectRef<String> objectRef3, String str2, Ref.ObjectRef<List<String>> objectRef4, List<String> list2, Ref.ObjectRef<List<ActorData>> objectRef5, String str3, Continuation<? super C00047> continuation) {
            super(2, continuation);
            this.$background = objectRef;
            this.$recommendations = list;
            this.$poster = str;
            this.$responseData = responseDataLocal;
            this.$year = objectRef2;
            this.$description = objectRef3;
            this.$plot = str2;
            this.$genre = objectRef4;
            this.$tags = list2;
            this.$actorData = objectRef5;
            this.$trailer = str3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00047 = new C00047(this.$background, this.$recommendations, this.$poster, this.$responseData, this.$year, this.$description, this.$plot, this.$genre, this.$tags, this.$actorData, this.$trailer, continuation);
            c00047.L$0 = obj;
            return c00047;
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
                    loadResponse.setPosterUrl(this.$poster);
                    ResponseDataLocal responseDataLocal = this.$responseData;
                    loadResponse.setLogoUrl((responseDataLocal == null || (meta2 = responseDataLocal.getMeta()) == null) ? null : meta2.getLogo());
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

    /* JADX WARN: Code duplicated, block: B:134:0x01c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x0122  */
    /* JADX WARN: Code duplicated, block: B:58:0x0127  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:85:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:94:0x01d8 A[Catch: Exception -> 0x01f2, TRY_LEAVE, TryCatch #4 {Exception -> 0x01f2, blocks: (B:76:0x0183, B:83:0x01b5, B:86:0x01bc, B:94:0x01d8, B:93:0x01d2, B:82:0x01aa, B:75:0x0179, B:79:0x018b, B:88:0x01c2), top: B:120:0x0179, inners: #2, #10, #13 }] */
    static /* synthetic */ Object loadLinks$suspendImpl(Cinefreak $this, String data, boolean isCasting, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super Boolean> continuation) {
        C00051 c00051;
        Object obj;
        Object objDecodeFromString;
        Object obj2;
        Map parsed;
        Object obj3;
        boolean z;
        String it;
        Object obj4;
        Object objDecodeFromString2;
        boolean z2;
        Object obj5;
        DeserializationStrategy deserializationStrategy;
        if (continuation instanceof C00051) {
            c00051 = (C00051) continuation;
            if ((c00051.label & Integer.MIN_VALUE) != 0) {
                c00051.label -= Integer.MIN_VALUE;
            } else {
                c00051 = $this.new C00051(continuation);
            }
        } else {
            c00051 = $this.new C00051(continuation);
        }
        C00051 c00052 = c00051;
        Object $result = c00052.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00052.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                AppUtils appUtils = AppUtils.INSTANCE;
                if (data != null) {
                    try {
                        try {
                            kotlin.Result.Companion companion = kotlin.Result.Companion;
                            KType kTypeTypeOf = Reflection.typeOf(Map.class, KTypeProjection.Companion.invariant(Reflection.typeOf(String.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Object.class)));
                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                            obj = kotlin.Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                        } catch (Exception e) {
                            objDecodeFromString = null;
                            obj2 = objDecodeFromString;
                            parsed = (Map) obj2;
                            if (parsed == null) {
                                return Boxing.boxBoolean(false);
                            }
                            obj3 = parsed.get("links");
                            z = obj3 == null ? false : false;
                            return Boxing.boxBoolean(z);
                        }
                    } catch (Throwable th) {
                        kotlin.Result.Companion companion2 = kotlin.Result.Companion;
                        obj = kotlin.Result.constructor-impl(ResultKt.createFailure(th));
                    }
                    if (kotlin.Result.exceptionOrNull-impl(obj) != null) {
                        try {
                            kotlin.Result.Companion companion3 = kotlin.Result.Companion;
                            try {
                                obj = kotlin.Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Map.class), (List) null, 2, (Object) null));
                                break;
                            } catch (Throwable th2) {
                                th = th2;
                                try {
                                    kotlin.Result.Companion companion4 = kotlin.Result.Companion;
                                    obj = kotlin.Result.constructor-impl(ResultKt.createFailure(th));
                                } catch (Exception e2) {
                                    objDecodeFromString = null;
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    }
                    if (kotlin.Result.isFailure-impl(obj)) {
                        obj = null;
                    }
                    DeserializationStrategy deserializationStrategy2 = (KSerializer) obj;
                    if (deserializationStrategy2 != null) {
                        try {
                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, data);
                        } catch (SerializationException e3) {
                            ArchComponentExtKt.logError(e3);
                            ObjectMapper $this$readValue$iv$iv$iv = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv$iv.readValue(data, new TypeReference<Map<String, ? extends Object>>() { // from class: com.cinefreak.Cinefreak$loadLinks$suspendImpl$$inlined$tryParseJson$1
                            });
                        } catch (Throwable th4) {
                            ObjectMapper $this$readValue$iv$iv$iv2 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv$iv2.readValue(data, new TypeReference<Map<String, ? extends Object>>() { // from class: com.cinefreak.Cinefreak$loadLinks$suspendImpl$$inlined$tryParseJson$1
                            });
                        }
                    } else {
                        ObjectMapper $this$readValue$iv$iv$iv3 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv$iv3.readValue(data, new TypeReference<Map<String, ? extends Object>>() { // from class: com.cinefreak.Cinefreak$loadLinks$suspendImpl$$inlined$tryParseJson$1
                        });
                    }
                    obj2 = objDecodeFromString;
                    break;
                } else {
                    obj2 = null;
                }
                parsed = (Map) obj2;
                if (parsed == null) {
                    return Boxing.boxBoolean(false);
                }
                obj3 = parsed.get("links");
                if (obj3 == null && (it = AppUtils.INSTANCE.toJson(obj3)) != null) {
                    AppUtils appUtils2 = AppUtils.INSTANCE;
                    try {
                        kotlin.Result.Companion companion5 = kotlin.Result.Companion;
                        z = false;
                        try {
                            try {
                                KType kTypeTypeOf2 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(EpisodeLinkHrefs.class)));
                                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                obj4 = kotlin.Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                                break;
                            } catch (Throwable th5) {
                                th = th5;
                                try {
                                    kotlin.Result.Companion companion6 = kotlin.Result.Companion;
                                    obj4 = kotlin.Result.constructor-impl(ResultKt.createFailure(th));
                                } catch (Exception e4) {
                                    objDecodeFromString2 = null;
                                }
                            }
                        } catch (Throwable th6) {
                            th = th6;
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        z = false;
                    }
                    if (kotlin.Result.exceptionOrNull-impl(obj4) != null) {
                        try {
                            kotlin.Result.Companion companion7 = kotlin.Result.Companion;
                            obj4 = kotlin.Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                        } catch (Throwable th8) {
                            kotlin.Result.Companion companion8 = kotlin.Result.Companion;
                            obj4 = kotlin.Result.constructor-impl(ResultKt.createFailure(th8));
                        }
                        obj5 = obj4;
                        if (kotlin.Result.isFailure-impl(obj5)) {
                            obj5 = null;
                        }
                        deserializationStrategy = (KSerializer) obj5;
                        if (deserializationStrategy != null) {
                            objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy, it);
                        } else {
                            ObjectMapper $this$readValue$iv$iv$iv4 = MainAPIKt.getMapper();
                            objDecodeFromString2 = $this$readValue$iv$iv$iv4.readValue(it, new TypeReference<List<? extends EpisodeLinkHrefs>>() { // from class: com.cinefreak.Cinefreak$loadLinks$lambda$0$$inlined$tryParseJson$1
                            });
                        }
                        break;
                    } else {
                        obj5 = obj4;
                        if (kotlin.Result.isFailure-impl(obj5)) {
                            obj5 = null;
                        }
                        deserializationStrategy = (KSerializer) obj5;
                        if (deserializationStrategy != null) {
                            try {
                                objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy, it);
                            } catch (SerializationException e5) {
                                ArchComponentExtKt.logError(e5);
                                ObjectMapper $this$readValue$iv$iv$iv5 = MainAPIKt.getMapper();
                                objDecodeFromString2 = $this$readValue$iv$iv$iv5.readValue(it, new TypeReference<List<? extends EpisodeLinkHrefs>>() { // from class: com.cinefreak.Cinefreak$loadLinks$lambda$0$$inlined$tryParseJson$1
                                });
                            } catch (Throwable th9) {
                                ObjectMapper $this$readValue$iv$iv$iv6 = MainAPIKt.getMapper();
                                objDecodeFromString2 = $this$readValue$iv$iv$iv6.readValue(it, new TypeReference<List<? extends EpisodeLinkHrefs>>() { // from class: com.cinefreak.Cinefreak$loadLinks$lambda$0$$inlined$tryParseJson$1
                                });
                            }
                        } else {
                            ObjectMapper $this$readValue$iv$iv$iv7 = MainAPIKt.getMapper();
                            objDecodeFromString2 = $this$readValue$iv$iv$iv7.readValue(it, new TypeReference<List<? extends EpisodeLinkHrefs>>() { // from class: com.cinefreak.Cinefreak$loadLinks$lambda$0$$inlined$tryParseJson$1
                            });
                        }
                    }
                    List links = (List) objDecodeFromString2;
                    if (links != null) {
                        if (links.isEmpty()) {
                            return Boxing.boxBoolean(z);
                        }
                        C00062 c00062 = $this.new C00062(function1, function2, null);
                        c00052.L$0 = SpillingKt.nullOutSpilledVariable($this);
                        c00052.L$1 = SpillingKt.nullOutSpilledVariable(data);
                        c00052.L$2 = SpillingKt.nullOutSpilledVariable(function1);
                        c00052.L$3 = SpillingKt.nullOutSpilledVariable(function2);
                        c00052.L$4 = SpillingKt.nullOutSpilledVariable(parsed);
                        c00052.L$5 = SpillingKt.nullOutSpilledVariable(links);
                        c00052.Z$0 = isCasting;
                        z2 = true;
                        c00052.label = 1;
                        if (ParCollectionsKt.amap(links, c00062, c00052) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    }
                }
                return Boxing.boxBoolean(z);
            case 1:
                boolean z3 = c00052.Z$0;
                ResultKt.throwOnFailure($result);
                z2 = true;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Boxing.boxBoolean(z2);
    }

    /* JADX INFO: renamed from: com.cinefreak.Cinefreak$loadLinks$2 */
    /* JADX INFO: compiled from: Cinefreak.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "link", "Lcom/cinefreak/Cinefreak$EpisodeLinkHrefs;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.cinefreak.Cinefreak$loadLinks$2", f = "Cinefreak.kt", i = {0, 0, 1, 1}, l = {607, 616}, m = "invokeSuspend", n = {"link", "decoded", "link", "decoded"}, nl = {615, 624}, s = {"L$0", "L$1", "L$0", "L$1"}, v = 2)
    static final class C00062 extends SuspendLambda implements Function2<EpisodeLinkHrefs, Continuation<? super Unit>, Object> {
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
            Continuation<Unit> c00062 = Cinefreak.this.new C00062(this.$subtitleCallback, this.$callback, continuation);
            c00062.L$0 = obj;
            return c00062;
        }

        public final Object invoke(EpisodeLinkHrefs episodeLinkHrefs, Continuation<? super Unit> continuation) {
            return create(episodeLinkHrefs, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object obj;
            String strSubstringBefore$default;
            String decoded;
            String decoded2;
            String decoded3;
            List groupValues;
            String str;
            EpisodeLinkHrefs link = (EpisodeLinkHrefs) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Cinefreak $this$invokeSuspend_u24lambda_u240 = Cinefreak.this;
                    try {
                        kotlin.Result.Companion companion = kotlin.Result.Companion;
                        MatchResult matchResultFind$default = Regex.find$default(new Regex("id=([^&]+)"), MainAPIKt.fixUrl($this$invokeSuspend_u24lambda_u240, link.getUrl()), 0, 2, (Object) null);
                        if (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null || (str = (String) CollectionsKt.getOrNull(groupValues, 1)) == null) {
                            return Unit.INSTANCE;
                        }
                        obj = kotlin.Result.constructor-impl(MainAPIKt.base64Decode(str));
                        if (kotlin.Result.isFailure-impl(obj)) {
                            obj = null;
                        }
                        String str2 = (String) obj;
                        if (str2 == null || (strSubstringBefore$default = StringsKt.substringBefore$default(str2, "newgo32", (String) null, 2, (Object) null)) == null || (decoded = StringsKt.trim(strSubstringBefore$default).toString()) == null) {
                            return Unit.INSTANCE;
                        }
                        if (StringsKt.contains$default(decoded, "neodrive", false, 2, (Object) null)) {
                            this.L$0 = SpillingKt.nullOutSpilledVariable(link);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(decoded);
                            this.label = 1;
                            if (new Neodrive().getUrl(decoded, link.getQuality(), this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            decoded3 = decoded;
                        } else if (StringsKt.contains$default(decoded, "cinecloud", false, 2, (Object) null)) {
                            this.L$0 = SpillingKt.nullOutSpilledVariable(link);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(decoded);
                            this.label = 2;
                            if (new CineCloud().getUrl(decoded, link.getQuality(), this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            decoded2 = decoded;
                        }
                        return Unit.INSTANCE;
                    } catch (Throwable th) {
                        kotlin.Result.Companion companion2 = kotlin.Result.Companion;
                        obj = kotlin.Result.constructor-impl(ResultKt.createFailure(th));
                    }
                    break;
                case 1:
                    decoded3 = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                case 2:
                    decoded2 = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
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

    /* JADX INFO: compiled from: Cinefreak.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/cinefreak/Cinefreak$EpisodeLinkHrefs;", "", "quality", "", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getQuality", "()Ljava/lang/String;", "getUrl", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Cinefreak"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class EpisodeLinkHrefs {

        @NotNull
        private final String quality;

        @NotNull
        private final String url;

        public static /* synthetic */ EpisodeLinkHrefs copy$default(EpisodeLinkHrefs episodeLinkHrefs, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = episodeLinkHrefs.quality;
            }
            if ((i & 2) != 0) {
                str2 = episodeLinkHrefs.url;
            }
            return episodeLinkHrefs.copy(str, str2);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getQuality() {
            return this.quality;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @NotNull
        public final EpisodeLinkHrefs copy(@NotNull String quality, @NotNull String url) {
            return new EpisodeLinkHrefs(quality, url);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EpisodeLinkHrefs)) {
                return false;
            }
            EpisodeLinkHrefs episodeLinkHrefs = (EpisodeLinkHrefs) other;
            return Intrinsics.areEqual(this.quality, episodeLinkHrefs.quality) && Intrinsics.areEqual(this.url, episodeLinkHrefs.url);
        }

        public int hashCode() {
            return (this.quality.hashCode() * 31) + this.url.hashCode();
        }

        @NotNull
        public String toString() {
            return "EpisodeLinkHrefs(quality=" + this.quality + ", url=" + this.url + ')';
        }

        public EpisodeLinkHrefs(@NotNull String quality, @NotNull String url) {
            this.quality = quality;
            this.url = url;
        }

        @NotNull
        public final String getQuality() {
            return this.quality;
        }

        @NotNull
        public final String getUrl() {
            return this.url;
        }
    }

    /* JADX INFO: compiled from: Cinefreak.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u001cHÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/cinefreak/Cinefreak$SearchData;", "", "results", "", "Lcom/cinefreak/Cinefreak$Result;", "total", "", "page", "totalPages", "<init>", "(Ljava/util/List;JJJ)V", "getResults", "()Ljava/util/List;", "getTotal", "()J", "getPage", "getTotalPages", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Cinefreak"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class SearchData {
        private final long page;

        @NotNull
        private final List<Result> results;
        private final long total;
        private final long totalPages;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SearchData copy$default(SearchData searchData, List list, long j, long j2, long j3, int i, Object obj) {
            if ((i & 1) != 0) {
                list = searchData.results;
            }
            if ((i & 2) != 0) {
                j = searchData.total;
            }
            if ((i & 4) != 0) {
                j2 = searchData.page;
            }
            if ((i & 8) != 0) {
                j3 = searchData.totalPages;
            }
            long j4 = j3;
            return searchData.copy(list, j, j2, j4);
        }

        @NotNull
        public final List<Result> component1() {
            return this.results;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getTotal() {
            return this.total;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final long getPage() {
            return this.page;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final long getTotalPages() {
            return this.totalPages;
        }

        @NotNull
        public final SearchData copy(@NotNull List<Result> results, long total, long page, long totalPages) {
            return new SearchData(results, total, page, totalPages);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SearchData)) {
                return false;
            }
            SearchData searchData = (SearchData) other;
            return Intrinsics.areEqual(this.results, searchData.results) && this.total == searchData.total && this.page == searchData.page && this.totalPages == searchData.totalPages;
        }

        public int hashCode() {
            return (((((this.results.hashCode() * 31) + Cinefreak$SearchData$$ExternalSyntheticBackport0.m0m(this.total)) * 31) + Cinefreak$SearchData$$ExternalSyntheticBackport0.m0m(this.page)) * 31) + Cinefreak$SearchData$$ExternalSyntheticBackport0.m0m(this.totalPages);
        }

        @NotNull
        public String toString() {
            return "SearchData(results=" + this.results + ", total=" + this.total + ", page=" + this.page + ", totalPages=" + this.totalPages + ')';
        }

        public SearchData(@NotNull List<Result> list, long total, long page, long totalPages) {
            this.results = list;
            this.total = total;
            this.page = page;
            this.totalPages = totalPages;
        }

        @NotNull
        public final List<Result> getResults() {
            return this.results;
        }

        public final long getTotal() {
            return this.total;
        }

        public final long getPage() {
            return this.page;
        }

        public final long getTotalPages() {
            return this.totalPages;
        }
    }

    /* JADX INFO: compiled from: Cinefreak.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003JO\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001f\u001a\u00020 HÖ\u0081\u0004J\n\u0010!\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006\""}, d2 = {"Lcom/cinefreak/Cinefreak$Result;", "", "t", "", "l", "d", "c", "tg", "i", "q", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getT", "()Ljava/lang/String;", "getL", "getD", "getC", "getTg", "getI", "getQ", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "Cinefreak"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Result {

        @NotNull
        private final String c;

        @NotNull
        private final String d;

        @NotNull
        private final String i;

        @NotNull
        private final String l;

        @NotNull
        private final String q;

        @NotNull
        private final String t;

        @NotNull
        private final String tg;

        public static /* synthetic */ Result copy$default(Result result, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
            if ((i & 1) != 0) {
                str = result.t;
            }
            if ((i & 2) != 0) {
                str2 = result.l;
            }
            if ((i & 4) != 0) {
                str3 = result.d;
            }
            if ((i & 8) != 0) {
                str4 = result.c;
            }
            if ((i & 16) != 0) {
                str5 = result.tg;
            }
            if ((i & 32) != 0) {
                str6 = result.i;
            }
            if ((i & 64) != 0) {
                str7 = result.q;
            }
            String str8 = str6;
            String str9 = str7;
            String str10 = str5;
            String str11 = str3;
            return result.copy(str, str2, str11, str4, str10, str8, str9);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getT() {
            return this.t;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getL() {
            return this.l;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getD() {
            return this.d;
        }

        @NotNull
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getC() {
            return this.c;
        }

        @NotNull
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getTg() {
            return this.tg;
        }

        @NotNull
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getI() {
            return this.i;
        }

        @NotNull
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getQ() {
            return this.q;
        }

        @NotNull
        public final Result copy(@NotNull String t, @NotNull String l, @NotNull String d, @NotNull String c, @NotNull String tg, @NotNull String i, @NotNull String q) {
            return new Result(t, l, d, c, tg, i, q);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Result)) {
                return false;
            }
            Result result = (Result) other;
            return Intrinsics.areEqual(this.t, result.t) && Intrinsics.areEqual(this.l, result.l) && Intrinsics.areEqual(this.d, result.d) && Intrinsics.areEqual(this.c, result.c) && Intrinsics.areEqual(this.tg, result.tg) && Intrinsics.areEqual(this.i, result.i) && Intrinsics.areEqual(this.q, result.q);
        }

        public int hashCode() {
            return (((((((((((this.t.hashCode() * 31) + this.l.hashCode()) * 31) + this.d.hashCode()) * 31) + this.c.hashCode()) * 31) + this.tg.hashCode()) * 31) + this.i.hashCode()) * 31) + this.q.hashCode();
        }

        @NotNull
        public String toString() {
            return "Result(t=" + this.t + ", l=" + this.l + ", d=" + this.d + ", c=" + this.c + ", tg=" + this.tg + ", i=" + this.i + ", q=" + this.q + ')';
        }

        public Result(@NotNull String t, @NotNull String l, @NotNull String d, @NotNull String c, @NotNull String tg, @NotNull String i, @NotNull String q) {
            this.t = t;
            this.l = l;
            this.d = d;
            this.c = c;
            this.tg = tg;
            this.i = i;
            this.q = q;
        }

        @NotNull
        public final String getT() {
            return this.t;
        }

        @NotNull
        public final String getL() {
            return this.l;
        }

        @NotNull
        public final String getD() {
            return this.d;
        }

        @NotNull
        public final String getC() {
            return this.c;
        }

        @NotNull
        public final String getTg() {
            return this.tg;
        }

        @NotNull
        public final String getI() {
            return this.i;
        }

        @NotNull
        public final String getQ() {
            return this.q;
        }
    }

    private final String getBaseUrl(String url) {
        Url it = URLUtilsKt.Url(url);
        return it.getProtocol().getName() + "://" + it.getHost();
    }
}
