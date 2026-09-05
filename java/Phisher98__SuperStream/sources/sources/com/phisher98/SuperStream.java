package com.phisher98;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lagradost.api.Log;
import com.lagradost.cloudstream3.APIHolder;
import com.lagradost.cloudstream3.ActorData;
import com.lagradost.cloudstream3.AnimeLoadResponse;
import com.lagradost.cloudstream3.DubStatus;
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
import com.lagradost.cloudstream3.Score;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SearchResponseList;
import com.lagradost.cloudstream3.ShowStatus;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvSeriesSearchResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.metaproviders.TmdbProvider;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
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
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.TimeoutKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: SuperStream.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/SuperStream/classes.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0016\u0018\u0000 K2\u00020\u0001:\u0017KLMNOPQRSTUVWXYZ[\\]^_`aB\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\"\u001a\u0004\u0018\u00010\u00072\b\u0010#\u001a\u0004\u0018\u00010\u0007H\u0002J\u0014\u0010$\u001a\u0004\u0018\u00010\u00072\b\u0010#\u001a\u0004\u0018\u00010\u0007H\u0002J\u001e\u0010 \u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0096@¢\u0006\u0002\u0010*J\u001a\u0010+\u001a\u0004\u0018\u00010,*\u00020-2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0007H\u0002J\u0014\u0010+\u001a\u0004\u0018\u00010,*\u00020/H\u0082@¢\u0006\u0002\u00100J\u001e\u00101\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u001e2\u0006\u00102\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u00103J \u00104\u001a\u0004\u0018\u0001052\u0006\u00102\u001a\u00020\u00072\u0006\u0010&\u001a\u00020'H\u0096@¢\u0006\u0002\u00106J\u0018\u00107\u001a\u0004\u0018\u0001082\u0006\u00109\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u00103JX\u0010:\u001a\u00020\r2\u0006\u0010;\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\r2\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020@0>2\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020@0>H\u0097@b\u0010\bD\u0012\f\bE\u0012\b\b\fJ\u0004\b\b(F¢\u0006\u0002\u0010CJ\b\u0010G\u001a\u00020HH\u0002J\u0012\u0010I\u001a\u00020\r2\b\u0010J\u001a\u0004\u0018\u00010\u0007H\u0002R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\rX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\rX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\rX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\tR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006b"}, d2 = {"Lcom/phisher98/SuperStream;", "Lcom/lagradost/cloudstream3/metaproviders/TmdbProvider;", "sharedPref", "Landroid/content/SharedPreferences;", "<init>", "(Landroid/content/SharedPreferences;)V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "hasMainPage", "", "getHasMainPage", "()Z", "instantLinkLoading", "getInstantLinkLoading", "useMetaLoadResponse", "getUseMetaLoadResponse", "hasQuickSearch", "getHasQuickSearch", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "token", "getToken", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "getImageUrl", "link", "getOriImageUrl", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResponse", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lcom/phisher98/SuperStream$Media;", "type", "Lorg/jsoup/nodes/Element;", "(Lorg/jsoup/nodes/Element;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "quickSearch", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "Lcom/lagradost/cloudstream3/SearchResponseList;", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/annotation/SuppressLint;", "value", "SuspiciousIndentation", "getDate", "Lcom/phisher98/SuperStream$TmdbDate;", "isUpcoming", "dateString", "Companion", "LinkData", "Data", "Results", "Media", "Genres", "Keywords", "KeywordResults", "Seasons", "Cast", "Episodes", "MediaDetailEpisodes", "Trailers", "ResultsTrailer", "AltTitles", "ResultsAltTitles", "ExternalIds", "Credits", "ResultsRecommendations", "LastEpisodeToAir", "ProductionCountries", "MediaDetail", "TmdbDate", "SuperStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSuperStream.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SuperStream.kt\ncom/phisher98/SuperStream\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 6 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,853:1\n73#2,5:854\n73#2,5:873\n73#2,5:892\n73#2,5:897\n73#2,5:916\n73#2,5:947\n73#2,5:1048\n73#2,5:1069\n1795#3,10:859\n2068#3:869\n2069#3:871\n1805#3:872\n1795#3,10:878\n2068#3:888\n2069#3:890\n1805#3:891\n1795#3,10:902\n2068#3:912\n2069#3:914\n1805#3:915\n1759#3:921\n1770#3:922\n2077#3,2:923\n2079#3:926\n1771#3:927\n1795#3,10:952\n2068#3:962\n2069#3:964\n1805#3:965\n1960#3,3:966\n1795#3,10:969\n2068#3:979\n2069#3:981\n1805#3:982\n1795#3,10:984\n2068#3:994\n2069#3:996\n1805#3:997\n1795#3,10:998\n2068#3:1008\n2069#3:1010\n1805#3:1011\n1795#3,10:1012\n2068#3:1022\n2069#3:1024\n1805#3:1025\n777#3:1026\n873#3,2:1027\n1739#3:1029\n1814#3,3:1030\n1739#3:1033\n1814#3,3:1034\n1795#3,10:1037\n2068#3:1047\n1739#3:1053\n1814#3,2:1054\n1816#3:1057\n2069#3:1059\n1805#3:1060\n777#3:1061\n873#3,2:1062\n1739#3:1064\n1814#3,2:1065\n1816#3:1068\n1#4:870\n1#4:889\n1#4:913\n1#4:925\n1#4:929\n1#4:963\n1#4:980\n1#4:983\n1#4:995\n1#4:1009\n1#4:1023\n1#4:1056\n1#4:1058\n1#4:1067\n1#4:1075\n1#4:1093\n63#5:928\n64#5,15:930\n63#5:1074\n64#5,15:1076\n50#6:945\n43#6:946\n50#6:1091\n43#6:1092\n*S KotlinDebug\n*F\n+ 1 SuperStream.kt\ncom/phisher98/SuperStream\n*L\n198#1:854,5\n222#1:873,5\n262#1:892,5\n283#1:897,5\n299#1:916,5\n350#1:947,5\n391#1:1048,5\n608#1:1069,5\n202#1:859,10\n202#1:869\n202#1:871\n202#1:872\n222#1:878,10\n222#1:888\n222#1:890\n222#1:891\n283#1:902,10\n283#1:912\n283#1:914\n283#1:915\n306#1:921\n306#1:922\n306#1:923,2\n306#1:926\n306#1:927\n359#1:952,10\n359#1:962\n359#1:964\n359#1:965\n364#1:966,3\n366#1:969,10\n366#1:979\n366#1:981\n366#1:982\n367#1:984,10\n367#1:994\n367#1:996\n367#1:997\n369#1:998,10\n369#1:1008\n369#1:1010\n369#1:1011\n377#1:1012,10\n377#1:1022\n377#1:1024\n377#1:1025\n380#1:1026\n380#1:1027,2\n381#1:1029\n381#1:1030,3\n384#1:1033\n384#1:1034,3\n389#1:1037,10\n389#1:1047\n391#1:1053\n391#1:1054,2\n391#1:1057\n389#1:1059\n389#1:1060\n441#1:1061\n441#1:1062,2\n442#1:1064\n442#1:1065,2\n442#1:1068\n202#1:870\n222#1:889\n283#1:913\n306#1:925\n340#1:929\n359#1:963\n366#1:980\n367#1:995\n369#1:1009\n377#1:1023\n389#1:1058\n624#1:1075\n340#1:928\n340#1:930,15\n624#1:1074\n624#1:1076,15\n340#1:945\n340#1:946\n624#1:1091\n624#1:1092\n*E\n"})
public class SuperStream extends TmdbProvider {

    @NotNull
    private static final String Cinemeta = "https://aiometadata.elfhosted.com/stremio/b7cb164b-074b-41d5-b458-b3a834e197bb";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String OFFICIAL_TMDB_URL = "https://api.themoviedb.org/3";

    @NotNull
    private static final String REMOTE_PROXY_LIST = "https://raw.githubusercontent.com/phisher98/TVVVV/refs/heads/main/Proxylist.txt";

    @NotNull
    private static final String apiKey = "98ae14df2b8d8f8f8136499daf79f0e0";

    @NotNull
    public static final String febbox = "https://www.febbox.com";
    private final boolean hasMainPage;
    private final boolean hasQuickSearch;
    private final boolean instantLinkLoading;

    @NotNull
    private final List<MainPageData> mainPage;

    @NotNull
    private String name;

    @NotNull
    private final Set<TvType> supportedTypes;

    @Nullable
    private final String token;
    private final boolean useMetaLoadResponse;

    /* JADX INFO: renamed from: com.phisher98.SuperStream$getMainPage$1 */
    /* JADX INFO: compiled from: SuperStream.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.SuperStream", f = "SuperStream.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3}, l = {185, 195, 203, 221}, m = "getMainPage$suspendImpl", n = {"$this", "request", "page", "$this", "request", "tmdbAPI", "page", "$this", "request", "tmdbAPI", "htmlResponse", "document", "parsedHtmlContent", "$this$mapNotNull$iv", "$this$mapNotNullTo$iv$iv", "destination$iv$iv", "$this$forEach$iv$iv$iv", "element$iv$iv$iv", "element$iv$iv", "div", "page", "$this", "request", "tmdbAPI", "adultQuery", "type", "page"}, nl = {186, 198, 868, 222}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "L$12", "L$13", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
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
            return SuperStream.getMainPage$suspendImpl(SuperStream.this, 0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.SuperStream$load$1 */
    /* JADX INFO: compiled from: SuperStream.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.SuperStream", f = "SuperStream.kt", i = {0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, l = {290, 296, 318, 329, 339, 350, 390, 434, 482, 499, 516}, m = "load$suspendImpl", n = {"$this", "url", "$this", "url", "jsonString", "response", "media", "$this", "url", "jsonString", "response", "media", "folderRes", "data", "listHtml", "doc", "episodes", "$this", "url", "jsonString", "response", "media", "$this", "url", "$this", "url", "tmdbAPI", "data", "type", "append", "resUrl", "$this", "url", "tmdbAPI", "data", "type", "append", "resUrl", "res", "title", "poster", "bgPoster", "orgTitle", "releaseDate", "year", "rating", "genres", "keywords", "actors", "recommendations", "trailer", "lastSeason", "$this$mapNotNull$iv", "$this$mapNotNullTo$iv$iv", "destination$iv$iv", "$this$forEach$iv$iv$iv", "element$iv$iv$iv", "element$iv$iv", "season", "isCartoon", "isAnime", "isAsian", "isBollywood", "$this", "url", "tmdbAPI", "data", "type", "append", "resUrl", "res", "title", "poster", "bgPoster", "orgTitle", "releaseDate", "year", "rating", "genres", "keywords", "actors", "recommendations", "trailer", "lastSeason", "episodes", "gson", "animeType", "imdbId", "isCartoon", "isAnime", "isAsian", "isBollywood", "$this", "url", "tmdbAPI", "data", "type", "append", "resUrl", "res", "title", "poster", "bgPoster", "orgTitle", "releaseDate", "year", "rating", "genres", "keywords", "actors", "recommendations", "trailer", "lastSeason", "episodes", "gson", "animeType", "imdbId", "cineJsonText", "cinejson", "animevideos", "animeepisodes", "isCartoon", "isAnime", "isAsian", "isBollywood", "$this", "url", "tmdbAPI", "data", "type", "append", "resUrl", "res", "title", "poster", "bgPoster", "orgTitle", "releaseDate", "year", "rating", "genres", "keywords", "actors", "recommendations", "trailer", "lastSeason", "episodes", "isCartoon", "isAnime", "isAsian", "isBollywood", "$this", "url", "tmdbAPI", "data", "type", "append", "resUrl", "res", "title", "poster", "bgPoster", "orgTitle", "releaseDate", "year", "rating", "genres", "keywords", "actors", "recommendations", "trailer", "isCartoon", "isAnime", "isAsian", "isBollywood"}, nl = {291, 299, 329, 339, 340, 885, 391, 435, 499, 516, -1}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$26", "L$27", "L$28", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$28", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "I$0", "I$1", "I$2", "I$3"}, v = 2)
    static final class C00021 extends ContinuationImpl {
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
        Object L$27;
        Object L$28;
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
            return SuperStream.load$suspendImpl(SuperStream.this, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.SuperStream$loadLinks$1 */
    /* JADX INFO: compiled from: SuperStream.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.SuperStream", f = "SuperStream.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4}, l = {576, 596, 608, 614, 625}, m = "loadLinks$suspendImpl", n = {"$this", "data", "subtitleCallback", "callback", "fid", "postdata", "isCasting", "$this", "data", "subtitleCallback", "callback", "fid", "postdata", "source", "regex", "pattern", "matcher", "file", "label", "isCasting", "found", "$this", "data", "subtitleCallback", "callback", "fid", "postdata", "source", "regex", "pattern", "matcher", "isCasting", "found", "$this", "data", "subtitleCallback", "callback", "fid", "postdata", "source", "regex", "pattern", "matcher", "res", "list", "first", "url", "isCasting", "found", "$this", "data", "subtitleCallback", "callback", "res", "isCasting"}, nl = {580, 595, 854, 613, 660}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0"}, v = 2)
    static final class C00081 extends ContinuationImpl {
        int I$0;
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

        C00081(Continuation<? super C00081> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SuperStream.loadLinks$suspendImpl(SuperStream.this, null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.SuperStream$quickSearch$1 */
    /* JADX INFO: compiled from: SuperStream.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.SuperStream", f = "SuperStream.kt", i = {0, 0}, l = {278}, m = "quickSearch$suspendImpl", n = {"$this", "query"}, nl = {-1}, s = {"L$0", "L$1"}, v = 2)
    static final class C00121 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00121(Continuation<? super C00121> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SuperStream.quickSearch$suspendImpl(SuperStream.this, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.SuperStream$search$1 */
    /* JADX INFO: compiled from: SuperStream.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.SuperStream", f = "SuperStream.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {281, 282}, m = "search$suspendImpl", n = {"$this", "query", "page", "$this", "query", "tmdbAPI", "page"}, nl = {283, 283}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "L$2", "I$0"}, v = 2)
    static final class C00131 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00131(Continuation<? super C00131> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SuperStream.search$suspendImpl(SuperStream.this, null, 0, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.SuperStream$toSearchResponse$2 */
    /* JADX INFO: compiled from: SuperStream.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.SuperStream", f = "SuperStream.kt", i = {0, 0, 0, 0, 0, 0}, l = {259}, m = "toSearchResponse", n = {"$this$toSearchResponse", "title", "poster", "fid", "href", "isDir"}, nl = {262}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0"}, v = 2)
    static final class C00142 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00142(Continuation<? super C00142> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SuperStream.this.toSearchResponse((Element) null, (Continuation<? super SearchResponse>) this);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SuperStream() {
        SharedPreferences sharedPreferences = null;
        this(sharedPreferences, 1, sharedPreferences);
    }

    @Nullable
    public Object getMainPage(int i, @NotNull MainPageRequest mainPageRequest, @NotNull Continuation<? super HomePageResponse> continuation) {
        return getMainPage$suspendImpl(this, i, mainPageRequest, continuation);
    }

    @Nullable
    public Object load(@NotNull String str, @NotNull Continuation<? super LoadResponse> continuation) {
        return load$suspendImpl(this, str, continuation);
    }

    @SuppressLint({"SuspiciousIndentation"})
    @Nullable
    public Object loadLinks(@NotNull String str, boolean z, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        return loadLinks$suspendImpl(this, str, z, function1, function2, continuation);
    }

    @Nullable
    public Object quickSearch(@NotNull String str, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        return quickSearch$suspendImpl(this, str, continuation);
    }

    @Nullable
    public Object search(@NotNull String str, int i, @NotNull Continuation<? super SearchResponseList> continuation) {
        return search$suspendImpl(this, str, i, continuation);
    }

    public SuperStream(@Nullable SharedPreferences sharedPref) {
        this.name = "SuperStream";
        this.hasMainPage = true;
        this.instantLinkLoading = true;
        this.useMetaLoadResponse = true;
        this.hasQuickSearch = true;
        this.supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.TvSeries, TvType.Anime, TvType.Cartoon});
        this.token = sharedPref != null ? sharedPref.getString("token", null) : null;
        this.mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("/trending/all/day?api_key=98ae14df2b8d8f8f8136499daf79f0e0&region=US", "Trending"), TuplesKt.to("/movie/popular?api_key=98ae14df2b8d8f8f8136499daf79f0e0&region=US", "Popular Movies"), TuplesKt.to("/tv/popular?api_key=98ae14df2b8d8f8f8136499daf79f0e0&region=US&with_original_language=en", "Popular TV Shows"), TuplesKt.to("/tv/airing_today?api_key=98ae14df2b8d8f8f8136499daf79f0e0&region=US&with_original_language=en", "Airing Today TV Shows"), TuplesKt.to("/discover/tv?api_key=98ae14df2b8d8f8f8136499daf79f0e0&with_networks=213", "Netflix"), TuplesKt.to("/discover/tv?api_key=98ae14df2b8d8f8f8136499daf79f0e0&with_networks=1024", "Amazon"), TuplesKt.to("/discover/tv?api_key=98ae14df2b8d8f8f8136499daf79f0e0&with_networks=2739", "Disney+"), TuplesKt.to("/discover/tv?api_key=98ae14df2b8d8f8f8136499daf79f0e0&with_networks=453", "Hulu"), TuplesKt.to("/discover/tv?api_key=98ae14df2b8d8f8f8136499daf79f0e0&with_networks=2552", "Apple TV+"), TuplesKt.to("/discover/tv?api_key=98ae14df2b8d8f8f8136499daf79f0e0&with_networks=49", "HBO"), TuplesKt.to("/discover/tv?api_key=98ae14df2b8d8f8f8136499daf79f0e0&with_networks=4330", "Paramount+"), TuplesKt.to("/discover/tv?api_key=98ae14df2b8d8f8f8136499daf79f0e0&with_networks=3353", "Peacock"), TuplesKt.to("/discover/movie?api_key=98ae14df2b8d8f8f8136499daf79f0e0&language=en-US&page=1&sort_by=popularity.desc&with_origin_country=IN", "Indian Movies"), TuplesKt.to("/discover/tv?api_key=98ae14df2b8d8f8f8136499daf79f0e0&with_networks=4008", "JioCinema"), TuplesKt.to("/discover/tv?api_key=98ae14df2b8d8f8f8136499daf79f0e0&with_networks=5920", "Amazon MiniTV"), TuplesKt.to("/discover/tv?api_key=98ae14df2b8d8f8f8136499daf79f0e0&with_networks=1112", "Crunchyroll"), TuplesKt.to("/movie/top_rated?api_key=98ae14df2b8d8f8f8136499daf79f0e0&region=US", "Top Rated Movies"), TuplesKt.to("/tv/top_rated?api_key=98ae14df2b8d8f8f8136499daf79f0e0&region=US", "Top Rated TV Shows"), TuplesKt.to("/discover/tv?api_key=98ae14df2b8d8f8f8136499daf79f0e0&with_original_language=ko", "Korean Shows"), TuplesKt.to("/discover/tv?api_key=98ae14df2b8d8f8f8136499daf79f0e0&with_keywords=210024|222243&sort_by=popularity.desc&air_date.lte=" + getDate().getToday() + "&air_date.gte=" + getDate().getToday(), "Airing Today Anime"), TuplesKt.to("/discover/tv?api_key=98ae14df2b8d8f8f8136499daf79f0e0&with_keywords=210024|222243&sort_by=popularity.desc&air_date.lte=" + getDate().getNextWeek() + "&air_date.gte=" + getDate().getToday(), "On The Air Anime"), TuplesKt.to("/discover/tv?api_key=98ae14df2b8d8f8f8136499daf79f0e0&with_genres=16&sort_by=air_date.desc&air_date.lte=" + getDate().getNextWeek() + "&air_date.gte=" + getDate().getToday() + "&language=jp", "Recently Updated Anime"), TuplesKt.to("/discover/tv?api_key=98ae14df2b8d8f8f8136499daf79f0e0&with_keywords=210024|222243", "Anime"), TuplesKt.to("/discover/movie?api_key=98ae14df2b8d8f8f8136499daf79f0e0&with_keywords=210024|222243", "Anime Movies"), TuplesKt.to("Personal", "Personal Febbox Content")});
    }

    public /* synthetic */ SuperStream(SharedPreferences sharedPreferences, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : sharedPreferences);
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

    public boolean getInstantLinkLoading() {
        return this.instantLinkLoading;
    }

    public boolean getUseMetaLoadResponse() {
        return this.useMetaLoadResponse;
    }

    public boolean getHasQuickSearch() {
        return this.hasQuickSearch;
    }

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    @Nullable
    public final String getToken() {
        return this.token;
    }

    /* JADX INFO: compiled from: SuperStream.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u000bJ\u000e\u0010\f\u001a\u00020\rH\u0082@¢\u0006\u0002\u0010\u000bJ\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fH\u0082@¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0013\u001a\u00020\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/phisher98/SuperStream$Companion;", "", "<init>", "()V", "Cinemeta", "", "OFFICIAL_TMDB_URL", "REMOTE_PROXY_LIST", "apiKey", "febbox", "getApiBase", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isOfficialAvailable", "", "fetchProxyList", "", "getType", "Lcom/lagradost/cloudstream3/TvType;", "t", "getStatus", "Lcom/lagradost/cloudstream3/ShowStatus;", "SuperStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nSuperStream.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SuperStream.kt\ncom/phisher98/SuperStream$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,853:1\n1#2:854\n777#3:855\n873#3,2:856\n1739#3:858\n1814#3,3:859\n*S KotlinDebug\n*F\n+ 1 SuperStream.kt\ncom/phisher98/SuperStream$Companion\n*L\n119#1:855\n119#1:856,2\n120#1:858\n120#1:859,3\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Code duplicated, block: B:20:0x004e  */
        /* JADX WARN: Code duplicated, block: B:22:0x0057 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:25:0x0066  */
        /* JADX WARN: Code duplicated, block: B:28:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:29:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:7:0x0014  */
        @Nullable
        public final Object getApiBase(@NotNull Continuation<? super String> continuation) {
            SuperStream$Companion$getApiBase$1 superStream$Companion$getApiBase$1;
            Object objIsOfficialAvailable;
            Object objFetchProxyList;
            String proxy;
            if (continuation instanceof SuperStream$Companion$getApiBase$1) {
                superStream$Companion$getApiBase$1 = (SuperStream$Companion$getApiBase$1) continuation;
                if ((superStream$Companion$getApiBase$1.label & Integer.MIN_VALUE) != 0) {
                    superStream$Companion$getApiBase$1.label -= Integer.MIN_VALUE;
                } else {
                    superStream$Companion$getApiBase$1 = new SuperStream$Companion$getApiBase$1(this, continuation);
                }
            } else {
                superStream$Companion$getApiBase$1 = new SuperStream$Companion$getApiBase$1(this, continuation);
            }
            Object $result = superStream$Companion$getApiBase$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (superStream$Companion$getApiBase$1.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    superStream$Companion$getApiBase$1.label = 1;
                    objIsOfficialAvailable = isOfficialAvailable(superStream$Companion$getApiBase$1);
                    if (objIsOfficialAvailable == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    if (((Boolean) objIsOfficialAvailable).booleanValue()) {
                        return SuperStream.OFFICIAL_TMDB_URL;
                    }
                    superStream$Companion$getApiBase$1.label = 2;
                    objFetchProxyList = fetchProxyList(superStream$Companion$getApiBase$1);
                    if (objFetchProxyList == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    proxy = (String) CollectionsKt.randomOrNull((Collection) objFetchProxyList, Random.Default);
                    if (proxy == null) {
                        return SuperStream.OFFICIAL_TMDB_URL;
                    }
                    Log.INSTANCE.d("Error:", "Official unavailable, using proxy: " + proxy);
                    return proxy;
                case 1:
                    ResultKt.throwOnFailure($result);
                    objIsOfficialAvailable = $result;
                    if (((Boolean) objIsOfficialAvailable).booleanValue()) {
                        return SuperStream.OFFICIAL_TMDB_URL;
                    }
                    superStream$Companion$getApiBase$1.label = 2;
                    objFetchProxyList = fetchProxyList(superStream$Companion$getApiBase$1);
                    if (objFetchProxyList == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    proxy = (String) CollectionsKt.randomOrNull((Collection) objFetchProxyList, Random.Default);
                    if (proxy == null) {
                        return SuperStream.OFFICIAL_TMDB_URL;
                    }
                    Log.INSTANCE.d("Error:", "Official unavailable, using proxy: " + proxy);
                    return proxy;
                case 2:
                    ResultKt.throwOnFailure($result);
                    objFetchProxyList = $result;
                    proxy = (String) CollectionsKt.randomOrNull((Collection) objFetchProxyList, Random.Default);
                    if (proxy == null) {
                        return SuperStream.OFFICIAL_TMDB_URL;
                    }
                    Log.INSTANCE.d("Error:", "Official unavailable, using proxy: " + proxy);
                    return proxy;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code duplicated, block: B:7:0x0014  */
        public final Object isOfficialAvailable(Continuation<? super Boolean> continuation) {
            SuperStream$Companion$isOfficialAvailable$1 superStream$Companion$isOfficialAvailable$1;
            Object objWithTimeoutOrNull;
            if (continuation instanceof SuperStream$Companion$isOfficialAvailable$1) {
                superStream$Companion$isOfficialAvailable$1 = (SuperStream$Companion$isOfficialAvailable$1) continuation;
                if ((superStream$Companion$isOfficialAvailable$1.label & Integer.MIN_VALUE) != 0) {
                    superStream$Companion$isOfficialAvailable$1.label -= Integer.MIN_VALUE;
                } else {
                    superStream$Companion$isOfficialAvailable$1 = new SuperStream$Companion$isOfficialAvailable$1(this, continuation);
                }
            } else {
                superStream$Companion$isOfficialAvailable$1 = new SuperStream$Companion$isOfficialAvailable$1(this, continuation);
            }
            Object $result = superStream$Companion$isOfficialAvailable$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (superStream$Companion$isOfficialAvailable$1.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    SuperStream$Companion$isOfficialAvailable$2 superStream$Companion$isOfficialAvailable$2 = new SuperStream$Companion$isOfficialAvailable$2(null);
                    superStream$Companion$isOfficialAvailable$1.label = 1;
                    objWithTimeoutOrNull = TimeoutKt.withTimeoutOrNull(5000L, superStream$Companion$isOfficialAvailable$2, superStream$Companion$isOfficialAvailable$1);
                    if (objWithTimeoutOrNull == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    objWithTimeoutOrNull = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Boolean bool = (Boolean) objWithTimeoutOrNull;
            return Boxing.boxBoolean(bool != null ? bool.booleanValue() : false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code duplicated, block: B:26:0x009e A[Catch: Exception -> 0x0126, LOOP:0: B:25:0x009c->B:26:0x009e, LOOP_END, TryCatch #3 {Exception -> 0x0126, blocks: (B:24:0x0080, B:26:0x009e, B:27:0x00b4, B:28:0x00c7, B:30:0x00cd, B:35:0x00e3, B:36:0x00e7, B:37:0x0103, B:39:0x0109, B:40:0x011e, B:21:0x0079), top: B:56:0x0079 }] */
        /* JADX WARN: Code duplicated, block: B:30:0x00cd A[Catch: Exception -> 0x0126, TryCatch #3 {Exception -> 0x0126, blocks: (B:24:0x0080, B:26:0x009e, B:27:0x00b4, B:28:0x00c7, B:30:0x00cd, B:35:0x00e3, B:36:0x00e7, B:37:0x0103, B:39:0x0109, B:40:0x011e, B:21:0x0079), top: B:56:0x0079 }] */
        /* JADX WARN: Code duplicated, block: B:32:0x00de  */
        /* JADX WARN: Code duplicated, block: B:33:0x00e0  */
        /* JADX WARN: Code duplicated, block: B:39:0x0109 A[Catch: Exception -> 0x0126, LOOP:2: B:37:0x0103->B:39:0x0109, LOOP_END, TryCatch #3 {Exception -> 0x0126, blocks: (B:24:0x0080, B:26:0x009e, B:27:0x00b4, B:28:0x00c7, B:30:0x00cd, B:35:0x00e3, B:36:0x00e7, B:37:0x0103, B:39:0x0109, B:40:0x011e, B:21:0x0079), top: B:56:0x0079 }] */
        /* JADX WARN: Code duplicated, block: B:59:0x00e3 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:62:0x00c7 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:7:0x0018  */
        public final Object fetchProxyList(Continuation<? super List<String>> continuation) {
            SuperStream$Companion$fetchProxyList$1 superStream$Companion$fetchProxyList$1;
            JSONArray arr;
            int length;
            ArrayList arrayList;
            int i;
            Collection destination$iv$iv;
            Collection destination$iv$iv2;
            String it;
            boolean z;
            if (continuation instanceof SuperStream$Companion$fetchProxyList$1) {
                superStream$Companion$fetchProxyList$1 = (SuperStream$Companion$fetchProxyList$1) continuation;
                if ((superStream$Companion$fetchProxyList$1.label & Integer.MIN_VALUE) != 0) {
                    superStream$Companion$fetchProxyList$1.label -= Integer.MIN_VALUE;
                } else {
                    superStream$Companion$fetchProxyList$1 = new SuperStream$Companion$fetchProxyList$1(this, continuation);
                }
            } else {
                superStream$Companion$fetchProxyList$1 = new SuperStream$Companion$fetchProxyList$1(this, continuation);
            }
            SuperStream$Companion$fetchProxyList$1 superStream$Companion$fetchProxyList$2 = superStream$Companion$fetchProxyList$1;
            Object $result = superStream$Companion$fetchProxyList$2.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (superStream$Companion$fetchProxyList$2.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    try {
                        Requests app = MainActivityKt.getApp();
                        try {
                            superStream$Companion$fetchProxyList$2.label = 1;
                            try {
                                $result = Requests.get$default(app, SuperStream.REMOTE_PROXY_LIST, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, superStream$Companion$fetchProxyList$2, 4094, (Object) null);
                                if ($result == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                String response = ((NiceResponse) $result).getText();
                                JSONObject json = new JSONObject(response);
                                arr = json.getJSONArray("proxies");
                                length = arr.length();
                                arrayList = new ArrayList(length);
                                for (i = 0; i < length; i++) {
                                    int it2 = i;
                                    arrayList.add(StringsKt.trim(arr.getString(it2)).toString());
                                }
                                ArrayList $this$filter$iv = arrayList;
                                destination$iv$iv = new ArrayList();
                                for (Object element$iv$iv : $this$filter$iv) {
                                    it = (String) element$iv$iv;
                                    if (it.length() > 0) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    if (z) {
                                        destination$iv$iv.add(element$iv$iv);
                                    }
                                }
                                Iterable $this$map$iv = (List) destination$iv$iv;
                                destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                for (Object item$iv$iv : $this$map$iv) {
                                    String proxyUrl = (String) item$iv$iv;
                                    String clean = StringsKt.removeSuffix(proxyUrl, "/");
                                    destination$iv$iv2.add(clean);
                                }
                                return (List) destination$iv$iv2;
                            } catch (Exception e) {
                                Log.INSTANCE.e("Error:", "Error fetching proxy list");
                                return CollectionsKt.emptyList();
                            }
                        } catch (Exception e2) {
                            Log.INSTANCE.e("Error:", "Error fetching proxy list");
                            return CollectionsKt.emptyList();
                        }
                    } catch (Exception e3) {
                    }
                    break;
                case 1:
                    try {
                        ResultKt.throwOnFailure($result);
                        String response2 = ((NiceResponse) $result).getText();
                        JSONObject json2 = new JSONObject(response2);
                        arr = json2.getJSONArray("proxies");
                        length = arr.length();
                        arrayList = new ArrayList(length);
                        while (i < length) {
                            int it3 = i;
                            arrayList.add(StringsKt.trim(arr.getString(it3)).toString());
                        }
                        ArrayList $this$filter$iv2 = arrayList;
                        destination$iv$iv = new ArrayList();
                        while (r11.hasNext()) {
                            it = (String) element$iv$iv;
                            if (it.length() > 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                destination$iv$iv.add(element$iv$iv);
                            }
                        }
                        Iterable $this$map$iv2 = (List) destination$iv$iv;
                        destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                        while (r10.hasNext()) {
                            String proxyUrl2 = (String) item$iv$iv;
                            String clean2 = StringsKt.removeSuffix(proxyUrl2, "/");
                            destination$iv$iv2.add(clean2);
                        }
                        return (List) destination$iv$iv2;
                    } catch (Exception e4) {
                        Log.INSTANCE.e("Error:", "Error fetching proxy list");
                        return CollectionsKt.emptyList();
                    }
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
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

    /* JADX WARN: Code duplicated, block: B:51:0x0226  */
    /* JADX WARN: Code duplicated, block: B:53:0x028b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:54:0x028c  */
    /* JADX WARN: Code duplicated, block: B:57:0x02a8  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x028c -> B:55:0x02a4). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    static /* synthetic */ java.lang.Object getMainPage$suspendImpl(com.phisher98.SuperStream r28, int r29, com.lagradost.cloudstream3.MainPageRequest r30, kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.HomePageResponse> r31) {
        /*
            Method dump skipped, instruction units count: 1056
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.SuperStream.getMainPage$suspendImpl(com.phisher98.SuperStream, int, com.lagradost.cloudstream3.MainPageRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ SearchResponse toSearchResponse$default(SuperStream superStream, Media media, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toSearchResponse");
        }
        if ((i & 1) != 0) {
            str = null;
        }
        return superStream.toSearchResponse(media, str);
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
        return MainAPIKt.newMovieSearchResponse$default(mainAPI, title, appUtils.toJson(new Data(id, mediaType, null, null, 12, null)), TvType.Movie, false, new Function1() { // from class: com.phisher98.SuperStream$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return SuperStream.toSearchResponse$lambda$0(this.f$0, $this$toSearchResponse, (MovieSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResponse$lambda$0(SuperStream this$0, Media $this_toSearchResponse, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl(this$0.getImageUrl($this_toSearchResponse.getPosterPath()));
        $this$newMovieSearchResponse.setScore(Score.Companion.from10($this_toSearchResponse.getVoteAverage()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    public final Object toSearchResponse(Element $this$toSearchResponse, Continuation<? super SearchResponse> continuation) {
        C00142 c00142;
        String poster;
        Object obj;
        String poster2;
        boolean isDir;
        String fid;
        Element elementSelectFirst;
        Element elementSelectFirst2;
        Object safe;
        String thumb;
        FebboxFile file;
        FebboxFile file2;
        FebboxFile file3;
        if (continuation instanceof C00142) {
            c00142 = (C00142) continuation;
            if ((c00142.label & Integer.MIN_VALUE) != 0) {
                c00142.label -= Integer.MIN_VALUE;
            } else {
                c00142 = new C00142(continuation);
            }
        } else {
            c00142 = new C00142(continuation);
        }
        Object $result = c00142.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        String thumb_small = null;
        switch (c00142.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String title = $this$toSearchResponse.select("p.file_name_show").text();
                String poster3 = $this$toSearchResponse.select("div.file_icon img").attr("src");
                String fid2 = $this$toSearchResponse.select("div").attr("data-id");
                if (StringsKt.isBlank(fid2)) {
                    Element elementParent = $this$toSearchResponse.parent();
                    String strAttr = (elementParent == null || (elementSelectFirst2 = elementParent.selectFirst("td[data-id]")) == null) ? null : elementSelectFirst2.attr("data-id");
                    if (strAttr == null) {
                        strAttr = "";
                    }
                    fid2 = strAttr;
                }
                if (StringsKt.isBlank(fid2)) {
                    return null;
                }
                Element elementParent2 = $this$toSearchResponse.parent();
                boolean isDir2 = Intrinsics.areEqual((elementParent2 == null || (elementSelectFirst = elementParent2.selectFirst("td[data-id]")) == null) ? null : elementSelectFirst.attr("data-is-dir"), "1");
                String href = "https://www.febbox.com/console/share_file_comment?fid=" + fid2;
                Requests app = MainActivityKt.getApp();
                String str = this.token;
                Map mapMapOf = MapsKt.mapOf(TuplesKt.to("cookie", str != null ? str : ""));
                c00142.L$0 = SpillingKt.nullOutSpilledVariable($this$toSearchResponse);
                c00142.L$1 = title;
                c00142.L$2 = poster3;
                c00142.L$3 = SpillingKt.nullOutSpilledVariable(fid2);
                c00142.L$4 = href;
                c00142.Z$0 = isDir2;
                c00142.label = 1;
                poster = poster3;
                Object obj2 = Requests.get$default(app, href, mapMapOf, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00142, 4092, (Object) null);
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = obj2;
                poster2 = href;
                isDir = isDir2;
                fid = title;
                break;
            case 1:
                isDir = c00142.Z$0;
                String href2 = (String) c00142.L$4;
                String poster4 = (String) c00142.L$2;
                String title2 = (String) c00142.L$1;
                ResultKt.throwOnFailure($result);
                poster = poster4;
                fid = title2;
                obj = $result;
                poster2 = href2;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NiceResponse this_$iv = (NiceResponse) obj;
        try {
            ResponseParser parser = this_$iv.getParser();
            Intrinsics.checkNotNull(parser);
            safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(FebboxPosterResponse.class));
        } catch (Exception e$iv) {
            e$iv.printStackTrace();
            safe = null;
        }
        FebboxPosterResponse posterRes = (FebboxPosterResponse) safe;
        if (posterRes == null || (file3 = posterRes.getFile()) == null || (thumb = file3.getThumb_big()) == null) {
            thumb = (posterRes == null || (file2 = posterRes.getFile()) == null) ? null : file2.getThumb();
            if (thumb == null) {
                if (posterRes != null && (file = posterRes.getFile()) != null) {
                    thumb_small = file.getThumb_small();
                }
                thumb = thumb_small == null ? poster : thumb_small;
            }
        }
        final String finalPoster = thumb;
        return isDir ? MainAPIKt.newTvSeriesSearchResponse$default((MainAPI) this, fid, poster2, TvType.TvSeries, false, new Function1() { // from class: com.phisher98.SuperStream$$ExternalSyntheticLambda0
            public final Object invoke(Object obj3) {
                return SuperStream.toSearchResponse$lambda$1(finalPoster, (TvSeriesSearchResponse) obj3);
            }
        }, 8, (Object) null) : MainAPIKt.newMovieSearchResponse$default((MainAPI) this, fid, poster2, TvType.Movie, false, new Function1() { // from class: com.phisher98.SuperStream$$ExternalSyntheticLambda1
            public final Object invoke(Object obj3) {
                return SuperStream.toSearchResponse$lambda$2(finalPoster, (MovieSearchResponse) obj3);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResponse$lambda$1(String $finalPoster, TvSeriesSearchResponse $this$newTvSeriesSearchResponse) {
        String str = $finalPoster;
        if (str.length() == 0) {
            str = "https://www.febbox.com/static/index_img/file_type/dir_icon2.png";
        }
        $this$newTvSeriesSearchResponse.setPosterUrl(str);
        return Unit.INSTANCE;
    }

    static final Unit toSearchResponse$lambda$2(String $finalPoster, MovieSearchResponse $this$newMovieSearchResponse) {
        String str = $finalPoster;
        if (str.length() == 0) {
            str = "https://www.febbox.com/static/index_img/file_type/dir_icon2.png";
        }
        $this$newMovieSearchResponse.setPosterUrl(str);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    static /* synthetic */ Object quickSearch$suspendImpl(SuperStream $this, String query, Continuation<? super List<? extends SearchResponse>> continuation) {
        C00121 c00121;
        Object objSearch;
        if (continuation instanceof C00121) {
            c00121 = (C00121) continuation;
            if ((c00121.label & Integer.MIN_VALUE) != 0) {
                c00121.label -= Integer.MIN_VALUE;
            } else {
                c00121 = $this.new C00121(continuation);
            }
        } else {
            c00121 = $this.new C00121(continuation);
        }
        Object $result = c00121.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00121.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                c00121.L$0 = SpillingKt.nullOutSpilledVariable($this);
                c00121.L$1 = SpillingKt.nullOutSpilledVariable(query);
                c00121.label = 1;
                objSearch = $this.search(query, 1, c00121);
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

    /* JADX WARN: Code duplicated, block: B:20:0x0108 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:21:0x0109  */
    /* JADX WARN: Code duplicated, block: B:29:0x0137  */
    /* JADX WARN: Code duplicated, block: B:45:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    static /* synthetic */ Object search$suspendImpl(SuperStream $this, String query, int page, Continuation<? super SearchResponseList> continuation) {
        C00131 c00131;
        Object obj;
        String query2;
        int page2;
        SuperStream $this2;
        Object safe;
        Results results;
        Iterable results2;
        SuperStream $this3 = $this;
        if (continuation instanceof C00131) {
            c00131 = (C00131) continuation;
            if ((c00131.label & Integer.MIN_VALUE) != 0) {
                c00131.label -= Integer.MIN_VALUE;
            } else {
                c00131 = $this3.new C00131(continuation);
            }
        } else {
            c00131 = $this3.new C00131(continuation);
        }
        Object $result = c00131.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00131.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Companion companion = INSTANCE;
                c00131.L$0 = $this3;
                c00131.L$1 = query;
                c00131.I$0 = page;
                c00131.label = 1;
                Object apiBase = companion.getApiBase(c00131);
                if (apiBase == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = apiBase;
                query2 = query;
                page2 = page;
                String tmdbAPI = (String) obj;
                Requests app = MainActivityKt.getApp();
                String str = tmdbAPI + "/search/multi?api_key=98ae14df2b8d8f8f8136499daf79f0e0&language=en-US&query=" + query2 + "&page=" + page2 + "&include_adult=" + MainAPI.Companion.getSettingsForProvider().getEnableAdult();
                c00131.L$0 = $this3;
                c00131.L$1 = SpillingKt.nullOutSpilledVariable(query2);
                c00131.L$2 = SpillingKt.nullOutSpilledVariable(tmdbAPI);
                c00131.I$0 = page2;
                c00131.label = 2;
                $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00131, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $this2 = $this3;
                NiceResponse this_$iv = (NiceResponse) $result;
                try {
                    ResponseParser parser = this_$iv.getParser();
                    Intrinsics.checkNotNull(parser);
                    safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(Results.class));
                    break;
                } catch (Exception e$iv) {
                    e$iv.printStackTrace();
                    safe = null;
                }
                results = (Results) safe;
                if (results != null || (results2 = results.getResults()) == null) {
                    return null;
                }
                Iterable $this$mapNotNull$iv = results2;
                int $i$f$mapNotNull = 0;
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                    Media media = (Media) element$iv$iv$iv;
                    int $i$f$mapNotNull2 = $i$f$mapNotNull;
                    SearchResponse searchResponse$default = toSearchResponse$default($this2, media, null, 1, null);
                    if (searchResponse$default != null) {
                        destination$iv$iv.add(searchResponse$default);
                    }
                    $i$f$mapNotNull = $i$f$mapNotNull2;
                }
                return MainAPIKt.toNewSearchResponseList$default((List) destination$iv$iv, (Boolean) null, 1, (Object) null);
            case 1:
                int page3 = c00131.I$0;
                String query3 = (String) c00131.L$1;
                $this3 = (SuperStream) c00131.L$0;
                ResultKt.throwOnFailure($result);
                page2 = page3;
                query2 = query3;
                obj = $result;
                String tmdbAPI2 = (String) obj;
                Requests app2 = MainActivityKt.getApp();
                String str2 = tmdbAPI2 + "/search/multi?api_key=98ae14df2b8d8f8f8136499daf79f0e0&language=en-US&query=" + query2 + "&page=" + page2 + "&include_adult=" + MainAPI.Companion.getSettingsForProvider().getEnableAdult();
                c00131.L$0 = $this3;
                c00131.L$1 = SpillingKt.nullOutSpilledVariable(query2);
                c00131.L$2 = SpillingKt.nullOutSpilledVariable(tmdbAPI2);
                c00131.I$0 = page2;
                c00131.label = 2;
                $result = Requests.get$default(app2, str2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00131, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $this2 = $this3;
                NiceResponse this_$iv2 = (NiceResponse) $result;
                ResponseParser parser2 = this_$iv2.getParser();
                Intrinsics.checkNotNull(parser2);
                safe = parser2.parseSafe(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(Results.class));
                results = (Results) safe;
                if (results != null) {
                    return null;
                }
                return null;
            case 2:
                int i = c00131.I$0;
                SuperStream $this4 = (SuperStream) c00131.L$0;
                ResultKt.throwOnFailure($result);
                $this2 = $this4;
                NiceResponse this_$iv3 = (NiceResponse) $result;
                ResponseParser parser3 = this_$iv3.getParser();
                Intrinsics.checkNotNull(parser3);
                safe = parser3.parseSafe(this_$iv3.getText(), Reflection.getOrCreateKotlinClass(Results.class));
                results = (Results) safe;
                if (results != null) {
                    return null;
                }
                return null;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:335:0x0e7c  */
    /* JADX WARN: Code duplicated, block: B:337:0x0f83 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:338:0x0f84  */
    /* JADX WARN: Code duplicated, block: B:355:0x0fed  */
    /* JADX WARN: Code duplicated, block: B:395:0x10f2  */
    /* JADX WARN: Code duplicated, block: B:398:0x1107  */
    /* JADX WARN: Code duplicated, block: B:399:0x110a  */
    /* JADX WARN: Code duplicated, block: B:401:0x110e  */
    /* JADX WARN: Code duplicated, block: B:402:0x1111  */
    /* JADX WARN: Code duplicated, block: B:404:0x1115  */
    /* JADX WARN: Code duplicated, block: B:405:0x1118  */
    /* JADX WARN: Code duplicated, block: B:407:0x111c  */
    /* JADX WARN: Code duplicated, block: B:408:0x111f  */
    /* JADX WARN: Code duplicated, block: B:411:0x1176  */
    /* JADX WARN: Code duplicated, block: B:414:0x1185  */
    /* JADX WARN: Code duplicated, block: B:635:0x0745 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:95:0x0741  */
    /* JADX WARN: Type inference failed for: r0v71, types: [java.lang.Throwable] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:338:0x0f84 -> B:339:0x0fb7). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    static /* synthetic */ java.lang.Object load$suspendImpl(com.phisher98.SuperStream r90, java.lang.String r91, kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r92) {
        /*
            Method dump skipped, instruction units count: 6606
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.SuperStream.load$suspendImpl(com.phisher98.SuperStream, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$0$0(String $name, int $index, String $thumb, Episode $this$newEpisode) {
        $this$newEpisode.setName($name);
        $this$newEpisode.setEpisode(Integer.valueOf($index + 1));
        $this$newEpisode.setPosterUrl($thumb);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.phisher98.SuperStream$load$2 */
    /* JADX INFO: compiled from: SuperStream.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.SuperStream$load$2", f = "SuperStream.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nSuperStream.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SuperStream.kt\ncom/phisher98/SuperStream$load$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,853:1\n1#2:854\n*E\n"})
    static final class C00032 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ FileData $media;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00032(FileData fileData, Continuation<? super C00032> continuation) {
            super(2, continuation);
            this.$media = fileData;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00032 = new C00032(this.$media, continuation);
            c00032.L$0 = obj;
            return c00032;
        }

        public final Object invoke(TvSeriesLoadResponse tvSeriesLoadResponse, Continuation<? super Unit> continuation) {
            return create(tvSeriesLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            String str;
            TvSeriesLoadResponse $this$newTvSeriesLoadResponse = (TvSeriesLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String thumb_big = this.$media.getThumb_big();
                    if (thumb_big != null) {
                        String str2 = thumb_big;
                        if (str2.length() == 0) {
                            str2 = "https://wallpapers.com/images/hd/netflix-background-gs7hjuwvv2g0e9fj.jpg";
                        }
                        str = str2;
                    } else {
                        str = null;
                    }
                    $this$newTvSeriesLoadResponse.setPosterUrl(str);
                    $this$newTvSeriesLoadResponse.setPlot("Added: " + this.$media.getAdd_time() + " | Updated: " + this.$media.getUpdate_time());
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.phisher98.SuperStream$load$3 */
    /* JADX INFO: compiled from: SuperStream.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.SuperStream$load$3", f = "SuperStream.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nSuperStream.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SuperStream.kt\ncom/phisher98/SuperStream$load$3\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,853:1\n1#2:854\n*E\n"})
    static final class C00043 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ FileData $media;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00043(FileData fileData, Continuation<? super C00043> continuation) {
            super(2, continuation);
            this.$media = fileData;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00043 = new C00043(this.$media, continuation);
            c00043.L$0 = obj;
            return c00043;
        }

        public final Object invoke(MovieLoadResponse movieLoadResponse, Continuation<? super Unit> continuation) {
            return create(movieLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            String str;
            MovieLoadResponse $this$newMovieLoadResponse = (MovieLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String thumb_big = this.$media.getThumb_big();
                    if (thumb_big != null) {
                        String str2 = thumb_big;
                        if (str2.length() == 0) {
                            str2 = "https://wallpapers.com/images/hd/netflix-background-gs7hjuwvv2g0e9fj.jpg";
                        }
                        str = str2;
                    } else {
                        str = null;
                    }
                    $this$newMovieLoadResponse.setPosterUrl(str);
                    $this$newMovieLoadResponse.setPlot("Added: " + this.$media.getAdd_time() + " | Updated: " + this.$media.getUpdate_time() + " | Size: " + this.$media.getFile_size());
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$10$0$1(Episodes $eps, SuperStream this$0, Episode $this$newEpisode) {
        $this$newEpisode.setName($eps.getName() + (this$0.isUpcoming($eps.getAirDate()) ? " • [UPCOMING]" : ""));
        $this$newEpisode.setSeason($eps.getSeasonNumber());
        $this$newEpisode.setEpisode($eps.getEpisodeNumber());
        $this$newEpisode.setPosterUrl(this$0.getImageUrl($eps.getStillPath()));
        $this$newEpisode.setScore(Score.Companion.from10($eps.getVoteAverage()));
        $this$newEpisode.setDescription($eps.getOverview());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$13$1(CinemetaRes.Meta.Video $video, SuperStream this$0, Episode $this$newEpisode) {
        $this$newEpisode.setName($video.getName() + (this$0.isUpcoming($video.getReleased()) ? " • [UPCOMING]" : ""));
        $this$newEpisode.setSeason(Integer.valueOf($video.getSeason()));
        $this$newEpisode.setEpisode(Integer.valueOf($video.getNumber()));
        $this$newEpisode.setPosterUrl($video.getThumbnail());
        $this$newEpisode.setScore(Score.Companion.from10($video.getRating()));
        $this$newEpisode.setDescription($video.getDescription());
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.phisher98.SuperStream$load$4 */
    /* JADX INFO: compiled from: SuperStream.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/AnimeLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.SuperStream$load$4", f = "SuperStream.kt", i = {0}, l = {494}, m = "invokeSuspend", n = {"$this$newAnimeLoadResponse"}, nl = {495}, s = {"L$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nSuperStream.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SuperStream.kt\ncom/phisher98/SuperStream$load$4\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,853:1\n1739#2:854\n1814#2,2:855\n1816#2:858\n1#3:857\n*S KotlinDebug\n*F\n+ 1 SuperStream.kt\ncom/phisher98/SuperStream$load$4\n*L\n488#1:854\n488#1:855,2\n488#1:858\n*E\n"})
    static final class C00054 extends SuspendLambda implements Function2<AnimeLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<ActorData> $actors;
        final /* synthetic */ List<Episode> $animeepisodes;
        final /* synthetic */ String $bgPoster;
        final /* synthetic */ Data $data;
        final /* synthetic */ List<String> $genres;
        final /* synthetic */ List<String> $keywords;
        final /* synthetic */ String $poster;
        final /* synthetic */ String $rating;
        final /* synthetic */ List<SearchResponse> $recommendations;
        final /* synthetic */ MediaDetail $res;
        final /* synthetic */ List<String> $trailer;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00054(List<Episode> list, String str, String str2, Integer num, MediaDetail mediaDetail, List<String> list2, List<String> list3, String str3, List<? extends SearchResponse> list4, List<ActorData> list5, List<String> list6, Data data, Continuation<? super C00054> continuation) {
            super(2, continuation);
            this.$animeepisodes = list;
            this.$poster = str;
            this.$bgPoster = str2;
            this.$year = num;
            this.$res = mediaDetail;
            this.$keywords = list2;
            this.$genres = list3;
            this.$rating = str3;
            this.$recommendations = list4;
            this.$actors = list5;
            this.$trailer = list6;
            this.$data = data;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00054 = new C00054(this.$animeepisodes, this.$poster, this.$bgPoster, this.$year, this.$res, this.$keywords, this.$genres, this.$rating, this.$recommendations, this.$actors, this.$trailer, this.$data, continuation);
            c00054.L$0 = obj;
            return c00054;
        }

        public final Object invoke(AnimeLoadResponse animeLoadResponse, Continuation<? super Unit> continuation) {
            return create(animeLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:25:0x00be  */
        public final Object invokeSuspend(Object $result) {
            List<String> list;
            String string;
            LoadResponse loadResponse = (AnimeLoadResponse) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    MainAPIKt.addEpisodes(loadResponse, DubStatus.Subbed, this.$animeepisodes);
                    loadResponse.setPosterUrl(this.$poster);
                    loadResponse.setBackgroundPosterUrl(this.$bgPoster);
                    loadResponse.setYear(this.$year);
                    loadResponse.setPlot(this.$res.getOverview());
                    Iterable iterable = this.$keywords;
                    if (iterable != null) {
                        Iterable $this$map$iv = iterable;
                        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                        for (Object item$iv$iv : $this$map$iv) {
                            String it = (String) item$iv$iv;
                            if (it.length() > 0) {
                                StringBuilder sbAppend = new StringBuilder().append((Object) CharsKt.titlecase(it.charAt(0)));
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
                    loadResponse.setScore(Score.Companion.from10(this.$rating));
                    loadResponse.setShowStatus(SuperStream.INSTANCE.getStatus(this.$res.getStatus()));
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

    /* JADX INFO: renamed from: com.phisher98.SuperStream$load$5 */
    /* JADX INFO: compiled from: SuperStream.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.SuperStream$load$5", f = "SuperStream.kt", i = {0}, l = {510}, m = "invokeSuspend", n = {"$this$newTvSeriesLoadResponse"}, nl = {511}, s = {"L$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nSuperStream.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SuperStream.kt\ncom/phisher98/SuperStream$load$5\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,853:1\n1739#2:854\n1814#2,2:855\n1816#2:858\n1#3:857\n*S KotlinDebug\n*F\n+ 1 SuperStream.kt\ncom/phisher98/SuperStream$load$5\n*L\n504#1:854\n504#1:855,2\n504#1:858\n*E\n"})
    static final class C00065 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<ActorData> $actors;
        final /* synthetic */ String $bgPoster;
        final /* synthetic */ Data $data;
        final /* synthetic */ List<String> $genres;
        final /* synthetic */ List<String> $keywords;
        final /* synthetic */ String $poster;
        final /* synthetic */ String $rating;
        final /* synthetic */ List<SearchResponse> $recommendations;
        final /* synthetic */ MediaDetail $res;
        final /* synthetic */ List<String> $trailer;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00065(String str, String str2, Integer num, MediaDetail mediaDetail, List<String> list, List<String> list2, String str3, List<? extends SearchResponse> list3, List<ActorData> list4, List<String> list5, Data data, Continuation<? super C00065> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$bgPoster = str2;
            this.$year = num;
            this.$res = mediaDetail;
            this.$keywords = list;
            this.$genres = list2;
            this.$rating = str3;
            this.$recommendations = list3;
            this.$actors = list4;
            this.$trailer = list5;
            this.$data = data;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00065 = new C00065(this.$poster, this.$bgPoster, this.$year, this.$res, this.$keywords, this.$genres, this.$rating, this.$recommendations, this.$actors, this.$trailer, this.$data, continuation);
            c00065.L$0 = obj;
            return c00065;
        }

        public final Object invoke(TvSeriesLoadResponse tvSeriesLoadResponse, Continuation<? super Unit> continuation) {
            return create(tvSeriesLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:25:0x00b7  */
        public final Object invokeSuspend(Object $result) {
            List<String> list;
            String string;
            LoadResponse loadResponse = (TvSeriesLoadResponse) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    loadResponse.setPosterUrl(this.$poster);
                    loadResponse.setBackgroundPosterUrl(this.$bgPoster);
                    loadResponse.setYear(this.$year);
                    loadResponse.setPlot(this.$res.getOverview());
                    Iterable iterable = this.$keywords;
                    if (iterable != null) {
                        Iterable $this$map$iv = iterable;
                        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                        for (Object item$iv$iv : $this$map$iv) {
                            String word = (String) item$iv$iv;
                            if (word.length() > 0) {
                                StringBuilder sb = new StringBuilder();
                                char it = word.charAt(0);
                                StringBuilder sbAppend = sb.append((Object) CharsKt.titlecase(it));
                                String strSubstring = word.substring(1);
                                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                                string = sbAppend.append(strSubstring).toString();
                            } else {
                                string = word;
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
                    loadResponse.setScore(Score.Companion.from10(this.$rating));
                    loadResponse.setShowStatus(SuperStream.INSTANCE.getStatus(this.$res.getStatus()));
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

    /* JADX INFO: renamed from: com.phisher98.SuperStream$load$7 */
    /* JADX INFO: compiled from: SuperStream.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.SuperStream$load$7", f = "SuperStream.kt", i = {0}, l = {549}, m = "invokeSuspend", n = {"$this$newMovieLoadResponse"}, nl = {550}, s = {"L$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nSuperStream.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SuperStream.kt\ncom/phisher98/SuperStream$load$7\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,853:1\n1739#2:854\n1814#2,2:855\n1816#2:858\n1#3:857\n*S KotlinDebug\n*F\n+ 1 SuperStream.kt\ncom/phisher98/SuperStream$load$7\n*L\n543#1:854\n543#1:855,2\n543#1:858\n*E\n"})
    static final class C00077 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<ActorData> $actors;
        final /* synthetic */ String $bgPoster;
        final /* synthetic */ Data $data;
        final /* synthetic */ List<String> $genres;
        final /* synthetic */ List<String> $keywords;
        final /* synthetic */ String $poster;
        final /* synthetic */ String $rating;
        final /* synthetic */ List<SearchResponse> $recommendations;
        final /* synthetic */ String $releaseDate;
        final /* synthetic */ MediaDetail $res;
        final /* synthetic */ List<String> $trailer;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ SuperStream this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00077(String str, String str2, SuperStream superStream, String str3, Integer num, MediaDetail mediaDetail, List<String> list, List<String> list2, String str4, List<? extends SearchResponse> list3, List<ActorData> list4, List<String> list5, Data data, Continuation<? super C00077> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$bgPoster = str2;
            this.this$0 = superStream;
            this.$releaseDate = str3;
            this.$year = num;
            this.$res = mediaDetail;
            this.$keywords = list;
            this.$genres = list2;
            this.$rating = str4;
            this.$recommendations = list3;
            this.$actors = list4;
            this.$trailer = list5;
            this.$data = data;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00077 = new C00077(this.$poster, this.$bgPoster, this.this$0, this.$releaseDate, this.$year, this.$res, this.$keywords, this.$genres, this.$rating, this.$recommendations, this.$actors, this.$trailer, this.$data, continuation);
            c00077.L$0 = obj;
            return c00077;
        }

        public final Object invoke(MovieLoadResponse movieLoadResponse, Continuation<? super Unit> continuation) {
            return create(movieLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:25:0x00cb  */
        public final Object invokeSuspend(Object $result) {
            List<String> list;
            String string;
            LoadResponse loadResponse = (MovieLoadResponse) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    loadResponse.setPosterUrl(this.$poster);
                    loadResponse.setBackgroundPosterUrl(this.$bgPoster);
                    loadResponse.setComingSoon(this.this$0.isUpcoming(this.$releaseDate));
                    loadResponse.setYear(this.$year);
                    loadResponse.setPlot(this.$res.getOverview());
                    loadResponse.setDuration(this.$res.getRuntime());
                    Iterable iterable = this.$keywords;
                    if (iterable != null) {
                        Iterable $this$map$iv = iterable;
                        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                        for (Object item$iv$iv : $this$map$iv) {
                            String word = (String) item$iv$iv;
                            if (word.length() > 0) {
                                StringBuilder sb = new StringBuilder();
                                char it = word.charAt(0);
                                StringBuilder sbAppend = sb.append((Object) CharsKt.titlecase(it));
                                String strSubstring = word.substring(1);
                                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                                string = sbAppend.append(strSubstring).toString();
                            } else {
                                string = word;
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
                    loadResponse.setScore(Score.Companion.from10(this.$rating));
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

    /* JADX WARN: Code duplicated, block: B:139:0x02db A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:29:0x02b6  */
    /* JADX WARN: Code duplicated, block: B:31:0x02bf  */
    /* JADX WARN: Code duplicated, block: B:32:0x02ce  */
    /* JADX WARN: Code duplicated, block: B:37:0x0377 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:38:0x0378  */
    /* JADX WARN: Code duplicated, block: B:40:0x039c A[LOOP:0: B:27:0x02b0->B:40:0x039c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:7:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0378 -> B:39:0x038e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @android.annotation.SuppressLint({"SuspiciousIndentation"})
    static /* synthetic */ java.lang.Object loadLinks$suspendImpl(com.phisher98.SuperStream r55, java.lang.String r56, boolean r57, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r58, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r59, kotlin.coroutines.Continuation<? super java.lang.Boolean> r60) {
        /*
            Method dump skipped, instruction units count: 1658
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.SuperStream.loadLinks$suspendImpl(com.phisher98.SuperStream, java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.phisher98.SuperStream$loadLinks$2 */
    /* JADX INFO: compiled from: SuperStream.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.SuperStream$loadLinks$2", f = "SuperStream.kt", i = {}, l = {627}, m = "invokeSuspend", n = {}, nl = {633}, s = {}, v = 2)
    static final class C00092 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ LinkData $res;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00092(LinkData linkData, Function1<? super SubtitleFile, Unit> function1, Continuation<? super C00092> continuation) {
            super(1, continuation);
            this.$res = linkData;
            this.$subtitleCallback = function1;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00092(this.$res, this.$subtitleCallback, continuation);
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
                    if (SuperStreamExtractor.INSTANCE.invokeSubtitleAPI(this.$res.getImdbId(), this.$res.getSeason(), this.$res.getEpisode(), this.$subtitleCallback, (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.phisher98.SuperStream$loadLinks$3 */
    /* JADX INFO: compiled from: SuperStream.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.SuperStream$loadLinks$3", f = "SuperStream.kt", i = {}, l = {637}, m = "invokeSuspend", n = {}, nl = {645}, s = {}, v = 2)
    static final class C00103 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ LinkData $res;
        int label;
        final /* synthetic */ SuperStream this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00103(LinkData linkData, SuperStream superStream, Function1<? super ExtractorLink, Unit> function1, Continuation<? super C00103> continuation) {
            super(1, continuation);
            this.$res = linkData;
            this.this$0 = superStream;
            this.$callback = function1;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00103(this.$res, this.this$0, this.$callback, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    if (this.$res.getImdbId() != null) {
                        this.label = 1;
                        if (SuperStreamExtractor.INSTANCE.invokeSuperstream(this.this$0.getToken(), this.$res.getImdbId(), this.$res.getSeason(), this.$res.getEpisode(), this.$callback, (Continuation) this) == coroutine_suspended) {
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
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.phisher98.SuperStream$loadLinks$4 */
    /* JADX INFO: compiled from: SuperStream.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.SuperStream$loadLinks$4", f = "SuperStream.kt", i = {}, l = {649}, m = "invokeSuspend", n = {}, nl = {657}, s = {}, v = 2)
    static final class C00114 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ LinkData $res;
        int label;
        final /* synthetic */ SuperStream this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00114(LinkData linkData, SuperStream superStream, Function1<? super ExtractorLink, Unit> function1, Continuation<? super C00114> continuation) {
            super(1, continuation);
            this.$res = linkData;
            this.this$0 = superStream;
            this.$callback = function1;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00114(this.$res, this.this$0, this.$callback, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    if (this.$res.getId() != null) {
                        this.label = 1;
                        if (SuperStreamExtractor.INSTANCE.invokeSuperstreamFeb(this.this$0.getToken(), this.$res.getId(), this.$res.getSeason(), this.$res.getEpisode(), this.$callback, (Continuation) this) == coroutine_suspended) {
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
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: SuperStream.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\bD\b\u0086\b\u0018\u00002\u00020\u0001B\u009f\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010 J\u000b\u00108\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010:\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010>\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010B\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010C\u001a\u00020\u0011HÆ\u0003J\u0010\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010F\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010J\u001a\u00020\u0011HÆ\u0003J\t\u0010K\u001a\u00020\u0011HÆ\u0003J\t\u0010L\u001a\u00020\u0011HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0005HÆ\u0003J¦\u0002\u0010O\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00112\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010PJ\u0014\u0010Q\u001a\u00020\u00112\b\u0010R\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010S\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010T\u001a\u00020\u0005HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b$\u0010 R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010#R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b&\u0010 R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b'\u0010 R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b(\u0010 R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010#R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010#R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010#R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b,\u0010 R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010#R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010.R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b/\u0010 R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b0\u0010 R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u0010#R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b2\u0010#R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u0010#R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b4\u0010#R\u0011\u0010\u0018\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010.R\u0011\u0010\u0019\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010.R\u0011\u0010\u001a\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010.R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u0010#R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b6\u0010#¨\u0006U"}, d2 = {"Lcom/phisher98/SuperStream$LinkData;", "", "id", "", "imdbId", "", "tvdbId", "type", "season", "episode", "epid", "aniId", "animeId", "title", "year", "orgTitle", "isAnime", "", "airedYear", "lastSeason", "epsTitle", "jpTitle", "date", "airedDate", "isAsian", "isBollywood", "isCartoon", "alttitle", "nametitle", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZLjava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getImdbId", "()Ljava/lang/String;", "getTvdbId", "getType", "getSeason", "getEpisode", "getEpid", "getAniId", "getAnimeId", "getTitle", "getYear", "getOrgTitle", "()Z", "getAiredYear", "getLastSeason", "getEpsTitle", "getJpTitle", "getDate", "getAiredDate", "getAlttitle", "getNametitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZLjava/lang/String;Ljava/lang/String;)Lcom/phisher98/SuperStream$LinkData;", "equals", "other", "hashCode", "toString", "SuperStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
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
            this(null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, false, false, false, null, null, 16777215, null);
        }

        public static /* synthetic */ LinkData copy$default(LinkData linkData, Integer num, String str, Integer num2, String str2, Integer num3, Integer num4, Integer num5, String str3, String str4, String str5, Integer num6, String str6, boolean z, Integer num7, Integer num8, String str7, String str8, String str9, String str10, boolean z2, boolean z3, boolean z4, String str11, String str12, int i, Object obj) {
            String str13;
            String str14;
            Integer num9 = (i & 1) != 0 ? linkData.id : num;
            String str15 = (i & 2) != 0 ? linkData.imdbId : str;
            Integer num10 = (i & 4) != 0 ? linkData.tvdbId : num2;
            String str16 = (i & 8) != 0 ? linkData.type : str2;
            Integer num11 = (i & 16) != 0 ? linkData.season : num3;
            Integer num12 = (i & 32) != 0 ? linkData.episode : num4;
            Integer num13 = (i & 64) != 0 ? linkData.epid : num5;
            String str17 = (i & 128) != 0 ? linkData.aniId : str3;
            String str18 = (i & 256) != 0 ? linkData.animeId : str4;
            String str19 = (i & 512) != 0 ? linkData.title : str5;
            Integer num14 = (i & 1024) != 0 ? linkData.year : num6;
            String str20 = (i & 2048) != 0 ? linkData.orgTitle : str6;
            boolean z5 = (i & 4096) != 0 ? linkData.isAnime : z;
            Integer num15 = (i & 8192) != 0 ? linkData.airedYear : num7;
            Integer num16 = num9;
            Integer num17 = (i & 16384) != 0 ? linkData.lastSeason : num8;
            String str21 = (i & 32768) != 0 ? linkData.epsTitle : str7;
            String str22 = (i & 65536) != 0 ? linkData.jpTitle : str8;
            String str23 = (i & 131072) != 0 ? linkData.date : str9;
            String str24 = (i & 262144) != 0 ? linkData.airedDate : str10;
            boolean z6 = (i & 524288) != 0 ? linkData.isAsian : z2;
            boolean z7 = (i & 1048576) != 0 ? linkData.isBollywood : z3;
            boolean z8 = (i & 2097152) != 0 ? linkData.isCartoon : z4;
            String str25 = (i & 4194304) != 0 ? linkData.alttitle : str11;
            if ((i & 8388608) != 0) {
                str14 = str25;
                str13 = linkData.nametitle;
            } else {
                str13 = str12;
                str14 = str25;
            }
            return linkData.copy(num16, str15, num10, str16, num11, num12, num13, str17, str18, str19, num14, str20, z5, num15, num17, str21, str22, str23, str24, z6, z7, z8, str14, str13);
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
        public final LinkData copy(@Nullable Integer id, @Nullable String imdbId, @Nullable Integer tvdbId, @Nullable String type, @Nullable Integer season, @Nullable Integer episode, @Nullable Integer epid, @Nullable String aniId, @Nullable String animeId, @Nullable String title, @Nullable Integer year, @Nullable String orgTitle, boolean isAnime, @Nullable Integer airedYear, @Nullable Integer lastSeason, @Nullable String epsTitle, @Nullable String jpTitle, @Nullable String date, @Nullable String airedDate, boolean isAsian, boolean isBollywood, boolean isCartoon, @Nullable String alttitle, @Nullable String nametitle) {
            return new LinkData(id, imdbId, tvdbId, type, season, episode, epid, aniId, animeId, title, year, orgTitle, isAnime, airedYear, lastSeason, epsTitle, jpTitle, date, airedDate, isAsian, isBollywood, isCartoon, alttitle, nametitle);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LinkData)) {
                return false;
            }
            LinkData linkData = (LinkData) other;
            return Intrinsics.areEqual(this.id, linkData.id) && Intrinsics.areEqual(this.imdbId, linkData.imdbId) && Intrinsics.areEqual(this.tvdbId, linkData.tvdbId) && Intrinsics.areEqual(this.type, linkData.type) && Intrinsics.areEqual(this.season, linkData.season) && Intrinsics.areEqual(this.episode, linkData.episode) && Intrinsics.areEqual(this.epid, linkData.epid) && Intrinsics.areEqual(this.aniId, linkData.aniId) && Intrinsics.areEqual(this.animeId, linkData.animeId) && Intrinsics.areEqual(this.title, linkData.title) && Intrinsics.areEqual(this.year, linkData.year) && Intrinsics.areEqual(this.orgTitle, linkData.orgTitle) && this.isAnime == linkData.isAnime && Intrinsics.areEqual(this.airedYear, linkData.airedYear) && Intrinsics.areEqual(this.lastSeason, linkData.lastSeason) && Intrinsics.areEqual(this.epsTitle, linkData.epsTitle) && Intrinsics.areEqual(this.jpTitle, linkData.jpTitle) && Intrinsics.areEqual(this.date, linkData.date) && Intrinsics.areEqual(this.airedDate, linkData.airedDate) && this.isAsian == linkData.isAsian && this.isBollywood == linkData.isBollywood && this.isCartoon == linkData.isCartoon && Intrinsics.areEqual(this.alttitle, linkData.alttitle) && Intrinsics.areEqual(this.nametitle, linkData.nametitle);
        }

        public int hashCode() {
            return ((((((((((((((((((((((((((((((((((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.imdbId == null ? 0 : this.imdbId.hashCode())) * 31) + (this.tvdbId == null ? 0 : this.tvdbId.hashCode())) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.season == null ? 0 : this.season.hashCode())) * 31) + (this.episode == null ? 0 : this.episode.hashCode())) * 31) + (this.epid == null ? 0 : this.epid.hashCode())) * 31) + (this.aniId == null ? 0 : this.aniId.hashCode())) * 31) + (this.animeId == null ? 0 : this.animeId.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.year == null ? 0 : this.year.hashCode())) * 31) + (this.orgTitle == null ? 0 : this.orgTitle.hashCode())) * 31) + SuperStream$LinkData$$ExternalSyntheticBackport0.m7m(this.isAnime)) * 31) + (this.airedYear == null ? 0 : this.airedYear.hashCode())) * 31) + (this.lastSeason == null ? 0 : this.lastSeason.hashCode())) * 31) + (this.epsTitle == null ? 0 : this.epsTitle.hashCode())) * 31) + (this.jpTitle == null ? 0 : this.jpTitle.hashCode())) * 31) + (this.date == null ? 0 : this.date.hashCode())) * 31) + (this.airedDate == null ? 0 : this.airedDate.hashCode())) * 31) + SuperStream$LinkData$$ExternalSyntheticBackport0.m7m(this.isAsian)) * 31) + SuperStream$LinkData$$ExternalSyntheticBackport0.m7m(this.isBollywood)) * 31) + SuperStream$LinkData$$ExternalSyntheticBackport0.m7m(this.isCartoon)) * 31) + (this.alttitle == null ? 0 : this.alttitle.hashCode())) * 31) + (this.nametitle != null ? this.nametitle.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("LinkData(id=").append(this.id).append(", imdbId=").append(this.imdbId).append(", tvdbId=").append(this.tvdbId).append(", type=").append(this.type).append(", season=").append(this.season).append(", episode=").append(this.episode).append(", epid=").append(this.epid).append(", aniId=").append(this.aniId).append(", animeId=").append(this.animeId).append(", title=").append(this.title).append(", year=").append(this.year).append(", orgTitle=");
            sb.append(this.orgTitle).append(", isAnime=").append(this.isAnime).append(", airedYear=").append(this.airedYear).append(", lastSeason=").append(this.lastSeason).append(", epsTitle=").append(this.epsTitle).append(", jpTitle=").append(this.jpTitle).append(", date=").append(this.date).append(", airedDate=").append(this.airedDate).append(", isAsian=").append(this.isAsian).append(", isBollywood=").append(this.isBollywood).append(", isCartoon=").append(this.isCartoon).append(", alttitle=").append(this.alttitle);
            sb.append(", nametitle=").append(this.nametitle).append(')');
            return sb.toString();
        }

        public LinkData(@Nullable Integer id, @Nullable String imdbId, @Nullable Integer tvdbId, @Nullable String type, @Nullable Integer season, @Nullable Integer episode, @Nullable Integer epid, @Nullable String aniId, @Nullable String animeId, @Nullable String title, @Nullable Integer year, @Nullable String orgTitle, boolean isAnime, @Nullable Integer airedYear, @Nullable Integer lastSeason, @Nullable String epsTitle, @Nullable String jpTitle, @Nullable String date, @Nullable String airedDate, boolean isAsian, boolean isBollywood, boolean isCartoon, @Nullable String alttitle, @Nullable String nametitle) {
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
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ LinkData(Integer num, String str, Integer num2, String str2, Integer num3, Integer num4, Integer num5, String str3, String str4, String str5, Integer num6, String str6, boolean z, Integer num7, Integer num8, String str7, String str8, String str9, String str10, boolean z2, boolean z3, boolean z4, String str11, String str12, int i, DefaultConstructorMarker defaultConstructorMarker) {
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
            boolean z5 = (i & 4096) != 0 ? false : z;
            Integer num15 = (i & 8192) != 0 ? null : num7;
            this(num9, str13, num10, str14, num11, num12, num13, str15, str16, str17, num14, str18, z5, num15, (i & 16384) != 0 ? null : num8, (i & 32768) != 0 ? null : str7, (i & 65536) != 0 ? null : str8, (i & 131072) != 0 ? null : str9, (i & 262144) != 0 ? null : str10, (i & 524288) != 0 ? false : z2, (i & 1048576) != 0 ? false : z3, (i & 2097152) != 0 ? false : z4, (i & 4194304) != 0 ? null : str11, (i & 8388608) != 0 ? null : str12);
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
    }

    /* JADX INFO: compiled from: SuperStream.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ>\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0005HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/phisher98/SuperStream$Data;", "", "id", "", "type", "", "aniId", "malId", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getType", "()Ljava/lang/String;", "getAniId", "getMalId", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/phisher98/SuperStream$Data;", "equals", "", "other", "hashCode", "toString", "SuperStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
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

    /* JADX INFO: compiled from: SuperStream.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J5\u0010\r\u001a\u00020\u00002*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R%\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/phisher98/SuperStream$Results;", "", "results", "Ljava/util/ArrayList;", "Lcom/phisher98/SuperStream$Media;", "Lkotlin/collections/ArrayList;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Ljava/util/ArrayList;)V", "getResults", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "SuperStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
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

    /* JADX INFO: compiled from: SuperStream.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B½\u0001\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e\u0012\u0018\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0010:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010\u001eJÄ\u0001\u0010'\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n2\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f2\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e2\u0018\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0010:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0011HÆ\u0001¢\u0006\u0002\u0010(J\u0014\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010,\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010-\u001a\u00020\u0007HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001e¨\u0006."}, d2 = {"Lcom/phisher98/SuperStream$Media;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "name", "", "title", "originalTitle", "original_title", "mediaType", "media_type", "posterPath", "poster_path", "voteAverage", "", "vote_average", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "getTitle", "getOriginalTitle", "getMediaType", "getPosterPath", "getVoteAverage", "()Ljava/lang/Double;", "Ljava/lang/Double;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;)Lcom/phisher98/SuperStream$Media;", "equals", "", "other", "hashCode", "toString", "SuperStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
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

        @Nullable
        private final Double voteAverage;

        public Media() {
            this(null, null, null, null, null, null, null, 127, null);
        }

        public static /* synthetic */ Media copy$default(Media media, Integer num, String str, String str2, String str3, String str4, String str5, Double d, int i, Object obj) {
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
            if ((i & 64) != 0) {
                d = media.voteAverage;
            }
            String str6 = str5;
            Double d2 = d;
            String str7 = str4;
            String str8 = str2;
            return media.copy(num, str, str8, str3, str7, str6, d2);
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

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Double getVoteAverage() {
            return this.voteAverage;
        }

        @NotNull
        public final Media copy(@JsonProperty("id") @Nullable Integer id, @JsonProperty("name") @Nullable String name, @JsonProperty("title") @Nullable String title, @JsonProperty("original_title") @Nullable String originalTitle, @JsonProperty("media_type") @Nullable String mediaType, @JsonProperty("poster_path") @Nullable String posterPath, @JsonProperty("vote_average") @Nullable Double voteAverage) {
            return new Media(id, name, title, originalTitle, mediaType, posterPath, voteAverage);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Media)) {
                return false;
            }
            Media media = (Media) other;
            return Intrinsics.areEqual(this.id, media.id) && Intrinsics.areEqual(this.name, media.name) && Intrinsics.areEqual(this.title, media.title) && Intrinsics.areEqual(this.originalTitle, media.originalTitle) && Intrinsics.areEqual(this.mediaType, media.mediaType) && Intrinsics.areEqual(this.posterPath, media.posterPath) && Intrinsics.areEqual(this.voteAverage, media.voteAverage);
        }

        public int hashCode() {
            return ((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.originalTitle == null ? 0 : this.originalTitle.hashCode())) * 31) + (this.mediaType == null ? 0 : this.mediaType.hashCode())) * 31) + (this.posterPath == null ? 0 : this.posterPath.hashCode())) * 31) + (this.voteAverage != null ? this.voteAverage.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Media(id=" + this.id + ", name=" + this.name + ", title=" + this.title + ", originalTitle=" + this.originalTitle + ", mediaType=" + this.mediaType + ", posterPath=" + this.posterPath + ", voteAverage=" + this.voteAverage + ')';
        }

        public Media(@JsonProperty("id") @Nullable Integer id, @JsonProperty("name") @Nullable String name, @JsonProperty("title") @Nullable String title, @JsonProperty("original_title") @Nullable String originalTitle, @JsonProperty("media_type") @Nullable String mediaType, @JsonProperty("poster_path") @Nullable String posterPath, @JsonProperty("vote_average") @Nullable Double voteAverage) {
            this.id = id;
            this.name = name;
            this.title = title;
            this.originalTitle = originalTitle;
            this.mediaType = mediaType;
            this.posterPath = posterPath;
            this.voteAverage = voteAverage;
        }

        public /* synthetic */ Media(Integer num, String str, String str2, String str3, String str4, String str5, Double d, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : d);
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

        @Nullable
        public final Double getVoteAverage() {
            return this.voteAverage;
        }
    }

    /* JADX INFO: compiled from: SuperStream.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0007HÆ\u0003JB\u0010\u0011\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0007HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/phisher98/SuperStream$Genres;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "name", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/phisher98/SuperStream$Genres;", "equals", "", "other", "hashCode", "toString", "SuperStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
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

    /* JADX INFO: compiled from: SuperStream.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0007HÆ\u0003JB\u0010\u0011\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0007HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/phisher98/SuperStream$Keywords;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "name", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/phisher98/SuperStream$Keywords;", "equals", "", "other", "hashCode", "toString", "SuperStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
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

    /* JADX INFO: compiled from: SuperStream.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002\u0012*\b\u0003\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J\u001d\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003Ja\u0010\u0010\u001a\u00020\u00002*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u00022*\b\u0003\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bHÆ\u0001J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004R%\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR%\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/phisher98/SuperStream$KeywordResults;", "", "results", "Ljava/util/ArrayList;", "Lcom/phisher98/SuperStream$Keywords;", "Lkotlin/collections/ArrayList;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "keywords", "<init>", "(Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getResults", "()Ljava/util/ArrayList;", "getKeywords", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "SuperStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
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

    /* JADX INFO: compiled from: SuperStream.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t\u0012\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003Jv\u0010\u0019\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t2\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000bHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0014\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001f\u001a\u00020\u0007HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0013\u0010\u000fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012¨\u0006 "}, d2 = {"Lcom/phisher98/SuperStream$Seasons;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "name", "", "seasonNumber", "season_number", "airDate", "air_date", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "getSeasonNumber", "getAirDate", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/phisher98/SuperStream$Seasons;", "equals", "", "other", "hashCode", "toString", "SuperStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
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

    /* JADX INFO: compiled from: SuperStream.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B£\u0001\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t\u0012\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003Jª\u0001\u0010 \u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t2\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n2\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f2\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000eHÆ\u0001¢\u0006\u0002\u0010!J\u0014\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010%\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010&\u001a\u00020\u0007HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015¨\u0006'"}, d2 = {"Lcom/phisher98/SuperStream$Cast;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "name", "", "originalName", "original_name", "character", "knownForDepartment", "known_for_department", "profilePath", "profile_path", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "getOriginalName", "getCharacter", "getKnownForDepartment", "getProfilePath", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/phisher98/SuperStream$Cast;", "equals", "", "other", "hashCode", "toString", "SuperStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
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

    /* JADX INFO: compiled from: SuperStream.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B×\u0001\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u000e:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f\u0012\u0018\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0011\u0012\u0018\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010$\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017JÞ\u0001\u0010+\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n2\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f2\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u000e:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f2\u0018\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00112\u0018\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0013HÆ\u0001¢\u0006\u0002\u0010,J\u0014\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00100\u001a\u00020\u0003HÖ\u0081\u0004J\n\u00101\u001a\u00020\u0007HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b!\u0010\u0017R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\"\u0010\u0017¨\u00062"}, d2 = {"Lcom/phisher98/SuperStream$Episodes;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "name", "", "overview", "airDate", "air_date", "stillPath", "still_path", "voteAverage", "", "vote_average", "episodeNumber", "episode_number", "seasonNumber", "season_number", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "getOverview", "getAirDate", "getStillPath", "getVoteAverage", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getEpisodeNumber", "getSeasonNumber", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/phisher98/SuperStream$Episodes;", "equals", "", "other", "hashCode", "toString", "SuperStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
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

    /* JADX INFO: compiled from: SuperStream.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J5\u0010\r\u001a\u00020\u00002*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R%\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/phisher98/SuperStream$MediaDetailEpisodes;", "", "episodes", "Ljava/util/ArrayList;", "Lcom/phisher98/SuperStream$Episodes;", "Lkotlin/collections/ArrayList;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Ljava/util/ArrayList;)V", "getEpisodes", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "SuperStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
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

    /* JADX INFO: compiled from: SuperStream.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J=\u0010\u000e\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/phisher98/SuperStream$Trailers;", "", "key", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getType", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "SuperStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Trailers {

        @Nullable
        private final String key;

        @Nullable
        private final String type;

        /* JADX WARN: Illegal instructions before constructor call */
        public Trailers() {
            String str = null;
            this(str, str, 3, str);
        }

        public static /* synthetic */ Trailers copy$default(Trailers trailers, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = trailers.key;
            }
            if ((i & 2) != 0) {
                str2 = trailers.type;
            }
            return trailers.copy(str, str2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getKey() {
            return this.key;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @NotNull
        public final Trailers copy(@JsonProperty("key") @Nullable String key, @JsonProperty("type") @Nullable String type) {
            return new Trailers(key, type);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Trailers)) {
                return false;
            }
            Trailers trailers = (Trailers) other;
            return Intrinsics.areEqual(this.key, trailers.key) && Intrinsics.areEqual(this.type, trailers.type);
        }

        public int hashCode() {
            return ((this.key == null ? 0 : this.key.hashCode()) * 31) + (this.type != null ? this.type.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Trailers(key=" + this.key + ", type=" + this.type + ')';
        }

        public Trailers(@JsonProperty("key") @Nullable String key, @JsonProperty("type") @Nullable String type) {
            this.key = key;
            this.type = type;
        }

        public /* synthetic */ Trailers(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }

        @Nullable
        public final String getKey() {
            return this.key;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }
    }

    /* JADX INFO: compiled from: SuperStream.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J5\u0010\r\u001a\u00020\u00002*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R%\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/phisher98/SuperStream$ResultsTrailer;", "", "results", "Ljava/util/ArrayList;", "Lcom/phisher98/SuperStream$Trailers;", "Lkotlin/collections/ArrayList;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Ljava/util/ArrayList;)V", "getResults", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "SuperStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
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

    /* JADX INFO: compiled from: SuperStream.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003JW\u0010\u0011\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/phisher98/SuperStream$AltTitles;", "", "iso_3166_1", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "title", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getIso_3166_1", "()Ljava/lang/String;", "getTitle", "getType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "SuperStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
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
        public final AltTitles copy(@JsonProperty("iso_3166_1") @Nullable String iso_3166_1, @JsonProperty("title") @Nullable String title, @JsonProperty("type") @Nullable String type) {
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

        public AltTitles(@JsonProperty("iso_3166_1") @Nullable String iso_3166_1, @JsonProperty("title") @Nullable String title, @JsonProperty("type") @Nullable String type) {
            this.iso_3166_1 = iso_3166_1;
            this.title = title;
            this.type = type;
        }

        public /* synthetic */ AltTitles(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
        }

        @Nullable
        public final String getIso_3166_1() {
            return this.iso_3166_1;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }
    }

    /* JADX INFO: compiled from: SuperStream.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J5\u0010\r\u001a\u00020\u00002*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R%\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/phisher98/SuperStream$ResultsAltTitles;", "", "results", "Ljava/util/ArrayList;", "Lcom/phisher98/SuperStream$AltTitles;", "Lkotlin/collections/ArrayList;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Ljava/util/ArrayList;)V", "getResults", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "SuperStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
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
        public final ResultsAltTitles copy(@JsonProperty("results") @Nullable ArrayList<AltTitles> results) {
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

        public ResultsAltTitles(@JsonProperty("results") @Nullable ArrayList<AltTitles> arrayList) {
            this.results = arrayList;
        }

        public /* synthetic */ ResultsAltTitles(ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new ArrayList() : arrayList);
        }

        @Nullable
        public final ArrayList<AltTitles> getResults() {
            return this.results;
        }
    }

    /* JADX INFO: compiled from: SuperStream.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\rJB\u0010\u0011\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0007HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/phisher98/SuperStream$ExternalIds;", "", "imdb_id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "tvdb_id", "", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getImdb_id", "()Ljava/lang/String;", "getTvdb_id", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/phisher98/SuperStream$ExternalIds;", "equals", "", "other", "hashCode", "toString", "SuperStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
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
        public final ExternalIds copy(@JsonProperty("imdb_id") @Nullable String imdb_id, @JsonProperty("tvdb_id") @Nullable Integer tvdb_id) {
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

        public ExternalIds(@JsonProperty("imdb_id") @Nullable String imdb_id, @JsonProperty("tvdb_id") @Nullable Integer tvdb_id) {
            this.imdb_id = imdb_id;
            this.tvdb_id = tvdb_id;
        }

        public /* synthetic */ ExternalIds(String str, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num);
        }

        @Nullable
        public final String getImdb_id() {
            return this.imdb_id;
        }

        @Nullable
        public final Integer getTvdb_id() {
            return this.tvdb_id;
        }
    }

    /* JADX INFO: compiled from: SuperStream.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J5\u0010\r\u001a\u00020\u00002*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R%\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/phisher98/SuperStream$Credits;", "", "cast", "Ljava/util/ArrayList;", "Lcom/phisher98/SuperStream$Cast;", "Lkotlin/collections/ArrayList;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Ljava/util/ArrayList;)V", "getCast", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "SuperStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
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

    /* JADX INFO: compiled from: SuperStream.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J5\u0010\r\u001a\u00020\u00002*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R%\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/phisher98/SuperStream$ResultsRecommendations;", "", "results", "Ljava/util/ArrayList;", "Lcom/phisher98/SuperStream$Media;", "Lkotlin/collections/ArrayList;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Ljava/util/ArrayList;)V", "getResults", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "SuperStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
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

    /* JADX INFO: compiled from: SuperStream.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJB\u0010\u000f\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/phisher98/SuperStream$LastEpisodeToAir;", "", "episode_number", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "season_number", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getEpisode_number", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSeason_number", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/phisher98/SuperStream$LastEpisodeToAir;", "equals", "", "other", "hashCode", "toString", "", "SuperStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
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

    /* JADX INFO: compiled from: SuperStream.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J#\u0010\u000b\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002HÆ\u0001J\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/phisher98/SuperStream$ProductionCountries;", "", "name", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "<init>", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "SuperStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
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
        public final ProductionCountries copy(@JsonProperty("name") @Nullable String name) {
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

        public ProductionCountries(@JsonProperty("name") @Nullable String name) {
            this.name = name;
        }

        public /* synthetic */ ProductionCountries(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str);
        }

        @Nullable
        public final String getName() {
            return this.name;
        }
    }

    /* JADX INFO: compiled from: SuperStream.kt */
    @Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bC\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BÇ\u0005\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t\u0012\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e\u0012\u0018\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u0012\u0018\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0012\u0012\u0018\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0014\u0012\u0018\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0016\u0012\u0018\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0017\u0012\u0018\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0018\u0012\u0018\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\u0001:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0019\u0012\u0018\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001a\u0012\u0018\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001b\u0012*\b\u0003\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dj\n\u0012\u0004\u0012\u00020\u001e\u0018\u0001`\u001f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001c\u0012\u0018\b\u0003\u0010 \u001a\u0004\u0018\u00010!:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b( \u0012\u0018\b\u0003\u0010\"\u001a\u0004\u0018\u00010#:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\"\u0012*\b\u0003\u0010$\u001a\u0016\u0012\u0004\u0012\u00020%\u0018\u00010\u001dj\n\u0012\u0004\u0012\u00020%\u0018\u0001`\u001f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b($\u0012\u0018\b\u0003\u0010&\u001a\u0004\u0018\u00010':\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(&\u0012\u0018\b\u0003\u0010(\u001a\u0004\u0018\u00010):\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b((\u0012\u0018\b\u0003\u0010*\u001a\u0004\u0018\u00010+:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(*\u0012\u0018\b\u0003\u0010,\u001a\u0004\u0018\u00010-:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(,\u0012\u0018\b\u0003\u0010.\u001a\u0004\u0018\u00010/:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(.\u0012*\b\u0003\u00100\u001a\u0016\u0012\u0004\u0012\u000201\u0018\u00010\u001dj\n\u0012\u0004\u0012\u000201\u0018\u0001`\u001f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(0¢\u0006\u0004\b2\u00103J\u0010\u0010Y\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00105J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00105J\u000b\u0010e\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u001d\u0010h\u001a\u0016\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dj\n\u0012\u0004\u0012\u00020\u001e\u0018\u0001`\u001fHÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010!HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010#HÆ\u0003J\u001d\u0010k\u001a\u0016\u0012\u0004\u0012\u00020%\u0018\u00010\u001dj\n\u0012\u0004\u0012\u00020%\u0018\u0001`\u001fHÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010'HÆ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010)HÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010+HÆ\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010-HÆ\u0003J\u000b\u0010p\u001a\u0004\u0018\u00010/HÆ\u0003J\u001d\u0010q\u001a\u0016\u0012\u0004\u0012\u000201\u0018\u00010\u001dj\n\u0012\u0004\u0012\u000201\u0018\u0001`\u001fHÆ\u0003JÎ\u0005\u0010r\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t2\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n2\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f2\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e2\u0018\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00102\u0018\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00122\u0018\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00142\u0018\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00162\u0018\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00172\u0018\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00182\u0018\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\u0001:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00192\u0018\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001a2\u0018\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001b2*\b\u0003\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dj\n\u0012\u0004\u0012\u00020\u001e\u0018\u0001`\u001f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001c2\u0018\b\u0003\u0010 \u001a\u0004\u0018\u00010!:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b( 2\u0018\b\u0003\u0010\"\u001a\u0004\u0018\u00010#:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\"2*\b\u0003\u0010$\u001a\u0016\u0012\u0004\u0012\u00020%\u0018\u00010\u001dj\n\u0012\u0004\u0012\u00020%\u0018\u0001`\u001f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b($2\u0018\b\u0003\u0010&\u001a\u0004\u0018\u00010':\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(&2\u0018\b\u0003\u0010(\u001a\u0004\u0018\u00010):\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b((2\u0018\b\u0003\u0010*\u001a\u0004\u0018\u00010+:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(*2\u0018\b\u0003\u0010,\u001a\u0004\u0018\u00010-:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(,2\u0018\b\u0003\u0010.\u001a\u0004\u0018\u00010/:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(.2*\b\u0003\u00100\u001a\u0016\u0012\u0004\u0012\u000201\u0018\u00010\u001dj\n\u0012\u0004\u0012\u000201\u0018\u0001`\u001f:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(0HÆ\u0001¢\u0006\u0002\u0010sJ\u0014\u0010t\u001a\u00020u2\b\u0010v\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010w\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010x\u001a\u00020\u0007HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00106\u001a\u0004\b4\u00105R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b9\u00108R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b:\u00108R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b;\u00108R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b<\u00108R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b=\u00108R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b>\u00108R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b?\u00108R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b@\u00108R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bA\u00108R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u00106\u001a\u0004\bB\u00105R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bE\u00108R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bF\u00108R%\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dj\n\u0012\u0004\u0012\u00020\u001e\u0018\u0001`\u001f¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0013\u0010 \u001a\u0004\u0018\u00010!¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u0013\u0010\"\u001a\u0004\u0018\u00010#¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR%\u0010$\u001a\u0016\u0012\u0004\u0012\u00020%\u0018\u00010\u001dj\n\u0012\u0004\u0012\u00020%\u0018\u0001`\u001f¢\u0006\b\n\u0000\u001a\u0004\bM\u0010HR\u0013\u0010&\u001a\u0004\u0018\u00010'¢\u0006\b\n\u0000\u001a\u0004\bN\u0010OR\u0013\u0010(\u001a\u0004\u0018\u00010)¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u0013\u0010*\u001a\u0004\u0018\u00010+¢\u0006\b\n\u0000\u001a\u0004\bR\u0010SR\u0013\u0010,\u001a\u0004\u0018\u00010-¢\u0006\b\n\u0000\u001a\u0004\bT\u0010UR\u0013\u0010.\u001a\u0004\u0018\u00010/¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR%\u00100\u001a\u0016\u0012\u0004\u0012\u000201\u0018\u00010\u001dj\n\u0012\u0004\u0012\u000201\u0018\u0001`\u001f¢\u0006\b\n\u0000\u001a\u0004\bX\u0010H¨\u0006y"}, d2 = {"Lcom/phisher98/SuperStream$MediaDetail;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "imdbId", "", "imdb_id", "title", "name", "originalTitle", "original_title", "originalName", "original_name", "posterPath", "poster_path", "backdropPath", "backdrop_path", "releaseDate", "release_date", "firstAirDate", "first_air_date", "overview", "runtime", "vote_average", "original_language", "status", "genres", "Ljava/util/ArrayList;", "Lcom/phisher98/SuperStream$Genres;", "Lkotlin/collections/ArrayList;", "keywords", "Lcom/phisher98/SuperStream$KeywordResults;", "last_episode_to_air", "Lcom/phisher98/SuperStream$LastEpisodeToAir;", "seasons", "Lcom/phisher98/SuperStream$Seasons;", "videos", "Lcom/phisher98/SuperStream$ResultsTrailer;", "external_ids", "Lcom/phisher98/SuperStream$ExternalIds;", "credits", "Lcom/phisher98/SuperStream$Credits;", "recommendations", "Lcom/phisher98/SuperStream$ResultsRecommendations;", "alternative_titles", "Lcom/phisher98/SuperStream$ResultsAltTitles;", "production_countries", "Lcom/phisher98/SuperStream$ProductionCountries;", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Lcom/phisher98/SuperStream$KeywordResults;Lcom/phisher98/SuperStream$LastEpisodeToAir;Ljava/util/ArrayList;Lcom/phisher98/SuperStream$ResultsTrailer;Lcom/phisher98/SuperStream$ExternalIds;Lcom/phisher98/SuperStream$Credits;Lcom/phisher98/SuperStream$ResultsRecommendations;Lcom/phisher98/SuperStream$ResultsAltTitles;Ljava/util/ArrayList;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getImdbId", "()Ljava/lang/String;", "getTitle", "getName", "getOriginalTitle", "getOriginalName", "getPosterPath", "getBackdropPath", "getReleaseDate", "getFirstAirDate", "getOverview", "getRuntime", "getVote_average", "()Ljava/lang/Object;", "getOriginal_language", "getStatus", "getGenres", "()Ljava/util/ArrayList;", "getKeywords", "()Lcom/phisher98/SuperStream$KeywordResults;", "getLast_episode_to_air", "()Lcom/phisher98/SuperStream$LastEpisodeToAir;", "getSeasons", "getVideos", "()Lcom/phisher98/SuperStream$ResultsTrailer;", "getExternal_ids", "()Lcom/phisher98/SuperStream$ExternalIds;", "getCredits", "()Lcom/phisher98/SuperStream$Credits;", "getRecommendations", "()Lcom/phisher98/SuperStream$ResultsRecommendations;", "getAlternative_titles", "()Lcom/phisher98/SuperStream$ResultsAltTitles;", "getProduction_countries", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Lcom/phisher98/SuperStream$KeywordResults;Lcom/phisher98/SuperStream$LastEpisodeToAir;Ljava/util/ArrayList;Lcom/phisher98/SuperStream$ResultsTrailer;Lcom/phisher98/SuperStream$ExternalIds;Lcom/phisher98/SuperStream$Credits;Lcom/phisher98/SuperStream$ResultsRecommendations;Lcom/phisher98/SuperStream$ResultsAltTitles;Ljava/util/ArrayList;)Lcom/phisher98/SuperStream$MediaDetail;", "equals", "", "other", "hashCode", "toString", "SuperStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
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
        public final MediaDetail copy(@JsonProperty("id") @Nullable Integer id, @JsonProperty("imdb_id") @Nullable String imdbId, @JsonProperty("title") @Nullable String title, @JsonProperty("name") @Nullable String name, @JsonProperty("original_title") @Nullable String originalTitle, @JsonProperty("original_name") @Nullable String originalName, @JsonProperty("poster_path") @Nullable String posterPath, @JsonProperty("backdrop_path") @Nullable String backdropPath, @JsonProperty("release_date") @Nullable String releaseDate, @JsonProperty("first_air_date") @Nullable String firstAirDate, @JsonProperty("overview") @Nullable String overview, @JsonProperty("runtime") @Nullable Integer runtime, @JsonProperty("vote_average") @Nullable Object vote_average, @JsonProperty("original_language") @Nullable String original_language, @JsonProperty("status") @Nullable String status, @JsonProperty("genres") @Nullable ArrayList<Genres> genres, @JsonProperty("keywords") @Nullable KeywordResults keywords, @JsonProperty("last_episode_to_air") @Nullable LastEpisodeToAir last_episode_to_air, @JsonProperty("seasons") @Nullable ArrayList<Seasons> seasons, @JsonProperty("videos") @Nullable ResultsTrailer videos, @JsonProperty("external_ids") @Nullable ExternalIds external_ids, @JsonProperty("credits") @Nullable Credits credits, @JsonProperty("recommendations") @Nullable ResultsRecommendations recommendations, @JsonProperty("alternative_titles") @Nullable ResultsAltTitles alternative_titles, @JsonProperty("production_countries") @Nullable ArrayList<ProductionCountries> production_countries) {
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

        public MediaDetail(@JsonProperty("id") @Nullable Integer id, @JsonProperty("imdb_id") @Nullable String imdbId, @JsonProperty("title") @Nullable String title, @JsonProperty("name") @Nullable String name, @JsonProperty("original_title") @Nullable String originalTitle, @JsonProperty("original_name") @Nullable String originalName, @JsonProperty("poster_path") @Nullable String posterPath, @JsonProperty("backdrop_path") @Nullable String backdropPath, @JsonProperty("release_date") @Nullable String releaseDate, @JsonProperty("first_air_date") @Nullable String firstAirDate, @JsonProperty("overview") @Nullable String overview, @JsonProperty("runtime") @Nullable Integer runtime, @JsonProperty("vote_average") @Nullable Object vote_average, @JsonProperty("original_language") @Nullable String original_language, @JsonProperty("status") @Nullable String status, @JsonProperty("genres") @Nullable ArrayList<Genres> arrayList, @JsonProperty("keywords") @Nullable KeywordResults keywords, @JsonProperty("last_episode_to_air") @Nullable LastEpisodeToAir last_episode_to_air, @JsonProperty("seasons") @Nullable ArrayList<Seasons> arrayList2, @JsonProperty("videos") @Nullable ResultsTrailer videos, @JsonProperty("external_ids") @Nullable ExternalIds external_ids, @JsonProperty("credits") @Nullable Credits credits, @JsonProperty("recommendations") @Nullable ResultsRecommendations recommendations, @JsonProperty("alternative_titles") @Nullable ResultsAltTitles alternative_titles, @JsonProperty("production_countries") @Nullable ArrayList<ProductionCountries> arrayList3) {
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

        @Nullable
        public final ResultsAltTitles getAlternative_titles() {
            return this.alternative_titles;
        }

        @Nullable
        public final ArrayList<ProductionCountries> getProduction_countries() {
            return this.production_countries;
        }
    }

    private final TmdbDate getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Calendar calender = Calendar.getInstance();
        String today = formatter.format(calender.getTime());
        calender.add(3, 1);
        String nextWeek = formatter.format(calender.getTime());
        return new TmdbDate(today, nextWeek);
    }

    /* JADX INFO: compiled from: SuperStream.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/phisher98/SuperStream$TmdbDate;", "", "today", "", "nextWeek", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getToday", "()Ljava/lang/String;", "getNextWeek", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "SuperStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class TmdbDate {

        @NotNull
        private final String nextWeek;

        @NotNull
        private final String today;

        public static /* synthetic */ TmdbDate copy$default(TmdbDate tmdbDate, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = tmdbDate.today;
            }
            if ((i & 2) != 0) {
                str2 = tmdbDate.nextWeek;
            }
            return tmdbDate.copy(str, str2);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getToday() {
            return this.today;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getNextWeek() {
            return this.nextWeek;
        }

        @NotNull
        public final TmdbDate copy(@NotNull String today, @NotNull String nextWeek) {
            return new TmdbDate(today, nextWeek);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TmdbDate)) {
                return false;
            }
            TmdbDate tmdbDate = (TmdbDate) other;
            return Intrinsics.areEqual(this.today, tmdbDate.today) && Intrinsics.areEqual(this.nextWeek, tmdbDate.nextWeek);
        }

        public int hashCode() {
            return (this.today.hashCode() * 31) + this.nextWeek.hashCode();
        }

        @NotNull
        public String toString() {
            return "TmdbDate(today=" + this.today + ", nextWeek=" + this.nextWeek + ')';
        }

        public TmdbDate(@NotNull String today, @NotNull String nextWeek) {
            this.today = today;
            this.nextWeek = nextWeek;
        }

        @NotNull
        public final String getToday() {
            return this.today;
        }

        @NotNull
        public final String getNextWeek() {
            return this.nextWeek;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isUpcoming(String dateString) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            if (dateString != null) {
                Date date = format.parse(dateString);
                Long lValueOf = date != null ? Long.valueOf(date.getTime()) : null;
                if (lValueOf != null) {
                    long dateTime = lValueOf.longValue();
                    return APIHolder.INSTANCE.getUnixTimeMS() < dateTime;
                }
            }
            return false;
        } catch (Throwable t) {
            ArchComponentExtKt.logError(t);
            return false;
        }
    }
}
