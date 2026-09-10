package com.phisher98;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lagradost.cloudstream3.AnimeLoadResponse;
import com.lagradost.cloudstream3.AnimeSearchResponse;
import com.lagradost.cloudstream3.DubStatus;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.MainPageData;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.Score;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.ShowStatus;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.syncproviders.SyncIdName;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.Qualities;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
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
import kotlin.coroutines.CoroutineContext;
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
import kotlinx.coroutines.BuildersKt;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Reanime.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Reanime/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u0000 [2\u00020\u0001:\u0017[\\]^_`abcdefghijklmnopqB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010%\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0096@¢\u0006\u0002\u0010,J\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020.0#2\u0006\u0010/\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u00100J\u001c\u00101\u001a\b\u0012\u0004\u0012\u00020.0#2\u0006\u0010/\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u00100J\u000e\u00102\u001a\u0004\u0018\u00010.*\u000203H\u0002J\u000e\u00102\u001a\u0004\u0018\u00010.*\u000204H\u0002J\u0018\u00105\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u00100JR\u00108\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020:0#\u0012\n\u0012\b\u0012\u0004\u0012\u00020:0#092\u0006\u0010;\u001a\u00020\u00052\b\u0010<\u001a\u0004\u0018\u00010)2\u0006\u0010=\u001a\u00020)2\u0006\u0010>\u001a\u00020)2\b\u0010?\u001a\u0004\u0018\u00010@H\u0082@¢\u0006\u0002\u0010AJF\u0010B\u001a\u00020\u000e2\u0006\u0010C\u001a\u00020\u00052\u0006\u0010D\u001a\u00020\u000e2\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020H0F2\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020H0FH\u0096@¢\u0006\u0002\u0010KJF\u0010L\u001a\u00020\u000e2\u0006\u0010M\u001a\u00020\u00052\u0006\u0010N\u001a\u00020\u00052\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020H0F2\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020H0FH\u0082@¢\u0006\u0002\u0010OJ\u0010\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020JH\u0016J>\u0010S\u001a\u00020H2\u0006\u0010T\u001a\u00020U2\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020H0F2\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020H0FH\u0082@¢\u0006\u0002\u0010VJ\u0012\u0010W\u001a\u00020)2\b\u0010X\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010Y\u001a\u0004\u0018\u00010\u0005*\u0004\u0018\u00010ZH\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0014\u0010\u0016\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u000e\u0010 \u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&¨\u0006r"}, d2 = {"Lcom/phisher98/Reanime;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasQuickSearch", "getHasQuickSearch", "hasDownloadSupport", "getHasDownloadSupport", "supportedSyncNames", "", "Lcom/lagradost/cloudstream3/syncproviders/SyncIdName;", "getSupportedSyncNames", "()Ljava/util/Set;", "supportedTypes", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "apiUrl", "aniZipApi", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "quickSearch", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "toSearchResponse", "Lcom/phisher98/Reanime$HomeAnime;", "Lcom/phisher98/Reanime$SearchAnime;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "fetchAllEpisodes", "Lkotlin/Pair;", "Lcom/lagradost/cloudstream3/Episode;", "animeId", "anilistId", "subbedCount", "dubbedCount", "anizip", "Lcom/phisher98/Reanime$AniZipResponse;", "(Ljava/lang/String;Ljava/lang/Integer;IILcom/phisher98/Reanime$AniZipResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveFlixEmbed", "embedUrl", "label", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVideoInterceptor", "Lokhttp3/Interceptor;", "extractorLink", "processSourcesResponse", "response", "Lcom/phisher98/Reanime$SourcesResponse;", "(Lcom/phisher98/Reanime$SourcesResponse;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveQuality", "q", "preferredTitle", "Lcom/phisher98/Reanime$Title;", "Companion", "HomeResponse", "HomeAnime", "SearchResponse2", "SearchAnime", "AnimeDetail", "StartDate", "Studio", "Artwork", "Tag", "EpisodesResponse", "EpisodeData", "SourcesResponse", "Source", "Subtitle", "FlixResponse", "FlixServer", "Title", "CoverImage", "AniZipResponse", "AniZipEpisode", "AniZipImage", "AniZipMappings", "Reanime"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nReanime.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Reanime.kt\ncom/phisher98/Reanime\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,944:1\n73#2,5:945\n73#2,5:964\n73#2,5:983\n73#2,5:1002\n73#2,5:1029\n73#2,5:1034\n73#2,5:1043\n73#2,5:1051\n73#2,5:1056\n73#2,5:1066\n1795#3,10:950\n2068#3:960\n2069#3:962\n1805#3:963\n1795#3,10:969\n2068#3:979\n2069#3:981\n1805#3:982\n1795#3,10:988\n2068#3:998\n2069#3:1000\n1805#3:1001\n296#3,2:1007\n296#3,2:1010\n777#3:1012\n873#3,2:1013\n1795#3,10:1015\n2068#3:1025\n2069#3:1027\n1805#3:1028\n296#3,2:1039\n296#3,2:1041\n2068#3:1048\n2069#3:1050\n777#3:1061\n873#3,2:1062\n2068#3,2:1064\n2068#3,2:1071\n2068#3,2:1073\n2068#3,2:1077\n2068#3:1079\n2068#3,2:1080\n2069#3:1082\n2068#3,2:1083\n1#4:961\n1#4:980\n1#4:999\n1#4:1009\n1#4:1026\n1#4:1049\n1505#5,2:1075\n*S KotlinDebug\n*F\n+ 1 Reanime.kt\ncom/phisher98/Reanime\n*L\n138#1:945,5\n144#1:964,5\n161#1:983,5\n205#1:1002,5\n230#1:1029,5\n234#1:1034,5\n292#1:1043,5\n386#1:1051,5\n404#1:1056,5\n447#1:1066,5\n139#1:950,10\n139#1:960\n139#1:962\n139#1:963\n151#1:969,10\n151#1:979\n151#1:981\n151#1:982\n163#1:988,10\n163#1:998\n163#1:1000\n163#1:1001\n211#1:1007,2\n220#1:1010,2\n224#1:1012\n224#1:1013,2\n225#1:1015,10\n225#1:1025\n225#1:1027\n225#1:1028\n246#1:1039,2\n248#1:1041,2\n297#1:1048\n297#1:1050\n405#1:1061\n405#1:1062,2\n411#1:1064,2\n460#1:1071,2\n490#1:1073,2\n553#1:1077,2\n669#1:1079\n691#1:1080,2\n669#1:1082\n718#1:1083,2\n139#1:961\n151#1:980\n163#1:999\n225#1:1026\n526#1:1075,2\n*E\n"})
public final class Reanime extends MainAPI {

    @Nullable
    private static volatile String lastFlixKeyUrl;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final ConcurrentHashMap<String, byte[]> flixKeyCache = new ConcurrentHashMap<>();

    @NotNull
    private static final byte[] FLIX_SEGMENT_XOR_KEY = {-99, 42, -15, 71, -77, -114, 92, 112, -90, 25, -28, 59, -40, 98, 15, -59};

    @NotNull
    private String mainUrl = "https://reanime.to";

    @NotNull
    private String name = "Re:ANIME";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "en";
    private final boolean hasQuickSearch = true;
    private final boolean hasDownloadSupport = true;

    @NotNull
    private final Set<SyncIdName> supportedSyncNames = SetsKt.setOf(new SyncIdName[]{SyncIdName.MyAnimeList, SyncIdName.Anilist});

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Anime, TvType.AnimeMovie, TvType.OVA});

    @NotNull
    private final String apiUrl = getMainUrl() + "/api/v1";

    @NotNull
    private final String aniZipApi = "https://api.ani.zip/mappings";

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("trending", "Trending Now"), TuplesKt.to("latest_aired", "Latest Episodes"), TuplesKt.to("status=Releasing&sort=popularity_desc", "Currently Airing"), TuplesKt.to("sort=popularity_desc", "Most Popular"), TuplesKt.to("sort=score_desc", "Top Rated"), TuplesKt.to("sort=year_desc", "New Releases"), TuplesKt.to("format=Movie&sort=popularity_desc", "Anime Movies"), TuplesKt.to("status=Finished&sort=popularity_desc", "Completed Series")});

    /* JADX INFO: renamed from: com.phisher98.Reanime$fetchAllEpisodes$1 */
    /* JADX INFO: compiled from: Reanime.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Reanime", f = "Reanime.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {291}, m = "fetchAllEpisodes", n = {"animeId", "anilistId", "anizip", "subEps", "dubEps", "subbedCount", "dubbedCount", "offset", "limit", "hasMore"}, nl = {292}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2", "I$3", "I$4"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
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
            return Reanime.this.fetchAllEpisodes(null, null, 0, 0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.Reanime$getMainPage$1 */
    /* JADX INFO: compiled from: Reanime.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Reanime", f = "Reanime.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1}, l = {138, 144}, m = "getMainPage", n = {"request", "data", "query", "url", "page", "limit", "offset", "request", "data", "page"}, nl = {945, 964}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "I$2", "L$0", "L$1", "I$0"}, v = 2)
    static final class C00021 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C00021(Continuation<? super C00021> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Reanime.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.Reanime$load$1 */
    /* JADX INFO: compiled from: Reanime.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Reanime", f = "Reanime.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {205, 230, 234, 254, 256}, m = "load", n = {"url", "animeId", "url", "animeId", "detail", "title", "poster", "description", "status", "tvType", "anilistId", "malId", "banner", "studioNames", "$this$load_u24lambda_u245", "url", "animeId", "detail", "title", "poster", "description", "status", "tvType", "anilistId", "malId", "banner", "studioNames", "$this$load_u24lambda_u246", "url", "animeId", "detail", "title", "poster", "description", "status", "tvType", "anilistId", "malId", "banner", "studioNames", "anizip", "anizipPoster", "anizipFanart", "finalPoster", "finalBanner", "logoUrl", "effectiveAnilistId", "url", "animeId", "detail", "title", "poster", "description", "status", "tvType", "anilistId", "malId", "banner", "studioNames", "anizip", "anizipPoster", "anizipFanart", "finalPoster", "finalBanner", "logoUrl", "effectiveAnilistId", "subEps", "dubEps"}, nl = {945, 972, 977, 256, -1}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20"}, v = 2)
    static final class C00031 extends ContinuationImpl {
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
        int label;
        /* synthetic */ Object result;

        C00031(Continuation<? super C00031> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Reanime.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.Reanime$loadLinks$1 */
    /* JADX INFO: compiled from: Reanime.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Reanime", f = "Reanime.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, l = {386, 397, 419, 429, 440, 449, 459, 464, 480, 485}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "parts", "watchUrl", "animeId", "episodeId", "anilistId", "epNum", "dubType", "$this$loadLinks_u24lambda_u242", "isCasting", "data", "subtitleCallback", "callback", "parts", "watchUrl", "animeId", "episodeId", "anilistId", "epNum", "dubType", "foundLinks", "flixUrl", "$this$loadLinks_u24lambda_u243", "isCasting", "data", "subtitleCallback", "callback", "parts", "watchUrl", "animeId", "episodeId", "anilistId", "epNum", "dubType", "foundLinks", "flixUrl", "res", "flix", "matchingServers", "$this$forEach$iv", "element$iv", "server", "sName", "link", "sType", "label", "$this$loadLinks_u24lambda_u245_u240", "hasLinks", "isCasting", "data", "subtitleCallback", "callback", "parts", "watchUrl", "animeId", "episodeId", "anilistId", "epNum", "dubType", "foundLinks", "flixUrl", "res", "flix", "matchingServers", "$this$forEach$iv", "element$iv", "server", "sName", "link", "sType", "label", "isCasting", "handled", "data", "subtitleCallback", "callback", "parts", "watchUrl", "animeId", "episodeId", "anilistId", "epNum", "dubType", "foundLinks", "sourcesUrl", "$this$loadLinks_u24lambda_u246", "isCasting", "data", "subtitleCallback", "callback", "parts", "watchUrl", "animeId", "episodeId", "anilistId", "epNum", "dubType", "foundLinks", "sourcesUrl", "res", "sources", "isCasting", "data", "subtitleCallback", "callback", "parts", "watchUrl", "animeId", "episodeId", "anilistId", "epNum", "dubType", "foundLinks", "$this$loadLinks_u24lambda_u247", "isCasting", "data", "subtitleCallback", "callback", "parts", "watchUrl", "animeId", "episodeId", "anilistId", "epNum", "dubType", "foundLinks", "$this$loadLinks_u24lambda_u247", "doc", "$this$forEach$iv", "element$iv", "iframe", "src", "$this$loadLinks_u24lambda_u247_u240_u240", "isCasting", "data", "subtitleCallback", "callback", "parts", "watchUrl", "animeId", "episodeId", "anilistId", "epNum", "dubType", "foundLinks", "resolver", "$this$loadLinks_u24lambda_u248", "isCasting", "data", "subtitleCallback", "callback", "parts", "watchUrl", "animeId", "episodeId", "anilistId", "epNum", "dubType", "foundLinks", "resolver", "intercepted", "$this$loadLinks_u24lambda_u249", "isCasting"}, nl = {946, 400, 423, 430, 443, 450, 460, 463, 479, 490}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "Z$0", "Z$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$15", "L$16", "L$17", "L$18", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "Z$0"}, v = 2)
    static final class C00051 extends ContinuationImpl {
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
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        boolean Z$0;
        boolean Z$1;
        int label;
        /* synthetic */ Object result;

        C00051(Continuation<? super C00051> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Reanime.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.Reanime$processSourcesResponse$1 */
    /* JADX INFO: compiled from: Reanime.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Reanime", f = "Reanime.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5}, l = {680, 686, 694, 702, 709, 721}, m = "processSourcesResponse", n = {"response", "subtitleCallback", "callback", "$this$forEach$iv", "element$iv", "source", "src", "$this$processSourcesResponse_u24lambda_u240_u241", "label", "quality", "response", "subtitleCallback", "callback", "$this$forEach$iv", "element$iv", "source", "src", "$this$processSourcesResponse_u24lambda_u240_u242", "label", "quality", "handledByExtractor", "response", "subtitleCallback", "callback", "$this$forEach$iv", "element$iv", "source", "src", "it", "label", "quality", "handledByExtractor", "response", "subtitleCallback", "callback", "$this$forEach$iv", "element$iv", "source", "src", "label", "quality", "handledByExtractor", "response", "subtitleCallback", "callback", "$this$forEach$iv", "element$iv", "source", "src", "label", "quality", "handledByExtractor", "response", "subtitleCallback", "callback", "$this$forEach$iv", "element$iv", "sub", "lang", "subUrl"}, nl = {679, 691, 693, 701, 708, 722}, s = {"L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$7", "L$8", "L$10", "I$0", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$7", "L$8", "I$0", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$7", "L$8", "I$0", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$7", "L$8"}, v = 2)
    static final class C00061 extends ContinuationImpl {
        int I$0;
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
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00061(Continuation<? super C00061> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Reanime.this.processSourcesResponse(null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.Reanime$resolveFlixEmbed$1 */
    /* JADX INFO: compiled from: Reanime.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Reanime", f = "Reanime.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5}, l = {509, 518, 529, 543, 548, 559}, m = "resolveFlixEmbed", n = {"embedUrl", "label", "subtitleCallback", "callback", "found", "$this$resolveFlixEmbed_u24lambda_u240", "embedUrl", "label", "subtitleCallback", "callback", "found", "$this$resolveFlixEmbed_u24lambda_u241", "embedUrl", "label", "subtitleCallback", "callback", "found", "$this$resolveFlixEmbed_u24lambda_u241", "subRegex", "embedHtml", "$this$forEach$iv", "element$iv", "match", "url", "lang", "embedUrl", "label", "subtitleCallback", "callback", "found", "resolver", "$this$resolveFlixEmbed_u24lambda_u242", "embedUrl", "label", "subtitleCallback", "callback", "found", "resolver", "interceptedUrl", "$this$resolveFlixEmbed_u24lambda_u243", "embedUrl", "label", "subtitleCallback", "callback", "found", "resolver", "interceptedUrl", "generated"}, nl = {513, 524, 531, 542, 553, 558}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$10", "L$11", "L$12", "L$13", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0"}, v = 2)
    static final class C00071 extends ContinuationImpl {
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

        C00071(Continuation<? super C00071> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Reanime.this.resolveFlixEmbed(null, null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.Reanime$search$1 */
    /* JADX INFO: compiled from: Reanime.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Reanime", f = "Reanime.kt", i = {0}, l = {160}, m = "search", n = {"query"}, nl = {161}, s = {"L$0"}, v = 2)
    static final class C00091 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00091(Continuation<? super C00091> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Reanime.this.search(null, (Continuation) this);
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
    public Set<SyncIdName> getSupportedSyncNames() {
        return this.supportedSyncNames;
    }

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    /* JADX INFO: compiled from: Reanime.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006J\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006J\n\u0010\u0012\u001a\u00020\u0006*\u00020\u0006R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/phisher98/Reanime$Companion;", "", "<init>", "()V", "flixKeyCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "lastFlixKeyUrl", "FLIX_SEGMENT_XOR_KEY", "deobfuscateSegment", "bytes", "getStatus", "Lcom/lagradost/cloudstream3/ShowStatus;", "s", "getTvType", "Lcom/lagradost/cloudstream3/TvType;", "format", "stripHtml", "Reanime"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final byte[] deobfuscateSegment(@NotNull byte[] bytes) {
            int lOffset = -1;
            boolean needXor = true;
            if (bytes.length >= 12 && bytes[0] == 82 && bytes[1] == 73 && bytes[2] == 70 && bytes[3] == 70 && bytes[8] == 87 && bytes[9] == 69 && bytes[10] == 66 && bytes[11] == 80) {
                lOffset = 12;
                if (bytes.length >= 13 && bytes[12] == 71) {
                    needXor = false;
                }
            } else if (bytes.length >= 8 && bytes[0] == -119 && bytes[1] == 80 && bytes[2] == 78 && bytes[3] == 71 && bytes[4] == 13 && bytes[5] == 10 && bytes[6] == 26 && bytes[7] == 10) {
                lOffset = 8;
                if (bytes.length >= 9 && bytes[8] == 71) {
                    needXor = false;
                }
            }
            if (lOffset == -1) {
                return bytes;
            }
            int outLen = bytes.length - lOffset;
            byte[] result = new byte[outLen];
            if (needXor) {
                byte[] xorKey = Reanime.FLIX_SEGMENT_XOR_KEY;
                for (int i = 0; i < outLen; i++) {
                    result[i] = (byte) (bytes[lOffset + i] ^ xorKey[i & 15]);
                }
            } else {
                System.arraycopy(bytes, lOffset, result, 0, outLen);
            }
            return result;
        }

        @NotNull
        public final ShowStatus getStatus(@NotNull String s) {
            String lowerCase = s.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (Intrinsics.areEqual(lowerCase, "finished")) {
                return ShowStatus.Completed;
            }
            return Intrinsics.areEqual(lowerCase, "releasing") ? ShowStatus.Ongoing : ShowStatus.Completed;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x002b, code lost:
        
            if (r0.equals("OVA") == false) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0034, code lost:
        
            if (r0.equals("ONA") == false) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x003d, code lost:
        
            if (r0.equals("SPECIAL") == false) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:?, code lost:
        
            return com.lagradost.cloudstream3.TvType.OVA;
         */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final TvType getTvType(@Nullable String format) {
            String upperCase;
            if (format != null) {
                upperCase = format.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            } else {
                upperCase = null;
            }
            if (upperCase != null) {
                switch (upperCase.hashCode()) {
                    case -1290482535:
                        break;
                    case 78402:
                        break;
                    case 78650:
                        break;
                    case 73549584:
                        if (upperCase.equals("MOVIE")) {
                            return TvType.AnimeMovie;
                        }
                        break;
                }
            }
            return TvType.Anime;
        }

        @NotNull
        public final String stripHtml(@NotNull String $this$stripHtml) {
            return StringsKt.trim(new Regex("<[^>]+>").replace(new Regex("<br\\s*/?>", RegexOption.IGNORE_CASE).replace($this$stripHtml, "\n"), "")).toString();
        }
    }

    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    /* JADX WARN: Code duplicated, block: B:106:0x01b4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:109:0x030c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:110:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:111:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:112:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x0144 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:37:0x0145  */
    /* JADX WARN: Code duplicated, block: B:40:0x014d  */
    /* JADX WARN: Code duplicated, block: B:43:0x0156  */
    /* JADX WARN: Code duplicated, block: B:44:0x015b  */
    /* JADX WARN: Code duplicated, block: B:47:0x0164  */
    /* JADX WARN: Code duplicated, block: B:48:0x0169  */
    /* JADX WARN: Code duplicated, block: B:51:0x0172  */
    /* JADX WARN: Code duplicated, block: B:52:0x0177  */
    /* JADX WARN: Code duplicated, block: B:54:0x017b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:55:0x017c  */
    /* JADX WARN: Code duplicated, block: B:58:0x0199  */
    /* JADX WARN: Code duplicated, block: B:60:0x01af  */
    /* JADX WARN: Code duplicated, block: B:75:0x02d1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:76:0x02d2  */
    /* JADX WARN: Code duplicated, block: B:78:0x02d8  */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    /* JADX WARN: Code duplicated, block: B:81:0x02f1  */
    /* JADX WARN: Code duplicated, block: B:83:0x0307  */
    /* JADX WARN: Code duplicated, block: B:86:0x0317  */
    /* JADX WARN: Code duplicated, block: B:89:0x0321  */
    /* JADX WARN: Code duplicated, block: B:90:0x0326  */
    /* JADX WARN: Code duplicated, block: B:93:0x032b  */
    /* JADX WARN: Code duplicated, block: B:94:0x032d  */
    /* JADX WARN: Code duplicated, block: B:97:0x0334  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        C00021 c00021;
        boolean z;
        String data;
        int limit;
        int offset;
        MainPageRequest request2;
        boolean z2;
        Object obj;
        C00021 c00022;
        String data2;
        MainPageRequest request3;
        Object safe;
        SearchResponse2 res;
        Iterable results;
        List results2;
        Integer total;
        int iIntValue;
        boolean hasNext;
        Iterable $this$mapNotNull$iv;
        Collection destination$iv$iv;
        SearchResponse searchResponse;
        Object safe2;
        HomeResponse home;
        Object it$iv$iv;
        Collection destination$iv$iv2;
        SearchResponse searchResponse2;
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
        Object obj2 = null;
        switch (c00021.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String data3 = request.getData();
                if (StringsKt.contains$default(data3, "=", false, 2, (Object) null) || StringsKt.startsWith$default(data3, "status", false, 2, (Object) null) || StringsKt.startsWith$default(data3, "sort", false, 2, (Object) null) || StringsKt.startsWith$default(data3, "format", false, 2, (Object) null)) {
                    Object obj3 = coroutine_suspended;
                    z = false;
                    int offset2 = (page - 1) * 36;
                    String query = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(data3, "sort=popularity_desc", "sort=popularity", false, 4, (Object) null), "sort=score_desc", "sort=score", false, 4, (Object) null), "sort=year_desc", "sort=year", false, 4, (Object) null), "sort=popularity", "sort=popularity_desc", false, 4, (Object) null), "sort=score", "sort=score_desc", false, 4, (Object) null), "sort=year", "sort=year_desc", false, 4, (Object) null);
                    String url = this.apiUrl + "/search?" + query + "&limit=36&offset=" + offset2;
                    Requests app = MainActivityKt.getApp();
                    c00021.L$0 = request;
                    c00021.L$1 = SpillingKt.nullOutSpilledVariable(data3);
                    c00021.L$2 = SpillingKt.nullOutSpilledVariable(query);
                    c00021.L$3 = SpillingKt.nullOutSpilledVariable(url);
                    c00021.I$0 = page;
                    c00021.I$1 = 36;
                    c00021.I$2 = offset2;
                    c00021.label = 1;
                    $result = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00021, 4094, (Object) null);
                    if ($result == obj3) {
                        return obj3;
                    }
                    data = data3;
                    limit = 36;
                    offset = offset2;
                    request2 = request;
                    NiceResponse this_$iv = (NiceResponse) $result;
                    try {
                        ResponseParser parser = this_$iv.getParser();
                        Intrinsics.checkNotNull(parser);
                        safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(SearchResponse2.class));
                        break;
                    } catch (Exception e$iv) {
                        e$iv.printStackTrace();
                        safe = obj2;
                    }
                    res = (SearchResponse2) safe;
                    if (res == null) {
                        return obj2;
                    }
                    results = res.getResults();
                    if (results != null) {
                        $this$mapNotNull$iv = results;
                        destination$iv$iv = new ArrayList();
                        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                            Iterable $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                            SearchAnime it = (SearchAnime) element$iv$iv$iv;
                            searchResponse = toSearchResponse(it);
                            if (searchResponse != null) {
                                destination$iv$iv.add(searchResponse);
                            }
                            $this$mapNotNull$iv = $this$mapNotNull$iv2;
                        }
                        results2 = (List) destination$iv$iv;
                    } else {
                        results2 = CollectionsKt.emptyList();
                    }
                    total = res.getTotal();
                    if (total != null) {
                        iIntValue = total.intValue();
                    } else {
                        iIntValue = 0;
                    }
                    if (iIntValue > offset + limit) {
                        hasNext = true;
                    } else {
                        hasNext = false;
                    }
                    String name = request2.getName();
                    if (hasNext) {
                        z = true;
                    }
                    return MainAPIKt.newHomePageResponse(name, results2, Boxing.boxBoolean(z));
                }
                if (page > 1) {
                    return null;
                }
                Requests app2 = MainActivityKt.getApp();
                String str = this.apiUrl + "/home";
                c00021.L$0 = request;
                c00021.L$1 = data3;
                c00021.I$0 = page;
                c00021.label = 2;
                z2 = false;
                obj = null;
                C00021 c00023 = c00021;
                $result = Requests.get$default(app2, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00023, 4094, (Object) null);
                c00022 = c00023;
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                data2 = data3;
                request3 = request;
                NiceResponse this_$iv2 = (NiceResponse) $result;
                try {
                    ResponseParser parser2 = this_$iv2.getParser();
                    Intrinsics.checkNotNull(parser2);
                    safe2 = parser2.parseSafe(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(HomeResponse.class));
                    break;
                } catch (Exception e$iv2) {
                    e$iv2.printStackTrace();
                    safe2 = obj;
                }
                home = (HomeResponse) safe2;
                if (home == null) {
                    return obj;
                }
                switch (data2) {
                    case "new_on_site":
                        it$iv$iv = home.getNewOnSite();
                        break;
                    case "latest_aired":
                        it$iv$iv = home.getLatestAired();
                        break;
                    case "trending":
                        it$iv$iv = home.getTrending();
                        break;
                    default:
                        it$iv$iv = obj;
                        break;
                }
                if (it$iv$iv == null) {
                    return obj;
                }
                String name2 = request3.getName();
                destination$iv$iv2 = new ArrayList();
                for (Object element$iv$iv$iv2 : (Iterable) it$iv$iv) {
                    Object list = it$iv$iv;
                    HomeAnime it2 = (HomeAnime) element$iv$iv$iv2;
                    searchResponse2 = toSearchResponse(it2);
                    if (searchResponse2 != null) {
                        destination$iv$iv2.add(searchResponse2);
                    }
                    it$iv$iv = list;
                }
                return MainAPIKt.newHomePageResponse(name2, (List) destination$iv$iv2, Boxing.boxBoolean(z2));
            case 1:
                offset = c00021.I$2;
                limit = c00021.I$1;
                int i = c00021.I$0;
                data = (String) c00021.L$1;
                MainPageRequest request4 = (MainPageRequest) c00021.L$0;
                ResultKt.throwOnFailure($result);
                obj2 = null;
                z = false;
                request2 = request4;
                NiceResponse this_$iv3 = (NiceResponse) $result;
                ResponseParser parser3 = this_$iv3.getParser();
                Intrinsics.checkNotNull(parser3);
                safe = parser3.parseSafe(this_$iv3.getText(), Reflection.getOrCreateKotlinClass(SearchResponse2.class));
                res = (SearchResponse2) safe;
                if (res == null) {
                    return obj2;
                }
                results = res.getResults();
                if (results != null) {
                    $this$mapNotNull$iv = results;
                    destination$iv$iv = new ArrayList();
                    while (r17.hasNext()) {
                        Iterable $this$mapNotNull$iv3 = $this$mapNotNull$iv;
                        SearchAnime it3 = (SearchAnime) element$iv$iv$iv;
                        searchResponse = toSearchResponse(it3);
                        if (searchResponse != null) {
                            destination$iv$iv.add(searchResponse);
                        }
                        $this$mapNotNull$iv = $this$mapNotNull$iv3;
                    }
                    results2 = (List) destination$iv$iv;
                } else {
                    results2 = CollectionsKt.emptyList();
                }
                total = res.getTotal();
                if (total != null) {
                    iIntValue = total.intValue();
                } else {
                    iIntValue = 0;
                }
                if (iIntValue > offset + limit) {
                    hasNext = true;
                } else {
                    hasNext = false;
                }
                String name3 = request2.getName();
                if (hasNext) {
                    z = true;
                }
                return MainAPIKt.newHomePageResponse(name3, results2, Boxing.boxBoolean(z));
            case 2:
                int i2 = c00021.I$0;
                String data4 = (String) c00021.L$1;
                MainPageRequest request5 = (MainPageRequest) c00021.L$0;
                ResultKt.throwOnFailure($result);
                data2 = data4;
                obj = null;
                z2 = false;
                c00022 = c00021;
                request3 = request5;
                NiceResponse this_$iv4 = (NiceResponse) $result;
                ResponseParser parser4 = this_$iv4.getParser();
                Intrinsics.checkNotNull(parser4);
                safe2 = parser4.parseSafe(this_$iv4.getText(), Reflection.getOrCreateKotlinClass(HomeResponse.class));
                home = (HomeResponse) safe2;
                if (home == null) {
                    return obj;
                }
                switch (data2) {
                    case -2070475256:
                        if (data2.equals("new_on_site")) {
                            it$iv$iv = home.getNewOnSite();
                        }
                        break;
                    case 603933873:
                        if (data2.equals("latest_aired")) {
                            it$iv$iv = home.getLatestAired();
                        }
                        break;
                    case 1394955557:
                        if (data2.equals("trending")) {
                            it$iv$iv = home.getTrending();
                        }
                        break;
                    default:
                        it$iv$iv = obj;
                        break;
                }
                if (it$iv$iv == null) {
                    return obj;
                }
                String name4 = request3.getName();
                destination$iv$iv2 = new ArrayList();
                while (r16.hasNext()) {
                    Object list2 = it$iv$iv;
                    HomeAnime it4 = (HomeAnime) element$iv$iv$iv2;
                    searchResponse2 = toSearchResponse(it4);
                    if (searchResponse2 != null) {
                        destination$iv$iv2.add(searchResponse2);
                    }
                    it$iv$iv = list2;
                }
                return MainAPIKt.newHomePageResponse(name4, (List) destination$iv$iv2, Boxing.boxBoolean(z2));
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Nullable
    public Object quickSearch(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        return search(query, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        C00091 c00091;
        Object safe;
        Iterable results;
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
                Requests app = MainActivityKt.getApp();
                String str = this.apiUrl + "/search?q=" + query;
                c00092.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00092.label = 1;
                $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00092, 4094, (Object) null);
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
        NiceResponse this_$iv = (NiceResponse) $result;
        try {
            ResponseParser parser = this_$iv.getParser();
            Intrinsics.checkNotNull(parser);
            safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(SearchResponse2.class));
        } catch (Exception e$iv) {
            e$iv.printStackTrace();
            safe = null;
        }
        SearchResponse2 searchResponse2 = (SearchResponse2) safe;
        if (searchResponse2 == null || (results = searchResponse2.getResults()) == null) {
            return CollectionsKt.emptyList();
        }
        Iterable $this$mapNotNull$iv = results;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            SearchAnime it = (SearchAnime) element$iv$iv$iv;
            SearchResponse searchResponse = toSearchResponse(it);
            if (searchResponse != null) {
                destination$iv$iv.add(searchResponse);
            }
        }
        return (List) destination$iv$iv;
    }

    private final SearchResponse toSearchResponse(final HomeAnime $this$toSearchResponse) {
        String title;
        final String poster;
        String id = $this$toSearchResponse.getAnimeId();
        if (id == null || (title = preferredTitle($this$toSearchResponse.getTitle())) == null) {
            return null;
        }
        CoverImage coverImage = $this$toSearchResponse.getCoverImage();
        if (coverImage == null || (poster = coverImage.getExtraLarge()) == null) {
            CoverImage coverImage2 = $this$toSearchResponse.getCoverImage();
            poster = coverImage2 != null ? coverImage2.getLarge() : null;
            if (poster == null) {
                CoverImage coverImage3 = $this$toSearchResponse.getCoverImage();
                poster = coverImage3 != null ? coverImage3.getMedium() : null;
                if (poster == null) {
                    return null;
                }
            }
        }
        return MainAPIKt.newAnimeSearchResponse$default(this, title, getMainUrl() + "/anime/" + id, INSTANCE.getTvType($this$toSearchResponse.getFormat()), false, new Function1() { // from class: com.phisher98.Reanime$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                return Reanime.toSearchResponse$lambda$0(poster, $this$toSearchResponse, (AnimeSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResponse$lambda$0(String $poster, HomeAnime $this_toSearchResponse, AnimeSearchResponse $this$newAnimeSearchResponse) {
        $this$newAnimeSearchResponse.setPosterUrl($poster);
        Integer dubbed = $this_toSearchResponse.getDubbed();
        boolean z = (dubbed != null ? dubbed.intValue() : 0) > 0;
        Integer subbed = $this_toSearchResponse.getSubbed();
        MainAPIKt.addDubStatus($this$newAnimeSearchResponse, z, (subbed != null ? subbed.intValue() : 0) > 0, $this_toSearchResponse.getDubbed(), $this_toSearchResponse.getSubbed());
        return Unit.INSTANCE;
    }

    private final SearchResponse toSearchResponse(final SearchAnime $this$toSearchResponse) {
        String title;
        final String poster;
        String id = $this$toSearchResponse.getAnimeId();
        if (id == null || (title = preferredTitle($this$toSearchResponse.getTitle())) == null) {
            return null;
        }
        CoverImage coverImage = $this$toSearchResponse.getCoverImage();
        if (coverImage == null || (poster = coverImage.getExtraLarge()) == null) {
            CoverImage coverImage2 = $this$toSearchResponse.getCoverImage();
            poster = coverImage2 != null ? coverImage2.getLarge() : null;
            if (poster == null) {
                CoverImage coverImage3 = $this$toSearchResponse.getCoverImage();
                poster = coverImage3 != null ? coverImage3.getMedium() : null;
                if (poster == null) {
                    return null;
                }
            }
        }
        return MainAPIKt.newAnimeSearchResponse$default(this, title, getMainUrl() + "/anime/" + id, INSTANCE.getTvType($this$toSearchResponse.getFormat()), false, new Function1() { // from class: com.phisher98.Reanime$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                return Reanime.toSearchResponse$lambda$1(poster, $this$toSearchResponse, (AnimeSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResponse$lambda$1(String $poster, SearchAnime $this_toSearchResponse, AnimeSearchResponse $this$newAnimeSearchResponse) {
        $this$newAnimeSearchResponse.setPosterUrl($poster);
        Integer dubbed = $this_toSearchResponse.getDubbed();
        boolean z = (dubbed != null ? dubbed.intValue() : 0) > 0;
        Integer subbed = $this_toSearchResponse.getSubbed();
        MainAPIKt.addDubStatus($this$newAnimeSearchResponse, z, (subbed != null ? subbed.intValue() : 0) > 0, $this_toSearchResponse.getDubbed(), $this_toSearchResponse.getSubbed());
        Integer averageScore = $this_toSearchResponse.getAverageScore();
        if (averageScore != null) {
            int it = averageScore.intValue();
            $this$newAnimeSearchResponse.setScore(Score.Companion.from10(String.valueOf(((double) it) / 10.0d)));
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0398  */
    /* JADX WARN: Code duplicated, block: B:104:0x03b8  */
    /* JADX WARN: Code duplicated, block: B:109:0x03ea  */
    /* JADX WARN: Code duplicated, block: B:111:0x03fe  */
    /* JADX WARN: Code duplicated, block: B:112:0x040a  */
    /* JADX WARN: Code duplicated, block: B:115:0x0417  */
    /* JADX WARN: Code duplicated, block: B:123:0x04ab A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:124:0x04ac  */
    /* JADX WARN: Code duplicated, block: B:149:0x0547  */
    /* JADX WARN: Code duplicated, block: B:151:0x055a  */
    /* JADX WARN: Code duplicated, block: B:153:0x0573 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:161:0x0600 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:162:0x0601  */
    /* JADX WARN: Code duplicated, block: B:196:0x0696  */
    /* JADX WARN: Code duplicated, block: B:198:0x06a8  */
    /* JADX WARN: Code duplicated, block: B:199:0x06c5  */
    /* JADX WARN: Code duplicated, block: B:202:0x06e3  */
    /* JADX WARN: Code duplicated, block: B:215:0x0722  */
    /* JADX WARN: Code duplicated, block: B:219:0x072a  */
    /* JADX WARN: Code duplicated, block: B:232:0x0764  */
    /* JADX WARN: Code duplicated, block: B:235:0x076a  */
    /* JADX WARN: Code duplicated, block: B:236:0x076d  */
    /* JADX WARN: Code duplicated, block: B:238:0x0770 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:239:0x0772  */
    /* JADX WARN: Code duplicated, block: B:240:0x0774  */
    /* JADX WARN: Code duplicated, block: B:241:0x0776  */
    /* JADX WARN: Code duplicated, block: B:244:0x0782  */
    /* JADX WARN: Code duplicated, block: B:247:0x0790  */
    /* JADX WARN: Code duplicated, block: B:249:0x07ad  */
    /* JADX WARN: Code duplicated, block: B:253:0x07bc  */
    /* JADX WARN: Code duplicated, block: B:256:0x07c0 A[LOOP:2: B:245:0x078a->B:256:0x07c0, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:260:0x07d4  */
    /* JADX WARN: Code duplicated, block: B:263:0x07dc  */
    /* JADX WARN: Code duplicated, block: B:266:0x07e4  */
    /* JADX WARN: Code duplicated, block: B:285:0x083e  */
    /* JADX WARN: Code duplicated, block: B:288:0x0843  */
    /* JADX WARN: Code duplicated, block: B:289:0x0845  */
    /* JADX WARN: Code duplicated, block: B:292:0x0850  */
    /* JADX WARN: Code duplicated, block: B:293:0x0853  */
    /* JADX WARN: Code duplicated, block: B:296:0x085a  */
    /* JADX WARN: Code duplicated, block: B:297:0x085f  */
    /* JADX WARN: Code duplicated, block: B:300:0x0866  */
    /* JADX WARN: Code duplicated, block: B:303:0x08ce A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:304:0x08cf  */
    /* JADX WARN: Code duplicated, block: B:307:0x099e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:308:0x099f  */
    /* JADX WARN: Code duplicated, block: B:325:0x0575 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:333:0x041e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:344:0x07c7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:345:0x07cf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:350:0x03bb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:354:0x0367 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:355:0x036b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:356:0x02e1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x0278 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:38:0x027b  */
    /* JADX WARN: Code duplicated, block: B:40:0x0287  */
    /* JADX WARN: Code duplicated, block: B:45:0x0296  */
    /* JADX WARN: Code duplicated, block: B:47:0x029c  */
    /* JADX WARN: Code duplicated, block: B:48:0x02a1  */
    /* JADX WARN: Code duplicated, block: B:50:0x02a5  */
    /* JADX WARN: Code duplicated, block: B:52:0x02ab  */
    /* JADX WARN: Code duplicated, block: B:53:0x02b0  */
    /* JADX WARN: Code duplicated, block: B:55:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:57:0x02ba  */
    /* JADX WARN: Code duplicated, block: B:60:0x02c7  */
    /* JADX WARN: Code duplicated, block: B:67:0x02e7  */
    /* JADX WARN: Code duplicated, block: B:68:0x02ec  */
    /* JADX WARN: Code duplicated, block: B:71:0x02f5  */
    /* JADX WARN: Code duplicated, block: B:72:0x02fc  */
    /* JADX WARN: Code duplicated, block: B:75:0x0307  */
    /* JADX WARN: Code duplicated, block: B:78:0x0325  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:81:0x0332  */
    /* JADX WARN: Code duplicated, block: B:83:0x0336  */
    /* JADX WARN: Code duplicated, block: B:85:0x033c  */
    /* JADX WARN: Code duplicated, block: B:88:0x0349  */
    /* JADX WARN: Code duplicated, block: B:91:0x0362 A[LOOP:6: B:86:0x0343->B:91:0x0362, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:95:0x036f  */
    /* JADX WARN: Code duplicated, block: B:96:0x0374  */
    /* JADX WARN: Code duplicated, block: B:99:0x037f  */
    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) {
        C00031 c00031;
        String poster;
        String animeId;
        Object obj;
        Object safe;
        AnimeDetail detail;
        Integer num;
        String strPreferredTitle;
        String title;
        CoverImage coverImage;
        CoverImage coverImage2;
        String url2;
        CoverImage coverImage3;
        Iterable $this$firstOrNull$iv;
        Iterator it;
        Object element$iv;
        Artwork artwork;
        String poster2;
        String description;
        String strStripHtml;
        String description2;
        String status;
        ShowStatus status2;
        TvType tvType;
        Integer anilistId;
        Integer malId;
        String it2;
        Iterable artworks;
        Iterable $this$firstOrNull$iv2;
        Iterator it3;
        Object element$iv2;
        Artwork artwork2;
        Iterable $this$firstOrNull$iv3;
        String banner;
        Iterable studios;
        Object obj2;
        List list;
        List studioNames;
        TvType tvType2;
        Object obj3;
        String poster3;
        String url3;
        AnimeDetail detail2;
        String description3;
        String title2;
        ShowStatus status3;
        Integer anilistId2;
        Integer malId2;
        List studioNames2;
        C00031 c00032;
        Integer anilistId3;
        Object obj4;
        AnimeDetail detail3;
        String animeId2;
        String banner2;
        String description4;
        ShowStatus status4;
        Integer malId3;
        String poster4;
        AnimeDetail detail4;
        AniZipResponse aniZipResponse;
        TvType tvType3;
        Iterable $this$filter$iv;
        int $i$f$filter;
        Collection destination$iv$iv;
        Iterable $this$mapNotNull$iv;
        Collection destination$iv$iv2;
        String name;
        Object obj5;
        Object obj6;
        String poster5;
        List studioNames3;
        String title3;
        String banner3;
        Integer malId4;
        String url4;
        AnimeDetail detail5;
        String animeId3;
        AniZipResponse anizip;
        Integer anilistId4;
        String banner4;
        Integer malId5;
        Integer anilistId5;
        TvType tvType4;
        ShowStatus status5;
        String description5;
        C00031 c00033;
        Integer malId6;
        Object obj7;
        Object obj8;
        AnimeDetail detail6;
        String animeId4;
        AnimeDetail detail7;
        String poster6;
        Object safe2;
        Object obj9;
        String banner5;
        String animeId5;
        Object url5;
        Object obj10;
        Object url6;
        Object obj11;
        Object obj12;
        Object obj13;
        Iterable artworks2;
        AniZipResponse anizip2;
        String poster7;
        Object url7;
        Iterable images;
        Object element$iv3;
        Object obj14;
        Integer effectiveAnilistId;
        Integer subbed;
        int iIntValue;
        String url8;
        Object obj15;
        List studioNames4;
        Object obj16;
        Integer malId7;
        Integer anilistId6;
        Integer malId8;
        C00031 c00034;
        AniZipResponse anizip3;
        Object obj17;
        String finalPoster;
        Object objFetchAllEpisodes;
        String str;
        String animeId6;
        Integer effectiveAnilistId2;
        Object obj18;
        AnimeDetail detail8;
        String banner6;
        String description6;
        Object obj19;
        Object obj20;
        String str2;
        String url9;
        Integer anilistId7;
        Integer malId9;
        ShowStatus status6;
        List studioNames5;
        String poster8;
        String str3;
        String title4;
        AniZipMappings mappings;
        Iterable $this$firstOrNull$iv4;
        Iterator it4;
        Object element$iv4;
        Artwork artwork3;
        Artwork it5;
        Iterable $this$firstOrNull$iv5;
        boolean z;
        List<AniZipImage> images2;
        Object obj21;
        List<AniZipImage> images3;
        Object next;
        Object safe3;
        Object obj22;
        Object objNewAnimeLoadResponse$default;
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
        C00031 c00035 = c00031;
        Object $result = c00035.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00035.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                poster = StringsKt.substringAfterLast$default(url, "/anime/", (String) null, 2, (Object) null);
                Requests app = MainActivityKt.getApp();
                String str4 = this.apiUrl + "/anime/" + poster;
                c00035.L$0 = url;
                c00035.L$1 = poster;
                c00035.label = 1;
                Object obj23 = Requests.get$default(app, str4, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00035, 4094, (Object) null);
                c00035 = c00035;
                if (obj23 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                animeId = url;
                obj = obj23;
                NiceResponse this_$iv = (NiceResponse) obj;
                try {
                    ResponseParser parser = this_$iv.getParser();
                    Intrinsics.checkNotNull(parser);
                    safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(AnimeDetail.class));
                } catch (Exception e$iv) {
                    e$iv.printStackTrace();
                    safe = null;
                }
                detail = (AnimeDetail) safe;
                if (detail == null) {
                    return null;
                }
                num = null;
                strPreferredTitle = preferredTitle(detail.getTitle());
                if (strPreferredTitle == null) {
                    strPreferredTitle = "Unknown";
                }
                title = strPreferredTitle;
                coverImage = detail.getCoverImage();
                if (coverImage != null || (url2 = coverImage.getExtraLarge()) == null) {
                    coverImage2 = detail.getCoverImage();
                    if (coverImage2 != null) {
                        url2 = coverImage2.getLarge();
                    } else {
                        url2 = null;
                    }
                    if (url2 == null) {
                        coverImage3 = detail.getCoverImage();
                        if (coverImage3 != null) {
                            url2 = coverImage3.getMedium();
                        } else {
                            url2 = null;
                        }
                        if (url2 == null) {
                            $this$firstOrNull$iv = detail.getArtworks();
                            if ($this$firstOrNull$iv != null) {
                                it = $this$firstOrNull$iv.iterator();
                                do {
                                    if (it.hasNext()) {
                                        element$iv = it.next();
                                    } else {
                                        element$iv = null;
                                    }
                                    artwork = (Artwork) element$iv;
                                    if (artwork != null) {
                                        url2 = artwork.getUrl();
                                    } else {
                                        url2 = null;
                                    }
                                } while (!StringsKt.equals(((Artwork) element$iv).getImageType(), "poster", true));
                                artwork = (Artwork) element$iv;
                                if (artwork != null) {
                                    url2 = artwork.getUrl();
                                } else {
                                    url2 = null;
                                }
                            } else {
                                url2 = null;
                            }
                        }
                    }
                }
                poster2 = url2;
                description = detail.getDescription();
                if (description != null) {
                    strStripHtml = INSTANCE.stripHtml(description);
                } else {
                    strStripHtml = null;
                }
                description2 = strStripHtml;
                Companion companion = INSTANCE;
                status = detail.getStatus();
                if (status == null) {
                    status = "";
                }
                status2 = companion.getStatus(status);
                tvType = INSTANCE.getTvType(detail.getFormat());
                anilistId = detail.getAnilistId();
                malId = detail.getMalId();
                it2 = detail.getBannerImage();
                if (it2 == null) {
                    artworks = detail.getArtworks();
                    if (artworks != null) {
                        $this$firstOrNull$iv2 = artworks;
                        it3 = $this$firstOrNull$iv2.iterator();
                        while (true) {
                            if (it3.hasNext()) {
                                element$iv2 = it3.next();
                                $this$firstOrNull$iv3 = $this$firstOrNull$iv2;
                                if (Intrinsics.areEqual(((Artwork) element$iv2).getImageType(), "banner")) {
                                    $this$firstOrNull$iv2 = $this$firstOrNull$iv3;
                                }
                            } else {
                                element$iv2 = null;
                            }
                        }
                        artwork2 = (Artwork) element$iv2;
                        if (artwork2 != null) {
                            it2 = artwork2.getUrl();
                        } else {
                            it2 = null;
                        }
                    } else {
                        it2 = null;
                    }
                } else {
                    if (StringsKt.isBlank(it2)) {
                        it2 = null;
                    }
                    if (it2 == null) {
                        artworks = detail.getArtworks();
                        if (artworks != null) {
                            $this$firstOrNull$iv2 = artworks;
                            it3 = $this$firstOrNull$iv2.iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    element$iv2 = it3.next();
                                    $this$firstOrNull$iv3 = $this$firstOrNull$iv2;
                                    if (Intrinsics.areEqual(((Artwork) element$iv2).getImageType(), "banner")) {
                                        $this$firstOrNull$iv2 = $this$firstOrNull$iv3;
                                    }
                                } else {
                                    element$iv2 = null;
                                }
                            }
                            artwork2 = (Artwork) element$iv2;
                            if (artwork2 != null) {
                                it2 = artwork2.getUrl();
                            } else {
                                it2 = null;
                            }
                        } else {
                            it2 = null;
                        }
                    }
                }
                banner = it2;
                studios = detail.getStudios();
                if (studios != null) {
                    $this$filter$iv = studios;
                    $i$f$filter = 0;
                    destination$iv$iv = new ArrayList();
                    for (Object element$iv$iv : $this$filter$iv) {
                        Iterable $this$filter$iv2 = $this$filter$iv;
                        int $i$f$filter2 = $i$f$filter;
                        Object obj24 = coroutine_suspended;
                        if (Intrinsics.areEqual(((Studio) element$iv$iv).isMain(), Boxing.boxBoolean(true))) {
                            destination$iv$iv.add(element$iv$iv);
                        }
                        $this$filter$iv = $this$filter$iv2;
                        $i$f$filter = $i$f$filter2;
                        coroutine_suspended = obj24;
                    }
                    obj2 = coroutine_suspended;
                    $this$mapNotNull$iv = (List) destination$iv$iv;
                    destination$iv$iv2 = new ArrayList();
                    for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                        name = ((Studio) element$iv$iv$iv).getName();
                        if (name != null) {
                            destination$iv$iv2.add(name);
                        }
                        $this$mapNotNull$iv = $this$mapNotNull$iv;
                    }
                    list = (List) destination$iv$iv2;
                } else {
                    obj2 = coroutine_suspended;
                    list = null;
                }
                studioNames = list;
                if (anilistId != null) {
                    try {
                        Result.Companion companion2 = Result.Companion;
                        Reanime $this$load_u24lambda_u245 = this;
                        url = MainActivityKt.getApp();
                        String str5 = $this$load_u24lambda_u245.aniZipApi + "?anilist_id=" + anilistId.intValue();
                        c00035.L$0 = animeId;
                        c00035.L$1 = poster;
                        c00035.L$2 = detail;
                        c00035.L$3 = title;
                        c00035.L$4 = poster2;
                        c00035.L$5 = description2;
                        c00035.L$6 = status2;
                        c00035.L$7 = tvType;
                        c00035.L$8 = anilistId;
                        c00035.L$9 = malId;
                        c00035.L$10 = banner;
                        c00035.L$11 = studioNames;
                        c00035.L$12 = SpillingKt.nullOutSpilledVariable($this$load_u24lambda_u245);
                        c00035.label = 2;
                        c00032 = c00035;
                        tvType2 = tvType;
                        anilistId3 = anilistId;
                        try {
                            obj4 = Requests.get$default(url, str5, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00032, 4094, (Object) null);
                            c00035 = c00032;
                            obj3 = obj2;
                            if (obj4 == obj3) {
                                return obj3;
                            }
                            poster3 = poster2;
                            url3 = animeId;
                            detail3 = detail;
                            description3 = description2;
                            animeId2 = poster;
                            title2 = title;
                            banner2 = banner;
                            status3 = status2;
                            malId2 = malId;
                            studioNames2 = studioNames;
                            try {
                                NiceResponse this_$iv2 = (NiceResponse) obj4;
                                try {
                                    try {
                                        ResponseParser parser2 = this_$iv2.getParser();
                                        Intrinsics.checkNotNull(parser2);
                                        url = url3;
                                        try {
                                            safe2 = parser2.parseSafe(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(AniZipResponse.class));
                                        } catch (Exception e) {
                                            e$iv = e;
                                            e$iv.printStackTrace();
                                            safe2 = num;
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        url3 = url;
                                        banner = banner2;
                                        detail2 = detail3;
                                        poster = animeId2;
                                        anilistId2 = anilistId3;
                                        Result.Companion companion3 = Result.Companion;
                                        detail3 = detail2;
                                        animeId2 = poster;
                                        banner2 = banner;
                                        anilistId3 = anilistId2;
                                        obj5 = Result.constructor-impl(ResultKt.createFailure(th));
                                    }
                                } catch (Exception e2) {
                                    e$iv = e2;
                                    url = url3;
                                }
                                url3 = url;
                                obj5 = Result.constructor-impl((AniZipResponse) safe2);
                            } catch (Throwable th2) {
                                th = th2;
                                banner = banner2;
                                detail2 = detail3;
                                poster = animeId2;
                                anilistId2 = anilistId3;
                            }
                            if (Result.isFailure-impl(obj5)) {
                                obj5 = num;
                            }
                            aniZipResponse = (AniZipResponse) obj5;
                            banner = banner2;
                            malId3 = malId2;
                            poster4 = poster3;
                            title = title2;
                            detail4 = detail3;
                            poster = animeId2;
                            status4 = status3;
                            description4 = description3;
                            tvType3 = tvType2;
                            anilistId = anilistId3;
                        } catch (Throwable th3) {
                            th = th3;
                            c00035 = c00032;
                            obj3 = obj2;
                            poster3 = poster2;
                            url3 = animeId;
                            detail2 = detail;
                            description3 = description2;
                            title2 = title;
                            status3 = status2;
                            anilistId2 = anilistId3;
                            malId2 = malId;
                            studioNames2 = studioNames;
                            Result.Companion companion4 = Result.Companion;
                            detail3 = detail2;
                            animeId2 = poster;
                            banner2 = banner;
                            anilistId3 = anilistId2;
                            obj5 = Result.constructor-impl(ResultKt.createFailure(th));
                            if (Result.isFailure-impl(obj5)) {
                                obj5 = num;
                            }
                            aniZipResponse = (AniZipResponse) obj5;
                            banner = banner2;
                            malId3 = malId2;
                            poster4 = poster3;
                            title = title2;
                            detail4 = detail3;
                            poster = animeId2;
                            status4 = status3;
                            description4 = description3;
                            tvType3 = tvType2;
                            anilistId = anilistId3;
                            if (aniZipResponse == null) {
                                if (malId3 != null) {
                                    try {
                                        Result.Companion companion5 = Result.Companion;
                                        Reanime $this$load_u24lambda_u246 = this;
                                        Requests app2 = MainActivityKt.getApp();
                                        obj6 = obj3;
                                        try {
                                            String str6 = $this$load_u24lambda_u246.aniZipApi + "?mal_id=" + malId3.intValue();
                                            c00035.L$0 = url3;
                                            c00035.L$1 = poster;
                                            c00035.L$2 = detail4;
                                            c00035.L$3 = title;
                                            c00035.L$4 = poster4;
                                            c00035.L$5 = description4;
                                            c00035.L$6 = status4;
                                            c00035.L$7 = tvType3;
                                            c00035.L$8 = anilistId;
                                            c00035.L$9 = malId3;
                                            c00035.L$10 = banner;
                                            c00035.L$11 = studioNames2;
                                            c00035.L$12 = SpillingKt.nullOutSpilledVariable($this$load_u24lambda_u246);
                                            c00035.label = 3;
                                            anilistId5 = anilistId;
                                            tvType4 = tvType3;
                                            status5 = status4;
                                            description5 = description4;
                                            c00033 = c00035;
                                            malId6 = malId3;
                                            url3 = url3;
                                            obj7 = obj6;
                                            try {
                                                obj8 = Requests.get$default(app2, str6, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00033, 4094, (Object) null);
                                                c00035 = c00033;
                                                if (obj8 == obj7) {
                                                    return obj7;
                                                }
                                                detail6 = detail4;
                                                animeId4 = poster;
                                                banner4 = banner;
                                                description4 = description5;
                                                status4 = status5;
                                                tvType3 = tvType4;
                                                anilistId = anilistId5;
                                                malId5 = malId6;
                                                detail7 = null;
                                                poster6 = poster4;
                                                try {
                                                    NiceResponse this_$iv3 = (NiceResponse) obj8;
                                                    try {
                                                        ResponseParser parser3 = this_$iv3.getParser();
                                                        Intrinsics.checkNotNull(parser3);
                                                        obj6 = obj7;
                                                        try {
                                                            try {
                                                                try {
                                                                    safe3 = parser3.parseSafe(this_$iv3.getText(), Reflection.getOrCreateKotlinClass(AniZipResponse.class));
                                                                } catch (Exception e3) {
                                                                    e$iv = e3;
                                                                    e$iv.printStackTrace();
                                                                    safe3 = num;
                                                                }
                                                            } catch (Exception e4) {
                                                                e$iv = e4;
                                                                e$iv.printStackTrace();
                                                                safe3 = num;
                                                                poster4 = poster6;
                                                                poster = animeId4;
                                                                obj9 = Result.constructor-impl((AniZipResponse) safe3);
                                                                banner5 = banner4;
                                                                if (Result.isFailure-impl(obj9)) {
                                                                    obj9 = num;
                                                                }
                                                                Integer num2 = malId5;
                                                                poster5 = poster4;
                                                                malId4 = num2;
                                                                studioNames3 = studioNames2;
                                                                animeId3 = poster;
                                                                title3 = title;
                                                                url4 = url3;
                                                                anizip = (AniZipResponse) obj9;
                                                                anilistId4 = anilistId;
                                                                banner3 = banner5;
                                                                detail5 = detail6;
                                                                if (anizip == null) {
                                                                    animeId5 = animeId3;
                                                                    url5 = num;
                                                                } else {
                                                                    animeId5 = animeId3;
                                                                    url5 = num;
                                                                }
                                                                obj10 = url5;
                                                                if (anizip != null) {
                                                                    url6 = num;
                                                                } else {
                                                                    url6 = num;
                                                                }
                                                                obj11 = url6;
                                                                if (poster5 == null) {
                                                                    obj12 = obj10;
                                                                } else {
                                                                    obj12 = poster5;
                                                                }
                                                                if (obj11 != null) {
                                                                    obj13 = obj11;
                                                                } else if (banner3 == null) {
                                                                    obj13 = obj12;
                                                                } else {
                                                                    obj13 = banner3;
                                                                }
                                                                artworks2 = detail5.getArtworks();
                                                                if (artworks2 != null) {
                                                                    $this$firstOrNull$iv4 = artworks2;
                                                                    it4 = $this$firstOrNull$iv4.iterator();
                                                                    while (true) {
                                                                        if (it4.hasNext()) {
                                                                            element$iv4 = it4.next();
                                                                            it5 = (Artwork) element$iv4;
                                                                            anizip2 = anizip;
                                                                            $this$firstOrNull$iv5 = $this$firstOrNull$iv4;
                                                                            poster7 = poster5;
                                                                            if (StringsKt.equals(it5.getImageType(), "clearart", true)) {
                                                                                z = true;
                                                                            } else {
                                                                                z = true;
                                                                            }
                                                                            if (!z) {
                                                                                anizip = anizip2;
                                                                                $this$firstOrNull$iv4 = $this$firstOrNull$iv5;
                                                                                poster5 = poster7;
                                                                            }
                                                                        } else {
                                                                            anizip2 = anizip;
                                                                            poster7 = poster5;
                                                                            element$iv4 = num;
                                                                        }
                                                                    }
                                                                    artwork3 = (Artwork) element$iv4;
                                                                    if (artwork3 != null) {
                                                                    }
                                                                    obj14 = url7;
                                                                    if (anilistId4 == null) {
                                                                        effectiveAnilistId = anilistId4;
                                                                    } else if (anizip2 != null) {
                                                                        effectiveAnilistId = num;
                                                                    } else {
                                                                        effectiveAnilistId = num;
                                                                    }
                                                                    subbed = detail5.getSubbed();
                                                                    if (subbed != null) {
                                                                        iIntValue = subbed.intValue();
                                                                    } else {
                                                                        iIntValue = 0;
                                                                    }
                                                                    Integer dubbed = detail5.getDubbed();
                                                                    int iIntValue2 = dubbed != null ? dubbed.intValue() : 0;
                                                                    c00035.L$0 = url4;
                                                                    url8 = url4;
                                                                    c00035.L$1 = SpillingKt.nullOutSpilledVariable(animeId5);
                                                                    c00035.L$2 = detail5;
                                                                    c00035.L$3 = title3;
                                                                    c00035.L$4 = SpillingKt.nullOutSpilledVariable(poster7);
                                                                    c00035.L$5 = description4;
                                                                    c00035.L$6 = status4;
                                                                    c00035.L$7 = tvType3;
                                                                    c00035.L$8 = anilistId4;
                                                                    c00035.L$9 = malId4;
                                                                    c00035.L$10 = SpillingKt.nullOutSpilledVariable(banner3);
                                                                    c00035.L$11 = studioNames3;
                                                                    c00035.L$12 = SpillingKt.nullOutSpilledVariable(anizip2);
                                                                    c00035.L$13 = SpillingKt.nullOutSpilledVariable(obj10);
                                                                    c00035.L$14 = SpillingKt.nullOutSpilledVariable(obj11);
                                                                    c00035.L$15 = obj12;
                                                                    c00035.L$16 = obj13;
                                                                    c00035.L$17 = obj14;
                                                                    c00035.L$18 = SpillingKt.nullOutSpilledVariable(effectiveAnilistId);
                                                                    c00035.label = 4;
                                                                    int i = iIntValue2;
                                                                    obj15 = obj13;
                                                                    studioNames4 = studioNames3;
                                                                    obj16 = obj12;
                                                                    malId7 = malId4;
                                                                    anilistId6 = anilistId4;
                                                                    int i2 = iIntValue;
                                                                    malId8 = effectiveAnilistId;
                                                                    c00034 = c00035;
                                                                    anizip3 = anizip2;
                                                                    obj17 = obj6;
                                                                    finalPoster = animeId5;
                                                                    objFetchAllEpisodes = fetchAllEpisodes(finalPoster, malId8, i2, i, anizip3, c00034);
                                                                    if (objFetchAllEpisodes == obj17) {
                                                                        return obj17;
                                                                    }
                                                                    str = obj16;
                                                                    animeId6 = finalPoster;
                                                                    effectiveAnilistId2 = malId8;
                                                                    obj18 = objFetchAllEpisodes;
                                                                    detail8 = detail5;
                                                                    banner6 = banner3;
                                                                    description6 = description4;
                                                                    obj19 = obj10;
                                                                    obj20 = obj11;
                                                                    str2 = obj15;
                                                                    url9 = url8;
                                                                    anilistId7 = anilistId6;
                                                                    malId9 = malId7;
                                                                    status6 = status4;
                                                                    studioNames5 = studioNames4;
                                                                    poster8 = poster7;
                                                                    str3 = obj14;
                                                                    title4 = title3;
                                                                    Pair pair = (Pair) obj18;
                                                                    List subEps = (List) pair.component1();
                                                                    List dubEps = (List) pair.component2();
                                                                    C00042 c00042 = new C00042(str, str2, str3, description6, detail8, studioNames5, status6, anilistId7, malId9, subEps, dubEps, null);
                                                                    c00034.L$0 = SpillingKt.nullOutSpilledVariable(url9);
                                                                    c00034.L$1 = SpillingKt.nullOutSpilledVariable(animeId6);
                                                                    c00034.L$2 = SpillingKt.nullOutSpilledVariable(detail8);
                                                                    c00034.L$3 = SpillingKt.nullOutSpilledVariable(title4);
                                                                    c00034.L$4 = SpillingKt.nullOutSpilledVariable(poster8);
                                                                    c00034.L$5 = SpillingKt.nullOutSpilledVariable(description6);
                                                                    c00034.L$6 = SpillingKt.nullOutSpilledVariable(status6);
                                                                    c00034.L$7 = SpillingKt.nullOutSpilledVariable(tvType3);
                                                                    c00034.L$8 = SpillingKt.nullOutSpilledVariable(anilistId7);
                                                                    c00034.L$9 = SpillingKt.nullOutSpilledVariable(malId9);
                                                                    c00034.L$10 = SpillingKt.nullOutSpilledVariable(banner6);
                                                                    c00034.L$11 = SpillingKt.nullOutSpilledVariable(studioNames5);
                                                                    c00034.L$12 = SpillingKt.nullOutSpilledVariable(anizip3);
                                                                    c00034.L$13 = SpillingKt.nullOutSpilledVariable(obj19);
                                                                    c00034.L$14 = SpillingKt.nullOutSpilledVariable(obj20);
                                                                    c00034.L$15 = SpillingKt.nullOutSpilledVariable(str);
                                                                    c00034.L$16 = SpillingKt.nullOutSpilledVariable(str2);
                                                                    c00034.L$17 = SpillingKt.nullOutSpilledVariable(str3);
                                                                    c00034.L$18 = SpillingKt.nullOutSpilledVariable(effectiveAnilistId2);
                                                                    c00034.L$19 = SpillingKt.nullOutSpilledVariable(subEps);
                                                                    c00034.L$20 = SpillingKt.nullOutSpilledVariable(dubEps);
                                                                    c00034.label = 5;
                                                                    obj22 = obj17;
                                                                    objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, title4, url9, tvType3, false, c00042, c00034, 8, (Object) null);
                                                                    if (objNewAnimeLoadResponse$default == obj22) {
                                                                        return obj22;
                                                                    }
                                                                    return objNewAnimeLoadResponse$default;
                                                                }
                                                                anizip2 = anizip;
                                                                poster7 = poster5;
                                                                if (anizip2 != null) {
                                                                    url7 = num;
                                                                } else {
                                                                    url7 = num;
                                                                }
                                                                obj14 = url7;
                                                                if (anilistId4 == null) {
                                                                    effectiveAnilistId = anilistId4;
                                                                } else if (anizip2 != null) {
                                                                    effectiveAnilistId = num;
                                                                } else {
                                                                    effectiveAnilistId = num;
                                                                }
                                                                subbed = detail5.getSubbed();
                                                                if (subbed != null) {
                                                                    iIntValue = subbed.intValue();
                                                                } else {
                                                                    iIntValue = 0;
                                                                }
                                                                Integer dubbed2 = detail5.getDubbed();
                                                                if (dubbed2 != null) {
                                                                }
                                                                c00035.L$0 = url4;
                                                                url8 = url4;
                                                                c00035.L$1 = SpillingKt.nullOutSpilledVariable(animeId5);
                                                                c00035.L$2 = detail5;
                                                                c00035.L$3 = title3;
                                                                c00035.L$4 = SpillingKt.nullOutSpilledVariable(poster7);
                                                                c00035.L$5 = description4;
                                                                c00035.L$6 = status4;
                                                                c00035.L$7 = tvType3;
                                                                c00035.L$8 = anilistId4;
                                                                c00035.L$9 = malId4;
                                                                c00035.L$10 = SpillingKt.nullOutSpilledVariable(banner3);
                                                                c00035.L$11 = studioNames3;
                                                                c00035.L$12 = SpillingKt.nullOutSpilledVariable(anizip2);
                                                                c00035.L$13 = SpillingKt.nullOutSpilledVariable(obj10);
                                                                c00035.L$14 = SpillingKt.nullOutSpilledVariable(obj11);
                                                                c00035.L$15 = obj12;
                                                                c00035.L$16 = obj13;
                                                                c00035.L$17 = obj14;
                                                                c00035.L$18 = SpillingKt.nullOutSpilledVariable(effectiveAnilistId);
                                                                c00035.label = 4;
                                                                int i3 = iIntValue2;
                                                                obj15 = obj13;
                                                                studioNames4 = studioNames3;
                                                                obj16 = obj12;
                                                                malId7 = malId4;
                                                                anilistId6 = anilistId4;
                                                                int i4 = iIntValue;
                                                                malId8 = effectiveAnilistId;
                                                                c00034 = c00035;
                                                                anizip3 = anizip2;
                                                                obj17 = obj6;
                                                                finalPoster = animeId5;
                                                                objFetchAllEpisodes = fetchAllEpisodes(finalPoster, malId8, i4, i3, anizip3, c00034);
                                                                if (objFetchAllEpisodes == obj17) {
                                                                    return obj17;
                                                                }
                                                                str = obj16;
                                                                animeId6 = finalPoster;
                                                                effectiveAnilistId2 = malId8;
                                                                obj18 = objFetchAllEpisodes;
                                                                detail8 = detail5;
                                                                banner6 = banner3;
                                                                description6 = description4;
                                                                obj19 = obj10;
                                                                obj20 = obj11;
                                                                str2 = obj15;
                                                                url9 = url8;
                                                                anilistId7 = anilistId6;
                                                                malId9 = malId7;
                                                                status6 = status4;
                                                                studioNames5 = studioNames4;
                                                                poster8 = poster7;
                                                                str3 = obj14;
                                                                title4 = title3;
                                                                Pair pair2 = (Pair) obj18;
                                                                List subEps2 = (List) pair2.component1();
                                                                List dubEps2 = (List) pair2.component2();
                                                                C00042 c00043 = new C00042(str, str2, str3, description6, detail8, studioNames5, status6, anilistId7, malId9, subEps2, dubEps2, null);
                                                                c00034.L$0 = SpillingKt.nullOutSpilledVariable(url9);
                                                                c00034.L$1 = SpillingKt.nullOutSpilledVariable(animeId6);
                                                                c00034.L$2 = SpillingKt.nullOutSpilledVariable(detail8);
                                                                c00034.L$3 = SpillingKt.nullOutSpilledVariable(title4);
                                                                c00034.L$4 = SpillingKt.nullOutSpilledVariable(poster8);
                                                                c00034.L$5 = SpillingKt.nullOutSpilledVariable(description6);
                                                                c00034.L$6 = SpillingKt.nullOutSpilledVariable(status6);
                                                                c00034.L$7 = SpillingKt.nullOutSpilledVariable(tvType3);
                                                                c00034.L$8 = SpillingKt.nullOutSpilledVariable(anilistId7);
                                                                c00034.L$9 = SpillingKt.nullOutSpilledVariable(malId9);
                                                                c00034.L$10 = SpillingKt.nullOutSpilledVariable(banner6);
                                                                c00034.L$11 = SpillingKt.nullOutSpilledVariable(studioNames5);
                                                                c00034.L$12 = SpillingKt.nullOutSpilledVariable(anizip3);
                                                                c00034.L$13 = SpillingKt.nullOutSpilledVariable(obj19);
                                                                c00034.L$14 = SpillingKt.nullOutSpilledVariable(obj20);
                                                                c00034.L$15 = SpillingKt.nullOutSpilledVariable(str);
                                                                c00034.L$16 = SpillingKt.nullOutSpilledVariable(str2);
                                                                c00034.L$17 = SpillingKt.nullOutSpilledVariable(str3);
                                                                c00034.L$18 = SpillingKt.nullOutSpilledVariable(effectiveAnilistId2);
                                                                c00034.L$19 = SpillingKt.nullOutSpilledVariable(subEps2);
                                                                c00034.L$20 = SpillingKt.nullOutSpilledVariable(dubEps2);
                                                                c00034.label = 5;
                                                                obj22 = obj17;
                                                                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, title4, url9, tvType3, false, c00043, c00034, 8, (Object) null);
                                                                if (objNewAnimeLoadResponse$default == obj22) {
                                                                    return obj22;
                                                                }
                                                                return objNewAnimeLoadResponse$default;
                                                            }
                                                            poster4 = poster6;
                                                            poster = animeId4;
                                                            obj9 = Result.constructor-impl((AniZipResponse) safe3);
                                                            banner5 = banner4;
                                                        } catch (Throwable th4) {
                                                            th = th4;
                                                            poster4 = poster6;
                                                            detail4 = detail6;
                                                            poster = animeId4;
                                                            Result.Companion companion6 = Result.Companion;
                                                            detail6 = detail4;
                                                            obj9 = Result.constructor-impl(ResultKt.createFailure(th));
                                                            banner5 = banner4;
                                                        }
                                                    } catch (Exception e5) {
                                                        e$iv = e5;
                                                        obj6 = obj7;
                                                    }
                                                } catch (Throwable th5) {
                                                    th = th5;
                                                    obj6 = obj7;
                                                }
                                                if (Result.isFailure-impl(obj9)) {
                                                    obj9 = num;
                                                }
                                                Integer num3 = malId5;
                                                poster5 = poster4;
                                                malId4 = num3;
                                                studioNames3 = studioNames2;
                                                animeId3 = poster;
                                                title3 = title;
                                                url4 = url3;
                                                anizip = (AniZipResponse) obj9;
                                                anilistId4 = anilistId;
                                                banner3 = banner5;
                                                detail5 = detail6;
                                            } catch (Throwable th6) {
                                                th = th6;
                                                obj6 = obj7;
                                                c00035 = c00033;
                                                banner4 = banner;
                                                description4 = description5;
                                                status4 = status5;
                                                tvType3 = tvType4;
                                                anilistId = anilistId5;
                                                malId5 = malId6;
                                                Result.Companion companion7 = Result.Companion;
                                                detail6 = detail4;
                                                obj9 = Result.constructor-impl(ResultKt.createFailure(th));
                                                banner5 = banner4;
                                                if (Result.isFailure-impl(obj9)) {
                                                    obj9 = num;
                                                }
                                                Integer num4 = malId5;
                                                poster5 = poster4;
                                                malId4 = num4;
                                                studioNames3 = studioNames2;
                                                animeId3 = poster;
                                                title3 = title;
                                                url4 = url3;
                                                anizip = (AniZipResponse) obj9;
                                                anilistId4 = anilistId;
                                                banner3 = banner5;
                                                detail5 = detail6;
                                                if (anizip == null) {
                                                    animeId5 = animeId3;
                                                    url5 = num;
                                                } else {
                                                    animeId5 = animeId3;
                                                    url5 = num;
                                                }
                                                obj10 = url5;
                                                if (anizip != null) {
                                                    url6 = num;
                                                } else {
                                                    url6 = num;
                                                }
                                                obj11 = url6;
                                                if (poster5 == null) {
                                                    obj12 = obj10;
                                                } else {
                                                    obj12 = poster5;
                                                }
                                                if (obj11 != null) {
                                                    obj13 = obj11;
                                                } else if (banner3 == null) {
                                                    obj13 = obj12;
                                                } else {
                                                    obj13 = banner3;
                                                }
                                                artworks2 = detail5.getArtworks();
                                                if (artworks2 != null) {
                                                    $this$firstOrNull$iv4 = artworks2;
                                                    it4 = $this$firstOrNull$iv4.iterator();
                                                    while (true) {
                                                        if (it4.hasNext()) {
                                                            element$iv4 = it4.next();
                                                            it5 = (Artwork) element$iv4;
                                                            anizip2 = anizip;
                                                            $this$firstOrNull$iv5 = $this$firstOrNull$iv4;
                                                            poster7 = poster5;
                                                            if (StringsKt.equals(it5.getImageType(), "clearart", true)) {
                                                                z = true;
                                                            } else {
                                                                z = true;
                                                            }
                                                            if (!z) {
                                                                anizip = anizip2;
                                                                $this$firstOrNull$iv4 = $this$firstOrNull$iv5;
                                                                poster5 = poster7;
                                                            }
                                                        } else {
                                                            anizip2 = anizip;
                                                            poster7 = poster5;
                                                            element$iv4 = num;
                                                        }
                                                    }
                                                    artwork3 = (Artwork) element$iv4;
                                                    if (artwork3 != null) {
                                                    }
                                                    obj14 = url7;
                                                    if (anilistId4 == null) {
                                                        effectiveAnilistId = anilistId4;
                                                    } else if (anizip2 != null) {
                                                        effectiveAnilistId = num;
                                                    } else {
                                                        effectiveAnilistId = num;
                                                    }
                                                    subbed = detail5.getSubbed();
                                                    if (subbed != null) {
                                                        iIntValue = subbed.intValue();
                                                    } else {
                                                        iIntValue = 0;
                                                    }
                                                    Integer dubbed3 = detail5.getDubbed();
                                                    if (dubbed3 != null) {
                                                    }
                                                    c00035.L$0 = url4;
                                                    url8 = url4;
                                                    c00035.L$1 = SpillingKt.nullOutSpilledVariable(animeId5);
                                                    c00035.L$2 = detail5;
                                                    c00035.L$3 = title3;
                                                    c00035.L$4 = SpillingKt.nullOutSpilledVariable(poster7);
                                                    c00035.L$5 = description4;
                                                    c00035.L$6 = status4;
                                                    c00035.L$7 = tvType3;
                                                    c00035.L$8 = anilistId4;
                                                    c00035.L$9 = malId4;
                                                    c00035.L$10 = SpillingKt.nullOutSpilledVariable(banner3);
                                                    c00035.L$11 = studioNames3;
                                                    c00035.L$12 = SpillingKt.nullOutSpilledVariable(anizip2);
                                                    c00035.L$13 = SpillingKt.nullOutSpilledVariable(obj10);
                                                    c00035.L$14 = SpillingKt.nullOutSpilledVariable(obj11);
                                                    c00035.L$15 = obj12;
                                                    c00035.L$16 = obj13;
                                                    c00035.L$17 = obj14;
                                                    c00035.L$18 = SpillingKt.nullOutSpilledVariable(effectiveAnilistId);
                                                    c00035.label = 4;
                                                    int i5 = iIntValue2;
                                                    obj15 = obj13;
                                                    studioNames4 = studioNames3;
                                                    obj16 = obj12;
                                                    malId7 = malId4;
                                                    anilistId6 = anilistId4;
                                                    int i6 = iIntValue;
                                                    malId8 = effectiveAnilistId;
                                                    c00034 = c00035;
                                                    anizip3 = anizip2;
                                                    obj17 = obj6;
                                                    finalPoster = animeId5;
                                                    objFetchAllEpisodes = fetchAllEpisodes(finalPoster, malId8, i6, i5, anizip3, c00034);
                                                    if (objFetchAllEpisodes == obj17) {
                                                        return obj17;
                                                    }
                                                    str = obj16;
                                                    animeId6 = finalPoster;
                                                    effectiveAnilistId2 = malId8;
                                                    obj18 = objFetchAllEpisodes;
                                                    detail8 = detail5;
                                                    banner6 = banner3;
                                                    description6 = description4;
                                                    obj19 = obj10;
                                                    obj20 = obj11;
                                                    str2 = obj15;
                                                    url9 = url8;
                                                    anilistId7 = anilistId6;
                                                    malId9 = malId7;
                                                    status6 = status4;
                                                    studioNames5 = studioNames4;
                                                    poster8 = poster7;
                                                    str3 = obj14;
                                                    title4 = title3;
                                                    Pair pair3 = (Pair) obj18;
                                                    List subEps3 = (List) pair3.component1();
                                                    List dubEps3 = (List) pair3.component2();
                                                    C00042 c00044 = new C00042(str, str2, str3, description6, detail8, studioNames5, status6, anilistId7, malId9, subEps3, dubEps3, null);
                                                    c00034.L$0 = SpillingKt.nullOutSpilledVariable(url9);
                                                    c00034.L$1 = SpillingKt.nullOutSpilledVariable(animeId6);
                                                    c00034.L$2 = SpillingKt.nullOutSpilledVariable(detail8);
                                                    c00034.L$3 = SpillingKt.nullOutSpilledVariable(title4);
                                                    c00034.L$4 = SpillingKt.nullOutSpilledVariable(poster8);
                                                    c00034.L$5 = SpillingKt.nullOutSpilledVariable(description6);
                                                    c00034.L$6 = SpillingKt.nullOutSpilledVariable(status6);
                                                    c00034.L$7 = SpillingKt.nullOutSpilledVariable(tvType3);
                                                    c00034.L$8 = SpillingKt.nullOutSpilledVariable(anilistId7);
                                                    c00034.L$9 = SpillingKt.nullOutSpilledVariable(malId9);
                                                    c00034.L$10 = SpillingKt.nullOutSpilledVariable(banner6);
                                                    c00034.L$11 = SpillingKt.nullOutSpilledVariable(studioNames5);
                                                    c00034.L$12 = SpillingKt.nullOutSpilledVariable(anizip3);
                                                    c00034.L$13 = SpillingKt.nullOutSpilledVariable(obj19);
                                                    c00034.L$14 = SpillingKt.nullOutSpilledVariable(obj20);
                                                    c00034.L$15 = SpillingKt.nullOutSpilledVariable(str);
                                                    c00034.L$16 = SpillingKt.nullOutSpilledVariable(str2);
                                                    c00034.L$17 = SpillingKt.nullOutSpilledVariable(str3);
                                                    c00034.L$18 = SpillingKt.nullOutSpilledVariable(effectiveAnilistId2);
                                                    c00034.L$19 = SpillingKt.nullOutSpilledVariable(subEps3);
                                                    c00034.L$20 = SpillingKt.nullOutSpilledVariable(dubEps3);
                                                    c00034.label = 5;
                                                    obj22 = obj17;
                                                    objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, title4, url9, tvType3, false, c00044, c00034, 8, (Object) null);
                                                    if (objNewAnimeLoadResponse$default == obj22) {
                                                        return obj22;
                                                    }
                                                    return objNewAnimeLoadResponse$default;
                                                }
                                                anizip2 = anizip;
                                                poster7 = poster5;
                                                if (anizip2 != null) {
                                                    url7 = num;
                                                } else {
                                                    url7 = num;
                                                }
                                                obj14 = url7;
                                                if (anilistId4 == null) {
                                                    effectiveAnilistId = anilistId4;
                                                } else if (anizip2 != null) {
                                                    effectiveAnilistId = num;
                                                } else {
                                                    effectiveAnilistId = num;
                                                }
                                                subbed = detail5.getSubbed();
                                                if (subbed != null) {
                                                    iIntValue = subbed.intValue();
                                                } else {
                                                    iIntValue = 0;
                                                }
                                                Integer dubbed4 = detail5.getDubbed();
                                                if (dubbed4 != null) {
                                                }
                                                c00035.L$0 = url4;
                                                url8 = url4;
                                                c00035.L$1 = SpillingKt.nullOutSpilledVariable(animeId5);
                                                c00035.L$2 = detail5;
                                                c00035.L$3 = title3;
                                                c00035.L$4 = SpillingKt.nullOutSpilledVariable(poster7);
                                                c00035.L$5 = description4;
                                                c00035.L$6 = status4;
                                                c00035.L$7 = tvType3;
                                                c00035.L$8 = anilistId4;
                                                c00035.L$9 = malId4;
                                                c00035.L$10 = SpillingKt.nullOutSpilledVariable(banner3);
                                                c00035.L$11 = studioNames3;
                                                c00035.L$12 = SpillingKt.nullOutSpilledVariable(anizip2);
                                                c00035.L$13 = SpillingKt.nullOutSpilledVariable(obj10);
                                                c00035.L$14 = SpillingKt.nullOutSpilledVariable(obj11);
                                                c00035.L$15 = obj12;
                                                c00035.L$16 = obj13;
                                                c00035.L$17 = obj14;
                                                c00035.L$18 = SpillingKt.nullOutSpilledVariable(effectiveAnilistId);
                                                c00035.label = 4;
                                                int i7 = iIntValue2;
                                                obj15 = obj13;
                                                studioNames4 = studioNames3;
                                                obj16 = obj12;
                                                malId7 = malId4;
                                                anilistId6 = anilistId4;
                                                int i8 = iIntValue;
                                                malId8 = effectiveAnilistId;
                                                c00034 = c00035;
                                                anizip3 = anizip2;
                                                obj17 = obj6;
                                                finalPoster = animeId5;
                                                objFetchAllEpisodes = fetchAllEpisodes(finalPoster, malId8, i8, i7, anizip3, c00034);
                                                if (objFetchAllEpisodes == obj17) {
                                                    return obj17;
                                                }
                                                str = obj16;
                                                animeId6 = finalPoster;
                                                effectiveAnilistId2 = malId8;
                                                obj18 = objFetchAllEpisodes;
                                                detail8 = detail5;
                                                banner6 = banner3;
                                                description6 = description4;
                                                obj19 = obj10;
                                                obj20 = obj11;
                                                str2 = obj15;
                                                url9 = url8;
                                                anilistId7 = anilistId6;
                                                malId9 = malId7;
                                                status6 = status4;
                                                studioNames5 = studioNames4;
                                                poster8 = poster7;
                                                str3 = obj14;
                                                title4 = title3;
                                                Pair pair4 = (Pair) obj18;
                                                List subEps4 = (List) pair4.component1();
                                                List dubEps4 = (List) pair4.component2();
                                                C00042 c00045 = new C00042(str, str2, str3, description6, detail8, studioNames5, status6, anilistId7, malId9, subEps4, dubEps4, null);
                                                c00034.L$0 = SpillingKt.nullOutSpilledVariable(url9);
                                                c00034.L$1 = SpillingKt.nullOutSpilledVariable(animeId6);
                                                c00034.L$2 = SpillingKt.nullOutSpilledVariable(detail8);
                                                c00034.L$3 = SpillingKt.nullOutSpilledVariable(title4);
                                                c00034.L$4 = SpillingKt.nullOutSpilledVariable(poster8);
                                                c00034.L$5 = SpillingKt.nullOutSpilledVariable(description6);
                                                c00034.L$6 = SpillingKt.nullOutSpilledVariable(status6);
                                                c00034.L$7 = SpillingKt.nullOutSpilledVariable(tvType3);
                                                c00034.L$8 = SpillingKt.nullOutSpilledVariable(anilistId7);
                                                c00034.L$9 = SpillingKt.nullOutSpilledVariable(malId9);
                                                c00034.L$10 = SpillingKt.nullOutSpilledVariable(banner6);
                                                c00034.L$11 = SpillingKt.nullOutSpilledVariable(studioNames5);
                                                c00034.L$12 = SpillingKt.nullOutSpilledVariable(anizip3);
                                                c00034.L$13 = SpillingKt.nullOutSpilledVariable(obj19);
                                                c00034.L$14 = SpillingKt.nullOutSpilledVariable(obj20);
                                                c00034.L$15 = SpillingKt.nullOutSpilledVariable(str);
                                                c00034.L$16 = SpillingKt.nullOutSpilledVariable(str2);
                                                c00034.L$17 = SpillingKt.nullOutSpilledVariable(str3);
                                                c00034.L$18 = SpillingKt.nullOutSpilledVariable(effectiveAnilistId2);
                                                c00034.L$19 = SpillingKt.nullOutSpilledVariable(subEps4);
                                                c00034.L$20 = SpillingKt.nullOutSpilledVariable(dubEps4);
                                                c00034.label = 5;
                                                obj22 = obj17;
                                                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, title4, url9, tvType3, false, c00045, c00034, 8, (Object) null);
                                                if (objNewAnimeLoadResponse$default == obj22) {
                                                    return obj22;
                                                }
                                                return objNewAnimeLoadResponse$default;
                                            }
                                        } catch (Throwable th7) {
                                            th = th7;
                                            banner4 = banner;
                                            malId5 = malId3;
                                            Result.Companion companion8 = Result.Companion;
                                            detail6 = detail4;
                                            obj9 = Result.constructor-impl(ResultKt.createFailure(th));
                                            banner5 = banner4;
                                            if (Result.isFailure-impl(obj9)) {
                                                obj9 = num;
                                            }
                                            Integer num5 = malId5;
                                            poster5 = poster4;
                                            malId4 = num5;
                                            studioNames3 = studioNames2;
                                            animeId3 = poster;
                                            title3 = title;
                                            url4 = url3;
                                            anizip = (AniZipResponse) obj9;
                                            anilistId4 = anilistId;
                                            banner3 = banner5;
                                            detail5 = detail6;
                                            if (anizip == null) {
                                                animeId5 = animeId3;
                                                url5 = num;
                                            } else {
                                                animeId5 = animeId3;
                                                url5 = num;
                                            }
                                            obj10 = url5;
                                            if (anizip != null) {
                                                url6 = num;
                                            } else {
                                                url6 = num;
                                            }
                                            obj11 = url6;
                                            if (poster5 == null) {
                                                obj12 = obj10;
                                            } else {
                                                obj12 = poster5;
                                            }
                                            if (obj11 != null) {
                                                obj13 = obj11;
                                            } else if (banner3 == null) {
                                                obj13 = obj12;
                                            } else {
                                                obj13 = banner3;
                                            }
                                            artworks2 = detail5.getArtworks();
                                            if (artworks2 != null) {
                                                $this$firstOrNull$iv4 = artworks2;
                                                it4 = $this$firstOrNull$iv4.iterator();
                                                while (true) {
                                                    if (it4.hasNext()) {
                                                        element$iv4 = it4.next();
                                                        it5 = (Artwork) element$iv4;
                                                        anizip2 = anizip;
                                                        $this$firstOrNull$iv5 = $this$firstOrNull$iv4;
                                                        poster7 = poster5;
                                                        if (StringsKt.equals(it5.getImageType(), "clearart", true)) {
                                                            z = true;
                                                        } else {
                                                            z = true;
                                                        }
                                                        if (!z) {
                                                            anizip = anizip2;
                                                            $this$firstOrNull$iv4 = $this$firstOrNull$iv5;
                                                            poster5 = poster7;
                                                        }
                                                    } else {
                                                        anizip2 = anizip;
                                                        poster7 = poster5;
                                                        element$iv4 = num;
                                                    }
                                                }
                                                artwork3 = (Artwork) element$iv4;
                                                if (artwork3 != null) {
                                                }
                                                obj14 = url7;
                                                if (anilistId4 == null) {
                                                    effectiveAnilistId = anilistId4;
                                                } else if (anizip2 != null) {
                                                    effectiveAnilistId = num;
                                                } else {
                                                    effectiveAnilistId = num;
                                                }
                                                subbed = detail5.getSubbed();
                                                if (subbed != null) {
                                                    iIntValue = subbed.intValue();
                                                } else {
                                                    iIntValue = 0;
                                                }
                                                Integer dubbed5 = detail5.getDubbed();
                                                if (dubbed5 != null) {
                                                }
                                                c00035.L$0 = url4;
                                                url8 = url4;
                                                c00035.L$1 = SpillingKt.nullOutSpilledVariable(animeId5);
                                                c00035.L$2 = detail5;
                                                c00035.L$3 = title3;
                                                c00035.L$4 = SpillingKt.nullOutSpilledVariable(poster7);
                                                c00035.L$5 = description4;
                                                c00035.L$6 = status4;
                                                c00035.L$7 = tvType3;
                                                c00035.L$8 = anilistId4;
                                                c00035.L$9 = malId4;
                                                c00035.L$10 = SpillingKt.nullOutSpilledVariable(banner3);
                                                c00035.L$11 = studioNames3;
                                                c00035.L$12 = SpillingKt.nullOutSpilledVariable(anizip2);
                                                c00035.L$13 = SpillingKt.nullOutSpilledVariable(obj10);
                                                c00035.L$14 = SpillingKt.nullOutSpilledVariable(obj11);
                                                c00035.L$15 = obj12;
                                                c00035.L$16 = obj13;
                                                c00035.L$17 = obj14;
                                                c00035.L$18 = SpillingKt.nullOutSpilledVariable(effectiveAnilistId);
                                                c00035.label = 4;
                                                int i9 = iIntValue2;
                                                obj15 = obj13;
                                                studioNames4 = studioNames3;
                                                obj16 = obj12;
                                                malId7 = malId4;
                                                anilistId6 = anilistId4;
                                                int i10 = iIntValue;
                                                malId8 = effectiveAnilistId;
                                                c00034 = c00035;
                                                anizip3 = anizip2;
                                                obj17 = obj6;
                                                finalPoster = animeId5;
                                                objFetchAllEpisodes = fetchAllEpisodes(finalPoster, malId8, i10, i9, anizip3, c00034);
                                                if (objFetchAllEpisodes == obj17) {
                                                    return obj17;
                                                }
                                                str = obj16;
                                                animeId6 = finalPoster;
                                                effectiveAnilistId2 = malId8;
                                                obj18 = objFetchAllEpisodes;
                                                detail8 = detail5;
                                                banner6 = banner3;
                                                description6 = description4;
                                                obj19 = obj10;
                                                obj20 = obj11;
                                                str2 = obj15;
                                                url9 = url8;
                                                anilistId7 = anilistId6;
                                                malId9 = malId7;
                                                status6 = status4;
                                                studioNames5 = studioNames4;
                                                poster8 = poster7;
                                                str3 = obj14;
                                                title4 = title3;
                                                Pair pair5 = (Pair) obj18;
                                                List subEps5 = (List) pair5.component1();
                                                List dubEps5 = (List) pair5.component2();
                                                C00042 c00046 = new C00042(str, str2, str3, description6, detail8, studioNames5, status6, anilistId7, malId9, subEps5, dubEps5, null);
                                                c00034.L$0 = SpillingKt.nullOutSpilledVariable(url9);
                                                c00034.L$1 = SpillingKt.nullOutSpilledVariable(animeId6);
                                                c00034.L$2 = SpillingKt.nullOutSpilledVariable(detail8);
                                                c00034.L$3 = SpillingKt.nullOutSpilledVariable(title4);
                                                c00034.L$4 = SpillingKt.nullOutSpilledVariable(poster8);
                                                c00034.L$5 = SpillingKt.nullOutSpilledVariable(description6);
                                                c00034.L$6 = SpillingKt.nullOutSpilledVariable(status6);
                                                c00034.L$7 = SpillingKt.nullOutSpilledVariable(tvType3);
                                                c00034.L$8 = SpillingKt.nullOutSpilledVariable(anilistId7);
                                                c00034.L$9 = SpillingKt.nullOutSpilledVariable(malId9);
                                                c00034.L$10 = SpillingKt.nullOutSpilledVariable(banner6);
                                                c00034.L$11 = SpillingKt.nullOutSpilledVariable(studioNames5);
                                                c00034.L$12 = SpillingKt.nullOutSpilledVariable(anizip3);
                                                c00034.L$13 = SpillingKt.nullOutSpilledVariable(obj19);
                                                c00034.L$14 = SpillingKt.nullOutSpilledVariable(obj20);
                                                c00034.L$15 = SpillingKt.nullOutSpilledVariable(str);
                                                c00034.L$16 = SpillingKt.nullOutSpilledVariable(str2);
                                                c00034.L$17 = SpillingKt.nullOutSpilledVariable(str3);
                                                c00034.L$18 = SpillingKt.nullOutSpilledVariable(effectiveAnilistId2);
                                                c00034.L$19 = SpillingKt.nullOutSpilledVariable(subEps5);
                                                c00034.L$20 = SpillingKt.nullOutSpilledVariable(dubEps5);
                                                c00034.label = 5;
                                                obj22 = obj17;
                                                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, title4, url9, tvType3, false, c00046, c00034, 8, (Object) null);
                                                if (objNewAnimeLoadResponse$default == obj22) {
                                                    return obj22;
                                                }
                                                return objNewAnimeLoadResponse$default;
                                            }
                                            anizip2 = anizip;
                                            poster7 = poster5;
                                            if (anizip2 != null) {
                                                url7 = num;
                                            } else {
                                                url7 = num;
                                            }
                                            obj14 = url7;
                                            if (anilistId4 == null) {
                                                effectiveAnilistId = anilistId4;
                                            } else if (anizip2 != null) {
                                                effectiveAnilistId = num;
                                            } else {
                                                effectiveAnilistId = num;
                                            }
                                            subbed = detail5.getSubbed();
                                            if (subbed != null) {
                                                iIntValue = subbed.intValue();
                                            } else {
                                                iIntValue = 0;
                                            }
                                            Integer dubbed6 = detail5.getDubbed();
                                            if (dubbed6 != null) {
                                            }
                                            c00035.L$0 = url4;
                                            url8 = url4;
                                            c00035.L$1 = SpillingKt.nullOutSpilledVariable(animeId5);
                                            c00035.L$2 = detail5;
                                            c00035.L$3 = title3;
                                            c00035.L$4 = SpillingKt.nullOutSpilledVariable(poster7);
                                            c00035.L$5 = description4;
                                            c00035.L$6 = status4;
                                            c00035.L$7 = tvType3;
                                            c00035.L$8 = anilistId4;
                                            c00035.L$9 = malId4;
                                            c00035.L$10 = SpillingKt.nullOutSpilledVariable(banner3);
                                            c00035.L$11 = studioNames3;
                                            c00035.L$12 = SpillingKt.nullOutSpilledVariable(anizip2);
                                            c00035.L$13 = SpillingKt.nullOutSpilledVariable(obj10);
                                            c00035.L$14 = SpillingKt.nullOutSpilledVariable(obj11);
                                            c00035.L$15 = obj12;
                                            c00035.L$16 = obj13;
                                            c00035.L$17 = obj14;
                                            c00035.L$18 = SpillingKt.nullOutSpilledVariable(effectiveAnilistId);
                                            c00035.label = 4;
                                            int i11 = iIntValue2;
                                            obj15 = obj13;
                                            studioNames4 = studioNames3;
                                            obj16 = obj12;
                                            malId7 = malId4;
                                            anilistId6 = anilistId4;
                                            int i12 = iIntValue;
                                            malId8 = effectiveAnilistId;
                                            c00034 = c00035;
                                            anizip3 = anizip2;
                                            obj17 = obj6;
                                            finalPoster = animeId5;
                                            objFetchAllEpisodes = fetchAllEpisodes(finalPoster, malId8, i12, i11, anizip3, c00034);
                                            if (objFetchAllEpisodes == obj17) {
                                                return obj17;
                                            }
                                            str = obj16;
                                            animeId6 = finalPoster;
                                            effectiveAnilistId2 = malId8;
                                            obj18 = objFetchAllEpisodes;
                                            detail8 = detail5;
                                            banner6 = banner3;
                                            description6 = description4;
                                            obj19 = obj10;
                                            obj20 = obj11;
                                            str2 = obj15;
                                            url9 = url8;
                                            anilistId7 = anilistId6;
                                            malId9 = malId7;
                                            status6 = status4;
                                            studioNames5 = studioNames4;
                                            poster8 = poster7;
                                            str3 = obj14;
                                            title4 = title3;
                                            Pair pair6 = (Pair) obj18;
                                            List subEps6 = (List) pair6.component1();
                                            List dubEps6 = (List) pair6.component2();
                                            C00042 c00047 = new C00042(str, str2, str3, description6, detail8, studioNames5, status6, anilistId7, malId9, subEps6, dubEps6, null);
                                            c00034.L$0 = SpillingKt.nullOutSpilledVariable(url9);
                                            c00034.L$1 = SpillingKt.nullOutSpilledVariable(animeId6);
                                            c00034.L$2 = SpillingKt.nullOutSpilledVariable(detail8);
                                            c00034.L$3 = SpillingKt.nullOutSpilledVariable(title4);
                                            c00034.L$4 = SpillingKt.nullOutSpilledVariable(poster8);
                                            c00034.L$5 = SpillingKt.nullOutSpilledVariable(description6);
                                            c00034.L$6 = SpillingKt.nullOutSpilledVariable(status6);
                                            c00034.L$7 = SpillingKt.nullOutSpilledVariable(tvType3);
                                            c00034.L$8 = SpillingKt.nullOutSpilledVariable(anilistId7);
                                            c00034.L$9 = SpillingKt.nullOutSpilledVariable(malId9);
                                            c00034.L$10 = SpillingKt.nullOutSpilledVariable(banner6);
                                            c00034.L$11 = SpillingKt.nullOutSpilledVariable(studioNames5);
                                            c00034.L$12 = SpillingKt.nullOutSpilledVariable(anizip3);
                                            c00034.L$13 = SpillingKt.nullOutSpilledVariable(obj19);
                                            c00034.L$14 = SpillingKt.nullOutSpilledVariable(obj20);
                                            c00034.L$15 = SpillingKt.nullOutSpilledVariable(str);
                                            c00034.L$16 = SpillingKt.nullOutSpilledVariable(str2);
                                            c00034.L$17 = SpillingKt.nullOutSpilledVariable(str3);
                                            c00034.L$18 = SpillingKt.nullOutSpilledVariable(effectiveAnilistId2);
                                            c00034.L$19 = SpillingKt.nullOutSpilledVariable(subEps6);
                                            c00034.L$20 = SpillingKt.nullOutSpilledVariable(dubEps6);
                                            c00034.label = 5;
                                            obj22 = obj17;
                                            objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, title4, url9, tvType3, false, c00047, c00034, 8, (Object) null);
                                            if (objNewAnimeLoadResponse$default == obj22) {
                                                return obj22;
                                            }
                                            return objNewAnimeLoadResponse$default;
                                        }
                                    } catch (Throwable th8) {
                                        th = th8;
                                        obj6 = obj3;
                                    }
                                } else {
                                    String url10 = url3;
                                    Integer malId10 = malId3;
                                    obj6 = obj3;
                                    Integer anilistId8 = anilistId;
                                    poster5 = poster4;
                                    studioNames3 = studioNames2;
                                    title3 = title;
                                    banner3 = banner;
                                    anilistId4 = anilistId8;
                                    malId4 = malId10;
                                    url4 = url10;
                                    detail5 = detail4;
                                    animeId3 = poster;
                                    anizip = num;
                                }
                                break;
                            } else {
                                String url11 = url3;
                                Integer malId11 = malId3;
                                obj6 = obj3;
                                Integer anilistId9 = anilistId;
                                poster5 = poster4;
                                studioNames3 = studioNames2;
                                title3 = title;
                                banner3 = banner;
                                malId4 = malId11;
                                url4 = url11;
                                detail5 = detail4;
                                animeId3 = poster;
                                anizip = aniZipResponse;
                                anilistId4 = anilistId9;
                            }
                            if (anizip == null) {
                                animeId5 = animeId3;
                                url5 = num;
                            } else {
                                animeId5 = animeId3;
                                url5 = num;
                            }
                            obj10 = url5;
                            if (anizip != null) {
                                url6 = num;
                            } else {
                                url6 = num;
                            }
                            obj11 = url6;
                            if (poster5 == null) {
                                obj12 = obj10;
                            } else {
                                obj12 = poster5;
                            }
                            if (obj11 != null) {
                                obj13 = obj11;
                            } else if (banner3 == null) {
                                obj13 = obj12;
                            } else {
                                obj13 = banner3;
                            }
                            artworks2 = detail5.getArtworks();
                            if (artworks2 != null) {
                                $this$firstOrNull$iv4 = artworks2;
                                it4 = $this$firstOrNull$iv4.iterator();
                                while (true) {
                                    if (it4.hasNext()) {
                                        element$iv4 = it4.next();
                                        it5 = (Artwork) element$iv4;
                                        anizip2 = anizip;
                                        $this$firstOrNull$iv5 = $this$firstOrNull$iv4;
                                        poster7 = poster5;
                                        if (StringsKt.equals(it5.getImageType(), "clearart", true)) {
                                            z = true;
                                        } else {
                                            z = true;
                                        }
                                        if (!z) {
                                            anizip = anizip2;
                                            $this$firstOrNull$iv4 = $this$firstOrNull$iv5;
                                            poster5 = poster7;
                                        }
                                    } else {
                                        anizip2 = anizip;
                                        poster7 = poster5;
                                        element$iv4 = num;
                                    }
                                }
                                artwork3 = (Artwork) element$iv4;
                                if (artwork3 != null) {
                                }
                                obj14 = url7;
                                if (anilistId4 == null) {
                                    effectiveAnilistId = anilistId4;
                                } else if (anizip2 != null) {
                                    effectiveAnilistId = num;
                                } else {
                                    effectiveAnilistId = num;
                                }
                                subbed = detail5.getSubbed();
                                if (subbed != null) {
                                    iIntValue = subbed.intValue();
                                } else {
                                    iIntValue = 0;
                                }
                                Integer dubbed7 = detail5.getDubbed();
                                if (dubbed7 != null) {
                                }
                                c00035.L$0 = url4;
                                url8 = url4;
                                c00035.L$1 = SpillingKt.nullOutSpilledVariable(animeId5);
                                c00035.L$2 = detail5;
                                c00035.L$3 = title3;
                                c00035.L$4 = SpillingKt.nullOutSpilledVariable(poster7);
                                c00035.L$5 = description4;
                                c00035.L$6 = status4;
                                c00035.L$7 = tvType3;
                                c00035.L$8 = anilistId4;
                                c00035.L$9 = malId4;
                                c00035.L$10 = SpillingKt.nullOutSpilledVariable(banner3);
                                c00035.L$11 = studioNames3;
                                c00035.L$12 = SpillingKt.nullOutSpilledVariable(anizip2);
                                c00035.L$13 = SpillingKt.nullOutSpilledVariable(obj10);
                                c00035.L$14 = SpillingKt.nullOutSpilledVariable(obj11);
                                c00035.L$15 = obj12;
                                c00035.L$16 = obj13;
                                c00035.L$17 = obj14;
                                c00035.L$18 = SpillingKt.nullOutSpilledVariable(effectiveAnilistId);
                                c00035.label = 4;
                                int i13 = iIntValue2;
                                obj15 = obj13;
                                studioNames4 = studioNames3;
                                obj16 = obj12;
                                malId7 = malId4;
                                anilistId6 = anilistId4;
                                int i14 = iIntValue;
                                malId8 = effectiveAnilistId;
                                c00034 = c00035;
                                anizip3 = anizip2;
                                obj17 = obj6;
                                finalPoster = animeId5;
                                objFetchAllEpisodes = fetchAllEpisodes(finalPoster, malId8, i14, i13, anizip3, c00034);
                                if (objFetchAllEpisodes == obj17) {
                                    return obj17;
                                }
                                str = obj16;
                                animeId6 = finalPoster;
                                effectiveAnilistId2 = malId8;
                                obj18 = objFetchAllEpisodes;
                                detail8 = detail5;
                                banner6 = banner3;
                                description6 = description4;
                                obj19 = obj10;
                                obj20 = obj11;
                                str2 = obj15;
                                url9 = url8;
                                anilistId7 = anilistId6;
                                malId9 = malId7;
                                status6 = status4;
                                studioNames5 = studioNames4;
                                poster8 = poster7;
                                str3 = obj14;
                                title4 = title3;
                                Pair pair7 = (Pair) obj18;
                                List subEps7 = (List) pair7.component1();
                                List dubEps7 = (List) pair7.component2();
                                C00042 c00048 = new C00042(str, str2, str3, description6, detail8, studioNames5, status6, anilistId7, malId9, subEps7, dubEps7, null);
                                c00034.L$0 = SpillingKt.nullOutSpilledVariable(url9);
                                c00034.L$1 = SpillingKt.nullOutSpilledVariable(animeId6);
                                c00034.L$2 = SpillingKt.nullOutSpilledVariable(detail8);
                                c00034.L$3 = SpillingKt.nullOutSpilledVariable(title4);
                                c00034.L$4 = SpillingKt.nullOutSpilledVariable(poster8);
                                c00034.L$5 = SpillingKt.nullOutSpilledVariable(description6);
                                c00034.L$6 = SpillingKt.nullOutSpilledVariable(status6);
                                c00034.L$7 = SpillingKt.nullOutSpilledVariable(tvType3);
                                c00034.L$8 = SpillingKt.nullOutSpilledVariable(anilistId7);
                                c00034.L$9 = SpillingKt.nullOutSpilledVariable(malId9);
                                c00034.L$10 = SpillingKt.nullOutSpilledVariable(banner6);
                                c00034.L$11 = SpillingKt.nullOutSpilledVariable(studioNames5);
                                c00034.L$12 = SpillingKt.nullOutSpilledVariable(anizip3);
                                c00034.L$13 = SpillingKt.nullOutSpilledVariable(obj19);
                                c00034.L$14 = SpillingKt.nullOutSpilledVariable(obj20);
                                c00034.L$15 = SpillingKt.nullOutSpilledVariable(str);
                                c00034.L$16 = SpillingKt.nullOutSpilledVariable(str2);
                                c00034.L$17 = SpillingKt.nullOutSpilledVariable(str3);
                                c00034.L$18 = SpillingKt.nullOutSpilledVariable(effectiveAnilistId2);
                                c00034.L$19 = SpillingKt.nullOutSpilledVariable(subEps7);
                                c00034.L$20 = SpillingKt.nullOutSpilledVariable(dubEps7);
                                c00034.label = 5;
                                obj22 = obj17;
                                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, title4, url9, tvType3, false, c00048, c00034, 8, (Object) null);
                                if (objNewAnimeLoadResponse$default == obj22) {
                                    return obj22;
                                }
                                return objNewAnimeLoadResponse$default;
                            }
                            anizip2 = anizip;
                            poster7 = poster5;
                            if (anizip2 != null) {
                                url7 = num;
                            } else {
                                url7 = num;
                            }
                            obj14 = url7;
                            if (anilistId4 == null) {
                                effectiveAnilistId = anilistId4;
                            } else if (anizip2 != null) {
                                effectiveAnilistId = num;
                            } else {
                                effectiveAnilistId = num;
                            }
                            subbed = detail5.getSubbed();
                            if (subbed != null) {
                                iIntValue = subbed.intValue();
                            } else {
                                iIntValue = 0;
                            }
                            Integer dubbed8 = detail5.getDubbed();
                            if (dubbed8 != null) {
                            }
                            c00035.L$0 = url4;
                            url8 = url4;
                            c00035.L$1 = SpillingKt.nullOutSpilledVariable(animeId5);
                            c00035.L$2 = detail5;
                            c00035.L$3 = title3;
                            c00035.L$4 = SpillingKt.nullOutSpilledVariable(poster7);
                            c00035.L$5 = description4;
                            c00035.L$6 = status4;
                            c00035.L$7 = tvType3;
                            c00035.L$8 = anilistId4;
                            c00035.L$9 = malId4;
                            c00035.L$10 = SpillingKt.nullOutSpilledVariable(banner3);
                            c00035.L$11 = studioNames3;
                            c00035.L$12 = SpillingKt.nullOutSpilledVariable(anizip2);
                            c00035.L$13 = SpillingKt.nullOutSpilledVariable(obj10);
                            c00035.L$14 = SpillingKt.nullOutSpilledVariable(obj11);
                            c00035.L$15 = obj12;
                            c00035.L$16 = obj13;
                            c00035.L$17 = obj14;
                            c00035.L$18 = SpillingKt.nullOutSpilledVariable(effectiveAnilistId);
                            c00035.label = 4;
                            int i15 = iIntValue2;
                            obj15 = obj13;
                            studioNames4 = studioNames3;
                            obj16 = obj12;
                            malId7 = malId4;
                            anilistId6 = anilistId4;
                            int i16 = iIntValue;
                            malId8 = effectiveAnilistId;
                            c00034 = c00035;
                            anizip3 = anizip2;
                            obj17 = obj6;
                            finalPoster = animeId5;
                            objFetchAllEpisodes = fetchAllEpisodes(finalPoster, malId8, i16, i15, anizip3, c00034);
                            if (objFetchAllEpisodes == obj17) {
                                return obj17;
                            }
                            str = obj16;
                            animeId6 = finalPoster;
                            effectiveAnilistId2 = malId8;
                            obj18 = objFetchAllEpisodes;
                            detail8 = detail5;
                            banner6 = banner3;
                            description6 = description4;
                            obj19 = obj10;
                            obj20 = obj11;
                            str2 = obj15;
                            url9 = url8;
                            anilistId7 = anilistId6;
                            malId9 = malId7;
                            status6 = status4;
                            studioNames5 = studioNames4;
                            poster8 = poster7;
                            str3 = obj14;
                            title4 = title3;
                            Pair pair8 = (Pair) obj18;
                            List subEps8 = (List) pair8.component1();
                            List dubEps8 = (List) pair8.component2();
                            C00042 c00049 = new C00042(str, str2, str3, description6, detail8, studioNames5, status6, anilistId7, malId9, subEps8, dubEps8, null);
                            c00034.L$0 = SpillingKt.nullOutSpilledVariable(url9);
                            c00034.L$1 = SpillingKt.nullOutSpilledVariable(animeId6);
                            c00034.L$2 = SpillingKt.nullOutSpilledVariable(detail8);
                            c00034.L$3 = SpillingKt.nullOutSpilledVariable(title4);
                            c00034.L$4 = SpillingKt.nullOutSpilledVariable(poster8);
                            c00034.L$5 = SpillingKt.nullOutSpilledVariable(description6);
                            c00034.L$6 = SpillingKt.nullOutSpilledVariable(status6);
                            c00034.L$7 = SpillingKt.nullOutSpilledVariable(tvType3);
                            c00034.L$8 = SpillingKt.nullOutSpilledVariable(anilistId7);
                            c00034.L$9 = SpillingKt.nullOutSpilledVariable(malId9);
                            c00034.L$10 = SpillingKt.nullOutSpilledVariable(banner6);
                            c00034.L$11 = SpillingKt.nullOutSpilledVariable(studioNames5);
                            c00034.L$12 = SpillingKt.nullOutSpilledVariable(anizip3);
                            c00034.L$13 = SpillingKt.nullOutSpilledVariable(obj19);
                            c00034.L$14 = SpillingKt.nullOutSpilledVariable(obj20);
                            c00034.L$15 = SpillingKt.nullOutSpilledVariable(str);
                            c00034.L$16 = SpillingKt.nullOutSpilledVariable(str2);
                            c00034.L$17 = SpillingKt.nullOutSpilledVariable(str3);
                            c00034.L$18 = SpillingKt.nullOutSpilledVariable(effectiveAnilistId2);
                            c00034.L$19 = SpillingKt.nullOutSpilledVariable(subEps8);
                            c00034.L$20 = SpillingKt.nullOutSpilledVariable(dubEps8);
                            c00034.label = 5;
                            obj22 = obj17;
                            objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, title4, url9, tvType3, false, c00049, c00034, 8, (Object) null);
                            if (objNewAnimeLoadResponse$default == obj22) {
                                return obj22;
                            }
                            return objNewAnimeLoadResponse$default;
                        }
                    } catch (Throwable th9) {
                        th = th9;
                        tvType2 = tvType;
                        obj3 = obj2;
                        poster3 = poster2;
                        url3 = animeId;
                        detail2 = detail;
                        description3 = description2;
                        title2 = title;
                        status3 = status2;
                        anilistId2 = anilistId;
                        malId2 = malId;
                        studioNames2 = studioNames;
                    }
                    break;
                } else {
                    obj3 = obj2;
                    description4 = description2;
                    status4 = status2;
                    malId3 = malId;
                    studioNames2 = studioNames;
                    poster4 = poster2;
                    url3 = animeId;
                    detail4 = detail;
                    aniZipResponse = null;
                    tvType3 = tvType;
                }
                if (aniZipResponse == null) {
                    String url12 = url3;
                    Integer malId12 = malId3;
                    obj6 = obj3;
                    Integer anilistId10 = anilistId;
                    poster5 = poster4;
                    studioNames3 = studioNames2;
                    title3 = title;
                    banner3 = banner;
                    malId4 = malId12;
                    url4 = url12;
                    detail5 = detail4;
                    animeId3 = poster;
                    anizip = aniZipResponse;
                    anilistId4 = anilistId10;
                } else if (malId3 != null) {
                    Result.Companion companion9 = Result.Companion;
                    Reanime $this$load_u24lambda_u247 = this;
                    Requests app3 = MainActivityKt.getApp();
                    obj6 = obj3;
                    String str7 = $this$load_u24lambda_u247.aniZipApi + "?mal_id=" + malId3.intValue();
                    c00035.L$0 = url3;
                    c00035.L$1 = poster;
                    c00035.L$2 = detail4;
                    c00035.L$3 = title;
                    c00035.L$4 = poster4;
                    c00035.L$5 = description4;
                    c00035.L$6 = status4;
                    c00035.L$7 = tvType3;
                    c00035.L$8 = anilistId;
                    c00035.L$9 = malId3;
                    c00035.L$10 = banner;
                    c00035.L$11 = studioNames2;
                    c00035.L$12 = SpillingKt.nullOutSpilledVariable($this$load_u24lambda_u247);
                    c00035.label = 3;
                    anilistId5 = anilistId;
                    tvType4 = tvType3;
                    status5 = status4;
                    description5 = description4;
                    c00033 = c00035;
                    malId6 = malId3;
                    url3 = url3;
                    obj7 = obj6;
                    obj8 = Requests.get$default(app3, str7, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00033, 4094, (Object) null);
                    c00035 = c00033;
                    if (obj8 == obj7) {
                        return obj7;
                    }
                    detail6 = detail4;
                    animeId4 = poster;
                    banner4 = banner;
                    description4 = description5;
                    status4 = status5;
                    tvType3 = tvType4;
                    anilistId = anilistId5;
                    malId5 = malId6;
                    detail7 = null;
                    poster6 = poster4;
                    NiceResponse this_$iv4 = (NiceResponse) obj8;
                    ResponseParser parser4 = this_$iv4.getParser();
                    Intrinsics.checkNotNull(parser4);
                    obj6 = obj7;
                    safe3 = parser4.parseSafe(this_$iv4.getText(), Reflection.getOrCreateKotlinClass(AniZipResponse.class));
                    poster4 = poster6;
                    poster = animeId4;
                    obj9 = Result.constructor-impl((AniZipResponse) safe3);
                    banner5 = banner4;
                    if (Result.isFailure-impl(obj9)) {
                        obj9 = num;
                    }
                    Integer num6 = malId5;
                    poster5 = poster4;
                    malId4 = num6;
                    studioNames3 = studioNames2;
                    animeId3 = poster;
                    title3 = title;
                    url4 = url3;
                    anizip = (AniZipResponse) obj9;
                    anilistId4 = anilistId;
                    banner3 = banner5;
                    detail5 = detail6;
                } else {
                    String url13 = url3;
                    Integer malId13 = malId3;
                    obj6 = obj3;
                    Integer anilistId11 = anilistId;
                    poster5 = poster4;
                    studioNames3 = studioNames2;
                    title3 = title;
                    banner3 = banner;
                    anilistId4 = anilistId11;
                    malId4 = malId13;
                    url4 = url13;
                    detail5 = detail4;
                    animeId3 = poster;
                    anizip = num;
                }
                if (anizip == null && (images3 = anizip.getImages()) != null) {
                    Iterator it6 = images3.iterator();
                    while (true) {
                        if (it6.hasNext()) {
                            next = it6.next();
                            animeId5 = animeId3;
                            String animeId7 = ((AniZipImage) next).getCoverType();
                            Iterator it7 = it6;
                            if (!Intrinsics.areEqual(animeId7, "Poster")) {
                                animeId3 = animeId5;
                                it6 = it7;
                            }
                        } else {
                            animeId5 = animeId3;
                            next = num;
                        }
                    }
                    AniZipImage aniZipImage = (AniZipImage) next;
                    if (aniZipImage != null) {
                        url5 = aniZipImage.getUrl();
                    }
                    obj10 = url5;
                    if (anizip != null || (images2 = anizip.getImages()) == null) {
                        url6 = num;
                    } else {
                        Iterator it8 = images2.iterator();
                        while (true) {
                            if (it8.hasNext()) {
                                Object next2 = it8.next();
                                Iterator it9 = it8;
                                obj21 = next2;
                                if (!Intrinsics.areEqual(((AniZipImage) next2).getCoverType(), "Fanart")) {
                                    it8 = it9;
                                }
                            } else {
                                obj21 = num;
                            }
                        }
                        AniZipImage aniZipImage2 = (AniZipImage) obj21;
                        if (aniZipImage2 != null) {
                            url6 = aniZipImage2.getUrl();
                        } else {
                            url6 = num;
                        }
                    }
                    obj11 = url6;
                    if (poster5 == null) {
                        obj12 = obj10;
                    } else {
                        obj12 = poster5;
                    }
                    if (obj11 != null) {
                        obj13 = obj11;
                    } else if (banner3 == null) {
                        obj13 = obj12;
                    } else {
                        obj13 = banner3;
                    }
                    artworks2 = detail5.getArtworks();
                    if (artworks2 != null) {
                        $this$firstOrNull$iv4 = artworks2;
                        it4 = $this$firstOrNull$iv4.iterator();
                        while (true) {
                            if (it4.hasNext()) {
                                element$iv4 = it4.next();
                                it5 = (Artwork) element$iv4;
                                anizip2 = anizip;
                                $this$firstOrNull$iv5 = $this$firstOrNull$iv4;
                                poster7 = poster5;
                                if (StringsKt.equals(it5.getImageType(), "clearart", true) || StringsKt.equals(it5.getImageType(), "clearlogo", true)) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (!z) {
                                    anizip = anizip2;
                                    $this$firstOrNull$iv4 = $this$firstOrNull$iv5;
                                    poster5 = poster7;
                                }
                            } else {
                                anizip2 = anizip;
                                poster7 = poster5;
                                element$iv4 = num;
                            }
                        }
                        artwork3 = (Artwork) element$iv4;
                        if (artwork3 != null || (url7 = artwork3.getUrl()) == null) {
                        }
                        obj14 = url7;
                        if (anilistId4 == null) {
                            effectiveAnilistId = anilistId4;
                        } else if (anizip2 != null || (mappings = anizip2.getMappings()) == null) {
                            effectiveAnilistId = num;
                        } else {
                            effectiveAnilistId = mappings.getAnilist_id();
                        }
                        subbed = detail5.getSubbed();
                        if (subbed != null) {
                            iIntValue = subbed.intValue();
                        } else {
                            iIntValue = 0;
                        }
                        Integer dubbed9 = detail5.getDubbed();
                        if (dubbed9 != null) {
                        }
                        c00035.L$0 = url4;
                        url8 = url4;
                        c00035.L$1 = SpillingKt.nullOutSpilledVariable(animeId5);
                        c00035.L$2 = detail5;
                        c00035.L$3 = title3;
                        c00035.L$4 = SpillingKt.nullOutSpilledVariable(poster7);
                        c00035.L$5 = description4;
                        c00035.L$6 = status4;
                        c00035.L$7 = tvType3;
                        c00035.L$8 = anilistId4;
                        c00035.L$9 = malId4;
                        c00035.L$10 = SpillingKt.nullOutSpilledVariable(banner3);
                        c00035.L$11 = studioNames3;
                        c00035.L$12 = SpillingKt.nullOutSpilledVariable(anizip2);
                        c00035.L$13 = SpillingKt.nullOutSpilledVariable(obj10);
                        c00035.L$14 = SpillingKt.nullOutSpilledVariable(obj11);
                        c00035.L$15 = obj12;
                        c00035.L$16 = obj13;
                        c00035.L$17 = obj14;
                        c00035.L$18 = SpillingKt.nullOutSpilledVariable(effectiveAnilistId);
                        c00035.label = 4;
                        int i17 = iIntValue2;
                        obj15 = obj13;
                        studioNames4 = studioNames3;
                        obj16 = obj12;
                        malId7 = malId4;
                        anilistId6 = anilistId4;
                        int i18 = iIntValue;
                        malId8 = effectiveAnilistId;
                        c00034 = c00035;
                        anizip3 = anizip2;
                        obj17 = obj6;
                        finalPoster = animeId5;
                        objFetchAllEpisodes = fetchAllEpisodes(finalPoster, malId8, i18, i17, anizip3, c00034);
                        if (objFetchAllEpisodes == obj17) {
                            return obj17;
                        }
                        str = obj16;
                        animeId6 = finalPoster;
                        effectiveAnilistId2 = malId8;
                        obj18 = objFetchAllEpisodes;
                        detail8 = detail5;
                        banner6 = banner3;
                        description6 = description4;
                        obj19 = obj10;
                        obj20 = obj11;
                        str2 = obj15;
                        url9 = url8;
                        anilistId7 = anilistId6;
                        malId9 = malId7;
                        status6 = status4;
                        studioNames5 = studioNames4;
                        poster8 = poster7;
                        str3 = obj14;
                        title4 = title3;
                        Pair pair9 = (Pair) obj18;
                        List subEps9 = (List) pair9.component1();
                        List dubEps9 = (List) pair9.component2();
                        C00042 c000410 = new C00042(str, str2, str3, description6, detail8, studioNames5, status6, anilistId7, malId9, subEps9, dubEps9, null);
                        c00034.L$0 = SpillingKt.nullOutSpilledVariable(url9);
                        c00034.L$1 = SpillingKt.nullOutSpilledVariable(animeId6);
                        c00034.L$2 = SpillingKt.nullOutSpilledVariable(detail8);
                        c00034.L$3 = SpillingKt.nullOutSpilledVariable(title4);
                        c00034.L$4 = SpillingKt.nullOutSpilledVariable(poster8);
                        c00034.L$5 = SpillingKt.nullOutSpilledVariable(description6);
                        c00034.L$6 = SpillingKt.nullOutSpilledVariable(status6);
                        c00034.L$7 = SpillingKt.nullOutSpilledVariable(tvType3);
                        c00034.L$8 = SpillingKt.nullOutSpilledVariable(anilistId7);
                        c00034.L$9 = SpillingKt.nullOutSpilledVariable(malId9);
                        c00034.L$10 = SpillingKt.nullOutSpilledVariable(banner6);
                        c00034.L$11 = SpillingKt.nullOutSpilledVariable(studioNames5);
                        c00034.L$12 = SpillingKt.nullOutSpilledVariable(anizip3);
                        c00034.L$13 = SpillingKt.nullOutSpilledVariable(obj19);
                        c00034.L$14 = SpillingKt.nullOutSpilledVariable(obj20);
                        c00034.L$15 = SpillingKt.nullOutSpilledVariable(str);
                        c00034.L$16 = SpillingKt.nullOutSpilledVariable(str2);
                        c00034.L$17 = SpillingKt.nullOutSpilledVariable(str3);
                        c00034.L$18 = SpillingKt.nullOutSpilledVariable(effectiveAnilistId2);
                        c00034.L$19 = SpillingKt.nullOutSpilledVariable(subEps9);
                        c00034.L$20 = SpillingKt.nullOutSpilledVariable(dubEps9);
                        c00034.label = 5;
                        obj22 = obj17;
                        objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, title4, url9, tvType3, false, c000410, c00034, 8, (Object) null);
                        if (objNewAnimeLoadResponse$default == obj22) {
                            return obj22;
                        }
                        return objNewAnimeLoadResponse$default;
                    }
                    anizip2 = anizip;
                    poster7 = poster5;
                    if (anizip2 != null || (images = anizip2.getImages()) == null) {
                        url7 = num;
                    } else {
                        Iterable $this$firstOrNull$iv6 = images;
                        int $i$f$firstOrNull = 0;
                        Iterator it10 = $this$firstOrNull$iv6.iterator();
                        while (true) {
                            if (it10.hasNext()) {
                                element$iv3 = it10.next();
                                AniZipImage it11 = (AniZipImage) element$iv3;
                                Iterable $this$firstOrNull$iv7 = $this$firstOrNull$iv6;
                                int $i$f$firstOrNull2 = $i$f$firstOrNull;
                                Iterator it12 = it10;
                                if (!(StringsKt.equals(it11.getCoverType(), "Clearlogo", true) || StringsKt.equals(it11.getCoverType(), "Logo", true))) {
                                    $this$firstOrNull$iv6 = $this$firstOrNull$iv7;
                                    $i$f$firstOrNull = $i$f$firstOrNull2;
                                    it10 = it12;
                                }
                            } else {
                                element$iv3 = num;
                            }
                        }
                        AniZipImage aniZipImage3 = (AniZipImage) element$iv3;
                        if (aniZipImage3 != null) {
                            url7 = aniZipImage3.getUrl();
                        } else {
                            url7 = num;
                        }
                    }
                    obj14 = url7;
                    if (anilistId4 == null) {
                        effectiveAnilistId = anilistId4;
                    } else if (anizip2 != null) {
                        effectiveAnilistId = num;
                    } else {
                        effectiveAnilistId = num;
                    }
                    subbed = detail5.getSubbed();
                    if (subbed != null) {
                        iIntValue = subbed.intValue();
                    } else {
                        iIntValue = 0;
                    }
                    Integer dubbed10 = detail5.getDubbed();
                    if (dubbed10 != null) {
                    }
                    c00035.L$0 = url4;
                    url8 = url4;
                    c00035.L$1 = SpillingKt.nullOutSpilledVariable(animeId5);
                    c00035.L$2 = detail5;
                    c00035.L$3 = title3;
                    c00035.L$4 = SpillingKt.nullOutSpilledVariable(poster7);
                    c00035.L$5 = description4;
                    c00035.L$6 = status4;
                    c00035.L$7 = tvType3;
                    c00035.L$8 = anilistId4;
                    c00035.L$9 = malId4;
                    c00035.L$10 = SpillingKt.nullOutSpilledVariable(banner3);
                    c00035.L$11 = studioNames3;
                    c00035.L$12 = SpillingKt.nullOutSpilledVariable(anizip2);
                    c00035.L$13 = SpillingKt.nullOutSpilledVariable(obj10);
                    c00035.L$14 = SpillingKt.nullOutSpilledVariable(obj11);
                    c00035.L$15 = obj12;
                    c00035.L$16 = obj13;
                    c00035.L$17 = obj14;
                    c00035.L$18 = SpillingKt.nullOutSpilledVariable(effectiveAnilistId);
                    c00035.label = 4;
                    int i19 = iIntValue2;
                    obj15 = obj13;
                    studioNames4 = studioNames3;
                    obj16 = obj12;
                    malId7 = malId4;
                    anilistId6 = anilistId4;
                    int i110 = iIntValue;
                    malId8 = effectiveAnilistId;
                    c00034 = c00035;
                    anizip3 = anizip2;
                    obj17 = obj6;
                    finalPoster = animeId5;
                    objFetchAllEpisodes = fetchAllEpisodes(finalPoster, malId8, i110, i19, anizip3, c00034);
                    if (objFetchAllEpisodes == obj17) {
                        return obj17;
                    }
                    str = obj16;
                    animeId6 = finalPoster;
                    effectiveAnilistId2 = malId8;
                    obj18 = objFetchAllEpisodes;
                    detail8 = detail5;
                    banner6 = banner3;
                    description6 = description4;
                    obj19 = obj10;
                    obj20 = obj11;
                    str2 = obj15;
                    url9 = url8;
                    anilistId7 = anilistId6;
                    malId9 = malId7;
                    status6 = status4;
                    studioNames5 = studioNames4;
                    poster8 = poster7;
                    str3 = obj14;
                    title4 = title3;
                    Pair pair10 = (Pair) obj18;
                    List subEps10 = (List) pair10.component1();
                    List dubEps10 = (List) pair10.component2();
                    C00042 c000411 = new C00042(str, str2, str3, description6, detail8, studioNames5, status6, anilistId7, malId9, subEps10, dubEps10, null);
                    c00034.L$0 = SpillingKt.nullOutSpilledVariable(url9);
                    c00034.L$1 = SpillingKt.nullOutSpilledVariable(animeId6);
                    c00034.L$2 = SpillingKt.nullOutSpilledVariable(detail8);
                    c00034.L$3 = SpillingKt.nullOutSpilledVariable(title4);
                    c00034.L$4 = SpillingKt.nullOutSpilledVariable(poster8);
                    c00034.L$5 = SpillingKt.nullOutSpilledVariable(description6);
                    c00034.L$6 = SpillingKt.nullOutSpilledVariable(status6);
                    c00034.L$7 = SpillingKt.nullOutSpilledVariable(tvType3);
                    c00034.L$8 = SpillingKt.nullOutSpilledVariable(anilistId7);
                    c00034.L$9 = SpillingKt.nullOutSpilledVariable(malId9);
                    c00034.L$10 = SpillingKt.nullOutSpilledVariable(banner6);
                    c00034.L$11 = SpillingKt.nullOutSpilledVariable(studioNames5);
                    c00034.L$12 = SpillingKt.nullOutSpilledVariable(anizip3);
                    c00034.L$13 = SpillingKt.nullOutSpilledVariable(obj19);
                    c00034.L$14 = SpillingKt.nullOutSpilledVariable(obj20);
                    c00034.L$15 = SpillingKt.nullOutSpilledVariable(str);
                    c00034.L$16 = SpillingKt.nullOutSpilledVariable(str2);
                    c00034.L$17 = SpillingKt.nullOutSpilledVariable(str3);
                    c00034.L$18 = SpillingKt.nullOutSpilledVariable(effectiveAnilistId2);
                    c00034.L$19 = SpillingKt.nullOutSpilledVariable(subEps10);
                    c00034.L$20 = SpillingKt.nullOutSpilledVariable(dubEps10);
                    c00034.label = 5;
                    obj22 = obj17;
                    objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, title4, url9, tvType3, false, c000411, c00034, 8, (Object) null);
                    if (objNewAnimeLoadResponse$default == obj22) {
                        return obj22;
                    }
                    return objNewAnimeLoadResponse$default;
                }
                animeId5 = animeId3;
                url5 = num;
                obj10 = url5;
                if (anizip != null) {
                    url6 = num;
                } else {
                    url6 = num;
                }
                obj11 = url6;
                if (poster5 == null) {
                    obj12 = obj10;
                } else {
                    obj12 = poster5;
                }
                if (obj11 != null) {
                    obj13 = obj11;
                } else if (banner3 == null) {
                    obj13 = obj12;
                } else {
                    obj13 = banner3;
                }
                artworks2 = detail5.getArtworks();
                if (artworks2 != null) {
                    $this$firstOrNull$iv4 = artworks2;
                    it4 = $this$firstOrNull$iv4.iterator();
                    while (true) {
                        if (it4.hasNext()) {
                            element$iv4 = it4.next();
                            it5 = (Artwork) element$iv4;
                            anizip2 = anizip;
                            $this$firstOrNull$iv5 = $this$firstOrNull$iv4;
                            poster7 = poster5;
                            if (StringsKt.equals(it5.getImageType(), "clearart", true)) {
                                z = true;
                            } else {
                                z = true;
                            }
                            if (!z) {
                                anizip = anizip2;
                                $this$firstOrNull$iv4 = $this$firstOrNull$iv5;
                                poster5 = poster7;
                            }
                        } else {
                            anizip2 = anizip;
                            poster7 = poster5;
                            element$iv4 = num;
                        }
                    }
                    artwork3 = (Artwork) element$iv4;
                    if (artwork3 != null) {
                    }
                    obj14 = url7;
                    if (anilistId4 == null) {
                        effectiveAnilistId = anilistId4;
                    } else if (anizip2 != null) {
                        effectiveAnilistId = num;
                    } else {
                        effectiveAnilistId = num;
                    }
                    subbed = detail5.getSubbed();
                    if (subbed != null) {
                        iIntValue = subbed.intValue();
                    } else {
                        iIntValue = 0;
                    }
                    Integer dubbed11 = detail5.getDubbed();
                    if (dubbed11 != null) {
                    }
                    c00035.L$0 = url4;
                    url8 = url4;
                    c00035.L$1 = SpillingKt.nullOutSpilledVariable(animeId5);
                    c00035.L$2 = detail5;
                    c00035.L$3 = title3;
                    c00035.L$4 = SpillingKt.nullOutSpilledVariable(poster7);
                    c00035.L$5 = description4;
                    c00035.L$6 = status4;
                    c00035.L$7 = tvType3;
                    c00035.L$8 = anilistId4;
                    c00035.L$9 = malId4;
                    c00035.L$10 = SpillingKt.nullOutSpilledVariable(banner3);
                    c00035.L$11 = studioNames3;
                    c00035.L$12 = SpillingKt.nullOutSpilledVariable(anizip2);
                    c00035.L$13 = SpillingKt.nullOutSpilledVariable(obj10);
                    c00035.L$14 = SpillingKt.nullOutSpilledVariable(obj11);
                    c00035.L$15 = obj12;
                    c00035.L$16 = obj13;
                    c00035.L$17 = obj14;
                    c00035.L$18 = SpillingKt.nullOutSpilledVariable(effectiveAnilistId);
                    c00035.label = 4;
                    int i111 = iIntValue2;
                    obj15 = obj13;
                    studioNames4 = studioNames3;
                    obj16 = obj12;
                    malId7 = malId4;
                    anilistId6 = anilistId4;
                    int i112 = iIntValue;
                    malId8 = effectiveAnilistId;
                    c00034 = c00035;
                    anizip3 = anizip2;
                    obj17 = obj6;
                    finalPoster = animeId5;
                    objFetchAllEpisodes = fetchAllEpisodes(finalPoster, malId8, i112, i111, anizip3, c00034);
                    if (objFetchAllEpisodes == obj17) {
                        return obj17;
                    }
                    str = obj16;
                    animeId6 = finalPoster;
                    effectiveAnilistId2 = malId8;
                    obj18 = objFetchAllEpisodes;
                    detail8 = detail5;
                    banner6 = banner3;
                    description6 = description4;
                    obj19 = obj10;
                    obj20 = obj11;
                    str2 = obj15;
                    url9 = url8;
                    anilistId7 = anilistId6;
                    malId9 = malId7;
                    status6 = status4;
                    studioNames5 = studioNames4;
                    poster8 = poster7;
                    str3 = obj14;
                    title4 = title3;
                    Pair pair11 = (Pair) obj18;
                    List subEps11 = (List) pair11.component1();
                    List dubEps11 = (List) pair11.component2();
                    C00042 c000412 = new C00042(str, str2, str3, description6, detail8, studioNames5, status6, anilistId7, malId9, subEps11, dubEps11, null);
                    c00034.L$0 = SpillingKt.nullOutSpilledVariable(url9);
                    c00034.L$1 = SpillingKt.nullOutSpilledVariable(animeId6);
                    c00034.L$2 = SpillingKt.nullOutSpilledVariable(detail8);
                    c00034.L$3 = SpillingKt.nullOutSpilledVariable(title4);
                    c00034.L$4 = SpillingKt.nullOutSpilledVariable(poster8);
                    c00034.L$5 = SpillingKt.nullOutSpilledVariable(description6);
                    c00034.L$6 = SpillingKt.nullOutSpilledVariable(status6);
                    c00034.L$7 = SpillingKt.nullOutSpilledVariable(tvType3);
                    c00034.L$8 = SpillingKt.nullOutSpilledVariable(anilistId7);
                    c00034.L$9 = SpillingKt.nullOutSpilledVariable(malId9);
                    c00034.L$10 = SpillingKt.nullOutSpilledVariable(banner6);
                    c00034.L$11 = SpillingKt.nullOutSpilledVariable(studioNames5);
                    c00034.L$12 = SpillingKt.nullOutSpilledVariable(anizip3);
                    c00034.L$13 = SpillingKt.nullOutSpilledVariable(obj19);
                    c00034.L$14 = SpillingKt.nullOutSpilledVariable(obj20);
                    c00034.L$15 = SpillingKt.nullOutSpilledVariable(str);
                    c00034.L$16 = SpillingKt.nullOutSpilledVariable(str2);
                    c00034.L$17 = SpillingKt.nullOutSpilledVariable(str3);
                    c00034.L$18 = SpillingKt.nullOutSpilledVariable(effectiveAnilistId2);
                    c00034.L$19 = SpillingKt.nullOutSpilledVariable(subEps11);
                    c00034.L$20 = SpillingKt.nullOutSpilledVariable(dubEps11);
                    c00034.label = 5;
                    obj22 = obj17;
                    objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, title4, url9, tvType3, false, c000412, c00034, 8, (Object) null);
                    if (objNewAnimeLoadResponse$default == obj22) {
                        return obj22;
                    }
                    return objNewAnimeLoadResponse$default;
                }
                anizip2 = anizip;
                poster7 = poster5;
                if (anizip2 != null) {
                    url7 = num;
                } else {
                    url7 = num;
                }
                obj14 = url7;
                if (anilistId4 == null) {
                    effectiveAnilistId = anilistId4;
                } else if (anizip2 != null) {
                    effectiveAnilistId = num;
                } else {
                    effectiveAnilistId = num;
                }
                subbed = detail5.getSubbed();
                if (subbed != null) {
                    iIntValue = subbed.intValue();
                } else {
                    iIntValue = 0;
                }
                Integer dubbed12 = detail5.getDubbed();
                if (dubbed12 != null) {
                }
                c00035.L$0 = url4;
                url8 = url4;
                c00035.L$1 = SpillingKt.nullOutSpilledVariable(animeId5);
                c00035.L$2 = detail5;
                c00035.L$3 = title3;
                c00035.L$4 = SpillingKt.nullOutSpilledVariable(poster7);
                c00035.L$5 = description4;
                c00035.L$6 = status4;
                c00035.L$7 = tvType3;
                c00035.L$8 = anilistId4;
                c00035.L$9 = malId4;
                c00035.L$10 = SpillingKt.nullOutSpilledVariable(banner3);
                c00035.L$11 = studioNames3;
                c00035.L$12 = SpillingKt.nullOutSpilledVariable(anizip2);
                c00035.L$13 = SpillingKt.nullOutSpilledVariable(obj10);
                c00035.L$14 = SpillingKt.nullOutSpilledVariable(obj11);
                c00035.L$15 = obj12;
                c00035.L$16 = obj13;
                c00035.L$17 = obj14;
                c00035.L$18 = SpillingKt.nullOutSpilledVariable(effectiveAnilistId);
                c00035.label = 4;
                int i113 = iIntValue2;
                obj15 = obj13;
                studioNames4 = studioNames3;
                obj16 = obj12;
                malId7 = malId4;
                anilistId6 = anilistId4;
                int i114 = iIntValue;
                malId8 = effectiveAnilistId;
                c00034 = c00035;
                anizip3 = anizip2;
                obj17 = obj6;
                finalPoster = animeId5;
                objFetchAllEpisodes = fetchAllEpisodes(finalPoster, malId8, i114, i113, anizip3, c00034);
                if (objFetchAllEpisodes == obj17) {
                    return obj17;
                }
                str = obj16;
                animeId6 = finalPoster;
                effectiveAnilistId2 = malId8;
                obj18 = objFetchAllEpisodes;
                detail8 = detail5;
                banner6 = banner3;
                description6 = description4;
                obj19 = obj10;
                obj20 = obj11;
                str2 = obj15;
                url9 = url8;
                anilistId7 = anilistId6;
                malId9 = malId7;
                status6 = status4;
                studioNames5 = studioNames4;
                poster8 = poster7;
                str3 = obj14;
                title4 = title3;
                Pair pair12 = (Pair) obj18;
                List subEps12 = (List) pair12.component1();
                List dubEps12 = (List) pair12.component2();
                C00042 c000413 = new C00042(str, str2, str3, description6, detail8, studioNames5, status6, anilistId7, malId9, subEps12, dubEps12, null);
                c00034.L$0 = SpillingKt.nullOutSpilledVariable(url9);
                c00034.L$1 = SpillingKt.nullOutSpilledVariable(animeId6);
                c00034.L$2 = SpillingKt.nullOutSpilledVariable(detail8);
                c00034.L$3 = SpillingKt.nullOutSpilledVariable(title4);
                c00034.L$4 = SpillingKt.nullOutSpilledVariable(poster8);
                c00034.L$5 = SpillingKt.nullOutSpilledVariable(description6);
                c00034.L$6 = SpillingKt.nullOutSpilledVariable(status6);
                c00034.L$7 = SpillingKt.nullOutSpilledVariable(tvType3);
                c00034.L$8 = SpillingKt.nullOutSpilledVariable(anilistId7);
                c00034.L$9 = SpillingKt.nullOutSpilledVariable(malId9);
                c00034.L$10 = SpillingKt.nullOutSpilledVariable(banner6);
                c00034.L$11 = SpillingKt.nullOutSpilledVariable(studioNames5);
                c00034.L$12 = SpillingKt.nullOutSpilledVariable(anizip3);
                c00034.L$13 = SpillingKt.nullOutSpilledVariable(obj19);
                c00034.L$14 = SpillingKt.nullOutSpilledVariable(obj20);
                c00034.L$15 = SpillingKt.nullOutSpilledVariable(str);
                c00034.L$16 = SpillingKt.nullOutSpilledVariable(str2);
                c00034.L$17 = SpillingKt.nullOutSpilledVariable(str3);
                c00034.L$18 = SpillingKt.nullOutSpilledVariable(effectiveAnilistId2);
                c00034.L$19 = SpillingKt.nullOutSpilledVariable(subEps12);
                c00034.L$20 = SpillingKt.nullOutSpilledVariable(dubEps12);
                c00034.label = 5;
                obj22 = obj17;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, title4, url9, tvType3, false, c000413, c00034, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == obj22) {
                    return obj22;
                }
                return objNewAnimeLoadResponse$default;
            case 1:
                String animeId8 = (String) c00035.L$1;
                String url14 = (String) c00035.L$0;
                ResultKt.throwOnFailure($result);
                poster = animeId8;
                animeId = url14;
                obj = $result;
                NiceResponse this_$iv5 = (NiceResponse) obj;
                ResponseParser parser5 = this_$iv5.getParser();
                Intrinsics.checkNotNull(parser5);
                safe = parser5.parseSafe(this_$iv5.getText(), Reflection.getOrCreateKotlinClass(AnimeDetail.class));
                detail = (AnimeDetail) safe;
                if (detail == null) {
                    return null;
                }
                num = null;
                strPreferredTitle = preferredTitle(detail.getTitle());
                if (strPreferredTitle == null) {
                    strPreferredTitle = "Unknown";
                }
                title = strPreferredTitle;
                coverImage = detail.getCoverImage();
                if (coverImage != null) {
                    coverImage2 = detail.getCoverImage();
                    if (coverImage2 != null) {
                        url2 = coverImage2.getLarge();
                    } else {
                        url2 = null;
                    }
                    if (url2 == null) {
                        coverImage3 = detail.getCoverImage();
                        if (coverImage3 != null) {
                            url2 = coverImage3.getMedium();
                        } else {
                            url2 = null;
                        }
                        if (url2 == null) {
                            $this$firstOrNull$iv = detail.getArtworks();
                            if ($this$firstOrNull$iv != null) {
                                it = $this$firstOrNull$iv.iterator();
                                do {
                                    if (it.hasNext()) {
                                        element$iv = it.next();
                                    } else {
                                        element$iv = null;
                                    }
                                    artwork = (Artwork) element$iv;
                                    if (artwork != null) {
                                        url2 = artwork.getUrl();
                                    } else {
                                        url2 = null;
                                    }
                                } while (!StringsKt.equals(((Artwork) element$iv).getImageType(), "poster", true));
                                artwork = (Artwork) element$iv;
                                if (artwork != null) {
                                    url2 = artwork.getUrl();
                                } else {
                                    url2 = null;
                                }
                            } else {
                                url2 = null;
                            }
                        }
                    }
                } else {
                    coverImage2 = detail.getCoverImage();
                    if (coverImage2 != null) {
                        url2 = coverImage2.getLarge();
                    } else {
                        url2 = null;
                    }
                    if (url2 == null) {
                        coverImage3 = detail.getCoverImage();
                        if (coverImage3 != null) {
                            url2 = coverImage3.getMedium();
                        } else {
                            url2 = null;
                        }
                        if (url2 == null) {
                            $this$firstOrNull$iv = detail.getArtworks();
                            if ($this$firstOrNull$iv != null) {
                                it = $this$firstOrNull$iv.iterator();
                                do {
                                    if (it.hasNext()) {
                                        element$iv = it.next();
                                    } else {
                                        element$iv = null;
                                    }
                                    artwork = (Artwork) element$iv;
                                    if (artwork != null) {
                                        url2 = artwork.getUrl();
                                    } else {
                                        url2 = null;
                                    }
                                } while (!StringsKt.equals(((Artwork) element$iv).getImageType(), "poster", true));
                                artwork = (Artwork) element$iv;
                                if (artwork != null) {
                                    url2 = artwork.getUrl();
                                } else {
                                    url2 = null;
                                }
                            } else {
                                url2 = null;
                            }
                        }
                    }
                }
                poster2 = url2;
                description = detail.getDescription();
                if (description != null) {
                    strStripHtml = INSTANCE.stripHtml(description);
                } else {
                    strStripHtml = null;
                }
                description2 = strStripHtml;
                Companion companion10 = INSTANCE;
                status = detail.getStatus();
                if (status == null) {
                    status = "";
                }
                status2 = companion10.getStatus(status);
                tvType = INSTANCE.getTvType(detail.getFormat());
                anilistId = detail.getAnilistId();
                malId = detail.getMalId();
                it2 = detail.getBannerImage();
                if (it2 == null) {
                    artworks = detail.getArtworks();
                    if (artworks != null) {
                        $this$firstOrNull$iv2 = artworks;
                        it3 = $this$firstOrNull$iv2.iterator();
                        while (true) {
                            if (it3.hasNext()) {
                                element$iv2 = it3.next();
                                $this$firstOrNull$iv3 = $this$firstOrNull$iv2;
                                if (Intrinsics.areEqual(((Artwork) element$iv2).getImageType(), "banner")) {
                                    $this$firstOrNull$iv2 = $this$firstOrNull$iv3;
                                }
                            } else {
                                element$iv2 = null;
                            }
                        }
                        artwork2 = (Artwork) element$iv2;
                        if (artwork2 != null) {
                            it2 = artwork2.getUrl();
                        } else {
                            it2 = null;
                        }
                    } else {
                        it2 = null;
                    }
                } else {
                    if (StringsKt.isBlank(it2)) {
                        it2 = null;
                    }
                    if (it2 == null) {
                        artworks = detail.getArtworks();
                        if (artworks != null) {
                            $this$firstOrNull$iv2 = artworks;
                            it3 = $this$firstOrNull$iv2.iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    element$iv2 = it3.next();
                                    $this$firstOrNull$iv3 = $this$firstOrNull$iv2;
                                    if (Intrinsics.areEqual(((Artwork) element$iv2).getImageType(), "banner")) {
                                        $this$firstOrNull$iv2 = $this$firstOrNull$iv3;
                                    }
                                } else {
                                    element$iv2 = null;
                                }
                            }
                            artwork2 = (Artwork) element$iv2;
                            if (artwork2 != null) {
                                it2 = artwork2.getUrl();
                            } else {
                                it2 = null;
                            }
                        } else {
                            it2 = null;
                        }
                    }
                }
                banner = it2;
                studios = detail.getStudios();
                if (studios != null) {
                    $this$filter$iv = studios;
                    $i$f$filter = 0;
                    destination$iv$iv = new ArrayList();
                    while (r19.hasNext()) {
                        Iterable $this$filter$iv3 = $this$filter$iv;
                        int $i$f$filter3 = $i$f$filter;
                        Object obj25 = coroutine_suspended;
                        if (Intrinsics.areEqual(((Studio) element$iv$iv).isMain(), Boxing.boxBoolean(true))) {
                            destination$iv$iv.add(element$iv$iv);
                        }
                        $this$filter$iv = $this$filter$iv3;
                        $i$f$filter = $i$f$filter3;
                        coroutine_suspended = obj25;
                    }
                    obj2 = coroutine_suspended;
                    $this$mapNotNull$iv = (List) destination$iv$iv;
                    destination$iv$iv2 = new ArrayList();
                    while (r20.hasNext()) {
                        name = ((Studio) element$iv$iv$iv).getName();
                        if (name != null) {
                            destination$iv$iv2.add(name);
                        }
                        $this$mapNotNull$iv = $this$mapNotNull$iv;
                    }
                    list = (List) destination$iv$iv2;
                } else {
                    obj2 = coroutine_suspended;
                    list = null;
                }
                studioNames = list;
                if (anilistId != null) {
                    Result.Companion companion11 = Result.Companion;
                    Reanime $this$load_u24lambda_u248 = this;
                    url = MainActivityKt.getApp();
                    String str8 = $this$load_u24lambda_u248.aniZipApi + "?anilist_id=" + anilistId.intValue();
                    c00035.L$0 = animeId;
                    c00035.L$1 = poster;
                    c00035.L$2 = detail;
                    c00035.L$3 = title;
                    c00035.L$4 = poster2;
                    c00035.L$5 = description2;
                    c00035.L$6 = status2;
                    c00035.L$7 = tvType;
                    c00035.L$8 = anilistId;
                    c00035.L$9 = malId;
                    c00035.L$10 = banner;
                    c00035.L$11 = studioNames;
                    c00035.L$12 = SpillingKt.nullOutSpilledVariable($this$load_u24lambda_u248);
                    c00035.label = 2;
                    c00032 = c00035;
                    tvType2 = tvType;
                    anilistId3 = anilistId;
                    obj4 = Requests.get$default(url, str8, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00032, 4094, (Object) null);
                    c00035 = c00032;
                    obj3 = obj2;
                    if (obj4 == obj3) {
                        return obj3;
                    }
                    poster3 = poster2;
                    url3 = animeId;
                    detail3 = detail;
                    description3 = description2;
                    animeId2 = poster;
                    title2 = title;
                    banner2 = banner;
                    status3 = status2;
                    malId2 = malId;
                    studioNames2 = studioNames;
                    NiceResponse this_$iv6 = (NiceResponse) obj4;
                    ResponseParser parser6 = this_$iv6.getParser();
                    Intrinsics.checkNotNull(parser6);
                    url = url3;
                    safe2 = parser6.parseSafe(this_$iv6.getText(), Reflection.getOrCreateKotlinClass(AniZipResponse.class));
                    url3 = url;
                    obj5 = Result.constructor-impl((AniZipResponse) safe2);
                    if (Result.isFailure-impl(obj5)) {
                        obj5 = num;
                    }
                    aniZipResponse = (AniZipResponse) obj5;
                    banner = banner2;
                    malId3 = malId2;
                    poster4 = poster3;
                    title = title2;
                    detail4 = detail3;
                    poster = animeId2;
                    status4 = status3;
                    description4 = description3;
                    tvType3 = tvType2;
                    anilistId = anilistId3;
                } else {
                    obj3 = obj2;
                    description4 = description2;
                    status4 = status2;
                    malId3 = malId;
                    studioNames2 = studioNames;
                    poster4 = poster2;
                    url3 = animeId;
                    detail4 = detail;
                    aniZipResponse = null;
                    tvType3 = tvType;
                }
                if (aniZipResponse == null) {
                    String url15 = url3;
                    Integer malId14 = malId3;
                    obj6 = obj3;
                    Integer anilistId12 = anilistId;
                    poster5 = poster4;
                    studioNames3 = studioNames2;
                    title3 = title;
                    banner3 = banner;
                    malId4 = malId14;
                    url4 = url15;
                    detail5 = detail4;
                    animeId3 = poster;
                    anizip = aniZipResponse;
                    anilistId4 = anilistId12;
                } else if (malId3 != null) {
                    Result.Companion companion12 = Result.Companion;
                    Reanime $this$load_u24lambda_u249 = this;
                    Requests app4 = MainActivityKt.getApp();
                    obj6 = obj3;
                    String str9 = $this$load_u24lambda_u249.aniZipApi + "?mal_id=" + malId3.intValue();
                    c00035.L$0 = url3;
                    c00035.L$1 = poster;
                    c00035.L$2 = detail4;
                    c00035.L$3 = title;
                    c00035.L$4 = poster4;
                    c00035.L$5 = description4;
                    c00035.L$6 = status4;
                    c00035.L$7 = tvType3;
                    c00035.L$8 = anilistId;
                    c00035.L$9 = malId3;
                    c00035.L$10 = banner;
                    c00035.L$11 = studioNames2;
                    c00035.L$12 = SpillingKt.nullOutSpilledVariable($this$load_u24lambda_u249);
                    c00035.label = 3;
                    anilistId5 = anilistId;
                    tvType4 = tvType3;
                    status5 = status4;
                    description5 = description4;
                    c00033 = c00035;
                    malId6 = malId3;
                    url3 = url3;
                    obj7 = obj6;
                    obj8 = Requests.get$default(app4, str9, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00033, 4094, (Object) null);
                    c00035 = c00033;
                    if (obj8 == obj7) {
                        return obj7;
                    }
                    detail6 = detail4;
                    animeId4 = poster;
                    banner4 = banner;
                    description4 = description5;
                    status4 = status5;
                    tvType3 = tvType4;
                    anilistId = anilistId5;
                    malId5 = malId6;
                    detail7 = null;
                    poster6 = poster4;
                    NiceResponse this_$iv7 = (NiceResponse) obj8;
                    ResponseParser parser7 = this_$iv7.getParser();
                    Intrinsics.checkNotNull(parser7);
                    obj6 = obj7;
                    safe3 = parser7.parseSafe(this_$iv7.getText(), Reflection.getOrCreateKotlinClass(AniZipResponse.class));
                    poster4 = poster6;
                    poster = animeId4;
                    obj9 = Result.constructor-impl((AniZipResponse) safe3);
                    banner5 = banner4;
                    if (Result.isFailure-impl(obj9)) {
                        obj9 = num;
                    }
                    Integer num7 = malId5;
                    poster5 = poster4;
                    malId4 = num7;
                    studioNames3 = studioNames2;
                    animeId3 = poster;
                    title3 = title;
                    url4 = url3;
                    anizip = (AniZipResponse) obj9;
                    anilistId4 = anilistId;
                    banner3 = banner5;
                    detail5 = detail6;
                } else {
                    String url16 = url3;
                    Integer malId15 = malId3;
                    obj6 = obj3;
                    Integer anilistId13 = anilistId;
                    poster5 = poster4;
                    studioNames3 = studioNames2;
                    title3 = title;
                    banner3 = banner;
                    anilistId4 = anilistId13;
                    malId4 = malId15;
                    url4 = url16;
                    detail5 = detail4;
                    animeId3 = poster;
                    anizip = num;
                }
                if (anizip == null) {
                    animeId5 = animeId3;
                    url5 = num;
                } else {
                    animeId5 = animeId3;
                    url5 = num;
                }
                obj10 = url5;
                if (anizip != null) {
                    url6 = num;
                } else {
                    url6 = num;
                }
                obj11 = url6;
                if (poster5 == null) {
                    obj12 = obj10;
                } else {
                    obj12 = poster5;
                }
                if (obj11 != null) {
                    obj13 = obj11;
                } else if (banner3 == null) {
                    obj13 = obj12;
                } else {
                    obj13 = banner3;
                }
                artworks2 = detail5.getArtworks();
                if (artworks2 != null) {
                    $this$firstOrNull$iv4 = artworks2;
                    it4 = $this$firstOrNull$iv4.iterator();
                    while (true) {
                        if (it4.hasNext()) {
                            element$iv4 = it4.next();
                            it5 = (Artwork) element$iv4;
                            anizip2 = anizip;
                            $this$firstOrNull$iv5 = $this$firstOrNull$iv4;
                            poster7 = poster5;
                            if (StringsKt.equals(it5.getImageType(), "clearart", true)) {
                                z = true;
                            } else {
                                z = true;
                            }
                            if (!z) {
                                anizip = anizip2;
                                $this$firstOrNull$iv4 = $this$firstOrNull$iv5;
                                poster5 = poster7;
                            }
                        } else {
                            anizip2 = anizip;
                            poster7 = poster5;
                            element$iv4 = num;
                        }
                    }
                    artwork3 = (Artwork) element$iv4;
                    if (artwork3 != null) {
                        break;
                    }
                    obj14 = url7;
                    if (anilistId4 == null) {
                        effectiveAnilistId = anilistId4;
                    } else if (anizip2 != null) {
                        effectiveAnilistId = num;
                    } else {
                        effectiveAnilistId = num;
                    }
                    subbed = detail5.getSubbed();
                    if (subbed != null) {
                        iIntValue = subbed.intValue();
                    } else {
                        iIntValue = 0;
                    }
                    Integer dubbed13 = detail5.getDubbed();
                    if (dubbed13 != null) {
                    }
                    c00035.L$0 = url4;
                    url8 = url4;
                    c00035.L$1 = SpillingKt.nullOutSpilledVariable(animeId5);
                    c00035.L$2 = detail5;
                    c00035.L$3 = title3;
                    c00035.L$4 = SpillingKt.nullOutSpilledVariable(poster7);
                    c00035.L$5 = description4;
                    c00035.L$6 = status4;
                    c00035.L$7 = tvType3;
                    c00035.L$8 = anilistId4;
                    c00035.L$9 = malId4;
                    c00035.L$10 = SpillingKt.nullOutSpilledVariable(banner3);
                    c00035.L$11 = studioNames3;
                    c00035.L$12 = SpillingKt.nullOutSpilledVariable(anizip2);
                    c00035.L$13 = SpillingKt.nullOutSpilledVariable(obj10);
                    c00035.L$14 = SpillingKt.nullOutSpilledVariable(obj11);
                    c00035.L$15 = obj12;
                    c00035.L$16 = obj13;
                    c00035.L$17 = obj14;
                    c00035.L$18 = SpillingKt.nullOutSpilledVariable(effectiveAnilistId);
                    c00035.label = 4;
                    int i115 = iIntValue2;
                    obj15 = obj13;
                    studioNames4 = studioNames3;
                    obj16 = obj12;
                    malId7 = malId4;
                    anilistId6 = anilistId4;
                    int i116 = iIntValue;
                    malId8 = effectiveAnilistId;
                    c00034 = c00035;
                    anizip3 = anizip2;
                    obj17 = obj6;
                    finalPoster = animeId5;
                    objFetchAllEpisodes = fetchAllEpisodes(finalPoster, malId8, i116, i115, anizip3, c00034);
                    if (objFetchAllEpisodes == obj17) {
                        return obj17;
                    }
                    str = obj16;
                    animeId6 = finalPoster;
                    effectiveAnilistId2 = malId8;
                    obj18 = objFetchAllEpisodes;
                    detail8 = detail5;
                    banner6 = banner3;
                    description6 = description4;
                    obj19 = obj10;
                    obj20 = obj11;
                    str2 = obj15;
                    url9 = url8;
                    anilistId7 = anilistId6;
                    malId9 = malId7;
                    status6 = status4;
                    studioNames5 = studioNames4;
                    poster8 = poster7;
                    str3 = obj14;
                    title4 = title3;
                    Pair pair13 = (Pair) obj18;
                    List subEps13 = (List) pair13.component1();
                    List dubEps13 = (List) pair13.component2();
                    C00042 c000414 = new C00042(str, str2, str3, description6, detail8, studioNames5, status6, anilistId7, malId9, subEps13, dubEps13, null);
                    c00034.L$0 = SpillingKt.nullOutSpilledVariable(url9);
                    c00034.L$1 = SpillingKt.nullOutSpilledVariable(animeId6);
                    c00034.L$2 = SpillingKt.nullOutSpilledVariable(detail8);
                    c00034.L$3 = SpillingKt.nullOutSpilledVariable(title4);
                    c00034.L$4 = SpillingKt.nullOutSpilledVariable(poster8);
                    c00034.L$5 = SpillingKt.nullOutSpilledVariable(description6);
                    c00034.L$6 = SpillingKt.nullOutSpilledVariable(status6);
                    c00034.L$7 = SpillingKt.nullOutSpilledVariable(tvType3);
                    c00034.L$8 = SpillingKt.nullOutSpilledVariable(anilistId7);
                    c00034.L$9 = SpillingKt.nullOutSpilledVariable(malId9);
                    c00034.L$10 = SpillingKt.nullOutSpilledVariable(banner6);
                    c00034.L$11 = SpillingKt.nullOutSpilledVariable(studioNames5);
                    c00034.L$12 = SpillingKt.nullOutSpilledVariable(anizip3);
                    c00034.L$13 = SpillingKt.nullOutSpilledVariable(obj19);
                    c00034.L$14 = SpillingKt.nullOutSpilledVariable(obj20);
                    c00034.L$15 = SpillingKt.nullOutSpilledVariable(str);
                    c00034.L$16 = SpillingKt.nullOutSpilledVariable(str2);
                    c00034.L$17 = SpillingKt.nullOutSpilledVariable(str3);
                    c00034.L$18 = SpillingKt.nullOutSpilledVariable(effectiveAnilistId2);
                    c00034.L$19 = SpillingKt.nullOutSpilledVariable(subEps13);
                    c00034.L$20 = SpillingKt.nullOutSpilledVariable(dubEps13);
                    c00034.label = 5;
                    obj22 = obj17;
                    objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, title4, url9, tvType3, false, c000414, c00034, 8, (Object) null);
                    if (objNewAnimeLoadResponse$default == obj22) {
                        return obj22;
                    }
                    return objNewAnimeLoadResponse$default;
                }
                anizip2 = anizip;
                poster7 = poster5;
                if (anizip2 != null) {
                    url7 = num;
                } else {
                    url7 = num;
                }
                obj14 = url7;
                if (anilistId4 == null) {
                    effectiveAnilistId = anilistId4;
                } else if (anizip2 != null) {
                    effectiveAnilistId = num;
                } else {
                    effectiveAnilistId = num;
                }
                subbed = detail5.getSubbed();
                if (subbed != null) {
                    iIntValue = subbed.intValue();
                } else {
                    iIntValue = 0;
                }
                Integer dubbed14 = detail5.getDubbed();
                if (dubbed14 != null) {
                }
                c00035.L$0 = url4;
                url8 = url4;
                c00035.L$1 = SpillingKt.nullOutSpilledVariable(animeId5);
                c00035.L$2 = detail5;
                c00035.L$3 = title3;
                c00035.L$4 = SpillingKt.nullOutSpilledVariable(poster7);
                c00035.L$5 = description4;
                c00035.L$6 = status4;
                c00035.L$7 = tvType3;
                c00035.L$8 = anilistId4;
                c00035.L$9 = malId4;
                c00035.L$10 = SpillingKt.nullOutSpilledVariable(banner3);
                c00035.L$11 = studioNames3;
                c00035.L$12 = SpillingKt.nullOutSpilledVariable(anizip2);
                c00035.L$13 = SpillingKt.nullOutSpilledVariable(obj10);
                c00035.L$14 = SpillingKt.nullOutSpilledVariable(obj11);
                c00035.L$15 = obj12;
                c00035.L$16 = obj13;
                c00035.L$17 = obj14;
                c00035.L$18 = SpillingKt.nullOutSpilledVariable(effectiveAnilistId);
                c00035.label = 4;
                int i117 = iIntValue2;
                obj15 = obj13;
                studioNames4 = studioNames3;
                obj16 = obj12;
                malId7 = malId4;
                anilistId6 = anilistId4;
                int i118 = iIntValue;
                malId8 = effectiveAnilistId;
                c00034 = c00035;
                anizip3 = anizip2;
                obj17 = obj6;
                finalPoster = animeId5;
                objFetchAllEpisodes = fetchAllEpisodes(finalPoster, malId8, i118, i117, anizip3, c00034);
                if (objFetchAllEpisodes == obj17) {
                    return obj17;
                }
                str = obj16;
                animeId6 = finalPoster;
                effectiveAnilistId2 = malId8;
                obj18 = objFetchAllEpisodes;
                detail8 = detail5;
                banner6 = banner3;
                description6 = description4;
                obj19 = obj10;
                obj20 = obj11;
                str2 = obj15;
                url9 = url8;
                anilistId7 = anilistId6;
                malId9 = malId7;
                status6 = status4;
                studioNames5 = studioNames4;
                poster8 = poster7;
                str3 = obj14;
                title4 = title3;
                Pair pair14 = (Pair) obj18;
                List subEps14 = (List) pair14.component1();
                List dubEps14 = (List) pair14.component2();
                C00042 c000415 = new C00042(str, str2, str3, description6, detail8, studioNames5, status6, anilistId7, malId9, subEps14, dubEps14, null);
                c00034.L$0 = SpillingKt.nullOutSpilledVariable(url9);
                c00034.L$1 = SpillingKt.nullOutSpilledVariable(animeId6);
                c00034.L$2 = SpillingKt.nullOutSpilledVariable(detail8);
                c00034.L$3 = SpillingKt.nullOutSpilledVariable(title4);
                c00034.L$4 = SpillingKt.nullOutSpilledVariable(poster8);
                c00034.L$5 = SpillingKt.nullOutSpilledVariable(description6);
                c00034.L$6 = SpillingKt.nullOutSpilledVariable(status6);
                c00034.L$7 = SpillingKt.nullOutSpilledVariable(tvType3);
                c00034.L$8 = SpillingKt.nullOutSpilledVariable(anilistId7);
                c00034.L$9 = SpillingKt.nullOutSpilledVariable(malId9);
                c00034.L$10 = SpillingKt.nullOutSpilledVariable(banner6);
                c00034.L$11 = SpillingKt.nullOutSpilledVariable(studioNames5);
                c00034.L$12 = SpillingKt.nullOutSpilledVariable(anizip3);
                c00034.L$13 = SpillingKt.nullOutSpilledVariable(obj19);
                c00034.L$14 = SpillingKt.nullOutSpilledVariable(obj20);
                c00034.L$15 = SpillingKt.nullOutSpilledVariable(str);
                c00034.L$16 = SpillingKt.nullOutSpilledVariable(str2);
                c00034.L$17 = SpillingKt.nullOutSpilledVariable(str3);
                c00034.L$18 = SpillingKt.nullOutSpilledVariable(effectiveAnilistId2);
                c00034.L$19 = SpillingKt.nullOutSpilledVariable(subEps14);
                c00034.L$20 = SpillingKt.nullOutSpilledVariable(dubEps14);
                c00034.label = 5;
                obj22 = obj17;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, title4, url9, tvType3, false, c000415, c00034, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == obj22) {
                    return obj22;
                }
                return objNewAnimeLoadResponse$default;
            case 2:
                studioNames2 = (List) c00035.L$11;
                banner2 = (String) c00035.L$10;
                malId2 = (Integer) c00035.L$9;
                anilistId2 = (Integer) c00035.L$8;
                TvType tvType5 = (TvType) c00035.L$7;
                status3 = (ShowStatus) c00035.L$6;
                description3 = (String) c00035.L$5;
                poster3 = (String) c00035.L$4;
                title2 = (String) c00035.L$3;
                detail3 = (AnimeDetail) c00035.L$2;
                animeId2 = (String) c00035.L$1;
                String url17 = (String) c00035.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    url3 = url17;
                    anilistId3 = anilistId2;
                    tvType2 = tvType5;
                    obj4 = $result;
                    num = null;
                    obj3 = coroutine_suspended;
                    NiceResponse this_$iv8 = (NiceResponse) obj4;
                    ResponseParser parser8 = this_$iv8.getParser();
                    Intrinsics.checkNotNull(parser8);
                    url = url3;
                    safe2 = parser8.parseSafe(this_$iv8.getText(), Reflection.getOrCreateKotlinClass(AniZipResponse.class));
                    url3 = url;
                    obj5 = Result.constructor-impl((AniZipResponse) safe2);
                } catch (Throwable th10) {
                    th = th10;
                    url3 = url17;
                    banner = banner2;
                    tvType2 = tvType5;
                    detail2 = detail3;
                    poster = animeId2;
                    num = null;
                    obj3 = coroutine_suspended;
                    Result.Companion companion13 = Result.Companion;
                    detail3 = detail2;
                    animeId2 = poster;
                    banner2 = banner;
                    anilistId3 = anilistId2;
                    obj5 = Result.constructor-impl(ResultKt.createFailure(th));
                    if (Result.isFailure-impl(obj5)) {
                        obj5 = num;
                    }
                    aniZipResponse = (AniZipResponse) obj5;
                    banner = banner2;
                    malId3 = malId2;
                    poster4 = poster3;
                    title = title2;
                    detail4 = detail3;
                    poster = animeId2;
                    status4 = status3;
                    description4 = description3;
                    tvType3 = tvType2;
                    anilistId = anilistId3;
                    if (aniZipResponse == null) {
                        String url18 = url3;
                        Integer malId16 = malId3;
                        obj6 = obj3;
                        Integer anilistId14 = anilistId;
                        poster5 = poster4;
                        studioNames3 = studioNames2;
                        title3 = title;
                        banner3 = banner;
                        malId4 = malId16;
                        url4 = url18;
                        detail5 = detail4;
                        animeId3 = poster;
                        anizip = aniZipResponse;
                        anilistId4 = anilistId14;
                    } else if (malId3 != null) {
                        Result.Companion companion14 = Result.Companion;
                        Reanime $this$load_u24lambda_u2410 = this;
                        Requests app5 = MainActivityKt.getApp();
                        obj6 = obj3;
                        String str10 = $this$load_u24lambda_u2410.aniZipApi + "?mal_id=" + malId3.intValue();
                        c00035.L$0 = url3;
                        c00035.L$1 = poster;
                        c00035.L$2 = detail4;
                        c00035.L$3 = title;
                        c00035.L$4 = poster4;
                        c00035.L$5 = description4;
                        c00035.L$6 = status4;
                        c00035.L$7 = tvType3;
                        c00035.L$8 = anilistId;
                        c00035.L$9 = malId3;
                        c00035.L$10 = banner;
                        c00035.L$11 = studioNames2;
                        c00035.L$12 = SpillingKt.nullOutSpilledVariable($this$load_u24lambda_u2410);
                        c00035.label = 3;
                        anilistId5 = anilistId;
                        tvType4 = tvType3;
                        status5 = status4;
                        description5 = description4;
                        c00033 = c00035;
                        malId6 = malId3;
                        url3 = url3;
                        obj7 = obj6;
                        obj8 = Requests.get$default(app5, str10, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00033, 4094, (Object) null);
                        c00035 = c00033;
                        if (obj8 == obj7) {
                            return obj7;
                        }
                        detail6 = detail4;
                        animeId4 = poster;
                        banner4 = banner;
                        description4 = description5;
                        status4 = status5;
                        tvType3 = tvType4;
                        anilistId = anilistId5;
                        malId5 = malId6;
                        detail7 = null;
                        poster6 = poster4;
                        NiceResponse this_$iv9 = (NiceResponse) obj8;
                        ResponseParser parser9 = this_$iv9.getParser();
                        Intrinsics.checkNotNull(parser9);
                        obj6 = obj7;
                        safe3 = parser9.parseSafe(this_$iv9.getText(), Reflection.getOrCreateKotlinClass(AniZipResponse.class));
                        poster4 = poster6;
                        poster = animeId4;
                        obj9 = Result.constructor-impl((AniZipResponse) safe3);
                        banner5 = banner4;
                        if (Result.isFailure-impl(obj9)) {
                            obj9 = num;
                        }
                        Integer num8 = malId5;
                        poster5 = poster4;
                        malId4 = num8;
                        studioNames3 = studioNames2;
                        animeId3 = poster;
                        title3 = title;
                        url4 = url3;
                        anizip = (AniZipResponse) obj9;
                        anilistId4 = anilistId;
                        banner3 = banner5;
                        detail5 = detail6;
                    } else {
                        String url19 = url3;
                        Integer malId17 = malId3;
                        obj6 = obj3;
                        Integer anilistId15 = anilistId;
                        poster5 = poster4;
                        studioNames3 = studioNames2;
                        title3 = title;
                        banner3 = banner;
                        anilistId4 = anilistId15;
                        malId4 = malId17;
                        url4 = url19;
                        detail5 = detail4;
                        animeId3 = poster;
                        anizip = num;
                    }
                    if (anizip == null) {
                        animeId5 = animeId3;
                        url5 = num;
                    } else {
                        animeId5 = animeId3;
                        url5 = num;
                    }
                    obj10 = url5;
                    if (anizip != null) {
                        url6 = num;
                    } else {
                        url6 = num;
                    }
                    obj11 = url6;
                    if (poster5 == null) {
                        obj12 = obj10;
                    } else {
                        obj12 = poster5;
                    }
                    if (obj11 != null) {
                        obj13 = obj11;
                    } else if (banner3 == null) {
                        obj13 = obj12;
                    } else {
                        obj13 = banner3;
                    }
                    artworks2 = detail5.getArtworks();
                    if (artworks2 != null) {
                        $this$firstOrNull$iv4 = artworks2;
                        it4 = $this$firstOrNull$iv4.iterator();
                        while (true) {
                            if (it4.hasNext()) {
                                element$iv4 = it4.next();
                                it5 = (Artwork) element$iv4;
                                anizip2 = anizip;
                                $this$firstOrNull$iv5 = $this$firstOrNull$iv4;
                                poster7 = poster5;
                                if (StringsKt.equals(it5.getImageType(), "clearart", true)) {
                                    z = true;
                                } else {
                                    z = true;
                                }
                                if (!z) {
                                    anizip = anizip2;
                                    $this$firstOrNull$iv4 = $this$firstOrNull$iv5;
                                    poster5 = poster7;
                                }
                            } else {
                                anizip2 = anizip;
                                poster7 = poster5;
                                element$iv4 = num;
                            }
                        }
                        artwork3 = (Artwork) element$iv4;
                        if (artwork3 != null) {
                            break;
                        }
                        obj14 = url7;
                        if (anilistId4 == null) {
                            effectiveAnilistId = anilistId4;
                        } else if (anizip2 != null) {
                            effectiveAnilistId = num;
                        } else {
                            effectiveAnilistId = num;
                        }
                        subbed = detail5.getSubbed();
                        if (subbed != null) {
                            iIntValue = subbed.intValue();
                        } else {
                            iIntValue = 0;
                        }
                        Integer dubbed15 = detail5.getDubbed();
                        if (dubbed15 != null) {
                        }
                        c00035.L$0 = url4;
                        url8 = url4;
                        c00035.L$1 = SpillingKt.nullOutSpilledVariable(animeId5);
                        c00035.L$2 = detail5;
                        c00035.L$3 = title3;
                        c00035.L$4 = SpillingKt.nullOutSpilledVariable(poster7);
                        c00035.L$5 = description4;
                        c00035.L$6 = status4;
                        c00035.L$7 = tvType3;
                        c00035.L$8 = anilistId4;
                        c00035.L$9 = malId4;
                        c00035.L$10 = SpillingKt.nullOutSpilledVariable(banner3);
                        c00035.L$11 = studioNames3;
                        c00035.L$12 = SpillingKt.nullOutSpilledVariable(anizip2);
                        c00035.L$13 = SpillingKt.nullOutSpilledVariable(obj10);
                        c00035.L$14 = SpillingKt.nullOutSpilledVariable(obj11);
                        c00035.L$15 = obj12;
                        c00035.L$16 = obj13;
                        c00035.L$17 = obj14;
                        c00035.L$18 = SpillingKt.nullOutSpilledVariable(effectiveAnilistId);
                        c00035.label = 4;
                        int i119 = iIntValue2;
                        obj15 = obj13;
                        studioNames4 = studioNames3;
                        obj16 = obj12;
                        malId7 = malId4;
                        anilistId6 = anilistId4;
                        int i1110 = iIntValue;
                        malId8 = effectiveAnilistId;
                        c00034 = c00035;
                        anizip3 = anizip2;
                        obj17 = obj6;
                        finalPoster = animeId5;
                        objFetchAllEpisodes = fetchAllEpisodes(finalPoster, malId8, i1110, i119, anizip3, c00034);
                        if (objFetchAllEpisodes == obj17) {
                            return obj17;
                        }
                        str = obj16;
                        animeId6 = finalPoster;
                        effectiveAnilistId2 = malId8;
                        obj18 = objFetchAllEpisodes;
                        detail8 = detail5;
                        banner6 = banner3;
                        description6 = description4;
                        obj19 = obj10;
                        obj20 = obj11;
                        str2 = obj15;
                        url9 = url8;
                        anilistId7 = anilistId6;
                        malId9 = malId7;
                        status6 = status4;
                        studioNames5 = studioNames4;
                        poster8 = poster7;
                        str3 = obj14;
                        title4 = title3;
                        Pair pair15 = (Pair) obj18;
                        List subEps15 = (List) pair15.component1();
                        List dubEps15 = (List) pair15.component2();
                        C00042 c000416 = new C00042(str, str2, str3, description6, detail8, studioNames5, status6, anilistId7, malId9, subEps15, dubEps15, null);
                        c00034.L$0 = SpillingKt.nullOutSpilledVariable(url9);
                        c00034.L$1 = SpillingKt.nullOutSpilledVariable(animeId6);
                        c00034.L$2 = SpillingKt.nullOutSpilledVariable(detail8);
                        c00034.L$3 = SpillingKt.nullOutSpilledVariable(title4);
                        c00034.L$4 = SpillingKt.nullOutSpilledVariable(poster8);
                        c00034.L$5 = SpillingKt.nullOutSpilledVariable(description6);
                        c00034.L$6 = SpillingKt.nullOutSpilledVariable(status6);
                        c00034.L$7 = SpillingKt.nullOutSpilledVariable(tvType3);
                        c00034.L$8 = SpillingKt.nullOutSpilledVariable(anilistId7);
                        c00034.L$9 = SpillingKt.nullOutSpilledVariable(malId9);
                        c00034.L$10 = SpillingKt.nullOutSpilledVariable(banner6);
                        c00034.L$11 = SpillingKt.nullOutSpilledVariable(studioNames5);
                        c00034.L$12 = SpillingKt.nullOutSpilledVariable(anizip3);
                        c00034.L$13 = SpillingKt.nullOutSpilledVariable(obj19);
                        c00034.L$14 = SpillingKt.nullOutSpilledVariable(obj20);
                        c00034.L$15 = SpillingKt.nullOutSpilledVariable(str);
                        c00034.L$16 = SpillingKt.nullOutSpilledVariable(str2);
                        c00034.L$17 = SpillingKt.nullOutSpilledVariable(str3);
                        c00034.L$18 = SpillingKt.nullOutSpilledVariable(effectiveAnilistId2);
                        c00034.L$19 = SpillingKt.nullOutSpilledVariable(subEps15);
                        c00034.L$20 = SpillingKt.nullOutSpilledVariable(dubEps15);
                        c00034.label = 5;
                        obj22 = obj17;
                        objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, title4, url9, tvType3, false, c000416, c00034, 8, (Object) null);
                        if (objNewAnimeLoadResponse$default == obj22) {
                            return obj22;
                        }
                        return objNewAnimeLoadResponse$default;
                    }
                    anizip2 = anizip;
                    poster7 = poster5;
                    if (anizip2 != null) {
                        url7 = num;
                    } else {
                        url7 = num;
                    }
                    obj14 = url7;
                    if (anilistId4 == null) {
                        effectiveAnilistId = anilistId4;
                    } else if (anizip2 != null) {
                        effectiveAnilistId = num;
                    } else {
                        effectiveAnilistId = num;
                    }
                    subbed = detail5.getSubbed();
                    if (subbed != null) {
                        iIntValue = subbed.intValue();
                    } else {
                        iIntValue = 0;
                    }
                    Integer dubbed16 = detail5.getDubbed();
                    if (dubbed16 != null) {
                    }
                    c00035.L$0 = url4;
                    url8 = url4;
                    c00035.L$1 = SpillingKt.nullOutSpilledVariable(animeId5);
                    c00035.L$2 = detail5;
                    c00035.L$3 = title3;
                    c00035.L$4 = SpillingKt.nullOutSpilledVariable(poster7);
                    c00035.L$5 = description4;
                    c00035.L$6 = status4;
                    c00035.L$7 = tvType3;
                    c00035.L$8 = anilistId4;
                    c00035.L$9 = malId4;
                    c00035.L$10 = SpillingKt.nullOutSpilledVariable(banner3);
                    c00035.L$11 = studioNames3;
                    c00035.L$12 = SpillingKt.nullOutSpilledVariable(anizip2);
                    c00035.L$13 = SpillingKt.nullOutSpilledVariable(obj10);
                    c00035.L$14 = SpillingKt.nullOutSpilledVariable(obj11);
                    c00035.L$15 = obj12;
                    c00035.L$16 = obj13;
                    c00035.L$17 = obj14;
                    c00035.L$18 = SpillingKt.nullOutSpilledVariable(effectiveAnilistId);
                    c00035.label = 4;
                    int i1111 = iIntValue2;
                    obj15 = obj13;
                    studioNames4 = studioNames3;
                    obj16 = obj12;
                    malId7 = malId4;
                    anilistId6 = anilistId4;
                    int i1112 = iIntValue;
                    malId8 = effectiveAnilistId;
                    c00034 = c00035;
                    anizip3 = anizip2;
                    obj17 = obj6;
                    finalPoster = animeId5;
                    objFetchAllEpisodes = fetchAllEpisodes(finalPoster, malId8, i1112, i1111, anizip3, c00034);
                    if (objFetchAllEpisodes == obj17) {
                        return obj17;
                    }
                    str = obj16;
                    animeId6 = finalPoster;
                    effectiveAnilistId2 = malId8;
                    obj18 = objFetchAllEpisodes;
                    detail8 = detail5;
                    banner6 = banner3;
                    description6 = description4;
                    obj19 = obj10;
                    obj20 = obj11;
                    str2 = obj15;
                    url9 = url8;
                    anilistId7 = anilistId6;
                    malId9 = malId7;
                    status6 = status4;
                    studioNames5 = studioNames4;
                    poster8 = poster7;
                    str3 = obj14;
                    title4 = title3;
                    Pair pair16 = (Pair) obj18;
                    List subEps16 = (List) pair16.component1();
                    List dubEps16 = (List) pair16.component2();
                    C00042 c000417 = new C00042(str, str2, str3, description6, detail8, studioNames5, status6, anilistId7, malId9, subEps16, dubEps16, null);
                    c00034.L$0 = SpillingKt.nullOutSpilledVariable(url9);
                    c00034.L$1 = SpillingKt.nullOutSpilledVariable(animeId6);
                    c00034.L$2 = SpillingKt.nullOutSpilledVariable(detail8);
                    c00034.L$3 = SpillingKt.nullOutSpilledVariable(title4);
                    c00034.L$4 = SpillingKt.nullOutSpilledVariable(poster8);
                    c00034.L$5 = SpillingKt.nullOutSpilledVariable(description6);
                    c00034.L$6 = SpillingKt.nullOutSpilledVariable(status6);
                    c00034.L$7 = SpillingKt.nullOutSpilledVariable(tvType3);
                    c00034.L$8 = SpillingKt.nullOutSpilledVariable(anilistId7);
                    c00034.L$9 = SpillingKt.nullOutSpilledVariable(malId9);
                    c00034.L$10 = SpillingKt.nullOutSpilledVariable(banner6);
                    c00034.L$11 = SpillingKt.nullOutSpilledVariable(studioNames5);
                    c00034.L$12 = SpillingKt.nullOutSpilledVariable(anizip3);
                    c00034.L$13 = SpillingKt.nullOutSpilledVariable(obj19);
                    c00034.L$14 = SpillingKt.nullOutSpilledVariable(obj20);
                    c00034.L$15 = SpillingKt.nullOutSpilledVariable(str);
                    c00034.L$16 = SpillingKt.nullOutSpilledVariable(str2);
                    c00034.L$17 = SpillingKt.nullOutSpilledVariable(str3);
                    c00034.L$18 = SpillingKt.nullOutSpilledVariable(effectiveAnilistId2);
                    c00034.L$19 = SpillingKt.nullOutSpilledVariable(subEps16);
                    c00034.L$20 = SpillingKt.nullOutSpilledVariable(dubEps16);
                    c00034.label = 5;
                    obj22 = obj17;
                    objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, title4, url9, tvType3, false, c000417, c00034, 8, (Object) null);
                    if (objNewAnimeLoadResponse$default == obj22) {
                        return obj22;
                    }
                    return objNewAnimeLoadResponse$default;
                }
                if (Result.isFailure-impl(obj5)) {
                    obj5 = num;
                }
                aniZipResponse = (AniZipResponse) obj5;
                banner = banner2;
                malId3 = malId2;
                poster4 = poster3;
                title = title2;
                detail4 = detail3;
                poster = animeId2;
                status4 = status3;
                description4 = description3;
                tvType3 = tvType2;
                anilistId = anilistId3;
                if (aniZipResponse == null) {
                    String url110 = url3;
                    Integer malId18 = malId3;
                    obj6 = obj3;
                    Integer anilistId16 = anilistId;
                    poster5 = poster4;
                    studioNames3 = studioNames2;
                    title3 = title;
                    banner3 = banner;
                    malId4 = malId18;
                    url4 = url110;
                    detail5 = detail4;
                    animeId3 = poster;
                    anizip = aniZipResponse;
                    anilistId4 = anilistId16;
                } else if (malId3 != null) {
                    Result.Companion companion15 = Result.Companion;
                    Reanime $this$load_u24lambda_u2411 = this;
                    Requests app6 = MainActivityKt.getApp();
                    obj6 = obj3;
                    String str11 = $this$load_u24lambda_u2411.aniZipApi + "?mal_id=" + malId3.intValue();
                    c00035.L$0 = url3;
                    c00035.L$1 = poster;
                    c00035.L$2 = detail4;
                    c00035.L$3 = title;
                    c00035.L$4 = poster4;
                    c00035.L$5 = description4;
                    c00035.L$6 = status4;
                    c00035.L$7 = tvType3;
                    c00035.L$8 = anilistId;
                    c00035.L$9 = malId3;
                    c00035.L$10 = banner;
                    c00035.L$11 = studioNames2;
                    c00035.L$12 = SpillingKt.nullOutSpilledVariable($this$load_u24lambda_u2411);
                    c00035.label = 3;
                    anilistId5 = anilistId;
                    tvType4 = tvType3;
                    status5 = status4;
                    description5 = description4;
                    c00033 = c00035;
                    malId6 = malId3;
                    url3 = url3;
                    obj7 = obj6;
                    obj8 = Requests.get$default(app6, str11, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00033, 4094, (Object) null);
                    c00035 = c00033;
                    if (obj8 == obj7) {
                        return obj7;
                    }
                    detail6 = detail4;
                    animeId4 = poster;
                    banner4 = banner;
                    description4 = description5;
                    status4 = status5;
                    tvType3 = tvType4;
                    anilistId = anilistId5;
                    malId5 = malId6;
                    detail7 = null;
                    poster6 = poster4;
                    NiceResponse this_$iv10 = (NiceResponse) obj8;
                    ResponseParser parser10 = this_$iv10.getParser();
                    Intrinsics.checkNotNull(parser10);
                    obj6 = obj7;
                    safe3 = parser10.parseSafe(this_$iv10.getText(), Reflection.getOrCreateKotlinClass(AniZipResponse.class));
                    poster4 = poster6;
                    poster = animeId4;
                    obj9 = Result.constructor-impl((AniZipResponse) safe3);
                    banner5 = banner4;
                    if (Result.isFailure-impl(obj9)) {
                        obj9 = num;
                    }
                    Integer num9 = malId5;
                    poster5 = poster4;
                    malId4 = num9;
                    studioNames3 = studioNames2;
                    animeId3 = poster;
                    title3 = title;
                    url4 = url3;
                    anizip = (AniZipResponse) obj9;
                    anilistId4 = anilistId;
                    banner3 = banner5;
                    detail5 = detail6;
                } else {
                    String url111 = url3;
                    Integer malId19 = malId3;
                    obj6 = obj3;
                    Integer anilistId17 = anilistId;
                    poster5 = poster4;
                    studioNames3 = studioNames2;
                    title3 = title;
                    banner3 = banner;
                    anilistId4 = anilistId17;
                    malId4 = malId19;
                    url4 = url111;
                    detail5 = detail4;
                    animeId3 = poster;
                    anizip = num;
                }
                if (anizip == null) {
                    animeId5 = animeId3;
                    url5 = num;
                } else {
                    animeId5 = animeId3;
                    url5 = num;
                }
                obj10 = url5;
                if (anizip != null) {
                    url6 = num;
                } else {
                    url6 = num;
                }
                obj11 = url6;
                if (poster5 == null) {
                    obj12 = obj10;
                } else {
                    obj12 = poster5;
                }
                if (obj11 != null) {
                    obj13 = obj11;
                } else if (banner3 == null) {
                    obj13 = obj12;
                } else {
                    obj13 = banner3;
                }
                artworks2 = detail5.getArtworks();
                if (artworks2 != null) {
                    $this$firstOrNull$iv4 = artworks2;
                    it4 = $this$firstOrNull$iv4.iterator();
                    while (true) {
                        if (it4.hasNext()) {
                            element$iv4 = it4.next();
                            it5 = (Artwork) element$iv4;
                            anizip2 = anizip;
                            $this$firstOrNull$iv5 = $this$firstOrNull$iv4;
                            poster7 = poster5;
                            if (StringsKt.equals(it5.getImageType(), "clearart", true)) {
                                z = true;
                            } else {
                                z = true;
                            }
                            if (!z) {
                                anizip = anizip2;
                                $this$firstOrNull$iv4 = $this$firstOrNull$iv5;
                                poster5 = poster7;
                            }
                        } else {
                            anizip2 = anizip;
                            poster7 = poster5;
                            element$iv4 = num;
                        }
                    }
                    artwork3 = (Artwork) element$iv4;
                    if (artwork3 != null) {
                        break;
                    }
                    obj14 = url7;
                    if (anilistId4 == null) {
                        effectiveAnilistId = anilistId4;
                    } else if (anizip2 != null) {
                        effectiveAnilistId = num;
                    } else {
                        effectiveAnilistId = num;
                    }
                    subbed = detail5.getSubbed();
                    if (subbed != null) {
                        iIntValue = subbed.intValue();
                    } else {
                        iIntValue = 0;
                    }
                    Integer dubbed17 = detail5.getDubbed();
                    if (dubbed17 != null) {
                    }
                    c00035.L$0 = url4;
                    url8 = url4;
                    c00035.L$1 = SpillingKt.nullOutSpilledVariable(animeId5);
                    c00035.L$2 = detail5;
                    c00035.L$3 = title3;
                    c00035.L$4 = SpillingKt.nullOutSpilledVariable(poster7);
                    c00035.L$5 = description4;
                    c00035.L$6 = status4;
                    c00035.L$7 = tvType3;
                    c00035.L$8 = anilistId4;
                    c00035.L$9 = malId4;
                    c00035.L$10 = SpillingKt.nullOutSpilledVariable(banner3);
                    c00035.L$11 = studioNames3;
                    c00035.L$12 = SpillingKt.nullOutSpilledVariable(anizip2);
                    c00035.L$13 = SpillingKt.nullOutSpilledVariable(obj10);
                    c00035.L$14 = SpillingKt.nullOutSpilledVariable(obj11);
                    c00035.L$15 = obj12;
                    c00035.L$16 = obj13;
                    c00035.L$17 = obj14;
                    c00035.L$18 = SpillingKt.nullOutSpilledVariable(effectiveAnilistId);
                    c00035.label = 4;
                    int i1113 = iIntValue2;
                    obj15 = obj13;
                    studioNames4 = studioNames3;
                    obj16 = obj12;
                    malId7 = malId4;
                    anilistId6 = anilistId4;
                    int i1114 = iIntValue;
                    malId8 = effectiveAnilistId;
                    c00034 = c00035;
                    anizip3 = anizip2;
                    obj17 = obj6;
                    finalPoster = animeId5;
                    objFetchAllEpisodes = fetchAllEpisodes(finalPoster, malId8, i1114, i1113, anizip3, c00034);
                    if (objFetchAllEpisodes == obj17) {
                        return obj17;
                    }
                    str = obj16;
                    animeId6 = finalPoster;
                    effectiveAnilistId2 = malId8;
                    obj18 = objFetchAllEpisodes;
                    detail8 = detail5;
                    banner6 = banner3;
                    description6 = description4;
                    obj19 = obj10;
                    obj20 = obj11;
                    str2 = obj15;
                    url9 = url8;
                    anilistId7 = anilistId6;
                    malId9 = malId7;
                    status6 = status4;
                    studioNames5 = studioNames4;
                    poster8 = poster7;
                    str3 = obj14;
                    title4 = title3;
                    Pair pair17 = (Pair) obj18;
                    List subEps17 = (List) pair17.component1();
                    List dubEps17 = (List) pair17.component2();
                    C00042 c000418 = new C00042(str, str2, str3, description6, detail8, studioNames5, status6, anilistId7, malId9, subEps17, dubEps17, null);
                    c00034.L$0 = SpillingKt.nullOutSpilledVariable(url9);
                    c00034.L$1 = SpillingKt.nullOutSpilledVariable(animeId6);
                    c00034.L$2 = SpillingKt.nullOutSpilledVariable(detail8);
                    c00034.L$3 = SpillingKt.nullOutSpilledVariable(title4);
                    c00034.L$4 = SpillingKt.nullOutSpilledVariable(poster8);
                    c00034.L$5 = SpillingKt.nullOutSpilledVariable(description6);
                    c00034.L$6 = SpillingKt.nullOutSpilledVariable(status6);
                    c00034.L$7 = SpillingKt.nullOutSpilledVariable(tvType3);
                    c00034.L$8 = SpillingKt.nullOutSpilledVariable(anilistId7);
                    c00034.L$9 = SpillingKt.nullOutSpilledVariable(malId9);
                    c00034.L$10 = SpillingKt.nullOutSpilledVariable(banner6);
                    c00034.L$11 = SpillingKt.nullOutSpilledVariable(studioNames5);
                    c00034.L$12 = SpillingKt.nullOutSpilledVariable(anizip3);
                    c00034.L$13 = SpillingKt.nullOutSpilledVariable(obj19);
                    c00034.L$14 = SpillingKt.nullOutSpilledVariable(obj20);
                    c00034.L$15 = SpillingKt.nullOutSpilledVariable(str);
                    c00034.L$16 = SpillingKt.nullOutSpilledVariable(str2);
                    c00034.L$17 = SpillingKt.nullOutSpilledVariable(str3);
                    c00034.L$18 = SpillingKt.nullOutSpilledVariable(effectiveAnilistId2);
                    c00034.L$19 = SpillingKt.nullOutSpilledVariable(subEps17);
                    c00034.L$20 = SpillingKt.nullOutSpilledVariable(dubEps17);
                    c00034.label = 5;
                    obj22 = obj17;
                    objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, title4, url9, tvType3, false, c000418, c00034, 8, (Object) null);
                    if (objNewAnimeLoadResponse$default == obj22) {
                        return obj22;
                    }
                    return objNewAnimeLoadResponse$default;
                }
                anizip2 = anizip;
                poster7 = poster5;
                if (anizip2 != null) {
                    url7 = num;
                } else {
                    url7 = num;
                }
                obj14 = url7;
                if (anilistId4 == null) {
                    effectiveAnilistId = anilistId4;
                } else if (anizip2 != null) {
                    effectiveAnilistId = num;
                } else {
                    effectiveAnilistId = num;
                }
                subbed = detail5.getSubbed();
                if (subbed != null) {
                    iIntValue = subbed.intValue();
                } else {
                    iIntValue = 0;
                }
                Integer dubbed18 = detail5.getDubbed();
                if (dubbed18 != null) {
                }
                c00035.L$0 = url4;
                url8 = url4;
                c00035.L$1 = SpillingKt.nullOutSpilledVariable(animeId5);
                c00035.L$2 = detail5;
                c00035.L$3 = title3;
                c00035.L$4 = SpillingKt.nullOutSpilledVariable(poster7);
                c00035.L$5 = description4;
                c00035.L$6 = status4;
                c00035.L$7 = tvType3;
                c00035.L$8 = anilistId4;
                c00035.L$9 = malId4;
                c00035.L$10 = SpillingKt.nullOutSpilledVariable(banner3);
                c00035.L$11 = studioNames3;
                c00035.L$12 = SpillingKt.nullOutSpilledVariable(anizip2);
                c00035.L$13 = SpillingKt.nullOutSpilledVariable(obj10);
                c00035.L$14 = SpillingKt.nullOutSpilledVariable(obj11);
                c00035.L$15 = obj12;
                c00035.L$16 = obj13;
                c00035.L$17 = obj14;
                c00035.L$18 = SpillingKt.nullOutSpilledVariable(effectiveAnilistId);
                c00035.label = 4;
                int i1115 = iIntValue2;
                obj15 = obj13;
                studioNames4 = studioNames3;
                obj16 = obj12;
                malId7 = malId4;
                anilistId6 = anilistId4;
                int i1116 = iIntValue;
                malId8 = effectiveAnilistId;
                c00034 = c00035;
                anizip3 = anizip2;
                obj17 = obj6;
                finalPoster = animeId5;
                objFetchAllEpisodes = fetchAllEpisodes(finalPoster, malId8, i1116, i1115, anizip3, c00034);
                if (objFetchAllEpisodes == obj17) {
                    return obj17;
                }
                str = obj16;
                animeId6 = finalPoster;
                effectiveAnilistId2 = malId8;
                obj18 = objFetchAllEpisodes;
                detail8 = detail5;
                banner6 = banner3;
                description6 = description4;
                obj19 = obj10;
                obj20 = obj11;
                str2 = obj15;
                url9 = url8;
                anilistId7 = anilistId6;
                malId9 = malId7;
                status6 = status4;
                studioNames5 = studioNames4;
                poster8 = poster7;
                str3 = obj14;
                title4 = title3;
                Pair pair18 = (Pair) obj18;
                List subEps18 = (List) pair18.component1();
                List dubEps18 = (List) pair18.component2();
                C00042 c000419 = new C00042(str, str2, str3, description6, detail8, studioNames5, status6, anilistId7, malId9, subEps18, dubEps18, null);
                c00034.L$0 = SpillingKt.nullOutSpilledVariable(url9);
                c00034.L$1 = SpillingKt.nullOutSpilledVariable(animeId6);
                c00034.L$2 = SpillingKt.nullOutSpilledVariable(detail8);
                c00034.L$3 = SpillingKt.nullOutSpilledVariable(title4);
                c00034.L$4 = SpillingKt.nullOutSpilledVariable(poster8);
                c00034.L$5 = SpillingKt.nullOutSpilledVariable(description6);
                c00034.L$6 = SpillingKt.nullOutSpilledVariable(status6);
                c00034.L$7 = SpillingKt.nullOutSpilledVariable(tvType3);
                c00034.L$8 = SpillingKt.nullOutSpilledVariable(anilistId7);
                c00034.L$9 = SpillingKt.nullOutSpilledVariable(malId9);
                c00034.L$10 = SpillingKt.nullOutSpilledVariable(banner6);
                c00034.L$11 = SpillingKt.nullOutSpilledVariable(studioNames5);
                c00034.L$12 = SpillingKt.nullOutSpilledVariable(anizip3);
                c00034.L$13 = SpillingKt.nullOutSpilledVariable(obj19);
                c00034.L$14 = SpillingKt.nullOutSpilledVariable(obj20);
                c00034.L$15 = SpillingKt.nullOutSpilledVariable(str);
                c00034.L$16 = SpillingKt.nullOutSpilledVariable(str2);
                c00034.L$17 = SpillingKt.nullOutSpilledVariable(str3);
                c00034.L$18 = SpillingKt.nullOutSpilledVariable(effectiveAnilistId2);
                c00034.L$19 = SpillingKt.nullOutSpilledVariable(subEps18);
                c00034.L$20 = SpillingKt.nullOutSpilledVariable(dubEps18);
                c00034.label = 5;
                obj22 = obj17;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, title4, url9, tvType3, false, c000419, c00034, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == obj22) {
                    return obj22;
                }
                return objNewAnimeLoadResponse$default;
            case 3:
                studioNames2 = (List) c00035.L$11;
                banner4 = (String) c00035.L$10;
                malId5 = (Integer) c00035.L$9;
                anilistId = (Integer) c00035.L$8;
                tvType3 = (TvType) c00035.L$7;
                status4 = (ShowStatus) c00035.L$6;
                description4 = (String) c00035.L$5;
                poster6 = (String) c00035.L$4;
                title = (String) c00035.L$3;
                detail6 = (AnimeDetail) c00035.L$2;
                animeId4 = (String) c00035.L$1;
                String url20 = (String) c00035.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    url3 = url20;
                    obj7 = coroutine_suspended;
                    detail7 = null;
                    obj8 = $result;
                    num = null;
                    NiceResponse this_$iv11 = (NiceResponse) obj8;
                    ResponseParser parser11 = this_$iv11.getParser();
                    Intrinsics.checkNotNull(parser11);
                    obj6 = obj7;
                    safe3 = parser11.parseSafe(this_$iv11.getText(), Reflection.getOrCreateKotlinClass(AniZipResponse.class));
                    poster4 = poster6;
                    poster = animeId4;
                    obj9 = Result.constructor-impl((AniZipResponse) safe3);
                    banner5 = banner4;
                } catch (Throwable th11) {
                    th = th11;
                    url3 = url20;
                    obj6 = coroutine_suspended;
                    poster4 = poster6;
                    detail4 = detail6;
                    poster = animeId4;
                    num = null;
                    Result.Companion companion16 = Result.Companion;
                    detail6 = detail4;
                    obj9 = Result.constructor-impl(ResultKt.createFailure(th));
                    banner5 = banner4;
                    if (Result.isFailure-impl(obj9)) {
                        obj9 = num;
                    }
                    Integer num10 = malId5;
                    poster5 = poster4;
                    malId4 = num10;
                    studioNames3 = studioNames2;
                    animeId3 = poster;
                    title3 = title;
                    url4 = url3;
                    anizip = (AniZipResponse) obj9;
                    anilistId4 = anilistId;
                    banner3 = banner5;
                    detail5 = detail6;
                    if (anizip == null) {
                        animeId5 = animeId3;
                        url5 = num;
                    } else {
                        animeId5 = animeId3;
                        url5 = num;
                    }
                    obj10 = url5;
                    if (anizip != null) {
                        url6 = num;
                    } else {
                        url6 = num;
                    }
                    obj11 = url6;
                    if (poster5 == null) {
                        obj12 = obj10;
                    } else {
                        obj12 = poster5;
                    }
                    if (obj11 != null) {
                        obj13 = obj11;
                    } else if (banner3 == null) {
                        obj13 = obj12;
                    } else {
                        obj13 = banner3;
                    }
                    artworks2 = detail5.getArtworks();
                    if (artworks2 != null) {
                        $this$firstOrNull$iv4 = artworks2;
                        it4 = $this$firstOrNull$iv4.iterator();
                        while (true) {
                            if (it4.hasNext()) {
                                element$iv4 = it4.next();
                                it5 = (Artwork) element$iv4;
                                anizip2 = anizip;
                                $this$firstOrNull$iv5 = $this$firstOrNull$iv4;
                                poster7 = poster5;
                                if (StringsKt.equals(it5.getImageType(), "clearart", true)) {
                                    z = true;
                                } else {
                                    z = true;
                                }
                                if (!z) {
                                    anizip = anizip2;
                                    $this$firstOrNull$iv4 = $this$firstOrNull$iv5;
                                    poster5 = poster7;
                                }
                            } else {
                                anizip2 = anizip;
                                poster7 = poster5;
                                element$iv4 = num;
                            }
                        }
                        artwork3 = (Artwork) element$iv4;
                        if (artwork3 != null) {
                            break;
                        }
                        obj14 = url7;
                        if (anilistId4 == null) {
                            effectiveAnilistId = anilistId4;
                        } else if (anizip2 != null) {
                            effectiveAnilistId = num;
                        } else {
                            effectiveAnilistId = num;
                        }
                        subbed = detail5.getSubbed();
                        if (subbed != null) {
                            iIntValue = subbed.intValue();
                        } else {
                            iIntValue = 0;
                        }
                        Integer dubbed19 = detail5.getDubbed();
                        if (dubbed19 != null) {
                        }
                        c00035.L$0 = url4;
                        url8 = url4;
                        c00035.L$1 = SpillingKt.nullOutSpilledVariable(animeId5);
                        c00035.L$2 = detail5;
                        c00035.L$3 = title3;
                        c00035.L$4 = SpillingKt.nullOutSpilledVariable(poster7);
                        c00035.L$5 = description4;
                        c00035.L$6 = status4;
                        c00035.L$7 = tvType3;
                        c00035.L$8 = anilistId4;
                        c00035.L$9 = malId4;
                        c00035.L$10 = SpillingKt.nullOutSpilledVariable(banner3);
                        c00035.L$11 = studioNames3;
                        c00035.L$12 = SpillingKt.nullOutSpilledVariable(anizip2);
                        c00035.L$13 = SpillingKt.nullOutSpilledVariable(obj10);
                        c00035.L$14 = SpillingKt.nullOutSpilledVariable(obj11);
                        c00035.L$15 = obj12;
                        c00035.L$16 = obj13;
                        c00035.L$17 = obj14;
                        c00035.L$18 = SpillingKt.nullOutSpilledVariable(effectiveAnilistId);
                        c00035.label = 4;
                        int i1117 = iIntValue2;
                        obj15 = obj13;
                        studioNames4 = studioNames3;
                        obj16 = obj12;
                        malId7 = malId4;
                        anilistId6 = anilistId4;
                        int i1118 = iIntValue;
                        malId8 = effectiveAnilistId;
                        c00034 = c00035;
                        anizip3 = anizip2;
                        obj17 = obj6;
                        finalPoster = animeId5;
                        objFetchAllEpisodes = fetchAllEpisodes(finalPoster, malId8, i1118, i1117, anizip3, c00034);
                        if (objFetchAllEpisodes == obj17) {
                            return obj17;
                        }
                        str = obj16;
                        animeId6 = finalPoster;
                        effectiveAnilistId2 = malId8;
                        obj18 = objFetchAllEpisodes;
                        detail8 = detail5;
                        banner6 = banner3;
                        description6 = description4;
                        obj19 = obj10;
                        obj20 = obj11;
                        str2 = obj15;
                        url9 = url8;
                        anilistId7 = anilistId6;
                        malId9 = malId7;
                        status6 = status4;
                        studioNames5 = studioNames4;
                        poster8 = poster7;
                        str3 = obj14;
                        title4 = title3;
                        Pair pair19 = (Pair) obj18;
                        List subEps19 = (List) pair19.component1();
                        List dubEps19 = (List) pair19.component2();
                        C00042 c0004110 = new C00042(str, str2, str3, description6, detail8, studioNames5, status6, anilistId7, malId9, subEps19, dubEps19, null);
                        c00034.L$0 = SpillingKt.nullOutSpilledVariable(url9);
                        c00034.L$1 = SpillingKt.nullOutSpilledVariable(animeId6);
                        c00034.L$2 = SpillingKt.nullOutSpilledVariable(detail8);
                        c00034.L$3 = SpillingKt.nullOutSpilledVariable(title4);
                        c00034.L$4 = SpillingKt.nullOutSpilledVariable(poster8);
                        c00034.L$5 = SpillingKt.nullOutSpilledVariable(description6);
                        c00034.L$6 = SpillingKt.nullOutSpilledVariable(status6);
                        c00034.L$7 = SpillingKt.nullOutSpilledVariable(tvType3);
                        c00034.L$8 = SpillingKt.nullOutSpilledVariable(anilistId7);
                        c00034.L$9 = SpillingKt.nullOutSpilledVariable(malId9);
                        c00034.L$10 = SpillingKt.nullOutSpilledVariable(banner6);
                        c00034.L$11 = SpillingKt.nullOutSpilledVariable(studioNames5);
                        c00034.L$12 = SpillingKt.nullOutSpilledVariable(anizip3);
                        c00034.L$13 = SpillingKt.nullOutSpilledVariable(obj19);
                        c00034.L$14 = SpillingKt.nullOutSpilledVariable(obj20);
                        c00034.L$15 = SpillingKt.nullOutSpilledVariable(str);
                        c00034.L$16 = SpillingKt.nullOutSpilledVariable(str2);
                        c00034.L$17 = SpillingKt.nullOutSpilledVariable(str3);
                        c00034.L$18 = SpillingKt.nullOutSpilledVariable(effectiveAnilistId2);
                        c00034.L$19 = SpillingKt.nullOutSpilledVariable(subEps19);
                        c00034.L$20 = SpillingKt.nullOutSpilledVariable(dubEps19);
                        c00034.label = 5;
                        obj22 = obj17;
                        objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, title4, url9, tvType3, false, c0004110, c00034, 8, (Object) null);
                        if (objNewAnimeLoadResponse$default == obj22) {
                            return obj22;
                        }
                        return objNewAnimeLoadResponse$default;
                    }
                    anizip2 = anizip;
                    poster7 = poster5;
                    if (anizip2 != null) {
                        url7 = num;
                    } else {
                        url7 = num;
                    }
                    obj14 = url7;
                    if (anilistId4 == null) {
                        effectiveAnilistId = anilistId4;
                    } else if (anizip2 != null) {
                        effectiveAnilistId = num;
                    } else {
                        effectiveAnilistId = num;
                    }
                    subbed = detail5.getSubbed();
                    if (subbed != null) {
                        iIntValue = subbed.intValue();
                    } else {
                        iIntValue = 0;
                    }
                    Integer dubbed110 = detail5.getDubbed();
                    if (dubbed110 != null) {
                    }
                    c00035.L$0 = url4;
                    url8 = url4;
                    c00035.L$1 = SpillingKt.nullOutSpilledVariable(animeId5);
                    c00035.L$2 = detail5;
                    c00035.L$3 = title3;
                    c00035.L$4 = SpillingKt.nullOutSpilledVariable(poster7);
                    c00035.L$5 = description4;
                    c00035.L$6 = status4;
                    c00035.L$7 = tvType3;
                    c00035.L$8 = anilistId4;
                    c00035.L$9 = malId4;
                    c00035.L$10 = SpillingKt.nullOutSpilledVariable(banner3);
                    c00035.L$11 = studioNames3;
                    c00035.L$12 = SpillingKt.nullOutSpilledVariable(anizip2);
                    c00035.L$13 = SpillingKt.nullOutSpilledVariable(obj10);
                    c00035.L$14 = SpillingKt.nullOutSpilledVariable(obj11);
                    c00035.L$15 = obj12;
                    c00035.L$16 = obj13;
                    c00035.L$17 = obj14;
                    c00035.L$18 = SpillingKt.nullOutSpilledVariable(effectiveAnilistId);
                    c00035.label = 4;
                    int i1119 = iIntValue2;
                    obj15 = obj13;
                    studioNames4 = studioNames3;
                    obj16 = obj12;
                    malId7 = malId4;
                    anilistId6 = anilistId4;
                    int i11110 = iIntValue;
                    malId8 = effectiveAnilistId;
                    c00034 = c00035;
                    anizip3 = anizip2;
                    obj17 = obj6;
                    finalPoster = animeId5;
                    objFetchAllEpisodes = fetchAllEpisodes(finalPoster, malId8, i11110, i1119, anizip3, c00034);
                    if (objFetchAllEpisodes == obj17) {
                        return obj17;
                    }
                    str = obj16;
                    animeId6 = finalPoster;
                    effectiveAnilistId2 = malId8;
                    obj18 = objFetchAllEpisodes;
                    detail8 = detail5;
                    banner6 = banner3;
                    description6 = description4;
                    obj19 = obj10;
                    obj20 = obj11;
                    str2 = obj15;
                    url9 = url8;
                    anilistId7 = anilistId6;
                    malId9 = malId7;
                    status6 = status4;
                    studioNames5 = studioNames4;
                    poster8 = poster7;
                    str3 = obj14;
                    title4 = title3;
                    Pair pair110 = (Pair) obj18;
                    List subEps110 = (List) pair110.component1();
                    List dubEps110 = (List) pair110.component2();
                    C00042 c0004111 = new C00042(str, str2, str3, description6, detail8, studioNames5, status6, anilistId7, malId9, subEps110, dubEps110, null);
                    c00034.L$0 = SpillingKt.nullOutSpilledVariable(url9);
                    c00034.L$1 = SpillingKt.nullOutSpilledVariable(animeId6);
                    c00034.L$2 = SpillingKt.nullOutSpilledVariable(detail8);
                    c00034.L$3 = SpillingKt.nullOutSpilledVariable(title4);
                    c00034.L$4 = SpillingKt.nullOutSpilledVariable(poster8);
                    c00034.L$5 = SpillingKt.nullOutSpilledVariable(description6);
                    c00034.L$6 = SpillingKt.nullOutSpilledVariable(status6);
                    c00034.L$7 = SpillingKt.nullOutSpilledVariable(tvType3);
                    c00034.L$8 = SpillingKt.nullOutSpilledVariable(anilistId7);
                    c00034.L$9 = SpillingKt.nullOutSpilledVariable(malId9);
                    c00034.L$10 = SpillingKt.nullOutSpilledVariable(banner6);
                    c00034.L$11 = SpillingKt.nullOutSpilledVariable(studioNames5);
                    c00034.L$12 = SpillingKt.nullOutSpilledVariable(anizip3);
                    c00034.L$13 = SpillingKt.nullOutSpilledVariable(obj19);
                    c00034.L$14 = SpillingKt.nullOutSpilledVariable(obj20);
                    c00034.L$15 = SpillingKt.nullOutSpilledVariable(str);
                    c00034.L$16 = SpillingKt.nullOutSpilledVariable(str2);
                    c00034.L$17 = SpillingKt.nullOutSpilledVariable(str3);
                    c00034.L$18 = SpillingKt.nullOutSpilledVariable(effectiveAnilistId2);
                    c00034.L$19 = SpillingKt.nullOutSpilledVariable(subEps110);
                    c00034.L$20 = SpillingKt.nullOutSpilledVariable(dubEps110);
                    c00034.label = 5;
                    obj22 = obj17;
                    objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, title4, url9, tvType3, false, c0004111, c00034, 8, (Object) null);
                    if (objNewAnimeLoadResponse$default == obj22) {
                        return obj22;
                    }
                    return objNewAnimeLoadResponse$default;
                }
                if (Result.isFailure-impl(obj9)) {
                    obj9 = num;
                }
                Integer num11 = malId5;
                poster5 = poster4;
                malId4 = num11;
                studioNames3 = studioNames2;
                animeId3 = poster;
                title3 = title;
                url4 = url3;
                anizip = (AniZipResponse) obj9;
                anilistId4 = anilistId;
                banner3 = banner5;
                detail5 = detail6;
                if (anizip == null) {
                    animeId5 = animeId3;
                    url5 = num;
                } else {
                    animeId5 = animeId3;
                    url5 = num;
                }
                obj10 = url5;
                if (anizip != null) {
                    url6 = num;
                } else {
                    url6 = num;
                }
                obj11 = url6;
                if (poster5 == null) {
                    obj12 = obj10;
                } else {
                    obj12 = poster5;
                }
                if (obj11 != null) {
                    obj13 = obj11;
                } else if (banner3 == null) {
                    obj13 = obj12;
                } else {
                    obj13 = banner3;
                }
                artworks2 = detail5.getArtworks();
                if (artworks2 != null) {
                    $this$firstOrNull$iv4 = artworks2;
                    it4 = $this$firstOrNull$iv4.iterator();
                    while (true) {
                        if (it4.hasNext()) {
                            element$iv4 = it4.next();
                            it5 = (Artwork) element$iv4;
                            anizip2 = anizip;
                            $this$firstOrNull$iv5 = $this$firstOrNull$iv4;
                            poster7 = poster5;
                            if (StringsKt.equals(it5.getImageType(), "clearart", true)) {
                                z = true;
                            } else {
                                z = true;
                            }
                            if (!z) {
                                anizip = anizip2;
                                $this$firstOrNull$iv4 = $this$firstOrNull$iv5;
                                poster5 = poster7;
                            }
                        } else {
                            anizip2 = anizip;
                            poster7 = poster5;
                            element$iv4 = num;
                        }
                    }
                    artwork3 = (Artwork) element$iv4;
                    if (artwork3 != null) {
                        break;
                    }
                    obj14 = url7;
                    if (anilistId4 == null) {
                        effectiveAnilistId = anilistId4;
                    } else if (anizip2 != null) {
                        effectiveAnilistId = num;
                    } else {
                        effectiveAnilistId = num;
                    }
                    subbed = detail5.getSubbed();
                    if (subbed != null) {
                        iIntValue = subbed.intValue();
                    } else {
                        iIntValue = 0;
                    }
                    Integer dubbed111 = detail5.getDubbed();
                    if (dubbed111 != null) {
                    }
                    c00035.L$0 = url4;
                    url8 = url4;
                    c00035.L$1 = SpillingKt.nullOutSpilledVariable(animeId5);
                    c00035.L$2 = detail5;
                    c00035.L$3 = title3;
                    c00035.L$4 = SpillingKt.nullOutSpilledVariable(poster7);
                    c00035.L$5 = description4;
                    c00035.L$6 = status4;
                    c00035.L$7 = tvType3;
                    c00035.L$8 = anilistId4;
                    c00035.L$9 = malId4;
                    c00035.L$10 = SpillingKt.nullOutSpilledVariable(banner3);
                    c00035.L$11 = studioNames3;
                    c00035.L$12 = SpillingKt.nullOutSpilledVariable(anizip2);
                    c00035.L$13 = SpillingKt.nullOutSpilledVariable(obj10);
                    c00035.L$14 = SpillingKt.nullOutSpilledVariable(obj11);
                    c00035.L$15 = obj12;
                    c00035.L$16 = obj13;
                    c00035.L$17 = obj14;
                    c00035.L$18 = SpillingKt.nullOutSpilledVariable(effectiveAnilistId);
                    c00035.label = 4;
                    int i11111 = iIntValue2;
                    obj15 = obj13;
                    studioNames4 = studioNames3;
                    obj16 = obj12;
                    malId7 = malId4;
                    anilistId6 = anilistId4;
                    int i11112 = iIntValue;
                    malId8 = effectiveAnilistId;
                    c00034 = c00035;
                    anizip3 = anizip2;
                    obj17 = obj6;
                    finalPoster = animeId5;
                    objFetchAllEpisodes = fetchAllEpisodes(finalPoster, malId8, i11112, i11111, anizip3, c00034);
                    if (objFetchAllEpisodes == obj17) {
                        return obj17;
                    }
                    str = obj16;
                    animeId6 = finalPoster;
                    effectiveAnilistId2 = malId8;
                    obj18 = objFetchAllEpisodes;
                    detail8 = detail5;
                    banner6 = banner3;
                    description6 = description4;
                    obj19 = obj10;
                    obj20 = obj11;
                    str2 = obj15;
                    url9 = url8;
                    anilistId7 = anilistId6;
                    malId9 = malId7;
                    status6 = status4;
                    studioNames5 = studioNames4;
                    poster8 = poster7;
                    str3 = obj14;
                    title4 = title3;
                    Pair pair111 = (Pair) obj18;
                    List subEps111 = (List) pair111.component1();
                    List dubEps111 = (List) pair111.component2();
                    C00042 c0004112 = new C00042(str, str2, str3, description6, detail8, studioNames5, status6, anilistId7, malId9, subEps111, dubEps111, null);
                    c00034.L$0 = SpillingKt.nullOutSpilledVariable(url9);
                    c00034.L$1 = SpillingKt.nullOutSpilledVariable(animeId6);
                    c00034.L$2 = SpillingKt.nullOutSpilledVariable(detail8);
                    c00034.L$3 = SpillingKt.nullOutSpilledVariable(title4);
                    c00034.L$4 = SpillingKt.nullOutSpilledVariable(poster8);
                    c00034.L$5 = SpillingKt.nullOutSpilledVariable(description6);
                    c00034.L$6 = SpillingKt.nullOutSpilledVariable(status6);
                    c00034.L$7 = SpillingKt.nullOutSpilledVariable(tvType3);
                    c00034.L$8 = SpillingKt.nullOutSpilledVariable(anilistId7);
                    c00034.L$9 = SpillingKt.nullOutSpilledVariable(malId9);
                    c00034.L$10 = SpillingKt.nullOutSpilledVariable(banner6);
                    c00034.L$11 = SpillingKt.nullOutSpilledVariable(studioNames5);
                    c00034.L$12 = SpillingKt.nullOutSpilledVariable(anizip3);
                    c00034.L$13 = SpillingKt.nullOutSpilledVariable(obj19);
                    c00034.L$14 = SpillingKt.nullOutSpilledVariable(obj20);
                    c00034.L$15 = SpillingKt.nullOutSpilledVariable(str);
                    c00034.L$16 = SpillingKt.nullOutSpilledVariable(str2);
                    c00034.L$17 = SpillingKt.nullOutSpilledVariable(str3);
                    c00034.L$18 = SpillingKt.nullOutSpilledVariable(effectiveAnilistId2);
                    c00034.L$19 = SpillingKt.nullOutSpilledVariable(subEps111);
                    c00034.L$20 = SpillingKt.nullOutSpilledVariable(dubEps111);
                    c00034.label = 5;
                    obj22 = obj17;
                    objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, title4, url9, tvType3, false, c0004112, c00034, 8, (Object) null);
                    if (objNewAnimeLoadResponse$default == obj22) {
                        return obj22;
                    }
                    return objNewAnimeLoadResponse$default;
                }
                anizip2 = anizip;
                poster7 = poster5;
                if (anizip2 != null) {
                    url7 = num;
                } else {
                    url7 = num;
                }
                obj14 = url7;
                if (anilistId4 == null) {
                    effectiveAnilistId = anilistId4;
                } else if (anizip2 != null) {
                    effectiveAnilistId = num;
                } else {
                    effectiveAnilistId = num;
                }
                subbed = detail5.getSubbed();
                if (subbed != null) {
                    iIntValue = subbed.intValue();
                } else {
                    iIntValue = 0;
                }
                Integer dubbed112 = detail5.getDubbed();
                if (dubbed112 != null) {
                }
                c00035.L$0 = url4;
                url8 = url4;
                c00035.L$1 = SpillingKt.nullOutSpilledVariable(animeId5);
                c00035.L$2 = detail5;
                c00035.L$3 = title3;
                c00035.L$4 = SpillingKt.nullOutSpilledVariable(poster7);
                c00035.L$5 = description4;
                c00035.L$6 = status4;
                c00035.L$7 = tvType3;
                c00035.L$8 = anilistId4;
                c00035.L$9 = malId4;
                c00035.L$10 = SpillingKt.nullOutSpilledVariable(banner3);
                c00035.L$11 = studioNames3;
                c00035.L$12 = SpillingKt.nullOutSpilledVariable(anizip2);
                c00035.L$13 = SpillingKt.nullOutSpilledVariable(obj10);
                c00035.L$14 = SpillingKt.nullOutSpilledVariable(obj11);
                c00035.L$15 = obj12;
                c00035.L$16 = obj13;
                c00035.L$17 = obj14;
                c00035.L$18 = SpillingKt.nullOutSpilledVariable(effectiveAnilistId);
                c00035.label = 4;
                int i11113 = iIntValue2;
                obj15 = obj13;
                studioNames4 = studioNames3;
                obj16 = obj12;
                malId7 = malId4;
                anilistId6 = anilistId4;
                int i11114 = iIntValue;
                malId8 = effectiveAnilistId;
                c00034 = c00035;
                anizip3 = anizip2;
                obj17 = obj6;
                finalPoster = animeId5;
                objFetchAllEpisodes = fetchAllEpisodes(finalPoster, malId8, i11114, i11113, anizip3, c00034);
                if (objFetchAllEpisodes == obj17) {
                    return obj17;
                }
                str = obj16;
                animeId6 = finalPoster;
                effectiveAnilistId2 = malId8;
                obj18 = objFetchAllEpisodes;
                detail8 = detail5;
                banner6 = banner3;
                description6 = description4;
                obj19 = obj10;
                obj20 = obj11;
                str2 = obj15;
                url9 = url8;
                anilistId7 = anilistId6;
                malId9 = malId7;
                status6 = status4;
                studioNames5 = studioNames4;
                poster8 = poster7;
                str3 = obj14;
                title4 = title3;
                Pair pair112 = (Pair) obj18;
                List subEps112 = (List) pair112.component1();
                List dubEps112 = (List) pair112.component2();
                C00042 c0004113 = new C00042(str, str2, str3, description6, detail8, studioNames5, status6, anilistId7, malId9, subEps112, dubEps112, null);
                c00034.L$0 = SpillingKt.nullOutSpilledVariable(url9);
                c00034.L$1 = SpillingKt.nullOutSpilledVariable(animeId6);
                c00034.L$2 = SpillingKt.nullOutSpilledVariable(detail8);
                c00034.L$3 = SpillingKt.nullOutSpilledVariable(title4);
                c00034.L$4 = SpillingKt.nullOutSpilledVariable(poster8);
                c00034.L$5 = SpillingKt.nullOutSpilledVariable(description6);
                c00034.L$6 = SpillingKt.nullOutSpilledVariable(status6);
                c00034.L$7 = SpillingKt.nullOutSpilledVariable(tvType3);
                c00034.L$8 = SpillingKt.nullOutSpilledVariable(anilistId7);
                c00034.L$9 = SpillingKt.nullOutSpilledVariable(malId9);
                c00034.L$10 = SpillingKt.nullOutSpilledVariable(banner6);
                c00034.L$11 = SpillingKt.nullOutSpilledVariable(studioNames5);
                c00034.L$12 = SpillingKt.nullOutSpilledVariable(anizip3);
                c00034.L$13 = SpillingKt.nullOutSpilledVariable(obj19);
                c00034.L$14 = SpillingKt.nullOutSpilledVariable(obj20);
                c00034.L$15 = SpillingKt.nullOutSpilledVariable(str);
                c00034.L$16 = SpillingKt.nullOutSpilledVariable(str2);
                c00034.L$17 = SpillingKt.nullOutSpilledVariable(str3);
                c00034.L$18 = SpillingKt.nullOutSpilledVariable(effectiveAnilistId2);
                c00034.L$19 = SpillingKt.nullOutSpilledVariable(subEps112);
                c00034.L$20 = SpillingKt.nullOutSpilledVariable(dubEps112);
                c00034.label = 5;
                obj22 = obj17;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, title4, url9, tvType3, false, c0004113, c00034, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == obj22) {
                    return obj22;
                }
                return objNewAnimeLoadResponse$default;
            case 4:
                Integer effectiveAnilistId3 = (Integer) c00035.L$18;
                String logoUrl = (String) c00035.L$17;
                String finalBanner = (String) c00035.L$16;
                String finalPoster2 = (String) c00035.L$15;
                String anizipFanart = (String) c00035.L$14;
                String anizipPoster = (String) c00035.L$13;
                AniZipResponse anizip4 = (AniZipResponse) c00035.L$12;
                List studioNames6 = (List) c00035.L$11;
                String banner7 = (String) c00035.L$10;
                Integer malId20 = (Integer) c00035.L$9;
                Integer anilistId18 = (Integer) c00035.L$8;
                TvType tvType6 = (TvType) c00035.L$7;
                ShowStatus status7 = (ShowStatus) c00035.L$6;
                String description7 = (String) c00035.L$5;
                poster8 = (String) c00035.L$4;
                String title5 = (String) c00035.L$3;
                AnimeDetail detail9 = (AnimeDetail) c00035.L$2;
                animeId6 = (String) c00035.L$1;
                String url21 = (String) c00035.L$0;
                ResultKt.throwOnFailure($result);
                str3 = logoUrl;
                str2 = finalBanner;
                str = finalPoster2;
                obj19 = anizipPoster;
                anizip3 = anizip4;
                studioNames5 = studioNames6;
                malId9 = malId20;
                anilistId7 = anilistId18;
                effectiveAnilistId2 = effectiveAnilistId3;
                status6 = status7;
                description6 = description7;
                title4 = title5;
                detail8 = detail9;
                obj18 = $result;
                url9 = url21;
                obj20 = anizipFanart;
                c00034 = c00035;
                obj17 = coroutine_suspended;
                banner6 = banner7;
                tvType3 = tvType6;
                Pair pair113 = (Pair) obj18;
                List subEps113 = (List) pair113.component1();
                List dubEps113 = (List) pair113.component2();
                C00042 c0004114 = new C00042(str, str2, str3, description6, detail8, studioNames5, status6, anilistId7, malId9, subEps113, dubEps113, null);
                c00034.L$0 = SpillingKt.nullOutSpilledVariable(url9);
                c00034.L$1 = SpillingKt.nullOutSpilledVariable(animeId6);
                c00034.L$2 = SpillingKt.nullOutSpilledVariable(detail8);
                c00034.L$3 = SpillingKt.nullOutSpilledVariable(title4);
                c00034.L$4 = SpillingKt.nullOutSpilledVariable(poster8);
                c00034.L$5 = SpillingKt.nullOutSpilledVariable(description6);
                c00034.L$6 = SpillingKt.nullOutSpilledVariable(status6);
                c00034.L$7 = SpillingKt.nullOutSpilledVariable(tvType3);
                c00034.L$8 = SpillingKt.nullOutSpilledVariable(anilistId7);
                c00034.L$9 = SpillingKt.nullOutSpilledVariable(malId9);
                c00034.L$10 = SpillingKt.nullOutSpilledVariable(banner6);
                c00034.L$11 = SpillingKt.nullOutSpilledVariable(studioNames5);
                c00034.L$12 = SpillingKt.nullOutSpilledVariable(anizip3);
                c00034.L$13 = SpillingKt.nullOutSpilledVariable(obj19);
                c00034.L$14 = SpillingKt.nullOutSpilledVariable(obj20);
                c00034.L$15 = SpillingKt.nullOutSpilledVariable(str);
                c00034.L$16 = SpillingKt.nullOutSpilledVariable(str2);
                c00034.L$17 = SpillingKt.nullOutSpilledVariable(str3);
                c00034.L$18 = SpillingKt.nullOutSpilledVariable(effectiveAnilistId2);
                c00034.L$19 = SpillingKt.nullOutSpilledVariable(subEps113);
                c00034.L$20 = SpillingKt.nullOutSpilledVariable(dubEps113);
                c00034.label = 5;
                obj22 = obj17;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, title4, url9, tvType3, false, c0004114, c00034, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == obj22) {
                    return obj22;
                }
                return objNewAnimeLoadResponse$default;
            case 5:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.phisher98.Reanime$load$2 */
    /* JADX INFO: compiled from: Reanime.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/AnimeLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Reanime$load$2", f = "Reanime.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nReanime.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Reanime.kt\ncom/phisher98/Reanime$load$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,944:1\n1#2:945\n*E\n"})
    static final class C00042 extends SuspendLambda implements Function2<AnimeLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ Integer $anilistId;
        final /* synthetic */ String $description;
        final /* synthetic */ AnimeDetail $detail;
        final /* synthetic */ List<Episode> $dubEps;
        final /* synthetic */ String $finalBanner;
        final /* synthetic */ String $finalPoster;
        final /* synthetic */ String $logoUrl;
        final /* synthetic */ Integer $malId;
        final /* synthetic */ ShowStatus $status;
        final /* synthetic */ List<String> $studioNames;
        final /* synthetic */ List<Episode> $subEps;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00042(String str, String str2, String str3, String str4, AnimeDetail animeDetail, List<String> list, ShowStatus showStatus, Integer num, Integer num2, List<Episode> list2, List<Episode> list3, Continuation<? super C00042> continuation) {
            super(2, continuation);
            this.$finalPoster = str;
            this.$finalBanner = str2;
            this.$logoUrl = str3;
            this.$description = str4;
            this.$detail = animeDetail;
            this.$studioNames = list;
            this.$status = showStatus;
            this.$anilistId = num;
            this.$malId = num2;
            this.$subEps = list2;
            this.$dubEps = list3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00042 = new C00042(this.$finalPoster, this.$finalBanner, this.$logoUrl, this.$description, this.$detail, this.$studioNames, this.$status, this.$anilistId, this.$malId, this.$subEps, this.$dubEps, continuation);
            c00042.L$0 = obj;
            return c00042;
        }

        public final Object invoke(AnimeLoadResponse animeLoadResponse, Continuation<? super Unit> continuation) {
            return create(animeLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Integer seasonYear;
            LoadResponse loadResponse = (AnimeLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    loadResponse.setPosterUrl(this.$finalPoster);
                    loadResponse.setBackgroundPosterUrl(this.$finalBanner);
                    try {
                        loadResponse.setLogoUrl(this.$logoUrl);
                        break;
                    } catch (Throwable th) {
                    }
                    loadResponse.setPlot(this.$description);
                    List<String> genres = this.$detail.getGenres();
                    if (genres == null) {
                        genres = CollectionsKt.emptyList();
                    }
                    List<String> list = genres;
                    List<String> listEmptyList = this.$studioNames;
                    if (listEmptyList == null) {
                        listEmptyList = CollectionsKt.emptyList();
                    }
                    loadResponse.setTags(CollectionsKt.plus(list, listEmptyList));
                    loadResponse.setShowStatus(this.$status);
                    StartDate startDate = this.$detail.getStartDate();
                    if (startDate == null || (seasonYear = startDate.getYear()) == null) {
                        seasonYear = this.$detail.getSeasonYear();
                    }
                    loadResponse.setYear(seasonYear);
                    Integer averageScore = this.$detail.getAverageScore();
                    if (averageScore != null) {
                        int it = averageScore.intValue();
                        loadResponse.setScore(Score.Companion.from10(String.valueOf(((double) it) / 10.0d)));
                    }
                    if (this.$anilistId != null) {
                        LoadResponse.Companion.addAniListId(loadResponse, this.$anilistId);
                    }
                    if (this.$malId != null) {
                        LoadResponse.Companion.addMalId(loadResponse, this.$malId);
                    }
                    MainAPIKt.addEpisodes(loadResponse, DubStatus.Subbed, this.$subEps);
                    MainAPIKt.addEpisodes(loadResponse, DubStatus.Dubbed, this.$dubEps);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:100:0x028b A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:111:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:115:0x02bd  */
    /* JADX WARN: Code duplicated, block: B:118:0x02c2  */
    /* JADX WARN: Code duplicated, block: B:120:0x02e2  */
    /* JADX WARN: Code duplicated, block: B:126:0x031f A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:127:0x0322  */
    /* JADX WARN: Code duplicated, block: B:131:0x032d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:132:0x032f  */
    /* JADX WARN: Code duplicated, block: B:134:0x0335  */
    /* JADX WARN: Code duplicated, block: B:138:0x0343 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:140:0x0346  */
    /* JADX WARN: Code duplicated, block: B:142:0x035a  */
    /* JADX WARN: Code duplicated, block: B:143:0x035d  */
    /* JADX WARN: Code duplicated, block: B:146:0x036a  */
    /* JADX WARN: Code duplicated, block: B:149:0x0376  */
    /* JADX WARN: Code duplicated, block: B:151:0x0379  */
    /* JADX WARN: Code duplicated, block: B:152:0x037b  */
    /* JADX WARN: Code duplicated, block: B:158:0x038f A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:15:0x0091  */
    /* JADX WARN: Code duplicated, block: B:160:0x0392  */
    /* JADX WARN: Code duplicated, block: B:161:0x0394  */
    /* JADX WARN: Code duplicated, block: B:166:0x03a8  */
    /* JADX WARN: Code duplicated, block: B:167:0x03ab A[PHI: r0
      0x03ab: PHI (r0v69 'it' java.lang.String) = (r0v43 'it' java.lang.String), (r0v70 'it' java.lang.String) binds: [B:159:0x0390, B:150:0x0377] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:170:0x03b4  */
    /* JADX WARN: Code duplicated, block: B:173:0x03c0  */
    /* JADX WARN: Code duplicated, block: B:176:0x03c4  */
    /* JADX WARN: Code duplicated, block: B:177:0x03c7  */
    /* JADX WARN: Code duplicated, block: B:178:0x03c9  */
    /* JADX WARN: Code duplicated, block: B:17:0x0115 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:183:0x03dd  */
    /* JADX WARN: Code duplicated, block: B:186:0x03e2  */
    /* JADX WARN: Code duplicated, block: B:18:0x0116  */
    /* JADX WARN: Code duplicated, block: B:191:0x03f5  */
    /* JADX WARN: Code duplicated, block: B:194:0x0432  */
    /* JADX WARN: Code duplicated, block: B:195:0x0435  */
    /* JADX WARN: Code duplicated, block: B:198:0x0457  */
    /* JADX WARN: Code duplicated, block: B:202:0x0469  */
    /* JADX WARN: Code duplicated, block: B:205:0x04a0  */
    /* JADX WARN: Code duplicated, block: B:207:0x04c6  */
    /* JADX WARN: Code duplicated, block: B:211:0x04f8  */
    /* JADX WARN: Code duplicated, block: B:212:0x04fd  */
    /* JADX WARN: Code duplicated, block: B:214:0x0500  */
    /* JADX WARN: Code duplicated, block: B:218:0x0528  */
    /* JADX WARN: Code duplicated, block: B:225:0x04e2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:229:0x04d4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x014d A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:32:0x0153  */
    /* JADX WARN: Code duplicated, block: B:40:0x0175  */
    /* JADX WARN: Code duplicated, block: B:42:0x0185  */
    /* JADX WARN: Code duplicated, block: B:44:0x0191  */
    /* JADX WARN: Code duplicated, block: B:45:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:47:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:49:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:52:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:53:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:54:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:56:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:59:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:61:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:62:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:65:0x0217  */
    /* JADX WARN: Code duplicated, block: B:66:0x021c  */
    /* JADX WARN: Code duplicated, block: B:69:0x0223  */
    /* JADX WARN: Code duplicated, block: B:78:0x0243  */
    /* JADX WARN: Code duplicated, block: B:79:0x0245  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:87:0x0264 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:89:0x0267  */
    /* JADX WARN: Code duplicated, block: B:90:0x0269  */
    /* JADX WARN: Code duplicated, block: B:98:0x0288 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0116 -> B:19:0x0122). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:194:0x0432
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object fetchAllEpisodes(java.lang.String r41, java.lang.Integer r42, int r43, int r44, com.phisher98.Reanime.AniZipResponse r45, kotlin.coroutines.Continuation<? super kotlin.Pair<? extends java.util.List<com.lagradost.cloudstream3.Episode>, ? extends java.util.List<com.lagradost.cloudstream3.Episode>>> r46) {
        /*
            Method dump skipped, instruction units count: 1348
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.Reanime.fetchAllEpisodes(java.lang.String, java.lang.Integer, int, int, com.phisher98.Reanime$AniZipResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit fetchAllEpisodes$lambda$0$10(String $epTitle, int $epNum, String $epDesc, String $epThumb, EpisodeData $ep, AniZipEpisode $anizipEp, Double $epRating, Episode $this$newEpisode) {
        $this$newEpisode.setName($epTitle);
        $this$newEpisode.setEpisode(Integer.valueOf($epNum));
        $this$newEpisode.setDescription($epDesc);
        $this$newEpisode.setPosterUrl($epThumb);
        String aired = $ep.getAired();
        if (aired == null) {
            aired = $anizipEp != null ? $anizipEp.getAirDateUtc() : null;
            if (aired == null) {
                aired = $anizipEp != null ? $anizipEp.getAirDate() : null;
            }
        }
        MainAPIKt.addDate$default($this$newEpisode, aired, (String) null, 2, (Object) null);
        if ($epRating != null) {
            double it = $epRating.doubleValue();
            $this$newEpisode.setScore(Score.Companion.from10(String.valueOf(it)));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit fetchAllEpisodes$lambda$0$11(String $epTitle, int $epNum, String $epDesc, String $epThumb, EpisodeData $ep, AniZipEpisode $anizipEp, Double $epRating, Episode $this$newEpisode) {
        $this$newEpisode.setName($epTitle);
        $this$newEpisode.setEpisode(Integer.valueOf($epNum));
        $this$newEpisode.setDescription($epDesc);
        $this$newEpisode.setPosterUrl($epThumb);
        String aired = $ep.getAired();
        if (aired == null) {
            aired = $anizipEp != null ? $anizipEp.getAirDateUtc() : null;
            if (aired == null) {
                aired = $anizipEp != null ? $anizipEp.getAirDate() : null;
            }
        }
        MainAPIKt.addDate$default($this$newEpisode, aired, (String) null, 2, (Object) null);
        if ($epRating != null) {
            double it = $epRating.doubleValue();
            $this$newEpisode.setScore(Score.Companion.from10(String.valueOf(it)));
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:230:0x0a92  */
    /* JADX WARN: Code duplicated, block: B:235:0x0aab  */
    /* JADX WARN: Code duplicated, block: B:238:0x0ab5  */
    /* JADX WARN: Code duplicated, block: B:241:0x0ac5  */
    /* JADX WARN: Code duplicated, block: B:250:0x0bbb A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:251:0x0bbc  */
    /* JADX WARN: Code duplicated, block: B:266:0x0cb1  */
    /* JADX WARN: Code duplicated, block: B:269:0x0cbd  */
    /* JADX WARN: Code duplicated, block: B:270:0x0cd9  */
    /* JADX WARN: Code duplicated, block: B:272:0x0d65 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:273:0x0d66  */
    /* JADX WARN: Code duplicated, block: B:276:0x0d93  */
    /* JADX WARN: Code duplicated, block: B:588:0x0aa4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:590:? A[LOOP:1: B:228:0x0a8c->B:590:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:269:0x0cbd -> B:278:0x0dba). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:273:0x0d66 -> B:274:0x0d8b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:378:0x124c -> B:576:0x1269). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:388:0x12db -> B:514:0x12f4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:405:0x1370 -> B:406:0x1387). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object loadLinks(@org.jetbrains.annotations.NotNull java.lang.String r71, boolean r72, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r73, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r74, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r75) {
        /*
            Method dump skipped, instruction units count: 5984
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.Reanime.loadLinks(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit loadLinks$lambda$5$0$0(Ref.BooleanRef $hasLinks, Function1 $callback, ExtractorLink linkObj) {
        $hasLinks.element = true;
        $callback.invoke(linkObj);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:70:0x02e2 A[Catch: all -> 0x041a, TRY_LEAVE, TryCatch #15 {all -> 0x041a, blocks: (B:68:0x02dc, B:70:0x02e2), top: B:193:0x02dc }] */
    /* JADX WARN: Code duplicated, block: B:74:0x0327 A[Catch: all -> 0x03d7, TRY_LEAVE, TryCatch #13 {all -> 0x03d7, blocks: (B:72:0x0310, B:74:0x0327), top: B:189:0x0310 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x0381 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:79:0x0382  */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    /* JADX WARN: Type inference failed for: r22v11 */
    /* JADX WARN: Type inference failed for: r22v12 */
    /* JADX WARN: Type inference failed for: r22v6, types: [boolean] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:79:0x0382 -> B:183:0x0398). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:84:0x03b7 -> B:85:0x03cf). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    public final java.lang.Object resolveFlixEmbed(java.lang.String r50, java.lang.String r51, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r52, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r53, kotlin.coroutines.Continuation<? super java.lang.Boolean> r54) {
        /*
            Method dump skipped, instruction units count: 1790
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.Reanime.resolveFlixEmbed(java.lang.String, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit resolveFlixEmbed$lambda$0$0(Ref.BooleanRef $found, Function1 $callback, ExtractorLink link) {
        $found.element = true;
        $callback.invoke(link);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.phisher98.Reanime$resolveFlixEmbed$4 */
    /* JADX INFO: compiled from: Reanime.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Reanime$resolveFlixEmbed$4", f = "Reanime.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00084 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C00084(Continuation<? super C00084> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00084 = new C00084(continuation);
            c00084.L$0 = obj;
            return c00084;
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
                    $this$newExtractorLink.setHeaders(MapsKt.mapOf(TuplesKt.to("Referer", "https://flixcloud.cc/")));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    @NotNull
    public Interceptor getVideoInterceptor(@NotNull ExtractorLink extractorLink) {
        return new Interceptor() { // from class: com.phisher98.Reanime$$ExternalSyntheticLambda6
            public final Response intercept(Interceptor.Chain chain) {
                return Reanime.getVideoInterceptor$lambda$0(chain);
            }
        };
    }

    static final Response getVideoInterceptor$lambda$0(Interceptor.Chain chain) {
        String rawUrl;
        String targetKeyUrl;
        Request request = chain.request();
        String url = request.url().toString();
        boolean isSegment = false;
        if (StringsKt.contains$default(url, "key.bin", false, 2, (Object) null)) {
            if (StringsKt.contains$default(url, "url=", false, 2, (Object) null)) {
                targetKeyUrl = request.url().queryParameter("url");
                if (targetKeyUrl == null) {
                    targetKeyUrl = lastFlixKeyUrl;
                }
            } else if (StringsKt.contains$default(url, "flixcloud.cc", false, 2, (Object) null)) {
                targetKeyUrl = url;
            } else {
                targetKeyUrl = lastFlixKeyUrl;
            }
            if (targetKeyUrl != null) {
                byte[] keyBytes = flixKeyCache.get(targetKeyUrl);
                if (keyBytes == null) {
                    keyBytes = (byte[]) BuildersKt.runBlockingK$default((CoroutineContext) null, new Reanime$getVideoInterceptor$1$keyBytes$1(targetKeyUrl, null), 1, (Object) null);
                }
                if (keyBytes != null) {
                    if (!(keyBytes.length == 0)) {
                        return new Response.Builder().code(200).message("OK").request(request).protocol(Protocol.HTTP_1_1).body(ResponseBody.Companion.create(keyBytes, MediaType.Companion.get("application/octet-stream"))).build();
                    }
                }
            }
        }
        Request.Builder reqBuilder = request.newBuilder();
        if (StringsKt.contains$default(url, "rundowncdn.top", false, 2, (Object) null) || StringsKt.contains$default(url, "atomic4cdn.top", false, 2, (Object) null) || StringsKt.contains$default(url, "flixcloud.cc", false, 2, (Object) null)) {
            reqBuilder.header("Referer", "https://flixcloud.cc/");
            reqBuilder.header("Origin", "https://flixcloud.cc");
        }
        Response response = chain.proceed(reqBuilder.build());
        if (StringsKt.contains$default(url, "parse-flixcloud", false, 2, (Object) null)) {
            MediaType contentType = response.body().contentType();
            String bodyText = response.body().string();
            if (StringsKt.contains$default(bodyText, "URI=\"key.bin\"", false, 2, (Object) null) && (rawUrl = request.url().queryParameter("url")) != null) {
                String keyUrl = StringsKt.substringBeforeLast$default(rawUrl, "/", (String) null, 2, (Object) null) + "/key.bin";
                lastFlixKeyUrl = keyUrl;
                String rewritten = StringsKt.replace$default(bodyText, "URI=\"key.bin\"", "URI=\"" + keyUrl + '\"', false, 4, (Object) null);
                return response.newBuilder().body(ResponseBody.Companion.create(rewritten, contentType)).build();
            }
            return response.newBuilder().body(ResponseBody.Companion.create(bodyText, contentType)).build();
        }
        if ((StringsKt.contains$default(url, ".webp", false, 2, (Object) null) || StringsKt.contains$default(url, ".png", false, 2, (Object) null) || StringsKt.contains$default(url, "seg-", false, 2, (Object) null) || StringsKt.contains$default(url, "rundowncdn.top", false, 2, (Object) null) || StringsKt.contains$default(url, "atomic4cdn.top", false, 2, (Object) null)) && !StringsKt.contains$default(url, ".m3u8", false, 2, (Object) null)) {
            isSegment = true;
        }
        if (isSegment && response.isSuccessful()) {
            ResponseBody body = response.body();
            byte[] bytes = body.bytes();
            byte[] deobfuscated = INSTANCE.deobfuscateSegment(bytes);
            return response.newBuilder().header("Content-Type", "video/mp2t").body(ResponseBody.Companion.create(deobfuscated, MediaType.Companion.get("video/mp2t"))).build();
        }
        return response;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:118:0x06be A[PHI: r1 r3 r4 r5 r6 r7 r8 r9 r10 r14 r15
      0x06be: PHI (r1v56 'response' com.phisher98.Reanime$SourcesResponse) = (r1v49 'response' com.phisher98.Reanime$SourcesResponse), (r1v57 'response' com.phisher98.Reanime$SourcesResponse) binds: [B:32:0x0212, B:117:0x06b5] A[DONT_GENERATE, DONT_INLINE]
      0x06be: PHI (r3v23 kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit>) = 
      (r3v19 kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit>)
      (r3v24 kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit>)
     binds: [B:32:0x0212, B:117:0x06b5] A[DONT_GENERATE, DONT_INLINE]
      0x06be: PHI (r4v52 kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit>) = 
      (r4v48 kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit>)
      (r4v54 kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit>)
     binds: [B:32:0x0212, B:117:0x06b5] A[DONT_GENERATE, DONT_INLINE]
      0x06be: PHI (r5v30 kotlin.coroutines.Continuation<? super kotlin.Unit>) = 
      (r5v18 kotlin.coroutines.Continuation<? super kotlin.Unit>)
      (r5v32 kotlin.coroutines.Continuation<? super kotlin.Unit>)
     binds: [B:32:0x0212, B:117:0x06b5] A[DONT_GENERATE, DONT_INLINE]
      0x06be: PHI (r6v40 com.phisher98.Reanime$processSourcesResponse$1) = (r6v36 com.phisher98.Reanime$processSourcesResponse$1), (r6v42 com.phisher98.Reanime$processSourcesResponse$1) binds: [B:32:0x0212, B:117:0x06b5] A[DONT_GENERATE, DONT_INLINE]
      0x06be: PHI (r7v52 '$result' java.lang.Object) = (r7v36 '$result' java.lang.Object), (r7v54 '$result' java.lang.Object) binds: [B:32:0x0212, B:117:0x06b5] A[DONT_GENERATE, DONT_INLINE]
      0x06be: PHI (r8v35 java.lang.Object) = (r8v31 java.lang.Object), (r8v36 java.lang.Object) binds: [B:32:0x0212, B:117:0x06b5] A[DONT_GENERATE, DONT_INLINE]
      0x06be: PHI (r9v47 '$i$f$forEach' int) = (r9v41 '$i$f$forEach' int), (r9v48 '$i$f$forEach' int) binds: [B:32:0x0212, B:117:0x06b5] A[DONT_GENERATE, DONT_INLINE]
      0x06be: PHI (r10v40 com.phisher98.Reanime) = (r10v38 com.phisher98.Reanime), (r10v41 com.phisher98.Reanime) binds: [B:32:0x0212, B:117:0x06b5] A[DONT_GENERATE, DONT_INLINE]
      0x06be: PHI (r14v30 java.util.Iterator) = (r14v28 java.util.Iterator), (r14v31 java.util.Iterator) binds: [B:32:0x0212, B:117:0x06b5] A[DONT_GENERATE, DONT_INLINE]
      0x06be: PHI (r15v27 '$this$forEach$iv' java.lang.Iterable) = (r15v25 '$this$forEach$iv' java.lang.Iterable), (r15v29 '$this$forEach$iv' java.lang.Iterable) binds: [B:32:0x0212, B:117:0x06b5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:31:0x0206  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:110:0x0603 -> B:117:0x06b5). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:116:0x0697 -> B:117:0x06b5). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:137:0x0758 -> B:138:0x0766). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0212 -> B:118:0x06be). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:80:0x0438 -> B:81:0x044b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    public final java.lang.Object processSourcesResponse(com.phisher98.Reanime.SourcesResponse r32, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r33, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r34, kotlin.coroutines.Continuation<? super kotlin.Unit> r35) {
        /*
            Method dump skipped, instruction units count: 1932
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.Reanime.processSourcesResponse(com.phisher98.Reanime$SourcesResponse, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final int resolveQuality(String q) {
        if (q == null) {
            return Qualities.Unknown.getValue();
        }
        if (StringsKt.contains$default(q, "2160", false, 2, (Object) null)) {
            return Qualities.P2160.getValue();
        }
        if (StringsKt.contains$default(q, "1080", false, 2, (Object) null)) {
            return Qualities.P1080.getValue();
        }
        if (StringsKt.contains$default(q, "720", false, 2, (Object) null)) {
            return Qualities.P720.getValue();
        }
        if (StringsKt.contains$default(q, "480", false, 2, (Object) null)) {
            return Qualities.P480.getValue();
        }
        return StringsKt.contains$default(q, "360", false, 2, (Object) null) ? Qualities.P360.getValue() : Qualities.Unknown.getValue();
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0018  */
    /* JADX WARN: Code duplicated, block: B:20:0x0031  */
    /* JADX WARN: Code duplicated, block: B:29:0x004a  */
    private final String preferredTitle(Title $this$preferredTitle) {
        String it;
        String it2;
        if ($this$preferredTitle == null || (it = $this$preferredTitle.getEnglish()) == null) {
            if ($this$preferredTitle != null || (it = $this$preferredTitle.getRomaji()) == null || StringsKt.isBlank(it)) {
                it = null;
            }
            if (it == null) {
                if ($this$preferredTitle != null || (it = $this$preferredTitle.getUserPreferred()) == null || StringsKt.isBlank(it)) {
                    it = null;
                }
                if (it == null) {
                    if ($this$preferredTitle != null || (it2 = $this$preferredTitle.getNative()) == null || StringsKt.isBlank(it2)) {
                        return null;
                    }
                    return it2;
                }
            }
        } else {
            if (StringsKt.isBlank(it)) {
                it = null;
            }
            if (it == null) {
                it = $this$preferredTitle != null ? null : null;
                if (it == null) {
                    it = $this$preferredTitle != null ? null : null;
                    if (it == null) {
                        return $this$preferredTitle != null ? null : null;
                    }
                }
            }
        }
        return it;
    }

    /* JADX INFO: compiled from: Reanime.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u001e\b\u0001\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u001e\b\u0001\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J[\u0010\u0014\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u001e\b\u0003\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b2\u001e\b\u0003\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\nHÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR-\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR-\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/phisher98/Reanime$HomeResponse;", "", "trending", "", "Lcom/phisher98/Reanime$HomeAnime;", "latestAired", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "latest_aired", "newOnSite", "new_on_site", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getTrending", "()Ljava/util/List;", "getLatestAired", "getNewOnSite", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Reanime"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class HomeResponse {

        @JsonProperty("latest_aired")
        @Nullable
        private final List<HomeAnime> latestAired;

        @JsonProperty("new_on_site")
        @Nullable
        private final List<HomeAnime> newOnSite;

        @Nullable
        private final List<HomeAnime> trending;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ HomeResponse copy$default(HomeResponse homeResponse, List list, List list2, List list3, int i, Object obj) {
            if ((i & 1) != 0) {
                list = homeResponse.trending;
            }
            if ((i & 2) != 0) {
                list2 = homeResponse.latestAired;
            }
            if ((i & 4) != 0) {
                list3 = homeResponse.newOnSite;
            }
            return homeResponse.copy(list, list2, list3);
        }

        @Nullable
        public final List<HomeAnime> component1() {
            return this.trending;
        }

        @Nullable
        public final List<HomeAnime> component2() {
            return this.latestAired;
        }

        @Nullable
        public final List<HomeAnime> component3() {
            return this.newOnSite;
        }

        @NotNull
        public final HomeResponse copy(@Nullable List<HomeAnime> trending, @JsonProperty("latest_aired") @Nullable List<HomeAnime> latestAired, @JsonProperty("new_on_site") @Nullable List<HomeAnime> newOnSite) {
            return new HomeResponse(trending, latestAired, newOnSite);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof HomeResponse)) {
                return false;
            }
            HomeResponse homeResponse = (HomeResponse) other;
            return Intrinsics.areEqual(this.trending, homeResponse.trending) && Intrinsics.areEqual(this.latestAired, homeResponse.latestAired) && Intrinsics.areEqual(this.newOnSite, homeResponse.newOnSite);
        }

        public int hashCode() {
            return ((((this.trending == null ? 0 : this.trending.hashCode()) * 31) + (this.latestAired == null ? 0 : this.latestAired.hashCode())) * 31) + (this.newOnSite != null ? this.newOnSite.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "HomeResponse(trending=" + this.trending + ", latestAired=" + this.latestAired + ", newOnSite=" + this.newOnSite + ')';
        }

        public HomeResponse(@Nullable List<HomeAnime> list, @JsonProperty("latest_aired") @Nullable List<HomeAnime> list2, @JsonProperty("new_on_site") @Nullable List<HomeAnime> list3) {
            this.trending = list;
            this.latestAired = list2;
            this.newOnSite = list3;
        }

        @Nullable
        public final List<HomeAnime> getTrending() {
            return this.trending;
        }

        @Nullable
        public final List<HomeAnime> getLatestAired() {
            return this.latestAired;
        }

        @Nullable
        public final List<HomeAnime> getNewOnSite() {
            return this.newOnSite;
        }
    }

    /* JADX INFO: compiled from: Reanime.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BÅ\u0001\u0012\u0018\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0018\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b\u0012\u0018\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\u0018\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u0013:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u00103\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0011HÆ\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010'J\u0010\u00105\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010'J\u0010\u00106\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010'J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÜ\u0001\u00109\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b2\u0018\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0018\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0013:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010:J\u0014\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010>\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010?\u001a\u00020\u0003HÖ\u0081\u0004R'\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR'\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R'\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001cR\u0019\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010(\u001a\u0004\b)\u0010'R)\u0010\u0015\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0016¢\u0006\n\n\u0002\u0010(\u001a\u0004\b*\u0010'R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001cR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001c¨\u0006@"}, d2 = {"Lcom/phisher98/Reanime$HomeAnime;", "", "animeId", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "anime_id", "title", "Lcom/phisher98/Reanime$Title;", "coverImage", "Lcom/phisher98/Reanime$CoverImage;", "cover_image", "bannerImage", "banner_image", "format", "status", "genres", "", "subbed", "", "dubbed", "averageScore", "average_score", "description", "rating", "<init>", "(Ljava/lang/String;Lcom/phisher98/Reanime$Title;Lcom/phisher98/Reanime$CoverImage;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getAnimeId", "()Ljava/lang/String;", "getTitle", "()Lcom/phisher98/Reanime$Title;", "getCoverImage", "()Lcom/phisher98/Reanime$CoverImage;", "getBannerImage", "getFormat", "getStatus", "getGenres", "()Ljava/util/List;", "getSubbed", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDubbed", "getAverageScore", "getDescription", "getRating", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/String;Lcom/phisher98/Reanime$Title;Lcom/phisher98/Reanime$CoverImage;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/phisher98/Reanime$HomeAnime;", "equals", "", "other", "hashCode", "toString", "Reanime"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class HomeAnime {

        @JsonProperty("anime_id")
        @Nullable
        private final String animeId;

        @JsonProperty("average_score")
        @Nullable
        private final Integer averageScore;

        @JsonProperty("banner_image")
        @Nullable
        private final String bannerImage;

        @JsonProperty("cover_image")
        @Nullable
        private final CoverImage coverImage;

        @Nullable
        private final String description;

        @Nullable
        private final Integer dubbed;

        @Nullable
        private final String format;

        @Nullable
        private final List<String> genres;

        @Nullable
        private final String rating;

        @Nullable
        private final String status;

        @Nullable
        private final Integer subbed;

        @Nullable
        private final Title title;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ HomeAnime copy$default(HomeAnime homeAnime, String str, Title title, CoverImage coverImage, String str2, String str3, String str4, List list, Integer num, Integer num2, Integer num3, String str5, String str6, int i, Object obj) {
            if ((i & 1) != 0) {
                str = homeAnime.animeId;
            }
            if ((i & 2) != 0) {
                title = homeAnime.title;
            }
            if ((i & 4) != 0) {
                coverImage = homeAnime.coverImage;
            }
            if ((i & 8) != 0) {
                str2 = homeAnime.bannerImage;
            }
            if ((i & 16) != 0) {
                str3 = homeAnime.format;
            }
            if ((i & 32) != 0) {
                str4 = homeAnime.status;
            }
            if ((i & 64) != 0) {
                list = homeAnime.genres;
            }
            if ((i & 128) != 0) {
                num = homeAnime.subbed;
            }
            if ((i & 256) != 0) {
                num2 = homeAnime.dubbed;
            }
            if ((i & 512) != 0) {
                num3 = homeAnime.averageScore;
            }
            if ((i & 1024) != 0) {
                str5 = homeAnime.description;
            }
            if ((i & 2048) != 0) {
                str6 = homeAnime.rating;
            }
            String str7 = str5;
            String str8 = str6;
            Integer num4 = num2;
            Integer num5 = num3;
            List list2 = list;
            Integer num6 = num;
            String str9 = str3;
            String str10 = str4;
            return homeAnime.copy(str, title, coverImage, str2, str9, str10, list2, num6, num4, num5, str7, str8);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getAnimeId() {
            return this.animeId;
        }

        @Nullable
        /* JADX INFO: renamed from: component10, reason: from getter */
        public final Integer getAverageScore() {
            return this.averageScore;
        }

        @Nullable
        /* JADX INFO: renamed from: component11, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        /* JADX INFO: renamed from: component12, reason: from getter */
        public final String getRating() {
            return this.rating;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Title getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final CoverImage getCoverImage() {
            return this.coverImage;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getBannerImage() {
            return this.bannerImage;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getFormat() {
            return this.format;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getStatus() {
            return this.status;
        }

        @Nullable
        public final List<String> component7() {
            return this.genres;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Integer getSubbed() {
            return this.subbed;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final Integer getDubbed() {
            return this.dubbed;
        }

        @NotNull
        public final HomeAnime copy(@JsonProperty("anime_id") @Nullable String animeId, @Nullable Title title, @JsonProperty("cover_image") @Nullable CoverImage coverImage, @JsonProperty("banner_image") @Nullable String bannerImage, @Nullable String format, @Nullable String status, @Nullable List<String> genres, @Nullable Integer subbed, @Nullable Integer dubbed, @JsonProperty("average_score") @Nullable Integer averageScore, @Nullable String description, @Nullable String rating) {
            return new HomeAnime(animeId, title, coverImage, bannerImage, format, status, genres, subbed, dubbed, averageScore, description, rating);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof HomeAnime)) {
                return false;
            }
            HomeAnime homeAnime = (HomeAnime) other;
            return Intrinsics.areEqual(this.animeId, homeAnime.animeId) && Intrinsics.areEqual(this.title, homeAnime.title) && Intrinsics.areEqual(this.coverImage, homeAnime.coverImage) && Intrinsics.areEqual(this.bannerImage, homeAnime.bannerImage) && Intrinsics.areEqual(this.format, homeAnime.format) && Intrinsics.areEqual(this.status, homeAnime.status) && Intrinsics.areEqual(this.genres, homeAnime.genres) && Intrinsics.areEqual(this.subbed, homeAnime.subbed) && Intrinsics.areEqual(this.dubbed, homeAnime.dubbed) && Intrinsics.areEqual(this.averageScore, homeAnime.averageScore) && Intrinsics.areEqual(this.description, homeAnime.description) && Intrinsics.areEqual(this.rating, homeAnime.rating);
        }

        public int hashCode() {
            return ((((((((((((((((((((((this.animeId == null ? 0 : this.animeId.hashCode()) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.coverImage == null ? 0 : this.coverImage.hashCode())) * 31) + (this.bannerImage == null ? 0 : this.bannerImage.hashCode())) * 31) + (this.format == null ? 0 : this.format.hashCode())) * 31) + (this.status == null ? 0 : this.status.hashCode())) * 31) + (this.genres == null ? 0 : this.genres.hashCode())) * 31) + (this.subbed == null ? 0 : this.subbed.hashCode())) * 31) + (this.dubbed == null ? 0 : this.dubbed.hashCode())) * 31) + (this.averageScore == null ? 0 : this.averageScore.hashCode())) * 31) + (this.description == null ? 0 : this.description.hashCode())) * 31) + (this.rating != null ? this.rating.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("HomeAnime(animeId=").append(this.animeId).append(", title=").append(this.title).append(", coverImage=").append(this.coverImage).append(", bannerImage=").append(this.bannerImage).append(", format=").append(this.format).append(", status=").append(this.status).append(", genres=").append(this.genres).append(", subbed=").append(this.subbed).append(", dubbed=").append(this.dubbed).append(", averageScore=").append(this.averageScore).append(", description=").append(this.description).append(", rating=");
            sb.append(this.rating).append(')');
            return sb.toString();
        }

        public HomeAnime(@JsonProperty("anime_id") @Nullable String animeId, @Nullable Title title, @JsonProperty("cover_image") @Nullable CoverImage coverImage, @JsonProperty("banner_image") @Nullable String bannerImage, @Nullable String format, @Nullable String status, @Nullable List<String> list, @Nullable Integer subbed, @Nullable Integer dubbed, @JsonProperty("average_score") @Nullable Integer averageScore, @Nullable String description, @Nullable String rating) {
            this.animeId = animeId;
            this.title = title;
            this.coverImage = coverImage;
            this.bannerImage = bannerImage;
            this.format = format;
            this.status = status;
            this.genres = list;
            this.subbed = subbed;
            this.dubbed = dubbed;
            this.averageScore = averageScore;
            this.description = description;
            this.rating = rating;
        }

        @Nullable
        public final String getAnimeId() {
            return this.animeId;
        }

        @Nullable
        public final Title getTitle() {
            return this.title;
        }

        @Nullable
        public final CoverImage getCoverImage() {
            return this.coverImage;
        }

        @Nullable
        public final String getBannerImage() {
            return this.bannerImage;
        }

        @Nullable
        public final String getFormat() {
            return this.format;
        }

        @Nullable
        public final String getStatus() {
            return this.status;
        }

        @Nullable
        public final List<String> getGenres() {
            return this.genres;
        }

        @Nullable
        public final Integer getSubbed() {
            return this.subbed;
        }

        @Nullable
        public final Integer getDubbed() {
            return this.dubbed;
        }

        @Nullable
        public final Integer getAverageScore() {
            return this.averageScore;
        }

        @Nullable
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        public final String getRating() {
            return this.rating;
        }
    }

    /* JADX INFO: compiled from: Reanime.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\fJ,\u0010\u0010\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/phisher98/Reanime$SearchResponse2;", "", "results", "", "Lcom/phisher98/Reanime$SearchAnime;", "total", "", "<init>", "(Ljava/util/List;Ljava/lang/Integer;)V", "getResults", "()Ljava/util/List;", "getTotal", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/util/List;Ljava/lang/Integer;)Lcom/phisher98/Reanime$SearchResponse2;", "equals", "", "other", "hashCode", "toString", "", "Reanime"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class SearchResponse2 {

        @Nullable
        private final List<SearchAnime> results;

        @Nullable
        private final Integer total;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SearchResponse2 copy$default(SearchResponse2 searchResponse2, List list, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                list = searchResponse2.results;
            }
            if ((i & 2) != 0) {
                num = searchResponse2.total;
            }
            return searchResponse2.copy(list, num);
        }

        @Nullable
        public final List<SearchAnime> component1() {
            return this.results;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getTotal() {
            return this.total;
        }

        @NotNull
        public final SearchResponse2 copy(@Nullable List<SearchAnime> results, @Nullable Integer total) {
            return new SearchResponse2(results, total);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SearchResponse2)) {
                return false;
            }
            SearchResponse2 searchResponse2 = (SearchResponse2) other;
            return Intrinsics.areEqual(this.results, searchResponse2.results) && Intrinsics.areEqual(this.total, searchResponse2.total);
        }

        public int hashCode() {
            return ((this.results == null ? 0 : this.results.hashCode()) * 31) + (this.total != null ? this.total.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "SearchResponse2(results=" + this.results + ", total=" + this.total + ')';
        }

        public SearchResponse2(@Nullable List<SearchAnime> list, @Nullable Integer total) {
            this.results = list;
            this.total = total;
        }

        @Nullable
        public final List<SearchAnime> getResults() {
            return this.results;
        }

        @Nullable
        public final Integer getTotal() {
            return this.total;
        }
    }

    /* JADX INFO: compiled from: Reanime.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\u0018\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0018\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\u0018\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u0011:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fHÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010-\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010.\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010\"Jª\u0001\u0010/\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0018\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0011:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0014HÆ\u0001¢\u0006\u0002\u00100J\u0014\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00104\u001a\u00020\u0011HÖ\u0081\u0004J\n\u00105\u001a\u00020\u0003HÖ\u0081\u0004R'\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR'\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0019\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010#\u001a\u0004\b$\u0010\"R)\u0010\u0013\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0014¢\u0006\n\n\u0002\u0010#\u001a\u0004\b%\u0010\"¨\u00066"}, d2 = {"Lcom/phisher98/Reanime$SearchAnime;", "", "animeId", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "anime_id", "title", "Lcom/phisher98/Reanime$Title;", "coverImage", "Lcom/phisher98/Reanime$CoverImage;", "cover_image", "format", "status", "genres", "", "subbed", "", "dubbed", "averageScore", "average_score", "<init>", "(Ljava/lang/String;Lcom/phisher98/Reanime$Title;Lcom/phisher98/Reanime$CoverImage;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getAnimeId", "()Ljava/lang/String;", "getTitle", "()Lcom/phisher98/Reanime$Title;", "getCoverImage", "()Lcom/phisher98/Reanime$CoverImage;", "getFormat", "getStatus", "getGenres", "()Ljava/util/List;", "getSubbed", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDubbed", "getAverageScore", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Lcom/phisher98/Reanime$Title;Lcom/phisher98/Reanime$CoverImage;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/phisher98/Reanime$SearchAnime;", "equals", "", "other", "hashCode", "toString", "Reanime"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class SearchAnime {

        @JsonProperty("anime_id")
        @Nullable
        private final String animeId;

        @JsonProperty("average_score")
        @Nullable
        private final Integer averageScore;

        @JsonProperty("cover_image")
        @Nullable
        private final CoverImage coverImage;

        @Nullable
        private final Integer dubbed;

        @Nullable
        private final String format;

        @Nullable
        private final List<String> genres;

        @Nullable
        private final String status;

        @Nullable
        private final Integer subbed;

        @Nullable
        private final Title title;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SearchAnime copy$default(SearchAnime searchAnime, String str, Title title, CoverImage coverImage, String str2, String str3, List list, Integer num, Integer num2, Integer num3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = searchAnime.animeId;
            }
            if ((i & 2) != 0) {
                title = searchAnime.title;
            }
            if ((i & 4) != 0) {
                coverImage = searchAnime.coverImage;
            }
            if ((i & 8) != 0) {
                str2 = searchAnime.format;
            }
            if ((i & 16) != 0) {
                str3 = searchAnime.status;
            }
            if ((i & 32) != 0) {
                list = searchAnime.genres;
            }
            if ((i & 64) != 0) {
                num = searchAnime.subbed;
            }
            if ((i & 128) != 0) {
                num2 = searchAnime.dubbed;
            }
            if ((i & 256) != 0) {
                num3 = searchAnime.averageScore;
            }
            Integer num4 = num2;
            Integer num5 = num3;
            List list2 = list;
            Integer num6 = num;
            String str4 = str3;
            CoverImage coverImage2 = coverImage;
            return searchAnime.copy(str, title, coverImage2, str2, str4, list2, num6, num4, num5);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getAnimeId() {
            return this.animeId;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Title getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final CoverImage getCoverImage() {
            return this.coverImage;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getFormat() {
            return this.format;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getStatus() {
            return this.status;
        }

        @Nullable
        public final List<String> component6() {
            return this.genres;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Integer getSubbed() {
            return this.subbed;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Integer getDubbed() {
            return this.dubbed;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final Integer getAverageScore() {
            return this.averageScore;
        }

        @NotNull
        public final SearchAnime copy(@JsonProperty("anime_id") @Nullable String animeId, @Nullable Title title, @JsonProperty("cover_image") @Nullable CoverImage coverImage, @Nullable String format, @Nullable String status, @Nullable List<String> genres, @Nullable Integer subbed, @Nullable Integer dubbed, @JsonProperty("average_score") @Nullable Integer averageScore) {
            return new SearchAnime(animeId, title, coverImage, format, status, genres, subbed, dubbed, averageScore);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SearchAnime)) {
                return false;
            }
            SearchAnime searchAnime = (SearchAnime) other;
            return Intrinsics.areEqual(this.animeId, searchAnime.animeId) && Intrinsics.areEqual(this.title, searchAnime.title) && Intrinsics.areEqual(this.coverImage, searchAnime.coverImage) && Intrinsics.areEqual(this.format, searchAnime.format) && Intrinsics.areEqual(this.status, searchAnime.status) && Intrinsics.areEqual(this.genres, searchAnime.genres) && Intrinsics.areEqual(this.subbed, searchAnime.subbed) && Intrinsics.areEqual(this.dubbed, searchAnime.dubbed) && Intrinsics.areEqual(this.averageScore, searchAnime.averageScore);
        }

        public int hashCode() {
            return ((((((((((((((((this.animeId == null ? 0 : this.animeId.hashCode()) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.coverImage == null ? 0 : this.coverImage.hashCode())) * 31) + (this.format == null ? 0 : this.format.hashCode())) * 31) + (this.status == null ? 0 : this.status.hashCode())) * 31) + (this.genres == null ? 0 : this.genres.hashCode())) * 31) + (this.subbed == null ? 0 : this.subbed.hashCode())) * 31) + (this.dubbed == null ? 0 : this.dubbed.hashCode())) * 31) + (this.averageScore != null ? this.averageScore.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "SearchAnime(animeId=" + this.animeId + ", title=" + this.title + ", coverImage=" + this.coverImage + ", format=" + this.format + ", status=" + this.status + ", genres=" + this.genres + ", subbed=" + this.subbed + ", dubbed=" + this.dubbed + ", averageScore=" + this.averageScore + ')';
        }

        public SearchAnime(@JsonProperty("anime_id") @Nullable String animeId, @Nullable Title title, @JsonProperty("cover_image") @Nullable CoverImage coverImage, @Nullable String format, @Nullable String status, @Nullable List<String> list, @Nullable Integer subbed, @Nullable Integer dubbed, @JsonProperty("average_score") @Nullable Integer averageScore) {
            this.animeId = animeId;
            this.title = title;
            this.coverImage = coverImage;
            this.format = format;
            this.status = status;
            this.genres = list;
            this.subbed = subbed;
            this.dubbed = dubbed;
            this.averageScore = averageScore;
        }

        @Nullable
        public final String getAnimeId() {
            return this.animeId;
        }

        @Nullable
        public final Title getTitle() {
            return this.title;
        }

        @Nullable
        public final CoverImage getCoverImage() {
            return this.coverImage;
        }

        @Nullable
        public final String getFormat() {
            return this.format;
        }

        @Nullable
        public final String getStatus() {
            return this.status;
        }

        @Nullable
        public final List<String> getGenres() {
            return this.genres;
        }

        @Nullable
        public final Integer getSubbed() {
            return this.subbed;
        }

        @Nullable
        public final Integer getDubbed() {
            return this.dubbed;
        }

        @Nullable
        public final Integer getAverageScore() {
            return this.averageScore;
        }
    }

    /* JADX INFO: compiled from: Reanime.kt */
    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b6\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0081\u0003\u0012\u0018\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t\u0012\u0018\b\u0001\u0010\n\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0018\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u000f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u0012\u0018\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\b\u0012\u0018\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001b\u0012\u0018\b\u0001\u0010\u001c\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001d\u0012\u0018\b\u0001\u0010\u001e\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001f\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0001\u0010\"\u001a\u0004\u0018\u00010#:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b($\u0012\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u0017\u0012\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\u0017\u0012\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010\u0017¢\u0006\u0004\b+\u0010,J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010J\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u00100J\u0010\u0010K\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u00100J\u000b\u0010L\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010R\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0017HÆ\u0003J\u0010\u0010S\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u00100J\u0010\u0010T\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u00100J\u0010\u0010U\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u00100J\u0010\u0010V\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u00100J\u0010\u0010W\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u00100J\u000b\u0010X\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010#HÆ\u0003J\u0011\u0010[\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u0017HÆ\u0003J\u0011\u0010\\\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\u0017HÆ\u0003J\u0011\u0010]\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010\u0017HÆ\u0003J \u0003\u0010^\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t2\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0018\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u000f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00102\u0018\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\b2\u0018\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001b2\u0018\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001d2\u0018\b\u0003\u0010\u001e\u001a\u0004\u0018\u00010\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00032\u0018\b\u0003\u0010\"\u001a\u0004\u0018\u00010#:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b($2\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u00172\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\u00172\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010\u0017HÆ\u0001¢\u0006\u0002\u0010_J\u0014\u0010`\u001a\u00020a2\b\u0010b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010c\u001a\u00020\bHÖ\u0081\u0004J\n\u0010d\u001a\u00020\u0003HÖ\u0081\u0004R'\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R)\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t¢\u0006\n\n\u0002\u00101\u001a\u0004\b/\u00100R)\u0010\n\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b¢\u0006\n\n\u0002\u00101\u001a\u0004\b2\u00100R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R'\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R'\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0012¢\u0006\b\n\u0000\u001a\u0004\b7\u0010.R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010.R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u0010.R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010.R\u0019\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u00101\u001a\u0004\b=\u00100R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u00101\u001a\u0004\b>\u00100R)\u0010\u001a\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001b¢\u0006\n\n\u0002\u00101\u001a\u0004\b?\u00100R)\u0010\u001c\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001d¢\u0006\n\n\u0002\u00101\u001a\u0004\b@\u00100R)\u0010\u001e\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001f¢\u0006\n\n\u0002\u00101\u001a\u0004\bA\u00100R\u0013\u0010 \u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bB\u0010.R\u0013\u0010!\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bC\u0010.R'\u0010\"\u001a\u0004\u0018\u00010#8\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b($¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0019\u0010%\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\bF\u0010<R\u0019\u0010'\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\bG\u0010<R\u0019\u0010)\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\bH\u0010<¨\u0006e"}, d2 = {"Lcom/phisher98/Reanime$AnimeDetail;", "", "animeId", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "anime_id", "anilistId", "", "anilist_id", "malId", "mal_id", "title", "Lcom/phisher98/Reanime$Title;", "coverImage", "Lcom/phisher98/Reanime$CoverImage;", "cover_image", "bannerImage", "banner_image", "description", "format", "status", "genres", "", "subbed", "dubbed", "averageScore", "average_score", "meanScore", "mean_score", "seasonYear", "season_year", "season", "rating", "startDate", "Lcom/phisher98/Reanime$StartDate;", "start_date", "studios", "Lcom/phisher98/Reanime$Studio;", "artworks", "Lcom/phisher98/Reanime$Artwork;", "tags", "Lcom/phisher98/Reanime$Tag;", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/phisher98/Reanime$Title;Lcom/phisher98/Reanime$CoverImage;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/phisher98/Reanime$StartDate;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getAnimeId", "()Ljava/lang/String;", "getAnilistId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMalId", "getTitle", "()Lcom/phisher98/Reanime$Title;", "getCoverImage", "()Lcom/phisher98/Reanime$CoverImage;", "getBannerImage", "getDescription", "getFormat", "getStatus", "getGenres", "()Ljava/util/List;", "getSubbed", "getDubbed", "getAverageScore", "getMeanScore", "getSeasonYear", "getSeason", "getRating", "getStartDate", "()Lcom/phisher98/Reanime$StartDate;", "getStudios", "getArtworks", "getTags", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/phisher98/Reanime$Title;Lcom/phisher98/Reanime$CoverImage;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/phisher98/Reanime$StartDate;Ljava/util/List;Ljava/util/List;Ljava/util/List;)Lcom/phisher98/Reanime$AnimeDetail;", "equals", "", "other", "hashCode", "toString", "Reanime"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class AnimeDetail {

        @JsonProperty("anilist_id")
        @Nullable
        private final Integer anilistId;

        @JsonProperty("anime_id")
        @Nullable
        private final String animeId;

        @Nullable
        private final List<Artwork> artworks;

        @JsonProperty("average_score")
        @Nullable
        private final Integer averageScore;

        @JsonProperty("banner_image")
        @Nullable
        private final String bannerImage;

        @JsonProperty("cover_image")
        @Nullable
        private final CoverImage coverImage;

        @Nullable
        private final String description;

        @Nullable
        private final Integer dubbed;

        @Nullable
        private final String format;

        @Nullable
        private final List<String> genres;

        @JsonProperty("mal_id")
        @Nullable
        private final Integer malId;

        @JsonProperty("mean_score")
        @Nullable
        private final Integer meanScore;

        @Nullable
        private final String rating;

        @Nullable
        private final String season;

        @JsonProperty("season_year")
        @Nullable
        private final Integer seasonYear;

        @JsonProperty("start_date")
        @Nullable
        private final StartDate startDate;

        @Nullable
        private final String status;

        @Nullable
        private final List<Studio> studios;

        @Nullable
        private final Integer subbed;

        @Nullable
        private final List<Tag> tags;

        @Nullable
        private final Title title;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AnimeDetail copy$default(AnimeDetail animeDetail, String str, Integer num, Integer num2, Title title, CoverImage coverImage, String str2, String str3, String str4, String str5, List list, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, String str6, String str7, StartDate startDate, List list2, List list3, List list4, int i, Object obj) {
            List list5;
            List list6;
            String str8 = (i & 1) != 0 ? animeDetail.animeId : str;
            Integer num8 = (i & 2) != 0 ? animeDetail.anilistId : num;
            Integer num9 = (i & 4) != 0 ? animeDetail.malId : num2;
            Title title2 = (i & 8) != 0 ? animeDetail.title : title;
            CoverImage coverImage2 = (i & 16) != 0 ? animeDetail.coverImage : coverImage;
            String str9 = (i & 32) != 0 ? animeDetail.bannerImage : str2;
            String str10 = (i & 64) != 0 ? animeDetail.description : str3;
            String str11 = (i & 128) != 0 ? animeDetail.format : str4;
            String str12 = (i & 256) != 0 ? animeDetail.status : str5;
            List list7 = (i & 512) != 0 ? animeDetail.genres : list;
            Integer num10 = (i & 1024) != 0 ? animeDetail.subbed : num3;
            Integer num11 = (i & 2048) != 0 ? animeDetail.dubbed : num4;
            Integer num12 = (i & 4096) != 0 ? animeDetail.averageScore : num5;
            Integer num13 = (i & 8192) != 0 ? animeDetail.meanScore : num6;
            String str13 = str8;
            Integer num14 = (i & 16384) != 0 ? animeDetail.seasonYear : num7;
            String str14 = (i & 32768) != 0 ? animeDetail.season : str6;
            String str15 = (i & 65536) != 0 ? animeDetail.rating : str7;
            StartDate startDate2 = (i & 131072) != 0 ? animeDetail.startDate : startDate;
            List list8 = (i & 262144) != 0 ? animeDetail.studios : list2;
            List list9 = (i & 524288) != 0 ? animeDetail.artworks : list3;
            if ((i & 1048576) != 0) {
                list6 = list9;
                list5 = animeDetail.tags;
            } else {
                list5 = list4;
                list6 = list9;
            }
            return animeDetail.copy(str13, num8, num9, title2, coverImage2, str9, str10, str11, str12, list7, num10, num11, num12, num13, num14, str14, str15, startDate2, list8, list6, list5);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getAnimeId() {
            return this.animeId;
        }

        @Nullable
        public final List<String> component10() {
            return this.genres;
        }

        @Nullable
        /* JADX INFO: renamed from: component11, reason: from getter */
        public final Integer getSubbed() {
            return this.subbed;
        }

        @Nullable
        /* JADX INFO: renamed from: component12, reason: from getter */
        public final Integer getDubbed() {
            return this.dubbed;
        }

        @Nullable
        /* JADX INFO: renamed from: component13, reason: from getter */
        public final Integer getAverageScore() {
            return this.averageScore;
        }

        @Nullable
        /* JADX INFO: renamed from: component14, reason: from getter */
        public final Integer getMeanScore() {
            return this.meanScore;
        }

        @Nullable
        /* JADX INFO: renamed from: component15, reason: from getter */
        public final Integer getSeasonYear() {
            return this.seasonYear;
        }

        @Nullable
        /* JADX INFO: renamed from: component16, reason: from getter */
        public final String getSeason() {
            return this.season;
        }

        @Nullable
        /* JADX INFO: renamed from: component17, reason: from getter */
        public final String getRating() {
            return this.rating;
        }

        @Nullable
        /* JADX INFO: renamed from: component18, reason: from getter */
        public final StartDate getStartDate() {
            return this.startDate;
        }

        @Nullable
        public final List<Studio> component19() {
            return this.studios;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getAnilistId() {
            return this.anilistId;
        }

        @Nullable
        public final List<Artwork> component20() {
            return this.artworks;
        }

        @Nullable
        public final List<Tag> component21() {
            return this.tags;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getMalId() {
            return this.malId;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Title getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final CoverImage getCoverImage() {
            return this.coverImage;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getBannerImage() {
            return this.bannerImage;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getFormat() {
            return this.format;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getStatus() {
            return this.status;
        }

        @NotNull
        public final AnimeDetail copy(@JsonProperty("anime_id") @Nullable String animeId, @JsonProperty("anilist_id") @Nullable Integer anilistId, @JsonProperty("mal_id") @Nullable Integer malId, @Nullable Title title, @JsonProperty("cover_image") @Nullable CoverImage coverImage, @JsonProperty("banner_image") @Nullable String bannerImage, @Nullable String description, @Nullable String format, @Nullable String status, @Nullable List<String> genres, @Nullable Integer subbed, @Nullable Integer dubbed, @JsonProperty("average_score") @Nullable Integer averageScore, @JsonProperty("mean_score") @Nullable Integer meanScore, @JsonProperty("season_year") @Nullable Integer seasonYear, @Nullable String season, @Nullable String rating, @JsonProperty("start_date") @Nullable StartDate startDate, @Nullable List<Studio> studios, @Nullable List<Artwork> artworks, @Nullable List<Tag> tags) {
            return new AnimeDetail(animeId, anilistId, malId, title, coverImage, bannerImage, description, format, status, genres, subbed, dubbed, averageScore, meanScore, seasonYear, season, rating, startDate, studios, artworks, tags);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AnimeDetail)) {
                return false;
            }
            AnimeDetail animeDetail = (AnimeDetail) other;
            return Intrinsics.areEqual(this.animeId, animeDetail.animeId) && Intrinsics.areEqual(this.anilistId, animeDetail.anilistId) && Intrinsics.areEqual(this.malId, animeDetail.malId) && Intrinsics.areEqual(this.title, animeDetail.title) && Intrinsics.areEqual(this.coverImage, animeDetail.coverImage) && Intrinsics.areEqual(this.bannerImage, animeDetail.bannerImage) && Intrinsics.areEqual(this.description, animeDetail.description) && Intrinsics.areEqual(this.format, animeDetail.format) && Intrinsics.areEqual(this.status, animeDetail.status) && Intrinsics.areEqual(this.genres, animeDetail.genres) && Intrinsics.areEqual(this.subbed, animeDetail.subbed) && Intrinsics.areEqual(this.dubbed, animeDetail.dubbed) && Intrinsics.areEqual(this.averageScore, animeDetail.averageScore) && Intrinsics.areEqual(this.meanScore, animeDetail.meanScore) && Intrinsics.areEqual(this.seasonYear, animeDetail.seasonYear) && Intrinsics.areEqual(this.season, animeDetail.season) && Intrinsics.areEqual(this.rating, animeDetail.rating) && Intrinsics.areEqual(this.startDate, animeDetail.startDate) && Intrinsics.areEqual(this.studios, animeDetail.studios) && Intrinsics.areEqual(this.artworks, animeDetail.artworks) && Intrinsics.areEqual(this.tags, animeDetail.tags);
        }

        public int hashCode() {
            return ((((((((((((((((((((((((((((((((((((((((this.animeId == null ? 0 : this.animeId.hashCode()) * 31) + (this.anilistId == null ? 0 : this.anilistId.hashCode())) * 31) + (this.malId == null ? 0 : this.malId.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.coverImage == null ? 0 : this.coverImage.hashCode())) * 31) + (this.bannerImage == null ? 0 : this.bannerImage.hashCode())) * 31) + (this.description == null ? 0 : this.description.hashCode())) * 31) + (this.format == null ? 0 : this.format.hashCode())) * 31) + (this.status == null ? 0 : this.status.hashCode())) * 31) + (this.genres == null ? 0 : this.genres.hashCode())) * 31) + (this.subbed == null ? 0 : this.subbed.hashCode())) * 31) + (this.dubbed == null ? 0 : this.dubbed.hashCode())) * 31) + (this.averageScore == null ? 0 : this.averageScore.hashCode())) * 31) + (this.meanScore == null ? 0 : this.meanScore.hashCode())) * 31) + (this.seasonYear == null ? 0 : this.seasonYear.hashCode())) * 31) + (this.season == null ? 0 : this.season.hashCode())) * 31) + (this.rating == null ? 0 : this.rating.hashCode())) * 31) + (this.startDate == null ? 0 : this.startDate.hashCode())) * 31) + (this.studios == null ? 0 : this.studios.hashCode())) * 31) + (this.artworks == null ? 0 : this.artworks.hashCode())) * 31) + (this.tags != null ? this.tags.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("AnimeDetail(animeId=").append(this.animeId).append(", anilistId=").append(this.anilistId).append(", malId=").append(this.malId).append(", title=").append(this.title).append(", coverImage=").append(this.coverImage).append(", bannerImage=").append(this.bannerImage).append(", description=").append(this.description).append(", format=").append(this.format).append(", status=").append(this.status).append(", genres=").append(this.genres).append(", subbed=").append(this.subbed).append(", dubbed=");
            sb.append(this.dubbed).append(", averageScore=").append(this.averageScore).append(", meanScore=").append(this.meanScore).append(", seasonYear=").append(this.seasonYear).append(", season=").append(this.season).append(", rating=").append(this.rating).append(", startDate=").append(this.startDate).append(", studios=").append(this.studios).append(", artworks=").append(this.artworks).append(", tags=").append(this.tags).append(')');
            return sb.toString();
        }

        public AnimeDetail(@JsonProperty("anime_id") @Nullable String animeId, @JsonProperty("anilist_id") @Nullable Integer anilistId, @JsonProperty("mal_id") @Nullable Integer malId, @Nullable Title title, @JsonProperty("cover_image") @Nullable CoverImage coverImage, @JsonProperty("banner_image") @Nullable String bannerImage, @Nullable String description, @Nullable String format, @Nullable String status, @Nullable List<String> list, @Nullable Integer subbed, @Nullable Integer dubbed, @JsonProperty("average_score") @Nullable Integer averageScore, @JsonProperty("mean_score") @Nullable Integer meanScore, @JsonProperty("season_year") @Nullable Integer seasonYear, @Nullable String season, @Nullable String rating, @JsonProperty("start_date") @Nullable StartDate startDate, @Nullable List<Studio> list2, @Nullable List<Artwork> list3, @Nullable List<Tag> list4) {
            this.animeId = animeId;
            this.anilistId = anilistId;
            this.malId = malId;
            this.title = title;
            this.coverImage = coverImage;
            this.bannerImage = bannerImage;
            this.description = description;
            this.format = format;
            this.status = status;
            this.genres = list;
            this.subbed = subbed;
            this.dubbed = dubbed;
            this.averageScore = averageScore;
            this.meanScore = meanScore;
            this.seasonYear = seasonYear;
            this.season = season;
            this.rating = rating;
            this.startDate = startDate;
            this.studios = list2;
            this.artworks = list3;
            this.tags = list4;
        }

        @Nullable
        public final String getAnimeId() {
            return this.animeId;
        }

        @Nullable
        public final Integer getAnilistId() {
            return this.anilistId;
        }

        @Nullable
        public final Integer getMalId() {
            return this.malId;
        }

        @Nullable
        public final Title getTitle() {
            return this.title;
        }

        @Nullable
        public final CoverImage getCoverImage() {
            return this.coverImage;
        }

        @Nullable
        public final String getBannerImage() {
            return this.bannerImage;
        }

        @Nullable
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        public final String getFormat() {
            return this.format;
        }

        @Nullable
        public final String getStatus() {
            return this.status;
        }

        @Nullable
        public final List<String> getGenres() {
            return this.genres;
        }

        @Nullable
        public final Integer getSubbed() {
            return this.subbed;
        }

        @Nullable
        public final Integer getDubbed() {
            return this.dubbed;
        }

        @Nullable
        public final Integer getAverageScore() {
            return this.averageScore;
        }

        @Nullable
        public final Integer getMeanScore() {
            return this.meanScore;
        }

        @Nullable
        public final Integer getSeasonYear() {
            return this.seasonYear;
        }

        @Nullable
        public final String getSeason() {
            return this.season;
        }

        @Nullable
        public final String getRating() {
            return this.rating;
        }

        @Nullable
        public final StartDate getStartDate() {
            return this.startDate;
        }

        @Nullable
        public final List<Studio> getStudios() {
            return this.studios;
        }

        @Nullable
        public final List<Artwork> getArtworks() {
            return this.artworks;
        }

        @Nullable
        public final List<Tag> getTags() {
            return this.tags;
        }
    }

    /* JADX INFO: compiled from: Reanime.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ2\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/phisher98/Reanime$StartDate;", "", "day", "", "month", "year", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getDay", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMonth", "getYear", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/phisher98/Reanime$StartDate;", "equals", "", "other", "hashCode", "toString", "", "Reanime"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class StartDate {

        @Nullable
        private final Integer day;

        @Nullable
        private final Integer month;

        @Nullable
        private final Integer year;

        public static /* synthetic */ StartDate copy$default(StartDate startDate, Integer num, Integer num2, Integer num3, int i, Object obj) {
            if ((i & 1) != 0) {
                num = startDate.day;
            }
            if ((i & 2) != 0) {
                num2 = startDate.month;
            }
            if ((i & 4) != 0) {
                num3 = startDate.year;
            }
            return startDate.copy(num, num2, num3);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getDay() {
            return this.day;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getMonth() {
            return this.month;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getYear() {
            return this.year;
        }

        @NotNull
        public final StartDate copy(@Nullable Integer day, @Nullable Integer month, @Nullable Integer year) {
            return new StartDate(day, month, year);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StartDate)) {
                return false;
            }
            StartDate startDate = (StartDate) other;
            return Intrinsics.areEqual(this.day, startDate.day) && Intrinsics.areEqual(this.month, startDate.month) && Intrinsics.areEqual(this.year, startDate.year);
        }

        public int hashCode() {
            return ((((this.day == null ? 0 : this.day.hashCode()) * 31) + (this.month == null ? 0 : this.month.hashCode())) * 31) + (this.year != null ? this.year.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "StartDate(day=" + this.day + ", month=" + this.month + ", year=" + this.year + ')';
        }

        public StartDate(@Nullable Integer day, @Nullable Integer month, @Nullable Integer year) {
            this.day = day;
            this.month = month;
            this.year = year;
        }

        @Nullable
        public final Integer getDay() {
            return this.day;
        }

        @Nullable
        public final Integer getMonth() {
            return this.month;
        }

        @Nullable
        public final Integer getYear() {
            return this.year;
        }
    }

    /* JADX INFO: compiled from: Reanime.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0018\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0012J@\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\nHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0014\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u0005HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R)\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u0092\u0002\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0006\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/phisher98/Reanime$Studio;", "", "id", "", "name", "", "isMain", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "is_main", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/phisher98/Reanime$Studio;", "equals", "other", "hashCode", "toString", "Reanime"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Studio {

        @Nullable
        private final Integer id;

        @JsonProperty("is_main")
        @Nullable
        private final Boolean isMain;

        @Nullable
        private final String name;

        public static /* synthetic */ Studio copy$default(Studio studio, Integer num, String str, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                num = studio.id;
            }
            if ((i & 2) != 0) {
                str = studio.name;
            }
            if ((i & 4) != 0) {
                bool = studio.isMain;
            }
            return studio.copy(num, str, bool);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Boolean getIsMain() {
            return this.isMain;
        }

        @NotNull
        public final Studio copy(@Nullable Integer id, @Nullable String name, @JsonProperty("is_main") @Nullable Boolean isMain) {
            return new Studio(id, name, isMain);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Studio)) {
                return false;
            }
            Studio studio = (Studio) other;
            return Intrinsics.areEqual(this.id, studio.id) && Intrinsics.areEqual(this.name, studio.name) && Intrinsics.areEqual(this.isMain, studio.isMain);
        }

        public int hashCode() {
            return ((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.isMain != null ? this.isMain.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Studio(id=" + this.id + ", name=" + this.name + ", isMain=" + this.isMain + ')';
        }

        public Studio(@Nullable Integer id, @Nullable String name, @JsonProperty("is_main") @Nullable Boolean isMain) {
            this.id = id;
            this.name = name;
            this.isMain = isMain;
        }

        @Nullable
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        public final String getName() {
            return this.name;
        }

        @Nullable
        public final Boolean isMain() {
            return this.isMain;
        }
    }

    /* JADX INFO: compiled from: Reanime.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0018\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J;\u0010\u0012\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R'\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/phisher98/Reanime$Artwork;", "", "imageType", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "image_type", "url", "source", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getImageType", "()Ljava/lang/String;", "getUrl", "getSource", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Reanime"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Artwork {

        @JsonProperty("image_type")
        @Nullable
        private final String imageType;

        @Nullable
        private final String source;

        @Nullable
        private final String url;

        public static /* synthetic */ Artwork copy$default(Artwork artwork, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = artwork.imageType;
            }
            if ((i & 2) != 0) {
                str2 = artwork.url;
            }
            if ((i & 4) != 0) {
                str3 = artwork.source;
            }
            return artwork.copy(str, str2, str3);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getImageType() {
            return this.imageType;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getSource() {
            return this.source;
        }

        @NotNull
        public final Artwork copy(@JsonProperty("image_type") @Nullable String imageType, @Nullable String url, @Nullable String source) {
            return new Artwork(imageType, url, source);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Artwork)) {
                return false;
            }
            Artwork artwork = (Artwork) other;
            return Intrinsics.areEqual(this.imageType, artwork.imageType) && Intrinsics.areEqual(this.url, artwork.url) && Intrinsics.areEqual(this.source, artwork.source);
        }

        public int hashCode() {
            return ((((this.imageType == null ? 0 : this.imageType.hashCode()) * 31) + (this.url == null ? 0 : this.url.hashCode())) * 31) + (this.source != null ? this.source.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Artwork(imageType=" + this.imageType + ", url=" + this.url + ", source=" + this.source + ')';
        }

        public Artwork(@JsonProperty("image_type") @Nullable String imageType, @Nullable String url, @Nullable String source) {
            this.imageType = imageType;
            this.url = url;
            this.source = source;
        }

        @Nullable
        public final String getImageType() {
            return this.imageType;
        }

        @Nullable
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        public final String getSource() {
            return this.source;
        }
    }

    /* JADX INFO: compiled from: Reanime.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0018\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b:\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0014JL\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b:\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000bHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0014\u0010\u001c\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010\u001f\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R)\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u0092\u0002\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0007\u0010\u0014¨\u0006 "}, d2 = {"Lcom/phisher98/Reanime$Tag;", "", "name", "", "category", "rank", "", "isAdult", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "is_adult", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getName", "()Ljava/lang/String;", "getCategory", "getRank", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;)Lcom/phisher98/Reanime$Tag;", "equals", "other", "hashCode", "toString", "Reanime"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Tag {

        @Nullable
        private final String category;

        @JsonProperty("is_adult")
        @Nullable
        private final Boolean isAdult;

        @Nullable
        private final String name;

        @Nullable
        private final Integer rank;

        public static /* synthetic */ Tag copy$default(Tag tag, String str, String str2, Integer num, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                str = tag.name;
            }
            if ((i & 2) != 0) {
                str2 = tag.category;
            }
            if ((i & 4) != 0) {
                num = tag.rank;
            }
            if ((i & 8) != 0) {
                bool = tag.isAdult;
            }
            return tag.copy(str, str2, num, bool);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getCategory() {
            return this.category;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getRank() {
            return this.rank;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Boolean getIsAdult() {
            return this.isAdult;
        }

        @NotNull
        public final Tag copy(@Nullable String name, @Nullable String category, @Nullable Integer rank, @JsonProperty("is_adult") @Nullable Boolean isAdult) {
            return new Tag(name, category, rank, isAdult);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Tag)) {
                return false;
            }
            Tag tag = (Tag) other;
            return Intrinsics.areEqual(this.name, tag.name) && Intrinsics.areEqual(this.category, tag.category) && Intrinsics.areEqual(this.rank, tag.rank) && Intrinsics.areEqual(this.isAdult, tag.isAdult);
        }

        public int hashCode() {
            return ((((((this.name == null ? 0 : this.name.hashCode()) * 31) + (this.category == null ? 0 : this.category.hashCode())) * 31) + (this.rank == null ? 0 : this.rank.hashCode())) * 31) + (this.isAdult != null ? this.isAdult.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Tag(name=" + this.name + ", category=" + this.category + ", rank=" + this.rank + ", isAdult=" + this.isAdult + ')';
        }

        public Tag(@Nullable String name, @Nullable String category, @Nullable Integer rank, @JsonProperty("is_adult") @Nullable Boolean isAdult) {
            this.name = name;
            this.category = category;
            this.rank = rank;
            this.isAdult = isAdult;
        }

        @Nullable
        public final String getName() {
            return this.name;
        }

        @Nullable
        public final String getCategory() {
            return this.category;
        }

        @Nullable
        public final Integer getRank() {
            return this.rank;
        }

        @Nullable
        public final Boolean isAdult() {
            return this.isAdult;
        }
    }

    /* JADX INFO: compiled from: Reanime.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJD\u0010\u0016\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0014\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/phisher98/Reanime$EpisodesResponse;", "", "data", "", "Lcom/phisher98/Reanime$EpisodeData;", "total", "", "offset", "limit", "<init>", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getData", "()Ljava/util/List;", "getTotal", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getOffset", "getLimit", "component1", "component2", "component3", "component4", "copy", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/phisher98/Reanime$EpisodesResponse;", "equals", "", "other", "hashCode", "toString", "", "Reanime"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class EpisodesResponse {

        @Nullable
        private final List<EpisodeData> data;

        @Nullable
        private final Integer limit;

        @Nullable
        private final Integer offset;

        @Nullable
        private final Integer total;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ EpisodesResponse copy$default(EpisodesResponse episodesResponse, List list, Integer num, Integer num2, Integer num3, int i, Object obj) {
            if ((i & 1) != 0) {
                list = episodesResponse.data;
            }
            if ((i & 2) != 0) {
                num = episodesResponse.total;
            }
            if ((i & 4) != 0) {
                num2 = episodesResponse.offset;
            }
            if ((i & 8) != 0) {
                num3 = episodesResponse.limit;
            }
            return episodesResponse.copy(list, num, num2, num3);
        }

        @Nullable
        public final List<EpisodeData> component1() {
            return this.data;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getTotal() {
            return this.total;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getOffset() {
            return this.offset;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Integer getLimit() {
            return this.limit;
        }

        @NotNull
        public final EpisodesResponse copy(@Nullable List<EpisodeData> data, @Nullable Integer total, @Nullable Integer offset, @Nullable Integer limit) {
            return new EpisodesResponse(data, total, offset, limit);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EpisodesResponse)) {
                return false;
            }
            EpisodesResponse episodesResponse = (EpisodesResponse) other;
            return Intrinsics.areEqual(this.data, episodesResponse.data) && Intrinsics.areEqual(this.total, episodesResponse.total) && Intrinsics.areEqual(this.offset, episodesResponse.offset) && Intrinsics.areEqual(this.limit, episodesResponse.limit);
        }

        public int hashCode() {
            return ((((((this.data == null ? 0 : this.data.hashCode()) * 31) + (this.total == null ? 0 : this.total.hashCode())) * 31) + (this.offset == null ? 0 : this.offset.hashCode())) * 31) + (this.limit != null ? this.limit.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "EpisodesResponse(data=" + this.data + ", total=" + this.total + ", offset=" + this.offset + ", limit=" + this.limit + ')';
        }

        public EpisodesResponse(@Nullable List<EpisodeData> list, @Nullable Integer total, @Nullable Integer offset, @Nullable Integer limit) {
            this.data = list;
            this.total = total;
            this.offset = offset;
            this.limit = limit;
        }

        @Nullable
        public final List<EpisodeData> getData() {
            return this.data;
        }

        @Nullable
        public final Integer getTotal() {
            return this.total;
        }

        @Nullable
        public final Integer getOffset() {
            return this.offset;
        }

        @Nullable
        public final Integer getLimit() {
            return this.limit;
        }
    }

    /* JADX INFO: compiled from: Reanime.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b#\b\u0086\b\u0018\u00002\u00020\u0001B\u0091\u0001\u0012\u0018\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u0018\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010'\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010(\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J¤\u0001\u0010*\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0018\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010+J\u0014\u0010,\u001a\u00020\r2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010.\u001a\u00020\u0007HÖ\u0081\u0004J\n\u0010/\u001a\u00020\u0003HÖ\u0081\u0004R'\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R)\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001f\u0010\u001dR)\u0010\u000f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u000f\u0010\u001dR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015¨\u00060"}, d2 = {"Lcom/phisher98/Reanime$EpisodeData;", "", "episodeId", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "episodeNumber", "", "episode_number", "title", "description", "thumbnail", "subbed", "", "dubbed", "isFiller", "is_filler", "aired", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)V", "getEpisodeId", "()Ljava/lang/String;", "getEpisodeNumber", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTitle", "getDescription", "getThumbnail", "getSubbed", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getDubbed", "getAired", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/phisher98/Reanime$EpisodeData;", "equals", "other", "hashCode", "toString", "Reanime"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class EpisodeData {

        @Nullable
        private final String aired;

        @Nullable
        private final String description;

        @Nullable
        private final Boolean dubbed;

        @JsonProperty("episodeId")
        @Nullable
        private final String episodeId;

        @JsonProperty("episode_number")
        @Nullable
        private final Integer episodeNumber;

        @JsonProperty("is_filler")
        @Nullable
        private final Boolean isFiller;

        @Nullable
        private final Boolean subbed;

        @Nullable
        private final String thumbnail;

        @Nullable
        private final String title;

        public static /* synthetic */ EpisodeData copy$default(EpisodeData episodeData, String str, Integer num, String str2, String str3, String str4, Boolean bool, Boolean bool2, Boolean bool3, String str5, int i, Object obj) {
            if ((i & 1) != 0) {
                str = episodeData.episodeId;
            }
            if ((i & 2) != 0) {
                num = episodeData.episodeNumber;
            }
            if ((i & 4) != 0) {
                str2 = episodeData.title;
            }
            if ((i & 8) != 0) {
                str3 = episodeData.description;
            }
            if ((i & 16) != 0) {
                str4 = episodeData.thumbnail;
            }
            if ((i & 32) != 0) {
                bool = episodeData.subbed;
            }
            if ((i & 64) != 0) {
                bool2 = episodeData.dubbed;
            }
            if ((i & 128) != 0) {
                bool3 = episodeData.isFiller;
            }
            if ((i & 256) != 0) {
                str5 = episodeData.aired;
            }
            Boolean bool4 = bool3;
            String str6 = str5;
            Boolean bool5 = bool;
            Boolean bool6 = bool2;
            String str7 = str4;
            String str8 = str2;
            return episodeData.copy(str, num, str8, str3, str7, bool5, bool6, bool4, str6);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getEpisodeId() {
            return this.episodeId;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getEpisodeNumber() {
            return this.episodeNumber;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getThumbnail() {
            return this.thumbnail;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Boolean getSubbed() {
            return this.subbed;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Boolean getDubbed() {
            return this.dubbed;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Boolean getIsFiller() {
            return this.isFiller;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getAired() {
            return this.aired;
        }

        @NotNull
        public final EpisodeData copy(@JsonProperty("episodeId") @Nullable String episodeId, @JsonProperty("episode_number") @Nullable Integer episodeNumber, @Nullable String title, @Nullable String description, @Nullable String thumbnail, @Nullable Boolean subbed, @Nullable Boolean dubbed, @JsonProperty("is_filler") @Nullable Boolean isFiller, @Nullable String aired) {
            return new EpisodeData(episodeId, episodeNumber, title, description, thumbnail, subbed, dubbed, isFiller, aired);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EpisodeData)) {
                return false;
            }
            EpisodeData episodeData = (EpisodeData) other;
            return Intrinsics.areEqual(this.episodeId, episodeData.episodeId) && Intrinsics.areEqual(this.episodeNumber, episodeData.episodeNumber) && Intrinsics.areEqual(this.title, episodeData.title) && Intrinsics.areEqual(this.description, episodeData.description) && Intrinsics.areEqual(this.thumbnail, episodeData.thumbnail) && Intrinsics.areEqual(this.subbed, episodeData.subbed) && Intrinsics.areEqual(this.dubbed, episodeData.dubbed) && Intrinsics.areEqual(this.isFiller, episodeData.isFiller) && Intrinsics.areEqual(this.aired, episodeData.aired);
        }

        public int hashCode() {
            return ((((((((((((((((this.episodeId == null ? 0 : this.episodeId.hashCode()) * 31) + (this.episodeNumber == null ? 0 : this.episodeNumber.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.description == null ? 0 : this.description.hashCode())) * 31) + (this.thumbnail == null ? 0 : this.thumbnail.hashCode())) * 31) + (this.subbed == null ? 0 : this.subbed.hashCode())) * 31) + (this.dubbed == null ? 0 : this.dubbed.hashCode())) * 31) + (this.isFiller == null ? 0 : this.isFiller.hashCode())) * 31) + (this.aired != null ? this.aired.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "EpisodeData(episodeId=" + this.episodeId + ", episodeNumber=" + this.episodeNumber + ", title=" + this.title + ", description=" + this.description + ", thumbnail=" + this.thumbnail + ", subbed=" + this.subbed + ", dubbed=" + this.dubbed + ", isFiller=" + this.isFiller + ", aired=" + this.aired + ')';
        }

        public EpisodeData(@JsonProperty("episodeId") @Nullable String episodeId, @JsonProperty("episode_number") @Nullable Integer episodeNumber, @Nullable String title, @Nullable String description, @Nullable String thumbnail, @Nullable Boolean subbed, @Nullable Boolean dubbed, @JsonProperty("is_filler") @Nullable Boolean isFiller, @Nullable String aired) {
            this.episodeId = episodeId;
            this.episodeNumber = episodeNumber;
            this.title = title;
            this.description = description;
            this.thumbnail = thumbnail;
            this.subbed = subbed;
            this.dubbed = dubbed;
            this.isFiller = isFiller;
            this.aired = aired;
        }

        @Nullable
        public final String getEpisodeId() {
            return this.episodeId;
        }

        @Nullable
        public final Integer getEpisodeNumber() {
            return this.episodeNumber;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        public final String getThumbnail() {
            return this.thumbnail;
        }

        @Nullable
        public final Boolean getSubbed() {
            return this.subbed;
        }

        @Nullable
        public final Boolean getDubbed() {
            return this.dubbed;
        }

        @Nullable
        public final Boolean isFiller() {
            return this.isFiller;
        }

        @Nullable
        public final String getAired() {
            return this.aired;
        }
    }

    /* JADX INFO: compiled from: Reanime.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/phisher98/Reanime$SourcesResponse;", "", "sources", "", "Lcom/phisher98/Reanime$Source;", "subtitles", "Lcom/phisher98/Reanime$Subtitle;", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getSources", "()Ljava/util/List;", "getSubtitles", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Reanime"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class SourcesResponse {

        @Nullable
        private final List<Source> sources;

        @Nullable
        private final List<Subtitle> subtitles;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SourcesResponse copy$default(SourcesResponse sourcesResponse, List list, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = sourcesResponse.sources;
            }
            if ((i & 2) != 0) {
                list2 = sourcesResponse.subtitles;
            }
            return sourcesResponse.copy(list, list2);
        }

        @Nullable
        public final List<Source> component1() {
            return this.sources;
        }

        @Nullable
        public final List<Subtitle> component2() {
            return this.subtitles;
        }

        @NotNull
        public final SourcesResponse copy(@Nullable List<Source> sources, @Nullable List<Subtitle> subtitles) {
            return new SourcesResponse(sources, subtitles);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SourcesResponse)) {
                return false;
            }
            SourcesResponse sourcesResponse = (SourcesResponse) other;
            return Intrinsics.areEqual(this.sources, sourcesResponse.sources) && Intrinsics.areEqual(this.subtitles, sourcesResponse.subtitles);
        }

        public int hashCode() {
            return ((this.sources == null ? 0 : this.sources.hashCode()) * 31) + (this.subtitles != null ? this.subtitles.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "SourcesResponse(sources=" + this.sources + ", subtitles=" + this.subtitles + ')';
        }

        public SourcesResponse(@Nullable List<Source> list, @Nullable List<Subtitle> list2) {
            this.sources = list;
            this.subtitles = list2;
        }

        @Nullable
        public final List<Source> getSources() {
            return this.sources;
        }

        @Nullable
        public final List<Subtitle> getSubtitles() {
            return this.subtitles;
        }
    }

    /* JADX INFO: compiled from: Reanime.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/phisher98/Reanime$Source;", "", "url", "", "quality", "server", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getQuality", "getServer", "getType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "Reanime"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Source {

        @Nullable
        private final String quality;

        @Nullable
        private final String server;

        @Nullable
        private final String type;

        @Nullable
        private final String url;

        public static /* synthetic */ Source copy$default(Source source, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = source.url;
            }
            if ((i & 2) != 0) {
                str2 = source.quality;
            }
            if ((i & 4) != 0) {
                str3 = source.server;
            }
            if ((i & 8) != 0) {
                str4 = source.type;
            }
            return source.copy(str, str2, str3, str4);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getQuality() {
            return this.quality;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getServer() {
            return this.server;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @NotNull
        public final Source copy(@Nullable String url, @Nullable String quality, @Nullable String server, @Nullable String type) {
            return new Source(url, quality, server, type);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Source)) {
                return false;
            }
            Source source = (Source) other;
            return Intrinsics.areEqual(this.url, source.url) && Intrinsics.areEqual(this.quality, source.quality) && Intrinsics.areEqual(this.server, source.server) && Intrinsics.areEqual(this.type, source.type);
        }

        public int hashCode() {
            return ((((((this.url == null ? 0 : this.url.hashCode()) * 31) + (this.quality == null ? 0 : this.quality.hashCode())) * 31) + (this.server == null ? 0 : this.server.hashCode())) * 31) + (this.type != null ? this.type.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Source(url=" + this.url + ", quality=" + this.quality + ", server=" + this.server + ", type=" + this.type + ')';
        }

        public Source(@Nullable String url, @Nullable String quality, @Nullable String server, @Nullable String type) {
            this.url = url;
            this.quality = quality;
            this.server = server;
            this.type = type;
        }

        @Nullable
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        public final String getQuality() {
            return this.quality;
        }

        @Nullable
        public final String getServer() {
            return this.server;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }
    }

    /* JADX INFO: compiled from: Reanime.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/phisher98/Reanime$Subtitle;", "", "url", "", "language", "label", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getLanguage", "getLabel", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Reanime"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Subtitle {

        @Nullable
        private final String label;

        @Nullable
        private final String language;

        @Nullable
        private final String url;

        public static /* synthetic */ Subtitle copy$default(Subtitle subtitle, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = subtitle.url;
            }
            if ((i & 2) != 0) {
                str2 = subtitle.language;
            }
            if ((i & 4) != 0) {
                str3 = subtitle.label;
            }
            return subtitle.copy(str, str2, str3);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getLanguage() {
            return this.language;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getLabel() {
            return this.label;
        }

        @NotNull
        public final Subtitle copy(@Nullable String url, @Nullable String language, @Nullable String label) {
            return new Subtitle(url, language, label);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Subtitle)) {
                return false;
            }
            Subtitle subtitle = (Subtitle) other;
            return Intrinsics.areEqual(this.url, subtitle.url) && Intrinsics.areEqual(this.language, subtitle.language) && Intrinsics.areEqual(this.label, subtitle.label);
        }

        public int hashCode() {
            return ((((this.url == null ? 0 : this.url.hashCode()) * 31) + (this.language == null ? 0 : this.language.hashCode())) * 31) + (this.label != null ? this.label.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Subtitle(url=" + this.url + ", language=" + this.language + ", label=" + this.label + ')';
        }

        public Subtitle(@Nullable String url, @Nullable String language, @Nullable String label) {
            this.url = url;
            this.language = language;
            this.label = label;
        }

        @Nullable
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        public final String getLanguage() {
            return this.language;
        }

        @Nullable
        public final String getLabel() {
            return this.label;
        }
    }

    /* JADX INFO: compiled from: Reanime.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J,\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/phisher98/Reanime$FlixResponse;", "", "success", "", "servers", "", "Lcom/phisher98/Reanime$FlixServer;", "<init>", "(Ljava/lang/Boolean;Ljava/util/List;)V", "getSuccess", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getServers", "()Ljava/util/List;", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/util/List;)Lcom/phisher98/Reanime$FlixResponse;", "equals", "other", "hashCode", "", "toString", "", "Reanime"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class FlixResponse {

        @Nullable
        private final List<FlixServer> servers;

        @Nullable
        private final Boolean success;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ FlixResponse copy$default(FlixResponse flixResponse, Boolean bool, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                bool = flixResponse.success;
            }
            if ((i & 2) != 0) {
                list = flixResponse.servers;
            }
            return flixResponse.copy(bool, list);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Boolean getSuccess() {
            return this.success;
        }

        @Nullable
        public final List<FlixServer> component2() {
            return this.servers;
        }

        @NotNull
        public final FlixResponse copy(@Nullable Boolean success, @Nullable List<FlixServer> servers) {
            return new FlixResponse(success, servers);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FlixResponse)) {
                return false;
            }
            FlixResponse flixResponse = (FlixResponse) other;
            return Intrinsics.areEqual(this.success, flixResponse.success) && Intrinsics.areEqual(this.servers, flixResponse.servers);
        }

        public int hashCode() {
            return ((this.success == null ? 0 : this.success.hashCode()) * 31) + (this.servers != null ? this.servers.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "FlixResponse(success=" + this.success + ", servers=" + this.servers + ')';
        }

        public FlixResponse(@Nullable Boolean success, @Nullable List<FlixServer> list) {
            this.success = success;
            this.servers = list;
        }

        @Nullable
        public final Boolean getSuccess() {
            return this.success;
        }

        @Nullable
        public final List<FlixServer> getServers() {
            return this.servers;
        }
    }

    /* JADX INFO: compiled from: Reanime.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\u0018\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0015Jd\u0010\u001e\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0014\u0010 \u001a\u00020\u000b2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\"\u001a\u00020#HÖ\u0081\u0004J\n\u0010$\u001a\u00020\u0003HÖ\u0081\u0004R'\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0015¨\u0006%"}, d2 = {"Lcom/phisher98/Reanime$FlixServer;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "$id", "serverName", "dataLink", "dataType", "continueWatch", "", "softsub", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getId", "()Ljava/lang/String;", "getServerName", "getDataLink", "getDataType", "getContinueWatch", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSoftsub", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/phisher98/Reanime$FlixServer;", "equals", "other", "hashCode", "", "toString", "Reanime"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class FlixServer {

        @Nullable
        private final Boolean continueWatch;

        @Nullable
        private final String dataLink;

        @Nullable
        private final String dataType;

        @JsonProperty("$id")
        @Nullable
        private final String id;

        @Nullable
        private final String serverName;

        @Nullable
        private final Boolean softsub;

        public static /* synthetic */ FlixServer copy$default(FlixServer flixServer, String str, String str2, String str3, String str4, Boolean bool, Boolean bool2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = flixServer.id;
            }
            if ((i & 2) != 0) {
                str2 = flixServer.serverName;
            }
            if ((i & 4) != 0) {
                str3 = flixServer.dataLink;
            }
            if ((i & 8) != 0) {
                str4 = flixServer.dataType;
            }
            if ((i & 16) != 0) {
                bool = flixServer.continueWatch;
            }
            if ((i & 32) != 0) {
                bool2 = flixServer.softsub;
            }
            Boolean bool3 = bool;
            Boolean bool4 = bool2;
            return flixServer.copy(str, str2, str3, str4, bool3, bool4);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getServerName() {
            return this.serverName;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getDataLink() {
            return this.dataLink;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getDataType() {
            return this.dataType;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Boolean getContinueWatch() {
            return this.continueWatch;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Boolean getSoftsub() {
            return this.softsub;
        }

        @NotNull
        public final FlixServer copy(@JsonProperty("$id") @Nullable String id, @Nullable String serverName, @Nullable String dataLink, @Nullable String dataType, @Nullable Boolean continueWatch, @Nullable Boolean softsub) {
            return new FlixServer(id, serverName, dataLink, dataType, continueWatch, softsub);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FlixServer)) {
                return false;
            }
            FlixServer flixServer = (FlixServer) other;
            return Intrinsics.areEqual(this.id, flixServer.id) && Intrinsics.areEqual(this.serverName, flixServer.serverName) && Intrinsics.areEqual(this.dataLink, flixServer.dataLink) && Intrinsics.areEqual(this.dataType, flixServer.dataType) && Intrinsics.areEqual(this.continueWatch, flixServer.continueWatch) && Intrinsics.areEqual(this.softsub, flixServer.softsub);
        }

        public int hashCode() {
            return ((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.serverName == null ? 0 : this.serverName.hashCode())) * 31) + (this.dataLink == null ? 0 : this.dataLink.hashCode())) * 31) + (this.dataType == null ? 0 : this.dataType.hashCode())) * 31) + (this.continueWatch == null ? 0 : this.continueWatch.hashCode())) * 31) + (this.softsub != null ? this.softsub.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "FlixServer(id=" + this.id + ", serverName=" + this.serverName + ", dataLink=" + this.dataLink + ", dataType=" + this.dataType + ", continueWatch=" + this.continueWatch + ", softsub=" + this.softsub + ')';
        }

        public FlixServer(@JsonProperty("$id") @Nullable String id, @Nullable String serverName, @Nullable String dataLink, @Nullable String dataType, @Nullable Boolean continueWatch, @Nullable Boolean softsub) {
            this.id = id;
            this.serverName = serverName;
            this.dataLink = dataLink;
            this.dataType = dataType;
            this.continueWatch = continueWatch;
            this.softsub = softsub;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ FlixServer(String str, String str2, String str3, String str4, Boolean bool, Boolean bool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            Boolean bool3;
            bool = (i & 16) != 0 ? null : bool;
            if ((i & 32) == 0) {
                bool3 = bool2;
            } else {
                bool3 = null;
            }
            this(str, str2, str3, str4, bool, bool3);
        }

        @Nullable
        public final String getId() {
            return this.id;
        }

        @Nullable
        public final String getServerName() {
            return this.serverName;
        }

        @Nullable
        public final String getDataLink() {
            return this.dataLink;
        }

        @Nullable
        public final String getDataType() {
            return this.dataType;
        }

        @Nullable
        public final Boolean getContinueWatch() {
            return this.continueWatch;
        }

        @Nullable
        public final Boolean getSoftsub() {
            return this.softsub;
        }
    }

    /* JADX INFO: compiled from: Reanime.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003JG\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tHÆ\u0001J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR'\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/phisher98/Reanime$Title;", "", "english", "", "native", "romaji", "userPreferred", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "user_preferred", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEnglish", "()Ljava/lang/String;", "getNative", "getRomaji", "getUserPreferred", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "Reanime"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Title {

        @Nullable
        private final String english;

        @Nullable
        private final String native;

        @Nullable
        private final String romaji;

        @JsonProperty("user_preferred")
        @Nullable
        private final String userPreferred;

        public static /* synthetic */ Title copy$default(Title title, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = title.english;
            }
            if ((i & 2) != 0) {
                str2 = title.native;
            }
            if ((i & 4) != 0) {
                str3 = title.romaji;
            }
            if ((i & 8) != 0) {
                str4 = title.userPreferred;
            }
            return title.copy(str, str2, str3, str4);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getEnglish() {
            return this.english;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getNative() {
            return this.native;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getRomaji() {
            return this.romaji;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getUserPreferred() {
            return this.userPreferred;
        }

        @NotNull
        public final Title copy(@Nullable String english, @Nullable String str, @Nullable String romaji, @JsonProperty("user_preferred") @Nullable String userPreferred) {
            return new Title(english, str, romaji, userPreferred);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Title)) {
                return false;
            }
            Title title = (Title) other;
            return Intrinsics.areEqual(this.english, title.english) && Intrinsics.areEqual(this.native, title.native) && Intrinsics.areEqual(this.romaji, title.romaji) && Intrinsics.areEqual(this.userPreferred, title.userPreferred);
        }

        public int hashCode() {
            return ((((((this.english == null ? 0 : this.english.hashCode()) * 31) + (this.native == null ? 0 : this.native.hashCode())) * 31) + (this.romaji == null ? 0 : this.romaji.hashCode())) * 31) + (this.userPreferred != null ? this.userPreferred.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Title(english=" + this.english + ", native=" + this.native + ", romaji=" + this.romaji + ", userPreferred=" + this.userPreferred + ')';
        }

        public Title(@Nullable String english, @Nullable String str, @Nullable String romaji, @JsonProperty("user_preferred") @Nullable String userPreferred) {
            this.english = english;
            this.native = str;
            this.romaji = romaji;
            this.userPreferred = userPreferred;
        }

        @Nullable
        public final String getEnglish() {
            return this.english;
        }

        @Nullable
        public final String getNative() {
            return this.native;
        }

        @Nullable
        public final String getRomaji() {
            return this.romaji;
        }

        @Nullable
        public final String getUserPreferred() {
            return this.userPreferred;
        }
    }

    /* JADX INFO: compiled from: Reanime.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003JG\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0018\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003:\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR'\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/phisher98/Reanime$CoverImage;", "", "color", "", "extraLarge", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "extra_large", "large", "medium", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getColor", "()Ljava/lang/String;", "getExtraLarge", "getLarge", "getMedium", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "Reanime"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class CoverImage {

        @Nullable
        private final String color;

        @JsonProperty("extra_large")
        @Nullable
        private final String extraLarge;

        @Nullable
        private final String large;

        @Nullable
        private final String medium;

        public static /* synthetic */ CoverImage copy$default(CoverImage coverImage, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = coverImage.color;
            }
            if ((i & 2) != 0) {
                str2 = coverImage.extraLarge;
            }
            if ((i & 4) != 0) {
                str3 = coverImage.large;
            }
            if ((i & 8) != 0) {
                str4 = coverImage.medium;
            }
            return coverImage.copy(str, str2, str3, str4);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getColor() {
            return this.color;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getExtraLarge() {
            return this.extraLarge;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getLarge() {
            return this.large;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getMedium() {
            return this.medium;
        }

        @NotNull
        public final CoverImage copy(@Nullable String color, @JsonProperty("extra_large") @Nullable String extraLarge, @Nullable String large, @Nullable String medium) {
            return new CoverImage(color, extraLarge, large, medium);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CoverImage)) {
                return false;
            }
            CoverImage coverImage = (CoverImage) other;
            return Intrinsics.areEqual(this.color, coverImage.color) && Intrinsics.areEqual(this.extraLarge, coverImage.extraLarge) && Intrinsics.areEqual(this.large, coverImage.large) && Intrinsics.areEqual(this.medium, coverImage.medium);
        }

        public int hashCode() {
            return ((((((this.color == null ? 0 : this.color.hashCode()) * 31) + (this.extraLarge == null ? 0 : this.extraLarge.hashCode())) * 31) + (this.large == null ? 0 : this.large.hashCode())) * 31) + (this.medium != null ? this.medium.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "CoverImage(color=" + this.color + ", extraLarge=" + this.extraLarge + ", large=" + this.large + ", medium=" + this.medium + ')';
        }

        public CoverImage(@Nullable String color, @JsonProperty("extra_large") @Nullable String extraLarge, @Nullable String large, @Nullable String medium) {
            this.color = color;
            this.extraLarge = extraLarge;
            this.large = large;
            this.medium = medium;
        }

        @Nullable
        public final String getColor() {
            return this.color;
        }

        @Nullable
        public final String getExtraLarge() {
            return this.extraLarge;
        }

        @Nullable
        public final String getLarge() {
            return this.large;
        }

        @Nullable
        public final String getMedium() {
            return this.medium;
        }
    }

    /* JADX INFO: compiled from: Reanime.kt */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0017J\\\u0010\u001f\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010 J\u0014\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010$\u001a\u00020\fHÖ\u0081\u0004J\n\u0010%\u001a\u00020\u0004HÖ\u0081\u0004R\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0019\u0010\u0017Ê\u0001\f\b'\u0012\b\b(\u0012\u0004\b\u0007\u0010\u0002¨\u0006&"}, d2 = {"Lcom/phisher98/Reanime$AniZipResponse;", "", "episodes", "", "", "Lcom/phisher98/Reanime$AniZipEpisode;", "images", "", "Lcom/phisher98/Reanime$AniZipImage;", "mappings", "Lcom/phisher98/Reanime$AniZipMappings;", "episodeCount", "", "specialCount", "<init>", "(Ljava/util/Map;Ljava/util/List;Lcom/phisher98/Reanime$AniZipMappings;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getEpisodes", "()Ljava/util/Map;", "getImages", "()Ljava/util/List;", "getMappings", "()Lcom/phisher98/Reanime$AniZipMappings;", "getEpisodeCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSpecialCount", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/util/Map;Ljava/util/List;Lcom/phisher98/Reanime$AniZipMappings;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/phisher98/Reanime$AniZipResponse;", "equals", "", "other", "hashCode", "toString", "Reanime", "Lcom/fasterxml/jackson/annotation/JsonIgnoreProperties;", "ignoreUnknown"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class AniZipResponse {

        @Nullable
        private final Integer episodeCount;

        @Nullable
        private final Map<String, AniZipEpisode> episodes;

        @Nullable
        private final List<AniZipImage> images;

        @Nullable
        private final AniZipMappings mappings;

        @Nullable
        private final Integer specialCount;

        public AniZipResponse() {
            this(null, null, null, null, null, 31, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AniZipResponse copy$default(AniZipResponse aniZipResponse, Map map, List list, AniZipMappings aniZipMappings, Integer num, Integer num2, int i, Object obj) {
            if ((i & 1) != 0) {
                map = aniZipResponse.episodes;
            }
            if ((i & 2) != 0) {
                list = aniZipResponse.images;
            }
            if ((i & 4) != 0) {
                aniZipMappings = aniZipResponse.mappings;
            }
            if ((i & 8) != 0) {
                num = aniZipResponse.episodeCount;
            }
            if ((i & 16) != 0) {
                num2 = aniZipResponse.specialCount;
            }
            Integer num3 = num2;
            AniZipMappings aniZipMappings2 = aniZipMappings;
            return aniZipResponse.copy(map, list, aniZipMappings2, num, num3);
        }

        @Nullable
        public final Map<String, AniZipEpisode> component1() {
            return this.episodes;
        }

        @Nullable
        public final List<AniZipImage> component2() {
            return this.images;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final AniZipMappings getMappings() {
            return this.mappings;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Integer getEpisodeCount() {
            return this.episodeCount;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Integer getSpecialCount() {
            return this.specialCount;
        }

        @NotNull
        public final AniZipResponse copy(@Nullable Map<String, AniZipEpisode> episodes, @Nullable List<AniZipImage> images, @Nullable AniZipMappings mappings, @Nullable Integer episodeCount, @Nullable Integer specialCount) {
            return new AniZipResponse(episodes, images, mappings, episodeCount, specialCount);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AniZipResponse)) {
                return false;
            }
            AniZipResponse aniZipResponse = (AniZipResponse) other;
            return Intrinsics.areEqual(this.episodes, aniZipResponse.episodes) && Intrinsics.areEqual(this.images, aniZipResponse.images) && Intrinsics.areEqual(this.mappings, aniZipResponse.mappings) && Intrinsics.areEqual(this.episodeCount, aniZipResponse.episodeCount) && Intrinsics.areEqual(this.specialCount, aniZipResponse.specialCount);
        }

        public int hashCode() {
            return ((((((((this.episodes == null ? 0 : this.episodes.hashCode()) * 31) + (this.images == null ? 0 : this.images.hashCode())) * 31) + (this.mappings == null ? 0 : this.mappings.hashCode())) * 31) + (this.episodeCount == null ? 0 : this.episodeCount.hashCode())) * 31) + (this.specialCount != null ? this.specialCount.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "AniZipResponse(episodes=" + this.episodes + ", images=" + this.images + ", mappings=" + this.mappings + ", episodeCount=" + this.episodeCount + ", specialCount=" + this.specialCount + ')';
        }

        public AniZipResponse(@Nullable Map<String, AniZipEpisode> map, @Nullable List<AniZipImage> list, @Nullable AniZipMappings mappings, @Nullable Integer episodeCount, @Nullable Integer specialCount) {
            this.episodes = map;
            this.images = list;
            this.mappings = mappings;
            this.episodeCount = episodeCount;
            this.specialCount = specialCount;
        }

        public /* synthetic */ AniZipResponse(Map map, List list, AniZipMappings aniZipMappings, Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : map, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : aniZipMappings, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : num2);
        }

        @Nullable
        public final Map<String, AniZipEpisode> getEpisodes() {
            return this.episodes;
        }

        @Nullable
        public final List<AniZipImage> getImages() {
            return this.images;
        }

        @Nullable
        public final AniZipMappings getMappings() {
            return this.mappings;
        }

        @Nullable
        public final Integer getEpisodeCount() {
            return this.episodeCount;
        }

        @Nullable
        public final Integer getSpecialCount() {
            return this.specialCount;
        }
    }

    /* JADX INFO: compiled from: Reanime.kt */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0081\u0001\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010$\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0088\u0001\u0010'\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010(J\u0014\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010,\u001a\u00020\bHÖ\u0081\u0004J\n\u0010-\u001a\u00020\u0004HÖ\u0081\u0004R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001a\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013Ê\u0001\f\b/\u0012\b\b0\u0012\u0004\b\u0007\u0010\u0002¨\u0006."}, d2 = {"Lcom/phisher98/Reanime$AniZipEpisode;", "", "title", "", "", "overview", "image", "absoluteEpisodeNumber", "", "rating", "runtime", "airDateUtc", "airDate", "summary", "<init>", "(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Object;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/util/Map;", "getOverview", "()Ljava/lang/String;", "getImage", "getAbsoluteEpisodeNumber", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRating", "()Ljava/lang/Object;", "getRuntime", "getAirDateUtc", "getAirDate", "getSummary", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Object;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/phisher98/Reanime$AniZipEpisode;", "equals", "", "other", "hashCode", "toString", "Reanime", "Lcom/fasterxml/jackson/annotation/JsonIgnoreProperties;", "ignoreUnknown"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class AniZipEpisode {

        @Nullable
        private final Integer absoluteEpisodeNumber;

        @Nullable
        private final String airDate;

        @Nullable
        private final String airDateUtc;

        @Nullable
        private final String image;

        @Nullable
        private final String overview;

        @Nullable
        private final Object rating;

        @Nullable
        private final Integer runtime;

        @Nullable
        private final String summary;

        @Nullable
        private final Map<String, String> title;

        public AniZipEpisode() {
            this(null, null, null, null, null, null, null, null, null, 511, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AniZipEpisode copy$default(AniZipEpisode aniZipEpisode, Map map, String str, String str2, Integer num, Object obj, Integer num2, String str3, String str4, String str5, int i, Object obj2) {
            if ((i & 1) != 0) {
                map = aniZipEpisode.title;
            }
            if ((i & 2) != 0) {
                str = aniZipEpisode.overview;
            }
            if ((i & 4) != 0) {
                str2 = aniZipEpisode.image;
            }
            if ((i & 8) != 0) {
                num = aniZipEpisode.absoluteEpisodeNumber;
            }
            if ((i & 16) != 0) {
                obj = aniZipEpisode.rating;
            }
            if ((i & 32) != 0) {
                num2 = aniZipEpisode.runtime;
            }
            if ((i & 64) != 0) {
                str3 = aniZipEpisode.airDateUtc;
            }
            if ((i & 128) != 0) {
                str4 = aniZipEpisode.airDate;
            }
            if ((i & 256) != 0) {
                str5 = aniZipEpisode.summary;
            }
            String str6 = str4;
            String str7 = str5;
            Integer num3 = num2;
            String str8 = str3;
            Object obj3 = obj;
            String str9 = str2;
            return aniZipEpisode.copy(map, str, str9, num, obj3, num3, str8, str6, str7);
        }

        @Nullable
        public final Map<String, String> component1() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getOverview() {
            return this.overview;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getImage() {
            return this.image;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Integer getAbsoluteEpisodeNumber() {
            return this.absoluteEpisodeNumber;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Object getRating() {
            return this.rating;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Integer getRuntime() {
            return this.runtime;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getAirDateUtc() {
            return this.airDateUtc;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getAirDate() {
            return this.airDate;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getSummary() {
            return this.summary;
        }

        @NotNull
        public final AniZipEpisode copy(@Nullable Map<String, String> title, @Nullable String overview, @Nullable String image, @Nullable Integer absoluteEpisodeNumber, @Nullable Object rating, @Nullable Integer runtime, @Nullable String airDateUtc, @Nullable String airDate, @Nullable String summary) {
            return new AniZipEpisode(title, overview, image, absoluteEpisodeNumber, rating, runtime, airDateUtc, airDate, summary);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AniZipEpisode)) {
                return false;
            }
            AniZipEpisode aniZipEpisode = (AniZipEpisode) other;
            return Intrinsics.areEqual(this.title, aniZipEpisode.title) && Intrinsics.areEqual(this.overview, aniZipEpisode.overview) && Intrinsics.areEqual(this.image, aniZipEpisode.image) && Intrinsics.areEqual(this.absoluteEpisodeNumber, aniZipEpisode.absoluteEpisodeNumber) && Intrinsics.areEqual(this.rating, aniZipEpisode.rating) && Intrinsics.areEqual(this.runtime, aniZipEpisode.runtime) && Intrinsics.areEqual(this.airDateUtc, aniZipEpisode.airDateUtc) && Intrinsics.areEqual(this.airDate, aniZipEpisode.airDate) && Intrinsics.areEqual(this.summary, aniZipEpisode.summary);
        }

        public int hashCode() {
            return ((((((((((((((((this.title == null ? 0 : this.title.hashCode()) * 31) + (this.overview == null ? 0 : this.overview.hashCode())) * 31) + (this.image == null ? 0 : this.image.hashCode())) * 31) + (this.absoluteEpisodeNumber == null ? 0 : this.absoluteEpisodeNumber.hashCode())) * 31) + (this.rating == null ? 0 : this.rating.hashCode())) * 31) + (this.runtime == null ? 0 : this.runtime.hashCode())) * 31) + (this.airDateUtc == null ? 0 : this.airDateUtc.hashCode())) * 31) + (this.airDate == null ? 0 : this.airDate.hashCode())) * 31) + (this.summary != null ? this.summary.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "AniZipEpisode(title=" + this.title + ", overview=" + this.overview + ", image=" + this.image + ", absoluteEpisodeNumber=" + this.absoluteEpisodeNumber + ", rating=" + this.rating + ", runtime=" + this.runtime + ", airDateUtc=" + this.airDateUtc + ", airDate=" + this.airDate + ", summary=" + this.summary + ')';
        }

        public AniZipEpisode(@Nullable Map<String, String> map, @Nullable String overview, @Nullable String image, @Nullable Integer absoluteEpisodeNumber, @Nullable Object rating, @Nullable Integer runtime, @Nullable String airDateUtc, @Nullable String airDate, @Nullable String summary) {
            this.title = map;
            this.overview = overview;
            this.image = image;
            this.absoluteEpisodeNumber = absoluteEpisodeNumber;
            this.rating = rating;
            this.runtime = runtime;
            this.airDateUtc = airDateUtc;
            this.airDate = airDate;
            this.summary = summary;
        }

        public /* synthetic */ AniZipEpisode(Map map, String str, String str2, Integer num, Object obj, Integer num2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : map, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : obj, (i & 32) != 0 ? null : num2, (i & 64) != 0 ? null : str3, (i & 128) != 0 ? null : str4, (i & 256) != 0 ? null : str5);
        }

        @Nullable
        public final Map<String, String> getTitle() {
            return this.title;
        }

        @Nullable
        public final String getOverview() {
            return this.overview;
        }

        @Nullable
        public final String getImage() {
            return this.image;
        }

        @Nullable
        public final Integer getAbsoluteEpisodeNumber() {
            return this.absoluteEpisodeNumber;
        }

        @Nullable
        public final Object getRating() {
            return this.rating;
        }

        @Nullable
        public final Integer getRuntime() {
            return this.runtime;
        }

        @Nullable
        public final String getAirDateUtc() {
            return this.airDateUtc;
        }

        @Nullable
        public final String getAirDate() {
            return this.airDate;
        }

        @Nullable
        public final String getSummary() {
            return this.summary;
        }
    }

    /* JADX INFO: compiled from: Reanime.kt */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bÊ\u0001\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\u0007\u0010\u0002¨\u0006\u0013"}, d2 = {"Lcom/phisher98/Reanime$AniZipImage;", "", "coverType", "", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getCoverType", "()Ljava/lang/String;", "getUrl", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Reanime", "Lcom/fasterxml/jackson/annotation/JsonIgnoreProperties;", "ignoreUnknown"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class AniZipImage {

        @Nullable
        private final String coverType;

        @Nullable
        private final String url;

        /* JADX WARN: Illegal instructions before constructor call */
        public AniZipImage() {
            String str = null;
            this(str, str, 3, str);
        }

        public static /* synthetic */ AniZipImage copy$default(AniZipImage aniZipImage, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = aniZipImage.coverType;
            }
            if ((i & 2) != 0) {
                str2 = aniZipImage.url;
            }
            return aniZipImage.copy(str, str2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getCoverType() {
            return this.coverType;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @NotNull
        public final AniZipImage copy(@Nullable String coverType, @Nullable String url) {
            return new AniZipImage(coverType, url);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AniZipImage)) {
                return false;
            }
            AniZipImage aniZipImage = (AniZipImage) other;
            return Intrinsics.areEqual(this.coverType, aniZipImage.coverType) && Intrinsics.areEqual(this.url, aniZipImage.url);
        }

        public int hashCode() {
            return ((this.coverType == null ? 0 : this.coverType.hashCode()) * 31) + (this.url != null ? this.url.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "AniZipImage(coverType=" + this.coverType + ", url=" + this.url + ')';
        }

        public AniZipImage(@Nullable String coverType, @Nullable String url) {
            this.coverType = coverType;
            this.url = url;
        }

        public /* synthetic */ AniZipImage(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }

        @Nullable
        public final String getCoverType() {
            return this.coverType;
        }

        @Nullable
        public final String getUrl() {
            return this.url;
        }
    }

    /* JADX INFO: compiled from: Reanime.kt */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJJ\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0014\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001d\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0006HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0012\u0010\fÊ\u0001\f\b \u0012\b\b!\u0012\u0004\b\u0007\u0010\u0002¨\u0006\u001f"}, d2 = {"Lcom/phisher98/Reanime$AniZipMappings;", "", "mal_id", "", "anilist_id", "imdb_id", "", "themoviedb_id", "thetvdb_id", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getMal_id", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAnilist_id", "getImdb_id", "()Ljava/lang/String;", "getThemoviedb_id", "getThetvdb_id", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/phisher98/Reanime$AniZipMappings;", "equals", "", "other", "hashCode", "toString", "Reanime", "Lcom/fasterxml/jackson/annotation/JsonIgnoreProperties;", "ignoreUnknown"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class AniZipMappings {

        @Nullable
        private final Integer anilist_id;

        @Nullable
        private final String imdb_id;

        @Nullable
        private final Integer mal_id;

        @Nullable
        private final String themoviedb_id;

        @Nullable
        private final Integer thetvdb_id;

        public AniZipMappings() {
            this(null, null, null, null, null, 31, null);
        }

        public static /* synthetic */ AniZipMappings copy$default(AniZipMappings aniZipMappings, Integer num, Integer num2, String str, String str2, Integer num3, int i, Object obj) {
            if ((i & 1) != 0) {
                num = aniZipMappings.mal_id;
            }
            if ((i & 2) != 0) {
                num2 = aniZipMappings.anilist_id;
            }
            if ((i & 4) != 0) {
                str = aniZipMappings.imdb_id;
            }
            if ((i & 8) != 0) {
                str2 = aniZipMappings.themoviedb_id;
            }
            if ((i & 16) != 0) {
                num3 = aniZipMappings.thetvdb_id;
            }
            Integer num4 = num3;
            String str3 = str;
            return aniZipMappings.copy(num, num2, str3, str2, num4);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getMal_id() {
            return this.mal_id;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getAnilist_id() {
            return this.anilist_id;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getImdb_id() {
            return this.imdb_id;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getThemoviedb_id() {
            return this.themoviedb_id;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Integer getThetvdb_id() {
            return this.thetvdb_id;
        }

        @NotNull
        public final AniZipMappings copy(@Nullable Integer mal_id, @Nullable Integer anilist_id, @Nullable String imdb_id, @Nullable String themoviedb_id, @Nullable Integer thetvdb_id) {
            return new AniZipMappings(mal_id, anilist_id, imdb_id, themoviedb_id, thetvdb_id);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AniZipMappings)) {
                return false;
            }
            AniZipMappings aniZipMappings = (AniZipMappings) other;
            return Intrinsics.areEqual(this.mal_id, aniZipMappings.mal_id) && Intrinsics.areEqual(this.anilist_id, aniZipMappings.anilist_id) && Intrinsics.areEqual(this.imdb_id, aniZipMappings.imdb_id) && Intrinsics.areEqual(this.themoviedb_id, aniZipMappings.themoviedb_id) && Intrinsics.areEqual(this.thetvdb_id, aniZipMappings.thetvdb_id);
        }

        public int hashCode() {
            return ((((((((this.mal_id == null ? 0 : this.mal_id.hashCode()) * 31) + (this.anilist_id == null ? 0 : this.anilist_id.hashCode())) * 31) + (this.imdb_id == null ? 0 : this.imdb_id.hashCode())) * 31) + (this.themoviedb_id == null ? 0 : this.themoviedb_id.hashCode())) * 31) + (this.thetvdb_id != null ? this.thetvdb_id.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "AniZipMappings(mal_id=" + this.mal_id + ", anilist_id=" + this.anilist_id + ", imdb_id=" + this.imdb_id + ", themoviedb_id=" + this.themoviedb_id + ", thetvdb_id=" + this.thetvdb_id + ')';
        }

        public AniZipMappings(@Nullable Integer mal_id, @Nullable Integer anilist_id, @Nullable String imdb_id, @Nullable String themoviedb_id, @Nullable Integer thetvdb_id) {
            this.mal_id = mal_id;
            this.anilist_id = anilist_id;
            this.imdb_id = imdb_id;
            this.themoviedb_id = themoviedb_id;
            this.thetvdb_id = thetvdb_id;
        }

        public /* synthetic */ AniZipMappings(Integer num, Integer num2, String str, String str2, Integer num3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : num3);
        }

        @Nullable
        public final Integer getMal_id() {
            return this.mal_id;
        }

        @Nullable
        public final Integer getAnilist_id() {
            return this.anilist_id;
        }

        @Nullable
        public final String getImdb_id() {
            return this.imdb_id;
        }

        @Nullable
        public final String getThemoviedb_id() {
            return this.themoviedb_id;
        }

        @Nullable
        public final Integer getThetvdb_id() {
            return this.thetvdb_id;
        }
    }
}
