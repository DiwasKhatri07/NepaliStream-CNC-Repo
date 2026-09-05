package com.phisher98;

import android.content.SharedPreferences;
import androidx.annotation.RequiresApi;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.ActorData;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.ErrorLoadingException;
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
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SearchResponseList;
import com.lagradost.cloudstream3.ShowStatus;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.metaproviders.TmdbProvider;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
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
import kotlin.text.StringsKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StremioAddon.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StremioAddon/classes.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\u0018\u0000 G2\u00020\u0001:\u0018GHIJKLMNOPQRSTUVWXYZ[\\]^B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010!\u001a\u0004\u0018\u00010\u00072\b\u0010\"\u001a\u0004\u0018\u00010\u00072\b\u0010#\u001a\u0004\u0018\u00010\u0007H\u0002J\u001e\u0010$\u001a\u0004\u0018\u00010\u00072\b\u0010\"\u001a\u0004\u0018\u00010\u00072\b\u0010#\u001a\u0004\u0018\u00010\u0007H\u0002J\u001e\u0010\u001d\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0096@¢\u0006\u0002\u0010*J\u001a\u0010+\u001a\u0004\u0018\u00010,*\u00020-2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0007H\u0002J\u001e\u0010/\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u001b2\u0006\u00100\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u00101J \u00102\u001a\u0004\u0018\u0001032\u0006\u00100\u001a\u00020\u00072\u0006\u0010&\u001a\u00020'H\u0096@¢\u0006\u0002\u00104J\u0018\u00105\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u00101JF\u00108\u001a\u00020\u00102\u0006\u00109\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u00102\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020>0<2\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020>0<H\u0096@¢\u0006\u0002\u0010AJZ\u0010B\u001a\u00020>2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010D\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010'2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020>0<2\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020>0<H\u0082@¢\u0006\u0002\u0010FR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u0010X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R+\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0016X\u0097\u0004\u0092\u0002\f\b\u001f\u0012\b\b \u0012\u0004\b\u0003\u00104¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006_"}, d2 = {"Lcom/phisher98/StremioAddon;", "Lcom/lagradost/cloudstream3/metaproviders/TmdbProvider;", "sharedPref", "Landroid/content/SharedPreferences;", "<init>", "(Landroid/content/SharedPreferences;)V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "hasQuickSearch", "getHasQuickSearch", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Landroidx/annotation/RequiresApi;", "value", "getImageUrl", "link", "fallback", "getOriImageUrl", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResponse", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lcom/phisher98/StremioAddon$Media;", "type", "quickSearch", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "Lcom/lagradost/cloudstream3/SearchResponseList;", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeMainSource", "imdbId", "season", "episode", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "StreamsResponse", "Subtitle", "ProxyHeaders", "BehaviorHints", "Stream", "LoadData", "Data", "Results", "Media", "Genres", "Keywords", "KeywordResults", "Seasons", "Cast", "Episodes", "MediaDetailEpisodes", "Trailers", "ResultsTrailer", "ExternalIds", "Credits", "ResultsRecommendations", "LastEpisodeToAir", "MediaDetail", "StremioAddon"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nStremioAddon.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StremioAddon.kt\ncom/phisher98/StremioAddon\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 6 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 7 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,528:1\n37#2,2:529\n73#3,5:531\n73#3,5:550\n73#3,5:588\n73#3,5:679\n73#3,5:710\n1795#4,10:536\n2068#4:546\n2069#4:548\n1805#4:549\n1795#4,10:555\n2068#4:565\n2069#4:567\n1805#4:568\n1795#4,10:593\n2068#4:603\n2069#4:605\n1805#4:606\n1795#4,10:607\n2068#4:617\n2069#4:619\n1805#4:620\n1795#4,10:622\n2068#4:632\n2069#4:634\n1805#4:635\n1795#4,10:636\n2068#4:646\n2069#4:648\n1805#4:649\n1795#4,10:650\n2068#4:660\n2069#4:662\n1805#4:663\n1739#4:664\n1814#4,3:665\n1795#4,10:668\n2068#4:678\n1739#4:684\n1814#4,3:685\n2069#4:689\n1805#4:690\n1#5:547\n1#5:566\n1#5:570\n1#5:604\n1#5:618\n1#5:621\n1#5:633\n1#5:647\n1#5:661\n1#5:688\n1#5:692\n63#6:569\n64#6,15:571\n63#6:691\n64#6,15:693\n50#7:586\n43#7:587\n50#7:708\n43#7:709\n*S KotlinDebug\n*F\n+ 1 StremioAddon.kt\ncom/phisher98/StremioAddon\n*L\n101#1:529,2\n121#1:531,5\n142#1:550,5\n156#1:588,5\n194#1:679,5\n302#1:710,5\n121#1:536,10\n121#1:546\n121#1:548\n121#1:549\n142#1:555,10\n142#1:565\n142#1:567\n142#1:568\n164#1:593,10\n164#1:603\n164#1:605\n164#1:606\n167#1:607,10\n167#1:617\n167#1:619\n167#1:620\n168#1:622,10\n168#1:632\n168#1:634\n168#1:635\n170#1:636,10\n170#1:646\n170#1:648\n170#1:649\n179#1:650,10\n179#1:660\n179#1:662\n179#1:663\n181#1:664\n181#1:665,3\n192#1:668,10\n192#1:678\n194#1:684\n194#1:685,3\n192#1:689\n192#1:690\n121#1:547\n142#1:566\n149#1:570\n164#1:604\n167#1:618\n168#1:633\n170#1:647\n179#1:661\n192#1:688\n260#1:692\n149#1:569\n149#1:571,15\n260#1:691\n260#1:693,15\n149#1:586\n149#1:587\n260#1:708\n260#1:709\n*E\n"})
public final class StremioAddon extends TmdbProvider {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String TRACKER_LIST_URL = "https://raw.githubusercontent.com/ngosang/trackerslist/master/trackers_best.txt";

    @NotNull
    private static final String apiKey = "98ae14df2b8d8f8f8136499daf79f0e0";

    @NotNull
    private static final String tmdbAPI = "https://api.themoviedb.org/3";

    @RequiresApi(26)
    @NotNull
    private final List<MainPageData> mainPage;

    @NotNull
    private final SharedPreferences sharedPref;

    @NotNull
    private String mainUrl = "https://example.com";

    @NotNull
    private String name = "Stremio";
    private final boolean hasMainPage = true;
    private final boolean hasQuickSearch = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.TvSeries, TvType.Torrent});

    /* JADX INFO: renamed from: com.phisher98.StremioAddon$getMainPage$1 */
    /* JADX INFO: compiled from: StremioAddon.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StremioAddon", f = "StremioAddon.kt", i = {0, 0, 0, 0}, l = {120}, m = "getMainPage", n = {"request", "adultQuery", "type", "page"}, nl = {121}, s = {"L$0", "L$1", "L$2", "I$0"}, v = 2)
    static final class C00001 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00001(Continuation<? super C00001> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StremioAddon.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StremioAddon$invokeMainSource$1 */
    /* JADX INFO: compiled from: StremioAddon.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StremioAddon", f = "StremioAddon.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {302, 304}, m = "invokeMainSource", n = {"imdbId", "season", "episode", "subtitleCallback", "callback", "addonList", "addonPref", "fixMainUrl", "url", "$this$invokeMainSource_u24lambda_u241", "imdbId", "season", "episode", "subtitleCallback", "callback", "addonList", "addonPref", "fixMainUrl", "url", "res"}, nl = {529, 307}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "L$9", "L$10", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "L$9", "L$11"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
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
            return StremioAddon.this.invokeMainSource(null, null, null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StremioAddon$load$1 */
    /* JADX INFO: compiled from: StremioAddon.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StremioAddon", f = "StremioAddon.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {156, 183, 193, 212, 230}, m = "load", n = {"url", "data", "type", "resUrl", "url", "data", "type", "resUrl", "res", "title", "poster", "bgPoster", "releaseDate", "year", "genres", "keywords", "actors", "recommendations", "trailer", "isAnime", "url", "data", "type", "resUrl", "res", "title", "poster", "bgPoster", "releaseDate", "year", "genres", "keywords", "actors", "recommendations", "trailer", "logoUrl", "$this$mapNotNull$iv", "$this$mapNotNullTo$iv$iv", "destination$iv$iv", "$this$forEach$iv$iv$iv", "element$iv$iv$iv", "element$iv$iv", "season", "isAnime", "url", "data", "type", "resUrl", "res", "title", "poster", "bgPoster", "releaseDate", "year", "genres", "keywords", "actors", "recommendations", "trailer", "logoUrl", "episodes", "isAnime", "url", "data", "type", "resUrl", "res", "title", "poster", "bgPoster", "releaseDate", "year", "genres", "keywords", "actors", "recommendations", "trailer", "logoUrl", "isAnime"}, nl = {548, 191, 194, 230, 191}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$21", "L$22", "L$23", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "I$0"}, v = 2)
    static final class C00021 extends ContinuationImpl {
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

        C00021(Continuation<? super C00021> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StremioAddon.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StremioAddon$loadLinks$1 */
    /* JADX INFO: compiled from: StremioAddon.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StremioAddon", f = "StremioAddon.kt", i = {0, 0, 0, 0, 0}, l = {262}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "res", "isCasting"}, nl = {268}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0"}, v = 2)
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
            return StremioAddon.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StremioAddon$quickSearch$1 */
    /* JADX INFO: compiled from: StremioAddon.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StremioAddon", f = "StremioAddon.kt", i = {0}, l = {137}, m = "quickSearch", n = {"query"}, nl = {-1}, s = {"L$0"}, v = 2)
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
            return StremioAddon.this.quickSearch(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StremioAddon$search$1 */
    /* JADX INFO: compiled from: StremioAddon.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StremioAddon", f = "StremioAddon.kt", i = {0, 0}, l = {140}, m = "search", n = {"query", "page"}, nl = {142}, s = {"L$0", "I$0"}, v = 2)
    static final class C00101 extends ContinuationImpl {
        int I$0;
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
            return StremioAddon.this.search(null, 0, (Continuation) this);
        }
    }

    public StremioAddon(@NotNull SharedPreferences sharedPref) {
        this.sharedPref = sharedPref;
        Collection categories = (List) new ArrayList();
        int currentMonth = Calendar.getInstance().get(2) + 1;
        categories.add(TuplesKt.to("https://api.themoviedb.org/3/trending/all/day?api_key=98ae14df2b8d8f8f8136499daf79f0e0&region=US", "Trending"));
        categories.add(TuplesKt.to("https://api.themoviedb.org/3/movie/popular?api_key=98ae14df2b8d8f8f8136499daf79f0e0&region=US", "Popular Movies"));
        switch (currentMonth) {
            case 11:
            case 12:
                categories.add(TuplesKt.to("https://api.themoviedb.org/3/discover/movie?api_key=98ae14df2b8d8f8f8136499daf79f0e0&with_keywords=207317&region=US", "Christmas Movies"));
                break;
        }
        if (currentMonth == 10) {
            categories.add(TuplesKt.to("https://api.themoviedb.org/3/discover/movie?api_key=98ae14df2b8d8f8f8136499daf79f0e0&with_genres=27&region=US", "Halloween Horror Movies"));
        }
        categories.add(TuplesKt.to("https://api.themoviedb.org/3/tv/popular?api_key=98ae14df2b8d8f8f8136499daf79f0e0&region=US&with_original_language=en", "Popular TV Shows"));
        categories.add(TuplesKt.to("https://api.themoviedb.org/3/tv/airing_today?api_key=98ae14df2b8d8f8f8136499daf79f0e0&region=US&with_original_language=en", "Airing Today TV Shows"));
        categories.add(TuplesKt.to("https://api.themoviedb.org/3/discover/tv?api_key=98ae14df2b8d8f8f8136499daf79f0e0&with_networks=213", "Netflix"));
        categories.add(TuplesKt.to("https://api.themoviedb.org/3/discover/tv?api_key=98ae14df2b8d8f8f8136499daf79f0e0&with_networks=1024", "Amazon Prime"));
        categories.add(TuplesKt.to("https://api.themoviedb.org/3/discover/tv?api_key=98ae14df2b8d8f8f8136499daf79f0e0&with_networks=2739", "Disney+"));
        categories.add(TuplesKt.to("https://api.themoviedb.org/3/discover/tv?api_key=98ae14df2b8d8f8f8136499daf79f0e0&with_networks=453", "Hulu"));
        categories.add(TuplesKt.to("https://api.themoviedb.org/3/discover/tv?api_key=98ae14df2b8d8f8f8136499daf79f0e0&with_networks=2552", "Apple TV+"));
        categories.add(TuplesKt.to("https://api.themoviedb.org/3/discover/tv?api_key=98ae14df2b8d8f8f8136499daf79f0e0&with_networks=49", "HBO Max"));
        categories.add(TuplesKt.to("https://api.themoviedb.org/3/discover/tv?api_key=98ae14df2b8d8f8f8136499daf79f0e0&with_networks=4330", "Paramount+"));
        categories.add(TuplesKt.to("https://api.themoviedb.org/3/movie/top_rated?api_key=98ae14df2b8d8f8f8136499daf79f0e0&region=US", "Top Rated Movies"));
        categories.add(TuplesKt.to("https://api.themoviedb.org/3/tv/top_rated?api_key=98ae14df2b8d8f8f8136499daf79f0e0&region=US", "Top Rated TV Shows"));
        categories.add(TuplesKt.to("https://api.themoviedb.org/3/movie/upcoming?api_key=98ae14df2b8d8f8f8136499daf79f0e0&region=US", "Upcoming Movies"));
        Collection $this$toTypedArray$iv = categories;
        Pair[] pairArr = (Pair[]) $this$toTypedArray$iv.toArray(new Pair[0]);
        this.mainPage = MainAPIKt.mainPageOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
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

    public boolean getHasQuickSearch() {
        return this.hasQuickSearch;
    }

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    /* JADX INFO: compiled from: StremioAddon.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/phisher98/StremioAddon$Companion;", "", "<init>", "()V", "TRACKER_LIST_URL", "", "tmdbAPI", "apiKey", "getType", "Lcom/lagradost/cloudstream3/TvType;", "t", "getStatus", "Lcom/lagradost/cloudstream3/ShowStatus;", "StremioAddon"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final TvType getType(@Nullable String t) {
            return Intrinsics.areEqual(t, "movie") ? TvType.Movie : TvType.TvSeries;
        }

        @NotNull
        public final ShowStatus getStatus(@Nullable String t) {
            return Intrinsics.areEqual(t, "Returning Series") ? ShowStatus.Ongoing : ShowStatus.Completed;
        }
    }

    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    private final String getImageUrl(String link, String fallback) {
        if (link == null) {
            return fallback;
        }
        return StringsKt.startsWith$default(link, "/", false, 2, (Object) null) ? "https://image.tmdb.org/t/p/original/" + link : link;
    }

    private final String getOriImageUrl(String link, String fallback) {
        if (link == null) {
            return fallback;
        }
        return StringsKt.startsWith$default(link, "/", false, 2, (Object) null) ? "https://image.tmdb.org/t/p/original/" + link : link;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.lagradost.cloudstream3.ErrorLoadingException */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) throws ErrorLoadingException {
        C00001 c00001;
        MainPageRequest request2;
        String type;
        Object safe;
        Iterable results;
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
                String adultQuery = MainAPI.Companion.getSettingsForProvider().getEnableAdult() ? "" : "&without_keywords=190370|13059|226161|195669|190370";
                String type2 = StringsKt.contains$default(request.getData(), "/movie", false, 2, (Object) null) ? "movie" : "tv";
                Requests app = MainActivityKt.getApp();
                String str = request.getData() + adultQuery + "&page=" + page;
                c00001.L$0 = request;
                c00001.L$1 = SpillingKt.nullOutSpilledVariable(adultQuery);
                c00001.L$2 = type2;
                c00001.I$0 = page;
                c00001.label = 1;
                String type3 = type2;
                $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00001, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                request2 = request;
                type = type3;
                break;
                break;
            case 1:
                int i = c00001.I$0;
                type = (String) c00001.L$2;
                request2 = (MainPageRequest) c00001.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NiceResponse this_$iv = (NiceResponse) $result;
        try {
            ResponseParser parser = this_$iv.getParser();
            Intrinsics.checkNotNull(parser);
            safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(Results.class));
        } catch (Exception e$iv) {
            e$iv.printStackTrace();
            safe = null;
        }
        Results results2 = (Results) safe;
        if (results2 == null || (results = results2.getResults()) == null) {
            throw new ErrorLoadingException("Invalid Json reponse");
        }
        Iterable $this$mapNotNull$iv = results;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Iterable $this$mapNotNull$iv2 = $this$mapNotNull$iv;
            Media media = (Media) element$iv$iv$iv;
            SearchResponse searchResponse = toSearchResponse(media, type);
            if (searchResponse != null) {
                destination$iv$iv.add(searchResponse);
            }
            $this$mapNotNull$iv = $this$mapNotNull$iv2;
        }
        List home = (List) destination$iv$iv;
        return MainAPIKt.newHomePageResponse$default(request2.getName(), home, (Boolean) null, 4, (Object) null);
    }

    static /* synthetic */ SearchResponse toSearchResponse$default(StremioAddon stremioAddon, Media media, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return stremioAddon.toSearchResponse(media, str);
    }

    private final SearchResponse toSearchResponse(final Media $this$toSearchResponse, String type) {
        MainAPI mainAPI = (MainAPI) this;
        String title = $this$toSearchResponse.getTitle();
        if (title == null && (title = $this$toSearchResponse.getName()) == null && (title = $this$toSearchResponse.getOriginalTitle()) == null) {
            return null;
        }
        AppUtils appUtils = AppUtils.INSTANCE;
        Integer id = $this$toSearchResponse.getId();
        String mediaType = $this$toSearchResponse.getMediaType();
        if (mediaType == null) {
            mediaType = type;
        }
        return MainAPIKt.newMovieSearchResponse$default(mainAPI, title, appUtils.toJson(new Data(id, mediaType, null, null, 12, null)), TvType.Movie, false, new Function1() { // from class: com.phisher98.StremioAddon$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return StremioAddon.toSearchResponse$lambda$0(this.f$0, $this$toSearchResponse, (MovieSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResponse$lambda$0(StremioAddon this$0, Media $this_toSearchResponse, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl(this$0.getImageUrl($this_toSearchResponse.getPosterPath(), "https://files.catbox.moe/90n81c.jpg"));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Nullable
    public Object quickSearch(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        C00091 c00091;
        Object objSearch;
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
        Object $result = c00091.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00091.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                c00091.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00091.label = 1;
                objSearch = search(query, 1, c00091);
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
    public Object search(@NotNull String query, int page, @NotNull Continuation<? super SearchResponseList> continuation) {
        C00101 c00101;
        int page2;
        Object safe;
        Iterable results;
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
        Object $result = c00101.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00101.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                String str = "https://api.themoviedb.org/3/search/multi?api_key=98ae14df2b8d8f8f8136499daf79f0e0&language=en-US&query=" + query + "&page=" + page + "&include_adult=" + MainAPI.Companion.getSettingsForProvider().getEnableAdult();
                c00101.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00101.I$0 = page;
                c00101.label = 1;
                $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00101, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                page2 = page;
                break;
                break;
            case 1:
                int page3 = c00101.I$0;
                ResultKt.throwOnFailure($result);
                page2 = page3;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NiceResponse this_$iv = (NiceResponse) $result;
        try {
            ResponseParser parser = this_$iv.getParser();
            Intrinsics.checkNotNull(parser);
            safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(Results.class));
        } catch (Exception e$iv) {
            e$iv.printStackTrace();
            safe = null;
        }
        Results results2 = (Results) safe;
        if (results2 == null || (results = results2.getResults()) == null) {
            return null;
        }
        Iterable $this$mapNotNull$iv = results;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Media media = (Media) element$iv$iv$iv;
            int page4 = page2;
            SearchResponse searchResponse$default = toSearchResponse$default(this, media, null, 1, null);
            if (searchResponse$default != null) {
                destination$iv$iv.add(searchResponse$default);
            }
            page2 = page4;
        }
        return MainAPIKt.toNewSearchResponseList$default((List) destination$iv$iv, (Boolean) null, 1, (Object) null);
    }

    /* JADX WARN: Code duplicated, block: B:184:0x0762  */
    /* JADX WARN: Code duplicated, block: B:186:0x0837 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:187:0x0838  */
    /* JADX WARN: Code duplicated, block: B:204:0x088d  */
    /* JADX WARN: Code duplicated, block: B:215:0x0920  */
    /* JADX WARN: Code duplicated, block: B:218:0x092e  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:187:0x0838 -> B:188:0x0858). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object load(@org.jetbrains.annotations.NotNull java.lang.String r56, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r57) {
        /*
            Method dump skipped, instruction units count: 2974
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.StremioAddon.load(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$6$0$0(Episodes $eps, StremioAddon this$0, Episode $this$newEpisode) {
        $this$newEpisode.setName($eps.getName() + (StremioAddonUtilsKt.isUpcoming($eps.getAirDate()) ? " • [UPCOMING]" : ""));
        $this$newEpisode.setSeason($eps.getSeasonNumber());
        $this$newEpisode.setEpisode($eps.getEpisodeNumber());
        $this$newEpisode.setPosterUrl(this$0.getImageUrl($eps.getStillPath(), "https://files.catbox.moe/qbz6xd.jpg"));
        $this$newEpisode.setScore(Score.Companion.from10($eps.getVoteAverage()));
        $this$newEpisode.setDescription($eps.getOverview());
        $this$newEpisode.setRunTime($eps.getRuntime());
        MainAPIKt.addDate$default($this$newEpisode, $eps.getAirDate(), (String) null, 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.phisher98.StremioAddon$load$2 */
    /* JADX INFO: compiled from: StremioAddon.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StremioAddon$load$2", f = "StremioAddon.kt", i = {0}, l = {226}, m = "invokeSuspend", n = {"$this$newTvSeriesLoadResponse"}, nl = {227}, s = {"L$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nStremioAddon.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StremioAddon.kt\ncom/phisher98/StremioAddon$load$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,528:1\n1#2:529\n*E\n"})
    static final class C00032 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<ActorData> $actors;
        final /* synthetic */ String $bgPoster;
        final /* synthetic */ List<String> $genres;
        final /* synthetic */ List<String> $keywords;
        final /* synthetic */ String $logoUrl;
        final /* synthetic */ String $poster;
        final /* synthetic */ List<SearchResponse> $recommendations;
        final /* synthetic */ MediaDetail $res;
        final /* synthetic */ String $trailer;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00032(String str, String str2, String str3, Integer num, MediaDetail mediaDetail, List<String> list, List<String> list2, List<? extends SearchResponse> list3, List<ActorData> list4, String str4, Continuation<? super C00032> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$bgPoster = str2;
            this.$logoUrl = str3;
            this.$year = num;
            this.$res = mediaDetail;
            this.$keywords = list;
            this.$genres = list2;
            this.$recommendations = list3;
            this.$actors = list4;
            this.$trailer = str4;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00032 = new C00032(this.$poster, this.$bgPoster, this.$logoUrl, this.$year, this.$res, this.$keywords, this.$genres, this.$recommendations, this.$actors, this.$trailer, continuation);
            c00032.L$0 = obj;
            return c00032;
        }

        public final Object invoke(TvSeriesLoadResponse tvSeriesLoadResponse, Continuation<? super Unit> continuation) {
            return create(tvSeriesLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            LoadResponse loadResponse = (TvSeriesLoadResponse) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    loadResponse.setPosterUrl(this.$poster);
                    loadResponse.setBackgroundPosterUrl(this.$bgPoster);
                    try {
                        loadResponse.setLogoUrl(this.$logoUrl);
                        break;
                    } catch (Throwable th) {
                    }
                    loadResponse.setYear(this.$year);
                    loadResponse.setPlot(this.$res.getOverview());
                    List<String> list = this.$keywords;
                    List<String> list2 = list;
                    if (list2 == null || list2.isEmpty()) {
                        list = null;
                    }
                    if (list == null) {
                        list = this.$genres;
                    }
                    loadResponse.setTags(list);
                    loadResponse.setScore(Score.Companion.from10(String.valueOf(this.$res.getVote_average())));
                    loadResponse.setShowStatus(StremioAddon.INSTANCE.getStatus(this.$res.getStatus()));
                    loadResponse.setRecommendations(this.$recommendations);
                    loadResponse.setActors(this.$actors);
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
            ExternalIds external_ids = this.$res.getExternal_ids();
            companion.addImdbId(loadResponse2, external_ids != null ? external_ids.getImdb_id() : null);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StremioAddon$load$3 */
    /* JADX INFO: compiled from: StremioAddon.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StremioAddon$load$3", f = "StremioAddon.kt", i = {0}, l = {248}, m = "invokeSuspend", n = {"$this$newMovieLoadResponse"}, nl = {249}, s = {"L$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nStremioAddon.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StremioAddon.kt\ncom/phisher98/StremioAddon$load$3\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,528:1\n1#2:529\n*E\n"})
    static final class C00043 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<ActorData> $actors;
        final /* synthetic */ String $bgPoster;
        final /* synthetic */ List<String> $genres;
        final /* synthetic */ List<String> $keywords;
        final /* synthetic */ String $logoUrl;
        final /* synthetic */ String $poster;
        final /* synthetic */ List<SearchResponse> $recommendations;
        final /* synthetic */ String $releaseDate;
        final /* synthetic */ MediaDetail $res;
        final /* synthetic */ String $trailer;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00043(String str, String str2, String str3, String str4, Integer num, MediaDetail mediaDetail, List<String> list, List<String> list2, List<? extends SearchResponse> list3, List<ActorData> list4, String str5, Continuation<? super C00043> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$logoUrl = str2;
            this.$releaseDate = str3;
            this.$bgPoster = str4;
            this.$year = num;
            this.$res = mediaDetail;
            this.$keywords = list;
            this.$genres = list2;
            this.$recommendations = list3;
            this.$actors = list4;
            this.$trailer = str5;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00043 = new C00043(this.$poster, this.$logoUrl, this.$releaseDate, this.$bgPoster, this.$year, this.$res, this.$keywords, this.$genres, this.$recommendations, this.$actors, this.$trailer, continuation);
            c00043.L$0 = obj;
            return c00043;
        }

        public final Object invoke(MovieLoadResponse movieLoadResponse, Continuation<? super Unit> continuation) {
            return create(movieLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            LoadResponse loadResponse = (MovieLoadResponse) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    loadResponse.setPosterUrl(this.$poster);
                    try {
                        loadResponse.setLogoUrl(this.$logoUrl);
                        break;
                    } catch (Throwable th) {
                    }
                    loadResponse.setComingSoon(StremioAddonUtilsKt.isUpcoming(this.$releaseDate));
                    loadResponse.setBackgroundPosterUrl(this.$bgPoster);
                    loadResponse.setYear(this.$year);
                    loadResponse.setPlot(this.$res.getOverview());
                    loadResponse.setDuration(this.$res.getRuntime());
                    List<String> list = this.$keywords;
                    List<String> list2 = list;
                    if (list2 == null || list2.isEmpty()) {
                        list = null;
                    }
                    if (list == null) {
                        list = this.$genres;
                    }
                    loadResponse.setTags(list);
                    loadResponse.setScore(Score.Companion.from10(String.valueOf(this.$res.getVote_average())));
                    loadResponse.setRecommendations(this.$recommendations);
                    loadResponse.setActors(this.$actors);
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
            ExternalIds external_ids = this.$res.getExternal_ids();
            companion.addImdbId(loadResponse2, external_ids != null ? external_ids.getImdb_id() : null);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00051 c00051;
        StremioAddon stremioAddon;
        Object obj;
        Object objDecodeFromString;
        if (continuation instanceof C00051) {
            c00051 = (C00051) continuation;
            if ((c00051.label & Integer.MIN_VALUE) != 0) {
                c00051.label -= Integer.MIN_VALUE;
                stremioAddon = this;
            } else {
                stremioAddon = this;
                c00051 = stremioAddon.new C00051(continuation);
            }
        } else {
            stremioAddon = this;
            c00051 = stremioAddon.new C00051(continuation);
        }
        C00051 c00052 = c00051;
        Object $result = c00052.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00052.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                AppUtils appUtils = AppUtils.INSTANCE;
                try {
                    Result.Companion companion = Result.Companion;
                    KType kTypeTypeOf = Reflection.typeOf(LoadData.class);
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                if (Result.exceptionOrNull-impl(obj) != null) {
                    try {
                        Result.Companion companion3 = Result.Companion;
                        obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(LoadData.class), (List) null, 2, (Object) null));
                    } catch (Throwable th2) {
                        Result.Companion companion4 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th2));
                    }
                }
                if (Result.isFailure-impl(obj)) {
                    obj = null;
                }
                DeserializationStrategy deserializationStrategy = (KSerializer) obj;
                if (deserializationStrategy != null) {
                    try {
                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, data);
                    } catch (SerializationException e) {
                        ArchComponentExtKt.logError(e);
                        ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv.readValue(data, new TypeReference<LoadData>() { // from class: com.phisher98.StremioAddon$loadLinks$$inlined$parseJson$1
                        });
                    } catch (Throwable th3) {
                        ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv2.readValue(data, new TypeReference<LoadData>() { // from class: com.phisher98.StremioAddon$loadLinks$$inlined$parseJson$1
                        });
                    }
                } else {
                    ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv3.readValue(data, new TypeReference<LoadData>() { // from class: com.phisher98.StremioAddon$loadLinks$$inlined$parseJson$1
                    });
                }
                LoadData res = (LoadData) objDecodeFromString;
                Function1[] function1Arr = {stremioAddon.new C00062(res, function1, function2, null), new C00073(res, function1, null), new C00084(res, function1, null)};
                c00052.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00052.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                c00052.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                c00052.L$3 = SpillingKt.nullOutSpilledVariable(res);
                c00052.Z$0 = isCasting;
                c00052.label = 1;
                if (ParCollectionsKt.runAllAsync(function1Arr, c00052) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                boolean z = c00052.Z$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Boxing.boxBoolean(true);
    }

    /* JADX INFO: renamed from: com.phisher98.StremioAddon$loadLinks$2 */
    /* JADX INFO: compiled from: StremioAddon.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StremioAddon$loadLinks$2", f = "StremioAddon.kt", i = {}, l = {263}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    static final class C00062 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ LoadData $res;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00062(LoadData loadData, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super C00062> continuation) {
            super(1, continuation);
            this.$res = loadData;
            this.$subtitleCallback = function1;
            this.$callback = function2;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return StremioAddon.this.new C00062(this.$res, this.$subtitleCallback, this.$callback, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (StremioAddon.this.invokeMainSource(this.$res.getImdbId(), this.$res.getSeason(), this.$res.getEpisode(), this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.phisher98.StremioAddon$loadLinks$3 */
    /* JADX INFO: compiled from: StremioAddon.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StremioAddon$loadLinks$3", f = "StremioAddon.kt", i = {}, l = {264}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    static final class C00073 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ LoadData $res;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00073(LoadData loadData, Function1<? super SubtitleFile, Unit> function1, Continuation<? super C00073> continuation) {
            super(1, continuation);
            this.$res = loadData;
            this.$subtitleCallback = function1;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00073(this.$res, this.$subtitleCallback, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (SubsExtractors.INSTANCE.invokeWatchsomuch(this.$res.getImdbId(), this.$res.getSeason(), this.$res.getEpisode(), this.$subtitleCallback, (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.phisher98.StremioAddon$loadLinks$4 */
    /* JADX INFO: compiled from: StremioAddon.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StremioAddon$loadLinks$4", f = "StremioAddon.kt", i = {}, l = {265}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    static final class C00084 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ LoadData $res;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00084(LoadData loadData, Function1<? super SubtitleFile, Unit> function1, Continuation<? super C00084> continuation) {
            super(1, continuation);
            this.$res = loadData;
            this.$subtitleCallback = function1;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00084(this.$res, this.$subtitleCallback, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (SubsExtractors.INSTANCE.invokeOpenSubs(this.$res.getImdbId(), this.$res.getSeason(), this.$res.getEpisode(), this.$subtitleCallback, (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:100:0x03ae  */
    /* JADX WARN: Code duplicated, block: B:103:0x03ca  */
    /* JADX WARN: Code duplicated, block: B:107:0x01ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:29:0x011a  */
    /* JADX WARN: Code duplicated, block: B:31:0x012b  */
    /* JADX WARN: Code duplicated, block: B:32:0x0130  */
    /* JADX WARN: Code duplicated, block: B:35:0x0139  */
    /* JADX WARN: Code duplicated, block: B:39:0x0143  */
    /* JADX WARN: Code duplicated, block: B:41:0x0147  */
    /* JADX WARN: Code duplicated, block: B:43:0x014c  */
    /* JADX WARN: Code duplicated, block: B:44:0x016e  */
    /* JADX WARN: Code duplicated, block: B:51:0x0204 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:52:0x0205  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:96:0x0369  */
    /* JADX WARN: Code duplicated, block: B:99:0x0387  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:90:0x0315 -> B:91:0x032d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:96:0x0369 -> B:97:0x0380). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    public final java.lang.Object invokeMainSource(java.lang.String r35, java.lang.Integer r36, java.lang.Integer r37, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r38, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r39, kotlin.coroutines.Continuation<? super kotlin.Unit> r40) {
        /*
            Method dump skipped, instruction units count: 1000
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.StremioAddon.invokeMainSource(java.lang.String, java.lang.Integer, java.lang.Integer, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object invokeMainSource$default(StremioAddon stremioAddon, String str, Integer num, Integer num2, Function1 function1, Function1 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            num2 = null;
        }
        return stremioAddon.invokeMainSource(str, num, num2, function1, function2, continuation);
    }

    /* JADX INFO: compiled from: StremioAddon.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/phisher98/StremioAddon$StreamsResponse;", "", "streams", "", "Lcom/phisher98/StremioAddon$Stream;", "<init>", "(Ljava/util/List;)V", "getStreams", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "StremioAddon"}, k = 1, mv = {2, 4, 0}, xi = 48)
    private static final /* data */ class StreamsResponse {

        @NotNull
        private final List<Stream> streams;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StreamsResponse copy$default(StreamsResponse streamsResponse, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = streamsResponse.streams;
            }
            return streamsResponse.copy(list);
        }

        @NotNull
        public final List<Stream> component1() {
            return this.streams;
        }

        @NotNull
        public final StreamsResponse copy(@NotNull List<Stream> streams) {
            return new StreamsResponse(streams);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof StreamsResponse) && Intrinsics.areEqual(this.streams, ((StreamsResponse) other).streams);
        }

        public int hashCode() {
            return this.streams.hashCode();
        }

        @NotNull
        public String toString() {
            return "StreamsResponse(streams=" + this.streams + ')';
        }

        public StreamsResponse(@NotNull List<Stream> list) {
            this.streams = list;
        }

        @NotNull
        public final List<Stream> getStreams() {
            return this.streams;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: StremioAddon.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/phisher98/StremioAddon$Subtitle;", "", "url", "", "lang", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getLang", "getId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "StremioAddon"}, k = 1, mv = {2, 4, 0}, xi = 48)
    static final /* data */ class Subtitle {

        @Nullable
        private final String id;

        @Nullable
        private final String lang;

        @Nullable
        private final String url;

        public static /* synthetic */ Subtitle copy$default(Subtitle subtitle, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = subtitle.url;
            }
            if ((i & 2) != 0) {
                str2 = subtitle.lang;
            }
            if ((i & 4) != 0) {
                str3 = subtitle.id;
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
        public final String getLang() {
            return this.lang;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @NotNull
        public final Subtitle copy(@Nullable String url, @Nullable String lang, @Nullable String id) {
            return new Subtitle(url, lang, id);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Subtitle)) {
                return false;
            }
            Subtitle subtitle = (Subtitle) other;
            return Intrinsics.areEqual(this.url, subtitle.url) && Intrinsics.areEqual(this.lang, subtitle.lang) && Intrinsics.areEqual(this.id, subtitle.id);
        }

        public int hashCode() {
            return ((((this.url == null ? 0 : this.url.hashCode()) * 31) + (this.lang == null ? 0 : this.lang.hashCode())) * 31) + (this.id != null ? this.id.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Subtitle(url=" + this.url + ", lang=" + this.lang + ", id=" + this.id + ')';
        }

        public Subtitle(@Nullable String url, @Nullable String lang, @Nullable String id) {
            this.url = url;
            this.lang = lang;
            this.id = id;
        }

        @Nullable
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        public final String getLang() {
            return this.lang;
        }

        @Nullable
        public final String getId() {
            return this.id;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: StremioAddon.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\n\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0004HÖ\u0081\u0004R\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/phisher98/StremioAddon$ProxyHeaders;", "", "request", "", "", "<init>", "(Ljava/util/Map;)V", "getRequest", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "StremioAddon"}, k = 1, mv = {2, 4, 0}, xi = 48)
    static final /* data */ class ProxyHeaders {

        @Nullable
        private final Map<String, String> request;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ProxyHeaders copy$default(ProxyHeaders proxyHeaders, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                map = proxyHeaders.request;
            }
            return proxyHeaders.copy(map);
        }

        @Nullable
        public final Map<String, String> component1() {
            return this.request;
        }

        @NotNull
        public final ProxyHeaders copy(@Nullable Map<String, String> request) {
            return new ProxyHeaders(request);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ProxyHeaders) && Intrinsics.areEqual(this.request, ((ProxyHeaders) other).request);
        }

        public int hashCode() {
            if (this.request == null) {
                return 0;
            }
            return this.request.hashCode();
        }

        @NotNull
        public String toString() {
            return "ProxyHeaders(request=" + this.request + ')';
        }

        public ProxyHeaders(@Nullable Map<String, String> map) {
            this.request = map;
        }

        @Nullable
        public final Map<String, String> getRequest() {
            return this.request;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: StremioAddon.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0006HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/phisher98/StremioAddon$BehaviorHints;", "", "proxyHeaders", "Lcom/phisher98/StremioAddon$ProxyHeaders;", "headers", "", "", "<init>", "(Lcom/phisher98/StremioAddon$ProxyHeaders;Ljava/util/Map;)V", "getProxyHeaders", "()Lcom/phisher98/StremioAddon$ProxyHeaders;", "getHeaders", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "StremioAddon"}, k = 1, mv = {2, 4, 0}, xi = 48)
    static final /* data */ class BehaviorHints {

        @Nullable
        private final Map<String, String> headers;

        @Nullable
        private final ProxyHeaders proxyHeaders;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ BehaviorHints copy$default(BehaviorHints behaviorHints, ProxyHeaders proxyHeaders, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                proxyHeaders = behaviorHints.proxyHeaders;
            }
            if ((i & 2) != 0) {
                map = behaviorHints.headers;
            }
            return behaviorHints.copy(proxyHeaders, map);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ProxyHeaders getProxyHeaders() {
            return this.proxyHeaders;
        }

        @Nullable
        public final Map<String, String> component2() {
            return this.headers;
        }

        @NotNull
        public final BehaviorHints copy(@Nullable ProxyHeaders proxyHeaders, @Nullable Map<String, String> headers) {
            return new BehaviorHints(proxyHeaders, headers);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BehaviorHints)) {
                return false;
            }
            BehaviorHints behaviorHints = (BehaviorHints) other;
            return Intrinsics.areEqual(this.proxyHeaders, behaviorHints.proxyHeaders) && Intrinsics.areEqual(this.headers, behaviorHints.headers);
        }

        public int hashCode() {
            return ((this.proxyHeaders == null ? 0 : this.proxyHeaders.hashCode()) * 31) + (this.headers != null ? this.headers.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "BehaviorHints(proxyHeaders=" + this.proxyHeaders + ", headers=" + this.headers + ')';
        }

        public BehaviorHints(@Nullable ProxyHeaders proxyHeaders, @Nullable Map<String, String> map) {
            this.proxyHeaders = proxyHeaders;
            this.headers = map;
        }

        @Nullable
        public final ProxyHeaders getProxyHeaders() {
            return this.proxyHeaders;
        }

        @Nullable
        public final Map<String, String> getHeaders() {
            return this.headers;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: StremioAddon.kt */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001Bw\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0004\b\u0010\u0010\u0011J6\u0010\u001f\u001a\u00020 2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020 0\"2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020 0\"H\u0086@¢\u0006\u0002\u0010&J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00030\rHÆ\u0003J\u000f\u00100\u001a\b\u0012\u0004\u0012\u00020\u000f0\rHÆ\u0003J\u0089\u0001\u00101\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\rHÆ\u0001J\u0014\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00105\u001a\u000206HÖ\u0081\u0004J\n\u00107\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001d¨\u00068"}, d2 = {"Lcom/phisher98/StremioAddon$Stream;", "", "name", "", "title", "url", "description", "ytId", "externalUrl", "behaviorHints", "Lcom/phisher98/StremioAddon$BehaviorHints;", "infoHash", "sources", "", "subtitles", "Lcom/phisher98/StremioAddon$Subtitle;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/phisher98/StremioAddon$BehaviorHints;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "getTitle", "getUrl", "getDescription", "getYtId", "getExternalUrl", "getBehaviorHints", "()Lcom/phisher98/StremioAddon$BehaviorHints;", "getInfoHash", "getSources", "()Ljava/util/List;", "getSubtitles", "runCallback", "", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "", "toString", "StremioAddon"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nStremioAddon.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StremioAddon.kt\ncom/phisher98/StremioAddon$Stream\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,528:1\n788#2:529\n800#2:530\n2077#2,2:531\n801#2,2:533\n2079#2:535\n803#2:536\n777#2:537\n873#2,2:538\n777#2:540\n873#2,2:541\n777#2:543\n873#2,2:544\n*S KotlinDebug\n*F\n+ 1 StremioAddon.kt\ncom/phisher98/StremioAddon$Stream\n*L\n379#1:529\n379#1:530\n379#1:531,2\n379#1:533,2\n379#1:535\n379#1:536\n380#1:537\n380#1:538,2\n383#1:540\n383#1:541,2\n385#1:543\n385#1:544,2\n*E\n"})
    static final /* data */ class Stream {

        @Nullable
        private final BehaviorHints behaviorHints;

        @Nullable
        private final String description;

        @Nullable
        private final String externalUrl;

        @Nullable
        private final String infoHash;

        @Nullable
        private final String name;

        @NotNull
        private final List<String> sources;

        @NotNull
        private final List<Subtitle> subtitles;

        @Nullable
        private final String title;

        @Nullable
        private final String url;

        @Nullable
        private final String ytId;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Stream copy$default(Stream stream, String str, String str2, String str3, String str4, String str5, String str6, BehaviorHints behaviorHints, String str7, List list, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = stream.name;
            }
            if ((i & 2) != 0) {
                str2 = stream.title;
            }
            if ((i & 4) != 0) {
                str3 = stream.url;
            }
            if ((i & 8) != 0) {
                str4 = stream.description;
            }
            if ((i & 16) != 0) {
                str5 = stream.ytId;
            }
            if ((i & 32) != 0) {
                str6 = stream.externalUrl;
            }
            if ((i & 64) != 0) {
                behaviorHints = stream.behaviorHints;
            }
            if ((i & 128) != 0) {
                str7 = stream.infoHash;
            }
            if ((i & 256) != 0) {
                list = stream.sources;
            }
            if ((i & 512) != 0) {
                list2 = stream.subtitles;
            }
            List list3 = list;
            List list4 = list2;
            BehaviorHints behaviorHints2 = behaviorHints;
            String str8 = str7;
            String str9 = str5;
            String str10 = str6;
            return stream.copy(str, str2, str3, str4, str9, str10, behaviorHints2, str8, list3, list4);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @NotNull
        public final List<Subtitle> component10() {
            return this.subtitles;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getYtId() {
            return this.ytId;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getExternalUrl() {
            return this.externalUrl;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final BehaviorHints getBehaviorHints() {
            return this.behaviorHints;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getInfoHash() {
            return this.infoHash;
        }

        @NotNull
        public final List<String> component9() {
            return this.sources;
        }

        @NotNull
        public final Stream copy(@Nullable String name, @Nullable String title, @Nullable String url, @Nullable String description, @Nullable String ytId, @Nullable String externalUrl, @Nullable BehaviorHints behaviorHints, @Nullable String infoHash, @NotNull List<String> sources, @NotNull List<Subtitle> subtitles) {
            return new Stream(name, title, url, description, ytId, externalUrl, behaviorHints, infoHash, sources, subtitles);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Stream)) {
                return false;
            }
            Stream stream = (Stream) other;
            return Intrinsics.areEqual(this.name, stream.name) && Intrinsics.areEqual(this.title, stream.title) && Intrinsics.areEqual(this.url, stream.url) && Intrinsics.areEqual(this.description, stream.description) && Intrinsics.areEqual(this.ytId, stream.ytId) && Intrinsics.areEqual(this.externalUrl, stream.externalUrl) && Intrinsics.areEqual(this.behaviorHints, stream.behaviorHints) && Intrinsics.areEqual(this.infoHash, stream.infoHash) && Intrinsics.areEqual(this.sources, stream.sources) && Intrinsics.areEqual(this.subtitles, stream.subtitles);
        }

        public int hashCode() {
            return ((((((((((((((((((this.name == null ? 0 : this.name.hashCode()) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.url == null ? 0 : this.url.hashCode())) * 31) + (this.description == null ? 0 : this.description.hashCode())) * 31) + (this.ytId == null ? 0 : this.ytId.hashCode())) * 31) + (this.externalUrl == null ? 0 : this.externalUrl.hashCode())) * 31) + (this.behaviorHints == null ? 0 : this.behaviorHints.hashCode())) * 31) + (this.infoHash != null ? this.infoHash.hashCode() : 0)) * 31) + this.sources.hashCode()) * 31) + this.subtitles.hashCode();
        }

        @NotNull
        public String toString() {
            return "Stream(name=" + this.name + ", title=" + this.title + ", url=" + this.url + ", description=" + this.description + ", ytId=" + this.ytId + ", externalUrl=" + this.externalUrl + ", behaviorHints=" + this.behaviorHints + ", infoHash=" + this.infoHash + ", sources=" + this.sources + ", subtitles=" + this.subtitles + ')';
        }

        public Stream(@Nullable String name, @Nullable String title, @Nullable String url, @Nullable String description, @Nullable String ytId, @Nullable String externalUrl, @Nullable BehaviorHints behaviorHints, @Nullable String infoHash, @NotNull List<String> list, @NotNull List<Subtitle> list2) {
            this.name = name;
            this.title = title;
            this.url = url;
            this.description = description;
            this.ytId = ytId;
            this.externalUrl = externalUrl;
            this.behaviorHints = behaviorHints;
            this.infoHash = infoHash;
            this.sources = list;
            this.subtitles = list2;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ Stream(String str, String str2, String str3, String str4, String str5, String str6, BehaviorHints behaviorHints, String str7, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            List listEmptyList;
            List listEmptyList2;
            if ((i & 256) == 0) {
                listEmptyList = list;
            } else {
                listEmptyList = CollectionsKt.emptyList();
            }
            if ((i & 512) == 0) {
                listEmptyList2 = list2;
            } else {
                listEmptyList2 = CollectionsKt.emptyList();
            }
            this(str, str2, str3, str4, str5, str6, behaviorHints, str7, listEmptyList, listEmptyList2);
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
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        public final String getYtId() {
            return this.ytId;
        }

        @Nullable
        public final String getExternalUrl() {
            return this.externalUrl;
        }

        @Nullable
        public final BehaviorHints getBehaviorHints() {
            return this.behaviorHints;
        }

        @Nullable
        public final String getInfoHash() {
            return this.infoHash;
        }

        @NotNull
        public final List<String> getSources() {
            return this.sources;
        }

        @NotNull
        public final List<Subtitle> getSubtitles() {
            return this.subtitles;
        }

        /* JADX WARN: Code duplicated, block: B:100:0x0367  */
        /* JADX WARN: Code duplicated, block: B:103:0x036d  */
        /* JADX WARN: Code duplicated, block: B:108:0x03af A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:109:0x03b0  */
        /* JADX WARN: Code duplicated, block: B:111:0x03be  */
        /* JADX WARN: Code duplicated, block: B:114:0x031e A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:117:0x02fe A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:123:0x0260 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:125:0x0244 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:129:0x02b6 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:30:0x0130 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:31:0x0131  */
        /* JADX WARN: Code duplicated, block: B:36:0x0139  */
        /* JADX WARN: Code duplicated, block: B:38:0x015b A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:39:0x015c  */
        /* JADX WARN: Code duplicated, block: B:41:0x015e  */
        /* JADX WARN: Code duplicated, block: B:44:0x0163  */
        /* JADX WARN: Code duplicated, block: B:46:0x0176 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:48:0x017a  */
        /* JADX WARN: Code duplicated, block: B:51:0x0180  */
        /* JADX WARN: Code duplicated, block: B:53:0x01c9 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:54:0x01ca  */
        /* JADX WARN: Code duplicated, block: B:58:0x01fe  */
        /* JADX WARN: Code duplicated, block: B:60:0x0206  */
        /* JADX WARN: Code duplicated, block: B:63:0x0219  */
        /* JADX WARN: Code duplicated, block: B:64:0x021c  */
        /* JADX WARN: Code duplicated, block: B:66:0x0220  */
        /* JADX WARN: Code duplicated, block: B:67:0x0226  */
        /* JADX WARN: Code duplicated, block: B:72:0x024a  */
        /* JADX WARN: Code duplicated, block: B:74:0x025b  */
        /* JADX WARN: Code duplicated, block: B:75:0x025d  */
        /* JADX WARN: Code duplicated, block: B:7:0x001a  */
        /* JADX WARN: Code duplicated, block: B:81:0x029b  */
        /* JADX WARN: Code duplicated, block: B:83:0x02b3  */
        /* JADX WARN: Code duplicated, block: B:87:0x02e8 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:88:0x02e9  */
        /* JADX WARN: Code duplicated, block: B:92:0x0304  */
        /* JADX WARN: Code duplicated, block: B:94:0x0317  */
        /* JADX WARN: Code duplicated, block: B:95:0x031a  */
        @Nullable
        public final Object runCallback(@NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
            StremioAddon$Stream$runCallback$1 stremioAddon$Stream$runCallback$1;
            Function1<? super SubtitleFile, Unit> function3;
            Object obj;
            Function1<? super ExtractorLink, Unit> function4;
            List<Subtitle> list;
            StremioAddon$Stream$runCallback$3 stremioAddon$Stream$runCallback$3;
            Function1<? super SubtitleFile, Unit> function5;
            String str;
            Function1<? super SubtitleFile, Unit> function6;
            String str2;
            Function1<? super ExtractorLink, Unit> function7;
            Object obj2;
            Continuation continuation2;
            Object obj3;
            Object obj4;
            Function1<? super ExtractorLink, Unit> function8;
            String resp;
            Collection destination$iv$iv;
            int index$iv$iv;
            Collection destination$iv$iv2;
            String otherTrackers;
            Iterable $this$filter$iv;
            int $i$f$filter;
            Collection destination$iv$iv3;
            String resp2;
            Object objAmap;
            String resp3;
            String otherTrackers2;
            Function1<? super ExtractorLink, Unit> function9;
            String it;
            String s;
            boolean z;
            int i;
            int i2;
            Collection destination$iv$iv4;
            String str3;
            String str4;
            Function1<? super ExtractorLink, Unit> function10;
            Function1<? super SubtitleFile, Unit> function11;
            String s2;
            boolean z2;
            Function1<? super ExtractorLink, Unit> function12 = function2;
            if (continuation instanceof StremioAddon$Stream$runCallback$1) {
                stremioAddon$Stream$runCallback$1 = (StremioAddon$Stream$runCallback$1) continuation;
                if ((stremioAddon$Stream$runCallback$1.label & Integer.MIN_VALUE) != 0) {
                    stremioAddon$Stream$runCallback$1.label -= Integer.MIN_VALUE;
                } else {
                    stremioAddon$Stream$runCallback$1 = new StremioAddon$Stream$runCallback$1(this, continuation);
                }
            } else {
                stremioAddon$Stream$runCallback$1 = new StremioAddon$Stream$runCallback$1(this, continuation);
            }
            StremioAddon$Stream$runCallback$1 stremioAddon$Stream$runCallback$2 = stremioAddon$Stream$runCallback$1;
            Object $result = stremioAddon$Stream$runCallback$2.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (stremioAddon$Stream$runCallback$2.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    if (this.url != null) {
                        String str5 = this.name;
                        if (str5 == null) {
                            str5 = "";
                        }
                        String strFixSourceName = StremioAddonUtilsKt.fixSourceName(this.name, this.title, this.description);
                        String str6 = this.url;
                        ExtractorLinkType infer_type = ExtractorApiKt.getINFER_TYPE();
                        StremioAddon$Stream$runCallback$2 stremioAddon$Stream$runCallback$4 = new StremioAddon$Stream$runCallback$2(this, null);
                        function3 = function1;
                        stremioAddon$Stream$runCallback$2.L$0 = function3;
                        stremioAddon$Stream$runCallback$2.L$1 = function12;
                        stremioAddon$Stream$runCallback$2.L$2 = function12;
                        stremioAddon$Stream$runCallback$2.label = 1;
                        Object objNewExtractorLink = ExtractorApiKt.newExtractorLink(str5, strFixSourceName, str6, infer_type, stremioAddon$Stream$runCallback$4, stremioAddon$Stream$runCallback$2);
                        if (objNewExtractorLink == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj = objNewExtractorLink;
                        function4 = function12;
                        function12.invoke(obj);
                        list = this.subtitles;
                        stremioAddon$Stream$runCallback$3 = new StremioAddon$Stream$runCallback$3(function3, null);
                        stremioAddon$Stream$runCallback$2.L$0 = function3;
                        stremioAddon$Stream$runCallback$2.L$1 = function4;
                        stremioAddon$Stream$runCallback$2.L$2 = null;
                        stremioAddon$Stream$runCallback$2.label = 2;
                        if (ParCollectionsKt.amap(list, stremioAddon$Stream$runCallback$3, stremioAddon$Stream$runCallback$2) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function12 = function4;
                    } else {
                        function3 = function1;
                    }
                    if (this.ytId != null) {
                        str = "https://www.youtube.com/watch?v=" + this.ytId;
                        stremioAddon$Stream$runCallback$2.L$0 = function3;
                        stremioAddon$Stream$runCallback$2.L$1 = function12;
                        stremioAddon$Stream$runCallback$2.label = 3;
                        if (ExtractorApiKt.loadExtractor(str, function3, function12, stremioAddon$Stream$runCallback$2) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function5 = function3;
                    } else {
                        function5 = function3;
                    }
                    if (this.externalUrl != null) {
                        str2 = this.externalUrl;
                        stremioAddon$Stream$runCallback$2.L$0 = SpillingKt.nullOutSpilledVariable(function5);
                        stremioAddon$Stream$runCallback$2.L$1 = function12;
                        stremioAddon$Stream$runCallback$2.label = 4;
                        if (ExtractorApiKt.loadExtractor(str2, function5, function12, stremioAddon$Stream$runCallback$2) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function6 = function5;
                    } else {
                        function6 = function5;
                    }
                    if (this.infoHash != null) {
                        Requests app = MainActivityKt.getApp();
                        stremioAddon$Stream$runCallback$2.L$0 = SpillingKt.nullOutSpilledVariable(function6);
                        stremioAddon$Stream$runCallback$2.L$1 = function12;
                        stremioAddon$Stream$runCallback$2.label = 5;
                        function7 = function12;
                        obj2 = coroutine_suspended;
                        continuation2 = null;
                        obj3 = Requests.get$default(app, StremioAddon.TRACKER_LIST_URL, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, stremioAddon$Stream$runCallback$2, 4094, (Object) null);
                        if (obj3 == obj2) {
                            stremioAddon$Stream$runCallback$2 = stremioAddon$Stream$runCallback$2;
                            return obj2;
                        }
                        stremioAddon$Stream$runCallback$2 = stremioAddon$Stream$runCallback$2;
                        obj4 = obj3;
                        function8 = function7;
                        resp = ((NiceResponse) obj4).getText();
                        Iterable $this$filterIndexed$iv = StringsKt.split$default(resp, new String[]{"\n"}, false, 0, 6, (Object) null);
                        destination$iv$iv = new ArrayList();
                        index$iv$iv = 0;
                        for (Object item$iv$iv$iv : $this$filterIndexed$iv) {
                            int index$iv$iv$iv = index$iv$iv + 1;
                            if (index$iv$iv < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            i = index$iv$iv;
                            if (i % 2 == 0) {
                                i2 = 1;
                            } else {
                                i2 = 0;
                            }
                            if (i2 != 0) {
                                destination$iv$iv.add(item$iv$iv$iv);
                            }
                            index$iv$iv = index$iv$iv$iv;
                        }
                        destination$iv$iv2 = new ArrayList();
                        for (Object element$iv$iv : (List) destination$iv$iv) {
                            s = (String) element$iv$iv;
                            if (s.length() > 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                destination$iv$iv2.add(element$iv$iv);
                            }
                        }
                        otherTrackers = CollectionsKt.joinToString$default((List) destination$iv$iv2, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.phisher98.StremioAddon$Stream$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj5) {
                                return StremioAddon.Stream.runCallback$lambda$2((String) obj5);
                            }
                        }, 30, (Object) null);
                        $this$filter$iv = this.sources;
                        $i$f$filter = 0;
                        destination$iv$iv3 = new ArrayList();
                        for (Object element$iv$iv2 : $this$filter$iv) {
                            it = (String) element$iv$iv2;
                            String resp4 = resp;
                            Iterable $this$filter$iv2 = $this$filter$iv;
                            int $i$f$filter2 = $i$f$filter;
                            if (StringsKt.startsWith$default(it, "tracker:", false, 2, continuation2)) {
                                destination$iv$iv3.add(element$iv$iv2);
                            }
                            resp = resp4;
                            $this$filter$iv = $this$filter$iv2;
                            $i$f$filter = $i$f$filter2;
                        }
                        resp2 = resp;
                        StremioAddon$Stream$runCallback$sourceTrackers$2 stremioAddon$Stream$runCallback$sourceTrackers$2 = new StremioAddon$Stream$runCallback$sourceTrackers$2(continuation2);
                        stremioAddon$Stream$runCallback$2.L$0 = SpillingKt.nullOutSpilledVariable(function6);
                        stremioAddon$Stream$runCallback$2.L$1 = function8;
                        stremioAddon$Stream$runCallback$2.L$2 = SpillingKt.nullOutSpilledVariable(resp2);
                        stremioAddon$Stream$runCallback$2.L$3 = otherTrackers;
                        stremioAddon$Stream$runCallback$2.label = 6;
                        objAmap = ParCollectionsKt.amap((List) destination$iv$iv3, stremioAddon$Stream$runCallback$sourceTrackers$2, stremioAddon$Stream$runCallback$2);
                        if (objAmap == obj2) {
                            return obj2;
                        }
                        resp3 = resp2;
                        otherTrackers2 = otherTrackers;
                        function9 = function8;
                        destination$iv$iv4 = new ArrayList();
                        for (Object element$iv$iv3 : (Iterable) objAmap) {
                            s2 = (String) element$iv$iv3;
                            if (s2.length() > 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (z2) {
                                destination$iv$iv4.add(element$iv$iv3);
                            }
                        }
                        String sourceTrackers = CollectionsKt.joinToString$default((List) destination$iv$iv4, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.phisher98.StremioAddon$Stream$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj5) {
                                return StremioAddon.Stream.runCallback$lambda$5((String) obj5);
                            }
                        }, 30, (Object) null);
                        String magnet = "magnet:?xt=urn:btih:" + this.infoHash + sourceTrackers + otherTrackers2;
                        str3 = this.name;
                        if (str3 == null) {
                            str3 = "";
                        }
                        str4 = this.title;
                        if (str4 == null && (str4 = this.name) == null) {
                            str4 = "";
                        }
                        StremioAddon$Stream$runCallback$4 stremioAddon$Stream$runCallback$5 = new StremioAddon$Stream$runCallback$4(continuation2);
                        stremioAddon$Stream$runCallback$2.L$0 = SpillingKt.nullOutSpilledVariable(function6);
                        stremioAddon$Stream$runCallback$2.L$1 = SpillingKt.nullOutSpilledVariable(function9);
                        stremioAddon$Stream$runCallback$2.L$2 = SpillingKt.nullOutSpilledVariable(resp3);
                        stremioAddon$Stream$runCallback$2.L$3 = SpillingKt.nullOutSpilledVariable(otherTrackers2);
                        stremioAddon$Stream$runCallback$2.L$4 = SpillingKt.nullOutSpilledVariable(sourceTrackers);
                        stremioAddon$Stream$runCallback$2.L$5 = SpillingKt.nullOutSpilledVariable(magnet);
                        stremioAddon$Stream$runCallback$2.L$6 = function9;
                        stremioAddon$Stream$runCallback$2.label = 7;
                        $result = ExtractorApiKt.newExtractorLink$default(str3, str4, magnet, (ExtractorLinkType) null, stremioAddon$Stream$runCallback$5, stremioAddon$Stream$runCallback$2, 8, (Object) null);
                        if ($result == obj2) {
                            return obj2;
                        }
                        function10 = function9;
                        function11 = function6;
                        function10.invoke($result);
                    }
                    return Unit.INSTANCE;
                case 1:
                    Function1<? super ExtractorLink, Unit> function13 = (Function1) stremioAddon$Stream$runCallback$2.L$2;
                    Function1<? super ExtractorLink, Unit> function14 = (Function1) stremioAddon$Stream$runCallback$2.L$1;
                    Function1<? super SubtitleFile, Unit> function15 = (Function1) stremioAddon$Stream$runCallback$2.L$0;
                    ResultKt.throwOnFailure($result);
                    function4 = function14;
                    function12 = function13;
                    function3 = function15;
                    obj = $result;
                    function12.invoke(obj);
                    list = this.subtitles;
                    stremioAddon$Stream$runCallback$3 = new StremioAddon$Stream$runCallback$3(function3, null);
                    stremioAddon$Stream$runCallback$2.L$0 = function3;
                    stremioAddon$Stream$runCallback$2.L$1 = function4;
                    stremioAddon$Stream$runCallback$2.L$2 = null;
                    stremioAddon$Stream$runCallback$2.label = 2;
                    if (ParCollectionsKt.amap(list, stremioAddon$Stream$runCallback$3, stremioAddon$Stream$runCallback$2) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function12 = function4;
                    if (this.ytId != null) {
                        str = "https://www.youtube.com/watch?v=" + this.ytId;
                        stremioAddon$Stream$runCallback$2.L$0 = function3;
                        stremioAddon$Stream$runCallback$2.L$1 = function12;
                        stremioAddon$Stream$runCallback$2.label = 3;
                        if (ExtractorApiKt.loadExtractor(str, function3, function12, stremioAddon$Stream$runCallback$2) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function5 = function3;
                    } else {
                        function5 = function3;
                    }
                    if (this.externalUrl != null) {
                        str2 = this.externalUrl;
                        stremioAddon$Stream$runCallback$2.L$0 = SpillingKt.nullOutSpilledVariable(function5);
                        stremioAddon$Stream$runCallback$2.L$1 = function12;
                        stremioAddon$Stream$runCallback$2.label = 4;
                        if (ExtractorApiKt.loadExtractor(str2, function5, function12, stremioAddon$Stream$runCallback$2) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function6 = function5;
                    } else {
                        function6 = function5;
                    }
                    if (this.infoHash != null) {
                        Requests app2 = MainActivityKt.getApp();
                        stremioAddon$Stream$runCallback$2.L$0 = SpillingKt.nullOutSpilledVariable(function6);
                        stremioAddon$Stream$runCallback$2.L$1 = function12;
                        stremioAddon$Stream$runCallback$2.label = 5;
                        function7 = function12;
                        obj2 = coroutine_suspended;
                        continuation2 = null;
                        obj3 = Requests.get$default(app2, StremioAddon.TRACKER_LIST_URL, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, stremioAddon$Stream$runCallback$2, 4094, (Object) null);
                        if (obj3 == obj2) {
                            stremioAddon$Stream$runCallback$2 = stremioAddon$Stream$runCallback$2;
                            return obj2;
                        }
                        stremioAddon$Stream$runCallback$2 = stremioAddon$Stream$runCallback$2;
                        obj4 = obj3;
                        function8 = function7;
                        resp = ((NiceResponse) obj4).getText();
                        Iterable $this$filterIndexed$iv2 = StringsKt.split$default(resp, new String[]{"\n"}, false, 0, 6, (Object) null);
                        destination$iv$iv = new ArrayList();
                        index$iv$iv = 0;
                        while (r15.hasNext()) {
                            int index$iv$iv$iv2 = index$iv$iv + 1;
                            if (index$iv$iv < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            i = index$iv$iv;
                            if (i % 2 == 0) {
                                i2 = 1;
                            } else {
                                i2 = 0;
                            }
                            if (i2 != 0) {
                                destination$iv$iv.add(item$iv$iv$iv);
                            }
                            index$iv$iv = index$iv$iv$iv2;
                        }
                        destination$iv$iv2 = new ArrayList();
                        while (r11.hasNext()) {
                            s = (String) element$iv$iv;
                            if (s.length() > 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                destination$iv$iv2.add(element$iv$iv);
                            }
                        }
                        otherTrackers = CollectionsKt.joinToString$default((List) destination$iv$iv2, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.phisher98.StremioAddon$Stream$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj5) {
                                return StremioAddon.Stream.runCallback$lambda$2((String) obj5);
                            }
                        }, 30, (Object) null);
                        $this$filter$iv = this.sources;
                        $i$f$filter = 0;
                        destination$iv$iv3 = new ArrayList();
                        while (r12.hasNext()) {
                            it = (String) element$iv$iv2;
                            String resp5 = resp;
                            Iterable $this$filter$iv3 = $this$filter$iv;
                            int $i$f$filter3 = $i$f$filter;
                            if (StringsKt.startsWith$default(it, "tracker:", false, 2, continuation2)) {
                                destination$iv$iv3.add(element$iv$iv2);
                            }
                            resp = resp5;
                            $this$filter$iv = $this$filter$iv3;
                            $i$f$filter = $i$f$filter3;
                        }
                        resp2 = resp;
                        StremioAddon$Stream$runCallback$sourceTrackers$2 stremioAddon$Stream$runCallback$sourceTrackers$3 = new StremioAddon$Stream$runCallback$sourceTrackers$2(continuation2);
                        stremioAddon$Stream$runCallback$2.L$0 = SpillingKt.nullOutSpilledVariable(function6);
                        stremioAddon$Stream$runCallback$2.L$1 = function8;
                        stremioAddon$Stream$runCallback$2.L$2 = SpillingKt.nullOutSpilledVariable(resp2);
                        stremioAddon$Stream$runCallback$2.L$3 = otherTrackers;
                        stremioAddon$Stream$runCallback$2.label = 6;
                        objAmap = ParCollectionsKt.amap((List) destination$iv$iv3, stremioAddon$Stream$runCallback$sourceTrackers$3, stremioAddon$Stream$runCallback$2);
                        if (objAmap == obj2) {
                            return obj2;
                        }
                        resp3 = resp2;
                        otherTrackers2 = otherTrackers;
                        function9 = function8;
                        destination$iv$iv4 = new ArrayList();
                        while (r11.hasNext()) {
                            s2 = (String) element$iv$iv3;
                            if (s2.length() > 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (z2) {
                                destination$iv$iv4.add(element$iv$iv3);
                            }
                        }
                        String sourceTrackers2 = CollectionsKt.joinToString$default((List) destination$iv$iv4, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.phisher98.StremioAddon$Stream$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj5) {
                                return StremioAddon.Stream.runCallback$lambda$5((String) obj5);
                            }
                        }, 30, (Object) null);
                        String magnet2 = "magnet:?xt=urn:btih:" + this.infoHash + sourceTrackers2 + otherTrackers2;
                        str3 = this.name;
                        if (str3 == null) {
                            str3 = "";
                        }
                        str4 = this.title;
                        if (str4 == null) {
                            str4 = "";
                        }
                        StremioAddon$Stream$runCallback$4 stremioAddon$Stream$runCallback$6 = new StremioAddon$Stream$runCallback$4(continuation2);
                        stremioAddon$Stream$runCallback$2.L$0 = SpillingKt.nullOutSpilledVariable(function6);
                        stremioAddon$Stream$runCallback$2.L$1 = SpillingKt.nullOutSpilledVariable(function9);
                        stremioAddon$Stream$runCallback$2.L$2 = SpillingKt.nullOutSpilledVariable(resp3);
                        stremioAddon$Stream$runCallback$2.L$3 = SpillingKt.nullOutSpilledVariable(otherTrackers2);
                        stremioAddon$Stream$runCallback$2.L$4 = SpillingKt.nullOutSpilledVariable(sourceTrackers2);
                        stremioAddon$Stream$runCallback$2.L$5 = SpillingKt.nullOutSpilledVariable(magnet2);
                        stremioAddon$Stream$runCallback$2.L$6 = function9;
                        stremioAddon$Stream$runCallback$2.label = 7;
                        $result = ExtractorApiKt.newExtractorLink$default(str3, str4, magnet2, (ExtractorLinkType) null, stremioAddon$Stream$runCallback$6, stremioAddon$Stream$runCallback$2, 8, (Object) null);
                        if ($result == obj2) {
                            return obj2;
                        }
                        function10 = function9;
                        function11 = function6;
                        function10.invoke($result);
                    }
                    return Unit.INSTANCE;
                case 2:
                    function12 = (Function1) stremioAddon$Stream$runCallback$2.L$1;
                    Function1<? super SubtitleFile, Unit> function16 = (Function1) stremioAddon$Stream$runCallback$2.L$0;
                    ResultKt.throwOnFailure($result);
                    function3 = function16;
                    if (this.ytId != null) {
                        str = "https://www.youtube.com/watch?v=" + this.ytId;
                        stremioAddon$Stream$runCallback$2.L$0 = function3;
                        stremioAddon$Stream$runCallback$2.L$1 = function12;
                        stremioAddon$Stream$runCallback$2.label = 3;
                        if (ExtractorApiKt.loadExtractor(str, function3, function12, stremioAddon$Stream$runCallback$2) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function5 = function3;
                    } else {
                        function5 = function3;
                    }
                    if (this.externalUrl != null) {
                        str2 = this.externalUrl;
                        stremioAddon$Stream$runCallback$2.L$0 = SpillingKt.nullOutSpilledVariable(function5);
                        stremioAddon$Stream$runCallback$2.L$1 = function12;
                        stremioAddon$Stream$runCallback$2.label = 4;
                        if (ExtractorApiKt.loadExtractor(str2, function5, function12, stremioAddon$Stream$runCallback$2) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function6 = function5;
                    } else {
                        function6 = function5;
                    }
                    if (this.infoHash != null) {
                        Requests app3 = MainActivityKt.getApp();
                        stremioAddon$Stream$runCallback$2.L$0 = SpillingKt.nullOutSpilledVariable(function6);
                        stremioAddon$Stream$runCallback$2.L$1 = function12;
                        stremioAddon$Stream$runCallback$2.label = 5;
                        function7 = function12;
                        obj2 = coroutine_suspended;
                        continuation2 = null;
                        obj3 = Requests.get$default(app3, StremioAddon.TRACKER_LIST_URL, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, stremioAddon$Stream$runCallback$2, 4094, (Object) null);
                        if (obj3 == obj2) {
                            stremioAddon$Stream$runCallback$2 = stremioAddon$Stream$runCallback$2;
                            return obj2;
                        }
                        stremioAddon$Stream$runCallback$2 = stremioAddon$Stream$runCallback$2;
                        obj4 = obj3;
                        function8 = function7;
                        resp = ((NiceResponse) obj4).getText();
                        Iterable $this$filterIndexed$iv3 = StringsKt.split$default(resp, new String[]{"\n"}, false, 0, 6, (Object) null);
                        destination$iv$iv = new ArrayList();
                        index$iv$iv = 0;
                        while (r15.hasNext()) {
                            int index$iv$iv$iv3 = index$iv$iv + 1;
                            if (index$iv$iv < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            i = index$iv$iv;
                            if (i % 2 == 0) {
                                i2 = 1;
                            } else {
                                i2 = 0;
                            }
                            if (i2 != 0) {
                                destination$iv$iv.add(item$iv$iv$iv);
                            }
                            index$iv$iv = index$iv$iv$iv3;
                        }
                        destination$iv$iv2 = new ArrayList();
                        while (r11.hasNext()) {
                            s = (String) element$iv$iv;
                            if (s.length() > 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                destination$iv$iv2.add(element$iv$iv);
                            }
                        }
                        otherTrackers = CollectionsKt.joinToString$default((List) destination$iv$iv2, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.phisher98.StremioAddon$Stream$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj5) {
                                return StremioAddon.Stream.runCallback$lambda$2((String) obj5);
                            }
                        }, 30, (Object) null);
                        $this$filter$iv = this.sources;
                        $i$f$filter = 0;
                        destination$iv$iv3 = new ArrayList();
                        while (r12.hasNext()) {
                            it = (String) element$iv$iv2;
                            String resp6 = resp;
                            Iterable $this$filter$iv4 = $this$filter$iv;
                            int $i$f$filter4 = $i$f$filter;
                            if (StringsKt.startsWith$default(it, "tracker:", false, 2, continuation2)) {
                                destination$iv$iv3.add(element$iv$iv2);
                            }
                            resp = resp6;
                            $this$filter$iv = $this$filter$iv4;
                            $i$f$filter = $i$f$filter4;
                        }
                        resp2 = resp;
                        StremioAddon$Stream$runCallback$sourceTrackers$2 stremioAddon$Stream$runCallback$sourceTrackers$4 = new StremioAddon$Stream$runCallback$sourceTrackers$2(continuation2);
                        stremioAddon$Stream$runCallback$2.L$0 = SpillingKt.nullOutSpilledVariable(function6);
                        stremioAddon$Stream$runCallback$2.L$1 = function8;
                        stremioAddon$Stream$runCallback$2.L$2 = SpillingKt.nullOutSpilledVariable(resp2);
                        stremioAddon$Stream$runCallback$2.L$3 = otherTrackers;
                        stremioAddon$Stream$runCallback$2.label = 6;
                        objAmap = ParCollectionsKt.amap((List) destination$iv$iv3, stremioAddon$Stream$runCallback$sourceTrackers$4, stremioAddon$Stream$runCallback$2);
                        if (objAmap == obj2) {
                            return obj2;
                        }
                        resp3 = resp2;
                        otherTrackers2 = otherTrackers;
                        function9 = function8;
                        destination$iv$iv4 = new ArrayList();
                        while (r11.hasNext()) {
                            s2 = (String) element$iv$iv3;
                            if (s2.length() > 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (z2) {
                                destination$iv$iv4.add(element$iv$iv3);
                            }
                        }
                        String sourceTrackers3 = CollectionsKt.joinToString$default((List) destination$iv$iv4, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.phisher98.StremioAddon$Stream$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj5) {
                                return StremioAddon.Stream.runCallback$lambda$5((String) obj5);
                            }
                        }, 30, (Object) null);
                        String magnet3 = "magnet:?xt=urn:btih:" + this.infoHash + sourceTrackers3 + otherTrackers2;
                        str3 = this.name;
                        if (str3 == null) {
                            str3 = "";
                        }
                        str4 = this.title;
                        if (str4 == null) {
                            str4 = "";
                        }
                        StremioAddon$Stream$runCallback$4 stremioAddon$Stream$runCallback$7 = new StremioAddon$Stream$runCallback$4(continuation2);
                        stremioAddon$Stream$runCallback$2.L$0 = SpillingKt.nullOutSpilledVariable(function6);
                        stremioAddon$Stream$runCallback$2.L$1 = SpillingKt.nullOutSpilledVariable(function9);
                        stremioAddon$Stream$runCallback$2.L$2 = SpillingKt.nullOutSpilledVariable(resp3);
                        stremioAddon$Stream$runCallback$2.L$3 = SpillingKt.nullOutSpilledVariable(otherTrackers2);
                        stremioAddon$Stream$runCallback$2.L$4 = SpillingKt.nullOutSpilledVariable(sourceTrackers3);
                        stremioAddon$Stream$runCallback$2.L$5 = SpillingKt.nullOutSpilledVariable(magnet3);
                        stremioAddon$Stream$runCallback$2.L$6 = function9;
                        stremioAddon$Stream$runCallback$2.label = 7;
                        $result = ExtractorApiKt.newExtractorLink$default(str3, str4, magnet3, (ExtractorLinkType) null, stremioAddon$Stream$runCallback$7, stremioAddon$Stream$runCallback$2, 8, (Object) null);
                        if ($result == obj2) {
                            return obj2;
                        }
                        function10 = function9;
                        function11 = function6;
                        function10.invoke($result);
                    }
                    return Unit.INSTANCE;
                case 3:
                    function12 = (Function1) stremioAddon$Stream$runCallback$2.L$1;
                    function5 = (Function1) stremioAddon$Stream$runCallback$2.L$0;
                    ResultKt.throwOnFailure($result);
                    if (this.externalUrl != null) {
                        str2 = this.externalUrl;
                        stremioAddon$Stream$runCallback$2.L$0 = SpillingKt.nullOutSpilledVariable(function5);
                        stremioAddon$Stream$runCallback$2.L$1 = function12;
                        stremioAddon$Stream$runCallback$2.label = 4;
                        if (ExtractorApiKt.loadExtractor(str2, function5, function12, stremioAddon$Stream$runCallback$2) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function6 = function5;
                    } else {
                        function6 = function5;
                    }
                    if (this.infoHash != null) {
                        Requests app4 = MainActivityKt.getApp();
                        stremioAddon$Stream$runCallback$2.L$0 = SpillingKt.nullOutSpilledVariable(function6);
                        stremioAddon$Stream$runCallback$2.L$1 = function12;
                        stremioAddon$Stream$runCallback$2.label = 5;
                        function7 = function12;
                        obj2 = coroutine_suspended;
                        continuation2 = null;
                        obj3 = Requests.get$default(app4, StremioAddon.TRACKER_LIST_URL, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, stremioAddon$Stream$runCallback$2, 4094, (Object) null);
                        if (obj3 == obj2) {
                            stremioAddon$Stream$runCallback$2 = stremioAddon$Stream$runCallback$2;
                            return obj2;
                        }
                        stremioAddon$Stream$runCallback$2 = stremioAddon$Stream$runCallback$2;
                        obj4 = obj3;
                        function8 = function7;
                        resp = ((NiceResponse) obj4).getText();
                        Iterable $this$filterIndexed$iv4 = StringsKt.split$default(resp, new String[]{"\n"}, false, 0, 6, (Object) null);
                        destination$iv$iv = new ArrayList();
                        index$iv$iv = 0;
                        while (r15.hasNext()) {
                            int index$iv$iv$iv4 = index$iv$iv + 1;
                            if (index$iv$iv < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            i = index$iv$iv;
                            if (i % 2 == 0) {
                                i2 = 1;
                            } else {
                                i2 = 0;
                            }
                            if (i2 != 0) {
                                destination$iv$iv.add(item$iv$iv$iv);
                            }
                            index$iv$iv = index$iv$iv$iv4;
                        }
                        destination$iv$iv2 = new ArrayList();
                        while (r11.hasNext()) {
                            s = (String) element$iv$iv;
                            if (s.length() > 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                destination$iv$iv2.add(element$iv$iv);
                            }
                        }
                        otherTrackers = CollectionsKt.joinToString$default((List) destination$iv$iv2, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.phisher98.StremioAddon$Stream$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj5) {
                                return StremioAddon.Stream.runCallback$lambda$2((String) obj5);
                            }
                        }, 30, (Object) null);
                        $this$filter$iv = this.sources;
                        $i$f$filter = 0;
                        destination$iv$iv3 = new ArrayList();
                        while (r12.hasNext()) {
                            it = (String) element$iv$iv2;
                            String resp7 = resp;
                            Iterable $this$filter$iv5 = $this$filter$iv;
                            int $i$f$filter5 = $i$f$filter;
                            if (StringsKt.startsWith$default(it, "tracker:", false, 2, continuation2)) {
                                destination$iv$iv3.add(element$iv$iv2);
                            }
                            resp = resp7;
                            $this$filter$iv = $this$filter$iv5;
                            $i$f$filter = $i$f$filter5;
                        }
                        resp2 = resp;
                        StremioAddon$Stream$runCallback$sourceTrackers$2 stremioAddon$Stream$runCallback$sourceTrackers$5 = new StremioAddon$Stream$runCallback$sourceTrackers$2(continuation2);
                        stremioAddon$Stream$runCallback$2.L$0 = SpillingKt.nullOutSpilledVariable(function6);
                        stremioAddon$Stream$runCallback$2.L$1 = function8;
                        stremioAddon$Stream$runCallback$2.L$2 = SpillingKt.nullOutSpilledVariable(resp2);
                        stremioAddon$Stream$runCallback$2.L$3 = otherTrackers;
                        stremioAddon$Stream$runCallback$2.label = 6;
                        objAmap = ParCollectionsKt.amap((List) destination$iv$iv3, stremioAddon$Stream$runCallback$sourceTrackers$5, stremioAddon$Stream$runCallback$2);
                        if (objAmap == obj2) {
                            return obj2;
                        }
                        resp3 = resp2;
                        otherTrackers2 = otherTrackers;
                        function9 = function8;
                        destination$iv$iv4 = new ArrayList();
                        while (r11.hasNext()) {
                            s2 = (String) element$iv$iv3;
                            if (s2.length() > 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (z2) {
                                destination$iv$iv4.add(element$iv$iv3);
                            }
                        }
                        String sourceTrackers4 = CollectionsKt.joinToString$default((List) destination$iv$iv4, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.phisher98.StremioAddon$Stream$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj5) {
                                return StremioAddon.Stream.runCallback$lambda$5((String) obj5);
                            }
                        }, 30, (Object) null);
                        String magnet4 = "magnet:?xt=urn:btih:" + this.infoHash + sourceTrackers4 + otherTrackers2;
                        str3 = this.name;
                        if (str3 == null) {
                            str3 = "";
                        }
                        str4 = this.title;
                        if (str4 == null) {
                            str4 = "";
                        }
                        StremioAddon$Stream$runCallback$4 stremioAddon$Stream$runCallback$8 = new StremioAddon$Stream$runCallback$4(continuation2);
                        stremioAddon$Stream$runCallback$2.L$0 = SpillingKt.nullOutSpilledVariable(function6);
                        stremioAddon$Stream$runCallback$2.L$1 = SpillingKt.nullOutSpilledVariable(function9);
                        stremioAddon$Stream$runCallback$2.L$2 = SpillingKt.nullOutSpilledVariable(resp3);
                        stremioAddon$Stream$runCallback$2.L$3 = SpillingKt.nullOutSpilledVariable(otherTrackers2);
                        stremioAddon$Stream$runCallback$2.L$4 = SpillingKt.nullOutSpilledVariable(sourceTrackers4);
                        stremioAddon$Stream$runCallback$2.L$5 = SpillingKt.nullOutSpilledVariable(magnet4);
                        stremioAddon$Stream$runCallback$2.L$6 = function9;
                        stremioAddon$Stream$runCallback$2.label = 7;
                        $result = ExtractorApiKt.newExtractorLink$default(str3, str4, magnet4, (ExtractorLinkType) null, stremioAddon$Stream$runCallback$8, stremioAddon$Stream$runCallback$2, 8, (Object) null);
                        if ($result == obj2) {
                            return obj2;
                        }
                        function10 = function9;
                        function11 = function6;
                        function10.invoke($result);
                    }
                    return Unit.INSTANCE;
                case 4:
                    function12 = (Function1) stremioAddon$Stream$runCallback$2.L$1;
                    function5 = (Function1) stremioAddon$Stream$runCallback$2.L$0;
                    ResultKt.throwOnFailure($result);
                    function6 = function5;
                    if (this.infoHash != null) {
                        Requests app5 = MainActivityKt.getApp();
                        stremioAddon$Stream$runCallback$2.L$0 = SpillingKt.nullOutSpilledVariable(function6);
                        stremioAddon$Stream$runCallback$2.L$1 = function12;
                        stremioAddon$Stream$runCallback$2.label = 5;
                        function7 = function12;
                        obj2 = coroutine_suspended;
                        continuation2 = null;
                        obj3 = Requests.get$default(app5, StremioAddon.TRACKER_LIST_URL, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, stremioAddon$Stream$runCallback$2, 4094, (Object) null);
                        if (obj3 == obj2) {
                            stremioAddon$Stream$runCallback$2 = stremioAddon$Stream$runCallback$2;
                            return obj2;
                        }
                        stremioAddon$Stream$runCallback$2 = stremioAddon$Stream$runCallback$2;
                        obj4 = obj3;
                        function8 = function7;
                        resp = ((NiceResponse) obj4).getText();
                        Iterable $this$filterIndexed$iv5 = StringsKt.split$default(resp, new String[]{"\n"}, false, 0, 6, (Object) null);
                        destination$iv$iv = new ArrayList();
                        index$iv$iv = 0;
                        while (r15.hasNext()) {
                            int index$iv$iv$iv5 = index$iv$iv + 1;
                            if (index$iv$iv < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            i = index$iv$iv;
                            if (i % 2 == 0) {
                                i2 = 1;
                            } else {
                                i2 = 0;
                            }
                            if (i2 != 0) {
                                destination$iv$iv.add(item$iv$iv$iv);
                            }
                            index$iv$iv = index$iv$iv$iv5;
                        }
                        destination$iv$iv2 = new ArrayList();
                        while (r11.hasNext()) {
                            s = (String) element$iv$iv;
                            if (s.length() > 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                destination$iv$iv2.add(element$iv$iv);
                            }
                        }
                        otherTrackers = CollectionsKt.joinToString$default((List) destination$iv$iv2, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.phisher98.StremioAddon$Stream$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj5) {
                                return StremioAddon.Stream.runCallback$lambda$2((String) obj5);
                            }
                        }, 30, (Object) null);
                        $this$filter$iv = this.sources;
                        $i$f$filter = 0;
                        destination$iv$iv3 = new ArrayList();
                        while (r12.hasNext()) {
                            it = (String) element$iv$iv2;
                            String resp8 = resp;
                            Iterable $this$filter$iv6 = $this$filter$iv;
                            int $i$f$filter6 = $i$f$filter;
                            if (StringsKt.startsWith$default(it, "tracker:", false, 2, continuation2)) {
                                destination$iv$iv3.add(element$iv$iv2);
                            }
                            resp = resp8;
                            $this$filter$iv = $this$filter$iv6;
                            $i$f$filter = $i$f$filter6;
                        }
                        resp2 = resp;
                        StremioAddon$Stream$runCallback$sourceTrackers$2 stremioAddon$Stream$runCallback$sourceTrackers$6 = new StremioAddon$Stream$runCallback$sourceTrackers$2(continuation2);
                        stremioAddon$Stream$runCallback$2.L$0 = SpillingKt.nullOutSpilledVariable(function6);
                        stremioAddon$Stream$runCallback$2.L$1 = function8;
                        stremioAddon$Stream$runCallback$2.L$2 = SpillingKt.nullOutSpilledVariable(resp2);
                        stremioAddon$Stream$runCallback$2.L$3 = otherTrackers;
                        stremioAddon$Stream$runCallback$2.label = 6;
                        objAmap = ParCollectionsKt.amap((List) destination$iv$iv3, stremioAddon$Stream$runCallback$sourceTrackers$6, stremioAddon$Stream$runCallback$2);
                        if (objAmap == obj2) {
                            return obj2;
                        }
                        resp3 = resp2;
                        otherTrackers2 = otherTrackers;
                        function9 = function8;
                        destination$iv$iv4 = new ArrayList();
                        while (r11.hasNext()) {
                            s2 = (String) element$iv$iv3;
                            if (s2.length() > 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (z2) {
                                destination$iv$iv4.add(element$iv$iv3);
                            }
                        }
                        String sourceTrackers5 = CollectionsKt.joinToString$default((List) destination$iv$iv4, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.phisher98.StremioAddon$Stream$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj5) {
                                return StremioAddon.Stream.runCallback$lambda$5((String) obj5);
                            }
                        }, 30, (Object) null);
                        String magnet5 = "magnet:?xt=urn:btih:" + this.infoHash + sourceTrackers5 + otherTrackers2;
                        str3 = this.name;
                        if (str3 == null) {
                            str3 = "";
                        }
                        str4 = this.title;
                        if (str4 == null) {
                            str4 = "";
                        }
                        StremioAddon$Stream$runCallback$4 stremioAddon$Stream$runCallback$9 = new StremioAddon$Stream$runCallback$4(continuation2);
                        stremioAddon$Stream$runCallback$2.L$0 = SpillingKt.nullOutSpilledVariable(function6);
                        stremioAddon$Stream$runCallback$2.L$1 = SpillingKt.nullOutSpilledVariable(function9);
                        stremioAddon$Stream$runCallback$2.L$2 = SpillingKt.nullOutSpilledVariable(resp3);
                        stremioAddon$Stream$runCallback$2.L$3 = SpillingKt.nullOutSpilledVariable(otherTrackers2);
                        stremioAddon$Stream$runCallback$2.L$4 = SpillingKt.nullOutSpilledVariable(sourceTrackers5);
                        stremioAddon$Stream$runCallback$2.L$5 = SpillingKt.nullOutSpilledVariable(magnet5);
                        stremioAddon$Stream$runCallback$2.L$6 = function9;
                        stremioAddon$Stream$runCallback$2.label = 7;
                        $result = ExtractorApiKt.newExtractorLink$default(str3, str4, magnet5, (ExtractorLinkType) null, stremioAddon$Stream$runCallback$9, stremioAddon$Stream$runCallback$2, 8, (Object) null);
                        if ($result == obj2) {
                            return obj2;
                        }
                        function10 = function9;
                        function11 = function6;
                        function10.invoke($result);
                    }
                    return Unit.INSTANCE;
                case 5:
                    Function1<? super ExtractorLink, Unit> function17 = (Function1) stremioAddon$Stream$runCallback$2.L$1;
                    Function1<? super SubtitleFile, Unit> function18 = (Function1) stremioAddon$Stream$runCallback$2.L$0;
                    ResultKt.throwOnFailure($result);
                    obj4 = $result;
                    function6 = function18;
                    continuation2 = null;
                    function8 = function17;
                    obj2 = coroutine_suspended;
                    resp = ((NiceResponse) obj4).getText();
                    Iterable $this$filterIndexed$iv6 = StringsKt.split$default(resp, new String[]{"\n"}, false, 0, 6, (Object) null);
                    destination$iv$iv = new ArrayList();
                    index$iv$iv = 0;
                    while (r15.hasNext()) {
                        int index$iv$iv$iv6 = index$iv$iv + 1;
                        if (index$iv$iv < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        i = index$iv$iv;
                        if (i % 2 == 0) {
                            i2 = 1;
                        } else {
                            i2 = 0;
                        }
                        if (i2 != 0) {
                            destination$iv$iv.add(item$iv$iv$iv);
                        }
                        index$iv$iv = index$iv$iv$iv6;
                    }
                    destination$iv$iv2 = new ArrayList();
                    while (r11.hasNext()) {
                        s = (String) element$iv$iv;
                        if (s.length() > 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            destination$iv$iv2.add(element$iv$iv);
                        }
                    }
                    otherTrackers = CollectionsKt.joinToString$default((List) destination$iv$iv2, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.phisher98.StremioAddon$Stream$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj5) {
                            return StremioAddon.Stream.runCallback$lambda$2((String) obj5);
                        }
                    }, 30, (Object) null);
                    $this$filter$iv = this.sources;
                    $i$f$filter = 0;
                    destination$iv$iv3 = new ArrayList();
                    while (r12.hasNext()) {
                        it = (String) element$iv$iv2;
                        String resp9 = resp;
                        Iterable $this$filter$iv7 = $this$filter$iv;
                        int $i$f$filter7 = $i$f$filter;
                        if (StringsKt.startsWith$default(it, "tracker:", false, 2, continuation2)) {
                            destination$iv$iv3.add(element$iv$iv2);
                        }
                        resp = resp9;
                        $this$filter$iv = $this$filter$iv7;
                        $i$f$filter = $i$f$filter7;
                    }
                    resp2 = resp;
                    StremioAddon$Stream$runCallback$sourceTrackers$2 stremioAddon$Stream$runCallback$sourceTrackers$7 = new StremioAddon$Stream$runCallback$sourceTrackers$2(continuation2);
                    stremioAddon$Stream$runCallback$2.L$0 = SpillingKt.nullOutSpilledVariable(function6);
                    stremioAddon$Stream$runCallback$2.L$1 = function8;
                    stremioAddon$Stream$runCallback$2.L$2 = SpillingKt.nullOutSpilledVariable(resp2);
                    stremioAddon$Stream$runCallback$2.L$3 = otherTrackers;
                    stremioAddon$Stream$runCallback$2.label = 6;
                    objAmap = ParCollectionsKt.amap((List) destination$iv$iv3, stremioAddon$Stream$runCallback$sourceTrackers$7, stremioAddon$Stream$runCallback$2);
                    if (objAmap == obj2) {
                        return obj2;
                    }
                    resp3 = resp2;
                    otherTrackers2 = otherTrackers;
                    function9 = function8;
                    destination$iv$iv4 = new ArrayList();
                    while (r11.hasNext()) {
                        s2 = (String) element$iv$iv3;
                        if (s2.length() > 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            destination$iv$iv4.add(element$iv$iv3);
                        }
                    }
                    String sourceTrackers6 = CollectionsKt.joinToString$default((List) destination$iv$iv4, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.phisher98.StremioAddon$Stream$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj5) {
                            return StremioAddon.Stream.runCallback$lambda$5((String) obj5);
                        }
                    }, 30, (Object) null);
                    String magnet6 = "magnet:?xt=urn:btih:" + this.infoHash + sourceTrackers6 + otherTrackers2;
                    str3 = this.name;
                    if (str3 == null) {
                        str3 = "";
                    }
                    str4 = this.title;
                    if (str4 == null) {
                        str4 = "";
                    }
                    StremioAddon$Stream$runCallback$4 stremioAddon$Stream$runCallback$10 = new StremioAddon$Stream$runCallback$4(continuation2);
                    stremioAddon$Stream$runCallback$2.L$0 = SpillingKt.nullOutSpilledVariable(function6);
                    stremioAddon$Stream$runCallback$2.L$1 = SpillingKt.nullOutSpilledVariable(function9);
                    stremioAddon$Stream$runCallback$2.L$2 = SpillingKt.nullOutSpilledVariable(resp3);
                    stremioAddon$Stream$runCallback$2.L$3 = SpillingKt.nullOutSpilledVariable(otherTrackers2);
                    stremioAddon$Stream$runCallback$2.L$4 = SpillingKt.nullOutSpilledVariable(sourceTrackers6);
                    stremioAddon$Stream$runCallback$2.L$5 = SpillingKt.nullOutSpilledVariable(magnet6);
                    stremioAddon$Stream$runCallback$2.L$6 = function9;
                    stremioAddon$Stream$runCallback$2.label = 7;
                    $result = ExtractorApiKt.newExtractorLink$default(str3, str4, magnet6, (ExtractorLinkType) null, stremioAddon$Stream$runCallback$10, stremioAddon$Stream$runCallback$2, 8, (Object) null);
                    if ($result == obj2) {
                        return obj2;
                    }
                    function10 = function9;
                    function11 = function6;
                    function10.invoke($result);
                    return Unit.INSTANCE;
                case 6:
                    String otherTrackers3 = (String) stremioAddon$Stream$runCallback$2.L$3;
                    String resp10 = (String) stremioAddon$Stream$runCallback$2.L$2;
                    Function1<? super ExtractorLink, Unit> function19 = (Function1) stremioAddon$Stream$runCallback$2.L$1;
                    Function1<? super SubtitleFile, Unit> function20 = (Function1) stremioAddon$Stream$runCallback$2.L$0;
                    ResultKt.throwOnFailure($result);
                    function9 = function19;
                    otherTrackers2 = otherTrackers3;
                    resp3 = resp10;
                    function6 = function20;
                    obj2 = coroutine_suspended;
                    objAmap = $result;
                    continuation2 = null;
                    destination$iv$iv4 = new ArrayList();
                    while (r11.hasNext()) {
                        s2 = (String) element$iv$iv3;
                        if (s2.length() > 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            destination$iv$iv4.add(element$iv$iv3);
                        }
                    }
                    String sourceTrackers7 = CollectionsKt.joinToString$default((List) destination$iv$iv4, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.phisher98.StremioAddon$Stream$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj5) {
                            return StremioAddon.Stream.runCallback$lambda$5((String) obj5);
                        }
                    }, 30, (Object) null);
                    String magnet7 = "magnet:?xt=urn:btih:" + this.infoHash + sourceTrackers7 + otherTrackers2;
                    str3 = this.name;
                    if (str3 == null) {
                        str3 = "";
                    }
                    str4 = this.title;
                    if (str4 == null) {
                        str4 = "";
                    }
                    StremioAddon$Stream$runCallback$4 stremioAddon$Stream$runCallback$11 = new StremioAddon$Stream$runCallback$4(continuation2);
                    stremioAddon$Stream$runCallback$2.L$0 = SpillingKt.nullOutSpilledVariable(function6);
                    stremioAddon$Stream$runCallback$2.L$1 = SpillingKt.nullOutSpilledVariable(function9);
                    stremioAddon$Stream$runCallback$2.L$2 = SpillingKt.nullOutSpilledVariable(resp3);
                    stremioAddon$Stream$runCallback$2.L$3 = SpillingKt.nullOutSpilledVariable(otherTrackers2);
                    stremioAddon$Stream$runCallback$2.L$4 = SpillingKt.nullOutSpilledVariable(sourceTrackers7);
                    stremioAddon$Stream$runCallback$2.L$5 = SpillingKt.nullOutSpilledVariable(magnet7);
                    stremioAddon$Stream$runCallback$2.L$6 = function9;
                    stremioAddon$Stream$runCallback$2.label = 7;
                    $result = ExtractorApiKt.newExtractorLink$default(str3, str4, magnet7, (ExtractorLinkType) null, stremioAddon$Stream$runCallback$11, stremioAddon$Stream$runCallback$2, 8, (Object) null);
                    if ($result == obj2) {
                        return obj2;
                    }
                    function10 = function9;
                    function11 = function6;
                    function10.invoke($result);
                    return Unit.INSTANCE;
                case 7:
                    function10 = (Function1) stremioAddon$Stream$runCallback$2.L$6;
                    function11 = (Function1) stremioAddon$Stream$runCallback$2.L$0;
                    ResultKt.throwOnFailure($result);
                    function10.invoke($result);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        static final CharSequence runCallback$lambda$2(String it) {
            return "&tr=" + it;
        }

        static final CharSequence runCallback$lambda$5(String it) {
            return "&tr=" + it;
        }
    }

    /* JADX INFO: compiled from: StremioAddon.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/phisher98/StremioAddon$LoadData;", "", "imdbId", "", "season", "", "episode", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getImdbId", "()Ljava/lang/String;", "getSeason", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEpisode", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/phisher98/StremioAddon$LoadData;", "equals", "", "other", "hashCode", "toString", "StremioAddon"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class LoadData {

        @Nullable
        private final Integer episode;

        @Nullable
        private final String imdbId;

        @Nullable
        private final Integer season;

        public LoadData() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ LoadData copy$default(LoadData loadData, String str, Integer num, Integer num2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = loadData.imdbId;
            }
            if ((i & 2) != 0) {
                num = loadData.season;
            }
            if ((i & 4) != 0) {
                num2 = loadData.episode;
            }
            return loadData.copy(str, num, num2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getImdbId() {
            return this.imdbId;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getSeason() {
            return this.season;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getEpisode() {
            return this.episode;
        }

        @NotNull
        public final LoadData copy(@Nullable String imdbId, @Nullable Integer season, @Nullable Integer episode) {
            return new LoadData(imdbId, season, episode);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LoadData)) {
                return false;
            }
            LoadData loadData = (LoadData) other;
            return Intrinsics.areEqual(this.imdbId, loadData.imdbId) && Intrinsics.areEqual(this.season, loadData.season) && Intrinsics.areEqual(this.episode, loadData.episode);
        }

        public int hashCode() {
            return ((((this.imdbId == null ? 0 : this.imdbId.hashCode()) * 31) + (this.season == null ? 0 : this.season.hashCode())) * 31) + (this.episode != null ? this.episode.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "LoadData(imdbId=" + this.imdbId + ", season=" + this.season + ", episode=" + this.episode + ')';
        }

        public LoadData(@Nullable String imdbId, @Nullable Integer season, @Nullable Integer episode) {
            this.imdbId = imdbId;
            this.season = season;
            this.episode = episode;
        }

        public /* synthetic */ LoadData(String str, Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2);
        }

        @Nullable
        public final String getImdbId() {
            return this.imdbId;
        }

        @Nullable
        public final Integer getSeason() {
            return this.season;
        }

        @Nullable
        public final Integer getEpisode() {
            return this.episode;
        }
    }

    /* JADX INFO: compiled from: StremioAddon.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ>\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0005HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/phisher98/StremioAddon$Data;", "", "id", "", "type", "", "aniId", "malId", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getType", "()Ljava/lang/String;", "getAniId", "getMalId", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/phisher98/StremioAddon$Data;", "equals", "", "other", "hashCode", "toString", "StremioAddon"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Data {

        @Nullable
        private final String aniId;

        @Nullable
        private final Integer id;

        @Nullable
        private final Integer malId;

        @Nullable
        private final String type;

        public Data() {
            this(null, null, null, null, 15, null);
        }

        public static /* synthetic */ Data copy$default(Data data, Integer num, String str, String str2, Integer num2, int i, Object obj) {
            if ((i & 1) != 0) {
                num = data.id;
            }
            if ((i & 2) != 0) {
                str = data.type;
            }
            if ((i & 4) != 0) {
                str2 = data.aniId;
            }
            if ((i & 8) != 0) {
                num2 = data.malId;
            }
            return data.copy(num, str, str2, num2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getAniId() {
            return this.aniId;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Integer getMalId() {
            return this.malId;
        }

        @NotNull
        public final Data copy(@Nullable Integer id, @Nullable String type, @Nullable String aniId, @Nullable Integer malId) {
            return new Data(id, type, aniId, malId);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Data)) {
                return false;
            }
            Data data = (Data) other;
            return Intrinsics.areEqual(this.id, data.id) && Intrinsics.areEqual(this.type, data.type) && Intrinsics.areEqual(this.aniId, data.aniId) && Intrinsics.areEqual(this.malId, data.malId);
        }

        public int hashCode() {
            return ((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.aniId == null ? 0 : this.aniId.hashCode())) * 31) + (this.malId != null ? this.malId.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Data(id=" + this.id + ", type=" + this.type + ", aniId=" + this.aniId + ", malId=" + this.malId + ')';
        }

        public Data(@Nullable Integer id, @Nullable String type, @Nullable String aniId, @Nullable Integer malId) {
            this.id = id;
            this.type = type;
            this.aniId = aniId;
            this.malId = malId;
        }

        public /* synthetic */ Data(Integer num, String str, String str2, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : num2);
        }

        @Nullable
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }

        @Nullable
        public final String getAniId() {
            return this.aniId;
        }

        @Nullable
        public final Integer getMalId() {
            return this.malId;
        }
    }

    /* JADX INFO: compiled from: StremioAddon.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J5\u0010\r\u001a\u00020\u00002*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R%\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/phisher98/StremioAddon$Results;", "", "results", "Ljava/util/ArrayList;", "Lcom/phisher98/StremioAddon$Media;", "Lkotlin/collections/ArrayList;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Ljava/util/ArrayList;)V", "getResults", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "StremioAddon"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Results {

        @Nullable
        private final ArrayList<Media> results;

        /* JADX WARN: Illegal instructions before constructor call */
        public Results() {
            ArrayList arrayList = null;
            this(arrayList, 1, arrayList);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Results copy$default(Results results, ArrayList arrayList, int i, Object obj) {
            if ((i & 1) != 0) {
                arrayList = results.results;
            }
            return results.copy(arrayList);
        }

        @Nullable
        public final ArrayList<Media> component1() {
            return this.results;
        }

        @NotNull
        public final Results copy(@JsonProperty("results") @Nullable ArrayList<Media> results) {
            return new Results(results);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Results) && Intrinsics.areEqual(this.results, ((Results) other).results);
        }

        public int hashCode() {
            if (this.results == null) {
                return 0;
            }
            return this.results.hashCode();
        }

        @NotNull
        public String toString() {
            return "Results(results=" + this.results + ')';
        }

        public Results(@JsonProperty("results") @Nullable ArrayList<Media> arrayList) {
            this.results = arrayList;
        }

        public /* synthetic */ Results(ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new ArrayList() : arrayList);
        }

        @Nullable
        public final ArrayList<Media> getResults() {
            return this.results;
        }
    }

    /* JADX INFO: compiled from: StremioAddon.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B£\u0001\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003Jª\u0001\u0010 \u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n2\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f2\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000eHÆ\u0001¢\u0006\u0002\u0010!J\u0014\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010%\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010&\u001a\u00020\u0007HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015¨\u0006'"}, d2 = {"Lcom/phisher98/StremioAddon$Media;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "name", "", "title", "originalTitle", "original_title", "mediaType", "media_type", "posterPath", "poster_path", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "getTitle", "getOriginalTitle", "getMediaType", "getPosterPath", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/phisher98/StremioAddon$Media;", "equals", "", "other", "hashCode", "toString", "StremioAddon"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Media {

        @Nullable
        private final Integer id;

        @Nullable
        private final String mediaType;

        @Nullable
        private final String name;

        @Nullable
        private final String originalTitle;

        @Nullable
        private final String posterPath;

        @Nullable
        private final String title;

        public Media() {
            this(null, null, null, null, null, null, 63, null);
        }

        public static /* synthetic */ Media copy$default(Media media, Integer num, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
            if ((i & 1) != 0) {
                num = media.id;
            }
            if ((i & 2) != 0) {
                str = media.name;
            }
            if ((i & 4) != 0) {
                str2 = media.title;
            }
            if ((i & 8) != 0) {
                str3 = media.originalTitle;
            }
            if ((i & 16) != 0) {
                str4 = media.mediaType;
            }
            if ((i & 32) != 0) {
                str5 = media.posterPath;
            }
            String str6 = str4;
            String str7 = str5;
            return media.copy(num, str, str2, str3, str6, str7);
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
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getOriginalTitle() {
            return this.originalTitle;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getMediaType() {
            return this.mediaType;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getPosterPath() {
            return this.posterPath;
        }

        @NotNull
        public final Media copy(@JsonProperty("id") @Nullable Integer id, @JsonProperty("name") @Nullable String name, @JsonProperty("title") @Nullable String title, @JsonProperty("original_title") @Nullable String originalTitle, @JsonProperty("media_type") @Nullable String mediaType, @JsonProperty("poster_path") @Nullable String posterPath) {
            return new Media(id, name, title, originalTitle, mediaType, posterPath);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Media)) {
                return false;
            }
            Media media = (Media) other;
            return Intrinsics.areEqual(this.id, media.id) && Intrinsics.areEqual(this.name, media.name) && Intrinsics.areEqual(this.title, media.title) && Intrinsics.areEqual(this.originalTitle, media.originalTitle) && Intrinsics.areEqual(this.mediaType, media.mediaType) && Intrinsics.areEqual(this.posterPath, media.posterPath);
        }

        public int hashCode() {
            return ((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.originalTitle == null ? 0 : this.originalTitle.hashCode())) * 31) + (this.mediaType == null ? 0 : this.mediaType.hashCode())) * 31) + (this.posterPath != null ? this.posterPath.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Media(id=" + this.id + ", name=" + this.name + ", title=" + this.title + ", originalTitle=" + this.originalTitle + ", mediaType=" + this.mediaType + ", posterPath=" + this.posterPath + ')';
        }

        public Media(@JsonProperty("id") @Nullable Integer id, @JsonProperty("name") @Nullable String name, @JsonProperty("title") @Nullable String title, @JsonProperty("original_title") @Nullable String originalTitle, @JsonProperty("media_type") @Nullable String mediaType, @JsonProperty("poster_path") @Nullable String posterPath) {
            this.id = id;
            this.name = name;
            this.title = title;
            this.originalTitle = originalTitle;
            this.mediaType = mediaType;
            this.posterPath = posterPath;
        }

        public /* synthetic */ Media(Integer num, String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5);
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
        public final String getOriginalTitle() {
            return this.originalTitle;
        }

        @Nullable
        public final String getMediaType() {
            return this.mediaType;
        }

        @Nullable
        public final String getPosterPath() {
            return this.posterPath;
        }
    }

    /* JADX INFO: compiled from: StremioAddon.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0007HÆ\u0003JB\u0010\u0011\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0007HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/phisher98/StremioAddon$Genres;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "name", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/phisher98/StremioAddon$Genres;", "equals", "", "other", "hashCode", "toString", "StremioAddon"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Genres {

        @Nullable
        private final Integer id;

        @Nullable
        private final String name;

        /* JADX WARN: Multi-variable type inference failed */
        public Genres() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Genres copy$default(Genres genres, Integer num, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                num = genres.id;
            }
            if ((i & 2) != 0) {
                str = genres.name;
            }
            return genres.copy(num, str);
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
        public final Genres copy(@JsonProperty("id") @Nullable Integer id, @JsonProperty("name") @Nullable String name) {
            return new Genres(id, name);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Genres)) {
                return false;
            }
            Genres genres = (Genres) other;
            return Intrinsics.areEqual(this.id, genres.id) && Intrinsics.areEqual(this.name, genres.name);
        }

        public int hashCode() {
            return ((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.name != null ? this.name.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Genres(id=" + this.id + ", name=" + this.name + ')';
        }

        public Genres(@JsonProperty("id") @Nullable Integer id, @JsonProperty("name") @Nullable String name) {
            this.id = id;
            this.name = name;
        }

        public /* synthetic */ Genres(Integer num, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
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

    /* JADX INFO: compiled from: StremioAddon.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0007HÆ\u0003JB\u0010\u0011\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0007HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/phisher98/StremioAddon$Keywords;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "name", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/phisher98/StremioAddon$Keywords;", "equals", "", "other", "hashCode", "toString", "StremioAddon"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Keywords {

        @Nullable
        private final Integer id;

        @Nullable
        private final String name;

        /* JADX WARN: Multi-variable type inference failed */
        public Keywords() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Keywords copy$default(Keywords keywords, Integer num, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                num = keywords.id;
            }
            if ((i & 2) != 0) {
                str = keywords.name;
            }
            return keywords.copy(num, str);
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
        public final Keywords copy(@JsonProperty("id") @Nullable Integer id, @JsonProperty("name") @Nullable String name) {
            return new Keywords(id, name);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Keywords)) {
                return false;
            }
            Keywords keywords = (Keywords) other;
            return Intrinsics.areEqual(this.id, keywords.id) && Intrinsics.areEqual(this.name, keywords.name);
        }

        public int hashCode() {
            return ((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.name != null ? this.name.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Keywords(id=" + this.id + ", name=" + this.name + ')';
        }

        public Keywords(@JsonProperty("id") @Nullable Integer id, @JsonProperty("name") @Nullable String name) {
            this.id = id;
            this.name = name;
        }

        public /* synthetic */ Keywords(Integer num, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
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

    /* JADX INFO: compiled from: StremioAddon.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002\u0012*\b\u0003\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J\u001d\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003Ja\u0010\u0010\u001a\u00020\u00002*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u00022*\b\u0003\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bHÆ\u0001J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004R%\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR%\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/phisher98/StremioAddon$KeywordResults;", "", "results", "Ljava/util/ArrayList;", "Lcom/phisher98/StremioAddon$Keywords;", "Lkotlin/collections/ArrayList;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "keywords", "<init>", "(Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getResults", "()Ljava/util/ArrayList;", "getKeywords", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "StremioAddon"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class KeywordResults {

        @Nullable
        private final ArrayList<Keywords> keywords;

        @Nullable
        private final ArrayList<Keywords> results;

        /* JADX WARN: Illegal instructions before constructor call */
        public KeywordResults() {
            ArrayList arrayList = null;
            this(arrayList, arrayList, 3, arrayList);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ KeywordResults copy$default(KeywordResults keywordResults, ArrayList arrayList, ArrayList arrayList2, int i, Object obj) {
            if ((i & 1) != 0) {
                arrayList = keywordResults.results;
            }
            if ((i & 2) != 0) {
                arrayList2 = keywordResults.keywords;
            }
            return keywordResults.copy(arrayList, arrayList2);
        }

        @Nullable
        public final ArrayList<Keywords> component1() {
            return this.results;
        }

        @Nullable
        public final ArrayList<Keywords> component2() {
            return this.keywords;
        }

        @NotNull
        public final KeywordResults copy(@JsonProperty("results") @Nullable ArrayList<Keywords> results, @JsonProperty("keywords") @Nullable ArrayList<Keywords> keywords) {
            return new KeywordResults(results, keywords);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof KeywordResults)) {
                return false;
            }
            KeywordResults keywordResults = (KeywordResults) other;
            return Intrinsics.areEqual(this.results, keywordResults.results) && Intrinsics.areEqual(this.keywords, keywordResults.keywords);
        }

        public int hashCode() {
            return ((this.results == null ? 0 : this.results.hashCode()) * 31) + (this.keywords != null ? this.keywords.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "KeywordResults(results=" + this.results + ", keywords=" + this.keywords + ')';
        }

        public KeywordResults(@JsonProperty("results") @Nullable ArrayList<Keywords> arrayList, @JsonProperty("keywords") @Nullable ArrayList<Keywords> arrayList2) {
            this.results = arrayList;
            this.keywords = arrayList2;
        }

        public /* synthetic */ KeywordResults(ArrayList arrayList, ArrayList arrayList2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new ArrayList() : arrayList, (i & 2) != 0 ? new ArrayList() : arrayList2);
        }

        @Nullable
        public final ArrayList<Keywords> getResults() {
            return this.results;
        }

        @Nullable
        public final ArrayList<Keywords> getKeywords() {
            return this.keywords;
        }
    }

    /* JADX INFO: compiled from: StremioAddon.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t\u0012\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003Jv\u0010\u0019\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t2\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000bHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0014\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001f\u001a\u00020\u0007HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0013\u0010\u000fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012¨\u0006 "}, d2 = {"Lcom/phisher98/StremioAddon$Seasons;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "name", "", "seasonNumber", "season_number", "airDate", "air_date", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "getSeasonNumber", "getAirDate", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/phisher98/StremioAddon$Seasons;", "equals", "", "other", "hashCode", "toString", "StremioAddon"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Seasons {

        @Nullable
        private final String airDate;

        @Nullable
        private final Integer id;

        @Nullable
        private final String name;

        @Nullable
        private final Integer seasonNumber;

        public Seasons() {
            this(null, null, null, null, 15, null);
        }

        public static /* synthetic */ Seasons copy$default(Seasons seasons, Integer num, String str, Integer num2, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                num = seasons.id;
            }
            if ((i & 2) != 0) {
                str = seasons.name;
            }
            if ((i & 4) != 0) {
                num2 = seasons.seasonNumber;
            }
            if ((i & 8) != 0) {
                str2 = seasons.airDate;
            }
            return seasons.copy(num, str, num2, str2);
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
        public final Integer getSeasonNumber() {
            return this.seasonNumber;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getAirDate() {
            return this.airDate;
        }

        @NotNull
        public final Seasons copy(@JsonProperty("id") @Nullable Integer id, @JsonProperty("name") @Nullable String name, @JsonProperty("season_number") @Nullable Integer seasonNumber, @JsonProperty("air_date") @Nullable String airDate) {
            return new Seasons(id, name, seasonNumber, airDate);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Seasons)) {
                return false;
            }
            Seasons seasons = (Seasons) other;
            return Intrinsics.areEqual(this.id, seasons.id) && Intrinsics.areEqual(this.name, seasons.name) && Intrinsics.areEqual(this.seasonNumber, seasons.seasonNumber) && Intrinsics.areEqual(this.airDate, seasons.airDate);
        }

        public int hashCode() {
            return ((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.seasonNumber == null ? 0 : this.seasonNumber.hashCode())) * 31) + (this.airDate != null ? this.airDate.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Seasons(id=" + this.id + ", name=" + this.name + ", seasonNumber=" + this.seasonNumber + ", airDate=" + this.airDate + ')';
        }

        public Seasons(@JsonProperty("id") @Nullable Integer id, @JsonProperty("name") @Nullable String name, @JsonProperty("season_number") @Nullable Integer seasonNumber, @JsonProperty("air_date") @Nullable String airDate) {
            this.id = id;
            this.name = name;
            this.seasonNumber = seasonNumber;
            this.airDate = airDate;
        }

        public /* synthetic */ Seasons(Integer num, String str, Integer num2, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : str2);
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
        public final Integer getSeasonNumber() {
            return this.seasonNumber;
        }

        @Nullable
        public final String getAirDate() {
            return this.airDate;
        }
    }

    /* JADX INFO: compiled from: StremioAddon.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B£\u0001\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t\u0012\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003Jª\u0001\u0010 \u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t2\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n2\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f2\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000eHÆ\u0001¢\u0006\u0002\u0010!J\u0014\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010%\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010&\u001a\u00020\u0007HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015¨\u0006'"}, d2 = {"Lcom/phisher98/StremioAddon$Cast;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "name", "", "originalName", "original_name", "character", "knownForDepartment", "known_for_department", "profilePath", "profile_path", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "getOriginalName", "getCharacter", "getKnownForDepartment", "getProfilePath", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/phisher98/StremioAddon$Cast;", "equals", "", "other", "hashCode", "toString", "StremioAddon"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Cast {

        @Nullable
        private final String character;

        @Nullable
        private final Integer id;

        @Nullable
        private final String knownForDepartment;

        @Nullable
        private final String name;

        @Nullable
        private final String originalName;

        @Nullable
        private final String profilePath;

        public Cast() {
            this(null, null, null, null, null, null, 63, null);
        }

        public static /* synthetic */ Cast copy$default(Cast cast, Integer num, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
            if ((i & 1) != 0) {
                num = cast.id;
            }
            if ((i & 2) != 0) {
                str = cast.name;
            }
            if ((i & 4) != 0) {
                str2 = cast.originalName;
            }
            if ((i & 8) != 0) {
                str3 = cast.character;
            }
            if ((i & 16) != 0) {
                str4 = cast.knownForDepartment;
            }
            if ((i & 32) != 0) {
                str5 = cast.profilePath;
            }
            String str6 = str4;
            String str7 = str5;
            return cast.copy(num, str, str2, str3, str6, str7);
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
        public final String getOriginalName() {
            return this.originalName;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getCharacter() {
            return this.character;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getKnownForDepartment() {
            return this.knownForDepartment;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getProfilePath() {
            return this.profilePath;
        }

        @NotNull
        public final Cast copy(@JsonProperty("id") @Nullable Integer id, @JsonProperty("name") @Nullable String name, @JsonProperty("original_name") @Nullable String originalName, @JsonProperty("character") @Nullable String character, @JsonProperty("known_for_department") @Nullable String knownForDepartment, @JsonProperty("profile_path") @Nullable String profilePath) {
            return new Cast(id, name, originalName, character, knownForDepartment, profilePath);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Cast)) {
                return false;
            }
            Cast cast = (Cast) other;
            return Intrinsics.areEqual(this.id, cast.id) && Intrinsics.areEqual(this.name, cast.name) && Intrinsics.areEqual(this.originalName, cast.originalName) && Intrinsics.areEqual(this.character, cast.character) && Intrinsics.areEqual(this.knownForDepartment, cast.knownForDepartment) && Intrinsics.areEqual(this.profilePath, cast.profilePath);
        }

        public int hashCode() {
            return ((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.originalName == null ? 0 : this.originalName.hashCode())) * 31) + (this.character == null ? 0 : this.character.hashCode())) * 31) + (this.knownForDepartment == null ? 0 : this.knownForDepartment.hashCode())) * 31) + (this.profilePath != null ? this.profilePath.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Cast(id=" + this.id + ", name=" + this.name + ", originalName=" + this.originalName + ", character=" + this.character + ", knownForDepartment=" + this.knownForDepartment + ", profilePath=" + this.profilePath + ')';
        }

        public Cast(@JsonProperty("id") @Nullable Integer id, @JsonProperty("name") @Nullable String name, @JsonProperty("original_name") @Nullable String originalName, @JsonProperty("character") @Nullable String character, @JsonProperty("known_for_department") @Nullable String knownForDepartment, @JsonProperty("profile_path") @Nullable String profilePath) {
            this.id = id;
            this.name = name;
            this.originalName = originalName;
            this.character = character;
            this.knownForDepartment = knownForDepartment;
            this.profilePath = profilePath;
        }

        public /* synthetic */ Cast(Integer num, String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5);
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
        public final String getOriginalName() {
            return this.originalName;
        }

        @Nullable
        public final String getCharacter() {
            return this.character;
        }

        @Nullable
        public final String getKnownForDepartment() {
            return this.knownForDepartment;
        }

        @Nullable
        public final String getProfilePath() {
            return this.profilePath;
        }
    }

    /* JADX INFO: compiled from: StremioAddon.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bñ\u0001\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r\u0012\u0018\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u000f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u0012\u0018\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0012\u0012\u0018\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010&\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010+\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018Jø\u0001\u0010.\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n2\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f2\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r2\u0018\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u000f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00102\u0018\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00122\u0018\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0014HÆ\u0001¢\u0006\u0002\u0010/J\u0014\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00103\u001a\u00020\u0003HÖ\u0081\u0004J\n\u00104\u001a\u00020\u0007HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001f\u0010\u0018R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b#\u0010\u0018R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b$\u0010\u0018¨\u00065"}, d2 = {"Lcom/phisher98/StremioAddon$Episodes;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "name", "", "overview", "airDate", "air_date", "stillPath", "still_path", "runtime", "voteAverage", "", "vote_average", "episodeNumber", "episode_number", "seasonNumber", "season_number", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "getOverview", "getAirDate", "getStillPath", "getRuntime", "getVoteAverage", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getEpisodeNumber", "getSeasonNumber", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/phisher98/StremioAddon$Episodes;", "equals", "", "other", "hashCode", "toString", "StremioAddon"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Episodes {

        @Nullable
        private final String airDate;

        @Nullable
        private final Integer episodeNumber;

        @Nullable
        private final Integer id;

        @Nullable
        private final String name;

        @Nullable
        private final String overview;

        @Nullable
        private final Integer runtime;

        @Nullable
        private final Integer seasonNumber;

        @Nullable
        private final String stillPath;

        @Nullable
        private final Double voteAverage;

        public Episodes() {
            this(null, null, null, null, null, null, null, null, null, 511, null);
        }

        public static /* synthetic */ Episodes copy$default(Episodes episodes, Integer num, String str, String str2, String str3, String str4, Integer num2, Double d, Integer num3, Integer num4, int i, Object obj) {
            if ((i & 1) != 0) {
                num = episodes.id;
            }
            if ((i & 2) != 0) {
                str = episodes.name;
            }
            if ((i & 4) != 0) {
                str2 = episodes.overview;
            }
            if ((i & 8) != 0) {
                str3 = episodes.airDate;
            }
            if ((i & 16) != 0) {
                str4 = episodes.stillPath;
            }
            if ((i & 32) != 0) {
                num2 = episodes.runtime;
            }
            if ((i & 64) != 0) {
                d = episodes.voteAverage;
            }
            if ((i & 128) != 0) {
                num3 = episodes.episodeNumber;
            }
            if ((i & 256) != 0) {
                num4 = episodes.seasonNumber;
            }
            Integer num5 = num3;
            Integer num6 = num4;
            Integer num7 = num2;
            Double d2 = d;
            String str5 = str4;
            String str6 = str2;
            return episodes.copy(num, str, str6, str3, str5, num7, d2, num5, num6);
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
        public final String getOverview() {
            return this.overview;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getAirDate() {
            return this.airDate;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getStillPath() {
            return this.stillPath;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Integer getRuntime() {
            return this.runtime;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Double getVoteAverage() {
            return this.voteAverage;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Integer getEpisodeNumber() {
            return this.episodeNumber;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final Integer getSeasonNumber() {
            return this.seasonNumber;
        }

        @NotNull
        public final Episodes copy(@JsonProperty("id") @Nullable Integer id, @JsonProperty("name") @Nullable String name, @JsonProperty("overview") @Nullable String overview, @JsonProperty("air_date") @Nullable String airDate, @JsonProperty("still_path") @Nullable String stillPath, @JsonProperty("runtime") @Nullable Integer runtime, @JsonProperty("vote_average") @Nullable Double voteAverage, @JsonProperty("episode_number") @Nullable Integer episodeNumber, @JsonProperty("season_number") @Nullable Integer seasonNumber) {
            return new Episodes(id, name, overview, airDate, stillPath, runtime, voteAverage, episodeNumber, seasonNumber);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Episodes)) {
                return false;
            }
            Episodes episodes = (Episodes) other;
            return Intrinsics.areEqual(this.id, episodes.id) && Intrinsics.areEqual(this.name, episodes.name) && Intrinsics.areEqual(this.overview, episodes.overview) && Intrinsics.areEqual(this.airDate, episodes.airDate) && Intrinsics.areEqual(this.stillPath, episodes.stillPath) && Intrinsics.areEqual(this.runtime, episodes.runtime) && Intrinsics.areEqual(this.voteAverage, episodes.voteAverage) && Intrinsics.areEqual(this.episodeNumber, episodes.episodeNumber) && Intrinsics.areEqual(this.seasonNumber, episodes.seasonNumber);
        }

        public int hashCode() {
            return ((((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.overview == null ? 0 : this.overview.hashCode())) * 31) + (this.airDate == null ? 0 : this.airDate.hashCode())) * 31) + (this.stillPath == null ? 0 : this.stillPath.hashCode())) * 31) + (this.runtime == null ? 0 : this.runtime.hashCode())) * 31) + (this.voteAverage == null ? 0 : this.voteAverage.hashCode())) * 31) + (this.episodeNumber == null ? 0 : this.episodeNumber.hashCode())) * 31) + (this.seasonNumber != null ? this.seasonNumber.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Episodes(id=" + this.id + ", name=" + this.name + ", overview=" + this.overview + ", airDate=" + this.airDate + ", stillPath=" + this.stillPath + ", runtime=" + this.runtime + ", voteAverage=" + this.voteAverage + ", episodeNumber=" + this.episodeNumber + ", seasonNumber=" + this.seasonNumber + ')';
        }

        public Episodes(@JsonProperty("id") @Nullable Integer id, @JsonProperty("name") @Nullable String name, @JsonProperty("overview") @Nullable String overview, @JsonProperty("air_date") @Nullable String airDate, @JsonProperty("still_path") @Nullable String stillPath, @JsonProperty("runtime") @Nullable Integer runtime, @JsonProperty("vote_average") @Nullable Double voteAverage, @JsonProperty("episode_number") @Nullable Integer episodeNumber, @JsonProperty("season_number") @Nullable Integer seasonNumber) {
            this.id = id;
            this.name = name;
            this.overview = overview;
            this.airDate = airDate;
            this.stillPath = stillPath;
            this.runtime = runtime;
            this.voteAverage = voteAverage;
            this.episodeNumber = episodeNumber;
            this.seasonNumber = seasonNumber;
        }

        public /* synthetic */ Episodes(Integer num, String str, String str2, String str3, String str4, Integer num2, Double d, Integer num3, Integer num4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : num2, (i & 64) != 0 ? null : d, (i & 128) != 0 ? null : num3, (i & 256) != 0 ? null : num4);
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
        public final String getOverview() {
            return this.overview;
        }

        @Nullable
        public final String getAirDate() {
            return this.airDate;
        }

        @Nullable
        public final String getStillPath() {
            return this.stillPath;
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
        public final Integer getEpisodeNumber() {
            return this.episodeNumber;
        }

        @Nullable
        public final Integer getSeasonNumber() {
            return this.seasonNumber;
        }
    }

    /* JADX INFO: compiled from: StremioAddon.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J5\u0010\r\u001a\u00020\u00002*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R%\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/phisher98/StremioAddon$MediaDetailEpisodes;", "", "episodes", "Ljava/util/ArrayList;", "Lcom/phisher98/StremioAddon$Episodes;", "Lkotlin/collections/ArrayList;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Ljava/util/ArrayList;)V", "getEpisodes", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "StremioAddon"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class MediaDetailEpisodes {

        @Nullable
        private final ArrayList<Episodes> episodes;

        /* JADX WARN: Illegal instructions before constructor call */
        public MediaDetailEpisodes() {
            ArrayList arrayList = null;
            this(arrayList, 1, arrayList);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MediaDetailEpisodes copy$default(MediaDetailEpisodes mediaDetailEpisodes, ArrayList arrayList, int i, Object obj) {
            if ((i & 1) != 0) {
                arrayList = mediaDetailEpisodes.episodes;
            }
            return mediaDetailEpisodes.copy(arrayList);
        }

        @Nullable
        public final ArrayList<Episodes> component1() {
            return this.episodes;
        }

        @NotNull
        public final MediaDetailEpisodes copy(@JsonProperty("episodes") @Nullable ArrayList<Episodes> episodes) {
            return new MediaDetailEpisodes(episodes);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof MediaDetailEpisodes) && Intrinsics.areEqual(this.episodes, ((MediaDetailEpisodes) other).episodes);
        }

        public int hashCode() {
            if (this.episodes == null) {
                return 0;
            }
            return this.episodes.hashCode();
        }

        @NotNull
        public String toString() {
            return "MediaDetailEpisodes(episodes=" + this.episodes + ')';
        }

        public MediaDetailEpisodes(@JsonProperty("episodes") @Nullable ArrayList<Episodes> arrayList) {
            this.episodes = arrayList;
        }

        public /* synthetic */ MediaDetailEpisodes(ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new ArrayList() : arrayList);
        }

        @Nullable
        public final ArrayList<Episodes> getEpisodes() {
            return this.episodes;
        }
    }

    /* JADX INFO: compiled from: StremioAddon.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J#\u0010\u000b\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/phisher98/StremioAddon$Trailers;", "", "key", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "StremioAddon"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Trailers {

        @Nullable
        private final String key;

        /* JADX WARN: Illegal instructions before constructor call */
        public Trailers() {
            String str = null;
            this(str, 1, str);
        }

        public static /* synthetic */ Trailers copy$default(Trailers trailers, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = trailers.key;
            }
            return trailers.copy(str);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getKey() {
            return this.key;
        }

        @NotNull
        public final Trailers copy(@JsonProperty("key") @Nullable String key) {
            return new Trailers(key);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Trailers) && Intrinsics.areEqual(this.key, ((Trailers) other).key);
        }

        public int hashCode() {
            if (this.key == null) {
                return 0;
            }
            return this.key.hashCode();
        }

        @NotNull
        public String toString() {
            return "Trailers(key=" + this.key + ')';
        }

        public Trailers(@JsonProperty("key") @Nullable String key) {
            this.key = key;
        }

        public /* synthetic */ Trailers(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str);
        }

        @Nullable
        public final String getKey() {
            return this.key;
        }
    }

    /* JADX INFO: compiled from: StremioAddon.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J5\u0010\r\u001a\u00020\u00002*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R%\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/phisher98/StremioAddon$ResultsTrailer;", "", "results", "Ljava/util/ArrayList;", "Lcom/phisher98/StremioAddon$Trailers;", "Lkotlin/collections/ArrayList;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Ljava/util/ArrayList;)V", "getResults", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "StremioAddon"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class ResultsTrailer {

        @Nullable
        private final ArrayList<Trailers> results;

        /* JADX WARN: Illegal instructions before constructor call */
        public ResultsTrailer() {
            ArrayList arrayList = null;
            this(arrayList, 1, arrayList);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ResultsTrailer copy$default(ResultsTrailer resultsTrailer, ArrayList arrayList, int i, Object obj) {
            if ((i & 1) != 0) {
                arrayList = resultsTrailer.results;
            }
            return resultsTrailer.copy(arrayList);
        }

        @Nullable
        public final ArrayList<Trailers> component1() {
            return this.results;
        }

        @NotNull
        public final ResultsTrailer copy(@JsonProperty("results") @Nullable ArrayList<Trailers> results) {
            return new ResultsTrailer(results);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ResultsTrailer) && Intrinsics.areEqual(this.results, ((ResultsTrailer) other).results);
        }

        public int hashCode() {
            if (this.results == null) {
                return 0;
            }
            return this.results.hashCode();
        }

        @NotNull
        public String toString() {
            return "ResultsTrailer(results=" + this.results + ')';
        }

        public ResultsTrailer(@JsonProperty("results") @Nullable ArrayList<Trailers> arrayList) {
            this.results = arrayList;
        }

        public /* synthetic */ ResultsTrailer(ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new ArrayList() : arrayList);
        }

        @Nullable
        public final ArrayList<Trailers> getResults() {
            return this.results;
        }
    }

    /* JADX INFO: compiled from: StremioAddon.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J=\u0010\u000e\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/phisher98/StremioAddon$ExternalIds;", "", "imdb_id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "tvdb_id", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getImdb_id", "()Ljava/lang/String;", "getTvdb_id", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "StremioAddon"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class ExternalIds {

        @Nullable
        private final String imdb_id;

        @Nullable
        private final String tvdb_id;

        /* JADX WARN: Illegal instructions before constructor call */
        public ExternalIds() {
            String str = null;
            this(str, str, 3, str);
        }

        public static /* synthetic */ ExternalIds copy$default(ExternalIds externalIds, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = externalIds.imdb_id;
            }
            if ((i & 2) != 0) {
                str2 = externalIds.tvdb_id;
            }
            return externalIds.copy(str, str2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getImdb_id() {
            return this.imdb_id;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTvdb_id() {
            return this.tvdb_id;
        }

        @NotNull
        public final ExternalIds copy(@JsonProperty("imdb_id") @Nullable String imdb_id, @JsonProperty("tvdb_id") @Nullable String tvdb_id) {
            return new ExternalIds(imdb_id, tvdb_id);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ExternalIds)) {
                return false;
            }
            ExternalIds externalIds = (ExternalIds) other;
            return Intrinsics.areEqual(this.imdb_id, externalIds.imdb_id) && Intrinsics.areEqual(this.tvdb_id, externalIds.tvdb_id);
        }

        public int hashCode() {
            return ((this.imdb_id == null ? 0 : this.imdb_id.hashCode()) * 31) + (this.tvdb_id != null ? this.tvdb_id.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "ExternalIds(imdb_id=" + this.imdb_id + ", tvdb_id=" + this.tvdb_id + ')';
        }

        public ExternalIds(@JsonProperty("imdb_id") @Nullable String imdb_id, @JsonProperty("tvdb_id") @Nullable String tvdb_id) {
            this.imdb_id = imdb_id;
            this.tvdb_id = tvdb_id;
        }

        public /* synthetic */ ExternalIds(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }

        @Nullable
        public final String getImdb_id() {
            return this.imdb_id;
        }

        @Nullable
        public final String getTvdb_id() {
            return this.tvdb_id;
        }
    }

    /* JADX INFO: compiled from: StremioAddon.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J5\u0010\r\u001a\u00020\u00002*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R%\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/phisher98/StremioAddon$Credits;", "", "cast", "Ljava/util/ArrayList;", "Lcom/phisher98/StremioAddon$Cast;", "Lkotlin/collections/ArrayList;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Ljava/util/ArrayList;)V", "getCast", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "StremioAddon"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Credits {

        @Nullable
        private final ArrayList<Cast> cast;

        /* JADX WARN: Illegal instructions before constructor call */
        public Credits() {
            ArrayList arrayList = null;
            this(arrayList, 1, arrayList);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Credits copy$default(Credits credits, ArrayList arrayList, int i, Object obj) {
            if ((i & 1) != 0) {
                arrayList = credits.cast;
            }
            return credits.copy(arrayList);
        }

        @Nullable
        public final ArrayList<Cast> component1() {
            return this.cast;
        }

        @NotNull
        public final Credits copy(@JsonProperty("cast") @Nullable ArrayList<Cast> cast) {
            return new Credits(cast);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Credits) && Intrinsics.areEqual(this.cast, ((Credits) other).cast);
        }

        public int hashCode() {
            if (this.cast == null) {
                return 0;
            }
            return this.cast.hashCode();
        }

        @NotNull
        public String toString() {
            return "Credits(cast=" + this.cast + ')';
        }

        public Credits(@JsonProperty("cast") @Nullable ArrayList<Cast> arrayList) {
            this.cast = arrayList;
        }

        public /* synthetic */ Credits(ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new ArrayList() : arrayList);
        }

        @Nullable
        public final ArrayList<Cast> getCast() {
            return this.cast;
        }
    }

    /* JADX INFO: compiled from: StremioAddon.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J5\u0010\r\u001a\u00020\u00002*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R%\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/phisher98/StremioAddon$ResultsRecommendations;", "", "results", "Ljava/util/ArrayList;", "Lcom/phisher98/StremioAddon$Media;", "Lkotlin/collections/ArrayList;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Ljava/util/ArrayList;)V", "getResults", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "StremioAddon"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class ResultsRecommendations {

        @Nullable
        private final ArrayList<Media> results;

        /* JADX WARN: Illegal instructions before constructor call */
        public ResultsRecommendations() {
            ArrayList arrayList = null;
            this(arrayList, 1, arrayList);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ResultsRecommendations copy$default(ResultsRecommendations resultsRecommendations, ArrayList arrayList, int i, Object obj) {
            if ((i & 1) != 0) {
                arrayList = resultsRecommendations.results;
            }
            return resultsRecommendations.copy(arrayList);
        }

        @Nullable
        public final ArrayList<Media> component1() {
            return this.results;
        }

        @NotNull
        public final ResultsRecommendations copy(@JsonProperty("results") @Nullable ArrayList<Media> results) {
            return new ResultsRecommendations(results);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ResultsRecommendations) && Intrinsics.areEqual(this.results, ((ResultsRecommendations) other).results);
        }

        public int hashCode() {
            if (this.results == null) {
                return 0;
            }
            return this.results.hashCode();
        }

        @NotNull
        public String toString() {
            return "ResultsRecommendations(results=" + this.results + ')';
        }

        public ResultsRecommendations(@JsonProperty("results") @Nullable ArrayList<Media> arrayList) {
            this.results = arrayList;
        }

        public /* synthetic */ ResultsRecommendations(ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new ArrayList() : arrayList);
        }

        @Nullable
        public final ArrayList<Media> getResults() {
            return this.results;
        }
    }

    /* JADX INFO: compiled from: StremioAddon.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJB\u0010\u000f\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/phisher98/StremioAddon$LastEpisodeToAir;", "", "episode_number", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "season_number", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getEpisode_number", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSeason_number", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/phisher98/StremioAddon$LastEpisodeToAir;", "equals", "", "other", "hashCode", "toString", "", "StremioAddon"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class LastEpisodeToAir {

        @Nullable
        private final Integer episode_number;

        @Nullable
        private final Integer season_number;

        /* JADX WARN: Illegal instructions before constructor call */
        public LastEpisodeToAir() {
            Integer num = null;
            this(num, num, 3, num);
        }

        public static /* synthetic */ LastEpisodeToAir copy$default(LastEpisodeToAir lastEpisodeToAir, Integer num, Integer num2, int i, Object obj) {
            if ((i & 1) != 0) {
                num = lastEpisodeToAir.episode_number;
            }
            if ((i & 2) != 0) {
                num2 = lastEpisodeToAir.season_number;
            }
            return lastEpisodeToAir.copy(num, num2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getEpisode_number() {
            return this.episode_number;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getSeason_number() {
            return this.season_number;
        }

        @NotNull
        public final LastEpisodeToAir copy(@JsonProperty("episode_number") @Nullable Integer episode_number, @JsonProperty("season_number") @Nullable Integer season_number) {
            return new LastEpisodeToAir(episode_number, season_number);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LastEpisodeToAir)) {
                return false;
            }
            LastEpisodeToAir lastEpisodeToAir = (LastEpisodeToAir) other;
            return Intrinsics.areEqual(this.episode_number, lastEpisodeToAir.episode_number) && Intrinsics.areEqual(this.season_number, lastEpisodeToAir.season_number);
        }

        public int hashCode() {
            return ((this.episode_number == null ? 0 : this.episode_number.hashCode()) * 31) + (this.season_number != null ? this.season_number.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "LastEpisodeToAir(episode_number=" + this.episode_number + ", season_number=" + this.season_number + ')';
        }

        public LastEpisodeToAir(@JsonProperty("episode_number") @Nullable Integer episode_number, @JsonProperty("season_number") @Nullable Integer season_number) {
            this.episode_number = episode_number;
            this.season_number = season_number;
        }

        public /* synthetic */ LastEpisodeToAir(Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2);
        }

        @Nullable
        public final Integer getEpisode_number() {
            return this.episode_number;
        }

        @Nullable
        public final Integer getSeason_number() {
            return this.season_number;
        }
    }

    /* JADX INFO: compiled from: StremioAddon.kt */
    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b>\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0081\u0005\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t\u0012\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e\u0012\u0018\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u0012\u0018\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0012\u0012\u0018\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0014\u0012\u0018\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0016\u0012\u0018\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0017\u0012\u0018\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0018\u0012\u0018\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\u0001:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0019\u0012\u0018\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001a\u0012\u0018\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001b\u0012*\b\u0003\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dj\n\u0012\u0004\u0012\u00020\u001e\u0018\u0001`\u001f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001c\u0012\u0018\b\u0003\u0010 \u001a\u0004\u0018\u00010!:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b( \u0012\u0018\b\u0003\u0010\"\u001a\u0004\u0018\u00010#:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\"\u0012*\b\u0003\u0010$\u001a\u0016\u0012\u0004\u0012\u00020%\u0018\u00010\u001dj\n\u0012\u0004\u0012\u00020%\u0018\u0001`\u001f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b($\u0012\u0018\b\u0003\u0010&\u001a\u0004\u0018\u00010':\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(&\u0012\u0018\b\u0003\u0010(\u001a\u0004\u0018\u00010):\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b((\u0012\u0018\b\u0003\u0010*\u001a\u0004\u0018\u00010+:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(*\u0012\u0018\b\u0003\u0010,\u001a\u0004\u0018\u00010-:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(,¢\u0006\u0004\b.\u0010/J\u0010\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00101J\u000b\u0010S\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010]\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00101J\u000b\u0010^\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u001d\u0010a\u001a\u0016\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dj\n\u0012\u0004\u0012\u00020\u001e\u0018\u0001`\u001fHÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010!HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010#HÆ\u0003J\u001d\u0010d\u001a\u0016\u0012\u0004\u0012\u00020%\u0018\u00010\u001dj\n\u0012\u0004\u0012\u00020%\u0018\u0001`\u001fHÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010'HÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010)HÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010+HÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010-HÆ\u0003J\u0088\u0005\u0010i\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t2\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n2\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f2\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e2\u0018\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00102\u0018\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00122\u0018\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00142\u0018\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00162\u0018\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00172\u0018\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00182\u0018\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\u0001:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00192\u0018\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001a2\u0018\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001b2*\b\u0003\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dj\n\u0012\u0004\u0012\u00020\u001e\u0018\u0001`\u001f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001c2\u0018\b\u0003\u0010 \u001a\u0004\u0018\u00010!:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b( 2\u0018\b\u0003\u0010\"\u001a\u0004\u0018\u00010#:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\"2*\b\u0003\u0010$\u001a\u0016\u0012\u0004\u0012\u00020%\u0018\u00010\u001dj\n\u0012\u0004\u0012\u00020%\u0018\u0001`\u001f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b($2\u0018\b\u0003\u0010&\u001a\u0004\u0018\u00010':\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(&2\u0018\b\u0003\u0010(\u001a\u0004\u0018\u00010):\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b((2\u0018\b\u0003\u0010*\u001a\u0004\u0018\u00010+:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(*2\u0018\b\u0003\u0010,\u001a\u0004\u0018\u00010-:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(,HÆ\u0001¢\u0006\u0002\u0010jJ\u0014\u0010k\u001a\u00020l2\b\u0010m\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010n\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010o\u001a\u00020\u0007HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00102\u001a\u0004\b0\u00101R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b5\u00104R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b6\u00104R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b7\u00104R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b8\u00104R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b9\u00104R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b:\u00104R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b;\u00104R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b<\u00104R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b=\u00104R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00102\u001a\u0004\b>\u00101R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bA\u00104R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bB\u00104R%\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dj\n\u0012\u0004\u0012\u00020\u001e\u0018\u0001`\u001f¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0013\u0010 \u001a\u0004\u0018\u00010!¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u0013\u0010\"\u001a\u0004\u0018\u00010#¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR%\u0010$\u001a\u0016\u0012\u0004\u0012\u00020%\u0018\u00010\u001dj\n\u0012\u0004\u0012\u00020%\u0018\u0001`\u001f¢\u0006\b\n\u0000\u001a\u0004\bI\u0010DR\u0013\u0010&\u001a\u0004\u0018\u00010'¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u0013\u0010(\u001a\u0004\u0018\u00010)¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u0013\u0010*\u001a\u0004\u0018\u00010+¢\u0006\b\n\u0000\u001a\u0004\bN\u0010OR\u0013\u0010,\u001a\u0004\u0018\u00010-¢\u0006\b\n\u0000\u001a\u0004\bP\u0010Q¨\u0006p"}, d2 = {"Lcom/phisher98/StremioAddon$MediaDetail;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "imdbId", "", "imdb_id", "title", "name", "originalTitle", "original_title", "originalName", "original_name", "posterPath", "poster_path", "backdropPath", "backdrop_path", "releaseDate", "release_date", "firstAirDate", "first_air_date", "overview", "runtime", "vote_average", "original_language", "status", "genres", "Ljava/util/ArrayList;", "Lcom/phisher98/StremioAddon$Genres;", "Lkotlin/collections/ArrayList;", "keywords", "Lcom/phisher98/StremioAddon$KeywordResults;", "last_episode_to_air", "Lcom/phisher98/StremioAddon$LastEpisodeToAir;", "seasons", "Lcom/phisher98/StremioAddon$Seasons;", "videos", "Lcom/phisher98/StremioAddon$ResultsTrailer;", "external_ids", "Lcom/phisher98/StremioAddon$ExternalIds;", "credits", "Lcom/phisher98/StremioAddon$Credits;", "recommendations", "Lcom/phisher98/StremioAddon$ResultsRecommendations;", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Lcom/phisher98/StremioAddon$KeywordResults;Lcom/phisher98/StremioAddon$LastEpisodeToAir;Ljava/util/ArrayList;Lcom/phisher98/StremioAddon$ResultsTrailer;Lcom/phisher98/StremioAddon$ExternalIds;Lcom/phisher98/StremioAddon$Credits;Lcom/phisher98/StremioAddon$ResultsRecommendations;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getImdbId", "()Ljava/lang/String;", "getTitle", "getName", "getOriginalTitle", "getOriginalName", "getPosterPath", "getBackdropPath", "getReleaseDate", "getFirstAirDate", "getOverview", "getRuntime", "getVote_average", "()Ljava/lang/Object;", "getOriginal_language", "getStatus", "getGenres", "()Ljava/util/ArrayList;", "getKeywords", "()Lcom/phisher98/StremioAddon$KeywordResults;", "getLast_episode_to_air", "()Lcom/phisher98/StremioAddon$LastEpisodeToAir;", "getSeasons", "getVideos", "()Lcom/phisher98/StremioAddon$ResultsTrailer;", "getExternal_ids", "()Lcom/phisher98/StremioAddon$ExternalIds;", "getCredits", "()Lcom/phisher98/StremioAddon$Credits;", "getRecommendations", "()Lcom/phisher98/StremioAddon$ResultsRecommendations;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Lcom/phisher98/StremioAddon$KeywordResults;Lcom/phisher98/StremioAddon$LastEpisodeToAir;Ljava/util/ArrayList;Lcom/phisher98/StremioAddon$ResultsTrailer;Lcom/phisher98/StremioAddon$ExternalIds;Lcom/phisher98/StremioAddon$Credits;Lcom/phisher98/StremioAddon$ResultsRecommendations;)Lcom/phisher98/StremioAddon$MediaDetail;", "equals", "", "other", "hashCode", "toString", "StremioAddon"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class MediaDetail {

        @Nullable
        private final String backdropPath;

        @Nullable
        private final Credits credits;

        @Nullable
        private final ExternalIds external_ids;

        @Nullable
        private final String firstAirDate;

        @Nullable
        private final ArrayList<Genres> genres;

        @Nullable
        private final Integer id;

        @Nullable
        private final String imdbId;

        @Nullable
        private final KeywordResults keywords;

        @Nullable
        private final LastEpisodeToAir last_episode_to_air;

        @Nullable
        private final String name;

        @Nullable
        private final String originalName;

        @Nullable
        private final String originalTitle;

        @Nullable
        private final String original_language;

        @Nullable
        private final String overview;

        @Nullable
        private final String posterPath;

        @Nullable
        private final ResultsRecommendations recommendations;

        @Nullable
        private final String releaseDate;

        @Nullable
        private final Integer runtime;

        @Nullable
        private final ArrayList<Seasons> seasons;

        @Nullable
        private final String status;

        @Nullable
        private final String title;

        @Nullable
        private final ResultsTrailer videos;

        @Nullable
        private final Object vote_average;

        public MediaDetail() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 8388607, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MediaDetail copy$default(MediaDetail mediaDetail, Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Integer num2, Object obj, String str11, String str12, ArrayList arrayList, KeywordResults keywordResults, LastEpisodeToAir lastEpisodeToAir, ArrayList arrayList2, ResultsTrailer resultsTrailer, ExternalIds externalIds, Credits credits, ResultsRecommendations resultsRecommendations, int i, Object obj2) {
            ResultsRecommendations resultsRecommendations2;
            Credits credits2;
            Integer num3 = (i & 1) != 0 ? mediaDetail.id : num;
            String str13 = (i & 2) != 0 ? mediaDetail.imdbId : str;
            String str14 = (i & 4) != 0 ? mediaDetail.title : str2;
            String str15 = (i & 8) != 0 ? mediaDetail.name : str3;
            String str16 = (i & 16) != 0 ? mediaDetail.originalTitle : str4;
            String str17 = (i & 32) != 0 ? mediaDetail.originalName : str5;
            String str18 = (i & 64) != 0 ? mediaDetail.posterPath : str6;
            String str19 = (i & 128) != 0 ? mediaDetail.backdropPath : str7;
            String str20 = (i & 256) != 0 ? mediaDetail.releaseDate : str8;
            String str21 = (i & 512) != 0 ? mediaDetail.firstAirDate : str9;
            String str22 = (i & 1024) != 0 ? mediaDetail.overview : str10;
            Integer num4 = (i & 2048) != 0 ? mediaDetail.runtime : num2;
            Object obj3 = (i & 4096) != 0 ? mediaDetail.vote_average : obj;
            String str23 = (i & 8192) != 0 ? mediaDetail.original_language : str11;
            Integer num5 = num3;
            String str24 = (i & 16384) != 0 ? mediaDetail.status : str12;
            ArrayList arrayList3 = (i & 32768) != 0 ? mediaDetail.genres : arrayList;
            KeywordResults keywordResults2 = (i & 65536) != 0 ? mediaDetail.keywords : keywordResults;
            LastEpisodeToAir lastEpisodeToAir2 = (i & 131072) != 0 ? mediaDetail.last_episode_to_air : lastEpisodeToAir;
            ArrayList arrayList4 = (i & 262144) != 0 ? mediaDetail.seasons : arrayList2;
            ResultsTrailer resultsTrailer2 = (i & 524288) != 0 ? mediaDetail.videos : resultsTrailer;
            ExternalIds externalIds2 = (i & 1048576) != 0 ? mediaDetail.external_ids : externalIds;
            Credits credits3 = (i & 2097152) != 0 ? mediaDetail.credits : credits;
            if ((i & 4194304) != 0) {
                credits2 = credits3;
                resultsRecommendations2 = mediaDetail.recommendations;
            } else {
                resultsRecommendations2 = resultsRecommendations;
                credits2 = credits3;
            }
            return mediaDetail.copy(num5, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, num4, obj3, str23, str24, arrayList3, keywordResults2, lastEpisodeToAir2, arrayList4, resultsTrailer2, externalIds2, credits2, resultsRecommendations2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component10, reason: from getter */
        public final String getFirstAirDate() {
            return this.firstAirDate;
        }

        @Nullable
        /* JADX INFO: renamed from: component11, reason: from getter */
        public final String getOverview() {
            return this.overview;
        }

        @Nullable
        /* JADX INFO: renamed from: component12, reason: from getter */
        public final Integer getRuntime() {
            return this.runtime;
        }

        @Nullable
        /* JADX INFO: renamed from: component13, reason: from getter */
        public final Object getVote_average() {
            return this.vote_average;
        }

        @Nullable
        /* JADX INFO: renamed from: component14, reason: from getter */
        public final String getOriginal_language() {
            return this.original_language;
        }

        @Nullable
        /* JADX INFO: renamed from: component15, reason: from getter */
        public final String getStatus() {
            return this.status;
        }

        @Nullable
        public final ArrayList<Genres> component16() {
            return this.genres;
        }

        @Nullable
        /* JADX INFO: renamed from: component17, reason: from getter */
        public final KeywordResults getKeywords() {
            return this.keywords;
        }

        @Nullable
        /* JADX INFO: renamed from: component18, reason: from getter */
        public final LastEpisodeToAir getLast_episode_to_air() {
            return this.last_episode_to_air;
        }

        @Nullable
        public final ArrayList<Seasons> component19() {
            return this.seasons;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getImdbId() {
            return this.imdbId;
        }

        @Nullable
        /* JADX INFO: renamed from: component20, reason: from getter */
        public final ResultsTrailer getVideos() {
            return this.videos;
        }

        @Nullable
        /* JADX INFO: renamed from: component21, reason: from getter */
        public final ExternalIds getExternal_ids() {
            return this.external_ids;
        }

        @Nullable
        /* JADX INFO: renamed from: component22, reason: from getter */
        public final Credits getCredits() {
            return this.credits;
        }

        @Nullable
        /* JADX INFO: renamed from: component23, reason: from getter */
        public final ResultsRecommendations getRecommendations() {
            return this.recommendations;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getName() {
            return this.name;
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
        public final String getPosterPath() {
            return this.posterPath;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getBackdropPath() {
            return this.backdropPath;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getReleaseDate() {
            return this.releaseDate;
        }

        @NotNull
        public final MediaDetail copy(@JsonProperty("id") @Nullable Integer id, @JsonProperty("imdb_id") @Nullable String imdbId, @JsonProperty("title") @Nullable String title, @JsonProperty("name") @Nullable String name, @JsonProperty("original_title") @Nullable String originalTitle, @JsonProperty("original_name") @Nullable String originalName, @JsonProperty("poster_path") @Nullable String posterPath, @JsonProperty("backdrop_path") @Nullable String backdropPath, @JsonProperty("release_date") @Nullable String releaseDate, @JsonProperty("first_air_date") @Nullable String firstAirDate, @JsonProperty("overview") @Nullable String overview, @JsonProperty("runtime") @Nullable Integer runtime, @JsonProperty("vote_average") @Nullable Object vote_average, @JsonProperty("original_language") @Nullable String original_language, @JsonProperty("status") @Nullable String status, @JsonProperty("genres") @Nullable ArrayList<Genres> genres, @JsonProperty("keywords") @Nullable KeywordResults keywords, @JsonProperty("last_episode_to_air") @Nullable LastEpisodeToAir last_episode_to_air, @JsonProperty("seasons") @Nullable ArrayList<Seasons> seasons, @JsonProperty("videos") @Nullable ResultsTrailer videos, @JsonProperty("external_ids") @Nullable ExternalIds external_ids, @JsonProperty("credits") @Nullable Credits credits, @JsonProperty("recommendations") @Nullable ResultsRecommendations recommendations) {
            return new MediaDetail(id, imdbId, title, name, originalTitle, originalName, posterPath, backdropPath, releaseDate, firstAirDate, overview, runtime, vote_average, original_language, status, genres, keywords, last_episode_to_air, seasons, videos, external_ids, credits, recommendations);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MediaDetail)) {
                return false;
            }
            MediaDetail mediaDetail = (MediaDetail) other;
            return Intrinsics.areEqual(this.id, mediaDetail.id) && Intrinsics.areEqual(this.imdbId, mediaDetail.imdbId) && Intrinsics.areEqual(this.title, mediaDetail.title) && Intrinsics.areEqual(this.name, mediaDetail.name) && Intrinsics.areEqual(this.originalTitle, mediaDetail.originalTitle) && Intrinsics.areEqual(this.originalName, mediaDetail.originalName) && Intrinsics.areEqual(this.posterPath, mediaDetail.posterPath) && Intrinsics.areEqual(this.backdropPath, mediaDetail.backdropPath) && Intrinsics.areEqual(this.releaseDate, mediaDetail.releaseDate) && Intrinsics.areEqual(this.firstAirDate, mediaDetail.firstAirDate) && Intrinsics.areEqual(this.overview, mediaDetail.overview) && Intrinsics.areEqual(this.runtime, mediaDetail.runtime) && Intrinsics.areEqual(this.vote_average, mediaDetail.vote_average) && Intrinsics.areEqual(this.original_language, mediaDetail.original_language) && Intrinsics.areEqual(this.status, mediaDetail.status) && Intrinsics.areEqual(this.genres, mediaDetail.genres) && Intrinsics.areEqual(this.keywords, mediaDetail.keywords) && Intrinsics.areEqual(this.last_episode_to_air, mediaDetail.last_episode_to_air) && Intrinsics.areEqual(this.seasons, mediaDetail.seasons) && Intrinsics.areEqual(this.videos, mediaDetail.videos) && Intrinsics.areEqual(this.external_ids, mediaDetail.external_ids) && Intrinsics.areEqual(this.credits, mediaDetail.credits) && Intrinsics.areEqual(this.recommendations, mediaDetail.recommendations);
        }

        public int hashCode() {
            return ((((((((((((((((((((((((((((((((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.imdbId == null ? 0 : this.imdbId.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.originalTitle == null ? 0 : this.originalTitle.hashCode())) * 31) + (this.originalName == null ? 0 : this.originalName.hashCode())) * 31) + (this.posterPath == null ? 0 : this.posterPath.hashCode())) * 31) + (this.backdropPath == null ? 0 : this.backdropPath.hashCode())) * 31) + (this.releaseDate == null ? 0 : this.releaseDate.hashCode())) * 31) + (this.firstAirDate == null ? 0 : this.firstAirDate.hashCode())) * 31) + (this.overview == null ? 0 : this.overview.hashCode())) * 31) + (this.runtime == null ? 0 : this.runtime.hashCode())) * 31) + (this.vote_average == null ? 0 : this.vote_average.hashCode())) * 31) + (this.original_language == null ? 0 : this.original_language.hashCode())) * 31) + (this.status == null ? 0 : this.status.hashCode())) * 31) + (this.genres == null ? 0 : this.genres.hashCode())) * 31) + (this.keywords == null ? 0 : this.keywords.hashCode())) * 31) + (this.last_episode_to_air == null ? 0 : this.last_episode_to_air.hashCode())) * 31) + (this.seasons == null ? 0 : this.seasons.hashCode())) * 31) + (this.videos == null ? 0 : this.videos.hashCode())) * 31) + (this.external_ids == null ? 0 : this.external_ids.hashCode())) * 31) + (this.credits == null ? 0 : this.credits.hashCode())) * 31) + (this.recommendations != null ? this.recommendations.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("MediaDetail(id=").append(this.id).append(", imdbId=").append(this.imdbId).append(", title=").append(this.title).append(", name=").append(this.name).append(", originalTitle=").append(this.originalTitle).append(", originalName=").append(this.originalName).append(", posterPath=").append(this.posterPath).append(", backdropPath=").append(this.backdropPath).append(", releaseDate=").append(this.releaseDate).append(", firstAirDate=").append(this.firstAirDate).append(", overview=").append(this.overview).append(", runtime=");
            sb.append(this.runtime).append(", vote_average=").append(this.vote_average).append(", original_language=").append(this.original_language).append(", status=").append(this.status).append(", genres=").append(this.genres).append(", keywords=").append(this.keywords).append(", last_episode_to_air=").append(this.last_episode_to_air).append(", seasons=").append(this.seasons).append(", videos=").append(this.videos).append(", external_ids=").append(this.external_ids).append(", credits=").append(this.credits).append(", recommendations=").append(this.recommendations);
            sb.append(')');
            return sb.toString();
        }

        public MediaDetail(@JsonProperty("id") @Nullable Integer id, @JsonProperty("imdb_id") @Nullable String imdbId, @JsonProperty("title") @Nullable String title, @JsonProperty("name") @Nullable String name, @JsonProperty("original_title") @Nullable String originalTitle, @JsonProperty("original_name") @Nullable String originalName, @JsonProperty("poster_path") @Nullable String posterPath, @JsonProperty("backdrop_path") @Nullable String backdropPath, @JsonProperty("release_date") @Nullable String releaseDate, @JsonProperty("first_air_date") @Nullable String firstAirDate, @JsonProperty("overview") @Nullable String overview, @JsonProperty("runtime") @Nullable Integer runtime, @JsonProperty("vote_average") @Nullable Object vote_average, @JsonProperty("original_language") @Nullable String original_language, @JsonProperty("status") @Nullable String status, @JsonProperty("genres") @Nullable ArrayList<Genres> arrayList, @JsonProperty("keywords") @Nullable KeywordResults keywords, @JsonProperty("last_episode_to_air") @Nullable LastEpisodeToAir last_episode_to_air, @JsonProperty("seasons") @Nullable ArrayList<Seasons> arrayList2, @JsonProperty("videos") @Nullable ResultsTrailer videos, @JsonProperty("external_ids") @Nullable ExternalIds external_ids, @JsonProperty("credits") @Nullable Credits credits, @JsonProperty("recommendations") @Nullable ResultsRecommendations recommendations) {
            this.id = id;
            this.imdbId = imdbId;
            this.title = title;
            this.name = name;
            this.originalTitle = originalTitle;
            this.originalName = originalName;
            this.posterPath = posterPath;
            this.backdropPath = backdropPath;
            this.releaseDate = releaseDate;
            this.firstAirDate = firstAirDate;
            this.overview = overview;
            this.runtime = runtime;
            this.vote_average = vote_average;
            this.original_language = original_language;
            this.status = status;
            this.genres = arrayList;
            this.keywords = keywords;
            this.last_episode_to_air = last_episode_to_air;
            this.seasons = arrayList2;
            this.videos = videos;
            this.external_ids = external_ids;
            this.credits = credits;
            this.recommendations = recommendations;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ MediaDetail(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Integer num2, Object obj, String str11, String str12, ArrayList arrayList, KeywordResults keywordResults, LastEpisodeToAir lastEpisodeToAir, ArrayList arrayList2, ResultsTrailer resultsTrailer, ExternalIds externalIds, Credits credits, ResultsRecommendations resultsRecommendations, int i, DefaultConstructorMarker defaultConstructorMarker) {
            Integer num3 = (i & 1) != 0 ? null : num;
            String str13 = (i & 2) != 0 ? null : str;
            String str14 = (i & 4) != 0 ? null : str2;
            String str15 = (i & 8) != 0 ? null : str3;
            String str16 = (i & 16) != 0 ? null : str4;
            String str17 = (i & 32) != 0 ? null : str5;
            String str18 = (i & 64) != 0 ? null : str6;
            String str19 = (i & 128) != 0 ? null : str7;
            String str20 = (i & 256) != 0 ? null : str8;
            String str21 = (i & 512) != 0 ? null : str9;
            String str22 = (i & 1024) != 0 ? null : str10;
            Integer num4 = (i & 2048) != 0 ? null : num2;
            Object obj2 = (i & 4096) != 0 ? null : obj;
            String str23 = (i & 8192) != 0 ? null : str11;
            String str24 = (i & 16384) != 0 ? null : str12;
            this(num3, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, num4, obj2, str23, str24, (i & 32768) != 0 ? new ArrayList() : arrayList, (i & 65536) != 0 ? null : keywordResults, (i & 131072) != 0 ? null : lastEpisodeToAir, (i & 262144) != 0 ? new ArrayList() : arrayList2, (i & 524288) != 0 ? null : resultsTrailer, (i & 1048576) != 0 ? null : externalIds, (i & 2097152) != 0 ? null : credits, (i & 4194304) != 0 ? null : resultsRecommendations);
        }

        @Nullable
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        public final String getImdbId() {
            return this.imdbId;
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
        public final String getOriginalTitle() {
            return this.originalTitle;
        }

        @Nullable
        public final String getOriginalName() {
            return this.originalName;
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
        public final String getReleaseDate() {
            return this.releaseDate;
        }

        @Nullable
        public final String getFirstAirDate() {
            return this.firstAirDate;
        }

        @Nullable
        public final String getOverview() {
            return this.overview;
        }

        @Nullable
        public final Integer getRuntime() {
            return this.runtime;
        }

        @Nullable
        public final Object getVote_average() {
            return this.vote_average;
        }

        @Nullable
        public final String getOriginal_language() {
            return this.original_language;
        }

        @Nullable
        public final String getStatus() {
            return this.status;
        }

        @Nullable
        public final ArrayList<Genres> getGenres() {
            return this.genres;
        }

        @Nullable
        public final KeywordResults getKeywords() {
            return this.keywords;
        }

        @Nullable
        public final LastEpisodeToAir getLast_episode_to_air() {
            return this.last_episode_to_air;
        }

        @Nullable
        public final ArrayList<Seasons> getSeasons() {
            return this.seasons;
        }

        @Nullable
        public final ResultsTrailer getVideos() {
            return this.videos;
        }

        @Nullable
        public final ExternalIds getExternal_ids() {
            return this.external_ids;
        }

        @Nullable
        public final Credits getCredits() {
            return this.credits;
        }

        @Nullable
        public final ResultsRecommendations getRecommendations() {
            return this.recommendations;
        }
    }
}
