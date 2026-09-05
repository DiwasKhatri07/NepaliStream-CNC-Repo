package com.phisher98;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.Actor;
import com.lagradost.cloudstream3.ActorData;
import com.lagradost.cloudstream3.ActorRole;
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
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
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
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KType;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.Interceptor;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;

/* JADX INFO: compiled from: AllMovieLandProvider.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/AllMovieLandProvider/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \u0018\u0000 M2\u00020\u0001:\u001eMNOPQRSTUVWXYZ[\\]^_`abcdefghijB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0005H\u0002J\u0012\u0010#\u001a\u0004\u0018\u00010\u00052\u0006\u0010$\u001a\u00020\u0005H\u0002J\u0010\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0005H\u0002J\u001e\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010+J(\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u00052\b\u0010/\u001a\u0004\u0018\u00010\u0005H\u0082@¢\u0006\u0002\u00100J*\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u00020\u00052\b\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u00020\u000eH\u0082@¢\u0006\u0002\u00107J\u001e\u0010\u001f\u001a\u0002082\u0006\u00109\u001a\u0002052\u0006\u0010:\u001a\u00020;H\u0096@¢\u0006\u0002\u0010<J\u001c\u0010=\u001a\b\u0012\u0004\u0012\u00020>0\u001d2\u0006\u0010?\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010@J\u0018\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010\"\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010@JF\u0010C\u001a\u00020\u000e2\u0006\u0010D\u001a\u00020\u00052\u0006\u0010E\u001a\u00020\u000e2\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020I0G2\u0012\u0010J\u001a\u000e\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020I0GH\u0096@¢\u0006\u0002\u0010LR\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006k"}, d2 = {"Lcom/phisher98/AllMovieLandProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasDownloadSupport", "getHasDownloadSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "sessionUa", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "getBaseUrl", "url", "extractJsonObject", "script", "cleanFolderJson", "raw", "getDlPayload", "Lcom/phisher98/AllMovieLandProvider$DlPayload;", "iframeUrl", "referer", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getM3u8Text", "playerDomain", "tokenKey", "fileId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchTmdbMeta", "Lcom/phisher98/AllMovieLandProvider$TmdbMeta;", "title", "year", "", "isSeries", "(Ljava/lang/String;Ljava/lang/Integer;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "TmdbMeta", "DlPayload", "PlayerMeta", "EpisodeData", "FileEntry", "SeasonFolder", "EpisodeFolder", "CatalogResponse", "CatalogResult", "CatalogCategory", "CatalogMovie", "MovieDetailResponse", "MovieDetail", "MovieActor", "Ratings", "RatingInfo", "Genre", "Country", "PlayerResponse", "TmdbSearchResponse", "TmdbSearchResult", "TmdbDetail", "TmdbGenre", "TmdbCredits", "TmdbCast", "TmdbExternalIds", "TmdbSeasonResponse", "TmdbEpisode", "SearchApiResponse", "AllMovieLandProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAllMovieLandProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AllMovieLandProvider.kt\ncom/phisher98/AllMovieLandProvider\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 5 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 6 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,578:1\n1#2:579\n1#2:583\n1#2:628\n1#2:658\n1#2:661\n1#2:680\n1#2:699\n1#2:713\n1#2:727\n1#2:741\n1#2:749\n1#2:781\n1#2:804\n1#2:829\n93#3,2:580\n63#3:582\n64#3,15:584\n95#3,2:601\n93#3,2:746\n63#3:748\n64#3,15:750\n95#3,2:767\n93#3,2:778\n63#3:780\n64#3,15:782\n95#3,2:799\n93#3,2:801\n63#3:803\n64#3,15:805\n95#3,2:822\n93#3,2:826\n63#3:828\n64#3,15:830\n95#3,2:847\n50#4:599\n43#4:600\n50#4:765\n43#4:766\n50#4:797\n43#4:798\n50#4:820\n43#4:821\n50#4:845\n43#4:846\n73#5,5:603\n73#5,5:608\n73#5,5:631\n73#5,5:664\n73#5,5:683\n73#5,5:770\n1739#6:613\n1814#6,3:614\n1795#6,10:617\n2068#6:627\n2069#6:629\n1805#6:630\n1795#6,10:636\n2068#6:646\n1795#6,10:647\n2068#6:657\n2069#6:659\n1805#6:660\n2069#6:662\n1805#6:663\n1795#6,10:669\n2068#6:679\n2069#6:681\n1805#6:682\n1795#6,10:688\n2068#6:698\n2069#6:700\n1805#6:701\n1795#6,10:702\n2068#6:712\n2069#6:714\n1805#6:715\n1795#6,10:716\n2068#6:726\n2069#6:728\n1805#6:729\n1795#6,10:730\n2068#6:740\n2069#6:742\n1805#6:743\n296#6,2:744\n2068#6:769\n2068#6,2:775\n2069#6:777\n2068#6,2:824\n2068#6,2:849\n*S KotlinDebug\n*F\n+ 1 AllMovieLandProvider.kt\ncom/phisher98/AllMovieLandProvider\n*L\n79#1:583\n139#1:628\n150#1:658\n149#1:661\n176#1:680\n201#1:699\n202#1:713\n203#1:727\n219#1:741\n230#1:749\n267#1:781\n317#1:804\n347#1:829\n79#1:580,2\n79#1:582\n79#1:584,15\n79#1:601,2\n230#1:746,2\n230#1:748\n230#1:750,15\n230#1:767,2\n267#1:778,2\n267#1:780\n267#1:782,15\n267#1:799,2\n317#1:801,2\n317#1:803\n317#1:805,15\n317#1:822,2\n347#1:826,2\n347#1:828\n347#1:830,15\n347#1:847,2\n79#1:599\n79#1:600\n230#1:765\n230#1:766\n267#1:797\n267#1:798\n317#1:820\n317#1:821\n347#1:845\n347#1:846\n117#1:603,5\n121#1:608,5\n146#1:631,5\n174#1:664,5\n193#1:683,5\n238#1:770,5\n123#1:613\n123#1:614,3\n139#1:617,10\n139#1:627\n139#1:629\n139#1:630\n149#1:636,10\n149#1:646\n150#1:647,10\n150#1:657\n150#1:659\n150#1:660\n149#1:662\n149#1:663\n176#1:669,10\n176#1:679\n176#1:681\n176#1:682\n201#1:688,10\n201#1:698\n201#1:700\n201#1:701\n202#1:702,10\n202#1:712\n202#1:714\n202#1:715\n203#1:716,10\n203#1:726\n203#1:728\n203#1:729\n219#1:730,10\n219#1:740\n219#1:742\n219#1:743\n224#1:744,2\n232#1:769\n242#1:775,2\n232#1:777\n327#1:824,2\n350#1:849,2\n*E\n"})
public final class AllMovieLandProvider extends MainAPI {

    @NotNull
    public static final String TMDB_API = "https://api.themoviedb.org/3";

    @NotNull
    public static final String TMDB_API_KEY = "1865f43a0549ca50d341dd9ab8b29f49";

    @NotNull
    public static final String TMDB_IMG = "https://image.tmdb.org/t/p/original";

    @NotNull
    private String mainUrl = "https://mapi.elochkaigolochla.com";

    @NotNull
    private String name = "AllMovieLand";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "hi";
    private final boolean hasDownloadSupport = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.TvSeries});

    @NotNull
    private final String sessionUa = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36";

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to(getMainUrl() + "/api/v1/catalog", "Home")});

    /* JADX INFO: compiled from: AllMovieLandProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TvType.values().length];
            try {
                iArr[TvType.TvSeries.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.phisher98.AllMovieLandProvider$fetchTmdbMeta$1 */
    /* JADX INFO: compiled from: AllMovieLandProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.AllMovieLandProvider", f = "AllMovieLandProvider.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {116, 120}, m = "fetchTmdbMeta", n = {"title", "year", "$this$fetchTmdbMeta_u24lambda_u240", "type", "yearParam", "isSeries", "title", "year", "$this$fetchTmdbMeta_u24lambda_u240", "type", "yearParam", "tmdbId", "isSeries"}, nl = {117, 121}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0"}, v = 2)
    static final class C00001 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
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
            return AllMovieLandProvider.this.fetchTmdbMeta(null, null, false, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.AllMovieLandProvider$getDlPayload$1 */
    /* JADX INFO: compiled from: AllMovieLandProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.AllMovieLandProvider", f = "AllMovieLandProvider.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {76, 83}, m = "getDlPayload", n = {"iframeUrl", "referer", "baseUrl", "iframeUrl", "referer", "baseUrl", "doc", "scriptHtml", "jsonStr", "meta", "tokenKey", "fileEndpoint"}, nl = {77, 87}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;
        /* synthetic */ Object result;

        C00011(Continuation<? super C00011> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AllMovieLandProvider.this.getDlPayload(null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.AllMovieLandProvider$getM3u8Text$1 */
    /* JADX INFO: compiled from: AllMovieLandProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.AllMovieLandProvider", f = "AllMovieLandProvider.kt", i = {0, 0, 0}, l = {92}, m = "getM3u8Text", n = {"playerDomain", "tokenKey", "fileId"}, nl = {96}, s = {"L$0", "L$1", "L$2"}, v = 2)
    static final class C00021 extends ContinuationImpl {
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
            return AllMovieLandProvider.this.getM3u8Text(null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.AllMovieLandProvider$getMainPage$1 */
    /* JADX INFO: compiled from: AllMovieLandProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.AllMovieLandProvider", f = "AllMovieLandProvider.kt", i = {0, 0}, l = {146}, m = "getMainPage", n = {"request", "page"}, nl = {579}, s = {"L$0", "I$0"}, v = 2)
    static final class C00031 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00031(Continuation<? super C00031> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AllMovieLandProvider.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.AllMovieLandProvider$load$1 */
    /* JADX INFO: compiled from: AllMovieLandProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.AllMovieLandProvider", f = "AllMovieLandProvider.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}, l = {193, 211, 226, 237, 279, 294}, m = "load", n = {"url", "url", "detail", "title", "type", "poster", "year", "plot", "duration", "tags", "actors", "trailer", "imdb", "score", "url", "detail", "title", "type", "poster", "year", "plot", "duration", "tags", "actors", "trailer", "imdb", "score", "tmdb", "finalTitle", "finalPlot", "finalPoster", "finalBackdrop", "finalScore", "finalActors", "finalTags", "episodes", "firstIframe", "url", "detail", "title", "type", "poster", "year", "plot", "duration", "tags", "actors", "trailer", "imdb", "score", "tmdb", "finalTitle", "finalPlot", "finalPoster", "finalBackdrop", "finalScore", "finalActors", "finalTags", "episodes", "firstIframe", "payload", "cleanedRaw", "seasons", "$this$forEach$iv", "element$iv", "season", "seasonNum", "$this$load_u24lambda_u249_u240", "url", "detail", "title", "type", "poster", "year", "plot", "duration", "tags", "actors", "trailer", "imdb", "score", "tmdb", "finalTitle", "finalPlot", "finalPoster", "finalBackdrop", "finalScore", "finalActors", "finalTags", "episodes", "firstIframe", "url", "detail", "title", "type", "poster", "year", "plot", "duration", "tags", "actors", "trailer", "imdb", "score", "tmdb", "finalTitle", "finalPlot", "finalPoster", "finalBackdrop", "finalScore", "finalActors", "finalTags"}, nl = {579, 212, 227, 238, 294, 221}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$28", "L$29", "L$30", "L$31", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20"}, v = 2)
    static final class C00041 extends ContinuationImpl {
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
            return AllMovieLandProvider.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.AllMovieLandProvider$loadLinks$1 */
    /* JADX INFO: compiled from: AllMovieLandProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.AllMovieLandProvider", f = "AllMovieLandProvider.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {328, 351}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "episodeData", "playerDomain", "tokenKey", "headers", "$this$forEach$iv", "element$iv", "file", "isCasting", "data", "subtitleCallback", "callback", "episodeData", "players", "$this$forEach$iv", "element$iv", "player", "isCasting"}, nl = {343, 397}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$9", "L$10", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "Z$0"}, v = 2)
    static final class C00071 extends ContinuationImpl {
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

        C00071(Continuation<? super C00071> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AllMovieLandProvider.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.AllMovieLandProvider$search$1 */
    /* JADX INFO: compiled from: AllMovieLandProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.AllMovieLandProvider", f = "AllMovieLandProvider.kt", i = {0}, l = {172}, m = "search", n = {"query"}, nl = {174}, s = {"L$0"}, v = 2)
    static final class C00101 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00101(Continuation<? super C00101> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AllMovieLandProvider.this.search(null, (Continuation) this);
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

    private final String getBaseUrl(String url) {
        Url it = URLUtilsKt.Url(url);
        return it.getProtocol().getName() + "://" + it.getHost();
    }

    private final String extractJsonObject(String script) {
        int start = StringsKt.indexOf$default(script, '{', 0, false, 6, (Object) null);
        int end = StringsKt.lastIndexOf$default(script, '}', 0, false, 6, (Object) null);
        if (start == -1 || end <= start) {
            return null;
        }
        String strSubstring = script.substring(start, end + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    private final String cleanFolderJson(String raw) {
        return new Regex("\\[\\s*],\\s*").replace(new Regex(",\\s*\\[\\s*]").replace(raw, ""), "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:20:0x00de  */
    /* JADX WARN: Code duplicated, block: B:22:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:29:0x0119  */
    /* JADX WARN: Code duplicated, block: B:41:0x0151  */
    /* JADX WARN: Code duplicated, block: B:42:0x0153  */
    /* JADX WARN: Code duplicated, block: B:51:0x0170 A[Catch: Exception -> 0x018b, TRY_LEAVE, TryCatch #1 {Exception -> 0x018b, blocks: (B:39:0x014b, B:43:0x0154, B:51:0x0170, B:50:0x016a, B:38:0x0141, B:45:0x015a), top: B:78:0x0141, inners: #4, #7 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x0196  */
    /* JADX WARN: Code duplicated, block: B:62:0x019c  */
    /* JADX WARN: Code duplicated, block: B:65:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:68:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:69:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:72:0x024b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:73:0x024c  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:82:0x011c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:84:0x015a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public final Object getDlPayload(String iframeUrl, String referer, Continuation<? super DlPayload> continuation) {
        C00011 c00011;
        Object obj;
        Object obj2;
        C00011 c00012;
        String referer2;
        String referer3;
        String baseUrl;
        Document doc;
        String scriptHtml;
        String jsonStr;
        Object obj3;
        Document doc2;
        Object objDecodeFromString;
        PlayerMeta meta;
        String tokenKey;
        String fileEndpoint;
        String baseUrl2;
        Object objPost$default;
        String tokenKey2;
        String baseUrl3;
        Object obj4;
        DeserializationStrategy deserializationStrategy;
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
        C00011 c00013 = c00011;
        Object $result = c00013.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00013.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String baseUrl4 = getBaseUrl(iframeUrl);
                Requests app = MainActivityKt.getApp();
                c00013.L$0 = iframeUrl;
                c00013.L$1 = SpillingKt.nullOutSpilledVariable(referer);
                c00013.L$2 = baseUrl4;
                c00013.label = 1;
                obj = coroutine_suspended;
                obj2 = Requests.get$default(app, iframeUrl, (Map) null, referer, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00013, 4090, (Object) null);
                c00012 = c00013;
                if (obj2 == obj) {
                    return obj;
                }
                referer2 = iframeUrl;
                referer3 = referer;
                baseUrl = baseUrl4;
                doc = ((NiceResponse) obj2).getDocument();
                scriptHtml = doc.select("script:containsData(HDVBPlayer)").html();
                jsonStr = extractJsonObject(scriptHtml);
                if (jsonStr == null) {
                    return new DlPayload(baseUrl, "", "");
                }
                AppUtils appUtils = AppUtils.INSTANCE;
                try {
                    try {
                        Result.Companion companion = Result.Companion;
                        KType kTypeTypeOf = Reflection.typeOf(PlayerMeta.class);
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                        obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                    } catch (Exception e) {
                        doc2 = doc;
                        objDecodeFromString = null;
                        meta = (PlayerMeta) objDecodeFromString;
                        if (meta == null) {
                            return new DlPayload(baseUrl, "", "");
                        }
                        String key = meta.getKey();
                        tokenKey = key != null ? key : "";
                        if (StringsKt.startsWith$default(meta.getFile(), "http", false, 2, (Object) null)) {
                            fileEndpoint = meta.getFile();
                        } else {
                            fileEndpoint = baseUrl + meta.getFile();
                        }
                        String fileEndpoint2 = fileEndpoint;
                        Requests app2 = MainActivityKt.getApp();
                        Map mapMapOf = MapsKt.mapOf(TuplesKt.to("X-CSRF-TOKEN", tokenKey));
                        c00012.L$0 = SpillingKt.nullOutSpilledVariable(referer2);
                        c00012.L$1 = SpillingKt.nullOutSpilledVariable(referer3);
                        c00012.L$2 = baseUrl;
                        c00012.L$3 = SpillingKt.nullOutSpilledVariable(doc2);
                        c00012.L$4 = SpillingKt.nullOutSpilledVariable(scriptHtml);
                        c00012.L$5 = SpillingKt.nullOutSpilledVariable(jsonStr);
                        c00012.L$6 = SpillingKt.nullOutSpilledVariable(meta);
                        c00012.L$7 = tokenKey;
                        c00012.L$8 = SpillingKt.nullOutSpilledVariable(fileEndpoint2);
                        c00012.label = 2;
                        baseUrl2 = baseUrl;
                        objPost$default = Requests.post$default(app2, fileEndpoint2, mapMapOf, referer2, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00012, 65528, (Object) null);
                        if (objPost$default == obj) {
                            return obj;
                        }
                        tokenKey2 = tokenKey;
                        baseUrl3 = baseUrl2;
                        $result = objPost$default;
                        String raw = ((NiceResponse) $result).getText();
                        return new DlPayload(baseUrl3, tokenKey2, raw);
                    }
                    break;
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                }
                if (Result.exceptionOrNull-impl(obj3) != null) {
                    doc2 = doc;
                } else {
                    try {
                        Result.Companion companion3 = Result.Companion;
                        doc2 = doc;
                        try {
                            obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(PlayerMeta.class), (List) null, 2, (Object) null));
                            break;
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                Result.Companion companion4 = Result.Companion;
                                obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                            } catch (Exception e2) {
                                objDecodeFromString = null;
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        doc2 = doc;
                    }
                }
                if (Result.isFailure-impl(obj3)) {
                    obj4 = null;
                } else {
                    obj4 = obj3;
                }
                deserializationStrategy = (KSerializer) obj4;
                if (deserializationStrategy != null) {
                    try {
                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, jsonStr);
                    } catch (SerializationException e3) {
                        ArchComponentExtKt.logError(e3);
                        ObjectMapper $this$readValue$iv$iv$iv = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv$iv.readValue(jsonStr, new TypeReference<PlayerMeta>() { // from class: com.phisher98.AllMovieLandProvider$getDlPayload$$inlined$tryParseJson$1
                        });
                    } catch (Throwable th4) {
                        ObjectMapper $this$readValue$iv$iv$iv2 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv$iv2.readValue(jsonStr, new TypeReference<PlayerMeta>() { // from class: com.phisher98.AllMovieLandProvider$getDlPayload$$inlined$tryParseJson$1
                        });
                    }
                } else {
                    ObjectMapper $this$readValue$iv$iv$iv3 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv$iv3.readValue(jsonStr, new TypeReference<PlayerMeta>() { // from class: com.phisher98.AllMovieLandProvider$getDlPayload$$inlined$tryParseJson$1
                    });
                }
                meta = (PlayerMeta) objDecodeFromString;
                if (meta == null) {
                    return new DlPayload(baseUrl, "", "");
                }
                String key2 = meta.getKey();
                tokenKey = key2 != null ? key2 : "";
                if (StringsKt.startsWith$default(meta.getFile(), "http", false, 2, (Object) null)) {
                    fileEndpoint = meta.getFile();
                } else {
                    fileEndpoint = baseUrl + meta.getFile();
                }
                String fileEndpoint3 = fileEndpoint;
                Requests app3 = MainActivityKt.getApp();
                Map mapMapOf2 = MapsKt.mapOf(TuplesKt.to("X-CSRF-TOKEN", tokenKey));
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(referer2);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(referer3);
                c00012.L$2 = baseUrl;
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(doc2);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(scriptHtml);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(jsonStr);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(meta);
                c00012.L$7 = tokenKey;
                c00012.L$8 = SpillingKt.nullOutSpilledVariable(fileEndpoint3);
                c00012.label = 2;
                baseUrl2 = baseUrl;
                objPost$default = Requests.post$default(app3, fileEndpoint3, mapMapOf2, referer2, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00012, 65528, (Object) null);
                if (objPost$default == obj) {
                    return obj;
                }
                tokenKey2 = tokenKey;
                baseUrl3 = baseUrl2;
                $result = objPost$default;
                String raw2 = ((NiceResponse) $result).getText();
                return new DlPayload(baseUrl3, tokenKey2, raw2);
            case 1:
                String baseUrl5 = (String) c00013.L$2;
                String referer4 = (String) c00013.L$1;
                String iframeUrl2 = (String) c00013.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                referer3 = referer4;
                referer2 = iframeUrl2;
                c00012 = c00013;
                obj2 = $result;
                baseUrl = baseUrl5;
                doc = ((NiceResponse) obj2).getDocument();
                scriptHtml = doc.select("script:containsData(HDVBPlayer)").html();
                jsonStr = extractJsonObject(scriptHtml);
                if (jsonStr == null) {
                    return new DlPayload(baseUrl, "", "");
                }
                AppUtils appUtils2 = AppUtils.INSTANCE;
                Result.Companion companion5 = Result.Companion;
                KType kTypeTypeOf2 = Reflection.typeOf(PlayerMeta.class);
                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                if (Result.exceptionOrNull-impl(obj3) != null) {
                    Result.Companion companion6 = Result.Companion;
                    doc2 = doc;
                    obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(PlayerMeta.class), (List) null, 2, (Object) null));
                    break;
                } else {
                    doc2 = doc;
                }
                if (Result.isFailure-impl(obj3)) {
                    obj4 = null;
                } else {
                    obj4 = obj3;
                }
                deserializationStrategy = (KSerializer) obj4;
                if (deserializationStrategy != null) {
                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, jsonStr);
                } else {
                    ObjectMapper $this$readValue$iv$iv$iv4 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv$iv4.readValue(jsonStr, new TypeReference<PlayerMeta>() { // from class: com.phisher98.AllMovieLandProvider$getDlPayload$$inlined$tryParseJson$1
                    });
                }
                meta = (PlayerMeta) objDecodeFromString;
                if (meta == null) {
                    return new DlPayload(baseUrl, "", "");
                }
                String key3 = meta.getKey();
                tokenKey = key3 != null ? key3 : "";
                if (StringsKt.startsWith$default(meta.getFile(), "http", false, 2, (Object) null)) {
                    fileEndpoint = meta.getFile();
                } else {
                    fileEndpoint = baseUrl + meta.getFile();
                }
                String fileEndpoint4 = fileEndpoint;
                Requests app4 = MainActivityKt.getApp();
                Map mapMapOf3 = MapsKt.mapOf(TuplesKt.to("X-CSRF-TOKEN", tokenKey));
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(referer2);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(referer3);
                c00012.L$2 = baseUrl;
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(doc2);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(scriptHtml);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(jsonStr);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(meta);
                c00012.L$7 = tokenKey;
                c00012.L$8 = SpillingKt.nullOutSpilledVariable(fileEndpoint4);
                c00012.label = 2;
                baseUrl2 = baseUrl;
                objPost$default = Requests.post$default(app4, fileEndpoint4, mapMapOf3, referer2, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00012, 65528, (Object) null);
                if (objPost$default == obj) {
                    return obj;
                }
                tokenKey2 = tokenKey;
                baseUrl3 = baseUrl2;
                $result = objPost$default;
                String raw3 = ((NiceResponse) $result).getText();
                return new DlPayload(baseUrl3, tokenKey2, raw3);
            case 2:
                tokenKey2 = (String) c00013.L$7;
                baseUrl3 = (String) c00013.L$2;
                ResultKt.throwOnFailure($result);
                String raw4 = ((NiceResponse) $result).getText();
                return new DlPayload(baseUrl3, tokenKey2, raw4);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object getM3u8Text(String playerDomain, String tokenKey, String fileId, Continuation<? super String> continuation) {
        C00021 c00021;
        AllMovieLandProvider allMovieLandProvider;
        if (continuation instanceof C00021) {
            c00021 = (C00021) continuation;
            if ((c00021.label & Integer.MIN_VALUE) != 0) {
                c00021.label -= Integer.MIN_VALUE;
                allMovieLandProvider = this;
            } else {
                allMovieLandProvider = this;
                c00021 = allMovieLandProvider.new C00021(continuation);
            }
        } else {
            allMovieLandProvider = this;
            c00021 = allMovieLandProvider.new C00021(continuation);
        }
        Object $result = c00021.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00021.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Map mapMapOf = MapsKt.mapOf(TuplesKt.to("X-CSRF-TOKEN", tokenKey));
                String str = allMovieLandProvider.getMainUrl() + '/';
                c00021.L$0 = SpillingKt.nullOutSpilledVariable(playerDomain);
                c00021.L$1 = SpillingKt.nullOutSpilledVariable(tokenKey);
                c00021.L$2 = SpillingKt.nullOutSpilledVariable(fileId);
                c00021.label = 1;
                $result = Requests.post$default(MainActivityKt.getApp(), playerDomain + "/playlist/" + fileId + ".txt", mapMapOf, str, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00021, 65528, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return ((NiceResponse) $result).getText();
    }

    /* JADX INFO: compiled from: AllMovieLandProvider.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\r¢\u0006\u0004\b\u0010\u0010\u0011J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00030\rHÆ\u0003J\u0089\u0001\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\rHÆ\u0001J\u0014\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010-\u001a\u00020.HÖ\u0081\u0004J\n\u0010/\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\r¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001d¨\u00060"}, d2 = {"Lcom/phisher98/AllMovieLandProvider$TmdbMeta;", "", "tmdbId", "", "title", "plot", "backdrop", "poster", "logo", "year", "score", "Lcom/lagradost/cloudstream3/Score;", "actors", "", "Lcom/lagradost/cloudstream3/ActorData;", "tags", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/lagradost/cloudstream3/Score;Ljava/util/List;Ljava/util/List;)V", "getTmdbId", "()Ljava/lang/String;", "getTitle", "getPlot", "getBackdrop", "getPoster", "getLogo", "getYear", "getScore", "()Lcom/lagradost/cloudstream3/Score;", "getActors", "()Ljava/util/List;", "getTags", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "", "toString", "AllMovieLandProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class TmdbMeta {

        @NotNull
        private final List<ActorData> actors;

        @Nullable
        private final String backdrop;

        @Nullable
        private final String logo;

        @Nullable
        private final String plot;

        @Nullable
        private final String poster;

        @Nullable
        private final Score score;

        @NotNull
        private final List<String> tags;

        @Nullable
        private final String title;

        @Nullable
        private final String tmdbId;

        @Nullable
        private final String year;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ TmdbMeta copy$default(TmdbMeta tmdbMeta, String str, String str2, String str3, String str4, String str5, String str6, String str7, Score score, List list, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = tmdbMeta.tmdbId;
            }
            if ((i & 2) != 0) {
                str2 = tmdbMeta.title;
            }
            if ((i & 4) != 0) {
                str3 = tmdbMeta.plot;
            }
            if ((i & 8) != 0) {
                str4 = tmdbMeta.backdrop;
            }
            if ((i & 16) != 0) {
                str5 = tmdbMeta.poster;
            }
            if ((i & 32) != 0) {
                str6 = tmdbMeta.logo;
            }
            if ((i & 64) != 0) {
                str7 = tmdbMeta.year;
            }
            if ((i & 128) != 0) {
                score = tmdbMeta.score;
            }
            if ((i & 256) != 0) {
                list = tmdbMeta.actors;
            }
            if ((i & 512) != 0) {
                list2 = tmdbMeta.tags;
            }
            List list3 = list;
            List list4 = list2;
            String str8 = str7;
            Score score2 = score;
            String str9 = str5;
            String str10 = str6;
            return tmdbMeta.copy(str, str2, str3, str4, str9, str10, str8, score2, list3, list4);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getTmdbId() {
            return this.tmdbId;
        }

        @NotNull
        public final List<String> component10() {
            return this.tags;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getPlot() {
            return this.plot;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getBackdrop() {
            return this.backdrop;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getPoster() {
            return this.poster;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getLogo() {
            return this.logo;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getYear() {
            return this.year;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Score getScore() {
            return this.score;
        }

        @NotNull
        public final List<ActorData> component9() {
            return this.actors;
        }

        @NotNull
        public final TmdbMeta copy(@Nullable String tmdbId, @Nullable String title, @Nullable String plot, @Nullable String backdrop, @Nullable String poster, @Nullable String logo, @Nullable String year, @Nullable Score score, @NotNull List<ActorData> actors, @NotNull List<String> tags) {
            return new TmdbMeta(tmdbId, title, plot, backdrop, poster, logo, year, score, actors, tags);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TmdbMeta)) {
                return false;
            }
            TmdbMeta tmdbMeta = (TmdbMeta) other;
            return Intrinsics.areEqual(this.tmdbId, tmdbMeta.tmdbId) && Intrinsics.areEqual(this.title, tmdbMeta.title) && Intrinsics.areEqual(this.plot, tmdbMeta.plot) && Intrinsics.areEqual(this.backdrop, tmdbMeta.backdrop) && Intrinsics.areEqual(this.poster, tmdbMeta.poster) && Intrinsics.areEqual(this.logo, tmdbMeta.logo) && Intrinsics.areEqual(this.year, tmdbMeta.year) && Intrinsics.areEqual(this.score, tmdbMeta.score) && Intrinsics.areEqual(this.actors, tmdbMeta.actors) && Intrinsics.areEqual(this.tags, tmdbMeta.tags);
        }

        public int hashCode() {
            return ((((((((((((((((((this.tmdbId == null ? 0 : this.tmdbId.hashCode()) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.plot == null ? 0 : this.plot.hashCode())) * 31) + (this.backdrop == null ? 0 : this.backdrop.hashCode())) * 31) + (this.poster == null ? 0 : this.poster.hashCode())) * 31) + (this.logo == null ? 0 : this.logo.hashCode())) * 31) + (this.year == null ? 0 : this.year.hashCode())) * 31) + (this.score != null ? this.score.hashCode() : 0)) * 31) + this.actors.hashCode()) * 31) + this.tags.hashCode();
        }

        @NotNull
        public String toString() {
            return "TmdbMeta(tmdbId=" + this.tmdbId + ", title=" + this.title + ", plot=" + this.plot + ", backdrop=" + this.backdrop + ", poster=" + this.poster + ", logo=" + this.logo + ", year=" + this.year + ", score=" + this.score + ", actors=" + this.actors + ", tags=" + this.tags + ')';
        }

        public TmdbMeta(@Nullable String tmdbId, @Nullable String title, @Nullable String plot, @Nullable String backdrop, @Nullable String poster, @Nullable String logo, @Nullable String year, @Nullable Score score, @NotNull List<ActorData> list, @NotNull List<String> list2) {
            this.tmdbId = tmdbId;
            this.title = title;
            this.plot = plot;
            this.backdrop = backdrop;
            this.poster = poster;
            this.logo = logo;
            this.year = year;
            this.score = score;
            this.actors = list;
            this.tags = list2;
        }

        @Nullable
        public final String getTmdbId() {
            return this.tmdbId;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final String getPlot() {
            return this.plot;
        }

        @Nullable
        public final String getBackdrop() {
            return this.backdrop;
        }

        @Nullable
        public final String getPoster() {
            return this.poster;
        }

        @Nullable
        public final String getLogo() {
            return this.logo;
        }

        @Nullable
        public final String getYear() {
            return this.year;
        }

        @Nullable
        public final Score getScore() {
            return this.score;
        }

        @NotNull
        public final List<ActorData> getActors() {
            return this.actors;
        }

        @NotNull
        public final List<String> getTags() {
            return this.tags;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:100:0x0329  */
    /* JADX WARN: Code duplicated, block: B:106:0x033f  */
    /* JADX WARN: Code duplicated, block: B:109:0x0347 A[Catch: all -> 0x0455, TryCatch #1 {all -> 0x0455, blocks: (B:64:0x023a, B:66:0x023f, B:70:0x025c, B:165:0x046a, B:73:0x0264, B:76:0x026c, B:78:0x0272, B:79:0x0288, B:81:0x028e, B:83:0x029c, B:88:0x02af, B:90:0x02d1, B:91:0x02f9, B:93:0x030c, B:95:0x0315, B:97:0x031b, B:101:0x032b, B:103:0x0331, B:107:0x0341, B:109:0x0347, B:114:0x0358, B:116:0x036f, B:118:0x0375, B:123:0x0386, B:125:0x039d, B:127:0x03a5, B:129:0x03ab, B:134:0x03be, B:136:0x03dd, B:138:0x03e3, B:140:0x03e9, B:142:0x03f3, B:144:0x03fb, B:146:0x0406, B:148:0x0411, B:149:0x0423, B:151:0x0429, B:153:0x043a, B:155:0x0443, B:157:0x044d, B:156:0x0449, B:92:0x0304, B:69:0x0256), top: B:179:0x023a, inners: #6 }] */
    /* JADX WARN: Code duplicated, block: B:111:0x0352  */
    /* JADX WARN: Code duplicated, block: B:112:0x0353  */
    /* JADX WARN: Code duplicated, block: B:114:0x0358 A[Catch: all -> 0x0455, TryCatch #1 {all -> 0x0455, blocks: (B:64:0x023a, B:66:0x023f, B:70:0x025c, B:165:0x046a, B:73:0x0264, B:76:0x026c, B:78:0x0272, B:79:0x0288, B:81:0x028e, B:83:0x029c, B:88:0x02af, B:90:0x02d1, B:91:0x02f9, B:93:0x030c, B:95:0x0315, B:97:0x031b, B:101:0x032b, B:103:0x0331, B:107:0x0341, B:109:0x0347, B:114:0x0358, B:116:0x036f, B:118:0x0375, B:123:0x0386, B:125:0x039d, B:127:0x03a5, B:129:0x03ab, B:134:0x03be, B:136:0x03dd, B:138:0x03e3, B:140:0x03e9, B:142:0x03f3, B:144:0x03fb, B:146:0x0406, B:148:0x0411, B:149:0x0423, B:151:0x0429, B:153:0x043a, B:155:0x0443, B:157:0x044d, B:156:0x0449, B:92:0x0304, B:69:0x0256), top: B:179:0x023a, inners: #6 }] */
    /* JADX WARN: Code duplicated, block: B:115:0x036d  */
    /* JADX WARN: Code duplicated, block: B:118:0x0375 A[Catch: all -> 0x0455, TryCatch #1 {all -> 0x0455, blocks: (B:64:0x023a, B:66:0x023f, B:70:0x025c, B:165:0x046a, B:73:0x0264, B:76:0x026c, B:78:0x0272, B:79:0x0288, B:81:0x028e, B:83:0x029c, B:88:0x02af, B:90:0x02d1, B:91:0x02f9, B:93:0x030c, B:95:0x0315, B:97:0x031b, B:101:0x032b, B:103:0x0331, B:107:0x0341, B:109:0x0347, B:114:0x0358, B:116:0x036f, B:118:0x0375, B:123:0x0386, B:125:0x039d, B:127:0x03a5, B:129:0x03ab, B:134:0x03be, B:136:0x03dd, B:138:0x03e3, B:140:0x03e9, B:142:0x03f3, B:144:0x03fb, B:146:0x0406, B:148:0x0411, B:149:0x0423, B:151:0x0429, B:153:0x043a, B:155:0x0443, B:157:0x044d, B:156:0x0449, B:92:0x0304, B:69:0x0256), top: B:179:0x023a, inners: #6 }] */
    /* JADX WARN: Code duplicated, block: B:120:0x0380  */
    /* JADX WARN: Code duplicated, block: B:121:0x0381  */
    /* JADX WARN: Code duplicated, block: B:123:0x0386 A[Catch: all -> 0x0455, TryCatch #1 {all -> 0x0455, blocks: (B:64:0x023a, B:66:0x023f, B:70:0x025c, B:165:0x046a, B:73:0x0264, B:76:0x026c, B:78:0x0272, B:79:0x0288, B:81:0x028e, B:83:0x029c, B:88:0x02af, B:90:0x02d1, B:91:0x02f9, B:93:0x030c, B:95:0x0315, B:97:0x031b, B:101:0x032b, B:103:0x0331, B:107:0x0341, B:109:0x0347, B:114:0x0358, B:116:0x036f, B:118:0x0375, B:123:0x0386, B:125:0x039d, B:127:0x03a5, B:129:0x03ab, B:134:0x03be, B:136:0x03dd, B:138:0x03e3, B:140:0x03e9, B:142:0x03f3, B:144:0x03fb, B:146:0x0406, B:148:0x0411, B:149:0x0423, B:151:0x0429, B:153:0x043a, B:155:0x0443, B:157:0x044d, B:156:0x0449, B:92:0x0304, B:69:0x0256), top: B:179:0x023a, inners: #6 }] */
    /* JADX WARN: Code duplicated, block: B:124:0x039b  */
    /* JADX WARN: Code duplicated, block: B:135:0x03db  */
    /* JADX WARN: Code duplicated, block: B:138:0x03e3 A[Catch: all -> 0x0455, TryCatch #1 {all -> 0x0455, blocks: (B:64:0x023a, B:66:0x023f, B:70:0x025c, B:165:0x046a, B:73:0x0264, B:76:0x026c, B:78:0x0272, B:79:0x0288, B:81:0x028e, B:83:0x029c, B:88:0x02af, B:90:0x02d1, B:91:0x02f9, B:93:0x030c, B:95:0x0315, B:97:0x031b, B:101:0x032b, B:103:0x0331, B:107:0x0341, B:109:0x0347, B:114:0x0358, B:116:0x036f, B:118:0x0375, B:123:0x0386, B:125:0x039d, B:127:0x03a5, B:129:0x03ab, B:134:0x03be, B:136:0x03dd, B:138:0x03e3, B:140:0x03e9, B:142:0x03f3, B:144:0x03fb, B:146:0x0406, B:148:0x0411, B:149:0x0423, B:151:0x0429, B:153:0x043a, B:155:0x0443, B:157:0x044d, B:156:0x0449, B:92:0x0304, B:69:0x0256), top: B:179:0x023a, inners: #6 }] */
    /* JADX WARN: Code duplicated, block: B:140:0x03e9 A[Catch: all -> 0x0455, TryCatch #1 {all -> 0x0455, blocks: (B:64:0x023a, B:66:0x023f, B:70:0x025c, B:165:0x046a, B:73:0x0264, B:76:0x026c, B:78:0x0272, B:79:0x0288, B:81:0x028e, B:83:0x029c, B:88:0x02af, B:90:0x02d1, B:91:0x02f9, B:93:0x030c, B:95:0x0315, B:97:0x031b, B:101:0x032b, B:103:0x0331, B:107:0x0341, B:109:0x0347, B:114:0x0358, B:116:0x036f, B:118:0x0375, B:123:0x0386, B:125:0x039d, B:127:0x03a5, B:129:0x03ab, B:134:0x03be, B:136:0x03dd, B:138:0x03e3, B:140:0x03e9, B:142:0x03f3, B:144:0x03fb, B:146:0x0406, B:148:0x0411, B:149:0x0423, B:151:0x0429, B:153:0x043a, B:155:0x0443, B:157:0x044d, B:156:0x0449, B:92:0x0304, B:69:0x0256), top: B:179:0x023a, inners: #6 }] */
    /* JADX WARN: Code duplicated, block: B:141:0x03f1  */
    /* JADX WARN: Code duplicated, block: B:144:0x03fb A[Catch: all -> 0x0455, TryCatch #1 {all -> 0x0455, blocks: (B:64:0x023a, B:66:0x023f, B:70:0x025c, B:165:0x046a, B:73:0x0264, B:76:0x026c, B:78:0x0272, B:79:0x0288, B:81:0x028e, B:83:0x029c, B:88:0x02af, B:90:0x02d1, B:91:0x02f9, B:93:0x030c, B:95:0x0315, B:97:0x031b, B:101:0x032b, B:103:0x0331, B:107:0x0341, B:109:0x0347, B:114:0x0358, B:116:0x036f, B:118:0x0375, B:123:0x0386, B:125:0x039d, B:127:0x03a5, B:129:0x03ab, B:134:0x03be, B:136:0x03dd, B:138:0x03e3, B:140:0x03e9, B:142:0x03f3, B:144:0x03fb, B:146:0x0406, B:148:0x0411, B:149:0x0423, B:151:0x0429, B:153:0x043a, B:155:0x0443, B:157:0x044d, B:156:0x0449, B:92:0x0304, B:69:0x0256), top: B:179:0x023a, inners: #6 }] */
    /* JADX WARN: Code duplicated, block: B:145:0x0404  */
    /* JADX WARN: Code duplicated, block: B:148:0x0411 A[Catch: all -> 0x0455, TryCatch #1 {all -> 0x0455, blocks: (B:64:0x023a, B:66:0x023f, B:70:0x025c, B:165:0x046a, B:73:0x0264, B:76:0x026c, B:78:0x0272, B:79:0x0288, B:81:0x028e, B:83:0x029c, B:88:0x02af, B:90:0x02d1, B:91:0x02f9, B:93:0x030c, B:95:0x0315, B:97:0x031b, B:101:0x032b, B:103:0x0331, B:107:0x0341, B:109:0x0347, B:114:0x0358, B:116:0x036f, B:118:0x0375, B:123:0x0386, B:125:0x039d, B:127:0x03a5, B:129:0x03ab, B:134:0x03be, B:136:0x03dd, B:138:0x03e3, B:140:0x03e9, B:142:0x03f3, B:144:0x03fb, B:146:0x0406, B:148:0x0411, B:149:0x0423, B:151:0x0429, B:153:0x043a, B:155:0x0443, B:157:0x044d, B:156:0x0449, B:92:0x0304, B:69:0x0256), top: B:179:0x023a, inners: #6 }] */
    /* JADX WARN: Code duplicated, block: B:151:0x0429 A[Catch: all -> 0x0455, TryCatch #1 {all -> 0x0455, blocks: (B:64:0x023a, B:66:0x023f, B:70:0x025c, B:165:0x046a, B:73:0x0264, B:76:0x026c, B:78:0x0272, B:79:0x0288, B:81:0x028e, B:83:0x029c, B:88:0x02af, B:90:0x02d1, B:91:0x02f9, B:93:0x030c, B:95:0x0315, B:97:0x031b, B:101:0x032b, B:103:0x0331, B:107:0x0341, B:109:0x0347, B:114:0x0358, B:116:0x036f, B:118:0x0375, B:123:0x0386, B:125:0x039d, B:127:0x03a5, B:129:0x03ab, B:134:0x03be, B:136:0x03dd, B:138:0x03e3, B:140:0x03e9, B:142:0x03f3, B:144:0x03fb, B:146:0x0406, B:148:0x0411, B:149:0x0423, B:151:0x0429, B:153:0x043a, B:155:0x0443, B:157:0x044d, B:156:0x0449, B:92:0x0304, B:69:0x0256), top: B:179:0x023a, inners: #6 }] */
    /* JADX WARN: Code duplicated, block: B:153:0x043a A[Catch: all -> 0x0455, TryCatch #1 {all -> 0x0455, blocks: (B:64:0x023a, B:66:0x023f, B:70:0x025c, B:165:0x046a, B:73:0x0264, B:76:0x026c, B:78:0x0272, B:79:0x0288, B:81:0x028e, B:83:0x029c, B:88:0x02af, B:90:0x02d1, B:91:0x02f9, B:93:0x030c, B:95:0x0315, B:97:0x031b, B:101:0x032b, B:103:0x0331, B:107:0x0341, B:109:0x0347, B:114:0x0358, B:116:0x036f, B:118:0x0375, B:123:0x0386, B:125:0x039d, B:127:0x03a5, B:129:0x03ab, B:134:0x03be, B:136:0x03dd, B:138:0x03e3, B:140:0x03e9, B:142:0x03f3, B:144:0x03fb, B:146:0x0406, B:148:0x0411, B:149:0x0423, B:151:0x0429, B:153:0x043a, B:155:0x0443, B:157:0x044d, B:156:0x0449, B:92:0x0304, B:69:0x0256), top: B:179:0x023a, inners: #6 }] */
    /* JADX WARN: Code duplicated, block: B:156:0x0449 A[Catch: all -> 0x0455, TryCatch #1 {all -> 0x0455, blocks: (B:64:0x023a, B:66:0x023f, B:70:0x025c, B:165:0x046a, B:73:0x0264, B:76:0x026c, B:78:0x0272, B:79:0x0288, B:81:0x028e, B:83:0x029c, B:88:0x02af, B:90:0x02d1, B:91:0x02f9, B:93:0x030c, B:95:0x0315, B:97:0x031b, B:101:0x032b, B:103:0x0331, B:107:0x0341, B:109:0x0347, B:114:0x0358, B:116:0x036f, B:118:0x0375, B:123:0x0386, B:125:0x039d, B:127:0x03a5, B:129:0x03ab, B:134:0x03be, B:136:0x03dd, B:138:0x03e3, B:140:0x03e9, B:142:0x03f3, B:144:0x03fb, B:146:0x0406, B:148:0x0411, B:149:0x0423, B:151:0x0429, B:153:0x043a, B:155:0x0443, B:157:0x044d, B:156:0x0449, B:92:0x0304, B:69:0x0256), top: B:179:0x023a, inners: #6 }] */
    /* JADX WARN: Code duplicated, block: B:163:0x0461 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:177:0x049a  */
    /* JADX WARN: Code duplicated, block: B:201:0x0441 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:202:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:34:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:40:0x015e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:41:0x015f  */
    /* JADX WARN: Code duplicated, block: B:52:0x019a A[Catch: all -> 0x046f, TryCatch #9 {all -> 0x046f, blocks: (B:42:0x016b, B:50:0x0195, B:52:0x019a, B:54:0x01a1, B:56:0x01aa, B:58:0x01b5, B:49:0x018f, B:44:0x0170), top: B:192:0x016b, inners: #10 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x0260  */
    /* JADX WARN: Code duplicated, block: B:73:0x0264 A[Catch: all -> 0x0455, TRY_LEAVE, TryCatch #1 {all -> 0x0455, blocks: (B:64:0x023a, B:66:0x023f, B:70:0x025c, B:165:0x046a, B:73:0x0264, B:76:0x026c, B:78:0x0272, B:79:0x0288, B:81:0x028e, B:83:0x029c, B:88:0x02af, B:90:0x02d1, B:91:0x02f9, B:93:0x030c, B:95:0x0315, B:97:0x031b, B:101:0x032b, B:103:0x0331, B:107:0x0341, B:109:0x0347, B:114:0x0358, B:116:0x036f, B:118:0x0375, B:123:0x0386, B:125:0x039d, B:127:0x03a5, B:129:0x03ab, B:134:0x03be, B:136:0x03dd, B:138:0x03e3, B:140:0x03e9, B:142:0x03f3, B:144:0x03fb, B:146:0x0406, B:148:0x0411, B:149:0x0423, B:151:0x0429, B:153:0x043a, B:155:0x0443, B:157:0x044d, B:156:0x0449, B:92:0x0304, B:69:0x0256), top: B:179:0x023a, inners: #6 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:89:0x02cb  */
    /* JADX WARN: Code duplicated, block: B:92:0x0304 A[Catch: all -> 0x0455, TryCatch #1 {all -> 0x0455, blocks: (B:64:0x023a, B:66:0x023f, B:70:0x025c, B:165:0x046a, B:73:0x0264, B:76:0x026c, B:78:0x0272, B:79:0x0288, B:81:0x028e, B:83:0x029c, B:88:0x02af, B:90:0x02d1, B:91:0x02f9, B:93:0x030c, B:95:0x0315, B:97:0x031b, B:101:0x032b, B:103:0x0331, B:107:0x0341, B:109:0x0347, B:114:0x0358, B:116:0x036f, B:118:0x0375, B:123:0x0386, B:125:0x039d, B:127:0x03a5, B:129:0x03ab, B:134:0x03be, B:136:0x03dd, B:138:0x03e3, B:140:0x03e9, B:142:0x03f3, B:144:0x03fb, B:146:0x0406, B:148:0x0411, B:149:0x0423, B:151:0x0429, B:153:0x043a, B:155:0x0443, B:157:0x044d, B:156:0x0449, B:92:0x0304, B:69:0x0256), top: B:179:0x023a, inners: #6 }] */
    /* JADX WARN: Code duplicated, block: B:95:0x0315 A[Catch: all -> 0x0455, TryCatch #1 {all -> 0x0455, blocks: (B:64:0x023a, B:66:0x023f, B:70:0x025c, B:165:0x046a, B:73:0x0264, B:76:0x026c, B:78:0x0272, B:79:0x0288, B:81:0x028e, B:83:0x029c, B:88:0x02af, B:90:0x02d1, B:91:0x02f9, B:93:0x030c, B:95:0x0315, B:97:0x031b, B:101:0x032b, B:103:0x0331, B:107:0x0341, B:109:0x0347, B:114:0x0358, B:116:0x036f, B:118:0x0375, B:123:0x0386, B:125:0x039d, B:127:0x03a5, B:129:0x03ab, B:134:0x03be, B:136:0x03dd, B:138:0x03e3, B:140:0x03e9, B:142:0x03f3, B:144:0x03fb, B:146:0x0406, B:148:0x0411, B:149:0x0423, B:151:0x0429, B:153:0x043a, B:155:0x0443, B:157:0x044d, B:156:0x0449, B:92:0x0304, B:69:0x0256), top: B:179:0x023a, inners: #6 }] */
    /* JADX WARN: Not initialized variable reg: 10, insn: 0x0093: MOVE (r22 I:??[OBJECT, ARRAY]) = (r10 I:??[OBJECT, ARRAY] A[D('year' java.lang.Integer)]), block:B:19:0x008d */
    public final Object fetchTmdbMeta(String title, Integer year, boolean isSeries, Continuation<? super TmdbMeta> continuation) {
        C00001 c00001;
        Object obj;
        String yearParam;
        String type;
        String yearParam2;
        Object obj2;
        Object obj3;
        AllMovieLandProvider $this$fetchTmdbMeta_u24lambda_u240;
        Object obj4;
        String type2;
        boolean isSeries2;
        String title2;
        Integer year2;
        Object safe;
        TmdbSearchResponse tmdbSearchResponse;
        TmdbMeta tmdbMeta;
        List<TmdbSearchResult> results;
        TmdbSearchResult tmdbSearchResult;
        String tmdbId;
        String tmdbId2;
        Object safe2;
        TmdbDetail details;
        TmdbCredits credits;
        TmdbDetail details2;
        List metaActors;
        String it;
        String str;
        String it2;
        String str2;
        String it3;
        String str3;
        String it4;
        String str4;
        TmdbExternalIds external_ids;
        String str5;
        String release_date;
        String strTake;
        Double vote_average;
        String strValueOf;
        Iterable genres;
        List listEmptyList;
        Collection destination$iv$iv;
        String name;
        String it5;
        Iterable cast;
        String imgPath;
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
        C00001 c00002 = c00001;
        Object $result = c00002.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (c00002.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    try {
                        Result.Companion companion = Result.Companion;
                        AllMovieLandProvider $this$fetchTmdbMeta_u24lambda_u241 = this;
                        String type3 = isSeries ? "tv" : "movie";
                        if (year == null) {
                            yearParam = "";
                            Requests app = MainActivityKt.getApp();
                            String str6 = "https://api.themoviedb.org/3/search/" + type3 + "?api_key=1865f43a0549ca50d341dd9ab8b29f49&query=" + StringsKt.trim(title).toString() + yearParam;
                            c00002.L$0 = SpillingKt.nullOutSpilledVariable(title);
                            c00002.L$1 = SpillingKt.nullOutSpilledVariable(year);
                            c00002.L$2 = SpillingKt.nullOutSpilledVariable($this$fetchTmdbMeta_u24lambda_u241);
                            c00002.L$3 = type3;
                            c00002.L$4 = SpillingKt.nullOutSpilledVariable(yearParam);
                            c00002.Z$0 = isSeries;
                            c00002.label = 1;
                            type = type3;
                            yearParam2 = yearParam;
                            obj2 = coroutine_suspended;
                            obj3 = Requests.get$default(app, str6, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00002, 4094, (Object) null);
                            c00002 = c00002;
                            if (obj3 == obj2) {
                                return obj2;
                            }
                            $this$fetchTmdbMeta_u24lambda_u240 = $this$fetchTmdbMeta_u24lambda_u241;
                            obj4 = obj3;
                            type2 = type;
                            isSeries2 = isSeries;
                            title2 = title;
                            year2 = year;
                            NiceResponse this_$iv = (NiceResponse) obj4;
                            ResponseParser parser = this_$iv.getParser();
                            Intrinsics.checkNotNull(parser);
                            safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(TmdbSearchResponse.class));
                            tmdbSearchResponse = (TmdbSearchResponse) safe;
                            if (tmdbSearchResponse != null) {
                            }
                            tmdbMeta = null;
                            obj = Result.constructor-impl(tmdbMeta);
                        } else {
                            try {
                                if (year.intValue() > 0) {
                                    yearParam = "&year=" + year.intValue();
                                } else {
                                    yearParam = "";
                                }
                                Requests app2 = MainActivityKt.getApp();
                                String str7 = "https://api.themoviedb.org/3/search/" + type3 + "?api_key=1865f43a0549ca50d341dd9ab8b29f49&query=" + StringsKt.trim(title).toString() + yearParam;
                                c00002.L$0 = SpillingKt.nullOutSpilledVariable(title);
                                c00002.L$1 = SpillingKt.nullOutSpilledVariable(year);
                                c00002.L$2 = SpillingKt.nullOutSpilledVariable($this$fetchTmdbMeta_u24lambda_u241);
                                c00002.L$3 = type3;
                                c00002.L$4 = SpillingKt.nullOutSpilledVariable(yearParam);
                                c00002.Z$0 = isSeries;
                                c00002.label = 1;
                                type = type3;
                                yearParam2 = yearParam;
                                obj2 = coroutine_suspended;
                                try {
                                    obj3 = Requests.get$default(app2, str7, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00002, 4094, (Object) null);
                                    c00002 = c00002;
                                    if (obj3 == obj2) {
                                        return obj2;
                                    }
                                    $this$fetchTmdbMeta_u24lambda_u240 = $this$fetchTmdbMeta_u24lambda_u241;
                                    obj4 = obj3;
                                    type2 = type;
                                    isSeries2 = isSeries;
                                    title2 = title;
                                    year2 = year;
                                    try {
                                        NiceResponse this_$iv2 = (NiceResponse) obj4;
                                        try {
                                            ResponseParser parser2 = this_$iv2.getParser();
                                            Intrinsics.checkNotNull(parser2);
                                            safe = parser2.parseSafe(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(TmdbSearchResponse.class));
                                        } catch (Exception e$iv) {
                                            e$iv.printStackTrace();
                                            safe = null;
                                        } catch (Throwable th) {
                                            th = th;
                                        }
                                        tmdbSearchResponse = (TmdbSearchResponse) safe;
                                        if (tmdbSearchResponse != null || (results = tmdbSearchResponse.getResults()) == null || (tmdbSearchResult = (TmdbSearchResult) CollectionsKt.firstOrNull(results)) == null || (tmdbId = String.valueOf(tmdbSearchResult.getId())) == null) {
                                            tmdbMeta = null;
                                            obj = Result.constructor-impl(tmdbMeta);
                                        } else {
                                            Requests app3 = MainActivityKt.getApp();
                                            String str8 = "https://api.themoviedb.org/3/" + type2 + '/' + tmdbId + "?api_key=1865f43a0549ca50d341dd9ab8b29f49&append_to_response=credits,external_ids";
                                            c00002.L$0 = SpillingKt.nullOutSpilledVariable(title2);
                                            c00002.L$1 = SpillingKt.nullOutSpilledVariable(year2);
                                            c00002.L$2 = SpillingKt.nullOutSpilledVariable($this$fetchTmdbMeta_u24lambda_u240);
                                            c00002.L$3 = SpillingKt.nullOutSpilledVariable(type2);
                                            c00002.L$4 = SpillingKt.nullOutSpilledVariable(yearParam2);
                                            c00002.L$5 = tmdbId;
                                            c00002.Z$0 = isSeries2;
                                            c00002.label = 2;
                                            try {
                                                $result = Requests.get$default(app3, str8, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00002, 4094, (Object) null);
                                                if ($result == obj2) {
                                                    return obj2;
                                                }
                                                tmdbId2 = tmdbId;
                                                try {
                                                    NiceResponse this_$iv3 = (NiceResponse) $result;
                                                    try {
                                                        ResponseParser parser3 = this_$iv3.getParser();
                                                        Intrinsics.checkNotNull(parser3);
                                                        safe2 = parser3.parseSafe(this_$iv3.getText(), Reflection.getOrCreateKotlinClass(TmdbDetail.class));
                                                    } catch (Exception e$iv2) {
                                                        e$iv2.printStackTrace();
                                                        safe2 = null;
                                                    }
                                                    details = (TmdbDetail) safe2;
                                                    if (details == null) {
                                                        tmdbMeta = null;
                                                    } else {
                                                        credits = details.getCredits();
                                                        if (credits != null || (cast = credits.getCast()) == null) {
                                                            details2 = details;
                                                            metaActors = CollectionsKt.emptyList();
                                                        } else {
                                                            Iterable $this$map$iv = cast;
                                                            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                                            for (Object item$iv$iv : $this$map$iv) {
                                                                TmdbCast cast2 = (TmdbCast) item$iv$iv;
                                                                String it6 = cast2.getProfile_path();
                                                                if (it6 == null) {
                                                                    imgPath = null;
                                                                } else {
                                                                    if (StringsKt.isBlank(it6)) {
                                                                        it6 = null;
                                                                    }
                                                                    if (it6 != null) {
                                                                        imgPath = TMDB_IMG + it6;
                                                                    } else {
                                                                        imgPath = null;
                                                                    }
                                                                }
                                                                destination$iv$iv2.add(new ActorData(new Actor(cast2.getName(), imgPath), (ActorRole) null, cast2.getCharacter(), (Actor) null, 10, (DefaultConstructorMarker) null));
                                                                details = details;
                                                                $this$map$iv = $this$map$iv;
                                                            }
                                                            details2 = details;
                                                            metaActors = (List) destination$iv$iv2;
                                                        }
                                                        it = details2.getName();
                                                        if (it == null) {
                                                            it = details2.getTitle();
                                                        }
                                                        if (it != null || StringsKt.isBlank(it)) {
                                                            str = null;
                                                        } else {
                                                            str = it;
                                                        }
                                                        it2 = details2.getOverview();
                                                        if (it2 != null || StringsKt.isBlank(it2)) {
                                                            str2 = null;
                                                        } else {
                                                            str2 = it2;
                                                        }
                                                        it3 = details2.getBackdrop_path();
                                                        if (it3 == null) {
                                                            str3 = null;
                                                        } else {
                                                            if (!StringsKt.isBlank(it3)) {
                                                                it3 = null;
                                                            }
                                                            if (it3 != null) {
                                                                str3 = TMDB_IMG + it3;
                                                            } else {
                                                                str3 = null;
                                                            }
                                                        }
                                                        it4 = details2.getPoster_path();
                                                        if (it4 == null) {
                                                            str4 = null;
                                                        } else {
                                                            if (!StringsKt.isBlank(it4)) {
                                                                it4 = null;
                                                            }
                                                            if (it4 != null) {
                                                                str4 = TMDB_IMG + it4;
                                                            } else {
                                                                str4 = null;
                                                            }
                                                        }
                                                        external_ids = details2.getExternal_ids();
                                                        if (external_ids != null || (it5 = external_ids.getImdb_id()) == null) {
                                                            str5 = null;
                                                        } else {
                                                            if (StringsKt.isBlank(it5)) {
                                                                it5 = null;
                                                            }
                                                            if (it5 != null) {
                                                                str5 = "https://live.metahub.space/logo/medium/" + it5 + "/img";
                                                            } else {
                                                                str5 = null;
                                                            }
                                                        }
                                                        release_date = details2.getRelease_date();
                                                        if (release_date == null) {
                                                            release_date = details2.getFirst_air_date();
                                                        }
                                                        if (release_date != null) {
                                                            strTake = StringsKt.take(release_date, 4);
                                                        } else {
                                                            strTake = null;
                                                        }
                                                        Score.Companion companion2 = Score.Companion;
                                                        vote_average = details2.getVote_average();
                                                        if (vote_average != null) {
                                                            strValueOf = String.valueOf(vote_average.doubleValue());
                                                        } else {
                                                            strValueOf = null;
                                                        }
                                                        Score scoreFrom10 = companion2.from10(strValueOf);
                                                        genres = details2.getGenres();
                                                        if (genres != null) {
                                                            Iterable $this$mapNotNull$iv = genres;
                                                            destination$iv$iv = new ArrayList();
                                                            for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                                                                name = ((TmdbGenre) element$iv$iv$iv).getName();
                                                                if (name != null) {
                                                                    destination$iv$iv.add(name);
                                                                }
                                                            }
                                                            listEmptyList = (List) destination$iv$iv;
                                                        } else {
                                                            listEmptyList = CollectionsKt.emptyList();
                                                        }
                                                        tmdbMeta = new TmdbMeta(tmdbId2, str, str2, str3, str4, str5, strTake, scoreFrom10, metaActors, listEmptyList);
                                                    }
                                                    obj = Result.constructor-impl(tmdbMeta);
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    Result.Companion companion3 = Result.Companion;
                                                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                                                }
                                            } catch (Throwable th3) {
                                                th = th3;
                                                Result.Companion companion4 = Result.Companion;
                                                obj = Result.constructor-impl(ResultKt.createFailure(th));
                                            }
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                    }
                                    Result.Companion companion5 = Result.Companion;
                                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                                } catch (Throwable th5) {
                                    th = th5;
                                }
                            } catch (Throwable th6) {
                                th = th6;
                            }
                        }
                        break;
                    } catch (Throwable th7) {
                        th = th7;
                    }
                    if (Result.isFailure-impl(obj)) {
                        return null;
                    }
                    return obj;
                case 1:
                    boolean isSeries3 = c00002.Z$0;
                    String yearParam3 = (String) c00002.L$4;
                    String type4 = (String) c00002.L$3;
                    AllMovieLandProvider $this$fetchTmdbMeta_u24lambda_u242 = (AllMovieLandProvider) c00002.L$2;
                    Integer year3 = (Integer) c00002.L$1;
                    String title3 = (String) c00002.L$0;
                    ResultKt.throwOnFailure($result);
                    obj4 = $result;
                    obj2 = coroutine_suspended;
                    yearParam2 = yearParam3;
                    type2 = type4;
                    $this$fetchTmdbMeta_u24lambda_u240 = $this$fetchTmdbMeta_u24lambda_u242;
                    year2 = year3;
                    isSeries2 = isSeries3;
                    title2 = title3;
                    NiceResponse this_$iv4 = (NiceResponse) obj4;
                    ResponseParser parser4 = this_$iv4.getParser();
                    Intrinsics.checkNotNull(parser4);
                    safe = parser4.parseSafe(this_$iv4.getText(), Reflection.getOrCreateKotlinClass(TmdbSearchResponse.class));
                    tmdbSearchResponse = (TmdbSearchResponse) safe;
                    if (tmdbSearchResponse != null) {
                    }
                    tmdbMeta = null;
                    obj = Result.constructor-impl(tmdbMeta);
                    if (Result.isFailure-impl(obj)) {
                        return null;
                    }
                    return obj;
                case 2:
                    boolean z = c00002.Z$0;
                    String tmdbId3 = (String) c00002.L$5;
                    ResultKt.throwOnFailure($result);
                    tmdbId2 = tmdbId3;
                    NiceResponse this_$iv5 = (NiceResponse) $result;
                    ResponseParser parser5 = this_$iv5.getParser();
                    Intrinsics.checkNotNull(parser5);
                    safe2 = parser5.parseSafe(this_$iv5.getText(), Reflection.getOrCreateKotlinClass(TmdbDetail.class));
                    details = (TmdbDetail) safe2;
                    if (details == null) {
                        tmdbMeta = null;
                    } else {
                        credits = details.getCredits();
                        if (credits != null) {
                            details2 = details;
                            metaActors = CollectionsKt.emptyList();
                        } else {
                            details2 = details;
                            metaActors = CollectionsKt.emptyList();
                        }
                        it = details2.getName();
                        if (it == null) {
                            it = details2.getTitle();
                        }
                        if (it != null) {
                            str = null;
                        } else {
                            str = null;
                        }
                        it2 = details2.getOverview();
                        if (it2 != null) {
                            str2 = null;
                        } else {
                            str2 = null;
                        }
                        it3 = details2.getBackdrop_path();
                        if (it3 == null) {
                            str3 = null;
                        } else {
                            if (!StringsKt.isBlank(it3)) {
                                it3 = null;
                            }
                            if (it3 != null) {
                                str3 = TMDB_IMG + it3;
                            } else {
                                str3 = null;
                            }
                        }
                        it4 = details2.getPoster_path();
                        if (it4 == null) {
                            str4 = null;
                        } else {
                            if (!StringsKt.isBlank(it4)) {
                                it4 = null;
                            }
                            if (it4 != null) {
                                str4 = TMDB_IMG + it4;
                            } else {
                                str4 = null;
                            }
                        }
                        external_ids = details2.getExternal_ids();
                        if (external_ids != null) {
                            str5 = null;
                        } else {
                            str5 = null;
                        }
                        release_date = details2.getRelease_date();
                        if (release_date == null) {
                            release_date = details2.getFirst_air_date();
                        }
                        if (release_date != null) {
                            strTake = StringsKt.take(release_date, 4);
                        } else {
                            strTake = null;
                        }
                        Score.Companion companion6 = Score.Companion;
                        vote_average = details2.getVote_average();
                        if (vote_average != null) {
                            strValueOf = String.valueOf(vote_average.doubleValue());
                        } else {
                            strValueOf = null;
                        }
                        Score scoreFrom11 = companion6.from10(strValueOf);
                        genres = details2.getGenres();
                        if (genres != null) {
                            Iterable $this$mapNotNull$iv2 = genres;
                            destination$iv$iv = new ArrayList();
                            while (r10.hasNext()) {
                                name = ((TmdbGenre) element$iv$iv$iv).getName();
                                if (name != null) {
                                    destination$iv$iv.add(name);
                                }
                            }
                            listEmptyList = (List) destination$iv$iv;
                        } else {
                            listEmptyList = CollectionsKt.emptyList();
                        }
                        tmdbMeta = new TmdbMeta(tmdbId2, str, str2, str3, str4, str5, strTake, scoreFrom11, metaActors, listEmptyList);
                    }
                    obj = Result.constructor-impl(tmdbMeta);
                    if (Result.isFailure-impl(obj)) {
                        return null;
                    }
                    return obj;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Throwable th8) {
            th = th8;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        C00031 c00031;
        Object safe;
        HomePageList homePageList;
        String strJoinToString$default;
        List listSplit$default;
        MovieSearchResponse movieSearchResponseNewMovieSearchResponse$default;
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
        Object $result = c00031.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00031.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (page > 1) {
                    return MainAPIKt.newHomePageResponse(CollectionsKt.emptyList(), Boxing.boxBoolean(false));
                }
                Requests app = MainActivityKt.getApp();
                String data = request.getData();
                c00031.L$0 = SpillingKt.nullOutSpilledVariable(request);
                c00031.I$0 = page;
                c00031.label = 1;
                $result = Requests.get$default(app, data, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00031, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                int i = c00031.I$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NiceResponse this_$iv = (NiceResponse) $result;
        try {
            ResponseParser parser = this_$iv.getParser();
            Intrinsics.checkNotNull(parser);
            safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(CatalogResponse.class));
        } catch (Exception e$iv) {
            e$iv.printStackTrace();
            safe = null;
        }
        CatalogResponse catalog = (CatalogResponse) safe;
        if (catalog == null) {
            return MainAPIKt.newHomePageResponse(CollectionsKt.emptyList(), Boxing.boxBoolean(false));
        }
        Iterable $this$mapNotNull$iv = catalog.getResult().getFull();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            CatalogCategory category = (CatalogCategory) element$iv$iv$iv;
            Iterable $this$mapNotNull$iv2 = category.getMovies();
            Collection destination$iv$iv2 = new ArrayList();
            for (Object element$iv$iv$iv2 : $this$mapNotNull$iv2) {
                CatalogResponse catalog2 = catalog;
                final CatalogMovie movie = (CatalogMovie) element$iv$iv$iv2;
                String title_en = movie.getTitle_en();
                if (title_en == null && (title_en = movie.getTitle_ru()) == null) {
                    movieSearchResponseNewMovieSearchResponse$default = null;
                } else {
                    String title = title_en;
                    TvType type = Intrinsics.areEqual(movie.getType(), "serial") ? TvType.TvSeries : TvType.Movie;
                    String apiUrl = getMainUrl() + "/api/v1/movies/" + movie.getKinopoisk_id();
                    movieSearchResponseNewMovieSearchResponse$default = MainAPIKt.newMovieSearchResponse$default(this, title, apiUrl, type, false, new Function1() { // from class: com.phisher98.AllMovieLandProvider$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            return AllMovieLandProvider.getMainPage$lambda$0$0$0(movie, (MovieSearchResponse) obj);
                        }
                    }, 8, (Object) null);
                }
                if (movieSearchResponseNewMovieSearchResponse$default != null) {
                    destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
                }
                catalog = catalog2;
            }
            CatalogResponse catalog3 = catalog;
            List items = (List) destination$iv$iv2;
            if (items.isEmpty()) {
                homePageList = null;
            } else {
                String name = category.getName();
                if (name == null || (listSplit$default = StringsKt.split$default(name, new String[]{" "}, false, 0, 6, (Object) null)) == null || (strJoinToString$default = CollectionsKt.joinToString$default(listSplit$default, " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.phisher98.AllMovieLandProvider$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        return AllMovieLandProvider.getMainPage$lambda$0$1((String) obj);
                    }
                }, 30, (Object) null)) == null) {
                    strJoinToString$default = "Unknown";
                }
                homePageList = new HomePageList(strJoinToString$default, items, false, 4, (DefaultConstructorMarker) null);
            }
            if (homePageList != null) {
                destination$iv$iv.add(homePageList);
            }
            catalog = catalog3;
        }
        List lists = (List) destination$iv$iv;
        return MainAPIKt.newHomePageResponse(lists, Boxing.boxBoolean(false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMainPage$lambda$0$0$0(CatalogMovie $movie, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($movie.getPoster());
        PlayerResponse playerResponse = (PlayerResponse) CollectionsKt.firstOrNull($movie.getPlayer());
        $this$newMovieSearchResponse.setQuality(MainAPIKt.getQualityFromString(playerResponse != null ? playerResponse.getQuality() : null));
        Ratings ratings = $movie.getRatings();
        RatingInfo imdb = ratings != null ? ratings.getImdb() : null;
        if (imdb != null) {
            Integer votes = imdb.getVotes();
            if ((votes != null ? votes.intValue() : 0) > 0) {
                Double rating = imdb.getRating();
                if ((rating != null ? rating.doubleValue() : 0.0d) > 0.0d) {
                    $this$newMovieSearchResponse.setScore(Score.Companion.from10(String.valueOf(imdb.getRating())));
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence getMainPage$lambda$0$1(String it) {
        String string;
        if (it.length() > 0) {
            StringBuilder sb = new StringBuilder();
            char c = it.charAt(0);
            String strValueOf = String.valueOf(c);
            Intrinsics.checkNotNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
            String upperCase = strValueOf.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            StringBuilder sbAppend = sb.append((Object) upperCase);
            String strSubstring = it.substring(1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            string = sbAppend.append(strSubstring).toString();
        } else {
            string = it;
        }
        return string;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        C00101 c00101;
        Object safe;
        List results;
        MovieSearchResponse movieSearchResponseNewMovieSearchResponse$default;
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
                Requests app = MainActivityKt.getApp();
                String str = getMainUrl() + "/api/v1/new-search/movies?title=" + StringsKt.trim(query).toString() + "&page=1&limit=20";
                c00102.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00102.label = 1;
                $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00102, 4094, (Object) null);
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
            safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(SearchApiResponse.class));
        } catch (Exception e$iv) {
            e$iv.printStackTrace();
            safe = null;
        }
        SearchApiResponse searchApiResponse = (SearchApiResponse) safe;
        if (searchApiResponse == null || (results = searchApiResponse.getResults()) == null) {
            return CollectionsKt.emptyList();
        }
        List $this$mapNotNull$iv = results;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            final CatalogMovie movie = (CatalogMovie) element$iv$iv$iv;
            String title_en = movie.getTitle_en();
            if (title_en == null && (title_en = movie.getTitle_ru()) == null) {
                movieSearchResponseNewMovieSearchResponse$default = null;
            } else {
                String title = title_en;
                TvType type = Intrinsics.areEqual(movie.getType(), "serial") ? TvType.TvSeries : TvType.Movie;
                String apiUrl = getMainUrl() + "/api/v1/movies/" + movie.getKinopoisk_id();
                movieSearchResponseNewMovieSearchResponse$default = MainAPIKt.newMovieSearchResponse$default(this, title, apiUrl, type, false, new Function1() { // from class: com.phisher98.AllMovieLandProvider$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        return AllMovieLandProvider.search$lambda$0$0(movie, (MovieSearchResponse) obj);
                    }
                }, 8, (Object) null);
            }
            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                destination$iv$iv.add(movieSearchResponseNewMovieSearchResponse$default);
            }
            results = results;
        }
        return (List) destination$iv$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit search$lambda$0$0(CatalogMovie $movie, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($movie.getPoster());
        PlayerResponse playerResponse = (PlayerResponse) CollectionsKt.firstOrNull($movie.getPlayer());
        $this$newMovieSearchResponse.setQuality(MainAPIKt.getQualityFromString(playerResponse != null ? playerResponse.getQuality() : null));
        Ratings ratings = $movie.getRatings();
        RatingInfo imdb = ratings != null ? ratings.getImdb() : null;
        if (imdb != null) {
            Integer votes = imdb.getVotes();
            if ((votes != null ? votes.intValue() : 0) > 0) {
                Double rating = imdb.getRating();
                if ((rating != null ? rating.doubleValue() : 0.0d) > 0.0d) {
                    $this$newMovieSearchResponse.setScore(Score.Companion.from10(String.valueOf(imdb.getRating())));
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:107:0x0528  */
    /* JADX WARN: Code duplicated, block: B:157:0x05d7  */
    /* JADX WARN: Code duplicated, block: B:167:0x05f3  */
    /* JADX WARN: Code duplicated, block: B:271:0x08b8  */
    /* JADX WARN: Code duplicated, block: B:273:0x08d0  */
    /* JADX WARN: Code duplicated, block: B:274:0x08d5  */
    /* JADX WARN: Code duplicated, block: B:276:0x08d8 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:344:0x0d6a  */
    /* JADX WARN: Code duplicated, block: B:348:0x0da1  */
    /* JADX WARN: Code duplicated, block: B:350:0x0db5  */
    /* JADX WARN: Code duplicated, block: B:353:0x0dc3  */
    /* JADX WARN: Code duplicated, block: B:356:0x0dda A[LOOP:1: B:351:0x0dbd->B:356:0x0dda, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:359:0x0de5  */
    /* JADX WARN: Code duplicated, block: B:525:0x0ddd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:526:0x0de0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:295:0x09c8 -> B:487:0x0a13). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:339:0x0d11 -> B:340:0x0d3d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at java.base/java.util.HashMap.hash(HashMap.java:338)
        	at java.base/java.util.HashMap.put(HashMap.java:610)
        	at java.base/java.util.HashSet.add(HashSet.java:221)
        	at jadx.core.utils.BlockUtils.addPredecessors(BlockUtils.java:703)
        	at jadx.core.utils.BlockUtils.addPredecessors(BlockUtils.java:706)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object load(@org.jetbrains.annotations.NotNull java.lang.String r59, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r60) {
        /*
            Method dump skipped, instruction units count: 4684
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.AllMovieLandProvider.load(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:11:0x0018  */
    /* JADX WARN: Code duplicated, block: B:13:0x001e  */
    /* JADX WARN: Code duplicated, block: B:26:0x0071  */
    public static final Unit load$lambda$9$1$1(TmdbEpisode $tmdbEp, EpisodeFolder $ep, Integer $epNum, Integer $seasonNum, String $poster, Episode $this$newEpisode) {
        String it;
        String it2;
        String it3;
        Double vote_average;
        String it4;
        if ($tmdbEp == null || (it = $tmdbEp.getName()) == null) {
            it = $ep.getTitle();
            if (it == null) {
                it = $ep.getEpisode() + " episode";
            }
        } else {
            if (StringsKt.isBlank(it)) {
                it = null;
            }
            if (it == null) {
                it = $ep.getTitle();
                if (it == null) {
                    it = $ep.getEpisode() + " episode";
                }
            }
        }
        $this$newEpisode.setName(it);
        $this$newEpisode.setEpisode($epNum);
        $this$newEpisode.setSeason($seasonNum);
        if ($tmdbEp == null || (it4 = $tmdbEp.getStill_path()) == null) {
            it2 = $poster;
        } else {
            if (StringsKt.isBlank(it4)) {
                it4 = null;
            }
            if (it4 == null || (it2 = TMDB_IMG + it4) == null) {
                it2 = $poster;
            }
        }
        $this$newEpisode.setPosterUrl(it2);
        if ($tmdbEp == null || (it3 = $tmdbEp.getOverview()) == null || StringsKt.isBlank(it3)) {
            it3 = null;
        }
        $this$newEpisode.setDescription(it3);
        $this$newEpisode.setScore(Score.Companion.from10(($tmdbEp == null || (vote_average = $tmdbEp.getVote_average()) == null) ? null : String.valueOf(vote_average.doubleValue())));
        MainAPIKt.addDate$default($this$newEpisode, $tmdbEp != null ? $tmdbEp.getAir_date() : null, (String) null, 2, (Object) null);
        return Unit.INSTANCE;
    }

    static final Unit load$lambda$11(String $poster, Episode $this$newEpisode) {
        $this$newEpisode.setName("Episode 1");
        $this$newEpisode.setEpisode(1);
        $this$newEpisode.setSeason(1);
        $this$newEpisode.setPosterUrl($poster);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.phisher98.AllMovieLandProvider$load$4 */
    /* JADX INFO: compiled from: AllMovieLandProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.AllMovieLandProvider$load$4", f = "AllMovieLandProvider.kt", i = {0}, l = {288}, m = "invokeSuspend", n = {"$this$newTvSeriesLoadResponse"}, nl = {289}, s = {"L$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nAllMovieLandProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AllMovieLandProvider.kt\ncom/phisher98/AllMovieLandProvider$load$4\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,578:1\n1#2:579\n*E\n"})
    static final class C00054 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ Integer $duration;
        final /* synthetic */ List<ActorData> $finalActors;
        final /* synthetic */ String $finalBackdrop;
        final /* synthetic */ String $finalPlot;
        final /* synthetic */ String $finalPoster;
        final /* synthetic */ Score $finalScore;
        final /* synthetic */ List<String> $finalTags;
        final /* synthetic */ TmdbMeta $tmdb;
        final /* synthetic */ String $trailer;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00054(String str, String str2, Integer num, String str3, List<String> list, Score score, Integer num2, List<ActorData> list2, String str4, TmdbMeta tmdbMeta, Continuation<? super C00054> continuation) {
            super(2, continuation);
            this.$finalPoster = str;
            this.$finalBackdrop = str2;
            this.$year = num;
            this.$finalPlot = str3;
            this.$finalTags = list;
            this.$finalScore = score;
            this.$duration = num2;
            this.$finalActors = list2;
            this.$trailer = str4;
            this.$tmdb = tmdbMeta;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00054 = new C00054(this.$finalPoster, this.$finalBackdrop, this.$year, this.$finalPlot, this.$finalTags, this.$finalScore, this.$duration, this.$finalActors, this.$trailer, this.$tmdb, continuation);
            c00054.L$0 = obj;
            return c00054;
        }

        public final Object invoke(TvSeriesLoadResponse tvSeriesLoadResponse, Continuation<? super Unit> continuation) {
            return create(tvSeriesLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            String it;
            String it2;
            LoadResponse loadResponse = (TvSeriesLoadResponse) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    loadResponse.setPosterUrl(this.$finalPoster);
                    loadResponse.setBackgroundPosterUrl(this.$finalBackdrop);
                    loadResponse.setYear(this.$year);
                    loadResponse.setPlot(this.$finalPlot);
                    loadResponse.setTags(CollectionsKt.distinct(this.$finalTags));
                    loadResponse.setScore(this.$finalScore);
                    loadResponse.setDuration(this.$duration);
                    loadResponse.setActors(this.$finalActors);
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
            TmdbMeta tmdbMeta = this.$tmdb;
            if (tmdbMeta != null && (it2 = tmdbMeta.getTmdbId()) != null) {
                LoadResponse.Companion.addTMDbId(loadResponse, it2);
            }
            TmdbMeta tmdbMeta2 = this.$tmdb;
            if (tmdbMeta2 != null && (it = tmdbMeta2.getLogo()) != null) {
                loadResponse.setLogoUrl(it);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.phisher98.AllMovieLandProvider$load$5 */
    /* JADX INFO: compiled from: AllMovieLandProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.AllMovieLandProvider$load$5", f = "AllMovieLandProvider.kt", i = {0}, l = {303}, m = "invokeSuspend", n = {"$this$newMovieLoadResponse"}, nl = {304}, s = {"L$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nAllMovieLandProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AllMovieLandProvider.kt\ncom/phisher98/AllMovieLandProvider$load$5\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,578:1\n1#2:579\n*E\n"})
    static final class C00065 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ Integer $duration;
        final /* synthetic */ List<ActorData> $finalActors;
        final /* synthetic */ String $finalBackdrop;
        final /* synthetic */ String $finalPlot;
        final /* synthetic */ String $finalPoster;
        final /* synthetic */ Score $finalScore;
        final /* synthetic */ List<String> $finalTags;
        final /* synthetic */ TmdbMeta $tmdb;
        final /* synthetic */ String $trailer;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00065(String str, String str2, Integer num, String str3, List<String> list, Score score, Integer num2, List<ActorData> list2, String str4, TmdbMeta tmdbMeta, Continuation<? super C00065> continuation) {
            super(2, continuation);
            this.$finalPoster = str;
            this.$finalBackdrop = str2;
            this.$year = num;
            this.$finalPlot = str3;
            this.$finalTags = list;
            this.$finalScore = score;
            this.$duration = num2;
            this.$finalActors = list2;
            this.$trailer = str4;
            this.$tmdb = tmdbMeta;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00065 = new C00065(this.$finalPoster, this.$finalBackdrop, this.$year, this.$finalPlot, this.$finalTags, this.$finalScore, this.$duration, this.$finalActors, this.$trailer, this.$tmdb, continuation);
            c00065.L$0 = obj;
            return c00065;
        }

        public final Object invoke(MovieLoadResponse movieLoadResponse, Continuation<? super Unit> continuation) {
            return create(movieLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            String it;
            String it2;
            LoadResponse loadResponse = (MovieLoadResponse) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    loadResponse.setPosterUrl(this.$finalPoster);
                    loadResponse.setBackgroundPosterUrl(this.$finalBackdrop);
                    loadResponse.setYear(this.$year);
                    loadResponse.setPlot(this.$finalPlot);
                    loadResponse.setTags(CollectionsKt.distinct(this.$finalTags));
                    loadResponse.setScore(this.$finalScore);
                    loadResponse.setDuration(this.$duration);
                    loadResponse.setActors(this.$finalActors);
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
            TmdbMeta tmdbMeta = this.$tmdb;
            if (tmdbMeta != null && (it2 = tmdbMeta.getTmdbId()) != null) {
                LoadResponse.Companion.addTMDbId(loadResponse, it2);
            }
            TmdbMeta tmdbMeta2 = this.$tmdb;
            if (tmdbMeta2 != null && (it = tmdbMeta2.getLogo()) != null) {
                loadResponse.setLogoUrl(it);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:109:0x033e  */
    /* JADX WARN: Code duplicated, block: B:111:0x038c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:112:0x038d  */
    /* JADX WARN: Code duplicated, block: B:128:0x02e4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:86:0x02dd  */
    /* JADX WARN: Code duplicated, block: B:96:0x02f9 A[Catch: Exception -> 0x030f, TRY_LEAVE, TryCatch #2 {Exception -> 0x030f, blocks: (B:77:0x02a8, B:84:0x02d7, B:87:0x02de, B:96:0x02f9, B:95:0x02f3, B:83:0x02cc, B:76:0x029e, B:80:0x02af, B:73:0x027b, B:90:0x02e4), top: B:118:0x027b, inners: #9, #10, #12 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:112:0x038d -> B:113:0x039a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x023c -> B:66:0x0250). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:712)
        	at jadx.core.utils.BlockUtils.isPathExists(BlockUtils.java:845)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.isCandidateForOutBlock(IfRegionMaker.java:303)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.findOutBlock(IfRegionMaker.java:267)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.restructureIf(IfRegionMaker.java:191)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:82)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object loadLinks(@org.jetbrains.annotations.NotNull java.lang.String r24, boolean r25, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r26, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r27, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r28) {
        /*
            Method dump skipped, instruction units count: 952
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.AllMovieLandProvider.loadLinks(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: compiled from: AllMovieLandProvider.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tÊ\u0001\u0002\b\u0017¨\u0006\u0016"}, d2 = {"Lcom/phisher98/AllMovieLandProvider$DlPayload;", "", "playerDomain", "", "tokenKey", "raw", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPlayerDomain", "()Ljava/lang/String;", "getTokenKey", "getRaw", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "AllMovieLandProvider", "Lkotlinx/serialization/Serializable;"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class DlPayload {

        @NotNull
        private final String playerDomain;

        @NotNull
        private final String raw;

        @NotNull
        private final String tokenKey;

        public static /* synthetic */ DlPayload copy$default(DlPayload dlPayload, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = dlPayload.playerDomain;
            }
            if ((i & 2) != 0) {
                str2 = dlPayload.tokenKey;
            }
            if ((i & 4) != 0) {
                str3 = dlPayload.raw;
            }
            return dlPayload.copy(str, str2, str3);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getPlayerDomain() {
            return this.playerDomain;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTokenKey() {
            return this.tokenKey;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getRaw() {
            return this.raw;
        }

        @NotNull
        public final DlPayload copy(@NotNull String playerDomain, @NotNull String tokenKey, @NotNull String raw) {
            return new DlPayload(playerDomain, tokenKey, raw);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DlPayload)) {
                return false;
            }
            DlPayload dlPayload = (DlPayload) other;
            return Intrinsics.areEqual(this.playerDomain, dlPayload.playerDomain) && Intrinsics.areEqual(this.tokenKey, dlPayload.tokenKey) && Intrinsics.areEqual(this.raw, dlPayload.raw);
        }

        public int hashCode() {
            return (((this.playerDomain.hashCode() * 31) + this.tokenKey.hashCode()) * 31) + this.raw.hashCode();
        }

        @NotNull
        public String toString() {
            return "DlPayload(playerDomain=" + this.playerDomain + ", tokenKey=" + this.tokenKey + ", raw=" + this.raw + ')';
        }

        public DlPayload(@NotNull String playerDomain, @NotNull String tokenKey, @NotNull String raw) {
            this.playerDomain = playerDomain;
            this.tokenKey = tokenKey;
            this.raw = raw;
        }

        @NotNull
        public final String getPlayerDomain() {
            return this.playerDomain;
        }

        @NotNull
        public final String getTokenKey() {
            return this.tokenKey;
        }

        @NotNull
        public final String getRaw() {
            return this.raw;
        }
    }

    /* JADX INFO: compiled from: AllMovieLandProvider.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tÊ\u0001\u0002\b\u0017¨\u0006\u0016"}, d2 = {"Lcom/phisher98/AllMovieLandProvider$PlayerMeta;", "", "file", "", "key", "href", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFile", "()Ljava/lang/String;", "getKey", "getHref", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "AllMovieLandProvider", "Lkotlinx/serialization/Serializable;"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class PlayerMeta {

        @NotNull
        private final String file;

        @NotNull
        private final String href;

        @Nullable
        private final String key;

        public static /* synthetic */ PlayerMeta copy$default(PlayerMeta playerMeta, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = playerMeta.file;
            }
            if ((i & 2) != 0) {
                str2 = playerMeta.key;
            }
            if ((i & 4) != 0) {
                str3 = playerMeta.href;
            }
            return playerMeta.copy(str, str2, str3);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getFile() {
            return this.file;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getKey() {
            return this.key;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getHref() {
            return this.href;
        }

        @NotNull
        public final PlayerMeta copy(@NotNull String file, @Nullable String key, @NotNull String href) {
            return new PlayerMeta(file, key, href);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PlayerMeta)) {
                return false;
            }
            PlayerMeta playerMeta = (PlayerMeta) other;
            return Intrinsics.areEqual(this.file, playerMeta.file) && Intrinsics.areEqual(this.key, playerMeta.key) && Intrinsics.areEqual(this.href, playerMeta.href);
        }

        public int hashCode() {
            return (((this.file.hashCode() * 31) + (this.key == null ? 0 : this.key.hashCode())) * 31) + this.href.hashCode();
        }

        @NotNull
        public String toString() {
            return "PlayerMeta(file=" + this.file + ", key=" + this.key + ", href=" + this.href + ')';
        }

        public PlayerMeta(@NotNull String file, @Nullable String key, @NotNull String href) {
            this.file = file;
            this.key = key;
            this.href = href;
        }

        public /* synthetic */ PlayerMeta(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? "" : str3);
        }

        @NotNull
        public final String getFile() {
            return this.file;
        }

        @Nullable
        public final String getKey() {
            return this.key;
        }

        @NotNull
        public final String getHref() {
            return this.href;
        }
    }

    /* JADX INFO: compiled from: AllMovieLandProvider.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eÊ\u0001\u0002\b\u001a¨\u0006\u0019"}, d2 = {"Lcom/phisher98/AllMovieLandProvider$EpisodeData;", "", "playerDomain", "", "tokenKey", "files", "", "Lcom/phisher98/AllMovieLandProvider$FileEntry;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getPlayerDomain", "()Ljava/lang/String;", "getTokenKey", "getFiles", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "AllMovieLandProvider", "Lkotlinx/serialization/Serializable;"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class EpisodeData {

        @NotNull
        private final List<FileEntry> files;

        @NotNull
        private final String playerDomain;

        @NotNull
        private final String tokenKey;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ EpisodeData copy$default(EpisodeData episodeData, String str, String str2, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = episodeData.playerDomain;
            }
            if ((i & 2) != 0) {
                str2 = episodeData.tokenKey;
            }
            if ((i & 4) != 0) {
                list = episodeData.files;
            }
            return episodeData.copy(str, str2, list);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getPlayerDomain() {
            return this.playerDomain;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTokenKey() {
            return this.tokenKey;
        }

        @NotNull
        public final List<FileEntry> component3() {
            return this.files;
        }

        @NotNull
        public final EpisodeData copy(@NotNull String playerDomain, @NotNull String tokenKey, @NotNull List<FileEntry> files) {
            return new EpisodeData(playerDomain, tokenKey, files);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EpisodeData)) {
                return false;
            }
            EpisodeData episodeData = (EpisodeData) other;
            return Intrinsics.areEqual(this.playerDomain, episodeData.playerDomain) && Intrinsics.areEqual(this.tokenKey, episodeData.tokenKey) && Intrinsics.areEqual(this.files, episodeData.files);
        }

        public int hashCode() {
            return (((this.playerDomain.hashCode() * 31) + this.tokenKey.hashCode()) * 31) + this.files.hashCode();
        }

        @NotNull
        public String toString() {
            return "EpisodeData(playerDomain=" + this.playerDomain + ", tokenKey=" + this.tokenKey + ", files=" + this.files + ')';
        }

        public EpisodeData(@NotNull String playerDomain, @NotNull String tokenKey, @NotNull List<FileEntry> list) {
            this.playerDomain = playerDomain;
            this.tokenKey = tokenKey;
            this.files = list;
        }

        @NotNull
        public final String getPlayerDomain() {
            return this.playerDomain;
        }

        @NotNull
        public final String getTokenKey() {
            return this.tokenKey;
        }

        @NotNull
        public final List<FileEntry> getFiles() {
            return this.files;
        }
    }

    /* JADX INFO: compiled from: AllMovieLandProvider.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bÊ\u0001\u0002\b\u001d¨\u0006\u001c"}, d2 = {"Lcom/phisher98/AllMovieLandProvider$FileEntry;", "", "file", "", "title", "translator", "id", "end_tag", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFile", "()Ljava/lang/String;", "getTitle", "getTranslator", "getId", "getEnd_tag", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "AllMovieLandProvider", "Lkotlinx/serialization/Serializable;"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class FileEntry {

        @Nullable
        private final String end_tag;

        @Nullable
        private final String file;

        @Nullable
        private final String id;

        @Nullable
        private final String title;

        @Nullable
        private final String translator;

        public FileEntry() {
            this(null, null, null, null, null, 31, null);
        }

        public static /* synthetic */ FileEntry copy$default(FileEntry fileEntry, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
            if ((i & 1) != 0) {
                str = fileEntry.file;
            }
            if ((i & 2) != 0) {
                str2 = fileEntry.title;
            }
            if ((i & 4) != 0) {
                str3 = fileEntry.translator;
            }
            if ((i & 8) != 0) {
                str4 = fileEntry.id;
            }
            if ((i & 16) != 0) {
                str5 = fileEntry.end_tag;
            }
            String str6 = str5;
            String str7 = str3;
            return fileEntry.copy(str, str2, str7, str4, str6);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getFile() {
            return this.file;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getTranslator() {
            return this.translator;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getEnd_tag() {
            return this.end_tag;
        }

        @NotNull
        public final FileEntry copy(@Nullable String file, @Nullable String title, @Nullable String translator, @Nullable String id, @Nullable String end_tag) {
            return new FileEntry(file, title, translator, id, end_tag);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FileEntry)) {
                return false;
            }
            FileEntry fileEntry = (FileEntry) other;
            return Intrinsics.areEqual(this.file, fileEntry.file) && Intrinsics.areEqual(this.title, fileEntry.title) && Intrinsics.areEqual(this.translator, fileEntry.translator) && Intrinsics.areEqual(this.id, fileEntry.id) && Intrinsics.areEqual(this.end_tag, fileEntry.end_tag);
        }

        public int hashCode() {
            return ((((((((this.file == null ? 0 : this.file.hashCode()) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.translator == null ? 0 : this.translator.hashCode())) * 31) + (this.id == null ? 0 : this.id.hashCode())) * 31) + (this.end_tag != null ? this.end_tag.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "FileEntry(file=" + this.file + ", title=" + this.title + ", translator=" + this.translator + ", id=" + this.id + ", end_tag=" + this.end_tag + ')';
        }

        public FileEntry(@Nullable String file, @Nullable String title, @Nullable String translator, @Nullable String id, @Nullable String end_tag) {
            this.file = file;
            this.title = title;
            this.translator = translator;
            this.id = id;
            this.end_tag = end_tag;
        }

        public /* synthetic */ FileEntry(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5);
        }

        @Nullable
        public final String getFile() {
            return this.file;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final String getTranslator() {
            return this.translator;
        }

        @Nullable
        public final String getId() {
            return this.id;
        }

        @Nullable
        public final String getEnd_tag() {
            return this.end_tag;
        }
    }

    /* JADX INFO: compiled from: AllMovieLandProvider.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J/\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eÊ\u0001\u0002\b\u001a¨\u0006\u0019"}, d2 = {"Lcom/phisher98/AllMovieLandProvider$SeasonFolder;", "", "id", "", "title", "folder", "", "Lcom/phisher98/AllMovieLandProvider$EpisodeFolder;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getId", "()Ljava/lang/String;", "getTitle", "getFolder", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "AllMovieLandProvider", "Lkotlinx/serialization/Serializable;"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class SeasonFolder {

        @NotNull
        private final List<EpisodeFolder> folder;

        @NotNull
        private final String id;

        @Nullable
        private final String title;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SeasonFolder copy$default(SeasonFolder seasonFolder, String str, String str2, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = seasonFolder.id;
            }
            if ((i & 2) != 0) {
                str2 = seasonFolder.title;
            }
            if ((i & 4) != 0) {
                list = seasonFolder.folder;
            }
            return seasonFolder.copy(str, str2, list);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        public final List<EpisodeFolder> component3() {
            return this.folder;
        }

        @NotNull
        public final SeasonFolder copy(@NotNull String id, @Nullable String title, @NotNull List<EpisodeFolder> folder) {
            return new SeasonFolder(id, title, folder);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SeasonFolder)) {
                return false;
            }
            SeasonFolder seasonFolder = (SeasonFolder) other;
            return Intrinsics.areEqual(this.id, seasonFolder.id) && Intrinsics.areEqual(this.title, seasonFolder.title) && Intrinsics.areEqual(this.folder, seasonFolder.folder);
        }

        public int hashCode() {
            return (((this.id.hashCode() * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + this.folder.hashCode();
        }

        @NotNull
        public String toString() {
            return "SeasonFolder(id=" + this.id + ", title=" + this.title + ", folder=" + this.folder + ')';
        }

        public SeasonFolder(@NotNull String id, @Nullable String title, @NotNull List<EpisodeFolder> list) {
            this.id = id;
            this.title = title;
            this.folder = list;
        }

        public /* synthetic */ SeasonFolder(String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? CollectionsKt.emptyList() : list);
        }

        @NotNull
        public final String getId() {
            return this.id;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        public final List<EpisodeFolder> getFolder() {
            return this.folder;
        }
    }

    /* JADX INFO: compiled from: AllMovieLandProvider.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010Ê\u0001\u0002\b\u001d¨\u0006\u001c"}, d2 = {"Lcom/phisher98/AllMovieLandProvider$EpisodeFolder;", "", "episode", "", "title", "id", "folder", "", "Lcom/phisher98/AllMovieLandProvider$FileEntry;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getEpisode", "()Ljava/lang/String;", "getTitle", "getId", "getFolder", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "AllMovieLandProvider", "Lkotlinx/serialization/Serializable;"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class EpisodeFolder {

        @NotNull
        private final String episode;

        @NotNull
        private final List<FileEntry> folder;

        @Nullable
        private final String id;

        @Nullable
        private final String title;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ EpisodeFolder copy$default(EpisodeFolder episodeFolder, String str, String str2, String str3, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = episodeFolder.episode;
            }
            if ((i & 2) != 0) {
                str2 = episodeFolder.title;
            }
            if ((i & 4) != 0) {
                str3 = episodeFolder.id;
            }
            if ((i & 8) != 0) {
                list = episodeFolder.folder;
            }
            return episodeFolder.copy(str, str2, str3, list);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getEpisode() {
            return this.episode;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @NotNull
        public final List<FileEntry> component4() {
            return this.folder;
        }

        @NotNull
        public final EpisodeFolder copy(@NotNull String episode, @Nullable String title, @Nullable String id, @NotNull List<FileEntry> folder) {
            return new EpisodeFolder(episode, title, id, folder);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EpisodeFolder)) {
                return false;
            }
            EpisodeFolder episodeFolder = (EpisodeFolder) other;
            return Intrinsics.areEqual(this.episode, episodeFolder.episode) && Intrinsics.areEqual(this.title, episodeFolder.title) && Intrinsics.areEqual(this.id, episodeFolder.id) && Intrinsics.areEqual(this.folder, episodeFolder.folder);
        }

        public int hashCode() {
            return (((((this.episode.hashCode() * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.id != null ? this.id.hashCode() : 0)) * 31) + this.folder.hashCode();
        }

        @NotNull
        public String toString() {
            return "EpisodeFolder(episode=" + this.episode + ", title=" + this.title + ", id=" + this.id + ", folder=" + this.folder + ')';
        }

        public EpisodeFolder(@NotNull String episode, @Nullable String title, @Nullable String id, @NotNull List<FileEntry> list) {
            this.episode = episode;
            this.title = title;
            this.id = id;
            this.folder = list;
        }

        public /* synthetic */ EpisodeFolder(String str, String str2, String str3, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? CollectionsKt.emptyList() : list);
        }

        @NotNull
        public final String getEpisode() {
            return this.episode;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final String getId() {
            return this.id;
        }

        @NotNull
        public final List<FileEntry> getFolder() {
            return this.folder;
        }
    }

    /* JADX INFO: compiled from: AllMovieLandProvider.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\u0002\b\u0012¨\u0006\u0011"}, d2 = {"Lcom/phisher98/AllMovieLandProvider$CatalogResponse;", "", "result", "Lcom/phisher98/AllMovieLandProvider$CatalogResult;", "<init>", "(Lcom/phisher98/AllMovieLandProvider$CatalogResult;)V", "getResult", "()Lcom/phisher98/AllMovieLandProvider$CatalogResult;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "AllMovieLandProvider", "Lkotlinx/serialization/Serializable;"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class CatalogResponse {

        @NotNull
        private final CatalogResult result;

        public static /* synthetic */ CatalogResponse copy$default(CatalogResponse catalogResponse, CatalogResult catalogResult, int i, Object obj) {
            if ((i & 1) != 0) {
                catalogResult = catalogResponse.result;
            }
            return catalogResponse.copy(catalogResult);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final CatalogResult getResult() {
            return this.result;
        }

        @NotNull
        public final CatalogResponse copy(@NotNull CatalogResult result) {
            return new CatalogResponse(result);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof CatalogResponse) && Intrinsics.areEqual(this.result, ((CatalogResponse) other).result);
        }

        public int hashCode() {
            return this.result.hashCode();
        }

        @NotNull
        public String toString() {
            return "CatalogResponse(result=" + this.result + ')';
        }

        public CatalogResponse(@NotNull CatalogResult result) {
            this.result = result;
        }

        @NotNull
        public final CatalogResult getResult() {
            return this.result;
        }
    }

    /* JADX INFO: compiled from: AllMovieLandProvider.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bÊ\u0001\u0002\b\u0013¨\u0006\u0012"}, d2 = {"Lcom/phisher98/AllMovieLandProvider$CatalogResult;", "", "full", "", "Lcom/phisher98/AllMovieLandProvider$CatalogCategory;", "<init>", "(Ljava/util/List;)V", "getFull", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "AllMovieLandProvider", "Lkotlinx/serialization/Serializable;"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class CatalogResult {

        @NotNull
        private final List<CatalogCategory> full;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CatalogResult copy$default(CatalogResult catalogResult, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = catalogResult.full;
            }
            return catalogResult.copy(list);
        }

        @NotNull
        public final List<CatalogCategory> component1() {
            return this.full;
        }

        @NotNull
        public final CatalogResult copy(@NotNull List<CatalogCategory> full) {
            return new CatalogResult(full);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof CatalogResult) && Intrinsics.areEqual(this.full, ((CatalogResult) other).full);
        }

        public int hashCode() {
            return this.full.hashCode();
        }

        @NotNull
        public String toString() {
            return "CatalogResult(full=" + this.full + ')';
        }

        public CatalogResult(@NotNull List<CatalogCategory> list) {
            this.full = list;
        }

        @NotNull
        public final List<CatalogCategory> getFull() {
            return this.full;
        }
    }

    /* JADX INFO: compiled from: AllMovieLandProvider.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J9\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0014\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012Ê\u0001\u0002\b\u001e¨\u0006\u001d"}, d2 = {"Lcom/phisher98/AllMovieLandProvider$CatalogCategory;", "", "id", "", "name", "", "index", "movies", "", "Lcom/phisher98/AllMovieLandProvider$CatalogMovie;", "<init>", "(ILjava/lang/String;ILjava/util/List;)V", "getId", "()I", "getName", "()Ljava/lang/String;", "getIndex", "getMovies", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "AllMovieLandProvider", "Lkotlinx/serialization/Serializable;"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class CatalogCategory {
        private final int id;
        private final int index;

        @NotNull
        private final List<CatalogMovie> movies;

        @Nullable
        private final String name;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CatalogCategory copy$default(CatalogCategory catalogCategory, int i, String str, int i2, List list, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = catalogCategory.id;
            }
            if ((i3 & 2) != 0) {
                str = catalogCategory.name;
            }
            if ((i3 & 4) != 0) {
                i2 = catalogCategory.index;
            }
            if ((i3 & 8) != 0) {
                list = catalogCategory.movies;
            }
            return catalogCategory.copy(i, str, i2, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getIndex() {
            return this.index;
        }

        @NotNull
        public final List<CatalogMovie> component4() {
            return this.movies;
        }

        @NotNull
        public final CatalogCategory copy(int id, @Nullable String name, int index, @NotNull List<CatalogMovie> movies) {
            return new CatalogCategory(id, name, index, movies);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CatalogCategory)) {
                return false;
            }
            CatalogCategory catalogCategory = (CatalogCategory) other;
            return this.id == catalogCategory.id && Intrinsics.areEqual(this.name, catalogCategory.name) && this.index == catalogCategory.index && Intrinsics.areEqual(this.movies, catalogCategory.movies);
        }

        public int hashCode() {
            return (((((this.id * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + this.index) * 31) + this.movies.hashCode();
        }

        @NotNull
        public String toString() {
            return "CatalogCategory(id=" + this.id + ", name=" + this.name + ", index=" + this.index + ", movies=" + this.movies + ')';
        }

        public CatalogCategory(int id, @Nullable String name, int index, @NotNull List<CatalogMovie> list) {
            this.id = id;
            this.name = name;
            this.index = index;
            this.movies = list;
        }

        public /* synthetic */ CatalogCategory(int i, String str, int i2, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i3 & 2) != 0 ? null : str, i2, list);
        }

        public final int getId() {
            return this.id;
        }

        @Nullable
        public final String getName() {
            return this.name;
        }

        public final int getIndex() {
            return this.index;
        }

        @NotNull
        public final List<CatalogMovie> getMovies() {
            return this.movies;
        }
    }

    /* JADX INFO: compiled from: AllMovieLandProvider.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\rHÆ\u0003J]\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0014\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010&\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010'\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aÊ\u0001\u0002\b)¨\u0006("}, d2 = {"Lcom/phisher98/AllMovieLandProvider$CatalogMovie;", "", "kinopoisk_id", "", "type", "", "title_ru", "title_en", "poster", "player", "", "Lcom/phisher98/AllMovieLandProvider$PlayerResponse;", "ratings", "Lcom/phisher98/AllMovieLandProvider$Ratings;", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/phisher98/AllMovieLandProvider$Ratings;)V", "getKinopoisk_id", "()I", "getType", "()Ljava/lang/String;", "getTitle_ru", "getTitle_en", "getPoster", "getPlayer", "()Ljava/util/List;", "getRatings", "()Lcom/phisher98/AllMovieLandProvider$Ratings;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "AllMovieLandProvider", "Lkotlinx/serialization/Serializable;"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class CatalogMovie {
        private final int kinopoisk_id;

        @NotNull
        private final List<PlayerResponse> player;

        @Nullable
        private final String poster;

        @Nullable
        private final Ratings ratings;

        @Nullable
        private final String title_en;

        @Nullable
        private final String title_ru;

        @NotNull
        private final String type;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CatalogMovie copy$default(CatalogMovie catalogMovie, int i, String str, String str2, String str3, String str4, List list, Ratings ratings, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = catalogMovie.kinopoisk_id;
            }
            if ((i2 & 2) != 0) {
                str = catalogMovie.type;
            }
            if ((i2 & 4) != 0) {
                str2 = catalogMovie.title_ru;
            }
            if ((i2 & 8) != 0) {
                str3 = catalogMovie.title_en;
            }
            if ((i2 & 16) != 0) {
                str4 = catalogMovie.poster;
            }
            if ((i2 & 32) != 0) {
                list = catalogMovie.player;
            }
            if ((i2 & 64) != 0) {
                ratings = catalogMovie.ratings;
            }
            List list2 = list;
            Ratings ratings2 = ratings;
            String str5 = str4;
            String str6 = str2;
            return catalogMovie.copy(i, str, str6, str3, str5, list2, ratings2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getKinopoisk_id() {
            return this.kinopoisk_id;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getTitle_ru() {
            return this.title_ru;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getTitle_en() {
            return this.title_en;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getPoster() {
            return this.poster;
        }

        @NotNull
        public final List<PlayerResponse> component6() {
            return this.player;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Ratings getRatings() {
            return this.ratings;
        }

        @NotNull
        public final CatalogMovie copy(int kinopoisk_id, @NotNull String type, @Nullable String title_ru, @Nullable String title_en, @Nullable String poster, @NotNull List<PlayerResponse> player, @Nullable Ratings ratings) {
            return new CatalogMovie(kinopoisk_id, type, title_ru, title_en, poster, player, ratings);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CatalogMovie)) {
                return false;
            }
            CatalogMovie catalogMovie = (CatalogMovie) other;
            return this.kinopoisk_id == catalogMovie.kinopoisk_id && Intrinsics.areEqual(this.type, catalogMovie.type) && Intrinsics.areEqual(this.title_ru, catalogMovie.title_ru) && Intrinsics.areEqual(this.title_en, catalogMovie.title_en) && Intrinsics.areEqual(this.poster, catalogMovie.poster) && Intrinsics.areEqual(this.player, catalogMovie.player) && Intrinsics.areEqual(this.ratings, catalogMovie.ratings);
        }

        public int hashCode() {
            return (((((((((((this.kinopoisk_id * 31) + this.type.hashCode()) * 31) + (this.title_ru == null ? 0 : this.title_ru.hashCode())) * 31) + (this.title_en == null ? 0 : this.title_en.hashCode())) * 31) + (this.poster == null ? 0 : this.poster.hashCode())) * 31) + this.player.hashCode()) * 31) + (this.ratings != null ? this.ratings.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "CatalogMovie(kinopoisk_id=" + this.kinopoisk_id + ", type=" + this.type + ", title_ru=" + this.title_ru + ", title_en=" + this.title_en + ", poster=" + this.poster + ", player=" + this.player + ", ratings=" + this.ratings + ')';
        }

        public CatalogMovie(int kinopoisk_id, @NotNull String type, @Nullable String title_ru, @Nullable String title_en, @Nullable String poster, @NotNull List<PlayerResponse> list, @Nullable Ratings ratings) {
            this.kinopoisk_id = kinopoisk_id;
            this.type = type;
            this.title_ru = title_ru;
            this.title_en = title_en;
            this.poster = poster;
            this.player = list;
            this.ratings = ratings;
        }

        public /* synthetic */ CatalogMovie(int i, String str, String str2, String str3, String str4, List list, Ratings ratings, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : str3, (i2 & 16) != 0 ? null : str4, (i2 & 32) != 0 ? CollectionsKt.emptyList() : list, (i2 & 64) != 0 ? null : ratings);
        }

        public final int getKinopoisk_id() {
            return this.kinopoisk_id;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }

        @Nullable
        public final String getTitle_ru() {
            return this.title_ru;
        }

        @Nullable
        public final String getTitle_en() {
            return this.title_en;
        }

        @Nullable
        public final String getPoster() {
            return this.poster;
        }

        @NotNull
        public final List<PlayerResponse> getPlayer() {
            return this.player;
        }

        @Nullable
        public final Ratings getRatings() {
            return this.ratings;
        }
    }

    /* JADX INFO: compiled from: AllMovieLandProvider.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\u0002\b\u0012¨\u0006\u0011"}, d2 = {"Lcom/phisher98/AllMovieLandProvider$MovieDetailResponse;", "", "result", "Lcom/phisher98/AllMovieLandProvider$MovieDetail;", "<init>", "(Lcom/phisher98/AllMovieLandProvider$MovieDetail;)V", "getResult", "()Lcom/phisher98/AllMovieLandProvider$MovieDetail;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "AllMovieLandProvider", "Lkotlinx/serialization/Serializable;"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class MovieDetailResponse {

        @NotNull
        private final MovieDetail result;

        public static /* synthetic */ MovieDetailResponse copy$default(MovieDetailResponse movieDetailResponse, MovieDetail movieDetail, int i, Object obj) {
            if ((i & 1) != 0) {
                movieDetail = movieDetailResponse.result;
            }
            return movieDetailResponse.copy(movieDetail);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final MovieDetail getResult() {
            return this.result;
        }

        @NotNull
        public final MovieDetailResponse copy(@NotNull MovieDetail result) {
            return new MovieDetailResponse(result);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof MovieDetailResponse) && Intrinsics.areEqual(this.result, ((MovieDetailResponse) other).result);
        }

        public int hashCode() {
            return this.result.hashCode();
        }

        @NotNull
        public String toString() {
            return "MovieDetailResponse(result=" + this.result + ')';
        }

        public MovieDetailResponse(@NotNull MovieDetail result) {
            this.result = result;
        }

        @NotNull
        public final MovieDetail getResult() {
            return this.result;
        }
    }

    /* JADX INFO: compiled from: AllMovieLandProvider.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\b\u0087\b\u0018\u00002\u00020\u0001B½\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000f\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000f\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u000f\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u00106\u001a\u0004\u0018\u00010\rHÆ\u0003J\u0011\u00107\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fHÆ\u0003J\u0011\u00108\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000fHÆ\u0003J\u0011\u00109\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000fHÆ\u0003J\u000f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00160\u000fHÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0005HÆ\u0003JÈ\u0001\u0010<\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000f2\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000f2\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u000f2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010=J\u0014\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010A\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010B\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001dR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010 \u001a\u0004\b%\u0010\u001fR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0019\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0019\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b*\u0010)R\u0019\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b+\u0010)R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u000f¢\u0006\b\n\u0000\u001a\u0004\b,\u0010)R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001dÊ\u0001\u0002\bD¨\u0006C"}, d2 = {"Lcom/phisher98/AllMovieLandProvider$MovieDetail;", "", "kinopoisk_id", "", "type", "", "year", "title_ru", "title_en", "description", "poster", "duration", "ratings", "Lcom/phisher98/AllMovieLandProvider$Ratings;", "genres", "", "Lcom/phisher98/AllMovieLandProvider$Genre;", "actors", "Lcom/phisher98/AllMovieLandProvider$MovieActor;", "countries", "Lcom/phisher98/AllMovieLandProvider$Country;", "player", "Lcom/phisher98/AllMovieLandProvider$PlayerResponse;", "trailer", "<init>", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/phisher98/AllMovieLandProvider$Ratings;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getKinopoisk_id", "()I", "getType", "()Ljava/lang/String;", "getYear", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTitle_ru", "getTitle_en", "getDescription", "getPoster", "getDuration", "getRatings", "()Lcom/phisher98/AllMovieLandProvider$Ratings;", "getGenres", "()Ljava/util/List;", "getActors", "getCountries", "getPlayer", "getTrailer", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/phisher98/AllMovieLandProvider$Ratings;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)Lcom/phisher98/AllMovieLandProvider$MovieDetail;", "equals", "", "other", "hashCode", "toString", "AllMovieLandProvider", "Lkotlinx/serialization/Serializable;"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class MovieDetail {

        @Nullable
        private final List<MovieActor> actors;

        @Nullable
        private final List<Country> countries;

        @Nullable
        private final String description;

        @Nullable
        private final Integer duration;

        @Nullable
        private final List<Genre> genres;
        private final int kinopoisk_id;

        @NotNull
        private final List<PlayerResponse> player;

        @Nullable
        private final String poster;

        @Nullable
        private final Ratings ratings;

        @Nullable
        private final String title_en;

        @Nullable
        private final String title_ru;

        @Nullable
        private final String trailer;

        @NotNull
        private final String type;

        @Nullable
        private final Integer year;

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getKinopoisk_id() {
            return this.kinopoisk_id;
        }

        @Nullable
        public final List<Genre> component10() {
            return this.genres;
        }

        @Nullable
        public final List<MovieActor> component11() {
            return this.actors;
        }

        @Nullable
        public final List<Country> component12() {
            return this.countries;
        }

        @NotNull
        public final List<PlayerResponse> component13() {
            return this.player;
        }

        @Nullable
        /* JADX INFO: renamed from: component14, reason: from getter */
        public final String getTrailer() {
            return this.trailer;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getYear() {
            return this.year;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getTitle_ru() {
            return this.title_ru;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getTitle_en() {
            return this.title_en;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getPoster() {
            return this.poster;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Integer getDuration() {
            return this.duration;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final Ratings getRatings() {
            return this.ratings;
        }

        @NotNull
        public final MovieDetail copy(int kinopoisk_id, @NotNull String type, @Nullable Integer year, @Nullable String title_ru, @Nullable String title_en, @Nullable String description, @Nullable String poster, @Nullable Integer duration, @Nullable Ratings ratings, @Nullable List<Genre> genres, @Nullable List<MovieActor> actors, @Nullable List<Country> countries, @NotNull List<PlayerResponse> player, @Nullable String trailer) {
            return new MovieDetail(kinopoisk_id, type, year, title_ru, title_en, description, poster, duration, ratings, genres, actors, countries, player, trailer);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MovieDetail)) {
                return false;
            }
            MovieDetail movieDetail = (MovieDetail) other;
            return this.kinopoisk_id == movieDetail.kinopoisk_id && Intrinsics.areEqual(this.type, movieDetail.type) && Intrinsics.areEqual(this.year, movieDetail.year) && Intrinsics.areEqual(this.title_ru, movieDetail.title_ru) && Intrinsics.areEqual(this.title_en, movieDetail.title_en) && Intrinsics.areEqual(this.description, movieDetail.description) && Intrinsics.areEqual(this.poster, movieDetail.poster) && Intrinsics.areEqual(this.duration, movieDetail.duration) && Intrinsics.areEqual(this.ratings, movieDetail.ratings) && Intrinsics.areEqual(this.genres, movieDetail.genres) && Intrinsics.areEqual(this.actors, movieDetail.actors) && Intrinsics.areEqual(this.countries, movieDetail.countries) && Intrinsics.areEqual(this.player, movieDetail.player) && Intrinsics.areEqual(this.trailer, movieDetail.trailer);
        }

        public int hashCode() {
            return (((((((((((((((((((((((((this.kinopoisk_id * 31) + this.type.hashCode()) * 31) + (this.year == null ? 0 : this.year.hashCode())) * 31) + (this.title_ru == null ? 0 : this.title_ru.hashCode())) * 31) + (this.title_en == null ? 0 : this.title_en.hashCode())) * 31) + (this.description == null ? 0 : this.description.hashCode())) * 31) + (this.poster == null ? 0 : this.poster.hashCode())) * 31) + (this.duration == null ? 0 : this.duration.hashCode())) * 31) + (this.ratings == null ? 0 : this.ratings.hashCode())) * 31) + (this.genres == null ? 0 : this.genres.hashCode())) * 31) + (this.actors == null ? 0 : this.actors.hashCode())) * 31) + (this.countries == null ? 0 : this.countries.hashCode())) * 31) + this.player.hashCode()) * 31) + (this.trailer != null ? this.trailer.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("MovieDetail(kinopoisk_id=").append(this.kinopoisk_id).append(", type=").append(this.type).append(", year=").append(this.year).append(", title_ru=").append(this.title_ru).append(", title_en=").append(this.title_en).append(", description=").append(this.description).append(", poster=").append(this.poster).append(", duration=").append(this.duration).append(", ratings=").append(this.ratings).append(", genres=").append(this.genres).append(", actors=").append(this.actors).append(", countries=");
            sb.append(this.countries).append(", player=").append(this.player).append(", trailer=").append(this.trailer).append(')');
            return sb.toString();
        }

        public MovieDetail(int kinopoisk_id, @NotNull String type, @Nullable Integer year, @Nullable String title_ru, @Nullable String title_en, @Nullable String description, @Nullable String poster, @Nullable Integer duration, @Nullable Ratings ratings, @Nullable List<Genre> list, @Nullable List<MovieActor> list2, @Nullable List<Country> list3, @NotNull List<PlayerResponse> list4, @Nullable String trailer) {
            this.kinopoisk_id = kinopoisk_id;
            this.type = type;
            this.year = year;
            this.title_ru = title_ru;
            this.title_en = title_en;
            this.description = description;
            this.poster = poster;
            this.duration = duration;
            this.ratings = ratings;
            this.genres = list;
            this.actors = list2;
            this.countries = list3;
            this.player = list4;
            this.trailer = trailer;
        }

        public /* synthetic */ MovieDetail(int i, String str, Integer num, String str2, String str3, String str4, String str5, Integer num2, Ratings ratings, List list, List list2, List list3, List list4, String str6, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, str, (i2 & 4) != 0 ? null : num, (i2 & 8) != 0 ? null : str2, (i2 & 16) != 0 ? null : str3, (i2 & 32) != 0 ? null : str4, (i2 & 64) != 0 ? null : str5, (i2 & 128) != 0 ? null : num2, (i2 & 256) != 0 ? null : ratings, (i2 & 512) != 0 ? null : list, (i2 & 1024) != 0 ? null : list2, (i2 & 2048) != 0 ? null : list3, (i2 & 4096) != 0 ? CollectionsKt.emptyList() : list4, (i2 & 8192) != 0 ? null : str6);
        }

        public final int getKinopoisk_id() {
            return this.kinopoisk_id;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }

        @Nullable
        public final Integer getYear() {
            return this.year;
        }

        @Nullable
        public final String getTitle_ru() {
            return this.title_ru;
        }

        @Nullable
        public final String getTitle_en() {
            return this.title_en;
        }

        @Nullable
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        public final String getPoster() {
            return this.poster;
        }

        @Nullable
        public final Integer getDuration() {
            return this.duration;
        }

        @Nullable
        public final Ratings getRatings() {
            return this.ratings;
        }

        @Nullable
        public final List<Genre> getGenres() {
            return this.genres;
        }

        @Nullable
        public final List<MovieActor> getActors() {
            return this.actors;
        }

        @Nullable
        public final List<Country> getCountries() {
            return this.countries;
        }

        @NotNull
        public final List<PlayerResponse> getPlayer() {
            return this.player;
        }

        @Nullable
        public final String getTrailer() {
            return this.trailer;
        }
    }

    /* JADX INFO: compiled from: AllMovieLandProvider.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0005HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rÊ\u0001\u0002\b\u001a¨\u0006\u0019"}, d2 = {"Lcom/phisher98/AllMovieLandProvider$MovieActor;", "", "id", "", "name", "", "character", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "getCharacter", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/phisher98/AllMovieLandProvider$MovieActor;", "equals", "", "other", "hashCode", "toString", "AllMovieLandProvider", "Lkotlinx/serialization/Serializable;"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class MovieActor {

        @Nullable
        private final String character;

        @Nullable
        private final Integer id;

        @Nullable
        private final String name;

        public MovieActor() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ MovieActor copy$default(MovieActor movieActor, Integer num, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                num = movieActor.id;
            }
            if ((i & 2) != 0) {
                str = movieActor.name;
            }
            if ((i & 4) != 0) {
                str2 = movieActor.character;
            }
            return movieActor.copy(num, str, str2);
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
        public final String getCharacter() {
            return this.character;
        }

        @NotNull
        public final MovieActor copy(@Nullable Integer id, @Nullable String name, @Nullable String character) {
            return new MovieActor(id, name, character);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MovieActor)) {
                return false;
            }
            MovieActor movieActor = (MovieActor) other;
            return Intrinsics.areEqual(this.id, movieActor.id) && Intrinsics.areEqual(this.name, movieActor.name) && Intrinsics.areEqual(this.character, movieActor.character);
        }

        public int hashCode() {
            return ((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.character != null ? this.character.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "MovieActor(id=" + this.id + ", name=" + this.name + ", character=" + this.character + ')';
        }

        public MovieActor(@Nullable Integer id, @Nullable String name, @Nullable String character) {
            this.id = id;
            this.name = name;
            this.character = character;
        }

        public /* synthetic */ MovieActor(Integer num, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2);
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
        public final String getCharacter() {
            return this.character;
        }
    }

    /* JADX INFO: compiled from: AllMovieLandProvider.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\u0002\b\u0012¨\u0006\u0011"}, d2 = {"Lcom/phisher98/AllMovieLandProvider$Ratings;", "", "imdb", "Lcom/phisher98/AllMovieLandProvider$RatingInfo;", "<init>", "(Lcom/phisher98/AllMovieLandProvider$RatingInfo;)V", "getImdb", "()Lcom/phisher98/AllMovieLandProvider$RatingInfo;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "AllMovieLandProvider", "Lkotlinx/serialization/Serializable;"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Ratings {

        @Nullable
        private final RatingInfo imdb;

        /* JADX WARN: Illegal instructions before constructor call */
        public Ratings() {
            RatingInfo ratingInfo = null;
            this(ratingInfo, 1, ratingInfo);
        }

        public static /* synthetic */ Ratings copy$default(Ratings ratings, RatingInfo ratingInfo, int i, Object obj) {
            if ((i & 1) != 0) {
                ratingInfo = ratings.imdb;
            }
            return ratings.copy(ratingInfo);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final RatingInfo getImdb() {
            return this.imdb;
        }

        @NotNull
        public final Ratings copy(@Nullable RatingInfo imdb) {
            return new Ratings(imdb);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Ratings) && Intrinsics.areEqual(this.imdb, ((Ratings) other).imdb);
        }

        public int hashCode() {
            if (this.imdb == null) {
                return 0;
            }
            return this.imdb.hashCode();
        }

        @NotNull
        public String toString() {
            return "Ratings(imdb=" + this.imdb + ')';
        }

        public Ratings(@Nullable RatingInfo imdb) {
            this.imdb = imdb;
        }

        public /* synthetic */ Ratings(RatingInfo ratingInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : ratingInfo);
        }

        @Nullable
        public final RatingInfo getImdb() {
            return this.imdb;
        }
    }

    /* JADX INFO: compiled from: AllMovieLandProvider.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ&\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fÊ\u0001\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lcom/phisher98/AllMovieLandProvider$RatingInfo;", "", "rating", "", "votes", "", "<init>", "(Ljava/lang/Double;Ljava/lang/Integer;)V", "getRating", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getVotes", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/Double;Ljava/lang/Integer;)Lcom/phisher98/AllMovieLandProvider$RatingInfo;", "equals", "", "other", "hashCode", "toString", "", "AllMovieLandProvider", "Lkotlinx/serialization/Serializable;"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class RatingInfo {

        @Nullable
        private final Double rating;

        @Nullable
        private final Integer votes;

        /* JADX WARN: Multi-variable type inference failed */
        public RatingInfo() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ RatingInfo copy$default(RatingInfo ratingInfo, Double d, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                d = ratingInfo.rating;
            }
            if ((i & 2) != 0) {
                num = ratingInfo.votes;
            }
            return ratingInfo.copy(d, num);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Double getRating() {
            return this.rating;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getVotes() {
            return this.votes;
        }

        @NotNull
        public final RatingInfo copy(@Nullable Double rating, @Nullable Integer votes) {
            return new RatingInfo(rating, votes);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RatingInfo)) {
                return false;
            }
            RatingInfo ratingInfo = (RatingInfo) other;
            return Intrinsics.areEqual(this.rating, ratingInfo.rating) && Intrinsics.areEqual(this.votes, ratingInfo.votes);
        }

        public int hashCode() {
            return ((this.rating == null ? 0 : this.rating.hashCode()) * 31) + (this.votes != null ? this.votes.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "RatingInfo(rating=" + this.rating + ", votes=" + this.votes + ')';
        }

        public RatingInfo(@Nullable Double rating, @Nullable Integer votes) {
            this.rating = rating;
            this.votes = votes;
        }

        public /* synthetic */ RatingInfo(Double d, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : d, (i & 2) != 0 ? null : num);
        }

        @Nullable
        public final Double getRating() {
            return this.rating;
        }

        @Nullable
        public final Integer getVotes() {
            return this.votes;
        }
    }

    /* JADX INFO: compiled from: AllMovieLandProvider.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bÊ\u0001\u0002\b\u0014¨\u0006\u0013"}, d2 = {"Lcom/phisher98/AllMovieLandProvider$Genre;", "", "id", "", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "AllMovieLandProvider", "Lkotlinx/serialization/Serializable;"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Genre {

        @Nullable
        private final String id;

        @Nullable
        private final String name;

        /* JADX WARN: Illegal instructions before constructor call */
        public Genre() {
            String str = null;
            this(str, str, 3, str);
        }

        public static /* synthetic */ Genre copy$default(Genre genre, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = genre.id;
            }
            if ((i & 2) != 0) {
                str2 = genre.name;
            }
            return genre.copy(str, str2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @NotNull
        public final Genre copy(@Nullable String id, @Nullable String name) {
            return new Genre(id, name);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Genre)) {
                return false;
            }
            Genre genre = (Genre) other;
            return Intrinsics.areEqual(this.id, genre.id) && Intrinsics.areEqual(this.name, genre.name);
        }

        public int hashCode() {
            return ((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.name != null ? this.name.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Genre(id=" + this.id + ", name=" + this.name + ')';
        }

        public Genre(@Nullable String id, @Nullable String name) {
            this.id = id;
            this.name = name;
        }

        public /* synthetic */ Genre(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }

        @Nullable
        public final String getId() {
            return this.id;
        }

        @Nullable
        public final String getName() {
            return this.name;
        }
    }

    /* JADX INFO: compiled from: AllMovieLandProvider.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bÊ\u0001\u0002\b\u0014¨\u0006\u0013"}, d2 = {"Lcom/phisher98/AllMovieLandProvider$Country;", "", "id", "", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "AllMovieLandProvider", "Lkotlinx/serialization/Serializable;"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Country {

        @Nullable
        private final String id;

        @Nullable
        private final String name;

        /* JADX WARN: Illegal instructions before constructor call */
        public Country() {
            String str = null;
            this(str, str, 3, str);
        }

        public static /* synthetic */ Country copy$default(Country country, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = country.id;
            }
            if ((i & 2) != 0) {
                str2 = country.name;
            }
            return country.copy(str, str2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @NotNull
        public final Country copy(@Nullable String id, @Nullable String name) {
            return new Country(id, name);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Country)) {
                return false;
            }
            Country country = (Country) other;
            return Intrinsics.areEqual(this.id, country.id) && Intrinsics.areEqual(this.name, country.name);
        }

        public int hashCode() {
            return ((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.name != null ? this.name.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Country(id=" + this.id + ", name=" + this.name + ')';
        }

        public Country(@Nullable String id, @Nullable String name) {
            this.id = id;
            this.name = name;
        }

        public /* synthetic */ Country(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }

        @Nullable
        public final String getId() {
            return this.id;
        }

        @Nullable
        public final String getName() {
            return this.name;
        }
    }

    /* JADX INFO: compiled from: AllMovieLandProvider.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010JT\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0014\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010 \u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010!\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0014\u0010\u0010Ê\u0001\u0002\b#¨\u0006\""}, d2 = {"Lcom/phisher98/AllMovieLandProvider$PlayerResponse;", "", "url", "", "translator", "translator_id", "", "quality", "source", "server", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getUrl", "()Ljava/lang/String;", "getTranslator", "getTranslator_id", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getQuality", "getSource", "getServer", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/phisher98/AllMovieLandProvider$PlayerResponse;", "equals", "", "other", "hashCode", "toString", "AllMovieLandProvider", "Lkotlinx/serialization/Serializable;"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class PlayerResponse {

        @Nullable
        private final String quality;

        @Nullable
        private final Integer server;

        @Nullable
        private final String source;

        @Nullable
        private final String translator;

        @Nullable
        private final Integer translator_id;

        @NotNull
        private final String url;

        public static /* synthetic */ PlayerResponse copy$default(PlayerResponse playerResponse, String str, String str2, Integer num, String str3, String str4, Integer num2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = playerResponse.url;
            }
            if ((i & 2) != 0) {
                str2 = playerResponse.translator;
            }
            if ((i & 4) != 0) {
                num = playerResponse.translator_id;
            }
            if ((i & 8) != 0) {
                str3 = playerResponse.quality;
            }
            if ((i & 16) != 0) {
                str4 = playerResponse.source;
            }
            if ((i & 32) != 0) {
                num2 = playerResponse.server;
            }
            String str5 = str4;
            Integer num3 = num2;
            return playerResponse.copy(str, str2, num, str3, str5, num3);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTranslator() {
            return this.translator;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getTranslator_id() {
            return this.translator_id;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getQuality() {
            return this.quality;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getSource() {
            return this.source;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Integer getServer() {
            return this.server;
        }

        @NotNull
        public final PlayerResponse copy(@NotNull String url, @Nullable String translator, @Nullable Integer translator_id, @Nullable String quality, @Nullable String source, @Nullable Integer server) {
            return new PlayerResponse(url, translator, translator_id, quality, source, server);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PlayerResponse)) {
                return false;
            }
            PlayerResponse playerResponse = (PlayerResponse) other;
            return Intrinsics.areEqual(this.url, playerResponse.url) && Intrinsics.areEqual(this.translator, playerResponse.translator) && Intrinsics.areEqual(this.translator_id, playerResponse.translator_id) && Intrinsics.areEqual(this.quality, playerResponse.quality) && Intrinsics.areEqual(this.source, playerResponse.source) && Intrinsics.areEqual(this.server, playerResponse.server);
        }

        public int hashCode() {
            return (((((((((this.url.hashCode() * 31) + (this.translator == null ? 0 : this.translator.hashCode())) * 31) + (this.translator_id == null ? 0 : this.translator_id.hashCode())) * 31) + (this.quality == null ? 0 : this.quality.hashCode())) * 31) + (this.source == null ? 0 : this.source.hashCode())) * 31) + (this.server != null ? this.server.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "PlayerResponse(url=" + this.url + ", translator=" + this.translator + ", translator_id=" + this.translator_id + ", quality=" + this.quality + ", source=" + this.source + ", server=" + this.server + ')';
        }

        public PlayerResponse(@NotNull String url, @Nullable String translator, @Nullable Integer translator_id, @Nullable String quality, @Nullable String source, @Nullable Integer server) {
            this.url = url;
            this.translator = translator;
            this.translator_id = translator_id;
            this.quality = quality;
            this.source = source;
            this.server = server;
        }

        public /* synthetic */ PlayerResponse(String str, String str2, Integer num, String str3, String str4, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : num2);
        }

        @NotNull
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        public final String getTranslator() {
            return this.translator;
        }

        @Nullable
        public final Integer getTranslator_id() {
            return this.translator_id;
        }

        @Nullable
        public final String getQuality() {
            return this.quality;
        }

        @Nullable
        public final String getSource() {
            return this.source;
        }

        @Nullable
        public final Integer getServer() {
            return this.server;
        }
    }

    /* JADX INFO: compiled from: AllMovieLandProvider.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bÊ\u0001\u0002\b\u0013¨\u0006\u0012"}, d2 = {"Lcom/phisher98/AllMovieLandProvider$TmdbSearchResponse;", "", "results", "", "Lcom/phisher98/AllMovieLandProvider$TmdbSearchResult;", "<init>", "(Ljava/util/List;)V", "getResults", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "AllMovieLandProvider", "Lkotlinx/serialization/Serializable;"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class TmdbSearchResponse {

        @NotNull
        private final List<TmdbSearchResult> results;

        /* JADX WARN: Illegal instructions before constructor call */
        public TmdbSearchResponse() {
            List list = null;
            this(list, 1, list);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ TmdbSearchResponse copy$default(TmdbSearchResponse tmdbSearchResponse, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = tmdbSearchResponse.results;
            }
            return tmdbSearchResponse.copy(list);
        }

        @NotNull
        public final List<TmdbSearchResult> component1() {
            return this.results;
        }

        @NotNull
        public final TmdbSearchResponse copy(@NotNull List<TmdbSearchResult> results) {
            return new TmdbSearchResponse(results);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof TmdbSearchResponse) && Intrinsics.areEqual(this.results, ((TmdbSearchResponse) other).results);
        }

        public int hashCode() {
            return this.results.hashCode();
        }

        @NotNull
        public String toString() {
            return "TmdbSearchResponse(results=" + this.results + ')';
        }

        public TmdbSearchResponse(@NotNull List<TmdbSearchResult> list) {
            this.results = list;
        }

        public /* synthetic */ TmdbSearchResponse(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? CollectionsKt.emptyList() : list);
        }

        @NotNull
        public final List<TmdbSearchResult> getResults() {
            return this.results;
        }
    }

    /* JADX INFO: compiled from: AllMovieLandProvider.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\u0002\b\u0011¨\u0006\u0010"}, d2 = {"Lcom/phisher98/AllMovieLandProvider$TmdbSearchResult;", "", "id", "", "<init>", "(I)V", "getId", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "AllMovieLandProvider", "Lkotlinx/serialization/Serializable;"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class TmdbSearchResult {
        private final int id;

        public static /* synthetic */ TmdbSearchResult copy$default(TmdbSearchResult tmdbSearchResult, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = tmdbSearchResult.id;
            }
            return tmdbSearchResult.copy(i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getId() {
            return this.id;
        }

        @NotNull
        public final TmdbSearchResult copy(int id) {
            return new TmdbSearchResult(id);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof TmdbSearchResult) && this.id == ((TmdbSearchResult) other).id;
        }

        public int hashCode() {
            return this.id;
        }

        @NotNull
        public String toString() {
            return "TmdbSearchResult(id=" + this.id + ')';
        }

        public TmdbSearchResult(int id) {
            this.id = id;
        }

        public final int getId() {
            return this.id;
        }
    }

    /* JADX INFO: compiled from: AllMovieLandProvider.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u009d\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010#J\u0011\u00104\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0014HÆ\u0003J¤\u0001\u00107\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÆ\u0001¢\u0006\u0002\u00108J\u0014\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010<\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010=\u001a\u00020\u0005HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0019\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*Ê\u0001\u0002\b?¨\u0006>"}, d2 = {"Lcom/phisher98/AllMovieLandProvider$TmdbDetail;", "", "id", "", "name", "", "title", "overview", "backdrop_path", "poster_path", "release_date", "first_air_date", "vote_average", "", "genres", "", "Lcom/phisher98/AllMovieLandProvider$TmdbGenre;", "credits", "Lcom/phisher98/AllMovieLandProvider$TmdbCredits;", "external_ids", "Lcom/phisher98/AllMovieLandProvider$TmdbExternalIds;", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/util/List;Lcom/phisher98/AllMovieLandProvider$TmdbCredits;Lcom/phisher98/AllMovieLandProvider$TmdbExternalIds;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "getTitle", "getOverview", "getBackdrop_path", "getPoster_path", "getRelease_date", "getFirst_air_date", "getVote_average", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getGenres", "()Ljava/util/List;", "getCredits", "()Lcom/phisher98/AllMovieLandProvider$TmdbCredits;", "getExternal_ids", "()Lcom/phisher98/AllMovieLandProvider$TmdbExternalIds;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/util/List;Lcom/phisher98/AllMovieLandProvider$TmdbCredits;Lcom/phisher98/AllMovieLandProvider$TmdbExternalIds;)Lcom/phisher98/AllMovieLandProvider$TmdbDetail;", "equals", "", "other", "hashCode", "toString", "AllMovieLandProvider", "Lkotlinx/serialization/Serializable;"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class TmdbDetail {

        @Nullable
        private final String backdrop_path;

        @Nullable
        private final TmdbCredits credits;

        @Nullable
        private final TmdbExternalIds external_ids;

        @Nullable
        private final String first_air_date;

        @Nullable
        private final List<TmdbGenre> genres;

        @Nullable
        private final Integer id;

        @Nullable
        private final String name;

        @Nullable
        private final String overview;

        @Nullable
        private final String poster_path;

        @Nullable
        private final String release_date;

        @Nullable
        private final String title;

        @Nullable
        private final Double vote_average;

        public TmdbDetail() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, 4095, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ TmdbDetail copy$default(TmdbDetail tmdbDetail, Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, Double d, List list, TmdbCredits tmdbCredits, TmdbExternalIds tmdbExternalIds, int i, Object obj) {
            if ((i & 1) != 0) {
                num = tmdbDetail.id;
            }
            if ((i & 2) != 0) {
                str = tmdbDetail.name;
            }
            if ((i & 4) != 0) {
                str2 = tmdbDetail.title;
            }
            if ((i & 8) != 0) {
                str3 = tmdbDetail.overview;
            }
            if ((i & 16) != 0) {
                str4 = tmdbDetail.backdrop_path;
            }
            if ((i & 32) != 0) {
                str5 = tmdbDetail.poster_path;
            }
            if ((i & 64) != 0) {
                str6 = tmdbDetail.release_date;
            }
            if ((i & 128) != 0) {
                str7 = tmdbDetail.first_air_date;
            }
            if ((i & 256) != 0) {
                d = tmdbDetail.vote_average;
            }
            if ((i & 512) != 0) {
                list = tmdbDetail.genres;
            }
            if ((i & 1024) != 0) {
                tmdbCredits = tmdbDetail.credits;
            }
            if ((i & 2048) != 0) {
                tmdbExternalIds = tmdbDetail.external_ids;
            }
            TmdbCredits tmdbCredits2 = tmdbCredits;
            TmdbExternalIds tmdbExternalIds2 = tmdbExternalIds;
            Double d2 = d;
            List list2 = list;
            String str8 = str6;
            String str9 = str7;
            String str10 = str4;
            String str11 = str5;
            return tmdbDetail.copy(num, str, str2, str3, str10, str11, str8, str9, d2, list2, tmdbCredits2, tmdbExternalIds2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        public final List<TmdbGenre> component10() {
            return this.genres;
        }

        @Nullable
        /* JADX INFO: renamed from: component11, reason: from getter */
        public final TmdbCredits getCredits() {
            return this.credits;
        }

        @Nullable
        /* JADX INFO: renamed from: component12, reason: from getter */
        public final TmdbExternalIds getExternal_ids() {
            return this.external_ids;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getOverview() {
            return this.overview;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getBackdrop_path() {
            return this.backdrop_path;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getPoster_path() {
            return this.poster_path;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getRelease_date() {
            return this.release_date;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getFirst_air_date() {
            return this.first_air_date;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final Double getVote_average() {
            return this.vote_average;
        }

        @NotNull
        public final TmdbDetail copy(@Nullable Integer id, @Nullable String name, @Nullable String title, @Nullable String overview, @Nullable String backdrop_path, @Nullable String poster_path, @Nullable String release_date, @Nullable String first_air_date, @Nullable Double vote_average, @Nullable List<TmdbGenre> genres, @Nullable TmdbCredits credits, @Nullable TmdbExternalIds external_ids) {
            return new TmdbDetail(id, name, title, overview, backdrop_path, poster_path, release_date, first_air_date, vote_average, genres, credits, external_ids);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TmdbDetail)) {
                return false;
            }
            TmdbDetail tmdbDetail = (TmdbDetail) other;
            return Intrinsics.areEqual(this.id, tmdbDetail.id) && Intrinsics.areEqual(this.name, tmdbDetail.name) && Intrinsics.areEqual(this.title, tmdbDetail.title) && Intrinsics.areEqual(this.overview, tmdbDetail.overview) && Intrinsics.areEqual(this.backdrop_path, tmdbDetail.backdrop_path) && Intrinsics.areEqual(this.poster_path, tmdbDetail.poster_path) && Intrinsics.areEqual(this.release_date, tmdbDetail.release_date) && Intrinsics.areEqual(this.first_air_date, tmdbDetail.first_air_date) && Intrinsics.areEqual(this.vote_average, tmdbDetail.vote_average) && Intrinsics.areEqual(this.genres, tmdbDetail.genres) && Intrinsics.areEqual(this.credits, tmdbDetail.credits) && Intrinsics.areEqual(this.external_ids, tmdbDetail.external_ids);
        }

        public int hashCode() {
            return ((((((((((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.overview == null ? 0 : this.overview.hashCode())) * 31) + (this.backdrop_path == null ? 0 : this.backdrop_path.hashCode())) * 31) + (this.poster_path == null ? 0 : this.poster_path.hashCode())) * 31) + (this.release_date == null ? 0 : this.release_date.hashCode())) * 31) + (this.first_air_date == null ? 0 : this.first_air_date.hashCode())) * 31) + (this.vote_average == null ? 0 : this.vote_average.hashCode())) * 31) + (this.genres == null ? 0 : this.genres.hashCode())) * 31) + (this.credits == null ? 0 : this.credits.hashCode())) * 31) + (this.external_ids != null ? this.external_ids.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("TmdbDetail(id=").append(this.id).append(", name=").append(this.name).append(", title=").append(this.title).append(", overview=").append(this.overview).append(", backdrop_path=").append(this.backdrop_path).append(", poster_path=").append(this.poster_path).append(", release_date=").append(this.release_date).append(", first_air_date=").append(this.first_air_date).append(", vote_average=").append(this.vote_average).append(", genres=").append(this.genres).append(", credits=").append(this.credits).append(", external_ids=");
            sb.append(this.external_ids).append(')');
            return sb.toString();
        }

        public TmdbDetail(@Nullable Integer id, @Nullable String name, @Nullable String title, @Nullable String overview, @Nullable String backdrop_path, @Nullable String poster_path, @Nullable String release_date, @Nullable String first_air_date, @Nullable Double vote_average, @Nullable List<TmdbGenre> list, @Nullable TmdbCredits credits, @Nullable TmdbExternalIds external_ids) {
            this.id = id;
            this.name = name;
            this.title = title;
            this.overview = overview;
            this.backdrop_path = backdrop_path;
            this.poster_path = poster_path;
            this.release_date = release_date;
            this.first_air_date = first_air_date;
            this.vote_average = vote_average;
            this.genres = list;
            this.credits = credits;
            this.external_ids = external_ids;
        }

        public /* synthetic */ TmdbDetail(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, Double d, List list, TmdbCredits tmdbCredits, TmdbExternalIds tmdbExternalIds, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : d, (i & 512) != 0 ? null : list, (i & 1024) != 0 ? null : tmdbCredits, (i & 2048) != 0 ? null : tmdbExternalIds);
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
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final String getOverview() {
            return this.overview;
        }

        @Nullable
        public final String getBackdrop_path() {
            return this.backdrop_path;
        }

        @Nullable
        public final String getPoster_path() {
            return this.poster_path;
        }

        @Nullable
        public final String getRelease_date() {
            return this.release_date;
        }

        @Nullable
        public final String getFirst_air_date() {
            return this.first_air_date;
        }

        @Nullable
        public final Double getVote_average() {
            return this.vote_average;
        }

        @Nullable
        public final List<TmdbGenre> getGenres() {
            return this.genres;
        }

        @Nullable
        public final TmdbCredits getCredits() {
            return this.credits;
        }

        @Nullable
        public final TmdbExternalIds getExternal_ids() {
            return this.external_ids;
        }
    }

    /* JADX INFO: compiled from: AllMovieLandProvider.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0005HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fÊ\u0001\u0002\b\u0017¨\u0006\u0016"}, d2 = {"Lcom/phisher98/AllMovieLandProvider$TmdbGenre;", "", "id", "", "name", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/phisher98/AllMovieLandProvider$TmdbGenre;", "equals", "", "other", "hashCode", "toString", "AllMovieLandProvider", "Lkotlinx/serialization/Serializable;"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class TmdbGenre {

        @Nullable
        private final Integer id;

        @Nullable
        private final String name;

        /* JADX WARN: Multi-variable type inference failed */
        public TmdbGenre() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ TmdbGenre copy$default(TmdbGenre tmdbGenre, Integer num, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                num = tmdbGenre.id;
            }
            if ((i & 2) != 0) {
                str = tmdbGenre.name;
            }
            return tmdbGenre.copy(num, str);
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

        @NotNull
        public final TmdbGenre copy(@Nullable Integer id, @Nullable String name) {
            return new TmdbGenre(id, name);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TmdbGenre)) {
                return false;
            }
            TmdbGenre tmdbGenre = (TmdbGenre) other;
            return Intrinsics.areEqual(this.id, tmdbGenre.id) && Intrinsics.areEqual(this.name, tmdbGenre.name);
        }

        public int hashCode() {
            return ((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.name != null ? this.name.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "TmdbGenre(id=" + this.id + ", name=" + this.name + ')';
        }

        public TmdbGenre(@Nullable Integer id, @Nullable String name) {
            this.id = id;
            this.name = name;
        }

        public /* synthetic */ TmdbGenre(Integer num, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str);
        }

        @Nullable
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        public final String getName() {
            return this.name;
        }
    }

    /* JADX INFO: compiled from: AllMovieLandProvider.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bÊ\u0001\u0002\b\u0013¨\u0006\u0012"}, d2 = {"Lcom/phisher98/AllMovieLandProvider$TmdbCredits;", "", "cast", "", "Lcom/phisher98/AllMovieLandProvider$TmdbCast;", "<init>", "(Ljava/util/List;)V", "getCast", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "AllMovieLandProvider", "Lkotlinx/serialization/Serializable;"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class TmdbCredits {

        @Nullable
        private final List<TmdbCast> cast;

        /* JADX WARN: Illegal instructions before constructor call */
        public TmdbCredits() {
            List list = null;
            this(list, 1, list);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ TmdbCredits copy$default(TmdbCredits tmdbCredits, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = tmdbCredits.cast;
            }
            return tmdbCredits.copy(list);
        }

        @Nullable
        public final List<TmdbCast> component1() {
            return this.cast;
        }

        @NotNull
        public final TmdbCredits copy(@Nullable List<TmdbCast> cast) {
            return new TmdbCredits(cast);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof TmdbCredits) && Intrinsics.areEqual(this.cast, ((TmdbCredits) other).cast);
        }

        public int hashCode() {
            if (this.cast == null) {
                return 0;
            }
            return this.cast.hashCode();
        }

        @NotNull
        public String toString() {
            return "TmdbCredits(cast=" + this.cast + ')';
        }

        public TmdbCredits(@Nullable List<TmdbCast> list) {
            this.cast = list;
        }

        public /* synthetic */ TmdbCredits(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : list);
        }

        @Nullable
        public final List<TmdbCast> getCast() {
            return this.cast;
        }
    }

    /* JADX INFO: compiled from: AllMovieLandProvider.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tÊ\u0001\u0002\b\u0017¨\u0006\u0016"}, d2 = {"Lcom/phisher98/AllMovieLandProvider$TmdbCast;", "", "name", "", "character", "profile_path", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getCharacter", "getProfile_path", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "AllMovieLandProvider", "Lkotlinx/serialization/Serializable;"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class TmdbCast {

        @Nullable
        private final String character;

        @NotNull
        private final String name;

        @Nullable
        private final String profile_path;

        public static /* synthetic */ TmdbCast copy$default(TmdbCast tmdbCast, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = tmdbCast.name;
            }
            if ((i & 2) != 0) {
                str2 = tmdbCast.character;
            }
            if ((i & 4) != 0) {
                str3 = tmdbCast.profile_path;
            }
            return tmdbCast.copy(str, str2, str3);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getCharacter() {
            return this.character;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getProfile_path() {
            return this.profile_path;
        }

        @NotNull
        public final TmdbCast copy(@NotNull String name, @Nullable String character, @Nullable String profile_path) {
            return new TmdbCast(name, character, profile_path);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TmdbCast)) {
                return false;
            }
            TmdbCast tmdbCast = (TmdbCast) other;
            return Intrinsics.areEqual(this.name, tmdbCast.name) && Intrinsics.areEqual(this.character, tmdbCast.character) && Intrinsics.areEqual(this.profile_path, tmdbCast.profile_path);
        }

        public int hashCode() {
            return (((this.name.hashCode() * 31) + (this.character == null ? 0 : this.character.hashCode())) * 31) + (this.profile_path != null ? this.profile_path.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "TmdbCast(name=" + this.name + ", character=" + this.character + ", profile_path=" + this.profile_path + ')';
        }

        public TmdbCast(@NotNull String name, @Nullable String character, @Nullable String profile_path) {
            this.name = name;
            this.character = character;
            this.profile_path = profile_path;
        }

        public /* synthetic */ TmdbCast(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
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
        public final String getProfile_path() {
            return this.profile_path;
        }
    }

    /* JADX INFO: compiled from: AllMovieLandProvider.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\u0002\b\u0011¨\u0006\u0010"}, d2 = {"Lcom/phisher98/AllMovieLandProvider$TmdbExternalIds;", "", "imdb_id", "", "<init>", "(Ljava/lang/String;)V", "getImdb_id", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "AllMovieLandProvider", "Lkotlinx/serialization/Serializable;"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class TmdbExternalIds {

        @Nullable
        private final String imdb_id;

        /* JADX WARN: Illegal instructions before constructor call */
        public TmdbExternalIds() {
            String str = null;
            this(str, 1, str);
        }

        public static /* synthetic */ TmdbExternalIds copy$default(TmdbExternalIds tmdbExternalIds, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = tmdbExternalIds.imdb_id;
            }
            return tmdbExternalIds.copy(str);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getImdb_id() {
            return this.imdb_id;
        }

        @NotNull
        public final TmdbExternalIds copy(@Nullable String imdb_id) {
            return new TmdbExternalIds(imdb_id);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof TmdbExternalIds) && Intrinsics.areEqual(this.imdb_id, ((TmdbExternalIds) other).imdb_id);
        }

        public int hashCode() {
            if (this.imdb_id == null) {
                return 0;
            }
            return this.imdb_id.hashCode();
        }

        @NotNull
        public String toString() {
            return "TmdbExternalIds(imdb_id=" + this.imdb_id + ')';
        }

        public TmdbExternalIds(@Nullable String imdb_id) {
            this.imdb_id = imdb_id;
        }

        public /* synthetic */ TmdbExternalIds(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str);
        }

        @Nullable
        public final String getImdb_id() {
            return this.imdb_id;
        }
    }

    /* JADX INFO: compiled from: AllMovieLandProvider.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bÊ\u0001\u0002\b\u0013¨\u0006\u0012"}, d2 = {"Lcom/phisher98/AllMovieLandProvider$TmdbSeasonResponse;", "", "episodes", "", "Lcom/phisher98/AllMovieLandProvider$TmdbEpisode;", "<init>", "(Ljava/util/List;)V", "getEpisodes", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "AllMovieLandProvider", "Lkotlinx/serialization/Serializable;"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class TmdbSeasonResponse {

        @Nullable
        private final List<TmdbEpisode> episodes;

        /* JADX WARN: Illegal instructions before constructor call */
        public TmdbSeasonResponse() {
            List list = null;
            this(list, 1, list);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ TmdbSeasonResponse copy$default(TmdbSeasonResponse tmdbSeasonResponse, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = tmdbSeasonResponse.episodes;
            }
            return tmdbSeasonResponse.copy(list);
        }

        @Nullable
        public final List<TmdbEpisode> component1() {
            return this.episodes;
        }

        @NotNull
        public final TmdbSeasonResponse copy(@Nullable List<TmdbEpisode> episodes) {
            return new TmdbSeasonResponse(episodes);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof TmdbSeasonResponse) && Intrinsics.areEqual(this.episodes, ((TmdbSeasonResponse) other).episodes);
        }

        public int hashCode() {
            if (this.episodes == null) {
                return 0;
            }
            return this.episodes.hashCode();
        }

        @NotNull
        public String toString() {
            return "TmdbSeasonResponse(episodes=" + this.episodes + ')';
        }

        public TmdbSeasonResponse(@Nullable List<TmdbEpisode> list) {
            this.episodes = list;
        }

        public /* synthetic */ TmdbSeasonResponse(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : list);
        }

        @Nullable
        public final List<TmdbEpisode> getEpisodes() {
            return this.episodes;
        }
    }

    /* JADX INFO: compiled from: AllMovieLandProvider.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003JV\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0014\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010#\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010$\u001a\u00020\u0005HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011Ê\u0001\u0002\b&¨\u0006%"}, d2 = {"Lcom/phisher98/AllMovieLandProvider$TmdbEpisode;", "", "episode_number", "", "name", "", "overview", "still_path", "vote_average", "", "air_date", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;)V", "getEpisode_number", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "getOverview", "getStill_path", "getVote_average", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getAir_date", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;)Lcom/phisher98/AllMovieLandProvider$TmdbEpisode;", "equals", "", "other", "hashCode", "toString", "AllMovieLandProvider", "Lkotlinx/serialization/Serializable;"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class TmdbEpisode {

        @Nullable
        private final String air_date;

        @Nullable
        private final Integer episode_number;

        @Nullable
        private final String name;

        @Nullable
        private final String overview;

        @Nullable
        private final String still_path;

        @Nullable
        private final Double vote_average;

        public TmdbEpisode() {
            this(null, null, null, null, null, null, 63, null);
        }

        public static /* synthetic */ TmdbEpisode copy$default(TmdbEpisode tmdbEpisode, Integer num, String str, String str2, String str3, Double d, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                num = tmdbEpisode.episode_number;
            }
            if ((i & 2) != 0) {
                str = tmdbEpisode.name;
            }
            if ((i & 4) != 0) {
                str2 = tmdbEpisode.overview;
            }
            if ((i & 8) != 0) {
                str3 = tmdbEpisode.still_path;
            }
            if ((i & 16) != 0) {
                d = tmdbEpisode.vote_average;
            }
            if ((i & 32) != 0) {
                str4 = tmdbEpisode.air_date;
            }
            Double d2 = d;
            String str5 = str4;
            return tmdbEpisode.copy(num, str, str2, str3, d2, str5);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getEpisode_number() {
            return this.episode_number;
        }

        @Nullable
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
        public final String getStill_path() {
            return this.still_path;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Double getVote_average() {
            return this.vote_average;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getAir_date() {
            return this.air_date;
        }

        @NotNull
        public final TmdbEpisode copy(@Nullable Integer episode_number, @Nullable String name, @Nullable String overview, @Nullable String still_path, @Nullable Double vote_average, @Nullable String air_date) {
            return new TmdbEpisode(episode_number, name, overview, still_path, vote_average, air_date);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TmdbEpisode)) {
                return false;
            }
            TmdbEpisode tmdbEpisode = (TmdbEpisode) other;
            return Intrinsics.areEqual(this.episode_number, tmdbEpisode.episode_number) && Intrinsics.areEqual(this.name, tmdbEpisode.name) && Intrinsics.areEqual(this.overview, tmdbEpisode.overview) && Intrinsics.areEqual(this.still_path, tmdbEpisode.still_path) && Intrinsics.areEqual(this.vote_average, tmdbEpisode.vote_average) && Intrinsics.areEqual(this.air_date, tmdbEpisode.air_date);
        }

        public int hashCode() {
            return ((((((((((this.episode_number == null ? 0 : this.episode_number.hashCode()) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.overview == null ? 0 : this.overview.hashCode())) * 31) + (this.still_path == null ? 0 : this.still_path.hashCode())) * 31) + (this.vote_average == null ? 0 : this.vote_average.hashCode())) * 31) + (this.air_date != null ? this.air_date.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "TmdbEpisode(episode_number=" + this.episode_number + ", name=" + this.name + ", overview=" + this.overview + ", still_path=" + this.still_path + ", vote_average=" + this.vote_average + ", air_date=" + this.air_date + ')';
        }

        public TmdbEpisode(@Nullable Integer episode_number, @Nullable String name, @Nullable String overview, @Nullable String still_path, @Nullable Double vote_average, @Nullable String air_date) {
            this.episode_number = episode_number;
            this.name = name;
            this.overview = overview;
            this.still_path = still_path;
            this.vote_average = vote_average;
            this.air_date = air_date;
        }

        public /* synthetic */ TmdbEpisode(Integer num, String str, String str2, String str3, Double d, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : d, (i & 32) != 0 ? null : str4);
        }

        @Nullable
        public final Integer getEpisode_number() {
            return this.episode_number;
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
        public final String getStill_path() {
            return this.still_path;
        }

        @Nullable
        public final Double getVote_average() {
            return this.vote_average;
        }

        @Nullable
        public final String getAir_date() {
            return this.air_date;
        }
    }

    /* JADX INFO: compiled from: AllMovieLandProvider.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bÊ\u0001\u0002\b\u0013¨\u0006\u0012"}, d2 = {"Lcom/phisher98/AllMovieLandProvider$SearchApiResponse;", "", "results", "", "Lcom/phisher98/AllMovieLandProvider$CatalogMovie;", "<init>", "(Ljava/util/List;)V", "getResults", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "AllMovieLandProvider", "Lkotlinx/serialization/Serializable;"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final /* data */ class SearchApiResponse {

        @NotNull
        private final List<CatalogMovie> results;

        /* JADX WARN: Illegal instructions before constructor call */
        public SearchApiResponse() {
            List list = null;
            this(list, 1, list);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SearchApiResponse copy$default(SearchApiResponse searchApiResponse, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = searchApiResponse.results;
            }
            return searchApiResponse.copy(list);
        }

        @NotNull
        public final List<CatalogMovie> component1() {
            return this.results;
        }

        @NotNull
        public final SearchApiResponse copy(@NotNull List<CatalogMovie> results) {
            return new SearchApiResponse(results);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof SearchApiResponse) && Intrinsics.areEqual(this.results, ((SearchApiResponse) other).results);
        }

        public int hashCode() {
            return this.results.hashCode();
        }

        @NotNull
        public String toString() {
            return "SearchApiResponse(results=" + this.results + ')';
        }

        public SearchApiResponse(@NotNull List<CatalogMovie> list) {
            this.results = list;
        }

        public /* synthetic */ SearchApiResponse(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? CollectionsKt.emptyList() : list);
        }

        @NotNull
        public final List<CatalogMovie> getResults() {
            return this.results;
        }
    }
}
