package com.cncverse;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;
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
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.network.CloudflareKiller;
import com.lagradost.cloudstream3.ui.settings.Globals;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
import com.lagradost.cloudstream3.utils.Qualities;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* JADX INFO: compiled from: MovieLinkBDProvider.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/MovieLinkBDProvider/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 a2\u00020\u0001:\u0001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010%\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010&J\u001e\u0010\u001b\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0096@¢\u0006\u0002\u0010,J\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u00192\u0006\u0010/\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u00100J\u001e\u00101\u001a\b\u0012\u0004\u0012\u00020.0\u00192\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0005H\u0002J\u0010\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u0005H\u0002J\u0016\u00108\u001a\u0002092\u0006\u00107\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u00100JF\u0010:\u001a\u00020\u00112\u0006\u0010;\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u00112\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u0002060>2\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u0002060>H\u0096@¢\u0006\u0002\u0010BJ:\u0010C\u001a\u0002062\u0006\u0010D\u001a\u00020\u00052\u0006\u0010E\u001a\u00020\u00052\u0006\u0010F\u001a\u00020\u00052\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u0002060>H\u0082@¢\u0006\u0002\u0010GJ:\u0010H\u001a\u0002062\u0006\u0010I\u001a\u00020\u00052\u0006\u0010E\u001a\u00020\u00052\u0006\u0010F\u001a\u00020\u00052\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u0002060>H\u0082@¢\u0006\u0002\u0010GJ:\u0010J\u001a\u0002062\u0006\u0010K\u001a\u00020\u00052\u0006\u0010E\u001a\u00020\u00052\u0006\u0010F\u001a\u00020\u00052\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u0002060>H\u0082@¢\u0006\u0002\u0010GJ:\u0010L\u001a\u0002062\u0006\u0010M\u001a\u00020\u00052\u0006\u0010E\u001a\u00020\u00052\u0006\u0010F\u001a\u00020\u00052\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u0002060>H\u0082@¢\u0006\u0002\u0010GJ2\u0010N\u001a\u0002062\u0006\u0010O\u001a\u00020\u00052\u0006\u0010E\u001a\u00020\u00052\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u0002060>H\u0082@¢\u0006\u0002\u0010PJ:\u0010Q\u001a\u0002062\u0006\u0010R\u001a\u00020\u00052\u0006\u0010E\u001a\u00020\u00052\u0006\u0010F\u001a\u00020\u00052\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u0002060>H\u0082@¢\u0006\u0002\u0010GJ\u0018\u0010S\u001a\u00020\u00052\u0006\u00107\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u0005H\u0002J\u0010\u0010T\u001a\u00020\u00052\u0006\u0010U\u001a\u00020\u0005H\u0002J\u0010\u0010V\u001a\u00020)2\u0006\u0010W\u001a\u00020\u0005H\u0002J,\u0010^\u001a\u00020\u00052\u0006\u00107\u001a\u00020\u00052\u0014\b\u0002\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050#H\u0082@¢\u0006\u0002\u0010_J,\u0010`\u001a\u0002032\u0006\u00107\u001a\u00020\u00052\u0014\b\u0002\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050#H\u0082@¢\u0006\u0002\u0010_R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0011X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u0011X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001a\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010X\u001a\u00020Y8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\\\u0010]\u001a\u0004\bZ\u0010[¨\u0006b"}, d2 = {"Lcom/cncverse/MovieLinkBDProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "lang", "getLang", "setLang", "hasMainPage", "", "getHasMainPage", "()Z", "hasDownloadSupport", "getHasDownloadSupport", "hasQuickSearch", "getHasQuickSearch", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "headers", "", "resolvedBase", "getBase", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseMovieCards", "doc", "Lorg/jsoup/nodes/Document;", "base", "openInExternalBrowser", "", "url", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveGetLink", "getLinkUrl", "qualityLabel", "refererUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveCdnUrl", "cdnUrl", "resolveWatchUrl", "watchUrl", "resolveGetWatch", "getWatchUrl", "resolveXCloud", "xcloudUrl", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveDirectFile", "fileUrl", "fixUrlDomain", "extractQualityLabel", "text", "labelToQuality", "label", "cfClient", "Lokhttp3/OkHttpClient;", "getCfClient", "()Lokhttp3/OkHttpClient;", "cfClient$delegate", "Lkotlin/Lazy;", "httpGetText", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "httpGetDoc", "Companion", "MovieLinkBDProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMovieLinkBDProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MovieLinkBDProvider.kt\ncom/cncverse/MovieLinkBDProvider\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n+ 5 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,1186:1\n1#2:1187\n1#2:1236\n1#2:1261\n1#2:1275\n296#3,2:1188\n1915#3,2:1190\n1915#3,2:1192\n1915#3:1194\n1916#3:1197\n832#3:1198\n862#3,2:1199\n832#3:1201\n862#3,2:1202\n832#3:1204\n862#3,2:1205\n1512#3:1207\n1538#3,3:1208\n1541#3,3:1218\n1915#3:1221\n832#3:1222\n862#3,2:1223\n1642#3,10:1225\n1915#3:1235\n1916#3:1237\n1652#3:1238\n1916#3:1239\n1915#3:1240\n832#3:1241\n862#3,2:1242\n1915#3,2:1244\n1916#3:1246\n832#3:1247\n862#3,2:1248\n1642#3,10:1250\n1915#3:1260\n1916#3:1262\n1652#3:1263\n1642#3,10:1264\n1915#3:1274\n1916#3:1276\n1652#3:1277\n1021#3,2:1278\n296#3,2:1280\n1088#4,2:1195\n383#5,7:1211\n*S KotlinDebug\n*F\n+ 1 MovieLinkBDProvider.kt\ncom/cncverse/MovieLinkBDProvider\n*L\n513#1:1236\n571#1:1261\n580#1:1275\n144#1:1188,2\n213#1:1190,2\n238#1:1192,2\n264#1:1194\n264#1:1197\n409#1:1198\n409#1:1199,2\n412#1:1201\n412#1:1202,2\n413#1:1204\n413#1:1205,2\n479#1:1207\n479#1:1208,3\n479#1:1218,3\n506#1:1221\n511#1:1222\n511#1:1223,2\n513#1:1225,10\n513#1:1235\n513#1:1237\n513#1:1238\n506#1:1239\n540#1:1240\n550#1:1241\n550#1:1242,2\n551#1:1244,2\n540#1:1246\n571#1:1247\n571#1:1248,2\n571#1:1250,10\n571#1:1260\n571#1:1262\n571#1:1263\n580#1:1264,10\n580#1:1274\n580#1:1276\n580#1:1277\n597#1:1278,2\n314#1:1280,2\n269#1:1195,2\n479#1:1211,7\n*E\n"})
public final class MovieLinkBDProvider extends MainAPI {
    private static final long BROWSER_DEBOUNCE_MS = 10000;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String FALLBACK_URL = "https://movielinkbd.one";

    @NotNull
    private static final String OMG10 = "aHR0cHM6Ly9vbWcxMC5jb20vNC8xMTEwNDQ4OQ==";

    @Nullable
    private static Context appContext;
    private static volatile boolean csGuardWasEverActive;
    private static volatile long lastBrowserOpenMs;
    private final boolean hasQuickSearch;

    @Nullable
    private volatile String resolvedBase;

    @NotNull
    private String mainUrl = FALLBACK_URL;

    @NotNull
    private String name = "MovieLinkBD";

    @NotNull
    private String lang = "bn";
    private final boolean hasMainPage = true;
    private final boolean hasDownloadSupport = true;

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("/", "Recently Updated"), TuplesKt.to("/type/movies", "All Movies"), TuplesKt.to("/type/series", "All Web Series"), TuplesKt.to("/language/hindi", "Hindi Movies"), TuplesKt.to("/language/bangla", "Bangla Movies"), TuplesKt.to("/language/bangla-dubbed", "Bangla Dubbed"), TuplesKt.to("/language/dual-audio", "Dual Audio"), TuplesKt.to("/language/english", "English"), TuplesKt.to("/southIndian", "South Indian"), TuplesKt.to("/language/korean", "Korean"), TuplesKt.to("/anime", "Anime Zone"), TuplesKt.to("/drama", "K/J/C Drama"), TuplesKt.to("/ongoing", "Ongoing Series"), TuplesKt.to("/genre/action", "Action"), TuplesKt.to("/genre/thriller", "Thriller"), TuplesKt.to("/genre/horror", "Horror"), TuplesKt.to("/genre/romance", "Romance"), TuplesKt.to("/category/wwe", "WWE")});

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.TvSeries, TvType.AsianDrama, TvType.AnimeMovie, TvType.Anime});

    @NotNull
    private final Map<String, String> headers = MapsKt.mapOf(new Pair[]{TuplesKt.to("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36"), TuplesKt.to("Accept-Language", "en-US,en;q=0.9")});

    /* JADX INFO: renamed from: cfClient$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy cfClient = LazyKt.lazy(new Function0() { // from class: com.cncverse.MovieLinkBDProvider$$ExternalSyntheticLambda3
        public final Object invoke() {
            return MovieLinkBDProvider.cfClient_delegate$lambda$0();
        }
    });

    /* JADX INFO: renamed from: com.cncverse.MovieLinkBDProvider$getBase$1 */
    /* JADX INFO: compiled from: MovieLinkBDProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.MovieLinkBDProvider", f = "MovieLinkBDProvider.kt", i = {0, 0, 0}, l = {142}, m = "getBase", n = {"currentUrl", "baseResult", "success"}, nl = {143}, s = {"L$0", "L$1", "I$0"}, v = 2)
    static final class C00001 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00001(Continuation<? super C00001> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MovieLinkBDProvider.this.getBase((Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.MovieLinkBDProvider$getMainPage$1 */
    /* JADX INFO: compiled from: MovieLinkBDProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.MovieLinkBDProvider", f = "MovieLinkBDProvider.kt", i = {0, 0, 1, 1, 1, 1, 1}, l = {180, 190}, m = "getMainPage", n = {"request", "page", "request", "base", "path", "url", "page"}, nl = {181, 191}, s = {"L$0", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C00011(Continuation<? super C00011> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MovieLinkBDProvider.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.MovieLinkBDProvider$httpGetDoc$1 */
    /* JADX INFO: compiled from: MovieLinkBDProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.MovieLinkBDProvider", f = "MovieLinkBDProvider.kt", i = {0, 0}, l = {1182}, m = "httpGetDoc", n = {"url", "headers"}, nl = {1183}, s = {"L$0", "L$1"}, v = 2)
    static final class C00021 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00021(Continuation<? super C00021> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MovieLinkBDProvider.this.httpGetDoc(null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.MovieLinkBDProvider$load$1 */
    /* JADX INFO: compiled from: MovieLinkBDProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.MovieLinkBDProvider", f = "MovieLinkBDProvider.kt", i = {0, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {298, 299, 465, 599}, m = "load", n = {"url", "url", "base", "url", "base", "doc", "rawTitle", "year", "posterElement", "poster", "plot", "genre", "cast", "language", "rating", "fullPlot", "jsonSources", "fileAnchors", "linkAnchors", "watchAnchors", "liveServerAnchors", "items", "linksData", "isSeries", "url", "base", "doc", "rawTitle", "year", "posterElement", "poster", "plot", "genre", "cast", "language", "rating", "fullPlot", "jsonSources", "fileAnchors", "linkAnchors", "watchAnchors", "liveServerAnchors", "episodesData", "isSeries"}, nl = {299, 302, 474, -1}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "I$0"}, v = 2)
    static final class C00041 extends ContinuationImpl {
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
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C00041(Continuation<? super C00041> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MovieLinkBDProvider.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.MovieLinkBDProvider$resolveCdnUrl$1 */
    /* JADX INFO: compiled from: MovieLinkBDProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.MovieLinkBDProvider", f = "MovieLinkBDProvider.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {800}, m = "resolveCdnUrl", n = {"cdnUrl", "qualityLabel", "refererUrl", "callback", "type", "displayName", "reqHeaders", "quality"}, nl = {799}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0"}, v = 2)
    static final class C00081 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        C00081(Continuation<? super C00081> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MovieLinkBDProvider.this.resolveCdnUrl(null, null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.MovieLinkBDProvider$resolveDirectFile$1 */
    /* JADX INFO: compiled from: MovieLinkBDProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.MovieLinkBDProvider", f = "MovieLinkBDProvider.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {1081, 1083, 1102}, m = "resolveDirectFile", n = {"fileUrl", "qualityLabel", "refererUrl", "callback", "fileUrl", "qualityLabel", "refererUrl", "callback", "base", "requestHeaders", "fileUrl", "qualityLabel", "refererUrl", "callback", "base", "requestHeaders", "html", "unescapedHtml", "srcRegex", "watchRegex", "m3u8Regex", "mp4Regex", "streamUrl", "resolvedUrl", "fixedStreamUrl", "type", "quality"}, nl = {1082, 1084, 1101}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "I$0"}, v = 2)
    static final class C00101 extends ContinuationImpl {
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

        C00101(Continuation<? super C00101> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MovieLinkBDProvider.this.resolveDirectFile(null, null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.MovieLinkBDProvider$resolveGetLink$1 */
    /* JADX INFO: compiled from: MovieLinkBDProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.MovieLinkBDProvider", f = "MovieLinkBDProvider.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7}, l = {702, 704, 719, 722, 732, 753, 764, 769}, m = "resolveGetLink", n = {"getLinkUrl", "qualityLabel", "refererUrl", "callback", "getLinkUrl", "qualityLabel", "refererUrl", "callback", "base", "reqHeaders", "getLinkUrl", "qualityLabel", "refererUrl", "callback", "base", "reqHeaders", "doc", "bodyText", "videoSrc", "streamUrl", "fixedStreamUrl", "getLinkUrl", "qualityLabel", "refererUrl", "callback", "base", "reqHeaders", "doc", "bodyText", "videoSrc", "streamUrl", "fixedStreamUrl", "getLinkUrl", "qualityLabel", "refererUrl", "callback", "base", "reqHeaders", "doc", "bodyText", "videoSrc", "streamUrl", "fixedStreamUrl", "type", "quality", "getLinkUrl", "qualityLabel", "refererUrl", "callback", "base", "reqHeaders", "doc", "bodyText", "videoSrc", "fileAnchor", "href", "fileUrl", "fixedFileUrl", "getLinkUrl", "qualityLabel", "refererUrl", "callback", "base", "reqHeaders", "doc", "bodyText", "videoSrc", "fileAnchor", "a", "href", "getLinkUrl", "qualityLabel", "refererUrl", "callback", "base", "reqHeaders", "doc", "bodyText", "videoSrc", "fileAnchor", "a", "href"}, nl = {703, 707, 720, 727, 731, 758, 768, 774}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "L$12", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "L$12"}, v = 2)
    static final class C00121 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
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

        C00121(Continuation<? super C00121> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MovieLinkBDProvider.this.resolveGetLink(null, null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.MovieLinkBDProvider$resolveGetWatch$1 */
    /* JADX INFO: compiled from: MovieLinkBDProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.MovieLinkBDProvider", f = "MovieLinkBDProvider.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8}, l = {863, 865, 877, 894, 900, 921, 932, 934, 943}, m = "resolveGetWatch", n = {"getWatchUrl", "qualityLabel", "refererUrl", "callback", "getWatchUrl", "qualityLabel", "refererUrl", "callback", "base", "requestHeaders", "getWatchUrl", "qualityLabel", "refererUrl", "callback", "base", "requestHeaders", "html", "doc", "watchAnchor", "href", "watchUrl", "fixedWatchUrl", "watchHeaders", "getWatchUrl", "qualityLabel", "refererUrl", "callback", "base", "requestHeaders", "html", "doc", "watchAnchor", "href", "watchUrl", "fixedWatchUrl", "watchHeaders", "watchHtml", "unescapedWatchHtml", "srcRegex", "watchRegex", "m3u8Regex", "mp4Regex", "streamUrl", "resolvedUrl", "fixedStreamUrl", "getWatchUrl", "qualityLabel", "refererUrl", "callback", "base", "requestHeaders", "html", "doc", "watchAnchor", "href", "watchUrl", "fixedWatchUrl", "watchHeaders", "watchHtml", "unescapedWatchHtml", "srcRegex", "watchRegex", "m3u8Regex", "mp4Regex", "streamUrl", "resolvedUrl", "fixedStreamUrl", "type", "quality", "getWatchUrl", "qualityLabel", "refererUrl", "callback", "base", "requestHeaders", "html", "doc", "watchAnchor", "fileAnchor", "href", "fileUrl", "fixedFileUrl", "getWatchUrl", "qualityLabel", "refererUrl", "callback", "base", "requestHeaders", "html", "doc", "watchAnchor", "fileAnchor", "videoSrc", "resolvedUrl", "fixedResolvedUrl", "getWatchUrl", "qualityLabel", "refererUrl", "callback", "base", "requestHeaders", "html", "doc", "watchAnchor", "fileAnchor", "videoSrc", "resolvedUrl", "fixedResolvedUrl", "getWatchUrl", "qualityLabel", "refererUrl", "callback", "base", "requestHeaders", "html", "doc", "watchAnchor", "fileAnchor", "videoSrc", "resolvedUrl", "fixedResolvedUrl", "type", "quality"}, nl = {864, 866, 878, 895, 899, 922, 933, 940, 942}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "I$0"}, v = 2)
    static final class C00141 extends ContinuationImpl {
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
        Object L$3;
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
            return MovieLinkBDProvider.this.resolveGetWatch(null, null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.MovieLinkBDProvider$resolveWatchUrl$1 */
    /* JADX INFO: compiled from: MovieLinkBDProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.MovieLinkBDProvider", f = "MovieLinkBDProvider.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {822, 830, 841, 849}, m = "resolveWatchUrl", n = {"watchUrl", "qualityLabel", "refererUrl", "callback", "reqHeaders", "type", "quality", "watchUrl", "qualityLabel", "refererUrl", "callback", "reqHeaders", "watchUrl", "qualityLabel", "refererUrl", "callback", "reqHeaders", "html", "unescaped", "srcRegex", "m3u8Regex", "mp4Regex", "streamUrl", "type", "quality", "watchUrl", "qualityLabel", "refererUrl", "callback", "reqHeaders", "html", "unescaped", "srcRegex", "m3u8Regex", "mp4Regex", "streamUrl"}, nl = {827, 831, 848, 850}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10"}, v = 2)
    static final class C00171 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
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

        C00171(Continuation<? super C00171> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MovieLinkBDProvider.this.resolveWatchUrl(null, null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.MovieLinkBDProvider$resolveXCloud$1 */
    /* JADX INFO: compiled from: MovieLinkBDProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.MovieLinkBDProvider", f = "MovieLinkBDProvider.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {1030, 1043, 1057}, m = "resolveXCloud", n = {"xcloudUrl", "qualityLabel", "callback", "TAG", "userAgent", "streamPlayerUrl", "streamUrl", "simpleHeaders", "tryUrl", "quality", "xcloudUrl", "qualityLabel", "callback", "TAG", "userAgent", "streamPlayerUrl", "streamUrl", "simpleHeaders", "tryUrl", "quality", "xcloudUrl", "qualityLabel", "callback", "TAG", "userAgent", "streamPlayerUrl", "streamUrl", "simpleHeaders", "type", "quality"}, nl = {1031, 1044, 1056}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$9", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$9", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0"}, v = 2)
    static final class C00201 extends ContinuationImpl {
        int I$0;
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
        int label;
        /* synthetic */ Object result;

        C00201(Continuation<? super C00201> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MovieLinkBDProvider.this.resolveXCloud(null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.MovieLinkBDProvider$search$1 */
    /* JADX INFO: compiled from: MovieLinkBDProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.MovieLinkBDProvider", f = "MovieLinkBDProvider.kt", i = {0, 1, 1, 1}, l = {198, 200}, m = "search", n = {"query", "query", "base", "encodedQuery"}, nl = {199, 201}, s = {"L$0", "L$0", "L$1", "L$2"}, v = 2)
    static final class C00221 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00221(Continuation<? super C00221> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MovieLinkBDProvider.this.search(null, (Continuation) this);
        }
    }

    /* JADX INFO: compiled from: MovieLinkBDProvider.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/cncverse/MovieLinkBDProvider$Companion;", "", "<init>", "()V", "isCsGuardActive", "", "csGuardWasEverActive", "isCsGuardBlocked", "showCsGuardToast", "", "ctx", "Landroid/content/Context;", "appContext", "getAppContext", "()Landroid/content/Context;", "setAppContext", "(Landroid/content/Context;)V", "FALLBACK_URL", "", "OMG10", "lastBrowserOpenMs", "", "BROWSER_DEBOUNCE_MS", "MovieLinkBDProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nMovieLinkBDProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MovieLinkBDProvider.kt\ncom/cncverse/MovieLinkBDProvider$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1186:1\n1#2:1187\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Code duplicated, block: B:11:0x0042  */
        public final boolean isCsGuardActive() {
            String name;
            Class<?> cls;
            String name2;
            try {
                Class<?> cls2 = Class.forName("android.app.ActivityThread");
                Object thread = cls2.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
                Field field = cls2.getDeclaredField("mInstrumentation");
                field.setAccessible(true);
                Object obj = field.get(thread);
                if (obj == null || (cls = obj.getClass()) == null || (name2 = cls.getName()) == null) {
                    name = "";
                } else {
                    name = name2.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(name, "toLowerCase(...)");
                    if (name == null) {
                        name = "";
                    }
                }
                return StringsKt.contains$default(name, "guard", false, 2, (Object) null) || StringsKt.contains$default(name, "csguard", false, 2, (Object) null);
            } catch (Throwable th) {
                return false;
            }
        }

        public final boolean isCsGuardBlocked() {
            if (isCsGuardActive()) {
                MovieLinkBDProvider.csGuardWasEverActive = true;
            }
            return MovieLinkBDProvider.csGuardWasEverActive;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void showCsGuardToast(final Context ctx) {
            if (ctx == null) {
                return;
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.MovieLinkBDProvider$Companion$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    MovieLinkBDProvider.Companion.showCsGuardToast$lambda$0(ctx);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void showCsGuardToast$lambda$0(Context $c) {
            Toast.makeText($c, "🚫 CSGuard detected — Restart CloudStream after removing CSGuard to use CNCRepo", 1).show();
        }

        @Nullable
        public final Context getAppContext() {
            return MovieLinkBDProvider.appContext;
        }

        public final void setAppContext(@Nullable Context context) {
            MovieLinkBDProvider.appContext = context;
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
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:104:0x0104 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:105:0x00f9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:106:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:42:0x00b4 A[Catch: Exception -> 0x0191, TRY_LEAVE, TryCatch #5 {Exception -> 0x0191, blocks: (B:39:0x0099, B:40:0x00ae, B:42:0x00b4), top: B:102:0x0099 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00e3 A[Catch: Exception -> 0x018f, TryCatch #0 {Exception -> 0x018f, blocks: (B:44:0x00dd, B:46:0x00e3, B:56:0x010b, B:59:0x0113, B:67:0x012a, B:69:0x016c, B:61:0x0119, B:63:0x0121), top: B:92:0x00dd }] */
    /* JADX WARN: Code duplicated, block: B:48:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:49:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:50:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:54:0x00fa A[LOOP:0: B:40:0x00ae->B:54:0x00fa, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:61:0x0119 A[Catch: Exception -> 0x018f, TryCatch #0 {Exception -> 0x018f, blocks: (B:44:0x00dd, B:46:0x00e3, B:56:0x010b, B:59:0x0113, B:67:0x012a, B:69:0x016c, B:61:0x0119, B:63:0x0121), top: B:92:0x00dd }] */
    /* JADX WARN: Code duplicated, block: B:63:0x0121 A[Catch: Exception -> 0x018f, TryCatch #0 {Exception -> 0x018f, blocks: (B:44:0x00dd, B:46:0x00e3, B:56:0x010b, B:59:0x0113, B:67:0x012a, B:69:0x016c, B:61:0x0119, B:63:0x0121), top: B:92:0x00dd }] */
    /* JADX WARN: Code duplicated, block: B:64:0x0126  */
    /* JADX WARN: Code duplicated, block: B:66:0x0129  */
    /* JADX WARN: Code duplicated, block: B:69:0x016c A[Catch: Exception -> 0x018f, TRY_LEAVE, TryCatch #0 {Exception -> 0x018f, blocks: (B:44:0x00dd, B:46:0x00e3, B:56:0x010b, B:59:0x0113, B:67:0x012a, B:69:0x016c, B:61:0x0119, B:63:0x0121), top: B:92:0x00dd }] */
    /* JADX WARN: Code duplicated, block: B:72:0x0174 A[Catch: Exception -> 0x018d, TryCatch #2 {Exception -> 0x018d, blocks: (B:70:0x0170, B:72:0x0174, B:75:0x017d, B:77:0x0183, B:79:0x0189), top: B:96:0x0170 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x017a  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:90:0x019c  */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object getBase(Continuation<? super String> continuation) {
        C00001 c00001;
        String string;
        String mainUrl;
        int i;
        String str;
        Object objHttpGetText;
        Document document;
        Iterable iterableSelect;
        Iterator it;
        String str2;
        Object next;
        Element element;
        Element elementSelectFirst;
        String strAttr;
        Context context;
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor editorEdit;
        SharedPreferences.Editor editorPutString;
        SharedPreferences sharedPreferences2;
        String lowerCase;
        Iterable iterable;
        C00001 c00002;
        boolean z;
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
        C00001 c00003 = c00001;
        Object obj = c00003.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        String str3 = null;
        switch (c00003.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                String str4 = this.resolvedBase;
                if (str4 != null) {
                    return str4;
                }
                if (Intrinsics.areEqual(getMainUrl(), FALLBACK_URL)) {
                    try {
                        Context context2 = appContext;
                        SharedPreferences sharedPreferences3 = context2 != null ? context2.getSharedPreferences("com.lagradost.cloudstream3", 0) : null;
                        if (sharedPreferences3 != null && (string = sharedPreferences3.getString("movielinkbd_main_url", null)) != null) {
                            setMainUrl(string);
                        }
                        break;
                    } catch (Exception e) {
                    }
                }
                mainUrl = getMainUrl();
                try {
                    Map<String, String> map = this.headers;
                    c00003.L$0 = mainUrl;
                    c00003.L$1 = FALLBACK_URL;
                    c00003.I$0 = 0;
                    c00003.label = 1;
                    objHttpGetText = httpGetText(mainUrl, map, c00003);
                    if (objHttpGetText == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    i = 0;
                    str = FALLBACK_URL;
                    try {
                        document = Jsoup.parse((String) objHttpGetText, mainUrl);
                        iterableSelect = document.select("a");
                        it = iterableSelect.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                next = it.next();
                                lowerCase = ((Element) next).text().toLowerCase(Locale.ROOT);
                                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                                iterable = iterableSelect;
                                c00002 = c00003;
                                try {
                                    if (StringsKt.contains$default(lowerCase, "visit movielinkbd new site", false, 2, (Object) null)) {
                                        str2 = null;
                                    } else {
                                        str2 = null;
                                        if (StringsKt.contains$default(lowerCase, "new site", false, 2, (Object) null)) {
                                            z = false;
                                        }
                                        if (z) {
                                            str3 = str2;
                                            iterableSelect = iterable;
                                            c00003 = c00002;
                                        }
                                    }
                                    z = true;
                                    if (z) {
                                        str3 = str2;
                                        iterableSelect = iterable;
                                        c00003 = c00002;
                                    }
                                } catch (Exception e2) {
                                }
                            } else {
                                str2 = str3;
                                next = str2;
                            }
                        }
                        element = (Element) next;
                        if (element != null || (strAttr = element.attr("abs:href")) == null) {
                            elementSelectFirst = document.selectFirst("a[href*='movielinkbd']:not([href*='movielinkbd.one'])");
                            if (elementSelectFirst != null) {
                                strAttr = elementSelectFirst.attr("abs:href");
                            } else {
                                strAttr = str2;
                            }
                            if (strAttr == null) {
                                strAttr = mainUrl;
                            }
                        }
                        URI uri = new URI(StringsKt.trimEnd(strAttr, new char[]{'/'}));
                        str = uri.getScheme() + "://" + uri.getHost();
                        this.resolvedBase = str;
                        i = 1;
                        if (!Intrinsics.areEqual(str, getMainUrl())) {
                            setMainUrl(str);
                            try {
                                context = appContext;
                                if (context != null) {
                                    sharedPreferences2 = context.getSharedPreferences("com.lagradost.cloudstream3", 0);
                                } else {
                                    sharedPreferences = str2;
                                }
                                if (sharedPreferences != 0 && (editorEdit = sharedPreferences.edit()) != null && (editorPutString = editorEdit.putString("movielinkbd_main_url", str)) != null) {
                                    sharedPreferences = sharedPreferences2;
                                    editorPutString.apply();
                                }
                                break;
                            } catch (Exception e3) {
                            }
                        }
                    } catch (Exception e4) {
                    }
                    if (i == 0) {
                        return str;
                    }
                    this.resolvedBase = getMainUrl();
                    return getMainUrl();
                } catch (Exception e5) {
                    i = 0;
                    str = FALLBACK_URL;
                }
                break;
            case 1:
                i = c00003.I$0;
                str = (String) c00003.L$1;
                mainUrl = (String) c00003.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    objHttpGetText = obj;
                    document = Jsoup.parse((String) objHttpGetText, mainUrl);
                    iterableSelect = document.select("a");
                    it = iterableSelect.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            next = it.next();
                            lowerCase = ((Element) next).text().toLowerCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                            iterable = iterableSelect;
                            c00002 = c00003;
                            if (StringsKt.contains$default(lowerCase, "visit movielinkbd new site", false, 2, (Object) null)) {
                                str2 = null;
                                if (StringsKt.contains$default(lowerCase, "new site", false, 2, (Object) null)) {
                                    z = false;
                                }
                                if (z) {
                                    str3 = str2;
                                    iterableSelect = iterable;
                                    c00003 = c00002;
                                }
                            } else {
                                str2 = null;
                            }
                            z = true;
                            if (z) {
                                str3 = str2;
                                iterableSelect = iterable;
                                c00003 = c00002;
                            }
                        } else {
                            str2 = str3;
                            next = str2;
                        }
                    }
                    element = (Element) next;
                    if (element != null) {
                        elementSelectFirst = document.selectFirst("a[href*='movielinkbd']:not([href*='movielinkbd.one'])");
                        if (elementSelectFirst != null) {
                            strAttr = elementSelectFirst.attr("abs:href");
                        } else {
                            strAttr = str2;
                        }
                        if (strAttr == null) {
                            strAttr = mainUrl;
                        }
                    } else {
                        elementSelectFirst = document.selectFirst("a[href*='movielinkbd']:not([href*='movielinkbd.one'])");
                        if (elementSelectFirst != null) {
                            strAttr = elementSelectFirst.attr("abs:href");
                        } else {
                            strAttr = str2;
                        }
                        if (strAttr == null) {
                            strAttr = mainUrl;
                        }
                    }
                    URI uri2 = new URI(StringsKt.trimEnd(strAttr, new char[]{'/'}));
                    str = uri2.getScheme() + "://" + uri2.getHost();
                    this.resolvedBase = str;
                    i = 1;
                    if (!Intrinsics.areEqual(str, getMainUrl())) {
                        setMainUrl(str);
                        context = appContext;
                        if (context != null) {
                            sharedPreferences2 = context.getSharedPreferences("com.lagradost.cloudstream3", 0);
                        } else {
                            sharedPreferences = str2;
                        }
                        if (sharedPreferences != 0) {
                            sharedPreferences = sharedPreferences2;
                            editorPutString.apply();
                        }
                    }
                    break;
                } catch (Exception e6) {
                }
                if (i == 0) {
                    return str;
                }
                this.resolvedBase = getMainUrl();
                return getMainUrl();
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00af  */
    /* JADX WARN: Code duplicated, block: B:28:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:29:0x00cd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:31:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:34:0x0117 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:35:0x0118  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        C00011 c00011;
        Object base;
        MainPageRequest request2;
        int page2;
        String base2;
        String path;
        String url;
        Object objHttpGetDoc;
        MainPageRequest request3;
        String base3;
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
                if (INSTANCE.isCsGuardBlocked()) {
                    INSTANCE.showCsGuardToast(null);
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), (Boolean) null, 2, (Object) null);
                }
                c00011.L$0 = request;
                c00011.I$0 = page;
                c00011.label = 1;
                base = getBase(c00011);
                if (base == coroutine_suspended) {
                    return coroutine_suspended;
                }
                request2 = request;
                page2 = page;
                base2 = (String) base;
                path = request2.getData();
                if (!Intrinsics.areEqual(path, "/") && page2 == 1) {
                    url = base2 + '/';
                } else if (Intrinsics.areEqual(path, "/")) {
                    url = base2 + "/page/" + page2;
                } else if (page2 == 1) {
                    url = base2 + path;
                } else {
                    url = base2 + path + "/page/" + page2;
                }
                Map<String, String> map = this.headers;
                c00011.L$0 = request2;
                c00011.L$1 = base2;
                c00011.L$2 = SpillingKt.nullOutSpilledVariable(path);
                c00011.L$3 = SpillingKt.nullOutSpilledVariable(url);
                c00011.I$0 = page2;
                c00011.label = 2;
                objHttpGetDoc = httpGetDoc(url, map, c00011);
                if (objHttpGetDoc == coroutine_suspended) {
                    return coroutine_suspended;
                }
                request3 = request2;
                base3 = base2;
                Document doc = (Document) objHttpGetDoc;
                List<SearchResponse> movieCards = parseMovieCards(doc, base3);
                return MainAPIKt.newHomePageResponse(new HomePageList(request3.getName(), movieCards, false, 4, (DefaultConstructorMarker) null), Boxing.boxBoolean(true ^ movieCards.isEmpty()));
            case 1:
                page2 = c00011.I$0;
                request2 = (MainPageRequest) c00011.L$0;
                ResultKt.throwOnFailure($result);
                base = $result;
                base2 = (String) base;
                path = request2.getData();
                if (!Intrinsics.areEqual(path, "/")) {
                    if (Intrinsics.areEqual(path, "/")) {
                        url = base2 + "/page/" + page2;
                    } else if (page2 == 1) {
                        url = base2 + path;
                    } else {
                        url = base2 + path + "/page/" + page2;
                    }
                } else if (Intrinsics.areEqual(path, "/")) {
                    url = base2 + "/page/" + page2;
                } else if (page2 == 1) {
                    url = base2 + path;
                } else {
                    url = base2 + path + "/page/" + page2;
                }
                Map<String, String> map2 = this.headers;
                c00011.L$0 = request2;
                c00011.L$1 = base2;
                c00011.L$2 = SpillingKt.nullOutSpilledVariable(path);
                c00011.L$3 = SpillingKt.nullOutSpilledVariable(url);
                c00011.I$0 = page2;
                c00011.label = 2;
                objHttpGetDoc = httpGetDoc(url, map2, c00011);
                if (objHttpGetDoc == coroutine_suspended) {
                    return coroutine_suspended;
                }
                request3 = request2;
                base3 = base2;
                Document doc2 = (Document) objHttpGetDoc;
                List<SearchResponse> movieCards2 = parseMovieCards(doc2, base3);
                return MainAPIKt.newHomePageResponse(new HomePageList(request3.getName(), movieCards2, false, 4, (DefaultConstructorMarker) null), Boxing.boxBoolean(true ^ movieCards2.isEmpty()));
            case 2:
                int i = c00011.I$0;
                base3 = (String) c00011.L$1;
                request3 = (MainPageRequest) c00011.L$0;
                ResultKt.throwOnFailure($result);
                objHttpGetDoc = $result;
                Document doc3 = (Document) objHttpGetDoc;
                List<SearchResponse> movieCards3 = parseMovieCards(doc3, base3);
                return MainAPIKt.newHomePageResponse(new HomePageList(request3.getName(), movieCards3, false, 4, (DefaultConstructorMarker) null), Boxing.boxBoolean(true ^ movieCards3.isEmpty()));
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x00ad A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) throws UnsupportedEncodingException {
        C00221 c00221;
        Object base;
        String base2;
        Object objHttpGetDoc;
        if (continuation instanceof C00221) {
            c00221 = (C00221) continuation;
            if ((c00221.label & Integer.MIN_VALUE) != 0) {
                c00221.label -= Integer.MIN_VALUE;
            } else {
                c00221 = new C00221(continuation);
            }
        } else {
            c00221 = new C00221(continuation);
        }
        Object $result = c00221.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00221.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (INSTANCE.isCsGuardBlocked()) {
                    INSTANCE.showCsGuardToast(null);
                    return CollectionsKt.emptyList();
                }
                c00221.L$0 = query;
                c00221.label = 1;
                base = getBase(c00221);
                if (base == coroutine_suspended) {
                    return coroutine_suspended;
                }
                base2 = (String) base;
                String encodedQuery = URLEncoder.encode(StringsKt.trim(query).toString(), "UTF-8");
                Map<String, String> map = this.headers;
                c00221.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00221.L$1 = base2;
                c00221.L$2 = SpillingKt.nullOutSpilledVariable(encodedQuery);
                c00221.label = 2;
                objHttpGetDoc = httpGetDoc(base2 + "/search?q=" + encodedQuery, map, c00221);
                if (objHttpGetDoc == coroutine_suspended) {
                    return coroutine_suspended;
                }
                Document doc = (Document) objHttpGetDoc;
                return parseMovieCards(doc, base2);
            case 1:
                query = (String) c00221.L$0;
                ResultKt.throwOnFailure($result);
                base = $result;
                base2 = (String) base;
                String encodedQuery2 = URLEncoder.encode(StringsKt.trim(query).toString(), "UTF-8");
                Map<String, String> map2 = this.headers;
                c00221.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00221.L$1 = base2;
                c00221.L$2 = SpillingKt.nullOutSpilledVariable(encodedQuery2);
                c00221.label = 2;
                objHttpGetDoc = httpGetDoc(base2 + "/search?q=" + encodedQuery2, map2, c00221);
                if (objHttpGetDoc == coroutine_suspended) {
                    return coroutine_suspended;
                }
                Document doc2 = (Document) objHttpGetDoc;
                return parseMovieCards(doc2, base2);
            case 2:
                base2 = (String) c00221.L$1;
                ResultKt.throwOnFailure($result);
                objHttpGetDoc = $result;
                Document doc3 = (Document) objHttpGetDoc;
                return parseMovieCards(doc3, base2);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:104:0x0243  */
    /* JADX WARN: Code duplicated, block: B:106:0x025f  */
    /* JADX WARN: Code duplicated, block: B:107:0x0262  */
    /* JADX WARN: Code duplicated, block: B:110:0x0267  */
    /* JADX WARN: Code duplicated, block: B:112:0x026a  */
    /* JADX WARN: Code duplicated, block: B:114:0x0286  */
    /* JADX WARN: Code duplicated, block: B:115:0x0289  */
    /* JADX WARN: Code duplicated, block: B:118:0x028e  */
    /* JADX WARN: Code duplicated, block: B:120:0x0291  */
    /* JADX WARN: Code duplicated, block: B:121:0x0296 A[PHI: r8
      0x0296: PHI (r8v21 'it' java.lang.String) = (r8v13 'it' java.lang.String), (r8v18 'it' java.lang.String), (r8v30 'it' java.lang.String) binds: [B:111:0x0268, B:119:0x028f, B:103:0x0241] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:123:0x02b1  */
    /* JADX WARN: Code duplicated, block: B:127:0x02c3  */
    /* JADX WARN: Code duplicated, block: B:168:0x03b4 A[LOOP:3: B:156:0x0388->B:168:0x03b4, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:201:0x03b2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:33:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:34:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:37:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:39:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:40:0x00e8 A[PHI: r3
      0x00e8: PHI (r3v19 'it' java.lang.String) = (r3v17 'it' java.lang.String), (r3v36 'it' java.lang.String) binds: [B:38:0x00de, B:30:0x00b8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:42:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:52:0x010e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:53:0x0110  */
    /* JADX WARN: Code duplicated, block: B:54:0x0115  */
    /* JADX WARN: Code duplicated, block: B:57:0x0131  */
    /* JADX WARN: Code duplicated, block: B:61:0x0143  */
    private final List<SearchResponse> parseMovieCards(Document doc, String base) {
        boolean z;
        int i;
        boolean z2;
        String str;
        String str2;
        String it;
        boolean z3;
        boolean z4;
        TvType tvType;
        String strText;
        String it2;
        boolean z5;
        String str3;
        Element img;
        final String poster;
        TvType tvType2;
        String strAttr;
        String strText2;
        String str4 = base;
        List results = new ArrayList();
        Elements cards = doc.select("div.movie-item, div.item-box, div.film-item, div.post-item, .movie-card");
        String str5 = "title";
        String str6 = "data-src";
        String str7 = "img";
        String str8 = "/anime/";
        String str9 = "/series/";
        String str10 = "src";
        if (!((Collection) cards).isEmpty()) {
            Iterable<Element> $this$forEach$iv = (Iterable) cards;
            for (Element card : $this$forEach$iv) {
                Element aTag = card.selectFirst("a[href*='/movie/'], a[href*='/series/'], a[href*='/anime/'], a[href*='/download18plus/']");
                if (aTag == null) {
                    cards = cards;
                    str3 = str8;
                } else {
                    String strAttr2 = aTag.attr("abs:href");
                    if (strAttr2.length() == 0) {
                        strAttr2 = str4 + aTag.attr("href");
                    }
                    String href = strAttr2;
                    Element elementSelectFirst = card.selectFirst(".title, .movie-title, h3, h2");
                    if (elementSelectFirst == null || (strText2 = elementSelectFirst.text()) == null || (it2 = StringsKt.trim(strText2).toString()) == null) {
                        it2 = StringsKt.trim(aTag.attr("title")).toString();
                        if (it2.length() > 0) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if (!z5) {
                            it2 = null;
                        }
                        if (it2 == null) {
                            str3 = str8;
                        } else {
                            String title = it2;
                            img = card.selectFirst("img");
                            if (img == null && (strAttr = img.attr("data-src")) != null) {
                                String strAttr3 = strAttr;
                                if (strAttr3.length() == 0) {
                                    strAttr3 = img.attr("src");
                                }
                                poster = strAttr3;
                                if (poster == null) {
                                    if (img != null) {
                                        poster = img.attr("src");
                                    } else {
                                        poster = null;
                                    }
                                }
                            } else if (img != null) {
                                poster = img.attr("src");
                            } else {
                                poster = null;
                            }
                            str3 = str8;
                            if (!StringsKt.contains$default(href, str9, false, 2, (Object) null) || StringsKt.contains$default(href, str3, false, 2, (Object) null)) {
                                tvType2 = TvType.TvSeries;
                            } else {
                                tvType2 = TvType.Movie;
                            }
                            TvType type = tvType2;
                            results.add(MainAPIKt.newMovieSearchResponse$default(this, title, href, type, false, new Function1() { // from class: com.cncverse.MovieLinkBDProvider$$ExternalSyntheticLambda8
                                public final Object invoke(Object obj) {
                                    return MovieLinkBDProvider.parseMovieCards$lambda$0$4(poster, (MovieSearchResponse) obj);
                                }
                            }, 8, (Object) null));
                        }
                    } else {
                        if (!(it2.length() > 0)) {
                            it2 = null;
                        }
                        if (it2 == null) {
                            it2 = StringsKt.trim(aTag.attr("title")).toString();
                            if (it2.length() > 0) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            if (!z5) {
                                it2 = null;
                            }
                            if (it2 == null) {
                                str3 = str8;
                            } else {
                                String title2 = it2;
                                img = card.selectFirst("img");
                                if (img == null) {
                                    if (img != null) {
                                        poster = img.attr("src");
                                    } else {
                                        poster = null;
                                    }
                                } else if (img != null) {
                                    poster = img.attr("src");
                                } else {
                                    poster = null;
                                }
                                str3 = str8;
                                if (StringsKt.contains$default(href, str9, false, 2, (Object) null)) {
                                    tvType2 = TvType.TvSeries;
                                } else {
                                    tvType2 = TvType.TvSeries;
                                }
                                TvType type2 = tvType2;
                                results.add(MainAPIKt.newMovieSearchResponse$default(this, title2, href, type2, false, new Function1() { // from class: com.cncverse.MovieLinkBDProvider$$ExternalSyntheticLambda8
                                    public final Object invoke(Object obj) {
                                        return MovieLinkBDProvider.parseMovieCards$lambda$0$4(poster, (MovieSearchResponse) obj);
                                    }
                                }, 8, (Object) null));
                            }
                        } else {
                            String title3 = it2;
                            img = card.selectFirst("img");
                            if (img == null) {
                                if (img != null) {
                                    poster = img.attr("src");
                                } else {
                                    poster = null;
                                }
                            } else if (img != null) {
                                poster = img.attr("src");
                            } else {
                                poster = null;
                            }
                            str3 = str8;
                            if (StringsKt.contains$default(href, str9, false, 2, (Object) null)) {
                                tvType2 = TvType.TvSeries;
                            } else {
                                tvType2 = TvType.TvSeries;
                            }
                            TvType type3 = tvType2;
                            results.add(MainAPIKt.newMovieSearchResponse$default(this, title3, href, type3, false, new Function1() { // from class: com.cncverse.MovieLinkBDProvider$$ExternalSyntheticLambda8
                                public final Object invoke(Object obj) {
                                    return MovieLinkBDProvider.parseMovieCards$lambda$0$4(poster, (MovieSearchResponse) obj);
                                }
                            }, 8, (Object) null));
                        }
                    }
                }
                cards = cards;
                $this$forEach$iv = $this$forEach$iv;
                str8 = str3;
                str9 = str9;
            }
            return results;
        }
        String movieLinkPattern = "a[href*='/movie/'], a[href*='/series/'], a[href*='/anime/'], a[href*='/download18plus/']";
        Set seen = new LinkedHashSet();
        Iterable<Element> $this$forEach$iv2 = doc.select("a[href*='/movie/'], a[href*='/series/'], a[href*='/anime/'], a[href*='/download18plus/']");
        int $i$f$forEach = 0;
        for (Element a : $this$forEach$iv2) {
            String strAttr4 = a.attr("abs:href");
            if (strAttr4.length() == 0) {
                strAttr4 = str4 + a.attr("href");
            }
            String href2 = strAttr4;
            if (seen.add(href2)) {
                Element img2 = a.selectFirst(str7);
                if (img2 == null) {
                    str = str6;
                    str2 = str7;
                } else {
                    String strAttr5 = img2.attr(str6);
                    if (strAttr5.length() == 0) {
                        strAttr5 = img2.attr(str10);
                    }
                    str = str6;
                    final String poster2 = strAttr5;
                    str2 = str7;
                    Element elementParent = a.parent();
                    Element titleEl = elementParent != null ? elementParent.selectFirst(".title, .movie-title, h3, h2, [class*='name']") : null;
                    if (titleEl == null || (strText = titleEl.text()) == null || (it = StringsKt.trim(strText).toString()) == null) {
                        it = StringsKt.trim(a.attr(str5)).toString();
                        if (it.length() > 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (!z3) {
                            it = null;
                        }
                        if (it == null) {
                            it = StringsKt.trim(a.text()).toString();
                            if (it.length() > 0) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            if (!z4) {
                                it = null;
                            }
                            if (it == null) {
                                String title4 = it;
                                if (!StringsKt.contains$default(href2, "/series/", false, 2, (Object) null) || StringsKt.contains$default(href2, "/anime/", false, 2, (Object) null)) {
                                    tvType = TvType.TvSeries;
                                } else {
                                    tvType = TvType.Movie;
                                }
                                TvType type4 = tvType;
                                results.add(MainAPIKt.newMovieSearchResponse$default(this, title4, href2, type4, false, new Function1() { // from class: com.cncverse.MovieLinkBDProvider$$ExternalSyntheticLambda9
                                    public final Object invoke(Object obj) {
                                        return MovieLinkBDProvider.parseMovieCards$lambda$1$5(poster2, (MovieSearchResponse) obj);
                                    }
                                }, 8, (Object) null));
                            }
                        } else {
                            String title5 = it;
                            if (StringsKt.contains$default(href2, "/series/", false, 2, (Object) null)) {
                                tvType = TvType.TvSeries;
                            } else {
                                tvType = TvType.TvSeries;
                            }
                            TvType type5 = tvType;
                            results.add(MainAPIKt.newMovieSearchResponse$default(this, title5, href2, type5, false, new Function1() { // from class: com.cncverse.MovieLinkBDProvider$$ExternalSyntheticLambda9
                                public final Object invoke(Object obj) {
                                    return MovieLinkBDProvider.parseMovieCards$lambda$1$5(poster2, (MovieSearchResponse) obj);
                                }
                            }, 8, (Object) null));
                        }
                    } else {
                        if (!(it.length() > 0)) {
                            it = null;
                        }
                        if (it == null) {
                            it = StringsKt.trim(a.attr(str5)).toString();
                            if (it.length() > 0) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (!z3) {
                                it = null;
                            }
                            if (it == null) {
                                it = StringsKt.trim(a.text()).toString();
                                if (it.length() > 0) {
                                    z4 = true;
                                } else {
                                    z4 = false;
                                }
                                if (!z4) {
                                    it = null;
                                }
                                if (it == null) {
                                    String title6 = it;
                                    if (StringsKt.contains$default(href2, "/series/", false, 2, (Object) null)) {
                                        tvType = TvType.TvSeries;
                                    } else {
                                        tvType = TvType.TvSeries;
                                    }
                                    TvType type6 = tvType;
                                    results.add(MainAPIKt.newMovieSearchResponse$default(this, title6, href2, type6, false, new Function1() { // from class: com.cncverse.MovieLinkBDProvider$$ExternalSyntheticLambda9
                                        public final Object invoke(Object obj) {
                                            return MovieLinkBDProvider.parseMovieCards$lambda$1$5(poster2, (MovieSearchResponse) obj);
                                        }
                                    }, 8, (Object) null));
                                }
                            } else {
                                String title7 = it;
                                if (StringsKt.contains$default(href2, "/series/", false, 2, (Object) null)) {
                                    tvType = TvType.TvSeries;
                                } else {
                                    tvType = TvType.TvSeries;
                                }
                                TvType type7 = tvType;
                                results.add(MainAPIKt.newMovieSearchResponse$default(this, title7, href2, type7, false, new Function1() { // from class: com.cncverse.MovieLinkBDProvider$$ExternalSyntheticLambda9
                                    public final Object invoke(Object obj) {
                                        return MovieLinkBDProvider.parseMovieCards$lambda$1$5(poster2, (MovieSearchResponse) obj);
                                    }
                                }, 8, (Object) null));
                            }
                        } else {
                            String title8 = it;
                            if (StringsKt.contains$default(href2, "/series/", false, 2, (Object) null)) {
                                tvType = TvType.TvSeries;
                            } else {
                                tvType = TvType.TvSeries;
                            }
                            TvType type8 = tvType;
                            results.add(MainAPIKt.newMovieSearchResponse$default(this, title8, href2, type8, false, new Function1() { // from class: com.cncverse.MovieLinkBDProvider$$ExternalSyntheticLambda9
                                public final Object invoke(Object obj) {
                                    return MovieLinkBDProvider.parseMovieCards$lambda$1$5(poster2, (MovieSearchResponse) obj);
                                }
                            }, 8, (Object) null));
                        }
                    }
                }
            } else {
                str = str6;
                str2 = str7;
            }
            str7 = str2;
            $this$forEach$iv2 = $this$forEach$iv2;
            $i$f$forEach = $i$f$forEach;
            str6 = str;
            str5 = str5;
            str10 = str10;
        }
        if (results.isEmpty()) {
            for (Element a2 : doc.select("a[href*='/movie/'], a[href*='/series/'], a[href*='/anime/'], a[href*='/download18plus/']")) {
                String strAttr6 = a2.attr("abs:href");
                if (strAttr6.length() == 0) {
                    strAttr6 = str4 + a2.attr("href");
                }
                String href3 = strAttr6;
                if (seen.add(href3)) {
                    String it3 = StringsKt.trim(a2.text()).toString();
                    String title9 = it3.length() > 0 ? it3 : null;
                    if (title9 != null && title9.length() >= 4) {
                        CharSequence $this$all$iv = title9;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= $this$all$iv.length()) {
                                z = true;
                                break;
                            }
                            char element$iv = $this$all$iv.charAt(i2);
                            if (Character.isUpperCase(element$iv)) {
                                i = i2;
                            } else {
                                i = i2;
                                if (element$iv != ' ') {
                                    z2 = false;
                                }
                                if (!z2) {
                                    z = false;
                                    break;
                                }
                                i2 = i + 1;
                            }
                            z2 = true;
                            if (!z2) {
                                z = false;
                                break;
                            }
                            i2 = i + 1;
                        }
                        if (!z) {
                            TvType type9 = (StringsKt.contains$default(href3, "/series/", false, 2, (Object) null) || StringsKt.contains$default(href3, "/anime/", false, 2, (Object) null)) ? TvType.TvSeries : TvType.Movie;
                            results.add(MainAPIKt.newMovieSearchResponse$default(this, title9, href3, type9, false, (Function1) null, 24, (Object) null));
                        }
                    }
                }
                str4 = base;
                movieLinkPattern = movieLinkPattern;
            }
        }
        return results;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit parseMovieCards$lambda$0$4(String $poster, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($poster);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit parseMovieCards$lambda$1$5(String $poster, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($poster.length() > 0 ? $poster : null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openInExternalBrowser(final String url) {
        final Context ctx;
        if (Globals.INSTANCE.isLayout(2) || (ctx = appContext) == null) {
            return;
        }
        long now = System.currentTimeMillis();
        if (now - lastBrowserOpenMs < BROWSER_DEBOUNCE_MS) {
            return;
        }
        lastBrowserOpenMs = now;
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.MovieLinkBDProvider$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                MovieLinkBDProvider.openInExternalBrowser$lambda$0(ctx, url);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openInExternalBrowser$lambda$0(Context $ctx, String $url) {
        try {
            Intent $this$openInExternalBrowser_u24lambda_u240_u240 = new Intent("android.intent.action.VIEW", Uri.parse($url));
            $this$openInExternalBrowser_u24lambda_u240_u240.addFlags(268435456);
            $ctx.startActivity($this$openInExternalBrowser_u24lambda_u240_u240);
        } catch (Exception e) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:104:0x035c  */
    /* JADX WARN: Code duplicated, block: B:107:0x0366  */
    /* JADX WARN: Code duplicated, block: B:108:0x0368  */
    /* JADX WARN: Code duplicated, block: B:110:0x036b A[Catch: Exception -> 0x0494, TryCatch #3 {Exception -> 0x0494, blocks: (B:97:0x0346, B:105:0x035d, B:110:0x036b, B:112:0x0378), top: B:537:0x0346 }] */
    /* JADX WARN: Code duplicated, block: B:158:0x048d A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:164:0x04b5  */
    /* JADX WARN: Code duplicated, block: B:166:0x04c7  */
    /* JADX WARN: Code duplicated, block: B:171:0x04f1  */
    /* JADX WARN: Code duplicated, block: B:173:0x0503  */
    /* JADX WARN: Code duplicated, block: B:178:0x052d  */
    /* JADX WARN: Code duplicated, block: B:180:0x053f  */
    /* JADX WARN: Code duplicated, block: B:184:0x0568  */
    /* JADX WARN: Code duplicated, block: B:187:0x057b  */
    /* JADX WARN: Code duplicated, block: B:189:0x0593  */
    /* JADX WARN: Code duplicated, block: B:190:0x0596  */
    /* JADX WARN: Code duplicated, block: B:192:0x059a  */
    /* JADX WARN: Code duplicated, block: B:193:0x05c5  */
    /* JADX WARN: Code duplicated, block: B:196:0x05d5  */
    /* JADX WARN: Code duplicated, block: B:197:0x05d7  */
    /* JADX WARN: Code duplicated, block: B:204:0x0620 A[LOOP:6: B:202:0x061a->B:204:0x0620, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:208:0x067b A[LOOP:7: B:206:0x0675->B:208:0x067b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:212:0x06be  */
    /* JADX WARN: Code duplicated, block: B:214:0x06da  */
    /* JADX WARN: Code duplicated, block: B:215:0x06dc  */
    /* JADX WARN: Code duplicated, block: B:21:0x0161 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:220:0x06ee  */
    /* JADX WARN: Code duplicated, block: B:221:0x06f0  */
    /* JADX WARN: Code duplicated, block: B:224:0x0717  */
    /* JADX WARN: Code duplicated, block: B:225:0x0719  */
    /* JADX WARN: Code duplicated, block: B:227:0x071c  */
    /* JADX WARN: Code duplicated, block: B:22:0x0162  */
    /* JADX WARN: Code duplicated, block: B:230:0x072d  */
    /* JADX WARN: Code duplicated, block: B:231:0x0730  */
    /* JADX WARN: Code duplicated, block: B:233:0x0734  */
    /* JADX WARN: Code duplicated, block: B:234:0x073e  */
    /* JADX WARN: Code duplicated, block: B:238:0x0823 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:239:0x0824  */
    /* JADX WARN: Code duplicated, block: B:241:0x083c  */
    /* JADX WARN: Code duplicated, block: B:243:0x0856  */
    /* JADX WARN: Code duplicated, block: B:246:0x0870  */
    /* JADX WARN: Code duplicated, block: B:248:0x0897  */
    /* JADX WARN: Code duplicated, block: B:249:0x08ab  */
    /* JADX WARN: Code duplicated, block: B:254:0x08d8  */
    /* JADX WARN: Code duplicated, block: B:256:0x0903  */
    /* JADX WARN: Code duplicated, block: B:25:0x0170  */
    /* JADX WARN: Code duplicated, block: B:261:0x0914  */
    /* JADX WARN: Code duplicated, block: B:264:0x091d  */
    /* JADX WARN: Code duplicated, block: B:266:0x0923  */
    /* JADX WARN: Code duplicated, block: B:270:0x0947  */
    /* JADX WARN: Code duplicated, block: B:272:0x095f  */
    /* JADX WARN: Code duplicated, block: B:273:0x0962  */
    /* JADX WARN: Code duplicated, block: B:275:0x0966  */
    /* JADX WARN: Code duplicated, block: B:276:0x0991  */
    /* JADX WARN: Code duplicated, block: B:279:0x09a1  */
    /* JADX WARN: Code duplicated, block: B:280:0x09a3  */
    /* JADX WARN: Code duplicated, block: B:286:0x0a0e  */
    /* JADX WARN: Code duplicated, block: B:289:0x0a1c  */
    /* JADX WARN: Code duplicated, block: B:291:0x0a2b  */
    /* JADX WARN: Code duplicated, block: B:294:0x0a39  */
    /* JADX WARN: Code duplicated, block: B:296:0x0a52  */
    /* JADX WARN: Code duplicated, block: B:297:0x0a55  */
    /* JADX WARN: Code duplicated, block: B:299:0x0a59  */
    /* JADX WARN: Code duplicated, block: B:29:0x0182  */
    /* JADX WARN: Code duplicated, block: B:306:0x0a8a  */
    /* JADX WARN: Code duplicated, block: B:311:0x0a9b  */
    /* JADX WARN: Code duplicated, block: B:315:0x0ab7  */
    /* JADX WARN: Code duplicated, block: B:317:0x0ac9  */
    /* JADX WARN: Code duplicated, block: B:321:0x0adf  */
    /* JADX WARN: Code duplicated, block: B:324:0x0afc  */
    /* JADX WARN: Code duplicated, block: B:326:0x0b41  */
    /* JADX WARN: Code duplicated, block: B:32:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:331:0x0b7f  */
    /* JADX WARN: Code duplicated, block: B:333:0x0b90 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:334:0x0b93  */
    /* JADX WARN: Code duplicated, block: B:341:0x0ba9  */
    /* JADX WARN: Code duplicated, block: B:343:0x0bad A[PHI: r50
      0x0bad: PHI (r50v18 java.lang.Object) = (r50v15 java.lang.Object), (r50v16 java.lang.Object), (r50v19 java.lang.Object) binds: [B:342:0x0bab, B:340:0x0ba7, B:333:0x0b90] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:346:0x0bb1 A[LOOP:15: B:329:0x0b79->B:346:0x0bb1, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:350:0x0bbc  */
    /* JADX WARN: Code duplicated, block: B:352:0x0bc4  */
    /* JADX WARN: Code duplicated, block: B:356:0x0bcd  */
    /* JADX WARN: Code duplicated, block: B:358:0x0bd0  */
    /* JADX WARN: Code duplicated, block: B:359:0x0bef  */
    /* JADX WARN: Code duplicated, block: B:361:0x0bf9  */
    /* JADX WARN: Code duplicated, block: B:363:0x0c11  */
    /* JADX WARN: Code duplicated, block: B:366:0x0c2d  */
    /* JADX WARN: Code duplicated, block: B:367:0x0c32  */
    /* JADX WARN: Code duplicated, block: B:370:0x0c3c  */
    /* JADX WARN: Code duplicated, block: B:372:0x0c4b  */
    /* JADX WARN: Code duplicated, block: B:375:0x0c59  */
    /* JADX WARN: Code duplicated, block: B:377:0x0c86  */
    /* JADX WARN: Code duplicated, block: B:37:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:384:0x0ca0  */
    /* JADX WARN: Code duplicated, block: B:386:0x0ca3  */
    /* JADX WARN: Code duplicated, block: B:393:0x0cbd  */
    /* JADX WARN: Code duplicated, block: B:396:0x0ccb  */
    /* JADX WARN: Code duplicated, block: B:398:0x0ce6  */
    /* JADX WARN: Code duplicated, block: B:400:0x0cf9  */
    /* JADX WARN: Code duplicated, block: B:402:0x0d12  */
    /* JADX WARN: Code duplicated, block: B:404:0x0d22  */
    /* JADX WARN: Code duplicated, block: B:407:0x0d2c  */
    /* JADX WARN: Code duplicated, block: B:40:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:411:0x0d4c  */
    /* JADX WARN: Code duplicated, block: B:413:0x0d5e  */
    /* JADX WARN: Code duplicated, block: B:418:0x0d7d A[LOOP:19: B:416:0x0d77->B:418:0x0d7d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:424:0x0df9  */
    /* JADX WARN: Code duplicated, block: B:426:0x0e17 A[LOOP:20: B:426:0x0e17->B:459:0x0e93, LOOP_START, PHI: r3
      0x0e17: PHI (r3v36 'epNum' int) = (r3v35 'epNum' int), (r3v37 'epNum' int) binds: [B:425:0x0e15, B:459:0x0e93] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:429:0x0e25  */
    /* JADX WARN: Code duplicated, block: B:431:0x0e33 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:432:0x0e36  */
    /* JADX WARN: Code duplicated, block: B:439:0x0e4c  */
    /* JADX WARN: Code duplicated, block: B:441:0x0e50 A[PHI: r54
      0x0e50: PHI (r54v5 java.util.Iterator) = (r54v2 java.util.Iterator), (r54v3 java.util.Iterator), (r54v6 java.util.Iterator) binds: [B:440:0x0e4e, B:438:0x0e4a, B:431:0x0e33] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:444:0x0e54 A[LOOP:21: B:427:0x0e1f->B:444:0x0e54, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:448:0x0e5d  */
    /* JADX WARN: Code duplicated, block: B:450:0x0e65  */
    /* JADX WARN: Code duplicated, block: B:454:0x0e6e  */
    /* JADX WARN: Code duplicated, block: B:456:0x0e71  */
    /* JADX WARN: Code duplicated, block: B:457:0x0e8e  */
    /* JADX WARN: Code duplicated, block: B:459:0x0e93 A[LOOP:20: B:426:0x0e17->B:459:0x0e93, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:462:0x0eb6  */
    /* JADX WARN: Code duplicated, block: B:463:0x0ebf  */
    /* JADX WARN: Code duplicated, block: B:466:0x0ecb  */
    /* JADX WARN: Code duplicated, block: B:522:0x110a  */
    /* JADX WARN: Code duplicated, block: B:525:0x1115  */
    /* JADX WARN: Code duplicated, block: B:528:0x11ba A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:529:0x11bb  */
    /* JADX WARN: Code duplicated, block: B:535:0x034e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:547:0x04ca A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:550:0x0506 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:553:0x0542 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:554:0x0608 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:556:0x05da A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:563:0x06e1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:564:0x06df A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x0200  */
    /* JADX WARN: Code duplicated, block: B:573:0x09d2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:574:0x09a6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:584:0x0acc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:587:0x0b45 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:588:0x0bb4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:589:0x0bb6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:591:0x0e96 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:592:0x0e96 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:594:0x0de2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:595:0x0dd9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:598:0x0d61 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:0x020d  */
    /* JADX WARN: Code duplicated, block: B:600:0x0e57 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:601:0x0e58 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:64:0x0221  */
    /* JADX WARN: Code duplicated, block: B:67:0x0245  */
    /* JADX WARN: Code duplicated, block: B:76:0x0275 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    /* JADX WARN: Code duplicated, block: B:80:0x0282  */
    /* JADX WARN: Code duplicated, block: B:81:0x02a5  */
    /* JADX WARN: Code duplicated, block: B:83:0x02a9  */
    /* JADX WARN: Code duplicated, block: B:84:0x02cb  */
    /* JADX WARN: Code duplicated, block: B:86:0x02cf  */
    /* JADX WARN: Code duplicated, block: B:88:0x02f0  */
    /* JADX WARN: Code duplicated, block: B:91:0x032b  */
    /* JADX WARN: Code duplicated, block: B:95:0x033b  */
    /* JADX WARN: Instruction removed from duplicated block: B:343:0x0bad, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:441:0x0e50, please report this as an issue */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) {
        C00041 c00041;
        String url2;
        Object base;
        String base2;
        Object objHttpGetDoc;
        String base3;
        String base4;
        Document doc;
        Element elementSelectFirst;
        String string;
        String rawTitle;
        MatchResult matchResultFind$default;
        Integer intOrNull;
        Integer year;
        Element posterElement;
        String poster;
        Element elementSelectFirst2;
        String strLoad$metaVal;
        String plot;
        String genre;
        String cast;
        String language;
        Element elementSelectFirst3;
        Float floatOrNull;
        StringBuilder $this$load_u24lambda_u244;
        String fullPlot;
        int i;
        int i2;
        List<StreamSource> jsonSources;
        String fullPlot2;
        Iterable $this$filterNot$iv;
        Collection destination$iv$iv;
        List fileAnchors;
        Collection destination$iv$iv2;
        List fileAnchors2;
        Object element$iv$iv;
        Collection destination$iv$iv3;
        Object linkAnchors;
        List watchAnchors;
        Iterable iterableSelect;
        String str;
        String epLinks;
        String str2;
        String str3;
        List episodesData;
        String str4;
        int i3;
        C00041 c00042;
        Object obj;
        boolean isSeries;
        String str5;
        String str6;
        String str7;
        List episodesData2;
        Document doc2;
        List episodesData3;
        List $this$sortBy$iv;
        Object objNewTvSeriesLoadResponse;
        Object obj2;
        String absHref;
        Element a;
        Iterable $this$mapNotNullTo$iv$iv;
        int $i$f$mapNotNullTo;
        Elements episodeSections;
        Iterable $this$forEach$iv;
        int $i$f$forEach;
        Iterator it;
        Element section;
        MatchResult epRange;
        int start;
        int end;
        List sectionLinks;
        Element sib;
        int start2;
        String epUrl;
        int epNum;
        Iterator it2;
        Object next;
        Episode existingEp;
        String data;
        boolean z;
        Integer episode;
        Iterator it3;
        Integer season;
        boolean z2;
        MatchResult epRange2;
        Element section2;
        List anchors;
        String str8;
        List episodesData4;
        Document doc3;
        Iterable $this$filterNot$iv2;
        Collection destination$iv$iv4;
        List $this$forEach$iv2;
        List groupValues;
        String str9;
        Integer intOrNull2;
        List groupValues2;
        String str10;
        Integer intOrNull3;
        Elements epCards;
        Iterable $this$forEach$iv3;
        int $i$f$forEach2;
        Iterator it4;
        String strAttr;
        boolean z3;
        MatchResult matchResultFind$default2;
        final int epNum2;
        Iterable $this$filterNot$iv3;
        Collection destination$iv$iv5;
        Object it$iv$iv;
        String str11;
        Iterable $this$mapNotNull$iv;
        int $i$f$mapNotNull;
        Collection destination$iv$iv6;
        String epUrl2;
        Iterator it5;
        Object obj3;
        Episode existingEp2;
        String data2;
        boolean z4;
        Object next2;
        Integer episode2;
        Iterator it6;
        Integer season2;
        boolean z5;
        String str12;
        String value;
        Integer intOrNull4;
        Element elementSelectFirst4;
        List $this$groupBy$iv;
        int $i$f$groupBy;
        Map grouped;
        Iterator it7;
        MatchResult matchResultFind$default3;
        final int epNum3;
        StreamSource streamSource;
        final String epLabel;
        List epLinksList;
        Iterator it8;
        StreamSource src;
        String ql;
        boolean z6;
        StreamSource src2;
        boolean z7;
        String value2;
        Integer intOrNull5;
        String episodeKey;
        Object value$iv$iv$iv;
        Object answer$iv$iv$iv;
        List items;
        Iterator it9;
        Iterator it10;
        Iterator it11;
        Object objNewMovieLoadResponse;
        Element a2;
        String string2;
        boolean z8;
        String h;
        String absH;
        String string3;
        boolean z9;
        String text;
        String strExtractQualityLabel;
        boolean z10;
        String ql2;
        boolean z11;
        boolean z12;
        Element elementSelectFirst5;
        String jsonScript;
        boolean z13;
        JSONObject jsonObj;
        JSONArray episodes;
        String str13;
        String str14;
        String it12;
        String value3;
        String strText;
        String strAttr2;
        List groupValues3;
        String str15;
        String strText2;
        MovieLinkBDProvider movieLinkBDProvider = this;
        String str16 = "Stream";
        String str17 = "";
        if (continuation instanceof C00041) {
            c00041 = (C00041) continuation;
            if ((c00041.label & Integer.MIN_VALUE) != 0) {
                c00041.label -= Integer.MIN_VALUE;
            } else {
                c00041 = movieLinkBDProvider.new C00041(continuation);
            }
        } else {
            c00041 = movieLinkBDProvider.new C00041(continuation);
        }
        C00041 c00043 = c00041;
        Object $result = c00043.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00043.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                url2 = url;
                c00043.L$0 = url2;
                c00043.label = 1;
                base = movieLinkBDProvider.getBase(c00043);
                if (base == coroutine_suspended) {
                    return coroutine_suspended;
                }
                base2 = (String) base;
                Map<String, String> map = movieLinkBDProvider.headers;
                c00043.L$0 = url2;
                c00043.L$1 = base2;
                c00043.label = 2;
                objHttpGetDoc = movieLinkBDProvider.httpGetDoc(url2, map, c00043);
                if (objHttpGetDoc == coroutine_suspended) {
                    return coroutine_suspended;
                }
                base3 = base2;
                base4 = url2;
                doc = (Document) objHttpGetDoc;
                elementSelectFirst = doc.selectFirst(".movie-info-view h2, h1, .movie-title, .film-title");
                if (elementSelectFirst != null || (strText2 = elementSelectFirst.text()) == null || (string = StringsKt.trim(strText2).toString()) == null) {
                    string = StringsKt.trim(StringsKt.substringBefore$default(doc.title(), "•", (String) null, 2, (Object) null)).toString();
                }
                rawTitle = string;
                matchResultFind$default = Regex.find$default(new Regex("\\((\\d{4})\\)"), rawTitle, 0, 2, (Object) null);
                if (matchResultFind$default != null || (groupValues3 = matchResultFind$default.getGroupValues()) == null || (str15 = (String) groupValues3.get(1)) == null) {
                    intOrNull = null;
                } else {
                    intOrNull = StringsKt.toIntOrNull(str15);
                }
                year = intOrNull;
                posterElement = doc.selectFirst("img.poster, img[class*='poster'], .poster img, .thumb img, img[src*='poster'], img[src*='uploads']");
                if (posterElement != null || (strAttr2 = posterElement.attr("data-src")) == null) {
                    poster = null;
                } else {
                    String strAttr3 = strAttr2;
                    if (strAttr3.length() == 0) {
                        strAttr3 = posterElement.attr("src");
                    }
                    String it13 = strAttr3;
                    if (it13 == null) {
                        poster = null;
                    } else if (it13.length() > 0) {
                        poster = it13;
                    } else {
                        poster = null;
                    }
                }
                elementSelectFirst2 = doc.selectFirst(".storyline p, .storyline, [class*='story'] p, [class*='plot']");
                if (elementSelectFirst2 != null || (strText = elementSelectFirst2.text()) == null || (strLoad$metaVal = StringsKt.trim(strText).toString()) == null) {
                    strLoad$metaVal = load$metaVal(doc, "Storyline");
                }
                plot = strLoad$metaVal;
                genre = load$metaVal(doc, "Genre");
                cast = load$metaVal(doc, "Cast");
                language = load$metaVal(doc, "Language");
                elementSelectFirst3 = doc.selectFirst("[class*='imdb'], [class*='rating']");
                if (elementSelectFirst3 != null || (it12 = elementSelectFirst3.text()) == null) {
                    floatOrNull = null;
                } else {
                    str16 = "Stream";
                    MatchResult matchResultFind$default4 = Regex.find$default(new Regex("[0-9.]+"), it12, 0, 2, (Object) null);
                    floatOrNull = (matchResultFind$default4 == null || (value3 = matchResultFind$default4.getValue()) == null) ? null : StringsKt.toFloatOrNull(value3);
                }
                $this$load_u24lambda_u244 = new StringBuilder();
                if (language != null) {
                    $this$load_u24lambda_u244.append("Language: " + language + '\n');
                }
                if (genre != null) {
                    $this$load_u24lambda_u244.append("Genre: " + genre + '\n');
                }
                if (cast != null) {
                    $this$load_u24lambda_u244.append("Cast: " + cast + '\n');
                }
                if (plot != null) {
                    $this$load_u24lambda_u244.append('\n' + plot);
                    Unit unit = Unit.INSTANCE;
                }
                fullPlot = StringsKt.trim($this$load_u24lambda_u244.toString()).toString();
                if (!StringsKt.contains$default(base4, "/series/", false, 2, (Object) null) || StringsKt.contains$default(base4, "/anime/", false, 2, (Object) null)) {
                    i = 1;
                } else {
                    i = 0;
                }
                i2 = i;
                jsonSources = new ArrayList();
                try {
                    elementSelectFirst5 = doc.selectFirst("script#mlbdInlinePlayerData");
                    if (elementSelectFirst5 != null) {
                        try {
                            jsonScript = elementSelectFirst5.data();
                            if (jsonScript == null) {
                                jsonScript = "";
                            }
                            if (jsonScript.length() > 0) {
                                z13 = true;
                            } else {
                                z13 = false;
                            }
                            if (z13 || (episodes = (jsonObj = new JSONObject(jsonScript)).optJSONArray("episodes")) == null) {
                                fullPlot2 = fullPlot;
                                str17 = "";
                            } else {
                                int length = episodes.length();
                                fullPlot2 = fullPlot;
                                int i4 = 0;
                                while (i4 < length) {
                                    try {
                                        JSONObject ep = episodes.getJSONObject(i4);
                                        int i5 = length;
                                        int i6 = i4;
                                        JSONObject jsonObj2 = jsonObj;
                                        String epKey = ep.optString("id", "movie");
                                        String epLabel2 = ep.optString("label", "Movie");
                                        JSONArray sources = ep.optJSONArray("sources");
                                        if (sources != null) {
                                            int length2 = sources.length();
                                            int j = 0;
                                            while (j < length2) {
                                                JSONObject src3 = sources.getJSONObject(j);
                                                JSONArray sources2 = sources;
                                                int i7 = length2;
                                                String streamUrl = src3.optString("url", str17);
                                                String downloadUrl = src3.optString("download_url", str17);
                                                int j2 = j;
                                                int q = src3.optInt("quality", 0);
                                                String qlRaw = StringsKt.trim(src3.optString("quality_label", str17)).toString();
                                                String str18 = qlRaw;
                                                if (str18.length() == 0) {
                                                    if (q >= 2160) {
                                                        str14 = "4K";
                                                    } else if (q >= 1080) {
                                                        str14 = "1080p";
                                                    } else if (q >= 720) {
                                                        str14 = "720p";
                                                    } else if (q >= 480) {
                                                        str14 = "480p";
                                                    } else {
                                                        str14 = q >= 360 ? "360p" : str16;
                                                    }
                                                    str18 = str14;
                                                }
                                                try {
                                                    String ql3 = str18;
                                                    String provider = src3.optString("provider", "MLBD CDN");
                                                    if (streamUrl.length() > 0) {
                                                        jsonSources.add(new StreamSource(q, ql3, streamUrl, downloadUrl, provider, epKey, epLabel2));
                                                    }
                                                    j = j2 + 1;
                                                    sources = sources2;
                                                    length2 = i7;
                                                    str17 = str17;
                                                } catch (Exception e) {
                                                }
                                            }
                                            str13 = str17;
                                        } else {
                                            str13 = str17;
                                        }
                                        i4 = i6 + 1;
                                        length = i5;
                                        jsonObj = jsonObj2;
                                        str17 = str13;
                                    } catch (Exception e2) {
                                        str17 = str17;
                                    }
                                }
                                str17 = str17;
                            }
                        } catch (Exception e3) {
                            fullPlot2 = fullPlot;
                            str17 = "";
                        }
                    } else {
                        jsonScript = "";
                        if (jsonScript.length() > 0) {
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                        if (z13) {
                            fullPlot2 = fullPlot;
                            str17 = "";
                        } else {
                            fullPlot2 = fullPlot;
                            str17 = "";
                        }
                    }
                } catch (Exception e4) {
                    fullPlot2 = fullPlot;
                    str17 = "";
                }
                $this$filterNot$iv = doc.select("a[href*='/file/']");
                destination$iv$iv = new ArrayList();
                for (Object element$iv$iv2 : $this$filterNot$iv) {
                    Iterable $this$filterNot$iv4 = $this$filterNot$iv;
                    if (!load$isComingSoon((Element) element$iv$iv2)) {
                        destination$iv$iv.add(element$iv$iv2);
                    }
                    $this$filterNot$iv = $this$filterNot$iv4;
                }
                fileAnchors = (List) destination$iv$iv;
                Iterable $this$filterNot$iv5 = doc.select("a[href*='/getLink/']");
                destination$iv$iv2 = new ArrayList();
                for (Object element$iv$iv3 : $this$filterNot$iv5) {
                    List fileAnchors3 = fileAnchors;
                    if (!load$isComingSoon((Element) element$iv$iv3)) {
                        destination$iv$iv2.add(element$iv$iv3);
                    }
                    fileAnchors = fileAnchors3;
                }
                fileAnchors2 = fileAnchors;
                element$iv$iv = (List) destination$iv$iv2;
                Iterable $this$filterNot$iv6 = doc.select("a[href*='/getWatch/']");
                destination$iv$iv3 = new ArrayList();
                for (Object element$iv$iv4 : $this$filterNot$iv6) {
                    Object linkAnchors2 = element$iv$iv;
                    if (!load$isComingSoon((Element) element$iv$iv4)) {
                        destination$iv$iv3.add(element$iv$iv4);
                    }
                    element$iv$iv = linkAnchors2;
                }
                linkAnchors = element$iv$iv;
                watchAnchors = (List) destination$iv$iv3;
                iterableSelect = doc.select(".mlbd-live-server-btn[href], a.mlbd-live-server-btn[href]");
                str = "|ext:";
                epLinks = "|cdn:";
                String str19 = "http";
                String str20 = "href";
                str2 = " ; ";
                if (i2 == 0) {
                    items = new ArrayList();
                    for (StreamSource src4 : jsonSources) {
                        posterElement = posterElement;
                        ql2 = src4.getQualityLabel();
                        if (src4.getStreamUrl().length() > 0) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (z11) {
                            items.add(ql2 + "|cdn:" + src4.getStreamUrl() + '|' + base4);
                        }
                        if (src4.getDownloadUrl().length() > 0) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        if (z12) {
                            items.add(ql2 + " [DL]|cdn:" + src4.getDownloadUrl() + '|' + base4);
                        }
                    }
                    String str21 = str2;
                    Element posterElement2 = posterElement;
                    for (it9 = fileAnchors2.iterator(); it9.hasNext(); it9 = it9) {
                        Element a3 = (Element) it9.next();
                        String href = load$absHref(base3, movieLinkBDProvider, a3);
                        String quality = movieLinkBDProvider.extractQualityLabel(StringsKt.trim(a3.text()).toString());
                        items.add(quality + '|' + href + '|' + base4);
                    }
                    for (it10 = CollectionsKt.plus((Collection) linkAnchors, watchAnchors).iterator(); it10.hasNext(); it10 = it10) {
                        Element a4 = (Element) it10.next();
                        String href2 = load$absHref(base3, movieLinkBDProvider, a4);
                        String quality2 = movieLinkBDProvider.extractQualityLabel(a4.text());
                        items.add(quality2 + '|' + href2 + '|' + base4);
                    }
                    it11 = iterableSelect.iterator();
                    while (it11.hasNext()) {
                        a2 = (Element) it11.next();
                        string2 = StringsKt.trim(a2.attr("href")).toString();
                        if (string2.length() == 0) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        if (!z8) {
                            h = string2;
                            Iterator it14 = it11;
                            if (StringsKt.startsWith$default(h, "http", false, 2, (Object) null)) {
                                absH = h;
                            } else {
                                absH = base3 + h;
                            }
                            string3 = StringsKt.trim(a2.text()).toString();
                            if (string3.length() == 0) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            if (z9) {
                                string3 = str16;
                            }
                            text = string3;
                            strExtractQualityLabel = movieLinkBDProvider.extractQualityLabel(text);
                            if (strExtractQualityLabel.length() == 0) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            if (z10) {
                                strExtractQualityLabel = StringsKt.take(text, 30);
                            }
                            String quality3 = strExtractQualityLabel;
                            items.add(quality3 + "|ext:" + absH + '|' + base4);
                            it11 = it14;
                        }
                    }
                    String linksData = CollectionsKt.joinToString$default(items, str21, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
                    TvType tvType = TvType.Movie;
                    Float rating = floatOrNull;
                    C00053 c00053 = new C00053(poster, year, fullPlot2, rating, null);
                    c00043.L$0 = SpillingKt.nullOutSpilledVariable(base4);
                    c00043.L$1 = SpillingKt.nullOutSpilledVariable(base3);
                    c00043.L$2 = SpillingKt.nullOutSpilledVariable(doc);
                    c00043.L$3 = SpillingKt.nullOutSpilledVariable(rawTitle);
                    c00043.L$4 = SpillingKt.nullOutSpilledVariable(year);
                    c00043.L$5 = SpillingKt.nullOutSpilledVariable(posterElement2);
                    c00043.L$6 = SpillingKt.nullOutSpilledVariable(poster);
                    c00043.L$7 = SpillingKt.nullOutSpilledVariable(plot);
                    c00043.L$8 = SpillingKt.nullOutSpilledVariable(genre);
                    c00043.L$9 = SpillingKt.nullOutSpilledVariable(cast);
                    c00043.L$10 = SpillingKt.nullOutSpilledVariable(language);
                    c00043.L$11 = SpillingKt.nullOutSpilledVariable(rating);
                    c00043.L$12 = SpillingKt.nullOutSpilledVariable(fullPlot2);
                    c00043.L$13 = SpillingKt.nullOutSpilledVariable(jsonSources);
                    c00043.L$14 = SpillingKt.nullOutSpilledVariable(fileAnchors2);
                    c00043.L$15 = SpillingKt.nullOutSpilledVariable(linkAnchors);
                    c00043.L$16 = SpillingKt.nullOutSpilledVariable(watchAnchors);
                    c00043.L$17 = SpillingKt.nullOutSpilledVariable(iterableSelect);
                    c00043.L$18 = SpillingKt.nullOutSpilledVariable(items);
                    c00043.L$19 = SpillingKt.nullOutSpilledVariable(linksData);
                    c00043.I$0 = i2;
                    c00043.label = 3;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(movieLinkBDProvider, rawTitle, base4, tvType, linksData, c00053, c00043);
                    if (objNewMovieLoadResponse == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return objNewMovieLoadResponse;
                }
                str3 = " ; ";
                episodesData = new ArrayList();
                str4 = "\\d+";
                if (jsonSources.isEmpty()) {
                    i3 = i2;
                    c00042 = c00043;
                    obj = coroutine_suspended;
                } else {
                    $this$groupBy$iv = jsonSources;
                    $i$f$groupBy = 0;
                    grouped = new LinkedHashMap();
                    for (Object element$iv$iv5 : $this$groupBy$iv) {
                        Iterable $this$groupBy$iv2 = $this$groupBy$iv;
                        episodeKey = ((StreamSource) element$iv$iv5).getEpisodeKey();
                        int $i$f$groupBy2 = $i$f$groupBy;
                        Object obj4 = coroutine_suspended;
                        value$iv$iv$iv = grouped.get(episodeKey);
                        if (value$iv$iv$iv == null) {
                            answer$iv$iv$iv = new ArrayList();
                            grouped.put(episodeKey, answer$iv$iv$iv);
                        } else {
                            answer$iv$iv$iv = value$iv$iv$iv;
                        }
                        List list$iv$iv = (List) answer$iv$iv$iv;
                        list$iv$iv.add(element$iv$iv5);
                        $this$groupBy$iv = $this$groupBy$iv2;
                        coroutine_suspended = obj4;
                        $i$f$groupBy = $i$f$groupBy2;
                        i2 = i2;
                    }
                    i3 = i2;
                    obj = coroutine_suspended;
                    it7 = grouped.entrySet().iterator();
                    while (it7.hasNext()) {
                        Map.Entry entry = (Map.Entry) it7.next();
                        String epKey2 = (String) entry.getKey();
                        List srcs = (List) entry.getValue();
                        Iterator it15 = it7;
                        C00041 c00044 = c00043;
                        matchResultFind$default3 = Regex.find$default(new Regex("\\d+"), epKey2, 0, 2, (Object) null);
                        if (matchResultFind$default3 != null || (value2 = matchResultFind$default3.getValue()) == null || (intOrNull5 = StringsKt.toIntOrNull(value2)) == null) {
                            epNum3 = 1;
                        } else {
                            epNum3 = intOrNull5.intValue();
                        }
                        streamSource = (StreamSource) CollectionsKt.firstOrNull(srcs);
                        if (streamSource != null || (epLabel = streamSource.getEpisodeLabel()) == null) {
                            epLabel = "Episode " + epNum3;
                        }
                        epLinksList = new ArrayList();
                        it8 = srcs.iterator();
                        while (it8.hasNext()) {
                            src = (StreamSource) it8.next();
                            it8 = it8;
                            ql = src.getQualityLabel();
                            if (src.getStreamUrl().length() > 0) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            if (z6) {
                                src2 = src;
                                epLinksList.add(ql + epLinks + src2.getStreamUrl() + '|' + base4);
                            } else {
                                src2 = src;
                            }
                            if (src2.getDownloadUrl().length() > 0) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            if (z7) {
                                epLinksList.add(ql + " [DL]|cdn:" + src2.getDownloadUrl() + '|' + base4);
                            }
                        }
                        String str22 = epLinks;
                        String epLinks2 = CollectionsKt.joinToString$default(epLinksList, str3, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
                        episodesData.add(MainAPIKt.newEpisode(movieLinkBDProvider, epLinks2, new Function1() { // from class: com.cncverse.MovieLinkBDProvider$$ExternalSyntheticLambda5
                            public final Object invoke(Object obj5) {
                                return MovieLinkBDProvider.load$lambda$13(epLabel, epNum3, (Episode) obj5);
                            }
                        }));
                        it7 = it15;
                        c00043 = c00044;
                        epLinks = str22;
                    }
                    c00042 = c00043;
                }
                isSeries = episodesData.isEmpty();
                str5 = "a[href*='/getLink/'], a[href*='/getWatch/']";
                if (isSeries) {
                    epCards = doc.select("div.ep-card, [data-ep]");
                    if (((Collection) epCards).isEmpty()) {
                        str6 = str3;
                    } else {
                        $this$forEach$iv3 = (Iterable) epCards;
                        $i$f$forEach2 = 0;
                        it4 = $this$forEach$iv3.iterator();
                        while (it4.hasNext()) {
                            Object element$iv = it4.next();
                            Element card = (Element) element$iv;
                            Elements epCards2 = epCards;
                            strAttr = card.attr("data-ep");
                            if (strAttr.length() == 0) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (z3 && ((elementSelectFirst4 = card.selectFirst("h1, h2, h3, h4, h5, h6")) == null || (strAttr = elementSelectFirst4.text()) == null)) {
                                strAttr = str17;
                            }
                            String epText = strAttr;
                            Iterable $this$forEach$iv4 = $this$forEach$iv3;
                            int $i$f$forEach3 = $i$f$forEach2;
                            String str23 = str4;
                            Iterator it16 = it4;
                            matchResultFind$default2 = Regex.find$default(new Regex(str4), epText, 0, 2, (Object) null);
                            if (matchResultFind$default2 != null || (value = matchResultFind$default2.getValue()) == null || (intOrNull4 = StringsKt.toIntOrNull(value)) == null) {
                                epNum2 = 1;
                            } else {
                                epNum2 = intOrNull4.intValue();
                            }
                            $this$filterNot$iv3 = card.select("a[href*='/getLink/'], a[href*='/getWatch/']");
                            destination$iv$iv5 = new ArrayList();
                            for (Object element$iv$iv6 : $this$filterNot$iv3) {
                                Iterable $this$filterNot$iv7 = $this$filterNot$iv3;
                                if (!load$isComingSoon((Element) element$iv$iv6)) {
                                    destination$iv$iv5.add(element$iv$iv6);
                                }
                                $this$filterNot$iv3 = $this$filterNot$iv7;
                            }
                            it$iv$iv = (List) destination$iv$iv5;
                            if (((Collection) it$iv$iv).isEmpty()) {
                                str11 = str3;
                            } else {
                                $this$mapNotNull$iv = (Iterable) it$iv$iv;
                                $i$f$mapNotNull = 0;
                                destination$iv$iv6 = new ArrayList();
                                for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                                    Object cardLinks = it$iv$iv;
                                    Element a5 = (Element) element$iv$iv$iv;
                                    Iterable $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                                    String href3 = load$absHref(base3, movieLinkBDProvider, a5);
                                    String quality4 = movieLinkBDProvider.extractQualityLabel(a5.text());
                                    int $i$f$mapNotNull2 = $i$f$mapNotNull;
                                    str12 = quality4 + '|' + href3 + '|' + base4;
                                    if (str12 != null) {
                                        destination$iv$iv6.add(str12);
                                    }
                                    it$iv$iv = cardLinks;
                                    $this$mapNotNull$iv = $this$mapNotNull$iv2;
                                    $i$f$mapNotNull = $i$f$mapNotNull2;
                                }
                                epUrl2 = CollectionsKt.joinToString$default((List) destination$iv$iv6, str3, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
                                it5 = episodesData.iterator();
                                while (true) {
                                    if (it5.hasNext()) {
                                        next2 = it5.next();
                                        Episode it17 = (Episode) next2;
                                        episode2 = it17.getEpisode();
                                        it6 = it5;
                                        if (episode2 == null && episode2.intValue() == epNum2 && (season2 = it17.getSeason()) != null) {
                                            obj3 = next2;
                                            z5 = season2.intValue() == 1;
                                            if (z5) {
                                                it5 = it6;
                                            }
                                        } else {
                                            obj3 = next2;
                                        }
                                        if (z5) {
                                            it5 = it6;
                                        }
                                    } else {
                                        obj3 = null;
                                    }
                                }
                                existingEp2 = (Episode) obj3;
                                if (existingEp2 != null) {
                                    data2 = existingEp2.getData();
                                    if (data2 != null || data2.length() == 0) {
                                        z4 = true;
                                    } else {
                                        z4 = false;
                                    }
                                    if (z4) {
                                        str11 = str3;
                                        existingEp2.setData(epUrl2);
                                    } else {
                                        str11 = str3;
                                        existingEp2.setData(existingEp2.getData() + str11 + epUrl2);
                                    }
                                    Unit unit2 = Unit.INSTANCE;
                                } else {
                                    str11 = str3;
                                    Boxing.boxBoolean(episodesData.add(MainAPIKt.newEpisode(movieLinkBDProvider, epUrl2, new Function1() { // from class: com.cncverse.MovieLinkBDProvider$$ExternalSyntheticLambda6
                                        public final Object invoke(Object obj5) {
                                            return MovieLinkBDProvider.load$lambda$14$4(epNum2, (Episode) obj5);
                                        }
                                    })));
                                }
                            }
                            str3 = str11;
                            epCards = epCards2;
                            $this$forEach$iv3 = $this$forEach$iv4;
                            $i$f$forEach2 = $i$f$forEach3;
                            str4 = str23;
                            it4 = it16;
                        }
                        str6 = str3;
                    }
                } else {
                    str6 = str3;
                }
                if (episodesData.isEmpty()) {
                    episodeSections = doc.select("div.episode-section, div.season-section, h3:contains(Episode), h4:contains(Episode), h5:contains(Episode), div[class*='episode'], div[class*='season'], strong:contains(Ep), b:contains(Ep)");
                    if (((Collection) episodeSections).isEmpty()) {
                        str7 = "|ext:";
                        episodesData2 = episodesData;
                        doc2 = doc;
                    } else {
                        $this$forEach$iv = (Iterable) episodeSections;
                        $i$f$forEach = 0;
                        it = $this$forEach$iv.iterator();
                        while (it.hasNext()) {
                            Object element$iv2 = it.next();
                            section = (Element) element$iv2;
                            String sectionText = section.text();
                            Elements episodeSections2 = episodeSections;
                            Iterable $this$forEach$iv5 = $this$forEach$iv;
                            int $i$f$forEach4 = $i$f$forEach;
                            Iterator it18 = it;
                            epRange = Regex.find$default(new Regex("(?:Ep|Episode)[^\\d]*(\\d+)(?:[^\\d]+(\\d+))?", RegexOption.IGNORE_CASE), sectionText, 0, 2, (Object) null);
                            if (epRange != null || (groupValues2 = epRange.getGroupValues()) == null || (str10 = (String) groupValues2.get(1)) == null || (intOrNull3 = StringsKt.toIntOrNull(str10)) == null) {
                                start = 1;
                            } else {
                                start = intOrNull3.intValue();
                            }
                            if (epRange != null || (groupValues = epRange.getGroupValues()) == null || (str9 = (String) groupValues.get(2)) == null || (intOrNull2 = StringsKt.toIntOrNull(str9)) == null) {
                                end = start;
                            } else {
                                end = intOrNull2.intValue();
                            }
                            sectionLinks = new ArrayList();
                            sib = section.nextElementSibling();
                            while (true) {
                                if (sib != null) {
                                    epRange2 = epRange;
                                    start2 = start;
                                    section2 = section;
                                    if (!new Regex("h[1-6]").matches(sib.tagName())) {
                                        anchors = new ArrayList();
                                        if (Intrinsics.areEqual(sib.tagName(), "a")) {
                                            str8 = str;
                                            episodesData4 = episodesData;
                                            doc3 = doc;
                                            if ((StringsKt.contains$default(sib.attr("href"), "/getLink/", false, 2, (Object) null) || StringsKt.contains$default(sib.attr("href"), "/getWatch/", false, 2, (Object) null)) && !load$isComingSoon(sib)) {
                                                anchors.add(sib);
                                            }
                                        } else {
                                            str8 = str;
                                            episodesData4 = episodesData;
                                            doc3 = doc;
                                        }
                                        $this$filterNot$iv2 = sib.select(str5);
                                        destination$iv$iv4 = new ArrayList();
                                        for (Object element$iv$iv7 : $this$filterNot$iv2) {
                                            Iterable $this$filterNot$iv8 = $this$filterNot$iv2;
                                            if (!load$isComingSoon((Element) element$iv$iv7)) {
                                                destination$iv$iv4.add(element$iv$iv7);
                                            }
                                            $this$filterNot$iv2 = $this$filterNot$iv8;
                                        }
                                        anchors.addAll((List) destination$iv$iv4);
                                        $this$forEach$iv2 = anchors;
                                        for (Object element$iv3 : $this$forEach$iv2) {
                                            Element a6 = (Element) element$iv3;
                                            sectionLinks.add(movieLinkBDProvider.extractQualityLabel(a6.text()) + '|' + load$absHref(base3, movieLinkBDProvider, a6) + '|' + base4);
                                            $this$forEach$iv2 = $this$forEach$iv2;
                                            anchors = anchors;
                                            str5 = str5;
                                        }
                                        sib = sib.nextElementSibling();
                                        start = start2;
                                        epRange = epRange2;
                                        section = section2;
                                        doc = doc3;
                                        episodesData = episodesData4;
                                        str = str8;
                                    }
                                } else {
                                    start2 = start;
                                }
                            }
                            if (!sectionLinks.isEmpty()) {
                                epUrl = CollectionsKt.joinToString$default(sectionLinks, str6, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
                                epNum = start2;
                                if (epNum <= end) {
                                    while (true) {
                                        it2 = episodesData.iterator();
                                        while (true) {
                                            if (it2.hasNext()) {
                                                next = it2.next();
                                                Episode it19 = (Episode) next;
                                                episode = it19.getEpisode();
                                                if (episode == null && episode.intValue() == epNum && (season = it19.getSeason()) != null) {
                                                    it3 = it2;
                                                    z2 = season.intValue() == 1;
                                                    if (z2) {
                                                        it2 = it3;
                                                    }
                                                } else {
                                                    it3 = it2;
                                                }
                                                if (z2) {
                                                    it2 = it3;
                                                }
                                            } else {
                                                next = null;
                                            }
                                        }
                                        existingEp = (Episode) next;
                                        if (existingEp != null) {
                                            data = existingEp.getData();
                                            if (data != null || data.length() == 0) {
                                                z = true;
                                            } else {
                                                z = false;
                                            }
                                            if (z) {
                                                existingEp.setData(epUrl);
                                            } else {
                                                existingEp.setData(existingEp.getData() + str6 + epUrl);
                                            }
                                        }
                                        if (epNum != end) {
                                            epNum++;
                                        }
                                    }
                                }
                            }
                            episodeSections = episodeSections2;
                            $this$forEach$iv = $this$forEach$iv5;
                            $i$f$forEach = $i$f$forEach4;
                            it = it18;
                            doc = doc;
                            episodesData = episodesData;
                            str = str;
                            str5 = str5;
                        }
                        str7 = str;
                        episodesData2 = episodesData;
                        doc2 = doc;
                    }
                } else {
                    str7 = "|ext:";
                    episodesData2 = episodesData;
                    doc2 = doc;
                }
                if (episodesData2.isEmpty() || ((Collection) linkAnchors).isEmpty()) {
                    episodesData3 = episodesData2;
                } else {
                    Iterable $this$filterNot$iv9 = CollectionsKt.plus((Collection) linkAnchors, watchAnchors);
                    Collection destination$iv$iv7 = new ArrayList();
                    for (Object element$iv$iv8 : $this$filterNot$iv9) {
                        if (!load$isComingSoon((Element) element$iv$iv8)) {
                            destination$iv$iv7.add(element$iv$iv8);
                        }
                    }
                    Iterable $this$mapNotNull$iv3 = (List) destination$iv$iv7;
                    int $i$f$mapNotNull3 = 0;
                    Collection destination$iv$iv8 = new ArrayList();
                    Iterable $this$mapNotNullTo$iv$iv2 = $this$mapNotNull$iv3;
                    int $i$f$mapNotNullTo2 = 0;
                    for (Object element$iv$iv$iv2 : $this$mapNotNullTo$iv$iv2) {
                        int $i$f$mapNotNull4 = $i$f$mapNotNull3;
                        Element a7 = (Element) element$iv$iv$iv2;
                        Iterable $this$mapNotNull$iv4 = $this$mapNotNull$iv3;
                        String h2 = a7.attr("abs:href");
                        if (h2.length() == 0) {
                            h2 = a7.attr("href");
                            a = a7;
                            $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv2;
                            $i$f$mapNotNullTo = $i$f$mapNotNullTo2;
                            if (!StringsKt.startsWith$default(h2, "http", false, 2, (Object) null)) {
                                h2 = base3 + h2;
                            }
                        } else {
                            a = a7;
                            $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv2;
                            $i$f$mapNotNullTo = $i$f$mapNotNullTo2;
                        }
                        String fixedHref = movieLinkBDProvider.fixUrlDomain(h2, base3);
                        String quality5 = movieLinkBDProvider.extractQualityLabel(a.text());
                        String str24 = quality5 + '|' + fixedHref + '|' + base4;
                        if (str24 != null) {
                            destination$iv$iv8.add(str24);
                        }
                        $i$f$mapNotNull3 = $i$f$mapNotNull4;
                        $this$mapNotNull$iv3 = $this$mapNotNull$iv4;
                        $this$mapNotNullTo$iv$iv2 = $this$mapNotNullTo$iv$iv;
                        $i$f$mapNotNullTo2 = $i$f$mapNotNullTo;
                    }
                    List allDownload = (List) destination$iv$iv8;
                    Iterable $this$mapNotNull$iv5 = iterableSelect;
                    int $i$f$mapNotNull5 = 0;
                    Collection destination$iv$iv9 = new ArrayList();
                    for (Object element$iv$iv$iv3 : $this$mapNotNull$iv5) {
                        List allDownload2 = allDownload;
                        Element a8 = (Element) element$iv$iv$iv3;
                        String string4 = StringsKt.trim(a8.attr(str20)).toString();
                        if (string4.length() == 0) {
                            absHref = null;
                        } else {
                            String href4 = string4;
                            String absHref2 = StringsKt.startsWith$default(href4, str19, false, 2, (Object) null) ? href4 : base3 + href4;
                            String string5 = StringsKt.trim(a8.text()).toString();
                            if (string5.length() == 0) {
                                string5 = str16;
                            }
                            String text2 = string5;
                            String strExtractQualityLabel2 = movieLinkBDProvider.extractQualityLabel(text2);
                            if (strExtractQualityLabel2.length() == 0) {
                                strExtractQualityLabel2 = StringsKt.take(text2, 30);
                            }
                            String quality6 = strExtractQualityLabel2;
                            absHref = quality6 + str7 + absHref2 + '|' + base4;
                        }
                        if (absHref != null) {
                            destination$iv$iv9.add(absHref);
                        }
                        movieLinkBDProvider = this;
                        str20 = str20;
                        $i$f$mapNotNull5 = $i$f$mapNotNull5;
                        allDownload = allDownload2;
                        $this$mapNotNull$iv5 = $this$mapNotNull$iv5;
                        str19 = str19;
                    }
                    List allLive = (List) destination$iv$iv9;
                    String allLinks = CollectionsKt.joinToString$default(CollectionsKt.plus(allDownload, allLive), str6, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
                    episodesData3 = episodesData2;
                    episodesData3.add(MainAPIKt.newEpisode(this, allLinks, new Function1() { // from class: com.cncverse.MovieLinkBDProvider$$ExternalSyntheticLambda7
                        public final Object invoke(Object obj5) {
                            return MovieLinkBDProvider.load$lambda$19((Episode) obj5);
                        }
                    }));
                }
                $this$sortBy$iv = episodesData3;
                if ($this$sortBy$iv.size() > 1) {
                    CollectionsKt.sortWith($this$sortBy$iv, new Comparator() { // from class: com.cncverse.MovieLinkBDProvider$load$$inlined$sortBy$1
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            Episode it20 = (Episode) t;
                            Episode it21 = (Episode) t2;
                            return ComparisonsKt.compareValues(it20.getEpisode(), it21.getEpisode());
                        }
                    });
                }
                TvType tvType2 = TvType.TvSeries;
                Float rating2 = floatOrNull;
                C00069 c00069 = new C00069(poster, year, fullPlot2, rating2, null);
                C00041 c00045 = c00042;
                c00045.L$0 = SpillingKt.nullOutSpilledVariable(base4);
                c00045.L$1 = SpillingKt.nullOutSpilledVariable(base3);
                c00045.L$2 = SpillingKt.nullOutSpilledVariable(doc2);
                c00045.L$3 = SpillingKt.nullOutSpilledVariable(rawTitle);
                c00045.L$4 = SpillingKt.nullOutSpilledVariable(year);
                c00045.L$5 = SpillingKt.nullOutSpilledVariable(posterElement);
                c00045.L$6 = SpillingKt.nullOutSpilledVariable(poster);
                c00045.L$7 = SpillingKt.nullOutSpilledVariable(plot);
                c00045.L$8 = SpillingKt.nullOutSpilledVariable(genre);
                c00045.L$9 = SpillingKt.nullOutSpilledVariable(cast);
                c00045.L$10 = SpillingKt.nullOutSpilledVariable(language);
                c00045.L$11 = SpillingKt.nullOutSpilledVariable(rating2);
                c00045.L$12 = SpillingKt.nullOutSpilledVariable(fullPlot2);
                c00045.L$13 = SpillingKt.nullOutSpilledVariable(jsonSources);
                c00045.L$14 = SpillingKt.nullOutSpilledVariable(fileAnchors2);
                c00045.L$15 = SpillingKt.nullOutSpilledVariable(linkAnchors);
                c00045.L$16 = SpillingKt.nullOutSpilledVariable(watchAnchors);
                c00045.L$17 = SpillingKt.nullOutSpilledVariable(iterableSelect);
                c00045.L$18 = SpillingKt.nullOutSpilledVariable(episodesData3);
                c00045.I$0 = i3;
                c00045.label = 4;
                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, rawTitle, base4, tvType2, episodesData3, c00069, c00045);
                obj2 = obj;
                if (objNewTvSeriesLoadResponse == obj2) {
                    return obj2;
                }
                return objNewTvSeriesLoadResponse;
            case 1:
                url2 = (String) c00043.L$0;
                ResultKt.throwOnFailure($result);
                base = $result;
                base2 = (String) base;
                Map<String, String> map2 = movieLinkBDProvider.headers;
                c00043.L$0 = url2;
                c00043.L$1 = base2;
                c00043.label = 2;
                objHttpGetDoc = movieLinkBDProvider.httpGetDoc(url2, map2, c00043);
                if (objHttpGetDoc == coroutine_suspended) {
                    return coroutine_suspended;
                }
                base3 = base2;
                base4 = url2;
                doc = (Document) objHttpGetDoc;
                elementSelectFirst = doc.selectFirst(".movie-info-view h2, h1, .movie-title, .film-title");
                if (elementSelectFirst != null) {
                    string = StringsKt.trim(StringsKt.substringBefore$default(doc.title(), "•", (String) null, 2, (Object) null)).toString();
                } else {
                    string = StringsKt.trim(StringsKt.substringBefore$default(doc.title(), "•", (String) null, 2, (Object) null)).toString();
                }
                rawTitle = string;
                matchResultFind$default = Regex.find$default(new Regex("\\((\\d{4})\\)"), rawTitle, 0, 2, (Object) null);
                if (matchResultFind$default != null) {
                    intOrNull = null;
                } else {
                    intOrNull = null;
                }
                year = intOrNull;
                posterElement = doc.selectFirst("img.poster, img[class*='poster'], .poster img, .thumb img, img[src*='poster'], img[src*='uploads']");
                if (posterElement != null) {
                    poster = null;
                } else {
                    poster = null;
                }
                elementSelectFirst2 = doc.selectFirst(".storyline p, .storyline, [class*='story'] p, [class*='plot']");
                if (elementSelectFirst2 != null) {
                    strLoad$metaVal = load$metaVal(doc, "Storyline");
                } else {
                    strLoad$metaVal = load$metaVal(doc, "Storyline");
                }
                plot = strLoad$metaVal;
                genre = load$metaVal(doc, "Genre");
                cast = load$metaVal(doc, "Cast");
                language = load$metaVal(doc, "Language");
                elementSelectFirst3 = doc.selectFirst("[class*='imdb'], [class*='rating']");
                if (elementSelectFirst3 != null) {
                }
                floatOrNull = null;
                $this$load_u24lambda_u244 = new StringBuilder();
                if (language != null) {
                    $this$load_u24lambda_u244.append("Language: " + language + '\n');
                }
                if (genre != null) {
                    $this$load_u24lambda_u244.append("Genre: " + genre + '\n');
                }
                if (cast != null) {
                    $this$load_u24lambda_u244.append("Cast: " + cast + '\n');
                }
                if (plot != null) {
                    $this$load_u24lambda_u244.append('\n' + plot);
                    Unit unit3 = Unit.INSTANCE;
                }
                fullPlot = StringsKt.trim($this$load_u24lambda_u244.toString()).toString();
                if (StringsKt.contains$default(base4, "/series/", false, 2, (Object) null)) {
                    i = 1;
                } else {
                    i = 1;
                }
                i2 = i;
                jsonSources = new ArrayList();
                elementSelectFirst5 = doc.selectFirst("script#mlbdInlinePlayerData");
                if (elementSelectFirst5 != null) {
                    jsonScript = elementSelectFirst5.data();
                    if (jsonScript == null) {
                        jsonScript = "";
                    }
                    if (jsonScript.length() > 0) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    if (z13) {
                        fullPlot2 = fullPlot;
                        str17 = "";
                    } else {
                        fullPlot2 = fullPlot;
                        str17 = "";
                    }
                } else {
                    jsonScript = "";
                    if (jsonScript.length() > 0) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    if (z13) {
                        fullPlot2 = fullPlot;
                        str17 = "";
                    } else {
                        fullPlot2 = fullPlot;
                        str17 = "";
                    }
                }
                $this$filterNot$iv = doc.select("a[href*='/file/']");
                destination$iv$iv = new ArrayList();
                while (r27.hasNext()) {
                    Iterable $this$filterNot$iv10 = $this$filterNot$iv;
                    if (!load$isComingSoon((Element) element$iv$iv2)) {
                        destination$iv$iv.add(element$iv$iv2);
                    }
                    $this$filterNot$iv = $this$filterNot$iv10;
                }
                fileAnchors = (List) destination$iv$iv;
                Iterable $this$filterNot$iv11 = doc.select("a[href*='/getLink/']");
                destination$iv$iv2 = new ArrayList();
                while (r28.hasNext()) {
                    List fileAnchors4 = fileAnchors;
                    if (!load$isComingSoon((Element) element$iv$iv3)) {
                        destination$iv$iv2.add(element$iv$iv3);
                    }
                    fileAnchors = fileAnchors4;
                }
                fileAnchors2 = fileAnchors;
                element$iv$iv = (List) destination$iv$iv2;
                Iterable $this$filterNot$iv12 = doc.select("a[href*='/getWatch/']");
                destination$iv$iv3 = new ArrayList();
                while (r28.hasNext()) {
                    Object linkAnchors3 = element$iv$iv;
                    if (!load$isComingSoon((Element) element$iv$iv4)) {
                        destination$iv$iv3.add(element$iv$iv4);
                    }
                    element$iv$iv = linkAnchors3;
                }
                linkAnchors = element$iv$iv;
                watchAnchors = (List) destination$iv$iv3;
                iterableSelect = doc.select(".mlbd-live-server-btn[href], a.mlbd-live-server-btn[href]");
                str = "|ext:";
                epLinks = "|cdn:";
                String str110 = "http";
                String str25 = "href";
                str2 = " ; ";
                if (i2 == 0) {
                    items = new ArrayList();
                    while (r35.hasNext()) {
                        posterElement = posterElement;
                        ql2 = src4.getQualityLabel();
                        if (src4.getStreamUrl().length() > 0) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (z11) {
                            items.add(ql2 + "|cdn:" + src4.getStreamUrl() + '|' + base4);
                        }
                        if (src4.getDownloadUrl().length() > 0) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        if (z12) {
                            items.add(ql2 + " [DL]|cdn:" + src4.getDownloadUrl() + '|' + base4);
                        }
                    }
                    String str26 = str2;
                    Element posterElement3 = posterElement;
                    while (it9.hasNext()) {
                        Element a9 = (Element) it9.next();
                        String href5 = load$absHref(base3, movieLinkBDProvider, a9);
                        String quality7 = movieLinkBDProvider.extractQualityLabel(StringsKt.trim(a9.text()).toString());
                        items.add(quality7 + '|' + href5 + '|' + base4);
                    }
                    while (it10.hasNext()) {
                        Element a10 = (Element) it10.next();
                        String href6 = load$absHref(base3, movieLinkBDProvider, a10);
                        String quality8 = movieLinkBDProvider.extractQualityLabel(a10.text());
                        items.add(quality8 + '|' + href6 + '|' + base4);
                    }
                    it11 = iterableSelect.iterator();
                    while (it11.hasNext()) {
                        a2 = (Element) it11.next();
                        string2 = StringsKt.trim(a2.attr("href")).toString();
                        if (string2.length() == 0) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        if (!z8) {
                            h = string2;
                            Iterator it110 = it11;
                            if (StringsKt.startsWith$default(h, "http", false, 2, (Object) null)) {
                                absH = h;
                            } else {
                                absH = base3 + h;
                            }
                            string3 = StringsKt.trim(a2.text()).toString();
                            if (string3.length() == 0) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            if (z9) {
                                string3 = str16;
                            }
                            text = string3;
                            strExtractQualityLabel = movieLinkBDProvider.extractQualityLabel(text);
                            if (strExtractQualityLabel.length() == 0) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            if (z10) {
                                strExtractQualityLabel = StringsKt.take(text, 30);
                            }
                            String quality9 = strExtractQualityLabel;
                            items.add(quality9 + "|ext:" + absH + '|' + base4);
                            it11 = it110;
                        }
                    }
                    String linksData2 = CollectionsKt.joinToString$default(items, str26, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
                    TvType tvType3 = TvType.Movie;
                    Float rating3 = floatOrNull;
                    C00053 c00054 = new C00053(poster, year, fullPlot2, rating3, null);
                    c00043.L$0 = SpillingKt.nullOutSpilledVariable(base4);
                    c00043.L$1 = SpillingKt.nullOutSpilledVariable(base3);
                    c00043.L$2 = SpillingKt.nullOutSpilledVariable(doc);
                    c00043.L$3 = SpillingKt.nullOutSpilledVariable(rawTitle);
                    c00043.L$4 = SpillingKt.nullOutSpilledVariable(year);
                    c00043.L$5 = SpillingKt.nullOutSpilledVariable(posterElement3);
                    c00043.L$6 = SpillingKt.nullOutSpilledVariable(poster);
                    c00043.L$7 = SpillingKt.nullOutSpilledVariable(plot);
                    c00043.L$8 = SpillingKt.nullOutSpilledVariable(genre);
                    c00043.L$9 = SpillingKt.nullOutSpilledVariable(cast);
                    c00043.L$10 = SpillingKt.nullOutSpilledVariable(language);
                    c00043.L$11 = SpillingKt.nullOutSpilledVariable(rating3);
                    c00043.L$12 = SpillingKt.nullOutSpilledVariable(fullPlot2);
                    c00043.L$13 = SpillingKt.nullOutSpilledVariable(jsonSources);
                    c00043.L$14 = SpillingKt.nullOutSpilledVariable(fileAnchors2);
                    c00043.L$15 = SpillingKt.nullOutSpilledVariable(linkAnchors);
                    c00043.L$16 = SpillingKt.nullOutSpilledVariable(watchAnchors);
                    c00043.L$17 = SpillingKt.nullOutSpilledVariable(iterableSelect);
                    c00043.L$18 = SpillingKt.nullOutSpilledVariable(items);
                    c00043.L$19 = SpillingKt.nullOutSpilledVariable(linksData2);
                    c00043.I$0 = i2;
                    c00043.label = 3;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(movieLinkBDProvider, rawTitle, base4, tvType3, linksData2, c00054, c00043);
                    if (objNewMovieLoadResponse == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return objNewMovieLoadResponse;
                }
                str3 = " ; ";
                episodesData = new ArrayList();
                str4 = "\\d+";
                if (jsonSources.isEmpty()) {
                    $this$groupBy$iv = jsonSources;
                    $i$f$groupBy = 0;
                    grouped = new LinkedHashMap();
                    while (r42.hasNext()) {
                        Iterable $this$groupBy$iv3 = $this$groupBy$iv;
                        episodeKey = ((StreamSource) element$iv$iv5).getEpisodeKey();
                        int $i$f$groupBy3 = $i$f$groupBy;
                        Object obj5 = coroutine_suspended;
                        value$iv$iv$iv = grouped.get(episodeKey);
                        if (value$iv$iv$iv == null) {
                            answer$iv$iv$iv = new ArrayList();
                            grouped.put(episodeKey, answer$iv$iv$iv);
                        } else {
                            answer$iv$iv$iv = value$iv$iv$iv;
                        }
                        List list$iv$iv2 = (List) answer$iv$iv$iv;
                        list$iv$iv2.add(element$iv$iv5);
                        $this$groupBy$iv = $this$groupBy$iv3;
                        coroutine_suspended = obj5;
                        $i$f$groupBy = $i$f$groupBy3;
                        i2 = i2;
                    }
                    i3 = i2;
                    obj = coroutine_suspended;
                    it7 = grouped.entrySet().iterator();
                    while (it7.hasNext()) {
                        Map.Entry entry2 = (Map.Entry) it7.next();
                        String epKey3 = (String) entry2.getKey();
                        List srcs2 = (List) entry2.getValue();
                        Iterator it111 = it7;
                        C00041 c00046 = c00043;
                        matchResultFind$default3 = Regex.find$default(new Regex("\\d+"), epKey3, 0, 2, (Object) null);
                        if (matchResultFind$default3 != null) {
                            epNum3 = 1;
                        } else {
                            epNum3 = 1;
                        }
                        streamSource = (StreamSource) CollectionsKt.firstOrNull(srcs2);
                        if (streamSource != null) {
                            epLabel = "Episode " + epNum3;
                        } else {
                            epLabel = "Episode " + epNum3;
                        }
                        epLinksList = new ArrayList();
                        it8 = srcs2.iterator();
                        while (it8.hasNext()) {
                            src = (StreamSource) it8.next();
                            it8 = it8;
                            ql = src.getQualityLabel();
                            if (src.getStreamUrl().length() > 0) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            if (z6) {
                                src2 = src;
                                epLinksList.add(ql + epLinks + src2.getStreamUrl() + '|' + base4);
                            } else {
                                src2 = src;
                            }
                            if (src2.getDownloadUrl().length() > 0) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            if (z7) {
                                epLinksList.add(ql + " [DL]|cdn:" + src2.getDownloadUrl() + '|' + base4);
                            }
                        }
                        String str27 = epLinks;
                        String epLinks3 = CollectionsKt.joinToString$default(epLinksList, str3, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
                        episodesData.add(MainAPIKt.newEpisode(movieLinkBDProvider, epLinks3, new Function1() { // from class: com.cncverse.MovieLinkBDProvider$$ExternalSyntheticLambda5
                            public final Object invoke(Object obj6) {
                                return MovieLinkBDProvider.load$lambda$13(epLabel, epNum3, (Episode) obj6);
                            }
                        }));
                        it7 = it111;
                        c00043 = c00046;
                        epLinks = str27;
                    }
                    c00042 = c00043;
                } else {
                    i3 = i2;
                    c00042 = c00043;
                    obj = coroutine_suspended;
                }
                isSeries = episodesData.isEmpty();
                str5 = "a[href*='/getLink/'], a[href*='/getWatch/']";
                if (isSeries) {
                    epCards = doc.select("div.ep-card, [data-ep]");
                    if (((Collection) epCards).isEmpty()) {
                        $this$forEach$iv3 = (Iterable) epCards;
                        $i$f$forEach2 = 0;
                        it4 = $this$forEach$iv3.iterator();
                        while (it4.hasNext()) {
                            Object element$iv4 = it4.next();
                            Element card2 = (Element) element$iv4;
                            Elements epCards3 = epCards;
                            strAttr = card2.attr("data-ep");
                            if (strAttr.length() == 0) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (z3) {
                                strAttr = str17;
                            }
                            String epText2 = strAttr;
                            Iterable $this$forEach$iv6 = $this$forEach$iv3;
                            int $i$f$forEach5 = $i$f$forEach2;
                            String str28 = str4;
                            Iterator it112 = it4;
                            matchResultFind$default2 = Regex.find$default(new Regex(str4), epText2, 0, 2, (Object) null);
                            if (matchResultFind$default2 != null) {
                                epNum2 = 1;
                            } else {
                                epNum2 = 1;
                            }
                            $this$filterNot$iv3 = card2.select("a[href*='/getLink/'], a[href*='/getWatch/']");
                            destination$iv$iv5 = new ArrayList();
                            while (r50.hasNext()) {
                                Iterable $this$filterNot$iv13 = $this$filterNot$iv3;
                                if (!load$isComingSoon((Element) element$iv$iv6)) {
                                    destination$iv$iv5.add(element$iv$iv6);
                                }
                                $this$filterNot$iv3 = $this$filterNot$iv13;
                            }
                            it$iv$iv = (List) destination$iv$iv5;
                            if (((Collection) it$iv$iv).isEmpty()) {
                                $this$mapNotNull$iv = (Iterable) it$iv$iv;
                                $i$f$mapNotNull = 0;
                                destination$iv$iv6 = new ArrayList();
                                while (r54.hasNext()) {
                                    Object cardLinks2 = it$iv$iv;
                                    Element a11 = (Element) element$iv$iv$iv;
                                    Iterable $this$mapNotNull$iv6 = $this$mapNotNull$iv;
                                    String href7 = load$absHref(base3, movieLinkBDProvider, a11);
                                    String quality10 = movieLinkBDProvider.extractQualityLabel(a11.text());
                                    int $i$f$mapNotNull6 = $i$f$mapNotNull;
                                    str12 = quality10 + '|' + href7 + '|' + base4;
                                    if (str12 != null) {
                                        destination$iv$iv6.add(str12);
                                    }
                                    it$iv$iv = cardLinks2;
                                    $this$mapNotNull$iv = $this$mapNotNull$iv6;
                                    $i$f$mapNotNull = $i$f$mapNotNull6;
                                }
                                epUrl2 = CollectionsKt.joinToString$default((List) destination$iv$iv6, str3, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
                                it5 = episodesData.iterator();
                                while (true) {
                                    if (it5.hasNext()) {
                                        next2 = it5.next();
                                        Episode it113 = (Episode) next2;
                                        episode2 = it113.getEpisode();
                                        it6 = it5;
                                        if (episode2 == null) {
                                            obj3 = next2;
                                        } else {
                                            obj3 = next2;
                                            if (season2.intValue() == 1) {
                                            }
                                        }
                                        if (z5) {
                                            it5 = it6;
                                        }
                                    } else {
                                        obj3 = null;
                                    }
                                }
                                existingEp2 = (Episode) obj3;
                                if (existingEp2 != null) {
                                    data2 = existingEp2.getData();
                                    if (data2 != null) {
                                        z4 = true;
                                    } else {
                                        z4 = true;
                                    }
                                    if (z4) {
                                        str11 = str3;
                                        existingEp2.setData(existingEp2.getData() + str11 + epUrl2);
                                    } else {
                                        str11 = str3;
                                        existingEp2.setData(epUrl2);
                                    }
                                    Unit unit4 = Unit.INSTANCE;
                                } else {
                                    str11 = str3;
                                    Boxing.boxBoolean(episodesData.add(MainAPIKt.newEpisode(movieLinkBDProvider, epUrl2, new Function1() { // from class: com.cncverse.MovieLinkBDProvider$$ExternalSyntheticLambda6
                                        public final Object invoke(Object obj6) {
                                            return MovieLinkBDProvider.load$lambda$14$4(epNum2, (Episode) obj6);
                                        }
                                    })));
                                }
                            } else {
                                str11 = str3;
                            }
                            str3 = str11;
                            epCards = epCards3;
                            $this$forEach$iv3 = $this$forEach$iv6;
                            $i$f$forEach2 = $i$f$forEach5;
                            str4 = str28;
                            it4 = it112;
                        }
                        str6 = str3;
                    } else {
                        str6 = str3;
                    }
                } else {
                    str6 = str3;
                }
                if (episodesData.isEmpty()) {
                    episodeSections = doc.select("div.episode-section, div.season-section, h3:contains(Episode), h4:contains(Episode), h5:contains(Episode), div[class*='episode'], div[class*='season'], strong:contains(Ep), b:contains(Ep)");
                    if (((Collection) episodeSections).isEmpty()) {
                        $this$forEach$iv = (Iterable) episodeSections;
                        $i$f$forEach = 0;
                        it = $this$forEach$iv.iterator();
                        while (it.hasNext()) {
                            Object element$iv5 = it.next();
                            section = (Element) element$iv5;
                            String sectionText2 = section.text();
                            Elements episodeSections3 = episodeSections;
                            Iterable $this$forEach$iv7 = $this$forEach$iv;
                            int $i$f$forEach6 = $i$f$forEach;
                            Iterator it114 = it;
                            epRange = Regex.find$default(new Regex("(?:Ep|Episode)[^\\d]*(\\d+)(?:[^\\d]+(\\d+))?", RegexOption.IGNORE_CASE), sectionText2, 0, 2, (Object) null);
                            if (epRange != null) {
                                start = 1;
                            } else {
                                start = 1;
                            }
                            if (epRange != null) {
                                end = start;
                            } else {
                                end = start;
                            }
                            sectionLinks = new ArrayList();
                            sib = section.nextElementSibling();
                            while (true) {
                                if (sib != null) {
                                    epRange2 = epRange;
                                    start2 = start;
                                    section2 = section;
                                    if (!new Regex("h[1-6]").matches(sib.tagName())) {
                                        anchors = new ArrayList();
                                        if (Intrinsics.areEqual(sib.tagName(), "a")) {
                                            str8 = str;
                                            episodesData4 = episodesData;
                                            doc3 = doc;
                                            if (StringsKt.contains$default(sib.attr("href"), "/getLink/", false, 2, (Object) null)) {
                                                anchors.add(sib);
                                            } else {
                                                anchors.add(sib);
                                            }
                                        } else {
                                            str8 = str;
                                            episodesData4 = episodesData;
                                            doc3 = doc;
                                        }
                                        $this$filterNot$iv2 = sib.select(str5);
                                        destination$iv$iv4 = new ArrayList();
                                        while (r54.hasNext()) {
                                            Iterable $this$filterNot$iv14 = $this$filterNot$iv2;
                                            if (!load$isComingSoon((Element) element$iv$iv7)) {
                                                destination$iv$iv4.add(element$iv$iv7);
                                            }
                                            $this$filterNot$iv2 = $this$filterNot$iv14;
                                        }
                                        anchors.addAll((List) destination$iv$iv4);
                                        $this$forEach$iv2 = anchors;
                                        while (r9.hasNext()) {
                                            Element a12 = (Element) element$iv3;
                                            sectionLinks.add(movieLinkBDProvider.extractQualityLabel(a12.text()) + '|' + load$absHref(base3, movieLinkBDProvider, a12) + '|' + base4);
                                            $this$forEach$iv2 = $this$forEach$iv2;
                                            anchors = anchors;
                                            str5 = str5;
                                        }
                                        sib = sib.nextElementSibling();
                                        start = start2;
                                        epRange = epRange2;
                                        section = section2;
                                        doc = doc3;
                                        episodesData = episodesData4;
                                        str = str8;
                                    }
                                } else {
                                    start2 = start;
                                }
                            }
                            if (!sectionLinks.isEmpty()) {
                                epUrl = CollectionsKt.joinToString$default(sectionLinks, str6, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
                                epNum = start2;
                                if (epNum <= end) {
                                    while (true) {
                                        it2 = episodesData.iterator();
                                        while (true) {
                                            if (it2.hasNext()) {
                                                next = it2.next();
                                                Episode it115 = (Episode) next;
                                                episode = it115.getEpisode();
                                                if (episode == null) {
                                                    it3 = it2;
                                                } else {
                                                    it3 = it2;
                                                    if (season.intValue() == 1) {
                                                    }
                                                }
                                                if (z2) {
                                                    it2 = it3;
                                                }
                                            } else {
                                                next = null;
                                            }
                                        }
                                        existingEp = (Episode) next;
                                        if (existingEp != null) {
                                            data = existingEp.getData();
                                            if (data != null) {
                                                z = true;
                                            } else {
                                                z = true;
                                            }
                                            if (z) {
                                                existingEp.setData(existingEp.getData() + str6 + epUrl);
                                            } else {
                                                existingEp.setData(epUrl);
                                            }
                                        }
                                        if (epNum != end) {
                                            epNum++;
                                        }
                                    }
                                }
                            }
                            episodeSections = episodeSections3;
                            $this$forEach$iv = $this$forEach$iv7;
                            $i$f$forEach = $i$f$forEach6;
                            it = it114;
                            doc = doc;
                            episodesData = episodesData;
                            str = str;
                            str5 = str5;
                        }
                        str7 = str;
                        episodesData2 = episodesData;
                        doc2 = doc;
                    } else {
                        str7 = "|ext:";
                        episodesData2 = episodesData;
                        doc2 = doc;
                    }
                } else {
                    str7 = "|ext:";
                    episodesData2 = episodesData;
                    doc2 = doc;
                }
                if (episodesData2.isEmpty()) {
                    episodesData3 = episodesData2;
                } else {
                    episodesData3 = episodesData2;
                }
                $this$sortBy$iv = episodesData3;
                if ($this$sortBy$iv.size() > 1) {
                    CollectionsKt.sortWith($this$sortBy$iv, new Comparator() { // from class: com.cncverse.MovieLinkBDProvider$load$$inlined$sortBy$1
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            Episode it20 = (Episode) t;
                            Episode it21 = (Episode) t2;
                            return ComparisonsKt.compareValues(it20.getEpisode(), it21.getEpisode());
                        }
                    });
                }
                TvType tvType4 = TvType.TvSeries;
                Float rating4 = floatOrNull;
                C00069 c000610 = new C00069(poster, year, fullPlot2, rating4, null);
                C00041 c00047 = c00042;
                c00047.L$0 = SpillingKt.nullOutSpilledVariable(base4);
                c00047.L$1 = SpillingKt.nullOutSpilledVariable(base3);
                c00047.L$2 = SpillingKt.nullOutSpilledVariable(doc2);
                c00047.L$3 = SpillingKt.nullOutSpilledVariable(rawTitle);
                c00047.L$4 = SpillingKt.nullOutSpilledVariable(year);
                c00047.L$5 = SpillingKt.nullOutSpilledVariable(posterElement);
                c00047.L$6 = SpillingKt.nullOutSpilledVariable(poster);
                c00047.L$7 = SpillingKt.nullOutSpilledVariable(plot);
                c00047.L$8 = SpillingKt.nullOutSpilledVariable(genre);
                c00047.L$9 = SpillingKt.nullOutSpilledVariable(cast);
                c00047.L$10 = SpillingKt.nullOutSpilledVariable(language);
                c00047.L$11 = SpillingKt.nullOutSpilledVariable(rating4);
                c00047.L$12 = SpillingKt.nullOutSpilledVariable(fullPlot2);
                c00047.L$13 = SpillingKt.nullOutSpilledVariable(jsonSources);
                c00047.L$14 = SpillingKt.nullOutSpilledVariable(fileAnchors2);
                c00047.L$15 = SpillingKt.nullOutSpilledVariable(linkAnchors);
                c00047.L$16 = SpillingKt.nullOutSpilledVariable(watchAnchors);
                c00047.L$17 = SpillingKt.nullOutSpilledVariable(iterableSelect);
                c00047.L$18 = SpillingKt.nullOutSpilledVariable(episodesData3);
                c00047.I$0 = i3;
                c00047.label = 4;
                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, rawTitle, base4, tvType4, episodesData3, c000610, c00047);
                obj2 = obj;
                if (objNewTvSeriesLoadResponse == obj2) {
                    return obj2;
                }
                return objNewTvSeriesLoadResponse;
            case 2:
                String base5 = (String) c00043.L$1;
                base4 = (String) c00043.L$0;
                ResultKt.throwOnFailure($result);
                base3 = base5;
                objHttpGetDoc = $result;
                doc = (Document) objHttpGetDoc;
                elementSelectFirst = doc.selectFirst(".movie-info-view h2, h1, .movie-title, .film-title");
                if (elementSelectFirst != null) {
                    string = StringsKt.trim(StringsKt.substringBefore$default(doc.title(), "•", (String) null, 2, (Object) null)).toString();
                } else {
                    string = StringsKt.trim(StringsKt.substringBefore$default(doc.title(), "•", (String) null, 2, (Object) null)).toString();
                }
                rawTitle = string;
                matchResultFind$default = Regex.find$default(new Regex("\\((\\d{4})\\)"), rawTitle, 0, 2, (Object) null);
                if (matchResultFind$default != null) {
                    intOrNull = null;
                } else {
                    intOrNull = null;
                }
                year = intOrNull;
                posterElement = doc.selectFirst("img.poster, img[class*='poster'], .poster img, .thumb img, img[src*='poster'], img[src*='uploads']");
                if (posterElement != null) {
                    poster = null;
                } else {
                    poster = null;
                }
                elementSelectFirst2 = doc.selectFirst(".storyline p, .storyline, [class*='story'] p, [class*='plot']");
                if (elementSelectFirst2 != null) {
                    strLoad$metaVal = load$metaVal(doc, "Storyline");
                } else {
                    strLoad$metaVal = load$metaVal(doc, "Storyline");
                }
                plot = strLoad$metaVal;
                genre = load$metaVal(doc, "Genre");
                cast = load$metaVal(doc, "Cast");
                language = load$metaVal(doc, "Language");
                elementSelectFirst3 = doc.selectFirst("[class*='imdb'], [class*='rating']");
                if (elementSelectFirst3 != null) {
                }
                floatOrNull = null;
                $this$load_u24lambda_u244 = new StringBuilder();
                if (language != null) {
                    $this$load_u24lambda_u244.append("Language: " + language + '\n');
                }
                if (genre != null) {
                    $this$load_u24lambda_u244.append("Genre: " + genre + '\n');
                }
                if (cast != null) {
                    $this$load_u24lambda_u244.append("Cast: " + cast + '\n');
                }
                if (plot != null) {
                    $this$load_u24lambda_u244.append('\n' + plot);
                    Unit unit5 = Unit.INSTANCE;
                }
                fullPlot = StringsKt.trim($this$load_u24lambda_u244.toString()).toString();
                if (StringsKt.contains$default(base4, "/series/", false, 2, (Object) null)) {
                    i = 1;
                } else {
                    i = 1;
                }
                i2 = i;
                jsonSources = new ArrayList();
                elementSelectFirst5 = doc.selectFirst("script#mlbdInlinePlayerData");
                if (elementSelectFirst5 != null) {
                    jsonScript = elementSelectFirst5.data();
                    if (jsonScript == null) {
                        jsonScript = "";
                    }
                    if (jsonScript.length() > 0) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    if (z13) {
                        fullPlot2 = fullPlot;
                        str17 = "";
                    } else {
                        fullPlot2 = fullPlot;
                        str17 = "";
                    }
                } else {
                    jsonScript = "";
                    if (jsonScript.length() > 0) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    if (z13) {
                        fullPlot2 = fullPlot;
                        str17 = "";
                    } else {
                        fullPlot2 = fullPlot;
                        str17 = "";
                    }
                }
                $this$filterNot$iv = doc.select("a[href*='/file/']");
                destination$iv$iv = new ArrayList();
                while (r27.hasNext()) {
                    Iterable $this$filterNot$iv15 = $this$filterNot$iv;
                    if (!load$isComingSoon((Element) element$iv$iv2)) {
                        destination$iv$iv.add(element$iv$iv2);
                    }
                    $this$filterNot$iv = $this$filterNot$iv15;
                }
                fileAnchors = (List) destination$iv$iv;
                Iterable $this$filterNot$iv16 = doc.select("a[href*='/getLink/']");
                destination$iv$iv2 = new ArrayList();
                while (r28.hasNext()) {
                    List fileAnchors5 = fileAnchors;
                    if (!load$isComingSoon((Element) element$iv$iv3)) {
                        destination$iv$iv2.add(element$iv$iv3);
                    }
                    fileAnchors = fileAnchors5;
                }
                fileAnchors2 = fileAnchors;
                element$iv$iv = (List) destination$iv$iv2;
                Iterable $this$filterNot$iv17 = doc.select("a[href*='/getWatch/']");
                destination$iv$iv3 = new ArrayList();
                while (r28.hasNext()) {
                    Object linkAnchors4 = element$iv$iv;
                    if (!load$isComingSoon((Element) element$iv$iv4)) {
                        destination$iv$iv3.add(element$iv$iv4);
                    }
                    element$iv$iv = linkAnchors4;
                }
                linkAnchors = element$iv$iv;
                watchAnchors = (List) destination$iv$iv3;
                iterableSelect = doc.select(".mlbd-live-server-btn[href], a.mlbd-live-server-btn[href]");
                str = "|ext:";
                epLinks = "|cdn:";
                String str111 = "http";
                String str29 = "href";
                str2 = " ; ";
                if (i2 == 0) {
                    items = new ArrayList();
                    while (r35.hasNext()) {
                        posterElement = posterElement;
                        ql2 = src4.getQualityLabel();
                        if (src4.getStreamUrl().length() > 0) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (z11) {
                            items.add(ql2 + "|cdn:" + src4.getStreamUrl() + '|' + base4);
                        }
                        if (src4.getDownloadUrl().length() > 0) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        if (z12) {
                            items.add(ql2 + " [DL]|cdn:" + src4.getDownloadUrl() + '|' + base4);
                        }
                    }
                    String str210 = str2;
                    Element posterElement4 = posterElement;
                    while (it9.hasNext()) {
                        Element a13 = (Element) it9.next();
                        String href8 = load$absHref(base3, movieLinkBDProvider, a13);
                        String quality11 = movieLinkBDProvider.extractQualityLabel(StringsKt.trim(a13.text()).toString());
                        items.add(quality11 + '|' + href8 + '|' + base4);
                    }
                    while (it10.hasNext()) {
                        Element a14 = (Element) it10.next();
                        String href9 = load$absHref(base3, movieLinkBDProvider, a14);
                        String quality12 = movieLinkBDProvider.extractQualityLabel(a14.text());
                        items.add(quality12 + '|' + href9 + '|' + base4);
                    }
                    it11 = iterableSelect.iterator();
                    while (it11.hasNext()) {
                        a2 = (Element) it11.next();
                        string2 = StringsKt.trim(a2.attr("href")).toString();
                        if (string2.length() == 0) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        if (!z8) {
                            h = string2;
                            Iterator it116 = it11;
                            if (StringsKt.startsWith$default(h, "http", false, 2, (Object) null)) {
                                absH = h;
                            } else {
                                absH = base3 + h;
                            }
                            string3 = StringsKt.trim(a2.text()).toString();
                            if (string3.length() == 0) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            if (z9) {
                                string3 = str16;
                            }
                            text = string3;
                            strExtractQualityLabel = movieLinkBDProvider.extractQualityLabel(text);
                            if (strExtractQualityLabel.length() == 0) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            if (z10) {
                                strExtractQualityLabel = StringsKt.take(text, 30);
                            }
                            String quality13 = strExtractQualityLabel;
                            items.add(quality13 + "|ext:" + absH + '|' + base4);
                            it11 = it116;
                        }
                    }
                    String linksData3 = CollectionsKt.joinToString$default(items, str210, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
                    TvType tvType5 = TvType.Movie;
                    Float rating5 = floatOrNull;
                    C00053 c00055 = new C00053(poster, year, fullPlot2, rating5, null);
                    c00043.L$0 = SpillingKt.nullOutSpilledVariable(base4);
                    c00043.L$1 = SpillingKt.nullOutSpilledVariable(base3);
                    c00043.L$2 = SpillingKt.nullOutSpilledVariable(doc);
                    c00043.L$3 = SpillingKt.nullOutSpilledVariable(rawTitle);
                    c00043.L$4 = SpillingKt.nullOutSpilledVariable(year);
                    c00043.L$5 = SpillingKt.nullOutSpilledVariable(posterElement4);
                    c00043.L$6 = SpillingKt.nullOutSpilledVariable(poster);
                    c00043.L$7 = SpillingKt.nullOutSpilledVariable(plot);
                    c00043.L$8 = SpillingKt.nullOutSpilledVariable(genre);
                    c00043.L$9 = SpillingKt.nullOutSpilledVariable(cast);
                    c00043.L$10 = SpillingKt.nullOutSpilledVariable(language);
                    c00043.L$11 = SpillingKt.nullOutSpilledVariable(rating5);
                    c00043.L$12 = SpillingKt.nullOutSpilledVariable(fullPlot2);
                    c00043.L$13 = SpillingKt.nullOutSpilledVariable(jsonSources);
                    c00043.L$14 = SpillingKt.nullOutSpilledVariable(fileAnchors2);
                    c00043.L$15 = SpillingKt.nullOutSpilledVariable(linkAnchors);
                    c00043.L$16 = SpillingKt.nullOutSpilledVariable(watchAnchors);
                    c00043.L$17 = SpillingKt.nullOutSpilledVariable(iterableSelect);
                    c00043.L$18 = SpillingKt.nullOutSpilledVariable(items);
                    c00043.L$19 = SpillingKt.nullOutSpilledVariable(linksData3);
                    c00043.I$0 = i2;
                    c00043.label = 3;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(movieLinkBDProvider, rawTitle, base4, tvType5, linksData3, c00055, c00043);
                    if (objNewMovieLoadResponse == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return objNewMovieLoadResponse;
                }
                str3 = " ; ";
                episodesData = new ArrayList();
                str4 = "\\d+";
                if (jsonSources.isEmpty()) {
                    $this$groupBy$iv = jsonSources;
                    $i$f$groupBy = 0;
                    grouped = new LinkedHashMap();
                    while (r42.hasNext()) {
                        Iterable $this$groupBy$iv4 = $this$groupBy$iv;
                        episodeKey = ((StreamSource) element$iv$iv5).getEpisodeKey();
                        int $i$f$groupBy4 = $i$f$groupBy;
                        Object obj6 = coroutine_suspended;
                        value$iv$iv$iv = grouped.get(episodeKey);
                        if (value$iv$iv$iv == null) {
                            answer$iv$iv$iv = new ArrayList();
                            grouped.put(episodeKey, answer$iv$iv$iv);
                        } else {
                            answer$iv$iv$iv = value$iv$iv$iv;
                        }
                        List list$iv$iv3 = (List) answer$iv$iv$iv;
                        list$iv$iv3.add(element$iv$iv5);
                        $this$groupBy$iv = $this$groupBy$iv4;
                        coroutine_suspended = obj6;
                        $i$f$groupBy = $i$f$groupBy4;
                        i2 = i2;
                    }
                    i3 = i2;
                    obj = coroutine_suspended;
                    it7 = grouped.entrySet().iterator();
                    while (it7.hasNext()) {
                        Map.Entry entry3 = (Map.Entry) it7.next();
                        String epKey4 = (String) entry3.getKey();
                        List srcs3 = (List) entry3.getValue();
                        Iterator it117 = it7;
                        C00041 c00048 = c00043;
                        matchResultFind$default3 = Regex.find$default(new Regex("\\d+"), epKey4, 0, 2, (Object) null);
                        if (matchResultFind$default3 != null) {
                            epNum3 = 1;
                        } else {
                            epNum3 = 1;
                        }
                        streamSource = (StreamSource) CollectionsKt.firstOrNull(srcs3);
                        if (streamSource != null) {
                            epLabel = "Episode " + epNum3;
                        } else {
                            epLabel = "Episode " + epNum3;
                        }
                        epLinksList = new ArrayList();
                        it8 = srcs3.iterator();
                        while (it8.hasNext()) {
                            src = (StreamSource) it8.next();
                            it8 = it8;
                            ql = src.getQualityLabel();
                            if (src.getStreamUrl().length() > 0) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            if (z6) {
                                src2 = src;
                                epLinksList.add(ql + epLinks + src2.getStreamUrl() + '|' + base4);
                            } else {
                                src2 = src;
                            }
                            if (src2.getDownloadUrl().length() > 0) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            if (z7) {
                                epLinksList.add(ql + " [DL]|cdn:" + src2.getDownloadUrl() + '|' + base4);
                            }
                        }
                        String str211 = epLinks;
                        String epLinks4 = CollectionsKt.joinToString$default(epLinksList, str3, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
                        episodesData.add(MainAPIKt.newEpisode(movieLinkBDProvider, epLinks4, new Function1() { // from class: com.cncverse.MovieLinkBDProvider$$ExternalSyntheticLambda5
                            public final Object invoke(Object obj7) {
                                return MovieLinkBDProvider.load$lambda$13(epLabel, epNum3, (Episode) obj7);
                            }
                        }));
                        it7 = it117;
                        c00043 = c00048;
                        epLinks = str211;
                    }
                    c00042 = c00043;
                } else {
                    i3 = i2;
                    c00042 = c00043;
                    obj = coroutine_suspended;
                }
                isSeries = episodesData.isEmpty();
                str5 = "a[href*='/getLink/'], a[href*='/getWatch/']";
                if (isSeries) {
                    epCards = doc.select("div.ep-card, [data-ep]");
                    if (((Collection) epCards).isEmpty()) {
                        $this$forEach$iv3 = (Iterable) epCards;
                        $i$f$forEach2 = 0;
                        it4 = $this$forEach$iv3.iterator();
                        while (it4.hasNext()) {
                            Object element$iv6 = it4.next();
                            Element card3 = (Element) element$iv6;
                            Elements epCards4 = epCards;
                            strAttr = card3.attr("data-ep");
                            if (strAttr.length() == 0) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (z3) {
                                strAttr = str17;
                            }
                            String epText3 = strAttr;
                            Iterable $this$forEach$iv8 = $this$forEach$iv3;
                            int $i$f$forEach7 = $i$f$forEach2;
                            String str212 = str4;
                            Iterator it118 = it4;
                            matchResultFind$default2 = Regex.find$default(new Regex(str4), epText3, 0, 2, (Object) null);
                            if (matchResultFind$default2 != null) {
                                epNum2 = 1;
                            } else {
                                epNum2 = 1;
                            }
                            $this$filterNot$iv3 = card3.select("a[href*='/getLink/'], a[href*='/getWatch/']");
                            destination$iv$iv5 = new ArrayList();
                            while (r50.hasNext()) {
                                Iterable $this$filterNot$iv18 = $this$filterNot$iv3;
                                if (!load$isComingSoon((Element) element$iv$iv6)) {
                                    destination$iv$iv5.add(element$iv$iv6);
                                }
                                $this$filterNot$iv3 = $this$filterNot$iv18;
                            }
                            it$iv$iv = (List) destination$iv$iv5;
                            if (((Collection) it$iv$iv).isEmpty()) {
                                $this$mapNotNull$iv = (Iterable) it$iv$iv;
                                $i$f$mapNotNull = 0;
                                destination$iv$iv6 = new ArrayList();
                                while (r54.hasNext()) {
                                    Object cardLinks3 = it$iv$iv;
                                    Element a15 = (Element) element$iv$iv$iv;
                                    Iterable $this$mapNotNull$iv7 = $this$mapNotNull$iv;
                                    String href10 = load$absHref(base3, movieLinkBDProvider, a15);
                                    String quality14 = movieLinkBDProvider.extractQualityLabel(a15.text());
                                    int $i$f$mapNotNull7 = $i$f$mapNotNull;
                                    str12 = quality14 + '|' + href10 + '|' + base4;
                                    if (str12 != null) {
                                        destination$iv$iv6.add(str12);
                                    }
                                    it$iv$iv = cardLinks3;
                                    $this$mapNotNull$iv = $this$mapNotNull$iv7;
                                    $i$f$mapNotNull = $i$f$mapNotNull7;
                                }
                                epUrl2 = CollectionsKt.joinToString$default((List) destination$iv$iv6, str3, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
                                it5 = episodesData.iterator();
                                while (true) {
                                    if (it5.hasNext()) {
                                        next2 = it5.next();
                                        Episode it119 = (Episode) next2;
                                        episode2 = it119.getEpisode();
                                        it6 = it5;
                                        if (episode2 == null) {
                                            obj3 = next2;
                                        } else {
                                            obj3 = next2;
                                            if (season2.intValue() == 1) {
                                            }
                                        }
                                        if (z5) {
                                            it5 = it6;
                                        }
                                    } else {
                                        obj3 = null;
                                    }
                                }
                                existingEp2 = (Episode) obj3;
                                if (existingEp2 != null) {
                                    data2 = existingEp2.getData();
                                    if (data2 != null) {
                                        z4 = true;
                                    } else {
                                        z4 = true;
                                    }
                                    if (z4) {
                                        str11 = str3;
                                        existingEp2.setData(existingEp2.getData() + str11 + epUrl2);
                                    } else {
                                        str11 = str3;
                                        existingEp2.setData(epUrl2);
                                    }
                                    Unit unit6 = Unit.INSTANCE;
                                } else {
                                    str11 = str3;
                                    Boxing.boxBoolean(episodesData.add(MainAPIKt.newEpisode(movieLinkBDProvider, epUrl2, new Function1() { // from class: com.cncverse.MovieLinkBDProvider$$ExternalSyntheticLambda6
                                        public final Object invoke(Object obj7) {
                                            return MovieLinkBDProvider.load$lambda$14$4(epNum2, (Episode) obj7);
                                        }
                                    })));
                                }
                            } else {
                                str11 = str3;
                            }
                            str3 = str11;
                            epCards = epCards4;
                            $this$forEach$iv3 = $this$forEach$iv8;
                            $i$f$forEach2 = $i$f$forEach7;
                            str4 = str212;
                            it4 = it118;
                        }
                        str6 = str3;
                    } else {
                        str6 = str3;
                    }
                } else {
                    str6 = str3;
                }
                if (episodesData.isEmpty()) {
                    episodeSections = doc.select("div.episode-section, div.season-section, h3:contains(Episode), h4:contains(Episode), h5:contains(Episode), div[class*='episode'], div[class*='season'], strong:contains(Ep), b:contains(Ep)");
                    if (((Collection) episodeSections).isEmpty()) {
                        $this$forEach$iv = (Iterable) episodeSections;
                        $i$f$forEach = 0;
                        it = $this$forEach$iv.iterator();
                        while (it.hasNext()) {
                            Object element$iv7 = it.next();
                            section = (Element) element$iv7;
                            String sectionText3 = section.text();
                            Elements episodeSections4 = episodeSections;
                            Iterable $this$forEach$iv9 = $this$forEach$iv;
                            int $i$f$forEach8 = $i$f$forEach;
                            Iterator it1110 = it;
                            epRange = Regex.find$default(new Regex("(?:Ep|Episode)[^\\d]*(\\d+)(?:[^\\d]+(\\d+))?", RegexOption.IGNORE_CASE), sectionText3, 0, 2, (Object) null);
                            if (epRange != null) {
                                start = 1;
                            } else {
                                start = 1;
                            }
                            if (epRange != null) {
                                end = start;
                            } else {
                                end = start;
                            }
                            sectionLinks = new ArrayList();
                            sib = section.nextElementSibling();
                            while (true) {
                                if (sib != null) {
                                    epRange2 = epRange;
                                    start2 = start;
                                    section2 = section;
                                    if (!new Regex("h[1-6]").matches(sib.tagName())) {
                                        anchors = new ArrayList();
                                        if (Intrinsics.areEqual(sib.tagName(), "a")) {
                                            str8 = str;
                                            episodesData4 = episodesData;
                                            doc3 = doc;
                                            if (StringsKt.contains$default(sib.attr("href"), "/getLink/", false, 2, (Object) null)) {
                                                anchors.add(sib);
                                            } else {
                                                anchors.add(sib);
                                            }
                                        } else {
                                            str8 = str;
                                            episodesData4 = episodesData;
                                            doc3 = doc;
                                        }
                                        $this$filterNot$iv2 = sib.select(str5);
                                        destination$iv$iv4 = new ArrayList();
                                        while (r54.hasNext()) {
                                            Iterable $this$filterNot$iv19 = $this$filterNot$iv2;
                                            if (!load$isComingSoon((Element) element$iv$iv7)) {
                                                destination$iv$iv4.add(element$iv$iv7);
                                            }
                                            $this$filterNot$iv2 = $this$filterNot$iv19;
                                        }
                                        anchors.addAll((List) destination$iv$iv4);
                                        $this$forEach$iv2 = anchors;
                                        while (r9.hasNext()) {
                                            Element a16 = (Element) element$iv3;
                                            sectionLinks.add(movieLinkBDProvider.extractQualityLabel(a16.text()) + '|' + load$absHref(base3, movieLinkBDProvider, a16) + '|' + base4);
                                            $this$forEach$iv2 = $this$forEach$iv2;
                                            anchors = anchors;
                                            str5 = str5;
                                        }
                                        sib = sib.nextElementSibling();
                                        start = start2;
                                        epRange = epRange2;
                                        section = section2;
                                        doc = doc3;
                                        episodesData = episodesData4;
                                        str = str8;
                                    }
                                } else {
                                    start2 = start;
                                }
                            }
                            if (!sectionLinks.isEmpty()) {
                                epUrl = CollectionsKt.joinToString$default(sectionLinks, str6, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
                                epNum = start2;
                                if (epNum <= end) {
                                    while (true) {
                                        it2 = episodesData.iterator();
                                        while (true) {
                                            if (it2.hasNext()) {
                                                next = it2.next();
                                                Episode it1111 = (Episode) next;
                                                episode = it1111.getEpisode();
                                                if (episode == null) {
                                                    it3 = it2;
                                                } else {
                                                    it3 = it2;
                                                    if (season.intValue() == 1) {
                                                    }
                                                }
                                                if (z2) {
                                                    it2 = it3;
                                                }
                                            } else {
                                                next = null;
                                            }
                                        }
                                        existingEp = (Episode) next;
                                        if (existingEp != null) {
                                            data = existingEp.getData();
                                            if (data != null) {
                                                z = true;
                                            } else {
                                                z = true;
                                            }
                                            if (z) {
                                                existingEp.setData(existingEp.getData() + str6 + epUrl);
                                            } else {
                                                existingEp.setData(epUrl);
                                            }
                                        }
                                        if (epNum != end) {
                                            epNum++;
                                        }
                                    }
                                }
                            }
                            episodeSections = episodeSections4;
                            $this$forEach$iv = $this$forEach$iv9;
                            $i$f$forEach = $i$f$forEach8;
                            it = it1110;
                            doc = doc;
                            episodesData = episodesData;
                            str = str;
                            str5 = str5;
                        }
                        str7 = str;
                        episodesData2 = episodesData;
                        doc2 = doc;
                    } else {
                        str7 = "|ext:";
                        episodesData2 = episodesData;
                        doc2 = doc;
                    }
                } else {
                    str7 = "|ext:";
                    episodesData2 = episodesData;
                    doc2 = doc;
                }
                if (episodesData2.isEmpty()) {
                    episodesData3 = episodesData2;
                } else {
                    episodesData3 = episodesData2;
                }
                $this$sortBy$iv = episodesData3;
                if ($this$sortBy$iv.size() > 1) {
                    CollectionsKt.sortWith($this$sortBy$iv, new Comparator() { // from class: com.cncverse.MovieLinkBDProvider$load$$inlined$sortBy$1
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            Episode it20 = (Episode) t;
                            Episode it21 = (Episode) t2;
                            return ComparisonsKt.compareValues(it20.getEpisode(), it21.getEpisode());
                        }
                    });
                }
                TvType tvType6 = TvType.TvSeries;
                Float rating6 = floatOrNull;
                C00069 c000611 = new C00069(poster, year, fullPlot2, rating6, null);
                C00041 c00049 = c00042;
                c00049.L$0 = SpillingKt.nullOutSpilledVariable(base4);
                c00049.L$1 = SpillingKt.nullOutSpilledVariable(base3);
                c00049.L$2 = SpillingKt.nullOutSpilledVariable(doc2);
                c00049.L$3 = SpillingKt.nullOutSpilledVariable(rawTitle);
                c00049.L$4 = SpillingKt.nullOutSpilledVariable(year);
                c00049.L$5 = SpillingKt.nullOutSpilledVariable(posterElement);
                c00049.L$6 = SpillingKt.nullOutSpilledVariable(poster);
                c00049.L$7 = SpillingKt.nullOutSpilledVariable(plot);
                c00049.L$8 = SpillingKt.nullOutSpilledVariable(genre);
                c00049.L$9 = SpillingKt.nullOutSpilledVariable(cast);
                c00049.L$10 = SpillingKt.nullOutSpilledVariable(language);
                c00049.L$11 = SpillingKt.nullOutSpilledVariable(rating6);
                c00049.L$12 = SpillingKt.nullOutSpilledVariable(fullPlot2);
                c00049.L$13 = SpillingKt.nullOutSpilledVariable(jsonSources);
                c00049.L$14 = SpillingKt.nullOutSpilledVariable(fileAnchors2);
                c00049.L$15 = SpillingKt.nullOutSpilledVariable(linkAnchors);
                c00049.L$16 = SpillingKt.nullOutSpilledVariable(watchAnchors);
                c00049.L$17 = SpillingKt.nullOutSpilledVariable(iterableSelect);
                c00049.L$18 = SpillingKt.nullOutSpilledVariable(episodesData3);
                c00049.I$0 = i3;
                c00049.label = 4;
                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, rawTitle, base4, tvType6, episodesData3, c000611, c00049);
                obj2 = obj;
                if (objNewTvSeriesLoadResponse == obj2) {
                    return obj2;
                }
                return objNewTvSeriesLoadResponse;
            case 3:
                int i8 = c00043.I$0;
                ResultKt.throwOnFailure($result);
                return $result;
            case 4:
                int i9 = c00043.I$0;
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private static final String load$metaVal(Document doc, String label) {
        Object element$iv;
        String strText;
        String strSubstringAfter$default;
        Element el;
        Iterable $this$firstOrNull$iv = doc.select("li, p, span, div");
        Iterator it = $this$firstOrNull$iv.iterator();
        do {
            if (!it.hasNext()) {
                element$iv = null;
                break;
            }
            element$iv = it.next();
            el = (Element) element$iv;
        } while (!StringsKt.contains(el.text(), label, true));
        Element element = (Element) element$iv;
        if (element == null || (strText = element.text()) == null || (strSubstringAfter$default = StringsKt.substringAfter$default(strText, ":", (String) null, 2, (Object) null)) == null) {
            return null;
        }
        return StringsKt.trim(strSubstringAfter$default).toString();
    }

    private static final boolean load$isComingSoon(Element a) {
        String t = StringsKt.trim(a.text()).toString().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(t, "toLowerCase(...)");
        return StringsKt.contains$default(t, "coming soon", false, 2, (Object) null) || Intrinsics.areEqual(t, "soon") || StringsKt.contains$default(t, "not available", false, 2, (Object) null);
    }

    /* JADX INFO: compiled from: MovieLinkBDProvider.kt */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\u008a\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003JT\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0014\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\"\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010#\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010¨\u0006$"}, d2 = {"com/cncverse/MovieLinkBDProvider$load$StreamSource", "", "quality", "", "qualityLabel", "", "streamUrl", "downloadUrl", "provider", "episodeKey", "episodeLabel", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getQuality", "()I", "getQualityLabel", "()Ljava/lang/String;", "getStreamUrl", "getDownloadUrl", "getProvider", "getEpisodeKey", "getEpisodeLabel", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/cncverse/MovieLinkBDProvider$load$StreamSource;", "equals", "", "other", "hashCode", "toString", "MovieLinkBDProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class StreamSource {
        private final String downloadUrl;
        private final String episodeKey;
        private final String episodeLabel;
        private final String provider;
        private final int quality;
        private final String qualityLabel;
        private final String streamUrl;

        public static /* synthetic */ StreamSource copy$default(StreamSource streamSource, int i, String str, String str2, String str3, String str4, String str5, String str6, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = streamSource.quality;
            }
            if ((i2 & 2) != 0) {
                str = streamSource.qualityLabel;
            }
            if ((i2 & 4) != 0) {
                str2 = streamSource.streamUrl;
            }
            if ((i2 & 8) != 0) {
                str3 = streamSource.downloadUrl;
            }
            if ((i2 & 16) != 0) {
                str4 = streamSource.provider;
            }
            if ((i2 & 32) != 0) {
                str5 = streamSource.episodeKey;
            }
            if ((i2 & 64) != 0) {
                str6 = streamSource.episodeLabel;
            }
            String str7 = str5;
            String str8 = str6;
            String str9 = str4;
            String str10 = str2;
            return streamSource.copy(i, str, str10, str3, str9, str7, str8);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getQuality() {
            return this.quality;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getQualityLabel() {
            return this.qualityLabel;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getStreamUrl() {
            return this.streamUrl;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getDownloadUrl() {
            return this.downloadUrl;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getProvider() {
            return this.provider;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getEpisodeKey() {
            return this.episodeKey;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getEpisodeLabel() {
            return this.episodeLabel;
        }

        public final StreamSource copy(int quality, String qualityLabel, String streamUrl, String downloadUrl, String provider, String episodeKey, String episodeLabel) {
            return new StreamSource(quality, qualityLabel, streamUrl, downloadUrl, provider, episodeKey, episodeLabel);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StreamSource)) {
                return false;
            }
            StreamSource streamSource = (StreamSource) other;
            return this.quality == streamSource.quality && Intrinsics.areEqual(this.qualityLabel, streamSource.qualityLabel) && Intrinsics.areEqual(this.streamUrl, streamSource.streamUrl) && Intrinsics.areEqual(this.downloadUrl, streamSource.downloadUrl) && Intrinsics.areEqual(this.provider, streamSource.provider) && Intrinsics.areEqual(this.episodeKey, streamSource.episodeKey) && Intrinsics.areEqual(this.episodeLabel, streamSource.episodeLabel);
        }

        public int hashCode() {
            return (((((((((((this.quality * 31) + this.qualityLabel.hashCode()) * 31) + this.streamUrl.hashCode()) * 31) + this.downloadUrl.hashCode()) * 31) + this.provider.hashCode()) * 31) + this.episodeKey.hashCode()) * 31) + this.episodeLabel.hashCode();
        }

        public String toString() {
            return "StreamSource(quality=" + this.quality + ", qualityLabel=" + this.qualityLabel + ", streamUrl=" + this.streamUrl + ", downloadUrl=" + this.downloadUrl + ", provider=" + this.provider + ", episodeKey=" + this.episodeKey + ", episodeLabel=" + this.episodeLabel + ')';
        }

        public StreamSource(int quality, String qualityLabel, String streamUrl, String downloadUrl, String provider, String episodeKey, String episodeLabel) {
            this.quality = quality;
            this.qualityLabel = qualityLabel;
            this.streamUrl = streamUrl;
            this.downloadUrl = downloadUrl;
            this.provider = provider;
            this.episodeKey = episodeKey;
            this.episodeLabel = episodeLabel;
        }

        public final int getQuality() {
            return this.quality;
        }

        public final String getQualityLabel() {
            return this.qualityLabel;
        }

        public final String getStreamUrl() {
            return this.streamUrl;
        }

        public final String getDownloadUrl() {
            return this.downloadUrl;
        }

        public final String getProvider() {
            return this.provider;
        }

        public final String getEpisodeKey() {
            return this.episodeKey;
        }

        public final String getEpisodeLabel() {
            return this.episodeLabel;
        }
    }

    private static final String load$absHref(String base, MovieLinkBDProvider this$0, Element a) {
        String h = StringsKt.trim(a.attr("href")).toString();
        String abs = StringsKt.startsWith$default(h, "http", false, 2, (Object) null) ? h : base + h;
        return this$0.fixUrlDomain(abs, base);
    }

    /* JADX INFO: renamed from: com.cncverse.MovieLinkBDProvider$load$3 */
    /* JADX INFO: compiled from: MovieLinkBDProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.MovieLinkBDProvider$load$3", f = "MovieLinkBDProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nMovieLinkBDProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MovieLinkBDProvider.kt\ncom/cncverse/MovieLinkBDProvider$load$3\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1186:1\n1#2:1187\n*E\n"})
    static final class C00053 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $fullPlot;
        final /* synthetic */ String $poster;
        final /* synthetic */ Float $rating;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00053(String str, Integer num, String str2, Float f, Continuation<? super C00053> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$year = num;
            this.$fullPlot = str2;
            this.$rating = f;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00053 = new C00053(this.$poster, this.$year, this.$fullPlot, this.$rating, continuation);
            c00053.L$0 = obj;
            return c00053;
        }

        public final Object invoke(MovieLoadResponse movieLoadResponse, Continuation<? super Unit> continuation) {
            return create(movieLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            MovieLoadResponse $this$newMovieLoadResponse = (MovieLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$newMovieLoadResponse.setPosterUrl(this.$poster);
                    $this$newMovieLoadResponse.setYear(this.$year);
                    String it = this.$fullPlot;
                    Score scoreFrom10 = null;
                    if (!(it.length() > 0)) {
                        it = null;
                    }
                    $this$newMovieLoadResponse.setPlot(it);
                    Float f = this.$rating;
                    if (f != null) {
                        scoreFrom10 = Score.Companion.from10(Boxing.boxFloat(f.floatValue()));
                    }
                    $this$newMovieLoadResponse.setScore(scoreFrom10);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$13(String $epLabel, int $epNum, Episode $this$newEpisode) {
        $this$newEpisode.setName($epLabel);
        $this$newEpisode.setSeason(1);
        $this$newEpisode.setEpisode(Integer.valueOf($epNum));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$14$4(int $epNum, Episode $this$newEpisode) {
        $this$newEpisode.setName("Episode " + $epNum);
        $this$newEpisode.setSeason(1);
        $this$newEpisode.setEpisode(Integer.valueOf($epNum));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$19(Episode $this$newEpisode) {
        $this$newEpisode.setName("Full Season");
        $this$newEpisode.setSeason(1);
        $this$newEpisode.setEpisode(1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.cncverse.MovieLinkBDProvider$load$9 */
    /* JADX INFO: compiled from: MovieLinkBDProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.MovieLinkBDProvider$load$9", f = "MovieLinkBDProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nMovieLinkBDProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MovieLinkBDProvider.kt\ncom/cncverse/MovieLinkBDProvider$load$9\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1186:1\n1#2:1187\n*E\n"})
    static final class C00069 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $fullPlot;
        final /* synthetic */ String $poster;
        final /* synthetic */ Float $rating;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00069(String str, Integer num, String str2, Float f, Continuation<? super C00069> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$year = num;
            this.$fullPlot = str2;
            this.$rating = f;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00069 = new C00069(this.$poster, this.$year, this.$fullPlot, this.$rating, continuation);
            c00069.L$0 = obj;
            return c00069;
        }

        public final Object invoke(TvSeriesLoadResponse tvSeriesLoadResponse, Continuation<? super Unit> continuation) {
            return create(tvSeriesLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            TvSeriesLoadResponse $this$newTvSeriesLoadResponse = (TvSeriesLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$newTvSeriesLoadResponse.setPosterUrl(this.$poster);
                    $this$newTvSeriesLoadResponse.setYear(this.$year);
                    String it = this.$fullPlot;
                    Score scoreFrom10 = null;
                    if (!(it.length() > 0)) {
                        it = null;
                    }
                    $this$newTvSeriesLoadResponse.setPlot(it);
                    Float f = this.$rating;
                    if (f != null) {
                        scoreFrom10 = Score.Companion.from10(Boxing.boxFloat(f.floatValue()));
                    }
                    $this$newTvSeriesLoadResponse.setScore(scoreFrom10);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.cncverse.MovieLinkBDProvider$loadLinks$2 */
    /* JADX INFO: compiled from: MovieLinkBDProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.MovieLinkBDProvider$loadLinks$2", f = "MovieLinkBDProvider.kt", i = {0, 1, 1, 1, 1}, l = {630, 690}, m = "invokeSuspend", n = {"$this$coroutineScope", "$this$coroutineScope", "base", "items", "deferreds"}, nl = {631, 691}, s = {"L$0", "L$0", "L$1", "L$2", "L$3"}, v = 2)
    @SourceDebugExtension({"SMAP\nMovieLinkBDProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MovieLinkBDProvider.kt\ncom/cncverse/MovieLinkBDProvider$loadLinks$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1186:1\n1586#2:1187\n1661#2,3:1188\n*S KotlinDebug\n*F\n+ 1 MovieLinkBDProvider.kt\ncom/cncverse/MovieLinkBDProvider$loadLinks$2\n*L\n632#1:1187\n632#1:1188,3\n*E\n"})
    static final class C00072 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ String $data;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00072(String str, Function1<? super ExtractorLink, Unit> function1, Function1<? super SubtitleFile, Unit> function2, Continuation<? super C00072> continuation) {
            super(2, continuation);
            this.$data = str;
            this.$callback = function1;
            this.$subtitleCallback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00072 = MovieLinkBDProvider.this.new C00072(this.$data, this.$callback, this.$subtitleCallback, continuation);
            c00072.L$0 = obj;
            return c00072;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:41:0x00fb A[LOOP:0: B:39:0x00f5->B:41:0x00fb, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:44:0x0154 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:45:0x0155  */
        public final Object invokeSuspend(Object $result) {
            Object base;
            String base2;
            MovieLinkBDProvider movieLinkBDProvider;
            Function1<ExtractorLink, Unit> function1;
            Function1<SubtitleFile, Unit> function2;
            Collection destination$iv$iv;
            List deferreds;
            CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    MovieLinkBDProvider movieLinkBDProvider2 = MovieLinkBDProvider.this;
                    final Context _ctx = MovieLinkBDProvider.INSTANCE.getAppContext();
                    SharedPreferences _prefs = _ctx != null ? _ctx.getSharedPreferences("CNCVerseSubscription", 0) : null;
                    String _mode = _prefs != null ? _prefs.getString("mode", "ads") : null;
                    long _expiresAt = _prefs != null ? _prefs.getLong("expires_at", 0L) : 0L;
                    long _nowSec = System.currentTimeMillis() / 1000;
                    boolean _isSubscribed = Intrinsics.areEqual(_mode, "subscription") && (_expiresAt == 0 || _expiresAt > _nowSec);
                    if (!_isSubscribed) {
                        if (Intrinsics.areEqual(_mode, "subscription") && _expiresAt > 0 && _expiresAt <= _nowSec) {
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.MovieLinkBDProvider$loadLinks$2$$ExternalSyntheticLambda0
                                @Override // java.lang.Runnable
                                public final void run() {
                                    MovieLinkBDProvider.C00072.invokeSuspend$lambda$0$0(_ctx);
                                }
                            });
                        }
                        movieLinkBDProvider2.openInExternalBrowser(new String(Base64.decode(MovieLinkBDProvider.OMG10, 0), Charsets.UTF_8));
                    }
                    this.L$0 = $this$coroutineScope;
                    this.label = 1;
                    base = MovieLinkBDProvider.this.getBase((Continuation) this);
                    if (base == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    base2 = (String) base;
                    Iterable items = StringsKt.split$default(this.$data, new String[]{" ; "}, false, 0, 6, (Object) null);
                    Iterable $this$map$iv = items;
                    movieLinkBDProvider = MovieLinkBDProvider.this;
                    function1 = this.$callback;
                    function2 = this.$subtitleCallback;
                    destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    for (Object item$iv$iv : $this$map$iv) {
                        String item = (String) item$iv$iv;
                        destination$iv$iv.add(BuildersKt.async$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new MovieLinkBDProvider$loadLinks$2$deferreds$1$1(item, base2, movieLinkBDProvider, function1, function2, null), 3, (Object) null));
                        base2 = base2;
                        movieLinkBDProvider = movieLinkBDProvider;
                        function1 = function1;
                        function2 = function2;
                    }
                    deferreds = (List) destination$iv$iv;
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$coroutineScope);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(base2);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(items);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(deferreds);
                    this.label = 2;
                    if (AwaitKt.awaitAll(deferreds, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Boxing.boxBoolean(true);
                case 1:
                    ResultKt.throwOnFailure($result);
                    base = $result;
                    base2 = (String) base;
                    Iterable items2 = StringsKt.split$default(this.$data, new String[]{" ; "}, false, 0, 6, (Object) null);
                    Iterable $this$map$iv2 = items2;
                    movieLinkBDProvider = MovieLinkBDProvider.this;
                    function1 = this.$callback;
                    function2 = this.$subtitleCallback;
                    destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                    while (r18.hasNext()) {
                        String item2 = (String) item$iv$iv;
                        destination$iv$iv.add(BuildersKt.async$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new MovieLinkBDProvider$loadLinks$2$deferreds$1$1(item2, base2, movieLinkBDProvider, function1, function2, null), 3, (Object) null));
                        base2 = base2;
                        movieLinkBDProvider = movieLinkBDProvider;
                        function1 = function1;
                        function2 = function2;
                    }
                    deferreds = (List) destination$iv$iv;
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$coroutineScope);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(base2);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(items2);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(deferreds);
                    this.label = 2;
                    if (AwaitKt.awaitAll(deferreds, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Boxing.boxBoolean(true);
                case 2:
                    ResultKt.throwOnFailure($result);
                    return Boxing.boxBoolean(true);
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$0$0(Context $_ctx) {
            Toast.makeText($_ctx, "⚠️(Opening ads) Subscription expired. If you have renewed your subscription, please re-verify it in Subscription Manager.", 1).show();
        }
    }

    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        return CoroutineScopeKt.coroutineScope(new C00072(data, function2, function1, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:183:0x06fd A[Catch: Exception -> 0x08d8, TryCatch #17 {Exception -> 0x08d8, blocks: (B:181:0x06f7, B:183:0x06fd, B:188:0x0726), top: B:286:0x06f7 }] */
    /* JADX WARN: Code duplicated, block: B:185:0x0721  */
    /* JADX WARN: Code duplicated, block: B:186:0x0723  */
    /* JADX WARN: Code duplicated, block: B:188:0x0726 A[Catch: Exception -> 0x08d8, TRY_LEAVE, TryCatch #17 {Exception -> 0x08d8, blocks: (B:181:0x06f7, B:183:0x06fd, B:188:0x0726), top: B:286:0x06f7 }] */
    /* JADX WARN: Code duplicated, block: B:193:0x0746 A[Catch: Exception -> 0x08ab, TryCatch #4 {Exception -> 0x08ab, blocks: (B:190:0x0739, B:193:0x0746, B:195:0x074e, B:197:0x0760, B:199:0x0770, B:201:0x0780, B:203:0x0790, B:219:0x083d), top: B:262:0x0739 }] */
    /* JADX WARN: Code duplicated, block: B:195:0x074e A[Catch: Exception -> 0x08ab, TryCatch #4 {Exception -> 0x08ab, blocks: (B:190:0x0739, B:193:0x0746, B:195:0x074e, B:197:0x0760, B:199:0x0770, B:201:0x0780, B:203:0x0790, B:219:0x083d), top: B:262:0x0739 }] */
    /* JADX WARN: Code duplicated, block: B:197:0x0760 A[Catch: Exception -> 0x08ab, TryCatch #4 {Exception -> 0x08ab, blocks: (B:190:0x0739, B:193:0x0746, B:195:0x074e, B:197:0x0760, B:199:0x0770, B:201:0x0780, B:203:0x0790, B:219:0x083d), top: B:262:0x0739 }] */
    /* JADX WARN: Code duplicated, block: B:199:0x0770 A[Catch: Exception -> 0x08ab, TryCatch #4 {Exception -> 0x08ab, blocks: (B:190:0x0739, B:193:0x0746, B:195:0x074e, B:197:0x0760, B:199:0x0770, B:201:0x0780, B:203:0x0790, B:219:0x083d), top: B:262:0x0739 }] */
    /* JADX WARN: Code duplicated, block: B:304:0x08d0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:305:0x08a5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:306:0x08a7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:307:0x08a1 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:310:0x08b7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:311:0x073f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Not initialized variable reg: 25, insn: 0x01b3: MOVE (r5 I:??[OBJECT, ARRAY]) = (r25 I:??[OBJECT, ARRAY] A[D('callback' kotlin.jvm.functions.Function1)]), block:B:24:0x01b3 */
    /* JADX WARN: Not initialized variable reg: 25, insn: 0x05f6: MOVE (r14 I:??[OBJECT, ARRAY]) = (r25 I:??[OBJECT, ARRAY] A[D('$result' java.lang.Object)]), block:B:154:0x05f0 */
    /* JADX WARN: Not initialized variable reg: 27, insn: 0x01b5: MOVE (r6 I:??[OBJECT, ARRAY]) = (r27 I:??[OBJECT, ARRAY] A[D('qualityLabel' java.lang.String)]), block:B:24:0x01b3 */
    /* JADX WARN: Not initialized variable reg: 28, insn: 0x01b7: MOVE (r4 I:??[OBJECT, ARRAY]) = (r28 I:??[OBJECT, ARRAY] A[D('getLinkUrl' java.lang.String)]), block:B:24:0x01b3 */
    /* JADX WARN: Path cross not found for [B:276:0x033e, B:75:0x0364], limit reached: 310 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:210:0x07f2 -> B:211:0x0800). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:215:0x0820 -> B:286:0x06f7). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:183:0x06fd
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object resolveGetLink(java.lang.String r31, java.lang.String r32, java.lang.String r33, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r34, kotlin.coroutines.Continuation<? super kotlin.Unit> r35) {
        /*
            Method dump skipped, instruction units count: 2454
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cncverse.MovieLinkBDProvider.resolveGetLink(java.lang.String, java.lang.String, java.lang.String, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit resolveGetLink$lambda$0(SubtitleFile it) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.cncverse.MovieLinkBDProvider$resolveGetLink$3 */
    /* JADX INFO: compiled from: MovieLinkBDProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.MovieLinkBDProvider$resolveGetLink$3", f = "MovieLinkBDProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00133 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $getLinkUrl;
        final /* synthetic */ int $quality;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MovieLinkBDProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00133(String str, int i, MovieLinkBDProvider movieLinkBDProvider, Continuation<? super C00133> continuation) {
            super(2, continuation);
            this.$getLinkUrl = str;
            this.$quality = i;
            this.this$0 = movieLinkBDProvider;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00133 = new C00133(this.$getLinkUrl, this.$quality, this.this$0, continuation);
            c00133.L$0 = obj;
            return c00133;
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
                    $this$newExtractorLink.setReferer(this.$getLinkUrl);
                    $this$newExtractorLink.setQuality(this.$quality);
                    $this$newExtractorLink.setHeaders(MapsKt.plus(this.this$0.headers, MapsKt.mapOf(TuplesKt.to("Referer", this.$getLinkUrl))));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit resolveGetLink$lambda$1(SubtitleFile it) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object resolveCdnUrl(String cdnUrl, String qualityLabel, String refererUrl, Function1<? super ExtractorLink, Unit> function1, Continuation<? super Unit> continuation) {
        C00081 c00081;
        String displayName;
        Object objNewExtractorLink;
        Function1<? super ExtractorLink, Unit> function2;
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
        try {
            switch (c00082.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    try {
                        int quality = labelToQuality(qualityLabel);
                        ExtractorLinkType type = StringsKt.contains$default(cdnUrl, ".m3u8", false, 2, (Object) null) ? ExtractorLinkType.M3U8 : ExtractorLinkType.VIDEO;
                        String displayName2 = StringsKt.endsWith$default(qualityLabel, " [DL]", false, 2, (Object) null) ? "MovieLinkBD DL" : "MovieLinkBD";
                        Map reqHeaders = MapsKt.plus(this.headers, MapsKt.mapOf(TuplesKt.to("Referer", refererUrl)));
                        String displayName3 = displayName2 + " [" + qualityLabel + ']';
                        C00092 c00092 = new C00092(refererUrl, quality, reqHeaders, null);
                        c00082.L$0 = SpillingKt.nullOutSpilledVariable(cdnUrl);
                        c00082.L$1 = SpillingKt.nullOutSpilledVariable(qualityLabel);
                        c00082.L$2 = SpillingKt.nullOutSpilledVariable(refererUrl);
                        c00082.L$3 = SpillingKt.nullOutSpilledVariable(function1);
                        c00082.L$4 = SpillingKt.nullOutSpilledVariable(type);
                        c00082.L$5 = SpillingKt.nullOutSpilledVariable(displayName2);
                        c00082.L$6 = SpillingKt.nullOutSpilledVariable(reqHeaders);
                        c00082.L$7 = function1;
                        c00082.I$0 = quality;
                        c00082.label = 1;
                        displayName = cdnUrl;
                        try {
                            objNewExtractorLink = ExtractorApiKt.newExtractorLink(displayName2, displayName3, displayName, type, c00092, c00082);
                            if (objNewExtractorLink == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            function2 = function1;
                            try {
                                function1.invoke(objNewExtractorLink);
                                break;
                            } catch (Exception e) {
                                function1 = function2;
                                cdnUrl = displayName;
                            }
                            return Unit.INSTANCE;
                        } catch (Exception e2) {
                            cdnUrl = displayName;
                            return Unit.INSTANCE;
                        }
                    } catch (Exception e3) {
                    }
                    break;
                case 1:
                    int i = c00082.I$0;
                    Function1<? super ExtractorLink, Unit> function3 = (Function1) c00082.L$7;
                    Function1<? super ExtractorLink, Unit> function4 = (Function1) c00082.L$3;
                    String cdnUrl2 = (String) c00082.L$0;
                    ResultKt.throwOnFailure($result);
                    function2 = function4;
                    function1 = function3;
                    displayName = cdnUrl2;
                    objNewExtractorLink = $result;
                    function1.invoke(objNewExtractorLink);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Exception e4) {
        }
    }

    /* JADX INFO: renamed from: com.cncverse.MovieLinkBDProvider$resolveCdnUrl$2 */
    /* JADX INFO: compiled from: MovieLinkBDProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.MovieLinkBDProvider$resolveCdnUrl$2", f = "MovieLinkBDProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00092 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $quality;
        final /* synthetic */ String $refererUrl;
        final /* synthetic */ Map<String, String> $reqHeaders;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00092(String str, int i, Map<String, String> map, Continuation<? super C00092> continuation) {
            super(2, continuation);
            this.$refererUrl = str;
            this.$quality = i;
            this.$reqHeaders = map;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00092 = new C00092(this.$refererUrl, this.$quality, this.$reqHeaders, continuation);
            c00092.L$0 = obj;
            return c00092;
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
                    $this$newExtractorLink.setReferer(this.$refererUrl);
                    $this$newExtractorLink.setQuality(this.$quality);
                    $this$newExtractorLink.setHeaders(this.$reqHeaders);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:52:0x01d9 A[Catch: Exception -> 0x033e, TryCatch #3 {Exception -> 0x033e, blocks: (B:88:0x0338, B:46:0x019a, B:48:0x01ca, B:50:0x01d0, B:59:0x01fb, B:61:0x0201, B:67:0x020f, B:69:0x0222, B:71:0x0227, B:70:0x0225, B:52:0x01d9, B:54:0x01e4, B:55:0x01e9, B:57:0x01f5), top: B:123:0x019a }] */
    /* JADX WARN: Code duplicated, block: B:54:0x01e4 A[Catch: Exception -> 0x033e, TryCatch #3 {Exception -> 0x033e, blocks: (B:88:0x0338, B:46:0x019a, B:48:0x01ca, B:50:0x01d0, B:59:0x01fb, B:61:0x0201, B:67:0x020f, B:69:0x0222, B:71:0x0227, B:70:0x0225, B:52:0x01d9, B:54:0x01e4, B:55:0x01e9, B:57:0x01f5), top: B:123:0x019a }] */
    /* JADX WARN: Code duplicated, block: B:55:0x01e9 A[Catch: Exception -> 0x033e, TryCatch #3 {Exception -> 0x033e, blocks: (B:88:0x0338, B:46:0x019a, B:48:0x01ca, B:50:0x01d0, B:59:0x01fb, B:61:0x0201, B:67:0x020f, B:69:0x0222, B:71:0x0227, B:70:0x0225, B:52:0x01d9, B:54:0x01e4, B:55:0x01e9, B:57:0x01f5), top: B:123:0x019a }] */
    /* JADX WARN: Code duplicated, block: B:57:0x01f5 A[Catch: Exception -> 0x033e, TryCatch #3 {Exception -> 0x033e, blocks: (B:88:0x0338, B:46:0x019a, B:48:0x01ca, B:50:0x01d0, B:59:0x01fb, B:61:0x0201, B:67:0x020f, B:69:0x0222, B:71:0x0227, B:70:0x0225, B:52:0x01d9, B:54:0x01e4, B:55:0x01e9, B:57:0x01f5), top: B:123:0x019a }] */
    /* JADX WARN: Code duplicated, block: B:58:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:65:0x020b  */
    /* JADX WARN: Code duplicated, block: B:67:0x020f A[Catch: Exception -> 0x033e, TryCatch #3 {Exception -> 0x033e, blocks: (B:88:0x0338, B:46:0x019a, B:48:0x01ca, B:50:0x01d0, B:59:0x01fb, B:61:0x0201, B:67:0x020f, B:69:0x0222, B:71:0x0227, B:70:0x0225, B:52:0x01d9, B:54:0x01e4, B:55:0x01e9, B:57:0x01f5), top: B:123:0x019a }] */
    /* JADX WARN: Code duplicated, block: B:69:0x0222 A[Catch: Exception -> 0x033e, TryCatch #3 {Exception -> 0x033e, blocks: (B:88:0x0338, B:46:0x019a, B:48:0x01ca, B:50:0x01d0, B:59:0x01fb, B:61:0x0201, B:67:0x020f, B:69:0x0222, B:71:0x0227, B:70:0x0225, B:52:0x01d9, B:54:0x01e4, B:55:0x01e9, B:57:0x01f5), top: B:123:0x019a }] */
    /* JADX WARN: Code duplicated, block: B:70:0x0225 A[Catch: Exception -> 0x033e, TryCatch #3 {Exception -> 0x033e, blocks: (B:88:0x0338, B:46:0x019a, B:48:0x01ca, B:50:0x01d0, B:59:0x01fb, B:61:0x0201, B:67:0x020f, B:69:0x0222, B:71:0x0227, B:70:0x0225, B:52:0x01d9, B:54:0x01e4, B:55:0x01e9, B:57:0x01f5), top: B:123:0x019a }] */
    /* JADX WARN: Code duplicated, block: B:74:0x02af A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:75:0x02b0  */
    /* JADX WARN: Code duplicated, block: B:7:0x0020  */
    /* JADX WARN: Code duplicated, block: B:80:0x02c5  */
    /* JADX WARN: Code duplicated, block: B:83:0x031a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:84:0x031b  */
    public final Object resolveWatchUrl(String watchUrl, String qualityLabel, String refererUrl, Function1<? super ExtractorLink, Unit> function1, Continuation<? super Unit> continuation) {
        C00171 c00171;
        String refererUrl2;
        String qualityLabel2;
        CharSequence charSequence;
        Object objHttpGetText;
        Map<String, String> map;
        Function1<? super ExtractorLink, Unit> function2;
        String refererUrl3;
        ExtractorLinkType type;
        Object objNewExtractorLink;
        String watchUrl2;
        Function1<? super ExtractorLink, Unit> function3;
        String html;
        String unescaped;
        Regex srcRegex;
        Regex m3u8Regex;
        Regex mp4Regex;
        MatchResult matchResultFind$default;
        MatchResult matchResultFind$default2;
        MatchResult matchResultFind$default3;
        String streamUrl;
        String str;
        boolean z;
        Function1 function4;
        String qualityLabel3;
        Function1<? super ExtractorLink, Unit> function5;
        ExtractorLinkType type2;
        Object objNewExtractorLink2;
        String streamUrl2;
        String watchUrl3;
        Object obj;
        Function1<? super ExtractorLink, Unit> function6;
        List groupValues;
        String qualityLabel4 = qualityLabel;
        String refererUrl4 = refererUrl;
        Function1<? super ExtractorLink, Unit> function7 = function1;
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
        try {
            switch (c00172.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    try {
                        Map<String, String> mapPlus = MapsKt.plus(this.headers, MapsKt.mapOf(TuplesKt.to("Referer", refererUrl4)));
                        charSequence = "m3u8";
                        if (!StringsKt.contains$default(watchUrl, ".m3u8", false, 2, (Object) null)) {
                            try {
                                if (!StringsKt.contains$default(watchUrl, ".mp4", false, 2, (Object) null) && !StringsKt.contains$default(watchUrl, ".mkv", false, 2, (Object) null)) {
                                    try {
                                        c00172.L$0 = watchUrl;
                                        c00172.L$1 = qualityLabel4;
                                        c00172.L$2 = refererUrl4;
                                        c00172.L$3 = function7;
                                        c00172.L$4 = SpillingKt.nullOutSpilledVariable(mapPlus);
                                        c00172.label = 2;
                                        objHttpGetText = httpGetText(watchUrl, mapPlus, c00172);
                                        if (objHttpGetText == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        map = mapPlus;
                                        function2 = function7;
                                        refererUrl3 = refererUrl4;
                                        refererUrl2 = qualityLabel4;
                                        qualityLabel2 = watchUrl;
                                        try {
                                            html = (String) objHttpGetText;
                                            try {
                                                unescaped = StringsKt.replace$default(html, "\\/", "/", false, 4, (Object) null);
                                                srcRegex = new Regex("const\\s+SRC\\s*=\\s*[\"'](https?://[^\"']+)[\"']");
                                                m3u8Regex = new Regex("(https?://[^\\s'\"<>]+\\.m3u8[^\\s'\"<>]*)");
                                                mp4Regex = new Regex("(https?://[^\\s'\"<>]+\\.(?:mp4|mkv)[^\\s'\"<>]*)");
                                                matchResultFind$default = Regex.find$default(srcRegex, unescaped, 0, 2, (Object) null);
                                                if (matchResultFind$default != null || (groupValues = matchResultFind$default.getGroupValues()) == null || (streamUrl = (String) groupValues.get(1)) == null) {
                                                    matchResultFind$default2 = Regex.find$default(m3u8Regex, unescaped, 0, 2, (Object) null);
                                                    if (matchResultFind$default2 != null) {
                                                        streamUrl = matchResultFind$default2.getValue();
                                                    } else {
                                                        matchResultFind$default3 = Regex.find$default(mp4Regex, unescaped, 0, 2, (Object) null);
                                                        if (matchResultFind$default3 != null) {
                                                            streamUrl = matchResultFind$default3.getValue();
                                                        } else {
                                                            streamUrl = null;
                                                        }
                                                    }
                                                }
                                                str = streamUrl;
                                                if (str != null || str.length() == 0) {
                                                    z = true;
                                                } else {
                                                    z = false;
                                                }
                                                if (z) {
                                                    if (StringsKt.contains$default(streamUrl, charSequence, false, 2, (Object) null)) {
                                                        type2 = ExtractorLinkType.M3U8;
                                                    } else {
                                                        type2 = ExtractorLinkType.VIDEO;
                                                    }
                                                    int quality = labelToQuality(refererUrl2);
                                                    ExtractorLinkType type3 = type2;
                                                    C00193 c00193 = new C00193(qualityLabel2, quality, this, null);
                                                    c00172.L$0 = SpillingKt.nullOutSpilledVariable(qualityLabel2);
                                                    c00172.L$1 = SpillingKt.nullOutSpilledVariable(refererUrl2);
                                                    c00172.L$2 = SpillingKt.nullOutSpilledVariable(refererUrl3);
                                                    c00172.L$3 = SpillingKt.nullOutSpilledVariable(function2);
                                                    c00172.L$4 = SpillingKt.nullOutSpilledVariable(map);
                                                    c00172.L$5 = SpillingKt.nullOutSpilledVariable(html);
                                                    c00172.L$6 = SpillingKt.nullOutSpilledVariable(unescaped);
                                                    c00172.L$7 = SpillingKt.nullOutSpilledVariable(srcRegex);
                                                    c00172.L$8 = SpillingKt.nullOutSpilledVariable(m3u8Regex);
                                                    c00172.L$9 = SpillingKt.nullOutSpilledVariable(mp4Regex);
                                                    c00172.L$10 = SpillingKt.nullOutSpilledVariable(streamUrl);
                                                    c00172.L$11 = SpillingKt.nullOutSpilledVariable(type3);
                                                    c00172.L$12 = function2;
                                                    c00172.I$0 = quality;
                                                    c00172.label = 3;
                                                    objNewExtractorLink2 = ExtractorApiKt.newExtractorLink("MovieLinkBD", "MovieLinkBD [" + refererUrl2 + ']', streamUrl, type3, c00193, c00172);
                                                    if (objNewExtractorLink2 == coroutine_suspended) {
                                                        return coroutine_suspended;
                                                    }
                                                    streamUrl2 = qualityLabel2;
                                                    watchUrl3 = refererUrl2;
                                                    obj = objNewExtractorLink2;
                                                    function6 = function2;
                                                    try {
                                                        function6.invoke(obj);
                                                        break;
                                                    } catch (Exception e) {
                                                        refererUrl2 = watchUrl3;
                                                        qualityLabel2 = streamUrl2;
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                                String streamUrl3 = streamUrl;
                                                try {
                                                    function4 = new Function1() { // from class: com.cncverse.MovieLinkBDProvider$$ExternalSyntheticLambda0
                                                        public final Object invoke(Object obj2) {
                                                            return MovieLinkBDProvider.resolveWatchUrl$lambda$0((SubtitleFile) obj2);
                                                        }
                                                    };
                                                    c00172.L$0 = SpillingKt.nullOutSpilledVariable(qualityLabel2);
                                                    c00172.L$1 = SpillingKt.nullOutSpilledVariable(refererUrl2);
                                                    c00172.L$2 = SpillingKt.nullOutSpilledVariable(refererUrl3);
                                                    c00172.L$3 = SpillingKt.nullOutSpilledVariable(function2);
                                                    c00172.L$4 = SpillingKt.nullOutSpilledVariable(map);
                                                    c00172.L$5 = SpillingKt.nullOutSpilledVariable(html);
                                                    c00172.L$6 = SpillingKt.nullOutSpilledVariable(unescaped);
                                                    c00172.L$7 = SpillingKt.nullOutSpilledVariable(srcRegex);
                                                    c00172.L$8 = SpillingKt.nullOutSpilledVariable(m3u8Regex);
                                                    c00172.L$9 = SpillingKt.nullOutSpilledVariable(mp4Regex);
                                                    c00172.L$10 = SpillingKt.nullOutSpilledVariable(streamUrl3);
                                                    c00172.label = 4;
                                                    if (ExtractorApiKt.loadExtractor(qualityLabel2, refererUrl3, function4, function2, c00172) == coroutine_suspended) {
                                                        return coroutine_suspended;
                                                    }
                                                    qualityLabel3 = refererUrl3;
                                                    function5 = function2;
                                                    return Unit.INSTANCE;
                                                } catch (Exception e2) {
                                                    Unit unit = Unit.INSTANCE;
                                                }
                                            } catch (Exception e3) {
                                                return Unit.INSTANCE;
                                            }
                                        } catch (Exception e4) {
                                            return Unit.INSTANCE;
                                        }
                                    } catch (Exception e5) {
                                        return Unit.INSTANCE;
                                    }
                                }
                            } catch (Exception e6) {
                                refererUrl2 = qualityLabel4;
                                qualityLabel2 = watchUrl;
                                return Unit.INSTANCE;
                            }
                        }
                        if (StringsKt.contains$default(watchUrl, charSequence, false, 2, (Object) null)) {
                            type = ExtractorLinkType.M3U8;
                            break;
                        } else {
                            type = ExtractorLinkType.VIDEO;
                        }
                        int quality2 = labelToQuality(qualityLabel4);
                        ExtractorLinkType type4 = type;
                        C00182 c00182 = new C00182(refererUrl4, quality2, mapPlus, null);
                        c00172.L$0 = SpillingKt.nullOutSpilledVariable(watchUrl);
                        c00172.L$1 = SpillingKt.nullOutSpilledVariable(qualityLabel4);
                        c00172.L$2 = SpillingKt.nullOutSpilledVariable(refererUrl4);
                        c00172.L$3 = SpillingKt.nullOutSpilledVariable(function7);
                        c00172.L$4 = SpillingKt.nullOutSpilledVariable(mapPlus);
                        c00172.L$5 = SpillingKt.nullOutSpilledVariable(type4);
                        c00172.L$6 = function7;
                        c00172.I$0 = quality2;
                        c00172.label = 1;
                        objNewExtractorLink = ExtractorApiKt.newExtractorLink("MovieLinkBD", "MovieLinkBD [" + qualityLabel4 + ']', watchUrl, type4, c00182, c00172);
                        if (objNewExtractorLink == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        watchUrl2 = watchUrl;
                        function3 = function7;
                        function7.invoke(objNewExtractorLink);
                        return Unit.INSTANCE;
                    } catch (Exception e7) {
                        refererUrl2 = qualityLabel4;
                        qualityLabel2 = watchUrl;
                    }
                    break;
                case 1:
                    int i = c00172.I$0;
                    Function1<? super ExtractorLink, Unit> function8 = (Function1) c00172.L$6;
                    function3 = (Function1) c00172.L$3;
                    refererUrl4 = (String) c00172.L$2;
                    qualityLabel4 = (String) c00172.L$1;
                    watchUrl2 = (String) c00172.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        function7 = function8;
                        objNewExtractorLink = $result;
                        function7.invoke(objNewExtractorLink);
                        return Unit.INSTANCE;
                    } catch (Exception e8) {
                        refererUrl2 = qualityLabel4;
                        qualityLabel2 = watchUrl2;
                        return Unit.INSTANCE;
                    }
                case 2:
                    Map<String, String> map2 = (Map) c00172.L$4;
                    Function1<? super ExtractorLink, Unit> function9 = (Function1) c00172.L$3;
                    String refererUrl5 = (String) c00172.L$2;
                    String qualityLabel5 = (String) c00172.L$1;
                    String watchUrl4 = (String) c00172.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        map = map2;
                        charSequence = "m3u8";
                        objHttpGetText = $result;
                        function2 = function9;
                        refererUrl3 = refererUrl5;
                        refererUrl2 = qualityLabel5;
                        qualityLabel2 = watchUrl4;
                        html = (String) objHttpGetText;
                        unescaped = StringsKt.replace$default(html, "\\/", "/", false, 4, (Object) null);
                        srcRegex = new Regex("const\\s+SRC\\s*=\\s*[\"'](https?://[^\"']+)[\"']");
                        m3u8Regex = new Regex("(https?://[^\\s'\"<>]+\\.m3u8[^\\s'\"<>]*)");
                        mp4Regex = new Regex("(https?://[^\\s'\"<>]+\\.(?:mp4|mkv)[^\\s'\"<>]*)");
                        matchResultFind$default = Regex.find$default(srcRegex, unescaped, 0, 2, (Object) null);
                        if (matchResultFind$default != null) {
                            matchResultFind$default2 = Regex.find$default(m3u8Regex, unescaped, 0, 2, (Object) null);
                            if (matchResultFind$default2 != null) {
                                streamUrl = matchResultFind$default2.getValue();
                            } else {
                                matchResultFind$default3 = Regex.find$default(mp4Regex, unescaped, 0, 2, (Object) null);
                                if (matchResultFind$default3 != null) {
                                    streamUrl = matchResultFind$default3.getValue();
                                } else {
                                    streamUrl = null;
                                }
                            }
                        } else {
                            matchResultFind$default2 = Regex.find$default(m3u8Regex, unescaped, 0, 2, (Object) null);
                            if (matchResultFind$default2 != null) {
                                streamUrl = matchResultFind$default2.getValue();
                            } else {
                                matchResultFind$default3 = Regex.find$default(mp4Regex, unescaped, 0, 2, (Object) null);
                                if (matchResultFind$default3 != null) {
                                    streamUrl = matchResultFind$default3.getValue();
                                } else {
                                    streamUrl = null;
                                }
                            }
                        }
                        str = streamUrl;
                        if (str != null) {
                            z = true;
                        } else {
                            z = true;
                        }
                        if (z) {
                            String streamUrl4 = streamUrl;
                            function4 = new Function1() { // from class: com.cncverse.MovieLinkBDProvider$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj2) {
                                    return MovieLinkBDProvider.resolveWatchUrl$lambda$0((SubtitleFile) obj2);
                                }
                            };
                            c00172.L$0 = SpillingKt.nullOutSpilledVariable(qualityLabel2);
                            c00172.L$1 = SpillingKt.nullOutSpilledVariable(refererUrl2);
                            c00172.L$2 = SpillingKt.nullOutSpilledVariable(refererUrl3);
                            c00172.L$3 = SpillingKt.nullOutSpilledVariable(function2);
                            c00172.L$4 = SpillingKt.nullOutSpilledVariable(map);
                            c00172.L$5 = SpillingKt.nullOutSpilledVariable(html);
                            c00172.L$6 = SpillingKt.nullOutSpilledVariable(unescaped);
                            c00172.L$7 = SpillingKt.nullOutSpilledVariable(srcRegex);
                            c00172.L$8 = SpillingKt.nullOutSpilledVariable(m3u8Regex);
                            c00172.L$9 = SpillingKt.nullOutSpilledVariable(mp4Regex);
                            c00172.L$10 = SpillingKt.nullOutSpilledVariable(streamUrl4);
                            c00172.label = 4;
                            if (ExtractorApiKt.loadExtractor(qualityLabel2, refererUrl3, function4, function2, c00172) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            qualityLabel3 = refererUrl3;
                            function5 = function2;
                            return Unit.INSTANCE;
                        }
                        if (StringsKt.contains$default(streamUrl, charSequence, false, 2, (Object) null)) {
                            type2 = ExtractorLinkType.M3U8;
                        } else {
                            type2 = ExtractorLinkType.VIDEO;
                        }
                        int quality3 = labelToQuality(refererUrl2);
                        ExtractorLinkType type5 = type2;
                        C00193 c00194 = new C00193(qualityLabel2, quality3, this, null);
                        c00172.L$0 = SpillingKt.nullOutSpilledVariable(qualityLabel2);
                        c00172.L$1 = SpillingKt.nullOutSpilledVariable(refererUrl2);
                        c00172.L$2 = SpillingKt.nullOutSpilledVariable(refererUrl3);
                        c00172.L$3 = SpillingKt.nullOutSpilledVariable(function2);
                        c00172.L$4 = SpillingKt.nullOutSpilledVariable(map);
                        c00172.L$5 = SpillingKt.nullOutSpilledVariable(html);
                        c00172.L$6 = SpillingKt.nullOutSpilledVariable(unescaped);
                        c00172.L$7 = SpillingKt.nullOutSpilledVariable(srcRegex);
                        c00172.L$8 = SpillingKt.nullOutSpilledVariable(m3u8Regex);
                        c00172.L$9 = SpillingKt.nullOutSpilledVariable(mp4Regex);
                        c00172.L$10 = SpillingKt.nullOutSpilledVariable(streamUrl);
                        c00172.L$11 = SpillingKt.nullOutSpilledVariable(type5);
                        c00172.L$12 = function2;
                        c00172.I$0 = quality3;
                        c00172.label = 3;
                        objNewExtractorLink2 = ExtractorApiKt.newExtractorLink("MovieLinkBD", "MovieLinkBD [" + refererUrl2 + ']', streamUrl, type5, c00194, c00172);
                        if (objNewExtractorLink2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        streamUrl2 = qualityLabel2;
                        watchUrl3 = refererUrl2;
                        obj = objNewExtractorLink2;
                        function6 = function2;
                        function6.invoke(obj);
                        return Unit.INSTANCE;
                    } catch (Exception e9) {
                        return Unit.INSTANCE;
                    }
                case 3:
                    int i2 = c00172.I$0;
                    function6 = (Function1) c00172.L$12;
                    watchUrl3 = (String) c00172.L$1;
                    streamUrl2 = (String) c00172.L$0;
                    ResultKt.throwOnFailure($result);
                    obj = $result;
                    function6.invoke(obj);
                    return Unit.INSTANCE;
                case 4:
                    function5 = (Function1) c00172.L$3;
                    qualityLabel3 = (String) c00172.L$2;
                    String qualityLabel6 = (String) c00172.L$1;
                    String watchUrl5 = (String) c00172.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                    } catch (Exception e10) {
                        refererUrl2 = qualityLabel6;
                        qualityLabel2 = watchUrl5;
                        Unit unit2 = Unit.INSTANCE;
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Exception e11) {
            refererUrl2 = qualityLabel4;
            qualityLabel2 = watchUrl;
        }
    }

    /* JADX INFO: renamed from: com.cncverse.MovieLinkBDProvider$resolveWatchUrl$2 */
    /* JADX INFO: compiled from: MovieLinkBDProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.MovieLinkBDProvider$resolveWatchUrl$2", f = "MovieLinkBDProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00182 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $quality;
        final /* synthetic */ String $refererUrl;
        final /* synthetic */ Map<String, String> $reqHeaders;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00182(String str, int i, Map<String, String> map, Continuation<? super C00182> continuation) {
            super(2, continuation);
            this.$refererUrl = str;
            this.$quality = i;
            this.$reqHeaders = map;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00182 = new C00182(this.$refererUrl, this.$quality, this.$reqHeaders, continuation);
            c00182.L$0 = obj;
            return c00182;
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
                    $this$newExtractorLink.setReferer(this.$refererUrl);
                    $this$newExtractorLink.setQuality(this.$quality);
                    $this$newExtractorLink.setHeaders(this.$reqHeaders);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.cncverse.MovieLinkBDProvider$resolveWatchUrl$3 */
    /* JADX INFO: compiled from: MovieLinkBDProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.MovieLinkBDProvider$resolveWatchUrl$3", f = "MovieLinkBDProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00193 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $quality;
        final /* synthetic */ String $watchUrl;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MovieLinkBDProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00193(String str, int i, MovieLinkBDProvider movieLinkBDProvider, Continuation<? super C00193> continuation) {
            super(2, continuation);
            this.$watchUrl = str;
            this.$quality = i;
            this.this$0 = movieLinkBDProvider;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00193 = new C00193(this.$watchUrl, this.$quality, this.this$0, continuation);
            c00193.L$0 = obj;
            return c00193;
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
                    $this$newExtractorLink.setReferer(this.$watchUrl);
                    $this$newExtractorLink.setQuality(this.$quality);
                    $this$newExtractorLink.setHeaders(MapsKt.plus(this.this$0.headers, MapsKt.mapOf(TuplesKt.to("Referer", this.$watchUrl))));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit resolveWatchUrl$lambda$0(SubtitleFile it) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:100:0x0526  */
    /* JADX WARN: Code duplicated, block: B:102:0x0529 A[Catch: Exception -> 0x078f, TryCatch #18 {Exception -> 0x078f, blocks: (B:86:0x04ea, B:88:0x04f0, B:90:0x04f6, B:94:0x0501, B:96:0x050e, B:97:0x0513, B:99:0x0521, B:102:0x0529, B:104:0x0536, B:106:0x053c, B:108:0x0542, B:114:0x054e, B:118:0x056a, B:120:0x0585, B:141:0x06c8, B:123:0x059c, B:125:0x05b2, B:127:0x05b7, B:126:0x05b5, B:117:0x0559), top: B:309:0x04ea }] */
    /* JADX WARN: Code duplicated, block: B:104:0x0536 A[Catch: Exception -> 0x078f, TryCatch #18 {Exception -> 0x078f, blocks: (B:86:0x04ea, B:88:0x04f0, B:90:0x04f6, B:94:0x0501, B:96:0x050e, B:97:0x0513, B:99:0x0521, B:102:0x0529, B:104:0x0536, B:106:0x053c, B:108:0x0542, B:114:0x054e, B:118:0x056a, B:120:0x0585, B:141:0x06c8, B:123:0x059c, B:125:0x05b2, B:127:0x05b7, B:126:0x05b5, B:117:0x0559), top: B:309:0x04ea }] */
    /* JADX WARN: Code duplicated, block: B:105:0x053b  */
    /* JADX WARN: Code duplicated, block: B:108:0x0542 A[Catch: Exception -> 0x078f, TryCatch #18 {Exception -> 0x078f, blocks: (B:86:0x04ea, B:88:0x04f0, B:90:0x04f6, B:94:0x0501, B:96:0x050e, B:97:0x0513, B:99:0x0521, B:102:0x0529, B:104:0x0536, B:106:0x053c, B:108:0x0542, B:114:0x054e, B:118:0x056a, B:120:0x0585, B:141:0x06c8, B:123:0x059c, B:125:0x05b2, B:127:0x05b7, B:126:0x05b5, B:117:0x0559), top: B:309:0x04ea }] */
    /* JADX WARN: Code duplicated, block: B:112:0x054b  */
    /* JADX WARN: Code duplicated, block: B:114:0x054e A[Catch: Exception -> 0x078f, TryCatch #18 {Exception -> 0x078f, blocks: (B:86:0x04ea, B:88:0x04f0, B:90:0x04f6, B:94:0x0501, B:96:0x050e, B:97:0x0513, B:99:0x0521, B:102:0x0529, B:104:0x0536, B:106:0x053c, B:108:0x0542, B:114:0x054e, B:118:0x056a, B:120:0x0585, B:141:0x06c8, B:123:0x059c, B:125:0x05b2, B:127:0x05b7, B:126:0x05b5, B:117:0x0559), top: B:309:0x04ea }] */
    /* JADX WARN: Code duplicated, block: B:116:0x0557  */
    /* JADX WARN: Code duplicated, block: B:117:0x0559 A[Catch: Exception -> 0x078f, TryCatch #18 {Exception -> 0x078f, blocks: (B:86:0x04ea, B:88:0x04f0, B:90:0x04f6, B:94:0x0501, B:96:0x050e, B:97:0x0513, B:99:0x0521, B:102:0x0529, B:104:0x0536, B:106:0x053c, B:108:0x0542, B:114:0x054e, B:118:0x056a, B:120:0x0585, B:141:0x06c8, B:123:0x059c, B:125:0x05b2, B:127:0x05b7, B:126:0x05b5, B:117:0x0559), top: B:309:0x04ea }] */
    /* JADX WARN: Code duplicated, block: B:120:0x0585 A[Catch: Exception -> 0x078f, TryCatch #18 {Exception -> 0x078f, blocks: (B:86:0x04ea, B:88:0x04f0, B:90:0x04f6, B:94:0x0501, B:96:0x050e, B:97:0x0513, B:99:0x0521, B:102:0x0529, B:104:0x0536, B:106:0x053c, B:108:0x0542, B:114:0x054e, B:118:0x056a, B:120:0x0585, B:141:0x06c8, B:123:0x059c, B:125:0x05b2, B:127:0x05b7, B:126:0x05b5, B:117:0x0559), top: B:309:0x04ea }] */
    /* JADX WARN: Code duplicated, block: B:140:0x06c3 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:143:0x0755 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:144:0x0756  */
    /* JADX WARN: Code duplicated, block: B:149:0x0775  */
    /* JADX WARN: Code duplicated, block: B:158:0x07af  */
    /* JADX WARN: Code duplicated, block: B:162:0x07cd  */
    /* JADX WARN: Code duplicated, block: B:165:0x07df  */
    /* JADX WARN: Code duplicated, block: B:166:0x07e1 A[Catch: Exception -> 0x087a, TryCatch #28 {Exception -> 0x087a, blocks: (B:163:0x07cf, B:167:0x07f2, B:166:0x07e1), top: B:327:0x07cf }] */
    /* JADX WARN: Code duplicated, block: B:172:0x0852 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:173:0x0853  */
    /* JADX WARN: Code duplicated, block: B:182:0x0887  */
    /* JADX WARN: Code duplicated, block: B:191:0x08a7 A[Catch: Exception -> 0x0b28, TRY_ENTER, TRY_LEAVE, TryCatch #12 {Exception -> 0x0b28, blocks: (B:183:0x0890, B:197:0x08b6, B:206:0x08ce, B:210:0x08e7, B:212:0x0904, B:215:0x091a, B:224:0x09ac, B:229:0x09c5, B:228:0x09c3, B:209:0x08d6, B:191:0x08a7), top: B:298:0x0890 }] */
    /* JADX WARN: Code duplicated, block: B:193:0x08af A[Catch: Exception -> 0x08a1, TRY_ENTER, TRY_LEAVE, TryCatch #17 {Exception -> 0x08a1, blocks: (B:186:0x089a, B:199:0x08bb, B:217:0x0920, B:219:0x0930, B:226:0x09c0, B:193:0x08af), top: B:308:0x089a }] */
    /* JADX WARN: Code duplicated, block: B:195:0x08b4  */
    /* JADX WARN: Code duplicated, block: B:199:0x08bb A[Catch: Exception -> 0x08a1, TRY_ENTER, TRY_LEAVE, TryCatch #17 {Exception -> 0x08a1, blocks: (B:186:0x089a, B:199:0x08bb, B:217:0x0920, B:219:0x0930, B:226:0x09c0, B:193:0x08af), top: B:308:0x089a }] */
    /* JADX WARN: Code duplicated, block: B:203:0x08c5  */
    /* JADX WARN: Code duplicated, block: B:205:0x08c9  */
    /* JADX WARN: Code duplicated, block: B:208:0x08d4  */
    /* JADX WARN: Code duplicated, block: B:209:0x08d6 A[Catch: Exception -> 0x0b28, TryCatch #12 {Exception -> 0x0b28, blocks: (B:183:0x0890, B:197:0x08b6, B:206:0x08ce, B:210:0x08e7, B:212:0x0904, B:215:0x091a, B:224:0x09ac, B:229:0x09c5, B:228:0x09c3, B:209:0x08d6, B:191:0x08a7), top: B:298:0x0890 }] */
    /* JADX WARN: Code duplicated, block: B:212:0x0904 A[Catch: Exception -> 0x0b28, TryCatch #12 {Exception -> 0x0b28, blocks: (B:183:0x0890, B:197:0x08b6, B:206:0x08ce, B:210:0x08e7, B:212:0x0904, B:215:0x091a, B:224:0x09ac, B:229:0x09c5, B:228:0x09c3, B:209:0x08d6, B:191:0x08a7), top: B:298:0x0890 }] */
    /* JADX WARN: Code duplicated, block: B:239:0x0a8e A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:242:0x0ae9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:243:0x0aea  */
    /* JADX WARN: Code duplicated, block: B:251:0x0b18  */
    /* JADX WARN: Code duplicated, block: B:302:0x0419 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:308:0x089a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x03f3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:71:0x03f4  */
    /* JADX WARN: Code duplicated, block: B:78:0x0432  */
    /* JADX WARN: Code duplicated, block: B:79:0x0434 A[Catch: Exception -> 0x079f, TryCatch #10 {Exception -> 0x079f, blocks: (B:76:0x042c, B:80:0x0445, B:79:0x0434), top: B:294:0x042c }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:82:0x0496 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:83:0x0497  */
    /* JADX WARN: Code duplicated, block: B:88:0x04f0 A[Catch: Exception -> 0x078f, TryCatch #18 {Exception -> 0x078f, blocks: (B:86:0x04ea, B:88:0x04f0, B:90:0x04f6, B:94:0x0501, B:96:0x050e, B:97:0x0513, B:99:0x0521, B:102:0x0529, B:104:0x0536, B:106:0x053c, B:108:0x0542, B:114:0x054e, B:118:0x056a, B:120:0x0585, B:141:0x06c8, B:123:0x059c, B:125:0x05b2, B:127:0x05b7, B:126:0x05b5, B:117:0x0559), top: B:309:0x04ea }] */
    /* JADX WARN: Code duplicated, block: B:93:0x0500 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:96:0x050e A[Catch: Exception -> 0x078f, TryCatch #18 {Exception -> 0x078f, blocks: (B:86:0x04ea, B:88:0x04f0, B:90:0x04f6, B:94:0x0501, B:96:0x050e, B:97:0x0513, B:99:0x0521, B:102:0x0529, B:104:0x0536, B:106:0x053c, B:108:0x0542, B:114:0x054e, B:118:0x056a, B:120:0x0585, B:141:0x06c8, B:123:0x059c, B:125:0x05b2, B:127:0x05b7, B:126:0x05b5, B:117:0x0559), top: B:309:0x04ea }] */
    /* JADX WARN: Code duplicated, block: B:97:0x0513 A[Catch: Exception -> 0x078f, TryCatch #18 {Exception -> 0x078f, blocks: (B:86:0x04ea, B:88:0x04f0, B:90:0x04f6, B:94:0x0501, B:96:0x050e, B:97:0x0513, B:99:0x0521, B:102:0x0529, B:104:0x0536, B:106:0x053c, B:108:0x0542, B:114:0x054e, B:118:0x056a, B:120:0x0585, B:141:0x06c8, B:123:0x059c, B:125:0x05b2, B:127:0x05b7, B:126:0x05b5, B:117:0x0559), top: B:309:0x04ea }] */
    /* JADX WARN: Code duplicated, block: B:99:0x0521 A[Catch: Exception -> 0x078f, TryCatch #18 {Exception -> 0x078f, blocks: (B:86:0x04ea, B:88:0x04f0, B:90:0x04f6, B:94:0x0501, B:96:0x050e, B:97:0x0513, B:99:0x0521, B:102:0x0529, B:104:0x0536, B:106:0x053c, B:108:0x0542, B:114:0x054e, B:118:0x056a, B:120:0x0585, B:141:0x06c8, B:123:0x059c, B:125:0x05b2, B:127:0x05b7, B:126:0x05b5, B:117:0x0559), top: B:309:0x04ea }] */
    /* JADX WARN: Not initialized variable reg: 12, insn: 0x017e: MOVE (r15 I:??[OBJECT, ARRAY] A[D('qualityLabel' java.lang.String)]) = (r12 I:??[OBJECT, ARRAY] A[D('callback' kotlin.jvm.functions.Function1)]), block:B:27:0x0176 */
    /* JADX WARN: Not initialized variable reg: 15, insn: 0x017b: MOVE (r2 I:??[OBJECT, ARRAY]) = (r15 I:??[OBJECT, ARRAY] A[D('qualityLabel' java.lang.String)]), block:B:27:0x0176 */
    /* JADX WARN: Not initialized variable reg: 17, insn: 0x017c: MOVE (r8 I:??[OBJECT, ARRAY]) = (r17 I:??[OBJECT, ARRAY] A[D('getWatchUrl' java.lang.String)]), block:B:27:0x0176 */
    public final Object resolveGetWatch(String getWatchUrl, String qualityLabel, String refererUrl, Function1<? super ExtractorLink, Unit> function1, Continuation<? super Unit> continuation) {
        C00141 c00141;
        String qualityLabel2;
        String qualityLabel3;
        String getWatchUrl2;
        String getWatchUrl3;
        Function1<? super ExtractorLink, Unit> function2;
        Function1<? super ExtractorLink, Unit> function3;
        String qualityLabel4;
        String refererUrl2;
        Object obj;
        Function1<? super ExtractorLink, Unit> function4;
        String href;
        String base;
        String html;
        Map<String, String> mapPlus;
        Function1<? super ExtractorLink, Unit> function5;
        Object objHttpGetText;
        Map<String, String> map;
        String base2;
        Object obj2;
        Function1<? super ExtractorLink, Unit> function6;
        Map<String, String> map2;
        Document doc;
        String html2;
        Element watchAnchor;
        String href2;
        String watchUrl;
        String fixedWatchUrl;
        Map<String, String> mapPlus2;
        Object objHttpGetText2;
        Element watchAnchor2;
        String href3;
        String watchUrl2;
        String watchUrl3;
        Map<String, String> map3;
        Object obj3;
        String href4;
        Document doc2;
        Map<String, String> map4;
        Function1<? super ExtractorLink, Unit> function7;
        CharSequence charSequence;
        String videoSrc;
        Object obj4;
        Map<String, String> map5;
        Element watchAnchor3;
        Function1<? super ExtractorLink, Unit> function8;
        Document doc3;
        String fixedWatchUrl2;
        String qualityLabel5;
        String html3;
        Element fileAnchor;
        MovieLinkBDProvider movieLinkBDProvider;
        String qualityLabel6;
        String qualityLabel7;
        Map<String, String> map6;
        Element elementSelectFirst;
        String videoSrc2;
        String str;
        boolean z;
        String str2;
        String resolvedUrl;
        String fixedResolvedUrl;
        String videoSrc3;
        Object base3;
        Element watchAnchor4;
        Map<String, String> map7;
        String getWatchUrl4;
        Function1<? super ExtractorLink, Unit> function9;
        Element watchAnchor5;
        String refererUrl3;
        Object objNewExtractorLink;
        String fixedResolvedUrl2;
        Element fileAnchor2;
        String resolvedUrl2;
        Function1<? super ExtractorLink, Unit> function10;
        Object $result;
        String refererUrl4;
        String getWatchUrl5;
        String getWatchUrl6;
        Map<String, String> map8;
        String getWatchUrl7;
        Function1<? super ExtractorLink, Unit> function11;
        String refererUrl5;
        String qualityLabel8;
        Element elementSelectFirst2;
        String href5;
        String fileUrl;
        String fixedFileUrl;
        String getWatchUrl8;
        Function1<? super ExtractorLink, Unit> function12;
        String qualityLabel9;
        String getWatchUrl9;
        Function1<? super ExtractorLink, Unit> function13;
        String refererUrl6;
        String qualityLabel10;
        String watchHtml;
        String unescapedWatchHtml;
        Regex srcRegex;
        Regex watchRegex;
        Regex m3u8Regex;
        Map<String, String> map9;
        Regex mp4Regex;
        Document doc4;
        String getWatchUrl10;
        MatchResult matchResultFind$default;
        String streamUrl;
        String str3;
        boolean z2;
        String str4;
        String resolvedUrl3;
        String fixedStreamUrl;
        String streamUrl2;
        String base4;
        String qualityLabel11;
        String resolvedUrl4;
        String getWatchUrl11;
        String qualityLabel12;
        String refererUrl7;
        Function1<? super ExtractorLink, Unit> function14;
        MatchResult matchResultFind$default2;
        MatchResult matchResultFind$default3;
        MatchResult matchResultFind$default4;
        List groupValues;
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
        Object $result2 = c00142.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        String str5 = "m3u8";
        try {
            switch (c00142.label) {
                case 0:
                    ResultKt.throwOnFailure($result2);
                    try {
                        c00142.L$0 = getWatchUrl;
                        try {
                            c00142.L$1 = qualityLabel;
                            try {
                                c00142.L$2 = refererUrl;
                                function3 = function1;
                                try {
                                    c00142.L$3 = function3;
                                    c00142.label = 1;
                                    Object base5 = getBase(c00142);
                                    if (base5 == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    qualityLabel4 = qualityLabel;
                                    refererUrl2 = refererUrl;
                                    obj = base5;
                                    function4 = function3;
                                    href = getWatchUrl;
                                    try {
                                        base = (String) obj;
                                        html = refererUrl2;
                                        try {
                                            mapPlus = MapsKt.plus(this.headers, MapsKt.mapOf(TuplesKt.to("Referer", refererUrl2)));
                                            c00142.L$0 = href;
                                            c00142.L$1 = qualityLabel4;
                                            c00142.L$2 = SpillingKt.nullOutSpilledVariable(html);
                                            c00142.L$3 = function4;
                                            c00142.L$4 = base;
                                            function5 = function4;
                                            try {
                                                c00142.L$5 = SpillingKt.nullOutSpilledVariable(mapPlus);
                                                c00142.label = 2;
                                                objHttpGetText = httpGetText(href, mapPlus, c00142);
                                                if (objHttpGetText == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                map = mapPlus;
                                                base2 = base;
                                                obj2 = objHttpGetText;
                                                function6 = function5;
                                                try {
                                                    String html4 = (String) obj2;
                                                    map2 = map;
                                                    doc = Jsoup.parse(html4, href);
                                                    html2 = html4;
                                                    watchAnchor = doc.selectFirst("a[href*='/watch/']");
                                                    if (watchAnchor == null) {
                                                        charSequence = "mcloud";
                                                        videoSrc = "xcloud";
                                                        obj4 = coroutine_suspended;
                                                        map5 = map2;
                                                        watchAnchor3 = watchAnchor;
                                                        function8 = function6;
                                                        doc3 = doc;
                                                        fixedWatchUrl2 = base2;
                                                        qualityLabel5 = qualityLabel4;
                                                        html3 = html2;
                                                        fileAnchor = doc3.selectFirst("a[href*='/file/']");
                                                        if (fileAnchor == null) {
                                                            href5 = fileAnchor.attr("href");
                                                            Map<String, String> map10 = map5;
                                                            if (StringsKt.startsWith$default(href5, "http", false, 2, (Object) null)) {
                                                                fileUrl = href5;
                                                            } else {
                                                                fileUrl = fixedWatchUrl2 + href5;
                                                            }
                                                            fixedFileUrl = fixUrlDomain(fileUrl, fixedWatchUrl2);
                                                            c00142.L$0 = SpillingKt.nullOutSpilledVariable(href);
                                                            c00142.L$1 = SpillingKt.nullOutSpilledVariable(qualityLabel5);
                                                            c00142.L$2 = SpillingKt.nullOutSpilledVariable(html);
                                                            c00142.L$3 = SpillingKt.nullOutSpilledVariable(function8);
                                                            c00142.L$4 = SpillingKt.nullOutSpilledVariable(fixedWatchUrl2);
                                                            c00142.L$5 = SpillingKt.nullOutSpilledVariable(map10);
                                                            c00142.L$6 = SpillingKt.nullOutSpilledVariable(html3);
                                                            c00142.L$7 = SpillingKt.nullOutSpilledVariable(doc3);
                                                            c00142.L$8 = SpillingKt.nullOutSpilledVariable(watchAnchor3);
                                                            c00142.L$9 = SpillingKt.nullOutSpilledVariable(fileAnchor);
                                                            c00142.L$10 = SpillingKt.nullOutSpilledVariable(href5);
                                                            c00142.L$11 = SpillingKt.nullOutSpilledVariable(fileUrl);
                                                            c00142.L$12 = SpillingKt.nullOutSpilledVariable(fixedFileUrl);
                                                            c00142.label = 6;
                                                            getWatchUrl8 = href;
                                                            function12 = function8;
                                                            qualityLabel9 = qualityLabel5;
                                                            if (resolveDirectFile(fixedFileUrl, qualityLabel5, getWatchUrl8, function8, c00142) == obj4) {
                                                                return obj4;
                                                            }
                                                            getWatchUrl9 = getWatchUrl8;
                                                            function13 = function12;
                                                            refererUrl6 = html;
                                                            qualityLabel10 = qualityLabel9;
                                                            return Unit.INSTANCE;
                                                        }
                                                        Function1<? super ExtractorLink, Unit> function15 = function8;
                                                        movieLinkBDProvider = this;
                                                        qualityLabel6 = qualityLabel5;
                                                        qualityLabel7 = href;
                                                        function3 = function15;
                                                        map6 = map5;
                                                        elementSelectFirst = doc3.selectFirst("video source, video[src]");
                                                        if (elementSelectFirst != null) {
                                                            videoSrc2 = elementSelectFirst.attr("src");
                                                            if (videoSrc2 == null) {
                                                                elementSelectFirst2 = doc3.selectFirst("iframe[src]");
                                                                if (elementSelectFirst2 != null) {
                                                                    videoSrc2 = elementSelectFirst2.attr("src");
                                                                } else {
                                                                    videoSrc2 = null;
                                                                }
                                                            }
                                                            str = videoSrc2;
                                                            if (str != null) {
                                                                z = true;
                                                            } else {
                                                                z = true;
                                                            }
                                                            if (z) {
                                                                if (StringsKt.startsWith$default(videoSrc2, "http", false, 2, (Object) null)) {
                                                                    str2 = videoSrc2;
                                                                } else {
                                                                    str2 = fixedWatchUrl2 + videoSrc2;
                                                                }
                                                                resolvedUrl = str2;
                                                                fixedResolvedUrl = movieLinkBDProvider.fixUrlDomain(resolvedUrl, fixedWatchUrl2);
                                                                videoSrc3 = videoSrc2;
                                                                base3 = fixedWatchUrl2;
                                                                watchAnchor4 = watchAnchor3;
                                                                getWatchUrl3 = null;
                                                                if (StringsKt.contains$default(fixedResolvedUrl, videoSrc, false, 2, (Object) null)) {
                                                                }
                                                                c00142.L$0 = SpillingKt.nullOutSpilledVariable(qualityLabel7);
                                                                c00142.L$1 = SpillingKt.nullOutSpilledVariable(qualityLabel6);
                                                                c00142.L$2 = SpillingKt.nullOutSpilledVariable(html);
                                                                c00142.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                                                                c00142.L$4 = SpillingKt.nullOutSpilledVariable(base3);
                                                                c00142.L$5 = SpillingKt.nullOutSpilledVariable(map6);
                                                                c00142.L$6 = SpillingKt.nullOutSpilledVariable(html3);
                                                                c00142.L$7 = SpillingKt.nullOutSpilledVariable(doc3);
                                                                c00142.L$8 = SpillingKt.nullOutSpilledVariable(watchAnchor4);
                                                                c00142.L$9 = SpillingKt.nullOutSpilledVariable(fileAnchor);
                                                                c00142.L$10 = SpillingKt.nullOutSpilledVariable(videoSrc3);
                                                                c00142.L$11 = SpillingKt.nullOutSpilledVariable(resolvedUrl);
                                                                c00142.L$12 = SpillingKt.nullOutSpilledVariable(fixedResolvedUrl);
                                                                c00142.label = 7;
                                                                if (movieLinkBDProvider.resolveXCloud(fixedResolvedUrl, qualityLabel6, function3, c00142) == obj4) {
                                                                    return obj4;
                                                                }
                                                                map7 = map6;
                                                                getWatchUrl4 = qualityLabel7;
                                                                function9 = function3;
                                                                watchAnchor5 = watchAnchor4;
                                                                refererUrl3 = html;
                                                                Unit unit = Unit.INSTANCE;
                                                            }
                                                        } else {
                                                            elementSelectFirst2 = doc3.selectFirst("iframe[src]");
                                                            if (elementSelectFirst2 != null) {
                                                                videoSrc2 = elementSelectFirst2.attr("src");
                                                            } else {
                                                                videoSrc2 = null;
                                                            }
                                                            str = videoSrc2;
                                                            if (str != null) {
                                                                z = true;
                                                            } else {
                                                                z = true;
                                                            }
                                                            if (z) {
                                                                if (StringsKt.startsWith$default(videoSrc2, "http", false, 2, (Object) null)) {
                                                                    str2 = videoSrc2;
                                                                } else {
                                                                    str2 = fixedWatchUrl2 + videoSrc2;
                                                                }
                                                                resolvedUrl = str2;
                                                                fixedResolvedUrl = movieLinkBDProvider.fixUrlDomain(resolvedUrl, fixedWatchUrl2);
                                                                videoSrc3 = videoSrc2;
                                                                base3 = fixedWatchUrl2;
                                                                watchAnchor4 = watchAnchor3;
                                                                getWatchUrl3 = null;
                                                                if (StringsKt.contains$default(fixedResolvedUrl, videoSrc, false, 2, (Object) null)) {
                                                                }
                                                                c00142.L$0 = SpillingKt.nullOutSpilledVariable(qualityLabel7);
                                                                c00142.L$1 = SpillingKt.nullOutSpilledVariable(qualityLabel6);
                                                                c00142.L$2 = SpillingKt.nullOutSpilledVariable(html);
                                                                c00142.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                                                                c00142.L$4 = SpillingKt.nullOutSpilledVariable(base3);
                                                                c00142.L$5 = SpillingKt.nullOutSpilledVariable(map6);
                                                                c00142.L$6 = SpillingKt.nullOutSpilledVariable(html3);
                                                                c00142.L$7 = SpillingKt.nullOutSpilledVariable(doc3);
                                                                c00142.L$8 = SpillingKt.nullOutSpilledVariable(watchAnchor4);
                                                                c00142.L$9 = SpillingKt.nullOutSpilledVariable(fileAnchor);
                                                                c00142.L$10 = SpillingKt.nullOutSpilledVariable(videoSrc3);
                                                                c00142.L$11 = SpillingKt.nullOutSpilledVariable(resolvedUrl);
                                                                c00142.L$12 = SpillingKt.nullOutSpilledVariable(fixedResolvedUrl);
                                                                c00142.label = 7;
                                                                if (movieLinkBDProvider.resolveXCloud(fixedResolvedUrl, qualityLabel6, function3, c00142) == obj4) {
                                                                    return obj4;
                                                                }
                                                                map7 = map6;
                                                                getWatchUrl4 = qualityLabel7;
                                                                function9 = function3;
                                                                watchAnchor5 = watchAnchor4;
                                                                refererUrl3 = html;
                                                                Unit unit2 = Unit.INSTANCE;
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                        return Unit.INSTANCE;
                                                    }
                                                    try {
                                                        href2 = watchAnchor.attr("href");
                                                        try {
                                                            if (StringsKt.startsWith$default(href2, "http", false, 2, (Object) null)) {
                                                                watchUrl = href2;
                                                            } else {
                                                                watchUrl = base2 + href2;
                                                            }
                                                            fixedWatchUrl = fixUrlDomain(watchUrl, base2);
                                                            mapPlus2 = MapsKt.plus(this.headers, MapsKt.mapOf(TuplesKt.to("Referer", href)));
                                                            c00142.L$0 = href;
                                                            c00142.L$1 = qualityLabel4;
                                                            c00142.L$2 = SpillingKt.nullOutSpilledVariable(html);
                                                            c00142.L$3 = function6;
                                                            c00142.L$4 = base2;
                                                            c00142.L$5 = SpillingKt.nullOutSpilledVariable(map2);
                                                            c00142.L$6 = SpillingKt.nullOutSpilledVariable(html2);
                                                            c00142.L$7 = doc;
                                                            c00142.L$8 = SpillingKt.nullOutSpilledVariable(watchAnchor);
                                                            c00142.L$9 = SpillingKt.nullOutSpilledVariable(href2);
                                                            c00142.L$10 = SpillingKt.nullOutSpilledVariable(watchUrl);
                                                            c00142.L$11 = fixedWatchUrl;
                                                            c00142.L$12 = SpillingKt.nullOutSpilledVariable(mapPlus2);
                                                            c00142.label = 3;
                                                            objHttpGetText2 = httpGetText(fixedWatchUrl, mapPlus2, c00142);
                                                            if (objHttpGetText2 == coroutine_suspended) {
                                                                return coroutine_suspended;
                                                            }
                                                            watchAnchor2 = watchAnchor;
                                                            href3 = href2;
                                                            watchUrl2 = watchUrl;
                                                            watchUrl3 = fixedWatchUrl;
                                                            map3 = mapPlus2;
                                                            obj3 = objHttpGetText2;
                                                            href4 = base2;
                                                            doc2 = doc;
                                                            map4 = map2;
                                                            function7 = function6;
                                                            qualityLabel3 = qualityLabel4;
                                                            try {
                                                                watchHtml = (String) obj3;
                                                                unescapedWatchHtml = StringsKt.replace$default(watchHtml, "\\/", "/", false, 4, (Object) null);
                                                                srcRegex = new Regex("const\\s+SRC\\s*=\\s*[\"'](https?://[^\"']+)[\"']");
                                                                watchRegex = new Regex("(https?://[^\\s'\"]+/watch/[^\\s'\"]*)");
                                                                map9 = map4;
                                                                m3u8Regex = new Regex("(https?://[^\\s'\"]+\\.m3u8[^\\s'\"]*)");
                                                                doc4 = doc2;
                                                                mp4Regex = new Regex("(https?://[^\\s'\"]+\\.(?:mp4|mkv)[^\\s'\"]*)");
                                                                getWatchUrl10 = href;
                                                                try {
                                                                    matchResultFind$default = Regex.find$default(srcRegex, unescapedWatchHtml, 0, 2, (Object) null);
                                                                    if (matchResultFind$default == null && (groupValues = matchResultFind$default.getGroupValues()) != null && (streamUrl = (String) groupValues.get(1)) != null) {
                                                                        str3 = streamUrl;
                                                                        if (str3 != null) {
                                                                            z2 = true;
                                                                        } else {
                                                                            z2 = true;
                                                                        }
                                                                        if (!z2) {
                                                                            if (StringsKt.startsWith$default(streamUrl, "http", false, 2, (Object) null)) {
                                                                                str4 = streamUrl;
                                                                            } else {
                                                                                str4 = href4 + streamUrl;
                                                                            }
                                                                            resolvedUrl3 = str4;
                                                                            fixedStreamUrl = fixUrlDomain(resolvedUrl3, href4);
                                                                            streamUrl2 = streamUrl;
                                                                            base4 = href4;
                                                                            if (StringsKt.contains$default(fixedStreamUrl, "xcloud", false, 2, (Object) null)) {
                                                                            }
                                                                            c00142.L$0 = SpillingKt.nullOutSpilledVariable(getWatchUrl10);
                                                                            c00142.L$1 = SpillingKt.nullOutSpilledVariable(qualityLabel3);
                                                                            c00142.L$2 = SpillingKt.nullOutSpilledVariable(html);
                                                                            c00142.L$3 = SpillingKt.nullOutSpilledVariable(function7);
                                                                            c00142.L$4 = SpillingKt.nullOutSpilledVariable(base4);
                                                                            c00142.L$5 = SpillingKt.nullOutSpilledVariable(map9);
                                                                            c00142.L$6 = SpillingKt.nullOutSpilledVariable(html2);
                                                                            c00142.L$7 = SpillingKt.nullOutSpilledVariable(doc4);
                                                                            c00142.L$8 = SpillingKt.nullOutSpilledVariable(watchAnchor2);
                                                                            c00142.L$9 = SpillingKt.nullOutSpilledVariable(href3);
                                                                            c00142.L$10 = SpillingKt.nullOutSpilledVariable(watchUrl2);
                                                                            c00142.L$11 = SpillingKt.nullOutSpilledVariable(watchUrl3);
                                                                            c00142.L$12 = SpillingKt.nullOutSpilledVariable(map3);
                                                                            c00142.L$13 = SpillingKt.nullOutSpilledVariable(watchHtml);
                                                                            c00142.L$14 = SpillingKt.nullOutSpilledVariable(unescapedWatchHtml);
                                                                            c00142.L$15 = SpillingKt.nullOutSpilledVariable(srcRegex);
                                                                            c00142.L$16 = SpillingKt.nullOutSpilledVariable(watchRegex);
                                                                            c00142.L$17 = SpillingKt.nullOutSpilledVariable(m3u8Regex);
                                                                            c00142.L$18 = SpillingKt.nullOutSpilledVariable(mp4Regex);
                                                                            c00142.L$19 = SpillingKt.nullOutSpilledVariable(streamUrl2);
                                                                            c00142.L$20 = SpillingKt.nullOutSpilledVariable(resolvedUrl3);
                                                                            c00142.L$21 = SpillingKt.nullOutSpilledVariable(fixedStreamUrl);
                                                                            c00142.label = 4;
                                                                            if (resolveXCloud(fixedStreamUrl, qualityLabel3, function7, c00142) == r34) {
                                                                                return coroutine_suspended;
                                                                            }
                                                                            qualityLabel11 = qualityLabel3;
                                                                            resolvedUrl4 = getWatchUrl10;
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                        String base6 = href4;
                                                                        obj4 = coroutine_suspended;
                                                                        map5 = map9;
                                                                        doc3 = doc4;
                                                                        href = getWatchUrl10;
                                                                        function8 = function7;
                                                                        watchAnchor3 = watchAnchor2;
                                                                        fixedWatchUrl2 = base6;
                                                                        qualityLabel5 = qualityLabel3;
                                                                        html3 = html2;
                                                                        fileAnchor = doc3.selectFirst("a[href*='/file/']");
                                                                        if (fileAnchor == null) {
                                                                            href5 = fileAnchor.attr("href");
                                                                            Map<String, String> map11 = map5;
                                                                            if (StringsKt.startsWith$default(href5, "http", false, 2, (Object) null)) {
                                                                                fileUrl = href5;
                                                                            } else {
                                                                                fileUrl = fixedWatchUrl2 + href5;
                                                                            }
                                                                            fixedFileUrl = fixUrlDomain(fileUrl, fixedWatchUrl2);
                                                                            c00142.L$0 = SpillingKt.nullOutSpilledVariable(href);
                                                                            c00142.L$1 = SpillingKt.nullOutSpilledVariable(qualityLabel5);
                                                                            c00142.L$2 = SpillingKt.nullOutSpilledVariable(html);
                                                                            c00142.L$3 = SpillingKt.nullOutSpilledVariable(function8);
                                                                            c00142.L$4 = SpillingKt.nullOutSpilledVariable(fixedWatchUrl2);
                                                                            c00142.L$5 = SpillingKt.nullOutSpilledVariable(map11);
                                                                            c00142.L$6 = SpillingKt.nullOutSpilledVariable(html3);
                                                                            c00142.L$7 = SpillingKt.nullOutSpilledVariable(doc3);
                                                                            c00142.L$8 = SpillingKt.nullOutSpilledVariable(watchAnchor3);
                                                                            c00142.L$9 = SpillingKt.nullOutSpilledVariable(fileAnchor);
                                                                            c00142.L$10 = SpillingKt.nullOutSpilledVariable(href5);
                                                                            c00142.L$11 = SpillingKt.nullOutSpilledVariable(fileUrl);
                                                                            c00142.L$12 = SpillingKt.nullOutSpilledVariable(fixedFileUrl);
                                                                            c00142.label = 6;
                                                                            getWatchUrl8 = href;
                                                                            function12 = function8;
                                                                            qualityLabel9 = qualityLabel5;
                                                                            if (resolveDirectFile(fixedFileUrl, qualityLabel5, getWatchUrl8, function8, c00142) == obj4) {
                                                                                return obj4;
                                                                            }
                                                                            getWatchUrl9 = getWatchUrl8;
                                                                            function13 = function12;
                                                                            refererUrl6 = html;
                                                                            qualityLabel10 = qualityLabel9;
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                        Function1<? super ExtractorLink, Unit> function16 = function8;
                                                                        movieLinkBDProvider = this;
                                                                        qualityLabel6 = qualityLabel5;
                                                                        qualityLabel7 = href;
                                                                        function3 = function16;
                                                                        map6 = map5;
                                                                        elementSelectFirst = doc3.selectFirst("video source, video[src]");
                                                                        if (elementSelectFirst != null) {
                                                                            videoSrc2 = elementSelectFirst.attr("src");
                                                                            if (videoSrc2 == null) {
                                                                                elementSelectFirst2 = doc3.selectFirst("iframe[src]");
                                                                                if (elementSelectFirst2 != null) {
                                                                                    videoSrc2 = elementSelectFirst2.attr("src");
                                                                                } else {
                                                                                    videoSrc2 = null;
                                                                                }
                                                                            }
                                                                            str = videoSrc2;
                                                                            if (str != null) {
                                                                                z = true;
                                                                            } else {
                                                                                z = true;
                                                                            }
                                                                            if (z) {
                                                                                if (StringsKt.startsWith$default(videoSrc2, "http", false, 2, (Object) null)) {
                                                                                    str2 = videoSrc2;
                                                                                } else {
                                                                                    str2 = fixedWatchUrl2 + videoSrc2;
                                                                                }
                                                                                resolvedUrl = str2;
                                                                                fixedResolvedUrl = movieLinkBDProvider.fixUrlDomain(resolvedUrl, fixedWatchUrl2);
                                                                                videoSrc3 = videoSrc2;
                                                                                base3 = fixedWatchUrl2;
                                                                                watchAnchor4 = watchAnchor3;
                                                                                getWatchUrl3 = null;
                                                                                if (StringsKt.contains$default(fixedResolvedUrl, videoSrc, false, 2, (Object) null)) {
                                                                                }
                                                                                c00142.L$0 = SpillingKt.nullOutSpilledVariable(qualityLabel7);
                                                                                c00142.L$1 = SpillingKt.nullOutSpilledVariable(qualityLabel6);
                                                                                c00142.L$2 = SpillingKt.nullOutSpilledVariable(html);
                                                                                c00142.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                                                                                c00142.L$4 = SpillingKt.nullOutSpilledVariable(base3);
                                                                                c00142.L$5 = SpillingKt.nullOutSpilledVariable(map6);
                                                                                c00142.L$6 = SpillingKt.nullOutSpilledVariable(html3);
                                                                                c00142.L$7 = SpillingKt.nullOutSpilledVariable(doc3);
                                                                                c00142.L$8 = SpillingKt.nullOutSpilledVariable(watchAnchor4);
                                                                                c00142.L$9 = SpillingKt.nullOutSpilledVariable(fileAnchor);
                                                                                c00142.L$10 = SpillingKt.nullOutSpilledVariable(videoSrc3);
                                                                                c00142.L$11 = SpillingKt.nullOutSpilledVariable(resolvedUrl);
                                                                                c00142.L$12 = SpillingKt.nullOutSpilledVariable(fixedResolvedUrl);
                                                                                c00142.label = 7;
                                                                                if (movieLinkBDProvider.resolveXCloud(fixedResolvedUrl, qualityLabel6, function3, c00142) == obj4) {
                                                                                    return obj4;
                                                                                }
                                                                                map7 = map6;
                                                                                getWatchUrl4 = qualityLabel7;
                                                                                function9 = function3;
                                                                                watchAnchor5 = watchAnchor4;
                                                                                refererUrl3 = html;
                                                                                Unit unit3 = Unit.INSTANCE;
                                                                            }
                                                                        } else {
                                                                            elementSelectFirst2 = doc3.selectFirst("iframe[src]");
                                                                            if (elementSelectFirst2 != null) {
                                                                                videoSrc2 = elementSelectFirst2.attr("src");
                                                                            } else {
                                                                                videoSrc2 = null;
                                                                            }
                                                                            str = videoSrc2;
                                                                            if (str != null) {
                                                                                z = true;
                                                                            } else {
                                                                                z = true;
                                                                            }
                                                                            if (z) {
                                                                                if (StringsKt.startsWith$default(videoSrc2, "http", false, 2, (Object) null)) {
                                                                                    str2 = videoSrc2;
                                                                                } else {
                                                                                    str2 = fixedWatchUrl2 + videoSrc2;
                                                                                }
                                                                                resolvedUrl = str2;
                                                                                fixedResolvedUrl = movieLinkBDProvider.fixUrlDomain(resolvedUrl, fixedWatchUrl2);
                                                                                videoSrc3 = videoSrc2;
                                                                                base3 = fixedWatchUrl2;
                                                                                watchAnchor4 = watchAnchor3;
                                                                                getWatchUrl3 = null;
                                                                                if (StringsKt.contains$default(fixedResolvedUrl, videoSrc, false, 2, (Object) null)) {
                                                                                }
                                                                                c00142.L$0 = SpillingKt.nullOutSpilledVariable(qualityLabel7);
                                                                                c00142.L$1 = SpillingKt.nullOutSpilledVariable(qualityLabel6);
                                                                                c00142.L$2 = SpillingKt.nullOutSpilledVariable(html);
                                                                                c00142.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                                                                                c00142.L$4 = SpillingKt.nullOutSpilledVariable(base3);
                                                                                c00142.L$5 = SpillingKt.nullOutSpilledVariable(map6);
                                                                                c00142.L$6 = SpillingKt.nullOutSpilledVariable(html3);
                                                                                c00142.L$7 = SpillingKt.nullOutSpilledVariable(doc3);
                                                                                c00142.L$8 = SpillingKt.nullOutSpilledVariable(watchAnchor4);
                                                                                c00142.L$9 = SpillingKt.nullOutSpilledVariable(fileAnchor);
                                                                                c00142.L$10 = SpillingKt.nullOutSpilledVariable(videoSrc3);
                                                                                c00142.L$11 = SpillingKt.nullOutSpilledVariable(resolvedUrl);
                                                                                c00142.L$12 = SpillingKt.nullOutSpilledVariable(fixedResolvedUrl);
                                                                                c00142.label = 7;
                                                                                if (movieLinkBDProvider.resolveXCloud(fixedResolvedUrl, qualityLabel6, function3, c00142) == obj4) {
                                                                                    return obj4;
                                                                                }
                                                                                map7 = map6;
                                                                                getWatchUrl4 = qualityLabel7;
                                                                                function9 = function3;
                                                                                watchAnchor5 = watchAnchor4;
                                                                                refererUrl3 = html;
                                                                                Unit unit4 = Unit.INSTANCE;
                                                                            }
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                    matchResultFind$default2 = Regex.find$default(watchRegex, unescapedWatchHtml, 0, 2, (Object) null);
                                                                    if (matchResultFind$default2 != null) {
                                                                        streamUrl = matchResultFind$default2.getValue();
                                                                    } else {
                                                                        matchResultFind$default3 = Regex.find$default(m3u8Regex, unescapedWatchHtml, 0, 2, (Object) null);
                                                                        if (matchResultFind$default3 != null) {
                                                                            streamUrl = matchResultFind$default3.getValue();
                                                                        } else {
                                                                            streamUrl = null;
                                                                        }
                                                                        if (streamUrl == null) {
                                                                            matchResultFind$default4 = Regex.find$default(mp4Regex, unescapedWatchHtml, 0, 2, (Object) null);
                                                                            if (matchResultFind$default4 != null) {
                                                                                streamUrl = matchResultFind$default4.getValue();
                                                                            } else {
                                                                                streamUrl = null;
                                                                            }
                                                                        }
                                                                    }
                                                                    str3 = streamUrl;
                                                                    if (str3 != null || str3.length() == 0) {
                                                                        z2 = true;
                                                                    } else {
                                                                        z2 = false;
                                                                    }
                                                                    if (!z2) {
                                                                        if (StringsKt.startsWith$default(streamUrl, "http", false, 2, (Object) null)) {
                                                                            str4 = streamUrl;
                                                                        } else {
                                                                            str4 = href4 + streamUrl;
                                                                        }
                                                                        resolvedUrl3 = str4;
                                                                        fixedStreamUrl = fixUrlDomain(resolvedUrl3, href4);
                                                                        streamUrl2 = streamUrl;
                                                                        base4 = href4;
                                                                        if (!StringsKt.contains$default(fixedStreamUrl, "xcloud", false, 2, (Object) null) || StringsKt.contains$default(fixedStreamUrl, "mcloud", false, 2, (Object) null)) {
                                                                            c00142.L$0 = SpillingKt.nullOutSpilledVariable(getWatchUrl10);
                                                                            c00142.L$1 = SpillingKt.nullOutSpilledVariable(qualityLabel3);
                                                                            c00142.L$2 = SpillingKt.nullOutSpilledVariable(html);
                                                                            c00142.L$3 = SpillingKt.nullOutSpilledVariable(function7);
                                                                            c00142.L$4 = SpillingKt.nullOutSpilledVariable(base4);
                                                                            c00142.L$5 = SpillingKt.nullOutSpilledVariable(map9);
                                                                            c00142.L$6 = SpillingKt.nullOutSpilledVariable(html2);
                                                                            c00142.L$7 = SpillingKt.nullOutSpilledVariable(doc4);
                                                                            c00142.L$8 = SpillingKt.nullOutSpilledVariable(watchAnchor2);
                                                                            c00142.L$9 = SpillingKt.nullOutSpilledVariable(href3);
                                                                            c00142.L$10 = SpillingKt.nullOutSpilledVariable(watchUrl2);
                                                                            c00142.L$11 = SpillingKt.nullOutSpilledVariable(watchUrl3);
                                                                            c00142.L$12 = SpillingKt.nullOutSpilledVariable(map3);
                                                                            c00142.L$13 = SpillingKt.nullOutSpilledVariable(watchHtml);
                                                                            c00142.L$14 = SpillingKt.nullOutSpilledVariable(unescapedWatchHtml);
                                                                            c00142.L$15 = SpillingKt.nullOutSpilledVariable(srcRegex);
                                                                            c00142.L$16 = SpillingKt.nullOutSpilledVariable(watchRegex);
                                                                            c00142.L$17 = SpillingKt.nullOutSpilledVariable(m3u8Regex);
                                                                            c00142.L$18 = SpillingKt.nullOutSpilledVariable(mp4Regex);
                                                                            c00142.L$19 = SpillingKt.nullOutSpilledVariable(streamUrl2);
                                                                            c00142.L$20 = SpillingKt.nullOutSpilledVariable(resolvedUrl3);
                                                                            c00142.L$21 = SpillingKt.nullOutSpilledVariable(fixedStreamUrl);
                                                                            c00142.label = 4;
                                                                            if (resolveXCloud(fixedStreamUrl, qualityLabel3, function7, c00142) == r34) {
                                                                                return coroutine_suspended;
                                                                            }
                                                                            qualityLabel11 = qualityLabel3;
                                                                            resolvedUrl4 = getWatchUrl10;
                                                                            try {
                                                                                return Unit.INSTANCE;
                                                                            } catch (Exception e) {
                                                                                getWatchUrl3 = resolvedUrl4;
                                                                                function3 = function7;
                                                                                qualityLabel3 = qualityLabel11;
                                                                            }
                                                                        } else {
                                                                            int quality = labelToQuality(qualityLabel3);
                                                                            ExtractorLinkType type = StringsKt.contains$default(fixedStreamUrl, str5, false, 2, (Object) null) ? ExtractorLinkType.M3U8 : ExtractorLinkType.VIDEO;
                                                                            String fixedWatchUrl3 = getName();
                                                                            String str6 = getName() + " Watch Online [" + qualityLabel3 + ']';
                                                                            C00152 c00152 = new C00152(watchUrl3, quality, this, null);
                                                                            c00142.L$0 = SpillingKt.nullOutSpilledVariable(getWatchUrl10);
                                                                            c00142.L$1 = SpillingKt.nullOutSpilledVariable(qualityLabel3);
                                                                            c00142.L$2 = SpillingKt.nullOutSpilledVariable(html);
                                                                            c00142.L$3 = SpillingKt.nullOutSpilledVariable(function7);
                                                                            c00142.L$4 = SpillingKt.nullOutSpilledVariable(base4);
                                                                            c00142.L$5 = SpillingKt.nullOutSpilledVariable(map9);
                                                                            c00142.L$6 = SpillingKt.nullOutSpilledVariable(html2);
                                                                            c00142.L$7 = SpillingKt.nullOutSpilledVariable(doc4);
                                                                            c00142.L$8 = SpillingKt.nullOutSpilledVariable(watchAnchor2);
                                                                            c00142.L$9 = SpillingKt.nullOutSpilledVariable(href3);
                                                                            c00142.L$10 = SpillingKt.nullOutSpilledVariable(watchUrl2);
                                                                            c00142.L$11 = SpillingKt.nullOutSpilledVariable(watchUrl3);
                                                                            c00142.L$12 = SpillingKt.nullOutSpilledVariable(map3);
                                                                            c00142.L$13 = SpillingKt.nullOutSpilledVariable(watchHtml);
                                                                            c00142.L$14 = SpillingKt.nullOutSpilledVariable(unescapedWatchHtml);
                                                                            c00142.L$15 = SpillingKt.nullOutSpilledVariable(srcRegex);
                                                                            c00142.L$16 = SpillingKt.nullOutSpilledVariable(watchRegex);
                                                                            c00142.L$17 = SpillingKt.nullOutSpilledVariable(m3u8Regex);
                                                                            c00142.L$18 = SpillingKt.nullOutSpilledVariable(mp4Regex);
                                                                            c00142.L$19 = SpillingKt.nullOutSpilledVariable(streamUrl2);
                                                                            c00142.L$20 = SpillingKt.nullOutSpilledVariable(resolvedUrl3);
                                                                            c00142.L$21 = SpillingKt.nullOutSpilledVariable(fixedStreamUrl);
                                                                            c00142.L$22 = SpillingKt.nullOutSpilledVariable(type);
                                                                            c00142.L$23 = function7;
                                                                            c00142.I$0 = quality;
                                                                            c00142.label = 5;
                                                                            try {
                                                                                Object objNewExtractorLink2 = ExtractorApiKt.newExtractorLink(fixedWatchUrl3, str6, fixedStreamUrl, type, c00152, c00142);
                                                                                if (objNewExtractorLink2 == coroutine_suspended) {
                                                                                    return coroutine_suspended;
                                                                                }
                                                                                getWatchUrl11 = getWatchUrl10;
                                                                                qualityLabel12 = qualityLabel3;
                                                                                $result2 = objNewExtractorLink2;
                                                                                refererUrl7 = html;
                                                                                function14 = function7;
                                                                                try {
                                                                                    function14.invoke($result2);
                                                                                    return Unit.INSTANCE;
                                                                                } catch (Exception e2) {
                                                                                    function3 = function7;
                                                                                    qualityLabel3 = qualityLabel12;
                                                                                    getWatchUrl3 = getWatchUrl11;
                                                                                }
                                                                            } catch (Exception e3) {
                                                                                getWatchUrl3 = getWatchUrl10;
                                                                                function3 = function7;
                                                                            }
                                                                        }
                                                                    } else {
                                                                        String base7 = href4;
                                                                        obj4 = coroutine_suspended;
                                                                        map5 = map9;
                                                                        doc3 = doc4;
                                                                        href = getWatchUrl10;
                                                                        function8 = function7;
                                                                        watchAnchor3 = watchAnchor2;
                                                                        fixedWatchUrl2 = base7;
                                                                        qualityLabel5 = qualityLabel3;
                                                                        html3 = html2;
                                                                        try {
                                                                            fileAnchor = doc3.selectFirst("a[href*='/file/']");
                                                                            if (fileAnchor == null) {
                                                                                Function1<? super ExtractorLink, Unit> function17 = function8;
                                                                                movieLinkBDProvider = this;
                                                                                qualityLabel6 = qualityLabel5;
                                                                                qualityLabel7 = href;
                                                                                function3 = function17;
                                                                                map6 = map5;
                                                                                try {
                                                                                    elementSelectFirst = doc3.selectFirst("video source, video[src]");
                                                                                    if (elementSelectFirst != null) {
                                                                                        try {
                                                                                            videoSrc2 = elementSelectFirst.attr("src");
                                                                                            if (videoSrc2 == null) {
                                                                                                elementSelectFirst2 = doc3.selectFirst("iframe[src]");
                                                                                                if (elementSelectFirst2 != null) {
                                                                                                    videoSrc2 = elementSelectFirst2.attr("src");
                                                                                                } else {
                                                                                                    videoSrc2 = null;
                                                                                                }
                                                                                            }
                                                                                            str = videoSrc2;
                                                                                            if (str != null || str.length() == 0) {
                                                                                                z = true;
                                                                                            } else {
                                                                                                z = false;
                                                                                            }
                                                                                            if (z) {
                                                                                                if (StringsKt.startsWith$default(videoSrc2, "http", false, 2, (Object) null)) {
                                                                                                    str2 = videoSrc2;
                                                                                                } else {
                                                                                                    str2 = fixedWatchUrl2 + videoSrc2;
                                                                                                }
                                                                                                resolvedUrl = str2;
                                                                                                fixedResolvedUrl = movieLinkBDProvider.fixUrlDomain(resolvedUrl, fixedWatchUrl2);
                                                                                                videoSrc3 = videoSrc2;
                                                                                                base3 = fixedWatchUrl2;
                                                                                                watchAnchor4 = watchAnchor3;
                                                                                                getWatchUrl3 = null;
                                                                                                try {
                                                                                                    if (!StringsKt.contains$default(fixedResolvedUrl, videoSrc, false, 2, (Object) null) || StringsKt.contains$default(fixedResolvedUrl, charSequence, false, 2, (Object) null)) {
                                                                                                        c00142.L$0 = SpillingKt.nullOutSpilledVariable(qualityLabel7);
                                                                                                        c00142.L$1 = SpillingKt.nullOutSpilledVariable(qualityLabel6);
                                                                                                        c00142.L$2 = SpillingKt.nullOutSpilledVariable(html);
                                                                                                        c00142.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                                                                                                        c00142.L$4 = SpillingKt.nullOutSpilledVariable(base3);
                                                                                                        c00142.L$5 = SpillingKt.nullOutSpilledVariable(map6);
                                                                                                        c00142.L$6 = SpillingKt.nullOutSpilledVariable(html3);
                                                                                                        c00142.L$7 = SpillingKt.nullOutSpilledVariable(doc3);
                                                                                                        c00142.L$8 = SpillingKt.nullOutSpilledVariable(watchAnchor4);
                                                                                                        c00142.L$9 = SpillingKt.nullOutSpilledVariable(fileAnchor);
                                                                                                        c00142.L$10 = SpillingKt.nullOutSpilledVariable(videoSrc3);
                                                                                                        c00142.L$11 = SpillingKt.nullOutSpilledVariable(resolvedUrl);
                                                                                                        c00142.L$12 = SpillingKt.nullOutSpilledVariable(fixedResolvedUrl);
                                                                                                        c00142.label = 7;
                                                                                                        if (movieLinkBDProvider.resolveXCloud(fixedResolvedUrl, qualityLabel6, function3, c00142) == obj4) {
                                                                                                            return obj4;
                                                                                                        }
                                                                                                        map7 = map6;
                                                                                                        getWatchUrl4 = qualityLabel7;
                                                                                                        function9 = function3;
                                                                                                        watchAnchor5 = watchAnchor4;
                                                                                                        refererUrl3 = html;
                                                                                                        try {
                                                                                                            Unit unit5 = Unit.INSTANCE;
                                                                                                        } catch (Exception e4) {
                                                                                                            qualityLabel3 = qualityLabel6;
                                                                                                            function3 = function9;
                                                                                                            getWatchUrl3 = getWatchUrl4;
                                                                                                        }
                                                                                                    } else if (!StringsKt.startsWith$default(fixedResolvedUrl, "http", false, 2, (Object) null) || StringsKt.contains$default(fixedResolvedUrl, "movielinkbd", false, 2, (Object) null)) {
                                                                                                        int quality2 = movieLinkBDProvider.labelToQuality(qualityLabel6);
                                                                                                        ExtractorLinkType type2 = StringsKt.contains$default(fixedResolvedUrl, str5, false, 2, (Object) null) ? ExtractorLinkType.M3U8 : ExtractorLinkType.VIDEO;
                                                                                                        String qualityLabel13 = movieLinkBDProvider.getName();
                                                                                                        String fixedResolvedUrl3 = movieLinkBDProvider.getName() + " Watch Online [" + qualityLabel6 + ']';
                                                                                                        C00164 c00164 = new C00164(qualityLabel7, quality2, movieLinkBDProvider, null);
                                                                                                        c00142.L$0 = SpillingKt.nullOutSpilledVariable(qualityLabel7);
                                                                                                        c00142.L$1 = SpillingKt.nullOutSpilledVariable(qualityLabel6);
                                                                                                        c00142.L$2 = SpillingKt.nullOutSpilledVariable(html);
                                                                                                        c00142.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                                                                                                        c00142.L$4 = SpillingKt.nullOutSpilledVariable(base3);
                                                                                                        c00142.L$5 = SpillingKt.nullOutSpilledVariable(map6);
                                                                                                        c00142.L$6 = SpillingKt.nullOutSpilledVariable(html3);
                                                                                                        c00142.L$7 = SpillingKt.nullOutSpilledVariable(doc3);
                                                                                                        c00142.L$8 = SpillingKt.nullOutSpilledVariable(watchAnchor4);
                                                                                                        c00142.L$9 = SpillingKt.nullOutSpilledVariable(fileAnchor);
                                                                                                        c00142.L$10 = SpillingKt.nullOutSpilledVariable(videoSrc3);
                                                                                                        c00142.L$11 = SpillingKt.nullOutSpilledVariable(resolvedUrl);
                                                                                                        c00142.L$12 = SpillingKt.nullOutSpilledVariable(fixedResolvedUrl);
                                                                                                        c00142.L$13 = SpillingKt.nullOutSpilledVariable(type2);
                                                                                                        c00142.L$14 = function3;
                                                                                                        c00142.I$0 = quality2;
                                                                                                        c00142.label = 9;
                                                                                                        qualityLabel6 = qualityLabel6;
                                                                                                        objNewExtractorLink = ExtractorApiKt.newExtractorLink(qualityLabel13, fixedResolvedUrl3, fixedResolvedUrl, type2, c00164, c00142);
                                                                                                        if (objNewExtractorLink == obj4) {
                                                                                                            return obj4;
                                                                                                        }
                                                                                                        fixedResolvedUrl2 = fixedResolvedUrl;
                                                                                                        fileAnchor2 = fileAnchor;
                                                                                                        resolvedUrl2 = resolvedUrl;
                                                                                                        function10 = function3;
                                                                                                        $result = base3;
                                                                                                        refererUrl4 = html;
                                                                                                        getWatchUrl5 = qualityLabel7;
                                                                                                        getWatchUrl6 = videoSrc3;
                                                                                                        try {
                                                                                                            function10.invoke(objNewExtractorLink);
                                                                                                            Unit unit6 = Unit.INSTANCE;
                                                                                                        } catch (Exception e5) {
                                                                                                            qualityLabel3 = qualityLabel6;
                                                                                                            getWatchUrl3 = getWatchUrl5;
                                                                                                        }
                                                                                                    } else {
                                                                                                        Function1 function18 = new Function1() { // from class: com.cncverse.MovieLinkBDProvider$$ExternalSyntheticLambda10
                                                                                                            public final Object invoke(Object obj5) {
                                                                                                                return MovieLinkBDProvider.resolveGetWatch$lambda$0((SubtitleFile) obj5);
                                                                                                            }
                                                                                                        };
                                                                                                        c00142.L$0 = SpillingKt.nullOutSpilledVariable(qualityLabel7);
                                                                                                        c00142.L$1 = SpillingKt.nullOutSpilledVariable(qualityLabel6);
                                                                                                        c00142.L$2 = SpillingKt.nullOutSpilledVariable(html);
                                                                                                        c00142.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                                                                                                        c00142.L$4 = SpillingKt.nullOutSpilledVariable(base3);
                                                                                                        c00142.L$5 = SpillingKt.nullOutSpilledVariable(map6);
                                                                                                        c00142.L$6 = SpillingKt.nullOutSpilledVariable(html3);
                                                                                                        c00142.L$7 = SpillingKt.nullOutSpilledVariable(doc3);
                                                                                                        c00142.L$8 = SpillingKt.nullOutSpilledVariable(watchAnchor4);
                                                                                                        c00142.L$9 = SpillingKt.nullOutSpilledVariable(fileAnchor);
                                                                                                        c00142.L$10 = SpillingKt.nullOutSpilledVariable(videoSrc3);
                                                                                                        c00142.L$11 = SpillingKt.nullOutSpilledVariable(resolvedUrl);
                                                                                                        c00142.L$12 = SpillingKt.nullOutSpilledVariable(fixedResolvedUrl);
                                                                                                        c00142.label = 8;
                                                                                                        if (ExtractorApiKt.loadExtractor(fixedResolvedUrl, qualityLabel7, function18, function3, c00142) == obj4) {
                                                                                                            return obj4;
                                                                                                        }
                                                                                                        map8 = map6;
                                                                                                        getWatchUrl7 = qualityLabel7;
                                                                                                        function11 = function3;
                                                                                                        refererUrl5 = html;
                                                                                                        qualityLabel8 = qualityLabel6;
                                                                                                        qualityLabel6 = qualityLabel8;
                                                                                                    }
                                                                                                } catch (Exception e6) {
                                                                                                    qualityLabel3 = null;
                                                                                                }
                                                                                            }
                                                                                        } catch (Exception e7) {
                                                                                            qualityLabel3 = qualityLabel6;
                                                                                            getWatchUrl3 = qualityLabel7;
                                                                                        }
                                                                                    } else {
                                                                                        elementSelectFirst2 = doc3.selectFirst("iframe[src]");
                                                                                        if (elementSelectFirst2 != null) {
                                                                                            videoSrc2 = elementSelectFirst2.attr("src");
                                                                                        } else {
                                                                                            videoSrc2 = null;
                                                                                        }
                                                                                        str = videoSrc2;
                                                                                        if (str != null) {
                                                                                            z = true;
                                                                                        } else {
                                                                                            z = true;
                                                                                        }
                                                                                        if (z) {
                                                                                            if (StringsKt.startsWith$default(videoSrc2, "http", false, 2, (Object) null)) {
                                                                                                str2 = videoSrc2;
                                                                                            } else {
                                                                                                str2 = fixedWatchUrl2 + videoSrc2;
                                                                                            }
                                                                                            resolvedUrl = str2;
                                                                                            fixedResolvedUrl = movieLinkBDProvider.fixUrlDomain(resolvedUrl, fixedWatchUrl2);
                                                                                            videoSrc3 = videoSrc2;
                                                                                            base3 = fixedWatchUrl2;
                                                                                            watchAnchor4 = watchAnchor3;
                                                                                            getWatchUrl3 = null;
                                                                                            if (StringsKt.contains$default(fixedResolvedUrl, videoSrc, false, 2, (Object) null)) {
                                                                                            }
                                                                                            c00142.L$0 = SpillingKt.nullOutSpilledVariable(qualityLabel7);
                                                                                            c00142.L$1 = SpillingKt.nullOutSpilledVariable(qualityLabel6);
                                                                                            c00142.L$2 = SpillingKt.nullOutSpilledVariable(html);
                                                                                            c00142.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                                                                                            c00142.L$4 = SpillingKt.nullOutSpilledVariable(base3);
                                                                                            c00142.L$5 = SpillingKt.nullOutSpilledVariable(map6);
                                                                                            c00142.L$6 = SpillingKt.nullOutSpilledVariable(html3);
                                                                                            c00142.L$7 = SpillingKt.nullOutSpilledVariable(doc3);
                                                                                            c00142.L$8 = SpillingKt.nullOutSpilledVariable(watchAnchor4);
                                                                                            c00142.L$9 = SpillingKt.nullOutSpilledVariable(fileAnchor);
                                                                                            c00142.L$10 = SpillingKt.nullOutSpilledVariable(videoSrc3);
                                                                                            c00142.L$11 = SpillingKt.nullOutSpilledVariable(resolvedUrl);
                                                                                            c00142.L$12 = SpillingKt.nullOutSpilledVariable(fixedResolvedUrl);
                                                                                            c00142.label = 7;
                                                                                            if (movieLinkBDProvider.resolveXCloud(fixedResolvedUrl, qualityLabel6, function3, c00142) == obj4) {
                                                                                                return obj4;
                                                                                            }
                                                                                            map7 = map6;
                                                                                            getWatchUrl4 = qualityLabel7;
                                                                                            function9 = function3;
                                                                                            watchAnchor5 = watchAnchor4;
                                                                                            refererUrl3 = html;
                                                                                            Unit unit7 = Unit.INSTANCE;
                                                                                        }
                                                                                    }
                                                                                } catch (Exception e8) {
                                                                                    getWatchUrl3 = qualityLabel7;
                                                                                    qualityLabel3 = qualityLabel6;
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                            try {
                                                                                href5 = fileAnchor.attr("href");
                                                                                Map<String, String> map12 = map5;
                                                                                if (StringsKt.startsWith$default(href5, "http", false, 2, (Object) null)) {
                                                                                    fileUrl = href5;
                                                                                } else {
                                                                                    fileUrl = fixedWatchUrl2 + href5;
                                                                                }
                                                                                fixedFileUrl = fixUrlDomain(fileUrl, fixedWatchUrl2);
                                                                                c00142.L$0 = SpillingKt.nullOutSpilledVariable(href);
                                                                                c00142.L$1 = SpillingKt.nullOutSpilledVariable(qualityLabel5);
                                                                                c00142.L$2 = SpillingKt.nullOutSpilledVariable(html);
                                                                                c00142.L$3 = SpillingKt.nullOutSpilledVariable(function8);
                                                                                c00142.L$4 = SpillingKt.nullOutSpilledVariable(fixedWatchUrl2);
                                                                                c00142.L$5 = SpillingKt.nullOutSpilledVariable(map12);
                                                                                c00142.L$6 = SpillingKt.nullOutSpilledVariable(html3);
                                                                                c00142.L$7 = SpillingKt.nullOutSpilledVariable(doc3);
                                                                                c00142.L$8 = SpillingKt.nullOutSpilledVariable(watchAnchor3);
                                                                                c00142.L$9 = SpillingKt.nullOutSpilledVariable(fileAnchor);
                                                                                c00142.L$10 = SpillingKt.nullOutSpilledVariable(href5);
                                                                                c00142.L$11 = SpillingKt.nullOutSpilledVariable(fileUrl);
                                                                                c00142.L$12 = SpillingKt.nullOutSpilledVariable(fixedFileUrl);
                                                                                c00142.label = 6;
                                                                                getWatchUrl8 = href;
                                                                                try {
                                                                                    function12 = function8;
                                                                                    qualityLabel9 = qualityLabel5;
                                                                                    if (resolveDirectFile(fixedFileUrl, qualityLabel5, getWatchUrl8, function8, c00142) == obj4) {
                                                                                        return obj4;
                                                                                    }
                                                                                    getWatchUrl9 = getWatchUrl8;
                                                                                    function13 = function12;
                                                                                    refererUrl6 = html;
                                                                                    qualityLabel10 = qualityLabel9;
                                                                                    try {
                                                                                        return Unit.INSTANCE;
                                                                                    } catch (Exception e9) {
                                                                                        qualityLabel3 = qualityLabel10;
                                                                                        getWatchUrl3 = getWatchUrl9;
                                                                                        function3 = function13;
                                                                                    }
                                                                                } catch (Exception e10) {
                                                                                    function3 = function8;
                                                                                    qualityLabel3 = qualityLabel5;
                                                                                    getWatchUrl3 = getWatchUrl8;
                                                                                }
                                                                            } catch (Exception e11) {
                                                                                String str7 = qualityLabel5;
                                                                                String qualityLabel14 = href;
                                                                                function3 = function8;
                                                                                qualityLabel3 = str7;
                                                                                getWatchUrl3 = qualityLabel14;
                                                                            }
                                                                        } catch (Exception e12) {
                                                                            getWatchUrl3 = href;
                                                                            function3 = function8;
                                                                            qualityLabel3 = qualityLabel5;
                                                                        }
                                                                    }
                                                                } catch (Exception e13) {
                                                                    getWatchUrl3 = getWatchUrl10;
                                                                    function3 = function7;
                                                                }
                                                            } catch (Exception e14) {
                                                                getWatchUrl3 = href;
                                                                function3 = function7;
                                                            }
                                                            return Unit.INSTANCE;
                                                        } catch (Exception e15) {
                                                            getWatchUrl3 = href;
                                                            function3 = function6;
                                                            qualityLabel3 = qualityLabel4;
                                                        }
                                                    } catch (Exception e16) {
                                                        getWatchUrl3 = href;
                                                        function3 = function6;
                                                        qualityLabel3 = qualityLabel4;
                                                    }
                                                } catch (Exception e17) {
                                                    getWatchUrl3 = href;
                                                    function3 = function6;
                                                    qualityLabel3 = qualityLabel4;
                                                }
                                            } catch (Exception e18) {
                                                qualityLabel3 = qualityLabel4;
                                                getWatchUrl3 = href;
                                                function3 = function5;
                                            }
                                        } catch (Exception e19) {
                                            Function1<? super ExtractorLink, Unit> function19 = function4;
                                            qualityLabel3 = qualityLabel4;
                                            getWatchUrl3 = href;
                                            function3 = function19;
                                        }
                                    } catch (Exception e20) {
                                        Function1<? super ExtractorLink, Unit> function20 = function4;
                                        qualityLabel3 = qualityLabel4;
                                        getWatchUrl3 = href;
                                        function3 = function20;
                                    }
                                } catch (Exception e21) {
                                    getWatchUrl3 = getWatchUrl;
                                    qualityLabel3 = qualityLabel;
                                }
                            } catch (Exception e22) {
                                function3 = function1;
                                getWatchUrl3 = getWatchUrl;
                                qualityLabel3 = qualityLabel;
                            }
                        } catch (Exception e23) {
                            function3 = function1;
                            getWatchUrl3 = getWatchUrl;
                            qualityLabel3 = qualityLabel;
                        }
                    } catch (Exception e24) {
                        function3 = function1;
                        getWatchUrl3 = getWatchUrl;
                        qualityLabel3 = qualityLabel;
                    }
                    break;
                case 1:
                    function4 = (Function1) c00142.L$3;
                    refererUrl2 = (String) c00142.L$2;
                    qualityLabel4 = (String) c00142.L$1;
                    href = (String) c00142.L$0;
                    try {
                        ResultKt.throwOnFailure($result2);
                        obj = $result2;
                        base = (String) obj;
                        html = refererUrl2;
                        mapPlus = MapsKt.plus(this.headers, MapsKt.mapOf(TuplesKt.to("Referer", refererUrl2)));
                        c00142.L$0 = href;
                        c00142.L$1 = qualityLabel4;
                        c00142.L$2 = SpillingKt.nullOutSpilledVariable(html);
                        c00142.L$3 = function4;
                        c00142.L$4 = base;
                        function5 = function4;
                        c00142.L$5 = SpillingKt.nullOutSpilledVariable(mapPlus);
                        c00142.label = 2;
                        objHttpGetText = httpGetText(href, mapPlus, c00142);
                        if (objHttpGetText == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        map = mapPlus;
                        base2 = base;
                        obj2 = objHttpGetText;
                        function6 = function5;
                        String html5 = (String) obj2;
                        map2 = map;
                        doc = Jsoup.parse(html5, href);
                        html2 = html5;
                        watchAnchor = doc.selectFirst("a[href*='/watch/']");
                        if (watchAnchor == null) {
                            charSequence = "mcloud";
                            videoSrc = "xcloud";
                            obj4 = coroutine_suspended;
                            map5 = map2;
                            watchAnchor3 = watchAnchor;
                            function8 = function6;
                            doc3 = doc;
                            fixedWatchUrl2 = base2;
                            qualityLabel5 = qualityLabel4;
                            html3 = html2;
                            fileAnchor = doc3.selectFirst("a[href*='/file/']");
                            if (fileAnchor == null) {
                                href5 = fileAnchor.attr("href");
                                Map<String, String> map13 = map5;
                                if (StringsKt.startsWith$default(href5, "http", false, 2, (Object) null)) {
                                    fileUrl = href5;
                                } else {
                                    fileUrl = fixedWatchUrl2 + href5;
                                }
                                fixedFileUrl = fixUrlDomain(fileUrl, fixedWatchUrl2);
                                c00142.L$0 = SpillingKt.nullOutSpilledVariable(href);
                                c00142.L$1 = SpillingKt.nullOutSpilledVariable(qualityLabel5);
                                c00142.L$2 = SpillingKt.nullOutSpilledVariable(html);
                                c00142.L$3 = SpillingKt.nullOutSpilledVariable(function8);
                                c00142.L$4 = SpillingKt.nullOutSpilledVariable(fixedWatchUrl2);
                                c00142.L$5 = SpillingKt.nullOutSpilledVariable(map13);
                                c00142.L$6 = SpillingKt.nullOutSpilledVariable(html3);
                                c00142.L$7 = SpillingKt.nullOutSpilledVariable(doc3);
                                c00142.L$8 = SpillingKt.nullOutSpilledVariable(watchAnchor3);
                                c00142.L$9 = SpillingKt.nullOutSpilledVariable(fileAnchor);
                                c00142.L$10 = SpillingKt.nullOutSpilledVariable(href5);
                                c00142.L$11 = SpillingKt.nullOutSpilledVariable(fileUrl);
                                c00142.L$12 = SpillingKt.nullOutSpilledVariable(fixedFileUrl);
                                c00142.label = 6;
                                getWatchUrl8 = href;
                                function12 = function8;
                                qualityLabel9 = qualityLabel5;
                                if (resolveDirectFile(fixedFileUrl, qualityLabel5, getWatchUrl8, function8, c00142) == obj4) {
                                    return obj4;
                                }
                                getWatchUrl9 = getWatchUrl8;
                                function13 = function12;
                                refererUrl6 = html;
                                qualityLabel10 = qualityLabel9;
                                return Unit.INSTANCE;
                            }
                            Function1<? super ExtractorLink, Unit> function110 = function8;
                            movieLinkBDProvider = this;
                            qualityLabel6 = qualityLabel5;
                            qualityLabel7 = href;
                            function3 = function110;
                            map6 = map5;
                            elementSelectFirst = doc3.selectFirst("video source, video[src]");
                            if (elementSelectFirst != null) {
                                videoSrc2 = elementSelectFirst.attr("src");
                                if (videoSrc2 == null) {
                                    elementSelectFirst2 = doc3.selectFirst("iframe[src]");
                                    if (elementSelectFirst2 != null) {
                                        videoSrc2 = elementSelectFirst2.attr("src");
                                    } else {
                                        videoSrc2 = null;
                                    }
                                }
                                str = videoSrc2;
                                if (str != null) {
                                    z = true;
                                } else {
                                    z = true;
                                }
                                if (z) {
                                    if (StringsKt.startsWith$default(videoSrc2, "http", false, 2, (Object) null)) {
                                        str2 = videoSrc2;
                                    } else {
                                        str2 = fixedWatchUrl2 + videoSrc2;
                                    }
                                    resolvedUrl = str2;
                                    fixedResolvedUrl = movieLinkBDProvider.fixUrlDomain(resolvedUrl, fixedWatchUrl2);
                                    videoSrc3 = videoSrc2;
                                    base3 = fixedWatchUrl2;
                                    watchAnchor4 = watchAnchor3;
                                    getWatchUrl3 = null;
                                    if (StringsKt.contains$default(fixedResolvedUrl, videoSrc, false, 2, (Object) null)) {
                                    }
                                    c00142.L$0 = SpillingKt.nullOutSpilledVariable(qualityLabel7);
                                    c00142.L$1 = SpillingKt.nullOutSpilledVariable(qualityLabel6);
                                    c00142.L$2 = SpillingKt.nullOutSpilledVariable(html);
                                    c00142.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                                    c00142.L$4 = SpillingKt.nullOutSpilledVariable(base3);
                                    c00142.L$5 = SpillingKt.nullOutSpilledVariable(map6);
                                    c00142.L$6 = SpillingKt.nullOutSpilledVariable(html3);
                                    c00142.L$7 = SpillingKt.nullOutSpilledVariable(doc3);
                                    c00142.L$8 = SpillingKt.nullOutSpilledVariable(watchAnchor4);
                                    c00142.L$9 = SpillingKt.nullOutSpilledVariable(fileAnchor);
                                    c00142.L$10 = SpillingKt.nullOutSpilledVariable(videoSrc3);
                                    c00142.L$11 = SpillingKt.nullOutSpilledVariable(resolvedUrl);
                                    c00142.L$12 = SpillingKt.nullOutSpilledVariable(fixedResolvedUrl);
                                    c00142.label = 7;
                                    if (movieLinkBDProvider.resolveXCloud(fixedResolvedUrl, qualityLabel6, function3, c00142) == obj4) {
                                        return obj4;
                                    }
                                    map7 = map6;
                                    getWatchUrl4 = qualityLabel7;
                                    function9 = function3;
                                    watchAnchor5 = watchAnchor4;
                                    refererUrl3 = html;
                                    Unit unit8 = Unit.INSTANCE;
                                }
                            } else {
                                elementSelectFirst2 = doc3.selectFirst("iframe[src]");
                                if (elementSelectFirst2 != null) {
                                    videoSrc2 = elementSelectFirst2.attr("src");
                                } else {
                                    videoSrc2 = null;
                                }
                                str = videoSrc2;
                                if (str != null) {
                                    z = true;
                                } else {
                                    z = true;
                                }
                                if (z) {
                                    if (StringsKt.startsWith$default(videoSrc2, "http", false, 2, (Object) null)) {
                                        str2 = videoSrc2;
                                    } else {
                                        str2 = fixedWatchUrl2 + videoSrc2;
                                    }
                                    resolvedUrl = str2;
                                    fixedResolvedUrl = movieLinkBDProvider.fixUrlDomain(resolvedUrl, fixedWatchUrl2);
                                    videoSrc3 = videoSrc2;
                                    base3 = fixedWatchUrl2;
                                    watchAnchor4 = watchAnchor3;
                                    getWatchUrl3 = null;
                                    if (StringsKt.contains$default(fixedResolvedUrl, videoSrc, false, 2, (Object) null)) {
                                    }
                                    c00142.L$0 = SpillingKt.nullOutSpilledVariable(qualityLabel7);
                                    c00142.L$1 = SpillingKt.nullOutSpilledVariable(qualityLabel6);
                                    c00142.L$2 = SpillingKt.nullOutSpilledVariable(html);
                                    c00142.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                                    c00142.L$4 = SpillingKt.nullOutSpilledVariable(base3);
                                    c00142.L$5 = SpillingKt.nullOutSpilledVariable(map6);
                                    c00142.L$6 = SpillingKt.nullOutSpilledVariable(html3);
                                    c00142.L$7 = SpillingKt.nullOutSpilledVariable(doc3);
                                    c00142.L$8 = SpillingKt.nullOutSpilledVariable(watchAnchor4);
                                    c00142.L$9 = SpillingKt.nullOutSpilledVariable(fileAnchor);
                                    c00142.L$10 = SpillingKt.nullOutSpilledVariable(videoSrc3);
                                    c00142.L$11 = SpillingKt.nullOutSpilledVariable(resolvedUrl);
                                    c00142.L$12 = SpillingKt.nullOutSpilledVariable(fixedResolvedUrl);
                                    c00142.label = 7;
                                    if (movieLinkBDProvider.resolveXCloud(fixedResolvedUrl, qualityLabel6, function3, c00142) == obj4) {
                                        return obj4;
                                    }
                                    map7 = map6;
                                    getWatchUrl4 = qualityLabel7;
                                    function9 = function3;
                                    watchAnchor5 = watchAnchor4;
                                    refererUrl3 = html;
                                    Unit unit9 = Unit.INSTANCE;
                                }
                            }
                            return Unit.INSTANCE;
                            return Unit.INSTANCE;
                        }
                        href2 = watchAnchor.attr("href");
                        if (StringsKt.startsWith$default(href2, "http", false, 2, (Object) null)) {
                            watchUrl = href2;
                        } else {
                            watchUrl = base2 + href2;
                        }
                        fixedWatchUrl = fixUrlDomain(watchUrl, base2);
                        mapPlus2 = MapsKt.plus(this.headers, MapsKt.mapOf(TuplesKt.to("Referer", href)));
                        c00142.L$0 = href;
                        c00142.L$1 = qualityLabel4;
                        c00142.L$2 = SpillingKt.nullOutSpilledVariable(html);
                        c00142.L$3 = function6;
                        c00142.L$4 = base2;
                        c00142.L$5 = SpillingKt.nullOutSpilledVariable(map2);
                        c00142.L$6 = SpillingKt.nullOutSpilledVariable(html2);
                        c00142.L$7 = doc;
                        c00142.L$8 = SpillingKt.nullOutSpilledVariable(watchAnchor);
                        c00142.L$9 = SpillingKt.nullOutSpilledVariable(href2);
                        c00142.L$10 = SpillingKt.nullOutSpilledVariable(watchUrl);
                        c00142.L$11 = fixedWatchUrl;
                        c00142.L$12 = SpillingKt.nullOutSpilledVariable(mapPlus2);
                        c00142.label = 3;
                        objHttpGetText2 = httpGetText(fixedWatchUrl, mapPlus2, c00142);
                        if (objHttpGetText2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        watchAnchor2 = watchAnchor;
                        href3 = href2;
                        watchUrl2 = watchUrl;
                        watchUrl3 = fixedWatchUrl;
                        map3 = mapPlus2;
                        obj3 = objHttpGetText2;
                        href4 = base2;
                        doc2 = doc;
                        map4 = map2;
                        function7 = function6;
                        qualityLabel3 = qualityLabel4;
                        watchHtml = (String) obj3;
                        unescapedWatchHtml = StringsKt.replace$default(watchHtml, "\\/", "/", false, 4, (Object) null);
                        srcRegex = new Regex("const\\s+SRC\\s*=\\s*[\"'](https?://[^\"']+)[\"']");
                        watchRegex = new Regex("(https?://[^\\s'\"]+/watch/[^\\s'\"]*)");
                        map9 = map4;
                        m3u8Regex = new Regex("(https?://[^\\s'\"]+\\.m3u8[^\\s'\"]*)");
                        doc4 = doc2;
                        mp4Regex = new Regex("(https?://[^\\s'\"]+\\.(?:mp4|mkv)[^\\s'\"]*)");
                        getWatchUrl10 = href;
                        matchResultFind$default = Regex.find$default(srcRegex, unescapedWatchHtml, 0, 2, (Object) null);
                        if (matchResultFind$default == null) {
                            matchResultFind$default2 = Regex.find$default(watchRegex, unescapedWatchHtml, 0, 2, (Object) null);
                            if (matchResultFind$default2 != null) {
                                streamUrl = matchResultFind$default2.getValue();
                            } else {
                                matchResultFind$default3 = Regex.find$default(m3u8Regex, unescapedWatchHtml, 0, 2, (Object) null);
                                if (matchResultFind$default3 != null) {
                                    streamUrl = matchResultFind$default3.getValue();
                                } else {
                                    streamUrl = null;
                                }
                                if (streamUrl == null) {
                                    matchResultFind$default4 = Regex.find$default(mp4Regex, unescapedWatchHtml, 0, 2, (Object) null);
                                    if (matchResultFind$default4 != null) {
                                        streamUrl = matchResultFind$default4.getValue();
                                    } else {
                                        streamUrl = null;
                                    }
                                }
                            }
                        } else {
                            matchResultFind$default2 = Regex.find$default(watchRegex, unescapedWatchHtml, 0, 2, (Object) null);
                            if (matchResultFind$default2 != null) {
                                streamUrl = matchResultFind$default2.getValue();
                            } else {
                                matchResultFind$default3 = Regex.find$default(m3u8Regex, unescapedWatchHtml, 0, 2, (Object) null);
                                if (matchResultFind$default3 != null) {
                                    streamUrl = matchResultFind$default3.getValue();
                                } else {
                                    streamUrl = null;
                                }
                                if (streamUrl == null) {
                                    matchResultFind$default4 = Regex.find$default(mp4Regex, unescapedWatchHtml, 0, 2, (Object) null);
                                    if (matchResultFind$default4 != null) {
                                        streamUrl = matchResultFind$default4.getValue();
                                    } else {
                                        streamUrl = null;
                                    }
                                }
                            }
                        }
                        str3 = streamUrl;
                        if (str3 != null) {
                            z2 = true;
                        } else {
                            z2 = true;
                        }
                        if (!z2) {
                            if (StringsKt.startsWith$default(streamUrl, "http", false, 2, (Object) null)) {
                                str4 = streamUrl;
                            } else {
                                str4 = href4 + streamUrl;
                            }
                            resolvedUrl3 = str4;
                            fixedStreamUrl = fixUrlDomain(resolvedUrl3, href4);
                            streamUrl2 = streamUrl;
                            base4 = href4;
                            if (StringsKt.contains$default(fixedStreamUrl, "xcloud", false, 2, (Object) null)) {
                            }
                            c00142.L$0 = SpillingKt.nullOutSpilledVariable(getWatchUrl10);
                            c00142.L$1 = SpillingKt.nullOutSpilledVariable(qualityLabel3);
                            c00142.L$2 = SpillingKt.nullOutSpilledVariable(html);
                            c00142.L$3 = SpillingKt.nullOutSpilledVariable(function7);
                            c00142.L$4 = SpillingKt.nullOutSpilledVariable(base4);
                            c00142.L$5 = SpillingKt.nullOutSpilledVariable(map9);
                            c00142.L$6 = SpillingKt.nullOutSpilledVariable(html2);
                            c00142.L$7 = SpillingKt.nullOutSpilledVariable(doc4);
                            c00142.L$8 = SpillingKt.nullOutSpilledVariable(watchAnchor2);
                            c00142.L$9 = SpillingKt.nullOutSpilledVariable(href3);
                            c00142.L$10 = SpillingKt.nullOutSpilledVariable(watchUrl2);
                            c00142.L$11 = SpillingKt.nullOutSpilledVariable(watchUrl3);
                            c00142.L$12 = SpillingKt.nullOutSpilledVariable(map3);
                            c00142.L$13 = SpillingKt.nullOutSpilledVariable(watchHtml);
                            c00142.L$14 = SpillingKt.nullOutSpilledVariable(unescapedWatchHtml);
                            c00142.L$15 = SpillingKt.nullOutSpilledVariable(srcRegex);
                            c00142.L$16 = SpillingKt.nullOutSpilledVariable(watchRegex);
                            c00142.L$17 = SpillingKt.nullOutSpilledVariable(m3u8Regex);
                            c00142.L$18 = SpillingKt.nullOutSpilledVariable(mp4Regex);
                            c00142.L$19 = SpillingKt.nullOutSpilledVariable(streamUrl2);
                            c00142.L$20 = SpillingKt.nullOutSpilledVariable(resolvedUrl3);
                            c00142.L$21 = SpillingKt.nullOutSpilledVariable(fixedStreamUrl);
                            c00142.label = 4;
                            if (resolveXCloud(fixedStreamUrl, qualityLabel3, function7, c00142) == r34) {
                                return coroutine_suspended;
                            }
                            qualityLabel11 = qualityLabel3;
                            resolvedUrl4 = getWatchUrl10;
                            return Unit.INSTANCE;
                        }
                        String base8 = href4;
                        obj4 = coroutine_suspended;
                        map5 = map9;
                        doc3 = doc4;
                        href = getWatchUrl10;
                        function8 = function7;
                        watchAnchor3 = watchAnchor2;
                        fixedWatchUrl2 = base8;
                        qualityLabel5 = qualityLabel3;
                        html3 = html2;
                        fileAnchor = doc3.selectFirst("a[href*='/file/']");
                        if (fileAnchor == null) {
                            href5 = fileAnchor.attr("href");
                            Map<String, String> map14 = map5;
                            if (StringsKt.startsWith$default(href5, "http", false, 2, (Object) null)) {
                                fileUrl = href5;
                            } else {
                                fileUrl = fixedWatchUrl2 + href5;
                            }
                            fixedFileUrl = fixUrlDomain(fileUrl, fixedWatchUrl2);
                            c00142.L$0 = SpillingKt.nullOutSpilledVariable(href);
                            c00142.L$1 = SpillingKt.nullOutSpilledVariable(qualityLabel5);
                            c00142.L$2 = SpillingKt.nullOutSpilledVariable(html);
                            c00142.L$3 = SpillingKt.nullOutSpilledVariable(function8);
                            c00142.L$4 = SpillingKt.nullOutSpilledVariable(fixedWatchUrl2);
                            c00142.L$5 = SpillingKt.nullOutSpilledVariable(map14);
                            c00142.L$6 = SpillingKt.nullOutSpilledVariable(html3);
                            c00142.L$7 = SpillingKt.nullOutSpilledVariable(doc3);
                            c00142.L$8 = SpillingKt.nullOutSpilledVariable(watchAnchor3);
                            c00142.L$9 = SpillingKt.nullOutSpilledVariable(fileAnchor);
                            c00142.L$10 = SpillingKt.nullOutSpilledVariable(href5);
                            c00142.L$11 = SpillingKt.nullOutSpilledVariable(fileUrl);
                            c00142.L$12 = SpillingKt.nullOutSpilledVariable(fixedFileUrl);
                            c00142.label = 6;
                            getWatchUrl8 = href;
                            function12 = function8;
                            qualityLabel9 = qualityLabel5;
                            if (resolveDirectFile(fixedFileUrl, qualityLabel5, getWatchUrl8, function8, c00142) == obj4) {
                                return obj4;
                            }
                            getWatchUrl9 = getWatchUrl8;
                            function13 = function12;
                            refererUrl6 = html;
                            qualityLabel10 = qualityLabel9;
                            return Unit.INSTANCE;
                        }
                        Function1<? super ExtractorLink, Unit> function111 = function8;
                        movieLinkBDProvider = this;
                        qualityLabel6 = qualityLabel5;
                        qualityLabel7 = href;
                        function3 = function111;
                        map6 = map5;
                        elementSelectFirst = doc3.selectFirst("video source, video[src]");
                        if (elementSelectFirst != null) {
                            videoSrc2 = elementSelectFirst.attr("src");
                            if (videoSrc2 == null) {
                                elementSelectFirst2 = doc3.selectFirst("iframe[src]");
                                if (elementSelectFirst2 != null) {
                                    videoSrc2 = elementSelectFirst2.attr("src");
                                } else {
                                    videoSrc2 = null;
                                }
                            }
                            str = videoSrc2;
                            if (str != null) {
                                z = true;
                            } else {
                                z = true;
                            }
                            if (z) {
                                if (StringsKt.startsWith$default(videoSrc2, "http", false, 2, (Object) null)) {
                                    str2 = videoSrc2;
                                } else {
                                    str2 = fixedWatchUrl2 + videoSrc2;
                                }
                                resolvedUrl = str2;
                                fixedResolvedUrl = movieLinkBDProvider.fixUrlDomain(resolvedUrl, fixedWatchUrl2);
                                videoSrc3 = videoSrc2;
                                base3 = fixedWatchUrl2;
                                watchAnchor4 = watchAnchor3;
                                getWatchUrl3 = null;
                                if (StringsKt.contains$default(fixedResolvedUrl, videoSrc, false, 2, (Object) null)) {
                                }
                                c00142.L$0 = SpillingKt.nullOutSpilledVariable(qualityLabel7);
                                c00142.L$1 = SpillingKt.nullOutSpilledVariable(qualityLabel6);
                                c00142.L$2 = SpillingKt.nullOutSpilledVariable(html);
                                c00142.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                                c00142.L$4 = SpillingKt.nullOutSpilledVariable(base3);
                                c00142.L$5 = SpillingKt.nullOutSpilledVariable(map6);
                                c00142.L$6 = SpillingKt.nullOutSpilledVariable(html3);
                                c00142.L$7 = SpillingKt.nullOutSpilledVariable(doc3);
                                c00142.L$8 = SpillingKt.nullOutSpilledVariable(watchAnchor4);
                                c00142.L$9 = SpillingKt.nullOutSpilledVariable(fileAnchor);
                                c00142.L$10 = SpillingKt.nullOutSpilledVariable(videoSrc3);
                                c00142.L$11 = SpillingKt.nullOutSpilledVariable(resolvedUrl);
                                c00142.L$12 = SpillingKt.nullOutSpilledVariable(fixedResolvedUrl);
                                c00142.label = 7;
                                if (movieLinkBDProvider.resolveXCloud(fixedResolvedUrl, qualityLabel6, function3, c00142) == obj4) {
                                    return obj4;
                                }
                                map7 = map6;
                                getWatchUrl4 = qualityLabel7;
                                function9 = function3;
                                watchAnchor5 = watchAnchor4;
                                refererUrl3 = html;
                                Unit unit10 = Unit.INSTANCE;
                            }
                        } else {
                            elementSelectFirst2 = doc3.selectFirst("iframe[src]");
                            if (elementSelectFirst2 != null) {
                                videoSrc2 = elementSelectFirst2.attr("src");
                            } else {
                                videoSrc2 = null;
                            }
                            str = videoSrc2;
                            if (str != null) {
                                z = true;
                            } else {
                                z = true;
                            }
                            if (z) {
                                if (StringsKt.startsWith$default(videoSrc2, "http", false, 2, (Object) null)) {
                                    str2 = videoSrc2;
                                } else {
                                    str2 = fixedWatchUrl2 + videoSrc2;
                                }
                                resolvedUrl = str2;
                                fixedResolvedUrl = movieLinkBDProvider.fixUrlDomain(resolvedUrl, fixedWatchUrl2);
                                videoSrc3 = videoSrc2;
                                base3 = fixedWatchUrl2;
                                watchAnchor4 = watchAnchor3;
                                getWatchUrl3 = null;
                                if (StringsKt.contains$default(fixedResolvedUrl, videoSrc, false, 2, (Object) null)) {
                                }
                                c00142.L$0 = SpillingKt.nullOutSpilledVariable(qualityLabel7);
                                c00142.L$1 = SpillingKt.nullOutSpilledVariable(qualityLabel6);
                                c00142.L$2 = SpillingKt.nullOutSpilledVariable(html);
                                c00142.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                                c00142.L$4 = SpillingKt.nullOutSpilledVariable(base3);
                                c00142.L$5 = SpillingKt.nullOutSpilledVariable(map6);
                                c00142.L$6 = SpillingKt.nullOutSpilledVariable(html3);
                                c00142.L$7 = SpillingKt.nullOutSpilledVariable(doc3);
                                c00142.L$8 = SpillingKt.nullOutSpilledVariable(watchAnchor4);
                                c00142.L$9 = SpillingKt.nullOutSpilledVariable(fileAnchor);
                                c00142.L$10 = SpillingKt.nullOutSpilledVariable(videoSrc3);
                                c00142.L$11 = SpillingKt.nullOutSpilledVariable(resolvedUrl);
                                c00142.L$12 = SpillingKt.nullOutSpilledVariable(fixedResolvedUrl);
                                c00142.label = 7;
                                if (movieLinkBDProvider.resolveXCloud(fixedResolvedUrl, qualityLabel6, function3, c00142) == obj4) {
                                    return obj4;
                                }
                                map7 = map6;
                                getWatchUrl4 = qualityLabel7;
                                function9 = function3;
                                watchAnchor5 = watchAnchor4;
                                refererUrl3 = html;
                                Unit unit11 = Unit.INSTANCE;
                            }
                        }
                        return Unit.INSTANCE;
                        return Unit.INSTANCE;
                    } catch (Exception e25) {
                        getWatchUrl3 = href;
                        function3 = function4;
                        qualityLabel3 = qualityLabel4;
                    }
                    break;
                case 2:
                    Map<String, String> map15 = (Map) c00142.L$5;
                    base2 = (String) c00142.L$4;
                    Function1<? super ExtractorLink, Unit> function21 = (Function1) c00142.L$3;
                    String refererUrl8 = (String) c00142.L$2;
                    String qualityLabel15 = (String) c00142.L$1;
                    String getWatchUrl12 = (String) c00142.L$0;
                    try {
                        ResultKt.throwOnFailure($result2);
                        map = map15;
                        obj2 = $result2;
                        html = refererUrl8;
                        href = getWatchUrl12;
                        function6 = function21;
                        qualityLabel4 = qualityLabel15;
                        String html6 = (String) obj2;
                        map2 = map;
                        doc = Jsoup.parse(html6, href);
                        html2 = html6;
                        watchAnchor = doc.selectFirst("a[href*='/watch/']");
                        if (watchAnchor == null) {
                            charSequence = "mcloud";
                            videoSrc = "xcloud";
                            obj4 = coroutine_suspended;
                            map5 = map2;
                            watchAnchor3 = watchAnchor;
                            function8 = function6;
                            doc3 = doc;
                            fixedWatchUrl2 = base2;
                            qualityLabel5 = qualityLabel4;
                            html3 = html2;
                            fileAnchor = doc3.selectFirst("a[href*='/file/']");
                            if (fileAnchor == null) {
                                href5 = fileAnchor.attr("href");
                                Map<String, String> map16 = map5;
                                if (StringsKt.startsWith$default(href5, "http", false, 2, (Object) null)) {
                                    fileUrl = href5;
                                } else {
                                    fileUrl = fixedWatchUrl2 + href5;
                                }
                                fixedFileUrl = fixUrlDomain(fileUrl, fixedWatchUrl2);
                                c00142.L$0 = SpillingKt.nullOutSpilledVariable(href);
                                c00142.L$1 = SpillingKt.nullOutSpilledVariable(qualityLabel5);
                                c00142.L$2 = SpillingKt.nullOutSpilledVariable(html);
                                c00142.L$3 = SpillingKt.nullOutSpilledVariable(function8);
                                c00142.L$4 = SpillingKt.nullOutSpilledVariable(fixedWatchUrl2);
                                c00142.L$5 = SpillingKt.nullOutSpilledVariable(map16);
                                c00142.L$6 = SpillingKt.nullOutSpilledVariable(html3);
                                c00142.L$7 = SpillingKt.nullOutSpilledVariable(doc3);
                                c00142.L$8 = SpillingKt.nullOutSpilledVariable(watchAnchor3);
                                c00142.L$9 = SpillingKt.nullOutSpilledVariable(fileAnchor);
                                c00142.L$10 = SpillingKt.nullOutSpilledVariable(href5);
                                c00142.L$11 = SpillingKt.nullOutSpilledVariable(fileUrl);
                                c00142.L$12 = SpillingKt.nullOutSpilledVariable(fixedFileUrl);
                                c00142.label = 6;
                                getWatchUrl8 = href;
                                function12 = function8;
                                qualityLabel9 = qualityLabel5;
                                if (resolveDirectFile(fixedFileUrl, qualityLabel5, getWatchUrl8, function8, c00142) == obj4) {
                                    return obj4;
                                }
                                getWatchUrl9 = getWatchUrl8;
                                function13 = function12;
                                refererUrl6 = html;
                                qualityLabel10 = qualityLabel9;
                                return Unit.INSTANCE;
                            }
                            Function1<? super ExtractorLink, Unit> function112 = function8;
                            movieLinkBDProvider = this;
                            qualityLabel6 = qualityLabel5;
                            qualityLabel7 = href;
                            function3 = function112;
                            map6 = map5;
                            elementSelectFirst = doc3.selectFirst("video source, video[src]");
                            if (elementSelectFirst != null) {
                                videoSrc2 = elementSelectFirst.attr("src");
                                if (videoSrc2 == null) {
                                    elementSelectFirst2 = doc3.selectFirst("iframe[src]");
                                    if (elementSelectFirst2 != null) {
                                        videoSrc2 = elementSelectFirst2.attr("src");
                                    } else {
                                        videoSrc2 = null;
                                    }
                                }
                                str = videoSrc2;
                                if (str != null) {
                                    z = true;
                                } else {
                                    z = true;
                                }
                                if (z) {
                                    if (StringsKt.startsWith$default(videoSrc2, "http", false, 2, (Object) null)) {
                                        str2 = videoSrc2;
                                    } else {
                                        str2 = fixedWatchUrl2 + videoSrc2;
                                    }
                                    resolvedUrl = str2;
                                    fixedResolvedUrl = movieLinkBDProvider.fixUrlDomain(resolvedUrl, fixedWatchUrl2);
                                    videoSrc3 = videoSrc2;
                                    base3 = fixedWatchUrl2;
                                    watchAnchor4 = watchAnchor3;
                                    getWatchUrl3 = null;
                                    if (StringsKt.contains$default(fixedResolvedUrl, videoSrc, false, 2, (Object) null)) {
                                    }
                                    c00142.L$0 = SpillingKt.nullOutSpilledVariable(qualityLabel7);
                                    c00142.L$1 = SpillingKt.nullOutSpilledVariable(qualityLabel6);
                                    c00142.L$2 = SpillingKt.nullOutSpilledVariable(html);
                                    c00142.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                                    c00142.L$4 = SpillingKt.nullOutSpilledVariable(base3);
                                    c00142.L$5 = SpillingKt.nullOutSpilledVariable(map6);
                                    c00142.L$6 = SpillingKt.nullOutSpilledVariable(html3);
                                    c00142.L$7 = SpillingKt.nullOutSpilledVariable(doc3);
                                    c00142.L$8 = SpillingKt.nullOutSpilledVariable(watchAnchor4);
                                    c00142.L$9 = SpillingKt.nullOutSpilledVariable(fileAnchor);
                                    c00142.L$10 = SpillingKt.nullOutSpilledVariable(videoSrc3);
                                    c00142.L$11 = SpillingKt.nullOutSpilledVariable(resolvedUrl);
                                    c00142.L$12 = SpillingKt.nullOutSpilledVariable(fixedResolvedUrl);
                                    c00142.label = 7;
                                    if (movieLinkBDProvider.resolveXCloud(fixedResolvedUrl, qualityLabel6, function3, c00142) == obj4) {
                                        return obj4;
                                    }
                                    map7 = map6;
                                    getWatchUrl4 = qualityLabel7;
                                    function9 = function3;
                                    watchAnchor5 = watchAnchor4;
                                    refererUrl3 = html;
                                    Unit unit12 = Unit.INSTANCE;
                                }
                            } else {
                                elementSelectFirst2 = doc3.selectFirst("iframe[src]");
                                if (elementSelectFirst2 != null) {
                                    videoSrc2 = elementSelectFirst2.attr("src");
                                } else {
                                    videoSrc2 = null;
                                }
                                str = videoSrc2;
                                if (str != null) {
                                    z = true;
                                } else {
                                    z = true;
                                }
                                if (z) {
                                    if (StringsKt.startsWith$default(videoSrc2, "http", false, 2, (Object) null)) {
                                        str2 = videoSrc2;
                                    } else {
                                        str2 = fixedWatchUrl2 + videoSrc2;
                                    }
                                    resolvedUrl = str2;
                                    fixedResolvedUrl = movieLinkBDProvider.fixUrlDomain(resolvedUrl, fixedWatchUrl2);
                                    videoSrc3 = videoSrc2;
                                    base3 = fixedWatchUrl2;
                                    watchAnchor4 = watchAnchor3;
                                    getWatchUrl3 = null;
                                    if (StringsKt.contains$default(fixedResolvedUrl, videoSrc, false, 2, (Object) null)) {
                                    }
                                    c00142.L$0 = SpillingKt.nullOutSpilledVariable(qualityLabel7);
                                    c00142.L$1 = SpillingKt.nullOutSpilledVariable(qualityLabel6);
                                    c00142.L$2 = SpillingKt.nullOutSpilledVariable(html);
                                    c00142.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                                    c00142.L$4 = SpillingKt.nullOutSpilledVariable(base3);
                                    c00142.L$5 = SpillingKt.nullOutSpilledVariable(map6);
                                    c00142.L$6 = SpillingKt.nullOutSpilledVariable(html3);
                                    c00142.L$7 = SpillingKt.nullOutSpilledVariable(doc3);
                                    c00142.L$8 = SpillingKt.nullOutSpilledVariable(watchAnchor4);
                                    c00142.L$9 = SpillingKt.nullOutSpilledVariable(fileAnchor);
                                    c00142.L$10 = SpillingKt.nullOutSpilledVariable(videoSrc3);
                                    c00142.L$11 = SpillingKt.nullOutSpilledVariable(resolvedUrl);
                                    c00142.L$12 = SpillingKt.nullOutSpilledVariable(fixedResolvedUrl);
                                    c00142.label = 7;
                                    if (movieLinkBDProvider.resolveXCloud(fixedResolvedUrl, qualityLabel6, function3, c00142) == obj4) {
                                        return obj4;
                                    }
                                    map7 = map6;
                                    getWatchUrl4 = qualityLabel7;
                                    function9 = function3;
                                    watchAnchor5 = watchAnchor4;
                                    refererUrl3 = html;
                                    Unit unit13 = Unit.INSTANCE;
                                }
                            }
                            return Unit.INSTANCE;
                            return Unit.INSTANCE;
                        }
                        href2 = watchAnchor.attr("href");
                        if (StringsKt.startsWith$default(href2, "http", false, 2, (Object) null)) {
                            watchUrl = href2;
                        } else {
                            watchUrl = base2 + href2;
                        }
                        fixedWatchUrl = fixUrlDomain(watchUrl, base2);
                        mapPlus2 = MapsKt.plus(this.headers, MapsKt.mapOf(TuplesKt.to("Referer", href)));
                        c00142.L$0 = href;
                        c00142.L$1 = qualityLabel4;
                        c00142.L$2 = SpillingKt.nullOutSpilledVariable(html);
                        c00142.L$3 = function6;
                        c00142.L$4 = base2;
                        c00142.L$5 = SpillingKt.nullOutSpilledVariable(map2);
                        c00142.L$6 = SpillingKt.nullOutSpilledVariable(html2);
                        c00142.L$7 = doc;
                        c00142.L$8 = SpillingKt.nullOutSpilledVariable(watchAnchor);
                        c00142.L$9 = SpillingKt.nullOutSpilledVariable(href2);
                        c00142.L$10 = SpillingKt.nullOutSpilledVariable(watchUrl);
                        c00142.L$11 = fixedWatchUrl;
                        c00142.L$12 = SpillingKt.nullOutSpilledVariable(mapPlus2);
                        c00142.label = 3;
                        objHttpGetText2 = httpGetText(fixedWatchUrl, mapPlus2, c00142);
                        if (objHttpGetText2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        watchAnchor2 = watchAnchor;
                        href3 = href2;
                        watchUrl2 = watchUrl;
                        watchUrl3 = fixedWatchUrl;
                        map3 = mapPlus2;
                        obj3 = objHttpGetText2;
                        href4 = base2;
                        doc2 = doc;
                        map4 = map2;
                        function7 = function6;
                        qualityLabel3 = qualityLabel4;
                        watchHtml = (String) obj3;
                        unescapedWatchHtml = StringsKt.replace$default(watchHtml, "\\/", "/", false, 4, (Object) null);
                        srcRegex = new Regex("const\\s+SRC\\s*=\\s*[\"'](https?://[^\"']+)[\"']");
                        watchRegex = new Regex("(https?://[^\\s'\"]+/watch/[^\\s'\"]*)");
                        map9 = map4;
                        m3u8Regex = new Regex("(https?://[^\\s'\"]+\\.m3u8[^\\s'\"]*)");
                        doc4 = doc2;
                        mp4Regex = new Regex("(https?://[^\\s'\"]+\\.(?:mp4|mkv)[^\\s'\"]*)");
                        getWatchUrl10 = href;
                        matchResultFind$default = Regex.find$default(srcRegex, unescapedWatchHtml, 0, 2, (Object) null);
                        if (matchResultFind$default == null) {
                            matchResultFind$default2 = Regex.find$default(watchRegex, unescapedWatchHtml, 0, 2, (Object) null);
                            if (matchResultFind$default2 != null) {
                                streamUrl = matchResultFind$default2.getValue();
                            } else {
                                matchResultFind$default3 = Regex.find$default(m3u8Regex, unescapedWatchHtml, 0, 2, (Object) null);
                                if (matchResultFind$default3 != null) {
                                    streamUrl = matchResultFind$default3.getValue();
                                } else {
                                    streamUrl = null;
                                }
                                if (streamUrl == null) {
                                    matchResultFind$default4 = Regex.find$default(mp4Regex, unescapedWatchHtml, 0, 2, (Object) null);
                                    if (matchResultFind$default4 != null) {
                                        streamUrl = matchResultFind$default4.getValue();
                                    } else {
                                        streamUrl = null;
                                    }
                                }
                            }
                        } else {
                            matchResultFind$default2 = Regex.find$default(watchRegex, unescapedWatchHtml, 0, 2, (Object) null);
                            if (matchResultFind$default2 != null) {
                                streamUrl = matchResultFind$default2.getValue();
                            } else {
                                matchResultFind$default3 = Regex.find$default(m3u8Regex, unescapedWatchHtml, 0, 2, (Object) null);
                                if (matchResultFind$default3 != null) {
                                    streamUrl = matchResultFind$default3.getValue();
                                } else {
                                    streamUrl = null;
                                }
                                if (streamUrl == null) {
                                    matchResultFind$default4 = Regex.find$default(mp4Regex, unescapedWatchHtml, 0, 2, (Object) null);
                                    if (matchResultFind$default4 != null) {
                                        streamUrl = matchResultFind$default4.getValue();
                                    } else {
                                        streamUrl = null;
                                    }
                                }
                            }
                        }
                        str3 = streamUrl;
                        if (str3 != null) {
                            z2 = true;
                        } else {
                            z2 = true;
                        }
                        if (!z2) {
                            if (StringsKt.startsWith$default(streamUrl, "http", false, 2, (Object) null)) {
                                str4 = streamUrl;
                            } else {
                                str4 = href4 + streamUrl;
                            }
                            resolvedUrl3 = str4;
                            fixedStreamUrl = fixUrlDomain(resolvedUrl3, href4);
                            streamUrl2 = streamUrl;
                            base4 = href4;
                            if (StringsKt.contains$default(fixedStreamUrl, "xcloud", false, 2, (Object) null)) {
                            }
                            c00142.L$0 = SpillingKt.nullOutSpilledVariable(getWatchUrl10);
                            c00142.L$1 = SpillingKt.nullOutSpilledVariable(qualityLabel3);
                            c00142.L$2 = SpillingKt.nullOutSpilledVariable(html);
                            c00142.L$3 = SpillingKt.nullOutSpilledVariable(function7);
                            c00142.L$4 = SpillingKt.nullOutSpilledVariable(base4);
                            c00142.L$5 = SpillingKt.nullOutSpilledVariable(map9);
                            c00142.L$6 = SpillingKt.nullOutSpilledVariable(html2);
                            c00142.L$7 = SpillingKt.nullOutSpilledVariable(doc4);
                            c00142.L$8 = SpillingKt.nullOutSpilledVariable(watchAnchor2);
                            c00142.L$9 = SpillingKt.nullOutSpilledVariable(href3);
                            c00142.L$10 = SpillingKt.nullOutSpilledVariable(watchUrl2);
                            c00142.L$11 = SpillingKt.nullOutSpilledVariable(watchUrl3);
                            c00142.L$12 = SpillingKt.nullOutSpilledVariable(map3);
                            c00142.L$13 = SpillingKt.nullOutSpilledVariable(watchHtml);
                            c00142.L$14 = SpillingKt.nullOutSpilledVariable(unescapedWatchHtml);
                            c00142.L$15 = SpillingKt.nullOutSpilledVariable(srcRegex);
                            c00142.L$16 = SpillingKt.nullOutSpilledVariable(watchRegex);
                            c00142.L$17 = SpillingKt.nullOutSpilledVariable(m3u8Regex);
                            c00142.L$18 = SpillingKt.nullOutSpilledVariable(mp4Regex);
                            c00142.L$19 = SpillingKt.nullOutSpilledVariable(streamUrl2);
                            c00142.L$20 = SpillingKt.nullOutSpilledVariable(resolvedUrl3);
                            c00142.L$21 = SpillingKt.nullOutSpilledVariable(fixedStreamUrl);
                            c00142.label = 4;
                            if (resolveXCloud(fixedStreamUrl, qualityLabel3, function7, c00142) == r34) {
                                return coroutine_suspended;
                            }
                            qualityLabel11 = qualityLabel3;
                            resolvedUrl4 = getWatchUrl10;
                            return Unit.INSTANCE;
                        }
                        String base9 = href4;
                        obj4 = coroutine_suspended;
                        map5 = map9;
                        doc3 = doc4;
                        href = getWatchUrl10;
                        function8 = function7;
                        watchAnchor3 = watchAnchor2;
                        fixedWatchUrl2 = base9;
                        qualityLabel5 = qualityLabel3;
                        html3 = html2;
                        fileAnchor = doc3.selectFirst("a[href*='/file/']");
                        if (fileAnchor == null) {
                            href5 = fileAnchor.attr("href");
                            Map<String, String> map17 = map5;
                            if (StringsKt.startsWith$default(href5, "http", false, 2, (Object) null)) {
                                fileUrl = href5;
                            } else {
                                fileUrl = fixedWatchUrl2 + href5;
                            }
                            fixedFileUrl = fixUrlDomain(fileUrl, fixedWatchUrl2);
                            c00142.L$0 = SpillingKt.nullOutSpilledVariable(href);
                            c00142.L$1 = SpillingKt.nullOutSpilledVariable(qualityLabel5);
                            c00142.L$2 = SpillingKt.nullOutSpilledVariable(html);
                            c00142.L$3 = SpillingKt.nullOutSpilledVariable(function8);
                            c00142.L$4 = SpillingKt.nullOutSpilledVariable(fixedWatchUrl2);
                            c00142.L$5 = SpillingKt.nullOutSpilledVariable(map17);
                            c00142.L$6 = SpillingKt.nullOutSpilledVariable(html3);
                            c00142.L$7 = SpillingKt.nullOutSpilledVariable(doc3);
                            c00142.L$8 = SpillingKt.nullOutSpilledVariable(watchAnchor3);
                            c00142.L$9 = SpillingKt.nullOutSpilledVariable(fileAnchor);
                            c00142.L$10 = SpillingKt.nullOutSpilledVariable(href5);
                            c00142.L$11 = SpillingKt.nullOutSpilledVariable(fileUrl);
                            c00142.L$12 = SpillingKt.nullOutSpilledVariable(fixedFileUrl);
                            c00142.label = 6;
                            getWatchUrl8 = href;
                            function12 = function8;
                            qualityLabel9 = qualityLabel5;
                            if (resolveDirectFile(fixedFileUrl, qualityLabel5, getWatchUrl8, function8, c00142) == obj4) {
                                return obj4;
                            }
                            getWatchUrl9 = getWatchUrl8;
                            function13 = function12;
                            refererUrl6 = html;
                            qualityLabel10 = qualityLabel9;
                            return Unit.INSTANCE;
                        }
                        Function1<? super ExtractorLink, Unit> function113 = function8;
                        movieLinkBDProvider = this;
                        qualityLabel6 = qualityLabel5;
                        qualityLabel7 = href;
                        function3 = function113;
                        map6 = map5;
                        elementSelectFirst = doc3.selectFirst("video source, video[src]");
                        if (elementSelectFirst != null) {
                            videoSrc2 = elementSelectFirst.attr("src");
                            if (videoSrc2 == null) {
                                elementSelectFirst2 = doc3.selectFirst("iframe[src]");
                                if (elementSelectFirst2 != null) {
                                    videoSrc2 = elementSelectFirst2.attr("src");
                                } else {
                                    videoSrc2 = null;
                                }
                            }
                            str = videoSrc2;
                            if (str != null) {
                                z = true;
                            } else {
                                z = true;
                            }
                            if (z) {
                                if (StringsKt.startsWith$default(videoSrc2, "http", false, 2, (Object) null)) {
                                    str2 = videoSrc2;
                                } else {
                                    str2 = fixedWatchUrl2 + videoSrc2;
                                }
                                resolvedUrl = str2;
                                fixedResolvedUrl = movieLinkBDProvider.fixUrlDomain(resolvedUrl, fixedWatchUrl2);
                                videoSrc3 = videoSrc2;
                                base3 = fixedWatchUrl2;
                                watchAnchor4 = watchAnchor3;
                                getWatchUrl3 = null;
                                if (StringsKt.contains$default(fixedResolvedUrl, videoSrc, false, 2, (Object) null)) {
                                }
                                c00142.L$0 = SpillingKt.nullOutSpilledVariable(qualityLabel7);
                                c00142.L$1 = SpillingKt.nullOutSpilledVariable(qualityLabel6);
                                c00142.L$2 = SpillingKt.nullOutSpilledVariable(html);
                                c00142.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                                c00142.L$4 = SpillingKt.nullOutSpilledVariable(base3);
                                c00142.L$5 = SpillingKt.nullOutSpilledVariable(map6);
                                c00142.L$6 = SpillingKt.nullOutSpilledVariable(html3);
                                c00142.L$7 = SpillingKt.nullOutSpilledVariable(doc3);
                                c00142.L$8 = SpillingKt.nullOutSpilledVariable(watchAnchor4);
                                c00142.L$9 = SpillingKt.nullOutSpilledVariable(fileAnchor);
                                c00142.L$10 = SpillingKt.nullOutSpilledVariable(videoSrc3);
                                c00142.L$11 = SpillingKt.nullOutSpilledVariable(resolvedUrl);
                                c00142.L$12 = SpillingKt.nullOutSpilledVariable(fixedResolvedUrl);
                                c00142.label = 7;
                                if (movieLinkBDProvider.resolveXCloud(fixedResolvedUrl, qualityLabel6, function3, c00142) == obj4) {
                                    return obj4;
                                }
                                map7 = map6;
                                getWatchUrl4 = qualityLabel7;
                                function9 = function3;
                                watchAnchor5 = watchAnchor4;
                                refererUrl3 = html;
                                Unit unit14 = Unit.INSTANCE;
                            }
                        } else {
                            elementSelectFirst2 = doc3.selectFirst("iframe[src]");
                            if (elementSelectFirst2 != null) {
                                videoSrc2 = elementSelectFirst2.attr("src");
                            } else {
                                videoSrc2 = null;
                            }
                            str = videoSrc2;
                            if (str != null) {
                                z = true;
                            } else {
                                z = true;
                            }
                            if (z) {
                                if (StringsKt.startsWith$default(videoSrc2, "http", false, 2, (Object) null)) {
                                    str2 = videoSrc2;
                                } else {
                                    str2 = fixedWatchUrl2 + videoSrc2;
                                }
                                resolvedUrl = str2;
                                fixedResolvedUrl = movieLinkBDProvider.fixUrlDomain(resolvedUrl, fixedWatchUrl2);
                                videoSrc3 = videoSrc2;
                                base3 = fixedWatchUrl2;
                                watchAnchor4 = watchAnchor3;
                                getWatchUrl3 = null;
                                if (StringsKt.contains$default(fixedResolvedUrl, videoSrc, false, 2, (Object) null)) {
                                }
                                c00142.L$0 = SpillingKt.nullOutSpilledVariable(qualityLabel7);
                                c00142.L$1 = SpillingKt.nullOutSpilledVariable(qualityLabel6);
                                c00142.L$2 = SpillingKt.nullOutSpilledVariable(html);
                                c00142.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                                c00142.L$4 = SpillingKt.nullOutSpilledVariable(base3);
                                c00142.L$5 = SpillingKt.nullOutSpilledVariable(map6);
                                c00142.L$6 = SpillingKt.nullOutSpilledVariable(html3);
                                c00142.L$7 = SpillingKt.nullOutSpilledVariable(doc3);
                                c00142.L$8 = SpillingKt.nullOutSpilledVariable(watchAnchor4);
                                c00142.L$9 = SpillingKt.nullOutSpilledVariable(fileAnchor);
                                c00142.L$10 = SpillingKt.nullOutSpilledVariable(videoSrc3);
                                c00142.L$11 = SpillingKt.nullOutSpilledVariable(resolvedUrl);
                                c00142.L$12 = SpillingKt.nullOutSpilledVariable(fixedResolvedUrl);
                                c00142.label = 7;
                                if (movieLinkBDProvider.resolveXCloud(fixedResolvedUrl, qualityLabel6, function3, c00142) == obj4) {
                                    return obj4;
                                }
                                map7 = map6;
                                getWatchUrl4 = qualityLabel7;
                                function9 = function3;
                                watchAnchor5 = watchAnchor4;
                                refererUrl3 = html;
                                Unit unit15 = Unit.INSTANCE;
                            }
                        }
                        return Unit.INSTANCE;
                        return Unit.INSTANCE;
                    } catch (Exception e26) {
                        getWatchUrl3 = getWatchUrl12;
                        qualityLabel3 = qualityLabel15;
                        function3 = function21;
                    }
                    break;
                case 3:
                    Map<String, String> map18 = (Map) c00142.L$12;
                    String fixedWatchUrl4 = (String) c00142.L$11;
                    String watchUrl4 = (String) c00142.L$10;
                    String href6 = (String) c00142.L$9;
                    Element watchAnchor6 = (Element) c00142.L$8;
                    Document doc5 = (Document) c00142.L$7;
                    String html7 = (String) c00142.L$6;
                    Map<String, String> map19 = (Map) c00142.L$5;
                    String base10 = (String) c00142.L$4;
                    Function1<? super ExtractorLink, Unit> function22 = (Function1) c00142.L$3;
                    String refererUrl9 = (String) c00142.L$2;
                    String qualityLabel16 = (String) c00142.L$1;
                    String getWatchUrl13 = (String) c00142.L$0;
                    try {
                        ResultKt.throwOnFailure($result2);
                        watchUrl2 = watchUrl4;
                        watchAnchor2 = watchAnchor6;
                        href3 = href6;
                        map3 = map18;
                        map4 = map19;
                        function7 = function22;
                        href = getWatchUrl13;
                        str5 = "m3u8";
                        watchUrl3 = fixedWatchUrl4;
                        doc2 = doc5;
                        html2 = html7;
                        href4 = base10;
                        qualityLabel3 = qualityLabel16;
                        html = refererUrl9;
                        obj3 = $result2;
                        watchHtml = (String) obj3;
                        unescapedWatchHtml = StringsKt.replace$default(watchHtml, "\\/", "/", false, 4, (Object) null);
                        srcRegex = new Regex("const\\s+SRC\\s*=\\s*[\"'](https?://[^\"']+)[\"']");
                        watchRegex = new Regex("(https?://[^\\s'\"]+/watch/[^\\s'\"]*)");
                        map9 = map4;
                        m3u8Regex = new Regex("(https?://[^\\s'\"]+\\.m3u8[^\\s'\"]*)");
                        doc4 = doc2;
                        mp4Regex = new Regex("(https?://[^\\s'\"]+\\.(?:mp4|mkv)[^\\s'\"]*)");
                        getWatchUrl10 = href;
                        matchResultFind$default = Regex.find$default(srcRegex, unescapedWatchHtml, 0, 2, (Object) null);
                        if (matchResultFind$default == null) {
                            matchResultFind$default2 = Regex.find$default(watchRegex, unescapedWatchHtml, 0, 2, (Object) null);
                            if (matchResultFind$default2 != null) {
                                streamUrl = matchResultFind$default2.getValue();
                            } else {
                                matchResultFind$default3 = Regex.find$default(m3u8Regex, unescapedWatchHtml, 0, 2, (Object) null);
                                if (matchResultFind$default3 != null) {
                                    streamUrl = matchResultFind$default3.getValue();
                                } else {
                                    streamUrl = null;
                                }
                                if (streamUrl == null) {
                                    matchResultFind$default4 = Regex.find$default(mp4Regex, unescapedWatchHtml, 0, 2, (Object) null);
                                    if (matchResultFind$default4 != null) {
                                        streamUrl = matchResultFind$default4.getValue();
                                    } else {
                                        streamUrl = null;
                                    }
                                }
                            }
                        } else {
                            matchResultFind$default2 = Regex.find$default(watchRegex, unescapedWatchHtml, 0, 2, (Object) null);
                            if (matchResultFind$default2 != null) {
                                streamUrl = matchResultFind$default2.getValue();
                            } else {
                                matchResultFind$default3 = Regex.find$default(m3u8Regex, unescapedWatchHtml, 0, 2, (Object) null);
                                if (matchResultFind$default3 != null) {
                                    streamUrl = matchResultFind$default3.getValue();
                                } else {
                                    streamUrl = null;
                                }
                                if (streamUrl == null) {
                                    matchResultFind$default4 = Regex.find$default(mp4Regex, unescapedWatchHtml, 0, 2, (Object) null);
                                    if (matchResultFind$default4 != null) {
                                        streamUrl = matchResultFind$default4.getValue();
                                    } else {
                                        streamUrl = null;
                                    }
                                }
                            }
                        }
                        str3 = streamUrl;
                        if (str3 != null) {
                            z2 = true;
                        } else {
                            z2 = true;
                        }
                        if (!z2) {
                            if (StringsKt.startsWith$default(streamUrl, "http", false, 2, (Object) null)) {
                                str4 = streamUrl;
                            } else {
                                str4 = href4 + streamUrl;
                            }
                            resolvedUrl3 = str4;
                            fixedStreamUrl = fixUrlDomain(resolvedUrl3, href4);
                            streamUrl2 = streamUrl;
                            base4 = href4;
                            if (StringsKt.contains$default(fixedStreamUrl, "xcloud", false, 2, (Object) null)) {
                            }
                            c00142.L$0 = SpillingKt.nullOutSpilledVariable(getWatchUrl10);
                            c00142.L$1 = SpillingKt.nullOutSpilledVariable(qualityLabel3);
                            c00142.L$2 = SpillingKt.nullOutSpilledVariable(html);
                            c00142.L$3 = SpillingKt.nullOutSpilledVariable(function7);
                            c00142.L$4 = SpillingKt.nullOutSpilledVariable(base4);
                            c00142.L$5 = SpillingKt.nullOutSpilledVariable(map9);
                            c00142.L$6 = SpillingKt.nullOutSpilledVariable(html2);
                            c00142.L$7 = SpillingKt.nullOutSpilledVariable(doc4);
                            c00142.L$8 = SpillingKt.nullOutSpilledVariable(watchAnchor2);
                            c00142.L$9 = SpillingKt.nullOutSpilledVariable(href3);
                            c00142.L$10 = SpillingKt.nullOutSpilledVariable(watchUrl2);
                            c00142.L$11 = SpillingKt.nullOutSpilledVariable(watchUrl3);
                            c00142.L$12 = SpillingKt.nullOutSpilledVariable(map3);
                            c00142.L$13 = SpillingKt.nullOutSpilledVariable(watchHtml);
                            c00142.L$14 = SpillingKt.nullOutSpilledVariable(unescapedWatchHtml);
                            c00142.L$15 = SpillingKt.nullOutSpilledVariable(srcRegex);
                            c00142.L$16 = SpillingKt.nullOutSpilledVariable(watchRegex);
                            c00142.L$17 = SpillingKt.nullOutSpilledVariable(m3u8Regex);
                            c00142.L$18 = SpillingKt.nullOutSpilledVariable(mp4Regex);
                            c00142.L$19 = SpillingKt.nullOutSpilledVariable(streamUrl2);
                            c00142.L$20 = SpillingKt.nullOutSpilledVariable(resolvedUrl3);
                            c00142.L$21 = SpillingKt.nullOutSpilledVariable(fixedStreamUrl);
                            c00142.label = 4;
                            if (resolveXCloud(fixedStreamUrl, qualityLabel3, function7, c00142) == r34) {
                                return coroutine_suspended;
                            }
                            qualityLabel11 = qualityLabel3;
                            resolvedUrl4 = getWatchUrl10;
                            return Unit.INSTANCE;
                        }
                        String base11 = href4;
                        obj4 = coroutine_suspended;
                        map5 = map9;
                        doc3 = doc4;
                        href = getWatchUrl10;
                        function8 = function7;
                        watchAnchor3 = watchAnchor2;
                        fixedWatchUrl2 = base11;
                        qualityLabel5 = qualityLabel3;
                        html3 = html2;
                        fileAnchor = doc3.selectFirst("a[href*='/file/']");
                        if (fileAnchor == null) {
                            href5 = fileAnchor.attr("href");
                            Map<String, String> map110 = map5;
                            if (StringsKt.startsWith$default(href5, "http", false, 2, (Object) null)) {
                                fileUrl = href5;
                            } else {
                                fileUrl = fixedWatchUrl2 + href5;
                            }
                            fixedFileUrl = fixUrlDomain(fileUrl, fixedWatchUrl2);
                            c00142.L$0 = SpillingKt.nullOutSpilledVariable(href);
                            c00142.L$1 = SpillingKt.nullOutSpilledVariable(qualityLabel5);
                            c00142.L$2 = SpillingKt.nullOutSpilledVariable(html);
                            c00142.L$3 = SpillingKt.nullOutSpilledVariable(function8);
                            c00142.L$4 = SpillingKt.nullOutSpilledVariable(fixedWatchUrl2);
                            c00142.L$5 = SpillingKt.nullOutSpilledVariable(map110);
                            c00142.L$6 = SpillingKt.nullOutSpilledVariable(html3);
                            c00142.L$7 = SpillingKt.nullOutSpilledVariable(doc3);
                            c00142.L$8 = SpillingKt.nullOutSpilledVariable(watchAnchor3);
                            c00142.L$9 = SpillingKt.nullOutSpilledVariable(fileAnchor);
                            c00142.L$10 = SpillingKt.nullOutSpilledVariable(href5);
                            c00142.L$11 = SpillingKt.nullOutSpilledVariable(fileUrl);
                            c00142.L$12 = SpillingKt.nullOutSpilledVariable(fixedFileUrl);
                            c00142.label = 6;
                            getWatchUrl8 = href;
                            function12 = function8;
                            qualityLabel9 = qualityLabel5;
                            if (resolveDirectFile(fixedFileUrl, qualityLabel5, getWatchUrl8, function8, c00142) == obj4) {
                                return obj4;
                            }
                            getWatchUrl9 = getWatchUrl8;
                            function13 = function12;
                            refererUrl6 = html;
                            qualityLabel10 = qualityLabel9;
                            return Unit.INSTANCE;
                        }
                        Function1<? super ExtractorLink, Unit> function114 = function8;
                        movieLinkBDProvider = this;
                        qualityLabel6 = qualityLabel5;
                        qualityLabel7 = href;
                        function3 = function114;
                        map6 = map5;
                        elementSelectFirst = doc3.selectFirst("video source, video[src]");
                        if (elementSelectFirst != null) {
                            videoSrc2 = elementSelectFirst.attr("src");
                            if (videoSrc2 == null) {
                                elementSelectFirst2 = doc3.selectFirst("iframe[src]");
                                if (elementSelectFirst2 != null) {
                                    videoSrc2 = elementSelectFirst2.attr("src");
                                } else {
                                    videoSrc2 = null;
                                }
                            }
                            str = videoSrc2;
                            if (str != null) {
                                z = true;
                            } else {
                                z = true;
                            }
                            if (z) {
                                if (StringsKt.startsWith$default(videoSrc2, "http", false, 2, (Object) null)) {
                                    str2 = videoSrc2;
                                } else {
                                    str2 = fixedWatchUrl2 + videoSrc2;
                                }
                                resolvedUrl = str2;
                                fixedResolvedUrl = movieLinkBDProvider.fixUrlDomain(resolvedUrl, fixedWatchUrl2);
                                videoSrc3 = videoSrc2;
                                base3 = fixedWatchUrl2;
                                watchAnchor4 = watchAnchor3;
                                getWatchUrl3 = null;
                                if (StringsKt.contains$default(fixedResolvedUrl, videoSrc, false, 2, (Object) null)) {
                                }
                                c00142.L$0 = SpillingKt.nullOutSpilledVariable(qualityLabel7);
                                c00142.L$1 = SpillingKt.nullOutSpilledVariable(qualityLabel6);
                                c00142.L$2 = SpillingKt.nullOutSpilledVariable(html);
                                c00142.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                                c00142.L$4 = SpillingKt.nullOutSpilledVariable(base3);
                                c00142.L$5 = SpillingKt.nullOutSpilledVariable(map6);
                                c00142.L$6 = SpillingKt.nullOutSpilledVariable(html3);
                                c00142.L$7 = SpillingKt.nullOutSpilledVariable(doc3);
                                c00142.L$8 = SpillingKt.nullOutSpilledVariable(watchAnchor4);
                                c00142.L$9 = SpillingKt.nullOutSpilledVariable(fileAnchor);
                                c00142.L$10 = SpillingKt.nullOutSpilledVariable(videoSrc3);
                                c00142.L$11 = SpillingKt.nullOutSpilledVariable(resolvedUrl);
                                c00142.L$12 = SpillingKt.nullOutSpilledVariable(fixedResolvedUrl);
                                c00142.label = 7;
                                if (movieLinkBDProvider.resolveXCloud(fixedResolvedUrl, qualityLabel6, function3, c00142) == obj4) {
                                    return obj4;
                                }
                                map7 = map6;
                                getWatchUrl4 = qualityLabel7;
                                function9 = function3;
                                watchAnchor5 = watchAnchor4;
                                refererUrl3 = html;
                                Unit unit16 = Unit.INSTANCE;
                            }
                        } else {
                            elementSelectFirst2 = doc3.selectFirst("iframe[src]");
                            if (elementSelectFirst2 != null) {
                                videoSrc2 = elementSelectFirst2.attr("src");
                            } else {
                                videoSrc2 = null;
                            }
                            str = videoSrc2;
                            if (str != null) {
                                z = true;
                            } else {
                                z = true;
                            }
                            if (z) {
                                if (StringsKt.startsWith$default(videoSrc2, "http", false, 2, (Object) null)) {
                                    str2 = videoSrc2;
                                } else {
                                    str2 = fixedWatchUrl2 + videoSrc2;
                                }
                                resolvedUrl = str2;
                                fixedResolvedUrl = movieLinkBDProvider.fixUrlDomain(resolvedUrl, fixedWatchUrl2);
                                videoSrc3 = videoSrc2;
                                base3 = fixedWatchUrl2;
                                watchAnchor4 = watchAnchor3;
                                getWatchUrl3 = null;
                                if (StringsKt.contains$default(fixedResolvedUrl, videoSrc, false, 2, (Object) null)) {
                                }
                                c00142.L$0 = SpillingKt.nullOutSpilledVariable(qualityLabel7);
                                c00142.L$1 = SpillingKt.nullOutSpilledVariable(qualityLabel6);
                                c00142.L$2 = SpillingKt.nullOutSpilledVariable(html);
                                c00142.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                                c00142.L$4 = SpillingKt.nullOutSpilledVariable(base3);
                                c00142.L$5 = SpillingKt.nullOutSpilledVariable(map6);
                                c00142.L$6 = SpillingKt.nullOutSpilledVariable(html3);
                                c00142.L$7 = SpillingKt.nullOutSpilledVariable(doc3);
                                c00142.L$8 = SpillingKt.nullOutSpilledVariable(watchAnchor4);
                                c00142.L$9 = SpillingKt.nullOutSpilledVariable(fileAnchor);
                                c00142.L$10 = SpillingKt.nullOutSpilledVariable(videoSrc3);
                                c00142.L$11 = SpillingKt.nullOutSpilledVariable(resolvedUrl);
                                c00142.L$12 = SpillingKt.nullOutSpilledVariable(fixedResolvedUrl);
                                c00142.label = 7;
                                if (movieLinkBDProvider.resolveXCloud(fixedResolvedUrl, qualityLabel6, function3, c00142) == obj4) {
                                    return obj4;
                                }
                                map7 = map6;
                                getWatchUrl4 = qualityLabel7;
                                function9 = function3;
                                watchAnchor5 = watchAnchor4;
                                refererUrl3 = html;
                                Unit unit17 = Unit.INSTANCE;
                            }
                        }
                        return Unit.INSTANCE;
                    } catch (Exception e27) {
                        function3 = function22;
                        getWatchUrl3 = getWatchUrl13;
                        qualityLabel3 = qualityLabel16;
                    }
                    return Unit.INSTANCE;
                case 4:
                    Function1<? super ExtractorLink, Unit> function23 = (Function1) c00142.L$3;
                    qualityLabel11 = (String) c00142.L$1;
                    String getWatchUrl14 = (String) c00142.L$0;
                    try {
                        ResultKt.throwOnFailure($result2);
                        resolvedUrl4 = getWatchUrl14;
                        function7 = function23;
                        return Unit.INSTANCE;
                    } catch (Exception e28) {
                        function3 = function23;
                        qualityLabel3 = qualityLabel11;
                        getWatchUrl3 = getWatchUrl14;
                    }
                    break;
                case 5:
                    int i = c00142.I$0;
                    Function1<? super ExtractorLink, Unit> function24 = (Function1) c00142.L$23;
                    Function1<? super ExtractorLink, Unit> function25 = (Function1) c00142.L$3;
                    refererUrl7 = (String) c00142.L$2;
                    qualityLabel12 = (String) c00142.L$1;
                    getWatchUrl11 = (String) c00142.L$0;
                    try {
                        ResultKt.throwOnFailure($result2);
                        function7 = function25;
                        function14 = function24;
                        function14.invoke($result2);
                        return Unit.INSTANCE;
                    } catch (Exception e29) {
                        function3 = function25;
                        qualityLabel3 = qualityLabel12;
                        getWatchUrl3 = getWatchUrl11;
                    }
                    break;
                case 6:
                    function13 = (Function1) c00142.L$3;
                    refererUrl6 = (String) c00142.L$2;
                    qualityLabel10 = (String) c00142.L$1;
                    getWatchUrl9 = (String) c00142.L$0;
                    ResultKt.throwOnFailure($result2);
                    return Unit.INSTANCE;
                case 7:
                    watchAnchor5 = (Element) c00142.L$8;
                    Map<String, String> map20 = (Map) c00142.L$5;
                    function9 = (Function1) c00142.L$3;
                    refererUrl3 = (String) c00142.L$2;
                    String qualityLabel17 = (String) c00142.L$1;
                    getWatchUrl4 = (String) c00142.L$0;
                    ResultKt.throwOnFailure($result2);
                    map7 = map20;
                    qualityLabel6 = qualityLabel17;
                    Unit unit18 = Unit.INSTANCE;
                    return Unit.INSTANCE;
                case 8:
                    map8 = (Map) c00142.L$5;
                    function11 = (Function1) c00142.L$3;
                    refererUrl5 = (String) c00142.L$2;
                    qualityLabel8 = (String) c00142.L$1;
                    getWatchUrl7 = (String) c00142.L$0;
                    ResultKt.throwOnFailure($result2);
                    movieLinkBDProvider = this;
                    qualityLabel6 = qualityLabel8;
                    return Unit.INSTANCE;
                case 9:
                    int i2 = c00142.I$0;
                    function10 = (Function1) c00142.L$14;
                    fixedResolvedUrl2 = (String) c00142.L$12;
                    resolvedUrl2 = (String) c00142.L$11;
                    getWatchUrl6 = (String) c00142.L$10;
                    fileAnchor2 = (Element) c00142.L$9;
                    doc3 = (Document) c00142.L$7;
                    html3 = (String) c00142.L$6;
                    Object base12 = (String) c00142.L$4;
                    Function1<? super ExtractorLink, Unit> function26 = (Function1) c00142.L$3;
                    refererUrl4 = (String) c00142.L$2;
                    String qualityLabel18 = (String) c00142.L$1;
                    getWatchUrl5 = (String) c00142.L$0;
                    try {
                        ResultKt.throwOnFailure($result2);
                        objNewExtractorLink = $result2;
                        $result = base12;
                        function3 = function26;
                        qualityLabel6 = qualityLabel18;
                        function10.invoke(objNewExtractorLink);
                        Unit unit19 = Unit.INSTANCE;
                    } catch (Exception e30) {
                        function3 = function26;
                        qualityLabel3 = qualityLabel18;
                        getWatchUrl3 = getWatchUrl5;
                        break;
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Exception e31) {
            qualityLabel3 = qualityLabel2;
            getWatchUrl3 = getWatchUrl2;
            function3 = function2;
        }
    }

    /* JADX INFO: renamed from: com.cncverse.MovieLinkBDProvider$resolveGetWatch$2 */
    /* JADX INFO: compiled from: MovieLinkBDProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.MovieLinkBDProvider$resolveGetWatch$2", f = "MovieLinkBDProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00152 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $fixedWatchUrl;
        final /* synthetic */ int $quality;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MovieLinkBDProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00152(String str, int i, MovieLinkBDProvider movieLinkBDProvider, Continuation<? super C00152> continuation) {
            super(2, continuation);
            this.$fixedWatchUrl = str;
            this.$quality = i;
            this.this$0 = movieLinkBDProvider;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00152 = new C00152(this.$fixedWatchUrl, this.$quality, this.this$0, continuation);
            c00152.L$0 = obj;
            return c00152;
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
                    $this$newExtractorLink.setReferer(this.$fixedWatchUrl);
                    $this$newExtractorLink.setQuality(this.$quality);
                    $this$newExtractorLink.setHeaders(MapsKt.plus(this.this$0.headers, MapsKt.mapOf(TuplesKt.to("Referer", this.$fixedWatchUrl))));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit resolveGetWatch$lambda$0(SubtitleFile it) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.cncverse.MovieLinkBDProvider$resolveGetWatch$4 */
    /* JADX INFO: compiled from: MovieLinkBDProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.MovieLinkBDProvider$resolveGetWatch$4", f = "MovieLinkBDProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00164 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $getWatchUrl;
        final /* synthetic */ int $quality;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MovieLinkBDProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00164(String str, int i, MovieLinkBDProvider movieLinkBDProvider, Continuation<? super C00164> continuation) {
            super(2, continuation);
            this.$getWatchUrl = str;
            this.$quality = i;
            this.this$0 = movieLinkBDProvider;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00164 = new C00164(this.$getWatchUrl, this.$quality, this.this$0, continuation);
            c00164.L$0 = obj;
            return c00164;
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
                    $this$newExtractorLink.setReferer(this.$getWatchUrl);
                    $this$newExtractorLink.setQuality(this.$quality);
                    $this$newExtractorLink.setHeaders(MapsKt.plus(this.this$0.headers, MapsKt.mapOf(TuplesKt.to("Referer", this.$getWatchUrl))));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:140:0x0213 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:35:0x0206  */
    /* JADX WARN: Code duplicated, block: B:39:0x020f  */
    /* JADX WARN: Code duplicated, block: B:47:0x025a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:48:0x025b  */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x025b -> B:128:0x026f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x02d5 -> B:31:0x01f2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:86:0x03b2 -> B:136:0x03ca). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:99:0x0434 -> B:71:0x0367). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    public final java.lang.Object resolveXCloud(java.lang.String r40, java.lang.String r41, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r42, kotlin.coroutines.Continuation<? super kotlin.Unit> r43) {
        /*
            Method dump skipped, instruction units count: 1452
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cncverse.MovieLinkBDProvider.resolveXCloud(java.lang.String, java.lang.String, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final String resolveXCloud$extractStreamUrl(String TAG, String $qualityLabel, MovieLinkBDProvider this$0, String streamPlayerUrl, String html, String source) {
        String value;
        List groupValues;
        String str;
        Object obj;
        List groupValues2;
        List groupValues3;
        if (html.length() < 100) {
            return null;
        }
        String unescaped = StringsKt.replace$default(html, "\\/", "/", false, 4, (Object) null);
        Log.d(TAG, '[' + $qualityLabel + "][" + source + "] len=" + html.length() + " hasSRC=" + StringsKt.contains$default(html, "SRC", false, 2, (Object) null) + " hasM3u8=" + StringsKt.contains$default(html, "m3u8", false, 2, (Object) null) + " hasMp4=" + StringsKt.contains$default(html, ".mp4", false, 2, (Object) null));
        Regex srcRegex = new Regex("const\\s+SRC\\s*=\\s*[\"'](https?://[^\"']+)[\"']");
        Regex fileRegex = new Regex("(?:file|src)\\s*:\\s*[\"'](https?://[^\"']+\\.(?:m3u8|mp4|mkv)[^\"']*)");
        Regex m3u8Regex = new Regex("(https?://[^\\s'\"<>]+\\.m3u8[^\\s'\"<>]*)");
        Regex mp4Regex = new Regex("(https?://[^\\s'\"<>]+\\.(?:mp4|mkv)[^\\s'\"<>]*)");
        Regex redirectRegex = new Regex("file\\s*:\\s*[\"'](/apis/redirect/[^\"']+)");
        MatchResult matchResultFind$default = Regex.find$default(srcRegex, unescaped, 0, 2, (Object) null);
        if (matchResultFind$default == null || (groupValues3 = matchResultFind$default.getGroupValues()) == null || (value = (String) groupValues3.get(1)) == null) {
            MatchResult matchResultFind$default2 = Regex.find$default(fileRegex, unescaped, 0, 2, (Object) null);
            if (matchResultFind$default2 == null || (groupValues = matchResultFind$default2.getGroupValues()) == null) {
                MatchResult matchResultFind$default3 = Regex.find$default(m3u8Regex, unescaped, 0, 2, (Object) null);
                value = matchResultFind$default3 != null ? matchResultFind$default3.getValue() : null;
                if (value == null) {
                    MatchResult matchResultFind$default4 = Regex.find$default(mp4Regex, unescaped, 0, 2, (Object) null);
                    value = matchResultFind$default4 != null ? matchResultFind$default4.getValue() : null;
                }
            } else {
                value = (String) groupValues.get(1);
            }
        }
        String found = value;
        String str2 = found;
        if (!(str2 == null || str2.length() == 0)) {
            Log.d(TAG, '[' + $qualityLabel + "][" + source + "] found: " + found);
            return found;
        }
        MatchResult matchResultFind$default5 = Regex.find$default(redirectRegex, unescaped, 0, 2, (Object) null);
        String redirectPath = (matchResultFind$default5 == null || (groupValues2 = matchResultFind$default5.getGroupValues()) == null) ? null : (String) groupValues2.get(1);
        String str3 = redirectPath;
        if (str3 == null || str3.length() == 0) {
            str = null;
        } else {
            try {
                Result.Companion companion = Result.Companion;
                str = null;
                try {
                    obj = Result.constructor-impl(new URI(streamPlayerUrl));
                } catch (Throwable th) {
                    th = th;
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
            } catch (Throwable th2) {
                th = th2;
                str = null;
            }
            if (Result.isFailure-impl(obj)) {
                obj = str;
            }
            URI uri = (URI) obj;
            String full = uri != null ? uri.getScheme() + "://" + uri.getHost() + redirectPath : str;
            String str4 = full;
            if (!(str4 == null || str4.length() == 0)) {
                Log.d(TAG, '[' + $qualityLabel + "][" + source + "] redirect: " + full);
                return full;
            }
        }
        Log.d(TAG, '[' + $qualityLabel + "][" + source + "] no stream found. snippet: " + StringsKt.take(html, 300));
        return str;
    }

    /* JADX INFO: renamed from: com.cncverse.MovieLinkBDProvider$resolveXCloud$2 */
    /* JADX INFO: compiled from: MovieLinkBDProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.MovieLinkBDProvider$resolveXCloud$2", f = "MovieLinkBDProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00212 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $quality;
        final /* synthetic */ String $streamPlayerUrl;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MovieLinkBDProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00212(String str, int i, MovieLinkBDProvider movieLinkBDProvider, Continuation<? super C00212> continuation) {
            super(2, continuation);
            this.$streamPlayerUrl = str;
            this.$quality = i;
            this.this$0 = movieLinkBDProvider;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00212 = new C00212(this.$streamPlayerUrl, this.$quality, this.this$0, continuation);
            c00212.L$0 = obj;
            return c00212;
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
                    $this$newExtractorLink.setReferer(this.$streamPlayerUrl);
                    $this$newExtractorLink.setQuality(this.$quality);
                    $this$newExtractorLink.setHeaders(MapsKt.plus(this.this$0.headers, MapsKt.mapOf(TuplesKt.to("Referer", this.$streamPlayerUrl))));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:40:0x014c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:41:0x014d  */
    /* JADX WARN: Code duplicated, block: B:46:0x0197 A[Catch: Exception -> 0x030b, TryCatch #4 {Exception -> 0x030b, blocks: (B:44:0x0191, B:46:0x0197, B:48:0x019d, B:52:0x01a8, B:54:0x01b3, B:55:0x01b8, B:57:0x01c4, B:60:0x01cc, B:62:0x01d7, B:64:0x01dd, B:66:0x01e3, B:72:0x01f1, B:76:0x020f, B:78:0x0231, B:80:0x0236, B:79:0x0234, B:75:0x01fe), top: B:114:0x0191 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x01a7 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:54:0x01b3 A[Catch: Exception -> 0x030b, TryCatch #4 {Exception -> 0x030b, blocks: (B:44:0x0191, B:46:0x0197, B:48:0x019d, B:52:0x01a8, B:54:0x01b3, B:55:0x01b8, B:57:0x01c4, B:60:0x01cc, B:62:0x01d7, B:64:0x01dd, B:66:0x01e3, B:72:0x01f1, B:76:0x020f, B:78:0x0231, B:80:0x0236, B:79:0x0234, B:75:0x01fe), top: B:114:0x0191 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x01b8 A[Catch: Exception -> 0x030b, TryCatch #4 {Exception -> 0x030b, blocks: (B:44:0x0191, B:46:0x0197, B:48:0x019d, B:52:0x01a8, B:54:0x01b3, B:55:0x01b8, B:57:0x01c4, B:60:0x01cc, B:62:0x01d7, B:64:0x01dd, B:66:0x01e3, B:72:0x01f1, B:76:0x020f, B:78:0x0231, B:80:0x0236, B:79:0x0234, B:75:0x01fe), top: B:114:0x0191 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x01c4 A[Catch: Exception -> 0x030b, TryCatch #4 {Exception -> 0x030b, blocks: (B:44:0x0191, B:46:0x0197, B:48:0x019d, B:52:0x01a8, B:54:0x01b3, B:55:0x01b8, B:57:0x01c4, B:60:0x01cc, B:62:0x01d7, B:64:0x01dd, B:66:0x01e3, B:72:0x01f1, B:76:0x020f, B:78:0x0231, B:80:0x0236, B:79:0x0234, B:75:0x01fe), top: B:114:0x0191 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:60:0x01cc A[Catch: Exception -> 0x030b, TryCatch #4 {Exception -> 0x030b, blocks: (B:44:0x0191, B:46:0x0197, B:48:0x019d, B:52:0x01a8, B:54:0x01b3, B:55:0x01b8, B:57:0x01c4, B:60:0x01cc, B:62:0x01d7, B:64:0x01dd, B:66:0x01e3, B:72:0x01f1, B:76:0x020f, B:78:0x0231, B:80:0x0236, B:79:0x0234, B:75:0x01fe), top: B:114:0x0191 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x01d7 A[Catch: Exception -> 0x030b, TryCatch #4 {Exception -> 0x030b, blocks: (B:44:0x0191, B:46:0x0197, B:48:0x019d, B:52:0x01a8, B:54:0x01b3, B:55:0x01b8, B:57:0x01c4, B:60:0x01cc, B:62:0x01d7, B:64:0x01dd, B:66:0x01e3, B:72:0x01f1, B:76:0x020f, B:78:0x0231, B:80:0x0236, B:79:0x0234, B:75:0x01fe), top: B:114:0x0191 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:66:0x01e3 A[Catch: Exception -> 0x030b, TryCatch #4 {Exception -> 0x030b, blocks: (B:44:0x0191, B:46:0x0197, B:48:0x019d, B:52:0x01a8, B:54:0x01b3, B:55:0x01b8, B:57:0x01c4, B:60:0x01cc, B:62:0x01d7, B:64:0x01dd, B:66:0x01e3, B:72:0x01f1, B:76:0x020f, B:78:0x0231, B:80:0x0236, B:79:0x0234, B:75:0x01fe), top: B:114:0x0191 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:72:0x01f1 A[Catch: Exception -> 0x030b, TryCatch #4 {Exception -> 0x030b, blocks: (B:44:0x0191, B:46:0x0197, B:48:0x019d, B:52:0x01a8, B:54:0x01b3, B:55:0x01b8, B:57:0x01c4, B:60:0x01cc, B:62:0x01d7, B:64:0x01dd, B:66:0x01e3, B:72:0x01f1, B:76:0x020f, B:78:0x0231, B:80:0x0236, B:79:0x0234, B:75:0x01fe), top: B:114:0x0191 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:75:0x01fe A[Catch: Exception -> 0x030b, TryCatch #4 {Exception -> 0x030b, blocks: (B:44:0x0191, B:46:0x0197, B:48:0x019d, B:52:0x01a8, B:54:0x01b3, B:55:0x01b8, B:57:0x01c4, B:60:0x01cc, B:62:0x01d7, B:64:0x01dd, B:66:0x01e3, B:72:0x01f1, B:76:0x020f, B:78:0x0231, B:80:0x0236, B:79:0x0234, B:75:0x01fe), top: B:114:0x0191 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x0231 A[Catch: Exception -> 0x030b, TryCatch #4 {Exception -> 0x030b, blocks: (B:44:0x0191, B:46:0x0197, B:48:0x019d, B:52:0x01a8, B:54:0x01b3, B:55:0x01b8, B:57:0x01c4, B:60:0x01cc, B:62:0x01d7, B:64:0x01dd, B:66:0x01e3, B:72:0x01f1, B:76:0x020f, B:78:0x0231, B:80:0x0236, B:79:0x0234, B:75:0x01fe), top: B:114:0x0191 }] */
    /* JADX WARN: Code duplicated, block: B:79:0x0234 A[Catch: Exception -> 0x030b, TryCatch #4 {Exception -> 0x030b, blocks: (B:44:0x0191, B:46:0x0197, B:48:0x019d, B:52:0x01a8, B:54:0x01b3, B:55:0x01b8, B:57:0x01c4, B:60:0x01cc, B:62:0x01d7, B:64:0x01dd, B:66:0x01e3, B:72:0x01f1, B:76:0x020f, B:78:0x0231, B:80:0x0236, B:79:0x0234, B:75:0x01fe), top: B:114:0x0191 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:82:0x02e6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:83:0x02e7  */
    /* JADX WARN: Code duplicated, block: B:88:0x0301  */
    public final Object resolveDirectFile(String fileUrl, String qualityLabel, String refererUrl, Function1<? super ExtractorLink, Unit> function1, Continuation<? super Unit> continuation) {
        C00101 c00101;
        String refererUrl2;
        String refererUrl3;
        Object base;
        String refererUrl4;
        Function1<? super ExtractorLink, Unit> function2;
        String base2;
        Map<String, String> mapPlus;
        Object objHttpGetText;
        Function1<? super ExtractorLink, Unit> function3;
        Object obj;
        String base3;
        Map<String, String> map;
        String base4;
        String fileUrl2;
        String html;
        String unescapedHtml;
        Regex srcRegex;
        Regex watchRegex;
        Regex m3u8Regex;
        Regex mp4Regex;
        String refererUrl5;
        MatchResult matchResultFind$default;
        String value;
        String streamUrl;
        String str;
        boolean z;
        String resolvedUrl;
        String fixedStreamUrl;
        ExtractorLinkType type;
        Object objNewExtractorLink;
        String refererUrl6;
        Function1<? super ExtractorLink, Unit> function4;
        MatchResult matchResultFind$default2;
        MatchResult matchResultFind$default3;
        MatchResult matchResultFind$default4;
        List groupValues;
        if (continuation instanceof C00101) {
            c00101 = (C00101) continuation;
            if ((c00101.label & Integer.MIN_VALUE) != 0) {
                c00101.label -= Integer.MIN_VALUE;
            } else {
                c00101 = new C00101(continuation);
            }
        } else {
            c00101 = new C00101(continuation);
        }
        C00101 c00102 = c00101;
        Object $result = c00102.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00102.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                try {
                    c00102.L$0 = fileUrl;
                    refererUrl3 = qualityLabel;
                    try {
                        c00102.L$1 = refererUrl3;
                        refererUrl2 = refererUrl;
                        try {
                            c00102.L$2 = refererUrl2;
                            try {
                                c00102.L$3 = function1;
                                c00102.label = 1;
                                base = getBase(c00102);
                                if (base == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                refererUrl4 = fileUrl;
                                function2 = function1;
                                try {
                                    base2 = (String) base;
                                    mapPlus = MapsKt.plus(this.headers, MapsKt.mapOf(TuplesKt.to("Referer", refererUrl2)));
                                    c00102.L$0 = refererUrl4;
                                    c00102.L$1 = refererUrl3;
                                    c00102.L$2 = SpillingKt.nullOutSpilledVariable(refererUrl2);
                                    c00102.L$3 = function2;
                                    c00102.L$4 = base2;
                                    c00102.L$5 = SpillingKt.nullOutSpilledVariable(mapPlus);
                                    c00102.label = 2;
                                    objHttpGetText = httpGetText(refererUrl4, mapPlus, c00102);
                                    if (objHttpGetText == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    function3 = function2;
                                    obj = objHttpGetText;
                                    base3 = base2;
                                    map = mapPlus;
                                    base4 = refererUrl3;
                                    fileUrl2 = refererUrl2;
                                    try {
                                        html = (String) obj;
                                        unescapedHtml = StringsKt.replace$default(html, "\\/", "/", false, 4, (Object) null);
                                        srcRegex = new Regex("const\\s+SRC\\s*=\\s*[\"'](https?://[^\"']+)[\"']");
                                        watchRegex = new Regex("(https?://[^\\s'\"]+/watch/[^\\s'\"]*)");
                                        m3u8Regex = new Regex("(https?://[^\\s'\"]+\\.m3u8[^\\s'\"]*)");
                                        mp4Regex = new Regex("(https?://[^\\s'\"]+\\.(?:mp4|mkv)[^\\s'\"]*)");
                                        refererUrl5 = fileUrl2;
                                        try {
                                            matchResultFind$default = Regex.find$default(srcRegex, unescapedHtml, 0, 2, (Object) null);
                                            if (matchResultFind$default != null || (groupValues = matchResultFind$default.getGroupValues()) == null || (value = (String) groupValues.get(1)) == null) {
                                                matchResultFind$default2 = Regex.find$default(watchRegex, unescapedHtml, 0, 2, (Object) null);
                                                if (matchResultFind$default2 != null) {
                                                    value = matchResultFind$default2.getValue();
                                                } else {
                                                    matchResultFind$default3 = Regex.find$default(m3u8Regex, unescapedHtml, 0, 2, (Object) null);
                                                    if (matchResultFind$default3 != null) {
                                                        value = matchResultFind$default3.getValue();
                                                    } else {
                                                        value = null;
                                                    }
                                                    if (value == null) {
                                                        matchResultFind$default4 = Regex.find$default(mp4Regex, unescapedHtml, 0, 2, (Object) null);
                                                        if (matchResultFind$default4 != null) {
                                                            value = matchResultFind$default4.getValue();
                                                        } else {
                                                            value = null;
                                                        }
                                                    }
                                                }
                                                streamUrl = value;
                                                str = streamUrl;
                                                if (str != null || str.length() == 0) {
                                                    z = true;
                                                } else {
                                                    z = false;
                                                }
                                                if (z) {
                                                    if (StringsKt.startsWith$default(streamUrl, "http", false, 2, (Object) null)) {
                                                        resolvedUrl = streamUrl;
                                                    } else {
                                                        resolvedUrl = base3 + streamUrl;
                                                    }
                                                    fixedStreamUrl = fixUrlDomain(resolvedUrl, base3);
                                                    int quality = labelToQuality(base4);
                                                    String resolvedUrl2 = resolvedUrl;
                                                    if (StringsKt.contains$default(fixedStreamUrl, "m3u8", false, 2, (Object) null)) {
                                                        type = ExtractorLinkType.M3U8;
                                                    } else {
                                                        type = ExtractorLinkType.VIDEO;
                                                    }
                                                    String name = getName();
                                                    String str2 = getName() + " Direct [" + base4 + ']';
                                                    ExtractorLinkType type2 = type;
                                                    C00112 c00112 = new C00112(refererUrl4, quality, this, null);
                                                    c00102.L$0 = SpillingKt.nullOutSpilledVariable(refererUrl4);
                                                    c00102.L$1 = SpillingKt.nullOutSpilledVariable(base4);
                                                    c00102.L$2 = SpillingKt.nullOutSpilledVariable(refererUrl5);
                                                    c00102.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                                                    c00102.L$4 = SpillingKt.nullOutSpilledVariable(base3);
                                                    c00102.L$5 = SpillingKt.nullOutSpilledVariable(map);
                                                    c00102.L$6 = SpillingKt.nullOutSpilledVariable(html);
                                                    c00102.L$7 = SpillingKt.nullOutSpilledVariable(unescapedHtml);
                                                    c00102.L$8 = SpillingKt.nullOutSpilledVariable(srcRegex);
                                                    c00102.L$9 = SpillingKt.nullOutSpilledVariable(watchRegex);
                                                    c00102.L$10 = SpillingKt.nullOutSpilledVariable(m3u8Regex);
                                                    c00102.L$11 = SpillingKt.nullOutSpilledVariable(mp4Regex);
                                                    c00102.L$12 = SpillingKt.nullOutSpilledVariable(streamUrl);
                                                    c00102.L$13 = SpillingKt.nullOutSpilledVariable(resolvedUrl2);
                                                    c00102.L$14 = SpillingKt.nullOutSpilledVariable(fixedStreamUrl);
                                                    c00102.L$15 = SpillingKt.nullOutSpilledVariable(type2);
                                                    c00102.L$16 = function3;
                                                    c00102.I$0 = quality;
                                                    c00102.label = 3;
                                                    objNewExtractorLink = ExtractorApiKt.newExtractorLink(name, str2, fixedStreamUrl, type2, c00112, c00102);
                                                    if (objNewExtractorLink == coroutine_suspended) {
                                                        return coroutine_suspended;
                                                    }
                                                    refererUrl6 = refererUrl5;
                                                    $result = objNewExtractorLink;
                                                    function4 = function3;
                                                    try {
                                                        function4.invoke($result);
                                                    } catch (Exception e) {
                                                        refererUrl2 = refererUrl6;
                                                    }
                                                }
                                            } else {
                                                streamUrl = value;
                                                str = streamUrl;
                                                if (str != null) {
                                                    z = true;
                                                } else {
                                                    z = true;
                                                }
                                                if (z) {
                                                    if (StringsKt.startsWith$default(streamUrl, "http", false, 2, (Object) null)) {
                                                        resolvedUrl = streamUrl;
                                                    } else {
                                                        resolvedUrl = base3 + streamUrl;
                                                    }
                                                    fixedStreamUrl = fixUrlDomain(resolvedUrl, base3);
                                                    int quality2 = labelToQuality(base4);
                                                    String resolvedUrl3 = resolvedUrl;
                                                    if (StringsKt.contains$default(fixedStreamUrl, "m3u8", false, 2, (Object) null)) {
                                                        type = ExtractorLinkType.M3U8;
                                                    } else {
                                                        type = ExtractorLinkType.VIDEO;
                                                    }
                                                    String name2 = getName();
                                                    String str3 = getName() + " Direct [" + base4 + ']';
                                                    ExtractorLinkType type3 = type;
                                                    C00112 c00113 = new C00112(refererUrl4, quality2, this, null);
                                                    c00102.L$0 = SpillingKt.nullOutSpilledVariable(refererUrl4);
                                                    c00102.L$1 = SpillingKt.nullOutSpilledVariable(base4);
                                                    c00102.L$2 = SpillingKt.nullOutSpilledVariable(refererUrl5);
                                                    c00102.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                                                    c00102.L$4 = SpillingKt.nullOutSpilledVariable(base3);
                                                    c00102.L$5 = SpillingKt.nullOutSpilledVariable(map);
                                                    c00102.L$6 = SpillingKt.nullOutSpilledVariable(html);
                                                    c00102.L$7 = SpillingKt.nullOutSpilledVariable(unescapedHtml);
                                                    c00102.L$8 = SpillingKt.nullOutSpilledVariable(srcRegex);
                                                    c00102.L$9 = SpillingKt.nullOutSpilledVariable(watchRegex);
                                                    c00102.L$10 = SpillingKt.nullOutSpilledVariable(m3u8Regex);
                                                    c00102.L$11 = SpillingKt.nullOutSpilledVariable(mp4Regex);
                                                    c00102.L$12 = SpillingKt.nullOutSpilledVariable(streamUrl);
                                                    c00102.L$13 = SpillingKt.nullOutSpilledVariable(resolvedUrl3);
                                                    c00102.L$14 = SpillingKt.nullOutSpilledVariable(fixedStreamUrl);
                                                    c00102.L$15 = SpillingKt.nullOutSpilledVariable(type3);
                                                    c00102.L$16 = function3;
                                                    c00102.I$0 = quality2;
                                                    c00102.label = 3;
                                                    objNewExtractorLink = ExtractorApiKt.newExtractorLink(name2, str3, fixedStreamUrl, type3, c00113, c00102);
                                                    if (objNewExtractorLink == coroutine_suspended) {
                                                        return coroutine_suspended;
                                                    }
                                                    refererUrl6 = refererUrl5;
                                                    $result = objNewExtractorLink;
                                                    function4 = function3;
                                                    function4.invoke($result);
                                                }
                                            }
                                        } catch (Exception e2) {
                                            refererUrl2 = refererUrl5;
                                            return Unit.INSTANCE;
                                        }
                                    } catch (Exception e3) {
                                        refererUrl2 = fileUrl2;
                                    }
                                    return Unit.INSTANCE;
                                } catch (Exception e4) {
                                    return Unit.INSTANCE;
                                }
                            } catch (Exception e5) {
                                return Unit.INSTANCE;
                            }
                        } catch (Exception e6) {
                        }
                    } catch (Exception e7) {
                        refererUrl2 = refererUrl;
                    }
                } catch (Exception e8) {
                    refererUrl2 = refererUrl;
                }
                break;
            case 1:
                function2 = (Function1) c00102.L$3;
                String refererUrl7 = (String) c00102.L$2;
                String qualityLabel2 = (String) c00102.L$1;
                refererUrl4 = (String) c00102.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    refererUrl2 = refererUrl7;
                    refererUrl3 = qualityLabel2;
                    base = $result;
                    base2 = (String) base;
                    mapPlus = MapsKt.plus(this.headers, MapsKt.mapOf(TuplesKt.to("Referer", refererUrl2)));
                    c00102.L$0 = refererUrl4;
                    c00102.L$1 = refererUrl3;
                    c00102.L$2 = SpillingKt.nullOutSpilledVariable(refererUrl2);
                    c00102.L$3 = function2;
                    c00102.L$4 = base2;
                    c00102.L$5 = SpillingKt.nullOutSpilledVariable(mapPlus);
                    c00102.label = 2;
                    objHttpGetText = httpGetText(refererUrl4, mapPlus, c00102);
                    if (objHttpGetText == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function3 = function2;
                    obj = objHttpGetText;
                    base3 = base2;
                    map = mapPlus;
                    base4 = refererUrl3;
                    fileUrl2 = refererUrl2;
                    html = (String) obj;
                    unescapedHtml = StringsKt.replace$default(html, "\\/", "/", false, 4, (Object) null);
                    srcRegex = new Regex("const\\s+SRC\\s*=\\s*[\"'](https?://[^\"']+)[\"']");
                    watchRegex = new Regex("(https?://[^\\s'\"]+/watch/[^\\s'\"]*)");
                    m3u8Regex = new Regex("(https?://[^\\s'\"]+\\.m3u8[^\\s'\"]*)");
                    mp4Regex = new Regex("(https?://[^\\s'\"]+\\.(?:mp4|mkv)[^\\s'\"]*)");
                    refererUrl5 = fileUrl2;
                    matchResultFind$default = Regex.find$default(srcRegex, unescapedHtml, 0, 2, (Object) null);
                    if (matchResultFind$default != null) {
                        matchResultFind$default2 = Regex.find$default(watchRegex, unescapedHtml, 0, 2, (Object) null);
                        if (matchResultFind$default2 != null) {
                            value = matchResultFind$default2.getValue();
                        } else {
                            matchResultFind$default3 = Regex.find$default(m3u8Regex, unescapedHtml, 0, 2, (Object) null);
                            if (matchResultFind$default3 != null) {
                                value = matchResultFind$default3.getValue();
                            } else {
                                value = null;
                            }
                            if (value == null) {
                                matchResultFind$default4 = Regex.find$default(mp4Regex, unescapedHtml, 0, 2, (Object) null);
                                if (matchResultFind$default4 != null) {
                                    value = matchResultFind$default4.getValue();
                                } else {
                                    value = null;
                                }
                            }
                        }
                    } else {
                        matchResultFind$default2 = Regex.find$default(watchRegex, unescapedHtml, 0, 2, (Object) null);
                        if (matchResultFind$default2 != null) {
                            value = matchResultFind$default2.getValue();
                        } else {
                            matchResultFind$default3 = Regex.find$default(m3u8Regex, unescapedHtml, 0, 2, (Object) null);
                            if (matchResultFind$default3 != null) {
                                value = matchResultFind$default3.getValue();
                            } else {
                                value = null;
                            }
                            if (value == null) {
                                matchResultFind$default4 = Regex.find$default(mp4Regex, unescapedHtml, 0, 2, (Object) null);
                                if (matchResultFind$default4 != null) {
                                    value = matchResultFind$default4.getValue();
                                } else {
                                    value = null;
                                }
                            }
                        }
                    }
                    streamUrl = value;
                    str = streamUrl;
                    if (str != null) {
                        z = true;
                    } else {
                        z = true;
                    }
                    if (z) {
                        if (StringsKt.startsWith$default(streamUrl, "http", false, 2, (Object) null)) {
                            resolvedUrl = streamUrl;
                        } else {
                            resolvedUrl = base3 + streamUrl;
                        }
                        fixedStreamUrl = fixUrlDomain(resolvedUrl, base3);
                        int quality3 = labelToQuality(base4);
                        String resolvedUrl4 = resolvedUrl;
                        if (StringsKt.contains$default(fixedStreamUrl, "m3u8", false, 2, (Object) null)) {
                            type = ExtractorLinkType.M3U8;
                        } else {
                            type = ExtractorLinkType.VIDEO;
                        }
                        String name3 = getName();
                        String str4 = getName() + " Direct [" + base4 + ']';
                        ExtractorLinkType type4 = type;
                        C00112 c00114 = new C00112(refererUrl4, quality3, this, null);
                        c00102.L$0 = SpillingKt.nullOutSpilledVariable(refererUrl4);
                        c00102.L$1 = SpillingKt.nullOutSpilledVariable(base4);
                        c00102.L$2 = SpillingKt.nullOutSpilledVariable(refererUrl5);
                        c00102.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                        c00102.L$4 = SpillingKt.nullOutSpilledVariable(base3);
                        c00102.L$5 = SpillingKt.nullOutSpilledVariable(map);
                        c00102.L$6 = SpillingKt.nullOutSpilledVariable(html);
                        c00102.L$7 = SpillingKt.nullOutSpilledVariable(unescapedHtml);
                        c00102.L$8 = SpillingKt.nullOutSpilledVariable(srcRegex);
                        c00102.L$9 = SpillingKt.nullOutSpilledVariable(watchRegex);
                        c00102.L$10 = SpillingKt.nullOutSpilledVariable(m3u8Regex);
                        c00102.L$11 = SpillingKt.nullOutSpilledVariable(mp4Regex);
                        c00102.L$12 = SpillingKt.nullOutSpilledVariable(streamUrl);
                        c00102.L$13 = SpillingKt.nullOutSpilledVariable(resolvedUrl4);
                        c00102.L$14 = SpillingKt.nullOutSpilledVariable(fixedStreamUrl);
                        c00102.L$15 = SpillingKt.nullOutSpilledVariable(type4);
                        c00102.L$16 = function3;
                        c00102.I$0 = quality3;
                        c00102.label = 3;
                        objNewExtractorLink = ExtractorApiKt.newExtractorLink(name3, str4, fixedStreamUrl, type4, c00114, c00102);
                        if (objNewExtractorLink == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        refererUrl6 = refererUrl5;
                        $result = objNewExtractorLink;
                        function4 = function3;
                        function4.invoke($result);
                    }
                    return Unit.INSTANCE;
                } catch (Exception e9) {
                    refererUrl2 = refererUrl7;
                    return Unit.INSTANCE;
                }
            case 2:
                Map<String, String> map2 = (Map) c00102.L$5;
                String base5 = (String) c00102.L$4;
                Function1<? super ExtractorLink, Unit> function5 = (Function1) c00102.L$3;
                String refererUrl8 = (String) c00102.L$2;
                base4 = (String) c00102.L$1;
                String fileUrl3 = (String) c00102.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    fileUrl2 = refererUrl8;
                    refererUrl4 = fileUrl3;
                    map = map2;
                    base3 = base5;
                    function3 = function5;
                    obj = $result;
                    html = (String) obj;
                    unescapedHtml = StringsKt.replace$default(html, "\\/", "/", false, 4, (Object) null);
                    srcRegex = new Regex("const\\s+SRC\\s*=\\s*[\"'](https?://[^\"']+)[\"']");
                    watchRegex = new Regex("(https?://[^\\s'\"]+/watch/[^\\s'\"]*)");
                    m3u8Regex = new Regex("(https?://[^\\s'\"]+\\.m3u8[^\\s'\"]*)");
                    mp4Regex = new Regex("(https?://[^\\s'\"]+\\.(?:mp4|mkv)[^\\s'\"]*)");
                    refererUrl5 = fileUrl2;
                    matchResultFind$default = Regex.find$default(srcRegex, unescapedHtml, 0, 2, (Object) null);
                    if (matchResultFind$default != null) {
                        matchResultFind$default2 = Regex.find$default(watchRegex, unescapedHtml, 0, 2, (Object) null);
                        if (matchResultFind$default2 != null) {
                            value = matchResultFind$default2.getValue();
                        } else {
                            matchResultFind$default3 = Regex.find$default(m3u8Regex, unescapedHtml, 0, 2, (Object) null);
                            if (matchResultFind$default3 != null) {
                                value = matchResultFind$default3.getValue();
                            } else {
                                value = null;
                            }
                            if (value == null) {
                                matchResultFind$default4 = Regex.find$default(mp4Regex, unescapedHtml, 0, 2, (Object) null);
                                if (matchResultFind$default4 != null) {
                                    value = matchResultFind$default4.getValue();
                                } else {
                                    value = null;
                                }
                            }
                        }
                    } else {
                        matchResultFind$default2 = Regex.find$default(watchRegex, unescapedHtml, 0, 2, (Object) null);
                        if (matchResultFind$default2 != null) {
                            value = matchResultFind$default2.getValue();
                        } else {
                            matchResultFind$default3 = Regex.find$default(m3u8Regex, unescapedHtml, 0, 2, (Object) null);
                            if (matchResultFind$default3 != null) {
                                value = matchResultFind$default3.getValue();
                            } else {
                                value = null;
                            }
                            if (value == null) {
                                matchResultFind$default4 = Regex.find$default(mp4Regex, unescapedHtml, 0, 2, (Object) null);
                                if (matchResultFind$default4 != null) {
                                    value = matchResultFind$default4.getValue();
                                } else {
                                    value = null;
                                }
                            }
                        }
                    }
                    streamUrl = value;
                    str = streamUrl;
                    if (str != null) {
                        z = true;
                    } else {
                        z = true;
                    }
                    if (z) {
                        if (StringsKt.startsWith$default(streamUrl, "http", false, 2, (Object) null)) {
                            resolvedUrl = streamUrl;
                        } else {
                            resolvedUrl = base3 + streamUrl;
                        }
                        fixedStreamUrl = fixUrlDomain(resolvedUrl, base3);
                        int quality4 = labelToQuality(base4);
                        String resolvedUrl5 = resolvedUrl;
                        if (StringsKt.contains$default(fixedStreamUrl, "m3u8", false, 2, (Object) null)) {
                            type = ExtractorLinkType.M3U8;
                        } else {
                            type = ExtractorLinkType.VIDEO;
                        }
                        String name4 = getName();
                        String str5 = getName() + " Direct [" + base4 + ']';
                        ExtractorLinkType type5 = type;
                        C00112 c00115 = new C00112(refererUrl4, quality4, this, null);
                        c00102.L$0 = SpillingKt.nullOutSpilledVariable(refererUrl4);
                        c00102.L$1 = SpillingKt.nullOutSpilledVariable(base4);
                        c00102.L$2 = SpillingKt.nullOutSpilledVariable(refererUrl5);
                        c00102.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                        c00102.L$4 = SpillingKt.nullOutSpilledVariable(base3);
                        c00102.L$5 = SpillingKt.nullOutSpilledVariable(map);
                        c00102.L$6 = SpillingKt.nullOutSpilledVariable(html);
                        c00102.L$7 = SpillingKt.nullOutSpilledVariable(unescapedHtml);
                        c00102.L$8 = SpillingKt.nullOutSpilledVariable(srcRegex);
                        c00102.L$9 = SpillingKt.nullOutSpilledVariable(watchRegex);
                        c00102.L$10 = SpillingKt.nullOutSpilledVariable(m3u8Regex);
                        c00102.L$11 = SpillingKt.nullOutSpilledVariable(mp4Regex);
                        c00102.L$12 = SpillingKt.nullOutSpilledVariable(streamUrl);
                        c00102.L$13 = SpillingKt.nullOutSpilledVariable(resolvedUrl5);
                        c00102.L$14 = SpillingKt.nullOutSpilledVariable(fixedStreamUrl);
                        c00102.L$15 = SpillingKt.nullOutSpilledVariable(type5);
                        c00102.L$16 = function3;
                        c00102.I$0 = quality4;
                        c00102.label = 3;
                        objNewExtractorLink = ExtractorApiKt.newExtractorLink(name4, str5, fixedStreamUrl, type5, c00115, c00102);
                        if (objNewExtractorLink == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        refererUrl6 = refererUrl5;
                        $result = objNewExtractorLink;
                        function4 = function3;
                        function4.invoke($result);
                    }
                } catch (Exception e10) {
                    refererUrl2 = refererUrl8;
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            case 3:
                int i = c00102.I$0;
                function4 = (Function1) c00102.L$16;
                String refererUrl9 = (String) c00102.L$2;
                try {
                    ResultKt.throwOnFailure($result);
                    refererUrl6 = refererUrl9;
                    function4.invoke($result);
                } catch (Exception e11) {
                    refererUrl2 = refererUrl9;
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.cncverse.MovieLinkBDProvider$resolveDirectFile$2 */
    /* JADX INFO: compiled from: MovieLinkBDProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.MovieLinkBDProvider$resolveDirectFile$2", f = "MovieLinkBDProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00112 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $fileUrl;
        final /* synthetic */ int $quality;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MovieLinkBDProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00112(String str, int i, MovieLinkBDProvider movieLinkBDProvider, Continuation<? super C00112> continuation) {
            super(2, continuation);
            this.$fileUrl = str;
            this.$quality = i;
            this.this$0 = movieLinkBDProvider;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00112 = new C00112(this.$fileUrl, this.$quality, this.this$0, continuation);
            c00112.L$0 = obj;
            return c00112;
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
                    $this$newExtractorLink.setReferer(this.$fileUrl);
                    $this$newExtractorLink.setQuality(this.$quality);
                    $this$newExtractorLink.setHeaders(MapsKt.plus(this.this$0.headers, MapsKt.mapOf(TuplesKt.to("Referer", this.$fileUrl))));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String fixUrlDomain(String url, String base) {
        String it;
        String it2;
        if (url.length() == 0) {
            return url;
        }
        try {
            URI uri = new URI(url);
            if (uri.getHost() == null || !StringsKt.contains$default(uri.getHost(), "movielinkbd", false, 2, (Object) null) || StringsKt.contains$default(uri.getHost(), "play", false, 2, (Object) null)) {
                return url;
            }
            String path = uri.getRawPath();
            String fragment = "";
            if (path == null) {
                path = "";
            }
            String it3 = uri.getRawQuery();
            if (it3 == null || (it = '?' + it3) == null) {
                it = "";
            }
            String it4 = uri.getRawFragment();
            if (it4 != null && (it2 = '#' + it4) != null) {
                fragment = it2;
            }
            return StringsKt.trimEnd(base, new char[]{'/'}) + '/' + StringsKt.trimStart(path, new char[]{'/'}) + it + fragment;
        } catch (Exception e) {
            return url;
        }
    }

    private final String extractQualityLabel(String text) {
        if (StringsKt.contains(text, "4K", true) || StringsKt.contains(text, "2160", true)) {
            return "4K";
        }
        if (StringsKt.contains(text, "1080", true)) {
            return "1080p";
        }
        if (StringsKt.contains(text, "720p HEVC", true) || StringsKt.contains(text, "720 HEVC", true)) {
            return "720p HEVC";
        }
        if (StringsKt.contains(text, "720", true)) {
            return "720p";
        }
        if (StringsKt.contains(text, "480", true)) {
            return "480p";
        }
        if (StringsKt.contains(text, "360", true)) {
            return "360p";
        }
        if (StringsKt.contains(text, "Watch Online", true)) {
            return "Stream";
        }
        if (StringsKt.contains(text, "Download", true)) {
            return "Download";
        }
        String string = StringsKt.trim(StringsKt.take(text, 30)).toString();
        if (string.length() == 0) {
            string = "Unknown";
        }
        return string;
    }

    private final int labelToQuality(String label) {
        if (StringsKt.contains(label, "4K", true) || StringsKt.contains(label, "2160", true)) {
            return Qualities.P2160.getValue();
        }
        if (StringsKt.contains(label, "1080", true)) {
            return Qualities.P1080.getValue();
        }
        if (StringsKt.contains(label, "720", true)) {
            return Qualities.P720.getValue();
        }
        if (StringsKt.contains(label, "480", true)) {
            return Qualities.P480.getValue();
        }
        return StringsKt.contains(label, "360", true) ? Qualities.P360.getValue() : Qualities.Unknown.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OkHttpClient getCfClient() {
        return (OkHttpClient) this.cfClient.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OkHttpClient cfClient_delegate$lambda$0() {
        return MainActivityKt.getApp().getBaseClient().newBuilder().addInterceptor(new CloudflareKiller()).connectTimeout(30L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS).build();
    }

    /* JADX INFO: renamed from: com.cncverse.MovieLinkBDProvider$httpGetText$2 */
    /* JADX INFO: compiled from: MovieLinkBDProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.MovieLinkBDProvider$httpGetText$2", f = "MovieLinkBDProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nMovieLinkBDProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MovieLinkBDProvider.kt\ncom/cncverse/MovieLinkBDProvider$httpGetText$2\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,1186:1\n221#2,2:1187\n*S KotlinDebug\n*F\n+ 1 MovieLinkBDProvider.kt\ncom/cncverse/MovieLinkBDProvider$httpGetText$2\n*L\n1168#1:1187,2\n*E\n"})
    static final class C00032 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ Map<String, String> $headers;
        final /* synthetic */ String $url;
        int label;
        final /* synthetic */ MovieLinkBDProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00032(Map<String, String> map, String str, MovieLinkBDProvider movieLinkBDProvider, Continuation<? super C00032> continuation) {
            super(2, continuation);
            this.$headers = map;
            this.$url = str;
            this.this$0 = movieLinkBDProvider;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00032(this.$headers, this.$url, this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Headers.Builder reqHeaders = new Headers.Builder();
                    for (Map.Entry<String, String> entry : this.$headers.entrySet()) {
                        String k = entry.getKey();
                        String v = entry.getValue();
                        reqHeaders.add(k, v);
                    }
                    Request request = new Request.Builder().url(this.$url).headers(reqHeaders.build()).get().build();
                    Response response = this.this$0.getCfClient().newCall(request).execute();
                    String body = response.body().string();
                    response.close();
                    return body;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object httpGetText$default(MovieLinkBDProvider movieLinkBDProvider, String str, Map map, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        return movieLinkBDProvider.httpGetText(str, map, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object httpGetText(String url, Map<String, String> map, Continuation<? super String> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C00032(map, url, this, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object httpGetDoc(String url, Map<String, String> map, Continuation<? super Document> continuation) {
        C00021 c00021;
        Object objHttpGetText;
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
                c00021.L$0 = url;
                c00021.L$1 = SpillingKt.nullOutSpilledVariable(map);
                c00021.label = 1;
                objHttpGetText = httpGetText(url, map, c00021);
                if (objHttpGetText == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                url = (String) c00021.L$0;
                ResultKt.throwOnFailure($result);
                objHttpGetText = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String html = (String) objHttpGetText;
        return Jsoup.parse(html, url);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object httpGetDoc$default(MovieLinkBDProvider movieLinkBDProvider, String str, Map map, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        return movieLinkBDProvider.httpGetDoc(str, map, continuation);
    }
}
