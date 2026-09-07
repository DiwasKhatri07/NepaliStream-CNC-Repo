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
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010 \u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0096@¢\u0006\u0002\u0010)J \u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010.J\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00020+0\u001e2\u0006\u00100\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u00101J\u0018\u00102\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0005H\u0002J:\u00103\u001a\b\u0012\u0004\u0012\u00020+0\u001e2\f\u00104\u001a\b\u0012\u0004\u0012\u00020+0\u001e2\f\u00105\u001a\b\u0012\u0004\u0012\u00020+0\u001e2\u000e\b\u0002\u00106\u001a\b\u0012\u0004\u0012\u00020+0\u001eH\u0002J\u0019\u00107\u001a\u0004\u0018\u0001082\b\u00109\u001a\u0004\u0018\u00010:H\u0002¢\u0006\u0002\u0010;J\u001e\u0010<\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010\u001e2\u0006\u0010>\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u00101J\u001e\u0010?\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010\u001e2\u0006\u0010>\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u00101J\u0018\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010B\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u00101JF\u0010C\u001a\u00020\u000e2\u0006\u0010D\u001a\u00020\u00052\u0006\u0010E\u001a\u00020\u000e2\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020I0G2\u0012\u0010J\u001a\u000e\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020I0GH\u0096@¢\u0006\u0002\u0010LJ\u000e\u0010M\u001a\u0004\u0018\u00010=*\u00020NH\u0002J\u0012\u0010O\u001a\u00020&2\b\u0010P\u001a\u0004\u0018\u00010\u0005H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0014\u0010\u0016\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001a\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050#X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Q"}, d2 = {"Lcom/AniVortex/AniVortexProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasQuickSearch", "getHasQuickSearch", "hasDownloadSupport", "getHasDownloadSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "ottCursorMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchOttSection", "Lcom/lagradost/cloudstream3/HomePageList;", "slug", "title", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchCatalogHome", "catalog", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cleanSectionTitle", "mergeAndSortHomeSections", "movieSections", "animeSections", "ottSections", "formatScore", "Lcom/lagradost/cloudstream3/Score;", "rating", "", "(Ljava/lang/Double;)Lcom/lagradost/cloudstream3/Score;", "quickSearch", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "search", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResponse", "Lcom/AniVortex/CatalogItem;", "getQualityInt", "quality", "AniVortex"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAniVortexProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AniVortexProvider.kt\ncom/AniVortex/AniVortexProvider\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 6 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,680:1\n73#2,5:681\n73#2,5:702\n73#2,5:726\n73#2,5:745\n73#2,5:764\n73#2,5:803\n73#2,5:822\n73#2,5:856\n73#2,5:862\n73#2,5:893\n296#3,2:686\n1795#3,10:688\n2068#3:698\n2069#3:700\n1805#3:701\n1795#3,10:707\n2068#3:717\n2069#3:719\n1805#3:720\n777#3:721\n873#3,2:722\n2068#3,2:724\n1795#3,10:731\n2068#3:741\n2069#3:743\n1805#3:744\n1795#3,10:750\n2068#3:760\n2069#3:762\n1805#3:763\n1795#3,10:769\n2068#3:779\n1795#3,10:780\n2068#3:790\n2069#3:792\n1805#3:793\n2069#3:795\n1805#3:796\n2068#3,2:797\n2068#3,2:799\n2068#3,2:801\n1795#3,10:808\n2068#3:818\n2069#3:820\n1805#3:821\n1795#3,10:828\n2068#3:838\n2069#3:840\n1805#3:841\n1795#3,10:842\n2068#3:852\n2069#3:854\n1805#3:855\n2068#3:861\n2068#3,2:867\n2069#3:869\n2068#3:898\n2068#3,2:899\n2068#3,2:901\n2069#3:903\n2068#3,2:904\n296#3,2:906\n1#4:699\n1#4:718\n1#4:742\n1#4:761\n1#4:791\n1#4:794\n1#4:819\n1#4:827\n1#4:839\n1#4:853\n1#4:873\n1#4:908\n93#5,2:870\n63#5:872\n64#5,15:874\n95#5,2:891\n50#6:889\n43#6:890\n*S KotlinDebug\n*F\n+ 1 AniVortexProvider.kt\ncom/AniVortex/AniVortexProvider\n*L\n119#1:681,5\n147#1:702,5\n178#1:726,5\n206#1:745,5\n230#1:764,5\n400#1:803,5\n415#1:822,5\n488#1:856,5\n501#1:862,5\n581#1:893,5\n121#1:686,2\n126#1:688,10\n126#1:698\n126#1:700\n126#1:701\n149#1:707,10\n149#1:717\n149#1:719\n149#1:720\n168#1:721\n168#1:722,2\n168#1:724,2\n179#1:731,10\n179#1:741\n179#1:743\n179#1:744\n207#1:750,10\n207#1:760\n207#1:762\n207#1:763\n236#1:769,10\n236#1:779\n237#1:780,10\n237#1:790\n237#1:792\n237#1:793\n236#1:795\n236#1:796\n353#1:797,2\n367#1:799,2\n375#1:801,2\n402#1:808,10\n402#1:818\n402#1:820\n402#1:821\n455#1:828,10\n455#1:838\n455#1:840\n455#1:841\n456#1:842,10\n456#1:852\n456#1:854\n456#1:855\n492#1:861\n503#1:867,2\n492#1:869\n585#1:898\n589#1:899,2\n605#1:901,2\n585#1:903\n622#1:904,2\n291#1:906,2\n126#1:699\n149#1:718\n179#1:742\n207#1:761\n237#1:791\n236#1:794\n402#1:819\n455#1:839\n456#1:853\n566#1:873\n566#1:870,2\n566#1:872\n566#1:874,15\n566#1:891,2\n566#1:889\n566#1:890\n*E\n"})
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

    /* JADX INFO: renamed from: com.AniVortex.AniVortexProvider$fetchCatalogHome$1 */
    /* JADX INFO: compiled from: AniVortexProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.AniVortex.AniVortexProvider", f = "AniVortexProvider.kt", i = {0, 0, 0, 0}, l = {230}, m = "fetchCatalogHome", n = {"catalog", "query", "headers", "url"}, nl = {681}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 2)
    static final class C00001 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C00001(Continuation<? super C00001> continuation) {
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
    @DebugMetadata(c = "com.AniVortex.AniVortexProvider", f = "AniVortexProvider.kt", i = {0, 0, 0, 0, 0}, l = {206}, m = "fetchOttSection", n = {"slug", "title", "query", "headers", "url"}, nl = {681}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C00011(Continuation<? super C00011> continuation) {
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
    @DebugMetadata(c = "com.AniVortex.AniVortexProvider", f = "AniVortexProvider.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5}, l = {61, 96, 119, 147, 178, 191}, m = "getMainPage", n = {"request", "data", "page", "request", "data", "catalog", "page", "request", "data", "parts", "catalog", "targetKey", "query", "headers", "url", "page", "request", "data", "catalog", "queryParams", "query", "headers", "url", "page", "request", "data", "slug", "queryParams", "query", "headers", "url", "page", "request", "data", "page"}, nl = {81, 97, 681, 702, 726, -1}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "L$0", "L$1", "I$0"}, v = 2)
    static final class C00021 extends ContinuationImpl {
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

        C00021(Continuation<? super C00021> continuation) {
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
    @DebugMetadata(c = "com.AniVortex.AniVortexProvider", f = "AniVortexProvider.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6}, l = {415, 438, 464, 488, 501, 528, 544}, m = "load", n = {"url", "queryDetail", "headersDetail", "detailUrl", "titleId", "url", "queryDetail", "headersDetail", "detailUrl", "detail", "tvType", "title", "poster", "backPoster", "plot", "tags", "year", "$this$load_u24lambda_u240", "titleId", "isMovie", "url", "queryDetail", "headersDetail", "detailUrl", "detail", "tvType", "title", "poster", "backPoster", "plot", "tags", "year", "tmdb", "finalPoster", "finalBackdrop", "finalPlot", "finalTags", "finalScore", "recommendationsList", "actorsList", "payload", "titleId", "isMovie", "url", "queryDetail", "headersDetail", "detailUrl", "detail", "tvType", "title", "poster", "backPoster", "plot", "tags", "year", "tmdb", "finalPoster", "finalBackdrop", "finalPlot", "finalTags", "finalScore", "recommendationsList", "actorsList", "queryWatch", "headersWatch", "watchUrl", "titleId", "isMovie", "url", "queryDetail", "headersDetail", "detailUrl", "detail", "tvType", "title", "poster", "backPoster", "plot", "tags", "year", "tmdb", "finalPoster", "finalBackdrop", "finalPlot", "finalTags", "finalScore", "recommendationsList", "actorsList", "queryWatch", "headersWatch", "watchUrl", "watchRes", "episodesList", "$this$forEach$iv", "element$iv", "season", "querySeason", "headersSeason", "seasonUrl", "titleId", "isMovie", "seasonId", "url", "queryDetail", "headersDetail", "detailUrl", "detail", "tvType", "title", "poster", "backPoster", "plot", "tags", "year", "tmdb", "finalPoster", "finalBackdrop", "finalPlot", "finalTags", "finalScore", "recommendationsList", "actorsList", "queryWatch", "headersWatch", "watchUrl", "watchRes", "episodesList", "fallbackPayload", "titleId", "isMovie", "url", "queryDetail", "headersDetail", "detailUrl", "detail", "tvType", "title", "poster", "backPoster", "plot", "tags", "year", "tmdb", "finalPoster", "finalBackdrop", "finalPlot", "finalTags", "finalScore", "recommendationsList", "actorsList", "queryWatch", "headersWatch", "watchUrl", "watchRes", "episodesList", "titleId", "isMovie"}, nl = {681, 445, 481, 715, 721, 544, -1}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$27", "L$28", "L$29", "L$30", "L$31", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "I$0", "I$1"}, v = 2)
    static final class C00041 extends ContinuationImpl {
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

        C00041(Continuation<? super C00041> continuation) {
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
    @DebugMetadata(c = "com.AniVortex.AniVortexProvider", f = "AniVortexProvider.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {581, 592, 608, 625}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "payload", "queryParams", "query", "headers", "url", "isCasting", "titleId", "data", "subtitleCallback", "callback", "payload", "queryParams", "query", "headers", "url", "playback", "serverName", "$this$forEach$iv", "element$iv", "lang", "langName", "$this$forEach$iv", "element$iv", "stream", "streamUrl", "isCasting", "titleId", "data", "subtitleCallback", "callback", "payload", "queryParams", "query", "headers", "url", "playback", "serverName", "$this$forEach$iv", "element$iv", "lang", "$this$forEach$iv", "langName", "element$iv", "download", "downloadUrl", "isCasting", "titleId", "data", "subtitleCallback", "callback", "payload", "queryParams", "query", "headers", "url", "playback", "serverName", "$this$forEach$iv", "element$iv", "sub", "isCasting", "titleId"}, nl = {704, 591, 607, 624}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$12", "L$13", "L$14", "L$15", "L$17", "L$18", "L$19", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$12", "L$13", "L$14", "L$15", "L$17", "L$18", "L$19", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$12", "L$13", "Z$0", "I$0"}, v = 2)
    static final class C00081 extends ContinuationImpl {
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

        C00081(Continuation<? super C00081> continuation) {
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
    @DebugMetadata(c = "com.AniVortex.AniVortexProvider", f = "AniVortexProvider.kt", i = {0, 0, 0, 0}, l = {400}, m = "search", n = {"query", "queryString", "headers", "url"}, nl = {681}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 2)
    static final class C00091 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C00091(Continuation<? super C00091> continuation) {
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

    /* JADX WARN: Code duplicated, block: B:105:0x0363  */
    /* JADX WARN: Code duplicated, block: B:131:0x04c0  */
    /* JADX WARN: Code duplicated, block: B:137:0x04d5  */
    /* JADX WARN: Code duplicated, block: B:139:0x04dd  */
    /* JADX WARN: Code duplicated, block: B:140:0x04df  */
    /* JADX WARN: Code duplicated, block: B:190:0x06fd  */
    /* JADX WARN: Code duplicated, block: B:195:0x0710  */
    /* JADX WARN: Code duplicated, block: B:202:0x0722  */
    /* JADX WARN: Code duplicated, block: B:204:0x0725  */
    /* JADX WARN: Code duplicated, block: B:211:0x0758  */
    /* JADX WARN: Code duplicated, block: B:213:0x0760  */
    /* JADX WARN: Code duplicated, block: B:214:0x0762  */
    /* JADX WARN: Code duplicated, block: B:217:0x0769  */
    /* JADX WARN: Code duplicated, block: B:218:0x076c  */
    /* JADX WARN: Code duplicated, block: B:270:0x0301 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    /* JADX WARN: Code duplicated, block: B:82:0x02f3 A[LOOP:2: B:67:0x02ad->B:82:0x02f3, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:87:0x0307  */
    /* JADX WARN: Code duplicated, block: B:89:0x030b  */
    /* JADX WARN: Code duplicated, block: B:92:0x0318  */
    /* JADX WARN: Code duplicated, block: B:95:0x031c  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        C00021 c00021;
        boolean z;
        String catalog;
        Map queryParams;
        Object obj;
        String data;
        MainPageRequest request2;
        int page2;
        Object obj2;
        MainPageRequest request3;
        boolean z2;
        Object obj3;
        String targetKey;
        MainPageRequest request4;
        int page3;
        Object safe;
        CatalogHomeResponse response;
        CatalogHomeResponse response2;
        CatalogSection matchedSection;
        List items;
        Iterable items2;
        List<CatalogSection> sections;
        Iterable sections2;
        Object element$iv;
        int $i$f$firstOrNull;
        boolean z3;
        Object safe2;
        CatalogExploreResponse response3;
        List items3;
        boolean zBooleanValue;
        Boolean hasMore;
        Iterable items4;
        Object safe3;
        OttTitlesResponse response4;
        List items5;
        String nextCursor;
        String nextCursor2;
        String str;
        boolean z4;
        boolean hasMore2;
        boolean z5;
        OttPageInfo page4;
        Boolean hasMore3;
        OttPageInfo page5;
        Iterable items6;
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
        Object element$iv$iv = c00021.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00021.label) {
            case 0:
                ResultKt.throwOnFailure(element$iv$iv);
                DonationManager.INSTANCE.checkAndShow(getName());
                String data2 = request.getData();
                if (Intrinsics.areEqual(data2, "home:all") || Intrinsics.areEqual(data2, "home")) {
                    z = false;
                } else {
                    if (!(data2.length() == 0)) {
                        String strRemovePrefix = "anime";
                        if (StringsKt.startsWith$default(data2, "home:", false, 2, (Object) null) || Intrinsics.areEqual(data2, "movie_series") || Intrinsics.areEqual(data2, "anime")) {
                            if (page > 1) {
                                return MainAPIKt.newHomePageResponse(CollectionsKt.emptyList(), Boxing.boxBoolean(false));
                            }
                            if (StringsKt.startsWith$default(data2, "home:", false, 2, (Object) null)) {
                                strRemovePrefix = StringsKt.removePrefix(data2, "home:");
                            } else if (!Intrinsics.areEqual(data2, "anime")) {
                                strRemovePrefix = "movie_series";
                            }
                            catalog = strRemovePrefix;
                            c00021.L$0 = SpillingKt.nullOutSpilledVariable(request);
                            c00021.L$1 = SpillingKt.nullOutSpilledVariable(data2);
                            c00021.L$2 = catalog;
                            c00021.I$0 = page;
                            c00021.label = 2;
                            element$iv$iv = fetchCatalogHome(catalog, c00021);
                            if (element$iv$iv == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            List homeLists = (List) element$iv$iv;
                            Log.d("AniVortex", "Loaded " + homeLists.size() + " home sections for " + catalog);
                            return MainAPIKt.newHomePageResponse(homeLists, Boxing.boxBoolean(false));
                        }
                        if (StringsKt.startsWith$default(data2, "section:", false, 2, (Object) null)) {
                            if (page > 1) {
                                return MainAPIKt.newHomePageResponse(CollectionsKt.emptyList(), Boxing.boxBoolean(false));
                            }
                            List parts = StringsKt.split$default(data2, new String[]{":"}, false, 0, 6, (Object) null);
                            String str2 = (String) CollectionsKt.getOrNull(parts, 1);
                            String catalog2 = str2 != null ? str2 : "movie_series";
                            String targetKey2 = (String) CollectionsKt.getOrNull(parts, 2);
                            if (targetKey2 == null) {
                                targetKey2 = "";
                            }
                            Pair pairBuildHeaders$default = AniVortexAuth.buildHeaders$default(AniVortexAuth.INSTANCE, "GET", "/api/v1/catalog/home", MapsKt.mapOf(new Pair[]{TuplesKt.to("catalog", catalog2), TuplesKt.to("include_adult", "false")}), null, 8, null);
                            String query = (String) pairBuildHeaders$default.component1();
                            Map headers = (Map) pairBuildHeaders$default.component2();
                            String url = getMainUrl() + "/api/v1/catalog/home?" + query;
                            Requests app = MainActivityKt.getApp();
                            c00021.L$0 = request;
                            c00021.L$1 = SpillingKt.nullOutSpilledVariable(data2);
                            c00021.L$2 = SpillingKt.nullOutSpilledVariable(parts);
                            c00021.L$3 = SpillingKt.nullOutSpilledVariable(catalog2);
                            c00021.L$4 = targetKey2;
                            c00021.L$5 = SpillingKt.nullOutSpilledVariable(query);
                            c00021.L$6 = SpillingKt.nullOutSpilledVariable(headers);
                            c00021.L$7 = SpillingKt.nullOutSpilledVariable(url);
                            c00021.I$0 = page;
                            c00021.label = 3;
                            String targetKey3 = targetKey2;
                            z2 = false;
                            obj3 = Requests.get$default(app, url, headers, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00021, 4092, (Object) null);
                            if (obj3 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            targetKey = targetKey3;
                            request4 = request;
                            page3 = page;
                            NiceResponse this_$iv = (NiceResponse) obj3;
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
                                matchedSection = (CatalogSection) element$iv;
                                if (matchedSection == null) {
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
                        C00021 c00022 = c00021;
                        if (StringsKt.startsWith$default(data2, "explore:", false, 2, (Object) null)) {
                            String catalog3 = StringsKt.removePrefix(data2, "explore:");
                            Map queryParams2 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("catalog", catalog3), TuplesKt.to("include_adult", "false"), TuplesKt.to("page", String.valueOf(page)), TuplesKt.to("limit", "24")});
                            Pair pairBuildHeaders$default2 = AniVortexAuth.buildHeaders$default(AniVortexAuth.INSTANCE, "GET", "/api/v1/catalog/explore", queryParams2, null, 8, null);
                            String query2 = (String) pairBuildHeaders$default2.component1();
                            Map headers2 = (Map) pairBuildHeaders$default2.component2();
                            String url2 = getMainUrl() + "/api/v1/catalog/explore?" + query2;
                            Requests app2 = MainActivityKt.getApp();
                            c00022.L$0 = request;
                            c00022.L$1 = SpillingKt.nullOutSpilledVariable(data2);
                            c00022.L$2 = SpillingKt.nullOutSpilledVariable(catalog3);
                            c00022.L$3 = SpillingKt.nullOutSpilledVariable(queryParams2);
                            c00022.L$4 = SpillingKt.nullOutSpilledVariable(query2);
                            c00022.L$5 = SpillingKt.nullOutSpilledVariable(headers2);
                            c00022.L$6 = SpillingKt.nullOutSpilledVariable(url2);
                            c00022.I$0 = page;
                            c00022.label = 4;
                            obj2 = Requests.get$default(app2, url2, headers2, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                            if (obj2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            request3 = request;
                            NiceResponse this_$iv2 = (NiceResponse) obj2;
                            try {
                                ResponseParser parser2 = this_$iv2.getParser();
                                Intrinsics.checkNotNull(parser2);
                                safe2 = parser2.parseSafe(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(CatalogExploreResponse.class));
                            } catch (Exception e$iv) {
                                e$iv.printStackTrace();
                                safe2 = null;
                            }
                            response3 = (CatalogExploreResponse) safe2;
                            if (response3 != null || (items4 = response3.getItems()) == null) {
                                items3 = CollectionsKt.emptyList();
                            } else {
                                Iterable $this$mapNotNull$iv2 = items4;
                                Collection destination$iv$iv2 = new ArrayList();
                                for (Object element$iv$iv$iv2 : $this$mapNotNull$iv2) {
                                    CatalogItem it4 = (CatalogItem) element$iv$iv$iv2;
                                    SearchResponse searchResponse2 = toSearchResponse(it4);
                                    if (searchResponse2 != null) {
                                        destination$iv$iv2.add(searchResponse2);
                                    }
                                }
                                items3 = (List) destination$iv$iv2;
                            }
                            String name = request3.getName();
                            if (response3 == null && (hasMore = response3.getHasMore()) != null) {
                                zBooleanValue = hasMore.booleanValue();
                            } else if (items3.size() >= 24) {
                                zBooleanValue = true;
                            } else {
                                zBooleanValue = false;
                            }
                            return MainAPIKt.newHomePageResponse(name, items3, Boxing.boxBoolean(zBooleanValue));
                        }
                        if (!StringsKt.startsWith$default(data2, "ott:", false, 2, (Object) null)) {
                            MainPageRequest mainPageRequestCopy$default = MainPageRequest.copy$default(request, (String) null, "home:all", false, 5, (Object) null);
                            c00022.L$0 = SpillingKt.nullOutSpilledVariable(request);
                            c00022.L$1 = SpillingKt.nullOutSpilledVariable(data2);
                            c00022.I$0 = page;
                            c00022.label = 6;
                            element$iv$iv = getMainPage(page, mainPageRequestCopy$default, c00022);
                            return element$iv$iv == coroutine_suspended ? coroutine_suspended : element$iv$iv;
                        }
                        String slug = StringsKt.removePrefix(data2, "ott:");
                        Map queryParams3 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("sort", "popular"), TuplesKt.to("include_adult", "false"), TuplesKt.to("limit", "24")});
                        ConcurrentHashMap<String, String> concurrentHashMap = this.ottCursorMap;
                        if (page > 1) {
                            String cursor = concurrentHashMap.get(data2 + ':' + page);
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
                            for (Object element$iv$iv2 : $this$filterTo$iv$iv) {
                                Object $result = element$iv$iv;
                                Map queryParams4 = queryParams3;
                                String it5 = (String) element$iv$iv2;
                                Iterable $this$filter$iv2 = $this$filter$iv;
                                int $i$f$filter2 = $i$f$filter;
                                Iterable $this$filterTo$iv$iv2 = $this$filterTo$iv$iv;
                                if (StringsKt.startsWith$default(it5, data2 + ':', false, 2, (Object) null)) {
                                    destination$iv$iv3.add(element$iv$iv2);
                                }
                                $this$filter$iv = $this$filter$iv2;
                                $i$f$filter = $i$f$filter2;
                                $this$filterTo$iv$iv = $this$filterTo$iv$iv2;
                                queryParams3 = queryParams4;
                                element$iv$iv = $result;
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
                        Map headers3 = (Map) pairBuildHeaders$default3.component2();
                        String url3 = getMainUrl() + "/api/v1/catalog/ott-platforms/" + slug + "/titles?" + query3;
                        Requests app3 = MainActivityKt.getApp();
                        c00022.L$0 = request;
                        c00022.L$1 = data2;
                        c00022.L$2 = SpillingKt.nullOutSpilledVariable(slug);
                        c00022.L$3 = SpillingKt.nullOutSpilledVariable(queryParams);
                        c00022.L$4 = SpillingKt.nullOutSpilledVariable(query3);
                        c00022.L$5 = SpillingKt.nullOutSpilledVariable(headers3);
                        c00022.L$6 = SpillingKt.nullOutSpilledVariable(url3);
                        c00022.I$0 = page;
                        c00022.label = 5;
                        obj = Requests.get$default(app3, url3, headers3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4092, (Object) null);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        data = data2;
                        request2 = request;
                        page2 = page;
                        NiceResponse this_$iv3 = (NiceResponse) obj;
                        try {
                            ResponseParser parser3 = this_$iv3.getParser();
                            Intrinsics.checkNotNull(parser3);
                            safe3 = parser3.parseSafe(this_$iv3.getText(), Reflection.getOrCreateKotlinClass(OttTitlesResponse.class));
                            break;
                        } catch (Exception e$iv2) {
                            e$iv2.printStackTrace();
                            safe3 = null;
                        }
                        response4 = (OttTitlesResponse) safe3;
                        if (response4 != null || (items6 = response4.getItems()) == null) {
                            items5 = CollectionsKt.emptyList();
                        } else {
                            Iterable $this$mapNotNull$iv3 = items6;
                            Collection destination$iv$iv4 = new ArrayList();
                            for (Object element$iv$iv$iv3 : $this$mapNotNull$iv3) {
                                CatalogItem it7 = (CatalogItem) element$iv$iv$iv3;
                                SearchResponse searchResponse3 = toSearchResponse(it7);
                                if (searchResponse3 != null) {
                                    destination$iv$iv4.add(searchResponse3);
                                }
                            }
                            items5 = (List) destination$iv$iv4;
                        }
                        if (response4 != null || (page5 = response4.getPage()) == null) {
                            nextCursor = null;
                        } else {
                            nextCursor = page5.getNextCursor();
                        }
                        nextCursor2 = nextCursor;
                        str = nextCursor2;
                        if (str != null || str.length() == 0) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (!z4) {
                            this.ottCursorMap.put(data + ':' + (page2 + 1), nextCursor2);
                        }
                        if (response4 == null && (page4 = response4.getPage()) != null && (hasMore3 = page4.getHasMore()) != null) {
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
                if (page > 1) {
                    return MainAPIKt.newHomePageResponse(CollectionsKt.emptyList(), Boxing.boxBoolean(z));
                }
                C00032 c00032 = new C00032(null);
                c00021.L$0 = SpillingKt.nullOutSpilledVariable(request);
                c00021.L$1 = SpillingKt.nullOutSpilledVariable(data2);
                c00021.I$0 = page;
                c00021.label = 1;
                element$iv$iv = CoroutineScopeKt.coroutineScope(c00032, c00021);
                if (element$iv$iv == coroutine_suspended) {
                    return coroutine_suspended;
                }
                Triple triple = (Triple) element$iv$iv;
                List<HomePageList> listMergeAndSortHomeSections = mergeAndSortHomeSections((List) triple.component1(), (List) triple.component2(), (List) triple.component3());
                Log.d("AniVortex", "Loaded " + listMergeAndSortHomeSections.size() + " combined home sections (including OTT platforms)");
                return MainAPIKt.newHomePageResponse(listMergeAndSortHomeSections, Boxing.boxBoolean(false));
            case 1:
                int page6 = c00021.I$0;
                ResultKt.throwOnFailure(element$iv$iv);
                Triple triple2 = (Triple) element$iv$iv;
                List<HomePageList> listMergeAndSortHomeSections2 = mergeAndSortHomeSections((List) triple2.component1(), (List) triple2.component2(), (List) triple2.component3());
                Log.d("AniVortex", "Loaded " + listMergeAndSortHomeSections2.size() + " combined home sections (including OTT platforms)");
                return MainAPIKt.newHomePageResponse(listMergeAndSortHomeSections2, Boxing.boxBoolean(false));
            case 2:
                int page7 = c00021.I$0;
                catalog = (String) c00021.L$2;
                ResultKt.throwOnFailure(element$iv$iv);
                List homeLists2 = (List) element$iv$iv;
                Log.d("AniVortex", "Loaded " + homeLists2.size() + " home sections for " + catalog);
                return MainAPIKt.newHomePageResponse(homeLists2, Boxing.boxBoolean(false));
            case 3:
                int page8 = c00021.I$0;
                String targetKey4 = (String) c00021.L$4;
                MainPageRequest request5 = (MainPageRequest) c00021.L$0;
                ResultKt.throwOnFailure(element$iv$iv);
                z2 = false;
                targetKey = targetKey4;
                obj3 = element$iv$iv;
                request4 = request5;
                page3 = page8;
                NiceResponse this_$iv4 = (NiceResponse) obj3;
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
            case 4:
                int page9 = c00021.I$0;
                MainPageRequest request6 = (MainPageRequest) c00021.L$0;
                ResultKt.throwOnFailure(element$iv$iv);
                obj2 = element$iv$iv;
                request3 = request6;
                NiceResponse this_$iv5 = (NiceResponse) obj2;
                ResponseParser parser5 = this_$iv5.getParser();
                Intrinsics.checkNotNull(parser5);
                safe2 = parser5.parseSafe(this_$iv5.getText(), Reflection.getOrCreateKotlinClass(CatalogExploreResponse.class));
                response3 = (CatalogExploreResponse) safe2;
                if (response3 != null) {
                    items3 = CollectionsKt.emptyList();
                } else {
                    items3 = CollectionsKt.emptyList();
                }
                String name3 = request3.getName();
                if (response3 == null) {
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
            case 5:
                int page10 = c00021.I$0;
                data = (String) c00021.L$1;
                MainPageRequest request7 = (MainPageRequest) c00021.L$0;
                ResultKt.throwOnFailure(element$iv$iv);
                obj = element$iv$iv;
                request2 = request7;
                page2 = page10;
                NiceResponse this_$iv6 = (NiceResponse) obj;
                ResponseParser parser6 = this_$iv6.getParser();
                Intrinsics.checkNotNull(parser6);
                safe3 = parser6.parseSafe(this_$iv6.getText(), Reflection.getOrCreateKotlinClass(OttTitlesResponse.class));
                response4 = (OttTitlesResponse) safe3;
                if (response4 != null) {
                    items5 = CollectionsKt.emptyList();
                } else {
                    items5 = CollectionsKt.emptyList();
                }
                if (response4 != null) {
                    nextCursor = null;
                } else {
                    nextCursor = null;
                }
                nextCursor2 = nextCursor;
                str = nextCursor2;
                if (str != null) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (!z4) {
                    this.ottCursorMap.put(data + ':' + (page2 + 1), nextCursor2);
                }
                if (response4 == null) {
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
            case 6:
                int i = c00021.I$0;
                ResultKt.throwOnFailure(element$iv$iv);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.AniVortex.AniVortexProvider$getMainPage$2 */
    /* JADX INFO: compiled from: AniVortexProvider.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Triple;", "", "Lcom/lagradost/cloudstream3/HomePageList;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.AniVortex.AniVortexProvider$getMainPage$2", f = "AniVortexProvider.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {78, 78, 78}, m = "invokeSuspend", n = {"$this$coroutineScope", "movieDef", "animeDef", "ottDef", "$this$coroutineScope", "movieDef", "animeDef", "ottDef", "$this$coroutineScope", "movieDef", "animeDef", "ottDef"}, nl = {78, 78, -1}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"}, v = 2)
    static final class C00032 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Triple<? extends List<? extends HomePageList>, ? extends List<? extends HomePageList>, ? extends List<? extends HomePageList>>>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        C00032(Continuation<? super C00032> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00032 = AniVortexProvider.this.new C00032(continuation);
            c00032.L$0 = obj;
            return c00032;
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
    /* JADX WARN: Code duplicated, block: B:44:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:51:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:53:0x01bb A[Catch: all -> 0x01c6, TRY_LEAVE, TryCatch #1 {all -> 0x01c6, blocks: (B:26:0x013c, B:28:0x0140, B:32:0x015d, B:34:0x0161, B:36:0x0167, B:37:0x0179, B:39:0x017f, B:41:0x0197, B:43:0x01a0, B:45:0x01a9, B:47:0x01af, B:53:0x01bb, B:31:0x0157), top: B:69:0x013c, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    /* JADX WARN: Code duplicated, block: B:83:? A[RETURN, SYNTHETIC] */
    public final Object fetchOttSection(String slug, String title, Continuation<? super HomePageList> continuation) {
        C00011 c00011;
        String title2;
        Object safe;
        OttTitlesResponse response;
        List items;
        List list;
        boolean z;
        Iterable items2;
        String slug2 = slug;
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
                try {
                    Pair pairBuildHeaders$default = AniVortexAuth.buildHeaders$default(AniVortexAuth.INSTANCE, "GET", "/api/v1/catalog/ott-platforms/" + slug2 + "/titles", MapsKt.mapOf(new Pair[]{TuplesKt.to("sort", "popular"), TuplesKt.to("include_adult", "false"), TuplesKt.to("limit", "20")}), null, 8, null);
                    String query = (String) pairBuildHeaders$default.component1();
                    Map headers = (Map) pairBuildHeaders$default.component2();
                    String url = getMainUrl() + "/api/v1/catalog/ott-platforms/" + slug2 + "/titles?" + query;
                    try {
                        Requests app = MainActivityKt.getApp();
                        c00011.L$0 = slug2;
                        c00011.L$1 = title;
                        c00011.L$2 = SpillingKt.nullOutSpilledVariable(query);
                        c00011.L$3 = SpillingKt.nullOutSpilledVariable(headers);
                        c00011.L$4 = SpillingKt.nullOutSpilledVariable(url);
                        c00011.label = 1;
                        try {
                            $result = Requests.get$default(app, url, headers, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00011, 4092, (Object) null);
                            if ($result == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            title2 = title;
                            try {
                                NiceResponse this_$iv = (NiceResponse) $result;
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
                } catch (Throwable th4) {
                    e = th4;
                }
                break;
            case 1:
                title2 = (String) c00011.L$1;
                slug2 = (String) c00011.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    NiceResponse this_$iv2 = (NiceResponse) $result;
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
                } catch (Throwable th5) {
                    e = th5;
                    Log.e("AniVortex", "Failed to fetch OTT section " + slug2 + ": " + e.getMessage());
                    return null;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    public final Object fetchCatalogHome(String catalog, Continuation<? super List<HomePageList>> continuation) {
        C00001 c00001;
        String catalog2;
        Object safe;
        CatalogHomeResponse response;
        List items;
        HomePageList homePageList;
        AniVortexProvider aniVortexProvider = this;
        if (continuation instanceof C00001) {
            c00001 = (C00001) continuation;
            if ((c00001.label & Integer.MIN_VALUE) != 0) {
                c00001.label -= Integer.MIN_VALUE;
            } else {
                c00001 = aniVortexProvider.new C00001(continuation);
            }
        } else {
            c00001 = aniVortexProvider.new C00001(continuation);
        }
        Object $result = c00001.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00001.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Pair pairBuildHeaders$default = AniVortexAuth.buildHeaders$default(AniVortexAuth.INSTANCE, "GET", "/api/v1/catalog/home", MapsKt.mapOf(new Pair[]{TuplesKt.to("catalog", catalog), TuplesKt.to("include_adult", "false")}), null, 8, null);
                String query = (String) pairBuildHeaders$default.component1();
                Map headers = (Map) pairBuildHeaders$default.component2();
                String url = aniVortexProvider.getMainUrl() + "/api/v1/catalog/home?" + query;
                Requests app = MainActivityKt.getApp();
                c00001.L$0 = catalog;
                c00001.L$1 = SpillingKt.nullOutSpilledVariable(query);
                c00001.L$2 = SpillingKt.nullOutSpilledVariable(headers);
                c00001.L$3 = SpillingKt.nullOutSpilledVariable(url);
                c00001.label = 1;
                $result = Requests.get$default(app, url, headers, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00001, 4092, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                catalog2 = catalog;
                break;
                break;
            case 1:
                String catalog3 = (String) c00001.L$0;
                ResultKt.throwOnFailure($result);
                catalog2 = catalog3;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NiceResponse this_$iv = (NiceResponse) $result;
        try {
            ResponseParser parser = this_$iv.getParser();
            Intrinsics.checkNotNull(parser);
            safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(CatalogHomeResponse.class));
        } catch (Exception e$iv) {
            e$iv.printStackTrace();
            safe = null;
        }
        CatalogHomeResponse response2 = (CatalogHomeResponse) safe;
        if ((response2 != null ? response2.getSections() : null) == null) {
            Log.e("AniVortex", "Failed to parse catalog home response for " + catalog2);
            return CollectionsKt.emptyList();
        }
        Iterable $this$mapNotNull$iv = response2.getSections();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            CatalogSection section = (CatalogSection) element$iv$iv$iv;
            Iterable items2 = section.getItems();
            if (items2 != null) {
                Iterable $this$mapNotNull$iv2 = items2;
                Collection destination$iv$iv2 = new ArrayList();
                for (Object element$iv$iv$iv2 : $this$mapNotNull$iv2) {
                    CatalogHomeResponse response3 = response2;
                    CatalogItem it = (CatalogItem) element$iv$iv$iv2;
                    SearchResponse searchResponse = aniVortexProvider.toSearchResponse(it);
                    if (searchResponse != null) {
                        destination$iv$iv2.add(searchResponse);
                    }
                    response2 = response3;
                }
                response = response2;
                items = (List) destination$iv$iv2;
            } else {
                response = response2;
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
                String cleanTitle = aniVortexProvider.cleanSectionTitle(title, catalog2);
                homePageList = new HomePageList(cleanTitle, items, Intrinsics.areEqual(section.getPresentation(), "hero"));
            }
            if (homePageList != null) {
                destination$iv$iv.add(homePageList);
            }
            aniVortexProvider = this;
            catalog2 = catalog2;
            response2 = response;
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

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        C00091 c00091;
        Object obj;
        Object safe;
        Iterable items;
        if (continuation instanceof C00091) {
            c00091 = (C00091) continuation;
            if ((c00091.label & Integer.MIN_VALUE) != 0) {
                c00091.label -= Integer.MIN_VALUE;
            } else {
                c00091 = new C00091(continuation);
            }
        } else {
            c00091 = new C00091(continuation);
        }
        C00091 c00092 = c00091;
        Object $result = c00092.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00092.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Pair pairBuildHeaders$default = AniVortexAuth.buildHeaders$default(AniVortexAuth.INSTANCE, "GET", "/api/v1/search", MapsKt.mapOf(TuplesKt.to("q", query)), null, 8, null);
                String queryString = (String) pairBuildHeaders$default.component1();
                Map headers = (Map) pairBuildHeaders$default.component2();
                String url = getMainUrl() + "/api/v1/search?" + queryString;
                Requests app = MainActivityKt.getApp();
                c00092.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00092.L$1 = SpillingKt.nullOutSpilledVariable(queryString);
                c00092.L$2 = SpillingKt.nullOutSpilledVariable(headers);
                c00092.L$3 = SpillingKt.nullOutSpilledVariable(url);
                c00092.label = 1;
                obj = Requests.get$default(app, url, headers, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00092, 4092, (Object) null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                obj = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NiceResponse this_$iv = (NiceResponse) obj;
        try {
            ResponseParser parser = this_$iv.getParser();
            Intrinsics.checkNotNull(parser);
            safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(AniVortexSearchResponse.class));
        } catch (Exception e$iv) {
            e$iv.printStackTrace();
            safe = null;
        }
        AniVortexSearchResponse response = (AniVortexSearchResponse) safe;
        if (response != null && (items = response.getItems()) != null) {
            Iterable $this$mapNotNull$iv = items;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                AniVortexSearchResponse response2 = response;
                CatalogItem it = (CatalogItem) element$iv$iv$iv;
                SearchResponse searchResponse = toSearchResponse(it);
                if (searchResponse != null) {
                    destination$iv$iv.add(searchResponse);
                }
                response = response2;
            }
            return (List) destination$iv$iv;
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:126:0x0746 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:127:0x0748  */
    /* JADX WARN: Code duplicated, block: B:129:0x074f  */
    /* JADX WARN: Code duplicated, block: B:136:0x0766 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:137:0x0768  */
    /* JADX WARN: Code duplicated, block: B:139:0x076f  */
    /* JADX WARN: Code duplicated, block: B:187:0x08ad A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:188:0x08af  */
    /* JADX WARN: Code duplicated, block: B:189:0x08b6  */
    /* JADX WARN: Code duplicated, block: B:222:0x0b76  */
    /* JADX WARN: Code duplicated, block: B:224:0x0b88  */
    /* JADX WARN: Code duplicated, block: B:226:0x0cc2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:227:0x0cc3  */
    /* JADX WARN: Code duplicated, block: B:245:0x0d17  */
    /* JADX WARN: Code duplicated, block: B:256:0x0d9c  */
    /* JADX WARN: Code duplicated, block: B:258:0x0dc0  */
    /* JADX WARN: Code duplicated, block: B:68:0x05fe  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:227:0x0cc3 -> B:228:0x0ce3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:258:0x0dc0 -> B:259:0x0de1). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object load(@org.jetbrains.annotations.NotNull java.lang.String r79, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r80) {
        /*
            Method dump skipped, instruction units count: 4190
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.AniVortex.AniVortexProvider.load(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.AniVortex.AniVortexProvider$load$2 */
    /* JADX INFO: compiled from: AniVortexProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.AniVortex.AniVortexProvider$load$2", f = "AniVortexProvider.kt", i = {0, 0}, l = {474}, m = "invokeSuspend", n = {"$this$newMovieLoadResponse", "it"}, nl = {474}, s = {"L$0", "L$1"}, v = 2)
    @SourceDebugExtension({"SMAP\nAniVortexProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AniVortexProvider.kt\ncom/AniVortex/AniVortexProvider$load$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,680:1\n1#2:681\n*E\n"})
    static final class C00052 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
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
        C00052(String str, String str2, TmdbMetadata tmdbMetadata, String str3, List<String> list, Integer num, Score score, List<? extends SearchResponse> list2, List<ActorData> list3, Continuation<? super C00052> continuation) {
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
            Continuation<Unit> c00052 = new C00052(this.$finalPoster, this.$finalBackdrop, this.$tmdb, this.$finalPlot, this.$finalTags, this.$year, this.$finalScore, this.$recommendationsList, this.$actorsList, continuation);
            c00052.L$0 = obj;
            return c00052;
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
    @DebugMetadata(c = "com.AniVortex.AniVortexProvider$load$4", f = "AniVortexProvider.kt", i = {0, 0}, l = {538}, m = "invokeSuspend", n = {"$this$newMovieLoadResponse", "it"}, nl = {538}, s = {"L$0", "L$1"}, v = 2)
    @SourceDebugExtension({"SMAP\nAniVortexProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AniVortexProvider.kt\ncom/AniVortex/AniVortexProvider$load$4\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,680:1\n1#2:681\n*E\n"})
    static final class C00064 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
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
        C00064(String str, String str2, TmdbMetadata tmdbMetadata, String str3, List<String> list, Integer num, Score score, List<? extends SearchResponse> list2, List<ActorData> list3, Continuation<? super C00064> continuation) {
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
            Continuation<Unit> c00064 = new C00064(this.$finalPoster, this.$finalBackdrop, this.$tmdb, this.$finalPlot, this.$finalTags, this.$year, this.$finalScore, this.$recommendationsList, this.$actorsList, continuation);
            c00064.L$0 = obj;
            return c00064;
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
    @DebugMetadata(c = "com.AniVortex.AniVortexProvider$load$5", f = "AniVortexProvider.kt", i = {0, 0}, l = {554}, m = "invokeSuspend", n = {"$this$newTvSeriesLoadResponse", "it"}, nl = {554}, s = {"L$0", "L$1"}, v = 2)
    @SourceDebugExtension({"SMAP\nAniVortexProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AniVortexProvider.kt\ncom/AniVortex/AniVortexProvider$load$5\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,680:1\n1#2:681\n*E\n"})
    static final class C00075 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
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
        C00075(String str, String str2, TmdbMetadata tmdbMetadata, String str3, List<String> list, Integer num, Score score, List<? extends SearchResponse> list2, List<ActorData> list3, Continuation<? super C00075> continuation) {
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
            Continuation<Unit> c00075 = new C00075(this.$finalPoster, this.$finalBackdrop, this.$tmdb, this.$finalPlot, this.$finalTags, this.$year, this.$finalScore, this.$recommendationsList, this.$actorsList, continuation);
            c00075.L$0 = obj;
            return c00075;
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

    /* JADX WARN: Code duplicated, block: B:100:0x0485  */
    /* JADX WARN: Code duplicated, block: B:120:0x0606  */
    /* JADX WARN: Code duplicated, block: B:133:0x075d A[PHI: r0 r1 r3 r4 r5 r6 r7 r8 r9 r10 r11 r12 r13 r14 r15 r16 r17 r18 r21 r23 r26
      0x075d: PHI (r0v101 kotlin.coroutines.Continuation<? super java.lang.Boolean>) = 
      (r0v82 kotlin.coroutines.Continuation<? super java.lang.Boolean>)
      (r0v103 kotlin.coroutines.Continuation<? super java.lang.Boolean>)
     binds: [B:119:0x0604, B:132:0x073b] A[DONT_GENERATE, DONT_INLINE]
      0x075d: PHI (r1v38 'playback' com.AniVortex.PlaybackResponse) = (r1v20 'playback' com.AniVortex.PlaybackResponse), (r1v40 'playback' com.AniVortex.PlaybackResponse) binds: [B:119:0x0604, B:132:0x073b] A[DONT_GENERATE, DONT_INLINE]
      0x075d: PHI (r3v23 com.AniVortex.AniVortexProvider$loadLinks$1) = (r3v14 com.AniVortex.AniVortexProvider$loadLinks$1), (r3v25 com.AniVortex.AniVortexProvider$loadLinks$1) binds: [B:119:0x0604, B:132:0x073b] A[DONT_GENERATE, DONT_INLINE]
      0x075d: PHI (r4v20 'serverName' java.lang.String) = (r4v13 'serverName' java.lang.String), (r4v22 'serverName' java.lang.String) binds: [B:119:0x0604, B:132:0x073b] A[DONT_GENERATE, DONT_INLINE]
      0x075d: PHI (r5v26 '$this$forEach$iv' java.lang.Object) = (r5v9 '$this$forEach$iv' java.lang.Object), (r5v28 '$this$forEach$iv' java.lang.Object) binds: [B:119:0x0604, B:132:0x073b] A[DONT_GENERATE, DONT_INLINE]
      0x075d: PHI (r6v32 'isCasting' boolean) = (r6v24 'isCasting' boolean), (r6v34 'isCasting' boolean) binds: [B:119:0x0604, B:132:0x073b] A[DONT_GENERATE, DONT_INLINE]
      0x075d: PHI (r7v37 java.lang.Object) = (r7v17 java.lang.Object), (r7v40 java.lang.Object) binds: [B:119:0x0604, B:132:0x073b] A[DONT_GENERATE, DONT_INLINE]
      0x075d: PHI (r8v24 'isCasting' boolean) = (r8v14 'isCasting' boolean), (r8v26 'isCasting' boolean) binds: [B:119:0x0604, B:132:0x073b] A[DONT_GENERATE, DONT_INLINE]
      0x075d: PHI (r9v22 'url' java.lang.String) = (r9v15 'url' java.lang.String), (r9v23 'url' java.lang.String) binds: [B:119:0x0604, B:132:0x073b] A[DONT_GENERATE, DONT_INLINE]
      0x075d: PHI (r10v19 'headers' java.util.Map) = (r10v14 'headers' java.util.Map), (r10v20 'headers' java.util.Map) binds: [B:119:0x0604, B:132:0x073b] A[DONT_GENERATE, DONT_INLINE]
      0x075d: PHI (r11v18 'query' java.lang.Object) = (r11v13 'query' java.lang.Object), (r11v19 'query' java.lang.Object) binds: [B:119:0x0604, B:132:0x073b] A[DONT_GENERATE, DONT_INLINE]
      0x075d: PHI (r12v28 'queryParams' java.util.Map) = (r12v23 'queryParams' java.util.Map), (r12v29 'queryParams' java.util.Map) binds: [B:119:0x0604, B:132:0x073b] A[DONT_GENERATE, DONT_INLINE]
      0x075d: PHI (r13v28 'payload' com.AniVortex.EpisodeDataPayload) = (r13v23 'payload' com.AniVortex.EpisodeDataPayload), (r13v29 'payload' com.AniVortex.EpisodeDataPayload) binds: [B:119:0x0604, B:132:0x073b] A[DONT_GENERATE, DONT_INLINE]
      0x075d: PHI (r14v26 kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit>) = 
      (r14v15 kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit>)
      (r14v28 kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit>)
     binds: [B:119:0x0604, B:132:0x073b] A[DONT_GENERATE, DONT_INLINE]
      0x075d: PHI (r15v18 kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit>) = 
      (r15v14 kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit>)
      (r15v19 kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit>)
     binds: [B:119:0x0604, B:132:0x073b] A[DONT_GENERATE, DONT_INLINE]
      0x075d: PHI (r16v10 'data' java.lang.Object) = (r16v6 'data' java.lang.Object), (r16v11 'data' java.lang.Object) binds: [B:119:0x0604, B:132:0x073b] A[DONT_GENERATE, DONT_INLINE]
      0x075d: PHI (r17v16 java.util.Iterator) = (r17v9 java.util.Iterator), (r17v18 java.util.Iterator) binds: [B:119:0x0604, B:132:0x073b] A[DONT_GENERATE, DONT_INLINE]
      0x075d: PHI (r18v10 com.AniVortex.AniVortexProvider) = (r18v6 com.AniVortex.AniVortexProvider), (r18v12 com.AniVortex.AniVortexProvider) binds: [B:119:0x0604, B:132:0x073b] A[DONT_GENERATE, DONT_INLINE]
      0x075d: PHI (r21v12 'titleId' int) = (r21v5 'titleId' int), (r21v13 'titleId' int) binds: [B:119:0x0604, B:132:0x073b] A[DONT_GENERATE, DONT_INLINE]
      0x075d: PHI (r23v10 boolean) = (r23v6 boolean), (r23v11 boolean) binds: [B:119:0x0604, B:132:0x073b] A[DONT_GENERATE, DONT_INLINE]
      0x075d: PHI (r26v10 '$result' java.lang.Object) = (r26v4 '$result' java.lang.Object), (r26v11 '$result' java.lang.Object) binds: [B:119:0x0604, B:132:0x073b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:93:0x0467  */
    /* JADX WARN: Code duplicated, block: B:95:0x0477  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:119:0x0604 -> B:133:0x075d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:120:0x0606 -> B:121:0x0626). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:125:0x063e -> B:131:0x0724). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:129:0x06f4 -> B:130:0x070f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:159:0x0852 -> B:160:0x086b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object loadLinks(@org.jetbrains.annotations.NotNull java.lang.String r46, boolean r47, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r48, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r49, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r50) {
        /*
            Method dump skipped, instruction units count: 2248
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
