package com.AniVortex;

import android.util.Log;
import com.lagradost.cloudstream3.ActorData;
import com.lagradost.cloudstream3.AnimeSearchResponse;
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
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvSeriesSearchResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.utils.Qualities;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import com.phisher98.donation.DonationManager;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AniVortexProvider.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/AniVortex/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00052\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050(H\u0082@¢\u0006\u0002\u0010)J \u0010 \u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0096@¢\u0006\u0002\u0010/J \u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u00104J\u001c\u00105\u001a\b\u0012\u0004\u0012\u0002010\u001e2\u0006\u00106\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u00107J\u0018\u00108\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u0005H\u0002J:\u00109\u001a\b\u0012\u0004\u0012\u0002010\u001e2\f\u0010:\u001a\b\u0012\u0004\u0012\u0002010\u001e2\f\u0010;\u001a\b\u0012\u0004\u0012\u0002010\u001e2\u000e\b\u0002\u0010<\u001a\b\u0012\u0004\u0012\u0002010\u001eH\u0002J\u0019\u0010=\u001a\u0004\u0018\u00010>2\b\u0010?\u001a\u0004\u0018\u00010@H\u0002¢\u0006\u0002\u0010AJ\u001e\u0010B\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010\u001e2\u0006\u0010D\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u00107J\u001e\u0010E\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010\u001e2\u0006\u0010D\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u00107J\u0018\u0010F\u001a\u0004\u0018\u00010G2\u0006\u0010&\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u00107JF\u0010H\u001a\u00020\u000e2\u0006\u0010I\u001a\u00020\u00052\u0006\u0010J\u001a\u00020\u000e2\u0012\u0010K\u001a\u000e\u0012\u0004\u0012\u00020M\u0012\u0004\u0012\u00020N0L2\u0012\u0010O\u001a\u000e\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020N0LH\u0096@¢\u0006\u0002\u0010QJ\u000e\u0010R\u001a\u0004\u0018\u00010C*\u00020SH\u0002J\u0012\u0010T\u001a\u00020,2\b\u0010U\u001a\u0004\u0018\u00010\u0005H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0014\u0010\u0016\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001a\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050#X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006V"}, d2 = {"Lcom/AniVortex/AniVortexProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasQuickSearch", "getHasQuickSearch", "hasDownloadSupport", "getHasDownloadSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "ottCursorMap", "Ljava/util/concurrent/ConcurrentHashMap;", "apiGet", "Lcom/lagradost/nicehttp/NiceResponse;", "url", "headers", "", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchOttSection", "Lcom/lagradost/cloudstream3/HomePageList;", "slug", "title", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchCatalogHome", "catalog", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cleanSectionTitle", "mergeAndSortHomeSections", "movieSections", "animeSections", "ottSections", "formatScore", "Lcom/lagradost/cloudstream3/Score;", "rating", "", "(Ljava/lang/Double;)Lcom/lagradost/cloudstream3/Score;", "quickSearch", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "search", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResponse", "Lcom/AniVortex/CatalogItem;", "getQualityInt", "quality", "AniVortex"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAniVortexProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AniVortexProvider.kt\ncom/AniVortex/AniVortexProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 5 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 6 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,713:1\n1795#2,10:714\n2068#2:724\n2069#2:726\n1805#2:727\n296#2,2:733\n1795#2,10:735\n2068#2:745\n2069#2:747\n1805#2:748\n1795#2,10:754\n2068#2:764\n2069#2:766\n1805#2:767\n777#2:768\n873#2,2:769\n2068#2,2:771\n1795#2,10:778\n2068#2:788\n2069#2:790\n1805#2:791\n1795#2,10:797\n2068#2:807\n2069#2:809\n1805#2:810\n1795#2,10:816\n2068#2:826\n1795#2,10:827\n2068#2:837\n2069#2:839\n1805#2:840\n2069#2:842\n1805#2:843\n2068#2,2:844\n2068#2,2:846\n2068#2,2:848\n1795#2,10:855\n2068#2:865\n2069#2:867\n1805#2:868\n1795#2,10:875\n2068#2:885\n2069#2:887\n1805#2:888\n1795#2,10:889\n2068#2:899\n2069#2:901\n1805#2:902\n2068#2:908\n2068#2,2:914\n2069#2:916\n2068#2:945\n2068#2,2:946\n2068#2,2:948\n2069#2:950\n2068#2,2:951\n296#2,2:953\n1#3:725\n1#3:746\n1#3:765\n1#3:789\n1#3:808\n1#3:838\n1#3:841\n1#3:866\n1#3:874\n1#3:886\n1#3:900\n1#3:920\n1#3:955\n73#4,5:728\n73#4,5:749\n73#4,5:773\n73#4,5:792\n73#4,5:811\n73#4,5:850\n73#4,5:869\n73#4,5:903\n73#4,5:909\n73#4,5:940\n93#5,2:917\n63#5:919\n64#5,15:921\n95#5,2:938\n50#6:936\n43#6:937\n*S KotlinDebug\n*F\n+ 1 AniVortexProvider.kt\ncom/AniVortex/AniVortexProvider\n*L\n62#1:714,10\n62#1:724\n62#1:726\n62#1:727\n151#1:733,2\n156#1:735,10\n156#1:745\n156#1:747\n156#1:748\n179#1:754,10\n179#1:764\n179#1:766\n179#1:767\n198#1:768\n198#1:769,2\n198#1:771,2\n209#1:778,10\n209#1:788\n209#1:790\n209#1:791\n237#1:797,10\n237#1:807\n237#1:809\n237#1:810\n266#1:816,10\n266#1:826\n267#1:827,10\n267#1:837\n267#1:839\n267#1:840\n266#1:842\n266#1:843\n383#1:844,2\n397#1:846,2\n405#1:848,2\n433#1:855,10\n433#1:865\n433#1:867\n433#1:868\n487#1:875,10\n487#1:885\n487#1:887\n487#1:888\n488#1:889,10\n488#1:899\n488#1:901\n488#1:902\n524#1:908\n535#1:914,2\n524#1:916\n618#1:945\n622#1:946,2\n638#1:948,2\n618#1:950\n655#1:951,2\n321#1:953,2\n62#1:725\n156#1:746\n179#1:765\n209#1:789\n237#1:808\n267#1:838\n266#1:841\n433#1:866\n487#1:886\n488#1:900\n598#1:920\n149#1:728,5\n177#1:749,5\n208#1:773,5\n236#1:792,5\n260#1:811,5\n431#1:850,5\n447#1:869,5\n520#1:903,5\n533#1:909,5\n614#1:940,5\n598#1:917,2\n598#1:919\n598#1:921,15\n598#1:938,2\n598#1:936\n598#1:937\n*E\n"})
public final class AniVortexProvider extends MainAPI {

    @NotNull
    private String mainUrl = "https://api.anivortex.in";

    @NotNull
    private String name = "AniVortex";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "hi";
    private final boolean hasQuickSearch = true;
    private final boolean hasDownloadSupport = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Anime, TvType.AnimeMovie, TvType.TvSeries, TvType.Movie});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("home:movie_series", "Movies & Series"), TuplesKt.to("section:anime:latest_anime", "Latest Anime"), TuplesKt.to("section:movie_series:recent_movies", "Recent Movies"), TuplesKt.to("section:movie_series:recent_series", "Recent TV Series"), TuplesKt.to("section:anime:top_rated_anime", "Top Rated Anime"), TuplesKt.to("section:movie_series:popular_series", "Popular TV Series"), TuplesKt.to("ott:netflix", "Netflix"), TuplesKt.to("ott:primevideo", "Prime Video"), TuplesKt.to("ott:jiohotstar", "JioHotstar"), TuplesKt.to("ott:crunchyroll", "Crunchyroll"), TuplesKt.to("ott:sonyliv", "SonyLiv"), TuplesKt.to("ott:zee5", "Zee5"), TuplesKt.to("ott:mxplayer", "MX Player"), TuplesKt.to("ott:showmax", "Showmax")});

    @NotNull
    private final ConcurrentHashMap<String, String> ottCursorMap = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: com.AniVortex.AniVortexProvider$apiGet$1 */
    /* JADX INFO: compiled from: AniVortexProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.AniVortex.AniVortexProvider", f = "AniVortexProvider.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {54, 57, 69}, m = "apiGet", n = {"url", "headers", "$this$apiGet_u24lambda_u240", "url", "headers", "$this$apiGet_u24lambda_u240", "resp", "url", "headers", "$this$apiGet_u24lambda_u240", "resp", "urlPath", "queryStr", "freshQuery", "freshHeaders", "freshUrl", "queryMap", "ok"}, nl = {55, 58, 71}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "Z$0"}, v = 2)
    static final class C00001 extends ContinuationImpl {
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
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00001(Continuation<? super C00001> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AniVortexProvider.this.apiGet(null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.AniVortex.AniVortexProvider$fetchCatalogHome$1 */
    /* JADX INFO: compiled from: AniVortexProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.AniVortex.AniVortexProvider", f = "AniVortexProvider.kt", i = {0, 0, 0, 0}, l = {260}, m = "fetchCatalogHome", n = {"catalog", "query", "headers", "url"}, nl = {714}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 2)
    static final class C00011 extends ContinuationImpl {
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
            return AniVortexProvider.this.fetchCatalogHome(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.AniVortex.AniVortexProvider$fetchOttSection$1 */
    /* JADX INFO: compiled from: AniVortexProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.AniVortex.AniVortexProvider", f = "AniVortexProvider.kt", i = {0, 0, 0, 0, 0}, l = {236}, m = "fetchOttSection", n = {"slug", "title", "query", "headers", "url"}, nl = {714}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"}, v = 2)
    static final class C00021 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C00021(Continuation<? super C00021> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AniVortexProvider.this.fetchOttSection(null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.AniVortex.AniVortexProvider$getMainPage$1 */
    /* JADX INFO: compiled from: AniVortexProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.AniVortex.AniVortexProvider", f = "AniVortexProvider.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6}, l = {84, 91, 126, 149, 177, 208, 221}, m = "getMainPage", n = {"request", "page", "request", "data", "page", "request", "data", "catalog", "page", "request", "data", "parts", "catalog", "targetKey", "query", "headers", "url", "page", "request", "data", "catalog", "queryParams", "query", "headers", "url", "page", "request", "data", "slug", "queryParams", "query", "headers", "url", "page", "request", "data", "page"}, nl = {85, 111, 127, 714, 735, 759, -1}, s = {"L$0", "I$0", "L$0", "L$1", "I$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "L$0", "L$1", "I$0"}, v = 2)
    static final class C00031 extends ContinuationImpl {
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

        C00031(Continuation<? super C00031> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AniVortexProvider.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.AniVortex.AniVortexProvider$load$1 */
    /* JADX INFO: compiled from: AniVortexProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.AniVortex.AniVortexProvider", f = "AniVortexProvider.kt", i = {0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7}, l = {437, 447, 470, 496, 520, 533, 560, 576}, m = "load", n = {"url", "url", "queryDetail", "headersDetail", "detailUrl", "titleId", "url", "queryDetail", "headersDetail", "detailUrl", "detail", "tvType", "title", "poster", "backPoster", "plot", "tags", "year", "$this$load_u24lambda_u240", "titleId", "isMovie", "url", "queryDetail", "headersDetail", "detailUrl", "detail", "tvType", "title", "poster", "backPoster", "plot", "tags", "year", "tmdb", "finalPoster", "finalBackdrop", "finalPlot", "finalTags", "finalScore", "recommendationsList", "actorsList", "payload", "titleId", "isMovie", "url", "queryDetail", "headersDetail", "detailUrl", "detail", "tvType", "title", "poster", "backPoster", "plot", "tags", "year", "tmdb", "finalPoster", "finalBackdrop", "finalPlot", "finalTags", "finalScore", "recommendationsList", "actorsList", "queryWatch", "headersWatch", "watchUrl", "titleId", "isMovie", "url", "queryDetail", "headersDetail", "detailUrl", "detail", "tvType", "title", "poster", "backPoster", "plot", "tags", "year", "tmdb", "finalPoster", "finalBackdrop", "finalPlot", "finalTags", "finalScore", "recommendationsList", "actorsList", "queryWatch", "headersWatch", "watchUrl", "watchRes", "episodesList", "$this$forEach$iv", "element$iv", "season", "querySeason", "headersSeason", "seasonUrl", "titleId", "isMovie", "seasonId", "url", "queryDetail", "headersDetail", "detailUrl", "detail", "tvType", "title", "poster", "backPoster", "plot", "tags", "year", "tmdb", "finalPoster", "finalBackdrop", "finalPlot", "finalTags", "finalScore", "recommendationsList", "actorsList", "queryWatch", "headersWatch", "watchUrl", "watchRes", "episodesList", "fallbackPayload", "titleId", "isMovie", "url", "queryDetail", "headersDetail", "detailUrl", "detail", "tvType", "title", "poster", "backPoster", "plot", "tags", "year", "tmdb", "finalPoster", "finalBackdrop", "finalPlot", "finalTags", "finalScore", "recommendationsList", "actorsList", "queryWatch", "headersWatch", "watchUrl", "watchRes", "episodesList", "titleId", "isMovie"}, nl = {438, 714, 477, 513, 748, 754, 576, -1}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$27", "L$28", "L$29", "L$30", "L$31", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "I$0", "I$1"}, v = 2)
    static final class C00051 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
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

        C00051(Continuation<? super C00051> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AniVortexProvider.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.AniVortex.AniVortexProvider$loadLinks$1 */
    /* JADX INFO: compiled from: AniVortexProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.AniVortex.AniVortexProvider", f = "AniVortexProvider.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {606, 614, 625, 641, 658}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "payload", "queryParams", "isCasting", "titleId", "data", "subtitleCallback", "callback", "payload", "queryParams", "query", "headers", "url", "isCasting", "titleId", "data", "subtitleCallback", "callback", "payload", "queryParams", "query", "headers", "url", "playback", "serverName", "$this$forEach$iv", "element$iv", "lang", "langName", "$this$forEach$iv", "element$iv", "stream", "streamUrl", "isCasting", "titleId", "data", "subtitleCallback", "callback", "payload", "queryParams", "query", "headers", "url", "playback", "serverName", "$this$forEach$iv", "element$iv", "lang", "$this$forEach$iv", "langName", "element$iv", "download", "downloadUrl", "isCasting", "titleId", "data", "subtitleCallback", "callback", "payload", "queryParams", "query", "headers", "url", "playback", "serverName", "$this$forEach$iv", "element$iv", "sub", "isCasting", "titleId"}, nl = {607, 737, 624, 640, 657}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$12", "L$13", "L$14", "L$15", "L$17", "L$18", "L$19", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$12", "L$13", "L$14", "L$15", "L$17", "L$18", "L$19", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$12", "L$13", "Z$0", "I$0"}, v = 2)
    static final class C00091 extends ContinuationImpl {
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

        C00091(Continuation<? super C00091> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AniVortexProvider.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.AniVortex.AniVortexProvider$search$1 */
    /* JADX INFO: compiled from: AniVortexProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.AniVortex.AniVortexProvider", f = "AniVortexProvider.kt", i = {0, 1, 1, 1, 1}, l = {423, 431}, m = "search", n = {"query", "query", "queryString", "headers", "url"}, nl = {424, 714}, s = {"L$0", "L$0", "L$1", "L$2", "L$3"}, v = 2)
    static final class C00101 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C00101(Continuation<? super C00101> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AniVortexProvider.this.search(null, (Continuation) this);
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

    public boolean getHasQuickSearch() {
        return this.hasQuickSearch;
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:21:0x0106  */
    /* JADX WARN: Code duplicated, block: B:23:0x0123 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x0124  */
    /* JADX WARN: Code duplicated, block: B:27:0x0136  */
    /* JADX WARN: Code duplicated, block: B:29:0x0154  */
    /* JADX WARN: Code duplicated, block: B:30:0x0159  */
    /* JADX WARN: Code duplicated, block: B:33:0x0167  */
    /* JADX WARN: Code duplicated, block: B:34:0x0169  */
    /* JADX WARN: Code duplicated, block: B:36:0x016c  */
    /* JADX WARN: Code duplicated, block: B:39:0x019a  */
    /* JADX WARN: Code duplicated, block: B:41:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:42:0x01df  */
    /* JADX WARN: Code duplicated, block: B:44:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:47:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:50:0x023c  */
    /* JADX WARN: Code duplicated, block: B:52:0x0240  */
    /* JADX WARN: Code duplicated, block: B:55:0x02d3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:56:0x02d4  */
    /* JADX WARN: Code duplicated, block: B:58:0x02e9  */
    /* JADX WARN: Code duplicated, block: B:59:0x02f8  */
    /* JADX WARN: Code duplicated, block: B:64:0x01e8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Instruction removed from duplicated block: B:27:0x0136, please report this as an issue */
    public final Object apiGet(String url, Map<String, String> map, Continuation<? super NiceResponse> continuation) throws Throwable {
        C00001 c00001;
        Object obj;
        int i;
        C00001 c00002;
        String url2;
        Map<String, String> map2;
        int i2;
        AniVortexProvider $this$apiGet_u24lambda_u240;
        NiceResponse resp;
        Object objReRegister;
        NiceResponse resp2;
        int i3;
        AniVortexProvider $this$apiGet_u24lambda_u241;
        Map<String, String> map3;
        String url3;
        boolean ok;
        String strSubstringAfter$default;
        String queryStr;
        boolean z;
        Map queryMap;
        String url4;
        String url5;
        int i4;
        NiceResponse resp3;
        AniVortexProvider $this$apiGet_u24lambda_u242;
        Map<String, String> map4;
        Collection destination$iv$iv;
        int $i$f$mapNotNullTo;
        List parts;
        Pair pair;
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
        Object $result = c00001.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00001.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                AniVortexProvider $this$apiGet_u24lambda_u243 = this;
                Requests app = MainActivityKt.getApp();
                c00001.L$0 = url;
                c00001.L$1 = SpillingKt.nullOutSpilledVariable(map);
                c00001.L$2 = $this$apiGet_u24lambda_u243;
                c00001.label = 1;
                C00001 c00003 = c00001;
                obj = coroutine_suspended;
                i = 2;
                $result = Requests.get$default(app, url, map, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00003, 4092, (Object) null);
                c00002 = c00003;
                if ($result == obj) {
                    return obj;
                }
                url2 = url;
                map2 = map;
                i2 = 0;
                $this$apiGet_u24lambda_u240 = $this$apiGet_u24lambda_u243;
                resp = (NiceResponse) $result;
                if (resp.getCode() == 401) {
                    return resp;
                }
                Log.w("AniVortex", "Got 401, triggering re-registration and retry...");
                AniVortexRegistration aniVortexRegistration = AniVortexRegistration.INSTANCE;
                c00002.L$0 = url2;
                c00002.L$1 = SpillingKt.nullOutSpilledVariable(map2);
                c00002.L$2 = $this$apiGet_u24lambda_u240;
                c00002.L$3 = resp;
                c00002.label = i;
                objReRegister = aniVortexRegistration.reRegister(c00002);
                if (objReRegister == obj) {
                    return obj;
                }
                resp2 = resp;
                i3 = i2;
                $result = objReRegister;
                $this$apiGet_u24lambda_u241 = $this$apiGet_u24lambda_u240;
                map3 = map2;
                url3 = url2;
                ok = ((Boolean) $result).booleanValue();
                if (!ok) {
                    return resp2;
                }
                String urlPath = StringsKt.substringBefore$default(StringsKt.substringAfter$default(url3, $this$apiGet_u24lambda_u241.getMainUrl(), (String) null, i, (Object) null), "?", (String) null, i, (Object) null);
                if (StringsKt.contains$default(url3, "?", false, i, (Object) null)) {
                    strSubstringAfter$default = StringsKt.substringAfter$default(url3, "?", (String) null, i, (Object) null);
                } else {
                    strSubstringAfter$default = "";
                }
                queryStr = strSubstringAfter$default;
                if (queryStr.length() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    Iterable $this$mapNotNull$iv = StringsKt.split$default(queryStr, new String[]{"&"}, false, 0, 6, (Object) null);
                    destination$iv$iv = new ArrayList();
                    $i$f$mapNotNullTo = 0;
                    for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                        String it = (String) element$iv$iv$iv;
                        parts = StringsKt.split$default(it, new String[]{"="}, false, 2, 2, (Object) null);
                        if (parts.size() == i) {
                            pair = TuplesKt.to(parts.get(0), URLDecoder.decode((String) parts.get(1), "UTF-8"));
                        } else {
                            pair = null;
                        }
                        if (pair != null) {
                            destination$iv$iv.add(pair);
                        }
                        $i$f$mapNotNullTo = $i$f$mapNotNullTo;
                        i = 2;
                    }
                    queryMap = MapsKt.toMap((List) destination$iv$iv);
                } else {
                    queryMap = MapsKt.emptyMap();
                }
                Pair pairBuildHeaders$default = AniVortexAuth.buildHeaders$default(AniVortexAuth.INSTANCE, "GET", urlPath, queryMap, null, 8, null);
                Map queryMap2 = queryMap;
                String freshQuery = (String) pairBuildHeaders$default.component1();
                Map freshHeaders = (Map) pairBuildHeaders$default.component2();
                String freshUrl = $this$apiGet_u24lambda_u241.getMainUrl() + urlPath + (freshQuery.length() > 0 ? '?' + freshQuery : "");
                Requests app2 = MainActivityKt.getApp();
                c00002.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                c00002.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                c00002.L$2 = SpillingKt.nullOutSpilledVariable($this$apiGet_u24lambda_u241);
                c00002.L$3 = SpillingKt.nullOutSpilledVariable(resp2);
                c00002.L$4 = SpillingKt.nullOutSpilledVariable(urlPath);
                c00002.L$5 = SpillingKt.nullOutSpilledVariable(queryStr);
                c00002.L$6 = SpillingKt.nullOutSpilledVariable(freshQuery);
                c00002.L$7 = SpillingKt.nullOutSpilledVariable(freshHeaders);
                c00002.L$8 = SpillingKt.nullOutSpilledVariable(freshUrl);
                c00002.L$9 = SpillingKt.nullOutSpilledVariable(queryMap2);
                c00002.Z$0 = ok;
                c00002.label = 3;
                url4 = url3;
                $result = Requests.get$default(app2, freshUrl, freshHeaders, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00002, 4092, (Object) null);
                if ($result == obj) {
                    return obj;
                }
                url5 = url4;
                i4 = i3;
                resp3 = resp2;
                $this$apiGet_u24lambda_u242 = $this$apiGet_u24lambda_u241;
                map4 = map3;
                return (NiceResponse) $result;
            case 1:
                i2 = 0;
                $this$apiGet_u24lambda_u240 = (AniVortexProvider) c00001.L$2;
                map2 = (Map) c00001.L$1;
                url2 = (String) c00001.L$0;
                ResultKt.throwOnFailure($result);
                c00002 = c00001;
                obj = coroutine_suspended;
                i = 2;
                resp = (NiceResponse) $result;
                if (resp.getCode() == 401) {
                    return resp;
                }
                Log.w("AniVortex", "Got 401, triggering re-registration and retry...");
                AniVortexRegistration aniVortexRegistration2 = AniVortexRegistration.INSTANCE;
                c00002.L$0 = url2;
                c00002.L$1 = SpillingKt.nullOutSpilledVariable(map2);
                c00002.L$2 = $this$apiGet_u24lambda_u240;
                c00002.L$3 = resp;
                c00002.label = i;
                objReRegister = aniVortexRegistration2.reRegister(c00002);
                if (objReRegister == obj) {
                    return obj;
                }
                resp2 = resp;
                i3 = i2;
                $result = objReRegister;
                $this$apiGet_u24lambda_u241 = $this$apiGet_u24lambda_u240;
                map3 = map2;
                url3 = url2;
                ok = ((Boolean) $result).booleanValue();
                if (!ok) {
                    return resp2;
                }
                String urlPath2 = StringsKt.substringBefore$default(StringsKt.substringAfter$default(url3, $this$apiGet_u24lambda_u241.getMainUrl(), (String) null, i, (Object) null), "?", (String) null, i, (Object) null);
                if (StringsKt.contains$default(url3, "?", false, i, (Object) null)) {
                    strSubstringAfter$default = StringsKt.substringAfter$default(url3, "?", (String) null, i, (Object) null);
                } else {
                    strSubstringAfter$default = "";
                }
                queryStr = strSubstringAfter$default;
                if (queryStr.length() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    Iterable $this$mapNotNull$iv2 = StringsKt.split$default(queryStr, new String[]{"&"}, false, 0, 6, (Object) null);
                    destination$iv$iv = new ArrayList();
                    $i$f$mapNotNullTo = 0;
                    while (r17.hasNext()) {
                        String it2 = (String) element$iv$iv$iv;
                        parts = StringsKt.split$default(it2, new String[]{"="}, false, 2, 2, (Object) null);
                        if (parts.size() == i) {
                            pair = TuplesKt.to(parts.get(0), URLDecoder.decode((String) parts.get(1), "UTF-8"));
                        } else {
                            pair = null;
                        }
                        if (pair != null) {
                            destination$iv$iv.add(pair);
                        }
                        $i$f$mapNotNullTo = $i$f$mapNotNullTo;
                        i = 2;
                    }
                    queryMap = MapsKt.toMap((List) destination$iv$iv);
                } else {
                    queryMap = MapsKt.emptyMap();
                }
                Pair pairBuildHeaders$default2 = AniVortexAuth.buildHeaders$default(AniVortexAuth.INSTANCE, "GET", urlPath2, queryMap, null, 8, null);
                Map queryMap3 = queryMap;
                String freshQuery2 = (String) pairBuildHeaders$default2.component1();
                Map freshHeaders2 = (Map) pairBuildHeaders$default2.component2();
                String freshUrl2 = $this$apiGet_u24lambda_u241.getMainUrl() + urlPath2 + (freshQuery2.length() > 0 ? '?' + freshQuery2 : "");
                Requests app3 = MainActivityKt.getApp();
                c00002.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                c00002.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                c00002.L$2 = SpillingKt.nullOutSpilledVariable($this$apiGet_u24lambda_u241);
                c00002.L$3 = SpillingKt.nullOutSpilledVariable(resp2);
                c00002.L$4 = SpillingKt.nullOutSpilledVariable(urlPath2);
                c00002.L$5 = SpillingKt.nullOutSpilledVariable(queryStr);
                c00002.L$6 = SpillingKt.nullOutSpilledVariable(freshQuery2);
                c00002.L$7 = SpillingKt.nullOutSpilledVariable(freshHeaders2);
                c00002.L$8 = SpillingKt.nullOutSpilledVariable(freshUrl2);
                c00002.L$9 = SpillingKt.nullOutSpilledVariable(queryMap3);
                c00002.Z$0 = ok;
                c00002.label = 3;
                url4 = url3;
                $result = Requests.get$default(app3, freshUrl2, freshHeaders2, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00002, 4092, (Object) null);
                if ($result == obj) {
                    return obj;
                }
                url5 = url4;
                i4 = i3;
                resp3 = resp2;
                $this$apiGet_u24lambda_u242 = $this$apiGet_u24lambda_u241;
                map4 = map3;
                return (NiceResponse) $result;
            case 2:
                NiceResponse resp4 = (NiceResponse) c00001.L$3;
                AniVortexProvider $this$apiGet_u24lambda_u244 = (AniVortexProvider) c00001.L$2;
                Map<String, String> map5 = (Map) c00001.L$1;
                String url6 = (String) c00001.L$0;
                ResultKt.throwOnFailure($result);
                c00002 = c00001;
                obj = coroutine_suspended;
                i3 = 0;
                resp2 = resp4;
                $this$apiGet_u24lambda_u241 = $this$apiGet_u24lambda_u244;
                map3 = map5;
                url3 = url6;
                i = 2;
                ok = ((Boolean) $result).booleanValue();
                if (!ok) {
                    return resp2;
                }
                String urlPath3 = StringsKt.substringBefore$default(StringsKt.substringAfter$default(url3, $this$apiGet_u24lambda_u241.getMainUrl(), (String) null, i, (Object) null), "?", (String) null, i, (Object) null);
                if (StringsKt.contains$default(url3, "?", false, i, (Object) null)) {
                    strSubstringAfter$default = StringsKt.substringAfter$default(url3, "?", (String) null, i, (Object) null);
                } else {
                    strSubstringAfter$default = "";
                }
                queryStr = strSubstringAfter$default;
                if (queryStr.length() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    Iterable $this$mapNotNull$iv3 = StringsKt.split$default(queryStr, new String[]{"&"}, false, 0, 6, (Object) null);
                    destination$iv$iv = new ArrayList();
                    $i$f$mapNotNullTo = 0;
                    while (r17.hasNext()) {
                        String it3 = (String) element$iv$iv$iv;
                        parts = StringsKt.split$default(it3, new String[]{"="}, false, 2, 2, (Object) null);
                        if (parts.size() == i) {
                            pair = TuplesKt.to(parts.get(0), URLDecoder.decode((String) parts.get(1), "UTF-8"));
                        } else {
                            pair = null;
                        }
                        if (pair != null) {
                            destination$iv$iv.add(pair);
                        }
                        $i$f$mapNotNullTo = $i$f$mapNotNullTo;
                        i = 2;
                    }
                    queryMap = MapsKt.toMap((List) destination$iv$iv);
                } else {
                    queryMap = MapsKt.emptyMap();
                }
                Pair pairBuildHeaders$default3 = AniVortexAuth.buildHeaders$default(AniVortexAuth.INSTANCE, "GET", urlPath3, queryMap, null, 8, null);
                Map queryMap4 = queryMap;
                String freshQuery3 = (String) pairBuildHeaders$default3.component1();
                Map freshHeaders3 = (Map) pairBuildHeaders$default3.component2();
                String freshUrl3 = $this$apiGet_u24lambda_u241.getMainUrl() + urlPath3 + (freshQuery3.length() > 0 ? '?' + freshQuery3 : "");
                Requests app4 = MainActivityKt.getApp();
                c00002.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                c00002.L$1 = SpillingKt.nullOutSpilledVariable(map3);
                c00002.L$2 = SpillingKt.nullOutSpilledVariable($this$apiGet_u24lambda_u241);
                c00002.L$3 = SpillingKt.nullOutSpilledVariable(resp2);
                c00002.L$4 = SpillingKt.nullOutSpilledVariable(urlPath3);
                c00002.L$5 = SpillingKt.nullOutSpilledVariable(queryStr);
                c00002.L$6 = SpillingKt.nullOutSpilledVariable(freshQuery3);
                c00002.L$7 = SpillingKt.nullOutSpilledVariable(freshHeaders3);
                c00002.L$8 = SpillingKt.nullOutSpilledVariable(freshUrl3);
                c00002.L$9 = SpillingKt.nullOutSpilledVariable(queryMap4);
                c00002.Z$0 = ok;
                c00002.label = 3;
                url4 = url3;
                $result = Requests.get$default(app4, freshUrl3, freshHeaders3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00002, 4092, (Object) null);
                if ($result == obj) {
                    return obj;
                }
                url5 = url4;
                i4 = i3;
                resp3 = resp2;
                $this$apiGet_u24lambda_u242 = $this$apiGet_u24lambda_u241;
                map4 = map3;
                return (NiceResponse) $result;
            case 3:
                i4 = 0;
                boolean z2 = c00001.Z$0;
                resp3 = (NiceResponse) c00001.L$3;
                $this$apiGet_u24lambda_u242 = (AniVortexProvider) c00001.L$2;
                map4 = (Map) c00001.L$1;
                url5 = (String) c00001.L$0;
                ResultKt.throwOnFailure($result);
                return (NiceResponse) $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x02df  */
    /* JADX WARN: Code duplicated, block: B:110:0x0326  */
    /* JADX WARN: Code duplicated, block: B:136:0x0459  */
    /* JADX WARN: Code duplicated, block: B:142:0x0470  */
    /* JADX WARN: Code duplicated, block: B:144:0x0478  */
    /* JADX WARN: Code duplicated, block: B:145:0x047a  */
    /* JADX WARN: Code duplicated, block: B:195:0x0666  */
    /* JADX WARN: Code duplicated, block: B:200:0x0679  */
    /* JADX WARN: Code duplicated, block: B:207:0x0688  */
    /* JADX WARN: Code duplicated, block: B:209:0x068b  */
    /* JADX WARN: Code duplicated, block: B:216:0x06be  */
    /* JADX WARN: Code duplicated, block: B:218:0x06c6  */
    /* JADX WARN: Code duplicated, block: B:219:0x06c8  */
    /* JADX WARN: Code duplicated, block: B:222:0x06cf  */
    /* JADX WARN: Code duplicated, block: B:223:0x06d1  */
    /* JADX WARN: Code duplicated, block: B:249:0x077f  */
    /* JADX WARN: Code duplicated, block: B:252:0x0786  */
    /* JADX WARN: Code duplicated, block: B:254:0x0793  */
    /* JADX WARN: Code duplicated, block: B:256:0x07b2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:257:0x07b3  */
    /* JADX WARN: Code duplicated, block: B:275:0x02c3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:86:0x02b5 A[LOOP:2: B:71:0x026f->B:86:0x02b5, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:92:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:94:0x02ce  */
    /* JADX WARN: Code duplicated, block: B:97:0x02db  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) throws Throwable {
        C00031 c00031;
        MainPageRequest request2;
        int page2;
        String data;
        boolean z;
        Object objCoroutineScope;
        Object objFetchCatalogHome;
        String data2;
        Map queryParams;
        Object objApiGet;
        String data3;
        Object objApiGet2;
        MainPageRequest request3;
        boolean z2;
        String targetKey;
        Object objApiGet3;
        MainPageRequest request4;
        Object safe;
        CatalogHomeResponse response;
        CatalogHomeResponse response2;
        CatalogSection matchedSection;
        List<CatalogSection> sections;
        List items;
        Iterable items2;
        Iterable sections2;
        Object element$iv;
        int $i$f$firstOrNull;
        boolean z3;
        Object safe2;
        CatalogExploreResponse response3;
        CatalogExploreResponse response4;
        List items3;
        boolean zBooleanValue;
        Boolean hasMore;
        Iterable items4;
        Object safe3;
        OttTitlesResponse response5;
        OttTitlesResponse response6;
        List items5;
        String nextCursor;
        String str;
        boolean z4;
        boolean hasMore2;
        boolean z5;
        OttPageInfo page3;
        Boolean hasMore3;
        OttPageInfo page4;
        Iterable items6;
        if (continuation instanceof C00031) {
            c00031 = (C00031) continuation;
            if ((c00031.label & Integer.MIN_VALUE) != 0) {
                c00031.label -= Integer.MIN_VALUE;
            } else {
                c00031 = new C00031(continuation);
            }
        } else {
            c00031 = new C00031(continuation);
        }
        C00031 c00032 = c00031;
        Object $result = c00032.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00032.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                DonationManager.INSTANCE.checkAndShow(getName());
                AniVortexRegistration aniVortexRegistration = AniVortexRegistration.INSTANCE;
                request2 = request;
                c00032.L$0 = request2;
                page2 = page;
                c00032.I$0 = page2;
                c00032.label = 1;
                if (aniVortexRegistration.ensureRegistered(c00032) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                data = request2.getData();
                if (!Intrinsics.areEqual(data, "home:all") || Intrinsics.areEqual(data, "home")) {
                    z = false;
                } else {
                    if (!(data.length() == 0)) {
                        String catalog = "anime";
                        if (StringsKt.startsWith$default(data, "home:", false, 2, (Object) null) || Intrinsics.areEqual(data, "movie_series") || Intrinsics.areEqual(data, "anime")) {
                            if (page2 > 1) {
                                return MainAPIKt.newHomePageResponse(CollectionsKt.emptyList(), Boxing.boxBoolean(false));
                            }
                            if (StringsKt.startsWith$default(data, "home:", false, 2, (Object) null)) {
                                catalog = StringsKt.removePrefix(data, "home:");
                            } else if (!Intrinsics.areEqual(data, "anime")) {
                                catalog = "movie_series";
                            }
                            c00032.L$0 = SpillingKt.nullOutSpilledVariable(request2);
                            c00032.L$1 = SpillingKt.nullOutSpilledVariable(data);
                            c00032.L$2 = catalog;
                            c00032.I$0 = page2;
                            c00032.label = 3;
                            objFetchCatalogHome = fetchCatalogHome(catalog, c00032);
                            if (objFetchCatalogHome == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            data2 = catalog;
                            List homeLists = (List) objFetchCatalogHome;
                            Log.d("AniVortex", "Loaded " + homeLists.size() + " home sections for " + data2);
                            return MainAPIKt.newHomePageResponse(homeLists, Boxing.boxBoolean(false));
                        }
                        if (StringsKt.startsWith$default(data, "section:", false, 2, (Object) null)) {
                            if (page2 > 1) {
                                return MainAPIKt.newHomePageResponse(CollectionsKt.emptyList(), Boxing.boxBoolean(false));
                            }
                            List parts = StringsKt.split$default(data, new String[]{":"}, false, 0, 6, (Object) null);
                            z2 = false;
                            String str2 = (String) CollectionsKt.getOrNull(parts, 1);
                            String catalog2 = str2 != null ? str2 : "movie_series";
                            targetKey = (String) CollectionsKt.getOrNull(parts, 2);
                            if (targetKey == null) {
                                targetKey = "";
                            }
                            Pair pairBuildHeaders$default = AniVortexAuth.buildHeaders$default(AniVortexAuth.INSTANCE, "GET", "/api/v1/catalog/home", MapsKt.mapOf(new Pair[]{TuplesKt.to("catalog", catalog2), TuplesKt.to("include_adult", "false")}), null, 8, null);
                            String query = (String) pairBuildHeaders$default.component1();
                            Map<String, String> map = (Map) pairBuildHeaders$default.component2();
                            String url = getMainUrl() + "/api/v1/catalog/home?" + query;
                            c00032.L$0 = request2;
                            c00032.L$1 = SpillingKt.nullOutSpilledVariable(data);
                            c00032.L$2 = SpillingKt.nullOutSpilledVariable(parts);
                            c00032.L$3 = SpillingKt.nullOutSpilledVariable(catalog2);
                            c00032.L$4 = targetKey;
                            c00032.L$5 = SpillingKt.nullOutSpilledVariable(query);
                            c00032.L$6 = SpillingKt.nullOutSpilledVariable(map);
                            c00032.L$7 = SpillingKt.nullOutSpilledVariable(url);
                            c00032.I$0 = page2;
                            c00032.label = 4;
                            objApiGet3 = apiGet(url, map, c00032);
                            if (objApiGet3 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            request4 = request2;
                            NiceResponse this_$iv = (NiceResponse) objApiGet3;
                            try {
                                ResponseParser parser = this_$iv.getParser();
                                Intrinsics.checkNotNull(parser);
                                try {
                                    safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(CatalogHomeResponse.class));
                                } catch (Exception e) {
                                    e$iv = e;
                                    e$iv.printStackTrace();
                                    safe = null;
                                }
                                break;
                            } catch (Exception e2) {
                                e$iv = e2;
                            }
                            response = (CatalogHomeResponse) safe;
                            if (response == null && (sections2 = response.getSections()) != null) {
                                Iterable $this$firstOrNull$iv = sections2;
                                int $i$f$firstOrNull2 = 0;
                                Iterator it = $this$firstOrNull$iv.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        element$iv = it.next();
                                        CatalogSection it2 = (CatalogSection) element$iv;
                                        response2 = response;
                                        Iterable $this$firstOrNull$iv2 = $this$firstOrNull$iv;
                                        if (StringsKt.equals(it2.getKey(), targetKey, true)) {
                                            $i$f$firstOrNull = $i$f$firstOrNull2;
                                        } else {
                                            if (it2.getTitle() != null) {
                                                $i$f$firstOrNull = $i$f$firstOrNull2;
                                                if (StringsKt.contains(request4.getName(), it2.getTitle(), true)) {
                                                }
                                                if (!z3) {
                                                    response = response2;
                                                    $this$firstOrNull$iv = $this$firstOrNull$iv2;
                                                    $i$f$firstOrNull2 = $i$f$firstOrNull;
                                                }
                                            } else {
                                                $i$f$firstOrNull = $i$f$firstOrNull2;
                                            }
                                            z3 = false;
                                            if (!z3) {
                                                response = response2;
                                                $this$firstOrNull$iv = $this$firstOrNull$iv2;
                                                $i$f$firstOrNull2 = $i$f$firstOrNull;
                                            }
                                        }
                                        z3 = true;
                                        if (!z3) {
                                            response = response2;
                                            $this$firstOrNull$iv = $this$firstOrNull$iv2;
                                            $i$f$firstOrNull2 = $i$f$firstOrNull;
                                        }
                                    } else {
                                        response2 = response;
                                        element$iv = null;
                                    }
                                }
                                CatalogSection catalogSection = (CatalogSection) element$iv;
                                if (catalogSection != null) {
                                    matchedSection = catalogSection;
                                }
                                if (matchedSection != null || (items2 = matchedSection.getItems()) == null) {
                                    items = CollectionsKt.emptyList();
                                } else {
                                    Iterable $this$mapNotNull$iv = items2;
                                    Collection destination$iv$iv = new ArrayList();
                                    for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                                        CatalogSection matchedSection2 = matchedSection;
                                        CatalogItem it3 = (CatalogItem) element$iv$iv$iv;
                                        SearchResponse searchResponse = toSearchResponse(it3);
                                        if (searchResponse != null) {
                                            destination$iv$iv.add(searchResponse);
                                        }
                                        matchedSection = matchedSection2;
                                    }
                                    items = (List) destination$iv$iv;
                                }
                                return MainAPIKt.newHomePageResponse(request4.getName(), items, Boxing.boxBoolean(z2));
                            }
                            response2 = response;
                            if (response2 != null || (sections = response2.getSections()) == null) {
                                matchedSection = null;
                            } else {
                                matchedSection = (CatalogSection) CollectionsKt.firstOrNull(sections);
                            }
                            if (matchedSection != null) {
                                items = CollectionsKt.emptyList();
                            } else {
                                items = CollectionsKt.emptyList();
                            }
                            return MainAPIKt.newHomePageResponse(request4.getName(), items, Boxing.boxBoolean(z2));
                        }
                        if (StringsKt.startsWith$default(data, "explore:", false, 2, (Object) null)) {
                            String catalog3 = StringsKt.removePrefix(data, "explore:");
                            Map queryParams2 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("catalog", catalog3), TuplesKt.to("include_adult", "false"), TuplesKt.to("page", String.valueOf(page2)), TuplesKt.to("limit", "24")});
                            Pair pairBuildHeaders$default2 = AniVortexAuth.buildHeaders$default(AniVortexAuth.INSTANCE, "GET", "/api/v1/catalog/explore", queryParams2, null, 8, null);
                            String query2 = (String) pairBuildHeaders$default2.component1();
                            Map<String, String> map2 = (Map) pairBuildHeaders$default2.component2();
                            String url2 = getMainUrl() + "/api/v1/catalog/explore?" + query2;
                            c00032.L$0 = request2;
                            c00032.L$1 = SpillingKt.nullOutSpilledVariable(data);
                            c00032.L$2 = SpillingKt.nullOutSpilledVariable(catalog3);
                            c00032.L$3 = SpillingKt.nullOutSpilledVariable(queryParams2);
                            c00032.L$4 = SpillingKt.nullOutSpilledVariable(query2);
                            c00032.L$5 = SpillingKt.nullOutSpilledVariable(map2);
                            c00032.L$6 = SpillingKt.nullOutSpilledVariable(url2);
                            c00032.I$0 = page2;
                            c00032.label = 5;
                            objApiGet2 = apiGet(url2, map2, c00032);
                            if (objApiGet2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            request3 = request2;
                            NiceResponse this_$iv2 = (NiceResponse) objApiGet2;
                            try {
                                ResponseParser parser2 = this_$iv2.getParser();
                                Intrinsics.checkNotNull(parser2);
                                safe2 = parser2.parseSafe(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(CatalogExploreResponse.class));
                                break;
                            } catch (Exception e$iv) {
                                e$iv.printStackTrace();
                                safe2 = null;
                            }
                            response3 = (CatalogExploreResponse) safe2;
                            if (response3 != null || (items4 = response3.getItems()) == null) {
                                response4 = response3;
                                items3 = CollectionsKt.emptyList();
                            } else {
                                Iterable $this$mapNotNull$iv2 = items4;
                                Collection destination$iv$iv2 = new ArrayList();
                                for (Object element$iv$iv$iv2 : $this$mapNotNull$iv2) {
                                    CatalogExploreResponse response7 = response3;
                                    CatalogItem it4 = (CatalogItem) element$iv$iv$iv2;
                                    SearchResponse searchResponse2 = toSearchResponse(it4);
                                    if (searchResponse2 != null) {
                                        destination$iv$iv2.add(searchResponse2);
                                    }
                                    response3 = response7;
                                }
                                response4 = response3;
                                items3 = (List) destination$iv$iv2;
                            }
                            String name = request3.getName();
                            if (response4 == null && (hasMore = response4.getHasMore()) != null) {
                                zBooleanValue = hasMore.booleanValue();
                            } else if (items3.size() >= 24) {
                                zBooleanValue = true;
                            } else {
                                zBooleanValue = false;
                            }
                            return MainAPIKt.newHomePageResponse(name, items3, Boxing.boxBoolean(zBooleanValue));
                        }
                        if (!StringsKt.startsWith$default(data, "ott:", false, 2, (Object) null)) {
                            MainPageRequest mainPageRequestCopy$default = MainPageRequest.copy$default(request2, (String) null, "home:all", false, 5, (Object) null);
                            c00032.L$0 = SpillingKt.nullOutSpilledVariable(request2);
                            c00032.L$1 = SpillingKt.nullOutSpilledVariable(data);
                            c00032.I$0 = page2;
                            c00032.label = 7;
                            Object mainPage = getMainPage(page2, mainPageRequestCopy$default, c00032);
                            return mainPage == coroutine_suspended ? coroutine_suspended : mainPage;
                        }
                        String slug = StringsKt.removePrefix(data, "ott:");
                        Map queryParams3 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("sort", "popular"), TuplesKt.to("include_adult", "false"), TuplesKt.to("limit", "24")});
                        ConcurrentHashMap<String, String> concurrentHashMap = this.ottCursorMap;
                        if (page2 > 1) {
                            String cursor = concurrentHashMap.get(data + ':' + page2);
                            String str3 = cursor;
                            if (str3 == null || str3.length() == 0) {
                                queryParams = queryParams3;
                            } else {
                                queryParams3.put("cursor", cursor);
                                queryParams = queryParams3;
                            }
                        } else {
                            Iterable $this$filter$iv = concurrentHashMap.keySet();
                            int $i$f$filter = 0;
                            Collection destination$iv$iv3 = new ArrayList();
                            Iterable $this$filterTo$iv$iv = $this$filter$iv;
                            for (Object element$iv$iv : $this$filterTo$iv$iv) {
                                String it5 = (String) element$iv$iv;
                                Map queryParams4 = queryParams3;
                                Iterable $this$filter$iv2 = $this$filter$iv;
                                int $i$f$filter2 = $i$f$filter;
                                Iterable $this$filterTo$iv$iv2 = $this$filterTo$iv$iv;
                                if (StringsKt.startsWith$default(it5, data + ':', false, 2, (Object) null)) {
                                    destination$iv$iv3.add(element$iv$iv);
                                }
                                $this$filter$iv = $this$filter$iv2;
                                $i$f$filter = $i$f$filter2;
                                $this$filterTo$iv$iv = $this$filterTo$iv$iv2;
                                queryParams3 = queryParams4;
                            }
                            queryParams = queryParams3;
                            Iterable $this$forEach$iv = (List) destination$iv$iv3;
                            for (Object element$iv2 : $this$forEach$iv) {
                                String it6 = (String) element$iv2;
                                this.ottCursorMap.remove(it6);
                            }
                        }
                        Pair pairBuildHeaders$default3 = AniVortexAuth.buildHeaders$default(AniVortexAuth.INSTANCE, "GET", "/api/v1/catalog/ott-platforms/" + slug + "/titles", queryParams, null, 8, null);
                        String query3 = (String) pairBuildHeaders$default3.component1();
                        Map<String, String> map3 = (Map) pairBuildHeaders$default3.component2();
                        String url3 = getMainUrl() + "/api/v1/catalog/ott-platforms/" + slug + "/titles?" + query3;
                        c00032.L$0 = request2;
                        c00032.L$1 = data;
                        c00032.L$2 = SpillingKt.nullOutSpilledVariable(slug);
                        c00032.L$3 = SpillingKt.nullOutSpilledVariable(queryParams);
                        c00032.L$4 = SpillingKt.nullOutSpilledVariable(query3);
                        c00032.L$5 = SpillingKt.nullOutSpilledVariable(map3);
                        c00032.L$6 = SpillingKt.nullOutSpilledVariable(url3);
                        c00032.I$0 = page2;
                        c00032.label = 6;
                        objApiGet = apiGet(url3, map3, c00032);
                        if (objApiGet == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        data3 = data;
                        NiceResponse this_$iv3 = (NiceResponse) objApiGet;
                        try {
                            ResponseParser parser3 = this_$iv3.getParser();
                            Intrinsics.checkNotNull(parser3);
                            safe3 = parser3.parseSafe(this_$iv3.getText(), Reflection.getOrCreateKotlinClass(OttTitlesResponse.class));
                            break;
                        } catch (Exception e$iv2) {
                            e$iv2.printStackTrace();
                            safe3 = null;
                        }
                        response5 = (OttTitlesResponse) safe3;
                        if (response5 != null || (items6 = response5.getItems()) == null) {
                            response6 = response5;
                            items5 = CollectionsKt.emptyList();
                        } else {
                            Iterable $this$mapNotNull$iv3 = items6;
                            Collection destination$iv$iv4 = new ArrayList();
                            for (Object element$iv$iv$iv3 : $this$mapNotNull$iv3) {
                                OttTitlesResponse response8 = response5;
                                CatalogItem it7 = (CatalogItem) element$iv$iv$iv3;
                                SearchResponse searchResponse3 = toSearchResponse(it7);
                                if (searchResponse3 != null) {
                                    destination$iv$iv4.add(searchResponse3);
                                }
                                response5 = response8;
                            }
                            response6 = response5;
                            items5 = (List) destination$iv$iv4;
                        }
                        if (response6 != null || (page4 = response6.getPage()) == null) {
                            nextCursor = null;
                        } else {
                            nextCursor = page4.getNextCursor();
                        }
                        str = nextCursor;
                        if (str != null || str.length() == 0) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (!z4) {
                            this.ottCursorMap.put(data3 + ':' + (page2 + 1), nextCursor);
                        }
                        if (response6 == null && (page3 = response6.getPage()) != null && (hasMore3 = page3.getHasMore()) != null) {
                            hasMore2 = hasMore3.booleanValue();
                        } else if (items5.size() >= 24) {
                            hasMore2 = true;
                        } else {
                            hasMore2 = false;
                        }
                        String name2 = request2.getName();
                        if (hasMore2) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        return MainAPIKt.newHomePageResponse(name2, items5, Boxing.boxBoolean(z5));
                    }
                    z = false;
                }
                if (page2 > 1) {
                    return MainAPIKt.newHomePageResponse(CollectionsKt.emptyList(), Boxing.boxBoolean(z));
                }
                C00042 c00042 = new C00042(null);
                c00032.L$0 = SpillingKt.nullOutSpilledVariable(request2);
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(data);
                c00032.I$0 = page2;
                c00032.label = 2;
                objCoroutineScope = CoroutineScopeKt.coroutineScope(c00042, c00032);
                if (objCoroutineScope == coroutine_suspended) {
                    return coroutine_suspended;
                }
                Triple triple = (Triple) objCoroutineScope;
                List<HomePageList> listMergeAndSortHomeSections = mergeAndSortHomeSections((List) triple.component1(), (List) triple.component2(), (List) triple.component3());
                Log.d("AniVortex", "Loaded " + listMergeAndSortHomeSections.size() + " combined home sections (including OTT platforms)");
                return MainAPIKt.newHomePageResponse(listMergeAndSortHomeSections, Boxing.boxBoolean(false));
            case 1:
                int page5 = c00032.I$0;
                request2 = (MainPageRequest) c00032.L$0;
                ResultKt.throwOnFailure($result);
                page2 = page5;
                data = request2.getData();
                if (Intrinsics.areEqual(data, "home:all")) {
                    z = false;
                } else {
                    z = false;
                }
                if (page2 > 1) {
                    return MainAPIKt.newHomePageResponse(CollectionsKt.emptyList(), Boxing.boxBoolean(z));
                }
                C00042 c00043 = new C00042(null);
                c00032.L$0 = SpillingKt.nullOutSpilledVariable(request2);
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(data);
                c00032.I$0 = page2;
                c00032.label = 2;
                objCoroutineScope = CoroutineScopeKt.coroutineScope(c00043, c00032);
                if (objCoroutineScope == coroutine_suspended) {
                    return coroutine_suspended;
                }
                Triple triple2 = (Triple) objCoroutineScope;
                List<HomePageList> listMergeAndSortHomeSections2 = mergeAndSortHomeSections((List) triple2.component1(), (List) triple2.component2(), (List) triple2.component3());
                Log.d("AniVortex", "Loaded " + listMergeAndSortHomeSections2.size() + " combined home sections (including OTT platforms)");
                return MainAPIKt.newHomePageResponse(listMergeAndSortHomeSections2, Boxing.boxBoolean(false));
            case 2:
                int page6 = c00032.I$0;
                ResultKt.throwOnFailure($result);
                objCoroutineScope = $result;
                Triple triple3 = (Triple) objCoroutineScope;
                List<HomePageList> listMergeAndSortHomeSections3 = mergeAndSortHomeSections((List) triple3.component1(), (List) triple3.component2(), (List) triple3.component3());
                Log.d("AniVortex", "Loaded " + listMergeAndSortHomeSections3.size() + " combined home sections (including OTT platforms)");
                return MainAPIKt.newHomePageResponse(listMergeAndSortHomeSections3, Boxing.boxBoolean(false));
            case 3:
                int page7 = c00032.I$0;
                data2 = (String) c00032.L$2;
                ResultKt.throwOnFailure($result);
                objFetchCatalogHome = $result;
                List homeLists2 = (List) objFetchCatalogHome;
                Log.d("AniVortex", "Loaded " + homeLists2.size() + " home sections for " + data2);
                return MainAPIKt.newHomePageResponse(homeLists2, Boxing.boxBoolean(false));
            case 4:
                int page8 = c00032.I$0;
                String targetKey2 = (String) c00032.L$4;
                request4 = (MainPageRequest) c00032.L$0;
                ResultKt.throwOnFailure($result);
                targetKey = targetKey2;
                z2 = false;
                objApiGet3 = $result;
                NiceResponse this_$iv4 = (NiceResponse) objApiGet3;
                ResponseParser parser4 = this_$iv4.getParser();
                Intrinsics.checkNotNull(parser4);
                safe = parser4.parseSafe(this_$iv4.getText(), Reflection.getOrCreateKotlinClass(CatalogHomeResponse.class));
                response = (CatalogHomeResponse) safe;
                if (response == null) {
                    response2 = response;
                    if (response2 != null) {
                        matchedSection = null;
                    } else {
                        matchedSection = null;
                    }
                } else {
                    response2 = response;
                    if (response2 != null) {
                        matchedSection = null;
                    } else {
                        matchedSection = null;
                    }
                }
                if (matchedSection != null) {
                    items = CollectionsKt.emptyList();
                } else {
                    items = CollectionsKt.emptyList();
                }
                return MainAPIKt.newHomePageResponse(request4.getName(), items, Boxing.boxBoolean(z2));
            case 5:
                int page9 = c00032.I$0;
                request3 = (MainPageRequest) c00032.L$0;
                ResultKt.throwOnFailure($result);
                objApiGet2 = $result;
                NiceResponse this_$iv5 = (NiceResponse) objApiGet2;
                ResponseParser parser5 = this_$iv5.getParser();
                Intrinsics.checkNotNull(parser5);
                safe2 = parser5.parseSafe(this_$iv5.getText(), Reflection.getOrCreateKotlinClass(CatalogExploreResponse.class));
                response3 = (CatalogExploreResponse) safe2;
                if (response3 != null) {
                    response4 = response3;
                    items3 = CollectionsKt.emptyList();
                } else {
                    response4 = response3;
                    items3 = CollectionsKt.emptyList();
                }
                String name3 = request3.getName();
                if (response4 == null) {
                    if (items3.size() >= 24) {
                        zBooleanValue = true;
                    } else {
                        zBooleanValue = false;
                    }
                } else if (items3.size() >= 24) {
                    zBooleanValue = true;
                } else {
                    zBooleanValue = false;
                }
                return MainAPIKt.newHomePageResponse(name3, items3, Boxing.boxBoolean(zBooleanValue));
            case 6:
                int page10 = c00032.I$0;
                data3 = (String) c00032.L$1;
                request2 = (MainPageRequest) c00032.L$0;
                ResultKt.throwOnFailure($result);
                objApiGet = $result;
                page2 = page10;
                NiceResponse this_$iv6 = (NiceResponse) objApiGet;
                ResponseParser parser6 = this_$iv6.getParser();
                Intrinsics.checkNotNull(parser6);
                safe3 = parser6.parseSafe(this_$iv6.getText(), Reflection.getOrCreateKotlinClass(OttTitlesResponse.class));
                response5 = (OttTitlesResponse) safe3;
                if (response5 != null) {
                    response6 = response5;
                    items5 = CollectionsKt.emptyList();
                } else {
                    response6 = response5;
                    items5 = CollectionsKt.emptyList();
                }
                if (response6 != null) {
                    nextCursor = null;
                } else {
                    nextCursor = null;
                }
                str = nextCursor;
                if (str != null) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (!z4) {
                    this.ottCursorMap.put(data3 + ':' + (page2 + 1), nextCursor);
                }
                if (response6 == null) {
                    if (items5.size() >= 24) {
                        hasMore2 = true;
                    } else {
                        hasMore2 = false;
                    }
                } else if (items5.size() >= 24) {
                    hasMore2 = true;
                } else {
                    hasMore2 = false;
                }
                String name4 = request2.getName();
                if (hasMore2) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                return MainAPIKt.newHomePageResponse(name4, items5, Boxing.boxBoolean(z5));
            case 7:
                int i = c00032.I$0;
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.AniVortex.AniVortexProvider$getMainPage$2 */
    /* JADX INFO: compiled from: AniVortexProvider.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Triple;", "", "Lcom/lagradost/cloudstream3/HomePageList;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.AniVortex.AniVortexProvider$getMainPage$2", f = "AniVortexProvider.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {108, 108, 108}, m = "invokeSuspend", n = {"$this$coroutineScope", "movieDef", "animeDef", "ottDef", "$this$coroutineScope", "movieDef", "animeDef", "ottDef", "$this$coroutineScope", "movieDef", "animeDef", "ottDef"}, nl = {108, 108, -1}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"}, v = 2)
    static final class C00042 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Triple<? extends List<? extends HomePageList>, ? extends List<? extends HomePageList>, ? extends List<? extends HomePageList>>>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        C00042(Continuation<? super C00042> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00042 = AniVortexProvider.this.new C00042(continuation);
            c00042.L$0 = obj;
            return c00042;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Triple<? extends List<HomePageList>, ? extends List<HomePageList>, ? extends List<HomePageList>>> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:15:0x00c9 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:16:0x00ca  */
        /* JADX WARN: Code duplicated, block: B:19:0x00f7 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:20:0x00f8  */
        public final Object invokeSuspend(Object $result) {
            Deferred animeDef;
            Deferred ottDef;
            Object objAwait;
            Deferred movieDef;
            Object objAwait2;
            Deferred ottDef2;
            Object obj;
            Deferred movieDef2;
            Deferred movieDef3;
            Object objAwait3;
            Object obj2;
            CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Deferred movieDef4 = BuildersKt.async$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AniVortexProvider$getMainPage$2$movieDef$1(AniVortexProvider.this, null), 3, (Object) null);
                    animeDef = BuildersKt.async$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AniVortexProvider$getMainPage$2$animeDef$1(AniVortexProvider.this, null), 3, (Object) null);
                    ottDef = BuildersKt.async$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AniVortexProvider$getMainPage$2$ottDef$1(AniVortexProvider.this, null), 3, (Object) null);
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$coroutineScope);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(movieDef4);
                    this.L$2 = animeDef;
                    this.L$3 = ottDef;
                    this.label = 1;
                    objAwait = movieDef4.await((Continuation) this);
                    if (objAwait == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    movieDef = movieDef4;
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$coroutineScope);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(movieDef);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(animeDef);
                    this.L$3 = ottDef;
                    this.L$4 = objAwait;
                    this.label = 2;
                    objAwait2 = animeDef.await((Continuation) this);
                    if (objAwait2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Object obj3 = objAwait;
                    ottDef2 = ottDef;
                    obj = obj3;
                    movieDef2 = movieDef;
                    movieDef3 = animeDef;
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$coroutineScope);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(movieDef2);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(movieDef3);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(ottDef2);
                    this.L$4 = obj;
                    this.L$5 = objAwait2;
                    this.label = 3;
                    objAwait3 = ottDef2.await((Continuation) this);
                    if (objAwait3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj2 = objAwait2;
                    return new Triple(obj, obj2, objAwait3);
                case 1:
                    ottDef = (Deferred) this.L$3;
                    Deferred animeDef2 = (Deferred) this.L$2;
                    movieDef = (Deferred) this.L$1;
                    ResultKt.throwOnFailure($result);
                    animeDef = animeDef2;
                    objAwait = $result;
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$coroutineScope);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(movieDef);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(animeDef);
                    this.L$3 = ottDef;
                    this.L$4 = objAwait;
                    this.label = 2;
                    objAwait2 = animeDef.await((Continuation) this);
                    if (objAwait2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Object obj4 = objAwait;
                    ottDef2 = ottDef;
                    obj = obj4;
                    movieDef2 = movieDef;
                    movieDef3 = animeDef;
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$coroutineScope);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(movieDef2);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(movieDef3);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(ottDef2);
                    this.L$4 = obj;
                    this.L$5 = objAwait2;
                    this.label = 3;
                    objAwait3 = ottDef2.await((Continuation) this);
                    if (objAwait3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj2 = objAwait2;
                    return new Triple(obj, obj2, objAwait3);
                case 2:
                    obj = this.L$4;
                    ottDef2 = (Deferred) this.L$3;
                    movieDef3 = (Deferred) this.L$2;
                    Deferred movieDef5 = (Deferred) this.L$1;
                    ResultKt.throwOnFailure($result);
                    movieDef2 = movieDef5;
                    objAwait2 = $result;
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$coroutineScope);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(movieDef2);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(movieDef3);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(ottDef2);
                    this.L$4 = obj;
                    this.L$5 = objAwait2;
                    this.label = 3;
                    objAwait3 = ottDef2.await((Continuation) this);
                    if (objAwait3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj2 = objAwait2;
                    return new Triple(obj, obj2, objAwait3);
                case 3:
                    obj2 = this.L$5;
                    obj = this.L$4;
                    ResultKt.throwOnFailure($result);
                    objAwait3 = $result;
                    return new Triple(obj, obj2, objAwait3);
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:42:0x016a  */
    /* JADX WARN: Code duplicated, block: B:49:0x017a  */
    /* JADX WARN: Code duplicated, block: B:51:0x017d A[Catch: all -> 0x0186, TRY_LEAVE, TryCatch #0 {all -> 0x0186, blocks: (B:24:0x00fd, B:26:0x0101, B:30:0x011d, B:32:0x0121, B:34:0x0127, B:35:0x013c, B:37:0x0142, B:39:0x015a, B:41:0x0163, B:43:0x016b, B:45:0x0171, B:51:0x017d, B:29:0x0118), top: B:63:0x00fd, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x0184 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    public final Object fetchOttSection(String slug, String title, Continuation<? super HomePageList> continuation) {
        C00021 c00021;
        String title2;
        Object objApiGet;
        Object safe;
        OttTitlesResponse response;
        List items;
        List list;
        boolean z;
        Iterable items2;
        String slug2 = slug;
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
                try {
                    Pair pairBuildHeaders$default = AniVortexAuth.buildHeaders$default(AniVortexAuth.INSTANCE, "GET", "/api/v1/catalog/ott-platforms/" + slug2 + "/titles", MapsKt.mapOf(new Pair[]{TuplesKt.to("sort", "popular"), TuplesKt.to("include_adult", "false"), TuplesKt.to("limit", "20")}), null, 8, null);
                    String query = (String) pairBuildHeaders$default.component1();
                    Map<String, String> map = (Map) pairBuildHeaders$default.component2();
                    String url = getMainUrl() + "/api/v1/catalog/ott-platforms/" + slug2 + "/titles?" + query;
                    c00021.L$0 = slug2;
                    title2 = title;
                    try {
                        c00021.L$1 = title2;
                        c00021.L$2 = SpillingKt.nullOutSpilledVariable(query);
                        c00021.L$3 = SpillingKt.nullOutSpilledVariable(map);
                        c00021.L$4 = SpillingKt.nullOutSpilledVariable(url);
                        c00021.label = 1;
                        objApiGet = apiGet(url, map, c00021);
                        if (objApiGet == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        try {
                            NiceResponse this_$iv = (NiceResponse) objApiGet;
                            try {
                                ResponseParser parser = this_$iv.getParser();
                                Intrinsics.checkNotNull(parser);
                                safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(OttTitlesResponse.class));
                                break;
                            } catch (Exception e$iv) {
                                e$iv.printStackTrace();
                                safe = null;
                            }
                            response = (OttTitlesResponse) safe;
                            if (response != null || (items2 = response.getItems()) == null) {
                                items = null;
                            } else {
                                Iterable $this$mapNotNull$iv = items2;
                                Collection destination$iv$iv = new ArrayList();
                                for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                                    CatalogItem it = (CatalogItem) element$iv$iv$iv;
                                    SearchResponse searchResponse = toSearchResponse(it);
                                    if (searchResponse != null) {
                                        destination$iv$iv.add(searchResponse);
                                    }
                                }
                                items = (List) destination$iv$iv;
                            }
                            list = items;
                            if (list != null || list.isEmpty()) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                return null;
                            }
                            return new HomePageList(title2, items, false);
                        } catch (Throwable th) {
                            e = th;
                            Log.e("AniVortex", "Failed to fetch OTT section " + slug2 + ": " + e.getMessage());
                            return null;
                        }
                    } catch (Throwable th2) {
                        e = th2;
                        Log.e("AniVortex", "Failed to fetch OTT section " + slug2 + ": " + e.getMessage());
                        return null;
                    }
                } catch (Throwable th3) {
                    e = th3;
                }
                break;
            case 1:
                String title3 = (String) c00021.L$1;
                slug2 = (String) c00021.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    objApiGet = $result;
                    title2 = title3;
                    NiceResponse this_$iv2 = (NiceResponse) objApiGet;
                    ResponseParser parser2 = this_$iv2.getParser();
                    Intrinsics.checkNotNull(parser2);
                    safe = parser2.parseSafe(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(OttTitlesResponse.class));
                    response = (OttTitlesResponse) safe;
                    if (response != null) {
                        items = null;
                    } else {
                        items = null;
                    }
                    list = items;
                    if (list != null) {
                        z = true;
                    } else {
                        z = true;
                    }
                    if (z) {
                        return new HomePageList(title2, items, false);
                    }
                    return null;
                } catch (Throwable th4) {
                    e = th4;
                    Log.e("AniVortex", "Failed to fetch OTT section " + slug2 + ": " + e.getMessage());
                    return null;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    public final Object fetchCatalogHome(String catalog, Continuation<? super List<HomePageList>> continuation) throws Throwable {
        C00011 c00011;
        Object objApiGet;
        String url;
        Object safe;
        List items;
        HomePageList homePageList;
        AniVortexProvider aniVortexProvider = this;
        if (continuation instanceof C00011) {
            c00011 = (C00011) continuation;
            if ((c00011.label & Integer.MIN_VALUE) != 0) {
                c00011.label -= Integer.MIN_VALUE;
            } else {
                c00011 = aniVortexProvider.new C00011(continuation);
            }
        } else {
            c00011 = aniVortexProvider.new C00011(continuation);
        }
        Object $result = c00011.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00011.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Pair pairBuildHeaders$default = AniVortexAuth.buildHeaders$default(AniVortexAuth.INSTANCE, "GET", "/api/v1/catalog/home", MapsKt.mapOf(new Pair[]{TuplesKt.to("catalog", catalog), TuplesKt.to("include_adult", "false")}), null, 8, null);
                String query = (String) pairBuildHeaders$default.component1();
                Map<String, String> map = (Map) pairBuildHeaders$default.component2();
                String url2 = aniVortexProvider.getMainUrl() + "/api/v1/catalog/home?" + query;
                c00011.L$0 = catalog;
                c00011.L$1 = SpillingKt.nullOutSpilledVariable(query);
                c00011.L$2 = SpillingKt.nullOutSpilledVariable(map);
                c00011.L$3 = SpillingKt.nullOutSpilledVariable(url2);
                c00011.label = 1;
                objApiGet = aniVortexProvider.apiGet(url2, map, c00011);
                if (objApiGet == coroutine_suspended) {
                    return coroutine_suspended;
                }
                url = catalog;
                break;
                break;
            case 1:
                String catalog2 = (String) c00011.L$0;
                ResultKt.throwOnFailure($result);
                objApiGet = $result;
                url = catalog2;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NiceResponse this_$iv = (NiceResponse) objApiGet;
        try {
            ResponseParser parser = this_$iv.getParser();
            Intrinsics.checkNotNull(parser);
            safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(CatalogHomeResponse.class));
        } catch (Exception e$iv) {
            e$iv.printStackTrace();
            safe = null;
        }
        CatalogHomeResponse response = (CatalogHomeResponse) safe;
        if ((response != null ? response.getSections() : null) == null) {
            Log.e("AniVortex", "Failed to parse catalog home response for " + url);
            return CollectionsKt.emptyList();
        }
        Iterable $this$mapNotNull$iv = response.getSections();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            CatalogSection section = (CatalogSection) element$iv$iv$iv;
            Iterable items2 = section.getItems();
            if (items2 != null) {
                Iterable $this$mapNotNull$iv2 = items2;
                Collection destination$iv$iv2 = new ArrayList();
                for (Object element$iv$iv$iv2 : $this$mapNotNull$iv2) {
                    CatalogItem it = (CatalogItem) element$iv$iv$iv2;
                    SearchResponse searchResponse = aniVortexProvider.toSearchResponse(it);
                    if (searchResponse != null) {
                        destination$iv$iv2.add(searchResponse);
                    }
                }
                items = (List) destination$iv$iv2;
            } else {
                items = null;
            }
            List list = items;
            if (list == null || list.isEmpty()) {
                homePageList = null;
            } else {
                String title = section.getTitle();
                if (title == null && (title = section.getKey()) == null) {
                    title = "Featured";
                }
                String cleanTitle = aniVortexProvider.cleanSectionTitle(title, url);
                homePageList = new HomePageList(cleanTitle, items, Intrinsics.areEqual(section.getPresentation(), "hero"));
            }
            if (homePageList != null) {
                destination$iv$iv.add(homePageList);
            }
            aniVortexProvider = this;
            response = response;
        }
        return (List) destination$iv$iv;
    }

    private final String cleanSectionTitle(String title, String catalog) {
        String clean = StringsKt.trim(title).toString();
        if (StringsKt.contains$default(clean, "_", false, 2, (Object) null)) {
            clean = CollectionsKt.joinToString$default(StringsKt.split$default(clean, new String[]{"_"}, false, 0, 6, (Object) null), " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.AniVortex.AniVortexProvider$$ExternalSyntheticLambda25
                public final Object invoke(Object obj) {
                    return AniVortexProvider.cleanSectionTitle$lambda$0((String) obj);
                }
            }, 30, (Object) null);
        }
        if (Intrinsics.areEqual(catalog, "anime")) {
            if (StringsKt.equals(clean, "Latest", true)) {
                clean = "Latest Anime";
            } else if (StringsKt.equals(clean, "Recently Added", true)) {
                clean = "Recently Added Anime";
            } else if (StringsKt.equals(clean, "Top Rated", true)) {
                clean = "Top Rated Anime";
            } else if (StringsKt.equals(clean, "Popular", true)) {
                clean = "Popular Anime";
            } else if (StringsKt.equals(clean, "Action", true)) {
                clean = "Action Anime";
            } else if (StringsKt.equals(clean, "Romance", true)) {
                clean = "Romance Anime";
            } else if (StringsKt.equals(clean, "Comedy", true)) {
                clean = "Comedy Anime";
            }
        } else if (StringsKt.equals(clean, "Popular", true)) {
            clean = "Popular Series";
        } else if (StringsKt.equals(clean, "Action", true)) {
            clean = "Action Movies";
        }
        return StringsKt.replace(StringsKt.replace(clean, "On Imdb", "on IMDb", true), "Imdb", "IMDb", true);
    }

    static final CharSequence cleanSectionTitle$lambda$0(String part) {
        String string;
        if (part.length() > 0) {
            StringBuilder sb = new StringBuilder();
            char it = part.charAt(0);
            StringBuilder sbAppend = sb.append((Object) (Character.isLowerCase(it) ? CharsKt.titlecase(it, Locale.ROOT) : String.valueOf(it)));
            String strSubstring = part.substring(1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            string = sbAppend.append(strSubstring).toString();
        } else {
            string = part;
        }
        return string;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ List mergeAndSortHomeSections$default(AniVortexProvider aniVortexProvider, List list, List list2, List list3, int i, Object obj) {
        if ((i & 4) != 0) {
            list3 = CollectionsKt.emptyList();
        }
        return aniVortexProvider.mergeAndSortHomeSections(list, list2, list3);
    }

    private final List<HomePageList> mergeAndSortHomeSections(List<HomePageList> movieSections, List<HomePageList> animeSections, List<HomePageList> ottSections) {
        List result = new ArrayList();
        Set used = new LinkedHashSet();
        mergeAndSortHomeSections$addMatching(result, used, movieSections, new Function1() { // from class: com.AniVortex.AniVortexProvider$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return Boolean.valueOf(((HomePageList) obj).isHorizontalImages());
            }
        });
        if (result.isEmpty()) {
            mergeAndSortHomeSections$addMatching(result, used, animeSections, new Function1() { // from class: com.AniVortex.AniVortexProvider$$ExternalSyntheticLambda11
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(((HomePageList) obj).isHorizontalImages());
                }
            });
        }
        mergeAndSortHomeSections$addMatching(result, used, animeSections, new Function1() { // from class: com.AniVortex.AniVortexProvider$$ExternalSyntheticLambda12
            public final Object invoke(Object obj) {
                return Boolean.valueOf(StringsKt.contains(((HomePageList) obj).getName(), "latest", true));
            }
        });
        mergeAndSortHomeSections$addMatching(result, used, movieSections, new Function1() { // from class: com.AniVortex.AniVortexProvider$$ExternalSyntheticLambda13
            public final Object invoke(Object obj) {
                return Boolean.valueOf(AniVortexProvider.mergeAndSortHomeSections$lambda$4((HomePageList) obj));
            }
        });
        mergeAndSortHomeSections$addMatching(result, used, movieSections, new Function1() { // from class: com.AniVortex.AniVortexProvider$$ExternalSyntheticLambda14
            public final Object invoke(Object obj) {
                return Boolean.valueOf(AniVortexProvider.mergeAndSortHomeSections$lambda$5((HomePageList) obj));
            }
        });
        mergeAndSortHomeSections$addMatching(result, used, ottSections, new Function1() { // from class: com.AniVortex.AniVortexProvider$$ExternalSyntheticLambda15
            public final Object invoke(Object obj) {
                return Boolean.valueOf(StringsKt.contains(((HomePageList) obj).getName(), "netflix", true));
            }
        });
        mergeAndSortHomeSections$addMatching(result, used, ottSections, new Function1() { // from class: com.AniVortex.AniVortexProvider$$ExternalSyntheticLambda16
            public final Object invoke(Object obj) {
                return Boolean.valueOf(StringsKt.contains(((HomePageList) obj).getName(), "prime", true));
            }
        });
        mergeAndSortHomeSections$addMatching(result, used, ottSections, new Function1() { // from class: com.AniVortex.AniVortexProvider$$ExternalSyntheticLambda17
            public final Object invoke(Object obj) {
                return Boolean.valueOf(StringsKt.contains(((HomePageList) obj).getName(), "hotstar", true));
            }
        });
        mergeAndSortHomeSections$addMatching(result, used, ottSections, new Function1() { // from class: com.AniVortex.AniVortexProvider$$ExternalSyntheticLambda18
            public final Object invoke(Object obj) {
                return Boolean.valueOf(StringsKt.contains(((HomePageList) obj).getName(), "crunchyroll", true));
            }
        });
        mergeAndSortHomeSections$addMatching(result, used, movieSections, new Function1() { // from class: com.AniVortex.AniVortexProvider$$ExternalSyntheticLambda19
            public final Object invoke(Object obj) {
                return Boolean.valueOf(AniVortexProvider.mergeAndSortHomeSections$lambda$10((HomePageList) obj));
            }
        });
        mergeAndSortHomeSections$addMatching(result, used, movieSections, new Function1() { // from class: com.AniVortex.AniVortexProvider$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(AniVortexProvider.mergeAndSortHomeSections$lambda$11((HomePageList) obj));
            }
        });
        mergeAndSortHomeSections$addMatching(result, used, ottSections, new Function1() { // from class: com.AniVortex.AniVortexProvider$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return Boolean.valueOf(StringsKt.contains(((HomePageList) obj).getName(), "sonyliv", true));
            }
        });
        mergeAndSortHomeSections$addMatching(result, used, ottSections, new Function1() { // from class: com.AniVortex.AniVortexProvider$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                return Boolean.valueOf(StringsKt.contains(((HomePageList) obj).getName(), "zee5", true));
            }
        });
        mergeAndSortHomeSections$addMatching(result, used, animeSections, new Function1() { // from class: com.AniVortex.AniVortexProvider$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                return Boolean.valueOf(AniVortexProvider.mergeAndSortHomeSections$lambda$14((HomePageList) obj));
            }
        });
        mergeAndSortHomeSections$addMatching(result, used, movieSections, new Function1() { // from class: com.AniVortex.AniVortexProvider$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                return Boolean.valueOf(AniVortexProvider.mergeAndSortHomeSections$lambda$15((HomePageList) obj));
            }
        });
        mergeAndSortHomeSections$addMatching(result, used, movieSections, new Function1() { // from class: com.AniVortex.AniVortexProvider$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                return Boolean.valueOf(AniVortexProvider.mergeAndSortHomeSections$lambda$16((HomePageList) obj));
            }
        });
        mergeAndSortHomeSections$addMatching(result, used, movieSections, new Function1() { // from class: com.AniVortex.AniVortexProvider$$ExternalSyntheticLambda7
            public final Object invoke(Object obj) {
                return Boolean.valueOf(StringsKt.contains(((HomePageList) obj).getName(), "popular", true));
            }
        });
        mergeAndSortHomeSections$addMatching(result, used, animeSections, new Function1() { // from class: com.AniVortex.AniVortexProvider$$ExternalSyntheticLambda8
            public final Object invoke(Object obj) {
                return Boolean.valueOf(StringsKt.contains(((HomePageList) obj).getName(), "popular", true));
            }
        });
        List<HomePageList> $this$forEach$iv = ottSections;
        for (Object element$iv : $this$forEach$iv) {
            HomePageList it = (HomePageList) element$iv;
            if (!used.contains(it.getName())) {
                result.add(it);
                used.add(it.getName());
            }
        }
        mergeAndSortHomeSections$addMatching(result, used, animeSections, new Function1() { // from class: com.AniVortex.AniVortexProvider$$ExternalSyntheticLambda9
            public final Object invoke(Object obj) {
                return Boolean.valueOf(StringsKt.contains(((HomePageList) obj).getName(), "action", true));
            }
        });
        mergeAndSortHomeSections$addMatching(result, used, movieSections, new Function1() { // from class: com.AniVortex.AniVortexProvider$$ExternalSyntheticLambda10
            public final Object invoke(Object obj) {
                return Boolean.valueOf(StringsKt.contains(((HomePageList) obj).getName(), "action", true));
            }
        });
        List<HomePageList> $this$forEach$iv2 = animeSections;
        for (Object element$iv2 : $this$forEach$iv2) {
            HomePageList it2 = (HomePageList) element$iv2;
            if (!used.contains(it2.getName()) && !it2.isHorizontalImages()) {
                result.add(it2);
                used.add(it2.getName());
            }
        }
        List<HomePageList> $this$forEach$iv3 = movieSections;
        for (Object element$iv3 : $this$forEach$iv3) {
            HomePageList it3 = (HomePageList) element$iv3;
            if (!used.contains(it3.getName()) && !it3.isHorizontalImages()) {
                result.add(it3);
                used.add(it3.getName());
            }
        }
        return result;
    }

    private static final void mergeAndSortHomeSections$addMatching(List<HomePageList> list, Set<String> set, List<HomePageList> list2, Function1<? super HomePageList, Boolean> function1) {
        Object element$iv;
        HomePageList it;
        List<HomePageList> $this$firstOrNull$iv = list2;
        Iterator it2 = $this$firstOrNull$iv.iterator();
        do {
            if (!it2.hasNext()) {
                element$iv = null;
                break;
            } else {
                element$iv = it2.next();
                it = (HomePageList) element$iv;
            }
        } while (!(((Boolean) function1.invoke(it)).booleanValue() && !set.contains(it.getName())));
        HomePageList item = (HomePageList) element$iv;
        if (item != null) {
            list.add(item);
            set.add(item.getName());
        }
    }

    static final boolean mergeAndSortHomeSections$lambda$4(HomePageList it) {
        return StringsKt.contains(it.getName(), "recent", true) && StringsKt.contains(it.getName(), "movie", true);
    }

    static final boolean mergeAndSortHomeSections$lambda$5(HomePageList it) {
        return StringsKt.contains(it.getName(), "recent", true) && (StringsKt.contains(it.getName(), "series", true) || StringsKt.contains(it.getName(), "tv", true));
    }

    static final boolean mergeAndSortHomeSections$lambda$10(HomePageList it) {
        return StringsKt.contains(it.getName(), "week", true) && StringsKt.contains(it.getName(), "movie", true);
    }

    static final boolean mergeAndSortHomeSections$lambda$11(HomePageList it) {
        return StringsKt.contains(it.getName(), "week", true) && (StringsKt.contains(it.getName(), "series", true) || StringsKt.contains(it.getName(), "tv", true));
    }

    static final boolean mergeAndSortHomeSections$lambda$14(HomePageList it) {
        return StringsKt.contains(it.getName(), "top", true) || StringsKt.contains(it.getName(), "rated", true);
    }

    static final boolean mergeAndSortHomeSections$lambda$15(HomePageList it) {
        return StringsKt.contains(it.getName(), "imdb", true) && StringsKt.contains(it.getName(), "movie", true);
    }

    static final boolean mergeAndSortHomeSections$lambda$16(HomePageList it) {
        return StringsKt.contains(it.getName(), "imdb", true) && (StringsKt.contains(it.getName(), "series", true) || StringsKt.contains(it.getName(), "tv", true));
    }

    private final Score formatScore(Double rating) {
        if (rating == null || rating.doubleValue() <= 0.0d) {
            return null;
        }
        Score.Companion companion = Score.Companion;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, "%.1f", Arrays.copyOf(new Object[]{rating}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return companion.from10(str);
    }

    @Nullable
    public Object quickSearch(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        return search(query, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x00c8 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:21:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:29:0x00f4 A[ADDED_TO_REGION, RETURN] */
    /* JADX WARN: Code duplicated, block: B:30:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:35:0x0113  */
    /* JADX WARN: Code duplicated, block: B:37:0x0129  */
    /* JADX WARN: Code duplicated, block: B:46:0x012e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) throws Throwable {
        C00101 c00101;
        String query2;
        Object objApiGet;
        Object safe;
        AniVortexSearchResponse response;
        Iterable items;
        Collection destination$iv$iv;
        SearchResponse searchResponse;
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
                AniVortexRegistration aniVortexRegistration = AniVortexRegistration.INSTANCE;
                c00102.L$0 = query;
                c00102.label = 1;
                if (aniVortexRegistration.ensureRegistered(c00102) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                query2 = query;
                Pair pairBuildHeaders$default = AniVortexAuth.buildHeaders$default(AniVortexAuth.INSTANCE, "GET", "/api/v1/search", MapsKt.mapOf(TuplesKt.to("q", query2)), null, 8, null);
                String queryString = (String) pairBuildHeaders$default.component1();
                Map<String, String> map = (Map) pairBuildHeaders$default.component2();
                String url = getMainUrl() + "/api/v1/search?" + queryString;
                c00102.L$0 = SpillingKt.nullOutSpilledVariable(query2);
                c00102.L$1 = SpillingKt.nullOutSpilledVariable(queryString);
                c00102.L$2 = SpillingKt.nullOutSpilledVariable(map);
                c00102.L$3 = SpillingKt.nullOutSpilledVariable(url);
                c00102.label = 2;
                objApiGet = apiGet(url, map, c00102);
                if (objApiGet == coroutine_suspended) {
                    return coroutine_suspended;
                }
                NiceResponse this_$iv = (NiceResponse) objApiGet;
                try {
                    ResponseParser parser = this_$iv.getParser();
                    Intrinsics.checkNotNull(parser);
                    safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(AniVortexSearchResponse.class));
                    break;
                } catch (Exception e$iv) {
                    e$iv.printStackTrace();
                    safe = null;
                }
                response = (AniVortexSearchResponse) safe;
                if (response == null && (items = response.getItems()) != null) {
                    Iterable $this$mapNotNull$iv = items;
                    destination$iv$iv = new ArrayList();
                    for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                        AniVortexSearchResponse response2 = response;
                        CatalogItem it = (CatalogItem) element$iv$iv$iv;
                        searchResponse = toSearchResponse(it);
                        if (searchResponse != null) {
                            destination$iv$iv.add(searchResponse);
                        }
                        response = response2;
                    }
                    return (List) destination$iv$iv;
                }
                return null;
            case 1:
                query2 = (String) c00102.L$0;
                ResultKt.throwOnFailure($result);
                Pair pairBuildHeaders$default2 = AniVortexAuth.buildHeaders$default(AniVortexAuth.INSTANCE, "GET", "/api/v1/search", MapsKt.mapOf(TuplesKt.to("q", query2)), null, 8, null);
                String queryString2 = (String) pairBuildHeaders$default2.component1();
                Map<String, String> map2 = (Map) pairBuildHeaders$default2.component2();
                String url2 = getMainUrl() + "/api/v1/search?" + queryString2;
                c00102.L$0 = SpillingKt.nullOutSpilledVariable(query2);
                c00102.L$1 = SpillingKt.nullOutSpilledVariable(queryString2);
                c00102.L$2 = SpillingKt.nullOutSpilledVariable(map2);
                c00102.L$3 = SpillingKt.nullOutSpilledVariable(url2);
                c00102.label = 2;
                objApiGet = apiGet(url2, map2, c00102);
                if (objApiGet == coroutine_suspended) {
                    return coroutine_suspended;
                }
                NiceResponse this_$iv2 = (NiceResponse) objApiGet;
                ResponseParser parser2 = this_$iv2.getParser();
                Intrinsics.checkNotNull(parser2);
                safe = parser2.parseSafe(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(AniVortexSearchResponse.class));
                response = (AniVortexSearchResponse) safe;
                if (response == null) {
                    return null;
                }
                Iterable $this$mapNotNull$iv2 = items;
                destination$iv$iv = new ArrayList();
                while (r16.hasNext()) {
                    AniVortexSearchResponse response3 = response;
                    CatalogItem it2 = (CatalogItem) element$iv$iv$iv;
                    searchResponse = toSearchResponse(it2);
                    if (searchResponse != null) {
                        destination$iv$iv.add(searchResponse);
                    }
                    response = response3;
                }
                return (List) destination$iv$iv;
            case 2:
                ResultKt.throwOnFailure($result);
                objApiGet = $result;
                NiceResponse this_$iv3 = (NiceResponse) objApiGet;
                ResponseParser parser3 = this_$iv3.getParser();
                Intrinsics.checkNotNull(parser3);
                safe = parser3.parseSafe(this_$iv3.getText(), Reflection.getOrCreateKotlinClass(AniVortexSearchResponse.class));
                response = (AniVortexSearchResponse) safe;
                if (response == null) {
                    return null;
                }
                Iterable $this$mapNotNull$iv3 = items;
                destination$iv$iv = new ArrayList();
                while (r16.hasNext()) {
                    AniVortexSearchResponse response4 = response;
                    CatalogItem it3 = (CatalogItem) element$iv$iv$iv;
                    searchResponse = toSearchResponse(it3);
                    if (searchResponse != null) {
                        destination$iv$iv.add(searchResponse);
                    }
                    response = response4;
                }
                return (List) destination$iv$iv;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:128:0x06cb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:129:0x06cd  */
    /* JADX WARN: Code duplicated, block: B:131:0x06d4  */
    /* JADX WARN: Code duplicated, block: B:138:0x06e8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:139:0x06ea  */
    /* JADX WARN: Code duplicated, block: B:141:0x06f1  */
    /* JADX WARN: Code duplicated, block: B:226:0x0aa5  */
    /* JADX WARN: Code duplicated, block: B:228:0x0ab7  */
    /* JADX WARN: Code duplicated, block: B:230:0x0be8 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:231:0x0be9  */
    /* JADX WARN: Code duplicated, block: B:248:0x0c46  */
    /* JADX WARN: Code duplicated, block: B:259:0x0ccb  */
    /* JADX WARN: Code duplicated, block: B:261:0x0cf3  */
    /* JADX WARN: Code duplicated, block: B:74:0x0575  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:231:0x0be9 -> B:232:0x0c11). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:261:0x0cf3 -> B:262:0x0d15). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object load(@org.jetbrains.annotations.NotNull java.lang.String r58, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r59) {
        /*
            Method dump skipped, instruction units count: 4054
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.AniVortex.AniVortexProvider.load(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.AniVortex.AniVortexProvider$load$2 */
    /* JADX INFO: compiled from: AniVortexProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.AniVortex.AniVortexProvider$load$2", f = "AniVortexProvider.kt", i = {0, 0}, l = {506}, m = "invokeSuspend", n = {"$this$newMovieLoadResponse", "it"}, nl = {506}, s = {"L$0", "L$1"}, v = 2)
    @SourceDebugExtension({"SMAP\nAniVortexProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AniVortexProvider.kt\ncom/AniVortex/AniVortexProvider$load$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,713:1\n1#2:714\n*E\n"})
    static final class C00062 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<ActorData> $actorsList;
        final /* synthetic */ String $finalBackdrop;
        final /* synthetic */ String $finalPlot;
        final /* synthetic */ String $finalPoster;
        final /* synthetic */ Score $finalScore;
        final /* synthetic */ List<String> $finalTags;
        final /* synthetic */ List<SearchResponse> $recommendationsList;
        final /* synthetic */ TmdbMetadata $tmdb;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00062(String str, String str2, TmdbMetadata tmdbMetadata, String str3, List<String> list, Integer num, Score score, List<? extends SearchResponse> list2, List<ActorData> list3, Continuation<? super C00062> continuation) {
            super(2, continuation);
            this.$finalPoster = str;
            this.$finalBackdrop = str2;
            this.$tmdb = tmdbMetadata;
            this.$finalPlot = str3;
            this.$finalTags = list;
            this.$year = num;
            this.$finalScore = score;
            this.$recommendationsList = list2;
            this.$actorsList = list3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00062 = new C00062(this.$finalPoster, this.$finalBackdrop, this.$tmdb, this.$finalPlot, this.$finalTags, this.$year, this.$finalScore, this.$recommendationsList, this.$actorsList, continuation);
            c00062.L$0 = obj;
            return c00062;
        }

        public final Object invoke(MovieLoadResponse movieLoadResponse, Continuation<? super Unit> continuation) {
            return create(movieLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            String it;
            Integer tmdbId;
            String it2;
            LoadResponse loadResponse = (MovieLoadResponse) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    loadResponse.setPosterUrl(this.$finalPoster);
                    loadResponse.setBackgroundPosterUrl(this.$finalBackdrop);
                    try {
                        TmdbMetadata tmdbMetadata = this.$tmdb;
                        loadResponse.setLogoUrl(tmdbMetadata != null ? tmdbMetadata.getLogoUrl() : null);
                        break;
                    } catch (Throwable th) {
                    }
                    loadResponse.setPlot(this.$finalPlot);
                    loadResponse.setTags(this.$finalTags);
                    loadResponse.setYear(this.$year);
                    loadResponse.setScore(this.$finalScore);
                    loadResponse.setRecommendations(this.$recommendationsList);
                    List<ActorData> list = this.$actorsList;
                    if (!(list == null || list.isEmpty())) {
                        loadResponse.setActors(this.$actorsList);
                    }
                    TmdbMetadata tmdbMetadata2 = this.$tmdb;
                    if (tmdbMetadata2 != null && (it = tmdbMetadata2.getTrailerUrl()) != null) {
                        this.L$0 = loadResponse;
                        this.L$1 = SpillingKt.nullOutSpilledVariable(it);
                        this.label = 1;
                        if (LoadResponse.Companion.addTrailer$default(LoadResponse.Companion, loadResponse, it, (String) null, false, this, 6, (Object) null) == coroutine_suspended) {
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
            TmdbMetadata tmdbMetadata3 = this.$tmdb;
            if (tmdbMetadata3 != null && (it2 = tmdbMetadata3.getImdbId()) != null) {
                LoadResponse.Companion.addImdbId(loadResponse, it2);
            }
            TmdbMetadata tmdbMetadata4 = this.$tmdb;
            if (tmdbMetadata4 != null && (tmdbId = tmdbMetadata4.getTmdbId()) != null) {
                LoadResponse.Companion.addTMDbId(loadResponse, String.valueOf(tmdbId.intValue()));
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$8$0$0(EpisodeInfo $ep, SeasonInfo $season, String $finalPoster, Episode $this$newEpisode) {
        Integer numValueOf;
        String title = $ep.getTitle();
        if (title == null) {
            StringBuilder sbAppend = new StringBuilder().append("Episode ");
            Integer episodeNumber = $ep.getEpisodeNumber();
            title = sbAppend.append(episodeNumber != null ? episodeNumber.intValue() : 1).toString();
        }
        $this$newEpisode.setName(title);
        $this$newEpisode.setEpisode($ep.getEpisodeNumber());
        Integer seasonNumber = $ep.getSeasonNumber();
        if (seasonNumber == null) {
            seasonNumber = $season.getSeasonNumber();
        }
        $this$newEpisode.setSeason(seasonNumber);
        String thumbnailUrl = $ep.getThumbnailUrl();
        if (thumbnailUrl == null) {
            thumbnailUrl = $finalPoster;
        }
        $this$newEpisode.setPosterUrl(thumbnailUrl);
        $this$newEpisode.setDescription($ep.getDescription());
        Integer durationSeconds = $ep.getDurationSeconds();
        if (durationSeconds != null) {
            int it = durationSeconds.intValue();
            numValueOf = Integer.valueOf(it / 60);
        } else {
            numValueOf = null;
        }
        $this$newEpisode.setRunTime(numValueOf);
        MainAPIKt.addDate$default($this$newEpisode, $ep.getReleaseDate(), (String) null, 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.AniVortex.AniVortexProvider$load$4 */
    /* JADX INFO: compiled from: AniVortexProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.AniVortex.AniVortexProvider$load$4", f = "AniVortexProvider.kt", i = {0, 0}, l = {570}, m = "invokeSuspend", n = {"$this$newMovieLoadResponse", "it"}, nl = {570}, s = {"L$0", "L$1"}, v = 2)
    @SourceDebugExtension({"SMAP\nAniVortexProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AniVortexProvider.kt\ncom/AniVortex/AniVortexProvider$load$4\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,713:1\n1#2:714\n*E\n"})
    static final class C00074 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<ActorData> $actorsList;
        final /* synthetic */ String $finalBackdrop;
        final /* synthetic */ String $finalPlot;
        final /* synthetic */ String $finalPoster;
        final /* synthetic */ Score $finalScore;
        final /* synthetic */ List<String> $finalTags;
        final /* synthetic */ List<SearchResponse> $recommendationsList;
        final /* synthetic */ TmdbMetadata $tmdb;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00074(String str, String str2, TmdbMetadata tmdbMetadata, String str3, List<String> list, Integer num, Score score, List<? extends SearchResponse> list2, List<ActorData> list3, Continuation<? super C00074> continuation) {
            super(2, continuation);
            this.$finalPoster = str;
            this.$finalBackdrop = str2;
            this.$tmdb = tmdbMetadata;
            this.$finalPlot = str3;
            this.$finalTags = list;
            this.$year = num;
            this.$finalScore = score;
            this.$recommendationsList = list2;
            this.$actorsList = list3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00074 = new C00074(this.$finalPoster, this.$finalBackdrop, this.$tmdb, this.$finalPlot, this.$finalTags, this.$year, this.$finalScore, this.$recommendationsList, this.$actorsList, continuation);
            c00074.L$0 = obj;
            return c00074;
        }

        public final Object invoke(MovieLoadResponse movieLoadResponse, Continuation<? super Unit> continuation) {
            return create(movieLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            String it;
            Integer tmdbId;
            String it2;
            LoadResponse loadResponse = (MovieLoadResponse) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    loadResponse.setPosterUrl(this.$finalPoster);
                    loadResponse.setBackgroundPosterUrl(this.$finalBackdrop);
                    try {
                        TmdbMetadata tmdbMetadata = this.$tmdb;
                        loadResponse.setLogoUrl(tmdbMetadata != null ? tmdbMetadata.getLogoUrl() : null);
                        break;
                    } catch (Throwable th) {
                    }
                    loadResponse.setPlot(this.$finalPlot);
                    loadResponse.setTags(this.$finalTags);
                    loadResponse.setYear(this.$year);
                    loadResponse.setScore(this.$finalScore);
                    loadResponse.setRecommendations(this.$recommendationsList);
                    List<ActorData> list = this.$actorsList;
                    if (!(list == null || list.isEmpty())) {
                        loadResponse.setActors(this.$actorsList);
                    }
                    TmdbMetadata tmdbMetadata2 = this.$tmdb;
                    if (tmdbMetadata2 != null && (it = tmdbMetadata2.getTrailerUrl()) != null) {
                        this.L$0 = loadResponse;
                        this.L$1 = SpillingKt.nullOutSpilledVariable(it);
                        this.label = 1;
                        if (LoadResponse.Companion.addTrailer$default(LoadResponse.Companion, loadResponse, it, (String) null, false, this, 6, (Object) null) == coroutine_suspended) {
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
            TmdbMetadata tmdbMetadata3 = this.$tmdb;
            if (tmdbMetadata3 != null && (it2 = tmdbMetadata3.getImdbId()) != null) {
                LoadResponse.Companion.addImdbId(loadResponse, it2);
            }
            TmdbMetadata tmdbMetadata4 = this.$tmdb;
            if (tmdbMetadata4 != null && (tmdbId = tmdbMetadata4.getTmdbId()) != null) {
                LoadResponse.Companion.addTMDbId(loadResponse, String.valueOf(tmdbId.intValue()));
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.AniVortex.AniVortexProvider$load$5 */
    /* JADX INFO: compiled from: AniVortexProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.AniVortex.AniVortexProvider$load$5", f = "AniVortexProvider.kt", i = {0, 0}, l = {586}, m = "invokeSuspend", n = {"$this$newTvSeriesLoadResponse", "it"}, nl = {586}, s = {"L$0", "L$1"}, v = 2)
    @SourceDebugExtension({"SMAP\nAniVortexProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AniVortexProvider.kt\ncom/AniVortex/AniVortexProvider$load$5\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,713:1\n1#2:714\n*E\n"})
    static final class C00085 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<ActorData> $actorsList;
        final /* synthetic */ String $finalBackdrop;
        final /* synthetic */ String $finalPlot;
        final /* synthetic */ String $finalPoster;
        final /* synthetic */ Score $finalScore;
        final /* synthetic */ List<String> $finalTags;
        final /* synthetic */ List<SearchResponse> $recommendationsList;
        final /* synthetic */ TmdbMetadata $tmdb;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00085(String str, String str2, TmdbMetadata tmdbMetadata, String str3, List<String> list, Integer num, Score score, List<? extends SearchResponse> list2, List<ActorData> list3, Continuation<? super C00085> continuation) {
            super(2, continuation);
            this.$finalPoster = str;
            this.$finalBackdrop = str2;
            this.$tmdb = tmdbMetadata;
            this.$finalPlot = str3;
            this.$finalTags = list;
            this.$year = num;
            this.$finalScore = score;
            this.$recommendationsList = list2;
            this.$actorsList = list3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00085 = new C00085(this.$finalPoster, this.$finalBackdrop, this.$tmdb, this.$finalPlot, this.$finalTags, this.$year, this.$finalScore, this.$recommendationsList, this.$actorsList, continuation);
            c00085.L$0 = obj;
            return c00085;
        }

        public final Object invoke(TvSeriesLoadResponse tvSeriesLoadResponse, Continuation<? super Unit> continuation) {
            return create(tvSeriesLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            String it;
            Integer tmdbId;
            String it2;
            LoadResponse loadResponse = (TvSeriesLoadResponse) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    loadResponse.setPosterUrl(this.$finalPoster);
                    loadResponse.setBackgroundPosterUrl(this.$finalBackdrop);
                    try {
                        TmdbMetadata tmdbMetadata = this.$tmdb;
                        loadResponse.setLogoUrl(tmdbMetadata != null ? tmdbMetadata.getLogoUrl() : null);
                        break;
                    } catch (Throwable th) {
                    }
                    loadResponse.setPlot(this.$finalPlot);
                    loadResponse.setTags(this.$finalTags);
                    loadResponse.setYear(this.$year);
                    loadResponse.setScore(this.$finalScore);
                    loadResponse.setRecommendations(this.$recommendationsList);
                    List<ActorData> list = this.$actorsList;
                    if (!(list == null || list.isEmpty())) {
                        loadResponse.setActors(this.$actorsList);
                    }
                    TmdbMetadata tmdbMetadata2 = this.$tmdb;
                    if (tmdbMetadata2 != null && (it = tmdbMetadata2.getTrailerUrl()) != null) {
                        this.L$0 = loadResponse;
                        this.L$1 = SpillingKt.nullOutSpilledVariable(it);
                        this.label = 1;
                        if (LoadResponse.Companion.addTrailer$default(LoadResponse.Companion, loadResponse, it, (String) null, false, this, 6, (Object) null) == coroutine_suspended) {
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
            TmdbMetadata tmdbMetadata3 = this.$tmdb;
            if (tmdbMetadata3 != null && (it2 = tmdbMetadata3.getImdbId()) != null) {
                LoadResponse.Companion.addImdbId(loadResponse, it2);
            }
            TmdbMetadata tmdbMetadata4 = this.$tmdb;
            if (tmdbMetadata4 != null && (tmdbId = tmdbMetadata4.getTmdbId()) != null) {
                LoadResponse.Companion.addTMDbId(loadResponse, String.valueOf(tmdbId.intValue()));
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x047a  */
    /* JADX WARN: Code duplicated, block: B:122:0x0616  */
    /* JADX WARN: Code duplicated, block: B:178:0x02b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:34:0x02ab  */
    /* JADX WARN: Code duplicated, block: B:44:0x02c7 A[Catch: Exception -> 0x02df, TRY_LEAVE, TryCatch #1 {Exception -> 0x02df, blocks: (B:25:0x0277, B:32:0x02a5, B:35:0x02ac, B:44:0x02c7, B:43:0x02c1, B:31:0x029a, B:24:0x026d, B:28:0x027e, B:21:0x0254, B:38:0x02b2), top: B:170:0x0254, inners: #4, #5, #7 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:93:0x0456 A[PHI: r0 r1 r2 r3 r4 r5 r6 r7 r8 r9 r10 r11 r12 r13 r14 r20 r21 r22 r23
      0x0456: PHI (r0v90 kotlin.coroutines.Continuation<? super java.lang.Boolean>) = 
      (r0v44 kotlin.coroutines.Continuation<? super java.lang.Boolean>)
      (r0v83 kotlin.coroutines.Continuation<? super java.lang.Boolean>)
      (r0v93 kotlin.coroutines.Continuation<? super java.lang.Boolean>)
     binds: [B:92:0x0435, B:121:0x0614, B:134:0x0769] A[DONT_GENERATE, DONT_INLINE]
      0x0456: PHI (r1v19 'playback' com.AniVortex.PlaybackResponse) = 
      (r1v6 'playback' com.AniVortex.PlaybackResponse)
      (r1v12 'playback' com.AniVortex.PlaybackResponse)
      (r1v22 'playback' com.AniVortex.PlaybackResponse)
     binds: [B:92:0x0435, B:121:0x0614, B:134:0x0769] A[DONT_GENERATE, DONT_INLINE]
      0x0456: PHI (r2v31 'serverName' java.lang.String) = (r2v16 'serverName' java.lang.String), (r2v21 'serverName' java.lang.String), (r2v34 'serverName' java.lang.String) binds: [B:92:0x0435, B:121:0x0614, B:134:0x0769] A[DONT_GENERATE, DONT_INLINE]
      0x0456: PHI (r3v16 '$this$forEach$iv' java.lang.Iterable) = 
      (r3v1 '$this$forEach$iv' java.lang.Iterable)
      (r3v5 '$this$forEach$iv' java.lang.Iterable)
      (r3v21 '$this$forEach$iv' java.lang.Iterable)
     binds: [B:92:0x0435, B:121:0x0614, B:134:0x0769] A[DONT_GENERATE, DONT_INLINE]
      0x0456: PHI (r4v11 'titleId' int) = (r4v2 'titleId' int), (r4v5 'titleId' int), (r4v13 'titleId' int) binds: [B:92:0x0435, B:121:0x0614, B:134:0x0769] A[DONT_GENERATE, DONT_INLINE]
      0x0456: PHI (r5v10 com.AniVortex.AniVortexProvider$loadLinks$1) = 
      (r5v1 com.AniVortex.AniVortexProvider$loadLinks$1)
      (r5v5 com.AniVortex.AniVortexProvider$loadLinks$1)
      (r5v14 com.AniVortex.AniVortexProvider$loadLinks$1)
     binds: [B:92:0x0435, B:121:0x0614, B:134:0x0769] A[DONT_GENERATE, DONT_INLINE]
      0x0456: PHI (r6v37 '$result' java.lang.Object) = (r6v22 '$result' java.lang.Object), (r6v27 '$result' java.lang.Object), (r6v42 '$result' java.lang.Object) binds: [B:92:0x0435, B:121:0x0614, B:134:0x0769] A[DONT_GENERATE, DONT_INLINE]
      0x0456: PHI (r7v31 java.lang.Object) = (r7v16 java.lang.Object), (r7v22 java.lang.Object), (r7v35 java.lang.Object) binds: [B:92:0x0435, B:121:0x0614, B:134:0x0769] A[DONT_GENERATE, DONT_INLINE]
      0x0456: PHI (r8v24 'isCasting' boolean) = (r8v11 'isCasting' boolean), (r8v18 'isCasting' boolean), (r8v26 'isCasting' boolean) binds: [B:92:0x0435, B:121:0x0614, B:134:0x0769] A[DONT_GENERATE, DONT_INLINE]
      0x0456: PHI (r9v20 'query' java.lang.String) = (r9v9 'query' java.lang.String), (r9v15 'query' java.lang.String), (r9v24 'query' java.lang.String) binds: [B:92:0x0435, B:121:0x0614, B:134:0x0769] A[DONT_GENERATE, DONT_INLINE]
      0x0456: PHI (r10v22 java.util.Map<java.lang.String, java.lang.String>) = 
      (r10v11 java.util.Map<java.lang.String, java.lang.String>)
      (r10v17 java.util.Map<java.lang.String, java.lang.String>)
      (r10v24 java.util.Map<java.lang.String, java.lang.String>)
     binds: [B:92:0x0435, B:121:0x0614, B:134:0x0769] A[DONT_GENERATE, DONT_INLINE]
      0x0456: PHI (r11v25 'query' java.lang.String) = (r11v9 'query' java.lang.String), (r11v16 'query' java.lang.String), (r11v27 'query' java.lang.String) binds: [B:92:0x0435, B:121:0x0614, B:134:0x0769] A[DONT_GENERATE, DONT_INLINE]
      0x0456: PHI (r12v38 'queryParams' java.util.Map) = (r12v8 'queryParams' java.util.Map), (r12v15 'queryParams' java.util.Map), (r12v39 'queryParams' java.util.Map) binds: [B:92:0x0435, B:121:0x0614, B:134:0x0769] A[DONT_GENERATE, DONT_INLINE]
      0x0456: PHI (r13v50 'payload' com.AniVortex.EpisodeDataPayload) = 
      (r13v22 'payload' com.AniVortex.EpisodeDataPayload)
      (r13v33 'payload' com.AniVortex.EpisodeDataPayload)
      (r13v51 'payload' com.AniVortex.EpisodeDataPayload)
     binds: [B:92:0x0435, B:121:0x0614, B:134:0x0769] A[DONT_GENERATE, DONT_INLINE]
      0x0456: PHI (r14v25 kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit>) = 
      (r14v11 kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit>)
      (r14v18 kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit>)
      (r14v28 kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit>)
     binds: [B:92:0x0435, B:121:0x0614, B:134:0x0769] A[DONT_GENERATE, DONT_INLINE]
      0x0456: PHI (r20v12 kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit>) = 
      (r20v4 kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit>)
      (r20v9 kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit>)
      (r20v14 kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit>)
     binds: [B:92:0x0435, B:121:0x0614, B:134:0x0769] A[DONT_GENERATE, DONT_INLINE]
      0x0456: PHI (r21v10 'data' java.lang.String) = (r21v0 'data' java.lang.String), (r21v5 'data' java.lang.String), (r21v11 'data' java.lang.String) binds: [B:92:0x0435, B:121:0x0614, B:134:0x0769] A[DONT_GENERATE, DONT_INLINE]
      0x0456: PHI (r22v14 java.util.Iterator) = (r22v1 java.util.Iterator), (r22v5 java.util.Iterator), (r22v17 java.util.Iterator) binds: [B:92:0x0435, B:121:0x0614, B:134:0x0769] A[DONT_GENERATE, DONT_INLINE]
      0x0456: PHI (r23v12 com.AniVortex.AniVortexProvider) = 
      (r23v2 com.AniVortex.AniVortexProvider)
      (r23v4 com.AniVortex.AniVortexProvider)
      (r23v14 com.AniVortex.AniVortexProvider)
     binds: [B:92:0x0435, B:121:0x0614, B:134:0x0769] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:95:0x045c  */
    /* JADX WARN: Code duplicated, block: B:97:0x046c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:121:0x0614 -> B:93:0x0456). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:122:0x0616 -> B:123:0x063c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:127:0x0654 -> B:133:0x0750). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:131:0x070c -> B:132:0x0738). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:161:0x0884 -> B:162:0x0896). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object loadLinks(@org.jetbrains.annotations.NotNull java.lang.String r38, boolean r39, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r40, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r41, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r42) {
        /*
            Method dump skipped, instruction units count: 2292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.AniVortex.AniVortexProvider.loadLinks(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final SearchResponse toSearchResponse(CatalogItem $this$toSearchResponse) {
        Integer id = $this$toSearchResponse.getId();
        String lowerCase = null;
        if (id == null) {
            return null;
        }
        int titleId = id.intValue();
        String itemTitle = $this$toSearchResponse.getTitle();
        if (itemTitle == null) {
            return null;
        }
        String href = getMainUrl() + "/api/v1/titles/" + titleId;
        final String image = $this$toSearchResponse.getPosterUrl();
        if (image == null) {
            image = $this$toSearchResponse.getBackdropUrl();
        }
        final Integer itemYear = $this$toSearchResponse.getReleaseYear();
        final Score itemScore = formatScore($this$toSearchResponse.getRating());
        String contentType = $this$toSearchResponse.getContentType();
        if (contentType != null) {
            lowerCase = contentType.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        }
        if (lowerCase != null) {
            switch (lowerCase.hashCode()) {
                case -196215899:
                    if (lowerCase.equals("anime_movie")) {
                        return MainAPIKt.newAnimeSearchResponse$default(this, itemTitle, href, TvType.AnimeMovie, false, new Function1() { // from class: com.AniVortex.AniVortexProvider$$ExternalSyntheticLambda22
                            public final Object invoke(Object obj) {
                                return AniVortexProvider.toSearchResponse$lambda$1(image, itemYear, itemScore, (AnimeSearchResponse) obj);
                            }
                        }, 8, (Object) null);
                    }
                    break;
                case 92962932:
                    if (lowerCase.equals("anime")) {
                        return MainAPIKt.newAnimeSearchResponse$default(this, itemTitle, href, TvType.Anime, false, new Function1() { // from class: com.AniVortex.AniVortexProvider$$ExternalSyntheticLambda23
                            public final Object invoke(Object obj) {
                                return AniVortexProvider.toSearchResponse$lambda$2(image, itemYear, itemScore, (AnimeSearchResponse) obj);
                            }
                        }, 8, (Object) null);
                    }
                    break;
                case 104087344:
                    if (lowerCase.equals("movie")) {
                        return MainAPIKt.newMovieSearchResponse$default(this, itemTitle, href, TvType.Movie, false, new Function1() { // from class: com.AniVortex.AniVortexProvider$$ExternalSyntheticLambda21
                            public final Object invoke(Object obj) {
                                return AniVortexProvider.toSearchResponse$lambda$0(image, itemYear, itemScore, (MovieSearchResponse) obj);
                            }
                        }, 8, (Object) null);
                    }
                    break;
            }
        }
        return MainAPIKt.newTvSeriesSearchResponse$default(this, itemTitle, href, TvType.TvSeries, false, new Function1() { // from class: com.AniVortex.AniVortexProvider$$ExternalSyntheticLambda24
            public final Object invoke(Object obj) {
                return AniVortexProvider.toSearchResponse$lambda$3(image, itemYear, itemScore, (TvSeriesSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResponse$lambda$0(String $image, Integer $itemYear, Score $itemScore, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($image);
        $this$newMovieSearchResponse.setYear($itemYear);
        $this$newMovieSearchResponse.setScore($itemScore);
        return Unit.INSTANCE;
    }

    static final Unit toSearchResponse$lambda$1(String $image, Integer $itemYear, Score $itemScore, AnimeSearchResponse $this$newAnimeSearchResponse) {
        $this$newAnimeSearchResponse.setPosterUrl($image);
        $this$newAnimeSearchResponse.setYear($itemYear);
        $this$newAnimeSearchResponse.setScore($itemScore);
        return Unit.INSTANCE;
    }

    static final Unit toSearchResponse$lambda$2(String $image, Integer $itemYear, Score $itemScore, AnimeSearchResponse $this$newAnimeSearchResponse) {
        $this$newAnimeSearchResponse.setPosterUrl($image);
        $this$newAnimeSearchResponse.setYear($itemYear);
        $this$newAnimeSearchResponse.setScore($itemScore);
        return Unit.INSTANCE;
    }

    static final Unit toSearchResponse$lambda$3(String $image, Integer $itemYear, Score $itemScore, TvSeriesSearchResponse $this$newTvSeriesSearchResponse) {
        $this$newTvSeriesSearchResponse.setPosterUrl($image);
        $this$newTvSeriesSearchResponse.setYear($itemYear);
        $this$newTvSeriesSearchResponse.setScore($itemScore);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0020, code lost:
    
        if (r0.equals("2160p") == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002a, code lost:
    
        if (r0.equals("1080p") == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0034, code lost:
    
        if (r0.equals("720p") == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003e, code lost:
    
        if (r0.equals("480p") == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0068, code lost:
    
        if (r0.equals("fhd") == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0078, code lost:
    
        if (r0.equals("sd") == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0088, code lost:
    
        if (r0.equals("hd") == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0098, code lost:
    
        if (r0.equals("4k") == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:?, code lost:
    
        return com.lagradost.cloudstream3.utils.Qualities.P1080.getValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:?, code lost:
    
        return com.lagradost.cloudstream3.utils.Qualities.P480.getValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:?, code lost:
    
        return com.lagradost.cloudstream3.utils.Qualities.P720.getValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:?, code lost:
    
        return com.lagradost.cloudstream3.utils.Qualities.P2160.getValue();
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int getQualityInt(String quality) {
        String lowerCase;
        if (quality != null) {
            lowerCase = quality.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        } else {
            lowerCase = null;
        }
        if (lowerCase != null) {
            switch (lowerCase.hashCode()) {
                case 1719:
                    break;
                case 3324:
                    break;
                case 3665:
                    break;
                case 101346:
                    break;
                case 1541122:
                    if (lowerCase.equals("240p")) {
                        return Qualities.P240.getValue();
                    }
                    break;
                case 1572835:
                    if (lowerCase.equals("360p")) {
                        return Qualities.P360.getValue();
                    }
                    break;
                case 1604548:
                    break;
                case 1688155:
                    break;
                case 46737913:
                    break;
                case 47689303:
                    break;
            }
        }
        return Qualities.Unknown.getValue();
    }
}
