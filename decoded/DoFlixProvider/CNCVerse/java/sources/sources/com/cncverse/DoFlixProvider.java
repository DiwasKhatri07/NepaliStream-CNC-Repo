package com.cncverse;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.RuntimeJsonMappingException;
import com.fasterxml.jackson.module.kotlin.ExtensionsKt;
import com.lagradost.cloudstream3.Actor;
import com.lagradost.cloudstream3.ActorData;
import com.lagradost.cloudstream3.ActorRole;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainPageData;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.MovieLoadResponse;
import com.lagradost.cloudstream3.MovieSearchResponse;
import com.lagradost.cloudstream3.SearchQuality;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvSeriesSearchResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.ui.settings.Globals;
import com.lagradost.cloudstream3.utils.Qualities;
import java.io.Closeable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DoFlixProvider.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/DoFlixProvider/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u0000 J2\u00020\u0001:\u0016JKLMNOPQRSTUVWXYZ[\\]^_B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010$J\u0014\u0010*\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010-\u001a\u00020(2\b\u0010,\u001a\u0004\u0018\u00010\u0005H\u0002J \u00101\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u00020(2\u0006\u00105\u001a\u000206H\u0096@¢\u0006\u0002\u00107J\u001c\u00108\u001a\b\u0012\u0004\u0012\u0002090/2\u0006\u0010:\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010$J\u0018\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010#\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010$JF\u0010=\u001a\u00020\u000f2\u0006\u0010>\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u000f2\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020C0A2\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020C0AH\u0096@¢\u0006\u0002\u0010FJ\b\u0010G\u001a\u00020CH\u0002J\b\u0010H\u001a\u00020CH\u0002J\u0010\u0010I\u001a\u00020C2\u0006\u0010#\u001a\u00020\u0005H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u000e\u0010\r\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0007\"\u0004\b\u0014\u0010\tR\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00050\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010)\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00050\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u0002000/X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102¨\u0006`"}, d2 = {"Lcom/cncverse/DoFlixProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "apiKey", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "headers", "", "customClient", "Lokhttp3/OkHttpClient;", "getCustomClient", "()Lokhttp3/OkHttpClient;", "customClient$delegate", "Lkotlin/Lazy;", "getWithCustomHeaders", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mapper", "Lcom/fasterxml/jackson/databind/ObjectMapper;", "movieGenres", "", "seriesGenres", "getQualityFromString", "Lcom/lagradost/cloudstream3/SearchQuality;", "qualityString", "getQualityValue", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showSubscriptionPopupIfNeeded", "showTelegramPopup", "openInExternalBrowser", "Companion", "MovieResult", "SeriesResult", "HomePageApiResponse", "SeriesPageApiResponse", "VideoItem", "SearchApiResponse", "TMDBGenre", "ProductionCountry", "CastMember", "CrewMember", "Credits", "SimilarResults", "MultiSearchResponse", "MovieDetails", "SeasonInfo", "TvDetails", "TvEpisode", "SeasonDetails", "StreamLink", "MovieLinksResponse", "EpisodeLinksResponse", "DoFlixProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDoFlixProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DoFlixProvider.kt\ncom/cncverse/DoFlixProvider\n+ 2 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,1126:1\n116#2:1127\n54#2:1128\n117#2:1129\n61#2,8:1130\n71#2:1139\n116#2:1144\n54#2:1145\n117#2:1146\n61#2,8:1147\n71#2:1156\n116#2:1179\n54#2:1180\n117#2:1181\n61#2,8:1182\n71#2:1191\n116#2:1196\n54#2:1197\n117#2:1198\n61#2,8:1199\n71#2:1208\n116#2:1231\n54#2:1232\n117#2:1233\n61#2,8:1234\n71#2:1243\n116#2:1244\n54#2:1245\n117#2:1246\n61#2,8:1247\n71#2:1256\n116#2:1261\n54#2:1262\n117#2:1263\n61#2,8:1264\n71#2:1273\n116#2:1274\n54#2:1275\n117#2:1276\n61#2,8:1277\n71#2:1286\n116#2:1290\n54#2:1291\n117#2:1292\n61#2,8:1293\n71#2:1302\n116#2:1305\n54#2:1306\n117#2:1307\n61#2,8:1308\n71#2:1317\n116#2:1320\n54#2:1321\n117#2:1322\n61#2,8:1323\n71#2:1332\n1#3:1138\n1#3:1155\n1#3:1190\n1#3:1207\n1#3:1242\n1#3:1255\n1#3:1272\n1#3:1285\n1#3:1301\n1#3:1316\n1#3:1331\n1#3:1335\n1586#4:1140\n1661#4,3:1141\n1586#4:1157\n1661#4,3:1158\n1915#4:1161\n1915#4:1162\n1916#4:1170\n1916#4:1171\n1080#4:1172\n1915#4:1173\n1586#4:1174\n1661#4,3:1175\n1916#4:1178\n1586#4:1192\n1661#4,3:1193\n1586#4:1209\n1661#4,3:1210\n1915#4:1213\n1915#4:1214\n1916#4:1222\n1916#4:1223\n1080#4:1224\n1915#4:1225\n1586#4:1226\n1661#4,3:1227\n1916#4:1230\n1915#4,2:1257\n1915#4,2:1259\n777#4:1287\n873#4,2:1288\n1915#4,2:1303\n1915#4,2:1318\n1915#4,2:1333\n383#5,7:1163\n383#5,7:1215\n*S KotlinDebug\n*F\n+ 1 DoFlixProvider.kt\ncom/cncverse/DoFlixProvider\n*L\n492#1:1127\n492#1:1128\n492#1:1129\n492#1:1130,8\n492#1:1139\n513#1:1144\n513#1:1145\n513#1:1146\n513#1:1147,8\n513#1:1156\n566#1:1179\n566#1:1180\n566#1:1181\n566#1:1182,8\n566#1:1191\n587#1:1196\n587#1:1197\n587#1:1198\n587#1:1199,8\n587#1:1208\n651#1:1231\n651#1:1232\n651#1:1233\n651#1:1234,8\n651#1:1243\n656#1:1244\n656#1:1245\n656#1:1246\n656#1:1247,8\n656#1:1256\n702#1:1261\n702#1:1262\n702#1:1263\n702#1:1264,8\n702#1:1273\n741#1:1274\n741#1:1275\n741#1:1276\n741#1:1277,8\n741#1:1286\n749#1:1290\n749#1:1291\n749#1:1292\n749#1:1293,8\n749#1:1302\n836#1:1305\n836#1:1306\n836#1:1307\n836#1:1308,8\n836#1:1317\n861#1:1320\n861#1:1321\n861#1:1322\n861#1:1323,8\n861#1:1332\n492#1:1138\n513#1:1155\n566#1:1190\n587#1:1207\n651#1:1242\n656#1:1255\n702#1:1272\n741#1:1285\n749#1:1301\n836#1:1316\n861#1:1331\n494#1:1140\n494#1:1141,3\n515#1:1157\n515#1:1158,3\n534#1:1161\n535#1:1162\n535#1:1170\n534#1:1171\n542#1:1172\n544#1:1173\n546#1:1174\n546#1:1175,3\n544#1:1178\n568#1:1192\n568#1:1193,3\n589#1:1209\n589#1:1210,3\n608#1:1213\n609#1:1214\n609#1:1222\n608#1:1223\n616#1:1224\n618#1:1225\n620#1:1226\n620#1:1227,3\n618#1:1230\n659#1:1257,2\n672#1:1259,2\n745#1:1287\n745#1:1288,2\n751#1:1303,2\n838#1:1318,2\n863#1:1333,2\n536#1:1163,7\n610#1:1215,7\n*E\n"})
public final class DoFlixProvider extends MainAPI {
    private static final long BROWSER_DEBOUNCE_MS = 10000;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String OMG10 = "aHR0cHM6Ly9vbWcxMC5jb20vNC8xMTEwNDQ4OQ==";

    @Nullable
    private static Context context;
    private static volatile boolean csGuardWasEverActive;
    private static volatile long lastBrowserOpenMs;
    private static volatile boolean subscriptionPopupShown;
    private static volatile boolean telegramPopupShown;

    @NotNull
    private String mainUrl = "https://panel.watchkaroabhi.com";

    @NotNull
    private String name = "DoFlix";

    @NotNull
    private final String apiKey = "qNhKLJiZVyoKdi9NCQGz8CIGrpUijujE";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "ta";

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.TvSeries});

    @NotNull
    private final Map<String, String> headers = MapsKt.mapOf(new Pair[]{TuplesKt.to("Connection", "Keep-Alive"), TuplesKt.to("User-Agent", "dooflix"), TuplesKt.to("X-App-Version", "305"), TuplesKt.to("X-Package-Name", "com.king.moja")});

    /* JADX INFO: renamed from: customClient$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy customClient = LazyKt.lazy(new Function0() { // from class: com.cncverse.DoFlixProvider$$ExternalSyntheticLambda10
        public final Object invoke() {
            return DoFlixProvider.customClient_delegate$lambda$0(this.f$0);
        }
    });

    @NotNull
    private final ObjectMapper mapper = ExtensionsKt.jacksonObjectMapper();

    @NotNull
    private final Map<Integer, String> movieGenres = MapsKt.mapOf(new Pair[]{TuplesKt.to(28, "Action"), TuplesKt.to(12, "Adventure"), TuplesKt.to(16, "Animation"), TuplesKt.to(35, "Comedy"), TuplesKt.to(80, "Crime"), TuplesKt.to(99, "Documentary"), TuplesKt.to(18, "Drama"), TuplesKt.to(10751, "Family"), TuplesKt.to(14, "Fantasy"), TuplesKt.to(36, "History"), TuplesKt.to(27, "Horror"), TuplesKt.to(10402, "Music"), TuplesKt.to(9648, "Mystery"), TuplesKt.to(10749, "Romance"), TuplesKt.to(878, "Science Fiction"), TuplesKt.to(10770, "TV Movie"), TuplesKt.to(53, "Thriller"), TuplesKt.to(10752, "War"), TuplesKt.to(37, "Western")});

    @NotNull
    private final Map<Integer, String> seriesGenres = MapsKt.mapOf(new Pair[]{TuplesKt.to(10765, "Sci-Fi & Fantasy"), TuplesKt.to(9648, "Mystery"), TuplesKt.to(35, "Comedy"), TuplesKt.to(18, "Drama"), TuplesKt.to(10759, "Action & Adventure"), TuplesKt.to(80, "Crime"), TuplesKt.to(10767, "Talk"), TuplesKt.to(10768, "War & Politics"), TuplesKt.to(16, "Animation"), TuplesKt.to(10751, "Family"), TuplesKt.to(10764, "Reality"), TuplesKt.to(10762, "Kids"), TuplesKt.to(99, "Documentary"), TuplesKt.to(37, "Western"), TuplesKt.to(10763, "News"), TuplesKt.to(10766, "Soap")});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to(getMainUrl() + "/api/3/discover/movie?api_key=qNhKLJiZVyoKdi9NCQGz8CIGrpUijujE&language=en&sort_by=primary_release_date.desc&watch_region=IN&page=1", "RecentMovies"), TuplesKt.to(getMainUrl() + "/api/3/discover/tv?api_key=qNhKLJiZVyoKdi9NCQGz8CIGrpUijujE&language=en&page=1&sort_by=first_air_date.desc", "RecentSeries"), TuplesKt.to(getMainUrl() + "/api/3/discover/movie?api_key=qNhKLJiZVyoKdi9NCQGz8CIGrpUijujE&language=en&sort_by=popularity.desc&watch_region=IN&page=1", "TrendingMovies"), TuplesKt.to(getMainUrl() + "/api/3/discover/tv?api_key=qNhKLJiZVyoKdi9NCQGz8CIGrpUijujE&language=en&page=1&sort_by=popularity.desc", "TrendingSeries")});

    /* JADX INFO: renamed from: com.cncverse.DoFlixProvider$getMainPage$1 */
    /* JADX INFO: compiled from: DoFlixProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.DoFlixProvider", f = "DoFlixProvider.kt", i = {0, 0}, l = {486}, m = "getMainPage", n = {"request", "page"}, nl = {487}, s = {"L$0", "I$0"}, v = 2)
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
            return DoFlixProvider.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.DoFlixProvider$load$1 */
    /* JADX INFO: compiled from: DoFlixProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.DoFlixProvider", f = "DoFlixProvider.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4}, l = {701, 704, 740, 748, 768}, m = "load", n = {"url", "parts", "type", "id", "detailsUrl", "url", "parts", "type", "id", "detailsUrl", "responseText", "details", "url", "parts", "type", "id", "detailsUrl", "url", "parts", "type", "id", "detailsUrl", "responseText", "details", "allEpisodes", "season", "seasonUrl", "url", "parts", "type", "id", "detailsUrl", "responseText", "details", "allEpisodes"}, nl = {702, 739, 741, 749, 698}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$9", "L$10", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
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

        C00011(Continuation<? super C00011> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DoFlixProvider.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.DoFlixProvider$loadLinks$1 */
    /* JADX INFO: compiled from: DoFlixProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.DoFlixProvider", f = "DoFlixProvider.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {835, 840, 860, 865}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "parts", "movieId", "linksUrl", "isCasting", "data", "subtitleCallback", "callback", "parts", "movieId", "linksUrl", "responseText", "linksResponse", "$this$forEach$iv", "element$iv", "link", "isCasting", "$i$f$forEach", "$i$a$-forEach-DoFlixProvider$loadLinks$3", "data", "subtitleCallback", "callback", "parts", "tvId", "seasonNum", "episodeNum", "linksUrl", "isCasting", "data", "subtitleCallback", "callback", "parts", "tvId", "seasonNum", "episodeNum", "linksUrl", "responseText", "linksResponse", "$this$forEach$iv", "element$iv", "link", "isCasting", "$i$f$forEach", "$i$a$-forEach-DoFlixProvider$loadLinks$4"}, nl = {836, 839, 861, 864}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$10", "L$11", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$12", "L$13", "Z$0", "I$0", "I$1"}, v = 2)
    static final class C00041 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
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
            return DoFlixProvider.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.DoFlixProvider$search$1 */
    /* JADX INFO: compiled from: DoFlixProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.DoFlixProvider", f = "DoFlixProvider.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {650, 655}, m = "search", n = {"query", "searchResults", "movieSearchUrl", "query", "searchResults", "movieSearchUrl", "movieResponseText", "movieSearchData", "tvSearchUrl"}, nl = {651, 656}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 2)
    static final class C00051 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C00051(Continuation<? super C00051> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DoFlixProvider.this.search(null, (Continuation) this);
        }
    }

    /* JADX INFO: compiled from: DoFlixProvider.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/cncverse/DoFlixProvider$Companion;", "", "<init>", "()V", "isCsGuardActive", "", "csGuardWasEverActive", "isCsGuardBlocked", "showCsGuardToast", "", "ctx", "Landroid/content/Context;", "context", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "OMG10", "", "lastBrowserOpenMs", "", "telegramPopupShown", "subscriptionPopupShown", "BROWSER_DEBOUNCE_MS", "DoFlixProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nDoFlixProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DoFlixProvider.kt\ncom/cncverse/DoFlixProvider$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1126:1\n1#2:1127\n*E\n"})
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
                DoFlixProvider.csGuardWasEverActive = true;
            }
            return DoFlixProvider.csGuardWasEverActive;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void showCsGuardToast(final Context ctx) {
            if (ctx == null) {
                return;
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.DoFlixProvider$Companion$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    DoFlixProvider.Companion.showCsGuardToast$lambda$0(ctx);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void showCsGuardToast$lambda$0(Context $c) {
            Toast.makeText($c, "🚫 CSGuard detected — Restart CloudStream after removing CSGuard to use CNCRepo", 1).show();
        }

        @Nullable
        public final Context getContext() {
            return DoFlixProvider.context;
        }

        public final void setContext(@Nullable Context context) {
            DoFlixProvider.context = context;
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

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    private final OkHttpClient getCustomClient() {
        return (OkHttpClient) this.customClient.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OkHttpClient customClient_delegate$lambda$0(DoFlixProvider this$0) {
        return new OkHttpClient.Builder().addInterceptor(new HeaderReplacementInterceptor(this$0.headers)).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getWithCustomHeaders(String url, Continuation<? super String> continuation) {
        Request request = new Request.Builder().url(url).build();
        Response response = (Closeable) getCustomClient().newCall(request).execute();
        try {
            Response response2 = response;
            String strString = response2.body().string();
            CloseableKt.closeFinally(response, (Throwable) null);
            return strString;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(response, th);
                throw th2;
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final SearchQuality getQualityFromString(String qualityString) {
        String upperCase;
        if (qualityString != null) {
            upperCase = qualityString.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        } else {
            upperCase = null;
        }
        if (upperCase == null) {
            return null;
        }
        switch (upperCase.hashCode()) {
            case -577968313:
                if (!upperCase.equals("TELECINE")) {
                    return null;
                }
                return SearchQuality.Telecine;
            case -577476283:
                if (!upperCase.equals("TELESYNC")) {
                    return null;
                }
                return SearchQuality.Telesync;
            case -402211300:
                if (!upperCase.equals("WORKPRINT")) {
                    return null;
                }
                return SearchQuality.WorkPrint;
            case 1687:
                if (!upperCase.equals("4K")) {
                    return null;
                }
                return SearchQuality.HD;
            case 2300:
                if (!upperCase.equals("HD")) {
                    return null;
                }
                return SearchQuality.HD;
            case 2671:
                if (!upperCase.equals("TC")) {
                    return null;
                }
                return SearchQuality.Telecine;
            case 2687:
                if (!upperCase.equals("TS")) {
                    return null;
                }
                return SearchQuality.Telesync;
            case 2777:
                if (!upperCase.equals("WP")) {
                    return null;
                }
                return SearchQuality.WorkPrint;
            case 66479:
                if (!upperCase.equals("CAM")) {
                    return null;
                }
                return SearchQuality.Cam;
            case 69570:
                if (!upperCase.equals("FHD")) {
                    return null;
                }
                return SearchQuality.HD;
            case 1688123:
                if (!upperCase.equals("720P")) {
                    return null;
                }
                return SearchQuality.HD;
            case 46737881:
                if (!upperCase.equals("1080P")) {
                    return null;
                }
                return SearchQuality.HD;
            case 47689271:
                if (!upperCase.equals("2160P")) {
                    return null;
                }
                return SearchQuality.HD;
            case 68585779:
                if (upperCase.equals("HDCAM")) {
                    return SearchQuality.HdCam;
                }
                return null;
            case 1980557034:
                if (!upperCase.equals("CAMRIP")) {
                    return null;
                }
                return SearchQuality.Cam;
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0020, code lost:
    
        if (r0.equals("2160P") == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002a, code lost:
    
        if (r0.equals("1080P") == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0034, code lost:
    
        if (r0.equals("720P") == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003d, code lost:
    
        if (r0.equals("480P") == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0056, code lost:
    
        if (r0.equals("FHD") == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0066, code lost:
    
        if (r0.equals("SD") == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0076, code lost:
    
        if (r0.equals("HD") == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0086, code lost:
    
        if (r0.equals("4K") == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:?, code lost:
    
        return com.lagradost.cloudstream3.utils.Qualities.P1080.getValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:?, code lost:
    
        return com.lagradost.cloudstream3.utils.Qualities.P480.getValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:?, code lost:
    
        return com.lagradost.cloudstream3.utils.Qualities.P720.getValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:?, code lost:
    
        return com.lagradost.cloudstream3.utils.Qualities.P2160.getValue();
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int getQualityValue(String qualityString) {
        String upperCase;
        if (qualityString != null) {
            upperCase = qualityString.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        } else {
            upperCase = null;
        }
        if (upperCase != null) {
            switch (upperCase.hashCode()) {
                case 1687:
                    break;
                case 2300:
                    break;
                case 2641:
                    break;
                case 69570:
                    break;
                case 1572803:
                    if (upperCase.equals("360P")) {
                        return Qualities.P360.getValue();
                    }
                    break;
                case 1604516:
                    break;
                case 1688123:
                    break;
                case 46737881:
                    break;
                case 47689271:
                    break;
            }
        }
        return Qualities.Unknown.getValue();
    }

    /* JADX INFO: compiled from: DoFlixProvider.kt */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\bI\b\u0087\b\u0018\u00002\u00020\u0001B·\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0003\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0015\u0012\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0003\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0015\u0012\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0003\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0015\u0012\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u001e\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u001f\u0010 J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010K\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010-J\u0010\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00100J\u0010\u0010M\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010-J\u000b\u0010N\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010Q\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0015HÆ\u0003J\u0010\u0010R\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0002\u00109J\u000b\u0010S\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010T\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0015HÆ\u0003J\u0010\u0010U\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00100J\u0011\u0010V\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0015HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010Y\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0002\u00109J¾\u0002\u0010Z\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0010\b\u0003\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00152\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0010\b\u0003\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00152\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00152\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u001e\u001a\u0004\u0018\u00010\u0017HÆ\u0001¢\u0006\u0002\u0010[J\u0014\u0010\\\u001a\u00020\u00172\b\u0010]\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010^\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010_\u001a\u00020\u0005HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010$R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010$R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010$R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010$R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010$R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010$R\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010.\u001a\u0004\b,\u0010-R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00101\u001a\u0004\b/\u00100R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010.\u001a\u0004\b2\u0010-R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010$R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010$R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010$R\u001e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010:\u001a\u0004\b8\u00109R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010$R\u001e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u00107R\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00101\u001a\u0004\b=\u00100R\u001e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u00107R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010$R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010$R\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010:\u001a\u0004\bA\u00109¨\u0006`"}, d2 = {"Lcom/cncverse/DoFlixProvider$MovieResult;", "", "id", "", "title", "", "name", "customPosterTag", "originalTitle", "originalName", "overview", "releaseDate", "firstAirDate", "popularity", "", "voteCount", "voteAverage", "posterPath", "backdropPath", "originalLanguage", "genreIds", "", "adult", "", "mediaType", "originCountry", "gender", "knownFor", "knownForDepartment", "profilePath", "video", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "getName", "getCustomPosterTag", "getOriginalTitle", "getOriginalName", "getOverview", "getReleaseDate", "getFirstAirDate", "getPopularity", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getVoteCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getVoteAverage", "getPosterPath", "getBackdropPath", "getOriginalLanguage", "getGenreIds", "()Ljava/util/List;", "getAdult", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMediaType", "getOriginCountry", "getGender", "getKnownFor", "getKnownForDepartment", "getProfilePath", "getVideo", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/cncverse/DoFlixProvider$MovieResult;", "equals", "other", "hashCode", "toString", "DoFlixProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class MovieResult {

        @JsonProperty("adult")
        @Nullable
        private final Boolean adult;

        @JsonProperty("backdrop_path")
        @Nullable
        private final String backdropPath;

        @JsonProperty("custom_poster_tag")
        @Nullable
        private final String customPosterTag;

        @JsonProperty("first_air_date")
        @Nullable
        private final String firstAirDate;

        @JsonProperty("gender")
        @Nullable
        private final Integer gender;

        @JsonProperty("genre_ids")
        @Nullable
        private final List<Integer> genreIds;

        @JsonProperty("id")
        private final int id;

        @JsonProperty("known_for")
        @Nullable
        private final List<Object> knownFor;

        @JsonProperty("known_for_department")
        @Nullable
        private final String knownForDepartment;

        @JsonProperty("media_type")
        @Nullable
        private final String mediaType;

        @JsonProperty("name")
        @Nullable
        private final String name;

        @JsonProperty("origin_country")
        @Nullable
        private final List<String> originCountry;

        @JsonProperty("original_language")
        @Nullable
        private final String originalLanguage;

        @JsonProperty("original_name")
        @Nullable
        private final String originalName;

        @JsonProperty("original_title")
        @Nullable
        private final String originalTitle;

        @JsonProperty("overview")
        @Nullable
        private final String overview;

        @JsonProperty("popularity")
        @Nullable
        private final Double popularity;

        @JsonProperty("poster_path")
        @Nullable
        private final String posterPath;

        @JsonProperty("profile_path")
        @Nullable
        private final String profilePath;

        @JsonProperty("release_date")
        @Nullable
        private final String releaseDate;

        @JsonProperty("title")
        @Nullable
        private final String title;

        @JsonProperty("video")
        @Nullable
        private final Boolean video;

        @JsonProperty("vote_average")
        @Nullable
        private final Double voteAverage;

        @JsonProperty("vote_count")
        @Nullable
        private final Integer voteCount;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MovieResult copy$default(MovieResult movieResult, int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Double d, Integer num, Double d2, String str9, String str10, String str11, List list, Boolean bool, String str12, List list2, Integer num2, List list3, String str13, String str14, Boolean bool2, int i2, Object obj) {
            Boolean bool3;
            String str15;
            int i3 = (i2 & 1) != 0 ? movieResult.id : i;
            String str16 = (i2 & 2) != 0 ? movieResult.title : str;
            String str17 = (i2 & 4) != 0 ? movieResult.name : str2;
            String str18 = (i2 & 8) != 0 ? movieResult.customPosterTag : str3;
            String str19 = (i2 & 16) != 0 ? movieResult.originalTitle : str4;
            String str20 = (i2 & 32) != 0 ? movieResult.originalName : str5;
            String str21 = (i2 & 64) != 0 ? movieResult.overview : str6;
            String str22 = (i2 & 128) != 0 ? movieResult.releaseDate : str7;
            String str23 = (i2 & 256) != 0 ? movieResult.firstAirDate : str8;
            Double d3 = (i2 & 512) != 0 ? movieResult.popularity : d;
            Integer num3 = (i2 & 1024) != 0 ? movieResult.voteCount : num;
            Double d4 = (i2 & 2048) != 0 ? movieResult.voteAverage : d2;
            String str24 = (i2 & 4096) != 0 ? movieResult.posterPath : str9;
            String str25 = (i2 & 8192) != 0 ? movieResult.backdropPath : str10;
            int i4 = i3;
            String str26 = (i2 & 16384) != 0 ? movieResult.originalLanguage : str11;
            List list4 = (i2 & 32768) != 0 ? movieResult.genreIds : list;
            Boolean bool4 = (i2 & 65536) != 0 ? movieResult.adult : bool;
            String str27 = (i2 & 131072) != 0 ? movieResult.mediaType : str12;
            List list5 = (i2 & 262144) != 0 ? movieResult.originCountry : list2;
            Integer num4 = (i2 & 524288) != 0 ? movieResult.gender : num2;
            List list6 = (i2 & 1048576) != 0 ? movieResult.knownFor : list3;
            String str28 = (i2 & 2097152) != 0 ? movieResult.knownForDepartment : str13;
            String str29 = (i2 & 4194304) != 0 ? movieResult.profilePath : str14;
            if ((i2 & 8388608) != 0) {
                str15 = str29;
                bool3 = movieResult.video;
            } else {
                bool3 = bool2;
                str15 = str29;
            }
            return movieResult.copy(i4, str16, str17, str18, str19, str20, str21, str22, str23, d3, num3, d4, str24, str25, str26, list4, bool4, str27, list5, num4, list6, str28, str15, bool3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component10, reason: from getter */
        public final Double getPopularity() {
            return this.popularity;
        }

        @Nullable
        /* JADX INFO: renamed from: component11, reason: from getter */
        public final Integer getVoteCount() {
            return this.voteCount;
        }

        @Nullable
        /* JADX INFO: renamed from: component12, reason: from getter */
        public final Double getVoteAverage() {
            return this.voteAverage;
        }

        @Nullable
        /* JADX INFO: renamed from: component13, reason: from getter */
        public final String getPosterPath() {
            return this.posterPath;
        }

        @Nullable
        /* JADX INFO: renamed from: component14, reason: from getter */
        public final String getBackdropPath() {
            return this.backdropPath;
        }

        @Nullable
        /* JADX INFO: renamed from: component15, reason: from getter */
        public final String getOriginalLanguage() {
            return this.originalLanguage;
        }

        @Nullable
        public final List<Integer> component16() {
            return this.genreIds;
        }

        @Nullable
        /* JADX INFO: renamed from: component17, reason: from getter */
        public final Boolean getAdult() {
            return this.adult;
        }

        @Nullable
        /* JADX INFO: renamed from: component18, reason: from getter */
        public final String getMediaType() {
            return this.mediaType;
        }

        @Nullable
        public final List<String> component19() {
            return this.originCountry;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component20, reason: from getter */
        public final Integer getGender() {
            return this.gender;
        }

        @Nullable
        public final List<Object> component21() {
            return this.knownFor;
        }

        @Nullable
        /* JADX INFO: renamed from: component22, reason: from getter */
        public final String getKnownForDepartment() {
            return this.knownForDepartment;
        }

        @Nullable
        /* JADX INFO: renamed from: component23, reason: from getter */
        public final String getProfilePath() {
            return this.profilePath;
        }

        @Nullable
        /* JADX INFO: renamed from: component24, reason: from getter */
        public final Boolean getVideo() {
            return this.video;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getCustomPosterTag() {
            return this.customPosterTag;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getOriginalTitle() {
            return this.originalTitle;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getOriginalName() {
            return this.originalName;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getOverview() {
            return this.overview;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getReleaseDate() {
            return this.releaseDate;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getFirstAirDate() {
            return this.firstAirDate;
        }

        @NotNull
        public final MovieResult copy(@JsonProperty("id") int id, @JsonProperty("title") @Nullable String title, @JsonProperty("name") @Nullable String name, @JsonProperty("custom_poster_tag") @Nullable String customPosterTag, @JsonProperty("original_title") @Nullable String originalTitle, @JsonProperty("original_name") @Nullable String originalName, @JsonProperty("overview") @Nullable String overview, @JsonProperty("release_date") @Nullable String releaseDate, @JsonProperty("first_air_date") @Nullable String firstAirDate, @JsonProperty("popularity") @Nullable Double popularity, @JsonProperty("vote_count") @Nullable Integer voteCount, @JsonProperty("vote_average") @Nullable Double voteAverage, @JsonProperty("poster_path") @Nullable String posterPath, @JsonProperty("backdrop_path") @Nullable String backdropPath, @JsonProperty("original_language") @Nullable String originalLanguage, @JsonProperty("genre_ids") @Nullable List<Integer> genreIds, @JsonProperty("adult") @Nullable Boolean adult, @JsonProperty("media_type") @Nullable String mediaType, @JsonProperty("origin_country") @Nullable List<String> originCountry, @JsonProperty("gender") @Nullable Integer gender, @JsonProperty("known_for") @Nullable List<? extends Object> knownFor, @JsonProperty("known_for_department") @Nullable String knownForDepartment, @JsonProperty("profile_path") @Nullable String profilePath, @JsonProperty("video") @Nullable Boolean video) {
            return new MovieResult(id, title, name, customPosterTag, originalTitle, originalName, overview, releaseDate, firstAirDate, popularity, voteCount, voteAverage, posterPath, backdropPath, originalLanguage, genreIds, adult, mediaType, originCountry, gender, knownFor, knownForDepartment, profilePath, video);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MovieResult)) {
                return false;
            }
            MovieResult movieResult = (MovieResult) other;
            return this.id == movieResult.id && Intrinsics.areEqual(this.title, movieResult.title) && Intrinsics.areEqual(this.name, movieResult.name) && Intrinsics.areEqual(this.customPosterTag, movieResult.customPosterTag) && Intrinsics.areEqual(this.originalTitle, movieResult.originalTitle) && Intrinsics.areEqual(this.originalName, movieResult.originalName) && Intrinsics.areEqual(this.overview, movieResult.overview) && Intrinsics.areEqual(this.releaseDate, movieResult.releaseDate) && Intrinsics.areEqual(this.firstAirDate, movieResult.firstAirDate) && Intrinsics.areEqual(this.popularity, movieResult.popularity) && Intrinsics.areEqual(this.voteCount, movieResult.voteCount) && Intrinsics.areEqual(this.voteAverage, movieResult.voteAverage) && Intrinsics.areEqual(this.posterPath, movieResult.posterPath) && Intrinsics.areEqual(this.backdropPath, movieResult.backdropPath) && Intrinsics.areEqual(this.originalLanguage, movieResult.originalLanguage) && Intrinsics.areEqual(this.genreIds, movieResult.genreIds) && Intrinsics.areEqual(this.adult, movieResult.adult) && Intrinsics.areEqual(this.mediaType, movieResult.mediaType) && Intrinsics.areEqual(this.originCountry, movieResult.originCountry) && Intrinsics.areEqual(this.gender, movieResult.gender) && Intrinsics.areEqual(this.knownFor, movieResult.knownFor) && Intrinsics.areEqual(this.knownForDepartment, movieResult.knownForDepartment) && Intrinsics.areEqual(this.profilePath, movieResult.profilePath) && Intrinsics.areEqual(this.video, movieResult.video);
        }

        public int hashCode() {
            return (((((((((((((((((((((((((((((((((((((((((((((this.id * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.customPosterTag == null ? 0 : this.customPosterTag.hashCode())) * 31) + (this.originalTitle == null ? 0 : this.originalTitle.hashCode())) * 31) + (this.originalName == null ? 0 : this.originalName.hashCode())) * 31) + (this.overview == null ? 0 : this.overview.hashCode())) * 31) + (this.releaseDate == null ? 0 : this.releaseDate.hashCode())) * 31) + (this.firstAirDate == null ? 0 : this.firstAirDate.hashCode())) * 31) + (this.popularity == null ? 0 : this.popularity.hashCode())) * 31) + (this.voteCount == null ? 0 : this.voteCount.hashCode())) * 31) + (this.voteAverage == null ? 0 : this.voteAverage.hashCode())) * 31) + (this.posterPath == null ? 0 : this.posterPath.hashCode())) * 31) + (this.backdropPath == null ? 0 : this.backdropPath.hashCode())) * 31) + (this.originalLanguage == null ? 0 : this.originalLanguage.hashCode())) * 31) + (this.genreIds == null ? 0 : this.genreIds.hashCode())) * 31) + (this.adult == null ? 0 : this.adult.hashCode())) * 31) + (this.mediaType == null ? 0 : this.mediaType.hashCode())) * 31) + (this.originCountry == null ? 0 : this.originCountry.hashCode())) * 31) + (this.gender == null ? 0 : this.gender.hashCode())) * 31) + (this.knownFor == null ? 0 : this.knownFor.hashCode())) * 31) + (this.knownForDepartment == null ? 0 : this.knownForDepartment.hashCode())) * 31) + (this.profilePath == null ? 0 : this.profilePath.hashCode())) * 31) + (this.video != null ? this.video.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("MovieResult(id=").append(this.id).append(", title=").append(this.title).append(", name=").append(this.name).append(", customPosterTag=").append(this.customPosterTag).append(", originalTitle=").append(this.originalTitle).append(", originalName=").append(this.originalName).append(", overview=").append(this.overview).append(", releaseDate=").append(this.releaseDate).append(", firstAirDate=").append(this.firstAirDate).append(", popularity=").append(this.popularity).append(", voteCount=").append(this.voteCount).append(", voteAverage=");
            sb.append(this.voteAverage).append(", posterPath=").append(this.posterPath).append(", backdropPath=").append(this.backdropPath).append(", originalLanguage=").append(this.originalLanguage).append(", genreIds=").append(this.genreIds).append(", adult=").append(this.adult).append(", mediaType=").append(this.mediaType).append(", originCountry=").append(this.originCountry).append(", gender=").append(this.gender).append(", knownFor=").append(this.knownFor).append(", knownForDepartment=").append(this.knownForDepartment).append(", profilePath=").append(this.profilePath);
            sb.append(", video=").append(this.video).append(')');
            return sb.toString();
        }

        public MovieResult(@JsonProperty("id") int id, @JsonProperty("title") @Nullable String title, @JsonProperty("name") @Nullable String name, @JsonProperty("custom_poster_tag") @Nullable String customPosterTag, @JsonProperty("original_title") @Nullable String originalTitle, @JsonProperty("original_name") @Nullable String originalName, @JsonProperty("overview") @Nullable String overview, @JsonProperty("release_date") @Nullable String releaseDate, @JsonProperty("first_air_date") @Nullable String firstAirDate, @JsonProperty("popularity") @Nullable Double popularity, @JsonProperty("vote_count") @Nullable Integer voteCount, @JsonProperty("vote_average") @Nullable Double voteAverage, @JsonProperty("poster_path") @Nullable String posterPath, @JsonProperty("backdrop_path") @Nullable String backdropPath, @JsonProperty("original_language") @Nullable String originalLanguage, @JsonProperty("genre_ids") @Nullable List<Integer> list, @JsonProperty("adult") @Nullable Boolean adult, @JsonProperty("media_type") @Nullable String mediaType, @JsonProperty("origin_country") @Nullable List<String> list2, @JsonProperty("gender") @Nullable Integer gender, @JsonProperty("known_for") @Nullable List<? extends Object> list3, @JsonProperty("known_for_department") @Nullable String knownForDepartment, @JsonProperty("profile_path") @Nullable String profilePath, @JsonProperty("video") @Nullable Boolean video) {
            this.id = id;
            this.title = title;
            this.name = name;
            this.customPosterTag = customPosterTag;
            this.originalTitle = originalTitle;
            this.originalName = originalName;
            this.overview = overview;
            this.releaseDate = releaseDate;
            this.firstAirDate = firstAirDate;
            this.popularity = popularity;
            this.voteCount = voteCount;
            this.voteAverage = voteAverage;
            this.posterPath = posterPath;
            this.backdropPath = backdropPath;
            this.originalLanguage = originalLanguage;
            this.genreIds = list;
            this.adult = adult;
            this.mediaType = mediaType;
            this.originCountry = list2;
            this.gender = gender;
            this.knownFor = list3;
            this.knownForDepartment = knownForDepartment;
            this.profilePath = profilePath;
            this.video = video;
        }

        public /* synthetic */ MovieResult(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Double d, Integer num, Double d2, String str9, String str10, String str11, List list, Boolean bool, String str12, List list2, Integer num2, List list3, String str13, String str14, Boolean bool2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2, str3, (i2 & 16) != 0 ? null : str4, (i2 & 32) != 0 ? null : str5, (i2 & 64) != 0 ? null : str6, (i2 & 128) != 0 ? null : str7, (i2 & 256) != 0 ? null : str8, (i2 & 512) != 0 ? null : d, (i2 & 1024) != 0 ? null : num, (i2 & 2048) != 0 ? null : d2, (i2 & 4096) != 0 ? null : str9, (i2 & 8192) != 0 ? null : str10, (i2 & 16384) != 0 ? null : str11, (32768 & i2) != 0 ? null : list, (65536 & i2) != 0 ? null : bool, (131072 & i2) != 0 ? null : str12, (262144 & i2) != 0 ? null : list2, (524288 & i2) != 0 ? null : num2, (1048576 & i2) != 0 ? null : list3, (2097152 & i2) != 0 ? null : str13, (4194304 & i2) != 0 ? null : str14, (i2 & 8388608) != 0 ? null : bool2);
        }

        public final int getId() {
            return this.id;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final String getName() {
            return this.name;
        }

        @Nullable
        public final String getCustomPosterTag() {
            return this.customPosterTag;
        }

        @Nullable
        public final String getOriginalTitle() {
            return this.originalTitle;
        }

        @Nullable
        public final String getOriginalName() {
            return this.originalName;
        }

        @Nullable
        public final String getOverview() {
            return this.overview;
        }

        @Nullable
        public final String getReleaseDate() {
            return this.releaseDate;
        }

        @Nullable
        public final String getFirstAirDate() {
            return this.firstAirDate;
        }

        @Nullable
        public final Double getPopularity() {
            return this.popularity;
        }

        @Nullable
        public final Integer getVoteCount() {
            return this.voteCount;
        }

        @Nullable
        public final Double getVoteAverage() {
            return this.voteAverage;
        }

        @Nullable
        public final String getPosterPath() {
            return this.posterPath;
        }

        @Nullable
        public final String getBackdropPath() {
            return this.backdropPath;
        }

        @Nullable
        public final String getOriginalLanguage() {
            return this.originalLanguage;
        }

        @Nullable
        public final List<Integer> getGenreIds() {
            return this.genreIds;
        }

        @Nullable
        public final Boolean getAdult() {
            return this.adult;
        }

        @Nullable
        public final String getMediaType() {
            return this.mediaType;
        }

        @Nullable
        public final List<String> getOriginCountry() {
            return this.originCountry;
        }

        @Nullable
        public final Integer getGender() {
            return this.gender;
        }

        @Nullable
        public final List<Object> getKnownFor() {
            return this.knownFor;
        }

        @Nullable
        public final String getKnownForDepartment() {
            return this.knownForDepartment;
        }

        @Nullable
        public final String getProfilePath() {
            return this.profilePath;
        }

        @Nullable
        public final Boolean getVideo() {
            return this.video;
        }
    }

    /* JADX INFO: compiled from: DoFlixProvider.kt */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b+\b\u0087\b\u0018\u00002\u00020\u0001B«\u0001\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0001\u0010\b\u001a\u00020\u0005\u0012\b\b\u0001\u0010\t\u001a\u00020\u0005\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b\u0012\b\b\u0001\u0010\f\u001a\u00020\u0003\u0012\b\b\u0001\u0010\r\u001a\u00020\u000b\u0012\b\b\u0001\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0010\u001a\u00020\u0005\u0012\u000e\b\u0001\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0012\u0012\u000e\b\u0001\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012\u0012\b\b\u0001\u0010\u0014\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\t\u00102\u001a\u00020\u000bHÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u000bHÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\t\u00106\u001a\u00020\u0005HÆ\u0003J\t\u00107\u001a\u00020\u0005HÆ\u0003J\u000f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00030\u0012HÆ\u0003J\u000f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012HÆ\u0003J\t\u0010:\u001a\u00020\u0015HÆ\u0003J\u00ad\u0001\u0010;\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0003\u0010\u0007\u001a\u00020\u00052\b\b\u0003\u0010\b\u001a\u00020\u00052\b\b\u0003\u0010\t\u001a\u00020\u00052\b\b\u0003\u0010\n\u001a\u00020\u000b2\b\b\u0003\u0010\f\u001a\u00020\u00032\b\b\u0003\u0010\r\u001a\u00020\u000b2\b\b\u0003\u0010\u000e\u001a\u00020\u00052\b\b\u0003\u0010\u000f\u001a\u00020\u00052\b\b\u0003\u0010\u0010\u001a\u00020\u00052\u000e\b\u0003\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u00122\u000e\b\u0003\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u00122\b\b\u0003\u0010\u0014\u001a\u00020\u0015HÆ\u0001J\u0014\u0010<\u001a\u00020\u00152\b\u0010=\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010>\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010?\u001a\u00020\u0005HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u0016\u0010\r\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!R\u0016\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001bR\u0016\u0010\u000f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001bR\u0016\u0010\u0010\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001bR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010(R\u0016\u0010\u0014\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+¨\u0006@"}, d2 = {"Lcom/cncverse/DoFlixProvider$SeriesResult;", "", "id", "", "name", "", "customPosterTag", "originalName", "overview", "firstAirDate", "popularity", "", "voteCount", "voteAverage", "posterPath", "backdropPath", "originalLanguage", "genreIds", "", "originCountry", "adult", "", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DIDLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Z)V", "getId", "()I", "getName", "()Ljava/lang/String;", "getCustomPosterTag", "getOriginalName", "getOverview", "getFirstAirDate", "getPopularity", "()D", "getVoteCount", "getVoteAverage", "getPosterPath", "getBackdropPath", "getOriginalLanguage", "getGenreIds", "()Ljava/util/List;", "getOriginCountry", "getAdult", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "equals", "other", "hashCode", "toString", "DoFlixProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class SeriesResult {

        @JsonProperty("adult")
        private final boolean adult;

        @JsonProperty("backdrop_path")
        @NotNull
        private final String backdropPath;

        @JsonProperty("custom_poster_tag")
        @Nullable
        private final String customPosterTag;

        @JsonProperty("first_air_date")
        @NotNull
        private final String firstAirDate;

        @JsonProperty("genre_ids")
        @NotNull
        private final List<Integer> genreIds;

        @JsonProperty("id")
        private final int id;

        @JsonProperty("name")
        @NotNull
        private final String name;

        @JsonProperty("origin_country")
        @NotNull
        private final List<String> originCountry;

        @JsonProperty("original_language")
        @NotNull
        private final String originalLanguage;

        @JsonProperty("original_name")
        @NotNull
        private final String originalName;

        @JsonProperty("overview")
        @NotNull
        private final String overview;

        @JsonProperty("popularity")
        private final double popularity;

        @JsonProperty("poster_path")
        @NotNull
        private final String posterPath;

        @JsonProperty("vote_average")
        private final double voteAverage;

        @JsonProperty("vote_count")
        private final int voteCount;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SeriesResult copy$default(SeriesResult seriesResult, int i, String str, String str2, String str3, String str4, String str5, double d, int i2, double d2, String str6, String str7, String str8, List list, List list2, boolean z, int i3, Object obj) {
            int i4 = (i3 & 1) != 0 ? seriesResult.id : i;
            return seriesResult.copy(i4, (i3 & 2) != 0 ? seriesResult.name : str, (i3 & 4) != 0 ? seriesResult.customPosterTag : str2, (i3 & 8) != 0 ? seriesResult.originalName : str3, (i3 & 16) != 0 ? seriesResult.overview : str4, (i3 & 32) != 0 ? seriesResult.firstAirDate : str5, (i3 & 64) != 0 ? seriesResult.popularity : d, (i3 & 128) != 0 ? seriesResult.voteCount : i2, (i3 & 256) != 0 ? seriesResult.voteAverage : d2, (i3 & 512) != 0 ? seriesResult.posterPath : str6, (i3 & 1024) != 0 ? seriesResult.backdropPath : str7, (i3 & 2048) != 0 ? seriesResult.originalLanguage : str8, (i3 & 4096) != 0 ? seriesResult.genreIds : list, (i3 & 8192) != 0 ? seriesResult.originCountry : list2, (i3 & 16384) != 0 ? seriesResult.adult : z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getId() {
            return this.id;
        }

        @NotNull
        /* JADX INFO: renamed from: component10, reason: from getter */
        public final String getPosterPath() {
            return this.posterPath;
        }

        @NotNull
        /* JADX INFO: renamed from: component11, reason: from getter */
        public final String getBackdropPath() {
            return this.backdropPath;
        }

        @NotNull
        /* JADX INFO: renamed from: component12, reason: from getter */
        public final String getOriginalLanguage() {
            return this.originalLanguage;
        }

        @NotNull
        public final List<Integer> component13() {
            return this.genreIds;
        }

        @NotNull
        public final List<String> component14() {
            return this.originCountry;
        }

        /* JADX INFO: renamed from: component15, reason: from getter */
        public final boolean getAdult() {
            return this.adult;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getCustomPosterTag() {
            return this.customPosterTag;
        }

        @NotNull
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getOriginalName() {
            return this.originalName;
        }

        @NotNull
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getOverview() {
            return this.overview;
        }

        @NotNull
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getFirstAirDate() {
            return this.firstAirDate;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final double getPopularity() {
            return this.popularity;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final int getVoteCount() {
            return this.voteCount;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final double getVoteAverage() {
            return this.voteAverage;
        }

        @NotNull
        public final SeriesResult copy(@JsonProperty("id") int id, @JsonProperty("name") @NotNull String name, @JsonProperty("custom_poster_tag") @Nullable String customPosterTag, @JsonProperty("original_name") @NotNull String originalName, @JsonProperty("overview") @NotNull String overview, @JsonProperty("first_air_date") @NotNull String firstAirDate, @JsonProperty("popularity") double popularity, @JsonProperty("vote_count") int voteCount, @JsonProperty("vote_average") double voteAverage, @JsonProperty("poster_path") @NotNull String posterPath, @JsonProperty("backdrop_path") @NotNull String backdropPath, @JsonProperty("original_language") @NotNull String originalLanguage, @JsonProperty("genre_ids") @NotNull List<Integer> genreIds, @JsonProperty("origin_country") @NotNull List<String> originCountry, @JsonProperty("adult") boolean adult) {
            return new SeriesResult(id, name, customPosterTag, originalName, overview, firstAirDate, popularity, voteCount, voteAverage, posterPath, backdropPath, originalLanguage, genreIds, originCountry, adult);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SeriesResult)) {
                return false;
            }
            SeriesResult seriesResult = (SeriesResult) other;
            return this.id == seriesResult.id && Intrinsics.areEqual(this.name, seriesResult.name) && Intrinsics.areEqual(this.customPosterTag, seriesResult.customPosterTag) && Intrinsics.areEqual(this.originalName, seriesResult.originalName) && Intrinsics.areEqual(this.overview, seriesResult.overview) && Intrinsics.areEqual(this.firstAirDate, seriesResult.firstAirDate) && Double.compare(this.popularity, seriesResult.popularity) == 0 && this.voteCount == seriesResult.voteCount && Double.compare(this.voteAverage, seriesResult.voteAverage) == 0 && Intrinsics.areEqual(this.posterPath, seriesResult.posterPath) && Intrinsics.areEqual(this.backdropPath, seriesResult.backdropPath) && Intrinsics.areEqual(this.originalLanguage, seriesResult.originalLanguage) && Intrinsics.areEqual(this.genreIds, seriesResult.genreIds) && Intrinsics.areEqual(this.originCountry, seriesResult.originCountry) && this.adult == seriesResult.adult;
        }

        public int hashCode() {
            return (((((((((((((((((((((((((((this.id * 31) + this.name.hashCode()) * 31) + (this.customPosterTag == null ? 0 : this.customPosterTag.hashCode())) * 31) + this.originalName.hashCode()) * 31) + this.overview.hashCode()) * 31) + this.firstAirDate.hashCode()) * 31) + DoFlixProvider$SeriesResult$$ExternalSyntheticBackport0.m0m(this.popularity)) * 31) + this.voteCount) * 31) + DoFlixProvider$SeriesResult$$ExternalSyntheticBackport0.m0m(this.voteAverage)) * 31) + this.posterPath.hashCode()) * 31) + this.backdropPath.hashCode()) * 31) + this.originalLanguage.hashCode()) * 31) + this.genreIds.hashCode()) * 31) + this.originCountry.hashCode()) * 31) + DoFlixProvider$SeriesResult$$ExternalSyntheticBackport1.m1m(this.adult);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("SeriesResult(id=").append(this.id).append(", name=").append(this.name).append(", customPosterTag=").append(this.customPosterTag).append(", originalName=").append(this.originalName).append(", overview=").append(this.overview).append(", firstAirDate=").append(this.firstAirDate).append(", popularity=").append(this.popularity).append(", voteCount=").append(this.voteCount).append(", voteAverage=").append(this.voteAverage).append(", posterPath=").append(this.posterPath).append(", backdropPath=").append(this.backdropPath).append(", originalLanguage=");
            sb.append(this.originalLanguage).append(", genreIds=").append(this.genreIds).append(", originCountry=").append(this.originCountry).append(", adult=").append(this.adult).append(')');
            return sb.toString();
        }

        public SeriesResult(@JsonProperty("id") int id, @JsonProperty("name") @NotNull String name, @JsonProperty("custom_poster_tag") @Nullable String customPosterTag, @JsonProperty("original_name") @NotNull String originalName, @JsonProperty("overview") @NotNull String overview, @JsonProperty("first_air_date") @NotNull String firstAirDate, @JsonProperty("popularity") double popularity, @JsonProperty("vote_count") int voteCount, @JsonProperty("vote_average") double voteAverage, @JsonProperty("poster_path") @NotNull String posterPath, @JsonProperty("backdrop_path") @NotNull String backdropPath, @JsonProperty("original_language") @NotNull String originalLanguage, @JsonProperty("genre_ids") @NotNull List<Integer> list, @JsonProperty("origin_country") @NotNull List<String> list2, @JsonProperty("adult") boolean adult) {
            this.id = id;
            this.name = name;
            this.customPosterTag = customPosterTag;
            this.originalName = originalName;
            this.overview = overview;
            this.firstAirDate = firstAirDate;
            this.popularity = popularity;
            this.voteCount = voteCount;
            this.voteAverage = voteAverage;
            this.posterPath = posterPath;
            this.backdropPath = backdropPath;
            this.originalLanguage = originalLanguage;
            this.genreIds = list;
            this.originCountry = list2;
            this.adult = adult;
        }

        public final int getId() {
            return this.id;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @Nullable
        public final String getCustomPosterTag() {
            return this.customPosterTag;
        }

        @NotNull
        public final String getOriginalName() {
            return this.originalName;
        }

        @NotNull
        public final String getOverview() {
            return this.overview;
        }

        @NotNull
        public final String getFirstAirDate() {
            return this.firstAirDate;
        }

        public final double getPopularity() {
            return this.popularity;
        }

        public final int getVoteCount() {
            return this.voteCount;
        }

        public final double getVoteAverage() {
            return this.voteAverage;
        }

        @NotNull
        public final String getPosterPath() {
            return this.posterPath;
        }

        @NotNull
        public final String getBackdropPath() {
            return this.backdropPath;
        }

        @NotNull
        public final String getOriginalLanguage() {
            return this.originalLanguage;
        }

        @NotNull
        public final List<Integer> getGenreIds() {
            return this.genreIds;
        }

        @NotNull
        public final List<String> getOriginCountry() {
            return this.originCountry;
        }

        public final boolean getAdult() {
            return this.adult;
        }
    }

    /* JADX INFO: compiled from: DoFlixProvider.kt */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0001\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0001\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\u000e\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0003\u0010\u0007\u001a\u00020\u00032\b\b\u0003\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/cncverse/DoFlixProvider$HomePageApiResponse;", "", "page", "", "results", "", "Lcom/cncverse/DoFlixProvider$MovieResult;", "totalPages", "totalResults", "<init>", "(ILjava/util/List;II)V", "getPage", "()I", "getResults", "()Ljava/util/List;", "getTotalPages", "getTotalResults", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "DoFlixProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class HomePageApiResponse {

        @JsonProperty("page")
        private final int page;

        @JsonProperty("results")
        @NotNull
        private final List<MovieResult> results;

        @JsonProperty("total_pages")
        private final int totalPages;

        @JsonProperty("total_results")
        private final int totalResults;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ HomePageApiResponse copy$default(HomePageApiResponse homePageApiResponse, int i, List list, int i2, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = homePageApiResponse.page;
            }
            if ((i4 & 2) != 0) {
                list = homePageApiResponse.results;
            }
            if ((i4 & 4) != 0) {
                i2 = homePageApiResponse.totalPages;
            }
            if ((i4 & 8) != 0) {
                i3 = homePageApiResponse.totalResults;
            }
            return homePageApiResponse.copy(i, list, i2, i3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getPage() {
            return this.page;
        }

        @NotNull
        public final List<MovieResult> component2() {
            return this.results;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getTotalPages() {
            return this.totalPages;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getTotalResults() {
            return this.totalResults;
        }

        @NotNull
        public final HomePageApiResponse copy(@JsonProperty("page") int page, @JsonProperty("results") @NotNull List<MovieResult> results, @JsonProperty("total_pages") int totalPages, @JsonProperty("total_results") int totalResults) {
            return new HomePageApiResponse(page, results, totalPages, totalResults);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof HomePageApiResponse)) {
                return false;
            }
            HomePageApiResponse homePageApiResponse = (HomePageApiResponse) other;
            return this.page == homePageApiResponse.page && Intrinsics.areEqual(this.results, homePageApiResponse.results) && this.totalPages == homePageApiResponse.totalPages && this.totalResults == homePageApiResponse.totalResults;
        }

        public int hashCode() {
            return (((((this.page * 31) + this.results.hashCode()) * 31) + this.totalPages) * 31) + this.totalResults;
        }

        @NotNull
        public String toString() {
            return "HomePageApiResponse(page=" + this.page + ", results=" + this.results + ", totalPages=" + this.totalPages + ", totalResults=" + this.totalResults + ')';
        }

        public HomePageApiResponse(@JsonProperty("page") int page, @JsonProperty("results") @NotNull List<MovieResult> list, @JsonProperty("total_pages") int totalPages, @JsonProperty("total_results") int totalResults) {
            this.page = page;
            this.results = list;
            this.totalPages = totalPages;
            this.totalResults = totalResults;
        }

        public final int getPage() {
            return this.page;
        }

        @NotNull
        public final List<MovieResult> getResults() {
            return this.results;
        }

        public final int getTotalPages() {
            return this.totalPages;
        }

        public final int getTotalResults() {
            return this.totalResults;
        }
    }

    /* JADX INFO: compiled from: DoFlixProvider.kt */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0001\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0001\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\u000e\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0003\u0010\u0007\u001a\u00020\u00032\b\b\u0003\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/cncverse/DoFlixProvider$SeriesPageApiResponse;", "", "page", "", "results", "", "Lcom/cncverse/DoFlixProvider$SeriesResult;", "totalPages", "totalResults", "<init>", "(ILjava/util/List;II)V", "getPage", "()I", "getResults", "()Ljava/util/List;", "getTotalPages", "getTotalResults", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "DoFlixProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class SeriesPageApiResponse {

        @JsonProperty("page")
        private final int page;

        @JsonProperty("results")
        @NotNull
        private final List<SeriesResult> results;

        @JsonProperty("total_pages")
        private final int totalPages;

        @JsonProperty("total_results")
        private final int totalResults;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SeriesPageApiResponse copy$default(SeriesPageApiResponse seriesPageApiResponse, int i, List list, int i2, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = seriesPageApiResponse.page;
            }
            if ((i4 & 2) != 0) {
                list = seriesPageApiResponse.results;
            }
            if ((i4 & 4) != 0) {
                i2 = seriesPageApiResponse.totalPages;
            }
            if ((i4 & 8) != 0) {
                i3 = seriesPageApiResponse.totalResults;
            }
            return seriesPageApiResponse.copy(i, list, i2, i3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getPage() {
            return this.page;
        }

        @NotNull
        public final List<SeriesResult> component2() {
            return this.results;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getTotalPages() {
            return this.totalPages;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getTotalResults() {
            return this.totalResults;
        }

        @NotNull
        public final SeriesPageApiResponse copy(@JsonProperty("page") int page, @JsonProperty("results") @NotNull List<SeriesResult> results, @JsonProperty("total_pages") int totalPages, @JsonProperty("total_results") int totalResults) {
            return new SeriesPageApiResponse(page, results, totalPages, totalResults);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SeriesPageApiResponse)) {
                return false;
            }
            SeriesPageApiResponse seriesPageApiResponse = (SeriesPageApiResponse) other;
            return this.page == seriesPageApiResponse.page && Intrinsics.areEqual(this.results, seriesPageApiResponse.results) && this.totalPages == seriesPageApiResponse.totalPages && this.totalResults == seriesPageApiResponse.totalResults;
        }

        public int hashCode() {
            return (((((this.page * 31) + this.results.hashCode()) * 31) + this.totalPages) * 31) + this.totalResults;
        }

        @NotNull
        public String toString() {
            return "SeriesPageApiResponse(page=" + this.page + ", results=" + this.results + ", totalPages=" + this.totalPages + ", totalResults=" + this.totalResults + ')';
        }

        public SeriesPageApiResponse(@JsonProperty("page") int page, @JsonProperty("results") @NotNull List<SeriesResult> list, @JsonProperty("total_pages") int totalPages, @JsonProperty("total_results") int totalResults) {
            this.page = page;
            this.results = list;
            this.totalPages = totalPages;
            this.totalResults = totalResults;
        }

        public final int getPage() {
            return this.page;
        }

        @NotNull
        public final List<SeriesResult> getResults() {
            return this.results;
        }

        public final int getTotalPages() {
            return this.totalPages;
        }

        public final int getTotalResults() {
            return this.totalResults;
        }
    }

    /* JADX INFO: compiled from: DoFlixProvider.kt */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001By\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\n\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0001\u0010\f\u001a\u00020\u0003\u0012\b\b\u0001\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J{\u0010%\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00032\b\b\u0003\u0010\u0007\u001a\u00020\u00032\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\n\u001a\u00020\u00032\b\b\u0003\u0010\u000b\u001a\u00020\u00032\b\b\u0003\u0010\f\u001a\u00020\u00032\b\b\u0003\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0014\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010)\u001a\u00020*HÖ\u0081\u0004J\n\u0010+\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0011R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0011R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011¨\u0006,"}, d2 = {"Lcom/cncverse/DoFlixProvider$VideoItem;", "", "videosId", "", "title", "description", "slug", "release", "isTvseries", "isPaid", "runtime", "videoQuality", "thumbnailUrl", "posterUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getVideosId", "()Ljava/lang/String;", "getTitle", "getDescription", "getSlug", "getRelease", "getRuntime", "getVideoQuality", "getThumbnailUrl", "getPosterUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "", "other", "hashCode", "", "toString", "DoFlixProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class VideoItem {

        @JsonProperty("description")
        @NotNull
        private final String description;

        @JsonProperty("is_paid")
        @Nullable
        private final String isPaid;

        @JsonProperty("is_tvseries")
        @Nullable
        private final String isTvseries;

        @JsonProperty("poster_url")
        @NotNull
        private final String posterUrl;

        @JsonProperty("release")
        @NotNull
        private final String release;

        @JsonProperty("runtime")
        @NotNull
        private final String runtime;

        @JsonProperty("slug")
        @NotNull
        private final String slug;

        @JsonProperty("thumbnail_url")
        @NotNull
        private final String thumbnailUrl;

        @JsonProperty("title")
        @NotNull
        private final String title;

        @JsonProperty("video_quality")
        @NotNull
        private final String videoQuality;

        @JsonProperty("videos_id")
        @NotNull
        private final String videosId;

        public static /* synthetic */ VideoItem copy$default(VideoItem videoItem, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, int i, Object obj) {
            if ((i & 1) != 0) {
                str = videoItem.videosId;
            }
            if ((i & 2) != 0) {
                str2 = videoItem.title;
            }
            if ((i & 4) != 0) {
                str3 = videoItem.description;
            }
            if ((i & 8) != 0) {
                str4 = videoItem.slug;
            }
            if ((i & 16) != 0) {
                str5 = videoItem.release;
            }
            if ((i & 32) != 0) {
                str6 = videoItem.isTvseries;
            }
            if ((i & 64) != 0) {
                str7 = videoItem.isPaid;
            }
            if ((i & 128) != 0) {
                str8 = videoItem.runtime;
            }
            if ((i & 256) != 0) {
                str9 = videoItem.videoQuality;
            }
            if ((i & 512) != 0) {
                str10 = videoItem.thumbnailUrl;
            }
            if ((i & 1024) != 0) {
                str11 = videoItem.posterUrl;
            }
            String str12 = str10;
            String str13 = str11;
            String str14 = str8;
            String str15 = str9;
            String str16 = str6;
            String str17 = str7;
            String str18 = str5;
            String str19 = str3;
            return videoItem.copy(str, str2, str19, str4, str18, str16, str17, str14, str15, str12, str13);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getVideosId() {
            return this.videosId;
        }

        @NotNull
        /* JADX INFO: renamed from: component10, reason: from getter */
        public final String getThumbnailUrl() {
            return this.thumbnailUrl;
        }

        @NotNull
        /* JADX INFO: renamed from: component11, reason: from getter */
        public final String getPosterUrl() {
            return this.posterUrl;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        @NotNull
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getSlug() {
            return this.slug;
        }

        @NotNull
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getRelease() {
            return this.release;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getIsTvseries() {
            return this.isTvseries;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getIsPaid() {
            return this.isPaid;
        }

        @NotNull
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getRuntime() {
            return this.runtime;
        }

        @NotNull
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getVideoQuality() {
            return this.videoQuality;
        }

        @NotNull
        public final VideoItem copy(@JsonProperty("videos_id") @NotNull String videosId, @JsonProperty("title") @NotNull String title, @JsonProperty("description") @NotNull String description, @JsonProperty("slug") @NotNull String slug, @JsonProperty("release") @NotNull String release, @JsonProperty("is_tvseries") @Nullable String isTvseries, @JsonProperty("is_paid") @Nullable String isPaid, @JsonProperty("runtime") @NotNull String runtime, @JsonProperty("video_quality") @NotNull String videoQuality, @JsonProperty("thumbnail_url") @NotNull String thumbnailUrl, @JsonProperty("poster_url") @NotNull String posterUrl) {
            return new VideoItem(videosId, title, description, slug, release, isTvseries, isPaid, runtime, videoQuality, thumbnailUrl, posterUrl);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VideoItem)) {
                return false;
            }
            VideoItem videoItem = (VideoItem) other;
            return Intrinsics.areEqual(this.videosId, videoItem.videosId) && Intrinsics.areEqual(this.title, videoItem.title) && Intrinsics.areEqual(this.description, videoItem.description) && Intrinsics.areEqual(this.slug, videoItem.slug) && Intrinsics.areEqual(this.release, videoItem.release) && Intrinsics.areEqual(this.isTvseries, videoItem.isTvseries) && Intrinsics.areEqual(this.isPaid, videoItem.isPaid) && Intrinsics.areEqual(this.runtime, videoItem.runtime) && Intrinsics.areEqual(this.videoQuality, videoItem.videoQuality) && Intrinsics.areEqual(this.thumbnailUrl, videoItem.thumbnailUrl) && Intrinsics.areEqual(this.posterUrl, videoItem.posterUrl);
        }

        public int hashCode() {
            return (((((((((((((((((((this.videosId.hashCode() * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31) + this.slug.hashCode()) * 31) + this.release.hashCode()) * 31) + (this.isTvseries == null ? 0 : this.isTvseries.hashCode())) * 31) + (this.isPaid != null ? this.isPaid.hashCode() : 0)) * 31) + this.runtime.hashCode()) * 31) + this.videoQuality.hashCode()) * 31) + this.thumbnailUrl.hashCode()) * 31) + this.posterUrl.hashCode();
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("VideoItem(videosId=").append(this.videosId).append(", title=").append(this.title).append(", description=").append(this.description).append(", slug=").append(this.slug).append(", release=").append(this.release).append(", isTvseries=").append(this.isTvseries).append(", isPaid=").append(this.isPaid).append(", runtime=").append(this.runtime).append(", videoQuality=").append(this.videoQuality).append(", thumbnailUrl=").append(this.thumbnailUrl).append(", posterUrl=").append(this.posterUrl).append(')');
            return sb.toString();
        }

        public VideoItem(@JsonProperty("videos_id") @NotNull String videosId, @JsonProperty("title") @NotNull String title, @JsonProperty("description") @NotNull String description, @JsonProperty("slug") @NotNull String slug, @JsonProperty("release") @NotNull String release, @JsonProperty("is_tvseries") @Nullable String isTvseries, @JsonProperty("is_paid") @Nullable String isPaid, @JsonProperty("runtime") @NotNull String runtime, @JsonProperty("video_quality") @NotNull String videoQuality, @JsonProperty("thumbnail_url") @NotNull String thumbnailUrl, @JsonProperty("poster_url") @NotNull String posterUrl) {
            this.videosId = videosId;
            this.title = title;
            this.description = description;
            this.slug = slug;
            this.release = release;
            this.isTvseries = isTvseries;
            this.isPaid = isPaid;
            this.runtime = runtime;
            this.videoQuality = videoQuality;
            this.thumbnailUrl = thumbnailUrl;
            this.posterUrl = posterUrl;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ VideoItem(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, int i, DefaultConstructorMarker defaultConstructorMarker) {
            String str12;
            String str13;
            if ((i & 32) == 0) {
                str12 = str6;
            } else {
                str12 = null;
            }
            if ((i & 64) == 0) {
                str13 = str7;
            } else {
                str13 = "0";
            }
            this(str, str2, str3, str4, str5, str12, str13, str8, str9, str10, str11);
        }

        @NotNull
        public final String getVideosId() {
            return this.videosId;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        public final String getDescription() {
            return this.description;
        }

        @NotNull
        public final String getSlug() {
            return this.slug;
        }

        @NotNull
        public final String getRelease() {
            return this.release;
        }

        @Nullable
        public final String isTvseries() {
            return this.isTvseries;
        }

        @Nullable
        public final String isPaid() {
            return this.isPaid;
        }

        @NotNull
        public final String getRuntime() {
            return this.runtime;
        }

        @NotNull
        public final String getVideoQuality() {
            return this.videoQuality;
        }

        @NotNull
        public final String getThumbnailUrl() {
            return this.thumbnailUrl;
        }

        @NotNull
        public final String getPosterUrl() {
            return this.posterUrl;
        }
    }

    /* JADX INFO: compiled from: DoFlixProvider.kt */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0001\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003HÆ\u0003J9\u0010\u0010\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0003\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0003\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003HÆ\u0001J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/cncverse/DoFlixProvider$SearchApiResponse;", "", "movie", "", "Lcom/cncverse/DoFlixProvider$VideoItem;", "tvseries", "tvChannels", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getMovie", "()Ljava/util/List;", "getTvseries", "getTvChannels", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "DoFlixProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class SearchApiResponse {

        @JsonProperty("movie")
        @NotNull
        private final List<VideoItem> movie;

        @JsonProperty("tv_channels")
        @NotNull
        private final List<Object> tvChannels;

        @JsonProperty("tvseries")
        @NotNull
        private final List<VideoItem> tvseries;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SearchApiResponse copy$default(SearchApiResponse searchApiResponse, List list, List list2, List list3, int i, Object obj) {
            if ((i & 1) != 0) {
                list = searchApiResponse.movie;
            }
            if ((i & 2) != 0) {
                list2 = searchApiResponse.tvseries;
            }
            if ((i & 4) != 0) {
                list3 = searchApiResponse.tvChannels;
            }
            return searchApiResponse.copy(list, list2, list3);
        }

        @NotNull
        public final List<VideoItem> component1() {
            return this.movie;
        }

        @NotNull
        public final List<VideoItem> component2() {
            return this.tvseries;
        }

        @NotNull
        public final List<Object> component3() {
            return this.tvChannels;
        }

        @NotNull
        public final SearchApiResponse copy(@JsonProperty("movie") @NotNull List<VideoItem> movie, @JsonProperty("tvseries") @NotNull List<VideoItem> tvseries, @JsonProperty("tv_channels") @NotNull List<? extends Object> tvChannels) {
            return new SearchApiResponse(movie, tvseries, tvChannels);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SearchApiResponse)) {
                return false;
            }
            SearchApiResponse searchApiResponse = (SearchApiResponse) other;
            return Intrinsics.areEqual(this.movie, searchApiResponse.movie) && Intrinsics.areEqual(this.tvseries, searchApiResponse.tvseries) && Intrinsics.areEqual(this.tvChannels, searchApiResponse.tvChannels);
        }

        public int hashCode() {
            return (((this.movie.hashCode() * 31) + this.tvseries.hashCode()) * 31) + this.tvChannels.hashCode();
        }

        @NotNull
        public String toString() {
            return "SearchApiResponse(movie=" + this.movie + ", tvseries=" + this.tvseries + ", tvChannels=" + this.tvChannels + ')';
        }

        public SearchApiResponse(@JsonProperty("movie") @NotNull List<VideoItem> list, @JsonProperty("tvseries") @NotNull List<VideoItem> list2, @JsonProperty("tv_channels") @NotNull List<? extends Object> list3) {
            this.movie = list;
            this.tvseries = list2;
            this.tvChannels = list3;
        }

        @NotNull
        public final List<VideoItem> getMovie() {
            return this.movie;
        }

        @NotNull
        public final List<VideoItem> getTvseries() {
            return this.tvseries;
        }

        @NotNull
        public final List<Object> getTvChannels() {
            return this.tvChannels;
        }
    }

    /* JADX INFO: compiled from: DoFlixProvider.kt */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0005HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/cncverse/DoFlixProvider$TMDBGenre;", "", "id", "", "name", "", "<init>", "(ILjava/lang/String;)V", "getId", "()I", "getName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "DoFlixProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class TMDBGenre {

        @JsonProperty("id")
        private final int id;

        @JsonProperty("name")
        @NotNull
        private final String name;

        public static /* synthetic */ TMDBGenre copy$default(TMDBGenre tMDBGenre, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = tMDBGenre.id;
            }
            if ((i2 & 2) != 0) {
                str = tMDBGenre.name;
            }
            return tMDBGenre.copy(i, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getId() {
            return this.id;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @NotNull
        public final TMDBGenre copy(@JsonProperty("id") int id, @JsonProperty("name") @NotNull String name) {
            return new TMDBGenre(id, name);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TMDBGenre)) {
                return false;
            }
            TMDBGenre tMDBGenre = (TMDBGenre) other;
            return this.id == tMDBGenre.id && Intrinsics.areEqual(this.name, tMDBGenre.name);
        }

        public int hashCode() {
            return (this.id * 31) + this.name.hashCode();
        }

        @NotNull
        public String toString() {
            return "TMDBGenre(id=" + this.id + ", name=" + this.name + ')';
        }

        public TMDBGenre(@JsonProperty("id") int id, @JsonProperty("name") @NotNull String name) {
            this.id = id;
            this.name = name;
        }

        public final int getId() {
            return this.id;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }
    }

    /* JADX INFO: compiled from: DoFlixProvider.kt */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/cncverse/DoFlixProvider$ProductionCountry;", "", "iso31661", "", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getIso31661", "()Ljava/lang/String;", "getName", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "DoFlixProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class ProductionCountry {

        @JsonProperty("iso_3166_1")
        @Nullable
        private final String iso31661;

        @JsonProperty("name")
        @Nullable
        private final String name;

        /* JADX WARN: Illegal instructions before constructor call */
        public ProductionCountry() {
            String str = null;
            this(str, str, 3, str);
        }

        public static /* synthetic */ ProductionCountry copy$default(ProductionCountry productionCountry, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = productionCountry.iso31661;
            }
            if ((i & 2) != 0) {
                str2 = productionCountry.name;
            }
            return productionCountry.copy(str, str2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getIso31661() {
            return this.iso31661;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @NotNull
        public final ProductionCountry copy(@JsonProperty("iso_3166_1") @Nullable String iso31661, @JsonProperty("name") @Nullable String name) {
            return new ProductionCountry(iso31661, name);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ProductionCountry)) {
                return false;
            }
            ProductionCountry productionCountry = (ProductionCountry) other;
            return Intrinsics.areEqual(this.iso31661, productionCountry.iso31661) && Intrinsics.areEqual(this.name, productionCountry.name);
        }

        public int hashCode() {
            return ((this.iso31661 == null ? 0 : this.iso31661.hashCode()) * 31) + (this.name != null ? this.name.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "ProductionCountry(iso31661=" + this.iso31661 + ", name=" + this.name + ')';
        }

        public ProductionCountry(@JsonProperty("iso_3166_1") @Nullable String iso31661, @JsonProperty("name") @Nullable String name) {
            this.iso31661 = iso31661;
            this.name = name;
        }

        public /* synthetic */ ProductionCountry(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }

        @Nullable
        public final String getIso31661() {
            return this.iso31661;
        }

        @Nullable
        public final String getName() {
            return this.name;
        }
    }

    /* JADX INFO: compiled from: DoFlixProvider.kt */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b:\b\u0087\b\u0018\u00002\u00020\u0001Bõ\u0001\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\t\u00108\u001a\u00020\u0005HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u0010@\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u0010B\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010F\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010/J\u000b\u0010G\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010H\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0002\u00103J\u0010\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u0010J\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jü\u0001\u0010K\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010LJ\u0014\u0010M\u001a\u00020\u00142\b\u0010N\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010O\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010P\u001a\u00020\u0005HÖ\u0081\u0004R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010 R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010 R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010 R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010 R\u001a\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b'\u0010\u001dR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010 R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b)\u0010\u001dR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010 R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010 R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010 R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b-\u0010\u001dR\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00100\u001a\u0004\b.\u0010/R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010 R\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00104\u001a\u0004\b2\u00103R\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b5\u0010\u001dR\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010 ¨\u0006Q"}, d2 = {"Lcom/cncverse/DoFlixProvider$CastMember;", "", "id", "", "name", "", "character", "profilePath", "biography", "birthday", "deathday", "placeOfBirth", "gender", "knownForDepartment", "tmdbId", "createdAt", "updatedAt", "metadata", "order", "adult", "", "originalName", "popularity", "", "castId", "creditId", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/String;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "getCharacter", "getProfilePath", "getBiography", "getBirthday", "getDeathday", "getPlaceOfBirth", "getGender", "getKnownForDepartment", "getTmdbId", "getCreatedAt", "getUpdatedAt", "getMetadata", "getOrder", "getAdult", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getOriginalName", "getPopularity", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getCastId", "getCreditId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/String;)Lcom/cncverse/DoFlixProvider$CastMember;", "equals", "other", "hashCode", "toString", "DoFlixProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class CastMember {

        @JsonProperty("adult")
        @Nullable
        private final Boolean adult;

        @JsonProperty("biography")
        @Nullable
        private final String biography;

        @JsonProperty("birthday")
        @Nullable
        private final String birthday;

        @JsonProperty("cast_id")
        @Nullable
        private final Integer castId;

        @JsonProperty("character")
        @Nullable
        private final String character;

        @JsonProperty("created_at")
        @Nullable
        private final String createdAt;

        @JsonProperty("credit_id")
        @Nullable
        private final String creditId;

        @JsonProperty("deathday")
        @Nullable
        private final String deathday;

        @JsonProperty("gender")
        @Nullable
        private final Integer gender;

        @JsonProperty("id")
        @Nullable
        private final Integer id;

        @JsonProperty("known_for_department")
        @Nullable
        private final String knownForDepartment;

        @JsonProperty("metadata")
        @Nullable
        private final String metadata;

        @JsonProperty("name")
        @NotNull
        private final String name;

        @JsonProperty("order")
        @Nullable
        private final Integer order;

        @JsonProperty("original_name")
        @Nullable
        private final String originalName;

        @JsonProperty("place_of_birth")
        @Nullable
        private final String placeOfBirth;

        @JsonProperty("popularity")
        @Nullable
        private final Double popularity;

        @JsonProperty("profile_path")
        @Nullable
        private final String profilePath;

        @JsonProperty("tmdb_id")
        @Nullable
        private final Integer tmdbId;

        @JsonProperty("updated_at")
        @Nullable
        private final String updatedAt;

        public static /* synthetic */ CastMember copy$default(CastMember castMember, Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, Integer num2, String str8, Integer num3, String str9, String str10, String str11, Integer num4, Boolean bool, String str12, Double d, Integer num5, String str13, int i, Object obj) {
            String str14;
            Integer num6;
            Integer num7 = (i & 1) != 0 ? castMember.id : num;
            String str15 = (i & 2) != 0 ? castMember.name : str;
            String str16 = (i & 4) != 0 ? castMember.character : str2;
            String str17 = (i & 8) != 0 ? castMember.profilePath : str3;
            String str18 = (i & 16) != 0 ? castMember.biography : str4;
            String str19 = (i & 32) != 0 ? castMember.birthday : str5;
            String str20 = (i & 64) != 0 ? castMember.deathday : str6;
            String str21 = (i & 128) != 0 ? castMember.placeOfBirth : str7;
            Integer num8 = (i & 256) != 0 ? castMember.gender : num2;
            String str22 = (i & 512) != 0 ? castMember.knownForDepartment : str8;
            Integer num9 = (i & 1024) != 0 ? castMember.tmdbId : num3;
            String str23 = (i & 2048) != 0 ? castMember.createdAt : str9;
            String str24 = (i & 4096) != 0 ? castMember.updatedAt : str10;
            String str25 = (i & 8192) != 0 ? castMember.metadata : str11;
            Integer num10 = num7;
            Integer num11 = (i & 16384) != 0 ? castMember.order : num4;
            Boolean bool2 = (i & 32768) != 0 ? castMember.adult : bool;
            String str26 = (i & 65536) != 0 ? castMember.originalName : str12;
            Double d2 = (i & 131072) != 0 ? castMember.popularity : d;
            Integer num12 = (i & 262144) != 0 ? castMember.castId : num5;
            if ((i & 524288) != 0) {
                num6 = num12;
                str14 = castMember.creditId;
            } else {
                str14 = str13;
                num6 = num12;
            }
            return castMember.copy(num10, str15, str16, str17, str18, str19, str20, str21, num8, str22, num9, str23, str24, str25, num11, bool2, str26, d2, num6, str14);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component10, reason: from getter */
        public final String getKnownForDepartment() {
            return this.knownForDepartment;
        }

        @Nullable
        /* JADX INFO: renamed from: component11, reason: from getter */
        public final Integer getTmdbId() {
            return this.tmdbId;
        }

        @Nullable
        /* JADX INFO: renamed from: component12, reason: from getter */
        public final String getCreatedAt() {
            return this.createdAt;
        }

        @Nullable
        /* JADX INFO: renamed from: component13, reason: from getter */
        public final String getUpdatedAt() {
            return this.updatedAt;
        }

        @Nullable
        /* JADX INFO: renamed from: component14, reason: from getter */
        public final String getMetadata() {
            return this.metadata;
        }

        @Nullable
        /* JADX INFO: renamed from: component15, reason: from getter */
        public final Integer getOrder() {
            return this.order;
        }

        @Nullable
        /* JADX INFO: renamed from: component16, reason: from getter */
        public final Boolean getAdult() {
            return this.adult;
        }

        @Nullable
        /* JADX INFO: renamed from: component17, reason: from getter */
        public final String getOriginalName() {
            return this.originalName;
        }

        @Nullable
        /* JADX INFO: renamed from: component18, reason: from getter */
        public final Double getPopularity() {
            return this.popularity;
        }

        @Nullable
        /* JADX INFO: renamed from: component19, reason: from getter */
        public final Integer getCastId() {
            return this.castId;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @Nullable
        /* JADX INFO: renamed from: component20, reason: from getter */
        public final String getCreditId() {
            return this.creditId;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getCharacter() {
            return this.character;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getProfilePath() {
            return this.profilePath;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getBiography() {
            return this.biography;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getBirthday() {
            return this.birthday;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getDeathday() {
            return this.deathday;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getPlaceOfBirth() {
            return this.placeOfBirth;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final Integer getGender() {
            return this.gender;
        }

        @NotNull
        public final CastMember copy(@JsonProperty("id") @Nullable Integer id, @JsonProperty("name") @NotNull String name, @JsonProperty("character") @Nullable String character, @JsonProperty("profile_path") @Nullable String profilePath, @JsonProperty("biography") @Nullable String biography, @JsonProperty("birthday") @Nullable String birthday, @JsonProperty("deathday") @Nullable String deathday, @JsonProperty("place_of_birth") @Nullable String placeOfBirth, @JsonProperty("gender") @Nullable Integer gender, @JsonProperty("known_for_department") @Nullable String knownForDepartment, @JsonProperty("tmdb_id") @Nullable Integer tmdbId, @JsonProperty("created_at") @Nullable String createdAt, @JsonProperty("updated_at") @Nullable String updatedAt, @JsonProperty("metadata") @Nullable String metadata, @JsonProperty("order") @Nullable Integer order, @JsonProperty("adult") @Nullable Boolean adult, @JsonProperty("original_name") @Nullable String originalName, @JsonProperty("popularity") @Nullable Double popularity, @JsonProperty("cast_id") @Nullable Integer castId, @JsonProperty("credit_id") @Nullable String creditId) {
            return new CastMember(id, name, character, profilePath, biography, birthday, deathday, placeOfBirth, gender, knownForDepartment, tmdbId, createdAt, updatedAt, metadata, order, adult, originalName, popularity, castId, creditId);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CastMember)) {
                return false;
            }
            CastMember castMember = (CastMember) other;
            return Intrinsics.areEqual(this.id, castMember.id) && Intrinsics.areEqual(this.name, castMember.name) && Intrinsics.areEqual(this.character, castMember.character) && Intrinsics.areEqual(this.profilePath, castMember.profilePath) && Intrinsics.areEqual(this.biography, castMember.biography) && Intrinsics.areEqual(this.birthday, castMember.birthday) && Intrinsics.areEqual(this.deathday, castMember.deathday) && Intrinsics.areEqual(this.placeOfBirth, castMember.placeOfBirth) && Intrinsics.areEqual(this.gender, castMember.gender) && Intrinsics.areEqual(this.knownForDepartment, castMember.knownForDepartment) && Intrinsics.areEqual(this.tmdbId, castMember.tmdbId) && Intrinsics.areEqual(this.createdAt, castMember.createdAt) && Intrinsics.areEqual(this.updatedAt, castMember.updatedAt) && Intrinsics.areEqual(this.metadata, castMember.metadata) && Intrinsics.areEqual(this.order, castMember.order) && Intrinsics.areEqual(this.adult, castMember.adult) && Intrinsics.areEqual(this.originalName, castMember.originalName) && Intrinsics.areEqual(this.popularity, castMember.popularity) && Intrinsics.areEqual(this.castId, castMember.castId) && Intrinsics.areEqual(this.creditId, castMember.creditId);
        }

        public int hashCode() {
            return ((((((((((((((((((((((((((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + this.name.hashCode()) * 31) + (this.character == null ? 0 : this.character.hashCode())) * 31) + (this.profilePath == null ? 0 : this.profilePath.hashCode())) * 31) + (this.biography == null ? 0 : this.biography.hashCode())) * 31) + (this.birthday == null ? 0 : this.birthday.hashCode())) * 31) + (this.deathday == null ? 0 : this.deathday.hashCode())) * 31) + (this.placeOfBirth == null ? 0 : this.placeOfBirth.hashCode())) * 31) + (this.gender == null ? 0 : this.gender.hashCode())) * 31) + (this.knownForDepartment == null ? 0 : this.knownForDepartment.hashCode())) * 31) + (this.tmdbId == null ? 0 : this.tmdbId.hashCode())) * 31) + (this.createdAt == null ? 0 : this.createdAt.hashCode())) * 31) + (this.updatedAt == null ? 0 : this.updatedAt.hashCode())) * 31) + (this.metadata == null ? 0 : this.metadata.hashCode())) * 31) + (this.order == null ? 0 : this.order.hashCode())) * 31) + (this.adult == null ? 0 : this.adult.hashCode())) * 31) + (this.originalName == null ? 0 : this.originalName.hashCode())) * 31) + (this.popularity == null ? 0 : this.popularity.hashCode())) * 31) + (this.castId == null ? 0 : this.castId.hashCode())) * 31) + (this.creditId != null ? this.creditId.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("CastMember(id=").append(this.id).append(", name=").append(this.name).append(", character=").append(this.character).append(", profilePath=").append(this.profilePath).append(", biography=").append(this.biography).append(", birthday=").append(this.birthday).append(", deathday=").append(this.deathday).append(", placeOfBirth=").append(this.placeOfBirth).append(", gender=").append(this.gender).append(", knownForDepartment=").append(this.knownForDepartment).append(", tmdbId=").append(this.tmdbId).append(", createdAt=");
            sb.append(this.createdAt).append(", updatedAt=").append(this.updatedAt).append(", metadata=").append(this.metadata).append(", order=").append(this.order).append(", adult=").append(this.adult).append(", originalName=").append(this.originalName).append(", popularity=").append(this.popularity).append(", castId=").append(this.castId).append(", creditId=").append(this.creditId).append(')');
            return sb.toString();
        }

        public CastMember(@JsonProperty("id") @Nullable Integer id, @JsonProperty("name") @NotNull String name, @JsonProperty("character") @Nullable String character, @JsonProperty("profile_path") @Nullable String profilePath, @JsonProperty("biography") @Nullable String biography, @JsonProperty("birthday") @Nullable String birthday, @JsonProperty("deathday") @Nullable String deathday, @JsonProperty("place_of_birth") @Nullable String placeOfBirth, @JsonProperty("gender") @Nullable Integer gender, @JsonProperty("known_for_department") @Nullable String knownForDepartment, @JsonProperty("tmdb_id") @Nullable Integer tmdbId, @JsonProperty("created_at") @Nullable String createdAt, @JsonProperty("updated_at") @Nullable String updatedAt, @JsonProperty("metadata") @Nullable String metadata, @JsonProperty("order") @Nullable Integer order, @JsonProperty("adult") @Nullable Boolean adult, @JsonProperty("original_name") @Nullable String originalName, @JsonProperty("popularity") @Nullable Double popularity, @JsonProperty("cast_id") @Nullable Integer castId, @JsonProperty("credit_id") @Nullable String creditId) {
            this.id = id;
            this.name = name;
            this.character = character;
            this.profilePath = profilePath;
            this.biography = biography;
            this.birthday = birthday;
            this.deathday = deathday;
            this.placeOfBirth = placeOfBirth;
            this.gender = gender;
            this.knownForDepartment = knownForDepartment;
            this.tmdbId = tmdbId;
            this.createdAt = createdAt;
            this.updatedAt = updatedAt;
            this.metadata = metadata;
            this.order = order;
            this.adult = adult;
            this.originalName = originalName;
            this.popularity = popularity;
            this.castId = castId;
            this.creditId = creditId;
        }

        public /* synthetic */ CastMember(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, Integer num2, String str8, Integer num3, String str9, String str10, String str11, Integer num4, Boolean bool, String str12, Double d, Integer num5, String str13, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, str, str2, str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : num2, (i & 512) != 0 ? null : str8, (i & 1024) != 0 ? null : num3, (i & 2048) != 0 ? null : str9, (i & 4096) != 0 ? null : str10, (i & 8192) != 0 ? null : str11, (i & 16384) != 0 ? null : num4, (32768 & i) != 0 ? null : bool, (65536 & i) != 0 ? null : str12, (131072 & i) != 0 ? null : d, (262144 & i) != 0 ? null : num5, (i & 524288) != 0 ? null : str13);
        }

        @Nullable
        public final Integer getId() {
            return this.id;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @Nullable
        public final String getCharacter() {
            return this.character;
        }

        @Nullable
        public final String getProfilePath() {
            return this.profilePath;
        }

        @Nullable
        public final String getBiography() {
            return this.biography;
        }

        @Nullable
        public final String getBirthday() {
            return this.birthday;
        }

        @Nullable
        public final String getDeathday() {
            return this.deathday;
        }

        @Nullable
        public final String getPlaceOfBirth() {
            return this.placeOfBirth;
        }

        @Nullable
        public final Integer getGender() {
            return this.gender;
        }

        @Nullable
        public final String getKnownForDepartment() {
            return this.knownForDepartment;
        }

        @Nullable
        public final Integer getTmdbId() {
            return this.tmdbId;
        }

        @Nullable
        public final String getCreatedAt() {
            return this.createdAt;
        }

        @Nullable
        public final String getUpdatedAt() {
            return this.updatedAt;
        }

        @Nullable
        public final String getMetadata() {
            return this.metadata;
        }

        @Nullable
        public final Integer getOrder() {
            return this.order;
        }

        @Nullable
        public final Boolean getAdult() {
            return this.adult;
        }

        @Nullable
        public final String getOriginalName() {
            return this.originalName;
        }

        @Nullable
        public final Double getPopularity() {
            return this.popularity;
        }

        @Nullable
        public final Integer getCastId() {
            return this.castId;
        }

        @Nullable
        public final String getCreditId() {
            return this.creditId;
        }
    }

    /* JADX INFO: compiled from: DoFlixProvider.kt */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b7\b\u0087\b\u0018\u00002\u00020\u0001Bé\u0001\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\t\u00106\u001a\u00020\u0005HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010?\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010A\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010D\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010.J\u000b\u0010E\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010F\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0002\u00102J\u000b\u0010G\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jð\u0001\u0010H\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010IJ\u0014\u0010J\u001a\u00020\u00142\b\u0010K\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010L\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010M\u001a\u00020\u0005HÖ\u0081\u0004R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001fR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001fR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001fR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001fR\u001a\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b'\u0010\u001cR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001fR\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b)\u0010\u001cR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001fR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001fR\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010/\u001a\u0004\b-\u0010.R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001fR\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00103\u001a\u0004\b1\u00102R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001f¨\u0006N"}, d2 = {"Lcom/cncverse/DoFlixProvider$CrewMember;", "", "id", "", "name", "", "job", "department", "profilePath", "biography", "birthday", "deathday", "placeOfBirth", "gender", "knownForDepartment", "tmdbId", "createdAt", "updatedAt", "metadata", "adult", "", "originalName", "popularity", "", "creditId", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "getJob", "getDepartment", "getProfilePath", "getBiography", "getBirthday", "getDeathday", "getPlaceOfBirth", "getGender", "getKnownForDepartment", "getTmdbId", "getCreatedAt", "getUpdatedAt", "getMetadata", "getAdult", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getOriginalName", "getPopularity", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getCreditId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;)Lcom/cncverse/DoFlixProvider$CrewMember;", "equals", "other", "hashCode", "toString", "DoFlixProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class CrewMember {

        @JsonProperty("adult")
        @Nullable
        private final Boolean adult;

        @JsonProperty("biography")
        @Nullable
        private final String biography;

        @JsonProperty("birthday")
        @Nullable
        private final String birthday;

        @JsonProperty("created_at")
        @Nullable
        private final String createdAt;

        @JsonProperty("credit_id")
        @Nullable
        private final String creditId;

        @JsonProperty("deathday")
        @Nullable
        private final String deathday;

        @JsonProperty("department")
        @Nullable
        private final String department;

        @JsonProperty("gender")
        @Nullable
        private final Integer gender;

        @JsonProperty("id")
        @Nullable
        private final Integer id;

        @JsonProperty("job")
        @Nullable
        private final String job;

        @JsonProperty("known_for_department")
        @Nullable
        private final String knownForDepartment;

        @JsonProperty("metadata")
        @Nullable
        private final String metadata;

        @JsonProperty("name")
        @NotNull
        private final String name;

        @JsonProperty("original_name")
        @Nullable
        private final String originalName;

        @JsonProperty("place_of_birth")
        @Nullable
        private final String placeOfBirth;

        @JsonProperty("popularity")
        @Nullable
        private final Double popularity;

        @JsonProperty("profile_path")
        @Nullable
        private final String profilePath;

        @JsonProperty("tmdb_id")
        @Nullable
        private final Integer tmdbId;

        @JsonProperty("updated_at")
        @Nullable
        private final String updatedAt;

        public static /* synthetic */ CrewMember copy$default(CrewMember crewMember, Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Integer num2, String str9, Integer num3, String str10, String str11, String str12, Boolean bool, String str13, Double d, String str14, int i, Object obj) {
            String str15;
            Double d2;
            Integer num4 = (i & 1) != 0 ? crewMember.id : num;
            String str16 = (i & 2) != 0 ? crewMember.name : str;
            String str17 = (i & 4) != 0 ? crewMember.job : str2;
            String str18 = (i & 8) != 0 ? crewMember.department : str3;
            String str19 = (i & 16) != 0 ? crewMember.profilePath : str4;
            String str20 = (i & 32) != 0 ? crewMember.biography : str5;
            String str21 = (i & 64) != 0 ? crewMember.birthday : str6;
            String str22 = (i & 128) != 0 ? crewMember.deathday : str7;
            String str23 = (i & 256) != 0 ? crewMember.placeOfBirth : str8;
            Integer num5 = (i & 512) != 0 ? crewMember.gender : num2;
            String str24 = (i & 1024) != 0 ? crewMember.knownForDepartment : str9;
            Integer num6 = (i & 2048) != 0 ? crewMember.tmdbId : num3;
            String str25 = (i & 4096) != 0 ? crewMember.createdAt : str10;
            String str26 = (i & 8192) != 0 ? crewMember.updatedAt : str11;
            Integer num7 = num4;
            String str27 = (i & 16384) != 0 ? crewMember.metadata : str12;
            Boolean bool2 = (i & 32768) != 0 ? crewMember.adult : bool;
            String str28 = (i & 65536) != 0 ? crewMember.originalName : str13;
            Double d3 = (i & 131072) != 0 ? crewMember.popularity : d;
            if ((i & 262144) != 0) {
                d2 = d3;
                str15 = crewMember.creditId;
            } else {
                str15 = str14;
                d2 = d3;
            }
            return crewMember.copy(num7, str16, str17, str18, str19, str20, str21, str22, str23, num5, str24, num6, str25, str26, str27, bool2, str28, d2, str15);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component10, reason: from getter */
        public final Integer getGender() {
            return this.gender;
        }

        @Nullable
        /* JADX INFO: renamed from: component11, reason: from getter */
        public final String getKnownForDepartment() {
            return this.knownForDepartment;
        }

        @Nullable
        /* JADX INFO: renamed from: component12, reason: from getter */
        public final Integer getTmdbId() {
            return this.tmdbId;
        }

        @Nullable
        /* JADX INFO: renamed from: component13, reason: from getter */
        public final String getCreatedAt() {
            return this.createdAt;
        }

        @Nullable
        /* JADX INFO: renamed from: component14, reason: from getter */
        public final String getUpdatedAt() {
            return this.updatedAt;
        }

        @Nullable
        /* JADX INFO: renamed from: component15, reason: from getter */
        public final String getMetadata() {
            return this.metadata;
        }

        @Nullable
        /* JADX INFO: renamed from: component16, reason: from getter */
        public final Boolean getAdult() {
            return this.adult;
        }

        @Nullable
        /* JADX INFO: renamed from: component17, reason: from getter */
        public final String getOriginalName() {
            return this.originalName;
        }

        @Nullable
        /* JADX INFO: renamed from: component18, reason: from getter */
        public final Double getPopularity() {
            return this.popularity;
        }

        @Nullable
        /* JADX INFO: renamed from: component19, reason: from getter */
        public final String getCreditId() {
            return this.creditId;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getJob() {
            return this.job;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getDepartment() {
            return this.department;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getProfilePath() {
            return this.profilePath;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getBiography() {
            return this.biography;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getBirthday() {
            return this.birthday;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getDeathday() {
            return this.deathday;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getPlaceOfBirth() {
            return this.placeOfBirth;
        }

        @NotNull
        public final CrewMember copy(@JsonProperty("id") @Nullable Integer id, @JsonProperty("name") @NotNull String name, @JsonProperty("job") @Nullable String job, @JsonProperty("department") @Nullable String department, @JsonProperty("profile_path") @Nullable String profilePath, @JsonProperty("biography") @Nullable String biography, @JsonProperty("birthday") @Nullable String birthday, @JsonProperty("deathday") @Nullable String deathday, @JsonProperty("place_of_birth") @Nullable String placeOfBirth, @JsonProperty("gender") @Nullable Integer gender, @JsonProperty("known_for_department") @Nullable String knownForDepartment, @JsonProperty("tmdb_id") @Nullable Integer tmdbId, @JsonProperty("created_at") @Nullable String createdAt, @JsonProperty("updated_at") @Nullable String updatedAt, @JsonProperty("metadata") @Nullable String metadata, @JsonProperty("adult") @Nullable Boolean adult, @JsonProperty("original_name") @Nullable String originalName, @JsonProperty("popularity") @Nullable Double popularity, @JsonProperty("credit_id") @Nullable String creditId) {
            return new CrewMember(id, name, job, department, profilePath, biography, birthday, deathday, placeOfBirth, gender, knownForDepartment, tmdbId, createdAt, updatedAt, metadata, adult, originalName, popularity, creditId);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CrewMember)) {
                return false;
            }
            CrewMember crewMember = (CrewMember) other;
            return Intrinsics.areEqual(this.id, crewMember.id) && Intrinsics.areEqual(this.name, crewMember.name) && Intrinsics.areEqual(this.job, crewMember.job) && Intrinsics.areEqual(this.department, crewMember.department) && Intrinsics.areEqual(this.profilePath, crewMember.profilePath) && Intrinsics.areEqual(this.biography, crewMember.biography) && Intrinsics.areEqual(this.birthday, crewMember.birthday) && Intrinsics.areEqual(this.deathday, crewMember.deathday) && Intrinsics.areEqual(this.placeOfBirth, crewMember.placeOfBirth) && Intrinsics.areEqual(this.gender, crewMember.gender) && Intrinsics.areEqual(this.knownForDepartment, crewMember.knownForDepartment) && Intrinsics.areEqual(this.tmdbId, crewMember.tmdbId) && Intrinsics.areEqual(this.createdAt, crewMember.createdAt) && Intrinsics.areEqual(this.updatedAt, crewMember.updatedAt) && Intrinsics.areEqual(this.metadata, crewMember.metadata) && Intrinsics.areEqual(this.adult, crewMember.adult) && Intrinsics.areEqual(this.originalName, crewMember.originalName) && Intrinsics.areEqual(this.popularity, crewMember.popularity) && Intrinsics.areEqual(this.creditId, crewMember.creditId);
        }

        public int hashCode() {
            return ((((((((((((((((((((((((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + this.name.hashCode()) * 31) + (this.job == null ? 0 : this.job.hashCode())) * 31) + (this.department == null ? 0 : this.department.hashCode())) * 31) + (this.profilePath == null ? 0 : this.profilePath.hashCode())) * 31) + (this.biography == null ? 0 : this.biography.hashCode())) * 31) + (this.birthday == null ? 0 : this.birthday.hashCode())) * 31) + (this.deathday == null ? 0 : this.deathday.hashCode())) * 31) + (this.placeOfBirth == null ? 0 : this.placeOfBirth.hashCode())) * 31) + (this.gender == null ? 0 : this.gender.hashCode())) * 31) + (this.knownForDepartment == null ? 0 : this.knownForDepartment.hashCode())) * 31) + (this.tmdbId == null ? 0 : this.tmdbId.hashCode())) * 31) + (this.createdAt == null ? 0 : this.createdAt.hashCode())) * 31) + (this.updatedAt == null ? 0 : this.updatedAt.hashCode())) * 31) + (this.metadata == null ? 0 : this.metadata.hashCode())) * 31) + (this.adult == null ? 0 : this.adult.hashCode())) * 31) + (this.originalName == null ? 0 : this.originalName.hashCode())) * 31) + (this.popularity == null ? 0 : this.popularity.hashCode())) * 31) + (this.creditId != null ? this.creditId.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("CrewMember(id=").append(this.id).append(", name=").append(this.name).append(", job=").append(this.job).append(", department=").append(this.department).append(", profilePath=").append(this.profilePath).append(", biography=").append(this.biography).append(", birthday=").append(this.birthday).append(", deathday=").append(this.deathday).append(", placeOfBirth=").append(this.placeOfBirth).append(", gender=").append(this.gender).append(", knownForDepartment=").append(this.knownForDepartment).append(", tmdbId=");
            sb.append(this.tmdbId).append(", createdAt=").append(this.createdAt).append(", updatedAt=").append(this.updatedAt).append(", metadata=").append(this.metadata).append(", adult=").append(this.adult).append(", originalName=").append(this.originalName).append(", popularity=").append(this.popularity).append(", creditId=").append(this.creditId).append(')');
            return sb.toString();
        }

        public CrewMember(@JsonProperty("id") @Nullable Integer id, @JsonProperty("name") @NotNull String name, @JsonProperty("job") @Nullable String job, @JsonProperty("department") @Nullable String department, @JsonProperty("profile_path") @Nullable String profilePath, @JsonProperty("biography") @Nullable String biography, @JsonProperty("birthday") @Nullable String birthday, @JsonProperty("deathday") @Nullable String deathday, @JsonProperty("place_of_birth") @Nullable String placeOfBirth, @JsonProperty("gender") @Nullable Integer gender, @JsonProperty("known_for_department") @Nullable String knownForDepartment, @JsonProperty("tmdb_id") @Nullable Integer tmdbId, @JsonProperty("created_at") @Nullable String createdAt, @JsonProperty("updated_at") @Nullable String updatedAt, @JsonProperty("metadata") @Nullable String metadata, @JsonProperty("adult") @Nullable Boolean adult, @JsonProperty("original_name") @Nullable String originalName, @JsonProperty("popularity") @Nullable Double popularity, @JsonProperty("credit_id") @Nullable String creditId) {
            this.id = id;
            this.name = name;
            this.job = job;
            this.department = department;
            this.profilePath = profilePath;
            this.biography = biography;
            this.birthday = birthday;
            this.deathday = deathday;
            this.placeOfBirth = placeOfBirth;
            this.gender = gender;
            this.knownForDepartment = knownForDepartment;
            this.tmdbId = tmdbId;
            this.createdAt = createdAt;
            this.updatedAt = updatedAt;
            this.metadata = metadata;
            this.adult = adult;
            this.originalName = originalName;
            this.popularity = popularity;
            this.creditId = creditId;
        }

        public /* synthetic */ CrewMember(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Integer num2, String str9, Integer num3, String str10, String str11, String str12, Boolean bool, String str13, Double d, String str14, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, str, str2, str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : str8, (i & 512) != 0 ? null : num2, (i & 1024) != 0 ? null : str9, (i & 2048) != 0 ? null : num3, (i & 4096) != 0 ? null : str10, (i & 8192) != 0 ? null : str11, (i & 16384) != 0 ? null : str12, (32768 & i) != 0 ? null : bool, (65536 & i) != 0 ? null : str13, (131072 & i) != 0 ? null : d, (i & 262144) != 0 ? null : str14);
        }

        @Nullable
        public final Integer getId() {
            return this.id;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @Nullable
        public final String getJob() {
            return this.job;
        }

        @Nullable
        public final String getDepartment() {
            return this.department;
        }

        @Nullable
        public final String getProfilePath() {
            return this.profilePath;
        }

        @Nullable
        public final String getBiography() {
            return this.biography;
        }

        @Nullable
        public final String getBirthday() {
            return this.birthday;
        }

        @Nullable
        public final String getDeathday() {
            return this.deathday;
        }

        @Nullable
        public final String getPlaceOfBirth() {
            return this.placeOfBirth;
        }

        @Nullable
        public final Integer getGender() {
            return this.gender;
        }

        @Nullable
        public final String getKnownForDepartment() {
            return this.knownForDepartment;
        }

        @Nullable
        public final Integer getTmdbId() {
            return this.tmdbId;
        }

        @Nullable
        public final String getCreatedAt() {
            return this.createdAt;
        }

        @Nullable
        public final String getUpdatedAt() {
            return this.updatedAt;
        }

        @Nullable
        public final String getMetadata() {
            return this.metadata;
        }

        @Nullable
        public final Boolean getAdult() {
            return this.adult;
        }

        @Nullable
        public final String getOriginalName() {
            return this.originalName;
        }

        @Nullable
        public final Double getPopularity() {
            return this.popularity;
        }

        @Nullable
        public final String getCreditId() {
            return this.creditId;
        }
    }

    /* JADX INFO: compiled from: DoFlixProvider.kt */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0001\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u000fJ:\u0010\u0014\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0003\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0015J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\bHÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/cncverse/DoFlixProvider$Credits;", "", "cast", "", "Lcom/cncverse/DoFlixProvider$CastMember;", "crew", "Lcom/cncverse/DoFlixProvider$CrewMember;", "id", "", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;)V", "getCast", "()Ljava/util/List;", "getCrew", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;)Lcom/cncverse/DoFlixProvider$Credits;", "equals", "", "other", "hashCode", "toString", "", "DoFlixProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Credits {

        @JsonProperty("cast")
        @NotNull
        private final List<CastMember> cast;

        @JsonProperty("crew")
        @NotNull
        private final List<CrewMember> crew;

        @JsonProperty("id")
        @Nullable
        private final Integer id;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Credits copy$default(Credits credits, List list, List list2, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                list = credits.cast;
            }
            if ((i & 2) != 0) {
                list2 = credits.crew;
            }
            if ((i & 4) != 0) {
                num = credits.id;
            }
            return credits.copy(list, list2, num);
        }

        @NotNull
        public final List<CastMember> component1() {
            return this.cast;
        }

        @NotNull
        public final List<CrewMember> component2() {
            return this.crew;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getId() {
            return this.id;
        }

        @NotNull
        public final Credits copy(@JsonProperty("cast") @NotNull List<CastMember> cast, @JsonProperty("crew") @NotNull List<CrewMember> crew, @JsonProperty("id") @Nullable Integer id) {
            return new Credits(cast, crew, id);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Credits)) {
                return false;
            }
            Credits credits = (Credits) other;
            return Intrinsics.areEqual(this.cast, credits.cast) && Intrinsics.areEqual(this.crew, credits.crew) && Intrinsics.areEqual(this.id, credits.id);
        }

        public int hashCode() {
            return (((this.cast.hashCode() * 31) + this.crew.hashCode()) * 31) + (this.id == null ? 0 : this.id.hashCode());
        }

        @NotNull
        public String toString() {
            return "Credits(cast=" + this.cast + ", crew=" + this.crew + ", id=" + this.id + ')';
        }

        public Credits(@JsonProperty("cast") @NotNull List<CastMember> list, @JsonProperty("crew") @NotNull List<CrewMember> list2, @JsonProperty("id") @Nullable Integer id) {
            this.cast = list;
            this.crew = list2;
            this.id = id;
        }

        public /* synthetic */ Credits(List list, List list2, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, list2, (i & 4) != 0 ? null : num);
        }

        @NotNull
        public final List<CastMember> getCast() {
            return this.cast;
        }

        @NotNull
        public final List<CrewMember> getCrew() {
            return this.crew;
        }

        @Nullable
        public final Integer getId() {
            return this.id;
        }
    }

    /* JADX INFO: compiled from: DoFlixProvider.kt */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJB\u0010\u0016\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0014\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/cncverse/DoFlixProvider$SimilarResults;", "", "results", "", "Lcom/cncverse/DoFlixProvider$MovieResult;", "page", "", "totalPages", "totalResults", "<init>", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getResults", "()Ljava/util/List;", "getPage", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTotalPages", "getTotalResults", "component1", "component2", "component3", "component4", "copy", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/cncverse/DoFlixProvider$SimilarResults;", "equals", "", "other", "hashCode", "toString", "", "DoFlixProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class SimilarResults {

        @JsonProperty("page")
        @Nullable
        private final Integer page;

        @JsonProperty("results")
        @NotNull
        private final List<MovieResult> results;

        @JsonProperty("total_pages")
        @Nullable
        private final Integer totalPages;

        @JsonProperty("total_results")
        @Nullable
        private final Integer totalResults;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SimilarResults copy$default(SimilarResults similarResults, List list, Integer num, Integer num2, Integer num3, int i, Object obj) {
            if ((i & 1) != 0) {
                list = similarResults.results;
            }
            if ((i & 2) != 0) {
                num = similarResults.page;
            }
            if ((i & 4) != 0) {
                num2 = similarResults.totalPages;
            }
            if ((i & 8) != 0) {
                num3 = similarResults.totalResults;
            }
            return similarResults.copy(list, num, num2, num3);
        }

        @NotNull
        public final List<MovieResult> component1() {
            return this.results;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getPage() {
            return this.page;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getTotalPages() {
            return this.totalPages;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Integer getTotalResults() {
            return this.totalResults;
        }

        @NotNull
        public final SimilarResults copy(@JsonProperty("results") @NotNull List<MovieResult> results, @JsonProperty("page") @Nullable Integer page, @JsonProperty("total_pages") @Nullable Integer totalPages, @JsonProperty("total_results") @Nullable Integer totalResults) {
            return new SimilarResults(results, page, totalPages, totalResults);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SimilarResults)) {
                return false;
            }
            SimilarResults similarResults = (SimilarResults) other;
            return Intrinsics.areEqual(this.results, similarResults.results) && Intrinsics.areEqual(this.page, similarResults.page) && Intrinsics.areEqual(this.totalPages, similarResults.totalPages) && Intrinsics.areEqual(this.totalResults, similarResults.totalResults);
        }

        public int hashCode() {
            return (((((this.results.hashCode() * 31) + (this.page == null ? 0 : this.page.hashCode())) * 31) + (this.totalPages == null ? 0 : this.totalPages.hashCode())) * 31) + (this.totalResults != null ? this.totalResults.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "SimilarResults(results=" + this.results + ", page=" + this.page + ", totalPages=" + this.totalPages + ", totalResults=" + this.totalResults + ')';
        }

        public SimilarResults(@JsonProperty("results") @NotNull List<MovieResult> list, @JsonProperty("page") @Nullable Integer page, @JsonProperty("total_pages") @Nullable Integer totalPages, @JsonProperty("total_results") @Nullable Integer totalResults) {
            this.results = list;
            this.page = page;
            this.totalPages = totalPages;
            this.totalResults = totalResults;
        }

        public /* synthetic */ SimilarResults(List list, Integer num, Integer num2, Integer num3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : num3);
        }

        @NotNull
        public final List<MovieResult> getResults() {
            return this.results;
        }

        @Nullable
        public final Integer getPage() {
            return this.page;
        }

        @Nullable
        public final Integer getTotalPages() {
            return this.totalPages;
        }

        @Nullable
        public final Integer getTotalResults() {
            return this.totalResults;
        }
    }

    /* JADX INFO: compiled from: DoFlixProvider.kt */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0001\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0001\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\u000e\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0003\u0010\u0007\u001a\u00020\u00032\b\b\u0003\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/cncverse/DoFlixProvider$MultiSearchResponse;", "", "page", "", "results", "", "Lcom/cncverse/DoFlixProvider$MovieResult;", "totalPages", "totalResults", "<init>", "(ILjava/util/List;II)V", "getPage", "()I", "getResults", "()Ljava/util/List;", "getTotalPages", "getTotalResults", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "DoFlixProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class MultiSearchResponse {

        @JsonProperty("page")
        private final int page;

        @JsonProperty("results")
        @NotNull
        private final List<MovieResult> results;

        @JsonProperty("total_pages")
        private final int totalPages;

        @JsonProperty("total_results")
        private final int totalResults;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MultiSearchResponse copy$default(MultiSearchResponse multiSearchResponse, int i, List list, int i2, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = multiSearchResponse.page;
            }
            if ((i4 & 2) != 0) {
                list = multiSearchResponse.results;
            }
            if ((i4 & 4) != 0) {
                i2 = multiSearchResponse.totalPages;
            }
            if ((i4 & 8) != 0) {
                i3 = multiSearchResponse.totalResults;
            }
            return multiSearchResponse.copy(i, list, i2, i3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getPage() {
            return this.page;
        }

        @NotNull
        public final List<MovieResult> component2() {
            return this.results;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getTotalPages() {
            return this.totalPages;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getTotalResults() {
            return this.totalResults;
        }

        @NotNull
        public final MultiSearchResponse copy(@JsonProperty("page") int page, @JsonProperty("results") @NotNull List<MovieResult> results, @JsonProperty("total_pages") int totalPages, @JsonProperty("total_results") int totalResults) {
            return new MultiSearchResponse(page, results, totalPages, totalResults);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MultiSearchResponse)) {
                return false;
            }
            MultiSearchResponse multiSearchResponse = (MultiSearchResponse) other;
            return this.page == multiSearchResponse.page && Intrinsics.areEqual(this.results, multiSearchResponse.results) && this.totalPages == multiSearchResponse.totalPages && this.totalResults == multiSearchResponse.totalResults;
        }

        public int hashCode() {
            return (((((this.page * 31) + this.results.hashCode()) * 31) + this.totalPages) * 31) + this.totalResults;
        }

        @NotNull
        public String toString() {
            return "MultiSearchResponse(page=" + this.page + ", results=" + this.results + ", totalPages=" + this.totalPages + ", totalResults=" + this.totalResults + ')';
        }

        public MultiSearchResponse(@JsonProperty("page") int page, @JsonProperty("results") @NotNull List<MovieResult> list, @JsonProperty("total_pages") int totalPages, @JsonProperty("total_results") int totalResults) {
            this.page = page;
            this.results = list;
            this.totalPages = totalPages;
            this.totalResults = totalResults;
        }

        public final int getPage() {
            return this.page;
        }

        @NotNull
        public final List<MovieResult> getResults() {
            return this.results;
        }

        public final int getTotalPages() {
            return this.totalPages;
        }

        public final int getTotalResults() {
            return this.totalResults;
        }
    }

    /* JADX INFO: compiled from: DoFlixProvider.kt */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\bF\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B±\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0001\u0010\b\u001a\u00020\u0003\u0012\b\b\u0001\u0010\t\u001a\u00020\u0005\u0012\b\b\u0001\u0010\n\u001a\u00020\u0005\u0012\u000e\b\u0001\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0001\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0003\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f\u0012\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\u0010\b\u0003\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\f\u0012\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u001e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u001f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010 \u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0003\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\"\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b#\u0010$J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\t\u0010H\u001a\u00020\u0005HÆ\u0003J\t\u0010I\u001a\u00020\u0005HÆ\u0003J\t\u0010J\u001a\u00020\u0005HÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\u0005HÆ\u0003J\t\u0010M\u001a\u00020\u0005HÆ\u0003J\u000f\u0010N\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010P\u001a\u00020\u0010HÆ\u0003J\t\u0010Q\u001a\u00020\u0012HÆ\u0003J\u0010\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00106J\u000b\u0010S\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010U\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fHÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010X\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0002\u0010>J\u0011\u0010Y\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\fHÆ\u0003J\u0010\u0010Z\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00106J\u000b\u0010[\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010]\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0002\u0010>J\u0010\u0010^\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00106J\u0010\u0010_\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00106J¸\u0002\u0010`\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00052\b\b\u0003\u0010\u0007\u001a\u00020\u00052\b\b\u0003\u0010\b\u001a\u00020\u00032\b\b\u0003\u0010\t\u001a\u00020\u00052\b\b\u0003\u0010\n\u001a\u00020\u00052\u000e\b\u0003\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\b\u0003\u0010\u000f\u001a\u00020\u00102\b\b\u0003\u0010\u0011\u001a\u00020\u00122\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0010\b\u0003\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f2\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0010\b\u0003\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\f2\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u001e\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u001f\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010 \u001a\u0004\u0018\u00010\u001a2\n\b\u0003\u0010!\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010aJ\u0014\u0010b\u001a\u00020c2\b\u0010d\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010e\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010f\u001a\u00020\u0005HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010(R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010(R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010&R\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010(R\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010(R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010(R\u0016\u0010\u000f\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0016\u0010\u0011\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00107\u001a\u0004\b5\u00106R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010(R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010(R\u001e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010/R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010(R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010(R\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010?\u001a\u0004\b=\u0010>R\u001e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010/R\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00107\u001a\u0004\bA\u00106R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010(R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010(R\u001a\u0010 \u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010?\u001a\u0004\bD\u0010>R\u001a\u0010!\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00107\u001a\u0004\bE\u00106R\u001a\u0010\"\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00107\u001a\u0004\bF\u00106¨\u0006g"}, d2 = {"Lcom/cncverse/DoFlixProvider$MovieDetails;", "", "id", "", "title", "", "overview", "releaseDate", "runtime", "posterPath", "backdropPath", "genres", "", "Lcom/cncverse/DoFlixProvider$TMDBGenre;", "customPosterTag", "credits", "Lcom/cncverse/DoFlixProvider$Credits;", "similar", "Lcom/cncverse/DoFlixProvider$SimilarResults;", "budget", "homepage", "imdbId", "originCountry", "originalLanguage", "originalTitle", "popularity", "", "productionCountries", "Lcom/cncverse/DoFlixProvider$ProductionCountry;", "revenue", "status", "tagline", "voteAverage", "voteCount", "publish", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/cncverse/DoFlixProvider$Credits;Lcom/cncverse/DoFlixProvider$SimilarResults;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "getOverview", "getReleaseDate", "getRuntime", "getPosterPath", "getBackdropPath", "getGenres", "()Ljava/util/List;", "getCustomPosterTag", "getCredits", "()Lcom/cncverse/DoFlixProvider$Credits;", "getSimilar", "()Lcom/cncverse/DoFlixProvider$SimilarResults;", "getBudget", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHomepage", "getImdbId", "getOriginCountry", "getOriginalLanguage", "getOriginalTitle", "getPopularity", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getProductionCountries", "getRevenue", "getStatus", "getTagline", "getVoteAverage", "getVoteCount", "getPublish", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/cncverse/DoFlixProvider$Credits;Lcom/cncverse/DoFlixProvider$SimilarResults;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/cncverse/DoFlixProvider$MovieDetails;", "equals", "", "other", "hashCode", "toString", "DoFlixProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class MovieDetails {

        @JsonProperty("backdrop_path")
        @NotNull
        private final String backdropPath;

        @JsonProperty("budget")
        @Nullable
        private final Integer budget;

        @JsonProperty("credits")
        @NotNull
        private final Credits credits;

        @JsonProperty("custom_poster_tag")
        @Nullable
        private final String customPosterTag;

        @JsonProperty("genres")
        @NotNull
        private final List<TMDBGenre> genres;

        @JsonProperty("homepage")
        @Nullable
        private final String homepage;

        @JsonProperty("id")
        private final int id;

        @JsonProperty("imdb_id")
        @Nullable
        private final String imdbId;

        @JsonProperty("origin_country")
        @Nullable
        private final List<String> originCountry;

        @JsonProperty("original_language")
        @Nullable
        private final String originalLanguage;

        @JsonProperty("original_title")
        @Nullable
        private final String originalTitle;

        @JsonProperty("overview")
        @NotNull
        private final String overview;

        @JsonProperty("popularity")
        @Nullable
        private final Double popularity;

        @JsonProperty("poster_path")
        @NotNull
        private final String posterPath;

        @JsonProperty("production_countries")
        @Nullable
        private final List<ProductionCountry> productionCountries;

        @JsonProperty("publish")
        @Nullable
        private final Integer publish;

        @JsonProperty("release_date")
        @NotNull
        private final String releaseDate;

        @JsonProperty("revenue")
        @Nullable
        private final Integer revenue;

        @JsonProperty("runtime")
        private final int runtime;

        @JsonProperty("similar")
        @NotNull
        private final SimilarResults similar;

        @JsonProperty("status")
        @Nullable
        private final String status;

        @JsonProperty("tagline")
        @Nullable
        private final String tagline;

        @JsonProperty("title")
        @NotNull
        private final String title;

        @JsonProperty("vote_average")
        @Nullable
        private final Double voteAverage;

        @JsonProperty("vote_count")
        @Nullable
        private final Integer voteCount;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MovieDetails copy$default(MovieDetails movieDetails, int i, String str, String str2, String str3, int i2, String str4, String str5, List list, String str6, Credits credits, SimilarResults similarResults, Integer num, String str7, String str8, List list2, String str9, String str10, Double d, List list3, Integer num2, String str11, String str12, Double d2, Integer num3, Integer num4, int i3, Object obj) {
            Integer num5;
            Integer num6;
            int i4 = (i3 & 1) != 0 ? movieDetails.id : i;
            String str13 = (i3 & 2) != 0 ? movieDetails.title : str;
            String str14 = (i3 & 4) != 0 ? movieDetails.overview : str2;
            String str15 = (i3 & 8) != 0 ? movieDetails.releaseDate : str3;
            int i5 = (i3 & 16) != 0 ? movieDetails.runtime : i2;
            String str16 = (i3 & 32) != 0 ? movieDetails.posterPath : str4;
            String str17 = (i3 & 64) != 0 ? movieDetails.backdropPath : str5;
            List list4 = (i3 & 128) != 0 ? movieDetails.genres : list;
            String str18 = (i3 & 256) != 0 ? movieDetails.customPosterTag : str6;
            Credits credits2 = (i3 & 512) != 0 ? movieDetails.credits : credits;
            SimilarResults similarResults2 = (i3 & 1024) != 0 ? movieDetails.similar : similarResults;
            Integer num7 = (i3 & 2048) != 0 ? movieDetails.budget : num;
            String str19 = (i3 & 4096) != 0 ? movieDetails.homepage : str7;
            String str20 = (i3 & 8192) != 0 ? movieDetails.imdbId : str8;
            int i6 = i4;
            List list5 = (i3 & 16384) != 0 ? movieDetails.originCountry : list2;
            String str21 = (i3 & 32768) != 0 ? movieDetails.originalLanguage : str9;
            String str22 = (i3 & 65536) != 0 ? movieDetails.originalTitle : str10;
            Double d3 = (i3 & 131072) != 0 ? movieDetails.popularity : d;
            List list6 = (i3 & 262144) != 0 ? movieDetails.productionCountries : list3;
            Integer num8 = (i3 & 524288) != 0 ? movieDetails.revenue : num2;
            String str23 = (i3 & 1048576) != 0 ? movieDetails.status : str11;
            String str24 = (i3 & 2097152) != 0 ? movieDetails.tagline : str12;
            Double d4 = (i3 & 4194304) != 0 ? movieDetails.voteAverage : d2;
            Integer num9 = (i3 & 8388608) != 0 ? movieDetails.voteCount : num3;
            if ((i3 & 16777216) != 0) {
                num6 = num9;
                num5 = movieDetails.publish;
            } else {
                num5 = num4;
                num6 = num9;
            }
            return movieDetails.copy(i6, str13, str14, str15, i5, str16, str17, list4, str18, credits2, similarResults2, num7, str19, str20, list5, str21, str22, d3, list6, num8, str23, str24, d4, num6, num5);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getId() {
            return this.id;
        }

        @NotNull
        /* JADX INFO: renamed from: component10, reason: from getter */
        public final Credits getCredits() {
            return this.credits;
        }

        @NotNull
        /* JADX INFO: renamed from: component11, reason: from getter */
        public final SimilarResults getSimilar() {
            return this.similar;
        }

        @Nullable
        /* JADX INFO: renamed from: component12, reason: from getter */
        public final Integer getBudget() {
            return this.budget;
        }

        @Nullable
        /* JADX INFO: renamed from: component13, reason: from getter */
        public final String getHomepage() {
            return this.homepage;
        }

        @Nullable
        /* JADX INFO: renamed from: component14, reason: from getter */
        public final String getImdbId() {
            return this.imdbId;
        }

        @Nullable
        public final List<String> component15() {
            return this.originCountry;
        }

        @Nullable
        /* JADX INFO: renamed from: component16, reason: from getter */
        public final String getOriginalLanguage() {
            return this.originalLanguage;
        }

        @Nullable
        /* JADX INFO: renamed from: component17, reason: from getter */
        public final String getOriginalTitle() {
            return this.originalTitle;
        }

        @Nullable
        /* JADX INFO: renamed from: component18, reason: from getter */
        public final Double getPopularity() {
            return this.popularity;
        }

        @Nullable
        public final List<ProductionCountry> component19() {
            return this.productionCountries;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component20, reason: from getter */
        public final Integer getRevenue() {
            return this.revenue;
        }

        @Nullable
        /* JADX INFO: renamed from: component21, reason: from getter */
        public final String getStatus() {
            return this.status;
        }

        @Nullable
        /* JADX INFO: renamed from: component22, reason: from getter */
        public final String getTagline() {
            return this.tagline;
        }

        @Nullable
        /* JADX INFO: renamed from: component23, reason: from getter */
        public final Double getVoteAverage() {
            return this.voteAverage;
        }

        @Nullable
        /* JADX INFO: renamed from: component24, reason: from getter */
        public final Integer getVoteCount() {
            return this.voteCount;
        }

        @Nullable
        /* JADX INFO: renamed from: component25, reason: from getter */
        public final Integer getPublish() {
            return this.publish;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getOverview() {
            return this.overview;
        }

        @NotNull
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getReleaseDate() {
            return this.releaseDate;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final int getRuntime() {
            return this.runtime;
        }

        @NotNull
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getPosterPath() {
            return this.posterPath;
        }

        @NotNull
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getBackdropPath() {
            return this.backdropPath;
        }

        @NotNull
        public final List<TMDBGenre> component8() {
            return this.genres;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getCustomPosterTag() {
            return this.customPosterTag;
        }

        @NotNull
        public final MovieDetails copy(@JsonProperty("id") int id, @JsonProperty("title") @NotNull String title, @JsonProperty("overview") @NotNull String overview, @JsonProperty("release_date") @NotNull String releaseDate, @JsonProperty("runtime") int runtime, @JsonProperty("poster_path") @NotNull String posterPath, @JsonProperty("backdrop_path") @NotNull String backdropPath, @JsonProperty("genres") @NotNull List<TMDBGenre> genres, @JsonProperty("custom_poster_tag") @Nullable String customPosterTag, @JsonProperty("credits") @NotNull Credits credits, @JsonProperty("similar") @NotNull SimilarResults similar, @JsonProperty("budget") @Nullable Integer budget, @JsonProperty("homepage") @Nullable String homepage, @JsonProperty("imdb_id") @Nullable String imdbId, @JsonProperty("origin_country") @Nullable List<String> originCountry, @JsonProperty("original_language") @Nullable String originalLanguage, @JsonProperty("original_title") @Nullable String originalTitle, @JsonProperty("popularity") @Nullable Double popularity, @JsonProperty("production_countries") @Nullable List<ProductionCountry> productionCountries, @JsonProperty("revenue") @Nullable Integer revenue, @JsonProperty("status") @Nullable String status, @JsonProperty("tagline") @Nullable String tagline, @JsonProperty("vote_average") @Nullable Double voteAverage, @JsonProperty("vote_count") @Nullable Integer voteCount, @JsonProperty("publish") @Nullable Integer publish) {
            return new MovieDetails(id, title, overview, releaseDate, runtime, posterPath, backdropPath, genres, customPosterTag, credits, similar, budget, homepage, imdbId, originCountry, originalLanguage, originalTitle, popularity, productionCountries, revenue, status, tagline, voteAverage, voteCount, publish);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MovieDetails)) {
                return false;
            }
            MovieDetails movieDetails = (MovieDetails) other;
            return this.id == movieDetails.id && Intrinsics.areEqual(this.title, movieDetails.title) && Intrinsics.areEqual(this.overview, movieDetails.overview) && Intrinsics.areEqual(this.releaseDate, movieDetails.releaseDate) && this.runtime == movieDetails.runtime && Intrinsics.areEqual(this.posterPath, movieDetails.posterPath) && Intrinsics.areEqual(this.backdropPath, movieDetails.backdropPath) && Intrinsics.areEqual(this.genres, movieDetails.genres) && Intrinsics.areEqual(this.customPosterTag, movieDetails.customPosterTag) && Intrinsics.areEqual(this.credits, movieDetails.credits) && Intrinsics.areEqual(this.similar, movieDetails.similar) && Intrinsics.areEqual(this.budget, movieDetails.budget) && Intrinsics.areEqual(this.homepage, movieDetails.homepage) && Intrinsics.areEqual(this.imdbId, movieDetails.imdbId) && Intrinsics.areEqual(this.originCountry, movieDetails.originCountry) && Intrinsics.areEqual(this.originalLanguage, movieDetails.originalLanguage) && Intrinsics.areEqual(this.originalTitle, movieDetails.originalTitle) && Intrinsics.areEqual(this.popularity, movieDetails.popularity) && Intrinsics.areEqual(this.productionCountries, movieDetails.productionCountries) && Intrinsics.areEqual(this.revenue, movieDetails.revenue) && Intrinsics.areEqual(this.status, movieDetails.status) && Intrinsics.areEqual(this.tagline, movieDetails.tagline) && Intrinsics.areEqual(this.voteAverage, movieDetails.voteAverage) && Intrinsics.areEqual(this.voteCount, movieDetails.voteCount) && Intrinsics.areEqual(this.publish, movieDetails.publish);
        }

        public int hashCode() {
            return (((((((((((((((((((((((((((((((((((((((((((((((this.id * 31) + this.title.hashCode()) * 31) + this.overview.hashCode()) * 31) + this.releaseDate.hashCode()) * 31) + this.runtime) * 31) + this.posterPath.hashCode()) * 31) + this.backdropPath.hashCode()) * 31) + this.genres.hashCode()) * 31) + (this.customPosterTag == null ? 0 : this.customPosterTag.hashCode())) * 31) + this.credits.hashCode()) * 31) + this.similar.hashCode()) * 31) + (this.budget == null ? 0 : this.budget.hashCode())) * 31) + (this.homepage == null ? 0 : this.homepage.hashCode())) * 31) + (this.imdbId == null ? 0 : this.imdbId.hashCode())) * 31) + (this.originCountry == null ? 0 : this.originCountry.hashCode())) * 31) + (this.originalLanguage == null ? 0 : this.originalLanguage.hashCode())) * 31) + (this.originalTitle == null ? 0 : this.originalTitle.hashCode())) * 31) + (this.popularity == null ? 0 : this.popularity.hashCode())) * 31) + (this.productionCountries == null ? 0 : this.productionCountries.hashCode())) * 31) + (this.revenue == null ? 0 : this.revenue.hashCode())) * 31) + (this.status == null ? 0 : this.status.hashCode())) * 31) + (this.tagline == null ? 0 : this.tagline.hashCode())) * 31) + (this.voteAverage == null ? 0 : this.voteAverage.hashCode())) * 31) + (this.voteCount == null ? 0 : this.voteCount.hashCode())) * 31) + (this.publish != null ? this.publish.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("MovieDetails(id=").append(this.id).append(", title=").append(this.title).append(", overview=").append(this.overview).append(", releaseDate=").append(this.releaseDate).append(", runtime=").append(this.runtime).append(", posterPath=").append(this.posterPath).append(", backdropPath=").append(this.backdropPath).append(", genres=").append(this.genres).append(", customPosterTag=").append(this.customPosterTag).append(", credits=").append(this.credits).append(", similar=").append(this.similar).append(", budget=");
            sb.append(this.budget).append(", homepage=").append(this.homepage).append(", imdbId=").append(this.imdbId).append(", originCountry=").append(this.originCountry).append(", originalLanguage=").append(this.originalLanguage).append(", originalTitle=").append(this.originalTitle).append(", popularity=").append(this.popularity).append(", productionCountries=").append(this.productionCountries).append(", revenue=").append(this.revenue).append(", status=").append(this.status).append(", tagline=").append(this.tagline).append(", voteAverage=").append(this.voteAverage);
            sb.append(", voteCount=").append(this.voteCount).append(", publish=").append(this.publish).append(')');
            return sb.toString();
        }

        public MovieDetails(@JsonProperty("id") int id, @JsonProperty("title") @NotNull String title, @JsonProperty("overview") @NotNull String overview, @JsonProperty("release_date") @NotNull String releaseDate, @JsonProperty("runtime") int runtime, @JsonProperty("poster_path") @NotNull String posterPath, @JsonProperty("backdrop_path") @NotNull String backdropPath, @JsonProperty("genres") @NotNull List<TMDBGenre> list, @JsonProperty("custom_poster_tag") @Nullable String customPosterTag, @JsonProperty("credits") @NotNull Credits credits, @JsonProperty("similar") @NotNull SimilarResults similar, @JsonProperty("budget") @Nullable Integer budget, @JsonProperty("homepage") @Nullable String homepage, @JsonProperty("imdb_id") @Nullable String imdbId, @JsonProperty("origin_country") @Nullable List<String> list2, @JsonProperty("original_language") @Nullable String originalLanguage, @JsonProperty("original_title") @Nullable String originalTitle, @JsonProperty("popularity") @Nullable Double popularity, @JsonProperty("production_countries") @Nullable List<ProductionCountry> list3, @JsonProperty("revenue") @Nullable Integer revenue, @JsonProperty("status") @Nullable String status, @JsonProperty("tagline") @Nullable String tagline, @JsonProperty("vote_average") @Nullable Double voteAverage, @JsonProperty("vote_count") @Nullable Integer voteCount, @JsonProperty("publish") @Nullable Integer publish) {
            this.id = id;
            this.title = title;
            this.overview = overview;
            this.releaseDate = releaseDate;
            this.runtime = runtime;
            this.posterPath = posterPath;
            this.backdropPath = backdropPath;
            this.genres = list;
            this.customPosterTag = customPosterTag;
            this.credits = credits;
            this.similar = similar;
            this.budget = budget;
            this.homepage = homepage;
            this.imdbId = imdbId;
            this.originCountry = list2;
            this.originalLanguage = originalLanguage;
            this.originalTitle = originalTitle;
            this.popularity = popularity;
            this.productionCountries = list3;
            this.revenue = revenue;
            this.status = status;
            this.tagline = tagline;
            this.voteAverage = voteAverage;
            this.voteCount = voteCount;
            this.publish = publish;
        }

        public /* synthetic */ MovieDetails(int i, String str, String str2, String str3, int i2, String str4, String str5, List list, String str6, Credits credits, SimilarResults similarResults, Integer num, String str7, String str8, List list2, String str9, String str10, Double d, List list3, Integer num2, String str11, String str12, Double d2, Integer num3, Integer num4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, str, str2, str3, i2, str4, str5, list, str6, credits, similarResults, (i3 & 2048) != 0 ? null : num, (i3 & 4096) != 0 ? null : str7, (i3 & 8192) != 0 ? null : str8, (i3 & 16384) != 0 ? null : list2, (32768 & i3) != 0 ? null : str9, (65536 & i3) != 0 ? null : str10, (131072 & i3) != 0 ? null : d, (262144 & i3) != 0 ? null : list3, (524288 & i3) != 0 ? null : num2, (1048576 & i3) != 0 ? null : str11, (2097152 & i3) != 0 ? null : str12, (4194304 & i3) != 0 ? null : d2, (8388608 & i3) != 0 ? null : num3, (i3 & 16777216) != 0 ? null : num4);
        }

        public final int getId() {
            return this.id;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        public final String getOverview() {
            return this.overview;
        }

        @NotNull
        public final String getReleaseDate() {
            return this.releaseDate;
        }

        public final int getRuntime() {
            return this.runtime;
        }

        @NotNull
        public final String getPosterPath() {
            return this.posterPath;
        }

        @NotNull
        public final String getBackdropPath() {
            return this.backdropPath;
        }

        @NotNull
        public final List<TMDBGenre> getGenres() {
            return this.genres;
        }

        @Nullable
        public final String getCustomPosterTag() {
            return this.customPosterTag;
        }

        @NotNull
        public final Credits getCredits() {
            return this.credits;
        }

        @NotNull
        public final SimilarResults getSimilar() {
            return this.similar;
        }

        @Nullable
        public final Integer getBudget() {
            return this.budget;
        }

        @Nullable
        public final String getHomepage() {
            return this.homepage;
        }

        @Nullable
        public final String getImdbId() {
            return this.imdbId;
        }

        @Nullable
        public final List<String> getOriginCountry() {
            return this.originCountry;
        }

        @Nullable
        public final String getOriginalLanguage() {
            return this.originalLanguage;
        }

        @Nullable
        public final String getOriginalTitle() {
            return this.originalTitle;
        }

        @Nullable
        public final Double getPopularity() {
            return this.popularity;
        }

        @Nullable
        public final List<ProductionCountry> getProductionCountries() {
            return this.productionCountries;
        }

        @Nullable
        public final Integer getRevenue() {
            return this.revenue;
        }

        @Nullable
        public final String getStatus() {
            return this.status;
        }

        @Nullable
        public final String getTagline() {
            return this.tagline;
        }

        @Nullable
        public final Double getVoteAverage() {
            return this.voteAverage;
        }

        @Nullable
        public final Integer getVoteCount() {
            return this.voteCount;
        }

        @Nullable
        public final Integer getPublish() {
            return this.publish;
        }
    }

    /* JADX INFO: compiled from: DoFlixProvider.kt */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001bJh\u0010%\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010&J\u0014\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010*\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010+\u001a\u00020\u0005HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001b¨\u0006,"}, d2 = {"Lcom/cncverse/DoFlixProvider$SeasonInfo;", "", "seasonNumber", "", "name", "", "episodeCount", "posterPath", "airDate", "id", "overview", "voteAverage", "", "<init>", "(ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Double;)V", "getSeasonNumber", "()I", "getName", "()Ljava/lang/String;", "getEpisodeCount", "getPosterPath", "getAirDate", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getOverview", "getVoteAverage", "()Ljava/lang/Double;", "Ljava/lang/Double;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Double;)Lcom/cncverse/DoFlixProvider$SeasonInfo;", "equals", "", "other", "hashCode", "toString", "DoFlixProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class SeasonInfo {

        @JsonProperty("air_date")
        @Nullable
        private final String airDate;

        @JsonProperty("episode_count")
        private final int episodeCount;

        @JsonProperty("id")
        @Nullable
        private final Integer id;

        @JsonProperty("name")
        @NotNull
        private final String name;

        @JsonProperty("overview")
        @Nullable
        private final String overview;

        @JsonProperty("poster_path")
        @Nullable
        private final String posterPath;

        @JsonProperty("season_number")
        private final int seasonNumber;

        @JsonProperty("vote_average")
        @Nullable
        private final Double voteAverage;

        public static /* synthetic */ SeasonInfo copy$default(SeasonInfo seasonInfo, int i, String str, int i2, String str2, String str3, Integer num, String str4, Double d, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = seasonInfo.seasonNumber;
            }
            if ((i3 & 2) != 0) {
                str = seasonInfo.name;
            }
            if ((i3 & 4) != 0) {
                i2 = seasonInfo.episodeCount;
            }
            if ((i3 & 8) != 0) {
                str2 = seasonInfo.posterPath;
            }
            if ((i3 & 16) != 0) {
                str3 = seasonInfo.airDate;
            }
            if ((i3 & 32) != 0) {
                num = seasonInfo.id;
            }
            if ((i3 & 64) != 0) {
                str4 = seasonInfo.overview;
            }
            if ((i3 & 128) != 0) {
                d = seasonInfo.voteAverage;
            }
            String str5 = str4;
            Double d2 = d;
            String str6 = str3;
            Integer num2 = num;
            return seasonInfo.copy(i, str, i2, str2, str6, num2, str5, d2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getSeasonNumber() {
            return this.seasonNumber;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getEpisodeCount() {
            return this.episodeCount;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getPosterPath() {
            return this.posterPath;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getAirDate() {
            return this.airDate;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getOverview() {
            return this.overview;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Double getVoteAverage() {
            return this.voteAverage;
        }

        @NotNull
        public final SeasonInfo copy(@JsonProperty("season_number") int seasonNumber, @JsonProperty("name") @NotNull String name, @JsonProperty("episode_count") int episodeCount, @JsonProperty("poster_path") @Nullable String posterPath, @JsonProperty("air_date") @Nullable String airDate, @JsonProperty("id") @Nullable Integer id, @JsonProperty("overview") @Nullable String overview, @JsonProperty("vote_average") @Nullable Double voteAverage) {
            return new SeasonInfo(seasonNumber, name, episodeCount, posterPath, airDate, id, overview, voteAverage);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SeasonInfo)) {
                return false;
            }
            SeasonInfo seasonInfo = (SeasonInfo) other;
            return this.seasonNumber == seasonInfo.seasonNumber && Intrinsics.areEqual(this.name, seasonInfo.name) && this.episodeCount == seasonInfo.episodeCount && Intrinsics.areEqual(this.posterPath, seasonInfo.posterPath) && Intrinsics.areEqual(this.airDate, seasonInfo.airDate) && Intrinsics.areEqual(this.id, seasonInfo.id) && Intrinsics.areEqual(this.overview, seasonInfo.overview) && Intrinsics.areEqual(this.voteAverage, seasonInfo.voteAverage);
        }

        public int hashCode() {
            return (((((((((((((this.seasonNumber * 31) + this.name.hashCode()) * 31) + this.episodeCount) * 31) + (this.posterPath == null ? 0 : this.posterPath.hashCode())) * 31) + (this.airDate == null ? 0 : this.airDate.hashCode())) * 31) + (this.id == null ? 0 : this.id.hashCode())) * 31) + (this.overview == null ? 0 : this.overview.hashCode())) * 31) + (this.voteAverage != null ? this.voteAverage.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "SeasonInfo(seasonNumber=" + this.seasonNumber + ", name=" + this.name + ", episodeCount=" + this.episodeCount + ", posterPath=" + this.posterPath + ", airDate=" + this.airDate + ", id=" + this.id + ", overview=" + this.overview + ", voteAverage=" + this.voteAverage + ')';
        }

        public SeasonInfo(@JsonProperty("season_number") int seasonNumber, @JsonProperty("name") @NotNull String name, @JsonProperty("episode_count") int episodeCount, @JsonProperty("poster_path") @Nullable String posterPath, @JsonProperty("air_date") @Nullable String airDate, @JsonProperty("id") @Nullable Integer id, @JsonProperty("overview") @Nullable String overview, @JsonProperty("vote_average") @Nullable Double voteAverage) {
            this.seasonNumber = seasonNumber;
            this.name = name;
            this.episodeCount = episodeCount;
            this.posterPath = posterPath;
            this.airDate = airDate;
            this.id = id;
            this.overview = overview;
            this.voteAverage = voteAverage;
        }

        public /* synthetic */ SeasonInfo(int i, String str, int i2, String str2, String str3, Integer num, String str4, Double d, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, str, i2, str2, str3, (i3 & 32) != 0 ? null : num, (i3 & 64) != 0 ? null : str4, (i3 & 128) != 0 ? null : d);
        }

        public final int getSeasonNumber() {
            return this.seasonNumber;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        public final int getEpisodeCount() {
            return this.episodeCount;
        }

        @Nullable
        public final String getPosterPath() {
            return this.posterPath;
        }

        @Nullable
        public final String getAirDate() {
            return this.airDate;
        }

        @Nullable
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        public final String getOverview() {
            return this.overview;
        }

        @Nullable
        public final Double getVoteAverage() {
            return this.voteAverage;
        }
    }

    /* JADX INFO: compiled from: DoFlixProvider.kt */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\bf\b\u0087\b\u0018\u00002\u00020\u0001BÓ\u0003\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0001\u0010\b\u001a\u00020\u0005\u0012\b\b\u0001\u0010\t\u001a\u00020\u0005\u0012\u000e\b\u0001\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u000e\b\u0001\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0003\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b\u0012\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u001e\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0003\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010 \u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0003\u0010#\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010$\u001a\u0004\u0018\u00010\"\u0012\u0010\b\u0003\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b\u0012\u0010\b\u0003\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b\u0012\u0010\b\u0003\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b\u0012\n\b\u0003\u0010(\u001a\u0004\u0018\u00010\u0001\u0012\u0010\b\u0003\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b\u0012\n\b\u0003\u0010*\u001a\u0004\u0018\u00010\u0001\u0012\u0010\b\u0003\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b\u0012\u0010\b\u0003\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b\u0012\u0010\b\u0003\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0004\b.\u0010/J\t\u0010_\u001a\u00020\u0003HÆ\u0003J\t\u0010`\u001a\u00020\u0005HÆ\u0003J\t\u0010a\u001a\u00020\u0005HÆ\u0003J\t\u0010b\u001a\u00020\u0005HÆ\u0003J\t\u0010c\u001a\u00020\u0005HÆ\u0003J\t\u0010d\u001a\u00020\u0005HÆ\u0003J\u000f\u0010e\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\u000f\u0010f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bHÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010h\u001a\u00020\u0003HÆ\u0003J\t\u0010i\u001a\u00020\u0012HÆ\u0003J\u0010\u0010j\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010@J\u000b\u0010k\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010m\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bHÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010p\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0002\u0010IJ\u000b\u0010q\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010s\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0002\u0010IJ\u0010\u0010t\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010@J\u000b\u0010u\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010v\u001a\u0004\u0018\u00010\"HÆ\u0003¢\u0006\u0002\u0010QJ\u000b\u0010w\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010x\u001a\u0004\u0018\u00010\"HÆ\u0003¢\u0006\u0002\u0010QJ\u0011\u0010y\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bHÆ\u0003J\u0011\u0010z\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bHÆ\u0003J\u0011\u0010{\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bHÆ\u0003J\u000b\u0010|\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0011\u0010}\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bHÆ\u0003J\u000b\u0010~\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0011\u0010\u007f\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bHÆ\u0003J\u0012\u0010\u0080\u0001\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bHÆ\u0003J\u0012\u0010\u0081\u0001\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bHÆ\u0003JÜ\u0003\u0010\u0082\u0001\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00052\b\b\u0003\u0010\u0007\u001a\u00020\u00052\b\b\u0003\u0010\b\u001a\u00020\u00052\b\b\u0003\u0010\t\u001a\u00020\u00052\u000e\b\u0003\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u000e\b\u0003\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b2\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\b\u0003\u0010\u0010\u001a\u00020\u00032\b\b\u0003\u0010\u0011\u001a\u00020\u00122\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0010\b\u0003\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b2\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u001e\u001a\u0004\u0018\u00010\u001b2\n\b\u0003\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010 \u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0003\u0010#\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010$\u001a\u0004\u0018\u00010\"2\u0010\b\u0003\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\u0010\b\u0003\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b2\u0010\b\u0003\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b2\n\b\u0003\u0010(\u001a\u0004\u0018\u00010\u00012\u0010\b\u0003\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\n\b\u0003\u0010*\u001a\u0004\u0018\u00010\u00012\u0010\b\u0003\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\u0010\b\u0003\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\u0010\b\u0003\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bHÆ\u0001¢\u0006\u0003\u0010\u0083\u0001J\u0016\u0010\u0084\u0001\u001a\u00020\"2\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\u000b\u0010\u0086\u0001\u001a\u00020\u0003HÖ\u0081\u0004J\u000b\u0010\u0087\u0001\u001a\u00020\u0005HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u00103R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00103R\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00103R\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00103R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u00109R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u00103R\u0016\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u00101R\u0016\u0010\u0011\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010A\u001a\u0004\b?\u0010@R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u00103R\u001e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u00109R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u00103R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u00103R\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010J\u001a\u0004\bH\u0010IR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u00103R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u00103R\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010J\u001a\u0004\bM\u0010IR\u001a\u0010\u001f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010A\u001a\u0004\bN\u0010@R\u0018\u0010 \u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u00103R\u001a\u0010!\u001a\u0004\u0018\u00010\"8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010R\u001a\u0004\bP\u0010QR\u0018\u0010#\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u00103R\u001a\u0010$\u001a\u0004\u0018\u00010\"8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010R\u001a\u0004\bT\u0010QR\u001e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bU\u00109R\u001e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u00109R\u001e\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bW\u00109R\u0018\u0010(\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bX\u0010YR\u001e\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bZ\u00109R\u0018\u0010*\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b[\u0010YR\u001e\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\\\u00109R\u001e\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u00109R\u001e\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b^\u00109¨\u0006\u0088\u0001"}, d2 = {"Lcom/cncverse/DoFlixProvider$TvDetails;", "", "id", "", "name", "", "overview", "firstAirDate", "posterPath", "backdropPath", "genres", "", "Lcom/cncverse/DoFlixProvider$TMDBGenre;", "seasons", "Lcom/cncverse/DoFlixProvider$SeasonInfo;", "customPosterTag", "numberOfSeasons", "credits", "Lcom/cncverse/DoFlixProvider$Credits;", "numberOfEpisodes", "similar", "Lcom/cncverse/DoFlixProvider$SimilarResults;", "homepage", "originCountry", "originalLanguage", "originalName", "popularity", "", "status", "tagline", "voteAverage", "voteCount", "lastAirDate", "inProduction", "", "type", "adult", "createdBy", "episodeRunTime", "languages", "lastEpisodeToAir", "networks", "nextEpisodeToAir", "productionCompanies", "productionCountries", "spokenLanguages", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;ILcom/cncverse/DoFlixProvider$Credits;Ljava/lang/Integer;Lcom/cncverse/DoFlixProvider$SimilarResults;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Object;Ljava/util/List;Ljava/lang/Object;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getId", "()I", "getName", "()Ljava/lang/String;", "getOverview", "getFirstAirDate", "getPosterPath", "getBackdropPath", "getGenres", "()Ljava/util/List;", "getSeasons", "getCustomPosterTag", "getNumberOfSeasons", "getCredits", "()Lcom/cncverse/DoFlixProvider$Credits;", "getNumberOfEpisodes", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSimilar", "()Lcom/cncverse/DoFlixProvider$SimilarResults;", "getHomepage", "getOriginCountry", "getOriginalLanguage", "getOriginalName", "getPopularity", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getStatus", "getTagline", "getVoteAverage", "getVoteCount", "getLastAirDate", "getInProduction", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getType", "getAdult", "getCreatedBy", "getEpisodeRunTime", "getLanguages", "getLastEpisodeToAir", "()Ljava/lang/Object;", "getNetworks", "getNextEpisodeToAir", "getProductionCompanies", "getProductionCountries", "getSpokenLanguages", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;ILcom/cncverse/DoFlixProvider$Credits;Ljava/lang/Integer;Lcom/cncverse/DoFlixProvider$SimilarResults;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Object;Ljava/util/List;Ljava/lang/Object;Ljava/util/List;Ljava/util/List;Ljava/util/List;)Lcom/cncverse/DoFlixProvider$TvDetails;", "equals", "other", "hashCode", "toString", "DoFlixProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class TvDetails {

        @JsonProperty("adult")
        @Nullable
        private final Boolean adult;

        @JsonProperty("backdrop_path")
        @NotNull
        private final String backdropPath;

        @JsonProperty("created_by")
        @Nullable
        private final List<Object> createdBy;

        @JsonProperty("credits")
        @NotNull
        private final Credits credits;

        @JsonProperty("custom_poster_tag")
        @Nullable
        private final String customPosterTag;

        @JsonProperty("episode_run_time")
        @Nullable
        private final List<Integer> episodeRunTime;

        @JsonProperty("first_air_date")
        @NotNull
        private final String firstAirDate;

        @JsonProperty("genres")
        @NotNull
        private final List<TMDBGenre> genres;

        @JsonProperty("homepage")
        @Nullable
        private final String homepage;

        @JsonProperty("id")
        private final int id;

        @JsonProperty("in_production")
        @Nullable
        private final Boolean inProduction;

        @JsonProperty("languages")
        @Nullable
        private final List<String> languages;

        @JsonProperty("last_air_date")
        @Nullable
        private final String lastAirDate;

        @JsonProperty("last_episode_to_air")
        @Nullable
        private final Object lastEpisodeToAir;

        @JsonProperty("name")
        @NotNull
        private final String name;

        @JsonProperty("networks")
        @Nullable
        private final List<Object> networks;

        @JsonProperty("next_episode_to_air")
        @Nullable
        private final Object nextEpisodeToAir;

        @JsonProperty("number_of_episodes")
        @Nullable
        private final Integer numberOfEpisodes;

        @JsonProperty("number_of_seasons")
        private final int numberOfSeasons;

        @JsonProperty("origin_country")
        @Nullable
        private final List<String> originCountry;

        @JsonProperty("original_language")
        @Nullable
        private final String originalLanguage;

        @JsonProperty("original_name")
        @Nullable
        private final String originalName;

        @JsonProperty("overview")
        @NotNull
        private final String overview;

        @JsonProperty("popularity")
        @Nullable
        private final Double popularity;

        @JsonProperty("poster_path")
        @NotNull
        private final String posterPath;

        @JsonProperty("production_companies")
        @Nullable
        private final List<Object> productionCompanies;

        @JsonProperty("production_countries")
        @Nullable
        private final List<Object> productionCountries;

        @JsonProperty("seasons")
        @NotNull
        private final List<SeasonInfo> seasons;

        @JsonProperty("similar")
        @Nullable
        private final SimilarResults similar;

        @JsonProperty("spoken_languages")
        @Nullable
        private final List<Object> spokenLanguages;

        @JsonProperty("status")
        @Nullable
        private final String status;

        @JsonProperty("tagline")
        @Nullable
        private final String tagline;

        @JsonProperty("type")
        @Nullable
        private final String type;

        @JsonProperty("vote_average")
        @Nullable
        private final Double voteAverage;

        @JsonProperty("vote_count")
        @Nullable
        private final Integer voteCount;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ TvDetails copy$default(TvDetails tvDetails, int i, String str, String str2, String str3, String str4, String str5, List list, List list2, String str6, int i2, Credits credits, Integer num, SimilarResults similarResults, String str7, List list3, String str8, String str9, Double d, String str10, String str11, Double d2, Integer num2, String str12, Boolean bool, String str13, Boolean bool2, List list4, List list5, List list6, Object obj, List list7, Object obj2, List list8, List list9, List list10, int i3, int i4, Object obj3) {
            List list11;
            List list12;
            int i5 = (i3 & 1) != 0 ? tvDetails.id : i;
            String str14 = (i3 & 2) != 0 ? tvDetails.name : str;
            String str15 = (i3 & 4) != 0 ? tvDetails.overview : str2;
            String str16 = (i3 & 8) != 0 ? tvDetails.firstAirDate : str3;
            String str17 = (i3 & 16) != 0 ? tvDetails.posterPath : str4;
            String str18 = (i3 & 32) != 0 ? tvDetails.backdropPath : str5;
            List list13 = (i3 & 64) != 0 ? tvDetails.genres : list;
            List list14 = (i3 & 128) != 0 ? tvDetails.seasons : list2;
            String str19 = (i3 & 256) != 0 ? tvDetails.customPosterTag : str6;
            int i6 = (i3 & 512) != 0 ? tvDetails.numberOfSeasons : i2;
            Credits credits2 = (i3 & 1024) != 0 ? tvDetails.credits : credits;
            Integer num3 = (i3 & 2048) != 0 ? tvDetails.numberOfEpisodes : num;
            SimilarResults similarResults2 = (i3 & 4096) != 0 ? tvDetails.similar : similarResults;
            String str20 = (i3 & 8192) != 0 ? tvDetails.homepage : str7;
            int i7 = i5;
            List list15 = (i3 & 16384) != 0 ? tvDetails.originCountry : list3;
            String str21 = (i3 & 32768) != 0 ? tvDetails.originalLanguage : str8;
            String str22 = (i3 & 65536) != 0 ? tvDetails.originalName : str9;
            Double d3 = (i3 & 131072) != 0 ? tvDetails.popularity : d;
            String str23 = (i3 & 262144) != 0 ? tvDetails.status : str10;
            String str24 = (i3 & 524288) != 0 ? tvDetails.tagline : str11;
            Double d4 = (i3 & 1048576) != 0 ? tvDetails.voteAverage : d2;
            Integer num4 = (i3 & 2097152) != 0 ? tvDetails.voteCount : num2;
            String str25 = (i3 & 4194304) != 0 ? tvDetails.lastAirDate : str12;
            Boolean bool3 = (i3 & 8388608) != 0 ? tvDetails.inProduction : bool;
            String str26 = (i3 & 16777216) != 0 ? tvDetails.type : str13;
            Boolean bool4 = (i3 & 33554432) != 0 ? tvDetails.adult : bool2;
            List list16 = (i3 & 67108864) != 0 ? tvDetails.createdBy : list4;
            List list17 = (i3 & 134217728) != 0 ? tvDetails.episodeRunTime : list5;
            List list18 = (i3 & 268435456) != 0 ? tvDetails.languages : list6;
            Object obj4 = (i3 & 536870912) != 0 ? tvDetails.lastEpisodeToAir : obj;
            List list19 = (i3 & 1073741824) != 0 ? tvDetails.networks : list7;
            Object obj5 = (i3 & Integer.MIN_VALUE) != 0 ? tvDetails.nextEpisodeToAir : obj2;
            List list20 = (i4 & 1) != 0 ? tvDetails.productionCompanies : list8;
            List list21 = (i4 & 2) != 0 ? tvDetails.productionCountries : list9;
            if ((i4 & 4) != 0) {
                list12 = list21;
                list11 = tvDetails.spokenLanguages;
            } else {
                list11 = list10;
                list12 = list21;
            }
            return tvDetails.copy(i7, str14, str15, str16, str17, str18, list13, list14, str19, i6, credits2, num3, similarResults2, str20, list15, str21, str22, d3, str23, str24, d4, num4, str25, bool3, str26, bool4, list16, list17, list18, obj4, list19, obj5, list20, list12, list11);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final int getNumberOfSeasons() {
            return this.numberOfSeasons;
        }

        @NotNull
        /* JADX INFO: renamed from: component11, reason: from getter */
        public final Credits getCredits() {
            return this.credits;
        }

        @Nullable
        /* JADX INFO: renamed from: component12, reason: from getter */
        public final Integer getNumberOfEpisodes() {
            return this.numberOfEpisodes;
        }

        @Nullable
        /* JADX INFO: renamed from: component13, reason: from getter */
        public final SimilarResults getSimilar() {
            return this.similar;
        }

        @Nullable
        /* JADX INFO: renamed from: component14, reason: from getter */
        public final String getHomepage() {
            return this.homepage;
        }

        @Nullable
        public final List<String> component15() {
            return this.originCountry;
        }

        @Nullable
        /* JADX INFO: renamed from: component16, reason: from getter */
        public final String getOriginalLanguage() {
            return this.originalLanguage;
        }

        @Nullable
        /* JADX INFO: renamed from: component17, reason: from getter */
        public final String getOriginalName() {
            return this.originalName;
        }

        @Nullable
        /* JADX INFO: renamed from: component18, reason: from getter */
        public final Double getPopularity() {
            return this.popularity;
        }

        @Nullable
        /* JADX INFO: renamed from: component19, reason: from getter */
        public final String getStatus() {
            return this.status;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @Nullable
        /* JADX INFO: renamed from: component20, reason: from getter */
        public final String getTagline() {
            return this.tagline;
        }

        @Nullable
        /* JADX INFO: renamed from: component21, reason: from getter */
        public final Double getVoteAverage() {
            return this.voteAverage;
        }

        @Nullable
        /* JADX INFO: renamed from: component22, reason: from getter */
        public final Integer getVoteCount() {
            return this.voteCount;
        }

        @Nullable
        /* JADX INFO: renamed from: component23, reason: from getter */
        public final String getLastAirDate() {
            return this.lastAirDate;
        }

        @Nullable
        /* JADX INFO: renamed from: component24, reason: from getter */
        public final Boolean getInProduction() {
            return this.inProduction;
        }

        @Nullable
        /* JADX INFO: renamed from: component25, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @Nullable
        /* JADX INFO: renamed from: component26, reason: from getter */
        public final Boolean getAdult() {
            return this.adult;
        }

        @Nullable
        public final List<Object> component27() {
            return this.createdBy;
        }

        @Nullable
        public final List<Integer> component28() {
            return this.episodeRunTime;
        }

        @Nullable
        public final List<String> component29() {
            return this.languages;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getOverview() {
            return this.overview;
        }

        @Nullable
        /* JADX INFO: renamed from: component30, reason: from getter */
        public final Object getLastEpisodeToAir() {
            return this.lastEpisodeToAir;
        }

        @Nullable
        public final List<Object> component31() {
            return this.networks;
        }

        @Nullable
        /* JADX INFO: renamed from: component32, reason: from getter */
        public final Object getNextEpisodeToAir() {
            return this.nextEpisodeToAir;
        }

        @Nullable
        public final List<Object> component33() {
            return this.productionCompanies;
        }

        @Nullable
        public final List<Object> component34() {
            return this.productionCountries;
        }

        @Nullable
        public final List<Object> component35() {
            return this.spokenLanguages;
        }

        @NotNull
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getFirstAirDate() {
            return this.firstAirDate;
        }

        @NotNull
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getPosterPath() {
            return this.posterPath;
        }

        @NotNull
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getBackdropPath() {
            return this.backdropPath;
        }

        @NotNull
        public final List<TMDBGenre> component7() {
            return this.genres;
        }

        @NotNull
        public final List<SeasonInfo> component8() {
            return this.seasons;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getCustomPosterTag() {
            return this.customPosterTag;
        }

        @NotNull
        public final TvDetails copy(@JsonProperty("id") int id, @JsonProperty("name") @NotNull String name, @JsonProperty("overview") @NotNull String overview, @JsonProperty("first_air_date") @NotNull String firstAirDate, @JsonProperty("poster_path") @NotNull String posterPath, @JsonProperty("backdrop_path") @NotNull String backdropPath, @JsonProperty("genres") @NotNull List<TMDBGenre> genres, @JsonProperty("seasons") @NotNull List<SeasonInfo> seasons, @JsonProperty("custom_poster_tag") @Nullable String customPosterTag, @JsonProperty("number_of_seasons") int numberOfSeasons, @JsonProperty("credits") @NotNull Credits credits, @JsonProperty("number_of_episodes") @Nullable Integer numberOfEpisodes, @JsonProperty("similar") @Nullable SimilarResults similar, @JsonProperty("homepage") @Nullable String homepage, @JsonProperty("origin_country") @Nullable List<String> originCountry, @JsonProperty("original_language") @Nullable String originalLanguage, @JsonProperty("original_name") @Nullable String originalName, @JsonProperty("popularity") @Nullable Double popularity, @JsonProperty("status") @Nullable String status, @JsonProperty("tagline") @Nullable String tagline, @JsonProperty("vote_average") @Nullable Double voteAverage, @JsonProperty("vote_count") @Nullable Integer voteCount, @JsonProperty("last_air_date") @Nullable String lastAirDate, @JsonProperty("in_production") @Nullable Boolean inProduction, @JsonProperty("type") @Nullable String type, @JsonProperty("adult") @Nullable Boolean adult, @JsonProperty("created_by") @Nullable List<? extends Object> createdBy, @JsonProperty("episode_run_time") @Nullable List<Integer> episodeRunTime, @JsonProperty("languages") @Nullable List<String> languages, @JsonProperty("last_episode_to_air") @Nullable Object lastEpisodeToAir, @JsonProperty("networks") @Nullable List<? extends Object> networks, @JsonProperty("next_episode_to_air") @Nullable Object nextEpisodeToAir, @JsonProperty("production_companies") @Nullable List<? extends Object> productionCompanies, @JsonProperty("production_countries") @Nullable List<? extends Object> productionCountries, @JsonProperty("spoken_languages") @Nullable List<? extends Object> spokenLanguages) {
            return new TvDetails(id, name, overview, firstAirDate, posterPath, backdropPath, genres, seasons, customPosterTag, numberOfSeasons, credits, numberOfEpisodes, similar, homepage, originCountry, originalLanguage, originalName, popularity, status, tagline, voteAverage, voteCount, lastAirDate, inProduction, type, adult, createdBy, episodeRunTime, languages, lastEpisodeToAir, networks, nextEpisodeToAir, productionCompanies, productionCountries, spokenLanguages);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TvDetails)) {
                return false;
            }
            TvDetails tvDetails = (TvDetails) other;
            return this.id == tvDetails.id && Intrinsics.areEqual(this.name, tvDetails.name) && Intrinsics.areEqual(this.overview, tvDetails.overview) && Intrinsics.areEqual(this.firstAirDate, tvDetails.firstAirDate) && Intrinsics.areEqual(this.posterPath, tvDetails.posterPath) && Intrinsics.areEqual(this.backdropPath, tvDetails.backdropPath) && Intrinsics.areEqual(this.genres, tvDetails.genres) && Intrinsics.areEqual(this.seasons, tvDetails.seasons) && Intrinsics.areEqual(this.customPosterTag, tvDetails.customPosterTag) && this.numberOfSeasons == tvDetails.numberOfSeasons && Intrinsics.areEqual(this.credits, tvDetails.credits) && Intrinsics.areEqual(this.numberOfEpisodes, tvDetails.numberOfEpisodes) && Intrinsics.areEqual(this.similar, tvDetails.similar) && Intrinsics.areEqual(this.homepage, tvDetails.homepage) && Intrinsics.areEqual(this.originCountry, tvDetails.originCountry) && Intrinsics.areEqual(this.originalLanguage, tvDetails.originalLanguage) && Intrinsics.areEqual(this.originalName, tvDetails.originalName) && Intrinsics.areEqual(this.popularity, tvDetails.popularity) && Intrinsics.areEqual(this.status, tvDetails.status) && Intrinsics.areEqual(this.tagline, tvDetails.tagline) && Intrinsics.areEqual(this.voteAverage, tvDetails.voteAverage) && Intrinsics.areEqual(this.voteCount, tvDetails.voteCount) && Intrinsics.areEqual(this.lastAirDate, tvDetails.lastAirDate) && Intrinsics.areEqual(this.inProduction, tvDetails.inProduction) && Intrinsics.areEqual(this.type, tvDetails.type) && Intrinsics.areEqual(this.adult, tvDetails.adult) && Intrinsics.areEqual(this.createdBy, tvDetails.createdBy) && Intrinsics.areEqual(this.episodeRunTime, tvDetails.episodeRunTime) && Intrinsics.areEqual(this.languages, tvDetails.languages) && Intrinsics.areEqual(this.lastEpisodeToAir, tvDetails.lastEpisodeToAir) && Intrinsics.areEqual(this.networks, tvDetails.networks) && Intrinsics.areEqual(this.nextEpisodeToAir, tvDetails.nextEpisodeToAir) && Intrinsics.areEqual(this.productionCompanies, tvDetails.productionCompanies) && Intrinsics.areEqual(this.productionCountries, tvDetails.productionCountries) && Intrinsics.areEqual(this.spokenLanguages, tvDetails.spokenLanguages);
        }

        public int hashCode() {
            return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.id * 31) + this.name.hashCode()) * 31) + this.overview.hashCode()) * 31) + this.firstAirDate.hashCode()) * 31) + this.posterPath.hashCode()) * 31) + this.backdropPath.hashCode()) * 31) + this.genres.hashCode()) * 31) + this.seasons.hashCode()) * 31) + (this.customPosterTag == null ? 0 : this.customPosterTag.hashCode())) * 31) + this.numberOfSeasons) * 31) + this.credits.hashCode()) * 31) + (this.numberOfEpisodes == null ? 0 : this.numberOfEpisodes.hashCode())) * 31) + (this.similar == null ? 0 : this.similar.hashCode())) * 31) + (this.homepage == null ? 0 : this.homepage.hashCode())) * 31) + (this.originCountry == null ? 0 : this.originCountry.hashCode())) * 31) + (this.originalLanguage == null ? 0 : this.originalLanguage.hashCode())) * 31) + (this.originalName == null ? 0 : this.originalName.hashCode())) * 31) + (this.popularity == null ? 0 : this.popularity.hashCode())) * 31) + (this.status == null ? 0 : this.status.hashCode())) * 31) + (this.tagline == null ? 0 : this.tagline.hashCode())) * 31) + (this.voteAverage == null ? 0 : this.voteAverage.hashCode())) * 31) + (this.voteCount == null ? 0 : this.voteCount.hashCode())) * 31) + (this.lastAirDate == null ? 0 : this.lastAirDate.hashCode())) * 31) + (this.inProduction == null ? 0 : this.inProduction.hashCode())) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.adult == null ? 0 : this.adult.hashCode())) * 31) + (this.createdBy == null ? 0 : this.createdBy.hashCode())) * 31) + (this.episodeRunTime == null ? 0 : this.episodeRunTime.hashCode())) * 31) + (this.languages == null ? 0 : this.languages.hashCode())) * 31) + (this.lastEpisodeToAir == null ? 0 : this.lastEpisodeToAir.hashCode())) * 31) + (this.networks == null ? 0 : this.networks.hashCode())) * 31) + (this.nextEpisodeToAir == null ? 0 : this.nextEpisodeToAir.hashCode())) * 31) + (this.productionCompanies == null ? 0 : this.productionCompanies.hashCode())) * 31) + (this.productionCountries == null ? 0 : this.productionCountries.hashCode())) * 31) + (this.spokenLanguages != null ? this.spokenLanguages.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("TvDetails(id=").append(this.id).append(", name=").append(this.name).append(", overview=").append(this.overview).append(", firstAirDate=").append(this.firstAirDate).append(", posterPath=").append(this.posterPath).append(", backdropPath=").append(this.backdropPath).append(", genres=").append(this.genres).append(", seasons=").append(this.seasons).append(", customPosterTag=").append(this.customPosterTag).append(", numberOfSeasons=").append(this.numberOfSeasons).append(", credits=").append(this.credits).append(", numberOfEpisodes=");
            sb.append(this.numberOfEpisodes).append(", similar=").append(this.similar).append(", homepage=").append(this.homepage).append(", originCountry=").append(this.originCountry).append(", originalLanguage=").append(this.originalLanguage).append(", originalName=").append(this.originalName).append(", popularity=").append(this.popularity).append(", status=").append(this.status).append(", tagline=").append(this.tagline).append(", voteAverage=").append(this.voteAverage).append(", voteCount=").append(this.voteCount).append(", lastAirDate=").append(this.lastAirDate);
            sb.append(", inProduction=").append(this.inProduction).append(", type=").append(this.type).append(", adult=").append(this.adult).append(", createdBy=").append(this.createdBy).append(", episodeRunTime=").append(this.episodeRunTime).append(", languages=").append(this.languages).append(", lastEpisodeToAir=").append(this.lastEpisodeToAir).append(", networks=").append(this.networks).append(", nextEpisodeToAir=").append(this.nextEpisodeToAir).append(", productionCompanies=").append(this.productionCompanies).append(", productionCountries=").append(this.productionCountries).append(", spokenLanguages=");
            sb.append(this.spokenLanguages).append(')');
            return sb.toString();
        }

        public TvDetails(@JsonProperty("id") int id, @JsonProperty("name") @NotNull String name, @JsonProperty("overview") @NotNull String overview, @JsonProperty("first_air_date") @NotNull String firstAirDate, @JsonProperty("poster_path") @NotNull String posterPath, @JsonProperty("backdrop_path") @NotNull String backdropPath, @JsonProperty("genres") @NotNull List<TMDBGenre> list, @JsonProperty("seasons") @NotNull List<SeasonInfo> list2, @JsonProperty("custom_poster_tag") @Nullable String customPosterTag, @JsonProperty("number_of_seasons") int numberOfSeasons, @JsonProperty("credits") @NotNull Credits credits, @JsonProperty("number_of_episodes") @Nullable Integer numberOfEpisodes, @JsonProperty("similar") @Nullable SimilarResults similar, @JsonProperty("homepage") @Nullable String homepage, @JsonProperty("origin_country") @Nullable List<String> list3, @JsonProperty("original_language") @Nullable String originalLanguage, @JsonProperty("original_name") @Nullable String originalName, @JsonProperty("popularity") @Nullable Double popularity, @JsonProperty("status") @Nullable String status, @JsonProperty("tagline") @Nullable String tagline, @JsonProperty("vote_average") @Nullable Double voteAverage, @JsonProperty("vote_count") @Nullable Integer voteCount, @JsonProperty("last_air_date") @Nullable String lastAirDate, @JsonProperty("in_production") @Nullable Boolean inProduction, @JsonProperty("type") @Nullable String type, @JsonProperty("adult") @Nullable Boolean adult, @JsonProperty("created_by") @Nullable List<? extends Object> list4, @JsonProperty("episode_run_time") @Nullable List<Integer> list5, @JsonProperty("languages") @Nullable List<String> list6, @JsonProperty("last_episode_to_air") @Nullable Object lastEpisodeToAir, @JsonProperty("networks") @Nullable List<? extends Object> list7, @JsonProperty("next_episode_to_air") @Nullable Object nextEpisodeToAir, @JsonProperty("production_companies") @Nullable List<? extends Object> list8, @JsonProperty("production_countries") @Nullable List<? extends Object> list9, @JsonProperty("spoken_languages") @Nullable List<? extends Object> list10) {
            this.id = id;
            this.name = name;
            this.overview = overview;
            this.firstAirDate = firstAirDate;
            this.posterPath = posterPath;
            this.backdropPath = backdropPath;
            this.genres = list;
            this.seasons = list2;
            this.customPosterTag = customPosterTag;
            this.numberOfSeasons = numberOfSeasons;
            this.credits = credits;
            this.numberOfEpisodes = numberOfEpisodes;
            this.similar = similar;
            this.homepage = homepage;
            this.originCountry = list3;
            this.originalLanguage = originalLanguage;
            this.originalName = originalName;
            this.popularity = popularity;
            this.status = status;
            this.tagline = tagline;
            this.voteAverage = voteAverage;
            this.voteCount = voteCount;
            this.lastAirDate = lastAirDate;
            this.inProduction = inProduction;
            this.type = type;
            this.adult = adult;
            this.createdBy = list4;
            this.episodeRunTime = list5;
            this.languages = list6;
            this.lastEpisodeToAir = lastEpisodeToAir;
            this.networks = list7;
            this.nextEpisodeToAir = nextEpisodeToAir;
            this.productionCompanies = list8;
            this.productionCountries = list9;
            this.spokenLanguages = list10;
        }

        public /* synthetic */ TvDetails(int i, String str, String str2, String str3, String str4, String str5, List list, List list2, String str6, int i2, Credits credits, Integer num, SimilarResults similarResults, String str7, List list3, String str8, String str9, Double d, String str10, String str11, Double d2, Integer num2, String str12, Boolean bool, String str13, Boolean bool2, List list4, List list5, List list6, Object obj, List list7, Object obj2, List list8, List list9, List list10, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, str, str2, str3, str4, str5, list, list2, str6, i2, credits, (i3 & 2048) != 0 ? null : num, (i3 & 4096) != 0 ? null : similarResults, (i3 & 8192) != 0 ? null : str7, (i3 & 16384) != 0 ? null : list3, (32768 & i3) != 0 ? null : str8, (65536 & i3) != 0 ? null : str9, (131072 & i3) != 0 ? null : d, (262144 & i3) != 0 ? null : str10, (524288 & i3) != 0 ? null : str11, (1048576 & i3) != 0 ? null : d2, (2097152 & i3) != 0 ? null : num2, (4194304 & i3) != 0 ? null : str12, (8388608 & i3) != 0 ? null : bool, (16777216 & i3) != 0 ? null : str13, (33554432 & i3) != 0 ? null : bool2, (67108864 & i3) != 0 ? null : list4, (134217728 & i3) != 0 ? null : list5, (268435456 & i3) != 0 ? null : list6, (536870912 & i3) != 0 ? null : obj, (1073741824 & i3) != 0 ? null : list7, (i3 & Integer.MIN_VALUE) != 0 ? null : obj2, (i4 & 1) != 0 ? null : list8, (i4 & 2) != 0 ? null : list9, (i4 & 4) != 0 ? null : list10);
        }

        public final int getId() {
            return this.id;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @NotNull
        public final String getOverview() {
            return this.overview;
        }

        @NotNull
        public final String getFirstAirDate() {
            return this.firstAirDate;
        }

        @NotNull
        public final String getPosterPath() {
            return this.posterPath;
        }

        @NotNull
        public final String getBackdropPath() {
            return this.backdropPath;
        }

        @NotNull
        public final List<TMDBGenre> getGenres() {
            return this.genres;
        }

        @NotNull
        public final List<SeasonInfo> getSeasons() {
            return this.seasons;
        }

        @Nullable
        public final String getCustomPosterTag() {
            return this.customPosterTag;
        }

        public final int getNumberOfSeasons() {
            return this.numberOfSeasons;
        }

        @NotNull
        public final Credits getCredits() {
            return this.credits;
        }

        @Nullable
        public final Integer getNumberOfEpisodes() {
            return this.numberOfEpisodes;
        }

        @Nullable
        public final SimilarResults getSimilar() {
            return this.similar;
        }

        @Nullable
        public final String getHomepage() {
            return this.homepage;
        }

        @Nullable
        public final List<String> getOriginCountry() {
            return this.originCountry;
        }

        @Nullable
        public final String getOriginalLanguage() {
            return this.originalLanguage;
        }

        @Nullable
        public final String getOriginalName() {
            return this.originalName;
        }

        @Nullable
        public final Double getPopularity() {
            return this.popularity;
        }

        @Nullable
        public final String getStatus() {
            return this.status;
        }

        @Nullable
        public final String getTagline() {
            return this.tagline;
        }

        @Nullable
        public final Double getVoteAverage() {
            return this.voteAverage;
        }

        @Nullable
        public final Integer getVoteCount() {
            return this.voteCount;
        }

        @Nullable
        public final String getLastAirDate() {
            return this.lastAirDate;
        }

        @Nullable
        public final Boolean getInProduction() {
            return this.inProduction;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }

        @Nullable
        public final Boolean getAdult() {
            return this.adult;
        }

        @Nullable
        public final List<Object> getCreatedBy() {
            return this.createdBy;
        }

        @Nullable
        public final List<Integer> getEpisodeRunTime() {
            return this.episodeRunTime;
        }

        @Nullable
        public final List<String> getLanguages() {
            return this.languages;
        }

        @Nullable
        public final Object getLastEpisodeToAir() {
            return this.lastEpisodeToAir;
        }

        @Nullable
        public final List<Object> getNetworks() {
            return this.networks;
        }

        @Nullable
        public final Object getNextEpisodeToAir() {
            return this.nextEpisodeToAir;
        }

        @Nullable
        public final List<Object> getProductionCompanies() {
            return this.productionCompanies;
        }

        @Nullable
        public final List<Object> getProductionCountries() {
            return this.productionCountries;
        }

        @Nullable
        public final List<Object> getSpokenLanguages() {
            return this.spokenLanguages;
        }
    }

    /* JADX INFO: compiled from: DoFlixProvider.kt */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b)\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B·\u0001\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0003\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012\u0012\u0010\b\u0003\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u00102\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u00104\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0011\u00107\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012HÆ\u0003J\u0011\u00108\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012HÆ\u0003J¾\u0001\u00109\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00122\u0010\b\u0003\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012HÆ\u0001¢\u0006\u0002\u0010:J\u0014\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010>\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010?\u001a\u00020\u0005HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b \u0010\u001eR\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u001a\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b$\u0010\u001eR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b&\u0010\u001eR\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b'\u0010\u001eR\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010)¨\u0006@"}, d2 = {"Lcom/cncverse/DoFlixProvider$TvEpisode;", "", "episodeNumber", "", "name", "", "overview", "stillPath", "airDate", "id", "runtime", "voteAverage", "", "voteCount", "productionCode", "seasonNumber", "showId", "crew", "", "guestStars", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;)V", "getEpisodeNumber", "()I", "getName", "()Ljava/lang/String;", "getOverview", "getStillPath", "getAirDate", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRuntime", "getVoteAverage", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getVoteCount", "getProductionCode", "getSeasonNumber", "getShowId", "getCrew", "()Ljava/util/List;", "getGuestStars", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;)Lcom/cncverse/DoFlixProvider$TvEpisode;", "equals", "", "other", "hashCode", "toString", "DoFlixProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class TvEpisode {

        @JsonProperty("air_date")
        @Nullable
        private final String airDate;

        @JsonProperty("crew")
        @Nullable
        private final List<Object> crew;

        @JsonProperty("episode_number")
        private final int episodeNumber;

        @JsonProperty("guest_stars")
        @Nullable
        private final List<Object> guestStars;

        @JsonProperty("id")
        @Nullable
        private final Integer id;

        @JsonProperty("name")
        @NotNull
        private final String name;

        @JsonProperty("overview")
        @Nullable
        private final String overview;

        @JsonProperty("production_code")
        @Nullable
        private final String productionCode;

        @JsonProperty("runtime")
        @Nullable
        private final Integer runtime;

        @JsonProperty("season_number")
        @Nullable
        private final Integer seasonNumber;

        @JsonProperty("show_id")
        @Nullable
        private final Integer showId;

        @JsonProperty("still_path")
        @Nullable
        private final String stillPath;

        @JsonProperty("vote_average")
        @Nullable
        private final Double voteAverage;

        @JsonProperty("vote_count")
        @Nullable
        private final Integer voteCount;

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getEpisodeNumber() {
            return this.episodeNumber;
        }

        @Nullable
        /* JADX INFO: renamed from: component10, reason: from getter */
        public final String getProductionCode() {
            return this.productionCode;
        }

        @Nullable
        /* JADX INFO: renamed from: component11, reason: from getter */
        public final Integer getSeasonNumber() {
            return this.seasonNumber;
        }

        @Nullable
        /* JADX INFO: renamed from: component12, reason: from getter */
        public final Integer getShowId() {
            return this.showId;
        }

        @Nullable
        public final List<Object> component13() {
            return this.crew;
        }

        @Nullable
        public final List<Object> component14() {
            return this.guestStars;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getOverview() {
            return this.overview;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getStillPath() {
            return this.stillPath;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getAirDate() {
            return this.airDate;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Integer getRuntime() {
            return this.runtime;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Double getVoteAverage() {
            return this.voteAverage;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final Integer getVoteCount() {
            return this.voteCount;
        }

        @NotNull
        public final TvEpisode copy(@JsonProperty("episode_number") int episodeNumber, @JsonProperty("name") @NotNull String name, @JsonProperty("overview") @Nullable String overview, @JsonProperty("still_path") @Nullable String stillPath, @JsonProperty("air_date") @Nullable String airDate, @JsonProperty("id") @Nullable Integer id, @JsonProperty("runtime") @Nullable Integer runtime, @JsonProperty("vote_average") @Nullable Double voteAverage, @JsonProperty("vote_count") @Nullable Integer voteCount, @JsonProperty("production_code") @Nullable String productionCode, @JsonProperty("season_number") @Nullable Integer seasonNumber, @JsonProperty("show_id") @Nullable Integer showId, @JsonProperty("crew") @Nullable List<? extends Object> crew, @JsonProperty("guest_stars") @Nullable List<? extends Object> guestStars) {
            return new TvEpisode(episodeNumber, name, overview, stillPath, airDate, id, runtime, voteAverage, voteCount, productionCode, seasonNumber, showId, crew, guestStars);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TvEpisode)) {
                return false;
            }
            TvEpisode tvEpisode = (TvEpisode) other;
            return this.episodeNumber == tvEpisode.episodeNumber && Intrinsics.areEqual(this.name, tvEpisode.name) && Intrinsics.areEqual(this.overview, tvEpisode.overview) && Intrinsics.areEqual(this.stillPath, tvEpisode.stillPath) && Intrinsics.areEqual(this.airDate, tvEpisode.airDate) && Intrinsics.areEqual(this.id, tvEpisode.id) && Intrinsics.areEqual(this.runtime, tvEpisode.runtime) && Intrinsics.areEqual(this.voteAverage, tvEpisode.voteAverage) && Intrinsics.areEqual(this.voteCount, tvEpisode.voteCount) && Intrinsics.areEqual(this.productionCode, tvEpisode.productionCode) && Intrinsics.areEqual(this.seasonNumber, tvEpisode.seasonNumber) && Intrinsics.areEqual(this.showId, tvEpisode.showId) && Intrinsics.areEqual(this.crew, tvEpisode.crew) && Intrinsics.areEqual(this.guestStars, tvEpisode.guestStars);
        }

        public int hashCode() {
            return (((((((((((((((((((((((((this.episodeNumber * 31) + this.name.hashCode()) * 31) + (this.overview == null ? 0 : this.overview.hashCode())) * 31) + (this.stillPath == null ? 0 : this.stillPath.hashCode())) * 31) + (this.airDate == null ? 0 : this.airDate.hashCode())) * 31) + (this.id == null ? 0 : this.id.hashCode())) * 31) + (this.runtime == null ? 0 : this.runtime.hashCode())) * 31) + (this.voteAverage == null ? 0 : this.voteAverage.hashCode())) * 31) + (this.voteCount == null ? 0 : this.voteCount.hashCode())) * 31) + (this.productionCode == null ? 0 : this.productionCode.hashCode())) * 31) + (this.seasonNumber == null ? 0 : this.seasonNumber.hashCode())) * 31) + (this.showId == null ? 0 : this.showId.hashCode())) * 31) + (this.crew == null ? 0 : this.crew.hashCode())) * 31) + (this.guestStars != null ? this.guestStars.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("TvEpisode(episodeNumber=").append(this.episodeNumber).append(", name=").append(this.name).append(", overview=").append(this.overview).append(", stillPath=").append(this.stillPath).append(", airDate=").append(this.airDate).append(", id=").append(this.id).append(", runtime=").append(this.runtime).append(", voteAverage=").append(this.voteAverage).append(", voteCount=").append(this.voteCount).append(", productionCode=").append(this.productionCode).append(", seasonNumber=").append(this.seasonNumber).append(", showId=");
            sb.append(this.showId).append(", crew=").append(this.crew).append(", guestStars=").append(this.guestStars).append(')');
            return sb.toString();
        }

        public TvEpisode(@JsonProperty("episode_number") int episodeNumber, @JsonProperty("name") @NotNull String name, @JsonProperty("overview") @Nullable String overview, @JsonProperty("still_path") @Nullable String stillPath, @JsonProperty("air_date") @Nullable String airDate, @JsonProperty("id") @Nullable Integer id, @JsonProperty("runtime") @Nullable Integer runtime, @JsonProperty("vote_average") @Nullable Double voteAverage, @JsonProperty("vote_count") @Nullable Integer voteCount, @JsonProperty("production_code") @Nullable String productionCode, @JsonProperty("season_number") @Nullable Integer seasonNumber, @JsonProperty("show_id") @Nullable Integer showId, @JsonProperty("crew") @Nullable List<? extends Object> list, @JsonProperty("guest_stars") @Nullable List<? extends Object> list2) {
            this.episodeNumber = episodeNumber;
            this.name = name;
            this.overview = overview;
            this.stillPath = stillPath;
            this.airDate = airDate;
            this.id = id;
            this.runtime = runtime;
            this.voteAverage = voteAverage;
            this.voteCount = voteCount;
            this.productionCode = productionCode;
            this.seasonNumber = seasonNumber;
            this.showId = showId;
            this.crew = list;
            this.guestStars = list2;
        }

        public /* synthetic */ TvEpisode(int i, String str, String str2, String str3, String str4, Integer num, Integer num2, Double d, Integer num3, String str5, Integer num4, Integer num5, List list, List list2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, str, str2, str3, str4, (i2 & 32) != 0 ? null : num, (i2 & 64) != 0 ? null : num2, (i2 & 128) != 0 ? null : d, (i2 & 256) != 0 ? null : num3, (i2 & 512) != 0 ? null : str5, (i2 & 1024) != 0 ? null : num4, (i2 & 2048) != 0 ? null : num5, (i2 & 4096) != 0 ? null : list, (i2 & 8192) != 0 ? null : list2);
        }

        public final int getEpisodeNumber() {
            return this.episodeNumber;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @Nullable
        public final String getOverview() {
            return this.overview;
        }

        @Nullable
        public final String getStillPath() {
            return this.stillPath;
        }

        @Nullable
        public final String getAirDate() {
            return this.airDate;
        }

        @Nullable
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        public final Integer getRuntime() {
            return this.runtime;
        }

        @Nullable
        public final Double getVoteAverage() {
            return this.voteAverage;
        }

        @Nullable
        public final Integer getVoteCount() {
            return this.voteCount;
        }

        @Nullable
        public final String getProductionCode() {
            return this.productionCode;
        }

        @Nullable
        public final Integer getSeasonNumber() {
            return this.seasonNumber;
        }

        @Nullable
        public final Integer getShowId() {
            return this.showId;
        }

        @Nullable
        public final List<Object> getCrew() {
            return this.crew;
        }

        @Nullable
        public final List<Object> getGuestStars() {
            return this.guestStars;
        }
    }

    /* JADX INFO: compiled from: DoFlixProvider.kt */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bu\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0001\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\n\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010&\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010 J|\u0010+\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\u000e\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u0010,J\u0014\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00100\u001a\u00020\u0003HÖ\u0081\u0004J\n\u00101\u001a\u00020\nHÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0019\u0010\u0017R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0018\u0010\f\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0018\u0010\r\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 ¨\u00062"}, d2 = {"Lcom/cncverse/DoFlixProvider$SeasonDetails;", "", "seasonNumber", "", "episodes", "", "Lcom/cncverse/DoFlixProvider$TvEpisode;", "id", "mongoId", "name", "", "overview", "posterPath", "airDate", "voteAverage", "", "<init>", "(ILjava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;)V", "getSeasonNumber", "()I", "getEpisodes", "()Ljava/util/List;", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMongoId", "getName", "()Ljava/lang/String;", "getOverview", "getPosterPath", "getAirDate", "getVoteAverage", "()Ljava/lang/Double;", "Ljava/lang/Double;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ILjava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;)Lcom/cncverse/DoFlixProvider$SeasonDetails;", "equals", "", "other", "hashCode", "toString", "DoFlixProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class SeasonDetails {

        @JsonProperty("air_date")
        @Nullable
        private final String airDate;

        @JsonProperty("episodes")
        @NotNull
        private final List<TvEpisode> episodes;

        @JsonProperty("id")
        @Nullable
        private final Integer id;

        @JsonProperty("_id")
        @Nullable
        private final Integer mongoId;

        @JsonProperty("name")
        @Nullable
        private final String name;

        @JsonProperty("overview")
        @Nullable
        private final String overview;

        @JsonProperty("poster_path")
        @Nullable
        private final String posterPath;

        @JsonProperty("season_number")
        private final int seasonNumber;

        @JsonProperty("vote_average")
        @Nullable
        private final Double voteAverage;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SeasonDetails copy$default(SeasonDetails seasonDetails, int i, List list, Integer num, Integer num2, String str, String str2, String str3, String str4, Double d, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = seasonDetails.seasonNumber;
            }
            if ((i2 & 2) != 0) {
                list = seasonDetails.episodes;
            }
            if ((i2 & 4) != 0) {
                num = seasonDetails.id;
            }
            if ((i2 & 8) != 0) {
                num2 = seasonDetails.mongoId;
            }
            if ((i2 & 16) != 0) {
                str = seasonDetails.name;
            }
            if ((i2 & 32) != 0) {
                str2 = seasonDetails.overview;
            }
            if ((i2 & 64) != 0) {
                str3 = seasonDetails.posterPath;
            }
            if ((i2 & 128) != 0) {
                str4 = seasonDetails.airDate;
            }
            if ((i2 & 256) != 0) {
                d = seasonDetails.voteAverage;
            }
            String str5 = str4;
            Double d2 = d;
            String str6 = str2;
            String str7 = str3;
            String str8 = str;
            Integer num3 = num;
            return seasonDetails.copy(i, list, num3, num2, str8, str6, str7, str5, d2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getSeasonNumber() {
            return this.seasonNumber;
        }

        @NotNull
        public final List<TvEpisode> component2() {
            return this.episodes;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Integer getMongoId() {
            return this.mongoId;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getOverview() {
            return this.overview;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getPosterPath() {
            return this.posterPath;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getAirDate() {
            return this.airDate;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final Double getVoteAverage() {
            return this.voteAverage;
        }

        @NotNull
        public final SeasonDetails copy(@JsonProperty("season_number") int seasonNumber, @JsonProperty("episodes") @NotNull List<TvEpisode> episodes, @JsonProperty("id") @Nullable Integer id, @JsonProperty("_id") @Nullable Integer mongoId, @JsonProperty("name") @Nullable String name, @JsonProperty("overview") @Nullable String overview, @JsonProperty("poster_path") @Nullable String posterPath, @JsonProperty("air_date") @Nullable String airDate, @JsonProperty("vote_average") @Nullable Double voteAverage) {
            return new SeasonDetails(seasonNumber, episodes, id, mongoId, name, overview, posterPath, airDate, voteAverage);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SeasonDetails)) {
                return false;
            }
            SeasonDetails seasonDetails = (SeasonDetails) other;
            return this.seasonNumber == seasonDetails.seasonNumber && Intrinsics.areEqual(this.episodes, seasonDetails.episodes) && Intrinsics.areEqual(this.id, seasonDetails.id) && Intrinsics.areEqual(this.mongoId, seasonDetails.mongoId) && Intrinsics.areEqual(this.name, seasonDetails.name) && Intrinsics.areEqual(this.overview, seasonDetails.overview) && Intrinsics.areEqual(this.posterPath, seasonDetails.posterPath) && Intrinsics.areEqual(this.airDate, seasonDetails.airDate) && Intrinsics.areEqual(this.voteAverage, seasonDetails.voteAverage);
        }

        public int hashCode() {
            return (((((((((((((((this.seasonNumber * 31) + this.episodes.hashCode()) * 31) + (this.id == null ? 0 : this.id.hashCode())) * 31) + (this.mongoId == null ? 0 : this.mongoId.hashCode())) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.overview == null ? 0 : this.overview.hashCode())) * 31) + (this.posterPath == null ? 0 : this.posterPath.hashCode())) * 31) + (this.airDate == null ? 0 : this.airDate.hashCode())) * 31) + (this.voteAverage != null ? this.voteAverage.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "SeasonDetails(seasonNumber=" + this.seasonNumber + ", episodes=" + this.episodes + ", id=" + this.id + ", mongoId=" + this.mongoId + ", name=" + this.name + ", overview=" + this.overview + ", posterPath=" + this.posterPath + ", airDate=" + this.airDate + ", voteAverage=" + this.voteAverage + ')';
        }

        public SeasonDetails(@JsonProperty("season_number") int seasonNumber, @JsonProperty("episodes") @NotNull List<TvEpisode> list, @JsonProperty("id") @Nullable Integer id, @JsonProperty("_id") @Nullable Integer mongoId, @JsonProperty("name") @Nullable String name, @JsonProperty("overview") @Nullable String overview, @JsonProperty("poster_path") @Nullable String posterPath, @JsonProperty("air_date") @Nullable String airDate, @JsonProperty("vote_average") @Nullable Double voteAverage) {
            this.seasonNumber = seasonNumber;
            this.episodes = list;
            this.id = id;
            this.mongoId = mongoId;
            this.name = name;
            this.overview = overview;
            this.posterPath = posterPath;
            this.airDate = airDate;
            this.voteAverage = voteAverage;
        }

        public /* synthetic */ SeasonDetails(int i, List list, Integer num, Integer num2, String str, String str2, String str3, String str4, Double d, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, list, (i2 & 4) != 0 ? null : num, (i2 & 8) != 0 ? null : num2, (i2 & 16) != 0 ? null : str, (i2 & 32) != 0 ? null : str2, (i2 & 64) != 0 ? null : str3, (i2 & 128) != 0 ? null : str4, (i2 & 256) != 0 ? null : d);
        }

        public final int getSeasonNumber() {
            return this.seasonNumber;
        }

        @NotNull
        public final List<TvEpisode> getEpisodes() {
            return this.episodes;
        }

        @Nullable
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        public final Integer getMongoId() {
            return this.mongoId;
        }

        @Nullable
        public final String getName() {
            return this.name;
        }

        @Nullable
        public final String getOverview() {
            return this.overview;
        }

        @Nullable
        public final String getPosterPath() {
            return this.posterPath;
        }

        @Nullable
        public final String getAirDate() {
            return this.airDate;
        }

        @Nullable
        public final Double getVoteAverage() {
            return this.voteAverage;
        }
    }

    /* JADX INFO: compiled from: DoFlixProvider.kt */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b'\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u008f\u0001\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010&\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010'\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010(\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010)\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010*\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0096\u0001\u0010-\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010.J\u0014\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00102\u001a\u00020\bHÖ\u0081\u0004J\n\u00103\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001a\u0010\u0018R\u001a\u0010\n\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001b\u0010\u0018R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001c\u0010\u0018R\u001a\u0010\f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001d\u0010\u0018R\u001a\u0010\r\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001e\u0010\u0018R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013¨\u00064"}, d2 = {"Lcom/cncverse/DoFlixProvider$StreamLink;", "", "host", "", "url", "quality", "size", "id", "", "movieId", "tvShowId", "seasonNumber", "episodeNumber", "order", "createdAt", "updatedAt", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getHost", "()Ljava/lang/String;", "getUrl", "getQuality", "getSize", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMovieId", "getTvShowId", "getSeasonNumber", "getEpisodeNumber", "getOrder", "getCreatedAt", "getUpdatedAt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/cncverse/DoFlixProvider$StreamLink;", "equals", "", "other", "hashCode", "toString", "DoFlixProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class StreamLink {

        @JsonProperty("created_at")
        @Nullable
        private final String createdAt;

        @JsonProperty("episode_number")
        @Nullable
        private final Integer episodeNumber;

        @JsonProperty("host")
        @NotNull
        private final String host;

        @JsonProperty("id")
        @Nullable
        private final Integer id;

        @JsonProperty("movie_id")
        @Nullable
        private final Integer movieId;

        @JsonProperty("order")
        @Nullable
        private final Integer order;

        @JsonProperty("quality")
        @NotNull
        private final String quality;

        @JsonProperty("season_number")
        @Nullable
        private final Integer seasonNumber;

        @JsonProperty("size")
        @NotNull
        private final String size;

        @JsonProperty("tv_show_id")
        @Nullable
        private final Integer tvShowId;

        @JsonProperty("updated_at")
        @Nullable
        private final String updatedAt;

        @JsonProperty("url")
        @NotNull
        private final String url;

        public static /* synthetic */ StreamLink copy$default(StreamLink streamLink, String str, String str2, String str3, String str4, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, String str5, String str6, int i, Object obj) {
            if ((i & 1) != 0) {
                str = streamLink.host;
            }
            if ((i & 2) != 0) {
                str2 = streamLink.url;
            }
            if ((i & 4) != 0) {
                str3 = streamLink.quality;
            }
            if ((i & 8) != 0) {
                str4 = streamLink.size;
            }
            if ((i & 16) != 0) {
                num = streamLink.id;
            }
            if ((i & 32) != 0) {
                num2 = streamLink.movieId;
            }
            if ((i & 64) != 0) {
                num3 = streamLink.tvShowId;
            }
            if ((i & 128) != 0) {
                num4 = streamLink.seasonNumber;
            }
            if ((i & 256) != 0) {
                num5 = streamLink.episodeNumber;
            }
            if ((i & 512) != 0) {
                num6 = streamLink.order;
            }
            if ((i & 1024) != 0) {
                str5 = streamLink.createdAt;
            }
            if ((i & 2048) != 0) {
                str6 = streamLink.updatedAt;
            }
            String str7 = str5;
            String str8 = str6;
            Integer num7 = num5;
            Integer num8 = num6;
            Integer num9 = num3;
            Integer num10 = num4;
            Integer num11 = num;
            Integer num12 = num2;
            return streamLink.copy(str, str2, str3, str4, num11, num12, num9, num10, num7, num8, str7, str8);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getHost() {
            return this.host;
        }

        @Nullable
        /* JADX INFO: renamed from: component10, reason: from getter */
        public final Integer getOrder() {
            return this.order;
        }

        @Nullable
        /* JADX INFO: renamed from: component11, reason: from getter */
        public final String getCreatedAt() {
            return this.createdAt;
        }

        @Nullable
        /* JADX INFO: renamed from: component12, reason: from getter */
        public final String getUpdatedAt() {
            return this.updatedAt;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getQuality() {
            return this.quality;
        }

        @NotNull
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getSize() {
            return this.size;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Integer getMovieId() {
            return this.movieId;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Integer getTvShowId() {
            return this.tvShowId;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Integer getSeasonNumber() {
            return this.seasonNumber;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final Integer getEpisodeNumber() {
            return this.episodeNumber;
        }

        @NotNull
        public final StreamLink copy(@JsonProperty("host") @NotNull String host, @JsonProperty("url") @NotNull String url, @JsonProperty("quality") @NotNull String quality, @JsonProperty("size") @NotNull String size, @JsonProperty("id") @Nullable Integer id, @JsonProperty("movie_id") @Nullable Integer movieId, @JsonProperty("tv_show_id") @Nullable Integer tvShowId, @JsonProperty("season_number") @Nullable Integer seasonNumber, @JsonProperty("episode_number") @Nullable Integer episodeNumber, @JsonProperty("order") @Nullable Integer order, @JsonProperty("created_at") @Nullable String createdAt, @JsonProperty("updated_at") @Nullable String updatedAt) {
            return new StreamLink(host, url, quality, size, id, movieId, tvShowId, seasonNumber, episodeNumber, order, createdAt, updatedAt);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StreamLink)) {
                return false;
            }
            StreamLink streamLink = (StreamLink) other;
            return Intrinsics.areEqual(this.host, streamLink.host) && Intrinsics.areEqual(this.url, streamLink.url) && Intrinsics.areEqual(this.quality, streamLink.quality) && Intrinsics.areEqual(this.size, streamLink.size) && Intrinsics.areEqual(this.id, streamLink.id) && Intrinsics.areEqual(this.movieId, streamLink.movieId) && Intrinsics.areEqual(this.tvShowId, streamLink.tvShowId) && Intrinsics.areEqual(this.seasonNumber, streamLink.seasonNumber) && Intrinsics.areEqual(this.episodeNumber, streamLink.episodeNumber) && Intrinsics.areEqual(this.order, streamLink.order) && Intrinsics.areEqual(this.createdAt, streamLink.createdAt) && Intrinsics.areEqual(this.updatedAt, streamLink.updatedAt);
        }

        public int hashCode() {
            return (((((((((((((((((((((this.host.hashCode() * 31) + this.url.hashCode()) * 31) + this.quality.hashCode()) * 31) + this.size.hashCode()) * 31) + (this.id == null ? 0 : this.id.hashCode())) * 31) + (this.movieId == null ? 0 : this.movieId.hashCode())) * 31) + (this.tvShowId == null ? 0 : this.tvShowId.hashCode())) * 31) + (this.seasonNumber == null ? 0 : this.seasonNumber.hashCode())) * 31) + (this.episodeNumber == null ? 0 : this.episodeNumber.hashCode())) * 31) + (this.order == null ? 0 : this.order.hashCode())) * 31) + (this.createdAt == null ? 0 : this.createdAt.hashCode())) * 31) + (this.updatedAt != null ? this.updatedAt.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("StreamLink(host=").append(this.host).append(", url=").append(this.url).append(", quality=").append(this.quality).append(", size=").append(this.size).append(", id=").append(this.id).append(", movieId=").append(this.movieId).append(", tvShowId=").append(this.tvShowId).append(", seasonNumber=").append(this.seasonNumber).append(", episodeNumber=").append(this.episodeNumber).append(", order=").append(this.order).append(", createdAt=").append(this.createdAt).append(", updatedAt=");
            sb.append(this.updatedAt).append(')');
            return sb.toString();
        }

        public StreamLink(@JsonProperty("host") @NotNull String host, @JsonProperty("url") @NotNull String url, @JsonProperty("quality") @NotNull String quality, @JsonProperty("size") @NotNull String size, @JsonProperty("id") @Nullable Integer id, @JsonProperty("movie_id") @Nullable Integer movieId, @JsonProperty("tv_show_id") @Nullable Integer tvShowId, @JsonProperty("season_number") @Nullable Integer seasonNumber, @JsonProperty("episode_number") @Nullable Integer episodeNumber, @JsonProperty("order") @Nullable Integer order, @JsonProperty("created_at") @Nullable String createdAt, @JsonProperty("updated_at") @Nullable String updatedAt) {
            this.host = host;
            this.url = url;
            this.quality = quality;
            this.size = size;
            this.id = id;
            this.movieId = movieId;
            this.tvShowId = tvShowId;
            this.seasonNumber = seasonNumber;
            this.episodeNumber = episodeNumber;
            this.order = order;
            this.createdAt = createdAt;
            this.updatedAt = updatedAt;
        }

        public /* synthetic */ StreamLink(String str, String str2, String str3, String str4, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, str4, (i & 16) != 0 ? null : num, (i & 32) != 0 ? null : num2, (i & 64) != 0 ? null : num3, (i & 128) != 0 ? null : num4, (i & 256) != 0 ? null : num5, (i & 512) != 0 ? null : num6, (i & 1024) != 0 ? null : str5, (i & 2048) != 0 ? null : str6);
        }

        @NotNull
        public final String getHost() {
            return this.host;
        }

        @NotNull
        public final String getUrl() {
            return this.url;
        }

        @NotNull
        public final String getQuality() {
            return this.quality;
        }

        @NotNull
        public final String getSize() {
            return this.size;
        }

        @Nullable
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        public final Integer getMovieId() {
            return this.movieId;
        }

        @Nullable
        public final Integer getTvShowId() {
            return this.tvShowId;
        }

        @Nullable
        public final Integer getSeasonNumber() {
            return this.seasonNumber;
        }

        @Nullable
        public final Integer getEpisodeNumber() {
            return this.episodeNumber;
        }

        @Nullable
        public final Integer getOrder() {
            return this.order;
        }

        @Nullable
        public final String getCreatedAt() {
            return this.createdAt;
        }

        @Nullable
        public final String getUpdatedAt() {
            return this.updatedAt;
        }
    }

    /* JADX INFO: compiled from: DoFlixProvider.kt */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\fJ*\u0010\u0010\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/cncverse/DoFlixProvider$MovieLinksResponse;", "", "links", "", "Lcom/cncverse/DoFlixProvider$StreamLink;", "id", "", "<init>", "(Ljava/util/List;Ljava/lang/Integer;)V", "getLinks", "()Ljava/util/List;", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/util/List;Ljava/lang/Integer;)Lcom/cncverse/DoFlixProvider$MovieLinksResponse;", "equals", "", "other", "hashCode", "toString", "", "DoFlixProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class MovieLinksResponse {

        @JsonProperty("id")
        @Nullable
        private final Integer id;

        @JsonProperty("links")
        @NotNull
        private final List<StreamLink> links;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MovieLinksResponse copy$default(MovieLinksResponse movieLinksResponse, List list, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                list = movieLinksResponse.links;
            }
            if ((i & 2) != 0) {
                num = movieLinksResponse.id;
            }
            return movieLinksResponse.copy(list, num);
        }

        @NotNull
        public final List<StreamLink> component1() {
            return this.links;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getId() {
            return this.id;
        }

        @NotNull
        public final MovieLinksResponse copy(@JsonProperty("links") @NotNull List<StreamLink> links, @JsonProperty("id") @Nullable Integer id) {
            return new MovieLinksResponse(links, id);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MovieLinksResponse)) {
                return false;
            }
            MovieLinksResponse movieLinksResponse = (MovieLinksResponse) other;
            return Intrinsics.areEqual(this.links, movieLinksResponse.links) && Intrinsics.areEqual(this.id, movieLinksResponse.id);
        }

        public int hashCode() {
            return (this.links.hashCode() * 31) + (this.id == null ? 0 : this.id.hashCode());
        }

        @NotNull
        public String toString() {
            return "MovieLinksResponse(links=" + this.links + ", id=" + this.id + ')';
        }

        public MovieLinksResponse(@JsonProperty("links") @NotNull List<StreamLink> list, @JsonProperty("id") @Nullable Integer id) {
            this.links = list;
            this.id = id;
        }

        public /* synthetic */ MovieLinksResponse(List list, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, (i & 2) != 0 ? null : num);
        }

        @NotNull
        public final List<StreamLink> getLinks() {
            return this.links;
        }

        @Nullable
        public final Integer getId() {
            return this.id;
        }
    }

    /* JADX INFO: compiled from: DoFlixProvider.kt */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\fJ*\u0010\u0010\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/cncverse/DoFlixProvider$EpisodeLinksResponse;", "", "results", "", "Lcom/cncverse/DoFlixProvider$StreamLink;", "id", "", "<init>", "(Ljava/util/List;Ljava/lang/Integer;)V", "getResults", "()Ljava/util/List;", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/util/List;Ljava/lang/Integer;)Lcom/cncverse/DoFlixProvider$EpisodeLinksResponse;", "equals", "", "other", "hashCode", "toString", "", "DoFlixProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class EpisodeLinksResponse {

        @JsonProperty("id")
        @Nullable
        private final Integer id;

        @JsonProperty("results")
        @NotNull
        private final List<StreamLink> results;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ EpisodeLinksResponse copy$default(EpisodeLinksResponse episodeLinksResponse, List list, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                list = episodeLinksResponse.results;
            }
            if ((i & 2) != 0) {
                num = episodeLinksResponse.id;
            }
            return episodeLinksResponse.copy(list, num);
        }

        @NotNull
        public final List<StreamLink> component1() {
            return this.results;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getId() {
            return this.id;
        }

        @NotNull
        public final EpisodeLinksResponse copy(@JsonProperty("results") @NotNull List<StreamLink> results, @JsonProperty("id") @Nullable Integer id) {
            return new EpisodeLinksResponse(results, id);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EpisodeLinksResponse)) {
                return false;
            }
            EpisodeLinksResponse episodeLinksResponse = (EpisodeLinksResponse) other;
            return Intrinsics.areEqual(this.results, episodeLinksResponse.results) && Intrinsics.areEqual(this.id, episodeLinksResponse.id);
        }

        public int hashCode() {
            return (this.results.hashCode() * 31) + (this.id == null ? 0 : this.id.hashCode());
        }

        @NotNull
        public String toString() {
            return "EpisodeLinksResponse(results=" + this.results + ", id=" + this.id + ')';
        }

        public EpisodeLinksResponse(@JsonProperty("results") @NotNull List<StreamLink> list, @JsonProperty("id") @Nullable Integer id) {
            this.results = list;
            this.id = id;
        }

        public /* synthetic */ EpisodeLinksResponse(List list, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, (i & 2) != 0 ? null : num);
        }

        @NotNull
        public final List<StreamLink> getResults() {
            return this.results;
        }

        @Nullable
        public final Integer getId() {
            return this.id;
        }
    }

    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.fasterxml.jackson.databind.RuntimeJsonMappingException */
    /* JADX WARN: Code duplicated, block: B:69:0x02c6  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) throws RuntimeJsonMappingException {
        C00001 c00001;
        Object obj;
        MainPageRequest request2;
        int page2;
        Map genreGroups;
        Iterable $this$forEach$iv;
        int $i$f$forEach;
        Object answer$iv;
        Object answer$iv2;
        DoFlixProvider doFlixProvider = this;
        if (continuation instanceof C00001) {
            c00001 = (C00001) continuation;
            if ((c00001.label & Integer.MIN_VALUE) != 0) {
                c00001.label -= Integer.MIN_VALUE;
            } else {
                c00001 = doFlixProvider.new C00001(continuation);
            }
        } else {
            c00001 = doFlixProvider.new C00001(continuation);
        }
        Object $result = c00001.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00001.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (INSTANCE.isCsGuardBlocked()) {
                    INSTANCE.showCsGuardToast(context);
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), (Boolean) null, 2, (Object) null);
                }
                doFlixProvider.showTelegramPopup();
                doFlixProvider.showSubscriptionPopupIfNeeded();
                String data = request.getData();
                c00001.L$0 = request;
                c00001.I$0 = page;
                c00001.label = 1;
                Object withCustomHeaders = doFlixProvider.getWithCustomHeaders(data, c00001);
                if (withCustomHeaders == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = withCustomHeaders;
                request2 = request;
                page2 = page;
                break;
                break;
            case 1:
                page2 = c00001.I$0;
                request2 = (MainPageRequest) c00001.L$0;
                ResultKt.throwOnFailure($result);
                obj = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String responseText = (String) obj;
        List homePageList = new ArrayList();
        String name = request2.getName();
        switch (name.hashCode()) {
            case 139953384:
                if (name.equals("TrendingMovies")) {
                    ObjectMapper $this$readValue$iv = doFlixProvider.mapper;
                    Object $this$checkTypeMismatch$iv$iv = $this$readValue$iv.readValue(responseText, new TypeReference<HomePageApiResponse>() { // from class: com.cncverse.DoFlixProvider$getMainPage$$inlined$readValue$2
                    });
                    if (!($this$checkTypeMismatch$iv$iv instanceof HomePageApiResponse)) {
                        throw new RuntimeJsonMappingException("Deserialized value did not match the specified type; specified " + Reflection.getOrCreateKotlinClass(HomePageApiResponse.class).getQualifiedName() + "(non-null) but was " + ($this$checkTypeMismatch$iv$iv != null ? Reflection.getOrCreateKotlinClass($this$checkTypeMismatch$iv$iv.getClass()).getQualifiedName() : null));
                    }
                    HomePageApiResponse homeData = (HomePageApiResponse) $this$checkTypeMismatch$iv$iv;
                    if (!homeData.getResults().isEmpty()) {
                        Iterable $this$map$iv = homeData.getResults();
                        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                        for (Object item$iv$iv : $this$map$iv) {
                            final MovieResult movie = (MovieResult) item$iv$iv;
                            DoFlixProvider doFlixProvider2 = doFlixProvider;
                            String title = movie.getTitle();
                            if (title == null && (title = movie.getName()) == null) {
                                title = "Unknown";
                            }
                            destination$iv$iv.add(MainAPIKt.newMovieSearchResponse$default(doFlixProvider2, title, "movie," + movie.getId(), TvType.Movie, false, new Function1() { // from class: com.cncverse.DoFlixProvider$$ExternalSyntheticLambda5
                                public final Object invoke(Object obj2) {
                                    return DoFlixProvider.getMainPage$lambda$1$0(movie, (MovieSearchResponse) obj2);
                                }
                            }, 8, (Object) null));
                            homeData = homeData;
                            $this$map$iv = $this$map$iv;
                        }
                        HomePageApiResponse homeData2 = homeData;
                        List trendingMovies = (List) destination$iv$iv;
                        homePageList.add(new HomePageList("🔥 Trending Movies", trendingMovies, false, 4, (DefaultConstructorMarker) null));
                        Map genreGroups2 = new LinkedHashMap();
                        Iterable $this$forEach$iv2 = homeData2.getResults();
                        int $i$f$forEach2 = 0;
                        for (Object element$iv : $this$forEach$iv2) {
                            MovieResult movie2 = (MovieResult) element$iv;
                            Iterable $this$forEach$iv3 = movie2.getGenreIds();
                            if ($this$forEach$iv3 != null) {
                                for (Object element$iv2 : $this$forEach$iv3) {
                                    int genreId = ((Number) element$iv2).intValue();
                                    Map genreGroups3 = genreGroups2;
                                    Integer numBoxInt = Boxing.boxInt(genreId);
                                    Iterable $this$forEach$iv4 = $this$forEach$iv2;
                                    Object value$iv = genreGroups3.get(numBoxInt);
                                    if (value$iv == null) {
                                        answer$iv = new ArrayList();
                                        genreGroups3.put(numBoxInt, answer$iv);
                                    } else {
                                        answer$iv = value$iv;
                                    }
                                    Object key$iv = answer$iv;
                                    ((List) key$iv).add(movie2);
                                    genreGroups2 = genreGroups3;
                                    $this$forEach$iv2 = $this$forEach$iv4;
                                    $i$f$forEach2 = $i$f$forEach2;
                                }
                                genreGroups = genreGroups2;
                                $this$forEach$iv = $this$forEach$iv2;
                                $i$f$forEach = $i$f$forEach2;
                                Unit unit = Unit.INSTANCE;
                            } else {
                                genreGroups = genreGroups2;
                                $this$forEach$iv = $this$forEach$iv2;
                                $i$f$forEach = $i$f$forEach2;
                            }
                            genreGroups2 = genreGroups;
                            $this$forEach$iv2 = $this$forEach$iv;
                            $i$f$forEach2 = $i$f$forEach;
                        }
                        Iterable $this$sortedByDescending$iv = genreGroups2.entrySet();
                        Iterable $this$forEach$iv5 = CollectionsKt.take(CollectionsKt.sortedWith($this$sortedByDescending$iv, new Comparator() { // from class: com.cncverse.DoFlixProvider$getMainPage$$inlined$sortedByDescending$1
                            @Override // java.util.Comparator
                            public final int compare(T t, T t2) {
                                Map.Entry it = (Map.Entry) t2;
                                Map.Entry it2 = (Map.Entry) t;
                                return ComparisonsKt.compareValues(Integer.valueOf(((List) it.getValue()).size()), Integer.valueOf(((List) it2.getValue()).size()));
                            }
                        }), 5);
                        int $i$f$forEach3 = 0;
                        Iterator it = $this$forEach$iv5.iterator();
                        while (it.hasNext()) {
                            Object element$iv3 = it.next();
                            Map.Entry entry = (Map.Entry) element$iv3;
                            int genreId2 = ((Number) entry.getKey()).intValue();
                            Iterable movies = (List) entry.getValue();
                            String str = doFlixProvider.movieGenres.get(Boxing.boxInt(genreId2));
                            if (str == null) {
                                str = "Other";
                            }
                            String genreName = str;
                            Iterable $this$map$iv2 = movies;
                            Iterable $this$forEach$iv6 = $this$forEach$iv5;
                            int $i$f$forEach4 = $i$f$forEach3;
                            int $i$f$forEach5 = CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10);
                            Collection destination$iv$iv2 = new ArrayList($i$f$forEach5);
                            Iterable $this$mapTo$iv$iv = $this$map$iv2;
                            for (Object item$iv$iv2 : $this$mapTo$iv$iv) {
                                final MovieResult movie3 = (MovieResult) item$iv$iv2;
                                DoFlixProvider doFlixProvider3 = this;
                                String title2 = movie3.getTitle();
                                destination$iv$iv2.add(MainAPIKt.newMovieSearchResponse$default(doFlixProvider3, (title2 == null && (title2 = movie3.getName()) == null) ? "Unknown" : title2, "movie," + movie3.getId(), TvType.Movie, false, new Function1() { // from class: com.cncverse.DoFlixProvider$$ExternalSyntheticLambda6
                                    public final Object invoke(Object obj2) {
                                        return DoFlixProvider.getMainPage$lambda$4$0$0(movie3, (MovieSearchResponse) obj2);
                                    }
                                }, 8, (Object) null));
                                $this$mapTo$iv$iv = $this$mapTo$iv$iv;
                                it = it;
                            }
                            List genreItems = (List) destination$iv$iv2;
                            homePageList.add(new HomePageList(genreName, genreItems, false, 4, (DefaultConstructorMarker) null));
                            doFlixProvider = this;
                            $this$forEach$iv5 = $this$forEach$iv6;
                            $i$f$forEach3 = $i$f$forEach4;
                        }
                    }
                }
                return MainAPIKt.newHomePageResponse$default(homePageList, (Boolean) null, 2, (Object) null);
            case 302373916:
                if (name.equals("TrendingSeries")) {
                    ObjectMapper $this$readValue$iv2 = doFlixProvider.mapper;
                    Object $this$checkTypeMismatch$iv$iv2 = $this$readValue$iv2.readValue(responseText, new TypeReference<SeriesPageApiResponse>() { // from class: com.cncverse.DoFlixProvider$getMainPage$$inlined$readValue$4
                    });
                    if (!($this$checkTypeMismatch$iv$iv2 instanceof SeriesPageApiResponse)) {
                        throw new RuntimeJsonMappingException("Deserialized value did not match the specified type; specified " + Reflection.getOrCreateKotlinClass(SeriesPageApiResponse.class).getQualifiedName() + "(non-null) but was " + ($this$checkTypeMismatch$iv$iv2 != null ? Reflection.getOrCreateKotlinClass($this$checkTypeMismatch$iv$iv2.getClass()).getQualifiedName() : null));
                    }
                    SeriesPageApiResponse seriesData = (SeriesPageApiResponse) $this$checkTypeMismatch$iv$iv2;
                    if (!seriesData.getResults().isEmpty()) {
                        Iterable $this$map$iv3 = seriesData.getResults();
                        Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                        for (Object item$iv$iv3 : $this$map$iv3) {
                            final SeriesResult series = (SeriesResult) item$iv$iv3;
                            destination$iv$iv3.add(MainAPIKt.newTvSeriesSearchResponse$default(doFlixProvider, series.getName(), "tvseries," + series.getId(), TvType.TvSeries, false, new Function1() { // from class: com.cncverse.DoFlixProvider$$ExternalSyntheticLambda8
                                public final Object invoke(Object obj2) {
                                    return DoFlixProvider.getMainPage$lambda$6$0(series, (TvSeriesSearchResponse) obj2);
                                }
                            }, 8, (Object) null));
                            seriesData = seriesData;
                            $this$map$iv3 = $this$map$iv3;
                        }
                        SeriesPageApiResponse seriesData2 = seriesData;
                        List trendingSeries = (List) destination$iv$iv3;
                        homePageList.add(new HomePageList("🔥 Trending Series", trendingSeries, false, 4, (DefaultConstructorMarker) null));
                        Map genreGroups4 = new LinkedHashMap();
                        Iterable $this$forEach$iv7 = seriesData2.getResults();
                        int $i$f$forEach6 = 0;
                        for (Object element$iv4 : $this$forEach$iv7) {
                            SeriesResult series2 = (SeriesResult) element$iv4;
                            for (Object element$iv5 : series2.getGenreIds()) {
                                int genreId3 = ((Number) element$iv5).intValue();
                                Map genreGroups5 = genreGroups4;
                                Integer numBoxInt2 = Boxing.boxInt(genreId3);
                                Iterable $this$forEach$iv8 = $this$forEach$iv7;
                                Object value$iv2 = genreGroups5.get(numBoxInt2);
                                if (value$iv2 == null) {
                                    answer$iv2 = new ArrayList();
                                    genreGroups5.put(numBoxInt2, answer$iv2);
                                } else {
                                    answer$iv2 = value$iv2;
                                }
                                Object key$iv2 = answer$iv2;
                                ((List) key$iv2).add(series2);
                                genreGroups4 = genreGroups5;
                                $this$forEach$iv7 = $this$forEach$iv8;
                                $i$f$forEach6 = $i$f$forEach6;
                            }
                        }
                        Iterable $this$sortedByDescending$iv2 = genreGroups4.entrySet();
                        Iterable $this$forEach$iv9 = CollectionsKt.take(CollectionsKt.sortedWith($this$sortedByDescending$iv2, new Comparator() { // from class: com.cncverse.DoFlixProvider$getMainPage$$inlined$sortedByDescending$2
                            @Override // java.util.Comparator
                            public final int compare(T t, T t2) {
                                Map.Entry it2 = (Map.Entry) t2;
                                Map.Entry it3 = (Map.Entry) t;
                                return ComparisonsKt.compareValues(Integer.valueOf(((List) it2.getValue()).size()), Integer.valueOf(((List) it3.getValue()).size()));
                            }
                        }), 5);
                        int $i$f$forEach7 = 0;
                        Iterator it2 = $this$forEach$iv9.iterator();
                        while (it2.hasNext()) {
                            Object element$iv6 = it2.next();
                            Map.Entry entry2 = (Map.Entry) element$iv6;
                            int genreId4 = ((Number) entry2.getKey()).intValue();
                            Iterable seriesList = (List) entry2.getValue();
                            String str2 = doFlixProvider.seriesGenres.get(Boxing.boxInt(genreId4));
                            if (str2 == null) {
                                str2 = "Other";
                            }
                            String genreName2 = str2;
                            Iterable $this$map$iv4 = seriesList;
                            Iterable $this$forEach$iv10 = $this$forEach$iv9;
                            int $i$f$forEach8 = $i$f$forEach7;
                            Iterator it3 = it2;
                            Collection destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv4, 10));
                            Iterable $this$mapTo$iv$iv2 = $this$map$iv4;
                            int $i$f$mapTo = 0;
                            for (Object item$iv$iv4 : $this$mapTo$iv$iv2) {
                                Iterable $this$mapTo$iv$iv3 = $this$mapTo$iv$iv2;
                                final SeriesResult series3 = (SeriesResult) item$iv$iv4;
                                destination$iv$iv4.add(MainAPIKt.newTvSeriesSearchResponse$default(doFlixProvider, series3.getName(), "tvseries," + series3.getId(), TvType.TvSeries, false, new Function1() { // from class: com.cncverse.DoFlixProvider$$ExternalSyntheticLambda9
                                    public final Object invoke(Object obj2) {
                                        return DoFlixProvider.getMainPage$lambda$9$0$0(series3, (TvSeriesSearchResponse) obj2);
                                    }
                                }, 8, (Object) null));
                                $this$mapTo$iv$iv2 = $this$mapTo$iv$iv3;
                                $i$f$mapTo = $i$f$mapTo;
                                page2 = page2;
                            }
                            List genreItems2 = (List) destination$iv$iv4;
                            homePageList.add(new HomePageList(genreName2, genreItems2, false, 4, (DefaultConstructorMarker) null));
                            $this$forEach$iv9 = $this$forEach$iv10;
                            $i$f$forEach7 = $i$f$forEach8;
                            it2 = it3;
                        }
                    }
                }
                return MainAPIKt.newHomePageResponse$default(homePageList, (Boolean) null, 2, (Object) null);
            case 1364508062:
                if (name.equals("RecentMovies")) {
                    ObjectMapper $this$readValue$iv3 = doFlixProvider.mapper;
                    Object $this$checkTypeMismatch$iv$iv3 = $this$readValue$iv3.readValue(responseText, new TypeReference<HomePageApiResponse>() { // from class: com.cncverse.DoFlixProvider$getMainPage$$inlined$readValue$1
                    });
                    if (!($this$checkTypeMismatch$iv$iv3 instanceof HomePageApiResponse)) {
                        throw new RuntimeJsonMappingException("Deserialized value did not match the specified type; specified " + Reflection.getOrCreateKotlinClass(HomePageApiResponse.class).getQualifiedName() + "(non-null) but was " + ($this$checkTypeMismatch$iv$iv3 != null ? Reflection.getOrCreateKotlinClass($this$checkTypeMismatch$iv$iv3.getClass()).getQualifiedName() : null));
                    }
                    HomePageApiResponse homeData3 = (HomePageApiResponse) $this$checkTypeMismatch$iv$iv3;
                    if (!homeData3.getResults().isEmpty()) {
                        Iterable $this$map$iv5 = homeData3.getResults();
                        Collection destination$iv$iv5 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv5, 10));
                        for (Object item$iv$iv5 : $this$map$iv5) {
                            final MovieResult movie4 = (MovieResult) item$iv$iv5;
                            DoFlixProvider doFlixProvider4 = doFlixProvider;
                            String title3 = movie4.getTitle();
                            if (title3 == null && (title3 = movie4.getName()) == null) {
                                title3 = "Unknown";
                            }
                            destination$iv$iv5.add(MainAPIKt.newMovieSearchResponse$default(doFlixProvider4, title3, "movie," + movie4.getId(), TvType.Movie, false, new Function1() { // from class: com.cncverse.DoFlixProvider$$ExternalSyntheticLambda4
                                public final Object invoke(Object obj2) {
                                    return DoFlixProvider.getMainPage$lambda$0$0(movie4, (MovieSearchResponse) obj2);
                                }
                            }, 8, (Object) null));
                            homeData3 = homeData3;
                            $this$map$iv5 = $this$map$iv5;
                        }
                        List movieItems = (List) destination$iv$iv5;
                        homePageList.add(new HomePageList("📅 Recently Added Movies", movieItems, false, 4, (DefaultConstructorMarker) null));
                    }
                }
                return MainAPIKt.newHomePageResponse$default(homePageList, (Boolean) null, 2, (Object) null);
            case 1526928594:
                if (name.equals("RecentSeries")) {
                    ObjectMapper $this$readValue$iv4 = doFlixProvider.mapper;
                    Object $this$checkTypeMismatch$iv$iv4 = $this$readValue$iv4.readValue(responseText, new TypeReference<SeriesPageApiResponse>() { // from class: com.cncverse.DoFlixProvider$getMainPage$$inlined$readValue$3
                    });
                    if (!($this$checkTypeMismatch$iv$iv4 instanceof SeriesPageApiResponse)) {
                        throw new RuntimeJsonMappingException("Deserialized value did not match the specified type; specified " + Reflection.getOrCreateKotlinClass(SeriesPageApiResponse.class).getQualifiedName() + "(non-null) but was " + ($this$checkTypeMismatch$iv$iv4 != null ? Reflection.getOrCreateKotlinClass($this$checkTypeMismatch$iv$iv4.getClass()).getQualifiedName() : null));
                    }
                    SeriesPageApiResponse seriesData3 = (SeriesPageApiResponse) $this$checkTypeMismatch$iv$iv4;
                    if (!seriesData3.getResults().isEmpty()) {
                        Iterable $this$map$iv6 = seriesData3.getResults();
                        Collection destination$iv$iv6 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv6, 10));
                        for (Object item$iv$iv6 : $this$map$iv6) {
                            SeriesPageApiResponse seriesData4 = seriesData3;
                            final SeriesResult series4 = (SeriesResult) item$iv$iv6;
                            destination$iv$iv6.add(MainAPIKt.newTvSeriesSearchResponse$default(doFlixProvider, series4.getName(), "tvseries," + series4.getId(), TvType.TvSeries, false, new Function1() { // from class: com.cncverse.DoFlixProvider$$ExternalSyntheticLambda7
                                public final Object invoke(Object obj2) {
                                    return DoFlixProvider.getMainPage$lambda$5$0(series4, (TvSeriesSearchResponse) obj2);
                                }
                            }, 8, (Object) null));
                            seriesData3 = seriesData4;
                            c00001 = c00001;
                            $result = $result;
                        }
                        List seriesItems = (List) destination$iv$iv6;
                        homePageList.add(new HomePageList("📅 Recently Added Series", seriesItems, false, 4, (DefaultConstructorMarker) null));
                    }
                }
                return MainAPIKt.newHomePageResponse$default(homePageList, (Boolean) null, 2, (Object) null);
            default:
                return MainAPIKt.newHomePageResponse$default(homePageList, (Boolean) null, 2, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMainPage$lambda$0$0(MovieResult $movie, MovieSearchResponse $this$newMovieSearchResponse) {
        String strSubstringBefore$default;
        $this$newMovieSearchResponse.setPosterUrl($movie.getPosterPath());
        String releaseDate = $movie.getReleaseDate();
        if (releaseDate == null) {
            releaseDate = $movie.getFirstAirDate();
        }
        SearchQuality searchQuality = null;
        $this$newMovieSearchResponse.setYear((releaseDate == null || (strSubstringBefore$default = StringsKt.substringBefore$default(releaseDate, "-", (String) null, 2, (Object) null)) == null) ? null : StringsKt.toIntOrNull(strSubstringBefore$default));
        Double voteAverage = $movie.getVoteAverage();
        if ((voteAverage != null ? voteAverage.doubleValue() : 0.0d) >= 8.0d) {
            searchQuality = SearchQuality.HD;
        } else {
            Double voteAverage2 = $movie.getVoteAverage();
            if ((voteAverage2 != null ? voteAverage2.doubleValue() : 0.0d) >= 7.0d) {
                searchQuality = SearchQuality.HD;
            }
        }
        $this$newMovieSearchResponse.setQuality(searchQuality);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMainPage$lambda$1$0(MovieResult $movie, MovieSearchResponse $this$newMovieSearchResponse) {
        String strSubstringBefore$default;
        $this$newMovieSearchResponse.setPosterUrl($movie.getPosterPath());
        String releaseDate = $movie.getReleaseDate();
        if (releaseDate == null) {
            releaseDate = $movie.getFirstAirDate();
        }
        SearchQuality searchQuality = null;
        $this$newMovieSearchResponse.setYear((releaseDate == null || (strSubstringBefore$default = StringsKt.substringBefore$default(releaseDate, "-", (String) null, 2, (Object) null)) == null) ? null : StringsKt.toIntOrNull(strSubstringBefore$default));
        Double voteAverage = $movie.getVoteAverage();
        if ((voteAverage != null ? voteAverage.doubleValue() : 0.0d) >= 8.0d) {
            searchQuality = SearchQuality.HD;
        } else {
            Double voteAverage2 = $movie.getVoteAverage();
            if ((voteAverage2 != null ? voteAverage2.doubleValue() : 0.0d) >= 7.0d) {
                searchQuality = SearchQuality.HD;
            }
        }
        $this$newMovieSearchResponse.setQuality(searchQuality);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMainPage$lambda$4$0$0(MovieResult $movie, MovieSearchResponse $this$newMovieSearchResponse) {
        String strSubstringBefore$default;
        $this$newMovieSearchResponse.setPosterUrl($movie.getPosterPath());
        String releaseDate = $movie.getReleaseDate();
        if (releaseDate == null) {
            releaseDate = $movie.getFirstAirDate();
        }
        SearchQuality searchQuality = null;
        $this$newMovieSearchResponse.setYear((releaseDate == null || (strSubstringBefore$default = StringsKt.substringBefore$default(releaseDate, "-", (String) null, 2, (Object) null)) == null) ? null : StringsKt.toIntOrNull(strSubstringBefore$default));
        Double voteAverage = $movie.getVoteAverage();
        if ((voteAverage != null ? voteAverage.doubleValue() : 0.0d) >= 8.0d) {
            searchQuality = SearchQuality.HD;
        } else {
            Double voteAverage2 = $movie.getVoteAverage();
            if ((voteAverage2 != null ? voteAverage2.doubleValue() : 0.0d) >= 7.0d) {
                searchQuality = SearchQuality.HD;
            }
        }
        $this$newMovieSearchResponse.setQuality(searchQuality);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMainPage$lambda$5$0(SeriesResult $series, TvSeriesSearchResponse $this$newTvSeriesSearchResponse) {
        $this$newTvSeriesSearchResponse.setPosterUrl($series.getPosterPath());
        SearchQuality searchQuality = null;
        $this$newTvSeriesSearchResponse.setYear(StringsKt.toIntOrNull(StringsKt.substringBefore$default($series.getFirstAirDate(), "-", (String) null, 2, (Object) null)));
        if ($series.getVoteAverage() >= 8.0d || $series.getVoteAverage() >= 7.0d) {
            searchQuality = SearchQuality.HD;
        }
        $this$newTvSeriesSearchResponse.setQuality(searchQuality);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMainPage$lambda$6$0(SeriesResult $series, TvSeriesSearchResponse $this$newTvSeriesSearchResponse) {
        $this$newTvSeriesSearchResponse.setPosterUrl($series.getPosterPath());
        SearchQuality searchQuality = null;
        $this$newTvSeriesSearchResponse.setYear(StringsKt.toIntOrNull(StringsKt.substringBefore$default($series.getFirstAirDate(), "-", (String) null, 2, (Object) null)));
        if ($series.getVoteAverage() >= 8.0d || $series.getVoteAverage() >= 7.0d) {
            searchQuality = SearchQuality.HD;
        }
        $this$newTvSeriesSearchResponse.setQuality(searchQuality);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMainPage$lambda$9$0$0(SeriesResult $series, TvSeriesSearchResponse $this$newTvSeriesSearchResponse) {
        $this$newTvSeriesSearchResponse.setPosterUrl($series.getPosterPath());
        SearchQuality searchQuality = null;
        $this$newTvSeriesSearchResponse.setYear(StringsKt.toIntOrNull(StringsKt.substringBefore$default($series.getFirstAirDate(), "-", (String) null, 2, (Object) null)));
        if ($series.getVoteAverage() >= 8.0d || $series.getVoteAverage() >= 7.0d) {
            searchQuality = SearchQuality.HD;
        }
        $this$newTvSeriesSearchResponse.setQuality(searchQuality);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.fasterxml.jackson.databind.RuntimeJsonMappingException */
    /* JADX WARN: Code duplicated, block: B:23:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:25:0x0107  */
    /* JADX WARN: Code duplicated, block: B:26:0x0116  */
    /* JADX WARN: Code duplicated, block: B:29:0x0125  */
    /* JADX WARN: Code duplicated, block: B:31:0x0174 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:32:0x0175  */
    /* JADX WARN: Code duplicated, block: B:35:0x0195  */
    /* JADX WARN: Code duplicated, block: B:37:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:38:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:41:0x01db  */
    /* JADX WARN: Code duplicated, block: B:44:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:46:0x0206  */
    /* JADX WARN: Code duplicated, block: B:53:0x0254  */
    /* JADX WARN: Code duplicated, block: B:55:0x0266  */
    /* JADX WARN: Code duplicated, block: B:63:0x020e A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:67:0x026e A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) throws RuntimeJsonMappingException {
        C00051 c00051;
        ArrayList searchResults;
        String movieSearchUrl;
        Object withCustomHeaders;
        String movieResponseText;
        Object $this$checkTypeMismatch$iv$iv;
        MultiSearchResponse movieSearchData;
        Object withCustomHeaders2;
        MultiSearchResponse movieSearchData2;
        List searchResults2;
        String qualifiedName;
        Object $this$checkTypeMismatch$iv$iv2;
        MultiSearchResponse tvSearchData;
        Iterable $this$forEach$iv;
        int $i$f$forEach;
        String name;
        String title;
        String qualifiedName2;
        String query2 = query;
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
        Object $result = c00051.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00051.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (INSTANCE.isCsGuardBlocked()) {
                    INSTANCE.showCsGuardToast(context);
                    return CollectionsKt.emptyList();
                }
                searchResults = new ArrayList();
                movieSearchUrl = getMainUrl() + "/api/3/search/movie?api_key=" + this.apiKey + "&language=en&page=1&query=" + query2;
                c00051.L$0 = query2;
                c00051.L$1 = searchResults;
                c00051.L$2 = SpillingKt.nullOutSpilledVariable(movieSearchUrl);
                c00051.label = 1;
                withCustomHeaders = getWithCustomHeaders(movieSearchUrl, c00051);
                if (withCustomHeaders == coroutine_suspended) {
                    return coroutine_suspended;
                }
                movieResponseText = (String) withCustomHeaders;
                ObjectMapper $this$readValue$iv = this.mapper;
                $this$checkTypeMismatch$iv$iv = $this$readValue$iv.readValue(movieResponseText, new TypeReference<MultiSearchResponse>() { // from class: com.cncverse.DoFlixProvider$search$$inlined$readValue$1
                });
                if (!($this$checkTypeMismatch$iv$iv instanceof MultiSearchResponse)) {
                    StringBuilder sbAppend = new StringBuilder().append("Deserialized value did not match the specified type; specified ").append(Reflection.getOrCreateKotlinClass(MultiSearchResponse.class).getQualifiedName()).append("(non-null)").append(" but was ");
                    if ($this$checkTypeMismatch$iv$iv != null) {
                        qualifiedName = Reflection.getOrCreateKotlinClass($this$checkTypeMismatch$iv$iv.getClass()).getQualifiedName();
                    } else {
                        qualifiedName = null;
                    }
                    throw new RuntimeJsonMappingException(sbAppend.append(qualifiedName).toString());
                }
                movieSearchData = (MultiSearchResponse) $this$checkTypeMismatch$iv$iv;
                String tvSearchUrl = getMainUrl() + "/api/3/search/tv?api_key=" + this.apiKey + "&language=en&page=1&query=" + query2;
                c00051.L$0 = SpillingKt.nullOutSpilledVariable(query2);
                c00051.L$1 = searchResults;
                c00051.L$2 = SpillingKt.nullOutSpilledVariable(movieSearchUrl);
                c00051.L$3 = SpillingKt.nullOutSpilledVariable(movieResponseText);
                c00051.L$4 = movieSearchData;
                c00051.L$5 = SpillingKt.nullOutSpilledVariable(tvSearchUrl);
                c00051.label = 2;
                withCustomHeaders2 = getWithCustomHeaders(tvSearchUrl, c00051);
                if (withCustomHeaders2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                List list = searchResults;
                movieSearchData2 = movieSearchData;
                searchResults2 = list;
                String tvResponseText = (String) withCustomHeaders2;
                ObjectMapper $this$readValue$iv2 = this.mapper;
                $this$checkTypeMismatch$iv$iv2 = $this$readValue$iv2.readValue(tvResponseText, new TypeReference<MultiSearchResponse>() { // from class: com.cncverse.DoFlixProvider$search$$inlined$readValue$2
                });
                if (!($this$checkTypeMismatch$iv$iv2 instanceof MultiSearchResponse)) {
                    StringBuilder sbAppend2 = new StringBuilder().append("Deserialized value did not match the specified type; specified ").append(Reflection.getOrCreateKotlinClass(MultiSearchResponse.class).getQualifiedName()).append("(non-null)").append(" but was ");
                    if ($this$checkTypeMismatch$iv$iv2 != null) {
                        qualifiedName2 = Reflection.getOrCreateKotlinClass($this$checkTypeMismatch$iv$iv2.getClass()).getQualifiedName();
                    } else {
                        qualifiedName2 = null;
                    }
                    throw new RuntimeJsonMappingException(sbAppend2.append(qualifiedName2).toString());
                }
                tvSearchData = (MultiSearchResponse) $this$checkTypeMismatch$iv$iv2;
                for (Object element$iv : movieSearchData2.getResults()) {
                    final MovieResult result = (MovieResult) element$iv;
                    DoFlixProvider doFlixProvider = this;
                    title = result.getTitle();
                    if (title != null && (title = result.getName()) == null) {
                        title = "Unknown";
                    }
                    MultiSearchResponse tvSearchData2 = tvSearchData;
                    MovieSearchResponse movieResult = MainAPIKt.newMovieSearchResponse$default(doFlixProvider, title, "movie," + result.getId(), TvType.Movie, false, new Function1() { // from class: com.cncverse.DoFlixProvider$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj) {
                            return DoFlixProvider.search$lambda$0$0(result, (MovieSearchResponse) obj);
                        }
                    }, 8, (Object) null);
                    searchResults2.add(movieResult);
                    tvSearchData = tvSearchData2;
                }
                $this$forEach$iv = tvSearchData.getResults();
                $i$f$forEach = 0;
                for (Object element$iv2 : $this$forEach$iv) {
                    final MovieResult result2 = (MovieResult) element$iv2;
                    DoFlixProvider doFlixProvider2 = this;
                    name = result2.getName();
                    if (name != null && (name = result2.getTitle()) == null) {
                        name = "Unknown";
                    }
                    Iterable $this$forEach$iv2 = $this$forEach$iv;
                    TvSeriesSearchResponse seriesResult = MainAPIKt.newTvSeriesSearchResponse$default(doFlixProvider2, name, "tvseries," + result2.getId(), TvType.TvSeries, false, new Function1() { // from class: com.cncverse.DoFlixProvider$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj) {
                            return DoFlixProvider.search$lambda$1$0(result2, (TvSeriesSearchResponse) obj);
                        }
                    }, 8, (Object) null);
                    searchResults2.add(seriesResult);
                    $this$forEach$iv = $this$forEach$iv2;
                    $i$f$forEach = $i$f$forEach;
                }
                return searchResults2;
            case 1:
                String movieSearchUrl2 = (String) c00051.L$2;
                List searchResults3 = (List) c00051.L$1;
                query2 = (String) c00051.L$0;
                ResultKt.throwOnFailure($result);
                movieSearchUrl = movieSearchUrl2;
                searchResults = searchResults3;
                withCustomHeaders = $result;
                movieResponseText = (String) withCustomHeaders;
                ObjectMapper $this$readValue$iv3 = this.mapper;
                $this$checkTypeMismatch$iv$iv = $this$readValue$iv3.readValue(movieResponseText, new TypeReference<MultiSearchResponse>() { // from class: com.cncverse.DoFlixProvider$search$$inlined$readValue$1
                });
                if (!($this$checkTypeMismatch$iv$iv instanceof MultiSearchResponse)) {
                    StringBuilder sbAppend3 = new StringBuilder().append("Deserialized value did not match the specified type; specified ").append(Reflection.getOrCreateKotlinClass(MultiSearchResponse.class).getQualifiedName()).append("(non-null)").append(" but was ");
                    if ($this$checkTypeMismatch$iv$iv != null) {
                        qualifiedName = Reflection.getOrCreateKotlinClass($this$checkTypeMismatch$iv$iv.getClass()).getQualifiedName();
                    } else {
                        qualifiedName = null;
                    }
                    throw new RuntimeJsonMappingException(sbAppend3.append(qualifiedName).toString());
                }
                movieSearchData = (MultiSearchResponse) $this$checkTypeMismatch$iv$iv;
                String tvSearchUrl2 = getMainUrl() + "/api/3/search/tv?api_key=" + this.apiKey + "&language=en&page=1&query=" + query2;
                c00051.L$0 = SpillingKt.nullOutSpilledVariable(query2);
                c00051.L$1 = searchResults;
                c00051.L$2 = SpillingKt.nullOutSpilledVariable(movieSearchUrl);
                c00051.L$3 = SpillingKt.nullOutSpilledVariable(movieResponseText);
                c00051.L$4 = movieSearchData;
                c00051.L$5 = SpillingKt.nullOutSpilledVariable(tvSearchUrl2);
                c00051.label = 2;
                withCustomHeaders2 = getWithCustomHeaders(tvSearchUrl2, c00051);
                if (withCustomHeaders2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                List list2 = searchResults;
                movieSearchData2 = movieSearchData;
                searchResults2 = list2;
                String tvResponseText2 = (String) withCustomHeaders2;
                ObjectMapper $this$readValue$iv4 = this.mapper;
                $this$checkTypeMismatch$iv$iv2 = $this$readValue$iv4.readValue(tvResponseText2, new TypeReference<MultiSearchResponse>() { // from class: com.cncverse.DoFlixProvider$search$$inlined$readValue$2
                });
                if (!($this$checkTypeMismatch$iv$iv2 instanceof MultiSearchResponse)) {
                    StringBuilder sbAppend4 = new StringBuilder().append("Deserialized value did not match the specified type; specified ").append(Reflection.getOrCreateKotlinClass(MultiSearchResponse.class).getQualifiedName()).append("(non-null)").append(" but was ");
                    if ($this$checkTypeMismatch$iv$iv2 != null) {
                        qualifiedName2 = Reflection.getOrCreateKotlinClass($this$checkTypeMismatch$iv$iv2.getClass()).getQualifiedName();
                    } else {
                        qualifiedName2 = null;
                    }
                    throw new RuntimeJsonMappingException(sbAppend4.append(qualifiedName2).toString());
                }
                tvSearchData = (MultiSearchResponse) $this$checkTypeMismatch$iv$iv2;
                while (r9.hasNext()) {
                    final MovieResult result3 = (MovieResult) element$iv;
                    DoFlixProvider doFlixProvider3 = this;
                    title = result3.getTitle();
                    if (title != null) {
                    }
                    MultiSearchResponse tvSearchData3 = tvSearchData;
                    MovieSearchResponse movieResult2 = MainAPIKt.newMovieSearchResponse$default(doFlixProvider3, title, "movie," + result3.getId(), TvType.Movie, false, new Function1() { // from class: com.cncverse.DoFlixProvider$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj) {
                            return DoFlixProvider.search$lambda$0$0(result3, (MovieSearchResponse) obj);
                        }
                    }, 8, (Object) null);
                    searchResults2.add(movieResult2);
                    tvSearchData = tvSearchData3;
                }
                $this$forEach$iv = tvSearchData.getResults();
                $i$f$forEach = 0;
                while (r8.hasNext()) {
                    final MovieResult result4 = (MovieResult) element$iv2;
                    DoFlixProvider doFlixProvider4 = this;
                    name = result4.getName();
                    if (name != null) {
                    }
                    Iterable $this$forEach$iv3 = $this$forEach$iv;
                    TvSeriesSearchResponse seriesResult2 = MainAPIKt.newTvSeriesSearchResponse$default(doFlixProvider4, name, "tvseries," + result4.getId(), TvType.TvSeries, false, new Function1() { // from class: com.cncverse.DoFlixProvider$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj) {
                            return DoFlixProvider.search$lambda$1$0(result4, (TvSeriesSearchResponse) obj);
                        }
                    }, 8, (Object) null);
                    searchResults2.add(seriesResult2);
                    $this$forEach$iv = $this$forEach$iv3;
                    $i$f$forEach = $i$f$forEach;
                }
                return searchResults2;
            case 2:
                movieSearchData2 = (MultiSearchResponse) c00051.L$4;
                List searchResults4 = (List) c00051.L$1;
                query2 = (String) c00051.L$0;
                ResultKt.throwOnFailure($result);
                searchResults2 = searchResults4;
                withCustomHeaders2 = $result;
                String tvResponseText3 = (String) withCustomHeaders2;
                ObjectMapper $this$readValue$iv5 = this.mapper;
                $this$checkTypeMismatch$iv$iv2 = $this$readValue$iv5.readValue(tvResponseText3, new TypeReference<MultiSearchResponse>() { // from class: com.cncverse.DoFlixProvider$search$$inlined$readValue$2
                });
                if (!($this$checkTypeMismatch$iv$iv2 instanceof MultiSearchResponse)) {
                    StringBuilder sbAppend5 = new StringBuilder().append("Deserialized value did not match the specified type; specified ").append(Reflection.getOrCreateKotlinClass(MultiSearchResponse.class).getQualifiedName()).append("(non-null)").append(" but was ");
                    if ($this$checkTypeMismatch$iv$iv2 != null) {
                        qualifiedName2 = Reflection.getOrCreateKotlinClass($this$checkTypeMismatch$iv$iv2.getClass()).getQualifiedName();
                    } else {
                        qualifiedName2 = null;
                    }
                    throw new RuntimeJsonMappingException(sbAppend5.append(qualifiedName2).toString());
                }
                tvSearchData = (MultiSearchResponse) $this$checkTypeMismatch$iv$iv2;
                while (r9.hasNext()) {
                    final MovieResult result5 = (MovieResult) element$iv;
                    DoFlixProvider doFlixProvider5 = this;
                    title = result5.getTitle();
                    if (title != null) {
                    }
                    MultiSearchResponse tvSearchData4 = tvSearchData;
                    MovieSearchResponse movieResult3 = MainAPIKt.newMovieSearchResponse$default(doFlixProvider5, title, "movie," + result5.getId(), TvType.Movie, false, new Function1() { // from class: com.cncverse.DoFlixProvider$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj) {
                            return DoFlixProvider.search$lambda$0$0(result5, (MovieSearchResponse) obj);
                        }
                    }, 8, (Object) null);
                    searchResults2.add(movieResult3);
                    tvSearchData = tvSearchData4;
                }
                $this$forEach$iv = tvSearchData.getResults();
                $i$f$forEach = 0;
                while (r8.hasNext()) {
                    final MovieResult result6 = (MovieResult) element$iv2;
                    DoFlixProvider doFlixProvider6 = this;
                    name = result6.getName();
                    if (name != null) {
                    }
                    Iterable $this$forEach$iv4 = $this$forEach$iv;
                    TvSeriesSearchResponse seriesResult3 = MainAPIKt.newTvSeriesSearchResponse$default(doFlixProvider6, name, "tvseries," + result6.getId(), TvType.TvSeries, false, new Function1() { // from class: com.cncverse.DoFlixProvider$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj) {
                            return DoFlixProvider.search$lambda$1$0(result6, (TvSeriesSearchResponse) obj);
                        }
                    }, 8, (Object) null);
                    searchResults2.add(seriesResult3);
                    $this$forEach$iv = $this$forEach$iv4;
                    $i$f$forEach = $i$f$forEach;
                }
                return searchResults2;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit search$lambda$0$0(MovieResult $result, MovieSearchResponse $this$newMovieSearchResponse) {
        String strSubstringBefore$default;
        $this$newMovieSearchResponse.setPosterUrl($result.getPosterPath());
        String releaseDate = $result.getReleaseDate();
        Integer intOrNull = null;
        if (releaseDate != null && (strSubstringBefore$default = StringsKt.substringBefore$default(releaseDate, "-", (String) null, 2, (Object) null)) != null) {
            intOrNull = StringsKt.toIntOrNull(strSubstringBefore$default);
        }
        $this$newMovieSearchResponse.setYear(intOrNull);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit search$lambda$1$0(MovieResult $result, TvSeriesSearchResponse $this$newTvSeriesSearchResponse) {
        String strSubstringBefore$default;
        $this$newTvSeriesSearchResponse.setPosterUrl($result.getPosterPath());
        String firstAirDate = $result.getFirstAirDate();
        Integer intOrNull = null;
        if (firstAirDate != null && (strSubstringBefore$default = StringsKt.substringBefore$default(firstAirDate, "-", (String) null, 2, (Object) null)) != null) {
            intOrNull = StringsKt.toIntOrNull(strSubstringBefore$default);
        }
        $this$newTvSeriesSearchResponse.setYear(intOrNull);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:69:0x03ab  */
    /* JADX WARN: Code duplicated, block: B:74:0x0421 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:75:0x0422  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:82:0x045e A[Catch: Exception -> 0x053b, TryCatch #1 {Exception -> 0x053b, blocks: (B:80:0x0451, B:82:0x045e, B:84:0x0488, B:86:0x049c, B:87:0x04a9, B:88:0x04aa, B:89:0x04be, B:91:0x04c4), top: B:113:0x0451 }] */
    /* JADX WARN: Code duplicated, block: B:84:0x0488 A[Catch: Exception -> 0x053b, TryCatch #1 {Exception -> 0x053b, blocks: (B:80:0x0451, B:82:0x045e, B:84:0x0488, B:86:0x049c, B:87:0x04a9, B:88:0x04aa, B:89:0x04be, B:91:0x04c4), top: B:113:0x0451 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x049b  */
    /* JADX WARN: Code duplicated, block: B:88:0x04aa A[Catch: Exception -> 0x053b, TryCatch #1 {Exception -> 0x053b, blocks: (B:80:0x0451, B:82:0x045e, B:84:0x0488, B:86:0x049c, B:87:0x04a9, B:88:0x04aa, B:89:0x04be, B:91:0x04c4), top: B:113:0x0451 }] */
    /* JADX WARN: Code duplicated, block: B:91:0x04c4 A[Catch: Exception -> 0x053b, TRY_LEAVE, TryCatch #1 {Exception -> 0x053b, blocks: (B:80:0x0451, B:82:0x045e, B:84:0x0488, B:86:0x049c, B:87:0x04a9, B:88:0x04aa, B:89:0x04be, B:91:0x04c4), top: B:113:0x0451 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:101:0x056e -> B:104:0x0586). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:103:0x057b -> B:104:0x0586). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x0422 -> B:117:0x0434). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object load(@org.jetbrains.annotations.NotNull java.lang.String r33, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r34) {
        /*
            Method dump skipped, instruction units count: 1554
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cncverse.DoFlixProvider.load(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.cncverse.DoFlixProvider$load$2 */
    /* JADX INFO: compiled from: DoFlixProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.DoFlixProvider$load$2", f = "DoFlixProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nDoFlixProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DoFlixProvider.kt\ncom/cncverse/DoFlixProvider$load$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1126:1\n1586#2:1127\n1661#2,3:1128\n1586#2:1131\n1661#2,3:1132\n1586#2:1135\n1661#2,3:1136\n*S KotlinDebug\n*F\n+ 1 DoFlixProvider.kt\ncom/cncverse/DoFlixProvider$load$2\n*L\n714#1:1127\n714#1:1128,3\n718#1:1131\n718#1:1132,3\n726#1:1135\n726#1:1136,3\n*E\n"})
    static final class C00022 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ MovieDetails $details;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DoFlixProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00022(MovieDetails movieDetails, DoFlixProvider doFlixProvider, Continuation<? super C00022> continuation) {
            super(2, continuation);
            this.$details = movieDetails;
            this.this$0 = doFlixProvider;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00022 = new C00022(this.$details, this.this$0, continuation);
            c00022.L$0 = obj;
            return c00022;
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
                    $this$newMovieLoadResponse.setPosterUrl(this.$details.getPosterPath());
                    $this$newMovieLoadResponse.setBackgroundPosterUrl(this.$details.getBackdropPath());
                    $this$newMovieLoadResponse.setYear(StringsKt.toIntOrNull(StringsKt.substringBefore$default(this.$details.getReleaseDate(), "-", (String) null, 2, (Object) null)));
                    $this$newMovieLoadResponse.setPlot(this.$details.getOverview());
                    Iterable $this$map$iv = this.$details.getGenres();
                    Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    for (Object item$iv$iv : $this$map$iv) {
                        TMDBGenre it = (TMDBGenre) item$iv$iv;
                        destination$iv$iv.add(it.getName());
                    }
                    $this$newMovieLoadResponse.setTags((List) destination$iv$iv);
                    $this$newMovieLoadResponse.setDuration(Boxing.boxInt(this.$details.getRuntime()));
                    Iterable $this$map$iv2 = CollectionsKt.take(this.$details.getCredits().getCast(), 10);
                    Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                    for (Object item$iv$iv2 : $this$map$iv2) {
                        CastMember cast = (CastMember) item$iv$iv2;
                        destination$iv$iv2.add(new ActorData(new Actor(cast.getName(), cast.getProfilePath()), (ActorRole) null, cast.getCharacter(), (Actor) null, 10, (DefaultConstructorMarker) null));
                    }
                    $this$newMovieLoadResponse.setActors((List) destination$iv$iv2);
                    Iterable $this$map$iv3 = CollectionsKt.take(this.$details.getSimilar().getResults(), 10);
                    DoFlixProvider doFlixProvider = this.this$0;
                    Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                    for (Object item$iv$iv3 : $this$map$iv3) {
                        final MovieResult item = (MovieResult) item$iv$iv3;
                        DoFlixProvider doFlixProvider2 = doFlixProvider;
                        String title = item.getTitle();
                        if (title == null && (title = item.getName()) == null) {
                            title = "Unknown";
                        }
                        destination$iv$iv3.add(MainAPIKt.newMovieSearchResponse$default(doFlixProvider2, title, "movie," + item.getId(), TvType.Movie, false, new Function1() { // from class: com.cncverse.DoFlixProvider$load$2$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj) {
                                return DoFlixProvider.C00022.invokeSuspend$lambda$2$0(item, (MovieSearchResponse) obj);
                            }
                        }, 8, (Object) null));
                    }
                    $this$newMovieLoadResponse.setRecommendations((List) destination$iv$iv3);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$2$0(MovieResult $item, MovieSearchResponse $this$newMovieSearchResponse) {
            String strSubstringBefore$default;
            $this$newMovieSearchResponse.setPosterUrl($item.getPosterPath());
            String releaseDate = $item.getReleaseDate();
            if (releaseDate == null) {
                releaseDate = $item.getFirstAirDate();
            }
            Integer intOrNull = null;
            if (releaseDate != null && (strSubstringBefore$default = StringsKt.substringBefore$default(releaseDate, "-", (String) null, 2, (Object) null)) != null) {
                intOrNull = StringsKt.toIntOrNull(strSubstringBefore$default);
            }
            $this$newMovieSearchResponse.setYear(intOrNull);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$1$0(TvEpisode $ep, SeasonInfo $season, Episode $this$newEpisode) {
        $this$newEpisode.setName($ep.getName());
        $this$newEpisode.setSeason(Integer.valueOf($season.getSeasonNumber()));
        $this$newEpisode.setEpisode(Integer.valueOf($ep.getEpisodeNumber()));
        $this$newEpisode.setPosterUrl($ep.getStillPath());
        $this$newEpisode.setDescription($ep.getOverview());
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.cncverse.DoFlixProvider$load$5 */
    /* JADX INFO: compiled from: DoFlixProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.DoFlixProvider$load$5", f = "DoFlixProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nDoFlixProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DoFlixProvider.kt\ncom/cncverse/DoFlixProvider$load$5\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1126:1\n1586#2:1127\n1661#2,3:1128\n1586#2:1131\n1661#2,3:1132\n1586#2:1135\n1661#2,3:1136\n*S KotlinDebug\n*F\n+ 1 DoFlixProvider.kt\ncom/cncverse/DoFlixProvider$load$5\n*L\n778#1:1127\n778#1:1128,3\n781#1:1131\n781#1:1132,3\n789#1:1135\n789#1:1136,3\n*E\n"})
    static final class C00035 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ TvDetails $details;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DoFlixProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00035(TvDetails tvDetails, DoFlixProvider doFlixProvider, Continuation<? super C00035> continuation) {
            super(2, continuation);
            this.$details = tvDetails;
            this.this$0 = doFlixProvider;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00035 = new C00035(this.$details, this.this$0, continuation);
            c00035.L$0 = obj;
            return c00035;
        }

        public final Object invoke(TvSeriesLoadResponse tvSeriesLoadResponse, Continuation<? super Unit> continuation) {
            return create(tvSeriesLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            ArrayList arrayList;
            List<MovieResult> results;
            Iterable iterableTake;
            TvSeriesLoadResponse $this$newTvSeriesLoadResponse = (TvSeriesLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$newTvSeriesLoadResponse.setPosterUrl(this.$details.getPosterPath());
                    $this$newTvSeriesLoadResponse.setBackgroundPosterUrl(this.$details.getBackdropPath());
                    $this$newTvSeriesLoadResponse.setYear(StringsKt.toIntOrNull(StringsKt.substringBefore$default(this.$details.getFirstAirDate(), "-", (String) null, 2, (Object) null)));
                    $this$newTvSeriesLoadResponse.setPlot(this.$details.getOverview());
                    Iterable $this$map$iv = this.$details.getGenres();
                    Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    for (Object item$iv$iv : $this$map$iv) {
                        TMDBGenre it = (TMDBGenre) item$iv$iv;
                        destination$iv$iv.add(it.getName());
                    }
                    $this$newTvSeriesLoadResponse.setTags((List) destination$iv$iv);
                    Iterable $this$map$iv2 = CollectionsKt.take(this.$details.getCredits().getCast(), 10);
                    Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                    for (Object item$iv$iv2 : $this$map$iv2) {
                        CastMember cast = (CastMember) item$iv$iv2;
                        destination$iv$iv2.add(new ActorData(new Actor(cast.getName(), cast.getProfilePath()), (ActorRole) null, cast.getCharacter(), (Actor) null, 10, (DefaultConstructorMarker) null));
                    }
                    $this$newTvSeriesLoadResponse.setActors((List) destination$iv$iv2);
                    SimilarResults similar = this.$details.getSimilar();
                    if (similar == null || (results = similar.getResults()) == null || (iterableTake = CollectionsKt.take(results, 10)) == null) {
                        arrayList = null;
                    } else {
                        Iterable $this$map$iv3 = iterableTake;
                        DoFlixProvider doFlixProvider = this.this$0;
                        Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                        for (Object item$iv$iv3 : $this$map$iv3) {
                            final MovieResult item = (MovieResult) item$iv$iv3;
                            DoFlixProvider doFlixProvider2 = doFlixProvider;
                            String name = item.getName();
                            if (name == null && (name = item.getTitle()) == null) {
                                name = "Unknown";
                            }
                            destination$iv$iv3.add(MainAPIKt.newTvSeriesSearchResponse$default(doFlixProvider2, name, "tvseries," + item.getId(), TvType.TvSeries, false, new Function1() { // from class: com.cncverse.DoFlixProvider$load$5$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj) {
                                    return DoFlixProvider.C00035.invokeSuspend$lambda$2$0(item, (TvSeriesSearchResponse) obj);
                                }
                            }, 8, (Object) null));
                        }
                        arrayList = (List) destination$iv$iv3;
                    }
                    $this$newTvSeriesLoadResponse.setRecommendations(arrayList);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$2$0(MovieResult $item, TvSeriesSearchResponse $this$newTvSeriesSearchResponse) {
            String strSubstringBefore$default;
            $this$newTvSeriesSearchResponse.setPosterUrl($item.getPosterPath());
            String firstAirDate = $item.getFirstAirDate();
            if (firstAirDate == null) {
                firstAirDate = $item.getReleaseDate();
            }
            Integer intOrNull = null;
            if (firstAirDate != null && (strSubstringBefore$default = StringsKt.substringBefore$default(firstAirDate, "-", (String) null, 2, (Object) null)) != null) {
                intOrNull = StringsKt.toIntOrNull(strSubstringBefore$default);
            }
            $this$newTvSeriesSearchResponse.setYear(intOrNull);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:61:0x02e3  */
    /* JADX WARN: Code duplicated, block: B:63:0x037c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:64:0x037d  */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x037d -> B:65:0x0394). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:88:0x05a8 -> B:89:0x05c5). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object loadLinks(@org.jetbrains.annotations.NotNull java.lang.String r33, boolean r34, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r35, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r36, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r37) {
        /*
            Method dump skipped, instruction units count: 1560
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cncverse.DoFlixProvider.loadLinks(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadLinks$lambda$0$0(Context $_ctx) {
        Toast.makeText($_ctx, "⚠️(Opening ads) Subscription expired. If you have renewed your subscription, please re-verify it in Subscription Manager.", 1).show();
    }

    private final void showSubscriptionPopupIfNeeded() {
        final Context ctx = context;
        if (ctx == null || subscriptionPopupShown) {
            return;
        }
        try {
            boolean isTV = Globals.INSTANCE.isLayout(2);
            if (isTV) {
                return;
            }
        } catch (Exception e) {
        }
        SharedPreferences sharedPreferences = ctx.getSharedPreferences("CNCVerseSubscription", 0);
        boolean isSubscribed = Intrinsics.areEqual(sharedPreferences != null ? sharedPreferences.getString("mode", "ads") : null, "subscription");
        if (isSubscribed) {
            return;
        }
        SharedPreferences _dontShowPrefs = ctx.getSharedPreferences("CNCVerseSubscription", 0);
        if (_dontShowPrefs.getBoolean("dont_show_ads_popup", false)) {
            subscriptionPopupShown = true;
        } else {
            subscriptionPopupShown = true;
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.DoFlixProvider$$ExternalSyntheticLambda15
                @Override // java.lang.Runnable
                public final void run() {
                    DoFlixProvider.showSubscriptionPopupIfNeeded$lambda$0(ctx);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSubscriptionPopupIfNeeded$lambda$0(final Context $ctx) {
        try {
            float dp = $ctx.getResources().getDisplayMetrics().density;
            GradientDrawable $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u240 = new GradientDrawable();
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u240.setColor(Color.parseColor("#1A1A2E"));
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u240.setCornerRadius(16.0f * dp);
            LinearLayout root = new LinearLayout($ctx);
            root.setOrientation(1);
            float f = 24;
            root.setPadding((int) (f * dp), (int) (20 * dp), (int) (f * dp), (int) (16 * dp));
            root.setBackground($this$showSubscriptionPopupIfNeeded_u24lambda_u240_u240);
            TextView $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u242 = new TextView($ctx);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u242.setText("📺 You're in Ads Mode");
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u242.setTextColor(-1);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u242.setTextSize(17.0f);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u242.setTypeface(Typeface.DEFAULT_BOLD);
            LinearLayout.LayoutParams it = new LinearLayout.LayoutParams(-1, -2);
            it.bottomMargin = (int) (8 * dp);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u242.setLayoutParams(it);
            View divider = new View($ctx);
            divider.setBackgroundColor(Color.parseColor("#2D2D4A"));
            LinearLayout.LayoutParams it2 = new LinearLayout.LayoutParams(-1, 1);
            it2.bottomMargin = (int) (12 * dp);
            divider.setLayoutParams(it2);
            TextView $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u244 = new TextView($ctx);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u244.setText("All CNCVerse extensions currently run with ads.\n\nSubscribe to remove ads from just ₹20/month.\n\nManage via Settings > Extensions > CNCVerse Cloudstream Repo > Subscription Manager.");
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u244.setTextColor(Color.parseColor("#A0A0A8"));
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u244.setTextSize(14.0f);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u244.setLineSpacing(0.0f, 1.4f);
            LinearLayout.LayoutParams it3 = new LinearLayout.LayoutParams(-1, -2);
            it3.bottomMargin = (int) (18 * dp);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u244.setLayoutParams(it3);
            LinearLayout btnRow = new LinearLayout($ctx);
            btnRow.setOrientation(0);
            btnRow.setGravity(8388613);
            TextView laterTv = new TextView($ctx);
            laterTv.setText("Maybe Later");
            laterTv.setTextColor(Color.parseColor("#808090"));
            laterTv.setTextSize(14.0f);
            float f2 = 10;
            int p = (int) (f2 * dp);
            laterTv.setPadding(p, p, p, p);
            laterTv.setClickable(true);
            laterTv.setFocusable(true);
            TextView subscribeTv = new TextView($ctx);
            subscribeTv.setText("Subscribe Now");
            subscribeTv.setTextColor(Color.parseColor("#A78BFA"));
            subscribeTv.setTextSize(14.0f);
            subscribeTv.setTypeface(Typeface.DEFAULT_BOLD);
            int p2 = (int) (f2 * dp);
            subscribeTv.setPadding(p2, p2, 0, p2);
            subscribeTv.setClickable(true);
            subscribeTv.setFocusable(true);
            LinearLayout $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u248 = new LinearLayout($ctx);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u248.setOrientation(0);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u248.setGravity(8388627);
            LinearLayout.LayoutParams it4 = new LinearLayout.LayoutParams(-1, -2);
            it4.bottomMargin = (int) (f2 * dp);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u248.setLayoutParams(it4);
            final CheckBox $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u249 = new CheckBox($ctx);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u249.setChecked(false);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u249.setButtonTintList(ColorStateList.valueOf(Color.parseColor("#A78BFA")));
            TextView $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u2410 = new TextView($ctx);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u2410.setText("Don't show me again");
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u2410.setTextColor(Color.parseColor("#A0A0A8"));
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u2410.setTextSize(13.0f);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u2410.setPadding((int) (6 * dp), 0, 0, 0);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u248.addView($this$showSubscriptionPopupIfNeeded_u24lambda_u240_u249);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u248.addView($this$showSubscriptionPopupIfNeeded_u24lambda_u240_u2410);
            btnRow.addView(laterTv);
            btnRow.addView(subscribeTv);
            root.addView($this$showSubscriptionPopupIfNeeded_u24lambda_u240_u242);
            root.addView(divider);
            root.addView($this$showSubscriptionPopupIfNeeded_u24lambda_u240_u244);
            root.addView($this$showSubscriptionPopupIfNeeded_u24lambda_u240_u248);
            root.addView(btnRow);
            final AlertDialog dialog = new AlertDialog.Builder($ctx).setView(root).setCancelable(true).create();
            Window window = dialog.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
            }
            laterTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.DoFlixProvider$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DoFlixProvider.showSubscriptionPopupIfNeeded$lambda$0$11($this$showSubscriptionPopupIfNeeded_u24lambda_u240_u249, $ctx, dialog, view);
                }
            });
            subscribeTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.DoFlixProvider$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DoFlixProvider.showSubscriptionPopupIfNeeded$lambda$0$12(dialog, $ctx, view);
                }
            });
            dialog.show();
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSubscriptionPopupIfNeeded$lambda$0$11(CheckBox $dontShowCb, Context $ctx, AlertDialog $dialog, View it) {
        if ($dontShowCb.isChecked()) {
            $ctx.getSharedPreferences("CNCVerseSubscription", 0).edit().putBoolean("dont_show_ads_popup", true).apply();
        }
        $dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSubscriptionPopupIfNeeded$lambda$0$12(AlertDialog $dialog, Context $ctx, View it) {
        $dialog.dismiss();
        try {
            Intent i = new Intent("android.intent.action.VIEW", Uri.parse("https://cncverse-sub.pages.dev"));
            i.addFlags(268435456);
            $ctx.startActivity(i);
        } catch (Exception e) {
        }
    }

    private final void showTelegramPopup() {
        final Context ctx;
        if (Globals.INSTANCE.isLayout(2) || (ctx = context) == null || telegramPopupShown) {
            return;
        }
        SharedPreferences prefs = ctx.getSharedPreferences("cncverse_prefs", 0);
        if (prefs.getBoolean("telegram_popup_shown", false)) {
            telegramPopupShown = true;
            return;
        }
        telegramPopupShown = true;
        prefs.edit().putBoolean("telegram_popup_shown", true).apply();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.DoFlixProvider$$ExternalSyntheticLambda17
            @Override // java.lang.Runnable
            public final void run() {
                DoFlixProvider.showTelegramPopup$lambda$0(ctx);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showTelegramPopup$lambda$0(final Context $ctx) {
        try {
            float dp = $ctx.getResources().getDisplayMetrics().density;
            GradientDrawable $this$showTelegramPopup_u24lambda_u240_u240 = new GradientDrawable();
            $this$showTelegramPopup_u24lambda_u240_u240.setColor(Color.parseColor("#1A1A2E"));
            $this$showTelegramPopup_u24lambda_u240_u240.setCornerRadius(16.0f * dp);
            LinearLayout root = new LinearLayout($ctx);
            root.setOrientation(1);
            float f = 24;
            root.setPadding((int) (f * dp), (int) (20 * dp), (int) (f * dp), (int) (16 * dp));
            root.setBackground($this$showTelegramPopup_u24lambda_u240_u240);
            TextView $this$showTelegramPopup_u24lambda_u240_u242 = new TextView($ctx);
            $this$showTelegramPopup_u24lambda_u240_u242.setText("💬 Join CNCVerse Community");
            $this$showTelegramPopup_u24lambda_u240_u242.setTextColor(-1);
            $this$showTelegramPopup_u24lambda_u240_u242.setTextSize(17.0f);
            $this$showTelegramPopup_u24lambda_u240_u242.setTypeface(Typeface.DEFAULT_BOLD);
            LinearLayout.LayoutParams it = new LinearLayout.LayoutParams(-1, -2);
            float f2 = 10;
            it.bottomMargin = (int) (f2 * dp);
            $this$showTelegramPopup_u24lambda_u240_u242.setLayoutParams(it);
            View dividerV = new View($ctx);
            dividerV.setBackgroundColor(Color.parseColor("#2D2D4A"));
            LinearLayout.LayoutParams it2 = new LinearLayout.LayoutParams(-1, 1);
            it2.bottomMargin = (int) (14 * dp);
            dividerV.setLayoutParams(it2);
            TextView $this$showTelegramPopup_u24lambda_u240_u244 = new TextView($ctx);
            $this$showTelegramPopup_u24lambda_u240_u244.setText("Join our Telegram group to discuss and share your opinion!");
            $this$showTelegramPopup_u24lambda_u240_u244.setTextColor(Color.parseColor("#A0A0A8"));
            $this$showTelegramPopup_u24lambda_u240_u244.setTextSize(14.0f);
            $this$showTelegramPopup_u24lambda_u240_u244.setLineSpacing(0.0f, 1.4f);
            LinearLayout.LayoutParams it3 = new LinearLayout.LayoutParams(-1, -2);
            it3.bottomMargin = (int) (18 * dp);
            $this$showTelegramPopup_u24lambda_u240_u244.setLayoutParams(it3);
            LinearLayout btnRow = new LinearLayout($ctx);
            btnRow.setOrientation(0);
            btnRow.setGravity(8388613);
            TextView laterTv = new TextView($ctx);
            laterTv.setText("Later");
            laterTv.setTextColor(Color.parseColor("#808090"));
            laterTv.setTextSize(14.0f);
            int p = (int) (f2 * dp);
            laterTv.setPadding(p, p, p, p);
            laterTv.setClickable(true);
            laterTv.setFocusable(true);
            TextView joinTv = new TextView($ctx);
            joinTv.setText("Join Telegram");
            joinTv.setTextColor(Color.parseColor("#5B9BF5"));
            joinTv.setTextSize(14.0f);
            joinTv.setTypeface(Typeface.DEFAULT_BOLD);
            int p2 = (int) (f2 * dp);
            joinTv.setPadding(p2, p2, 0, p2);
            joinTv.setClickable(true);
            joinTv.setFocusable(true);
            btnRow.addView(laterTv);
            btnRow.addView(joinTv);
            root.addView($this$showTelegramPopup_u24lambda_u240_u242);
            root.addView(dividerV);
            root.addView($this$showTelegramPopup_u24lambda_u240_u244);
            root.addView(btnRow);
            final AlertDialog dialog = new AlertDialog.Builder($ctx).setView(root).setCancelable(true).create();
            Window window = dialog.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
            }
            laterTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.DoFlixProvider$$ExternalSyntheticLambda11
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    dialog.dismiss();
                }
            });
            joinTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.DoFlixProvider$$ExternalSyntheticLambda12
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DoFlixProvider.showTelegramPopup$lambda$0$9(dialog, $ctx, view);
                }
            });
            dialog.show();
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showTelegramPopup$lambda$0$9(AlertDialog $dialog, Context $ctx, View it) {
        $dialog.dismiss();
        try {
            Intent i = new Intent("android.intent.action.VIEW", Uri.parse("https://t.me/cncverse"));
            i.addFlags(268435456);
            $ctx.startActivity(i);
        } catch (Exception e) {
        }
    }

    private final void openInExternalBrowser(final String url) {
        final Context ctx;
        if (Globals.INSTANCE.isLayout(2) || (ctx = context) == null) {
            return;
        }
        long now = System.currentTimeMillis();
        if (now - lastBrowserOpenMs < BROWSER_DEBOUNCE_MS) {
            return;
        }
        lastBrowserOpenMs = now;
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.DoFlixProvider$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                DoFlixProvider.openInExternalBrowser$lambda$0(ctx, url);
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
}
