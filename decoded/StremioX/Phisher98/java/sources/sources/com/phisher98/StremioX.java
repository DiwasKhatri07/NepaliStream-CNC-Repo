package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.api.Log;
import com.lagradost.cloudstream3.ActorData;
import com.lagradost.cloudstream3.AnimeLoadResponse;
import com.lagradost.cloudstream3.DubStatus;
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
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StremioX.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StremioX/classes.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b$\u0018\u0000 B2\u00020\u0001:\u001dBCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003H\u0002J\u0014\u0010\u001f\u001a\u0004\u0018\u00010\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003H\u0002J\u001e\u0010\u001b\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0096@¢\u0006\u0002\u0010%J\u001a\u0010&\u001a\u0004\u0018\u00010'*\u00020(2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0003H\u0002J\u001e\u0010*\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u00192\u0006\u0010+\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010,J \u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010+\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010/J\u0018\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010,JF\u00103\u001a\u00020\u000e2\u0006\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u000e2\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u000209072\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020907H\u0096@¢\u0006\u0002\u0010<JZ\u0010=\u001a\u0002092\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\"2\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u000209072\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020907H\u0082@¢\u0006\u0002\u0010AR\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006_"}, d2 = {"Lcom/phisher98/StremioX;", "Lcom/lagradost/cloudstream3/metaproviders/TmdbProvider;", "mainUrl", "", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "hasQuickSearch", "getHasQuickSearch", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "getImageUrl", "link", "getOriImageUrl", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResponse", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lcom/phisher98/StremioX$Media;", "type", "quickSearch", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "Lcom/lagradost/cloudstream3/SearchResponseList;", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeMainSource", "imdbId", "season", "episode", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "StreamsResponse", "Subtitle", "ProxyHeaders", "BehaviorHints", "Stream", "LoadData", "Data", "Results", "Media", "Genres", "Keywords", "KeywordResults", "Seasons", "Cast", "Episodes", "MediaDetailEpisodes", "Trailers", "ResultsTrailer", "ExternalIds", "Credits", "ResultsRecommendations", "LastEpisodeToAir", "MediaDetail", "ResultsAltTitles", "AltTitles", "ProductionCountries", "CinemetaRes", "LinkData", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nStremioX.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StremioX.kt\ncom/phisher98/StremioX\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 6 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,714:1\n73#2,5:715\n73#2,5:734\n73#2,5:772\n73#2,5:855\n73#2,5:871\n73#2,5:907\n1795#3,10:720\n2068#3:730\n2069#3:732\n1805#3:733\n1795#3,10:739\n2068#3:749\n2069#3:751\n1805#3:752\n1795#3,10:777\n2068#3:787\n2069#3:789\n1805#3:790\n1795#3,10:791\n2068#3:801\n2069#3:803\n1805#3:804\n1795#3,10:806\n2068#3:816\n2069#3:818\n1805#3:819\n1960#3,3:820\n1795#3,10:823\n2068#3:833\n2069#3:835\n1805#3:836\n1795#3,10:837\n2068#3:847\n2069#3:849\n1805#3:850\n1739#3:851\n1814#3,3:852\n1795#3,10:860\n2068#3:870\n1739#3:876\n1814#3,3:877\n2069#3:881\n1805#3:882\n777#3:883\n873#3,2:884\n1739#3:912\n1814#3,3:913\n1#4:731\n1#4:750\n1#4:754\n1#4:788\n1#4:802\n1#4:805\n1#4:817\n1#4:834\n1#4:848\n1#4:880\n1#4:886\n1#4:888\n1#4:906\n63#5:753\n64#5,15:755\n63#5:887\n64#5,15:889\n50#6:770\n43#6:771\n50#6:904\n43#6:905\n*S KotlinDebug\n*F\n+ 1 StremioX.kt\ncom/phisher98/StremioX\n*L\n109#1:715,5\n130#1:734,5\n144#1:772,5\n186#1:855,5\n191#1:871,5\n356#1:907,5\n109#1:720,10\n109#1:730\n109#1:732\n109#1:733\n130#1:739,10\n130#1:749\n130#1:751\n130#1:752\n152#1:777,10\n152#1:787\n152#1:789\n152#1:790\n154#1:791,10\n154#1:801\n154#1:803\n154#1:804\n155#1:806,10\n155#1:816\n155#1:818\n155#1:819\n159#1:820,3\n161#1:823,10\n161#1:833\n161#1:835\n161#1:836\n170#1:837,10\n170#1:847\n170#1:849\n170#1:850\n173#1:851\n173#1:852,3\n189#1:860,10\n189#1:870\n191#1:876\n191#1:877,3\n189#1:881\n189#1:882\n210#1:883\n210#1:884,2\n216#1:912\n216#1:913,3\n109#1:731\n130#1:750\n137#1:754\n152#1:788\n154#1:802\n155#1:817\n161#1:834\n170#1:848\n189#1:880\n325#1:888\n137#1:753\n137#1:755,15\n325#1:887\n325#1:889,15\n137#1:770\n137#1:771\n325#1:904\n325#1:905\n*E\n"})
public final class StremioX extends TmdbProvider {

    @NotNull
    private static final String Cinemeta = "https://aiometadata.elfhosted.com/stremio/b7cb164b-074b-41d5-b458-b3a834e197bb";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String TRACKER_LIST_URL = "https://raw.githubusercontent.com/ngosang/trackerslist/master/trackers_best.txt";

    @NotNull
    private static final String apiKey = "98ae14df2b8d8f8f8136499daf79f0e0";

    @NotNull
    private static final String tmdbAPI = "https://api.themoviedb.org/3";

    @NotNull
    private String mainUrl;

    @NotNull
    private String name;
    private final boolean hasMainPage = true;
    private final boolean hasQuickSearch = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(TvType.Others);

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("https://api.themoviedb.org/3/trending/all/day?api_key=98ae14df2b8d8f8f8136499daf79f0e0&region=US", "Trending"), TuplesKt.to("https://api.themoviedb.org/3/movie/popular?api_key=98ae14df2b8d8f8f8136499daf79f0e0&region=US", "Popular Movies"), TuplesKt.to("https://api.themoviedb.org/3/tv/popular?api_key=98ae14df2b8d8f8f8136499daf79f0e0&region=US&with_original_language=en", "Popular TV Shows"), TuplesKt.to("https://api.themoviedb.org/3/tv/airing_today?api_key=98ae14df2b8d8f8f8136499daf79f0e0&region=US&with_original_language=en", "Airing Today TV Shows"), TuplesKt.to("https://api.themoviedb.org/3/discover/tv?api_key=98ae14df2b8d8f8f8136499daf79f0e0&with_networks=213", "Netflix"), TuplesKt.to("https://api.themoviedb.org/3/discover/tv?api_key=98ae14df2b8d8f8f8136499daf79f0e0&with_networks=1024", "Amazon"), TuplesKt.to("https://api.themoviedb.org/3/discover/tv?api_key=98ae14df2b8d8f8f8136499daf79f0e0&with_networks=2739", "Disney+"), TuplesKt.to("https://api.themoviedb.org/3/discover/tv?api_key=98ae14df2b8d8f8f8136499daf79f0e0&with_networks=453", "Hulu"), TuplesKt.to("https://api.themoviedb.org/3/discover/tv?api_key=98ae14df2b8d8f8f8136499daf79f0e0&with_networks=2552", "Apple TV+"), TuplesKt.to("https://api.themoviedb.org/3/discover/tv?api_key=98ae14df2b8d8f8f8136499daf79f0e0&with_networks=49", "HBO"), TuplesKt.to("https://api.themoviedb.org/3/discover/tv?api_key=98ae14df2b8d8f8f8136499daf79f0e0&with_networks=4330", "Paramount+"), TuplesKt.to("https://api.themoviedb.org/3/movie/top_rated?api_key=98ae14df2b8d8f8f8136499daf79f0e0&region=US", "Top Rated Movies"), TuplesKt.to("https://api.themoviedb.org/3/tv/top_rated?api_key=98ae14df2b8d8f8f8136499daf79f0e0&region=US", "Top Rated TV Shows"), TuplesKt.to("https://api.themoviedb.org/3/movie/upcoming?api_key=98ae14df2b8d8f8f8136499daf79f0e0&region=US", "Upcoming Movies"), TuplesKt.to("https://api.themoviedb.org/3/discover/tv?api_key=98ae14df2b8d8f8f8136499daf79f0e0&with_original_language=ko", "Korean Shows")});

    /* JADX INFO: renamed from: com.phisher98.StremioX$getMainPage$1 */
    /* JADX INFO: compiled from: StremioX.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StremioX", f = "StremioX.kt", i = {0, 0, 0, 0}, l = {108}, m = "getMainPage", n = {"request", "adultQuery", "type", "page"}, nl = {109}, s = {"L$0", "L$1", "L$2", "I$0"}, v = 2)
    static final class C00181 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00181(Continuation<? super C00181> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StremioX.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StremioX$invokeMainSource$1 */
    /* JADX INFO: compiled from: StremioX.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StremioX", f = "StremioX.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {356, 357}, m = "invokeMainSource", n = {"imdbId", "season", "episode", "subtitleCallback", "callback", "fixMainUrl", "url", "imdbId", "season", "episode", "subtitleCallback", "callback", "fixMainUrl", "url", "res"}, nl = {716, 360}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7"}, v = 2)
    static final class C00191 extends ContinuationImpl {
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

        C00191(Continuation<? super C00191> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StremioX.this.invokeMainSource(null, null, null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StremioX$load$1 */
    /* JADX INFO: compiled from: StremioX.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StremioX", f = "StremioX.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7}, l = {144, 176, 186, 190, 213, 254, 275, 294}, m = "load", n = {"url", "data", "type", "resUrl", "url", "data", "type", "resUrl", "res", "title", "poster", "bgPoster", "releaseDate", "year", "genres", "keywords", "actors", "recommendations", "trailer", "isAnime", "isCartoon", "isAsian", "isBollywood", "url", "data", "type", "resUrl", "res", "title", "poster", "bgPoster", "releaseDate", "year", "genres", "keywords", "actors", "recommendations", "trailer", "logoUrl", "animeType", "imdbId", "isAnime", "isCartoon", "isAsian", "isBollywood", "url", "data", "type", "resUrl", "res", "title", "poster", "bgPoster", "releaseDate", "year", "genres", "keywords", "actors", "recommendations", "trailer", "logoUrl", "animeType", "imdbId", "cineRes", "$this$mapNotNull$iv", "$this$mapNotNullTo$iv$iv", "destination$iv$iv", "$this$forEach$iv$iv$iv", "element$iv$iv$iv", "element$iv$iv", "season", "isAnime", "isCartoon", "isAsian", "isBollywood", "url", "data", "type", "resUrl", "res", "title", "poster", "bgPoster", "releaseDate", "year", "genres", "keywords", "actors", "recommendations", "trailer", "logoUrl", "animeType", "imdbId", "cineRes", "episodes", "animeVideos", "jpTitle", "isAnime", "isCartoon", "isAsian", "isBollywood", "url", "data", "type", "resUrl", "res", "title", "poster", "bgPoster", "releaseDate", "year", "genres", "keywords", "actors", "recommendations", "trailer", "logoUrl", "animeType", "imdbId", "cineRes", "episodes", "animeVideos", "jpTitle", "syncMetaData", "animeMetaData", "kitsuid", "isAnime", "isCartoon", "isAsian", "isBollywood", "url", "data", "type", "resUrl", "res", "title", "poster", "bgPoster", "releaseDate", "year", "genres", "keywords", "actors", "recommendations", "trailer", "logoUrl", "animeType", "imdbId", "cineRes", "episodes", "isAnime", "isCartoon", "isAsian", "isBollywood", "url", "data", "type", "resUrl", "res", "title", "poster", "bgPoster", "releaseDate", "year", "genres", "keywords", "actors", "recommendations", "trailer", "logoUrl", "animeType", "imdbId", "cineRes", "isAnime", "isCartoon", "isAsian", "isBollywood"}, nl = {734, 184, 817, 191, 214, 275, 294, 188}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$24", "L$25", "L$26", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "I$0", "I$1", "I$2", "I$3"}, v = 2)
    static final class C00211 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
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
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C00211(Continuation<? super C00211> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StremioX.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StremioX$loadLinks$1 */
    /* JADX INFO: compiled from: StremioX.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StremioX", f = "StremioX.kt", i = {0, 0, 0, 0, 0}, l = {326}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "res", "isCasting"}, nl = {340}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0"}, v = 2)
    static final class C00251 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00251(Continuation<? super C00251> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StremioX.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StremioX$quickSearch$1 */
    /* JADX INFO: compiled from: StremioX.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StremioX", f = "StremioX.kt", i = {0}, l = {125}, m = "quickSearch", n = {"query"}, nl = {-1}, s = {"L$0"}, v = 2)
    static final class C00291 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00291(Continuation<? super C00291> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StremioX.this.quickSearch(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StremioX$search$1 */
    /* JADX INFO: compiled from: StremioX.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StremioX", f = "StremioX.kt", i = {0, 0}, l = {128}, m = "search", n = {"query", "page"}, nl = {130}, s = {"L$0", "I$0"}, v = 2)
    static final class C00301 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00301(Continuation<? super C00301> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StremioX.this.search(null, 0, (Continuation) this);
        }
    }

    public StremioX(@NotNull String mainUrl, @NotNull String name) {
        this.mainUrl = mainUrl;
        this.name = name;
    }

    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    public void setMainUrl(@NotNull String str) {
        this.mainUrl = str;
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

    /* JADX INFO: compiled from: StremioX.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\f\u001a\u00020\r2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/phisher98/StremioX$Companion;", "", "<init>", "()V", "TRACKER_LIST_URL", "", "tmdbAPI", "Cinemeta", "apiKey", "getType", "Lcom/lagradost/cloudstream3/TvType;", "t", "getStatus", "Lcom/lagradost/cloudstream3/ShowStatus;", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
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

    private final String getImageUrl(String link) {
        if (link == null) {
            return null;
        }
        return StringsKt.startsWith$default(link, "/", false, 2, (Object) null) ? "https://image.tmdb.org/t/p/original/" + link : link;
    }

    private final String getOriImageUrl(String link) {
        if (link == null) {
            return null;
        }
        return StringsKt.startsWith$default(link, "/", false, 2, (Object) null) ? "https://image.tmdb.org/t/p/original/" + link : link;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.lagradost.cloudstream3.ErrorLoadingException */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) throws ErrorLoadingException {
        C00181 c00181;
        MainPageRequest request2;
        String type;
        Object safe;
        Iterable results;
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
                String adultQuery = MainAPI.Companion.getSettingsForProvider().getEnableAdult() ? "" : "&without_keywords=190370|13059|226161|195669|190370";
                String type2 = StringsKt.contains$default(request.getData(), "/movie", false, 2, (Object) null) ? "movie" : "tv";
                Requests app = MainActivityKt.getApp();
                String str = request.getData() + adultQuery + "&page=" + page;
                c00181.L$0 = request;
                c00181.L$1 = SpillingKt.nullOutSpilledVariable(adultQuery);
                c00181.L$2 = type2;
                c00181.I$0 = page;
                c00181.label = 1;
                String type3 = type2;
                $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00181, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                request2 = request;
                type = type3;
                break;
                break;
            case 1:
                int i = c00181.I$0;
                type = (String) c00181.L$2;
                request2 = (MainPageRequest) c00181.L$0;
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

    static /* synthetic */ SearchResponse toSearchResponse$default(StremioX stremioX, Media media, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return stremioX.toSearchResponse(media, str);
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
        return MainAPIKt.newMovieSearchResponse$default(mainAPI, title, appUtils.toJson(new Data(id, mediaType, null, null, 12, null)), TvType.Movie, false, new Function1() { // from class: com.phisher98.StremioX$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return StremioX.toSearchResponse$lambda$0(this.f$0, $this$toSearchResponse, (MovieSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResponse$lambda$0(StremioX this$0, Media $this_toSearchResponse, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl(this$0.getImageUrl($this_toSearchResponse.getPosterPath()));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Nullable
    public Object quickSearch(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        C00291 c00291;
        Object objSearch;
        if (continuation instanceof C00291) {
            c00291 = (C00291) continuation;
            if ((c00291.label & Integer.MIN_VALUE) != 0) {
                c00291.label -= Integer.MIN_VALUE;
            } else {
                c00291 = new C00291(continuation);
            }
        } else {
            c00291 = new C00291(continuation);
        }
        Object $result = c00291.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00291.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                c00291.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00291.label = 1;
                objSearch = search(query, 1, c00291);
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
        C00301 c00301;
        int page2;
        Object safe;
        Iterable results;
        if (continuation instanceof C00301) {
            c00301 = (C00301) continuation;
            if ((c00301.label & Integer.MIN_VALUE) != 0) {
                c00301.label -= Integer.MIN_VALUE;
            } else {
                c00301 = new C00301(continuation);
            }
        } else {
            c00301 = new C00301(continuation);
        }
        Object $result = c00301.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00301.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                String str = "https://api.themoviedb.org/3/search/multi?api_key=98ae14df2b8d8f8f8136499daf79f0e0&language=en-US&query=" + query + "&page=" + page + "&include_adult=" + MainAPI.Companion.getSettingsForProvider().getEnableAdult();
                c00301.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00301.I$0 = page;
                c00301.label = 1;
                $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00301, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                page2 = page;
                break;
                break;
            case 1:
                int page3 = c00301.I$0;
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

    /* JADX WARN: Code duplicated, block: B:244:0x0bd7  */
    /* JADX WARN: Code duplicated, block: B:246:0x0ce0 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:247:0x0ce1  */
    /* JADX WARN: Code duplicated, block: B:264:0x0d40  */
    /* JADX WARN: Code duplicated, block: B:275:0x0dd3  */
    /* JADX WARN: Code duplicated, block: B:278:0x0de1  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:247:0x0ce1 -> B:248:0x0d0b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object load(@org.jetbrains.annotations.NotNull java.lang.String r83, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r84) {
        /*
            Method dump skipped, instruction units count: 5002
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.StremioX.load(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$7$0$0(Episodes $eps, StremioX this$0, Episode $this$newEpisode) {
        $this$newEpisode.setName($eps.getName() + (UtilsKt.isUpcoming($eps.getAirDate()) ? " • [UPCOMING]" : ""));
        $this$newEpisode.setSeason($eps.getSeasonNumber());
        $this$newEpisode.setEpisode($eps.getEpisodeNumber());
        $this$newEpisode.setPosterUrl(this$0.getImageUrl($eps.getStillPath()));
        $this$newEpisode.setScore(Score.Companion.from10($eps.getVoteAverage()));
        $this$newEpisode.setDescription($eps.getOverview());
        MainAPIKt.addDate$default($this$newEpisode, $eps.getAirDate(), (String) null, 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:22:0x0066 A[PHI: r9
      0x0066: PHI (r9v8 java.lang.Integer) = (r9v2 java.lang.Integer), (r9v14 java.lang.Integer) binds: [B:21:0x0064, B:12:0x004d] A[DONT_GENERATE, DONT_INLINE]] */
    public static final List<Episode> load$buildEpisodeList(List<CinemetaRes.Meta.Video> list, CinemetaRes cineRes, StremioX this$0, Data data, String imdbId, MediaDetail res, String title, Integer year, String jpTitle, boolean isAsian, boolean isBollywood, boolean isCartoon, boolean isDub) {
        Integer intOrNull;
        int videoYear;
        CinemetaRes.Meta meta;
        String year2;
        List listSplit$default;
        String str;
        List<CinemetaRes.Meta.Video> $this$map$iv = list;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            final CinemetaRes.Meta.Video video = (CinemetaRes.Meta.Video) item$iv$iv;
            String released = video.getReleased();
            if (released == null || (listSplit$default = StringsKt.split$default(released, new String[]{"-"}, false, 0, 6, (Object) null)) == null || (str = (String) CollectionsKt.firstOrNull(listSplit$default)) == null || (intOrNull = StringsKt.toIntOrNull(str)) == null) {
                intOrNull = (cineRes == null || (meta = cineRes.getMeta()) == null || (year2 = meta.getYear()) == null) ? null : StringsKt.toIntOrNull(year2);
                if (intOrNull != null) {
                    videoYear = intOrNull.intValue();
                } else {
                    videoYear = 0;
                }
            } else {
                videoYear = intOrNull.intValue();
            }
            MainAPI mainAPI = (MainAPI) this$0;
            AppUtils appUtils = AppUtils.INSTANCE;
            Integer id = data.getId();
            ExternalIds external_ids = res.getExternal_ids();
            Integer tvdb_id = external_ids != null ? external_ids.getTvdb_id() : null;
            String type = data.getType();
            Integer season = video.getSeason();
            Integer episode = video.getEpisode();
            Integer numValueOf = Integer.valueOf(videoYear);
            String title2 = video.getTitle();
            String released2 = video.getReleased();
            String releaseDate = res.getReleaseDate();
            if (releaseDate == null) {
                releaseDate = res.getFirstAirDate();
            }
            destination$iv$iv.add(MainAPIKt.newEpisode(mainAPI, appUtils.toJson(new LinkData(id, imdbId, tvdb_id, type, season, episode, null, null, null, title, numValueOf, "", true, year, null, title2, jpTitle, released2, releaseDate, isAsian, isBollywood, isCartoon, res.getTitle(), res.getName(), isDub, null, 33571264, null)), new Function1() { // from class: com.phisher98.StremioX$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    return StremioX.load$buildEpisodeList$lambda$10$0(video, (Episode) obj);
                }
            }));
        }
        return (List) destination$iv$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$buildEpisodeList$lambda$10$0(CinemetaRes.Meta.Video $video, Episode $this$newEpisode) {
        $this$newEpisode.setName($video.getTitle() + (UtilsKt.isUpcoming($video.getReleased()) ? " • [UPCOMING]" : ""));
        $this$newEpisode.setSeason($video.getSeason());
        $this$newEpisode.setEpisode($video.getEpisode());
        $this$newEpisode.setPosterUrl($video.getThumbnail());
        $this$newEpisode.setDescription($video.getOverview());
        MainAPIKt.addDate$default($this$newEpisode, $video.getReleased(), (String) null, 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.phisher98.StremioX$load$2 */
    /* JADX INFO: compiled from: StremioX.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/AnimeLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StremioX$load$2", f = "StremioX.kt", i = {0}, l = {267}, m = "invokeSuspend", n = {"$this$newAnimeLoadResponse"}, nl = {268}, s = {"L$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nStremioX.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StremioX.kt\ncom/phisher98/StremioX$load$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,714:1\n1739#2:715\n1814#2,2:716\n1816#2:719\n1#3:718\n*S KotlinDebug\n*F\n+ 1 StremioX.kt\ncom/phisher98/StremioX$load$2\n*L\n261#1:715\n261#1:716,2\n261#1:719\n*E\n"})
    static final class C00222 extends SuspendLambda implements Function2<AnimeLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<ActorData> $actors;
        final /* synthetic */ List<CinemetaRes.Meta.Video> $animeVideos;
        final /* synthetic */ String $bgPoster;
        final /* synthetic */ CinemetaRes $cineRes;
        final /* synthetic */ Data $data;
        final /* synthetic */ List<String> $genres;
        final /* synthetic */ String $imdbId;
        final /* synthetic */ boolean $isAsian;
        final /* synthetic */ boolean $isBollywood;
        final /* synthetic */ boolean $isCartoon;
        final /* synthetic */ String $jpTitle;
        final /* synthetic */ List<String> $keywords;
        final /* synthetic */ String $kitsuid;
        final /* synthetic */ String $logoUrl;
        final /* synthetic */ String $poster;
        final /* synthetic */ List<SearchResponse> $recommendations;
        final /* synthetic */ MediaDetail $res;
        final /* synthetic */ String $title;
        final /* synthetic */ String $trailer;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ StremioX this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00222(String str, String str2, String str3, Integer num, MediaDetail mediaDetail, List<String> list, List<String> list2, List<? extends SearchResponse> list3, List<ActorData> list4, String str4, String str5, CinemetaRes cinemetaRes, String str6, List<CinemetaRes.Meta.Video> list5, StremioX stremioX, Data data, String str7, String str8, boolean z, boolean z2, boolean z3, Continuation<? super C00222> continuation) {
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
            this.$kitsuid = str5;
            this.$cineRes = cinemetaRes;
            this.$imdbId = str6;
            this.$animeVideos = list5;
            this.this$0 = stremioX;
            this.$data = data;
            this.$title = str7;
            this.$jpTitle = str8;
            this.$isAsian = z;
            this.$isBollywood = z2;
            this.$isCartoon = z3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00222 = new C00222(this.$poster, this.$bgPoster, this.$logoUrl, this.$year, this.$res, this.$keywords, this.$genres, this.$recommendations, this.$actors, this.$trailer, this.$kitsuid, this.$cineRes, this.$imdbId, this.$animeVideos, this.this$0, this.$data, this.$title, this.$jpTitle, this.$isAsian, this.$isBollywood, this.$isCartoon, continuation);
            c00222.L$0 = obj;
            return c00222;
        }

        public final Object invoke(AnimeLoadResponse animeLoadResponse, Continuation<? super Unit> continuation) {
            return create(animeLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:29:0x00e3  */
        public final Object invokeSuspend(Object $result) {
            List<String> list;
            String string;
            CinemetaRes.Meta meta;
            CinemetaRes.Meta.AppExtras appExtras;
            LoadResponse loadResponse = (AnimeLoadResponse) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    MainAPIKt.addEpisodes(loadResponse, DubStatus.Subbed, StremioX.load$buildEpisodeList(this.$animeVideos, this.$cineRes, this.this$0, this.$data, this.$imdbId, this.$res, this.$title, this.$year, this.$jpTitle, this.$isAsian, this.$isBollywood, this.$isCartoon, false));
                    loadResponse.setPosterUrl(this.$poster);
                    loadResponse.setBackgroundPosterUrl(this.$bgPoster);
                    try {
                        loadResponse.setLogoUrl(this.$logoUrl);
                        break;
                    } catch (Throwable th) {
                    }
                    loadResponse.setYear(this.$year);
                    loadResponse.setPlot(this.$res.getOverview());
                    Iterable iterable = this.$keywords;
                    if (iterable != null) {
                        Iterable $this$map$iv = iterable;
                        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                        for (Object item$iv$iv : $this$map$iv) {
                            String it = (String) item$iv$iv;
                            if (it.length() > 0) {
                                StringBuilder sb = new StringBuilder();
                                char c = it.charAt(0);
                                StringBuilder sbAppend = sb.append((Object) CharsKt.titlecase(c));
                                String strSubstring = it.substring(1);
                                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                                string = sbAppend.append(strSubstring).toString();
                            } else {
                                string = it;
                            }
                            destination$iv$iv.add(string);
                        }
                        list = (List) destination$iv$iv;
                        if (list.isEmpty()) {
                            list = null;
                        }
                        if (list == null) {
                            list = this.$genres;
                        }
                    } else {
                        list = this.$genres;
                    }
                    loadResponse.setTags(list);
                    loadResponse.setScore(Score.Companion.from10(String.valueOf(this.$res.getVote_average())));
                    loadResponse.setShowStatus(StremioX.INSTANCE.getStatus(this.$res.getStatus()));
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
            try {
                LoadResponse.Companion.addKitsuId(loadResponse, this.$kitsuid);
            } catch (Throwable th2) {
            }
            CinemetaRes cinemetaRes = this.$cineRes;
            loadResponse.setContentRating((cinemetaRes == null || (meta = cinemetaRes.getMeta()) == null || (appExtras = meta.getAppExtras()) == null) ? null : appExtras.getCertification());
            LoadResponse.Companion.addImdbId(loadResponse, this.$imdbId);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StremioX$load$3 */
    /* JADX INFO: compiled from: StremioX.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StremioX$load$3", f = "StremioX.kt", i = {0}, l = {289}, m = "invokeSuspend", n = {"$this$newTvSeriesLoadResponse"}, nl = {290}, s = {"L$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nStremioX.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StremioX.kt\ncom/phisher98/StremioX$load$3\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,714:1\n1#2:715\n*E\n"})
    static final class C00233 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<ActorData> $actors;
        final /* synthetic */ String $bgPoster;
        final /* synthetic */ Data $data;
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
        C00233(String str, String str2, String str3, Integer num, MediaDetail mediaDetail, List<String> list, List<String> list2, List<? extends SearchResponse> list3, List<ActorData> list4, String str4, Data data, Continuation<? super C00233> continuation) {
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
            this.$data = data;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00233 = new C00233(this.$poster, this.$bgPoster, this.$logoUrl, this.$year, this.$res, this.$keywords, this.$genres, this.$recommendations, this.$actors, this.$trailer, this.$data, continuation);
            c00233.L$0 = obj;
            return c00233;
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
                    loadResponse.setShowStatus(StremioX.INSTANCE.getStatus(this.$res.getStatus()));
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
            LoadResponse.Companion.addTMDbId(loadResponse, String.valueOf(this.$data.getId()));
            LoadResponse.Companion companion = LoadResponse.Companion;
            LoadResponse loadResponse2 = loadResponse;
            ExternalIds external_ids = this.$res.getExternal_ids();
            companion.addImdbId(loadResponse2, external_ids != null ? external_ids.getImdb_id() : null);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StremioX$load$4 */
    /* JADX INFO: compiled from: StremioX.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StremioX$load$4", f = "StremioX.kt", i = {0}, l = {312}, m = "invokeSuspend", n = {"$this$newMovieLoadResponse"}, nl = {313}, s = {"L$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nStremioX.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StremioX.kt\ncom/phisher98/StremioX$load$4\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,714:1\n1#2:715\n*E\n"})
    static final class C00244 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<ActorData> $actors;
        final /* synthetic */ String $bgPoster;
        final /* synthetic */ Data $data;
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
        C00244(String str, String str2, String str3, String str4, Integer num, MediaDetail mediaDetail, List<String> list, List<String> list2, List<? extends SearchResponse> list3, List<ActorData> list4, String str5, Data data, Continuation<? super C00244> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$releaseDate = str2;
            this.$logoUrl = str3;
            this.$bgPoster = str4;
            this.$year = num;
            this.$res = mediaDetail;
            this.$keywords = list;
            this.$genres = list2;
            this.$recommendations = list3;
            this.$actors = list4;
            this.$trailer = str5;
            this.$data = data;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00244 = new C00244(this.$poster, this.$releaseDate, this.$logoUrl, this.$bgPoster, this.$year, this.$res, this.$keywords, this.$genres, this.$recommendations, this.$actors, this.$trailer, this.$data, continuation);
            c00244.L$0 = obj;
            return c00244;
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
                    loadResponse.setComingSoon(UtilsKt.isUpcoming(this.$releaseDate));
                    try {
                        loadResponse.setLogoUrl(this.$logoUrl);
                        break;
                    } catch (Throwable th) {
                    }
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
            LoadResponse.Companion.addTMDbId(loadResponse, String.valueOf(this.$data.getId()));
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
        C00251 c00251;
        StremioX stremioX;
        Object obj;
        Object objDecodeFromString;
        if (continuation instanceof C00251) {
            c00251 = (C00251) continuation;
            if ((c00251.label & Integer.MIN_VALUE) != 0) {
                c00251.label -= Integer.MIN_VALUE;
                stremioX = this;
            } else {
                stremioX = this;
                c00251 = stremioX.new C00251(continuation);
            }
        } else {
            stremioX = this;
            c00251 = stremioX.new C00251(continuation);
        }
        C00251 c00252 = c00251;
        Object $result = c00252.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00252.label) {
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
                        objDecodeFromString = $this$readValue$iv$iv.readValue(data, new TypeReference<LoadData>() { // from class: com.phisher98.StremioX$loadLinks$$inlined$parseJson$1
                        });
                    } catch (Throwable th3) {
                        ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv2.readValue(data, new TypeReference<LoadData>() { // from class: com.phisher98.StremioX$loadLinks$$inlined$parseJson$1
                        });
                    }
                } else {
                    ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv3.readValue(data, new TypeReference<LoadData>() { // from class: com.phisher98.StremioX$loadLinks$$inlined$parseJson$1
                    });
                }
                LoadData res = (LoadData) objDecodeFromString;
                Function1[] function1Arr = {new C00262(res, stremioX, function1, function2, null), new C00273(res, function1, null), new C00284(res, function1, null)};
                c00252.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00252.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                c00252.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                c00252.L$3 = SpillingKt.nullOutSpilledVariable(res);
                c00252.Z$0 = isCasting;
                c00252.label = 1;
                if (ParCollectionsKt.runAllAsync(function1Arr, c00252) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                boolean z = c00252.Z$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Boxing.boxBoolean(true);
    }

    /* JADX INFO: renamed from: com.phisher98.StremioX$loadLinks$2 */
    /* JADX INFO: compiled from: StremioX.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StremioX$loadLinks$2", f = "StremioX.kt", i = {}, l = {330}, m = "invokeSuspend", n = {}, nl = {331}, s = {}, v = 2)
    static final class C00262 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ LoadData $res;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        int label;
        final /* synthetic */ StremioX this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00262(LoadData loadData, StremioX stremioX, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super C00262> continuation) {
            super(1, continuation);
            this.$res = loadData;
            this.this$0 = stremioX;
            this.$subtitleCallback = function1;
            this.$callback = function2;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00262(this.$res, this.this$0, this.$subtitleCallback, this.$callback, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Log.INSTANCE.d("Phisher", String.valueOf(this.$res.getImdbId()));
                    this.label = 1;
                    if (this.this$0.invokeMainSource(this.$res.getImdbId(), this.$res.getSeason(), this.$res.getEpisode(), this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.phisher98.StremioX$loadLinks$3 */
    /* JADX INFO: compiled from: StremioX.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StremioX$loadLinks$3", f = "StremioX.kt", i = {}, l = {333}, m = "invokeSuspend", n = {}, nl = {334}, s = {}, v = 2)
    static final class C00273 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ LoadData $res;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00273(LoadData loadData, Function1<? super SubtitleFile, Unit> function1, Continuation<? super C00273> continuation) {
            super(1, continuation);
            this.$res = loadData;
            this.$subtitleCallback = function1;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00273(this.$res, this.$subtitleCallback, continuation);
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

    /* JADX INFO: renamed from: com.phisher98.StremioX$loadLinks$4 */
    /* JADX INFO: compiled from: StremioX.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StremioX$loadLinks$4", f = "StremioX.kt", i = {}, l = {336}, m = "invokeSuspend", n = {}, nl = {337}, s = {}, v = 2)
    static final class C00284 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ LoadData $res;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00284(LoadData loadData, Function1<? super SubtitleFile, Unit> function1, Continuation<? super C00284> continuation) {
            super(1, continuation);
            this.$res = loadData;
            this.$subtitleCallback = function1;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00284(this.$res, this.$subtitleCallback, continuation);
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
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    public final Object invokeMainSource(String imdbId, Integer season, Integer episode, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super Unit> continuation) {
        C00191 c00191;
        StremioX stremioX;
        Integer num;
        String url;
        Object obj;
        C00191 c00192;
        Object $result;
        Object obj2;
        Integer season2;
        Integer episode2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        String url2;
        String fixMainUrl;
        Object safe;
        StreamsResponse res;
        List<Stream> streams;
        if (continuation instanceof C00191) {
            c00191 = (C00191) continuation;
            if ((c00191.label & Integer.MIN_VALUE) != 0) {
                c00191.label -= Integer.MIN_VALUE;
                stremioX = this;
            } else {
                stremioX = this;
                c00191 = stremioX.new C00191(continuation);
            }
        } else {
            stremioX = this;
            c00191 = stremioX.new C00191(continuation);
        }
        Object $result2 = c00191.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00191.label) {
            case 0:
                ResultKt.throwOnFailure($result2);
                String it = stremioX.getMainUrl();
                if (StringsKt.isBlank(it)) {
                    it = null;
                }
                if (it == null) {
                    it = "https://torrentio.strem.fun/manifest.json";
                }
                String fixMainUrl2 = UtilsKt.fixSourceUrl(it);
                if (season == null) {
                    url = fixMainUrl2 + "/stream/movie/" + imdbId + ".json";
                    num = episode;
                } else {
                    num = episode;
                    url = fixMainUrl2 + "/stream/series/" + imdbId + ':' + season.intValue() + ':' + num + ".json";
                }
                Requests app = MainActivityKt.getApp();
                c00191.L$0 = SpillingKt.nullOutSpilledVariable(imdbId);
                c00191.L$1 = SpillingKt.nullOutSpilledVariable(season);
                c00191.L$2 = SpillingKt.nullOutSpilledVariable(num);
                c00191.L$3 = function1;
                c00191.L$4 = function2;
                c00191.L$5 = SpillingKt.nullOutSpilledVariable(fixMainUrl2);
                c00191.L$6 = SpillingKt.nullOutSpilledVariable(url);
                c00191.label = 1;
                String url3 = url;
                C00191 c00193 = c00191;
                obj = coroutine_suspended;
                Object obj3 = Requests.get$default(app, url3, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 120L, (Interceptor) null, false, (ResponseParser) null, c00193, 3838, (Object) null);
                c00192 = c00193;
                if (obj3 == obj) {
                    return obj;
                }
                $result = imdbId;
                obj2 = obj3;
                season2 = season;
                episode2 = episode;
                function3 = function1;
                function4 = function2;
                url2 = url3;
                fixMainUrl = fixMainUrl2;
                NiceResponse this_$iv = (NiceResponse) obj2;
                try {
                    ResponseParser parser = this_$iv.getParser();
                    Intrinsics.checkNotNull(parser);
                    safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(StreamsResponse.class));
                    break;
                } catch (Exception e$iv) {
                    e$iv.printStackTrace();
                    safe = null;
                }
                res = (StreamsResponse) safe;
                if (res != null || (streams = res.getStreams()) == null) {
                    return Unit.INSTANCE;
                }
                C00202 c00202 = new C00202(function3, function4, null);
                c00192.L$0 = SpillingKt.nullOutSpilledVariable($result);
                c00192.L$1 = SpillingKt.nullOutSpilledVariable(season2);
                c00192.L$2 = SpillingKt.nullOutSpilledVariable(episode2);
                c00192.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                c00192.L$4 = SpillingKt.nullOutSpilledVariable(function4);
                c00192.L$5 = SpillingKt.nullOutSpilledVariable(fixMainUrl);
                c00192.L$6 = SpillingKt.nullOutSpilledVariable(url2);
                c00192.L$7 = SpillingKt.nullOutSpilledVariable(res);
                c00192.label = 2;
                return ParCollectionsKt.amap(streams, c00202, c00192) == obj ? obj : Unit.INSTANCE;
            case 1:
                url2 = (String) c00191.L$6;
                String fixMainUrl3 = (String) c00191.L$5;
                function4 = (Function1) c00191.L$4;
                function3 = (Function1) c00191.L$3;
                episode2 = (Integer) c00191.L$2;
                season2 = (Integer) c00191.L$1;
                Object imdbId2 = (String) c00191.L$0;
                ResultKt.throwOnFailure($result2);
                c00192 = c00191;
                obj = coroutine_suspended;
                fixMainUrl = fixMainUrl3;
                $result = imdbId2;
                obj2 = $result2;
                NiceResponse this_$iv2 = (NiceResponse) obj2;
                ResponseParser parser2 = this_$iv2.getParser();
                Intrinsics.checkNotNull(parser2);
                safe = parser2.parseSafe(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(StreamsResponse.class));
                res = (StreamsResponse) safe;
                if (res != null) {
                    break;
                }
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result2);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static /* synthetic */ Object invokeMainSource$default(StremioX stremioX, String str, Integer num, Integer num2, Function1 function1, Function1 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            num2 = null;
        }
        return stremioX.invokeMainSource(str, num, num2, function1, function2, continuation);
    }

    /* JADX INFO: renamed from: com.phisher98.StremioX$invokeMainSource$2 */
    /* JADX INFO: compiled from: StremioX.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "stream", "Lcom/phisher98/StremioX$Stream;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StremioX$invokeMainSource$2", f = "StremioX.kt", i = {0}, l = {358}, m = "invokeSuspend", n = {"stream"}, nl = {359}, s = {"L$0"}, v = 2)
    static final class C00202 extends SuspendLambda implements Function2<Stream, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00202(Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super C00202> continuation) {
            super(2, continuation);
            this.$subtitleCallback = function1;
            this.$callback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00202 = new C00202(this.$subtitleCallback, this.$callback, continuation);
            c00202.L$0 = obj;
            return c00202;
        }

        public final Object invoke(Stream stream, Continuation<? super Unit> continuation) {
            return create(stream, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Stream stream = (Stream) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(stream);
                    this.label = 1;
                    if (stream.runCallback(this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: compiled from: StremioX.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/phisher98/StremioX$StreamsResponse;", "", "streams", "", "Lcom/phisher98/StremioX$Stream;", "<init>", "(Ljava/util/List;)V", "getStreams", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
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
    /* JADX INFO: compiled from: StremioX.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/phisher98/StremioX$Subtitle;", "", "url", "", "lang", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getLang", "getId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
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
    /* JADX INFO: compiled from: StremioX.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\n\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0004HÖ\u0081\u0004R\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/phisher98/StremioX$ProxyHeaders;", "", "request", "", "", "<init>", "(Ljava/util/Map;)V", "getRequest", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
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
    /* JADX INFO: compiled from: StremioX.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0006HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/phisher98/StremioX$BehaviorHints;", "", "proxyHeaders", "Lcom/phisher98/StremioX$ProxyHeaders;", "headers", "", "", "<init>", "(Lcom/phisher98/StremioX$ProxyHeaders;Ljava/util/Map;)V", "getProxyHeaders", "()Lcom/phisher98/StremioX$ProxyHeaders;", "getHeaders", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
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
    /* JADX INFO: compiled from: StremioX.kt */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001Bw\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0004\b\u0010\u0010\u0011J6\u0010\u001f\u001a\u00020 2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020 0\"2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020 0\"H\u0086@¢\u0006\u0002\u0010&J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00030\rHÆ\u0003J\u000f\u00100\u001a\b\u0012\u0004\u0012\u00020\u000f0\rHÆ\u0003J\u0089\u0001\u00101\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\rHÆ\u0001J\u0014\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00105\u001a\u000206HÖ\u0081\u0004J\n\u00107\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001d¨\u00068"}, d2 = {"Lcom/phisher98/StremioX$Stream;", "", "name", "", "title", "url", "description", "ytId", "externalUrl", "behaviorHints", "Lcom/phisher98/StremioX$BehaviorHints;", "infoHash", "sources", "", "subtitles", "Lcom/phisher98/StremioX$Subtitle;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/phisher98/StremioX$BehaviorHints;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "getTitle", "getUrl", "getDescription", "getYtId", "getExternalUrl", "getBehaviorHints", "()Lcom/phisher98/StremioX$BehaviorHints;", "getInfoHash", "getSources", "()Ljava/util/List;", "getSubtitles", "runCallback", "", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "", "toString", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nStremioX.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StremioX.kt\ncom/phisher98/StremioX$Stream\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,714:1\n788#2:715\n800#2:716\n2077#2,2:717\n801#2,2:719\n2079#2:721\n803#2:722\n777#2:723\n873#2,2:724\n777#2:726\n873#2,2:727\n777#2:729\n873#2,2:730\n*S KotlinDebug\n*F\n+ 1 StremioX.kt\ncom/phisher98/StremioX$Stream\n*L\n427#1:715\n427#1:716\n427#1:717,2\n427#1:719,2\n427#1:721\n427#1:722\n428#1:723\n428#1:724,2\n431#1:726\n431#1:727,2\n433#1:729\n433#1:730,2\n*E\n"})
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

        /* JADX WARN: Code duplicated, block: B:100:0x0365  */
        /* JADX WARN: Code duplicated, block: B:103:0x036b  */
        /* JADX WARN: Code duplicated, block: B:108:0x03ad A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:109:0x03ae  */
        /* JADX WARN: Code duplicated, block: B:111:0x03bc  */
        /* JADX WARN: Code duplicated, block: B:114:0x031c A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:117:0x02fc A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:123:0x025e A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:125:0x0242 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:129:0x02b4 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:30:0x012e A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:31:0x012f  */
        /* JADX WARN: Code duplicated, block: B:36:0x0137  */
        /* JADX WARN: Code duplicated, block: B:38:0x0159 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:39:0x015a  */
        /* JADX WARN: Code duplicated, block: B:41:0x015c  */
        /* JADX WARN: Code duplicated, block: B:44:0x0161  */
        /* JADX WARN: Code duplicated, block: B:46:0x0174 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:48:0x0178  */
        /* JADX WARN: Code duplicated, block: B:51:0x017e  */
        /* JADX WARN: Code duplicated, block: B:53:0x01c7 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:54:0x01c8  */
        /* JADX WARN: Code duplicated, block: B:58:0x01fc  */
        /* JADX WARN: Code duplicated, block: B:60:0x0204  */
        /* JADX WARN: Code duplicated, block: B:63:0x0217  */
        /* JADX WARN: Code duplicated, block: B:64:0x021a  */
        /* JADX WARN: Code duplicated, block: B:66:0x021e  */
        /* JADX WARN: Code duplicated, block: B:67:0x0224  */
        /* JADX WARN: Code duplicated, block: B:72:0x0248  */
        /* JADX WARN: Code duplicated, block: B:74:0x0259  */
        /* JADX WARN: Code duplicated, block: B:75:0x025b  */
        /* JADX WARN: Code duplicated, block: B:7:0x001a  */
        /* JADX WARN: Code duplicated, block: B:81:0x0299  */
        /* JADX WARN: Code duplicated, block: B:83:0x02b1  */
        /* JADX WARN: Code duplicated, block: B:87:0x02e6 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:88:0x02e7  */
        /* JADX WARN: Code duplicated, block: B:92:0x0302  */
        /* JADX WARN: Code duplicated, block: B:94:0x0315  */
        /* JADX WARN: Code duplicated, block: B:95:0x0318  */
        @Nullable
        public final Object runCallback(@NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
            StremioX$Stream$runCallback$1 stremioX$Stream$runCallback$1;
            Function1<? super SubtitleFile, Unit> function3;
            Object obj;
            Function1<? super ExtractorLink, Unit> function4;
            List<Subtitle> list;
            StremioX$Stream$runCallback$3 stremioX$Stream$runCallback$3;
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
            if (continuation instanceof StremioX$Stream$runCallback$1) {
                stremioX$Stream$runCallback$1 = (StremioX$Stream$runCallback$1) continuation;
                if ((stremioX$Stream$runCallback$1.label & Integer.MIN_VALUE) != 0) {
                    stremioX$Stream$runCallback$1.label -= Integer.MIN_VALUE;
                } else {
                    stremioX$Stream$runCallback$1 = new StremioX$Stream$runCallback$1(this, continuation);
                }
            } else {
                stremioX$Stream$runCallback$1 = new StremioX$Stream$runCallback$1(this, continuation);
            }
            StremioX$Stream$runCallback$1 stremioX$Stream$runCallback$2 = stremioX$Stream$runCallback$1;
            Object $result = stremioX$Stream$runCallback$2.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (stremioX$Stream$runCallback$2.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    if (this.url != null) {
                        String str5 = this.name;
                        if (str5 == null) {
                            str5 = "";
                        }
                        String strFixSourceName = UtilsKt.fixSourceName(this.name, this.title);
                        String str6 = this.url;
                        ExtractorLinkType infer_type = ExtractorApiKt.getINFER_TYPE();
                        StremioX$Stream$runCallback$2 stremioX$Stream$runCallback$4 = new StremioX$Stream$runCallback$2(this, null);
                        function3 = function1;
                        stremioX$Stream$runCallback$2.L$0 = function3;
                        stremioX$Stream$runCallback$2.L$1 = function12;
                        stremioX$Stream$runCallback$2.L$2 = function12;
                        stremioX$Stream$runCallback$2.label = 1;
                        Object objNewExtractorLink = ExtractorApiKt.newExtractorLink(str5, strFixSourceName, str6, infer_type, stremioX$Stream$runCallback$4, stremioX$Stream$runCallback$2);
                        if (objNewExtractorLink == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj = objNewExtractorLink;
                        function4 = function12;
                        function12.invoke(obj);
                        list = this.subtitles;
                        stremioX$Stream$runCallback$3 = new StremioX$Stream$runCallback$3(function3, null);
                        stremioX$Stream$runCallback$2.L$0 = function3;
                        stremioX$Stream$runCallback$2.L$1 = function4;
                        stremioX$Stream$runCallback$2.L$2 = null;
                        stremioX$Stream$runCallback$2.label = 2;
                        if (ParCollectionsKt.amap(list, stremioX$Stream$runCallback$3, stremioX$Stream$runCallback$2) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function12 = function4;
                    } else {
                        function3 = function1;
                    }
                    if (this.ytId != null) {
                        str = "https://www.youtube.com/watch?v=" + this.ytId;
                        stremioX$Stream$runCallback$2.L$0 = function3;
                        stremioX$Stream$runCallback$2.L$1 = function12;
                        stremioX$Stream$runCallback$2.label = 3;
                        if (ExtractorApiKt.loadExtractor(str, function3, function12, stremioX$Stream$runCallback$2) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function5 = function3;
                    } else {
                        function5 = function3;
                    }
                    if (this.externalUrl != null) {
                        str2 = this.externalUrl;
                        stremioX$Stream$runCallback$2.L$0 = SpillingKt.nullOutSpilledVariable(function5);
                        stremioX$Stream$runCallback$2.L$1 = function12;
                        stremioX$Stream$runCallback$2.label = 4;
                        if (ExtractorApiKt.loadExtractor(str2, function5, function12, stremioX$Stream$runCallback$2) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function6 = function5;
                    } else {
                        function6 = function5;
                    }
                    if (this.infoHash != null) {
                        Requests app = MainActivityKt.getApp();
                        stremioX$Stream$runCallback$2.L$0 = SpillingKt.nullOutSpilledVariable(function6);
                        stremioX$Stream$runCallback$2.L$1 = function12;
                        stremioX$Stream$runCallback$2.label = 5;
                        function7 = function12;
                        obj2 = coroutine_suspended;
                        continuation2 = null;
                        obj3 = Requests.get$default(app, StremioX.TRACKER_LIST_URL, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, stremioX$Stream$runCallback$2, 4094, (Object) null);
                        if (obj3 == obj2) {
                            stremioX$Stream$runCallback$2 = stremioX$Stream$runCallback$2;
                            return obj2;
                        }
                        stremioX$Stream$runCallback$2 = stremioX$Stream$runCallback$2;
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
                        otherTrackers = CollectionsKt.joinToString$default((List) destination$iv$iv2, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.phisher98.StremioX$Stream$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj5) {
                                return StremioX.Stream.runCallback$lambda$2((String) obj5);
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
                        StremioX$Stream$runCallback$sourceTrackers$2 stremioX$Stream$runCallback$sourceTrackers$2 = new StremioX$Stream$runCallback$sourceTrackers$2(continuation2);
                        stremioX$Stream$runCallback$2.L$0 = SpillingKt.nullOutSpilledVariable(function6);
                        stremioX$Stream$runCallback$2.L$1 = function8;
                        stremioX$Stream$runCallback$2.L$2 = SpillingKt.nullOutSpilledVariable(resp2);
                        stremioX$Stream$runCallback$2.L$3 = otherTrackers;
                        stremioX$Stream$runCallback$2.label = 6;
                        objAmap = ParCollectionsKt.amap((List) destination$iv$iv3, stremioX$Stream$runCallback$sourceTrackers$2, stremioX$Stream$runCallback$2);
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
                        String sourceTrackers = CollectionsKt.joinToString$default((List) destination$iv$iv4, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.phisher98.StremioX$Stream$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj5) {
                                return StremioX.Stream.runCallback$lambda$5((String) obj5);
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
                        StremioX$Stream$runCallback$4 stremioX$Stream$runCallback$5 = new StremioX$Stream$runCallback$4(continuation2);
                        stremioX$Stream$runCallback$2.L$0 = SpillingKt.nullOutSpilledVariable(function6);
                        stremioX$Stream$runCallback$2.L$1 = SpillingKt.nullOutSpilledVariable(function9);
                        stremioX$Stream$runCallback$2.L$2 = SpillingKt.nullOutSpilledVariable(resp3);
                        stremioX$Stream$runCallback$2.L$3 = SpillingKt.nullOutSpilledVariable(otherTrackers2);
                        stremioX$Stream$runCallback$2.L$4 = SpillingKt.nullOutSpilledVariable(sourceTrackers);
                        stremioX$Stream$runCallback$2.L$5 = SpillingKt.nullOutSpilledVariable(magnet);
                        stremioX$Stream$runCallback$2.L$6 = function9;
                        stremioX$Stream$runCallback$2.label = 7;
                        $result = ExtractorApiKt.newExtractorLink$default(str3, str4, magnet, (ExtractorLinkType) null, stremioX$Stream$runCallback$5, stremioX$Stream$runCallback$2, 8, (Object) null);
                        if ($result == obj2) {
                            return obj2;
                        }
                        function10 = function9;
                        function11 = function6;
                        function10.invoke($result);
                    }
                    return Unit.INSTANCE;
                case 1:
                    Function1<? super ExtractorLink, Unit> function13 = (Function1) stremioX$Stream$runCallback$2.L$2;
                    Function1<? super ExtractorLink, Unit> function14 = (Function1) stremioX$Stream$runCallback$2.L$1;
                    Function1<? super SubtitleFile, Unit> function15 = (Function1) stremioX$Stream$runCallback$2.L$0;
                    ResultKt.throwOnFailure($result);
                    function4 = function14;
                    function12 = function13;
                    function3 = function15;
                    obj = $result;
                    function12.invoke(obj);
                    list = this.subtitles;
                    stremioX$Stream$runCallback$3 = new StremioX$Stream$runCallback$3(function3, null);
                    stremioX$Stream$runCallback$2.L$0 = function3;
                    stremioX$Stream$runCallback$2.L$1 = function4;
                    stremioX$Stream$runCallback$2.L$2 = null;
                    stremioX$Stream$runCallback$2.label = 2;
                    if (ParCollectionsKt.amap(list, stremioX$Stream$runCallback$3, stremioX$Stream$runCallback$2) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function12 = function4;
                    if (this.ytId != null) {
                        str = "https://www.youtube.com/watch?v=" + this.ytId;
                        stremioX$Stream$runCallback$2.L$0 = function3;
                        stremioX$Stream$runCallback$2.L$1 = function12;
                        stremioX$Stream$runCallback$2.label = 3;
                        if (ExtractorApiKt.loadExtractor(str, function3, function12, stremioX$Stream$runCallback$2) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function5 = function3;
                    } else {
                        function5 = function3;
                    }
                    if (this.externalUrl != null) {
                        str2 = this.externalUrl;
                        stremioX$Stream$runCallback$2.L$0 = SpillingKt.nullOutSpilledVariable(function5);
                        stremioX$Stream$runCallback$2.L$1 = function12;
                        stremioX$Stream$runCallback$2.label = 4;
                        if (ExtractorApiKt.loadExtractor(str2, function5, function12, stremioX$Stream$runCallback$2) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function6 = function5;
                    } else {
                        function6 = function5;
                    }
                    if (this.infoHash != null) {
                        Requests app2 = MainActivityKt.getApp();
                        stremioX$Stream$runCallback$2.L$0 = SpillingKt.nullOutSpilledVariable(function6);
                        stremioX$Stream$runCallback$2.L$1 = function12;
                        stremioX$Stream$runCallback$2.label = 5;
                        function7 = function12;
                        obj2 = coroutine_suspended;
                        continuation2 = null;
                        obj3 = Requests.get$default(app2, StremioX.TRACKER_LIST_URL, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, stremioX$Stream$runCallback$2, 4094, (Object) null);
                        if (obj3 == obj2) {
                            stremioX$Stream$runCallback$2 = stremioX$Stream$runCallback$2;
                            return obj2;
                        }
                        stremioX$Stream$runCallback$2 = stremioX$Stream$runCallback$2;
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
                        otherTrackers = CollectionsKt.joinToString$default((List) destination$iv$iv2, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.phisher98.StremioX$Stream$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj5) {
                                return StremioX.Stream.runCallback$lambda$2((String) obj5);
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
                        StremioX$Stream$runCallback$sourceTrackers$2 stremioX$Stream$runCallback$sourceTrackers$3 = new StremioX$Stream$runCallback$sourceTrackers$2(continuation2);
                        stremioX$Stream$runCallback$2.L$0 = SpillingKt.nullOutSpilledVariable(function6);
                        stremioX$Stream$runCallback$2.L$1 = function8;
                        stremioX$Stream$runCallback$2.L$2 = SpillingKt.nullOutSpilledVariable(resp2);
                        stremioX$Stream$runCallback$2.L$3 = otherTrackers;
                        stremioX$Stream$runCallback$2.label = 6;
                        objAmap = ParCollectionsKt.amap((List) destination$iv$iv3, stremioX$Stream$runCallback$sourceTrackers$3, stremioX$Stream$runCallback$2);
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
                        String sourceTrackers2 = CollectionsKt.joinToString$default((List) destination$iv$iv4, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.phisher98.StremioX$Stream$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj5) {
                                return StremioX.Stream.runCallback$lambda$5((String) obj5);
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
                        StremioX$Stream$runCallback$4 stremioX$Stream$runCallback$6 = new StremioX$Stream$runCallback$4(continuation2);
                        stremioX$Stream$runCallback$2.L$0 = SpillingKt.nullOutSpilledVariable(function6);
                        stremioX$Stream$runCallback$2.L$1 = SpillingKt.nullOutSpilledVariable(function9);
                        stremioX$Stream$runCallback$2.L$2 = SpillingKt.nullOutSpilledVariable(resp3);
                        stremioX$Stream$runCallback$2.L$3 = SpillingKt.nullOutSpilledVariable(otherTrackers2);
                        stremioX$Stream$runCallback$2.L$4 = SpillingKt.nullOutSpilledVariable(sourceTrackers2);
                        stremioX$Stream$runCallback$2.L$5 = SpillingKt.nullOutSpilledVariable(magnet2);
                        stremioX$Stream$runCallback$2.L$6 = function9;
                        stremioX$Stream$runCallback$2.label = 7;
                        $result = ExtractorApiKt.newExtractorLink$default(str3, str4, magnet2, (ExtractorLinkType) null, stremioX$Stream$runCallback$6, stremioX$Stream$runCallback$2, 8, (Object) null);
                        if ($result == obj2) {
                            return obj2;
                        }
                        function10 = function9;
                        function11 = function6;
                        function10.invoke($result);
                    }
                    return Unit.INSTANCE;
                case 2:
                    function12 = (Function1) stremioX$Stream$runCallback$2.L$1;
                    Function1<? super SubtitleFile, Unit> function16 = (Function1) stremioX$Stream$runCallback$2.L$0;
                    ResultKt.throwOnFailure($result);
                    function3 = function16;
                    if (this.ytId != null) {
                        str = "https://www.youtube.com/watch?v=" + this.ytId;
                        stremioX$Stream$runCallback$2.L$0 = function3;
                        stremioX$Stream$runCallback$2.L$1 = function12;
                        stremioX$Stream$runCallback$2.label = 3;
                        if (ExtractorApiKt.loadExtractor(str, function3, function12, stremioX$Stream$runCallback$2) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function5 = function3;
                    } else {
                        function5 = function3;
                    }
                    if (this.externalUrl != null) {
                        str2 = this.externalUrl;
                        stremioX$Stream$runCallback$2.L$0 = SpillingKt.nullOutSpilledVariable(function5);
                        stremioX$Stream$runCallback$2.L$1 = function12;
                        stremioX$Stream$runCallback$2.label = 4;
                        if (ExtractorApiKt.loadExtractor(str2, function5, function12, stremioX$Stream$runCallback$2) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function6 = function5;
                    } else {
                        function6 = function5;
                    }
                    if (this.infoHash != null) {
                        Requests app3 = MainActivityKt.getApp();
                        stremioX$Stream$runCallback$2.L$0 = SpillingKt.nullOutSpilledVariable(function6);
                        stremioX$Stream$runCallback$2.L$1 = function12;
                        stremioX$Stream$runCallback$2.label = 5;
                        function7 = function12;
                        obj2 = coroutine_suspended;
                        continuation2 = null;
                        obj3 = Requests.get$default(app3, StremioX.TRACKER_LIST_URL, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, stremioX$Stream$runCallback$2, 4094, (Object) null);
                        if (obj3 == obj2) {
                            stremioX$Stream$runCallback$2 = stremioX$Stream$runCallback$2;
                            return obj2;
                        }
                        stremioX$Stream$runCallback$2 = stremioX$Stream$runCallback$2;
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
                        otherTrackers = CollectionsKt.joinToString$default((List) destination$iv$iv2, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.phisher98.StremioX$Stream$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj5) {
                                return StremioX.Stream.runCallback$lambda$2((String) obj5);
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
                        StremioX$Stream$runCallback$sourceTrackers$2 stremioX$Stream$runCallback$sourceTrackers$4 = new StremioX$Stream$runCallback$sourceTrackers$2(continuation2);
                        stremioX$Stream$runCallback$2.L$0 = SpillingKt.nullOutSpilledVariable(function6);
                        stremioX$Stream$runCallback$2.L$1 = function8;
                        stremioX$Stream$runCallback$2.L$2 = SpillingKt.nullOutSpilledVariable(resp2);
                        stremioX$Stream$runCallback$2.L$3 = otherTrackers;
                        stremioX$Stream$runCallback$2.label = 6;
                        objAmap = ParCollectionsKt.amap((List) destination$iv$iv3, stremioX$Stream$runCallback$sourceTrackers$4, stremioX$Stream$runCallback$2);
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
                        String sourceTrackers3 = CollectionsKt.joinToString$default((List) destination$iv$iv4, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.phisher98.StremioX$Stream$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj5) {
                                return StremioX.Stream.runCallback$lambda$5((String) obj5);
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
                        StremioX$Stream$runCallback$4 stremioX$Stream$runCallback$7 = new StremioX$Stream$runCallback$4(continuation2);
                        stremioX$Stream$runCallback$2.L$0 = SpillingKt.nullOutSpilledVariable(function6);
                        stremioX$Stream$runCallback$2.L$1 = SpillingKt.nullOutSpilledVariable(function9);
                        stremioX$Stream$runCallback$2.L$2 = SpillingKt.nullOutSpilledVariable(resp3);
                        stremioX$Stream$runCallback$2.L$3 = SpillingKt.nullOutSpilledVariable(otherTrackers2);
                        stremioX$Stream$runCallback$2.L$4 = SpillingKt.nullOutSpilledVariable(sourceTrackers3);
                        stremioX$Stream$runCallback$2.L$5 = SpillingKt.nullOutSpilledVariable(magnet3);
                        stremioX$Stream$runCallback$2.L$6 = function9;
                        stremioX$Stream$runCallback$2.label = 7;
                        $result = ExtractorApiKt.newExtractorLink$default(str3, str4, magnet3, (ExtractorLinkType) null, stremioX$Stream$runCallback$7, stremioX$Stream$runCallback$2, 8, (Object) null);
                        if ($result == obj2) {
                            return obj2;
                        }
                        function10 = function9;
                        function11 = function6;
                        function10.invoke($result);
                    }
                    return Unit.INSTANCE;
                case 3:
                    function12 = (Function1) stremioX$Stream$runCallback$2.L$1;
                    function5 = (Function1) stremioX$Stream$runCallback$2.L$0;
                    ResultKt.throwOnFailure($result);
                    if (this.externalUrl != null) {
                        str2 = this.externalUrl;
                        stremioX$Stream$runCallback$2.L$0 = SpillingKt.nullOutSpilledVariable(function5);
                        stremioX$Stream$runCallback$2.L$1 = function12;
                        stremioX$Stream$runCallback$2.label = 4;
                        if (ExtractorApiKt.loadExtractor(str2, function5, function12, stremioX$Stream$runCallback$2) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function6 = function5;
                    } else {
                        function6 = function5;
                    }
                    if (this.infoHash != null) {
                        Requests app4 = MainActivityKt.getApp();
                        stremioX$Stream$runCallback$2.L$0 = SpillingKt.nullOutSpilledVariable(function6);
                        stremioX$Stream$runCallback$2.L$1 = function12;
                        stremioX$Stream$runCallback$2.label = 5;
                        function7 = function12;
                        obj2 = coroutine_suspended;
                        continuation2 = null;
                        obj3 = Requests.get$default(app4, StremioX.TRACKER_LIST_URL, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, stremioX$Stream$runCallback$2, 4094, (Object) null);
                        if (obj3 == obj2) {
                            stremioX$Stream$runCallback$2 = stremioX$Stream$runCallback$2;
                            return obj2;
                        }
                        stremioX$Stream$runCallback$2 = stremioX$Stream$runCallback$2;
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
                        otherTrackers = CollectionsKt.joinToString$default((List) destination$iv$iv2, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.phisher98.StremioX$Stream$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj5) {
                                return StremioX.Stream.runCallback$lambda$2((String) obj5);
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
                        StremioX$Stream$runCallback$sourceTrackers$2 stremioX$Stream$runCallback$sourceTrackers$5 = new StremioX$Stream$runCallback$sourceTrackers$2(continuation2);
                        stremioX$Stream$runCallback$2.L$0 = SpillingKt.nullOutSpilledVariable(function6);
                        stremioX$Stream$runCallback$2.L$1 = function8;
                        stremioX$Stream$runCallback$2.L$2 = SpillingKt.nullOutSpilledVariable(resp2);
                        stremioX$Stream$runCallback$2.L$3 = otherTrackers;
                        stremioX$Stream$runCallback$2.label = 6;
                        objAmap = ParCollectionsKt.amap((List) destination$iv$iv3, stremioX$Stream$runCallback$sourceTrackers$5, stremioX$Stream$runCallback$2);
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
                        String sourceTrackers4 = CollectionsKt.joinToString$default((List) destination$iv$iv4, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.phisher98.StremioX$Stream$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj5) {
                                return StremioX.Stream.runCallback$lambda$5((String) obj5);
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
                        StremioX$Stream$runCallback$4 stremioX$Stream$runCallback$8 = new StremioX$Stream$runCallback$4(continuation2);
                        stremioX$Stream$runCallback$2.L$0 = SpillingKt.nullOutSpilledVariable(function6);
                        stremioX$Stream$runCallback$2.L$1 = SpillingKt.nullOutSpilledVariable(function9);
                        stremioX$Stream$runCallback$2.L$2 = SpillingKt.nullOutSpilledVariable(resp3);
                        stremioX$Stream$runCallback$2.L$3 = SpillingKt.nullOutSpilledVariable(otherTrackers2);
                        stremioX$Stream$runCallback$2.L$4 = SpillingKt.nullOutSpilledVariable(sourceTrackers4);
                        stremioX$Stream$runCallback$2.L$5 = SpillingKt.nullOutSpilledVariable(magnet4);
                        stremioX$Stream$runCallback$2.L$6 = function9;
                        stremioX$Stream$runCallback$2.label = 7;
                        $result = ExtractorApiKt.newExtractorLink$default(str3, str4, magnet4, (ExtractorLinkType) null, stremioX$Stream$runCallback$8, stremioX$Stream$runCallback$2, 8, (Object) null);
                        if ($result == obj2) {
                            return obj2;
                        }
                        function10 = function9;
                        function11 = function6;
                        function10.invoke($result);
                    }
                    return Unit.INSTANCE;
                case 4:
                    function12 = (Function1) stremioX$Stream$runCallback$2.L$1;
                    function5 = (Function1) stremioX$Stream$runCallback$2.L$0;
                    ResultKt.throwOnFailure($result);
                    function6 = function5;
                    if (this.infoHash != null) {
                        Requests app5 = MainActivityKt.getApp();
                        stremioX$Stream$runCallback$2.L$0 = SpillingKt.nullOutSpilledVariable(function6);
                        stremioX$Stream$runCallback$2.L$1 = function12;
                        stremioX$Stream$runCallback$2.label = 5;
                        function7 = function12;
                        obj2 = coroutine_suspended;
                        continuation2 = null;
                        obj3 = Requests.get$default(app5, StremioX.TRACKER_LIST_URL, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, stremioX$Stream$runCallback$2, 4094, (Object) null);
                        if (obj3 == obj2) {
                            stremioX$Stream$runCallback$2 = stremioX$Stream$runCallback$2;
                            return obj2;
                        }
                        stremioX$Stream$runCallback$2 = stremioX$Stream$runCallback$2;
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
                        otherTrackers = CollectionsKt.joinToString$default((List) destination$iv$iv2, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.phisher98.StremioX$Stream$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj5) {
                                return StremioX.Stream.runCallback$lambda$2((String) obj5);
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
                        StremioX$Stream$runCallback$sourceTrackers$2 stremioX$Stream$runCallback$sourceTrackers$6 = new StremioX$Stream$runCallback$sourceTrackers$2(continuation2);
                        stremioX$Stream$runCallback$2.L$0 = SpillingKt.nullOutSpilledVariable(function6);
                        stremioX$Stream$runCallback$2.L$1 = function8;
                        stremioX$Stream$runCallback$2.L$2 = SpillingKt.nullOutSpilledVariable(resp2);
                        stremioX$Stream$runCallback$2.L$3 = otherTrackers;
                        stremioX$Stream$runCallback$2.label = 6;
                        objAmap = ParCollectionsKt.amap((List) destination$iv$iv3, stremioX$Stream$runCallback$sourceTrackers$6, stremioX$Stream$runCallback$2);
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
                        String sourceTrackers5 = CollectionsKt.joinToString$default((List) destination$iv$iv4, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.phisher98.StremioX$Stream$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj5) {
                                return StremioX.Stream.runCallback$lambda$5((String) obj5);
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
                        StremioX$Stream$runCallback$4 stremioX$Stream$runCallback$9 = new StremioX$Stream$runCallback$4(continuation2);
                        stremioX$Stream$runCallback$2.L$0 = SpillingKt.nullOutSpilledVariable(function6);
                        stremioX$Stream$runCallback$2.L$1 = SpillingKt.nullOutSpilledVariable(function9);
                        stremioX$Stream$runCallback$2.L$2 = SpillingKt.nullOutSpilledVariable(resp3);
                        stremioX$Stream$runCallback$2.L$3 = SpillingKt.nullOutSpilledVariable(otherTrackers2);
                        stremioX$Stream$runCallback$2.L$4 = SpillingKt.nullOutSpilledVariable(sourceTrackers5);
                        stremioX$Stream$runCallback$2.L$5 = SpillingKt.nullOutSpilledVariable(magnet5);
                        stremioX$Stream$runCallback$2.L$6 = function9;
                        stremioX$Stream$runCallback$2.label = 7;
                        $result = ExtractorApiKt.newExtractorLink$default(str3, str4, magnet5, (ExtractorLinkType) null, stremioX$Stream$runCallback$9, stremioX$Stream$runCallback$2, 8, (Object) null);
                        if ($result == obj2) {
                            return obj2;
                        }
                        function10 = function9;
                        function11 = function6;
                        function10.invoke($result);
                    }
                    return Unit.INSTANCE;
                case 5:
                    Function1<? super ExtractorLink, Unit> function17 = (Function1) stremioX$Stream$runCallback$2.L$1;
                    Function1<? super SubtitleFile, Unit> function18 = (Function1) stremioX$Stream$runCallback$2.L$0;
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
                    otherTrackers = CollectionsKt.joinToString$default((List) destination$iv$iv2, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.phisher98.StremioX$Stream$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj5) {
                            return StremioX.Stream.runCallback$lambda$2((String) obj5);
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
                    StremioX$Stream$runCallback$sourceTrackers$2 stremioX$Stream$runCallback$sourceTrackers$7 = new StremioX$Stream$runCallback$sourceTrackers$2(continuation2);
                    stremioX$Stream$runCallback$2.L$0 = SpillingKt.nullOutSpilledVariable(function6);
                    stremioX$Stream$runCallback$2.L$1 = function8;
                    stremioX$Stream$runCallback$2.L$2 = SpillingKt.nullOutSpilledVariable(resp2);
                    stremioX$Stream$runCallback$2.L$3 = otherTrackers;
                    stremioX$Stream$runCallback$2.label = 6;
                    objAmap = ParCollectionsKt.amap((List) destination$iv$iv3, stremioX$Stream$runCallback$sourceTrackers$7, stremioX$Stream$runCallback$2);
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
                    String sourceTrackers6 = CollectionsKt.joinToString$default((List) destination$iv$iv4, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.phisher98.StremioX$Stream$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj5) {
                            return StremioX.Stream.runCallback$lambda$5((String) obj5);
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
                    StremioX$Stream$runCallback$4 stremioX$Stream$runCallback$10 = new StremioX$Stream$runCallback$4(continuation2);
                    stremioX$Stream$runCallback$2.L$0 = SpillingKt.nullOutSpilledVariable(function6);
                    stremioX$Stream$runCallback$2.L$1 = SpillingKt.nullOutSpilledVariable(function9);
                    stremioX$Stream$runCallback$2.L$2 = SpillingKt.nullOutSpilledVariable(resp3);
                    stremioX$Stream$runCallback$2.L$3 = SpillingKt.nullOutSpilledVariable(otherTrackers2);
                    stremioX$Stream$runCallback$2.L$4 = SpillingKt.nullOutSpilledVariable(sourceTrackers6);
                    stremioX$Stream$runCallback$2.L$5 = SpillingKt.nullOutSpilledVariable(magnet6);
                    stremioX$Stream$runCallback$2.L$6 = function9;
                    stremioX$Stream$runCallback$2.label = 7;
                    $result = ExtractorApiKt.newExtractorLink$default(str3, str4, magnet6, (ExtractorLinkType) null, stremioX$Stream$runCallback$10, stremioX$Stream$runCallback$2, 8, (Object) null);
                    if ($result == obj2) {
                        return obj2;
                    }
                    function10 = function9;
                    function11 = function6;
                    function10.invoke($result);
                    return Unit.INSTANCE;
                case 6:
                    String otherTrackers3 = (String) stremioX$Stream$runCallback$2.L$3;
                    String resp10 = (String) stremioX$Stream$runCallback$2.L$2;
                    Function1<? super ExtractorLink, Unit> function19 = (Function1) stremioX$Stream$runCallback$2.L$1;
                    Function1<? super SubtitleFile, Unit> function20 = (Function1) stremioX$Stream$runCallback$2.L$0;
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
                    String sourceTrackers7 = CollectionsKt.joinToString$default((List) destination$iv$iv4, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.phisher98.StremioX$Stream$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj5) {
                            return StremioX.Stream.runCallback$lambda$5((String) obj5);
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
                    StremioX$Stream$runCallback$4 stremioX$Stream$runCallback$11 = new StremioX$Stream$runCallback$4(continuation2);
                    stremioX$Stream$runCallback$2.L$0 = SpillingKt.nullOutSpilledVariable(function6);
                    stremioX$Stream$runCallback$2.L$1 = SpillingKt.nullOutSpilledVariable(function9);
                    stremioX$Stream$runCallback$2.L$2 = SpillingKt.nullOutSpilledVariable(resp3);
                    stremioX$Stream$runCallback$2.L$3 = SpillingKt.nullOutSpilledVariable(otherTrackers2);
                    stremioX$Stream$runCallback$2.L$4 = SpillingKt.nullOutSpilledVariable(sourceTrackers7);
                    stremioX$Stream$runCallback$2.L$5 = SpillingKt.nullOutSpilledVariable(magnet7);
                    stremioX$Stream$runCallback$2.L$6 = function9;
                    stremioX$Stream$runCallback$2.label = 7;
                    $result = ExtractorApiKt.newExtractorLink$default(str3, str4, magnet7, (ExtractorLinkType) null, stremioX$Stream$runCallback$11, stremioX$Stream$runCallback$2, 8, (Object) null);
                    if ($result == obj2) {
                        return obj2;
                    }
                    function10 = function9;
                    function11 = function6;
                    function10.invoke($result);
                    return Unit.INSTANCE;
                case 7:
                    function10 = (Function1) stremioX$Stream$runCallback$2.L$6;
                    function11 = (Function1) stremioX$Stream$runCallback$2.L$0;
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

    /* JADX INFO: compiled from: StremioX.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/phisher98/StremioX$LoadData;", "", "imdbId", "", "season", "", "episode", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getImdbId", "()Ljava/lang/String;", "getSeason", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEpisode", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/phisher98/StremioX$LoadData;", "equals", "", "other", "hashCode", "toString", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
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

    /* JADX INFO: compiled from: StremioX.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ>\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0005HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/phisher98/StremioX$Data;", "", "id", "", "type", "", "aniId", "malId", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getType", "()Ljava/lang/String;", "getAniId", "getMalId", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/phisher98/StremioX$Data;", "equals", "", "other", "hashCode", "toString", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
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

    /* JADX INFO: compiled from: StremioX.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J5\u0010\r\u001a\u00020\u00002*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R%\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/phisher98/StremioX$Results;", "", "results", "Ljava/util/ArrayList;", "Lcom/phisher98/StremioX$Media;", "Lkotlin/collections/ArrayList;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Ljava/util/ArrayList;)V", "getResults", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
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

    /* JADX INFO: compiled from: StremioX.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B£\u0001\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003Jª\u0001\u0010 \u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n2\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f2\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000eHÆ\u0001¢\u0006\u0002\u0010!J\u0014\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010%\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010&\u001a\u00020\u0007HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015¨\u0006'"}, d2 = {"Lcom/phisher98/StremioX$Media;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "name", "", "title", "originalTitle", "original_title", "mediaType", "media_type", "posterPath", "poster_path", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "getTitle", "getOriginalTitle", "getMediaType", "getPosterPath", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/phisher98/StremioX$Media;", "equals", "", "other", "hashCode", "toString", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
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

    /* JADX INFO: compiled from: StremioX.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0007HÆ\u0003JB\u0010\u0011\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0007HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/phisher98/StremioX$Genres;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "name", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/phisher98/StremioX$Genres;", "equals", "", "other", "hashCode", "toString", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
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

    /* JADX INFO: compiled from: StremioX.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0007HÆ\u0003JB\u0010\u0011\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0007HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/phisher98/StremioX$Keywords;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "name", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/phisher98/StremioX$Keywords;", "equals", "", "other", "hashCode", "toString", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
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

    /* JADX INFO: compiled from: StremioX.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002\u0012*\b\u0003\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J\u001d\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003Ja\u0010\u0010\u001a\u00020\u00002*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u00022*\b\u0003\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bHÆ\u0001J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004R%\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR%\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/phisher98/StremioX$KeywordResults;", "", "results", "Ljava/util/ArrayList;", "Lcom/phisher98/StremioX$Keywords;", "Lkotlin/collections/ArrayList;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "keywords", "<init>", "(Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getResults", "()Ljava/util/ArrayList;", "getKeywords", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
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

    /* JADX INFO: compiled from: StremioX.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t\u0012\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003Jv\u0010\u0019\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t2\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000bHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0014\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001f\u001a\u00020\u0007HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0013\u0010\u000fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012¨\u0006 "}, d2 = {"Lcom/phisher98/StremioX$Seasons;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "name", "", "seasonNumber", "season_number", "airDate", "air_date", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "getSeasonNumber", "getAirDate", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/phisher98/StremioX$Seasons;", "equals", "", "other", "hashCode", "toString", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
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

    /* JADX INFO: compiled from: StremioX.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B£\u0001\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t\u0012\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003Jª\u0001\u0010 \u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t2\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n2\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f2\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000eHÆ\u0001¢\u0006\u0002\u0010!J\u0014\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010%\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010&\u001a\u00020\u0007HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015¨\u0006'"}, d2 = {"Lcom/phisher98/StremioX$Cast;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "name", "", "originalName", "original_name", "character", "knownForDepartment", "known_for_department", "profilePath", "profile_path", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "getOriginalName", "getCharacter", "getKnownForDepartment", "getProfilePath", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/phisher98/StremioX$Cast;", "equals", "", "other", "hashCode", "toString", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
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

    /* JADX INFO: compiled from: StremioX.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B×\u0001\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u000e:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f\u0012\u0018\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0011\u0012\u0018\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010$\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017JÞ\u0001\u0010+\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n2\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f2\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u000e:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f2\u0018\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00112\u0018\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0013HÆ\u0001¢\u0006\u0002\u0010,J\u0014\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00100\u001a\u00020\u0003HÖ\u0081\u0004J\n\u00101\u001a\u00020\u0007HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b!\u0010\u0017R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\"\u0010\u0017¨\u00062"}, d2 = {"Lcom/phisher98/StremioX$Episodes;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "name", "", "overview", "airDate", "air_date", "stillPath", "still_path", "voteAverage", "", "vote_average", "episodeNumber", "episode_number", "seasonNumber", "season_number", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "getOverview", "getAirDate", "getStillPath", "getVoteAverage", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getEpisodeNumber", "getSeasonNumber", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/phisher98/StremioX$Episodes;", "equals", "", "other", "hashCode", "toString", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
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
        private final Integer seasonNumber;

        @Nullable
        private final String stillPath;

        @Nullable
        private final Double voteAverage;

        public Episodes() {
            this(null, null, null, null, null, null, null, null, 255, null);
        }

        public static /* synthetic */ Episodes copy$default(Episodes episodes, Integer num, String str, String str2, String str3, String str4, Double d, Integer num2, Integer num3, int i, Object obj) {
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
                d = episodes.voteAverage;
            }
            if ((i & 64) != 0) {
                num2 = episodes.episodeNumber;
            }
            if ((i & 128) != 0) {
                num3 = episodes.seasonNumber;
            }
            Integer num4 = num2;
            Integer num5 = num3;
            String str5 = str4;
            Double d2 = d;
            return episodes.copy(num, str, str2, str3, str5, d2, num4, num5);
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
        public final Double getVoteAverage() {
            return this.voteAverage;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Integer getEpisodeNumber() {
            return this.episodeNumber;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Integer getSeasonNumber() {
            return this.seasonNumber;
        }

        @NotNull
        public final Episodes copy(@JsonProperty("id") @Nullable Integer id, @JsonProperty("name") @Nullable String name, @JsonProperty("overview") @Nullable String overview, @JsonProperty("air_date") @Nullable String airDate, @JsonProperty("still_path") @Nullable String stillPath, @JsonProperty("vote_average") @Nullable Double voteAverage, @JsonProperty("episode_number") @Nullable Integer episodeNumber, @JsonProperty("season_number") @Nullable Integer seasonNumber) {
            return new Episodes(id, name, overview, airDate, stillPath, voteAverage, episodeNumber, seasonNumber);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Episodes)) {
                return false;
            }
            Episodes episodes = (Episodes) other;
            return Intrinsics.areEqual(this.id, episodes.id) && Intrinsics.areEqual(this.name, episodes.name) && Intrinsics.areEqual(this.overview, episodes.overview) && Intrinsics.areEqual(this.airDate, episodes.airDate) && Intrinsics.areEqual(this.stillPath, episodes.stillPath) && Intrinsics.areEqual(this.voteAverage, episodes.voteAverage) && Intrinsics.areEqual(this.episodeNumber, episodes.episodeNumber) && Intrinsics.areEqual(this.seasonNumber, episodes.seasonNumber);
        }

        public int hashCode() {
            return ((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.overview == null ? 0 : this.overview.hashCode())) * 31) + (this.airDate == null ? 0 : this.airDate.hashCode())) * 31) + (this.stillPath == null ? 0 : this.stillPath.hashCode())) * 31) + (this.voteAverage == null ? 0 : this.voteAverage.hashCode())) * 31) + (this.episodeNumber == null ? 0 : this.episodeNumber.hashCode())) * 31) + (this.seasonNumber != null ? this.seasonNumber.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Episodes(id=" + this.id + ", name=" + this.name + ", overview=" + this.overview + ", airDate=" + this.airDate + ", stillPath=" + this.stillPath + ", voteAverage=" + this.voteAverage + ", episodeNumber=" + this.episodeNumber + ", seasonNumber=" + this.seasonNumber + ')';
        }

        public Episodes(@JsonProperty("id") @Nullable Integer id, @JsonProperty("name") @Nullable String name, @JsonProperty("overview") @Nullable String overview, @JsonProperty("air_date") @Nullable String airDate, @JsonProperty("still_path") @Nullable String stillPath, @JsonProperty("vote_average") @Nullable Double voteAverage, @JsonProperty("episode_number") @Nullable Integer episodeNumber, @JsonProperty("season_number") @Nullable Integer seasonNumber) {
            this.id = id;
            this.name = name;
            this.overview = overview;
            this.airDate = airDate;
            this.stillPath = stillPath;
            this.voteAverage = voteAverage;
            this.episodeNumber = episodeNumber;
            this.seasonNumber = seasonNumber;
        }

        public /* synthetic */ Episodes(Integer num, String str, String str2, String str3, String str4, Double d, Integer num2, Integer num3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : d, (i & 64) != 0 ? null : num2, (i & 128) != 0 ? null : num3);
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

    /* JADX INFO: compiled from: StremioX.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J5\u0010\r\u001a\u00020\u00002*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R%\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/phisher98/StremioX$MediaDetailEpisodes;", "", "episodes", "Ljava/util/ArrayList;", "Lcom/phisher98/StremioX$Episodes;", "Lkotlin/collections/ArrayList;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Ljava/util/ArrayList;)V", "getEpisodes", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
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

    /* JADX INFO: compiled from: StremioX.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J#\u0010\u000b\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/phisher98/StremioX$Trailers;", "", "key", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
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

    /* JADX INFO: compiled from: StremioX.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J5\u0010\r\u001a\u00020\u00002*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R%\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/phisher98/StremioX$ResultsTrailer;", "", "results", "Ljava/util/ArrayList;", "Lcom/phisher98/StremioX$Trailers;", "Lkotlin/collections/ArrayList;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Ljava/util/ArrayList;)V", "getResults", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
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

    /* JADX INFO: compiled from: StremioX.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ&\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004R#\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0007z\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0002¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR%\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0007z\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/phisher98/StremioX$ExternalIds;", "", "imdb_id", "", "tvdb_id", "", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getImdb_id", "()Ljava/lang/String;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "getTvdb_id", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/phisher98/StremioX$ExternalIds;", "equals", "", "other", "hashCode", "toString", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class ExternalIds {

        @Nullable
        private final String imdb_id;

        @Nullable
        private final Integer tvdb_id;

        /* JADX WARN: Multi-variable type inference failed */
        public ExternalIds() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ ExternalIds copy$default(ExternalIds externalIds, String str, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                str = externalIds.imdb_id;
            }
            if ((i & 2) != 0) {
                num = externalIds.tvdb_id;
            }
            return externalIds.copy(str, num);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getImdb_id() {
            return this.imdb_id;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getTvdb_id() {
            return this.tvdb_id;
        }

        @NotNull
        public final ExternalIds copy(@Nullable String imdb_id, @Nullable Integer tvdb_id) {
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

        public ExternalIds(@Nullable String imdb_id, @Nullable Integer tvdb_id) {
            this.imdb_id = imdb_id;
            this.tvdb_id = tvdb_id;
        }

        public /* synthetic */ ExternalIds(String str, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num);
        }

        @JsonProperty("imdb_id")
        @Nullable
        public final String getImdb_id() {
            return this.imdb_id;
        }

        @JsonProperty("tvdb_id")
        @Nullable
        public final Integer getTvdb_id() {
            return this.tvdb_id;
        }
    }

    /* JADX INFO: compiled from: StremioX.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J5\u0010\r\u001a\u00020\u00002*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R%\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/phisher98/StremioX$Credits;", "", "cast", "Ljava/util/ArrayList;", "Lcom/phisher98/StremioX$Cast;", "Lkotlin/collections/ArrayList;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Ljava/util/ArrayList;)V", "getCast", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
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

    /* JADX INFO: compiled from: StremioX.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J5\u0010\r\u001a\u00020\u00002*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R%\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/phisher98/StremioX$ResultsRecommendations;", "", "results", "Ljava/util/ArrayList;", "Lcom/phisher98/StremioX$Media;", "Lkotlin/collections/ArrayList;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Ljava/util/ArrayList;)V", "getResults", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
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

    /* JADX INFO: compiled from: StremioX.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJB\u0010\u000f\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/phisher98/StremioX$LastEpisodeToAir;", "", "episode_number", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "season_number", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getEpisode_number", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSeason_number", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/phisher98/StremioX$LastEpisodeToAir;", "equals", "", "other", "hashCode", "toString", "", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
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

    /* JADX INFO: compiled from: StremioX.kt */
    @Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\bF\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bé\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\u001c\b\u0002\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\u001c\b\u0002\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\u0016\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&\u0012\u001c\b\u0002\u0010'\u001a\u0016\u0012\u0004\u0012\u00020(\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020(\u0018\u0001`\u0016¢\u0006\u0004\b)\u0010*J\u0010\u0010Y\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010,J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010,J\u000b\u0010e\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001d\u0010h\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\u0016HÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u001d\u0010k\u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\u0016HÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010 HÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\"HÆ\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010$HÆ\u0003J\u000b\u0010p\u001a\u0004\u0018\u00010&HÆ\u0003J\u001d\u0010q\u001a\u0016\u0012\u0004\u0012\u00020(\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020(\u0018\u0001`\u0016HÆ\u0003Jð\u0002\u0010r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u001c\b\u0002\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u001c\b\u0002\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\u00162\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\u001c\b\u0002\u0010'\u001a\u0016\u0012\u0004\u0012\u00020(\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020(\u0018\u0001`\u0016HÆ\u0001¢\u0006\u0002\u0010sJ\u0014\u0010t\u001a\u00020u2\b\u0010v\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010w\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010x\u001a\u00020\u0005HÖ\u0081\u0004R%\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0007z\f\b.\u0012\b\b/\u0012\u0004\b\b(\u0002¢\u0006\n\n\u0002\u0010-\u001a\u0004\b+\u0010,R#\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0007z\f\b.\u0012\b\b/\u0012\u0004\b\b(2¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R#\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0007z\f\b.\u0012\b\b/\u0012\u0004\b\b(\u0006¢\u0006\b\n\u0000\u001a\u0004\b3\u00101R#\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0007z\f\b.\u0012\b\b/\u0012\u0004\b\b(\u0007¢\u0006\b\n\u0000\u001a\u0004\b4\u00101R#\u0010\b\u001a\u0004\u0018\u00010\u00058\u0007z\f\b.\u0012\b\b/\u0012\u0004\b\b(6¢\u0006\b\n\u0000\u001a\u0004\b5\u00101R#\u0010\t\u001a\u0004\u0018\u00010\u00058\u0007z\f\b.\u0012\b\b/\u0012\u0004\b\b(8¢\u0006\b\n\u0000\u001a\u0004\b7\u00101R#\u0010\n\u001a\u0004\u0018\u00010\u00058\u0007z\f\b.\u0012\b\b/\u0012\u0004\b\b(:¢\u0006\b\n\u0000\u001a\u0004\b9\u00101R#\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0007z\f\b.\u0012\b\b/\u0012\u0004\b\b(<¢\u0006\b\n\u0000\u001a\u0004\b;\u00101R#\u0010\f\u001a\u0004\u0018\u00010\u00058\u0007z\f\b.\u0012\b\b/\u0012\u0004\b\b(>¢\u0006\b\n\u0000\u001a\u0004\b=\u00101R#\u0010\r\u001a\u0004\u0018\u00010\u00058\u0007z\f\b.\u0012\b\b/\u0012\u0004\b\b(@¢\u0006\b\n\u0000\u001a\u0004\b?\u00101R#\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0007z\f\b.\u0012\b\b/\u0012\u0004\b\b(\u000e¢\u0006\b\n\u0000\u001a\u0004\bA\u00101R%\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0007z\f\b.\u0012\b\b/\u0012\u0004\b\b(\u000f¢\u0006\n\n\u0002\u0010-\u001a\u0004\bB\u0010,R#\u0010\u0010\u001a\u0004\u0018\u00010\u00018\u0007z\f\b.\u0012\b\b/\u0012\u0004\b\b(\u0010¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR#\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0007z\f\b.\u0012\b\b/\u0012\u0004\b\b(\u0011¢\u0006\b\n\u0000\u001a\u0004\bE\u00101R#\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0007z\f\b.\u0012\b\b/\u0012\u0004\b\b(\u0012¢\u0006\b\n\u0000\u001a\u0004\bF\u00101R5\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\u00168\u0007z\f\b.\u0012\b\b/\u0012\u0004\b\b(\u0013¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR#\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0007z\f\b.\u0012\b\b/\u0012\u0004\b\b(\u0017¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR#\u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0007z\f\b.\u0012\b\b/\u0012\u0004\b\b(\u0019¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR5\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\u00168\u0007z\f\b.\u0012\b\b/\u0012\u0004\b\b(\u001b¢\u0006\b\n\u0000\u001a\u0004\bM\u0010HR#\u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0007z\f\b.\u0012\b\b/\u0012\u0004\b\b(\u001d¢\u0006\b\n\u0000\u001a\u0004\bN\u0010OR#\u0010\u001f\u001a\u0004\u0018\u00010 8\u0007z\f\b.\u0012\b\b/\u0012\u0004\b\b(\u001f¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR#\u0010!\u001a\u0004\u0018\u00010\"8\u0007z\f\b.\u0012\b\b/\u0012\u0004\b\b(!¢\u0006\b\n\u0000\u001a\u0004\bR\u0010SR#\u0010#\u001a\u0004\u0018\u00010$8\u0007z\f\b.\u0012\b\b/\u0012\u0004\b\b(#¢\u0006\b\n\u0000\u001a\u0004\bT\u0010UR#\u0010%\u001a\u0004\u0018\u00010&8\u0007z\f\b.\u0012\b\b/\u0012\u0004\b\b(%¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR5\u0010'\u001a\u0016\u0012\u0004\u0012\u00020(\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020(\u0018\u0001`\u00168\u0007z\f\b.\u0012\b\b/\u0012\u0004\b\b('¢\u0006\b\n\u0000\u001a\u0004\bX\u0010H¨\u0006y"}, d2 = {"Lcom/phisher98/StremioX$MediaDetail;", "", "id", "", "imdbId", "", "title", "name", "originalTitle", "originalName", "posterPath", "backdropPath", "releaseDate", "firstAirDate", "overview", "runtime", "vote_average", "original_language", "status", "genres", "Ljava/util/ArrayList;", "Lcom/phisher98/StremioX$Genres;", "Lkotlin/collections/ArrayList;", "keywords", "Lcom/phisher98/StremioX$KeywordResults;", "last_episode_to_air", "Lcom/phisher98/StremioX$LastEpisodeToAir;", "seasons", "Lcom/phisher98/StremioX$Seasons;", "videos", "Lcom/phisher98/StremioX$ResultsTrailer;", "external_ids", "Lcom/phisher98/StremioX$ExternalIds;", "credits", "Lcom/phisher98/StremioX$Credits;", "recommendations", "Lcom/phisher98/StremioX$ResultsRecommendations;", "alternative_titles", "Lcom/phisher98/StremioX$ResultsAltTitles;", "production_countries", "Lcom/phisher98/StremioX$ProductionCountries;", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Lcom/phisher98/StremioX$KeywordResults;Lcom/phisher98/StremioX$LastEpisodeToAir;Ljava/util/ArrayList;Lcom/phisher98/StremioX$ResultsTrailer;Lcom/phisher98/StremioX$ExternalIds;Lcom/phisher98/StremioX$Credits;Lcom/phisher98/StremioX$ResultsRecommendations;Lcom/phisher98/StremioX$ResultsAltTitles;Ljava/util/ArrayList;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "getImdbId", "()Ljava/lang/String;", "imdb_id", "getTitle", "getName", "getOriginalTitle", "original_title", "getOriginalName", "original_name", "getPosterPath", "poster_path", "getBackdropPath", "backdrop_path", "getReleaseDate", "release_date", "getFirstAirDate", "first_air_date", "getOverview", "getRuntime", "getVote_average", "()Ljava/lang/Object;", "getOriginal_language", "getStatus", "getGenres", "()Ljava/util/ArrayList;", "getKeywords", "()Lcom/phisher98/StremioX$KeywordResults;", "getLast_episode_to_air", "()Lcom/phisher98/StremioX$LastEpisodeToAir;", "getSeasons", "getVideos", "()Lcom/phisher98/StremioX$ResultsTrailer;", "getExternal_ids", "()Lcom/phisher98/StremioX$ExternalIds;", "getCredits", "()Lcom/phisher98/StremioX$Credits;", "getRecommendations", "()Lcom/phisher98/StremioX$ResultsRecommendations;", "getAlternative_titles", "()Lcom/phisher98/StremioX$ResultsAltTitles;", "getProduction_countries", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Lcom/phisher98/StremioX$KeywordResults;Lcom/phisher98/StremioX$LastEpisodeToAir;Ljava/util/ArrayList;Lcom/phisher98/StremioX$ResultsTrailer;Lcom/phisher98/StremioX$ExternalIds;Lcom/phisher98/StremioX$Credits;Lcom/phisher98/StremioX$ResultsRecommendations;Lcom/phisher98/StremioX$ResultsAltTitles;Ljava/util/ArrayList;)Lcom/phisher98/StremioX$MediaDetail;", "equals", "", "other", "hashCode", "toString", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class MediaDetail {

        @Nullable
        private final ResultsAltTitles alternative_titles;

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
        private final ArrayList<ProductionCountries> production_countries;

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
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 33554431, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MediaDetail copy$default(MediaDetail mediaDetail, Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Integer num2, Object obj, String str11, String str12, ArrayList arrayList, KeywordResults keywordResults, LastEpisodeToAir lastEpisodeToAir, ArrayList arrayList2, ResultsTrailer resultsTrailer, ExternalIds externalIds, Credits credits, ResultsRecommendations resultsRecommendations, ResultsAltTitles resultsAltTitles, ArrayList arrayList3, int i, Object obj2) {
            ArrayList arrayList4;
            ResultsAltTitles resultsAltTitles2;
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
            ArrayList arrayList5 = (i & 32768) != 0 ? mediaDetail.genres : arrayList;
            KeywordResults keywordResults2 = (i & 65536) != 0 ? mediaDetail.keywords : keywordResults;
            LastEpisodeToAir lastEpisodeToAir2 = (i & 131072) != 0 ? mediaDetail.last_episode_to_air : lastEpisodeToAir;
            ArrayList arrayList6 = (i & 262144) != 0 ? mediaDetail.seasons : arrayList2;
            ResultsTrailer resultsTrailer2 = (i & 524288) != 0 ? mediaDetail.videos : resultsTrailer;
            ExternalIds externalIds2 = (i & 1048576) != 0 ? mediaDetail.external_ids : externalIds;
            Credits credits2 = (i & 2097152) != 0 ? mediaDetail.credits : credits;
            ResultsRecommendations resultsRecommendations2 = (i & 4194304) != 0 ? mediaDetail.recommendations : resultsRecommendations;
            ResultsAltTitles resultsAltTitles3 = (i & 8388608) != 0 ? mediaDetail.alternative_titles : resultsAltTitles;
            if ((i & 16777216) != 0) {
                resultsAltTitles2 = resultsAltTitles3;
                arrayList4 = mediaDetail.production_countries;
            } else {
                arrayList4 = arrayList3;
                resultsAltTitles2 = resultsAltTitles3;
            }
            return mediaDetail.copy(num5, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, num4, obj3, str23, str24, arrayList5, keywordResults2, lastEpisodeToAir2, arrayList6, resultsTrailer2, externalIds2, credits2, resultsRecommendations2, resultsAltTitles2, arrayList4);
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
        /* JADX INFO: renamed from: component24, reason: from getter */
        public final ResultsAltTitles getAlternative_titles() {
            return this.alternative_titles;
        }

        @Nullable
        public final ArrayList<ProductionCountries> component25() {
            return this.production_countries;
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
        public final MediaDetail copy(@Nullable Integer id, @Nullable String imdbId, @Nullable String title, @Nullable String name, @Nullable String originalTitle, @Nullable String originalName, @Nullable String posterPath, @Nullable String backdropPath, @Nullable String releaseDate, @Nullable String firstAirDate, @Nullable String overview, @Nullable Integer runtime, @Nullable Object vote_average, @Nullable String original_language, @Nullable String status, @Nullable ArrayList<Genres> genres, @Nullable KeywordResults keywords, @Nullable LastEpisodeToAir last_episode_to_air, @Nullable ArrayList<Seasons> seasons, @Nullable ResultsTrailer videos, @Nullable ExternalIds external_ids, @Nullable Credits credits, @Nullable ResultsRecommendations recommendations, @Nullable ResultsAltTitles alternative_titles, @Nullable ArrayList<ProductionCountries> production_countries) {
            return new MediaDetail(id, imdbId, title, name, originalTitle, originalName, posterPath, backdropPath, releaseDate, firstAirDate, overview, runtime, vote_average, original_language, status, genres, keywords, last_episode_to_air, seasons, videos, external_ids, credits, recommendations, alternative_titles, production_countries);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MediaDetail)) {
                return false;
            }
            MediaDetail mediaDetail = (MediaDetail) other;
            return Intrinsics.areEqual(this.id, mediaDetail.id) && Intrinsics.areEqual(this.imdbId, mediaDetail.imdbId) && Intrinsics.areEqual(this.title, mediaDetail.title) && Intrinsics.areEqual(this.name, mediaDetail.name) && Intrinsics.areEqual(this.originalTitle, mediaDetail.originalTitle) && Intrinsics.areEqual(this.originalName, mediaDetail.originalName) && Intrinsics.areEqual(this.posterPath, mediaDetail.posterPath) && Intrinsics.areEqual(this.backdropPath, mediaDetail.backdropPath) && Intrinsics.areEqual(this.releaseDate, mediaDetail.releaseDate) && Intrinsics.areEqual(this.firstAirDate, mediaDetail.firstAirDate) && Intrinsics.areEqual(this.overview, mediaDetail.overview) && Intrinsics.areEqual(this.runtime, mediaDetail.runtime) && Intrinsics.areEqual(this.vote_average, mediaDetail.vote_average) && Intrinsics.areEqual(this.original_language, mediaDetail.original_language) && Intrinsics.areEqual(this.status, mediaDetail.status) && Intrinsics.areEqual(this.genres, mediaDetail.genres) && Intrinsics.areEqual(this.keywords, mediaDetail.keywords) && Intrinsics.areEqual(this.last_episode_to_air, mediaDetail.last_episode_to_air) && Intrinsics.areEqual(this.seasons, mediaDetail.seasons) && Intrinsics.areEqual(this.videos, mediaDetail.videos) && Intrinsics.areEqual(this.external_ids, mediaDetail.external_ids) && Intrinsics.areEqual(this.credits, mediaDetail.credits) && Intrinsics.areEqual(this.recommendations, mediaDetail.recommendations) && Intrinsics.areEqual(this.alternative_titles, mediaDetail.alternative_titles) && Intrinsics.areEqual(this.production_countries, mediaDetail.production_countries);
        }

        public int hashCode() {
            return ((((((((((((((((((((((((((((((((((((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.imdbId == null ? 0 : this.imdbId.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.originalTitle == null ? 0 : this.originalTitle.hashCode())) * 31) + (this.originalName == null ? 0 : this.originalName.hashCode())) * 31) + (this.posterPath == null ? 0 : this.posterPath.hashCode())) * 31) + (this.backdropPath == null ? 0 : this.backdropPath.hashCode())) * 31) + (this.releaseDate == null ? 0 : this.releaseDate.hashCode())) * 31) + (this.firstAirDate == null ? 0 : this.firstAirDate.hashCode())) * 31) + (this.overview == null ? 0 : this.overview.hashCode())) * 31) + (this.runtime == null ? 0 : this.runtime.hashCode())) * 31) + (this.vote_average == null ? 0 : this.vote_average.hashCode())) * 31) + (this.original_language == null ? 0 : this.original_language.hashCode())) * 31) + (this.status == null ? 0 : this.status.hashCode())) * 31) + (this.genres == null ? 0 : this.genres.hashCode())) * 31) + (this.keywords == null ? 0 : this.keywords.hashCode())) * 31) + (this.last_episode_to_air == null ? 0 : this.last_episode_to_air.hashCode())) * 31) + (this.seasons == null ? 0 : this.seasons.hashCode())) * 31) + (this.videos == null ? 0 : this.videos.hashCode())) * 31) + (this.external_ids == null ? 0 : this.external_ids.hashCode())) * 31) + (this.credits == null ? 0 : this.credits.hashCode())) * 31) + (this.recommendations == null ? 0 : this.recommendations.hashCode())) * 31) + (this.alternative_titles == null ? 0 : this.alternative_titles.hashCode())) * 31) + (this.production_countries != null ? this.production_countries.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("MediaDetail(id=").append(this.id).append(", imdbId=").append(this.imdbId).append(", title=").append(this.title).append(", name=").append(this.name).append(", originalTitle=").append(this.originalTitle).append(", originalName=").append(this.originalName).append(", posterPath=").append(this.posterPath).append(", backdropPath=").append(this.backdropPath).append(", releaseDate=").append(this.releaseDate).append(", firstAirDate=").append(this.firstAirDate).append(", overview=").append(this.overview).append(", runtime=");
            sb.append(this.runtime).append(", vote_average=").append(this.vote_average).append(", original_language=").append(this.original_language).append(", status=").append(this.status).append(", genres=").append(this.genres).append(", keywords=").append(this.keywords).append(", last_episode_to_air=").append(this.last_episode_to_air).append(", seasons=").append(this.seasons).append(", videos=").append(this.videos).append(", external_ids=").append(this.external_ids).append(", credits=").append(this.credits).append(", recommendations=").append(this.recommendations);
            sb.append(", alternative_titles=").append(this.alternative_titles).append(", production_countries=").append(this.production_countries).append(')');
            return sb.toString();
        }

        public MediaDetail(@Nullable Integer id, @Nullable String imdbId, @Nullable String title, @Nullable String name, @Nullable String originalTitle, @Nullable String originalName, @Nullable String posterPath, @Nullable String backdropPath, @Nullable String releaseDate, @Nullable String firstAirDate, @Nullable String overview, @Nullable Integer runtime, @Nullable Object vote_average, @Nullable String original_language, @Nullable String status, @Nullable ArrayList<Genres> arrayList, @Nullable KeywordResults keywords, @Nullable LastEpisodeToAir last_episode_to_air, @Nullable ArrayList<Seasons> arrayList2, @Nullable ResultsTrailer videos, @Nullable ExternalIds external_ids, @Nullable Credits credits, @Nullable ResultsRecommendations recommendations, @Nullable ResultsAltTitles alternative_titles, @Nullable ArrayList<ProductionCountries> arrayList3) {
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
            this.alternative_titles = alternative_titles;
            this.production_countries = arrayList3;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ MediaDetail(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Integer num2, Object obj, String str11, String str12, ArrayList arrayList, KeywordResults keywordResults, LastEpisodeToAir lastEpisodeToAir, ArrayList arrayList2, ResultsTrailer resultsTrailer, ExternalIds externalIds, Credits credits, ResultsRecommendations resultsRecommendations, ResultsAltTitles resultsAltTitles, ArrayList arrayList3, int i, DefaultConstructorMarker defaultConstructorMarker) {
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
            this(num3, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, num4, obj2, str23, str24, (i & 32768) != 0 ? new ArrayList() : arrayList, (i & 65536) != 0 ? null : keywordResults, (i & 131072) != 0 ? null : lastEpisodeToAir, (i & 262144) != 0 ? new ArrayList() : arrayList2, (i & 524288) != 0 ? null : resultsTrailer, (i & 1048576) != 0 ? null : externalIds, (i & 2097152) != 0 ? null : credits, (i & 4194304) != 0 ? null : resultsRecommendations, (i & 8388608) != 0 ? null : resultsAltTitles, (i & 16777216) != 0 ? new ArrayList() : arrayList3);
        }

        @JsonProperty("id")
        @Nullable
        public final Integer getId() {
            return this.id;
        }

        @JsonProperty("imdb_id")
        @Nullable
        public final String getImdbId() {
            return this.imdbId;
        }

        @JsonProperty("title")
        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @JsonProperty("name")
        @Nullable
        public final String getName() {
            return this.name;
        }

        @JsonProperty("original_title")
        @Nullable
        public final String getOriginalTitle() {
            return this.originalTitle;
        }

        @JsonProperty("original_name")
        @Nullable
        public final String getOriginalName() {
            return this.originalName;
        }

        @JsonProperty("poster_path")
        @Nullable
        public final String getPosterPath() {
            return this.posterPath;
        }

        @JsonProperty("backdrop_path")
        @Nullable
        public final String getBackdropPath() {
            return this.backdropPath;
        }

        @JsonProperty("release_date")
        @Nullable
        public final String getReleaseDate() {
            return this.releaseDate;
        }

        @JsonProperty("first_air_date")
        @Nullable
        public final String getFirstAirDate() {
            return this.firstAirDate;
        }

        @JsonProperty("overview")
        @Nullable
        public final String getOverview() {
            return this.overview;
        }

        @JsonProperty("runtime")
        @Nullable
        public final Integer getRuntime() {
            return this.runtime;
        }

        @JsonProperty("vote_average")
        @Nullable
        public final Object getVote_average() {
            return this.vote_average;
        }

        @JsonProperty("original_language")
        @Nullable
        public final String getOriginal_language() {
            return this.original_language;
        }

        @JsonProperty("status")
        @Nullable
        public final String getStatus() {
            return this.status;
        }

        @JsonProperty("genres")
        @Nullable
        public final ArrayList<Genres> getGenres() {
            return this.genres;
        }

        @JsonProperty("keywords")
        @Nullable
        public final KeywordResults getKeywords() {
            return this.keywords;
        }

        @JsonProperty("last_episode_to_air")
        @Nullable
        public final LastEpisodeToAir getLast_episode_to_air() {
            return this.last_episode_to_air;
        }

        @JsonProperty("seasons")
        @Nullable
        public final ArrayList<Seasons> getSeasons() {
            return this.seasons;
        }

        @JsonProperty("videos")
        @Nullable
        public final ResultsTrailer getVideos() {
            return this.videos;
        }

        @JsonProperty("external_ids")
        @Nullable
        public final ExternalIds getExternal_ids() {
            return this.external_ids;
        }

        @JsonProperty("credits")
        @Nullable
        public final Credits getCredits() {
            return this.credits;
        }

        @JsonProperty("recommendations")
        @Nullable
        public final ResultsRecommendations getRecommendations() {
            return this.recommendations;
        }

        @JsonProperty("alternative_titles")
        @Nullable
        public final ResultsAltTitles getAlternative_titles() {
            return this.alternative_titles;
        }

        @JsonProperty("production_countries")
        @Nullable
        public final ArrayList<ProductionCountries> getProduction_countries() {
            return this.production_countries;
        }
    }

    /* JADX INFO: compiled from: StremioX.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J'\u0010\r\u001a\u00020\u00002\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R5\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00058\u0007z\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0002¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/phisher98/StremioX$ResultsAltTitles;", "", "results", "Ljava/util/ArrayList;", "Lcom/phisher98/StremioX$AltTitles;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/util/ArrayList;)V", "getResults", "()Ljava/util/ArrayList;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class ResultsAltTitles {

        @Nullable
        private final ArrayList<AltTitles> results;

        /* JADX WARN: Illegal instructions before constructor call */
        public ResultsAltTitles() {
            ArrayList arrayList = null;
            this(arrayList, 1, arrayList);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ResultsAltTitles copy$default(ResultsAltTitles resultsAltTitles, ArrayList arrayList, int i, Object obj) {
            if ((i & 1) != 0) {
                arrayList = resultsAltTitles.results;
            }
            return resultsAltTitles.copy(arrayList);
        }

        @Nullable
        public final ArrayList<AltTitles> component1() {
            return this.results;
        }

        @NotNull
        public final ResultsAltTitles copy(@Nullable ArrayList<AltTitles> results) {
            return new ResultsAltTitles(results);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ResultsAltTitles) && Intrinsics.areEqual(this.results, ((ResultsAltTitles) other).results);
        }

        public int hashCode() {
            if (this.results == null) {
                return 0;
            }
            return this.results.hashCode();
        }

        @NotNull
        public String toString() {
            return "ResultsAltTitles(results=" + this.results + ')';
        }

        public ResultsAltTitles(@Nullable ArrayList<AltTitles> arrayList) {
            this.results = arrayList;
        }

        public /* synthetic */ ResultsAltTitles(ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new ArrayList() : arrayList);
        }

        @JsonProperty("results")
        @Nullable
        public final ArrayList<AltTitles> getResults() {
            return this.results;
        }
    }

    /* JADX INFO: compiled from: StremioX.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004R#\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0007z\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0002¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR#\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0007z\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR#\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0007z\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/phisher98/StremioX$AltTitles;", "", "iso_3166_1", "", "title", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getIso_3166_1", "()Ljava/lang/String;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "getTitle", "getType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class AltTitles {

        @Nullable
        private final String iso_3166_1;

        @Nullable
        private final String title;

        @Nullable
        private final String type;

        public AltTitles() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ AltTitles copy$default(AltTitles altTitles, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = altTitles.iso_3166_1;
            }
            if ((i & 2) != 0) {
                str2 = altTitles.title;
            }
            if ((i & 4) != 0) {
                str3 = altTitles.type;
            }
            return altTitles.copy(str, str2, str3);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getIso_3166_1() {
            return this.iso_3166_1;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @NotNull
        public final AltTitles copy(@Nullable String iso_3166_1, @Nullable String title, @Nullable String type) {
            return new AltTitles(iso_3166_1, title, type);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AltTitles)) {
                return false;
            }
            AltTitles altTitles = (AltTitles) other;
            return Intrinsics.areEqual(this.iso_3166_1, altTitles.iso_3166_1) && Intrinsics.areEqual(this.title, altTitles.title) && Intrinsics.areEqual(this.type, altTitles.type);
        }

        public int hashCode() {
            return ((((this.iso_3166_1 == null ? 0 : this.iso_3166_1.hashCode()) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.type != null ? this.type.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "AltTitles(iso_3166_1=" + this.iso_3166_1 + ", title=" + this.title + ", type=" + this.type + ')';
        }

        public AltTitles(@Nullable String iso_3166_1, @Nullable String title, @Nullable String type) {
            this.iso_3166_1 = iso_3166_1;
            this.title = title;
            this.type = type;
        }

        public /* synthetic */ AltTitles(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
        }

        @JsonProperty("iso_3166_1")
        @Nullable
        public final String getIso_3166_1() {
            return this.iso_3166_1;
        }

        @JsonProperty("title")
        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @JsonProperty("type")
        @Nullable
        public final String getType() {
            return this.type;
        }
    }

    /* JADX INFO: compiled from: StremioX.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0003HÖ\u0081\u0004R#\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0007z\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/phisher98/StremioX$ProductionCountries;", "", "name", "", "<init>", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class ProductionCountries {

        @Nullable
        private final String name;

        /* JADX WARN: Illegal instructions before constructor call */
        public ProductionCountries() {
            String str = null;
            this(str, 1, str);
        }

        public static /* synthetic */ ProductionCountries copy$default(ProductionCountries productionCountries, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = productionCountries.name;
            }
            return productionCountries.copy(str);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @NotNull
        public final ProductionCountries copy(@Nullable String name) {
            return new ProductionCountries(name);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ProductionCountries) && Intrinsics.areEqual(this.name, ((ProductionCountries) other).name);
        }

        public int hashCode() {
            if (this.name == null) {
                return 0;
            }
            return this.name.hashCode();
        }

        @NotNull
        public String toString() {
            return "ProductionCountries(name=" + this.name + ')';
        }

        public ProductionCountries(@Nullable String name) {
            this.name = name;
        }

        public /* synthetic */ ProductionCountries(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str);
        }

        @JsonProperty("name")
        @Nullable
        public final String getName() {
            return this.name;
        }
    }

    /* JADX INFO: compiled from: StremioX.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0011B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/phisher98/StremioX$CinemetaRes;", "", "meta", "Lcom/phisher98/StremioX$CinemetaRes$Meta;", "<init>", "(Lcom/phisher98/StremioX$CinemetaRes$Meta;)V", "getMeta", "()Lcom/phisher98/StremioX$CinemetaRes$Meta;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Meta", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class CinemetaRes {

        @Nullable
        private final Meta meta;

        /* JADX WARN: Illegal instructions before constructor call */
        public CinemetaRes() {
            Meta meta = null;
            this(meta, 1, meta);
        }

        public static /* synthetic */ CinemetaRes copy$default(CinemetaRes cinemetaRes, Meta meta, int i, Object obj) {
            if ((i & 1) != 0) {
                meta = cinemetaRes.meta;
            }
            return cinemetaRes.copy(meta);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Meta getMeta() {
            return this.meta;
        }

        @NotNull
        public final CinemetaRes copy(@Nullable Meta meta) {
            return new CinemetaRes(meta);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof CinemetaRes) && Intrinsics.areEqual(this.meta, ((CinemetaRes) other).meta);
        }

        public int hashCode() {
            if (this.meta == null) {
                return 0;
            }
            return this.meta.hashCode();
        }

        @NotNull
        public String toString() {
            return "CinemetaRes(meta=" + this.meta + ')';
        }

        public CinemetaRes(@Nullable Meta meta) {
            this.meta = meta;
        }

        public /* synthetic */ CinemetaRes(Meta meta, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : meta);
        }

        @Nullable
        public final Meta getMeta() {
            return this.meta;
        }

        /* JADX INFO: compiled from: StremioX.kt */
        @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b=\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001:\u0007jklmnopB\u0087\u0003\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u0003:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0016\u0012\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u0016\u0012\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u0016\u0012\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u0016\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%\u0012\u0018\b\u0003\u0010&\u001a\u0004\u0018\u00010':\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b((¢\u0006\u0004\b)\u0010*J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010X\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0016HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010]\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0016HÆ\u0003J\u0011\u0010^\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u0016HÆ\u0003J\u0011\u0010_\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u0016HÆ\u0003J\u0011\u0010`\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u0016HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010%HÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010'HÆ\u0003J\u0089\u0003\u0010c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\u0018\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u0003:\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u00162\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u00162\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u00162\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u00162\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\u0018\b\u0003\u0010&\u001a\u0004\u0018\u00010':\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b((HÆ\u0001J\u0014\u0010d\u001a\u00020e2\b\u0010f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010g\u001a\u00020hHÖ\u0081\u0004J\n\u0010i\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010,R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010,R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010,R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010,R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010,R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010,R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010,R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010,R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010,R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u0010,R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u0010,R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010,R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u0010,R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010,R\u0019\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b=\u0010,R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u0010,R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u0010,R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b@\u0010,R\u0019\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\bA\u0010<R\u0019\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\bB\u0010<R\u0019\u0010 \u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\bC\u0010<R\u0019\u0010\"\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\bD\u0010<R\u0013\u0010$\u001a\u0004\u0018\u00010%¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u0013\u0010&\u001a\u0004\u0018\u00010'¢\u0006\b\n\u0000\u001a\u0004\bG\u0010H¨\u0006q"}, d2 = {"Lcom/phisher98/StremioX$CinemetaRes$Meta;", "", "id", "", "type", "name", "imdbId", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "imdb_id", "slug", "director", "writer", "description", "year", "releaseInfo", "released", "runtime", "status", "country", "imdbRating", "genres", "", "poster", "rawPosterUrl", "_rawPosterUrl", "background", "logo", "videos", "Lcom/phisher98/StremioX$CinemetaRes$Meta$Video;", "trailers", "Lcom/phisher98/StremioX$CinemetaRes$Meta$Trailer;", "trailerStreams", "Lcom/phisher98/StremioX$CinemetaRes$Meta$TrailerStream;", "links", "Lcom/phisher98/StremioX$CinemetaRes$Meta$Link;", "behaviorHints", "Lcom/phisher98/StremioX$CinemetaRes$Meta$BehaviorHints;", "appExtras", "Lcom/phisher98/StremioX$CinemetaRes$Meta$AppExtras;", "app_extras", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/phisher98/StremioX$CinemetaRes$Meta$BehaviorHints;Lcom/phisher98/StremioX$CinemetaRes$Meta$AppExtras;)V", "getId", "()Ljava/lang/String;", "getType", "getName", "getImdbId", "getSlug", "getDirector", "getWriter", "getDescription", "getYear", "getReleaseInfo", "getReleased", "getRuntime", "getStatus", "getCountry", "getImdbRating", "getGenres", "()Ljava/util/List;", "getPoster", "getRawPosterUrl", "getBackground", "getLogo", "getVideos", "getTrailers", "getTrailerStreams", "getLinks", "getBehaviorHints", "()Lcom/phisher98/StremioX$CinemetaRes$Meta$BehaviorHints;", "getAppExtras", "()Lcom/phisher98/StremioX$CinemetaRes$Meta$AppExtras;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "copy", "equals", "", "other", "hashCode", "", "toString", "BehaviorHints", "Link", "Trailer", "TrailerStream", "Video", "AppExtras", "Cast", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public static final /* data */ class Meta {

            @Nullable
            private final AppExtras appExtras;

            @Nullable
            private final String background;

            @Nullable
            private final BehaviorHints behaviorHints;

            @Nullable
            private final String country;

            @Nullable
            private final String description;

            @Nullable
            private final String director;

            @Nullable
            private final List<String> genres;

            @Nullable
            private final String id;

            @Nullable
            private final String imdbId;

            @Nullable
            private final String imdbRating;

            @Nullable
            private final List<Link> links;

            @Nullable
            private final String logo;

            @Nullable
            private final String name;

            @Nullable
            private final String poster;

            @Nullable
            private final String rawPosterUrl;

            @Nullable
            private final String releaseInfo;

            @Nullable
            private final String released;

            @Nullable
            private final String runtime;

            @Nullable
            private final String slug;

            @Nullable
            private final String status;

            @Nullable
            private final List<TrailerStream> trailerStreams;

            @Nullable
            private final List<Trailer> trailers;

            @Nullable
            private final String type;

            @Nullable
            private final List<Video> videos;

            @Nullable
            private final String writer;

            @Nullable
            private final String year;

            public Meta() {
                this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 67108863, null);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Meta copy$default(Meta meta, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, List list, String str16, String str17, String str18, String str19, List list2, List list3, List list4, List list5, BehaviorHints behaviorHints, AppExtras appExtras, int i, Object obj) {
                AppExtras appExtras2;
                BehaviorHints behaviorHints2;
                String str20 = (i & 1) != 0 ? meta.id : str;
                String str21 = (i & 2) != 0 ? meta.type : str2;
                String str22 = (i & 4) != 0 ? meta.name : str3;
                String str23 = (i & 8) != 0 ? meta.imdbId : str4;
                String str24 = (i & 16) != 0 ? meta.slug : str5;
                String str25 = (i & 32) != 0 ? meta.director : str6;
                String str26 = (i & 64) != 0 ? meta.writer : str7;
                String str27 = (i & 128) != 0 ? meta.description : str8;
                String str28 = (i & 256) != 0 ? meta.year : str9;
                String str29 = (i & 512) != 0 ? meta.releaseInfo : str10;
                String str30 = (i & 1024) != 0 ? meta.released : str11;
                String str31 = (i & 2048) != 0 ? meta.runtime : str12;
                String str32 = (i & 4096) != 0 ? meta.status : str13;
                String str33 = (i & 8192) != 0 ? meta.country : str14;
                String str34 = str20;
                String str35 = (i & 16384) != 0 ? meta.imdbRating : str15;
                List list6 = (i & 32768) != 0 ? meta.genres : list;
                String str36 = (i & 65536) != 0 ? meta.poster : str16;
                String str37 = (i & 131072) != 0 ? meta.rawPosterUrl : str17;
                String str38 = (i & 262144) != 0 ? meta.background : str18;
                String str39 = (i & 524288) != 0 ? meta.logo : str19;
                List list7 = (i & 1048576) != 0 ? meta.videos : list2;
                List list8 = (i & 2097152) != 0 ? meta.trailers : list3;
                List list9 = (i & 4194304) != 0 ? meta.trailerStreams : list4;
                List list10 = (i & 8388608) != 0 ? meta.links : list5;
                BehaviorHints behaviorHints3 = (i & 16777216) != 0 ? meta.behaviorHints : behaviorHints;
                if ((i & 33554432) != 0) {
                    behaviorHints2 = behaviorHints3;
                    appExtras2 = meta.appExtras;
                } else {
                    appExtras2 = appExtras;
                    behaviorHints2 = behaviorHints3;
                }
                return meta.copy(str34, str21, str22, str23, str24, str25, str26, str27, str28, str29, str30, str31, str32, str33, str35, list6, str36, str37, str38, str39, list7, list8, list9, list10, behaviorHints2, appExtras2);
            }

            @Nullable
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getId() {
                return this.id;
            }

            @Nullable
            /* JADX INFO: renamed from: component10, reason: from getter */
            public final String getReleaseInfo() {
                return this.releaseInfo;
            }

            @Nullable
            /* JADX INFO: renamed from: component11, reason: from getter */
            public final String getReleased() {
                return this.released;
            }

            @Nullable
            /* JADX INFO: renamed from: component12, reason: from getter */
            public final String getRuntime() {
                return this.runtime;
            }

            @Nullable
            /* JADX INFO: renamed from: component13, reason: from getter */
            public final String getStatus() {
                return this.status;
            }

            @Nullable
            /* JADX INFO: renamed from: component14, reason: from getter */
            public final String getCountry() {
                return this.country;
            }

            @Nullable
            /* JADX INFO: renamed from: component15, reason: from getter */
            public final String getImdbRating() {
                return this.imdbRating;
            }

            @Nullable
            public final List<String> component16() {
                return this.genres;
            }

            @Nullable
            /* JADX INFO: renamed from: component17, reason: from getter */
            public final String getPoster() {
                return this.poster;
            }

            @Nullable
            /* JADX INFO: renamed from: component18, reason: from getter */
            public final String getRawPosterUrl() {
                return this.rawPosterUrl;
            }

            @Nullable
            /* JADX INFO: renamed from: component19, reason: from getter */
            public final String getBackground() {
                return this.background;
            }

            @Nullable
            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getType() {
                return this.type;
            }

            @Nullable
            /* JADX INFO: renamed from: component20, reason: from getter */
            public final String getLogo() {
                return this.logo;
            }

            @Nullable
            public final List<Video> component21() {
                return this.videos;
            }

            @Nullable
            public final List<Trailer> component22() {
                return this.trailers;
            }

            @Nullable
            public final List<TrailerStream> component23() {
                return this.trailerStreams;
            }

            @Nullable
            public final List<Link> component24() {
                return this.links;
            }

            @Nullable
            /* JADX INFO: renamed from: component25, reason: from getter */
            public final BehaviorHints getBehaviorHints() {
                return this.behaviorHints;
            }

            @Nullable
            /* JADX INFO: renamed from: component26, reason: from getter */
            public final AppExtras getAppExtras() {
                return this.appExtras;
            }

            @Nullable
            /* JADX INFO: renamed from: component3, reason: from getter */
            public final String getName() {
                return this.name;
            }

            @Nullable
            /* JADX INFO: renamed from: component4, reason: from getter */
            public final String getImdbId() {
                return this.imdbId;
            }

            @Nullable
            /* JADX INFO: renamed from: component5, reason: from getter */
            public final String getSlug() {
                return this.slug;
            }

            @Nullable
            /* JADX INFO: renamed from: component6, reason: from getter */
            public final String getDirector() {
                return this.director;
            }

            @Nullable
            /* JADX INFO: renamed from: component7, reason: from getter */
            public final String getWriter() {
                return this.writer;
            }

            @Nullable
            /* JADX INFO: renamed from: component8, reason: from getter */
            public final String getDescription() {
                return this.description;
            }

            @Nullable
            /* JADX INFO: renamed from: component9, reason: from getter */
            public final String getYear() {
                return this.year;
            }

            @NotNull
            public final Meta copy(@Nullable String id, @Nullable String type, @Nullable String name, @JsonProperty("imdb_id") @Nullable String imdbId, @Nullable String slug, @Nullable String director, @Nullable String writer, @Nullable String description, @Nullable String year, @Nullable String releaseInfo, @Nullable String released, @Nullable String runtime, @Nullable String status, @Nullable String country, @Nullable String imdbRating, @Nullable List<String> genres, @Nullable String poster, @JsonProperty("_rawPosterUrl") @Nullable String rawPosterUrl, @Nullable String background, @Nullable String logo, @Nullable List<Video> videos, @Nullable List<Trailer> trailers, @Nullable List<TrailerStream> trailerStreams, @Nullable List<Link> links, @Nullable BehaviorHints behaviorHints, @JsonProperty("app_extras") @Nullable AppExtras appExtras) {
                return new Meta(id, type, name, imdbId, slug, director, writer, description, year, releaseInfo, released, runtime, status, country, imdbRating, genres, poster, rawPosterUrl, background, logo, videos, trailers, trailerStreams, links, behaviorHints, appExtras);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Meta)) {
                    return false;
                }
                Meta meta = (Meta) other;
                return Intrinsics.areEqual(this.id, meta.id) && Intrinsics.areEqual(this.type, meta.type) && Intrinsics.areEqual(this.name, meta.name) && Intrinsics.areEqual(this.imdbId, meta.imdbId) && Intrinsics.areEqual(this.slug, meta.slug) && Intrinsics.areEqual(this.director, meta.director) && Intrinsics.areEqual(this.writer, meta.writer) && Intrinsics.areEqual(this.description, meta.description) && Intrinsics.areEqual(this.year, meta.year) && Intrinsics.areEqual(this.releaseInfo, meta.releaseInfo) && Intrinsics.areEqual(this.released, meta.released) && Intrinsics.areEqual(this.runtime, meta.runtime) && Intrinsics.areEqual(this.status, meta.status) && Intrinsics.areEqual(this.country, meta.country) && Intrinsics.areEqual(this.imdbRating, meta.imdbRating) && Intrinsics.areEqual(this.genres, meta.genres) && Intrinsics.areEqual(this.poster, meta.poster) && Intrinsics.areEqual(this.rawPosterUrl, meta.rawPosterUrl) && Intrinsics.areEqual(this.background, meta.background) && Intrinsics.areEqual(this.logo, meta.logo) && Intrinsics.areEqual(this.videos, meta.videos) && Intrinsics.areEqual(this.trailers, meta.trailers) && Intrinsics.areEqual(this.trailerStreams, meta.trailerStreams) && Intrinsics.areEqual(this.links, meta.links) && Intrinsics.areEqual(this.behaviorHints, meta.behaviorHints) && Intrinsics.areEqual(this.appExtras, meta.appExtras);
            }

            public int hashCode() {
                return ((((((((((((((((((((((((((((((((((((((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.imdbId == null ? 0 : this.imdbId.hashCode())) * 31) + (this.slug == null ? 0 : this.slug.hashCode())) * 31) + (this.director == null ? 0 : this.director.hashCode())) * 31) + (this.writer == null ? 0 : this.writer.hashCode())) * 31) + (this.description == null ? 0 : this.description.hashCode())) * 31) + (this.year == null ? 0 : this.year.hashCode())) * 31) + (this.releaseInfo == null ? 0 : this.releaseInfo.hashCode())) * 31) + (this.released == null ? 0 : this.released.hashCode())) * 31) + (this.runtime == null ? 0 : this.runtime.hashCode())) * 31) + (this.status == null ? 0 : this.status.hashCode())) * 31) + (this.country == null ? 0 : this.country.hashCode())) * 31) + (this.imdbRating == null ? 0 : this.imdbRating.hashCode())) * 31) + (this.genres == null ? 0 : this.genres.hashCode())) * 31) + (this.poster == null ? 0 : this.poster.hashCode())) * 31) + (this.rawPosterUrl == null ? 0 : this.rawPosterUrl.hashCode())) * 31) + (this.background == null ? 0 : this.background.hashCode())) * 31) + (this.logo == null ? 0 : this.logo.hashCode())) * 31) + (this.videos == null ? 0 : this.videos.hashCode())) * 31) + (this.trailers == null ? 0 : this.trailers.hashCode())) * 31) + (this.trailerStreams == null ? 0 : this.trailerStreams.hashCode())) * 31) + (this.links == null ? 0 : this.links.hashCode())) * 31) + (this.behaviorHints == null ? 0 : this.behaviorHints.hashCode())) * 31) + (this.appExtras != null ? this.appExtras.hashCode() : 0);
            }

            @NotNull
            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("Meta(id=").append(this.id).append(", type=").append(this.type).append(", name=").append(this.name).append(", imdbId=").append(this.imdbId).append(", slug=").append(this.slug).append(", director=").append(this.director).append(", writer=").append(this.writer).append(", description=").append(this.description).append(", year=").append(this.year).append(", releaseInfo=").append(this.releaseInfo).append(", released=").append(this.released).append(", runtime=");
                sb.append(this.runtime).append(", status=").append(this.status).append(", country=").append(this.country).append(", imdbRating=").append(this.imdbRating).append(", genres=").append(this.genres).append(", poster=").append(this.poster).append(", rawPosterUrl=").append(this.rawPosterUrl).append(", background=").append(this.background).append(", logo=").append(this.logo).append(", videos=").append(this.videos).append(", trailers=").append(this.trailers).append(", trailerStreams=").append(this.trailerStreams);
                sb.append(", links=").append(this.links).append(", behaviorHints=").append(this.behaviorHints).append(", appExtras=").append(this.appExtras).append(')');
                return sb.toString();
            }

            public Meta(@Nullable String id, @Nullable String type, @Nullable String name, @JsonProperty("imdb_id") @Nullable String imdbId, @Nullable String slug, @Nullable String director, @Nullable String writer, @Nullable String description, @Nullable String year, @Nullable String releaseInfo, @Nullable String released, @Nullable String runtime, @Nullable String status, @Nullable String country, @Nullable String imdbRating, @Nullable List<String> list, @Nullable String poster, @JsonProperty("_rawPosterUrl") @Nullable String rawPosterUrl, @Nullable String background, @Nullable String logo, @Nullable List<Video> list2, @Nullable List<Trailer> list3, @Nullable List<TrailerStream> list4, @Nullable List<Link> list5, @Nullable BehaviorHints behaviorHints, @JsonProperty("app_extras") @Nullable AppExtras appExtras) {
                this.id = id;
                this.type = type;
                this.name = name;
                this.imdbId = imdbId;
                this.slug = slug;
                this.director = director;
                this.writer = writer;
                this.description = description;
                this.year = year;
                this.releaseInfo = releaseInfo;
                this.released = released;
                this.runtime = runtime;
                this.status = status;
                this.country = country;
                this.imdbRating = imdbRating;
                this.genres = list;
                this.poster = poster;
                this.rawPosterUrl = rawPosterUrl;
                this.background = background;
                this.logo = logo;
                this.videos = list2;
                this.trailers = list3;
                this.trailerStreams = list4;
                this.links = list5;
                this.behaviorHints = behaviorHints;
                this.appExtras = appExtras;
            }

            /* JADX WARN: Illegal instructions before constructor call */
            public /* synthetic */ Meta(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, List list, String str16, String str17, String str18, String str19, List list2, List list3, List list4, List list5, BehaviorHints behaviorHints, AppExtras appExtras, int i, DefaultConstructorMarker defaultConstructorMarker) {
                String str20 = (i & 1) != 0 ? null : str;
                String str21 = (i & 2) != 0 ? null : str2;
                String str22 = (i & 4) != 0 ? null : str3;
                String str23 = (i & 8) != 0 ? null : str4;
                String str24 = (i & 16) != 0 ? null : str5;
                String str25 = (i & 32) != 0 ? null : str6;
                String str26 = (i & 64) != 0 ? null : str7;
                String str27 = (i & 128) != 0 ? null : str8;
                String str28 = (i & 256) != 0 ? null : str9;
                String str29 = (i & 512) != 0 ? null : str10;
                String str30 = (i & 1024) != 0 ? null : str11;
                String str31 = (i & 2048) != 0 ? null : str12;
                String str32 = (i & 4096) != 0 ? null : str13;
                String str33 = (i & 8192) != 0 ? null : str14;
                String str34 = (i & 16384) != 0 ? null : str15;
                this(str20, str21, str22, str23, str24, str25, str26, str27, str28, str29, str30, str31, str32, str33, str34, (i & 32768) != 0 ? null : list, (i & 65536) != 0 ? null : str16, (i & 131072) != 0 ? null : str17, (i & 262144) != 0 ? null : str18, (i & 524288) != 0 ? null : str19, (i & 1048576) != 0 ? null : list2, (i & 2097152) != 0 ? null : list3, (i & 4194304) != 0 ? null : list4, (i & 8388608) != 0 ? null : list5, (i & 16777216) != 0 ? null : behaviorHints, (i & 33554432) != 0 ? null : appExtras);
            }

            @Nullable
            public final String getId() {
                return this.id;
            }

            @Nullable
            public final String getType() {
                return this.type;
            }

            @Nullable
            public final String getName() {
                return this.name;
            }

            @Nullable
            public final String getImdbId() {
                return this.imdbId;
            }

            @Nullable
            public final String getSlug() {
                return this.slug;
            }

            @Nullable
            public final String getDirector() {
                return this.director;
            }

            @Nullable
            public final String getWriter() {
                return this.writer;
            }

            @Nullable
            public final String getDescription() {
                return this.description;
            }

            @Nullable
            public final String getYear() {
                return this.year;
            }

            @Nullable
            public final String getReleaseInfo() {
                return this.releaseInfo;
            }

            @Nullable
            public final String getReleased() {
                return this.released;
            }

            @Nullable
            public final String getRuntime() {
                return this.runtime;
            }

            @Nullable
            public final String getStatus() {
                return this.status;
            }

            @Nullable
            public final String getCountry() {
                return this.country;
            }

            @Nullable
            public final String getImdbRating() {
                return this.imdbRating;
            }

            @Nullable
            public final List<String> getGenres() {
                return this.genres;
            }

            @Nullable
            public final String getPoster() {
                return this.poster;
            }

            @Nullable
            public final String getRawPosterUrl() {
                return this.rawPosterUrl;
            }

            @Nullable
            public final String getBackground() {
                return this.background;
            }

            @Nullable
            public final String getLogo() {
                return this.logo;
            }

            @Nullable
            public final List<Video> getVideos() {
                return this.videos;
            }

            @Nullable
            public final List<Trailer> getTrailers() {
                return this.trailers;
            }

            @Nullable
            public final List<TrailerStream> getTrailerStreams() {
                return this.trailerStreams;
            }

            @Nullable
            public final List<Link> getLinks() {
                return this.links;
            }

            @Nullable
            public final BehaviorHints getBehaviorHints() {
                return this.behaviorHints;
            }

            @Nullable
            public final AppExtras getAppExtras() {
                return this.appExtras;
            }

            /* JADX INFO: compiled from: StremioX.kt */
            @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\nJ&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0014\u0010\u0010\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/phisher98/StremioX$CinemetaRes$Meta$BehaviorHints;", "", "defaultVideoId", "hasScheduledVideos", "", "<init>", "(Ljava/lang/Object;Ljava/lang/Boolean;)V", "getDefaultVideoId", "()Ljava/lang/Object;", "getHasScheduledVideos", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Ljava/lang/Object;Ljava/lang/Boolean;)Lcom/phisher98/StremioX$CinemetaRes$Meta$BehaviorHints;", "equals", "other", "hashCode", "", "toString", "", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final /* data */ class BehaviorHints {

                @Nullable
                private final Object defaultVideoId;

                @Nullable
                private final Boolean hasScheduledVideos;

                /* JADX WARN: Illegal instructions before constructor call */
                public BehaviorHints() {
                    Boolean bool = null;
                    this(bool, bool, 3, bool);
                }

                public static /* synthetic */ BehaviorHints copy$default(BehaviorHints behaviorHints, Object obj, Boolean bool, int i, Object obj2) {
                    if ((i & 1) != 0) {
                        obj = behaviorHints.defaultVideoId;
                    }
                    if ((i & 2) != 0) {
                        bool = behaviorHints.hasScheduledVideos;
                    }
                    return behaviorHints.copy(obj, bool);
                }

                @Nullable
                /* JADX INFO: renamed from: component1, reason: from getter */
                public final Object getDefaultVideoId() {
                    return this.defaultVideoId;
                }

                @Nullable
                /* JADX INFO: renamed from: component2, reason: from getter */
                public final Boolean getHasScheduledVideos() {
                    return this.hasScheduledVideos;
                }

                @NotNull
                public final BehaviorHints copy(@Nullable Object defaultVideoId, @Nullable Boolean hasScheduledVideos) {
                    return new BehaviorHints(defaultVideoId, hasScheduledVideos);
                }

                public boolean equals(@Nullable Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof BehaviorHints)) {
                        return false;
                    }
                    BehaviorHints behaviorHints = (BehaviorHints) other;
                    return Intrinsics.areEqual(this.defaultVideoId, behaviorHints.defaultVideoId) && Intrinsics.areEqual(this.hasScheduledVideos, behaviorHints.hasScheduledVideos);
                }

                public int hashCode() {
                    return ((this.defaultVideoId == null ? 0 : this.defaultVideoId.hashCode()) * 31) + (this.hasScheduledVideos != null ? this.hasScheduledVideos.hashCode() : 0);
                }

                @NotNull
                public String toString() {
                    return "BehaviorHints(defaultVideoId=" + this.defaultVideoId + ", hasScheduledVideos=" + this.hasScheduledVideos + ')';
                }

                public BehaviorHints(@Nullable Object defaultVideoId, @Nullable Boolean hasScheduledVideos) {
                    this.defaultVideoId = defaultVideoId;
                    this.hasScheduledVideos = hasScheduledVideos;
                }

                public /* synthetic */ BehaviorHints(Object obj, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? null : obj, (i & 2) != 0 ? null : bool);
                }

                @Nullable
                public final Object getDefaultVideoId() {
                    return this.defaultVideoId;
                }

                @Nullable
                public final Boolean getHasScheduledVideos() {
                    return this.hasScheduledVideos;
                }
            }

            /* JADX INFO: compiled from: StremioX.kt */
            @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/phisher98/StremioX$CinemetaRes$Meta$Link;", "", "name", "", "category", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getCategory", "getUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final /* data */ class Link {

                @Nullable
                private final String category;

                @Nullable
                private final String name;

                @Nullable
                private final String url;

                public Link() {
                    this(null, null, null, 7, null);
                }

                public static /* synthetic */ Link copy$default(Link link, String str, String str2, String str3, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = link.name;
                    }
                    if ((i & 2) != 0) {
                        str2 = link.category;
                    }
                    if ((i & 4) != 0) {
                        str3 = link.url;
                    }
                    return link.copy(str, str2, str3);
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
                public final String getUrl() {
                    return this.url;
                }

                @NotNull
                public final Link copy(@Nullable String name, @Nullable String category, @Nullable String url) {
                    return new Link(name, category, url);
                }

                public boolean equals(@Nullable Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof Link)) {
                        return false;
                    }
                    Link link = (Link) other;
                    return Intrinsics.areEqual(this.name, link.name) && Intrinsics.areEqual(this.category, link.category) && Intrinsics.areEqual(this.url, link.url);
                }

                public int hashCode() {
                    return ((((this.name == null ? 0 : this.name.hashCode()) * 31) + (this.category == null ? 0 : this.category.hashCode())) * 31) + (this.url != null ? this.url.hashCode() : 0);
                }

                @NotNull
                public String toString() {
                    return "Link(name=" + this.name + ", category=" + this.category + ", url=" + this.url + ')';
                }

                public Link(@Nullable String name, @Nullable String category, @Nullable String url) {
                    this.name = name;
                    this.category = category;
                    this.url = url;
                }

                public /* synthetic */ Link(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
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
                public final String getUrl() {
                    return this.url;
                }
            }

            /* JADX INFO: compiled from: StremioX.kt */
            @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/phisher98/StremioX$CinemetaRes$Meta$Trailer;", "", "source", "", "type", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSource", "()Ljava/lang/String;", "getType", "getName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final /* data */ class Trailer {

                @Nullable
                private final String name;

                @Nullable
                private final String source;

                @Nullable
                private final String type;

                public Trailer() {
                    this(null, null, null, 7, null);
                }

                public static /* synthetic */ Trailer copy$default(Trailer trailer, String str, String str2, String str3, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = trailer.source;
                    }
                    if ((i & 2) != 0) {
                        str2 = trailer.type;
                    }
                    if ((i & 4) != 0) {
                        str3 = trailer.name;
                    }
                    return trailer.copy(str, str2, str3);
                }

                @Nullable
                /* JADX INFO: renamed from: component1, reason: from getter */
                public final String getSource() {
                    return this.source;
                }

                @Nullable
                /* JADX INFO: renamed from: component2, reason: from getter */
                public final String getType() {
                    return this.type;
                }

                @Nullable
                /* JADX INFO: renamed from: component3, reason: from getter */
                public final String getName() {
                    return this.name;
                }

                @NotNull
                public final Trailer copy(@Nullable String source, @Nullable String type, @Nullable String name) {
                    return new Trailer(source, type, name);
                }

                public boolean equals(@Nullable Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof Trailer)) {
                        return false;
                    }
                    Trailer trailer = (Trailer) other;
                    return Intrinsics.areEqual(this.source, trailer.source) && Intrinsics.areEqual(this.type, trailer.type) && Intrinsics.areEqual(this.name, trailer.name);
                }

                public int hashCode() {
                    return ((((this.source == null ? 0 : this.source.hashCode()) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.name != null ? this.name.hashCode() : 0);
                }

                @NotNull
                public String toString() {
                    return "Trailer(source=" + this.source + ", type=" + this.type + ", name=" + this.name + ')';
                }

                public Trailer(@Nullable String source, @Nullable String type, @Nullable String name) {
                    this.source = source;
                    this.type = type;
                    this.name = name;
                }

                public /* synthetic */ Trailer(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
                }

                @Nullable
                public final String getSource() {
                    return this.source;
                }

                @Nullable
                public final String getType() {
                    return this.type;
                }

                @Nullable
                public final String getName() {
                    return this.name;
                }
            }

            /* JADX INFO: compiled from: StremioX.kt */
            @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/phisher98/StremioX$CinemetaRes$Meta$TrailerStream;", "", "ytId", "", "title", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getYtId", "()Ljava/lang/String;", "getTitle", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final /* data */ class TrailerStream {

                @Nullable
                private final String title;

                @Nullable
                private final String ytId;

                /* JADX WARN: Illegal instructions before constructor call */
                public TrailerStream() {
                    String str = null;
                    this(str, str, 3, str);
                }

                public static /* synthetic */ TrailerStream copy$default(TrailerStream trailerStream, String str, String str2, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = trailerStream.ytId;
                    }
                    if ((i & 2) != 0) {
                        str2 = trailerStream.title;
                    }
                    return trailerStream.copy(str, str2);
                }

                @Nullable
                /* JADX INFO: renamed from: component1, reason: from getter */
                public final String getYtId() {
                    return this.ytId;
                }

                @Nullable
                /* JADX INFO: renamed from: component2, reason: from getter */
                public final String getTitle() {
                    return this.title;
                }

                @NotNull
                public final TrailerStream copy(@Nullable String ytId, @Nullable String title) {
                    return new TrailerStream(ytId, title);
                }

                public boolean equals(@Nullable Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof TrailerStream)) {
                        return false;
                    }
                    TrailerStream trailerStream = (TrailerStream) other;
                    return Intrinsics.areEqual(this.ytId, trailerStream.ytId) && Intrinsics.areEqual(this.title, trailerStream.title);
                }

                public int hashCode() {
                    return ((this.ytId == null ? 0 : this.ytId.hashCode()) * 31) + (this.title != null ? this.title.hashCode() : 0);
                }

                @NotNull
                public String toString() {
                    return "TrailerStream(ytId=" + this.ytId + ", title=" + this.title + ')';
                }

                public TrailerStream(@Nullable String ytId, @Nullable String title) {
                    this.ytId = ytId;
                    this.title = title;
                }

                public /* synthetic */ TrailerStream(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
                }

                @Nullable
                public final String getYtId() {
                    return this.ytId;
                }

                @Nullable
                public final String getTitle() {
                    return this.title;
                }
            }

            /* JADX INFO: compiled from: StremioX.kt */
            @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b!\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jz\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010(J\u0014\u0010)\u001a\u00020\f2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010+\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010,\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0011¨\u0006-"}, d2 = {"Lcom/phisher98/StremioX$CinemetaRes$Meta$Video;", "", "id", "", "title", "season", "", "episode", "thumbnail", "overview", "released", "available", "", "runtime", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getTitle", "getSeason", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEpisode", "getThumbnail", "getOverview", "getReleased", "getAvailable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getRuntime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/phisher98/StremioX$CinemetaRes$Meta$Video;", "equals", "other", "hashCode", "toString", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final /* data */ class Video {

                @Nullable
                private final Boolean available;

                @Nullable
                private final Integer episode;

                @Nullable
                private final String id;

                @Nullable
                private final String overview;

                @Nullable
                private final String released;

                @Nullable
                private final String runtime;

                @Nullable
                private final Integer season;

                @Nullable
                private final String thumbnail;

                @Nullable
                private final String title;

                public Video() {
                    this(null, null, null, null, null, null, null, null, null, 511, null);
                }

                public static /* synthetic */ Video copy$default(Video video, String str, String str2, Integer num, Integer num2, String str3, String str4, String str5, Boolean bool, String str6, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = video.id;
                    }
                    if ((i & 2) != 0) {
                        str2 = video.title;
                    }
                    if ((i & 4) != 0) {
                        num = video.season;
                    }
                    if ((i & 8) != 0) {
                        num2 = video.episode;
                    }
                    if ((i & 16) != 0) {
                        str3 = video.thumbnail;
                    }
                    if ((i & 32) != 0) {
                        str4 = video.overview;
                    }
                    if ((i & 64) != 0) {
                        str5 = video.released;
                    }
                    if ((i & 128) != 0) {
                        bool = video.available;
                    }
                    if ((i & 256) != 0) {
                        str6 = video.runtime;
                    }
                    Boolean bool2 = bool;
                    String str7 = str6;
                    String str8 = str4;
                    String str9 = str5;
                    String str10 = str3;
                    Integer num3 = num;
                    return video.copy(str, str2, num3, num2, str10, str8, str9, bool2, str7);
                }

                @Nullable
                /* JADX INFO: renamed from: component1, reason: from getter */
                public final String getId() {
                    return this.id;
                }

                @Nullable
                /* JADX INFO: renamed from: component2, reason: from getter */
                public final String getTitle() {
                    return this.title;
                }

                @Nullable
                /* JADX INFO: renamed from: component3, reason: from getter */
                public final Integer getSeason() {
                    return this.season;
                }

                @Nullable
                /* JADX INFO: renamed from: component4, reason: from getter */
                public final Integer getEpisode() {
                    return this.episode;
                }

                @Nullable
                /* JADX INFO: renamed from: component5, reason: from getter */
                public final String getThumbnail() {
                    return this.thumbnail;
                }

                @Nullable
                /* JADX INFO: renamed from: component6, reason: from getter */
                public final String getOverview() {
                    return this.overview;
                }

                @Nullable
                /* JADX INFO: renamed from: component7, reason: from getter */
                public final String getReleased() {
                    return this.released;
                }

                @Nullable
                /* JADX INFO: renamed from: component8, reason: from getter */
                public final Boolean getAvailable() {
                    return this.available;
                }

                @Nullable
                /* JADX INFO: renamed from: component9, reason: from getter */
                public final String getRuntime() {
                    return this.runtime;
                }

                @NotNull
                public final Video copy(@Nullable String id, @Nullable String title, @Nullable Integer season, @Nullable Integer episode, @Nullable String thumbnail, @Nullable String overview, @Nullable String released, @Nullable Boolean available, @Nullable String runtime) {
                    return new Video(id, title, season, episode, thumbnail, overview, released, available, runtime);
                }

                public boolean equals(@Nullable Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof Video)) {
                        return false;
                    }
                    Video video = (Video) other;
                    return Intrinsics.areEqual(this.id, video.id) && Intrinsics.areEqual(this.title, video.title) && Intrinsics.areEqual(this.season, video.season) && Intrinsics.areEqual(this.episode, video.episode) && Intrinsics.areEqual(this.thumbnail, video.thumbnail) && Intrinsics.areEqual(this.overview, video.overview) && Intrinsics.areEqual(this.released, video.released) && Intrinsics.areEqual(this.available, video.available) && Intrinsics.areEqual(this.runtime, video.runtime);
                }

                public int hashCode() {
                    return ((((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.season == null ? 0 : this.season.hashCode())) * 31) + (this.episode == null ? 0 : this.episode.hashCode())) * 31) + (this.thumbnail == null ? 0 : this.thumbnail.hashCode())) * 31) + (this.overview == null ? 0 : this.overview.hashCode())) * 31) + (this.released == null ? 0 : this.released.hashCode())) * 31) + (this.available == null ? 0 : this.available.hashCode())) * 31) + (this.runtime != null ? this.runtime.hashCode() : 0);
                }

                @NotNull
                public String toString() {
                    return "Video(id=" + this.id + ", title=" + this.title + ", season=" + this.season + ", episode=" + this.episode + ", thumbnail=" + this.thumbnail + ", overview=" + this.overview + ", released=" + this.released + ", available=" + this.available + ", runtime=" + this.runtime + ')';
                }

                public Video(@Nullable String id, @Nullable String title, @Nullable Integer season, @Nullable Integer episode, @Nullable String thumbnail, @Nullable String overview, @Nullable String released, @Nullable Boolean available, @Nullable String runtime) {
                    this.id = id;
                    this.title = title;
                    this.season = season;
                    this.episode = episode;
                    this.thumbnail = thumbnail;
                    this.overview = overview;
                    this.released = released;
                    this.available = available;
                    this.runtime = runtime;
                }

                public /* synthetic */ Video(String str, String str2, Integer num, Integer num2, String str3, String str4, String str5, Boolean bool, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : bool, (i & 256) != 0 ? null : str6);
                }

                @Nullable
                public final String getId() {
                    return this.id;
                }

                @Nullable
                public final String getTitle() {
                    return this.title;
                }

                @Nullable
                public final Integer getSeason() {
                    return this.season;
                }

                @Nullable
                public final Integer getEpisode() {
                    return this.episode;
                }

                @Nullable
                public final String getThumbnail() {
                    return this.thumbnail;
                }

                @Nullable
                public final String getOverview() {
                    return this.overview;
                }

                @Nullable
                public final String getReleased() {
                    return this.released;
                }

                @Nullable
                public final Boolean getAvailable() {
                    return this.available;
                }

                @Nullable
                public final String getRuntime() {
                    return this.runtime;
                }
            }

            /* JADX INFO: compiled from: StremioX.kt */
            @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003Jc\u0010\u0018\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00032\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00032\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\bHÖ\u0081\u0004R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001b\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u001b\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/phisher98/StremioX$CinemetaRes$Meta$AppExtras;", "", "cast", "", "Lcom/phisher98/StremioX$CinemetaRes$Meta$Cast;", "directors", "writers", "seasonPosters", "", "certification", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getCast", "()Ljava/util/List;", "getDirectors", "getWriters", "getSeasonPosters", "getCertification", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final /* data */ class AppExtras {

                @Nullable
                private final List<Cast> cast;

                @Nullable
                private final String certification;

                @Nullable
                private final List<Object> directors;

                @Nullable
                private final List<String> seasonPosters;

                @Nullable
                private final List<Object> writers;

                public AppExtras() {
                    this(null, null, null, null, null, 31, null);
                }

                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ AppExtras copy$default(AppExtras appExtras, List list, List list2, List list3, List list4, String str, int i, Object obj) {
                    if ((i & 1) != 0) {
                        list = appExtras.cast;
                    }
                    if ((i & 2) != 0) {
                        list2 = appExtras.directors;
                    }
                    if ((i & 4) != 0) {
                        list3 = appExtras.writers;
                    }
                    if ((i & 8) != 0) {
                        list4 = appExtras.seasonPosters;
                    }
                    if ((i & 16) != 0) {
                        str = appExtras.certification;
                    }
                    String str2 = str;
                    List list5 = list3;
                    return appExtras.copy(list, list2, list5, list4, str2);
                }

                @Nullable
                public final List<Cast> component1() {
                    return this.cast;
                }

                @Nullable
                public final List<Object> component2() {
                    return this.directors;
                }

                @Nullable
                public final List<Object> component3() {
                    return this.writers;
                }

                @Nullable
                public final List<String> component4() {
                    return this.seasonPosters;
                }

                @Nullable
                /* JADX INFO: renamed from: component5, reason: from getter */
                public final String getCertification() {
                    return this.certification;
                }

                @NotNull
                public final AppExtras copy(@Nullable List<Cast> cast, @Nullable List<? extends Object> directors, @Nullable List<? extends Object> writers, @Nullable List<String> seasonPosters, @Nullable String certification) {
                    return new AppExtras(cast, directors, writers, seasonPosters, certification);
                }

                public boolean equals(@Nullable Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof AppExtras)) {
                        return false;
                    }
                    AppExtras appExtras = (AppExtras) other;
                    return Intrinsics.areEqual(this.cast, appExtras.cast) && Intrinsics.areEqual(this.directors, appExtras.directors) && Intrinsics.areEqual(this.writers, appExtras.writers) && Intrinsics.areEqual(this.seasonPosters, appExtras.seasonPosters) && Intrinsics.areEqual(this.certification, appExtras.certification);
                }

                public int hashCode() {
                    return ((((((((this.cast == null ? 0 : this.cast.hashCode()) * 31) + (this.directors == null ? 0 : this.directors.hashCode())) * 31) + (this.writers == null ? 0 : this.writers.hashCode())) * 31) + (this.seasonPosters == null ? 0 : this.seasonPosters.hashCode())) * 31) + (this.certification != null ? this.certification.hashCode() : 0);
                }

                @NotNull
                public String toString() {
                    return "AppExtras(cast=" + this.cast + ", directors=" + this.directors + ", writers=" + this.writers + ", seasonPosters=" + this.seasonPosters + ", certification=" + this.certification + ')';
                }

                public AppExtras(@Nullable List<Cast> list, @Nullable List<? extends Object> list2, @Nullable List<? extends Object> list3, @Nullable List<String> list4, @Nullable String certification) {
                    this.cast = list;
                    this.directors = list2;
                    this.writers = list3;
                    this.seasonPosters = list4;
                    this.certification = certification;
                }

                public /* synthetic */ AppExtras(List list, List list2, List list3, List list4, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2, (i & 4) != 0 ? null : list3, (i & 8) != 0 ? null : list4, (i & 16) != 0 ? null : str);
                }

                @Nullable
                public final List<Cast> getCast() {
                    return this.cast;
                }

                @Nullable
                public final List<Object> getDirectors() {
                    return this.directors;
                }

                @Nullable
                public final List<Object> getWriters() {
                    return this.writers;
                }

                @Nullable
                public final List<String> getSeasonPosters() {
                    return this.seasonPosters;
                }

                @Nullable
                public final String getCertification() {
                    return this.certification;
                }
            }

            /* JADX INFO: compiled from: StremioX.kt */
            @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/phisher98/StremioX$CinemetaRes$Meta$Cast;", "", "name", "", "character", "photo", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getCharacter", "getPhoto", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
            public static final /* data */ class Cast {

                @Nullable
                private final String character;

                @Nullable
                private final String name;

                @Nullable
                private final String photo;

                public Cast() {
                    this(null, null, null, 7, null);
                }

                public static /* synthetic */ Cast copy$default(Cast cast, String str, String str2, String str3, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = cast.name;
                    }
                    if ((i & 2) != 0) {
                        str2 = cast.character;
                    }
                    if ((i & 4) != 0) {
                        str3 = cast.photo;
                    }
                    return cast.copy(str, str2, str3);
                }

                @Nullable
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
                public final String getPhoto() {
                    return this.photo;
                }

                @NotNull
                public final Cast copy(@Nullable String name, @Nullable String character, @Nullable String photo) {
                    return new Cast(name, character, photo);
                }

                public boolean equals(@Nullable Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof Cast)) {
                        return false;
                    }
                    Cast cast = (Cast) other;
                    return Intrinsics.areEqual(this.name, cast.name) && Intrinsics.areEqual(this.character, cast.character) && Intrinsics.areEqual(this.photo, cast.photo);
                }

                public int hashCode() {
                    return ((((this.name == null ? 0 : this.name.hashCode()) * 31) + (this.character == null ? 0 : this.character.hashCode())) * 31) + (this.photo != null ? this.photo.hashCode() : 0);
                }

                @NotNull
                public String toString() {
                    return "Cast(name=" + this.name + ", character=" + this.character + ", photo=" + this.photo + ')';
                }

                public Cast(@Nullable String name, @Nullable String character, @Nullable String photo) {
                    this.name = name;
                    this.character = character;
                    this.photo = photo;
                }

                public /* synthetic */ Cast(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
                }

                @Nullable
                public final String getName() {
                    return this.name;
                }

                @Nullable
                public final String getCharacter() {
                    return this.character;
                }

                @Nullable
                public final String getPhoto() {
                    return this.photo;
                }
            }
        }
    }

    /* JADX INFO: compiled from: StremioX.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\bJ\b\u0086\b\u0018\u00002\u00020\u0001Bµ\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010<\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010>\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010B\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010F\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010G\u001a\u00020\u0011HÆ\u0003J\u0010\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010J\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010N\u001a\u00020\u0011HÆ\u0003J\t\u0010O\u001a\u00020\u0011HÆ\u0003J\t\u0010P\u001a\u00020\u0011HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010S\u001a\u00020\u0011HÆ\u0003J\u0010\u0010T\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u00109J¼\u0002\u0010U\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00112\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u00112\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u0010VJ\u0014\u0010W\u001a\u00020\u00112\b\u0010X\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010Y\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010Z\u001a\u00020\u0005HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010#\u001a\u0004\b&\u0010\"R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010%R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010#\u001a\u0004\b(\u0010\"R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010#\u001a\u0004\b)\u0010\"R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010#\u001a\u0004\b*\u0010\"R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010%R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010%R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010%R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010#\u001a\u0004\b.\u0010\"R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u0010%R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u00100R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010#\u001a\u0004\b1\u0010\"R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010#\u001a\u0004\b2\u0010\"R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u0010%R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b4\u0010%R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u0010%R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b6\u0010%R\u0011\u0010\u0018\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u00100R\u0011\u0010\u0019\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u00100R\u0011\u0010\u001a\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u00100R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b7\u0010%R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b8\u0010%R\u0011\u0010\u001d\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u00100R\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010:\u001a\u0004\b\u001e\u00109¨\u0006["}, d2 = {"Lcom/phisher98/StremioX$LinkData;", "", "id", "", "imdbId", "", "tvdbId", "type", "season", "episode", "epid", "aniId", "animeId", "title", "year", "orgTitle", "isAnime", "", "airedYear", "lastSeason", "epsTitle", "jpTitle", "date", "airedDate", "isAsian", "isBollywood", "isCartoon", "alttitle", "nametitle", "isDub", "isMovie", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZLjava/lang/String;Ljava/lang/String;ZLjava/lang/Boolean;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getImdbId", "()Ljava/lang/String;", "getTvdbId", "getType", "getSeason", "getEpisode", "getEpid", "getAniId", "getAnimeId", "getTitle", "getYear", "getOrgTitle", "()Z", "getAiredYear", "getLastSeason", "getEpsTitle", "getJpTitle", "getDate", "getAiredDate", "getAlttitle", "getNametitle", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZLjava/lang/String;Ljava/lang/String;ZLjava/lang/Boolean;)Lcom/phisher98/StremioX$LinkData;", "equals", "other", "hashCode", "toString", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class LinkData {

        @Nullable
        private final String airedDate;

        @Nullable
        private final Integer airedYear;

        @Nullable
        private final String alttitle;

        @Nullable
        private final String aniId;

        @Nullable
        private final String animeId;

        @Nullable
        private final String date;

        @Nullable
        private final Integer epid;

        @Nullable
        private final Integer episode;

        @Nullable
        private final String epsTitle;

        @Nullable
        private final Integer id;

        @Nullable
        private final String imdbId;
        private final boolean isAnime;
        private final boolean isAsian;
        private final boolean isBollywood;
        private final boolean isCartoon;
        private final boolean isDub;

        @Nullable
        private final Boolean isMovie;

        @Nullable
        private final String jpTitle;

        @Nullable
        private final Integer lastSeason;

        @Nullable
        private final String nametitle;

        @Nullable
        private final String orgTitle;

        @Nullable
        private final Integer season;

        @Nullable
        private final String title;

        @Nullable
        private final Integer tvdbId;

        @Nullable
        private final String type;

        @Nullable
        private final Integer year;

        public LinkData() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, false, false, false, null, null, false, null, 67108863, null);
        }

        public static /* synthetic */ LinkData copy$default(LinkData linkData, Integer num, String str, Integer num2, String str2, Integer num3, Integer num4, Integer num5, String str3, String str4, String str5, Integer num6, String str6, boolean z, Integer num7, Integer num8, String str7, String str8, String str9, String str10, boolean z2, boolean z3, boolean z4, String str11, String str12, boolean z5, Boolean bool, int i, Object obj) {
            Boolean bool2;
            boolean z6;
            Integer num9 = (i & 1) != 0 ? linkData.id : num;
            String str13 = (i & 2) != 0 ? linkData.imdbId : str;
            Integer num10 = (i & 4) != 0 ? linkData.tvdbId : num2;
            String str14 = (i & 8) != 0 ? linkData.type : str2;
            Integer num11 = (i & 16) != 0 ? linkData.season : num3;
            Integer num12 = (i & 32) != 0 ? linkData.episode : num4;
            Integer num13 = (i & 64) != 0 ? linkData.epid : num5;
            String str15 = (i & 128) != 0 ? linkData.aniId : str3;
            String str16 = (i & 256) != 0 ? linkData.animeId : str4;
            String str17 = (i & 512) != 0 ? linkData.title : str5;
            Integer num14 = (i & 1024) != 0 ? linkData.year : num6;
            String str18 = (i & 2048) != 0 ? linkData.orgTitle : str6;
            boolean z7 = (i & 4096) != 0 ? linkData.isAnime : z;
            Integer num15 = (i & 8192) != 0 ? linkData.airedYear : num7;
            Integer num16 = num9;
            Integer num17 = (i & 16384) != 0 ? linkData.lastSeason : num8;
            String str19 = (i & 32768) != 0 ? linkData.epsTitle : str7;
            String str20 = (i & 65536) != 0 ? linkData.jpTitle : str8;
            String str21 = (i & 131072) != 0 ? linkData.date : str9;
            String str22 = (i & 262144) != 0 ? linkData.airedDate : str10;
            boolean z8 = (i & 524288) != 0 ? linkData.isAsian : z2;
            boolean z9 = (i & 1048576) != 0 ? linkData.isBollywood : z3;
            boolean z10 = (i & 2097152) != 0 ? linkData.isCartoon : z4;
            String str23 = (i & 4194304) != 0 ? linkData.alttitle : str11;
            String str24 = (i & 8388608) != 0 ? linkData.nametitle : str12;
            boolean z11 = (i & 16777216) != 0 ? linkData.isDub : z5;
            if ((i & 33554432) != 0) {
                z6 = z11;
                bool2 = linkData.isMovie;
            } else {
                bool2 = bool;
                z6 = z11;
            }
            return linkData.copy(num16, str13, num10, str14, num11, num12, num13, str15, str16, str17, num14, str18, z7, num15, num17, str19, str20, str21, str22, z8, z9, z10, str23, str24, z6, bool2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component10, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component11, reason: from getter */
        public final Integer getYear() {
            return this.year;
        }

        @Nullable
        /* JADX INFO: renamed from: component12, reason: from getter */
        public final String getOrgTitle() {
            return this.orgTitle;
        }

        /* JADX INFO: renamed from: component13, reason: from getter */
        public final boolean getIsAnime() {
            return this.isAnime;
        }

        @Nullable
        /* JADX INFO: renamed from: component14, reason: from getter */
        public final Integer getAiredYear() {
            return this.airedYear;
        }

        @Nullable
        /* JADX INFO: renamed from: component15, reason: from getter */
        public final Integer getLastSeason() {
            return this.lastSeason;
        }

        @Nullable
        /* JADX INFO: renamed from: component16, reason: from getter */
        public final String getEpsTitle() {
            return this.epsTitle;
        }

        @Nullable
        /* JADX INFO: renamed from: component17, reason: from getter */
        public final String getJpTitle() {
            return this.jpTitle;
        }

        @Nullable
        /* JADX INFO: renamed from: component18, reason: from getter */
        public final String getDate() {
            return this.date;
        }

        @Nullable
        /* JADX INFO: renamed from: component19, reason: from getter */
        public final String getAiredDate() {
            return this.airedDate;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getImdbId() {
            return this.imdbId;
        }

        /* JADX INFO: renamed from: component20, reason: from getter */
        public final boolean getIsAsian() {
            return this.isAsian;
        }

        /* JADX INFO: renamed from: component21, reason: from getter */
        public final boolean getIsBollywood() {
            return this.isBollywood;
        }

        /* JADX INFO: renamed from: component22, reason: from getter */
        public final boolean getIsCartoon() {
            return this.isCartoon;
        }

        @Nullable
        /* JADX INFO: renamed from: component23, reason: from getter */
        public final String getAlttitle() {
            return this.alttitle;
        }

        @Nullable
        /* JADX INFO: renamed from: component24, reason: from getter */
        public final String getNametitle() {
            return this.nametitle;
        }

        /* JADX INFO: renamed from: component25, reason: from getter */
        public final boolean getIsDub() {
            return this.isDub;
        }

        @Nullable
        /* JADX INFO: renamed from: component26, reason: from getter */
        public final Boolean getIsMovie() {
            return this.isMovie;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getTvdbId() {
            return this.tvdbId;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Integer getSeason() {
            return this.season;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Integer getEpisode() {
            return this.episode;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Integer getEpid() {
            return this.epid;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getAniId() {
            return this.aniId;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getAnimeId() {
            return this.animeId;
        }

        @NotNull
        public final LinkData copy(@Nullable Integer id, @Nullable String imdbId, @Nullable Integer tvdbId, @Nullable String type, @Nullable Integer season, @Nullable Integer episode, @Nullable Integer epid, @Nullable String aniId, @Nullable String animeId, @Nullable String title, @Nullable Integer year, @Nullable String orgTitle, boolean isAnime, @Nullable Integer airedYear, @Nullable Integer lastSeason, @Nullable String epsTitle, @Nullable String jpTitle, @Nullable String date, @Nullable String airedDate, boolean isAsian, boolean isBollywood, boolean isCartoon, @Nullable String alttitle, @Nullable String nametitle, boolean isDub, @Nullable Boolean isMovie) {
            return new LinkData(id, imdbId, tvdbId, type, season, episode, epid, aniId, animeId, title, year, orgTitle, isAnime, airedYear, lastSeason, epsTitle, jpTitle, date, airedDate, isAsian, isBollywood, isCartoon, alttitle, nametitle, isDub, isMovie);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LinkData)) {
                return false;
            }
            LinkData linkData = (LinkData) other;
            return Intrinsics.areEqual(this.id, linkData.id) && Intrinsics.areEqual(this.imdbId, linkData.imdbId) && Intrinsics.areEqual(this.tvdbId, linkData.tvdbId) && Intrinsics.areEqual(this.type, linkData.type) && Intrinsics.areEqual(this.season, linkData.season) && Intrinsics.areEqual(this.episode, linkData.episode) && Intrinsics.areEqual(this.epid, linkData.epid) && Intrinsics.areEqual(this.aniId, linkData.aniId) && Intrinsics.areEqual(this.animeId, linkData.animeId) && Intrinsics.areEqual(this.title, linkData.title) && Intrinsics.areEqual(this.year, linkData.year) && Intrinsics.areEqual(this.orgTitle, linkData.orgTitle) && this.isAnime == linkData.isAnime && Intrinsics.areEqual(this.airedYear, linkData.airedYear) && Intrinsics.areEqual(this.lastSeason, linkData.lastSeason) && Intrinsics.areEqual(this.epsTitle, linkData.epsTitle) && Intrinsics.areEqual(this.jpTitle, linkData.jpTitle) && Intrinsics.areEqual(this.date, linkData.date) && Intrinsics.areEqual(this.airedDate, linkData.airedDate) && this.isAsian == linkData.isAsian && this.isBollywood == linkData.isBollywood && this.isCartoon == linkData.isCartoon && Intrinsics.areEqual(this.alttitle, linkData.alttitle) && Intrinsics.areEqual(this.nametitle, linkData.nametitle) && this.isDub == linkData.isDub && Intrinsics.areEqual(this.isMovie, linkData.isMovie);
        }

        public int hashCode() {
            return ((((((((((((((((((((((((((((((((((((((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.imdbId == null ? 0 : this.imdbId.hashCode())) * 31) + (this.tvdbId == null ? 0 : this.tvdbId.hashCode())) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.season == null ? 0 : this.season.hashCode())) * 31) + (this.episode == null ? 0 : this.episode.hashCode())) * 31) + (this.epid == null ? 0 : this.epid.hashCode())) * 31) + (this.aniId == null ? 0 : this.aniId.hashCode())) * 31) + (this.animeId == null ? 0 : this.animeId.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.year == null ? 0 : this.year.hashCode())) * 31) + (this.orgTitle == null ? 0 : this.orgTitle.hashCode())) * 31) + StremioX$LinkData$$ExternalSyntheticBackport0.m1m(this.isAnime)) * 31) + (this.airedYear == null ? 0 : this.airedYear.hashCode())) * 31) + (this.lastSeason == null ? 0 : this.lastSeason.hashCode())) * 31) + (this.epsTitle == null ? 0 : this.epsTitle.hashCode())) * 31) + (this.jpTitle == null ? 0 : this.jpTitle.hashCode())) * 31) + (this.date == null ? 0 : this.date.hashCode())) * 31) + (this.airedDate == null ? 0 : this.airedDate.hashCode())) * 31) + StremioX$LinkData$$ExternalSyntheticBackport0.m1m(this.isAsian)) * 31) + StremioX$LinkData$$ExternalSyntheticBackport0.m1m(this.isBollywood)) * 31) + StremioX$LinkData$$ExternalSyntheticBackport0.m1m(this.isCartoon)) * 31) + (this.alttitle == null ? 0 : this.alttitle.hashCode())) * 31) + (this.nametitle == null ? 0 : this.nametitle.hashCode())) * 31) + StremioX$LinkData$$ExternalSyntheticBackport0.m1m(this.isDub)) * 31) + (this.isMovie != null ? this.isMovie.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("LinkData(id=").append(this.id).append(", imdbId=").append(this.imdbId).append(", tvdbId=").append(this.tvdbId).append(", type=").append(this.type).append(", season=").append(this.season).append(", episode=").append(this.episode).append(", epid=").append(this.epid).append(", aniId=").append(this.aniId).append(", animeId=").append(this.animeId).append(", title=").append(this.title).append(", year=").append(this.year).append(", orgTitle=");
            sb.append(this.orgTitle).append(", isAnime=").append(this.isAnime).append(", airedYear=").append(this.airedYear).append(", lastSeason=").append(this.lastSeason).append(", epsTitle=").append(this.epsTitle).append(", jpTitle=").append(this.jpTitle).append(", date=").append(this.date).append(", airedDate=").append(this.airedDate).append(", isAsian=").append(this.isAsian).append(", isBollywood=").append(this.isBollywood).append(", isCartoon=").append(this.isCartoon).append(", alttitle=").append(this.alttitle);
            sb.append(", nametitle=").append(this.nametitle).append(", isDub=").append(this.isDub).append(", isMovie=").append(this.isMovie).append(')');
            return sb.toString();
        }

        public LinkData(@Nullable Integer id, @Nullable String imdbId, @Nullable Integer tvdbId, @Nullable String type, @Nullable Integer season, @Nullable Integer episode, @Nullable Integer epid, @Nullable String aniId, @Nullable String animeId, @Nullable String title, @Nullable Integer year, @Nullable String orgTitle, boolean isAnime, @Nullable Integer airedYear, @Nullable Integer lastSeason, @Nullable String epsTitle, @Nullable String jpTitle, @Nullable String date, @Nullable String airedDate, boolean isAsian, boolean isBollywood, boolean isCartoon, @Nullable String alttitle, @Nullable String nametitle, boolean isDub, @Nullable Boolean isMovie) {
            this.id = id;
            this.imdbId = imdbId;
            this.tvdbId = tvdbId;
            this.type = type;
            this.season = season;
            this.episode = episode;
            this.epid = epid;
            this.aniId = aniId;
            this.animeId = animeId;
            this.title = title;
            this.year = year;
            this.orgTitle = orgTitle;
            this.isAnime = isAnime;
            this.airedYear = airedYear;
            this.lastSeason = lastSeason;
            this.epsTitle = epsTitle;
            this.jpTitle = jpTitle;
            this.date = date;
            this.airedDate = airedDate;
            this.isAsian = isAsian;
            this.isBollywood = isBollywood;
            this.isCartoon = isCartoon;
            this.alttitle = alttitle;
            this.nametitle = nametitle;
            this.isDub = isDub;
            this.isMovie = isMovie;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ LinkData(Integer num, String str, Integer num2, String str2, Integer num3, Integer num4, Integer num5, String str3, String str4, String str5, Integer num6, String str6, boolean z, Integer num7, Integer num8, String str7, String str8, String str9, String str10, boolean z2, boolean z3, boolean z4, String str11, String str12, boolean z5, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
            Integer num9 = (i & 1) != 0 ? null : num;
            String str13 = (i & 2) != 0 ? null : str;
            Integer num10 = (i & 4) != 0 ? null : num2;
            String str14 = (i & 8) != 0 ? null : str2;
            Integer num11 = (i & 16) != 0 ? null : num3;
            Integer num12 = (i & 32) != 0 ? null : num4;
            Integer num13 = (i & 64) != 0 ? null : num5;
            String str15 = (i & 128) != 0 ? null : str3;
            String str16 = (i & 256) != 0 ? null : str4;
            String str17 = (i & 512) != 0 ? null : str5;
            Integer num14 = (i & 1024) != 0 ? null : num6;
            String str18 = (i & 2048) != 0 ? null : str6;
            boolean z6 = (i & 4096) != 0 ? false : z;
            Integer num15 = (i & 8192) != 0 ? null : num7;
            this(num9, str13, num10, str14, num11, num12, num13, str15, str16, str17, num14, str18, z6, num15, (i & 16384) != 0 ? null : num8, (i & 32768) != 0 ? null : str7, (i & 65536) != 0 ? null : str8, (i & 131072) != 0 ? null : str9, (i & 262144) != 0 ? null : str10, (i & 524288) != 0 ? false : z2, (i & 1048576) != 0 ? false : z3, (i & 2097152) != 0 ? false : z4, (i & 4194304) != 0 ? null : str11, (i & 8388608) != 0 ? null : str12, (i & 16777216) != 0 ? false : z5, (i & 33554432) != 0 ? false : bool);
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
        public final Integer getTvdbId() {
            return this.tvdbId;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }

        @Nullable
        public final Integer getSeason() {
            return this.season;
        }

        @Nullable
        public final Integer getEpisode() {
            return this.episode;
        }

        @Nullable
        public final Integer getEpid() {
            return this.epid;
        }

        @Nullable
        public final String getAniId() {
            return this.aniId;
        }

        @Nullable
        public final String getAnimeId() {
            return this.animeId;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final Integer getYear() {
            return this.year;
        }

        @Nullable
        public final String getOrgTitle() {
            return this.orgTitle;
        }

        public final boolean isAnime() {
            return this.isAnime;
        }

        @Nullable
        public final Integer getAiredYear() {
            return this.airedYear;
        }

        @Nullable
        public final Integer getLastSeason() {
            return this.lastSeason;
        }

        @Nullable
        public final String getEpsTitle() {
            return this.epsTitle;
        }

        @Nullable
        public final String getJpTitle() {
            return this.jpTitle;
        }

        @Nullable
        public final String getDate() {
            return this.date;
        }

        @Nullable
        public final String getAiredDate() {
            return this.airedDate;
        }

        public final boolean isAsian() {
            return this.isAsian;
        }

        public final boolean isBollywood() {
            return this.isBollywood;
        }

        public final boolean isCartoon() {
            return this.isCartoon;
        }

        @Nullable
        public final String getAlttitle() {
            return this.alttitle;
        }

        @Nullable
        public final String getNametitle() {
            return this.nametitle;
        }

        public final boolean isDub() {
            return this.isDub;
        }

        @Nullable
        public final Boolean isMovie() {
            return this.isMovie;
        }
    }
}
