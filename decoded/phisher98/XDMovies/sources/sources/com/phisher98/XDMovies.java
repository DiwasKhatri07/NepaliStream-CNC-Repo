package com.phisher98;

import com.google.gson.Gson;
import com.lagradost.api.Log;
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
import com.lagradost.cloudstream3.Score;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SearchResponseList;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
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
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import okhttp3.Headers;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: XDMovies.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/XDMovies/classes.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 C2\u00020\u0001:\u0001CB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010$\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010 2\u0006\u0010&\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010'J\u001e\u0010\"\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0096@¢\u0006\u0002\u0010-J\f\u0010.\u001a\u00020%*\u00020/H\u0002J\u0018\u00100\u001a\u0004\u0018\u00010\u00052\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00050 H\u0002J\f\u0010.\u001a\u00020%*\u000202H\u0002J \u00103\u001a\u0004\u0018\u0001042\u0006\u0010&\u001a\u00020\u00052\u0006\u0010)\u001a\u00020*H\u0096@¢\u0006\u0002\u00105J\u0016\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010'JF\u00109\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u000e2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020?0=2\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020?0=H\u0096@¢\u0006\u0002\u0010BR\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0014\u0010\u0016\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0014\u0010\u0018\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u0006D"}, d2 = {"Lcom/phisher98/XDMovies;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasDownloadSupport", "getHasDownloadSupport", "instantLinkLoading", "getInstantLinkLoading", "hasQuickSearch", "getHasQuickSearch", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "quickSearch", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResult", "Lorg/jsoup/nodes/Element;", "highestQuality", "qualities", "Lcom/phisher98/SearchData$SearchDataItem;", "search", "Lcom/lagradost/cloudstream3/SearchResponseList;", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "XDMovies"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nXDMovies.kt\nKotlin\n*S Kotlin\n*F\n+ 1 XDMovies.kt\ncom/phisher98/XDMovies\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n+ 5 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 6 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,538:1\n1795#2,10:539\n2068#2:549\n2069#2:551\n1805#2:552\n1795#2,10:553\n2068#2:563\n2069#2:572\n1805#2:573\n2198#2,14:574\n1795#2,10:593\n2068#2:603\n2069#2:605\n1805#2:606\n1739#2:607\n1814#2,3:608\n1739#2:611\n1814#2,3:612\n1795#2,10:616\n2068#2:626\n2069#2:628\n1805#2:629\n1795#2,10:630\n2068#2:640\n2069#2:642\n1805#2:643\n2068#2:644\n1795#2,10:645\n2068#2:655\n2069#2:657\n1805#2:658\n2069#2:666\n2077#2,3:667\n777#2:671\n873#2,2:672\n1#3:550\n1#3:570\n1#3:571\n1#3:604\n1#3:615\n1#3:627\n1#3:641\n1#3:656\n1#3:670\n437#4:564\n513#4,5:565\n73#5,5:588\n460#6,7:659\n*S KotlinDebug\n*F\n+ 1 XDMovies.kt\ncom/phisher98/XDMovies\n*L\n239#1:539,10\n239#1:549\n239#1:551\n239#1:552\n264#1:553,10\n264#1:563\n264#1:572\n264#1:573\n267#1:574,14\n288#1:593,10\n288#1:603\n288#1:605\n288#1:606\n303#1:607\n303#1:608,3\n304#1:611\n304#1:612,3\n346#1:616,10\n346#1:626\n346#1:628\n346#1:629\n361#1:630,10\n361#1:640\n361#1:642\n361#1:643\n391#1:644\n397#1:645,10\n397#1:655\n397#1:657\n397#1:658\n391#1:666\n401#1:667,3\n499#1:671\n499#1:672,2\n239#1:550\n264#1:571\n288#1:604\n346#1:627\n361#1:641\n397#1:656\n265#1:564\n265#1:565,5\n287#1:588,5\n398#1:659,7\n*E\n"})
public final class XDMovies extends MainAPI {

    @NotNull
    private static final String CINEMETAURL = "https://cinemeta-live.strem.io";

    @NotNull
    public static final String TMDBAPI = "https://api.themoviedb.org/3";

    @NotNull
    public static final String TMDBIMAGEBASEURL = "https://image.tmdb.org/t/p/original";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Map<String, String> headers = MapsKt.mapOf(new Pair[]{TuplesKt.to("x-auth-token", MainAPIKt.base64Decode("NzI5N3Nra2loa2Fqd25zZ2FrbGFrc2h1d2Q=")), TuplesKt.to("x-requested-with", "XMLHttpRequest")});

    @NotNull
    private static final Gson gson = new Gson();

    @NotNull
    private static final Regex titleRegex = new Regex("S(\\d{1,2})E(\\d{1,3})", RegexOption.IGNORE_CASE);

    @NotNull
    private static final Regex seasonNumRegex1 = new Regex("season-(?:packs|episodes)-(\\d+)");

    @NotNull
    private static final Regex seasonNumRegex2 = new Regex("Season\\s*(\\d+)", RegexOption.IGNORE_CASE);

    @NotNull
    private static final List<String> CF_BLOCKER_PHRASES = CollectionsKt.listOf(new String[]{"just a moment", "checking your browser", "ddos-guard", "attention required", "verify you are human", "performing security verification"});

    @NotNull
    private static final Mutex cfBypassMutex = MutexKt.Mutex$default(false, 1, (Object) null);

    @NotNull
    private String mainUrl = "https://top.xdmovies.wtf";

    @NotNull
    private String name = "XD Movies";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "en";
    private final boolean hasDownloadSupport = true;
    private final boolean instantLinkLoading = true;
    private final boolean hasQuickSearch = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.TvSeries, TvType.Anime});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("Homepage", "HomePage"), TuplesKt.to("category.php?ott=Netflix", "Netflix"), TuplesKt.to("category.php?ott=Amazon", "Amazon Prime Video"), TuplesKt.to("category.php?ott=DisneyPlus", "Disney+"), TuplesKt.to("category.php?ott=AppleTVPlus", "Apple TV+"), TuplesKt.to("category.php?ott=HBOMax", "HBO Max"), TuplesKt.to("category.php?ott=Hulu", "Hulu"), TuplesKt.to("category.php?ott=Zee5", "Zee5"), TuplesKt.to("category.php?ott=JioHotstar", "Hotstar")});

    /* JADX INFO: renamed from: com.phisher98.XDMovies$getMainPage$1 */
    /* JADX INFO: compiled from: XDMovies.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.XDMovies", f = "XDMovies.kt", i = {0, 0, 0}, l = {238}, m = "getMainPage", n = {"request", "pageUrl", "page"}, nl = {239}, s = {"L$0", "L$1", "I$0"}, v = 2)
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
            return XDMovies.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.XDMovies$load$1 */
    /* JADX INFO: compiled from: XDMovies.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.XDMovies", f = "XDMovies.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8}, l = {294, 322, 331, 337, 352, 368, 382, 452, 467}, m = "load", n = {"url", "url", "document", "infoDiv", "detailsWrapper", "headerStyle", "downloadRoot", "title", "poster", "backgroundPoster", "audios", "tags", "firstAirDate", "year", "description", "rating", "contentType", "source", "tvType", "tmdbTvTypeSlug", "tvTypeSlugForCinemeta", "$this$load_u24lambda_u242", "tmdbId", "url", "document", "infoDiv", "detailsWrapper", "headerStyle", "downloadRoot", "title", "poster", "backgroundPoster", "audios", "tags", "firstAirDate", "year", "description", "rating", "contentType", "source", "tvType", "tmdbTvTypeSlug", "tvTypeSlugForCinemeta", "tmdbResText", "tmdbRes", "imdbId", "$this$load_u24lambda_u243", "tmdbId", "url", "document", "infoDiv", "detailsWrapper", "headerStyle", "downloadRoot", "title", "poster", "backgroundPoster", "audios", "tags", "firstAirDate", "year", "description", "rating", "contentType", "source", "tvType", "tmdbTvTypeSlug", "tvTypeSlugForCinemeta", "tmdbResText", "tmdbRes", "imdbId", "creditsJsonText", "actors", "$this$load_u24lambda_u244", "tmdbId", "url", "document", "infoDiv", "detailsWrapper", "headerStyle", "downloadRoot", "title", "poster", "backgroundPoster", "audios", "tags", "firstAirDate", "year", "description", "rating", "contentType", "source", "tvType", "tmdbTvTypeSlug", "tvTypeSlugForCinemeta", "tmdbResText", "tmdbRes", "imdbId", "creditsJsonText", "actors", "detailsJsonText", "genres", "tmdbId", "url", "document", "infoDiv", "detailsWrapper", "headerStyle", "downloadRoot", "title", "poster", "backgroundPoster", "audios", "tags", "firstAirDate", "year", "description", "rating", "contentType", "source", "tvType", "tmdbTvTypeSlug", "tvTypeSlugForCinemeta", "tmdbResText", "tmdbRes", "imdbId", "creditsJsonText", "actors", "detailsJsonText", "genres", "logoUrl", "downloadLinks", "href", "it", "tmdbId", "url", "document", "infoDiv", "detailsWrapper", "headerStyle", "downloadRoot", "title", "poster", "backgroundPoster", "audios", "tags", "firstAirDate", "year", "description", "rating", "contentType", "source", "tvType", "tmdbTvTypeSlug", "tvTypeSlugForCinemeta", "tmdbResText", "tmdbRes", "imdbId", "creditsJsonText", "actors", "detailsJsonText", "genres", "logoUrl", "downloadLinks", "href", "responseData", "episodes", "seasonSections", "seasonSection", "$this$load_u24lambda_u2410", "tmdbId", "seasonNum", "url", "document", "infoDiv", "detailsWrapper", "headerStyle", "downloadRoot", "title", "poster", "backgroundPoster", "audios", "tags", "firstAirDate", "year", "description", "rating", "contentType", "source", "tvType", "tmdbTvTypeSlug", "tvTypeSlugForCinemeta", "tmdbResText", "tmdbRes", "imdbId", "creditsJsonText", "actors", "detailsJsonText", "genres", "logoUrl", "downloadLinks", "href", "responseData", "episodes", "seasonSections", "tmdbId", "url", "document", "infoDiv", "detailsWrapper", "headerStyle", "downloadRoot", "title", "poster", "backgroundPoster", "audios", "tags", "firstAirDate", "year", "description", "rating", "contentType", "source", "tvType", "tmdbTvTypeSlug", "tvTypeSlugForCinemeta", "tmdbResText", "tmdbRes", "imdbId", "creditsJsonText", "actors", "detailsJsonText", "genres", "logoUrl", "downloadLinks", "href", "responseData", "tmdbId"}, nl = {295, 324, 330, 339, 360, 369, 384, 467, -1}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$28", "L$29", "L$30", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$28", "L$29", "L$30", "L$31", "L$32", "L$34", "L$35", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$28", "L$29", "L$30", "L$31", "L$32", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$28", "L$29", "L$30", "I$0"}, v = 2)
    static final class C00081 extends ContinuationImpl {
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
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C00081(Continuation<? super C00081> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return XDMovies.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.XDMovies$loadLinks$1 */
    /* JADX INFO: compiled from: XDMovies.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.XDMovies", f = "XDMovies.kt", i = {0, 0, 0, 0, 0, 0}, l = {509}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "links", "successCount", "isCasting"}, nl = {534}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0"}, v = 2)
    static final class C00111 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00111(Continuation<? super C00111> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return XDMovies.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.XDMovies$quickSearch$1 */
    /* JADX INFO: compiled from: XDMovies.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.XDMovies", f = "XDMovies.kt", i = {0}, l = {234}, m = "quickSearch", n = {"query"}, nl = {-1}, s = {"L$0"}, v = 2)
    static final class C00131 extends ContinuationImpl {
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
            return XDMovies.this.quickSearch(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.XDMovies$search$1 */
    /* JADX INFO: compiled from: XDMovies.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.XDMovies", f = "XDMovies.kt", i = {0, 0}, l = {284}, m = "search", n = {"query", "page"}, nl = {287}, s = {"L$0", "I$0"}, v = 2)
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
            return XDMovies.this.search(null, 0, (Continuation) this);
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

    public boolean getInstantLinkLoading() {
        return this.instantLinkLoading;
    }

    public boolean getHasQuickSearch() {
        return this.hasQuickSearch;
    }

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    /* JADX INFO: compiled from: XDMovies.kt */
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J,\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00062\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H\u0086@¢\u0006\u0002\u0010\u001cJ\u0017\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001b\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010\u001fJ\u0014\u0010 \u001a\u00020\u0006*\u00020!2\u0006\u0010\"\u001a\u00020\u0006H\u0002J\u001c\u0010#\u001a\u00020\u0006*\u00020!2\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0006H\u0002R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/phisher98/XDMovies$Companion;", "", "<init>", "()V", "headers", "", "", "getHeaders", "()Ljava/util/Map;", "gson", "Lcom/google/gson/Gson;", "CINEMETAURL", "TMDBIMAGEBASEURL", "TMDBAPI", "titleRegex", "Lkotlin/text/Regex;", "seasonNumRegex1", "seasonNumRegex2", "CF_BLOCKER_PHRASES", "", "isCloudflareBlocked", "", "response", "Lcom/lagradost/nicehttp/NiceResponse;", "cfBypassMutex", "Lkotlinx/coroutines/sync/Mutex;", "appGet", "url", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "extractTmdbId", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "safeText", "Lorg/jsoup/nodes/Element;", "selector", "safeAttr", "attr", "XDMovies"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nXDMovies.kt\nKotlin\n*S Kotlin\n*F\n+ 1 XDMovies.kt\ncom/phisher98/XDMovies$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n*L\n1#1,538:1\n1#2:539\n1960#3,3:540\n117#4,10:543\n*S KotlinDebug\n*F\n+ 1 XDMovies.kt\ncom/phisher98/XDMovies$Companion\n*L\n192#1:540,3\n203#1:543,10\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final Map<String, String> getHeaders() {
            return XDMovies.headers;
        }

        public final boolean isCloudflareBlocked(@NotNull NiceResponse response) {
            Object obj;
            if (response.getCode() == 403 || response.getCode() == 503) {
                return true;
            }
            Headers headers = response.getHeaders();
            if (headers.get("cf-mitigated") != null) {
                return true;
            }
            try {
                Result.Companion companion = Result.Companion;
                Companion companion2 = this;
                String lowerCase = response.getText().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                obj = Result.constructor-impl(lowerCase);
            } catch (Throwable th) {
                Result.Companion companion3 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (Result.exceptionOrNull-impl(obj) != null) {
                return false;
            }
            String body = (String) obj;
            Iterable $this$any$iv = XDMovies.CF_BLOCKER_PHRASES;
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

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object appGet$default(Companion companion, String str, Map map, Continuation continuation, int i, Object obj) {
            if ((i & 2) != 0) {
                map = MapsKt.emptyMap();
            }
            return companion.appGet(str, map, continuation);
        }

        /* JADX WARN: Code duplicated, block: B:33:0x0139  */
        /* JADX WARN: Code duplicated, block: B:35:0x0150 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:36:0x0151  */
        /* JADX WARN: Code duplicated, block: B:43:0x019d A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:44:0x019e  */
        /* JADX WARN: Code duplicated, block: B:47:0x01b6 A[Catch: all -> 0x0287, TRY_LEAVE, TryCatch #3 {all -> 0x0287, blocks: (B:45:0x01a8, B:47:0x01b6), top: B:87:0x01a8 }] */
        /* JADX WARN: Code duplicated, block: B:51:0x01f2 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:52:0x01f3  */
        /* JADX WARN: Code duplicated, block: B:56:0x0204  */
        /* JADX WARN: Code duplicated, block: B:61:0x024f A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:62:0x0250  */
        /* JADX WARN: Code duplicated, block: B:68:0x0277  */
        /* JADX WARN: Code duplicated, block: B:79:0x02b0  */
        /* JADX WARN: Code duplicated, block: B:7:0x0018  */
        /* JADX WARN: Code duplicated, block: B:91:0x01de A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Nullable
        public final Object appGet(@NotNull String url, @NotNull Map<String, String> map, @NotNull Continuation<? super NiceResponse> continuation) throws Throwable {
            XDMovies$Companion$appGet$1 xDMovies$Companion$appGet$1;
            Mutex $this$withLock_u24default$iv;
            Object owner$iv;
            Object obj;
            XDMovies$Companion$appGet$1 xDMovies$Companion$appGet$2;
            String url2;
            Map<String, String> map2;
            Ref.ObjectRef objectRef;
            Ref.ObjectRef rawResponse;
            Mutex $this$withLock_u24default$iv2;
            Object owner$iv2;
            Ref.ObjectRef rawResponse2;
            String url3;
            int $i$f$withLock;
            Map<String, String> map3;
            int i;
            Map<String, String> map4;
            String url4;
            Ref.ObjectRef rawResponse3;
            Mutex $this$withLock_u24default$iv3;
            Object obj2;
            XDMovies$Companion$appGet$1 xDMovies$Companion$appGet$3;
            String url5;
            Map<String, String> map5;
            int $i$f$withLock2;
            Ref.ObjectRef objectRef2;
            Ref.ObjectRef rawResponse4;
            Object owner$iv3;
            Mutex $this$withLock_u24default$iv4;
            Ref.ObjectRef rawResponse5;
            Object obj3;
            int i2;
            Ref.ObjectRef objectRef3;
            if (continuation instanceof XDMovies$Companion$appGet$1) {
                xDMovies$Companion$appGet$1 = (XDMovies$Companion$appGet$1) continuation;
                if ((xDMovies$Companion$appGet$1.label & Integer.MIN_VALUE) != 0) {
                    xDMovies$Companion$appGet$1.label -= Integer.MIN_VALUE;
                } else {
                    xDMovies$Companion$appGet$1 = new XDMovies$Companion$appGet$1(this, continuation);
                }
            } else {
                xDMovies$Companion$appGet$1 = new XDMovies$Companion$appGet$1(this, continuation);
            }
            XDMovies$Companion$appGet$1 xDMovies$Companion$appGet$4 = xDMovies$Companion$appGet$1;
            Object $result = xDMovies$Companion$appGet$4.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (xDMovies$Companion$appGet$4.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Ref.ObjectRef rawResponse6 = new Ref.ObjectRef();
                        Requests app = MainActivityKt.getApp();
                        XDMoviesCFBypassInterceptor xDMoviesCFBypassInterceptor = XDMoviesCFBypassInterceptor.INSTANCE;
                        xDMovies$Companion$appGet$4.L$0 = url;
                        xDMovies$Companion$appGet$4.L$1 = map;
                        xDMovies$Companion$appGet$4.L$2 = rawResponse6;
                        xDMovies$Companion$appGet$4.L$3 = rawResponse6;
                        xDMovies$Companion$appGet$4.label = 1;
                        obj = Requests.get$default(app, url, map, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, xDMoviesCFBypassInterceptor, false, (ResponseParser) null, xDMovies$Companion$appGet$4, 3580, (Object) null);
                        xDMovies$Companion$appGet$2 = xDMovies$Companion$appGet$4;
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        url2 = url;
                        map2 = map;
                        objectRef = rawResponse6;
                        rawResponse = objectRef;
                        objectRef.element = obj;
                        if (isCloudflareBlocked((NiceResponse) rawResponse.element)) {
                            $this$withLock_u24default$iv2 = XDMovies.cfBypassMutex;
                            xDMovies$Companion$appGet$2.L$0 = url2;
                            xDMovies$Companion$appGet$2.L$1 = map2;
                            xDMovies$Companion$appGet$2.L$2 = rawResponse;
                            xDMovies$Companion$appGet$2.L$3 = $this$withLock_u24default$iv2;
                            xDMovies$Companion$appGet$2.label = 2;
                            if ($this$withLock_u24default$iv2.lock((Object) null, xDMovies$Companion$appGet$2) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            owner$iv2 = null;
                            rawResponse2 = rawResponse;
                            url3 = url2;
                            $i$f$withLock = 0;
                            map3 = map2;
                            i = 0;
                            try {
                                Requests app2 = MainActivityKt.getApp();
                                XDMoviesCFBypassInterceptor xDMoviesCFBypassInterceptor2 = XDMoviesCFBypassInterceptor.INSTANCE;
                                xDMovies$Companion$appGet$2.L$0 = url3;
                                xDMovies$Companion$appGet$2.L$1 = map3;
                                xDMovies$Companion$appGet$2.L$2 = rawResponse2;
                                xDMovies$Companion$appGet$2.L$3 = $this$withLock_u24default$iv2;
                                xDMovies$Companion$appGet$2.L$4 = rawResponse2;
                                xDMovies$Companion$appGet$2.label = 3;
                                Ref.ObjectRef rawResponse7 = rawResponse2;
                                map4 = map3;
                                XDMovies$Companion$appGet$1 xDMovies$Companion$appGet$5 = xDMovies$Companion$appGet$2;
                                url4 = url3;
                                rawResponse3 = rawResponse7;
                                $this$withLock_u24default$iv3 = $this$withLock_u24default$iv2;
                                try {
                                    obj2 = Requests.get$default(app2, url4, map4, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, xDMoviesCFBypassInterceptor2, false, (ResponseParser) null, xDMovies$Companion$appGet$5, 3580, (Object) null);
                                    xDMovies$Companion$appGet$3 = xDMovies$Companion$appGet$5;
                                    if (obj2 == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    url5 = url4;
                                    map5 = map4;
                                    $i$f$withLock2 = $i$f$withLock;
                                    objectRef2 = rawResponse3;
                                    rawResponse4 = objectRef2;
                                    $this$withLock_u24default$iv = $this$withLock_u24default$iv3;
                                    $result = obj2;
                                    try {
                                        objectRef2.element = $result;
                                        if (XDMovies.INSTANCE.isCloudflareBlocked((NiceResponse) rawResponse4.element)) {
                                            Log.INSTANCE.d("XDMovies", "CF challenge detected on " + url5 + " – launching WebView bypass");
                                            if (XDMoviesProvider.INSTANCE.getCfWebviewEnabled()) {
                                                try {
                                                    xDMovies$Companion$appGet$3.L$0 = url5;
                                                    xDMovies$Companion$appGet$3.L$1 = map5;
                                                    xDMovies$Companion$appGet$3.L$2 = rawResponse4;
                                                    xDMovies$Companion$appGet$3.L$3 = $this$withLock_u24default$iv;
                                                    xDMovies$Companion$appGet$3.L$4 = null;
                                                    xDMovies$Companion$appGet$3.label = 4;
                                                    if (XDMoviesKt.showXDMoviesCFBypassDialogAndWait(url5, xDMovies$Companion$appGet$3) == coroutine_suspended) {
                                                        return coroutine_suspended;
                                                    }
                                                    owner$iv3 = owner$iv2;
                                                    owner$iv2 = owner$iv3;
                                                    $i$f$withLock = $i$f$withLock2;
                                                    $this$withLock_u24default$iv4 = $this$withLock_u24default$iv;
                                                    rawResponse5 = rawResponse4;
                                                    map4 = map5;
                                                } catch (Throwable th) {
                                                    th = th;
                                                    owner$iv = owner$iv2;
                                                    $this$withLock_u24default$iv.unlock(owner$iv);
                                                    throw th;
                                                }
                                            } else {
                                                $i$f$withLock = $i$f$withLock2;
                                                $this$withLock_u24default$iv4 = $this$withLock_u24default$iv;
                                                rawResponse5 = rawResponse4;
                                                map4 = map5;
                                            }
                                            try {
                                                Requests app3 = MainActivityKt.getApp();
                                                XDMoviesCFBypassInterceptor xDMoviesCFBypassInterceptor3 = XDMoviesCFBypassInterceptor.INSTANCE;
                                                xDMovies$Companion$appGet$3.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                                                xDMovies$Companion$appGet$3.L$1 = SpillingKt.nullOutSpilledVariable(map4);
                                                xDMovies$Companion$appGet$3.L$2 = rawResponse5;
                                                xDMovies$Companion$appGet$3.L$3 = $this$withLock_u24default$iv4;
                                                xDMovies$Companion$appGet$3.L$4 = rawResponse5;
                                                xDMovies$Companion$appGet$3.label = 5;
                                                Mutex $this$withLock_u24default$iv5 = $this$withLock_u24default$iv4;
                                                url4 = url5;
                                                rawResponse3 = rawResponse5;
                                                $this$withLock_u24default$iv3 = $this$withLock_u24default$iv5;
                                                obj3 = Requests.get$default(app3, url4, map4, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, xDMoviesCFBypassInterceptor3, false, (ResponseParser) null, xDMovies$Companion$appGet$3, 3580, (Object) null);
                                                if (obj3 == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                url5 = url4;
                                                map5 = map4;
                                                owner$iv = owner$iv2;
                                                i2 = i;
                                                objectRef3 = rawResponse3;
                                                rawResponse4 = objectRef3;
                                                $this$withLock_u24default$iv = $this$withLock_u24default$iv3;
                                                $result = obj3;
                                                try {
                                                    objectRef3.element = $result;
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    $this$withLock_u24default$iv.unlock(owner$iv);
                                                    throw th;
                                                }
                                            } catch (Throwable th3) {
                                                th = th3;
                                                owner$iv = owner$iv2;
                                                $this$withLock_u24default$iv = $this$withLock_u24default$iv4;
                                                $this$withLock_u24default$iv.unlock(owner$iv);
                                                throw th;
                                            }
                                        } else {
                                            owner$iv = owner$iv2;
                                        }
                                        Unit unit = Unit.INSTANCE;
                                        $this$withLock_u24default$iv.unlock(owner$iv);
                                        rawResponse = rawResponse4;
                                    } catch (Throwable th4) {
                                        th = th4;
                                        owner$iv = owner$iv2;
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                    owner$iv = owner$iv2;
                                    $this$withLock_u24default$iv = $this$withLock_u24default$iv3;
                                    $this$withLock_u24default$iv.unlock(owner$iv);
                                    throw th;
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                owner$iv = owner$iv2;
                                $this$withLock_u24default$iv = $this$withLock_u24default$iv2;
                                $this$withLock_u24default$iv.unlock(owner$iv);
                                throw th;
                            }
                        }
                        return rawResponse.element;
                    case 1:
                        objectRef = (Ref.ObjectRef) xDMovies$Companion$appGet$4.L$3;
                        rawResponse = (Ref.ObjectRef) xDMovies$Companion$appGet$4.L$2;
                        map2 = (Map) xDMovies$Companion$appGet$4.L$1;
                        url2 = (String) xDMovies$Companion$appGet$4.L$0;
                        ResultKt.throwOnFailure($result);
                        xDMovies$Companion$appGet$2 = xDMovies$Companion$appGet$4;
                        obj = $result;
                        objectRef.element = obj;
                        if (isCloudflareBlocked((NiceResponse) rawResponse.element)) {
                            $this$withLock_u24default$iv2 = XDMovies.cfBypassMutex;
                            xDMovies$Companion$appGet$2.L$0 = url2;
                            xDMovies$Companion$appGet$2.L$1 = map2;
                            xDMovies$Companion$appGet$2.L$2 = rawResponse;
                            xDMovies$Companion$appGet$2.L$3 = $this$withLock_u24default$iv2;
                            xDMovies$Companion$appGet$2.label = 2;
                            if ($this$withLock_u24default$iv2.lock((Object) null, xDMovies$Companion$appGet$2) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            owner$iv2 = null;
                            rawResponse2 = rawResponse;
                            url3 = url2;
                            $i$f$withLock = 0;
                            map3 = map2;
                            i = 0;
                            Requests app4 = MainActivityKt.getApp();
                            XDMoviesCFBypassInterceptor xDMoviesCFBypassInterceptor4 = XDMoviesCFBypassInterceptor.INSTANCE;
                            xDMovies$Companion$appGet$2.L$0 = url3;
                            xDMovies$Companion$appGet$2.L$1 = map3;
                            xDMovies$Companion$appGet$2.L$2 = rawResponse2;
                            xDMovies$Companion$appGet$2.L$3 = $this$withLock_u24default$iv2;
                            xDMovies$Companion$appGet$2.L$4 = rawResponse2;
                            xDMovies$Companion$appGet$2.label = 3;
                            Ref.ObjectRef rawResponse8 = rawResponse2;
                            map4 = map3;
                            XDMovies$Companion$appGet$1 xDMovies$Companion$appGet$6 = xDMovies$Companion$appGet$2;
                            url4 = url3;
                            rawResponse3 = rawResponse8;
                            $this$withLock_u24default$iv3 = $this$withLock_u24default$iv2;
                            obj2 = Requests.get$default(app4, url4, map4, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, xDMoviesCFBypassInterceptor4, false, (ResponseParser) null, xDMovies$Companion$appGet$6, 3580, (Object) null);
                            xDMovies$Companion$appGet$3 = xDMovies$Companion$appGet$6;
                            if (obj2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            url5 = url4;
                            map5 = map4;
                            $i$f$withLock2 = $i$f$withLock;
                            objectRef2 = rawResponse3;
                            rawResponse4 = objectRef2;
                            $this$withLock_u24default$iv = $this$withLock_u24default$iv3;
                            $result = obj2;
                            objectRef2.element = $result;
                            if (XDMovies.INSTANCE.isCloudflareBlocked((NiceResponse) rawResponse4.element)) {
                                Log.INSTANCE.d("XDMovies", "CF challenge detected on " + url5 + " – launching WebView bypass");
                                if (XDMoviesProvider.INSTANCE.getCfWebviewEnabled()) {
                                    xDMovies$Companion$appGet$3.L$0 = url5;
                                    xDMovies$Companion$appGet$3.L$1 = map5;
                                    xDMovies$Companion$appGet$3.L$2 = rawResponse4;
                                    xDMovies$Companion$appGet$3.L$3 = $this$withLock_u24default$iv;
                                    xDMovies$Companion$appGet$3.L$4 = null;
                                    xDMovies$Companion$appGet$3.label = 4;
                                    if (XDMoviesKt.showXDMoviesCFBypassDialogAndWait(url5, xDMovies$Companion$appGet$3) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    owner$iv3 = owner$iv2;
                                    owner$iv2 = owner$iv3;
                                    $i$f$withLock = $i$f$withLock2;
                                    $this$withLock_u24default$iv4 = $this$withLock_u24default$iv;
                                    rawResponse5 = rawResponse4;
                                    map4 = map5;
                                } else {
                                    $i$f$withLock = $i$f$withLock2;
                                    $this$withLock_u24default$iv4 = $this$withLock_u24default$iv;
                                    rawResponse5 = rawResponse4;
                                    map4 = map5;
                                }
                                Requests app5 = MainActivityKt.getApp();
                                XDMoviesCFBypassInterceptor xDMoviesCFBypassInterceptor5 = XDMoviesCFBypassInterceptor.INSTANCE;
                                xDMovies$Companion$appGet$3.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                                xDMovies$Companion$appGet$3.L$1 = SpillingKt.nullOutSpilledVariable(map4);
                                xDMovies$Companion$appGet$3.L$2 = rawResponse5;
                                xDMovies$Companion$appGet$3.L$3 = $this$withLock_u24default$iv4;
                                xDMovies$Companion$appGet$3.L$4 = rawResponse5;
                                xDMovies$Companion$appGet$3.label = 5;
                                Mutex $this$withLock_u24default$iv6 = $this$withLock_u24default$iv4;
                                url4 = url5;
                                rawResponse3 = rawResponse5;
                                $this$withLock_u24default$iv3 = $this$withLock_u24default$iv6;
                                obj3 = Requests.get$default(app5, url4, map4, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, xDMoviesCFBypassInterceptor5, false, (ResponseParser) null, xDMovies$Companion$appGet$3, 3580, (Object) null);
                                if (obj3 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                url5 = url4;
                                map5 = map4;
                                owner$iv = owner$iv2;
                                i2 = i;
                                objectRef3 = rawResponse3;
                                rawResponse4 = objectRef3;
                                $this$withLock_u24default$iv = $this$withLock_u24default$iv3;
                                $result = obj3;
                                objectRef3.element = $result;
                            } else {
                                owner$iv = owner$iv2;
                            }
                            Unit unit2 = Unit.INSTANCE;
                            $this$withLock_u24default$iv.unlock(owner$iv);
                            rawResponse = rawResponse4;
                        }
                        return rawResponse.element;
                    case 2:
                        Mutex $this$withLock_u24default$iv7 = (Mutex) xDMovies$Companion$appGet$4.L$3;
                        Ref.ObjectRef rawResponse9 = (Ref.ObjectRef) xDMovies$Companion$appGet$4.L$2;
                        map3 = (Map) xDMovies$Companion$appGet$4.L$1;
                        url3 = (String) xDMovies$Companion$appGet$4.L$0;
                        ResultKt.throwOnFailure($result);
                        $i$f$withLock = 0;
                        owner$iv2 = null;
                        rawResponse2 = rawResponse9;
                        xDMovies$Companion$appGet$2 = xDMovies$Companion$appGet$4;
                        $this$withLock_u24default$iv2 = $this$withLock_u24default$iv7;
                        i = 0;
                        Requests app6 = MainActivityKt.getApp();
                        XDMoviesCFBypassInterceptor xDMoviesCFBypassInterceptor6 = XDMoviesCFBypassInterceptor.INSTANCE;
                        xDMovies$Companion$appGet$2.L$0 = url3;
                        xDMovies$Companion$appGet$2.L$1 = map3;
                        xDMovies$Companion$appGet$2.L$2 = rawResponse2;
                        xDMovies$Companion$appGet$2.L$3 = $this$withLock_u24default$iv2;
                        xDMovies$Companion$appGet$2.L$4 = rawResponse2;
                        xDMovies$Companion$appGet$2.label = 3;
                        Ref.ObjectRef rawResponse10 = rawResponse2;
                        map4 = map3;
                        XDMovies$Companion$appGet$1 xDMovies$Companion$appGet$7 = xDMovies$Companion$appGet$2;
                        url4 = url3;
                        rawResponse3 = rawResponse10;
                        $this$withLock_u24default$iv3 = $this$withLock_u24default$iv2;
                        obj2 = Requests.get$default(app6, url4, map4, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, xDMoviesCFBypassInterceptor6, false, (ResponseParser) null, xDMovies$Companion$appGet$7, 3580, (Object) null);
                        xDMovies$Companion$appGet$3 = xDMovies$Companion$appGet$7;
                        if (obj2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        url5 = url4;
                        map5 = map4;
                        $i$f$withLock2 = $i$f$withLock;
                        objectRef2 = rawResponse3;
                        rawResponse4 = objectRef2;
                        $this$withLock_u24default$iv = $this$withLock_u24default$iv3;
                        $result = obj2;
                        objectRef2.element = $result;
                        if (XDMovies.INSTANCE.isCloudflareBlocked((NiceResponse) rawResponse4.element)) {
                            Log.INSTANCE.d("XDMovies", "CF challenge detected on " + url5 + " – launching WebView bypass");
                            if (XDMoviesProvider.INSTANCE.getCfWebviewEnabled()) {
                                xDMovies$Companion$appGet$3.L$0 = url5;
                                xDMovies$Companion$appGet$3.L$1 = map5;
                                xDMovies$Companion$appGet$3.L$2 = rawResponse4;
                                xDMovies$Companion$appGet$3.L$3 = $this$withLock_u24default$iv;
                                xDMovies$Companion$appGet$3.L$4 = null;
                                xDMovies$Companion$appGet$3.label = 4;
                                if (XDMoviesKt.showXDMoviesCFBypassDialogAndWait(url5, xDMovies$Companion$appGet$3) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                owner$iv3 = owner$iv2;
                                owner$iv2 = owner$iv3;
                                $i$f$withLock = $i$f$withLock2;
                                $this$withLock_u24default$iv4 = $this$withLock_u24default$iv;
                                rawResponse5 = rawResponse4;
                                map4 = map5;
                            } else {
                                $i$f$withLock = $i$f$withLock2;
                                $this$withLock_u24default$iv4 = $this$withLock_u24default$iv;
                                rawResponse5 = rawResponse4;
                                map4 = map5;
                            }
                            Requests app7 = MainActivityKt.getApp();
                            XDMoviesCFBypassInterceptor xDMoviesCFBypassInterceptor7 = XDMoviesCFBypassInterceptor.INSTANCE;
                            xDMovies$Companion$appGet$3.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                            xDMovies$Companion$appGet$3.L$1 = SpillingKt.nullOutSpilledVariable(map4);
                            xDMovies$Companion$appGet$3.L$2 = rawResponse5;
                            xDMovies$Companion$appGet$3.L$3 = $this$withLock_u24default$iv4;
                            xDMovies$Companion$appGet$3.L$4 = rawResponse5;
                            xDMovies$Companion$appGet$3.label = 5;
                            Mutex $this$withLock_u24default$iv8 = $this$withLock_u24default$iv4;
                            url4 = url5;
                            rawResponse3 = rawResponse5;
                            $this$withLock_u24default$iv3 = $this$withLock_u24default$iv8;
                            obj3 = Requests.get$default(app7, url4, map4, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, xDMoviesCFBypassInterceptor7, false, (ResponseParser) null, xDMovies$Companion$appGet$3, 3580, (Object) null);
                            if (obj3 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            url5 = url4;
                            map5 = map4;
                            owner$iv = owner$iv2;
                            i2 = i;
                            objectRef3 = rawResponse3;
                            rawResponse4 = objectRef3;
                            $this$withLock_u24default$iv = $this$withLock_u24default$iv3;
                            $result = obj3;
                            objectRef3.element = $result;
                        } else {
                            owner$iv = owner$iv2;
                        }
                        Unit unit3 = Unit.INSTANCE;
                        $this$withLock_u24default$iv.unlock(owner$iv);
                        rawResponse = rawResponse4;
                        return rawResponse.element;
                    case 3:
                        $i$f$withLock2 = 0;
                        objectRef2 = (Ref.ObjectRef) xDMovies$Companion$appGet$4.L$4;
                        Mutex $this$withLock_u24default$iv9 = (Mutex) xDMovies$Companion$appGet$4.L$3;
                        Ref.ObjectRef rawResponse11 = (Ref.ObjectRef) xDMovies$Companion$appGet$4.L$2;
                        Map<String, String> map6 = (Map) xDMovies$Companion$appGet$4.L$1;
                        String url6 = (String) xDMovies$Companion$appGet$4.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            i = 0;
                            owner$iv2 = null;
                            $this$withLock_u24default$iv = $this$withLock_u24default$iv9;
                            rawResponse4 = rawResponse11;
                            map5 = map6;
                            url5 = url6;
                            xDMovies$Companion$appGet$3 = xDMovies$Companion$appGet$4;
                            objectRef2.element = $result;
                            if (XDMovies.INSTANCE.isCloudflareBlocked((NiceResponse) rawResponse4.element)) {
                                Log.INSTANCE.d("XDMovies", "CF challenge detected on " + url5 + " – launching WebView bypass");
                                if (XDMoviesProvider.INSTANCE.getCfWebviewEnabled()) {
                                    xDMovies$Companion$appGet$3.L$0 = url5;
                                    xDMovies$Companion$appGet$3.L$1 = map5;
                                    xDMovies$Companion$appGet$3.L$2 = rawResponse4;
                                    xDMovies$Companion$appGet$3.L$3 = $this$withLock_u24default$iv;
                                    xDMovies$Companion$appGet$3.L$4 = null;
                                    xDMovies$Companion$appGet$3.label = 4;
                                    if (XDMoviesKt.showXDMoviesCFBypassDialogAndWait(url5, xDMovies$Companion$appGet$3) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    owner$iv3 = owner$iv2;
                                    owner$iv2 = owner$iv3;
                                    $i$f$withLock = $i$f$withLock2;
                                    $this$withLock_u24default$iv4 = $this$withLock_u24default$iv;
                                    rawResponse5 = rawResponse4;
                                    map4 = map5;
                                } else {
                                    $i$f$withLock = $i$f$withLock2;
                                    $this$withLock_u24default$iv4 = $this$withLock_u24default$iv;
                                    rawResponse5 = rawResponse4;
                                    map4 = map5;
                                }
                                Requests app8 = MainActivityKt.getApp();
                                XDMoviesCFBypassInterceptor xDMoviesCFBypassInterceptor8 = XDMoviesCFBypassInterceptor.INSTANCE;
                                xDMovies$Companion$appGet$3.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                                xDMovies$Companion$appGet$3.L$1 = SpillingKt.nullOutSpilledVariable(map4);
                                xDMovies$Companion$appGet$3.L$2 = rawResponse5;
                                xDMovies$Companion$appGet$3.L$3 = $this$withLock_u24default$iv4;
                                xDMovies$Companion$appGet$3.L$4 = rawResponse5;
                                xDMovies$Companion$appGet$3.label = 5;
                                Mutex $this$withLock_u24default$iv10 = $this$withLock_u24default$iv4;
                                url4 = url5;
                                rawResponse3 = rawResponse5;
                                $this$withLock_u24default$iv3 = $this$withLock_u24default$iv10;
                                obj3 = Requests.get$default(app8, url4, map4, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, xDMoviesCFBypassInterceptor8, false, (ResponseParser) null, xDMovies$Companion$appGet$3, 3580, (Object) null);
                                if (obj3 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                url5 = url4;
                                map5 = map4;
                                owner$iv = owner$iv2;
                                i2 = i;
                                objectRef3 = rawResponse3;
                                rawResponse4 = objectRef3;
                                $this$withLock_u24default$iv = $this$withLock_u24default$iv3;
                                $result = obj3;
                                objectRef3.element = $result;
                            } else {
                                owner$iv = owner$iv2;
                            }
                            Unit unit4 = Unit.INSTANCE;
                            $this$withLock_u24default$iv.unlock(owner$iv);
                            rawResponse = rawResponse4;
                            return rawResponse.element;
                        } catch (Throwable th7) {
                            th = th7;
                            owner$iv = null;
                            $this$withLock_u24default$iv = $this$withLock_u24default$iv9;
                            $this$withLock_u24default$iv.unlock(owner$iv);
                            throw th;
                        }
                    case 4:
                        $i$f$withLock2 = 0;
                        owner$iv3 = null;
                        $this$withLock_u24default$iv = (Mutex) xDMovies$Companion$appGet$4.L$3;
                        rawResponse4 = (Ref.ObjectRef) xDMovies$Companion$appGet$4.L$2;
                        map5 = (Map) xDMovies$Companion$appGet$4.L$1;
                        url5 = (String) xDMovies$Companion$appGet$4.L$0;
                        ResultKt.throwOnFailure($result);
                        i = 0;
                        xDMovies$Companion$appGet$3 = xDMovies$Companion$appGet$4;
                        owner$iv2 = owner$iv3;
                        $i$f$withLock = $i$f$withLock2;
                        $this$withLock_u24default$iv4 = $this$withLock_u24default$iv;
                        rawResponse5 = rawResponse4;
                        map4 = map5;
                        Requests app9 = MainActivityKt.getApp();
                        XDMoviesCFBypassInterceptor xDMoviesCFBypassInterceptor9 = XDMoviesCFBypassInterceptor.INSTANCE;
                        xDMovies$Companion$appGet$3.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                        xDMovies$Companion$appGet$3.L$1 = SpillingKt.nullOutSpilledVariable(map4);
                        xDMovies$Companion$appGet$3.L$2 = rawResponse5;
                        xDMovies$Companion$appGet$3.L$3 = $this$withLock_u24default$iv4;
                        xDMovies$Companion$appGet$3.L$4 = rawResponse5;
                        xDMovies$Companion$appGet$3.label = 5;
                        Mutex $this$withLock_u24default$iv11 = $this$withLock_u24default$iv4;
                        url4 = url5;
                        rawResponse3 = rawResponse5;
                        $this$withLock_u24default$iv3 = $this$withLock_u24default$iv11;
                        obj3 = Requests.get$default(app9, url4, map4, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, xDMoviesCFBypassInterceptor9, false, (ResponseParser) null, xDMovies$Companion$appGet$3, 3580, (Object) null);
                        if (obj3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        url5 = url4;
                        map5 = map4;
                        owner$iv = owner$iv2;
                        i2 = i;
                        objectRef3 = rawResponse3;
                        rawResponse4 = objectRef3;
                        $this$withLock_u24default$iv = $this$withLock_u24default$iv3;
                        $result = obj3;
                        objectRef3.element = $result;
                        Unit unit5 = Unit.INSTANCE;
                        $this$withLock_u24default$iv.unlock(owner$iv);
                        rawResponse = rawResponse4;
                        return rawResponse.element;
                    case 5:
                        i2 = 0;
                        objectRef3 = (Ref.ObjectRef) xDMovies$Companion$appGet$4.L$4;
                        owner$iv = null;
                        $this$withLock_u24default$iv = (Mutex) xDMovies$Companion$appGet$4.L$3;
                        rawResponse4 = (Ref.ObjectRef) xDMovies$Companion$appGet$4.L$2;
                        map5 = (Map) xDMovies$Companion$appGet$4.L$1;
                        url5 = (String) xDMovies$Companion$appGet$4.L$0;
                        ResultKt.throwOnFailure($result);
                        objectRef3.element = $result;
                        Unit unit6 = Unit.INSTANCE;
                        $this$withLock_u24default$iv.unlock(owner$iv);
                        rawResponse = rawResponse4;
                        return rawResponse.element;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Throwable th8) {
                th = th8;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Integer extractTmdbId(String url) {
            return StringsKt.toIntOrNull(StringsKt.substringAfterLast$default(url, "-", (String) null, 2, (Object) null));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String safeText(Element $this$safeText, String selector) {
            Element elementSelectFirst = $this$safeText.selectFirst(selector);
            String strText = elementSelectFirst != null ? elementSelectFirst.text() : null;
            return strText == null ? "" : strText;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String safeAttr(Element $this$safeAttr, String selector, String attr) {
            Element elementSelectFirst = $this$safeAttr.selectFirst(selector);
            String strAttr = elementSelectFirst != null ? elementSelectFirst.attr(attr) : null;
            return strAttr == null ? "" : strAttr;
        }
    }

    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Nullable
    public Object quickSearch(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) throws IOException {
        C00131 c00131;
        Object objSearch;
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
        Object $result = c00131.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00131.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                c00131.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00131.label = 1;
                objSearch = search(query, 1, c00131);
                if (objSearch == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                objSearch = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        SearchResponseList searchResponseList = (SearchResponseList) objSearch;
        if (searchResponseList != null) {
            return searchResponseList.getItems();
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        C00071 c00071;
        boolean z;
        int page2;
        MainPageRequest request2;
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
                String pageUrl = getMainUrl() + '/' + (StringsKt.contains$default(request.getData(), "Homepage", false, 2, (Object) null) ? "?" : request.getData() + '&') + "page=" + page;
                Requests app = MainActivityKt.getApp();
                c00071.L$0 = request;
                c00071.L$1 = SpillingKt.nullOutSpilledVariable(pageUrl);
                c00071.I$0 = page;
                c00071.label = 1;
                z = true;
                $result = Requests.get$default(app, pageUrl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00071, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                page2 = page;
                request2 = request;
                break;
                break;
            case 1:
                page2 = c00071.I$0;
                request2 = (MainPageRequest) c00071.L$0;
                ResultKt.throwOnFailure($result);
                z = true;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv = document.select("div.container div.movie-grid a");
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
        List home = (List) destination$iv$iv;
        return MainAPIKt.newHomePageResponse(new HomePageList(request2.getName(), home, false, 4, (DefaultConstructorMarker) null), Boxing.boxBoolean(z));
    }

    private final SearchResponse toSearchResult(Element $this$toSearchResult) {
        String title = INSTANCE.safeText($this$toSearchResult, "h3");
        String href = MainAPIKt.fixUrl(this, $this$toSearchResult.attr("href"));
        final String posterUrl = MainAPIKt.fixUrlNull(this, INSTANCE.safeAttr($this$toSearchResult, "img", "src"));
        Element elementSelectFirst = $this$toSearchResult.selectFirst("div.quality-badge");
        final String quality = elementSelectFirst != null ? elementSelectFirst.ownText() : null;
        return MainAPIKt.newMovieSearchResponse$default(this, title, href, TvType.Movie, false, new Function1() { // from class: com.phisher98.XDMovies$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                return XDMovies.toSearchResult$lambda$0(posterUrl, quality, (MovieSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResult$lambda$0(String $posterUrl, String $quality, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($posterUrl);
        $this$newMovieSearchResponse.setQuality(XDMoviesParserKt.getSearchQuality($quality));
        return Unit.INSTANCE;
    }

    private final String highestQuality(List<String> qualities) throws IOException {
        Object maxElem$iv;
        Pair pair;
        List<String> $this$mapNotNull$iv = qualities;
        int $i$f$mapNotNull = 0;
        Collection destination$iv$iv = new ArrayList();
        Iterable $this$mapNotNullTo$iv$iv = $this$mapNotNull$iv;
        for (Object element$iv$iv$iv : $this$mapNotNullTo$iv$iv) {
            CharSequence q = (String) element$iv$iv$iv;
            CharSequence $this$filterTo$iv$iv = q;
            Iterable $this$mapNotNull$iv2 = $this$mapNotNull$iv;
            Appendable destination$iv$iv2 = new StringBuilder();
            int $i$f$mapNotNull2 = $i$f$mapNotNull;
            int $i$f$mapNotNull3 = $this$filterTo$iv$iv.length();
            Iterable $this$mapNotNullTo$iv$iv2 = $this$mapNotNullTo$iv$iv;
            int index$iv$iv = 0;
            while (index$iv$iv < $i$f$mapNotNull3) {
                int i = $i$f$mapNotNull3;
                char element$iv$iv = $this$filterTo$iv$iv.charAt(index$iv$iv);
                if (Character.isDigit(element$iv$iv)) {
                    destination$iv$iv2.append(element$iv$iv);
                }
                index$iv$iv++;
                $i$f$mapNotNull3 = i;
            }
            Integer intOrNull = StringsKt.toIntOrNull(((StringBuilder) destination$iv$iv2).toString());
            if (intOrNull != null) {
                int res = intOrNull.intValue();
                pair = TuplesKt.to(Integer.valueOf(res), q);
            } else {
                pair = null;
            }
            if (pair != null) {
                destination$iv$iv.add(pair);
            }
            $this$mapNotNull$iv = $this$mapNotNull$iv2;
            $i$f$mapNotNull = $i$f$mapNotNull2;
            $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv2;
        }
        Iterable $this$maxByOrNull$iv = (List) destination$iv$iv;
        Iterator iterator$iv = $this$maxByOrNull$iv.iterator();
        if (iterator$iv.hasNext()) {
            maxElem$iv = iterator$iv.next();
            if (iterator$iv.hasNext()) {
                Pair it = (Pair) maxElem$iv;
                int maxValue$iv = ((Number) it.getFirst()).intValue();
                do {
                    Object e$iv = iterator$iv.next();
                    Pair it2 = (Pair) e$iv;
                    int v$iv = ((Number) it2.getFirst()).intValue();
                    if (maxValue$iv < v$iv) {
                        maxElem$iv = e$iv;
                        maxValue$iv = v$iv;
                    }
                } while (iterator$iv.hasNext());
            }
        } else {
            maxElem$iv = null;
        }
        Pair pair2 = (Pair) maxElem$iv;
        if (pair2 != null) {
            return (String) pair2.getSecond();
        }
        return null;
    }

    private final SearchResponse toSearchResult(final SearchData.SearchDataItem $this$toSearchResult) throws IOException {
        boolean isTv = true;
        if (!StringsKt.equals($this$toSearchResult.getType(), "tv", true) && !StringsKt.equals($this$toSearchResult.getType(), "series", true)) {
            isTv = false;
        }
        TvType tvType = isTv ? TvType.TvSeries : TvType.Movie;
        String url = getMainUrl() + $this$toSearchResult.getPath();
        final String bestQuality = highestQuality($this$toSearchResult.getQualities());
        return MainAPIKt.newMovieSearchResponse$default(this, $this$toSearchResult.getTitle(), url, tvType, false, new Function1() { // from class: com.phisher98.XDMovies$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return XDMovies.toSearchResult$lambda$1($this$toSearchResult, bestQuality, (MovieSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResult$lambda$1(SearchData.SearchDataItem $this_toSearchResult, String $bestQuality, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl(TMDBIMAGEBASEURL + $this_toSearchResult.getPoster());
        $this$newMovieSearchResponse.setQuality(XDMoviesParserKt.getSearchQuality($bestQuality));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object search(@NotNull String query, int page, @NotNull Continuation<? super SearchResponseList> continuation) throws IOException {
        C00141 c00141;
        Object safe;
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
        switch (c00142.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                String str = getMainUrl() + "/php/search_api.php?query=" + query + "&fuzzy=true";
                Map<String, String> map = headers;
                c00142.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00142.I$0 = page;
                c00142.label = 1;
                $result = Requests.get$default(app, str, map, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00142, 4092, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                int i = c00142.I$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NiceResponse this_$iv = (NiceResponse) $result;
        try {
            ResponseParser parser = this_$iv.getParser();
            Intrinsics.checkNotNull(parser);
            safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(SearchData.class));
        } catch (Exception e$iv) {
            e$iv.printStackTrace();
            safe = null;
        }
        Iterable searchData = (SearchData) safe;
        if (searchData == null) {
            return null;
        }
        Iterable $this$mapNotNull$iv = searchData;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            SearchData.SearchDataItem it = (SearchData.SearchDataItem) element$iv$iv$iv;
            SearchResponse searchResult = toSearchResult(it);
            if (searchResult != null) {
                destination$iv$iv.add(searchResult);
            }
        }
        List results = (List) destination$iv$iv;
        return MainAPIKt.toNewSearchResponseList$default(results, (Boolean) null, 1, (Object) null);
    }

    /* JADX WARN: Code duplicated, block: B:319:0x1852  */
    /* JADX WARN: Code duplicated, block: B:321:0x1871  */
    /* JADX WARN: Code duplicated, block: B:328:0x188b  */
    /* JADX WARN: Code duplicated, block: B:383:0x19e8 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:384:0x19e9  */
    /* JADX WARN: Code duplicated, block: B:429:0x20a1  */
    /* JADX WARN: Code duplicated, block: B:433:0x20c9  */
    /* JADX WARN: Code duplicated, block: B:435:0x20df  */
    /* JADX WARN: Code duplicated, block: B:436:0x20e4  */
    /* JADX WARN: Code duplicated, block: B:438:0x20e7  */
    /* JADX WARN: Code duplicated, block: B:441:0x2102  */
    /* JADX WARN: Code duplicated, block: B:448:0x211d  */
    /* JADX WARN: Code duplicated, block: B:450:0x2123  */
    /* JADX WARN: Code duplicated, block: B:453:0x2132  */
    /* JADX WARN: Code duplicated, block: B:457:0x215c  */
    /* JADX WARN: Code duplicated, block: B:459:0x218a  */
    /* JADX WARN: Code duplicated, block: B:460:0x218d  */
    /* JADX WARN: Code duplicated, block: B:463:0x2192  */
    /* JADX WARN: Code duplicated, block: B:465:0x2196  */
    /* JADX WARN: Code duplicated, block: B:469:0x21b6  */
    /* JADX WARN: Code duplicated, block: B:471:0x21c4  */
    /* JADX WARN: Code duplicated, block: B:472:0x21d8  */
    /* JADX WARN: Code duplicated, block: B:474:0x21e8  */
    /* JADX WARN: Code duplicated, block: B:479:0x2223  */
    /* JADX WARN: Code duplicated, block: B:481:0x222b  */
    /* JADX WARN: Code duplicated, block: B:484:0x223f  */
    /* JADX WARN: Code duplicated, block: B:487:0x2250  */
    /* JADX WARN: Code duplicated, block: B:490:0x225b  */
    /* JADX WARN: Code duplicated, block: B:494:0x2265  */
    /* JADX WARN: Code duplicated, block: B:497:0x226a  */
    /* JADX WARN: Code duplicated, block: B:499:0x226d  */
    /* JADX WARN: Code duplicated, block: B:500:0x2272  */
    /* JADX WARN: Code duplicated, block: B:504:0x22c3  */
    /* JADX WARN: Code duplicated, block: B:507:0x22d1  */
    /* JADX WARN: Code duplicated, block: B:509:0x22e9  */
    /* JADX WARN: Code duplicated, block: B:526:0x2325  */
    /* JADX WARN: Code duplicated, block: B:528:0x232a  */
    /* JADX WARN: Code duplicated, block: B:552:0x2378  */
    /* JADX WARN: Code duplicated, block: B:554:0x237b  */
    /* JADX WARN: Code duplicated, block: B:558:0x2387 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:559:0x2389  */
    /* JADX WARN: Code duplicated, block: B:560:0x238e  */
    /* JADX WARN: Code duplicated, block: B:562:0x2392  */
    /* JADX WARN: Code duplicated, block: B:563:0x23a8  */
    /* JADX WARN: Code duplicated, block: B:565:0x23ae  */
    /* JADX WARN: Code duplicated, block: B:569:0x23b8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:570:0x23ba  */
    /* JADX WARN: Code duplicated, block: B:571:0x23bf  */
    /* JADX WARN: Code duplicated, block: B:573:0x23c3  */
    /* JADX WARN: Code duplicated, block: B:576:0x23e1  */
    /* JADX WARN: Code duplicated, block: B:579:0x23e9  */
    /* JADX WARN: Code duplicated, block: B:580:0x23ee  */
    /* JADX WARN: Code duplicated, block: B:583:0x23f5  */
    /* JADX WARN: Code duplicated, block: B:584:0x23fc  */
    /* JADX WARN: Code duplicated, block: B:586:0x2429  */
    /* JADX WARN: Code duplicated, block: B:588:0x2433  */
    /* JADX WARN: Code duplicated, block: B:591:0x243d  */
    /* JADX WARN: Code duplicated, block: B:593:0x2463  */
    /* JADX WARN: Code duplicated, block: B:607:0x249c A[LOOP:7: B:596:0x246f->B:607:0x249c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:610:0x24b0  */
    /* JADX WARN: Code duplicated, block: B:612:0x24b9  */
    /* JADX WARN: Code duplicated, block: B:636:0x2509  */
    /* JADX WARN: Code duplicated, block: B:639:0x2510  */
    /* JADX WARN: Code duplicated, block: B:643:0x251a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:644:0x251c  */
    /* JADX WARN: Code duplicated, block: B:645:0x2521  */
    /* JADX WARN: Code duplicated, block: B:647:0x2525  */
    /* JADX WARN: Code duplicated, block: B:650:0x2549  */
    /* JADX WARN: Code duplicated, block: B:653:0x2553  */
    /* JADX WARN: Code duplicated, block: B:654:0x2558  */
    /* JADX WARN: Code duplicated, block: B:657:0x255f  */
    /* JADX WARN: Code duplicated, block: B:658:0x2566  */
    /* JADX WARN: Code duplicated, block: B:661:0x2597  */
    /* JADX WARN: Code duplicated, block: B:663:0x25b5  */
    /* JADX WARN: Code duplicated, block: B:665:0x26e3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:666:0x26e4  */
    /* JADX WARN: Code duplicated, block: B:771:0x219d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:772:0x22b7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:786:0x24ab A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v448 */
    /* JADX WARN: Type inference failed for: r0v449 */
    /* JADX WARN: Type inference failed for: r0v500, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r0v505, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r0v704 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:384:0x19e9 -> B:740:0x1a33). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:426:0x2053 -> B:427:0x209b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:580:0x23ee
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object load(@org.jetbrains.annotations.NotNull java.lang.String r89, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r90) {
        /*
            Method dump skipped, instruction units count: 10024
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.XDMovies.load(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static final Unit load$lambda$16(String $name, int $seasonNum, int $epNum, String $poster, String $desc, Score $score, String $airDate, Episode $this$newEpisode) {
        $this$newEpisode.setName($name);
        $this$newEpisode.setSeason(Integer.valueOf($seasonNum));
        $this$newEpisode.setEpisode(Integer.valueOf($epNum));
        $this$newEpisode.setPosterUrl($poster);
        $this$newEpisode.setDescription($desc);
        $this$newEpisode.setScore($score);
        MainAPIKt.addDate$default($this$newEpisode, $airDate, (String) null, 2, (Object) null);
        return Unit.INSTANCE;
    }

    static final Unit load$lambda$20(String $name, int $seasonNum, int $epNum, String $poster, String $desc, Score $score, String $airDate, Episode $this$newEpisode) {
        $this$newEpisode.setName($name);
        $this$newEpisode.setSeason(Integer.valueOf($seasonNum));
        $this$newEpisode.setEpisode(Integer.valueOf($epNum));
        $this$newEpisode.setPosterUrl($poster);
        $this$newEpisode.setDescription($desc);
        $this$newEpisode.setScore($score);
        MainAPIKt.addDate$default($this$newEpisode, $airDate, (String) null, 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.phisher98.XDMovies$load$6 */
    /* JADX INFO: compiled from: XDMovies.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.XDMovies$load$6", f = "XDMovies.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nXDMovies.kt\nKotlin\n*S Kotlin\n*F\n+ 1 XDMovies.kt\ncom/phisher98/XDMovies$load$6\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,538:1\n1#2:539\n*E\n"})
    static final class C00096 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<ActorData> $actors;
        final /* synthetic */ String $backgroundPoster;
        final /* synthetic */ String $description;
        final /* synthetic */ List<String> $genres;
        final /* synthetic */ String $imdbId;
        final /* synthetic */ String $logoUrl;
        final /* synthetic */ String $poster;
        final /* synthetic */ Score $rating;
        final /* synthetic */ String $source;
        final /* synthetic */ List<String> $tags;
        final /* synthetic */ int $tmdbId;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00096(String str, String str2, String str3, Integer num, String str4, List<String> list, Score score, String str5, List<ActorData> list2, String str6, int i, List<String> list3, Continuation<? super C00096> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$backgroundPoster = str2;
            this.$logoUrl = str3;
            this.$year = num;
            this.$description = str4;
            this.$tags = list;
            this.$rating = score;
            this.$source = str5;
            this.$actors = list2;
            this.$imdbId = str6;
            this.$tmdbId = i;
            this.$genres = list3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00096 = new C00096(this.$poster, this.$backgroundPoster, this.$logoUrl, this.$year, this.$description, this.$tags, this.$rating, this.$source, this.$actors, this.$imdbId, this.$tmdbId, this.$genres, continuation);
            c00096.L$0 = obj;
            return c00096;
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
                    loadResponse.setPosterUrl(this.$poster);
                    loadResponse.setBackgroundPosterUrl(this.$backgroundPoster);
                    try {
                        loadResponse.setLogoUrl(this.$logoUrl);
                        break;
                    } catch (Throwable th) {
                    }
                    loadResponse.setYear(this.$year);
                    loadResponse.setPlot(this.$description);
                    List<String> list = this.$tags;
                    List<String> list2 = this.$genres;
                    if (list.isEmpty()) {
                        list = list2;
                    }
                    loadResponse.setTags(list);
                    loadResponse.setScore(this.$rating);
                    loadResponse.setContentRating(this.$source);
                    loadResponse.setActors(this.$actors);
                    LoadResponse.Companion.addImdbId(loadResponse, this.$imdbId);
                    LoadResponse.Companion.addTMDbId(loadResponse, String.valueOf(this.$tmdbId));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.phisher98.XDMovies$load$7 */
    /* JADX INFO: compiled from: XDMovies.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.XDMovies$load$7", f = "XDMovies.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nXDMovies.kt\nKotlin\n*S Kotlin\n*F\n+ 1 XDMovies.kt\ncom/phisher98/XDMovies$load$7\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,538:1\n1#2:539\n*E\n"})
    static final class C00107 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<ActorData> $actors;
        final /* synthetic */ String $backgroundPoster;
        final /* synthetic */ String $description;
        final /* synthetic */ List<String> $genres;
        final /* synthetic */ String $imdbId;
        final /* synthetic */ String $logoUrl;
        final /* synthetic */ String $poster;
        final /* synthetic */ Score $rating;
        final /* synthetic */ String $source;
        final /* synthetic */ List<String> $tags;
        final /* synthetic */ int $tmdbId;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00107(String str, String str2, String str3, Integer num, String str4, List<String> list, Score score, String str5, List<ActorData> list2, String str6, int i, List<String> list3, Continuation<? super C00107> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$backgroundPoster = str2;
            this.$logoUrl = str3;
            this.$year = num;
            this.$description = str4;
            this.$tags = list;
            this.$rating = score;
            this.$source = str5;
            this.$actors = list2;
            this.$imdbId = str6;
            this.$tmdbId = i;
            this.$genres = list3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00107 = new C00107(this.$poster, this.$backgroundPoster, this.$logoUrl, this.$year, this.$description, this.$tags, this.$rating, this.$source, this.$actors, this.$imdbId, this.$tmdbId, this.$genres, continuation);
            c00107.L$0 = obj;
            return c00107;
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
                    loadResponse.setPosterUrl(this.$poster);
                    loadResponse.setBackgroundPosterUrl(this.$backgroundPoster);
                    try {
                        loadResponse.setLogoUrl(this.$logoUrl);
                        break;
                    } catch (Throwable th) {
                    }
                    loadResponse.setYear(this.$year);
                    loadResponse.setPlot(this.$description);
                    List<String> list = this.$tags;
                    List<String> list2 = this.$genres;
                    if (list.isEmpty()) {
                        list = list2;
                    }
                    loadResponse.setTags(list);
                    loadResponse.setScore(this.$rating);
                    loadResponse.setContentRating(this.$source);
                    loadResponse.setActors(this.$actors);
                    LoadResponse.Companion.addImdbId(loadResponse, this.$imdbId);
                    LoadResponse.Companion.addTMDbId(loadResponse, String.valueOf(this.$tmdbId));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:44:0x010d  */
    /* JADX WARN: Code duplicated, block: B:46:0x0120  */
    /* JADX WARN: Code duplicated, block: B:47:0x0123  */
    /* JADX WARN: Code duplicated, block: B:53:0x013b  */
    /* JADX WARN: Code duplicated, block: B:55:0x0140  */
    /* JADX WARN: Code duplicated, block: B:57:0x0179 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:58:0x017a  */
    /* JADX WARN: Code duplicated, block: B:61:0x0187  */
    /* JADX WARN: Code duplicated, block: B:71:0x0127 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:74:0x0107 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00111 c00111;
        boolean z;
        Object obj;
        List links;
        AtomicInteger successCount;
        boolean z2;
        C00122 c00122;
        Collection destination$iv$iv;
        boolean z3;
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
        C00111 c00112 = c00111;
        Object $result = c00112.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00112.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (StringsKt.isBlank(data)) {
                    return Boxing.boxBoolean(false);
                }
                try {
                    Result.Companion companion = Result.Companion;
                    XDMovies xDMovies = this;
                    JSONArray arr = new JSONArray(data);
                    List $this$loadLinks_u24lambda_u240_u240_u240 = CollectionsKt.createListBuilder(arr.length());
                    int length = arr.length();
                    for (int i = 0; i < length; i++) {
                        String it = StringsKt.trim(arr.optString(i)).toString();
                        if (!(it.length() > 0)) {
                            it = null;
                        }
                        if (it != null) {
                            z = false;
                            try {
                                Boxing.boxBoolean($this$loadLinks_u24lambda_u240_u240_u240.add(it));
                            } catch (Throwable th) {
                                th = th;
                                Result.Companion companion2 = Result.Companion;
                                obj = Result.constructor-impl(ResultKt.createFailure(th));
                                if (Result.exceptionOrNull-impl(obj) != null) {
                                    Iterable $this$filter$iv = CollectionsKt.listOf(StringsKt.trim(data).toString());
                                    destination$iv$iv = new ArrayList();
                                    for (Object element$iv$iv : $this$filter$iv) {
                                        if (((String) element$iv$iv).length() > 0) {
                                            z3 = true;
                                        } else {
                                            z3 = false;
                                        }
                                        if (z3) {
                                            destination$iv$iv.add(element$iv$iv);
                                        }
                                    }
                                    obj = (List) destination$iv$iv;
                                }
                                links = (List) obj;
                                if (links.isEmpty()) {
                                    return Boxing.boxBoolean(z);
                                }
                                z2 = false;
                                successCount = new AtomicInteger(0);
                                c00122 = new C00122(links, successCount, this, function1, function2, null);
                                c00112.L$0 = SpillingKt.nullOutSpilledVariable(data);
                                c00112.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                                c00112.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                                c00112.L$3 = SpillingKt.nullOutSpilledVariable(links);
                                c00112.L$4 = successCount;
                                c00112.Z$0 = isCasting;
                                c00112.label = 1;
                                if (CoroutineScopeKt.coroutineScope(c00122, c00112) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                if (successCount.get() > 0) {
                                    z2 = true;
                                }
                                return Boxing.boxBoolean(z2);
                            }
                        }
                    }
                    z = false;
                    obj = Result.constructor-impl(CollectionsKt.build($this$loadLinks_u24lambda_u240_u240_u240));
                } catch (Throwable th2) {
                    th = th2;
                    z = false;
                }
                if (Result.exceptionOrNull-impl(obj) != null) {
                    Iterable $this$filter$iv2 = CollectionsKt.listOf(StringsKt.trim(data).toString());
                    destination$iv$iv = new ArrayList();
                    while (r13.hasNext()) {
                        if (((String) element$iv$iv).length() > 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (z3) {
                            destination$iv$iv.add(element$iv$iv);
                        }
                    }
                    obj = (List) destination$iv$iv;
                }
                links = (List) obj;
                if (links.isEmpty()) {
                    return Boxing.boxBoolean(z);
                }
                z2 = false;
                successCount = new AtomicInteger(0);
                c00122 = new C00122(links, successCount, this, function1, function2, null);
                c00112.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00112.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                c00112.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                c00112.L$3 = SpillingKt.nullOutSpilledVariable(links);
                c00112.L$4 = successCount;
                c00112.Z$0 = isCasting;
                c00112.label = 1;
                if (CoroutineScopeKt.coroutineScope(c00122, c00112) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                boolean z4 = c00112.Z$0;
                AtomicInteger successCount2 = (AtomicInteger) c00112.L$4;
                ResultKt.throwOnFailure($result);
                z2 = false;
                successCount = successCount2;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (successCount.get() > 0) {
            z2 = true;
        }
        return Boxing.boxBoolean(z2);
    }

    /* JADX INFO: renamed from: com.phisher98.XDMovies$loadLinks$2 */
    /* JADX INFO: compiled from: XDMovies.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.XDMovies$loadLinks$2", f = "XDMovies.kt", i = {0}, l = {531}, m = "invokeSuspend", n = {"$this$coroutineScope"}, nl = {532}, s = {"L$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nXDMovies.kt\nKotlin\n*S Kotlin\n*F\n+ 1 XDMovies.kt\ncom/phisher98/XDMovies$loadLinks$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,538:1\n1739#2:539\n1814#2,3:540\n*S KotlinDebug\n*F\n+ 1 XDMovies.kt\ncom/phisher98/XDMovies$loadLinks$2\n*L\n510#1:539\n510#1:540,3\n*E\n"})
    static final class C00122 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ List<String> $links;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        final /* synthetic */ AtomicInteger $successCount;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ XDMovies this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00122(List<String> list, AtomicInteger atomicInteger, XDMovies xDMovies, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super C00122> continuation) {
            super(2, continuation);
            this.$links = list;
            this.$successCount = atomicInteger;
            this.this$0 = xDMovies;
            this.$subtitleCallback = function1;
            this.$callback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00122 = new C00122(this.$links, this.$successCount, this.this$0, this.$subtitleCallback, this.$callback, continuation);
            c00122.L$0 = obj;
            return c00122;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Iterable $this$map$iv = this.$links;
                    AtomicInteger atomicInteger = this.$successCount;
                    XDMovies xDMovies = this.this$0;
                    Function1<SubtitleFile, Unit> function1 = this.$subtitleCallback;
                    Function1<ExtractorLink, Unit> function2 = this.$callback;
                    Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    for (Object item$iv$iv : $this$map$iv) {
                        String link = (String) item$iv$iv;
                        Collection destination$iv$iv2 = destination$iv$iv;
                        destination$iv$iv2.add(BuildersKt.launch$default($this$coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new XDMovies$loadLinks$2$1$1(atomicInteger, link, xDMovies, function1, function2, null), 2, (Object) null));
                        destination$iv$iv = destination$iv$iv2;
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$coroutineScope);
                    this.label = 1;
                    if (AwaitKt.joinAll((List) destination$iv$iv, (Continuation) this) == coroutine_suspended) {
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
    }
}
